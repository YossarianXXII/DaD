package main;


import de.jensd.fx.glyphs.fontawesome.FontAwesomeIcon;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIconView;
import gui.AwesomeRadio;
import gui.MapPane;
import gui.GUIUtil;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import map.MapItemFactory;

import java.awt.Dimension;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.ScrollEvent;

public class MapViewController {

    static final Dimension TextureSize = new Dimension(64, 64);

    @FXML
    public void initialize() {


        mainPane = new MapPane();
        GUIUtil.clipChildren(mainPane);
        workAreaAnchor.getChildren().add(mainPane);
        GUIUtil.anchorAll(mainPane);

        itemRadio = new ToggleGroup();

        newItemRadio = new AwesomeRadio("New Item", new FontAwesomeIconView(FontAwesomeIcon.STAR));
        newItemRadio.setOnAction(this::onRadioButton);

        moveItemRadio = new AwesomeRadio("Move", new FontAwesomeIconView(FontAwesomeIcon.ARROWS_ALT));
        moveItemRadio.setOnAction(this::onRadioButton);

        deleteItemRadio = new AwesomeRadio("Delete", new FontAwesomeIconView(FontAwesomeIcon.ERASER));
        deleteItemRadio.setOnAction(this::onRadioButton);

        selectItemRadio = new AwesomeRadio("Select", new FontAwesomeIconView(FontAwesomeIcon.CROSSHAIRS));
        selectItemRadio.setOnAction(this::onRadioButton);



        newItemRadio.setToggleGroup(itemRadio);
        newItemRadio.setSelected(true);
        moveItemRadio.setToggleGroup(itemRadio);
        deleteItemRadio.setToggleGroup(itemRadio);
        selectItemRadio.setToggleGroup(itemRadio);

        itemRadio.getToggles().setAll(
          newItemRadio,
          moveItemRadio,
          deleteItemRadio,
          selectItemRadio
        );


        System.out.println(itemRadio.getToggles().toString());
        itemRadio.getToggles();


        controlsToolbar.getItems().addAll(
                newItemRadio,
                moveItemRadio,
                deleteItemRadio,
                selectItemRadio
        );

        GlobalState.selectedTool = itemRadio.getSelectedToggle();
        System.out.println(GlobalState.selectedTool);
        mainPane.setOnMousePressed(this::onMousePressed);


    }


    @FXML
    void onAction(ActionEvent event) {

    }


    void onMousePressed(MouseEvent event) {
        System.out.println(GlobalState.selectedTool);
        System.out.println(event.getSource());
        if (GlobalState.selectedTool.equals(newItemRadio)) {
            MapItemFactory.getNew(event.getX(), event.getY(), mainPane);

        }
        if (moveItemRadio.isSelected()) {
            // select Item and move it
        }
        if (deleteItemRadio.isSelected()) {
            // delete Item under cursor
        }


    }

    @FXML
    void onMouseReleased(MouseEvent event) {

    }


    void onRadioButton(ActionEvent event) {
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

    private MapPane mainPane;

    @FXML
    private MenuItem saveButton;
    @FXML
    private MenuItem closeButton;
    @FXML
    private MenuItem aboutButton;
    private RadioButton newItemRadio;
    private RadioButton moveItemRadio;
    private RadioButton deleteItemRadio;
    private RadioButton selectItemRadio;

    private ToggleGroup itemRadio;
    @FXML
    private AnchorPane workAreaAnchor;
    @FXML
    private ToolBar controlsToolbar;

}
