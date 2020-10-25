/**
 * BanqueService.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package soapws;

public interface BanqueService extends java.rmi.Remote {
    public double conversion_euro_to_dh(double montant) throws java.rmi.RemoteException;
    public soapws.Compte recuperer_compte(int code) throws java.rmi.RemoteException;
    public soapws.Compte[] recuperer_liste_comptes() throws java.rmi.RemoteException;
}
