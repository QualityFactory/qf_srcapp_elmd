package br.com.qualityfactory.el.elmd.service.table;

import java.lang.reflect.Field;
import java.util.Collection;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import br.com.qualityfactory.el.elmd.domain.Model;
import br.com.qualityfactory.el.elmd.exception.ArchitectureProcessELException;
import br.com.qualityfactory.el.elmd.exception.DataBaseELException;
import br.com.qualityfactory.el.elmd.util.BusinessUtil;
import br.com.qualityfactory.el.elmd.util.SQLFactory;

class TableDefaultRepositoryImpl implements TableDefaultRepository {
	
	@PersistenceContext
	private EntityManager manager; 
	
	@Override
	public Collection<Model> listAllModels(Model model) {
		CriteriaQuery<Model> query = SQLFactory.getQuery(manager, model);
		return doSelect(query, doFrom(model, query));
	}
	
	@Override
	public Model findModelByParam(Model model) throws DataBaseELException, ArchitectureProcessELException {
		Model modelFound = null;
		
		try {
			CriteriaBuilder builder = SQLFactory.getBuilder(manager);
			Collection<Field> fields = BusinessUtil.getFieldsModel(model);
			CriteriaQuery<Model> query = SQLFactory.getQuery(manager, model);
			Root<Model> variableRoot = doFrom(model, query);
			
			for (Field field: fields) {
				query.select(variableRoot).where(builder.equal(variableRoot.get(field.getName()), field.get(model)));
			}
			
			modelFound = manager.createQuery(query).getSingleResult();
			
		} catch (NoResultException noResultException) {
			throw new DataBaseELException(noResultException);
		} catch ( IllegalArgumentException | IllegalAccessException illegalException) {
			throw new ArchitectureProcessELException(illegalException);
		}
		
		return modelFound;
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
