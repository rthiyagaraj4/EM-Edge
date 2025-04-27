<!DOCTYPE html>
<%@page import="java.sql.*,webbeans.eCommon.*,java.util.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
	<head>
 <%
	
	request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	java.util.Properties property = (java.util.Properties) session.getAttribute( "jdbc" ) ;
	String locale = (String) property.getProperty("LOCALE");
	String qryString = request.getQueryString();
	String curr_sys_date			= "";
	String to_date			= "";
	String from_date				= "";	

	String patient_id = request.getParameter("patient_id")==null?"":request.getParameter("patient_id");
	String locn_code = request.getParameter("locn_code")==null?"":request.getParameter("locn_code");
	String patient_class = request.getParameter("patient_class")==null?"":request.getParameter("patient_class");

	
	
    curr_sys_date = com.ehis.util.DateUtils.getCurrentDate("DMY",locale);
    from_date = com.ehis.util.DateUtils.minusDate(curr_sys_date,"DMY",locale,7,"d");
  //  to_date = com.ehis.util.DateUtils.plusDate(curr_sys_date,"DMY",locale,7,"d");

   /*   Added by kishore kumar N on 02-Nov-09, for CRF 0691.1   */
	to_date = com.ehis.util.DateUtils.plusDate(curr_sys_date,"DMY",locale,7,"d");
	/*ends here. */
 %>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
        <script language='javascript' src='../../eCommon/js/ValidateControl.js'></script>
		<script language='javascript' src='../../eCommon/js/common.js'></script>
		<script language="javascript" src="../../eCommon/js/dchk.js"></script>
		<script language="javascript" src="../../eCA/js/TaskList.js"></script>
		<script type="text/javascript" src="../../eCommon/js/CommonCalendar.js"></script>
		<Script language ="JavaScript" src ='../../eCommon/js/CommonLookup.js'></Script>
		<script language="javascript" src="../../eOR/js/OrCommonFunction.js"></script>
		<script src="../../eCommon/js/DateUtils.js" language="javascript"></script>
		<script src='../../eCA/js/ScheduleForVacination.js' language='javascript'></script>
		<title></title>
	</head>

	<body>
		<form>
			<table cellpadding='0' cellspacing='0' border='0' width='100%'>
				<tr>
					<td class='label'><fmt:message key="Common.view.label" bundle="${common_labels}"/></td>
					<td class='fields'>
						<select name='sleView' id='sleView'>
							<option value='C' selected><fmt:message key="Common.CurrentEncounter.label" bundle="${common_labels}"/></option>
							<option value='A'><fmt:message key="Common.all.label" bundle="${common_labels}"/></option>
						</select>
					</td>				
					<td class='label'><fmt:message key="Common.Period.label" bundle="${common_labels}"/></td>
					<td class='fields'><input type="text" name="date_from" id="date_from" value="<%=from_date%>" size="10" maxlength="10" onBlur="dateChecking(this,date_to,'<%=locale%>')"><img src="../../eCommon/images/CommonCalendar.gif" align='center' onclick="return showCalendar('date_from');" style='cursor:pointer'>&nbsp;&nbsp;-&nbsp;&nbsp;<input type=text name='date_to' id='date_to' value='<%=to_date%>' size="10" maxlength="10" onBlur="dateChecking(date_from,this,'<%=locale%>')"><img src="../../eCommon/images/CommonCalendar.gif" onclick="return showCalendar('date_to');" style='cursor:pointer'><!-- <img src="../../eCommon/images/mandatory.gif" align='center'> -->&nbsp;&nbsp; <input class='button' type='button' name='go' id='go' value='<fmt:message key="Common.Go.label" bundle="${common_labels}"/>' onclick='showTaskList("<%=qryString%>")'></td>
					<td>
						<input type='button' name='viewMARChart' id='viewMARChart' value='<fmt:message key="eCA.ViewMARChart.label" bundle="${ca_labels}"/>' onClick="callMednDetails('<%=patient_id%>','<%=locn_code%>','<%=patient_class%>')">
					</td>
					</tr> 
				</tr>
			</table>
			
		</form>
	</body>
<SCRIPT LANGUAGE="JavaScript">
	showTaskList("<%=qryString%>");
</SCRIPT>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</html>

