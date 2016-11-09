package br.com.qualityfactory.el.elmd.controller;

import java.util.List;
import java.util.UUID;

import javax.inject.Inject;

import com.google.common.collect.Lists;

import br.com.caelum.vraptor.Consumes;
import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.view.Results;
import br.com.qualityfactory.el.elmd.domain.Model;
import br.com.qualityfactory.el.elmd.service.codest.CodestService;
import br.com.qualityfactory.el.elmd.transaction.Response;
import br.com.qualityfactory.el.elmd.transaction.Token;
import br.com.qualityfactory.el.elmd.transaction.request.CodestRequest;

@Controller
@Path("/codest")
public class CodestController {

	@Inject
	private Result result;

	@Inject
	private CodestService service;

	@Post("getCodests")
	@Consumes("application/json")
	public void listAll(CodestRequest request) {
		Response response = new Response();

		Token token = new Token();
		token.setKey(UUID.randomUUID().toString());

		response.setResponse((List<Model>) service.listAll());
		response.setToken(token);

		result.use(Results.json()).withoutRoot().from(response).include("response").recursive().serialize();
	}

	@Post("doFilter")
	@Consumes("application/json")
	public void findCodestWithArguments(CodestRequest request) {
		Response response = new Response();
		
		Token token = new Token();
		token.setKey(UUID.randomUUID().toString());
		
		response.setResponse(Lists.newArrayList(service.findWithArguments(request.getCodest())));
		response.setToken(token);
		
		result.use(Results.json()).withoutRoot().from(response).include("response").recursive().serialize();
	}

}
