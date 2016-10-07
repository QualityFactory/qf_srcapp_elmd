package br.com.qualityfactory.el.elmd.tests;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import br.com.qualityfactory.el.elmd.adjective.Adjective;
import br.com.qualityfactory.el.elmd.adjective.AdjectiveImpl;
import br.com.qualityfactory.el.elmd.defaultfc.Model;
import br.com.qualityfactory.el.elmd.model.AdjectiveModel;

public class AdjectiveTest implements TestDefault {
	private Adjective adjective;
	private Model model;

	@Before
	public void init() {
		adjective = new AdjectiveImpl();
		model = new AdjectiveModel();
	}

	@Test
	public void getAll() {
		TestDefault.super.getAll(adjective, model);
	}
	
	@Test
	public void validateCode() throws NoSuchMethodException, SecurityException {
		List<String> lsCodes = new ArrayList<>();
		lsCodes.add("\\x0100");
		
		TestDefault.super.validateCodeTable(adjective, model, lsCodes);
	}

	@Override
	public Integer getNumRecords() {
		return 1;
	}
}