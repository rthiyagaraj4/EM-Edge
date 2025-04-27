<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%> 
<%@ page import="eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8"%>
<%	
	request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
%>

<html>
<script>
	
	var  dialogFrame=parent.document.getElementById('dialog-body');
	var argArray = window.dialogArguments ;
	if(argArray == undefined){
		argArray=dialogFrame.contentWindow.dialogArguments;
	}
	var fieldLegend     = argArray[9];
	window.document.title=fieldLegend;
	
</script>
<title id="lookup_title"><%=request.getParameter( "title" )%></title>
<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
<iframe name="lookup_head" id="lookup_head" src='../../eOR/jsp/OrCommonLookupSearchCriteria.jsp?title=<%=request.getParameter( "title" )%>' noresize  frameborder="no" marginheight="0" marginwidth="0" scrolling="no" style='height:15vh;width:99vw'></iframe>
<iframe name="lookup_detail" id="lookup_detail"    src="../../eCommon/html/blank.html"  noresize  scrolling="no" frameborder="no" marginheight="0" marginwidth="0" style="height:70vh;width:98vw"></iframe>
<iframe name="lookup_cancel" id="lookup_cancel" src="../../eOR/jsp/OrCommonLookupCancel.jsp" noresize  frameborder="no" marginheight="0" marginwidth="0" style="height:10vh;width:98vw"></iframe>

</html>

