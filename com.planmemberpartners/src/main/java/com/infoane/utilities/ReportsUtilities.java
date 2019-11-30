package com.infoane.utilities;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class ReportsUtilities {
	public static ExtentHtmlReporter reporter;
	public static ExtentReports extent;
	public static ExtentTest logger;

	//Initializing the Driver 
	public static WebDriver driver ;
	//Variables Initialization
	public static String browser = null;
	public static String URL = null;
	public static String path = null;
	public static String environment = null;
	public static DesiredCapabilities capability ;
	public static EdgeOptions edgeOptions;
	public static File reportPath ;
	public static String reportFolder ;


	@BeforeTest
	public void startReport(ITestContext context){
		try{
			//ExtentReports(String filePath,Boolean replaceExisting) 
			//filepath - path of the file, in .htm or .html format - path where your report needs to generate. 
			String timeStamp = new SimpleDateFormat("dd_MMM_yy-HH_mm_ss").format(Calendar.getInstance().getTime());

			String extentReportPath = System.getProperty("user.dir") +"/Reports/"+reportFolder+"/"+context.getCurrentXmlTest().getName()+"_"+timeStamp+".html";
			//replaceExisting - Setting to overwrite (TRUE) the existing file or append to it
			//True (default): the file will be replaced with brand new markup, and all existing data will be lost. Use this option to create a brand new report
			//False: existing data will remain, new tests will be appended to the existing report. If the the supplied path does not exist, a new file will be created.
			reporter = new ExtentHtmlReporter(extentReportPath);
			//loading the external xml file (i.e., extent-config.xml) which was placed under the base directory
			//You could find the xml file below. Create xml file in your project and copy past the code mentioned below
			extent = new ExtentReports();
			extent.attachReporter(reporter);
		}catch(Exception e){
			e.printStackTrace();
			Assert.fail("Failed Before Test configuration");
		}
	}
	
	@AfterMethod
	public void afterMethodConfig(ITestResult result){
		try{
			if(result.getStatus() == 1){
				SeleniumUtilities.WEB_getScreenShot(result.getName());
				logger.log(Status.PASS, "Test Case Passed is "+result.getName());
			}else if(result.getStatus() == 2){
				try{
					logger.log(Status.FAIL, "Test Case Failed is "+result.getName());
					logger.log(Status.FAIL, "Test Case Failed is "+result.getThrowable());
					DateFormat df = new SimpleDateFormat("dd-MMMM-yyyy");
					Date dateobj = new Date();
					String date=df.format(dateobj);
					DateFormat df1 = new SimpleDateFormat("hh-mm-ss");
					Date dateobj1 = new Date();
					String time=df1.format(dateobj1);

					// To create reference of TakesScreenshot
					TakesScreenshot screenshot=(TakesScreenshot)driver;

					// Call method to capture screenshot
					File src=screenshot.getScreenshotAs(OutputType.FILE);

					// Copy files to specific location 
					// result.getName() will return name of test case so that screenshot name will be same as test case name
					String dest = System.getProperty("user.dir")+"/Screenshots/"+result.getName()+"_"+environment+"_"+browser+"_"+date+"-"+time+".png";
					FileUtils.copyFile(src, new File(dest));
					logger.fail(result.getThrowable().getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(dest).build());
				}catch(Exception e){
					e.printStackTrace();
					Assert.fail("Executed 'After Method --> Failed to take Screenshot");
				}
			}else if(result.getStatus() == 3){
				logger.log(Status.SKIP, "Test Case Skipped is "+result.getName());
			}
			//Close the browser
			driver.close();
		}catch(Exception e){
			e.printStackTrace();
			Assert.fail("Failed to Execute Afer Method");
		}
	}

	public static void WEB_getScreenShot(String screenShotName){
		try{
			DateFormat df = new SimpleDateFormat("dd-MMMM-yyyy");
			Date dateobj = new Date();
			String date=df.format(dateobj);
			DateFormat df1 = new SimpleDateFormat("hh-mm-ss");
			Date dateobj1 = new Date();
			String time=df1.format(dateobj1);
			// To create reference of TakesScreenshot
			TakesScreenshot screenshot=(TakesScreenshot)driver;
			// Call method to capture screenshot
			File src=screenshot.getScreenshotAs(OutputType.FILE);
			// Copy files to specific location 
			// result.getName() will return name of test case so that screenshot name will be same as test case name
			String dest = System.getProperty("user.dir")+"/Screenshots/"+screenShotName+"_"+environment+"_"+browser+"_"+date+"-"+time+".png";
			FileUtils.copyFile(src, new File(dest));
			//logger.addScreenCaptureFromPath(dest);
			logger.pass(screenShotName, MediaEntityBuilder.createScreenCaptureFromPath(dest).build());
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	@AfterTest
	public void endReport(){
		// writing everything to document
		//flush() - to write or update test information to your report. 
		extent.flush();
	}
}
