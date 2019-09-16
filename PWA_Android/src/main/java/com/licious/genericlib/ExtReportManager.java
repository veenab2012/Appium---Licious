package com.licious.genericlib;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

//import com.aventstack.extentreports.ExtentReporter;
//import com.aventstack.extentreports.ExtentReports;
//import com.aventstack.extentreports.ExtentTest;
//import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
//import com.aventstack.extentreports.reporter.configuration.Protocol;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ExtReportManager {
	
	private static File dir;
    public static ExtentReports report;
    public static ExtentTest ExtentTest;
    public static ExtentTest test;
    //public static ExtentHtmlReporter htmlReporter;
//    public static String filepath = getDateFolder() + "/" + "APIAUTOMATION " + getDate();
	
    public static ExtentReports GetExtentReport() {
    
		String createfolder = getDateFolder() + "/" + "APPIUMAUTOMATION" + getDate() ;
	    report = new ExtentReports(System.getProperty("user.dir") + createfolder + ".html",false);
	    
	    report.addSystemInfo("Host Name", "Licious");
	    report.addSystemInfo("Environment", "Appium");
	    report.addSystemInfo("User Name", "Veena Basawa");	
	    return report;
    }
    
    public static ExtentTest startTest(String name) {
      test = report.startTest(name);
      return test;
  }

   
    
    public static String getDate() {
        DateFormat dateFormat = new SimpleDateFormat("YYYY_MM_dd_HH_mm");
        Date date = new Date();
        return dateFormat.format(date);
    }

    public static File getDateFolder() {
        DateFormat dateFromat = new SimpleDateFormat("YYYY_MM_dd");
        Date date = new Date();
        String dateString = dateFromat.format(date);
        dir = new File("/ExtentReport/" + dateString);
        if (!dir.exists())
            dir.mkdir();
        return dir;
    }


//    private static File dir;
//    private static ExtentReports report;
//    private static ExtentTest test;
//    private static ExtentHtmlReporter htmlReporter;
//    private static String filepath = getDateFolder() + "/" + "APPIUMAUTOMATION " + getDate();
//
//    public static ExtentReports GetExtent() {
//        if (report != null)
//            return report;
//        report = new ExtentReports();
//        report.attachReporter(getHtmlReporter());
//        String path = filepath.replace(".", "");
//        return report;
//    }
//
//    private static ExtentReporter getHtmlReporter() {
//        htmlReporter = new ExtentHtmlReporter(filepath + ".html");
//        htmlReporter.config().setDocumentTitle("Appium Testing");
//        htmlReporter.config().setReportName("Appium");
//        htmlReporter.config().setEncoding("utf-8");
//        htmlReporter.config().setProtocol(Protocol.HTTP);
//        return htmlReporter;
//    }
//
//    public static ExtentTest createTest(String name, String desc) {
//        test = report.createTest(name, desc);
//        return test;
//    }
//
//    public static String getDate() {
//        DateFormat dateFormat = new SimpleDateFormat("YYYY_MM_dd_HH_mm_");
//        Date date = new Date();
//        return dateFormat.format(date);
//    }
//
//    public static File getDateFolder() {
//        DateFormat dateFromat = new SimpleDateFormat("YYYY_MM_dd");
//        Date date = new Date();
//        String dateString = dateFromat.format(date);
//        dir = new File("./report/" + dateString);
//        if (!dir.exists())
//            dir.mkdir();
//        return dir;
//    }

	
	
}
