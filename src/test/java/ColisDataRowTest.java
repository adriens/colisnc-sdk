/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.adriens.github.colisnc.colisnc.ColisDataRow;
import com.adriens.github.colisnc.countries.Country;
import com.adriens.github.colisnc.localisation.Localisation;

import java.time.LocalDateTime;

import static org.junit.Assert.*;
import org.junit.Test;

/**
 *
 * @author meilie
 *
 * Test of class ColisDataRow.
 * 
 */

public class ColisDataRowTest {
    
    /**
     * Test of getLocalization method, of class ColisDataRow.
     */
    @Test
    public void testGetLocalization() {
        try {
            
            ColisDataRow instance = new ColisDataRow();
            Localisation localisation = new Localisation();
            localisation.setName("NOUMEA-TEST");
            instance.setLocalization(localisation);
            assertEquals("localisation name set to \"NOUMEA-TEST\"", instance.getLocalization(), localisation);
            
        } catch (Exception ex) {
            
            assertEquals("No exception", 0, ex.getMessage().length());
        }
        
    }
    
    /**
     * Test of getStatus method, of class ColisDataRow.
     * Test null row.
     */
    @Test
    public void testGetStatusNull() {
        try {
            
            ColisDataRow aRow = null;
            assertNull("on row null, null", ColisDataRow.getStatus(aRow));
        
        } catch (Exception ex) {
            
            assertEquals("No exception", 0, ex.getMessage().length());
        }
    }
    
    /**
     * Test of getPays method, of class ColisDataRow.
     * Test for country name set to "test".
     */
    @Test
    public void testGetPays() {
        try {
            
            ColisDataRow aRow = new ColisDataRow();
            aRow.setPays("test");
            assertEquals("Country set to \"test\"","test", aRow.getPays());
            
        } catch (Exception ex) {
            
            assertEquals("No exception", 0, ex.getMessage().length());
        }
        
    }
    
    /**
     * Test of getInformations method, of class ColisDataRow.
     * Test for information set to "test".
     */
    @Test
    public void testGetInformations() {
        try {
            
            ColisDataRow aRow = new ColisDataRow();
            aRow.setInformations("test");
            assertEquals("Information set to \"test\"","test", aRow.getInformations());
            
        } catch (Exception ex) {
            
            assertEquals("No exception", 0, ex.getMessage().length());
        }
        
    }
    
    /**
     * Test of getDate method, of class ColisDataRow.
     * Test for date set to current date.
     */
    @Test
    public void testGetDate() {
        try {
            
            ColisDataRow aRow = new ColisDataRow();
            LocalDateTime currentDateTime = LocalDateTime.now();
            aRow.setDate(currentDateTime);
            assertEquals(currentDateTime, aRow.getDate());
            
        } catch (Exception ex) {
            
            assertEquals("No exception", 0, ex.getMessage().length());
        }
        
    }
    
    /**
     * Test of getDate method, of class ColisDataRow.
     * Test for country set to (isoTEST","codeTEST","nameTEST").
     */
    @Test
    public void testGetCountry() {
        try {
            
            ColisDataRow aRow = new ColisDataRow();
            Country countryTEST = new Country("isoTEST","codeTEST","nameTEST");
            aRow.setCountry(countryTEST);
            assertEquals("Country set to Country(\"isoTEST\",\"codeTEST\",\"nameTEST\")",countryTEST, aRow.getCountry());
            
        } catch (Exception ex) {
            
            assertEquals("No exception", 0, ex.getMessage().length());
        }
    }

}
