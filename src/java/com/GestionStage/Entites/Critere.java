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
public class Critere {
    
    private String id_critere;
    private String nom;
    
    public Critere(){
    }

    public String getIdCritere() {
        return id_critere;
    }

    public void setIdCritere(String id_critere) {
        this.id_critere = id_critere;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }
}
