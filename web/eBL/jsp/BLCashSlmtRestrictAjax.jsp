<!DOCTYPE html>
<%@page import="com.google.gson.JsonObject"%>
<%@page import="java.sql.Date,java.text.*"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="eBL.Common.BlRepository"%>
<%@page contentType="text/html;charset=UTF-8" import="java.sql.*, eBL.Common.*, eCommon.Common.*, webbeans.eCommon.*"%>
<%@page import="org.json.simple.JSONObject"%>	
<%@page import="eBL.BLCashSlmtRestriction"%>

<%
	request.setCharacterEncoding("UTF-8");
	String calledFrom = "";
 	Connection con = null;
 	CallableStatement cstmt = null;
 	PreparedStatement pstmt = null;
 	ResultSet rst = null;
try {
	con = ConnectionManager.getConnection();
	calledFrom = request.getParameter("calledFrom");
	
	if("blCashSlmt".equals(calledFrom)){
		String slmtTypeCode = request.getParameter("slmtTypeCode");
		BLCashSlmtRestriction billRestr = new BLCashSlmtRestriction();
		String cashYn = billRestr.blCashSlmt(slmtTypeCode);
		out.println(cashYn);
	}
	else if("checkCashRestrictionEligibility".equals(calledFrom)){
		String facilityId = (String) session.getValue("facility_id");
		BLCashSlmtRestriction billRestr = new BLCashSlmtRestriction();
		String restrictEligibility = billRestr.checkCashRestrictionEligibility(facilityId);
		out.println(restrictEligibility);
	}
	else if("BLPatientDepValidate".equals(calledFrom)){
		String facilityId = (String) session.getValue("facility_id");
		String patientId = request.getParameter("patientId");
		String depositAmt = request.getParameter("depositAmt");
		BLCashSlmtRestriction billRestr = new BLCashSlmtRestriction();
		JsonObject obj=billRestr.BLPatientDepValidate(facilityId,patientId,depositAmt);
		out.println(obj);
	}
	else if("BLPatientRecValidate".equals(calledFrom)){
		String facilityId = (String) session.getValue("facility_id");
		String docTypeCode = request.getParameter("docTypeCode");
		String docNum = request.getParameter("docNum");
		String docDate = request.getParameter("docDate");
		String episodeType = request.getParameter("episodeType");
		String episodeId = request.getParameter("episodeId");
		String visitId = request.getParameter("visitId");
		String patientId = request.getParameter("patientId");
		String slmtAmt = request.getParameter("slmtAmt");
		BLCashSlmtRestriction billRestr = new BLCashSlmtRestriction();
		JsonObject obj=billRestr.BLPatientRecValidate( facilityId, docTypeCode, docNum, docDate, episodeType, episodeId, visitId, patientId, slmtAmt);
		System.err.println(obj);
		out.println(obj);
	}
	

}
	catch (Exception e) {

	e.printStackTrace() ;
	System.out.println("Exception from BLCashSlmtRestrictAjax :"+e);
}
finally
	{	
		ConnectionManager.returnConnection(con, request);
	}


%>

