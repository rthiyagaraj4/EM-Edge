<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<html>
<head>
<title><fmt:message key="eMO.PoliceDetails.label" bundle="${mo_labels}"/></title>     	
	<%
     String sStyle	=
     (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	 request.setCharacterEncoding("UTF-8");
%>

<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
	<script language='javascript' src='../../eMO/js/MORegisterAttn.js'></script>
		<script language='javascript' src='../../eCommon/js/ValidateControl.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<%
		
		String params = request.getQueryString() ;

%>

<iframe name='f_query_add_mod' id='f_query_add_mod' 	src='../../eMO/jsp/PoliceDetails.jsp?<%=params%>' frameborder='0' noresize scrolling='no' style='height:80vh;width:100vw'></iframe>
<iframe name='dummyFrame' id='dummyFrame'		src='../../eCommon/jsp/MstCodeError.jsp' frameborder='0' noresize scrolling='auto' style='height:0vh;width:100vw'></iframe>

</html>

