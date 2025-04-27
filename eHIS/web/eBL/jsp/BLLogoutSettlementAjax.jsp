<!DOCTYPE html>
<%@ page language="java" import="java.sql.*,webbeans.eCommon.*,java.net.*,webbeans.op.CurrencyFormat, java.io.*, com.ehis.util.*,java.util.*, java.text.SimpleDateFormat,eBL.Common.*, eBL.*, eCommon.Common.*" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@page import="org.json.simple.JSONObject"%>	
    

<%
HttpSession httpSession = request.getSession(false);
Properties p = (Properties) httpSession.getValue("jdbc");
Connection con = con=ConnectionManager.getConnection(request);
PreparedStatement pstmt = null;
ResultSet rs = null;
String site_id=" ";
String outst=" ";
String billcount_KDAH=" ";
String billcount_MC=" ";
JSONObject obj=new JSONObject();
try{
	
	
	String strLoginTime=request.getParameter("login_time");
	String strLogoutTime=request.getParameter("logout_time");
	String strCashCounterCode=request.getParameter("cashcounter1");
	String facility_id=request.getParameter("facility_id");
	
	
	try {
		pstmt=con.prepareStatement("select customer_id from sm_site_param");
		rs = pstmt.executeQuery();
		while (rs.next()) {
			site_id = rs.getString(1);
		}
		System.out.println("site id " + site_id);
	} catch (Exception e) {
		e.printStackTrace();
		System.out.println("site id " + e);
	}

	try {
		pstmt=con.prepareStatement("SELECT nvl(outst_bills_only,'N')  outstanding_ind FROM bl_parameters WHERE  operating_facility_id = '"+facility_id+"'");
		rs = pstmt.executeQuery();
		while (rs.next()) {
			outst = rs.getString(1);
		}
		System.out.println("outst : " + outst);
		
		
	} catch (Exception e) {
		e.printStackTrace();
		System.out.println("Execption outst settlement " + e);
	}

	try {
		pstmt=con.prepareStatement("SELECT COUNT (*) bill_count FROM bl_bill_hdr WHERE cust_code IS NULL AND bill_status IS NULL AND NVL (bill_tot_outst_amt, 0) <> 0 AND cash_counter_facility_id ='"+facility_id+"' AND CASH_COUNTER_CODE ='"+strCashCounterCode+"' AND DOC_DATE BETWEEN to_date('"+strLoginTime+"','dd/mm/yyyy hh24:mi:ss') AND to_date('"+strLogoutTime+"','dd/mm/yyyy hh24:mi:ss')");
		rs = pstmt.executeQuery();
		while (rs.next()) {
			billcount_KDAH = rs.getString(1);
		}
		System.out.println("billcount_KDAH : " + billcount_KDAH);

	} catch (Exception e) {
		e.printStackTrace();
		System.out.println("Execption billcount_KDAH settlement  " + e);
	}

	try {
		pstmt=con.prepareStatement("SELECT COUNT (*) bill_count FROM bl_bill_hdr WHERE cust_code IS NULL AND bill_status IS NULL AND NVL (bill_tot_outst_amt, 0) <> 0 AND cash_counter_facility_id ='"+facility_id+"'  AND CASH_COUNTER_CODE ='"+strCashCounterCode+"' AND DOC_DATE BETWEEN to_date('"+strLoginTime+"','dd/mm/yyyy hh24:mi:ss') AND to_date('"+strLogoutTime+"','dd/mm/yyyy hh24:mi:ss') AND episode_type in ('O','E','R')");
		rs = pstmt.executeQuery();
		while (rs.next()) {
			billcount_MC = rs.getString(1);
		}
		System.out.println("billcount_MC : " + billcount_MC);

	} catch (Exception e) {
		e.printStackTrace();
		System.out.println("Execption billcount_MC settlement  " + e);
	}
	
	obj.put("site_id",site_id);
	obj.put("outst",outst);
	obj.put("billcount_KDAH",billcount_KDAH);
	obj.put("billcount_MC",billcount_MC);

	
	out.print(obj);
    out.flush();
	
}
catch(Exception ee){
	
	ee.printStackTrace();
	System.err.println("BLLogoutSettlementAjax : " + ee);
	
	
	//ee.printStackTrace(ee);
}


%>
