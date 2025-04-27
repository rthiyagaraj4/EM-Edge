/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eIPAD.login.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import webbeans.eCommon.ConnectionManager;

/**
 * Servlet implementation class IpadLoginServlet
 */
public class IpadLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public IpadLoginServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession(true);
		String login_user= (String)session.getAttribute("login_user");
		String facility_id= (String)session.getAttribute("facility_id");
		
		if(login_user == null || login_user.trim().equals("")){
			authenticateUser(request,response,session);
		}
		else if(facility_id == null || facility_id.trim().equals("")){
			selectRespFacility(request,response,session);
		}
		else{
			//this case occurs when the user refreshes the login page even after successful authentication
			authenticateUser(request,response,session);
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
	private void authenticateUser(HttpServletRequest request, HttpServletResponse response, HttpSession session) throws ServletException, IOException{
		RequestDispatcher rd = session.getServletContext().getRequestDispatcher("/eIPAD/jsp/LoginIpad-newUI.jsp");
		rd.forward(request, response);
	}
	
	private void selectRespFacility(HttpServletRequest request, HttpServletResponse response, HttpSession session)throws ServletException, IOException{
		//setting  product version and description in session
		Connection conn = null;
		try{
			conn = ConnectionManager.getConnection(request);
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			String sql="select a.PRODUCT_NAME PRODUCT_NAME,a.PRODUCT_DESCRIPTION PRODUCT_DESCRIPTION,a.VERSION_NO VERSION_NO,a.COPYRIGHT_INFO COPYRIGHT_INFO,b.CUSTOMER_ID CUSTOMER_ID from sm_installation a,sm_site_param b";
			try{
				pstmt = conn.prepareStatement(sql);
				rs = pstmt.executeQuery();
				if (rs != null && rs.next()){
					session.setAttribute("CUSTOMER_ID", rs.getString("CUSTOMER_ID")==null?"":rs.getString("CUSTOMER_ID"));
					session.setAttribute("version_no",rs.getString("VERSION_NO")==null?"":rs.getString("VERSION_NO"));
					session.setAttribute("product_description",rs.getString("PRODUCT_DESCRIPTION")==null?"":rs.getString("PRODUCT_DESCRIPTION"));
					session.setAttribute("product_name",rs.getString("PRODUCT_NAME")==null?"":rs.getString("PRODUCT_NAME"));
				}
			}
			catch(SQLException e){
				System.out.println("Login: SQL Exception occured while getting product details" +e.toString());
				e.printStackTrace();
			}
			finally{
				if(pstmt!=null)  pstmt.close();
				if(rs!=null)  rs.close();
				 ConnectionManager.returnConnection(conn, request);
			}
		}
		catch(Exception e){
			System.out.println("Login: Exception occured while creating connection" +e.toString());
			e.printStackTrace();
		}
		finally{
			if(conn!=null) ConnectionManager.returnConnection(conn, request);
			
			
		}
	
		//Building facility and responsibility list
		String RespFacilityString = request.getParameter("RespFaciList");
		String[] RespFacilityArray;
		String[] RespCountArray = null;
		String[] FacilityCountArray = null;
		String[] RespArray = null;
		String[] FacilityArray = null;
		
		ArrayList<String> RespIdArray = new ArrayList<String>();
		ArrayList<String> RespNameArray = new ArrayList<String>();
		ArrayList<String> FacilityIDArray = new ArrayList<String>();
		ArrayList<String> FacilityNameArray = new ArrayList<String>();
		int RespCount = 0;
		int FacilityCount = 0;
		RequestDispatcher rd;
		if(RespFacilityString!=null && !RespFacilityString.equals("")){
			RespFacilityArray = RespFacilityString.split("==");
			if(RespFacilityArray!=null && RespFacilityArray.length>=2){
				RespCountArray = RespFacilityArray[0].split("\\$\\$");
				FacilityCountArray = RespFacilityArray[1].split("\\$\\$");
			}
				
			if(RespCountArray!=null && RespCountArray.length>=2){
				RespCount = Integer.parseInt(RespCountArray[0]);
				RespArray = RespCountArray[1].split("\\^\\^");
			}
			if(FacilityCountArray!=null && FacilityCountArray.length>=2){
				FacilityCount = Integer.parseInt(FacilityCountArray[0]);
				FacilityArray = FacilityCountArray[1].split("\\^\\^");
			}
			
			if(RespArray!= null){
				for(int i=0; i<RespArray.length; i++){
					String eachRespName_ID[] = RespArray[i].split("~");
					RespIdArray.add(i, eachRespName_ID[0]);
					RespNameArray.add(i, eachRespName_ID[1]);
					
				}
			}
			if(FacilityArray!= null){
				for(int i=0; i<FacilityArray.length; i++){
					String eachFacilityName_ID[] = FacilityArray[i].split("~");
					FacilityIDArray.add(i, eachFacilityName_ID[0]);
					FacilityNameArray.add(i, eachFacilityName_ID[1]);
				}
			}
		}
		
		if(RespCount > 0 && FacilityCount > 0){
			
			if(RespCount == 1 && FacilityCount == 1){
				
				session.setAttribute("responsibility_id", RespIdArray.get(0));
				session.setAttribute("responsibility_name", RespNameArray.get(0));
				session.setAttribute("facility_id", FacilityIDArray.get(0));
				session.setAttribute("facility_name", FacilityNameArray.get(0));
				response.sendRedirect("/eIPAD/jsp/IPad.jsp");
/*				rd = session.getServletContext().getRequestDispatcher("/eIPAD/jsp/IPad.jsp");
				rd.forward(request, response);*/	
			}
			else{
				request.setAttribute("LoginRespIdArray", RespIdArray);
				request.setAttribute("LoginRespNameArray", RespNameArray);
				request.setAttribute("LoginRespCount", RespCount);
				request.setAttribute("LoginFacilityIdArray", FacilityIDArray);
				request.setAttribute("LoginFacilityNameArray", FacilityNameArray);
				request.setAttribute("LoginFacilityCount", FacilityCount);
			}
				
			rd = session.getServletContext().getRequestDispatcher("/eIPAD/jsp/LoginRFSelect-newUI.jsp");
			rd.forward(request, response);	
			
		}
		else{
			rd = session.getServletContext().getRequestDispatcher("/eIPAD/jsp/LoginIpad-newUI.jsp");
			rd.forward(request, response);	
		}

	}
	
	

}
