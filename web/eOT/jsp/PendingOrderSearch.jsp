<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%@ page import= "java.sql.Connection,java.sql.PreparedStatement,java.sql.ResultSet,eCommon.XSSRequestWrapper,webbeans.eCommon.ConnectionManager,eCommon.Common.CommonBean,eOT.*,eOT.Common.*,eOT.resources.*" contentType="text/html; charset=UTF-8"   %>

<html>
<head>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<% String locale = (String)session.getAttribute("LOCALE"); %>
<%	request.setCharacterEncoding("UTF-8");	
    //Added Against MMS Vulnerability Issue - Starts
    request= new XSSRequestWrapper(request);
    response.addHeader("X-XSS-Protection", "1; mode=block");
    response.addHeader("X-Content-Type-Options", "nosniff");
	//Added Against MMS Vulnerability Issue - Ends
%>

<%
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

String imgUrl="";
	if(sStyle.equals("IeStyle.css"))
	 {
			imgUrl= "../../eCommon/images/searchBoxBG.jpg";	 
	 }

%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
<link rel="stylesheet" type="text/css" href="../../eCommon/html/CommonCalendar.css"></link>
<Script Language="JavaScript" src="../../eCommon/js/CommonLookup.js"></Script>
<script type="text/javascript" src="../../eCommon/js/CommonCalendar.js"></script>
<script type='text/javascript' src='../../eCommon/js/ValidateControl.js'></script>
<script type='text/javascript' src='../../eCommon/js/common.js'></script>
<script type='text/javascript' src='../../eOT/js/Booking.js'></script>
<script type='text/javascript' src='../../eOT/js/PreOperCheckIn.js'></script>
<script language="Javascript" src="../../eCommon/js/DateUtils.js"></script>
<script language="Javascript" src="../../eOT/js/OTCommon.js"></script>
<script language='javascript' src='../../eOT/js/jquery-latest.js'></script>

	
<script language='javascript'>

function funResetAll()
{
	var frmObj=document.forms[0];
	frmObj.SURGEON.value="";
	frmObj.SURGEON_CODE.value="";
	frmObj.SPECIALITY_CODE.value="";
	frmObj.SPECIALITY_DESC.value="";
	frmObj.patientid.value="";
	frmObj.patientName.value="";
	frmObj.orderid.value="";
	frmObj.from_date.value="";
	frmObj.to_date.value="";	
	parent.qa_query_result.location.href = "../../eCommon/html/blank.html"; // KDAH-CRF-0283 [IN:050553]
}

function changeDate(da)
{
	var dat=new Array();
	var retDat="";
	dat=da.split("/");
	if(dat!=null&& dat != '' && dat.length > 0)
	{
    if(dat[1].length==1) 	dat[1]="0"+dat[1];
	if(dat[0].length==1) 	dat[0]="0"+dat[0];	

	retDat=dat[1]+"/";
	retDat+=dat[0]+"/";
	retDat+=dat[2];
	}

	return retDat;
}
function checkDate(){
	var data="";
	var data1="";

	var obj=document.forms[0];

	data=obj.from_date.value;
	data=changeDate(data);
	data1=obj.to_date.value;
	data1=changeDate(data1);

	var dat=new Date(data);
	var dat1=new Date(data1);
	if(dat>dat1){
		var msg = getMessage("DATE1_NOT_LESSER_THAN_DATE2","OT");
		var msgArray = msg.split("#");
		var todate_label = getLabel("Common.todate.label","common");
		var fromdate_label = getLabel("Common.fromdate.label","common");
		alert(msgArray[0]+todate_label+msgArray[1]+fromdate_label+msgArray[2]);
		return;
	}
}

function callPatientSearch(){
	var patient_id	=	document.forms[0].patientid;
	var patient_name	=	document.forms[0].patientName;
	var return_value =	"";

	document.forms[0].patientName.value="";
	return_value	=	(patient_id.value.length>0)?patient_id.value:PatientSearch();
	if(return_value==null)  return;
	var obj=document.forms[0];
	if(return_value!=null){
		obj.patientid.value	=	return_value;
	}else{
		obj.patientid.value	="";
	}
	
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest();
	var xmlStr ="<root></root>";
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST","CommonValidation.jsp?func_mode=patient_search&patient_id="+return_value,false);
	xmlHttp.send(xmlDoc);
	var retVal = localTrimString(xmlHttp.responseText); 
	if(retVal=="INVALID_PATIENT"){
			alert(getMessage("INVALID_PATIENT","MP"));
			patient_id.value="";
			patient_name.value="";
			patient_id.focus();
			return
	}
	
	if(retVal!="" ){
			var retVal_arr = retVal.split("##");
			patient_id.value		=return_value
			patient_name.value		= retVal_arr[0];
			document.forms[0].patientName.value=retVal_arr[0];
	}
/*Commented by Suma as part of code tuning on April 23 2010*/
	//document.forms[0].submit();
	/*ends here*/
}
function clearDesc(){
	var formObj = document.forms[0];
	var pat_id=formObj.patientid.value;
	if(pat_id=="" || pat_id==null || pat_id=="null" || pat_id=="undefined")
	formObj.patientName.value="";
}
function checkForSpecCharsforID(event)
{
    var strCheck = '0123456789/';
    var whichCode = (window.Event) ? event.which : event.keyCode;
    key = String.fromCharCode(whichCode);  // Get key value from key code
    if (strCheck.indexOf(key) == -1) return false;  // Not a valid key
	if( (event.keyCode >= 97) && (event.keyCode <= 122) )
	return (event.keyCode -= 32);
	return true ;
}
</script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<body OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()'>
<form name="addlSearchCriteriaForm" id="addlSearchCriteriaForm" method='post' action='..\..\eOT\jsp\PendingOrderSearch.jsp'>

	<%	

	String facilityid=(String)session.getValue("facility_id");
	Connection conn=null;
	PreparedStatement pstmt=null;
	ResultSet rs=null;

	String preferedDate="",sql="",strPatientId="",strSurgeonCode="",strSpecialityCode="",strSurgeonName="",strSpecialityDesc="",strPatientName="",strCheckinFlag="",tab_id="",PatIDLen="",ammendBooking="",chkBookingExistDays="";//MMS-QH-CRF-0186

	strCheckinFlag=CommonBean.checkForNull(request.getParameter("checkin_booking_flag"));
	strPatientId=CommonBean.checkForNull(request.getParameter("patientid"));	
	strSurgeonCode=CommonBean.checkForNull(request.getParameter("SURGEON_CODE"));
	strSpecialityCode=CommonBean.checkForNull(request.getParameter("SPECIALITY_CODE"));
	strSurgeonName=CommonBean.checkForNull(request.getParameter("SURGEON"));
	strSpecialityDesc=CommonBean.checkForNull(request.getParameter("SPECIALITY_DESC"));
	tab_id=CommonBean.checkForNull(request.getParameter("tab_id"));
	String called_from = CommonBean.checkForNull(request.getParameter("called_from")); //Added against for [IN:057473]
// KDAH-CRF-0283 [IN:050553]
	String sql_sm_report = "select customer_id from SM_SITE_PARAM where rownum = 1"; 
	String customerId = "";
	String bookingPriorityOrdersYN = "";
// KDAH-CRF-0283 [IN:050553]
    try
    { 
		conn = ConnectionManager.getConnection(request);
// start KDAH-CRF-0283 [IN:050553]
		pstmt = conn.prepareStatement(sql_sm_report);
		rs=pstmt.executeQuery();
		if(rs.next())
			customerId = rs.getString("CUSTOMER_ID");
		if(rs!=null)
			rs.close();
		if(pstmt !=null)
			pstmt.close();
		//pstmt = conn.prepareStatement("SELECT booking_priority_orders_yn FROM ot_param_for_facility WHERE operating_facility_id = ?");//MMS-QH-CRF-0186
		//MMS-QH-CRF-0186
		pstmt = conn.prepareStatement("SELECT booking_priority_orders_yn,nvl(ammend_bookings, 'N') ammend_bookings, chk_bookings_exist_days FROM ot_param_for_facility WHERE operating_facility_id = ?");
		
		pstmt.setString(1, facilityid);
		rs = pstmt.executeQuery();
		if(rs.next()){
		bookingPriorityOrdersYN = rs.getString("booking_priority_orders_yn");
		ammendBooking = rs.getString("ammend_bookings");
		chkBookingExistDays = rs.getString("chk_bookings_exist_days");
		}
		//MMS-QH-CRF-0186	
		if(rs!=null)
			rs.close();
		if(pstmt !=null)
			pstmt.close();
// end KDAH-CRF-0283 [IN:050553]
		 String sqlLen ="SELECT PATIENT_ID_LENGTH, to_char(SYSDATE,'dd/mm/yyyy') SYSDATE1 FROM MP_PARAM ";
		pstmt=conn.prepareStatement(sqlLen);
		 rs=pstmt.executeQuery();
	 while(rs.next() && rs!=null)
	{
     PatIDLen   = (rs.getString("PATIENT_ID_LENGTH")==null)?"0":rs.getString("PATIENT_ID_LENGTH");
	 	preferedDate=com.ehis.util.DateUtils.convertDate(rs.getString("SYSDATE1"),"DMY","en",locale);
	}
	if(rs!=null) rs.close();
	if(pstmt!=null) pstmt.close();

	if(strPatientId.length()>0)
	{
		sql=OTRepository.getOTKeyValue("SQL_OT_PENDING_SERARCH_SELECT1");
	 	pstmt=conn.prepareCall(sql);
		pstmt.setString(1,locale);
		pstmt.setString(2,strPatientId);
		rs=pstmt.executeQuery();
		if(rs.next()){
   			strPatientName=CommonBean.checkForNull(rs.getString("SHORT_NAME1"));
		}
	}
}catch(Exception ee){
	ee.printStackTrace();
	//System.err.println("Pending OrderSearch"+ee);
}
finally{
	if(rs!=null) rs.close();
	if(pstmt!=null)	pstmt.close();
	ConnectionManager.returnConnection(conn,request);
}

%>

<table cellpadding=3  cellspacing="0" border="0" width="100%" align="center">

<tr>
		<td class="label" width="25%" >
			<fmt:message key="Common.speciality.label" bundle="${common_labels}"/>
		</td>
		<td class="fields" width="25%" >
			<input type='text' name='SPECIALITY_DESC' id='SPECIALITY_DESC' maxlength='20' size='20' value= "<%=strSpecialityDesc%>"
			onBlur="if(this.value!='')return searchSpeciality(SPECIALITY_DESC); else SPECIALITY_CODE.value='' ">
			<input type='button' class='button' value='?' name='spcButton' id='spcButton' onClick="return searchSpeciality(SPECIALITY_DESC);">
		</td>
		<td class="label" width="25%" >
<%
		if(customerId != null && customerId.equalsIgnoreCase("KDAH")) // start KDAH-CRF-0283 [IN:050553]
		{
%>
			<fmt:message key="eOT.OrderingSurgeon.label" bundle="${ot_labels}"/>
<%
		}
		else
		{
%>
			<fmt:message key="Common.Surgeon.label" bundle="${common_labels}"/>
<%
		}
%>
		</td>
		<td class="fields" width="25%" >
			<input type='text' class="fields" name='SURGEON' id='SURGEON' maxlength='20' size='20' value= "<%=strSurgeonName%>" 
			onBlur="if(this.value!='')return searchSurgeon(SURGEON); else SURGEON_CODE.value='' ">
			<input type='button' class='button' value='?' name='surButton' id='surButton' onClick="return searchSurgeon(SURGEON);" >
		</td>
		
	</tr>

<tr>
		<td class="label" width="25%" >
			<fmt:message key="Common.patientId.label" bundle="${common_labels}"/>
		</td>
		<td class="fields" width="25%" >    
			<input type='text' name='patientid' id='patientid' maxlength='<%=PatIDLen%>' size='<%=PatIDLen%>' onkeypress="return CheckForSpecChars(event)" onBlur="if(this.value!='')callPatientSearch();else clearDesc() " value= "<%=strPatientId%>" >
			<input type='button' class='button' value='?' name='surButton' id='surButton' onClick="callPatientSearch();">
		</td>
		<td class="label" width="25%" >
			<fmt:message key="Common.PatientName.label" bundle="${common_labels}"/>
		</td>
		<td class="fields" width="25%" >    
			<input type='text' name='patientName' id='patientName' maxlength='30' size='30' value= "" readOnly>
		</td>
	</tr>

<tr>
		<td class="label" width="25%" >
				<fmt:message key="Common.fromdate.label" bundle="${common_labels}"/> 
		</td>
		<td class="fields" width="25%" >
				<input type='text' class="fields" name='from_date' id='from_date' size='11' value='<%=preferedDate%>'  maxlength='10' onblur='isValidDate(this);'  onkeypress="return checkForSpecCharsforID(event);">
				<img src="../../eCommon/images/CommonCalendar.gif"	
				onClick="return showCalendar('from_date','dd/mm/y');">
				<img src='../../eCommon/images/mandatory.gif'></img>
		</td>
		<td class="label" width="25%" >
				<fmt:message key="Common.todate.label" bundle="${common_labels}"/>   
		</td>
		<td class="fields" width="25%" >
				<input type='text' class="fields" name='to_date' id='to_date' size='11' value=''  maxlength='10' Onblur='isValidDate(this);' onkeypress="return checkForSpecCharsforID(event);"> 
				<img src="../../eCommon/images/CommonCalendar.gif" onblur='isValidDate(this);'	onClick="return showCalendar('to_date','dd/mm/y');">
		 </td>
</tr>

<tr>
		<td class="label" width="25%" >
			<fmt:message key="Common.OrderID.label" bundle="${common_labels}"/>
		</td>
		<td class="fields" width="25%" >
			<input type='text' class="fields" name='orderid' id='orderid' maxlength='20' size='20' value= "" onBlur="if(this.value!='')searchorderid(orderid);" >
			<input type='button' class='button' value='?'  onClick="searchorderid(orderid);">
		</td>
<%
		if(bookingPriorityOrdersYN != null && bookingPriorityOrdersYN.equalsIgnoreCase("Y")) // start KDAH-CRF-0283 [IN:050553]
		{
%>
		<td class="label" width="25%" ><fmt:message key="Common.priority.label" bundle="${common_labels}"/></td>
		<td class='fields' width='25%'>
			<select class='label' name='priority' id='priority' id='priority' >
				<option  value=''><fmt:message key="eOT.select.Label" bundle="${ot_labels}"/></option>
				<option  value='Priority-1'><fmt:message key="eOT.priority1.label" bundle="${ot_labels}"/></option>
				<option  value='Priority-2'><fmt:message key="eOT.priority2.label" bundle="${ot_labels}"/></option>
				<option  value='Priority-3'><fmt:message key="eOT.priority3.label" bundle="${ot_labels}"/></option>
		</select>&nbsp;&nbsp;
<%
		}
		else
		{
%>
			<td class='fields' width='25%'>
			<td colspan='4' align='right'>
<%
		}// end KDAH-CRF-0283 [IN:050553]
%>
			<input type="button" class="button" name="search" id="search" value='<fmt:message key="Common.search.label" bundle="${common_labels}"/>' onClick="funPendingSearch()">
			<input type="button" class="button" name="clear" id="clear" value='<fmt:message key="Common.clear.label" bundle="${common_labels}"/>' onClick="funResetAll()" >
		</td>
</tr>

</table>
				<%if(!imgUrl.equals("")){ %>
					 <img src='<%=imgUrl%>' width='100%' height='15'/> 
				<%}%>
<!-- MO-CRF-20082 -->
<script>

parent.result_dtl.location.href="../../eOT/jsp/pendingOrderTail.jsp?bookingPriorityOrdersYN=<%=bookingPriorityOrdersYN%>&ammendBooking=<%=ammendBooking%>&called_from=<%=called_from%>"; <!-- Added against for [IN:057473] -->
<%
		if(bookingPriorityOrdersYN != null && bookingPriorityOrdersYN.equalsIgnoreCase("Y")) // start 052734
		{
%>
		//parent.result_dtl.location.href="../../eOT/jsp/pendingOrderTail.jsp?bookingPriorityOrdersYN=<%=bookingPriorityOrdersYN%>&ammendBooking=<%=ammendBooking%>";
<%
		}		
%>
</script>
<!-- MO-CRF-20082 -->

<input type='hidden' name='orderiddate' id='orderiddate' value=''>
<input type='hidden' name='date_compare' id='date_compare' value='<%=preferedDate%>'>
<input type='hidden' name='facility_id' id='facility_id' value='<%=facilityid%>'>
<input type='hidden' name='SPECIALITY_CODE' id='SPECIALITY_CODE' value='<%=strSpecialityCode%>'>
<input type='hidden' name='SURGEON_CODE' id='SURGEON_CODE' value='<%=strSurgeonCode%>'>
<input type='hidden' name='checkin_booking_flag' id='checkin_booking_flag' value='<%=strCheckinFlag%>'>
<input type='hidden' name='tab_id' id='tab_id' value='<%=tab_id%>'>
<input type='hidden' name='locale' id='locale' value="<%=locale%>">
<input type='hidden' name='patient_id' id='patient_id' value="<%=strPatientId%>" >
<input type='hidden' name='customerId' id='customerId' id='customerId' value="<%=customerId%>" >
<input type='hidden' name='bookingPriorityOrdersYN' id='bookingPriorityOrdersYN' id='bookingPriorityOrdersYN' value="<%=bookingPriorityOrdersYN%>" >
<input type='hidden' name='chkBookingExistDays' id='chkBookingExistDays' id='chkBookingExistDays' value="<%=chkBookingExistDays%>" ><!-- MMS-QH-CRF-0186 -->
<input type='hidden' name="called_from" id="called_from" value="<%=called_from%>"> <!-- Added against for [IN:057473] -->
</form>
</body>
</html>

