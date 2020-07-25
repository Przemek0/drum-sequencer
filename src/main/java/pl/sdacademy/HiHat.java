package pl.sdacademy;

import javafx.scene.control.CheckBox;

public class HiHat extends NoteControls <CheckBox> {

    public HiHat() {
        super();
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
                noteSequence.setHHNoteAt(key, true);
            } else {
                noteSequence.setHHNoteAt(key, false);
            }
        }));
    }

//    @Override
//    protected void putControlsToGridPane(GridPane gridPane, int row) {
//        noteControls.forEach((key, value) -> gridPane.add(value, key+1, row));
//    }
}
