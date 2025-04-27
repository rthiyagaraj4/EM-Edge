<!DOCTYPE html>
<%-- JSP Page specific attributes start --%>
<%@page contentType="text/html;charset=UTF-8" import="java.util.*, ePH.*, ePH.Common.*, eCommon.Common.*" %>
<%-- JSP Page specific attributes end --%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<%@ page import="java.sql.*, java.util.*, java.text.*,webbeans.eCommon.*" %>
<html>
	<head>
<% 
		request.setCharacterEncoding("UTF-8");
		String locale			= (String)session.getAttribute("LOCALE");
		String sStyle=(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css"; %>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>'type='text/css'></link>
		<link rel="stylesheet" type ="text/css" href="../../eCommon/html/CommonCalendar.css"></link>
		<script type="text/javascript" src="../../eCommon/js/CommonCalendar.js"></script>
		<script language="JavaScript" src="../../eCommon/js/dchk.js"></script>
		<script language="JavaScript" src="../../eCommon/js/ValidateControl.js"></script>
		<script language="JavaScript" src="../../eCommon/js/common.js"></script>
		<script language="JavaScript" src="../../ePH/js/PhCommon.js"></script>
		<script language="JavaScript" src="../../ePH/js/PhPatWaitTime.js"></script> 
		<script language="Javascript" src="../../eCommon/js/DateUtils.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	</head>	
<%
	String function_id	=	request.getParameter("function_id");
	if(function_id ==null) function_id="";
	String bean_id			= "PhDrugInfoEnqBean" ;
	String bean_name		= "ePH.PhDrugInfoEnqBean";
	PhDrugInfoEnqBean bean = (PhDrugInfoEnqBean)getBeanObject( bean_id,bean_name , request ) ;
	bean.setLanguageId(locale);
	String sys_date="";
	sys_date		=bean.getSysdate();
	SimpleDateFormat dtSystemFormat = new SimpleDateFormat("dd/MM/yyyy");
	java.util.Date date_time	 	= new java.util.Date();
	String dateString 				= dtSystemFormat.format(date_time);
	dateString 				=com.ehis.util.DateUtils.convertDate(dateString,"DMY","en",locale);
%>
	<BODY onMouseDown="CodeArrest()" onKeyDown="lockKey()" topmargin="0">
		<form name="formPhWaitTimeCriteria" id="formPhWaitTimeCriteria" ACTION="../../eCommon/jsp/report_options.jsp" TARGET="messageFrame"  >
			<br><br><br>
			<table cellpadding="0" cellspacing="0"  border="0" width="50%" align="center">
				<tr>
				</tr>
				<tr><td colspan='3' class='label'>&nbsp;&nbsp;</td></tr>
				<tr><td colspan='3' class='label'>&nbsp;&nbsp;</td></tr>
				<tr>
					<td   class="label" width="35%" colspan='1'>&nbsp;<fmt:message key="Common.reporttype.label" bundle="${common_labels}"/>&nbsp;&nbsp;</td>
					<td  colspan='1' width='65%' ><SELECT name="p_report_type" id="p_report_type" onChange="setTOandFromDate(enq_date_from)" >
					<OPTION VALUE="1"><fmt:message key="Common.daily.label" bundle="${common_labels}"/></OPTION>
					<OPTION VALUE="2"><fmt:message key="Common.monthly.label" bundle="${common_labels}"/></OPTION> 
					</select>
					</td>
				</tr>
				 <tr><td colspan='3' class='label'>&nbsp;&nbsp;</td></tr>
					<tr>
					<td   class="label" width="35%" nowrap colspan='1'>&nbsp;<fmt:message key="ePH.EnquiryDateFrom.label" bundle="${ph_labels}"/>&nbsp;&nbsp;  </td>  
					<%-- <td class="label" align="left" width="65%"> <input type='text'  name='enq_date_from' id='enq_date_from' size='8' value="" maxlength="10" Onblur="if(CheckDateT(this)){DateCheck('<%=dateString%>',enq_date_from)};" onKeyPress='return AllowDateFormat()'>&nbsp;<IMG  SRC="../../eCommon/images/CommonCalendar.gif"  id="phdate" onclick="return showCalendar('enq_date_from');" onblur="document.forms[0].enq_date_from.focus();">&nbsp;<img align='center' src ='../../eCommon/images/mandatory.gif'></img>&nbsp;&nbsp;&nbsp;&nbsp;<fmt:message key="Common.to.label" bundle="${common_labels}"/>&nbsp;&nbsp;<input type='text'  name='enq_date_to' id='enq_date_to' size='8' value="" maxlength="10" Onblur="if(CheckDateT(this)){DateCheck('<%=dateString%>',enq_date_to)};"   onKeyPress='return AllowDateFormat()'>&nbsp;<IMG  SRC="../../eCommon/images/CommonCalendar.gif"  id="phdate1" onclick="return showCalendar('enq_date_to');"  onblur="document.forms[0].enq_date_to.focus();">&nbsp;<img align='center' src ='../../eCommon/images/mandatory.gif'> --%></img><!--p_enq_date_from to enq_date_from AND p_enq_date_to to enq_date_to Added for DateConversion identification -->
					<!-- Added for ML-MMOH-SCF-2364 and ML-BRU-SCF-2212 -->
					<td class="label" align="left" width="65%"> <input type='text'  name='enq_date_from' id='enq_date_from' size='8' value="" maxlength="10" Onblur='checkDate(this,"DMY","<%=locale%>")' onKeyPress='return AllowDateFormat()'>&nbsp;<IMG  SRC="../../eCommon/images/CommonCalendar.gif"  id="phdate" onclick="return showCalendar('enq_date_from');" onblur="document.forms[0].enq_date_from.focus();">&nbsp;<img align='center' src ='../../eCommon/images/mandatory.gif'></img>&nbsp;&nbsp;&nbsp;&nbsp;
					<fmt:message key="Common.to.label" bundle="${common_labels}"/>&nbsp;&nbsp;<input type='text'  name='enq_date_to' id='enq_date_to' size='8' value="" maxlength="10" Onblur='checkDate(this,"DMY","<%=locale%>")'   onKeyPress='return AllowDateFormat()'>&nbsp;<IMG  SRC="../../eCommon/images/CommonCalendar.gif"  id="phdate1" onclick="return showCalendar('enq_date_to');"  onblur="document.forms[0].enq_date_to.focus();">&nbsp;<img align='center' src ='../../eCommon/images/mandatory.gif'>
					</td> 
					<!-- Added for ML-MMOH-SCF-2364 and ML-BRU-SCF-2212-->
				</tr>
				<tr><td colspan='3' class='label'>&nbsp;&nbsp;</td></tr>
				<tr><td colspan='3' class='label'>&nbsp;&nbsp;</td></tr>
			</table>
			<input type="hidden" name="bean_id" id="bean_id" value="<%=bean_id%>">
			<input type="hidden" name="bean_name" id="bean_name"	value="<%=bean_name%>"> 
			<INPUT TYPE="hidden" name="p_facility_id" id="p_facility_id" VALUE="<%= session.getValue( "facility_id" ) %>">
			<INPUT TYPE="hidden" name="p_user_name" id="p_user_name" VALUE="<%= session.getValue( "login_user" ) %>">
			<INPUT TYPE="hidden" name="p_module_id" id="p_module_id" VALUE="PH">
			<INPUT TYPE="hidden" name="sys_dt" id="sys_dt" VALUE="<%=dateString%>">
			<INPUT TYPE="hidden" name="from_dt" id="from_dt" VALUE="">
			<INPUT TYPE="hidden" name="to_dt" id="to_dt" VALUE="">
			<INPUT TYPE="hidden" name="p_report_id" id="p_report_id" VALUE="PHPTWAITTIME">
			<INPUT TYPE="hidden" name="language_id" id="language_id" VALUE="<%=locale%>">
			<INPUT TYPE="hidden" name="p_language_id" id="p_language_id" VALUE="<%=locale%>">
			<INPUT TYPE="hidden" name="p_enq_date_from" id="p_enq_date_from" VALUE=""><!--Added for DateConversion identification -->
			<INPUT TYPE="hidden" name="p_enq_date_to" id="p_enq_date_to" VALUE=""><!--Added for DateConversion identification -->
		</form>
	</body>
	<% putObjectInBean(bean_id,bean,request); %>
</html>

