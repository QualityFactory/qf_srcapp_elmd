package br.com.qualityfactory.el.elmd.tests;

import java.io.IOException;

import org.junit.Before;
import org.junit.Test;

import br.com.qualityfactory.el.elmd.defaultfc.Model;
import br.com.qualityfactory.el.elmd.exceptions.NotFoundColumnException;
import br.com.qualityfactory.el.elmd.model.VerbModel;
import br.com.qualityfactory.el.elmd.sheet.ProcTemplate;
import br.com.qualityfactory.el.elmd.sheet.SheetDefault;
import br.com.qualityfactory.el.elmd.sheet.VerbSheet;
import br.com.qualityfactory.el.elmd.verb.Verb;
import br.com.qualityfactory.el.elmd.verb.VerbImpl;

public class VerbTest implements TestDefault{

	private Verb verb;
	private Model model;
	private SheetDefault sheet;

	@Before
	public void init() {
		verb = new VerbImpl();
		model = new VerbModel();
		sheet = new VerbSheet();
	}

	@Test
	public void getAll() throws IOException {
		TestDefault.super.getAll(verb, model);
	}
	
	@Test
	public void validateCode() throws IllegalArgumentException, IllegalAccessException, IOException, NotFoundColumnException {
		TestDefault.super.validateCode(verb, model, sheet);
	}
	
	@Test
	public void validateValue() throws IllegalArgumentException, IllegalAccessException, NotFoundColumnException, IOException {
		TestDefault.super.validateValue(verb, model, sheet);
	}

	@Override
	public Integer getNumRecords() throws IOException {
		return ProcTemplate.getCountRows(sheet);
	}
}