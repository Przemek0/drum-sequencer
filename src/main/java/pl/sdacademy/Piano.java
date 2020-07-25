package pl.sdacademy;


import javafx.scene.control.ChoiceBox;

public class Piano extends NoteControls <ChoiceBox<Integer>> {

    public Piano() {
        super();
    }

    @Override
    protected void initialization() {
        for (int i = 0; i < 32; i++) {
            noteControls.put(i, new ChoiceBox<>());
        }

        noteControls.forEach((key, value) -> {
            value.getItems().add(null);
            for (int i = 0; i <= 120; i+=10) {
                value.getItems().add(i);
            }
        });
    }

    @Override
    protected void addAction(NoteSequence noteSequence) {
        noteControls.forEach((key, value) -> {
            if (value.getValue() != null) {
                noteSequence.setPianoNoteAt(key, (int) value.getValue());
            } else {
                noteSequence.setPianoNoteAt(key, -1);
            }
        });
    }

//    @Override
//    protected void putControlsToGridPane(GridPane gridPane, int row) {
//        noteControls.forEach((key, value) -> gridPane.add(value, key + 1, row));
//    }
}
