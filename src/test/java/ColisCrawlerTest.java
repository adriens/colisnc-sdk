/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.adriens.github.colisnc.colisnc.ColisCrawler;
import com.adriens.github.colisnc.colisnc.ColisDataRow;

import com.gargoylesoftware.htmlunit.BrowserVersion;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlPage;

import java.util.*;
import static org.junit.Assert.*;

import org.junit.Test;

/**
 *
 * @author meilie
 * 
 */
public class ColisCrawlerTest {

    /**
     * Test of WebClient method, of class ColisCrawler.
     */
    @Test
    public void testSiteIsAlive() {
        try {
            WebClient webClient = new WebClient(BrowserVersion.BEST_SUPPORTED);
            webClient.getOptions().setJavaScriptEnabled(false);
            webClient.getOptions().setDownloadImages(false);
            HtmlPage thePage = webClient.getPage(ColisCrawler.BASE_URL);
            
            assertTrue("You can access the page ", thePage.asText().contains("Suivi de Votre Envoi"));
            
        } catch (Exception ex) {
            
            System.err.println("Page inaccessible: " + ex.getMessage());
        }
    }
    
    /**
     * Test of getLatestStatusForColisList method, of class ColisCrawler.
     * Test null parameter colisListe.
     */
    @Test
    public void testGetLatestStatusForColisListNullColisListe() {
        try {

            ArrayList<ColisDataRow> colisList = ColisCrawler.getLatestStatusForColisList(null);
            assertNull("on null, null, ", colisList);

        } catch (Exception ex) {
            
            assertEquals("No exception", 0, ex.getMessage().length());
        }
    }

    /**
     * Test of getLatestStatusForColisList method, of class ColisCrawler.
     * Test empty parameter colisListe.
     */
    @Test
    public void testGetLatestStatusForColisListEmptyColisListe() {
        try {

            List<String> colisListe = new ArrayList<>();
            ArrayList<ColisDataRow> colisList = ColisCrawler.getLatestStatusForColisList(colisListe);
            assertTrue("On empty list, no rows", colisList.isEmpty());

        } catch (Exception ex) {
            
            assertEquals("No exception", 0, ex.getMessage().length());
        }
    }

    /**
     * Test of getLatestStatusForColisList method, of class ColisCrawler.
     * Test for 1 colis in parameter colisListe.
     */
    @Test
    public void testGetLatestStatusForColisListOneColisListe() {
        try {

            List<String> colisListe = Arrays.asList(new String[]{"CA107308006SI"});
            ArrayList<ColisDataRow> colisList = ColisCrawler.getLatestStatusForColisList(colisListe);
            assertTrue("latest row for colisListe", colisList.size() == 1);

        } catch (Exception ex) {
            
            assertEquals("No exception", 0, ex.getMessage().length());
        }
    }

    /**
     * Test of getLatestStatusForColisList method, of class ColisCrawler.
     * Test for 3 colis in parameter colisListe.
     */
    @Test
    public void testGetLatestStatusForColisListMultiColisListe() {
        try {

            List<String> colisListe = Arrays.asList(new String[]{"RP733152095CN", "7Q08649925982", "7A53946342222"});
            ArrayList<ColisDataRow> colisList = ColisCrawler.getLatestStatusForColisList(colisListe);
            assertTrue("3 latest row for the 3 colisListe", colisList.size() == 3);

        } catch (Exception ex) {
            
            assertEquals("No exception", 0, ex.getMessage().length());
        }
    }

    /**
     * Test of getColisRows method, of class ColisCrawler.
     * Test empty parameter.
     */
    @Test
    public void testGetColisRowsEmptyItemId() {
        try {

            String itemId = "";
            ArrayList<ColisDataRow> colisList = ColisCrawler.getColisRows(itemId);
            assertTrue("no rows for empty itemId", colisList.isEmpty());

        } catch (Exception ex) {
            
            assertEquals("No exception", 0, ex.getMessage().length());
        }
    }

    /**
     * Test of getColisRows method, of class ColisCrawler.
     * Test null parameter.
     */
    @Test
    public void testGetColisRowsNulltemId() {

        try {

            String itemId = null;
            ArrayList<ColisDataRow> colisList = ColisCrawler.getColisRows(itemId);
            assertTrue("no rows for null itemId", colisList.isEmpty());

        } catch (Exception ex) {
            
            assertEquals("No exception", 0, ex.getMessage().length());
        }
    }

    /**
     * Test of getColisRows method, of class ColisCrawler.
     * Test existing colis, itemId parameter.
     */
    @Test
    public void testGetColisRowsGoodItemId() {
        try {

            String itemId = "CA107308006SI";
            ArrayList<ColisDataRow> colisList = ColisCrawler.getColisRows(itemId);
            assertTrue("on itemId \"CA107308006SI\", there're 6 rows", colisList.size() == 6);

        } catch (Exception ex) {
            
            assertEquals("No exception", 0, ex.getMessage().length());
        }
    }

    /**
     * Test of getColisRows method, of class ColisCrawler.
     * Test nonexistent colis, itemId parameter.
     */
    @Test
    public void testGetColisRowsBadItemId() {
        try {

            String itemId = "XX";
            ArrayList<ColisDataRow> colisList = ColisCrawler.getColisRows(itemId);
            assertTrue("on bad itemId, empty colisList", colisList.isEmpty());

        } catch (Exception ex) {
            
            assertEquals("No exception", 0, ex.getMessage().length());
        }
    }

    /**
     * Test of getColisRows method, of class ColisCrawler.
     * Test null parameter.
     */
    @Test
    public void testGetLatestNullItemId() {
        try {

            String itemId = null;
            ColisDataRow colisList = ColisCrawler.getLatest(itemId);
            assertNull("on null, null", colisList);

        } catch (Exception ex) {
            
            assertEquals("No exception", 0, ex.getMessage().length());
        }
    }

    /**
     * Test of getColisRows method, of class ColisCrawler.
     * Test empty parameter.
     */
    @Test
    public void testGetLatestEmptyItemId() {
        try {

            String itemId = "";
            ColisDataRow colisList = ColisCrawler.getLatest(itemId);
            assertNull("on empty itemId, null", colisList);

        } catch (Exception ex) {
            
            assertEquals("No exception", 0, ex.getMessage().length());
        }
    }

    /**
     * Test of getLatest method, of class ColisCrawler.
     * Test nonexistent colis, itemId parameter.
     */
    @Test
    public void testGetLatestBadItemId() {
        try {

            String itemId = "XX";
            ColisDataRow result = ColisCrawler.getLatest(itemId);
            assertNull("on bad itemId and empty lList, null", result);

        } catch (Exception ex) {
            
            assertEquals("No exception", 0, ex.getMessage().length());
        }
    }

    /**
     * Test of getLatest method, of class ColisCrawler.
     * Test existing colis, itemId parameter.
     */
    @Test
    public void testGetLatestGoodItemId() {
        try {

            String itemId = "CA107308006SI";
            ArrayList<ColisDataRow> lList = ColisCrawler.getColisRows(itemId);
            ColisDataRow latestRow = lList.get(0);
            ColisDataRow result = ColisCrawler.getLatest(itemId);
            assertEquals(result.getItemId(), latestRow.getItemId());

        } catch (Exception ex) {
            
            assertEquals("No exception", 0, ex.getMessage().length());
        }
    }

    /**
     * Test of getOldest method, of class ColisCrawler.
     * Test null parameter.
     */
    @Test
    public void testGetOldestNullItemId() {
        try {

            String itemId = null;
            ColisDataRow result = ColisCrawler.getOldest(itemId);
            assertNull("on null itemId, null", result);

        } catch (Exception ex) {
            
            assertEquals("No exception", 0, ex.getMessage().length());
        }
    }

    /**
     * Test of getOldest method, of class ColisCrawler.
     * Test empty parameter.
     */
    @Test
    public void testGetOldestEmptyItemId() {
        try {

            String itemId = "";
            ColisDataRow result = ColisCrawler.getOldest(itemId);
            assertNull("on empty itemId, null", result);

        } catch (Exception ex) {
            
            assertEquals("No exception", 0, ex.getMessage().length());
        }
    }

    /**
     * Test of getOldest method, of class ColisCrawler.
     * Test nonexistent colis, itemId paramter.
     */
    @Test
    public void testGetOldestBadItemId() {
        try {

            String itemId = "XX";
            ColisDataRow result = ColisCrawler.getOldest(itemId);
            assertNull("on bas itemId, null", result);

        } catch (Exception ex) {
            
            assertEquals("No exception", 0, ex.getMessage().length());
        }
    }

    /**
     * Test of getOldest method, of class ColisCrawler.
     * Test existing colis, itemId parameter.
     */
    @Test
    public void testGetOldestGoodItemId() {
        try {

            String itemId = "CA107308006SI";
            ArrayList<ColisDataRow> lList = ColisCrawler.getColisRows(itemId);
            ColisDataRow oldestRow = lList.get(lList.size() - 1);
            ColisDataRow result = ColisCrawler.getOldest(itemId);
            assertEquals(result.getItemId(), oldestRow.getItemId());

        } catch (Exception ex) {
            
            assertEquals("No exception", 0, ex.getMessage().length());
        }
    }

}
