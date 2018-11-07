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
public class Communication {
    private String titre;
    private String message;
    private Utilisateur expediteur;
    private Utilisateur destinataire;

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
     * @return the expediteur
     */
    public Utilisateur getExpediteur() {
        return expediteur;
    }

    /**
     * @param expediteur the expediteur to set
     */
    public void setExpediteur(Utilisateur expediteur) {
        this.expediteur = expediteur;
    }

    /**
     * @return the destinataire
     */
    public Utilisateur getDestinataire() {
        return destinataire;
    }

    /**
     * @param destinataire the destinataire to set
     */
    public void setDestinataire(Utilisateur destinataire) {
        this.destinataire = destinataire;
    }
    
}
