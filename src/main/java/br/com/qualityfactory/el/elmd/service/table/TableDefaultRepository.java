package br.com.qualityfactory.el.elmd.service.table;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.Repository;

import br.com.qualityfactory.el.elmd.domain.Model;

public interface TableDefaultRepository extends Repository<Model, Long> {
	Page<Model> findAll(Model model, Pageable pageable);
	
	Page<Model> findByParam(Model model);
}
