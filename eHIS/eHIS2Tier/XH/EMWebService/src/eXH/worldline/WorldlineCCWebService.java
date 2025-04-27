package eXH.worldline;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;


@Path("/v1")
public class WorldlineCCWebService {
	
	@POST
	@Path("/TransRequest")
	@Consumes(MediaType.TEXT_PLAIN)
	public Response TransRequest(String actionKey) {
		System.out.println(" ::: Inside Worldline Credit Card Request ::: ");
		String responseTxt = "";
		try {

			responseTxt = WorldLineCCTransactions(actionKey);
		} catch (Exception e) {
			e.printStackTrace();
			responseTxt = "E$!^Exception Occured";
		}
		System.out.println(" ::: WorldlineCCWebService response : "+responseTxt);
		return Response
				.ok(responseTxt)
				.header("Access-Control-Allow-Origin", "*")
				.header("Access-Control-Allow-Methods",
						"POST, GET, PUT, UPDATE, OPTIONS")
				.header("Access-Control-Allow-Headers",
						"Content-Type, Accept, X-Requested-With").build();
	}
	
private String WorldLineCCTransactions(String actionKey){
		
		String responseTxt="";
		
		try{
			
			WorldlineCCTransInterface WorldlineTrans = new WorldlineCCTransaction();
			
			responseTxt = WorldlineTrans.TransRequestMethod("WLCR", actionKey);
			
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
