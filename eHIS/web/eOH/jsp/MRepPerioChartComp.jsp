<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8"%>              
<% request.setCharacterEncoding("UTF-8");%>
<%@ page  import= "eOT.*, eOT.Common.*,eCommon.Common.*,java.sql.Connection,java.sql.PreparedStatement,java.sql.ResultSet,webbeans.eCommon.ConnectionManager,eOT.*" %>
 <% request.setCharacterEncoding("UTF-8"); %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
<head>
<%
	String locale	= (String)session.getAttribute("LOCALE");
    String sStyle=(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?
   (String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	String fromCompCode = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOH.ComponentCodeFrom.Label","oh_labels");
	String toCompCode = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.to.label","common_labels");
%>

	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
	<script language="javascript" src="../../eCommon/js/common.js"></script>
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="javascript" src="../../eCommon/js/CommonLookup.js"></script>
	<script language="javascript" src="../../eOH/js/MasterReports.js"></script>
 	<script language='javascript' src='../../eOH/js/OHReportsLkupSQL.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
 
</head>
<body onMouseDown="CodeArrest()" onKeyDown="lockKey()">
	<br>
	<form name="MReportForm" id="MReportForm" action="../../eCommon/jsp/report_options.jsp" target="messageFrame">
		<table width="98%" align="center" cellpadding="0" cellspacing="0" border="0">
		<th colspan="4" align="left"><fmt:message key="Common.reportcritera.label" bundle="${common_labels}"/></TH>
		<tr>
			<td colspan="4">&nbsp;</td>
		</tr>
<tr>
			<td width="22%" class="label"><fmt:message key="eOH.ComponentCodeFrom.Label" bundle="${oh_labels}"/> &nbsp;</td>

		    <td class='fields' width='25%'>
				<input type='hidden' name='param6' id='param6' value=""> 
				<input type='hidden' name="P_COMP_CODE_FROM" id="P_COMP_CODE_FROM" value=""> 
				<input type='text' name='param5_desc' id='param5_desc' size='25' title='<%=fromCompCode%>'  param1 = 'P_COMP_CODE_FROM'  param2 = 'param6' key ='PERIO_DON_CHART_COMP' onBlur="if(this.value!='')callCommonMasterLookup(this); else P_COMP_CODE_FROM.value='',param6.value='' "> 
				<input type='button' class='button' value='?' name='FromTrmtCatTypeLookUp' id='FromTrmtCatTypeLookUp' onClick="callCommonMasterLookup(param5_desc);">
					
					
			</td>
			<td width="22%" class="label" align ="center"><fmt:message key="Common.to.label" bundle="${common_labels}"/> &nbsp;</td>
			<td class='fields' width='25%'>
				<input type='hidden' name='param8' id='param8' value=""> 
				<input type='hidden' name="P_COMP_CODE_TO" id="P_COMP_CODE_TO" value=""> 
				<input type='text' name='param7_desc' id='param7_desc' size='25' title='<%=toCompCode%>'  param1 = 'P_COMP_CODE_TO'  param2 = 'param8' key ='PERIO_DON_CHART_COMP' onBlur="if(this.value!='')callCommonMasterLookup(this); else P_COMP_CODE_TO.value='',param8.value='' "> 
				<input type='button' class='button' value='?' name='ToTrmtCatTypeLookUp' id='ToTrmtCatTypeLookUp' onClick="callCommonMasterLookup(param7_desc);">
	
					
			</td>
</tr>
<tr>
			<td width="22%" class="label"><fmt:message key="eOH.SurfaceApplcalbeYN.Label" bundle="${oh_labels}"/> &nbsp;</td>
			<td align="left" width="25%">
			<select name="P_SURF_APPL_YN" id="P_SURF_APPL_YN">
				<option value=""><fmt:message key="Common.Both.label" bundle="${common_labels}"/></option>
				<option value="Y"><fmt:message key="Common.yes.label" bundle="${common_labels}"/></option>
				<option value="N"><fmt:message key="Common.no.label" bundle="${common_labels}"/></option>
				</select>
			</td>
			<td width="22%" class="label" align ="center"></td>
			<td class='fields' width='25%'></td>
</tr>
		<tr>
			<td colspan="4">&nbsp;</td>
		</tr>
	</table>

	<input type="hidden" name="facility_id" id="facility_id" value="<%= session.getValue( "facility_id" ) %>">
	<input type="hidden" name="p_facility_id" id="p_facility_id" value="<%= session.getValue( "facility_id" ) %>">
	<input type="hidden" name="user_name" id="user_name" value="<%= session.getValue( "login_user" ) %>">
	<input type="hidden" name="module_id" id="module_id" value="OH">
	<input type="hidden" name="p_module_id" id="p_module_id" value="OH">
	<input type="hidden" name="report_id" id="report_id" value="OHRPCHCP">
	<input type="hidden" name="p_report_id" id="p_report_id" value="OHRPCHCP">
	<input type="hidden" name="language_id" id="language_id" value="<%=locale%>">
	<input type="hidden" name="locale" id="locale" value="<%=locale%>">
	
</form>
</body>
</html>

