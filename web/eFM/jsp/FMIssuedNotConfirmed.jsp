<!DOCTYPE html>
<!-- Developed By	   :-	Prashant Bhalsingh
	 Created on   	   :	21/06/2001
	 Module Name 	   :	FM\Reports FMNotPulledForAppt.
-->
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>


<%
	request.setCharacterEncoding("UTF-8");
	String url = "../../eCommon/jsp/commonToolbar.jsp?" ;
	String params = request.getQueryString() ;
	String source = url + params ;	
%>
<html>
<head>
	<!-- <link rel='stylesheet' type ='text/css' href='../../eCommon/html/IeStyle.css'></link> -->
	<%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
	<script language='javascript' src='../../eCommon/js/common.js'></script>
	<script language='javascript' src='../../eCommon/js/ValidateControl.js' ></script>

	<script>
function reset()
{
	searchFrame.document.forms[0].reset(); 
	searchResultFrame.document.location.href='../../eCommon/html/blank.html'; 
}
function run()
{
	var error="";
	var msg="";
	 if(searchFrame.CheckPositiveNumberMy(searchFrame.document.reportFMFileNotPulledForAppointment.p_no_of_days))
	{
	if(searchFrame.document.reportFMFileNotPulledForAppointment.p_from_code.value == '')
	 {
		//var msg ="APP-FM0057 one of the option from FS Location should be selected"	  ;
		msg =getMessage("CAN_NOT_BE_BLANK","common");
		msg=msg.replace('$',getLabel("eFM.FSLocation.label","FM"));
		msg = msg +"<br>";		
	 }
	if(searchFrame.document.reportFMFileNotPulledForAppointment.p_no_of_days.value==""){
		error=getMessage("CAN_NOT_BE_BLANK","common");
		error = error.replace("$",getLabel('eFM.Filespendingformorethan.label','FM'));
		msg=msg+error;
	}
	if(msg==""){
		if(searchFrame.CheckSystemDateLesser(searchFrame.document.forms[0].p_from_date,	
		  searchFrame.document.forms[0].today.value) &&
			searchFrame.CheckSystemDateLesser(searchFrame.document.forms[0].p_to_date,
			searchFrame.document.forms[0].today.value))
		{
			searchFrame.document.forms[0].action="../../eCommon/jsp/report_options.jsp"; 
			searchFrame.document.forms[0].target="messageFrame";	
		searchFrame.document.forms[0].submit(); 
		}
		
		
	}else{
		messageFrame.location.href='../../eCommon/jsp/error.jsp?err_num='+msg;
		return false ;
	}
	
	}
 }





</script>
 <head>
<iframe name='commontoolbarFrame' id='commontoolbarFrame'      src='<%=source%>' scrolling='NO' frameborder=0  noresize style='height:8vh;width:100vw'></iframe>
<iframe name='searchFrame' id='searchFrame' src='../../eFM/jsp/FMNotIssuedConfirmed.jsp'	scrolling='NO' frameborder=0 noresize style='height:25vh;width:100vw'></iframe>
<iframe name='searchResultFrame' id='searchResultFrame' src='../../eCommon/html/blank.html' frameborder=0 scrolling='NO' noresize style='height:55vh;width:100vw'></iframe>
<iframe name='messageFrame' id='messageFrame' src='../../eCommon/jsp/error.jsp' scrolling='NO' frameborder='0' noresize style='height:12vh;width:100vw'></iframe>


