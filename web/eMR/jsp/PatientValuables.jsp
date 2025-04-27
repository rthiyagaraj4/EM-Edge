<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>

<html>
<head>
	<link rel="stylesheet" type="text/css" href="../../eCommon/html/<%=sStyle%>"></link>
	<script language='javascript' src="../../eMR/js/DaigConfirmation.js"></script>
	<script language='javascript' src='../../eCommon/js/common.js' ></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
		
</head>
<%
	request.setCharacterEncoding("UTF-8");
	String url="../../eCommon/jsp/commonToolbar.jsp?";
	String params = request.getQueryString() ;
	String source = url + params ;
	String call_function = checkForNull(request.getParameter("function_id"));



%>
<iframe name='commontoolbarFrame' id='commontoolbarFrame' src=<%=source%> frameborder='0' scrolling='no' noresize style='height:9vh;width:100vw'></iframe>
<iframe scrolling="no" name='criteriaFrame' id='criteriaFrame' src='../../eMR/jsp/MedRecRequestCriteria.jsp?&call_function=<%=call_function%>&function_id=<%=call_function%>' noresize frameborder=0 style='height:35vh;width:100vw'></iframe>
<iframe scrolling="auto" name='resultFrame' id='resultFrame' src='../../eCommon/html/blank.html'  noresize frameborder=0 style='height:46vh;width:100vw'></iframe>
<iframe name='messageFrame' id='messageFrame' src='../../eCommon/jsp/error.jsp' frameborder=0 noresize scrolling='auto' style='height:9%;width:100vw'></iframe>
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

