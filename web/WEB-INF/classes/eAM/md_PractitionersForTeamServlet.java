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

public class md_PractitionersForTeamServlet extends javax.servlet.http.HttpServlet 
{
	PrintWriter out;
	java.util.Properties p;

	
	
	//String role ;
	//String practitioner;
	 String team ;
	
	//String speciality_code="";
	String finalSelect="";
	String locale="";
	 Connection con;
	 PreparedStatement pslPrepStmt;
	  PreparedStatement stmtDel;
	  ResultSet rs3;
	  ResultSet rs4;

	
	String client_ip_address ;
    String facilityId;
	//String serviceURL;
	//String objectName;
	HttpSession session;
	

	//java.text.SimpleDateFormat dateFormat = new java.text.SimpleDateFormat( "yyyy-MM-dd" ) ;

	public void init(ServletConfig config) throws ServletException
	{
		super.init(config);
	}

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws javax.servlet.ServletException,IOException
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
		//serviceURL=(String) session.getValue("serviceURL");
 locale= p.getProperty("LOCALE");
		try
		{
			 con = ConnectionManager.getConnection(req);
			 con.setAutoCommit(false);
			res.setContentType("text/html");
			this.out = res.getWriter();
			String operation = req.getParameter("function_name");
			if (operation.equals("insert"))
			{
				insertDeletePractForTeam(req, res);
			}


		}
		catch(Exception e)
		{
			out.println(e.toString());
		}
		finally
				{
				            ConnectionManager.returnConnection(con, req);
        		}
	}


private void insertDeletePractForTeam(HttpServletRequest req, HttpServletResponse res)
	{
		try
		{
			String err_value = "1" ;
			String addedById = p.getProperty( "login_user" ) ;
			//String addedDate = dateFormat.format( new java.util.Date() ) ;
			String modifiedById = addedById ;
		//	String modifiedDate = addedDate ;
			String addedFacilityId=facilityId;
			String modifiedFacilityId = addedFacilityId ;
			String addedAtWorkstation=client_ip_address;
			String modifiedAtWorkstation = addedAtWorkstation ;
			String dispmessage = "" ;

//			java.sql.Date added_date1 = java.sql.Date.valueOf( addedDate ) ;
//			java.sql.Date modified_date1 = java.sql.Date.valueOf(modifiedDate ) ;

//			java.sql.Date added_date = new java.sql.Date(added_date1.parse(added_date1.toLocaleString())-(added_date1.getTimezoneOffset()*60*1000) ) ;
		//	java.sql.Date modified_date = new java.sql.Date(modified_date1.parse(modified_date1.toLocaleString())-(modified_date1.getTimezoneOffset()*60*1000) ) ;


			team			= req.getParameter("team_id");
			String facility_id= req.getParameter("facilityID");
			//speciality_code 	= req.getParameter("speciality_code");
			finalSelect = req.getParameter("finalSelect");
			String sqlIns="insert into am_pract_for_team ( facility_id		"+
																					", team_id		"+
																					", practitioner_id	"+
																					", pract_role		"+
																					", added_by_id	"+
																					", added_date		"+
																					", added_at_ws_no	"+
																					", added_facility_id	 "+
																					", modified_by_id	"+
																					", modified_date	"+
																					", modified_at_ws_no "+
																					", modified_facility_id ) values(?,?,?,?,?,sysdate,?,?,?,sysdate,?,?) ";

			String sqlDel=" delete from am_pract_for_team where facility_id=? and team_id =? and practitioner_id=?";
			
			StringTokenizer stmain=new StringTokenizer(finalSelect,"~");
			
			int mainTkn=stmain.countTokens();
			
			int resUpdate=0;
			

			for(int k=0;k<mainTkn;k++)
			{
				String st=stmain.nextToken();
				StringTokenizer subTkn=new StringTokenizer(st,"$");
				String practitioner_id=subTkn.nextToken();
				String role_id=subTkn.nextToken();
				String flag=subTkn.nextToken();
			
				if(flag.equals("I"))
				{

				stmtDel =con.prepareStatement(sqlDel);

				stmtDel.setString(1,facility_id);
				stmtDel.setString(2,team);
				stmtDel.setString(3,practitioner_id);

				resUpdate=stmtDel.executeUpdate();

				pslPrepStmt = con.prepareStatement(sqlIns);
				pslPrepStmt.setString(1,facility_id);
				pslPrepStmt.setString(2,team);
				pslPrepStmt.setString(3,practitioner_id);
				pslPrepStmt.setString(4,role_id);
				pslPrepStmt.setString(5,addedById);
				pslPrepStmt.setString(6,addedAtWorkstation);
				pslPrepStmt.setString(7,addedFacilityId);
				pslPrepStmt.setString(8,modifiedById);
				pslPrepStmt.setString(9,modifiedAtWorkstation);
				pslPrepStmt.setString(10,modifiedFacilityId);
				resUpdate=pslPrepStmt.executeUpdate();
				if(pslPrepStmt!=null) pslPrepStmt.close();
                 if(stmtDel!=null) stmtDel.close();
				}
				else if(flag.equals("D"))
				{

				pslPrepStmt = con.prepareStatement(sqlDel);
				pslPrepStmt.setString(1,facility_id);
				pslPrepStmt.setString(2,team);
				pslPrepStmt.setString(3,practitioner_id);
				resUpdate=pslPrepStmt.executeUpdate();
				
				if(pslPrepStmt!=null) pslPrepStmt.close();
				
				}
			}
			int chkcc = 0;
			String chkc = "";
			String chkcnt = "select count(*) chkcc from am_pract_for_team where facility_id ='"+facility_id+"' and team_id = '"+team+"' and PRACT_ROLE = 'C' ";
	
			Statement st4 = con.createStatement();
			 rs4 = st4.executeQuery(chkcnt);
			while (rs4!= null && rs4.next())
			{
				chkcc  = rs4.getInt("chkcc");
			}
			if (chkcc>1) chkc = "N";
			else
				chkc = "Y";
			
			if(st4!=null)st4.close();
			if(rs4!=null)rs4.close();
			String chkchf = "select PRACT_ROLE from am_pract_for_team where facility_id ='"+facility_id+"' and team_id = '"+team+"'";

			Statement st3 = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY 
);
			 rs3 = st3.executeQuery(chkchf);
			String chkyn = "";
			String PRACT_ROLE = "";
			if(!rs3.next())
				chkyn = "N";
			rs3.beforeFirst();
			while (rs3.next())
			{
				PRACT_ROLE =  rs3.getString("PRACT_ROLE");
				if(PRACT_ROLE.equals("C"))
				{
					chkyn = "Y";
					break;
				}
				else
					chkyn = "N";
			}
			if(rs3!=null)rs3.close();
			if(st3!=null)st3.close();
		//	String s20 = "";
		
			if(chkc == null)	chkc = "N" ;
			if(chkc.equals(""))	chkc = "N" ;

			if(chkyn == null)	chkyn = "N";
//			if(chkyn.equals(""))	chkyn = "N" ;
			if(resUpdate >=1)
			{


				if(chkyn.equals("Y")&&(chkc.equals("Y")))
				{
					con.commit() ;
				  
			//	  con.commit();
				  Hashtable hashtable1 = MessageManager.getMessage(locale, "RECORD_INSERTED","SM");
				  err_value="1" ;
				dispmessage=  (String)hashtable1.get("message");

				 hashtable1.clear();
				}
				else if(chkc.equals("N"))
				{
					
					con.rollback();
 				  err_value="0" ;
				//dispmessage= "APP-AM0020 Only one Chief can exist for a team....";
				java.util.Hashtable message = MessageManager.getMessage(locale, "ONE_CHIEF_PER_TEAM", "AM");
				 dispmessage = ((String) message.get("message"));
			//out.println("<script>alert('Atleast One Chief Should be Selected....')</script>");

				}
				else if(chkyn.equals("N"))
				{					
				 con.rollback();
				 err_value="0" ;
				// dispmessage= "Atleast one chief should be selected...";
				 java.util.Hashtable message = MessageManager.getMessage(locale, "AM0127", "AM");
				 dispmessage = ((String) message.get("message"));
				}
		 	} else {
				con.rollback();
			}
			
			 res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode(dispmessage,"UTF-8" ) + "&err_value="+err_value);

			
		}
		catch ( Exception e )
		{
			
			out.println("<h3> Exception raise by Servlet ...So Record Not Modified </h3> Foll: Error Received : "+e.toString());
			out.println( "Values sent are : <br>" ) ;
			e.printStackTrace();
			
		}
		finally
		{
			try
			{  
				if(rs3!=null) rs3.close();
				if(rs4!=null) rs4.close();
				if(pslPrepStmt!=null) pslPrepStmt.close();
				if(stmtDel!=null) stmtDel.close();
			}catch(Exception e){out.print("Exception in closing statement " + e);}
		}

	}
}
