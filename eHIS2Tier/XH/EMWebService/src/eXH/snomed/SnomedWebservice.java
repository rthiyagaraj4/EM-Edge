package eXH.snomed;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.apache.commons.httpclient.HttpStatus;
import eXH.snomed.SnomedTransaction;

@Path("/s1")

public class SnomedWebservice {
	
	public static List<String> responseTxt;
	public static String response_str="";
	
	@POST
	@Path("/snomedRequest")
	@Consumes(MediaType.TEXT_PLAIN)
	@Produces({MediaType.TEXT_PLAIN})
	public  String SnomedRequest(String actionKey) {
		
		System.out.println(" ::: Inside SNOMED Request ::: ");
		System.out.println(" ::: Action Key... "+actionKey);
		// responseTxt =new ArrayList<String>();
		try {
			response_str = SnomedTransactions(actionKey);		
			System.out.println(" ::: Inside SNOMED Request try::: "+response_str);		
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			String responseTxt1 = "E$!^Exception Occured";
			System.out.println(" ::: Inside SNOMED Request Exception::: "+responseTxt1);		
		}
		
		return response_str;
				/*.ok(response_str)
				.header("Access-Control-Allow-Origin", "*")
				.header("Access-Control-Allow-Methods",
						"POST, GET, PUT, UPDATE, OPTIONS")
				.header("Access-Control-Allow-Headers",
						"Content-Type, Accept, X-Requested-With").build(); */
	}

	private String SnomedTransactions(String actionKey){
		
		responseTxt=new ArrayList<String>();		
		try{	
			SnomedTransaction SnomedTrans = new SnomedTransaction();	
			responseTxt =  SnomedTrans.TransRequestMethod("SNOMED",actionKey);
			
			StringBuffer sb= new StringBuffer();
			for (String s: responseTxt)
			{
				sb.append(s);
				sb.append(",");
			}
			
			response_str=sb.toString();
			
		}catch (Exception e) {
			System.out.println("( ::: SNOMEDWebService:SNOMEDTransaction) Exception at executing procedure ::: ");
			e.printStackTrace(System.err);
		}
		
		return response_str;
		
	}
	
}
