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
	String title=request.getParameter("title")==null?"Email":request.getParameter("title");

	%>

	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />
	<title><%=title%></title>
</head>
	<script language="javascript" src="../../eCommon/js/common.js"></script>
	<script language='javascript' src="../../eCommon/js/ValidateControl.js"></script>
	<script language="javascript" src="../js/EMail.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


	<iframe name='EMailHdrFrame' id='EMailHdrFrame' src="../../eCA/jsp/EMailHdr.jsp?<%=request.getQueryString()%>"  noresize scrolling=no framespacing=0 FRAMEBORDER=1 style='height:22vh;width:100vw'></iframe>
	<iframe name='EMailEdtrFrame' id='EMailEdtrFrame' src='../../eCommon/html/blank.html'  noresize framespacing=0 FRAMEBORDER=1 style='height:13vh;width:100vw'></iframe>
	<iframe name='EMailEdtrBttnFrame' id='EMailEdtrBttnFrame' src="../../eCommon/html/blank.html" noresize  scrolling=no framespacing=0 FRAMEBORDER=1 style='height:7vh;width:100vw'></iframe>
	<iframe name='EMailBtmFrame' id='EMailBtmFrame' src='../../eCommon/html/blank.html'  noresize framespacing=0 FRAMEBORDER=1 scrolling=no style='height:22vh;width:100vw'></iframe>
	<iframe name='dummyEmailFrame' id='dummyEmailFrame' src="../../eCommon/html/blank.html"  noresize framespacing=0 FRAMEBORDER=1 scrolling=no style='height:0%;width:100vw'></iframe>

</html>

