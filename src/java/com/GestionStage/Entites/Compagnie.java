/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.GestionStage.Entites;

/**
 *
 * @author sebas
 */
public class Compagnie {
    private String id_compagnie;
    private String nom;
    private String site_web;
    private String id_adresse;

    /**
     * @return the id_compagnie
     */
    public String getId_compagnie() {
        return id_compagnie;
    }

    /**
     * @param id_compagnie the id_compagnie to set
     */
    public void setId_compagnie(String id_compagnie) {
        this.id_compagnie = id_compagnie;
    }

    /**
     * @return the nom
     */
    public String getNom() {
        return nom;
    }

    /**
     * @param nom the nom to set
     */
    public void setNom(String nom) {
        this.nom = nom;
    }

    /**
     * @return the site_web
     */
    public String getSite_web() {
        return site_web;
    }

    /**
     * @param site_web the site_web to set
     */
    public void setSite_web(String site_web) {
        this.site_web = site_web;
    }

    /**
     * @return the adresse
     */
    public String get_IDAdresse() {
        return id_adresse;
    }

    /**
     * @param adresse the adresse to set
     */
    public void set_IDAdresse(String id_adresse) {
        this.id_adresse = id_adresse;
    }
}
