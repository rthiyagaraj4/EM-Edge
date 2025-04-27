<!DOCTYPE html>
<%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<%@ page contentType="text/html;charset=UTF-8" import="java.sql.*" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 

<%
	String p_module_id		= "AM" ;
	String p_report_id		= "AMBSTGDT" ;
	String p_facility_id		= (String) session.getValue( "facility_id" ) ;
	String p_user_name		= (String) session.getValue( "login_user" ) ;
	String locale = (String)session.getAttribute("LOCALE");
	String p_passing_local_date="";

		if(locale.equals("th"))
		{
			p_passing_local_date="Y";
		}else 
		{
			p_passing_local_date="N";
		} 
%>
<html>
<HEAD>
<TITLE></TITLE>
		<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<script src="../../eCommon/js/ValidateControl.js"></script>
<script src="../../eAM/js/SearchPopup.js" language="JavaScript"></script>

<script src='../../eCommon/js/common.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</HEAD>

<BODY onLoad="Focusing('p_fm_stat_grp');" onMouseDown="CodeArrest();" onKeyDown = "lockKey();">
<br>
<br>
<form name="repStatGrpDtl" id="repStatGrpDtl" action="../../eCommon/jsp/report_options.jsp" target="messageFrame">
<table width='60%' align='center' valign='top'>
		
		<th align='left'> <fmt:message key="Common.reportcritera.label" bundle="${common_labels}"/>
		</th>

	<tr>

		<td width="60%" class="Border" align='center'>

				<table width='60%' cellPadding="" cellSpacing="0"  align='center' >

					<tr>
						<td align="center" >&nbsp;</td>
						<td class="fields" ><fmt:message key="Common.from.label" bundle="${common_labels}"/></td>
						<td class="fields" ><fmt:message key="Common.to.label" bundle="${common_labels}"/></td>
					</tr>

					<tr>
						<td align='right' class="label"><fmt:message key="Common.StatisticsGroup.label" bundle="${common_labels}"/>&nbsp;</td>
						<td ><input type=text  name='p_fm_stat_grp' id='p_fm_stat_grp' size="6" maxlength="6" align="center"><input type='button' name='statgrp' id='statgrp' value='?' class='button' onclick='searchCode(this, p_fm_stat_grp)'>
						</td>
						<td > <input type=text  name='p_to_stat_grp' id='p_to_stat_grp' size="6" maxlength="6" align="center"><input type='button' name='statgrp' id='statgrp' value='?' class='button' onclick='searchCode(this, p_to_stat_grp)'>
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
<input type="hidden" name="p_facility_id" id="p_facility_id"		value="<%= p_facility_id %>">
<input type="hidden" name="p_module_id" id="p_module_id" 		value="<%= p_module_id %>">
<input type="hidden" name="p_report_id" id="p_report_id" 		value="<%= p_report_id %>">
<input type="hidden" name="p_user_name" id="p_user_name"		value="<%= p_user_name %>">
<input type='hidden' name='locale' id='locale' value='<%=locale%>'>
</form>
</BODY>
</HTML>

