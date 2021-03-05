package testBase;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import io.github.bonigarcia.wdm.WebDriverManager;
import pageObjects.EnterInsuranceDataPageObjects;
import pageObjects.EnterProductDataPageObject;
import pageObjects.EnterVehicleDataPageObjects;
import pageObjects.HomeObjects;
import pageObjects.SelectPriceOptionsPageObjects;
import utils.PropertiesReader;

public class TestBase extends ObjectsRepo {

	@SuppressWarnings("deprecation")
	public WebDriver launcgAndNavigate() throws Exception {

		// read properties file and read browser and url

		String browser = PropertiesReader.getPropertyValueByKey("browser");
		String url = PropertiesReader.getPropertyValueByKey("url");

		if (browser.equalsIgnoreCase("chrome")) {
			// launch Browser
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		} else if (browser.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		} else if (browser.equalsIgnoreCase("ie")) {
			WebDriverManager.iedriver();
			driver = new InternetExplorerDriver();
		} else if (browser.equalsIgnoreCase("edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		}

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		// navigate to URL
		driver.get(url);

		return driver;
	}

	// open browser and navigate to URL
	// login
	@BeforeMethod
	public void setupMethodI() {
		try {
			launcgAndNavigate();
			homePage = new HomeObjects();
			vehicleData = new EnterVehicleDataPageObjects();
			productData = new EnterProductDataPageObject();
			insuranceData = new EnterInsuranceDataPageObjects();
			priceOptions = new SelectPriceOptionsPageObjects();
		} catch (Exception e) {
			//
			e.printStackTrace();
		}
	}

	// logout and close
	@AfterMethod
	public void cleanup() {
		// driver.close();
	}

}
