package insuranceCalc_Motorcycle;

import org.testng.Assert;
import org.testng.annotations.Test;

import testBase.TestBase;

// TestNG  
// - no need of main

public class End2End_Motorcycle extends TestBase {

	@Test(enabled = true)
	public void insuranceCalculate() throws Exception {
		homePage.clickOnMotorCycleLink();
		vehicleData.enterVehicleData();
		vehicleData.next();
		insuranceData.enterInsuranceData();
		insuranceData.next();
		productData.enterProductData();
		productData.next();

		// expected
		String exp_silver = "241.00";
		// actual
		String act_silver = priceOptions.getPriceForOption("Silver");
		Assert.assertEquals(act_silver, act_silver, "Fail Case: expected :" + exp_silver + " actual:" + act_silver);
		
		priceOptions.selectPriceOption("Silver");
		priceOptions.next();
	}

	@Test(enabled = false)
	public void insuranceCalculate_VolvoMotor() {
		System.out.println(driver.getTitle());
	}

	@Test(enabled = false)
	public void insuranceCalculate_FordMotor() {
		System.out.println(driver.getCurrentUrl());
	}
}
