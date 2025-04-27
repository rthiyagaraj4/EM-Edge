<!DOCTYPE html>
<%--
	FileName	: ExtPractitionerReferralQueryMain.jsp
	Version	    : 3	
	Modified On	: 17-2-2005
--%>
<%
	String sStyle =
	(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

%>
<%@ page contentType="text/html;charset=UTF-8" import="java.sql.*, webbeans.eCommon.*" %>
<jsp:useBean id="accessRightRecSet" class="webbeans.eCommon.RecordSet" scope="session"/> 
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 

<%
request.setCharacterEncoding("UTF-8");
	String facilityId = request.getParameter("facilityId");
		if(facilityId == null) facilityId="";
	accessRightRecSet.clearAll();
%>
<html>
<head>
		<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
	<script language='javascript' src='../../eAM/js/OPSPractitioner.js'></script>
	<script src='../../eCommon/js/common.js' language='javascript'></script>
	<script language='javascript' src='../../eCommon/js/ValidateControl.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>

<iframe name='f_query_add_mod_query' id='f_query_add_mod_query'  src='../../eAM/jsp/AddModifyPractForExternalReferral.jsp?facilityId=<%=facilityId%>' frameborder=0 noresize scrolling='no' style='height:25vh;width:100vw'></iframe>
<iframe name='f_query_add_mod_res' id='f_query_add_mod_res' 	 src='../../eCommon/html/blank.html' frameborder=0 noresize scrolling='no' style='height:70vh;width:100vw'></iframe>
<iframe name='dummy' id='dummy' src='../../eCommon/html/blank.html' frameborder=0 noresize scrolling='no' style='height:0vh;width:100vw'></iframe>

</html>

