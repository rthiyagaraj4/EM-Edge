<!DOCTYPE html>
 <!--
/*
--------------------------------------------------------------------------------------------------------------------------------
Date		Edit History	Name		Rev.Date   	Rev.By 		Description
--------------------------------------------------------------------------------------------------------------------------------
9/10/2020	IN073499		 Shazana								MMS-KH-SCF-0087
---------------------------------------------------------------------------------------------------------------------------------------
*/

--> 

 <%-- saved on 03/11/2005 --%>
<%-- JSP Page specific attributes start --%>
<%@page contentType="text/html;charset=UTF-8" import="java.util.*, ePH.*,eOR.*, ePH.Common.* , eCommon.Common.*" %>

<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<html> 
<head>
	<% 
	request.setCharacterEncoding("UTF-8");
	String locale			= (String)session.getAttribute("LOCALE");
	//
	
	String sStyle=(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?
(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css"; %>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>'type='text/css'></link>
	<link rel="stylesheet" type ="text/css" href="../../eCommon/html/CommonCalendar.css"></link>
 	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="javascript" src="../../ePH/js/PhSyrngeForAdmix.js"></script>
	<SCRIPT LANGUAGE="javascript" SRC="../../eCommon/js/dchk.js"></SCRIPT>
	<script language="JavaScript" src="../../eCommon/js/FieldFormatMethods.js"></script>
	<script language="javascript" src="../../eCommon/js/common.js"></script>
	<SCRIPT LANGUAGE="javascript" SRC="../../eCommon/js/CommonLookup.js"></SCRIPT>
	<script language="javascript" src="../js/PhCommon.js"></script>
	<script type="text/javascript" src="../../eCommon/js/CommonCalendar.js"></script>
	<script language="Javascript" src="../../eCommon/js/DateUtils.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


</head>
<% 
	
	
	String bean_id				= "PHRepDispStatisByDispBean" ;
	String bean_name			= "ePH.PHRepDispStatisByDispBean";
	PHRepDispStatisByDispBean bean	= (PHRepDispStatisByDispBean)getBeanObject( bean_id,bean_name, request ) ;
	bean.setLanguageId(locale);
	String sys_date=bean.getSysdate();
%>


<BODY onMouseDown="CodeArrest()" onKeyDown="lockKey()" 
onload="document.formPhSyrngForAdmixCriteria.p_patient_id.focus();"> 
						
<form name="formPhSyrngForAdmixCriteria" id="formPhSyrngForAdmixCriteria" ACTION="../../eCommon/jsp/report_options.jsp" TARGET="messageFrame" >

<table cellpadding="0" cellspacing="0" width="100%" align="center" border="0">
<TH COLSPAN="6"><fmt:message key="Common.reportcritera.label" bundle="${common_labels}"/></TH>
<tr>
		<td class="label" width="30%" ><fmt:message key="Common.patientId.label" bundle="${common_labels}"/></td>
		
		<td width="30%" >&nbsp;&nbsp;<input type="text" name="p_patient_id" id="p_patient_id" maxlength="<%=bean.getPatientIDLength()%>" size="20" onBlur="Duplicatecheck();populateSyrngDispNo()" onKeyPress="changeToUpper()"><!--  Duplicatecheck(); added for ML-BRU-SCF-0621[IN036565]-->	<input type="button" class="button" value="?" name="pat_search" id="pat_search" onClick="callPatientSearch(document.formPhSyrngForAdmixCriteria.p_patient_id)">&nbsp;<img  src="../../eCommon/images/mandatory.gif"></td>
		<!-- increased width for IN073499 -->

		<td class="label" width="20%" nowrap>&nbsp;&nbsp;&nbsp;&nbsp;<fmt:message key="ePH.DispensedDate.label" bundle="${ph_labels}"/></td>
		
		<td width="10%">&nbsp;&nbsp;<input type="text" name="p_date1" id="p_date1" size="8" value="<%=com.ehis.util.DateUtils.convertDate(sys_date,"DMY","en",locale)%>" maxlength="10" onBlur="if(CheckDateT(this)) populateSyrngDispNo();"><IMG SRC="../../eCommon/images/CommonCalendar.gif" id=Calendar onclick="showCalendar('p_date1');document.formPhSyrngForAdmixCriteria.p_date1.focus();return false;" >&nbsp;<img  src="../../eCommon/images/mandatory.gif"></td>  
		<td class="label"></td>
	<td>&nbsp;&nbsp;
	<INPUT TYPE="hidden" name="p_date" id="p_date" VALUE="">
</tr>
<tr>
	<td class="label" nowrap><fmt:message key="Common.patientclass.label" bundle="${common_labels}"/></td>

	<td>&nbsp;&nbsp;<select name="p_patient_class" id="p_patient_class" onChange="populateSyrngDispNo()">
	<option value="IP"><fmt:message key="Common.inpatient.label" bundle="${common_labels}"/></option>
	<option value="OP"><fmt:message key="Common.Outpatient.label" bundle="${common_labels}"/></option>
	</select>&nbsp<img  src="../../eCommon/images/mandatory.gif">
	</td>
 	
<td class="label" id="lbl_disp_no"><fmt:message key="ePH.DispenseNo.label" bundle="${ph_labels}"/></td>
	<td id="lst_disp_no">&nbsp;&nbsp;<select name="p_disp_no" id="p_disp_no" >
	<option value="">&nbsp;&nbsp;&nbsp;&nbsp;---<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---&nbsp;&nbsp;&nbsp;&nbsp;</option>
	</select>&nbsp<img  src="../../eCommon/images/mandatory.gif">
	</td>
	<td class="label"></td>
	<td>&nbsp;&nbsp;
	</td> 
</tr>
	<INPUT TYPE="hidden" name="p_module_id" id="p_module_id" VALUE="PH">
	<INPUT TYPE="hidden" name="p_report_id" id="p_report_id" VALUE="PHBRSYGLB">
	<INPUT TYPE="hidden" name="p_facility_id" id="p_facility_id" VALUE="<%= session.getValue( "facility_id" ) %>">
	<INPUT TYPE="hidden" name="p_user_name" id="p_user_name" VALUE="<%= session.getValue( "login_user" ) %>">
	<INPUT TYPE="hidden" name="locale" id="locale" VALUE="<%=locale%>"> 
	<INPUT TYPE="hidden" name="p_language_id" id="p_language_id" VALUE="<%=locale%>">



</body>
<%
putObjectInBean(bean_id,bean,request);
%>

</html>

