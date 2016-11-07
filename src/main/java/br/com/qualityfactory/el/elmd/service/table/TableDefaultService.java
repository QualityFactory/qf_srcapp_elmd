package br.com.qualityfactory.el.elmd.service.table;

import java.util.Collection;

import br.com.qualityfactory.el.elmd.domain.Model;

public interface TableDefaultService {
	
	/**
	 * Return all records for the model receive by param
	 * @param model Implementation of model that represents the entity in the database
	 */
	public Collection<Model> listAll(Model model);
	
}
