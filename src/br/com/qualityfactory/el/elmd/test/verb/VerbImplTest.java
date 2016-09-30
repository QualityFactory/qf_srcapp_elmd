package br.com.qualityfactory.el.elmd.test.verb;

import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import br.com.qualityfactory.el.elmd.defaultfc.Model;
import br.com.qualityfactory.el.elmd.ejb.util.TestUtil;
import br.com.qualityfactory.el.elmd.model.VerbModel;
import br.com.qualityfactory.el.elmd.verb.Verb;
import br.com.qualityfactory.el.elmd.verb.VerbImpl;

public class VerbImplTest {

	private Verb verb;
	private Model model;

	@Before
	public void init() {
		//TestUtil.initTest(this);
		verb = new VerbImpl();
		model = new VerbModel();
	}

	@Test
	public void testGetAllVerbs() {
		if (verb.obterTodos(model).isEmpty()) {
			fail("O método não obteve nenhum resultado.");
		}
	}
}
