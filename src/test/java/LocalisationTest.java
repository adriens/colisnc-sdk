/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.adriens.github.colisnc.localisation.Localisation;

import static org.junit.Assert.*;
import org.junit.Test;

/**
 *
 * @author meilie
 * 
 */
public class LocalisationTest {
    
    @Test
    public void testGetLongName() {
        try {
            
            Localisation localisation = new Localisation();
            localisation.setLongName("test");
            String result = localisation.getLongName();
            assertTrue("longName set : \"test\"", "test".equals(result));
        
        } catch (Exception ex) {
            
            assertEquals("No exception", 0, ex.getMessage().length());
        }
        
    }

}
