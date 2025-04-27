<!DOCTYPE html>
<html>
	<%@ page contentType="text/html; charset=UTF-8"%>
	<%@ include file="../../eCommon/jsp/CommonInclude.jsp" %>
	<%	request.setCharacterEncoding("UTF-8");	%>

	<%
		String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
	<link rel='stylesheet' type ='text/css' href='../../eCommon/html/Tabs.css'></link>
	<script language="javascript" src="../../eCommon/js/common.js"></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
	<%String title = request.getParameter("title");%>
	<Title><%=title%></Title>
	 <iframe name='ohDiagLinkConditionsHeader' id='ohDiagLinkConditionsHeader' frameborder="0" scrolling="auto" noresize src="../../eOH/jsp/OHDiagLinkConditionsHeader.jsp?<%=request.getQueryString()%>" style='height:15%;width:100vw'></iframe><iframe name="ohDiagLinkConditions" id="ohDiagLinkConditions" frameborder="0" scrolling="auto" noresize src="../../eOH/jsp/OHDiagLinkConditions.jsp?<%=request.getQueryString()%>" style="height:100vh;width:100vw"></iframe> 
</html>
<%
%>



