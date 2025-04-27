<!DOCTYPE html>
<%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<%@ page import="java.sql.*, java.util.*, java.text.*,webbeans.eCommon.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp" %>

<html>
<head>
		<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
  <script language='javascript' src='../../eAM/js/Anaesthesia.js'></script>
  <script language='javascript' src='../../eCommon/js/common.js'></script>
  <script language='javascript' src='../../eCommon/js/ValidateControl.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	<script>

	function change() 
	{ 
		if (anaesthesia_form.eff_status.checked == true)
			anaesthesia_form.eff_status.value="E";
		else
			anaesthesia_form.eff_status.value="D";
	}

	</script>
</head>
<%
	request= new XSSRequestWrapper(request);
    response.addHeader("X-XSS-Protection", "1; mode=block");
    response.addHeader("X-Content-Type-Options", "nosniff");
	request.setCharacterEncoding("UTF-8");
	Connection con = null;
	String mode = request.getParameter( "operation" );

    //String facilityId= (String) session.getValue("facility_id");
	
	String anaesthesia_code = request.getParameter("anaesthesia_code");

	Statement stmt=null;
	ResultSet rs=null;
	String sql = "";
	PreparedStatement pstmt = null;

	String longDesc	 = "";
	String shortDesc	 = "";
	String reactEffStatus = "E";
	String chkEffStatus  = "checked";

    String make_readonly = "";
	//String checkenable ="enabled";
	String code_readonly="";

	try 
	{
		con = ConnectionManager.getConnection(request);
		if(!(anaesthesia_code == null))
		{
			stmt= con.createStatement();
			sql = "select * from am_anaesthesia where anaesthesia_code=?";
						
			pstmt   = con.prepareStatement(sql);
			pstmt.setString	(	1,	anaesthesia_code);
			rs		 = pstmt.executeQuery();

			if(rs.next())
			{
				longDesc = rs.getString("LONG_DESC");
				shortDesc = rs.getString("SHORT_DESC");
				reactEffStatus = rs.getString("EFF_STATUS");
			}

			if(longDesc==null) longDesc="";
			if(shortDesc==null) shortDesc="";
			if(reactEffStatus==null) reactEffStatus="";

			if(reactEffStatus.equals("E"))
				chkEffStatus="checked";
			else if(reactEffStatus.equals("D"))
				{

					chkEffStatus="unchecked";
					//checkenable = "disabled";
					make_readonly = "readonly"; 
				}
			code_readonly="readonly";
			mode = "modify";
		}else{
				anaesthesia_code="";
				longDesc	 = "";
				shortDesc	 = "";
				reactEffStatus = "E";
				chkEffStatus  = "checked";
				mode = "insert";
		}
	

%>

<body OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()' onLoad="FocusFirstElement();">

<form name='anaesthesia_form' id='anaesthesia_form' action='../../servlet/eAM.AnaesthesiaServlet' method='post' target='messageFrame'>
		<div>
			<br><br><br><br> <br><br><br><br><br><br>
			<table border='0' cellpadding='0' cellspacing='0' width='70%' align='center'>
					<tr><td colspan='2'>&nbsp;</td></tr>
					<tr>
						<td  class='label' width='30%'><fmt:message key="Common.code.label" bundle="${common_labels}"/></td>		
						<td class='fields' width='70%'>&nbsp;
						<input type="text" name='anaesth_code' id='anaesth_code' size='4' maxlength='4' value='<%=anaesthesia_code%>' <%=code_readonly%> onBlur="ChangeUpperCase(this);" onKeyPress='return CheckForSpecChars(event);'>&nbsp;<img src='../../eCommon/images/mandatory.gif' align='center'></img></td>
					</tr>
					<tr><td colspan='2'>&nbsp;</td></tr>
					<tr>
						<td  class='label' width='30%'><fmt:message key="Common.longdescription.label" bundle="${common_labels}"/></td>		
						<td class='fields' width='70%'>&nbsp;
						<input type="text" name='long_desc' id='long_desc' size='40' maxlength='40' onBlur="makeValidString(this);" value="<%=longDesc%>" <%=make_readonly%> >&nbsp;<img src='../../eCommon/images/mandatory.gif' align='center'></img></td>
					</tr>
					<tr><td colspan='2'>&nbsp;</td></tr>
					<tr>
						<td class='label' width='30%'><fmt:message key="Common.shortdescription.label" bundle="${common_labels}"/></td>		
						<td class='fields' width='70%'>&nbsp;
						<input type="text" name='short_desc' id='short_desc' size='15' maxlength='15' onBlur="makeValidString(this);" value="<%=shortDesc%>" <%=make_readonly%> >&nbsp;<img src='../../eCommon/images/mandatory.gif' align='center'></img></td>
					</tr>
					<tr><td colspan='2'>&nbsp;</td></tr>
					<tr>
						<td  class='label' width='30%'><fmt:message key="Common.enabled.label" bundle="${common_labels}"/></td>
						<td class='fields' width='70%'>&nbsp;
						<input type='checkbox' name='eff_status' id='eff_status' value='<%=reactEffStatus%>' <%=chkEffStatus%> onClick="change()"></td>
					</tr>
					<tr><td colspan='2'>&nbsp;</td></tr>
				</table>
			</div>

<%
		if(rs!=null)	rs.close();
		if(stmt!=null) stmt.close();
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
	finally
	{
		
			ConnectionManager.returnConnection(con,request);
	}
%>
		<input type='hidden' name='function' id='function' value='<%=mode%>'>
	</form>
</body>
</html>

