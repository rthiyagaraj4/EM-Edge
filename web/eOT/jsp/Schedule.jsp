<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%> 
<%@ page import ="java.sql.Connection,java.sql.PreparedStatement,java.sql.ResultSet,eCommon.XSSRequestWrapper,webbeans.eCommon.ConnectionManager,eOT.Common.OTRepository,java.util.*,java.text.*" %>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp" %>
<%@ include file="../../eOT/jsp/StringUtil.jsp" %>
<script  language='javascript' src='../../eCommon/js/ValidateControl.js'></script>
<script language='javascript' src='../../eOT/js/jquery-latest.js'></script>
<script language='javascript'  src='../../eOT/js/CancelTransfer.js' ></script> 
<script language='javascript'  src='../../eOT/js/Booking.js' ></script>
<script language='javascript' src='../../eCommon/js/common.js' ></script>
<script type="text/javascript" src="../../eOT/js/OTCommon.js"></script>
<script language="Javascript" src="../../eCommon/js/DateUtils.js"></script>

<html>
<head>

<%
	String locale = (String)session.getAttribute("LOCALE");
	request.setCharacterEncoding("UTF-8");
    //Added Against MMS Vulnerability Issue - Starts
    request= new XSSRequestWrapper(request);
    response.addHeader("X-XSS-Protection", "1; mode=block");
    response.addHeader("X-Content-Type-Options", "nosniff");
	//Added Against MMS Vulnerability Issue - Ends 

	String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	String ammendFlag = checkForNull(request.getParameter("ammendFlag"));
	String fpp_category = checkForNull(request.getParameter("fpp_category"));	//ML-MMOH-CRF-1939-US005
	System.err.println("fpp_category in param "+fpp_category);
%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
<script language='javascript'>
function setAssignValue(dat)
{
	return dat;
}

function funCompareTime(hiddenTime)
{
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest() ;
	var xmlStr ="<root><SEARCH ";
	xmlStr +=" /></root>";
	param="sql=SELECT FLOOR(TO_DATE(TO_CHAR(SYSDATE,'dd/mm/yyyy hh24:mi'),'dd/mm/yyyy hh24:mi')-TO_DATE('"+hiddenTime+"','dd/mm/yyyy hh24:mi')) FROM dual";
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST","../../servlet/eOT.CommonQueryServlet?"+param,false);
	xmlHttp.send(xmlDoc);
	var retVal = xmlHttp.responseText;		
	retVal=eval(retVal);
	var val=parseInt(retVal,10);	 
	 if(val<0) 
		 return true;
	 else	 
		 return false;
}

async function showBookingDialog1(spltycode,spltydesc,fromTime,hiddenTime,specialityCode,index)
{	
	var dialogHeight= "99vh" ;
	var dialogTop = "10px" ;
	var dialogWidth	= "90vw" ;
	var dialogLeft	= "25px" ;
	var features = "dialogLeft:"+dialogLeft+"; dialogTop:"+dialogTop+"; dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth+";status:no";
	var arguments			= "";
	var retVal="";
	var retVal1="";
	var obj=document.forms[0];
	var chkSize;
	var selSurgeonCode;//ML-BRU-SCF-1439 [051911]
	if(document.forms[0].chkSize.value == '')
		chkSize = 0;
	chkSize = parseInt(document.forms[0].chkSize.value);
	selSurgeonCode = document.forms[0].selSurgeonCode.value;// ML-BRU-SCF-1439 [051911]
	var end_time=obj.end_time.value;
	var called_from=obj.called_from.value;
	var procedure=obj.procedure.value;
	var locale = obj.locale.value;
	var function_id = obj.function_id.value;
	var specialityDesc=eval("obj.splty"+index+".value");
	var bo_date=obj.booking_date.value+"  "+fromTime;
	var chkFlag=funCompareTime(bo_date);
	var totalDurPend = 0;
	//002495
	var strval = obj.orderid.value;//002495
	if(chkFlag==false)
		alert(getMessage("TIME_LESS_THAN","OT"));	
	else
	{
		//PMG2014-CRF-0024 US-3 start
		var duplPatientIdSearchFlag = true;
		var facilityId = $('#facilityId').val();
		var todaysDate = $('#todaysDate').val();
		var bookingDate = $('#bookingDate').val();
		var patientId = $('#patientId').val();
				
		//PMG MOD CRF-24 US-3 START	
		if(patientId == '' || patientId=='undefined' || patientId==null)
		{
			var orderId=document.forms[0].orderid.value;			
			var xmlDoc = "" ;
			var xmlHttp = new XMLHttpRequest();
			var xmlStr ="<root></root>";
			xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
			xmlHttp.open("POST","CommonValidation.jsp?func_mode=getPatientId&orderId="+orderId+"&facilityId="+facilityId, false);
			xmlHttp.send(xmlDoc);
			patientId = localTrimString(xmlHttp.responseText);			
		}
		//PMG MOD CRF-24 US-3 END
		
		if(todaysDate == bookingDate)
		{
			var xmlDoc = "" ;
			var xmlHttp = new XMLHttpRequest();
			var xmlStr ="<root></root>";
			xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
			xmlHttp.open("POST","CommonValidation.jsp?func_mode=duplPatientIdSearch&patient_id="+patientId+"&facilityId="+facilityId, false);
			xmlHttp.send(xmlDoc);
			var duplPatientIdSearch = localTrimString(xmlHttp.responseText);
			var duplPatientIdSearchArray = duplPatientIdSearch.split("~");
			if(duplPatientIdSearchArray[0] == "REC_EXIST")
			{
				if(duplPatientIdSearchArray[2] == 'Y')
				{
						if(!window.confirm(getMessage("APP-OT0228","OT")))
							duplPatientIdSearchFlag = false;
				}
			}
		}
		if(duplPatientIdSearchFlag)
		{
		//PMG2014-CRF-0024 end
		var strval=obj.orderid.value;//002495
		//Added against KAUH-SCF-0282 Starts here		   
		var customer_id1=obj.customer_id1.value;
		var facility_id=obj.facility_id.value;		
		var booking_date1=obj.booking_date.value;
		var xmlDoc = "" ;
		var xmlHttp = new XMLHttpRequest();
		var params = "order_id="+strval+"&queried_pref_surg_date="+booking_date1+"&facility_id="+facility_id+"&booking_no="+fromTime+"&customerId="+customer_id1;
		var xmlStr ="<root><SEARCH ";
		xmlStr +=" /></root>";
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open("POST","CommonValidation.jsp?func_mode=validateElectiveCutOffTime&"+params,false);
		xmlHttp.send(xmlDoc);
		var retVal = trimString(xmlHttp.responseText);
		if(retVal.length>1)
		{
			var msg = getMessage("APP-OT0124","OT");
			alert(msg);
		}
		else
		{
		//Added against KAUH-SCF-0282 Ends here
		if(obj.booking_no.value == null || obj.booking_no.value == '')
		{		
			var param="booking_date="+convertDate(obj.booking_date.value,'DMY','en',locale)+
			"&start_time="+fromTime+
			"&end_time="+end_time+
			"&roomCode="+obj.roomCode.value+
			"&roomDesc="+encodeURIComponent(obj.roomDesc.value)+
			"&surgeonCode="+obj.surgeonCode.value+
			"&surgeonName="+encodeURIComponent(obj.surgeonName.value)+
			"&speciality_code="+specialityCode+
			"&selSurgeonCode="+selSurgeonCode+
			"&hidden_time="+hiddenTime+
			"&called_from="+called_from+
			"&spltycode="+spltycode+
			"&spltydesc="+spltydesc+
			"&procedure="+procedure+
			"&function_id="+function_id+
			"&speciality_desc="+encodeURIComponent(specialityDesc)+
			"&orderid="+strval+
			"&patientId="+patientId+
			"&full_vacant="+obj.full_vacant.value+
			"&selOrderIds="+obj.selOrderIds.value+
			"&selBookingNumber="+obj.selBookingNumber.value+
			"&fpp_category="+obj.fpp_category.value+//ML-MMOH-CRF-1939-US005
			"&ammendFlag="+obj.ammendFlag.value;//MMS-QH-CRF-186

			retVal1=""+await top.window.showModalDialog("../../eOT/jsp/OperationRegisterFrame.jsp?"+param,arguments,features);
			var par="";
			//Refresh Issue while ammend Booking starts
			var ammendFlag1=obj.ammendFlag.value;
			//Added Against alpha-ICN		
			/* var param1="booking_date="+convertDate(obj.booking_date.value,'DMY','en',locale)+
						"&roomCode="+obj.roomCode.value+
						"&roomDesc="+encodeURIComponent(obj.roomDesc.value)+
						"&surgeonCode="+obj.surgeonCode.value+
						"&surgeonName="+encodeURIComponent(obj.surgeonName.value)+
						"&speciality_code="+specialityCode+
						"&speciality_desc="+encodeURIComponent(specialityDesc)+
						"&orderid="+strval+
						"&selOrderIds="+obj.selOrderIds.value+
						"&called_from="+called_from+
						"&procedure="+procedure+
						"&function_id="+function_id+
						"&selSurgeonCode="+selSurgeonCode+
						"&full_vacant="+obj.full_vacant.value+					
						"&booking_no="+obj.booking_no.value+
						"&start_time="+fromTime+
						"&end_time="+end_time+
						"&chkSize=1"; */
						
			var param1="booking_date="+obj.booking_date.value+
						"&roomCode="+obj.roomCode.value+
						"&roomDesc="+encodeURIComponent(obj.roomDesc.value)+
						"&surgeonCode="+obj.surgeonCode.value+
						"&surgeonName="+encodeURIComponent(obj.surgeonName.value)+
						"&speciality_code="+specialityCode+
						"&speciality_desc="+encodeURIComponent(specialityDesc)+
						"&orderid="+strval+
						"&selOrderIds="+obj.selOrderIds.value+
						"&called_from="+called_from+
						"&procedure="+procedure+
						"&function_id="+function_id+
						"&selSurgeonCode="+selSurgeonCode+
						"&full_vacant="+obj.full_vacant.value+					
						"&booking_no="+obj.booking_no.value+
						"&start_time="+fromTime+
						"&end_time="+end_time+
						"&chkSize=1";	 //Modified Against SKR-SCF-1384
			
			if(retVal1.charAt(0)=='1')
			{
				if(chkSize == '0' || chkSize == '1' || chkSize == '' || isNaN(chkSize))
					par = obj.param1.value;
				else if(chkSize == '2')
					par = parent.result0.document.getElementById("param1").value + "~" + parent.result1.document.getElementById("param1").value;
				else if(chkSize == '3')
					par = parent.result0.document.getElementById("param1").value + "~" + parent.result1.document.getElementById("param1").value + "~~" + parent.result2.document.getElementById("param1").value;
				
				if((obj.orderid!=null&&obj.orderid.value.length > 0) || (obj.booking_no!=null&&obj.booking_no.value.length >0)){
					//par += "&fun=1"; //commented for alpha-ICN (Need to check here)	
				}
				if(ammendFlag1 =='Y'){
				parent.dispSlotsFrame.location.href="../../eOT/jsp/Schedule.jsp?"+par;
				}	//Refresh Issue while ammend Booking ends
				else if(chkSize == '0' || chkSize == '' || (isNaN(chkSize))){	//44391-Chaitanya //57524
						// Commented and Added Below line
						//parent.qa_query_result.location.href="../../eOT/jsp/Schedule.jsp?"+par;
						parent.qa_query_result.location.href="../../eOT/jsp/Schedule.jsp?"+param1;
				}
				else if(chkSize == '1' || chkSize == '2' || chkSize == '3'){
						parent.parent.qa_query_result.location.href="../../eOT/jsp/ScheduleFrame.jsp?"+par;
				}		
					if(called_from!='')
					{
						if(chkSize == '0' || chkSize == '' || isNaN(chkSize))
						{
							//parent.qa_query_result.location.href="../../eOT/jsp/Schedule.jsp?"+par; // commented by selvin script error
							/* parent.frames[2].location.href="../../eOT/jsp/Schedule.jsp?"+par;
							parent.result0.ScheduleStatus.disabled=true;
							parent.frames[0].ScheduleStatusspan.disabled=true; */
						}
						else if(chkSize == '1' || chkSize == '2' || chkSize == '3')
						{
							//Added Against start alpha-ICN
							if(chkSize == '1'){
								parent.parent.qa_query_result.location.href="../../eOT/jsp/ScheduleFrame.jsp?"+param1;
							}else if(chkSize == '2' || chkSize == '3'){
								parent.parent.qa_query_result.location.href="../../eOT/jsp/ScheduleFrame.jsp?"+par;
							}
							//Added Against end alpha-ICN
							parent.parent.frames[0].ScheduleStatus.disabled=true;
							parent.parent.frames[0].ScheduleStatusspan.disabled=true;		
						}
					}
				}
			}
			else
			{	
				var param="booking_date="+obj.booking_date.value+"&roomCode="+obj.roomCode.value+"&roomDesc="+obj.roomDesc.value+"&surgeonCode="+obj.surgeonCode.value+"&surgeonName="+encodeURIComponent(obj.surgeonName.value)+"&speciality_code="+specialityCode+"&start_time="+fromTime+"&end_time="+end_time+"&hidden_time="+hiddenTime+"&transfer=1"+"&booking_no="+obj.booking_no.value+"&facility_id="+obj.facility_id.value+"&order_id="+obj.orderid.value+"&spltycode="+spltycode+"&procedure="+procedure+"&function_id="+function_id+"&speciality_desc="+encodeURIComponent(specialityDesc)+"&startTime="+obj.startTime.value+"&endTime="+obj.endTime.value+"&timeDifference="+obj.timeDifference.value;//spltycode using for checking block speciality case
				param+="&selOrderIds="+obj.selOrderIds.value;
				retVal1=""+await top.window.showModalDialog("../../eOT/jsp/BookingDetailFrame.jsp?"+param,arguments,features);
				var par="";
				param+="&full_vacant="+obj.full_vacant.value;
				if(retVal1.charAt(0)=='1')
				{
					if(chkSize == '0' || chkSize == '1' || chkSize == '' || isNaN(chkSize))
						par = obj.param1.value;
					else if(chkSize == '2')
						par = parent.result0.document.getElementById("param1").value + "~" + parent.result1.document.getElementById("param1").value;
					else if(chkSize == '3')
						par = parent.result0.document.getElementById("param1").value + "~" + parent.result1.document.getElementById("param1").value + "~~" + parent.result2.document.getElementById("param1").value;
					if((obj.orderid!=null&&obj.orderid.value.length > 0) || (obj.booking_no!=null&&obj.booking_no.value.length >0))
						par=par+"&fun=1";	
					if(chkSize == '0' || chkSize == '' || isNaN(chkSize))//44391-Chaitanya
					{
						parent.qa_query_result.location.href="../../eOT/jsp/Schedule.jsp?"+par;
						parent.frames[0].ScheduleStatus.disabled=true;
						parent.frames[0].ScheduleStatusspan.disabled=true;
					}
					else if(chkSize == '1' || chkSize == '2' || chkSize == '3')
					{
						parent.parent.qa_query_result.location.href="../../eOT/jsp/ScheduleFrame.jsp?"+par;
						parent.parent.frames[0].ScheduleStatus.disabled=true;
						parent.parent.frames[0].ScheduleStatusspan.disabled=true;
					}
				}
			}
		}//Added  against Kauh SCF-0282
		}
	}
}

function getDurationForPendingorder(obj) //002495
{
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest() ;
	var xmlStr ="<root><SEARCH  /></root>";
	var param="func_mode=getDurnForPendOrder&order_id="+obj;
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST","../../eOT/jsp/OTCommonValidation.jsp?"+param,false);
	xmlHttp.send(xmlDoc);
	var duration = localTrimString(xmlHttp.responseText);	
	return duration;
}
</script>
</head>
<body OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()' >
<script type="text/javascript" src="../../eOT/js/wz_tooltip.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<form name='displayresults' id='displayresults'>
<%
	String sql = "";
	StringBuffer resultSql = new StringBuffer();
		resultSql.append("	SELECT   TO_CHAR (from_time, 'HH24:MI') from_time1,	");
		resultSql.append("	TO_CHAR (from_time, 'DD/MM/YYYY HH24:MI') from_time2,	");
		resultSql.append("	TO_CHAR (to_time, 'HH24:MI') to_time1, patient_id patient_id1,	");
		resultSql.append("	DECODE(?,'en',PATIENT_NAME,PATIENT_LOC_NAME) PATIENT_NAME1,	");
		resultSql.append("	(SELECT PRACTITIONER_NAME FROM AM_PRACTITIONER_LANG_vw WHERE PRACTITIONER_ID = SURGEON_CODE AND LANGUAGE_ID =?) SURGEON_LANG_NAME,	");
		resultSql.append("	(SELECT PRACTITIONER_NAME FROM AM_PRACTITIONER WHERE PRACTITIONER_ID = SURGEON_CODE) SURGEON_ENG_NAME,	");
		resultSql.append("	SPECIALITY_DESC SPECIALITY_DESC1,SPECIALITY_CODE  SPECIALITY_CODE1,BOOKING_NUM BOOKING_NUM1,	");
		resultSql.append("	OPER_DESC OPER_DESC1,MULTIPLE_OPERS_YN MULTIPLE_OPERS_YN1,STATUS STATUS1,TOOL_TIP_MSG TOOL_TIP_MSG1, "); //ML-MMOH-CRF-0337.1
		resultSql.append("	CASE WHEN (booking_date < TRUNC (SYSDATE) OR (booking_date = TRUNC (SYSDATE) AND "); //ML-MMOH-CRF-0337.1
		resultSql.append("	TO_CHAR (from_time, 'SSSSS') < TO_CHAR (SYSDATE,'SSSSS'))) THEN 0 ELSE 1 END slot_status "); //ML-MMOH-CRF-0337.1
		resultSql.append("	FROM OT_BOOKING_TIME_SLOTS_VW  A  	");
		resultSql.append("	WHERE OPERATING_FACILITY_ID=? AND OPER_ROOM_CODE=? AND NVL(LANGUAGE_ID,?) = ?	");
		resultSql.append("	AND (SELECT COUNT (*) slots FROM ot_diary_schedule WHERE operating_facility_id = ? AND oper_room_code = ? 	");

	if(!ammendFlag.equalsIgnoreCase("Y")){
		resultSql.append("	AND booking_date = TO_DATE (?, 'DD/MM/YYYY') AND team_doctor_code = ?) > 0 	");
	}else{
		resultSql.append("	AND booking_date = TO_DATE (?, 'DD/MM/YYYY') ) > 0 	");
	}

	resultSql.append("	AND BOOKING_DATE=TO_DATE(?,'DD/MM/YYYY') ORDER BY  to_date(to_char(FROM_TIME,'HH24:MI'),'HH24:MI')	");

	Connection conn=null;
	PreparedStatement pstmt=null;
	PreparedStatement pstmt1=null;
	ResultSet rs=null;
	ResultSet rs1=null;
%>

	<table class='grid' border="1" width="100%" cellspacing='0' cellpadding='3' id='results'>
	<tr style="position: sticky; top: 0; background-color: white; z-index: 1;">
		<th class='columnHeader' nowrap><fmt:message key="Common.fromtime.label" bundle="${common_labels}"/></th>
		<th class='columnHeader' nowrap><fmt:message key="Common.totime.label" bundle="${common_labels}"/></th>
		<th class='columnHeader' nowrap><fmt:message key="Common.patientId.label" bundle="${common_labels}"/></th>
		<th class='columnHeader' nowrap><fmt:message key="Common.PatientName.label" bundle="${common_labels}"/></th>
		<th class='columnHeader' nowrap><fmt:message key="Common.Surgeon.label" bundle="${common_labels}"/></th>
		<th class='columnHeader' nowrap><fmt:message key="eOT.Procedure(s).Label" bundle="${ot_labels}"/></th>
		<th class='columnHeader' nowrap><fmt:message key="Common.speciality.label" bundle="${common_labels}"/></th>		
	</tr>
<%
	String all_surgeons=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOT.AllSurgeons.label","ot_labels");
	String strBookingDate="";
	String strRoomCode="";
	String strFacilityId="";
	String strSurgeonName="";
	String strSurgeonCode="";
	String selSurgeonCode=""; // ML-BRU-SCF-1439 [051911]
	String strRoomDesc="";
	String strSpecialityCode="";
	String strSpecialityDesc="";
	String strSpecialityDesc1="";
	String strOrderId="";
	String strBookingNo="";
	String strTempBookNo="";
	String strOperDesc="";
	String strMultipleOperYN="";
	String fun="";
	String strFromTime="";
	String strToTime="";
	int islotstatus = 0;	//Added for ML-MMOH-CRF-0337.1
	String strPatientID="";
	String strSurgeon="";
	String strSpltycode="";
	String strSpltycodedesc="";
	String strName="";
	String strStatus="";
	String strQuery="";
	String org_pat_id="";
	String strProcname="";
	String startTime="";// 44528 - Chaitanya
	String endTime="";
	int fetchCount=0;
	String strFromHiddenTime="";
	String strToolTipMsg="";
	Date startTimeFormat = null;
	Date endTimeFormat = null;
	long timeDifference = 0;
	StringBuffer reason_title=new StringBuffer("");
	String called_from=checkForNull(request.getParameter("called_from"));
	String no_of_slots=checkForNull(request.getParameter("no_of_slots"));
	String chkSize = checkForNull(request.getParameter("chkSize"));
	boolean orderBookingFlag = false;
	reason_title=reason_title.append(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.reason.label","common_labels"));
	String todaysDate = com.ehis.util.DateUtils.getCurrentDate("dd/mm/yyyy", locale); //PMG2014-CRF-0024 US-3
	String patientId = checkForNull(request.getParameter("patientId")); //PMG2014-CRF-0024 US-3
	strBookingDate=request.getParameter("booking_date");
	strRoomCode=request.getParameter("roomCode");
	strOrderId=request.getParameter("orderid");
	String selOrderIds = checkForNull(request.getParameter("selOrderIds")); // ChAiTu - 186
	String selBookingNumber = checkForNull(request.getParameter("selBookingNumber")); // ChAiTu - 186
	strOrderId=strOrderId==null?"":strOrderId;
	fun=checkForNull(request.getParameter("fun"));
	strFacilityId=""+session.getValue("facility_id");
	String performing_facility_id = (String)session.getValue("performing_facility");
	//CRF-004 Authorize Slots for Booking - Rajesh V
	String fullVacant = checkForNull(request.getParameter("full_vacant"));
	//CRF-004 Authorize Slots for Booking - Rajesh V
	String fullVacantVal = checkForNull(request.getParameter("fullVacantVal"));

	if(performing_facility_id!=null && performing_facility_id.length()>0)
		strFacilityId = (String)session.getValue("performing_facility");
	
	strSurgeonName=checkForNull(request.getParameter("surgeonName"));
	strSurgeonCode=checkForNull(request.getParameter("surgeonCode"));
	selSurgeonCode = request.getParameter("selSurgeonCode");// ML-BRU-SCF-1439 [051911]
	System.err.println("404,Schedule.jsp==strSurgeonCode=="+strSurgeonCode+"==selSurgeonCode=="+selSurgeonCode);
	strRoomDesc=checkForNull(request.getParameter("roomDesc"));
	strSpecialityCode=checkForNull(request.getParameter("speciality_code"));
	strSpecialityDesc=checkForNull(request.getParameter("speciality_desc"));
	strBookingNo=checkForNull(request.getParameter("booking_no"));
	startTime=checkForNull(request.getParameter("startTime"));// 44528 - Chaitanya
	endTime=checkForNull(request.getParameter("endTime"));
	StringBuilder sbr_menu = new StringBuilder();	
	StringBuilder sbr_code = new StringBuilder();
	if(startTime!=null && startTime.trim().length() > 0 && endTime!=null && endTime.trim().length() > 0)// 44528 - Chaitanya - start
	{
		DateFormat timeFormat = new SimpleDateFormat("HH:mm");
		startTimeFormat = timeFormat.parse(startTime);
		endTimeFormat = timeFormat.parse(endTime);
		timeDifference = (endTimeFormat.getTime() - startTimeFormat.getTime())/1000/60;
	}// 44528 - Chaitanya - end
	strProcname=checkForNull(request.getParameter("procedure"));
	String function_id=request.getParameter("function_id");
	String customer_id1="";// Added for IN:41808
	String sql_sm_report="select customer_id from SM_SITE_PARAM where rownum = 1";
	conn = ConnectionManager.getConnection(request);
try
{	
	pstmt=conn.prepareStatement(sql_sm_report); // Added for IN:41808
	rs=pstmt.executeQuery();
	if(rs !=null && rs.next())
		customer_id1=checkForNull(rs.getString("customer_id"));
	if(rs!=null)rs.close();
	if(pstmt!=null)pstmt.close();// End for IN:41808
	

	pstmt = conn.prepareStatement(resultSql.toString());
	pstmt.setString(1,locale);	
	pstmt.setString(2,locale);	
	pstmt.setString(3,strFacilityId);
	pstmt.setString(4,strRoomCode);	
	pstmt.setString(5,locale);	
	pstmt.setString(6,locale);	
	pstmt.setString(7,strFacilityId);
	pstmt.setString(8,strRoomCode);
	pstmt.setString(9,strBookingDate);
	if(ammendFlag.equalsIgnoreCase("Y")){
		//pstmt.setString(10,"*All");
		pstmt.setString(10,strBookingDate);
		//pstmt.setString(10,strSurgeonCode);
	}else{
		pstmt.setString(10,strSurgeonCode);
		pstmt.setString(11,strBookingDate);	
	}
	//pstmt.setString(11,strBookingDate);
	rs=pstmt.executeQuery();
	fetchCount=0;

	sql=""+OTRepository.getOTKeyValue("SQL_OT_SCHEDULE_SELECT2");
	pstmt1=conn.prepareStatement(sql);
	if(rs.isBeforeFirst())
	{
	while(rs.next())
	{
		fetchCount++;
		sbr_menu.delete(0, sbr_menu.length()); // Added for IN:045530
		sbr_code.delete(0, sbr_code.length()); 
		strFromTime=checkForNull(rs.getString("FROM_TIME1"));	
		strFromHiddenTime=rs.getString("FROM_TIME2");
		strToTime=checkForNull(rs.getString("TO_TIME1"));
		islotstatus=rs.getInt("SLOT_STATUS");	//Added for ML-MMOH-CRF-0337.1
		strPatientID=checkForNull(rs.getString("PATIENT_ID1"));
		strName=checkForNull(rs.getString("PATIENT_NAME1"));
		if(locale.equals("en"))
			strSurgeon=checkForNull(rs.getString("SURGEON_ENG_NAME"));
		else
		{
			strSurgeon=checkForNull(rs.getString("SURGEON_LANG_NAME"));
			if(strSurgeon.equals(""))
				strSurgeon=checkForNull(rs.getString("SURGEON_ENG_NAME"));
		}
		if(strSurgeon.equals("") && locale.equals("en") && !strName.equals(""))
			strSurgeon=all_surgeons;	
		else if(strSurgeon.equals("") && !locale.equals("en")&& !strName.equals(""))
			strSurgeon=all_surgeons;	
			strOperDesc=checkForNull(rs.getString("OPER_DESC1"));
			strMultipleOperYN=checkForNull(rs.getString("MULTIPLE_OPERS_YN1"));
			strStatus=checkForNull(rs.getString("STATUS1"));			
			strToolTipMsg=checkForNull(rs.getString("TOOL_TIP_MSG1"));
			strSpltycode=checkForNull(rs.getString("SPECIALITY_CODE1"));
			strSpltycodedesc=checkForNull(rs.getString("SPECIALITY_DESC1"));

		if(fetchCount%2==0)
			strQuery="class='gridData'";
		else
			strQuery="class='gridData'";

		if(strStatus.equals("30")==false && strPatientID.length()==0&&fun.length()==0)
		{
				out.println("<input type='hidden' name='splty"+fetchCount+"' id='splty"+fetchCount+"' value=\""+strSpecialityDesc+"\" >"); 
				out.println("<tr >  <td width=6%  "+strQuery+" >");
			if(no_of_slots.equals("0"))
				out.println(strFromTime+"  </td>");
			else
			if(islotstatus == 0)	// Added for ML-MMOH-CRF-0337.1
				out.println(strFromTime+"  </td>");
			else
				out.println("<a class='gridLink' href=\" javascript:showBookingDialog1('"+strSpltycode+"','"+strSpltycodedesc+"','"+strFromTime+"','"+strFromHiddenTime+"','"+strSpecialityCode+"',"+fetchCount+");\">"+strFromTime+"</a></td>");
		}
		else
		{
			out.println("<tr>  ");
			if(strStatus.equals("30"))
			{
				strTempBookNo=reason_title.append(",").toString();
				strTempBookNo+=strToolTipMsg;
				out.println("<input type='hidden' name='reasonX"+fetchCount+"' id='reasonX"+fetchCount+"' value=\""+strTempBookNo+"\" >"); 				
				//out.println("<td width=6%  "+strQuery+" OnMouseOver=\"reasonToolTipBlockSlotReason('reasonX',"+fetchCount+")\"  //onMouseOut='hideToolTip();'\" > <font color='RED' >" +strFromTime+"</font></td>");
				out.println("<td width=6%  "+strQuery+" OnMouseOver=\"Tip(reasonToolTipBlockSlotReason('reasonX',"+fetchCount+"))\"  onMouseOut='UnTip();'\" > <font color='RED' >" +strFromTime+"</font></td>");//58860
			}
			else
			{					
				orderBookingFlag = true;//186 && added below against  for IN 57507
				//if((strPatientID != null && patientId != null) && (strPatientID.equals(patientId) && strPatientID.contains("********")))
				if((strPatientID != null && patientId != null) && (strPatientID.equals(patientId))) //&& strPatientID.contains("**********")))
				{
					// Added / Modified for ML-MMOH-CRF-0337.1 Start
					out.println("<input type='hidden' name='splty"+fetchCount+"' id='splty"+fetchCount+"' value=\""+strSpecialityDesc+"\" >");
					out.println("<tr >  <td width=6%  "+strQuery+" >");
					if(islotstatus == 0)
						out.println(strFromTime+"  </td>");
					else
						out.println("<a class='gridLink' href=\" javascript:showBookingDialog1('"+strSpltycode+"','"+strSpltycodedesc+"','"+strFromTime+"','"+strFromHiddenTime+"','"+strSpecialityCode+"',"+fetchCount+");\">"+strFromTime+"</a></td>");
					// Added/Modified for ML-MMOH-CRF-0337.1 End
				}
				else
					out.println("<td width=6%  "+strQuery+"> "+strFromTime+"  </td>");	
					out.println("<input type='hidden' name='orderBookingFlag"+fetchCount+"' id='orderBookingFlag"+fetchCount+"' value='"+orderBookingFlag+"'/>");
			}
		}
			out.println(" <td width=6%  "+strQuery+">");
		if(strStatus.equals("30")==true) 
			out.println("<font color='RED'>" +strToTime+"</font></td>");
		else
			out.println(""+strToTime+"</td>");	
			strSpecialityDesc1=checkForNull(rs.getString("SPECIALITY_DESC1"));	//strSpecialityCode1=checkForNull(rs.getString("SPECIALITY_CODE1"));
			strTempBookNo=checkForNull(rs.getString("BOOKING_NUM1"));

		if(strPatientID.length()>0)
		{			
			if(!strPatientID.startsWith("*") && customer_id1.equalsIgnoreCase("RTN") )
			{
				org_pat_id = strPatientID;
				sbr_menu.append(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOT.ViewBookingDetails.Label","ot_labels"));
				sbr_menu.append(",");
				sbr_menu.append(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOT.OperSiteIdentify.Label","ot_labels"));
				sbr_code.append("RS1");
				sbr_code.append(",");
				sbr_code.append("BQ7");
				out.println("<td width='' nowrap id='orderctl"+fetchCount+"' style='cursor:pointer' class='gridDataBlue'  onClick=\"commonDisplayTooltip('"+sbr_code+"','"+sbr_menu+"','"+strTempBookNo+","+strFacilityId+","+strPatientID+","+strOrderId+","+org_pat_id+"',this,'imgArrow"+fetchCount+"');\"  width='10%'  '><a class='gridDataBlue' href=\"javascript:commonDisplayTooltip('"+sbr_code+"','"+sbr_menu+"','"+strTempBookNo+","+strFacilityId+","+strPatientID+","+strOrderId+","+org_pat_id+"',this,'imgArrow"+fetchCount+"');\">"+strPatientID+"<img align='right' src='../../eCommon/images/inactiveArrow.gif' name='imgArrow"+fetchCount+"'></td>"); 			
			}
			else if(!strPatientID.startsWith("*"))
			{
				org_pat_id = strPatientID;
				String bookingDetails_title=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOT.ViewBookingDetails.Label","ot_labels");				
				out.println("<td width='' nowrap id='orderctl"+fetchCount+"' style='cursor:pointer' class='gridDataBlue'  onClick=\"commonDisplayTooltip('RS1','"+bookingDetails_title+"','"+strTempBookNo+","+strFacilityId+","+strPatientID+","+strOrderId+","+org_pat_id+"',this,'imgArrow"+fetchCount+"');\"  width='10%'  '><a class='gridDataBlue' href=\"javascript:commonDisplayTooltip('RS1','"+bookingDetails_title+"','"+strTempBookNo+","+strFacilityId+","+strPatientID+","+strOrderId+","+org_pat_id+"',this,'imgArrow"+fetchCount+"');\">"+strPatientID+"<img align='right' src='../../eCommon/images/inactiveArrow.gif' name='imgArrow"+fetchCount+"'></td>"); 					
			}
			else
			{
				org_pat_id = strPatientID;
				String bookingDetails_title=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOT.ViewBookingDetails.Label","ot_labels");
				out.println("<td width='' nowrap id='orderctl"+fetchCount+"' style='cursor:pointer' class='gridDataBlue'  onClick=\"commonDisplayTooltip('RS1','"+bookingDetails_title+"','"+strTempBookNo+","+strFacilityId+","+strPatientID+","+strOrderId+","+org_pat_id+"',this,'imgArrow"+fetchCount+"');\"  width='10%'  '><a class='gridDataBlue' href=\"javascript:commonDisplayTooltip('RS1','"+bookingDetails_title+"','"+strTempBookNo+","+strFacilityId+","+strPatientID+","+strOrderId+","+org_pat_id+"',this,'imgArrow"+fetchCount+"');\">"+strPatientID+"<img align='right' src='../../eCommon/images/inactiveArrow.gif' name='imgArrow"+fetchCount+"'></td>");
			}
		} 
		else
			out.println("<td width=10%  "+strQuery+">"+strPatientID+"</td>");	
			out.println("<td width=20%  "+strQuery+">"+strName+"</td>");	
			out.println("<td width=20%  "+strQuery+">"+strSurgeon+"</td>");	
		//	strMultipleOperYN = "Y";//186
		if(strMultipleOperYN.equals("Y"))		
		{
			pstmt1.setString(1,locale);
			pstmt1.setString(2,strTempBookNo);
			pstmt1.setString(3,strFacilityId);//KDAH-SCF-0520
			rs1=pstmt1.executeQuery();
			strTempBookNo=strTempBookNo+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOT.OperationsProcedures.Label","ot_labels")+",";
			while(rs1.next())
			{
				strTempBookNo=strTempBookNo+rs1.getString(1)+",";
			}
			rs1.close();
			out.println("<input type='hidden' name='reason"+fetchCount+"' id='reason"+fetchCount+"' value=\""+strTempBookNo+"\" >"); 
			out.println("<td width=20%  "+strQuery+" OnMouseOver=\"Tip(reasonToolTip('reason','"+fetchCount+"'))\"  onMouseOut='UnTip();'><font color='BLUE' >"+strOperDesc+"</font></td>");							
		}//ML-MMOH-SCF-0387 [IN:060022] 
		else
			out.println("<td width=20%  "+strQuery+">"+strOperDesc+"</td>");	
			out.println("<td width=20%  "+strQuery+">"+strSpecialityDesc1+"</td></tr>");	
	}
	}
	else
	{
		out.println("</table><table style='margin-top:230px'><tr><td valign=bottom align=right class='gridData' nowrap>");
		out.println("For the selected date Schedule is not available</td></tr>");
	}
	pstmt.close();
}
catch(Exception ee)
{
	//System.err.println("Error in Schedule.jsp====>>"+ee);
	ee.printStackTrace();
}
finally
{
	if(rs!=null)
		rs.close();
	if(pstmt1!=null)
		pstmt1.close();
	if(pstmt!=null)
		pstmt.close(); 
	if(conn!=null)
		conn.close();
}
%>
</table>

<input type="hidden" name="booking_date" id="booking_date" id="bookingDate" value="<%=strBookingDate%>">
<input type="hidden" name="roomCode" id="roomCode" value="<%=strRoomCode%>">
<input type="hidden" name="surgeonName" id="surgeonName" value="<%=strSurgeonName%>">
<input type="hidden" name="surgeonCode" id="surgeonCode" value="<%=strSurgeonCode%>">
<input type="hidden" name="roomDesc" id="roomDesc" value="<%=strRoomDesc%>">
<input type="hidden" name="speciality_code" id="speciality_code" value="<%=strSpecialityCode%>">
<input type="hidden" name="speciality_desc" id="speciality_desc" value="<%=strSpecialityDesc%>">
<input type="hidden" name="param1" id="param1" id="param1" value="<%=request.getQueryString()%>">
<input type="hidden" name="orderid" id="orderid" value="<%=strOrderId%>">
<input type='hidden' name='selOrderIds' id='selOrderIds' id='selOrderIds' value='<%=selOrderIds%>'> <%-- ChAiTu - 186 --%>
<input type='hidden' name='selBookingNumber' id='selBookingNumber' id='selBookingNumber' value='<%=selBookingNumber%>'> <%-- ChAiTu - 186 --%>
<input type="hidden" name="booking_no" id="booking_no" value="<%=strBookingNo%>">
<input type='hidden' name='startTime' id='startTime' value='<%=startTime%>'> <!-- 44528 - Chaitanya -->
<input type='hidden' name='endTime' id='endTime' value='<%=endTime%>'>
<input type="hidden" name="facility_id" id="facility_id" id="facilityId" value="<%=strFacilityId%>">
<input type="hidden" name="patientId" id="patientId" id="patientId" value="<%=patientId%>">
<input type='hidden' name='locale' id='locale' value="<%=locale%>">
<input type='hidden' name='called_from' id='called_from' value="<%=called_from%>">
<input type='hidden' name='end_time' id='end_time' value="<%=strToTime%>">
<input type='hidden' name='timeDifference' id='timeDifference' value="<%=timeDifference%>"> <!-- 44528 - Chaitanya -->
<input type='hidden' name='procedure' id='procedure' value="<%=strProcname%>">
<input type='hidden' name='function_id' id='function_id' value="<%=function_id%>">
<input type='hidden' name='chkSize' id='chkSize' value="<%=chkSize%>">
<input type='hidden' name='fpp_category' id='fpp_category' value="<%=fpp_category%>">	<!--ML-MMOH-CRF-1939-US005-->
<input type='hidden' name='selSurgeonCode' id='selSurgeonCode' value="<%=selSurgeonCode%>"> <!-- ML-BRU-SCF-1439 [051911] -->
<!-- CRF-004 Authorize Slots for Booking - Rajesh V -->
<input type='hidden' name='full_vacant' id='full_vacant' value="<%=fullVacant%>">
<input type="hidden" name="todaysDate" id="todaysDate" id="todaysDate" value="<%=todaysDate%>">
<input type="hidden" name="ammendFlag" id="ammendFlag" id="ammendFlag" value="<%=ammendFlag%>">
<!-- CRF-004 Authorize Slots for Booking - Rajesh V -->
<input type="hidden" name="customer_id1" id="customer_id1" id="customer_id1" value="<%=customer_id1%>"><!--Added Against KAUH-SCF-0282-->
</form>
 	<div name='tooltiplayer' id='tooltiplayer' style='position:absolute; width:30%; visibility:hidden;' bgcolor='blue'>	
	</div>
</body>
</html>

