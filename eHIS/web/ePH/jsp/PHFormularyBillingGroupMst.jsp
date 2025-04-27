<!DOCTYPE html>
 <%-- saved on 26/10/2005 --%>
<%@page contentType="text/html;charset=UTF-8" import="eCommon.XSSRequestWrapper"%>
<html>
<head>
	
	
	
	<script language="javascript" src="../../eCommon/js/common.js"></script>
	<script language="javascript" src="../js/PhCommon.js"></script>
	<script language="javascript" src="../js/FormularyMast.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>



<%
//added By Himanshu Start.
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
//end.
	String url ="../../eCommon/jsp/MstCodeToolbar.jsp?"  ;
	String params = request.getQueryString();
	String source = url + params ;
%>

<iframe name="commontoolbarFrame" id="commontoolbarFrame" frameborder="0" scrolling="no" noresize src="<%= source %>" style="height:8vh;width:100vw"></iframe><iframe name="f_query_add_mod" id="f_query_add_mod" frameborder="0" scrolling="no" noresize src="../../eCommon/html/blank.html" style="height:83vh;width:100vw"></iframe><iframe name="messageFrame" id="messageFrame" frameborder="0" scrolling="auto" noresize src="../../eCommon/jsp/MstCodeError.jsp" style="height:9vh;width:100vw"></iframe>
</html>

