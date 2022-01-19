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
    		WebDriverManager.firefoxdriver().setup();  //Launching browser setup  
    	
    		driver = new FirefoxDriver(); 
    		driver.manage().window().maximize();    //maximizing window		
			driver.get("https://www.policybazaar.com/"); // Launching the URL
    		
    	}
		//Assigns Chrome Properties to the Driver
    	else if(browser.equalsIgnoreCase("chrome"))
    	{    	
    		WebDriverManager.chromedriver().setup(); //Launching browser setup
    		
    		driver = new ChromeDriver();
    		driver.manage().window().maximize();  //maximizing window
			driver.get("https://www.policybazaar.com/"); //Launching the URL
    		
    	}
        return driver;
    }

	public static void close_browser(){

		driver.quit();

	}
}
