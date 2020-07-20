package pl.sdacademy;

import javax.sound.midi.MidiChannel;
import javax.sound.midi.MidiSystem;
import javax.sound.midi.MidiUnavailableException;
import javax.sound.midi.Synthesizer;
import java.util.function.Consumer;

public class MidiPlayer {
    private final static int SEQUENCE_LENGTH = 32;
    private final static int INITIAL_TEMPO = 120;

    private NoteSequence noteSequence;
    private int tempo;
    private boolean stopped;
    private boolean mute;
    private Synthesizer midiSynth;

    private MidiChannel drumChannel;
    private MidiChannel pianoChannel;

    public MidiPlayer() {
        noteSequence = new NoteSequence(SEQUENCE_LENGTH);
        tempo = INITIAL_TEMPO;
        stopped = true;

        try {
            midiSynth = MidiSystem.getSynthesizer();
            if (!midiSynth.isOpen()) {
                midiSynth.open();
            }
        } catch (MidiUnavailableException e) {
            throw new RuntimeException("Sterownik midi jest niedostępny");
        }
        MidiChannel[] midiChannels = midiSynth.getChannels();
        drumChannel = midiChannels[9];
        pianoChannel = midiChannels[0];
        pianoChannel.programChange(0);
    }

    public void start() {
        if (!stopped) {
            return;
        }
        stopped = false;
        Thread midiPlayerThread = new Thread(() -> {
            while (!stopped) {
                for (int i = 0; i < SEQUENCE_LENGTH; i++) {
                    if (!mute) {
                        playNotes(i);
                    }
                    try {
                        Thread.sleep(7500 / tempo);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        midiPlayerThread.setDaemon(true);
        midiPlayerThread.start();
    }

    private void playNotes(int noteNumber) {
        int pianoNote = noteSequence.getPianoNote(noteNumber);
        if (pianoNote != -1) {
            pianoChannel.allNotesOff();
            pianoChannel.noteOn(pianoNote, 100);
        }
        if (noteSequence.getKickNote(noteNumber)) {
            drumChannel.noteOn(35, 100);
        }
        if (noteSequence.getHHNote(noteNumber)) {
            drumChannel.noteOn(42, 100);
        }
        if (noteSequence.getSnareNote(noteNumber)) {
            drumChannel.noteOn(38, 100);
        }
    }

    public void close() {
        midiSynth.close();
    }

    public NoteSequence getNoteSequence() {
        return noteSequence;
    }

    public int getTempo() {
        return tempo;
    }

    public void setTempo(int tempo) {
        this.tempo = tempo;
    }

    public void stop() {
        this.stopped = true;
    }

    public void setMute(boolean mute) {
        this.mute = mute;
    }
}
