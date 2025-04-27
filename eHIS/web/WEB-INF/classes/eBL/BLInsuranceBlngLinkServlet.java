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
import java.util.*;
import java.sql.*;
import webbeans.eCommon.ConnectionManager;
import webbeans.eCommon.*;


public class BLInsuranceBlngLinkServlet extends javax.servlet.http.HttpServlet
{
	PrintWriter out;
	java.util.Properties p;
	HashMap results;
	String facilityId="";
	String client_ip_address="";
	String login_user="";
	String locale="en";	
	HttpSession session;
	java.text.SimpleDateFormat dateFormat = new java.text.SimpleDateFormat( "yyyy-MM-dd" ) ;

	public void init(ServletConfig config) throws ServletException
	{
		System.out.println("Inside init method of servlet");
		super.init(config);
	}

	public synchronized void doPost(HttpServletRequest req, HttpServletResponse res) throws javax.servlet.ServletException,IOException
	{	
		
		System.out.println("Inside DoPost method of servlet");
		req.setCharacterEncoding("UTF-8");
		res.setContentType("text/html;charset=UTF-8");
		session = req.getSession(false);
		this.p = (java.util.Properties) session.getValue( "jdbc" ) ;
		facilityId = (String) session.getValue( "facility_id" ) ;
		client_ip_address = this.p.getProperty("client_ip_address");
		login_user = this.p.getProperty( "login_user" ) ;
		//String locale = this.p.getProperty("LOCALE") ;

		Connection connection = null;
		CallableStatement callIns = null;
		CallableStatement callUpd = null;

		try
		{

		 connection   =   ConnectionManager.getConnection(p);


		 callIns = connection.prepareCall("{ call blpayersfindtls.insert_payersprioritybybg (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
		 callUpd = connection.prepareCall("{ call blpayersfindtls.update_payersprioritybybg (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");


			this.out = res.getWriter();
			String operation = req.getParameter("mode");
			System.out.println("BLInsuranceBlngLinkServlet  mode "+operation);
			if ( operation.equals("insert"))   insert(req, res,callIns);
			if ( operation.equals("modify"))    modify(req, res,callUpd);

			connection.commit();
		}
		catch(Exception e)
		{
			out.println(e.toString());
			e.printStackTrace();
		}
		finally
		{
		if(connection !=null)  ConnectionManager.returnConnection(connection);
		}
	}

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws javax.servlet.ServletException,IOException{
		System.out.println("Inside Get method of servlet");
		doPost(req,res);
	}

	private void modify(HttpServletRequest req, HttpServletResponse res,CallableStatement callUpd)
	{
	try{		
		String operatingfacilityid=checkForNull(req.getParameter("facId_hid"));		
		//	String blnggrpid=checkForNull(req.getParameter("billingGrp"));
		String blnggrpid=checkForNull(req.getParameter("billingGrpCode"));	
		String custcode=checkForNull(req.getParameter("payerCode"));
		String patientclass = checkForNull(req.getParameter("patClass_hid"));
		String policytypecode = checkForNull(req.getParameter("policyTypeCode"));
		String priorityno = checkForNull(req.getParameter("prior_hid"));				
		String adjruleind	= null;
		String adjpercamtind = null; 
		String adjpercamtvalue = null; 
		String pmntdiffadjint	= null; 				
		String drgpmntdiffadjint = null; 
		String splsrvpmntdiffadjint = null; 
		String custgroupcode	= checkForNull(req.getParameter("payerGrpCode"));				
		String languageid = checkForNull(req.getParameter("locale"));
		String addedbyid = login_user;
		String addedfacilityid	= facilityId;
		String addedwsno	= client_ip_address;	
		String status = checkForNull(req.getParameter("status"));;
		if("on".equals(status) || "E".equals(status)){
			status = "E";
		}
		else{
			status = "D";
		}
		System.out.println("addedbyid/addedfacilityid/addedwsno"+addedbyid+"/"+addedfacilityid+"/"+addedwsno+"/"+status);
		System.out.println("facid/billid/cuscod/patclas/polcod/cusgrcod/lang/add_facId/priorityno>>>>"+operatingfacilityid+"/"+blnggrpid+"/"+custcode+"/"+patientclass+"/"+policytypecode+"/"+custgroupcode+"/"+languageid+"/"+addedfacilityid+"/"+priorityno);
		
		callUpd.setString(1,operatingfacilityid);
		callUpd.setString(2,blnggrpid);
		callUpd.setString(3,custcode);
		callUpd.setString(4,patientclass);
		callUpd.setString(5,policytypecode);
		callUpd.setString(6,priorityno);
		callUpd.setString(7,adjruleind);
		callUpd.setString(8,adjpercamtind);
		callUpd.setString(9,adjpercamtvalue);
		callUpd.setString(10,pmntdiffadjint);
		callUpd.setString(11,drgpmntdiffadjint);
		callUpd.setString(12,splsrvpmntdiffadjint);
		callUpd.setString(13,custgroupcode);
		callUpd.setString(14,status);
		callUpd.setString(15,languageid);
		callUpd.setString(16,addedbyid);
		callUpd.setString(17,addedfacilityid);
		callUpd.setString(18,addedwsno);

		callUpd.registerOutParameter(19,java.sql.Types.VARCHAR);       	
		callUpd.registerOutParameter(20,java.sql.Types.VARCHAR); 	
		callUpd.registerOutParameter(21,java.sql.Types.VARCHAR);
	
		callUpd.execute();	

		String str_error_level		=	callUpd.getString(19);
		String str_sysmesage_id	=	callUpd.getString(20);					
		String str_error_text		=	callUpd.getString(21);			
			
		str_sysmesage_id=str_sysmesage_id==null?"":str_sysmesage_id;
		str_error_level=str_error_level==null?"":str_error_level;
		str_error_text=str_error_text==null?"":str_error_text;
		String msg="";
		 if(!str_sysmesage_id.equals(""))
		 {
				Hashtable messageHashtable=new Hashtable();				
				StringTokenizer message_st = new StringTokenizer(str_sysmesage_id,"|");
				while(message_st.hasMoreTokens())
				{
					String sysMessageId = message_st.nextToken();
					messageHashtable=MessageManager.getMessage(locale,sysMessageId,"BL");
					msg=msg+(String)messageHashtable.get("message")+"<br>";
				}	   
			 }
			 if(!("".equals(str_error_level) && "".equals(str_error_text))){
				 msg=msg+str_error_text;
			 }
			
			 if(!("".equals(msg))){
				res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode( msg,"UTF-8" ) +"&err_value=2");
			 }
			 else		
				{
					Hashtable messageHashtable=new Hashtable();
					messageHashtable=MessageManager.getMessage(locale,"RECORD_INSERTED","SM");
					String success_msg=(String)messageHashtable.get("message");
					res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode( success_msg,"UTF-8" ) +"&err_value=1");
				}	 
		}
		catch ( Exception e ){
			out.println(" Exception raised ...So Record Not updatedFoll: Error Received : "+e.toString());
			e.printStackTrace();
			//out.println( "Values sent are : <br>" ) ;
		}finally{
			if(callUpd !=null){
				try {
					callUpd.close();
				} catch (SQLException e) {						
					e.printStackTrace();
				}
			}//commented checkstyle
		}
	}

	private void insert(HttpServletRequest req, HttpServletResponse res,CallableStatement callIns)
	{
		try{
				String operatingfacilityid=checkForNull(req.getParameter("facility"));		
			//	String blnggrpid=checkForNull(req.getParameter("billingGrp"));
				String blnggrpid=checkForNull(req.getParameter("billingGrpCode"));				
				String custcode=checkForNull(req.getParameter("payerCode"));
				String patientclass = checkForNull(req.getParameter("patient_class"));
				String policytypecode = checkForNull(req.getParameter("policyTypeCode"));
				String priorityno = checkForNull(req.getParameter("priority"));
				String adjruleind	= null; 
				String adjpercamtind = null; 
				String adjpercamtvalue = null; 
				String pmntdiffadjint	= null; 				
				String drgpmntdiffadjint = null; 
				String splsrvpmntdiffadjint = null; 
				String custgroupcode	= checkForNull(req.getParameter("payerGrpCode"));	
				String status = checkForNull(req.getParameter("status"));;
				if("on".equals(status) || "E".equals(status)){
					status = "E";
				}
				else{
					status = "D";
				}
				String languageid = checkForNull(req.getParameter("locale"));
				String addedbyid = login_user;
				String addedfacilityid	= facilityId;
				String addedwsno	= client_ip_address;
				
				System.out.println("addedbyid/addedfacilityid/addedwsno/status"+addedbyid+"/"+addedfacilityid+"/"+addedwsno+"/"+status);
				System.out.println("facid/billid/cuscod/patclas/polcod/cusgrcod/lang/add_fac/priorityno>>>>"+operatingfacilityid+"/"+blnggrpid+"/"+custcode+"/"+patientclass+"/"+policytypecode+"/"+custgroupcode+"/"+languageid+"/"+addedfacilityid+"/"+priorityno);
								
				callIns.setString(1,operatingfacilityid);
				callIns.setString(2,blnggrpid);
				callIns.setString(3,custcode);
				callIns.setString(4,patientclass);
				callIns.setString(5,policytypecode);
				callIns.setString(6,priorityno);
				callIns.setString(7,adjruleind);
				callIns.setString(8,adjpercamtind);
				callIns.setString(9,adjpercamtvalue);
				callIns.setString(10,pmntdiffadjint);
				callIns.setString(11,drgpmntdiffadjint);
				callIns.setString(12,splsrvpmntdiffadjint);
				callIns.setString(13,custgroupcode);
				callIns.setString(14,status);
				callIns.setString(15,languageid);
				callIns.setString(16,addedbyid);
				callIns.setString(17,addedfacilityid);
				callIns.setString(18,addedwsno);

				callIns.registerOutParameter(19,java.sql.Types.VARCHAR);       	
				callIns.registerOutParameter(20,java.sql.Types.VARCHAR); 	
				callIns.registerOutParameter(21,java.sql.Types.VARCHAR); 	

				callIns.execute();

				String str_error_level		=	callIns.getString(19);
				String str_sysmesage_id	=	callIns.getString(20);					
				String str_error_text		=	callIns.getString(21);
				
				str_sysmesage_id=str_sysmesage_id==null?"":str_sysmesage_id;
				str_error_level=str_error_level==null?"":str_error_level;
				str_error_text=str_error_text==null?"":str_error_text;

				String msg="";				
				 if(!str_sysmesage_id.equals(""))
				 {
						
					Hashtable messageHashtable=new Hashtable();
					
					StringTokenizer message_st = new StringTokenizer(str_sysmesage_id,"|");
					while(message_st.hasMoreTokens())
						{
							String sysMessageId = message_st.nextToken();
							messageHashtable=MessageManager.getMessage(locale,sysMessageId,"BL");
							msg=msg+(String)messageHashtable.get("message")+"<br>";
						}
				 }
				 if(!("".equals(str_error_level) && "".equals(str_error_text))){
					 msg=msg+str_error_text;
				 }
				
				 if(!("".equals(msg))){
					 res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode( msg,"UTF-8" ) +"&err_value=2");
				 }
				else
				{				
					Hashtable messageHashtable=new Hashtable();
					messageHashtable=MessageManager.getMessage(locale,"RECORD_INSERTED","SM");
					String success_msg=(String)messageHashtable.get("message");
					res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode( success_msg,"UTF-8" ) +"&err_value=1");
				}			
		}
		catch ( Exception e ){
			out.println(" Exception raised ...So Record Not insertedFoll: Error Received : "+e.toString());
			e.printStackTrace();
			//out.println( "Values sent are : <br>" ) ;
		}finally{
			if(callIns !=null){
				try {
					callIns.close();
				} catch (SQLException e) {						
					e.printStackTrace();
				}
			}//commented checkstyle
		}
	}

	private String checkForNull(String str){
		System.out.println("inside null check");
		return (str!=null && str.intern()!="null")?str:"";
	}

	private String checkForNull(String str,String defaultVal){
		System.out.println("inside null check");
		return (!checkForNull(str).equals(""))?str:defaultVal;
	}
}
