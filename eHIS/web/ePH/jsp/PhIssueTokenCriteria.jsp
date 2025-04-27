<!DOCTYPE html>
 <%-- saved on 03/11/2005 --%>
<%-- JSP Page specific attributes start --%>
<%@page contentType="text/html;charset=UTF-8" import="java.util.*,java.sql.*, ePH.*, ePH.Common.*, eCommon.Common.*" %>
<%-- JSP Page specific attributes end --%>

<%-- Mandatory declarations start --%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%-- Mandatory declarations end --%>

<html>
<head>
	<!-- <link rel="stylesheet" type="text/css" href="../../eCommon/html/IeStyle.css"></link> -->
	<%
	request.setCharacterEncoding("UTF-8");
	String locale			= (String)session.getAttribute("LOCALE");
	//


String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>

 	<script LANGUAGE="javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<script LANGUAGE="javascript" src="../../ePH/js/PhIssueToken.js"></script>
	<SCRIPT LANGUAGE="javascript" SRC="../../eCommon/js/CommonLookup.js"></SCRIPT>
	<SCRIPT LANGUAGE="javascript" SRC="../../eCommon/js/dchk.js"></SCRIPT>
	<script LANGUAGE="javascript" src="../../eCommon/js/common.js"></script>
	<script LANGUAGE="javascript" src="../js/PhCommon.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>

<%
	String p_facility_id		= (String) session.getValue( "facility_id" ) ;
	String bean_id				= "PhIssueTokenBean" ;
	String bean_name			= "ePH.PhIssueTokenBean";
	PhIssueTokenBean bean		= (PhIssueTokenBean)getBeanObject( bean_id, bean_name, request ) ;
	bean.setLanguageId(locale);
    ArrayList displocationlist  = bean.getDispLocationList();
	String pat_id_length=bean.getPatientIDLength();

%>


<!-- <BODY onload="document.formPhIssueTokenCriteria.p_disp_locn_code.focus();"> -->
<BODY onload="document.formPhIssueTokenCriteria.p_disp_locn_code.focus();" onMouseDown="" onKeyDown="lockKey()">

<form name="formPhIssueTokenCriteria" id="formPhIssueTokenCriteria" ACTION="../../eCommon/jsp/report_options.jsp" TARGET="messageFrame" >
	
	<table cellpadding="0" cellspacing="0" width="100%" align="center" border="0">
	<TH COLSPAN="4" ALIGN="left"><fmt:message key="Common.reportcritera.label" bundle="${common_labels}"/></TH>
	<tr>
        <td align="right" class="label"><fmt:message key="ePH.DispenseLocation.label" bundle="${ph_labels}"/></td>
		<td  align="left">&nbsp;<SELECT name="p_disp_locn_code" id="p_disp_locn_code" onChange="populateTokenSeries(p_facility_id.value,this.value)">
		   	<OPTION VALUE=" ">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;---<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			</OPTION>
	 <%	 if (displocationlist.size() > 0 )
				for (int i=0; i<displocationlist.size(); i+=2) {
	%>
			 <OPTION VALUE="<%= displocationlist.get(i) %>"><%= displocationlist.get(i+1) %></OPTION>

	<% 	} %> 
	  </SELECT><img src="../../eCommon/images/mandatory.gif" align="center"></td> 
		<td align="right" width="25%" class="label"><fmt:message key="ePH.TokenSeries.label" bundle="${ph_labels}"/></td>
		<td align="left" width="30%">&nbsp;<SELECT name="p_token_series_code" id="p_token_series_code">
		<OPTION VAlUE="">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;---<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</OPTION>
	   	</SELECT><img src="../../eCommon/images/mandatory.gif" align="center"></td>
	</tr>
	<td align="right" class="label"><fmt:message key="Common.patientId.label" bundle="${common_labels}"/></td>
		<td align="left"  >&nbsp;<input type="text" name="p_patient_id" id="p_patient_id" onKeyPress="return CheckForSpecChars(event)"maxlength="<%=pat_id_length%>" size="20" value="" onblur="Duplicatecheck();populateTokenSeries_NO(document.formPhIssueTokenCriteria.p_disp_locn_code.value,document.formPhIssueTokenCriteria.p_token_series_code.value,document.formPhIssueTokenCriteria.p_patient_id.value)" ><!--  onblur="Duplicatecheck();" added for ML-BRU-SCF-0621[IN036565]-->		<input type="button" class="button" value="?" name="pat_search" id="pat_search" onClick="callPatientSearch(document.formPhIssueTokenCriteria.p_patient_id)">
		</SELECT><img src="../../eCommon/images/mandatory.gif" align="center"></td>
		<td align="right" width="25%" class="label"><fmt:message key="ePH.TokenNo.label" bundle="${ph_labels}"/></td>
		<td align="left" width="30%">&nbsp;<SELECT name="p_serial_no" id="p_serial_no">
		<OPTION VAlUE="">--<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>--</OPTION>
	   	</SELECT><img src="../../eCommon/images/mandatory.gif" align="center"></td>
	</tr>
	
	</table>
	
	<INPUT TYPE="hidden" name="p_user_name" id="p_user_name" VALUE="<%= session.getValue( "login_user" ) %>">
	<INPUT TYPE="hidden" name="p_facility_id" id="p_facility_id" VALUE="<%= p_facility_id %>">
	<INPUT TYPE="hidden" name="bean_id" id="bean_id" VALUE="<%=bean_id%>">
	<INPUT TYPE="hidden" name="bean_name" id="bean_name" VALUE="<%=bean_name%>">
	<INPUT TYPE="hidden" name="p_module_id" id="p_module_id" VALUE="PH">
	<INPUT TYPE="hidden" name="p_report_id" id="p_report_id" VALUE="PHBREGPR">
	<INPUT TYPE="hidden" name="p_language_id" id="p_language_id" VALUE="<%=locale%>">
	
</form>
<% putObjectInBean(bean_id,bean,request); %>

</body>
</html>

