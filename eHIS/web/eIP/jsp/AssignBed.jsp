<!DOCTYPE html>
<%@ page   contentType="text/html;charset=UTF-8" import= "java.sql.Connection,java.sql.Statement,java.sql.ResultSet, webbeans.eCommon.ConnectionManager,eCommon.XSSRequestWrapper" %>
<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>
<html>
<head>
	<link rel='stylesheet' type ='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
	<script language ='javascript' src='../../eCommon/js/common.js'></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
		
	<script>
	   function reset()
	   {
			f_query_add_mod.document.forms[0].reset();
			if (f_query_add_mod.document.forms[0].searchby != null)
			{
				if (f_query_add_mod.document.forms[0].soundex.value!='')
				{
					f_query_add_mod.document.forms[0].searchby.value		=	"";
					f_query_add_mod.document.forms[0].searchby.disabled	=	true;
				}
				else
				{
					f_query_add_mod.document.forms[0].searchby.disabled	=	false;
					f_query_add_mod.document.forms[0].searchby.value		=	"S";
				}
			}
			f_query_add_mod.document.forms[0].search.disabled = false;
			f_query_add_mod1.location.href = '../../eCommon/html/blank.html';
	   }
	</script>
</head>
<%
	request.setCharacterEncoding("UTF-8"); 
	//MMS-ME-SCF-0096 vulnerability Issue
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff"); 
	//MMS-ME-SCF-0096 vulnerability Issue
	StringBuffer sqlBuffer	=	new StringBuffer();
	String url				=	"../../eCommon/jsp/commonToolbar.jsp?";
	String params			=	checkForNull(request.getQueryString());
	String facilityId		=	checkForNull((String)session.getValue("facility_id"));
	String loginUser		=	checkForNull((String)session.getValue("login_user"));
	//String call_function	=	checkForNull((String)session.getValue("call_function"));
	String function_id=request.getParameter("function_id");
        if(function_id == null) function_id = "";
		
	String chg_nurs_unit_in_assign_bed_yn		=	"";

	sqlBuffer.append(url);
	sqlBuffer.append(params);
	String source			=	sqlBuffer.toString();
	
	Connection connection	=	null;
	ResultSet resultSet 	=	null; 
	Statement statement 	=	null;

	try
	{
		connection	= ConnectionManager.getConnection(request);
		statement	= connection.createStatement();		

		if (sqlBuffer.length() > 0)
			sqlBuffer.delete(0, sqlBuffer.length());
		sqlBuffer.append("select 1 from ip_param where facility_id = '");
		sqlBuffer.append(facilityId);
		sqlBuffer.append("' ");

		resultSet = statement.executeQuery(sqlBuffer.toString()) ;
		
		if((resultSet != null) && (resultSet.next()))
		{
			statement = connection.createStatement();
			resultSet = statement.executeQuery("Select AM_OPER_STN_ACCESS_CHECK('"+facilityId+"','"+loginUser+"','N','','ASSIGN_BED_YN') FROM dual") ;
			resultSet.next();
	     	String OsVal=resultSet.getString(1);
            if(OsVal.equals("1"))
			{
			out.print(" <script>alert(getMessage('IP_NO_OPER_STN_FOR_USER','IP'));document.location.href='../../eCommon/jsp/dmenu.jsp';</script>");
			}else if(OsVal.equals("2"))
			{
				 /*if(call_function.equals("TransferPatient")){

				out.print(" <script>alert(getMessage(' ASSIGN_BED_USER_ACCESS,'IP'));document.location.href='../../eCommon/jsp/dmenu.jsp';</script>");
				}else {*/
			out.print(" <script>alert(getMessage('NURS_UNIT_NOT_DEFINED','IP'));document.location.href='../../eCommon/jsp/dmenu.jsp';</script>");
			//}
			}else  if(OsVal.equals("3"))
			{
			out.print(" <script>alert(getMessage('OPER_STN_FUNC_RESTRN','IP'));document.location.href='../../eCommon/jsp/dmenu.jsp';</script>");
			}else  if(OsVal.equals("4"))
			{
			out.print(" <script>alert(getMessage('NOT_VALID','Common'));document.location.href='../../eCommon/jsp/dmenu.jsp';</script>");
			}
			if(OsVal.equals("5"))
			{
			out.print(" <script>alert(getMessage('INVALID_OPER_STN_ACCESS','Common'));document.location.href='../../eCommon/jsp/dmenu.jsp';</script>");
			}
			else	if(!OsVal.equals(""))
			{	

			%>

			<iframe name='commontoolbarFrame' id='commontoolbarFrame'	src=<%= source %> frameborder=0 scrolling='no' noresize style='height:7vh;width:100vw'></iframe>
			<iframe name='f_query_add_mod' id='f_query_add_mod' 	src='../../eIP/jsp/InpatientLookupCriteria.jsp?function_id=<%=function_id%>&jsp_name=AssignBedMain.jsp&call_function=assign_bed&wherecondn=ASSIGN_BED_YN&oper_stn_id=<%=OsVal%>&chg_nurs_unit_in_assign_bed_yn=<%=chg_nurs_unit_in_assign_bed_yn%>' frameborder=0 scrolling='no' noresize style='height:22vh;width:100vw'></iframe>
			<iframe name='f_query_add_mod1' id='f_query_add_mod1' 	src='../../eCommon/html/blank.html' frameborder=0 scrolling='auto' noresize style='height:55vh;width:100vw'></iframe>
			<iframe name='desc_frame' id='desc_frame' 	src='QuerySearchResultFrames.jsp?step=assignbed' frameborder=0 scrolling='auto' noresize  style='height:8vh;width:100vw'></iframe>
			<iframe name='messageFrame' id='messageFrame'		src='../../eCommon/jsp/MstCodeError.jsp' frameborder=0 noresize scrolling='auto' style='height:12vh;width:100vw'></iframe>

			<%
			}
			
		}
		else
		{
		%>
		  <script>
				alert(getMessage('IP_PARAM_NOT_FOUND','IP'));
				document.location.href= '../../eCommon/jsp/dmenu.jsp';
		  </script>
		<%
		}
		if (resultSet != null) resultSet.close();
		if (statement != null) statement.close();

		}catch(Exception e)
		{
			//out.println("Exception in tryCatch : "+ e.toString());
			e.printStackTrace();
		}
		finally
		{
			try
			{
				if(resultSet!=null) resultSet.close();
				if(statement!=null) statement.close();

				if(connection != null)
				ConnectionManager.returnConnection(connection,request);
			}
			catch(Exception ee)
			{
				
				ee.printStackTrace();
			}
		}
	%>
</html>

<%!
	public static String checkForNull(String inputString)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? "" : inputString);
	}
	
	public static String checkForNull(String inputString, String defaultValue)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? defaultValue : inputString);
	}
%>

