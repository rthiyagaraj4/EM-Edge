<!DOCTYPE html>
<%@ page import ="java.sql.Connection,java.sql.PreparedStatement,eCommon.Common.*,java.sql.ResultSet,webbeans.eCommon.ConnectionManager,eCommon.XSSRequestWrapper" contentType=" text/html;charset=UTF-8" %>
<%
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
 String locale = (String)session.getAttribute("LOCALE"); 
 request.setCharacterEncoding("UTF-8");
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff"); %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@ include file="../../eOT/jsp/StringUtil.jsp"%>
<html>
<head>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
	<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
	<script src="../../eCommon/js/common.js" language="javascript"></script>
	<script language='javascript' src='../../eOT/js/SurgeryType.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<!--body onLoad="parent.commontoolbarFrame.document.forms[0].apply.disabled=false" OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()'-->
<body OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()'> <!--Modified Against GHL-SCF-1519-->
<%
Connection con=null;
PreparedStatement stmt=null;
ResultSet rs=null;
String mode=checkForNull(request.getParameter("mode"));
String nature_code = checkForNull(request.getParameter("nature_code"));
String chk_checked="checked";
String chk_value="E";
String disable_flag="";
String surgery_disable="";
String long_desc="";
String short_desc="";
String nature_type="";
String status="";
String sql="";

if(mode.equals("modify"))
{
	con=ConnectionManager.getConnection(request);
		//sql=" Select  long_desc, short_desc, nature_type, nvl(status,'E') status from OT_NATURE_OF_SURGERY where nature_code= ?";
		sql="Select  long_desc, short_desc, nature_type, nvl(status,'E') status from OT_NATURE_OF_SURGERY_LANG_VW where nature_code= ? AND LANGUAGE_ID= ?";

		stmt=con.prepareStatement(sql);
		stmt.setString(1,nature_code);
		stmt.setString(2,locale);
		rs=stmt.executeQuery();
		if(rs!=null && rs.next())
		{
			long_desc=rs.getString("long_desc");
			short_desc=rs.getString("short_desc");
			nature_type=rs.getString("nature_type");
			status=rs.getString("status");
		}
		if(status.equals("E"))
		{
			chk_checked="checked";
			disable_flag="";
			
		}
		else
		{
			chk_checked="";
			disable_flag="disabled";
			chk_value="D";
		}
		
	surgery_disable="disabled";	
}
%>
<form name="surgery_form" id="surgery_form"  onload='FocusFirstElement()'  action="../../servlet/eOT.SurgeryTypeServlet" method="post" target="messageFrame"> 
<br><br><br><br><br><br>
<table border=0 cellspacing=0 cellpadding=3 width='60%'  align=center>
<tr>
	<td width='35%'></td>
	<td width='65%'></td>
</tr>

<tr>
	<td class=label width="25%">
		<fmt:message key="Common.SurgeryType.label" bundle="${common_labels}"/>
	</td>
	<td class="fields" width="25%">
		<input type="text" name="surgery_type" id="surgery_type" value="<%=nature_code%>" size=6 maxlength=6  <%=surgery_disable%> onkeypress="return CheckForSpecChars(event)"  onBlur="ChangeUpperCase(this)" ><img src='../../eCommon/images/mandatory.gif'>
	</td>
</tr>

<tr>
	<td class=label width="25%">
		<fmt:message key="Common.longdescription.label" bundle="${common_labels}"/>
	</td>
	<td class="fields" width="25%">
		<input type="text" name="long_desc" id="long_desc" value="<%=long_desc%>"  size=30 maxlength=30 <%=disable_flag%>>
		<img src='../../eCommon/images/mandatory.gif'>
	</td>
</tr>

<tr>
	<td class=label width="25%">
		<fmt:message key="Common.shortdescription.label" bundle="${common_labels}"/>
	</td>
	<td class="fields" width="25%">
		<input type="text" name="short_desc" id="short_desc" value="<%=short_desc%>"   size='15' maxlength='15' <%=disable_flag%>>
		<img src='../../eCommon/images/mandatory.gif'>
	</td>
</tr>

<tr>
	<td class=label width="25%"><fmt:message key="Common.type.label" bundle="${common_labels}"/></td>
	<td class="fields" width="25%"><select name='type' id='type' <%=disable_flag%>> 
	<%
	if(mode.equals("modify")){
		if(nature_type.equals("EL")){
		%>
		<option value="EL"><fmt:message key="Common.elective.label" bundle="${common_labels}"/></option>
		<option value="EM"><fmt:message key="Common.emergency.label" bundle="${common_labels}"/></option>
		<%}
		else if(nature_type.equals("EM")){%>
		<option value="EM"><fmt:message key="Common.emergency.label" bundle="${common_labels}"/></option>
		<option value="EL"><fmt:message key="Common.elective.label" bundle="${common_labels}"/></option>
		<%
		}
	}
	else{
	%>
		<option value="EL"><fmt:message key="Common.elective.label" bundle="${common_labels}"/></option>
		<option value="EM"><fmt:message key="Common.emergency.label" bundle="${common_labels}"/></option>
	<%}%>
		</select>
		<img src='../../eCommon/images/mandatory.gif'>
	</td>
</tr>
<tr>
	<td class=label width="25%">
			<fmt:message key="Common.enabled.label" bundle="${common_labels}"/>
	</td>
	<td class="fields" width="25%">
			<input type="checkbox" name="status" id="status" onClick='setCheckValue();' value='<%=chk_value%>' <%=chk_checked%> >
	</td>
</tr>
<tr>
	<td width='35%'></td>
	<td width='65%'></td>
</tr>
</table>
<input type=hidden name='mode' id='mode' value='<%=mode%>'>
<input type=hidden name=surgery_type1 value="<%=nature_code%>">
<input type=hidden name=long_desc1 value="<%=long_desc%>">
<input type=hidden name=short_desc1 value="<%=short_desc%>">
<input type=hidden name=type1 value="<%=nature_type%>">
<input type='hidden' name='locale' id='locale' value="<%=locale%>">
</form>
</body>
</html>


