/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.GestionStage.Entites;

import java.util.Date;
import java.util.UUID;

/**
 *
 * @author Nicolas
 */
public class Offrestage {
    
    private String id_offre;
    private String titre;
    private String description;
    private String lien_web;
    private String lien_document;
    private Date date;
    private int nb_vues;
    private int active;
    private String id_employeur;

    public Offrestage(String titre, String description, String lien_web, String lien_document, String id_employeur) {
        this.id_offre= UUID.randomUUID().toString();
        this.titre = titre;
        this.description = description;
        this.lien_web = lien_web;
        this.lien_document = lien_document;
        this.date = new Date();
        this.nb_vues=0;
        this.active=0;
        this.id_employeur = id_employeur;
    }
    
    public String getIdOffre() {
        return id_offre;
    }

    public void setIdOffre(String id_offre) {
        this.id_offre = id_offre;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLienWeb() {
        return lien_web;
    }

    public void setLienWeb(String lien_web) {
        this.lien_web = lien_web;
    }

    public String getLienDocument() {
        return lien_document;
    }

    public void setLienDocument(String lien_document) {
        this.lien_document = lien_document;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getNbVues() {
        return nb_vues;
    }

    public void setNbVues(int nb_vues) {
        this.nb_vues = nb_vues;
    }

    public int getActive() {
        return active;
    }

    public void setActive(int active) {
        this.active = active;
    }

    public String getIdEmployeur() {
        return id_employeur;
    }

    public void setIdEmployeur(String id_employeur) {
        this.id_employeur = id_employeur;
    }
}
