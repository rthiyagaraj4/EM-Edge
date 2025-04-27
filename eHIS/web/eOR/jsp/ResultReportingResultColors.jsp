<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%@page contentType="text/html; charset=UTF-8"%>
<HTML>
<HEAD>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
    <TITLE></TITLE>
<%
	request.setCharacterEncoding("UTF-8");
	String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
	<script language="JavaScript" src="../../eCommon/js/common.js"></script>
	
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
 	<script language="JavaScript" src="../js/ExistingOrder.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

 	  
</HEAD>
<BODY  OnMouseDown="CodeArrest()"; onKeyDown="lockKey()">
<form>
<table cellpadding=3 cellspacing=0 border=1 width="98%" >
<tr><%--<td  class='QRY6' width='2%'></td><td  class='label' ><fmt:message key="eOR.ContMed.label" bundle="${or_labels}"/></td>--%><td  class='QRY7' width='2%'></td><td  class='label' ><fmt:message key="Common.Future.label" bundle="${common_labels}"/></td><td  class='QRY2' width='2%'></td><td  class='label' ><fmt:message key="Common.Elapsed.label" bundle="${common_labels}"/></td></td><%--<td  class='QRY3' width='2%'></td><td  class='label' >On-Hold[Activate?]</td>--%><%--<td  class='QRY4' width='2%'></td>
 <td  class='label'>Secondary Order</td> --%>
<td  class='QRY1' width='2%'></td><td  nowrap class='label'><fmt:message key="Common.OverDue.label" bundle="${common_labels}"/></td><td  class='QRY5' width='2%'></td><td  nowrap class='label'><fmt:message key="Common.Due.label" bundle="${common_labels}"/></td><td  class='QRY6' width='2%'></td><td  class='label' ><fmt:message key="Common.complete.label" bundle="${common_labels}"/></td></tr>
</table>
</form>
</BODY>
</HTML>

