/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eXH;

import java.lang.reflect.Method;
import java.net.*;
import java.sql.*;
import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import webbeans.eCommon.ConnectionManager;
import webbeans.eCommon.*; 
import eXH.XHDBAdapter;
import eXH.ArrayAuditInfo;
import eXH.XHTYPE;
import eXH.*;
import eCommon.Common.*;
//import webbeans.eCommon.ConnectionManager;

import com.ehis.persist.PersistenceHelper;

import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**																	  						 
 *  Class used to update autorized users setup
 * 
 */
public class MachineForDispenserServlet extends HttpServlet
{

	java.util.Properties prop;
	HttpSession session;
	private String locale = "";
	String facility_id="";
	String client_ip_address="";
	String login_user="";

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		System.out.println(" ::: Reached Servlet MachineForDispenserServlet ::: ");

		String mode = "";
		PrintWriter out;
		out=response.getWriter();
		//req=request;
        HttpSession session=request.getSession(false);
		RequestDispatcher reqDis=null;
		int result = 0;
		String error = "";
		int rowCount = 0;
		





		//totalRecords=Integer.parseInt((String)request.getParameter("totalCount"));
		mode = request.getParameter("mode");
		

		System.out.println("MachineForDispenserServlet doPost :: Mode :: "+mode);

			if(mode.equals("U")){
				result = updateData(request, response);
			}else if(mode.equals("I")){

				rowCount = Integer.parseInt((String)request.getParameter("rowCount"));
				System.out.println(" ::: Row Count ::: "+rowCount);

				for(int i = 0; i < rowCount;i++){
					if(XHDBAdapter.checkNull(request.getParameter("Machine_Code"+i)).length() != 0 ){
					result = insertData(request, response, i);
					}
				}
			}

			this.locale  = (String) session.getAttribute("LOCALE");
			System.out.println("locale ::: "+this.locale);
			MessageManager mm = new MessageManager();
			if(result == 1){
			
			System.out.println("Operation Completed Successfully ....");
			final java.util.Hashtable mesg = mm.getMessage(locale, "XH1001", "XH") ;
			error = ((String) mesg.get("message"));
			
			reqDis = 	session.getServletContext().
			getRequestDispatcher("/eXH/jsp/DisplayResult.jsp?message="+error+"&fun_id=xyz");
			reqDis.forward(request,response);
		}
		else if(result == 0){
			
			System.out.println("Atleast one record entered...");
			final java.util.Hashtable mesg = mm.getMessage(locale, "ATLEAST_ONE_RECORD_ENTERED", "Common") ;
			error = ((String) mesg.get("message"));
			
			reqDis = 	session.getServletContext().
			getRequestDispatcher("/eXH/jsp/DisplayResult.jsp?message="+error+"&fun_id=xyz");
			reqDis.forward(request,response);
		}
		else if(result == 2){
			
			System.out.println("Error operation failed....");

			final java.util.Hashtable mesg = mm.getMessage(locale, "XH1000", "XH") ;
			error = ((String) mesg.get("message"));
		
			reqDis = 	session.getServletContext().
			getRequestDispatcher("/eXH/jsp/DisplayResult.jsp?message="+error+"&fun_id=xyz");
			reqDis.forward(request,response);
		}
		else if(result == 3){
			
			System.out.println("Record Already Exists....");

			final java.util.Hashtable mesg = mm.getMessage(locale, "CODE_ALREADY_EXISTS", "Common") ;
			error = ((String) mesg.get("message"));
		
			reqDis = 	session.getServletContext().
			getRequestDispatcher("/eXH/jsp/DisplayResult.jsp?message="+error+"&fun_id=xyz");
			reqDis.forward(request,response);
		}		

	}

	private int updateData(HttpServletRequest request, HttpServletResponse response) {
		System.out.println(" MachineForDispenserServlet updateData :::");

		int rslt = 0;
		int err_no = 0;
		String updateQuery = "";
		Connection dbConn = null;
        PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String machine_code = "",  long_desc = "",  short_desc = "",  eff_status = "";

		session=request.getSession(false);
		String locale = request.getParameter("locale");
		System.out.println("locale.."+locale);

		try{

			machine_code = XHDBAdapter.checkNull(request.getParameter("machineCode"));
			long_desc = XHDBAdapter.checkNull(request.getParameter("longDesc"));
			short_desc = XHDBAdapter.checkNull(request.getParameter("shortDesc"));
			eff_status = XHDBAdapter.checkNull(request.getParameter("effStatus"));

			System.out.println(" MachineForDispenserServlet updateData values ::: machineCode :"+machine_code+" longDesc : "+long_desc+" shortDesc : "+short_desc+" effStatus : "+eff_status);
			
			updateQuery = " UPDATE XH_DISP_MACHINE_CODES SET LONG_DESC = ?, SHORT_DESC = ?, EFF_STATUS = ? WHERE MACHINE_CODE = ?";

			System.out.println("updateQuery ::: "+updateQuery);

			dbConn = ConnectionManager.getConnection();
				
			pstmt = dbConn.prepareStatement(updateQuery);

			pstmt.setString(1, long_desc);
			pstmt.setString(2, short_desc);
			pstmt.setString(3, eff_status);
			pstmt.setString(4, machine_code);

			rslt = pstmt.executeUpdate();
			err_no = 1;
			dbConn.commit();
			//MessageManager mm=new MessageManager();

			System.out.println("updateCount ..."+rslt+" :: err_no :: "+err_no);

		}catch(Exception e){
			System.err.println("Error in MachineForDispenserServlet updateData :: " + e);
			e.printStackTrace();
			err_no = 2;
		}finally{
			XHUtil.closeDBResources(rs, pstmt, dbConn);
		}
		return err_no;
	}

	private int insertData(HttpServletRequest request, HttpServletResponse response, int i)
		{
		
		System.out.println(" MachineForDispenserServlet insertData :::");

		String machine_code = "", long_desc = "",  short_desc = "",  eff_status = "";
		
		Connection dbConn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		HttpSession session=request.getSession(false);
		String locale = request.getParameter("locale");
		System.out.println("locale.."+locale);
		int err_no = 0;

		this.prop = (java.util.Properties) session.getValue( "jdbc" ) ;
		this.facility_id = (String) session.getValue( "facility_id" ) ;
		login_user = this.prop.getProperty( "login_user" ) ;
		client_ip_address = this.prop.getProperty("client_ip_address") ;

		System.out.println("MachineForDispenserServlet insertData :: facility ID :: "+this.facility_id+" : loin user : "+login_user+" : ip Address : "+client_ip_address);

		int insertCount  = 0;

		int searchCount = 0;

		machine_code = XHDBAdapter.checkNull(request.getParameter("Machine_Code"+i));
		long_desc = XHDBAdapter.checkNull(request.getParameter("Long_Desc"+i));
		short_desc = XHDBAdapter.checkNull(request.getParameter("Short_Desc"+i));
		eff_status = XHDBAdapter.checkNull(request.getParameter("EFF_Status"+i));

		if(eff_status.trim().equals("")){
			eff_status = "N";
		}
		
		System.out.println(" MachineForDispenserServlet insertData value ::: machineCode :"+machine_code+" longDesc : "+long_desc+" shortDesc : "+short_desc+" effStatus : "+eff_status);
		
		
		
		try
		{
			String searchstmt = " SELECT COUNT(*) FROM XH_DISP_MACHINE_CODES WHERE MACHINE_CODE = ? ";

			System.out.println("searchstmt ::: "+searchstmt);

			dbConn = ConnectionManager.getConnection();
			
			pstmt = dbConn.prepareStatement(searchstmt);

			pstmt.setString(1, machine_code);
			rs = pstmt.executeQuery();
			while(rs.next()){
				searchCount = rs.getInt(1);
			}
			
		}
		catch (Exception e)
		{
			e.getMessage();
		}finally {
			XHUtil.closeDBResources(rs, pstmt, dbConn);
		}
		System.out.println("searchCount..."+searchCount);

		if(searchCount == 1){
			err_no = 3;
			
		}else{
		
			try {

				if(machine_code.length() != 0 ){


				String insertstmt = "INSERT INTO XH_DISP_MACHINE_CODES (MACHINE_CODE, LONG_DESC, SHORT_DESC, EFF_STATUS, ADDED_BY_ID, ADDED_AT_WS_NO, ADDED_FACILITY_ID, MODIFIED_BY_ID, MODIFIED_AT_WS_NO, MODIFIED_FACILITY_ID, ADDED_DATE, MODIFIED_DATE) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, SYSDATE, SYSDATE)";

				System.out.println("insertstmt ::: "+insertstmt);

				dbConn = ConnectionManager.getConnection();
				
				pstmt = dbConn.prepareStatement(insertstmt);

				pstmt.setString(1, machine_code);
				pstmt.setString(2, long_desc);
				pstmt.setString(3, short_desc);
				pstmt.setString(4, eff_status);
				pstmt.setString(5, login_user);
				pstmt.setString(6, client_ip_address);
				pstmt.setString(7, this.facility_id);
				pstmt.setString(8, login_user);
				pstmt.setString(9, client_ip_address);
				pstmt.setString(10, this.facility_id);

				insertCount = pstmt.executeUpdate();

				System.out.println("insertCount ..."+insertCount);
				if (insertCount == 1) {

					System.out.println("Machine Codes Table Inserted Successfully");
					dbConn.commit();
					err_no = 1;

					/*final java.util.Hashtable mesg = mm.getMessage(locale, "XH1001", "XH") ;
					message_text2 = ((String) mesg.get("message"));
					reqDis = 	session.getServletContext().
					getRequestDispatcher("/eXH/jsp/DisplayResult.jsp?message="+message_text2);
					reqDis.forward(request,response);*/
				} else {
					System.out.println("Error in Inserting Machine Codes Table");
					dbConn.rollback();
				}	
			}
				

			} catch (Exception e) {
				System.err.println("Error in MachineForDispenserServlet insertData :: " + e);
				//con.rollback();
				//response.sendRedirect("../eCommon/jsp/error.jsp?err_num=" + e);
				e.printStackTrace();
				err_no = 2;
			} finally {
				//bean.clearBean();
				XHUtil.closeDBResources(rs, pstmt, dbConn);
			}
			
			//return err_no;
	  }
	  return err_no;
	}

	
}//end of class
