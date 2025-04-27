<!DOCTYPE html>
<% 
/*
------------------------------------------------------------------------------------------------------------------------------
Date		Edit History	Name		Rev.Date		Rev.Name			Description
------------------------------------------------------------------------------------------------------------------------------
27/07/2017		IN061891	Raja S		27/07/2017		Ramesh G		ML-MMOH-CRF-0543
------------------------------------------------------------------------------------------------------------------------------
*/
%>
<%@page import="java.sql.*,webbeans.eCommon.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<html>
<head>
<title><fmt:message key="eCA.PersonalisePatList.label" bundle="${ca_labels}"/></title>
	<%
		request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
		String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
		java.util.Properties p = (java.util.Properties) session.getValue( "jdbc" ) ;
		String locale = (String) p.getProperty("LOCALE");
		
	%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />
	<script language='javascript' src='../../eCommon/js/common.js'></script>
	<script language='javascript' src='../../eCommon/js/DateUtils.js'></script>
	<script language='javascript' src='../../eCommon/js/ValidateControl.js'></script>
	<script language='javascript' src='../../eCommon/js/dchk.js'></script>
	<script type="text/javascript" src="../../eCommon/js/CommonCalendar.js"></script>
	<Script language ="JavaScript" src ='../../eCommon/js/CommonLookup.js'></Script>
	<script language='javascript' src='../../eCA/js/PersonalisePatListDetails.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


</head>
<body class='CONTENT' onMouseDown="CodeArrest()" onKeyDown="lockKey()">
<center>
<form name='PersonalisePatSrchCriteriaForm' id='PersonalisePatSrchCriteriaForm'>
<%
	
	String	query_string		=	"";
	String	from_date_time		=	"";
	String	to_date_time		=	"";
	int 	allowedDays 		= 	7;

	query_string = request.getQueryString();

	to_date_time	=	com.ehis.util.DateUtils.getCurrentDate("DMYHM",locale);
	from_date_time	=	com.ehis.util.DateUtils.minusDate(to_date_time,"DMYHM",locale,allowedDays,"d");

%>
	<table border="0" cellpadding="3" cellspacing="0" width="100%" align='center'>
		<tr>
			<td class="LABEL"  width='10%' ><fmt:message key="Common.Period.label" bundle="${common_labels}"/></td>
			<td class="fields" width='40%' nowrap>
				<input type='text' name='from_date_time' id='from_date_time' value="<%=from_date_time%>" size='14' maxLength='16'  onBlur='CheckDateNew(this); checkPeriodFromTo(this,to_date_time, "DMYHM","<%=locale%>")'><input type='image' src="../../eCommon/images/CommonCalendar.gif" onclick="return showCalendarValidate('from_date_time');">
				&nbsp;&nbsp;-&nbsp;&nbsp;<input type='text' name='to_date_time' id='to_date_time' value="<%=to_date_time%>" size='14' maxLength='16'  onBlur='CheckDateNew(this);checkPeriodFromTo(from_date_time,this,"DMYHM","<%=locale%>")'><input type='image' src="../../eCommon/images/CommonCalendar.gif" onclick="return showCalendarValidate('to_date_time');">
			</td>
			<td  class="LABEL"  width='10%'><fmt:message key="Common.active.label" bundle="${common_labels}"/><input type='radio' name='active' id='active' value='A' onclick='changeactflg(this);' checked></td>
			<td  class="LABEL"  width='10%'><fmt:message key="Common.Inactive.label" bundle="${common_labels}"/><input type='radio' name='active' id='active' value='I' onclick='changeactflg(this);' ></td>
			<input type='hidden' name='active_flg' id='active_flg' value='A'>
			<td  width='15%' class = button align ='right' ><input type='button' name='search' id='search' value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.search.label","common_labels")%>' class='BUTTON' onClick="return showPersonalisePatSearchResults();"></td>
		</tr>	
	</table>
		<input type='hidden' name='query_string' id='query_string'	value="<%=query_string%>">	
</form>
</center>
</body>
</html>
<script language='javascript'>	
	parent.PatCriteriaFr.location.href = "../../eCA/jsp/PersonalisePatListDetails.jsp?<%=query_string%>&active_flg=A&from_date_time=<%=from_date_time%>&to_date_time=<%=to_date_time%>";
</script>

