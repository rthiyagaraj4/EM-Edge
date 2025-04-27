<!DOCTYPE html>
<%@ page import ="java.sql.*,java.util.*,webbeans.eCommon.*,java.lang.*" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp"%> 
<html> 
<head>
	<%
	request.setCharacterEncoding("UTF-8");

String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute
("PREFERRED_STYLE"):"IeStyle.css";
%> 

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' 
type='text/css' ></link>
	<script language="JavaScript" src="../../eCommon/js/common.js"></script>
	<script language="JavaScript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="JavaScript" src="../js/StCommon.js"></script>
	<script language="JavaScript" src="../js/SalesAndReturnHistory.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
 
</head>
<iframe name='frameSalesAndReturnHistoryQueryCriteria' id='frameSalesAndReturnHistoryQueryCriteria' frameborder="0" scrolling="no" noresize src="../../eST/jsp/SalesAndReturnHistoryQueryCriteria.jsp" style='height:25vh;width:100vw'></iframe>
<iframe name='frameSalesAndReturnHistoryQueryResult' id='frameSalesAndReturnHistoryQueryResult' src="../../eCommon/html/blank.html" frameborder="0" noresize scrolling="auto" style='height:100vh;width:100vw'></iframe>
</html>


