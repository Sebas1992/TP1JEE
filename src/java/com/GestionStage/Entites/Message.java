/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.GestionStage.Entites;

import java.sql.Date;
import java.sql.Time;

/**
 *
 * @author sebas
 */
public class Message {
    private String id_message;
    private String titre;
    private String message;
    private int vu;
    private Date date;
    private Time heure;
    private String id_expediteur;

    /**
     * @return the id_message
     */
    public String getId_message() {
        return id_message;
    }

    /**
     * @param id_message the id_message to set
     */
    public void setId_message(String id_message) {
        this.id_message = id_message;
    }

    /**
     * @return the titre
     */
    public String getTitre() {
        return titre;
    }

    /**
     * @param titre the titre to set
     */
    public void setTitre(String titre) {
        this.titre = titre;
    }

    /**
     * @return the message
     */
    public String getMessage() {
        return message;
    }

    /**
     * @param message the message to set
     */
    public void setMessage(String message) {
        this.message = message;
    }

    /**
     * @return the vu
     */
    public int getVu() {
        return vu;
    }

    /**
     * @param vu the vu to set
     */
    public void setVu(int vu) {
        this.vu = vu;
    }

    /**
     * @return the date
     */
    public Date getDate() {
        return date;
    }

    /**
     * @param date the date to set
     */
    public void setDate(Date date) {
        this.date = date;
    }

    /**
     * @return the heure
     */
    public Time getHeure() {
        return heure;
    }

    /**
     * @param heure the heure to set
     */
    public void setHeure(Time heure) {
        this.heure = heure;
    }

    /**
     * @return the id_expediteur
     */
    public String getId_expediteur() {
        return id_expediteur;
    }

    /**
     * @param id_expediteur the id_expediteur to set
     */
    public void setId_expediteur(String id_expediteur) {
        this.id_expediteur = id_expediteur;
    }
}
