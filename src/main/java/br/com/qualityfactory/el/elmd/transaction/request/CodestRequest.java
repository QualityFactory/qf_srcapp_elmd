package br.com.qualityfactory.el.elmd.transaction.request;

import br.com.qualityfactory.el.elmd.domain.Codest;
import br.com.qualityfactory.el.elmd.transaction.Token;
import lombok.Data;

@Data
public class CodestRequest {
	private Token token;
	private Codest codest;
}
