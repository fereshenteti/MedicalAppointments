package metier;

import java.util.List;

import entity.Medecin;
import entity.Patient;

public interface IMedecinCatalogueRDV {

	public Medecin ajouterMedecin(Medecin m);
	public Medecin updateMedecin(Medecin m);
	public boolean desactiverMedecin(Long idMedecin);
	public Medecin getMedecin(Long idMedecin);
	public List<Medecin> allMedecin();
	public List<Medecin> allMedecinBySpecialite(String specialite);
	public List<Medecin> allMedecinByNameOrFirstName(String nom);
}
