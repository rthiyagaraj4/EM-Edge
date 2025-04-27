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
	String sql = "";

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
		<table width="70%" align="center" cellpadding="0" cellspacing="0" border="0">
		<th colspan="4" align="left"><fmt:message key="Common.reportcritera.label" bundle="${common_labels}"/></TH>
		<tr>
			<td colspan="4">&nbsp;</td>
		</tr>
		<tr>
			<td align="right" width="25%" class="label"><fmt:message key="eOH.SiteType.Label" bundle="${oh_labels}"/> &nbsp;</td>
			<td align="left">
			<select name="p_site_type" id="p_site_type" tabIndex="3">
				<option value=""><fmt:message key="Common.all.label" bundle="${common_labels}"/></option>
				<% 
				try{
					String site_type_code = "";
					String site_type_desc = "";
					con=ConnectionManager.getConnection(request);
					sql="SELECT SITE_TYPE, SITE_DESC FROM OH_SITE_TYPE_LANG_VW WHERE LANGUAGE_ID=? ORDER BY SITE_DESC";
					pstmt=con.prepareStatement(sql);
					pstmt.setString(1,locale);
					rs=pstmt.executeQuery();
					while(rs.next()){
						site_type_code=rs.getString(1);
						site_type_desc=rs.getString(2);
				%>	
						<option value= "<%=site_type_code%>"> <%=site_type_desc%> </option>
					<% 
					}%>
					</select>
					
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
	<input type="hidden" name="report_id" id="report_id" value="OHRSTYPE">
	<input type="hidden" name="p_report_id" id="p_report_id" value="OHRSTYPE">
	<input type="hidden" name="language_id" id="language_id" value="<%=locale%>">
	<input type="hidden" name="locale" id="locale" value="<%=locale%>">
	
</form>
</body>
</html>





