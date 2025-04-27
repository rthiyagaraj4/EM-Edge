<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
 <%@ page contentType="text/html; charset=UTF-8"%>
<html>
<head>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%
request.setCharacterEncoding("UTF-8");
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="JavaScript" src="../../eCommon/js/common.js"></script>
 	<script language="JavaScript" src="../js/ViewOrder.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	<title><fmt:message key="Common.Review.label" bundle="${common_labels}"/></title>
</head>
<body OnMouseDown="CodeArrest()"; onKeyDown="lockKey()">
<%
	/*String bean_id = "Or_ExistingOrder" ;
	String bean_name = "eOR.ExistingOrder";
	
	ExistingOrder bean = (ExistingOrder)mh.getBeanObject( bean_id, request,  bean_name ) ; 

	String prepsdata = bean.getPrepsdata(orderId.trim(),order_line_num.trim()) ;
	if((prepsdata.trim()).equals("") )
		prepsdata = "Test data in PrepsComment.jsp";*/
%>
<FORM METHOD=POST ACTION="">
<table cellpadding=3 cellspacing=0 border=0 align=center>
<td class=columnheader colspan=4><fmt:message key="eOR.AuthorisationInfo.label" bundle="${or_labels}"/></td>
<tr>
	<td class="label"><B><fmt:message key="Common.Practitioner.label" bundle="${common_labels}"/></B></td>
	<td><INPUT TYPE="text" name="practitioner" id="practitioner" value='<fmt:message key="Common.Practitioner.label" bundle="${common_labels}"/>' readOnly> </td>
	<td class="label"><B><fmt:message key="Common.datetime.label" bundle="${common_labels}"/></B></td>
	<td class=fields><INPUT TYPE="text" name="auth_date_time" id="auth_date_time" value="18/02/2003 12:12" readOnly> </td>
</tr>
<td class=columnheader colspan=4><fmt:message key="eOR.ConsentInfo.label" bundle="${or_labels}"/></td>
<tr>
	<td class="label"><B><fmt:message key="eOR.ConsentBy.label" bundle="${or_labels}"/></B></td>
	<td><INPUT TYPE="text" name="practitioner" id="practitioner" value='<fmt:message key="eOR.ConsentBy.label" bundle="${or_labels}"/>' readOnly> </td>
	<td class="label"><B><fmt:message key="Common.datetime.label" bundle="${common_labels}"/></B></td>
	<td><INPUT TYPE="text" name="cons_date_time" id="cons_date_time" value="18/02/2003 12:12" readOnly> </td>
</tr>
<tr><td colspan=4 class='button'><INPUT TYPE="button"  class="button" value='<fmt:message key="Common.close.label" bundle="${common_labels}"/>' onClick='window.close()'></td></tr>
</table>
</FORM>

</BODY>
</HTML>

