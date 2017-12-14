package metier;

import java.util.List;

import entity.Patient;

public interface IPatientCatalogueRDV {
	
	public Patient ajouterPatient(Patient m);
	public Patient updatePatient(Patient m);
	public boolean desactiverPatient(Long idPatient);
	public Patient getPatient(Long idPatient);
	public List<Patient> allPatient();
	public List<Patient> allPatientByNameOrFirstName(String nom);
 
}
