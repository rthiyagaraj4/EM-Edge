<!DOCTYPE html>
<%@ page import="java.sql.*" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%
    request.setCharacterEncoding("UTF-8");
	String p_module_id		= "AE" ;
	String p_report_id		= "AEBGCSSR" ;
	String p_facility_id	= (String) session.getValue( "facility_id" ) ;
	String p_user_name		= (String) session.getValue( "login_user" ) ;
%>

<html>

<HEAD>
<TITLE></TITLE>
<% String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<script src="../../eCommon/js/common.js"></script>
<script src="../../eCommon/js/ValidateControl.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


</HEAD>

<BODY onMouseDown='CodeArrest()' onKeyDown = 'lockKey()'>
<br>
<br>
<form name="repGCSResponseScoreList" id="repGCSResponseScoreList" action="../../eCommon/jsp/report_options.jsp" target="messageFrame">
<table width='80%' align='center' valign='top'>

		<th align='left'> <fmt:message key="Common.reportcritera.label" bundle="${common_labels}"/>
		</th>

	<tr>

		<td width="80%" class="Border" align='center'>

				<table width='85%' cellPadding="0" cellSpacing="0" align='center'>
				<tr>
					<td  class='label' width="50%">
						<fmt:message key="eAE.GCSScore.label" bundle="${ae_labels}"/> 
					</td>
					<td width="50%">
						<select name='P_GCS_CATEGORY' id='P_GCS_CATEGORY'>
						<option value='4'><fmt:message key="Common.all.label" bundle="${common_labels}"/>
						<option value='1'><fmt:message key="eAE.EyeResponse.label" bundle="${ae_labels}"/>
						<option value='2'><fmt:message key="eAE.VerbalResponse.label" bundle="${ae_labels}"/>
						<option value='3'><fmt:message key="eAE.MotorResponse.label" bundle="${ae_labels}"/>

						</select>
					</td>
				</tr>
				<tr>
				<td width="50%" colspan=2>&nbsp;</td>
				<td width="50%"></td>
					</tr>
		</table>
	</td>
</tr>
</table>
<input type="hidden" name="p_facility_id" id="p_facility_id"		value="<%= p_facility_id %>">
<input type="hidden" name="p_module_id" id="p_module_id" 		value="<%= p_module_id %>">
<input type="hidden" name="p_report_id" id="p_report_id" 		value="<%= p_report_id %>">
<input type="hidden" name="p_user_name" id="p_user_name"			value="<%= p_user_name %>">
</form>
</body>
</html>

