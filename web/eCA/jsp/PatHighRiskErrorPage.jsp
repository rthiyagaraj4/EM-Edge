<!DOCTYPE html>
<% 
/*
-------------------------------------------------------------------------------------------------------------------------------------
Date       		Edit History    	Name        	Description
-------------------------------------------------------------------------------------------------------------------------------------
?             	100            		?           	created
20/01/2012		CHL-CRF [IN035950]	Ramesh G		CHL-CRF [IN035950]										
-------------------------------------------------------------------------------------------------------------------------------------
*/
%>
<%@ page contentType="text/html;charset=UTF-8" import="eCommon.XSSRequestWrapper" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%
		
		request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
		String sStyle =	(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
	<script language='javascript' src='../../eCommon/js/ValidateControl.js'></script>
<head>

<script language="JavaScript">
function onsuccess(modal_yn,error,errorRemarks,p_called_from_widget)
{  
	if(modal_yn == "Y"){
		//alert("APP-CA001 Operation Completed Successfully...");
		var message = error.substring(0,(error.lastIndexOf(".")));
		alert(message);
		parent.window.close();
	}else{
		//CHL-CRF Start.[IN035950]
		if(p_called_from_widget!=""){
			parent.frame1.document.location.reload();
			parent.frame2.document.location.reload();
		}else{
		//CHL-CRF Start.[IN035950]
			top.content.workAreaFrame.frame1.document.location.reload();
			top.content.workAreaFrame.frame2.document.location.reload();
			top.plineFrame.document.location.reload();
		} //CHL-CRF[IN035950]	 
	}
}

</script>

</head>
<BODY CLASS="MESSAGE" onMouseDown="CodeArrest()" onKeyDown="lockKey()">
<p align="left">
<%
    String error=request.getParameter( "err_num" );
    if (error != null) { 
		out.println(error);
        String queryString = (String) session.getValue( "queryString" ) ;
        if ( queryString == null ) queryString = "" ;
        String error_value = request.getParameter( "err_value" )==null ? "0" : request.getParameter( "err_value" ) ;
		String modal_yn = request.getParameter( "modal_yn" )==null ? "N" : request.getParameter( "modal_yn" ) ;
		String errorRemarks = request.getParameter( "errorRemarks" )==null ? "N" : request.getParameter( "errorRemarks" ) ;
		String p_called_from_widget = request.getParameter("p_called_from_widget")==null?"":request.getParameter("p_called_from_widget"); //CHL-CRF [IN035950]
		if ( error_value.equals( "1" ) ){
			//CHL-CRF Start.[IN035950]			
			out.println( "<script language='JavaScript'>onsuccess('"+modal_yn+"','"+error+"','"+errorRemarks+"','"+p_called_from_widget+"');</script>" ) ;
			//CHL-CRF Start.[IN035950]
		}	          
    }

%>
</p>
</BODY>

