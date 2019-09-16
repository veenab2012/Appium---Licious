package com.licious.pom;

import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.licious.genericlib.BasePage;

import io.appium.java_client.android.AndroidDriver;

public class ChickenPage extends BasePage{

	public ChickenPage(AndroidDriver driver) {
		super(driver);
		
	}
	
	public static final String ADD_TO_CART ="//*[contains(text(),'x1')]/..//*[text()='ADD TO CART']";
	
	
	public void clickOnAddToCart(String productName) throws Exception {
		
		WebElement productNameLink = getElementWithDynamicXpath(ADD_TO_CART, productName);
//		waitUntil(ExpectedConditions.elementToBeClickable(productNameLink),WebDriverException.class);
//		scrollToElement(productNameLink);
//		clickBtn(productNameLink);
		
		
	}

}
