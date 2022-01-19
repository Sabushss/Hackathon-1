package com.policybazzar;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverSetup {

	static WebDriver driver = null; 
    	
    public static WebDriver getWebDriver(String browser){

		//Assigns FireFox Properties to the Driver
    	if(browser.equalsIgnoreCase("firefox"))
    	{    		
    		WebDriverManager.firefoxdriver().setup();    
    	
    		driver = new FirefoxDriver(); 
    		driver.manage().window().maximize();    		
			driver.get("https://www.policybazaar.com/");
    		
    	}
		//Assigns Chrome Properties to the Driver
    	else if(browser.equalsIgnoreCase("chrome"))
    	{    	
    		WebDriverManager.chromedriver().setup();
    		
    		driver = new ChromeDriver();
    		driver.manage().window().maximize();
			driver.get("https://www.policybazaar.com/");
    		
    	}
        return driver;
    }

	public static void close_browser(){

		driver.quit();

	}
}