package eXH.EM;

import java.io.UnsupportedEncodingException;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.*;

import eXH.util.*;

@Path("/m1")

public class EMasterWebservice {
	
	public static String l_debug_YN = "N";
	public static String l_app_msg = "";
	public static String l_event_type = "";
	
	@GET
	@Path("/opclinic")
	@Consumes(MediaType.TEXT_PLAIN)
	@Produces(MediaType.APPLICATION_JSON)
	public Response GetClinicDetails(@Context UriInfo info,@Context HttpHeaders headers) throws UnsupportedEncodingException {
		
		String actionKey = info.getRequestUri().getQuery();    
		MultivaluedMap<String,String> params = info.getQueryParameters();
		
	    String responseTxt = "";
		String[] str = null;
		
		String addedDate = new java.text.SimpleDateFormat( "yyyy-MM-dd HH:mm:ss" ).format( new java.util.Date() ) ;
		
		try {
			if (l_debug_YN.equals("Y"))	
				System.out.println(l_app_msg);
			System.out.println(" ::: Clinic details request date and time ::: "+addedDate);
			System.out.println(" .............................................................................. ");			
			
			l_debug_YN = XHUtil.getDebugYN();
			
			if (l_debug_YN.equals("Y"))	
				System.out.println("Action Key : "+actionKey);
			
			l_app_msg = " ::: Query Parameters  : " + params;
			if (l_debug_YN.equals("Y"))
				System.out.println(l_app_msg);
			
			String key = headers.getRequestHeader("key").get(0);
			
			responseTxt = ClinicDetailsTransactions(actionKey,key,"G");
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
	
	@POST
	@Path("/opclinic")
	@Consumes(MediaType.TEXT_PLAIN)
	@Produces(MediaType.TEXT_PLAIN)
	public Response PostClinicDetails(@Context UriInfo info, @Context HttpHeaders headers) throws UnsupportedEncodingException {

		String actionKey = info.getRequestUri().getQuery();
		MultivaluedMap<String, String> params = info.getQueryParameters();

		String responseTxt = "";
		String[] str = null;
		
		String addedDate = new java.text.SimpleDateFormat( "yyyy-MM-dd HH:mm:ss" ).format( new java.util.Date() ) ;
		
		try {
			if (l_debug_YN.equals("Y"))	
				System.out.println(l_app_msg);
			System.out.println(" ::: Clinic details request date and time ::: "+addedDate);
			System.out.println(" .............................................................................. ");			
			
			l_debug_YN = XHUtil.getDebugYN();
			
			if (l_debug_YN.equals("Y"))	
				System.out.println("Action Key : "+actionKey);
			
			l_app_msg = " ::: Query Parameters  : " + params;
			if (l_debug_YN.equals("Y"))
				System.out.println(l_app_msg);
			
			String key = headers.getRequestHeader("key").get(0);
			
			responseTxt = ClinicDetailsTransactions(actionKey,key, "P");
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
	
	private String ClinicDetailsTransactions(String paramString, String key, String method) throws Exception {
		String responseTxt = "";
		
		try {
			
			l_app_msg = " ::: Inside ClinicDetailsTransactions ::: ";
			if (l_debug_YN.equals("Y"))	
				System.out.println(l_app_msg);	
			
			l_event_type = "OM01";

			QueryMasterOutboundTransaction QueryClinicDtls = new QueryMasterOutboundTransaction();

			responseTxt = QueryClinicDtls.processOutboundRequest(paramString, key, l_event_type, method);
			
			l_app_msg = " ::: Inside ClinicDetailsTransactions responseTxt ::: "+responseTxt;
			if (l_debug_YN.equals("Y"))	
				System.out.println(l_app_msg);
		
			if (method.equals("P")) {
				l_app_msg = " ::: Inside ClinicDetailsTransactions Post ::: " + responseTxt;
				if (l_debug_YN.equals("Y"))
					System.out.println(l_app_msg);
				responseTxt = "200#" + responseTxt + "#";
			}

		} catch (Exception exp) {
			exp.printStackTrace(System.err);
		}
		return responseTxt;
	}
	
	
	@GET
	@Path("/amspeciality")
	@Consumes(MediaType.TEXT_PLAIN)
	@Produces(MediaType.APPLICATION_JSON)
	public Response GetSpecialityDetails(@Context UriInfo info,@Context HttpHeaders headers) {
		
		String actionKey = info.getRequestUri().getQuery();
	    String responseTxt = "";
		String[] str = null;
		
		String addedDate = new java.text.SimpleDateFormat( "yyyy-MM-dd HH:mm:ss" ).format( new java.util.Date() ) ;
		
		try {
			
			System.out.println(" ::: Speciality details request date and time ::: "+addedDate);
			System.out.println(" .............................................................................. ");
			
			l_debug_YN = XHUtil.getDebugYN();
			
			String key = headers.getRequestHeader("key").get(0);
			
			responseTxt = SpecialityDetailsTransactions(actionKey,key, "G");
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
	
	@POST
	@Path("/amspeciality")
	@Consumes(MediaType.TEXT_PLAIN)
	@Produces(MediaType.TEXT_PLAIN)
	public Response PostSpecialityDetails(@Context UriInfo info,@Context HttpHeaders headers) {
		
		String actionKey = info.getRequestUri().getQuery();
	    String responseTxt = "";
		String[] str = null;
		
		String addedDate = new java.text.SimpleDateFormat( "yyyy-MM-dd HH:mm:ss" ).format( new java.util.Date() ) ;
		
		try {
			
			System.out.println(" ::: Speciality details request date and time ::: "+addedDate);
			System.out.println(" .............................................................................. ");
			
			l_debug_YN = XHUtil.getDebugYN();
			
			String key = headers.getRequestHeader("key").get(0);
			
			responseTxt = SpecialityDetailsTransactions(actionKey,key, "P");
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
	
	
	private String SpecialityDetailsTransactions(String paramString, String key, String method) throws Exception {
		String responseTxt = "";
		
		try {
			
			l_app_msg = " ::: Inside SpecialityDetailsTransactions ::: ";
			if (l_debug_YN.equals("Y"))	
				System.out.println(l_app_msg);
			
			l_event_type = "OM02";

			QueryMasterOutboundTransaction QuerySpecDtls = new QueryMasterOutboundTransaction();

			responseTxt = QuerySpecDtls.processOutboundRequest(paramString, key, l_event_type, method);
			
			l_app_msg = " ::: Inside SpecialityDetailsTransactions responseTxt ::: "+responseTxt;
			if (l_debug_YN.equals("Y"))	
			System.out.println(l_app_msg);
			
			if (method.equals("P")) {				
				l_app_msg = " ::: Inside SpecialityDetailsTransactions Post ::: " + responseTxt;
				if (l_debug_YN.equals("Y"))
					System.out.println(l_app_msg);
				responseTxt = "200#" + responseTxt + "#";
			}

		} catch (Exception exp) {
			exp.printStackTrace(System.err);
		}
		return responseTxt;
	}
	
	@GET
	@Path("/ampractitioner")
	@Consumes(MediaType.TEXT_PLAIN)
	@Produces(MediaType.APPLICATION_JSON)
	public Response GetPractitionerDetails(@Context UriInfo info,@Context HttpHeaders headers) {
		
		String actionKey = info.getRequestUri().getQuery();
		
	    String responseTxt = "";
		String[] str = null;
		
		String addedDate = new java.text.SimpleDateFormat( "yyyy-MM-dd HH:mm:ss" ).format( new java.util.Date() ) ;
		
		try {
			
			System.out.println(" ::: Practitioner details request date and time ::: "+addedDate);
			System.out.println(" .............................................................................. ");
			
			l_debug_YN = XHUtil.getDebugYN();
			
			String key = headers.getRequestHeader("key").get(0);
			
			responseTxt = PracDetailsTransactions(actionKey,key, "G");
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
	
	@POST
	@Path("/ampractitioner")
	@Consumes(MediaType.TEXT_PLAIN)
	@Produces(MediaType.TEXT_PLAIN)
	public Response PostPractitionerDetails(@Context UriInfo info,@Context HttpHeaders headers) {
		
		String actionKey = info.getRequestUri().getQuery();
		
	    String responseTxt = "";
		String[] str = null;
		
		String addedDate = new java.text.SimpleDateFormat( "yyyy-MM-dd HH:mm:ss" ).format( new java.util.Date() ) ;
		
		try {
			
			System.out.println(" ::: Practitioner details request date and time ::: "+addedDate);
			System.out.println(" .............................................................................. ");
			
			l_debug_YN = XHUtil.getDebugYN();
			
			String key = headers.getRequestHeader("key").get(0);
			
			responseTxt = PracDetailsTransactions(actionKey, key, "P");
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
	

	private String PracDetailsTransactions(String paramString, String key, String method) throws Exception {
		String responseTxt = "";
		
		try {
			
			l_app_msg = " ::: Inside PracDetailsTransactions ::: ";
			if (l_debug_YN.equals("Y"))	
				System.out.println(l_app_msg);
			
			l_event_type = "OM03";

			QueryMasterOutboundTransaction QueryPracDtls = new QueryMasterOutboundTransaction();

			responseTxt = QueryPracDtls.processOutboundRequest(paramString, key, l_event_type, method);
			
			l_app_msg = " ::: Inside PracDetailsTransactions responseTxt ::: "+responseTxt;
			if (l_debug_YN.equals("Y"))	
			System.out.println(l_app_msg);
			
			if (method.equals("P")) {				
				l_app_msg = " ::: Inside PracDetailsTransactions Post ::: " + responseTxt;
				if (l_debug_YN.equals("Y"))
					System.out.println(l_app_msg);
				
				responseTxt = "200#" + responseTxt + "#";
			}

		} catch (Exception exp) {
			exp.printStackTrace(System.err);
		}
		return responseTxt;
	}
	
	@GET
	@Path("/amcontactreason")
	@Consumes(MediaType.TEXT_PLAIN)
	@Produces(MediaType.APPLICATION_JSON)
	public Response GetReasonDetails(@Context UriInfo info,@Context HttpHeaders headers) {
		
		String actionKey = info.getRequestUri().getQuery();
		
	    String responseTxt = "";
		String[] str = null;
		
		String addedDate = new java.text.SimpleDateFormat( "yyyy-MM-dd HH:mm:ss" ).format( new java.util.Date() ) ;
		
		try {
			
			System.out.println(" ::: Reason details request date and time ::: "+addedDate);
			System.out.println(" .............................................................................. ");
			
			l_debug_YN = XHUtil.getDebugYN();
			
			String key = headers.getRequestHeader("key").get(0);
			
			responseTxt = ReasonDetailsTransactions(actionKey,key,"G");
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
	
	@POST
	@Path("/amcontactreason")
	@Consumes(MediaType.TEXT_PLAIN)
	@Produces(MediaType.TEXT_PLAIN)
	public Response PostReasonDetails(@Context UriInfo info,@Context HttpHeaders headers) {
		
		String actionKey = info.getRequestUri().getQuery();
		
	    String responseTxt = "";
		String[] str = null;
		
		String addedDate = new java.text.SimpleDateFormat( "yyyy-MM-dd HH:mm:ss" ).format( new java.util.Date() ) ;
		
		try {
			
			System.out.println(" ::: Reason details request date and time ::: "+addedDate);
			System.out.println(" .............................................................................. ");
			
			l_debug_YN = XHUtil.getDebugYN();
			
			String key = headers.getRequestHeader("key").get(0);
			
			responseTxt = ReasonDetailsTransactions(actionKey,key,"P");
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
	
	private String ReasonDetailsTransactions(String paramString, String key, String method) throws Exception {
		String responseTxt = "";
		
		try {
			
			l_app_msg = " ::: Inside ReasonDetailsTransactions ::: ";
			if (l_debug_YN.equals("Y"))	
				System.out.println(l_app_msg);
			
			l_event_type = "OM05";

			QueryMasterOutboundTransaction QueryReasonDtls = new QueryMasterOutboundTransaction();

			responseTxt = QueryReasonDtls.processOutboundRequest(paramString, key, l_event_type, method);
			
			l_app_msg = " ::: Inside ReasonDetailsTransactions responseTxt ::: "+responseTxt;
			if (l_debug_YN.equals("Y"))	
			System.out.println(l_app_msg);
			
			if (method.equals("P")) {				
				l_app_msg = " ::: Inside ReasonDetailsTransactions Post ::: " + responseTxt;
				if (l_debug_YN.equals("Y"))
					System.out.println(l_app_msg);
				
				responseTxt = "200#" + responseTxt + "#";
			}

		} catch (Exception exp) {
			exp.printStackTrace(System.err);
		}
		return responseTxt;
	}
	
	@GET
	@Path("/oaclinicschedule")
	@Consumes(MediaType.TEXT_PLAIN)
	@Produces(MediaType.APPLICATION_JSON)
	public Response GetScheduleDetails(@Context UriInfo info,@Context HttpHeaders headers) {
		
		String actionKey = info.getRequestUri().getQuery();
		MultivaluedMap<String,String> params = info.getQueryParameters();
		
	    String responseTxt = "";
		String[] str = null;
		String requestType = "";
		
		String addedDate = new java.text.SimpleDateFormat( "yyyy-MM-dd HH:mm:ss" ).format( new java.util.Date() ) ;
		
		try {
			
			System.out.println(" ::: Query Schedule details request date and time ::: "+addedDate);
			System.out.println(" ::: Query Parameters ::: "+params);
			System.out.println(" .............................................................................. ");
			
			requestType = params.getFirst("request_type");
			System.out.println(" ::: Request Type ::: "+requestType);
			
			l_debug_YN = XHUtil.getDebugYN();
			
			String key = headers.getRequestHeader("key").get(0);
			
			responseTxt = ScheduleDetailsTransactions(actionKey,key, "G", requestType);
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
	
	@POST
	@Path("/oaclinicschedule")
	@Consumes(MediaType.TEXT_PLAIN)
	@Produces(MediaType.TEXT_PLAIN)
	public Response PostScheduleDetails(@Context UriInfo info,@Context HttpHeaders headers) {
		
		String actionKey = info.getRequestUri().getQuery();
		MultivaluedMap<String,String> params = info.getQueryParameters();
		
	    String responseTxt = "";
		String[] str = null;
		String requestType = "";
		
		String addedDate = new java.text.SimpleDateFormat( "yyyy-MM-dd HH:mm:ss" ).format( new java.util.Date() ) ;
		
		try {
			
			System.out.println(" ::: POST Schedule details request date and time ::: "+addedDate);
			System.out.println(" ::: POST Parameters ::: "+params);
			System.out.println(" .............................................................................. ");
			
			requestType = params.getFirst("request_type");
			System.out.println(" ::: Request Type ::: "+requestType);
			
			l_debug_YN = XHUtil.getDebugYN();
			
			String key = headers.getRequestHeader("key").get(0);
			
			responseTxt = ScheduleDetailsTransactions(actionKey,key, "P", requestType);
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
	
	private String ScheduleDetailsTransactions(String paramString, String key, String method, String requestType) throws Exception {
		String responseTxt = "";
		
		try {
			
			l_app_msg = " ::: Inside ScheduleDetailsTransactions ::: ";
			if (l_debug_YN.equals("Y"))	
				System.out.println(l_app_msg);
			
			l_event_type = "OM04";
			
			if (requestType.equalsIgnoreCase("CANSLOT"))
				l_event_type = "OM14";			
			

			QueryMasterOutboundTransaction QueryScheduleDtls = new QueryMasterOutboundTransaction();

			responseTxt = QueryScheduleDtls.processOutboundRequest(paramString, key, l_event_type, method);
			l_app_msg = " ::: Inside ScheduleDetailsTransactions responseTxt ::: " + responseTxt;
			if (l_debug_YN.equals("Y"))
				System.out.println(l_app_msg);

			if (method.equals("P")) {				
				l_app_msg = " ::: Inside ScheduleDetailsTransactions Post ::: " + responseTxt;
				if (l_debug_YN.equals("Y"))
					System.out.println(l_app_msg);
				
				responseTxt = "200#" + responseTxt + "#";
			}
		} catch (Exception exp) {
			exp.printStackTrace(System.err);
		}
		return responseTxt;
	}
	
	@POST
	@Path("/oablockslots")
	@Consumes(MediaType.TEXT_PLAIN)
	@Produces(MediaType.TEXT_PLAIN)
	public Response PostBlockSlots(@Context UriInfo info,@Context HttpHeaders headers) {
		
		String actionKey = info.getRequestUri().getQuery();
		
	    String responseTxt = "";
		String[] str = null;
		
		String addedDate = new java.text.SimpleDateFormat( "yyyy-MM-dd HH:mm:ss" ).format( new java.util.Date() ) ;
		
		try {
			
			System.out.println(" ::: Query Block Slots details request date and time ::: "+addedDate);
			System.out.println(" .............................................................................. ");
			
			l_debug_YN = XHUtil.getDebugYN();
			
			String key = headers.getRequestHeader("key").get(0);
			
			responseTxt = BLockSlotsTransactions(actionKey,key, "P");
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
	
	private String BLockSlotsTransactions(String paramString, String key, String method) throws Exception {
		String responseTxt = "";
		
		try {
			
			l_app_msg = " ::: Inside BlockSLots Transactions ::: ";
			if (l_debug_YN.equals("Y"))	
				System.out.println(l_app_msg);
			
			l_event_type = "OA36";

			QueryMasterOutboundTransaction QueryBlockSlotsDtls = new QueryMasterOutboundTransaction();

			responseTxt = QueryBlockSlotsDtls.processOutboundRequest(paramString, key, l_event_type, method);
			l_app_msg = " ::: Inside ReasonDetailsTransactions responseTxt ::: " + responseTxt;
			if (l_debug_YN.equals("Y"))
				System.out.println(l_app_msg);

			if (method.equals("P")) {				
				l_app_msg = " ::: Inside ScheduleDetailsTransactions Post ::: " + responseTxt;
				if (l_debug_YN.equals("Y"))
					System.out.println(l_app_msg);

				responseTxt = "200#" + responseTxt + "#";
			}
		} catch (Exception exp) {
			exp.printStackTrace(System.err);
		}
		return responseTxt;
	}
	
	@POST
	@Path("/oaunblockslots")
	@Consumes(MediaType.TEXT_PLAIN)
	@Produces(MediaType.TEXT_PLAIN)
	public Response PostUnBlockSlots(@Context UriInfo info,@Context HttpHeaders headers) {
		
		String actionKey = info.getRequestUri().getQuery();
		
	    String responseTxt = "";
		String[] str = null;
		
		String addedDate = new java.text.SimpleDateFormat( "yyyy-MM-dd HH:mm:ss" ).format( new java.util.Date() ) ;
		
		try {
			
			System.out.println(" ::: Query Block Slots details request date and time ::: "+addedDate);
			System.out.println(" .............................................................................. ");
			
			l_debug_YN = XHUtil.getDebugYN();
			
			String key = headers.getRequestHeader("key").get(0);
			
			responseTxt = UnBLockSlotsTransactions(actionKey,key, "P");
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
	
	private String UnBLockSlotsTransactions(String paramString, String key, String method) throws Exception {
		String responseTxt = "";
		
		try {
			
			l_app_msg = " ::: Inside Un-BlockSLots Transactions ::: ";
			if (l_debug_YN.equals("Y"))	
				System.out.println(l_app_msg);

			l_event_type = "OA37";

			QueryMasterOutboundTransaction QueryBlockSlotsDtls = new QueryMasterOutboundTransaction();

			responseTxt = QueryBlockSlotsDtls.processOutboundRequest(paramString, key, l_event_type, method);
			l_app_msg = " ::: Inside ReasonDetailsTransactions responseTxt ::: " + responseTxt;
			if (l_debug_YN.equals("Y"))
				System.out.println(l_app_msg);

			if (method.equals("P")) {				
				l_app_msg = " ::: Inside ScheduleDetailsTransactions Post ::: " + responseTxt;
				if (l_debug_YN.equals("Y"))
					System.out.println(l_app_msg);

				responseTxt = "200#" + responseTxt + "#";
			}
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

}
