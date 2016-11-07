package br.com.qualityfactory.el.elmd.service.table;

import java.util.Collection;

import javax.inject.Inject;

import br.com.qualityfactory.el.elmd.domain.Model;

public class TableDefaultServiceImpl implements TableDefaultService {

	@Inject
	private TableDefaultRepository repository;
	
	@Override
	public Collection<Model> listAll(Model model) {
		return repository.listAllModels(model);
	}
}
