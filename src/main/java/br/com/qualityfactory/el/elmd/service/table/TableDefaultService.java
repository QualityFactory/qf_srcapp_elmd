package br.com.qualityfactory.el.elmd.service.table;

import java.util.Collection;

import br.com.qualityfactory.el.elmd.domain.Model;

public interface TableDefaultService {
	
	/**
	 * Return all records for the model receive by param
	 * @param model Implementation of model that represents the entity in the database
	 */
	public Collection<Model> listAll(Model model);
	
	/**
	 * Return a model that was found in the search on database
	 * @param model Model with the params for parameterized of search 
	 * @return Return a model found
	 */
	public Model findByParam(Model model);
	
}
