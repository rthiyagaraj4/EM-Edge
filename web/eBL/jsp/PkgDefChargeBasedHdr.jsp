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
		System.out.println("siteSpecf" + ss);

		
		%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
	<script language="javascript" src="../../eCommon/js/common.js"></script>
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
<Script src=\"../../eCommon/js/showModalDialog.js\" language=\"JavaScript\"></Script>




<body onMouseDown="CodeArrest()" onKeyDown="lockKey()">
<form>
	<table id="tableheader" border="1" width="100%" cellspacing='0' cellpadding='3'>		
	<tr>
	<!-- Added by MuthuN against 28192 on 27-7-12 -->
		<td class='COLUMNHEADER'  width ='9%' nowrap ><fmt:message key="Common.type.label" bundle="${common_labels}"/></td>	
		<td  class='COLUMNHEADER'  width ='16%' nowrap><fmt:message key="Common.BillingService.label" bundle="${common_labels}"/> / <fmt:message key="Common.item.label" bundle="${common_labels}"/></td>
		<td class='columnheader' width ='13%' nowrap><fmt:message key="eBL.PERC_AMOUNT_INDICATOR.label" bundle="${bl_labels}"/></td>
		<td class='columnheader' width ='9%' nowrap><fmt:message key="eBL.PERC_AMOUNT.label" bundle="${bl_labels}"/></td>
		<td class='COLUMNHEADER' width ='10%' nowrap><fmt:message key="eBL.serviceLimit.label" bundle="${bl_labels}"/></td>
		<td  class='COLUMNHEADER' width ='10%' nowrap><fmt:message key="eBL.ROUND_TO.label" bundle="${bl_labels}"/></td>
		<td  class='COLUMNHEADER' width ='10%' nowrap><fmt:message key="eBL.ROUND_INDICATOR.label" bundle="${bl_labels}"/></td>
		
		
		
	  <%if(ss){ %>
 		<!-- //sarathkumar InclHmeMedi -->
		<td  class='COLUMNHEADER' WIDTH='' nowrap><fmt:message key="eBL.IncludeHomeMedication.label" bundle="${bl_labels}"/></td>
		 <% }%>
		
		<td class='columnheader' width ='10%' nowrap><fmt:message key="eBL.RefundRatePer.label" bundle="${bl_labels}"/></td>
		<td class='columnheader' width ='10%' nowrap><fmt:message key="eBL.AUTO_REFUND.label" bundle="${bl_labels}"/></td>
		<td class='COLUMNHEADER' width ='3' nowrap >Factor appl for serv_lmt</td>
		<td class='COLUMNHEADER' width ='10%' nowrap><fmt:message key="Common.Select.label" bundle="${common_labels}"/></td>
		<!--<td class='COLUMNHEADER'  width ='9%' nowrap ><fmt:message key="Common.type.label" bundle="${common_labels}"/></td>	
		<td  class='COLUMNHEADER'  width ='' nowrap><fmt:message key="Common.BillingService.label" bundle="${common_labels}"/></td>
		<!-- <td  class='COLUMNHEADER' width="30%"><fmt:message key='Common.ServiceDescription.label' bundle='${common_labels}'/></td>
		<td class='columnheader' width ='' nowrap><fmt:message key="eBL.PERC_AMOUNT_INDICATOR.label" bundle="${bl_labels}"/></td>
		<td class='columnheader' width ='' nowrap><fmt:message key="eBL.PERC_AMOUNT.label" bundle="${bl_labels}"/></td>
		<td class='COLUMNHEADER' width ='' nowrap><fmt:message key="eBL.serviceLimit.label" bundle="${bl_labels}"/></td>
		<td  class='COLUMNHEADER' width ='' nowrap><fmt:message key="eBL.ROUND_TO.label" bundle="${bl_labels}"/></td>
		<td  class='COLUMNHEADER' width ='' nowrap><fmt:message key="eBL.ROUND_INDICATOR.label" bundle="${bl_labels}"/></td>
		<td class='columnheader' width ='' nowrap><fmt:message key="eBL.RefundRatePer.label" bundle="${bl_labels}"/></td>
		<td class='columnheader' width ='' nowrap><fmt:message key="eBL.AUTO_REFUND.label" bundle="${bl_labels}"/></td>
		<td class='columnheader' width ='' nowrap><fmt:message key="eBL.ApplyFactorForServiceLimit.label" bundle="${bl_labels}"/></td>
		<td class='columnheader' width ='' nowrap >Factor appl for serv_lmt</td>
		<td class='COLUMNHEADER' width ='' nowrap><fmt:message key="Common.Select.label" bundle="${common_labels}"/></td>-->	
	</td>
	</tr>
	
		</table>
		
	</form>	
	</body>
</html>



