<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" %>
<% request.setCharacterEncoding("UTF-8");  %>
<html>
<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>
<%
	request.setCharacterEncoding("UTF-8");
	//String url    = "../../eCommon/jsp/MstCodeToolbar.jsp?"; 
	//String params = request.getQueryString() ;
	//String source = url + params ;
	String function_id = request.getParameter("call_func");
	String oper = request.getParameter("oper");
%>
<head>
	<link rel='stylesheet' type ='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
	<%
	if(function_id.equals("PRACT_FOR_CLINIC"))
		{
		%>
			<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script><script language='javascript' src='../../eOP/js/PClinic.js'></script>
		<%
		}
		else if(function_id.equals("Resource_unit"))
		{
		%>
			<script language='javascript' src='../../eOP/js/ResourceForUnit.js'></script>
		<%
		}
		%>
	
</head>
	<iframe name='HeaderFrame' id='HeaderFrame' src='../jsp/PractitionerForClinicHeader.jsp?function_id=<%=function_id%>&oper=<%=oper %>' frameborder=0 scrolling='no' noresize frameborder='0' style='height:5vh;width:100vw'></iframe>
		<iframe name='res_locn_by_pract_crit' id='res_locn_by_pract_crit' src='../../eCommon/html/blank.html'  frameborder=0 frameborder='0' style='height:95vh;width:100vw'></iframe><iframe name='res_locn_by_pract_result' id='res_locn_by_pract_result'	src='../../eCommon/html/blank.html' frameborder=0 noresize scrolling='auto' frameborder='0' style='height:0vh;width:100vw'></iframe>
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

