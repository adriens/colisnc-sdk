/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.adriens.github.colisnc.countries.Country;
import com.adriens.github.colisnc.countries.ListCountriesDefinedLanguage;

import static org.junit.Assert.*;
import org.junit.Test;


/**
 *
 * @author meilie
 * 
 */
public class ListCountriesDefinedLanguageTest {
    
    @Test
    public void testGetNullCountry() {
        try {
            
            String aCountryName = null;
            Country result = ListCountriesDefinedLanguage.getCountry(aCountryName);
            assertNull("on null country, null", result);
            
        } catch (Exception ex) {
            
            assertEquals("No exception", 0, ex.getMessage().length());
        }
    }
    
    @Test
    public void testGetEmptyCountry() {
        try {
            
            String aCountryName = "";
            Country result = ListCountriesDefinedLanguage.getCountry(aCountryName);
            assertNull("on empty country, null", result);
            
        } catch (Exception ex) {
            
            assertEquals("No exception", 0, ex.getMessage().length());
        }
    }
    
}
