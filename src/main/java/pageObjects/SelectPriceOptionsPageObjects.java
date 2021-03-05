package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import testBase.TestBase;

public class SelectPriceOptionsPageObjects extends TestBase {

	@FindBy(id="nextsendquote")
	WebElement btn_nextsendquote;
	
	// init
	public SelectPriceOptionsPageObjects() {
		PageFactory.initElements(driver, this);
	}

	public String getPriceForOption(String plan) {
		// //table[@id='priceTable']/tbody/tr[1]/td[@data-label='Silver']/span
		// //span[@name='outpremium']/parent::td[@data-label='Silver']/span
		String dataXpath = "//span[@name='outpremium']/parent::td[@data-label='" + plan + "']/span";
		return driver.findElement(By.xpath(dataXpath)).getText();
	}
	
	public void selectPriceOption(String plan) {
		String dataXpath = "//input[@name='Select Option' and @value='"+ plan + "']/parent::label";
		driver.findElement(By.xpath(dataXpath)).click();
	}
	
	public void next() {
		btn_nextsendquote.click();
	}
}
