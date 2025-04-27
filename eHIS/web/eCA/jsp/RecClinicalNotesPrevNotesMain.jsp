<!DOCTYPE html>
<%@ page import="eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<html>
<head>

<%	
	request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";	
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />
<script src='../../eCommon/js/common.js' language='javascript'></script>
<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>

<title><fmt:message key="eCA.PreviewNotes.label" bundle="${ca_labels}"/></title>
	<frameset rows='7%,19%,77%,5%' frameborder='0'>
		<frame name="RecClinicalNotesPrevFilterCriteriaFrame" frameborder="0" scrolling="no" noresize src="../../eCA/jsp/RecClinicalNotesPrevFilterCriteria.jsp?<%=request.getQueryString()%>"></frame>
		<frame name="RecClinicalNotesPrevNotesSearchCriteriaFrame" frameborder="0" scrolling="no" noresize src="../../eCommon/html/blank.html"></frame>
		<frameset cols='30%,*'>
		<frame name="RecClinicalNotesPrevNotesSearchDetailFrame" frameborder="0" scrolling="auto" noresize src="../../eCommon/html/blank.html"></frame> 
		<frame name="RecClinicalNotesPrevNotesSearchNotesDetailFrame" frameborder="0" scrolling="auto" noresize src="../../eCommon/html/blank.html"></frame> 
		</frameset>
		<frame name="messageframe" frameborder="0" scrolling="auto" noresize src="../../eCommon/jsp/error.jsp"></frame> 
	</frameset>
</head>
</html>
