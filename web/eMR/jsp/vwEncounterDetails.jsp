<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" %>
<script>
function reset()
 {
	//searchFrame.document.forms[0].search[1].disabled=false;
	patientDetailsFrame.document.location.href="../../eCommon/html/blank.html";
	searchResultFrame.document.location.href="../../eCommon/html/blank.html";  
	//searchFrame.document.getElementById("PatientDetail").innerHTML = "&nbsp;"
	
	/*Added for Bru-HIMS-CRF-380 Start*/
	//searchFrame.document.forms[0].reset(); 
	
	searchFrame.document.forms[0].PatientId.value="";
	searchFrame.document.forms[0].p_fm_encoun_date.value="";
	searchFrame.document.forms[0].p_to_encoun_date.value="";
	searchFrame.document.forms[0].p_enc_type.value="";
	searchFrame.document.forms[0].p_encounter_id.value="";
	searchFrame.document.forms[0].p_all_facility_id.value=searchFrame.document.forms[0].facility.value;
	searchFrame.document.forms[0].p_order_by.value="PATIENT_CLASS";
	
	
	searchFrame.document.forms[0].PatientId.focus(); 
	/*Added for Bru-HIMS-CRF-380 End*/
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
	<script language='javascript' src='../../eCommon/js/common.js'></script>
 <head>
<iframe name='commontoolbarFrame' id='commontoolbarFrame'      src='<%=source%>' scrolling='NO' frameborder=0  noresize style='height:8vh;width:100vw'></iframe>
	<iframe name='searchFrame' id='searchFrame'       src='../../eMR/jsp/vwEncounterDetailSearch.jsp'	scrolling='No' frameborder=0  style='height:20vh;width:100vw'></iframe>
	<iframe name='patientDetailsFrame' id='patientDetailsFrame' src='../../eCommon/html/blank.html' frameborder=0 scrolling='no' style='height:9vh;width:100vw'></iframe>
	<iframe name='searchResultFrame' id='searchResultFrame' src='../../eCommon/html/blank.html' frameborder=0 scrolling='auto' noresize style='height:50vh;width:100vw'></iframe>
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

