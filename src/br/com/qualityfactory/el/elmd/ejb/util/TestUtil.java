package br.com.qualityfactory.el.elmd.ejb.util;

import org.mockito.MockitoAnnotations;

public class TestUtil {
	public static <T> void initTest(T testClass){
		MockitoAnnotations.initMocks(testClass);
	}
}
