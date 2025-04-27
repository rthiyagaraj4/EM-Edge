<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%@ page import="java.sql.*"  contentType="text/html;charset=UTF-8" %>
 <% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>
<%
	request.setCharacterEncoding("UTF-8"); 
	String p_module_id		= "IP" ;
	String p_report_id		= "IPBNBBLT" ;
	String p_facility_id		= (String) session.getValue( "facility_id" ) ;
	String p_user_name		= (String) session.getValue( "login_user" ) ;
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
			
			if(obj.name=="bed_class_code")
			{
				tit=getLabel('Common.BedClass.label','common')
				sql="select bed_class_code,short_desc from ip_bed_class ";
				search_code="bed_class_code";
				search_desc= "short_desc";
			}

			if(obj.name=="nursing_unit_code")
			{
				tit=getLabel('Common.nursingUnit.label','common');
				sql="select nursing_unit_code, short_desc from ip_nursing_unit where facility_id=`<%= p_facility_id%>` ";
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
<form name="RepNursUnitBedClassBkgLmtForm" id="RepNursUnitBedClassBkgLmtForm" action="../../eCommon/jsp/report_options.jsp" target="messageFrame">
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
					
				<tr>
						<td align='left' width='30%' class="label"><fmt:message key="eIP.BedClassCode.label" bundle="${ip_labels}"/> &nbsp;</td>
						<td class="fields" width='20%'  >
							<input type=text  name='p_fm_bed_class' id='p_fm_bed_class' size="2" maxlength="2" align="center"><input type='button' name='bed_class_code' id='bed_class_code' value='?' class='button' onclick='searchCode(this, p_fm_bed_class)'>
						</td>
						<td class="fields" width='40%'> 
							<input type=text  name='p_to_bed_class' id='p_to_bed_class' size="2" maxlength="2" align="center"><input type='button' name='bed_class_code' id='bed_class_code' value='?' class='button' onclick='searchCode(this, p_to_bed_class)'>
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

