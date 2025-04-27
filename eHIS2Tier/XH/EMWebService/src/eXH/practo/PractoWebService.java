package eXH.practo;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import eXH.util.*;

@Path("/p3")
public class PractoWebService {
	
	public static String l_debug_YN = "N";
	public static String l_app_msg = "";
	
	//Methods For Inbound transactions
	//Added for KDAH-CRF-0456 by Kapil on 25/07/2018
	@POST
	@Path("/bookAppointment")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response BookTrans(String actionKey,@Context HttpHeaders headers) {
		//String dbDetails = ConnectionManager.getDBDetails();
		String responseTxt = "", responseTxtPayment="";
		String[] str = null;
		
		String addedDate = new java.text.SimpleDateFormat( "yyyy-MM-dd HH:mm:ss" ).format( new java.util.Date() ) ;
		
		try {
			
			l_debug_YN = XHUtil.getDebugYN();
			
			System.out.println(" ::: Appointments API - Book Appointment Request Date time ::: "+addedDate);
			System.out.println(" .............................................................................. ");
			
			l_app_msg = " ::: Inside Book Appointment ::: ";
			if (l_debug_YN.equals("Y"))	
				System.out.println(l_app_msg);
			
			String key = headers.getRequestHeader("key").get(0);
			
			responseTxt = PractoInboundTransactions(actionKey, "OA21", key);
			
			System.out.println(" .............................................................................. ");
			System.out.println("::: Book Appointment Response... "+responseTxt);
			System.out.println(" .............................................................................. ");
			
			if ((actionKey.contains("bankrefNo") || actionKey.contains("netAmountDebit")) &&
			(!(responseTxt.contains("Error") || responseTxt.contains("\"status\":0"))))
			{
				System.out.println("::: Book Appointment with payment Details :::");
				responseTxtPayment=PractoPaymentTransactions(actionKey,"OA25",false);
			}
			if (responseTxtPayment.contains("Error")||responseTxtPayment.contains("\"status\":0")){
				str=responseTxtPayment.split("#");
			}
			else{
				str = responseTxt.split("#");
			}
			
			System.out.println(" .............................................................................. ");
			
		} catch (Exception e) {
			e.printStackTrace();
			responseTxt = "E#Exception Occured";
		}
		return Response.status(responseCode(str[0])).entity(str[1]).build();
		//return responseTxt;
	}

	@POST
	@Path("/cancelAppointment")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response CancelTrans(String actionKey,@Context HttpHeaders headers) {
		String responseTxt = "";
		String[] str = null;
		
		String addedDate = new java.text.SimpleDateFormat( "yyyy-MM-dd HH:mm:ss" ).format( new java.util.Date() ) ;
		
		
		try {
			
				l_debug_YN = XHUtil.getDebugYN();
				
				System.out.println(" ::: Appointments API - Cancel Appointment Request Date time ::: "+addedDate);
				System.out.println(" .............................................................................. ");
			
				l_app_msg = " ::: Inside Cancel Appointment ::: ";
				if (l_debug_YN.equals("Y"))	
					System.out.println(l_app_msg);
				
				String key =  headers.getRequestHeaders().get("key").get(0);
			
				responseTxt = PractoInboundTransactions(actionKey, "OA22", key);
				str = responseTxt.split("#");
				
				System.out.println(" .............................................................................. ");
			
		} catch (Exception e) {
			e.printStackTrace();
			responseTxt = "E#Exception Occured";
		}
		
		return Response.status(responseCode(str[0])).entity(str[1]).build();
		//return responseTxt;
		
	}

	@POST
	@Path("/rescheduleAppointment")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response RescheduleTrans(String actionKey,@Context HttpHeaders headers) {
		String responseTxt = "";
		String[] str = null;
		
		String addedDate = new java.text.SimpleDateFormat( "yyyy-MM-dd HH:mm:ss" ).format( new java.util.Date() ) ;		
		
		try {
			
				l_debug_YN = XHUtil.getDebugYN();
				
				System.out.println(" ::: Appointments API - Reschedule Appointment Request Date time ::: "+addedDate);
				System.out.println(" .............................................................................. ");
			
				l_app_msg = " ::: Inside Reshedule Appointment ::: ";
				if (l_debug_YN.equals("Y"))	
					System.out.println(l_app_msg);
			
				String key = headers.getRequestHeader("key").get(0);
				responseTxt = PractoInboundTransactions(actionKey, "OA23", key);
				str = responseTxt.split("#");
				
				System.out.println(" .............................................................................. ");
			
		} catch (Exception e) {
			e.printStackTrace();
			responseTxt = "E#Exception Occured";
		}
		return Response.status(responseCode(str[0])).entity(str[1]).build();
		//return responseTxt;

	}
	
	@POST
	@Path("/blockAppointment")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response BlockTrans(String actionKey,@Context HttpHeaders headers) {
		String responseTxt = "";
		String[] str = null;
		
		String addedDate = new java.text.SimpleDateFormat( "yyyy-MM-dd HH:mm:ss" ).format( new java.util.Date() ) ;
		
		try {
			
				l_debug_YN = XHUtil.getDebugYN();
				
				System.out.println(" ::: Appointments API - Block Appointment Request Date time ::: "+addedDate);
				System.out.println(" .............................................................................. ");
			
				l_app_msg = " ::: Inside Block Appointment ::: ";
				if (l_debug_YN.equals("Y"))	
					System.out.println(l_app_msg);
				
				String key = headers.getRequestHeader("key").get(0);
				responseTxt = PractoInboundTransactions(actionKey, "OA24", key);
				str = responseTxt.split("#");
				
				System.out.println(" .............................................................................. ");
			
		} catch (Exception e) {
			e.printStackTrace();
			responseTxt = "E#Exception Occured";
		}
		return Response.status(responseCode(str[0])).entity(str[1]).build();
		//return responseTxt;

	}
	
	//Added for KDAH-CRF-0513
	
	@POST
	@Path("/AppointmentsPayment")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public Response PaymentTrans(String actionKey,@Context HttpHeaders headers) {
		System.out.println("::: Inside Practo Payment Request :::");
    	String responseTxt="";
    	String[] str = null;
    	
    	String addedDate = new java.text.SimpleDateFormat( "yyyy-MM-dd HH:mm:ss" ).format( new java.util.Date() ) ;
   	
	    try {
	    	
	    	System.out.println(" ::: Appointments API - Payment Request Date time ::: "+addedDate);
			System.out.println(" .............................................................................. ");
	    	
			responseTxt=PractoPaymentTransactions(actionKey,"OA25",true);
			str = responseTxt.split("#");
			
			System.out.println(" .............................................................................. ");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			responseTxt = "E$!^Exception Occured";
		}
	    return Response.status(responseCode(str[0])).entity(str[1]).build();
	}
	
	//Method For outbound transactions
	//Added for KDAH-CRF-0456 by Krupa on 25/07/2018
	@POST
	@Path("/TransRequest")
	@Consumes(MediaType.TEXT_PLAIN)
	public Response TransRequest(String actionKey) {
		String responseTxt = "";
		try {
			
			l_debug_YN = XHUtil.getDebugYN();
			
			responseTxt = PractoOutboundTransactions(actionKey);
		} catch (Exception e) {
			e.printStackTrace();
			responseTxt = "E$!^Exception Occured";
		}
		return Response.status(200).entity(responseTxt).build();
	}
	
	//Method For Patient Details transactions
	//Added for KDAH-CRF-0523 by Kapil on 19/03/2019
	@POST
	@Path("/QueryPatientDetails")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response patientDetails(String actionKey) {
		String responseTxt = "";
		String[] str = null;
		
		String addedDate = new java.text.SimpleDateFormat( "yyyy-MM-dd HH:mm:ss" ).format( new java.util.Date() ) ;
		
		try {
			
			System.out.println(" ::: Appointments API - Query Patient Details Request Date time ::: "+addedDate);
			System.out.println(" .............................................................................. ");
			
			l_debug_YN = XHUtil.getDebugYN();
			
			responseTxt = PatientDetailsTransactions(actionKey);
			str = responseTxt.split("#");
			
			if (str.length > 1)
			{
				//str[1] = str[1].replaceAll("null", "\"\"");
				str[1] = str[1].replaceAll("\\$\\$", "#");				
			}
			
			System.out.println(" .............................................................................. ");
			
		} catch (Exception e) {
			e.printStackTrace();
			responseTxt = "E$!^Exception Occured";
		}
		return Response.status(responseCode(str[0])).entity(str[1]).build();
	}
	
	
	
	//Method For Query Visit Consultation transactions
	//Added for KDAH-CRF-0524 by Kapil on 22/03/2019
	@POST
	@Path("/QueryVisitType")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response QueryVisitType(String actionKey) {
		String responseTxt = "";
		String[] str = null;
		
		String addedDate = new java.text.SimpleDateFormat( "yyyy-MM-dd HH:mm:ss" ).format( new java.util.Date() ) ;
		
		try {
			
			l_debug_YN = XHUtil.getDebugYN();
			
			System.out.println(" ::: Appointments API - Query Visit Type Request Date time ::: "+addedDate);
			System.out.println(" .............................................................................. ");
			
			l_app_msg = " ::: Inside Query Visit Type  ::: ";
			if (l_debug_YN.equals("Y"))	
				System.out.println(l_app_msg);
			
			responseTxt = QueryVisitTypeTransaction(actionKey);
			str = responseTxt.split("#");
			
			if (str.length > 1)
			{
				//str[1] = str[1].replaceAll("null", "\"\"");
				str[1] = str[1].replaceAll("\\$\\$", "#");				
			}
			
			System.out.println(" .............................................................................. ");
			
		} catch (Exception e) {
			e.printStackTrace();
			responseTxt = "E#Exception Occured";
		}
		return Response.status(responseCode(str[0])).entity(str[1]).build();
	}
	
	// Method Added for Patient Registration
	// Added for KDAH-CRF-0523 by Kapil on 26/03/2019
	@POST
	@Path("/RegisterPatientDetails")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response patientRegistration(String actionKey) {
		String responseTxt = "";
		String[] str = null;
		
		String addedDate = new java.text.SimpleDateFormat( "yyyy-MM-dd HH:mm:ss" ).format( new java.util.Date() ) ;
		
		try {
			
			l_debug_YN = XHUtil.getDebugYN();
			
			System.out.println(" ::: Appointments API - Register Patient Details Request Date time ::: "+addedDate);
			System.out.println(" .............................................................................. ");
			
			responseTxt = RegisterPatient(actionKey);
			str = responseTxt.split("#");
			
			System.out.println(" .............................................................................. ");
		} catch (Exception e) {
			e.printStackTrace();
			responseTxt = "E#Exception Occured";
		}
		return Response.status(responseCode(str[0])).entity(str[1]).build();	
	}
	
		
	// Method Added for Patient Visit Registration
	// Added for KDAH-CRF-0579 by Apoorva on 06/08/2021
	@POST
	@Path("/visitregistration")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response patientVisitRegistration(String actionKey) {
		String responseTxt = "";
		String[] str = null;
		
		String addedDate = new java.text.SimpleDateFormat( "yyyy-MM-dd HH:mm:ss" ).format( new java.util.Date() ) ;
		
		try {
			
			l_debug_YN = XHUtil.getDebugYN();
			
			System.out.println(" ::: Appointments API - Visit Registration Request Date time ::: "+addedDate);
			System.out.println(" ...........................................action key............................... ");
			
			System.out.println(actionKey);
			
			responseTxt = visitRegisterPatient(actionKey);
			str = responseTxt.split("#");
			
			
			System.out.println(" .............................................................................. ");
		} catch (Exception e) {
			e.printStackTrace();
			responseTxt = "E#Exception Occured";
		}
		
		return Response.status(responseCode(str[0])).entity(str[1]).build();
	}
		
		
	//Added for KDAH-CRF-0579 by Apoorva on 06/08/2021
	private String visitRegisterPatient(String paramString) throws Exception {
		String responseTxt = "";

		try {
			
				System.out.println(l_debug_YN);
			
				l_app_msg = " ::: Inside Visit Registration ::: ";
				if (l_debug_YN.equals("Y"))	
					System.out.println(l_app_msg);
				
				l_app_msg = " ::: Inside Visit Registration paramString ::: "+paramString;
				if (l_debug_YN.equals("Y"))	
					System.out.println(l_app_msg);
				
				
				PractoInboundTransaction QHISTrans = new PractoInboundTransaction();
				
				responseTxt = QHISTrans.processVisitRequest(paramString);
				
				l_app_msg = " ::: Inside Visit Registration responseTxt ::: "+responseTxt;
				if (l_debug_YN.equals("Y"))	
					System.out.println(l_app_msg);


		} catch (Exception exp) {
			exp.printStackTrace(System.err);
		}
		return responseTxt;
	}	
	
	//Added for KDAH-CRF-0523 by Kapil on 26/03/2019
	private String RegisterPatient(String paramString) throws Exception {
		String responseTxt = "";

		try {
			
				l_app_msg = " ::: Inside PatientDetailsTransactions ::: ";
				if (l_debug_YN.equals("Y"))	
					System.out.println(l_app_msg);
				
				l_app_msg = " ::: Inside PatientDetailsTransactions paramString ::: "+paramString;
				if (l_debug_YN.equals("Y"))	
					System.out.println(l_app_msg);

				PractoRegisterPatient QueryPatientDtls = new PractoRegisterPatient();

				responseTxt = QueryPatientDtls.processRequest(paramString);
				
				l_app_msg = " ::: Inside PatientDetailsTransactions responseTxt ::: "+responseTxt;
				if (l_debug_YN.equals("Y"))	
					System.out.println(l_app_msg);


		} catch (Exception exp) {
			exp.printStackTrace(System.err);
		}
		return responseTxt;
	}
	
	//Added for KDAH-CRF-0523 by Kapil on 19/03/2019
	private String PatientDetailsTransactions(String paramString) throws Exception {
		String responseTxt = "";

		try {
			
				l_app_msg = " ::: Inside PatientDetailsTransactions ::: ";
				if (l_debug_YN.equals("Y"))	
					System.out.println(l_app_msg);
				
				l_app_msg = " ::: Inside PatientDetailsTransactions paramString ::: "+paramString;
				if (l_debug_YN.equals("Y"))	
					System.out.println(l_app_msg);

				PractoQueryPatientDetailsTransaction QueryPatientDtls = new PractoQueryPatientDetailsTransaction();

				responseTxt = QueryPatientDtls.processRequest(paramString);
				
				l_app_msg = " ::: Inside PatientDetailsTransactions responseTxt ::: "+responseTxt;
				if (l_debug_YN.equals("Y"))	
					System.out.println(l_app_msg);


		} catch (Exception exp) {
			exp.printStackTrace(System.err);
		}
		return responseTxt;
	}
	
	//Added for KDAH-CRF-0523 by Kapil on 22/03/2019
	private String QueryVisitTypeTransaction(String paramString) throws Exception {
		String responseTxt = "";

		try {
			
				l_app_msg = " ::: Inside PatientDetailsTransactions ::: ";
				if (l_debug_YN.equals("Y"))	
					System.out.println(l_app_msg);
				
				l_app_msg = " ::: Inside PatientDetailsTransactions paramString ::: "+paramString;
				if (l_debug_YN.equals("Y"))	
					System.out.println(l_app_msg);

				PractoQueryVisitTypeTransaction QueryVisitType = new PractoQueryVisitTypeTransaction();

				responseTxt = QueryVisitType.processRequest(paramString);
				
				l_app_msg = " ::: Inside PatientDetailsTransactions responseTxt ::: "+responseTxt;
				if (l_debug_YN.equals("Y"))	
					System.out.println(l_app_msg);


		} catch (Exception exp) {
			exp.printStackTrace(System.err);
		}
		return responseTxt;
	}

	//Added for KDAH-CRF-0456 by Kapil on 25/07/2018
	private String PractoInboundTransactions(String paramString, String requestType, String key){
		String responseTxt = "";		
		
		try {
			
				l_app_msg = " ::: Inside PractoInboundTransactions ::: ";
				if (l_debug_YN.equals("Y"))	
					System.out.println(l_app_msg);
				
				l_app_msg = " ::: Inside PractoInboundTransactions paramString ::: "+paramString;
				if (l_debug_YN.equals("Y"))	
					System.out.println(l_app_msg);

				PractoInboundTransaction QHISTrans = new PractoInboundTransaction();
	
				responseTxt = QHISTrans.processRequest(paramString, requestType, key);
				
				l_app_msg = " ::: Inside PractoInboundTransactions responseTxt ::: "+responseTxt;
				if (l_debug_YN.equals("Y"))	
					System.out.println(l_app_msg);
	
				if (responseTxt.indexOf("Error") == 0) {
					return responseTxt;
				}

		} catch (Exception exp) {
			System.out.println("(ProctoInboundTransactions) Exception occurred : "+exp.getMessage());
			exp.printStackTrace(System.err);
		}
		
		return responseTxt;
	}
	//Added for KDAH-CRF-0456 by Krupa on 25/07/2018
	private String PractoOutboundTransactions(String paramString) throws Exception {
		String responseTxt = "";

		try {
			
				l_app_msg = " ::: Inside PractoOutboundTransactions ::: ";
				if (l_debug_YN.equals("Y"))	
					System.out.println(l_app_msg);
				
				l_app_msg = " ::: Inside PractoOutboundTransactions paramString ::: "+paramString;
				if (l_debug_YN.equals("Y"))	
					System.out.println(l_app_msg);

				PractoOutboundTransactions QHISTrans = new PractoOutboundTransactions();

				responseTxt = QHISTrans.processRequest(paramString);
				
				l_app_msg = " ::: Inside PractoOutboundTransactions responseTxt ::: "+responseTxt;
				if (l_debug_YN.equals("Y"))	
					System.out.println(l_app_msg);


		} catch (Exception exp) {
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
	
	// Added for KDAH-CRF-0513
	private String PractoPaymentTransactions(String paramString, String requestType, boolean auditFlag){
		String responseTxt = "";		
		
		try {
			
				l_app_msg = "::: Inside PractoInboundTransactions ::: ";
				if (l_debug_YN.equals("Y"))	
					System.out.println(l_app_msg);
				
				l_app_msg = "::: Inside PractoInboundTransactions paramString ::: "+paramString;
				if (l_debug_YN.equals("Y"))
					System.out.println(l_app_msg);

				PractoPaymentTransaction QHISTrans = new PractoPaymentTransaction();
	
				responseTxt = QHISTrans.processRequest(paramString, requestType, auditFlag);
				
				l_app_msg = "::: Inside PractoInboundTransactions responseTxt ::: "+responseTxt;
				if (l_debug_YN.equals("Y"))
					System.out.println(l_app_msg);
	
				if (responseTxt.indexOf("Error") == 0) {
					return responseTxt;
				}

		} catch (Exception exp) {
			System.out.println("(ProctoInboundTransactions) Exception occurred : "+exp.getMessage());
			exp.printStackTrace(System.err);
		}
		
		return responseTxt;
	}

	//Method For Query Visit Consultation transactions
	//Added for KDAH-CRF-0573 by Sethu on 10/10/2020
	@POST
	@Path("/QueryRescheduleAppt")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response QueryRescheduleAppt(String actionKey) {
		String responseTxt = "";
		String[] str = null;
		
		String addedDate = new java.text.SimpleDateFormat( "yyyy-MM-dd HH:mm:ss" ).format( new java.util.Date() ) ;
		
		try {
			
			l_debug_YN = XHUtil.getDebugYN();
			
			System.out.println(" ::: Appointments API - Reschedule Appointment Query API Request Date time ::: "+addedDate);
			System.out.println(" .............................................................................. ");
			
			l_app_msg = " ::: Inside Query Visit Type  ::: ";
			if (l_debug_YN.equals("Y"))	
				System.out.println(l_app_msg);
			
			responseTxt = QueryRescheduleAPITransaction(actionKey);
			str = responseTxt.split("#");
			
			if (str.length > 1)
			{
				//str[1] = str[1].replaceAll("null", "\"\"");
				str[1] = str[1].replaceAll("\\$\\$", "#");				
			}
			
			System.out.println(" .............................................................................. ");
			
		} catch (Exception e) {
			e.printStackTrace();
			responseTxt = "E#Exception Occured";
		}
		return Response.status(responseCode(str[0])).entity(str[1]).build();
	}
	
	//Added for KDAH-CRF-0573 by Sethu on 10/10/2020
	private String QueryRescheduleAPITransaction(String paramString) throws Exception {
		String responseTxt = "";

		try {
			
				l_app_msg = " ::: Inside PatientDetailsTransactions ::: ";
				if (l_debug_YN.equals("Y"))	
					System.out.println(l_app_msg);
				
				l_app_msg = " ::: Inside PatientDetailsTransactions paramString ::: "+paramString;
				if (l_debug_YN.equals("Y"))	
					System.out.println(l_app_msg);

				PractoQueryVisitTypeTransaction QueryVisitType = new PractoQueryVisitTypeTransaction();

				responseTxt = QueryVisitType.queryScheduleAPI(paramString);
				
				l_app_msg = " ::: Inside QueryRescheduleAPITransaction responseTxt ::: "+responseTxt;
				if (l_debug_YN.equals("Y"))	
					System.out.println(l_app_msg);


		} catch (Exception exp) {
			exp.printStackTrace(System.err);
		}
		return responseTxt;
	}
	
	//Method For Query Slots Availability
	//Added for KDAH-CRF-0581 by Sethu on 19/01/2021
	@POST
	@Path("/QuerySlotsAvailability")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response QuerySlotsAvailability(String actionKey) {
		String responseTxt = "";
		String[] str = null;
		
		String addedDate = new java.text.SimpleDateFormat( "yyyy-MM-dd HH:mm:ss" ).format( new java.util.Date() ) ;
		
		try {
			
			l_debug_YN = XHUtil.getDebugYN();
			
			System.out.println(" ::: Appointments API - Query Slots Availability API Request Date time ::: "+addedDate);
			System.out.println(" .............................................................................. ");
			
			l_app_msg = " ::: Inside Query Visit Type  ::: ";
			if (l_debug_YN.equals("Y"))	
				System.out.println(l_app_msg);
			
			responseTxt = QuerySlotsAvailabilityTransaction(actionKey);
			str = responseTxt.split("#");
			
			if (str.length > 1)
			{
				//str[1] = str[1].replaceAll("null", "\"\"");
				str[1] = str[1].replaceAll("\\$\\$", "#");				
			}
			
			System.out.println(" .............................................................................. ");
			
		} catch (Exception e) {
			e.printStackTrace();
			responseTxt = "E#Exception Occured";
		}
		return Response.status(responseCode(str[0])).entity(str[1]).build();
	}	
	
	//Added for KDAH-CRF-0581 by Sethu on 19/01/2021
	private String QuerySlotsAvailabilityTransaction(String paramString) throws Exception {
		String responseTxt = "";

		try {
			
				l_app_msg = " ::: Inside PatientDetailsTransactions ::: ";
				if (l_debug_YN.equals("Y"))	
					System.out.println(l_app_msg);
				
				l_app_msg = " ::: Inside PatientDetailsTransactions paramString ::: "+paramString;
				if (l_debug_YN.equals("Y"))	
					System.out.println(l_app_msg);

				PractoQueryVisitTypeTransaction QueryVisitType = new PractoQueryVisitTypeTransaction();

				responseTxt = QueryVisitType.querySlotsAvailability(paramString);
				
				l_app_msg = " ::: Inside QuerySlotsAvailabilityTransaction responseTxt ::: "+responseTxt;
				if (l_debug_YN.equals("Y"))	
					System.out.println(l_app_msg);


		} catch (Exception exp) {
			exp.printStackTrace(System.err);
		}
		return responseTxt;
	}
}
