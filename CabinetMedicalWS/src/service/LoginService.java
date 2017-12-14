package service;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import metier.LoginCatalogueRDVImpl;

import com.sun.jersey.spi.resource.Singleton;

@Singleton
@Path("/login")
@Produces(MediaType.APPLICATION_JSON+"; charset=utf-8")
public class LoginService {

	private LoginCatalogueRDVImpl metier;
	
	public LoginService() {
		super();
		this.metier = new LoginCatalogueRDVImpl();
	}
	
	@GET
	@Path("/")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public boolean signIN(@QueryParam("email")String email, @QueryParam("password")String password)
	{
		return metier.signIN(email, password);
	}
	
}
