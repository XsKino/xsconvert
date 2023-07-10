package com.xsconvert.convert;

import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SplitMenuButton;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.Arrays;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    private Stage stage;
    private Scene scene;
    private Parent root;

    private Stage getEventStage(Event event) {
        return (Stage) ((Node)event.getSource()).getScene().getWindow();
    }


    @FXML
    private AnchorPane titleBar;

    @FXML
    private ImageView iconImg;

    @FXML
    private Text titleText, fromCurrCode, toCurrCode, exhangeRate, fromCurrCodeDisplay, toCurrCodeDisplay;

    @FXML
    private TextField fromAmount, toAmount;

    @FXML
    private SplitMenuButton fromCurrSelect, toCurrSelect;

    @FXML
    private Button convertButton;

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
    protected void handleClickSelect(ActionEvent e) {
        toggleSplitMenuButton(e);
    }

    @FXML
    protected void handleFromAmountChange(Event e) {
        if(((TextField) e.getSource()).getText().length() > 0) {
            convertButton.setDisable(false);
            convertButton.getParent().setStyle("-fx-opacity: 1");
        } else {
            convertButton.setDisable(true);
            convertButton.getParent().setStyle("-fx-opacity: 0");
        }
        changeToAmountStyle(false);
    }

    @FXML
    protected void handleCurrChange(Event e) {
        changeToAmountStyle(false);
        changeRateText(0);
    }

    @FXML
    protected void handleConvert(ActionEvent e) {
        Currency curr1 = new Currency(fromCurrCode.getText());
        curr1.setAmount(Double.parseDouble(fromAmount.getText()));
        Currency curr2 = new Currency(toCurrCode.getText());
        try {
            CurrencyConverter.convert(curr1, curr2);
            changeToAmountStyle(true);
            convertButton.setDisable(true);
            convertButton.getParent().setStyle("-fx-opacity: 0");
            changeRateText(curr2.getRate());
            toAmount.setText(String.valueOf(curr2.getAmount()));

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    private void changeToAmountStyle(Boolean valid) {
        if(valid) {
            toAmount.getParent().setStyle("-fx-background-color: transparent");
        } else {
            toAmount.getParent().setStyle("-fx-background-color: linear-gradient(from 0 0 to 500 300 , rgba(158,16,64,1) 0%, rgba(0,0,0,0) 28%, rgba(0,0,0,0) 46%, rgba(158,16,64,1) 100%)");
        }
    }

    private void changeRateText(double rate) {
//        exhangeRate.setText(String.format("%.6f", rate));
        if(rate > 0) {
            exhangeRate.setText(String.valueOf(rate));
            exhangeRate.setStyle("-fx-fill: #ededed");
        } else {
            exhangeRate.setText("?");
            exhangeRate.setStyle("-fx-fill: #fffa");
        }
    }

    private static double xOffset = 0;
    private static double yOffset = 0;

    private void populateMenuItems() {
        for(Currency currency : Currency.getAvailCurrencies()) {
            String itemText = currency.getCode()+ " | " + currency.getName();
            fromCurrSelect.getItems().add(new MenuItem(itemText));
            toCurrSelect.getItems().add(new MenuItem(itemText));
        }
        fromCurrSelect.setText(new Currency("USD").getName());
        toCurrSelect.setText(new Currency("MXN").getName());
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        changeRateText(0);
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
        toCurrSelect.getItems().removeAll(toCurrSelect.getItems());
        populateMenuItems();

        for(MenuItem item : fromCurrSelect.getItems()) {
            item.setOnAction(e -> {
                String[] splitText = item.getText().split(" ");
                String code = splitText[0];
                String name = String.join(" ", Arrays.copyOfRange(splitText, 2, splitText.length));
                fromCurrCode.setText(code);
                fromCurrCodeDisplay.setText(code);
                fromCurrSelect.setText(name);
                handleCurrChange(e);
            });
        }

        for(MenuItem item : toCurrSelect.getItems()) {
            item.setOnAction(e -> {
                String[] splitText = item.getText().split(" ");
                String code = splitText[0];
                String name = String.join(" ", Arrays.copyOfRange(splitText, 2, splitText.length));
                toCurrCode.setText(code);
                toCurrCodeDisplay.setText(code);
                toCurrSelect.setText(name);
                handleCurrChange(e);
            });
        }
    }
}