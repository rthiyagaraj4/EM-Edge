/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
/*
--------------------------------------------------------------------------------------------------------
Date			Edit History	Name		Rev.Date		Rev.Name			Description
---------------------------------------------------------------------------------------------------------
03/03/2022      29024           K Pranay                                          unused local variable[Common-ICN-0092  ]
-------------------------------------------------------------------------------------------------------
*/

package eCA;


import java.io.*;
import java.net.*;
import java.util.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.lang.reflect.Method;
import java.net.URLEncoder;




import webbeans.eCommon.*;

public class RiskFactorGroupServlet extends HttpServlet 
{
    public void init(ServletConfig servletconfig) throws ServletException
    {
        super.init(servletconfig);
    }

    public  void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException
    {
		PrintWriter out = null;
		try
        {
            req.setCharacterEncoding("UTF-8");
			res.setContentType("text/html;charset=UTF-8");	
            out = res.getWriter();
            String mode = req.getParameter("mode") != null ? req.getParameter("mode") : "";
			System.out.println( " MODE " + mode);
            if(mode.trim().equalsIgnoreCase("1"))
                insert(req, res, out);
            if(mode.trim().equalsIgnoreCase("2"))
                modify(req, res, out);            
        }catch(Exception e){
            out.println(e.toString());            
			e.printStackTrace();
        }
    }

    public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException
    {		
		PrintWriter out = null;
		try{
			out = res.getWriter();
            doPost(req, res);
        }catch(Exception e){
            out.println("Exception in invoking doPost Method");            
			e.printStackTrace();
        }
    }

    private void insert(HttpServletRequest req, HttpServletResponse res, PrintWriter out)
    {	
		Connection con = null;
		PreparedStatement pstmt = null;
		PreparedStatement pstmt1 = null;
		PreparedStatement pstmt2 = null;
		ResultSet rs = null;
	
		Properties p;
		HttpSession session;
		String  group_id = "", group_desc="";
		String enabled;
		int colIndex = 0;
	//	String riskFactor = "";//Common-ICN-0092  
	
		boolean insertSuccess = false;
        session = req.getSession(false);
		p = (Properties)session.getValue("jdbc");
		
		group_id	= req.getParameter("group_id") == null ? "": req.getParameter("group_id").trim();
		group_desc			= req.getParameter("group_desc") == null ? "": req.getParameter("group_desc").trim();		
		enabled			= req.getParameter("eff_status") == null ? "": req.getParameter("eff_status").trim() ;		
		
		if(enabled.equals("") || enabled.equals(null))
		{
			enabled = "D";
		}	
		
		String addedById="";
		String modifiedById="";
		String addedAtWorkstation="";
		String modifiedAtWorkstation="";
		
		String message1 	= "";
		String message2 	= "0";
		
	    String facilityId = (String)session.getValue("facility_id");
	    String client_ip_address = p.getProperty("client_ip_address");
		
		addedById = p.getProperty("login_user") != null ? p.getProperty("login_user") : "";
        addedAtWorkstation = client_ip_address != null ? client_ip_address : "";
	    modifiedById = p.getProperty("login_user") != null ? p.getProperty("login_user") : "";
	    modifiedAtWorkstation = client_ip_address != null ? client_ip_address : "";
		try
        {
			con = ConnectionManager.getConnection(req);
			pstmt = con.prepareStatement("select * from CA_GROUP_RISK_FACTOR_TYPE where RISK_FACTOR_GROUP=?");
			pstmt.setString(1,group_id);
			rs=pstmt.executeQuery();
			if(rs.next()){
				java.util.Hashtable hashtable = MessageManager.getMessage(p.getProperty("LOCALE"),"CODE_ALREADY_EXISTS","Common");                
				message1 = (java.lang.String)hashtable.get("message");					
			}else{
				pstmt1 = con.prepareStatement("INSERT INTO CA_GROUP_RISK_FACTOR_TYPE (RISK_FACTOR_GROUP,RISK_FACTOR_DESC,EFF_STATUS,ADDED_BY_ID,ADDED_DATE,ADDED_FACILITY_ID,ADDED_AT_WS_NO,MODIFIED_BY_ID,MODIFIED_DATE,MODIFIED_FACILITY_ID,MODIFIED_AT_WS_NO) VALUES(?,?,?,?,?,?,?,?,?,?,?)");
				
				pstmt1.setString(++colIndex,group_id);
				pstmt1.setString(++colIndex,group_desc);
				pstmt1.setString(++colIndex,enabled);
				pstmt1.setString(++colIndex, addedById);
				pstmt1.setTimestamp(++colIndex, new Timestamp(System.currentTimeMillis()));
				pstmt1.setString(++colIndex, facilityId);
				pstmt1.setString(++colIndex, addedAtWorkstation);
				pstmt1.setString(++colIndex, modifiedById);
				pstmt1.setTimestamp(++colIndex, new Timestamp(System.currentTimeMillis()));
				pstmt1.setString(++colIndex, facilityId);
				pstmt1.setString(++colIndex, modifiedAtWorkstation);	
				pstmt1.executeUpdate();
				insertSuccess = true;
			}
			if(insertSuccess == true)
			{	
				int isInserted = insertRiskFactorTypeForGroup(req, res, out, con);
				if(isInserted!=0){
					con.commit();
					java.util.Hashtable hashtable = MessageManager.getMessage(p.getProperty("LOCALE"),"RECORD_INSERTED","SM");                
					message1 = (java.lang.String)hashtable.get("message");
					message2 = "1";
				}else{
					try{
						con.rollback();
					}catch(Exception ee){
						ee.printStackTrace();
					}
					message1 = "Exception raise by Servlet..........So Record Not inserted.";							
				}
			}
            res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + URLEncoder.encode(message1,"UTF-8") + "&err_value=" + message2);
		}catch(Exception e){
			try{
				con.rollback();
				message1="Exception raise by Servlet ...So Record Not inserted  Foll: Error Received : "+ e.toString();
				res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + URLEncoder.encode(message1,"UTF-8") + "&err_value=" + message2);
			}catch(Exception ee){
				ee.printStackTrace();
			}
            e.printStackTrace();
        }finally{
			try{
				if (rs!= null) rs.close();
				if (pstmt!= null) pstmt.close();
				if (pstmt1!= null) pstmt1.close();
				if (pstmt2!= null) pstmt2.close();
				con.close();
			}
			catch(Exception ee){
				ee.printStackTrace();
			}
		} 
	}
	public int insertRiskFactorTypeForGroup(HttpServletRequest req, HttpServletResponse res, PrintWriter out, Connection con)
	{
		PreparedStatement pstmt = null;
	//	PreparedStatement pstmt2 = null;//Common-ICN-0092  
		Properties p;
		HttpSession session;
		
		String addedById="";
		String modifiedById="";
		String addedAtWorkstation="";
		String modifiedAtWorkstation="";
		String group_id = "";
		String riskFactor = "";
		String rowCount = "";
	//	int colIndex = 0;//Common-ICN-0092  
		int [] rowsInserted ;
		int insertedCount = 0;
		
		session = req.getSession(false);
		p = (Properties)session.getValue("jdbc");
	//	String mode = req.getParameter("mode") != null ? req.getParameter("mode") : "";//Common-ICN-0092 
		String facilityId = (String)session.getValue("facility_id");
	    String client_ip_address = p.getProperty("client_ip_address");
		
		
		group_id	= req.getParameter("group_id") == null ? "": req.getParameter("group_id").trim();
		rowCount 	= req.getParameter("rowID") == null ? "": req.getParameter("rowID") ;	
		
		
		addedById = p.getProperty("login_user") != null ? p.getProperty("login_user") : "";
        addedAtWorkstation = client_ip_address != null ? client_ip_address : "";
	    modifiedById = p.getProperty("login_user") != null ? p.getProperty("login_user") : "";
	    modifiedAtWorkstation = client_ip_address != null ? client_ip_address : "";
		
		try{
			pstmt = con.prepareStatement("INSERT INTO CA_GROUP_RISK_FACTOR_DTL (RISK_FACTOR_GROUP,RISK_FACTOR_TYPE,ADDED_BY_ID,ADDED_DATE,ADDED_AT_WS_NO,ADDED_FACILITY_ID,MODIFIED_BY_ID,MODIFIED_DATE,MODIFIED_AT_WS_NO,MODIFIED_FACILITY_ID) VALUES(?,?,?,?,?,?,?,?,?,?)");
			int rowCounter = Integer.parseInt(rowCount);
		
			for(int i=0; i <= rowCounter; i++)
			{	
				riskFactor = req.getParameter("risk_fact_code"+i)== null ? "": req.getParameter("risk_fact_code"+i).trim();
		
				if(!(riskFactor.equals(""))&& riskFactor != null){
					pstmt.setString(1,group_id);
					pstmt.setString(2,riskFactor);
					pstmt.setString(3, addedById);
					pstmt.setTimestamp(4, new Timestamp(System.currentTimeMillis()));
					pstmt.setString(5, addedAtWorkstation);
					pstmt.setString(6, facilityId);
					pstmt.setString(7, modifiedById);
					pstmt.setTimestamp(8, new Timestamp(System.currentTimeMillis()));
					pstmt.setString(9, modifiedAtWorkstation);
					pstmt.setString(10, facilityId);
					pstmt.addBatch();
				}
			}
			try {
				rowsInserted = pstmt.executeBatch();
				insertedCount = rowsInserted.length;
		
			} catch(BatchUpdateException e) {
				e.printStackTrace();
				// handle bad record, and re-batch the remaining?
			}	
		}catch(Exception e){
			e.printStackTrace();
			System.out.println("	RiskFactorGroupServlet.java  Error : "+e.getMessage());
		}
		finally{
			try{
				if (pstmt!= null) pstmt.close();
				
			}
			catch(Exception ee){
				ee.printStackTrace();
			}
		} 
		return insertedCount;	
	}
	private void modify(HttpServletRequest req, HttpServletResponse res, PrintWriter out)
    {	
		Connection con = null;

		PreparedStatement pstmt1 = null;
		PreparedStatement pstmt2 = null;

		Properties p;
		HttpSession session;
		String  group_id = "", group_desc="";
		String enabled;
		int colIndex = 0;
	//	String riskFactor = "";//Common-ICN-0092  
	
	//	boolean insertSuccess = false;//Common-ICN-0092  
        session = req.getSession(false);
		p = (Properties)session.getValue("jdbc");
		
		group_id	= req.getParameter("group_id") == null ? "": req.getParameter("group_id").trim();
		group_desc			= req.getParameter("group_desc") == null ? "": req.getParameter("group_desc").trim() ;		
		enabled			= req.getParameter("eff_status") == null ? "": req.getParameter("eff_status").trim() ;		
		
		if(enabled.equals("") || enabled.equals(null))
		{
			enabled = "D";
		}		
		
		String modifiedById="";
		String modifiedAtWorkstation="";
		
		String message1 	= "";
		String message2 	= "0";
		
	    String facilityId = (String)session.getValue("facility_id");
	    String client_ip_address = p.getProperty("client_ip_address");
		
	    modifiedById = p.getProperty("login_user") != null ? p.getProperty("login_user") : "";
	    modifiedAtWorkstation = client_ip_address != null ? client_ip_address : "";
		try
        {
			con = ConnectionManager.getConnection(req);
			pstmt1 = con.prepareStatement("UPDATE  CA_GROUP_RISK_FACTOR_TYPE set RISK_FACTOR_DESC = ? , EFF_STATUS = ? , MODIFIED_BY_ID = ? , MODIFIED_DATE = ? , MODIFIED_FACILITY_ID = ? , MODIFIED_AT_WS_NO = ? where RISK_FACTOR_GROUP = ?");
							
			pstmt1.setString(++colIndex,group_desc);
			pstmt1.setString(++colIndex,enabled);
			pstmt1.setString(++colIndex, modifiedById);
			pstmt1.setTimestamp(++colIndex, new Timestamp(System.currentTimeMillis()));
			pstmt1.setString(++colIndex, facilityId);
			pstmt1.setString(++colIndex, modifiedAtWorkstation);	
			pstmt1.setString(++colIndex,group_id);
			int insertCount = pstmt1.executeUpdate();
			
			if(insertCount > 0)
			{	
				int isInserted = 0;
				pstmt2 =  con.prepareStatement("delete from CA_GROUP_RISK_FACTOR_DTL where RISK_FACTOR_GROUP=?");
				pstmt2.setString(1,group_id);
				pstmt2.executeUpdate();
				
				isInserted = insertRiskFactorTypeForGroup(req, res, out, con);
				if(isInserted!=0){
					con.commit();
					java.util.Hashtable hashtable = MessageManager.getMessage(p.getProperty("LOCALE"),"RECORD_INSERTED","SM");                
					message1 = (java.lang.String)hashtable.get("message");
					message2 = "1";
				}else{
					try{
						con.rollback();
					}catch(Exception ee){
						ee.printStackTrace();
					}
					message1 = "Exception raise by Servlet..........So Record Not inserted.";							
				}
			}
            res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + URLEncoder.encode(message1,"UTF-8") + "&err_value=" + message2);
		}catch(Exception e){
			try{
				con.rollback();
				message1="Exception raise by Servlet ...So Record Not inserted  Foll: Error Received : "+ e.toString();
				res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + URLEncoder.encode(message1,"UTF-8") + "&err_value=" + message2);
			}catch(Exception ee){
				ee.printStackTrace();
			}
            e.printStackTrace();
        }finally{
			try{
				if (pstmt1!= null) pstmt1.close();
				if (pstmt2!= null) pstmt2.close();
				con.close();
			}
			catch(Exception ee){
				ee.printStackTrace();
			}
		} 
	}
}
