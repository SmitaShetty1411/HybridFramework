package com.qa.automation.testscripts;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qa.automation.base.TestBase;
import com.qa.automation.pages.Ebay_Homepage;

public class Ebay_Website_URL_Lanching extends TestBase {
    Ebay_Homepage HomePage;

    public Ebay_Website_URL_Lanching() throws IOException {
        super();
    }
    
    Logger log=Logger.getLogger(Ebay_Website_URL_Lanching.class);
    @BeforeClass
    public void setup() throws IOException {
        HomePage = new Ebay_Homepage();
        browserInitialization();
        log.info("Browser is launched successfully.");
        // HomePage = new ebay_Homepage(); // This line is redundant and can be removed.
    }

    @Test
    public void verifytheHomePagetitle() {
        String Title = HomePage.validateHomePageTitle();
        Assert.assertEquals(Title, "Electronics, Cars, Fashion, Collectibles & More | eBay");
        log.info("ebay.com website launched in the browser.");
    }

    @AfterClass
    public void ClosingtheBrowser() {
        // Use quit() instead of close() to close all windows and end the WebDriver session.
        driver.quit();
    }
}
