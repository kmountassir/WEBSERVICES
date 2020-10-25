package endpoint;

import javax.xml.ws.Endpoint;

import soapws.BanqueService;

public class ServeurJaxWS {
	public static void main(String[] args) {
		String url = "http://0.0.0.0:8090/";
		Endpoint.publish(url, new BanqueService());
		System.out.println("Webservice deployé sur "+url);
	}
}
