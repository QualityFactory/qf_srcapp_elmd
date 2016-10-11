package br.com.qualityfactory.el.elmd.tests;

import java.io.IOException;

import org.junit.Before;
import org.junit.Test;

import br.com.qualityfactory.el.elmd.codest.CodesTable;
import br.com.qualityfactory.el.elmd.codest.CodesTableImpl;
import br.com.qualityfactory.el.elmd.defaultfc.Model;
import br.com.qualityfactory.el.elmd.enums.EnumNameField;
import br.com.qualityfactory.el.elmd.exceptions.NotFoundColumnException;
import br.com.qualityfactory.el.elmd.model.CodesTableModel;
import br.com.qualityfactory.el.elmd.sheet.CodestSheet;
import br.com.qualityfactory.el.elmd.sheet.ProcTemplate;
import br.com.qualityfactory.el.elmd.sheet.SheetDefault;

public class CodesTableTest implements TestDefault {
	private CodesTable codesTable;
	private Model model;
	private SheetDefault sheet;
	
	/**
	 * Inicializa o teste obtendo todos os registros no banco
	 */
	@Before
	public void init(){
		codesTable = new CodesTableImpl();
		model = new CodesTableModel();
		sheet = new CodestSheet();
		
	}
	
	/**
	 * 
	 * Valida a quantidade de registros que foram persistidos no banco
	 * @throws IOException 
	 */
	@Test
	public void getAll() throws IOException {
		TestDefault.super.getAll(codesTable, model);
	}

	@Test
	public void validateCode() throws IllegalArgumentException, IllegalAccessException, NotFoundColumnException, IOException {
		TestDefault.super.validateFieldTable(codesTable, model, EnumNameField.CODE, ProcTemplate.getFieldSheet(sheet, EnumNameField.CODE));
	}
	
	@Test
	public void validateNameTable() throws IllegalArgumentException, IllegalAccessException, NotFoundColumnException, IOException {
		TestDefault.super.validateFieldTable(codesTable, model, EnumNameField.NAME, ProcTemplate.getFieldSheet(sheet, EnumNameField.NAME));
	}

	@Override
	public Integer getNumRecords() throws IOException {
		return ProcTemplate.getCountRows(sheet);
	}
}
