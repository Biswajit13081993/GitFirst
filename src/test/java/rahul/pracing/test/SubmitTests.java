package rahul.pracing.test;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import rahul.pracing.pageObjects.CartingPage;
import rahul.pracing.pageObjects.CheckOutPage;
import rahul.pracing.pageObjects.CoonfirmationPage;
import rahul.pracing.pageObjects.ProductPage;
import rahul.pracing.testComponents.BaseTest;
//import rahulshettyacademy.pageobjects.LandPage;

public class SubmitTests extends BaseTest{
	
	String productName = "ADIDAS ORIGINAL";
	
	@Test(dataProvider="getData")
	public void submitOrder(HashMap<String, String> input) {
		ProductPage productCata = landOnPage.userAction(input.get("userMail"), input.get("password"));
		productCata.getProductList();
		productCata.addToCart(input.get("productName"));
		productCata.goToCartButton();
		CartingPage cartPage = new CartingPage(driver);
		boolean match = cartPage.verifyProductDisplay(input.get("productName"));
		Assert.assertTrue(match);
		cartPage.checkOut();
		CheckOutPage checkOut = new CheckOutPage(driver);
		checkOut.sendingCVV();
		checkOut.actionsToConfirm("India");
		CoonfirmationPage confirmPage = new CoonfirmationPage(driver);
		String text = confirmPage.gettingConfirmationText();
		Assert.assertTrue(text.equalsIgnoreCase("Thankyou for the order."));
	}

		@DataProvider
		public Object[][] getData() throws IOException {
			List<HashMap<String, String>> data = getJsonToMap(System.getProperty("user.dir") +"\\src\\test\\java\\rahul\\pracing\\data\\PurchaseOrderData.json");
			return new Object[][] {{data.get(0)}, {data.get(1)}};
		}


}
