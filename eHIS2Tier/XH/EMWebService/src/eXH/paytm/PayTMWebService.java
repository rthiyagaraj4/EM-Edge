package eXH.paytm;


import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/p1")
public class PayTMWebService {
    
    @POST
    @Path("/TransRequest")
    @Consumes(MediaType.TEXT_PLAIN)
    public Response TransRequest(String actionKey) 
   {
    	System.out.println("::: Inside PayTm Request :::");
    	String responseTxt="";
	    try {
	    	
			responseTxt=PayTMTransactions(actionKey);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			responseTxt = "E$!^Exception Occured";
		}
		return Response.ok(responseTxt).header("Access-Control-Allow-Origin", "*")
			      .header("Access-Control-Allow-Methods", "POST, GET, PUT, UPDATE, OPTIONS")
			      .header("Access-Control-Allow-Headers", "Content-Type, Accept, X-Requested-With").build();
    }
    /*
    @GET
    @Path("/TransRequestGet/{actionKey}")
    @Produces(MediaType.TEXT_PLAIN)
    @Consumes(MediaType.TEXT_PLAIN)
    public String TransRequestGet(@PathParam("actionKey") String actionKey) 
   {
    
	   String responseTxt="";
	    try {
			responseTxt=PayTMTransactions(actionKey);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			responseTxt = "E$!^Exception Occured";
		}
		System.out.println("PayTMWebService:::final response.... " +responseTxt);
		return responseTxt;
    }
    */
    private String PayTMTransactions(String paramString) throws Exception 
	{
		String responseTxt="";

		try
		{   

			XHTransactionInterface PayTMTrans = new PayTMWithdrawTransaction();
				
			responseTxt = PayTMTrans.TransRequestMethod("PAYTMPROF1","PAYTM", paramString);

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


