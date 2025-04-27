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
	String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
<script src='../../eCommon/js/common.js' language='javascript'></script>
<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<title><fmt:message key="eCA.Notescontent.label" bundle="${ca_labels}"/></title>
</head>
<%
String accession_num=request.getParameter("accession_num");
String no_modal=request.getParameter("no_modal");

%>

<iframe name ='heading' marginwidth=0 marginheight=0 frameborder=no scrolling='no' noresize  src='../../eCA/jsp/PhysicanNotesDetailsHeading.jsp?accession_num=<%=accession_num%>&no_modal=<%=no_modal%>' style='height:6vh;width:100vw'></iframe>
<iframe name ='result' marginwidth=0 marginheight=0 frameborder=no scrolling='auto'  src='../../eCA/jsp/PhysicanNotesDetails.jsp?accession_num=<%=accession_num%>&no_modal=<%=no_modal%>' style='height:84vh;width:100vw'></iframe>
 

</html>

