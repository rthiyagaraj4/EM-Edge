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
import java.net.*;
import javax.servlet.http.HttpSession;
import javax.servlet.ServletException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletRequest;
import java.io.PrintWriter;
import java.io.IOException;
import java.util.*;
import java.util.StringTokenizer;
import javax.naming.InitialContext;
import javax.rmi.PortableRemoteObject;
import eBL.*;	 
import com.ehis.persist.*;
import java.sql.*;
import webbeans.eCommon.*;
import java.util.ArrayList ;
import eCommon.Common.*;
import com.ehis.eslp.ServiceLocator;




public class BLCashChequeHandOverServlet extends javax.servlet.http.HttpServlet
{
	PrintWriter out;
	java.util.Properties p;
	HashMap results;
	String facilityId="";
	String client_ip_address="";
	String login_user="";
	String slmt_ind="",adm_rec_flag="";
	String locale = "";
	HashMap tabdata=null;
	HttpSession session;
	String mode="";
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
		locale = this.p.getProperty("LOCALE") ;
	//	System.out.println("Check in Servlet 1:"+req.getParameter("mode"));
	//System.out.println("Check incashHandOver 1:");
		try
		{
			this.out = res.getWriter();			
			String operation = req.getParameter("mode");	
			//System.out.println("operation :"+operation);
			//insertData(req, res);

			if ( operation.equals("insert") || operation.equals("modify"))
			{
				//System.out.println("Check in Servlet operation 1");
				insertData(req, res);
			}
			else if ( operation.equals("delete"))
			{
				//System.out.println("Check in Servlet operation 2");
				removeData(req, res);
			}
					
			
		}
		catch(Exception e)
		{
			out.println(e.toString());
			System.out.println("main ex"+e.toString());
		}
	}

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws javax.servlet.ServletException,IOException{
		doPost(req,res);
	}




	private void insertData(HttpServletRequest req,HttpServletResponse res)
	{
		try 
		{	
			tabdata=new HashMap();
			//java.util.Locale loc = new java.util.Locale(locale);		
			tabdata = populateTabData(req,res);			
			
			boolean local_ejbs = false;
			//System.out.println("ejb call 0");
			if ((getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS") != null) && (getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS").equalsIgnoreCase("TRUE")))
				local_ejbs = true;
			//System.out.println("ejb call 1");
			Object home =ServiceLocator.getInstance().getHome("java:comp/env/CashChequeHandOver",eBL.CashChequeHandOver.CashChequeHandOverLocalHome.class, local_ejbs);	
			//System.out.println("ejb call 2");

			Object busObj = (home.getClass().getMethod("create",null)).invoke(home, null);
			//System.out.println("ejb call 3");

			Object argArray[] = new Object[2];

			//System.out.println("ejb call 4");
					
			argArray[0] = p;
			argArray[1] = tabdata;
			
			
			//System.out.println("ejb call 5");
			Class[] paramArray = new Class[2];

			paramArray[0] = p.getClass();
			paramArray[1] = tabdata.getClass();	
			
			

			java.util.HashMap results = (java.util.HashMap) (busObj.getClass().getMethod("insert", paramArray)).invoke(busObj, argArray);	
			(busObj.getClass().getMethod("remove", null)).invoke(busObj, null);
			//System.out.println("ejb results :"+results);

			boolean inserted = (((Boolean) results.get("status")).booleanValue());
			//System.out.println("ejb inserted :"+inserted);
			String error = (String) results.get("error");
			//System.out.println("ejb error :"+error);
			String message = (String) results.get("message");
			//System.out.println("ejb message :"+message);
			String sys_error = (String) results.get("sys_error");
			//System.out.println("ejb sys_error :"+sys_error);
			String error_value="0";			
			
			if(inserted)
			{				
				error_value = "1" ;		
				
				Hashtable messageHashtable=new Hashtable();
				messageHashtable=MessageManager.getMessage(locale,"RECORD_INSERTED","SM");
				String success_msg=(String)messageHashtable.get("message");		
				res.sendRedirect("../eCommon/jsp/error.jsp?err_num=" + java.net.URLEncoder.encode( success_msg,"UTF-8" ) +"&err_value="+error_value);
			}
			else
			{				
				if(!sys_error.equals(""))
				{
					res.sendRedirect("../eCommon/jsp/error.jsp?err_num=" + java.net.URLEncoder.encode( sys_error.toString(),"UTF-8" ) +"&err_value="+error_value);
				}
				else if(!message.equals(""))
				{
					
					Hashtable messageHashtable=new Hashtable();
					String msg="";
					StringTokenizer message_st = new StringTokenizer(message,"|");
					while(message_st.hasMoreTokens())
						{
							String sysMessageId = message_st.nextToken();					
							messageHashtable=MessageManager.getMessage(locale,sysMessageId,"BL");
							msg=msg+(String)messageHashtable.get("message")+"<br>";							
						}						
					

					res.sendRedirect("../eCommon/jsp/error.jsp?err_num=" + java.net.URLEncoder.encode( msg,"UTF-8" ) +"&err_value="+error_value);

					
							
			
				}
				else if(!error.equals(""))
				{						
					res.sendRedirect("../eCommon/jsp/error.jsp?err_num=" + java.net.URLEncoder.encode( error,"UTF-8" ) +"&err_value="+error_value);
				}	 			
			} 
			

			 
		}
		catch (Exception e) 
		{
			//con.rollback();
			System.out.println("exception in main=" + e.toString());
			e.printStackTrace();
			out.println("<h3> Exception raise by Servlet ...So Record Not inserted </h3> Foll: Error Received : "
							+ e.toString() );
			out.println("Values sent are : <br>");
		} 

	}

	private HashMap populateTabData(HttpServletRequest req, HttpServletResponse res){
		//System.out.println("inside Pooulatedatesdsda");

		String bean_id		= "BLCashChequeHandOverBean" ;
		String bean_name	= "eBL.BLCashChequeHandOverBean";
		BLCashChequeHandOverBean bean			= (BLCashChequeHandOverBean)PersistenceHelper.getBeanObject( bean_id, bean_name, req ) ;
		HashMap cashCollectionDtls = bean.getCashCollectionDtls();
		HashMap chequeCollectionDtls = bean.getChequeCollectionDtls();	
		String tot_cash_amt =  bean.getTotCashAmt();	
		String tot_chk_amt  =  bean.getTotChequeAmt();	
		String loginDateTime  = checkForNull(req.getParameter("loginDateTime"));
		//System.out.println("loginDateTime Called loginDateTime:"+loginDateTime);

		String reqDateTime  = checkForNull(req.getParameter("reqDateTime"));
		//System.out.println("reqDateTime Called reqDateTime:"+reqDateTime);

		String cashInHand  = checkForNull(req.getParameter("cashInHand"));
		String chequeInHand  = checkForNull(req.getParameter("chequeInHand"));
		String cashCounterCode  = checkForNull(req.getParameter("cashCounterCode"));
		String inUseBy  = checkForNull(req.getParameter("inUseBy"));

			loginDateTime = com.ehis.util.DateUtils.convertDate(loginDateTime,"DMYHMS",locale,"en");
					//System.out.println("loginDateTime Called loginDateTime conv:"+loginDateTime);

			reqDateTime = com.ehis.util.DateUtils.convertDate(reqDateTime,"DMYHMS",locale,"en");
					//System.out.println("reqDateTime Called reqDateTime conv:"+reqDateTime);

		String mode  = checkForNull(req.getParameter("mode"));
		//System.out.println("mode Called serv mode :"+mode);

		String handoverrequestamt  = checkForNull(req.getParameter("handoverrequestamt"));
		//System.out.println("handoverrequestamt Called serv handoverrequestamt :"+handoverrequestamt);



		 
		tabdata.put("FACILITY_ID",facilityId);
		tabdata.put("loginDateTime",loginDateTime);
		tabdata.put("reqDateTime",reqDateTime);
		tabdata.put("cashInHand",cashInHand);
		tabdata.put("chequeInHand",chequeInHand);
		tabdata.put("CASH_COLL_DTLS_SER",cashCollectionDtls);
		tabdata.put("CHEQUE_COLL_DTLS_SER",chequeCollectionDtls);
		tabdata.put("cashCounterCode",cashCounterCode);
		tabdata.put("inUseBy",inUseBy);
		tabdata.put("client_ip_address",client_ip_address);
		tabdata.put("tot_cash_amt",tot_cash_amt);
		tabdata.put("tot_chk_amt",tot_chk_amt);
		tabdata.put("mode",mode);
		tabdata.put("handoverrequestamt",handoverrequestamt);
		tabdata.put("locale",locale);

			
		
		//System.out.println("populateTabData Called tabdata:"+tabdata);
		return tabdata;	
	

	}	

	private void removeData(HttpServletRequest req,HttpServletResponse res)
	{
		try 
		{	
			tabdata=new HashMap();
			//java.util.Locale loc = new java.util.Locale(locale);		
			tabdata = deleteTabData(req,res);			
			
			boolean local_ejbs = false;
			//System.out.println("ejb call 0");
			if ((getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS") != null) && (getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS").equalsIgnoreCase("TRUE")))
				local_ejbs = true;
			//System.out.println("ejb call 1");
			Object home =ServiceLocator.getInstance().getHome("java:comp/env/CashChequeHandOver",eBL.CashChequeHandOver.CashChequeHandOverLocalHome.class, local_ejbs);	
			//System.out.println("ejb call 2");

			Object busObj = (home.getClass().getMethod("create",null)).invoke(home, null);
			//System.out.println("ejb call 3");

			Object argArray[] = new Object[2];

			//System.out.println("ejb call 4");
					
			argArray[0] = p;
			argArray[1] = tabdata;
			
			
			//System.out.println("ejb call 5");
			Class[] paramArray = new Class[2];

			paramArray[0] = p.getClass();
			paramArray[1] = tabdata.getClass();	
			
			

			java.util.HashMap results = (java.util.HashMap) (busObj.getClass().getMethod("modify", paramArray)).invoke(busObj, argArray);	
			(busObj.getClass().getMethod("remove", null)).invoke(busObj, null);
			//System.out.println("ejb results :"+results);

			boolean inserted = (((Boolean) results.get("status")).booleanValue());
			//System.out.println("ejb inserted :"+inserted);
			String error = (String) results.get("error");
			//System.out.println("ejb error :"+error);
			String message = (String) results.get("message");
			//System.out.println("ejb message :"+message);
			String sys_error = (String) results.get("sys_error");
			//System.out.println("ejb sys_error :"+sys_error);
			String error_value="0";			
			
			if(inserted)
			{				
				error_value = "1" ;		
				
				Hashtable messageHashtable=new Hashtable();
				messageHashtable=MessageManager.getMessage(locale,"RECORD_INSERTED","SM");
				String success_msg=(String)messageHashtable.get("message");		
				res.sendRedirect("../eCommon/jsp/error.jsp?err_num=" + java.net.URLEncoder.encode( success_msg,"UTF-8" ) +"&err_value="+error_value);
			}
			else
			{				
				if(!sys_error.equals(""))
				{
					res.sendRedirect("../eCommon/jsp/error.jsp?err_num=" + java.net.URLEncoder.encode( sys_error.toString(),"UTF-8" ) +"&err_value="+error_value);
				}
				else if(!message.equals(""))
				{
					
					Hashtable messageHashtable=new Hashtable();
					String msg="";
					StringTokenizer message_st = new StringTokenizer(message,"|");
					while(message_st.hasMoreTokens())
						{
							String sysMessageId = message_st.nextToken();					
							messageHashtable=MessageManager.getMessage(locale,sysMessageId,"BL");
							msg=msg+(String)messageHashtable.get("message")+"<br>";							
						}						
					

					res.sendRedirect("../eCommon/jsp/error.jsp?err_num=" + java.net.URLEncoder.encode( msg,"UTF-8" ) +"&err_value="+error_value);

					
							
			
				}
				else if(!error.equals(""))
				{						
					res.sendRedirect("../eCommon/jsp/error.jsp?err_num=" + java.net.URLEncoder.encode( error,"UTF-8" ) +"&err_value="+error_value);
				}	 			
			} 
			

			 
		} catch (Exception e) 
		{
			//con.rollback();
			System.out.println("exception in main=" + e.toString());
			e.printStackTrace();
			out.println("<h3> Exception raise by Servlet ...So Record Not inserted </h3> Foll: Error Received : "
							+ e.toString() );
			out.println("Values sent are : <br>");
		} 

	}
private HashMap deleteTabData(HttpServletRequest req, HttpServletResponse res){
		//System.out.println("inside deleteData");

		
		String loginDateTime  = checkForNull(req.getParameter("loginDateTime"));
		//System.out.println("loginDateTime Called loginDateTime:"+loginDateTime);
		String reqDateTime  = checkForNull(req.getParameter("reqDateTime"));
		//System.out.println("reqDateTime Called reqDateTime:"+reqDateTime);		
		String cashCounterCode  = checkForNull(req.getParameter("cashCounterCode"));
		String inUseBy  = checkForNull(req.getParameter("inUseBy"));

			loginDateTime = com.ehis.util.DateUtils.convertDate(loginDateTime,"DMYHMS",locale,"en");
					//System.out.println("loginDateTime Called loginDateTime conv:"+loginDateTime);

			reqDateTime = com.ehis.util.DateUtils.convertDate(reqDateTime,"DMYHMS",locale,"en");
					//System.out.println("reqDateTime Called reqDateTime conv:"+reqDateTime);

		String mode  = checkForNull(req.getParameter("mode"));
		//System.out.println("mode Called serv mode :"+mode);
		


		 
		tabdata.put("FACILITY_ID",facilityId);
		tabdata.put("loginDateTime",loginDateTime);
		tabdata.put("reqDateTime",reqDateTime);	
		tabdata.put("cashCounterCode",cashCounterCode);
		tabdata.put("inUseBy",inUseBy);
		tabdata.put("client_ip_address",client_ip_address);		
		tabdata.put("mode",mode);		
		tabdata.put("locale",locale);		
			
		
		//System.out.println("deleteTabData Called tabdata:"+tabdata);
		return tabdata;	

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
