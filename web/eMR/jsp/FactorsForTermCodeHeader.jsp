<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%@ page import="java.sql.*, java.util.*, java.text.*,webbeans.eCommon.*" %>
<%@page contentType="text/html;charset=UTF-8" import="java.util.*, eMR.*, eCommon.Common.*,com.ehis.eslp.* " %><% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>
<% request.setCharacterEncoding("UTF-8"); %>
<html>
<head>
<link rel="stylesheet" type="text/css" href="../../eCommon/html/<%=sStyle%>"></link>
<script language='javascript' src='../../eCommon/js/common.js'></script>
<script language='javascript' src='../../eCommon/js/CommonLookup.js'></script>
<script language='javascript' src='../../eCommon/js/ValidateControl.js'></script>
<script language="javascript" src="../js/FactorsForTermCode.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<body  onMouseDown="CodeArrest()" onKeyDown="lockKey()" > 
<form method='post' action='' target='bankFrame' name='factorsfortermcodeheader' id='factorsfortermcodeheader'>
<table border="0" cellpadding="5" cellspacing="0" width="100%" align='center'>
<%
Connection con = null;
PreparedStatement pstmt = null;
ResultSet rs = null;
try
{
	String sql_termsetid = "select term_set_id,term_set_desc from mr_term_set where eff_status = 'E' order by term_set_desc";
	con = ConnectionManager.getConnection(request);
	pstmt = con.prepareStatement(sql_termsetid);
	rs = pstmt.executeQuery();
%>
<tr>
	<td class='label' width='20%' ><fmt:message key="Common.TermSetID.label" bundle="${common_labels}"/></td>
	<td class='fields' width='60%'><select name='term_set_id' id='term_set_id' onchange='clrresult(this)'>
			<option value="">---<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---</option>
<%
	if(rs!=null)
	{
		while(rs.next())
		{
			out.println("<option value='"+rs.getString(1)+"'>"+rs.getString(2)+"</option>");
		}
	}

%>
		</select><img src='../../eCommon/images/mandatory.gif'></img>
	</td>
	<td class='label' width='20%'></td>
</tr>
<tr>
	<td class='label' ><fmt:message key="Common.TermCode.label" bundle="${common_labels}"/></td>
	<td class='fields'><input type=text size = '60' maxlength = '60'  name="term_code_desc" id="term_code_desc" value=""  onblur='getbeforetermcodeval(this);chkValue(this)' disabled ><input class='button' type=button name="term_code_lukup" id="term_code_lukup" value="?"  onClick='gettermcodeval(term_code_desc)'>
	<img src='../../eCommon/images/mandatory.gif'align='center'></img>
	<input type="hidden" name="term_code" id="term_code" value="" >
	</td>
	<td class='label' width='20%'></td>
</tr>
<tr>
	<td colspan='2' class='label'></td><td class='button'><INPUT TYPE="button" class='button' value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.search.label","common_labels")%>' onclick='disprespg()'></td>
</tr>
</table>
</form>
<%
}
catch (Exception e)
{
	//out.println(e.toString());
	e.printStackTrace();
}
finally
{
	if(rs!=null) rs.close();
	if(pstmt!=null) pstmt.close();
	ConnectionManager.returnConnection(con);
}
%>
</body>
</html>
<%!
	public static String checkForNull(String inputString)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? "" : inputString);
	}
	public static String checkForNull(String inputString, String defaultValue)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? defaultValue : inputString);
	}
%>

