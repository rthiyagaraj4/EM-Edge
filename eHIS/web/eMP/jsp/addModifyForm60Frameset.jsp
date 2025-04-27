<!DOCTYPE html>
<%@ page import ="java.sql.*,webbeans.eCommon.*" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<html>
<head>
<title><fmt:message key="eMP.form60.label" bundle="${mp_labels}"/></title>
<Script language='javascript' src='../../eCommon/js/common.js'></Script>
<Script language='javascript' src='../../eMP/js/Form60.js'></Script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<%
	request.setCharacterEncoding("UTF-8");
    String params = request.getQueryString() ;
 
	
					   

							 
							 %>
								</head>
								
								<iframe name='searchCriteria' id='searchCriteria' src='../../eMP/jsp/addModifyForm60.jsp?<%=params%>' frameborder=0  scrolling='auto' style='height:91vh;width:100vw'></iframe>
								<iframe name='messageFrame' id='messageFrame' src='../../eCommon/jsp/error.jsp' frameborder=0 noresize scrolling='auto' style='height:9vh;width:100vw'></iframe>
							 <%			
					%>
</html>

