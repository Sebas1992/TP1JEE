/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.GestionStage.Entites;

import java.sql.Time;
import java.sql.Timestamp;

/**
 *
 * @author sebas
 */
public class Utilisateur {
    private String id_utilisateur;
    private String courriel;
    private String mot_de_passe;
    private String nom;
    private String prenom;
    private String type_utilisateur;

    public Utilisateur() {
    }
    
    public Utilisateur(String id_utilisateur, String courriel, String mot_de_passe, String nom, String prenom, String type_utilisateur) {
        this.id_utilisateur = id_utilisateur;
        this.courriel = courriel;
        this.mot_de_passe = mot_de_passe;
        this.nom = nom;
        this.prenom = prenom;
        this.type_utilisateur = type_utilisateur;
    }
    
    public Utilisateur(String nom, String prenom)
    {
        this.nom = nom;
        this.prenom = prenom;
    }
    
    /**
     * @return the id_utilisateur
     */
    public String getId_utilisateur() {
        return id_utilisateur;
    }

    /**
     * @param id_utilisateur the id_utilisateur to set
     */
    public void setId_utilisateur(String id_utilisateur) {
        this.id_utilisateur = id_utilisateur;
    }

    /**
     * @return the courriel
     */
    public String getCourriel() {
        return courriel;
    }

    /**
     * @param courriel the courriel to set
     */
    public void setCourriel(String courriel) {
        this.courriel = courriel;
    }

    /**
     * @return the mot_de_passe
     */
    public String getMot_de_passe() {
        return mot_de_passe;
    }

    /**
     * @param mot_de_passe the mot_de_passe to set
     */
    public void setMot_de_passe(String mot_de_passe) {
        this.mot_de_passe = mot_de_passe;
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
     * @return the prenom
     */
    public String getPrenom() {
        return prenom;
    }

    /**
     * @param prenom the prenom to set
     */
    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    /**
     * @return the type_utilisateur
     */
    public String getType_utilisateur() {
        return type_utilisateur;
    }

    /**
     * @param type_utilisateur the type_utilisateur to set
     */
    public void setType_utilisateur(String type_utilisateur) {
        this.type_utilisateur = type_utilisateur;
    }
    
}
