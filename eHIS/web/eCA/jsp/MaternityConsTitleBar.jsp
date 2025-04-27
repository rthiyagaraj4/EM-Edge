<!DOCTYPE html>
<%@ page import="java.sql.*,webbeans.eCommon.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8"%> 
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
<head>
	<%
		request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
		String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />

	<script src='../../eCA/js/CAMainMenu.js' language='javascript'></script>
	<script src='../../eCA/js/MaternityConsTree.js' language='javascript'></script>
	<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>	
	<script src="../../eCommon/js/common.js" language="javascript"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
 
</head>
<%
String p_event_title=request.getParameter("p_event_title") == null ? "" : request.getParameter("p_event_title");
%>
<body  OnMouseDown='CodeArrest()' onKeyDown="lockKey()">
<FORM METHOD=POST ACTION="" name="matconstitleform" id="matconstitleform">
<TABLE width='100%' align='center' border=0 cellspacing=0>
<TR><TD width='25%' class='label'><b><fmt:message key="Common.open.label" bundle="${common_labels}"/>&nbsp;&nbsp;&nbsp;&nbsp;<a ><%=p_event_title%></a></b></TD></TR>
</TABLE>
</FORM>
</body>
</html>

