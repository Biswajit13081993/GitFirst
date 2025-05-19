package rahul.pracing.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import rahul.pracing.AbstractComponents.AbstarctParent;

public class CheckOutPage extends AbstarctParent{
	
	WebDriver driver;
	
	public CheckOutPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="(//input[@class='input txt'])[1]")
	WebElement cvv;
	
	@FindBy(css="[placeholder='Select Country']")
	WebElement selectCountry;
	
	@FindBy(css=".ta-item:last-of-type")
	WebElement clickCountry;
	
	@FindBy(css=".actions a")
	WebElement placingOrder;
	
	By visibilityCVV = By.xpath("(//input[@class='input txt'])[1]");
	By visibilityOfAllCountries = By.cssSelector(".ta-results");
	
	public void sendingCVV() {
		waitForWebElementToAppear(cvv);
		cvv.sendKeys("1234");
	}
	
	public void actionsToConfirm(String countryName) {
		Actions a = new Actions(driver);
		a.sendKeys(selectCountry, countryName).build().perform();
		waitELementToAppear(visibilityOfAllCountries);
		clickCountry.click();
		placingOrder.click();
	}
	
	public void checkOut2() {
		System.out.println("Running for git 4");
	}
	

}
