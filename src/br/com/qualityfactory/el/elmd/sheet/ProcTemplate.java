package br.com.qualityfactory.el.elmd.sheet;

import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import br.com.qualityfactory.el.elmd.enums.EnumNameField;

public class ProcTemplate {
	
	private static XSSFWorkbook workbook;
	
	private static XSSFWorkbook getInstance() throws IOException {
		if (workbook == null) {
			workbook = new XSSFWorkbook(ClassLoader.getSystemResourceAsStream("Template.xlsx"));
		}
		
		return workbook;
	}
	
	public static XSSFSheet getSheet(SheetDefault sheet) throws IOException {
		return ProcTemplate.getInstance().getSheet(sheet.getClass().getSimpleName().replace("Sheet", "").toLowerCase());
	}
	
	public static void getFieldSheet(SheetDefault pSheet, EnumNameField nameField) throws IllegalArgumentException, IllegalAccessException, IOException {		
		final int ROW_HEAD = 1;
		
		XSSFSheet sheet = getSheet(pSheet);
		
		int firstRow = sheet.getFirstRowNum() + ROW_HEAD;
		int lastRow  = sheet.getLastRowNum();
		
		Iterator<Row> rows = sheet.iterator();
		
		while (rows.hasNext()){
			Row row = rows.next();
			
			row.getCell(0);
		}
	}
}