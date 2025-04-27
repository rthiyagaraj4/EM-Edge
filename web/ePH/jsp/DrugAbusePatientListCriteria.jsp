<!DOCTYPE html>
<%-- saved on 03/11/2005 --%>
<%-- JSP Page specific attributes start --%>
<%@page contentType="text/html;charset=UTF-8" import="java.util.*, ePH.*, ePH.Common.*, eCommon.Common.*,eCommon.XSSRequestWrapper" %>
<%-- JSP Page specific attributes end --%>  

<%-- Mandatory declarations start --%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%-- Mandatory declarations end --%>

<HTML>
<HEAD>
	<%
	request.setCharacterEncoding("UTF-8");
//added By Himanshu Start.
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
//end.
	String locale			= (String)session.getAttribute("LOCALE");
	String sStyle =
	(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	String current_date			= com.ehis.util.DateUtils.getCurrentDate("DMY",locale); //code added for ADR Admin Date Time is not validating[32828] 
	String bean_id				= "PHReportsBean" ;  //resuse existing bean for patient id validation only
	String bean_name			= "ePH.PHReportsBean";
	PHReportsBean bean	= (PHReportsBean)getBeanObject( bean_id, bean_name , request) ;
	bean.setLanguageId(locale);
 
	String	weekRangeSysdate		=  bean.checkForNull(bean.getWeekRangeSysdate(),""); // Get the FROM AND TO DATE // AAKH-CRF-0140
	StringTokenizer weekDate = new StringTokenizer(weekRangeSysdate, ":");
	String fromDate	=	weekDate.nextToken();// AAKH-CRF-0140
	String toDate	=	weekDate.nextToken();// AAKH-CRF-0140

%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
	<SCRIPT LANGUAGE="javascript" SRC="../../eCommon/js/common.js"></SCRIPT>
	<script language="javascript" src="../../eCommon/js/CommonCalendar.js"></script>
	<SCRIPT LANGUAGE="javascript" SRC="../../eCommon/js/ValidateControl.js"></SCRIPT>
	<SCRIPT LANGUAGE="javascript" SRC="../../eCommon/js/DateUtils.js"></SCRIPT>
	<SCRIPT LANGUAGE="javascript" SRC="../../eCommon/js/CommonLookup.js"></SCRIPT>
	<SCRIPT LANGUAGE="javascript" SRC="../../ePH/js/DrugNameCommonLookup.js"></SCRIPT>
	<SCRIPT LANGUAGE="javascript" SRC="../../ePH/js/DrugAbusePatientList.js"></SCRIPT>
	<!--<SCRIPT LANGUAGE="javascript" SRC="../../ePH/js/PhMessages.js"></SCRIPT>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
-->
</HEAD>

<BODY onload="document.formDrugAbusePatientList.drug_abuse_reported_from_date.focus();" onMouseDown="" onKeyDown="lockKey()">
<BR>
<FORM name="formDrugAbusePatientList" id="formDrugAbusePatientList" ACTION="../../eCommon/jsp/report_options.jsp" TARGET="messageFrame">
	<TABLE WIDTH="70%" ALIGN="center" CELLPADDING="0" CELLSPACING="0" BORDER="0">
		<TH COLSPAN="4" ALIGN="left"><fmt:message key="Common.reportcritera.label" bundle="${common_labels}"/></TH>
		<TR>
			<td class="label" width="20%" nowrap><fmt:message key="Common.patientId.label" bundle="${common_labels}"/></td>
			<td width="20%"><input type="text" name="p_patient_id_val" id="p_patient_id_val" size="20" value="" maxlength=""   <%=bean.getPatientIDLength()%>> 
					
					<input type="button" value="?" class="button" name="btnPatientID" id="btnPatientID" onClick="callPatientSearch()"  >
			</td>
			<td>&nbsp;</td>
			<td>&nbsp;</td>
		</tr>
		<TR>
			<TD COLSPAN="4">&nbsp;</TD>
		</TR>
		<TR>
			<TD WIDTH="20%">&nbsp;</TD>
			<TD CLASS="FIELDS" ALIGN="left" WIDTH="20%"><b><fmt:message key="Common.from.label" bundle="${common_labels}"/><b></TD>
			<TD WIDTH="10%">&nbsp;</TD>
			<TD CLASS="FIELDS" ALIGN="left" WIDTH="50%" colspan='2'><b><fmt:message key="Common.to.label" bundle="${common_labels}"/></b></TD>
		</TR>
 		<TR>
			<TD COLSPAN="4">&nbsp;</TD>  
		</TR>

		<TR> 
			<td class="label" width="20%" nowrap><fmt:message key="Common.date.label" bundle="${common_labels}"/>&nbsp;</td>
			<td class="field" width="20%"><input type='text'  name='drug_abuse_reported_from_date' id='drug_abuse_reported_from_date' size='8' value="<%=fromDate%>" maxlength="10"  onblur='return CheckValidDate(this,"DMY","<%=locale%>");'>&nbsp;<img  SRC="../../eCommon/images/CommonCalendar.gif"  id="drugabusereportedfromdate" onclick="return showCalendar('drug_abuse_reported_from_date');">&nbsp;<img align='center' src ='../../eCommon/images/mandatory.gif'></img>  
			</td>
			<td>&nbsp;</td>
			<td class="field" width="30%"><input type='text'  name='drug_abuse_reported_to_date1' id='drug_abuse_reported_to_date1' size='8' value="<%=toDate%>" maxlength="10" onblur='return checkingDate(this,"DMY","<%=locale%>");'>&nbsp;<img  SRC="../../eCommon/images/CommonCalendar.gif"  id="drugabusereportedtodate1" onclick="return showCalendar('drug_abuse_reported_to_date1');">&nbsp;<img align='center' src ='../../eCommon/images/mandatory.gif'></img>  
			</td>	
			
		 </tr> 

		<TR>
			<TD COLSPAN="4">&nbsp;</TD>
		</TR>
		
		<TR>
			<td class="label" width="20%">&nbsp;<fmt:message key="ePH.RestrictionType.label" bundle="${ph_labels}"/></td>
			<td width="20%" >
				<select name="p_restriction_type" id="p_restriction_type" onChange="restrictionType(this);">
					<option value="DC" selected><fmt:message key="ePH.DrugClass.label" bundle="${ph_labels}"/></option>
					<option value="DN"><fmt:message key="Common.DrugName.label" bundle="${common_labels}"/></option>
				</select>
			</td>
			<td class="label" id='drug_class' style="display:inline" ALIGN="right"><fmt:message key="ePH.DrugClass.label" bundle="${ph_labels}"/>
			</td> 
			<td ALIGN="left" ><select name="p_drug_class" id="p_drug_class"  style='display:inline'>
					<option value="">--<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>--</option>
					<option value="G"><fmt:message key="Common.general.label" bundle="${common_labels}"/></option>
					<option value="N"><fmt:message key="ePH.Narcotics.label" bundle="${ph_labels}"/></option>
					<option value="C"><fmt:message key="ePH.Controlled.label" bundle="${ph_labels}"/></option>
				</select></td>
		
		<!-- 	<input type='text'  name='drug_name' id='drug_name' size="40" maxlength="60"  onKeyPress="return CheckForSpecChars(event)" id='drug_name_id' style="visibility:hidden">
			<input valign='top' type='button' name='drug_search' id='drug_search' id='drug_search_id' value='?' class='button' onFocus="callDrugSearch(document.formDrugAbusePatientList.drug_name, 2)" onClick="callDrugSearch(document.formDrugAbusePatientList.drug_name, 2)"  style="visibility:hidden"></td>
		
	 -->
	
	 </TR>
		
		<TR>
		<TD COLSPAN="2">&nbsp;</TD>
		 <td class="label" name='drug_name_label'   id='drug_name_label' style="visibility:hidden" >	<fmt:message key="Common.DrugName.label" bundle="${common_labels}"/>
			</td>
			<td>
		 <input type="text" name="drug_name" id="drug_name" maxlength="60" size="40"  value="" onBlur="searchDrug(document.formDrugAbusePatientList.drug_name)"  style="visibility:hidden">
					<input type="button" class="button"	value="?"  name='drug_search' id='drug_search' 	onClick="searchDrug(document.formDrugAbusePatientList.drug_search)"  style="visibility:hidden">
					
					 <input type="hidden" name="drug_code" id="drug_code" value=""></td>
			
		</TR>


	</TABLE>

	<INPUT TYPE="hidden" name="p_facility_id" id="p_facility_id" VALUE="<%=session.getValue( "facility_id" )%>">
	<INPUT TYPE="hidden" name="p_user_name" id="p_user_name" VALUE="<%=session.getValue( "login_user" )%>">
	<INPUT TYPE="hidden" name="p_module_id" id="p_module_id" VALUE="PH">
	<INPUT TYPE="hidden" name="p_report_id" id="p_report_id" VALUE="PHDRUGAPL">
	<INPUT TYPE="hidden" name="locale" id="locale" VALUE="<%=locale%>">
	<INPUT TYPE="hidden" name="p_language_id" id="p_language_id" VALUE="<%=locale%>">
	<input type="hidden" name="current_date" id="current_date"	value="<%=current_date%>">
	<input type="hidden" name="p_drug_abuse_fm_date" id="p_drug_abuse_fm_date"	value="">
	<input type="hidden" name="p_drug_abuse_to_date" id="p_drug_abuse_to_date"	value="">
	<input type="hidden" name="p_drug_code" id="p_drug_code" value="">
	<input type="hidden" name="p_patient_id" id="p_patient_id" value="">
	


	
	
</FORM>

 
</BODY>
</HTML>

