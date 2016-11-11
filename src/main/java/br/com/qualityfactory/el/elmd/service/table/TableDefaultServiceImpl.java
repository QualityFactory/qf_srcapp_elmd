package br.com.qualityfactory.el.elmd.service.table;

import java.util.Collection;

import javax.inject.Inject;

import br.com.qualityfactory.el.elmd.domain.Model;
import br.com.qualityfactory.el.elmd.exception.ArchitectureProcessELException;
import br.com.qualityfactory.el.elmd.exception.DataBaseELException;

public class TableDefaultServiceImpl implements TableDefaultService {

	@Inject
	private TableDefaultRepository repository;

	@Override
	public Collection<Model> listAll(Model model) {
		return repository.listAllModels(model);
	}

	@Override
	public Model findByParam(Model model) throws DataBaseELException, ArchitectureProcessELException {
		return repository.findModelByParam(model);
	}
}
