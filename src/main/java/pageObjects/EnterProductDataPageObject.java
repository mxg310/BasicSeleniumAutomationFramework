package pageObjects;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import testBase.TestBase;

public class EnterProductDataPageObject extends TestBase {

	String title = "Enter Product Data";

	@FindBy(xpath = "//input[@id='startdate']")
	WebElement txt_startdate;

	@FindBy(id = "openstartdatecalender")
	WebElement cal_openstartdatecalender;

	@FindBy(id = "insurancesum")
	WebElement sel_insurancesum;

	@FindBy(id = "meritrating")
	WebElement sel_meritrating;

	@FindBy(id = "damageinsurance")
	WebElement sel_damageinsurance;

	// gender (radio button)
	@FindBy(xpath = "//input[@name='Optional Products[]']//parent::label")
	List<WebElement> chk_optionalProductsr;

	@FindBy(id = "courtesycar")
	WebElement sel_courtesycar;

	@FindBy(id = "preventerinsurancedata")
	WebElement btn_preventerinsurancedata;

	@FindBy(id = "nextselectpriceoption")
	WebElement btn_nextselectpriceoption;

	// initialize Page Objects
	public EnterProductDataPageObject() {
		PageFactory.initElements(driver, this);
	}
	
	public void enterProductData() throws Exception {
		
		cm.selectDropdownOption(sel_insurancesum, "5.000.000,00");
		cm.selectDropdownOption(sel_damageinsurance, "Full Coverage");
		cm.selectCheckBoxes(chk_optionalProductsr, "Euro Protection");
		txt_startdate.sendKeys("02/02/2022");
	}
	
	public void next() {
		btn_nextselectpriceoption.click();
	}
}
