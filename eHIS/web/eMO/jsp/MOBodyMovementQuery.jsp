<!DOCTYPE html>

<%@ page   contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<html>
<head>
	<%
     String sStyle	=
     (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
     request.setCharacterEncoding("UTF-8");

%>


      <link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
    <script src='../../eMO/js/MOBodyMovementQuery.js' language="javascript"></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
	<title><fmt:message key="eMO.RegistrationDtls.label" bundle="${mo_labels}"/></title>
	
</head>
<%
		String url="../../eCommon/jsp/commonToolbar.jsp?";
		String params = request.getQueryString() ;
		String source = url + params ;
		String param=request.getParameter("param");
		if(param == null) param="";
		
		 String function_id=checkForNull(request.getParameter("function_id"));
		
		
if(function_id.equals("ViewMovementHistory")){
%>
<frameset rows='93,12%,50'>
<%}else{%>
<frameset rows='42,12%,*,50'>
<frame name='commontoolbarFrame' id='commontoolbarFrame'	src=<%= source %> frameborder=0 scrolling='no' noresize>
<%}%>
		<frame name='criteria' id='criteria' src='../jsp/MOBodyMovementQueryCriteria.jsp?<%=params%>' frameborder=0 scrolling='no'>
		<frame name='result' id='result'   src='../../eCommon/html/blank.html'      frameborder=0 noresize scrolling='auto'>
		<frame name='messageFrame' id='messageFrame'		src='../../eCommon/jsp/error.jsp' frameborder=0 noresize scrolling='auto'>
	</frameset>
</html>
<!--Below line added for this CRF  Bru-HIMS-CRF-367-->
<%!
	// to handle NullPointerException.
	public static String checkForNull(String inputString)
	{
		return((inputString == null) ? "" : inputString);
	}

	public static String checkForNull(String inputString, String defaultValue)
	{
		return((inputString == null) ? defaultValue : inputString);
	}
%>

