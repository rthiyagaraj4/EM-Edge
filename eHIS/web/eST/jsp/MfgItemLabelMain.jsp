<!DOCTYPE html>
 <%-- JSP Page specific attributes start --%>
<%@page contentType="text/html;charset=UTF-8" import="java.util.*, eST.*, eST.Common.* , eCommon.Common.*"%>
<%-- JSP Page specific attributes end --%>

<%-- Mandatory declarations start --%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp"%> 
<%-- Mandatory declarations end --%>

<html>
<head>
<!-- 	<link rel="stylesheet" type="text/css" href="../../eCommon/html/IeStyle.css"></link>
 -->	<%
		request.setCharacterEncoding("UTF-8");
		String locale			= (String)session.getAttribute("LOCALE");
		
		String sStyle =
		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' ></link>
<script language="JavaScript" src="../../eCommon/js/common.js"></script>
	<script language="JavaScript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="JavaScript" src="../js/StCommon.js"></script>
<!-- 	<script language="JavaScript" src="../js/StMessages.js"></script>
 -->	<script language="JavaScript" src="../js/ReportMfgItemLabel.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

 </head>

<body onload="FocusFirstElement()" >

<%
	/* Mandatory checks start */
//	String mode					=	request.getParameter( "mode" );
	String bean_id				=	"StockLevelReportBean";
	String bean_name			=	"eST.StockLevelReportBean";
	
	/* Initialize Function specific start */
	StockLevelReportBean bean = (StockLevelReportBean)getBeanObject( bean_id,bean_name,request ) ;  
	bean.setLanguageId(locale);
//	bean.clear() ;

	/* Initialize Function specific end */
	
	String site_id = bean.getCustomerID();
	System.out.println("site_id" +site_id);

%>
		
<form name="formMfgItemLabelMain" id="formMfgItemLabelMain" >
<br>

<table border = 0 cellpadding=0 cellspacing=0 width="74%" align="center">
<tr>
	<td colspan="3">&nbsp;</td>
</tr>
<tr>
	<td class="label" width='35%'><fmt:message key="Common.reporttype.label" bundle="${common_labels}"/></td>
	<td colspan="2">&nbsp;&nbsp;
	<select name="summary_code" id="summary_code" onChange="loadPage();">
	<option value="" >&nbsp;&nbsp;&nbsp;&nbsp;---------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---------&nbsp;&nbsp;</option>
	<% if(site_id.equals("MOHBR")){%>
	<option value="A"><fmt:message key="eST.ManufacturingItemLabel.label" bundle="${st_labels}"/></option>
	<option value="B"><fmt:message key="eST.RepackingLabelWithBarcode.label" bundle="${st_labels}"/></option>
	<option value="C"><fmt:message key="eST.RepackingLabelWithoutBarcode.label" bundle="${st_labels}"/></option>
	
	<%}else{%>  
	<option value="A"><fmt:message key="eST.ManufacturingItemLabel.label" bundle="${st_labels}"/></option>
	<option value="B"><fmt:message key="eST.RepackingLabel.label" bundle="${st_labels}"/></option>
	<%}%>
		</select></td>
</tr>
<tr>
	<td colspan="3">&nbsp;</td>
</tr>
</table>
<input type="hidden" name="bean_id" id="bean_id" value="<%=bean_id%>">
<input type="hidden" name="bean_name" id="bean_name" value="<%= bean_name %>">
</form>
<%
putObjectInBean(bean_id,bean,request);
%>
</body>

</html>

