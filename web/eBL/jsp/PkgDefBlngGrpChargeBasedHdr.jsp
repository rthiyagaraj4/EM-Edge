<!DOCTYPE html>
<%@ page   import="java.sql.*, webbeans.eCommon.* , java.io.*,java.util.*,com.ehis.util.*,java.text.*" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@page import="eBL.BLReportIdMapper"%> 

<html>
<head>


<%
		//unused variable, commented on 09/06/05
		//String params = request.getQueryString() ;
		String fromDate			=   request.getParameter("fromDate")==null ? "" :request.getParameter("fromDate");
		String blng_grp_code	=	request.getParameter("blng_grp_code") == null ? "" :request.getParameter("blng_grp_code") ;
		String blng_grp_desc	=	request.getParameter("blng_grp_desc") == null ? "" :request.getParameter("blng_grp_desc") ;
		String service_code		=	request.getParameter("service_code") == null ? "" :request.getParameter("service_code") ;
		String service_desc		=	request.getParameter("service_desc") == null ? "" :request.getParameter("service_desc") ;
%>
<%
		String sStyle =		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
		String siteSpecf=session.getAttribute("siteSpecf").toString();
		Boolean ss=Boolean.parseBoolean(siteSpecf); 
		System.out.println("siteSpecf" + ss); 
		
%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
	<script language="javascript" src="../../eCommon/js/common.js"></script>
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
<Script src=\"../../eCommon/js/showModalDialog.js\" language=\"JavaScript\"></Script>




<body onMouseDown="CodeArrest()" onKeyDown="lockKey()">
<form>
	<table id="tableheader" border="1" width="100%" cellspacing='0' cellpadding='3'>	
	<tr><td class='COLUMNHEADER'  colspan='13'><fmt:message key="eBL.BillingGroup.label" bundle="${bl_labels}"/>&nbsp;: &nbsp;<%=blng_grp_desc%>&nbsp;,&nbsp;&nbsp;&nbsp;&nbsp;<fmt:message key="Common.fromdate.label" bundle="${common_labels}"/>&nbsp;: &nbsp;<%=fromDate%>&nbsp;&nbsp;&nbsp;</td>
</tr>
	<tr>
	<!-- Added by MuthuN against 28192 on 27-7-12 -->
		<td class='COLUMNHEADER'  width ='9%' nowrap ><fmt:message key="Common.type.label" bundle="${common_labels}"/></td>
		<td  class='COLUMNHEADER'  width ='' nowrap><fmt:message key="Common.BillingService.label" bundle="${common_labels}"/> / <fmt:message key="Common.item.label" bundle="${common_labels}"/></td>
		<td class='columnheader'  width ='' nowrap><fmt:message key="eBL.PERC_AMOUNT_INDICATOR.label" bundle="${bl_labels}"/></td>
		<td class='columnheader'  width ='' nowrap><fmt:message key="eBL.PERC_AMOUNT.label" bundle="${bl_labels}"/></td>		
		<td  class='COLUMNHEADER' width ='' nowrap><fmt:message key="eBL.ROUND_TO.label" bundle="${bl_labels}"/></td>
		<td  class='COLUMNHEADER' width ='' nowrap><fmt:message key="eBL.ROUND_INDICATOR.label" bundle="${bl_labels}"/></td>
		<%if( ss){%>
	<td class='columnheader'width=''  nowrap><fmt:message bundle="${bl_labels }" key="eBL.IncludeHomeMedication.label"></fmt:message></td> 
	<!-- Added By suganya  -->
<%} else{%>
	<td class='columnheader'width=''  nowrap >
<%} %>
		<td class='columnheader'  width ='' nowrap><fmt:message key="eBL.RefundRatePer.label" bundle="${bl_labels}"/></td>
		<td class='columnheader'  width ='' nowrap><fmt:message key="eBL.AUTO_REFUND.label" bundle="${bl_labels}"/></td>
		<td class='columnheader'  width ='' nowrap >Factor appl for serv_lmt</td>
		<td class='COLUMNHEADER'  width ='' nowrap><fmt:message key="eBL.serviceLimit.label" bundle="${bl_labels}"/></td>
		<td class='columnheader' width=''  nowrap><fmt:message bundle="${bl_labels }" key="eBL.SplitReqd.label"></fmt:message></td> 
		<td class='COLUMNHEADER'  width ='' nowrap><fmt:message key="Common.Select.label" bundle="${common_labels}"/></td>		
		</tr>
	
		</table>
		
	</form>	
	</body>
</html>



