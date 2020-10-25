package service;


import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.print.attribute.standard.Media;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import entities.Compte;

@Path(value = "/banque")
public class BanqueRestService {
	private static Map<Integer,Compte> comptes = new HashMap<Integer, Compte>();
	
	@GET
	@Path("/conversion/{montant}")
	@Produces(MediaType.APPLICATION_JSON)
	public double conversion (@PathParam("montant") double montant) {
		return montant*11;
	}
	
	@GET
	@Path("/comptes/{code}")
	@Produces(MediaType.APPLICATION_JSON)
	public Compte getCompte(@PathParam("code") int code) {
		return new Compte(code,Math.random()*9000,new Date());
	}
	
	@GET
	@Path("/comptes")
	@Produces({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
	public List<Compte> listeComptes(){
		return new ArrayList<Compte>(comptes.values());
	}
	
	@POST
	@Path("/comptes")
	@Produces({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
	public Compte saveCompte(Compte compte) {
		comptes.put(compte.getCode(), compte);
		return compte;
	}
	
	@PUT
	@Path("/comptes/{code}")
	@Produces({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
	public Compte updateCompte(@PathParam("code")int code,Compte compte) {
		comptes.put(code, compte);
		return compte;
	}
	
	@DELETE
	@Path("/comptes/{code}")
	@Produces({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
	public Compte deleteCompte(@PathParam("code")int code) {
		Compte c = comptes.get(code);
		comptes.remove(code);
		return c;
	}
}
