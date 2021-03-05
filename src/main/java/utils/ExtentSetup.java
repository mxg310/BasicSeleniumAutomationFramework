package utils;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import testBase.ObjectsRepo;

public class ExtentSetup extends ObjectsRepo {

	public static ExtentReports setupExtentReport() {
		SimpleDateFormat fmt = new SimpleDateFormat("dd-MM-YYYY-HH-mm-ss");
		Date dt = new Date();
		String date_time = fmt.format(dt);
		
		String reportPath = System.getProperty("user.dir") + "/Reports/ExecutionReport" + date_time + ".html";
		ExtentSparkReporter spark = new ExtentSparkReporter(reportPath);
		extentReport = new ExtentReports();
		extentReport.attachReporter(spark);
		
		spark.config().setDocumentTitle("Document Title");
		spark.config().setTheme(Theme.DARK);
		spark.config().setReportName("Test Report Name");
		
		return extentReport;
	}
}
