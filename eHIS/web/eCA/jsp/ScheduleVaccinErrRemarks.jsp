<!DOCTYPE html>
<%@ page import ="java.sql.*,java.util.*,java.net.*,java.text.*,webbeans.eCommon.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<html>
		<head><title><fmt:message key="Common.Error.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="Common.remarks.label" bundle="${common_labels}"/></title>

	<%
		  request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
		  String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
		//java.util.Properties p1 = (java.util.Properties) session.getValue( "jdbc" ) ;
		//String locale = (String) p1.getProperty("LOCALE");
		String error_remarks		=	request.getParameter("error_remarks")==null?"":request.getParameter("error_remarks");

		

	%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />
	<script Language="JavaScript" src='../../eCA/js/ScheduleForVacination.js'></script>
	<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
	<script language='javascript' src='../../eCommon/js/common.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


	</head>

	<body onKeyDown="lockKey()">
		<form name='ScheduleVaccRemarks' id='ScheduleVaccRemarks' >
		<table border="0" cellpadding="3" cellspacing="0" width="100%" align="center" name="resultTable" id="resultTable" id="resultTable">
		<!--<tr><td class='label' colspan=2 ><fmt:message key="Common.Error.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="Common.remarks.label" bundle="${common_labels}"/></td> </tr>-->
		<tr><td class='fields' colspan=2 >
			<textarea name='remark_text' id='remark_text1' value="" rows=9 cols=38 value='' onBlur="SPCheckMaxLen('Complaint Text',this,200,'')" onkeyPress='return checkMaxLimit(this,200)'><%=error_remarks%></textarea><img id = "remarkMandImg" src="../../eCommon/images/mandatory.gif" ></td>
		</tr>
		<tr>
			<td class='label' width='50%'></td><td width='50%' align='right' ><input type='button' class='button' value='<fmt:message key="Common.ok.label" bundle="${common_labels}"/>' id='remOK_btn'  name='remOK_btn' onClick="click_ok();">
			<input type='button' class='button' value='<fmt:message key="Common.cancel.label" bundle="${common_labels}"/>' id='cancel_btn'  name='cancel_btn' onClick="window.close();"></td>
		</tr>

		</table>
		</form>
  </body>
</html>

