/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
/*
--------------------------------------------------------------------------------------------------------------
Date			Edit History		Name                 	Rev.Date 		Rev.by 					Description
--------------------------------------------------------------------------------------------------------------
42761      21/03/2023        krishna Pranay      21/03/2023     Ramesh Goli        COMMON-ICN-0125
--------------------------------------------------------------------------------------------------------------
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

public class HealthRiskFactorsForDiseaseServlet extends HttpServlet {
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
           /* if(mode.trim().equalsIgnoreCase("2"))
                modify(req, res, out);       */     
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
		//PreparedStatement pstmt2 = null;
		ResultSet rs = null;
	
		Properties p;
		HttpSession session;
	
		String term_set = "";
		String diagprob_code = "";
		String riskFactor = "";
		//String search_by = "";//15950
		String mandatory_yn = "";
		
		int insertedCount = 0;
		//boolean insertSuccess = false;//15950
        
		session = req.getSession(false);
		p = (Properties)session.getValue("jdbc");
		
		term_set = req.getParameter("terminology_set") == null ? "": req.getParameter("terminology_set").trim();
		diagprob_code = req.getParameter("diagprob_code") == null ? "": req.getParameter("diagprob_code").trim();
		
		String addedById="";
		String modifiedById="";
		String addedAtWorkstation="";
		String modifiedAtWorkstation="";
		String rowCount = "";
		String risk_group_type = "";
		String message1 	= "";
		String message2 	= "0";
		//boolean addedBatch = false;//15950
		
	    String facilityId = (String)session.getValue("facility_id");
	    String client_ip_address = p.getProperty("client_ip_address");
	
		rowCount 	= req.getParameter("rowID") == null ? "": req.getParameter("rowID") ;	
		int rowCounter = Integer.parseInt(rowCount);
		addedById = p.getProperty("login_user") != null ? p.getProperty("login_user") : "";
        addedAtWorkstation = client_ip_address != null ? client_ip_address : "";
	    modifiedById = p.getProperty("login_user") != null ? p.getProperty("login_user") : "";
	    modifiedAtWorkstation = client_ip_address != null ? client_ip_address : "";
		
		try {
			con = ConnectionManager.getConnection(req);
			pstmt = con.prepareStatement(" Delete from CA_DIAG_RISK_FACTOR where TERM_SET_ID = ? and TERM_SET_CODE =? ");
			pstmt.setString(1,term_set);
			pstmt.setString(2,diagprob_code);
			pstmt.executeUpdate();
			
			if (pstmt!= null) pstmt.close();//15950
			pstmt1 = con.prepareStatement("INSERT INTO CA_DIAG_RISK_FACTOR (RISK_GRP_TYPE,RISK_FACTOR,TERM_SET_ID,TERM_SET_CODE,FACTOR_MAND_YN,ADDED_BY_ID,ADDED_DATE,ADDED_AT_WS_NO,ADDED_FACILITY_ID,MODIFIED_BY_ID,MODIFIED_DATE,MODIFIED_AT_WS_NO,MODIFIED_FACILITY_ID) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?)");
			for(int i=0; i <= rowCounter; i++){	
				riskFactor = req.getParameter("risk_fact_code"+i)== null ? "": req.getParameter("risk_fact_code"+i).trim();
				mandatory_yn	 = req.getParameter("mandatory"+i) == null ? "N": req.getParameter("mandatory"+i).trim();	
				risk_group_type	 = req.getParameter("search_by"+i) == null ? "": req.getParameter("search_by"+i).trim();
				if(!(riskFactor.equals(""))&& riskFactor != null){
					pstmt = con.prepareStatement("select * from CA_DIAG_RISK_FACTOR where RISK_GRP_TYPE=? and RISK_FACTOR = ? and TERM_SET_ID = ? and TERM_SET_CODE =?");
					pstmt.setString(1,risk_group_type);
					pstmt.setString(2,riskFactor);
					pstmt.setString(3,term_set);
					pstmt.setString(4,diagprob_code);
					rs=pstmt.executeQuery();
					if(rs.next()){
						java.util.Hashtable hashtable = MessageManager.getMessage(p.getProperty("LOCALE"),"CODE_ALREADY_EXISTS","Common");	message1 = (java.lang.String)hashtable.get("message");
		
					}else{
						
						//int colIndex = 0;//15950	
						pstmt1.setString(1,risk_group_type);
						pstmt1.setString(2,riskFactor);
						pstmt1.setString(3,term_set);
						pstmt1.setString(4,diagprob_code);
						pstmt1.setString(5,mandatory_yn);
						pstmt1.setString(6, addedById);
						pstmt1.setTimestamp(7, new Timestamp(System.currentTimeMillis()));
						pstmt1.setString(8, addedAtWorkstation);
						pstmt1.setString(9, facilityId);
						pstmt1.setString(10, modifiedById);
						pstmt1.setTimestamp(11, new Timestamp(System.currentTimeMillis()));
						pstmt1.setString(12, modifiedAtWorkstation);	
						pstmt1.setString(13, facilityId);
						pstmt1.addBatch();
						insertedCount ++ ;
					}
					if(rs!=null) rs.close();//Common-ICN-0092  
					if(pstmt!=null) pstmt.close();//42761

				}	
			}	
		
			try {
				
				if(insertedCount >0){
					pstmt1.executeBatch();
					con.commit();
					java.util.Hashtable hashtable = MessageManager.getMessage(p.getProperty("LOCALE"),"RECORD_INSERTED","SM");                
					message1 = (java.lang.String)hashtable.get("message");
					message2 = "1";
				}
			} catch(BatchUpdateException e) {
				e.printStackTrace();
				// handle bad record, and re-batch the remaining?
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
				if (pstmt1!= null) pstmt1.close();//Common-ICN-0092  
				if (pstmt!= null) pstmt.close();//Common-ICN-0092  
				con.close();
			}
			catch(Exception ee){
				ee.printStackTrace();
			}
		} 
	}
}
