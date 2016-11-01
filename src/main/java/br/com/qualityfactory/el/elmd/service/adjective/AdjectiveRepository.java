package br.com.qualityfactory.el.elmd.service.adjective;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.Repository;

import br.com.qualityfactory.el.elmd.domain.Adjective;

interface AdjectiveRepository extends Repository<Adjective, Long> {
	Page<Adjective> findAll(Pageable pageable);
	
	Adjective findById(Short id);

	Adjective findByCode(String code);
	
	Adjective findByName(String name);
}
