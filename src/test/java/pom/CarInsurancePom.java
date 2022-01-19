package pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CarInsurancePom{

	WebDriver driver;

	public	By Rto1 = By.xpath("//SPAN[@class=''][text()='TN01']");
	public By Bmw1 = By.xpath("//INPUT[@type='text']");
	public By CarName1 = By.xpath("//LI[@id='react-autowhatever-1--item-0']");
	public By FuelType1 = By.id("Petrol");
	public By Variant1 =  By.xpath("//SPAN[@class='']");
	public By RegYear1 = By.xpath("//*[text()='Brand New Car']");
	public By UserName1 = By.id("name");
	public By UserEmail1 = By.id("email");
	public By ErrorMsg1 = By.xpath("//div[@class='msg-error show']");

	//UI two Locators
	public By Rto2 = By.xpath("//div[text()='TN01']");
	public By Bmw2 = By.xpath("//INPUT[@type='text']");
	public By CarName2 = By.xpath( "//LI[@id='react-autowhatever-1--item-0']");
	public By FuelType2 = By.id("Petrol");
	public By Variant2 = By.xpath("//DIV[@class='cards'][text()='116i (1598 cc)']");
	public By RegYear2 = By.xpath("//DIV[@class='cards'][text()='Brand new car']");
	public By userName2 = By.xpath("//INPUT[@id='name']");
	public By UserEmail2 =By.xpath("//INPUT[@id='email']");
	public By ErrorMsg2 =  By.xpath("//div[@class='msg-error show']");

	// UI-1 Methods
	public void CarDriver(WebDriver driver) {
		this.driver = driver;
	}
	public void CarBrand(String car_name) {

		driver.findElement(Bmw1).click();
		driver.findElement(Bmw1).sendKeys(car_name);

	}
	public void CarSeries() {
		driver.findElement(CarName1).click();
	}
	public void FuelType1() {
		driver.findElement(FuelType1).click();
	}
	public void CarVariant() {
		driver.findElement(Variant1).click();
	}
	public void CarRegistrYear() {
		driver.findElement(RegYear1).click();
	}
	public void UserName(String name){		
		driver.findElement(UserName1).sendKeys(name);

	}
	public void UserMail(String mail) {		
		driver.findElement(UserEmail1).sendKeys(mail);
	}
	public void ErrorMesg1() {
		String str= driver.findElement(ErrorMsg1).getText();
		System.out.println(str);
	}
	
	//UI-2 Methods
	public void CarBrand2(String car_name){
		
//		try {
//			Thread.sleep(1000);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}

		driver.findElement(Bmw2).click();
		driver.findElement(Bmw2).sendKeys(car_name);
	}
	public void carSeries2() {
		driver.findElement(CarName2).click();
	}
	public void FuelType2() {
		driver.findElement(FuelType2).click();
	}
	public void CarVariant2() {
		driver.findElement(Variant2).click();
	}
	public void carRegsYear2() {
		driver.findElement(RegYear2).click();
	}
	public void userName2(String name) {				
		driver.findElement(userName2).sendKeys(name);
	}
	public void usermail2(String mail) {				
		driver.findElement(UserEmail2).sendKeys(mail);
	}
	public void Errormsg2() {
		String str= driver.findElement(ErrorMsg2).getText();
		System.out.println(str);
	}
	
	//Common UI locators:
	public By CarInsurance = By.xpath("//p[text()='Car']");
	public By Proceedbtn = By.xpath("//a[@class='btn-proceed']");
	public By city = By.id("spn9");

	public void ProceedWithoutCar() {
		driver.findElement(Proceedbtn).click();	
	}
	public void SelectCity() {
		driver.findElement(city).click();
	}
	public void SelCarIns() {
		driver.findElement(CarInsurance).click();
	}

}