<!DOCTYPE html>
<html>
	<head>
		<%@page
		import="java.util.*,webbeans.eCommon.*,eCommon.Common.*,java.sql.*"%>
		<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
		<%@ page contentType="text/html;charset=UTF-8" %>
		<%request.setCharacterEncoding("UTF-8"); %>
		<script language='javascript' src='../../eXI/js/ViewGRNS.js'></script>
		<script language='javascript' src='../../eCommon/js/common.js'></script>
		<script type="text/javascript"
			src="../../eCommon/js/CommonCalendar.js"></script>
		<script language='javascript'
			src='../../eCommon/js/ValidateControl.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	</head>
	<%
	String params = request.getQueryString();
	%>
	<title><fmt:message key="eXI.ViewSingleFrameDtls.Label" bundle="${xi_labels}" /></title>
	<iframe name='f_query_single_rst_dtl' id='f_query_single_rst_dtl'
			src="../../eXI/jsp/ViewSingleFormDetails.jsp?<%=params%>"
			frameborder=0 scrolling='auto' style='height:99vh;width:99vw'></iframe>
</html>

