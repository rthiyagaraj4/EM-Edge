<!DOCTYPE html>
<%@ page import ="java.sql.*,webbeans.eCommon.*" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<html>
<head>
<TITLE><fmt:message key="eMR.Modification.label" bundle="${mr_labels}"/>&nbsp;<fmt:message key="Common.details.label" bundle="${common_labels}"/></TITLE>

	
	<script src='../../eCommon/js/common.js' language='javascript'></script>
	<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
	<script language='javascript' src="../js/MedRecRequestButtons.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<%
	request.setCharacterEncoding("UTF-8");
    String params = request.getQueryString() ;
%>
</head>
				
	<iframe name='searchCriteria' id='searchCriteria' src='../../eMR/jsp/MedRecRequestModificationDtls.jsp?<%=params%>' frameborder=0  scrolling='auto' style='height:100vh;width:100vw'></iframe><iframe name='messageFrame' id='messageFrame' src='../../eCommon/jsp/error.jsp' frameborder=0 noresize scrolling='auto' style='height:20%;width:100vw'></iframe>
</html>

