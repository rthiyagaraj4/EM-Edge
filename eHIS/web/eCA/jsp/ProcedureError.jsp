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
		String sStyle =
		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
	<script language='javascript' src='../../eCommon/js/ValidateControl.js'></script>
<head>

<script language="JavaScript">
function onsuccess(modal_yn,error,errorRemarks,p_called_from_widget)  //CHL-CRF [IN035950]
{  
	if(modal_yn == "Y"){
		//Added by Archana Dhal on 3/9/2011 related to incident no.IN026810 
		// parent.frames[1].document.location.href = parent.frames[1].document.location.href ;
		var query_string = parent.document.getElementById("dialog-body").contentWindow.document.getElementById("frame2").contentWindow.document.getElementById("qryStr").value;
		var index = (query_string.lastIndexOf("&mode=update"));
		if(index != -1)
			var qry_Str = query_string.substring(0,index);
		else
			qry_Str = query_string;
		//console.log(parent.document.getElementById("dialog-body").contentWindow.document.getElementById("frame2"));
		parent.document.getElementById("dialog-body").contentWindow.document.getElementById("frame1").contentWindow.location.href="../../eCA/jsp/ProcQueryResult.jsp?"+qry_Str;
		parent.document.getElementById("dialog-body").contentWindow.document.getElementById("frame2").contentWindow.location.href="../../eCA/jsp/AddModifyOPProc.jsp?"+qry_Str;
		//alert("APP-CA001 Operation Completed Successfully...");
		//var message = error.substring(0,(error.lastIndexOf(".")));
		//Commented by Jyothi to fix IN026248 on 03/02/2010
		/*var message = error;
		alert(message);
		parent.window.close();*/
	}else{
		if(p_called_from_widget!=""){
			//parent.frames[1].document.location.href = parent.frames[1].document.location.href ;
			var query_string = parent.document.getElementById("dialog-body").contentWindow.document.getElementById("frame2").contentWindow.document.getElementById("qryStr").value;
			var index = (query_string.lastIndexOf("&mode=update"));
			if(index != -1)
				var qry_Str = query_string.substring(0,index);
			else
				qry_Str = query_string;
			parent.frame1.location.href="../../eCA/jsp/ProcQueryResult.jsp?"+qry_Str;
			parent.frame2.location.href="../../eCA/jsp/AddModifyOPProc.jsp?"+qry_Str;
		}else{
			var objWork = top.content;
			if(null!= objWork ){
				top.content.workAreaFrame.frame1.document.location.reload();	 
				var query_string = top.content.workAreaFrame.frame2.document.forms[0].qryStr.value;
				var index = (query_string.lastIndexOf("&mode=update"));
				if(index != -1)
					var qry_Str = query_string.substring(0,index);
				else
					qry_Str = query_string;		
				top.content.workAreaFrame.frame2.location.href="../../eCA/jsp/AddModifyOPProc.jsp?"+qry_Str;
			}else{
				parent.frame1.document.location.reload();	 
				var query_string = parent.frame2.document.forms[0].qryStr.value;
				var index = (query_string.lastIndexOf("&mode=update"));
				if(index != -1)
					var qry_Str = query_string.substring(0,index);
				else
					qry_Str = query_string;		
				parent.frame2.location.href="../../eCA/jsp/AddModifyOPProc.jsp?"+qry_Str;
			
			}
		}
	}
}

</script>

</head>
<BODY CLASS="MESSAGE" onMouseDown="CodeArrest()" onKeyDown="lockKey()">
<p align="left">
<%
    String error=request.getParameter( "err_num" );
	//out.println("<script>alert('error"+error+"');</script>");
    if (error != null) {
        

        String queryString = (String) session.getValue( "queryString" ) ;
        if ( queryString == null ) queryString = "" ;
        String error_value = request.getParameter( "err_value" )==null ? "0" : request.getParameter( "err_value" ) ;
		String modal_yn = request.getParameter( "modal_yn" )==null ? "N" : request.getParameter( "modal_yn" ) ;
		String errorRemarks = request.getParameter( "errorRemarks" )==null ? "N" : request.getParameter( "errorRemarks" ) ;
		String p_called_from_widget = request.getParameter("p_called_from_widget")==null?"":request.getParameter("p_called_from_widget"); //CHL-CRF [IN035950]
       // if(modal_yn.equals("N"))
	   {
    	    out.println( "<script language='JavaScript'>  var messageParagraph = document.createElement('p'); messageParagraph.textContent = '" + error + "';  parent.parent.document.getElementById('dialog-body').contentWindow.document.getElementById('messageFrame').contentWindow.document.body.appendChild(messageParagraph); </script>" ) ;
			// out.println(error);
		    if ( error_value.equals( "1" ))
			     out.println( "<script language='JavaScript'>onsuccess('"+modal_yn+"','"+error+"','"+errorRemarks+"','"+p_called_from_widget+"')</script>" ) ;
		}        
    }

%>
</p>
</BODY>

