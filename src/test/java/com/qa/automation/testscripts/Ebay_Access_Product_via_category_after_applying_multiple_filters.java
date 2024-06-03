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
import com.qa.automation.pages.Ebay_ShopByCategoryResultPage;

public class Ebay_Access_Product_via_category_after_applying_multiple_filters extends TestBase{
	
	   Ebay_Homepage homePage;
	   Ebay_SearchResultPage searchResultPage;
	   Ebay_ShopByCategoryResultPage SearchProductWithMultifilters;
	   
	public Ebay_Access_Product_via_category_after_applying_multiple_filters() throws IOException {
		super();
		
	}
	
	Logger log=Logger.getLogger(Ebay_Access_Product_via_category_after_applying_multiple_filters.class);
	@BeforeClass
    public void setup() throws IOException {
    	browserInitialization();
        homePage = new Ebay_Homepage();
        searchResultPage = new Ebay_SearchResultPage();
        SearchProductWithMultifilters= new Ebay_ShopByCategoryResultPage();
        log.info("Browser is launched successfully.");
    }
	
	@Test
	public void AccessProductViaCategory() throws IOException {
	    log.info("***********Scenario 1: Access a Product via category after applying multiple filters*******************");
		homePage.shopByCategory();
		log.info("Succesfully clicked on shopbycategory and selected the category");
	    Assert.assertTrue(SearchProductWithMultifilters.isPageLoadedCompletely(), "Page did not load completely.");
	    SearchProductWithMultifilters.changeSearchCategory();
	    log.info("Able to click on the required search category");
	    SearchProductWithMultifilters.selectAllFilters();
	    log.info("Succesfully applied the specific filters.");
	    SearchProductWithMultifilters.verifyAppliedFilters();
	    log.info("All the applied filters are verified succesfully.");
	}
	
	  @AfterClass
	    public void tearDown() {
	        driver.quit();
	        log.info("Browser is closed.");
	    }

	
}
