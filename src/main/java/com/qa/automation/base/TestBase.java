package com.qa.automation.base;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.qa.automation.util.TestUtil;


public class TestBase {

	public static WebDriver driver;
	public static Properties prop;
	public static String CurrentUserDir = System.getProperty("user.dir");
	
	public TestBase() throws IOException {

		
		prop = new Properties(); // this is for config file read , we have initialize the properties class
		FileInputStream ip = new FileInputStream(CurrentUserDir + "//src//main//java//com//cermati//qa//automation//config//config.properties");
	    prop.load(ip);
	}

	    public static void browserInitialization() {

		String browserName = prop.getProperty("browser");

		if (browserName.equalsIgnoreCase("chrome"))
		{
			System.setProperty("webdriver.chrome.driver",CurrentUserDir + "/src/main/java/Softwares/chromedriver-win64/chromedriver.exe");
			driver = new ChromeDriver();
		} 
		else if (browserName.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver",
					CurrentUserDir + "/src/main/java/Softwares/geckodriver-v0.34.0-win32/geckodriver.exe");
		} 
		else if (browserName.equalsIgnoreCase("edge")) {
			System.setProperty("webdriver.edge.driver",
					CurrentUserDir + "/src/main/java/Softwares/edgedriver_win64/msedgedriver.exe");

		} else {
			System.out.println("Invalid Input for Browser in config file.");
		}

		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.Page_Load_Timeout, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.Implicit_wait, TimeUnit.SECONDS);

		driver.get(prop.getProperty("url"));
	}

		public static WebDriver getDriver() {
			
			return driver;
		}

	
		}

