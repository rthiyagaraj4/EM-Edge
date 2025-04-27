<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%@ page contentType="text/html;charset=UTF-8" import ="java.sql.*,java.util.*,java.net.*,java.text.*,webbeans.eCommon.*" %>
<%
	String p_module_id	 = "DR" ;
	String p_report_id	 = "DRBREPID";
	String p_facility_id = (String) session.getValue("facility_id");
	String p_user_name	 = (String) session.getValue("login_user");
%>
<html>
<HEAD>
	<!-- <link rel="stylesheet" type="text/css" href="../../eCommon/html/IeStyle.css"></link> -->
	<%

	request.setCharacterEncoding("UTF-8");
	String sStyle	=
	(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	%>
	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
	<link rel="stylesheet" type="text/css" href="../../eCommon/html/CommonCalendar.css"></link>
	<script language='javascript' src='../../eCommon/js/common.js'></script>
	<script language='javascript' src='../../eCommon/js/CommonLookup.js'></script>
	<script language='javascript' src='../../eCommon/js/ValidateControl.js'></script>
	<script language='javascript' src="../../eCommon/js/CommonCalendar.js"></script>
	<script language='javascript' src='../../eCommon/js/DateUtils.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	<script>
		/*function validateDate(obj)
		{		
			if(obj.value!='')
			{
				if(validDate(obj.value,'DMY',localeName)==false)
					{
						alert(getMessage("INVALID_DATE_FMT","SM"));					
						obj.value='';
						obj.focus();
						return false;
				}			
			}		
		}*/

		/*function CheckTheDate(Object2,focusflag) 
		{
			var datefield = Object2;
			if(ChkDate(Object2) == false) 
			{
		        //alert("APP-SM0011 - Invalid Date Format");
				alert(getMessage("INVALID_DATE_FMT","SM"));

				if(focusflag == null)
				{
					if(datefield.name == 'p_fm_replace_date')
						document.forms[0].p_fm_replace_date.value = '';
					else if(datefield.name == 'p_to_replace_date')
						document.forms[0].p_to_replace_date.value = '';

					datefield.focus();
				}
		        return false;
			}
		    else
			{
		        return true;
			}
		}*/
		function chkFormat(obj){
	if(obj.value!=''){
		if(obj.name=='p_fm_replace_date1'){			
			document.getElementById('p_fm_replace_date').value=convertDate(document.forms[0].p_fm_replace_date1.value,'DMY',localeName);			
		}else{				
			document.getElementById('p_to_replace_date').value=convertDate(document.forms[0].p_to_replace_date1.value,'DMY',localeName);				
		}
	}else{
		if(obj.name=='p_fm_replace_date1'){			
			document.getElementById('p_fm_replace_date').value="";			
		}else{				
			document.getElementById('p_to_replace_date').value="";
		}
	}
}

async function displayUser(obj,target)
{


	
		var retVal =    new String();
		var argumentArray  = new Array() ;
		var dataNameArray  = new Array() ;
		var dataValueArray = new Array() ;
		var dataTypeArray  = new Array() ;
		var tit = getLabel("Common.RequestedBy.label","Common"); 
		var sql="";

		sql			= " select appl_user_id code, APPL_USER_NAME description from sm_appl_user where  eff_status = 'E' and upper(appl_user_id) like upper(?) and upper(APPL_USER_NAME)  like upper(?) ORDER BY 2";
	
		argumentArray[0] =sql;
		argumentArray[1] = dataNameArray ;
		argumentArray[2] = dataValueArray ;
		argumentArray[3] = dataTypeArray ;
		argumentArray[4] = "1,2";
		argumentArray[5] = document.forms[0].p_requested_by.value;
		argumentArray[6] = DESC_LINK  ;
		argumentArray[7] = DESC_CODE ;
		var retVal = await CommonLookup(tit,argumentArray);
		if (!(retVal == null||retVal == ""))
		{
				
		var ret1=unescape(retVal);
		arr=ret1.split(",");
		target.value=arr[1];
		}
}
	</script>
</HEAD>
<BODY onMouseDown="CodeArrest()" onKeyDown='lockKey()'>
	<br><br>
	<form name="repDRMergedPatientIDs" id="repDRMergedPatientIDs" action="../../eCommon/jsp/report_options.jsp" target="messageFrame">
		
<table width='80%' align='center' valign='top'>
		<th class='columnheader' style="text-align:left;"><fmt:message key="Common.reportcritera.label" bundle="${common_labels}"/></th>
		<tr>
			<td width="100%" class="Border" align='center'>
				
			<table width='70%' cellPadding="0" cellSpacing="0"  align='center' border=0 >
				
				<tr>
				<td>&nbsp;</td>
				<td>&nbsp;</td> 
				</tr>
			
				<tr>
					<td class="label" width='15%' nowrap>&nbsp;</td>
					<td width='33%' class='querydata'><fmt:message key="Common.from.label" bundle="${common_labels}"/></td>
					<td width='33%' class='querydata'><fmt:message key="Common.to.label" bundle="${common_labels}"/></td>
				</tr>
				<tr>
					<td class="label" width='33%' nowrap><fmt:message key="eDR.ReplacementDate.label" bundle="${dr_labels}"/></td>
					<td class='fields' width='33%'>
					   <input type=text  name='p_fm_replace_date1' id='p_fm_replace_date1' value='' maxlength=10 size=10 onBlur="validDateObj(this,'DMY',localeName);chkFormat(this);"><input type="image" src='../../eCommon/images/CommonCalendar.gif' onClick="return showCalendar('p_fm_replace_date1');"><input type='hidden' name='p_fm_replace_date' id='p_fm_replace_date' value=''/>
					</td>
					<td class='fields' width='33%'>
					    <input type=text  name='p_to_replace_date1' id='p_to_replace_date1' value='' maxlength=10 size=10 onBlur="validDateObj(this,'DMY',localeName);chkFormat(this);"><input type="image"  src='../../eCommon/images/CommonCalendar.gif' onClick="return showCalendar('p_to_replace_date1');"><input type='hidden' name='p_to_replace_date' id='p_to_replace_date' value=''/>
					</td>
				</tr>
				
				<tr><td colspan=4>&nbsp;</td></tr>
				
				<tr>
					<td width="33%" class="label"><fmt:message key="Common.filecreated.label" bundle="${common_labels}"/></td>
					<td class='fields' width="33%"><select name='p_include_file' id='p_include_file' >
					<option value='A'><fmt:message key="Common.all.label" bundle="${common_labels}"/></option>
					<option value='Y'><fmt:message key="Common.yes.label" bundle="${common_labels}"/></option>
					<option value='N'><fmt:message key="Common.no.label" bundle="${common_labels}"/></option>
					</select></td>
					<td width="40%">&nbsp;</td>
				</tr>
				
				<tr><td colspan=4>&nbsp;</td></tr>
				
				<!--Added by Ashwini on 11-Jan-2024 for ML-MMOH-CRF-2102-->
				<tr>
				<td width='30%' class="label"><fmt:message key="Common.RequestedBy.label" bundle="${common_labels}"/>&nbsp;&nbsp;</td>
				<td width='20%'><input type="text" name="p_requested_by" id = "p_requested_by" size="30" OnBlur='ChangeUpperCase(this);if(this.value != "") displayUser(requested_by_btn,this);'><input type='button'name='requested_by_btn' value='?' class='button' onclick='displayUser(this,p_requested_by)'>&nbsp;&nbsp;</td>
				</tr>
				
				<tr><td>&nbsp;</td><td>&nbsp;</td></tr>

			</table>
		</td>
	</tr>
</table>
	<input type="hidden" name="p_facility_id" id="p_facility_id" value="<%=p_facility_id%>">
	<input type="hidden" name="p_module_id" id="p_module_id" value="<%=p_module_id%>">
	<input type="hidden" name="p_report_id" id="p_report_id" value="<%=p_report_id%>">
	<input type="hidden" name="p_user_name" id="p_user_name"	value="<%=p_user_name%>">

	<%-- <INPUT TYPE="hidden" name="p_language_id" id="p_language_id" value="<%=localeName%>">	--%>


</form>
</BODY>
</HTML>


