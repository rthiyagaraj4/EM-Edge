<!DOCTYPE html>
<%@page contentType="text/html;charset=UTF-8" import="eCommon.XSSRequestWrapper" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<html>
<title><fmt:message key="eCA.PerformedDetails.label" bundle="${ca_labels}"/></title>
<head>
<%
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
String sStyle =

(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

%>

	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />
	<link rel="stylesheet" type="text/css" href="../../eCommon/html/CommonCalendar.css"></link>
	<script language="javascript" src="../../eCommon/js/common.js"></script>
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="javascript" src="../../eCommon/js/dchk.js"></script>
	<script language="javascript" src="../../eCA/js/PatTaskList.js"></script>
	<script type="text/javascript" src="../../eCommon/js/CommonCalendar.js"></script>
	<Script language ="JavaScript" src ='../../eCommon/js/CommonLookup.js'></Script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<%
String status = request.getParameter("status")==null ? "" : request.getParameter("status");

if(status.equals(""))
{
%>
<iframe src='../../eCA/jsp/PatTaskListPerformTop.jsp?<%=request.getQueryString()%>' noresize scrolling ='no' name='patTaskListPerformTopFrame' frameborder='0' style='height:34vh;width:100vw'></iframe><iframe src='../../eCommon/html/blank.html' noresize scrolling ='no'  name='patTaskListPerformFrame' id='patTaskListPerformFrame' frameborder='0' style='height:100vh;width:100vw'></iframe><iframe src='../../eCommon/jsp/MstCodeError.jsp' noresize scrolling ='no' name='messageFrame' id='messageFrame' style='height:0%;width:100vw'></iframe>
<%
}
else
{
%>
<iframe src='../../eCA/jsp/PatTaskListPerform.jsp?<%=request.getQueryString()%>' noresize scrolling ='no' name='patTaskListPerformFrame' style='height:98vh;width:99vw'></iframe><iframe src='../../eCommon/jsp/MstCodeError.jsp' noresize scrolling ='no' name='messageFrame' id='messageFrame' style='height:0%;width:100vw'></iframe>

<%
}
%>
</html>

