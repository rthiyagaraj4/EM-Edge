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
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;
import java.util.Date.*;
import javax.naming.*;
import javax.rmi.*;
import java.io.IOException;
import java.io.PrintWriter;
import webbeans.eCommon.*;

public class RecDiagnosisDiffGroupServlet extends javax.servlet.http.HttpServlet
{
	
	PrintWriter out;
	java.util.Properties p;

	Connection   con = null;
	
	PreparedStatement pstmt		= null;
	ResultSet			rs		=	null;

	String facilityId			= "";
	String client_ip_address	= "";
	String addedById			= "";
	//String addedDate			= "";
	String addedAtWorkstation	= "";
	String addedFacilityId		= "";
	String modifiedById			= "";
	String modifiedAtWorkstation= "";

	//StringBuffer sb= new StringBuffer();

	String Patient_Id    = "";
	String term_set_id   = "";
	String term_code     = "";
	String occur_srl_no    = "";
	String error_value	 = "";
	String cur_diff_id   = "";
	String tempString    = "";
	String grp_mode      = "";
	String curr_grp_id   = "";

	String  n_curr_grp_id ="";
	String  n_cur_diff_id ="";
	
	int insert_chk =0;
	String mode ="";
	boolean result=true;
	HttpSession session;
	String locale = "";
	public void init(ServletConfig config) throws ServletException	{
		super.init(config);
	}
	public synchronized void doGet(HttpServletRequest req, HttpServletResponse res)
	throws javax.servlet.ServletException,IOException
	{
		doPost(req,res);
	}
	public synchronized void doPost(HttpServletRequest req, HttpServletResponse res) throws javax.servlet.ServletException,IOException
	{
		
		req.setCharacterEncoding("UTF-8");
		res.setContentType("text/html;charset=UTF-8");
		this.out = res.getWriter();

		session = req.getSession(false);
		this.p = (Properties)session.getValue("jdbc") ;
		locale = p.getProperty("LOCALE");
		this.facilityId = (String)session.getValue( "facility_id" ) ;
		this.client_ip_address = this.p.getProperty("client_ip_address");
		addedById = (p.getProperty("login_user")==null)?"":p.getProperty("login_user")  ;
		addedFacilityId		= facilityId;
		addedAtWorkstation	= client_ip_address;
		modifiedAtWorkstation = client_ip_address;
		modifiedById = (p.getProperty("login_user")==null)?"":p.getProperty("login_user")  ;       
		curr_grp_id = req.getParameter("curr_grp_id")==null?"":req.getParameter("curr_grp_id");
		n_curr_grp_id = curr_grp_id;
			
		try
		{
			mode = req.getParameter("mode")==null?"":req.getParameter("mode");
			grp_mode = req.getParameter("grp_mode")==null?"":req.getParameter("grp_mode");
			Patient_Id  = req.getParameter("Patient_Id")==null?"":req.getParameter("Patient_Id");
			addGroup(req,res);
		}
		catch(Exception e)
		{
			//out.println("Exception @ try "+e.toString());
			e.printStackTrace();
		}

	}
/***************************  Adding Group *********************************/
	private void addGroup(HttpServletRequest req, HttpServletResponse res)
	{
		
		String termvals[]   = req.getParameterValues("termValues");
		int new_group_id=0;
		try
		{
			con = ConnectionManager.getConnection(req);
			StringBuffer sql_group = new StringBuffer();
			
			try
			{
				con.setAutoCommit(false);
				
				if(sql_group.length() > 0) sql_group.delete(0,sql_group.length());
				sql_group.append("select nvl(max(diff_group_id),0)+1 "); 
				sql_group.append("new_group_id from pr_differential_diagnosis where patient_id=?");
				
				pstmt = con.prepareStatement(sql_group.toString());
				pstmt.setString(1,Patient_Id);
				rs=pstmt.executeQuery();
				
				while(rs.next())
				{
					new_group_id = rs.getInt(1);
				}
				if(rs != null)rs.close();
				if(pstmt != null) pstmt.close();
				
				if(termvals.length!=0 )
				{
				  if(mode.equals("N"))
					{
					 if(sql_group.length() > 0) sql_group.delete(0,sql_group.length());
					sql_group.append( "insert into pr_differential_diagnosis ");
					sql_group.append("(patient_id,term_set_id,term_code,");
					sql_group.append("occur_srl_no,diff_group_id,finalized_yn,"); 
					sql_group.append("added_by_id,added_date,added_at_ws_no,"); 
					sql_group.append("added_facility_id,");
					sql_group.append("modified_by_id,modified_date,");
					sql_group.append("modified_at_ws_no,modified_facility_id)");
					sql_group.append("values  (?,?,?,");
					sql_group.append("?,?,'N',?,sysdate,?,?,?,sysdate,?,?)");

					pstmt = con.prepareStatement(sql_group.toString());
					for(int index = 0 ; index < termvals.length;index++)
					{
						tempString = termvals[index];
						StringTokenizer str1 = new StringTokenizer(java.net.URLDecoder.decode(tempString),"|");
					while(str1.hasMoreTokens())
					{
							term_set_id = str1.nextToken();
							term_code = str1.nextToken();
							occur_srl_no = str1.nextToken();
							cur_diff_id=str1.nextToken();
							n_cur_diff_id = cur_diff_id;

							pstmt.setString(1,Patient_Id);
							pstmt.setString(2,term_set_id);
							pstmt.setString(3,term_code);
							pstmt.setString(4,occur_srl_no);
						    if (grp_mode.equals("UpdateGroup"))
							{
								pstmt.setString(5,curr_grp_id);
							}
							else
							{
								pstmt.setInt(5,new_group_id);
							}
					}
							pstmt.setString(6,addedById);
							pstmt.setString(7,addedAtWorkstation);
							pstmt.setString(8,addedFacilityId);
							pstmt.setString(9,modifiedById);
							pstmt.setString(10,modifiedAtWorkstation);
							pstmt.setString(11,addedFacilityId);
							insert_chk = pstmt.executeUpdate(); 
				}
				try
				{
					if(insert_chk > 0)
						result = true; 
					else 
						result = false;
					if(pstmt != null) pstmt.close();
					if(result)
					{
						con.commit();
					}
					else
					{
						con.rollback();
					}
				}
				catch(Exception x)
				{
					x.printStackTrace();
					//sb.append("Exception while inserting PR_DIFFERENTIAL_DIAGNOSIS ::"+x.getMessage());
					con.rollback();
					result=false;
				}
		} //end if
			
			else if(mode.equals("U"))
			{	
				
				if(sql_group.length() > 0) sql_group.delete(0,sql_group.length());
				
				sql_group.append("update PR_DIFFERENTIAL_DIAGNOSIS  set ");
				sql_group.append("DIFF_GROUP_ID = ?,MODIFIED_BY_ID =?,");
				sql_group.append("MODIFIED_DATE=sysdate, MODIFIED_AT_WS_NO=?,");
				sql_group.append("MODIFIED_FACILITY_ID=? where PATIENT_ID = ? ");
				sql_group.append("and  TERM_SET_ID = ? And  TERM_CODE = ? "); 
				sql_group.append(" and OCCUR_SRL_NO = ? ");
				sql_group.append(" and DIFF_GROUP_ID = ?");
				
				try
				{
					int modify_chk = 0;
					pstmt = con.prepareStatement(sql_group.toString());

					for(int index = 0 ; index < termvals.length;index++)
					{
						tempString = termvals[index];
						StringTokenizer str1 = new StringTokenizer(java.net.URLDecoder.decode(tempString),"|");
						while(str1.hasMoreTokens())
						{	
							term_set_id = str1.nextToken();
							term_code = str1.nextToken();
							occur_srl_no = str1.nextToken();
							cur_diff_id = str1.nextToken();
							n_cur_diff_id = cur_diff_id;
							pstmt.setString(6,term_set_id);
							pstmt.setString(7,term_code);
							pstmt.setString(8,occur_srl_no);

							if(grp_mode.equals("NewGroup"))
							{
								pstmt.setString(9,n_cur_diff_id);
							}
							else if(grp_mode.equals("UpdateGroup"))
							{
								pstmt.setString(9,n_cur_diff_id);	
							}
						
						}
					if(grp_mode.equals("NewGroup"))
					{
						pstmt.setInt(1,new_group_id);
					}
					else if(grp_mode.equals("UpdateGroup"))
					{
						pstmt.setString(1,n_curr_grp_id);	
					}
						pstmt.setString(2,modifiedById);
						pstmt.setString(3,modifiedAtWorkstation);
						pstmt.setString(4,addedFacilityId);
						pstmt.setString(5,Patient_Id);
						modify_chk = pstmt.executeUpdate();
				}
				
				if(modify_chk > 0)
					result = true; 
				else 
					result = false;
				if(result)
				{
					con.commit();
				}
				else
				{
					con.rollback();
				}
				if(pstmt != null) pstmt.close();
			}
			catch(Exception x)
			{	
				
				x.printStackTrace();
				//sb.append("Exception while updating PR_DIFFERENTIAL_DIAGNOSIS ::"+x.getMessage());
				con.rollback();
				result=false;
			}
		} 		

	}
			String error = "";
			if(result)
			{
				error_value	= "1" ;
				
				
				java.util.Hashtable message = MessageManager.getMessage( locale, "RECORD_MODIFIED","SM" ) ;
				String msg = (String) message.get("message");
				error=msg;
			}
			else
			{
				error_value	= "0" ;
				error				= "APP-SM0002 Operation failed ....";
			}
				
				res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode( error, "UTF-8" ) + "&err_value=" + error_value );

		}
			
		catch(SQLException ex)
		{
				ex.printStackTrace();
				//out.println("Exception in insert mode "+ex.toString());
				con.rollback();
				result=false;
		}
		
	}
	catch(Exception ex)
	{
		//out.println("Exception in while inserting  " + ex.toString());
		ex.printStackTrace();
	}
	finally
	{
		
		if(con != null)ConnectionManager.returnConnection(con,req);
	}
	
 }
 
}
