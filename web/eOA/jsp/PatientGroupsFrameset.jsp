<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 

<%@ page contentType="text/html;charset=UTF-8"  %>
<html>
<head>
	<%
	request.setCharacterEncoding("UTF-8");
	String sStyle	=
	(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	%>
	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
	<Script language="JavaScript" src="../../eCommon/js/common.js"></Script>
	<Script Language="JavaScript" src="../../eCommon/js/rowcolor.js"></Script>
	<script language='javascript' src='../../eCommon/js/DateUtils.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>	
	
	<iframe name='GROUP_DETAILS' id='GROUP_DETAILS' FRAMEBORDER='0' SRC="../../eOA/jsp/PatientGrpDetails.jsp"  noresize style='height:100vh;width:48vw'></iframe>		
		<iframe name='ADD_GROUP' id='ADD_GROUP' FRAMEBORDER='0' src="../../eOA/jsp/PatientGrpCreate.jsp" noresize style='height:100vh;width:50vw'></iframe>			
	
</html>

