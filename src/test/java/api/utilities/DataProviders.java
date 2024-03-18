package api.utilities;

import java.util.ArrayList;

import org.testng.annotations.DataProvider;

import api.tests.GorestTests;

public class DataProviders {
	
	@DataProvider(name = "ExcelData")
	public String [][] getSheetData()throws Exception{
		
		
		XLUtility xlUtility  = new XLUtility("sheet1");
		int rowNum = xlUtility.getRowNum();
		int cellNum = xlUtility.getCellNum();
		String [][]data = new String[rowNum][cellNum];
		for(int i=1; i<=rowNum; i++) {
			for(int j=0; j<cellNum; j++) {
				data[i-1][j] =xlUtility.getSheetData(i, j);
			}}
	
		return data;
	}
	

	
	
	
	

}
