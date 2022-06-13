package service;

import java.util.List;

import javax.persistence.Persistence;

import dao.DiseaseDao;
import model.Disease;

public class DiseaseService {
	private DiseaseDao diseaseDao;

	public DiseaseService() {
		try {
			diseaseDao = new DiseaseDao(Persistence.createEntityManagerFactory("EyeTester"));
		} catch (Exception ex) {
			System.out.println(ex);
		}
	}

	public void addDisease(Disease newDisease) {
		diseaseDao.create(newDisease);
	}

	public void updatePatient(Disease updatedDisease) {
		diseaseDao.update(updatedDisease);
	}

	public List<Disease> getAllDiseases() {
		return diseaseDao.findAll();
	}


	public Disease findDisease(String disease) throws Exception {
		String name = disease;
		List<Disease> Diseases = diseaseDao.find(name);
		if (Diseases.size() == 0) {
			throw new Exception("Disease not found!");
		}
		Disease u = Diseases.get(0);

		return u;
	}
}
