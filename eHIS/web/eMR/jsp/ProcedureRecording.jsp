<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" import= "webbeans.eCommon.*,java.sql.*,java.text.*,java.net.*" %>
<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>

<html>
<head>
	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
	<script language='javascript' src='../../eCommon/js/common.js' ></script>
	<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>	
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
	request.setCharacterEncoding("UTF-8");
	String url="../../eCommon/jsp/commonToolbar.jsp?";
	String params = request.getQueryString() ;
	String source = url + params ;
	String call_function=request.getParameter("function_id")==null?"":request.getParameter("function_id");

	if(call_function.equals("PROCEDURE_RECORDING"))
	{			
		%>
		<iframe name='commontoolbarFrame' id='commontoolbarFrame' src=<%=source%> frameborder='0' scrolling='no' noresize style='height:8vh;width:100vw'></iframe>
		<iframe scrolling="no" name='f_query_add_mod' id='f_query_add_mod' src='../../eMR/jsp/MedRecRequestCriteria.jsp?jsp_name=PatProcRecordWrapper.jsp&win_height=33.4&win_width=49.6&call_function=<%=call_function%>&function_id=<%=call_function%>' noresize frameborder=0 style='height:24vh;width:100vw'></iframe>
		<iframe scrolling="auto" name='content' id='content' src='../../eCommon/html/blank.html'  noresize frameborder=0 style='height:30vh;width:100vw'></iframe>
		<iframe scrolling="auto" name='dummy_frame' id='dummy_frame' src='../../eCommon/html/blank.html'  noresize frameborder=0 style='height:29vh;width:100vw'></iframe>
		<iframe name='messageFrame' id='messageFrame' src='../../eCommon/jsp/error.jsp' frameborder=0 noresize scrolling='auto' style='width:100vw'></iframe>
<%				
			
			
			}	%>
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

