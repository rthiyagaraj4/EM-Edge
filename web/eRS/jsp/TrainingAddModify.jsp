<!DOCTYPE html>

<%-- JSP Page specific attributes start --%>
<%@ page language="java" contentType="text/html;charset=UTF-8" import ="java.sql.*, webbeans.eCommon.*, java.net.*,java.util.*, eRS.* ,eCommon.Common.*"%>
<%-- JSP Page specific attributes end --%>
<%-- Mandatory declarations start --%>
<%-- Remarks --This gives handle to  CommonMultipleHandler Bean with id=>mh--%>
<%@ include file="../../eCommon/jsp/Common.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%-- Mandatory declarations end --%>
<%String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

request.setCharacterEncoding("UTF-8");
String locale			= (String)session.getAttribute("LOCALE");
//String primary_lang		= (String)session.getAttribute("PRIMARY_LANG");
Connection conn;



%>
<html>
<head>
<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<script language="JavaScript" src="../../eCommon/js/common.js"></script>

<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
<script language="javascript" src="../js/Training.js"></script>
<!-- <script language="javascript" src="../js/RSMessages.js"> </script>
<script language="javascript" src="../../eCommon/js/messages.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
 -->
</head>
<%
String mode	= request.getParameter("mode");
String operation_type="";
%>
<body  onload='FocusFirstElement()' onMouseDown="CodeArrest()" onKeyDown="lockKey()" >
	<br><br><br><br><br>
	<form name='form_TrainingAddModify' id='form_TrainingAddModify' target='messageFrame' method='post'  action='../../servlet/eRS.TrainingServlet' >
	<%
		if(mode.equalsIgnoreCase("1")){
		operation_type="insert";
			
	%>
	<table cellpadding=0 cellspacing=0 border=0 width="80%" align=center>
		<tr>
		<td colspan="5">&nbsp;</td>
		</tr>
		<tr>
			<!-- <td  width="20%"  align=right class="label">Code</td> -->
			<td  width="20%"  align=right class="label"><fmt:message key="Common.code.label" bundle="${common_labels}"/></td>
			<td  width="60%"  align=left class="label">&nbsp;&nbsp;&nbsp;&nbsp;<input type="text" name='training_code' id='training_code' value='' size='10' maxlength='10' onKeyPress="return CheckForSpecChars(event)" >&nbsp;<img src="../../eCommon/images/mandatory.gif"></td>
		</tr>
		<tr>
			<!-- <td  width="20%"  align=right class="label">Description</td> -->
			<td  width="20%"  align=right class="label"><fmt:message key="Common.description.label" bundle="${common_labels}"/></td>
			<td  width="60%"  align=left class="label">&nbsp;&nbsp;&nbsp;&nbsp;<input type="text" name="training_desc" id="training_desc" value='' size='38' maxlength='30'>&nbsp;<img src="../../eCommon/images/mandatory.gif"></td>
		</tr>
		<tr>
			<!-- <td  width="20%"  align=right class="label">Explanatory Text</td> -->
			<td  width="20%"  align=right class="label"><fmt:message key="Common.ExplanatoryText.label"  bundle="${common_labels}"/></td>
			<td  width="60%"  align=left class="label">&nbsp;&nbsp;&nbsp;&nbsp;<textarea name="training_expl_text"  rows='11'cols='45' onblur='checkForMax(this);'></textarea></td>
		</tr>
		<tr>
			<!-- <td  width="20%"  align=right class="label">Enabled</td> -->
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
			PreparedStatement pstmt=null;
			ResultSet rs=null;
			conn = ConnectionManager.getConnection(request);	
			

			String sql="";
			String training_code=request.getParameter("training_code");
			String training_desc="";
			String training_expl_text="";
			String eff_status="";
try
{

//sql="select training_desc,training_expl_text,eff_status from rs_training where training_code=?";
sql="select training_desc,training_expl_text,eff_status from rs_training_lang_vw where training_code=? And language_id = ?";
pstmt=conn.prepareStatement(sql);
pstmt.setString(1,training_code);
pstmt.setString(2,locale);
	
rs=pstmt.executeQuery();

while(rs.next())
	{
		training_desc=rs.getString("training_desc")==null ? "":rs.getString("training_desc");
		training_expl_text=rs.getString("training_expl_text")==null ? "":rs.getString("training_expl_text");
		eff_status=rs.getString("eff_status")==null ? "":rs.getString("eff_status");
	}
}catch(Exception e)
{
	e.printStackTrace();
}
finally
{
	if (rs != null)   rs.close();
	if (pstmt != null) pstmt.close();
	ConnectionManager.returnConnection(conn,request);
}
%>
	<table cellpadding=0 cellspacing=0 border=0 width="80%" align=center>
		<tr>
		<td colspan="5">&nbsp;</td>
		</tr>
		<tr>
			<td  width="20%"  align=right class="label"><fmt:message key="Common.code.label" bundle="${common_labels}"/></td>
			<td  width="60%"  align=left class="label">&nbsp;&nbsp;&nbsp;&nbsp;<input type="text" name='training_code' id='training_code' value='<%=training_code%>' size='10' maxlength='10' readonly onKeyPress="return CheckForSpecChars(event)" >&nbsp;<img src="../../eCommon/images/mandatory.gif"></td>
		</tr>
		<tr>
			<td  width="20%"  align=right class="label"><fmt:message key="Common.description.label" bundle="${common_labels}"/></td>
		<%if(eff_status.equals("E"))
			{%>
			<td  width="60%"  align=left class="label">&nbsp;&nbsp;&nbsp;&nbsp;<input type="text" name="training_desc" id="training_desc" value='<%=training_desc%>' size='38' maxlength='30'>&nbsp;<img src="../../eCommon/images/mandatory.gif"></td>
		<%}else{%>
			<td  width="60%"  align=left class="label">&nbsp;&nbsp;&nbsp;&nbsp;<input type="text" name="training_desc" id="training_desc" value='<%=training_desc%>' size='38' maxlength='30' readonly>&nbsp;<img src="../../eCommon/images/mandatory.gif"></td>
		<%}%>
		</tr>
		<tr>
			<td  width="20%"  align=right class="label"><fmt:message key="Common.ExplanatoryText.label"  bundle="${common_labels}"/></td>
		<%if(eff_status.equals("E"))
			{%>
			<td  width="60%"  align=left class="label">&nbsp;&nbsp;&nbsp;&nbsp;<textarea name="training_expl_text"  rows='11'cols='45' onblur='checkForMax(this);'><%=training_expl_text%></textarea></td>
		<%}else{%>
			<td  width="60%"  align=left class="label">&nbsp;&nbsp;&nbsp;&nbsp;<textarea name="training_expl_text"  rows='11'cols='45' maxlength='4000' readonly><%=training_expl_text%></textarea></td>
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

