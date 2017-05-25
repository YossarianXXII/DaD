package main;


import map.MapItemFactory;
import java.awt.Dimension;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.MenuItem;
import javafx.scene.control.RadioButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.ScrollEvent;
import javafx.scene.layout.Pane;

public class MapViewController {

    static final Dimension TextureSize = new Dimension(64, 64);

    @FXML
    public void initialize(){
        newItemRadio.setOnAction(e->{
            
        });
    }
    
    
    @FXML
    void onAction(ActionEvent event) {

    }

    @FXML
    void onMousePressed(MouseEvent event) {
       if(newItemRadio.isSelected()){
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
        if(newItemRadio.isSelected()){
            GlobalState.isDeleteItemRadioSelected = false;
            GlobalState.isNewItemRadioSelected = true;
            GlobalState.isMoveItemRadioSelected = false;
        }
        if(moveItemRadio.isSelected()){
            GlobalState.isDeleteItemRadioSelected = false;
            GlobalState.isNewItemRadioSelected = false;
            GlobalState.isMoveItemRadioSelected = true;
        }
        if(deleteItemRadio.isSelected()){
            GlobalState.isDeleteItemRadioSelected = true;
            GlobalState.isNewItemRadioSelected = false;
            GlobalState.isMoveItemRadioSelected = false;
            
        }
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

}
