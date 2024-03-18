package api.utilities;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class XLUtility {
	
	FileInputStream fileInputStream;
	XSSFWorkbook xssfWorkbook;
	String sheetName;
	String path = "C:\\Users\\sugum\\OneDrive\\Documents\\testData.xlsx";
	
	public XLUtility(String sheetName) {

		this.sheetName = sheetName;
	}
	
	public int getRowNum() throws Exception{
		fileInputStream = new FileInputStream(path);
		xssfWorkbook = new XSSFWorkbook(fileInputStream);
		XSSFSheet sheet = xssfWorkbook.getSheet(sheetName);
		int lastRowNum = sheet.getLastRowNum();
		return lastRowNum;	
	}
	
	public int getCellNum() throws Exception{
		fileInputStream = new FileInputStream(path);
		xssfWorkbook = new XSSFWorkbook(fileInputStream);
		XSSFSheet sheet = xssfWorkbook.getSheet(sheetName);
		short lastCellNum = sheet.getRow(0).getLastCellNum();
		return lastCellNum;
	}
	
	public String getSheetData(int rowNum,int colNum) throws Exception{
		fileInputStream = new FileInputStream(path);
		xssfWorkbook = new XSSFWorkbook(fileInputStream);
		XSSFSheet sheet = xssfWorkbook.getSheet(sheetName);
		XSSFRow row = sheet.getRow(rowNum);
		XSSFCell cell = row.getCell(colNum);
		DataFormatter dataFormatter = new DataFormatter();
		String data = dataFormatter.formatCellValue(cell);
		return data;
	}
}













