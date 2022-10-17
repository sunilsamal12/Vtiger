package com.crm.Generic_Utilities;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Excel_Utility {
	
	/**
	 * this method used for fetch data from excel sheet
	 * @param sheetName
	 * @param rowNum
	 * @param cellNum
	 * @return
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 * @author sunil
	 */
	public String getDataFromExcelSheet(String sheetName,int rowNum,int cellNum) throws EncryptedDocumentException, IOException {
		

	//	FileInputStream fis=new FileInputStream("Book1.xlsx");
		FileInputStream fis=new FileInputStream(ipathConstant.excel_path);
		
		Workbook wb=WorkbookFactory.create(fis);
		Sheet sh=wb.getSheet(sheetName);
		DataFormatter format=new DataFormatter();
		String data=format.formatCellValue(sh.getRow(rowNum).getCell(cellNum));
		return data;
	}

}
