<!DOCTYPE html>
<%@ page import ="java.sql.*,java.net.*,webbeans.eCommon.*,java.text.*" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<HTML>
<HEAD>
	<%
     String sStyle	=
     (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	 request.setCharacterEncoding("UTF-8");

%>

<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
	<script language='javascript' src="../../eCommon/js/ValidateControl.js"></script>
	<script language='javascript' src='../../eCommon/js/common.js'></script>
	
	<script language='javascript' src='../../eMO/js/MOAreaAvailabilityQueryCriteria.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</HEAD>
<BODY onLoad="focusField()" onKeyDown = 'lockKey()'> 
<form name="AreaAvailForm" id="AreaAvailForm" target="messageFrame">
<table width='100%' align='center' valign='top'>
	<th class='columnheader' align='left'><fmt:message key="Common.QueryCriteria.label" bundle="${common_labels}"/></th>
	<tr>
		<td width="100%" class="Border" align='center'>
			<table width='100%' cellPadding="0" cellSpacing="0"  align='left' border="0">
   	<tr>
					<td class='LABEL' width='12%'><fmt:message key="eMO.AreaType.label" bundle="${mo_labels}"/></td>
					<td width='25%'><select name='Area_Type' id='Area_Type' onchange ='selarea(this);'>
					<option value=''>------ <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> ------</option>
					<option value='P'><fmt:message key="eMO.PostmortemArea.label" bundle="${mo_labels}"/></option>
					<option value='R'><fmt:message key="eMO.ReleaseArea.label" bundle="${mo_labels}"/></option>
					<option value='S'><fmt:message key="eMO.StorageArea.label" bundle="${mo_labels}"/></option>
					<option value='O'><fmt:message key="Common.others.label" bundle="${common_labels}"/></option>
					</td>
        <td class='LABEL' width='12%'><fmt:message key="Common.area.label" bundle="${common_labels}"/></td>
		<td width='25%'><select name='area_code' id='area_code'>
        <option value=''>------ <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> ------</option>
		</select></td>	</tr>
		<tr>
		<td align='right'  colspan=4>
		<input type='button' name='search' id='search' value='<fmt:message key="Common.search.label" bundle="${common_labels}"/>' class='button' onClick='submitPage();'>
		<input type='button' name='clear' id='clear'  value='<fmt:message key="Common.clear.label" bundle="${common_labels}"/>'  class='button' onclick='clearAll()'>
		</td>
		</tr>
	</table>
</table>
</form>
</BODY>
</HTML>

