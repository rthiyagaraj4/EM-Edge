<!DOCTYPE html>
<!--Created by Ashwini on 05-May-2017 for ML-MMOH-CRF-0698-->
<%@ page contentType="text/html;charset=UTF-8" %>
<script>
 function reset()
 {
	searchResultFrame.document.location.href="../../eCommon/html/blank.html";  
	searchFrame.document.forms[0].PatientId.value="";
	searchFrame.document.forms[0].enc_type.value="";
	searchFrame.document.forms[0].frm_enc_date.value="";
	searchFrame.document.forms[0].to_enc_date.value="";
	searchFrame.document.forms[0].PatientId.focus(); 
 }
</script>
<%
	request.setCharacterEncoding("UTF-8");
	String url = "../../eCommon/jsp/commonToolbar.jsp?" ;
	String params = request.getQueryString() ;
	String source = url + params ;	
%>
<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>
<html>
<head>
	<link rel="stylesheet" type="text/css" href="../../eCommon/html/<%=sStyle%>"></link>
	<script language='javascript' src='../../ecommon/js/common.js'></script>
 <head>
<iframe name='commontoolbarFrame' id='commontoolbarFrame'      src='<%=source%>' scrolling='NO' frameborder=0  noresize style='height:8vh;width:100vw'></iframe>
	<iframe name='searchFrame' id='searchFrame'       src='../../eMR/jsp/ConfirmVisitAdmsnSearch.jsp'	scrolling='No' frameborder=0 style='height:25vh;width:100vw'></iframe>
	<iframe name='searchResultFrame' id='searchResultFrame' src='../../eCommon/html/blank.html' frameborder=0 scrolling='auto' noresize style='height:60vh;width:100vw'></iframe>
	<iframe name='messageFrame' id='messageFrame' src='../../eCommon/jsp/error.jsp' scrolling='NO' frameborder='0' noresize style='height:9vh;width:100vw'></iframe>

<%!
	public static String checkForNull(String inputString)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? "" : inputString);
	}
	public static String checkForNull(String inputString, String defaultValue)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? defaultValue : inputString);
	}
%>

