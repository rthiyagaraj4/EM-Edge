<!DOCTYPE html>
<%-- JSP Page specific attributes start --%>
<%@page contentType="text/html;charset=UTF-8" import="java.util.*, ePH.*, ePH.Common.*, eCommon.Common.*" %>
<%-- JSP Page specific attributes end --%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 

<%-- Mandatory declarations start --%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%-- Mandatory declarations end --%>
<%@ page import="java.sql.*,  java.text.*,webbeans.eCommon.*" %>
<html>
	<head>
<%
		request.setCharacterEncoding("UTF-8");
		String locale			= (String)session.getAttribute("LOCALE");
		String sStyle=(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
		<link rel="stylesheet" type ="text/css" href="../../eCommon/html/CommonCalendar.css"></link>
		<script language="javascript" src="../../ePH/js/PhRepAdministrationNotRecorded.js"></script>
		<script language="javascript" src="../../eCommon/js/CommonCalendar.js"></script>
		<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>   
		<script language="javascript" src="../../eCommon/js/common.js"></script>
		<script language="javascript" src="../js/PhCommon.js"></script>
		<script language="Javascript" src="../../eCommon/js/DateUtils.js"></script>
		<SCRIPT LANGUAGE="javascript" SRC="../../eCommon/js/dchk.js"></SCRIPT>	
		<script language="JavaScript" src="../../eCommon/js/FieldFormatMethods.js"></script>
		<script language="JavaScript" src="../../eCommon/js/CommonLookup.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
<!-- adding for scf ML-BRU-SCF-0498 [IN:035593] -->
	</head>
<%
	String bean_id				= "PHRepMednAdmnListBean" ;
	String bean_name			= "ePH.PHRepMednAdmnListBean";
	PHRepMednAdmnListBean bean	= (PHRepMednAdmnListBean)getBeanObject( bean_id, bean_name , request) ;
	String  med_adm_yn			= bean.getMednAdmnList();
    ArrayList nursingList       = bean.getMednNursingList(locale);
	ArrayList dateList          = bean.getMednDateList();
    String currentdate			= com.ehis.util.DateUtils.getCurrentDate("DMY",locale);
	if(med_adm_yn.equals("N"))
		out.println("<script>GoBack()</script>");
%>
	<BODY onMouseDown="CodeArrest()" onKeyDown="lockKey()" onload="">   <!-- ML-BRU-SCF-0498 [IN035593] Removed the onload focus  -->
		<form name="formPhRepAdministrationNotRecordedCriteria" id="formPhRepAdministrationNotRecordedCriteria" ACTION="../../eCommon/jsp/report_options.jsp" TARGET="messageFrame" >
			<table cellpadding="0" cellspacing="4" width="100%" align="center" border="0">
				<TH COLSPAN="6" ALIGN="left"><fmt:message key="Common.reportcritera.label" bundle="${common_labels}"/></TH>
				<tr>
					<!--<td align="right" class="label" width="18%"><fmt:message key="Common.nursingUnit.label" bundle="${common_labels}"/></td>
					<td align="left" >&nbsp;&nbsp;<SELECT name="P_NURSING_UNIT" id="P_NURSING_UNIT" >
					<OPTION VALUE=" "> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;---<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; </OPTION>
					<%	for (int i=0; i<nursingList.size(); i+=2) { %>
					<OPTION VALUE="<%= nursingList.get(i) %>"><%= nursingList.get(i+1) %></OPTION>

					<% 	} %>
					</SELECT><img src="../../eCommon/images/mandatory.gif" align="center"></td>--> <!-- commented below code for scf ML-BRU-SCF-0498 [IN:035593]  -->
					<td class="label"><fmt:message key="Common.locationtype.label" bundle="${common_labels}"/></td><!-- adding start for scf ML-BRU-SCF-0498 [IN:035593] -->
					<td>&nbsp;
					<select name="locn_type" id="locn_type" onChange="resetLocation()">
						<option value="">----<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>----</option>
						<option value="C"><fmt:message key="Common.clinic.label" bundle="${common_labels}"/></option>
						<option value="N"><fmt:message key="Common.nursingUnit.label" bundle="${common_labels}"/></option>
					</select>&nbsp;<img src="../../eCommon/images/mandatory.gif" align="center">
					</td>
					<td class="label"><fmt:message key="Common.Location.label" bundle="${common_labels}"/></td>
					<td><input type="text" name="locn_name" id="locn_name" maxlength="20" size="20"  disabled><input type="button" name="btnLocation" id="btnLocation" class="button" value="?" onfocus="locationLookup(locn_name)" onClick="locationLookup(locn_name)"><input type="hidden" name="locn_code" id="locn_code">&nbsp;<img src="../../eCommon/images/mandatory.gif" align="center"></td> <!-- adding end for scf ML-BRU-SCF-0498 [IN:035593] -->		
					<td colspan='4'>&nbsp;</td>
				</tr>
				<tr>
					<td align="right" class="label" ><fmt:message key="Common.DateFrom.label" bundle="${common_labels}"/></td> 
					<td class="label">&nbsp;<input type="text" name="P_DATE_FROM1" id="P_DATE_FROM1"  value="<%=currentdate%>"
					 onBlur='if(CheckDateT(this)) if(DateCheck(currentdate,P_DATE_FROM1)) validate_date(this,"TO_DATE_LESS_FROM");' maxlength="10" size="10" />
				   <IMG SRC="../../eCommon/images/CommonCalendar.gif" id=Calendar onclick="return showCalendar('P_DATE_FROM1');" >&nbsp;<img src="../../eCommon/images/mandatory.gif"  align="center"></td><td align="right" class="label" ><fmt:message key="Common.DateTo.label" bundle="${common_labels}"/>&nbsp;&nbsp;</td>
					<td><input type="text" name="P_DATE_TO1" id="P_DATE_TO1" value="<%=currentdate%>" onBlur='if(CheckDateT(this)) if(DateCheck(currentdate,P_DATE_TO1)) validate_date(this,"TO_DATE_LESS_FROM");' maxlength="10" size="10" >
					<IMG SRC="../../eCommon/images/CommonCalendar.gif" id=Calendar onclick="return showCalendar('P_DATE_TO1')"; >&nbsp;<img name='mandatory' src="../../eCommon/images/mandatory.gif">
					</td> </td> 
						<td class="label" colspan=2>&nbsp;</td>
				</tr>
				<tr>
					<td  align="right" class="label" ><fmt:message key="Common.patientId.label" bundle="${common_labels}"/>&nbsp;&nbsp;</td><td align="left">&nbsp;&nbsp;<input type="text" name="P_PATIENT_ID" id="P_PATIENT_ID" maxlength="<%=bean.getPatientIDLength()%>" size="20"  onKeyPress="changeToUpper()"  ><input type="button" class="button" value="?" name="pat_search" id="pat_search"
					  onfocus="callPatientSearch(document.formPhRepAdministrationNotRecordedCriteria.P_PATIENT_ID)" onClick="callPatientSearch(document.formPhRepAdministrationNotRecordedCriteria.P_PATIENT_ID)">&nbsp;</td>
					<!-- Added Label Tag for  ML-BRU-SCF-0498 [IN:035593]-->
					<td align="right" class="label"><label id='lbl_from_bed'><fmt:message key="ePH.FromBedNo.label" bundle="${ph_labels}"/>&nbsp;&nbsp;</label></td><td align ='left' ><input type="text" name="P_FROM_BED_NO" id="P_FROM_BED_NO" value="" size="8">&nbsp;&nbsp;&nbsp; </td><td align="right" class="label" ><label id='lbl_to_bed'><fmt:message key="ePH.ToBedNo.label" bundle="${ph_labels}"/>&nbsp;&nbsp;</label></td><td><input type="text" value="" name="P_TO_BED_NO" id="P_TO_BED_NO" size="8"></td>
				 </tr>
				 <tr valign="middle">
					<td align="right" class="label"><fmt:message key="ePH.AdministrationStatus.label" bundle="${ph_labels}"/></td>
					<td align="left">&nbsp;&nbsp;<select name="P_ADMIN_STATUS" id="P_ADMIN_STATUS">
					<option value="">---<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---</option>
                    <option value="E"><fmt:message key="Common.Elapsed.label" bundle="${common_labels}"/></option>
					<option value="O"><fmt:message key="Common.Overdue.label" bundle="${common_labels}"/></option>
					<option value="D"><fmt:message key="Common.Due.label" bundle="${common_labels}"/></option>
					<option value="F"><fmt:message key="Common.Future.label" bundle="${common_labels}"/></option>
					</select>
					</td>
					<td colspan='4'>&nbsp;</td>
				</tr>
			</table>
			<INPUT TYPE="hidden" name="p_ad_date" id="p_ad_date" VALUE="<%=dateList.get(2) %>">
			<INPUT TYPE="hidden" name="p_in_date" id="p_in_date" VALUE="<%=dateList.get(0) %>">
			<INPUT TYPE="hidden" name="p_en_date" id="p_en_date" VALUE="<%=dateList.get(1) %>">
			<INPUT TYPE="hidden" name="p_facility_id" id="p_facility_id" VALUE="<%= session.getValue( "facility_id" ) %>">
			<INPUT TYPE="hidden" name="p_user_name" id="p_user_name" VALUE="<%= session.getValue( "login_user" ) %>">
			<INPUT TYPE="hidden" name="p_module_id" id="p_module_id" VALUE="PH">
			<INPUT TYPE="hidden" name="p_report_id" id="p_report_id" VALUE="PHRADMINNOTREC">
			<INPUT TYPE="hidden" name="p_language_id" id="p_language_id" VALUE="<%=locale%>" >
			<INPUT TYPE="hidden" name="P_DATE_FROM" id="P_DATE_FROM" VALUE="">
			<INPUT TYPE="hidden" name="P_DATE_TO" id="P_DATE_TO" VALUE="">
			<INPUT TYPE="hidden" name="currentdate" id="currentdate" VALUE="<%=currentdate%>">
			<INPUT TYPE="hidden" name="language_id" id="language_id" VALUE="<%=locale%>"><!-- adding for scf ML-BRU-SCF-0498 [IN:035593] -Start -->
			<input type="hidden" name="SQL_PH_PRINT_PRESCRIPTIONS_SELECT1" id="SQL_PH_PRINT_PRESCRIPTIONS_SELECT1" value="<%=PhRepository.getPhKeyValue("SQL_PH_PRINT_PRESCRIPTIONS_SELECT1")%>">
			<input type="hidden" name="SQL_PH_PRINT_PRESCRIPTIONS_SELECT2" id="SQL_PH_PRINT_PRESCRIPTIONS_SELECT2" value="<%=PhRepository.getPhKeyValue("SQL_PH_PRINT_PRESCRIPTIONS_SELECT2")%>"><!-- adding for scf ML-BRU-SCF-0498 [IN:035593] End-->
		</form>
		<% putObjectInBean(bean_id,bean,request); %>
	</body>
</html>

