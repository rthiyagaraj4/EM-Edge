<!DOCTYPE html>
<%-- saved on 30/12/2009 --%>

<%-- JSP Page specific attributes start --%>
<%@page contentType="text/html;charset=UTF-8" import="ePH.*, ePH.Common.*" %>
<%-- JSP Page specific attributes end --%>
<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%-- Mandatory declarations end --%>
<html>
<head>
<%
	request.setCharacterEncoding("UTF-8");
	String locale			= (String)session.getAttribute("LOCALE");
	String facility_id			= (String)session.getValue( "facility_id" );
	
	String sStyle=(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>

	<link rel="stylesheet" type ="text/css" href="../../eCommon/html/CommonCalendar.css"></link>
	<!-- import the calendar script -->
	<script language="javascript" src="../../eCommon/js/CommonCalendar.js"></script>
	<script language="JavaScript" src="../../eCommon/js/FieldFormatMethods.js"></script>
	<script language="JavaScript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="Javascript" src="../../eCommon/js/CommonLookup.js"></SCRIPT>
	<script language="javascript" src="../../eCommon/js/common.js"></script>
	<script language="javascript" SRC="../../eCommon/js/dchk.js"></script>

	<script language="javascript" src="../js/PhCommon.js"></script>
	 <script language="javascript" src="../js/SRRDispDrugsDtl.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
  
	</head>
	<body onMouseDown="CodeArrest()" onKeyDown="lockKey()" topmargin="0">
	<FORM name="formDispDrugsDtl" id="formDispDrugsDtl" ACTION="../../eCommon/jsp/report_options.jsp" TARGET="messageFrame">
	<%
	String bean_id			= "SRRPHRepDispStatisByDispBean";
	String bean_name		= "ePH.SRRPHRepDispStatisByDispBean";

	ArrayList dispLocnList=new ArrayList();

	String sql_ph_drug_search_select2 =	PhRepository.getPhKeyValue("SQL_PH_DRUG_SEARCH_SELECT2");

	SRRPHRepDispStatisByDispBean bean = (SRRPHRepDispStatisByDispBean)getBeanObject( bean_id, bean_name,request) ;
	bean.setLanguageId(locale);

	
	dispLocnList = bean.getDispLocnList(facility_id);
	if(dispLocnList == null)
				dispLocnList = new ArrayList();

	ArrayList drugCategory = bean.getDrugCategory();
	%>

<TABLE cellpadding=0 cellspacing=0 width="80%"  align="center" border="0" >
<TR><TD colspan="8">&nbsp;</TD>
<TR>			
		<TD CLASS="label"> <fmt:message key="Common.DateFrom.label" bundle="${common_labels}"/></TD>
		<TD>&nbsp;&nbsp;<input type="text" name="p_from_date1" id="p_from_date1"  size="8"  value="" maxlength="10" onBlur="CheckDate(this);validateDate()"><IMG SRC="../../eCommon/images/CommonCalendar.gif"  id="Calendar" onclick="return showCalendar('p_from_date1');"><img src="../../eCommon/images/mandatory.gif" align="center"></img>
		</TD>
		<input type = "hidden" name = "p_from_date" value = "">
		<TD class="label"><fmt:message key="Common.to.label" bundle="${common_labels}"/></TD>
		<TD>&nbsp;&nbsp;<input type="text" name="p_to_date1" id="p_to_date1"  size="8"  value="" maxlength="10" onBlur="CheckDate(this);validateDate()"><IMG SRC="../../eCommon/images/CommonCalendar.gif" id="Calendar" onclick="return showCalendar('p_to_date1');"> 
		<img src="../../eCommon/images/mandatory.gif" align="center"></img>
		</TD>
		<input type = "hidden" name = "p_to_date" value = "">
</TR>
<tr><td>&nbsp;</td></tr>
<TR >
		<TD CLASS="label"><fmt:message key="ePH.DispenseLocation.label" bundle="${ph_labels}"/></TD>
				<TD>&nbsp;&nbsp;<select name='p_disp_locn' id='p_disp_locn'>
						<option value="ALL">--- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> ---</option>
<%
							for(int i=0; i<dispLocnList.size();i+=2){
%>
								<option value = <%= dispLocnList.get(i)%>><%= dispLocnList.get(i+1)%></option>
<%
							}
%>
					</select>
				</TD>
		<TD colspan="4"></TD>
</TR>
<tr>
						<td class="label"><fmt:message key="Common.locationtype.label" bundle="${common_labels}"/></td>
						<td>&nbsp;&nbsp;<select name="p_locn_type" id="p_locn_type" onchange='clear1(this)'>
								<option value=""> ---<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> ---&nbsp;&nbsp;</option>
								<option value="C"><fmt:message key="Common.clinic.label" bundle="${common_labels}"/></option>
								<option value="N"><fmt:message key="Common.nursingUnit.label" bundle="${common_labels}"/></option>
								</select>
						</td>
						<td class="label"><fmt:message key="ePH.LocationForm.label" bundle="${ph_labels}"/></td>
						<td>&nbsp;&nbsp;<input type="text" name="p_locn_name" id="p_locn_name" maxlength="20" size="20"  onBlur="locationLookup(this,'yes')" ><input type="button" name="btnLocation" id="btnLocation" class="button" value="?" onfocus="locationLookup(p_locn_name)" onClick="locationLookup(p_locn_name)">
						<input type="hidden" name="p_locn_code" id="p_locn_code">
					</td>		
</tr>

<tr><td>&nbsp;</td></tr>

<tr>
	<td class="label"><fmt:message key="ePH.TypeOfDrug.label" bundle="${ph_labels}"/></td>
						<td>&nbsp;&nbsp;<select name="p_drug_type" id="p_drug_type" onchange=''>
								<option value=""> ---<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> ---&nbsp;&nbsp;</option>
								<option value="IC"><fmt:message key="ePH.InfectionControl.label" bundle="${ph_labels}"/></option>
								<option value="V"><fmt:message key="Common.Vaccine.label" bundle="${common_labels}"/></option>
								<option value="PS"><fmt:message key="ePH.Poisonous/Scheduled.label" bundle="${ph_labels}"/></option>
								</select>
						</td>
</tr>

<tr>
					<td width="15%" class="label"><fmt:message key="ePH.DrugClass.label" bundle="${ph_labels}"/></td>
					<td width="30%">&nbsp;
						<select name="p_drug_class" id="p_drug_class">
							<option value=""> --<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>-- </option>
							<option value="G"><fmt:message key="Common.general.label" bundle="${common_labels}"/></option>
							<option value="N"><fmt:message key="ePH.Narcotics.label" bundle="${ph_labels}"/></option>
							<option value="C"><fmt:message key="ePH.Controlled.label" bundle="${ph_labels}"/></option>
						</select>
					</td>
					<td  class="label"><fmt:message key="ePH.DrugCategory.label" bundle="${ph_labels}"/></td>
					<td  colspan="2" >&nbsp;
							<select name="p_drug_catg_code" id="p_drug_catg_code" >
								<option value="">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;-- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> --&nbsp;&nbsp;&nbsp;&nbsp;</option>
<%
									if (drugCategory.size() != 0) {
										for (int datacnt = 0; datacnt < drugCategory.size(); datacnt++) {
%>
											<option value="<%= drugCategory.get(datacnt++) %>"><%= drugCategory.get(datacnt) %></OPTION>
<%
											}
										}
%>
							</select>
					</td>
</tr>

<tr><td>&nbsp;</td></tr>

<TR >
				<TD class="label" colspan="1"><fmt:message key="Common.DrugName.label" bundle="${common_labels}"/></TD>
				<TD colspan="3">&nbsp;&nbsp;<input type="text" name="p_drug_name" id="p_drug_name" maxlength="60" size="60"  ><input type="button" class="button" value="?" name="drug_name_search" id="drug_name_search" onfocus="searchDrugName();" onclick="searchDrugName();">
				<input type="hidden" name="drug_code" id="drug_code" value="">
			</TD>	
</TR>

<tr><td>&nbsp;</td></tr>

<tr>
			<td class="label"><fmt:message key="Common.patientId.label" bundle="${common_labels}"/></td>
			<td>&nbsp;&nbsp;<input type="text" name="p_patient_id" id="p_patient_id" maxlength="<%=bean.getPatientIDLength()%>" size="20"  onKeyPress="changeToUpper()" ><input type="button" class="button" value="?" name="pat_search" id="pat_search" onfocus="callPatientSearch(document.formDispDrugsDtl.p_patient_id)" onClick="callPatientSearch(document.formDispDrugsDtl.p_patient_id)"></td>
</tr>
<tr><td>&nbsp;</td></tr>
<TR>
		<TD CLASS="label"><fmt:message key="Common.orderBy.label" bundle="${common_labels}"/></TD>
		<TD COLSPAN="3">&nbsp;&nbsp;<select name="p_order_by" id="p_order_by" onChange="initialize_clase(this);"> 
		<option value="">&nbsp;&nbsp;&nbsp;&nbsp;--- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> ---&nbsp;&nbsp;&nbsp;&nbsp;</option>
		<option value="D"><fmt:message key="Common.Drug.label" bundle="${common_labels}"/></option>
		<option value="L"><fmt:message key="Common.OrderingLocation.label" bundle="${common_labels}"/></option>
		</select>
		</TD>
</TR>
<TR><TD colspan="8">&nbsp;</TD>
</TABLE>
		<INPUT TYPE="hidden" name="p_facility_id" id="p_facility_id" VALUE="<%= session.getValue( "facility_id" ) %>">
		<INPUT TYPE="hidden" name="p_user_name" id="p_user_name" VALUE="<%= session.getValue( "login_user" ) %>">
		<INPUT TYPE="hidden" name="p_module_id" id="p_module_id" VALUE="PH">
		<INPUT TYPE="hidden" name="p_report_id" id="p_report_id" VALUE="PHDISPDRGDTL">
		<INPUT TYPE="hidden" name="CLAUSE" id="CLAUSE" VALUE=""> 
		<INPUT TYPE="hidden" name="language_id" id="language_id" VALUE="<%=locale%>"> 
		<INPUT TYPE="hidden" name="p_language_id" id="p_language_id" VALUE="<%=locale%>">
		<INPUT TYPE="hidden" name="P_REPRINT" id="P_REPRINT" VALUE="Y">
</form>

<input type="hidden" name="sql_ph_drug_search_select2" id="sql_ph_drug_search_select2" value="<%=sql_ph_drug_search_select2%>">
		<input type="hidden" name="SQL_PH_PRINT_PRESCRIPTIONS_SELECT1" id="SQL_PH_PRINT_PRESCRIPTIONS_SELECT1" value="<%=PhRepository.getPhKeyValue("SQL_PH_PRINT_PRESCRIPTIONS_SELECT1")%>">
		<input type="hidden" name="SQL_PH_PRINT_PRESCRIPTIONS_SELECT2" id="SQL_PH_PRINT_PRESCRIPTIONS_SELECT2" value="<%=PhRepository.getPhKeyValue("SQL_PH_PRINT_PRESCRIPTIONS_SELECT2")%>">

</html>
<%
putObjectInBean(bean_id,bean,request);
%>

