<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" import= "webbeans.eCommon.*,java.sql.*,java.text.*,java.net.*,eCommon.XSSRequestWrapper" %>
<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>

<html>
<head>
	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
	<script language='javascript' src='../../eCommon/js/common.js' ></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>	
<script>
function reset()
{	
		f_query_add_mod.document.forms[0].reset();
		content.document.location.href ='../../eCommon/html/blank.html';
		messageFrame.document.location.href ='../../eCommon/jsp/error.jsp';	
}
</script>
</head>
<%
	Connection con = null;
	Statement stmt = null;
	ResultSet rs   = null;
	int count      = 0;
	try
	{
		con = ConnectionManager.getConnection(request);
		stmt = con.createStatement();
		rs  = stmt.executeQuery("select count(*) from MR_PARAMETER");

		if(rs!=null && rs.next())
			count = rs.getInt(1);

		if(rs!=null)
			rs.close();

		if(stmt!=null)
			stmt.close();
	}
	catch(Exception e)
	{
		//out.println("Exception in RecordDiagnosis.jsp : "+e.toString());
		e.printStackTrace();
	}
	finally
	{
		if(con!=null) ConnectionManager.returnConnection(con,request);
	}

	if(count>0)
	{
		request.setCharacterEncoding("UTF-8");
		request= new XSSRequestWrapper(request);
		response.addHeader("X-XSS-Protection", "1; mode=block");
		response.addHeader("X-Content-Type-Options", "nosniff");
		String url="../../eCommon/jsp/commonToolbar.jsp?";
		String params = request.getQueryString() ;
		String source = url + params ;
		String call_function=request.getParameter("function_id")==null?"":request.getParameter("function_id");

		if(call_function.equals("RECORD_DIAGNOSIS"))
		{			
			%>
			<iframe name='commontoolbarFrame' id='commontoolbarFrame' src=<%=source%> frameborder='0' scrolling='no' noresize style='height:8vh;width:100vw'></iframe>
			<iframe scrolling="no" name='f_query_add_mod' id='f_query_add_mod' src='../../eMR/jsp/MedRecRequestCriteria.jsp?jsp_name=RecDiagnosis.jsp&win_height=33.4&win_width=49.6&call_function=<%=call_function%>&function_id=<%=call_function%>' noresize frameborder=0 style='height:265%;width:100vw'></iframe>
			<iframe scrolling="auto" name='content' id='content' src='../../eCommon/html/blank.html'  noresize frameborder=0 style='height:61vh;width:100vw'></iframe>
			<iframe name='messageFrame' id='messageFrame' src='../../eCommon/jsp/error.jsp' frameborder=0 noresize scrolling='auto' style='height:50%;width:100vw'></iframe>
	<%				
				
				
		}
	}else
	{
		out.println("<script>alert(getMessage('MR_PARAM_NOT_DEFINED','MR'));</script>");
		out.println("<script>document.location.href='../../eCommon/jsp/dmenu.jsp';</script>");
	}
	%>
</html>
<%!	
	private String checkForNull(String inputString)
	{
		return (inputString==null)	? "" : inputString;
	}

	private String checkForNull(String inputString, String defaultValue)
	{
		return (inputString==null)	? defaultValue : inputString;
	}
%>

