<!DOCTYPE html>
<%@ page import ="java.sql.*, java.util.*, java.text.*, webbeans.eCommon.*,eCommon.XSSRequestWrapper " contentType="text/html;charset=UTF-8" %>
 <%@ include file="../../eCommon/jsp/CommonInclude.jsp" %>

<%
	request.setCharacterEncoding("UTF-8");
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");
%>
<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>
 <%--
	@todo Should be declared locally
--%>
<%! 
String birthplacecode;String longdesc;String shortdesc;String effdatefrom;String effdateto;String effstatus;//String regioncodecompare; 
%>

<html>
	<head>
		<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
		<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
		<script src='../../eCommon/js/common.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	</head>
	<body OnMouseDown='CodeArrest()' onLoad='FocusFirstElement()' onKeyDown = 'lockKey()'>

<% birthplacecode = request.getParameter("birth_place_code");
//Connection conn = (Connection) session.getValue( "connection" );
Connection conn = null;
PreparedStatement pstmt=null;
ResultSet rset=null;


try{
	conn = ConnectionManager.getConnection(request);
	String sql = "select birth_place_code,long_desc,short_desc,eff_date_from,eff_date_to,eff_status from mp_birth_place where birth_place_code=?";
	//pstmt = conn.prepareStatement("select birth_place_code,long_desc,short_desc,eff_date_from,eff_date_to,eff_status from mp_birth_place where birth_place_code='"+birthplacecode+"'");
	pstmt = conn.prepareStatement(sql);
	pstmt.setString(1,birthplacecode);
	
	rset = pstmt.executeQuery();
	if(rset != null) {
		rset.next();
		birthplacecode = rset.getString("birth_place_code");
		longdesc = rset.getString("long_desc");
		shortdesc = rset.getString("short_desc");
		if(rset.getString("eff_date_from")==null) {
			effdatefrom = "" ;
		}
		else {
			String temp = rset.getString("eff_date_from");
			effdatefrom = temp.substring(8,10)+ "/" + temp.substring(5,7) + "/" + temp.substring(0,4);
		}
		if(rset.getString("eff_date_to")==null) {
			effdateto = "";
		}
		else {
			String temp1 = rset.getString("eff_date_to");
			effdateto = temp1.substring(8,10)+ "/" + temp1.substring(5,7) + "/" + temp1.substring(0,4);
		}
		effstatus = rset.getString("eff_status");
		//regioncodecompare = rset.getString("region_code");
	}
%>
	<form name='res_town_form' id='res_town_form' action='../../servlet/eMP.BirthPlaceServlet' method='post' target='messageFrame'>
		<BR><BR><BR><BR><BR><BR><BR><BR>
		<div align='left'>
		<table border='0' cellpadding='3' cellspacing='0' width='75%' align='center'>
			<tr>
				<td width='40%' >&nbsp;</td>
				<td width='60%' colspan='2'>&nbsp;</td>
			</tr>
			<tr>
				<td width='40%' class='label'><fmt:message key="Common.code.label" bundle="${common_labels}"/></td>
				<td width='60%' class='fields' colspan='2'><input type='text' name='birth_place_code' id='birth_place_code' value='<%=birthplacecode%>' size='2' readonly ><img src='../images/mandatory.gif'></img>
<%
	if ( effstatus.equals("E") )
	{
%>
				</td>
			</tr>
			<tr>
				<td width='40%' class='label'><fmt:message key="Common.longdescription.label" bundle="${common_labels}"/></td>
				<td width='60%' colspan='2' class='fields'><input type='text' name='long_desc' id='long_desc' size='30' maxlength='30' onBlur='makeValidString(this)' value="<%=longdesc%>"><img src='../images/mandatory.gif'></img>
				</td>
			</tr>
			<tr>
				<td width='40%' class='label'><fmt:message key="Common.shortdescription.label" bundle="${common_labels}"/></td>
				<td width='60%' colspan='2' class='fields'><input type='text' name='short_desc' id='short_desc' size='15' maxlength='15' onBlur='makeValidString(this)' value="<%=shortdesc%>"><img src='../images/mandatory.gif'></img>
				</td>
			</tr>
			<input type='hidden' name='eff_date_from1' id='eff_date_from1' size='10' maxlength ='10'  value='<%=effdatefrom%>' >
			<input type='hidden' name='eff_date_to1' id='eff_date_to1' size='10' maxlength ='10'   value='<%=effdateto%>'>
			<tr>
				<td width='40%' class='label'><fmt:message key="Common.enabled.label" bundle="${common_labels}"/></td>
				<td class='fields' width='60%' colspan='2'><input type='checkbox' name='eff_status' id='eff_status' value='E'
<%
		if  ( effstatus.equals("E") )
			out.println("checked >");
		else
			out.println(">");
%>
				</td>
			</tr> 
			<tr>
				<td width='40%' >&nbsp;</td>
				<td width='60%' colspan='2'>&nbsp;</td>
			</tr>
		</table>
		</div>
		<input type='hidden' name='function' id='function' value='modify'>
		<input type='hidden' name='function_name' id='function_name' value='modify'>
		<input type='hidden' name='eff_date_from' id='eff_date_from' value=''>
		<input type='hidden' name='eff_date_to' id='eff_date_to' value=''>
	</form>
<%	}
	if ( effstatus.equals("D") )
	{
		//String rgncode="";
%>		
				</td>
			</tr>
			<tr>
				<td width='40%' class='label'><fmt:message key="Common.longdescription.label" bundle="${common_labels}"/></td>
				<td width='60%' colspan='2' class='fields'><input type='text' name='long_desc' id='long_desc' size='30' maxlength='30' onBlur='makeValidString(this)' value="<%=longdesc%>" readonly><img src='../images/mandatory.gif'></img>
				</td>
			</tr>
			<tr>
				<td width='40%' class='label'><fmt:message key="Common.shortdescription.label" bundle="${common_labels}"/></td>
				<td width='60%' colspan='2' class='fields'><input type='text' name='short_desc' id='short_desc' size='15' maxlength='15' onBlur='makeValidString(this)' value="<%=shortdesc%>" readonly><img src='../images/mandatory.gif'></img>
				</td>
			</tr>
			<input type='hidden' name='eff_date_from1' id='eff_date_from1' size='10' maxlength ='10'  value='<%=effdatefrom%>' readonly>	
			<input type='hidden' name='eff_date_to1' id='eff_date_to1' size='10' maxlength ='10'   value='<%=effdateto%>' readonly>
			<tr>
				<td width='40%' class='label'><fmt:message key="Common.enabled.label" bundle="${common_labels}"/></td>
				<td width='60%' class='fields' colspan='2'><input type='checkbox' name='eff_status' id='eff_status' value='E'
<%
		if  ( effstatus.equals("E") )
			out.println("checked >");
		else
			out.println(">");
%>
				</td>
			</tr>
			<tr>
				<td width='40%' >&nbsp;</td>
				<td width='60%' colspan='2'>&nbsp;</td>
			</tr> 
		</table>
		</div>
		<input type='hidden' name='function' id='function' value='modify'>
		<input type='hidden' name='function_name' id='function_name' value='modify'>
		<input type='hidden' name='eff_date_from' id='eff_date_from' value=''>
		<input type='hidden' name='eff_date_to' id='eff_date_to' value=''>
	</form>
<%}
}catch(Exception e) { 
	//out.println(e);
	e.printStackTrace();
}finally{
	if (rset != null) rset.close();
	if (pstmt != null) pstmt.close();
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

