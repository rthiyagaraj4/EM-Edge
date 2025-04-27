/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
/*
-----------------------------------------------------------------------
Date       Edit History      Name        	Description
-----------------------------------------------------------------------
?             100            ?           	created
12/04/2013    IN30708        Karthi      To incorporate the "Symbol" function  from Microsoft words to the Microsoft Editor in the clinical notes.
-----------------------------------------------------------------------
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

public class CASymbolGroupServlet extends HttpServlet {
    public void init(ServletConfig servletconfig) throws ServletException {
        super.init(servletconfig);
    }

    public  void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		PrintWriter out = null;
		try{
            req.setCharacterEncoding("UTF-8");
			res.setContentType("text/html;charset=UTF-8");	
            out = res.getWriter();
            String mode = req.getParameter("mode") != null ? req.getParameter("mode") : "";
			if(mode.trim().equalsIgnoreCase("1"))
                insert(req, res, out);
			if(mode.trim().equalsIgnoreCase("2"))
                modify(req, res, out);     
        }catch(Exception e){
            out.println(e.toString());            
			e.printStackTrace();
        }
    }

    public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {		
		PrintWriter out = null;
		try{
			out = res.getWriter();
            doPost(req, res);
        }catch(Exception e){
            out.println("Exception in invoking doPost Method");            
			e.printStackTrace();
        }
    }

    private void insert(HttpServletRequest req, HttpServletResponse res, PrintWriter out){	
		Connection con = null;
		PreparedStatement pstmt = null;
		PreparedStatement pstmt1 = null;
		ResultSet rs = null;
	
		Properties p;
		HttpSession session;
	
		session = req.getSession(false);
		p = (Properties)session.getValue("jdbc");
		
		
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
		
		String symbolGrp = req.getParameter("group_id")==null ? "": req.getParameter("group_id").trim();
		int isInserted = 0;
		try {
			con = ConnectionManager.getConnection(req);
			pstmt = con.prepareStatement(" select * from CA_SYMBOL_GROUP where SYMBOL_GROUP = ? ");
			pstmt.setString(1,symbolGrp);
			rs = pstmt.executeQuery();
			if(rs.next()){ 
				java.util.Hashtable hashtable = MessageManager.getMessage(p.getProperty("LOCALE"),"CODE_ALREADY_EXISTS","Common");
				message1 = (java.lang.String)hashtable.get("message");		
			}
			else
			{
				isInserted = insertNoteTypeRecords(req, res, con);
				if(isInserted != 0){
					con.commit();
					java.util.Hashtable hashtable = MessageManager.getMessage(p.getProperty("LOCALE"),"RECORD_INSERTED","SM");               
					message1 = (java.lang.String)hashtable.get("message");
					message2 = "1";
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
				con.close();
			}
			catch(Exception ee){
				ee.printStackTrace();
			}
		} 
	}
	
	private void modify(HttpServletRequest req, HttpServletResponse res, PrintWriter out)
    {	
		Connection con = null;
		PreparedStatement pstmt2 = null;
		ResultSet rs = null;
	
		Properties p;
		HttpSession session;
	
		session = req.getSession(false);
		p = (Properties)session.getValue("jdbc");
		
		
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
		
		String symbolGrp = req.getParameter("group_id")==null ? "": req.getParameter("group_id").trim();
		int insertedRow = 0;
		
		try
        {
			int isInserted = 0;
			con = ConnectionManager.getConnection(req);
			
			pstmt2 =  con.prepareStatement("delete from CA_SYMBOL_GROUP where SYMBOL_GROUP = ?");
			pstmt2.setString(1,symbolGrp);
			int isdeleted = pstmt2.executeUpdate();
				
			isInserted = insertNoteTypeRecords(req, res, con);
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
				if (pstmt2!= null) pstmt2.close();
				con.close();
			}
			catch(Exception ee){
				ee.printStackTrace();
			}
		} 
	}
	
	private int insertNoteTypeRecords(HttpServletRequest req, HttpServletResponse res, Connection con){
		
		int insertedCount = 0;
		int [] rowsInserted ;
		
		PreparedStatement pstmt1 = null;
		
		Properties p;
		HttpSession session;
	
		session = req.getSession(false);
		p = (Properties)session.getValue("jdbc");
				
		String addedById="";
		String modifiedById="";
		String addedAtWorkstation="";
		String modifiedAtWorkstation="";
		
	    String facilityId = (String)session.getValue("facility_id");
	    String client_ip_address = p.getProperty("client_ip_address");
		
		addedById = p.getProperty("login_user") != null ? p.getProperty("login_user") : "";
        addedAtWorkstation = client_ip_address != null ? client_ip_address : "";
	    modifiedById = p.getProperty("login_user") != null ? p.getProperty("login_user") : "";
	    modifiedAtWorkstation = client_ip_address != null ? client_ip_address : "";
		
		String symbolGrp = req.getParameter("group_id")==null ? "": req.getParameter("group_id").trim();
		String symbolGrpDesc = req.getParameter("group_desc")==null ? "": req.getParameter("group_desc");
		String rowCount = req.getParameter("rowID")==null ? "": req.getParameter("rowID").trim();
		String effStatus =  req.getParameter("eff_status")==null ? "": req.getParameter("eff_status");
		String noteIndicator = "";
		String noteGroupId = "";
		int noOfRows = Integer.parseInt(rowCount);
		if(effStatus == null || effStatus.equals(""))
		{
			effStatus = "D";
		}
		try{ 
			String insertSql = "INSERT INTO CA_SYMBOL_GROUP (SYMBOL_GROUP, SYMBOL_GRP_NOTE_IND, SYMBOL_GRP_NOTE, SYMBOL_GROUP_DESC, EFF_STATUS, ADDED_BY_ID, ADDED_DATE, ADDED_FACILITY_ID, ADDED_AT_WS_NO, MODIFIED_BY_ID, MODIFIED_DATE, MODIFIED_FACILITY_ID, MODIFIED_AT_WS_NO) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?)";
			pstmt1 = con.prepareStatement(insertSql);
			for(int i=0; i <= noOfRows; i++) {
				noteGroupId = req.getParameter("note_group_id"+i ) == null ? "" : req.getParameter("note_group_id"+i).trim();
				noteIndicator = req.getParameter("search_by"+i ) == null ? "" : req.getParameter("search_by"+i).trim();
				if((!(noteIndicator.equals("")) && noteIndicator != null ) && (!(noteGroupId.equals("")) && noteGroupId != null )) {
					pstmt1.setString(1, symbolGrp);
					pstmt1.setString(2, noteIndicator);
					pstmt1.setString(3, noteGroupId);
					pstmt1.setString(4, symbolGrpDesc);
					pstmt1.setString(5, effStatus);
					pstmt1.setString(6, addedById);
					pstmt1.setTimestamp(7, new Timestamp(System.currentTimeMillis()));
					pstmt1.setString(8, facilityId);
					pstmt1.setString(9, addedAtWorkstation);
					pstmt1.setString(10, modifiedById);
					pstmt1.setTimestamp(11, new Timestamp(System.currentTimeMillis()));
					pstmt1.setString(12, facilityId);
					pstmt1.setString(13, modifiedAtWorkstation);
					pstmt1.addBatch();
				}
			}
			try {
				rowsInserted = pstmt1.executeBatch();
				insertedCount = rowsInserted.length;
			} catch(BatchUpdateException e) {
				e.printStackTrace();
			}		
		}
		catch(Exception ex) {
			ex.printStackTrace();
			System.out.println(" CASymbolGroupServlet.java Error : "+ex.getMessage());
		}
		finally{
			try{
				if (pstmt1!= null) pstmt1.close();
			}
			catch(Exception ee){
				ee.printStackTrace();
			}
		} 
		return insertedCount;
	}
}
