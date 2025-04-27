<!DOCTYPE html>
<html>
<%@page   import= "java.sql.Connection,java.sql.PreparedStatement,java.sql.ResultSet,java.sql.Clob,webbeans.eCommon.ConnectionManager,eOT.OperationDtlBean,eOT.Common.OTRepository,java.util.ArrayList,eOR.OrderEntryBillingQueryBean" %>

<%@page  contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eOT/jsp/StringUtil.jsp"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>

<% String locale = (String)session.getAttribute("LOCALE"); 
	request.setCharacterEncoding("UTF-8"); 
	String or_bean_id 				    = "orderentrybean";
    String or_bean_name 			    = "eOR.OrderEntryBean";
%>
<head>
<!-- <TITLE><fmt:message key="Common.booking.label" bundle="${common_labels}"/></TITLE> -->
<%
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
//System.out.println("Sanjay Ftr- " + request.getQueryString());
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
<link rel="stylesheet" type="text/css" href="../../eCommon/html/CommonCalendar.css"/>
<Script Language="JavaScript"  src="../../eCommon/js/CommonLookup.js"></Script>
<script type="text/javascript" src="../../eCommon/js/CommonCalendar.js"></script>
<script type='text/javascript' src='../../eCommon/js/ValidateControl.js'></script>
<script type='text/javascript' src='../../eOT/js/Booking.js'></script>
<script type='text/javascript' src='../../eOT/js/BookingPatientSearch.js'></script>
<script type="text/javascript" src="../../eOT/js/OTCommon.js"></script>
<script type='text/javascript' src='../../eOT/js/OTPatientSearch.js'></script>
<script language="Javascript" src="../../eCommon/js/DateUtils.js"></script>
<script>

function showBookingDialog1 (){
	var dialogHeight 		= screen.availHeight;
	var dialogWidth  		= screen.availWidth;
	var dialogTop   		= "0";
	var dialogLeft   		= "0";
	var features			= "dialogLeft:"+dialogLeft+"dialogTop:"+dialogTop+"; dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth+";status:no";
	var arguments			= "";
	var retVal="";
	var retVal1="";
	var obj = parent.frames[0].document.forms[0];		
	//var obj=document.forms[0];
	//var locale = obj.locale.value;
	var procedure = obj.procedure.value;
	var fromTime=obj.start_time.value;
	var specialityCode = obj.speciality_code.value;	
	var specialityDesc = obj.speciality_desc.value;
	var surgeonCode = obj.surgeonCode.value;
	var surgeonName = obj.surgeonName.value;
	var roomCode = obj.roomCode.value;
	var roomDesc = obj.roomDesc.value;
	var booking_date = obj.booking_date.value;
	var called_from = obj.called_from.value;
	var hiddenTime = obj.hidden_time.value;
	var over_booking_case_yn = obj.over_booking_case_yn.value;
	var locale = obj.locale.value;	
	//if(obj.orderid.value==null||obj.orderid.value==''){		
		var param="booking_date="+convertDate(booking_date,'DMY','en',locale)+"&roomCode="+roomCode+"&roomDesc="+encodeURIComponent(roomDesc)+"&surgeonCode="+surgeonCode+"&surgeonName="+encodeURIComponent(surgeonName)+"&speciality_code="+specialityCode+"&speciality_desc="+encodeURIComponent(specialityDesc)+"&start_time="+fromTime+"&hidden_time="+hiddenTime+"&over_booking_case_yn="+over_booking_case_yn+"&called_from="+called_from+"&procedure="+procedure;		
		var strval=obj.orderid.value;
		param+="&orderid="+strval;				
		retVal1=""+window.showModalDialog("../../eOT/jsp/OperationRegisterFrame.jsp?"+param,arguments,features);//Sanjay		
		window.close();
		//retVal1=""+window.showModalDialog("../../eOT/jsp/OperOverBookingFrame.jsp?"+param,arguments,features);//Sanjay	
	//}
}
// Function for Reschedule/Transfer Booking
function showBookingDialog2 (booking_no,facility_id,function_id,orderid){
	var dialogHeight 		= screen.availHeight;
	var dialogWidth  		= screen.availWidth;
	var dialogTop   		= "0";
	var dialogLeft   		= "0";
	var features			= "dialogLeft:"+dialogLeft+"dialogTop:"+dialogTop+"; dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth+";status:no";
	var arguments			= "";
	var retVal="";
	var retVal1="";
	var obj = parent.frames[0].document.forms[0];		
	//var obj=document.forms[0];
	//var locale = obj.locale.value;
	var procedure = obj.procedure.value;
	var fromTime=obj.start_time.value;
	var specialityCode = obj.speciality_code.value;	
	var specialityDesc = obj.speciality_desc.value;
	var surgeonCode = obj.surgeonCode.value;
	var surgeonName = obj.surgeonName.value;
	var roomCode = obj.roomCode.value;
	var roomDesc = obj.roomDesc.value;
	var booking_date = obj.booking_date.value;
	var called_from = obj.called_from.value;
	var hiddenTime = obj.hidden_time.value;
	var over_booking_case_yn = obj.over_booking_case_yn.value;
	var locale = obj.locale.value;
	//alert('showBookingDialog2');//Sanjay
	var param="booking_date="+convertDate(booking_date,'DMY','en',locale)+"&roomCode="+roomCode+"&roomDesc="+encodeURIComponent(roomDesc)+"&surgeonCode="+surgeonCode+"&surgeonName="+encodeURIComponent(surgeonName)+"&speciality_code="+specialityCode+"&speciality_desc="+encodeURIComponent(specialityDesc)+"&start_time="+fromTime+"&hidden_time="+hiddenTime+"&transfer=1"+"&booking_no="+booking_no+"&facility_id="+facility_id+"&order_id="+orderid+"&over_booking_case_yn=Y"+"&called_from="+called_from+"&function_id="+function_id;		
	retVal1=""+window.showModalDialog("../../eOT/jsp/BookingDetailFrame.jsp?"+param,arguments,features);	
	if (retVal1 == 1)
	{
		window.returnValue = "YES";
	}	
	window.close();		
}

function setNo(){ 
       window.returnValue = "NO";
    }

function setOk(){ 
       window.returnValue = "OK";
}

</script>
</head>

<body OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()'>
<script type="text/javascript" src="../../eOT/js/wz_tooltip.js"></script>
<Script src=\"../../eCommon/js/showModalDialog.js\" language=\"JavaScript\"></Script>



<form name='OverBookedCasesFtr' id='OverBookedCasesFtr' method='POST' action='../../eOT/jsp/OperationProcedureHdr.jsp'>
<%@ include file="../../eCommon/jsp/Common.jsp"%>
<%
String row_count = checkForNull(request.getParameter("row_count"));
String userOverBookYN = checkForNull(request.getParameter("userOverBookYN"));
//Added on 7-11-12 by Muthu against 31719
String overbookcount = checkForNull(request.getParameter("overbookcount"));
int rowCount = Integer.parseInt(row_count);
int overBookCount = Integer.parseInt(overbookcount);
int overBookAvail = overBookCount-rowCount;
//Added on 7-11-12 by Muthu against 31719
String orderid= "";
String booking_no = checkForNull(request.getParameter("booking_no"));
//out.println("booking_no:"+booking_no);
String facility_id = "";
String function_id = "";
//if (Integer.parseInt(overbookcount) > 0 ) {//Sanjay
%>
<tr>
<td>
	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	<B> <fmt:message key="eOT.TotalOverBookedCases.Label" bundle="${ot_labels}"/> </B> <%= row_count %> 
</td>
</tr><br>
<!-- Added on 7-11-12 by Muthu against 31719-->
<tr>
<td>
	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	<B> <fmt:message key="eOT.OverBookingAvailability.Label" bundle="${ot_labels}"/> </B> <%= overBookAvail %> 
</td>
<!-- Added on 7-11-12 by Muthu against 31719-->

<!--
<td>
<input type='text' class = "fields" name='OverBookedCount' id='OverBookedCount' size = '1' value=''  border="0" cellspacing="0" cellpadding="0" disabled>
</td>
-->


<%
//}//Sanjay
// if user has rights to Over Book, then Yes and No button would be enabled
if (userOverBookYN.equalsIgnoreCase("Y") &&  overBookAvail > 0) {
%>
<td>
	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	<fmt:message key="eOT.ContinueBooking.Label" bundle="${ot_labels}"/> 
</td>

<!--	<input type = 'button' name ='Yes' value = 'Yes' onclick = "showBookingDialog1()"> -->
<%
	if (booking_no.length() > 0 ) {	
	orderid = checkForNull(request.getParameter("orderid"));
	facility_id = checkForNull(request.getParameter("facility_id"));
	function_id = checkForNull(request.getParameter("function_id"));
%>
<td>
<input type = 'button' name ='Yes' value = '<fmt:message key="Common.yes.label" bundle="${common_labels}"/>' onclick = 'showBookingDialog2("<%=booking_no%>","<%=facility_id%>","<%=function_id%>","<%=orderid%>");'>
</td>
<%
	}
	else {
%>
<td>
<input type = 'button' name ='Yes' value = '<fmt:message key="Common.yes.label" bundle="${common_labels}"/>' onclick = 'showBookingDialog1();'>
</td>
<%
	}
%>
<td>
	<input type = 'button' name ='No' value = '<fmt:message key="Common.no.label" bundle="${common_labels}"/>' onclick = 'setNo(); window.close();'>
</td>

<%
// if user does not have rights to Over Book, then OK button would be enabled
} //else if (userOverBookYN.equalsIgnoreCase("N")  ||  overBookAvail == 0) {
	else {
%>
<td>
	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	<input type = 'button' name ='Ok' value = '<fmt:message key="Common.ok.label" bundle="${common_labels}"/>' onclick = 'setOk(); window.close();'>
</td>
<%
}
%>
</tr>

</form>
</BODY>
</HTML>

