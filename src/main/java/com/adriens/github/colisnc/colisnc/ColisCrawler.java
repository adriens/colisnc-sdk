/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.adriens.github.colisnc.colisnc;

import com.adriens.github.colisnc.countries.ListCountriesDefinedLanguage;
import com.adriens.github.colisnc.localisation.Localisation;
import com.adriens.github.colisnc.localisation.Localisations;
import com.gargoylesoftware.htmlunit.BrowserVersion;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import com.gargoylesoftware.htmlunit.html.HtmlTable;
import com.gargoylesoftware.htmlunit.html.HtmlTableBody;
import com.gargoylesoftware.htmlunit.html.HtmlTableRow;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author 3004SAL
 */
public class ColisCrawler {
    public static final String BASE_URL = "http://webtrack.opt.nc/ipswebtracking/IPSWeb_item_events.asp";
    public static final String QUERY = "?itemid=";
    public static final String NO_ROWS_MESSAGE = "Le colis demandé est introuvable...";
    
    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/uuuu HH:mm:ss");
    final static Logger logger = LoggerFactory.getLogger(ColisCrawler.class);
    
    private static WebClient buildWebClient(){
        WebClient webClient = new WebClient(BrowserVersion.BEST_SUPPORTED);
        webClient.getOptions().setJavaScriptEnabled(false);
        webClient.getOptions().setDownloadImages(false);
        return webClient;
    }
    
     public static final ArrayList<ColisDataRow> getColisRows(String itemId) throws Exception {
         WebClient webClient = buildWebClient();
         ArrayList<ColisDataRow> rows ;
        rows = new ArrayList<>();
        if(itemId == null){
            return rows;
        }
        if (itemId.isEmpty()){
            return rows;
        }
         HtmlPage rowsPage = webClient.getPage(ColisCrawler.BASE_URL + ColisCrawler.QUERY + itemId + "&Submit=Nouvelle+recherche");
         if (rowsPage.asText().contains(NO_ROWS_MESSAGE)){
             logger.warn("Le colis demandé <" + itemId + "> est introuvable...");
             return rows;
         }
        // get the table
         HtmlTable rowsTable = (HtmlTable)rowsPage.getElementsByTagName("table").get(0);
         for (final HtmlTableBody body : rowsTable.getBodies()) {
            final List<HtmlTableRow> tableRows = body.getRows();
            logger.debug("Rows found : " + rows.size());
            // now fetch each row
             Iterator<HtmlTableRow> rowIter = tableRows.iterator();
            HtmlTableRow theRow;
            
            String rawDateHeure;
            String pays;
            String localisation;
            String typeEvenement;
            String informations;
            LocalDateTime localDateTime;
            Localisation geolocalized;
            
            
            while (rowIter.hasNext()) {
                ColisDataRow colisRow = new ColisDataRow();
                theRow = rowIter.next();
                
                rawDateHeure = theRow.getCell(1).asText();
                pays = theRow.getCell(2).asText();
                localisation = theRow.getCell(3).asText();
                typeEvenement = theRow.getCell(4).asText();
                informations = theRow.getCell(5).asText();
            
                localDateTime = LocalDateTime.parse(rawDateHeure, formatter);
                geolocalized = Localisations.locate(localisation);
                
                
                colisRow.setRawDateHeure(rawDateHeure);;
                colisRow.setPays(pays);
                colisRow.setLocalisation(localisation);
                colisRow.setTypeEvenement(typeEvenement);
                colisRow.setInformations(informations);
                colisRow.setDate(localDateTime);
                colisRow.setStatus();
                colisRow.setCountry(ListCountriesDefinedLanguage.getCountry(pays));
                colisRow.setLocalization(geolocalized);
                rows.add(colisRow);
                
                logger.debug("RAW LINE : <" + theRow.asText() + ">");
                logger.info("raw dateHeure : <" + rawDateHeure + ">");
                logger.info("Local DateTime: <" + localDateTime + ">");
                
                logger.info("pays : <" + pays + ">");
                logger.info("localisation : <" + localisation + ">");
                logger.info("typeEvenement : <" + typeEvenement + ">");
                logger.info("informations : <" + informations + ">");
                logger.info("localization : <" + geolocalized + ">");
                logger.info("---------------------------------------------------");
                //lTransaction = new Transaction(convertFromTextDate(dateAsString), libele, extractSolde(debitAsString), extractSolde(credititAsString));
                //getTransactions().add(lTransaction);
                //logger.debug("Added new transaction : " + lTransaction.toString());
            }
            //logger.debug("End of <" + getTransactions().size() + "> transactions fetching");
        }
        return rows;
     }
     public static final ColisDataRow getLatest(String itemId) throws Exception {
         if(itemId == null){
            return null;
         }
         if(itemId.length() == 0){
             return null;
         }
         ArrayList<ColisDataRow> lList = ColisCrawler.getColisRows(itemId);
         
         if(lList.size() == 0){
             return null;
         }
         
         return lList.get(0);
     }
     
     public static final ColisDataRow getOldest(String itemId) throws Exception {
         if(itemId == null){
            return null;
         }
         if(itemId.length() == 0){
             return null;
         }
         ArrayList<ColisDataRow> lList = ColisCrawler.getColisRows(itemId);
         
         if(lList.size() == 0){
             return null;
         }
         
         return lList.get(lList.size()-1);
     }
     
     public static void main (String[] args){
         //String itemId = "XX";
         String itemId = "CA107308006SI";
         try{
             ArrayList<ColisDataRow> coliadDetails = ColisCrawler.getColisRows(itemId);
             System.out.println("Got <" + coliadDetails.size() + "> details pour <" + itemId + ">");
             System.out.println("###############################################");
             System.out.println("latest : " + ColisCrawler.getLatest(itemId));
             System.exit(0);
         }
         catch (Exception ex){
             System.exit(1);
         }
     }
}