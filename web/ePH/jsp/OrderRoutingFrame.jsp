<!DOCTYPE html>
 <%-- JSP Page specific attributes start --%>
<%@page contentType="text/html;charset=UTF-8" import="java.util.*, ePH.*, ePH.Common.*, eCommon.Common.*" %>
<%-- JSP Page specific attributes end --%>

<%-- Mandatory declarations start --%>

<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%-- Mandatory declarations end --%>
<html>
<head>
	<%
	request.setCharacterEncoding("UTF-8");
	String locale			= (String)session.getAttribute("LOCALE");
	

String sStyle=(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>

	<script language="JavaScript" src="../js/PhCommon.js"></script>
	<script language="JavaScript" src="../js/OrderRouting.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<%
	String param = request.getParameter("param");
	if (param == null) param = "";
	if (param.equals("createIfFrameIsNull")){
%>
<iframe name="orderrouting_top" id="orderrouting_top" frameborder="0" scrolling="no" noresize  src="../../ePH/jsp/OrderRoutingCharAddModify.jsp?mode=<%=CommonRepository.getCommonKeyValue("MODE_INSERT")%>" style="height:20vh;width:100vw"></iframe><iframe name="orderrouting_middle" id="orderrouting_middle" frameborder="0" scrolling="auto" noresize src="../../ePH/jsp/OrderRoutingLocnDetAddModify.jsp?mode=<%=CommonRepository.getCommonKeyValue("MODE_INSERT")%>" style="height:43vh;width:100vw"></iframe><iframe name="orderrouting_bottom" id="orderrouting_bottom" frameborder="0" scrolling="no" noresize src="../../ePH/jsp/OrderRoutingLocationAddModify.jsp?mode=<%=CommonRepository.getCommonKeyValue("MODE_INSERT")%>" style="height:34vh;width:100vw"></iframe>
<%
	}else{
%>
<iframe name="orderrouting_top" id="orderrouting_top" frameborder="0" scrolling="no" noresize  src="../../eCommon/html/blank.html" style="height:20vh;width:100vw"></iframe><iframe name="orderrouting_middle" id="orderrouting_middle" frameborder="0" scrolling="auto" noresize src="../../eCommon/html/blank.html" style="height:43vh;width:100vw"></iframe><iframe name="orderrouting_bottom" id="orderrouting_bottom" frameborder="0" scrolling="no" noresize src="../../eCommon/html/blank.html" style="height:34vh;width:100vw"></iframe>
<%
	}
%>


</html>

