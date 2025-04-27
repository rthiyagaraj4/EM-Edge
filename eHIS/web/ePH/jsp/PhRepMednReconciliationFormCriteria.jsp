<!DOCTYPE html>
<%-- JSP Page specific attributes start --%>
<%@page contentType="text/html;charset=UTF-8 " import="java.util.*, ePH.*,ePH.Common.*" %>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp"%> 
<%@ include file="../../eCommon/jsp/CommonInclude.jsp" %> 
	<head>
<%
		request.setCharacterEncoding("UTF-8");
		String locale			= (String)session.getAttribute("LOCALE");
		String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
		<link rel="stylesheet" type ="text/css" href="../../eCommon/html/CommonCalendar.css"></link>
		<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
		<script language="javascript" src="../../ePH/js/PhRepMednReconForm.js"></script>
		<script language="javascript" src="../../eCommon/js/common.js"></script>
		<SCRIPT LANGUAGE="javascript" SRC="../../eCommon/js/CommonLookup.js"></SCRIPT>
		<script type="text/javascript" src="../../eCommon/js/CommonCalendar.js"></script>
		<script language="Javascript" src="../../eCommon/js/DateUtils.js"></script>
	</head>
<%
	String bean_id				= "PHReportsBean" ;
	String bean_name			= "ePH.PHReportsBean";
	PHReportsBean bean	= (PHReportsBean)getBeanObject( bean_id, bean_name, request ) ;
	bean.setLanguageId(locale);
	String sys_date=bean.getSysDate();
%>
	<BODY onMouseDown="CodeArrest()" onKeyDown="lockKey()" onload="document.formPhRepMednRecon.p_patient_id.focus();"> 
		<form name="formPhRepMednRecon" id="formPhRepMednRecon" ACTION="../../eCommon/jsp/report_options.jsp" TARGET="messageFrame" >
			<table cellpadding="0" cellspacing="2" width="100%" align="center" border="0">
				<tr>
					<td width="10%" class="label">&nbsp;</td>
					<td class="label" width="10%" ><fmt:message key="Common.patientId.label" bundle="${common_labels}"/></td>
					<td width="*" class="label">
						<input type="text" name="p_patient_id" id="p_patient_id"  maxlength="<%=bean.getPatientIDLength()%>" size="20" size="20" onChange="getPatentDetails(this);">
						<input type="button" class="button" value="?" name="pat_search" id="pat_search" onClick="callPatientSearch(document.formPhRepMednRecon.p_patient_id)" >
						<img  src="../../eCommon/images/mandatory.gif">&nbsp;&nbsp;&nbsp;&nbsp;
						<label id="patient_detail"></label> 
					</td>
				</tr>
				<tr>
					<td class="label">&nbsp;</td>
					<td class="label"  nowrap>
						<fmt:message key="ePH.PrintDate.label" bundle="${ph_labels}"/>
					</td>
					<td class="label" >
						<input type="text" name="p_disp_date" id="p_disp_date" size="8" value="<%=com.ehis.util.DateUtils.convertDate(sys_date,"DMY","en",locale)%>" maxlength="10" onBlur="CheckDateT(this);">
						<IMG SRC="../../eCommon/images/CommonCalendar.gif" id='Calendar' onclick="showCalendar('p_disp_date');document.formPhRepMednRecon.p_disp_date.focus();return false;" >&nbsp;<img  src="../../eCommon/images/mandatory.gif">
					</td>    
				</tr>
			</table>
		   <INPUT TYPE="hidden" name="p_dispense_date" id="p_dispense_date" VALUE="<%=sys_date%>">
		   <INPUT TYPE="hidden" name="p_module_id" id="p_module_id" VALUE="PH">
		   <INPUT TYPE="hidden" name="p_report_id" id="p_report_id" VALUE="PHBDRGCR">
			<INPUT TYPE="hidden" name="p_facility_id" id="p_facility_id" VALUE="<%= session.getValue( "facility_id" ) %>">
			<INPUT TYPE="hidden" name="p_user_name" id="p_user_name" VALUE="<%= session.getValue( "login_user" ) %>">
			<input type="hidden" name="p_mode" id="p_mode" value="VIEW"> 
			<INPUT TYPE="hidden" name="locale" id="locale" VALUE="<%=locale%>"> 
			<INPUT TYPE="hidden" name="p_language_id" id="p_language_id" VALUE="<%=locale%>"> 
		</form>
	</body>
</html>

