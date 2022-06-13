package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.ParameterExpression;
import javax.persistence.criteria.Root;

import model.Disease;

public class DiseaseDao extends GenericDao<Disease> {

	private EntityManagerFactory factory;

	public DiseaseDao(EntityManagerFactory factory) {
		super(Disease.class);
		this.factory = factory;
	}

	@Override
	public EntityManager getEntityManager() {
		try {
			return factory.createEntityManager();
		} catch (Exception ex) {
			System.out.println("The entity manager cannot be created!");
			return null;
		}
	}
	
	
	// for login
	public List<Disease> find(String name) {
		EntityManager em = getEntityManager();
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Disease> q = cb.createQuery(Disease.class);

		Root<Disease> c = q.from(Disease.class);
		ParameterExpression<String> paramName = cb.parameter(String.class);
		q.select(c).where(cb.equal(c.get("diseaseName"), paramName));
		TypedQuery<Disease> query = em.createQuery(q);
		query.setParameter(paramName, name);

		List<Disease> results = query.getResultList();
		return results;
	}
}
