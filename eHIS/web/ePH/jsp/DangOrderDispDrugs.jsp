<!DOCTYPE html>
  <%@page contentType="text/html;charset=UTF-8" import="eCommon.XSSRequestWrapper" %>
<html>                                
<head>                                
	
	<%
	request.setCharacterEncoding("UTF-8");
//added By Himanshu for COMMON-ICN-0182 on 17/10/2023 Start.
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086
//end.
	String locale			= (String)session.getAttribute("LOCALE");

	String sStyle=(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css"; 
%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>

	<script language="javascript" src="../js/PhCommon.js"></script>
	<script language="javascript" src="../../eCommon/js/common.js"></script>
	 <script language="javascript" src="../js/DangOrderDispDrugs.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
  
</head>                               

<%
	String url = "../../eCommon/jsp/commonToolbar.jsp?" ;
	String params = request.getQueryString() ;
	String source = url + params ;
%>

<iframe name="commontoolbarFrame" id="commontoolbarFrame" frameborder="0" scrolling="no" noresize src="<%= source %>" style="height:10vh;width:100vw"></iframe><iframe name="f_query_criteria" id="f_query_criteria" frameborder="0" scrolling="no" noresize src="../../ePH/jsp/DangOrderDispDrugsCriteria.jsp" style="height:80vh;width:100vw"></iframe><iframe name="messageFrame" id="messageFrame" src="../../eCommon/jsp/error.jsp" frameborder="0" noresize scrolling="auto" style="height:10vh;width:100vw"></iframe>
</html>

