/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
/*
----------------------------------------------------------------------------------------------------------------------------------------------------------
Date       	Edit History	Name				Rev.Date	Rev.Name			Description
----------------------------------------------------------------------------------------------------------------------------------------------------------
21/10/2019	4974		Sivabagyam			22/10/2019	Ramesh Goli		ML-MMOH-CRF-1144							
01/12/2020	9620		SIVABAGYAM M	01/12/2020		RAMESH G   CA-ML-MMOH-CRF-1144/01-Role Based Access Rights for Task List

------------------------------------------------------------------------------------------------------------------------------------------------
*/
package eCA;
import java.sql.*;
import java.io.*;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.naming.*;
import javax.rmi.*;

import webbeans.eCommon.*;
import webbeans.eCommon.MessageManager;
import java.util.*;
import java.util.Map.Entry;

import eCommon.SingleTabHandler.*;

public class CARoleBasedTaskListServlet extends javax.servlet.http.HttpServlet
{
	public void init(ServletConfig config) throws ServletException
	{
		super.init(config);
	}

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws javax.servlet.ServletException,IOException
	{
		req.setCharacterEncoding("UTF-8");
		res.setContentType("text/html;charset=UTF-8");

		PrintWriter out = null;

		try
		{
			out = res.getWriter();
			insertTaskListMap(req, res, out);
		}
		catch(Exception e)
		{
			//out.println("Exception in Main Block : "+e.toString());//common-icn-0181
			e.printStackTrace();
		}
	}
	private void insertTaskListMap(HttpServletRequest req, HttpServletResponse res, PrintWriter out) throws SQLException
	{
		Connection con				= null;
		PreparedStatement pstmt		= null;
		PreparedStatement pstmt1	= null;
		
		String client_ip_address	= "";
		String facilityId			= "";
		String errorMsg				= "";
		String errVal				= "0";
		boolean insert 				= false;
		try
		{
			HttpSession session =req.getSession();
			con = ConnectionManager.getConnection(req);
			eCA.CARoleBasedTaskList CARoleBasedTaskList =(CARoleBasedTaskList)session.getAttribute("CARoleBasedTaskList");
			LinkedHashMap<String, ArrayList<ArrayList<String>>> wholeMap=CARoleBasedTaskList.getMap();
			ArrayList<String> tasks=new ArrayList<String>();
			java.util.Properties p;
			p						= (java.util.Properties) session.getValue( "jdbc" ) ;
			String locale			= (String) p.getProperty("LOCALE");
			client_ip_address		= (String) p.getProperty("client_ip_address");
			facilityId				= (String)session.getValue("facility_id");
			String addedById			= p.getProperty( "login_user" ) ;			
			String modifiedById			= addedById ;
			String addedAtWorkstation	= client_ip_address;
			String modifiedAtWorkstation= addedAtWorkstation;
			String addedFacilityId		= facilityId;
			String modifiedFacilityId	= facilityId;
			
			String sql		= "";
			String sql1		= "";			
			int totalCount  = 0;
			int[] count_adpt = null;
			String category="";
			String selectd_facility=req.getParameter("facility_id")== null ? "" : req.getParameter("facility_id");
			sql1= "Delete from CA_ROLE_BASED_ACC_TASK_LIST WHERE FACILITY_ID=?";
			pstmt = con.prepareStatement(sql1);	
			pstmt.setString(1, selectd_facility);
			pstmt.executeUpdate();	
				sql = "insert into CA_ROLE_BASED_ACC_TASK_LIST  (PRACT_TYPE,CA_TASK_LIST_MSPECI,CA_TASK_LIST_REGORD,CA_TASK_LIST_RESREP,CA_TASK_LIST_MEDADMN,CA_TASK_LIST_INT,CA_TASK_LIST_BLDCONS,CA_TASK_LIST_RECCONS,CA_TASK_LIST_VITAL,FACILITY_ID,ORDER_CATEGORY,added_by_id, added_date, added_at_ws_no, added_facility_id, modified_by_id, modified_date, modified_at_ws_no, modified_facility_id) values(?,?,?,?,?,?,?,?,?,?,?,?,SYSDATE,?,?,?,SYSDATE,?,?)";											
				pstmt1 = con.prepareStatement(sql);	
				ArrayList<ArrayList<String>> allowedlist=CARoleBasedTaskList.getTaskList();
				for(int i=0;i<allowedlist.size();i++)
				{
					totalCount++;
					tasks=allowedlist.get(i);
					category=req.getParameter("category"+i)== null ? "" : req.getParameter("category"+i);	
					pstmt1.setString(1,tasks.get(0));
					pstmt1.setString(2,tasks.get(1));								
					pstmt1.setString(3,tasks.get(2));								
					pstmt1.setString(4,tasks.get(3));
					pstmt1.setString(5,tasks.get(4));
					pstmt1.setString(6,tasks.get(5));
					pstmt1.setString(7,tasks.get(6));
					pstmt1.setString(8,tasks.get(7));
					pstmt1.setString(9,tasks.get(8));
					pstmt1.setString(10,selectd_facility);
					pstmt1.setString(11,category);
					pstmt1.setString(12,addedById);								
					pstmt1.setString(13,addedAtWorkstation);
					pstmt1.setString(14,addedFacilityId);
					pstmt1.setString(15,modifiedById);								
					pstmt1.setString(16,modifiedAtWorkstation);
					pstmt1.setString(17,modifiedFacilityId);
					pstmt1.addBatch();
			}
			if(totalCount==0){
				insert=true;
			}else{
				count_adpt = pstmt1.executeBatch();				
						
				for (int i=0;i<count_adpt.length ;i++ )
				{
					if(count_adpt[i]<0  && count_adpt[i] != -2 )
					{
						insert=false;
						break;
					}
					else
					{
						insert=true;
					}
				}					
			}
			if(insert){			
				con.commit();
				errorMsg= getMessage(locale, "RECORD_INSERTED","CA");
				errVal = "0";
				
			}else{								
				con.rollback();
				errorMsg= getMessage(locale, "FAILED_TRANSACTION","CA");
				errVal = "0";
			}
			out.println("<script language=\"javascript\">");
			out.println("parent.messageFrame.location.href='../eCommon/jsp/MstCodeError.jsp?err_num="+ java.net.URLEncoder.encode( errorMsg,"UTF-8" ) +"'");
			out.println("parent.CARoleBasedAccessRightsforTaskListFrame.location.href='../eCA/jsp/CARoleBasedAccessRightsforTaskList.jsp'");
			out.println("</script>");
			

		}catch (Exception ee){
			ee.printStackTrace();
		}finally{
			if(pstmt1 != null) pstmt1.close();
			if(pstmt != null) pstmt.close();
			if(con != null)
				ConnectionManager.returnConnection(con,req);
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