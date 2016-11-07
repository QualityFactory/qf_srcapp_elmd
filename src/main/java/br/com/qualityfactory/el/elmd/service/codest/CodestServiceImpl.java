package br.com.qualityfactory.el.elmd.service.codest;

import java.util.Collection;

import javax.inject.Inject;

import br.com.qualityfactory.el.elmd.domain.Model;

public class CodestServiceImpl implements CodestService {
	
	@Inject
	private CodestRespository repository;

	@Override
	public Collection<Model> listAll() {
		return repository.listAllCodest();
	}
}
