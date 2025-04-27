<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%@ page import="java.sql.*,java.text.*,webbeans.eCommon.*,eCommon.Common.*"  contentType="text/html;charset=UTF-8" %>
 <% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>
<%
	request.setCharacterEncoding("UTF-8"); 
	String p_module_id		= "IP" ;
	String p_facility_id		= (String) session.getValue( "facility_id" ) ;
	String p_user_name		= (String) session.getValue( "login_user" ) ;
	Connection con			= null;
	try{
		con = ConnectionManager.getConnection(request);
		Boolean isSpeciality=false;
		isSpeciality=CommonBean.isSiteSpecific(con, "MR","PER_PD_SPECIALITY");  
%>

<html>	
<HEAD>
<TITLE></TITLE>
	<link rel="stylesheet" type="text/css" href="../../eCommon/html/<%=sStyle%>"></link>
	<link rel="stylesheet" type="text/css" href="../../eCommon/html/CommonCalendar.css"></link>
	<script src="../../eCommon/js/ValidateControl.js"></script>
	<script src='../../eCommon/js/dchk.js' language='javascript'></script>
	<script src="../../eCommon/js/common.js"></script>
	<script src="../../eCommon/js/CommonCalendar.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	<script>
	function mychange()
 {
	 if (document.getElementById('p_type').value=='M')
	 {
		 document.getElementById('MY1').innerHTML=getLabel('eIP.CensusMonth.label','IP')+"&nbsp;";
		  document.getElementById('MY').innerHTML = "<input type='text' name='p_trn_date' id='p_trn_date' id='census_mth' maxlength='5' size='5' readonly><input type='image'  src='../../eCommon/images/CommonCalendar.gif' onClick=\"document.forms[0].p_trn_date.select();return showCalendar('census_mth','mm/y',null)\">&nbsp;<img align='center' src='../../eCommon/images/mandatory.gif'></img>"
	 }
	 else  if (document.getElementById('p_type').value=='Y')
	 {
		 document.getElementById('MY1').innerHTML=getLabel('Common.CensusYear.label','Common')+"&nbsp;";
		 document.getElementById('MY').innerHTML = "<input type='text' name='p_trn_date' id='p_trn_date' id='census_date' maxlength='4' size='4' readonly><input type='image'  src='../../eCommon/images/CommonCalendar.gif' onClick=\"document.forms[0].p_trn_date.select();return showCalendar('census_date','y',null)\">&nbsp;<img align='center' src='../../eCommon/images/mandatory.gif'></img>"
	 }
 }			
	async function searchCode(obj,target)
		{
				var retVal = 	new String();
				var dialogHeight= "400px" ;
				var dialogWidth	= "700px" ;
				var status = "no";
				var arguments	= "" ;
				var sql="";
				var search_code="";
				var search_desc="";
				var tit="";
				var nur_unit=document.forms[0].p_nursing_unit_code.value;//Added by Kamatchi S for ML-MMOH-CRF-1563
				if(obj.name=="nursing_unit")
				{
					tit=getLabel('Common.nursingUnit.label','common');
					sql="select nursing_unit_code, short_desc from ip_nursing_unit where EFF_STATUS =`E`	AND INCL_FOR_HOSP_OCCUP_CALC_YN =`Y` and facility_id=`<%=p_facility_id%>`";
					search_code="nursing_unit_code";
					search_desc= "short_desc";
				}
				//Added by Kamatchi S for ML-MMOH-CRF-1563
				else if(obj.name=="speciality")
				{
					tit=encodeURIComponent(getLabel("Common.speciality.label","Common"));
					sql="SELECT a.SPECIALTY_CODE , b.short_desc  FROM ip_nurs_unit_for_specialty a, am_speciality b,ip_nursing_unit c where c.EFF_STATUS =`E` and b.EFF_STATUS=`E` and c.facility_id=`<%=p_facility_id%>` and c.nursing_unit_code=a.nursing_unit_code and a.SPECIALTY_CODE=b.SPECIALITY_CODE ";
					if(nur_unit!="")
					{
						sql=sql+ " and c.nursing_unit_code=`"+nur_unit+"`";
					}
					search_code="a.SPECIALTY_CODE";
					search_desc="b.short_desc";
				}

				
				var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; scroll=no; status:" + status;
				retVal = await window.showModalDialog("../../eCommon/jsp/GeneralSearch.jsp?SQL="+sql+"&search_code="+search_code+"&search_desc="+search_desc+"&title="+encodeURIComponent(tit),arguments,features);
	
				if (!(retVal == null))
				{
					target.value=retVal;
				}
				else
					target.focus();
				// Added by Lakshmanan for ML-MMOH-SCF-1825
				<%if(isSpeciality) { %>
				if (obj.name=="nursing_unit" & (nur_unit=="" | nur_unit!=retVal)){
					document.forms[0].p_speciality_code.value="";
					}
				<%}%>
		}

		function ChkDateFormat(Object2) {
			var datefield = Object2;
			if (ChkDate1(Object2) == false) {
				alert(parent.parent.parent.frames[0].getMessage('INVALID_DATE_FMT','SM'));
				datefield.select();
				datefield.focus();		
				return false;
			}
			else {
				return true;
			}
		}
		
		function ChkDate1(Object3) {
		var strDate;	
		var strMonth;
		var strYear;	
		var datefield = Object3;
		var strDateArray = new Array();

		strDate = datefield.value;
		if (strDate.length == 0) return true; 
		
		strDateArray = strDate.split("/");
		if (strDateArray.length != 2) {
			return false;
		}
		else {
			strMonth = strDateArray[0];
			strYear = strDateArray[1];
		}
	
		if (strYear.length < 4) return false;
		if (isNaN(strMonth)==true) return false;
		if (isNaN(strYear)==true) return false;
		if (strYear < 1900) return false;
		if (strMonth>12 || strMonth<1) 	return false;

		return true;
 }
	function vlaidstring(event)
	{
		if((((event.keyCode>=48) && (event.keyCode<=57))
		||((event.keyCode>=65) && (event.keyCode<=90))
		||((event.keyCode>=97) && (event.keyCode<=122))
		||(event.keyCode==42)||(event.keyCode==95)))
		return true
	else
		return false
	}
	// Added by lakshmanan for ML-MMOH-SCF-1825 
	function clearSpecialityCode() {
		document.forms[0].p_speciality_code.value="";
	}
</script>

</HEAD>

<BODY onMouseDown='CodeArrest()' onKeyDown='lockKey()' onLoad="mychange()" >
<br>
<br>
<form name="Rep2MonthlyIPCensusNursingUnitForm" id="Rep2MonthlyIPCensusNursingUnitForm" action="../../eCommon/jsp/report_options.jsp" target="messageFrame">
<table width='80%' align='center' valign='top'>

		<th align='left'> <fmt:message key="Common.reportcritera.label" bundle="${common_labels}"/>
		</th>

	<tr>

		<td width="100%" class="Border" align='center'>

			<table width='80%' cellPadding="0" cellSpacing="0"  align='center' >

			<tr>
					<td align='left' width='30%' class="label"><fmt:message key="Common.reporttype.label" bundle="${common_labels}"/>&nbsp;</td>
					<td width='25%'>
						 <SELECT name="p_type" id="p_type" onchange='mychange()'>
						 <option value="M"><fmt:message key="Common.month.label" bundle="${common_labels}"/></option>
						 <option value="Y"><fmt:message key="Common.year.label" bundle="${common_labels}"/></option>
						 </SELECT>
					</td>
					 <td colspan ='3'> 
				</tr>
				<tr>
					<td align='right' width='30%' class="label">  &nbsp;&nbsp;</td>
					<td width='25%'  ></td>
					<td colspan ='3'></td>
					<td colspan ='3'></td>
				</tr>
				<tr>
						<td align='left' id='MY1'class="label"> &nbsp; &nbsp;</td>
						<td align='left' id='MY' > &nbsp; </td><td> </td>
				</tr>
				<tr>
					<td align='right' width='30%' class="label">  &nbsp;</td>
					<td width='25%'  ></td>
					<td colspan ='3'></td>
					
				</tr>
						 
				<tr>
						<td align='left' width='30%' class="label"><fmt:message key="Common.NursingUnitCode.label" bundle="${common_labels}"/>&nbsp;</td>
						<td width='20%'  >
						<!--Added this onchange='clearSpecialityCode()' by Lakshmanan for ML-MMOH-SCF-1825  -->
							<input type=text  name='p_nursing_unit_code' id='p_nursing_unit_code' size="4" maxlength="4" align="center" onkeypress='return vlaidstring(event)'
							<%if(isSpeciality){%>
							onchange='clearSpecialityCode()'
							<%}%>
							>
							<input type='button' name='nursing_unit' id='nursing_unit' value='?' class='button'  onclick='searchCode(this, p_nursing_unit_code)'>
						<img align='center' src='../../eMP/images/mandatory.gif'>
						</td>
						<!--Added by KAMATCHI S for ML-MMOH-CRF-1563-->
						<%if(isSpeciality){%>
						<td align='left' width='30%' class="label"><fmt:message key="Common.speciality.label" bundle="${common_labels}"/>&nbsp;</td>
						<td width='20%'  >
							<input type=text  name='p_speciality_code' id='p_speciality_code' size="4" maxlength="4" align="center" onkeypress='return vlaidstring(event)'><input type='button' name='speciality' id='speciality' value='?' class='button'  onclick='searchCode(this, p_speciality_code)'>
						</td>
						<%}%>
							<!--Added by KAMATCHI S for ML-MMOH-CRF-1563-->
				</tr>
				
				<tr>
					<td>&nbsp;</td>
					<Td>&nbsp;</td>
				</tr>
		<%	}catch(Exception e)
		{
			out.println(e);
		}
		finally
		{
			ConnectionManager.returnConnection(con,request);
		}		%>
		</table>
	</td>
</tr>
</table>

	<input type="hidden" name="p_facility_id" id="p_facility_id"		value="<%= p_facility_id %>">
	<input type="hidden" name="p_module_id" id="p_module_id" 		value="<%= p_module_id %>">
	<input type="hidden" name="p_report_id" id="p_report_id" 		value="">
	<input type="hidden" name="p_user_name" id="p_user_name"		value="<%= p_user_name %>">

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

