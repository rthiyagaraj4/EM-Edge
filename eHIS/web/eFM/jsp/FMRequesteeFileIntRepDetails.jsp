<!DOCTYPE html>
<%@ page import ="java.sql.*,java.util.*,java.net.*,java.text.*,webbeans.eCommon.*" contentType="text/html; charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<HTML>
<head>
	<!-- <link rel='stylesheet' type='text/css' href='../../eCommon/html/IeStyle.css'> -->
<%
	request.setCharacterEncoding("UTF-8");
	String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"),"IeStyle.css");
%>

	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
	<script language='javascript' src='../../eCommon/js/ValidateControl.js'></script>
	<script language='javascript' src='../../eCommon/js/common.js'></script>
	<script src='../../eIP/js/IPQueryCommon.js' language='javascript'></script>
	<script language='javascript' src='../../eFM/js/FMInternalReportReprint.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>

<BODY onMouseDown="CodeArrest()" onKeyDown = 'lockKey();'>
<FORM name = 'fm_requestee_form'>
<%
	Connection con					= ConnectionManager.getConnection(request);
	java.sql.Statement stmt		= null;	
	ResultSet rs						= null;	



	String p_check_fcy				= request.getParameter("p_print_enter_fcy");
	String p_selected_fcy			= request.getParameter("selected_fcy");
	String disabled_selected_fcy	= request.getParameter("disabled_selected_fcy");
	String p_chosen_fcy				= request.getParameter("p_chosen_fcy");
	String reset_mode				= request.getParameter("reset_mode");
	String doc_or_file					= request.getParameter("doc_or_file")==null?"F":request.getParameter("doc_or_file");	
	String file_type_yn="";
	String patient_id_length="";
	String p_access_all="";
	String user_id		=	(String)session.getValue("login_user");
	if(p_check_fcy == null) p_check_fcy = "N";
	if(p_selected_fcy == null) p_selected_fcy = "";
	if(disabled_selected_fcy == null) disabled_selected_fcy = "";
	if(p_chosen_fcy == null)
	{
		p_chosen_fcy = "L";
		p_selected_fcy = "YN";
		disabled_selected_fcy ="disabled";
	}
	if(reset_mode==null) reset_mode="";

	try
	{
		stmt	= con.createStatement();

		String facilityid	= (String) session.getValue("facility_id");
		String sql			= "";	
		String sql1			= "";	
		String sql2        ="";
		String p_function	= "insert";
		String p_code		= "";
		String p_desc		= "";

		sql1 = "select FILE_TYPE_APPL_YN,patient_id_length from mp_param " ;

		rs = stmt.executeQuery(sql1);

		while (rs.next())
		{			
		file_type_yn		 = rs.getString("FILE_TYPE_APPL_YN");
		patient_id_length		 = rs.getString("patient_id_length");
		}
	  if(stmt!=null)	stmt.close();
	  if(rs!=null)	rs.close();
	
	stmt		=con.createStatement();
	sql2 = "select 1 rec_cnt , fs_locn_code from fm_user_access_rights where facility_id='"+facilityid+"' and  appl_user_id='"+user_id+"'  and (req_yn='Y' or req_across_facilities_yn='Y') ";
		
		rs   =stmt.executeQuery(sql2);

	if (!rs.next())
		{

		}else{
		p_access_all = rs.getString("fs_locn_code");
		}

	
	if(stmt!=null)	stmt.close();
	if(rs!=null)	rs.close();
	
	
	stmt	= con.createStatement();
		sql = " select facility_id,facility_name from sm_facility_param_lang_vw where facility_id <> '"+facilityid+"' and language_id='"+localeName+"' order by facility_name " ;
		rs = stmt.executeQuery(sql);
	%>
	<table cellpadding='3' cellspacing='0' border='0' width='100%' align='center'>
		<TR><Td colspan='4' class='columnheader'><fmt:message key="eFM.RequestTo.label" bundle="${fm_labels}"/></Td></TR>
		<TR>
			<TD width='25%' class='label'><fmt:message key="Common.facility.label" bundle="${common_labels}"/></TD>
			<TD width='25%' class='fields'>
			<select name=logged_fcy onChange="javascript:log_ent_fcy('<%=p_selected_fcy%>')" <%=disabled_selected_fcy%> <%=reset_mode%>>

			<% if(p_selected_fcy.equals("YN")) { %>
				<option value='L' selected><fmt:message key="Common.loggedinfacility.label" bundle="${common_labels}"/></option>

			<% } else if(p_selected_fcy.equals("NY")) { %>
				<option value='E' selected><fmt:message key="Common.enterprisefacility.label" bundle="${common_labels}"/></option>

			<% }
				else
				{ 
					if(p_chosen_fcy.equals("L"))
					{
						%>
						<option value='L' selected><fmt:message key="Common.loggedinfacility.label" bundle="${common_labels}"/></option>
						<option value='E' ><fmt:message key="Common.enterprisefacility.label" bundle="${common_labels}"/></option>
						<%
					}
					else
					{
						%>
						<option value='L' ><fmt:message key="Common.loggedinfacility.label" bundle="${common_labels}"/></option>
						<option value='E' selected><fmt:message key="Common.enterprisefacility.label" bundle="${common_labels}"/></option>
						<%
					}
				}
				%>
				</select>
			</TD>
			
		<%
		if(p_check_fcy.equals("N"))
		{
			%>
				<TD width = '25%'   ></TD>
				<TD width = '25%'    ></TD>
			<%
		}
		else
		{
			%>
			<TD width='25%' class='label'><fmt:message key="Common.facility.label" bundle="${common_labels}"/></TD>	
			<TD width ='25%'  class= 'fields'>
				<select name=enter_fcy onChange="getExternalFiles(this.value)">
				<option value=''>------ <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>------</option>
				<%
				while(rs.next())
				{
					p_code = rs.getString("facility_id");
					p_desc = rs.getString("facility_name");

					if(facilityid.equals(p_code))
					{
						%>
						<option value='<%=p_code%>' selected><%=p_desc%></option>
						<%
					}
					else
					{
						%>
						<option value='<%=p_code%>' ><%=p_desc%></option>
						<%
					}
				}
				if(rs!=null)	rs.close();
				%>
				</select>
				</TD>
			</TR>
			<%
		}
		%>
	      <tr>
			<td class='label'><fmt:message key="Common.patientId.label" bundle="${common_labels}"/></td>
			<td class='fields'><input type='text' name=patientid size='18' maxlength='<%=patient_id_length%>' value='' onBlur="ChangeUpperCase(this);CheckPatientExists(this.value);" onKeyPress='return CheckForSpecChars(event)'><input  type=button name=search value='?' class=button onClick="callPatientSearch()" ><img align='center' src='../../eCommon/images/mandatory.gif'></img></td>
		<td class='label' nowrap><%
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
		%></td>
		<td id="fileid" class='fields'><input type='text' name='fileno' id='fileno' size='15' maxlength='15' value='' onKeyPress='return CheckForSpecChars(event)' onBlur="CheckFileExists(this.value)"></td>
		</tr>
		<tr>
		<td class='label'  nowrap><fmt:message key="eFM.VolumeNo.label" bundle="${fm_labels}"/></td>
			
		<td id="volid" class='fields'><select name='volumeno' id='volumeno'>
			<option value=''>---<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---</option></select></td>
		<td class='label' colspan='2'></td>
		</tr>
		<tr>
			<td class='label' width='25%' ><fmt:message key="Common.encounterid.label" bundle="${common_labels}"/></td>
			<td class='fields' width='25%' ><input type='text'  size='12'  maxlength='12' name='encounter_id' id='encounter_id' onKeyPress="return allowValidNumber(this,event,12,0)" onBlur="validSplchars1(this);CheckNumber(this); checkEncounter(this);" disabled><input type="button" name='encounter_id_search' id='encounter_id_search' value="?" class="button" onclick="callSearchScreen('E');" disabled></td>
			<TD width = '25%'   ></TD>
			<TD width = '25%'    ></TD>
			<input type='hidden' name='f_curr_fs_locn' id='f_curr_fs_locn' value=''>
		</tr>
		
		</TABLE>
	<input type='hidden' name=functionval value='<%=p_function%>'>
	<input type='hidden' name=doc_or_file value='<%=doc_or_file%>'>
	<input type='hidden' name=p_access_all value='<%=p_access_all%>'>
	</FORM>
<%
if(stmt!=null) stmt.close();
}
catch(Exception e)
{
	out.println("Exception e :"+e);
}
finally
{		
	ConnectionManager.returnConnection(con,request);
}
%>
</BODY>
</HTML>


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

