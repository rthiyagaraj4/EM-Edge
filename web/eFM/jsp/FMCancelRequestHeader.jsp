<!DOCTYPE html>
<%@ page import ="java.sql.*, java.text.*,webbeans.eCommon.*,com.ehis.util.*" contentType="text/html; charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<html>
<head>
	<!-- <link rel='stylesheet' type ='text/css' href='../../eCommon/html/IeStyle.css'></link> -->
	<%
	request.setCharacterEncoding("UTF-8");
	String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"),"IeStyle.css");
	
	%>

	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>

	<link rel='stylesheet' type='text/css' href='../../eCommon/html/CommonCalendar.css'></link>
	<Script language="JavaScript" src="../../eCommon/js/CommonCalendar.js" ></Script>
	<script language='javascript' src='../../eCommon/js/common.js'></script>
	<script language='javascript' src='../../eCommon/js/ValidateControl.js'></script>
	<script language='javascript' src='../../eFM/js/FMCancelRequestFiles.js'></script>
	<script language='javascript' src='../../eCommon/js/DateUtils.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<body OnMouseDown="CodeArrest();" onLoad="document.CancelFilesHeader_form.FS_LOCN_ID.focus();" onKeyDown = 'lockKey();'>
<form name='CancelFilesHeader_form' id='CancelFilesHeader_form'>
	<table border='0' cellpadding='3' cellspacing='0' width='98%' align='left'>
<%
		Connection conn			= ConnectionManager.getConnection(request);
		java.sql.Statement stmt	= null;
		ResultSet rs			= null;
		
		String facility_id	= (String) session.getValue("facility_id");
		String user_id		= (String) session.getValue("login_user");
		
		String userSecurity = "N";
		String access_all   = "";
		//String datetime		= "";
		String username		= "";
		String userButtAttr = "";
		
		try
		{

			access_all		= request.getParameter("userVal");
			userSecurity	= request.getParameter("userSecurity");

			if(access_all == null || access_all.equals("null")) access_all = "";
			if(userSecurity == null || userSecurity.equals("null")) userSecurity = "N";
			
			stmt = conn.createStatement();
						
			//rs = stmt.executeQuery("select appl_user_name, TO_CHAR(SYSDATE,'DD/MM/YYYY') SYDATE from sm_appl_user where appl_user_id='"+user_id+"' ");
			rs = stmt.executeQuery("SELECT apPl_User_Name FROM sm_apPl_User_lang_vw WHERE  apPl_User_Id = '"+user_id+"' AND LANGUAGE_id='"+localeName+"'");
			if(rs != null && rs.next())
			{
				username = rs.getString(1);
			    //datetime			= rs.getString("SYDATE").trim(); commented by S.Sathish for IN021089 on Friday, April 30, 2010
			} if(rs!=null) rs.close();
			
			//datetime=DateUtils.convertDate(datetime,"DMY","en",localeName);
			%>
			<tr>
			<TD width='25%' class= 'label'> <fmt:message key="eFM.FSLocationIdentity.label" bundle="${fm_labels}"/></TD>
			<TD width='25%' class='fields' ><select name="FS_LOCN_ID" id="FS_LOCN_ID"  onChange="PopulateData(this.value)">
					<option value="">---- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>----</option>
					<option value="C"><fmt:message key="Common.clinic.label" bundle="${common_labels}"/></option>
					<option value="N"><fmt:message key="Common.nursingUnit.label" bundle="${common_labels}"/></option>
					<option value="E"><fmt:message key="Common.ProcedureUnit.label" bundle="${common_labels}"/></option>
					<option value="Y"><fmt:message key="Common.DaycareUnit.label" bundle="${common_labels}"/></option>
					<option value="T"><fmt:message key="Common.practitioner.label" bundle="${common_labels}"/></option>
					<option value="D"><fmt:message key="Common.department.label" bundle="${common_labels}"/></option>
				</select>
			</TD>
			<TD width='25%'  class= 'label'> <fmt:message key="eFM.FSLocation.label" bundle="${fm_labels}"/></TD>
			<TD width='25%'  class='fields' ><select name='fslocation' id='fslocation' onChange="showcriteria(this.value);">
				<option value=''>---------- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>----------</option>
				<%
				if(userSecurity.equals("Y"))
				{
					userButtAttr = "Disabled";
				}
				%>
				</select><img src='../../eCommon/images/mandatory.gif' align='center'></img>
				</td>
			</tr>
			<tr>
				<td class='label' > <fmt:message key="Common.requesteddate.label" bundle="${common_labels}"/></td>
				<td class='fields'><input type='text' id='canreqdate' name='receivedate' id='receivedate' maxlength='10' size='17' value='' onBlur='validDateObj(this,"DMY","<%=localeName%>");setDate(this);'><input type="image" src="../../eCommon/images/CommonCalendar.gif"  onClick="return showCalendar('canreqdate');"></td>
				<!--Below line modifed for this SCF ML-MMOH-SCF-0361 -->
				<td class='label' width='15%'><fmt:message key="Common.name.label" bundle="${common_labels}"/></td>
				<td class='fields'><input type='text' name='username1' id='username1'  size='30' value="<%=username%>" readonly><input type='hidden' name='username' id='username' size='30' value='<%=user_id%>' readonly><input type='button' name='searchuser' id='searchuser' value='?' class='button' valign='center' onClick="searchUser(username,'<%=facility_id%>')" <%=userButtAttr%>></td>
			</tr>
			<tr>
					<td class='label' colspan='3' >&nbsp;</td>
					<td class='button' align="right"><input type='button' class='button' name='clear' id='clear' value=' <%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.clear.label","common_labels")%> ' onClick="clearValues();"></td>
			</tr>
		</table>
		<%
		if(rs!=null)	rs.close();
		if(stmt!=null) stmt.close();
	}
	catch(Exception e)
	{
		out.println("Exception e :"+e);
	}
	finally
	{				
		ConnectionManager.returnConnection(conn,request);
	}
%>
	<input type='hidden' name='hdrec_locn_code' id='hdrec_locn_code' value=''>
	<input type='hidden' name='hdrec_locn_iden' id='hdrec_locn_iden' value=''>
	<input type='hidden' name='hdrec_user_id' id='hdrec_user_id' value=''>
	<input type='hidden' name='userSecurity' id='userSecurity' value='<%=userSecurity%>'>
	<input type='hidden' name='access_all' id='access_all' value='<%=access_all%>'>
</form>
</body>
</html>

<%!	
	private String checkForNull(String inputString)
	{
		return (inputString == null) ? "" :	inputString;
	}
	
	public static String checkForNull(String inputString, String defaultValue)
	{
		return(((inputString == null) || (inputString == "") ||(inputString.equals("null"))) ? defaultValue : inputString);
	}
%>

