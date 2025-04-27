<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%
	request.setCharacterEncoding("UTF-8");
%>
<html>
<head>
<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
<script src="../../eCommon/js/common.js" language="javascript"></script>
<script src='../../eMP/js/EntitlementPlan.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<%
	//String url = "../../eCommon/jsp/MstCodeToolbar.jsp?";
	//String params = request.getQueryString();
	//String toolBar = url + params;
%>
	<iframe name='addModifySearch' id='addModifySearch' src ='../../eMP/jsp/EntitlementPlanQueryPage.jsp' frameborder=0 scrolling='no' style='height:19vh;width:100vw'></iframe>
	<iframe name='addModifyResult' id='addModifyResult' src ='../../eCommon/html/blank.html' frameborder=0 noresize scrolling='no' style='height:81vh;width:100vw'></iframe>
</head>
</html>

