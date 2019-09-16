package com.licious.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import com.licious.genericlib.BasePage;
import com.licious.genericlib.ExtReportManager;
import com.licious.genericlib.Log;
import com.relevantcodes.extentreports.LogStatus;

import static com.licious.genericlib.StdUtil.*;
import static com.licious.genericlib.ExtReportManager.*;

import java.util.HashMap;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.FindsByAndroidUIAutomator;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidBy;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSFindBy;

public class HomeScreen extends BasePage {
	
	public HomeScreen(AppiumDriver<MobileElement> driver) {
		
		super(driver);
		
	}
	
	@AndroidFindBy(id="com.licious:id/tvGetStarted")
//	@iOSFindBy()
	private MobileElement getStartedbtn;
	
	@AndroidFindBy(xpath="//*[@class='android.widget.ImageView']")
//	@iOSFindBy()
	private MobileElement searchIcon;
	
	@AndroidFindBy(id="com.licious:id/etAreaSearch")
//	@iOSFindBy()
	private MobileElement searchLocationTbox;	
	
	@AndroidFindBy(id="com.licious:id/rlSearchedProduct")
//	@iOSFindBy()
	private MobileElement searchedProduct;	
	
	@AndroidFindBy(xpath="//*[@resource-id='com.licious:id/tvTitle'and text()='x1']")
	private MobileElement chicken;
	
	@AndroidBy(xpath="//*[@class='android.widget.ImageView']")
	private MobileElement AddToCart;
	
//	@AndroidBy(id="com.licious:id/tvAddtoCart")
//	private MobileElement AddToCart;
	
	public void searchLocation() {
		
		getStartedbtn.click();
		Log.info("Clicked on Let's get started");
		test.log(LogStatus.PASS, "Clicked on Let's get started");
		
//		logger.log("Clicked on Let's get started");
		customWait(2);
		searchIcon.click();
		searchLocationTbox.sendKeys("Indiranagar");	
		customWait(2);
		scrollByText("Indiranagar, Bengaluru, Karnataka, India");
		customWait(10);	
		
	}
	
	public void searchProduct() {
		searchIcon.click();
		searchLocationTbox.sendKeys("lamb chops");
		customWait(5);
		searchedProduct.click();
		customWait(8);
		AddToCart.click();
		
	}
	
	public void selectProductCategory(AppiumDriver<MobileElement> driver, String productCategory) throws Exception {		
	    
		customWait(10);	
		((FindsByAndroidUIAutomator<MobileElement>) _driver).findElementByAndroidUIAutomator("//*[@text = 'Chicken']").click();
		
		
//		((Object) driver).findElementByAndroidUIAutomator();
//		driver.findElement(By.xpath("//*[@text = 'Chicken']")).click();
//		chicken.click();
//		clickBtn(getElementWithDynamicXpath(PRODUCT_CATEGORY, productCategory));
		customWait(5);
	}
}
