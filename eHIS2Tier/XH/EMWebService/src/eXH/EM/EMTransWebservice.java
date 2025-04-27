package eXH.EM;

import java.io.UnsupportedEncodingException;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.*;

import eXH.util.*;

@Path("/t1")

public class EMTransWebservice {
	
	public static String l_debug_YN = "N";
	public static String l_app_msg = "";
	public static String l_event_type = "";
	
	@POST
	@Path("/registerpatient")
	@Consumes(MediaType.TEXT_PLAIN)
	@Produces(MediaType.TEXT_PLAIN)
	public Response PostRegisterPatient(@Context UriInfo info,@Context HttpHeaders headers) throws UnsupportedEncodingException {
		
		String actionKey = info.getRequestUri().getQuery();    
		MultivaluedMap<String,String> params = info.getQueryParameters();
		
	    String responseTxt = "";
		String[] str = null;
		
		String addedDate = new java.text.SimpleDateFormat( "yyyy-MM-dd HH:mm:ss" ).format( new java.util.Date() ) ;
		
		try {
			if (l_debug_YN.equals("Y"))	
				System.out.println(l_app_msg);
			System.out.println(" ::: Register Patient Post request date and time ::: "+addedDate);
			System.out.println(" .............................................................................. ");			
			
			l_debug_YN = XHUtil.getDebugYN();
			
			if (l_debug_YN.equals("Y"))	
				System.out.println("Action Key : "+actionKey);
			
			l_app_msg = " ::: Query Parameters  : " + params;
			if (l_debug_YN.equals("Y"))
				System.out.println(l_app_msg);
			
			String key = headers.getRequestHeader("key").get(0);
			
			responseTxt = RegisterPatient(actionKey,key, "P");
			str = responseTxt.split("#");
			
			l_app_msg = " ::: Response  : " + str;
			if (l_debug_YN.equals("Y"))
				System.out.println(l_app_msg);
			
			if (str.length > 1)
			{
				str[1] = str[1].replaceAll("\\$\\$", "#");				
			}
			
			l_app_msg = " ::: Response  STR[1]: " + str[1];
			if (l_debug_YN.equals("Y"))
				System.out.println(l_app_msg);
			
			System.out.println(" .............................................................................. ");
			
		} catch (Exception e) {
			e.printStackTrace();
			responseTxt = "E$!^Exception Occured";
		}
		return Response.status(responseCode(str[0])).entity(str[1]).build();
	}
	
	private String RegisterPatient(String paramString, String key, String method) throws Exception {
		String responseTxt = "";
		
		try {
			
				l_app_msg = " ::: Inside Register Patient Transactions ::: ";
				if (l_debug_YN.equals("Y"))	
					System.out.println(l_app_msg);
				/*
				l_app_msg = " ::: Inside Register Patient paramString ::: "+paramString;
				if (l_debug_YN.equals("Y"))	
					System.out.println(l_app_msg);
				*/
				
				l_event_type = "OA30";

				QueryOutboundTransaction QueryPatientDtls = new QueryOutboundTransaction();

				responseTxt = QueryPatientDtls.processOutboundRequest(paramString, key, l_event_type, method);
				
				l_app_msg = " ::: Inside Register Patient Response ::: "+responseTxt;
				if (l_debug_YN.equals("Y"))	
					System.out.println(l_app_msg);
				
				responseTxt =  "200#" + responseTxt + "#";


		} catch (Exception exp) {
			exp.printStackTrace(System.err);
		}
		return responseTxt;
	}
	
	@POST
	@Path("/scheduleappt")
	@Consumes(MediaType.TEXT_PLAIN)
	@Produces(MediaType.TEXT_PLAIN)
	public Response PostScheduleAppt(@Context UriInfo info,@Context HttpHeaders headers) {
		
		String actionKey = info.getRequestUri().getQuery();
	    String responseTxt = "";
		String[] str = null;
		
		String addedDate = new java.text.SimpleDateFormat( "yyyy-MM-dd HH:mm:ss" ).format( new java.util.Date() ) ;
		
		try {
			
			System.out.println(" ::: Register Appt Post request date and time ::: "+addedDate);
			System.out.println(" .............................................................................. ");
			
			l_debug_YN = XHUtil.getDebugYN();
			
			String key = headers.getRequestHeader("key").get(0);
			
			responseTxt = ScheduleApptTrans(actionKey,key, "P");
			str = responseTxt.split("#");
			
			if (str.length > 1)
			{
				str[1] = str[1].replaceAll("\\$\\$", "#");				
			}
			
			System.out.println(" .............................................................................. ");
			
		} catch (Exception e) {
			e.printStackTrace();
			responseTxt = "E$!^Exception Occured";
		}
		return Response.status(responseCode(str[0])).entity(str[1]).build();
	}
	
	
	private String ScheduleApptTrans(String paramString, String key, String method) throws Exception {
		String responseTxt = "";
		
		try {
			
				l_app_msg = " ::: Inside Register Appt Transactions ::: ";
				if (l_debug_YN.equals("Y"))	
					System.out.println(l_app_msg);
				
				l_app_msg = " ::: Inside Register Appointment paramString ::: "+paramString;
				if (l_debug_YN.equals("Y"))	
					System.out.println(l_app_msg);
				
				l_event_type = "OA21";

				QueryOutboundTransaction QuerySchApptDtls = new QueryOutboundTransaction();

				responseTxt = QuerySchApptDtls.processOutboundRequest(paramString, key, l_event_type, method);
				
				l_app_msg = " ::: Inside Schedule Appointments responseTxt ::: "+responseTxt;
				if (l_debug_YN.equals("Y"))	
					System.out.println(l_app_msg);
				
				responseTxt =  "200#" + responseTxt + "#";


		} catch (Exception exp) {
			exp.printStackTrace(System.err);
		}
		return responseTxt;
	}
	
	@POST
	@Path("/rescheduleappt")
	@Consumes(MediaType.TEXT_PLAIN)
	@Produces(MediaType.TEXT_PLAIN)
	public Response PostRescheduleAppt(@Context UriInfo info,@Context HttpHeaders headers) {
		
		String actionKey = info.getRequestUri().getQuery();
		
	    String responseTxt = "";
		String[] str = null;
		
		String addedDate = new java.text.SimpleDateFormat( "yyyy-MM-dd HH:mm:ss" ).format( new java.util.Date() ) ;
		
		try {
			
			System.out.println(" ::: Reschedule Appointment Post request date and time ::: "+addedDate);
			System.out.println(" .............................................................................. ");
			
			l_debug_YN = XHUtil.getDebugYN();
			
			String key = headers.getRequestHeader("key").get(0);
			
			responseTxt = RescheduleApptTrans(actionKey, key, "P");
			str = responseTxt.split("#");
			
			if (str.length > 1)
			{
				str[1] = str[1].replaceAll("\\$\\$", "#");				
			}
			
			System.out.println(" .............................................................................. ");
			
		} catch (Exception e) {
			e.printStackTrace();
			responseTxt = "E$!^Exception Occured";
		}
		return Response.status(responseCode(str[0])).entity(str[1]).build();
	}	

	private String RescheduleApptTrans(String paramString, String key, String method) throws Exception {
		String responseTxt = "";
		
		try {
			
				l_app_msg = " ::: Inside Reschedule Appointments ::: ";
				if (l_debug_YN.equals("Y"))	
					System.out.println(l_app_msg);
				
				l_app_msg = " ::: Inside Reschedule Appointments paramString ::: "+paramString;
				if (l_debug_YN.equals("Y"))	
					System.out.println(l_app_msg);
				
				l_event_type = "OA23";

				QueryOutboundTransaction QueryRescheduleAppt = new QueryOutboundTransaction();

				responseTxt = QueryRescheduleAppt.processOutboundRequest(paramString, key, l_event_type, method);
				
				l_app_msg = " ::: Inside Reschedule Appointments responseTxt ::: "+responseTxt;
				if (l_debug_YN.equals("Y"))	
					System.out.println(l_app_msg);
				
				responseTxt =  "200#" + responseTxt + "#";


		} catch (Exception exp) {
			exp.printStackTrace(System.err);
		}
		return responseTxt;
	}
	
	@POST
	@Path("/cancelappt")
	@Consumes(MediaType.TEXT_PLAIN)
	@Produces(MediaType.TEXT_PLAIN)
	public Response PostCancellAppt(@Context UriInfo info,@Context HttpHeaders headers) {
		
		String actionKey = info.getRequestUri().getQuery();
		
	    String responseTxt = "";
		String[] str = null;
		
		String addedDate = new java.text.SimpleDateFormat( "yyyy-MM-dd HH:mm:ss" ).format( new java.util.Date() ) ;
		
		try {
			
			System.out.println(" ::: Cancel Appointments Post request date and time ::: "+addedDate);
			System.out.println(" .............................................................................. ");
			
			l_debug_YN = XHUtil.getDebugYN();
			
			String key = headers.getRequestHeader("key").get(0);
			
			responseTxt = CancelledApptTrans(actionKey,key,"P");
			str = responseTxt.split("#");
			
			if (str.length > 1)
			{
				str[1] = str[1].replaceAll("\\$\\$", "#");				
			}
			
			System.out.println(" .............................................................................. ");
			
		} catch (Exception e) {
			e.printStackTrace();
			responseTxt = "E$!^Exception Occured";
		}
		return Response.status(responseCode(str[0])).entity(str[1]).build();
	}
	
	private String CancelledApptTrans(String paramString, String key, String method) throws Exception {
		String responseTxt = "";
		
		try {
			
				l_app_msg = " ::: Inside Cancelled Appointment ::: ";
				if (l_debug_YN.equals("Y"))	
					System.out.println(l_app_msg);
				
				l_app_msg = " ::: Inside Cancelled Appointments paramString ::: "+paramString;
				if (l_debug_YN.equals("Y"))	
					System.out.println(l_app_msg);
				
				l_event_type = "OA22";

				QueryOutboundTransaction QueryCanApptDtls = new QueryOutboundTransaction();

				responseTxt = QueryCanApptDtls.processOutboundRequest(paramString, key, l_event_type, method);
				
				l_app_msg = " ::: Inside Cancelled Schedule responseTxt ::: "+responseTxt;
				if (l_debug_YN.equals("Y"))	
					System.out.println(l_app_msg);
				
				responseTxt =  "200#" + responseTxt + "#";


		} catch (Exception exp) {
			exp.printStackTrace(System.err);
		}
		return responseTxt;
	}
	
	@POST
	@Path("/mergepat")
	@Consumes(MediaType.TEXT_PLAIN)
	@Produces(MediaType.TEXT_PLAIN)
	public Response PostPatMergeDetails(@Context UriInfo info,@Context HttpHeaders headers) {
		
		String actionKey = info.getRequestUri().getQuery();
		
	    String responseTxt = "";
		String[] str = null;
		
		String addedDate = new java.text.SimpleDateFormat( "yyyy-MM-dd HH:mm:ss" ).format( new java.util.Date() ) ;
		
		try {
			
			System.out.println(" ::: Merge Patient Post request date and time ::: "+addedDate);
			System.out.println(" .............................................................................. ");
			
			l_debug_YN = XHUtil.getDebugYN();
			
			String key = headers.getRequestHeader("key").get(0);
			
			responseTxt = MergePatientTrans(actionKey,key,"P");
			str = responseTxt.split("#");
			
			if (str.length > 1)
			{
				str[1] = str[1].replaceAll("\\$\\$", "#");				
			}
			
			System.out.println(" .............................................................................. ");
			
		} catch (Exception e) {
			e.printStackTrace();
			responseTxt = "E$!^Exception Occured";
		}
		return Response.status(responseCode(str[0])).entity(str[1]).build();
	}
	
	private String MergePatientTrans(String paramString, String key, String method) throws Exception {
		String responseTxt = "";
		
		try {
			
				l_app_msg = " ::: Inside Merge Patient ::: ";
				if (l_debug_YN.equals("Y"))	
					System.out.println(l_app_msg);
				
				l_app_msg = " ::: Inside Merge Patient paramString ::: "+paramString;
				if (l_debug_YN.equals("Y"))	
					System.out.println(l_app_msg);
				
				l_event_type = "OA38";

				QueryOutboundTransaction QueryMrgPatientDtls = new QueryOutboundTransaction();

				responseTxt = QueryMrgPatientDtls.processOutboundRequest(paramString, key, l_event_type, method);
				
				l_app_msg = " ::: Inside Cancelled Schedule responseTxt ::: "+responseTxt;
				if (l_debug_YN.equals("Y"))	
					System.out.println(l_app_msg);
				
				responseTxt =  "200#" + responseTxt + "#";


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
	
	
	@POST
	@Path("/emregisterpatient")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response EmRegisterPatient(String actionKey,@Context HttpHeaders headers) throws UnsupportedEncodingException {
		
	    String responseTxt = "";
		String[] str = null;
		
		String addedDate = new java.text.SimpleDateFormat( "yyyy-MM-dd HH:mm:ss" ).format( new java.util.Date() ) ;
		
		try {
			if (l_debug_YN.equals("Y"))	
				System.out.println(l_app_msg);
			System.out.println(" ::: Register Patient request date and time ::: "+addedDate);
			System.out.println(" .............................................................................. ");			
			
			l_debug_YN = XHUtil.getDebugYN();
			
			if (l_debug_YN.equals("Y"))	
				System.out.println("Action Key : "+actionKey);			
			
			String key = headers.getRequestHeader("key").get(0);
			
			responseTxt = EmRegisterPatient(actionKey,key,"R");
			str = responseTxt.split("#");
			
			if (str.length > 1)
			{
				str[1] = str[1].replaceAll("\\$\\$", "#");				
			}
			
			System.out.println(" .............................................................................. ");
			
		} catch (Exception e) {
			e.printStackTrace();
			responseTxt = "E$!^Exception Occured";
		}
		return Response.status(responseCode(str[0])).entity(str[1]).build();
	}
	
	@PUT
	@Path("/emregisterpatient")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response EmPutRegisterPatient(String actionKey,@Context HttpHeaders headers) throws UnsupportedEncodingException {
		
	    String responseTxt = "";
		String[] str = null;
		
		String addedDate = new java.text.SimpleDateFormat( "yyyy-MM-dd HH:mm:ss" ).format( new java.util.Date() ) ;
		
		try {
			if (l_debug_YN.equals("Y"))	
				System.out.println(l_app_msg);
			System.out.println(" ::: Register Patient request date and time ::: "+addedDate);
			System.out.println(" .............................................................................. ");			
			
			l_debug_YN = XHUtil.getDebugYN();
			
			if (l_debug_YN.equals("Y"))	
				System.out.println("Action Key : "+actionKey);			
			
			String key = headers.getRequestHeader("key").get(0);
			
			responseTxt = EmRegisterPatient(actionKey,key,"P");
			str = responseTxt.split("#");
			
			if (str.length > 1)
			{
				str[1] = str[1].replaceAll("\\$\\$", "#");				
			}
			
			System.out.println(" .............................................................................. ");
			
		} catch (Exception e) {
			e.printStackTrace();
			responseTxt = "E$!^Exception Occured";
		}
		return Response.status(responseCode(str[0])).entity(str[1]).build();
	}
	
	private String EmRegisterPatient(String paramString, String key, String method) throws Exception {
		String responseTxt = "";
		
		try {
			
				l_app_msg = " ::: Inside Register Patient Transactions ::: ";
				if (l_debug_YN.equals("Y"))	
					System.out.println(l_app_msg);
				
				/*
				l_app_msg = " ::: Inside Register Patient paramString ::: "+paramString;
				if (l_debug_YN.equals("Y"))	
					System.out.println(l_app_msg);
				*/
				
				l_event_type = "OA30";

				EMInboundPatientRegistration QueryPatientDtls = new EMInboundPatientRegistration();

				responseTxt = QueryPatientDtls.processInPatRegRequest(paramString, key, l_event_type, method);
				
				l_app_msg = " ::: Inside Register Patient Response ::: "+responseTxt;
				if (l_debug_YN.equals("Y"))	
					System.out.println(l_app_msg);
				

		} catch (Exception exp) {
			exp.printStackTrace(System.err);
		}
		return responseTxt;
	}
	
	@POST
	@Path("/emscheduleappt")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response EmScheduleAppt(String actionKey,@Context HttpHeaders headers) {
		
	    String responseTxt = "", responseTxtPayment="";
		String[] str = null;
		
		String addedDate = new java.text.SimpleDateFormat( "yyyy-MM-dd HH:mm:ss" ).format( new java.util.Date() ) ;
		
		try {
			
			System.out.println(" ::: Schedule Appt Post request date and time ::: "+addedDate);
			System.out.println(" .............................................................................. ");
			
			l_debug_YN = XHUtil.getDebugYN();
			
			String key = headers.getRequestHeader("key").get(0);
			
			responseTxt = EmScheduleApptTrans(actionKey,key);
			
			if ((actionKey.contains("bank_ref_no") || actionKey.contains("net_amount_debit")) && 
					(!(responseTxt.contains("Error") || responseTxt.contains("\"status\":0"))))
			{
				System.out.println("::: Book Appointment with payment Details :::");
				responseTxtPayment=EMPaymentTransaction(actionKey,"OA25",key);
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
	}
	
	
	private String EmScheduleApptTrans(String paramString, String key) throws Exception {
		String responseTxt = "";
		
		try {
			
				l_app_msg = " ::: Inside Schedule Appt Transactions ::: ";
				if (l_debug_YN.equals("Y"))	
					System.out.println(l_app_msg);
				
				l_app_msg = " ::: Inside Schedule Appointment paramString ::: "+paramString;
				if (l_debug_YN.equals("Y"))	
					System.out.println(l_app_msg);
				
				l_event_type = "OA21";

				InboundTransaction QuerySchApptDtls = new InboundTransaction();

				responseTxt = QuerySchApptDtls.processInboundRequest(paramString, l_event_type, key);
				
				l_app_msg = " ::: Inside EmScheduleApptTrans responseTxt ::: "+responseTxt;
				if (l_debug_YN.equals("Y"))	
					System.out.println(l_app_msg);


		} catch (Exception exp) {
			exp.printStackTrace(System.err);
		}
		return responseTxt;
	}
	
	@POST
	@Path("/emrescheduleappt")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response EmRescheduleAppt(String actionKey,@Context HttpHeaders headers) {
		
		
	    String responseTxt = "";
		String[] str = null;
		
		String addedDate = new java.text.SimpleDateFormat( "yyyy-MM-dd HH:mm:ss" ).format( new java.util.Date() ) ;
		
		try {
			
			System.out.println(" ::: Reschedule Appointment request date and time ::: "+addedDate);
			System.out.println(" .............................................................................. ");
			
			l_debug_YN = XHUtil.getDebugYN();
			
			String key = headers.getRequestHeader("key").get(0);
			
			responseTxt = EmRescheduleApptTrans(actionKey, key);
			str = responseTxt.split("#");
			
			if (str.length > 1)
			{
				str[1] = str[1].replaceAll("\\$\\$", "#");				
			}
			
			System.out.println(" .............................................................................. ");
			
		} catch (Exception e) {
			e.printStackTrace();
			responseTxt = "E$!^Exception Occured";
		}
		return Response.status(responseCode(str[0])).entity(str[1]).build();
	}	

	private String EmRescheduleApptTrans(String paramString, String key) throws Exception {
		String responseTxt = "";
		
		try {
			
				l_app_msg = " ::: Inside Reschedule Appointments ::: ";
				if (l_debug_YN.equals("Y"))	
					System.out.println(l_app_msg);
				
				l_app_msg = " ::: Inside Reschedule Appointments paramString ::: "+paramString;
				if (l_debug_YN.equals("Y"))	
					System.out.println(l_app_msg);
				
				l_event_type = "OA23";

				InboundTransaction QueryRescheduleAppt = new InboundTransaction();

				responseTxt = QueryRescheduleAppt.processInboundRequest(paramString, l_event_type, key);
				
				l_app_msg = " ::: Inside Reschedule Appointments responseTxt ::: "+responseTxt;
				if (l_debug_YN.equals("Y"))	
					System.out.println(l_app_msg);


		} catch (Exception exp) {
			exp.printStackTrace(System.err);
		}
		return responseTxt;
	}
	
	@POST
	@Path("/emcancelappt")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response EmCancelAppt(String actionKey,@Context HttpHeaders headers) {
		
	    String responseTxt = "";
		String[] str = null;
		
		String addedDate = new java.text.SimpleDateFormat( "yyyy-MM-dd HH:mm:ss" ).format( new java.util.Date() ) ;
		
		try {
			
			System.out.println(" ::: Cancel Appointments Post request date and time ::: "+addedDate);
			System.out.println(" .............................................................................. ");
			
			l_debug_YN = XHUtil.getDebugYN();
			
			String key = headers.getRequestHeader("key").get(0);
			
			responseTxt = EmCancelledApptTrans(actionKey,key);
			str = responseTxt.split("#");
			
			if (str.length > 1)
			{
				str[1] = str[1].replaceAll("\\$\\$", "#");				
			}
			
			System.out.println(" .............................................................................. ");
			
		} catch (Exception e) {
			e.printStackTrace();
			responseTxt = "E$!^Exception Occured";
		}
		return Response.status(responseCode(str[0])).entity(str[1]).build();
	}
	
	private String EmCancelledApptTrans(String paramString, String key) throws Exception {
		String responseTxt = "";
		
		try {
			
				l_app_msg = " ::: Inside CancelledApptTrans ::: ";
				if (l_debug_YN.equals("Y"))	
					System.out.println(l_app_msg);
				
				l_app_msg = " ::: Inside CancelledApptTrans paramString ::: "+paramString;
				if (l_debug_YN.equals("Y"))	
					System.out.println(l_app_msg);
				
				l_event_type = "OA22";

				InboundTransaction QueryCancelDtls = new InboundTransaction();

				responseTxt = QueryCancelDtls.processInboundRequest(paramString, l_event_type, key);
				
				l_app_msg = " ::: Inside CancelledApptTrans responseTxt ::: "+responseTxt;
				if (l_debug_YN.equals("Y"))	
					System.out.println(l_app_msg);


		} catch (Exception exp) {
			exp.printStackTrace(System.err);
		}
		return responseTxt;
	}
	
	private String EMPaymentTransaction(String paramString, String requestType,String key){
		String responseTxt = "";		
		
		try {
			
				l_app_msg = "::: Inside EMPaymentTransaction ::: ";
				if (l_debug_YN.equals("Y"))	
					System.out.println(l_app_msg);
				
				l_app_msg = "::: Inside EMPaymentTransaction paramString ::: "+paramString;
				if (l_debug_YN.equals("Y"))
					System.out.println(l_app_msg);

				EMPaymentTransaction QHISTrans = new EMPaymentTransaction();
	
				responseTxt = QHISTrans.processInboundPaymentRequest(paramString, requestType, key);
				
				l_app_msg = "::: Inside EMPaymentTransaction responseTxt ::: "+responseTxt;
				if (l_debug_YN.equals("Y"))
					System.out.println(l_app_msg);
	
				if (responseTxt.indexOf("Error") == 0) {
					return responseTxt;
				}

		} catch (Exception exp) {
			System.out.println("(EMPaymentTransaction) Exception occurred : "+exp.getMessage());
			exp.printStackTrace(System.err);
		}
		
		return responseTxt;
	}
	
	@POST
	@Path("/emreleaseslots")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response EMReleaseSlots(String actionKey,@Context HttpHeaders headers) {
		String responseTxt = "";
		String[] str = null;
		
		String addedDate = new java.text.SimpleDateFormat( "yyyy-MM-dd HH:mm:ss" ).format( new java.util.Date() ) ;
		
		try {
			
				l_debug_YN = XHUtil.getDebugYN();
				
				System.out.println(" ::: Appointments API - Release Slots Request Date time ::: "+addedDate);
				System.out.println(" .............................................................................. ");
			
				l_app_msg = " ::: Inside Block Appointment ::: ";
				if (l_debug_YN.equals("Y"))	
					System.out.println(l_app_msg);
				
				l_event_type = "OA34";
				
				String key = headers.getRequestHeader("key").get(0);
				responseTxt = EmReleaseSlots(actionKey, l_event_type, key);
				str = responseTxt.split("#");
				
				System.out.println(" .............................................................................. ");
			
		} catch (Exception e) {
			e.printStackTrace();
			responseTxt = "E#Exception Occured";
		}
		return Response.status(responseCode(str[0])).entity(str[1]).build();
		//return responseTxt;

	}
	
	private String EmReleaseSlots(String paramString, String eventType, String key) throws Exception {
		String responseTxt = "";
		
		try {
			
				l_app_msg = " ::: Inside CancelledApptTrans ::: ";
				if (l_debug_YN.equals("Y"))	
					System.out.println(l_app_msg);
				
				l_app_msg = " ::: Inside CancelledApptTrans paramString ::: "+paramString;
				if (l_debug_YN.equals("Y"))	
					System.out.println(l_app_msg);
				
				l_event_type = "OA34";

				InboundTransaction QueryReasonDtls = new InboundTransaction();

				responseTxt = QueryReasonDtls.processInboundRequest(paramString, l_event_type, key);
				
				l_app_msg = " ::: Inside CancelledApptTrans responseTxt ::: "+responseTxt;
				if (l_debug_YN.equals("Y"))	
					System.out.println(l_app_msg);


		} catch (Exception exp) {
			exp.printStackTrace(System.err);
		}
		return responseTxt;
	}
	

	@POST
	@Path("/emreserveslots")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response EmBlockAppointment(String actionKey,@Context HttpHeaders headers) {
		String responseTxt = "";
		String[] str = null;
		
		String addedDate = new java.text.SimpleDateFormat( "yyyy-MM-dd HH:mm:ss" ).format( new java.util.Date() ) ;
		
		try {
			
				l_debug_YN = XHUtil.getDebugYN();
				
				System.out.println(" ::: Appointments API - Reserve Appointment Slots Request Date time ::: "+addedDate);
				System.out.println(" .............................................................................. ");
			
				l_app_msg = " ::: Inside Reserve Appointment ::: ";
				if (l_debug_YN.equals("Y"))	
					System.out.println(l_app_msg);
				
				String key = headers.getRequestHeader("key").get(0);
				responseTxt = EmBlockAppointmentTransaction(actionKey,key);
				str = responseTxt.split("#");
				
				System.out.println(" .............................................................................. ");
			
		} catch (Exception e) {
			e.printStackTrace();
			responseTxt = "E#Exception Occured";
		}
		return Response.status(responseCode(str[0])).entity(str[1]).build();
		//return responseTxt;

	}

	private String EmBlockAppointmentTransaction(String paramString, String key) throws Exception {
		String responseTxt = "";
		
		try {
			
				l_app_msg = " ::: Inside Reserve Appt Slots Transactions ::: ";
				if (l_debug_YN.equals("Y"))	
					System.out.println(l_app_msg);
				
				l_app_msg = " ::: Inside Reserve Appt Slots paramString ::: "+paramString;
				if (l_debug_YN.equals("Y"))	
					System.out.println(l_app_msg);
				
				l_event_type = "OA24";

				InboundTransaction QuerySchApptDtls = new InboundTransaction();

				responseTxt = QuerySchApptDtls.processInboundRequest(paramString, l_event_type, key);
				
				l_app_msg = " ::: Inside EmScheduleApptTrans responseTxt ::: "+responseTxt;
				if (l_debug_YN.equals("Y"))	
					System.out.println(l_app_msg);


		} catch (Exception exp) {
			exp.printStackTrace(System.err);
		}
		return responseTxt;
	}
	
	
	// Method Added for Patient Visit Registration
		// Added for KDAH-CRF-0579 by Apoorva on 06/08/2021
		@POST
		@Path("/emvisitregistration")
		@Consumes(MediaType.APPLICATION_JSON)
		@Produces(MediaType.APPLICATION_JSON)
		public Response patientVisitRegistration(String actionKey, @Context HttpHeaders headers) {
			String responseTxt = "";
			String[] str = null;
			
			String addedDate = new java.text.SimpleDateFormat( "yyyy-MM-dd HH:mm:ss" ).format( new java.util.Date() ) ;
			
			try {
				
				l_debug_YN = XHUtil.getDebugYN();
				
				System.out.println(" ::: Appointments API - Visit Registration Request Date time ::: "+addedDate);
				System.out.println(" ...........................................action key............................... \n " +actionKey);
				
				String key = headers.getRequestHeader("key").get(0);
				responseTxt = visitRegisterPatient(actionKey, key);
				str = responseTxt.split("#");
				
				
				System.out.println(" .............................................................................. ");
			} catch (Exception e) {
				e.printStackTrace();
				responseTxt = "E#Exception Occured";
			}
			
			return Response.status(responseCode(str[0])).entity(str[1]).build();
		}
			
			
		//Added for KDAH-CRF-0579 by Apoorva on 06/08/2021
		private String visitRegisterPatient(String paramString, String key) throws Exception {
			String responseTxt = "";

			try {
				
					System.out.println(l_debug_YN);
				
					l_app_msg = " ::: Inside Visit Registration ::: ";
					if (l_debug_YN.equals("Y"))	
						System.out.println(l_app_msg);
					
					l_app_msg = " ::: Inside Visit Registration paramString ::: "+paramString;
					if (l_debug_YN.equals("Y"))	
						System.out.println(l_app_msg);
					
					l_event_type = "OA33";
					
					InboundTransaction visitReg = new InboundTransaction();

					responseTxt = visitReg.processVisitRequest(paramString, l_event_type, key);
					
					
					l_app_msg = " ::: Inside Visit Registration responseTxt ::: "+responseTxt;
					if (l_debug_YN.equals("Y"))	
						System.out.println(l_app_msg);


			} catch (Exception exp) {
				exp.printStackTrace(System.err);
			}
			return responseTxt;
		}	


		@POST
	    @Path("/visitregistration")
	    @Consumes(MediaType.TEXT_PLAIN)
	    @Produces(MediaType.TEXT_PLAIN)
	    public Response PostVisitRegistration(@Context final UriInfo info, @Context final HttpHeaders headers) {
	        final String actionKey = info.getRequestUri().getQuery();
	        String responseTxt = "";
	        String[] str = null;
	        String addedDate = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format( new java.util.Date());
	        try {
	            System.out.println(" ::: Visit Registration Post request date and time ::: " + addedDate);
	            System.out.println(" .............................................................................. ");
	            l_debug_YN = XHUtil.getDebugYN();
	            String key = headers.getRequestHeader("key").get(0);
	            responseTxt = this.VistRegTrans(actionKey, key, "P");
	            str = responseTxt.split("#");
	            if (str.length > 1) {
	                str[1] = str[1].replaceAll("\\$\\$", "#");
	            }
	            System.out.println(" .............................................................................. ");
	        }
	        catch (Exception e) {
	            e.printStackTrace();
	            responseTxt = "E$!^Exception Occured";
	        }
	        return Response.status(this.responseCode(str[0])).entity((Object)str[1]).build();
	    }
	    
	    private String VistRegTrans(final String paramString, final String key, final String method) throws Exception {
	        String responseTxt = "";
	        try {
	            l_app_msg = " ::: Inside Visit Registration ::: ";
	            if (l_debug_YN.equals("Y")) {
	                System.out.println(l_app_msg);
	            }
	            
	            /*
	            l_app_msg = " ::: Inside Visit Registration paramString ::: " + paramString;
	            if (l_debug_YN.equals("Y")) {
	                System.out.println(l_app_msg);
	            }
	            */
	            l_event_type = "OA33";
	            QueryOutboundTransaction QueryVisitDtls = new QueryOutboundTransaction();
	            responseTxt = QueryVisitDtls.processOutboundRequest(paramString, key, l_event_type, method);
	            l_app_msg = " ::: Inside Visit Registration responseTxt ::: " + responseTxt;
	            if (l_debug_YN.equals("Y")) {
	                System.out.println(l_app_msg);
	            }
	            responseTxt = "200#" + responseTxt + "#";
	        }
	        catch (Exception exp) {
	            exp.printStackTrace(System.err);
	        }
	        return responseTxt;
	    }
	    
	    
	    @POST
	    @Path("/generatetoken")
	    @Consumes(MediaType.APPLICATION_JSON)
	    @Produces(MediaType.APPLICATION_JSON)
	    public Response PostGenerateToken(String actionKey) {
	    	String responseTxt = "";
			String[] str = null;
			
			String addedDate = new java.text.SimpleDateFormat( "yyyy-MM-dd HH:mm:ss" ).format( new java.util.Date() ) ;
			
			
			try {
				
					l_debug_YN = XHUtil.getDebugYN();
					
					System.out.println(" ::: Generate Token Request::: "+addedDate);
					System.out.println(" .............................................................................. ");
				
					l_app_msg = " ::: Inside Generate Token ::: ";
					if (l_debug_YN.equals("Y"))	
						System.out.println(l_app_msg);
				
					responseTxt = GenerateToken(actionKey);
					str = responseTxt.split("#");
					
					System.out.println(" .............................................................................. ");
				
			} catch (Exception e) {
				e.printStackTrace();
				responseTxt = "E#Exception Occured";
			}
			
			return Response.status(responseCode(str[0])).entity(str[1]).build();

	    }
	    
	    private String GenerateToken(String paramString) throws Exception {
	        String responseTxt = "";
	        try {
	            l_app_msg = " ::: Inside Generate Token Transaction ::: ";
	            if (l_debug_YN.equals("Y")) {
	                System.out.println(l_app_msg);
	            }
	            l_app_msg = " ::: Inside Generate Token Transaction paramString ::: " + paramString;
	            if (l_debug_YN.equals("Y")) {
	                System.out.println(l_app_msg);
	            }
	            InboundTransaction GenerateToken = new InboundTransaction();
	            responseTxt = GenerateToken.processGenerateToken(paramString);
	            l_app_msg = " ::: Inside Generate Token ::: " + responseTxt;
	            if (l_debug_YN.equals("Y")) {
	                System.out.println(l_app_msg);
	            }
	        }
	        catch (Exception exp) {
	            exp.printStackTrace(System.err);
	        }
	        return responseTxt;
	    }

	    @GET
		@Path("/getauthvalidity")
		@Consumes(MediaType.TEXT_PLAIN)
		@Produces(MediaType.APPLICATION_JSON)
		public Response GetTokenValidInfo(@Context UriInfo info,@Context HttpHeaders headers) throws UnsupportedEncodingException {
			
			String actionKey = info.getRequestUri().getQuery();    
			MultivaluedMap<String,String> params = info.getQueryParameters();
			
		    String responseTxt = "";
			String[] str = null;
			
			String addedDate = new java.text.SimpleDateFormat( "yyyy-MM-dd HH:mm:ss" ).format( new java.util.Date() ) ;
			
			try {
				if (l_debug_YN.equals("Y"))	
					System.out.println(l_app_msg);
				System.out.println(" :::Token Validity details request date and time ::: "+addedDate);
				System.out.println(" .............................................................................. ");			
				
				l_debug_YN = XHUtil.getDebugYN();
				
				if (l_debug_YN.equals("Y"))	
					System.out.println("actionKey:::::::::::"+actionKey);
				
				l_app_msg = " ::: Query Parameters  : " + params;
				if (l_debug_YN.equals("Y"))
					System.out.println(l_app_msg);
				
				responseTxt = TokenValidityDetails(actionKey);
				str = responseTxt.split("#");
				
				if (str.length > 1)
				{
					str[1] = str[1].replaceAll("\\$\\$", "#");				
				}
				
				System.out.println(" .............................................................................. ");
				
			} catch (Exception e) {
				e.printStackTrace();
				responseTxt = "E$!^Exception Occured";
			}
			return Response.status(responseCode(str[0])).entity(str[1]).build();
		}
		
	    private String TokenValidityDetails(String paramString) throws Exception {
			String responseTxt = "";
			
			try {
				
					l_app_msg = " ::: Inside TokenValidityDetails ::: ";
					if (l_debug_YN.equals("Y"))	
						System.out.println(l_app_msg);
					
					l_app_msg = " ::: Inside TokenValidityDetails paramString ::: "+paramString;
					if (l_debug_YN.equals("Y"))	
						System.out.println(l_app_msg);
					
					InboundTransaction TokenValidity = new InboundTransaction();
		            responseTxt = TokenValidity.checkTokenValidity(paramString);
					
					l_app_msg = " ::: Inside TokenValidityDetails responseTxt ::: "+responseTxt;
					if (l_debug_YN.equals("Y"))	
						System.out.println(l_app_msg);
				

			} catch (Exception exp) {
				exp.printStackTrace(System.err);
			}
			return responseTxt;
		}


}
