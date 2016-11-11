package br.com.qualityfactory.el.elmd.service.table;

import java.util.Collection;

import br.com.qualityfactory.el.elmd.domain.Model;
import br.com.qualityfactory.el.elmd.exception.ArchitectureProcessELException;
import br.com.qualityfactory.el.elmd.exception.DataBaseELException;

interface TableDefaultRepository {
	Collection<Model> listAllModels(Model model);
	
	Model findModelByParam(Model model) throws DataBaseELException, ArchitectureProcessELException;	
}
