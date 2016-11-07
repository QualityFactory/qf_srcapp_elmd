package br.com.qualityfactory.el.elmd.service.table;

import java.util.Collection;

import br.com.qualityfactory.el.elmd.domain.Model;
import br.com.qualityfactory.el.elmd.util.SQLFactory;

class TableDefaultRepositoryImpl implements TableDefaultRepository {

	@Override
	public Collection<Model> listAllModels(Model model) {
		return SQLFactory.getDataTable(model);
	}
}
