package br.com.qualityfactory.el.elmd.service.codest;

import java.util.Collection;

import br.com.qualityfactory.el.elmd.domain.Model;

public interface CodestService {

	/**
	 * Recovery all codest
	 * @return return all codest
	 */
	public Collection<Model> listAll();
	
}
