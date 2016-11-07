package br.com.qualityfactory.el.elmd.controller;

import java.util.List;
import java.util.UUID;

import javax.inject.Inject;

import br.com.caelum.vraptor.Consumes;
import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.view.Results;
import br.com.qualityfactory.el.elmd.domain.Model;
import br.com.qualityfactory.el.elmd.service.codest.CodestService;
import br.com.qualityfactory.el.elmd.transaction.Request;
import br.com.qualityfactory.el.elmd.transaction.Response;
import br.com.qualityfactory.el.elmd.transaction.Token;

@Controller
@Path("/codest")
public class CodestController {
	
	@Inject
	private Result result;
	
	@Inject
	private CodestService service;
	
	@Post("/listAll")
	@Consumes("application/json")
	public void listAll(Request request) {	 
		 /*Codest codest = new Codest();
		 codest.setCode("34242r23432342");
		 codest.setId((short)21);
		 codest.setTableName("adjective");
		 
		 List<Model> ls = new ArrayList<>();
		 ls.add(codest);
		 
		 Token token = new Token();
		 token.setKey(UUID.randomUUID().toString());
		 
		 Response response = new Response();
		 
		 response.setToken(token);
		 response.setResponse(ls);*/
		 
		 Response response = new Response();
		 
		 Token token = new Token();
		 token.setKey(UUID.randomUUID().toString());
		
		 response.setResponse((List<Model>) service.listAll());
		 response.setToken(token);
		 
		 result.use(Results.json()).withoutRoot().from(response).include("response").recursive().serialize();
	}
}
