package com.licious.genericlib;

public interface IConstants {
	
	public static final String PROPERTY_FILEPATH = "src/main/resources/app.properties";
	
	public static final String EXCEL_FILEPATH = "./ExcelTestData/Licidata.xlsx";
	
	public static final String EXTENTREPORTS_FILEPATH = System.getProperty("user.dir")+"./ExtentReport/" + StdUtil.getSimpleDate() + "erep.html";
	//public static final String EXTENTREPORTS_FILEPATH = System.getProperty("user.dir") + "/ExtentReport/abc.html";
	//public static final String EXTENTREPORTS_FILEPATH = "D:/PWA_Android_Veena/PWA_Android/ExtentReport/abc.html";
	
	
	public static final String SCREENSHOTS_PATH="./Screenshots/" +StdUtil.getSimpleDate()+ ".png";

	//System.getProperty("user.dir")+

}
