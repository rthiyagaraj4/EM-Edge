<!DOCTYPE html>
<!-- by Meghanath -->
<%@ page import="java.io.*,java.text.*,java.sql.*,java.util.*,webbeans.eCommon.*" contentType="text/html; charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<HTML>
	<HEAD>
		<!-- <LINK rel='stylesheet' type='text/css' href='../../eCommon/html/IeStyle.css'></LINK> -->
		<%
		request.setCharacterEncoding("UTF-8");
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
		<SCRIPT language='javascript' src='../../eCommon/js/common.js'></SCRIPT>
		<SCRIPT language='javascript' src='../../eCommon/js/ValidateControl.js'></SCRIPT>
		<SCRIPT language='javascript' src='../../eFM/js/QueryFMEncounterDetails.js'></SCRIPT>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	</HEAD>
<%
	Connection conn = null;
	Statement stmt  = null;
	ResultSet rst   = null;

	String facility_id = (String) session.getValue("facility_id");

	String file_type_code       = "";
	String file_type_desc       = "";
	String mysql				= "";

	StringBuffer fileTypeBuffer = null;
	fileTypeBuffer = new StringBuffer();

	mysql="select distinct a.file_type_code,b.short_desc from fm_encounter_volume_link a,mr_file_type b where a.facility_id = b.facility_id AND a.file_type_code = b.file_type_code and a.facility_id='"+facility_id+"' ";
	try
	{
		conn = ConnectionManager.getConnection(request);
		stmt = conn.createStatement();
		rst  = stmt.executeQuery(mysql);
		while(rst != null && rst.next())
		{
			file_type_code = rst.getString("file_type_code");
			file_type_desc = rst.getString("short_desc");

			fileTypeBuffer.append("<OPTION value='"+file_type_code+"'>"+file_type_desc+"</OPTION>");
		}
%>
	<BODY OnMouseDown='CodeArrest();' onKeyDown = 'lockKey();'>
	<FORM name='QFMEDSearchForm' id='QFMEDSearchForm'>
		<TABLE border='0' cellpadding='0'  cellspacing='0' width='100%'>
			<TR><TD class='label' colspan='4'>&nbsp;</TD></TR>
			<TR><TD class='label' width='20%' ><fmt:message key="Common.filetype.label" bundle="${common_labels}"/></TD>
				<TD class='fields' width='30%' ><SELECT name='file_type' id='file_type' onChange='DiableField(this);'><OPTION value=''>----<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>----</OPTION><%=fileTypeBuffer%></SELECT></TD>
				<TD class='label' width='20%' ><fmt:message key="Common.encounterid.label" bundle="${common_labels}"/></TD>
				<TD class='fields' width='30%'><input type='text' size='12'  maxlength='12' name='encounter_id' id='encounter_id' value='' onKeyPress="return allowValidNumber(this,event,12,0)" onBlur="//validSplchars1(this);" readonly><input type="button" name='encounter_id_search' id='encounter_id_search' value="?" class="button" onclick="callSearchScreen();"></TD>
			</TR>
			<TR>
				<TD class='button' colspan='4' ><INPUT type='button' class='button' name='select' id='select' value='Select' onClick="fetchResultPage();"><INPUT type='button' class='button' name='clear' id='clear' value='Clear' onClick="clearAllData();"></TD>
			</TR>
		</TABLE>
		<TABLE border='1' cellpadding='0'  cellspacing='0' width='100%' id='tab' style='visibility:hidden'>
			<TR>
				<Td class='columnheader' width='29%'><fmt:message key="Common.PatientDetails.label" bundle="${common_labels}"/></Td>
				<Td class='columnheader' width='12%' id='th'>&nbsp;</Td>
				<Td class='columnheader' width='15%'><fmt:message key="Common.encounterdatetime.label" bundle="${common_labels}"/></Td>
				<Td class='columnheader' width='8%'><fmt:message key="eFM.VolumeNo.label" bundle="${fm_labels}"/></Td>
				<Td class='columnheader' width='12%'><fmt:message key="Common.practitioner.label" bundle="${common_labels}"/></Td>
				<Td class='columnheader' width='12%'><fmt:message key="eFM.Specialitys.label" bundle="${fm_labels}"/></Td>
				<Td class='columnheader' width='12%'><fmt:message key="Common.Location.label" bundle="${common_labels}"/></Td>
			</TR>
		</TABLE>
	</FORM>
<%	
	if(rst != null) rst.close();
	if(stmt != null) stmt.close();		
	}
	catch(Exception e)
	{
		out.println("Exception e :"+e.toString());
	}
	finally
	{		
		ConnectionManager.returnConnection(conn,request);
	}

%>
	</BODY>
</HTML>

