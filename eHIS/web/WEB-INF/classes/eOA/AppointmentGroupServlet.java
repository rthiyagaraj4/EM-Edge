/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eOA;


import javax.servlet.ServletException;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.sql.*;
import java.io.*;
import java.util.*;
import webbeans.eCommon.*;


public class AppointmentGroupServlet extends HttpServlet{
	PrintWriter out;	
	Properties p;
	
	String group_id ;              
	String group_name   ;           
	String locationtype ;           
	String b_loc_val;               
	String min_patient   ;         
	String max_patient;
	String eff_status;
	String blocation;
	
	String facilityId ;	
	String client_ip_address ;	
	Connection con;
	PreparedStatement pstmt;
	ResultSet rset;
	String locale="";
	String sql="";	
	
	HttpSession session;
	java.text.SimpleDateFormat dateFormat = new java.text.SimpleDateFormat( "yyyy-MM-dd" ) ;

	public synchronized void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException,IOException{
		session = req.getSession(false);		
		this.facilityId = (String) session.getValue( "facility_id" ) ;
		this.p = (java.util.Properties) session.getValue( "jdbc" ) ;
		this.client_ip_address = p.getProperty("client_ip_address");
		locale= p.getProperty("LOCALE");
		try{
				con=ConnectionManager.getConnection(req);
				res.setContentType("text/html");
				this.out = res.getWriter();
				String operation = req.getParameter("function_name");		
				if ( operation.equals("insert"))    insertCreateGroup(req, res);
				if ( operation.equals("modify"))   modifyCreateGroup(req, res);
			}catch(Exception e){
				out.println(e.toString());
				e.printStackTrace();
			}
	}
	private void insertCreateGroup(HttpServletRequest req, HttpServletResponse res)	{
		try
		{	
			group_id=req.getParameter("group_id");			
			group_name=req.getParameter("group_name");
			locationtype =req.getParameter("locationType");
			blocation=req.getParameter("blocation");
			min_patient =req.getParameter("min_patient"); System.out.println("min_patient==>"+min_patient);
			max_patient = req.getParameter("max_patient");System.out.println("max_patient==>"+max_patient);
			eff_status = req.getParameter("eff_status");			
			if ( eff_status == null )eff_status="D";
			String addedById = p.getProperty( "login_user" ) ;			
			String modifiedById = addedById ;
			String addedFacilityId=facilityId;
			String modifiedFacilityId = addedFacilityId ;
			String addedAtWorkstation=client_ip_address;
			String modifiedAtWorkstation = addedAtWorkstation ;	
			String error_msg = "" ;	
			int count=0;
			int result=0; 
			
			sql="select count(*) from OA_GROUP_HDR where group_id='"+group_id+"'";			

			pstmt = con.prepareStatement( sql );
			rset = pstmt.executeQuery();
			if(rset!=null && rset.next()){
				count=rset.getInt(1);
			}

			if(count != 0){
					 Hashtable message = MessageManager.getMessage(locale, "CODE_ALREADY_EXISTS","Common");
					 error_msg = (String)message.get("message");					
					 res.sendRedirect("../eCommon/jsp/error.jsp?err_num=" + java.net.URLEncoder.encode( error_msg,"UTF-8"));
					 message.clear();			
			}else{			
				if(pstmt !=null) pstmt.close();					
			   sql="insert into OA_GROUP_HDR(GROUP_ID,GROUP_NAME,LOCN_TYPE,LOCN_CODE,MAX_PATIENTS,MIN_PATIENTS,ADDED_BY_ID,ADDED_DATE,ADDED_AT_WS_NO,ADDED_FACILITY_ID,MODIFIED_BY_ID,MODIFIED_DATE,MODIFIED_AT_WS_NO,MODIFIED_FACILITY_ID,EFF_STATUS) values('"+group_id+"','"+group_name+"','"+locationtype+"','"+blocation+"','"+max_patient+"','"+min_patient+"','"+addedById+"',sysdate,'"+addedAtWorkstation+"','"+addedFacilityId+"','"+modifiedById+"',sysdate,'"+modifiedAtWorkstation+"','"+modifiedFacilityId+"','"+eff_status+"')";
	           System.out.println("sql===>"+sql);
				pstmt = con.prepareStatement( sql );
				result= pstmt.executeUpdate();							
					
				if ( result > 0 ){
					 con.commit();
					 Hashtable message = MessageManager.getMessage(locale, "RECORD_INSERTED","SM");
					 error_msg = (String)message.get("message");					 
					 res.sendRedirect("../eCommon/jsp/error.jsp?err_num=" + java.net.URLEncoder.encode( error_msg,"UTF-8") + "&err_value=1"  );
					 message.clear();
				}else{
					con.rollback();
					res.sendRedirect("../eCommon/jsp/error.jsp?err_num="+java.net.URLEncoder.encode( error_msg,"UTF-8" ) );
				}
			}			
				if(pstmt !=null) pstmt.close();
				if(rset !=null) rset.close();
	}catch(Exception e){
			out.println("<h3> Exception raise by Servlet ...So Record Not Inserted </h3> Foll: Error Received : "+e.toString());				
			e.printStackTrace();
	}finally{
			if(con !=null){
				ConnectionManager.returnConnection(con,p);
			}
		}
	}

	private void modifyCreateGroup(HttpServletRequest req, HttpServletResponse res)	{
		try{
			group_id=req.getParameter("group_id");			
			group_name=req.getParameter("group_name");
			locationtype =req.getParameter("locationType");
			blocation=req.getParameter("blocation");
			min_patient =req.getParameter("min_patient");
			max_patient = req.getParameter("max_patient");
			eff_status = req.getParameter("eff_status");			
			if ( eff_status == null )eff_status="D";
			
			System.out.println("group_id==>"+group_id);
			System.out.println("group_name==>"+group_name);
			System.out.println("locationtype==>"+locationtype);
			System.out.println("blocation==>"+blocation);
			System.out.println("min_patient==>"+min_patient);
			System.out.println("max_patient==>"+max_patient);
				
			String modifiedById =  p.getProperty( "login_user" ) ;						
			String modifiedFacilityId = facilityId ;			
			String modifiedAtWorkstation = client_ip_address ;
			String error_msg = "" ;
			int count=0;
			int result=0;	
					
			//	sql="update OA_GROUP_HDR set GROUP_NAME='"+group_name+"',LOCN_TYPE='"+locationtype+"',LOCN_CODE='"+blocation+"',MAX_PATIENTS='"+max_patient+"',MIN_PATIENTS='"+min_patient+"',MODIFIED_BY_ID='"+modifiedById+"',MODIFIED_DATE=sysdate,MODIFIED_AT_WS_NO='"+modifiedAtWorkstation+"',MODIFIED_FACILITY_ID='"+modifiedFacilityId+"' where GROUP_ID='"+group_id+"'";		
			
			sql="update OA_GROUP_HDR set MAX_PATIENTS='"+max_patient+"',MIN_PATIENTS='"+min_patient+"',MODIFIED_BY_ID='"+modifiedById+"',MODIFIED_DATE=sysdate,MODIFIED_AT_WS_NO='"+modifiedAtWorkstation+"',MODIFIED_FACILITY_ID='"+modifiedFacilityId+"',EFF_STATUS='"+eff_status+"' where GROUP_ID='"+group_id+"' and LOCN_CODE='"+blocation+"' ";
			
				System.out.println("Update====>"+sql);
				pstmt = con.prepareStatement( sql );				
				result= pstmt.executeUpdate();							
						
				if ( result > 0 ){
					 con.commit();
					 Hashtable message = MessageManager.getMessage(locale, "RECORD_INSERTED","SM");
					 error_msg = (String)message.get("message");					 
					 res.sendRedirect("../eCommon/jsp/error.jsp?err_num=" + java.net.URLEncoder.encode( error_msg,"UTF-8") + "&err_value=1"  );
					 message.clear();
				}else{
					con.rollback();
					res.sendRedirect("../eCommon/jsp/error.jsp?err_num="+java.net.URLEncoder.encode( error_msg,"UTF-8" ) );
				}
		
			
			if(pstmt !=null) pstmt.close();
			if(rset !=null) rset.close();

		}catch(Exception e){
			out.println("<h3> Exception raise by Servlet ...So Record Not Modified </h3> Foll: Error Received : "+e.toString());			
			e.printStackTrace();
		}finally{
			if(con !=null){
				ConnectionManager.returnConnection(con,p);
			}
		}
	}
}
