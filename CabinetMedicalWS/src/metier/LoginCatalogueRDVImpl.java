package metier;

import java.sql.ResultSet;

import cnx.DBConnexion;

public class LoginCatalogueRDVImpl implements ILoginCatalogueRDV{

	DBConnexion db = new DBConnexion();
	
	@Override
	public boolean signIN(String email, String password) {
		try 
		{
			if(db.connexionBD()==null)
			{
				db.connexionBD();				
			}
			String req = "SELECT * FROM `user` WHERE username= '"+email+"' and password= '"+password+"'";
			ResultSet rs =  db.executeQuery(req);
			if(rs.next())
			{
				return true;
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
		return false;
	}

}
