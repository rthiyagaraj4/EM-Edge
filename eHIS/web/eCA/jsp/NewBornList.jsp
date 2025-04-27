<!DOCTYPE html>
<%@page import="java.sql.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8"%> 
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
	<head>
	
		<%
			request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
			String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
		%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />
		<script language='javascript' src='../../eCommon/js/ValidateControl.js'></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
		<title><fmt:message key="eCA.NewBornList.label" bundle="${ca_labels}"/></title>
	</head>
	<!-- Modified frameset by kishore kumar N on 04/12/2008 for CRF -0387-->
	<iframe name='NewBornCriteriaFrame' id='NewBornCriteriaFrame' src='../../eCA/jsp/NewBornListCriteria.jsp?<%=request.getQueryString()%>' frameborder=0 marginheight=0 marginwidth=0 scrolling='no' noresize style='height:27vh;width:100vw'></iframe>
	<iframe name='NewBornTitleFrame' id='NewBornTitleFrame' src='../../eCommon/html/blank.html' frameborder='0' marginheight=0  scrolling='no'  noresize style='height:7vh;width:100vw'></iframe>
	<iframe name='NewBornResultFrame' id='NewBornResultFrame' src='../../eCommon/html/blank.html'  scrolling='auto' noresize frameborder=0 marginheight=0 marginwidth=0 style='height:58vh;width:100vw'></iframe>
    <iframe name='NewBornColorRefFrame' id='NewBornColorRefFrame' src='../../eCA/jsp/CAPatColorReference.jsp?newborn_page_yn=Y'  scrolling='no' noresize frameborder=0 marginheight=0 marginwidth=0  class='normal' style='height:6vh;width:100vw'></iframe>
	
	
</html>

