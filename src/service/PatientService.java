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
import javax.ws.rs.core.MediaType;

import metier.PatientCatalogueRDVImpl;

import com.sun.jersey.spi.resource.Singleton;

import entity.Patient;

@Singleton
@Path("/patient")
@Produces(MediaType.APPLICATION_JSON+"; charset=utf-8")
public class PatientService {

	private PatientCatalogueRDVImpl metier;

	public PatientService() {
		super();
		this.metier = new PatientCatalogueRDVImpl();
	}
	
	@POST
	@Path("/patients")
	@Consumes(MediaType.APPLICATION_JSON)
	public Patient ajouterPatient(Patient m)
	{
		return metier.ajouterPatient(m);
	}
	
	@PUT
	@Path("/patients")
	public Patient updatePatient(Patient m)
	{
		return metier.updatePatient(m);
	}
	
	@DELETE
	@Path("/patients")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public boolean desactiverPatient(@FormParam(value="idPatient") Long idPatient)
	{
		return metier.desactiverPatient(idPatient);
	}
	
	@GET
	@Path("/patients/{idPatient}")
	public Patient getPatient(@PathParam(value="idPatient") Long idPatient)
	{
		return metier.getPatient(idPatient);
	}
	
	@GET
	@Path("/patientsFindNom/{nom}")
	public List<Patient> getPatient(@PathParam(value="nom") String nom)
	{
		return metier.allPatientByNameOrFirstName(nom);
	}
	
	@GET
	@Path("/")
	public List<Patient> allPatient()
	{
		return metier.allPatient();
	}
	
}
