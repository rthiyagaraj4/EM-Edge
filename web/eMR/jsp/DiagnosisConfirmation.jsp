<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp" %>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>

<html>
<head>
	<link rel="stylesheet" type="text/css" href="../../eCommon/html/<%=sStyle%>"></link>
	<script language='javascript' src='../../eCommon/js/common.js' ></script>		
<script language='javascript' src="../../eMR/js/DaigConfirmation.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<%
	String url="../../eCommon/jsp/commonToolbar.jsp?";
	request.setCharacterEncoding("UTF-8");
	String params = request.getQueryString() ;
	String source = url + params ;
	String call_function=request.getParameter("function_id")==null?"":request.getParameter("function_id");
	
%>
<!-- <frameset rows='6%,32%,*,9%'> -->
    <iframe name='commontoolbarFrame' id='commontoolbarFrame' src=<%=source%> frameborder='0' scrolling='no' noresize style='height:8vh;width:100vw'> </iframe>
	<iframe scrolling="no" name='f_query_add_mod' id='f_query_add_mod' src='../../eMR/jsp/MedRecRequestCriteria.jsp?&call_function=<%=call_function%>&function_id=<%=call_function%>' noresize frameborder=0   style='height:80vh;width:100vw'></iframe>
	<iframe scrolling="auto" name='resultFrame' id='resultFrame' src='../../eCommon/html/blank.html'  noresize frameborder=0 style='height:4vh;width:100vw'></iframe>
	<!-- <frame scrolling="no" name='f_select' id='f_select' src='../../eMR/jsp/MedRecRequestButton.jsp'  noresize frameborder=0> -->
	<iframe name='messageFrame' id='messageFrame' src='../../eCommon/jsp/error.jsp' frameborder=0 noresize scrolling='auto' style='height:8vh;width:100vw'></iframe>
	<!-- <frame name='errFrame' id='errFrame' src='../../eCommon/html/blank.html' frameborder=0 noresize scrolling='auto'> -->
<!-- </frameset> -->
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

