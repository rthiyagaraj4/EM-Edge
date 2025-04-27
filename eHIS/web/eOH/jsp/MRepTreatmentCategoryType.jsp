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
	String module_id = "";
	String module_name = "";

%>

	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
	<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script><script language="javascript" src="../../eCommon/js/common.js"></script>
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="javascript" src="../../eCommon/js/CommonLookup.js"></script>
	<script language="javascript" src="../../eOH/js/MasterReports.js"></script>
	<script language='javascript' src='../../eOH/js/MSpltyTreatmentProc.js'></script>

</head>
<body onMouseDown="CodeArrest()" onKeyDown="lockKey()">
	<br>
	<form name="MReportForm" id="MReportForm" action="../../eCommon/jsp/report_options.jsp" target="messageFrame">
		<table width="70%" align="center" cellpadding="0" cellspacing="0" border="0">
		<th colspan="4" align="left"><fmt:message key="Common.reportcritera.label" bundle="${common_labels}"/></TH>
		<tr>
			<td colspan="4">&nbsp;</td>
		</tr>
		<tr>
			<td align="right" width="25%" class="label"><fmt:message key="eOH.SpecialityModule.Label" bundle="${oh_labels}"/> &nbsp;</td>
			<td align="left">
				<select name="splty_module_id" id="splty_module_id" tabIndex="3" onChange="populateTreatmentCodes(this);">
					<option value=""><fmt:message key="eOH.DefaultSelect.Label" bundle="${oh_labels}"/></option>
				<% 
				try{
					con=ConnectionManager.getConnection(request);
					pstmt=con.prepareStatement("SELECT MODULE_ID, MODULE_NAME FROM SM_MODULE_LANG_VW WHERE MODULE_GROUP_ID = ? AND LANGUAGE_ID=? AND NVL(INSTALL_YN,'X')='Y' ORDER BY MODULE_NAME");
					pstmt.setString(1,"SS");
					pstmt.setString(2,locale);
					rs=pstmt.executeQuery();
					while(rs.next()){
						module_id=rs.getString(1);
						module_name=rs.getString(2);
				%>	
						<option value="<%=module_id%>" > <%=module_name%> </option>
					<% 
					}%>
				</select>
			</td>
		</tr>
		<tr>
			<td colspan="4">&nbsp;</td>
		</tr>
		<tr>
			<td class=label width="25%" nowrap><fmt:message key="eOH.TreatmentCategoryCode.Label" bundle="${oh_labels}"/></td>
			<td class="fields" width="25%" colspan="3" align="left">
				<select name="trmt_category_code" id="trmt_category_code"> 
					<option value=""><fmt:message key="eOH.DefaultSelect.Label" bundle="${oh_labels}"/></option>
				</select>
			</td>
		</tr>
	</table>

	<input type="hidden" name="facility_id" id="facility_id" value="<%= session.getValue( "facility_id" ) %>">
	<input type="hidden" name="p_facility_id" id="p_facility_id" value="<%= session.getValue( "facility_id" ) %>">
	<input type="hidden" name="user_name" id="user_name" value="<%= session.getValue( "login_user" ) %>">
	<input type="hidden" name="module_id" id="module_id" value="OH">
	<input type="hidden" name="p_module_id" id="p_module_id" value="OH">
	<input type="hidden" name="report_id" id="report_id" value="OHRSPTRT">
	<input type="hidden" name="p_report_id" id="p_report_id" value="OHRSPTRT">
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





