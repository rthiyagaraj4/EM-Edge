/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
/*
	Developed By       :  P.Sudhakaran
	Developed on   	   :  10/12/2001
	Modified on		   :  07/02/2002
	Modified by		   :  R. Nanda Kumar
	Modified on		   :  27/07/2004
	Modified by		   :  Karabi
	Module Name 	   :  eCIS/dr
	Function Name	   :  Default Search Criteria
	Function ID		   :  DR_DEF_SEARCH_CRITER
	This servlet is used fo insert and update the default search criteria values into the database.
*/
package eDR;
import java.sql.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;
import webbeans.eCommon.*;

public class DefaultSearchCriteriaServlet extends javax.servlet.http.HttpServlet
{
	PrintWriter out;
	Properties p;
	HttpSession session;
	
	PreparedStatement SqlInsertPstmt	= null;
	PreparedStatement sqlupdatePstmt	= null;
	Connection con						= null;
	Statement stmt						= null;
	ResultSet messageResultset          = null;

	String facilityId				= "";
	String client_ip_address		= "";
    String mode						= "";
	String addedById				= "";
	String modifiedById				= "";
	String addedFacilityId			= "";
	String modifiedFacilityId		= "";
	String addedAtWorkstation		= "";
	String modifiedAtWorkstation	= "";
	String name_loc_lang_yn			= "";
	String first_name 				= "";
	String second_name 				= "";
	String third_name 				= "";
	String family_name 				= "";
	String names_sndx_type			= "";
	String nationality_code			= "";
	String sex 						= "";
	String day_of_birth 			= "";
	String month_of_birth 			= "";
	String year_of_birth 			= "";
	String res_area_code 			= "";
	String contact1_no 				= "";
	String contact2_no				= "";
	String search_type 				= "";
	String short_desc11				= "";
	String short_desc22				= "";
	String short_desc33				= "";
	String short_desc44				= "";
	String other_alt_id_type		= "";

	int rsinsertft	= 0;

	StringBuffer sqlinsert	= null; 
	StringBuffer sqlupdate	= null;

	public void init(ServletConfig config) throws ServletException
	{
			super.init(config);
	}

	public synchronized void doPost(HttpServletRequest req, HttpServletResponse res) throws javax.servlet.ServletException,IOException
	{
		req.setCharacterEncoding("UTF-8");
		res.setContentType("text/html;charset=UTF-8");
		session					= req.getSession(false);
		this.facilityId			= (String) session.getValue("facility_id" ) ;
		this.p					= (Properties) session.getValue( "jdbc" ) ;
		this.client_ip_address	= p.getProperty("client_ip_address");
		
		try
		{
			con		= ConnectionManager.getConnection(req);
			stmt	= con.createStatement();
			
			this.out					=res.getWriter();

			mode				= req.getParameter("mode");
			name_loc_lang_yn	= req.getParameter("name_loc_lang_yn");
			first_name 			= req.getParameter("first_name");
			second_name 		= req.getParameter("second_name");
			third_name 			= req.getParameter("third_name");
			family_name 		= req.getParameter("family_name");
			names_sndx_type		= req.getParameter("names_sndx_type");
			nationality_code	= req.getParameter("nationality_code");
			sex 				= req.getParameter("sex");
			short_desc11 		= req.getParameter("short_desc11");
			short_desc22 		= req.getParameter("short_desc22");
			short_desc33 		= req.getParameter("short_desc33");
			short_desc44 		= req.getParameter("short_desc44");
			day_of_birth 		= req.getParameter("day_of_birth1");
			month_of_birth 		= req.getParameter("month_of_birth1");
			year_of_birth 		= req.getParameter("year_of_birth1");
			res_area_code 		= req.getParameter("res_area_code");
			contact1_no 		= req.getParameter("contact1_no");
			contact2_no			= req.getParameter("contact2_no");
			search_type 		= req.getParameter("search_type");
			other_alt_id_type	= req.getParameter("other_alt_id_type");
			
			addedById				= p.getProperty( "login_user" ) ;
			modifiedById			= addedById ;
			addedFacilityId			= facilityId;
			modifiedFacilityId	    = addedFacilityId ;
			addedAtWorkstation	    = client_ip_address;
			modifiedAtWorkstation	= addedAtWorkstation ;

			if(nationality_code == null) nationality_code = "";
			if(name_loc_lang_yn == null) name_loc_lang_yn = "";
			if(first_name == null) first_name = "";
			if(second_name == null) second_name = "";
			if(third_name == null) third_name = "";
			if(family_name == null) family_name = "";
			if(names_sndx_type == null) names_sndx_type = "N";
			if(sex == null) sex = "";
			if(day_of_birth == null) day_of_birth = "";
			if(month_of_birth == null) month_of_birth = "";
			if(year_of_birth == null) year_of_birth = "";
			if(res_area_code == null) res_area_code = "";
			if(contact1_no == null) contact1_no = "";
			if(contact2_no == null) contact2_no = "";
			if(search_type == null) search_type = "";
			if(short_desc11 == null) short_desc11 = "";
			if(short_desc22 == null) short_desc22 = "";
			if(short_desc33 == null) short_desc33 = "";
			if(short_desc44 == null) short_desc44 = "";
			if(other_alt_id_type == null || other_alt_id_type.equals("null")) other_alt_id_type="";
			
			//assigning N to check box variables
			if(!nationality_code.equals("Y")) nationality_code = "N";
			if(!name_loc_lang_yn.equals("Y")) name_loc_lang_yn = "N";
			if(!first_name.equals("Y")) first_name = "N";
			if(!second_name.equals("Y")) second_name = "N";
			if(!third_name.equals("Y"))	third_name = "N";
			if(!family_name.equals("Y")) family_name = "N";
			if(!sex.equals("Y")) sex = "N";
			if(!day_of_birth.equals("Y")) day_of_birth = "N";
			if(!month_of_birth.equals("Y")) month_of_birth = "N";
			if(!year_of_birth.equals("Y")) year_of_birth = "N";
			if(!res_area_code.equals("Y")) res_area_code = "N";
			if(!contact1_no.equals("Y")) contact1_no = "N";
			if(!contact2_no.equals("Y")) contact2_no = "N";
			
			if(mode.equals("insert"))	
			{
				insert_dr_def_search_criter(res);
			}
			else if(mode.equals("update"))	
			{
				modify_dr_def_search_criter(res);
			}
		}
		catch(Exception e)
		{
			out.println(e.toString());
			e.printStackTrace();
		}
		finally
		{
			ConnectionManager.returnConnection(con,req);
		}
	}//do post

	private synchronized void insert_dr_def_search_criter(HttpServletResponse res)
	{
		try
		{
			String locale = p.getProperty("LOCALE");
			
			con.setAutoCommit(false);
			sqlinsert = new StringBuffer();

			sqlinsert.append("INSERT INTO dr_def_search_criteria ");
			sqlinsert.append("(nationality_code_yn,");
			sqlinsert.append("name_loc_lang_yn,");
			sqlinsert.append("first_name_yn,");
			sqlinsert.append("second_name_yn,");
			sqlinsert.append("third_name_yn,");
			sqlinsert.append("family_name_yn,");
			sqlinsert.append("names_sndx_type,");
			sqlinsert.append("sex_yn,");
			sqlinsert.append("day_of_birth_yn,");
			sqlinsert.append("month_of_birth_yn,");
			sqlinsert.append("year_of_birth_yn,");
			sqlinsert.append("res_area_code_yn,");
			sqlinsert.append("contact1_no_yn,");
			sqlinsert.append("contact2_no_yn,");
			sqlinsert.append("search_type,");
			sqlinsert.append("added_by_id,");
			sqlinsert.append("added_date,");
			sqlinsert.append("added_at_ws_no,");
			sqlinsert.append("added_facility_id,");
			sqlinsert.append("modified_by_id,");
			sqlinsert.append("modified_date,");
			sqlinsert.append("modified_at_ws_no,");
			sqlinsert.append("modified_facility_id,");
			sqlinsert.append("ALT_ID1_NO_YN,");
			sqlinsert.append("ALT_ID2_NO_YN,");
			sqlinsert.append("ALT_ID3_NO_YN,");
			sqlinsert.append("OTHER_ALT_ID_TYPE,");
			sqlinsert.append("ALT_ID4_NO_YN) ");
			sqlinsert.append("values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,sysdate,?,?,?,sysdate,?,?,?,?,?,?,?)");
			
			SqlInsertPstmt = con.prepareStatement(sqlinsert.toString());

			SqlInsertPstmt.setString(1,nationality_code);
			SqlInsertPstmt.setString(2,name_loc_lang_yn);
			SqlInsertPstmt.setString(3,first_name);
			SqlInsertPstmt.setString(4,second_name);
			SqlInsertPstmt.setString(5,third_name);
			SqlInsertPstmt.setString(6,family_name);
			SqlInsertPstmt.setString(7,names_sndx_type);
			SqlInsertPstmt.setString(8,sex);
			SqlInsertPstmt.setString(9,day_of_birth);
			SqlInsertPstmt.setString(10,month_of_birth);
			SqlInsertPstmt.setString(11,year_of_birth);
			SqlInsertPstmt.setString(12,res_area_code);
			SqlInsertPstmt.setString(13,contact1_no);
			SqlInsertPstmt.setString(14,contact2_no);
			SqlInsertPstmt.setString(15,search_type);
			SqlInsertPstmt.setString(16,addedById);
			SqlInsertPstmt.setString(17,addedAtWorkstation);
			SqlInsertPstmt.setString(18,addedFacilityId);
			SqlInsertPstmt.setString(19,modifiedById);
			SqlInsertPstmt.setString(20,modifiedAtWorkstation);
			SqlInsertPstmt.setString(21,modifiedFacilityId);
			SqlInsertPstmt.setString(22,short_desc11);
			SqlInsertPstmt.setString(23,short_desc22);
			SqlInsertPstmt.setString(24,short_desc33);
			SqlInsertPstmt.setString(25,other_alt_id_type);
			SqlInsertPstmt.setString(26,short_desc44);
			
			rsinsertft = SqlInsertPstmt.executeUpdate();
		
			if(rsinsertft > 0)
			{
				con.commit();
				
			/*	String message   = "";
				String msg		 = "SELECT GET_ERROR_MESSAGE('RECORD_INSERTED') FROM dual";
				messageResultset = stmt.executeQuery(msg);
				if(messageResultset != null)
				{
					if(messageResultset.next())
					{
						message = messageResultset.getString(1);
					}
				} if(messageResultset != null) messageResultset.close();  */

				java.util.Hashtable message = MessageManager.getMessage(locale, "RECORD_INSERTED", "SM");
				String error = ((String) message.get("message"));

				res.sendRedirect("../eCommon/jsp/error.jsp?err_num=" + java.net.URLEncoder.encode(error,"UTF-8") + "&err_value=1 " );
			}
			else
			{
				con.rollback();
				//res.sendRedirect("../eCommon/jsp/error.jsp?err_num=" + java.net.URLEncoder.encode("Transaction Failed ") + "&err_value=0 " );
			}

			if((sqlinsert != null) && (sqlinsert.length() > 0))
			{
				sqlinsert.delete(0,sqlinsert.length());
			}

			if(stmt != null) stmt.close();
			if(SqlInsertPstmt != null) SqlInsertPstmt.close();
		}//try
		catch(Exception e1)
		{
			out.println("Exception raise by Servlet in insert_dr_def_search_criter method :"+e1.toString());
			e1.printStackTrace();
		}
	}//method

	private synchronized void modify_dr_def_search_criter(HttpServletResponse res)
	{
		try
		{
			String locale = p.getProperty("LOCALE");			

			con.setAutoCommit(false);
			sqlupdate = new StringBuffer();

			sqlupdate.append("UPDATE dr_def_search_criteria SET ");
			sqlupdate.append("nationality_code_yn = ?, ");
			sqlupdate.append("name_loc_lang_yn = ?, ");
			sqlupdate.append("first_name_yn = ?, ");
			sqlupdate.append("second_name_yn = ?, ");
			sqlupdate.append("third_name_yn = ?, ");
			sqlupdate.append("family_name_yn = ?, ");
			sqlupdate.append("names_sndx_type = ?, ");
			sqlupdate.append("sex_yn = ?, ");
			sqlupdate.append("day_of_birth_yn = ?, ");
			sqlupdate.append("month_of_birth_yn = ?, ");
			sqlupdate.append("year_of_birth_yn = ?, ");
			sqlupdate.append("res_area_code_yn = ?, ");
			sqlupdate.append("contact1_no_yn = ?, ");
			sqlupdate.append("contact2_no_yn = ?, ");
			sqlupdate.append("search_type = ?, ");
			sqlupdate.append("modified_by_id = ? ,");
			sqlupdate.append("modified_date = SYSDATE, ");
			sqlupdate.append("modified_at_ws_no = ?, ");
			sqlupdate.append("modified_facility_id = ?, ");
			sqlupdate.append("ALT_ID1_NO_YN = ?, ");
			sqlupdate.append("ALT_ID2_NO_YN = ?, ");
			sqlupdate.append("ALT_ID3_NO_YN = ?, ");
			sqlupdate.append("other_alt_id_type = ?, ");
			sqlupdate.append("ALT_ID4_NO_YN = ?");
			
			sqlupdatePstmt = con.prepareStatement(sqlupdate.toString());
			
			sqlupdatePstmt.setString(1,nationality_code);	
			sqlupdatePstmt.setString(2,name_loc_lang_yn);	
			sqlupdatePstmt.setString(3,first_name);	
			sqlupdatePstmt.setString(4,second_name);	
			sqlupdatePstmt.setString(5,third_name);	
			sqlupdatePstmt.setString(6,family_name);	
			sqlupdatePstmt.setString(7,names_sndx_type);	
			sqlupdatePstmt.setString(8,sex);	
			sqlupdatePstmt.setString(9,day_of_birth);	
			sqlupdatePstmt.setString(10,month_of_birth);	
			sqlupdatePstmt.setString(11,year_of_birth);	
			sqlupdatePstmt.setString(12,res_area_code);	
			sqlupdatePstmt.setString(13,contact1_no);	
			sqlupdatePstmt.setString(14,contact2_no);	
			sqlupdatePstmt.setString(15,search_type);	
			sqlupdatePstmt.setString(16,modifiedById);	
			sqlupdatePstmt.setString(17,modifiedAtWorkstation);	
			sqlupdatePstmt.setString(18,modifiedFacilityId);	
			sqlupdatePstmt.setString(19,short_desc11);	
			sqlupdatePstmt.setString(20,short_desc22);	
			sqlupdatePstmt.setString(21,short_desc33);	
			sqlupdatePstmt.setString(22,other_alt_id_type);	
			sqlupdatePstmt.setString(23,short_desc44);	
			
			rsinsertft = sqlupdatePstmt.executeUpdate();
		
			if(rsinsertft > 0)
			{
				con.commit();
			
			/*	String message	 = "";
				String msg		 = "select GET_ERROR_MESSAGE('RECORD_MODIFIED') from dual";
				messageResultset = stmt.executeQuery(msg);
				if(messageResultset != null){
					if(messageResultset.next()){
						message = messageResultset.getString(1);
					}
				} if(messageResultset != null) messageResultset.close();  */
	
				java.util.Hashtable message = MessageManager.getMessage(locale, "RECORD_MODIFIED", "SM");
				String error = ((String) message.get("message"));

				res.sendRedirect("../eCommon/jsp/error.jsp?err_num=" + java.net.URLEncoder.encode(error,"UTF-8") + "&err_value=1 " );
			}
			else
			{
				con.rollback();
				//res.sendRedirect("../eCommon/jsp/error.jsp?err_num=" + java.net.URLEncoder.encode("Transaction Failed ") + "&err_value=0 " );
			}

			if((sqlupdate != null) && (sqlupdate.length() > 0))
			{
				sqlupdate.delete(0,sqlupdate.length());
			}

			if(stmt != null) stmt.close();
			if(sqlupdatePstmt != null) sqlupdatePstmt.close();
		}//try
		catch(Exception e2)
		{
				out.println("Exception raise by Servlet in modify_dr_def_search_criter method :"+e2.toString());
				e2.printStackTrace();
		}
	}//method
}//class
