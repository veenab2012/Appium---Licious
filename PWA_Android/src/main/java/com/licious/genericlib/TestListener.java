package com.licious.genericlib;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class TestListener implements ITestListener{
	
	public ExtentReports report;
	public ExtentTest ExtentTest;
//	private static File dir;
//    public static ExtentReports report;
//    public static ExtentTest ExtentTest;
//    //public static ExtentHtmlReporter htmlReporter;
//    public static String filepath = getDateFolder() + "/" + "APIAUTOMATION " + getDate();


//    public static String getDate() {
//        DateFormat dateFormat = new SimpleDateFormat("YYYY_MM_dd_HH_mm");
//        Date date = new Date();
//        return dateFormat.format(date);
//    }
//
//    public static File getDateFolder() {
//        DateFormat dateFromat = new SimpleDateFormat("YYYY_MM_dd");
//        Date date = new Date();
//        String dateString = dateFromat.format(date);
//        dir = new File("/ExtentReport/" + dateString);
//        if (!dir.exists())
//            dir.mkdir();
//        return dir;
//    }

	//ExtentTest extTest;
	
    public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
    	report=ExtReportManager.GetExtentReport();
//		String createfolder = getDateFolder() + "/" + "APPIUMAUTOMATION" + getDate() ;
//        report = new ExtentReports(System.getProperty("user.dir") + createfolder + ".html",false);
//        
//        report.addSystemInfo("Host Name", "Licious");
//        report.addSystemInfo("Environment", "Appium");
//        report.addSystemInfo("User Name", "Veena Basawa");	
		
	}
    

    public void onTestStart(ITestResult result) {
		System.out.println(result.getName() + " is started");
		Log.info(result.getName() + " is started");
		ExtentTest= ExtReportManager.startTest(result.getName());
	}

	public void onTestSuccess(ITestResult result) {
		
//		ExtentTest = report.startTest(result.getName());
		
//		ExtentTest= ExtReportManager.startTest(result.getName());
		System.out.println(result.getName() + " has Passed");
		Log.info(result.getName() + " has Passed");
		ExtentTest.log(LogStatus.PASS, result.getName() + " Has Passed ");
		
		report.endTest(ExtentTest);
	    report.flush();
	
	}

	public void onTestFailure(ITestResult result) {
		
//		ExtentTest = report.startTest(result.getName());
		
//		ExtentTest= ExtReportManager.startTest(result.getName());
		System.out.println(result.getName() + "Test is Failed");
		Log.info(result.getName() + "Test is Failed");
		
		try {
			ExtentTest.log(LogStatus.FAIL, ExtentTest.addBase64ScreenShot(StdUtil.takeScreenShot()));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		 ExtentTest.log(LogStatus.FAIL, " Has Failed Test Case " + result.getThrowable());
	     ExtentTest.log(LogStatus.FAIL, " Has Failed Test Case " + result.getName());
	     
	     report.endTest(ExtentTest);
	     report.flush();

//		StdUtil.captureScreenShot();
		
//		if(result.getStatus()==ITestResult.SUCCESS){
//			
//			//log.info(result.getName() + " is " + result.getStatus());
//			extTest.log(LogStatus.PASS,"result.getName() + \" is \" + result.getStatus()");
//		}
//		else{
//			extTest.log(LogStatus.FAIL, result.getName() + " is " + result.getStatus());			
//			extTest.log(LogStatus.FAIL, extTest.addScreenCapture(CommUtil.getScreenshotspath()));
//		}
		
				
	}

	public void onTestSkipped(ITestResult result) {
		System.out.println(result.getName() + "Test is Skipped");
		Log.info(result.getName() + "Test is Skipped");		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub

		
		report.close();
		
		
		
	}

}
