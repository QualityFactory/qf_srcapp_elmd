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
		XSSFSheet sheet = ProcTemplate.getSheet(pSheet);
		
		Integer numCellField = ProcTemplate.identifyColumnField(sheet.iterator(), nameField);
		
		Iterator<Row> rows = sheet.iterator();
		
		while(rows.hasNext()){
			Row row = rows.next();
			Cell activeCell = row.getCell(numCellField); 
			
			if (activeCell == null || activeCell.getCellType() == Cell.CELL_TYPE_BLANK || (activeCell.getCellType() == Cell.CELL_TYPE_STRING &&  
					activeCell.getStringCellValue().equals(nameField.getDescricao()))) {
				continue;
			}
			
			if (nameField.name().equals(EnumNameField.CODE.name())) {
				lsField.add(getNumHex(activeCell.getStringCellValue()));
			} else {
				lsField.add(activeCell.getStringCellValue());
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
			
			break;
		}
		
		throw new NotFoundColumnException("Não foi possível encontrar a coluna especificada - " + nameField.getDescricao());
	}
	
	private static String getNumHex(String hex) {
		String format = "\\x";
		String numHexInit = "";

		if (hex.length() == 1) {
			numHexInit = "000";
		} else if (hex.length() == 2) {
			numHexInit = "00";
		} else if (hex.length() == 3) {
			numHexInit = "0";
		}

		return format.concat(numHexInit).concat(hex);
	}
	
	/**
	 * Método necessário para validar a quantidade de registros existentes na planilha
	 * @param pSheet
	 * @return
	 * @throws IOException
	 */
	public static int getCountRows(SheetDefault pSheet) throws IOException {
		XSSFSheet sheet = ProcTemplate.getSheet(pSheet);
		Iterator<Row> rows = sheet.iterator();
		
		int countRow = 0;
		
		while (rows.hasNext()) {
			Row row = rows.next();
			Cell activeCell = row.getCell(row.getFirstCellNum()); 
			
			if ((activeCell.getCellType() == Cell.CELL_TYPE_BLANK) || 
					(activeCell.getCellType() == Cell.CELL_TYPE_STRING && activeCell.getStringCellValue().equals(EnumNameField.CODE.getDescricao()))) {
				continue;
			}
			
			++countRow;
		}
		
		return countRow;
	}
	
	
}