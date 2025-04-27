<!DOCTYPE html>
 <%@page contentType="text/html; charset=UTF-8" import="eCommon.XSSRequestWrapper" %>
 <%-- saved on 27/10/2005 --%>
<html>
<head>
<!--	<% String sStyle=(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?
(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css"; %>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>'type='text/css'></link> -->

	<SCRIPT LANGUAGE="JavaScript" SRC="../js/UomForForm.js"></SCRIPT>
	<script language="Javascript" src="../../eCommon/js/common.js"></script>
	<script language="JavaScript" src="../js/PhCommon.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<%
request.setCharacterEncoding("UTF-8");
//Added for COMMON-ICN-0182 on 17-10-2023
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086
//ends
	String url = "../../ePH/jsp/UomForFormofDrugAddModify.jsp?" ;
	String params = request.getQueryString() ;
	String source = url + params ;
%>
<iframe name='f_formOfDrug' id='f_formOfDrug'  frameborder="0" scrolling='no' noresize src="<%= source %>" style='height:8vh;width:100vw'></iframe><iframe name="f_buttons" id="f_buttons" src="../../eCommon/html/blank.html" frameborder="0" noresize scrolling="no" style="height:5vh;width:100vw"></iframe><iframe name="f_UOMDetails" id="f_UOMDetails" src="../../eCommon/html/blank.html" frameborder="0" noresize scrolling="auto" style="height:67vh;width:100vw"></iframe>
</html>

