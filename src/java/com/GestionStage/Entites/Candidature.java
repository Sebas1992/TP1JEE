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
public class Candidature {
    private String titre;
    private String description;
    private String lien_web;
    private String lien_document;
    private int nb_vues;
    private String active;
    private Timestamp date;
    private String statut;
    private Utilisateur etudiant;

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
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * @return the lien_web
     */
    public String getLien_web() {
        return lien_web;
    }

    /**
     * @param lien_web the lien_web to set
     */
    public void setLien_web(String lien_web) {
        this.lien_web = lien_web;
    }

    /**
     * @return the lien_document
     */
    public String getLien_document() {
        return lien_document;
    }

    /**
     * @param lien_document the lien_document to set
     */
    public void setLien_document(String lien_document) {
        this.lien_document = lien_document;
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
     * @return the active
     */
    public String getActive() {
        return active;
    }

    /**
     * @param active the active to set
     */
    public void setActive(String active) {
        this.active = active;
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

    /**
     * @return the statut
     */
    public String getStatut() {
        return statut;
    }

    /**
     * @param statut the statut to set
     */
    public void setStatut(String statut) {
        this.statut = statut;
    }

    /**
     * @return the etudiant
     */
    public Utilisateur getEtudiant() {
        return etudiant;
    }

    /**
     * @param etudiant the etudiant to set
     */
    public void setEtudiant(Utilisateur etudiant) {
        this.etudiant = etudiant;
    }
}