package com.library;

import java.io.FileInputStream;
import java.util.Properties;

import org.apache.poi.sl.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Generic 
{
	public static String Sdir = System.getProperty("user.dir");
	public static String config_file = Sdir+"\\Config.properties" ;
	public static String App_Path = Sdir+"\\APK_Files\\abof.apk";
	public static String Excel_Path = Sdir+"\\TestAbofData.xlsx";
	/* To Read the data from the properties file */
	public static String getproperties(String Key)
	{	
		String svalue = null;
		try
		{
		FileInputStream file = new FileInputStream(config_file);
		Properties Prop = new Properties();
		Prop.load(file);
		svalue = Prop.getProperty(Key);
		
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return svalue;
	}
	
	public static void handleKeyboard()
	{
		try
		{
		BaseClass.driver.hideKeyboard();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	/* To Read the data from the Excel file */
	
	public static String readFromExcel(String Sheetname,int row, int cell)
	{
	String sdata = null;
	
		try
		{
		FileInputStream file = new FileInputStream(Excel_Path);
		Workbook Wb = (Workbook)new WorkbookFactory().create(file);
		org.apache.poi.ss.usermodel.Sheet sh=  Wb.getSheet("Data");
		sdata = sh.getRow(row).getCell(cell).getStringCellValue();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return sdata;
		
	}
	

}
