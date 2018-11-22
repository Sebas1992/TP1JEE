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
public class Adresse {
    private String id_adresse;
    private String numero_civique;
    private String rue;
    private String bureau;
    private String ville;
    private String code_postal;
    private String province;
    private String pays;
    private String tel;

    /**
     * @return the id_adresse
     */
    public String getId_adresse() {
        return id_adresse;
    }

    /**
     * @param id_adresse the id_adresse to set
     */
    public void setId_adresse(String id_adresse) {
        this.id_adresse = id_adresse;
    }

    /**
     * @return the numero_civique
     */
    public String getNumero_civique() {
        return numero_civique;
    }

    /**
     * @param numero_civique the numero_civique to set
     */
    public void setNumero_civique(String numero_civique) {
        this.numero_civique = numero_civique;
    }

    /**
     * @return the rue
     */
    public String getRue() {
        return rue;
    }

    /**
     * @param rue the rue to set
     */
    public void setRue(String rue) {
        this.rue = rue;
    }

    /**
     * @return the bureau
     */
    public String getBureau() {
        return bureau;
    }

    /**
     * @param bureau the bureau to set
     */
    public void setBureau(String bureau) {
        this.bureau = bureau;
    }

    /**
     * @return the ville
     */
    public String getVille() {
        return ville;
    }

    /**
     * @param ville the ville to set
     */
    public void setVille(String ville) {
        this.ville = ville;
    }

    /**
     * @return the code_postal
     */
    public String getCode_postal() {
        return code_postal;
    }

    /**
     * @param code_postal the code_postal to set
     */
    public void setCode_postal(String code_postal) {
        this.code_postal = code_postal;
    }

    /**
     * @return the province
     */
    public String getProvince() {
        return province;
    }

    /**
     * @param province the province to set
     */
    public void setProvince(String province) {
        this.province = province;
    }

    /**
     * @return the pays
     */
    public String getPays() {
        return pays;
    }

    /**
     * @param pays the pays to set
     */
    public void setPays(String pays) {
        this.pays = pays;
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
}