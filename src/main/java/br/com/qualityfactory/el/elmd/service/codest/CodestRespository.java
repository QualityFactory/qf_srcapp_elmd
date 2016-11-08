package br.com.qualityfactory.el.elmd.service.codest;

import java.util.Collection;

import br.com.qualityfactory.el.elmd.domain.Model;

interface CodestRespository {
	Collection<Model> listAllCodest();
	
	Model findByTableName(String tableName);
}
