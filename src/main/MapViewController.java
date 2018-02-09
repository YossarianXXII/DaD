package main;


import de.jensd.fx.glyphs.emojione.utils.EmojiOneFactory;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIcon;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIconView;
import de.jensd.fx.glyphs.fontawesome.utils.FontAwesomeIconFactory;
import map.MapItemFactory;
import java.awt.Dimension;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.MenuItem;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.ScrollEvent;
import javafx.scene.layout.Pane;

public class MapViewController {

    static final Dimension TextureSize = new Dimension(64, 64);

    @FXML
    public void initialize(){
        GlobalState.selectedTool = itemRadio.getSelectedToggle();




//        newItemRadio.getStyleClass().remove("radio-button");
//        moveItemRadio.getStyleClass().remove("radio-button");
//        deleteItemRadio.getStyleClass().remove("radio-button");
//        selectItemRadio.getStyleClass().remove("radio-button");

        newItemRadio.getStyleClass().setAll("font-awesome-radio");
        moveItemRadio.getStyleClass().setAll("font-awesome-radio");
        deleteItemRadio.getStyleClass().setAll("font-awesome-radio");
        selectItemRadio.getStyleClass().setAll("font-awesome-radio");

        FontAwesomeIconView newIcon = new FontAwesomeIconView(FontAwesomeIcon.STAR);

        newIcon.getStyleClass().setAll("new-glyph-icon");

        newItemRadio.setGraphic(newIcon);
        moveItemRadio.setGraphic(new FontAwesomeIconView(FontAwesomeIcon.MAGNET));
        deleteItemRadio.setGraphic(new FontAwesomeIconView(FontAwesomeIcon.ERASER));
        selectItemRadio.setGraphic(new FontAwesomeIconView(FontAwesomeIcon.CROSSHAIRS));

    }
    
    
    @FXML
    void onAction(ActionEvent event) {

    }

    @FXML
    void onMousePressed(MouseEvent event) {
        System.out.println(GlobalState.selectedTool);    
       if( GlobalState.selectedTool.equals(newItemRadio) ){
           MapItemFactory.getNew(event.getX(), event.getY(), mainPane);
           
       }
       if(moveItemRadio.isSelected()){
           // select Item and move it
       }
       if(deleteItemRadio.isSelected()){
           // delete Item under cursor
       }
       
        
    }

    @FXML
    void onMouseReleased(MouseEvent event) {

    }
    
    @FXML
    void onRadioButton(ActionEvent event){
//        System.out.println("Event");
//        System.out.println(  ((RadioButton)(event.getSource())).getId() );
            System.out.println(itemRadio.getSelectedToggle().toString());    
            GlobalState.selectedTool = itemRadio.getSelectedToggle();
//        System.out.println(selectedToggle.getId());
//        RadioButton name = (RadioButton)event.getSource();
//        System.out.println(name.getId());
        
    }

    @FXML
    void onScroll(ScrollEvent event) {

    }
    
    @FXML private MenuItem saveButton;
    @FXML private MenuItem closeButton;
    @FXML private MenuItem aboutButton;
    @FXML private Pane mainPane;
    @FXML private RadioButton newItemRadio;
    @FXML private RadioButton moveItemRadio;
    @FXML private RadioButton deleteItemRadio;
    @FXML private ToggleButton selectItemRadio;
    @FXML private ToggleGroup itemRadio;

}
