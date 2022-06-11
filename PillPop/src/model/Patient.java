package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the patient database table.
 * 
 */
@Entity
@NamedQuery(name="Patient.findAll", query="SELECT p FROM Patient p")
public class Patient implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int patientID;

	private String email;

	private String password;

	private String patientName;

	private String type;

	//bi-directional many-to-one association to Disease
	@ManyToOne
	@JoinColumn(name="patientDisease")
	private Disease disease;

	public Patient() {
	}

	public int getPatientID() {
		return this.patientID;
	}

	public void setPatientID(int patientID) {
		this.patientID = patientID;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPatientName() {
		return this.patientName;
	}

	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Disease getDisease() {
		return this.disease;
	}

	public void setDisease(Disease disease) {
		this.disease = disease;
	}

}