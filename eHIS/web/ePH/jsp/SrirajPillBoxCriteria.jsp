<!DOCTYPE html>
 
<%-- saved on 03/11/2005 --%>
<%-- JSP Page specific attributes start --%>
<%@page contentType="text/html;charset=UTF-8" import="java.util.*, ePH.*, ePH.Common.*, eCommon.Common.*,java.text.*" %>
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
	<script LANGUAGE="javascript" src="../../eCommon/js/common.js"></script>
	<script language="javascript" src="../../eCommon/js/CommonCalendar.js"></script>
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<script LANGUAGE="javascript" SRC="../../eCommon/js/CommonLookup.js"></SCRIPT>
	<script LANGUAGE="javascript" SRC="../../eCommon/js/dchk.js"></SCRIPT>
	<script language="Javascript" src="../../eCommon/js/DateUtils.js"></script>
	<script language="JavaScript" src="../../eCommon/js/FieldFormatMethods.js"></script>
	<SCRIPT LANGUAGE="javascript" SRC="../../eCommon/js/dchk.js"></SCRIPT>
	<script language="javascript" src="../../ePH/js/DrugNameCommonLookup.js"></script> 
	<script language="javascript" src="../js/SrirajPillBox.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
 
	
	
		

 </head>
<body onMouseDown="CodeArrest()" onKeyDown="lockKey()" topmargin="0">
<form name="formSirirajPillBoxCriteria" id="formSirirajPillBoxCriteria" action="../../eCommon/jsp/report_options.jsp" target="messageFrame">

	<%
		String	bean_id			=	"ADRReportBean" ;
		String	bean_name		=	"ePH.ADRReportBean";

   		ADRReportBean bean = (ADRReportBean)getBeanObject(bean_id,bean_name ,request) ;
		bean.setLanguageId(locale);

		String	bean_id1			=	"PHReportsBean" ;
		String	bean_name1		=	"ePH.PHReportsBean";

   		PHReportsBean bean1 = (PHReportsBean)getBeanObject(bean_id1,bean_name1 ,request) ;
		bean1.setLanguageId(locale);
		String bean_id2			= "SRRPHDrugUsageByPractBean" ;
		String bean_name2		= "ePH.SRRPHDrugUsageByPractBean";
		SRRPHDrugUsageByPractBean bean2 = (SRRPHDrugUsageByPractBean)getBeanObject( bean_id2,bean_name2,request ) ;
		bean2.setLanguageId(locale);
		ArrayList IVlegends = (ArrayList)bean2.getIVLegends();

		String sql_ph_drug_search_select	=	"SELECT DRUG_CODE CODE, DRUG_DESC DESCRIPTION FROM PH_DRUG_LANG_VW PH_DRUG WHERE  UPPER(DRUG_CODE) LIKE UPPER(?) AND UPPER(DRUG_DESC) LIKE UPPER(?) AND DISCONTINUED_YN='N' AND LANGUAGE_ID =";
		String ivlegend_option  = "";
		
			for(int i=0;i<=IVlegends.size()-2;i=i+2){
				if (i==0)
					ivlegend_option		=ivlegend_option +	"<option value='1'>"+((String) IVlegends.get(i+1))+"</option>"; 
				else if (i==2)
					ivlegend_option		=ivlegend_option +	"<option value='2'>"+((String) IVlegends.get(i+1))+"</option>";
				else if (i==4)
					ivlegend_option		=ivlegend_option +	"<option value='3'>"+((String) IVlegends.get(i+1))+"</option>";
				else if (i==6)
					ivlegend_option		=ivlegend_option +	"<option value='4'>"+((String) IVlegends.get(i+1))+"</option>";
				else if (i==8)
					ivlegend_option		=ivlegend_option +	"<option value='5'>"+((String) IVlegends.get(i+1))+"</option>";
			}
		java.util.Date date_time	 	= new java.util.Date();
		String currentdate				= com.ehis.util.DateUtils.getCurrentDate("DMY",locale);
			
	
	%>

	<table cellpadding=0 cellspacing=0 width="105%"  align="center" border="0" >
	      <TH COLSPAN="6" ALIGN="center"><fmt:message key="Common.reportcritera.label" bundle="${common_labels}"/></TH>
			<tr><td class='label' colspan='4' height='6'></td></tr>
			<tr>
				<td colspan='2' class="label"><fmt:message key="Common.reporttype.label" bundle="${common_labels}"/></td>
				<td>&nbsp;<SELECT name="p_report_type" id="p_report_type"  onChange="" style="width:155px">
				<option value =""> ---------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> --------- </option>
		   		<option value ="W"> <fmt:message key="ePH.WeeklySchedule.label" bundle="${ph_labels}"/></option>
				<option value ="WR"> <fmt:message key="ePH.WeeklyRefillList.label" bundle="${ph_labels}"/></option>	
				<option value ="M"> <fmt:message key="ePH.MonthlyCheckList.label" bundle="${ph_labels}"/></option>	
    			</select>&nbsp;<img src="../../eCommon/images/mandatory.gif" align="center">
				</td>
				<td colspan='4' class="label" nowrap><fmt:message key="Common.patientId.label" bundle="${common_labels}"/>
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="text"  name="p_patient_id" id="p_patient_id" size=20 value=""  onKeyPress="return CheckForSpecChars(event)" maxlength="<%=bean.getPatientIDLength()%>" onBlur="callPatientSearch();">&nbsp;<input type="button" name="patient_search" id="patient_search" value="?" class="button"  onClick="callPatientSearch();">&nbsp;<img src="../../eCommon/images/mandatory.gif" align="center">
				<input type="hidden" name="P_PAT_ID" id="P_PAT_ID" value=""> &nbsp;			
				<label id="p_patient_name" style='display:none'></label>					
				</td>
				</td>	
    </tr>
	<tr><td class='label' colspan='4' height='6'></td></tr>
	<tr>
			<td colspan='2' class="label"><fmt:message key="Common.status.label" bundle="${common_labels}"/></td>
			<td>&nbsp;<select name="p_status" id="p_status"  maxlength="3" onChange="">
				
				<option  VALUE="C" ><fmt:message key="Common.completed.label" bundle="${common_labels}"/></option>
				<option  VALUE="F"><fmt:message key="ePH.FutureRx.label" bundle="${ph_labels}"/></option>
				<option  VALUE="A" ><fmt:message key="Common.active.label" bundle="${common_labels}"/></option>
				<option  VALUE="D"><fmt:message key="Common.Discontinued.label" bundle="${common_labels}"/></option>
				<option  VALUE="O"><fmt:message key="ePH.OnHold.label" bundle="${ph_labels}"/></option>
				<option  VALUE="R"><fmt:message key="Common.returned.label" bundle="${common_labels}"/></option>
				<option  VALUE="C"><fmt:message key="Common.cancelled.label" bundle="${common_labels}"/></option>
				<option  VALUE="P"><fmt:message key="Common.Pending.label" bundle="${common_labels}"/></option>
				<option  VALUE="PA"><fmt:message key="Common.PendingAuthorization.label" bundle="${common_labels}"/></option>
				<option  VALUE="PC"><fmt:message key="Common.PendingConsent.label" bundle="${common_labels}"/></option>
				<option  VALUE="PS"><fmt:message key="ePH.PendingSplAprvl.label" bundle="${ph_labels}"/></option>
				<option  VALUE="" selected><fmt:message key="Common.all.label" bundle="${common_labels}"/></option>
				</select>
			</td>

			<td colspan='4' class="label"><fmt:message key="ePH.TypeofOrder.label" bundle="${ph_labels}"/>
				&nbsp;&nbsp;&nbsp;&nbsp;<select name="order_type" id="order_type"><option value="ALL" selected><fmt:message key="Common.all.label" bundle="${common_labels}"/></option>
				<option value="10"><fmt:message key="ePH.RxOrder.label" bundle="${ph_labels}"/></option>
				<option value="6"><fmt:message key="ePH.CompoundingOrder.label" bundle="${ph_labels}"/> </option>
				<%=ivlegend_option%>				
				<option value="9"><fmt:message key="ePH.OncologyOrder.label" bundle="${ph_labels}"/></option>		
				<option value="0"><fmt:message key="ePH.OncologyAdmixture.label" bundle="${ph_labels}"/></option></select>
				</td>
	</tr>
	<tr><td class='label' colspan='4' height='6'></td></tr>

	<tr>			
						<td colspan='2' class="label" ><fmt:message key="Common.Start.label" bundle="${common_labels}"/></td>
						<td>&nbsp;<input type="text" size="10" maxlength="10" name="P_FM_DATE_TEXTBOX" id="P_FM_DATE_TEXTBOX" OnBlur='CheckDate(this)' value='<%=currentdate%>'>&nbsp;<INPUT TYPE="image" SRC="../../eCommon/images/CommonCalendar.gif" id=Calendar onclick="return showCalendar('P_FM_DATE_TEXTBOX');" >&nbsp;<img src="../../eCommon/images/mandatory.gif"  align="center"></td>
						<input type="hidden" name ="P_FM_DATE" value = "">
						<input type="hidden" name ="P_TO_DATE" value = "">
						<td colspan='4' class="label"><fmt:message key="Common.to.label" bundle="${common_labels}"/>			&nbsp;&nbsp;&nbsp&nbsp;&nbsp&nbsp;&nbsp&nbsp;&nbsp&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						<input type="text" size="10" maxlength="10" name="P_TO_DATE_TEXTBOX" id="P_TO_DATE_TEXTBOX" OnBlur='CheckDate(this)' value='<%=currentdate%>'>&nbsp;<INPUT TYPE="image" SRC="../../eCommon/images/CommonCalendar.gif" id='Calendar' onclick="return showCalendar('P_TO_DATE_TEXTBOX');" >&nbsp;&nbsp;<img src="../../eCommon/images/mandatory.gif"  align="center">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<fmt:message key="Common.Ordering.label" bundle="${common_labels}"/> <fmt:message key="Common.date.label" bundle="${common_labels}"/>	&nbsp;&nbsp;<input type="text" name="P_ORD_DATE" id="P_ORD_DATE"  size="8"  value="" maxlength="10" onBlur="CheckDate(this);" >&nbsp;<IMG SRC="../../eCommon/images/CommonCalendar.gif" id='Calendar' onclick="return showCalendar('P_ORD_DATE');" >	
						</td>
			</tr>
			<tr><td class='label' colspan='4' height='6'></td></tr>
			<tr >
				<td colspan='2' class="label" nowrap><fmt:message key="Common.Drug.label" bundle="${common_labels}"/></td>
				<td>&nbsp;<input type="text" name="drug_name" id="drug_name" maxlength="60" size="60" >&nbsp;<input type="button" class="button" value="?" name="drug_name_search" id="drug_name_search" onfocus="searchDrugName();" onclick="searchDrugName();">
				<input type="hidden" name="p_drug_code" id="p_drug_code" value="">
				</td>
				<td colspan='4'class="label" nowrap><fmt:message key="Common.Language.label" bundle="${common_labels}"/>
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<select name="P_LANGUAGE_ID" id="P_LANGUAGE_ID" onChange=""><BR>
				<option value="th"><fmt:message key="ePH.Thai.label" bundle="${ph_labels}"/></option>
				<option value="en"><fmt:message key="Common.English.label" bundle="${common_labels}"/></option>
				</select>&nbsp;<img src="../../eCommon/images/mandatory.gif"  align="center">
				</td>

	
			</tr>
	</table>
	<INPUT TYPE="hidden" name="p_facility_id" id="p_facility_id" VALUE="<%= session.getValue( "facility_id" ) %>">
	<INPUT TYPE="hidden" name="p_user_name" id="p_user_name" VALUE="<%= session.getValue( "login_user" ) %>">
	<INPUT TYPE="hidden" name="p_report_id" id="p_report_id" VALUE="">
	<INPUT TYPE="hidden" name="p_module_id" id="p_module_id" VALUE="PH">
	<INPUT TYPE="hidden" name="bean_id" id="bean_id" VALUE="<%=bean_id%>">
	<INPUT TYPE="hidden" name="bean_name" id="bean_name" VALUE="<%=bean_name%>">
	<INPUT TYPE="hidden" name="bean_id2" id="bean_id2" VALUE="<%=bean_id2%>">
	<INPUT TYPE="hidden" name="bean_name2" id="bean_name2" VALUE="<%=bean_name2%>">
	<INPUT TYPE="hidden" name="p_language_id" id="p_language_id" VALUE="<%=locale%>">
	<INPUT TYPE="hidden" name="p_language_id1" id="p_language_id1" VALUE="<%=locale%>">
</form>
		
		<input type="hidden" name="sql_ph_drug_search_select" id="sql_ph_drug_search_select" value="<%=sql_ph_drug_search_select%>">

</html>
<%  
    putObjectInBean(bean_id,bean,request);
    putObjectInBean(bean_id1,bean1,request);
    putObjectInBean(bean_id2,bean2,request);
%>

