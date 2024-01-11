package com.maven.datadriventesting;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelSheet 
{

	
	public static void main(String[] args) throws EncryptedDocumentException, IOException 
	{
		FileInputStream fis = new FileInputStream("./src/test/resource/workbook.xlsx");
		
		 Workbook wbf = WorkbookFactory.create(fis);
		 
		 Sheet sheet = wbf.getSheet("Sheet1");
		 Row row = sheet.getRow(1);
		 Cell cell = row.getCell(1);
		 
		  double numericCellValue = cell.getNumericCellValue();
		  
		 System.out.println((long)numericCellValue);
		 
		 
		 
		
		

	}

}
