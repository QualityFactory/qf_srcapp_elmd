package br.com.qualityfactory.el.elmd.service.adjective;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import br.com.qualityfactory.el.elmd.domain.Adjective;

@Component("adjectiveService")
@Transactional
public class AdjectiveServiceImpl implements AdjectiveService {

	private AdjectiveRepository adjectiveRepository;
	
	public AdjectiveServiceImpl(AdjectiveRepository adjectiveRepository) {
		this.adjectiveRepository = adjectiveRepository;
	}

	@Override
	public Page<Adjective> findAdjectives(Pageable pageable) {
		return adjectiveRepository.findAll(pageable);
	}

	@Override
	public Adjective findById(Short id) {
		return adjectiveRepository.findById(id);
	}

	@Override
	public Adjective findByCode(String code) {
		return adjectiveRepository.findByCode(code);
	}

	@Override
	public Adjective findByName(String name) {
		return adjectiveRepository.findByName(name);
	}
}
