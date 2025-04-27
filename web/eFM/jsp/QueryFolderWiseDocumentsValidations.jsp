<!DOCTYPE html>
<%@ page import="java.sql.Connection, java.sql.ResultSet, java.sql.Statement, java.sql.PreparedStatement,  webbeans.eCommon.ConnectionManager" contentType="text/html; charset=UTF-8" %>
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
<script language='javascript' src='../../eCommon/js/common.js'></script>
<script language='javascript' src='../../eCommon/js/ValidateControl.js'></script>
<script language='javascript' src='../../eCommon/js/CommonCalendar.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<%
Connection connection			=	null;
PreparedStatement preStatement	=	null;
ResultSet	resultSet			=	null;

try
{
	String sqlString			=	"";
	String facilityID 			=	checkForNull((String) session.getValue("facility_id"));
	String operation			=	checkForNull(request.getParameter("operation"));
	String specific				=	checkForNull(request.getParameter("specific"));

	connection					=	ConnectionManager.getConnection(request);	

	if (operation.equals("SpecificFolders"))
	{
		sqlString	=	" SELECT doc_folder_id, doc_folder_name, patient_id, from_period, to_period FROM fm_doc_folder WHERE facility_id = ? AND patient_period_specific = ? AND eff_status = 'E' ";	

		preStatement	=	connection.prepareStatement(sqlString);	
		preStatement.setString(1, facilityID);
		preStatement.setString(2, specific);
		resultSet		=	preStatement.executeQuery();
		if (resultSet!=null)
		{
			while(resultSet.next())
			{

			}
		}
	}
	if(resultSet!=null)	resultSet.close();
	if(preStatement!=null) preStatement.close();
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
</html>
<%!

public static String checkForNull(String inputString)
{
	return(((inputString == null) || (inputString.equals("null")) ) ? "" : inputString);
}


%>

