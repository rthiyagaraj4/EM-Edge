<!DOCTYPE html>
<!--TerminologySetForPractionerTypeFrameSet.jsp
*	Copyright � MEDICOM Solutions (P) Ltd. ALL RIGHTS RESERVED
*	Application		:	eCP
*	Purpose 			:	
*	Created By		:	Suubulakshmy. K
*	Created On		:	30 Dec 2004-->
<html>
 <style>
        body, html {
            margin: 0;
            padding: 0;
            overflow: hidden; /* Prevent main scrolling */
            height: 100%;
        }
</style>
<head>
<%@ page contentType="text/html;charset=UTF-8" import="eCommon.XSSRequestWrapper" session="false" %>
<% request.setCharacterEncoding("UTF-8");
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff"); %>
	<script language="JavaScript" src="../../eCommon/js/common.js"></script>
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
	
	<script>function_id = "<%=request.getParameter("function_id")%>";	</script>
	<script language="javascript" src="../js/TerminologySetForPractitionerType.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<iframe name="frameSearch" id="frameSearch" src="../jsp/TerminologySetForPractitionerTypeHeader.jsp" frameborder="0" scrolling="no" style="height: 30vh; width: 100vw; border: none;"></iframe>
<iframe name="frameResult" id="frameResult" src="../../eCommon/html/blank.html" frameborder="0" noresize scrolling="no" style="height: 50vh; width: 95vw; border: none;"></iframe>
<iframe name="Dummy" id="Dummy" src="../../eCommon/html/blank.html" frameborder="0" scrolling="no" noresize style="height: 40vh; width: 100vw; border: none;"></iframe>
</body>


</html>

