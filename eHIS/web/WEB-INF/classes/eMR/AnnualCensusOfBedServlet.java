/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eMR;
import eCommon.SingleTabHandler.*;
import java.io.*;
import java.net.URLEncoder;
import java.sql.*;
import javax.naming.InitialContext;
import javax.rmi.PortableRemoteObject;
import javax.servlet.*;
import javax.servlet.http.*;
import java.text.*;
import java.util.*;
import webbeans.eCommon.*;

public class AnnualCensusOfBedServlet extends javax.servlet.http.HttpServlet 
{
	java.util.Properties p;
	HttpSession session;
	PrintWriter out;
	String facilityId					= "";
	String group_code					= "";
	String report_id					= "";
	String sub_group_code				= "";
	String maxrecord					= "";
	String tab_list_no					= "";	
	String text							= "";
	String textr1						= "";
	String textr2						= "";
	String textr3						= "";
	String textr4						= "";
	String error						= "";
	String err_value					= "";
	String client_ip_address			= "";
	String inc							= "";
	String addedById					= "";
	String modifiedById					= "";
	String modifiedAtWorkstation		= "";
	String modifiedFacilityId			= "";
	String addedFacilityId				= "";
	String addedAtWorkstation			= "";
	String tab_list						= "";	
	String function_name				= "";
	String census_date					= "";
	String locale="";
//	String bed_class_group_code			= "";
	int text1							= 0;	
	int cnt								= 0;
	boolean status;
	Connection con						= null;
	Statement	stmt					= null;
	PreparedStatement pstmt				= null;
	PreparedStatement preStatement		= null;
	public void init(ServletConfig config) throws ServletException
	{
		super.init(config);
	}
	public synchronized void doPost(HttpServletRequest request, HttpServletResponse response) throws javax.servlet.ServletException,IOException
	{
		session							= request.getSession(false);
		this.p							= (java.util.Properties) session.getValue( "jdbc" ) ;
		report_id						= checkForNull(request.getParameter("report_id"));
		group_code						= checkForNull(request.getParameter("group_code"));
		sub_group_code					= checkForNull(request.getParameter("sub_group_code"));
		census_date		= checkForNull(request.getParameter("census_date"));
	//	bed_class_group_code		= checkForNull(request.getParameter("bed_class_group_code"));
		maxrecord						= checkForNull(request.getParameter("maxrecord1"));
		this.facilityId					= checkForNull((String) session.getValue( "facility_id")) ;
		client_ip_address				= p.getProperty("client_ip_address");
		group_code						= group_code.trim();
		sub_group_code					= sub_group_code.trim();
		maxrecord						= maxrecord.trim();		
		function_name					= request.getParameter("function_name1");
		if(function_name==null || function_name.equals("null"))
		function_name="";
		locale = p.getProperty("LOCALE");
		
		insertTabulation(request,response);
		
	}   
	
	private void insertTabulation(HttpServletRequest request, HttpServletResponse response)
	{
		response.setContentType("text/html");
		int count = 0;
		count=Integer.parseInt(maxrecord);
		try
		{
			this.out					= response.getWriter();
			String level_code3			= checkForNull(request.getParameter("level_code"));
			level_code3					=level_code3.trim();
			con							= ConnectionManager.getConnection(request);
			stmt						= con.createStatement();
			con.setAutoCommit(false);
			addedById					= p.getProperty( "login_user" ) ;
			modifiedById				= addedById ;
			addedFacilityId				= facilityId;
			modifiedFacilityId			= addedFacilityId ;
			addedAtWorkstation			= client_ip_address;
			modifiedAtWorkstation		= addedAtWorkstation ;
			int i=1;
			try
			{
				String sql350="";
				for(i=1;i<count;i++)
				{
					tab_list_no			= checkForNull(request.getParameter("tab_list_no"+i));
					text                = checkForNull(request.getParameter("text"+i));
					inc                 = checkForNull(request.getParameter("inc"+i));
					tab_list            = checkForNull(request.getParameter("tab_list"+i));
					textr1             = checkForNull(request.getParameter("textr1"+i));
					textr2             = checkForNull(request.getParameter("textr2"+i));
					textr3             = checkForNull(request.getParameter("textr3"+i));					
					textr4             = checkForNull(request.getParameter("textr4"+i));/*Commented by Dharma on Dec 3rd 2014 against HSA-CRF-0205 [IN:050120]*/
					if(inc.equals("") || inc.equals("N"))
					{
						//String sql22="";
						try{
							sql350 ="delete from MR_ANNUAL_CENSUS_OF_BED where to_char(CENSUS_YEAR,'yyyy')= ? and GROUP_CODE=?  and SUB_GROUP_CODE=?  and BED_CLASS_GROUP_CODE=?";
							preStatement		=	con.prepareStatement(sql350);					
							preStatement.setString(1, census_date);
							preStatement.setString(2, group_code);
							preStatement.setString(3, sub_group_code);
							preStatement.setString(4, tab_list_no);
							cnt = preStatement.executeUpdate();
							if(cnt>0)
							status=true;
						if(preStatement!=null)preStatement.close();
						}
						catch(Exception e)
							{
							//System.err.println("Exception :"+e.toString());
							e.printStackTrace();
							}
					}
					if(inc.equals("Y") )//&& !(text.equals(""))
					{
		
						try{
	  						if(preStatement!=null)preStatement.close();
							sql350 ="delete from MR_ANNUAL_CENSUS_OF_BED where to_char(CENSUS_YEAR,'yyyy')= ?  and GROUP_CODE=?  and SUB_GROUP_CODE=?  and BED_CLASS_GROUP_CODE=?";
							preStatement		=	con.prepareStatement(sql350);					
							preStatement.setString(1, census_date);
							preStatement.setString(2, group_code);
							preStatement.setString(3, sub_group_code);
							preStatement.setString(4, tab_list_no);			
	  						preStatement.executeUpdate();
							if(preStatement!=null)preStatement.close();		
							}
						catch(Exception e)
							{
							//System.err.println("Exception1 :"+e.toString());
							e.printStackTrace();
							}						
						//float text_tab        =Float.parseFloat(text);
						/*String sp = "insert into MR_ANNUAL_CENSUS_OF_BED (FACILITY_ID , CENSUS_YEAR, GROUP_CODE ,SUB_GROUP_CODE, BED_CLASS_GROUP_CODE, COMM_BED_CNT, MALE_BED_CNT, FEMALE_BED_CNT, CHILD_BED_CNT, added_by_id, added_date, added_at_ws_no, added_facility_id, modified_by_id, modified_date, modified_at_ws_no, modified_facility_id ) values  (?, to_date(?,'yyyy'), ?, ?, ?, ?, ?, ?,?, ?, sysdate, ?, ?, ?, sysdate, ?, ?)";*/
						/*Modified by Dharma on Dec 3rd 2014 against HSA-CRF-0205 [IN:050120]*/

						String sp = "insert into MR_ANNUAL_CENSUS_OF_BED (FACILITY_ID , CENSUS_YEAR, GROUP_CODE ,SUB_GROUP_CODE, BED_CLASS_GROUP_CODE, COMM_BED_CNT, MALE_BED_CNT, FEMALE_BED_CNT,CHILD_BED_CNT,  added_by_id, added_date, added_at_ws_no, added_facility_id, modified_by_id, modified_date, modified_at_ws_no, modified_facility_id ) values  (?, to_date(?,'yyyy'), ?, ?, ?, ?, ?, ?, ?,?, sysdate, ?, ?, ?, sysdate, ?, ?)";
						
						pstmt = con.prepareStatement(sp);					
						pstmt.setString(1, facilityId);
						pstmt.setString(2, census_date);
						pstmt.setString(3, group_code);
						pstmt.setString(4, sub_group_code);
						pstmt.setString(5, tab_list_no);					
						pstmt.setString(6, textr1);
						pstmt.setString(7, textr2);
						pstmt.setString(8, textr3);
						/*Modified index by Dharma on Dec 3rd 2014 against HSA-CRF-0205 [IN:050120] Start*/
						pstmt.setString(9, textr4);						
						pstmt.setString(10, addedById);
						pstmt.setString(11, addedAtWorkstation);
						pstmt.setString(12, addedFacilityId);
						pstmt.setString(13, modifiedById);
						pstmt.setString(14, modifiedAtWorkstation);
						pstmt.setString(15, modifiedFacilityId);
						/*Modified by Dharma on Dec 3rd 2014 against HSA-CRF-0205 [IN:050120] End*/
						cnt=pstmt.executeUpdate();						
						if(pstmt != null)	pstmt.close();
						if(cnt>0)
							status=true;
						else
							status=false;
						
					}
				}
			}
			catch(Exception x)
			{
				//out.println("Exceptioina at line 150"+x.getMessage());
				x.printStackTrace();
				status=false;
				con.rollback();
				error=x.getMessage();
			}
			if(status)
			{
				err_value="1";
				con.commit();
				java.util.Hashtable message = MessageManager.getMessage(locale, "RECORD_INSERTED","SM");
				error	=	(String) message.get("message");
				err_value= "1";
				response.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode( error,"UTF-8" ) + "&err_value=" + err_value );
				message.clear();
				
			}
			else
			{
				err_value="0";
				con.rollback();
				out.println(err_value);
				response.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode( error,"UTF-8" ) + "&err_value=" + err_value );
			}
			if(stmt!=null) stmt.close();
		}
		catch ( Exception e )
		{
			//out.println("<h3> Exception raise by Servlet ...So Record Not Modified </h3> Foll: Error Received : "+e.toString());
			e.printStackTrace();
			try
			{
				con.rollback();
			}
			catch(Exception eee)
			{
				//out.println("Exception raise by servlet"+eee.toString());
				eee.printStackTrace();
			}
		//	out.println(e.toString());
		}
		  finally
		  {
				 if( con != null ) ConnectionManager.returnConnection(con,request);
		  }    
	}
	public static String checkForNull(String inputString)
	{
		return( ( (inputString == null) || (inputString.equals("null") ) ) ? "" : inputString);
	}
}
