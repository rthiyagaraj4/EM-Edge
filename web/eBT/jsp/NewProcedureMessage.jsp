<!DOCTYPE html>
<%
/*
Added by Niveditha For GHL-CRF-0602.1
*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
 <%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%
	request.setCharacterEncoding("UTF-8");
		String sStyle =

		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
	<script src='../../eCommon/js/common.js' language='javascript'></SCRIPT>
	<script language='javascript' src='../../eCommon/js/ValidateControl.js'></script>
	<script language='javascript' src='../../eBT/js/NewProcedure.js'></script>
<head>

<script language="JavaScript">
function onsuccess(modal_yn,error,errorRemarks)
{  
	if(modal_yn == "Y"){
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

