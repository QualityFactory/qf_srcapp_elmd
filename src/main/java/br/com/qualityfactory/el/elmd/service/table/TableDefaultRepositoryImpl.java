package br.com.qualityfactory.el.elmd.service.table;

import java.util.Collection;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import br.com.qualityfactory.el.elmd.domain.Model;
import br.com.qualityfactory.el.elmd.util.SQLFactory;

class TableDefaultRepositoryImpl implements TableDefaultRepository {
	
	@PersistenceContext
	private EntityManager manager; 
	

	@Override
	public Collection<Model> listAllModels(Model model) {
		CriteriaQuery<Model> query = SQLFactory.getQuery(manager, model);
		return doSelect(query, doFrom(model, query));
	}

	private Collection<Model> doSelect(CriteriaQuery<Model> query, Root<Model> variableRoot) {
		query.select(variableRoot);
		return (Collection<Model>) manager.createQuery(query).getResultList();
	}

	@SuppressWarnings("unchecked")
	private Root<Model> doFrom(Model model, CriteriaQuery<Model> query) {
		return (Root<Model>) query.from(model.getClass());
	}
}
