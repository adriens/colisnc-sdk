/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.adriens.github.colisnc.colisnc;

import java.time.LocalDateTime;

/**
 *
 * @author 3004SAL
 */
public class ColisDataRow {

    /**
     * @return the rawDateHeure
     */
    public String getRawDateHeure() {
        return rawDateHeure;
    }

    /**
     * @param rawDateHeure the rawDateHeure to set
     */
    public void setRawDateHeure(String rawDateHeure) {
        this.rawDateHeure = rawDateHeure;
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
     * @return the localisation
     */
    public String getLocalisation() {
        return localisation;
    }

    /**
     * @param localisation the localisation to set
     */
    public void setLocalisation(String localisation) {
        this.localisation = localisation;
    }

    /**
     * @return the typeEvenement
     */
    public String getTypeEvenement() {
        return typeEvenement;
    }

    /**
     * @param typeEvenement the typeEvenement to set
     */
    public void setTypeEvenement(String typeEvenement) {
        this.typeEvenement = typeEvenement;
    }

    /**
     * @return the informations
     */
    public String getInformations() {
        return informations;
    }

    /**
     * @param informations the informations to set
     */
    public void setInformations(String informations) {
        this.informations = informations;
    }

    /**
     * @return the date
     */
    public LocalDateTime getDate() {
        return date;
    }

    /**
     * @param date the date to set
     */
    public void setDate(LocalDateTime date) {
        this.date = date;
    }
    private String rawDateHeure;
    private String pays;
    private String localisation;
    private String typeEvenement;
    private String informations;
    private LocalDateTime date;
    
    public ColisDataRow(){
        
    }
    
    
    
    public String toString(){
        String out = "";
        out = "Date/Heure : <" + getRawDateHeure() + ">\n";
        out += "Localisation : <" + getLocalisation() + ">\n";
        return out;
    }
}
