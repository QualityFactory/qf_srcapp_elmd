package br.com.qualityfactory.el.elmd.service.codest;

import java.util.Collection;

import br.com.qualityfactory.el.elmd.domain.Model;

public interface CodestService {

	/**
	 * Recovery all codest
	 * @return return all codest found
	 */
	public Collection<Model> listAll();
	
	/**
	 * Recovery the model with the name of table 
	 * @param tableName name of table
	 * @return Return the model found
	 */
	public Model findByTableName(String tableName);
}
