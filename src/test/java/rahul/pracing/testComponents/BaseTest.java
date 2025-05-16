package rahul.pracing.testComponents;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import rahul.pracing.pageObjects.landingPage;

public class BaseTest {
	
	public WebDriver driver;
	public landingPage landOnPage;
	
	public WebDriver initializeBrowser() throws IOException {
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir") +"\\src\\main\\java\\rahul\\pracing\\resources\\GlobalData.properties");
		prop.load(fis);
		String browserName = prop.getProperty("browser");
		
		if(browserName.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		}
		
		else if(browserName.equalsIgnoreCase("edge")) {
			driver = new EdgeDriver();
		}
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		return driver;
	}
	
	public List<HashMap<String, String>> getJsonToMap(String filePath) throws IOException {
		
		String jsonContent = FileUtils.readFileToString(new File(filePath), StandardCharsets.UTF_8);
		ObjectMapper map = new ObjectMapper();
		List<HashMap<String, String>> data = map.readValue(jsonContent, new TypeReference<List<HashMap<String, String>>>(){});
		return data;
	}
	
	@BeforeMethod(alwaysRun=true)
	public landingPage landOn() throws IOException {
		driver = initializeBrowser();
		landOnPage = new landingPage(driver);
		landOnPage.goTo();
		return landOnPage;
	}
	
	@AfterMethod(alwaysRun=true)
	public void exitFromBrowser() {
		driver.close();
	}

}
