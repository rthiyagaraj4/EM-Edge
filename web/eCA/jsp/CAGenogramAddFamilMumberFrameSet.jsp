<!DOCTYPE html>
<%
/* 
--------------------------------------------------------------------------------------------------------------------
Date       	Edit History	Name        	Description
--------------------------------------------------------------------------------------------------------------------
06/09/2013	IN030457		Ramesh G		Bru-HIMS-CRF-016
06/09/2013	IN030458		Ramesh G		Bru-HIMS-CRF-017
 
--------------------------------------------------------------------------------------------------------------------
*/
%>
<%@ page import="eCommon.XSSRequestWrapper" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<html>
<%
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
%>
	<head><title>Genogram - Add Family Member</title> 
<%
	String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
	<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
	</head>
	<iframe name='genogramAddFamilyMemberDtls' id='genogramAddFamilyMemberDtls' src="../../eCA/jsp/CAGenogramAddFamilyDtls.jsp?<%=request.getQueryString()%>" frameborder='0' noresize scrolling='no' style='height:38%;width:100vw'></iframe><iframe name='genogramAddFamilyMemberFram' id='genogramAddFamilyMemberFram' src='../../eCA/jsp/blank.jsp' frameborder=0 scrolling=yes noresize style='height:100vh;width:100vw'></iframe>
		<iframe name='genogramAddFamilyMemberBtn' id='genogramAddFamilyMemberBtn' src='../../eCA/jsp/CAGenogramAddFamilyBtn.jsp?<%=request.getQueryString()%>' frameborder=0 scrolling=no noresize style='height:3%;width:100vw'></iframe>
		<iframe name='messageFrame' id='messageFrame' src='../../eCommon/jsp/MstCodeError.jsp' noresize  frameborder=0  marginheight=0 marginwidth=0 SCROLLING='auto' noresize style='height:5%;width:100vw'></iframe> 
	
</html>

