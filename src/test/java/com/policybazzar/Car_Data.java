package com.policybazzar;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Car_Data {

	public static String[] customerData = new String[3];
	
	public String[] readData() throws IOException {
		
		FileInputStream fis = new FileInputStream("./Excel/ReadWrite.xlsx"); //Providing path of the excel file
        
 		XSSFWorkbook workbook = new XSSFWorkbook(fis); //Finds the workbook instance for XLSX file
        XSSFSheet sheet = workbook.getSheetAt(1); //Returns first sheet from the XLSX workbook
        XSSFRow row; //Declaring an object named "row"
        XSSFCell cell; //Declaring an object named "cell"
        
        row=sheet.getRow(0); //Fetching the index zero value
        
        //For each row, iterate through each columns
        for(int i=0;i<3;i++)
        {
             cell=row.getCell(i);
             customerData[i]=cell.toString();
             //System.out.println(" Values:"+cell.toString());
        }
                
        return customerData;
	}
}
