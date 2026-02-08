package com.utility;

import java.io.File;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


// To Read the Row and Column Values
public class ReadExcelData {
	public static String getParticularRowData(int rowValue, int columnValue){
		String data = null;
		try {
		File file = new File ("C:\\Users\\N.PURUSH\\Desktop\\DataDriven_IPT.xlsx");
		Workbook book = new XSSFWorkbook(file);//upcasting
		Sheet sheet = book.getSheet("Sheet1");
		Row row =sheet.getRow(rowValue);
		Cell cell = row.getCell(columnValue);
		//String data = cell.getStringCellValue();
				//System.out.println(data);
				//}
				//String data = cell.getStringcellValue();
				//System.out.println(data);

				// Format Every cell in to String
		
		DataFormatter dataFormat = new DataFormatter();
		data = dataFormat.formatCellValue(cell);
		}
				catch (Exception e) {
				e.printStackTrace();
		}
				return data;
	}
	public static void main (String[] args) {
		String result = getParticularRowData (1,3);
		System.out.println(result);
}
}


