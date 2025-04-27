package eXH.pancard;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;




@Path("/p4")
public class PanCardWebService {
	
	@POST
    @Path("/TransRequest")
    @Consumes(MediaType.TEXT_PLAIN)
    public Response TransRequest(String actionKey) 
   {
    	System.out.println("::: Inside PanCard Request :::");
    	String responseTxt="";
	    try {
	    	
			responseTxt=PanTransactions(actionKey);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			responseTxt = "E$!^Exception Occured";
		}
		return Response.ok(responseTxt).header("Access-Control-Allow-Origin", "*")
			      .header("Access-Control-Allow-Methods", "POST, GET, PUT, UPDATE, OPTIONS")
			      .header("Access-Control-Allow-Headers", "Content-Type, Accept, X-Requested-With").build();
    }
	
	private String PanTransactions(String paramString) throws Exception 
	{
		String responseTxt="";

		try
		{   

			PanCardTransaction PanCardTrans = new PanCardTransaction();
				
			responseTxt = PanCardTrans.TransRequestMethod("PANCARPROF1","PANCARD", paramString);

			if (responseTxt.indexOf("Error")==0)
			{
				return responseTxt;
			}				
			
		}
		catch(Exception exp)
		{
			System.out.println("(PayTMWebService:PayTMTransactions) Exception at executing procedure");
			exp.printStackTrace(System.err);
		}

		return responseTxt;	
	}

}
