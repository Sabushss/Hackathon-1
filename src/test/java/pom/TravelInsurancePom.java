package pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class TravelInsurancePom {

	WebDriver driver; 

	public void travel(WebDriver driver){
		this.driver = driver;
	}

	//Common UI locators
	
	public By travel_insurance = By.xpath("//*[@class='icon-bg icon-bg-new ti']");
	public By country = By.id("country");
	public By country_search = By.className("search-item");
	public By button = By.className("travel_main_cta");
	public By from_date = By.xpath("(//input[@aria-invalid='false'])[1]");
	public By to_date = By.xpath("(//input[@aria-invalid='false'])[2]");
	public By to_date_button = By.xpath("//button[@aria-label='Feb 14, 2022']");
	public By no_of_passengers = By.xpath("//label[@for='traveller_2'][text()='2']");
	public By first_passenger = By.xpath("//div[@class='pqLayoutWrap']/div[@class='pqMembersAgeWrap']/div[@class='inputRow select '][1]//select[@id='feet']");
	public By second_passenger = By.xpath("//div[@class='pqLayoutWrap']/div[@class='pqMembersAgeWrap']/div[@class='inputRow select '][2]//select[@id='feet']");
	public By no = By.xpath("//input[@value='no']");
	public By ph_no = By.xpath("//input[@inputmode='numeric']");

	//Common UI Locators functions

	public void travel_insurance(){
		driver.findElement(travel_insurance).click();
	}

	public void country(String country){
		driver.findElement(this.country).sendKeys(country);        
	}

	public void country_search(){
		driver.findElement(country_search).click();
	}

	public void click(){
		driver.findElement(button).click();
	}

	public void from_date(String from_date){
		driver.findElement(this.from_date).sendKeys(from_date);
	}

	public void to_date(String to_date){
		driver.findElement(this.to_date).sendKeys(to_date);
	}

	public void to_date_click(){
		driver.findElement(to_date_button).click();
	}

	public void no_of_passengers(){
		driver.findElement(no_of_passengers).click();
	}

	public void first_passenger(String age){
		Select sel = new Select(driver.findElement(first_passenger));
        sel.selectByVisibleText(age);
	}

	public void second_passenger(String age){
		Select sel = new Select(driver.findElement(second_passenger));
        sel.selectByVisibleText(age);
	}

	public void no_click(){
		driver.findElement(no).click();
	}

	public void send_nos(String ph_no){

		driver.findElement(this.ph_no).click();

        driver.findElement(this.ph_no).sendKeys(ph_no);

	}

	//UI one Locators
	
	public By sort_one = By.xpath("//a[text()='Sort by']");
	public By low_one = By.xpath("//label[text()='Premium low to high']");
	public By apply_one = By.xpath("//button[text()='Apply']");
	public By price_one = By.tagName("span");
	public By name_one = By.xpath("//p[@class=\"quotesCard--insurerName\"]");

	//UI one Functions
	
	public void sort_one(){
		driver.findElement(By.xpath("//a[text()='Sort by']")).click();
	}

	public void low_one(){
		driver.findElement(By.xpath("//label[text()='Premium low to high']")).click();
	}

	public void apply_one(){
		driver.findElement(By.xpath("//button[text()='Apply']")).click();	
	}

	//UI two Locators

	public By sort_two = By.xpath("//*[@class='sort_select']");
	public By price_two = By.tagName("button");
	public By name_two = By.tagName("div");

	//UI two Functions

	public void sort_two(){

		Select sl = new Select(driver.findElement(sort_two));          

        sl.selectByIndex(1);

	}
}
