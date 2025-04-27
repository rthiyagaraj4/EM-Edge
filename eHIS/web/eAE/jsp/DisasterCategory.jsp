<!-- 
CRF Reference No: ML-MMOH-CRF-2111
Detected Release: JUNE24
File Prepared by: Ajay Hatwate
File Prepared on: 10/04/2024
-->
<%@ page import="java.sql.*, java.util.*, java.text.*,webbeans.eCommon.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8" %>
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 

<%
	String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); 

String facilityId = (String) session.getValue("facility_id");
String disaster_catg_param = "N";
Connection con = null;
PreparedStatement pstmt=null;
ResultSet rset=null;
try{
	con = ConnectionManager.getConnection(request);
	pstmt = con.prepareStatement("select ENABLE_DISASTER_CATEG from ae_param where operating_facility_id = ?");
	pstmt.setString(1, facilityId);
	rset = pstmt.executeQuery();
	rset.next();
	disaster_catg_param = rset.getString("ENABLE_DISASTER_CATEG");

	System.out.println(disaster_catg_param + " : ENABLE_DISASTER_CATEG ");
}catch(Exception e){
	e.printStackTrace();
}


%>
<html>
<head>
<link rel="stylesheet" type="text/css" href="../../eCommon/html/<%=sStyle%>">
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script><script Language="JavaScript" src="../../eAE/js/DisasterCategory.js"></script>
<script src="../../eCommon/js/common.js" language="javascript"></script>
</head>
<%
String params = request.getQueryString() ;
if(disaster_catg_param.equals("Y")){
%>
<!--
<iframe name="commontoolbarFrame" id="commontoolbarFrame" src="../../eCommon/jsp/MstCodeToolbar.jsp?<%=params %>" height="8%" width="100%" style="" "border:1;" scrolling="no" noresize></iframe>
<iframe name="f_query_add_mod" id="f_query_add_mod" src="../../eCommon/html/blank.html" height="82%" width="100%" style="border:2;" ></iframe>
<iframe name="messageFrame" id="messageFrame" src="../../eCommon/jsp/error.jsp" height="10%" width="100%" style="" "border:3;" scrolling="auto" noresize></iframe>
-->

<iframe name='commontoolbarFrame' id='commontoolbarFrame' id='commontoolbarFrame' src="../../eCommon/jsp/MstCodeToolbar.jsp?<%=params %>" frameborder=0 scrolling='no' noresize frameborder='0' style='height:8%;width:100vw'></iframe>
	<iframe name='f_query_add_mod' id='f_query_add_mod' id='f_query_add_mod' src='../../eCommon/html/blank.html' frameborder=0 scrolling='no' noresize frameborder='0' style='height:100vh;width:100vw'></iframe>
	<iframe name='messageFrame' id='messageFrame' id='messageFrame' src='../../eCommon/jsp/error.jsp' frameborder=0 noresize scrolling='auto' frameborder='0' style='height:10%;width:100vw'></iframe>
<%
}else{%>
	<script>
	var msg = getMessage("DISASTER_CATEGORIZAION_NOT_ENABLE", 'AE');
	alert(msg);
	//location.reload();
	parent.parent.parent.frames[1].expand(this);
	</script>
	
<% }%>

</html>
<%!	
	private String checkForNull(String inputString)
	{
		return (inputString==null)	?	""	:	inputString;
	}
	public static String checkForNull(String inputString, String defaultValue)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? defaultValue : inputString);
	}
%>

