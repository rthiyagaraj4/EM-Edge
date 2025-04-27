<!DOCTYPE html>
<%@page contentType="text/html;charset=UTF-8" import="java.util.*, ePH.*, ePH.Common.*, eCommon.Common.*" %>
<%@include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%-- Mandatory declarations end --%>
<%@ page import="java.sql.*, java.util.*, java.text.*,webbeans.eCommon.*" %>
<html>
	<head>
<%
		request.setCharacterEncoding("UTF-8");
		String locale			= (String)session.getAttribute("LOCALE");
		String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
		<link rel="stylesheet" type ="text/css" href="../../eCommon/html/CommonCalendar.css"></link>
		<script LANGUAGE="javascript" src="../../eCommon/js/common.js"></script>
		<script language="javascript" src="../../eCommon/js/CommonCalendar.js"></script>
		<script language="javascript" src="../../ecommon/js/ValidateControl.js"></script>
		<script language="JavaScript" src="../../eCommon/js/CommonLookup.js"></script>
		<script language="Javascript" src="../../eCommon/js/DateUtils.js"></script>
		<script language="JavaScript" src="../../eCommon/js/FieldFormatMethods.js"></script>
		<script LANGUAGE="javascript" src="../../ePH/js/PhRepRetunMedication.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	</head>
<%
	String p_facility_id		= (String) session.getValue( "facility_id" ) ;
	String bean_id				= "PHReportsBean" ;
	String bean_name			= "ePH.PHReportsBean";
	PHReportsBean bean	= (PHReportsBean)getBeanObject( bean_id, bean_name , request) ;
	bean.setLanguageId(locale);
    ArrayList facilityList       = bean.getFacilitys();
    ArrayList alFormDtls       = bean.getFormDtls();
	String facility_id  =  (String) session.getValue( "facility_id" ) ;
	String user_name  =  (String) session.getValue( "login_user" ) ;
	String sysdate =com.ehis.util.DateUtils.convertDate(bean.getSysDate(), "DMY","en",locale);
	String SQL_PH_MEDN_RETUN_REASON_SELECT=PhRepository.getPhKeyValue( "SQL_PH_MEDN_RETUN_REASON_SELECT" );
%>
	<BODY onMouseDown="" onKeyDown="">
		<form name="formRepReturnMednCriteria" id="formRepReturnMednCriteria" ACTION="../../eCommon/jsp/report_options.jsp" TARGET="messageFrame" >
			<table cellpadding="2" cellspacing="0" width="100%" align="center" border="0">
				<TH COLSPAN="4" ALIGN="center"><fmt:message key="Common.reportcritera.label" bundle="${common_labels}" /></TH>
				<tr>
					<td class="label"><fmt:message key="Common.FacilityName.label" bundle="${common_labels}"/></td>
					<td colspan="3" class="label">
						<SELECT name="p_return_facility_id" id="p_return_facility_id" >
							<OPTION VALUE="" selected><fmt:message key="Common.all.label" bundle="${common_labels}"/></OPTION>
<%
							if (facilityList.size() > 0 ){
								for (int i=0; i<facilityList.size(); i+=2) {
%>
										<OPTION VALUE="<%= facilityList.get(i) %>"><%= facilityList.get(i+1) %></OPTION>
<% 	
								}
							}
%>
					</select><img src="../../eCommon/images/mandatory.gif" align="center">
					</td>
				</tr>
				<tr>
					<td class="label"><fmt:message key="ePH.reporttype.label" bundle="${ph_labels}"/></td>
					<td colspan="3" class="label">
						<select name="p_rep_type" id="p_rep_type" onchange='dispMandImg(this);' >
							<option value="S" selected><fmt:message key="Common.Summary.label" bundle="${common_labels}"/></option>
							<option value="D"><fmt:message key="Common.Detail.label" bundle="${common_labels}"/></option>
						</select><img src="../../eCommon/images/mandatory.gif" align="center">
					</td>
				</tr>
				<tr>
					<td class="label" width='15%'><fmt:message key="ePH.ReturnDateFrom.label" bundle="${ph_labels}"/></td>
					<td class='label' width='25%'>
						<input type="text" name="frm_date" id="frm_date" size=10 maxlength=10 class="DATE" value="<%=sysdate%>" onChange="if(CheckDateT(this)) dateCheckWithCurrDate('F');" ><input class="STSMALL" type='image' src="../../eCommon/images/CommonCalendar.gif" onClick="return showCalendar('frm_date');" >&nbsp;<img src="../../eCommon/images/mandatory.gif" align="center">
					</td>
					<td class="label" width='10%' align='right'><fmt:message key="Common.to.label" bundle="${common_labels}"/></td>
					<td class='label' ><input type="text" name="to_date" id="to_date" size=10 maxlength=10 class="DATE" value="<%=sysdate%>" onChange="if(CheckDateT(this) && dateCheckWithCurrDate('T')) validateProcessDt();" ><input class="STSMALL" type='image' src="../../eCommon/images/CommonCalendar.gif" onClick="return showCalendar('to_date');" >&nbsp;<img src="../../eCommon/images/mandatory.gif" align="center">
					</td>
				</tr>
				<tr>
					<td class="label"><fmt:message key="Common.patientId.label" bundle="${common_labels}"/></td>
					<td colspan="3" class="label">
						<input type="text" name="p_patient_id" id="p_patient_id" value="" maxlength="<%=bean.getPatientIDLength()%>" size="20" onKeyPress="changeToUpper()" onchange="Duplicatecheck();" >
						<input type="button" value="?" class="button" name="btnPatientID" id="btnPatientID" onClick="callPatientSearch()">
						<img src="../../eCommon/images/mandatory.gif" align="center" id='img_mand_pat_id' style='display:none;'></img> 
					</td>
				</tr>
				<tr>
					<td class="label" valign='top'><fmt:message key="Common.Return.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="Common.reason.label" bundle="${common_labels}"/></td>
					<td class='label'  valign='top'>
						<input type="text" name="p_return_Reason_desc" id="p_return_Reason_desc" value="" maxlength="60" size="40" onChange="searchReasonCode('DESC');">
						<input type="hidden" name="p_return_Reason_code" id="p_return_Reason_code" value="" >
						<input type="button" value="?" class="button" name="btnRetResCode" id="btnRetResCode" onClick="searchReasonCode('LKP');"><img src="../../eCommon/images/mandatory.gif" align="center" id='img_mand_retReason'></img> 
					</td>
					<td class="label" valign='top'><fmt:message key="ePH.FormofDrug.label" bundle="${ph_labels}"/></td>
					<td class='label' >
						<select name="p_form_code" id="p_form_code" size="14" multiple="multiple" style='width:200px;'>
<%
							if (alFormDtls.size() > 0 ){
								for (int i=0; i<alFormDtls.size(); i+=2) {
%>
										<OPTION VALUE="<%= alFormDtls.get(i) %>"><%= alFormDtls.get(i+1) %></OPTION>
<% 	
								}
							}
%>
						</select>
					</td>
				</tr>
			</table>
			
			<INPUT TYPE="hidden" name="p_user_name" id="p_user_name" VALUE="<%= session.getValue( "login_user" ) %>">
			<INPUT TYPE="hidden" name="p_facility_id" id="p_facility_id" VALUE="<%= p_facility_id %>">
			<INPUT TYPE="hidden" name="bean_id" id="bean_id" VALUE="<%=bean_id%>">
			<INPUT TYPE="hidden" name="bean_name" id="bean_name" VALUE="<%=bean_name%>">
			<INPUT TYPE="hidden" name="p_module_id" id="p_module_id" VALUE="PH">
			<INPUT TYPE="hidden" name="p_report_id" id="p_report_id" VALUE="PHRRETSUM">
			<INPUT TYPE="hidden" name="p_language_id" id="p_language_id" VALUE="<%=locale%>">
			<INPUT TYPE="hidden" name="sysdate" id="sysdate" VALUE="<%=sysdate%>">
			<INPUT TYPE="hidden" name="p_frm_date" id="p_frm_date" VALUE="<%=sysdate%>">
			<INPUT TYPE="hidden" name="p_to_date" id="p_to_date" VALUE="<%=sysdate%>">
			<INPUT TYPE="hidden" name="p_where" id="p_where" VALUE="">
			<INPUT TYPE="hidden" name="SQL_PH_MEDN_RETUN_REASON_SELECT" id="SQL_PH_MEDN_RETUN_REASON_SELECT" VALUE="<%=SQL_PH_MEDN_RETUN_REASON_SELECT%>">
		</form>
	</body>
</html>

