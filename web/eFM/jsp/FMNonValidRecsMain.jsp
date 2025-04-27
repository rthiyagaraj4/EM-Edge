<!DOCTYPE html>
<%@ page import ="java.sql.*, java.text.*,webbeans.eCommon.*"  contentType="text/html; charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<html>
<head>
	<!-- <link rel='stylesheet' type ='text/css' href='../../eCommon/html/IeStyle.css'></link> -->
<%
	request.setCharacterEncoding("UTF-8");
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
	<script language='javascript' src='../../eCommon/js/common.js'></script>
	<script language='javascript' src='../../eCommon/js/ValidateControl.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<title><fmt:message key="eFM.ChangeFileReturnDateFilesNotAllowed.label" bundle="${fm_labels}"/></title>
<%
	String patient_id = request.getParameter("patient_id");
%>
	 <iframe name='NonValidRecsFrame' id='NonValidRecsFrame' src='../../eFM/jsp/FMNonValidRecsResult.jsp?patient_id=<%=patient_id%>' frameborder=0 scrolling=auto noresize style='height:82%;width:100vw'></iframe>
		<iframe name='NonValidRecsColorFrame' id='NonValidRecsColorFrame' src='../../eFM/jsp/FMNonValidRecsColor.jsp' scrolling=no frameborder=0 noresize style='height:15%;width:100vw'></iframe>
	 
</html>


