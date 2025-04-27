<!DOCTYPE html>
<%@ page import="java.sql.Connection, java.sql.ResultSet, java.sql.PreparedStatement, webbeans.eCommon.ConnectionManager" contentType="text/html; charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<html>
<head>
	<!-- <link rel="stylesheet" type="text/css" href="../../eCommon/html/IeStyle.css"></link> -->
	<%
request.setCharacterEncoding("UTF-8");
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
	<script language='javascript' src='../../eCommon/js/common.js'></script>
	<script language="javascript" src="../../eFM/js/DTFolderInFSLocn.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	<title><fmt:message key="eFM.DocumentTypeinFolder.label" bundle="${fm_labels}"/></title>
<%
	String url		= "../../eCommon/jsp/MstCodeToolbar.jsp?" ;
	String params	= request.getQueryString() ;
	String source	= url + params ;
	
	StringBuffer sqlBuffer			= new StringBuffer();

	Connection connection			=	null;
	PreparedStatement preStatement	=	null;
	ResultSet resultSet				=	null;

	String facility_id				=	checkForNull((String) session.getValue("facility_id"));
	String user_id					=	checkForNull((String) session.getValue("login_user"));

	String maintain_doc_or_file	=	"N";
	
	int userAccess					=	0;

	try
	{
		connection		=	ConnectionManager.getConnection(request);

		sqlBuffer.append("SELECT maintain_doc_or_file FROM mp_param ");

		preStatement	=	connection.prepareStatement(sqlBuffer.toString());
		resultSet		=	preStatement.executeQuery();

		if((resultSet != null) && (resultSet.next()))
			 maintain_doc_or_file	= checkForNull(resultSet.getString("maintain_doc_or_file"), "F" );
		if(maintain_doc_or_file.equals("D"))
		{
			if ((sqlBuffer != null) && (sqlBuffer.length() > 0))
				sqlBuffer.delete(0, sqlBuffer.length());

			sqlBuffer.append("SELECT 1 FROM fm_user_access_rights WHERE facility_id = '");
			sqlBuffer.append(facility_id);
			sqlBuffer.append("' AND appl_user_id = '");
			sqlBuffer.append(user_id);			
			sqlBuffer.append("' ");
			
			if(resultSet!=null)	resultSet.close();
			if(preStatement!=null)  preStatement.close();			

			preStatement	= connection.prepareStatement(sqlBuffer.toString());
			resultSet		= preStatement.executeQuery();

			if((resultSet != null) && (resultSet.next()))
				 userAccess = resultSet.getInt(1);

			if(userAccess != 1)
			{
			%>
				<script> 
					alert(getMessage("FM_NO_USER_RIGHTS","FM")); 
					parent.parent.frames[2].location.href='../../eCommon/jsp/dmenu.jsp'; 
				</script>
			<%
			}
		}
		else
		{
			%>
				<script> 
					alert(getMessage("MP_PARAM_NOT_FOUND","MP")); 
					parent.parent.frames[2].location.href='../../eCommon/jsp/dmenu.jsp'; 
				</script>
			<%
		}
	if(resultSet!=null)	resultSet.close();
	if(preStatement!=null)  preStatement.close();
	}
	catch(Exception exception)
	{
		out.println(exception.toString());
	}
	finally
	{		
		ConnectionManager.returnConnection(connection,request);
	}
%>

</head>
<iframe name="commontoolbarFrame" id="commontoolbarFrame" src="<%=source%>" frameborder="0" scrolling="no" noresize style="height:8%;width:100vw"></iframe>
	<iframe name="criteriaFrame" id="criteriaFrame" src="../../eCommon/html/blank.html" frameborder="0" scrolling="no" noresize style="height:5%;width:100vw"></iframe>
	<iframe name="resultFrame" id="resultFrame" src="../../eCommon/html/blank.html" frameborder="0" scrolling="no" noresize style="height:100vh;width:100vw"></iframe>
	<iframe name="messageFrame" id="messageFrame" src="../../eCommon/jsp/MstCodeError.jsp" frameborder="0" scrolling="auto" noresize style="height:10%;width:100vw"></iframe>

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

