package pl.sdacademy;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollBar;
import javafx.scene.control.Slider;
import javafx.scene.effect.ColorInput;
import javafx.scene.effect.Effect;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;

public class PrimaryController {

    @FXML
    private GridPane controlsGridPane;

    @FXML
    private Button btnPlay;

    @FXML
    private Button btnStop;

    @FXML
    private Slider sliderTempo;

    public void initialize() {
        HiHat hiHat = new HiHat();
        Kick kick = new Kick();
        Snare snare = new Snare();
        Piano piano = new Piano();

        hiHat.putControlsToGridPane(controlsGridPane, 0);
        kick.putControlsToGridPane(controlsGridPane, 1);
        snare.putControlsToGridPane(controlsGridPane, 2);
        piano.putControlsToGridPane(controlsGridPane, 3);

        MidiPlayer midiPlayer = new MidiPlayer();
        NoteSequence noteSequence = midiPlayer.getNoteSequence();
        hiHat.addAction(noteSequence);
        kick.addAction(noteSequence);
        snare.addAction(noteSequence);



        btnPlay.setOnAction(actionEvent -> {
            midiPlayer.setTempo((int) sliderTempo.getValue());
            piano.addAction(noteSequence);
            midiPlayer.start();
        });
        btnStop.setOnAction(actionEvent -> midiPlayer.stop());

        Effect effect = new ColorInput(0,0,20, 20, Color.FORESTGREEN);
        midiPlayer.setOnNotePlayed(onNotePlayed -> {
            piano.addAction(noteSequence);
            int i = onNotePlayed-1;
            if (i < 0) {
                i = 31;
            }
            hiHat.noteControls.get(i).setEffect(null);
            hiHat.noteControls.get(onNotePlayed).setEffect(effect);
            kick.noteControls.get(i).setEffect(null);
            kick.noteControls.get(onNotePlayed).setEffect(effect);
            snare.noteControls.get(i).setEffect(null);
            snare.noteControls.get(onNotePlayed).setEffect(effect);

            if (sliderTempo.isValueChanging()) {
                midiPlayer.setTempo((int) sliderTempo.getValue());
            }

        });

    }
}
