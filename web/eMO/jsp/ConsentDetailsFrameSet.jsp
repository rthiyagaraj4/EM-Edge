<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
<head>
	<%
     String sStyle	=
     (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	 request.setCharacterEncoding("UTF-8");
	 String title=request.getParameter("title");
%>

<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
	<script language='javascript' src='../../eMO/js/MORegisterAttn.js'></script>
	<script language='javascript' src='../../eCommon/js/common.js'></script>
		<script language='javascript' src='../../eCommon/js/ValidateControl.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<title><%=title%></title>
</head>

<%
		
		String params = request.getQueryString() ;


%>

<iframe name='f_query_add_mod' id='f_query_add_mod' 	src='../../eMO/jsp/MORegisterDeceased_ConsentForm.jsp?<%=params%>' scrolling='no' frameborder='0' style='height:100vh;width:100vw'></iframe><iframe name='dummyFrame' id='dummyFrame'		src='../../eCommon/jsp/MstCodeError.jsp' frameborder=0 noresize scrolling='auto' style='height:0%;width:100vw'></iframe>

</html>

