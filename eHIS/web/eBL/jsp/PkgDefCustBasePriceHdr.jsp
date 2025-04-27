<!DOCTYPE html>
<%@ page   import="java.sql.*, webbeans.eCommon.* , java.io.*,java.util.*,com.ehis.util.*,java.text.*" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<html>
<head>
<%
		String fromDate			 = request.getParameter("fromDate")==null ? "" :request.getParameter("fromDate") ;
		String cust_grp_code			 = request.getParameter("cust_grp_code")==null ? "" :request.getParameter("cust_grp_code") ;
		String cust_grp_desc			 = request.getParameter("cust_grp_desc")==null ? "" :request.getParameter("cust_grp_desc") ;
		String cust_code			 = request.getParameter("cust_code")==null ? "" :request.getParameter("cust_code") ;
		String cust_desc			 = request.getParameter("cust_desc")==null ? "" :request.getParameter("cust_desc") ;
		String parent_index			 = request.getParameter("parent_index")==null ? "" :request.getParameter("parent_index") ;
	
%>
<!--
	<link rel='stylesheet' type ='text/css' href='../../eCommon/html/IeStyle.css'</link>
	-->
		<%
		String sStyle =		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
    %>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
	<script language='javascript' src='../../eCommon/js/jquery-3.6.3.js'></script>
	<script language="javascript" src="../../eCommon/js/common.js"></script>
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


<body onMouseDown="CodeArrest()" onKeyDown="lockKey()">
<form>
	<table id="tableheader" border="1" width="100%" cellspacing='0' cellpadding='3'>		
	<tr>
		<td class='COLUMNHEADER'  colspan='12'><fmt:message key="eBL.CUSTOMER_GROUP.label" bundle="${bl_labels}"/>&nbsp; : &nbsp;<%=cust_grp_desc%>&nbsp;,&nbsp;&nbsp;&nbsp;&nbsp;<fmt:message key="Common.Customer.label" bundle="${common_labels}"/>&nbsp;:&nbsp;<%=cust_desc%>&nbsp;&nbsp;&nbsp;<fmt:message key="Common.fromdate.label" bundle="${common_labels}"/>&nbsp;: &nbsp;<%=fromDate%>&nbsp;&nbsp;&nbsp;</td>
	</tr>
	<tr >
	<td  class='COLUMNHEADER' WIDTH='' nowrap><fmt:message key="Common.BillingClass.label" bundle="${common_labels}"/></td>
	<td  class='COLUMNHEADER' WIDTH='' nowrap><fmt:message key="Common.INDICATOR.label" bundle="${common_labels}"/></td>
	<td  class='COLUMNHEADER' WIDTH='' nowrap><fmt:message key="Common.Price.label" bundle="${common_labels}"/></td>
	<td  class='COLUMNHEADER' WIDTH='' nowrap><fmt:message key="eBL.ROUND_TO.label" bundle="${bl_labels}"/></td>
	<td  class='COLUMNHEADER' WIDTH='' nowrap><fmt:message key="eBL.ROUND_INDICATOR.label" bundle="${bl_labels}"/></td>
	<td  class='COLUMNHEADER' WIDTH='' nowrap><fmt:message key="eBL.DEPOSIT.label" bundle="${bl_labels}"/></td>
	<td  class='COLUMNHEADER' WIDTH='' nowrap><fmt:message key="eBL.PARTIAL_DEPOSIT.label" bundle="${bl_labels}"/> </td>
	<td  class='COLUMNHEADER' WIDTH='' nowrap><fmt:message key="eBL.PERC_AMOUNT.label" bundle="${bl_labels}"/></td>
	<!--<td  class='COLUMNHEADER' ><fmt:message key="eBL.MIN_DEPOSIT_AMOUNT.label" bundle="${bl_labels}"/></td>
		<td  class='COLUMNHEADER' ><fmt:message key="eBL.ApplyFactorForServiceLimit.label" bundle="${bl_labels}"/></td>
		<td class='columnheader'  >Min Deposit Amt</td>
		<td class='columnheader'  >Factor appl for serv lmt</td>-->

	<!-- Added by muthu for Factor for service rate issue for KDAH on 21-6-12 -->
	<td  class='COLUMNHEADER' WIDTH='' nowrap ><fmt:message key="eBL.MIN_DEPOSIT_AMOUNT.label" bundle="${bl_labels}"/></td>
	<td  class='COLUMNHEADER' WIDTH='' nowrap>ApplFactServLmt</td>	 
	<td  class='COLUMNHEADER' width='13%' ><fmt:message key="eBL.FactorForServiceRate.Label" bundle="${bl_labels}"/></td>
	<!-- Added by muthu for Factor for service rate issue for KDAH on 21-6-12 -->
	<td  class='COLUMNHEADER' WIDTH='' nowrap>&nbsp;</td><!--Added by muthu for Report issue for KDAH on 21-6-12 -->
	</tr>
	</table>		
	</form>	
	</body>
</html>


