package eXH.saml;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.joda.time.DateTime;


import eXH.saml.SamlCommunication;


@Path("/s1")


public class samlWebService {
	
	@POST
	@Path("/TransRequest")
	@Consumes(MediaType.TEXT_PLAIN)
	public Response TransRequest(String actionKey) {
		String addedDate = new java.text.SimpleDateFormat( "yyyy-MM-dd HH:mm:ss" ).format( new java.util.Date() ) ;
		
		System.out.println(" ::: Inside Malaffi Request Date time ::: "+addedDate);
		System.out.println(" ::: Action Key... "+actionKey);
		String responseTxt = "";
		try {

			responseTxt = SamlTransactions(actionKey);
			System.out.println(" .............................................................................. ");
		} catch (Exception e) {
			e.printStackTrace();
			responseTxt = "E$!^Exception Occured$!^"+e.getMessage();
		}

		return Response
				.ok(responseTxt)
				.header("Access-Control-Allow-Origin", "*")
				.header("Access-Control-Allow-Methods",
						"POST, GET, PUT, UPDATE, OPTIONS")
				.header("Access-Control-Allow-Headers",
						"Content-Type, Accept, X-Requested-With").build();
	}
	
	private String SamlTransactions(String actionKey){
		
		String responseTxt="";
		
		try{
			
			SamlCommunication samlcomm = new SamlCommunication();
			
			responseTxt = samlcomm.TransRequestMethod("MALAFFI", actionKey);
			
			if (responseTxt.indexOf("Error")==0)
			{
				return responseTxt;
			}
			
		}catch (Exception e) {
			System.out.println("( ::: SamlWebService:SamlTransactions) Exception at executing procedure ::: ");
			e.printStackTrace(System.err);
		}
		
		return responseTxt;
		
	}

}
	


