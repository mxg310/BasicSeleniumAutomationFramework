package testBase;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import pageObjects.EnterInsuranceDataPageObjects;
import pageObjects.EnterProductDataPageObject;
import pageObjects.EnterVehicleDataPageObjects;
import pageObjects.HomeObjects;
import pageObjects.SelectPriceOptionsPageObjects;
import utils.CommonMethods;

public class ObjectsRepo {

	public static HomeObjects homePage;
	public static EnterVehicleDataPageObjects vehicleData;
	public static EnterProductDataPageObject productData;
	public static EnterInsuranceDataPageObjects insuranceData;
	public static SelectPriceOptionsPageObjects priceOptions;
	
	public static ExtentReports extentReport;
	public static ExtentTest test;
	public static WebDriver driver;
	
	
	public static CommonMethods cm = new CommonMethods();
}
