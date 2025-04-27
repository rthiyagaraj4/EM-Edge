<!DOCTYPE html>
<html>
<%String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%request.setCharacterEncoding("UTF-8"); %>
<link rel='StyleSheet' href='../eCommon/html/<%=sStyle%>' type='text/css'></link>
<head>
<script Language="JavaScript"  src="../eCommon/js/ValidateControl.js" ></script> 
<script language="JavaScript">
</script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<BODY CLASS="MESSAGE" onMouseDown="CodeArrest()" onKeyDown ='lockKey()'>
<p align="left">
<%
	   
	String result=(String)request.getParameter( "message" );
	
//	System.out.println("result 19"+result);
 																		   
%>
<%=result%>
</p>
</BODY>															  
</html>

