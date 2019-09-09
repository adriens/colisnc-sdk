/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.adriens.github.colisnc.colisnc;

/**
 *
 * @author 3004SAL
 */
public class ColisDataRow {
    private String dateHeure;
    private String pays;
    private String localisation;
    private String typeEvenement;
    private String informations;
    
    public ColisDataRow(){
        
    }
    public String toString(){
        String out = "";
        out = "Date/Heure : <" + dateHeure + ">\n";
        out += "Localisation : <" + localisation + ">\n";
        return out;
    }
}
