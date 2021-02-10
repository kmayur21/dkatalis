package com.dkatalis.listeners;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.dkatalis.base.TestBase;
import com.dkatalis.utilities.TestUtils;

public class CustomListeners extends TestBase implements ITestListener {

	
	
	@Override
	public void onTestStart(ITestResult result) {
		String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());//time stamp
		String reportName="Test-Report-"+timeStamp+".html";
		
		HTMLreporter=new ExtentHtmlReporter(System.getProperty("user.dir")+ "/test-output/testReport/"+reportName);//specify location of the report
		HTMLreporter.loadXMLConfig(System.getProperty("user.dir")+ "/ExtentConfig.xml");
		
		extent=new ExtentReports();
		
		extent.attachReporter(HTMLreporter);
		extent.setSystemInfo("Host name","localhost");
		extent.setSystemInfo("Environemnt","QA");
		extent.setSystemInfo("User","Mayur");
		
		HTMLreporter.config().setDocumentTitle("Fit Flop Test Project"); // Tile of report
		HTMLreporter.config().setReportName("Functional Test Automation Report"); // name of the report
		//HTMLreporter.config().setTestViewChartLocation(ChartLocation.TOP); //location of the chart
		HTMLreporter.config().setTheme(Theme.DARK);
		
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		test=extent.createTest(result.getName()); // create new entry in th report
		test.log(Status.PASS,MarkupHelper.createLabel(result.getName(),ExtentColor.GREEN)); // send the passed information to the report with GREEN color highlighted
		
		
	}

	@Override
	public void onTestFailure(ITestResult result) {
		
		System.setProperty("org.uncommons.reportng.escape-output", "false");
		try {
			TestUtils.captureScreenshot();
		}catch(Exception e){
			e.printStackTrace();
		}
		
		test=extent.createTest(result.getName()); // create new entry in th report
		test.log(Status.FAIL,MarkupHelper.createLabel(result.getName(),ExtentColor.RED));
		test=extent.createTest(result.getName());
		test.log(Status.FAIL,"Test Cases fails are " +result.getName());// get name is used to add name of the method in the report.
		test.log(Status.FAIL, "Test case fails "+result.getThrowable());
//		Reporter.log("Capturing the screenshot");
//		
//		Reporter.log("<a target=\"_blank\" href="+TestUtils.screenshotName+">Screenshot</a>");
//		Reporter.log("<br>");
		//setting this value to false will escape the text generation and it will generate the report.
		//Reporter.log("<a target=\"_blank\" href="+TestUtils.screenshotName+">Screenshot</a>");
		
		
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onFinish(ITestContext context) {
		extent.flush();
		
	}
	
	
	
	

}
