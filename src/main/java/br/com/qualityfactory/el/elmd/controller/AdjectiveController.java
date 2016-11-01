package br.com.qualityfactory.el.elmd.controller;

import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import br.com.qualityfactory.el.elmd.service.adjective.AdjectiveService;

@Controller
public class AdjectiveController {

	private AdjectiveService adjectiveService;

	@GetMapping("/")
	@ResponseBody
	@Transactional(readOnly = true)
	public String helloWorld() {
		return this.adjectiveService.findById((short) 1).getValue();
	}
}
