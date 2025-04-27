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
import webbeans.eCommon.*;

public class OtherStaffForFacilityServlet extends javax.servlet.http.HttpServlet
{
	PrintWriter out;
	String effStatus="";
	String finalvalue="";
	java.util.Properties p;
	String facilityId ;
	String client_ip_address ;
	String error_value = "";
	HttpSession session;
    Connection con;
	PreparedStatement pstmt_insert = null;
	PreparedStatement pstmt_delete = null;
	PreparedStatement pstmt_update = null;	
	String locale="";
	//java.text.SimpleDateFormat dateFormat = new java.text.SimpleDateFormat( "yyyy-MM-dd" ) ;

	public void init(ServletConfig config) throws ServletException
	{
		super.init(config);
	}

	public synchronized void doPost(HttpServletRequest req, HttpServletResponse res) throws javax.servlet.ServletException,IOException
	{
		session = req.getSession(false);		
		this.facilityId = (String) session.getAttribute( "facility_id" ) ;
		this.p = (java.util.Properties) session.getAttribute( "jdbc" ) ;
		this.client_ip_address = p.getProperty("client_ip_address");
		try
		{
			con = ConnectionManager.getConnection(req);
			res.setContentType("text/html");
			this.out = res.getWriter();
			 locale= p.getProperty("LOCALE");
			String operation = req.getParameter("function_name");
			if ( operation.equals("insert") )   insertOPPF(req, res);


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

	public void doGet(HttpServletResponse res) throws javax.servlet.ServletException,IOException
	{
		try
		{		
			this.out = res.getWriter();
			res.setContentType("text/html");
			out.println("<html><head><link rel='stylesheet' type ='text/css' href='../eCommon/html/IeStyle.css'></link><script language='javascript' src='/eCIS/mp/js/Occupation.js'></script></head><frameset rows='60,*,50'><frame name='commontoolbarFrame' src='../eCommon/jsp/MstCodeToolbar.jsp?function_name=Occupation' frameborder=0 scrolling='no' noresize><frame name='f_query_add_mod' src='../eCommon/html/blank.html' frameborder=0><frame name='messageFrame' src='../eCommon/jsp/MstCodeError.jsp' frameborder=0 noresize scrolling='auto'></frameset></html> ");
		}
		catch(Exception e)	{	
		e.printStackTrace();}
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
		        boolean flag1 = true;
				
int l=0;
			
		
			effStatus = req.getParameter("effStatus"); 	if(effStatus == null) effStatus="D";
			
			//int noOfRecords = Integer.parseInt(req.getParameter("noOfRecords"));

			String sql="insert into am_other_staff_for_facility (facility_id,other_staff_id,eff_date_from,eff_date_to,eff_status,added_by_id,added_date,added_at_ws_no,added_facility_id,modified_by_id,modified_date,modified_at_ws_no,modified_facility_id)values ( ?,?,to_date(?,'dd/mm/yyyy'),to_date(?,'dd/mm/yyyy'),?,?,sysdate,?,?,?,sysdate,?,?)";
			String sql2 = "update am_other_staff_for_facility set eff_date_from=to_date(?,'dd/mm/yyyy'),eff_date_to=to_date(?,'dd/mm/yyyy') where facility_id=? and other_staff_id=? ";
			String sql3="delete from am_other_staff_for_facility where facility_id=? and other_staff_id=?";
			
			pstmt_insert = con.prepareStatement(sql);
			pstmt_update = con.prepareStatement(sql2);
			pstmt_delete = con.prepareStatement(sql3);


			String other_staff_id = "";
			String curr_val = "";
			String def_val = "";
			String eff_date_from = "";
			String eff_date_to = "";
			String eff_status = "";
			String index = "";
			//String curval = "";
			
			//int start =Integer.parseInt(req.getParameter("start"));
			String facility_id = req.getParameter("facility_id");

			String finalvalue = req.getParameter("finalSelect");
			if(finalvalue == null) finalvalue="";

			

			StringTokenizer stringtokenizer = new StringTokenizer(finalvalue, "~");
				
				int maintkn=stringtokenizer.countTokens();
				
				for(int j=0;j<maintkn;j++)
				{
					String stMain=stringtokenizer.nextToken();
					StringTokenizer st5=new StringTokenizer(stMain,"$");
					st5.nextToken();
					st5.nextToken();
					index = st5.nextToken();
					curr_val = st5.nextToken();
					def_val = st5.nextToken();
					eff_date_from = st5.nextToken();
					eff_date_to = st5.nextToken();
					other_staff_id = st5.nextToken();
					eff_status = st5.nextToken();

					
					if(eff_date_from.equals("null") || eff_date_from.equals(" ") )
					{
					eff_date_from="";
					}
					if(eff_date_to.equals("null") || eff_date_to.equals(" ")) 
					{
					eff_date_to="";
					}

																

		//	for(int i=0;i<(noOfRecords);i++)
		//	{
		//		other_staff_id = req.getParameter("other_staff_id"+i)==null ? "":req.getParameter("other_staff_id"+i);
		//		curr_val = req.getParameter("curr_db_action"+i);
		//		def_val = req.getParameter("def_db_action"+i);

		
				if(curr_val.equals("I") && def_val.equals("U"))
				{
					
					
					pstmt_delete.setString(1,facility_id);
					pstmt_delete.setString(2,other_staff_id);
			l = 	pstmt_delete.executeUpdate();		
				}
				else
				{
					
				//	eff_date_from = req.getParameter("eff_date_from"+i) == null ?"":req.getParameter("eff_date_from"+i);
				//		 eff_date_to = req.getParameter("eff_da+te_to"+i)== null ?"":req.getParameter("eff_date_to"+i);
				//		 eff_status = req.getParameter("select"+i)==null ? "":req.getParameter("select"+i) ;
				
				//		 if(eff_status.equalsIgnoreCase(""))
				//			 eff_status = "D";
				//		 else
				//			 eff_status = "E";
					 if(curr_val.equals("U") && def_val.equals("I"))
					 {					

						 //insert
						

						 pstmt_insert.setString(1,facility_id);
						 pstmt_insert.setString(2,other_staff_id);
						 pstmt_insert.setString(3,eff_date_from);
						 pstmt_insert.setString(4,eff_date_to);
						 pstmt_insert.setString(5,eff_status);
						 pstmt_insert.setString(6,addedById);
						 pstmt_insert.setString(7,addedAtWorkstation);
						 pstmt_insert.setString(8,addedFacilityId);
						 pstmt_insert.setString(9,modifiedById);
						 pstmt_insert.setString(10,modifiedAtWorkstation);
						 pstmt_insert.setString(11,modifiedFacilityId);
						
						 l = pstmt_insert.executeUpdate();	
						// if(pstmt_insert!=null) pstmt_insert.close();
					 }
					 else
					{
						 
						 pstmt_update.setString(1,eff_date_from);
						 pstmt_update.setString(2,eff_date_to);
						 pstmt_update.setString(3,facility_id);
						 pstmt_update.setString(4,other_staff_id);
						 l = pstmt_update.executeUpdate();		
					}
						
					
				}
		
				
			//}//end of for

				}

				if(l > 0)
				   flag1 = true;
	if(flag1)	con.commit();

			Hashtable hashtable1 = MessageManager.getMessage(locale, "RECORD_INSERTED","SM");
				String s20 = (String)hashtable1.get("message");
				
				res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode(s20,"UTF-8" ) + "&err_value=1");
				//hashtable1.clear();
		
	}catch ( Exception e )
	{
		//out.println("<h3> Exception raise by Servlet ...So Record Not Modified </h3> Foll: Error Received : "+e.toString());
		//out.println( "Values sent are : <br>" ) ;
		//out.println( facility+ " "+pract + " "+ effectiveStatus );
		try{
			con.rollback();
		error_value = "Exception Message -> " + e.getMessage();
		e.printStackTrace();
		res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num="+error_value );
		}catch(Exception ex)
		{
			ex.printStackTrace();
		}
	}
	finally
	{
		try
		{
			if(pstmt_insert!=null) pstmt_insert.close();
			if(pstmt_delete!=null) pstmt_delete.close();
			if(pstmt_update!=null) pstmt_update.close();
		
			ConnectionManager.returnConnection(con,req);


		}catch(Exception e){out.print("Exception in closing statements " + e);
		e.printStackTrace();
		}
	}
	}
}
