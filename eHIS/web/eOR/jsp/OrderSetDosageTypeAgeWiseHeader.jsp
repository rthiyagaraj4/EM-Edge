<!DOCTYPE html>
<!--
------------------------------------------------------------------------------------------------------------------------------
Date       	Edit History    Name        	Rev.Date		Rev.Name		Description
------------------------------------------------------------------------------------------------------------------------------
12/02/2018	IN065713		Dinesh T		12/02/2018		Ramesh G		This file is created for ML-MMOH-CRF-0987 
12/02/2018	IN065713		Dinesh T		12/02/2018		Ramesh G		ML-MMOH-CRF-0987
																			Created this file for this CRF
------------------------------------------------------------------------------------------------------------------------------
-->
<%-- JSP Page specific attributes end --%>
<%-- Mandatory declarations start --%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %> 
<%-- Mandatory declarations end --%>
<head>
<script language="JavaScript" src="../../eCommon/js/common.js"></script>
<script language='javascript' src='../js/OrCommon.js'></script>
<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
<script language='javascript' src='../js/OrderSet.js'></script>
<script language="JavaScript" src="../../eCommon/js/CommonLookup.js"></script>
<script language="javascript" src="../js/OrCommonFunction.js"></script>
</head>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@ page language="java" contentType="text/html;charset=UTF-8"%>
<%
	request.setCharacterEncoding("UTF-8");
	String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
<title></title>
</head>
<body>
<table cellpadding='3' cellspacing='0' border='1' width='30%' align='left' class='grid'>
<tr>
<td width ='10%' class='clicked' id='age_grp_tab' style="text-align:center;valign:middle">
<b>Age Group</b>
</td>
<td width ='30%' class='normal' id='age_grp_add_cata_tab' style="text-align:center;valign:middle">
<b>Order Set Additional</b>
</td>
</tr>
</table>
</body>
</html>

