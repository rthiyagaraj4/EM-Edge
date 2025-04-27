<!DOCTYPE html>
 <%-- JSP Page specific attributes start --%>
<%@page contentType="text/html;" import="java.util.*, ePH.*, ePH.Common.*, eCommon.Common.*" %>
<%-- JSP Page specific attributes end --%>

<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>

<%-- Mandatory declarations start --%>

<%-- Mandatory declarations end --%>
<%@ page import="java.sql.*, java.util.*, java.text.*,webbeans.eCommon.*" %>
<html>
<head>
<% String sStyle=(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?
(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css"; %>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>'type='text/css'></link>
	<link rel="stylesheet" type ="text/css" href="../../eCommon/html/CommonCalendar.css"></link>
	<script type="text/javascript" src="../../eCommon/js/CommonCalendar.js"></script>
	<script language="JavaScript" src="../../eCommon/js/dchk.js"></script>
	<script language="JavaScript" src="../../eCommon/js/messages.js"></script>
	<script language="JavaScript" src="../js/PhMessages.js"></script>
	<script language="JavaScript" src="../../eCommon/js/ValidateControl.js"></script>
    <script language="JavaScript" src="../../eCommon/js/common.js"></script>
	<script language="JavaScript" src="../../eCommon/js/PhCommon.js"></script>
	<script language="JavaScript" src="../../ePH/js/PerfIndrDispensingOP.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
 
</head>	
<BODY onMouseDown="CodeArrest()" onKeyDown="lockKey()" topmargin="0">
<form name="formPhPerfIndrDispensingOPCriteria" id="formPhPerfIndrDispensingOPCriteria" ACTION="../../eCommon/jsp/report_options.jsp" TARGET="messageFrame"  >
<table cellpadding="0" cellspacing="0"  border="0" width="100%" align="center">
<TH COLSPAN="2" ALIGN="left"><fmt:message key="Common.reportcritera.label" bundle="${common_labels}"/></TH>
<tr>
	<td colspan='2' class='label'>&nbsp;&nbsp;</td>
</tr>
<tr>
	<td align="right"  class="label" width="35%" nowrap colspan='1'>&nbsp;<fmt:message key="Common.DateFrom.label" bundle="${common_labels}"/>&nbsp;&nbsp;  </td>  
	<td class="label" align="left" width="65%"> <input type='text'  name='p_enq_date_from' id='p_enq_date_from' size='8' value="" maxlength="10" Onblur="CheckDate(this);" onKeyPress='return AllowDateFormat()'>&nbsp;<IMG SRC="../../eCommon/images/CommonCalendar.gif"  id="phdate" onclick="return showCalendar('p_enq_date_from');" onblur="document.forms[0].p_enq_date_from.focus();">&nbsp;<img align='center' src ='../../eCommon/images/mandatory.gif'></img>&nbsp;&nbsp;&nbsp;&nbsp;<fmt:message key="Common.to.label" bundle="${common_labels}"/>&nbsp;&nbsp;<input type='text'  name='p_enq_date_to' id='p_enq_date_to' size='8' value="" maxlength="10" Onblur="CheckDate(this);"   onKeyPress='return AllowDateFormat()'>&nbsp;<IMG  SRC="../../eCommon/images/CommonCalendar.gif"  id="phdate1" onclick="return showCalendar('p_enq_date_to');"  onblur="document.forms[0].p_enq_date_to.focus();">&nbsp;<img align='center' src ='../../eCommon/images/mandatory.gif'></img>
	</td>
 </tr>
 <tr>
	<td colspan='2' class='label'>&nbsp;&nbsp;</td>
</tr>
</table>
 	<INPUT TYPE="hidden" name="p_user_name" id="p_user_name" VALUE="<%= session.getValue( "login_user" ) %>">
	<INPUT TYPE="hidden" name="p_facility_id" id="p_facility_id" VALUE="<%= session.getValue( "facility_id" ) %>">
	<INPUT TYPE="hidden" name="p_module_id" id="p_module_id" VALUE="PH">
	<INPUT TYPE="hidden" name="p_from_date" id="p_from_date" VALUE="">
	<INPUT TYPE="hidden" name="p_to_date" id="p_to_date" VALUE="">
	<INPUT TYPE="hidden" name="p_report_id" id="p_report_id" VALUE="PHBPFINDSOP">
</form>
</body>
</html>

