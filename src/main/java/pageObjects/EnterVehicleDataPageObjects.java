package pageObjects;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import testBase.TestBase;

public class EnterVehicleDataPageObjects extends TestBase {

	String title = "Enter Vehicle Data";

	@FindBy(id = "make")
	WebElement sel_make;

	@FindBy(id = "model")
	WebElement sel_model;

	@FindBy(id = "engineperformance")
	WebElement txt_engineperformance;

	@FindBy(id = "cylindercapacity")
	WebElement txt_cylindercapacity;

	@FindBy(xpath = "//input[@id='cylindercapacity']/following-sibling::span[@class='error']")
	WebElement err_cylindercapacity;

	@FindBy(id = "dateofmanufacture")
	WebElement date_dateofmanufacture;

	// numberofseats -- numberofseatsmotorcycle
	@FindBy(id = "numberofseatsmotorcycle")
	WebElement sel_numberofseats;

	@FindBy(id = "fuel")
	WebElement sel_fuel;

	@FindBy(id = "listprice")
	WebElement txt_listprice;

	@FindBy(id = "licenseplatenumber")
	WebElement txt_licenseplatenumber;

	@FindBy(id = "annualmileage")
	WebElement txt_annualmileage;

	@FindBy(id = "nextenterinsurantdata")
	WebElement btn_nextenterinsurantdata;

	// initialize Page Objects
	public EnterVehicleDataPageObjects() {
		PageFactory.initElements(driver, this);
	}

	public void enterCylinderCapacity(String value) {
		txt_cylindercapacity.sendKeys(value);
	}

	public String getErrorMessageOnCylinderCapacity() {
		return err_cylindercapacity.getText();
	}

	public List<String> getDropdownOptions_model() {
		return cm.getDropdownOptions_asList(sel_model);
	}

	public List<String> getDropdownOptions_make() {
		return cm.getDropdownOptions_asList(sel_make);
	}
	
	public void enterVehicleData() throws Exception {
		// get the values from excel - TODO
		cm.selectDropdownOption(sel_make, "BMW");
		cm.selectDropdownOption(sel_model, "Moped");
		txt_cylindercapacity.sendKeys("333");
		txt_engineperformance.sendKeys("555");
		date_dateofmanufacture.sendKeys("12/12/2006");
		cm.selectDropdownOption(sel_numberofseats, "2");
		txt_listprice.sendKeys("1000");
		txt_annualmileage.sendKeys("555");		
	}
	
	public void next() {
		btn_nextenterinsurantdata.click();
	}
}
