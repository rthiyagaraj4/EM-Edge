<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%@ page import="java.sql.*" contentType="text/html;charset=UTF-8" %>
<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>
<%
	request.setCharacterEncoding("UTF-8"); 
	String p_module_id		= "IP" ;
	String p_report_id		= "IPBKGMSG" ;
	String p_facility_id	= (String) session.getValue( "facility_id" ) ;
	String p_user_name		= (String) session.getValue( "login_user" ) ;
	String locale = (String)session.getAttribute("LOCALE");
%>

<html>	
<HEAD>
<TITLE></TITLE>
<link rel="stylesheet" type="text/css" href="../../eCommon/html/<%=sStyle%>"></link>
<link rel="stylesheet" type="text/css" href="../../eCommon/html/CommonCalendar.css"></link>
<script src="../../eCommon/js/ValidateControl.js"></script>
<script language="JavaScript" src="../../eCommon/js/common.js"></script>
<script src="../../eCommon/js/CommonCalendar.js"></script>
<script src='../../eCommon/js/DateUtils.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


<script>
async function searchCode(obj,target)
	{
			var retVal = 	new String();
			var locale= "<%=locale%>"
			var dialogHeight= "60vh" ;
			var dialogWidth	= "70vw" ;
			var status = "no";
			var arguments	= "" ;
			var sql="";
			var search_code="";
			var search_desc="";
			var tit="";

			tit=getLabel('eIP.MedicalServiceGroup.label','IP')
			//sql="select med_ser_grp_code, short_desc from ip_medical_service_group ";
			sql="select med_ser_grp_code, short_desc from IP_MEDICAL_SERVICE_GRP_LANG_VW where language_id=`"+locale+"` ";
			
			search_code="med_ser_grp_code";
			search_desc= "short_desc";
			
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
	/*Tuesday, December 22, 2009 IN017529, Since Booking can have future date.
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
}*/
</script>
</HEAD>

<BODY onMouseDown="CodeArrest()" onKeyDown = "lockKey()" >
<br>
<br>
<form name="Rep2BookingByMedServGroupForm" id="Rep2BookingByMedServGroupForm" action="../../eCommon/jsp/report_options.jsp" target="messageFrame">
<table width='80%' align='center' valign='top'>

		<th align='left'> <fmt:message key="Common.reportcritera.label" bundle="${common_labels}"/>
		</th>

	<tr>

		<td width="100%" class="Border" align='center'>

			<table width='80%' cellPadding="0" cellSpacing="0"  align='center' >

				<tr>
					<td class='label' align="center" width="35%">&nbsp;</td>
					<td class="querydata" width="20%" style="font-weight: bold;"><fmt:message key="Common.from.label" bundle="${common_labels}"/></td>
					<td class="querydata" width="40%" style="font-weight: bold;"><fmt:message key="Common.to.label" bundle="${common_labels}"/></td>
				</tr>
	
	</tr>								

				<tr>
						<td align='right' width='30%' class="label"><fmt:message key="eIP.PreferredAdmissionDate.label" bundle="${ip_labels}"/>&nbsp;</td>
						<td class='fields' width='20%'  >
							<input type=text id="adm_date_from"  name='p_fm_preferred_date' id='p_fm_preferred_date' size="10" maxlength="10" align="center" onblur='if(validDateObj(this,"DMY","<%=localeName%>")){/*chkWithSysDt(this);*/}'><img src='../../eCommon/images/CommonCalendar.gif' onClick="return showCalendar('adm_date_from');"/>
						</td>
						<td class='fields' width='40%'> 
							<input type=text id="adm_date_to"  name='p_to_preferred_date' id='p_to_preferred_date' size="10" maxlength="10" align="center" onblur='if(validDateObj(this,"DMY","<%=localeName%>")){/*chkWithSysDt(this);*/}'><img src='../../eCommon/images/CommonCalendar.gif' onClick="return showCalendar('adm_date_to');"/>
						</td>
				</tr>
				
				<tr>
					<td class='label'>&nbsp;</td>
					<td class='label'>&nbsp;</td>
				</tr>


				<tr>
						<td align='right' width='30%' class="label" nowrap><fmt:message key="eIP.MedicalServiceGroup.label" bundle="${ip_labels}"/>&nbsp;<fmt:message key="Common.code.label" bundle="${common_labels}"/></td>
						<td class='fields' width='20%'  >
							<input type=text  name='p_fm_med_ser_grp_code' id='p_fm_med_ser_grp_code' size="2" maxlength="2" align="center"><input type='button' name='med_ser_grp_code' id='med_ser_grp_code' value='?' class='button' onclick='searchCode(this, p_fm_med_ser_grp_code)'>
						</td>
						<td class='fields' width='40%'> 
							<input type=text  name='p_to_med_ser_grp_code' id='p_to_med_ser_grp_code' size="2" maxlength="2" align="center"><input type='button' name='med_ser_grp_code' id='med_ser_grp_code' value='?' class='button' onclick='searchCode(this, p_to_med_ser_grp_code)'>
						</td>
				</tr>
			
				<tr>
					<td class='label'>&nbsp;</td>
					<Td class='label'>&nbsp;</td>
				</tr>								
				
				
				<tr>
					<td align='right' width='30%' class="label">
						<fmt:message key="Common.BookingStatus.label" bundle="${common_labels}"/> &nbsp;
					</td>
					<td class='fields'  width='20%' align="left">
						<select name='p_rep_type' id='p_rep_type'>							
							<option value='1'><fmt:message key="Common.Admitted.label" bundle="${common_labels}"/>
							<option value='2'><fmt:message key="Common.cancelled.label" bundle="${common_labels}"/>
							<option value='3'><fmt:message key="Common.confirmed.label" bundle="${common_labels}"/>							
							<option value='4'><fmt:message key="Common.NoShows.label" bundle="${common_labels}"/>
							<option value='5'><fmt:message key="Common.NotConfirmed.label" bundle="${common_labels}"/>
							
						</select>&nbsp;<img src='../../eCommon/images/mandatory.gif'align='center'></img>
					</td>
				</tr>

				<tr>
					<td class='label'>&nbsp;</td>
					<Td class='label'>&nbsp;</td>
				</tr>
		</table>
	</td>
</tr>
</table>
	<%if(localeName.equals("en"))
	{%>
	<!-- <INPUT TYPE="hidden" name="p_passing_local_date" id="p_passing_local_date" value="N"> -->
	<%}
	else if(localeName.equals("th"))
	{%>
	<INPUT TYPE="hidden" name="P_passing_local_date" id="P_passing_local_date" value="Y">
	<%}%>
	
	<input type="hidden" name="p_facility_id" id="p_facility_id"	value="<%= p_facility_id %>">
	<input type="hidden" name="p_module_id" id="p_module_id" 	value="<%= p_module_id %>">
	<input type="hidden" name="p_report_id" id="p_report_id" 	value="<%= p_report_id %>">
	<input type="hidden" name="p_user_name" id="p_user_name"	    value="<%= p_user_name %>">

</form>
<script>
document.forms[0].p_fm_preferred_date.focus()
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

