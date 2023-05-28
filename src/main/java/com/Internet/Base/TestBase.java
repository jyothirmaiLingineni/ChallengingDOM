package com.Internet.Base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class TestBase {
	
	public static WebDriver driver;
	public static Properties prop;
	//Handling properties file
	public TestBase(){
		try {
			prop = new Properties();
			FileInputStream ip = new FileInputStream("C:\\Users\\kotap\\IdeaProjects\\ChallengingDOM\\Environment.properties");
			prop.load(ip);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	//Browser initialisation
	public static void initialization(){
		
		String browserName = prop.getProperty("browser");		
		
		if(browserName.equalsIgnoreCase("chrome")){
			System.out.println("Executing in Chrome browser_________________________");
			//System.setProperty("webdriver.chrome.driver", prop.getProperty("chromepath"));
			ChromeOptions options=new ChromeOptions();
			options.addArguments("--headless");
			driver = new ChromeDriver(options); 
		}
		else if(browserName.equalsIgnoreCase("firefox")){
			System.out.println("Executing in Firefox browser___________________________");
			//System.setProperty("webdriver.gecko.driver",prop.getProperty("geckopath"));	
			driver = new FirefoxDriver(); 
		}
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();	
		driver.get(prop.getProperty("url"));
		
	}
}

