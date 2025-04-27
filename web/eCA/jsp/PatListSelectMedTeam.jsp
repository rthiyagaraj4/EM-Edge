<!DOCTYPE html>
<%@ page import="java.sql.*, webbeans.eCommon.*" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
	<head>
<%
request.setCharacterEncoding("UTF-8");
	String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
	<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
	<script src='../../eCommon/js/common.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	<title><fmt:message key="Common.medicalteam.label" bundle="${common_labels}"/></title>
	<script>
	function onSub()
	{
		var val = document.forms[0].med_team.value;
		if(val != "")
		{
			window.returnValue=val;
			parent.window.close();
		}
		else
		{	var msg=getMessage('CAN_NOT_BE_BLANK','Common');
			msg = msg.replace('$',getLabel('Common.medicalteam.label','Common'));
			alert(msg);
			
		}
	}

	</script>
</head>
<%
Connection con = null;
PreparedStatement pstmt = null;
ResultSet rs = null;
try
{
	con = ConnectionManager.getConnection(request);
	String episode_id = request.getParameter("episode_id");
	if(episode_id == null || episode_id.equals("null"))episode_id="";
	java.util.Properties p = (java.util.Properties) session.getValue( "jdbc" ) ;
	String locale = (String) p.getProperty("LOCALE");
	String facility_id =  (String) session.getValue("facility_id") ;
	String login_pract = (String) session.getValue("ca_practitioner_id");

	String sql_query = "Select Team_Id, AM_GET_DESC.AM_MEDICAL_TEAM(?,Team_Id,?,'2') Team_Short_Desc  from Am_Pract_For_Team_Vw where Facility_Id = ? and Practitioner_Id = ?  and Appl_for_op_yn = 'Y' and Speciality_Code = (select specialty_code from pr_encounter where facility_id = ? and encounter_id = ?)";
	%>
	<body class='CONTENT' onMouseDown="CodeArrest()" onKeyDown="lockKey()">
	<form>
	<table cellspacing="0" cellpadding="3" border="0" width="90%" align="center">
	<br>
	<tr>
	<td class="label"  width='25%'><fmt:message key="Common.medicalteam.label" bundle="${common_labels}"/></td>
	<td class="fields" width='25%'><select name="med_team" id="med_team">
	<%
		pstmt = con.prepareStatement(sql_query);
		pstmt.setString(1,facility_id);
		pstmt.setString(2,locale);
		pstmt.setString(3,facility_id);
		pstmt.setString(4,login_pract);
		pstmt.setString(5,facility_id);
		pstmt.setString(6,episode_id);
		rs = pstmt.executeQuery();

		while(rs.next())
		{
			String team_id = rs.getString("Team_Id");
			String team_short_desc = rs.getString("team_short_desc");

			if(team_id == null || team_id.equals("null"))team_id="";
			if(team_short_desc == null || team_short_desc.equals("null"))team_short_desc="";

			%>
				<option value="<%=team_id%>"><%=team_short_desc%></option>
			<%
		}
	%>
	</select><img src="../../eCommon/images/mandatory.gif"></img>
	</td>
    <td width='25%'></td>
    <td width='25%'></td>
	</tr>
	<table cellspacing="0" cellpadding="3" border="0" width="90%" align="center">
	<br>
	<tr>
		<td width='25%'></td>
		<td width='25%'></td>
		<td width='25%'></td>	
		<td  class="WHITE" width='25%' align='right'><input type="button" class="button" name="ok" id="ok" value="<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ok.label","common_labels")%>" onClick="onSub();">&nbsp;<input type="button" class="button" name="cancel" id="cancel" value="<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.cancel.label","common_labels")%>" onClick="parent.window.close();"></td>
	</tr>
	</table>
	</table>
	</form>
	</body>
	</html>
<%
	if(rs != null) rs.close();
	if(pstmt != null) pstmt.close();
}
catch(Exception e)
{
	out.println("Exception in main try"+e.toString());
}
finally
{	
	if(con!=null)
		ConnectionManager.returnConnection(con,request);
}
	%>

