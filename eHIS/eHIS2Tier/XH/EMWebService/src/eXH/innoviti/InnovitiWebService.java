package eXH.innoviti;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/p5")
public class InnovitiWebService {

	@POST
	@Path("/TransRequest")
	@Consumes(MediaType.TEXT_PLAIN)
	public Response TransRequest(String actionKey) {
		System.out.println(" ::: Inside Innoviti Request ::: ");
		String responseTxt = "";
		try {

			responseTxt = InnovitiTransactions(actionKey);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			responseTxt = "E$!^Exception Occured";
		}
		return Response
				.ok(responseTxt)
				.header("Access-Control-Allow-Origin", "*")
				.header("Access-Control-Allow-Methods",
						"POST, GET, PUT, UPDATE, OPTIONS")
				.header("Access-Control-Allow-Headers",
						"Content-Type, Accept, X-Requested-With").build();
	}
	
	private String InnovitiTransactions(String actionKey){
		
		String responseTxt="";
		
		try{
			
			InnovitiTransaction InnovitiTrans = new InnovitiTransaction();
			
			responseTxt = InnovitiTrans.TransRequestMethod("INNOWEB", actionKey);
			
			if (responseTxt.indexOf("Error")==0)
			{
				return responseTxt;
			}
			
		}catch (Exception e) {
			System.out.println("( ::: InnovitiWebService:InnovitiTransaction) Exception at executing procedure ::: ");
			e.printStackTrace(System.err);
		}
		
		return responseTxt;
		
	}

}
