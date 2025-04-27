<!DOCTYPE html>
<%@ page import ="java.sql.*,java.util.*,oracle.jdbc.driver.*,java.net.*,java.text.*,webbeans.eCommon.*" %>
<% String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
 %>
<%!
	String p_module_id		= "RS" ;
	String p_report_id		= "RSBACCESSRIGHTS" ;
	//String p_facility_id	= (String) session.getValue( "facility_id" ) ;
	//String p_user_name		= (String) session.getValue( "login_user" ) ;
%>
<html>

<HEAD>

<TITLE></TITLE>
<link rel="stylesheet" type="text/css" href="../../eCommon/html/<%=sStyle%>"></link>
<script language='javascript' src='../../eCommon/js/CommonLookup.js'></script>
<script language='javascript'src='../../eRS/js/RSCommon.js' ></script>
<script src="../../eCommon/js/ValidateControl.js"></script>
<script src="../../eRS/js/repRSMasterList.js" language="javascript"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<script>
function searchAccessRights(target1,target2)
{
	var argumentArray  = new Array() ;
	var dataNameArray  = new Array() ;
	var dataValueArray = new Array() ;
	var dataTypeArray  = new Array() ;
	var obj = target1;
	if(obj == 'W')
	{
	argumentArray[0] = "select workplace_code code,  workplace_desc description  from rs_workplace where eff_status = 'E' and upper(workplace_code) like upper(?) and upper(workplace_desc) like upper(?)order by workplace_desc ";
	}else
	{
	argumentArray[0] = "select a.appl_user_id code, b.appl_user_name description from sm_facility_for_user a, sm_appl_user b where b.appl_user_id = a.appl_user_id and b.eff_status = 'E' and sysdate between nvl(a.access_eff_date_from, sysdate) and nvl(a.access_eff_date_to, sysdate) and upper(a.appl_user_id) like upper(?) and upper(b.appl_user_name) like upper(?)order by description";
	}

	argumentArray[1] = dataNameArray ;
	argumentArray[2] = dataValueArray ;
	argumentArray[3] = dataTypeArray ;
	argumentArray[4] = "1,2";
	argumentArray[5] = target2.value;
	argumentArray[6] = CODE_LINK ;//CODE_LINK
	argumentArray[7] = CODE_DESC ;//CODE_DESC

	retVal = RSCommonLookup("Access Rights", argumentArray );
	if(retVal != null && retVal != "" )  {
	target2.value = retVal[1] ;
	}
}


</script>
</HEAD>

<BODY onKeyDown = 'lockKey()'>
<br>
<br>
<form name="form_repAccessRightsList" id="form_repAccessRightsList" action="../../eCommon/jsp/report_options.jsp" target="messageFrame">

<table width='80%' align='center' valign='top'>

		<th align='left'> Report Criteria
		</th>

	<tr>

		<td width="100%" class="Border" align='center'>

				<table width='80%' cellPadding="0" cellSpacing="0" align='center'>
					<tr>
						<td align="left" width="35%">&nbsp;</td>
						<td class="label"  align="left"  width="20%">From</td>
						<td class="label" align="left"  width="40%">To</td>
					</tr>
					<tr>
						<td align="right" class="label" width="20%">Workplace &nbsp;</td>
						<td  width="30%">
						&nbsp;<input type=text  name='from_workplace_desc' id='from_workplace_desc' value="" size="10" maxlength="10" onblur="searchAccessRights('W',from_workplace_desc)"><input type='button' name='workplace1' id='workplace1' value='?' class='button' onclick="searchAccessRights('W',from_workplace_desc)">&nbsp;<input type="hidden" name="workplace_code" id="workplace_code" value="">
						</td>
						<td width="50%">
						<input type=text  name='to_workplace_desc' id='to_workplace_desc' value="" size="10" maxlength="10" onblur="searchAccessRights('W',to_workplace_desc)"><input type='button' name='workplace2' id='workplace2' value='?' class='button' onclick="searchAccessRights('W',to_workplace_desc)"><input type="hidden" name="workplace_code" id="workplace_code" value="">

						</td>
				</tr>
				<tr>
									<td>&nbsp;</td>
									<Td>&nbsp;</td>
				</tr>
				<tr>
					<td align="right" class="label" width="20%">User &nbsp;</td>
						<td  width="30%">
						&nbsp;<input type=text  name='from_user_desc' id='from_user_desc' value="" size="10"  onblur="searchAccessRights('S',from_user_desc)"><input type='button' name='workplace1' id='workplace1' value='?' class='button' onclick="searchAccessRights('S',from_user_desc)">&nbsp;<input type="hidden" name="workplace_code" id="workplace_code" value="">
						</td>
						<td width="50%">
						<input type=text  name='to_user_desc' id='to_user_desc' value="" size="10"  onblur="searchAccessRights('S',to_user_desc)"><input type='button' name='workplace2' id='workplace2' value='?' class='button' onclick="searchAccessRights('S',to_user_desc)"><input type="hidden" name="workplace_code" id="workplace_code" value="">

						</td>
				</tr>

<tr>
					<td>&nbsp;</td>
					<Td>&nbsp;</td>
				</tr>
				<tr>
					<td align="right" width='30%' class="label">
						Order By &nbsp;
					</td>
					<td width='20%' align="left">
						&nbsp;<select name='p_order_by' id='p_order_by'>
						<option value='WU'>WorkPlace,User
						<option value='UW'>User, WorkPlace
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
<!-- <input type="hidden" name="p_facility_id" id="p_facility_id"		value="<%= session.getValue( "facility_id" ) %>">
<input type="hidden" name="p_user_name" id="p_user_name"			value="<%=  session.getValue( "login_user" ) %>"> -->
<input type="hidden" name="p_module_id" id="p_module_id" 		value="<%= p_module_id %>">
<input type="hidden" name="p_report_id" id="p_report_id" 		value="<%= p_report_id %>">
<input type="hidden" name="pref" id="pref" >
<input type="hidden" name="text" id="text" >
</form>
</BODY>
</HTML>



