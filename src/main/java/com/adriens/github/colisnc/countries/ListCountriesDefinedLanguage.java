/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.adriens.github.colisnc.countries;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.stream.Collectors;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author 3004SAL
 * 
 * ListCountriesDefinedLanguage is the class representing the list of all countries in french.
 * 
 * {@code 
 * 
 * public void demoLocalisations() {
 *
 *      try {
 *          JAXBContext jaxbContext = JAXBContext.newInstance(Localisations.class);
 *          Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
 *
 *          assertNotNull("JAXBContext is not null", jaxbContext);
 *          assertNotNull("Unmarshaller is not null", jaxbUnmarshaller);
 *
 *          //We had written this file in marshalling example
 *          Localisations parts = (Localisations) jaxbUnmarshaller.unmarshal(Localisations.class.getResourceAsStream("/localisations.xml"));
 *
 *          assertTrue("there must be at least 10 localisation", parts.getLocalisations().size() > 10);
 *
 *          for (Localisation part : parts.getLocalisations()) {
 *              System.out.println(part.getName());
 *              System.out.println(part.getUrl());
 *              System.out.println("-------------------------------------------------");
 *          }
 *
 *          System.out.println("######################################################");
 *
 *          String aLocalisation = "NOUMEA-CTP";
 *          Localisation local = new Localisation();
 *
 *          local = Localisations.locate(aLocalisation);
 *          System.out.println(local);
 *
 *          assertNotNull("we must find a city", local);
 *
 *      } catch (JAXBException ex) {
 *          System.err.println("impossible to manage xml : " + ex.getMessage());
 *      }
 *  }
 * 
 * }
 * 
 */
public class ListCountriesDefinedLanguage {
    
    final static Logger logger = LoggerFactory.getLogger(ListCountriesDefinedLanguage.class);
    
    /**
     * Return a list of all Country objects in french
     * @return a list of all Country objects
     */
    public static List<Country> getCountries() {
        List<Country> countries = new ArrayList<>();

        // Map ISO countries to custom country object
        String[] countryCodes = Locale.getISOCountries();
        for (String countryCode : countryCodes){

            Locale locale = new Locale("", countryCode);
            String iso = locale.getISO3Country();
            String code = locale.getCountry();
            String name = locale.getDisplayCountry(Locale.FRANCE).toLowerCase();
            name = StringUtils.stripAccents(name);

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
    
    /**
     * Return a Country object that match the aCountryName argument.
     * @param aCountryName
     *          the name of the Country to return.
     * @return a Country object.
     */
    public static Country getCountry(String aCountryName){
        Country out = null;
        if(aCountryName == null){
            return out;
        }
        if(aCountryName.equals("")){
            return out;
        }
        
        Map<String, Country> cMap = getCountries().stream().collect(Collectors.toMap(Country::getName, country -> country));
        out = cMap.get(StringUtils.stripAccents(aCountryName.toLowerCase()));
        return out;
    }
}
