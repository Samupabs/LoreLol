package com.dam.fragments.controller;

import com.dam.fragments.Main;
import com.dam.fragments.main.MyListener;
import com.dam.fragments.model.Fruit;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class MarketController implements Initializable {

    @FXML private VBox chosenFruitCard;
    @FXML private Label fruitNameLable;
    @FXML private Label fruitPriceLabel;
    @FXML private ImageView fruitImg;
    @FXML private GridPane grid;

    private Image image;

    private int column = 0;
    private int row    = 1;

    private void generateTestData(MyListener callback) {

        String[] fruitsName  = {"Veigar"  ,"VelKoz","Vi" ,"Jinx","Garen"};
        String[] fruitsColor = {"6A7324","A7745B" ,"F16C31","291D36","22371D"    };
        double[] fruitsPrice = {2.99    ,3.99     , 1.5    , 0.99   , 4.99       };

        for(int i=0;i<fruitsName.length;i++){

            String fruitName   = fruitsName[i];
            String fruitImgSrc = "img/"+fruitName.toLowerCase()+"Ani.gif";
            double fruitPrice  = fruitsPrice[i];
            String fruitColor  = fruitsColor[i];

            callback.onClickListener(new Fruit(fruitName, fruitImgSrc,fruitPrice,fruitColor));
        }
  }

    private void setChosenFruit(Fruit fruit) {
        image = new Image(Main.class.getResourceAsStream(fruit.getImgSrc()));
        fruitNameLable.setText(fruit.getName());
        fruitPriceLabel.setText(Main.CURRENCY + fruit.getPrice());
        fruitImg.setImage(image);
        chosenFruitCard.setStyle("-fx-background-color: #" + fruit.getColor());
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        generateTestData(fruit -> {

            try {

                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(Main.class.getResource("item.fxml"));
                AnchorPane anchorPane         = fxmlLoader.load();
                ItemController itemController = fxmlLoader.getController();

                itemController.setData(fruit, data ->{
                    setChosenFruit(data);
                });

                if (column == 6) {  column = 0;  row++;  }

                grid.add(anchorPane, column++, row); //(child,column,row)
                //set grid width
                grid.setMinWidth(Region.USE_COMPUTED_SIZE);
                grid.setPrefWidth(Region.USE_COMPUTED_SIZE);
                grid.setMaxWidth(Region.USE_PREF_SIZE);

                //set grid height
                grid.setMinHeight(Region.USE_COMPUTED_SIZE);
                grid.setPrefHeight(Region.USE_COMPUTED_SIZE);
                grid.setMaxHeight(Region.USE_PREF_SIZE);

                GridPane.setMargin(anchorPane, new Insets(10));

            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }
}
