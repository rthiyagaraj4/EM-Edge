<!DOCTYPE html>
<%@ page   import="java.sql.*, webbeans.eCommon.* , java.io.*,java.util.*,com.ehis.util.*,java.text.*" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<html>
<head>
<%
		//unused variable, commented on 09/06/05
		//String params = request.getQueryString() ;
%>
<!--
	<link rel='stylesheet' type ='text/css' href='../../eCommon/html/IeStyle.css'</link>
	-->
		<%
		String sStyle =		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
    %>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
	<script language="javascript" src="../../eCommon/js/common.js"></script>
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


<body onMouseDown="CodeArrest()" onKeyDown="lockKey()">
<form>
<center>
	<table border="1" width="100%" cellspacing='0' cellpadding='3'>
	<TR>
		<td width='100%' class="COLUMNHEADER" colspan='8'><fmt:message key="eBL.SETTLEMENT_WISE_COLLECTION.label" bundle="${bl_labels}"/></td>
	</TR>
	<TR>		
		<td width='37%' class="COLUMNHEADER" ><fmt:message key="Common.SettlementType.label" bundle="${common_labels}"/></td>
        <td width='7%' class="COLUMNHEADER"><fmt:message key="Common.TotalCount.label" bundle="${common_labels}"/></td>
		<td width='7%' class="COLUMNHEADER"><fmt:message key="eBL.CANCELLED_COUNT.label" bundle="${bl_labels}"/></td>
		<td width='7%' class="COLUMNHEADER"><fmt:message key="eBL.BOUNCED_COUNT.label" bundle="${bl_labels}"/></td>
		<td width='10%' class="COLUMNHEADER"><fmt:message key="eBL.CANCEL_AMT.label" bundle="${bl_labels}"/></td>	
		<td width='10%' class="COLUMNHEADER"><fmt:message key="eBL.RECEIPT_AMT.label" bundle="${bl_labels}"/> </td>
		<td width='10%' class="COLUMNHEADER"><fmt:message key="eBL.ACTUAL_AMT.label" bundle="${bl_labels}"/> </td>
		<td width='12%' class="COLUMNHEADER"><fmt:message key="eBL.DISCREPANCY_AMT.label" bundle="${bl_labels}"/></td>		
		</TR>
		</table>
		
	</form>	
	</body>
</html>


<!--

<iframe name='commontoolbarFrame' id='commontoolbarFrame'	src="../../eCommon/jsp/commonToolbar.jsp"  frameborder=0 scrolling='no' noresize style='height:8vh;width:100vw'></iframe>
<!--<frame name='bl_cashier_logout' id='bl_cashier_logout' 	src='BLCashierPopupWindow.jsp' frameborder=0 scrolling='auto' noresize>
<iframe name='bl_cashier_logout' id='bl_cashier_logout' 	src='BLLogoutCashCounterMain.jsp' frameborder=0 scrolling='auto' noresize style='height:83vh;width:100vw'></iframe>
<iframe name='messageFrame' id='messageFrame'		src='../../eCommon/jsp/error.jsp' frameborder=0 noresize scrolling='auto' noresize style='height:9vh;width:100vw'></iframe>

-->

