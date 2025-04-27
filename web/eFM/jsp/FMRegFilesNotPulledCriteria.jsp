<!DOCTYPE html>
<%@ page import="java.util.*, java.sql.*, webbeans.eCommon.*" contentType="text/html; charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<%
	request.setCharacterEncoding("UTF-8");

	String facility_id="", user_id="", fs_locn_code="", fs_locn_desc="", user_security_yn="";	
	Connection con	=	null;
	java.sql.Statement stmt	=	null;
	ResultSet rs	=	null;

	java.sql.Statement stmt2	=	null;
	ResultSet rs2	=	null;
	String sql2		= "";
	String access_all = "";
	String sys_date = "";

	try
	{
		con			=	ConnectionManager.getConnection(request);
		facility_id	=	(String)session.getValue("facility_id");
		user_id		=	(String)session.getValue("login_user");
		stmt		=	con.createStatement();

		String fm_param_query="select user_security_yn, to_char(SYSDATE,'DD/MM/YYYY') SYDATE from fm_parameter where facility_id='"+facility_id+"'";

	//	String sm_user_query="SELECT appl_user_id, appl_user_name from sm_facility_for_user_vw where  facility_id='"+facility_id+"' order by 2";

		rs = stmt.executeQuery(fm_param_query);
		if(rs.next())
		{
			user_security_yn = rs.getString("user_security_yn");
			sys_date		 = rs.getString("SYDATE");
		}
		if(rs!=null)	rs.close();	
		if(stmt!=null) stmt.close();

		if(user_security_yn == null || user_security_yn.equals("null"))user_security_yn="N";

		String fs_locn_query = "";
		if(user_security_yn.equals("Y"))
		{
			stmt2 = con.createStatement();
			sql2 = "select 1 rec_cnt from fm_user_access_rights where appl_user_id='"+user_id+"' and facility_id='"+facility_id+"' and fs_locn_code='*ALL' ";

			rs2 = stmt2.executeQuery(sql2);
			while(rs2.next())
			{
				access_all = rs2.getString("rec_cnt");
			}
			if(rs2 != null)		rs2.close();

			if (access_all.equals("1"))
			{
				fs_locn_query="SELECT fs_locn_code, short_desc fs_locn_desc FROM fm_storage_locn WHERE facility_id = '"+facility_id+"' AND eff_status='E' AND PERMANENT_FILE_AREA_YN = 'Y' Order by 2";
			}
			else
			{
				fs_locn_query="SELECT fs_locn_code, fs_locn_short_desc fs_locn_desc FROM fm_user_access_rights_vw WHERE facility_id = '"+facility_id+"' AND appl_user_id='"+user_id+"'  AND TRACK_OUT_TO_OPD='Y' AND PERMANENT_FILE_AREA_YN = 'Y' Order by 2";
			}
		}
		else
		{
			fs_locn_query="SELECT fs_locn_code, short_desc fs_locn_desc FROM fm_storage_locn WHERE facility_id = '"+facility_id+"' AND eff_status='E' AND PERMANENT_FILE_AREA_YN = 'Y' Order by 2";
		}
	%>
<html>
<head>
	<title><fmt:message key="eFM.RegisterFileNotPulled.label" bundle="${fm_labels}"/></title>
	<!-- <link rel='stylesheet' type='text/css' href='../../eCommon/html/IeStyle.css'></link> -->
	<%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
	<script src='../../eCommon/js/ValidateControl.js'></script>
	<script src='../../eFM/js/FMRegFilesNotPulled.js'></script>
	<script language='javascript' src='../../eCommon/js/common.js'></script>
	<script language='javascript' src='../../eCommon/js/DateUtils.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<body onMouseDown='CodeArrest()' onKeyDown = 'lockKey();'>
	<form name='RegFileNotPulledForm' id='RegFileNotPulledForm' action='' target=''>
		<table cellpadding='0' cellspacing='0' border='0' width='100%' align='center'>
		<tr><td colspan='4'>&nbsp;</td></tr>
		<tr>
		<td  class='label'><fmt:message key="eFM.FSLocation.label" bundle="${fm_labels}"/></td>
		<td class='fields'><select name='fs_locn_code' id='fs_locn_code' onChange=''><option value=''>-------- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> -------</option>
		<%
			if(stmt != null) stmt=null;
			stmt =	con.createStatement();
			rs = stmt.executeQuery(fs_locn_query);
			int count=0;
			String selected="";
			while(rs.next())
			{
				count++;
				fs_locn_code	=	rs.getString("fs_locn_code");
				fs_locn_desc	=	rs.getString("fs_locn_desc");

				if(fs_locn_code == null)fs_locn_code="";
				if(fs_locn_desc == null)fs_locn_desc="";

				if(count==1)selected="";
				else selected="";

				out.println("<option value="+fs_locn_code+" "+selected+" >"+fs_locn_desc+"</option>");
			}
		%>
		</select><img src='../../eCommon/images/mandatory.gif'></img></td>
		<td  class='label'><fmt:message key="eFM.GeneratedBy.label" bundle="${fm_labels}"/></td>
		<td class='fields'>
		<%
			if(user_security_yn.equals("Y"))
		{
		%>
			<input type='text' name='appl_user_id' id='appl_user_id' value='<%=user_id%>' size='40' disabled maxlength=30 ><input type=button name=searchcode value='?' class=button onClick="searchCode(appl_user_id,'<%=facility_id%>')" disabled></td>
		<%
		}
		else
		{
		%>
			<input type='text' name='appl_user_id' id='appl_user_id' value='<%=user_id%>' size='40' readonly maxlength=30 ><input type=button name=searchcode value='?' class=button onClick="searchCode(appl_user_id,'<%=facility_id%>')"></td>
		<%
		}
		%>
	</tr>

	<tr>
		<td class='label' ><fmt:message key="Common.AppointmentDate.label" bundle="${common_labels}"/></td>
		<td class='fields' ><input type='text' name='appt_date' id='appt_date' value='<%=sys_date%>' size='10' maxlength='10' onBlur='validDateObj(this,"DMY",localeName);'><img src='../../eCommon/images/mandatory.gif'></img></td>
		<td colspan='2' align='center'><input type='button' name='subBotton' id='subBotton' class='button' value='Show Unpulled Files' onClick='fetchResults(appt_date,fs_locn_code);'></td>
		</tr>
		<tr><td colspan='4'><input type='hidden' name='CBValStr' id='CBValStr' value=''></td></tr>
		</table>
		<script>
			if ('<%=count%>'==1)
			{
				document.forms[0].fs_locn_code.value = '<%=fs_locn_code%>';
			}
		</script>

	</form>
</body>
</html>
			<%
	if(rs != null)		rs.close();
	if(stmt != null)	stmt.close();		
	if(stmt2 != null)	stmt2.close();
	}
	catch(Exception e)
	{
		out.println("Exception in main try"+e);
	}
	finally
	{		
		ConnectionManager.returnConnection(con,request);
	}
%>

