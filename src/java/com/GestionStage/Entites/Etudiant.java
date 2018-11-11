/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.GestionStage.Entites;

/**
 *
 * @author Nicolas
 */
public class Etudiant extends Utilisateur{
    
    private String id_etudiant;
    private String status;
    
    public Etudiant() {
    }

    public Etudiant(String id_etudiant) {
        //this.id_etudiant = id_etudiant;
        //this.status="En recherche de stage";
        this(id_etudiant,"En recherche de stage");

    }
    
    public Etudiant(String id_etudiant, String courriel, String mot_de_passe, String nom, String prenom, String type_utilisateur)
    {
        super(id_etudiant, courriel, mot_de_passe, nom, prenom, type_utilisateur);
    }
    
    public Etudiant(String id_etudiant, String status) {
        this.id_etudiant = id_etudiant;
        this.status = status;
    }

    public String getId_etudiant() {
        return id_etudiant;
    }

    public void setId_etudiant(String id_etudiant) {
        this.id_etudiant = id_etudiant;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    } 
}
