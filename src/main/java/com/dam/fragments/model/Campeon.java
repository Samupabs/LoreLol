package com.dam.fragments.model;

/**
 * Clase que representa a un campeón en el juego.
 */
public class Campeon {

    private String name;
    private String imgGIF;
    private String imgICON;
    private String descripcion;
    private String color;
    private String audioCampeon;

    /**
     * Constructor para crear un objeto Campeon.
     *
     * @param name         Nombre del campeón.
     * @param imgSrc       Ruta de la imagen GIF del campeón.
     * @param descripcion  Descripción del campeón.
     * @param color        Color asociado al campeón.
     * @param imgSrcICON   Ruta de la imagen ICON del campeón.
     * @param audioCampeon Ruta del archivo de audio asociado al campeón.
     */
    public Campeon(String name, String imgSrc, String descripcion, String color, String imgSrcICON, String audioCampeon) {
        this.name        = name;
        this.imgGIF      = imgSrc;
        this.descripcion = descripcion;
        this.color       = color;
        this.imgICON     = imgSrcICON;
        this.audioCampeon= audioCampeon;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImgGIF() {
        return imgGIF;
    }

    public void setImgGIF(String imgGIF) {
        this.imgGIF = imgGIF;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }


    public String getColor() {
        return color;
    }


    public void setColor(String color) {
        this.color = color;
    }


    public String getImgICON() {
        return imgICON;
    }

    public void setImgICON(String imgICON) {
        this.imgICON = imgICON;
    }

    public String getAudioCampeon() {
        return audioCampeon;
    }

    public void setAudioCampeon(String audioCampeon) {
        this.audioCampeon = audioCampeon;
    }
}
