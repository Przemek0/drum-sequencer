package pl.sdacademy;

public class MidiPLayerExample {
    public static void main(String[] args) throws InterruptedException {
        MidiPlayer midiPlayer = new MidiPlayer();
        NoteSequence noteSequence = midiPlayer.getNoteSequence();
        noteSequence.setKickNoteAt(0, true);
        noteSequence.setKickNoteAt(12, true);
        noteSequence.setKickNoteAt(20, true);

        noteSequence.setSnareNoteAt(8, true);
        noteSequence.setSnareNoteAt(24, true);

        noteSequence.setHHNoteAt(0, true);
        noteSequence.setHHNoteAt(8, true);
        noteSequence.setHHNoteAt(16, true);
        noteSequence.setHHNoteAt(24, true);

        midiPlayer.start();
        Thread.sleep(5000);
    }
}
