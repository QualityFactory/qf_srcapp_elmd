package br.com.qualityfactory.el.elmd.service.table;

import java.util.Collection;

import br.com.qualityfactory.el.elmd.domain.Model;

interface TableDefaultRepository {
	
	Collection<Model> listAllModels(Model model);
}
