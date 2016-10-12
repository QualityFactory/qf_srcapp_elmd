package br.com.qualityfactory.el.elmd.tests;

import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Collection;
import java.util.List;

import br.com.qualityfactory.el.elmd.defaultfc.Model;
import br.com.qualityfactory.el.elmd.defaultfc.TableDefault;
import br.com.qualityfactory.el.elmd.enums.EnumNameFieldModel;
import br.com.qualityfactory.el.elmd.enums.EnumNameFieldSheet;
import br.com.qualityfactory.el.elmd.exceptions.NotFoundColumnException;
import br.com.qualityfactory.el.elmd.sheet.ProcTemplate;
import br.com.qualityfactory.el.elmd.sheet.SheetDefault;
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
	 * Verifica se o campo informado está persistido corretamente no banco de dados
	 * @param table
	 * @param modelImpl
	 * @param nameMethod
	 * @throws IllegalAccessException 
	 * @throws IllegalArgumentException 
	 */
	 default void validateFieldTable(TableDefault table, Model modelImpl, EnumNameFieldModel nameField, List<String> values) throws IllegalArgumentException, IllegalAccessException {
		Collection<Model> models = table.obterTodos(modelImpl);
		
		sheetList:
		for (String value: values) {
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
			
				if (fieldValue.isEmpty()) {
					Assert.fail("Não foi possível encontrar o field " + nameField.name() + " mapeado no model " + model.getClass().getSimpleName());
				}
			
				if (fieldValue.equalsIgnoreCase(value)){
					continue sheetList;
				}
			}
			
			Assert.fail("O valor " + value + " não foi encontrado na base de dados.");
		}
	}
	
	/**
	 * Método genérico para validação do code no banco de dados
	 * @param table
	 * @param model
	 * @param sheet
	 * @throws IllegalArgumentException
	 * @throws IllegalAccessException
	 * @throws IOException
	 * @throws NotFoundColumnException
	 */
	public default void validateCode(TableDefault table, Model model, SheetDefault sheet) throws IllegalArgumentException, IllegalAccessException, IOException, NotFoundColumnException {
		validateFieldTable(table, model, EnumNameFieldModel.CODE, ProcTemplate.getFieldSheet(sheet, EnumNameFieldSheet.CODE));
	}
	
	/**
	 * Método genérico para validação do valor no banco de dados
	 * @param table
	 * @param model
	 * @param sheet
	 * @throws IllegalArgumentException
	 * @throws IllegalAccessException
	 * @throws NotFoundColumnException
	 * @throws IOException
	 */
	public default void validateValue(TableDefault table, Model model, SheetDefault sheet) throws IllegalArgumentException, IllegalAccessException, NotFoundColumnException, IOException {
		validateFieldTable(table, model, EnumNameFieldModel.VALUE, ProcTemplate.getFieldSheet(sheet, EnumNameFieldSheet.VALUE));
	}
	
	/**
	 * Método genérico para validação do name no banco de dados
	 * @param table Implementação da fachada 
	 * @param model Implementação do model mapeado com a tabela no banco de dados
	 * @param sheet Implementação da planilha 
	 * @throws IllegalArgumentException
	 * @throws IllegalAccessException
	 * @throws NotFoundColumnException
	 * @throws IOException
	 */
	public default void validateName(TableDefault table, Model model, SheetDefault sheet) throws IllegalArgumentException, IllegalAccessException, NotFoundColumnException, IOException {
		validateFieldTable(table, model, EnumNameFieldModel.TABLENAME, ProcTemplate.getFieldSheet(sheet, EnumNameFieldSheet.NAME));
	}
	
	/**
	 * Quantidade de registros que deve ser 
	 * @return
	 * @throws IOException 
	 */
	public Integer getNumRecords() throws IOException;
}
