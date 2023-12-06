package com.dam.fragments.controller;

import com.dam.fragments.Main;
import com.dam.fragments.main.MyListener;
import com.dam.fragments.model.Fruit;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

import java.net.URL;
import java.util.ResourceBundle;

public class ItemController implements Initializable {

    @FXML private Label nameLabel;
    @FXML private Label priceLable;
    @FXML private ImageView img;

    @FXML private void click(MouseEvent mouseEvent) {
        myListener.onClickListener(fruit);
    }

    private Fruit fruit;
    private MyListener myListener;

    public void setData(Fruit fruit, MyListener myListener) {

        this.fruit      = fruit;
        this.myListener = myListener;
        Image image     = new Image(Main.class.getResourceAsStream(fruit.getImgSrc()));

        nameLabel.setText(fruit.getName());
        priceLable.setText(Main.CURRENCY + String.format("%.02f", fruit.getPrice()));
        img.setImage(image);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        myListener = (data)->{};
    }
}
