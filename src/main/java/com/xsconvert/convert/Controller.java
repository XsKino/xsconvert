package com.xsconvert.convert;

import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import org.w3c.dom.events.MouseEvent;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.function.Function;

public class Controller implements Initializable {

    private Stage stage;
    private Scene scene;
    private Parent root;

    private double x = 0, y = 0;

    private Stage getEventStage(Event event) {
        return (Stage) ((Node)event.getSource()).getScene().getWindow();
    }

    @FXML
    private AnchorPane titleBar;

    @FXML
    private ImageView iconImg;

    @FXML
    private Text titleText;

    @FXML
    protected void closeStage(ActionEvent event) {
        getEventStage(event).close();
    }

    @FXML
    protected void minimizeStage(ActionEvent event) {
        getEventStage(event).setIconified(true);
    }

    @FXML
    private void switchScene(String newScene, ActionEvent event) throws IOException {
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
    }
}