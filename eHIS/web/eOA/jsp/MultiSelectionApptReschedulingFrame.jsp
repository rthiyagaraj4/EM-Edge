<!--Created by Ashwini on 05-Apr-2024 for ML-MMOH-CRF-2060-->
<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp" %> 
<%@ page contentType="text/html;charset=UTF-8" import="java.sql.*,java.text.*,webbeans.eCommon.*,org.json.simple.*,eCommon.XSSRequestWrapper,webbeans.eCommon.ConnectionManager" %>

<html>
<head>

<%
String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script><script language="javascript" src="../../eCommon/js/common.js"></script>
<script language='javascript' src='../../eOA/js/MultiSelectionApptRescheduling.js'></script>
	
</head>

<%
request.setCharacterEncoding("UTF-8"); 

request = new XSSRequestWrapper(request);
response.addHeader("X-XSS-Protection", "1; mode=block");
response.addHeader("X-Content-Type-Options", "nosniff");
	
String url = "../../eCommon/jsp/commonToolbar.jsp?";
String params = request.getQueryString();
String source = url + params;

String facilityid = (String)session.getValue("facility_id");
String globaluser = (String)session.getValue("login_user");

Connection con = null;
String oper_stn_id = "";
String currentdate = "";
String tfr_appt_yn = "";
String book_appt_yn = "";
String visit_limit_rule = "";
String allow_inside = "";

try{

	con = ConnectionManager.getConnection(request);

	JSONObject json = getAMOperatorStationSetupDtls(con,facilityid,globaluser);
	oper_stn_id = (String) json.get("oper_stn_id");			
	currentdate = (String) json.get("currentdate");
	tfr_appt_yn = (String) json.get("tfr_appt_yn");
	book_appt_yn = (String) json.get("book_appt_yn");
	visit_limit_rule = (String) json.get("visit_limit_rule");
	allow_inside = (String) json.get("allow_inside");

	if(allow_inside.equals("Y")){%>
		
			<iframe name='commontoolbarFrame' id='commontoolbarFrame' src=<%=source%> frameborder=0 scrolling='no' noresize frameborder='0' style='height:6vh;width:100vw'></iframe>
			<iframe name='frame1' id='frame1' 	src='../../eOA/jsp/MultiSelectionApptReschedulingCriteria.jsp?oper_stn_id=<%=oper_stn_id%>&currentdate=<%=currentdate%>&tfr_appt_yn=<%=tfr_appt_yn%>&book_appt_yn=<%=book_appt_yn%>&visit_limit_rule=<%=visit_limit_rule%>' frameborder=0  scrolling='no' frameborder='0' style='height:25vh;width:100vw'></iframe>
			<iframe name='frame2' id='frame2' src='../../eCommon/html/blank.html' frameborder=0 scrolling='auto' frameborder='0' style='height:35vh;width:100vw'></iframe>
			<iframe name='frame3submit' id='frame3submit' src='../../eCommon/html/blank.html' frameborder=0 scrolling='no' frameborder='0' style='height:25vh;width:100vw'></iframe>
			<iframe name='messageFrame' id='messageFrame' src='../../eCommon/jsp/error.jsp' frameborder=0 noresize scrolling='auto' frameborder='0' style='height:8vh;width:100vw'></iframe>
		

	<%}else{%>
	
		<script>
			alert(getMessage("NO_OPER_STN_FOR_USER","Common"));
			document.location.href='../../eCommon/jsp/dmenu.jsp';
		</script>

	<%}%>

</html>

<%

}catch(Exception es){
	es.printStackTrace();
}
finally{
	ConnectionManager.returnConnection(con,request);
}

%>

<%!
public static JSONObject getAMOperatorStationSetupDtls(Connection con, String facilityid, String globaluser) throws Exception{

	PreparedStatement pstmt = null;
	ResultSet rs = null;

	String oper_stn_id = "";
	String currentdate = "";
	String tfr_appt_yn = "";
	String book_appt_yn = "";
	String visit_limit_rule = "";
	String allow_inside = "";
	
	JSONObject jsonObj = new JSONObject();

	try{
		String sql = "SELECT a.oper_stn_id, tfr_appt_yn, book_appt_yn, TO_CHAR (SYSDATE, 'dd/mm/yyyy') dt, (SELECT visit_limit_rule FROM oa_param WHERE module_id = 'OA') visit_limit_rule FROM am_oper_stn a, am_user_for_oper_stn b WHERE a.facility_id = ? AND a.facility_id = b.facility_id AND a.oper_stn_id = b.oper_stn_id AND b.appl_user_id = ? AND TRUNC (SYSDATE) BETWEEN b.eff_date_from AND NVL (b.eff_date_to, TRUNC (SYSDATE))";
		
		pstmt = con.prepareStatement(sql);
		
		pstmt.setString(1,facilityid);
		pstmt.setString(2,globaluser);
		
		rs	= pstmt.executeQuery();

		if(rs!=null && rs.next()){
			oper_stn_id = rs.getString("oper_stn_id")==null?"":rs.getString("oper_stn_id");
			currentdate = rs.getString("dt")==null?"":rs.getString("dt");
			tfr_appt_yn = rs.getString("tfr_appt_yn")==null?"":rs.getString("tfr_appt_yn");
			book_appt_yn = rs.getString("book_appt_yn")==null?"":rs.getString("book_appt_yn");
			visit_limit_rule = rs.getString("visit_limit_rule")==null?"":rs.getString("visit_limit_rule");
			allow_inside = "Y";
		}else{
			allow_inside = "N";
		}

		jsonObj.put("oper_stn_id",oper_stn_id);
		jsonObj.put("currentdate",currentdate);
		jsonObj.put("tfr_appt_yn",tfr_appt_yn);
		jsonObj.put("book_appt_yn",book_appt_yn);
		jsonObj.put("visit_limit_rule",visit_limit_rule);
		jsonObj.put("allow_inside",allow_inside);
		
	}catch(Exception ex){
		ex.printStackTrace();
	}finally{
		try{
			if(rs!=null)rs.close();
			if(pstmt!=null)pstmt.close();
		}catch(Exception ex){
			System.err.println("Exception in getAMOperatorStationSetupDtls - "+ex.getMessage());
			ex.printStackTrace();
		}
	}
	return jsonObj;
}
%>