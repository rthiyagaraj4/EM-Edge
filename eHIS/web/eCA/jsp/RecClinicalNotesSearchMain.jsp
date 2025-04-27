<!DOCTYPE html>
<%@ page import="eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8" %>
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
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<%
	String operation_mode	=	"";

	operation_mode	=	checkForNull(request.getParameter("operation_mode"));

	//out.println("<script>alert('"+operation_mode+"');</script>");

	if(operation_mode.equals("ViewNoteStatus"))
	{
%>
	<title><fmt:message key="eCA.ClinicalNoteStatusDetails.label" bundle="${ca_labels}"/></title>
	<iframe name="RecClinicalNotesStatusResultFrame" id="RecClinicalNotesStatusResultFrame" frameborder="0" scrolling="auto" noresize src="../../eCA/jsp/RecClinicalNotesStatusResult.jsp?<%=request.getQueryString()%>" style="height:29vh;width:100vw"></iframe>
	<iframe name="RecClinicalNotesStatusDetailsFrame" id="RecClinicalNotesStatusDetailsFrame" frameborder="0" scrolling="auto" noresize src="../../eCA/jsp/RecClinicalNotesStatusDetails.jsp?<%=request.getQueryString()%>" style="height:66vh;width:100vw"></iframe> 
	
<%
	}
	else
	{
%>
	<title><fmt:message key="eCA.ClinicalNoteDetails.label" bundle="${ca_labels}"/></title>
	<iframe name="RecClinicalNotesSearchToolbarFrame" id="RecClinicalNotesSearchToolbarFrame" frameborder="0" scrolling="no" noresize src="../../eCA/jsp/RecClinicalNotesSearchToolbar.jsp?<%=request.getQueryString()%>" style="height:8vh;width:100vw"></iframe>
		<iframe name="RecClinicalNotesSearchDetailsFrame" id="RecClinicalNotesSearchDetailsFrame" frameborder="0" scrolling="auto" noresize src="../../eCA/jsp/RecClinicalNotesSearchDetails.jsp?<%=request.getQueryString()%>" style="height:93vh;width:100vw"></iframe> 
		<iframe name="messageframe" id="messageframe" frameborder="0" scrolling="auto" noresize src="../../eCommon/jsp/error.jsp" style="height:0vh;width:100vw"></iframe> 
	
<%

	}	
%>
</head>
</html>

<%!
	private String checkForNull(String inputString)
	{
		return (inputString==null)	?	""	:	inputString;
	}
%>

