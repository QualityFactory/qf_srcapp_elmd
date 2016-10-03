package br.com.qualityfactory.el.elmd.defaultfc;

import java.util.Collection;

import br.com.qualityfactory.el.elmd.ejb.factory.SQLFactory;

public abstract class TableDefaultImpl implements TableDefaultFacade {

	@Override
	public Collection<Model> obterTodos(Model model) {
		return SQLFactory.getDataTable(model);
	}
}