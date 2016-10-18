package br.com.qualityfactory.el.elmd.test.ejb;

import java.util.Properties;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import org.junit.Test;

import br.com.qualityfactory.el.elmd.adjective.AdjectiveImpl;
import br.com.qualityfactory.el.elmd.model.AdjectiveModel;

public class ConnectionTest {
	
	@Test
	public void doLookup() throws NamingException{
		InitialContext.doLookup("java:global/qf_srcapp_elmd/AdjectiveImpl!br.com.qualityfactory.el.elmd.adjective.AdjectiveLocal");
		//InitialContext initialContext = new InitialContext();
		//initialContext.bind("java:global/a", 100);
	}
	
	
	
}
