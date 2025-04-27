/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eOH;

import javax.servlet.http.HttpSession;
import javax.servlet.ServletException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletRequest;
import java.io.PrintWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Properties;
import java.util.ArrayList;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import webbeans.eCommon.ConnectionManager;
import org.xml.sax.InputSource;
import webbeans.eCommon.*;

public class MTasksLinkServlet extends javax.servlet.http.HttpServlet {
	public void init(ServletConfig config) throws ServletException	{
		super.init(config);
	}

	private String checkForNull(String str){
		return (str!=null && str.intern()!="null")?str:"";
	}

	public void doPost(HttpServletRequest req, HttpServletResponse res)
	throws javax.servlet.ServletException,IOException{
		String treatment_code = checkForNull(req.getParameter("treatment_code"));
	
		PrintWriter out;
		HashMap hashElement=null,map=null;
		eOH.MasterXMLParse masterXMLParse;
		HashMap CommonData=new HashMap();
		req.setCharacterEncoding("UTF-8");
		res.setContentType("text/html;charset=UTF-8");
		HttpSession session=req.getSession(false);
		out=res.getWriter();

		masterXMLParse=new eOH.MasterXMLParse();
		String client_ip_address="";
		String facility_id = "";
		String login_user="";
		String locale="";

		java.util.Properties prop = null;
		facility_id = (String)session.getValue( "facility_id" ) ;
		prop = (java.util.Properties) session.getValue( "jdbc" ) ;
		client_ip_address = prop.getProperty( "client_ip_address" );
		login_user = prop.getProperty( "login_user" );
		locale = prop.getProperty("LOCALE");

		CommonData.put("login_user", login_user);
		CommonData.put("login_at_ws_no",client_ip_address);
		CommonData.put("facility_id",facility_id);
		CommonData.put("locale",locale);

		Connection con = null;
		PreparedStatement pstmt_delete = null;
		PreparedStatement pstmt_or_delete = null;
		PreparedStatement pstmt_insert = null;
		PreparedStatement pstmt_or_insert = null;
		PreparedStatement pstmt_appttime = null;
		ResultSet rs = null;
		int flag=0;
		String error_value = "";
		int count=0;
		String msg="";
		MessageManager mm=new MessageManager();
		ArrayList arrList = null;
		ArrayList tabData = null;
		ArrayList flag_arr = null;
		try{
			arrList = new ArrayList(1);
			con = ConnectionManager.getConnection(req);
			InputSource inputSource=new InputSource(req.getReader());
			hashElement=masterXMLParse.parseXMLData(inputSource,null,arrList,eOH.MasterXMLParse.DETAIL_ONLY);
			tabData =(ArrayList) hashElement.get("SEARCH");
			String task_code = "";
			String mode = "";
			String days_between = "";
			String days_between_oper = "";
			String appt_time = "";
			String order_type_code = "";
			String seq_no="";
			String select_value="";
			pstmt_delete=con.prepareStatement("DELETE FROM OH_TREATMENT_TASKS WHERE TRMT_CODE =?");

			pstmt_or_delete=con.prepareStatement("DELETE FROM OR_ORDER_SET_COMPONENT WHERE ORDER_SET_CODE = (SELECT ORDER_CATALOG_CODE FROM OH_TREATMENT WHERE TRMT_CODE=?)");

			pstmt_insert=con.prepareStatement("INSERT INTO OH_TREATMENT_TASKS (TRMT_CODE,TASK_CODE,SEQ_NO,APPT_DURATION,DAYS_BETWEEN_OPERATOR,DAYS_BETWEEN,EFF_STATUS,ADDED_BY_ID,ADDED_DATE,ADDED_AT_WS_NO,ADDED_FACILITY_ID,MODIFIED_BY_ID,MODIFIED_DATE,MODIFIED_AT_WS_NO,MODIFIED_FACILITY_ID) VALUES (?,?,?,TO_DATE(?,'HH24:MI'),?,?,?,?,SYSDATE,?,?,?,SYSDATE,?,?)");

			pstmt_or_insert=con.prepareStatement("INSERT INTO OR_ORDER_SET_COMPONENT(ORDER_SET_CODE, ORDER_CATALOG_CODE, ORDER_SET_SEQ_NUM, ORDER_TYPE_CODE, ORDER_CATEGORY, REQD_OR_OPT_IND, REL_START_DATE_TIME, ROUTE_CODE, QTY_VALUE, QTY_UNIT, FREQ_CODE, DURN_VALUE, DURN_TYPE, ITEM_NARRATION, OCURRANCE_NUM, ADDED_BY_ID, ADDED_DATE, ADDED_AT_WS_NO, ADDED_FACILITY_ID, MODIFIED_BY_ID, MODIFIED_DATE, MODIFIED_AT_WS_NO, MODIFIED_FACILITY_ID) VALUES ((SELECT ORDER_CATALOG_CODE FROM OH_TREATMENT WHERE TRMT_CODE =?), (SELECT ORDER_CATALOG_CODE FROM OH_TASKS WHERE TASK_CODE = ?), ?, ?, 'OH', 'R', NULL, NULL, 1, NULL, NULL, NULL, NULL, NULL, 1, ?, SYSDATE, ?, ?, ?, SYSDATE, ?, ?)");

			pstmt_appttime=con.prepareStatement("SELECT TO_CHAR(APPT_TIME,'HH24:MI') APPT_TIME, ORDER_TYPE_CODE FROM OR_ORDER_CATALOG WHERE ORDER_CATALOG_CODE = (SELECT ORDER_CATALOG_CODE FROM OH_TASKS WHERE TASK_CODE = ?)");

			flag_arr= new ArrayList();
			if(tabData!=null && tabData.size()>0){
				pstmt_delete.setString(1,treatment_code);
				pstmt_delete.executeUpdate();

				pstmt_or_delete.setString(1,treatment_code);
				pstmt_or_delete.executeUpdate();

				for(int i = 0;i<tabData.size();i++){
					count++;
					map = (HashMap) tabData.get(i);
					task_code = (String )  map.get("task_code");
					select_value = (String) map.get("select_value");
					seq_no=(String) map.get("seq_no");
					mode=(String )  map.get("mode");
					mode=checkForNull(mode);
					if(!task_code.equals(null) && !task_code.equals("") && select_value.equals("Y")){
						//Get the Appt time from order_catalog
						if(rs!=null) rs.close();
						pstmt_appttime.setString(1,task_code);
						rs = pstmt_appttime.executeQuery();
						while(rs.next() && rs != null){
							appt_time = rs.getString("APPT_TIME");
							order_type_code = rs.getString("ORDER_TYPE_CODE");
						}
						if(rs!=null) rs.close();
						pstmt_insert.setString(1,treatment_code);
						pstmt_insert.setString(2,task_code);
						pstmt_insert.setString(3,seq_no);
						pstmt_insert.setString(4,appt_time);
						pstmt_insert.setString(5,days_between_oper);
						pstmt_insert.setString(6,days_between);
						pstmt_insert.setString(7,"E");
						pstmt_insert.setString(8,(String) CommonData.get("login_user"));
						pstmt_insert.setString(9,(String) CommonData.get("login_at_ws_no"));
						pstmt_insert.setString(10,(String) CommonData.get("facility_id"));
						pstmt_insert.setString(11,(String) CommonData.get("login_user"));
						pstmt_insert.setString(12,(String) CommonData.get("login_at_ws_no"));
						pstmt_insert.setString(13,(String) CommonData.get("facility_id"));
						flag = pstmt_insert.executeUpdate();
						flag_arr.add(""+flag);
						//Insert into the OR_ORDER_SET_COMPONENT TABLE
						//INSERT INTO OR_ORDER_SET_COMPONENT(ORDER_SET_CODE, ORDER_CATALOG_CODE, ORDER_SET_SEQ_NUM, ORDER_TYPE_CODE, ORDER_CATEGORY, REQD_OR_OPT_IND, REL_START_DATE_TIME, ROUTE_CODE, QTY_VALUE, QTY_UNIT, FREQ_CODE, DURN_VALUE, DURN_TYPE, ITEM_NARRATION, OCURRANCE_NUM, ADDED_BY_ID, ADDED_DATE, ADDED_AT_WS_NO, ADDED_FACILITY_ID, MODIFIED_BY_ID, MODIFIED_DATE, MODIFIED_AT_WS_NO, MODIFIED_FACILITY_ID) VALUES (?, ?, ?, ?, 'OH', 'R', NULL, NULL, 1, NULL, NULL, NULL, NULL, NULL, 1, ?, SYSDATE, ?, ?, ?, SYSDATE, ?, ?);

						pstmt_or_insert.setString(1,treatment_code);
						pstmt_or_insert.setString(2,task_code);
						pstmt_or_insert.setString(3,seq_no);
						pstmt_or_insert.setString(4,order_type_code); // ORDER_TYPE_CODE
						pstmt_or_insert.setString(5,(String) CommonData.get("login_user"));
						pstmt_or_insert.setString(6,(String) CommonData.get("login_at_ws_no"));
						pstmt_or_insert.setString(7,(String) CommonData.get("facility_id"));
						pstmt_or_insert.setString(8,(String) CommonData.get("login_user"));
						pstmt_or_insert.setString(9,(String) CommonData.get("login_at_ws_no"));
						pstmt_or_insert.setString(10,(String) CommonData.get("facility_id"));
						flag = pstmt_or_insert.executeUpdate();
					} 
				}// end of for Loop
			
			if(!flag_arr.contains("0")){
				error_value="1";
				con.commit();
				final java.util.Hashtable mesg = mm.getMessage(locale, "RECORD_INSERTED", "SM") ;
				msg = ((String) mesg.get("message"));
				mesg.clear();
			 }else{
				error_value="0";
				con.rollback();
				final java.util.Hashtable mesg = mm.getMessage(locale, "APP-OH00018", "OH") ;
				msg = ((String) mesg.get("message"));
				mesg.clear();
			 }
			 out.println(msg);
		}// end of outer if Loop
		}catch(Exception e){
			    System.err.println("Err Msg in MTasksLinkServlet"+e.getMessage());
				out.println(""+e);
				try{
					error_value="0";
					con.rollback();
					final java.util.Hashtable mesg = mm.getMessage(locale, "APP-OH00018", "OH") ;
					msg = ((String) mesg.get("message"));
					mesg.clear();
				}catch(Exception e1){
					out.println(""+e1);
				}
		}finally{
			try{
				hashElement.clear();map.clear();
				CommonData.clear();arrList.clear();
				tabData.clear();flag_arr.clear();

				if(rs!=null) rs.close();
				if(pstmt_delete!=null) pstmt_delete.close();
				if(pstmt_or_delete!=null) pstmt_or_delete.close();
				if(pstmt_or_insert!=null) pstmt_or_insert.close();
				if(pstmt_insert!=null) pstmt_insert.close();
				if(pstmt_appttime!=null) pstmt_appttime.close();

				if(con!=null) ConnectionManager.returnConnection(con,req);
			}catch(Exception e){}
		}
	 }
 }



