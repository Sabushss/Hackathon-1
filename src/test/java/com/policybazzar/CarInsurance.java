package com.policybazzar;

import java.io.IOException;
import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import pom.CarInsurancePom;

public class CarInsurance{
	
	WebDriver driver;
	
	String[] data; //declaring array of string data type

	WebDriverWait wait;
	//creating object for car insurance POM class
	CarInsurancePom fetch = new CarInsurancePom();
	//
	public void process(WebDriver driver) throws InterruptedException, IOException{

		this.driver = driver;
					
		wait = new WebDriverWait(driver,Duration.ofSeconds(25));
		//creating object to call car data class
		Car_Data travel_values = new Car_Data();
        
        data = travel_values.readData(); //calling the method read data 
		
		fetch.CarDriver(driver); //calling car driver method from car insurance POM class

		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(25));
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(fetch.CarInsurance));
		
		wait.until(ExpectedConditions.elementToBeClickable(fetch.CarInsurance));

		driver.findElement(fetch.CarInsurance).click();  //Locating xpath from Pom class 
				
		wait.until(ExpectedConditions.visibilityOfElementLocated(fetch.Proceedbtn));
		
		driver.findElement(fetch.Proceedbtn).click();   //Locating xpath from Pom class
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(fetch.city));

		driver.findElement(fetch.city).click();  //Locating xpath from Pom class
                //Conditional statement for handling two different UIs'
		if(driver.findElements(fetch.Rto2).isEmpty()) {
	
			ui_one();
		
		}
		else
		{
			ui_two();
		}

	}
	//Definig the method for UI 1
	public void ui_one() throws InterruptedException{

		wait.until(ExpectedConditions.visibilityOfElementLocated(fetch.Rto1));
		
		driver.findElement(fetch.Rto1).click();  //Locating xpath for RTO number from Pom class for UI 1
					
		wait.until(ExpectedConditions.visibilityOfElementLocated(fetch.Bmw1));
		
        wait.until(ExpectedConditions.elementToBeClickable(fetch.Bmw1)); //passing condition to wait till the BMW1 text box is clicked
         //calling the method car brand and the data is fetched from excel
        fetch.CarBrand(data[0]);
				
		wait.until(ExpectedConditions.elementToBeClickable(fetch.CarName1));

		fetch.CarSeries(); //calling the method car series from POM for UI 1
		
		fetch.FuelType1(); //calling the method Fuel type from POM for UI 1
		
		fetch.CarVariant(); //calling the method car variant from POM for UI 1
		
		fetch.CarRegistrYear(); //calling the method car Register from POM for UI 1
		
		fetch.UserName(data[1]); //calling the method user name from POM and data fetched from excel for UI 1
		
		fetch.UserMail(data[2]); //calling the method user mail from POM and data fetched from excel for UI 1
		
        wait.until(ExpectedConditions.elementToBeClickable(fetch.ErrorMsg1));

		fetch.ErrorMesg1(); //calling the method error message from POM for UI 1
		 
	}
	
         //Defining the method for UI 2
	public void ui_two() throws InterruptedException{	
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(fetch.Rto2));
		
		driver.findElement(fetch.Rto2).click();  //Locating xpath for RTO number from Pom class
				
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));		
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(fetch.Bmw2)); //passing condition to wait till the BMW1 text box is clicked

        //wait.until(ExpectedConditions.elementToBeClickable(fetch.Bmw2));
        //calling the method car brand and the data is fetched from excel
        fetch.CarBrand2(data[0]);
        
		wait.until(ExpectedConditions.elementToBeClickable(fetch.CarName2));

		fetch.carSeries2(); //calling the method car series from POM for UI 2
		
		fetch.FuelType2(); //calling the method fuel type from POM for UI 2
		
		fetch.CarVariant2(); //calling the method car variant from POM for UI 2
		
		fetch.carRegsYear2(); //calling the method car registration from POM for UI 2
		
		fetch.userName2(data[1]); //calling the method user name from POM for UI 2
		
		fetch.usermail2(data[2]); //calling the method user mail from POM for UI 2
		
		wait.until(ExpectedConditions.elementToBeClickable(fetch.ErrorMsg2));
		
		fetch.Errormsg2(); //calling the method error msg from POM for UI 2

	}
	
}
