<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp" %>
<%@ page import="java.sql.*, java.util.*, java.text.*,webbeans.eCommon.* " contentType="text/html;charset=UTF-8" %>
<%
	request.setCharacterEncoding("UTF-8");
%>
<html>
<head>

<%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
<script src="../../eCommon/js/common.js" language="javascript"></script>
<script Language="JavaScript" src="../../eMP/js/ReasonforRestriction.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>

<% 

String function = request.getParameter("function")==null?"":request.getParameter("function");
String reason_code = request.getParameter("reason_code")==null?"":request.getParameter("reason_code");
String long_desc="";
String short_desc="";
String enable_value = "";
String is_enable = "";

if(function.equals("modify")){

Connection conn = null;
PreparedStatement pstmt=null;
ResultSet rset=null;
	
String eff_date_from="",eff_date_to="";

try{
conn = ConnectionManager.getConnection(request);

StringBuffer sql = new StringBuffer("select reason_code,long_desc,short_desc,eff_date_from,eff_date_to,eff_status from MP_PAT_RESTRICTION_REASON where reason_code='");
sql.append(reason_code);
sql.append("'");
pstmt = conn.prepareStatement(sql.toString());
rset = pstmt.executeQuery();
rset.next();
long_desc = rset.getString("long_desc");
short_desc = rset.getString("short_desc");
enable_value = rset.getString("eff_status");
if(enable_value.equals("E")){
	is_enable = "checked";	
}else{
	is_enable = "";
}
}catch(Exception e){
	e.printStackTrace();
}
}
%>


<body  OnMouseDown="CodeArrest()" onKeyDown='lockKey();' OnLoad="Focusing('reason_code')">
<form name="reason_for_restriction_form" id="reason_for_restriction_form" action="../../servlet/eMP.ReasonForRestrictionServlet" method="post" target="messageFrame">
<BR><BR><BR><BR><BR><BR><BR><BR><BR>
<div align="left">
  <table border="0" cellpadding="3" cellspacing="0" width="75%" align='center'>

  <tr>
  	<td width='40%'>&nbsp;</td>
  	<td width='60%' colspan='2'>&nbsp;</td>
  </tr>
    <tr>
      <td width="40%" class="label"><fmt:message key="Common.code.label" bundle="${common_labels}"/></td>
      <td width="60%" colspan="2" class='fields'><input type="text" name="reason_code" id="reason_code" size="4"maxlength="4" onBlur="ChangeUpperCase(this)" value="<%= reason_code %>" onKeyPress="return CheckForSpecChars(event)" <%if(function.equals("modify")){out.print("readonly");} %> ><img src='../images/mandatory.gif'></img>	
	  </td>
    </tr>
    <tr>
      <td width="40%" class="label"><fmt:message key="Common.longdescription.label" bundle="${common_labels}"/></td>
      <td width="60%" colspan="2" class='fields'><input type="text" name="long_desc" id="long_desc" value="<%= long_desc %>" size="30" maxlength="30" onBlur='makeValidString(this)' style='{ font-size: ;}'><img src='../images/mandatory.gif'></img></td>
    </tr>
  <tr>
      <td width="40%" class="label"><fmt:message key="Common.shortdescription.label" bundle="${common_labels}"/></td>
      <td width="60%" colspan="2" class='fields'><input type="text" name="short_desc" id="short_desc" value="<%=short_desc %>" size="15" maxlength="15" onBlur='makeValidString(this)'><img src='../images/mandatory.gif'></img></td>
    </tr>

<% if(function.equals("modify")){ %>
	<tr>
		<td width="40%" class="label"><fmt:message key="Common.enabled.label" bundle="${common_labels}"/></td>
		<td width="60%" colspan='2' class='fields'><input type="checkbox" onclick="updateEffStatus()" name="eff_status" id="eff_status" value="<%= enable_value %>" <%=is_enable
		%>></td>
	</tr>
	<%}else{ %>
		<tr>
		<td width="40%" class="label"><fmt:message key="Common.enabled.label" bundle="${common_labels}"/></td>
		<td width="60%" colspan='2' class='fields'><input type="checkbox" onclick="updateEffStatus()" name="eff_status" id="eff_status" value="E" checked></td>
	</tr>
<%} %>
   <tr>
    	<td width='40%'>&nbsp;</td>
    	<td width='60%' colspan='2'>&nbsp;</td>
  </tr>

  </table>
</div>
<%if(function.equals("modify")){ %>
<input type="hidden" name="function" id="function" value="modify">
<input type='hidden' name='function_name' id='function_name' value='modify'>
<%}else{ %>

<input type="hidden" name="function" id="function" value="insert">
<input type='hidden' name='function_name' id='function_name' value='insert'>
<% }%>
</form>

</body>
</html>

