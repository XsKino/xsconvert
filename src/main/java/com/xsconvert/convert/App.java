package com.xsconvert.convert;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class App extends Application {

    public static Stage primaryStage;


    @Override
    public void start(Stage stage) throws Exception {

        primaryStage = stage;
        stage.setTitle("XSConvert | Convierte Divisas");
        stage.getIcons().add(new Image("file:src/main/resources/img/icon.png"));
        Parent root = FXMLLoader.load(getClass().getResource("home.fxml"));
        Scene scene = new Scene(root, Color.TRANSPARENT);
        stage.initStyle(StageStyle.TRANSPARENT);



        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {

        launch(args);
    }

    public static Stage getPrimaryStage() {
        return primaryStage;
    }

}