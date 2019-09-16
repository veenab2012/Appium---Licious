package com.licious.genericlib;

/**
 * @author Veena Basawa
 *
 */

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;

//import com.relevantcodes.extentreports.ExtentReports;
//import com.relevantcodes.extentreports.ExtentTest;
//import com.relevantcodes.extentreports.LogStatus;

import com.aventstack.extentreports.ExtentReporter;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import org.apache.log4j.Logger;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.LocksDevice;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

@Listeners(TestListener.class)
public abstract class BaseTest implements IConstants {
	
	public static ExtentReports extRpt;
	public static ExtentTest extTest;
//	public Log log1;
//	public Logger log;
	
	public static Properties properties;
	public static AppiumDriver<MobileElement> driver;
	public static AppiumDriverLocalService service;
	public static AppiumServiceBuilder builder;
	public static DesiredCapabilities capabilities;
	public static String serverIP = null;
	
	
	@BeforeSuite
	public void setUp() throws Exception{
		
//		log=Logger.getLogger(this.getClass());
		
//		extRpt=new ExtentReports(EXTENTREPORTS_FILEPATH);
//		extRpt.addSystemInfo("Host Name", "Licious");
//		extRpt.addSystemInfo("Environment", "Appium");
//		extRpt.addSystemInfo("User Name", "Veena Basawa");	
		
//		extRpt=ExtentManager.GetExtent();
				
		Log.info("Starting Appium server");
		
		serverIP = "127.0.0.1";		
		builder = new AppiumServiceBuilder();
		builder.usingPort(4723);	
		builder.withIPAddress(serverIP);
		builder.withLogFile(new File("./AppiumServerLogs/AppiumServerLogs1.txt"));	
		
		service = AppiumDriverLocalService.buildService(builder);		
		if(service.isRunning()==true) {
			Reporter.log("Appium server is already running, Stop and Start",true);
			service.stop();
			StdUtil.customWait(10);
		}
		service.start();		
		StdUtil.customWait(10);		
		Log.info("Appium Server started");
	}
	
	
	@BeforeTest
	public void beforeTest() throws InterruptedException, MalformedURLException{
		
//		logger=extRpt.startTest(m.getName());		
		properties=PropertyLoader.getPropertyObj();		
		
		File filePath = new File(System.getProperty("user.dir"));
		File appDir = new File(filePath, "/BuildFiles");
//		File app = new File(appDir, "3.4.11.1004.apk");
		File app = new File(appDir, "3.4.20.105.apk");
		
		capabilities=new DesiredCapabilities();
		
//		capabilities.setCapability("automationName","Appium");
		capabilities.setCapability("platformName", properties.getProperty("PLATFORM"));//"Android");
		capabilities.setCapability("deviceName", properties.getProperty("DEVICENAME"));//"Veena_Nexus5_Nougat");		
		capabilities.setCapability("platformVersion", properties.getProperty("PLATFORMVERSION"));//"7.0");
		capabilities.setCapability("avd","Veena_Nexus5_Nougat");
		capabilities.setCapability("app",app.getAbsolutePath());
		
		capabilities.setCapability("clearSystemFiles",true);
//		capabilities.setCapability("noReset",true);
		
		driver= new AndroidDriver<MobileElement>(new URL("http://" + serverIP + ":4723/wd/hub"),capabilities);
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		((LocksDevice) driver).unlockDevice();
//		andDriver.resetApp();
		
		Reporter.log(driver.getSessionDetails().toString(),true);
		Log.info("App is launched");
//		logger.log(LogStatus.PASS,"App is launched");
	}
	
	
	@BeforeMethod
	public void beforeMethod(Method m) throws InterruptedException, MalformedURLException{
		
//		extTest=extRpt.createTest(m.getName(),m.toString());	
		
		
//		properties=PropertyLoader.getPropertyObj();		
//		
//		File filePath = new File(System.getProperty("user.dir"));
//		File appDir = new File(filePath, "/BuildFiles");
//		File app = new File(appDir, "3.4.11.1004.apk");
//		
//		capabilities=new DesiredCapabilities();
//		
////		capabilities.setCapability("automationName","Appium");
//		capabilities.setCapability("platformName", properties.getProperty("PLATFORM"));//"Android");
//		capabilities.setCapability("deviceName", properties.getProperty("DEVICENAME"));//"Veena_Nexus5_Nougat");		
//		capabilities.setCapability("platformVersion", properties.getProperty("PLATFORMVERSION"));//"7.0");
//		capabilities.setCapability("avd","Veena_Nexus5_Nougat");
//		capabilities.setCapability("app",app.getAbsolutePath());
//		
//		capabilities.setCapability("clearSystemFiles",true);
////		capabilities.setCapability("noReset",true);
//		
//		driver= new AndroidDriver<MobileElement>(new URL("http://" + serverIP + ":4723/wd/hub"),capabilities);
//		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
//		((LocksDevice) driver).unlockDevice();
////		andDriver.resetApp();
//		
//		Reporter.log(driver.getSessionDetails().toString(),true);
		Log.info("Test method started");
//		extTest.log(LogStatus.PASS, "App is launched");
//		extTest.log(LogStatus.PASS,"App is launched");
	}
	
//	@AfterMethod
//	public void afterMethod(ITestResult result) throws IOException {
//		
//		
//		if(result.getStatus()==ITestResult.SUCCESS){
//					
//			Log.info(result.getName() + " is PASSED");
//			extTest.log(LogStatus.PASS,result.getName() + " is PASSED");
//		}
//		else{
//			
//			Log.info(result.getName() + " is FAILED");
//			logger.log(LogStatus.FAIL, result.getName() + " is FAILED");
//			logger.log(LogStatus.FAIL, logger.addBase64ScreenShot(StdUtil.takeScreenShot(driver)));
//			
//		}		
		
//		extRpt.endTest(logger);
		
//		if (driver != null) {
//			driver.close();		
//		}
		
//	}

	
	@AfterSuite
	public void tearDown() throws InterruptedException{
		
		driver.closeApp();
		service.stop();
//		extRpt.flush();			
	}
}