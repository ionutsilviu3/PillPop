package service;

import java.util.List;

import javax.persistence.Persistence;

import model.Patient;
import dao.PatientDao;

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

	public List<Patient> getAllPatients() {
		return patientDao.findAll();
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
}
