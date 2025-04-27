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

	Connection con=null;
	PreparedStatement pstmt=null;
	ResultSet rs=null;
try{
	String clinical_group_code = "";
	String clinical_group_desc = "";
	con=ConnectionManager.getConnection(request);

%>

	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
	<Script src="../../eCommon/js/showModalDialog.js" language="JavaScript"></Script><script language="javascript" src="../../eCommon/js/common.js"></script>
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="javascript" src="../../eCommon/js/CommonLookup.js"></script>
	<script language="javascript" src="../../eOH/js/MasterReports.js"></script>
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
			<td width="22%" class="label"><fmt:message key="eOH.ClinicalGroupCodeFrom.Label" bundle="${oh_labels}"/> &nbsp;</td>
			<td width="22%" class="field">
			<select name="p_clinical_group_code_from" id="p_clinical_group_code_from">
				<option value=""><fmt:message key="Common.all.label" bundle="${common_labels}"/></option>
				<% 
				try{
					pstmt=con.prepareStatement("SELECT CLINICAL_GROUP_CODE, CLINICAL_GROUP_DESC FROM OH_CLINICAL_GROUP_LANG_VW WHERE LANGUAGE_ID=? ORDER BY CLINICAL_GROUP_DESC");
					pstmt.setString(1,locale);
					rs=pstmt.executeQuery();
					while(rs.next()){
						clinical_group_code=rs.getString(1);
						clinical_group_desc=rs.getString(2);
				%>	
						<option value= "<%=clinical_group_code%>"> <%=clinical_group_desc%> </option>
					<% 
					}%>
				<% 
				}catch(Exception e){
					out.println("exp"+e);
				}finally{
					try{
						if(rs!=null) rs.close();
						if(pstmt!=null) pstmt.close();
					}catch(Exception e){
						out.println("exp"+e);
					}
				}
			%>		
			</select>&nbsp;
			</td>
			<td width="22%" class="label"><fmt:message key="Common.to.label" bundle="${common_labels}"/> &nbsp;</td>
			<td width="22%" class="field">&nbsp;
			<select name="p_clinical_group_code_to" id="p_clinical_group_code_to">
				<option value=""><fmt:message key="Common.all.label" bundle="${common_labels}"/></option>
				<% 
				try{
					pstmt=con.prepareStatement("SELECT CLINICAL_GROUP_CODE, CLINICAL_GROUP_DESC FROM OH_CLINICAL_GROUP_LANG_VW WHERE LANGUAGE_ID=? ORDER BY CLINICAL_GROUP_DESC");
					pstmt.setString(1,locale);
					rs=pstmt.executeQuery();
					while(rs.next()){
						clinical_group_code=rs.getString(1);
						clinical_group_desc=rs.getString(2);
				%>	
						<option value= "<%=clinical_group_code%>"> <%=clinical_group_desc%> </option>
					<% 
					}%>
				<% 
				}catch(Exception e){
					out.println("exp"+e);
				}finally{
					try{
						if(rs!=null) rs.close();
						if(pstmt!=null) pstmt.close();
					}catch(Exception e){
						out.println("exp"+e);
					}
				}
			%>		
			</select>
			</td>
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
	<input type="hidden" name="report_id" id="report_id" value="OHRCLGRP">
	<input type="hidden" name="p_report_id" id="p_report_id" value="OHRCLGRP">
	<input type="hidden" name="language_id" id="language_id" value="<%=locale%>">
	<input type="hidden" name="locale" id="locale" value="<%=locale%>">
	
</form>
</body>
</html>
<% 
}catch(Exception e){
	out.println("exp"+e);
}finally{
	try{
		if(rs!=null) rs.close();
		if(pstmt!=null) pstmt.close();
		ConnectionManager.returnConnection(con);
	}catch(Exception e){
		out.println("exp"+e);
	}
}
%>		

