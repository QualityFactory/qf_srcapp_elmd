package br.com.qualityfactory.el.elmd.tests;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import br.com.qualityfactory.el.elmd.codest.CodesTable;
import br.com.qualityfactory.el.elmd.codest.CodesTableImpl;
import br.com.qualityfactory.el.elmd.defaultfc.Model;
import br.com.qualityfactory.el.elmd.model.CodesTableModel;
import junit.framework.Assert;

public class CodesTableTest implements TestDefault {
	private CodesTable codesTable;
	private Model model;
	private List<Model> models;
	
	/**
	 * Inicializa o teste obtendo todos os registros no banco
	 */
	@Before
	public void init(){
		codesTable = new CodesTableImpl();
		model = new CodesTableModel();
		
		models = (List<Model>) codesTable.obterTodos(model);			
	}
	
	/**
	 * Valida a quantidade de registros que foram persistidos no banco
	 */
	@Test
	public void getAll() {
		TestDefault.super.getAll(codesTable, model);
	}
	
	/**
	 * Valida os códes na tabela codest no banco de dados 
	 */
	@Test
	public void validateCodesPersist() {
		modelLoop:
		for (Model model : getAllCodesTable()) {
			for (Model modelDB : models) {
				if (modelDB.getCode().equals(model.getCode())){
					continue modelLoop;
				}
			}
			
			Assert.fail("O registro " + model.getCode() + " não foi encontrado na base de dados.");
		}
	}
	
	/**
	 * Valida se o nome da tabela informado na planilha foi persistido corretamente no banco de dados
	 */
	@Test
	public void validateNamesTablesPersist() {
		modelLoop:
		for (Model model : getAllCodesTable()) {
			CodesTableModel tableModelSheet = ((CodesTableModel)model);
			for (Model modelDB : models) {
				if (((CodesTableModel)modelDB).getTableName().equals(tableModelSheet.getTableName())){
					continue modelLoop;
				}
			}
			
			Assert.fail("O registro " + tableModelSheet.getTableName() + " não foi encontrado na base de dados.");
		}
	}
	
	public void validateCodeNameLink() {
		modelLoop:
		for (Model model : getAllCodesTable()) {
			CodesTableModel tableModelSheet = ((CodesTableModel)model);
			for (Model modelDB : models) {
				if (((CodesTableModel)modelDB).getTableName().equals(tableModelSheet.getTableName())){
					continue modelLoop;
				}
			}
			
			Assert.fail("O registro " + tableModelSheet.getTableName() + " não foi encontrado na base de dados.");
		}
	}
	
	/**
	 * Para fins de teste, informa os registros que devem estar presentes no banco, o ideal seria é recuperar os dados diretamente da planilha
	 * 
	 * @return
	 */
	private List<Model> getAllCodesTable(){
		List<Model> lsCodesTable = new ArrayList<>();
		
		Model model = new CodesTableModel();
		model.setCode("\\x0001");
		((CodesTableModel)model).setTableName("rule");
		lsCodesTable.add(model);
		
		Model model2 = new CodesTableModel();
		model2.setCode("\\x0002");
		((CodesTableModel)model2).setTableName("rule");
		lsCodesTable.add(model2);
		
		return lsCodesTable;
	}

	@Override
	public Integer getNumRecords() {
		return 33;
	}
}
