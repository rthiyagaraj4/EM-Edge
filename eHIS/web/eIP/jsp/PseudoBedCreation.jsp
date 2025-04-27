<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<title><fmt:message key="eIP.CreatePseudoBed.label" bundle="${ip_labels}"/></title>
<head>
	<link rel='stylesheet' type ='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
	<script src='../../eCommon/js/common.js' language='javascript'></script>
	<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
	<script language='javascript' src='../../eIP/js/PseudoBedCreation.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<%
		request.setCharacterEncoding("UTF-8");
		String url="../../eCommon/jsp/commonToolbar.jsp?";
		String params = request.getQueryString() ;
		String source = url + params ;
		String frommodal = request.getParameter("from_modal")==null?"":request.getParameter("from_modal");
		String nursingunit = request.getParameter("nursing_unit")==null?"":request.getParameter("nursing_unit");
		String nursingunitdesc = request.getParameter("nursing_unit_desc")==null?"":request.getParameter("nursing_unit_desc");

		if(frommodal.equals("Y"))
		{
			%>
			<iframe name='commontoolbarFrame' id='commontoolbarFrame'	src=<%= source %> frameborder=0 scrolling='no'  style='height:8vh;width:100vw'></iframe>
			<iframe name='f_query_add_mod' id='f_query_add_mod' 	src='../../eIP/jsp/addModifyPseudoBedCreation.jsp?from_modal=Y&nursing_unit_code=<%=nursingunit%>&nursing_unit_desc=<%=nursingunitdesc%>' frameborder=0 style='height:80vh;width:100vw'></iframe>
			<iframe name='messageFrame' id='messageFrame'		src='../../eCommon/jsp/error.jsp' frameborder=0  scrolling='auto' style='height:12vh;width:100vw'></iframe>
			<%
		}
		else
		{
%>
<iframe name='commontoolbarFrame' id='commontoolbarFrame'	src=<%= source %> frameborder=0 scrolling='no'  style='height:8vh;width:100vw'></iframe>
<iframe name='f_query_add_mod' id='f_query_add_mod' 	src='../../eCommon/html/blank.html' frameborder=0 style='height:80vh;width:100vw'></iframe>
<iframe name='messageFrame' id='messageFrame'		src='../../eCommon/jsp/error.jsp' frameborder=0  scrolling='auto' style='height:12vh;width:100vw'></iframe>
<%
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

