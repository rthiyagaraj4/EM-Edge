/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eMR;

import java.sql.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;
import javax.naming.*;
import javax.rmi.*;
import eCommon.SingleTableHandler.*;
import eCommon.SingleTabHandler.*;
import eCommon.Common.*;
import com.ehis.util.*;
import webbeans.eCommon.*;

public class MajorMedicalEventsServlet extends javax.servlet.http.HttpServlet
{

	Connection conn		= null;
	HttpSession session;
	PreparedStatement pstmt=null;
	PrintWriter out;
	Properties p;
	String addedById = "";
	String called_from	=	"";
	String client_ip_address ;
	String event_confirmed_flag ;
	String event_details ;
	String event_edate ;
	String event_sdate ;
	String facilityId ;
	String locale;
	String med_event_type_code;
	String modifiedAtWorkstation = "";
	String modifiedById = "";
	String modifiedFacilityId = "";
	String patient_id;
	int 	reslt = 0;
	java.sql.Date event_edate1 = null;
	java.sql.Date event_sdate1=null;

	public void init(ServletConfig config) throws ServletException
	{
		super.init(config);
	}

	public synchronized void doPost(HttpServletRequest req, HttpServletResponse res) throws javax.servlet.ServletException,IOException
	{
		req.setCharacterEncoding("UTF-8");
		session = req.getSession(false);
		this.facilityId = (String) session.getValue( "facility_id" ) ;
		this.p = (Properties) session.getValue( "jdbc" ) ;
		this.client_ip_address = p.getProperty("client_ip_address");
		locale = p.getProperty("LOCALE");
		try
		{
			res.setContentType("text/html;charset=UTF-8");
			this.out = res.getWriter();
			String operation = req.getParameter("mode");
			
			if ( operation.equals("insert") )   insert(req, res);
			if ( operation.equals("modify"))    datamodify(req, res);
		}
		catch(Exception e)
		{
			//out.println(e.toString());
			e.printStackTrace();
		}
	}

	private void datamodify(HttpServletRequest req, HttpServletResponse res)
	{
		
		
		try
		{
			conn = ConnectionManager.getConnection(req);
			conn.setAutoCommit(false);
			pstmt = conn.prepareStatement("update mr_med_event_log set event_edate=to_date(?,'dd/mm/yyyy'), event_details=? , event_confirmed_flag=?, MODIFIED_BY_ID = ?,MODIFIED_FACILITY_ID=?,MODIFIED_AT_WS_NO=?, modified_date=sysdate WHERE patient_id=? AND med_event_type_code=? AND event_sdate =to_date(?,'dd/mm/yyyy')");

			patient_id =req.getParameter("patient_id");
			med_event_type_code =req.getParameter("med_event_type_code1");

			event_sdate = req.getParameter("event_sdate");
			event_sdate = DateUtils.convertDate(event_sdate,"DMY",locale,"en");
			

			event_edate = req.getParameter("event_edate");
			if(event_edate==null) 
				event_edate="";
			event_edate = DateUtils.convertDate(event_edate,"DMY",locale,"en");
			

			event_details = req.getParameter("event_details");
			event_confirmed_flag = req.getParameter("confirmed");
			if ( event_confirmed_flag == null )
			event_confirmed_flag="N";
			called_from	=	(req.getParameter("called_from")==null)	?	""	:	req.getParameter("called_from");
			
			addedById = p.getProperty( "login_user" ) ;
			modifiedById = addedById ;
			String addedFacilityId=facilityId;
			modifiedFacilityId = addedFacilityId ;
			String addedAtWorkstation=client_ip_address;
			modifiedAtWorkstation = addedAtWorkstation ;
		

			pstmt.setString(1,event_edate);
			pstmt.setString(2,event_details);
			pstmt.setString(3,event_confirmed_flag);
			pstmt.setString(4,modifiedById);
			pstmt.setString(5,modifiedFacilityId);
			pstmt.setString(6,modifiedAtWorkstation);
			pstmt.setString(7,patient_id);
			pstmt.setString(8,med_event_type_code);
			pstmt.setString(9,event_sdate);


			reslt = pstmt.executeUpdate();
			
			String inserted = ( reslt != 0) ? "RECORD_MODIFIED" : "NOT_Modified";

			if ( pstmt != null)
			{
				pstmt.close();
			}
			
			java.util.Hashtable message = MessageManager.getMessage( locale, "RECORD_MODIFIED","SM" ) ;
			String error = (String) message.get("message");
			
			String error_value = "0" ;

			if (inserted.equals("RECORD_MODIFIED"))
			{					
				conn.commit();
				error_value="1";
				if(called_from.equals("CA"))
				{
					out.println("<script>var temp='update';parent.frames(1).frames(2).onSuccess(temp);</script>");
					res.sendRedirect("../eCA/jsp/CAError.jsp?err_num=" + java.net.URLEncoder.encode( error, "UTF-8" ) + "&err_value="+error_value);
				}
				else
				{
					res.sendRedirect("../eCommon/jsp/error.jsp?err_num=" + java.net.URLEncoder.encode( error, "UTF-8" ) + "&err_value="+error_value);
				}
			}
			else
			{
				conn.rollback();
			}

		}
		catch ( Exception e )
		{
			//out.println("<h3> Exception raise by Servlet ...So Record Not Modified </h3> Foll: Error Received : "+e.toString());
			e.printStackTrace();
		}
		finally{
			if ( conn != null)
			{
				ConnectionManager.returnConnection(conn,req);
			}
		}
	}
	
	private void insert(HttpServletRequest req, HttpServletResponse res)
	{
		
		try
		{
			patient_id =req.getParameter("patient_id");
			med_event_type_code =req.getParameter("med_event_type_code");
			event_sdate = req.getParameter("event_sdate");
			
			
			event_sdate = DateUtils.convertDate(event_sdate,"DMY",locale,"en");
			
			event_edate = req.getParameter("event_edate");



			if(event_edate==null) 
				event_edate="";

			event_edate = DateUtils.convertDate(event_edate,"DMY",locale,"en");
			
			event_details = req.getParameter("event_details");
			event_confirmed_flag = req.getParameter("confirmed");
			if ( event_confirmed_flag == null )
			event_confirmed_flag="N";
			called_from	=	(req.getParameter("called_from")==null)	?	""	:	req.getParameter("called_from");
			
			addedById = p.getProperty( "login_user" ) ;
			modifiedById = addedById ;
			String addedFacilityId=facilityId;
			modifiedFacilityId = addedFacilityId ;
			String addedAtWorkstation=client_ip_address;			
			modifiedAtWorkstation = addedAtWorkstation ;
			event_edate1 = null;
			if(!event_edate.equals(""))
			{
				StringTokenizer st = new StringTokenizer(event_edate,"/");
				String d1="";
				String d2="";
				String d3="";
				while(st.hasMoreTokens())
				{
					d1=st.nextToken();
					d2=st.nextToken();
					d3=st.nextToken();
				}
				String s=d3+"-"+d2+"-"+d1;
				event_edate1 = java.sql.Date.valueOf(s);
			}
			event_sdate1=null;
			if(!event_sdate.equals(""))
			{
				StringTokenizer st1 = new StringTokenizer(event_sdate,"/");
				String d11="";
				String d21="";
				String d31="";
				while(st1.hasMoreTokens())
				{
					d11=st1.nextToken();
					d21=st1.nextToken();
					d31=st1.nextToken();
				}
				
				String s1=d31+"-"+d21+"-"+d11;
				event_sdate1 = java.sql.Date.valueOf(s1);
			}

			HashMap tabdata=new HashMap();
			tabdata.put("patient_id",patient_id);
			tabdata.put("med_event_type_code",med_event_type_code);
			if(!event_sdate.equals(""))
			tabdata.put("event_sdate",event_sdate1);
			if(!event_edate.equals(""))
			tabdata.put("event_edate",event_edate1);
			tabdata.put("event_details",event_details);
			tabdata.put("event_confirmed_flag",event_confirmed_flag);
			tabdata.put("ADDED_BY_ID",addedById);
			tabdata.put("ADDED_DATE",new  java.sql.Timestamp(System.currentTimeMillis()));
			tabdata.put("ADDED_FACILITY_ID", facilityId);
			tabdata.put("ADDED_AT_WS_NO",addedAtWorkstation);
			tabdata.put("MODIFIED_BY_ID",modifiedById);
			tabdata.put("MODIFIED_DATE",new  java.sql.Timestamp(System.currentTimeMillis()));
			tabdata.put("MODIFIED_FACILITY_ID",modifiedFacilityId);
			tabdata.put("MODIFIED_AT_WS_NO",modifiedAtWorkstation );
			
		
			String dupflds[]={"patient_id","med_event_type_code","event_sdate"};

			String tableName = "MR_MED_EVENT_LOG";
			boolean local_ejbs = false;

			if ((getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS") !=null) &&(getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS").equalsIgnoreCase("TRUE"))) local_ejbs = true;

			Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome("java:comp/env/SingleTabHandler",SingleTabHandlerManagerHome.class,local_ejbs);
			Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);

			Object argArray[] = new Object[4];
			argArray[0] = p;
			argArray[1] = tabdata;
			argArray[2] = dupflds;
			argArray[3] = tableName;

			Class [] paramArray = new Class[4];
			paramArray[0] = p.getClass();
			paramArray[1] = tabdata.getClass();
			paramArray[2] = dupflds.getClass();
			paramArray[3] = tableName.getClass();

			HashMap results = (HashMap)(busObj.getClass().getMethod("insert",paramArray)).invoke(busObj,argArray);
			(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);

			boolean inserted	= ( ((Boolean) results.get( "status" )).booleanValue() ) ;


			String error = (String) results.get("error") ;
			String error_value = "0" ;
			if(inserted)
			{
				error_value = "1" ;
			}
			if(called_from.equals("CA"))
			{
				res.sendRedirect("../eCA/jsp/CAError.jsp?err_num=" + java.net.URLEncoder.encode( error, "UTF-8" ) + "&err_value="+error_value);
			}
			else
			{
				res.sendRedirect("../eCommon/jsp/error.jsp?err_num=" + java.net.URLEncoder.encode( error, "UTF-8" ) + "&err_value="+error_value);
			}
			if ( tabdata != null) tabdata.clear();
			if ( results != null) results.clear();
		}
		catch ( Exception e )
		{
			
			//out.println("<h3> Exception raise by Servlet ...So Record Not Modified </h3> Foll: Error Received : "+e.toString());
			
			e.printStackTrace();
		}
	}
}
