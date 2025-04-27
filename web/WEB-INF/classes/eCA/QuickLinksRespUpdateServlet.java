/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eCA ;

import java.sql.*;
import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.naming.*;
import javax.rmi.*;

import webbeans.eCommon.*;
import webbeans.eCommon.MessageManager;

public class QuickLinksRespUpdateServlet extends HttpServlet
{
	public void init(ServletConfig cfg) throws ServletException
	{
		super.init(cfg);
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, java.io.IOException
    {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		java.io.PrintWriter out = response.getWriter();
		HttpSession session	=	null;
        session		=	request.getSession(true) ;

		try
        {
			updateResp(request,response,session,out);
		}
		catch(Exception e)
		{
			e.printStackTrace();
			
		}
	}
	private void updateResp(HttpServletRequest request, HttpServletResponse response, HttpSession session, PrintWriter out)
	{
		Connection con = null;
		PreparedStatement pstmtCheck = null ;
		PreparedStatement pstmtInsert = null ;
		PreparedStatement pstmt = null ;
		ResultSet rs = null;

		try
		{
			java.util.Properties p;

			String client_ip_address="";
			String function_id = "";
			String ql_type = "";
			String ql_ref = "";
			String ql_desc = "";
			String items[];
			String facilityId = "";
			String checked = "";
			String resp_id = "";
			String locale = "";
			String errorMsg = "";
			String link_type = "";
			String default_yn_req = "";
			String default_yn = "";

			int u = 0;
            int paramsSize =0;
			int count= 0;
			
			session				= request.getSession(false);
			p					= (java.util.Properties) session.getValue( "jdbc" ) ;
			locale				= (String) p.getProperty("LOCALE");
			client_ip_address	= (String) p.getProperty("client_ip_address");
			facilityId			= (String) session.getValue("facility_id");
			resp_id				= (String) session.getValue("responsibility_id");

			String addedById	= p.getProperty( "login_user" ) ;
			String modifiedById = addedById ;
			String addedAtWorkstation = client_ip_address;
			String modifiedAtWorkstation = addedAtWorkstation;
			String addedFacilityId = facilityId;
			String modifiedFacilityId = facilityId;
			String addedDate = new java.text.SimpleDateFormat( "yyyy-MM-dd" ).format( new java.util.Date() ) ;
			String modifiedDate = addedDate ;

			java.sql.Date added_date = java.sql.Date.valueOf( addedDate ) ;
			java.sql.Date modified_date = java.sql.Date.valueOf( modifiedDate ) ;
			
			String encounterId = request.getParameter("encounter_id") == null ? "" : request.getParameter("encounter_id");
			String patient_id = request.getParameter("patient_id")==null?"":request.getParameter("patient_id");

			boolean result = false ;
			boolean insertable = false ;
			//StringBuffer strSql = new StringBuffer("");
			Hashtable htResMesg = new Hashtable();

			RecordSet recordset = null;
			RecordSet recordsetDef = null;
			checked = (request.getParameter("count")==null)?"0":request.getParameter("count");
			link_type = (request.getParameter("link_type")==null)?"":request.getParameter("link_type");
			default_yn_req = (request.getParameter("default_yn")==null)?"":request.getParameter("default_yn");

			String function_id1 = request.getParameter("function_id") == null ? "" : request.getParameter("function_id");
			
			count = Integer.parseInt(checked);

			try
			{
				recordset= (webbeans.eCommon.RecordSet)com.ehis.persist.PersistenceHelper.getObjectFromBean("CustomizeResp"+patient_id+encounterId,"webbeans.eCommon.RecordSet",session);
				recordsetDef= (webbeans.eCommon.RecordSet)com.ehis.persist.PersistenceHelper.getObjectFromBean("CustomizeRespDef"+patient_id+encounterId,"webbeans.eCommon.RecordSet",session);
			}
			catch(Exception e)
			{
				e.printStackTrace();
				
			}
			for(int j = 0; j <= count; j++)
            {
				if(request.getParameter("chk" + j) != null)
				{
					ql_ref = request.getParameter("chk" + j);
										
					if(!recordset.containsObject(ql_ref))
						recordset.putObject(ql_ref);
                }
				if(request.getParameter("default_chk" + j) != null)
				{
					ql_ref = request.getParameter("default_chk" + j);
									
					if(recordsetDef.getSize() > 0)
					{
						recordsetDef.removeObject(0);
						recordsetDef.putObject(ql_ref);
					}
					else
						recordsetDef.putObject(ql_ref);
                }

			}
			paramsSize =  recordset.getSize();
			items = new String[paramsSize];
			for(int i = 0; i < recordset.getSize(); i++)
			{
                items[u] = (String)recordset.getObject(i);
				u++;
			}
				
			default_yn_req = (String)recordsetDef.getObject(0);
			
			try
			{
				con = ConnectionManager.getConnection(request);
				StringBuffer check_sql = new StringBuffer();
				
				check_sql.append("delete from sm_quick_link_for_user where APPL_USER_ID = ? AND LINK_TYPE =? ");
				if(link_type.equals("F"))
				{
					check_sql.append(" and option_id=? ");
				}
				
				pstmtCheck = con.prepareStatement(check_sql.toString());
				pstmtCheck.setString(1,addedById);
				pstmtCheck.setString(2,link_type);
				if(link_type.equals("F"))
				{
					pstmtCheck.setString(3,function_id1);
				}
				
				int detCount = pstmtCheck.executeUpdate();
				if(detCount >= 0)
					insertable = true;
				else
					insertable = false;
							
				if(pstmtCheck != null)pstmtCheck.close();

				String sql ="SELECT QUICK_LINK_TYPE, QUICK_LINK_DESCRIPTION, OPTION_ID FROM SM_QUICK_LINK_LIST WHERE QUICK_LINK_REF = ?";	
				
				StringBuffer insert_sql =new StringBuffer();
				
				
				insert_sql.append("INSERT INTO SM_QUICK_LINK_FOR_USER( APPL_USER_ID,LINK_TYPE,QUICK_LINK_REF");
				insert_sql.append(",OPTION_ID,DEFAULT_YN,ADDED_BY_ID");
				insert_sql.append(",ADDED_DATE,ADDED_AT_WS_NO,ADDED_FACILITY_ID");
				insert_sql.append(",MODIFIED_BY_ID,MODIFIED_DATE,MODIFIED_AT_WS_NO");
				insert_sql.append(",MODIFIED_FACILITY_ID)");
				insert_sql.append("VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?)");
   
   
   
   
   
				/* insert_sql.append(" Insert into SM_QUICK_LINK_RESPONSIBILITY ( QUICK_LINK_TYPE,");
				insert_sql.append(" QUICK_LINK_DESCRIPTION,");
				insert_sql.append(" OPTION_ID,");
				insert_sql.append(" RESP_ID,");
				insert_sql.append(" added_by_id,");
				insert_sql.append(" added_date,");
				insert_sql.append(" added_at_ws_no,");
				insert_sql.append(" added_facility_id,");
				insert_sql.append(" modified_by_id,");
				insert_sql.append(" modified_date,");
				insert_sql.append(" modified_at_ws_no,");
				insert_sql.append(" modified_facility_id ) ");
				insert_sql.append("  values(?,?,?,?,?,?,?,?,?,?,?,?)"); */

				pstmtInsert = con.prepareStatement(insert_sql.toString());
					
				if(insertable)
				{
					if(items.length == 0)
						result = true;
					
					for(int j = 0;j< items.length;j++)
					{
						if (items[j] != null)
						{
							if(items[j].equals(default_yn_req))
							{
								default_yn ="Y";		
							}
							else
							{
								default_yn ="N";
							}
							
							pstmt = con.prepareStatement(sql);
							pstmt.setString(1,items[j]);
							rs = pstmt.executeQuery();
							if(rs.next())
							{
								ql_type = rs.getString("QUICK_LINK_TYPE") == null ? "" : rs.getString("QUICK_LINK_TYPE");
								ql_desc = rs.getString("QUICK_LINK_DESCRIPTION") == null ? "" : rs.getString("QUICK_LINK_DESCRIPTION");
								function_id = rs.getString("OPTION_ID") == null ? "" : rs.getString("OPTION_ID");
							}
							if(rs != null) rs.close();
							if(pstmt != null) pstmt.close();

							pstmtInsert.setString(1,addedById);
							pstmtInsert.setString(2,link_type);
							pstmtInsert.setString(3,items[j]);

							pstmtInsert.setString(4,function_id);
							pstmtInsert.setString(5,default_yn); //default
							pstmtInsert.setString(6,addedById);

							pstmtInsert.setDate(7,added_date);
							pstmtInsert.setString(8,addedAtWorkstation);
							pstmtInsert.setString(9,addedFacilityId);

							pstmtInsert.setString(10,modifiedById);
							pstmtInsert.setDate(11,modified_date);
							pstmtInsert.setString(12,modifiedAtWorkstation);
							pstmtInsert.setString(13,modifiedFacilityId);




							/*
							pstmtInsert.setString(1,ql_type);
							pstmtInsert.setString(2,ql_desc);
							pstmtInsert.setString(3,function_id);
							pstmtInsert.setString(4,resp_id);
							pstmtInsert.setString(5,addedById);
							pstmtInsert.setDate(6,added_date);
							pstmtInsert.setString(7,addedAtWorkstation);
							pstmtInsert.setString(8,addedFacilityId);
							pstmtInsert.setString(9,modifiedById);
							pstmtInsert.setDate(10,modified_date);
							pstmtInsert.setString(11,modifiedAtWorkstation);
							pstmtInsert.setString(12,modifiedFacilityId); */

							int count1 = pstmtInsert.executeUpdate();
														
							if (count1 > 0 )
							{
								result = true;
							}

						}else{
							result = true;
						}
					}
				}
				if(pstmtInsert !=null) pstmtInsert.close();
				
				if (result)
				{
					con.commit();
					htResMesg = MessageManager.getMessage(locale, "RECORD_INSERTED","CA");
				}
				else
				{
					con.rollback();
					htResMesg = MessageManager.getMessage(locale, "FAILED_TRANSACTION","CA");
				}
				
				errorMsg = (String)htResMesg.get("message");
				out.println("<script>alert('"+errorMsg+"');</script>");
				out.println("<script>parent.window.returnValue=\"Success\";</script>");
				out.println("<script>parent.window.close();</script>");
			}
			catch(Exception e)
			{
				e.printStackTrace();
				
			}
			finally
	 		{
				 try{
					 if(con != null) ConnectionManager.returnConnection(con,request);
				 }catch(Exception exc){
				 exc.printStackTrace();
				 }
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
			
		}
	}
}
