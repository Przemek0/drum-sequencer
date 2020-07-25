package pl.sdacademy;

import javafx.scene.control.Control;
import javafx.scene.layout.GridPane;

import java.util.HashMap;
import java.util.Map;

public abstract class NoteControls<V extends Control> {
    protected Map<Integer, V>  noteControls;

    public NoteControls() {
        this.noteControls = new HashMap<>();
        initialization();
    }

    protected abstract void initialization();

    protected abstract void addAction(NoteSequence noteSequence);

//    protected abstract void putControlsToGridPane(GridPane gridPane, int row);

    protected void putControlsToGridPane(GridPane gridPane, int row) {
        noteControls.forEach((key, value) -> gridPane.add(value, key+1, row));
    }
}
