package br.com.qualityfactory.el.elmd.service.codest;

import java.util.Collection;

import br.com.qualityfactory.el.elmd.domain.Codest;
import br.com.qualityfactory.el.elmd.domain.Model;
import br.com.qualityfactory.el.elmd.exception.ArchitectureProcessELException;
import br.com.qualityfactory.el.elmd.exception.DataBaseELException;

interface CodestRespository {
	Collection<Model> listAllCodest();
	
	Model findWithArguments(Codest codest) throws DataBaseELException, ArchitectureProcessELException;
}
