package gui;

import de.jensd.fx.glyphs.GlyphIcon;
import de.jensd.fx.glyphs.GlyphIcons;
import javafx.scene.control.RadioButton;

public class AwesomeRadio extends RadioButton {

    public AwesomeRadio(GlyphIcon icon){
        super();
        this.getStyleClass().setAll("font-awesome-radio");
        this.setGraphic(icon);
    }


}
