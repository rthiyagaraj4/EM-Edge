<!DOCTYPE html>

<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<html>
<head>
	<%
     String sStyle	=
     (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	 request.setCharacterEncoding("UTF-8");

%>

      <link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
    <script src='../../eMO/js/MORegDetailsQuery.js' language="javascript"></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
	<title><fmt:message key="eMO.RegistrationDtls.label" bundle="${mo_labels}"/></title>
	
</head>
<%
		String url="../../eCommon/jsp/commonToolbar.jsp?";
		String params = request.getQueryString() ;
		String source = url + params ;
		String param=request.getParameter("param");
		if(param == null) param="";
		String function_id=request.getParameter("function_id");
		if(function_id == null) function_id="";
%>

<iframe name='commontoolbarFrame' id='commontoolbarFrame'	src=<%= source %> frameborder=0 scrolling='no' noresize style='height:8vh;width:100vw'></iframe>
		<iframe name='criteria' id='criteria' src='../jsp/MORegnDtlsQueryCriteria.jsp?function_id=<%=function_id%>' frameborder=0 scrolling='no' style='height:30vh;width:100vw'></iframe><iframe name='MOFrame' id='MOFrame' src='../../eMO/jsp/MOManagePatTabs.jsp' frameborder=0 noresize scrolling='no' style='height:5vh;width:100vw'></iframe><iframe name='result' id='result'   src='../../eCommon/html/blank.html'      frameborder=0 noresize scrolling='auto' style='height:41vh;width:100vw'></iframe><iframe name='messageFrame' id='messageFrame'		src='../../eCommon/jsp/error.jsp' frameborder=0 noresize scrolling='auto' style='height:9vh;width:100vw'></iframe><iframe name='dispframe' id='dispframe'		src='../../eMO/jsp/MOManageDeceasedColor.jsp' frameborder=0 noresize scrolling='auto' style='height:30vh;width:100vw'></iframe>
	<form>
	<input type='hidden' name='function_id' id='function_id' value=<%=function_id%>>
	</form>
</html>


