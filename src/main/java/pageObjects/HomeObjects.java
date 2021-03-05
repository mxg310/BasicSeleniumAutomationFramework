package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import testBase.TestBase;

public class HomeObjects extends TestBase {

	@FindBy(id = "nav_automobile")
	WebElement link_automobile;

	@FindBy(id = "nav_truck")
	WebElement link_truck;

	@FindBy(id = "nav_motorcycle")
	WebElement link_motorcycle;

	@FindBy(id = "nav_camper")
	WebElement link_camper;

	// initElement
	public HomeObjects() {
		PageFactory.initElements(driver, this);
	}
	
	//for clicking on Motorcycle link
	public void clickOnMotorCycleLink() {
		link_motorcycle.click();
	}
}
