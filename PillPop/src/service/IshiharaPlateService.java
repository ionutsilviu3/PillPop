package service;

import java.util.List;

import javax.persistence.Persistence;

import dao.IshiharaPlateDao;
import model.Ishiharaplate;

public class IshiharaPlateService {
	private IshiharaPlateDao ishiharaPlateDao;

	public IshiharaPlateService() {
		try {
			ishiharaPlateDao = new IshiharaPlateDao(Persistence.createEntityManagerFactory("EyeTester"));
		} catch (Exception ex) {
			System.out.println(ex);
		}
	}

	public void addIshiharaPlate(Ishiharaplate newIshiharaPlate) {
		ishiharaPlateDao.create(newIshiharaPlate);
	}

	public void updatePatient(Ishiharaplate updatedIshiharaPlate) {
		ishiharaPlateDao.update(updatedIshiharaPlate);
	}

	public List<Ishiharaplate> getAllIshiharaPlates() {
		return ishiharaPlateDao.findAll();
	}


	public Ishiharaplate findIshiharaPlate(int ishiharaPlate) throws Exception {
		String id = ((Integer)ishiharaPlate).toString();
		List<Ishiharaplate> ishiharaPlates = ishiharaPlateDao.find(id);
		if (ishiharaPlates.size() == 0) {
			throw new Exception("Ishihara Plate not found!");
		}
		Ishiharaplate u = ishiharaPlates.get(0);

		return u;
	}
}
