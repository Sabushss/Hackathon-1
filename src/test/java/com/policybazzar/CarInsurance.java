package com.policybazzar;

import java.io.IOException;
import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import pom.CarInsurancePom;

public class CarInsurance{
	
	WebDriver driver;
	
	String[] data;

	WebDriverWait wait;
	
	CarInsurancePom fetch = new CarInsurancePom();
	
	public void process(WebDriver driver) throws InterruptedException, IOException{

		this.driver = driver;
					
		wait = new WebDriverWait(driver,Duration.ofSeconds(25));
		
		Car_Data travel_values = new Car_Data();
        
        data = travel_values.readData();
		
		fetch.CarDriver(driver);

		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(25));
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(fetch.CarInsurance));
		
		wait.until(ExpectedConditions.elementToBeClickable(fetch.CarInsurance));

		driver.findElement(fetch.CarInsurance).click();
				
		wait.until(ExpectedConditions.visibilityOfElementLocated(fetch.Proceedbtn));
		
		driver.findElement(fetch.Proceedbtn).click();
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(fetch.city));

		driver.findElement(fetch.city).click();

		if(driver.findElements(fetch.Rto2).isEmpty()) {
	
			ui_one();
		
		}
		else
		{
			ui_two();
		}

	}
	public void ui_one() throws InterruptedException{

		wait.until(ExpectedConditions.visibilityOfElementLocated(fetch.Rto1));
		
		driver.findElement(fetch.Rto1).click();
					
		wait.until(ExpectedConditions.visibilityOfElementLocated(fetch.Bmw1));
		
        wait.until(ExpectedConditions.elementToBeClickable(fetch.Bmw1));

        fetch.CarBrand(data[0]);
				
		wait.until(ExpectedConditions.elementToBeClickable(fetch.CarName1));

		fetch.CarSeries();
		
		fetch.FuelType1();
		
		fetch.CarVariant();
		
		fetch.CarRegistrYear();
		
		fetch.UserName(data[1]);
		
		fetch.UserMail(data[2]);
		
        wait.until(ExpectedConditions.elementToBeClickable(fetch.ErrorMsg1));

		fetch.ErrorMesg1();
		
	}

	public void ui_two() throws InterruptedException{	
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(fetch.Rto2));
		
		driver.findElement(fetch.Rto2).click();
				
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));		
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(fetch.Bmw2));

        //wait.until(ExpectedConditions.elementToBeClickable(fetch.Bmw2));

        fetch.CarBrand2(data[0]);
        
		wait.until(ExpectedConditions.elementToBeClickable(fetch.CarName2));

		fetch.carSeries2();
		
		fetch.FuelType2();
		
		fetch.CarVariant2();
		
		fetch.carRegsYear2();
		
		fetch.userName2(data[1]);
		
		fetch.usermail2(data[2]);
		
		wait.until(ExpectedConditions.elementToBeClickable(fetch.ErrorMsg2));
		
		fetch.Errormsg2();

	}
	
}