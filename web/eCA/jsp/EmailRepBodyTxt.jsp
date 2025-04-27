<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" import="eCommon.XSSRequestWrapper" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>

<head>
	
	<%
		request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
		String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />

	<script language="javascript" src="../../eCommon/js/common.js"></script>
	<script language='javascript' src="../../eCommon/js/ValidateControl.js"></script>
	<script language="javascript" src="../js/EmailRepBodyTxt.js"></script>

	<frameset rows='10%,33%,50%,8%' border=0>

		<frame name='EmailRepBodyTxtHdrFrame' src='../../eCA/jsp/EmailRepBodyTxtHdr.jsp?<%=request.getQueryString()%>' frameborder=no noresize scrolling=no framespacing=NO border=0>
		<frameset id='listFrameset' cols='60%,*' border=0>	
			<frame name='EmailRepBodyTxtPrevEdtrFrame' src='../../eCommon/html/blank.html' frameborder=1 noresize framespacing=NO border=1> 
			<frame name='EmailRepBodyTxtListFrame' src='../../eCommon/html/blank.html' frameborder=1 noresize framespacing=NO border=1>
		</frameset>
			
		<frame name='EmailRepBodyTxtEdtrFrame' src='../../eCommon/html/blank.html' frameborder=no noresize framespacing=NO border=0>

		<frame name='EmailRepBodyTxtEdtrBttnFrame' src='../../eCommon/html/blank.html' frameborder=no noresize  scrolling=no framespacing=NO border=0> 
			
	</frameset>

</head>

</html>
