package pl.sdacademy;

import javafx.scene.control.CheckBox;
import javafx.scene.layout.GridPane;

public class Snare extends NoteControls<CheckBox> {

    public Snare() {
        super("Snare");
    }

    @Override
    protected void initialization() {
        for (int i = 0; i < 32; i++) {
            noteControls.put(i, new CheckBox());
        }
    }

    @Override
    protected void addAction(NoteSequence noteSequence) {
        noteControls.forEach((key, value) -> value.setOnAction(actionEvent -> {
            if (value.isSelected()) {
                noteSequence.setSnareNoteAt(key, true);
            } else {
                noteSequence.setSnareNoteAt(key, false);
            }
        }));
    }

//    @Override
//    protected void putControlsToGridPane(GridPane gridPane, int row) {
//        noteControls.forEach((key, value) -> gridPane.add(value, key+1, row));
//    }
}
