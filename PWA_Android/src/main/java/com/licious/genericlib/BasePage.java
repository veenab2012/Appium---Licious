package com.licious.genericlib;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Coordinates;
import org.openqa.selenium.interactions.Locatable;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.FindsByAndroidUIAutomator;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public abstract class BasePage {
	
	protected static AppiumDriver<MobileElement> _driver;
	public static WebDriverWait webdriverWait;

	protected BasePage(AppiumDriver<MobileElement> driver){
        _driver = driver;
        webdriverWait = new WebDriverWait(_driver, 15);
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }
	
	public static void customWait(int seconds) {
		
		try {
			
			Thread.sleep(seconds*1000);
			
		} catch(InterruptedException e) {
			
			e.printStackTrace();
		}		
		
	}
	
	public static void scrollByText(String text) {		
		
		((FindsByAndroidUIAutomator<MobileElement>) _driver).findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textContains(\""+text+"\").instance(0))").click();
	       
	}
	
	public static void scrollToElement(MobileElement element) {
		
		JavascriptExecutor js = (JavascriptExecutor) _driver;
        HashMap<String, String> swipeObject = new HashMap<String, String>();
        swipeObject.put("direction", "down");
        swipeObject.put("element", ((RemoteWebElement) element).getId());
        js.executeScript("mobile: swipe", swipeObject);
        customWait(5000);

	}
	
	public boolean clickBtn(MobileElement productNameLink) {
		
        try {
        	productNameLink.click();
            return true;
            
        } catch (NoSuchElementException s) {
        	
        	return false;
        }
     }
	
	 public MobileElement getElementWithDynamicXpath(String xpathValue, String ... replaceValues) {
		int i = 1;
		for(String replaceValue : replaceValues) {
		             xpathValue = xpathValue.replace("x"+i, replaceValue);
		             i++;
		}
		System.out.println("Final Dynamic XPath value = "+xpathValue);
		List<MobileElement> list = _driver.findElements(By.xpath(xpathValue));
		if (list.size() == 0)
		             return null;
		return list.get(0);
		}
	 	
	 
	 public WebElement waitUntil(ExpectedCondition<?> expectedCondition, Class<?>... classes) {
		 
	
		FluentWait<WebDriver> wait = webdriverWait.pollingEvery(2, TimeUnit.SECONDS).withTimeout(60, TimeUnit.SECONDS);
		
		if (classes != null) {
			
			for (Class c : classes) {
				
		        wait.ignoring(c);
		        
			}
		             
		}
		return (WebElement) wait.until(expectedCondition);
	 }
	 
}                

