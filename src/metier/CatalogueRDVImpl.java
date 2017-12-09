package metier;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import cnx.DBConnexion;
import entity.Medecin;
import entity.Patient;
import entity.Rdv;

public class CatalogueRDVImpl implements ICatalogueRDV{

	DBConnexion db = new DBConnexion();
	
	@Override
	public Rdv ajouterRDV(Rdv r) {
		try
		{
			if(db.connexionBD()==null)
			{
				db.connexionBD();				
			}
			String req = "INSERT INTO `rdv`(`date_rdv`, `tranche_heure`, `id_patient`, `id_medecin`) "
					+ "VALUES ('"+r.getDateRDV().substring(0, 10)+"', '"+r.getTrancheHeure()+"', "+r.getPatient().getIdPatient()+", "+r.getMedecin().getIdMedecin()+")";
			db.executeUpdate(req);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		finally
		{
			db.deconnexionBD();
		}
		return r;
	}

	@Override
	public Rdv updateRDV(Rdv r) {
		try
		{
			if(db.connexionBD()==null)
			{
				db.connexionBD();				
			}
			String req = "UPDATE `rdv` SET `date_rdv`='"+r.getDateRDV()+"',`tranche_heure`='"+r.getTrancheHeure()+"',"
					+ "`id_patient`="+r.getPatient().getIdPatient()+",`id_medecin`="+r.getMedecin().getIdMedecin()+" WHERE `id_rdv`="+r.getIdRDV()+"";
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
		return r;
	}

	@Override
	public boolean deleteRDV(Long idRdv) {
		try
		{
			if(db.connexionBD()==null)
			{
				db.connexionBD();				
			}
			String req = "DELETE FROM `rdv` WHERE `id_rdv`="+idRdv+"";
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
	public Rdv getRDV(Long idRdv) {
		try 
		{
			if(db.connexionBD()==null)
			{
				db.connexionBD();				
			}
			String req = "SELECT * FROM `rdv` WHERE id_rdv="+idRdv+"";
			ResultSet rs =  db.executeQuery(req);
			Rdv r = new Rdv();
			if(rs.next())
			{
				r.setIdRDV(rs.getLong("id_rdv"));
				r.setDateRDV(rs.getString("date_rdv"));
				r.setTrancheHeure(rs.getString("tranche_heure"));
				r.setPatient(getPatient(rs.getLong("id_patient")));
				r.setMedecin(getMedecin(rs.getLong("id_medecin")));
			}
			return r;
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
	public List<Rdv> allRDV() {
		ArrayList<Rdv> rdvs = new ArrayList<Rdv>();
		try 
		{
			if(db.connexionBD()==null)
			{
				db.connexionBD();				
			}
			String req = "SELECT * FROM `rdv`";
			ResultSet rs = db.executeQuery(req);
			while (rs.next()) {
				Rdv r = new Rdv();
				r.setIdRDV(rs.getLong("id_rdv"));
				r.setDateRDV(rs.getString("date_rdv"));
				r.setTrancheHeure(rs.getString("tranche_heure"));
				r.setPatient(getPatient(rs.getLong("id_patient")));
				r.setMedecin(getMedecin(rs.getLong("id_medecin")));
				rdvs.add(r);
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
		return rdvs;
	}

	@Override
	public List<Rdv> allRDVByDate(String date) {
		ArrayList<Rdv> rdvs = new ArrayList<Rdv>();
		try 
		{
			if(db.connexionBD()==null)
			{
				db.connexionBD();		
			}
			String req = "SELECT * FROM `rdv` WHERE date_rdv='"+date+"'";
			ResultSet rs = db.executeQuery(req);
			while (rs.next()) {
				Rdv r = new Rdv();
				r.setIdRDV(rs.getLong("id_rdv"));
				r.setDateRDV(rs.getString("date_rdv"));
				r.setTrancheHeure(rs.getString("tranche_heure"));
				r.setPatient(getPatient(rs.getLong("id_patient")));
				r.setMedecin(getMedecin(rs.getLong("id_medecin")));
				rdvs.add(r);
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
		return rdvs;
	}
	
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
	public List<Rdv> allRDVByMedecin(Long idMedecin) {
		ArrayList<Rdv> rdvs = new ArrayList<Rdv>();
		try 
		{
			if(db.connexionBD()==null)
			{
				db.connexionBD();		
			}
			String req = "SELECT * FROM `rdv` WHERE id_medecin="+idMedecin+"";
			ResultSet rs = db.executeQuery(req);
			while (rs.next()) {
				Rdv r = new Rdv();
				r.setIdRDV(rs.getLong("id_rdv"));
				r.setDateRDV(rs.getString("date_rdv"));
				r.setTrancheHeure(rs.getString("tranche_heure"));
				r.setPatient(getPatient(rs.getLong("id_patient")));
				r.setMedecin(getMedecin(rs.getLong("id_medecin")));
				rdvs.add(r);
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
		return rdvs;
	}

	@Override
	public List<Rdv> allRDVByPatient(Long idPatient) {
		ArrayList<Rdv> rdvs = new ArrayList<Rdv>();
		try 
		{
			if(db.connexionBD()==null)
			{
				db.connexionBD();		
			}
			String req = "SELECT * FROM `rdv` WHERE id_patient="+idPatient+"";
			ResultSet rs = db.executeQuery(req);
			while (rs.next()) {
				Rdv r = new Rdv();
				r.setIdRDV(rs.getLong("id_rdv"));
				r.setDateRDV(rs.getString("date_rdv"));
				r.setTrancheHeure(rs.getString("tranche_heure"));
				r.setPatient(getPatient(rs.getLong("id_patient")));
				r.setMedecin(getMedecin(rs.getLong("id_medecin")));
				rdvs.add(r);
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
		return rdvs;
	}

}
