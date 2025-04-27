<!DOCTYPE html>
<%@page import="java.sql.*,webbeans.eCommon.*" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<html>
<head>
	<title></title>
	
	<%
		String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
		//java.util.Properties p = (java.util.Properties) session.getValue( "jdbc" ) ;
		//String locale = (String) p.getProperty("LOCALE");
	%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />

	<script language='javascript' src='../../eCommon/js/ValidateControl.js'></script>
	<script language='javascript' src='../../eCommon/js/common.js'></script>
	<script language='javascript' src='../../eCA/js/RecClinicalNotesPart1.js'></script>
	<script language='javascript' src='../../eCA/js/RecClinicalNotesPart2.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<body onMouseDown="CodeArrest()" onKeyDown="lockKey()" class='CONTENT'>
	<center>	
		<table border='0' cellpadding='3' cellspacing='0' width='100%' align='center' style="display">
			<TR>
				<TD class='LABEL' width='100%' valign="center"><font size="2" style="font-weight:bold;color:red">P<br>r<br>o<br>c<br>e<br>s<br>s<br>i<br>n<br>g<br><br>P<br>l<br>e<br>a<br>s<br>e<br> <br>w<br>a<br>i<br>t<br></font></TD>
			</TR>		
		</table>			
	</center>
</body>
</html>

