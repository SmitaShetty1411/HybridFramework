package com.qa.automation.pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.automation.base.TestBase;

public class Ebay_Homepage extends TestBase {

    @FindBy(xpath = "//input[@name='_nkw']")
    WebElement searchTypeBox;

    @FindBy(xpath = "//input[@type='submit']")
    WebElement searchButton;
    
    @FindBy(xpath= "//button[@id='gh-shop-a']")
    WebElement ShopByCategory;
    
    @FindBy(xpath="//a[text()='Cell phones & accessories']")
    WebElement ProductForSearch;
    
    public Ebay_Homepage() throws IOException {
        super();
        PageFactory.initElements(driver, this);
    }
    
    public String validateHomePageTitle() {
		return driver.getTitle();
	}

    public Ebay_SearchResultPage SearchAProduct(String searchProduct) throws IOException {
        searchTypeBox.click();
        searchTypeBox.sendKeys(searchProduct);
        searchButton.click();
        return new Ebay_SearchResultPage();
    }
    
    public Ebay_ShopByCategoryResultPage shopByCategory() throws IOException {
    	
    	ShopByCategory.click();
    	ProductForSearch.click();
    	return new Ebay_ShopByCategoryResultPage();
    }
}
