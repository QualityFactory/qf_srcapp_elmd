package br.com.qualityfactory.el.elmd.util;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;

import br.com.qualityfactory.el.elmd.domain.Model;

public class BusinessUtil {
	public static Collection<Field> getFieldsModel(Model model) throws IllegalArgumentException, IllegalAccessException {
		Collection<Field> fields = new ArrayList<>();

		for (Field field : model.getClass().getDeclaredFields()) {
			field.setAccessible(true);

			if (!field.getName().contains("serialVersion") && field.get(model) != null) {
				fields.add(field);
			}
		}

		return fields;
	}
}
