<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
<head>
    <script language="JavaScript" src="../../eCommon/js/common.js"></script>
 	<script language="JavaScript" src="../js/RSCommon.js"></script>
	<script language="javascript" src="../js/StaffProfileSetup.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<%
	String staff_id= request.getParameter("staff_id")==null?"":request.getParameter("staff_id");
%>
<title><fmt:message key="eRS.StaffProfile.label" bundle="${rs_labels}"/> - <fmt:message key="eRS.Experience.label" bundle="${rs_labels}"/>-<%=staff_id%></title>
</head>
<iframe name='frameExprHdr' id='frameExprHdr' src="../../eRS/jsp/StaffProfileSetupExprHdr.jsp" frameborder=0	scrolling='auto' noresize style='height:7%;width:100vw'></iframe>
<iframe name='frameExprResult' id='frameExprResult' src="../../eRS/jsp/StaffProfileSetupExprResult.jsp?<%=request.getQueryString()%>" frameborder=0 scrolling='auto' noresize style='height:100vh;width:100vw'></iframe>
<iframe name='frameExprRecord' id='frameExprRecord' src="../../eRS/jsp/StaffProfileSetupExprRecord.jsp?<%=request.getQueryString()%>" frameborder=0 scrolling='no' noresize style='height:51%;width:100vw'></iframe> 
<iframe name='frameError' id='frameError' src="../../eRS/jsp/StaffProfileSetupError.jsp" frameborder=0 scrolling='no' noresize style='height:0.1%;width:100vw'></iframe>

</html>

