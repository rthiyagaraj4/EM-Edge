/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
 /**
Sr No        Version              TFS              SCF/CRF           		   Developer Name
-----------------------------------------------------------------------------------------------
1            V210416             17021        	Common-ICN-0009-TF	           Mohana Priya K
2			V230210								MMS-DM-CRF-0209.5			Namrata Charate
 */
 
package eBL;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.sql.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.io.*;
import java.util.*;
import java.text.SimpleDateFormat;

import webbeans.eCommon.ConnectionManager;

import eCommon.Common.CommonAdapter;
import webbeans.eCommon.*;
import eBL.Common.*;
import eBL.Common.BlAdapter;

/**
 * Servlet implementation class BLColorIndctrServlet
 */
public class BLColorIndctrServlet extends HttpServlet {
	PrintWriter out;
	HttpSession session;
	Connection con = null;
	PreparedStatement pstmt = null;
	//ResultSet rs = null;
	//HashMap support_data = new HashMap();
	String msg="";
	Boolean isUpdateSuccess=false;
	public HashMap colorTimeValues		= new HashMap();
	StringBuffer sb = new StringBuffer();

    /**
     * @see HttpServlet#HttpServlet()
     */
    public BLColorIndctrServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String error_value = "0" ;
		String error = "";
		String facId=(String)request.getParameter("facilityId");
		String loginUser=(String)request.getParameter("loginUser");
		String WS_NO=(String)request.getParameter("WS_NO");
		String saveMode=(String)request.getParameter("modeType");
		
		try {
			request.setCharacterEncoding("UTF-8");
			response.setContentType("text/html;charset=UTF-8");
			this.out = response.getWriter();
			//int z = 6; //commented V210416
			int row=0;
			int idCount=0;				
			con	=	ConnectionManager.getConnection(request);
			con.setAutoCommit(false);
			java.util.Date d1 = new java.util.Date();
			SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
			String formattedDate = df.format(d1);
			
			String mul_fact_ded_rule_YN = (String)request.getParameter("mul_fact_ded_rule_YN");
			System.err.println("Inside Servlet mul_fact_ded_rule_YN:"+mul_fact_ded_rule_YN);
			String drugCat_YN = (String)request.getParameter("drug_cat_YN");
			String diagCat_YN = (String)request.getParameter("diag_cat_YN");
			String serv_item_Cat_YN = (String)request.getParameter("service_items_YN"); //V230210
			System.err.println("Inside Servlet drugCat_YN: "+drugCat_YN+" diagCat_YN: "+diagCat_YN+" serv_item_Cat_YN: "+serv_item_Cat_YN);
			if(saveMode.equals("update")) {
				String finArrValues=(String)request.getParameter("finArrIds");
				System.err.println("finArrValues:"+finArrValues);
				if(!"".equals(finArrValues)){
					String[] arrOfIds = finArrValues.split("~~"); 
					
					idCount=arrOfIds.length;
					//for (String f : arrOfIds) 
					int col=0;
				
					for (String x : arrOfIds){
						String reqStatus="";
						String reqDescStatus=(String)request.getParameter("reqStatus"+x);
						if(reqDescStatus.equals("Pending")){
							reqStatus="P";
						}else if(reqDescStatus.equals("Sent To Insurance")){
							reqStatus="S";
						}else if(reqDescStatus.equals("Hold")){
							reqStatus="H";
						}else if(reqDescStatus.equals("Approved")){
							reqStatus="A";
						}else if(reqDescStatus.equals("Rejected")){
							reqStatus="R";
						}else if(reqDescStatus.equals("Clarification")){
							reqStatus="C";
						}
						

						String strQuery="UPDATE BL_COLOR_INDICATOR_RULE_STATUS set FACILITY_ID=?,REQUEST_STATUS=?,TIME_LIMIT=?,COLOR_CODE=?,MODIFIED_BY_ID=?,MODIFIED_AT_WS_NO=?,MODIFIED_DATE=to_date(?,'dd/MM/yyyy hh24:mi:ss'),MODIFIED_FACILITY_ID=?,REQUEST_STATUS_DESC=? where FACILITY_ID=? and REQUEST_STATUS=?";
						pstmt = con.prepareStatement(strQuery);
						//ML--MMOH-CRF-0600 - Changed as ++count instead of numeric values
						pstmt.setString(1,facId);
						pstmt.setString(2,reqStatus);
						pstmt.setString(3,(String)request.getParameter("timeLimit"+x));
						
						String checkColInd = (String)request.getParameter("colIndc"+x);
						
						if(checkColInd == null)
							checkColInd = "";
						
						pstmt.setString(4,checkColInd);
						pstmt.setString(5,loginUser);
						pstmt.setString(6,WS_NO);
						pstmt.setString(7,formattedDate);
						pstmt.setString(8,facId);
						pstmt.setString(9,reqDescStatus);
						pstmt.setString(10,facId);
						pstmt.setString(11,reqStatus);
						col=pstmt.executeUpdate();
						row+=col;
					}
					if (row==idCount)
					{
						isUpdateSuccess = true;
						con.commit();				
					}
					else{
						isUpdateSuccess = false;
						con.rollback();
					}
				} else {
					isUpdateSuccess = true;
				}
			}
			else if(saveMode.equals("insert")) {
				int col=0;
				for(int x=1;x<=6;x++){
					String reqStatus="";
					String reqDescStatus=(String)request.getParameter("reqStatus"+x);
					if(reqDescStatus.equals("Pending")){
						reqStatus="P";
					}else if(reqDescStatus.equals("Sent To Insurance")){
						reqStatus="S";
					}else if(reqDescStatus.equals("Hold")){
						reqStatus="H";
					}else if(reqDescStatus.equals("Approved")){
						reqStatus="A";
					}else if(reqDescStatus.equals("Rejected")){
						reqStatus="R";
					}else if(reqDescStatus.equals("Clarification")){
						reqStatus="C";
					}
					String strQuery="INSERT INTO BL_COLOR_INDICATOR_RULE_STATUS (FACILITY_ID,REQUEST_STATUS,TIME_LIMIT,COLOR_CODE,ADDED_BY_ID,ADDED_AT_WS_NO,ADDED_DATE,ADDED_FACILITY_ID,MODIFIED_BY_ID,MODIFIED_AT_WS_NO,MODIFIED_DATE,MODIFIED_FACILITY_ID,REQUEST_STATUS_DESC) VALUES(?,?,?,?,?,?,to_date(?,'dd/MM/yyyy hh24:mi:ss'),?,?,?,to_date(?,'dd/MM/yyyy hh24:mi:ss'),?,?)";
					pstmt = con.prepareStatement(strQuery);
					//ML--MMOH-CRF-0600 - Changed as ++count instead of numeric values
					pstmt.setString(1,facId);
					pstmt.setString(2,reqStatus);
					pstmt.setString(3,(String)request.getParameter("timeLimit"+x));
					pstmt.setString(4,(String)request.getParameter("colInd"+x));
					pstmt.setString(5,loginUser);
					pstmt.setString(6,WS_NO);
					pstmt.setString(7,formattedDate);
					pstmt.setString(8,facId);
					pstmt.setString(9,loginUser);
					pstmt.setString(10,WS_NO);
					pstmt.setString(11,formattedDate);
					pstmt.setString(12,facId);
					pstmt.setString(13,reqDescStatus);
					col=pstmt.executeUpdate();
					row+=col;
				}
				if (row==6)
				{
					isUpdateSuccess = true;
					con.commit();				
				}
				else{
					isUpdateSuccess = false;
					con.rollback();
				}
			}
			
			if(isUpdateSuccess){
				int col=0;
				String strQuery="UPDATE BL_PARAMETERS set MULTI_FACTOR_DED_RULE_APPL_YN=?, MFDR_DRUG_CAT_APPL_YN=?, MFDR_DIAG_CAT_APPL_YN=?, MFDR_SERV_ITEM_CAT_APPL_YN=? where OPERATING_FACILITY_ID=?"; //V230210
				pstmt = con.prepareStatement(strQuery);
				pstmt.setString(1,mul_fact_ded_rule_YN);
				pstmt.setString(2,drugCat_YN);
				pstmt.setString(3,diagCat_YN);
				pstmt.setString(4,serv_item_Cat_YN);  //V230210
				pstmt.setString(5,facId);
				col=pstmt.executeUpdate();
				
				if(col == 1){
					isUpdateSuccess = true;
					con.commit();				
				}
				else{
					isUpdateSuccess = false;
					con.rollback();
				}
			}
		
			if(isUpdateSuccess){
				//con.commit();		
				error_value = "1" ;
				error = "APP-SM0070 Operation Completed Successfully ....";
			}else{
				//con.rollback();	
				error_value = "0" ;
				error = "Record has not been saved. Please try again";			
			}
			response.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode(error,"UTF-8"  )+"&err_value="+error_value );			
			
			if(pstmt!=null){
				pstmt.close();
			}
		}catch(SQLException sqle){
			System.err.println("164,SQLException in BLColorIndctrServlet.java" + sqle.toString());
			sqle.printStackTrace();
			isUpdateSuccess = false;
		}catch(Exception e){
			System.err.println("168,Exception in BLColorIndctrServlet.java" + e.toString());
			e.printStackTrace();
			isUpdateSuccess = false;
			//con.rollback();	
		}finally{
			try{
				if(isUpdateSuccess){
					con.commit();
				}else{  
					con.rollback();
				}
				if(pstmt!=null){ pstmt.close();
				}
				if(con!=null){ 
					//ConnectionManager.returnConnection(con);
					con.close();
				}
				else{
					con.close();
				}
				}catch(Exception e){
					e.printStackTrace();	
					System.err.println("Final catch excep in BLColorIndctrServlet.java" + e.toString());				
				}
		}
	}
}
