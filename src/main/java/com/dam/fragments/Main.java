package com.dam.fragments;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage stage) throws Exception{
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("fondo.fxml"));
        Scene scene           = new Scene(fxmlLoader.load());

        scene.getStylesheets().clear();
        stage.setTitle("Selector de Campeones");
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
