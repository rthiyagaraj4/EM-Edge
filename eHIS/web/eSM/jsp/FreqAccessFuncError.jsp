<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8"  import="java.io.*, eCommon.XSSRequestWrapper"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 

 <%
		request.setCharacterEncoding("UTF-8");
		request= new XSSRequestWrapper(request);
		response.addHeader("X-XSS-Protection", "1; mode=block");
		response.addHeader("X-Content-Type-Options", "nosniff");
        String sStyle	=
        (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
   %>

	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>

<head>
    <Script Language="JavaScript" src="../../eCommon/js/ValidateControl.js"></Script>


<script language="JavaScript">

</script>

</head>

<BODY CLASS="MESSAGE" onKeyDown = 'lockKey()'>

<p align="left">
<%
  
    String error=request.getParameter( "err_num" );
       if ( error != null ) {
        String queryString = (String) session.getValue( "queryString" ) ;
        if ( queryString == null ) queryString = "" ;

        //InputStreamReader reader = new InputStreamReader( new ByteArrayInputStream( error.getBytes()), "windows-1256" ) ;
        // error = (new BufferedReader(reader)).readLine() ;
        // if ( error == null ) error = "" ;
		out.println( "<script language='JavaScript'>if(parent.commontoolbarFrame!=null){ parent.commontoolbarFrame.location.href='../../eSM/jsp/FreqAccessToolbar.jsp?" + queryString /* "&home_required_yn="+home_required_yn+*/+"';}</script>" ) ;

		
		String error_value = request.getParameter( "err_value" )==null ? "0" : request.getParameter( "err_value" ) ;

        if ( error_value.equals( "1" ) ){
			out.println( "<script language='JavaScript'>parent.onSuccess();"+
            "document.writeln(\""+error+"\")" +
            "</script>" ) ;
		}
            else
		   {
                out.println( error ) ;
				}
            
    }

%>
</p>
</BODY>

