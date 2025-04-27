<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%
/*
-------------------------------------------------------------------------------------------------------------------------------------
Date       		Edit History    Name        	Description
-------------------------------------------------------------------------------------------------------------------------------------
?             	100            	?           	created
25/09/2012		IN030279		Ramesh G		Bru-HIMS-CRF-160 								 
-------------------------------------------------------------------------------------------------------------------------------------
----------------------------------------------------------------------------------------------------------------------------------------------------------
Date       Edit History      Name        		Rev.Date		Rev.Name		Description
----------------------------------------------------------------------------------------------------------------------------------------------------------
28/08/2017	IN065091		Krishna Gowtham J 	29/08/2017		Ramesh G		GHL-CRF-0440.1
----------------------------------------------------------------------------------------------------------------------------------------------------------
*/
%>
<%@page import="java.util.*, eOR.* ,eOR.Common.*,eCommon.Common.*,webbeans.eCommon.ConnectionManager,java.sql.*"   contentType="text/html; charset=UTF-8" %><!--IN065091-->

<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<HTML>
<HEAD>
    <TITLE></TITLE>
<%

	String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
	<script language="JavaScript" src="../../eCommon/js/common.js"></script>

	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
 	<script language="JavaScript" src="../js/ExistingOrder.js"></script>
<!--	<script language="JavaScript" src="../js/OrMessages.js"></script>-->
 	<script language="JavaScript" src="../js/PatOrderByPrivReln.js"></script> 
 	<script language="JavaScript" src="../js/PatOrderByPrivRelnTracking.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
 
	<!--IN065091 start-->
	<style>
	TD.QRY11 
	{
		BACKGROUND-COLOR: #05bbea;
		FONT-SIZE: 9PT ;
		BORDER-COLOR:	BLACK;
		BORDER-LEFT-COLOR: #D5E2E5;
		BORDER-RIGHT-COLOR: #D5E2E5;
		BORDER-TOP-COLOR: #D5E2E5;
		BORDER-BOTTOM-COLOR: #D5E2E5;
	}
	</style>
	<!--IN065091 Ends-->
</HEAD>
<BODY onMouseDown="CodeArrest()" onKeyDown="lockKey()">
<%
request.setCharacterEncoding("UTF-8");
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String function = request.getParameter("function") == null ? "" : request.getParameter("function");
	String view_by = "";
	view_by 	= request.getParameter("view_by") == null ? "" : request.getParameter("view_by");//IN065091
	//IN065091 start
	Connection connection =  null;
try{
	connection		= ConnectionManager.getConnection(request); 
	boolean isSiteSpecificBTColor = false;
	isSiteSpecificBTColor = eCommon.Common.CommonBean.isSiteSpecific(connection, "OR","BLOOD_ORDERS_ACK");
	//IN065091 Ends
	String print_enable = "";
	//if(function.equals("OrderTracking"))
	//{
		//view_by = request.getParameter("view_by") == null ? "" : request.getParameter("view_by");
	
		//if(view_by.equals("L"))
			//print_enable = "disabled";
		//else
			print_enable = "";
	//}
	String function_from = (String)request.getParameter("function_from")==null?"":(String)request.getParameter("function_from");//IN030279 
%>
<form>
<table cellpadding=3 cellspacing=0 border=0 width="100%" >
<tr><%--<td  class='QRY6' width='1%'>&nbsp;</td><td  class='label' >Cont.Med.</td>--%>
<td  class='QRY1' width='1%'></td>
<td  class='DATA' ><font size="1"><fmt:message key="eOR.ActiveRenew.label" bundle="${or_labels}"/></font></td>
<td  class='QRY2' width='1%'></td>
<td  class='DATA' ><font size="1"><fmt:message key="eOR.ExpiredRenew.label" bundle="${or_labels}"/></font></td><%--<td  class='QRY3' width='1%'>&nbsp;</td><td  class='DATA' ><font size="1">On-Hold[Activate?]</font></td>--%><%--<td  class='QRY4' width='1%'>&nbsp;</td>
 <td  class='DATA'><font size="1">Secondary Order</font></td> --%>
<td  class='QRY7' width='1%'></td>
<td  nowrap class='DATA'><font size="1"><fmt:message key="eOR.FutureOrder.label" bundle="${or_labels}"/></font></td>
<td  class='QRY5' width='1%'></td>
<td  nowrap class='DATA'><font size="1"><fmt:message key="eOR.SecondaryOrderExists.label" bundle="${or_labels}"/></font></td>
<!--IN065091 start-->
<%
if("L".equals(view_by) && isSiteSpecificBTColor){
%>
	<td  class='QRY11' width='1%' id=""></td>
	<td  nowrap class='DATA' id=""><font size="1"><fmt:message key="eOR.AckOrder.label" bundle="${or_labels}"/></font></td>
	<td colspan="1" class="label">&nbsp;</td>
<%
}else{
%>
<!-- IN030279 Start.
<td colspan="3" class="label">  -->
<td colspan="3" class="label">&nbsp;</td>
<!-- IN030279 End. -->
<%}%>
<!--IN065091 end-->
</tr>
<tr>
	<td  class='QRY9' width='1%'></td>
	<td  class='DATA' nowrap class='label'><font size="1"><fmt:message key="eOR.ResultModified.label" bundle="${or_labels}"/></font></td>
	<td  class='QRY10' width='1%'></td>
	<td  class='DATA' nowrap class='label'><font size="1"><fmt:message key="eOR.ResultModifiedA.label" bundle="${or_labels}"/></font></td>
	<td  class='QRY8' width='1%'></td>
	<td  class='DATA' nowrap class='label'><font size="1"><fmt:message key="eOR.ReScheduled.label" bundle="${or_labels}"/></font></td>
 	<td  class='LIGHTYELLOW' width='1%'></td> 
	<td  class='DATA' nowrap class='label'><font size="1"><fmt:message key="eOR.AppointmentRequired.label" bundle="${or_labels}"/></font></td>
	<td  class='BROWN' width='1%'></td> 
	<td  class='DATA' nowrap class='label'><font size="1"><fmt:message key="eOR.ReportNotRequested.label" bundle="${or_labels}"/></font></td>
	<%if(function.equals("OrderTracking")){%>
	<td align='right'>
		<input type=button class=button name='print' id='print' value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.print.label","common_labels")%>' onClick='printValuesTracking()' <%=print_enable%>>
	</td>
	<%}%>	
	<!-- IN030279 Start-->
	<%if(function_from.equals("MO")){%>
	<td align='right'>		
		<input type=button class=button name='placeOrder' id='placeOrder' value='View All Orders' onClick='viewAllOrderMO()' >&nbsp;
		<input type=button class=button name='viewAllOrders' id='viewAllOrders' value='Place Order' onClick='placeOrderMO()' >&nbsp;&nbsp;&nbsp;
	</td>
	<%}%>
	<!-- IN030279 End-->
</tr>
</table>
<input type="hidden" name="p_language_id" id="p_language_id" value="<%= localeName %>">
</form>
<%
}
catch(Exception e){
	//out.println("Exception@1: "+e);//COMMON-ICN-0181
	e.printStackTrace();//COMMON-ICN-0181
}
finally
{
	if(connection!=null)	ConnectionManager.returnConnection(connection,request);
}
%>
</BODY>
</HTML>

