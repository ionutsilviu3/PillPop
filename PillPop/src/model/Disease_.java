package model;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2022-06-11T23:12:04.332+0300")
@StaticMetamodel(Disease.class)
public class Disease_ {
	public static volatile SingularAttribute<Disease, Integer> diseaseID;
	public static volatile SingularAttribute<Disease, String> description;
	public static volatile SingularAttribute<Disease, String> diseaseName;
	public static volatile ListAttribute<Disease, Patient> patients;
}
