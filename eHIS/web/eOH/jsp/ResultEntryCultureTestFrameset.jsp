<!DOCTYPE html>
<%@ page contentType="text/html; charset=UTF-8"%> 
<HTML>
<Head><TITLE>
<%request.setCharacterEncoding("UTF-8");%>
<%=(request.getParameter("title") == null)?"":request.getParameter("title")%></TITLE>
<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
</Head>
<!--<script>alert("<%=request.getQueryString()%>")</script>-->
<iframe name='ResultCultureTestHdr' id='ResultCultureTestHdr' src='ResultCultureTestHdr.jsp?<%=request.getQueryString()%>' frameborder=0  scrolling=no noresize style='height:8%;width:100vw'></iframe>
	<iframe name='ResultCultureTest' id='ResultCultureTest' src='../../eCommon/html/blank.html' frameborder=0 noresize style='height:100vh;width:100vw'></iframe>
	<iframe name='ResultCultureTestBtn' id='ResultCultureTestBtn' src='ResultcultureTestBtn.jsp?<%=request.getQueryString()%>' frameborder=0 scrolling=no style='height:5%;width:100vw'></iframe>
</HTML>

