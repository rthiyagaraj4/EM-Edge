<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" import="java.sql.*, webbeans.eCommon.*" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 

<jsp:useBean id="accessRightRecSet" class="webbeans.eCommon.RecordSet" scope="session"/> 
<%
	request.setCharacterEncoding("UTF-8");
	accessRightRecSet.clearAll();
	String facility_id = request.getParameter("facility_id");
		if(facility_id == null) facility_id="";
%>
<html>
<head>
	<link rel='stylesheet' type ='text/css' href='../../eCommon/html/IeStyle.css'></link>
	<script language='javascript' src='../../eAM/js/OtherStaffForFacility.js'></script>
		<script language='javascript' src='../../eCommon/js/ValidateControl.js'></script>
<script src='../../eCommon/js/common.js' language='javascript'></script>
<script language="javascript" src="../../eCommon/js/DateUtils.js"> </script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


</head>
<!-- Modified by Suji Keerthi for MOHE-CRF-0013 -->
<iframe name='f_query_add_mod_query' id='f_query_add_mod_query' 	 src='../../eAM/jsp/OtherStaffForFacilityQuery.jsp?facility_id=<%=facility_id%>' frameborder=0 noresize scrolling='no' style='height:30vh;width:98vw'></iframe>
<iframe name='f_query_add_mod_res' id='f_query_add_mod_res' 	 src='../../eCommon/html/blank.html' frameborder=0 noresize scrolling='no' style='height:65vh;width:98vw'></iframe>

</html>

