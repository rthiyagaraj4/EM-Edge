/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eBL;

import java.lang.reflect.Method;
import java.net.URLEncoder;
import javax.servlet.http.HttpSession;
import javax.servlet.ServletException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletRequest;
import java.io.PrintWriter;
import java.io.IOException;
import java.util.HashMap;
import javax.naming.InitialContext;
import javax.rmi.PortableRemoteObject;
import eCommon.SingleTabHandler.*;
import java.sql.*;
import webbeans.eCommon.*;


public class BLPatRegBlngDtlsServlet extends javax.servlet.http.HttpServlet
{
	PrintWriter out;
	java.util.Properties p;
	HashMap results;
	String facilityId="";
	String client_ip_address="";
	String login_user="";
//	String locale="";
	String slmt_ind="",adm_rec_flag="";
	String table_name="BL_MP_PAT_REGN_DTLS";
	HttpSession session;
	java.text.SimpleDateFormat dateFormat = new java.text.SimpleDateFormat( "yyyy-MM-dd" ) ;

	public void init(ServletConfig config) throws ServletException
	{
		super.init(config);
	}

	public synchronized void doPost(HttpServletRequest req, HttpServletResponse res) throws javax.servlet.ServletException,IOException
	{	
		req.setCharacterEncoding("UTF-8");
		res.setContentType("text/html;charset=UTF-8");
		session = req.getSession(false);
		this.p = (java.util.Properties) session.getValue( "jdbc" ) ;
		facilityId = (String) session.getValue( "facility_id" ) ;
		client_ip_address = this.p.getProperty("client_ip_address");
		login_user = this.p.getProperty( "login_user" ) ;
//		String locale = this.p.getProperty("LOCALE") ;
//		System.err.println("Check in Servlet 1:"+req.getParameter("mode"));
		try
		{
			this.out = res.getWriter();
			String operation = req.getParameter("mode");
			if ( operation.equals("insert"))
			{
//		System.err.println("Check in Servlet 2");
				insert(req, res);
			}
			else if ( operation.equals("modify"))
			{
//		System.err.println("Check in Servlet 3");
				modify(req, res);
			}
		}
		catch(Exception e)
		{
			out.println(e.toString());
		}
	}

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws javax.servlet.ServletException,IOException{
		doPost(req,res);
	}


	private HashMap populateTabData(HttpServletRequest req, HttpServletResponse res){
//		System.err.println("populateTabData Called");
		String mode = checkForNull(req.getParameter("mode"));
//		System.err.println("populateTabData Called mode:"+mode);
		HashMap tabdata=new HashMap();
		if("insert".equals(mode)){
			String facility_id=checkForNull(req.getParameter("facility_id"));
			String pat_ser_code=checkForNull(req.getParameter("pat_ser_code"));
			String blng_grp_code=checkForNull(req.getParameter("blng_grp_code"));
			String payer_grp_code = checkForNull(req.getParameter("payer_grp_code"));
			String payer_code = checkForNull(req.getParameter("payer_code"));
			String chargeble_yn = checkForNull(req.getParameter("chargeble_yn"),"N");
			String chargeble_dur_renwel = checkForNull(req.getParameter("chargeble_dur_renwel"),"N");
			if(chargeble_yn.equals("on"))
				chargeble_yn = "Y";
			else
				chargeble_yn = "N";
			String charge_non_chargeable_yn = checkForNull(req.getParameter("charge_non_chargeable_yn"),"N");
			if(charge_non_chargeable_yn.equals("on"))
				charge_non_chargeable_yn = "Y";
			else
				charge_non_chargeable_yn = "N";
			
			if(chargeble_dur_renwel.equals("on"))
				chargeble_dur_renwel = "Y";
			else
				chargeble_dur_renwel = "N";
			String serv_panel_ind = checkForNull(req.getParameter("serv_panel_ind"));
			String serv_panel_code = checkForNull(req.getParameter("serv_panel_code"));
			String renewal_code = checkForNull(req.getParameter("renewal_code"));//Added V190404-MuthuKN/AMRI-CRF-0357.1
			slmt_ind = checkForNull(req.getParameter("slmt_ind"));
			adm_rec_flag = checkForNull(req.getParameter("adm_rec_flag"));

			tabdata.put("FACILITY_ID",facility_id);
			tabdata.put("PAT_SER_GRP_CODE",pat_ser_code);
			tabdata.put("CHARGE_YN",chargeble_yn);
			tabdata.put("charge_PAT_RENEW_yn",chargeble_dur_renwel);
			tabdata.put("BLNG_GRP_ID",blng_grp_code);
			tabdata.put("CUST_GROUP_CODE",payer_grp_code);
			tabdata.put("CUST_CODE",payer_code);
			tabdata.put("CHARGE_AT_ENC_REGN",charge_non_chargeable_yn);
			tabdata.put("SERVICE_PANEL_IND",serv_panel_ind);
			tabdata.put("BLNG_SERV_CODE",serv_panel_code);
			tabdata.put("REN_BLNG_SERV_CODE",renewal_code);//Added V190404-MuthuKN/AMRI-CRF-0357.1
			tabdata.put("ADDED_BY_ID",login_user);
			tabdata.put("ADDED_DATE",new  java.sql.Timestamp(System.currentTimeMillis()));
			tabdata.put("MODIFIED_BY_ID",login_user);
			tabdata.put("MODIFIED_DATE",new  java.sql.Timestamp(System.currentTimeMillis()));
			tabdata.put("ADDED_AT_WS_NO",client_ip_address);
			tabdata.put("ADDED_FACILITY_ID", facilityId);
			tabdata.put("MODIFIED_AT_WS_NO",client_ip_address );
			tabdata.put("MODIFIED_FACILITY_ID",facilityId);
		}else if("modify".equals(mode)){

			String chargeble_yn = checkForNull(req.getParameter("chargeble_yn"),"N");
			if(chargeble_yn.equals("on"))
				chargeble_yn = "Y";
			else
				chargeble_yn = "N";
			String charge_non_chargeable_yn = checkForNull(req.getParameter("charge_non_chargeable_yn"),"N");
			if(charge_non_chargeable_yn.equals("on"))
				charge_non_chargeable_yn = "Y";
			else
				charge_non_chargeable_yn = "N";
			String serv_panel_ind = checkForNull(req.getParameter("serv_panel_ind"));
			String serv_panel_code = checkForNull(req.getParameter("serv_panel_code"));
			String renewal_code = checkForNull(req.getParameter("renewal_code"));//Added V190404-MuthuKN/AMRI-CRF-0357.1
			slmt_ind = checkForNull(req.getParameter("slmt_ind"));
			adm_rec_flag = checkForNull(req.getParameter("adm_rec_flag"));

			//Added V190401-MuthuKumarN/IN70056 & IN:070057
			String chargeble_dur_renwel = checkForNull(req.getParameter("chargeble_dur_renwel"),"N");
			if(chargeble_dur_renwel.equals("on"))
				chargeble_dur_renwel = "Y";
			else
				chargeble_dur_renwel = "N";
			//Added V190401-MuthuKumarN/IN70056 & IN:070057

			tabdata.put("CHARGE_YN",chargeble_yn);
			tabdata.put("CHARGE_AT_ENC_REGN",charge_non_chargeable_yn);
			tabdata.put("charge_PAT_RENEW_yn",chargeble_dur_renwel);
			tabdata.put("SERVICE_PANEL_IND",serv_panel_ind);
			tabdata.put("BLNG_SERV_CODE",serv_panel_code);
			tabdata.put("REN_BLNG_SERV_CODE",renewal_code);//Added V190404-MuthuKN/AMRI-CRF-0357.1
			tabdata.put("MODIFIED_BY_ID",login_user);
			tabdata.put("MODIFIED_DATE",new  java.sql.Timestamp(System.currentTimeMillis()));
			tabdata.put("MODIFIED_AT_WS_NO",client_ip_address );
			tabdata.put("MODIFIED_FACILITY_ID",facilityId);
		}
//		System.err.println("populateTabData Called tabdata:"+tabdata);
		return tabdata;
	}

	private Object getRemoteObject(){
		boolean local_ejbs = isLocalEJB();
		Object busObj=null;
		try{
			//Object home =com.medicom.ESLP.ServiceLocator.getInstance().getHome("java:comp/env/SingleTabHandler",SingleTabHandlerManagerHome.class,local_ejbs);
			Object home =com.ehis.eslp.ServiceLocator.getInstance().getHome("java:comp/env/SingleTabHandler",SingleTabHandlerManagerHome.class,local_ejbs);
			//Get the remote object by invoking create method on the home object using reflection
			busObj =	(home.getClass().getMethod("create",null)).invoke(home,null);
		}catch(Exception e){
				//out.println(e.toString());
				e.printStackTrace();
		}
		return busObj;
			
	}


	private void modify(HttpServletRequest req, HttpServletResponse res){
		//String oper_group_code=checkForNull(req.getParameter("oper_group_code1"));
		//String oper_cat_code=checkForNull(req.getParameter("oper_cat_code1"));
//		System.err.println("Inside Modify Mode");
		HashMap tabData = populateTabData(req,res);
//		System.err.println("Inside Modify Mode:"+tabData);
		HashMap condflds=new HashMap();

		if(slmt_ind.equals("C"))
		{
			condflds.put("FACILITY_ID",checkForNull(req.getParameter("facility_id1")));
			condflds.put("PAT_SER_GRP_CODE",checkForNull(req.getParameter("pat_ser_grp_code1")));
			condflds.put("BLNG_GRP_ID",checkForNull(req.getParameter("blng_grp_id1")));
		}
		else
		{
			condflds.put("FACILITY_ID",checkForNull(req.getParameter("facility_id1")));
			condflds.put("PAT_SER_GRP_CODE",checkForNull(req.getParameter("pat_ser_grp_code1")));
			condflds.put("BLNG_GRP_ID",checkForNull(req.getParameter("blng_grp_id1")));
	        condflds.put("CUST_GROUP_CODE",checkForNull(req.getParameter("cust_group_code1")));
		    condflds.put("CUST_CODE",checkForNull(req.getParameter("cust_code1")));
		}
		
//		System.err.println("condflds in modify:"+condflds);
//		System.err.println("table_name in modify:"+table_name);
		
		Object argArray[]  = new Object[4];
		argArray[0] = p;
		argArray[1] = tabData;				   
		argArray[2] = condflds;
		argArray[3] = table_name;
		Class [] paramArray	   = new Class[4];
		paramArray[0] = p.getClass();
		paramArray[1] = tabData.getClass();
		paramArray[2] = condflds.getClass();
		paramArray[3] = table_name.getClass();

		try{   
			Object busObj = getRemoteObject();
			results =(HashMap)(busObj.getClass().getMethod("update",paramArray)).invoke(busObj,argArray);
			boolean inserted = ( ((Boolean) results.get( "status" )).booleanValue() ) ;
//			System.err.println("inserted:"+inserted);
			String error = (String) results.get("error") ;
//			System.err.println("error:"+error);
			String error_value = "0" ;
			if ( inserted ){
				error_value = "1" ;
			}else{
				error = (String) results.get("error") ;
			}
//			System.err.println("error_value:"+error_value);
       		error = (String) results.get("error") ;
			    res.sendRedirect("../eCommon/jsp/error.jsp?err_num=" + java.net.URLEncoder.encode( error,"UTF-8" ) +"&err_value="+error_value);
		}
		catch ( Exception e ){
			//out.println("<h3> Exception raised by Servlet ...So Record Not Modified </h3> Foll: Error Received : "+e.toString());
			//out.println( "Values sent are : <br>" ) ;
			//out.println( oper_group_code+" "+oper_cat_code);
			e.printStackTrace();
		}
	}

	private void insert(HttpServletRequest req, HttpServletResponse res)
	{
//		System.err.println("Insert 1");
		HashMap tabData = populateTabData(req,res);
//		Connection con=ConnectionManager.getConnection(p);
//				System.err.println("Insert 2");
		String dupflds[] = new String[3];
		String dupflds1[] = new String[5];
//		System.err.println("Insert 3");
		if(slmt_ind.equals("C"))
		{
			dupflds[0]="FACILITY_ID";
			dupflds[1]="PAT_SER_GRP_CODE";
			dupflds[2]="BLNG_GRP_ID";
//		System.err.println("Insert 3.1");
		}
		else
		{
			dupflds1[0]="FACILITY_ID";
			dupflds1[1]="PAT_SER_GRP_CODE";
			dupflds1[2]="BLNG_GRP_ID";
			dupflds1[3]="CUST_GROUP_CODE";
			dupflds1[4]="CUST_CODE";
//		System.err.println("Insert 3.2");
		}
//		System.err.println("Insert 4");
		Object argArray[]  = new Object[4];
//		System.err.println("Insert 5");
		argArray[0] = p;
		argArray[1] = tabData;
		if(slmt_ind.equals("C"))
		{
			argArray[2] = dupflds;
		}
		else
		{
			argArray[2] = dupflds1;
		}
		argArray[3] = table_name;

//		System.err.println("tabData:"+tabData);
//		System.err.println("dupflds:"+dupflds);
//		System.err.println("table_name:"+table_name);

		Class [] paramArray	   = new Class[4];
		paramArray[0] = p.getClass();
		paramArray[1] = tabData.getClass();
		paramArray[2] = dupflds.getClass();
		paramArray[3] = table_name.getClass();

		try{
				Object busObj =	getRemoteObject();
				results =(HashMap)(busObj.getClass().getMethod("insert",paramArray)).invoke(busObj,argArray);
				(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);
				boolean inserted = ( ((Boolean) results.get( "status" )).booleanValue() ) ;
				String error = (String) results.get("error") ;
				String error_value = "0" ;
				if ( inserted ){
					 error_value = "1" ;
				}else{
					 error = (String) results.get("error") ;
				}
			    error = (String) results.get("error") ;
			    res.sendRedirect("../eCommon/jsp/error.jsp?err_num=" + java.net.URLEncoder.encode( error,"UTF-8" ) +"&err_value="+error_value);
		}
		catch ( Exception e ){
			e.printStackTrace();
			//out.println(" Exception raised ...So Record Not insertedFoll: Error Received : "+e.toString());
			//out.println( "Values sent are : <br>" ) ;
		}
		
	}

	private String checkForNull(String str){
		return (str!=null && str.intern()!="null")?str:"";
	}

	private String checkForNull(String str,String defaultVal){
		return (!checkForNull(str).equals(""))?str:defaultVal;
	}

	private boolean isLocalEJB(){
		ServletContext servletcontext = getServletConfig().getServletContext();
		if ((servletcontext.getInitParameter("LOCAL_EJBS")!=null) &&(servletcontext.getInitParameter("LOCAL_EJBS").equalsIgnoreCase("TRUE"))) 
			return true;
			return false;
	}
}
