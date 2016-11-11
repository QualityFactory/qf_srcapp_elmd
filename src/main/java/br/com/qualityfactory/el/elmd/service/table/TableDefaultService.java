package br.com.qualityfactory.el.elmd.service.table;

import java.util.Collection;

import br.com.qualityfactory.el.elmd.domain.Model;
import br.com.qualityfactory.el.elmd.exception.ArchitectureProcessELException;
import br.com.qualityfactory.el.elmd.exception.DataBaseELException;

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
	 * @exception DataBaseELException exception for errors in the database generate by JPA
	 * @exception ArchitectureProcessELException exception for errors in the process for get data by way of reflection 
	 */
	public Model findByParam(Model model) throws DataBaseELException, ArchitectureProcessELException;
	
}
