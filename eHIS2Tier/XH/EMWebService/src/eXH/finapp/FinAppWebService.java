package eXH.finapp;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import eXH.util.*;

@Path("/f1")
public class FinAppWebService {
	
	public static String l_debug_YN = "N";
	public static String l_app_msg = "";
	
	//Methods For Inbound transactions
	@POST
	@Path("/QueryPaymentDetails")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response QueryPayment(String actionKey,@Context HttpHeaders headers) {
		String responseTxt = "";
		String[] str = null;
		
		String addedDate = new java.text.SimpleDateFormat( "yyyy-MM-dd HH:mm:ss" ).format( new java.util.Date() ) ;
		
		try {
			
			l_debug_YN = XHUtil.getDebugYN();
			
			System.out.println(" ::: Query Payment Details API  Request Date time ::: "+addedDate);
			
			l_app_msg = " ::: Inside Query Payment ::: ";
			if (l_debug_YN.equals("Y"))	
				System.out.println(l_app_msg);
			
				responseTxt = QueryPaymentDetails(actionKey, "F01");
			
			str = responseTxt.split("#");
			
			System.out.println(" .............................................................................. ");
			
		} catch (Exception e) {
			e.printStackTrace();
			responseTxt = "E#Exception Occured";
		}
		return Response.status(responseCode(str[0])).entity(str[1]).build();
	}

	@POST
	@Path("/RegisterVisit")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response RegisterVisit(String actionKey) { 
		String responseTxt = "";
		String[] str = null;
		
		String addedDate = new java.text.SimpleDateFormat( "yyyy-MM-dd HH:mm:ss" ).format( new java.util.Date() ) ;
		
		try {
			
			l_debug_YN = XHUtil.getDebugYN();
			
			System.out.println(" ::: RegisterVisit API  Request Date time ::: "+addedDate);
			System.out.println(" .............................................................................. ");
			
			responseTxt = calRegisterVisit(actionKey); 
			str = responseTxt.split("#");
			
			System.out.println(" .............................................................................. ");
		} catch (Exception e) {
			e.printStackTrace();
			responseTxt = "E#Exception Occured";
		}
		return Response.status(responseCode(str[0])).entity(str[1]).build();	
	}

	@POST
	@Path("/QueryApprovalServices")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response QueryApprovalServices(String actionKey) { 
		String responseTxt = "";
		String[] str = null;
		
		String addedDate = new java.text.SimpleDateFormat( "yyyy-MM-dd HH:mm:ss" ).format( new java.util.Date() ) ;
		
		try {
			
			l_debug_YN = XHUtil.getDebugYN();
			
			System.out.println(" ::: RegisterVisit API  Request Date time ::: "+addedDate);
			System.out.println(" .............................................................................. ");
			
			responseTxt = QueryServices(actionKey);
			str = responseTxt.split("#");
			
			System.out.println(" .............................................................................. ");
		} catch (Exception e) {
			e.printStackTrace();
			responseTxt = "E#Exception Occured";
		}
		return Response.status(responseCode(str[0])).entity(str[1]).build();	
	}

	@POST
	@Path("/UpdateApprovalStatus")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response UpdateApprovalStatus(String actionKey) { 
		String responseTxt = "";
		String[] str = null;
		
		String addedDate = new java.text.SimpleDateFormat( "yyyy-MM-dd HH:mm:ss" ).format( new java.util.Date() ) ;
		
		try {
			
			l_debug_YN = XHUtil.getDebugYN();
			
			System.out.println(" ::: RegisterVisit API  Request Date time ::: "+addedDate);
			System.out.println(" .............................................................................. ");
			
			responseTxt = UpdateApproval(actionKey);
			str = responseTxt.split("#");
			
			System.out.println(" .............................................................................. ");
		} catch (Exception e) {
			e.printStackTrace();
			responseTxt = "E#Exception Occured";
		}
		return Response.status(responseCode(str[0])).entity(str[1]).build();	
	}
	
	
	
	
	private String QueryPaymentDetails(String paramString, String requestType){
		String responseTxt = "";		
		
		try {
			
				l_app_msg = " ::: Inside QueryPaymentDetails ::: ";
				if (l_debug_YN.equals("Y"))	
					System.out.println(l_app_msg);
				
				l_app_msg = " ::: Inside QueryPaymentDetails paramString ::: "+paramString;
				if (l_debug_YN.equals("Y"))	
					System.out.println(l_app_msg);

				QueryPaymentDetails QHISTrans = new QueryPaymentDetails();
	
				responseTxt = QHISTrans.processRequest(paramString, requestType);
				
				l_app_msg = " ::: Inside QueryPaymentDetails responseTxt ::: "+responseTxt;
				if (l_debug_YN.equals("Y"))	
					System.out.println(l_app_msg);
	
			} catch (Exception exp) {
			System.out.println("(QueryPaymentDetails) Exception occurred : "+exp.getMessage());
			exp.printStackTrace(System.err);
		}
		
		return responseTxt;
	}

	public Response.Status responseCode(String code){
		if (code.equals("200")) {
			return Response.Status.OK;
		} else if (code.equals("400")) {
			return Response.Status.BAD_REQUEST;
		} else if (code.equals("401")) {
			return Response.Status.UNAUTHORIZED;
		} else if (code.equals("403")) {
			return Response.Status.FORBIDDEN;
		} else  {
			return Response.Status.INTERNAL_SERVER_ERROR;
		}
	}
	
	
		private String calRegisterVisit(String paramString) throws Exception {
			String responseTxt = "";

			try {
				
					l_app_msg = " ::: Inside Regiser Visit ::: ";
					if (l_debug_YN.equals("Y"))	
						System.out.println(l_app_msg);
					
					l_app_msg = " ::: Inside Register Visit paramString ::: "+paramString;
					if (l_debug_YN.equals("Y"))	
						System.out.println(l_app_msg);

					FinAppRegisterVisit RegVisit = new FinAppRegisterVisit();

					responseTxt = RegVisit.processRequest(paramString);
					
					l_app_msg = " ::: Inside Register Visit responseTxt ::: "+responseTxt;
					if (l_debug_YN.equals("Y"))	
						System.out.println(l_app_msg);

			} catch (Exception exp) {
				exp.printStackTrace(System.err);
			}
			return responseTxt;
		}

		private String QueryServices(String paramString){
		String responseTxt = "";		
		
		try {
			
				l_app_msg = " ::: Inside QueryServices ::: ";
				if (l_debug_YN.equals("Y"))	
					System.out.println(l_app_msg);
				
				l_app_msg = " ::: Inside QueryServices paramString ::: "+paramString;
				if (l_debug_YN.equals("Y"))	
					System.out.println(l_app_msg);

				QueryApprovalServices QASTrans = new QueryApprovalServices();
	
				responseTxt = QASTrans.processRequest(paramString);
				
				l_app_msg = " ::: Inside QueryServices responseTxt ::: "+responseTxt;
				if (l_debug_YN.equals("Y"))	
					System.out.println(l_app_msg);
	
			} catch (Exception exp) {
			System.out.println("(QueryServices) Exception occurred : "+exp.getMessage());
			exp.printStackTrace(System.err);
		}
		
		return responseTxt;
	}

	private String UpdateApproval(String paramString){
		String responseTxt = "";		
		
		try {
			
				l_app_msg = " ::: Inside UpdateApproval ::: ";
				if (l_debug_YN.equals("Y"))	
					System.out.println(l_app_msg);
				
				l_app_msg = " ::: Inside UpdateApproval paramString ::: "+paramString;
				if (l_debug_YN.equals("Y"))	
					System.out.println(l_app_msg);

				UpdateApprovalServices UASTrans = new UpdateApprovalServices();
	
				responseTxt = UASTrans.processRequest(paramString);
				
				l_app_msg = " ::: Inside UpdateApproval responseTxt ::: "+responseTxt;
				if (l_debug_YN.equals("Y"))	
					System.out.println(l_app_msg);
	
			} catch (Exception exp) {
			System.out.println("(UpdateApproval) Exception occurred : "+exp.getMessage());
			exp.printStackTrace(System.err);
		}
		
		return responseTxt;
	}


	
}
