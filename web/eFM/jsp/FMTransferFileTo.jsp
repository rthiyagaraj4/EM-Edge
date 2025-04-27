<!DOCTYPE html>
<%@ page import ="java.sql.*, java.text.*,webbeans.eCommon.*" contentType="text/html; charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<html>
<head>
	<!-- <link rel='stylesheet' type ='text/css' href='../../eCommon/html/IeStyle.css'></link> -->
	<%
	request.setCharacterEncoding("UTF-8");
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

%>

	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
	<script language="javascript" src="../../eCommon/js/jquery-3.6.3.js"></script> <!-- Added by Sangeetha for GDOH-CRF-0133 -->
	<script language='javascript' src='../../eCommon/js/common.js'></script>
	<script language='javascript' src='../../eCommon/js/ValidateControl.js'></script>
	<script language='javascript' src='../../eFM/js/FMPractitionerComponent.js'></script>
	<script language='javascript' src='../../eFM/js/FMTransferFile.js'></script>
	<Script src="../../eCommon/js/CommonLookup.js" language="JavaScript"></Script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


</head>
<%
	Connection conn			= ConnectionManager.getConnection(request);
	java.sql.Statement stmt	= null;
	ResultSet rs			= null;

	String facility_id		= (String) session.getValue("facility_id");
	String sql1				= "";
	String from_locn_code	= request.getParameter("From_locn_code");
	boolean isCurrentFsLocation = false; //Added by Sangeetha for ML-MMOH-CRF-0345.2 on 17/07/17

	if(from_locn_code == null || from_locn_code.equals("null")) from_locn_code = "NOTDEFINED";
	try 
	{
		//Added by Sangeetha for ML-MMOH-CRF-0345.2 on 17/07/17
		isCurrentFsLocation = eCommon.Common.CommonBean.isSiteSpecific(conn,"FM","CURR_FS_LOCATION_SEARCH");
%>
<body OnMouseDown='CodeArrest()' onKeyDown = 'lockKey();'>
<form name='FMTransferFileTo_form' id='FMTransferFileTo_form'>
	<table border='0' cellpadding='3' cellspacing='0' width='100%' align='center'>
	<% //Added by Sangeetha for ML-MMOH-CRF-0345.2 on 17/07/17
	if(isCurrentFsLocation){ %>
		<tr height="60"> 
			<td class='label' width="10%" ><fmt:message key="eFM.CurrentFSLocation.label" bundle="${fm_labels}"/></td>
			<td width = '20%' class='label' id="FS_Locn_display"></td>
		</tr>
		<tr><td>&nbsp;</td></tr>
	<%}%>
	<th colspan='2' class='columnheader'><fmt:message key="Common.TransferTo.label" bundle="${common_labels}"/></th>
	<TR>
		<TD width='40%' class= 'label'><fmt:message key="eFM.FSLocationIdentity.label" bundle="${fm_labels}"/></TD>
		<TD width='60%' class='fields' >
			<select name="FS_LOCN_ID" id="FS_LOCN_ID"  onChange="PopulateToData(this.value)">
				<option value="">---------- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>----------</option>
				<option value="C"><fmt:message key="Common.clinic.label" bundle="${common_labels}"/></option>
				<option value="N"><fmt:message key="Common.nursingUnit.label" bundle="${common_labels}"/></option>
				<option value="Y"><fmt:message key="Common.DaycareUnit.label" bundle="${common_labels}"/></option>
				<option value="E"><fmt:message key="Common.ProcedureUnit.label" bundle="${common_labels}"/></option>
				<option value="T"><fmt:message key="Common.practitioner.label" bundle="${common_labels}"/></option>
				<option value="D"><fmt:message key="Common.department.label" bundle="${common_labels}"/></option> 
			</select>
		</TD>
	</TR>
	<TR>
		<TD class= 'label'><fmt:message key="eFM.FSLocation.label" bundle="${fm_labels}"/></TD>
		<TD class='fields' ><select name='tofslocn' id='tofslocn' onChange='chkToVal();'>
			<option value=''>---------------- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>----------------</option>
			</select><img src='../../eCommon/images/mandatory.gif' align='center'></img>
		</TD>
	</TR>
	<TR>
		<TD class="LABEL" id="returning"><fmt:message key="Common.TransferTo.label" bundle="${common_labels}"/></TD>
		<TD class='fields'><input type="text" name="returning_desc" id="returning_desc" value="" onChange="getToValidRecords(this);" disabled><input type="Hidden" name="returning_code" id="returning_code" value=""><input type="button" name="ret_button" id="ret_button" value="?" class="BUTTON" onClick="getToValidRecords(returning_desc);" disabled><IMG src='../../eCommon/images/mandatory.gif' align='center' id="mandat1"></IMG></TD>
	</TR>
	<TR>
		<TD class='label' ><fmt:message key="eFM.Narration.label" bundle="${fm_labels}"/></TD>
		<TD class='fields'><select name='narration' id='narration'>
		<OPTION value=''>------------ <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>------------</OPTION>
	<%
	
		if(!(from_locn_code.equals("NOTDEFINED"))) 
		{
			sql1 = "SELECT  NARRATION_CODE , SHORT_DESC FROM   fm_narration_lang_vw WHERE EFF_STATUS = 'E'  AND LANGUAGE_ID='"+localeName+"' ORDER BY 2";

			stmt = conn.createStatement();
			rs	 = stmt.executeQuery(sql1);
			
			while(rs != null && rs.next()) 
			{
				String ID1		= rs.getString(1);
				String desc1	= rs.getString(2);
				out.println("<option value='"+ID1+"'>"+desc1+"</option>");
			}
		}
		%>
		</select><!-- this hidden button is for alignment purpose --><INPUT TYPE="button" style='visibility:hidden'>
		</td>
	</tr>
	<%
	if(rs!=null)	rs.close();
	if(stmt!=null) stmt.close();
	}catch(Exception e){out.println(e);}
	finally 
	{		
		ConnectionManager.returnConnection(conn,request);
	}
	%>
</table>
<input type='hidden' name='facility_id' id='facility_id' value='<%=facility_id%>'>
</form>
</body>
</html>

