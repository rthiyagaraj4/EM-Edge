/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eCA;

import java.util.*;
import java.sql.*;
import java.io.*;
import javax.servlet.http.*;
import javax.servlet.*;
import webbeans.eCommon.*;
import webbeans.eCommon.MessageManager;

public class ChartRecordingSplChtPatRecDtlServlet extends HttpServlet
{
	String locale			= "";

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		PrintWriter out;
		java.util.Properties p;
		HttpSession session;
		
		try
		{
            request.setCharacterEncoding("UTF-8");
			response.setContentType("text/html;charset=UTF-8");	

			out				= response.getWriter();
			session			= request.getSession(false);
			p				= (java.util.Properties)session.getValue("jdbc");
			locale			= (String) p.getProperty("LOCALE");

//			response.setContentType("text/html");
			insertPatRec(request,response,out,p,session);
		}
		catch(Exception e)
		{
			
			e.printStackTrace();
		}	
	}

	private void insertPatRec(HttpServletRequest request, HttpServletResponse response, PrintWriter out, java.util.Properties p, HttpSession session)
	{
		Connection con = null;
		PreparedStatement pstmt = null;

		String chartId = request.getParameter("chartId") == null ? "" : request.getParameter("chartId");
		String patientId = request.getParameter("patientId") == null ? "" : request.getParameter("patientId");
		String splChartGrpId = request.getParameter("splChartGrpId") == null ? "" : request.getParameter("splChartGrpId");
		String numOfRows = request.getParameter("numOfRows") == null ? "0" : request.getParameter("numOfRows");
		String numOfCols = request.getParameter("numOfCols") == null ? "0" : request.getParameter("numOfCols");
	

		String keyval = "";
		String elementType = "";
		String trnsValue = "";
		//float trnsValNum = 0.0f;
		double trnsValNum = 0.0;

		int cnt = 0;

		String added_by_id = (p.getProperty("login_user")==null)?"":p.getProperty("login_user");
		String added_facility_id = (String)session.getValue("facility_id");
		String modified_at_ws_no   = p.getProperty("client_ip_address") == null ? "" : p.getProperty("client_ip_address");

		int rows = Integer.parseInt(numOfRows);
		int cols = Integer.parseInt(numOfCols);

		String sql = "insert into CA_SPL_CHART_PAT_REC_DTL(patient_id,chart_id,key_value,element_type,trns_value,post_type,added_by_id,added_date,added_at_ws_no,added_facility_id,modified_by_id,modified_date,modified_at_ws_no,modified_facility_id,eff_status,spl_chart_type_grp_id) values(?,?,?,?,?,'U',?,sysdate,?,?,?,sysdate,?,?,'E',?)";
	
		try
		{
			con = ConnectionManager.getConnection(request);
			pstmt = con.prepareStatement(sql);			

			for(int i = 0;i < rows;i++)
			{
				keyval = request.getParameter("keyValue"+i);
				if(keyval != null)
				{
					for(int j = 0; j < cols;j++)
					{
						elementType = request.getParameter("element"+i+"Type"+j) == null ? "" : request.getParameter("element"+i+"Type"+j);
						trnsValue = request.getParameter("txt"+i+"Vals"+j) == null ? "" : request.getParameter("txt"+i+"Vals"+j);
						
						if(!trnsValue.equals(""))
						{
							trnsValNum = (double) Double.parseDouble(trnsValue);

							if(!elementType.equals(""))
							{	
								pstmt.setString(1,patientId);
								pstmt.setString(2,chartId);
								pstmt.setString(3,keyval);				
								pstmt.setString(4,elementType);
								pstmt.setDouble(5,trnsValNum);
								pstmt.setString(6,added_by_id);
								pstmt.setString(7,modified_at_ws_no);
								pstmt.setString(8,added_facility_id);
								pstmt.setString(9,added_by_id);
								pstmt.setString(10,modified_at_ws_no);
								pstmt.setString(11,added_facility_id);
								pstmt.setString(12,splChartGrpId);

								cnt = pstmt.executeUpdate();
							}
						}
					}
				}
			}
			
			if(pstmt != null) pstmt.close();

			try
			{
				con.commit();

				Hashtable tabdata = MessageManager.getMessage(locale, "RECORD_INSERTED","CA");
				int index=0;
				String errorMsg= (String) tabdata.get("message");
				StringBuffer replaceString = new StringBuffer(errorMsg);
				if((index=replaceString.toString().indexOf("<br>"))!=-1)
				{
					replaceString=replaceString.replace(index,index+"<br>".length()," ");
				}	
				out.println("<script>alert('"+replaceString.toString()+"')</script>");	
				out.println("<script>window.close();</script>"); 	
			}
			catch(Exception e2)
			{
				e2.printStackTrace();
			}
		}
		catch(Exception e)
		{
			try
			{
				con.rollback();
			}
			catch(Exception e1)
			{
				e1.printStackTrace();
			}
			
			e.printStackTrace();
		}
		finally
		{
			if(con != null) ConnectionManager.returnConnection(con);	
		}
	}
}
