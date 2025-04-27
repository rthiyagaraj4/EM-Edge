/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eAM;
import java.sql.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;
import javax.naming.*;
import javax.rmi.*;
import java.util.*;
import webbeans.eCommon.*;
import eCommon.XSSRequestWrapper;

public class OPPFServlet extends javax.servlet.http.HttpServlet
{
	PrintWriter out;
	
	String primary_specialty="";
	String totAssignreassign="", effStatus="",finalSelect="";
	java.util.Properties p;
	String facility;
	String facilityId ;
	String client_ip_address ;
	String locale="";
	//String serviceURL;
	//String objectName;
	HttpSession session;
	
	 Connection con;
	 PreparedStatement pslPrepStmt;
	 PreparedStatement delStmt;
	//java.text.SimpleDateFormat dateFormat = new java.text.SimpleDateFormat( "yyyy-MM-dd" ) ;

	public void init(ServletConfig config) throws ServletException
	{
		super.init(config);
	}

	public synchronized void doPost(HttpServletRequest req, HttpServletResponse res) throws javax.servlet.ServletException,IOException
	{
		//MMS-ME-SCF-0096 vulnerability Issue 
		req= new XSSRequestWrapper(req);
		res.addHeader("X-XSS-Protection", "1; mode=block");
		res.addHeader("X-Content-Type-Options", "nosniff");
		//MMS-ME-SCF-0096 vulnerability Issue
		session = req.getSession(false);		
		this.facilityId = (String) session.getValue( "facility_id" ) ;
		this.p = (java.util.Properties) session.getValue( "jdbc" ) ;
		this.client_ip_address = p.getProperty("client_ip_address");
		 locale= p.getProperty("LOCALE");

		try
		{
			con = ConnectionManager.getConnection(req);
			res.setContentType("text/html");
			this.out = res.getWriter();
			String operation = req.getParameter("function_name");
			if ( operation.equals("insert") )   insertOPPF(req, res);


		}
		catch(Exception e)
		{
			e.printStackTrace();
			out.println(e.toString());
		}
		finally
		        {
		            ConnectionManager.returnConnection(con, req);
        		}
	}



private void insertOPPF(HttpServletRequest req, HttpServletResponse res)
	{
		try
		{
				String addedById = p.getProperty( "login_user" ) ;
				String modifiedById = addedById ;
				String addedFacilityId=facilityId;
				String modifiedFacilityId = addedFacilityId ;
				String addedAtWorkstation=client_ip_address;
			    String modifiedAtWorkstation = addedAtWorkstation ;
            
			facility=req.getParameter("facility_id");
			if(facility == null) facility="";
			
			primary_specialty=req.getParameter("primary_specialty");
			if(primary_specialty == null) primary_specialty="";
			totAssignreassign= req.getParameter("totAssignreassign");
			if(totAssignreassign == null) totAssignreassign="";
			effStatus = req.getParameter("effStatus");
			if(effStatus == null) effStatus="D";
			finalSelect = req.getParameter("finalSelect");
			if(finalSelect == null) finalSelect="";
			
			
			String sql="insert into am_pract_for_facility (facility_id,practitioner_id,allow_unassign_in_practq_yn,eff_status,added_by_id,added_date,added_at_ws_no,added_facility_id,modified_by_id,modified_date,modified_at_ws_no,modified_facility_id)values ( ?,?,?,?,?,sysdate,?,?,?,sysdate,?,?) " ;

			String sql2=" update am_pract_for_facility  set  allow_unassign_in_practq_yn =? , eff_status=? where facility_id =? and  practitioner_id=?";

			String sql3="delete from am_pract_for_facility where facility_id=? and practitioner_id=? ";
			delStmt=con.prepareStatement(sql3);
			
			StringTokenizer mainTkn= new StringTokenizer(finalSelect,"`");
			
			int maintkns= mainTkn.countTokens();
			int resUpdate=0;
			String practitioner_id="",allow_unassign_in_practq_yn="",eff_status="",selectyn="";

			for(int main=0;main<maintkns;main++)
			{
				String sub1=mainTkn.nextToken();
				StringTokenizer subTkn= new StringTokenizer(sub1,"$");
				practitioner_id=subTkn.nextToken();
				allow_unassign_in_practq_yn=subTkn.nextToken();
				selectyn=subTkn.nextToken();
				eff_status=subTkn.nextToken();
				selectyn=subTkn.nextToken();
								
				if(selectyn.equals("N"))
				{
					delStmt.setString(1,facility);
					delStmt.setString(2,practitioner_id.substring(2,practitioner_id.length()));
                  
					resUpdate=delStmt.executeUpdate();
                  
                    pslPrepStmt = con.prepareStatement(sql);
					pslPrepStmt.setString(1,facility);
					pslPrepStmt.setString(2,practitioner_id.substring(2,practitioner_id.length()));
					pslPrepStmt.setString(3,allow_unassign_in_practq_yn);
					pslPrepStmt.setString(4,eff_status);
					pslPrepStmt.setString(5,addedById);
					pslPrepStmt.setString(6,addedAtWorkstation);
					pslPrepStmt.setString(7,addedFacilityId);
					pslPrepStmt.setString(8,modifiedById);
					pslPrepStmt.setString(9,modifiedAtWorkstation);
					pslPrepStmt.setString(10,modifiedFacilityId);
					 
					resUpdate=pslPrepStmt.executeUpdate();
					 
					if(pslPrepStmt!=null) pslPrepStmt.close();
				}
				else
				{
					pslPrepStmt = con.prepareStatement(sql2);
					pslPrepStmt.setString(1,allow_unassign_in_practq_yn);
					pslPrepStmt.setString(2,eff_status);
					pslPrepStmt.setString(3,facility);
					pslPrepStmt.setString(4,practitioner_id.substring(2,practitioner_id.length()));
					
					resUpdate=pslPrepStmt.executeUpdate();
					
				}
			}
			if(delStmt!=null) delStmt.close();
			if(pslPrepStmt!=null) pslPrepStmt.close();
			String s20 = "";
			if(resUpdate >=1)
			{
				con.commit();
				Hashtable hashtable1 = MessageManager.getMessage(locale, "RECORD_INSERTED","SM");
				s20 = (String)hashtable1.get("message");
				
				res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode(s20,"UTF-8" ) + "&err_value=1");
				hashtable1.clear();
		 	}else
            {
              con.rollback();
              res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode(s20,"UTF-8" ) + "&err_value=1");
            }
	}
		catch ( Exception e )
		{
			e.printStackTrace();
			out.println("<h3> Exception raise by Servlet ...So Record Not Modified </h3> Foll: Error Received : "+e.toString());
			out.println( "Values sent are : <br>" ) ;
		}
		finally
		{
			try
			{
				if(pslPrepStmt!=null) pslPrepStmt.close();
				if(delStmt!=null) delStmt.close();
			}catch(Exception e){
				e.printStackTrace();
				out.print("Exception in closing statements " + e);}
		}
	}
}
