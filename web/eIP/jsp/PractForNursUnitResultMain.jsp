<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" %>
<% request.setCharacterEncoding("UTF-8");  %>
<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>
<html>
<head>
	<link rel='stylesheet' type ='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
	<script language='javascript' src='../js/NursUnitPract.js'></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
</head>
<%
		String operation		= checkForNull(request.getParameter("operation"),"modify");
		String nursing_unit_code = checkForNull(request.getParameter("nursing_unit_code"));
		String nursing_unit_desc = checkForNull(request.getParameter("nursing_unit_desc"));
		String practitioner_id   = checkForNull(request.getParameter("practitioner_id"));
		String practitioner_short_name = checkForNull(request.getParameter("practitioner_short_name"));
%>

<iframe name='NurUtPractQueryFrame' id='NurUtPractQueryFrame'src='../../eIP/jsp/PractForNursUnitResultSub.jsp'frameborder='0'noresize scrolling='no' style='height:1%;width:100vw'></iframe><iframe name='NurUtPractResultFrame' id='NurUtPractResultFrame' src='../../eIP/jsp/PractForNursUnitResult.jsp?operation=<%=operation%>&nursing_unit_code=<%=nursing_unit_code%>&nursing_unit_desc=<%=nursing_unit_desc%>&practitioner_id=<%=practitioner_id%>&practitioner_short_name=<%=practitioner_short_name%>'frameborder=0 scrolling='auto' noresize style='height:80vh;width:100vw'></iframe>

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

