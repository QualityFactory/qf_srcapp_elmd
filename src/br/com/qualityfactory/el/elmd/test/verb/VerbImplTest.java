package br.com.qualityfactory.el.elmd.test.verb;

import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import br.com.qualityfactory.el.elmd.defaultfc.Model;
import br.com.qualityfactory.el.elmd.model.VerbModel;
import br.com.qualityfactory.el.elmd.verb.Verb;
import br.com.qualityfactory.el.elmd.verb.VerbImpl;

public class VerbImplTest {

	@InjectMocks
	private Verb verb = Mockito.mock(VerbImpl.class);
	private Model model = Mockito.mock(VerbModel.class);

	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void testObterTodos() {

		if (verb.obterTodos(model).isEmpty()) {
			fail("O método não obteve nenhum resultado.");
		}
	}
}
