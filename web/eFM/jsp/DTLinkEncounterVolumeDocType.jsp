<!DOCTYPE html>
<%@ page import="java.sql.Connection, java.sql.ResultSet, java.sql.PreparedStatement, webbeans.eCommon.ConnectionManager" contentType="text/html; charset=UTF-8" %>
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
	<script language='javascript' src='../../eFM/js/DTLinkEncounterVolumeDocType.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<%
	StringBuffer sourceBuffer	= new StringBuffer();	
	String url					= "../../eCommon/jsp/commonToolbar.jsp?" ;
	String params				= request.getQueryString() ;
	
	sourceBuffer.append(url);
	sourceBuffer.append(params);

	Connection connection			=	null;
	PreparedStatement preStatement	=	null;
	ResultSet resultSet				=	null;

	String maintain_doc_or_file	=	"N";	
   
	try
	{
		connection		=	ConnectionManager.getConnection(request);

		preStatement	=	connection.prepareStatement("SELECT maintain_doc_or_file FROM mp_param ");
		resultSet		=	preStatement.executeQuery();

		if((resultSet != null) && (resultSet.next()))
		   maintain_doc_or_file	= checkForNull(resultSet.getString("maintain_doc_or_file"), "N" );
		     
	
		if(maintain_doc_or_file.equals("F"))
		{
		%>
		<iframe name='commontoolbarFrame' id='commontoolbarFrame' src='<%=sourceBuffer.toString()%>' frameborder='0' scrolling=no noresize style='height:8%;width:100vw'></iframe>
			<iframe name='criteria_frame' id='criteria_frame' src='../../eFM/jsp/DTLinkEncounterVolumeDocTypeCriteria.jsp' frameborder=0 scrolling='no' noresize style='height:15%;width:100vw'></iframe>
			<iframe name='tab_frame' id='tab_frame' src='../../eCommon/html/blank.html' frameborder=0 scrolling='no' noresize style='height:6%;width:100vw'></iframe>
			<iframe name='result_frame' id='result_frame' src='../../eCommon/html/blank.html' frameborder=0 scrolling='auto' noresize style='height:100vh;width:100vw'></iframe>
			<iframe name='messageFrame' id='messageFrame' src='../../eCommon/jsp/error.jsp' scrolling='auto' frameborder='0' noresize style='height:9%;width:100vw'></iframe>
		 
		<%
		}
		else if(maintain_doc_or_file.equals("D"))
		{
		%>
		<iframe name='commontoolbarFrame' id='commontoolbarFrame' src='<%=sourceBuffer.toString()%>' frameborder='0' scrolling=no noresize style='height:8%;width:100vw'></iframe>
			<iframe name='criteria_frame' id='criteria_frame' src='../../eFM/jsp/DTLinkEncounterDocTypeCriteria.jsp' frameborder=0 scrolling='no' noresize style='height:5%;width:100vw'></iframe>
			<iframe name='tab_frame' id='tab_frame' src='../../eCommon/html/blank.html' frameborder=0 scrolling='no' noresize style='height:4%;width:100vw'></iframe>
			<iframe name='result_frame' id='result_frame' src='../../eCommon/html/blank.html' frameborder=0 scrolling='auto' noresize style='height:100vh;width:100vw'></iframe>
			<iframe name='messageFrame' id='messageFrame' src='../../eCommon/jsp/error.jsp' scrolling='auto' frameborder='0' noresize style='height:9%;width:100vw'></iframe>
		 
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

