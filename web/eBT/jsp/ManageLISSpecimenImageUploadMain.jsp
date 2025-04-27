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

		
		<script language="JavaScript" src="../../eCommon/js/common.js"></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
		

	</head>
	<iframe name='fileUploadLinksFrame' id='fileUploadLinksFrame' src='../../eBT/jsp/ManageLISSpecimenImageUploadLinks.jsp?<%=request.getQueryString()%>' frameborder='0'  style='height:65vh;width:100vw'></iframe>
		<iframe name='fileUploadFrame' id='fileUploadFrame' src='../../eCA/jsp/blank.jsp' frameborder='0' scrolling='no' style='height:25vh;width:100vw'></iframe>
		<iframe name='fileUploadBlankFrame' id='fileUploadBlankFrame' src='../../eCommon/html/blank.html' frameborder='0'  style='height:0vh;width:100vw'></iframe>
		<iframe name='messageFrame' id='messageFrame' src='../../eCommon/jsp/error.jsp' frameborder='0'  style='height:10vh;width:100vw'></iframe>
	
</html>

