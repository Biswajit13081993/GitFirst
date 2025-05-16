package rahul.pracing.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import rahul.pracing.AbstractComponents.AbstarctParent;

public class landingPage extends AbstarctParent{
		
	WebDriver driver;
	
	public landingPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="userEmail")
	WebElement userMail;
	
	@FindBy(id="userPassword")
	WebElement password;
	
	@FindBy(id="login")
	WebElement subButton;
	
	public ProductPage userAction(String userMailId, String userPass) {
		userMail.sendKeys(userMailId);
		password.sendKeys(userPass);
		subButton.click();
		ProductPage productCata = new ProductPage(driver);
		return productCata;
	}
	public void goTo() {
		driver.get("https://rahulshettyacademy.com/client/");	
	}

}
