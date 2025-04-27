<!DOCTYPE html>
<%-- saved 0n 24/10/2005 --%>
<%@ page import="eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8" %>
<html>
<head>
	<!-- <link rel="stylesheet" type="text/css" href="../../eCommon/html/IeStyle.css"></link> -->
	
	<!--<SCRIPT LANGUAGE="JavaScript" SRC="../js/ReconstituentFluidForDrug.js"></SCRIPT>-->
	<script language="Javascript" src="../../eCommon/js/common.js"></script>
	<script language="JavaScript" src="../../ePH/js/PhCommon.js"></script>
<!-- 	<script language="JavaScript" src="../../ePH/js/PhMessages.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
 -->

<%
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086
	String url = "../../ePH/jsp/TPNRegNonStdReg.jsp?" ;
	String params = request.getQueryString() ;
	String source = url + params ;
	String weight=request.getParameter("weight");
	if ((weight==null)||(weight.equals("")))
	{
	%>
<script>	alert(getMessage("PH_WEIGHT_REQUIRED","PH")); </script>
	<%
	}
%>
<iframe name="HeaderFrame" id="HeaderFrame" frameborder="0" scrolling="no" noresize src="<%= source %>" style="height:10vh;width:100vw"></iframe><iframe name="DetailFrame" id="DetailFrame" frameborder="0" scrolling="auto" noresize src=
	"../../eCommon/html/blank.html">
	<!-- '<%//="../../ePH/jsp/TPNRegNonStdRegDetails.jsp?"+params%>'> -- style='height:78vh;width:100vw'></iframe><iframe name="ShowDetailFrame" id="ShowDetailFrame" frameborder="0" scrolling="auto" noresize src= "../../eCommon/html/blank.html" style="height:0vh;width:100vw"></iframe><iframe name="ButtonFrame" id="ButtonFrame" frameborder="0" scrolling="auto" noresize src= "../../ePH/jsp/TPNRegNonStdRegButtons.jsp?<%=params%>" style="height:12vh;width:100vw"></iframe>
</html>

