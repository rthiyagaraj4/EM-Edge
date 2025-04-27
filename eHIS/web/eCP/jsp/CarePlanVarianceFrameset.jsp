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
*	Created On		:	21 Jan 2005
--%>
<%@page language="java" import ="com.ehis.eslp.*,java.sql.*,java.util.*,webbeans.eCommon.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
<head>
<%
//This file is saved on 18/10/2005.
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

String title="";

String mode=request.getParameter("mode")==null?"":request.getParameter("mode");

if(mode.equals("1"))
  title=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.remarks.label","common_labels");
else
  title=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCP.ActionPlan.label","cp_labels");

String remarks="";
String action_plan="";
%>
<title><%=title%></title>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
<script language="JavaScript" src="../../eCommon/js/common.js"></script>
<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
<script language="JavaScript" src="../../eCP/js/CarePlanVariance.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<body onMouseDown="CodeArrest()"  onload='FocusFirstElement()' onKeyDown="lockKey()" >
<form name=f1>
<table cellpadding=0 cellspacing=0 width="100%" border=0 align="center">
<tr>
<td class="label" colspan="2"></td>
</tr>
<%
if(mode.equals("1"))
{
   remarks=request.getParameter("remarks")==null?"":request.getParameter("remarks");
%>
<tr>
<td class="label" align="center"><fmt:message key="Common.remarks.label" bundle="${common_labels}"/></td>
<td align="center"><textarea name="remarks" cols=40 rows=5 readonly><%=remarks%></textarea></td>
</tr>
<%
}
else
{
  action_plan=request.getParameter("actionplan")==null?"":request.getParameter("actionplan");
%>
<tr>
<td class="label" align="center"><fmt:message key="eCP.ActionPlan.label" bundle="${cp_labels}"/></td>
<td align="center"><textarea name="action_plan" cols=40 rows=5 readonly><%=action_plan%></textarea></td>
</tr>
<%
}
%>
<tr>
<td class="label" colspan="2"></td>
</tr>
<tr>
<td class="label" colspan="2"></td>
</tr>
<tr>
<td class="label" colspan="2"></td>
</tr>
<tr>
<td colspan="2" align="right"><input type="button" class="button" name="close" id="close" value='<fmt:message key="Common.close.label" bundle="${common_labels}"/>' onClick="closeWindow('FS');">&nbsp;&nbsp;</td>
</tr>
<tr>
<td class="label" colspan="2"></td>
</tr>
</table>
</form>
</html>

