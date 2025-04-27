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
	<table id="tableheader" border="1" width="100%" cellspacing='0' cellpadding='3'>	
	<tr >
	<!--<td  class='COLUMNHEADER' width='19%' ><fmt:message key="Common.BillingClass.label" bundle="${common_labels}"/></td>
	<td  class='COLUMNHEADER' width='6%' ><fmt:message key="Common.INDICATOR.label" bundle="${common_labels}"/></td>
	<td  class='COLUMNHEADER' width='12%' ><fmt:message key="Common.Price.label" bundle="${common_labels}"/></td>
	<td  class='COLUMNHEADER' width='2%' ><fmt:message key="eBL.ROUND_TO.label" bundle="${bl_labels}"/></td>
	<td  class='COLUMNHEADER' width='4%'  ><fmt:message key="eBL.ROUND_INDICATOR.label" bundle="${bl_labels}"/></td>	
	<td  class='COLUMNHEADER' width='7%' ><fmt:message key="eBL.DEPOSIT.label" bundle="${bl_labels}"/></td>
	<td  class='COLUMNHEADER' width='14%' ><fmt:message key="eBL.PARTIAL_DEPOSIT.label" bundle="${bl_labels}"/> </td>
	<td  class='COLUMNHEADER' width='9%' ><fmt:message key="eBL.PERC_AMOUNT.label" bundle="${bl_labels}"/></td>
	<td  class='COLUMNHEADER' width='13%' ><fmt:message key="eBL.MIN_DEPOSIT_AMOUNT.label" bundle="${bl_labels}"/></td>
	<td  class='COLUMNHEADER' width='15%' ><fmt:message key="eBL.ApplyFactorForServiceLimit.label" bundle="${bl_labels}"/></td>
	<td  class='COLUMNHEADER' width='14%' >ApplFactServLmt</td>
	<td>&nbsp;&nbsp;</td>-->

	<td  class='COLUMNHEADER' WIDTH='' nowrap><fmt:message key="Common.BillingClass.label" bundle="${common_labels}"/></td>
	<td  class='COLUMNHEADER' WIDTH='' nowrap><fmt:message key="Common.INDICATOR.label" bundle="${common_labels}"/></td>
	<td  class='COLUMNHEADER' WIDTH='' nowrap><fmt:message key="Common.Price.label" bundle="${common_labels}"/></td>
	<td  class='COLUMNHEADER' WIDTH='' nowrap><fmt:message key="eBL.ROUND_TO.label" bundle="${bl_labels}"/></td>
	<td  class='COLUMNHEADER' WIDTH='' nowrap><fmt:message key="eBL.ROUND_INDICATOR.label" bundle="${bl_labels}"/></td>	
	<td  class='COLUMNHEADER' WIDTH='' nowrap><fmt:message key="eBL.DEPOSIT.label" bundle="${bl_labels}"/></td>
	<td  class='COLUMNHEADER' WIDTH='' nowrap><fmt:message key="eBL.PARTIAL_DEPOSIT.label" bundle="${bl_labels}"/> </td>
	<td  class='COLUMNHEADER' WIDTH='' nowrap><fmt:message key="eBL.PERC_AMOUNT.label" bundle="${bl_labels}"/></td>
	<td  class='COLUMNHEADER' WIDTH='' nowrap ><fmt:message key="eBL.MIN_DEPOSIT_AMOUNT.label" bundle="${bl_labels}"/></td>
	<td  class='COLUMNHEADER' WIDTH='' nowrap>ApplFactServLmt</td>
	  <!-- Added by muthu for Factor for service rate issue for KDAH on 21-6-12 -->
	<td  class='COLUMNHEADER' width='' ><fmt:message key="eBL.FactorForServiceRate.Label" bundle="${bl_labels}"/></td>
	  <!-- Added by muthu for Factor for service rate issue for KDAH on 21-6-12 -->
	<td  class='COLUMNHEADER' WIDTH='' nowrap>&nbsp;</td><!--Added by muthu for Report issue for KDAH on 21-6-12 -->
	</tr>
		</table>
		
	</form>	
	</body>
</html>


<!--

<iframe name='commontoolbarFrame' id='commontoolbarFrame'	src="../../eCommon/jsp/commonToolbar.jsp"  frameborder=0 scrolling='no' noresize style='height:8vh;width:100vw'></iframe>
<!--<frame name='bl_cashier_logout' id='bl_cashier_logout' 	src='BLCashierPopupWindow.jsp' frameborder=0 scrolling='auto' noresize></iframe>
<iframe name='bl_cashier_logout' id='bl_cashier_logout' 	src='BLLogoutCashCounterMain.jsp' frameborder=0 scrolling='auto' noresize style='height:83vh;width:100vw'></iframe>
<iframe name='messageFrame' id='messageFrame'		src='../../eCommon/jsp/error.jsp' frameborder=0 noresize scrolling='auto' noresize style='height:9vh;width:100vw'></iframe>

-->

