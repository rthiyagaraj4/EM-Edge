<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%@ page import="java.sql.*" contentType="text/html;charset=UTF-8" %>
<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>
<%
	request.setCharacterEncoding("UTF-8"); 
	String p_module_id		= "IP" ;
	String p_report_id		= "IPBAVLBD" ;
	String p_facility_id	= (String) session.getValue( "facility_id" ) ;
	String p_user_name		= (String) session.getValue( "login_user" ) ;
	String locale = (String)session.getAttribute("LOCALE");
%>

<html>	
<HEAD>
<TITLE></TITLE>
<link rel="stylesheet" type="text/css" href="../../eCommon/html/CommonCalendar.css"></link>
<link rel="stylesheet" type="text/css" href="../../eCommon/html/<%=sStyle%>"></link>
<script src="../../eCommon/js/ValidateControl.js"></script>
<script src='../../eCommon/js/dchk.js' language='javascript'></script>
<script language="JavaScript" src="../../eCommon/js/common.js"></script><script src="../../eCommon/js/CommonCalendar.js"></script>
<script src="../../eCommon/js/DateUtils.js"></script>
<script src='../../eCommon/js/FieldFormatMethods.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


<script>
async function searchCode(obj,target)
	{
			var retVal = 	new String();
			var locale= "<%=locale%>"
			var dialogHeight= "28" ;
			var dialogWidth	= "43" ;
			var status = "no";
			var arguments	= "" ;
			var sql="";
			var search_code="";
			var search_desc="";
			var tit="";
			if(obj.name=="bed_no")
			{
				tit=getLabel('Common.BedClass.label','common')
				sql="select distinct bed_no,bed_no from ip_nursing_unit_bed_vw ";
				
				search_code="bed_no";
				search_desc= "bed_no";
			}

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

	function dateVal( obj )
	{
		if(obj.value !="")
		{
			if(!doDateTimeChk(obj))
			{
				obj.focus()
				alert( parent.parent.parent.frames[0].getMessage("INVALID_DATE_TIME","SM") )
			}
		}
	}

	function ChangeState()
	{
		if ( Rep2AvailableBedsForm.pseudo_bed_yn.checked == true)
		{
			Rep2AvailableBedsForm.pseudo_bed_yn.value="Y";
		}
		else
		{
			Rep2AvailableBedsForm.pseudo_bed_yn.cheked=false;
			Rep2AvailableBedsForm.pseudo_bed_yn.value="N";
		}

	}
	function chkWithSysDt(obj){
		if(obj.value!=''){

			if(isBeforeNow(obj.value,"DMY",localeName))
				return true;
			else {
				alert(getMessage("START_DATE_GREATER_SYSDATE","COMMON"));
				obj.select();
				obj.focus();
				return false ;
			}
		}
}

</script>
</HEAD>

<BODY onMouseDown='CodeArrest()' onKeyDown='lockKey()'>
<br>
<br>
<form name="Rep2AvailableBedsForm" id="Rep2AvailableBedsForm" action="../../eCommon/jsp/report_options.jsp" target="messageFrame">
<table width='80%' align='center'  valign='top'>

		<th align='left'><fmt:message key="Common.reportcritera.label" bundle="${common_labels}"/></th>

	<tr>

		<td width="100%" class="Border" align='center'>

			<table width='80%' cellPadding="0" cellSpacing="0"  align='center' >

				<tr>
					<td class="label" align="center" width="35%">&nbsp;</td>
					<td class="querydata" width="20%" style="font-weight: bold;"><fmt:message key="Common.from.label" bundle="${common_labels}"/></td>
					<td class="querydata" width="40%" style="font-weight: bold;"><fmt:message key="Common.to.label" bundle="${common_labels}"/></td>
				</tr>
	
				</tr>								

				<tr>

						<td align='right' width='30%' class="label"><fmt:message key="Common.NursingUnitCode.label" bundle="${common_labels}"/> &nbsp;</td>
						<td class="fields" width='20%'  >
							<input type=text  name='p_fm_nursing_unit_code' id='p_fm_nursing_unit_code' size="4" maxlength="4" align="center"><input type='button' name='nursing_unit_code' id='nursing_unit_code' value='?' class='button' onclick='searchCode(this, p_fm_nursing_unit_code)'>
						</td>
						<td class="fields" width='40%'> 
							<input type=text  name='p_to_nursing_unit_code' id='p_to_nursing_unit_code' size="4" maxlength="4" align="center"><input type='button' name='nursing_unit_code' id='nursing_unit_code' value='?' class='button' onclick='searchCode(this, p_to_nursing_unit_code)'>
				</tr>

<tr>
					<td class="label">&nbsp;</td>
					<Td class="label">&nbsp;</td>
				</tr>	
<!-- <tr>
					<td class="label" align="center" width="35%">&nbsp;</td>
					<td class="querydata" width="20%" style="font-weight: bold;"><fmt:message key="Common.from.label" bundle="${common_labels}"/></td>
					<td class="querydata" width="40%" style="font-weight: bold;"><fmt:message key="Common.to.label" bundle="${common_labels}"/></td>
				</tr> -->
				<tr>
		<td  width='40%' class="label" align='right' nowrap><fmt:message key="Common.Period.label" bundle="${common_labels}"/>&nbsp;&nbsp;</td>
		<td  width='20%' align='left'>
		       <input type=text id="p_date_from" name='p_fr_dt' id='p_fr_dt' size="16" maxlength="16" onblur='validDateObj(this,"DMYHM","<%=localeName%>");'><img src='../../eCommon/images/CommonCalendar.gif' onClick="return showCalendar('p_date_from',null,'hh:mm');"/>
		</td>
		<td  width='40%' align='left'>
		       <input type=text id="p_date_to"  name='p_to_dt' id='p_to_dt' size="16" maxlength="16" onblur='validDateObj(this,"DMYHM","<%=localeName%>");'><img src='../../eCommon/images/CommonCalendar.gif' onClick="return showCalendar('p_date_to',null,'hh:mm');"/>
		</td>
	</tr>

				<tr>
					<td class="label">&nbsp;</td>
					<Td class="label">&nbsp;</td>
				</tr>	


				<tr>
						<td align='right' width='30%' class="label"><fmt:message key="Common.roomno.label" bundle="${common_labels}"/> &nbsp;</td>
						<td class="fields" width='20%'  >
							<input type=text  name='p_fm_room_no' id='p_fm_room_no' size="4" maxlength="4" align="center">
						</td>
						<td class="fields" width='40%'> 
							<input type=text  name='p_to_room_no' id='p_to_room_no' size="4" maxlength="4" align="center">
						</td>
				</tr>

				<tr>
					<td class="label">&nbsp;</td>
					<Td class="label">&nbsp;</td>
				</tr>

				<tr>
					<td align='right' width='30%' class="label"><fmt:message key="Common.gender.label" bundle="${common_labels}"/> &nbsp;</td>
					<td class="fields" width='20%' align="left">
						<select name='p_sex_spec_ind' id='p_sex_spec_ind'>
							<option value='B'><fmt:message key="Common.all.label" bundle="${common_labels}"/>
							<option value='M'><fmt:message key="Common.male.label" bundle="${common_labels}"/>
							<option value='F'><fmt:message key="Common.female.label" bundle="${common_labels}"/>
							<option value='U'><fmt:message key="Common.unknown.label" bundle="${common_labels}"/>
						</select>&nbsp;<img src='../../eCommon/images/mandatory.gif' align='center'></img>
					</td>
				</tr>

				<tr>
					<td class="label">&nbsp;</td>
					<Td class="label">&nbsp;</td>
				</tr>

              <tr>
				<td  align='right'  class='label'  ><fmt:message key="eIP.PseudoBed.label" bundle="${ip_labels}"/> </td>
				<td class="fields" align='left'  class='label' > 
				   <input type='checkbox'  name='pseudo_bed_yn' id='pseudo_bed_yn'   value=''   onClick='ChangeState()'> 
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

	<input type="hidden" name="p_facility_id" id="p_facility_id"	value="<%= p_facility_id %>">
	<input type="hidden" name="p_module_id" id="p_module_id" 	value="<%= p_module_id %>">
	<input type="hidden" name="p_report_id" id="p_report_id" 	value="<%= p_report_id %>">
	<input type="hidden" name="p_user_name" id="p_user_name"	     	value="<%= p_user_name %>">
 	<input type="hidden" name="p_pseudo_bed_yn" id="p_pseudo_bed_yn"	    value="N">
</form>
<script>
   document.forms[0].p_fm_nursing_unit_code.focus();
   ChangeState();
</script>
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

