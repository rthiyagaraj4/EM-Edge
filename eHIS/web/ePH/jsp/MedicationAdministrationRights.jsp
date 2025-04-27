<!DOCTYPE html>
<% 
/*
---------------------------------------------------------------------------------------------------------------------------------	
	Date		Edit History	Name		Rev.Date   	Rev.By 		Description
--------------------------------------------------------------------------------------------------------------------------------

28/11/2019       IN059899        PRATHYUSHA                          JD-CRF-0200
-------------------------------------------------------------------------------------------------------------------------------
*/
%>
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
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' ></link> 
	<script language="JavaScript" src="../../ePH/js/MedicationAdministrationRights.js"></script>
	
	<script language="javascript" src="../../eCommon/js/common.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<%
	String url = "../../eCommon/jsp/commonToolbar.jsp?";
	String params =request.getQueryString() ;
	String source = url + params ;
%> 
<iframe name = "commontoolbarFrame" frameborder = "0" scrolling = "no" noresize src="<%= source %>" style="height:8vh;width:100vw"></iframe><iframe name = "f_query_add_mod" frameborder = "0" scrolling = "auto" noresize src="../../eCommon/html/blank.html" style="height:83vh;width:100vw"></iframe><iframe name = "messageFrame" src="../../eCommon/jsp/error.jsp" frameborder = "0" noresize scrolling = "auto" style="height:9vh;width:100vw"></iframe>
</html>




