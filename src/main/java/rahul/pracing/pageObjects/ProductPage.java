package rahul.pracing.pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import rahul.pracing.AbstractComponents.AbstarctParent;

public class ProductPage extends AbstarctParent{
	
	WebDriver driver;
	
	public ProductPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css=".mb-3")
	List<WebElement> products;
	
	@FindBy(css=".ng-animating")
	WebElement spinner;
	
	
	By productsBy = By.cssSelector(".mb-3");
	By addToProdCart = By.cssSelector(".card-body button:last-of-type");
	By toastMessageAppear = By.id("toast-container");
	
	public List<WebElement> getProductList() {
		waitELementToAppear(productsBy);
		return products;
	}
	
	public WebElement getProdByName(String productName) {
		WebElement prod = getProductList().stream().filter(product -> product.findElement(By.cssSelector("b")).getText().equals(productName)).findFirst().orElse(null);
		return prod;
	}
	
	public void addToCart(String productName) {
		WebElement prod = getProdByName(productName);
		prod.findElement(addToProdCart).click();
		waitELementToAppear(toastMessageAppear);
		waitForElementToDisappear(spinner);
		
	}
	
	public void checkOut5() {
		System.out.println("Running for git 1");
	}
	
	

}
