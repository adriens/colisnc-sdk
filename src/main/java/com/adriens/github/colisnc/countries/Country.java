/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.adriens.github.colisnc.countries;

/**
 * 
 * @author 3004SAL
 * <br>
 * <p>
 * A <code><b>Country</b></code> object represents a specific geographical, political, or cultural region.
 * </p>
 */
public class Country implements Comparable {

    
    private String iso;
    private String code;
    private String name;

    /**
     * Constructor
     * 
     * @param iso
     *          a three-letter abbreviation for the country.
     * @param code
     *          a two-letter code or a three-digit code for the country.
     * @param name
     *          the name for the country.
     */
    public Country(String iso, String code, String name) {
        this.iso = iso;
        this.code = code;
        this.name = name;
    }
    
    /**
     * Return a three-letter abbreviation for the country.
     * @return a three-letter abbreviation for the country.
     */
    public String getIso() {
        return iso;
    }
    
    /**
     * Returns the country code, which should either be the empty string, an uppercase ISO 3166 2-letter code, or a UN M.49 3-digit code.
     * @return The country code, or the empty string if none is defined.
     */
    public String getCode() {
        return code;
    }
    
    /**
     * Returns the name of the country.
     * @return The name of the country.
     */
    public String getName() {
        return name;
    }
    
    /**
     * Call to compareTo() method.
     * It compares two strings, the name of this country and the country name in argument, lexicographically.
     * 
     * @param o
     *          the {@code Country} that the name be compared.
     * @return the value {@code 0} if the argument country name is equal to
     *          this country name; a value less than {@code 0} if this name
     *          is lexicographically less than the name argument; and a
     *          value greater than {@code 0} if this name is
     *          lexicographically greater than the name argument.
     */
    public int compareTo(Country o) {
        return this.name.compareTo(o.getName());
    }
    
    @Override
    public String toString() {
        return "Country{" +
                "iso='" + iso + '\'' +
                ", code='" + code + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
    
    @Override
    public int compareTo(Object o) {
        return this.compareTo((Country)o);
            //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
