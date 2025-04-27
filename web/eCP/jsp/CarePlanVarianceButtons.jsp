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
*	Created By		:	P.Anuradha
*	Created On		:	19 July 2005
--%>
<%@page language="java" import ="com.ehis.eslp.*,java.sql.*,java.util.*,webbeans.eCommon.*" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
<head>
<%
//This file is saved on 18/10/2005.

String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
<script language="JavaScript" src="../../eCommon/js/common.js"></script>
<script language="JavaScript" src="../../eCommon/js/ValidateControl.js"></script>
<script language="JavaScript" src="../../eCP/js/CarePlanVariance.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<body onMouseDown="CodeArrest()"  onload='FocusFirstElement()' onKeyDown="lockKey()" >
<form name="Variance_Buttons" id="Variance_Buttons" method="post" target="messageFrame">
<table cellpadding=0 cellspacing=0 width="100%" border=0>
<tr>
<td align="right" width="90%"><input class="button" type=button name="Variance_Record" id="Variance_Record" value='<fmt:message key="Common.record.label" bundle="${common_labels}"/>' onClick="SubmitRecord();">
</td>
<td align="left" width="10%">&nbsp;<input class="button" type=button name="Variance_Close" id="Variance_Close" value='<fmt:message key="Common.close.label" bundle="${common_labels}"/>' onClick="closeWindow('Buttons');">
</td>
</tr>
</table>
</form>
</body>
</html>

