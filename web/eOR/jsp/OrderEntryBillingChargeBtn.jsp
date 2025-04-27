<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%@page contentType="text/html;charset=UTF-8"%> 
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<html>
<head>
<%
	request.setCharacterEncoding("UTF-8");
	String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
	
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="javascript" src="../../eCommon/js/common.js"></script>
 	<script language="javaScript" src="../../eOR/js/OrderBillingChargeDtls.js"></script>
	<script language="JavaScript" src="../../eOR/js/ViewOrder.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
 

</head>
<body OnMouseDown="CodeArrest()"; onKeyDown="lockKey()">
<%
String tablewidth="";
String called_from=request.getParameter("called_from");
called_from = (called_from == null) ? "" : called_from;
if(!called_from.equals("register_visit"))
{
	tablewidth="15%";
}
else
{
	tablewidth="28%";
}
%>
<table cellpadding=3 cellspacing=0 border=1 width="100%" align=center class="gridComponentHolder">
	<tr>
		<td width="<%=tablewidth%>" class="gridData" style='border-width: 1;text-align: right;font-size: 3%'><font class='label' size="10"><span id='total_' style="visibility:visible"><B><fmt:message key="Common.total.label" bundle="${common_labels}"/> <fmt:message key="Common.Charge.label" bundle="${common_labels}"/>:</B></font></td>
		<td width='15%' class="gridData" style='border-width: 1;text-align: right;'><font class='label' size="2" size="1"><B><span id='actual_' style="visibility:visible">0.0</span></B></font></td>
		<td width='15%' class="gridData" style='border-width: 1;text-align: right;'><font class='label' size="2" size="1"><B><span id='payable_' style="visibility:visible">0.0</span></B></font></td>
		<td width='15%' class="gridData" style='border-width: 1;text-align: right;'><font class='label' size="2" size="1"><B><span id='paid_' style="visibility:visible">0.0</span></B></font></td>
		<td width='50%' colspan='4' class='gridData' style='border-width: 1;text-align: right;'>

			<input type="button" name="record" id="record" class="BUTTON" value ="<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.record.label","common_labels")%>" title ="Record"  onClick="recordBillCharges()">&nbsp;<input type='button' class='button' title='Cancel' value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.cancel.label","common_labels")%>' onclick ='closeChildWin()' name='cancel' id='cancel'>
			
		</td>
	</tr>

</table>




</body>
</html>

