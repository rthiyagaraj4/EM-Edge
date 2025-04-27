<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%-- JSP Page specific attributes start --%>
<%@page import="java.util.*, eOR.* ,eOR.Common.*,eCommon.Common.*"  contentType="text/html; charset=UTF-8"%>
<%-- JSP Page specific attributes end --%>
<html>
<head>
<%
	String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
	<script language="JavaScript" src="../../eCommon/js/common.js"></script>
	<script language="JavaScript" src="../../eCommon/js/dchk.js"></script>
	<!-- used for date validation-->
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
 	<script language="JavaScript" src="../js/OrCommonFunction.js"></script>
    <script language="JavaScript" src="../js/ExternalOrder.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<head>

<form name=formPatientPendingOrdersClose>
<table width='100%' align='center'>
<tr >
<td  class='button' valign='bottom'><INPUT TYPE='button' value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOR.Renew.label","or_labels")%>' class='button' onClick='RenewOrders()'><INPUT TYPE='button' value='Close' class='button' onClick='window.close()'></td>
</tr>
</table>
</form>
</html>

 

