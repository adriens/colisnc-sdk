/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.adriens.github.colisnc.countries.Country;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author meilie
 * 
 * Test of class Country.
 *
 */

public class CountryTest {
    
    /**
     * Test of getIso method, of class Country.
     * Test for country set to ("isoTEST","codeTEST","nameTEST").
     */
    @Test
    public void testGetIso() {
        try {
            
            Country instance = new Country("isoTEST","codeTEST","nameTEST");
            assertEquals("Country iso set to \"isoTEST\"",instance.getIso(), "isoTEST");
            
        } catch (Exception ex) {
            
            assertEquals("No exception", 0, ex.getMessage().length());
        }
        
    }
    
    /**
     * Test of getCode method, of class Country.
     * Test for country set to ("isoTEST","codeTEST","nameTEST").
     */
    @Test
    public void testGetCode() {
        try {
            
            Country instance = new Country("isoTEST","codeTEST","nameTEST");
            assertEquals("Country code set to \"codeTEST\"",instance.getCode(), "codeTEST");
            
        } catch (Exception ex) {
            
            assertEquals("No exception", 0, ex.getMessage().length());
        }
        
    }

}
