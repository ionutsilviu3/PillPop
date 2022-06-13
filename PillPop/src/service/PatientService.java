package service;

import java.util.List;

import javax.persistence.Persistence;

import application.IdException;
import dao.PatientDao;
import model.Disease;
import model.Patient;

public class PatientService {
	private PatientDao patientDao;

	public PatientService() {
		try {
			patientDao = new PatientDao(Persistence.createEntityManagerFactory("EyeTester"));
		} catch (Exception ex) {
			System.out.println(ex);
		}
	}

	public void addPatient(Patient newPatient) {
		patientDao.create(newPatient);
	}

	public void updatePatient(Patient updatedPatient) {
		patientDao.update(updatedPatient);
	}

	public void updateType(String type, int id) {
		patientDao.updateType(type, id);
	}

	public void updateDisease(Disease disease, int id) {
		patientDao.updateDisease(disease, id);
	}

	public List<Patient> getAllPatients() {
		return patientDao.findAll();
	}

	public Patient findPatientID(String id) throws IdException {
		List<Patient> patients = patientDao.findPatientID(id);
		if (patients.size() == 0) {
			throw new IdException("User not found!");
		}
		Patient u = patients.get(0);

		return u;
	}

	public Patient findPatient(String patient, String pass) throws Exception {
		List<Patient> patients = patientDao.find(patient);
		if (patients.size() == 0) {
			throw new Exception("User not found!");
		}
		Patient u = patients.get(0);

		if (pass.compareTo(u.getPassword()) != 0) {
			throw new Exception("Password does not match");
		}
		return u;
	}

	public void deletePatient(Patient p) {
		patientDao.deletePatient(p.getPatientID());

	}
}
