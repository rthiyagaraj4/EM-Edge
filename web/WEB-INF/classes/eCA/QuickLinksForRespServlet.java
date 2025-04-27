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

public class QuickLinksForRespServlet extends HttpServlet
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
			insertQuickLinksForResp(request,response,session,out);
		}
		catch(Exception e)
		{
			e.printStackTrace();
			
		}
	}
	private void insertQuickLinksForResp(HttpServletRequest request, HttpServletResponse response, HttpSession session, PrintWriter out)
	{
		Connection con = null;
		PreparedStatement pstmtCheck = null ;
		PreparedStatement pstmtInsert = null ;
		//PreparedStatement pstmt = null ;
		//ResultSet rs = null;

		try
		{
			java.util.Properties p;

			String client_ip_address="";
			//String practitioner_id="";
			String function_id = "";
			String ql_type = "";
			String ql_ref = "";
			String items[];
			String facilityId = "";
			String checked = "";
			String resp_id = "";
			String locale = "";
			String errorMsg = "";
			String error_value = "";
			String default_checked = "";
			String default_ref = "";

			int u = 0;
            int paramsSize =0;
			int count= 0;
			
			session				= request.getSession(false);
			p					= (java.util.Properties) session.getValue( "jdbc" ) ;
			locale				= (String) p.getProperty("LOCALE");
			client_ip_address	= (String) p.getProperty("client_ip_address");
			facilityId			= (String)session.getValue("facility_id");

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

			boolean result = false ;
			boolean insertable = false ;
			//StringBuffer strSql = new StringBuffer("");
			Hashtable htResMesg = new Hashtable();

			RecordSet recordset = null;
			RecordSet recordset1 = null;
			//practitioner_id = request.getParameter("practitioner_id");
			checked = (request.getParameter("count")==null)?"0":request.getParameter("count");
			function_id = (request.getParameter("function_id")==null)?"":request.getParameter("function_id");
			ql_type = (request.getParameter("ql_type")==null)?"":request.getParameter("ql_type");
			resp_id = (request.getParameter("resp_id")==null)?"":request.getParameter("resp_id");

			count = Integer.parseInt(checked);
			try
			{
				recordset = (webbeans.eCommon.RecordSet)com.ehis.persist.PersistenceHelper.getObjectFromBean("QuickLinkResp","webbeans.eCommon.RecordSet",session);
				recordset1 = (webbeans.eCommon.RecordSet)com.ehis.persist.PersistenceHelper.getObjectFromBean("QuickLinkResp1","webbeans.eCommon.RecordSet",session);

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
					
					if(recordset1.getSize() > 0)
					{
						recordset1.removeObject(0);
						recordset1.putObject(ql_ref);
					}
					else
						recordset1.putObject(ql_ref);
                }
			}
			paramsSize =  recordset.getSize();
			items = new String[paramsSize];
			for(int i = 0; i < recordset.getSize(); i++)
			{
                items[u] = (String)recordset.getObject(i);
				u++;
			}
			default_checked = (String)recordset1.getObject(0);
			try
			{
				con = ConnectionManager.getConnection(request);
				StringBuffer check_sql = new StringBuffer();
				
				check_sql.append("delete from SM_QUICK_LINK_RESP where LINK_TYPE = ? ");
				if(!function_id.equals(""))
					check_sql.append(" and OPTION_ID = ? ");
				if(!resp_id.equals(""))
					check_sql.append(" and RESP_ID = ? ");
				
				pstmtCheck = con.prepareStatement(check_sql.toString());
				int counter = 0;
				pstmtCheck.setString(++counter,ql_type);
				if(!function_id.equals(""))
					pstmtCheck.setString(++counter,function_id);
				if(!resp_id.equals(""))
					pstmtCheck.setString(++counter,resp_id);

				int detCount = pstmtCheck.executeUpdate();
				if(detCount >= 0)
					insertable = true;
				else
					insertable = false;
							
				if(pstmtCheck != null)pstmtCheck.close();

					
				StringBuffer insert_sql =new StringBuffer();
				insert_sql.append(" Insert into SM_QUICK_LINK_RESP ( LINK_TYPE,");
				insert_sql.append(" RESP_ID,");
				insert_sql.append(" OPTION_ID,");
				insert_sql.append(" QUICK_LINK_REF,");
				insert_sql.append(" added_by_id,");
				insert_sql.append(" added_date,");
				insert_sql.append(" added_at_ws_no,");
				insert_sql.append(" added_facility_id,");
				insert_sql.append(" modified_by_id,");
				insert_sql.append(" modified_date,");
				insert_sql.append(" modified_at_ws_no,");
				insert_sql.append(" modified_facility_id ");
				if(!function_id.equals(""))
					insert_sql.append(" , DEFAULT_YN ) ");
				else
					insert_sql.append(" )");
				insert_sql.append("  values(?,?,?,?,?,?,?,?,?,?,?,?");
				if(!function_id.equals(""))
					insert_sql.append(",? ) ");
				else
					insert_sql.append(" )");
				
				pstmtInsert = con.prepareStatement(insert_sql.toString());
					
				if(insertable)
				{
					if(items.length == 0)
						result = true;

					for(int j = 0;j< items.length;j++)
					{
						if (items[j] != null)
						{
							if(items[j].equals(default_checked))
								default_ref = "Y";
							else
								default_ref = "N";

							pstmtInsert.setString(1,ql_type);
							pstmtInsert.setString(2,resp_id);
							pstmtInsert.setString(3,function_id);
							pstmtInsert.setString(4,items[j]);
							pstmtInsert.setString(5,addedById);
							pstmtInsert.setDate(6,added_date);
							pstmtInsert.setString(7,addedAtWorkstation);
							pstmtInsert.setString(8,addedFacilityId);
							pstmtInsert.setString(9,modifiedById);
							pstmtInsert.setDate(10,modified_date);
							pstmtInsert.setString(11,modifiedAtWorkstation);
							pstmtInsert.setString(12,modifiedFacilityId);
							if(!function_id.equals(""))
									pstmtInsert.setString(13,default_ref);

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
					error_value = "1" ;
				}
				else
				{
					con.rollback();
					htResMesg = MessageManager.getMessage(locale, "FAILED_TRANSACTION","CA");
					error_value = "0";
				}
				errorMsg = (String)htResMesg.get("message");
				response.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode( errorMsg,"UTF-8" ) + "&err_value=" + error_value );
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
	//end		
		}
		catch(Exception e)
		{
			e.printStackTrace();
			
		}
	}
}
