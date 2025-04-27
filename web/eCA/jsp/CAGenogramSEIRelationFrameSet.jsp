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
	<head><title>Genogram - Add Relatonships</title>
<%
	String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
	<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
	</head>
	<frameset rows="32%,27%,32%,4%,5%">		
		<frame name='genogramFamilyMemberDtlsFrame' id='genogramFamilyMemberDtlsFrame' src="../../eCA/jsp/CAGenogramFamilyDtls.jsp?<%=request.getQueryString()%>" frameborder='0' noresize scrolling='no'>
		<frame name='genogramAddSEIRelationFrame' id='genogramAddSEIRelationFrame' src='../../eCA/jsp/CAGenogramAddSEIRelation.jsp?<%=request.getQueryString()%>' frameborder=0 scrolling=no noresize>
		<frame name='genogramSEIRelationDtlsFrame' id='genogramSEIRelationDtlsFrame' src='../../eCA/jsp/CAGenogramSEIRelationDtls.jsp?<%=request.getQueryString()%>' frameborder=0 scrolling=no noresize>
		<frame name='genogramSEIRelationBtnFrame' id='genogramSEIRelationBtnFrame' src='../../eCA/jsp/CAGenogramSEIRelationBtn.jsp?<%=request.getQueryString()%>' frameborder=0 scrolling=no noresize>
		<!--<frame name='genogramAddSEIRelationFrame' id='genogramAddSEIRelationFrame' src='../../eCA/jsp/blank.jsp' frameborder=0 scrolling=no noresize>
		<frame name='genogramSEIRelationDtlsFrame' id='genogramSEIRelationDtlsFrame' src='../../eCA/jsp/blank.jsp' frameborder=0 scrolling=no noresize>  -->
		<frame name='messageFrame' id='messageFrame' src='../../eCommon/jsp/MstCodeError.jsp' noresize  frameborder=0  marginheight=0 marginwidth=0 SCROLLING='auto' noresize> 
	</frameset>
</html>

