package com.crm.comcast.genericUtilities;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
/**
 * Its developed using Apache POI libraries which is used to handle microsoft excel sheet
 * @author FARHAN SD
 *
 */
public class ExcelUtility {
	/**
	 * To fetch data from excel
	 * @return
	 */
	public String getTestDataFromExcel(String sheet,int row,int cell) throws Throwable {
		FileInputStream fis=new FileInputStream(IPathConstants.excelPath);
		Workbook book = WorkbookFactory.create(fis);
		Cell cellvalue = book.getSheet(sheet).getRow(row).getCell(cell);
		
		DataFormatter datafor=new DataFormatter();
		String value = datafor.formatCellValue(cellvalue);
		return value;
	}
	/**
	 * to write data into excel
	 */
	public void writeDataInExcel(String sheetin, int row, int cell, String input) throws Throwable {
		FileInputStream fis=new FileInputStream(IPathConstants.excelPath);
		Workbook book = WorkbookFactory.create(fis);
		book.getSheet(sheetin).createRow(row).getCell(cell).setCellValue(input);
		FileOutputStream fos=new FileOutputStream(IPathConstants.excelPath);
		book.write(fos);
	}
}