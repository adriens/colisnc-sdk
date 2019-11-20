/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.adriens.github.colisnc.localisation;

/**
 *
 * @author 3004SAL
 */
public class Localisation {
    
    private String name;
    private String longName;
    private String url;

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the longName
     */
    public String getLongName() {
        return longName;
    }

    /**
     * @param longName the longName to set
     */
    public void setLongName(String longName) {
        this.longName = longName;
    }

    /**
     * @return the url
     */
    public String getUrl() {
        return url;
    }

    /**
     * @param url the url to set
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
