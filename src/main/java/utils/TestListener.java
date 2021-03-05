package utils;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.Status;

import testBase.TestBase;

public class TestListener extends TestBase implements ITestListener {

	@Override
	public void onFinish(ITestContext context) {
		// close extent
		extentReport.flush();
	}

	@Override
	public void onStart(ITestContext context) {
		// setup
		extentReport = ExtentSetup.setupExtentReport();
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {

	}

	@Override
	public void onTestFailure(ITestResult result) {
		test.log(Status.FAIL, result.getMethod().getMethodName() + " is FAIL");
		test.log(Status.FAIL, result.getThrowable());
		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String screenPath = System.getProperty("user.dir") + "/Reports/screenshots/"
				+ result.getMethod().getMethodName() + ".jpeg";
		File dest = new File(screenPath);

		try {
			FileUtils.copyFile(src, dest);
		} catch (IOException e) {
			e.printStackTrace();
		}

		test.addScreenCaptureFromPath(screenPath, "Failed reason - screenshot");
	}

	@Override
	public void onTestSkipped(ITestResult result) {

	}

	@Override
	public void onTestStart(ITestResult result) {
		test = extentReport.createTest(result.getMethod().getMethodName());
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		test.log(Status.PASS, result.getMethod().getMethodName() + " is PASS");
	}

}
