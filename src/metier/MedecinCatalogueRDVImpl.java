package metier;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import cnx.DBConnexion;
import entity.Medecin;
import entity.Patient;

public class MedecinCatalogueRDVImpl implements IMedecinCatalogueRDV {

	DBConnexion db = new DBConnexion();
	
	@Override
	public Medecin ajouterMedecin(Medecin m) {
		try
		{
			if(db.connexionBD()==null)
			{
				db.connexionBD();				
			}
			String req = "INSERT INTO `medecin`(`nom`, `prenom`, `grade`, `specialite`) "
					+ "VALUES ('"+m.getNom()+"', '"+m.getPrenom()+"', '"+m.getGrade()+"', '"+m.getSpecialite()+"')";
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
	public Medecin updateMedecin(Medecin m) {
		try
		{
			if(db.connexionBD()==null)
			{
				db.connexionBD();				
			}
			String req = "UPDATE `medecin` SET `nom`='"+m.getNom()+"',`prenom`='"+m.getPrenom()+"',"
					+ "`grade`='"+m.getGrade()+"',`specialite`='"+m.getSpecialite()+"' WHERE `id_medecin`="+m.getIdMedecin()+"";
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
	public boolean desactiverMedecin(Long idMedecin) {
		try
		{
			if(db.connexionBD()==null)
			{
				db.connexionBD();				
			}
			String req = "UPDATE `medecin` SET `actif`="+false+" WHERE `id_medecin`="+idMedecin+"";
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
	public Medecin getMedecin(Long idMedecin) {
		try 
		{
			if(db.connexionBD()==null)
			{
				db.connexionBD();				
			}
			String req = "SELECT * FROM `medecin` WHERE id_medecin="+idMedecin+"";
			ResultSet rs =  db.executeQuery(req);
			Medecin m =  new Medecin();
			if(rs.next())
			{
				m.setIdMedecin(rs.getLong("id_medecin"));
				m.setNom(rs.getString("nom"));
				m.setPrenom(rs.getString("prenom"));
				m.setSpecialite(rs.getString("specialite"));
				m.setGrade(rs.getString("grade"));
				m.setActif(rs.getBoolean("actif"));
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
	public List<Medecin> allMedecin() {
		ArrayList<Medecin> medecins = new ArrayList<Medecin>();
		try 
		{
			if(db.connexionBD()==null)
			{
				db.connexionBD();				
			}
			String req = "SELECT * FROM `medecin`";
			ResultSet rs = db.executeQuery(req);
			while (rs.next()) {
				Medecin m =  new Medecin();
				m.setIdMedecin(rs.getLong("id_medecin"));
				m.setNom(rs.getString("nom"));
				m.setPrenom(rs.getString("prenom"));
				m.setSpecialite(rs.getString("specialite"));
				m.setGrade(rs.getString("grade"));
				m.setActif(rs.getBoolean("actif"));
				medecins.add(m);
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
		return medecins;
	}

	@Override
	public List<Medecin> allMedecinBySpecialite(String specialite) {
		ArrayList<Medecin> medecins = new ArrayList<Medecin>();
		try 
		{
			if(db.connexionBD()==null)
			{
				db.connexionBD();				
			}
			String req = "SELECT * FROM `medecin` WHERE specialite='"+specialite+"'";
			ResultSet rs = db.executeQuery(req);
			while (rs.next()) {
				Medecin m =  new Medecin();
				m.setIdMedecin(rs.getLong("id_medecin"));
				m.setNom(rs.getString("nom"));
				m.setPrenom(rs.getString("prenom"));
				m.setSpecialite(rs.getString("specialite"));
				m.setGrade(rs.getString("grade"));
				m.setActif(rs.getBoolean("actif"));
				medecins.add(m);
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
		return medecins;
	}

	@Override
	public List<Medecin> allMedecinByNameOrFirstName(String nom) {
		ArrayList<Medecin> medecins = new ArrayList<Medecin>();
		try 
		{
			if(db.connexionBD()==null)
			{
				db.connexionBD();				
			}
			String req = "SELECT * FROM `medecin` WHERE nom LIKE '%"+nom+"%' or prenom LIKE '%"+nom+"%'";
			ResultSet rs = db.executeQuery(req);
			while (rs.next()) {
				Medecin m =  new Medecin();
				m.setIdMedecin(rs.getLong("id_medecin"));
				m.setNom(rs.getString("nom"));
				m.setPrenom(rs.getString("prenom"));
				m.setSpecialite(rs.getString("specialite"));
				m.setGrade(rs.getString("grade"));
				m.setActif(rs.getBoolean("actif"));
				medecins.add(m);
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
		return medecins;
	}

}
