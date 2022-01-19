package com.policybazzar;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Travel_Data {

 	public static String[] customerData = new String[6];
	
 	XSSFWorkbook workbook;
 	XSSFSheet sheet;
 	
 	Travel_Data() throws IOException {
 	
 		FileInputStream fis = new FileInputStream("./Excel/ReadWrite.xlsx"); //Providing path of the excel file
    
 		 workbook = new XSSFWorkbook(fis); //Finds the workbook instance for XLSX file
    
 		 sheet = workbook.getSheetAt(0); //Returns first sheet from the XLSX workbook
	}
	public String[] readData() throws IOException {
		
		XSSFRow row; //Declaring an object named "row"
	    XSSFCell cell; //Declaring an object named "cell"
	    
	    row=sheet.getRow(0); //Fetching the index zero value	    
			
        //For each row, iterate through each columns
        for(int i=1;i<7;i++)
        {
             cell=row.getCell(i);
             customerData[i-1]=cell.toString();
             //System.out.println(" Values:"+cell.toString());
        }
                
        return customerData;
	}
	
	public String getBrowser() {
	
		String browser;
		
		XSSFRow row; //Declaring an object named "row"
	    XSSFCell cell; //Declaring an object named "cell"
	    
	    row=sheet.getRow(0); //Fetching the index zero value	    
				
	    cell=row.getCell(0);
	    
	    browser = cell.toString();
	    
		return browser;
	}
}
