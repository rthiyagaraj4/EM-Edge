<!DOCTYPE html>
<%@ page   import="java.sql.*, webbeans.eCommon.* , java.io.*,java.util.*,com.ehis.util.*,java.text.*" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<html>
<head>
<%
		//unused variable, commented on 09/06/05
		//String params = request.getQueryString() ;
		String fromDate			=   request.getParameter("fromDate")==null ? "" :request.getParameter("fromDate");
		String cust_grp_code	=	request.getParameter("cust_grp_code") == null ? "" :request.getParameter("cust_grp_code") ;
		String cust_grp_desc	=	request.getParameter("cust_grp_desc") == null ? "" :request.getParameter("cust_grp_desc") ;
		String cust_code		=	request.getParameter("cust_code") == null ? "" :request.getParameter("cust_code") ;
		String cust_desc		=	request.getParameter("cust_desc") == null ? "" :request.getParameter("cust_desc") ;
		String service_code		=	request.getParameter("service_code") == null ? "" :request.getParameter("service_code") ;
		String service_desc		=	request.getParameter("service_desc") == null ? "" :request.getParameter("service_desc") ;
%>
<!--
	<link rel='stylesheet' type ='text/css' href='../../eCommon/html/IeStyle.css'</link>
	-->
		<%
		String sStyle =		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
		String siteSpecf=session.getAttribute("siteSpecf").toString();
		Boolean ss=Boolean.parseBoolean(siteSpecf); 
		System.out.println("siteSpecf" + ss); 
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
	<table id="tableheader" border="1" width="100%" cellspacing='0' cellpadding='3'>		
	<tr><td class='COLUMNHEADER'  colspan='18'><fmt:message key="eBL.CUSTOMER_GROUP.label" bundle="${bl_labels}"/>&nbsp;: &nbsp;<%=cust_grp_desc%>&nbsp;,&nbsp;&nbsp;&nbsp;&nbsp;<fmt:message key="Common.Customer.label" bundle="${common_labels}"/>&nbsp;:&nbsp;<%=cust_desc%>&nbsp;&nbsp;&nbsp;<fmt:message key="Common.fromdate.label" bundle="${common_labels}"/>&nbsp;: &nbsp;<%=fromDate%>&nbsp;&nbsp;&nbsp;<fmt:message key="Common.BillingService.label" bundle="${common_labels}"/>&nbsp;: &nbsp;<%=service_desc%>&nbsp;&nbsp;&nbsp;</td>
	</tr>
	<tr>
	<td class='columnheader' width ='' nowrap><fmt:message key="Common.type.label" bundle="${common_labels}"/></td> 
	<td class='columnheader' width ='' nowrap><fmt:message key="Common.BillingService.label" bundle="${common_labels}"/></td> 
	<td class='columnheader' width ='' nowrap><fmt:message key="Common.Exclude.label" bundle="${common_labels}"/></td>
	<td class='columnheader' width ='' nowrap><fmt:message key="eBL.QTY_LMT.label" bundle="${bl_labels}"/></td>
	<td class='columnheader' width ='' nowrap><fmt:message key="eBL.PERC_AMOUNT_INDICATOR.label" bundle="${bl_labels}"/></td>
	<td class='columnheader' width ='' nowrap><fmt:message key="eBL.AMT_LMT.label" bundle="${bl_labels}"/></td>
	<td class='COLUMNHEADER' width ='' nowrap><fmt:message key="eBL.ROUND_TO.label" bundle="${bl_labels}"/></td>
	<td class='COLUMNHEADER' width ='' nowrap><fmt:message key="eBL.ROUND_INDICATOR.label" bundle="${bl_labels}"/></td>
	<%if( ss){%>
		<td class='columnheader'width=''  nowrap><fmt:message bundle="${bl_labels }" key="eBL.IncludeHomeMedication.label"></fmt:message></td> 
		<!-- Added By suganya  -->
	<%} else{%>
		<td class='columnheader'width=''  nowrap >
	<%} %>
	<!-- Added V190320-Aravindh/MMS-DM-CRF-0129 -->
	<% if(dailyLimitSiteSpec) { %>
		<td class='COLUMNHEADER' WIDTH='' nowrap><fmt:message key="eBL.DailyLimit.label" bundle="${bl_labels}"/> <fmt:message key="eBL.INDICATOR.label" bundle="${bl_labels}"/></td>
		<td class='COLUMNHEADER' WIDTH='' nowrap><fmt:message key="eBL.DailyLimit.label" bundle="${bl_labels}"/> <fmt:message key="eBL.IRBAmount.label" bundle="${bl_labels}"/></td>
		<td class='COLUMNHEADER' WIDTH='' nowrap><fmt:message key="eBL.DailyLimit.label" bundle="${bl_labels}"/> <fmt:message key="eBL.QTY.label" bundle="${bl_labels}"/></td>
	<% } else{ %>
		<td class='COLUMNHEADER' WIDTH='' nowrap  Display:none >&nbsp;</td>
		<td class='COLUMNHEADER' WIDTH='' nowrap  Display:none >&nbsp;</td> 
		<td class='COLUMNHEADER' WIDTH='' nowrap  Display:none >&nbsp;</td>
	<% } %>
	<td class='columnheader' width ='' nowrap><fmt:message key="Common.Replace.label" bundle="${common_labels}"/></td>
	<td class='columnheader' width ='' nowrap><fmt:message key="eBL.RefundRatePer.label" bundle="${bl_labels}"/></td>
	<td class='columnheader' width ='' nowrap ><fmt:message key="eBL.AUTO_REFUND.label" bundle="${bl_labels}"/></td>
	<!--<td class='columnheader' ><fmt:message key="eBL.ApplyFactorForServiceLimit.label" bundle="${bl_labels}"/></td>-->
	<td class='columnheader' width ='' nowrap >FactorAppl forServLmt</td>
	<td class='columnheader' width=''  nowrap><fmt:message bundle="${bl_labels }" key="eBL.SplitReqd.label"></fmt:message></td> <!-- Added By Rajesh V -->
	<td class='columnheader' width ='' nowrap><fmt:message key="Common.Select.label" bundle="${common_labels}"/></td>
	</tr>
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

