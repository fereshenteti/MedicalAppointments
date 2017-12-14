package service;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import metier.MedecinCatalogueRDVImpl;

import com.sun.jersey.spi.resource.Singleton;

import entity.Medecin;
import entity.Patient;

@Singleton
@Path("/medecin")
@Produces(MediaType.APPLICATION_JSON+"; charset=utf-8")
public class MedecinService {

	private MedecinCatalogueRDVImpl metier;

	public MedecinService() {
		super();
		this.metier = new MedecinCatalogueRDVImpl();
	}
	
	@POST
	@Path(("/medecins"))
	@Consumes(MediaType.APPLICATION_JSON)
	public Medecin ajouterMedecin(Medecin m)
	{
		return metier.ajouterMedecin(m);
	}
	
	@PUT
	@Path("/medecins")
	public Medecin updateMedecin(Medecin m)
	{
		return metier.updateMedecin(m);
	}
	
	@DELETE
	@Path("/medecins")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public boolean desactiverMedecin(@FormParam(value="idMedecin") Long idMedecin)
	{
		return metier.desactiverMedecin(idMedecin);
	}
	
	@GET
	@Path("/medecins/{idMedecin}")
	public Medecin getMedecin(@PathParam(value="idMedecin") Long idMedecin)
	{
		return metier.getMedecin(idMedecin);
	}
	
	@GET
	@Path("/")
	public List<Medecin> allMedecin()
	{
		return metier.allMedecin();
	}
	
	@GET
	@Path("/medecinsFindNom/{nom}")
	public List<Medecin> getMedecin(@PathParam(value="nom") String nom)
	{
		return metier.allMedecinByNameOrFirstName(nom);
	}
	
	@GET
	@Path("/medecinsLogIN")
	public Medecin getMedecin(@QueryParam(value="username") String username, @QueryParam(value="password") String password)
	{
		return metier.signIN(username, password);
	}
	
	@GET
	@Path("/medecins")
	public List<Medecin> allMedecinBySpecialite(@QueryParam(value="specialite") String specialite)
	{
		return metier.allMedecinBySpecialite(specialite);
	}
	
}
