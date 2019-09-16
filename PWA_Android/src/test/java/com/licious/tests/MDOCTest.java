package com.licious.tests;

import org.testng.annotations.Test;

import com.licious.genericlib.BaseTest;
import static com.licious.genericlib.StdUtil.*;
import com.licious.pom.HomeScreen;

import junit.framework.Assert;

public class MDOCTest extends BaseTest {
	
	@Test
	public void createOrder() throws Exception {
		
//		logger= extRpt.startTest("Createorder");
		HomeScreen home= new HomeScreen(driver);
		
		customWait(5);	
		swipe(driver, "left");
		swipe(driver, "left");
		swipe(driver, "left");
				
		home.searchLocation();
//		home.searchProduct();
		
		
	}
	
	@Test
	public void createOrder1() throws Exception {
		
//		logger= extRpt.startTest("Createorder");
//		HomeScreen home= new HomeScreen(driver);
//		
//		customWait(5);	
		swipe(driver, "down");
		swipe(driver, "down");
		swipe(driver, "down");
				
//		home.searchLocation();
//		home.searchProduct();
		
		
	}
	

}
