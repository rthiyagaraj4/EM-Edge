<!DOCTYPE html>
<%
/*
--------------------------------------------------------------------------------------------------------------
Date			Edit History      Name			Description
--------------------------------------------------------------------------------------------------------------
29/03/2012		IN032043		Ramesh G		CA>Chart View>Zoom>graph cannot be viewed or printed.
---------------------------------------------------------------------------------------------------------------
*/
%>
<%@page import="java.util.*,java.sql.*,webbeans.eCommon.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
<head>	
<%
	request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085

	String graphURL = "";
	String graphTitle="";
	String filename = "";
	graphTitle =(String)request.getParameter("GraphTitle")==null?"":request.getParameter("GraphTitle");
	filename =(String)request.getParameter("FileName")==null?"":request.getParameter("FileName");
	graphURL = request.getContextPath()+"/eCA/MediPainter/images/"+filename;
	
%>
<TITLE><%=graphTitle %></TITLE>
<script>
function winClose(){
	window.close();
}
</script>
</head>
<body>
<form>	
	<TABLE cellpadding='1' bgcolor='#404040' cellspacing='1'  style='padding-top:10px;' width='100%' height='100%'>
	<TR height='90%'>
		<TD bgcolor='#FFFFFF' id="imgsrc">
			<img  src="<%=graphURL%>" usemap="#<%=filename%>"  border=0 width='100%' height='100%'/>
		</TD>
	</TR>
	<TR height='10%'>
		<TD align='right' style='padding-right:10px;' bgcolor='#FFFFFF'>			
			<INPUT TYPE="button" VALUE="Close" ONCLICK="javascript:winClose();">
		</TD>
	</TR>
	</TABLE>
</form>

</body>
</html>

