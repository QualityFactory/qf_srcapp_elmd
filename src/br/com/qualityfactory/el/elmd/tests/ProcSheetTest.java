package br.com.qualityfactory.el.elmd.tests;

import org.junit.Before;
import org.junit.Test;

import br.com.qualityfactory.el.elmd.sheet.ProcTemplate;

public class ProcSheetTest {
	
	private ProcTemplate procSheet;
	
	@Before
	public void init() {
		procSheet = new ProcTemplate();
	}
	
	@Test
	public void procSheets(){
		procSheet.toString();
	}
}
