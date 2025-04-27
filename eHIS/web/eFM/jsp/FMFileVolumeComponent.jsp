<!DOCTYPE html>
<%@ page import="java.sql.Connection, java.sql.ResultSet, java.sql.PreparedStatement,  webbeans.eCommon.ConnectionManager" contentType="text/html; charset=UTF-8" %>

<%
request.setCharacterEncoding("UTF-8");
Connection connection			=	null;
PreparedStatement preStatement	=	null;
ResultSet	resultSet			=	null;

String facilityID 			=	"";
String patient_id 			=	"";
String file_no	 			=	"";
String file_type 			=	"";
String volume_name 			=	"";
String onChangeFunction		=	"";

StringBuffer volumeBuffer	=	new StringBuffer();

try
{
	connection			=	ConnectionManager.getConnection(request);
	
	facilityID 			=	checkForNull((String) session.getValue("facility_id"));
	patient_id 			=	checkForNull(request.getParameter("patient_id"));
	file_no 			=	checkForNull(request.getParameter("file_no"));
	file_type 			=	checkForNull(request.getParameter("file_type"));
	volume_name			=	checkForNull(request.getParameter("volume_name"));
	onChangeFunction	=	checkForNull(request.getParameter("onChangeFunction"));

	if ((volumeBuffer != null) && (volumeBuffer.length() > 0))
		volumeBuffer.delete(0, volumeBuffer.length());
	volumeBuffer.append("SELECT DISTINCT volume_no FROM fm_curr_locn WHERE facility_id = '");
	volumeBuffer.append(facilityID);
	volumeBuffer.append("' and patient_id = '");
	volumeBuffer.append(patient_id);
	volumeBuffer.append("' ");

	if (!file_no.equals(""))
	{
		volumeBuffer.append(" AND file_no = '");
		volumeBuffer.append(file_no);
		volumeBuffer.append("' ");
	}
	if (!file_type.equals(""))
	{
		volumeBuffer.append(" AND file_type_code = '");
		volumeBuffer.append(file_type);
		volumeBuffer.append("' ");
	}
	
	if (volume_name.equals(""))
		volume_name	=	"file_volume";
	%>
		<select name="<%=volume_name%>" id="<%=volume_name%>" onChange="<%=onChangeFunction%>">
		<option value = "">---<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---</option>
	<%
	preStatement	=	connection.prepareStatement(volumeBuffer.toString());
	resultSet		=	preStatement.executeQuery();
	if (resultSet != null)
	{
		while (resultSet.next())
		{
		%>
			<option value='<%=resultSet.getInt("volume_no")%>'><%=resultSet.getInt("volume_no")%></option>
		<%
		}
	}
%>
	</select>
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
	ConnectionManager.returnConnection(connection,request);
}
%>

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

