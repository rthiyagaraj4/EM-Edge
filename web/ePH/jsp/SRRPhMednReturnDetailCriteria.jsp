<!DOCTYPE html>
 
<%-- saved on 03/11/2005 --%>
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
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<script LANGUAGE="javascript" SRC="../../eCommon/js/CommonLookup.js"></SCRIPT>
	<script LANGUAGE="javascript" SRC="../../eCommon/js/dchk.js"></SCRIPT>
	<script LANGUAGE="javascript" src="../../eCommon/js/common.js"></script>
	<script language="javascript" src="../../ePH/js/DrugNameCommonLookup.js"></script> 
	<script LANGUAGE="javascript" src="../js/PhCommon.js"></script>
	<script language="javascript" src="../js/SRRPhMednReturnDetail.js"></script> 
	<script language="Javascript" src="../../eCommon/js/DateUtils.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


 </head>
<body onMouseDown="CodeArrest()" onKeyDown="lockKey()" topmargin="0">
<!-- <form name="formOrderDispDrugs" id="formOrderDispDrugs" action="../../eCommon/jsp/report_options.jsp" target="messageFrame"> -->
<form name="formPhMedicationReturnDetail" id="formPhMedicationReturnDetail" action="../../eCommon/jsp/report_options.jsp" target="messageFrame">

	<%	String p_facility_id		= (String) session.getValue( "facility_id" ) ;

		String	bean_id			=	"ADRReportBean" ;
		String	bean_name		=	"ePH.ADRReportBean";

   		ADRReportBean bean = (ADRReportBean)getBeanObject(bean_id,bean_name ,request) ;
		bean.setLanguageId(locale);

		String	bean_id1			=	"PHReportsBean" ;
		String	bean_name1		=	"ePH.PHReportsBean";

   		PHReportsBean bean1 = (PHReportsBean)getBeanObject(bean_id1,bean_name1 ,request) ;
		bean1.setLanguageId(locale);

		String bean_id2			= "SRRPHRepDispStatisByDispBean" ;
		String bean_name2		= "ePH.SRRPHRepDispStatisByDispBean";
	
	SRRPHRepDispStatisByDispBean bean2 = (SRRPHRepDispStatisByDispBean)getBeanObject( bean_id2,bean_name2,request ) ;
	bean2.setLanguageId(locale);
	//out.println("bean2..getsetLanguageId=========>" +bean2.getLanguageId());
	ArrayList dispLocationList = bean2.getDispLocnList(p_facility_id);
	ArrayList drugCategoryList = bean2.getDrugCategory();
	String sql_ph_drug_search_select2 =	PhRepository.getPhKeyValue("SQL_PH_DRUG_SEARCH_SELECT2");
	String sql_ph_nursing_unit_select	=	PhRepository.getPhKeyValue("SQL_PH_MEDN_ORD_STAT_SRC_NU_SELECT1");//Location type queries
	String sql_ph_clinic_select			=	PhRepository.getPhKeyValue("SQL_PH_MEDN_ORD_STAT_SRC_CL_SELECT1");
	String sql_ph_drug_search_select	=	"SELECT DRUG_CODE CODE, DRUG_DESC DESCRIPTION FROM PH_DRUG_LANG_VW PH_DRUG WHERE  UPPER(DRUG_CODE) LIKE UPPER(?) AND UPPER(DRUG_DESC) LIKE UPPER(?) AND DISCONTINUED_YN='N' AND LANGUAGE_ID =";
	String sql_ph_generic_search_select	=	"select generic_id code,generic_name description from ph_generic_name_lang_vw where eff_status ='E' and UPPER(generic_id) LIKE UPPER(?) AND UPPER(generic_name) LIKE UPPER(?) and language_id = ";




	
		
	%>

	<table cellpadding=0 cellspacing=0 width="100%"  align="center" border="0" >
	      <th colspan="8"><fmt:message key="Common.reportcritera.label" bundle="${common_labels}"/></th>
			<TR><TD colspan="8">&nbsp;</TD>

			<tr>			
						<td class="label"><fmt:message key="ePH.ReturnDateFrom.label" bundle="${ph_labels}"/></td>
						<td colspan="7" >&nbsp;&nbsp;<input type="text" name="p_from_dt1" id="p_from_dt1"  size="8"  value="" maxlength="10" onBlur="CheckDate(this);" ><IMG SRC="../../eCommon/images/CommonCalendar.gif" id='Calendar' onclick="return showCalendar('p_from_dt1');" >
						<img src="../../eCommon/images/mandatory.gif" align="center"></img>
						<INPUT TYPE="hidden" name="p_from_dt" id="p_from_dt" VALUE=" ">
						&nbsp;<label class="label"><fmt:message key="Common.to.label" bundle="${common_labels}"/></label>
						&nbsp;<input type="text" name="p_to_dt1" id="p_to_dt1"  size="8"  value="" maxlength="10" onBlur="CheckDate(this);"><IMG SRC="../../eCommon/images/CommonCalendar.gif" id='Calendar' onclick="return showCalendar('p_to_dt1');" >
								<img src="../../eCommon/images/mandatory.gif" align="center"></img>
								<INPUT TYPE="hidden" name="p_to_dt" id="p_to_dt" VALUE=" ">
						</td>
			</tr>
			<!-- Adding New List box Dispense Location -->
			<tr>
				<td class='label'><fmt:message key="ePH.DispenseLocation.label" bundle="${ph_labels}"/></td>
				<td colspan="7">&nbsp;&nbsp;<SELECT name="P_DISP_LOCN_CODE" id="P_DISP_LOCN_CODE" >
				 <option value ="">---------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> --------- </option>
	<%
				for (int i=0;i<dispLocationList.size();i+=2){
    %>
					<option value ="<%=dispLocationList.get(i).toString()%>"><%=dispLocationList.get(i+1).toString()%></option>
	<%}
	%>   
   </select></td>
  </tr>
  <!-- ADDing New List box and Lookup For Location Type -->
  <tr><td class='label'><fmt:message key="Common.locationtype.label" bundle="${ph_labels}"/></td>
					<td Colspan="6">&nbsp;&nbsp;<SELECT name="p_locn_type" id="p_locn_type" onChange ='clearLocation();'>						
						  <option value=""> ---------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> --------- </option>
						  <option VALUE="C" ><fmt:message key="Common.clinic.label" bundle="${common_labels}"/></option>
						   <option VALUE="N"  ><fmt:message key="Common.nursingUnit.label" bundle="${common_labels}"/></option>
						</select>
                    </td>					
					<td colspan="1" class="label">
						 <fmt:message key="ePH.Location.label" bundle="${ph_labels}"/> 
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						<input type="text" name="locn_text" id="locn_text" size="20" value="" > 
						<INPUT TYPE="button" name="locn_lookup_btn" id="locn_lookup_btn" VALUE="?" CLASS="button"  onClick="callLocationLookup(locn_text);" >
						<input type="hidden" name="p_locn_code" id="p_locn_code" value ="" /> 
                    </td> 					
					
			</tr>
			<tr>
						<td class='label' colspan="6"nowrap><fmt:message key="ePH.DRUG/MEDICALSUPPLY.label" bundle="${ph_labels}"/></td>
						&nbsp;<td><SELECT name="drug_med_supply" id="drug_med_supply"  onChange = "callCriteriaChange();">
						<option> ---------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> --------- </option>
						<option value ="Y"> <fmt:message key="Common.Drug.label" bundle="${common_labels}"/></option>
						<option value ="N"> <fmt:message key="ePH.MEDICALSUPPLY.label" bundle="${ph_labels}"/></option>
						<option value ="" selected> <fmt:message key="Common.all.label" bundle="${common_labels}"/></option>
						</select></td><td class='label'>
						<fmt:message key="ePH.ReturnedDrug.label" bundle="${ph_labels}"/>
						 &nbsp;&nbsp;&nbsp;&nbsp;<input type="text" name="drug_name" id="drug_name" maxlength="60" size="60" readonly ><input type="button" class="button" value="?" name="drug_search_btn" id="drug_search_btn" onfocus="searchDrugName();" onclick="searchDrugName();">
						<input type="hidden" name="drug_code" id="drug_code" value="">
						</td>	
			</tr>
			<tr >
						<td class="label"><fmt:message key="Common.patientId.label" bundle="${common_labels}"/></td>
						<td colspan="7">&nbsp;&nbsp;<input type="text"  name="P_PAT_ID1" id="P_PAT_ID1" size=20 value=""  onKeyPress="return CheckForSpecChars(event)" maxlength="<%=bean.getPatientIDLength()%>" ><input type="button" name="patient_search" id="patient_search" value="?" class="button"                     onClick="callPatientLookup();">
						<input type="hidden" name="P_PAT_ID" id="P_PAT_ID" value="">
						</td>	
			</tr>		
		
			<tr >
						<td class="label"><fmt:message key="ePH.ReasonforReturn.label" bundle="${ph_labels}"/></td>
				        <td colspan="8">&nbsp;&nbsp;<select name="P_REASON_CODE" id="P_REASON_CODE" >
				    	<option value="">&nbsp;&nbsp;--<fmt:message key="ePH.ReasonforReturn.label" bundle="${ph_labels}"/>--&nbsp;&nbsp;</option>
					    <% ArrayList Reason=bean1.getReturnReasoncodes();
						  	if (Reason.size() > 0 )
				            for (int i=0; i<Reason.size(); i+=2) {
	                    %>
			            <OPTION VALUE="<%= Reason.get(i) %>"><%= Reason.get(i+1) %></OPTION>

	                <% 	} %>  

				        </select>
		        		
			</tr>
	<TR><TD colspan="8">&nbsp;</TD>
	</table>
			<INPUT TYPE="hidden" name="p_facility_id" id="p_facility_id" VALUE="<%= session.getValue( "facility_id" ) %>">
	<INPUT TYPE="hidden" name="p_user_name" id="p_user_name" VALUE="<%= session.getValue( "login_user" ) %>">
	<!-- <INPUT TYPE="hidden" name="p_report_id" id="p_report_id" VALUE="PHPRMDRTSM"> -->
	<INPUT TYPE="hidden" name="p_report_id" id="p_report_id" VALUE="PHPRMDRTSM">
	<INPUT TYPE="hidden" name="p_module_id" id="p_module_id" VALUE="PH">
	<INPUT TYPE="hidden" name="p_language_id" id="p_language_id" VALUE="<%=locale%>">
	<INPUT TYPE="hidden" name="bean_id2" id="bean_id2" VALUE="<%= bean_id2 %>">
	<INPUT TYPE="hidden" name="bean_name2" id="bean_name2" VALUE="<%= bean_name2 %>">
	
	
	<input type="hidden" name="P_DRUG_NONDRUG" id="P_DRUG_NONDRUG" value="">
	<input type="hidden" name="P_RET_DRUG" id="P_RET_DRUG" value="">
	<INPUT TYPE="hidden" name="p_reprint" id="p_reprint" VALUE="Y">

</form>
		<!-- <input type="hidden" name="sql_ph_drug_search_select2" id="sql_ph_drug_search_select2" value="<%=sql_ph_drug_search_select2%>"> -->
		<input type="hidden" name="sql_ph_drug_search_select" id="sql_ph_drug_search_select" value="<%=sql_ph_drug_search_select%>">
		<input type="hidden" name="SQL_PH_PRINT_PRESCRIPTIONS_SELECT1" id="SQL_PH_PRINT_PRESCRIPTIONS_SELECT1" value="<%=PhRepository.getPhKeyValue("SQL_PH_PRINT_PRESCRIPTIONS_SELECT1")%>">
		<input type="hidden" name="SQL_PH_PRINT_PRESCRIPTIONS_SELECT2" id="SQL_PH_PRINT_PRESCRIPTIONS_SELECT2" value="<%=PhRepository.getPhKeyValue("SQL_PH_PRINT_PRESCRIPTIONS_SELECT2")%>">
		<input type="hidden" name="sql_ph_nursing_unit_select" id="sql_ph_nursing_unit_select" value="<%=sql_ph_nursing_unit_select%>">
	<input type="hidden" name="sql_ph_clinic_select" id="sql_ph_clinic_select" value="<%=sql_ph_clinic_select%>">

</html>
<%  
    putObjectInBean(bean_id,bean,request);
    putObjectInBean(bean_id1,bean1,request);
    putObjectInBean(bean_id2,bean2,request);
%>

