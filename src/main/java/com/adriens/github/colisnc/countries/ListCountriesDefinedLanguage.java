/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.adriens.github.colisnc.countries;

import com.adriens.github.colisnc.colisnc.ColisCrawler;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.stream.Collectors;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author 3004SAL
 */
public class ListCountriesDefinedLanguage {
    final static Logger logger = LoggerFactory.getLogger(ListCountriesDefinedLanguage.class);
    
    public static List<Country> getCountries() {
        List<Country> countries = new ArrayList<Country>();

        // Map ISO countries to custom country object
        String[] countryCodes = Locale.getISOCountries();
        for (String countryCode : countryCodes){

            Locale locale = new Locale("", countryCode);
            String iso = locale.getISO3Country();
            String code = locale.getCountry();
            String name = locale.getDisplayCountry(Locale.FRANCE).toLowerCase();

            countries.add(new Country(iso, code, name));
        }

        // Sort countries
        Collections.sort(countries);

        // Loop over collection of countries and print to console
        countries.forEach(System.out::println);

        // print total number of countries
        logger.debug("found: " + countries.size() + " countries");
        return countries;
    }
    
    
    public static Country getCountry(String aCountryName){
        Country out = null;
        if(aCountryName == null){
            return out;
        }
        if(aCountryName.equals("")){
            return out;
        }
        
        Map<String, Country> cMap = getCountries().stream().collect(Collectors.toMap(Country::getName, country -> country));
        out = cMap.get(aCountryName.toLowerCase());
        return out;
    }
    public static void main(String... args){

        // Create a collection of all available countries
        Country theCountry = ListCountriesDefinedLanguage.getCountry("SLOVÉNIE");
        System.out.println("trouvé:\n" + theCountry);
        System.exit(0);
    }
}
