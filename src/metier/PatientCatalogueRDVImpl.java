package metier;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import cnx.DBConnexion;
import entity.Medecin;
import entity.Patient;

public class PatientCatalogueRDVImpl implements IPatientCatalogueRDV{

	DBConnexion db = new DBConnexion();
	
	@Override
	public Patient ajouterPatient(Patient m) {
		try
		{
			if(db.connexionBD()==null)
			{
				db.connexionBD();				
			}
			String req = "INSERT INTO `patient`(`nom`, `prenom`, `age`, `fonction`) "
					+ "VALUES ('"+m.getNom()+"', '"+m.getPrenom()+"', '"+m.getAge()+"', '"+m.getFonction()+"')";
			db.executeUpdate(req);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		finally
		{
			db.deconnexionBD();
		}
		return m;
	}

	@Override
	public Patient updatePatient(Patient m) {
		try
		{
			if(db.connexionBD()==null)
			{
				db.connexionBD();				
			}
			String req = "UPDATE `patient` SET `nom`='"+m.getNom()+"',`prenom`='"+m.getPrenom()+"',"
					+ "`fonction`='"+m.getFonction()+"', `age`="+m.getAge()+" WHERE `id_patient`="+m.getIdPatient()+"";
			db.executeUpdate(req);
		}
		catch(Exception e)
		{
			e.printStackTrace();			
		}
		finally
		{
			db.deconnexionBD();
		}
		return m;
	}

	@Override
	public boolean desactiverPatient(Long idPatient) {
		try
		{
			if(db.connexionBD()==null)
			{
				db.connexionBD();				
			}
			String req = "UPDATE `patient` SET `actif`="+false+" WHERE `id_patient`="+idPatient+"";
			db.executeUpdate(req);
			return true;
		}
		catch(Exception e)
		{
			e.printStackTrace();			
		}
		finally
		{
			db.deconnexionBD();
		}
		return false;
	}

	@Override
	public Patient getPatient(Long idPatient) {
		try 
		{
			if(db.connexionBD()==null)
			{
				db.connexionBD();				
			}
			String req = "SELECT * FROM `patient` WHERE id_patient="+idPatient+"";
			ResultSet rs =  db.executeQuery(req);
			Patient m =  new Patient();
			if(rs.next())
			{
				m.setIdPatient(rs.getLong("id_patient"));
				m.setNom(rs.getString("nom"));
				m.setPrenom(rs.getString("prenom"));
				m.setAge(rs.getInt("age"));
				m.setFonction(rs.getString("fonction"));
			}
			return m;
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		finally
		{
			db.deconnexionBD();
		}
		return null;
	}

	@Override
	public List<Patient> allPatient() {
		ArrayList<Patient> patients = new ArrayList<Patient>();
		try 
		{
			if(db.connexionBD()==null)
			{
				db.connexionBD();				
			}
			String req = "SELECT * FROM `patient`";
			ResultSet rs = db.executeQuery(req);
			while (rs.next()) {
				Patient m =  new Patient();
				m.setIdPatient(rs.getLong("id_patient"));
				m.setNom(rs.getString("nom"));
				m.setPrenom(rs.getString("prenom"));
				m.setAge(rs.getInt("age"));
				m.setFonction(rs.getString("fonction"));
				patients.add(m);
			}
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		finally
		{
			db.deconnexionBD();
		}
		return patients;
	}

	@Override
	public List<Patient> allPatientByNameOrFirstName(String nom) {
		ArrayList<Patient> patients = new ArrayList<Patient>();
		try 
		{
			if(db.connexionBD()==null)
			{
				db.connexionBD();				
			}
			String req = "SELECT * FROM `patient` WHERE nom LIKE '%"+nom+"%' or prenom LIKE '%"+nom+"%'";
			ResultSet rs = db.executeQuery(req);
			while (rs.next()) {
				Patient m =  new Patient();
				m.setIdPatient(rs.getLong("id_patient"));
				m.setNom(rs.getString("nom"));
				m.setPrenom(rs.getString("prenom"));
				m.setAge(rs.getInt("age"));
				m.setFonction(rs.getString("fonction"));
				patients.add(m);
			}
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		finally
		{
			db.deconnexionBD();
		}
		return patients;
	}
}
