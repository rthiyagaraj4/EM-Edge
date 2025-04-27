<!DOCTYPE html>
<%@ page import="java.sql.Connection, java.sql.ResultSet,java.sql.PreparedStatement,  webbeans.eCommon.ConnectionManager" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 

<html>
<head>
<% 
	request.setCharacterEncoding("UTF-8");
	String sStyle			= checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css");
	
%>
	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
	<script language='javascript' src='../../eCommon/js/common.js'></script>
	<script language='javascript' src='../../eCommon/js/ValidateControl.js'></script>
	<script language='javascript' src='../../eFM/js/FMReturnToMRD.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<%
	StringBuffer sourceBuffer	= new StringBuffer();
	StringBuffer sqlBuffer		= new StringBuffer();

	String url		= "../../eCommon/jsp/commonToolbar.jsp?" ;
	String params	= request.getQueryString() ;
	
	sourceBuffer.append(url);
	sourceBuffer.append(params);

	Connection connection			= null;
	PreparedStatement preStatement	= null;
	PreparedStatement pstmt_fn	= null;
	ResultSet resultSet				= null;
	ResultSet rset_fn				= null;

	String facility_id	= checkForNull((String) session.getValue("facility_id"));
	String user_id		= checkForNull((String) session.getValue("login_user"));

	String userAccess =	"";
    String sql1="";
	String userSecurity="";
	try
	{
		connection	= ConnectionManager.getConnection(request);
		
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
		
		sqlBuffer.append("SELECT 1 userAccess FROM fm_user_access_rights WHERE facility_id = '");
		sqlBuffer.append(facility_id);
		sqlBuffer.append("' AND appl_user_id = '");
		sqlBuffer.append(user_id);
		sqlBuffer.append("' AND return_file_yn = 'Y' ");
				
		preStatement	= connection.prepareStatement(sqlBuffer.toString());
		resultSet		= preStatement.executeQuery();
	
		if((sqlBuffer != null) && (sqlBuffer.length() > 0))
		{
			sqlBuffer.delete(0,sqlBuffer.length());
		}

		if((resultSet != null) && (resultSet.next()))
		{
			 userAccess = resultSet.getString("userAccess");
		}
		if(!userAccess.equals("1"))
		{
		%>
			<script> 
				alert(getMessage("FM_NO_USER_RIGHTS","FM")); 
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
		out.println("Exception :"+exception.toString());
		exception.printStackTrace();
	}
	finally
	{		
		ConnectionManager.returnConnection(connection,request);
		if(rset_fn!=null)	rset_fn.close();
		if(pstmt_fn!=null)  pstmt_fn.close();
	}

if(session.getAttribute("doc_or_file")!=null)
session.removeAttribute("doc_or_file");
%>

<frameset rows='8%,27%,*,9%' frameborder='0'>
	<frame name='commontoolbarFrame' id='commontoolbarFrame' src='<%=sourceBuffer.toString()%>' frameborder='0' scrolling=no noresize>
	<!-- below line(s) added by venkatesh.S against issue KAUH-SCF-0016 [IN032341] on 23/April/2012-->
		<!--<frame name='criteria_frame' id='criteria_frame' src='../../eFM/jsp/FMReturnToMRDCriteria.jsp?' frameborder=0 scrolling='no' noresize> -->
	<frame name='criteria_frame' id='criteria_frame' src='../../eFM/jsp/FMReturnToMRDCriteria.jsp?userSecurity=<%=userSecurity%>'' frameborder=0 scrolling='no' noresize>
	<!--end issue KAUH-SCF-0016 [IN032341] -->
	<frame name='result_frame' id='result_frame' src='../../eCommon/html/blank.html' frameborder=0 scrolling='auto' noresize>
	<frame name='messageFrame' id='messageFrame' src='../../eCommon/jsp/error.jsp' scrolling='auto' frameborder='0' noresize>
 </frameset>
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

