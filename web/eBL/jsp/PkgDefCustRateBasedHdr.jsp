<!DOCTYPE html>
<%@ page   import="java.sql.*, webbeans.eCommon.* , java.io.*,java.util.*,com.ehis.util.*,java.text.*" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@page import="eBL.BLReportIdMapper"%> 

<html>
<head>
<%
		String fromDate				 = request.getParameter("fromDate")==null ? "" :request.getParameter("fromDate") ;
		System.out.println("fromDate PkgDefCustRateBasedHdr.jsp=>"+fromDate);
		String cust_grp_code		 = request.getParameter("cust_grp_code")==null ? "" :request.getParameter("cust_grp_code") ;
		String cust_grp_desc		 = request.getParameter("cust_grp_desc")==null ? "" :request.getParameter("cust_grp_desc") ;
		String cust_code			 = request.getParameter("cust_code")==null ? "" :request.getParameter("cust_code") ;
		String cust_desc			 = request.getParameter("cust_desc")==null ? "" :request.getParameter("cust_desc") ;
		String parent_index			 = request.getParameter("parent_index")==null ? "" :request.getParameter("parent_index") ;
	System.out.println("cust_grp_code PkgDefCustRateBasedHdr.jsp=>"+cust_grp_code);
	System.out.println("cust_grp_desc PkgDefCustRateBasedHdr.jsp=>"+cust_grp_desc);
	System.out.println("cust_code PkgDefCustRateBasedHdr.jsp=>"+cust_code);
	System.out.println("cust_desc PkgDefCustRateBasedHdr.jsp=>"+cust_desc);
%>
<!--
	<link rel='stylesheet' type ='text/css' href='../../eCommon/html/IeStyle.css'</link>
	-->
		<%
		String sStyle =		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
		String siteSpecf=session.getAttribute("siteSpecf").toString();
		Boolean ss=Boolean.parseBoolean(siteSpecf); 
		/* Added V190320-Aravindh/MMS-DM-CRF-0129/Starts */
		Connection con = null;
		boolean dailyLimitSiteSpec = false;
		try {
			con = ConnectionManager.getConnection(request);
			dailyLimitSiteSpec = eCommon.Common.CommonBean.isSiteSpecific(con, "BL", "BL_ENABLE_DAILY_PKG_SERV_LIMIT");
		} catch(Exception ex) {
			System.err.println("Error in PkgDefRateBasedHdr.jsp: "+ex);
			ex.printStackTrace();
		}
		/* Added V190320-Aravindh/MMS-DM-CRF-0129/Ends */
    %>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
	<script language='javascript' src='../../eCommon/js/jquery-3.6.3.js'></script>
	<script language="javascript" src="../../eCommon/js/common.js"></script>
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
<Script src=\"../../eCommon/js/showModalDialog.js\" language=\"JavaScript\"></Script>




<body onMouseDown="CodeArrest()" onKeyDown="lockKey()">
<form>
	<table id="tableheader1" border="1" width="100%" cellspacing='0' cellpadding='3'>		
	<tr>
	<%if(ss){%>
	<td class='COLUMNHEADER'  colspan='23'><fmt:message key="eBL.CUSTOMER_GROUP.label" bundle="${bl_labels}"/>&nbsp;: &nbsp;<%=cust_grp_desc%>&nbsp;,&nbsp;&nbsp;&nbsp;&nbsp;<fmt:message key="Common.Customer.label" bundle="${common_labels}"/>&nbsp;:&nbsp;<%=cust_desc%>&nbsp;&nbsp;&nbsp;<fmt:message key="Common.fromdate.label" bundle="${common_labels}"/>&nbsp;: &nbsp;<%=fromDate%>&nbsp;&nbsp;&nbsp;</td>
	<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
	<%}else{ %>
	<td class='COLUMNHEADER'  colspan='22'><fmt:message key="eBL.CUSTOMER_GROUP.label" bundle="${bl_labels}"/>&nbsp;: &nbsp;<%=cust_grp_desc%>&nbsp;,&nbsp;&nbsp;&nbsp;&nbsp;<fmt:message key="Common.Customer.label" bundle="${common_labels}"/>&nbsp;:&nbsp;<%=cust_desc%>&nbsp;&nbsp;&nbsp;<fmt:message key="Common.fromdate.label" bundle="${common_labels}"/>&nbsp;: &nbsp;<%=fromDate%>&nbsp;&nbsp;&nbsp;</td>
	<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
	<%} %>
	</tr>
	<tr>
	<td class='columnheader' WIDTH='9' nowrap><fmt:message key="Common.type.label" bundle="${common_labels}"/></td> 
	<td class='columnheader'  WIDTH='' nowrap><fmt:message key="Common.BillingService.label" bundle="${common_labels}"/></td> 
	<td class='columnheader' WIDTH='' nowrap> <fmt:message key="Common.ordercatalog.label" bundle="${common_labels}"/></td> 
	<td class='columnheader' WIDTH='' nowrap><fmt:message key="eBL.AmountIndicator.label" bundle="${bl_labels}"/></td>
	<td class='columnheader' WIDTH='' nowrap><fmt:message key="eBL.FactorRate.label" bundle="${bl_labels}"/></td>
	<td class='columnheader' WIDTH='' nowrap ><fmt:message key="eBL.QTY_LMT.label" bundle="${bl_labels}"/></td>
	<td class='columnheader' WIDTH='' nowrap><fmt:message key="eBL.PERC_AMOUNT_INDICATOR.label" bundle="${bl_labels}"/></td>
	<td class='columnheader' WIDTH='' nowrap><fmt:message key="eBL.PERC_AMOUNT.label" bundle="${bl_labels}"/></td>
	<td  class='COLUMNHEADER' WIDTH='' nowrap><fmt:message key="eBL.ROUND_TO.label" bundle="${bl_labels}"/></td>
	<td  class='COLUMNHEADER' WIDTH='' nowrap><fmt:message key="eBL.ROUND_INDICATOR.label" bundle="${bl_labels}"/></td>
	<td  class='COLUMNHEADER' WIDTH='' nowrap><fmt:message key="eBL.PkgLmtIndLevel.label" bundle="${bl_labels}"/></td>
	<!-- <td class='columnheader' ><fmt:message key="eBL.PercentageLimit.label" bundle="${bl_labels}"/></td>
	<td class='columnheader' ><fmt:message key="eBL.AMT_LMT.label" bundle="${bl_labels}"/></td>
	<td class='columnheader' ><fmt:message key="eBL.NoLimit.label" bundle="${bl_labels}"/></td>
	 -->
	 <%if(ss){%>
		<td class='columnheader'width=''  nowrap><fmt:message bundle="${bl_labels }" key="eBL.IncludeHomeMedication.label"></fmt:message></td> 
		<!-- Added By suganya  -->
	<%} else{%>
		<td class='columnheader'width=''  nowrap >
	<%} %>
	<!-- Added V190320-Aravindh/MMS-DM-CRF-0129 -->
	<!-- Modified V190626-Aravindh/MMS-DM-CRF-0129.1 -->
	<% if(dailyLimitSiteSpec) { %>
		<td class='COLUMNHEADER' WIDTH='' nowrap><fmt:message key="eBL.DailyLimit.label" bundle="${bl_labels}"/> <fmt:message key="eBL.INDICATOR.label" bundle="${bl_labels}"/></td>
		<td class='COLUMNHEADER' WIDTH='' nowrap><fmt:message key="eBL.DailyLimit.label" bundle="${bl_labels}"/> <fmt:message key="eBL.IRBAmount.label" bundle="${bl_labels}"/></td>
		<td class='COLUMNHEADER' WIDTH='' nowrap><fmt:message key="eBL.DailyLimit.label" bundle="${bl_labels}"/> <fmt:message key="eBL.QTY.label" bundle="${bl_labels}"/></td>	
	<% } else{ %>
		 <td class='COLUMNHEADER' WIDTH='' nowrap  Display:none >&nbsp;</td>
		 <td class='COLUMNHEADER' WIDTH='' nowrap  Display:none >&nbsp;</td> 
		 <td class='COLUMNHEADER' WIDTH='' nowrap  Display:none >&nbsp;</td> 
	<% } %>
	<td class='columnheader' WIDTH='' nowrap><fmt:message key="Common.Replace.label" bundle="${common_labels}"/></td>
	<td class='columnheader' WIDTH='' nowrap><fmt:message key="eBL.RefundRatePer.label" bundle="${bl_labels}"/></td>
	<td class='columnheader' WIDTH='' nowrap><fmt:message key="eBL.AUTO_REFUND.label" bundle="${bl_labels}"/></td>
	<!--<td class='columnheader' ><fmt:message key="eBL.ApplyFactorForServiceLimit.label" bundle="${bl_labels}"/></td>-->
	<td class='columnheader' WIDTH='' nowrap>Factor appl for servLmt</td>
	<td class='columnheader' WIDTH='' nowrap><fmt:message key="eBL.CLOSE_PACKAGE.label" bundle="${bl_labels}"/></td>
	<td class='columnheader' WIDTH='' nowrap><fmt:message key="eBL.serviceLimit.label" bundle="${bl_labels}"/></td>
	<td class='columnheader'width=''  nowrap><fmt:message bundle="${bl_labels }" key="eBL.SplitReqd.label"></fmt:message></td> <!-- Added By Rajesh V -->
	<td class='columnheader' WIDTH='' nowrap><fmt:message key="Common.Select.label" bundle="${common_labels}"/></td>
	<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
	</tr>
	</table>		
</form>	
</body>
</html>


