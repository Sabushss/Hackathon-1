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
    static WebElement elec;
    
    public void process(WebDriver driver){

        this.driver = driver;
        
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        
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

    }
}


