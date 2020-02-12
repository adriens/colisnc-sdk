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

    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public String getLongName() {
        return longName;
    }
    
    public void setLongName(String longName) {
        this.longName = longName;
    }
    
    public String getUrl() {
        return url;
    }
    
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
