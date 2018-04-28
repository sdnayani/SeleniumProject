package com.guru99.framework;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFRow;


public class ExcelUtils {
	
    private static HSSFWorkbook ExcelWBook;
    private static HSSFSheet ExcelWSheet;
	private static HSSFCell Cell;
	private static XSSFRow Row;

//This method is to set the File path and to open the Excel file, Pass Excel Path and Sheetname as Arguments to this method

public static void setExcelFile(String Path,String SheetName) throws Exception {

		try {

			// Open the Excel file

		FileInputStream ExcelFile = new FileInputStream(Path);
		
		ExcelWBook = new HSSFWorkbook(ExcelFile);
		ExcelWSheet = ExcelWBook.getSheet(SheetName);

		} catch (Exception e){

			throw (e);

		}

}

public static Object[][] getTableArray(String FilePath, String SheetName)    throws Exception

{   

   String[][] tabArray = null;

   try{
	   FileInputStream ExcelFile = new FileInputStream(FilePath);
	   
	   // Access the required test data sheet
	   ExcelWBook = new HSSFWorkbook(ExcelFile);
	   ExcelWSheet =ExcelWBook.getSheet(SheetName);
	   
	   int ci=0,cj=0;
	   int totalRows = ExcelWSheet.getLastRowNum();
	   int totalCols = 2;
	   int startRow = 1;
	   int startCol = 1;
	   tabArray=new String[totalRows][totalCols];

	   ci=0;
	   
	   for (int i=startRow;i<=totalRows;i++, ci++) {           	   

		  cj=0;

		   for (int j=startCol;j<=totalCols;j++, cj++){

			   tabArray[ci][cj]=getCellData(i,j);

			   System.out.println(tabArray[ci][cj]);  

				}

			}

	}

	catch (FileNotFoundException e)

	{

		System.out.println("Could not read the Excel sheet");

		e.printStackTrace();

	}

	catch (IOException e)

	{

		System.out.println("Could not read the Excel sheet");

		e.printStackTrace();

	}

	return(tabArray);

}

//This method is to read the test data from the Excel cell, in this we are passing parameters as Row num and Col num

public static String getCellData(int RowNum, int ColNum) throws Exception{

		try{

			Cell = ExcelWSheet.getRow(RowNum).getCell(ColNum);

			String CellData = Cell.getStringCellValue();

			return CellData;

			}catch (Exception e){

			return"";
			}

}




	}
