package br.com.qualityfactory.el.elmd.util;

import java.util.Collection;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import br.com.qualityfactory.el.elmd.domain.Model;

public class SQLFactory {

	private static EntityManager manager;
	private static CriteriaBuilder builder;

	public static Collection<Model> getDataTable(Model model) {
		CriteriaQuery<Model> query = getQuery(model);

		return doSelect(query, doFrom(model, query));
	}

	@SuppressWarnings("unchecked")
	private static CriteriaQuery<Model> getQuery(Model model) {
		return (CriteriaQuery<Model>) getBuilder().createQuery(model.getClass());
	}

	private static CriteriaBuilder getBuilder() {
		if (builder == null) {
			builder = getManager().getCriteriaBuilder();
		}

		return builder;
	}

	@SuppressWarnings("unchecked")
	private static Root<Model> doFrom(Model model, CriteriaQuery<Model> query) {
		return (Root<Model>) query.from(model.getClass());
	}

	private static Collection<Model> doSelect(CriteriaQuery<Model> query, Root<Model> variableRoot) {
		query.select(variableRoot);
		return (Collection<Model>) getManager().createQuery(query).getResultList();
	}

	private static EntityManager getManager() {
		if (manager == null) {
			manager = Persistence.createEntityManagerFactory(BusinessContant.PERSISTENCE_UNIT).createEntityManager(); 
		}
		
		return manager;
	}
}