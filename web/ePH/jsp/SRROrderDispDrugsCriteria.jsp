<!DOCTYPE html>
 <%-- saved on 29/12/2009 --%>

<%-- JSP Page specific attributes start --%>
<%@page contentType="text/html;charset=UTF-8" import="java.util.*, ePH.*, ePH.Common.*, eCommon.Common.*" %>
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
	<!-- <script language="javascript" SRC="../../eCommon/js/dchk.js"></script> 
	<script language="javascript" src="../../eCommon/js/messages.js"></script>-->

	<script language="javascript" src="../js/PhCommon.js"></script>
	 <script language="javascript" src="../js/SRROrdVsDispDrugs.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
  
	</head>
	<body onMouseDown="CodeArrest()" onKeyDown="lockKey()" topmargin="0">
	<FORM name="formSRROrderDispDrugs" id="formSRROrderDispDrugs" ACTION="../../eCommon/jsp/report_options.jsp" TARGET="messageFrame">

	<%
		String sql_ph_drug_search_select2 =	PhRepository.getPhKeyValue("SQL_PH_DRUG_SEARCH_SELECT2");

		String bean_id				= "SRRPHRepDispStatisByDispBean" ;
		String bean_name			= "ePH.SRRPHRepDispStatisByDispBean";
		SRRPHRepDispStatisByDispBean bean	= (SRRPHRepDispStatisByDispBean)getBeanObject( bean_id, bean_name,request ) ;
		bean.setLanguageId(locale);
			String myLoginFacilityId = (String)session.getValue("facility_id");
			ArrayList dispLocnList = bean.getDispLocnList(myLoginFacilityId);
			if(dispLocnList == null)
				dispLocnList = new ArrayList();
			ArrayList drugCategory = bean.getDrugCategory();
	%>

	<table cellpadding=0 cellspacing=0 width="90%"  align="center" border="0" >
			<TR><TD colspan="8">&nbsp;</TD>
			<tr>
						<td class="label"><fmt:message key="ePH.OrderPriority.label" bundle="${ph_labels}"/></td>
						<td >&nbsp;&nbsp;<select name="p_order_type" id="p_order_type">
								<option value="R" SELECTED><fmt:message key="Common.routine.label" bundle="${common_labels}"/></option>
								<option value="U"><fmt:message key="Common.urgent.label" bundle="${common_labels}"/></option>
						  </select>
						</td>

						<td class="label"><fmt:message key="Common.patientclass.label" bundle="${common_labels}"/></td>
						<td colspan="3">&nbsp;&nbsp;<select name="p_patient_class" id="p_patient_class">
								<option value="">--<fmt:message key="Common.Select.label" bundle="${common_labels}"/>--</option>
								<option value="IP" ><fmt:message key="Common.inpatient.label" bundle="${common_labels}"/></option>
								<option value="DC"><fmt:message key="Common.daycare.label" bundle="${common_labels}"/></option>
								<option value="OP"><fmt:message key="Common.Outpatient.label" bundle="${common_labels}"/></option>
								<option value="EM"><fmt:message key="Common.emergency.label" bundle="${common_labels}"/></option>
						  </select>
						</td>
			</tr>

			<tr><td>&nbsp;</td></tr>

			<tr>			
						<td class="label"><fmt:message key="Common.OrderDateFrom.label" bundle="${common_labels}"/></td>
						<td>&nbsp;&nbsp;<input type="text" name="p_from_dt1" id="p_from_dt1"  size="8"  value="" maxlength="10" onBlur="CheckDate(this);" ><IMG SRC="../../eCommon/images/CommonCalendar.gif" id=Calendar onclick="return showCalendar('p_from_dt1');" >
								<img src="../../eCommon/images/mandatory.gif" align="center"></img>
								<INPUT TYPE="hidden" name="p_from_dt" id="p_from_dt" VALUE=" ">
						</td>
						<td class="label"><fmt:message key="Common.to.label" bundle="${common_labels}"/></td>
						<td colspan="3">&nbsp;&nbsp;<input type="text" name="p_to_dt1" id="p_to_dt1"  size="8"  value="" maxlength="10" onBlur="CheckDate(this);"><IMG SRC="../../eCommon/images/CommonCalendar.gif" id=Calendar onclick="return showCalendar('p_to_dt1');" >
								<img src="../../eCommon/images/mandatory.gif" align="center"></img>
								<INPUT TYPE="hidden" name="p_to_dt" id="p_to_dt" VALUE=" ">
						</td>
			</tr>

			<tr><td>&nbsp;</td></tr>

			<TR>
				<TD CLASS="label"><fmt:message key="ePH.DispenseLocation.label" bundle="${ph_labels}"/></TD>
				<TD>&nbsp;&nbsp;<select name='p_disp_locn' id='p_disp_locn'>
						<option value=''>--- <fmt:message key="Common.all.label" bundle="${common_labels}"/> ---</option>
<%
							for(int i=0; i<dispLocnList.size();i+=2){
%>
								<option value = <%= dispLocnList.get(i)%>><%= dispLocnList.get(i+1)%></option>
<%
							}
%>
					</select>
				</TD>
			</TR>

			<tr>
						<td class="label"><fmt:message key="Common.locationtype.label" bundle="${common_labels}"/></td>
						<td>&nbsp;&nbsp;<select name="p_locn_type" id="p_locn_type" onchange='clear1(this)'>
								<option value=""> ---<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> ---&nbsp;&nbsp;</option>
								<option value="C"><fmt:message key="Common.clinic.label" bundle="${common_labels}"/></option>
								<option value="N"><fmt:message key="Common.nursingUnit.label" bundle="${common_labels}"/></option>
								</select>
						</td>
						<td class="label"><fmt:message key="Common.Location.label" bundle="${common_labels}"/></td>
						<td>&nbsp;&nbsp;<input type="text" name="p_locn_name" id="p_locn_name" maxlength="20" size="20"   ><input type="button" name="btnLocation" id="btnLocation" class="button" value="?" onfocus="locationLookup(p_locn_name)" onClick="locationLookup(p_locn_name)">
						<input type="hidden" name="p_locn_code" id="p_locn_code" value="">
					</td>		
			</tr>

			<tr><td>&nbsp;</td></tr>

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
							<select name="p_drug_category" id="p_drug_category" >
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

			<tr>
						<td class="label"><fmt:message key="Common.DrugName.label" bundle="${common_labels}"/></td>
						<td colspan="8">&nbsp;&nbsp;<input type="text" name="p_drug_name" id="p_drug_name" maxlength="60" size="67" onblur="searchDrugName('T');"><input type="button" class="button" value="?" name="p_drug_name_search" id="p_drug_name_search" onfocus="searchDrugName('L');" onclick="searchDrugName('L');"> 
							<input type="hidden" name="p_drug_code" id="p_drug_code" value="">  
						</td>	
			</tr>

			<tr><td>&nbsp;</td></tr>

			<tr>
				<td width="15%" class="label"><fmt:message key="ePH.SelectedBy.label" bundle="${ph_labels}"/></td>
					<td width="30%">&nbsp;
						<select name="p_select_by" id="p_select_by">
							<option value=""> --<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>-- </option>
							<option value="Q"><fmt:message key="ePH.DifferentQuantity.label" bundle="${ph_labels}"/></option>
							<option value="D"><fmt:message key="ePH.DifferentDrugName.label" bundle="${ph_labels}"/></option>
						</select>
					</td>
			</tr>
	<TR><TD colspan="8">&nbsp;</TD>
	</table>
	<INPUT TYPE="hidden" name="p_facility_id" id="p_facility_id" VALUE="<%= session.getValue( "facility_id" ) %>">
	<INPUT TYPE="hidden" name="p_user_name" id="p_user_name" VALUE="<%= session.getValue( "login_user" ) %>">
	<INPUT TYPE="hidden" name="p_report_id" id="p_report_id" VALUE="PHORDDISPDRUG">
	<INPUT TYPE="hidden" name="p_module_id" id="p_module_id" VALUE="PH">
	<INPUT TYPE="hidden" name="language_id" id="language_id" VALUE="<%=locale%>">
	<INPUT TYPE="hidden" name="p_language_id" id="p_language_id" VALUE="<%=locale%>">
	<INPUT TYPE="hidden" name="P_REPRINT" id="P_REPRINT" VALUE="Y">
		
</form>
	<input type="hidden" name="sql_ph_drug_search_select2" id="sql_ph_drug_search_select2" value="<%=sql_ph_drug_search_select2%>">
	<input type="hidden" name="SQL_PH_PRINT_PRESCRIPTIONS_SELECT1" id="SQL_PH_PRINT_PRESCRIPTIONS_SELECT1" value="<%=PhRepository.getPhKeyValue("SQL_PH_PRINT_PRESCRIPTIONS_SELECT1")%>">
	<input type="hidden" name="SQL_PH_PRINT_PRESCRIPTIONS_SELECT2" id="SQL_PH_PRINT_PRESCRIPTIONS_SELECT2" value="<%=PhRepository.getPhKeyValue("SQL_PH_PRINT_PRESCRIPTIONS_SELECT2")%>">
<% putObjectInBean(bean_id,bean,request); %>
</BODY>
</html>

