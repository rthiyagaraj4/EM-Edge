<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>

<%-- JSP Page specific attributes start --%>
<%@page  import="java.util.*, eOR.* ,eOR.Common.*,eCommon.Common.*" contentType="text/html; charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<%-- JSP Page specific attributes end --%>
<HTML>
<HEAD>
    <TITLE><fmt:message key="Common.PIN.label" bundle="${common_labels}"/></TITLE>
<%
	String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/></link>
	<script language="JavaScript" src="../../eCommon/js/common.js"></script>
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="JavaScript" src="../../eCommon/js/dchk.js"></script>
 	<script language="JavaScript" src="../../eOR/js/OrderEntry.js"></script>
 	<script language="JavaScript" src="../../eOR/js/OrCommonFunction.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</HEAD>
<BODY  OnMouseDown="CodeArrest()"; onKeyDown="lockKey()">
<FORM name="confirmRequest" id="confirmRequest">
<%
    String login_user = (String)session.getAttribute("login_user");
%>
<Table cellpadding='3' cellspacing='0' border='0' width='98%' align='center'>
<TR>
<TD class='label' ><fmt:message key="Common.user.label" bundle="${common_labels}"/></TD><TD class='label' align='left'><B><%=login_user%></B></TD></tr>
<TR><TD class='label' colspan='2'></TD></TR>
<tr><TD class='label' ><fmt:message key="Common.PIN.label" bundle="${common_labels}"/></TD><TD class='label' ><Input name='PIN' id='PIN' type='password' autocomplete="off"></TD></TR>  <!--41670 autocomplete="off"-->
<TR><TD class='label' colspan='2'></TD></TR>
<tr><TD class='label' colspan='2' ><Input value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ok.label","common_labels")%>' Name='button' type='button' class='button' onClick='closeConfirm()'></TD>
</TR>
</Table>
</Form>
</BODY>
</HTML>

