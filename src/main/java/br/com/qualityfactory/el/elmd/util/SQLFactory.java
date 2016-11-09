package br.com.qualityfactory.el.elmd.util;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;

import br.com.qualityfactory.el.elmd.domain.Model;

public class SQLFactory {

	private static CriteriaBuilder builder;

	@SuppressWarnings("unchecked")
	public static CriteriaQuery<Model> getQuery(EntityManager manager, Model model) {
		return (CriteriaQuery<Model>) getBuilder(manager).createQuery(model.getClass());
	}

	public static CriteriaBuilder getBuilder(EntityManager manager) {
		if (builder == null) {
			builder = manager.getCriteriaBuilder();
		}

		return builder;
	}
}