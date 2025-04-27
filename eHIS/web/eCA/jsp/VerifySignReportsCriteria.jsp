<!DOCTYPE html>
<%@page import="java.sql.*,java.util.*,webbeans.eCommon.*" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
	<head>
		<title><fmt:message key="eCA.VerifySignReports.label" bundle="${ca_labels}"/></title>
	<%
		request.setCharacterEncoding("UTF-8");	
		String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
		/** added by kishore kumar n on 28/11/2009  */
		String imgUrl="";
	if(sStyle.equals("IeStyle.css"))
	 {
			imgUrl= "../../eCommon/images/searchBoxBG.jpg";
	 }
	 /** ends here*/


		java.util.Properties p = (java.util.Properties) session.getValue( "jdbc" ) ;
		String locale = (String) p.getProperty("LOCALE");
	%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />
	    <script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
		<script src="../../eCommon/js/common.js" language="javascript"></script>
		<script language=javascript src='../../eCommon/js/CommonLookup.js'></script>
		<script type='text/javascript' src="../../eCommon/js/CommonCalendar.js"></script>
		<script language='javascript' src='../../eCommon/js/DateUtils.js'></script>
		<script language='javascript' src='../../eCA/js/VerifySignReports.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	</head>
	<body onKeyDown='lockKey()'>
	<%
		String fromDate = "";
		String toDate = "";

		toDate		= com.ehis.util.DateUtils.getCurrentDate("DMY",locale);
	    fromDate	= com.ehis.util.DateUtils.minusDate(toDate,"DMY",locale,7,"d");
	%>
		<form name='signRepCriteriaForm' id='signRepCriteriaForm'>
			<table  border="0" width="100%" cellspacing='0' cellpadding='3' align='center'>
				<tr>
					<td class='label' width='25%'>
						<fmt:message key="Common.Period.label" bundle="${common_labels}"/>
					</td>
					<td class='label' width='15%'>
						<input type='textbox' id='fromDt' name='fromDt' id='fromDt' value='<%=fromDate%>' size=10 maxlength=10 onblur='CheckWithSysDate(this);'></input><input type='image' src="../../eCommon/images/CommonCalendar.gif" onclick="return showCalendarValidate('fromDt')"><img src='../../eCommon/images/mandatory.gif'></img>
					</td>
					<td width='25%'>
					<input type='textbox' id='toDt' name='toDt' id='toDt' value='<%=toDate%>' size=10 maxlength=10 onblur='CheckWithSysDate(this);'></input><input type='image' src="../../eCommon/images/CommonCalendar.gif" onclick="return showCalendarValidate('toDt')"></input><img src='../../eCommon/images/mandatory.gif'></img>
					</td>
					<td>&nbsp;</td>
				</tr>
				<tr>
					<td class='label' width='25%'>
						<fmt:message key="Common.patientId.label" bundle="${common_labels}"/>
					</td>
					<td width='15%'>
						<input type='text' width='25%' name='patientId' id='patientId' value='' nowrap onKeyPress='return CheckForSpecChars(event)' onBlur='' size='' maxlength='' ><input type='button' name='patSearch' id='patSearch' class='button' value='?' tabIndex="4" onClick="callPatientSearch()">
					</td>
					<td>&nbsp;</td>
					<td>
						<input type="button" class=button name='search' id='search'  value='<fmt:message key="Common.search.label" bundle="${common_labels}"/>' onClick="searchForDetails()">
					</td>
				</tr>
			</table>

				<!-- added by kishore kumar n on 27/11/2009  -->
				<%if(!imgUrl.equals("")){ %>
					 <img src='<%=imgUrl%>' width='100%' height='15'/> 
				<%}%>
				<!--ends here -->
			<input type=hidden name='locale' id='locale' value='<%=locale%>'>
			<input type="hidden" name="report_id" id="report_id" value="">
		</form>
		<script>
			document.forms[0].search.click();
		</script>
	</body>
</html>

