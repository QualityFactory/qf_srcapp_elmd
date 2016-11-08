package br.com.qualityfactory.el.elmd.transaction;

import java.io.Serializable;
import java.util.List;

import br.com.qualityfactory.el.elmd.domain.Model;
import lombok.Data;

@Data
public class Response implements Serializable{
	
	private static final long serialVersionUID = 1L;

	private Token token;
	private List<Model> response;
	private Message message;
}
