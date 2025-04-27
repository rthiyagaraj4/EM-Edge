<!DOCTYPE html>
<!--
	Developed by 	:	Suman
	Created on 	:	14/04/2005
	Module		:	OA
	Function	:	Invite WaitList
--><%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<%@ page contentType="text/html;charset=UTF-8" import="java.sql.*,java.text.*,webbeans.eCommon.*,eCommon.XSSRequestWrapper" %>
 <%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<html>
	<title><fmt:message key="eOA.InvitationStatus.label" bundle="${oa_labels}"/></title>

<head>
	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
	<script src='../../eOA/js/oamessages.js' language='javascript'></script>
    <script language='javascript' src='../../eOA/js/WaitListInvitation.js'></script>
    <script language="javascript" src="../../eCommon/js/messages.js"></script>
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
	
</head>

<%	
		request.setCharacterEncoding("UTF-8");
		request= new XSSRequestWrapper(request);
		response.addHeader("X-XSS-Protection", "1; mode=block");
		response.addHeader("X-Content-Type-Options", "nosniff");
		String s=request.getQueryString();
	
	try{

			
%>
		<iframe name='criteria' id='criteria'  src='../../eOA/jsp/InvitationStatusCriteria.jsp?<%=s%>' frameborder=0 noresize scrolling='No' style='height:39vh;width:100vw'></iframe>
		<iframe name='query_search_header' id='query_search_header' src='../../eCommon/html/blank.html' frameBorder=0 noresize scrolling='no' style='height:7vh;width:100vw'></iframe>
		<iframe name='query_search_result' id='query_search_result' src='../../eCommon/html/blank.html' frameBorder=0 noresize scrolling='auto' style='height:50vh;width:100vw'></iframe>
		<iframe name='messageFrame' id='messageFrame'	 src='../../eCommon/jsp/error.jsp' frameborder=0 noresize scrolling=auto style='height:0vh;width:100vw'></iframe>

</html>

<%

	
}
catch(Exception es){
//out.println(es);
es.printStackTrace();//Added by Kamatchi S for security issue against COMMON-ICN-0165
}
finally{
}

%>

