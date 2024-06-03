package com.qa.automation.pages;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.automation.base.TestBase;

public class Ebay_ShopByCategoryResultPage extends TestBase{

	public Ebay_ShopByCategoryResultPage() throws IOException {
		super();
		PageFactory.initElements(driver, this);
	}
	  
	
	  @FindBy(xpath = "//div[@class='seo-breadcrumbs-container lexexpsvc']")
	  private WebElement pageLoadingCheckElement;
	  
	  @FindBy(xpath="//a[contains(text(), 'Cell Phone & Smartphone Parts')]")
	  private WebElement subcategory;
	  
	  @FindBy(xpath="//button[@class='brm__all-filters fake-link']")
	  private WebElement AllFilters;
	  
	  @FindBy(xpath="(//span[text()='Condition'])[2]")
	  private WebElement Condition;
      
	  @FindBy(xpath = "//span[text()='Condition']//following::input[@type='checkbox'][1]")
	   private WebElement conditionCheckBoxFilter;

	  @FindBy(xpath = "(//span[text()='Price'])[2]")
	  private WebElement Price;
	  
	  @FindBy(xpath="//input[@class='x-textrange__input x-textrange__input--from']")
	  private WebElement PriceFrom;
	  
	  @FindBy(xpath="//input[@class='x-textrange__input x-textrange__input--to']") 
	  private WebElement PriceTo;
	  
	  @FindBy(xpath = "(//span[text()='Item Location'])")
	  private WebElement itemLocation;

	  @FindBy(xpath = "(//input[@class='radio__control'])[4]")
	   private WebElement itemLocationFilter;

	   @FindBy(xpath = "//button[text()='Apply']")
	   private WebElement applyFiltersButton;
	   
	   @FindBy(xpath="(//button[@class='x-flyout__button'])[1]")
	   private WebElement AppliedFilterVerification;
	   
	   
	   @FindBy(xpath="(//ul[@class='brm__aspect-list'])[1]")
	   private WebElement AppliedFilterValue;
	   
	public boolean isPageLoadedCompletely() {
        try {
            return pageLoadingCheckElement.isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }
	  public void changeSearchCategory() {
		  subcategory.click();
	    }
	    
	 public void selectAllFilters() {
		 
	    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center', inline: 'center', behavior: 'smooth'});", AllFilters);
		 AllFilters.click();
		 Set<String> windowHandles = driver.getWindowHandles();
		  for (String windowHandle : windowHandles) 
		  {
		  driver.switchTo().window(windowHandle);
		  Condition.click();
		  conditionCheckBoxFilter.click();
		  Price.click();
		  PriceFrom.sendKeys(prop.getProperty("priceFrom"));
		  PriceTo.sendKeys(prop.getProperty("PriceTo"));
		  itemLocation.click();
		  itemLocationFilter.click();
		  applyFiltersButton.click();
		  
		  driver.switchTo().defaultContent();
		  break;
		  }
	 }
		  
	 public void verifyAppliedFilters() {
		    try {
		        AppliedFilterVerification.click();
		    } catch (StaleElementReferenceException e) {
		        // Handle the exception by re-finding the element
		        AppliedFilterVerification.click();
		    }

		    List<WebElement> appliedFilters = AppliedFilterValue.findElements(By.tagName("li"));
		    List<String> expectedValues = Arrays.asList("Condition", "Price", "Item Location");
		    // Iterate through the list and compare each li element's text with expected values
		    for (WebElement appliedFilter : appliedFilters) {
		        String actualValue = appliedFilter.getText();
		        for (String expectedValue : expectedValues) {
		            if (actualValue.trim().contains(expectedValue.trim())) {
		                System.out.println("Expected filter: " + expectedValue + " is applied.");
		                break;
		            }
		        }
		    }
		}

}

