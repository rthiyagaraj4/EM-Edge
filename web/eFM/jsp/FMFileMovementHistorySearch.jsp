<!DOCTYPE html>
<%@ page import ="java.sql.*,java.util.*,java.net.*,java.text.*,webbeans.eCommon.*"  contentType="text/html; charset=UTF-8" %> 
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<%
	String p_module_id		= "FM" ;
	String p_report_id		= "FMBFMVHS" ;
	String p_facility_id	= (String) session.getValue( "facility_id" ) ;
	String p_user_name		= (String) session.getValue( "login_user" ) ;
%>
<head>
<!-- <link rel='stylesheet' type='text/css' href='../../eCommon/html/IeStyle.css'> -->
<%
	request.setCharacterEncoding("UTF-8");
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<link rel="stylesheet" type="text/css" href="../../eCommon/html/CommonCalendar.css"></link>
<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
<script src='../../eCommon/js/common.js' language='javascript'></script>
<script src='../../eFM/js/FMRepFileMovement.js' language='javascript'></script>
<script language='javascript' src='../../eFM/js/checkSystemDate.js'></script>
<script language='javascript' src="../../eCommon/js/CommonCalendar.js"></script>
<script language='javascript' src='../../eCommon/js/DateUtils.js'></script>
</head>

<body OnMouseDown='CodeArrest();' onload='document.forms[0].patientid.focus();' onKeyDown = 'lockKey();'>
<%
	Connection conn = ConnectionManager.getConnection(request);
	String facility_id = (String) session.getValue("facility_id");
	
	Statement stmt=null;
	ResultSet rset=null;
	ResultSet rs=null;

	String sql = "",p_file_no_length="";
	String today ="";
	String file_type_yn = "";

	try
	{	
		stmt = conn.createStatement();
		int p_patient_id_length		= 0 ;
		String p_separate_file_no_yn = "";
		String p_no_rec_in_facility = "N";

		sql = "select patient_id_length,separate_file_no_yn,FILE_TYPE_APPL_YN from mp_param " ;

		rs = stmt.executeQuery(sql);

	while (rs.next())
	{
		p_patient_id_length = rs.getInt("patient_id_length");
		p_file_no_length		 = rs.getString("separate_file_no_yn");
		file_type_yn		 = rs.getString("FILE_TYPE_APPL_YN");
	}
	if(rs!=null)	rs.close();
	sql = "select separate_file_no_yn from mp_param_for_facility where facility_id = '"+facility_id+"'" ;

	rs = stmt.executeQuery(sql);

	if (rs.next())
	{
		p_separate_file_no_yn = rs.getString("separate_file_no_yn");
		p_no_rec_in_facility = "Y";
	}
	
	if (p_no_rec_in_facility.equals("Y"))
	{
		if (p_separate_file_no_yn.equals("N"))
			p_file_no_length =  Integer.toString(p_patient_id_length);
		else
			p_file_no_length	=	"20";
	}
	else
	{
		if (p_file_no_length.equals("N"))
			p_file_no_length =  Integer.toString(p_patient_id_length);
		else
			p_file_no_length	=	"20";
	}
		
		sql = "select to_char(sysdate,'dd/mm/yyyy')today from dual";	
		rset = stmt.executeQuery(sql);
		if (rset.next())
		{
		today = rset.getString("today");
		}

%>
	<form name='ManualEntry_form' id='ManualEntry_form' target='messageFrame' action="../../eCommon/jsp/report_options.jsp">
	
	<table border='0' cellpadding='3' cellspacing='0' width='100%' align='center'>
	<tr><td colspan='4'>&nbsp;</td></tr>	
	<tr>
		<td class='label' width='20%'><fmt:message key="Common.patientId.label" bundle="${common_labels}"/></td>
		<td class='fields' width='30%'><input type='text' name='patientid' id='patientid' value=''	tabIndex="1" onBlur="ChangeUpperCase(this);CheckPatientExists(this.value)" onKeyPress='return CheckForSpecChars(event)' size='20' maxlength=<%=p_patient_id_length%> ><input type=button name=search value='?' tabIndex="6"   class=button onClick="callPatientSearch()"><img src='../../eCommon/images/mandatory.gif' align='center'></img></td>
		<td class='label' width='20%' >
		<%
		if (file_type_yn.equals("N"))
  		{
		%>
			<fmt:message key="Common.fileno.label" bundle="${common_labels}"/>
		<%
	    }else{
		%>
			<fmt:message key="Common.filetype.label" bundle="${common_labels}"/>
		<%
	    }
		%>
		</td>
		<td  width='30%' id="fileid" class='fields'><input type='text' name='fileno' id='fileno' size='20'  tabIndex="2" maxlength='<%=p_file_no_length%>' value='' onKeyPress='return CheckForSpecChars(event)' onBlur="CheckFileExists(this.value)" ><img src='../../eCommon/images/mandatory.gif' align='center'></img>
		</td>
	</tr>
	<tr>
		<td  class='label'  ><fmt:message key="eFM.VolumeNo.label" bundle="${fm_labels}"/></td>
		<td class='fields' id="volid"><select name='volumeno' id='volumeno'><option value=''>----<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>----</option></select></td>
<!-- 	</tr>	
	<tr>  -->
		<td class='label' ><fmt:message key="Common.date.label" bundle="${common_labels}"/></td>
		<td  class='fields'><input type='text' id="date_from" name='p_from_date' id='p_from_date' size='10' maxlength='10' tabIndex="3" value='' onBlur='validDateObj(this,"DMY","<%=localeName%>");'><input type="image" src='../../eCommon/images/CommonCalendar.gif' onClick="return showCalendar('date_from');">&nbsp;-&nbsp;<input type='text' id="date_to" name='p_to_date' id='p_to_date' size='10' maxlength='10' value='' tabIndex="4" onBlur='validDateObj(this,"DMY","<%=localeName%>");'><input type="image"  src='../../eCommon/images/CommonCalendar.gif' onClick="return showCalendar('date_to');"></td>
		</tr>
		 <tr><td colspan='4'>&nbsp;</td></tr>
				
	</table>
<%
	if(rs!=null)	rs.close();
	if(rset!=null)	rset.close();
	if(stmt!=null)	stmt.close();
	}
	catch(Exception e)
	{
		out.println(e);
	}
	finally
	{		
		ConnectionManager.returnConnection(conn,request);
	}
%>
	<input type="hidden" name="p_facility_id" id="p_facility_id"		value="<%= p_facility_id %>">
	<input type="hidden" name="file_type_yn" id="file_type_yn"		value="<%= file_type_yn %>">
	<input type="hidden" name="p_module_id" id="p_module_id" 		value="<%= p_module_id %>">
	<input type="hidden" name="p_report_id" id="p_report_id" 		value="<%= p_report_id %>">
	<input type="hidden" name="p_user_name" id="p_user_name"			value="<%= p_user_name %>">
	<input type="hidden" name="today" id="today"				value="<%=today%>">
	<input type='hidden' name='validFile' id='validFile' value=''>
	<input type='hidden' name='file_type_code' id='file_type_code' value=''>
	<%-- <INPUT TYPE="hidden" name="p_language_id" id="p_language_id" value="<%=localeName%>"> --%>
</form>
</body>
</html>

