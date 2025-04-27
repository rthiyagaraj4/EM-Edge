<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%@page import="eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8"%> 
<html>
<script language="JavaScript" src="../js/ReprintForms.js"></script>
<script language="JavaScript" src="../../eCommon/js/common.js"></script>
<!-- <script language="javascript" src="../../eCommon/js/messages.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

 -->
 <%
	request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
%>
 <%
	String url = "../../eCommon/jsp/commonToolbar.jsp?" ;
	String params = request.getQueryString() ;
	String source = url + params ;
%>

<iframe name="commontoolbarFrame" id="commontoolbarFrame" scrolling="NO" frameborder="0" noresize src="<%= source %>" style="height:6vh;width:100vw"></iframe>
<iframe name='ReprintFormsSearch' id='ReprintFormsSearch' src='ReprintFormsSearch.jsp' frameborder=0  style="height:3vh;width:100vw">
	<iframe name='ReprintFormsHeader' id='ReprintFormsHeader' src='../../eCommon/html/blank.html' frameborder=0 scrolling=no noresize style='height:32vh;width:100vw'></iframe>
	<iframe name='ReprintFormsResult' id='ReprintFormsResult' src='../../eCommon/html/blank.html' frameborder=0 scrolling=auto noresize style='height:3vh;width:100vw'></iframe>
	<iframe name='ReprintFormsBtn' id='ReprintFormsBtn'	  src='../../eCommon/html/blank.html' frameborder=0 noresize style='height:50vh;width:100vw'></iframe>
	<iframe name='messageFrame' id='messageFrame'	  src='../../eCommon/jsp/error.jsp?err_num=' frameborder=0 noresize style='height:6vh;width:100vw'></iframe>

</html>

