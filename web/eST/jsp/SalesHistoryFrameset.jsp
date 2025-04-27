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
	<script language="JavaScript" src="../js/SalesHistory.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
 
</head>
<iframe name="criteria" id="criteria" frameborder="0" scrolling="no" noresize src="../../eST/jsp/SalesHistoryQueryCriteria.jsp" style="height:20vh;width:100vw"></iframe>
<iframe name="result" id="result" src="../../eCommon/html/blank.html" frameborder="0" noresize scrolling="no" style="height:80vh;width:100vw"></iframe>
</html>


