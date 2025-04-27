<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<% request.setCharacterEncoding("UTF-8"); %>
<html>
<head>
	<link rel='stylesheet' type ='text/css' href='../../eCommon/html/IeStyle.css'></link>
	<script Language="JavaScript" src="../../eCommon/js/common.js"></script>
	<!-- <script language='javascript' src='../js/NursingUnit.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
 -->
</head>
	<iframe name='fldframe' id='fldframe' src='../../eOP/jsp/OPStatGetVal.jsp' scrolling='no' frameborder=0 noresize  style='height:20vh;width:100vw'></iframe>
	<iframe name='qryframe' id='qryframe' src='../../eOP/jsp/OPStatQueryResult.jsp?qry=N' scrolling='no' frameborder=0 noresize  style='height:78vh;width:100vw'></iframe>
</html>

