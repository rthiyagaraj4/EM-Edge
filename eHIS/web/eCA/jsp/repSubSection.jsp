<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%
	

	String p_module_id		= "CA" ;
	String p_report_id		= "CABSUBSC" ;
	String p_facility_id		= (String) session.getValue( "facility_id" ) ;
	String p_user_name		= (String) session.getValue( "login_user" ) ;

%>
<html>
<HEAD>
<TITLE></TITLE>
<%
request.setCharacterEncoding("UTF-8");
String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />
<script src="../../eCommon/js/ValidateControl.js"></script>
<script src="../../eCommon/js/common.js"></script>
<script src='../../eCA/js/repResetRunList.js' language='javascript'></script>
<script src="../../eCommon/js/CommonLookup.js" language="JavaScript"></Script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


</HEAD>

<BODY class='CONTENT' OnMouseDown='CodeArrest()'  onKeyDown = 'lockKey()' onload='FocusFirstElement()'>
<br>
<br>
<form name="repSubSection" id="repSubSection" action="../../eCommon/jsp/report_options.jsp" target="messageFrame">
<table width='80%' align='center' valign='top'>

		<th class='columnheader' align='left' ><fmt:message key="Common.reportcritera.label" bundle="${common_labels}"/>
		</th>

	<tr>

		<td width="100%" class="Border" align='center'>

				<table width='80%' cellPadding="0" cellSpacing="0"  align='center' >

					<tr>
						<td align="center" width="35%">&nbsp;</td>
						<td class="label" width="20%"><fmt:message key="Common.from.label" bundle="${common_labels}"/></td>
						<td align='right' width='10%' >&nbsp;
						</td>
						<td class="label" width="40%"><fmt:message key="Common.to.label" bundle="${common_labels}"/></td>
					</tr>
<!-- 
					<tr>
						<td align='right' width='30%' class="label">Section&nbsp;</td>
						<td width='20%'  ><input type=text  name='p_fr_header_code' id='p_fr_header_code' size="4" maxlength="4" align="center"><input type='button' name='sec' id='sec' value='?' class='button' onclick='searchCode(this, section_code_from)'>
						</td>
						<td width='40%'><input type=text  name='p_to_header_code' id='p_to_header_code' size="4" maxlength="4" align="center"><input type='button' name='sec1' id='sec1' value='?' class='button' onclick='searchCode(this, section_code_to)'>
						</td>
				</tr>

				<tr>
					<td>&nbsp;</td>
					<Td>&nbsp;</td>
				</tr> -->


					<tr>
						<td align='left' width='30%' class="label"><fmt:message key="Common.Section.label" bundle="${common_labels}"/></td>
						<td width='20%'  ><input type=text  name='p_fr_header_code1' id='p_fr_header_code1' size="15" maxlength="30" onblur='search_Codeforsubsection(this, p_fr_header_code1)' align="center"><input type='hidden'  name='p_fr_header_code' id='p_fr_header_code' value=''><input type='button' name='ssec' id='ssec' value='?' class='button' onclick='search_Codeforsubsection(this, p_fr_header_code1)'>
						</td>
						<td align='right' width='10%' >&nbsp;
						</td>
						<td width='40%'><input type=text  name='p_to_header_code1' id='p_to_header_code1' size="15" maxlength="30" onblur='search_Codeforsubsection(this, p_to_header_code1)' align="center"><input type='hidden'  name='p_to_header_code' id='p_to_header_code'   value=''><input type='button' name='ssec1' id='ssec1' value='?' class='button' onclick='search_Codeforsubsection(this, p_to_header_code1)'>
						</td>
				</tr>

				<tr>
					<td>&nbsp;</td>
					<Td>&nbsp;</td>
				</tr>

			<!-- 	<tr>
					<td align='right' width='30%' class="label">Nature &nbsp;</td>
					<td  width='20%' align="left">
						<select name='p_nature' id='p_nature'>
						<option value="B">Both
						<option value="E">Enabled
						<option value="D">Disabled
						</select>
					</td>
				</tr>

<tr>
					<td>&nbsp;</td>
					<Td>&nbsp;</td>
				</tr> -->
				<!-- <tr>
					<td align='right' width='30%' class="label">
						Order By &nbsp;
					</td>
					<td  width='20%' align="left">
						<select name='p_order_by' id='p_order_by'>
						<option value='1'>Code
						<option value='2'>Description
						</select>
					</td>
				</tr>
				<tr>
					<td>&nbsp;</td>
					<Td>&nbsp;</td>
				</tr> -->
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

