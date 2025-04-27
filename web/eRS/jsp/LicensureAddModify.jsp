<!DOCTYPE html>
<!-- LicensureAddModify.jsp-->
<!--
*	Copyright  MEDICOM Solutions (P) Ltd. ALL RIGHTS RESERVED
*	Application		:	eRS
*	Purpose 		:	to add or modify the Licensure data
*	Created By		:	suri
*	Created On		:	17 jan 07
-->
<%-- JSP Page specific attributes start --%>
<%@ page language="java" contentType="text/html;charset=UTF-8" import ="java.sql.*, webbeans.eCommon.*,java.net.*,java.util.*, eRS.*"%>
<%-- JSP Page specific attributes end --%>
<%-- Mandatory declarations start --%>
<%-- Remarks --This gives handle to  CommonMultipleHandler Bean with id=>mh--%>

<%@ include file="../../eCommon/jsp/Common.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<%-- Mandatory declarations end --%>
<%
request.setCharacterEncoding("UTF-8");
String locale			= (String)session.getAttribute("LOCALE");
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";%>
<html>
<head>
<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
	<script language="JavaScript" src="../../eCommon/js/common.js"></script>
	<!-- <script language="JavaScript" src="../../eCommon/js/MstCodeCommon.js"></script> -->
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="javascript" src="../js/Licensure.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	
</head>
<%
String mode	= request.getParameter("mode");
String operation_type="";
%>
<body  onload='FocusFirstElement()' onMouseDown="CodeArrest()" onKeyDown="lockKey()" >
	<br><br><br><br><br>
	<form name='form_LicensureAddModify' id='form_LicensureAddModify' target='messageFrame' method='post'  action='../../servlet/eRS.LicensureServlet' >
<%
	if(mode.equalsIgnoreCase("1")){
	operation_type="insert";
%>
	<table cellpadding=0 cellspacing=0 border=0 width="80%" align=center>
		<tr>
		<td colspan="5">&nbsp;</td>
		</tr>
		<tr>
			<td  width="20%"  align=right class="label"><fmt:message key="Common.code.label" bundle="${common_labels}"/></td>
			<td  width="60%"  align=left class="label">&nbsp;&nbsp;&nbsp;&nbsp;<input type="text" name='license_code' id='license_code' value='' size='10' maxlength='10' onKeyPress="return CheckForSpecChars(event)" >&nbsp;<img src="../../eCommon/images/mandatory.gif"></td>
		</tr>
		<tr>
			<td  width="20%"  align=right class="label"><fmt:message key="Common.description.label" bundle="${common_labels}"/></td>
			<td  width="60%"  align=left class="label">&nbsp;&nbsp;&nbsp;&nbsp;<input type="text" name="license_desc" id="license_desc" value='' size='30' maxlength='30'>&nbsp;<img src="../../eCommon/images/mandatory.gif"></td>
		</tr>
		<tr>
			<td  width="20%"  align=right class="label"><fmt:message key="Common.ExplanatoryText.label" bundle="${common_labels}"/></td>
			<td  width="60%"  align=left class="label">&nbsp;&nbsp;&nbsp;&nbsp;<textarea name="license_expl_text"  rows='11'cols='45' onblur='checkForMax(this);'></textarea></td>
		</tr>
		<tr>
			<td  width="20%"  align=right class="label"><fmt:message key="Common.enabled.label" bundle="${common_labels}"/></td>
			<td  width="60%"  align=left class="label">&nbsp;&nbsp;&nbsp;<input type="checkbox" name='eff_status' id='eff_status' checked value="E" onclick="checkActive(this);"></td>
		</tr>
		<tr>
		<td colspan="5">&nbsp;</td>
		</tr>
	</table>
	<%}
		else
		{
			operation_type="modify";

			Connection conn=null;
			PreparedStatement pstmt_expl_text=null;
			ResultSet rs_expl_text=null;

			conn = ConnectionManager.getConnection(request);	

			String sql_expl_text="";
			String license_code=request.getParameter("license_code");
			String license_desc="";
    		String license_expl_text="";
			String eff_status="";
try
{
//sql_expl_text="select license_expl_text,license_desc,eff_status from rs_licensure where license_code=?";
sql_expl_text="select license_expl_text,license_desc,eff_status from rs_licensure_lang_vw where license_code=? And language_id = ?";
pstmt_expl_text=conn.prepareStatement(sql_expl_text);
pstmt_expl_text.setString(1,license_code);
pstmt_expl_text.setString(2,locale);

rs_expl_text=pstmt_expl_text.executeQuery();

while(rs_expl_text.next())
	{
		license_expl_text=rs_expl_text.getString("license_expl_text")==null ? "":rs_expl_text.getString("license_expl_text");
		license_desc=rs_expl_text.getString("license_desc")==null ? "":rs_expl_text.getString("license_desc");
		eff_status=rs_expl_text.getString("eff_status")==null ? "":rs_expl_text.getString("eff_status");
	}
}catch(Exception e)
{
	e.printStackTrace();
}
finally
{
	if (rs_expl_text != null)   rs_expl_text.close();
	if (pstmt_expl_text != null) pstmt_expl_text.close();
	ConnectionManager.returnConnection(conn,request);
}
%>
	<table cellpadding=0 cellspacing=0 border=0 width="80%" align=center>
		<tr>
		<td colspan="5">&nbsp;</td>
		</tr>
		<tr>
			<td  width="20%"  align=right class="label"><fmt:message key="Common.code.label" bundle="${common_labels}"/></td>
			<td  width="60%"  align=left class="label">&nbsp;&nbsp;&nbsp;&nbsp;<input type="text" name='license_code' id='license_code' value='<%=license_code%>' size='10' maxlength='10' readonly onKeyPress="return CheckForSpecChars(event)" >&nbsp;<img src="../../eCommon/images/mandatory.gif"></td>
		</tr>
		<tr>
			<td  width="20%"  align=right class="label"><fmt:message key="Common.description.label" bundle="${common_labels}"/></td>
		<%if(eff_status.equals("E"))
			{%>
			<td  width="60%"  align=left class="label">&nbsp;&nbsp;&nbsp;&nbsp;<input type="text" name="license_desc" id="license_desc" value='<%=license_desc%>' size='30' maxlength='30'>&nbsp;<img src="../../eCommon/images/mandatory.gif"></td>
		<%}else{%>
			<td  width="60%"  align=left class="label">&nbsp;&nbsp;&nbsp;&nbsp;<input type="text" name="license_desc" id="license_desc" value='<%=license_desc%>' size='30' maxlength='30' readonly>&nbsp;<img src="../../eCommon/images/mandatory.gif"></td>
		<%}%>
		</tr>
		<tr>
			<td  width="20%"  align=right class="label"><fmt:message key="Common.ExplanatoryText.label" bundle="${common_labels}"/></td>
		<%if(eff_status.equals("E"))
			{%>
			<td  width="60%"  align=left class="label">&nbsp;&nbsp;&nbsp;&nbsp;<textarea name="license_expl_text"  rows='11'cols='45' onblur='checkForMax(this);'><%=license_expl_text%></textarea></td>
		<%}else{%>
			<td  width="60%"  align=left class="label">&nbsp;&nbsp;&nbsp;&nbsp;<textarea name="license_expl_text"  rows='11'cols='45' maxlength='4000' readonly><%=license_expl_text%></textarea></td>
				<%}%>
		</tr>
		<tr>
			<td  width="20%"  align=right class="label"><fmt:message key="Common.enabled.label" bundle="${common_labels}"/></td>
				<%if(eff_status.equals("E"))
			{%>
			<td  width="60%"  align=left >&nbsp;&nbsp;&nbsp;<input type="checkbox" name='eff_status' id='eff_status' checked value="<%=eff_status%>" onclick="checkActive(this);"></td>
			<%}else{%>
			<td  width="60%"  align=left class="label">&nbsp;&nbsp;&nbsp;<input type="checkbox" name='eff_status' id='eff_status' value="<%=eff_status%>" onclick="checkActive(this);"></td>
			<%}%>
		</tr>
		<tr>
		<td colspan="5">&nbsp;</td>
		</tr>
	</table>
		<%}%>				
<input type='hidden' name='operation_type' id='operation_type' value='<%=operation_type%>'>	
</form>
</body>
</html>	

