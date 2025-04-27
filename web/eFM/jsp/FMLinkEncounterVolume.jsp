<!DOCTYPE html>
<%@ page import="java.sql.Connection, java.sql.ResultSet, java.sql.PreparedStatement,  webbeans.eCommon.ConnectionManager" contentType="text/html; charset=UTF-8" %>
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
	<script language='javascript' src='../../eFM/js/FMLinkEncounterVolume.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<%
	StringBuffer sourceBuffer	= new StringBuffer();
	StringBuffer sqlBuffer		= new StringBuffer();

	String url					= "../../eCommon/jsp/commonToolbar.jsp?" ;
	String params				= request.getQueryString() ;
	
	sourceBuffer.append(url);
	sourceBuffer.append(params);

	Connection connection			=	null;
	PreparedStatement preStatement	=	null;
	ResultSet resultSet				=	null;

	String facility_id				=	checkForNull((String) session.getValue("facility_id"));
	String user_id					=	checkForNull((String) session.getValue("login_user"));

	String link_bet_file_and_enctr_yn	=	"N";
	String sql1="";
	String userSecurity="";
	int userAccess					=	0;

	try
	{
		connection		=	ConnectionManager.getConnection(request);

		sql1  = "Select USER_SECURITY_YN from FM_PARAMETER where facility_id = '"+facility_id+"' ";
		preStatement	= connection.prepareStatement(sql1);
		resultSet		= preStatement.executeQuery();
		
		if(resultSet != null && resultSet.next())
		{
			 userSecurity = resultSet.getString("USER_SECURITY_YN");
		}
		
	if(resultSet!=null)	resultSet.close();
	if(preStatement!=null)  preStatement.close();
		
		
		if(userSecurity.equals("Y"))
		{
		sqlBuffer.append("SELECT link_bet_file_and_enctr_yn FROM fm_parameter WHERE facility_id = '");
		sqlBuffer.append(facility_id);
		sqlBuffer.append("' ");

		preStatement	=	connection.prepareStatement(sqlBuffer.toString());
		resultSet		=	preStatement.executeQuery();

		if((resultSet != null) && (resultSet.next()))
			 link_bet_file_and_enctr_yn	= checkForNull(resultSet.getString("link_bet_file_and_enctr_yn"), "N" );
		
		if(link_bet_file_and_enctr_yn.equals("Y"))
		{
			if ((sqlBuffer != null) && (sqlBuffer.length() > 0))
				sqlBuffer.delete(0, sqlBuffer.length());

			sqlBuffer.append("SELECT 1 FROM fm_user_access_rights WHERE facility_id = '");
			sqlBuffer.append(facility_id);
			sqlBuffer.append("'  AND appl_user_id = '");
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
					parent.frames[2].location.href='../../eCommon/jsp/dmenu.jsp'; 
				</script>
			<%
			}
		}
		else
		{
			%>
				<script> 
					alert(getMessage("FM_PARAM_NOT_AVAILABLE","FM")); 
					parent.frames[2].location.href='../../eCommon/jsp/dmenu.jsp'; 
				</script>
			<%
		}
	
	
	if(resultSet!=null)	resultSet.close();
	if(preStatement!=null)  preStatement.close();
		}
	
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

<iframe name='commontoolbarFrame' id='commontoolbarFrame' src='<%=sourceBuffer.toString()%>' frameborder='0' scrolling=no noresize style='height:7vh;width:100vw'></iframe>
	<iframe name='criteria_frame' id='criteria_frame' src='../../eFM/jsp/FMLinkEncounterVolumeCriteria.jsp' frameborder=0 scrolling='no' noresize style='height:15vh;width:100vw'></iframe>
	<iframe name='patient_line_frame' id='patient_line_frame' src='../../eCommon/html/blank.html' frameborder=0 scrolling='no' noresize style='height:10vh;width:100vw'></iframe>
	<iframe name='result_frame' id='result_frame' src='../../eCommon/html/blank.html' frameborder=0 scrolling='auto' noresize style='height:55vh;width:100vw'></iframe>
<iframe name="messageFrame" id="messageFrame" src="../../eCommon/jsp/error.jsp" scrolling="no" frameborder="0" noresize="" style="width: 100vw; height: 12vh; border: none;"></iframe> 
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

