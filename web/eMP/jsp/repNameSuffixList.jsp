<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%!
	String p_module_id		= "MP" ;
	String p_report_id		= "MPBNSFFX" ;

%>
<% 
	String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); 
	request.setCharacterEncoding("UTF-8");
	%>

<html>
<head>
<title></title>
<link rel="stylesheet" type="text/css" href="../../eCommon/html/<%=sStyle%>"></link>
<script src="../../eCommon/js/ValidateControl.js"></script>
<script src="../js/MPReportMasterList.js"></script>
<script src='../../eCommon/js/common.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<script>
/*
function callSearch(fromobj,target)
{
			var retVal =    new String();
            var dialogHeight= "28" ;
            var dialogWidth = "43" ;
            var status = "no";
            var arguments   = "";
            var features    = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; scroll=no; status:" + status;
			retVal = window.showModalDialog("../../eMP/jsp/SearchNamePrefixSuffix.jsp?titles=Suffix",arguments,features);
   
    if(retVal != null) 
	{
		retVal = unescape(retVal);
		var arr = retVal.split("`");
		target.value=arr[0];
	
            target.focus();
	}
}
*/
</script>
</head>

<body onMouseDown="CodeArrest();" onKeyDown = 'lockKey()'>
<br>
<br>
<form name="repNameSuffixList" id="repNameSuffixList" action="../../eCommon/jsp/report_options.jsp" target="messageFrame">


<table width='80%' align='center' valign='top'>

		<td class='columnheader' ><fmt:message key="Common.reportcritera.label" bundle="${common_labels}"/></td>
	<tr>
		<td width="80%" class="Border" >
				<table width='80%' cellPadding="3" cellSpacing="0" align='center'>
					<tr>
						<td width="35%">&nbsp;</td>
						<td class="querydata" width="20%"><fmt:message key="Common.from.label" bundle="${common_labels}"/></td>
						<td class="querydata" width="45%" ><fmt:message key="Common.to.label" bundle="${common_labels}"/></td>
					</tr>
					<tr>
						<td class="label" ><fmt:message key="Common.NameSuffix.label" bundle="${common_labels}"/></td>
						<td  class='fields'><input type="text"  name="p_fm_name_suffix" id="p_fm_name_suffix" size="8" maxlength="8"><input type='button' name='nameSuffix' id='nameSuffix' value='?' class='button' onclick='callSearch(this, p_fm_name_suffix)'>
						</td>
						<td class='fields'><input type="text"  name="p_to_name_suffix" id="p_to_name_suffix" size="8" maxlength="8"><input type='button' name='nameSuffix' id='nameSuffix' value='?' class='button' onclick='callSearch(this, p_to_name_suffix)'>
						</td>
					</tr>
					<tr>
						<td class='label' ><fmt:message key="Common.Nature.label" bundle="${common_labels}"/></td>
						<td class='fields' ><select name="p_nature" id="p_nature">
							<option value="B"><fmt:message key="Common.Both.label" bundle="${common_labels}"/>
							<option value="E"><fmt:message key="Common.enabled.label" bundle="${common_labels}"/>
							<option value="D"><fmt:message key="Common.Disabled.label" bundle="${common_labels}"/>
							</select>
						</td>
					</tr>
					<tr>
						<td class='label' ><fmt:message key="Common.orderBy.label" bundle="${common_labels}"/></td>
						<td class='fields'><select name="p_order_by" id="p_order_by">
							<option value="1"><fmt:message key="Common.NameSuffix.label" bundle="${common_labels}"/>
							<option value="4"><fmt:message key="Common.gender.label" bundle="${common_labels}"/>
							</select>
						</td>
					</tr >

				<tr>
						<td>&nbsp;</td>
						<Td>&nbsp;</td>
				</tr>

				</table>
		</td>
	</tr>
</table>
<input type="hidden" name="p_facility_id" id="p_facility_id"		value="<%= session.getValue( "facility_id" ) %>">
<input type="hidden" name="p_module_id" id="p_module_id" 		value="<%= p_module_id %>">
<input type="hidden" name="p_report_id" id="p_report_id" 		value="<%= p_report_id %>">
<input type="hidden" name="p_user_name" id="p_user_name"			value="<%=  session.getValue( "login_user" ) %>">
<%-- <INPUT TYPE="hidden" name="p_language_id" id="p_language_id" value="<%=localeName%>"> --%>
</form>
</body>
</html>

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

