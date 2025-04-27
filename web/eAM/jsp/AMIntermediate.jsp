<!DOCTYPE html>
<%@ page import ="java.sql.*,java.util.*,java.net.*,webbeans.eCommon.*,eCommon.Common.*,org.json.simple.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8" %> 
<jsp:useBean id="obj" scope="page" class="webbeans.eCommon.XMLStringParser"/> 
<%
	request.setCharacterEncoding("UTF-8");
	//MMS-ME-SCF-0096 vulnerability Issue 
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");
	//MMS-ME-SCF-0096 vulnerability Issue
	Connection con = null;
	con = ConnectionManager.getConnection(request);

try{
	Map hash = (Map)obj.parseXMLString( request ) ;
	hash = (Map)hash.get("SEARCH") ;
	String action = (String) hash.get("action")==null?"":(String) hash.get("action");
	
	if(action.equals("getPractName")){
		String retVal = "";
		String natid = (String) hash.get("national_id");
		JSONObject practJSONObj	= new JSONObject();
		practJSONObj = eAM.AMCommonBean.getPractName(con,natid);
		int rec_cnt = (Integer)practJSONObj.get("rec_cnt");
		String practitioner_name = (String)practJSONObj.get("practitioner_name");
		retVal = rec_cnt+"|~|"+practitioner_name;
		out.println(retVal);
	}
	else if(action.equals("getOthAltPractName")){
		String retVal = "";
		String othalttype = (String) hash.get("oth_alt_type");
		String othaltid = (String) hash.get("oth_alt_id");
		JSONObject practJSONObj	= new JSONObject();
		practJSONObj = eAM.AMCommonBean.getOthAltPractName(con,othalttype,othaltid);
		int rec_cnt = (Integer)practJSONObj.get("rec_cnt");
		String practitioner_name = (String)practJSONObj.get("practitioner_name");
		retVal = rec_cnt+"|~|"+practitioner_name;
		out.println(retVal);
	}
	else if(action.equals("getOthStaffName")){
		String retVal = "";
		String natid = (String) hash.get("national_id");
		JSONObject staffJSONObj	= new JSONObject();
		staffJSONObj = eAM.AMCommonBean.getOthStaffName(con,natid);
		int rec_cnt = (Integer)staffJSONObj.get("rec_cnt");
		String oth_staff_name = (String)staffJSONObj.get("oth_staff_name");
		retVal = rec_cnt+"|~|"+oth_staff_name;
		out.println(retVal);
	}
	else if(action.equals("getOthAltStaffName")){
		String retVal = "";
		String othalttype = (String) hash.get("oth_alt_type");
		String othaltid = (String) hash.get("oth_alt_id");
		JSONObject staffJSONObj	= new JSONObject();
		staffJSONObj = eAM.AMCommonBean.getOthAltStaffName(con,othalttype,othaltid);
		int rec_cnt = (Integer)staffJSONObj.get("rec_cnt");
		String oth_staff_name = (String)staffJSONObj.get("oth_staff_name");
		retVal = rec_cnt+"|~|"+oth_staff_name;
		out.println(retVal);
	}
	// added by Lakshmanan for MO-CRF-20183.2 US001 start
	else if(action.equals("EmpServNo")){
		int retVal = 0;
		String empservno	= (String) hash.get("empservno");		
		JSONObject empServNoJSONOBJ=eAM.AMCommonBean.getEmpServNo(con,empservno);
		retVal = (Integer)empServNoJSONOBJ.get("rec_cnt");		
		out.println(retVal);
	}
	// added by Lakshmanan for MO-CRF-20183.2 US001 end
}catch(Exception e){ 
	e.printStackTrace();	
}finally{ 
	if(con != null){
		ConnectionManager.returnConnection(con,request);
	}	
}                  
%>  
