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

public class SpltyMasterCodeServlet extends HttpServlet
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
		
		try
        {
			insertMstCode(request,response,out);
		}
		catch(Exception e)
		{
			e.printStackTrace();
			
		}
	}
	private void insertMstCode(HttpServletRequest request, HttpServletResponse response, PrintWriter out)
	{
		Connection con = null;
		PreparedStatement pstmt = null ;
		PreparedStatement pstmtCheck = null ;

		try
		{
			java.util.Properties p;
			HttpSession session;

			session						= request.getSession(false);
			p							= (java.util.Properties) session.getValue( "jdbc" );
			String locale				= (String) p.getProperty("LOCALE");
			String client_ip_address	= (String) p.getProperty("client_ip_address");
			String facilityId			= (String)session.getValue("facility_id");
			String addedById			= p.getProperty( "login_user" ) ;
			String modifiedById			= addedById ;
			String addedAtWorkstation	= client_ip_address;
			String modifiedAtWorkstation= addedAtWorkstation;
			String addedFacilityId		= facilityId;
			String modifiedFacilityId	= facilityId;
			String addedDate = new java.text.SimpleDateFormat( "yyyy-MM-dd" ).format( new java.util.Date() ) ;
			String modifiedDate			= addedDate ;

			java.sql.Date added_date	= java.sql.Date.valueOf( addedDate );
			java.sql.Date modified_date = java.sql.Date.valueOf( modifiedDate );

			String code				= "";
			String longDesc			= "";
			String shortDesc		= "";
			String eff_status		= "";
			String mast_type_ref	= request.getParameter("mast_type_ref")==null?"":request.getParameter("mast_type_ref");
			String totalCount		= request.getParameter("total")==null?"":request.getParameter("total");
			int count				= Integer.parseInt(totalCount);
			
			boolean result = false ;
			boolean insertable = false ;
			String error_value = "0";
			String error = "";

			try
			{
				con = ConnectionManager.getConnection(request);
				String check_sql = "";
				/************START ADDED BY DEEPA ON 7/8/2009 AT 3:49 PM FOR IN008172 **/
				check_sql = "delete AM_DISCR_MSR_REF_RNG_LIST  where DISCR_MSR_ID = ? ";
				pstmtCheck = con.prepareStatement(check_sql);
				pstmtCheck.setString(1,mast_type_ref);
				pstmtCheck.executeUpdate();

				if(pstmtCheck != null) pstmtCheck.close();
				/************END ADDED BY DEEPA ON 7/8/2009 AT 3:49 PM FOR IN008172 **/

				check_sql = "delete from CA_SPLTY_MAST_CODE_VAL where mast_type_ref = ? ";
				pstmtCheck = con.prepareStatement(check_sql);
				pstmtCheck.setString(1,mast_type_ref);
				int detCount = pstmtCheck.executeUpdate();
				
				if(detCount >= 0)
					insertable = true;
				else
					insertable = false;
				
				if(pstmtCheck != null)pstmtCheck.close();

				if(insertable)
				{
					String insert_sql = "insert into CA_SPLTY_MAST_CODE_VAL (mast_type_ref,splty_mst_code,short_desc,long_desc,eff_status,added_by_id,added_date,added_at_ws_no,added_facility_id,modified_by_id,modified_date, modified_at_ws_no, modified_facility_id) values(?,?,?,?,?,?,?,?,?,?,?,?,?)";
					pstmt = con.prepareStatement(insert_sql);

					for(int j=0;j<count;j++)
					{
						code = request.getParameter("code"+j)==null?"":request.getParameter("code"+j);
						longDesc = request.getParameter("longDesc"+j)==null?"":request.getParameter("longDesc"+j);
						shortDesc = request.getParameter("shortDesc"+j)==null?"":request.getParameter("shortDesc"+j);
						eff_status = request.getParameter("effStatus"+j)==null?"":request.getParameter("effStatus"+j);

						pstmt.setString(1,mast_type_ref);
						pstmt.setString(2,code);
						pstmt.setString(3,shortDesc);
						pstmt.setString(4,longDesc);
						pstmt.setString(5,eff_status);
						pstmt.setString(6,addedById);
						pstmt.setDate(7,added_date);
						pstmt.setString(8,addedAtWorkstation);
						pstmt.setString(9,addedFacilityId);
						pstmt.setString(10,modifiedById);
						pstmt.setDate(11,modified_date);
						pstmt.setString(12,modifiedAtWorkstation);
						pstmt.setString(13,modifiedFacilityId);
						int count1 = pstmt.executeUpdate();
						if (count1 > 0 )
						{
							result = true;
						}
						else
							result = false;
					}
					
					if(pstmt !=null) pstmt.close();
				}
				
				if(result)
				{
					con.commit();
					error = getMessage(locale, "RECORD_INSERTED","CA");
					error_value = "1";		response.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num="+java.net.URLEncoder.encode(error,"UTF-8")+"&err_value="+error_value);
				}
				else
				{
					con.rollback();
				}
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
	private String getMessage(String locale, String messageId, String moduleId)
	{
		java.util.Hashtable message = MessageManager.getMessage(locale,messageId,moduleId);
		String mesg = (String) message.get("message");
		message.clear();
		return(mesg) ;
	}
}
