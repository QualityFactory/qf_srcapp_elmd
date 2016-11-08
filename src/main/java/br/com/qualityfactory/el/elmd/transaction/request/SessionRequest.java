package br.com.qualityfactory.el.elmd.transaction.request;

import br.com.qualityfactory.el.elmd.transaction.Token;
import lombok.Data;

@Data
public class SessionRequest {
	private Token token;
}
