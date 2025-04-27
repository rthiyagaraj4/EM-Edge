/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eCA;
import java.sql.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;
import javax.naming.*;
import javax.rmi.*;
import java.util.*;
import webbeans.eCommon.MessageManager;
import webbeans.eCommon.*;
import eCA.SitesForVaccineBean;

public class SitesForVaccineServlet extends javax.servlet.http.HttpServlet	{

	/**
*	init	-	will initialise the servlet
*	@param	config - this is ServletConfig
*/
public void init(ServletConfig config) throws ServletException	{
		super.init(config);
	}
/**
*	doPost	-	will be called when the method is of post
*	@param	request - this is HttpServletRequest
*	@param	response - this is HttpServletResponse
*	throws javax.servlet.ServletException,IOException
*/
public  void doPost(HttpServletRequest request, HttpServletResponse response)throws javax.servlet.ServletException,IOException
	{
	    HttpSession session = request.getSession(false);
		PrintWriter out = null;
		Connection con = null;
		PreparedStatement ps1 = null;
		ResultSet rs1 = null;			
		int arrayLength=0;
		String vaccineId = "";
		String errorMsg = "";
		Hashtable tabdata = new Hashtable();
		Properties p;
	  try
		{   request.setCharacterEncoding("UTF-8"); 
			response.setContentType("text/html; charset=UTF-8");
			con = ConnectionManager.getConnection(request);
			out = response.getWriter();
			arrayLength = Integer.parseInt(request.getParameter("array_length"));
			if(arrayLength != 0)
			{

				insertModify(request,response,arrayLength,con);
			}
			else
			{   p = (java.util.Properties)session.getValue( "jdbc" ) ;
		        String locale = (String) p.getProperty("LOCALE");  
				vaccineId = request.getParameter("vaccineId") == null ? "" : request.getParameter("vaccineId");
				ps1 = con.prepareStatement("Delete from CA_IM_SITE_FOR_VACCINE where VACCINE_ID =? ");
				ps1.setString(1,vaccineId);
				ps1.executeUpdate();
				tabdata = MessageManager.getMessage(locale, "RECORD_INSERTED","CA");
				errorMsg= (String) tabdata.get("message");
				response.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num="+java.net.URLEncoder.encode(errorMsg,"UTF-8")+"&err_value=1");

			}
			if(rs1 != null) rs1.close();
			if(ps1 != null) ps1.close();
		}
	catch(Exception ee)
			{
				//out.println("Exception raise by Sites For Vaccine Servlet ...So Record Not inserted  : "+ee.toString());//common-icn-0181
				ee.printStackTrace();
			}
			finally
			{
					
					if(con != null) ConnectionManager.returnConnection(con);
				
			}
			
	}
	/**
*	insertModify	-	will be called when the Modification of Data is to be Done
*	@param	request - this is HttpServletRequest
*	@param	response - this is HttpServletResponse
*	@param	
*	throws javax.servlet.ServletException,IOException
*/

public void insertModify(HttpServletRequest request,HttpServletResponse response,int arrayLength,Connection con)
	{
		PrintWriter out = null;
		String client_ip_addr ="";
		String facilityId ="";
		String addedId ="";
		HttpSession session = request.getSession(false); 
		Properties p;
		Hashtable tabdata = new Hashtable();
		PreparedStatement ps = null;
		PreparedStatement psUpdate = null;
		PreparedStatement psInsert = null;
		//Connection con = null;
		ResultSet rs = null;
		String errorMsg = "";
		//String seq_num[] = new String[arrayLength];
		String siteName[] =  new String[arrayLength]; 
		String defaultYN[] =  new String[arrayLength]; 
		String sqlInsert = "";
		String sqlUpdate = "";
		String remove_value =  request.getParameter("remove_value")==null ? "" :request.getParameter("remove_value");
		SitesForVaccineBean sitesbean= new SitesForVaccineBean();
		String vaccineId = "";
		int rowCount =0;
		String sqlSelect = "";
		int index = 0;
		//int maxRecord = 0;
		//long seqNo=0;
		int count =0;
		int rows=0;
		p = (java.util.Properties) session.getValue( "jdbc" ) ;
		String locale = (String) p.getProperty("LOCALE");
		facilityId = (String) session.getValue( "facility_id" ) ;
		client_ip_addr=	p.getProperty("client_ip_address");
		addedId =  (p.getProperty("login_user")==null)?"":p.getProperty("login_user")  ; 
		for(index = 0;index < arrayLength;index++)
		{
			//seq_num[index] = request.getParameter("seq_num"+index);
			siteName[index] =  request.getParameter("siteName"+index);
			defaultYN[index] =  request.getParameter("defaultYN"+index);
		}
		for (int k = 0;k<defaultYN.length ;k++ )
		{
			if (defaultYN[k] == null || defaultYN[k]=="" || defaultYN[k].equals(""))
			{
				defaultYN[k] = "N";
			}
		}
	    try
		{
			out = response.getWriter();
			vaccineId = request.getParameter("vaccineId") == null ? "" : request.getParameter("vaccineId");
			//con = ConnectionManager.getConnection(request);
			if(!remove_value.equals(""))
			{
			StringTokenizer token = new StringTokenizer(remove_value,"||");
			while(token.hasMoreTokens())
				{
					sitesbean.deleteRow(token.nextToken(),con,vaccineId,p);
				}
			}

			sqlInsert = "Insert into CA_IM_SITE_FOR_VACCINE (VACCINE_ID, SITE_ID, DEFAULT_YN, ADDED_BY_ID, ADDED_DATE, ADDED_AT_WS_NO, ADDED_FACILITY_ID, MODIFIED_BY_ID, MODIFIED_DATE, MODIFIED_AT_WS_NO, MODIFIED_FACILITY_ID) values(?,?,?,?,sysdate,?,?,?,sysdate,?,?)";

			//sqlInsert = "Insert into ca_chart_section (CHART_ID, PANEL_ID, DISPLAY_ORDER_SEQ, ADDED_BY_ID, ADDED_DATE, ADDED_AT_WS_NO, ADDED_FACILITY_ID, MODIFIED_BY_ID, MODIFIED_DATE, MODIFIED_AT_WS_NO, MODIFIED_FACILITY_ID) values(?,?,?,?,sysdate,?,?,?,sysdate,?,?)";
			
			sqlUpdate = "update CA_IM_SITE_FOR_VACCINE set  DEFAULT_YN=?, MODIFIED_BY_ID=?, MODIFIED_DATE=sysdate, MODIFIED_AT_WS_NO=?, MODIFIED_FACILITY_ID=? where VACCINE_ID= ? and  SITE_ID =?";
			
			sqlSelect = "select DEFAULT_YN from CA_IM_SITE_FOR_VACCINE where VACCINE_ID=? and  SITE_ID=?";
			psUpdate = con.prepareStatement(sqlUpdate);
			
			psInsert = con.prepareStatement(sqlInsert);
			for(rowCount = 0 ; rowCount < arrayLength;rowCount ++)
			{
				count =0;
				ps = con.prepareStatement(sqlSelect);
				ps.setString(1,vaccineId);
				ps.setString(2,siteName[rowCount]);
				
				try
				{
					rs = ps.executeQuery();
					while(rs.next())
					{
						//seqNo = Long.parseLong(rs.getString(2));	
						count ++;
					}
				}
				catch (Exception ee1)
				{

					ee1.printStackTrace();

				}
					if(count !=0)
				{
					//if(seqNo == Long.parseLong(seq_num[rowCount]))
					//{
						//rows++;
					//}
					//else
					//{
						
						psUpdate.setString(1,defaultYN[rowCount]);
						psUpdate.setString(2,addedId);
						psUpdate.setString(3,client_ip_addr);
						psUpdate.setString(4,facilityId);
						psUpdate.setString(5,vaccineId);
						psUpdate.setString(6,siteName[rowCount]);
						rows =rows +  psUpdate.executeUpdate();
					//}
				}
				else
				{
					psInsert.setString(1,vaccineId);
					psInsert.setString(2,siteName[rowCount]);
					psInsert.setString(3,defaultYN[rowCount]);
					psInsert.setString(4,addedId);
					psInsert.setString(5,client_ip_addr);
					psInsert.setString(6,facilityId);
					psInsert.setString(7,addedId);
					psInsert.setString(8,client_ip_addr);
					psInsert.setString(9,facilityId);
					rows = rows + psInsert.executeUpdate();
				}
				if(rs != null) rs.close();
				if(ps != null) ps.close();
			}
			if(rows == arrayLength)
			{
				con.commit();
				tabdata = MessageManager.getMessage(locale,"RECORD_INSERTED","CA");
				errorMsg= (String) tabdata.get("message");
				response.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num="+java.net.URLEncoder.encode(errorMsg,"UTF-8")+"&err_value=1");
			}
			else
			{
				try{
						con.rollback();
				}catch(Exception e){
				
				e.printStackTrace();
				}
			}
			if(rs != null) rs.close();
					if(ps != null) ps.close();
					if(psUpdate != null)	 psUpdate.close();
					if(psInsert != null)	psInsert.close();
		}
		catch(Exception ee)
			{
				//out.println("Exception raise by Sites For  Vaccine Insert Modify Function Servlet ...So Record Not inserted  : "+ee.toString());//common-icn-0181
				ee.printStackTrace();
			}
			finally
			{				
					//if(con != null) ConnectionManager.returnConnection(con);
				
			}
	
	}
}

