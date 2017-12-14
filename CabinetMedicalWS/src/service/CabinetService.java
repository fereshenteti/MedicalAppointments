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

import metier.CatalogueRDVImpl;

import com.sun.jersey.spi.resource.Singleton;

import entity.Rdv;

@Singleton
@Path("/cabinet")
@Produces(MediaType.APPLICATION_JSON+"; charset=utf-8")
public class CabinetService {
	
	private CatalogueRDVImpl metier;

	public CabinetService() {
		super();
		this.metier = new CatalogueRDVImpl();
	}
	
	@POST  
	@Path(("/rdvs"))
	@Consumes(MediaType.APPLICATION_JSON)
	public Rdv ajouterRDV(Rdv r)
	{
		return metier.ajouterRDV(r);
	}
	
	@PUT
	@Path("/rdvs")
	public Rdv updateRDV(Rdv r)
	{
		return metier.updateRDV(r);
	}
	
	@DELETE
	@Path("/rdvs")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public boolean deleteRDV(@FormParam(value="idRdv") Long idRdv)
	{
		return metier.deleteRDV(idRdv);
	}
	
	@GET
	@Path("/rdvs/{idRdv}")
	public Rdv getRDV(@PathParam(value="idRdv")Long idRdv)
	{
		return metier.getRDV(idRdv);
	}
	
	@GET
	@Path("/")
	public List<Rdv> allRDV()
	{
		return metier.allRDV();
	}
	
	@GET
	@Path("/rdvs")
	public List<Rdv> allRDVByDate(@QueryParam(value="date") String date)
	{
		return metier.allRDVByDate(date);
	}
	
	@GET
	@Path("/rdvsMedecin")
	public List<Rdv> allRDVByMedecin(@QueryParam(value="idMedecin") Long idMedecin)
	{
		return metier.allRDVByMedecin(idMedecin);
	}
	
	@GET
	@Path("/rdvsMedecinByDate")
	public List<Rdv> allRDVByMedecinByDate(@QueryParam(value="idMedecin") Long idMedecin, @QueryParam(value="date") String date)
	{
		return metier.allRDVByMedecinByDate(idMedecin, date);
	}
	
	@GET
	@Path("/rdvsPatient")
	public List<Rdv> allRDVByDate(@QueryParam(value="idPatient") Long idPatient)
	{
		return metier.allRDVByPatient(idPatient);
	}
	
}
