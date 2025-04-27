<!DOCTYPE html>
<%@ page import ="java.sql.*, java.util.*, java.text.*, webbeans.eCommon.*,eCommon.XSSRequestWrapper " contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%
    request.setCharacterEncoding("UTF-8");
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");
%>
<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>

<%
	String resareacode = "";
	String longdesc = "";
	String shortdesc = "";
	String effdatefrom = "";
	String effdateto = "";
	String effstatus = "";
	String regioncodecompare = "";
%>
	<html><head>
	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
	<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
	<script src='../../eCommon/js/common.js' language='javascript'></script>	
	<Script src="../../eCommon/js/CommonLookup.js" language="JavaScript"></Script>
	<Script src="../../eMP/js/Postal.js" language="JavaScript"></Script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	</head>
	<body OnMouseDown='CodeArrest()' onLoad='' onKeyDown = 'lockKey()'>
<% 
	resareacode = request.getParameter("postal_code");

	Connection conn = null;
	java.sql.Statement pstmt=null;
	ResultSet rset=null;
	PreparedStatement pstmt1=null;

	String regiondesc = "";
	String selectQuery = "";

	try
	{
		conn = ConnectionManager.getConnection(request);
																	
		pstmt = conn.createStatement();
		
		//selectQuery ="SELECT a.postal_code, b.res_town_code, b.long_desc res_town_desc, a.long_desc, a.short_desc, a.eff_date_to, a.eff_status, a.eff_date_from FROM mp_postal_code a, mp_res_town b WHERE a.res_town_code = b.res_town_code(+) AND a.postal_code = '"+resareacode+"' ";
		selectQuery ="SELECT a.postal_code, b.res_town_code, b.long_desc res_town_desc, a.long_desc, a.short_desc, a.eff_date_to, a.eff_status, a.eff_date_from FROM mp_postal_code a, mp_res_town b WHERE a.res_town_code = b.res_town_code(+) AND a.postal_code = ? ";
				
		//rset = pstmt.executeQuery(selectQuery);
		pstmt1 = conn.prepareStatement(selectQuery);
		pstmt1.setString(1,resareacode);
		rset = pstmt1.executeQuery();
		if(rset != null && rset.next()) 
		{  			
			resareacode = rset.getString("postal_code");
			longdesc	= rset.getString("long_desc");
			shortdesc	= rset.getString("short_desc");
			effstatus			= rset.getString("eff_status");
			regioncodecompare	= rset.getString("res_town_code") == null ? "" : rset.getString("res_town_code");
			regiondesc			= rset.getString("res_town_desc") == null ? "" : rset.getString("res_town_desc");
		
			if(rset.getString("eff_date_from")==null) 
			{
				effdatefrom = "" ;
			}
			else 
			{
				String temp = rset.getString("eff_date_from");
				effdatefrom = temp.substring(8,10)+ "/" + temp.substring(5,7) + "/" + temp.substring(0,4);
			}
	
			if(rset.getString("eff_date_to")==null) 
			{
				effdateto = "";
			}
			else 
			{
				String temp1 = rset.getString("eff_date_to");
				effdateto = temp1.substring(8,10)+ "/" + temp1.substring(5,7) + "/" + temp1.substring(0,4);
			}
			
			if(regioncodecompare == null || regioncodecompare.equals("null")) regioncodecompare = "";
			if(regiondesc == null || regiondesc.equals("null")) regiondesc = "";
		} 	
		%>
		<form name='postal_form' id='postal_form' action='../../servlet/eMP.PostalServlet' method='post' target='messageFrame'>
		<BR><BR><BR><BR><BR><BR><BR><BR>
		<div align='left'>
			<table border='0' cellpadding='3' cellspacing='0' width='75%' align='center'>
				<tr><td width='40%' >&nbsp;</td><td width='60%' colspan='1'>&nbsp;</td></tr>
				<tr>
					<td width='40%' class='label'><fmt:message key="Common.code.label" bundle="${common_labels}"/></td>
					<td width='60%' class='fields' colspan='1'><input type='text' name='postal_code' id='postal_code' value="<%=resareacode%>" size='6' readonly ><img src='../images/mandatory.gif'></img>
					<%if(effstatus.equals("E")) 
					{ 
					%>
					</td>
				</tr>
				<tr>
					<td width='40%' class='label'><fmt:message key="Common.longdescription.label" bundle="${common_labels}"/></td>
					<td width='60%' colspan='1' class='fields'><input type='text' name='long_desc' id='long_desc' size='30' maxlength='30' onBlur='makeValidString(this)' value="<%=longdesc%>"><img src='../images/mandatory.gif'></img></td>
				</tr>
				<tr>
					<td width='40%' class='label'><fmt:message key="Common.shortdescription.label" bundle="${common_labels}"/></td>
					<td width='60%' colspan='1'class='fields'><input type='text' name='short_desc' id='short_desc' size='15' maxlength='15' onBlur='makeValidString(this)' value="<%=shortdesc%>"><img src='../images/mandatory.gif'></img>
				</td>
				</tr>
				<tr><td width='40%' class='label'><fmt:message key="Common.Town.label" bundle="${common_labels}"/></td>
				<td width='60%' class='fields' colspan='1'><INPUT type='text' name='resTownDesc' id='resTownDesc' size='30' maxlength='30' value='<%=regiondesc%>' onBlur='searchTown(this,resTownDesc)'><INPUT type='hidden' name='res_town_code' id='res_town_code' value='<%=regioncodecompare%>'><input type='button' name='resTownCodeButton' id='resTownCodeButton' value='?' class='button' onclick='searchTown(this,resTownDesc)'>
				</td>
			</tr>
			<input type='hidden' name='eff_date_from1' id='eff_date_from1' size='10' maxlength ='10'  value="<%=effdatefrom%>" >
			<input type='hidden' name='eff_date_to1' id='eff_date_to1' size='10' maxlength ='10'   value="<%=effdateto%>">
			<tr>
				<td width='40%' class='label'><fmt:message key="Common.enabled.label" bundle="${common_labels}"/></td>
				<td class='fields'' width='60%' colspan='1'><input type='checkbox' name='eff_status' id='eff_status' value='E'
				<%if(effstatus.equals("E")) out.println("checked >");
				else out.println(">");
				%>
				</td>
			</tr>
			<tr>
				<td width='40%' >&nbsp;</td>
				<td width='60%' colspan='1'>&nbsp;</td>
			</tr>
		</table>
		</div>
		<input type='hidden' name='function' id='function' value='modify'>
		<input type='hidden' name='function_name' id='function_name' value='modify'>
		<input type='hidden' name='eff_date_from' id='eff_date_from' value=''>
		<input type='hidden' name='eff_date_to' id='eff_date_to' value=''></form>

		<% 
		} if(effstatus.equals("D")) { %>
			</td>
		</tr>
		<tr>
			<td width='40%' class='label'><fmt:message key="Common.longdescription.label" bundle="${common_labels}"/></td>
			<td width='60%' colspan='1' class='fields'><input type='text' name='long_desc' id='long_desc' size='30' maxlength='30' value="<%=longdesc%>" readonly><img src='../images/mandatory.gif'></img>
		</td>
		</tr>
		<tr>
			<td width='40%' class='label'><fmt:message key="Common.shortdescription.label" bundle="${common_labels}"/></td>
			<td width='60%' colspan='1'class='fields'><input type='text' name='short_desc' id='short_desc' size='15'  maxlength='15' value="<%=shortdesc%>" readonly ><img src='../images/mandatory.gif'></img>
			</td>
		</tr>
		<tr>
			<td width='40%' class='label'><fmt:message key="Common.Town.label" bundle="${common_labels}"/></td>
			<td width='60%' class='fields' colspan='1'><INPUT type='text' name='resTownDesc1' id='resTownDesc1' value="<%=regiondesc%>" readonly><INPUT type='hidden' name='res_town_code1' id='res_town_code1' value="<%=regioncodecompare%>">
			</td>
		</tr>
		<input type='hidden' name='res_town_code' id='res_town_code' value="<%=regioncodecompare%>">
		<input type='hidden' name='eff_date_from1' id='eff_date_from1' size='10' maxlength ='10'   value='<%= effdatefrom%>' readonly>
		<input type='hidden' name='eff_date_to1' id='eff_date_to1' size='10' maxlength ='10'    value='<%=effdateto%>' readonly>
		<tr>
			<td width='40%' class='label'><fmt:message key="Common.enabled.label" bundle="${common_labels}"/></td>
			<td width='60%' class='fields' colspan='1'><input type='checkbox' name='eff_status' id='eff_status' value='E'
			<%if(effstatus.equals("E")) out.println("checked >");
			else out.println(">");
			%>
			</td>
		</tr>
		<tr>
			<td width='40%' >&nbsp;</td>
			<td width='60%' colspan='1'>&nbsp;</td>
		</tr> 
	</table>
	</div>
	<input type='hidden' name='function' id='function' value='modify'>
	<input type='hidden' name='function_name' id='function_name' value='modify'>
	<input type='hidden' name='eff_date_from' id='eff_date_from' value=''>
	<input type='hidden' name='eff_date_to' id='eff_date_to' value=''></form>
	<%
	}
}
catch(Exception e) 
{ 
	//out.println(e.toString());
	e.printStackTrace();
}
finally
{
	if(rset != null) rset.close();
	if(pstmt != null) pstmt.close();
	if(conn!=null) ConnectionManager.returnConnection(conn,request);
}
%>
</body>
</html>

<%!	
	private String checkForNull(String inputString)
	{
		return (inputString==null)	?	""	:	inputString;
	}
	
	public static String checkForNull(String inputString, String defaultValue)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? defaultValue : inputString);
	}
%>

