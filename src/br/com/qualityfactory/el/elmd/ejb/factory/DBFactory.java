package br.com.qualityfactory.el.elmd.ejb.factory;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import br.com.qualityfactory.el.elmd.defaultfc.Model;
import br.com.qualityfactory.el.elmd.ejb.util.NegocioConstantes;

public class DBFactory {
	
	private static EntityManager entityManager;

	private static CriteriaBuilder builder;
	private static CriteriaQuery<Model> query;
	
	@SuppressWarnings("unchecked")
	public static List<Model> getDataTable(Model model){
		return (List<Model>) getQuery(model).select(doFrom(model));
	}
	
	@SuppressWarnings("unchecked")
	private static CriteriaQuery<Model> getQuery(Model model){
		query = (CriteriaQuery<Model>) getBuilder().createQuery(model.getClass());
		
		return query; 
	}
	
	private static CriteriaBuilder getBuilder(){
		if (builder == null) {
			builder = getEntityManager().getCriteriaBuilder();
		}
		
		return builder;
	}
	
	@SuppressWarnings("unchecked")
	private static Root<Model> doFrom(Model model){
		return (Root<Model>) getQuery(model).from(model.getClass());
	}
	
	private static EntityManager getEntityManager(){
		if (entityManager == null){
			entityManager = Persistence.createEntityManagerFactory(NegocioConstantes.PERSISTENCE_UTIL).createEntityManager();
		}
		
		return entityManager;
	}
}
