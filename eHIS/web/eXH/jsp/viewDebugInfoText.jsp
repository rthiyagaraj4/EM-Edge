<!DOCTYPE html>
<html>
<%@ page import="java.net.URLDecoder,eXH.XHDBAdapter"%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%
String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
request.setCharacterEncoding("UTF-8"); 
%>
<link rel='StyleSheet' href='../eCommon/html/<%=sStyle%>' type='text/css'></link>

<head>
<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
<script language="javascript" src="../../eCommon/js/common.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>

<BODY CLASS="MESSAGE" onMouseDown="CodeArrest()" onKeyDown ='lockKey()'>

<%
String strText = URLDecoder.decode(XHDBAdapter.checkNull((String)request.getParameter("text")));
%>

<form>
<TABLE>
<TR>
	<TD CLASS='fields'>
		<TEXTAREA NAME="" ROWS="2" COLS="120"><%=strText%></TEXTAREA>
	</TD>
</TR>
</TABLE>
</form>
</BODY>
</html>

