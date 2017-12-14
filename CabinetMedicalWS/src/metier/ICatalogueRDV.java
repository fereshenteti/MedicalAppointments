package metier;

import java.util.List;

import entity.Rdv;

public interface ICatalogueRDV {
	
	public Rdv ajouterRDV(Rdv r);
	public Rdv updateRDV(Rdv r);
	public boolean deleteRDV(Long idRdv);
	public Rdv getRDV(Long idRdv);
	public List<Rdv> allRDV();
	public List<Rdv> allRDVByDate(String date);
	public List<Rdv> allRDVByMedecin(Long idMedecin);
	public List<Rdv> allRDVByMedecinByDate(Long idMedecin, String date);
	public List<Rdv> allRDVByPatient(Long idPatient);

}
