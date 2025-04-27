<!DOCTYPE html>

<%@page import="java.sql.*,webbeans.eCommon.*,java.util.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
		<head>
 <%
	request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String sStyle =

(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
	<script language='javascript' src='../../eCommon/js/common.js'></script>
	<script language='javascript' src='../../eCommon/js/ValidateControl.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


			<title><fmt:message key="eCA.ViewReferralPatientList.label" bundle="${ca_labels}"/></title>
		</head>
<%  
	String locationType=request.getParameter("locationType")==null?"":request.getParameter("locationType"); 
%>
		<iframe name='PatCriteriaFr' id='PatCriteriaFr'		src='../../eCA/jsp/ReferralPatListCriteria.jsp?<%=request.getQueryString()%>&locationType=<%=locationType%>'   frameborder=0 scrolling='no'  noresize style='height:22vh;width:100vw'></iframe>
					<iframe name='PatResultFr' id='PatResultFr'		src='../../eCommon/html/blank.html' frameborder=0 scrolling='auto' noresize style='height:67vh;width:100vw'></iframe>
					<iframe name='colorRefframe' id='colorRefframe' src='../../eCA/jsp/CAPatColorReference.jsp' frameborder=0 scrolling='no' noresize marginheight=0 marginwidth=0  class='normal' style='height:7vh;width:100vw'></iframe>
		
</html>

