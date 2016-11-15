package br.com.qualityfactory.el.elmd.controller;

import java.util.*;

import javax.inject.*;

import com.google.common.collect.*;

import br.com.caelum.vraptor.*;
import br.com.caelum.vraptor.view.*;

import br.com.qualityfactory.el.elifr.domain.*;
import br.com.qualityfactory.el.elifr.exception.*;
import br.com.qualityfactory.el.elifr.service.table.*;
import br.com.qualityfactory.el.elifr.vo.request.*;
import br.com.qualityfactory.el.elifr.vo.*;
import br.com.qualityfactory.el.elifr.vo.enums.*;

@Controller
@Path("/codest")
public class CodestController {

	@Inject
	private Result result;

	private TableService service;

	@Post("listAll")
	@Consumes("application/json")
	public void listAll(CodestRequest request) {
		Response response = new Response();

		Token token = new Token();
		token.setKey(UUID.randomUUID().toString().getBytes());

		response.setResponse(new ArrayList<>(service.getInstance().listAll(new Codest())));
		response.setToken(token);

		result.use(Results.json()).withoutRoot().from(response).include("response").recursive().serialize();
	}

	@Post("findByParameter")
	@Consumes("application/json")
	public void findCodestWithArguments(CodestRequest request) {
		Response response = new Response();

		Token token = new Token();
		token.setKey(UUID.randomUUID().toString().getBytes());
		Message message = new Message();

		try {
			Model model = service.findByParam(request.getCodest());
			message.setMessageType(EnumMessageType.SUCCESS);
			response.setResponse(Lists.newArrayList(model));
		} catch (DataBaseELException dataBaseELException) {
			message.setMessageType(EnumMessageType.ALERT);
			message.setExceptionName(dataBaseELException.getClass().getSimpleName());
			message.setValue(dataBaseELException.getMessage());
			message.setOriginalExceptionName(dataBaseELException.getOriginalException().getClass().getSimpleName());
		} catch (ArchitectureELException architectureProcessELException) {
			message.setMessageType(EnumMessageType.ERROR);
			message.setValue(architectureProcessELException.getMessage());
			message.setExceptionName(architectureProcessELException.getClass().getSimpleName());
			message.setOriginalExceptionName(architectureProcessELException.getOriginalException().getClass().getSimpleName());
		}

		response.setMessage(message);
		response.setToken(token);

		result.use(Results.json()).withoutRoot().from(response).include("response").recursive().serialize();
	}
}
