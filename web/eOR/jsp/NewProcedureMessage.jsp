<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%@ page import="eCommon.XSSRequestWrapper" contentType="text/html; charset=UTF-8"%>
 <%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%
	request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
		String sStyle =

		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
	<script src='../../eCommon/js/common.js' language='javascript'></SCRIPT>
	<script language='javascript' src='../../eCommon/js/ValidateControl.js'></script>
	<script language='javascript' src='../../eOR/js/NewProcedure.js'></script>
<head>

<script language="JavaScript">
function onsuccess(modal_yn,error,errorRemarks)
{  
	if(modal_yn == "Y"){
		//alert("APP-CA001 Operation Completed Successfully...");
		var message = error.substring(0,(error.lastIndexOf(".")));
		alert(message);
		parent.window.close();
	}else{
						
		top.content.workAreaFrame.location.reload();
	}
}

</script>

</head>
<BODY CLASS="MESSAGE" onMouseDown="CodeArrest()" onKeyDown="lockKey()">
<p align="left">
<%
    String error=request.getParameter( "err_num" );
    if (error != null) {
        

        String queryString = (String) session.getValue( "queryString" ) ;
        if ( queryString == null ) queryString = "" ;
        String error_value = request.getParameter( "err_value" )==null ? "0" : request.getParameter( "err_value" ) ;
		String modal_yn = request.getParameter( "modal_yn" )==null ? "N" : request.getParameter( "modal_yn" ) ;
		String errorRemarks = request.getParameter( "errorRemarks" )==null ? "N" : request.getParameter( "errorRemarks" ) ;
		System.out.println("====in message ==error_value=="+error_value+"==modal_yn=="+modal_yn+"==errorRemarks="+errorRemarks+"==");
       // if(modal_yn.equals("N"))
	   {
			out.println(error);
		    if ( error_value.equals( "1" ))
			     out.println( "<script language='JavaScript'>onsuccess('"+modal_yn+"','"+error+"','"+errorRemarks+"')</script>" ) ;
		}        
    }

%>
</p>
</BODY>

