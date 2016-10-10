package br.com.qualityfactory.el.elmd.tests;

import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Collection;
import java.util.List;

import br.com.qualityfactory.el.elmd.defaultfc.Model;
import br.com.qualityfactory.el.elmd.defaultfc.TableDefault;
import br.com.qualityfactory.el.elmd.enums.EnumNameField;
import junit.framework.Assert;

public interface TestDefault {

	/**
	 * Valida de forma genérica a quantidade de registros que devem existir no banco de dados
	 * @param table Implementação da tabela(facade) que irá gerar a consulta no banco de dados 
	 * @param modelImpl Implementação do model mapeado com a tabela no banco de dados
	 * @throws IOException 
	 */
	public default void getAll(TableDefault table, Model modelImpl) throws IOException {
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
	 * Verifica se o código informado está persistido corretamente no banco de dados 
	 * @param table Implementação do facade que disponibilizará a consulta com o banco 
	 * @param modelImpl Implementação do model mapeado com a tabela no banco de dados
	 * @param values Valores que devem existir no banco de dados
	 * 
	 */
	
	/**
	 * Verifica se o campo informado está persistido corretamente no banco de dados
	 * @param table
	 * @param modelImpl
	 * @param nameMethod
	 * @throws IllegalAccessException 
	 * @throws IllegalArgumentException 
	 */
	public default void validateFieldTable(TableDefault table, Model modelImpl, EnumNameField nameField, List<String> values) throws IllegalArgumentException, IllegalAccessException {
		Collection<Model> models = table.obterTodos(modelImpl);
		
		modelList:
		for (Model model: models) {
			String fieldValue = "";
			
			for (Field field : model.getClass().getDeclaredFields()) {
				if (field.getName().equalsIgnoreCase(nameField.name())) {		
					field.setAccessible(true);
					fieldValue = field.get(model).toString();					
					field.setAccessible(false);
					
					break;
				}
			}
			
			String valueNotFound = "";
			
			for (String value: values) {
				if (fieldValue.equals(value)){
					continue modelList;
				}
				
				valueNotFound = value;
				break;
			}
			
			Assert.fail("O valor " + valueNotFound + " não foi encontrado na base de dados.");
		}
	}
	
	/**
	 * Quantidade de registros que deve ser 
	 * @return
	 * @throws IOException 
	 */
	public Integer getNumRecords() throws IOException;
}
