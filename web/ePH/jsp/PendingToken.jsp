<!DOCTYPE html>
<%@page contentType="text/html;charset=UTF-8" import="eCommon.XSSRequestWrapper" %>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<head>

	<script language="JavaScript" src="../../eCommon/js/common.js"></script>
	
<TITLE> <fmt:message key="ePH.PendingTokenDetails.label" bundle="${ph_labels}"/></TITLE>
 </head>

<%
	 request.setCharacterEncoding("UTF-8");
//added By Himanshu for COMMON-ICN-0182 on 17/10/2023 Start.
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086
//end.
	String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

	
%>
<iframe name="f_query_detail" id="f_query_detail" frameborder="0" scrolling="no" noresize src="../../ePH/jsp/PendingTokenDeatils.jsp?<%=request.getQueryString()%>" style="height:89%;width:100vw"></iframe><iframe name="f_query_button" id="f_query_button" frameborder="0" scrolling="no" noresize SRC="../../ePH/jsp/PendingTokenButtons.jsp" style="height:100vh;width:100vw"></iframe>
</html>

