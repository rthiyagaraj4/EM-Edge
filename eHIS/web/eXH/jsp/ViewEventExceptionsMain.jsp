<!DOCTYPE html>
<html>
<%@ page import = "eXH.XHDBAdapter" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%
String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

<head>
	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
	<script language="javascript" src="../../eCommon/js/common.js" ></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
</head>
<title><fmt:message key="Common.Review.label" bundle="${common_labels}"/></title>

<%
try
{
String applicationID = XHDBAdapter.checkNull(request.getParameter("applicationID"));
String facilityID = XHDBAdapter.checkNull(request.getParameter("facilityID"));
String msgID = XHDBAdapter.checkNull(request.getParameter("msgID"));
String srlNo = XHDBAdapter.checkNull(request.getParameter("srlNo"));
String sub_module = XHDBAdapter.checkNull(request.getParameter("sub_module"));
String protocolMode = XHDBAdapter.checkNull(request.getParameter("protocolMode"));
String protocol_link_id = XHDBAdapter.checkNull(request.getParameter("protocol_link_id"));
String purge_status = XHDBAdapter.checkNull(request.getParameter("purge_status"));

String url = "../../eXH/jsp/ViewEventExceptionsHeader.jsp?applicationID="+applicationID+"&facilityID="+facilityID+"&msgID="+msgID+"&srlNo="+srlNo+
				"&sub_module="+sub_module+"&protocolMode="+protocolMode+"&protocol_link_id="+protocol_link_id+"&purge_status="+purge_status;
%>
<iframe name='resultsFrame' id='resultsFrame' src="<%= url %>" scrolling="no" frameborder="0" noresize style='height:96vh;width:100vw'></iframe>
	<iframe name='messageFrame' id='messageFrame'	src="../../eCommon/jsp/MstCodeError.jsp" frameborder=0 noresize scrolling='no' style='height:4vh;width:100vw'></iframe>

<%
}
catch(Exception exp)
{
	exp.printStackTrace(System.err);
}
%>


</html>

