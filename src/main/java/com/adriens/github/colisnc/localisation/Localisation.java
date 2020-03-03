/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.adriens.github.colisnc.localisation;

/**
 * 
 * @author 3004SAL
 * <br>
 * <p>
 * <code><b>Localisation</b></code> is the class representing the location/position of different city/places.
 * </p>
 * 
 */
public class Localisation {
    
    private String name;
    private String longName;
    private String url;

    /**
     * Return the displayed name of the Localisation object. 
     * @return the name of the Localisation.
     */
    public String getName() {
        return name;
    }
    
    /**
     * Set the name key of the Localisation object.
     * @param name
     *          The name key of the Localisation.
     */
    public void setName(String name) {
        this.name = name;
    }
    
    /**
     * Return the name of the Localisation object.
     * @return
     *          The name of the Localisation.
     */
    public String getLongName() {
        return longName;
    }
    
    /**
     * Set the name of the Localisation object.
     * @param longName
     *          The name of the Localisation.
     */
    public void setLongName(String longName) {
        this.longName = longName;
    }
    
    /**
     * Return the url to Google Map of the Localisation object.
     * @return the url of the Localisation.
     */
    public String getUrl() {
        return url;
    }
    
    /**
     * Set the url to Google Map of the Localisation object.
     * @param url
     *          the url of the Localisation.
     */
    public void setUrl(String url) {
        this.url = url;
    }
    
   public String toString(){
       String out = "";
       out = "Loc. Name : <" + getName() + ">\n" ;
       out += "Loc. url: <" + getUrl() + ">";
       return out;
   } 
}
