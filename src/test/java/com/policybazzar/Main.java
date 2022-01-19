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

	ExtentReports report = Rep.reporter();
	
	WebDriver driver = null;

	@BeforeSuite
	public void setup() {
		
		try {
			
			Travel_Data data = new Travel_Data();
		
			String str = "https://www.policybazaar.com/";
		
			ExtentTest logger = report.createTest("DriverSetup");
		
			driver = DriverSetup.getWebDriver(data.getBrowser());
		
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
			
			ExtentTest logger = report.createTest("Travel insurance is successful");
			
			TravelInsurance obj = new TravelInsurance();
		
			obj.process(driver);
			
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

			String fileWithPath = System.getProperty("user.dir")+"./ScreenShot/TakeTravelInsurance.png";			
			
			takeSnapShot(driver,fileWithPath);
						
			ExtentTest logger = report.createTest("car insurance is successful");
			
			driver.manage().deleteAllCookies();
			
			driver.navigate().to("https://www.policybazaar.com/");
			
			CarInsurance obj = new CarInsurance();
			
			obj.process(driver);				
		
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

			String fileWithPath = System.getProperty("user.dir")+"./ScreenShot/TakeCarInsurance.png";			
			
			takeSnapShot(driver,fileWithPath);
						
			ExtentTest logger = report.createTest("Health insurance is successful");
			
			driver.manage().deleteAllCookies();
			
			driver.navigate().to("https://www.policybazaar.com/");			

			HealthInsurancePom fetch = new HealthInsurancePom();

			Actions builder = new Actions(driver);
			WebElement elec = driver.findElement(fetch.insurance_product);
			builder.moveToElement(elec).perform();
			
			List<WebElement> allLinks = driver.findElements(fetch.all_links);
			List<String>output=new ArrayList<String>();

			for(WebElement e:allLinks){
				output.add(e.getText());
			}

			System.out.println(output);
			
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
			
			String fileWithPath = System.getProperty("user.dir")+"./ScreenShot/TakeInsuranceProducts.png";			
			
			takeSnapShot(driver,fileWithPath);
			
			ExtentTest logger = report.createTest("closing browser");
			
			DriverSetup.close_browser();
			
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
