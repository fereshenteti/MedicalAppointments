package cnx;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class DBConnexion {
	
	private Connection con;
	private Statement stm;
	
	public Connection connexionBD()
	{
		try
		{
			Class.forName("com.mysql.jdbc.Driver");  
			con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/cabinet", "root", "");
        } 
		catch (Exception e) {             
            System.out.println(" Erreur de connexion � la Base de donn�es");
            e.getMessage();
        }
		return con;
	}
	
	public void deconnexionBD(){
        try 
        {
            con.close();
        } 
        catch (Exception e) {
            System.out.println(" D�connexion Impossible ");
        }
    }	
	
	public void executeUpdate(String req) throws Exception
	{
		stm = con.createStatement();
		stm.executeUpdate(req);
	}
	
	public ResultSet executeQuery(String req) throws Exception
	{
		stm = con.createStatement();
		return stm.executeQuery(req);
	}
	
}
