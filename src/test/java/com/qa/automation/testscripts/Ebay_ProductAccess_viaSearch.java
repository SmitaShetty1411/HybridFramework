package com.qa.automation.testscripts;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qa.automation.base.TestBase;
import com.qa.automation.pages.Ebay_Homepage;
import com.qa.automation.pages.Ebay_SearchResultPage;

public class Ebay_ProductAccess_viaSearch extends TestBase {
    Ebay_Homepage homePage;
    Ebay_SearchResultPage searchResultPage;

    public Ebay_ProductAccess_viaSearch() throws IOException {
        super();
    }
    Logger log=Logger.getLogger(Ebay_ProductAccess_viaSearch.class);
    @BeforeClass
    public void setup() throws IOException {
    	browserInitialization();
        homePage = new Ebay_Homepage();
        searchResultPage = new Ebay_SearchResultPage();
        log.info("Browser is launhed successfully.");
      
    }

    @Test
    public void Test_AccessProduct_ViaSearch() throws IOException {
    	log.info("***********Scenario 2: Access a Product via Search*******************");
		
    	String ProductName=prop.getProperty("Product");
        homePage.SearchAProduct(ProductName);
        log.info("Succesfully entered the "+ProductName+" in the search bar");
        String CategoryName=prop.getProperty("Category");
        searchResultPage.changeSearchCategory(CategoryName);
        log.info("Search category is changed to "+CategoryName+ " Successfully.");
        Assert.assertTrue(searchResultPage.isPageLoadedCompletely(), "Page did not load completely.");
        log.info("Page loaded successfully");
        String firstResultName = searchResultPage.getFirstResultName();
        Assert.assertTrue(firstResultName.toLowerCase().contains(ProductName.toLowerCase()), "First result name does not match with the search string.");
        log.info("First result name matches with the search string "+ProductName);
    }

    @AfterClass
    public void tearDown() {
       driver.quit();
        log.info("Browser is closed.");
    }
}
