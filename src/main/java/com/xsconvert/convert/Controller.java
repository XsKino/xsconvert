package com.xsconvert.convert;

import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SplitMenuButton;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import org.w3c.dom.events.MouseEvent;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    private Stage stage;
    private Scene scene;
    private Parent root;

    MenuItem MXN = new MenuItem("MXN");
    MenuItem USD = new MenuItem("USD");
    MenuItem EUR = new MenuItem("EUR");

    private double x = 0, y = 0;

    private Stage getEventStage(Event event) {
        return (Stage) ((Node)event.getSource()).getScene().getWindow();
    }

    @FXML
    private AnchorPane titleBar;

    @FXML
    private ImageView iconImg;

    @FXML
    private Text titleText, toAmount, fromCurrCode, toCurrCode, exhangeRate, fromCurrCodeDisplay, toCurrCodeDisplay;

    @FXML
    private TextField fromAmount;

    @FXML
    private SplitMenuButton fromCurrSelect, toCurrSelect;

    @FXML
    protected void closeStage(ActionEvent event) {
        getEventStage(event).close();
    }

    @FXML
    protected void minimizeStage(ActionEvent event) {
        getEventStage(event).setIconified(true);
    }

    @FXML
    protected void switchScene(String newScene, ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource(newScene));
        stage = getEventStage(event);
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    protected void switchToHome(ActionEvent event) throws IOException {
        switchScene("home.fxml", event);
    }

    protected void toggleSplitMenuButton(Event e) {
        SplitMenuButton select = (SplitMenuButton)e.getSource();
        if(!select.isShowing()) {
            select.show();
        }
    }

    @FXML
    protected void handleFromCurrSelect(ActionEvent e) {
        SplitMenuButton select = (SplitMenuButton)e.getSource();
        toggleSplitMenuButton(e);
        System.out.println("fromCurrSelect clicked!");
    }

    private static double xOffset = 0;
    private static double yOffset = 0;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        titleBar.setOnMousePressed(pressEvent -> {
            titleBar.setOnMouseDragged(dragEvent -> {
                getEventStage(pressEvent).setX(dragEvent.getScreenX() - pressEvent.getSceneX());
                getEventStage(pressEvent).setY(dragEvent.getScreenY() - pressEvent.getSceneY());
            });
        });

        iconImg.setImage(App.getPrimaryStage().getIcons().get(0));
        titleText.setText(App.getPrimaryStage().getTitle());

        fromAmount.setTextFormatter(new DecimalTextFormatter(0, 99));
        fromAmount.setText("");

        fromCurrSelect.getItems().removeAll(fromCurrSelect.getItems());
        fromCurrSelect.getItems().addAll(MXN, USD, EUR);

        for(MenuItem item : fromCurrSelect.getItems()) {
            item.setOnAction(e -> {
                String code = item.getText();
                fromCurrCode.setText(code);
                fromCurrCodeDisplay.setText(code);
                fromCurrSelect.setText(code);
            });
        }

    }
}