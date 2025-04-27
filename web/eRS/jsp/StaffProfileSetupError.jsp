<!DOCTYPE html>
<%
request.setCharacterEncoding("UTF-8");
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";%>
<html>
<head>
<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<script language="javascript" src="../js/StaffProfileSetup.js"></script>
</head>
<BODY CLASS="MESSAGE">
<p align="left">
<%
	String error=request.getParameter( "err_num" );

	System.err.println("error--------->"+error);
	if ( error != null ) {
		String error_value = request.getParameter( "err_value" )==null ? "0" : request.getParameter( "err_value" ) ;
		if ( error_value.equals( "1" ) ){
			out.println( "<script language='JavaScript'>alert(\""+error+"\");</script>" ) ;
			out.println( "<script language='JavaScript'>parent.onSuccess();</script>" ) ;
		}else
			out.println( "<script language='JavaScript'>alert(\""+error+"\");</script><Script src=\"../../eCommon/js/showModalDialog.js\" language=\"JavaScript\"></Script>" ) ;
	}
%>
</p>
</BODY>
</html>

