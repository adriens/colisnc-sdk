/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.adriens.github.colisnc.colisnc;

import com.adriens.github.colisnc.countries.Country;
import com.adriens.github.colisnc.countries.ListCountriesDefinedLanguage;
import com.adriens.github.colisnc.localisation.Localisation;
import java.time.LocalDateTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author 3004SAL
 */
public class ColisDataRow {

    /**
     * @return the itemId
     */
    public String getItemId() {
        return itemId;
    }

    /**
     * @param itemId the itemId to set
     */
    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    /**
     * @return the localization
     */
    public Localisation getLocalization() {
        return localization;
    }

    /**
     * @param localization the localization to set
     */
    public void setLocalization(Localisation localization) {
        this.localization = localization;
    }

    final static Logger logger = LoggerFactory.getLogger(ColisDataRow.class);
    enum Status {
     COLIS_LIVRE,
     COLIS_EN_COURS_ACHEMINEMENT,
     COLIS_EN_COURS_DEDOUANEMENT,
     COLIS_ARRIVE_PAYS_DESTINATION,
     COLIS_A_QUITTE_PAYS_ORIGINE,
     COLIS_PRIS_EN_CHARGE,
     COLIS_NULL_STATUS,
     COLIS_PAS_PU_ETRE_LIVRE,
     UNEXPECTED
    }
    
    public static final Status getStatus(ColisDataRow aRow){
   
        if(aRow == null){
            return null;
        }
        String aTypeEvenement = aRow.getTypeEvenement();
        if (aTypeEvenement == null){
            return Status.COLIS_NULL_STATUS;
        }
        // now test
        aTypeEvenement.replace("Votre courrier/colis", "");
        if (aTypeEvenement.contains("a été livré")){
            return Status.COLIS_LIVRE;
        }
        else if(aTypeEvenement.contains("en cours d'acheminement")){
            return Status.COLIS_EN_COURS_ACHEMINEMENT;
        }
        else if(aTypeEvenement.contains("en cours de dédouanement")){
            return Status.COLIS_EN_COURS_DEDOUANEMENT;
        }
        else if(aTypeEvenement.contains("arrivé dans le pays de destination")){
            return Status.COLIS_ARRIVE_PAYS_DESTINATION;
        }
        else if(aTypeEvenement.contains("quitté le pays d'origine")){
            return Status.COLIS_A_QUITTE_PAYS_ORIGINE;
        }
        else if(aTypeEvenement.contains("a été pris en charge")){
            return Status.COLIS_PRIS_EN_CHARGE;
        }
        else if(aTypeEvenement.contains("n'a pas pu être livré")){
            return Status.COLIS_PAS_PU_ETRE_LIVRE;
        }
        else {
            logger.warn("Got unexpected status : <" + aTypeEvenement + ">. Returning <" + Status.UNEXPECTED + ">.");
            logger.warn("Plese consider adding this staus to test case ;-p");
            return Status.UNEXPECTED;
        }
        
        
    }
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
    
    private Status status;
    
    private Country country;
    
    private Localisation localization;
    
    private String itemId;
    
    
    public ColisDataRow(){
        
    }
    
    
    public void setStatus(){
        setStatus(ColisDataRow.getStatus(this));
    }
    public void setStatus(Status aStatus){
        this.status = aStatus;
    }
    public Status getStatus(){
        return this.status;
    }
    
    public void setCountry(Country aCountry){
        this.country = aCountry;
    }
    
    public Country getCountry(){
        return this.country;
    }
    
    public String toString(){
        String out = "";
        out = "Colis: <" + getItemId() + ">\n";
        out += "Date/Heure : <" + getRawDateHeure() + ">\n";
        out += "Localisation : <" + getLocalisation() + ">\n";
        out += "Status : <" + getStatus().toString() + ">";
        return out;
    }
}
