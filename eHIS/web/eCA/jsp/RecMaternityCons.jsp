<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" import="eCommon.XSSRequestWrapper" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp"%>
<%
	webbeans.eCA.RecClinicalNotesSectionBean matBean = (webbeans.eCA.RecClinicalNotesSectionBean)getObjectFromBean("matBean","webbeans.eCA.RecClinicalNotesSectionBean",session);

	String patientId = request.getParameter("patient_id") == null ? "" : request.getParameter("patient_id");
	String encounterId = request.getParameter("episode_id") == null ? "" : request.getParameter("episode_id");
	String modevalue = request.getParameter("modeValue") == null ? "" : request.getParameter("modeValue");
	String strKey = "";
	strKey = patientId + "~" + encounterId;
	strKey = strKey.trim();
	matBean.removePatientSection(strKey);	
	matBean.startPatientSection(strKey);	
	putObjectInBean("matBean",matBean,session); 
%>
<html>
	<head>
		<title><fmt:message key="eCA.RecMaternityConsMain.label" bundle="${ca_labels}"/></title>
		<%
			request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
			String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
			String queryString = request.getQueryString() == null ? "" : request.getQueryString();
		%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />
	</head>
	<iframe name='recMatConsTabsFrame' id='recMatConsTabsFrame' src='../../eCA/jsp/RecMaternityConsTabs.jsp?<%=queryString%>' frameborder="yes" scrolling="no"  style='height:6%;width:100vw'></iframe>
		<iframe name='recMatConsDetailsFrame' id='recMatConsDetailsFrame' src='../../eCommon/html/blank.html' frameborder="yes" scrolling="yes"  style='height:100vh;width:100vw'></iframe>
		<iframe name='recMatConsBtnsFrame' id='recMatConsBtnsFrame' src='../../eCA/jsp/RecMaternityConsToolbar.jsp?modeValue=<%=modevalue%>' frameborder="yes" scrolling="no"  style='height:5%;width:100vw'></iframe>
		<iframe name='recMatConsBlankFrame' id='recMatConsBlankFrame' src='../../eCommon/html/blank.html' frameborder="yes" scrolling="no"  style='height:0%;width:100vw'></iframe>
	
</html>

