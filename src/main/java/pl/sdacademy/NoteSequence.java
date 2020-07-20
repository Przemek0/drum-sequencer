package pl.sdacademy;

public class NoteSequence {
    private boolean[] kickNotes;
    private boolean[] hhNotes;
    private boolean[] snareNotes;
    private int[] pianoNotes;

    public NoteSequence(int sequenceLength) {
        kickNotes = new boolean[sequenceLength];
        hhNotes = new boolean[sequenceLength];
        snareNotes = new boolean[sequenceLength];
        pianoNotes = new int[sequenceLength];
        for (int i = 0; i < sequenceLength; i++) {
            pianoNotes[i] = -1;
        }
    }

    public int getPianoNote(int noteNumber) {
        return pianoNotes[noteNumber];
    }

    public boolean getKickNote(int noteNumber) {
        return kickNotes[noteNumber];
    }

    public boolean getSnareNote(int noteNumber) {
        return snareNotes[noteNumber];
    }

    public boolean getHHNote(int noteNumber) {
        return hhNotes[noteNumber];
    }

    public void setPianoNoteAt(int noteNumber, int value) {
        pianoNotes[noteNumber] = value;
    }

    public void setKickNoteAt(int noteNumber, boolean value) {
        kickNotes[noteNumber] = value;
    }

    public void setHHNoteAt(int noteNumber, boolean value) {
        hhNotes[noteNumber] = value;
    }

    public void setSnareNoteAt(int noteNumber, boolean value) {
        snareNotes[noteNumber] = value;
    }
}
