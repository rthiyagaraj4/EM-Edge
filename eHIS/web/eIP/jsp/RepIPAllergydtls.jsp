<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%@ page import="java.sql.*, webbeans.eCommon.* " contentType="text/html;charset=UTF-8"  %>
<% request.setCharacterEncoding("UTF-8");  %>
<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>
<%
	request.setCharacterEncoding("UTF-8"); 
	String p_module_id		= "IP" ;
	String p_report_id		= "IPINALGDTL";
	String p_facility_id		= (String) session.getValue( "facility_id" ) ;
	String p_user_name		= (String) session.getValue( "login_user" ) ;
	String locale = (String)session.getAttribute("LOCALE");
	String function_id= checkForNull(request.getParameter("function_id"));
	String defaultSelect = "";
	//Added by shanmukh on 14th-AUG-2018 for ML-MMOH-CRF-1115
	Connection con  =  null;
	String isSpltyNurUnitToEnableYNAppl="";
	try
    {
	con  =  ConnectionManager.getConnection(request);
	isSpltyNurUnitToEnableYNAppl = eIP.IPCommonBean.getSpltyNurUnitToEnableYN(con);
	}catch(Exception e){out.println(e);e.printStackTrace();}
	 finally
	 {
		if(con!=null) ConnectionManager.returnConnection(con,request);
	 }
	 //END
%>
<html>	
<HEAD>
<TITLE></TITLE>
<link rel="stylesheet" type="text/css" href="../../eCommon/html/<%=sStyle%>"></link>
<link rel="stylesheet" type="text/css" href="../../eCommon/html/CommonCalendar.css"></link>
<script src="../../eCommon/js/ValidateControl.js" language='javascript'></script>
<script src='../../eCommon/js/dchk.js' language='javascript'></script>
<script src="../../eCommon/js/CommonCalendar.js" language='javascript'></script>
<script src="../../eCommon/js/common.js" language='javascript'></script>
<script src='../../eCommon/js/DateUtils.js' language='javascript'></script>
<script language='javascript' src='../../eCommon/js/CommonLookup.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>



<script>
async function searchCode(obj,target)	{

	var retVal = 	new String();
	var locale= "<%=locale%>"
	/* var dialogHeight= "28" ;
	var dialogWidth	= "43" ; */
	var dialogHeight= "400px" ;
	var dialogWidth="900px";
	var status = "no";
	var arguments	= "" ;
	var sql="";
	var search_code="";
	var search_desc="";
	var tit="";
	if(obj.name=="nursing_unit_code")
	{
		tit=getLabel('Common.nursingUnit.label','common');
		//sql="select nursing_unit_code, short_desc from ip_nursing_unit where facility_id=`<%= p_facility_id%>` ";
		sql="select nursing_unit_code, short_desc from ip_nursing_unit_lang_vw where facility_id=`<%= p_facility_id%>` and language_id=`"+locale+"` ";
		search_code="nursing_unit_code";
		search_desc= "short_desc";
	}
	var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; scroll=no; status:" + status;
	retVal = await window.showModalDialog("../../eCommon/jsp/GeneralSearch.jsp?SQL="+sql+"&search_code="+search_code+"&search_desc="+search_desc+"&title="+encodeURIComponent(tit),arguments,features);

	if (!(retVal == null))
	{
		target.value=retVal;
	}
	else
		target.focus();
}


function validate_date(Obj) {
	if(Obj.value != '') {
		if(!validDateObj(Obj,"DMY",localeName)) {			
			Obj.select();
			return false;			
		 } else if (isBeforeNow(Obj.value,"DMY",localeName) == false) {
			var err1 = getMessage("DATE_NOT_GREATER_SYSDATE","Common");			
			alert(err1);
			Obj.value = "";
			Obj.focus();
			return false;
		 }		
    }
}

function enableDisableAdmDate(obj){
	if(obj.checked){
		document.forms[0].p_current_ip.value='Y';
		document.forms[0].p_fm_admission_date.value="";
		document.forms[0].p_to_admission_date.value="";
		document.forms[0].p_fm_admission_date.disabled=true;
		document.forms[0].p_to_admission_date.disabled=true;
		document.forms[0].p_fm_admission_date_cal.disabled=true;
		document.forms[0].p_to_admission_date_cal.disabled=true;
		document.forms[0].p_fm_admission_date_img.style.visibility	= 'hidden';
		document.forms[0].p_to_admission_date_img.style.visibility	= 'hidden';

	}else{
		document.forms[0].p_current_ip.value='N';
		document.forms[0].p_fm_admission_date.disabled=false;
		document.forms[0].p_to_admission_date.disabled=false;
		document.forms[0].p_fm_admission_date_cal.disabled=false;
		document.forms[0].p_to_admission_date_cal.disabled=false;
		document.forms[0].p_fm_admission_date_img.style.visibility	= 'visible';
		document.forms[0].p_to_admission_date_img.style.visibility	= 'visible';
	}
}
</script>
</HEAD>

<BODY onMouseDown="CodeArrest();" onKeyDown ="lockKey();">
<br>
<br>
<form name="RepIPAllergydtlsForm" id="RepIPAllergydtlsForm" action="../../eCommon/jsp/report_options.jsp" target="messageFrame">
	<table width='80%' align='center' valign='top'>

			<th align='left'> <fmt:message key="Common.reportcritera.label" bundle="${common_labels}"/>
			</th>

		<tr>

			<td width="100%" class="Border" align='center'>

				<table width='80%' cellPadding="0" cellSpacing="0"  align='center' >
				<tr>
						<td align='left' width='30%' class="label">
							<fmt:message key="Common.current.label" bundle="${common_labels}"/> &nbsp;<fmt:message key="Common.inpatient.label" bundle="${common_labels}"/> &nbsp;
						</td>
						<td  width='40%' align="left">
						<input type='checkbox' name='is_current_ip' id='is_current_ip' value='Y' onclick='enableDisableAdmDate(this);'/>
						<input type='hidden' name= 'p_current_ip' value='N' />
						</td>
					</tr>
					
					<tr>
						<td>&nbsp;</td>
						<Td>&nbsp;</td>
					</tr>	

					<tr>
						<td align="center" width="30%">&nbsp;</td>
						<td class="label" width="40%"><fmt:message key="Common.from.label" bundle="${common_labels}"/></td>
						<td class="label" width="30%"><fmt:message key="Common.to.label" bundle="${common_labels}"/></td>
					</tr>
		
					</tr>								

					<tr>
					<td align='left' width='30%' class="label"><fmt:message key="Common.admissiondate.label" bundle="${common_labels}"/> &nbsp;</td>
							<td width='40%'  >
								<input type=text id="adm_date_from"  name='p_fm_admission_date' id='p_fm_admission_date' size="10" maxlength="10" align="center" onblur="if(validDateObj(this,'DMY',localeName))validate_date(this)"><img src='../../eCommon/images/CommonCalendar.gif' onClick="RepIPAllergydtlsForm.p_fm_admission_date.focus();return showCalendar('adm_date_from');" name='p_fm_admission_date_cal'/>&nbsp;<img src='../../eCommon/images/mandatory.gif' name='p_fm_admission_date_img'></img>
							</td>
							<td width='30%'> 
								<input type=text id="adm_date_to"  name='p_to_admission_date' id='p_to_admission_date' size="10" maxlength="10" align="center" onblur="if(validDateObj(this,'DMY',localeName))validate_date(this)"><img src='../../eCommon/images/CommonCalendar.gif' onClick="RepIPAllergydtlsForm.p_to_admission_date.focus();return showCalendar('adm_date_to');" name='p_to_admission_date_cal'/>&nbsp;<img src='../../eCommon/images/mandatory.gif' name='p_to_admission_date_img'></img>
							</td>
					</tr>
					
					<tr>
						<td>&nbsp;</td>
						<Td>&nbsp;</td>
					</tr>
	 
					<tr><!--Added by Shanmukh on 20th-AUG-2018 for ML-MMOH-CRF-1115-->
					<%if(isSpltyNurUnitToEnableYNAppl.equals("N")){%>
					<jsp:include page="CommonNursingUnitLookup.jsp">
					<jsp:param name="nursing_unit_code_Appl" value="p_fm_nursing_unit"/>
					<jsp:param name="nursing_unit_to_code_Appl" value="p_to_nursing_unit"/>
					</jsp:include>
					<%}else{%>
	 
							<td align='left' width='30%' class="label"><fmt:message key="Common.NursingUnitCode.label" bundle="${common_labels}"/> &nbsp;</td>
							<td width='40%'  >
								<input type=text  name='p_fm_nursing_unit' id='p_fm_nursing_unit' size="4" maxlength="4" align="center"><input type='button' name='nursing_unit_code' id='nursing_unit_code' value='?' class='button' onclick='searchCode(this, p_fm_nursing_unit)'>
							</td>
							<td width='30%'> 
								<input type=text  name='p_to_nursing_unit' id='p_to_nursing_unit' size="4" maxlength="4" align="center"><input type='button' name='nursing_unit_code' id='nursing_unit_code' value='?' class='button' onclick='searchCode(this, p_to_nursing_unit)'>
							</td>
					<%}%>		
					</tr>

					<tr>
						<td>&nbsp;</td>
						<Td>&nbsp;</td>
					</tr>	
					<tr>
						<td align='left' width='30%' class="label">
							<fmt:message key="Common.patientclass.label" bundle="${common_labels}"/> &nbsp;
						</td>
						<td  width='40%' align="left">
						<select name='P_patient_class' id='P_patient_class'>
							<option value='IP'><fmt:message key="Common.inpatient.label" bundle="${common_labels}"/></option>
							<option value='DC'><fmt:message key="Common.daycare.label" bundle="${common_labels}"/></option>
							<option value='B'><fmt:message key="Common.Both.label" bundle="${common_labels}"/></option>						
						</select>
						</td>
					</tr>
					
					<tr>
						<td>&nbsp;</td>
						<Td>&nbsp;</td>
					</tr>	
					
					<tr>
						<td align='left' width='30%' class="label">
							<fmt:message key="Common.status.label" bundle="${common_labels}"/> &nbsp;
						</td>
						<td  width='40%' align="left">
							<select name='p_status' id='p_status'>
							<option value='A'><fmt:message key="Common.active.label" bundle="${common_labels}"/>
							<option value='R'><fmt:message key="Common.Resolved.label" bundle="${common_labels}"/>
							<option value='B'><fmt:message key="Common.Both.label" bundle="${common_labels}"/>
													
							</select>
						</td>
					</tr>
					
				<tr>
						<td>&nbsp;</td>
						<Td>&nbsp;</td>
					</tr>
					</table>
		</td>
	</tr>
	</table>
	
	<input type="hidden" name="p_facility_id" id="p_facility_id"		value="<%= p_facility_id %>">
	<input type="hidden" name="p_module_id" id="p_module_id" 		value="<%= p_module_id %>">
	<input type="hidden" name="p_report_id" id="p_report_id" 		value="<%= p_report_id %>">
	<input type="hidden" name="p_user_name" id="p_user_name"		value="<%= p_user_name %>">
	<input type='hidden' name ='function_id' value="<%=function_id%>"> 

</form>
</BODY>
</HTML>

<%!
	public static String checkForNull(String inputString)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? "" : inputString);
	}
	public static String checkForNull(String inputString, String defaultValue)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? defaultValue : inputString);
	}
%>

