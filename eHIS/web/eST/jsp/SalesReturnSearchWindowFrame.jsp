<!DOCTYPE html>
<%@ page import ="eST.*, eST.Common.* , eCommon.Common.*,java.util.*,webbeans.eCommon.*" contentType="text/html;charset=UTF-8"%> 
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp"%> 
<%@include file="../../eCommon/jsp/CommonBean.jsp"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html> 
<head>
<% 

	 request.setCharacterEncoding("UTF-8");

		String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	%>

	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' ></link>
	<script language="JavaScript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="JavaScript" src="../../eCommon/js/common.js"></script>
	<script language="JavaScript" src="../../eST/js/StCommon.js"></script>
	<script language="JavaScript" src="../../eST/js/StTransaction.js"></script>
	<script language="JavaScript" src="../../eST/js/SalesReturn.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	<title><fmt:message key="eST.SalesReturnDetails.label" bundle="${st_labels}"/></title>
</head>
<%
	String params = request.getQueryString();
%>
<iframe name="frameSalesReturnSearchWindowCriteria" id="frameSalesReturnSearchWindowCriteria" frameborder="0" scrolling="no" noresize src="../../eST/jsp/SalesReturnSearchWindowCriteria.jsp?<%=params%>" style="height:50vh;width:100vw"></iframe>
<iframe name="frameSalesReturnSearchWindowResult" id="frameSalesReturnSearchWindowResult" frameborder="0" src="../../eCommon/html/blank.html" scrolling="auto"  style="height:40vh;width:100vw"></iframe>
</html>

