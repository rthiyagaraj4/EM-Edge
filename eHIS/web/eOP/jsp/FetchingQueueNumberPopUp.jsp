<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%@ page import ="java.util.*,java.sql.*,webbeans.eCommon.*,eCommon.Common.*,eCommon.XSSRequestWrapper"  contentType="text/html;charset=UTF-8" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<% request.setCharacterEncoding("UTF-8"); %>
<HTML>
<head>
<title>
</title>
	<% 
	String sStyle=(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	
	String duration=request.getParameter("duration");
	java.util.Properties p=null;
	p = (java.util.Properties) session.getValue("jdbc");
	String locale="";
	locale = p.getProperty("LOCALE");
	java.util.Hashtable message = MessageManager.getMessage(locale, "QUEUE_NO_RETRIVAL_PROCESS", "OP");
	String success_msg = ((String) message.get("message"));
	%>
			<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
			<script language='javascript' src="../../eOP/js/ConsPatArrival.js"></script>
			<script language="javascript" src="../../eCommon/js/common.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<body >
<br><br>
<center><p style="display: inline-block; margin-bottom: 70px;font-size: 17px"><%=success_msg%></p></center>
<div >

</div>
	<Script>
	var timeout_duration=<%=duration%>;
	setTimeout(function(){
		window.exitContact();
		}, timeout_duration);
	</Script>
</body>
</HTML>

