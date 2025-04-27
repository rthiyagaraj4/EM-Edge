<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%@ page import="eCommon.XSSRequestWrapper" contentType="text/html; charset=UTF-8"%>

<jsp:useBean id="TerminologyLookup" scope="session" class="webbeans.eCommon.RecordSet" />
<html>
<title id="lookup_title"><%=request.getParameter( "title" )==null?"Terminology ":request.getParameter("title")%></title>
<script language="JavaScript" src="../../eOR/js/NewProcedureTermCode.js"></script>
<%
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
String radioval = request.getParameter("radioval")==null?"":request.getParameter("radioval");
if(radioval.equals("")){
	radioval = "G";
	TerminologyLookup.clearAll();
}

String frameCols = "";
String frameSrc = "";

if(radioval.equals("G")){
	frameCols = "30%,70%";
	frameSrc = "../../eOR/jsp/NewProcTermCodeGroup.jsp?"+request.getQueryString();
}else{
	frameCols = "0%,100%";
	frameSrc = "../../eCommon/html/blank.html";
}
%>
<frameset rows="20%,*,5%,0%">
	<frame name="lookup_head" src="../../eOR/jsp/NewProcTermCodeQuerySearch.jsp?<%=request.getQueryString()%>" noresize  frameborder="no" marginheight="0" marginwidth="0" scrolling="auto">
	
	<frameset cols="<%=frameCols%>" name='procDetails'>

	<frame name="lookup_group"    src="<%=frameSrc%>"  noresize  scrolling="auto" frameborder="no" marginheight="0" marginwidth="0"> 
	<!-- <frame name="lookup_group"    src="../../eOR/jsp/NewProcTermCodeGroup.jsp?<%=request.getQueryString()%>"  noresize  scrolling="auto" frameborder="no" marginheight="0" marginwidth="0"> -->
	<frame name="lookup_detail"    src="../../eCommon/html/blank.html"  noresize  scrolling="auto" frameborder="no" marginheight="0" marginwidth="0"> 

	</frameset>
	<frame name="lookup_cancel" src="../../eOR/jsp/NewProcTermCodeBtn.jsp?<%=request.getQueryString()%>" noresize  frameborder="no" marginheight="0" marginwidth="0" scrolling="no">
	<!-- <frame name="lookup_tempframe" src="../../eOR/jsp/NewProcTermCodeValidate.jsp?<%=request.getQueryString()%>" noresize  frameborder="no" marginheight="0" marginwidth="0" scrolling="no"> -->
	<frame name="lookup_tempframe" src="../../eCommon/html/blank.html" noresize frameborder="no" marginheight="0" marginwidth="0" scrolling="no">
</frameset>

</html>
