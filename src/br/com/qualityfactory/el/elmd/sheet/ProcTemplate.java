package br.com.qualityfactory.el.elmd.sheet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import br.com.qualityfactory.el.elmd.enums.EnumNameField;
import br.com.qualityfactory.el.elmd.exceptions.NotFoundColumnException;

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
	
	/**
	 * Recupera a lista de valores para o field solicitado
	 * @param pSheet
	 * @param nameField
	 * @return
	 * @throws IllegalArgumentException
	 * @throws IllegalAccessException
	 * @throws IOException
	 * @throws NotFoundColumnException
	 */
	public static List<String> getFieldSheet(SheetDefault pSheet, EnumNameField nameField) throws IllegalArgumentException, IllegalAccessException, IOException, NotFoundColumnException {		
		List<String> lsField = new ArrayList<>();
		XSSFSheet sheet = getSheet(pSheet);
		
		Integer numCellField = identifyColumnField(sheet.iterator(), nameField);
		
		Iterator<Row> rows = sheet.iterator();
		
		while(rows.hasNext()){
			Row row = rows.next();
			
			if ((row.getCell(numCellField).getCellType() == Cell.CELL_TYPE_BLANK) || (row.getCell(numCellField).getCellType() == Cell.CELL_TYPE_STRING &&  
					row.getCell(numCellField).getStringCellValue().equals(nameField.getDescricao()))) {
				continue;
			}
			
			if ((row.getCell(numCellField).getCellType() == Cell.CELL_TYPE_NUMERIC) && (nameField.name().equals(EnumNameField.CODE.name()))){
				lsField.add(getNumHex(row.getCell(numCellField).getNumericCellValue()));
			}
		}
		
		return lsField;
				
	}
	
	private static Integer identifyColumnField(Iterator<Row> rows, EnumNameField nameField) throws NotFoundColumnException {
		while (rows.hasNext()){
			Row row = rows.next();
			
			for (int i = row.getFirstCellNum(); i < row.getLastCellNum(); i++)
				if (row.getCell(i).getStringCellValue().equals(nameField.getDescricao())){
					return i;
				}
		}
		
		throw new NotFoundColumnException("Não foi possível encontrar a coluna especificada - " + nameField.getDescricao());
	}
	
	private static String getNumHex(Double number){
		String numHex = String.valueOf(number.intValue());
		String format = "\\x";
		String numHexInit = "";
		
		if (numHex.length() == 1) {
			numHexInit = "000";
		} else if (numHex.length() == 2) {
			numHexInit = "00";
		} else if (numHex.length() == 3) {
			numHexInit = "0";
		}
		
		return format.concat(numHexInit).concat(numHex);
	}
	
	
}