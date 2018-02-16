package gui;

import de.jensd.fx.glyphs.GlyphIcon;
import de.jensd.fx.glyphs.GlyphIcons;
import javafx.scene.control.RadioButton;

import java.awt.event.ActionEvent;
import java.beans.EventHandler;

public class AwesomeRadio extends RadioButton {

    private final String action;

    public AwesomeRadio(String action, GlyphIcon icon){
        super();
//        this.getStyleClass().setAll("font-awesome-radio");
//        this.setGraphic(icon);
        this.action = action;

    }

    @Override
    public String toString() {
        return "AwesomeRadio{" +
                "action='" + action + '\'' +
                '}';
    }
}
