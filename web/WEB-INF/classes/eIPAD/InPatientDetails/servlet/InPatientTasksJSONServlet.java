/**
 * 
 */
package eIPAD.InPatientDetails.servlet;

import java.io.IOException;
import java.util.Properties;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ehis.persist.PersistenceHelper;
import com.google.gson.Gson;

import eIPAD.InPatientDetails.request.InPatientTaskRequest;
import eIPAD.InPatientDetails.dao.InPatientTasksDAO;
import eIPAD.InPatientDetails.daoimps.InPatientTasksDAOImpl;
import eIPAD.InPatientDetails.response.InPatientTaskResponse;
import eIPAD.chartsummary.common.healthobject.PatContext;
import eIPAD.chartsummary.common.response.TransactionResponse;

/**
 * @author saraswathir
 *
 */
public class InPatientTasksJSONServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String jsonFieldResponse = "";
		String mode = request.getParameter("requestMode") == null ? "" : request.getParameter("requestMode");
		String loginuserid = "";
		String client_ip_address = "";
		HttpSession session = request.getSession(false);
		Properties p = (java.util.Properties) session.getValue( "jdbc" ) ;
		
		String bean_id = "Or_FutureOrder" ;
		String bean_name = "eOR.FutureOrder";
		eOR.FutureOrder futureBean = (eOR.FutureOrder)PersistenceHelper.getBeanObject( bean_id, bean_name, request  ) ;
		eOR.OrderEntryBillingQueryBean billingbean = (eOR.OrderEntryBillingQueryBean)PersistenceHelper.getBeanObject( "Or_BillingQry", "eOR.OrderEntryBillingQueryBean", request ) ;
		billingbean.clearBean();
		futureBean.setOrderEntryBillBean(billingbean);
		if("PATIENT_TASKS".equals(mode)){
			String patientId =request.getParameter("patientId") == null? "":request.getParameter("patientId");
			String facilityId =request.getParameter("facilityId") == null? "":request.getParameter("facilityId");
			String encounterId =request.getParameter("encounterId") == null? "":request.getParameter("encounterId");
			String clinicianId = request.getParameter("clinicianId") == null? "":request.getParameter("clinicianId");
			PatContext patientContext = new PatContext();
			patientContext.setPatientId(patientId);
			patientContext.setFacilityId(facilityId);
			patientContext.setEncounterId(encounterId);
			patientContext.setClinicianId(clinicianId);
			patientContext.setLocale("en");
			response.setContentType("application/json");
			
			InPatientTasksDAO patTaskDAO = new InPatientTasksDAOImpl();
			Gson gson = new Gson();
			
			InPatientTaskRequest taskRequest = new InPatientTaskRequest();
			if(patientContext != null) {
				taskRequest.setPatientContext(patientContext);
			}
			
			InPatientTaskResponse taskResponse = patTaskDAO.getInPatientPendingTasks(taskRequest, request);
			if(taskResponse != null ){
				jsonFieldResponse = gson.toJson(taskResponse);
			}	
		}else if("PATIENT_CHARGE".equals(mode)){
			String patientId =request.getParameter("patientId") == null? "":request.getParameter("patientId");
			String facilityId =request.getParameter("facilityId") == null? "":request.getParameter("facilityId");
			String encounterId =request.getParameter("encounterId") == null? "":request.getParameter("encounterId");
			String clinicianId = request.getParameter("clinicianId") == null? "":request.getParameter("clinicianId");
			loginuserid =(String) session.getValue("login_user");
			client_ip_address = p.getProperty("client_ip_address");
			PatContext patientContext = new PatContext();
			patientContext.setPatientId(patientId);
			patientContext.setFacilityId(facilityId);
			patientContext.setEncounterId(encounterId);
			patientContext.setClinicianId(clinicianId);
			patientContext.setLocale("en");
			patientContext.setLoggedInUser(loginuserid);
			response.setContentType("application/json");
			
			InPatientTasksDAO patTaskDAO = new InPatientTasksDAOImpl();
			Gson gson = new Gson();
			
			InPatientTaskRequest taskRequest = new InPatientTaskRequest();
			if(patientContext != null) {
				taskRequest.setPatientContext(patientContext);
				taskRequest.setClientIpAddress(client_ip_address);
			}
			TransactionResponse taskResponse = patTaskDAO.getPerformChargePatient(taskRequest, request);
			if(taskResponse != null ){
				jsonFieldResponse = gson.toJson(taskResponse);
			}
		}
		PersistenceHelper.putObjectInBean(bean_id,futureBean,request); 
		response.getWriter().write(jsonFieldResponse);
		
	}
}
