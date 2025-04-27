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
    
		//sarathkumar added code to make as siteSpecific //sarathkumar InclHmeMedi
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
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
	

<body onMouseDown="CodeArrest()" onKeyDown="lockKey()">
<form>
	<table id="tableheader" border="1" width="100%" cellspacing='0' cellpadding='3'>	
	<%-- <tr>
		<td class='columnheader' colspan="11">&nbsp;</td>
		<td class='columnheader' colspan="3" nowrap WIDTH='200'><fmt:message key="eBL.PkgServicesDailyLmt.label" bundle="${bl_labels}"/></td>
		<td class='columnheader' colspan="8">&nbsp;</td>		
	</tr> --%>
	<tr >
	<td class='COLUMNHEADER'  WIDTH='' nowrap><fmt:message key="Common.type.label" bundle="${common_labels}"/></td> 
	<td class='COLUMNHEADER'  WIDTH='' nowrap><fmt:message key="Common.BillingService.label" bundle="${common_labels}"/></td> 
	<td class='COLUMNHEADER'  WIDTH='' nowrap> <fmt:message key="Common.ordercatalog.label" bundle="${common_labels}"/></td> 
	<td class='COLUMNHEADER'  WIDTH='' nowrap><fmt:message key="eBL.AmountIndicator.label" bundle="${bl_labels}"/></td>
	<td class='COLUMNHEADER'  WIDTH='' nowrap><fmt:message key="eBL.FactorRate.label" bundle="${bl_labels}"/></td>
	<td class='COLUMNHEADER'  WIDTH='' nowrap><fmt:message key="eBL.QTY_LMT.label" bundle="${bl_labels}"/></td>
	<td class='COLUMNHEADER'  WIDTH='' nowrap><fmt:message key="eBL.PERC_AMOUNT_INDICATOR.label" bundle="${bl_labels}"/></td>
	<td class='COLUMNHEADER'  WIDTH='' nowrap><fmt:message key="eBL.PERC_AMOUNT.label" bundle="${bl_labels}"/></td>
	<td  class='COLUMNHEADER' WIDTH='' nowrap><fmt:message key="eBL.ROUND_TO.label" bundle="${bl_labels}"/></td>
	<td  class='COLUMNHEADER' WIDTH='' nowrap><fmt:message key="eBL.ROUND_INDICATOR.label" bundle="${bl_labels}"/></td>
	<td  class='COLUMNHEADER' WIDTH='' nowrap><fmt:message key="eBL.PkgLmtIndLevel.label" bundle="${bl_labels}"/></td>
	<!-- <td class='columnheader' ><fmt:message key="eBL.PercentageLimit.label" bundle="${bl_labels}"/></td>
	<td class='columnheader' ><fmt:message key="eBL.AMT_LMT.label" bundle="${bl_labels}"/></td>
	<td class='columnheader' ><fmt:message key="eBL.NoLimit.label" bundle="${bl_labels}"/></td>
	 -->
	 
	  <%if(ss){ %>
	 <!-- //sarathkumar InclHmeMedi -->							
	<td  class='COLUMNHEADER' WIDTH='' nowrap><fmt:message key="eBL.IncludeHomeMedication.label" bundle="${bl_labels}"/></td>
	 <% }
	  else{ %>
		  <td class='COLUMNHEADER' WIDTH='' nowrap  Display:none > </td>
			 
	<% } %>
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
	<td class='COLUMNHEADER' WIDTH='' nowrap><fmt:message key="Common.Replace.label" bundle="${common_labels}"/></td>
	<td class='COLUMNHEADER' WIDTH='' nowrap><fmt:message key="eBL.RefundRatePer.label" bundle="${bl_labels}"/></td>
	<td class='COLUMNHEADER' WIDTH='' nowrap><fmt:message key="eBL.AUTO_REFUND.label" bundle="${bl_labels}"/></td>
	<!--<td class='columnheader' ><fmt:message key="eBL.ApplyFactorForServiceLimit.label" bundle="${bl_labels}"/></td>-->
	<td  class='COLUMNHEADER' width='' nowrap>Appl Fact ServLmt</td>
	<td class='COLUMNHEADER' WIDTH=='' nowrap><fmt:message key="eBL.CLOSE_PACKAGE.label" bundle="${bl_labels}"/></td>
	<td class='COLUMNHEADER' WIDTH='' nowrap><fmt:message key="eBL.serviceLimit.label" bundle="${bl_labels}"/></td>
	<td class='COLUMNHEADER'width=''  nowrap><fmt:message bundle="${bl_labels }" key="eBL.SplitReqd.label"></fmt:message></td> <!-- Added By Rajesh V -->
	<td class='COLUMNHEADER' WIDTH='' nowrap><fmt:message key="Common.Select.label" bundle="${common_labels}"/></td>
	<!-- <td>&nbsp;&nbsp;&nbsp;</td> --><!-- Commented V190624-Aravindh/MMS-DM-CRF-0129.1/Unwanted TD -->
	</tr>
</table>
</form>	
</body>
</html>

