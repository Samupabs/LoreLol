package com.dam.fragments.controller;

import com.dam.fragments.Main;
import com.dam.fragments.main.MyListener;
import com.dam.fragments.model.Campeon;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * Controlador para la visualización de información de campeones.
 */
public class controladorDeCampeones implements Initializable {

    @FXML private Label nombreCampeon;
    @FXML private Label descripcionCampeon;
    @FXML private ImageView img;
    @FXML private MediaView audioMV;
    private Campeon campeon;
    private MyListener myListener;

    /**
     * Maneja el evento de clic en un campeón.
     *
     * @param mouseEvent Evento de clic del ratón.
     */
    @FXML private void click(MouseEvent mouseEvent) {
        // Notifica al escuchador sobre el clic en el campeón.
        myListener.onClickListener(campeon);

        // Obtiene la ruta del archivo de audio del campeón.
        String path = "..\\LoreLol\\src\\main\\resources\\com\\dam\\fragments\\" + campeon.getAudioCampeon();

        try {
            // Crea un objeto Media basado en la ruta del archivo de audio.
            Media media = new Media(new File(path).toURI().toString());

            // Crea un reproductor de medios y lo establece en el MediaView.
            MediaPlayer mediaPL = new MediaPlayer(media);
            audioMV.setMediaPlayer(mediaPL);

            // Inicia la reproducción del audio.
            audioMV.getMediaPlayer().play();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Establece los datos del campeón para su visualización.
     *
     * @param campeon      Objeto Campeon que contiene la información del campeón.
     * @param myListener   Escuchador de eventos personalizados.
     */
    public void setData(Campeon campeon, MyListener myListener) {
        // Asigna los datos del campeón y el escuchador.
        this.campeon    = campeon;
        this.myListener = myListener;

        // Carga y muestra la imagen del campeón.
        Image image     = new Image(Main.class.getResourceAsStream(campeon.getImgICON()));
        nombreCampeon.setText(campeon.getName());
        descripcionCampeon.setText(campeon.getDescripcion());
        img.setImage(image);
    }

    /**
     * Inicializa el controlador después de que se carga la interfaz de usuario.
     *
     * @param url            Ubicación utilizada para resolver rutas relativas para el objeto ResourceBundle.
     * @param resourceBundle El recurso para localizar el objeto de inicialización, o null si no hay inicialización.
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        // Inicializa el escuchador de eventos con una implementación vacía.
        myListener = (data)->{};
    }
}
