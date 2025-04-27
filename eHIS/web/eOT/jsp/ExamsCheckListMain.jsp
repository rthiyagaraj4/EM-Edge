<!DOCTYPE html>
<!--
Developed by    : Bhavani Shankar.
Module/Function : RD Exams CheckList 
start date		: 25/05/2005
-->
<%@page  import="eOT.*,eOT.Common.*" %>
<%@page  contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<% request.setCharacterEncoding("UTF-8");%>
<%@include file="../../eCommon/jsp/Common.jsp" %>
<html>
<head>
	<%
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
	<script language="javascript" src="../../eCommon/js/common.js"></script>
	<script language="JavaScript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="javascript" src="../../eOT/js/ExamsCheckList.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<title><fmt:message key="eOT.ExamsCheckList.Label" bundle="${ot_labels}"/></title>
<%
	String url = "../../eCommon/jsp/commonToolbar.jsp?" ;
	String params = request.getQueryString() ;
	String source = url + params ;
%>
<script>
</script>

<iframe name="commontoolbarFrame" id="commontoolbarFrame"  scrolling="no" noresize src="<%= source %>" style="height:5vh;width:100vw"></iframe>
<iframe name="f_header" id="f_header"  scrolling="no" noresize src="../../eOT/jsp/ExamsCheckListHeader.jsp?<%=params%>" style="height:0vh;width:100vw"></iframe>
<iframe name="f_header_title" id="f_header_title"  scrolling="no" noresize src="../../eCommon/html/blank.html" style="height:4vh;width:100vw"></iframe>
<iframe name="f_details" id="f_details"  scrolling="auto" noresize src="../../eCommon/html/blank.html" style="height:82vh;width:100vw"></iframe>
<iframe name="messageFrame" id="messageFrame" src="../../eCommon/jsp/error.jsp"  noresize scrolling="auto" style="height:9vh;width:100vw"></iframe>
</html>

