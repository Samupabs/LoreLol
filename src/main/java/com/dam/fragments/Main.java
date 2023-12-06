package com.dam.fragments;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    public static final String CURRENCY = "$";

    @Override
    public void start(Stage stage) throws Exception{
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("market.fxml"));
        Scene scene           = new Scene(fxmlLoader.load());

        scene.getStylesheets().clear();
//        scene.getStylesheets().add(getClass().getResource("style.css").toExternalForm());
        stage.setTitle("Fruits Marker");
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
