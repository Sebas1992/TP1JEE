/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.GestionStage.Entites;

import java.util.Date;

/**
 *
 * @author Nicolas
 */
public class Cv {
    private String id_cv;
    private String lien;
    private String langue;
    private int nb_vues;
    private String id_etudiant;
    private Date date;

    public Cv() {
    }
    
    public Cv(String id_cv, String lien, String langue, int nb_vues, String id_etudiant, Date date) {
        this.id_cv = id_cv;
        this.lien = lien;
        this.langue = langue;
        this.nb_vues = nb_vues;
        this.id_etudiant = id_etudiant;
        this.date = date;
    }

    public String getId_cv() {
        return id_cv;
    }

    public void setId_cv(String id_cv) {
        this.id_cv = id_cv;
    }

    public String getLien() {
        return lien;
    }

    public void setLien(String lien) {
        this.lien = lien;
    }

    public String getLangue() {
        return langue;
    }

    public void setLangue(String langue) {
        this.langue = langue;
    }

    public int getNb_vues() {
        return nb_vues;
    }

    public void setNb_vues(int nb_vues) {
        this.nb_vues = nb_vues;
    }

    public String getId_etudiant() {
        return id_etudiant;
    }

    public void setId_etudiant(String id_etudiant) {
        this.id_etudiant = id_etudiant;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
