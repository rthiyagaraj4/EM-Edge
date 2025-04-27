<!DOCTYPE html>
<%@ page import ="java.sql.*,java.util.*,java.net.*,java.text.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%
	request.setCharacterEncoding("UTF-8");

	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");

	String module_id = request.getParameter("module_id");
	if(module_id==null) module_id="";
	
%>
<html>
<head>
<title><fmt:message key="eOP.ItemBatchResult.label" bundle="${op_labels}"/></title>
<!-- <link rel='stylesheet' type='text/css' href='../../eCommon/html/IeStyle.css'></link> -->
<%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<script src="../../eCommon/js/ValidateControl.js"></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
	
<iframe name='Selection' id='Selection' src="../../eOP/jsp/AddModifyBatchProcess.jsp?module_id=<%=module_id%>" noresize  frameborder=no marginheight=0 marginwidth=0 SCROLLING=no style='height:12vh;width:100vw'></iframe>
<iframe name='Criteria' id='Criteria' src='../../eCommon/html/blank.html' noresize  frameborder=no marginheight=0 marginwidth=0 SCROLLING=no style='height:32vh;width:100vw'></iframe>
<iframe name='Criteria1' id='Criteria1' src='../../eCommon/html/blank.html' noresize frameborder='no' marginheight='0' marginwidth='0' scrolling='auto' style='height:55vh;width:100vw'></iframe>
<iframe name='button' id='button' src='../../eCommon/html/blank.html' noresize frameborder='no' marginheight='0' marginwidth='0' scrolling='no' style='height:0vh;width:100vw'></iframe>
</head>
</html>

