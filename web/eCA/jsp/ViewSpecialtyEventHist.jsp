<!DOCTYPE html>
<%@page contentType="text/html;charset=UTF-8" import="eCommon.XSSRequestWrapper" %>
<%
	request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String sStyle =	(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

<html>
<title><fmt:message key="eCA.ViewSpecialtyEventHistory.label" bundle="${ca_labels}"/></title>
<head> 
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link> 
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="JavaScript" src="../../eCommon/js/common.js"></script>
</head>
<FRAMESET ROWS="6%,*,0%,6%" id='myFrameSetControls' FRAMEBORDER=NO>
		<FRAME SRC="../../eCA/jsp/ViewSpecialtyEventHistControl.jsp?<%=request.getQueryString()%>" name='controlsFrame' FRAMESPACING=NO FRAMEBORDER=NO scrolling=no>  
<FRAMESET COLS="40%,*" FRAMEBORDER=NO>
	<FRAME SRC="../../eCommon/html/blank.html" name='unitFrame' FRAMEBORDER=NO scrolling=NO>
	<FRAME SRC="../../eCommon/html/blank.html" name='dataFrame' FRAMEBORDER=NO scrolling=yes>
</FRAMESET>
	<frame name='addToGrpFrame' src='../../eCommon/html/blank.html' frameborder=0 scrolling=no>
	<frame name='messageFrame' src='../../eCommon/html/blank.html' frameborder=0 scrolling=no>
</FRAMESET> 

</html>
