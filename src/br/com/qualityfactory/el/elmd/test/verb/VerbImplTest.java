package br.com.qualityfactory.el.elmd.test.verb;

import static org.junit.Assert.fail;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import br.com.qualityfactory.el.elmd.defaultfc.Model;
import br.com.qualityfactory.el.elmd.model.VerbModel;
import br.com.qualityfactory.el.elmd.verb.Verb;
import br.com.qualityfactory.el.elmd.verb.VerbImpl;

public class VerbImplTest {

	private Verb verb;
	private Model model;

	@Before
	public void init() {
		verb = new VerbImpl();
		model = new VerbModel();
	}

	@Test
	public void testGetAllVerbs() {
		Collection<Model> verbs = verb.obterTodos(model);

		if (verbs == null || verbs.size() != 3) {
			fail("A consulta n�o obteve nenhum resultado.");
		}
	}

	/**
	 * Verifica a lista de verbos que devem estar presentes no banco de dados
	 */
	@Test
	public void testVerifyValues() {
		for (String value : getValues()) {
			if (!verifyValues(value)) {
				fail("O verbo " + value + "n�o foi encontrado na base de dados.");
			}
		}
	}
	
	/**
	 * Verifica a lista de verbos que dem estar presentes no banco de dados
	 */
	@Test
	public void testVerifyCodes() {
		for (String codes : getCodes()) {
			if (!verifyCodes(codes)) {
				fail("O verbo " + codes + "n�o foi encontrado na base de dados.");
			}
		}
	}

	/**
	 * Valida��o dos verbos verificando se o nome na base de dados corresponde ao nome informado na planilha
	 * 
	 * @param cVerb
	 *            Verbo que deve estar cadastrado na base de dados
	 * @return Retorna false caso seja encontrada alguma inconsist�ncia com o
	 *         nome do verbo e true caso o verbo esteje cadastrado corretamente.
	 */
	private boolean verifyValues(String pVerb) {
		for (Model model : verb.obterTodos(model)) {
			VerbModel verb = ((VerbModel) model);

			if (verb.getValue().equals(pVerb)) {
				return true;
			}
		}

		return false;
	}

	/**
	 * Valida��o do verbos verificando se o c�digo na base de dados corresponde
	 * ao c�digo informado na planilha
	 * 
	 * @param pCode
	 *            C�digo do verbo em Hexadecimal
	 * @return Retorna false caso seja encontrada alguma inconsist�ncia com o
	 *         c�digo do verbo e true caso o c�digo esteja cadastrado
	 *         corretamente
	 */
	private boolean verifyCodes(String pCode) {
		for (Model model : verb.obterTodos(model)) {
			VerbModel verb = ((VerbModel) model);

			if (verb.getCode().equals(pCode)) {
				return true;
			}
		}

		return false;
	}

	/**
	 * Recupera os values que devem existir no banco de dados
	 * 
	 * @return Retorna uma lista de verbos para valida��o do banco de dados
	 */
	private List<String> getValues() {
		List<String> lsValues = new ArrayList<>();
		lsValues.add("run");
		lsValues.add("walk");
		lsValues.add("walking");
		
		return lsValues;
	}
	
	/**
	 * Recupera os codes que devem existir no banco de dados
	 * @return
	 */
	private List<String> getCodes() {
		List<String> lsCodes = new ArrayList<>();
		lsCodes.add("\\x70");
		lsCodes.add("\\x71");
		lsCodes.add("\\x72");
		
		return lsCodes;
	}
}
