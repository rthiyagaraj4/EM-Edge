<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" import="eCommon.XSSRequestWrapper"%>
<% request.setCharacterEncoding("UTF-8");
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff"); %>
<%
String mulitple_yn = request.getParameter("mulitple_yn")==null?"":request.getParameter("mulitple_yn");
String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<html>
<title id="lookup_title"><%=request.getParameter( "title" )==null?"Term Code Lookup":request.getParameter("title")%></title>
<head><link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' /></head>
<script language="JavaScript" src="../../eMR/js/NoteTerminologyCode.js"></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<%-- <frameset rows="25%,*,10%">	

<frame name="lookup_head" id="lookup_head" src="../../eMR/jsp/TermCodeQueryCriteria.jsp?<%=request.getQueryString()%>" noresize  frameborder="no" marginheight="0" marginwidth="0">
<frame name="lookup_detail" id="lookup_detail"    src="../../eCommon/html/blank.html"  noresize  scrolling="auto" frameborder="no" marginheight="0" marginwidth="0">
<!-- <frame name="lookup_detail" id="lookup_detail"    src="../../eCommon/html/blank.html"  noresize  scrolling="no" frameborder="no" marginheight="0" marginwidth="0"> -->
<frame name="lookup_cancel" id="lookup_cancel" src="../../eMR/jsp/TermCodeButton.jsp?mulitple_yn=<%=mulitple_yn%>" noresize  frameborder="no" marginheight="0" marginwidth="0">
</frameset> --%>
<iframe name="lookup_head" id="lookup_head" src="../../eMR/jsp/TermCodeQueryCriteria.jsp?<%=request.getQueryString()%>" noresize  frameborder="no" marginheight="0" marginwidth="0" style='height:14vh;width:100vw'></iframe>
<iframe name="lookup_detail" id="lookup_detail"    src="../../eCommon/html/blank.html"  noresize  scrolling="auto" frameborder="no" marginheight="0" marginwidth="0" style='height:76vh;width:100vw'></iframe>
<iframe name="lookup_cancel" id="lookup_cancel" src="../../eMR/jsp/TermCodeButton.jsp?mulitple_yn=<%=mulitple_yn%>" noresize  frameborder="no" marginheight="0" marginwidth="0" style='height:12vh;width:100vw'></iframe>
</html>

