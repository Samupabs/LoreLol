package com.dam.fragments.controller;

import com.dam.fragments.Main;
import com.dam.fragments.main.MyListener;
import com.dam.fragments.model.Campeon;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.scene.media.MediaView;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class controladorDelFondo implements Initializable {

    @FXML private VBox selectorDeCampeon;
    @FXML private Label nombreCampeon;
    @FXML private Label descripcionCampeon;
    @FXML private ImageView imagenCampeon;
    @FXML private GridPane grid;


    private Image image;
    private int column = 0;
    private int row    = 1;

    /**
     * Genera datos de prueba de campeones y notifica al escuchador sobre cada campeón creado.
     *
     * @param callback Escuchador de eventos personalizados.
     */
    private void generateTestData(MyListener callback) {

        String[] nombresDeCampeones       = {"Veigar"  ,"Vi"     ,"Jinx"  ,"Garen" ,"VelKoz"};
        String[] coloresDeCampeones       = {"4d4dff"  ,"ff1aff" ,"66c2ff","ff9900","8c1aff"};
        String[] descripcionesDeCampeones = {
                "Veigar, el entusiasta hechicero yordle, ha hecho suyos poderes a los que muy pocos se atreven ni siquiera a acercarse. Era un espíritu libre habitante de Ciudad de Bandle que deseaba aprender más sobre la magia celestial que realizaban algunos mortales, pero su reclusión en el Bastión Inmortal llevó su innata curiosidad por otro camino. Ahora, este terco yordle con la furia oscura de las estrellas a su disposición es menospreciado a menudo y, aunque él se ve a sí mismo como una fuerza del mal, hay quien todavía se cuestiona sus motivos ulteriores.",
                "Vi, anteriormente una delincuente en las perversas calles de Zaun, es una mujer impulsiva e imponente con muy poco respeto por las figuras autoritarias. Tras crecer sola, Vi desarrolló y perfeccionó sus instintos de supervivencia, así como un áspero sentido del humor lleno de malicia. Ahora trabaja con los Guardianes para mantener la paz en Piltover y se vale de sus poderosos guanteletes hextech, que pueden golpear a través de las paredes y de los sospechosos con la misma facilidad.",
                "Jinx, una criminal perturbada e impulsiva de Zaun, vive para sembrar el caos sin importarle las consecuencias. Provoca las explosiones más ruidosas y cegadoras con su arsenal de armas letales para dejar un rastro de terror y destrucción a su paso. Jinx aborrece el aburrimiento y disfruta dejando su peculiar impronta allá donde va.",
                "Garen, un orgulloso y noble soldado, lucha a la cabeza de la Vanguardia Impertérrita. Es querido entre sus compañeros y respetado por sus enemigos en su papel de vástago de la prestigiosa familia Crownguard, encargada de defender Demacia y sus ideales. Vestido con una armadura resistente a la magia y con una poderosa espada, Garen está listo para enfrentarse a los magos y hechiceros en el campo de batalla en un verdadero torbellino de acero y virtud.",
                "No está claro si Vel'Koz es el primer ente del Vacío que ha aparecido en Runaterra. Lo que sí es seguro es que no ha existido ningún otro que se le pueda comparar en crueldad e inteligencia calculadora. Mientras que los de su especie devoran y profanan todo cuanto encuentran, él pretende estudiar el reino físico —así como los extraños y belicosos seres que lo habitan—, con el fin de encontrar cualquier debilidad que pueda aprovechar el Vacío."
        };

        for(int i=0;i<nombresDeCampeones.length;i++){

            String champName   = nombresDeCampeones[i];
            String champGIF    = "img/"+champName.toLowerCase()+"Ani.gif";
            String champICON   = "img/"+champName.toLowerCase()+"Icon.png";
            String champDesc   = descripcionesDeCampeones[i];
            String champColor  = coloresDeCampeones[i];
            String champAudio  = "img/"+champName.toLowerCase()+"Sonido.mp3";

            callback.onClickListener(new Campeon(champName, champGIF,champDesc,champColor,champICON,champAudio));
        }
  }


    /**
     * Establece la información del campeón seleccionado en la interfaz de usuario.
     *
     * @param campeon Objeto Campeon que contiene la información del campeón seleccionado.
     */
    private void setCampeonElegido(Campeon campeon) {
        image = new Image(Main.class.getResourceAsStream(campeon.getImgGIF()));
        nombreCampeon.setText(campeon.getName());
        descripcionCampeon.setText(campeon.getDescripcion());
        imagenCampeon.setImage(image);
        selectorDeCampeon.setStyle("-fx-background-color: #" + campeon.getColor());
    }


    /**
     * Inicializa el controlador después de que se carga la interfaz de usuario.
     *
     * @param location  Ubicación utilizada para resolver rutas relativas para el objeto ResourceBundle.
     * @param resources El recurso para localizar el objeto de inicialización, o null si no hay inicialización.
     */
    @Override
    public void initialize(URL location, ResourceBundle resources) {

        generateTestData(campeon -> {

            try {

                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(Main.class.getResource("campeones.fxml"));
                AnchorPane anchorPane         = fxmlLoader.load();
                controladorDeCampeones controladorDeCampeones = fxmlLoader.getController();

                controladorDeCampeones.setData(campeon, data ->{
                    setCampeonElegido(data);
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
