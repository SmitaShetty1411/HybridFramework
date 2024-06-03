package com.qa.automation.util;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class TestUtil extends com.qa.automation.base.TestBase {
	static String CurrentUserDir = System.getProperty("user.dir");
	public TestUtil() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}

	public static long Page_Load_Timeout = 1000;
	public static long Implicit_wait = 10;

	public static class ScreenshotHelper {

	    public static String getScreenshot(WebDriver driver) throws IOException {
	        TakesScreenshot ts = (TakesScreenshot) driver;
	        File source = ts.getScreenshotAs(OutputType.FILE);
	        String screenshotPath = CurrentUserDir+"/Screenshot" + System.currentTimeMillis() + ".png";
	        File destination = new File(screenshotPath);
	        // Copy the file to the destination
	        org.apache.commons.io.FileUtils.copyFile(source, destination);
	        return screenshotPath;
	    }
	}
}