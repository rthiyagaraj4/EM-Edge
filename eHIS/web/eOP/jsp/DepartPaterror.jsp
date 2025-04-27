<!DOCTYPE html>
<!-- <link rel='stylesheet' type='text/css' href='../../eCommon/html/IeStyle.css'>
 --><!--<script src='../../ca/js/VitalSigns.js' language='javascript'></SCRIPT>-->
 <%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%
request.setCharacterEncoding("UTF-8");
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
	<Script src="../../eCommon/js/ValidateControl.js" language="JavaScript"></Script>

<BODY CLASS="MESSAGE" onKeyDown = 'lockKey();'>

<p align="left">
<%
    String error=request.getParameter( "err_num" );

	if ( error != null ) {%>

        <script>
        var r='<%=error%>';
		
        r = r.substr(0,r.length-5);
        alert(r)
        parent.window.close();
        </script>
        <%
        String error_value = request.getParameter( "err_value" )==null ? "0" : request.getParameter( "err_value" ) ;
		//out.println( "<script language='JavaScript'>parent.tools.document.write ('"+error+"') </script>" ) ;
        if ( error_value.equals( "1" ) )
            out.println( "<script language='JavaScript'>onsuccess();</script>" ) ;
    }

%>
</p>
</BODY>

