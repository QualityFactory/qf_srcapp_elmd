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
import br.com.qualityfactory.el.elmd.enums.EnumMessageType;
import br.com.qualityfactory.el.elmd.exception.ArchitectureProcessELException;
import br.com.qualityfactory.el.elmd.exception.DataBaseELException;
import br.com.qualityfactory.el.elmd.service.codest.CodestService;
import br.com.qualityfactory.el.elmd.transaction.Message;
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

	@Post("listAll")
	@Consumes("application/json")
	public void listAll(CodestRequest request) {
		Response response = new Response();

		Token token = new Token();
		token.setKey(UUID.randomUUID().toString());

		response.setResponse((List<Model>) service.listAll());
		response.setToken(token);

		result.use(Results.json()).withoutRoot().from(response).include("response").recursive().serialize();
	}

	@Post("findByParameter")
	@Consumes("application/json")
	public void findCodestWithArguments(CodestRequest request) {
		Response response = new Response();

		Token token = new Token();
		token.setKey(UUID.randomUUID().toString());
		Message message = new Message();

		try {
			Model model = service.findWithArguments(request.getCodest());
			message.setMessageType(EnumMessageType.SUCCESS);
			response.setResponse(Lists.newArrayList(model));
		} catch (DataBaseELException dataBaseELException) {
			message.setMessageType(EnumMessageType.ALERT);
			message.setException(dataBaseELException.getClass().getSimpleName());
			message.setValue(dataBaseELException.getMessage());
			message.setOriginalException(dataBaseELException.getOriginalException().getClass().getSimpleName());
		} catch (ArchitectureProcessELException architectureProcessELException) {
			message.setMessageType(EnumMessageType.ERROR);
			message.setValue(architectureProcessELException.getMessage());
			message.setException(architectureProcessELException.getClass().getSimpleName());
			message.setOriginalException(architectureProcessELException.getOriginalException().getClass().getSimpleName());
		}

		response.setMessage(message);
		response.setToken(token);

		result.use(Results.json()).withoutRoot().from(response).include("response").recursive().serialize();
	}
}
