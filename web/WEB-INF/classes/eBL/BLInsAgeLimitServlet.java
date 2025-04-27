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
import eCommon.XSSRequestWrapper;

public class BLInsAgeLimitServlet extends javax.servlet.http.HttpServlet
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
		super.init(config);
	}

	public synchronized void doPost(HttpServletRequest req, HttpServletResponse res) throws javax.servlet.ServletException,IOException
	{	
		req.setCharacterEncoding("UTF-8");
		res.setContentType("text/html;charset=UTF-8");
		req= new XSSRequestWrapper(req);
		res.addHeader("X-XSS-Protection", "1; mode=block");
		res.addHeader("X-Content-Type-Options", "nosniff");
		
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
		 callIns = connection.prepareCall("{ call  blinspolicycoverage.insert_age_grp_for_policies (?,?,?,?,?,?,?,?,?,?,?,?,?)}");
		 callUpd = connection.prepareCall("{ call blinspolicycoverage.update_age_grp_for_policies(?,?,?,?,?,?,?,?,?,?,?,?,?)}");



			this.out = res.getWriter();
			String operation = req.getParameter("mode");
			System.out.println("BLInsAddLimitServlet  mode "+operation);
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
		doPost(req,res);
	}

	private void modify(HttpServletRequest req, HttpServletResponse res,CallableStatement callUpd)
	{
		try{
			String age_group_code=checkForNull(req.getParameter("code"));		
			String short_desc=checkForNull(req.getParameter("short_desc"));
			String long_desc=checkForNull(req.getParameter("long_desc"));
			String status = checkForNull(req.getParameter("status"),"D");

			String frmYear = checkForNull(req.getParameter("frmYear"));
			String frmMonth = checkForNull(req.getParameter("frmMonth"));
			String frmDay	= checkForNull(req.getParameter("frmDay"));

			String toYear = checkForNull(req.getParameter("toYear"));
			String toMonth = checkForNull(req.getParameter("toMonth"));
			String toDay	= checkForNull(req.getParameter("toDay"));

			callUpd.setString(1,age_group_code);
			callUpd.setString(2,long_desc);
			callUpd.setString(3,short_desc);
			callUpd.setString(4,frmYear);
			callUpd.setString(5,frmMonth);
			callUpd.setString(6,frmDay);
			callUpd.setString(7,toYear);
			callUpd.setString(8,toMonth);
			callUpd.setString(9,toDay);
			callUpd.setString(10,status);

			callUpd.registerOutParameter(11,java.sql.Types.VARCHAR);       	
			callUpd.registerOutParameter(12,java.sql.Types.VARCHAR); 	
			callUpd.registerOutParameter(13,java.sql.Types.VARCHAR);

			callUpd.execute();	

			//String str_error_level		=	callUpd.getString(11);
			String str_sysmesage_id	=	callUpd.getString(12);					
			String str_error_text		=	callUpd.getString(13);			
			
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
			}
			else
				
			{
				Hashtable messageHashtable=new Hashtable();
				messageHashtable=MessageManager.getMessage(locale,"RECORD_INSERTED","SM");
				String success_msg=(String)messageHashtable.get("message");
				res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode( success_msg,"UTF-8" ) +"&err_value=1");
			}
			 
									System.out.println("BLInsAddLimitServlet  inside Modify  after redirect");
		}
		catch ( Exception e ){
			out.println(" Exception raised ...So Record Not updatedFoll: Error Received : "+e.toString());
			e.printStackTrace();
			//out.println( "Values sent are : <br>" ) ;
		}
		finally{
			if(callUpd!=null){
				try {
					callUpd.close();
				} catch (SQLException e) {						
					e.printStackTrace();
				}
			}//Added for checkstyle
		}
	}



	private void insert(HttpServletRequest req, HttpServletResponse res,CallableStatement callIns)
	{
		try{



			String age_group_code=checkForNull(req.getParameter("code"));		
			String short_desc=checkForNull(req.getParameter("short_desc"));
			String long_desc=checkForNull(req.getParameter("long_desc"));
			String status = checkForNull(req.getParameter("status"),"D");

			String frmYear = checkForNull(req.getParameter("frmYear"));
			String frmMonth = checkForNull(req.getParameter("frmMonth"));
			String frmDay	= checkForNull(req.getParameter("frmDay"));

			String toYear = checkForNull(req.getParameter("toYear"));
			String toMonth = checkForNull(req.getParameter("toMonth"));
			String toDay	= checkForNull(req.getParameter("toDay"));




				callIns.setString(1,age_group_code);
				callIns.setString(2,long_desc);
				callIns.setString(3,short_desc);				
				callIns.setString(4,frmYear);
				callIns.setString(5,frmMonth);
				callIns.setString(6,frmDay);
				callIns.setString(7,toYear);
				callIns.setString(8,toMonth);
				callIns.setString(9,toDay);
				callIns.setString(10,status);

				callIns.registerOutParameter(11,java.sql.Types.VARCHAR);       	
				callIns.registerOutParameter(12,java.sql.Types.VARCHAR); 	
				callIns.registerOutParameter(13,java.sql.Types.VARCHAR); 	

				
				callIns.execute();	


				//String str_error_level		=	callIns.getString(11);
				String str_sysmesage_id	=	callIns.getString(12);					
				String str_error_text		=	callIns.getString(13);
				
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
			}
		   else
			{				
				Hashtable messageHashtable=new Hashtable();
				messageHashtable=MessageManager.getMessage(locale,"RECORD_INSERTED","SM");
				String success_msg=(String)messageHashtable.get("message");
				res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode( success_msg,"UTF-8" ) +"&err_value=1");
			}
			
				System.out.println("BLInsAddLimitServlet  inside insert  after sendRedirect");
		}
		catch ( Exception e ){
			out.println(" Exception raised ...So Record Not insertedFoll: Error Received : "+e.toString());
			e.printStackTrace();
			//out.println( "Values sent are : <br>" ) ;
		}finally{
			if(callIns!=null){
				try {
					callIns.close();
				} catch (SQLException e) {						
					e.printStackTrace();
				}
			} //Added for checkstyle
		}
	}

	private String checkForNull(String str){
		return (str!=null && str.intern()!="null")?str:"";
	}

	private String checkForNull(String str,String defaultVal){
		return (!checkForNull(str).equals(""))?str:defaultVal;
	}


}
