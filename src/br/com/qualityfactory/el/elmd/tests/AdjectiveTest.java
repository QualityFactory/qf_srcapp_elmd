package br.com.qualityfactory.el.elmd.tests;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import br.com.qualityfactory.el.elmd.adjective.Adjective;
import br.com.qualityfactory.el.elmd.adjective.AdjectiveImpl;
import br.com.qualityfactory.el.elmd.defaultfc.Model;
import br.com.qualityfactory.el.elmd.enums.EnumNameField;
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

	@Test
	public void getAll() throws IOException {
		TestDefault.super.getAll(adjective, model);
	}
	
	@Test
	public void validateCode() throws IllegalArgumentException, IllegalAccessException, IOException {
		ProcTemplate.getFieldSheet(sheet, EnumNameField.CODE);
		
		//List<String> lsCodes = new ArrayList<>();
		//lsCodes.add("\\x0100");
		
		//TestDefault.super.validateFieldTable(adjective, model, EnumNameField.CODE, lsCodes);
	}
	
	
	public void validateValue() throws IllegalArgumentException, IllegalAccessException {
		List<String> lsValues = new ArrayList<>();
		lsValues.add("quick");

		TestDefault.super.validateFieldTable(adjective, model, EnumNameField.VALUE, lsValues);
	}

	@Override
	public Integer getNumRecords() throws IOException {
		return ProcTemplate.getSheet(sheet).getLastRowNum();
	}
}