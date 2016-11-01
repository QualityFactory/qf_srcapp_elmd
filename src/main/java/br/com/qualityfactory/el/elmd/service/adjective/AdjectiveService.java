package br.com.qualityfactory.el.elmd.service.adjective;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import br.com.qualityfactory.el.elmd.domain.Adjective;

public interface AdjectiveService {
	
	Page<Adjective> findAdjectives(Pageable pageable);
	
	Adjective findById(Short id);
	
	Adjective findByCode(String code);
	
	Adjective findByName(String name);
}
