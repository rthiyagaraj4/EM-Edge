<!DOCTYPE html>
<% 
/*
-------------------------------------------------------------------------------------------------------------------------------------
Date       		Edit History    	Name        	Description
-------------------------------------------------------------------------------------------------------------------------------------
?             	100            		?           	created
20/01/2012		CHL-CRF [IN035950]	Ramesh G	CHL-CRF [IN035950]										
-------------------------------------------------------------------------------------------------------------------------------------
*/
%>
<%@ page import="eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<script language='javascript' src='../js/RecPatChiefComplaint.js'></script>
<head>
<%
	request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String sStyle =	(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

%>

	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />
<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
<script language="JavaScript" >

function onsuccess(encounter_id,p_called_from_widget)
{	
	//CHL-CRF Start.[IN035950]
	if(p_called_from_widget!=""){
		parent.RecPatChiefComplaintResultFrame.location.href="../../eCA/jsp/RecPatChiefComplaintResult.jsp?encounter_id="+encounter_id+"&p_called_from_widget="+p_called_from_widget;
		parent.RecPatChiefComplaintAddModifyFrame.location.href="../../eCA/jsp/RecPatChiefComplaintAddModify.jsp?encounter_id="+encounter_id+"&p_called_from_widget="+p_called_from_widget;
	}else{
	//CHL-CRF Start.[IN035950]
		parent.frames[3].RecPatChiefComplaintResultFrame.location.href="../../eCA/jsp/RecPatChiefComplaintResult.jsp?encounter_id="+encounter_id;
		parent.frames[3].RecPatChiefComplaintAddModifyFrame.location.href="../../eCA/jsp/RecPatChiefComplaintAddModify.jsp?encounter_id="+encounter_id;
	} //CHL-CRF[IN035950]
}

</script>
</head>

<BODY CLASS="MESSAGE" onKeyDown="lockKey()">

<p align="left">

<%
	String error=request.getParameter( "err_num" );
	if(error != null){
		out.println( error ) ;
	String error_value = request.getParameter( "err_value" )==null ? "0" : request.getParameter( "err_value" ) ;
	String encounter_id = request.getParameter("encounter_id")==null?"":request.getParameter("encounter_id");
	String p_called_from_widget = request.getParameter("p_called_from_widget")==null?"":request.getParameter("p_called_from_widget"); //CHL-CRF [IN035950]
		if ( error_value.equals( "1" ) ){
			//CHL-CRF Start.[IN035950]
			//out.println( "<script language='JavaScript'>onsuccess('"+encounter_id+"');</script>" ) ;
			out.println( "<script language='JavaScript'>onsuccess('"+encounter_id+"','"+p_called_from_widget+"');</script>" ) ;
			//CHL-CRF Start.[IN035950]
		}
	}
%>
</p>
</BODY>

