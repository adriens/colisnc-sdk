/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.adriens.github.colisnc.localisation.Localisation;
import com.adriens.github.colisnc.localisation.Localisations;

import java.util.*;

import static org.junit.Assert.*;
import org.junit.Test;

/**
 *
 * @author meilie
 * 
 * Test of class Localisations.
 * 
 */

public class LocalisationsTest {
    
    /**
     * Test of setLocalisations method, of class Localisations.
     * Test for 1 city named "test".
     */
    @Test
    public void testSetOneLocalisations() {
        try {

            Localisation localisations = new Localisation();
            localisations.setName("test");

            List<Localisation> lLocalisations = Arrays.asList(new Localisation[]{localisations});

            Localisations instance = new Localisations();
            instance.setLocalisations(lLocalisations);
           
            assertEquals("1 localisation", lLocalisations, instance.getLocalisations());

        } catch (Exception ex) {
            
            assertEquals("No exception", 0, ex.getMessage().length());
        }
    }

    /**
     * Test of setLocalisations method, of class Localisations.
     * Test for 3 cities named "test1","test2","test3".
     */
    @Test
    public void testSetMultiLocalisations() {
        try {

            Localisation localisation1 = new Localisation();
            Localisation localisation2 = new Localisation();
            Localisation localisation3 = new Localisation();
            localisation1.setName("test1");
            localisation2.setName("test2");
            localisation3.setName("test3");
            
            List<Localisation> lLocalisations = Arrays.asList(new Localisation[]{localisation1, localisation2, localisation3});

            Localisations instance = new Localisations();
            instance.setLocalisations(lLocalisations);

            assertEquals("3 localisations", lLocalisations, instance.getLocalisations());

        } catch (Exception ex) {
            
            assertEquals("No exception", 0, ex.getMessage().length());
        }
    }
    
}
