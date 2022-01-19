package com.policybazzar;

import pom.TravelInsurancePom;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.v94.browser.Browser;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class TravelInsurance{
    
	String[] data;
	
    WebDriver driver;

    WebDriverWait wait;
    
    TravelInsurancePom fetch = new TravelInsurancePom();
    
    List<Integer> set = new ArrayList<Integer>();  
    List<String> insurance = new ArrayList<String>();

	public void process(WebDriver driver)throws Exception{

        this.driver = driver;

    	wait = new WebDriverWait(driver,Duration.ofSeconds(25));

        Travel_Data travel_values = new Travel_Data();
        
        data = travel_values.readData();

		fetch.travel(driver);

		//Filling Dummy Values in the form for two Students
		
		click_travel_insurance();
		
		send_country();
		
		send_dates();
		
        passengers();
        
        select_no();
        
        ph_no();
          
        if(!driver.findElements(By.xpath("//section[@class='leftSection']")).isEmpty()){
            //Fetching Values from First UI
            ui_one();          
        }
        else 
        {
            //Fetching Values from Second UI
            ui_two();
        }  

    }
	
	public void click_travel_insurance() {
		
		 wait.until(ExpectedConditions.visibilityOfElementLocated(fetch.travel_insurance));
	        
		 fetch.travel_insurance();

	}

	public void send_country() throws InterruptedException {
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(fetch.country));
        
        fetch.country(data[0]);
     
        Thread.sleep(2000);

        wait.until(ExpectedConditions.visibilityOfElementLocated(fetch.country_search));

        fetch.country_search();      
        
        wait.until(ExpectedConditions.elementToBeClickable(fetch.button));

        fetch.click();
        
	}
	
	public void send_dates() throws InterruptedException {
	
		Capabilities cap = ((RemoteWebDriver) driver).getCapabilities();
	    
		String browserName = cap.getBrowserName().toLowerCase();
	    
	    if(browserName.contains("firefox")) {
		
	    	wait.until(ExpectedConditions.elementToBeClickable(fetch.from_date));

	    	fetch.from_date(data[1]);
                
	    	wait.until(ExpectedConditions.elementToBeClickable(fetch.to_date_button));
        		
	    	fetch.to_date_click();

	    	wait.until(ExpectedConditions.elementToBeClickable(fetch.to_date));
		
	    	fetch.to_date(data[2]);

	    	wait.until(ExpectedConditions.visibilityOfElementLocated(fetch.button));
                
	    	if(driver.findElement(By.xpath("//p[@class='travelDays']")).getText().contains("NaN"))
	    		Thread.sleep(2000);
        
	    	fetch.click();
	    
	    }else if(browserName.contains("chrome")) {
	    	wait.until(ExpectedConditions.elementToBeClickable(fetch.from_date));

	    	fetch.from_date(data[1]);
                
	    	wait.until(ExpectedConditions.elementToBeClickable(fetch.to_date));
			
	    	fetch.to_date(data[2]);

	    	wait.until(ExpectedConditions.elementToBeClickable(fetch.to_date_button));
        		
	    	fetch.to_date_click();

	    	wait.until(ExpectedConditions.visibilityOfElementLocated(fetch.button));
        
	    	fetch.click();

	    }
	}
	
	public void passengers() {
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(fetch.no_of_passengers));
        
        fetch.no_of_passengers();

        fetch.first_passenger(data[3]);

        fetch.second_passenger(data[4]);

        wait.until(ExpectedConditions.elementToBeClickable(fetch.button));
        
        fetch.click();

	}
	
	public void select_no() {

		wait.until(ExpectedConditions.visibilityOfElementLocated(fetch.no));

        fetch.no_click();

	}
	
	public void ph_no() {
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(fetch.ph_no));
        
        fetch.send_nos(data[5]);
        
        wait.until(ExpectedConditions.elementToBeClickable(fetch.button));

        fetch.click();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));

	}

    public void ui_one() throws InterruptedException{
          	    
    	wait.until(ExpectedConditions.visibilityOfElementLocated(fetch.sort_one));
        
    	fetch.sort_one();
    	
        Thread.sleep(2000);      
        
        wait.until(ExpectedConditions.visibilityOfElementLocated(fetch.low_one));
       
        wait.until(ExpectedConditions.elementToBeClickable(fetch.low_one));
        
        fetch.low_one();
                        
        wait.until(ExpectedConditions.visibilityOfElementLocated(fetch.apply_one));
        
        wait.until(ExpectedConditions.elementToBeClickable(fetch.apply_one));
        
        fetch.apply_one();
                    
        List<String> set = new ArrayList<String>();  
        
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(fetch.price_one));          
        
        List<WebElement> allLinks = driver.findElements(fetch.price_one);
                 
        for(WebElement link:allLinks){               
                if(link.getText()!=null)
                    if(link.getText().substring(0).contains("₹"))
                        {
                            set.add(link.getText());
                            if(set.size() == 3)
                            	break;
                        }
        }        
        
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(fetch.name_one));          
        
        allLinks = driver.findElements(fetch.name_one); 
        
        List<String> hash_Set = new ArrayList<String>();
        
        for(WebElement link:allLinks)
            {		
        		if(link.getText()!=null)
        			if(link.getText().length()!=0)
        				hash_Set.add(link.getText());
        		if(hash_Set.size() == 3)
        			break;
            }                
        
        for(int iter=0; iter<3; iter++) {
        	System.out.println(hash_Set.get(iter)+":"+set.get(iter));
        }
             
    }

    public void ui_two() throws InterruptedException{            
    	
    	wait.until(ExpectedConditions.visibilityOfElementLocated(fetch.sort_two));
    	
        fetch.sort_two();
        
        List<WebElement> allLinks = driver.findElements(fetch.price_two); 
                            
            for(WebElement link:allLinks)
                {	if(link.getText().length()!=0)		            				
                        {

                            String temp = link.getText().substring(2, link.getText().length());			
                            temp = temp.replace(",","");                                
                                                        
                            set.add(Integer.parseInt(temp));                                
                                                        
                        }                    
                }
     
        allLinks = driver.findElements(fetch.name_two);

        for(WebElement e:allLinks){
            if(e.getAttribute("class").contains("Logo"))
                if(e.getAttribute("class").substring(0,4).equals("Logo"))
                    insurance.add(e.getAttribute("class").substring(5,e.getAttribute("class").length()));            
        }
       
        String[][] output = new String[3][2];
        
        String temp = "";

        for(int i=0;i<3;i++)
            {                                                    
                for(int j=0;j<2;j++){
                                               
                    if(j == 0)
                        temp = insurance.get(i);
                    else
                        temp = String.valueOf(set.get(i));

                    output[i][j] = String.valueOf(temp);        
                }                  
        }
        
        System.out.println(Arrays.deepToString(output));
        
    }
}
