<!DOCTYPE html>
<%@ page import="java.sql.*,java.util.*,webbeans.eCommon.* " contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%
	String sStyle =		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	String patientId = request.getParameter("patient_id");
	String episodeId =request.getParameter("episodeId");
	String visitId =request.getParameter("visitId");
	String episodeType =request.getParameter("episodeType");
	String noOfDecimal = request.getParameter("noOfDecimal");
	String params = request.getQueryString() ;
	System.out.println("suganya33333"+params);
	String calledFrom=request.getParameter("called_from");
%>
 
<html>
<head>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
<link rel="stylesheet" type="text/css" href="../../eCommon/html/CommonCalendar.css"></link>
<script language='javascript' src='../../eCommon/js/CommonCalendar.js' ></script>
<script language="javascript" src="../../eCommon/js/common.js"></script>
<script language="javascript" src="../../eCommon/js/FieldFormatMethods.js"></script>
<script language="javascript" src="../../eCommon/js/DateUtils.js"></script>
<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
<script language="javascript" src='../js/PkgUtilization.js'></script> 
<script language='javascript' src='../../eCommon/js/jquery-3.6.3.js'></script>
<script>
$(document).ready(function(){
	
	$('#patientId').focus();
	$('#btmframecontainer').hide();

}); 

function callPackageDetails1(obj)
{
	
	parent.PkgUtilizationPatientHdr.location.href="../../eCommon/html/blank.html";
	parent.PkgServDtlsFrame.location.href="../../eCommon/html/blank.html";
parent.PkgPatientHdr.location.href="../../eCommon/html/blank.html";
	parent.PkgDtlsFrame.location.href="../../eCommon/html/blank.html";
var episodeId=$('#episodeId').val();
var visitId=$('#visitId').val();
var episodeType=$('#episodeType').val();
	var patientId=$('#patientId').val();//obj.value;
	var noOfDecimal = $('#noOfDecimal').val();


	if(patientId==null || patientId=="")
	{
		//alert(getMessage("BL0002","BL"));
	}
	else
	{
		var xmlStr ="<root><SEARCH ";
		xmlStr+= "patientId=\"" + patientId + "\" " ;					
		xmlStr +=" /></root>";
		var temp_jsp="PkgAdhocDiscountValidation.jsp?func_mode=CHK_PAT_ID";					
		var xmlDoc = "" ;
		var xmlHttp = new XMLHttpRequest() ;
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open("POST",temp_jsp,false);
		xmlHttp.send(xmlDoc);
		var responseText=trimString(xmlHttp.responseText);		
		if(responseText=="N")
		{
			alert(getMessage("INVALID_PATIENT","MP"));
			obj.value="";
			obj.focus();
		}
		else if(responseText=="Y")
		{
			parent.PkgDtlsFrame.location.href="../../eBL/jsp/BillReceiptPkgUtilizationForPatient.jsp?patientId="+patientId+"&noOfDecimal="+noOfDecimal+"&episodeId="+episodeId+"&visitId="+visitId+"&episodeType="+episodeType;
		}
	}
}

</script>
</head>
<body onKeyDown= "lockKey();" onMouseDown="CodeArrest();" onSelect="codeArrestThruSelect();" onload="callPackageDetails1()">
	<div id='btmframecontainer'>
<form name='frmPkgPatIdHeader' id='frmPkgPatIdHeader' >
<tr>		
		<td class="label" width="25%"><b><fmt:message key="Common.patientId.label"   bundle="${common_labels}"/></b>
	
		<INPUT TYPE="textbox"  name="patientId" id="patientId"  id="patientId" SIZE="10" maxlength='20' VALUE=<%=patientId %>   readonly  >
	</tr>
	
	
	</div>
	<input type='hidden' name='episodeId' id='episodeId' id='episodeId' value='<%=episodeId %>'>
	<input type='hidden' name='noOfDecimal' id='noOfDecimal'  value='<%=noOfDecimal %>'>
	<input type='hidden' name='visitId' id='visitId' id='visitId' value='<%=visitId %>'>
	<input type='hidden' name='episodeType' id='episodeType' id='episodeType' value='<%=episodeType %>'>

	
	
</form>
</body>

