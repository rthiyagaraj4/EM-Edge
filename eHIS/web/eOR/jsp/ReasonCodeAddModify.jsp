<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%@ page import="eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8"%>
<%
	request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String function_id = request.getParameter( "function_id" ) ;

%>
<html>
<head>
	<script language="JavaScript" src="../../eOR/js/ReasonCode.js"></script>
 	<script language="JavaScript" src="../../eOR/js/OrCommon.js"></script>

	<script language="JavaScript"> function_id = "<%=function_id%>"</script>
	<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<%@ page session="false" %>
</head>
<%
	String mode = request.getParameter("mode");
	String action_type= request.getParameter("action_type");
	String action_reason_code= request.getParameter("action_reason_code");
	String action_reason_desc= request.getParameter("action_reason_desc");
	String action_description= request.getParameter("action_description");
	String eff_status= request.getParameter("eff_status");

	if(action_type == null)action_type = "";
	if(action_reason_code == null)action_reason_code = "";
	if(action_reason_desc == null)action_reason_desc = "";
	if(action_description == null)action_description = "";
	if(eff_status == null)eff_status = "";
	if(mode == null)mode = "";
	
	mode = mode.trim();

	if(!(mode.equals("2"))){
		mode = "1";
	}
%>
<iframe name='reason_code_top' id='reason_code_top' src='ReasonCodeAddModifyReason.jsp?mode=<%=mode%>&action_type=<%=action_type%>&action_reason_code=<%=action_reason_code%>&action_reason_desc=<%=action_reason_desc%>&eff_status=<%=eff_status%>&action_description=<%=action_description%>' frameborder=0 scrolling='no' noresize style='height:36vh;width:95vw'></iframe>
<iframe name='reason_code_bottom' id='reason_code_bottom' src='ReasonCodeAddModifyReasonOrdCat.jsp?mode=<%=mode%>&action_type=<%=action_type%>&action_reason_code=<%=action_reason_code%>&action_reason_desc=<%=action_reason_desc%>&eff_status=<%=eff_status%>&function_id=<%=function_id%>&action_description=<%=action_description%>' frameborder=0 style='height:66vh;width:98vw'></iframe>
</html>									

