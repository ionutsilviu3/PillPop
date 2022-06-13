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
import model.Patient;

public class PatientDao extends GenericDao<Patient> {

	private EntityManagerFactory factory;

	public PatientDao(EntityManagerFactory factory) {
		super(Patient.class);
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

	public void updateDisease(Disease disease) {
		EntityManager em = getEntityManager();
		Patient patient = em.find(Patient.class, 1);
		  em.getTransaction().begin();
		  patient.setType("f");
		  //disease.addPatient(patient);
		  em.getTransaction().commit();
		  em.close();
	}

	public List<Patient> findPatientID(String id) {
		EntityManager em = getEntityManager();
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Patient> q = cb.createQuery(Patient.class);

		Root<Patient> c = q.from(Patient.class);
		ParameterExpression<String> paramID = cb.parameter(String.class);
		q.select(c).where(cb.equal(c.get("patientID"), paramID));
		TypedQuery<Patient> query = em.createQuery(q);
		query.setParameter(paramID, id);

		List<Patient> results = query.getResultList();
		return results;
	}

	// for login
	public List<Patient> find(String name) {
		EntityManager em = getEntityManager();
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Patient> q = cb.createQuery(Patient.class);

		Root<Patient> c = q.from(Patient.class);
		ParameterExpression<String> paramName = cb.parameter(String.class);
		q.select(c).where(cb.equal(c.get("patientName"), paramName));
		TypedQuery<Patient> query = em.createQuery(q);
		query.setParameter(paramName, name);

		List<Patient> results = query.getResultList();
		return results;
	}
}
