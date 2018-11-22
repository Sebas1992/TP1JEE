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
public class Employeur extends Utilisateur{
    private String id_employeur;
    private String tel;
    private String id_compagnie;

    /**
     * @return the id_employeur
     */
    public String getId_employeur() {
        return id_employeur;
    }

    /**
     * @param id_employeur the id_employeur to set
     */
    public void setId_employeur(String id_employeur) {
        this.id_employeur = id_employeur;
    }

    /**
     * @return the tel
     */
    public String getTel() {
        return tel;
    }

    /**
     * @param tel the tel to set
     */
    public void setTel(String tel) {
        this.tel = tel;
    }

    /**
     * @return the compagnie
     */
    public String get_IDCompagnie() {
        return id_compagnie;
    }

    /**
     * @param compagnie the compagnie to set
     */
    public void set_IDCompagnie(String id_compagnie) {
        this.id_compagnie = id_compagnie;
    }
}
