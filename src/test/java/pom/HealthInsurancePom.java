package pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HealthInsurancePom {
	
	WebDriver driver;
	
	public By insurance_product = By.xpath("//a[text()='Insurance Products ']");
    
	public By all_links = By.xpath("//div[@class=\"ruby-row\"]/div[3]/ul/li/a");
	
//	public HealthInsurancePom(WebDriver driver){
//		this.driver = driver;
//	}
	
}
