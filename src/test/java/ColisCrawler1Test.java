/*
import com.adriens.github.colisnc.colisnc.ColisCrawler;
import com.adriens.github.colisnc.colisnc.ColisDataRow;
import com.gargoylesoftware.htmlunit.BrowserVersion;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import java.util.ArrayList;
import java.util.List;
import junit.framework.TestCase;
import org.junit.*;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 
// @author 3004SAL
 
public class ColisCrawlerTest extends TestCase{

    
    @Test
    public void testSiteIsAlive() {
        try {
            WebClient webClient = new WebClient(BrowserVersion.BEST_SUPPORTED);
            webClient.getOptions().setJavaScriptEnabled(false);
            webClient.getOptions().setDownloadImages(false);
            HtmlPage thePage = webClient.getPage(ColisCrawler.BASE_URL);
            Assert.assertTrue("La pagse est bien accessible", thePage.asText().contains("Suivi de Votre Envoi"));
        } catch (Exception ex) {

        }
    }
    
    @Test
    public void testBadItemid(){
        try{
            String itemId = "XXXX";
            ArrayList<ColisDataRow> coliadDetails = ColisCrawler.getColisRows(itemId);
            Assert.assertEquals("Sur un numéro bidon, liste vide", 0, coliadDetails.size());
        }
        catch(Exception ex){
            Assert.assertEquals("Pas d'exception", 0, ex.getMessage().length());
        }
    }
        
    @Test
    public void testGoodItemid(){
        try{
            String itemId = "CA107308006SI";
            ArrayList<ColisDataRow> coliadDetails = ColisCrawler.getColisRows(itemId);
            Assert.assertEquals("Sur CA107308006SI, la liste doit avoir 6 items", 6, coliadDetails.size());
        }
        catch(Exception ex){
            Assert.assertEquals("Pas d'exception", 0, ex.getMessage().length());
        }
    }
   
  
 
}*/
