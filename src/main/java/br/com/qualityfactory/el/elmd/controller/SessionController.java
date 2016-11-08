package br.com.qualityfactory.el.elmd.controller;

import java.util.UUID;

import javax.inject.Inject;

import br.com.caelum.vraptor.Consumes;
import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.view.Results;
import br.com.qualityfactory.el.elmd.transaction.Response;
import br.com.qualityfactory.el.elmd.transaction.Token;
import br.com.qualityfactory.el.elmd.transaction.request.SessionRequest;

@Controller
@Path("/session")
public class SessionController {
	
	@Inject
	private Result result;
	
	@Post("open")
	@Consumes("application/json")
	public void openSession(SessionRequest request) {
		 Token token = new Token();
		 token.setKey(UUID.randomUUID().toString());
		 
		 Response response = new Response();
		 response.setToken(token);
		 
		 result.use(Results.json()).withoutRoot().from(response).include("response").recursive().serialize();
	}
}
