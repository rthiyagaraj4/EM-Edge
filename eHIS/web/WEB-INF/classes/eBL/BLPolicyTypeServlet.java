/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
/*
Sr No        Version           Incident        SCF/CRF             Developer Name
-----------------------------------------------------------------------------------
1            V200904            72977         NMC-JD-CRF-0059       Mohana Priya K
*/
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
import java.sql.Date;
import java.text.SimpleDateFormat;

public class BLPolicyTypeServlet extends javax.servlet.http.HttpServlet
{
	PrintWriter out;
	java.util.Properties p;
	HashMap results;
	String facilityId="";
	String client_ip_address="";
	String login_user="";
	String locale="";	
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
		locale=(String) session.getValue( "LOCALE" );
		Connection connection = null;
		CallableStatement callIns = null;
		CallableStatement callUpd = null;
		String site_spec=req.getParameter("sitespecval");

		try
		{
			connection   =   ConnectionManager.getConnection(p);

			callIns = connection.prepareCall("{ call  blpolicytypes.proc_ins_bl_policy_types(?,?,?,?,?,?,?,sysdate,?,?,?,?)}");
			callUpd = connection.prepareCall("{ call blpolicytypes.proc_upd_bl_policy_types(?,?,?,?,?,?,?,sysdate,?,?,?,?)}");

			this.out = res.getWriter();
			String operation = req.getParameter("mode");
			if ( operation.equals("insert"))   insert(req, res,callIns);
			if ( operation.equals("modify"))    modify(req, res,callUpd);
			connection.commit();
		}
		catch(Exception e)
		{
			e.printStackTrace();
			//out.println(e.toString());
		}
		finally
		{
			if(connection !=null)  ConnectionManager.returnConnection(connection);
		}
	}

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws javax.servlet.ServletException,IOException{
		doPost(req,res);
	}

	private void modify(HttpServletRequest req, HttpServletResponse res,CallableStatement callUpd)
	{
		try{		
				String policy_type_code=checkForNull(req.getParameter("policy_type_code1"));		
				String short_desc=checkForNull(req.getParameter("short_desc"));
				String long_desc=checkForNull(req.getParameter("long_desc"));
				String status = checkForNull(req.getParameter("status"),"D");
				String gosipolicy = checkForNull(req.getParameter("gosipolicy"),"N");

				callUpd.setString(1,facilityId);
				callUpd.setString(2,policy_type_code);
				callUpd.setString(3,long_desc);
				callUpd.setString(4,short_desc);
				callUpd.setString(5,status);
				callUpd.setString(6,gosipolicy);
				callUpd.setString(7,login_user);
				callUpd.setString(8,client_ip_address);

				callUpd.registerOutParameter(9,java.sql.Types.VARCHAR);       	
				callUpd.registerOutParameter(10,java.sql.Types.VARCHAR); 	
				callUpd.registerOutParameter(11,java.sql.Types.VARCHAR);

				callUpd.execute();	
				
				String str_error_level		=	callUpd.getString(9);
				String str_sysmesage_id		=	callUpd.getString(10);					
				String str_error_text		=	callUpd.getString(11);

				str_sysmesage_id=str_sysmesage_id==null?"":str_sysmesage_id;
				if(!str_sysmesage_id.equals(""))
				{
					Hashtable messageHashtable=new Hashtable();
					String msg="";
					StringTokenizer message_st = new StringTokenizer(str_sysmesage_id,"|");
					while(message_st.hasMoreTokens())
					{
						String sysMessageId = message_st.nextToken();
						messageHashtable=MessageManager.getMessage(locale,sysMessageId,"BL");
						msg=msg+(String)messageHashtable.get("message")+"<br>";
					}
					res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode( msg,"UTF-8" ) +"&err_value="+str_error_text);
				}else{
					Hashtable messageHashtable=new Hashtable();
					messageHashtable=MessageManager.getMessage(locale,"RECORD_INSERTED","SM");
					String success_msg=(String)messageHashtable.get("message");
					res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode( success_msg,"UTF-8" ) +"&err_value=1");
				}			 
			}catch ( Exception e ){
				e.printStackTrace();
				//out.println(" Exception raised ...So Record Not updatedFoll: Error Received : "+e.toString());
			}
	}

	private void insert(HttpServletRequest req, HttpServletResponse res,CallableStatement callIns)
	{
		try{
				String error_value="";
				String error="";
				boolean isUpdated=false;

				String policy_type_code=checkForNull(req.getParameter("policy_type_code"));		
				String short_desc=checkForNull(req.getParameter("short_desc"));
				String long_desc=checkForNull(req.getParameter("long_desc"));
				String status = checkForNull(req.getParameter("status"),"D");
				String gosipolicy = checkForNull(req.getParameter("gosipolicy"),"N"); 

				Connection connection = null;
				connection   =   ConnectionManager.getConnection(p);
				PreparedStatement pstmt1 = null;
				ResultSet rs = null;

				String sql="SELECT OPERATING_FACILITY_ID facility,LONG_DESC,SHORT_DESC,NVL(GOSI_YN,'N') GOSI_YN,NVL(status,'E') status1 FROM BL_INS_POLICY_TYPES where POLICY_TYPE_CODE ='"+policy_type_code+"' and OPERATING_FACILITY_ID='"+facilityId+"'";
				pstmt1 = connection.prepareStatement(sql);
				System.err.println("befre exec 1");
				rs=pstmt1.executeQuery();
				System.err.println("aftr exec 1");
				
				while(rs != null && rs.next()){
					error_value = "0" ;
					error = "App-BL0917 Duplicate Record Exists.";	
					isUpdated=true;
				}
			
				callIns.setString(1,facilityId);
				callIns.setString(2,policy_type_code);
				callIns.setString(3,long_desc);
				callIns.setString(4,short_desc);
				callIns.setString(5,status);
				callIns.setString(6,gosipolicy);
				callIns.setString(7,login_user);
				callIns.setString(8,client_ip_address);
				
				callIns.registerOutParameter(9,java.sql.Types.VARCHAR);       	
				callIns.registerOutParameter(10,java.sql.Types.VARCHAR); 	
				callIns.registerOutParameter(11,java.sql.Types.VARCHAR);	
				System.err.println("befr execute");
				callIns.execute();
				System.err.println("aftr execute");
				String str_error_level		=	callIns.getString(9);
				String str_sysmesage_id		=	callIns.getString(10);					
				String str_error_text		=	callIns.getString(11);				
				
				str_sysmesage_id=str_sysmesage_id==null?"":str_sysmesage_id;
					
				if(!str_sysmesage_id.equals(""))
				{						
					Hashtable messageHashtable=new Hashtable();
					String msg="";
					StringTokenizer message_st = new StringTokenizer(str_sysmesage_id,"|");
					while(message_st.hasMoreTokens())
					{
						String sysMessageId = message_st.nextToken();
						messageHashtable=MessageManager.getMessage(locale,sysMessageId,"BL");
						msg=msg+(String)messageHashtable.get("message")+"<br>";
					}
					res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode( msg,"UTF-8" ) +"&err_value="+str_error_text);
				}else if(isUpdated){
					res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode( error,"UTF-8" ) +"&err_value="+error_value);		
				}else{				
					Hashtable messageHashtable=new Hashtable();
					messageHashtable=MessageManager.getMessage(locale,"RECORD_INSERTED","SM");
					String success_msg=(String)messageHashtable.get("message");
					res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode( success_msg,"UTF-8" ) +"&err_value=1");
				}				
			}catch ( Exception e ){
				e.printStackTrace();
				//out.println(" Exception raised ...So Record Not insertedFoll: Error Received : "+e.toString());				
			}
	}

	private String checkForNull(String str){
		return (str!=null && str.intern()!="null")?str:"";
	}

	private String checkForNull(String str,String defaultVal){
		return (!checkForNull(str).equals(""))?str:defaultVal;
	}
}