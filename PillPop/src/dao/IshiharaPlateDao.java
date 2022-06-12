package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.ParameterExpression;
import javax.persistence.criteria.Root;

import model.Ishiharaplate;

public class IshiharaPlateDao extends GenericDao<Ishiharaplate> {

	private EntityManagerFactory factory;

	public IshiharaPlateDao(EntityManagerFactory factory) {
		super(Ishiharaplate.class);
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
	
	
	
	public List<Ishiharaplate> find(String id) {
		EntityManager em = getEntityManager();
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Ishiharaplate> q = cb.createQuery(Ishiharaplate.class);

		Root<Ishiharaplate> c = q.from(Ishiharaplate.class);
		ParameterExpression<String> paramId = cb.parameter(String.class);
		q.select(c).where(cb.equal(c.get("plateID"), paramId));
		TypedQuery<Ishiharaplate> query = em.createQuery(q);
		query.setParameter(paramId, id);

		List<Ishiharaplate> results = query.getResultList();
		return results;
	}
}
