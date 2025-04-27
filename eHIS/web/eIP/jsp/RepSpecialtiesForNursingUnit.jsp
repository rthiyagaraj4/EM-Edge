<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%@ page import="java.sql.*"  contentType="text/html;charset=UTF-8"  %>
 <% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>
<%
	request.setCharacterEncoding("UTF-8"); 
	String p_module_id		= "IP" ;
	String p_report_id		= "IPBSPFNU" ;
	String p_facility_id		= (String) session.getValue( "facility_id" ) ;
	String p_user_name		= (String) session.getValue( "login_user" ) ;
	String locale			= (String)session.getAttribute("LOCALE");
%>

<html>	
<HEAD>
<TITLE></TITLE>
<link rel="stylesheet" type="text/css" href="../../eCommon/html/<%=sStyle%>"></link>
<script src="../../eCommon/js/ValidateControl.js" language='JavaScript'></script>
<script language="JavaScript" src="../../eCommon/js/common.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<script>
async function searchCode(obj,target)
	{
			var retVal = 	new String();
			var dialogHeight= "400px" ;
			var dialogWidth="900px";
			/* var dialogHeight= "28" ;
			var dialogWidth	= "43" ; */
			var status = "no";
			var arguments	= "" ;
			var sql="";
			var search_code="";
			var search_desc="";
			var tit="";
			var locale = document.forms[0].locale.value;
			if(obj.name=="speciality_id")
			{
				var tit=getLabel('Common.speciality.label','common');
				sql="select speciality_code,short_desc from am_speciality_lang_vw where language_id = `"+locale+"` and eff_status = `E` ";
				search_code="speciality_code";
				search_desc= "short_desc";
			}

			if(obj.name=="nursing_unit_code")
			{
				tit=getLabel('Common.nursingUnit.label','common');
				sql="select nursing_unit_code, short_desc from ip_nursing_unit_lang_vw where facility_id=`<%= p_facility_id%>`  and language_id = `<%=locale%>` and eff_status = `E`";
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
</script>
</HEAD>

<BODY onMouseDown='CodeArrest()' onKeyDown='lockKey()'>
<br>
<br>
<form name="RepSpltyNursingUnitForm" id="RepSpltyNursingUnitForm" action="../../eCommon/jsp/report_options.jsp" target="messageFrame">
<table width='80%' align='center' valign='top'>

		<th align='left'> <fmt:message key="Common.reportcritera.label" bundle="${common_labels}"/>
		</th>

	<tr>

		<td width="100%" class="Border" align='center'>

			<table width='80%' cellPadding="0" cellSpacing="0"  align='center' >

				<tr>
					<td align="center" width="35%">&nbsp;</td>
					<td class="querydata" width="20%" style="font-weight: bold;"><fmt:message key="Common.from.label" bundle="${common_labels}"/></td>
					<td class="querydata" width="40%" style="font-weight: bold;"><fmt:message key="Common.to.label" bundle="${common_labels}"/></td>
				</tr>

			
				<tr>
						<td align='left' width='30%' class="label"><fmt:message key="Common.speciality.label" bundle="${common_labels}"/> <fmt:message key="Common.code.label" bundle="${common_labels}"/> &nbsp;</td>
						<td class="fields" width='20%'  >
							<input type=text  name='p_fm_speciality' id='p_fm_speciality' size="4" maxlength="4" align="center"><input type='button' name='speciality_id' id='speciality_id' value='?' class='button' onclick='searchCode(this, p_fm_speciality)'>
						</td>
						<td class="fields" width='40%'> 
							<input type=text  name='p_to_speciality' id='p_to_speciality' size="4" maxlength="4" align="center"><input type='button' name='speciality_id' id='speciality_id' value='?' class='button' onclick='searchCode(this, p_to_speciality)'>
						</td>
				</tr>
			
				<tr>
					<td class="label">&nbsp;</td>
					<Td class="label">&nbsp;</td>
				</tr>
					
				<tr>
						<td align='left' width='30%' class="label"><fmt:message key="Common.NursingUnitCode.label" bundle="${common_labels}"/> &nbsp;</td>
						<td class="fields" width='20%'  >
							<input type=text  name='p_fm_nursing_unit' id='p_fm_nursing_unit' size="4" maxlength="4" align="center"><input type='button' name='nursing_unit_code' id='nursing_unit_code' value='?' class='button' onclick='searchCode(this, p_fm_nursing_unit)'>
						</td>
						<td class="fields" width='40%'> 
							<input type=text  name='p_to_nursing_unit' id='p_to_nursing_unit' size="4" maxlength="4" align="center"><input type='button' name='nursing_unit_code' id='nursing_unit_code' value='?' class='button' onclick='searchCode(this, p_to_nursing_unit)'>
						</td>
				</tr>
			
				<tr>
					<td class="label">&nbsp;</td>
					<Td class="label">&nbsp;</td>
				</tr>								

		</table>
	</td>
</tr>
</table>

	<input type="hidden" name="p_facility_id" id="p_facility_id"		value="<%= p_facility_id %>">
	<input type="hidden" name="p_module_id" id="p_module_id" 		value="<%= p_module_id %>">
	<input type="hidden" name="p_report_id" id="p_report_id" 		value="<%= p_report_id %>">
	<input type="hidden" name="p_user_name" id="p_user_name"			value="<%= p_user_name %>">
	<input type="hidden" name="locale" id="locale"			value="<%= locale %>">

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

