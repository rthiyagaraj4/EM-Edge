<!DOCTYPE html>
<%@ page import="eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%
	request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	String email_to_pat_id_yn = request.getParameter("email_to_pat_id_yn") == null ? "N" : request.getParameter("email_to_pat_id_yn");
	String email_to_any_id_yn = request.getParameter("email_to_any_id_yn") == null ? "N" : request.getParameter("email_to_any_id_yn");

	String rows = "39%,*,10%";

	if(email_to_pat_id_yn.equals("N") && email_to_any_id_yn.equals("N")) rows = "0%,*,10%";
	else rows = "39%,*,10%";

%>
<title><%=request.getParameter("title")%></title>
<!-- <script>
//	alert('here --- inside main---');
//	alert('<%=request.getQueryString()%>');
</script> -->
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />
<script language="javascript" src="../../eCommon/js/common.js"></script>
<script language='javascript' src="../../eCommon/js/ValidateControl.js"></script>
<script language="javascript" src="../js/EMail.js"></script>
<frameset rows='<%=rows%>' frameborder=0 id='patAdhRegFrameset'>
	<frame name='emailPatAdhFrame' id='emailPatAdhFrame' src='../../eCA/jsp/EMailPatAdhNames.jsp?<%=request.getQueryString()%>' scrolling='no'></frame>
	<frame name='emailRegPatFrame' id='emailRegPatFrame' src='../../eCA/jsp/EMailRegNames.jsp?<%=request.getQueryString()%>'></frame>
	<frame name='emailRegBlankFrame' id='emailRegBlankFrame' src='../../eCommon/jsp/error.jsp'></frame>
</frameset>

