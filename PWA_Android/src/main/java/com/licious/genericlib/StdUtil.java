package com.licious.genericlib;

import java.awt.Dimension;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

import javax.imageio.ImageIO;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.FindsByAndroidUIAutomator;
import io.appium.java_client.MobileDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;


public class StdUtil extends BaseTest implements IConstants{
	
	
	
	public static void tapwithCoordinates(AndroidDriver andDriver,int xOffset,int yOffset) {
		
		TouchAction clicktap=new TouchAction(andDriver);	
		clicktap.tap(new PointOption().withCoordinates(170, 450)).perform();
	}
	
	public  static String getScreenshotspath() {
		
		return SCREENSHOTS_PATH;
	}
	
	public static void captureScreenShot() {
	
	try {
		Robot r=new Robot();
		
		BufferedImage image= r.createScreenCapture(new Rectangle(Toolkit.getDefaultToolkit().getScreenSize()));		
		ImageIO.write(image,"png",new File(SCREENSHOTS_PATH));
		customWait(5);
		
		
		//System.out.println(SCREENSHOTS_PATH);
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	
	}
	
	 public static String takeScreenShot() throws IOException { //AppiumDriver<MobileElement> driver
			
//			TakesScreenshot screenshot = (TakesScreenshot) driver;
//		    File source = screenshot.getScreenshotAs(OutputType.FILE);
//		    String destination = "./Screenshots/" +StdUtil.getSimpleDate()+ ".png";
//		    File finalDestination = new File(destination);
//		    FileUtils.copyFile(source, finalDestination);
//		    customWait(5);
//		    return finalDestination.toString();
		 
		 	String encodedBase64 = null;
		    FileInputStream fileInputStream = null;
		    TakesScreenshot screenshot = (TakesScreenshot) driver;
		    File source = screenshot.getScreenshotAs(OutputType.FILE);
		    String destination = "./Screenshots/" +StdUtil.getSimpleDate()+ ".png";
		    File finalDestination = new File(destination);
		    FileUtils.copyFile(source, finalDestination);

		    try {
		        fileInputStream =new FileInputStream(finalDestination);
		        byte[] bytes =new byte[(int)finalDestination.length()];
		        fileInputStream.read(bytes);
		        encodedBase64 = new String(Base64.encodeBase64(bytes));
		    }catch (FileNotFoundException e){
		        e.printStackTrace();
		    }
		    System.out.println(encodedBase64);
//		    return encodedBase64;
		    return "data:image/png;base64," + encodedBase64;
		
		}
	
	
	public static String getSimpleDate() {
		
		DateFormat dateFormat = new SimpleDateFormat("MM_dd_yyyy_HH_mm_ss");
		 
		Date date = new Date();		 
		String datenew= dateFormat.format(date);		 
		 return datenew;
		
	}
	
	public static void customWait(int seconds) {
		
		try {
			
			Thread.sleep(seconds*1000);
			
		} catch(InterruptedException e) {
			
			e.printStackTrace();
		}		
		
	}

	public static void swipe(AppiumDriver driver, String direction) {
	    org.openqa.selenium.Dimension size = driver.manage().window().getSize();
	    
	    System.out.println("Size" + size);
	    int startX = 0;
	    int endX = 0;
	    int startY = 0;
	    int endY = 0;
	    PointOption p1= new PointOption();
	    WaitOptions w1= new WaitOptions();

	    switch (direction) {
	        case "left":
	            startY = (int) (size.height / 2);
	            startX = (int) (size.width * 0.90);
	            endX = (int) (size.width * 0.10);
	            System.out.println(startY +","+startX+","+endX);
	            new TouchAction(driver)
	                    .press(p1.point(startX, startY))
	                    .moveTo(p1.point(endX, startY))
	                    .release()
	                    .perform();
	            customWait(2);
	            break;

//	        case "right":
//	            startY = (int) (size.height / 2);
//	            startX = (int) (size.width * 0.05);
//	            endX = (int) (size.width * 0.90);
//	            new TouchAction(driver)
//	                    .press(startX, startY)
//	                    .waitAction(Duration.ofMillis(duration))
//	                    .moveTo(endX, startY)
//	                    .release()
//	                    .perform();
//	            break;
//
//	        case UP:
//	            endY = (int) (size.height * 0.70);
//	            startY = (int) (size.height * 0.30);
//	            startX = (size.width / 2);
//	            new TouchAction(driver)
//	                    .press(startX, startY)
//	                    .waitAction(Duration.ofMillis(duration))
//	                    .moveTo(endX, startY)
//	                    .release()
//	                    .perform();
//	            break;
//
//
	        case "down":
	            startY = (int) (size.height * 0.70);
	            endY = (int) (size.height * 0.30);
	            startX = (size.width / 2);
	            new TouchAction(driver)
	                    .press(p1.point(startX, startY))
//	                    .waitAction(Duration.ofMillis(duration))
	                    .moveTo(p1.point(startX, endY))
	                    .release()
	                    .perform();

	            break;
	            
//	        case "left":
//	            startY = (int) (size.height / 2);
//	            startX = (int) (size.width * 0.90);
//	            endX = (int) (size.width * 0.10);
//	            System.out.println(startY +","+startX+","+endX);
//	            new TouchAction(driver)
//	                    .press(p1.point(startX, startY))
//	                    .moveTo(p1.point(endX, startY))
//	                    .release()
//	                    .perform();
//	            customWait(2);
//	            break;
	    }
	}

}
