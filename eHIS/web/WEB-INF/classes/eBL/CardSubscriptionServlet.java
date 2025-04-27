/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eBL;

import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.ehis.eslp.ServiceLocator;
import eCommon.Common.CommonAdapter;





public class CardSubscriptionServlet extends javax.servlet.http.HttpServlet
{
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

	public void init(ServletConfig config) throws ServletException
	{
		super.init(config);
	}

	public synchronized void doPost(HttpServletRequest req, HttpServletResponse res) throws javax.servlet.ServletException,IOException
	{	
		try{
		HttpSession session=req.getSession(false);
		this.p = (java.util.Properties) session.getValue( "jdbc" ) ;
		login_user = this.p.getProperty( "login_user" ) ;
		boolean local_ejbs = false;
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
				"java:comp/env/PkgCardSubscription",eBL.PkgCardSubscription.PkgCardSubscriptionHome.class, local_ejbs);
		Object busObj = (home.getClass().getMethod("create")).invoke(home);
		HashMap<String,String> results = new HashMap<String,String>();
		HashMap<String,String> tabData = new HashMap<String,String>();
		
		tabData.put("patient_id", req.getParameter("patient_id"));
		tabData.put("card_type", req.getParameter("card_type"));
		tabData.put("effFrom", req.getParameter("effFrom"));
		tabData.put("addPatId", req.getParameter("addPatId"));
		tabData.put("facility_id", facility_id);
		tabData.put("login_user", login_user);
		tabData.put("client_ip_address", client_ip_address);
		Object argArray[]  = new Object[2];
		   argArray[0] = tabData;	
		   argArray[1] = p;

		Class [] paramArray	   = new Class[2];
			 paramArray[0] = tabData.getClass();
			 paramArray[1] = p.getClass();
		results=(HashMap<String,String>) (busObj.getClass().getMethod("insertCardSubscription",paramArray)).invoke(busObj, argArray);
		String error = "";
		String mapValue = "";
		int err_val = 1;
		for (Iterator iterator = results.keySet().iterator(); iterator.hasNext();) {
			String type = (String) iterator.next();
			mapValue = results.get(type);
			if(mapValue != null){
				//if(mapValue.contains("Error")){
					error = error+mapValue+"<br/>";
					err_val = 2;
				//}				
			}
		}
		if(error.length()==0){
			error = "Operation Completed Sucessfully";
		}
		else{
			error = "Record not saved"+"<br/>"+error;
		}
		res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode( error,"UTF-8" ) +"&err_value="+err_val);
		}
		catch(Exception e){
			System.err.println("Exception in CardSubscription Servlet->"+e);
		}

	}

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws javax.servlet.ServletException,IOException{
		doPost(req,res);
	}


	
}
