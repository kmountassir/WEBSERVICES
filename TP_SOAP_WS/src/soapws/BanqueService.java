package soapws;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

import entities.Compte;

@WebService(serviceName = "banquews")
public class BanqueService {
	
	@WebMethod(operationName = "conversion_euro_to_dh")
	public double conversion (@WebParam(name = "montant") double montant) {
		return montant*11;
	}
	
	@WebMethod(operationName = "recuperer_compte")
	public Compte getCompte(@WebParam(name = "code") int code) {
		return new Compte(code,Math.random()*9000,new Date());
	}
	
	@WebMethod(operationName = "recuperer_liste_comptes")
	public List<Compte> listeComptes(){
		List<Compte>comptes = new ArrayList<Compte>();
		comptes.add(new Compte(1,Math.random()*9000,new Date()));
		comptes.add(new Compte(2,Math.random()*9000,new Date()));
		comptes.add(new Compte(3,Math.random()*9000,new Date()));
		return comptes;
	}
}
