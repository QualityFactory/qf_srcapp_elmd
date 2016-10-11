package br.com.qualityfactory.el.elmd.tests;

import java.io.IOException;

import org.junit.Before;
import org.junit.Test;

import br.com.qualityfactory.el.elmd.adjective.Adjective;
import br.com.qualityfactory.el.elmd.adjective.AdjectiveImpl;
import br.com.qualityfactory.el.elmd.defaultfc.Model;
import br.com.qualityfactory.el.elmd.enums.EnumNameField;
import br.com.qualityfactory.el.elmd.exceptions.NotFoundColumnException;
import br.com.qualityfactory.el.elmd.model.AdjectiveModel;
import br.com.qualityfactory.el.elmd.sheet.AdjectiveSheet;
import br.com.qualityfactory.el.elmd.sheet.ProcTemplate;
import br.com.qualityfactory.el.elmd.sheet.SheetDefault;

public class AdjectiveTest implements TestDefault {
	private Adjective adjective;
	private SheetDefault sheet;
	private Model model;

	@Before
	public void init() {
		adjective = new AdjectiveImpl();	
		model = new AdjectiveModel();
		sheet = new AdjectiveSheet();
	}

	public void getAll() throws IOException {
		TestDefault.super.getAll(adjective, model);
	}
	
	@Test
	public void validateCode() throws IllegalArgumentException, IllegalAccessException, IOException, NotFoundColumnException {
		TestDefault.super.validateFieldTable(adjective, model, EnumNameField.CODE, ProcTemplate.getFieldSheet(sheet, EnumNameField.CODE));
	}
	
	@Test
	public void validateValue() throws IllegalArgumentException, IllegalAccessException, NotFoundColumnException, IOException {
		TestDefault.super.validateFieldTable(adjective, model, EnumNameField.VALUE, ProcTemplate.getFieldSheet(sheet, EnumNameField.VALUE));
	}

	@Override
	public Integer getNumRecords() throws IOException {
		return ProcTemplate.getSheet(sheet).getLastRowNum();
	}
}