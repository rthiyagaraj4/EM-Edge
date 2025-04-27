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
21/10/2019	IN069242		Sivabagyam			22/10/2019	Ramesh Goli			GHL-CRF-0567							
09/10/2023     51003           Krishna Pranay    10/10/2023       Ramesh Goli        COMMON-ICN-0178
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

import java.util.*;
import java.util.Map.Entry;

import eCommon.SingleTabHandler.*;

public class CARestrictCEHDataServlet extends javax.servlet.http.HttpServlet
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
			insertRestrictData(req, res, out);
		}
		catch(Exception e)
		{
			//out.println("Exception in Main Block : "+e.toString());//common-icn-0181
			e.printStackTrace();
		}
	}
	private void insertRestrictData(HttpServletRequest req, HttpServletResponse res, PrintWriter out) throws SQLException
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
			HttpSession session =req.getSession(false);
			con = ConnectionManager.getConnection(req);
			
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
			//String sql1		= "";		//51003	
			int totalCount  = 0;
			int[] count_adpt = null;
			HashMap<String,String> restrictData=new HashMap<String,String>();
			
			String mapData=req.getParameter("restrictData");
			mapData = mapData.substring(1, mapData.length()-1);           //remove curly brackets
			if(!"".equals(mapData.trim())){
				String[] keyValuePairs = mapData.split(",");              //split the string to creat key-value pairs
				for(String pair : keyValuePairs)                        //iterate over the pairs
				{
					String[] entry = pair.split("=");                   //split the pairs to get key and value 
					restrictData.put(entry[0].trim(), entry[1].trim());          //add them to the hashmap and trim whitespaces
				}
			}
			
			String restrictId=req.getParameter("restrictId")	== null ? "" : req.getParameter("restrictId");
			//String restrictDesc=req.getParameter("restrictDesc")	== null ? "" : req.getParameter("restrictDesc");//51003
			String histFunction=req.getParameter("histFunction")	== null ? "" : req.getParameter("histFunction");
			
			String deletQry="Delete from CA_CEH_RESTRICT_DATA_DTL where restriction_id=? ";
			pstmt=con.prepareStatement(deletQry);
			pstmt.setString(1,restrictId);
			pstmt.executeUpdate();		
			
			sql = "insert into CA_CEH_RESTRICT_DATA_DTL  (restriction_id,hist_function,restriction_type,hist_rec_type,event_class,restriction_yn,added_by_id, added_date, added_at_ws_no, added_facility_id, modified_by_id, modified_date, modified_at_ws_no, modified_facility_id) values(?,?,?,?,?,?,?,SYSDATE,?,?,?,SYSDATE,?,?)";											
			pstmt1 = con.prepareStatement(sql);			
			for (Entry<String, String> entry1 : restrictData.entrySet()) {
				if (entry1.getValue().equals("Y")) {
					totalCount++;
					String hist_rec_data= entry1.getKey();
					String[] allvalues = hist_rec_data.split("\\|");   
	
					pstmt1.setString(1,restrictId);
					pstmt1.setString(2,histFunction);								
					pstmt1.setString(3,allvalues[1]);								
					pstmt1.setString(4,allvalues[2]);
					pstmt1.setString(5,allvalues[3]);
					pstmt1.setString(6,entry1.getValue());
					pstmt1.setString(7,addedById);								
					pstmt1.setString(8,addedAtWorkstation);
					pstmt1.setString(9,addedFacilityId);
					pstmt1.setString(10,modifiedById);								
					pstmt1.setString(11,modifiedAtWorkstation);
					pstmt1.setString(12,modifiedFacilityId);
					pstmt1.addBatch();
				}
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
			res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode( errorMsg,"UTF-8" ) +"&err_value="+errVal);

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