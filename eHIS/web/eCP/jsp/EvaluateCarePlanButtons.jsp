<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%--
*	Copyright © MEDICOM Solutions (P) Ltd. ALL RIGHTS RESERVED
*	Application		:	eCP
*	Purpose 		:	
*	Created By		:	Vinay.
*	Created On		:	30 Mar 2005
--%><html>
<%@page contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<head>
<%
//This file is saved on 18/10/2005.
String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
<link rel="stylesheet" type="text/css" href="../../eCommon/html/CommonCalendar.css"></link>
<script src="../../eCP/js/common.js" language="JavaScript"></script>
<script src="../../eCommon/js/common.js" language="JavaScript"></script>
<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
<script type="text/javascript" src="../../eCommon/js/CommonCalendar.js"></script>
<script language="JavaScript" src="../../eCommon/js/CommonLookup.js"></script>
<script src="../../eCP/js/EvaluateCarePlan.js" language="JavaScript"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<body OnMouseDown='CodeArrest()'>
<form name='eval_cp_buttons' id='eval_cp_buttons'>
<table border="0" cellpadding="0" cellspacing="0" width="100%" align='center'>
<tr>
	<td align='right'><INPUT class='button' TYPE="button" value='<fmt:message key="Common.record.label" bundle="${common_labels}"/>
' onclick='funcrecord()'>
	<INPUT class='button' TYPE="button" value='<fmt:message key="Common.close.label" bundle="${common_labels}"/>
' onclick='wincls()'></td>
</tr>
</table>
</form>
</body>
</html>

