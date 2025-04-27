<!DOCTYPE html>
<%@ page import="java.sql.Connection, java.sql.ResultSet,java.sql.PreparedStatement,  webbeans.eCommon.ConnectionManager" contentType="text/html; charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<%
	request.setCharacterEncoding("UTF-8");
Connection connect				=	null;
PreparedStatement preStatement	=	null;
ResultSet	resultSet			=	null;

String system_date	= "";

try
{
	connect			=	ConnectionManager.getConnection(request);
	preStatement	=	connect.prepareStatement("SELECT to_char(sysdate, 'dd/mm/rrrr hh24:mi') system_date from dual");
	resultSet		=	preStatement.executeQuery();

	if((resultSet != null) && (resultSet.next()))
	{
		system_date		=	checkForNull(resultSet.getString("system_date"));
	}
	if(preStatement!=null) preStatement.close();
	if(resultSet!=null)	resultSet.close();
%>	

<html>
<head><title><fmt:message key="eFM.FileTransportDetails.label" bundle="${fm_labels}"/></title>
	<!-- <link rel='stylesheet' type ='text/css' href='../../eCommon/html/IeStyle.css'></link> -->
	<%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
	<script language='javascript' src='../../eCommon/js/common.js'></script>
	<script language='javascript' src='../../eCommon/js/ValidateControl.js'></script>
	<script language='javascript' src='../../eFM/js/FMLinkEncounterVolume.js'></script>
	<Script src="../../eCommon/js/CommonLookup.js" language="JavaScript"></Script>
	<script language='javascript' src='../../eFM/js/FMReturnToMRD.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<body onMouseDown = "CodeArrest();" onLoad="FocusFirstElement();" onKeyDown = 'lockKey();'> 
<form name='FMReturnToMRDTransportForm' id='FMReturnToMRDTransportForm' action='FMReturnToMRDResult.jsp' method='POST' target="result_frame">
<table cellpadding='0' cellspacing='0' border='0' width='100%'>
<tr>
	<td class="LABEL" width="40%"><fmt:message key="Common.datetime.label" bundle="${common_labels}"/></td>
	<td class='fields' width="60%"><input type="text" name="date_time" id="date_time" value="<%=system_date%>" readonly size="14">
	</td>
</tr>
<tr>
	<td class="LABEL" width="40%"><fmt:message key="Common.FileTransportMode.label" bundle="${common_labels}"/></td>
	<td width="60%" class='fields'><select name="transport_mode" id="transport_mode" onChange="enableTransportMode(this.value);">
			<option value="">----------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---------</option>
			<%
				String code  = "";
				String desc  = "";
				String flag  = "";
				StringBuffer valueBuffer	=	new StringBuffer();
				if (preStatement != null)  preStatement = null;
				if (resultSet != null)  resultSet = null;
				preStatement	=	connect.prepareStatement("SELECT transport_mode, short_desc, by_person_yn FROM am_transport_mode WHERE file_related_yn = 'Y' AND eff_status = 'E' ORDER BY short_desc");
				resultSet		=	preStatement.executeQuery();

				if(resultSet != null)
				{
					while(resultSet.next())
					{
						code	=	checkForNull(resultSet.getString("transport_mode"));
						desc	=	checkForNull(resultSet.getString("short_desc"));
						flag	=	checkForNull(resultSet.getString("by_person_yn"));
						if (valueBuffer.length() > 0)
							valueBuffer.delete(0, valueBuffer.length());
						valueBuffer.append(code);
						valueBuffer.append("||");
						valueBuffer.append(flag);
					%>
					<option value="<%=valueBuffer.toString()%>"><%=desc%></option>
					<%
					}
				}
			%>
		</select>
		<input type="text" name="transport_mode_desc" id="transport_mode_desc" disabled></td>
</tr>
<tr><td colspan="2" class="LABEL">&nbsp;</td></tr>
<tr>
	<td colspan="2" align="CENTER"><input type="Button" class="BUTTON" name="ok_button" id="ok_button" value="OK" style='width:45' onClick="closeWindow();">&nbsp;<input type="reset" class="BUTTON" name="clear_button" id="clear_button" value="Clear" style='width:45'></td>
</tr>
</table>
<%
if(preStatement!=null) preStatement.close();
if(resultSet!=null)	resultSet.close();
}
catch(Exception e)
{
	out.println("Exception : " + e.toString());
}
finally
{	
	ConnectionManager.returnConnection(connect,request);
}
%>
<input type="Hidden" name="added_items" id="added_items" value="">
<input type="Hidden" name="added_patients" id="added_patients" value="">
<input type="Hidden" name="added_volumes" id="added_volumes" value="">
<input type="Hidden" name="show_all_yn" id="show_all_yn" value="Y">
</form>
</body>
</html>

<%!

public static String checkForNull(String inputString)
{
	return(((inputString == null) || (inputString.equals("null")) ) ? "" : inputString);
}

public static String checkForNull(String inputString, String defaultValue)
{
	return(((inputString == null) || (inputString.equals("null")) ) ? defaultValue : inputString);
}

%>

