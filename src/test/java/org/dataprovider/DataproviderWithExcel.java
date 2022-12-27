package org.dataprovider;

import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataproviderWithExcel {
	@DataProvider
	@Test
	public String[][] loginDatas() {
		Workbook wbook = null;
		String filepath = "C:\\Users\\mania\\eclipse-workspace\\test_datas\\Book 2.xlsx";

		try {
			wbook = new XSSFWorkbook(filepath);
		} catch (IOException e) {
			e.printStackTrace();
		}

		Sheet sheet = wbook.getSheetAt(0);
		int rows = sheet.getPhysicalNumberOfRows();
		System.out.println(rows);

		int cells = sheet.getRow(0).getPhysicalNumberOfCells();
		System.out.println(cells);
		String[][] data = new String[rows - 1][cells];

		for (int i = 1; i < rows; i++) {
			Row row = sheet.getRow(i);

			for (int j = 0; j < cells; j++) {
				Cell cell = row.getCell(j);
				DataFormatter dataform = new DataFormatter();
				String value = dataform.formatCellValue(cell);
				data[i - 1][j] = value;
			}

		}
		return data;
	}

}
