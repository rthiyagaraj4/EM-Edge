<!DOCTYPE html>
<%@page import="eBL.BLReportIdMapper,eXH.CreditCardTransactions"%>
<%@ page import="java.sql.*, webbeans.eCommon.* ,webbeans.op.CurrencyFormat, java.io.*,java.util.*,java.net.*,java.lang.*,ecis.utils.OnlineReport,ecis.utils.OnlineReports" contentType="text/html;charset=UTF-8"  %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<head>
<script language="javascript" src="../../eCommon/js/common.js"></script>
<script language="javascript" src="../../eCommon/js/DateUtils.js"></script>
<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
<script language='javascript' src='../../eCommon/js/jquery-3.6.3.js'></script>
<script language="JavaScript">
$(document).ready(function(){
	var dtDisp = '';
	if($('#currdate').val() != ''){
		var curDt = $('#currdate').val().split(" ");
		var timeArr = curDt[1].split(":");
		dtDisp = curDt[0]+" "+timeArr[0]+":"+timeArr[1];
	}
	
	parent.frames[4].document.forms[0].postmthyr.value=$('#month').val();
	parent.frames[4].document.forms[0].postmonthyr.value=$('#year').val();						
	parent.frames[4].document.forms[0].doc_date.value= dtDisp;
	parent.frames[4].document.forms[0].cash_ctr.value=$('#cash_counter_code').val();
	parent.frames[4].document.forms[0].shift.value=$('#shift_id').val();
	if($('#sys_warning').val()!=''){
		alert(getMessage($('#sys_warning').val(),'BL'));
	}
	alert($('#errorMessage').val());
	if($('#printYn').val() == 'Y'){
		callAsyncOnlinePrint();		
	}

	if($('#err_val').val() == 1){
		//window.close();
	    const dialogTag = parent.parent.document.getElementById("dialog_tag");    
	    dialogTag.close();
	}
	else{
		parent.frames[2].document.forms[0].target = '';
	}

});

function callAsyncOnlinePrint(){		
	
	var xmlStr="<root><report/></root>";
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest() ;
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST","../../eBL/jsp/BLAdhocDiscOnlineReport.jsp",true);
	xmlHttp.send(xmlDoc);	
}
</script >
<%!
private String decodeParam(String input){
	String output = "";
	try{
		if(input!=null){
			input = input.replaceAll("%(?![0-9a-fA-F]{2})", "%25");
			input = input.replaceAll("\\+", "%2B");
			output = URLDecoder.decode(input,"UTF-8");
		}
	}
	catch(Exception e){
		System.err.println("Exception while Decoding BillReceiptAjax->"+e);
	}
	return output;
}
%>
</head>

<html>
<BODY CLASS="MESSAGE" onKeyDown = 'lockKey()'>
<form id='messageFrm'>
<p align="left">
<%

	request.setCharacterEncoding("UTF-8");
	String locale	= (String)session.getAttribute("LOCALE");
	String month = decodeParam(request.getParameter("month"));
	String year = decodeParam(request.getParameter("year"));
	String currdate = decodeParam(request.getParameter("currdate"));
	String cash_counter_code = decodeParam(request.getParameter("cash_counter_code"));
	String shift_id = decodeParam(request.getParameter("shift_id"));
	String printYn = decodeParam(request.getParameter("printYn"));
	String errorMessage = decodeParam(request.getParameter("errorMessage"));
	String err_val = decodeParam(request.getParameter("err_val"));
	String sys_warning = decodeParam(request.getParameter("sys_warning"));
%>
<input type='hidden' name='month' id='month' id='month' value='<%=month%>'>
<input type='hidden' name='year' id='year' id='year' value='<%=year%>'>
<input type='hidden' name='currdate' id='currdate' id='currdate' value='<%=currdate%>'>
<input type='hidden' name='cash_counter_code' id='cash_counter_code' id='cash_counter_code' value='<%=cash_counter_code%>'>
<input type='hidden' name='shift_id' id='shift_id' id='shift_id' value='<%=shift_id%>'>
<input type='hidden' name='printYn' id='printYn' id='printYn' value='<%=printYn%>'>
<input type='hidden' name='errorMessage' id='errorMessage' id='errorMessage' value='<%=errorMessage%>'>
<input type='hidden' name='err_val' id='err_val' id='err_val' value='<%=err_val%>'>
<input type='hidden' name='sys_warning' id='sys_warning' id='sys_warning' value='<%=sys_warning%>'>

</form>
</body>

</html>

