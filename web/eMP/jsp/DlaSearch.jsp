<!DOCTYPE html>
<HTML> 
<%@ page import = "java.util.*" %>
<%@ page import ="java.sql.Connection,java.sql.PreparedStatement,java.sql.Statement,java.sql.ResultSet,webbeans.eCommon.ConnectionManager"%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%request.setCharacterEncoding("UTF-8"); %>
<% String locale = ((String)session.getAttribute("LOCALE"));	%>

<HEAD>
<%String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

<%
	Connection oraConn = null;
	Statement stmt = null;
	ResultSet rs = null;

	String firstNamePrompt = null;
	String surNamePrompt = null;
	String nationalIDPrompt = null;
	String national_id = request.getParameter("nationalIdNo");
	String patient_id = (String)session.getAttribute("dla_patient_id");
	String fucntion_id = (String)session.getAttribute("dla_function_id");
	if(national_id == null)national_id = "";
%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
<script language='javascript' src='../../eCommon/js/common.js'></script>
<script language='javascript' src='../../eCommon/js/ValidateControl.js'></script>
<script language='javascript' src='../../eMP/js/dlainterface.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


<BODY  leftmargin=0 topmargin=0 onMouseDown="CodeArrest()" onKeyDown = 'lockKey()' onLoad="this.document.forms[0].d_flag.value='N';this.document.forms[0].user_name.focus()">
<form name="CriteriaForm" id="CriteriaForm" method="post">
<input type='hidden' name='d_flag' id='d_flag' value=''>
<INPUT TYPE="hidden" name="mode" id="mode" VALUE="search">
<table cellspacing=0 cellpadding=3 width='100%' align=center>

<%
try
{
	String query = "SELECT nvl(FIRST_NAME_PROMPT,'First Name')FIRST_NAME_PROMPT,nvl(FIRST_NAME_LOC_LANG_PROMPT,'First Name')FIRST_NAME_LOC_LANG_PROMPT,nvl(FAMILY_NAME_PROMPT,'Family Name')FAMILY_NAME_PROMPT,nvl(FAMILY_NAME_LOC_LANG_PROMPT,'Family Name')FAMILY_NAME_LOC_LANG_PROMPT,NAT_ID_PROMPT FROM MP_PARAM_LANG_VW WHERE MODULE_ID='MP' AND LANGUAGE_ID='"+locale+"'";

	oraConn = ConnectionManager.getConnection();
	stmt = oraConn.createStatement();
	rs = stmt.executeQuery(query);

	if(rs.next())
	{
		nationalIDPrompt = rs.getString("NAT_ID_PROMPT");
		if(locale != null && locale.equalsIgnoreCase("TH"))
		{
			firstNamePrompt = rs.getString("FIRST_NAME_LOC_LANG_PROMPT");
			surNamePrompt = rs.getString("FAMILY_NAME_LOC_LANG_PROMPT");
		}
		else
		{
			firstNamePrompt = rs.getString("FIRST_NAME_PROMPT");
			surNamePrompt = rs.getString("FAMILY_NAME_PROMPT");
		}
	}
}
catch(Exception exp)
{
	exp.printStackTrace(System.err);
}
finally
{
	if(rs != null) rs.close();
	if(stmt != null) stmt.close();
	if(oraConn != null) ConnectionManager.returnConnection(oraConn);
}

%>

<tr width="100">
<td class="COLUMNHEADER" colspan=5><fmt:message key="eMP.usercredentials.label" bundle="${mp_labels}"/></td>
</tr> 
<tr>							  
<td class="label">&nbsp;</td>			 
<td class="label" ><fmt:message key="eMP.DLAUserID.label" bundle="${mp_labels}"/></td>
<td class='fields'><input type="text"name=user_name id="user_name" width="30%" align="left" size="20" maxlength="50" onBlur="chkAlphaNumeric(this)"> <img src='../../eCommon/images/mandatory.gif'></td>
<td class="label" ><fmt:message key="Common.password.label" bundle="${common_labels}"/></td>
<td class='fields'><input type="PASSWORD" name=pass_word id="pass_word" width="30%" align="left" maxlength="50" size="20"><img src='../../eCommon/images/mandatory.gif'></td>
</tr> 

<tr>
<td  class="COLUMNHEADER" colspan=5><fmt:message key="Common.SearchCriteria.label" bundle="${common_labels}"/></td>
</tr> 

<tr>
<td  class="label"><fmt:message key="Common.searchby.label" bundle="${common_labels}"/></td>
<td  class="fields"><input type="radio" name="search_by" id="search_by" id='search_by' class="label" value="N" onclick="storeVal(this)" checked>
<%if(nationalIDPrompt != null && !nationalIDPrompt.equalsIgnoreCase("") && !nationalIDPrompt.equalsIgnoreCase(" ")){%>
		<%=nationalIDPrompt%>
		<input type="hidden" name="test" id="test">
	<%}else{%>
		<fmt:message key="eMP.CitizenId.label" bundle="${mp_labels}"/>
	<%}%>

<input type="radio" name="search_by" id="search_by" class="label" value="S" onclick="storeVal(this)">
	<%if(firstNamePrompt != null && !firstNamePrompt.equalsIgnoreCase("") && !firstNamePrompt.equalsIgnoreCase(" ")){%>
		<%=firstNamePrompt%> &
	<%}else{%>
		<fmt:message key="Common.FirstName.label" bundle="${common_labels}"/> &
	<%}%>
	<%if(surNamePrompt != null && !surNamePrompt.equalsIgnoreCase("") && !surNamePrompt.equalsIgnoreCase(" ")){%>
		<%=surNamePrompt%>
	<%}else{%>
		<fmt:message key="eMP.surname.label" bundle="${mp_labels}"/>
	<%}%>
	<input type="hidden" name="first_name_prompt" id="first_name_prompt" id="first_name_prompt" value="<%=firstNamePrompt%>">
	<input type="hidden" name="sur_name_prompt" id="sur_name_prompt" id="sur_name_prompt" value="<%=surNamePrompt%>">
	<input type="hidden" name="nat_id_prompt" id="nat_id_prompt" id="nat_id_prompt" value="<%=nationalIDPrompt%>">
	<input type="hidden" name="patient_id" id="patient_id" id="patient_id" value="<%=patient_id%>">	
	<input type="hidden" name="fucntion_id" id="fucntion_id" id="fucntion_id" value="<%=fucntion_id%>">	
</td>
<td class="label">&nbsp;</td>
<td class="label">&nbsp;</td>
<td class="label">&nbsp;</td>
</tr>


<tr id='national_div' style='display:block'>
<td class="label">&nbsp;</td>
<td class=label >
	<%if(nationalIDPrompt != null && !nationalIDPrompt.equalsIgnoreCase("") && !nationalIDPrompt.equalsIgnoreCase(" ")){%>
		<%=nationalIDPrompt%>
		<input type="hidden" name="test" id="test">
	<%}else{%>
		National ID No
	<%}%>
</td>
<td class='fields'><input type=text name ='national_id_name' size=20 maxlength="13" value="<%=national_id%>"><img src='../../eCommon/images/mandatory.gif'></td>
<td class="label">&nbsp;</td>
<td class="label">&nbsp;</td>
</tr>

<tr  id='name_div' style='display:none'>
<td  class="label">&nbsp;</td>
<td class=label >
	<%if(firstNamePrompt != null && !firstNamePrompt.equalsIgnoreCase("") && !firstNamePrompt.equalsIgnoreCase(" ")){%>
		<%=firstNamePrompt%>
	<%}else{%>
		<fmt:message key="Common.FirstName.label" bundle="${common_labels}"/></td>
	<%}%>
<td class='fields'><input type=text name ='first_name' size=20 maxlength="24" onBlur="chkAlphaNumeric(this)"><img src='../../eCommon/images/mandatory.gif'></td>

<td class=label >
	<%if(surNamePrompt != null && !surNamePrompt.equalsIgnoreCase("") && !surNamePrompt.equalsIgnoreCase(" ")){%>
		<%=surNamePrompt%>
	<%}else{%>
		<fmt:message key="eMP.surname.label" bundle="${mp_labels}"/></td>
	<%}%>
<td class='fields'><input type=text name ='sur_name' size=20 maxlength="24" onBlur="chkAlphaNumeric(this)"></td>
</tr>

<tr>
<td colspan=5 align="right" nowrap>
	<input type="button" align="left" name="Search" id="Search" value='<fmt:message key="Common.search.label" bundle="${common_labels}"/>' onClick="serachFunction()" class="button">
	<input type="button" align="right" name="Reset" id="Reset" value='<fmt:message key="Common.reset.label" bundle="${common_labels}"/>' onClick="resetForm();" class="button" >
</td>
</tr>																		    

</table>
</form>
</BODY>
</html>

