package insuranceCalc_Motorcycle;

import static org.testng.Assert.assertEquals;

import java.util.Arrays;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import testBase.TestBase;

public class ErrorTests_Motorcycle extends TestBase {

	@Test(enabled = false)
	public void errorMessage_PayloadField_case1() {
		// verify error message if value is more than 2000 for cylinder capacity

		// open and navigate (part of setup)

		// click Motorcycle on Home Page
		homePage.clickOnMotorCycleLink();

		// enter cylinder capacity
		vehicleData.enterCylinderCapacity("3333");

		test.log(Status.PASS, "Capacity is filled with 3333");

		// validate error message
		assertEquals(vehicleData.getErrorMessageOnCylinderCapacity(), "Must be a number between 1 and 2000",
				"Expected error messange is not as Expected on cylinder capacity field");
	}

	@Test(enabled = false)
	public void errorMessage_PayloadField_case2() {
		// verify error message if value is more than 2000 for cylinder capacity

		// open and navigate (part of setup)

		// click Motorcycle on Home Page
		homePage.clickOnMotorCycleLink();

		// enter cylinder capacity
		vehicleData.enterCylinderCapacity("2000");

		test.log(Status.PASS, "Capacity is filled with 2000");

		// validate error message
		assertEquals(vehicleData.getErrorMessageOnCylinderCapacity(), "Must be a number between 1 and 2000",
				"Expected error messange is not as Expected on cylinder capacity field");
	}

	@Test(enabled = true)
	public void verifyModelDropDownOptions() {
		// click motorcycle link
		homePage.clickOnMotorCycleLink();

		// get dropdown content
		List<String> actualValues = vehicleData.getDropdownOptions_model();
		
		test.log(Status.INFO, "Actual drop down contents ::" + actualValues);
		// compare - assert
		List<String> expectedValues = Arrays.asList("– please select –", "Scooter", "Three-Wheeler", "Moped",
				"Motorcycle");
		test.log(Status.INFO, "Expected drop down contents ::" + expectedValues);
		
		Assert.assertEquals(actualValues, expectedValues, "Error in Drop-Down options");
	}
}
