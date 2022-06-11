package model;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2022-06-11T23:12:04.373+0300")
@StaticMetamodel(Patient.class)
public class Patient_ {
	public static volatile SingularAttribute<Patient, Integer> patientID;
	public static volatile SingularAttribute<Patient, String> email;
	public static volatile SingularAttribute<Patient, String> password;
	public static volatile SingularAttribute<Patient, String> patientName;
	public static volatile SingularAttribute<Patient, String> type;
	public static volatile SingularAttribute<Patient, Disease> disease;
}
