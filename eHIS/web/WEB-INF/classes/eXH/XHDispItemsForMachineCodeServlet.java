/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eXH;
import java.net.*;
import java.sql.*;
import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import webbeans.eCommon.ConnectionManager;
import webbeans.eCommon.*;

public class XHDispItemsForMachineCodeServlet extends HttpServlet	
{
	java.util.Properties prop;
	HttpSession session;
	private String locale = "";
	
	
    protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Reached Servlet XHDispItemsForMachineCodeServlet");
		
	 
	  int result = 0;
	  int primaryCheck = 0;
	  String error = "";
	  String mode = "";
	  RequestDispatcher reqDis=null;
	  int totalRecords=Integer.parseInt((String)request.getParameter("totalRecords"));
	  mode = request.getParameter("mode");
	  String selectChk = request.getParameter("selectChk");
	  System.out.println("totalRecords.."+totalRecords+" ::: Select Check Box ::: "+selectChk+" ::: mode ::: "+mode);
	  
	  for(int i=1;i<=totalRecords;i++) {
		  if(mode.equals("Modify")){
				result = updateModifyDtl(request,response,i);
		  }else if(mode.equals("Insert")){
			  primaryCheck = primaryKeyCheck(request,response,i);
			  if(primaryCheck == 1){
				 result = 3;
			  }
			  else if(primaryCheck == 0){
				  result = insertModifyDtl(request,response,i);
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
			
			System.out.println("Select atleast one record ...");
			final java.util.Hashtable mesg = mm.getMessage(locale, "ATLEAST_ONE_SELECTED", "Common") ;
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
			
			System.out.println("Record Already Exists...");

			final java.util.Hashtable mesg = mm.getMessage(locale, "CODE_ALREADY_EXISTS", "Common") ;
			error = ((String) mesg.get("message"));
			reqDis = 	session.getServletContext().
			getRequestDispatcher("/eXH/jsp/DisplayResult.jsp?message="+error+"&fun_id=xyz");
			reqDis.forward(request,response);
		}
		//error_value = Integer.toString(result);
		//response.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode( error,"UTF-8" ) +"&err_value="+error_value);
	}

	private int primaryKeyCheck(HttpServletRequest request, HttpServletResponse response, int i) {
		int searchCount = 0;
		String searchstmt = "";
		Connection dbConn = null;
        PreparedStatement pstmt = null;
		ResultSet rs = null;

		System.out.println(" ::: Inside primaryKeyCheck ::: ");
		String facility_id = "", disp_locn = "", item_code = "";
		

		try{
			facility_id = request.getParameter("hid_facility_id"+i);
			disp_locn = request.getParameter("hid_dispense_location"+i);
			//machine_code = request.getParameter("hid_machine"+i);
			item_code = request.getParameter("hid_item"+i);

			searchstmt = " SELECT COUNT(*) FROM XH_DISP_LOCN_MACHINES WHERE UPPER(FACILITY_ID) = UPPER(?) AND UPPER(DISP_LOCN_CODE) = UPPER(?) AND UPPER(ITEM_CODE) = UPPER(?) ";

			dbConn = ConnectionManager.getConnection();
			
			pstmt = dbConn.prepareStatement(searchstmt);
			pstmt.setString(1, facility_id);
			pstmt.setString(2, disp_locn);
			//pstmt.setString(3, machine_code);
			pstmt.setString(3, item_code);
			rs = pstmt.executeQuery();
			while(rs.next()){
				searchCount = rs.getInt(1);
			}
			System.out.println("primaryKeyCheck.searchCount ::: "+searchCount);
		}
		catch (Exception e)
		{
			e.getMessage();
		}finally {
			XHUtil.closeDBResources(rs, pstmt, dbConn);
		}
		return searchCount;
	}

	private int updateModifyDtl(HttpServletRequest request, HttpServletResponse response, int i) {
		int rslt = 0;
		int err_no = 0;
		String sql = "";
		Connection con = null;
        PreparedStatement pstmt = null;
		ResultSet rst = null;

		System.out.println(" ::: Inside updateModifyDtl ::: ");

		session = request.getSession(false);
		String facility_id = request.getParameter("hid_facility_id"+i);
		int selectCheck = Integer.parseInt((String)request.getParameter("hid_selectBox"+i));
		String DispLocn = request.getParameter("hid_dispense_location"+i);
		String machine = request.getParameter("hid_machine"+i);
		String item = request.getParameter("hid_item"+i);
		String highAlertDrug = request.getParameter("hid_high_alert_drug"+i);
		String packOnlyExpDrug = request.getParameter("hid_pack"+i);
		this.prop = (java.util.Properties) session.getValue( "jdbc" ) ;
		System.out.println("XHDispItemsForMachineCodeServlet.updateModifyDtl ::: selectCheck ::: "+selectCheck);

		if(selectCheck == 1){

		try{				
				sql = " UPDATE XH_DISP_LOCN_MACHINES SET HIGH_ALERT_DRUG_YN = ?, PACK_ONLY_EXPENSIVE_DRUG_YN = ?, MACHINE_CODE = ? WHERE FACILITY_ID = ? AND DISP_LOCN_CODE = ?  AND ITEM_CODE = ?";
				System.out.println("Update Query..."+sql);
				con = ConnectionManager.getConnection(request);
				pstmt = con.prepareStatement(sql);

				pstmt.setString(1, highAlertDrug);
				pstmt.setString(2, packOnlyExpDrug);
				pstmt.setString(3, machine);
				pstmt.setString(4, facility_id);
				pstmt.setString(5, DispLocn);				
				pstmt.setString(6, item);
				

				
				rslt= pstmt.executeUpdate();
				err_no = 1;
				con.commit();

				}
				catch(Exception e){
					System.err.println("Exception updateModifyDtl ->"+e);
					e.printStackTrace();
					err_no = 2;
				}
				finally{
					XHUtil.closeDBResources(rst, pstmt, con);
				}
				}else{
		}
				return err_no;
	}

   private int insertModifyDtl(HttpServletRequest request, HttpServletResponse response, int i) {
		int rslt = 0;
		int err_no = 0;
		String sql = "";
		Connection con = null;
        PreparedStatement pstmt = null;
		ResultSet rst = null;

		System.out.println(" ::: Inside insertModifyDtl ::: ");

		session = request.getSession(false);

		String facility_id = request.getParameter("hid_facility_id"+i);
		int selectCheck = Integer.parseInt((String)request.getParameter("hid_selectBox"+i));
		String DispLocn = request.getParameter("hid_dispense_location"+i);
		String machine = request.getParameter("hid_machine"+i);
		String item = request.getParameter("hid_item"+i);
		String highAlertDrug = request.getParameter("hid_high_alert_drug"+i);
		String packOnlyExpDrug = request.getParameter("hid_pack"+i);
		this.prop = (java.util.Properties) session.getValue( "jdbc" ) ;
		String login_user = this.prop.getProperty( "login_user" ) ;
		String client_ip_address = this.prop.getProperty("client_ip_address") ;

		System.out.println(" XHDispItemsForMachineCodeServlet request values..facility_id.."+facility_id+"..Dispense Location.."+DispLocn+"..Machine.."+machine+"==selectCheck==>"+selectCheck);
		System.out.println(" XHDispItemsForMachineCodeServlet request values..item"+item+"..High alert drug.."+highAlertDrug+"..pack only.."+packOnlyExpDrug);
		System.out.println(" XHDispItemsForMachineCodeServlet request values..Login user"+login_user+"..ip address.."+client_ip_address);
		System.out.println(" facility ID lenght..."+facility_id.length());

		if(selectCheck == 1){
		
			try{
				
				sql = "INSERT INTO XH_DISP_LOCN_MACHINES(FACILITY_ID, DISP_LOCN_CODE, MACHINE_CODE, ITEM_CODE, HIGH_ALERT_DRUG_YN, PACK_ONLY_EXPENSIVE_DRUG_YN, EFF_STATUS, ADDED_BY_ID, ADDED_AT_WS_NO,  MODIFIED_BY_ID, MODIFIED_AT_WS_NO, ADDED_DATE, MODIFIED_DATE) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, SYSDATE, SYSDATE)";
				System.out.println("Insert Query..."+sql);
				con = ConnectionManager.getConnection(request);
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, facility_id);
				pstmt.setString(2, DispLocn);
				pstmt.setString(3, machine);
				pstmt.setString(4, item);
				pstmt.setString(5, highAlertDrug);
				pstmt.setString(6, packOnlyExpDrug);
				pstmt.setString(7, "E");
				pstmt.setString(8, login_user);
				pstmt.setString(9, client_ip_address);
				pstmt.setString(10, login_user);
				pstmt.setString(11, client_ip_address);
				
				rslt= pstmt.executeUpdate();
				err_no = 1;
				con.commit();

				}
				catch(Exception e){
					System.err.println("Exception ->"+e);
					e.printStackTrace();
					err_no = 2;
				}
				finally{
					XHUtil.closeDBResources(rst, pstmt, con);
				}
		}else{
		}
		return err_no;
	  
   }
	
	
		
}// end of class
