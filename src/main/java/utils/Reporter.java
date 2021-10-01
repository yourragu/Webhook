package utils;

import java.io.IOException;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class Reporter {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		
		//Create physical report
		ExtentHtmlReporter reporter = new ExtentHtmlReporter("./reports/result.html");
		
		//To see history
		reporter.setAppendExisting(false);
		
		//Create actual report data
		ExtentReports extent  = new ExtentReports();
		
		//Attach the extent data to physical report
		extent.attachReporter(reporter);
		
		//Create test case with details
		ExtentTest test = extent.createTest("Google Website","Launched google website");
		test.assignAuthor("Ragunath");
		test.assignCategory("Regrssion");
		
		//Test step status
		test.pass("Successfully Passed",MediaEntityBuilder.createScreenCaptureFromPath(".././snaps/login.png").build());
		extent.flush();
		
		
		
		

	}

}
