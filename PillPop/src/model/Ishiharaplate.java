package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the ishiharaplate database table.
 * 
 */
@Entity
@NamedQuery(name="Ishiharaplate.findAll", query="SELECT i FROM Ishiharaplate i")
public class Ishiharaplate implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int plateID;

	private int correctAns;

	private int wrongAns;

	public Ishiharaplate() {
	}

	public int getPlateID() {
		return this.plateID;
	}

	public void setPlateID(int plateID) {
		this.plateID = plateID;
	}

	public int getCorrectAns() {
		return this.correctAns;
	}

	public void setCorrectAns(int correctAns) {
		this.correctAns = correctAns;
	}

	public int getWrongAns() {
		return this.wrongAns;
	}

	public void setWrongAns(int wrongAns) {
		this.wrongAns = wrongAns;
	}

}