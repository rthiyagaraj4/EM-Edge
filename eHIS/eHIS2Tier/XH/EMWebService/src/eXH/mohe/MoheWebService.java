package eXH.mohe;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;


import eXH.util.*;

@Path("/v1")
public class MoheWebService {
	
	public static String l_debug_YN = "N";
	public static String l_app_msg = "";
	
	// Method Added for Cash Counter Login Check
	@POST
	@Path("/CashCounterLogin")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response cashCounterLogin(String actionKey) {
		String responseTxt = "";
		String[] str = null;
		try {
			System.out.println(" ::: cashCounterLogin ::: ");
			l_debug_YN = XHUtil.getDebugYN();
			
			//MohePatientVisitBillTransaction mohePatientVisitBillTrans = new MohePatientVisitBillTransaction();
			MoheCashCounterLoginTransaction moheCashCounterLoginTrans = new MoheCashCounterLoginTransaction();
			responseTxt = moheCashCounterLoginTrans.TransRequestMethod(actionKey);
			System.out.println(" ::: Final response : "+responseTxt);
			str = responseTxt.split("#");
		} catch (Exception e) {
			e.printStackTrace();
			responseTxt = "E$!^Exception Occured";
		}
		return Response.status(responseCode(str[0])).entity(str[1]).build();	
	}
	
	// Method Added for Cash Counter Login Check
	@POST
	@Path("/PatientVisitBill")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response patientVisitBill(String actionKey) {
		String responseTxt = "";
		String[] str = null;
		try {
			System.out.println(" ::: patientVisitBill ::: ");
			l_debug_YN = XHUtil.getDebugYN();
			
			MohePatientVisitBillTransaction mohePatientVisitBillTrans = new MohePatientVisitBillTransaction();
			responseTxt = mohePatientVisitBillTrans.TransRequestMethod(actionKey);
			System.out.println(" ::: Final response : "+responseTxt);
			str = responseTxt.split("#");
		} catch (Exception e) {
			e.printStackTrace();
			responseTxt = "E$!^Exception Occured";
		}
		return Response.status(responseCode(str[0])).entity(str[1]).build();	
	}
	
	// Method Added for Cash Counter Login Check
	@POST
	@Path("/CashCounterLoginCheck")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response cashCounterLoginCheck(String actionKey) {
		String responseTxt = "";
		String[] str = null;
		try {
			System.out.println(" ::: cashCounterLoginCheck ::: ");
			l_debug_YN = XHUtil.getDebugYN();
			
			MoheCashCounterLoginCheckTransaction moheCashCounterLoginCheckTrans = new MoheCashCounterLoginCheckTransaction();
			responseTxt = moheCashCounterLoginCheckTrans.TransRequestMethod(actionKey);
			System.out.println(" ::: Final response : "+responseTxt);
			str = responseTxt.split("#");
		} catch (Exception e) {
			e.printStackTrace();
			responseTxt = "E$!^Exception Occured";
		}
		return Response.status(responseCode(str[0])).entity(str[1]).build();	
	}
	
	// Method Added for Deposit Refund Check
	@POST
	@Path("/DepositRefundCheck")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response depositRefundCheck(String actionKey) {
		String responseTxt = "";
		String[] str = null;
		try {
			System.out.println(" ::: depositRefundCheck ::: ");
			l_debug_YN = XHUtil.getDebugYN();
			
			MoheDepositRefundCheckTransaction moheDepositRefundCheckTrans = new MoheDepositRefundCheckTransaction();
			responseTxt = moheDepositRefundCheckTrans.TransRequestMethod(actionKey);
			System.out.println(" ::: Final response : "+responseTxt);
			str = responseTxt.split("#");
		} catch (Exception e) {
			e.printStackTrace();
			responseTxt = "E$!^Exception Occured";
		}
		return Response.status(responseCode(str[0])).entity(str[1]).build();	
	}
	
	// Method Added for Patient Visit Registration
	@POST
	@Path("/RegisterVisit")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response patientVisitRegistration(String actionKey) {
		String responseTxt = "";
		String[] str = null;
		try {
			System.out.println("patientVisitRegistration...");
			l_debug_YN = XHUtil.getDebugYN();
			
			responseTxt = RegisterVisit(actionKey);
			System.out.println("patientVisitRegistration after method..."+responseTxt);
			str = responseTxt.split("#");
		} catch (Exception e) {
			e.printStackTrace();
			responseTxt = "E$!^Exception Occured";
		}
		return Response.status(responseCode(str[0])).entity(str[1]).build();	
	}
	
	private String RegisterVisit(String paramString) throws Exception {
		String responseTxt = "";

		try {
			
				l_app_msg = " ::: Inside RegisterVisit ::: ";
				if (l_debug_YN.equals("Y"))	
					System.out.println(l_app_msg);
				
				l_app_msg = " ::: Inside RegisterVisit paramString ::: "+paramString;
				if (l_debug_YN.equals("Y"))	
					System.out.println(l_app_msg);

				MoheVisitRegistration VisitRegistrationDtls = new MoheVisitRegistration();

				responseTxt = VisitRegistrationDtls.processRequest(paramString);
				
				l_app_msg = " ::: Inside MoheVisitRegistration responseTxt ::: "+responseTxt;
				if (l_debug_YN.equals("Y"))	
					System.out.println(l_app_msg);


		} catch (Exception exp) {
			exp.printStackTrace(System.err);
		}
		return responseTxt;
	}
	
	// Method Added for Patient Registration
	@POST
	@Path("/RegisterPatient")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response patientRegistration(String actionKey) {
		String responseTxt = "";
		String[] str = null;
		try {
			System.out.println("RegisterPatientDetails...");
			l_debug_YN = XHUtil.getDebugYN();
			
			responseTxt = RegisterPatient(actionKey);
			System.out.println("RegisterPatientDetails after method...");
			str = responseTxt.split("#");
		} catch (Exception e) {
			e.printStackTrace();
			responseTxt = "E$!^Exception Occured";
		}
		return Response.status(responseCode(str[0])).entity(str[1]).build();	
	}
	
	@POST
	@Path("/bookAppointment")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response BookTrans(String actionKey) {
		//String dbDetails = ConnectionManager.getDBDetails();
		String responseTxt = "";
		String[] str = null;
		
		try {
			
			l_debug_YN = XHUtil.getDebugYN();
			
			l_app_msg = " ::: Inside Book Appointment ::: ";
			if (l_debug_YN.equals("Y"))	
				System.out.println(l_app_msg);
			
			//String key = headers.getRequestHeader("key").get(0);
			if(!actionKey.contains("bankrefNo") || !actionKey.contains("netAmountDebit")){
				System.out.println("::: Book Appointment without payment Details :::");
				responseTxt = MoheInboundTransactions(actionKey, "OA21");
			}
			else if (actionKey.contains("bankrefNo") || actionKey.contains("netAmountDebit"))
			{
				System.out.println("::: Book Appointment with payment Details :::");
				responseTxt=MohePaymentTransactions(actionKey,"OA25");
			}
			System.out.println("responseTxt11123332: "+responseTxt);
			str = responseTxt.split("#");
			System.out.println("str11123332: "+str);
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
	public Response CancelTrans(String actionKey) {
		String responseTxt = "";
		String[] str = null;
		
		try {
			
				l_debug_YN = XHUtil.getDebugYN();
			
				l_app_msg = " ::: Inside Cancel Appointment ::: ";
				if (l_debug_YN.equals("Y"))	
					System.out.println(l_app_msg);
				
				//String key =  headers.getRequestHeaders().get("key").get(0);
			
				responseTxt = MoheInboundTransactions(actionKey, "OA22");
				str = responseTxt.split("#");
			
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
	public Response RescheduleTrans(String actionKey) {
		String responseTxt = "";
		String[] str = null;
		
		try {
			
				l_debug_YN = XHUtil.getDebugYN();
			
				l_app_msg = " ::: Inside Reshedule Appointment ::: ";
				if (l_debug_YN.equals("Y"))	
					System.out.println(l_app_msg);
			
				//String key = headers.getRequestHeader("key").get(0);
				responseTxt = MoheInboundTransactions(actionKey, "OA23");
				str = responseTxt.split("#");
			
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
	public Response BlockTrans(String actionKey) {
		String responseTxt = "";
		String[] str = null;
		
		try {
			
				l_debug_YN = XHUtil.getDebugYN();
			
				l_app_msg = " ::: Inside Block Appointment ::: ";
				if (l_debug_YN.equals("Y"))	
					System.out.println(l_app_msg);
				
				//String key = headers.getRequestHeader("key").get(0);
				responseTxt = MoheInboundTransactions(actionKey, "OA24");
				str = responseTxt.split("#");
			
		} catch (Exception e) {
			e.printStackTrace();
			responseTxt = "E#Exception Occured";
		}
		return Response.status(responseCode(str[0])).entity(str[1]).build();
		//return responseTxt;

	}
	
	//Method For Patient Details transactions
	@POST
	@Path("/QueryPatientDetails")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response patientDetails(String actionKey) {
		String responseTxt = "";
		String[] str = null;
		try {
			
			l_debug_YN = XHUtil.getDebugYN();
			
			responseTxt = PatientDetailsTransactions(actionKey);
			str = responseTxt.split("#");
		} catch (Exception e) {
			e.printStackTrace();
			responseTxt = "E$!^Exception Occured";
		}
		return Response.status(responseCode(str[0])).entity(str[1]).build();
	}
	
	@POST
	@Path("/QueryVisitType")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response QueryVisitType(String actionKey) {
		String responseTxt = "";
		String[] str = null;
		try {
			
			l_debug_YN = XHUtil.getDebugYN();
			
			l_app_msg = " ::: Inside Query Visit Type  ::: ";
			if (l_debug_YN.equals("Y"))	
				System.out.println(l_app_msg);
			
			responseTxt = QueryVisitTypeTransaction(actionKey);
			str = responseTxt.split("#");
		} catch (Exception e) {
			e.printStackTrace();
			responseTxt = "E$!^Exception Occured";
		}
		return Response.status(responseCode(str[0])).entity(str[1]).build();
	}
	
	@POST
	@Path("/QueryConsultAvail")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response QueryConsultAvail(String actionKey) {
		String responseTxt = "";
		String[] str = null;
		try {
			
			l_debug_YN = XHUtil.getDebugYN();
			
			l_app_msg = " ::: Inside Query Visit Type  ::: ";
			if (l_debug_YN.equals("Y"))	
				System.out.println(l_app_msg);
			
			responseTxt = QueryConsultAvailiability(actionKey);
			str = responseTxt.split("#");
			System.out.println("str o..."+str[0]+"..str1.."+str[1]+"..responseTxt.."+responseTxt);
		} catch (Exception e) {
			e.printStackTrace();
			responseTxt = "E$!^Exception Occured";
		}
		return Response.status(responseCode(str[0])).entity(str[1]).build();
	}
	
	private String RegisterPatient(String paramString) throws Exception {
		String responseTxt = "";

		try {
			
				l_app_msg = " ::: Inside PatientDetailsTransactions ::: ";
				if (l_debug_YN.equals("Y"))	
					System.out.println(l_app_msg);
				
				l_app_msg = " ::: Inside PatientDetailsTransactions paramString ::: "+paramString;
				if (l_debug_YN.equals("Y"))	
					System.out.println(l_app_msg);

				MoheRegisterPatient QueryPatientDtls = new MoheRegisterPatient();

				responseTxt = QueryPatientDtls.processRequest(paramString);
				
				l_app_msg = " ::: Inside PatientDetailsTransactions responseTxt ::: "+responseTxt;
				if (l_debug_YN.equals("Y"))	
					System.out.println(l_app_msg);


		} catch (Exception exp) {
			exp.printStackTrace(System.err);
		}
		return responseTxt;
	}
			
		
	private String PatientDetailsTransactions(String paramString) throws Exception {
		String responseTxt = "";

		try {
			
				l_app_msg = " ::: Inside PatientDetailsTransactions ::: ";
				if (l_debug_YN.equals("Y"))	
					System.out.println(l_app_msg);
				
				l_app_msg = " ::: Inside PatientDetailsTransactions paramString ::: "+paramString;
				if (l_debug_YN.equals("Y"))	
					System.out.println(l_app_msg);

				MoheQueryPatientDetailsTransaction QueryPatientDtls = new MoheQueryPatientDetailsTransaction();

				responseTxt = QueryPatientDtls.processRequest(paramString);
				
				l_app_msg = " ::: Inside PatientDetailsTransactions responseTxt ::: "+responseTxt;
				if (l_debug_YN.equals("Y"))	
					System.out.println(l_app_msg);


		} catch (Exception exp) {
			exp.printStackTrace(System.err);
		}
		return responseTxt;
	}
		
		
	private String MoheInboundTransactions(String paramString, String requestType){
		String responseTxt = "";		
		
		try {
			
				l_app_msg = " ::: Inside MoheInboundTransactions ::: ";
				if (l_debug_YN.equals("Y"))	
					System.out.println(l_app_msg);
				
				l_app_msg = " ::: Inside MoheInboundTransactions paramString ::: "+paramString;
				if (l_debug_YN.equals("Y"))	
					System.out.println(l_app_msg);
	
				MoheInboundTransaction QHISTrans = new MoheInboundTransaction();
	
				responseTxt = QHISTrans.processRequest(paramString, requestType);
				
				l_app_msg = " ::: Inside MoheInboundTransactions responseTxt ::: "+responseTxt;
				if (l_debug_YN.equals("Y"))	
					System.out.println(l_app_msg);
	
				if (responseTxt.indexOf("Error") == 0) {
					return responseTxt;
				}
	
		} catch (Exception exp) {
			System.out.println("(MoheInboundTransactions) Exception occurred : "+exp.getMessage());
			exp.printStackTrace(System.err);
		}
		
		return responseTxt;
	}
	
	private String QueryVisitTypeTransaction(String paramString) throws Exception {
		String responseTxt = "";

		try {
			
				l_app_msg = " ::: Inside PatientDetailsTransactions ::: ";
				if (l_debug_YN.equals("Y"))	
					System.out.println(l_app_msg);
				
				l_app_msg = " ::: Inside PatientDetailsTransactions paramString ::: "+paramString;
				if (l_debug_YN.equals("Y"))	
					System.out.println(l_app_msg);

				MoheQueryVisitTypeTransaction QueryVisitType = new MoheQueryVisitTypeTransaction();

				responseTxt = QueryVisitType.processRequest(paramString);
				
				l_app_msg = " ::: Inside PatientDetailsTransactions responseTxt ::: "+responseTxt;
				if (l_debug_YN.equals("Y"))	
					System.out.println(l_app_msg);


		} catch (Exception exp) {
			exp.printStackTrace(System.err);
		}
		return responseTxt;
	}
	
	private String MohePaymentTransactions(String paramString, String requestType){
		String responseTxt = "";		
		
		try {
			
				l_app_msg = "::: Inside MoheInboundTransactions ::: ";
				if (l_debug_YN.equals("Y"))	
					System.out.println(l_app_msg);
				
				l_app_msg = "::: Inside MoheInboundTransactions paramString ::: "+paramString;
				if (l_debug_YN.equals("Y"))
					System.out.println(l_app_msg);

				MohePaymentTransaction QHISTrans = new MohePaymentTransaction();
	
				responseTxt = QHISTrans.processRequest(paramString, requestType);
				
				l_app_msg = "::: Inside MoheInboundTransactions responseTxt ::: "+responseTxt;
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
	
	private String QueryConsultAvailiability(String paramString) throws Exception {
		String responseTxt = "";

		try {
			
				l_app_msg = " ::: Inside PatientDetailsTransactions ::: ";
				if (l_debug_YN.equals("Y"))	
					System.out.println(l_app_msg);
				
				l_app_msg = " ::: Inside PatientDetailsTransactions paramString ::: "+paramString;
				if (l_debug_YN.equals("Y"))	
					System.out.println(l_app_msg);

				MoheQueryConsultAvailability QueryConsultAvail = new MoheQueryConsultAvailability();

				responseTxt = QueryConsultAvail.processRequest(paramString);
				
				l_app_msg = " ::: Inside QueryConsultAvailiability responseTxt ::: "+responseTxt;
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
	
	
	
}
