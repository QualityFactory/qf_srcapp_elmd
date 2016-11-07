package br.com.qualityfactory.el.elmd.controller;

import java.util.UUID;

import javax.inject.Inject;

import br.com.caelum.vraptor.Consumes;
import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.view.Results;
import br.com.qualityfactory.el.elmd.transaction.Request;
import br.com.qualityfactory.el.elmd.transaction.Response;
import br.com.qualityfactory.el.elmd.transaction.Token;

@Controller
@Path("/session")
public class SessionController {
	
	@Inject
	private Result result;
	
	@Post("/openSession")
	@Consumes("application/json")
	public void openSession(Request request) {
		 Token token = new Token();
		 token.setKey(UUID.randomUUID().toString());
		 
		 Response response = new Response();
		 
		 response.setToken(token);
		 response.setResponse(null);
		 
		 result.use(Results.json()).withoutRoot().from(response).include("response").recursive().serialize();
	}
}
