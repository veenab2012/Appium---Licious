package com.licious.genericlib;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtil {
	
	public static FileInputStream fis = null;	
	
	public static String readExcelData(String path,String sheetName,int row,int col) {
		
		String data="";
		
		try {
			fis= new FileInputStream(new File(path));
			data=WorkbookFactory.create(fis).getSheet(sheetName).getRow(row).getCell(col).getStringCellValue();
					
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}catch (EncryptedDocumentException e) {
			e.printStackTrace();
		} catch (InvalidFormatException e) {
			e.printStackTrace();
		}	
		
		return data;			
	}
	
	public static int getRowCount(String path,String sheetName) {
		
		int rowcount=0;
		
		try {
			
			fis= new FileInputStream(new File(path));
			rowcount=WorkbookFactory.create(fis).getSheet(sheetName).getLastRowNum();
//			Workbook wb = WorkbookFactory.create(new FileInputStream(path));
//			rowcount = wb.getSheet(sheetName).getLastRowNum();
					
		}catch (Exception e) {
			e.printStackTrace();
		}	
		
		return rowcount;
		
	}
		
}
