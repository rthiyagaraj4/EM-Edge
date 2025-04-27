<!DOCTYPE html>
<%@ page import ="java.sql.*,java.net.*,java.text.*, eCA.ChartComponentFormulaBean,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
	<head>
		<title><fmt:message key="eCA.FomulaConstructionForSummary.label" bundle="${ca_labels}"/></title>
		<script src='../../eCA/js/ChartComponent.js' language='javascript'></script>
		<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
		<script src="../../eCommon/js/common.js" language="javascript"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

		<!-- <link rel='stylesheet' type='text/css' href='../../eCommon/html/IeStyle.css'> -->
<%
	request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String sStyle =	(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />
	</head>
	<body onKeyDown="lockKey()">
	<form name='ChartComponentFormulaConstSummaryForm' id='ChartComponentFormulaConstSummaryForm' method='post' action=''>
	<br>
	<%
		HashMap tabSummary = null;
		String chartCompDiscrSearch ="";
		String summaryType= "";
		StringTokenizer  strToken=null;
		ChartComponentFormulaBean formulaBean  = (ChartComponentFormulaBean)session.getAttribute("formulaBean");
		String panel_desc_id = request.getParameter("panel_desc_id")==null?"":request.getParameter("panel_desc_id");
		String discr_msr_id = request.getParameter("discr_msr_id")==null?"":request.getParameter("discr_msr_id");
		if(formulaBean != null)
		{
			tabSummary = formulaBean.getSummary();
			if(tabSummary != null)
			{
				chartCompDiscrSearch =((String)tabSummary.get(panel_desc_id)==null) ? "" : (String)tabSummary.get(panel_desc_id);
				if(!chartCompDiscrSearch.equals(""))
				{	
					strToken = new StringTokenizer(chartCompDiscrSearch,":");
					summaryType = strToken.nextToken().trim();
					summaryType = strToken.nextToken().trim();
					if(summaryType.equals("X"))
						summaryType = "";
				}

			}
		}
				
	%>
	<table width='100%' border=0 align=center bordercolor=blue cellpadding='3' cellspacing='0'>
		<tr>
			<td width='100%' colspan=2>&nbsp;</td>
			<td width='100%' colspan=2>&nbsp;</td>
		</tr>
		<tr>
			<td class=label width='100%' > <fmt:message key="eCA.SummaryLegend.label" bundle="${ca_labels}"/>&nbsp;&nbsp;<input type='text' name='summLegend' id='summLegend' size='12'><img src='../../eCommon/images/mandatory.gif'></td>
		</tr>
		<tr>
			<td width='100%' colspan=2>&nbsp;</td>
			<td width='100%' colspan=2>&nbsp;</td>
		</tr>
		<tr>
			<td class='label' width='100%' >fmt:message key="eCA.SummaryType.label" bundle="${ca_labels}"/>&nbsp;
				<select name='summType' id='summType' onChange='calcSummary()'>
				<option value=''>------------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>-------------</option>
				<option value='SUM' <%if(summaryType.equals("SUM")) out.println("selected");%>><fmt:message key="eCA.SUM.label" bundle="${ca_labels}"/></option>
				<option value='AVERAGE' <%if(summaryType.equals("AVERAGE")) out.println("selected");%>><fmt:message key="Common.Average.label" bundle="${common_labels}"/></option>
				<option value='MINIMUM' <%if(summaryType.equals("MINIMUM")) out.println("selected");%>><fmt:message key="Common.Minimum.label" bundle="${common_labels}"/></option>
				<option value='MAXIMUM' <%if(summaryType.equals("MAXIMUM")) out.println("selected");%>><fmt:message key="Common.maximum.label" bundle="${common_labels}"/></option>
				<option value='PERCENTAGE' <%if(summaryType.equals("PERCENTAGE")) out.println("selected");%>><fmt:message key="eCA.Percentage.label" bundle="${ca_labels}"/></option>
				</select>
				<td width='100%' colspan=2>&nbsp;</td>
				<td width='100%' colspan=2>&nbsp;</td>
			</td>
			<td width='100%' colspan=2>&nbsp;</td>
			<td width='100%' colspan=2>&nbsp;</td>
		</tr>
		<tr>
			<td width='100%' colspan=2>&nbsp;</td>
			<td width='100%' colspan=2>&nbsp;</td>
		</tr>
		<tr>
			<td width='100%'><input type='button' class='button' Value='  OK  ' onclick='clickOK("<%=panel_desc_id%>","<%=discr_msr_id%>")' name='ok'></input>&nbsp;&nbsp;&nbsp;<input type='button' class='button' Value='<fmt:message key="Common.cancel.label" bundle="${common_labels}"/>' onclick='cancelwin()' name='cancel'></input></td>
			<td width='100%' colspan=2>&nbsp;</td>
			<td width='100%' colspan=2>&nbsp;</td>
		</tr>
		<tr>
			<td width='100%' colspan=2>&nbsp;</td>
			<td width='100%' colspan=2>&nbsp;</td>
		</tr>
	</table>	
	</form>
	</body>
</html>

