package com.policybazzar;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.*;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import Report.Rep;
import pom.HealthInsurancePom;

public class Main {
        //creating object for report class
	ExtentReports report = Rep.reporter();
	
	WebDriver driver = null;
        
	@BeforeSuite
	public void setup() {
		
		try {
			//creating object to call travel data class
			Travel_Data data = new Travel_Data();
		
			String str = "https://www.policybazaar.com/";
		        //Initiating test case
			ExtentTest logger = report.createTest("DriverSetup");
		        //Launching browser
			driver = DriverSetup.getWebDriver(data.getBrowser());
		        //condition is declared to generate extent report
			if(driver.getCurrentUrl().equals(str)) {
		
				logger.log(Status.PASS,"Browser launched successfully");
		
			}else {
		
				logger.log(Status.FAIL, "Browser was not initiated successfully");
			}
		
			} catch (IOException e) {
			
				e.printStackTrace();
		}
		
	}

	@Test(priority = 1)
	public void travel_insurance(){

		try{
			 //Initiating test case
			ExtentTest logger = report.createTest("Travel insurance is successful");
			//creating object to call travel insurance class
			TravelInsurance obj = new TravelInsurance();
		        //calling the process method from travel insurance class
			obj.process(driver);
			 //condition is declared to generate extent report
			if(driver.getTitle().equals("PolicyBazaar Travel Insurance - Quotes")) {
			
				logger.log(Status.PASS, "Travel insurancce is successful");
			
			}else {
		    
				logger.log(Status.FAIL, "Error occured in travel insurance");
			}

		} catch (Exception e) {

			e.printStackTrace();
		}
	}
	
	@Test(priority = 2)
	public void car_insurance(){

		try{
                         //Declaring the location to save the screenshots
			String fileWithPath = System.getProperty("user.dir")+"./ScreenShot/TakeTravelInsurance.png";			
			//command to take screenshot
			takeSnapShot(driver,fileWithPath);
			//Initiating test case			
			ExtentTest logger = report.createTest("car insurance is successful");
			//managing cookies
			driver.manage().deleteAllCookies();
			//navigating to home
			driver.navigate().to("https://www.policybazaar.com/");
			//creating object to call car insurance class
			CarInsurance obj = new CarInsurance();
			//calling the method process from car insurance class
			obj.process(driver);				
		        //condition is declared to generate extent report
			if(driver.getTitle().equals("PolicyBazaar Car Insurance: Insure Your Car Today")){
				
				logger.log(Status.PASS,"Car insurance launched successfully");
			
			}else {
		
			logger.log(Status.FAIL,"Error occured in car insurance");
		
			}
		
		}catch(Exception e){

			e.printStackTrace();
		}
	}

	@Test(priority = 3)
	public void health_insurance(){

		try{      
                        //Declaring the location to save the screenshots
			String fileWithPath = System.getProperty("user.dir")+"./ScreenShot/TakeCarInsurance.png";			
			//command to take screenshot
			takeSnapShot(driver,fileWithPath);
			//Initiating test case			
			ExtentTest logger = report.createTest("Health insurance is successful");
			//Handling cookies
			driver.manage().deleteAllCookies();
			//navigating back to home
			driver.navigate().to("https://www.policybazaar.com/");			
                        //creating object to call health insurance POM class
			HealthInsurancePom fetch = new HealthInsurancePom();
                        //object creation to call action class
			Actions builder = new Actions(driver);
			//Locating webelement to perform action
			WebElement elec = driver.findElement(fetch.insurance_product);
			builder.moveToElement(elec).perform(); //action to hover on the web element
			//creating a list to fecth the webelements
			List<WebElement> allLinks = driver.findElements(fetch.all_links);
			List<String>output=new ArrayList<String>(); //creating a new string array list
                        //iteration to get the web elements and store it in array as string
			for(WebElement e:allLinks){
				output.add(e.getText());
			}
                         //Print the list in console
			System.out.println(output);
			 //condition is declared to generate extent report
			if(output.get(0).contains("Insurance")) {
			
				logger.log(Status.PASS,"Health insurance launched successfully");
			
			}else {
		    
				logger.log(Status.FAIL,"Error occured in health insurance");
			
			}
		
		}catch(Exception e){

			e.printStackTrace();
		}
	}

	@AfterSuite
	public void close_browser() throws NullPointerException{

		try{
			//Declaring the location to save the screenshots
			String fileWithPath = System.getProperty("user.dir")+"./ScreenShot/TakeInsuranceProducts.png";			
			//command to take screenshot
			takeSnapShot(driver,fileWithPath);
			//Initiating test case
			ExtentTest logger = report.createTest("closing browser");
			
			DriverSetup.close_browser();
			 //condition is declared to generate extent report
			if(hasQuit(driver)) {
			
				logger.log(Status.PASS,"Closed browser successfully");
		
			}else {
			
				logger.log(Status.FAIL,"browser not closed successfully");
		
			}	

		}catch(Exception e){

		e.printStackTrace();

		}

		report.flush();
	}
	
	public boolean hasQuit(WebDriver driver) {

        try {

            driver.getTitle();

            return false;

        } catch (Exception e) {

            return true;

        }
	}
	
	public static void takeSnapShot(WebDriver webdriver,String fileWithPath) throws Exception{

        //Convert web driver object to TakeScreenshot

        TakesScreenshot scrShot = ((TakesScreenshot)webdriver);

        //Call getScreenshotAs method to create image file

        File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);

        //Move image file to new destination

        File DestFile=new File(fileWithPath);

        //Copy file at destination

        FileUtils.copyFile(SrcFile, DestFile);

    }


}
