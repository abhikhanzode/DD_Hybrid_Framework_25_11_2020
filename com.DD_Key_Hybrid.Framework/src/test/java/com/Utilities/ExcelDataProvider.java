package com.Utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelDataProvider {

	public XSSFWorkbook wb;
	public FileInputStream fis;

	public ExcelDataProvider() {
		File src = new File("./TestData/testData.xlsx");
		try {
			fis = new FileInputStream(src);
			wb = new XSSFWorkbook(fis);

		} 
		catch (Exception e) {
			System.out.println("Unable to read Excel File"+e.getMessage());		

		}
	}
	
	// Method Overloading 

	public String getStringData(int sheetIndex, int row, int column) {
		return wb.getSheetAt(sheetIndex).getRow(row).getCell(column).getStringCellValue();
	}

	public String getStringData(String sheetName, int row, int column) {
		return wb.getSheet(sheetName).getRow(row).getCell(column).getStringCellValue();
	}

	public double getNumericData(String sheetName, int row, int column) {
		return wb.getSheet(sheetName).getRow(row).getCell(column).getNumericCellValue();

	}

}
