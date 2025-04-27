<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%@ page contentType="text/html;charset=UTF-8" %>
<% request.setCharacterEncoding("UTF-8"); %>
<html>
<head>
<!--<title><fmt:message key="eMR.ICDCodeSearch.label" bundle="${mr_labels}"/></title>-->
<title><fmt:message key="Common.TermCode.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="Common.search.label" bundle="${common_labels}"/></title>
	<script src='../../eMR/js/ICDCodeForDagger.js' language='javascript'></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<%
	String queryString=request.getQueryString();
	//out.println("<script>alert(\""+queryString+"\");</script>");
%>
<!--
	F.Y.I
	1.Modified On 1/19/2010 for IN018218
	2.This below frame was modified for Blank HTml when any Term set was selected  for with no records then the Query caused no records  alert is is coming twice 
	<frame name='group_head' id='group_head' src='../../eMR/jsp/PaintConsultation.jsp?<%=queryString%>' noresize  scrollbar=no  frameborder=no  marginheight=0 marginwidth=0>
-->

<!--<frameset rows='5%,*,10%'>-->
<iframe name='group_head' id='group_head' src='../../eMR/jsp/Consultation.jsp?<%=queryString%>' frameborder=no scrolling='no'style='height:6vh;width:100vw'></iframe>
<iframe name='group_blank' id='group_blank' src='../../eCommon/html/blank.html' scrolling='no'  frameborder=no style='height:80vh;width:100vw'></iframe>
<iframe name='group_close_button' id='group_close_button' src='../../eMR/jsp/SearchCancel.jsp' frameborder=no scrolling='no'style='height:8vh;width:99vw'></iframe>
</html>

