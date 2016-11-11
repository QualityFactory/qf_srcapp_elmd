package br.com.qualityfactory.el.elmd.service.codest;

import java.util.Collection;

import javax.inject.Inject;

import br.com.qualityfactory.el.elmd.domain.Codest;
import br.com.qualityfactory.el.elmd.domain.Model;
import br.com.qualityfactory.el.elmd.exception.ArchitectureProcessELException;
import br.com.qualityfactory.el.elmd.exception.DataBaseELException;
import br.com.qualityfactory.el.elmd.service.table.TableDefaultService;

class CodestRepositoryImpl implements CodestRespository {
	
	@Inject
	private TableDefaultService tableService;

	@Override
	public Collection<Model> listAllCodest() {
		return tableService.listAll(new Codest());
	}
	
	@Override
	public Model findWithArguments(Codest codest) throws DataBaseELException, ArchitectureProcessELException {
		return tableService.findByParam(codest);
	}
}
