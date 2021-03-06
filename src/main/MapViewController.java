package main;


import de.jensd.fx.glyphs.fontawesome.FontAwesomeIcon;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIconView;
import gui.AwesomeToggle;
import gui.GUIUtil;
import gui.MapObjectPicker;
import gui.MapPane;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.MenuItem;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.ScrollEvent;
import javafx.scene.layout.AnchorPane;
import map.MapItemFactory;

import java.awt.*;

public class MapViewController {

    static final Dimension TextureSize = new Dimension(64, 64);

    @FXML
    public void initialize() {


        mainPane = new MapPane();
        GUIUtil.clipChildren(mainPane);
        workAreaAnchor.getChildren().add(mainPane);
        GUIUtil.anchorAll(mainPane);

        itemRadio = new ToggleGroup();

        newItemRadio = new AwesomeToggle("New Item", new FontAwesomeIconView(FontAwesomeIcon.STAR));
        newItemRadio.setOnAction(this::onRadioButton);

        moveItemRadio = new AwesomeToggle("Move", new FontAwesomeIconView(FontAwesomeIcon.ARROWS_ALT));
        moveItemRadio.setOnAction(this::onRadioButton);

        deleteItemRadio = new AwesomeToggle("Delete", new FontAwesomeIconView(FontAwesomeIcon.ERASER));
        deleteItemRadio.setOnAction(this::onRadioButton);

        selectItemRadio = new AwesomeToggle("Select", new FontAwesomeIconView(FontAwesomeIcon.CROSSHAIRS));
        selectItemRadio.setOnAction(this::onRadioButton);



        newItemRadio.setToggleGroup(itemRadio);

        moveItemRadio.setToggleGroup(itemRadio);
        deleteItemRadio.setToggleGroup(itemRadio);
        selectItemRadio.setToggleGroup(itemRadio);

        itemRadio.getToggles().setAll(
          newItemRadio,
          moveItemRadio,
          deleteItemRadio,
          selectItemRadio
        );

        controlsToolbar.getItems().addAll(
                newItemRadio,
                moveItemRadio,
                deleteItemRadio,
                selectItemRadio
        );
        newItemRadio.setSelected(true);
        GlobalState.selectedTool = itemRadio.getSelectedToggle();
        System.out.println(GlobalState.selectedTool);
        mainPane.setOnMousePressed(this::onMousePressed);

        picker = new MapObjectPicker();
        picker.initialize();

        mainPane.getChildren().add(picker);
    }


    @FXML
    void onAction(ActionEvent event) {

    }


    void onMousePressed(MouseEvent event) {
        if (GlobalState.selectedTool.equals(newItemRadio)) {
            MapItemFactory.getNew(event.getX(), event.getY(), mainPane, picker.getSelected());
        }
    }

    @FXML
    void onMouseReleased(MouseEvent event) {

    }


    private void onRadioButton(ActionEvent event) {
        System.out.println(itemRadio.getSelectedToggle().toString());
        GlobalState.selectedTool = itemRadio.getSelectedToggle();
    }

    @FXML
    void onScroll(ScrollEvent event) {

    }

    private MapPane mainPane;
    private MapObjectPicker picker;

    @FXML
    private MenuItem saveButton;
    @FXML
    private MenuItem closeButton;
    @FXML
    private MenuItem aboutButton;
    private ToggleButton newItemRadio;
    private ToggleButton moveItemRadio;
    private ToggleButton deleteItemRadio;
    private ToggleButton selectItemRadio;

    private ToggleGroup itemRadio;
    @FXML
    private AnchorPane workAreaAnchor;
    @FXML
    private ToolBar controlsToolbar;

}
