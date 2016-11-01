package br.com.qualityfactory.el.elmd.service.table;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import br.com.qualityfactory.el.elmd.domain.Model;

public interface TableDefaultService {
	Page<Model> findAll(Model model, Pageable pageable);
	
	Model findByParam(Model model, String value, String fieldName, Pageable pageable);
}
