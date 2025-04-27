<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" %>

<html>
	<head>
		
		<% request.setCharacterEncoding("UTF-8");%>
		<%@ include file="../../eCommon/jsp/CommonInclude.jsp" %>
		<%
				String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";			
			
		%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />

		
			<title><fmt:message key="Common.Specimen.label" bundle="${common_labels}"/> <fmt:message key="Common.Image.label" bundle="${common_labels}"/></title>
		

	</head>
	<iframe name='fileUploadLinksFrame' id='fileUploadLinksFrame' src='../../eBT/jsp/ManageLISSpecimenImageShowImage.jsp?<%=request.getQueryString()%>' frameborder='0'  style='height:100vh;width:100vw'></iframe>

	
</html>

