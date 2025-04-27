<!DOCTYPE html>
<%
/*
-------------------------------------------------------------------------------------------------------------------------------
Date       		Edit History     Name      	Rev.Date		Rev.Name		Description
-------------------------------------------------------------------------------------------------------------------------------
23/10/2018		IN067402		Prakash		10/09/2018		Ramesh Goli		ML-MMOH-CRF-0813.1
-------------------------------------------------------------------------------------------------------------------------------
*/
%>
<html>
<head>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@page import="java.util.*, eOR.*,eCA.*,eCA.Common.*, eMR.*, eOR.Common.*, eCommon.Common.*, java.sql.*, webbeans.eCommon.*,eCommon.XSSRequestWrapper"%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %> 
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%
	 request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	String imgUrl = "";
	if(sStyle.equals("IeStyle.css"))
	 {
			imgUrl= "../../eCommon/images/searchBoxBG.jpg";	 
	 }
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
<link rel="stylesheet" type="text/css" href="../../eCommon/html/CommonCalendar.css" />	
	<script language='javascript' src='../../eCommon/js/DateUtils.js'></script>
	<script type="text/javascript" src="../../eCommon/js/CommonCalendar.js"></script>
	<script language='javascript' src='../../eCommon/js/ValidateControl.js'></script>
	<script language='javascript' src='../../eCommon/js/common.js'></script>
	<script src='../../eCommon/js/dchk.js' language='javascript'></script>	
	<script src='../../eCA/js/DateCheck.js' language='javascript'></script>
	<script src='../../eCA/js/CATannerStaging.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<body onMouseDown="CodeArrest()" onKeyDown="lockKey()">
<%
	Properties p = (Properties)session.getValue("jdbc");
	String locale= (String) p.getProperty("LOCALE");
	String date_from="";
	String date_to="";
	
	if (date_from.equals(""))
	{
		date_to		= com.ehis.util.DateUtils.getCurrentDate("DMYHM",locale);
		date_from	= com.ehis.util.DateUtils.minusDate(date_to,"DMYHM",locale,30,"d");
	}
	else
	{
		date_to = com.ehis.util.DateUtils.getCurrentDate("DMYHM",locale);
		date_from = com.ehis.util.DateUtils.convertDate(date_from,"DMYHM","en",locale);				
	}
	
	String patient_id = request.getParameter("patient_id")==null?"":request.getParameter("patient_id");
	String encounter_id = request.getParameter("encounter_id")==null?"":request.getParameter("encounter_id");	
	String sex = request.getParameter("Sex")==null?"":request.getParameter("Sex");	
%>
<form name='tanner_criteria_form' id='tanner_criteria_form' target='messageFrame' >
<table  cellpadding=3 cellspacing=0 width="100%" align=center border=0>
	<tr>
		<td class="label" width='15%'><fmt:message key="Common.Period.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="Common.from.label" bundle="${common_labels}"/>
		</td>
		<td class="fields" width='35%' >
				<input type="text" maxlength=16 size="16" value='<%=date_from%>' name="from_date" id="from_date" onBlur='chkDateTime(this,"DMYHM","<%=locale%>");'><img src="../../eCommon/images/CommonCalendar.gif"  onclick="return showCalendarValidate('from_date');" /> 
				<fmt:message key="Common.to.label" bundle="${common_labels}"/>
				<input type="text" maxlength=16 size="16" value='<%=date_to%>' name="to_date" id="to_date" onBlur='chkDateTime(this,"DMYHM","<%=locale%>");'><img src="../../eCommon/images/CommonCalendar.gif"  onclick="return showCalendarValidate('to_date');" />
		</td>
		<td class="label" id="encid" style="" width='15%'>
				<fmt:message key="Common.encounterid.label" bundle="${common_labels}"/></td>
		<td>
			<input type="text" name="encounter_id" id="encounter_id" value="<%=encounter_id%>" maxlength=12 size=13 onKeyPress = 'return allowValidNumber(this,event,12,0)' onblur = 'isNumeric(this)' >
		</td>
		<td>
			<input type="button" class=button name='search' id='search' value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.search.label","common_labels")%>'  onClick="populateResult()">&nbsp;
		</td>
	</tr>
		<input type="hidden" name="date_from" id="date_from" value="<%=date_from%>">
		<input type="hidden" name="date_to" id="date_to" value="<%=date_to%>">
		<input type="hidden" name="encounterid" id="encounterid" value="<%=encounter_id%>">
		<input type="hidden" name="patient_id" id="patient_id" value="<%=patient_id%>">
		<input type="hidden" name="sex" id="sex" value="<%=sex%>">
</table>
</form>
</body>
</html>
<script>
populateResult();
</script>

