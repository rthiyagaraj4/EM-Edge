<!DOCTYPE html>
<%@ page import="java.sql.Connection, java.sql.ResultSet,  java.sql.PreparedStatement,  webbeans.eCommon.ConnectionManager" contentType="text/html; charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
<head>
<!-- <link rel='stylesheet' type ='text/css' href='../../eCommon/html/IeStyle.css'></link> -->
<%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
request.setCharacterEncoding("UTF-8");
%>

	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>

<script language='javascript' src='../../eCommon/js/common.js'></script>
<script language='javascript' src='../../eCommon/js/ValidateControl.js'></script>
<script language='javascript' src='../../eCommon/js/CommonCalendar.js'></script>
<script language="javascript" src="../../eCommon/js/rowcolor.js" ></script>
<script src="../../eFM/js/DTDocumentNumberLookup.js" language="javascript"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<%
Connection connection			=	null;
PreparedStatement preStatement	=	null;
ResultSet	resultSet			=	null;
try
{	
//	String search_text	=	checkForNull(request.getParameter("search_text"));
//	String sql			=	checkForNull(request.getParameter("sql"));

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

public static String checkForNull(String inputString, String defaultValue)
{
	return(((inputString == null) || (inputString.equals("null")) ) ? defaultValue : inputString);
}

public static boolean isNull(String inputString)
{
	return (((inputString == null) || (inputString.equals("null")) ) ? false : true);
}

%>

