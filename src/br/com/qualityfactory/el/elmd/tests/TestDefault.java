package br.com.qualityfactory.el.elmd.tests;

import java.util.Collection;
import java.util.List;

import br.com.qualityfactory.el.elmd.defaultfc.Model;
import br.com.qualityfactory.el.elmd.defaultfc.TableDefault;
import junit.framework.Assert;

public interface TestDefault {

	/**
	 * Valida de forma gen�rica a quantidade de registros que devem existir no banco de dados
	 * @param table Implementa��o da tabela(facade) que ir� gerar a consulta no banco de dados 
	 * @param modelImpl Implementa��o do model mapeado com a tabela no banco de dados
	 */
	public default void getAll(TableDefault table, Model modelImpl) {
		Collection<Model> models = table.obterTodos(modelImpl);
		Assert.assertEquals(getNumRecords().intValue(), models.size());
	}
	
	/**
	 * Verifica se o c�digo informado est� persistido corretamente no banco de dados 
	 * @param table Implementa��o do facade que disponibilizar� a consulta com o banco 
	 * @param modelImpl Implementa��o do model mapeado com a tabela no banco de dados
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
			
			Assert.fail("O valor " + valueNotFound + " n�o foi encontrado na base de dados.");
		}
	}
	
	/**
	 * Quantidade de registros que deve ser 
	 * @return
	 */
	public Integer getNumRecords();
}
