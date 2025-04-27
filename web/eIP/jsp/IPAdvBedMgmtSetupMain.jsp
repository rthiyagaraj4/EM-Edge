<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8"%>
<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>
<html>
<head>
	<link rel='stylesheet' type ='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
	<script src='../../eIP/js/IPAdvBedMgmtSetup.js' language='javascript'></script>
	<script src='../../eCommon/js/common.js' language='javascript'></script>
	<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<%   
	request.setCharacterEncoding("UTF-8");
	String url="../../eCommon/jsp/commonToolbar.jsp?";
	String params = request.getQueryString() ;
	String source = url + params ; 
	//Below code was added by N Munisekhar on 08-JAN-2013 against [IN037130]
    String function_id=request.getParameter("function_id");
    if(function_id == null) function_id = "";	
	
%>
	<iframe name='commontoolbarFrame' id='commontoolbarFrame'	src=<%= source %> frameborder=0 scrolling='no' style='height:7vh;width:100vw'></iframe>
	<!--Below code was modified by N Munisekhar on 08-JAN-2013 against [IN037130] -->
	<iframe name='blank' id='blank' src='../../eIP/jsp/IPAdvBedMgmtCriteria.jsp?function_id=<%=function_id%>' frameborder=0 scrolling='no' style='height:4vh;width:100vw'></iframe>
	<iframe name='f_query_add_mod' id='f_query_add_mod' src='../../eCommon/html/blank.html' frameborder=0 scrolling='no' style="height:82vh ;width:100vw"></iframe>
	<iframe name='messageFrame' id='messageFrame' src='../../eCommon/jsp/MstCodeError.jsp' frameborder=0  scrolling='auto' style='height:7vh;width:100vw'></iframe>
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

