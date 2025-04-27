package eBL;

import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ehis.eslp.ServiceLocator;
import com.ehis.persist.PersistenceHelper;

import eBL.placeorder.model.BLChargePatientNewOrderBean;
import eBL.placeorder.request.PlaceNewOrderRequest;
import eBL.placeorder.response.PlaceNewOrderResponse;

/**
 * This Servlet routes the Request from New Order Related Pages to EJB ChargePatientNewOrder.
 * Response Object is recieved by this Servlet.
 * Decides Whether Error occurred in Transaction.
 * Based on the Error Rsponse is redirected to BLExistingOrderMessage.jsp  
 * @author ravaradharajan
 *
 */
public class BLChargePatientNewOrderServlet extends HttpServlet {
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
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BLChargePatientNewOrderServlet() {
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
		PlaceNewOrderResponse responseBean = null;
		try{
			HttpSession session=req.getSession(false);
			locale = (String)session.getAttribute("LOCALE");
			loc = new Locale(locale);
			rb = ResourceBundle.getBundle("eSM.resources.Messages",loc);
			this.p = (java.util.Properties) session.getValue( "jdbc" ) ;
			login_user = this.p.getProperty( "login_user" ) ;
			boolean local_ejbs = false;
			//String mode = req.getParameter("mode"); //commented checkstyle
			mode = req.getParameter("mode");//Added checkstyle
			String locale = this.p.getProperty("LOCALE") ;
			facility_id = (String) session.getValue( "facility_id" ) ;
			client_ip_address = this.p.getProperty("client_ip_address") ;
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
			//HashMap results = new HashMap();//commented checkstyle
			
			//
			String beanId = "BLChargePatientNewOrderBean" ;
			String beanName = "eBL.placeorder.model.BLChargePatientExistingOrderBean";
			BLChargePatientNewOrderBean serviceBean = (BLChargePatientNewOrderBean)PersistenceHelper.getObjectFromBean(beanId, beanName, session) ;
			//
			PlaceNewOrderRequest requestBean = new PlaceNewOrderRequest();
			requestBean.setFacilityId(facility_id);
			requestBean.setLoginUser(login_user);
			requestBean.setClientIpAddress(client_ip_address);
			requestBean.setNewOrderBean(serviceBean);
			requestBean.setLocale(locale);
			
			Object argArray[]  = new Object[1];
			argArray[0] = requestBean;	


			Class [] paramArray	   = new Class[1];
			paramArray[0] = requestBean.getClass();
			
			responseBean=(PlaceNewOrderResponse) (busObj.getClass().getMethod("recordBLCharges",paramArray)).invoke(busObj, argArray);

			List<String> errorList = responseBean.getErrorList();

			
			
			StringBuffer consErrorText = new StringBuffer();
			String error = "";
			int err_val = 1;
			if(!errorList.isEmpty()){
				for (Iterator<String> iterator = errorList.iterator(); iterator.hasNext();) {
					err_val = 2;
					error = (String) iterator.next();
					consErrorText.append(error);
					consErrorText.append("<br/>");
				}
				error = consErrorText.toString();
			}
			
			
			if("".equals(error)){
				try{
					error = rb.getString("RECORD_INSERTED");
				}
				catch(Exception rbException){
					System.err.println("Exceprion in RB ->"+rbException);
					error = "APP-SM0070 Operation Completed Successfully ....";
				}
			}
			/*else{
				error = "Record not saved"+"<br/>"+error;
			}*/
			res.sendRedirect("../eBL/jsp/BLExistingOrderMessage.jsp?calledFrom=newOrder&err_num=" + java.net.URLEncoder.encode( error,"UTF-8" ) +"&err_value="+err_val);
			}
			catch(Exception e){
				System.err.println("Exception in CardSubscription Servlet->"+e);
			}
	}

}
