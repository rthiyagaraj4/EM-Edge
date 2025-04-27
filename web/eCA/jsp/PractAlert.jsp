<!DOCTYPE html>
<%--Author  Arvind Singh Pal Created on 4/1/2009 --%>
<%@page import="java.sql.*,webbeans.eCommon.*,java.util.*" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
		<head>
 <%
	request.setCharacterEncoding("UTF-8"); 
	String sStyle =

(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
	<script language='javascript' src='../../eCommon/js/common.js'></script>
	<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


		<title><fmt:message key="eCA.PractitionerAlert .label" bundle="${ca_labels}"/></title>
		</head>
		<iframe name='PractAlertCriteriaFr' id='PractAlertCriteriaFr'		src='../../eCA/jsp/PractAlertCriteria.jsp'   frameborder=0 scrolling='no'  noresize style='height:14%;width:100vw'></iframe>
					<iframe name='PractAlertResultFr' id='PractAlertResultFr'		src='../../eCommon/html/blank.html' frameborder=0 scrolling='auto' noresize style='height:100vh;width:100vw'></iframe>					
		
</html>




