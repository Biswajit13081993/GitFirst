package rahul.pracing.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import rahul.pracing.AbstractComponents.AbstarctParent;

public class CoonfirmationPage extends AbstarctParent{
	
	WebDriver driver;
	
	public CoonfirmationPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css=".hero-primary")
	WebElement confirmationText;
	
	public String gettingConfirmationText() {
		return confirmationText.getText();
	}
	
	public void checkOut3() {
		System.out.println("Running for git 3");
	}

}
