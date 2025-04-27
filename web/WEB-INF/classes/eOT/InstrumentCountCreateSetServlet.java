/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eOT;
import javax.servlet.http.HttpSession;
import javax.servlet.ServletException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletRequest;
import java.io.PrintWriter;
import java.io.IOException;
import java.util.Properties;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import webbeans.eCommon.ConnectionManager;
import webbeans.eCommon.*;

public class InstrumentCountCreateSetServlet extends javax.servlet.http.HttpServlet {
	public void init(ServletConfig config) throws ServletException	{
		super.init(config);
	}
	public void doPost(HttpServletRequest req, HttpServletResponse res)
	throws javax.servlet.ServletException,IOException{
		Connection	con = null;
		ResultSet	rs = null;
		ResultSet	rs_bio = null;
		PreparedStatement pstmt = null;
		PreparedStatement pstmt_hdr = null;
		PreparedStatement pstmt_hdr_bio = null;

		PrintWriter out;
		req.setCharacterEncoding("UTF-8");
		res.setContentType("text/html;charset=UTF-8");
		HttpSession session=req.getSession(false);
		out=res.getWriter();
		Properties prop = (java.util.Properties) session.getValue( "jdbc" ) ;

		String surgery_date	= req.getParameter("surgery_date");
		String team_doctor_code	= req.getParameter("team_doctor_code");		
		String booking_num	= req.getParameter("booking_num");
		String oper_num		= req.getParameter("oper_num");
		String oper_code	= req.getParameter("oper_code");
		String patient_id	= req.getParameter("patient_id");
		String set_code		= req.getParameter("set_code");
		String tray_num		= req.getParameter("tray_num");
		//CRF-268 Instrument Count - Rajesh V
		int noOfunits = 0;
		String otParam = req.getParameter("ot_Param");
		if("Y".equalsIgnoreCase(otParam)){
			noOfunits = Integer.parseInt(req.getParameter("req_qty"));
		}		 
		//CRF-268 Instrument Count - Rajesh V
		String facility_id = (String)session.getValue( "facility_id" );
		String login_at_ws_no = prop.getProperty( "client_ip_address" );
		String login_user = (String)session.getValue( "login_user" );
		String locale = prop.getProperty("LOCALE");
		int count=0;
		String bio_hazard_yn="N";

		
		ArrayList item_list = new ArrayList();
		String result = "";
		try{
			con = ConnectionManager.getConnection(req);
			//String sql = "SELECT A.ITEM_CODE,ITEM_DESC,ITEM_QTY FROM OT_INSTRUMENT_COMPONENTS A, OT_SS_COMPONENTS B WHERE INSTR_CODE=? AND A.ITEM_CODE = B.ITEM_CODE";

			String sql_bio="SELECT COUNT(*) BIO_YN_COUNT FROM OT_STORE_ISSUE_HDR WHERE OPERATING_FACILITY_ID='"+facility_id+"'AND OPER_NUM ='"+oper_num+"' AND NVL(BIO_HAZARD_YN,'N') ='Y'";

			pstmt_hdr_bio=con.prepareStatement(sql_bio);
			rs_bio=pstmt_hdr_bio.executeQuery();

			while(rs_bio!=null && rs_bio.next()){
			 count= Integer.parseInt(rs_bio.getString("BIO_YN_COUNT"));
			}
			if(count>0)
			{
				bio_hazard_yn="Y";
			}

			String sql = "SELECT A.ITEM_CODE,ITEM_DESC,ITEM_QTY FROM OT_INSTRUMENT_COMPONENTS A, OT_SS_COMPONENTS_LANG_VW B WHERE INSTR_CODE=? AND A.ITEM_CODE = B.ITEM_CODE AND B.LANGUAGE_ID='"+locale+"' ";

			pstmt=con.prepareStatement(sql);
			pstmt.setString(1,set_code);
			rs=pstmt.executeQuery();
			while(rs!=null && rs.next())	{
				item_list.add(rs.getString("ITEM_CODE"));
				item_list.add(rs.getString("ITEM_QTY"));
				item_list.add(rs.getString("ITEM_DESC"));
			}
			int index=1;
			sql = "INSERT INTO OT_STORE_ISSUE_HDR(OPERATING_FACILITY_ID,PATIENT_ID,BOOKING_NUM,OPER_NUM,SET_CODE,TRAY_NUM,BIO_HAZARD_YN) VALUES(?,?,?,?,?,?,?) ";

			pstmt_hdr=con.prepareStatement(sql);
		// OT_STORE_ISSUE_HDR INSERT START FROM HERE
			pstmt_hdr.setString(index++,facility_id);	// OPERATING_FACILITY_ID
			pstmt_hdr.setString(index++,patient_id);	// PATIENT_ID
			pstmt_hdr.setString(index++,booking_num);	// BOOKING_NUM
			pstmt_hdr.setString(index++,oper_num);		// OPER_NUM
			pstmt_hdr.setString(index++,set_code);		// SET_CODE
			pstmt_hdr.setString(index++,tray_num);		// TRAY_NUM
			pstmt_hdr.setString(index,bio_hazard_yn);		// BIO_HAZARD_YN
			pstmt_hdr.addBatch();
		// OT_STORE_ISSUE_DTLS INSERT START FROM HERE
			sql = "INSERT INTO OT_STORE_ISSUE_DTLS(OPERATING_FACILITY_ID,PATIENT_ID,SURGERY_DATE,TEAM_DOCTOR_CODE,OPER_CODE,BOOKING_NUM,OPER_NUM,SET_CODE,TRAY_NUM,ITEM_TYPE,ITEM_CODE,STD_QTY,ITEM_NAME,ADDED_BY_ID,ADDED_DATE,ADDED_AT_WS_NO,ADDED_FACILITY_ID,MODIFIED_BY_ID,MODIFIED_DATE,MODIFIED_AT_WS_NO,MODIFIED_FACILITY_ID) VALUES(?,?,TO_DATE(?,'DD/MM/YYYY'),?,?,?,?,?,?,?,?,?,?,?,SYSDATE,?,?,?,SYSDATE,?,?) ";
			if(pstmt!=null) pstmt.close();
			pstmt=con.prepareStatement(sql);
			for(int j=0;j<item_list.size();j+=3){
				index=1;
				pstmt.setString(index++,facility_id);	// OPERATING_FACILITY_ID 1
				pstmt.setString(index++,patient_id);	// PATIENT_ID 2
				pstmt.setString(index++,surgery_date);	// SURGERY_DATE 3
				pstmt.setString(index++,team_doctor_code);	// TEAM_DOCTOR_CODE 4
				pstmt.setString(index++,oper_code);		// OPER_CODE 5
				pstmt.setString(index++,booking_num);	// BOOKING_NUM 6
				pstmt.setString(index++,oper_num);		// OPER_NUM 7
				pstmt.setString(index++,set_code);		// SET_CODE 8
				pstmt.setString(index++,tray_num);		// TRAY_NUM 9
				pstmt.setString(index++,"C");		// ITEMP_TYPE	10			
				pstmt.setString(index++,(String)item_list.get(j));		// ITEM_CODE 11
				pstmt.setString(index++,(String)item_list.get(j+1));	// STD_QTY 12
				pstmt.setString(index++,(String)item_list.get(j+2));			// ITEM_NAME 13
				pstmt.setString(index++,login_user);	// ADDED_BY_ID 14
				pstmt.setString(index++,login_at_ws_no);// ADDED_AT_WS_NO 15
				pstmt.setString(index++,facility_id);	// ADDED_FACILITY_ID 16
				pstmt.setString(index++,login_user);	// MODIFIED_BY_ID 17
				pstmt.setString(index++,login_at_ws_no);// MODIFIED_AT_WS_NO 18
				pstmt.setString(index++,facility_id);	// MODIFIED_FACILITY_ID 19
				pstmt.addBatch();
			}
			int[] result_hdr_insert= pstmt_hdr.executeBatch();
			for (int i=0;i<result_hdr_insert.length ;i++ ) {
				if(result_hdr_insert[i]<0  && result_hdr_insert[i] != -2 ){
					con.rollback();
					result = "TRANSACTION_FAILED";
				}
			}
			int[] result_insert= pstmt.executeBatch();
			for (int i=0;i<result_insert.length ;i++ ) {
				if(result_insert[i]<0  && result_insert[i] != -2 ){
					con.rollback();
					result = "TRANSACTION_FAILED";
				}
			}
			if(pstmt!=null) pstmt.close();	//Added Against Common-ICN-0031
			//CRF-268 Instrument Count - Rajesh V
			if("Y".equalsIgnoreCase(otParam)){
				String sqlPickList =	"insert into ot_pick_lists(operating_facility_id,patient_id,surgery_date,team_doctor_code,booking_num,"+
										"oper_num,oper_code,item_type,item_id,no_of_units,added_by_id,added_date,added_at_ws_no,added_facility_id,"+
										"modified_by_id,modified_date,modified_at_ws_no,modified_facility_id) values(?,?,to_date(?,'dd/mm/yyyy'),?,?,?,?,?,?,?,?,sysdate,?,?,?,sysdate,?,?)";
				pstmt = con.prepareStatement(sqlPickList);
				pstmt.setString(1,facility_id);	
				pstmt.setString(2,patient_id);	
				pstmt.setString(3,surgery_date);	
				pstmt.setString(4,team_doctor_code);			
				pstmt.setString(5,booking_num);	
				pstmt.setString(6,oper_num);
				pstmt.setString(7,oper_code);
				pstmt.setString(8,"I");
				pstmt.setString(9,set_code);	
				pstmt.setInt(10,noOfunits);
				pstmt.setString(11,login_user);	
				pstmt.setString(12,login_at_ws_no);
				pstmt.setString(13,facility_id);	
				pstmt.setString(14,login_user);	
				pstmt.setString(15,login_at_ws_no);
				pstmt.setString(16,facility_id);	
				pstmt.execute();
			}
			//CRF-268 Instrument Count - Rajesh V
			con.commit();
			result = "RECORD_INSERTED";
            MessageManager mm=new MessageManager();
			String msg = "";
			if(result.equals("TRANSACTION_FAILED")){
				final java.util.Hashtable mesg = mm.getMessage(locale, "APP-OT0082", "OT") ;
				msg = ((String) mesg.get("message"));
				//out.println("<html><script>alert('Operation Failed ....');</script></html>");
				out.println("<html><script>alert("+msg+");</script></html>");
			}else{		
				final java.util.Hashtable mesg = mm.getMessage(locale, "RECORD_INSERTED", "SM") ;
				msg = ((String) mesg.get("message"));
				String htmlStr = "<html><script>";
				//htmlStr = htmlStr+"alert('APP-SM0002 Operation Completed Successfully! ....');";
				htmlStr = htmlStr+"alert('"+msg+"');";
				htmlStr = htmlStr+"window.returnValue='RECORD_INSERTED';window.close();";
				htmlStr = htmlStr+"</script></html>"; 
				out.println(htmlStr);				
			}
			
				if(rs!=null) rs.close();
				if(rs_bio!=null) rs_bio.close();
				if(pstmt_hdr_bio!=null) pstmt_hdr_bio.close();
				if(pstmt_hdr!=null) pstmt_hdr.close();
				if(pstmt!=null) pstmt.close();
		}catch(Exception e){

			e.printStackTrace();
		}
		finally{
		
				if(con!=null)
				ConnectionManager.returnConnection(con, req);

		}
	}
} 
