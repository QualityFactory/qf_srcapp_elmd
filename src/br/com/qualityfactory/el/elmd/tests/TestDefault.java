package br.com.qualityfactory.el.elmd.tests;

import java.util.Collection;
import java.util.List;

import br.com.qualityfactory.el.elmd.defaultfc.Model;
import br.com.qualityfactory.el.elmd.defaultfc.TableDefault;
import junit.framework.Assert;

public interface TestDefault {

	/**
	 * Valida de forma genérica a quantidade de registros que devem existir no banco de dados
	 * @param table Implementação da tabela(facade) que irá gerar a consulta no banco de dados 
	 * @param modelImpl Implementação do model mapeado com a tabela no banco de dados
	 */
	public default void getAll(TableDefault table, Model modelImpl) {
		Collection<Model> models = table.obterTodos(modelImpl);
		Assert.assertEquals(getNumRecords().intValue(), models.size());
	}
	
	/**
	 * Verifica se o código informado está persistido corretamente no banco de dados 
	 * @param table Implementação do facade que disponibilizará a consulta com o banco 
	 * @param modelImpl Implementação do model mapeado com a tabela no banco de dados
	 * @param values Valores que devem existir no banco de dados
	 * 
	 */
	public default void validateCodeTable(TableDefault table, Model modelImpl, List<String> values) throws NoSuchMethodException, SecurityException {
		Collection<Model> models = table.obterTodos(modelImpl);
		
		modelCode:
		for (Model model: models){			
			String valueNotFound = "";
					
			for (String value: values) {
				if (model.getCode().equals(value)){
					continue modelCode;
				}
				
				valueNotFound = value;
			}
			
			Assert.fail("O valor " + valueNotFound + " não foi encontrado na base de dados.");
		}
	}
	
	/**
	 * Quantidade de registros que deve ser 
	 * @return
	 */
	public Integer getNumRecords();
}
