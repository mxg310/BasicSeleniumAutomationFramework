package pageObjects;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import testBase.TestBase;

public class EnterInsuranceDataPageObjects extends TestBase {

	String title = "Enter Insurant Data";

	@FindBy(id = "firstname")
	WebElement txt_firstname;

	@FindBy(id = "lastname")
	WebElement txt_lastname;

	@FindBy(id = "birthdate")
	WebElement date_birthdate;

	// gender (radio button)
	@FindBy(xpath = "//input[@name='Gender']/parent::label")
	List<WebElement> rdo_gender;

	@FindBy(id = "streetaddress")
	WebElement txt_streetaddress;

	@FindBy(id = "country")
	WebElement sel_country;

	@FindBy(id = "zipcode")
	WebElement txt_zipcode;

	@FindBy(id = "city")
	WebElement txt_city;

	@FindBy(id = "occupation")
	WebElement sel_occupation;

	// Hobbies (Check boxes)
	@FindBy(xpath = "//input[@name='Hobbies']//parent::label")
	List<WebElement> chk_hobbiew;

	@FindBy(id = "website")
	WebElement txt_website;

	@FindBy(id = "picture")
	WebElement txt_picture;

	@FindBy(id = "open")
	WebElement btn_open;

	@FindBy(id = "preventervehicledata")
	WebElement btn_preventervehicledata;

	@FindBy(id = "nextenterproductdata")
	WebElement btn_nextenterproductdata;

	// initialize Page Objects
	public EnterInsuranceDataPageObjects() {
		PageFactory.initElements(driver, this);
	}
	
	public void enterInsuranceData() throws Exception {
		txt_firstname.sendKeys("Murali");
		txt_lastname.sendKeys("krishna");
		date_birthdate.sendKeys("12/12/1987");
		cm.selectRadioOption(rdo_gender, "Male");
		cm.selectDropdownOption(sel_country, "India");
		txt_zipcode.sendKeys("560098");
		cm.selectDropdownOption(sel_occupation, "Farmer");		
		// select check-box
		cm.selectCheckBoxes(chk_hobbiew, "Speeding,Other");
		// upload-picture (TODO)
		
	}
	
	public void next() {
		btn_nextenterproductdata.click();
	}
}
