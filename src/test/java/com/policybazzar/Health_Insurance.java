package com.policybazzar;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import pom.HealthInsurancePom;

public class Health_Insurance{

    WebDriver driver;
    static WebElement elec; //delcaring Webelement elec
    
    public void process(WebDriver driver){

        this.driver = driver;
        
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        //creating object to call health insurance POM
        HealthInsurancePom fetch = new HealthInsurancePom();
        //Creating object to call actions class
        Actions builder = new Actions(driver);
        //performing action to hover on insurance products
        WebElement elec = driver.findElement(fetch.insurance_product);
        builder.moveToElement(elec).perform();
        //creating a  list to retrieve the webelements 
        List<WebElement> allLinks = driver.findElements(fetch.all_links);
        List<String>output=new ArrayList<String>(); //creating a new list of string data type
       //Using for loop to fetch the list and store it 
        for(WebElement e:allLinks){              
              output.add(e.getText());                
        }
        //Printing the list in the console
        System.out.println(output);

    }
}


