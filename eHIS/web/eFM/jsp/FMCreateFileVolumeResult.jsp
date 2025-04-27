<!DOCTYPE html>
<!-- by Meghanath -->
<%@ page import="java.sql.*, java.util.*, java.text.*,webbeans.eCommon.*" contentType="text/html; charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<HTML>
	<HEAD>
		<!-- <LINK rel='stylesheet' type ='text/css' href='../../eCommon/html/IeStyle.css'></LINK> -->
	<%
	request.setCharacterEncoding("UTF-8");
	String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"),"IeStyle.css");
	
	%>

	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
		<SCRIPT language='javascript' src='../../eCommon/js/common.js'></SCRIPT>
		<SCRIPT language='javascript' src='../../eCommon/js/ValidateControl.js'></SCRIPT>
		<SCRIPT language='javascript' src='../../eFM/js/FMCreateFileVolume.js'></SCRIPT>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	</HEAD>
	<%
	Connection con			= null;
	java.sql.Statement stmt	= null;
	ResultSet	rs			= null;
	
	String facilityid 				= (String) session.getValue("facility_id");
	
	String patient_id				= "";
	String p_file_no				= "";
	String p_file_type_code			= "";
	String file_type_appl_yn		= "";
	String volume_status			= "";
	String criteria					= "";	
	String mysql1					= "";
	String flag						= "true";

	int volume_no			= 0;
	int new_volume_number	= 0;
	
	try
	{
		con				  =	ConnectionManager.getConnection(request);
		
		patient_id		  = checkForNull(request.getParameter("patient_id"));
		p_file_no		  = checkForNull(request.getParameter("file_no"));
		p_file_type_code  = checkForNull(request.getParameter("file_type_code"));
		file_type_appl_yn = checkForNull(request.getParameter("file_type_appl_yn"));
				
		if(file_type_appl_yn.equals("Y"))
		{
			criteria = " AND FILE_TYPE_CODE = '"+p_file_type_code+"' ";
		}
		
		// Modified by Muthu on 12/03/2010 Issue :- File no is not getting created if the latest volume is in lost status
		mysql1 = "SELECT MAX(volume_no) volume_no, volume_status  status FROM fm_curr_locn WHERE facility_id = '"+facilityid+"' AND patient_id = '"+patient_id+"' AND FILE_NO = '"+p_file_no+"' "+criteria+" GROUP BY volume_status ORDER BY volume_no desc";
		// End of Comment
	
		stmt = con.createStatement();
		rs   = stmt.executeQuery(mysql1);

		if(rs != null && rs.next())
		{
			volume_no     = rs.getInt("volume_no");
			volume_status = rs.getString("status");
			if(volume_no > 0)
				new_volume_number = volume_no + 1;
		}

		if(!volume_status.equals(""))
			{
				switch(volume_status.charAt(0))
				{
					case 'A' : volume_status = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.active.label","common_labels"); break;

					case 'I' : volume_status = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Inactive.label","common_labels"); break;

					case 'L' : volume_status = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Lost.label","common_labels"); break;

			
				}
			}
		
		if(volume_no == 0 || new_volume_number == 0)
		{
			flag = "false";
			%>
			<SCRIPT>
				alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','common'));
			</SCRIPT>
			<%
		}
		%>
		<BODY  onMouseDown='CodeArrest()' onKeyDown = 'lockKey();'>
			<form name='FMCreateFileVolumeResultForm' id='FMCreateFileVolumeResultForm' action='../../servlet/eFM.FMCreateFileVolumeServlet' method='post' target='messageFrame'>
			<BR><BR><BR><BR><BR>
			<%	
			if(flag.equals("true"))
			{
				%>
				<TABLE cellpadding='5' cellspacing='0' border='0' width='50%' align="CENTER">
					<TR>
						<TD class='label' width='50%'><fmt:message key="eFM.CurrrentVolumeNumber.label" bundle="${fm_labels}"/></TD>
						<TD class='fields' width='50%'><INPUT type='text' name='volume_no' id='volume_no' value='<%=volume_no%>' size='3' readonly></TD>
					</TR>
					<TR>
						<TD class='label' ><fmt:message key="eFM.CurrrentVolumeStatus.label" bundle="${fm_labels}"/></TD>
						<TD class='querydata' ><%=volume_status%></TD> 
					</TR>
					<TR>
						<TD class='label' ><fmt:message key="eFM.NewVolumeNumber.label" bundle="${fm_labels}"/></TD>
						<TD class='fields'><INPUT type='text' name='new_volume_number' id='new_volume_number' value='<%=new_volume_number%>' size='3'  readonly></TD>
					</TR>
				</TABLE>
				<INPUT type=hidden name='patient_id' id='patient_id' value='<%=patient_id%>'>
				<INPUT type=hidden name='p_file_no' id='p_file_no' value='<%=p_file_no%>'>
				<INPUT type=hidden name='p_file_type_code' id='p_file_type_code' value='<%=p_file_type_code%>'>
				<INPUT type=hidden name='file_type_appl_yn' id='file_type_appl_yn' value='<%=file_type_appl_yn%>'>
				<SCRIPT>
					parent.frames[1].document.forms[0].patient_id.disabled = true;
				</SCRIPT>
				<%
			}
		if(rs!=null)	rs.close();
		if(stmt!=null) stmt.close();
		}catch(Exception e){out.println("Exception :"+e.toString());}
		finally
		{				
			ConnectionManager.returnConnection(con,request);			
		}
		%>
</FORM>
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

