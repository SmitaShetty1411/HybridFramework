package com.qa.automation.pages;

import java.io.IOException;

import org.openqa.selenium.By;
//import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.automation.base.TestBase;

public class Ebay_SearchResultPage extends TestBase {
	
	   public Ebay_SearchResultPage() throws IOException {
	        super();
	        PageFactory.initElements(driver, this);
	    }

    @FindBy(xpath = "//div[@id='gh-cat-box']")
    private WebElement pageLoadingCheckElement;

    @FindBy(xpath = "(//div[@class='s-item__title'])[2]")
    private WebElement firstElementInPage;

 

    public void changeSearchCategory(String newCategory) {
        String categoryXpath = String.format("//ul[contains(@class, 'srp-refine__category__list')][1]//li[normalize-space()='%s']", newCategory);
        WebElement categoryElementToClick = driver.findElement(By.xpath(categoryXpath));
        categoryElementToClick.click();
    }

    public boolean isPageLoadedCompletely() {
        try {
            return pageLoadingCheckElement.isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public String getFirstResultName() {
        return firstElementInPage.getText();
    }
}
