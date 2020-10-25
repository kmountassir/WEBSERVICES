package test;

import java.rmi.RemoteException;

import soapws.BanqueServiceProxy;
import soapws.Compte;

public class ClientSoapWS {

	public static void main(String[] args) {
		BanqueServiceProxy proxy = new BanqueServiceProxy();
		try {
			System.out.println(proxy.conversion_euro_to_dh(100));
			Compte compte = proxy.recuperer_compte(3);
			System.out.println(compte.getCode());
			System.out.println(compte.getSolde());
			Compte[]comptes = proxy.recuperer_liste_comptes();
			for(Compte cp : comptes ) {
				System.out.println("----------");
				System.out.println(cp.getCode());
				System.out.println(cp.getSolde());
			}
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
