<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%@page import="eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8"%> 
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<html>
<head>
<%
	request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
	
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="javascript" src="../../eCommon/js/common.js"></script>

	<script language="JavaScript" src="../js/ViewOrder.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<body OnMouseDown="CodeArrest()"; onKeyDown="lockKey()">
<%
	

 	String toatal_amt = request.getParameter( "toatal_amt" ) ;
 	String toatal_pat_payable = request.getParameter( "toatal_pat_payable" ) ;
 	String toatal_pat_paid = request.getParameter( "toatal_pat_paid" ) ;
	
 %>
<form name='view_order_btn' id='view_order_btn' target='messageFrame' >
<table cellpadding=0 cellspacing=0 border=0 width="100%" align=center class="gridComponentHolder">
	
	<tr>
		<td  width='70%' class='label' width="" style="vertical-align:middle">&nbsp;
			<table cellpadding=3 cellspacing=0 border=1 width='100%' align='center' class="grid">
	
	<tr>
		<td colspan="" width='18%' class="gridData" style='border-width: 0;text-align: left;'><font class='label' size="1"><B><fmt:message key="Common.total.label" bundle="${common_labels}"/></B> : <%=toatal_amt%></font></td>
		<td colspan="" width='18%' class="gridData" style='border-width: 0;text-align: left;'><font class='label' size="1"><B><fmt:message key="Common.PatientPayable.label" bundle="${common_labels}"/></B>: <%=toatal_pat_payable%></font></td>
		<td colspan="" width='20%' class="gridData"style='border-width: 0;text-align: left;' nowrap><font class='label' size="1"><B><fmt:message key="Common.PatientPaid.label" bundle="${common_labels}"/></B>: <%=toatal_pat_paid%></font></td>

	</tr>
	</table>
	
	</td>
		<td  width='30%' class='button' align="right">
		
	
		<INPUT TYPE="button" value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.close.label","common_labels")%>' class='button' onClick='closeChildWin();'>
		</td>
	</tr>

</table>


</form>

</body>
</html>

