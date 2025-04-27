<!DOCTYPE html>
<%@ page import="java.sql.*, java.util.*, java.text.*,webbeans.eCommon.*" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 

<html>
<head>
<%
String sStyle	=
	(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	
%>

<TITLE> Message from</TITLE>
<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>	
	<script src='../../eCommon/js/common.js' language='javascript'></script>
	<script src='../../eAE/js/AERegisterAttn.js' language='javascript'></script>
	<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<script>
function priorityZoneCheckYes(){
window.returnValue = document.priortityzone.priority_zone_yes.value;
window.close();
}
function priorityZoneCheckNo(){
window.returnValue = document.priortityzone.priority_zone_no.value;
window.close();
}
</script>
</head>		
	<form name="priortityzone" id="priortityzone">
    <body>	
	<table border=0 align=center width="100%">	      
	       <tr><td>&nbsp;</td></tr>
		   <tr><td>&nbsp;</td></tr>
	       <tr><td align=center ><font style="color:Tahoma;font-size:12px"><fmt:message key="eAE.SeenbyDoctorImmediately.label" bundle="${ae_labels}"/></font></td></tr>
		   <tr><td>&nbsp;</td></tr>
		   <tr><td>&nbsp;</td></tr>		   
		   <tr><td align=center>
		   <input type='button' name='priority_zone_yes' id='priority_zone_yes' class='button' value='<fmt:message key="Common.yes.label" bundle="${common_labels}"/>'
		   onClick="priorityZoneCheckYes();">&nbsp;&nbsp;&nbsp;&nbsp;
		   <input type='button' name='priority_zone_no' id='priority_zone_no' class='button' value='<fmt:message key="Common.no.label" bundle="${common_labels}"/>'
		   onClick="priorityZoneCheckNo();">		    
		   </tr>
	</table>
	</form>
</html>

