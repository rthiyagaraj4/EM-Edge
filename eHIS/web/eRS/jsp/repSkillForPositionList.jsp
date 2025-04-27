<!DOCTYPE html>
<%@ page import="java.sql.*" %>
<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>
<%!
	String p_module_id		= "RS" ;
%>
<html>
<HEAD>
<link rel="stylesheet" type="text/css" href="../../eCommon/html/<%=sStyle%>"></link>
<script language='javascript' src='../../eCommon/js/CommonLookup.js'></script>
<script language='javascript'src='../../eRS/js/RSCommon.js' ></script>
<script src="../../eCommon/js/ValidateControl.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<script>
function getReportId(obj)
{
 var val=obj.value;
 alert(val);
 if(val=='PS')
	 document.form_repSkillForPositionList.p_report_id.value='RSBSKFPS';
 else
	 document.form_repSkillForPositionList.p_report_id.value='RSBSKPS1';

}
function searchSkillForPosition(target1,target2)
{
	var frmObj = document.form_repSkillForPositionList;
	var argumentArray  = new Array() ;
	var dataNameArray  = new Array() ;
	var dataValueArray = new Array() ;
	var dataTypeArray  = new Array() ;
	var obj = target1;
	if(obj == 'P')
		argumentArray[0] = "select position_code code, position_desc description  from am_position where eff_status = 'E' and upper(position_code) like upper(?) and upper(position_desc) like upper(?)order by position_desc ";
	else
		argumentArray[0] = "select skill_code code, skill_desc description  from rs_skill where eff_status = 'E' and upper(skill_code) like upper(?) and upper(skill_desc) like upper(?)order by skill_desc ";

	argumentArray[1] = dataNameArray ;
	argumentArray[2] = dataValueArray ;
	argumentArray[3] = dataTypeArray ;
	argumentArray[4] = "1,2";
	argumentArray[5] = target2.value;
	argumentArray[6] = CODE_LINK ;//CODE_LINK
	argumentArray[7] = CODE_DESC ;//CODE_DESC

	retVal = RSCommonLookup("SkillForPosition", argumentArray );
	if(retVal != null && retVal != "" )  {
	target2.value = retVal[1] ;
if(obj == 'P')
	frmObj.position_code.value = retVal[0];
else
	frmObj.skill_code.value = retVal[0];

	}
}
</script>
</HEAD>

<BODY onKeyDown = 'lockKey()'>
<br>
<br>
<form name="form_repSkillForPositionList" id="form_repSkillForPositionList" action="../../eCommon/jsp/report_options.jsp" target="messageFrame">

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
						<td align="right" class="label" width="20%">Position &nbsp;</td>
						<td  width="30%">
						<input type=text  name='from_position_desc' id='from_position_desc' value="" size="10" onblur="searchSkillForPosition('P',from_workplace_desc)"><input type='button' name='position1' id='position1' value='?' class='button' onclick="searchSkillForPosition('P',from_position_desc)"><input type="hidden" name="position_code" id="position_code" value="">
						</td>
						<td width="50%">
						<input type=text  name='to_position_desc' id='to_position_desc' value="" size="10" onblur="searchSkillForPosition('P',to_position_desc)"><input type='button' name='position2' id='position2' value='?' class='button' onclick="searchSkillForPosition('P',to_position_desc)"><input type="hidden" name="position_code" id="position_code" value="">

						</td>
				</tr>
				<tr>
									<td>&nbsp;</td>
									<Td>&nbsp;</td>
				</tr>
				<tr>
						<td align="right" class="label" width="20%">Skill &nbsp;</td>
						<td  width="30%">
						<input type=text  name='from_skill_desc' id='from_skill_desc' value="" size="10" onblur="searchSkillForPosition('S',from_skill_desc)"><input type='button' name='skill1' id='skill1' value='?' class='button' onclick="searchSkillForPosition('S',from_skill_desc)"><input type="hidden" name="skill_code" id="skill_code" value="">
						</td>
						<td width="50%">
						<input type=text  name='to_skill_desc' id='to_skill_desc' value="" size="10" onblur="searchSkillForPosition('S',to_skill_desc)"><input type='button' name='skill2' id='skill2' value='?' class='button' onclick="searchSkillForPosition('S',to_skill_desc)"><input type="hidden" name="skill_code" id="skill_code" value="">

						</td>
				</tr>
				<tr>
									<td>&nbsp;</td>
									<Td>&nbsp;</td>
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
						<select name='p_order_by' id='p_order_by' onchange="getReportId(this);">
						<option value='PS'>Position,Skill
						<option value='SP'>Skill, Position
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
<input type="hidden" name="p_module_id" id="p_module_id" value="<%= p_module_id %>">
<input type="hidden" name="p_report_id" id="p_report_id" value="">
<input type="hidden" name="pref" id="pref" >
<input type="hidden" name="text" id="text" >
</form>
</BODY>
</HTML>
<%!	
	private String checkForNull(String inputString)
	{
		return (inputString==null)	?	""	:	inputString;
	}
	
	public static String checkForNull(String inputString, String defaultValue)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? defaultValue : inputString);
	}
%>

