<!DOCTYPE html>
<%-- JSP Page specific attributes start --%>
<%@page contentType="text/html;charset=UTF-8" import="java.util.*, ePH.*, ePH.Common.*, eCommon.Common.*,eCommon.XSSRequestWrapper" %>
<%-- JSP Page specific attributes end --%>

<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>


<%-- Mandatory declarations end --%>
<html>
<head>
<%
	 request.setCharacterEncoding("UTF-8");
//added By Himanshu for COMMON-ICN-0182 on 17/10/2023 Start.
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086
//end.
	String sStyle=(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

	String sPatientId	= request.getParameter("patientId");
	String sOrderId		= request.getParameter("orderId");

%>
<title><fmt:message key="ePH.PPN.label" bundle="${ph_labels}"/> <fmt:message key="Common.Orders.label" bundle="${common_labels}"/>	</title>
 <link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
 
	<script language="javascript" src="../../eCommon/js/common.js"></script>
	<script language="javascript" src="../js/PhCommon.js"></script>
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="javascript" src="../../ePH/js/PPNRegimen.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>


<iframe name="PPNSearchCriteria" id="PPNSearchCriteria" frameborder="0" scrolling="no" noresize src="../../ePH/jsp/PPNSearchCriteria.jsp?patientId=<%=sPatientId%>&orderId=<%=sOrderId%>" style="height:12vh;width:100vw"></iframe><iframe name="PPNSearchResult" id="PPNSearchResult" frameborder="0" scrolling="no" noresize src="../../ePH/jsp/PPNSearchResult.jsp" style="height:88vh;width:100vw"></iframe>	

</html>

