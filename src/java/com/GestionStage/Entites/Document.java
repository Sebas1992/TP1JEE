/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.GestionStage.Entites;

import java.sql.Timestamp;

/**
 *
 * @author sebas
 */
public class Document {
    private String id_document;
    private String lien;
    private String type;
    private int nb_vues;
    private String id_coordonnateur;
    private Timestamp date;

    public Document(){
        
    }
    
    public Document(String id_document, String lien, String type, int nb_vues, String id_coordonnateur, Timestamp date)
    {
        this.id_document = id_document;
        this.lien = lien;
        this.type = type;
        this.nb_vues = nb_vues;
        this.id_coordonnateur = id_coordonnateur;
        this.date = date;
    }
    
    /**
     * @return the id_document
     */
    public String getId_document() {
        return id_document;
    }

    /**
     * @param id_document the id_document to set
     */
    public void setId_document(String id_document) {
        this.id_document = id_document;
    }

    /**
     * @return the lien
     */
    public String getLien() {
        return lien;
    }

    /**
     * @param lien the lien to set
     */
    public void setLien(String lien) {
        this.lien = lien;
    }

    /**
     * @return the type
     */
    public String getType() {
        return type;
    }

    /**
     * @param type the type to set
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * @return the nb_vues
     */
    public int getNb_vues() {
        return nb_vues;
    }

    /**
     * @param nb_vues the nb_vues to set
     */
    public void setNb_vues(int nb_vues) {
        this.nb_vues = nb_vues;
    }

    /**
     * @return the id_coordonnateur
     */
    public String getId_coordonnateur() {
        return id_coordonnateur;
    }

    /**
     * @param id_coordonnateur the id_coordonnateur to set
     */
    public void setId_coordonnateur(String id_coordonnateur) {
        this.id_coordonnateur = id_coordonnateur;
    }

    /**
     * @return the date
     */
    public Timestamp getDate() {
        return date;
    }

    /**
     * @param date the date to set
     */
    public void setDate(Timestamp date) {
        this.date = date;
    }
}
