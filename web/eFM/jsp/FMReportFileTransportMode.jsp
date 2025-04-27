<!DOCTYPE html>
<%@ page import="java.sql.*"  contentType="text/html; charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<%
	String p_module_id		= "FM" ;
	String p_report_id		= "FMBFLTMD" ;
	String p_facility_id	= (String) session.getValue( "facility_id" ) ;
	String p_user_name		= (String) session.getValue( "login_user" ) ;
%>

<html>
<HEAD>
<TITLE></TITLE>
<!-- <link rel="stylesheet" type="text/css" href="../../eCommon/html/IeStyle.css"></link> -->
<%
	request.setCharacterEncoding("UTF-8");
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<script src="../../eCommon/js/ValidateControl.js"></script>
<script language='javascript' src='../../eCommon/js/common.js' ></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<script>
async function searchCode(obj,target)
	{
			var retVal = 	new String();
			var dialogHeight= "28" ;
			var dialogWidth	= "43" ;
			var status = "no";
			var arguments	= "" ;
			var sql="";
			var search_code="";
			var search_desc="";
			var tit="";
			
			//alert(obj.name)
			if(obj.name=="TransportFrom")
			{
				tit="Transport Mode"
				sql="select file_transport_mode,short_desc from fm_file_transport_mode  where EFF_STATUS=`E` ";
				search_code="file_transport_mode";
				search_desc= "short_desc";
			}
		
			if(obj.name=="TransportTo")
			{
				tit="Transport Mode"
				sql="select file_transport_mode,short_desc from fm_file_transport_mode ";
				search_code="file_transport_mode";
				search_desc= "short_desc";
			}
		
			var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; scroll=no; status:" + status;
			retVal =await window.showModalDialog("../../eCommon/jsp/GeneralSearch.jsp?SQL="+sql+"&search_code="+search_code+"&search_desc="+search_desc+"&title="+encodeURIComponent(tit),arguments,features);

			if (!(retVal == null))
			{
				target.value=retVal;
			}
			else
				target.focus();
	}
</script>
</HEAD>

<BODY onMouseDown="CodeArrest();"  onload='document.forms[0].p_from_code.focus();' onKeyDown = 'lockKey();'>
<br>
<br>
<form name="reportTransport" id="reportTransport" action="../../eCommon/jsp/report_options.jsp" target="messageFrame">
<table width='80%' align='center' valign='top'>

		<td class='columnheader'> <fmt:message key="Common.reportcritera.label" bundle="${common_labels}"/></td>

	<tr>												   
		<td width="100%" class="Border" align='center'>

				<table width='80%' cellPadding="0" cellSpacing="0"  align='center' >

					<tr>
						<td align="center" width="35%">&nbsp;</td>
						<td class="querydata" width="20%"><fmt:message key="Common.from.label" bundle="${common_labels}"/></td>
						<td class="querydata" width="40%"><fmt:message key="Common.to.label" bundle="${common_labels}"/></td>
					</tr>

					<!-- <tr>
						<td width='30%' class="label">Facility ID&nbsp;</td>
						<td width='20%'  ><input type=text  name='p_fm_facility_id' id='p_fm_facility_id' size="2" maxlength="2" align="center"><input type='button' name='facility' id='facility' value='?' class='button' onclick='searchCode(this, p_fm_facility_id)'>
						</td>
						<td width='40%'> <input type=text  name='p_to_facility_id' id='p_to_facility_id' size="2" maxlength="2" align="center"><input type='button' name='facility' id='facility' value='?' class='button' onclick='searchCode(this, p_to_facility_id)'>
						</td>
				</tr>
 -->
				<tr>
						<td width='30%' class="label"><fmt:message key="Common.FileTransportMode.label" bundle="${common_labels}"/>&nbsp;</td>
						<td width='20%' class='fields' ><input type=text  tabIndex='1' name='p_from_code' id='p_from_code' size="8" maxlength="8" onKeyPress='return CheckForSpecChars(event)' onBlur='ChangeUpperCase(this);' align="center"><input type='button' name='TransportFrom' id='TransportFrom' value='?' class='button' 
						onclick='searchCode(this, p_from_code)'>						
						</td>
						<td width='40%' class='fields'> <input type=text  tabIndex='2' name='p_to_code' id='p_to_code' size="8" maxlength="8" onKeyPress='return CheckForSpecChars(event)' onBlur='ChangeUpperCase(this);' align="center"><input type='button' name='TransportTo' id='TransportTo' value='?' class='button'
						onclick='searchCode(this, p_to_code)'>
						</td>
				</tr>
				
								<tr>
									<td>&nbsp;</td>
									<Td>&nbsp;</td>
				</tr>
												
				<tr>
					<td  width='30%' class="label"><fmt:message key="Common.Nature.label" bundle="${common_labels}"/></td>
					<td  width='20%' class='fields' >
						<select name='p_eff_status' id='p_eff_status' tabIndex='3'>
						<option value="B"><fmt:message key="Common.Both.label" bundle="${common_labels}"/></option>
						<option value="E"><fmt:message key="Common.enabled.label" bundle="${common_labels}"/></option>
						<option value="D"><fmt:message key="Common.Disabled.label" bundle="${common_labels}"/></option>
						</select>
					</td>
				</tr>
	<tr>
					<td>&nbsp;</td>
					<Td>&nbsp;</td>
				</tr>
				<tr>
					<td  width='30%' class="label"><fmt:message key="Common.orderBy.label" bundle="${common_labels}"/></td>
					<td  width='20%' class='fields'><select name='p_order_by' id='p_order_by' tabIndex='4'>
						<option value='1'><fmt:message key="Common.FileTransportMode.label" bundle="${common_labels}"/> </option>
						<option value='2'><fmt:message key="eFM.FileTransportModeDescription.label" bundle="${fm_labels}"/></option>
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

	<input type="hidden" name="p_facility_id" id="p_facility_id"	value="<%= p_facility_id %>">
	<input type="hidden" name="p_module_id" id="p_module_id" 	value="<%= p_module_id %>">
	<input type="hidden" name="p_report_id" id="p_report_id" 	value="<%= p_report_id %>">
	<input type="hidden" name="p_user_name" id="p_user_name"		value="<%= p_user_name %>">

</form>
</BODY>
</HTML>

