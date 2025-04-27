<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 

<%@ page contentType="text/html;charset=UTF-8"  %>

<html>
<head>
	<title><fmt:message key="eDR.ViewRecordDetails.label" bundle="${dr_labels}"/></title>
	<link rel="stylesheet" type="text/css" href="../../eCommon/html/IeStyle.css"></link>
	<Script language="JavaScript" src="../../eCommon/js/common.js" ></Script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
</head>
<%
	request.setCharacterEncoding("UTF-8");
	//String url = "../../eCommon/jsp/commonToolbar.jsp?" ;
	String params = request.getQueryString() ;
	//String source = url + params ;
	
%>
	<iframe name='f_query_add_mod' id='f_query_add_mod' src='../../eDR/jsp/ManageRequestPatientDetails.jsp?<%=params%>'  style='height:100vh;width:100vw'></iframe>
	<iframe name='messageFrame' id='messageFrame' src='../..//eCommon/jsp/error.jsp'  noresize scrolling='auto' style='height:0vh;width:100vw'></iframe>
</html>

