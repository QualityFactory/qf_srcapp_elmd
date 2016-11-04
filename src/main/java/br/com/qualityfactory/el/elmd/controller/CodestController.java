package br.com.qualityfactory.el.elmd.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.inject.Inject;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.view.Results;
import br.com.qualityfactory.el.elmd.domain.Codest;
import br.com.qualityfactory.el.elmd.domain.Model;
import br.com.qualityfactory.el.elmd.transaction.Response;

@Controller
@Path("/codest")
public class CodestController {
	
	@Inject
	private Result result;
	
	@Path("/listAll")
	public void listAll() {	 
		 Codest codest = new Codest();
		 codest.setCode("34242r23432342");
		 codest.setId((short)21);
		 codest.setTableName("adjective");
		 
		 List<Model> ls = new ArrayList<>();
		 ls.add(codest);
		 
		 UUID id = UUID.randomUUID();
		 
		 Response response = new Response();
		 
		 response.setResponse(ls);
		 response.setToken(id.toString().getBytes());
		 
		 result.use(Results.json()).withoutRoot().from(response).include("response").recursive().serialize();
	}
}
