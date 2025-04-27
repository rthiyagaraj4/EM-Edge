/**
 * 
 */
package eIPAD.registerorder.servlet;

import java.io.IOException;
import java.util.HashMap;
import java.util.Hashtable;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ehis.persist.PersistenceHelper;
import com.google.gson.Gson;

import eIPAD.chartsummary.common.response.TransactionResponse;
import eOR.RegisterOrder;
import eOR.Common.OrAdapter;

/**
 * @author saraswathir
 *
 */
public class RegisterOrderJSONServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Gson gson = new Gson();
		String jsonFieldResponse = "";
		response.setContentType("application/json");
		HttpSession session = request.getSession(false);
		String requestMode =request.getParameter("requestMode") == null? "":request.getParameter("requestMode");
		HashMap map = null;
		if(requestMode.equals("RegisterOrder")){
			TransactionResponse transactionResp = new TransactionResponse();
			try{
				String bean_id="Or_RegisterOrder";
				String bean_name="eOR.RegisterOrder";
				OrAdapter beanObj = (RegisterOrder)PersistenceHelper.getBeanObject( bean_id, bean_name, request) ;
				boolean local_ejbs = false;
				if ((getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS") !=null) && (getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS").equalsIgnoreCase("TRUE"))) 
					local_ejbs = true;
				beanObj.setLocalEJB(local_ejbs);
				
				String total_recs = request.getParameter("total_recs") == null? "":request.getParameter("total_recs");
				String practitionerId = (String)session.getAttribute("practitioner_id")== null? "":(String)session.getAttribute("practitioner_id");
				String practitioner_type = (String)session.getAttribute("practitioner_type")== null? "":(String)session.getAttribute("practitioner_type");
				String login_user = (String)session.getAttribute( "login_user")== null? "":(String)session.getAttribute( "login_user");
				String facilityId = (String) session.getAttribute( "facility_id")== null? "":(String) session.getAttribute( "facility_id");
				String locale = (String) session.getAttribute("LOCALE")== null? "":(String) session.getAttribute("LOCALE");
				beanObj.setLoginById(login_user);
				java.util.Properties p = (java.util.Properties) session.getAttribute( "jdbc" ) ;
				String client_ip_address = (String) p.getProperty("client_ip_address");
				beanObj.setLoginAtWsNo( client_ip_address ) ;
				beanObj.setLoginFacilityId(facilityId);
				beanObj.setLanguageId(locale ) ;
				String mode = "1";
				beanObj.setMode(mode);
				String function_id = "";
				String view_by = "H";
				Hashtable hash = new Hashtable();
				int total_recs_int = Integer.parseInt(total_recs);
				if(total_recs_int>0){
					for(int i=0;i<total_recs_int;i++){
						String ord_id = request.getParameter("ord_id"+i) == null? "":request.getParameter("ord_id"+i); 
						String order_category = request.getParameter("order_category"+i) == null? "":request.getParameter("order_category"+i); 
						hash.put("ord_id"+i, ord_id);
						hash.put("order_category"+i, order_category);
						hash.put("cont_order_ind"+i, "DO");
						hash.put("view_by"+i, view_by);
						hash.put("chk"+i, "on");
						hash.put("ord_consent_status"+i, "N");
						hash.put("order_set_id"+i, "");
						hash.put("prn_reg_ord"+i, "N");
						
					}
				}
				hash.put("HttpRequest", request) ;
				hash.put("HttpResponse", response) ;
				hash.put("total_recs", total_recs);
				hash.put("mode" , mode);
				hash.put("practitioner_id" , practitionerId);
				hash.put("bean_id" , bean_id);
				hash.put("bean_name" , bean_name);
				hash.put("function_id", function_id);
				hash.put("view_by", view_by);
				hash.put("pract_type", practitioner_type);
				hash.put("login_value", "pract");
				hash.put("activity_type", "");
				hash.put("specimen_no", "");
				hash.put("int_or_ext", "");
				hash.put("performing_location_code", "");
				hash.put("order_no", "");
				hash.put("encntr_id", "");
				hash.put("patientId", "");
				hash.put("locn", "");
				hash.put("location_type", "");
				hash.put("priority", "");
				hash.put("ord_type", "");
				hash.put("single_multi", "");
				hash.put("ord_cat", "");
				
				beanObj.setAll(hash);
			 	map = beanObj.validate() ;
				boolean validated = ((Boolean) map.get( "result" )).booleanValue() ;
				if(validated){
					map = beanObj.apply() ;	
					boolean result = ((Boolean) map.get( "result" )).booleanValue() ;
					if(result){
						transactionResp.setTransactionResult(transactionResp.SUCCESS);
					}else{
						transactionResp.setTransactionResult(transactionResp.FAILURE);
					}
				}else{
					transactionResp.setTransactionResult(transactionResp.FAILURE);
				}
				jsonFieldResponse = gson.toJson(transactionResp);
				PersistenceHelper.putObjectInBean(bean_id,beanObj,request);
			}
			catch(Exception e){
				transactionResp.setTransactionResult(transactionResp.FAILURE);
			}
		}
		response.getWriter().write(jsonFieldResponse);
	}

}
