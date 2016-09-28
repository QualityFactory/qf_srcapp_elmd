package br.com.qualityfactory.el.elmd.defaultfc;

import java.util.ArrayList;
import java.util.List;

public abstract class TableDefault implements TableDefaultFacade {

	@Override
	public List<Model> obterTodos(Model model) {
		return new ArrayList<Model>();
		//return ;
	}

}
