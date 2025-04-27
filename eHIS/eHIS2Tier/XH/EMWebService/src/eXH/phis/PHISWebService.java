package eXH.phis;

import javax.ws.rs.Consumes;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/p2")
public class PHISWebService {
	@POST
    @Path("/TransRequest")
    @Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
    public Response TransRequest(String actionKey) 
	{
		String responseTxt="";
	    try {
	    	
			responseTxt=PHISTransactions(actionKey);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			responseTxt = "E$!^Exception Occured";
		}
		return Response.ok(responseTxt).header("Access-Control-Allow-Origin", "*")
			      .header("Access-Control-Allow-Methods", "POST, GET, PUT, UPDATE, OPTIONS")
			      .header("Access-Control-Allow-Headers", "Content-Type, Accept, X-Requested-With").build();
    }
	
	private String PHISTransactions(String paramString) throws Exception 
	{
			String responseTxt="";

			try
			{   
				PHISTransaction PHISTrans = new PHISTransaction();
					
				responseTxt = PHISTrans.TransRequestMethod(paramString);

				if (responseTxt.indexOf("Error")==0)
				{
					return responseTxt;
				}				
				
			}
			catch(Exception exp)
			{
				System.out.println("(PHISWebService:PHISTransactions) Exception at executing procedure");
				exp.printStackTrace(System.err);
			}
			return responseTxt;	
		}
}
