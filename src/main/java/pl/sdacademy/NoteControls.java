package pl.sdacademy;

import javafx.scene.Node;
import javafx.scene.layout.GridPane;

import javax.sound.sampled.Control;
import java.util.HashMap;
import java.util.Map;

public abstract class NoteControls<V extends Node> {
    protected String name;
    protected Map<Integer, V>  noteControls;

    public NoteControls(String name) {
        this.name = name;
        this.noteControls = new HashMap<>();
        initialization();
    }

    public Map<Integer, V> getNoteControls() {
        return noteControls;
    }

    public String getName() {
        return name;
    }

    protected abstract void initialization();

    protected abstract void addAction(NoteSequence noteSequence);

//    protected abstract void putControlsToGridPane(GridPane gridPane, int row);

    protected void putControlsToGridPane(GridPane gridPane, int row) {
        noteControls.forEach((key, value) -> gridPane.add(value, key+1, row));
    }
}
