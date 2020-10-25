package soapws;

public class BanqueServiceProxy implements soapws.BanqueService {
  private String _endpoint = null;
  private soapws.BanqueService banqueService = null;
  
  public BanqueServiceProxy() {
    _initBanqueServiceProxy();
  }
  
  public BanqueServiceProxy(String endpoint) {
    _endpoint = endpoint;
    _initBanqueServiceProxy();
  }
  
  private void _initBanqueServiceProxy() {
    try {
      banqueService = (new soapws.BanquewsLocator()).getBanqueServicePort();
      if (banqueService != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)banqueService)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)banqueService)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (banqueService != null)
      ((javax.xml.rpc.Stub)banqueService)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public soapws.BanqueService getBanqueService() {
    if (banqueService == null)
      _initBanqueServiceProxy();
    return banqueService;
  }
  
  public double conversion_euro_to_dh(double montant) throws java.rmi.RemoteException{
    if (banqueService == null)
      _initBanqueServiceProxy();
    return banqueService.conversion_euro_to_dh(montant);
  }
  
  public soapws.Compte recuperer_compte(int code) throws java.rmi.RemoteException{
    if (banqueService == null)
      _initBanqueServiceProxy();
    return banqueService.recuperer_compte(code);
  }
  
  public soapws.Compte[] recuperer_liste_comptes() throws java.rmi.RemoteException{
    if (banqueService == null)
      _initBanqueServiceProxy();
    return banqueService.recuperer_liste_comptes();
  }
  
  
}