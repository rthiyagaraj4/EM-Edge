package eBL;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.ArrayList;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ehis.eslp.ServiceLocator;
import com.ehis.persist.PersistenceHelper;

import eBL.placeorder.common.request.BaseRequest;
import eBL.placeorder.model.BLChargePatientExistingOrderBean;
import eBL.placeorder.request.PlaceNewOrderRequest;
import eBL.placeorder.response.PlaceNewOrderResponse;

/**
 * This Servlet routes the Request from Existing Order Related Pages to EJB ChargePatientNewOrder.
 * Response Object is recieved by this Servlet.
 * Decides Whether Error occurred in Transaction.  
 * Based on the Error Rsponse is redirected to BLExistingOrderMessage.jsp  
 * @author ravaradharajan
 *
 */
public class BLExistingOrderServlet extends HttpServlet {
	//private static final long serialVersionUID = 1L; //commented checkstyle
	java.util.Properties p;
	String facilityId="";
	String client_ip_address="";
	String login_user="";
	String slmt_ind="",adm_rec_flag="";
	String locale = "";
	String facility_id = "";
	HttpSession session;
	String mode="";
	java.text.SimpleDateFormat dateFormat = new java.text.SimpleDateFormat( "yyyy-MM-dd" ) ;
	
	Locale loc = null;
	ResourceBundle rb = null;
	
	String beanId = "BLChargePatientExistingOrderBean" ;
	String beanName = "eBL.placeorder.model.BLChargePatientExistingOrderBean";
	boolean local_ejbs = false;
	BLChargePatientExistingOrderBean serviceBean = null;

	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BLExistingOrderServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		try{
			session=req.getSession(false);
			PlaceNewOrderResponse response = null;
			String mode = req.getParameter("mode");
			locale = (String)session.getAttribute("LOCALE");
			loc = new Locale(locale);
			rb = ResourceBundle.getBundle("eSM.resources.Messages",loc);
			this.p = (java.util.Properties) session.getValue( "jdbc" ) ;
			login_user = this.p.getProperty( "login_user" ) ;
			
			facility_id = (String) session.getValue( "facility_id" ) ;
			client_ip_address = this.p.getProperty("client_ip_address") ;
			if("amendService".equals(mode)){
				response = amendExistingOrder(req,res);
			}
			else if("discountService".equals(mode)){
				response = discountForService(req,res);
			}
			else{
				response = updateExistingOrder(req,res,mode);
			}
			
			List<String> errorList = response.getErrorList();
			List<String> warningList = response.getWarningList();
			String hdnReSize = req.getParameter("hdnReSize");
			
			
			StringBuffer consErrorText = new StringBuffer();
			StringBuffer consWarningText = new StringBuffer();
			String error = "", warning="";
			int err_val = 1;
			if(!errorList.isEmpty()){
				for (Iterator<String> iterator = errorList.iterator(); iterator.hasNext();) {
					err_val = 2;
					error = (String) iterator.next();
					consErrorText.append(error);
					consErrorText.append("<br/>");
				}
			}
			error = consErrorText.toString();
			
			if(warningList == null){
				warningList = new ArrayList<String>();
			}
			if(!warningList.isEmpty()){
				for (Iterator<String> iterator = warningList.iterator(); iterator.hasNext();) {
					warning = (String) iterator.next();
					consWarningText.append(error);
					consWarningText.append("<br/>");
				}
			}
			warning = consWarningText.toString();
									
			if("".equals(error)){
				try{
					error = rb.getString("RECORD_INSERTED");
				}
				catch(Exception rbException){
					System.err.println("Exceprion in RB ->"+rbException);
					error = "APP-SM0070 Operation Completed Successfully ....";
				}
				//error = "Operation Completed Sucessfully";
				/*if("cancelAll".equals(mode) || "cancelBLServ".equals(mode)){
					if(!"".equals(warning)){
						error = error + "<br/>"+
								"Below are the warning messages <br/> ";
					}
				}*/
			}
			else{
				error = "Record not saved"+"<br/>"+error;
			}
			/*String redirect = "<script> "+
								"parent.BLChargePatientEncounterTabPage.document.getElementById('add_mod').click(); "+
							"</script>";
			PrintWriter out = res.getWriter();
			out.println(error);
			out.println(redirect);*/
			if("UP".equals(hdnReSize)){
				res.sendRedirect("../eBL/jsp/BLExistingOrderMessage.jsp?calledFrom=processOrder&err_num=" + java.net.URLEncoder.encode( error,"UTF-8" ) +"&err_value="+err_val);
			}
			else if("cancelAll".equals(mode)){
				res.sendRedirect("../eBL/jsp/BLExistingOrderMessage.jsp?calledFrom=cancelAll&err_num=" + java.net.URLEncoder.encode( error,"UTF-8" ) +"&err_value="+err_val+"&warning="+ java.net.URLEncoder.encode( warning,"UTF-8" ));
			}
			else if("cancelBLServ".equals(mode)){
				res.sendRedirect("../eBL/jsp/BLExistingOrderMessage.jsp?calledFrom=cancelBLServ&err_num=" + java.net.URLEncoder.encode( error,"UTF-8" ) +"&err_value="+err_val+"&warning="+ java.net.URLEncoder.encode( warning,"UTF-8" ));
			}
			else{
				res.sendRedirect("../eBL/jsp/BLExistingOrderMessage.jsp?calledFrom=existingOrder&err_num=" + java.net.URLEncoder.encode( error,"UTF-8" ) +"&err_value="+err_val);
			}
			
			}
			catch(Exception e){
				System.err.println("Exception in Existing Order Servlet->"+e);
			}
	}

	private PlaceNewOrderResponse discountForService(HttpServletRequest req,
			HttpServletResponse res) {
		PlaceNewOrderResponse responseBean = null;
		try{
			serviceBean = (BLChargePatientExistingOrderBean) PersistenceHelper.getObjectFromBean(beanId, beanName, session);
			serviceBean.setAdhocDiscount(req.getParameter("adhocDiscAmt"));
			serviceBean.setNetCharge(req.getParameter("patPayable"));
			serviceBean.setDiscReason(req.getParameter("discReason"));
			if ((getServletConfig().getServletContext().getInitParameter(
					"LOCAL_EJBS") != null)
					&& (getServletConfig().getServletContext()
							.getInitParameter("LOCAL_EJBS")
							.equalsIgnoreCase("TRUE"))) {
				local_ejbs = true;
			}
			

			Object home = ServiceLocator.getInstance().getHome(
					"java:comp/env/ChargePatientNewOrder",eBL.ChargePatientNewOrder.ChargePatientNewOrderHome.class, local_ejbs);
			Object busObj = (home.getClass().getMethod("create")).invoke(home);
			
			PlaceNewOrderRequest requestBean = new PlaceNewOrderRequest();
			requestBean.setFacilityId(facility_id);
			requestBean.setLoginUser(login_user);
			requestBean.setClientIpAddress(client_ip_address);
			requestBean.setExistingOrderBean(serviceBean);
			requestBean.setLocale(locale);
			
			Object argArray[]  = new Object[1];
			argArray[0] = requestBean;	


			Class [] paramArray	   = new Class[1];
			paramArray[0] = requestBean.getClass();
				 
				  
			responseBean=(PlaceNewOrderResponse) (busObj.getClass().getMethod("discountBLServ",paramArray)).invoke(busObj, argArray);
			
		}
		catch(Exception e){
			
		}
		return responseBean;
	}

	@SuppressWarnings("unchecked")
	private PlaceNewOrderResponse amendExistingOrder(HttpServletRequest req,
			HttpServletResponse res) {
		PlaceNewOrderResponse responseBean = null;
		try{
			serviceBean = (BLChargePatientExistingOrderBean) PersistenceHelper.getObjectFromBean(beanId, beanName, session);
			serviceBean.setServQty(req.getParameter("qty"));
			serviceBean.setNetCharge(req.getParameter("patPayable"));
			serviceBean.setPhysicianId(req.getParameter("drName"));
			if ((getServletConfig().getServletContext().getInitParameter(
					"LOCAL_EJBS") != null)
					&& (getServletConfig().getServletContext()
							.getInitParameter("LOCAL_EJBS")
							.equalsIgnoreCase("TRUE"))) {
				local_ejbs = true;
			}
			

			Object home = ServiceLocator.getInstance().getHome(
					"java:comp/env/ChargePatientNewOrder",eBL.ChargePatientNewOrder.ChargePatientNewOrderHome.class, local_ejbs);
			Object busObj = (home.getClass().getMethod("create")).invoke(home);
			
			PlaceNewOrderRequest requestBean = new PlaceNewOrderRequest();
			requestBean.setFacilityId(facility_id);
			requestBean.setLoginUser(login_user);
			requestBean.setClientIpAddress(client_ip_address);
			requestBean.setExistingOrderBean(serviceBean);
			requestBean.setLocale(locale);
			
			Object argArray[]  = new Object[1];
			argArray[0] = requestBean;	


			Class [] paramArray	   = new Class[1];
			paramArray[0] = requestBean.getClass();
			
			responseBean=(PlaceNewOrderResponse) (busObj.getClass().getMethod("amendBLServ",paramArray)).invoke(busObj, argArray);
			
		}
		catch(Exception e){
			
		}
		return responseBean;
	}

	@SuppressWarnings("unchecked")
	private PlaceNewOrderResponse updateExistingOrder(HttpServletRequest req,
			HttpServletResponse res,String mode) {
		@SuppressWarnings("rawtypes")
		PlaceNewOrderResponse responseBean = null;
		try{
			serviceBean = (BLChargePatientExistingOrderBean) PersistenceHelper.getObjectFromBean(beanId, beanName, session);
			if ((getServletConfig().getServletContext().getInitParameter(
					"LOCAL_EJBS") != null)
					&& (getServletConfig().getServletContext()
							.getInitParameter("LOCAL_EJBS")
							.equalsIgnoreCase("TRUE"))) {
				local_ejbs = true;
			}
			

			Object home = ServiceLocator.getInstance().getHome(
					"java:comp/env/ChargePatientNewOrder",eBL.ChargePatientNewOrder.ChargePatientNewOrderHome.class, local_ejbs);
			Object busObj = (home.getClass().getMethod("create")).invoke(home);
			
			PlaceNewOrderRequest requestBean = new PlaceNewOrderRequest();
			requestBean.setFacilityId(facility_id);
			requestBean.setLoginUser(login_user);
			requestBean.setClientIpAddress(client_ip_address);
			requestBean.setExistingOrderBean(serviceBean);
			requestBean.setLocale(locale);
			
			Object argArray[]  = new Object[1];
			argArray[0] = requestBean;	


			Class [] paramArray	   = new Class[1];
			paramArray[0] = requestBean.getClass();
			
			responseBean=(PlaceNewOrderResponse) (busObj.getClass().getMethod(mode,paramArray)).invoke(busObj, argArray);									
			
		}
		catch(Exception e){
			System.err.println("Exception in Existing Order Servlet->"+e);
		}
		
		return responseBean;
		
	}

}
