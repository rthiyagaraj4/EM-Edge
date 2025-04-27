<!DOCTYPE html>
<%-- JSP Page specific attributes start --%>
<%@page contentType="text/html;charset=UTF-8" import="java.util.*, java.lang.*,eST.*, eST.Common.* , eCommon.Common.*"%>
<%-- JSP Page specific attributes end --%>

<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp"%> 
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%-- Mandatory declarations end --%>

<html>
<head>
<%
		request.setCharacterEncoding("UTF-8");
		String locale			=	(String)session.getAttribute("LOCALE");
		String sStyle			=	(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	%>

		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' ></link>
		<script language="JavaScript" src="../../eCommon/js/common.js"></script>
		<script language="JavaScript" src="../../eCommon/js/ValidateControl.js"></script>
		<script language="JavaScript" src="../js/StCommon.js"></script>
		<script language="JavaScript" src="../js/SRRTrnSummaryReport.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>

<body onload="FocusFirstElement()" >

<%
	/* Mandatory checks start */
//	String mode					=		request.getParameter( "mode" );
	String bean_id				=		"TrnSummaryListBean";
	String bean_name			=		"eST.TrnSummaryListBean";
	
	/* Initialize Function specific start */
	TrnSummaryListBean bean		=		(TrnSummaryListBean)getBeanObject( bean_id,bean_name,request ) ;  
//	bean.clear() ;
	bean.setLanguageId(locale);
	/* Initialize Function specific end */

%>
		
<form name="formTrnSummaryList" id="formTrnSummaryList" >
<br>

<table cellpadding=0 cellspacing=0 width="70%" align="center">
<tr>
	<td colspan="3">&nbsp;</td>
</tr>
<tr>
	<td align="right" class="label" width='35%'><fmt:message key="Common.Transaction.label"   bundle="${common_labels}"/></td>
	<td align="left"  colspan="2">&nbsp;&nbsp;
		<select name="summary_code" id="summary_code" onchange="loadPage();">
			<option value="">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;-----<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>-----&nbsp;&nbsp;&nbsp;</option>
			<option  value='A'><fmt:message key="Common.Request.label" bundle="${common_labels}"/></option>
			<option  value='B'><fmt:message key="Common.Issue.label" bundle="${common_labels}"/></option>
			<option  value='C'><fmt:message key="eST.ManufacturingReceipt.label" bundle="${st_labels}"/></option>
			<option  value='D'><fmt:message key="eMM.Adjustment.label" bundle="${mm_labels}"/></option>
			<option  value='E'><fmt:message key="Common.Transfer.label" bundle="${common_labels}"/></option>
			<option  value='F'><fmt:message key="eST.IssueReturns.label" bundle="${st_labels}"/></option>
			<option  value='G'><fmt:message key="eST.GoodsReceivedNote.label" bundle="${st_labels}"/></option>
			<option  value='H'><fmt:message key="eST.GoodsReturntoVendor.label" bundle="${st_labels}"/></option>
			<option  value='J'><fmt:message key="eST.Bonus.label" bundle="${st_labels}"/></option>
			<option  value='K'><fmt:message key="eST.ProductTransfer.label" bundle="${st_labels}"/></option>
			<!-- only for MOHML add on 13/02/2009 -->
			<option  value='L'><fmt:message key="eST.Manufacturing.label" bundle="${st_labels}"/> <fmt:message key="Common.details.label" bundle="${common_labels}"/> </option>
			<option  value='M'><fmt:message key="eST.SplitBatch.label" bundle="${st_labels}"/></option>
			<option  value='N'><fmt:message key="eST.ChangeBinLocation.label" bundle="${st_labels}"/></option>
			<option  value='O'><fmt:message key="eST.CondemnExpiredBatches.label" bundle="${st_labels}"/></option>
			<option  value='P'><fmt:message key="eST.Acknowledge.label" bundle="${st_labels}"/></option>
		</select>
	</td>
</tr>
<tr>
	<td colspan="3">&nbsp;</td>
</tr>
</table>
	<input type="hidden" name="bean_id" id="bean_id"			value="<%=bean_id%>">
	<input type="hidden" name="bean_name" id="bean_name"		value="<%= bean_name %>">
</form>
<%
putObjectInBean(bean_id,bean,request);
%>
</body>
</html>

