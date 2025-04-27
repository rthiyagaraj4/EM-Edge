<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%@page  import ="java.util.StringTokenizer,java.util.HashMap,java.sql.Connection,java.sql.PreparedStatement,java.sql.CallableStatement,java.sql.ResultSet,webbeans.eCommon.ConnectionManager,eOT.Common.OTRepository,java.sql.Types,java.util.Date,java.util.Calendar,java.text.*,java.util.*,webbeans.eCommon.*,eCommon.XSSRequestWrapper,eCommon.Common.*" %>
<%@page  contentType="text/html; charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp" %>
<% 
	request.setCharacterEncoding("UTF-8");
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");
	String locale = (String)session.getAttribute("LOCALE");
	String facility_id = (String) session.getValue("facility_id");	
	/*//Added by lakshmi against change in performing_facility starts here
	String performing_facility_id = (String)session.getValue("performing_facility");
	if(performing_facility_id!=null && performing_facility_id.length()>0)
	facility_id = (String)session.getValue("performing_facility");
	//Added by lakshmi against change in performing_facility ends here */
	%>
<%@include file="../../eOT/jsp/StringUtil.jsp"%>
<html>
<head>
	<%
	String sStyle =	(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
	<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
	<script src='../../eCommon/js/common.js' language='javascript'></script>
	<Script src="../../eOA/js/Validate.js" language="JavaScript"></Script>
	<Script src="../../eOA/js/Validate1.js" language="JavaScript"></Script>
	<script language="Javascript" src="../../eCommon/js/DateUtils.js"></script>
	<script language="Javascript" src="../../eOT/js/OTCommon.js"></script>
	<script language="Javascript" src="../../eOT/js/Booking.js"></script>
	<!--337-->
	<style type="text/css">
		.menu {text-align:left;position:absolute;width:400px;}
		.menu1 {text-align:left;position:absolute;width:860px;}
	</style>
<script>
function scrollTitle()
{
		var tab1=document.getElementById("divTitleTable1");
		var tab2=document.getElementById("divTitleTable");
		var tab3=document.getElementById("divTitleTable23");
		var widthValue=400;
		var x = document.body.scrollLeft;
		var y = document.body.scrollTop;
		if(x > 0)
		{
			tab1.style.left=(x-4)+"px";
			tab3.style.left=(x-4)+"px";
		}
		else
		{
			tab1.style.left="0px";
			tab3.style.left="0px";
			x=0;
		}
		if(y > 0)
		{
			tab1.style.top=(y-4)+"px";
			tab2.style.top=(y-4)+"px";
		}
		else
		{
			tab1.style.top="4px";
			tab2.style.top="4px";
			y=4;
		}
	}

async function chkPermSlotsBooking(bookingDate,operRoom,doctorCode,specialityCode,totalDuration)
{
		var customerId = document.forms[0].customerId.value;
		if(customerId == 'MOHBR') //IN050472
		{
		var authFlag = false;//002495
		var xmlDoc = "" ;
		var xmlHttp = new XMLHttpRequest() ;
		var xmlStr ="<root><SEARCH  /></root>";
		var param="func_mode=chkPermSlots&booking_date="+bookingDate+"&doctor_code="+doctorCode+"&oper_room="+operRoom+"&speciality_code="+specialityCode+"&total_dur="+totalDuration;
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open("POST","../../eOT/jsp/OTCommonValidation.jsp?"+param,false);
		xmlHttp.send(xmlDoc);
		var role_type = localTrimString(xmlHttp.responseText);	
		if(role_type == 'NO')
		{
			var confirmBox = confirm(getMessage("APP-OT0199","OT"));
			if(confirmBox)
			{
				var url		= "../../eOT/jsp/AuthenticateBookingUsers.jsp?&oper_room="+operRoom+"&doctor_code="+doctorCode; ;
				var dialogHeight	= "11" ;
				var dialogWidth	= "25" ;
				var arguments	= "" ;
				var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; status:no" ;
				var reportURL 	= await window.showModalDialog( url, arguments, features ) ;
				if(reportURL=='YES')
				{
					role_type = 'YES';
					authFlag = true;//002495
					}
				}
			}
			return (role_type + "~" + authFlag);
		}
		else //IN050472
			return ("YES~true");
}
	
function chkPermSlotsBookingAuthent(bookingDate,operRoom,doctorCode,specialityCode,totalDuration)
{
		var xmlDoc = "" ;
		var xmlHttp = new XMLHttpRequest() ;
		var xmlStr ="<root><SEARCH  /></root>";
		var param="func_mode=chkPermSlots&booking_date="+bookingDate+"&doctor_code="+doctorCode+"&oper_room="+operRoom+"&speciality_code="+specialityCode+"&total_dur="+totalDuration;
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open("POST","../../eOT/jsp/OTCommonValidation.jsp?"+param,false);
		xmlHttp.send(xmlDoc);
		var role_type = localTrimString(xmlHttp.responseText);
		return role_type;
}
	
//CRF-004.1 - 36448
function chkPermSlotsBooking1(bookingDate,operRoom,doctorCode,specialityCode,totalDuration)
{
		var xmlDoc = "" ;
		var xmlHttp = new XMLHttpRequest() ;
		var xmlStr ="<root><SEARCH  /></root>";
		var param="func_mode=chkPermSlots&booking_date="+bookingDate+"&doctor_code="+doctorCode+"&oper_room="+operRoom+"&speciality_code="+specialityCode+"&total_dur="+totalDuration;
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open("POST","../../eOT/jsp/OTCommonValidation.jsp?"+param,false);
		xmlHttp.send(xmlDoc);
		var role_type = localTrimString(xmlHttp.responseText);	
 		return role_type;
}
//CRF-004.1 - 36448 
function localTrimString(sInString) 
{
		  return sInString.replace(/^\s+|\s+$/g,"");
}

function getDurationForPendingorder(obj)
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
//CRF-004 Authorize Slots for Booking - Rajesh V

function assign()
{
		var tab1=document.getElementById("divTitleTable1");
		var tab2=document.getElementById("divTitleTable");
		var tab3=document.getElementById("divTitleTable23");
		var topValue=4;
//		var widthValue=400;
		var widthValue=380;
		tab1.style.top=topValue+"px";
		tab1.style.left="0px";
		tab1.style.width=widthValue+"px";
		tab1.style.visibility='visible';
		tab2.style.top="4px";
		tab2.style.left=widthValue+"px";
		tab2.style.width="713px";
		tab2.style.visibility='visible';
		tab3.style.top="65px";
		tab3.style.left="0px";
		tab3.style.width=widthValue+"px";
		tab3.style.visibility='visible';
		tab3.style.position='absolute';
}
	
function checkBoxMaxSelect(fetchCount)
{
		var total = 0;
		var max = document.forms[0].fetchCount.value;
		for (var idx = 0; idx < max; idx++)
		{
			if (eval("document.forms[0].check"+idx+".checked") == true)
			{
				total = total+1;
				if(total > 3)
				{
					eval("document.forms[0].check"+fetchCount).checked = false;
					alert(getMessage('PRACT_SELECT_VALIDATION','OA'));
				}
			}
		}
}

function moveNext(boDate,obDM,full_vacant, cellPos)
{
		var cellPosLst = cellPos.substring(cellPos.indexOf("_")+1, cellPos.length);
		var max = document.forms[0].fetchCount.value;
		var patientId = document.forms[0].patientId.value; //PMG2014-CRF-0024 U-3
		var retArray = new Array();//002495
		var customerId = document.forms[0].customerId.value;
		if(max == null) 
			max = 1;
		var retVal = trimString(validateElectiveCutOffTime(boDate));
		var overBookingWindowYN = document.forms[0].overBookingWindowYN.value;
		var authFlag = false;
		var fullVacantVal = '';
		if(retVal.length>1)
		{
			var msg = getMessage("APP-OT0124","OT");
			alert(msg);
		}
		else
		{
			var f = new Array();
			if(customerId != 'KDAH')
			{
				var j = 0;
				for (var idx = 0; idx < max; idx++)
				{
					if (eval("document.forms[0].check"+idx+".checked"))
					{
						
						if (eval("document.forms[0].check"+idx+".checked") == true)
						{
							
							f[j] = idx;
							j++;
						}
					}
				}
			}
			
			if(f.length > 1)
			{
				for (var z = 0; z < f.length; z++)
				{
					var obj = document.forms[0];
					fullVacantVal = '';
					var roomCode;
					var surgeonCode;
					var objS = eval("document.forms[0].xx"+f[z]+"");
					var totalDurPend = 0;
					var speciality_code='';
					
					if(objS != null)
					{
						roomCode = objS.getAttribute('OperRoomCode');
						surgeonCode = objS.getAttribute('SurgeonCode');
					}
					
					if(obj.Speciality_Code.value != null && obj.Speciality_Code.value != '')
						speciality_code=obj.Speciality_Code.value;
						if(document.getElementById("fullVacantVal"+f[z]+'_'+cellPosLst) != null)
							fullVacantVal = document.getElementById("fullVacantVal"+f[z]+'_'+cellPosLst).value;
					var otParam = obj.ot_Param.value;
					var orderIdVal = obj.orderid.value;
					if(fullVacantVal == 'VAC')
					{
						if(otParam == 'Y' || otParam=='y')
						{
							if(orderIdVal.length > 1)
								totalDurPend = getDurationForPendingorder(orderIdVal);
							var ret = chkPermSlotsBookingAuthent(boDate, roomCode, surgeonCode, speciality_code, 0);//002495
							if(ret == 'NO')
								authFlag = true;
						}
					}
				}
			}
			
			if(authFlag)
			{
				for(var a = 0; a < f.length; a++)
					eval("document.forms[0].check"+f[a]).checked = false;
				alert(getMessage("APP-OT0218","OT"));
			}
			else
			{
				if(f.length == 0)
				{
					var obj = document.forms[0];
					var objS = eval("document.forms[0]."+obDM);
					var speciality_code='';
					var speciality_desc='';
					var called_from=obj.called_from.value;
					var function_id=obj.function_id.value;
					var roomCode=objS.getAttribute('OperRoomCode');
					var roomDesc=objS.getAttribute('OperRoomDesc');
					var surgeonCode=objS.getAttribute('SurgeonCode');
					var selSurgeonCode = obj.selSurgeonCode.value;// 051911
					if(selSurgeonCode != '')
					{
						if(selSurgeonCode == '*ALL' && surgeonCode == '*ALL')
							selSurgeonCode = surgeonCode;
						else if(selSurgeonCode == '*ALL' && surgeonCode != '*ALL')
							selSurgeonCode = surgeonCode;
						else if(selSurgeonCode != '*ALL' && surgeonCode != '*ALL')
							selSurgeonCode = surgeonCode;
					}
					else
						selSurgeonCode = surgeonCode;
					//051911
					var surgeonName=objS.getAttribute('SurgeonName');
					var procedure=obj.procedure_hdn.value;
					if(obj.Speciality_Code.value!=null&&obj.Speciality_Code.value!='')
						speciality_code=obj.Speciality_Code.value;
					if(obj.Speciality_Desc.value!=null&&obj.Speciality_Desc.value!='')
						speciality_desc=obj.Speciality_Desc.value;

					//CRF-004 Authorize Slots for Booking - Rajesh V
					var otParam = obj.ot_Param.value;
					var orderIdVal = obj.orderid.value;
					var totalDurPend = 0;
					if(full_vacant == 'VACANT')
					{
						if(otParam == 'Y' || otParam=='y')
						{
							if(orderIdVal.length > 1)
								totalDurPend = getDurationForPendingorder(orderIdVal);
							//002495
							var ret = chkPermSlotsBooking(boDate,roomCode,surgeonCode,speciality_code,0);
							retArray = ret.split("~");
							ret = retArray[0];
							//002495
							if(ret=='NO')
								return;
						}
					}
					//CRF-004 Authorize Slots for Booking - Rajesh V
					var param = "booking_date="+boDate+
								"&roomCode="+roomCode+
								"&roomDesc="+roomDesc+
								"&surgeonCode="+surgeonCode+
								"&surgeonName="+encodeURIComponent(surgeonName)+//IN055121
								"&speciality_code="+speciality_code+
								"&speciality_desc="+speciality_desc+
								"&orderid="+obj.orderid.value+
					"&selOrderIds="+obj.selOrderIds.value+
								"&booking_no="+obj.booking_no.value+
								"&startTime="+obj.startTime.value+// 44528 - Chaitanya
								"&endTime="+obj.endTime.value+
								"&called_from="+obj.called_from.value+
								"&fpp_category="+obj.fpp_category.value+ //ML-MMOH-CRF-1939-US005
								"&procedure="+procedure+
								"&function_id="+function_id+
								"&authFlag="+retArray[1]+//002495
								"&overBookingWindowYN="+overBookingWindowYN+
								"&patientId="+patientId+ //PMG2014-CRF-0024 U-3
								"&selSurgeonCode="+selSurgeonCode+// 051911
								"&full_vacant="+full_vacant;

					if(full_vacant=="VACANT" || full_vacant=="FULL_OVER_BOOKING_NO")
					{
						parent.parent.f_query_add_mod.location.href="../../eOT/jsp/ScheduleHdr.jsp?"+param;
						parent.parent.frames[0].changeTab("DaySchedule");
						parent.parent.qa_query_result.location.href="../../eOT/jsp/Schedule.jsp?"+param;
						parent.parent.qa_query_result_tail.location.href="../../eOT/jsp/TailScheduleLegend.jsp?"+param;
					}
					else if(full_vacant=="FULL_OVER_BOOKING_YES")
						{
						if(selSurgeonCode != null){
							surgeonCode = selSurgeonCode; // for SCF-1640						
						}
						showBookingDialog1(speciality_code,speciality_desc,surgeonCode,surgeonName,roomCode,roomDesc,boDate,full_vacant,obj.called_from.value);
						}
				}
				else if(f.length == 1)
				{
					var param = '';
					var param0 = '';
					var fullVacantVal0 = '';
					var obj = document.forms[0];
					var called_from = obj.called_from.value;
					var function_id = obj.function_id.value;
					var speciality_code = '';
					var speciality_desc = '';
					var procedure = obj.procedure_hdn.value;
					if(obj.Speciality_Code.value != null && obj.Speciality_Code.value != '')
						speciality_code = obj.Speciality_Code.value;
					if(obj.Speciality_Desc.value != null && obj.Speciality_Desc.value != '')
						speciality_desc = obj.Speciality_Desc.value;
					var otParam = obj.ot_Param.value;
					var orderIdVal = obj.orderid.value;
					var objS0 = eval("document.forms[0].xx"+f[0]+"");
					var roomCode0 = objS0.getAttribute('OperRoomCode');
					var roomDesc0 = objS0.getAttribute('OperRoomDesc');
					var surgeonCode0 = objS0.getAttribute('SurgeonCode');
					// start MMS-SCF-0431 [051825]
					var selSurgeonCode = obj.selSurgeonCode.value;
					if(selSurgeonCode != '')
					{
						if(selSurgeonCode == '*ALL' && surgeonCode0 == '*ALL')
							selSurgeonCode = surgeonCode0;
						else if(selSurgeonCode == '*ALL' && surgeonCode0 != '*ALL')
							selSurgeonCode = surgeonCode0;
						else if(selSurgeonCode != '*ALL' && surgeonCode0 != '*ALL')
							selSurgeonCode = surgeonCode0;
					}
					else
						selSurgeonCode = surgeonCode0;
					// end MMS-SCF-0431 [051825]

					var surgeonName0 = objS0.getAttribute('SurgeonName');
					var totalDurPend = 0;
					var ret;
					if(document.getElementById("fullVacantVal"+f[0]+'_'+cellPosLst) != null)
						fullVacantVal0 = document.getElementById("fullVacantVal"+f[0]+'_'+cellPosLst).value;
					
					if(full_vacant == 'VACANT')
					{
						if(otParam == 'Y' || otParam=='y')
						{
							if(orderIdVal.length > 1)
								totalDurPend = getDurationForPendingorder(orderIdVal);
							//002495
							ret = chkPermSlotsBooking(boDate, roomCode0, surgeonCode0, speciality_code, 0);
							retArray = ret.split("~");
							ret = retArray[0];
							//002495
							if(ret=='NO')
								return;
						}
					}
					param0 = "booking_date="+boDate+
									"&roomCode="+roomCode0+
									"&roomDesc="+roomDesc0+
									"&surgeonCode="+surgeonCode0+
									"&surgeonName="+encodeURIComponent(surgeonName0)+//IN055121
									"&speciality_code="+speciality_code+
									"&speciality_desc="+speciality_desc+
									"&orderid="+obj.orderid.value+
					"&selOrderIds="+obj.selOrderIds.value+
					"&fpp_category="+obj.fpp_category.value+ //ML-MMOH-CRF-1939-US005
									"&booking_no="+obj.booking_no.value+
									"&startTime="+obj.startTime.value+// 44528 - Chaitanya
									"&endTime="+obj.endTime.value+
									"&called_from="+obj.called_from.value+
									"&overBookingWindowYN="+overBookingWindowYN+
									"&patientId="+patientId+ //PMG2014-CRF-0024  U-3
									"&procedure="+procedure+
									"&function_id="+function_id+
									"&authFlag="+retArray[1]+//002495
									"&chkSize=1"+
									"&frameNmbr=0"+
									"&fullVacantVal="+fullVacantVal0+
									"&selSurgeonCode="+selSurgeonCode+// MMS-SCF-0431 [051825]
									"&full_vacant="+full_vacant;
					param = param0;
						parent.parent.f_query_add_mod.location.href="../../eOT/jsp/ScheduleHdrFrame.jsp?"+param;
						parent.parent.frames[0].changeTab("DaySchedule");
						parent.parent.qa_query_result.location.href="../../eOT/jsp/ScheduleFrame.jsp?"+param;
						parent.parent.qa_query_result_tail.location.href="../../eOT/jsp/TailScheduleLegendFrame.jsp?"+param;
				}
			else if(f.length == 2)
			{
				var param = '';
				var param0 = '';
				var param1 = '';
				var fullVacantVal0 = '';
				var fullVacantVal1 = '';
				var obj = document.forms[0];
				var called_from = obj.called_from.value;
				var function_id = obj.function_id.value;
				var speciality_code = '';
				var speciality_desc = '';
				var procedure = obj.procedure_hdn.value;
				if(obj.Speciality_Code.value != null && obj.Speciality_Code.value != '')
					speciality_code = obj.Speciality_Code.value;
				if(obj.Speciality_Desc.value != null && obj.Speciality_Desc.value != '')
					speciality_desc = obj.Speciality_Desc.value;
				var otParam = obj.ot_Param.value;
				var orderIdVal = obj.orderid.value;
				var objS0 = eval("document.forms[0].xx"+f[0]+"");
				var objS1 = eval("document.forms[0].xx"+f[1]+"");
				var roomCode0 = objS0.getAttribute('OperRoomCode');
				var roomDesc0 = objS0.getAttribute('OperRoomDesc');
				var surgeonCode0 = objS0.getAttribute('SurgeonCode');

					// start MMS-SCF-0431 [051825]
					var selSurgeonCode0 = obj.selSurgeonCode.value;
					if(selSurgeonCode0 != '')
					{
						if(selSurgeonCode0 == '*ALL' && surgeonCode0 == '*ALL')
							selSurgeonCode0 = surgeonCode0;
						else if(selSurgeonCode0 == '*ALL' && surgeonCode0 != '*ALL')
							selSurgeonCode0 = surgeonCode0;
						else if(selSurgeonCode0 != '*ALL' && surgeonCode0 != '*ALL')
							selSurgeonCode0 = surgeonCode0;
					}
					else
						selSurgeonCode0 = surgeonCode0;
					// end MMS-SCF-0431 [051825]

				var surgeonName0 = objS0.getAttribute('SurgeonName');
				var roomCode1 = objS1.getAttribute('OperRoomCode');
				var roomDesc1 = objS1.getAttribute('OperRoomDesc');
				var surgeonCode1 = objS1.getAttribute('SurgeonCode');

					// start MMS-SCF-0431 [051825]
					var selSurgeonCode1 = obj.selSurgeonCode.value;
					if(selSurgeonCode1 != '')
					{
						if(selSurgeonCode1 == '*ALL' && surgeonCode1 == '*ALL')
							selSurgeonCode1 = surgeonCode1;
						else if(selSurgeonCode1 == '*ALL' && surgeonCode1 != '*ALL')
							selSurgeonCode1 = surgeonCode1;
						else if(selSurgeonCode1 != '*ALL' && surgeonCode1 != '*ALL')
							selSurgeonCode1 = surgeonCode1;
					}
					else
						selSurgeonCode1 = surgeonCode1;
					// end MMS-SCF-0431 [051825]

				var surgeonName1 = objS1.getAttribute('SurgeonName');
				var totalDurPend = 0;
				var ret;
				if(document.getElementById("fullVacantVal"+f[0]+'_'+cellPosLst) != null)
					fullVacantVal0 = document.getElementById("fullVacantVal"+f[0]+'_'+cellPosLst).value;
				if(document.getElementById("fullVacantVal"+f[1]+'_'+cellPosLst) != null)
					fullVacantVal1 = document.getElementById("fullVacantVal"+f[1]+'_'+cellPosLst).value;
				param0 = "booking_date="+boDate+
								"&roomCode="+roomCode0+
								"&roomDesc="+roomDesc0+
								"&surgeonCode="+surgeonCode0+
								"&surgeonName="+encodeURIComponent(surgeonName0)+//IN055121
								"&speciality_code="+speciality_code+
								"&speciality_desc="+speciality_desc+
								"&orderid="+obj.orderid.value+
					"&selOrderIds="+obj.selOrderIds.value+
								"&booking_no="+obj.booking_no.value+
								"&startTime="+obj.startTime.value+// 44528 - Chaitanya
								"&endTime="+obj.endTime.value+
								"&called_from="+obj.called_from.value+
								"&fpp_category="+obj.fpp_category.value+ //Added By Gaurav Against ML-MMOH-SCF-2511
								"&procedure="+procedure+
								"&function_id="+function_id+
								"&overBookingWindowYN="+overBookingWindowYN+
								"&patientId="+patientId+//PMG2014-CRF-0024  U-3
								"&chkSize=2"+
								"&frameNmbr=0"+
								"&fullVacantVal="+fullVacantVal0+
								"&selSurgeonCode="+selSurgeonCode0+// MMS-SCF-0431 [051825]
								"&full_vacant="+full_vacant;
				param1 = "booking_date="+boDate+
								"&roomCode="+roomCode1+
								"&roomDesc="+roomDesc1+
								"&surgeonCode="+surgeonCode1+
								"&surgeonName="+encodeURIComponent(surgeonName1)+//IN055121
								"&speciality_code="+speciality_code+
								"&speciality_desc="+speciality_desc+
								"&orderid="+obj.orderid.value+
					"&selOrderIds="+obj.selOrderIds.value+
								"&booking_no="+obj.booking_no.value+
								"&startTime="+obj.startTime.value+// 44528 - Chaitanya
								"&endTime="+obj.endTime.value+
								"&called_from="+obj.called_from.value+
								"&fpp_category="+obj.fpp_category.value+ //ML-MMOH-CRF-1939-US005
								"&procedure="+procedure+
								"&function_id="+function_id+
								"&overBookingWindowYN="+overBookingWindowYN+
								"&patientId="+patientId+ //PMG2014-CRF-0024  U-3
								"&chkSize=2"+
								"&frameNmbr=1"+
								"&fullVacantVal="+fullVacantVal1+
								"&selSurgeonCode="+selSurgeonCode1+// MMS-SCF-0431 [051825]
								"&full_vacant="+full_vacant;
				param = param0 + "~" + param1;
					parent.parent.f_query_add_mod.location.href="../../eOT/jsp/ScheduleHdrFrame.jsp?"+param;
					parent.parent.frames[0].changeTab("DaySchedule");
					parent.parent.qa_query_result.location.href="../../eOT/jsp/ScheduleFrame.jsp?"+param;
					parent.parent.qa_query_result_tail.location.href="../../eOT/jsp/TailScheduleLegendFrame.jsp?"+param;
			}
			else if(f.length == 3)
			{
				var param = '';
				var param0 = '';
				var param1 = '';
				var param2 = '';
				var obj = document.forms[0];
				var called_from = obj.called_from.value;
				var function_id = obj.function_id.value;
				var speciality_code = '';
				var speciality_desc = '';
				var procedure = obj.procedure_hdn.value;
				if(obj.Speciality_Code.value != null && obj.Speciality_Code.value != '')
					speciality_code = obj.Speciality_Code.value;
				if(obj.Speciality_Desc.value != null && obj.Speciality_Desc.value != '')
					speciality_desc = obj.Speciality_Desc.value;
				var otParam = obj.ot_Param.value;
				var orderIdVal = obj.orderid.value;
				var fullVacantVal0 = '';
				var fullVacantVal1 = '';
				var fullVacantVal2 = '';
				var objS0 = eval("document.forms[0].xx"+f[0]+"");
				var objS1 = eval("document.forms[0].xx"+f[1]+"");
				var objS2 = eval("document.forms[0].xx"+f[2]+"");
				var roomCode0 = objS0.getAttribute('OperRoomCode');
				var roomDesc0 = objS0.getAttribute('OperRoomDesc');
				var surgeonCode0 = objS0.getAttribute('SurgeonCode');
				


					// start MMS-SCF-0431 [051825]
					var selSurgeonCode0 = obj.selSurgeonCode.value;
					if(selSurgeonCode0 != '')
					{
						if(selSurgeonCode0 == '*ALL' && surgeonCode0 == '*ALL')
							selSurgeonCode0 = surgeonCode0;
						else if(selSurgeonCode0 == '*ALL' && surgeonCode0 != '*ALL')
							selSurgeonCode0 = surgeonCode0;
						else if(selSurgeonCode0 != '*ALL' && surgeonCode0 != '*ALL')
							selSurgeonCode0 = surgeonCode0;
					}
					else
						selSurgeonCode0 = surgeonCode0;
					// end MMS-SCF-0431 [051825]

				var surgeonName0 = objS0.getAttribute('SurgeonName');
				var roomCode1 = objS1.getAttribute('OperRoomCode');
				var roomDesc1 = objS1.getAttribute('OperRoomDesc');
				var surgeonCode1 = objS1.getAttribute('SurgeonCode');

					// start MMS-SCF-0431 [051825]
					var selSurgeonCode1 = obj.selSurgeonCode.value;
					if(selSurgeonCode1 != '')
					{
						if(selSurgeonCode1 == '*ALL' && surgeonCode1 == '*ALL')
							selSurgeonCode1 = surgeonCode1;
						else if(selSurgeonCode1 == '*ALL' && surgeonCode1 != '*ALL')
							selSurgeonCode1 = surgeonCode1;
						else if(selSurgeonCode1 != '*ALL' && surgeonCode1 != '*ALL')
							selSurgeonCode1 = surgeonCode1;
					}
					else
						selSurgeonCode1 = surgeonCode1;
					// end MMS-SCF-0431 [051825]

				var surgeonName1 = objS1.getAttribute('SurgeonName');
				var roomCode2 = objS2.getAttribute('OperRoomCode');
				var roomDesc2 = objS2.getAttribute('OperRoomDesc');
				var surgeonCode2 = objS2.getAttribute('SurgeonCode');

					// start MMS-SCF-0431 [051825]
					var selSurgeonCode2 = obj.selSurgeonCode.value;
					if(selSurgeonCode2 != '')
					{
						if(selSurgeonCode2 == '*ALL' && surgeonCode2 == '*ALL')
							selSurgeonCode2 = surgeonCode2;
						else if(selSurgeonCode2 == '*ALL' && surgeonCode2 != '*ALL')
							selSurgeonCode2 = surgeonCode2;
						else if(selSurgeonCode2 != '*ALL' && surgeonCode2 != '*ALL')
							selSurgeonCode2 = surgeonCode2;
					}
					else
						selSurgeonCode2 = surgeonCode2;
					// end MMS-SCF-0431 [051825]

				var surgeonName2 = objS2.getAttribute('SurgeonName');
				if(document.getElementById("fullVacantVal"+f[0]+'_'+cellPosLst) != null)
					fullVacantVal0 = document.getElementById("fullVacantVal"+f[0]+'_'+cellPosLst).value;
				if(document.getElementById("fullVacantVal"+f[1]+'_'+cellPosLst) != null)
					fullVacantVal1 = document.getElementById("fullVacantVal"+f[1]+'_'+cellPosLst).value;
				if(document.getElementById("fullVacantVal"+f[2]+'_'+cellPosLst))
					fullVacantVal2 = document.getElementById("fullVacantVal"+f[2]+'_'+cellPosLst).value;
				var totalDurPend = 0;
				var ret;
				param0 = "booking_date="+boDate+
								"&roomCode="+roomCode0+
								"&roomDesc="+roomDesc0+
								"&surgeonCode="+surgeonCode0+
								"&surgeonName="+encodeURIComponent(surgeonName0)+//IN055121
								"&speciality_code="+speciality_code+
								"&speciality_desc="+speciality_desc+
								"&orderid="+obj.orderid.value+
					"&selOrderIds="+obj.selOrderIds.value+
								"&booking_no="+obj.booking_no.value+
								"&startTime="+obj.startTime.value+// 44528 - Chaitanya
								"&endTime="+obj.endTime.value+
								"&called_from="+obj.called_from.value+
								"&fpp_category="+obj.fpp_category.value+ //Added By Gaurav Against ML-MMOH-SCF-2511
								"&procedure="+procedure+
								"&function_id="+function_id+
								"&overBookingWindowYN="+overBookingWindowYN+
								"&patientId="+patientId+ //PMG2014-CRF-0024  U-3
								"&chkSize=3"+
								"&frameNmbr=0"+
								"&fullVacantVal="+fullVacantVal0+
								"&selSurgeonCode="+selSurgeonCode0+// MMS-SCF-0431 [051825]
								"&full_vacant="+full_vacant;
				
				param1 = "booking_date="+boDate+
								"&roomCode="+roomCode1+
								"&roomDesc="+roomDesc1+
								"&surgeonCode="+surgeonCode1+
								"&surgeonName="+encodeURIComponent(surgeonName1)+//IN055121
								"&speciality_code="+speciality_code+
								"&speciality_desc="+speciality_desc+
								"&orderid="+obj.orderid.value+
					"&selOrderIds="+obj.selOrderIds.value+
								"&booking_no="+obj.booking_no.value+
								"&startTime="+obj.startTime.value+// 44528 - Chaitanya
								"&endTime="+obj.endTime.value+
								"&called_from="+obj.called_from.value+
								"&fpp_category="+obj.fpp_category.value+ //Added By Gaurav Against ML-MMOH-SCF-2511
								"&procedure="+procedure+
								"&function_id="+function_id+
								"&overBookingWindowYN="+overBookingWindowYN+
								"&patientId="+patientId+ //PMG2014-CRF-0024 U-3
								"&chkSize=3"+
								"&frameNmbr=1"+
								"&fullVacantVal="+fullVacantVal1+
								"&selSurgeonCode="+selSurgeonCode1+// MMS-SCF-0431 [051825]
								"&full_vacant="+full_vacant;

				param2 = "booking_date="+boDate+
								"&roomCode="+roomCode2+
								"&roomDesc="+roomDesc2+
								"&surgeonCode="+surgeonCode2+
								"&surgeonName="+encodeURIComponent(surgeonName2)+//IN055121
								"&speciality_code="+speciality_code+
								"&speciality_desc="+speciality_desc+
								"&orderid="+obj.orderid.value+
					"&selOrderIds="+obj.selOrderIds.value+
								"&booking_no="+obj.booking_no.value+
								"&startTime="+obj.startTime.value+// 44528 - Chaitanya
								"&endTime="+obj.endTime.value+
								"&fpp_category="+obj.fpp_category.value+ //ML-MMOH-CRF-1939-US005
								"&called_from="+obj.called_from.value+
								"&procedure="+procedure+
								"&function_id="+function_id+
								"&overBookingWindowYN="+overBookingWindowYN+
								"&patientId="+patientId+ //PMG2014-CRF-0024 U-3
								"&chkSize=3"+
								"&frameNmbr=2"+
								"&fullVacantVal="+fullVacantVal2+
								"&selSurgeonCode="+selSurgeonCode2+// MMS-SCF-0431 [051825]
								"&full_vacant="+full_vacant;
				param = param0 + "~" + param1 + "~~" + param2;
					parent.parent.f_query_add_mod.location.href = "../../eOT/jsp/ScheduleHdrFrame.jsp?"+param;
					parent.parent.frames[0].changeTab("DaySchedule");
					parent.parent.qa_query_result.location.href = "../../eOT/jsp/ScheduleFrame.jsp?"+param;
					parent.parent.qa_query_result_tail.location.href = "../../eOT/jsp/TailScheduleLegendFrame.jsp?"+param;
			}
		}//Else part
	}
}
	//CRF-004.1 - 36448
function moveNext1(boDate,obDM,full_vacant,posnew,rowId)
{
		var retVal = trimString(validateElectiveCutOffTime(boDate));
		if(retVal.length>1)
		{
			var msg = getMessage("APP-OT0124","OT");
			alert(msg);
		}
		else
		{
			var obj=document.forms[0];
			var speciality_code='';
			var speciality_desc='';
			var objS=eval("document.forms[0]."+obDM);		
			var called_from=document.getElementById("called_from").value;
			var function_id=document.getElementById("function_id").value;		
			var objS=document.getElementById(obDM);
			var obj=document.forms[0];
			var procedure=document.getElementById("procedure_hdn").value;
			var specialityCode=document.getElementById("Speciality_Code").value;
			var specialityDesc=document.getElementById("Speciality_Desc").value;
			var surgeonName=document.getElementById("str_Surgeon_Name").value;
			var roomCode=objS.OperRoomCode;
			var surgeonCode=objS.SurgeonCode;
			var locale=document.getElementById("locale").value;//337
			var facility_id=document.getElementById("facility_id").value;//337
			if(specialityCode!=null&&specialityCode!='')
				speciality_code=specialityCode;		
			if(specialityDesc !=null&&specialityDesc!='')
				speciality_desc=specialityDesc;		
			var otParam = document.getElementById("ot_Param").value;
			var orderIdVal = document.getElementById("orderid").value;
			var isVacant="";
			if(document.getElementById("Hid_isVacant"+rowId+'_'+posnew))
				isVacant=document.getElementById("Hid_isVacant"+rowId+'_'+posnew).value;
			var totalDurPend = 0;
			if(full_vacant == 'VACANT' && isVacant=='Y')
			{
				if(otParam == 'Y' || otParam=='y')
				{
					//if(orderIdVal.length>1)//Commented against 1323
					//	totalDurPend = getDurationForPendingorder(orderIdVal);//Commented against 1323
					var ret = chkPermSlotsBooking1(boDate, roomCode, surgeonCode, speciality_code, 0);//002495
					if(ret == 'NO')
					{
						document.getElementById('cell'+rowId+'_'+posnew).className='CYANCLR';
						return;
					}
				}
			}
		}//Else part
}	
//KDAH-SCF-0266
function displaySlotColour(boDate, slotColourDisp, full_vacant, posnew, rowId)
{
		var retVal = trimString(validateElectiveCutOffTime(boDate));      
		if(retVal.length>1)
		{
			var msg = getMessage("APP-OT0124","OT");
			alert(msg);
		}
		else
		{
			var isVacant="";
			if(document.getElementById("Hid_isVacant"+rowId+'_'+posnew))
				isVacant=document.getElementById("Hid_isVacant"+rowId+'_'+posnew).value;
			var otParam = document.getElementById("ot_Param").value;
			if(full_vacant == 'VACANT' && isVacant=='Y')
			{
				if(otParam == 'Y' || otParam=='y')
				{
					if(slotColourDisp == 'NO')
					{
						document.getElementById('cell'+rowId+'_'+posnew).className='CYANCLR';
						return;
					}
				}
			}
		}//Else part
}
//KDAH-SCF-0266
//CRF-004.1 - 36448	
async function showBookingDialog1(specialityCode,specialityDesc,surgeonCode,surgeonName,roomCode,roomDesc,booking_date,full_vacant,called_from)
{
	
	var dialogHeight 		= "16";
	var dialogWidth  		= screen.availWidth;
	var dialogTop   		= "0";
	var dialogLeft   		= "0";
	var features			= "dialogLeft:"+dialogLeft+"dialogTop:"+dialogTop+"; dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth+";status:no";
	var arguments			= "";
	var retVal="";
	var retVal1="";
	var obj=document.forms[0];
	var locale = obj.locale.value;
	var procedure = obj.procedure_hdn.value;
	var fromTime=obj.overbook_start_time.value;
	var hiddenTime=booking_date+" "+obj.overbook_start_time.value;
	var strval=obj.orderid.value;
	var selOrderIds=obj.selOrderIds.value;
	var facility_id = obj.facility_id.value;
	var fpp_category = obj.fpp_category.value; //ML-MMOH-CRF-1939-US005
	var bookingAvailable;
	var overBookingWindowYN = obj.overBookingWindowYN.value;
	if(obj.booking_no.value == null || obj.booking_no.value == '')
	{
		var param="booking_date="+convertDate(booking_date,'DMY','en',locale)+"&roomCode="+roomCode+"&roomDesc="+encodeURIComponent(roomDesc)+"&surgeonCode="+surgeonCode+"&surgeonName="+encodeURIComponent(surgeonName)+"&speciality_code="+specialityCode+"&speciality_desc="+encodeURIComponent(specialityDesc)+"&start_time="+fromTime+"&hidden_time="+hiddenTime+"&over_booking_case_yn=Y"+"&called_from="+called_from+"&procedure="+procedure;
		param+="&orderid="+strval;		
		param+="&selOrderIds="+selOrderIds;
		if (overBookingWindowYN == 'N')
		{
			//43811 added by Chaitanya on 10/19/2013
			bookingAvailable = chkOverBookingAvailable(roomCode, booking_date, facility_id);
			if(bookingAvailable == 'Y')
			{
			dialogHeight = screen.availHeight;
			features = "dialogLeft:"+dialogLeft+"dialogTop:"+dialogTop+"; dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth+";status:no";
				retVal1=""+ await window.showModalDialog("../../eOT/jsp/OperationRegisterFrame.jsp?"+param,arguments,features);//Sanja
			}
			else
				alert(getMessage("APP-OT0219","OT"));
			//43811 added by Chaitanya on 10/19/2013
		}
		else 
			retVal1=""+await window.showModalDialog("../../eOT/jsp/OperOverBookingFrame.jsp?"+param,arguments,features);//Sanjay
	}
	else
	{
		var function_id=obj.function_id.value;
		var param="booking_date="+convertDate(booking_date,'DMY','en',locale)+"&roomCode="+roomCode+"&roomDesc="+encodeURIComponent(roomDesc)+"&surgeonCode="+surgeonCode+"&surgeonName="+encodeURIComponent(surgeonName)+"&speciality_code="+specialityCode+"&speciality_desc="+encodeURIComponent(specialityDesc)+"&start_time="+fromTime+"&hidden_time="+hiddenTime+"&transfer=1"+"&booking_no="+obj.booking_no.value+"&startTime="+obj.startTime.value+"&endTime="+obj.endTime.value+"&facility_id="+obj.facility_id.value+"&order_id="+strval+"&over_booking_case_yn=Y"+"&called_from="+called_from+"&function_id="+function_id;		// 44528 - Chaitanya
		param+="&orderid="+strval;	
		param+="&selOrderIds="+selOrderIds;
		if (overBookingWindowYN == 'N')
		{
			dialogHeight = screen.availHeight;
			features = "dialogLeft:"+dialogLeft+"dialogTop:"+dialogTop+"; dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth+";status:no";			
			retVal1=""+await window.showModalDialog("../../eOT/jsp/BookingDetailFrame.jsp?"+param,arguments,features);
		}
		else
		{
			retVal1=""+await window.showModalDialog("../../eOT/jsp/OperOverBookingFrame.jsp?"+param,arguments,features);//Sanjay
			if (retVal1 == "YES")
			{	
				parent.parent.frames[1].location.href="../../eOT/jsp/DiarySheduleSearch.jsp?reschedule=Y";//Sanjay
				parent.parent.frames[2].location.href="../../eCommon/html/blank.html";//Sanjay
			}
		}		
	}
	if(obj.booking_no.value==null||obj.booking_no.value=='')
	{
		var param="booking_date="+booking_date+"&roomCode="+roomCode+"&roomDesc="+encodeURIComponent(roomDesc)+"&surgeonCode="+surgeonCode+"&surgeonName="+encodeURIComponent(surgeonName)+"&speciality_code="+specialityCode+"&speciality_desc="+encodeURIComponent(specialityDesc)+"&start_time="+fromTime+"&hidden_time="+hiddenTime+"&over_booking_case_yn=Y"+"&called_from="+called_from+"&procedure="+procedure;
		var strval=obj.orderid.value;
		param+="&orderid="+strval;
		param+="&selOrderIds="+selOrderIds;
	}
	else
	{
				var function_id=obj.function_id.value;
		var param="booking_date="+booking_date+"&roomCode="+roomCode+"&roomDesc="+encodeURIComponent(roomDesc)+"&surgeonCode="+surgeonCode+"&surgeonName="+encodeURIComponent(surgeonName)+"&speciality_code="+specialityCode+"&speciality_desc="+encodeURIComponent(specialityDesc)+"&start_time="+fromTime+"&hidden_time="+hiddenTime+"&transfer=1"+"&booking_no="+obj.booking_no.value+"&startTime="+obj.startTime.value+"&endTime="+obj.endTime.value+"&facility_id="+obj.facility_id.value+"&order_id="+obj.orderid.value+"&over_booking_case_yn=Y"+"&called_from="+called_from+"&function_id="+function_id+"&selOrderIds="+selOrderIds;// 44528 - Chaitanya
	}

		var par="";
		if(retVal1.charAt(0)=='1'){
			if((obj.orderid!=null&&obj.orderid.value.length > 0) || (obj.booking_no!=null&&obj.booking_no.value.length >0)){
				param=param+"&fun=1";	
			}
			param += "&fpp_category="+fpp_category; //ML-MMOH-CRF-1939-US005
			parent.parent.f_query_add_mod.location.href="../../eOT/jsp/ScheduleHdr.jsp?"+param;
			parent.parent.frames[0].changeTab("DaySchedule");
			
			parent.parent.qa_query_result.location.href="../../eOT/jsp/Schedule.jsp?"+param;
			parent.parent.qa_query_result_tail.location.href="../../eOT/jsp/TailScheduleLegend.jsp?"+param;
		}
}

function validateElectiveCutOffTime(boDate)
{ 
	var formObj = document.calendar;
	var order_id=document.getElementById("orderid").value;
	

	var selOrderIds = document.getElementById("selOrderIds").value;
	var booking_num=document.getElementById("booking_no").value;
	var facility_id=document.getElementById("facility_id").value;
       /* var order_id = formObj.orderid.value;//
	var booking_num = formObj.booking_no.value;
	var facility_id = formObj.facility_id.value;*/ //
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest();
	var params = "order_id="+order_id+"&queried_pref_surg_date="+boDate+"&facility_id="+facility_id+"&booking_num="+booking_num;
	var xmlStr ="<root><SEARCH ";
	xmlStr +=" /></root>";
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST","CommonValidation.jsp?func_mode=validateElectiveCutOffTime&"+params,false);
	xmlHttp.send(xmlDoc);
	var retVal = trimString(xmlHttp.responseText);
	return retVal;
}
//43811 added by Chaitanya on 10/19/2013
function chkOverBookingAvailable(roomCode, booking_date, facility_id)
{
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest() ;
	var locale = document.forms[0].locale.value;
	var xmlStr ="<root><SEARCH  /></root>";
	var param="func_mode=chkOverBookingAvailable&roomCode="+roomCode+"&strBookingDate="+convertDate(booking_date,'DMY','en',locale)+"&facility_id="+facility_id;
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST","../../eOT/jsp/OTCommonValidation.jsp?"+param,false);
	xmlHttp.send(xmlDoc);
	var check_count = localTrimString(xmlHttp.responseText);	
	return check_count;
}
//43811 added by Chaitanya on 10/19/2013
</script>
</head>
<body onLoad='assign()' onscroll="scrollTitle()" OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()'>  
<script type="text/javascript" src="../../eOT/js/wz_tooltip.js"></script>
<%
	int arr[]={0,31,28,31,30,31,30,31,31,30,31,30,31};
	String dayValue[]={"","Su","Mo","Tu","We","Th","Fr","Sa"};
	int cou=0,count=0,date=0,dayStart=0,dat=0,flag=0,holidayCount=0,date11=0,month11=0,year11=0,dat1=0;
	int holiday[]=new int[10];	
	int tempDate=0,tempMonth=0,tempYear=0;
	String strSpecialityCode="";
	String strSpecialityDesc="";
	String strSpecificSplty="";
	String strBookingNo="";
	String dateStr="";
	//KDAH-SCF-0266
	String daysArray[] = new String[31];
	String slotColourDisp="";
	//KDAH-SCF-0266
	String dateValue="";
	String strSlot="";
	String strOrderId="";
	String strFromValue="";
	String customerId = "";
	String otParam = "";
	String sqlOtParam = "select NVL(SCHEDULE_RESTRICT_YN,'N') facility from OT_PARAM where rownum = 1";
	String sqlOverBookingParam = "select NVL(over_booking_window_user, 'N') from OT_PARAM_FOR_FACILITY where OPERATING_FACILITY_ID = ?";
	String overBookingWindowYN = "";
	HashMap hashHolidaylist=new HashMap();
	strBookingNo=request.getParameter("booking_no");
	strBookingNo=strBookingNo==null?"":strBookingNo;
	strOrderId=request.getParameter("orderid");
	strOrderId=strOrderId==null?"":strOrderId;
	strFromValue=request.getParameter("from_value");
	String called_from=checkForNull(request.getParameter("called_from"));
	strFromValue=strFromValue==null?"":strFromValue;
	strSpecialityCode=request.getParameter("speciality_code");
	strSpecialityCode=strSpecialityCode==null?"":strSpecialityCode;
	strSpecialityDesc=request.getParameter("speciality_desc");
	strSpecialityDesc=java.net.URLEncoder.encode(strSpecialityDesc,"UTF-8");
	strSpecialityDesc=strSpecialityDesc==null?"":strSpecialityDesc;
	String function_id=checkForNull(request.getParameter("function_id"));
	String startTime = checkForNull(request.getParameter("startTime"));// 44528 - Chaitanya
	String selOrderIds=request.getParameter("selOrderIds");//Chaitanya
	String endTime = checkForNull(request.getParameter("endTime"));
	String patientId = checkForNull(request.getParameter("patientId")); //PMG2014-CRF-0024 U-3
	String fpp_category = checkForNull(request.getParameter("fpp_category"));  //ML-MMOH-CRF-1939-US005
	String strProc=request.getParameter("procedure");
	strProc=strProc==null?"":strProc; 
	dateValue = request.getParameter("date");
	int month=0,year=0;
	StringTokenizer strToken=new StringTokenizer(dateValue,"/");
	StringTokenizer colourDispTokens = null;//KDAH-SCF-0266
	if(strToken.hasMoreTokens())
	{
		date=Integer.parseInt(strToken.nextToken());
		month=Integer.parseInt(strToken.nextToken());
		year=Integer.parseInt(strToken.nextToken());
	}

	String[] date_arr = dateValue.split("/"); 
	String thai_year = date_arr[2];

	if(month==2){
		if(year%100==0&&year%400==0){
			arr[month]=arr[month]+1;
		}else if((year%100)!=0&&(year%4)==0){
			arr[month]=arr[month]+1;
		}
	}

	Connection conn=null;
	PreparedStatement pstmt=null;
	PreparedStatement pstmt1=null;
	PreparedStatement overbook_pstmt=null;	
	ResultSet rs=null;
	ResultSet overbook_rs=null;
	CallableStatement callableStatement=null;
	PreparedStatement pstmtOverBookingParam=null;
	ResultSet rsOverBookingParam=null;
	String  sql=OTRepository.getOTKeyValue("SQL_OT_CALENDAR_SELECT1");
	conn = ConnectionManager.getConnection(request);
	String overbook_start_time="";
	try{ 
		overbook_pstmt = conn.prepareStatement("SELECT TO_DATE(?,'DD/MM/YYYY HH24:MI') END_DATE_TIME,TO_CHAR((TO_DATE(?,'DD/MM/YYYY HH24:MI')- TO_CHAR(UNIT_OT_TIME,'SSSSS')/(24*60*60)),'HH24:MI') START_DATE_TIME FROM OT_PARAM_FOR_FACILITY WHERE OPERATING_FACILITY_ID = ?");
		overbook_pstmt.setString(1,dateValue+" 00:00");
		overbook_pstmt.setString(2,dateValue+" 00:00");
		overbook_pstmt.setString(3,facility_id);
		overbook_rs = overbook_pstmt.executeQuery();
		//overbook_rs = overbook_pstmt.executeQuery();
		while(overbook_rs.next()){
			overbook_start_time = overbook_rs.getString("START_DATE_TIME");
		}
		String sql_sm_report = "select customer_id from SM_SITE_PARAM where rownum = 1"; //IN044993
		pstmt = conn.prepareStatement(sql_sm_report);
		rs=pstmt.executeQuery();
		if(rs.next())
			customerId = rs.getString("CUSTOMER_ID");
		if(rs!=null)
			rs.close();
		if(pstmt !=null)
			pstmt.close();	//IN044993 
		pstmt = conn.prepareStatement(sqlOtParam);
		rs=pstmt.executeQuery();
		if(rs !=null && rs.next())
		{
			otParam=checkForNull(rs.getString("facility"));		
		}
		pstmt = null;
		rs = null;
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1,dateValue);
		rs=pstmt.executeQuery();
		if(rs!=null && rs.next()==true)
			dayStart=Integer.parseInt(rs.getString(1));
		pstmtOverBookingParam = conn.prepareStatement(sqlOverBookingParam);
		pstmtOverBookingParam.setString(1,facility_id);
		rsOverBookingParam=pstmtOverBookingParam.executeQuery();
		if(rsOverBookingParam!=null && rsOverBookingParam.next()==true)
			overBookingWindowYN=checkForNull(rsOverBookingParam.getString(1));
	}catch(Exception ee){
		ee.printStackTrace();
	}finally{
		if(rs!=null)   rs.close();
		if(pstmt!=null) pstmt.close();
		if(overbook_rs !=null)	overbook_rs.close();
		if(overbook_pstmt!=null) overbook_pstmt.close();
		if(rsOverBookingParam !=null)	rsOverBookingParam.close();
		if(pstmtOverBookingParam!=null) pstmtOverBookingParam.close();
	}%>
	<%
	try{
		String sql1="SELECT b.DAY_code DAY_CODE1, a.DAY_OF_WEEK  FROM OT_DAY_OF_WEEK a, (select to_char(sysdate,'D') day_code, to_char(sysdate,'DAY') day_of_week from dual union select to_char(sysdate+1,'D') day_code, to_char(sysdate+1,'DAY') day_of_week from dual union select to_char(sysdate+2,'D') day_code, to_char(sysdate+2,'DAY') day_of_week from dual union select to_char(sysdate+3,'D') day_code, to_char(sysdate+3,'DAY') day_of_week from dual union select to_char(sysdate+4,'D') day_code, to_char(sysdate+4,'DAY') day_of_week from dual union select to_char(sysdate+5,'D') day_code, to_char(sysdate+5,'DAY') day_of_week from dual union select to_char(sysdate+6,'D') day_code, to_char(sysdate+6,'DAY') day_of_week from dual) b where trim(a.day_of_week) = trim(b.day_of_week) AND A.day_status = 'H'";
		pstmt1 = conn.prepareStatement(sql1);
	   	rs=pstmt1.executeQuery();
		holidayCount=0;
		while(rs.next()==true){
				holiday[holidayCount]=Integer.parseInt(rs.getString("DAY_CODE1"));
				 holidayCount++;
			}
		}catch(Exception ee){
			ee.printStackTrace();
			//System.err.println("Err Msg From CalendarSlot.jsp-->"+ee);
		}finally{
			if(rs!=null) rs.close();
	    	pstmt1.close();
		}
	try{
			HashMap HashHoliday1 = null;
			sql="SELECT  TO_CHAR(A.HOLIDAY_DATE,'DD/MM/YYYY') HOLIDAY_DATE,  TO_CHAR(HOLIDAY_DATE,'DD/MM/YYYY') DATE1 ,UPPER(TO_CHAR( HOLIDAY_DATE,'DAY')) DAYNAME, DAY_CODE  FROM OT_HOLIDAY A , OT_DAY_OF_WEEK B WHERE B.DAY_OF_WEEK = TRIM(UPPER(TO_CHAR(A.HOLIDAY_DATE,'DAY'))) AND OPERATING_FACILITY_ID =?";
			pstmt = conn.prepareStatement(sql);
			String  login_user=""+session.getValue("facility_id");
			int index_holiday=0;
			pstmt.setString(1,login_user);
			rs=pstmt.executeQuery();		
			while(rs.next()){
				index_holiday++;
				HashHoliday1 = new HashMap();
				HashHoliday1.put("holiday_date",rs.getString("HOLIDAY_DATE"));
				HashHoliday1.put("date1",rs.getString("DATE1"));
				HashHoliday1.put("dayname",rs.getString("DAYNAME"));
				HashHoliday1.put("day_code",rs.getString("DAY_CODE"));
				hashHolidaylist.put(index_holiday+"",HashHoliday1);
			 }
	}catch(Exception ee){
		ee.printStackTrace();
		//System.err.println("Error Msg in CalenderSlot : "+ee);
	}finally{
		if(rs!=null)	rs.close();
		pstmt.close();
	}	
%>
<!-- DIV TABLE 1 -->
<div id="divTitleTable1"  class='menu1' >
<table>		
<tr>
	<td class='ush' width='340px' NOWRAP ></td>
</tr>
</table>

<table border=0 width='380px' align="left" >
<tr>
	<td class='OALABEL' width='170px' NOWRAP ></td>
	<td class='OALABEL' width='170px' NOWRAP ></td> 
</tr>

<tr>
	<th class='columnheader'  align="center"  height='47px' width='170px' NOWRAP> 
		<fmt:message key="Common.Surgeon.label" bundle="${common_labels}"/> </th>
	<th class='columnheader'  align="center"  height='47px' width='170px' NOWRAP> 
		<fmt:message key="Common.Theatre.label" bundle="${common_labels}"/>
</th>
<%
if(!customerId.equalsIgnoreCase("KDAH")){//Added agaomst KDAH-SCF-0214 [IN:045516]
%>
	<th class='columnheader'  align="center"  width='35px' height='47px'> </th>
<%
}//Added agaomst KDAH-SCF-0214 [IN:045516]
%>

</tr>
</table>
</div>
<!--END DIV TABLE1-->
<!--DIV TBALE2-->

<div id="divTitleTable" class='menu' >
<table border=0 width='840px' bgColor='white' align="center"   >
<tr>
<% 
	int new_month=0;
	int new_month1=0;
	int new_year=0;
	int new_thai_year=0;

	String th_year = com.ehis.util.DateUtils.convertDate(""+month+"/"+thai_year,"MY","en",locale);

		strToken=new StringTokenizer(th_year,"/");
		if(strToken.hasMoreTokens())
		{
			month=Integer.parseInt(strToken.nextToken());
			thai_year=strToken.nextToken();
		}

   if(date ==1&&arr[month]==31){
	   out.println("<td  align='left'  width='840px'  colspan='"+arr[month]+"' class=ush>&nbsp;"+month+"/"+thai_year+"</td>");
	   
   }else{
	   if((month+1)>12){
			new_month=1;
			new_year =year+1;
			new_thai_year = Integer.parseInt(thai_year)+1;
	   }else{
			new_month=month+1;
			new_year=year;
			new_thai_year = Integer.parseInt(thai_year);
	   }
		out.println("<td align='left' width='"+((arr[month]-date)*23)+"px' colspan='"+(arr[month]-date)+"' class=ush>&nbsp;"+month+"/"+thai_year+"</td>");
		out.println("<td  align='left'  width='"+((30-(arr[month]-date))*23)+"px'  colspan='"+(30-(arr[month]-date))+"' class=ush>&nbsp;"+new_month+"/"+new_thai_year+"</td>");
			if(new_month==2) {
		if(date==31){
			new_month1=new_month+1;
			out.println("<td  align='right'  width='840px'    colspan='"+arr[month]+"' class=ush>&nbsp;"+new_month1+"/"+thai_year+"</td>");
		}
		else if(date==30){
			if(!((new_year%100==0&&new_year%400==0)||((new_year%100)!=0&&(new_year%4)==0))) {
					new_month1=new_month+1;
					out.println("<td  align='right'   width='840px'  colspan='"+arr[month]+"' class=ush>&nbsp;"+new_month1+"/"+thai_year+"</td>");
					}
				}
	}
   }         
%>
</tr>	
</table>

<table border=1 width='840px'  bgColor=white  id='colors' align="left" >
<tr>
	<%
		count=31;
	for(dat=1,cou=dayStart;dat<=count;dat++)
	{			
	out.println("<td class=OALABEL width='21px' >"+dayValue[cou]+"</td>");
	cou=(cou%7)+1;
	}
%>
</tr>
<tr>	
<%
	HashMap map = new HashMap();
	int dayss=dayStart;
	for( dat=date, count=1; dat<=arr[month];dat++, count++)
	{
	flag=0;
	for(cou=0;cou<holidayCount;cou++)
		{
			 if(dayss==holiday[cou]) 
			 {
			flag=1;
			break;
		}
		}
		for(int i1=1;i1<=hashHolidaylist.size();i1++)
		{
		map = (HashMap) hashHolidaylist.get(i1+"");
		String date1=(String)map.get("date1");
		StringTokenizer strToken1=new StringTokenizer(date1,"/");
			if(strToken1.hasMoreTokens())
			{
			 date11=Integer.parseInt(strToken1.nextToken());
			 month11=Integer.parseInt(strToken1.nextToken());
			 year11=Integer.parseInt(strToken1.nextToken());
		}
			if(date11==dat && month11==month && year11==year)
			flag=1;
		}
		if(flag == 0)
		out.print("<td class='OALABEL ' width='21px' >"+dat+"</td>");
		else
		out.print("<td class='OAHOLIDAY' width='21px' >"+dat+"</td>");
	dayss=(dayss%7)+1;
	}
if(count<=31)
{
for( dat=1;dat<=(32-count);dat++)
{	
flag=0;
for(cou=0;cou<holidayCount;cou++)
			{
				if(dayss==holiday[cou])
				{
					flag=1;
					break;
				}
			}
	dat1=dat;
			if(new_month==2) 
			{
				if(new_year%100==0&&new_year%400==0) 
				{
					if(dat==30)
						dat1=1;
					}
				else if((new_year%100)!=0&&(new_year%4)==0)
				{
					if(dat==30)
						dat1=1;
					}
				else
				{
					if(dat==29)
						dat1=1;
					else if(dat==30)
						dat1=2;
					else
						dat1=dat;
					}
				}
			else
		dat1=dat;
if(flag==0)
	out.print("<td class='OALABEL ' width='21px' >"+dat1+"</td>");
else
	out.print("<td class='OAHOLIDAY' width='21px' >"+dat1+"</td>");
dayss=(dayss%7)+1;
}
}
%>	
</tr>
</table>
</div>

<!--END DIV TBALE2-->
</br></br>
</br></br>

<!--DIV TBALE3-->
<form name='calendar' id='calendar'>
<div id="divTitleTable23" style="z-index:100;margin-top:3px;">
<table width='380px' align="left"   >

<%
	HashMap hashSurgeonCode=new HashMap();
	HashMap hashRoomCode=new HashMap();
	HashMap hashSurgeonName=new HashMap();
	HashMap hashSpecificSplty=new HashMap();
	HashMap hashRoomDesc=new HashMap();
	//CRF-004.1 - 36448 
	 ArrayList objslot = new ArrayList();	 
	 ArrayList indexIncr = new ArrayList();
	 ArrayList posslot = new ArrayList();
	//CRF-004.1 - 36448 
	String strSurgeonCode="";
	String strOperRoomCode="";
	String strSurgeonName="";
	String strOperRoomDesc="";
	String strValue="";
	String chkBoxChked = "";
	String strResultString="";
	String allowableSlots = "";//KDAH-SCF-0266
	int index=0;
	ResultSet rst = null;
	String selSurgeonCode = "";// 051911
try
{
    sql=request.getParameter("sql");
	//Added Against MOHE-SCF-0209...starts
	String[] ar = sql.split("::");
	String key = ar[0].substring(2,13);
	if(key.equals("INTERNALREP")){
	int var = 1;
	String sql_query="";
	try {
	MessageManager mm = new MessageManager();
	java.util.Hashtable mesg = mm.getMessage(locale,ar[0],ar[1]);
	sql_query = (String) mesg.get("message");
	StringBuffer sb = new StringBuffer();
	int start = 0,end = 0;
	
	for(int i=0;i<sql_query.length();i++){
		end=i;
		if(sql_query.charAt(i) == '#'){
			sb.append(sql_query.substring(start, end));
			var++;
			sb.append(ar[var]);
			start = i+1;
		}
		if(i==sql_query.length()-1) sb.append(sql_query.substring(start,i+1));
		//System.err.println("sql = "+sb);
	}

	sql = sb.toString();
	System.err.println(sql);
	}
	catch (Exception e) {
		e.printStackTrace();
		//System.err.println("Err Msg CalendarSlot.jsp in getting SQL "+e.getMessage());
	}
	}
	//Added Against MOHE-SCF-0209...ends
	selSurgeonCode = request.getParameter("selSurgeonCode");// 051911
	
	System.out.println(" ********************* SQL Query in Calendarslot :"+sql);
	pstmt = conn.prepareStatement(sql);
	pstmt.setString(1,dateValue);
	pstmt.setString(2,dateValue);
	rst=pstmt.executeQuery();
	int fetchCount=0;
	while(rst.next())
	{
		strSurgeonCode=rst.getString("SURGEON_CODE1");	
		strOperRoomCode=rst.getString("OPER_ROOM_CODE1");
		strSurgeonName=rst.getString("SURGEON_NAME1");
		if(strSurgeonName.length()>22){
		strSurgeonName=strSurgeonName.substring(0,1).toUpperCase() +
              strSurgeonName.substring(1).toLowerCase(); // muthu 07-10-11 
		}
		else{
			strSurgeonName = rst.getString("SURGEON_NAME1");
		}
		strOperRoomDesc=rst.getString("OPER_ROOM_DESC1");
		strSpecificSplty=rst.getString("SPECIALITY_CODE1");
		hashSurgeonCode.put(""+fetchCount,strSurgeonCode);
		hashRoomCode.put(""+fetchCount,strOperRoomCode);
		hashSurgeonName.put(""+fetchCount,strSurgeonName);
		hashRoomDesc.put(""+fetchCount,strOperRoomDesc);
		hashSpecificSplty.put(""+fetchCount,strSpecificSplty);

		out.println("<tr>");
		out.println("<td class='OALABEL' width='170px' height='29px' style='nowrap' >"+strSurgeonName+"</td>");
		out.println("<td class='OALABEL' width='170px' height='29px' style='nowrap' >"+strOperRoomDesc+"</td>");
		//CRF 0085 change	
			System.out.println("--------customerId---------:"+customerId);
		if(customerId != null && !customerId.equalsIgnoreCase("MOHBR") && !customerId.equalsIgnoreCase("SHALM") && !customerId.equalsIgnoreCase("WCH") && fetchCount < 3)	//IN044993 & 58919
			chkBoxChked = "checked";
       	if(!customerId.equalsIgnoreCase("KDAH"))//Added against KDAH-SCF-0214 [IN:045516]
			out.println("<td class='OALABEL' width='30px' NOWRAP ><input type=checkbox "+ chkBoxChked +" name='check"+fetchCount+"' id='check"+fetchCount+"' id='check"+fetchCount+"' onClick=checkBoxMaxSelect("+fetchCount+")></td>");
		//Added agaomst KDAH-SCF-0214 [IN:045516]
		strToken=new StringTokenizer(strResultString,"#");
		out.println("</tr>");
		fetchCount++;
		chkBoxChked = "";
	}
	out.println("<input type='hidden' name='fetchCount' id='fetchCount' value='"+fetchCount+"'/>");
	out.println("<input type='hidden' name='customerId' id='customerId' id='customerId' value='"+customerId+"'/>");//KDAH-SCF-0266
}catch(Exception ee)
	{
		ee.printStackTrace();
		//System.err.println("cmg in loop 2 :" +ee);
		}
	finally{
		if(rst!=null)   rst.close();
		if(rs!=null)   rs.close();
		pstmt.close();
	}
%>
</table>
</div>
<!--END DIV TBALE3-->
<!-- Detail FORM-->

<!-- CRF-004.1 - 36448  -->
<input type='hidden' name='Speciality_Code' id='Speciality_Code' value="<%=strSpecialityCode%>">
<input type='hidden' name='Speciality_Desc' id='Speciality_Desc' value="<%=strSpecialityDesc%>">
<input type='hidden' name='booking_no' id='booking_no' value='<%=strBookingNo%>'>
<input type='hidden' name='startTime' id='startTime' value='<%=startTime%>'> <%-- 44528 - Chaitanya --%>
<input type='hidden' name='endTime' id='endTime' value='<%=endTime%>'>
<input type='hidden' name='patientId' id='patientId' id="patientId" value='<%=patientId%>'> <%-- PMG2014-CRF-0024 U-3 --%>
<input type='hidden' name='orderid' id='orderid' value="<%=strOrderId%>">
<input type='hidden' name='selOrderIds' id='selOrderIds' id='selOrderIds' value='<%=selOrderIds%>'> <%-- ChAiTu - 186 --%>
<input type='hidden' name='locale' id='locale' value="<%=locale%>">
<input type='hidden' name='facility_id' id='facility_id' value="<%=facility_id%>">
<input type='hidden' name='procedure_hdn' id='procedure_hdn' value="<%=strProc%>">
<input type='hidden' name='params' id='params' value="<%=request.getQueryString()%>">
<input type='hidden' name='called_from' id='called_from' value="<%=called_from%>">
<input type='hidden' name='function_id' id='function_id' value="<%=function_id%>">
<input type='hidden' name='ot_Param' id='ot_Param' value='<%=otParam%>'>
<input type='hidden' name='oper_room_code' id='oper_room_code' value="<%=strOperRoomCode%>">
<input type='hidden' name='str_Surgeon_Name' id='str_Surgeon_Name' value="<%=strSurgeonName%>">
<input type='hidden' name='str_Surgeon_Code' id='str_Surgeon_Code' value="<%=strSurgeonCode%>">
<br>
<table border=1 width='1196px' align="left" style="margin-left:0px;margin-top:-2px">
<%
try{
//FacilityID Parameter is added additionally in procedure and changes done by Bala subramanian as instructed by vishwa on 05/06/2006
callableStatement=conn.prepareCall("{ call OT_SURGEON_CALENDAR(?,?,?,?,?)}");
	
for(int pos=0;pos<hashSurgeonCode.size();pos++)
{
	index=0;
	callableStatement.setString(++index,facility_id);
	callableStatement.setString(++index,""+hashSurgeonCode.get(""+pos));
	callableStatement.setString(++index,""+hashRoomCode.get(""+pos));
	callableStatement.setString(++index,dateValue);		
	strSurgeonCode=""+hashSurgeonCode.put(""+pos,strSurgeonCode);
	strSurgeonName=""+hashSurgeonName.put(""+pos,strSurgeonName);
	strOperRoomCode=""+hashRoomCode.put(""+pos,strOperRoomCode);
	strOperRoomDesc=""+hashRoomDesc.put(""+pos,strOperRoomDesc);
	callableStatement.registerOutParameter(++index,Types.VARCHAR);
	callableStatement.execute();
	strResultString=callableStatement.getString(index);
	String borderc = "";//CRF-337
	
	//CRF-004.1 - 36448 
	int indexclor=0;
	//CRF-004.1 - 36448  
	out.println("<tr>");
	out.println("<td>");
	
	strToken=new StringTokenizer(strResultString,"#");
	tempDate=date;
	tempMonth=month;
	tempYear=year;
	out.println("<input type='hidden' name='xx"+pos+"' id='xx"+pos+"' SurgeonName=\""+strSurgeonName+"\"  specificSplty=\""+strSpecificSplty+"\"  SurgeonCode=\""+strSurgeonCode+"\"	OperRoomCode=\""+strOperRoomCode+"\"  OperRoomDesc=\""+strOperRoomDesc+"\">&nbsp</td>");
	while(strToken.hasMoreTokens())
	{
		strValue=strToken.nextToken();
		strSlot=""+strValue.charAt(2)+strValue.charAt(3);
	if(tempDate <10)
			dateStr="0"+tempDate+"/";
		else
			dateStr=""+tempDate+"/";
	if(tempMonth <10)    
			dateStr+="0"+tempMonth+"/";
	else    
		dateStr+=""+tempMonth+"/";
		dateStr+=""+tempYear;
	   tempDate++;
	   if(tempDate>arr[tempMonth])
	   {
	          tempDate=1;
			  tempMonth++;
			if(tempMonth>12)
			  {
					tempYear++;
					tempMonth=1;
			  }
			  }
	   out.println("<input type='hidden' name='Hid_pos' id='Hid_pos' value='"+pos+"'/>");
		switch(strValue.charAt(0))
		{
			case 'U':  
				if(strSlot.equals("00")) 
					strSlot="";
		        out.print(" <td class='OALABEL' width='21px' height='29px' style='word-wrap: break-word' align='center' id='cell"+pos+"_"+indexclor+"'> "+strSlot+"</td>"); 
		        break;  
			case 'S':
				if(strSlot.equals("00")) 
					strSlot="0";
			  	out.println(" <td class='OAGREEN' width='21px' align='center' style='word-wrap: break-word'  height='29px' id='cell"+pos+"_"+indexclor+"'>");
				if(strFromValue.equals("1")==true && ComparingDate(dateStr))
					out.println(""+strSlot+"</td>");
				else
				{
					out.println("<a href=\"javascript:moveNext('"+dateStr+"','xx"+pos+"','VACANT','"+pos+"_"+indexclor+"');\">"+strSlot+" </a></td>");
					out.println("<input type='hidden' name='Hid_isVacant"+pos+"_"+indexclor+"' id='Hid_isVacant"+pos+"_"+indexclor+"' value='Y'>");
					out.println("<input type='hidden' name='fullVacantVal"+pos+"_"+indexclor+"' id='fullVacantVal"+pos+"_"+indexclor+"' value='VAC'>");
				}	
			break;	
		    case 'F':
		    	if(strSlot.equals("00")) 
		    		strSlot="0"; // Character 'F' Fully booked Cases and Over Booking Not Allowed
				out.print(" <td class='OAFULL' width='21px' align='center' id='cell"+pos+"_"+indexclor+"'>");		    
				if(strFromValue.equals("1")==true && ComparingDate(dateStr))
					out.println(""+strSlot+"</td>");
				else
				{
					out.println("<font color=white><a href=\"javascript:moveNext('"+dateStr+"','xx"+pos+"','FULL_OVER_BOOKING_NO','"+pos+"_"+indexclor+"');\">"+strSlot+"</a></font></td>");
					out.println("<input type='hidden' name='fullVacantVal"+pos+"_"+indexclor+"' id='fullVacantVal"+pos+"_"+indexclor+"' value='FOBN'>");
				}				
			break;
		    case 'O':
		    	if(strSlot.equals("00")) 
		    		strSlot="0"; // character 'O' Fully booked Cases and Over Booking is Allowed
				out.print(" <td class='EMERGENT' align='center' width='21px' id='cell"+pos+"_"+indexclor+"'>");	
				if(strFromValue.equals("1")==true && ComparingDate(dateStr))
					out.println(""+strSlot+"</td>");
				else
				{
					out.println("<font color=white><a href=\"javascript:moveNext('"+dateStr+"','xx"+pos+"','FULL_OVER_BOOKING_YES','"+pos+"_"+indexclor+"');\">"+strSlot+"</a></font></td>");
					out.println("<input type='hidden' name='fullVacantVal"+pos+"_"+indexclor+"' id='fullVacantVal"+pos+"_"+indexclor+"' value='FOBY'>");
				}				
			break;
			
			// Added start for New Blocked Theatre CRF - 337
			case 'B':
		    	if(strSlot.equals("00")) 
		    		strSlot="0"; // character 'B' Fully blocked Cases and Over Booking is Allowed
				//out.print(" <td class='OARED' align='center' width='21px' id='cell"+pos+"_"+indexclor+"'>");	
				if(strFromValue.equals("1")==true && ComparingDate(dateStr)){
					//out.print(" <td class='OARED' align='center' width='21px' id='cell"+pos+"_"+indexclor+"'>");	
					out.println(""+strSlot+"</td>");
				}	
				else
				{
					/*out.print(" <td class='OARED' align='center' width='21px' id='cell"+pos+"_"+indexclor+"'>");	
					out.println("<font color=white><a href=\"javascript:moveNext('"+dateStr+"','xx"+pos+"','FULL_OVER_BOOKING_NO','"+pos+"_"+indexclor+"');\">"+strSlot+"</a></font></td>");
					out.println("<input type='hidden' name='fullVacantVal"+pos+"_"+indexclor+"' id='fullVacantVal"+pos+"_"+indexclor+"' value='FOBY'>");*/
				%>	
					<td class='OARED' BORDERCOLOR='#FF0000' align='center' width='21px' id='cell"+<%=pos%>+"_"+<%=indexclor%>+"' OnMouseOver="Tip(BlockedToolTip('<%=dateStr%>','<%=strOperRoomCode%>','<%=locale%>','<%=facility_id%>'));" onMouseOut='UnTip();'>
					<!--<font color=white><a href="javascript:moveNext('<%=dateStr%>','xx'+<%=pos%>,'FULL_OVER_BOOKING_NO',<%=pos%>+'_'+<%=indexclor%>)"><%=strSlot%></a></font>-->
					<font color=white><a href="javascript:moveNext('<%=dateStr%>','xx'+<%=pos%>,'FULL_OVER_BOOKING_NO',<%=pos%>+'_'+<%=indexclor%>)">&nbsp</a></font>
					<input type='hidden' name='fullVacantVal' id='fullVacantVal'+<%=pos%>+'_'+<%=indexclor%>+' value='FOBY'>
					
				<%	
				}				
			break;
			case 'P':
				if(strSlot.equals("00")) 
					strSlot="0";
			  	out.println(" <td class='OAGREEN' BORDERCOLOR='#FF0000' width='21px' align='center' style='word-wrap: break-word'  height='29px' id='cell"+pos+"_"+indexclor+"' OnMouseOver=\"Tip(BlockedToolTip('"+dateStr+"','"+strOperRoomCode+"','"+locale+"','"+facility_id+"'))\" onMouseOut=\"UnTip()\">");
				if(strFromValue.equals("1")==true && ComparingDate(dateStr))
					out.println(""+strSlot+"</td>");
				else
				{
					out.println("<a href=\"javascript:moveNext('"+dateStr+"','xx"+pos+"','VACANT','"+pos+"_"+indexclor+"');\">"+strSlot+" </a></td>");
					out.println("<input type='hidden' name='Hid_isVacant"+pos+"_"+indexclor+"' id='Hid_isVacant"+pos+"_"+indexclor+"' value='Y'>");
					out.println("<input type='hidden' name='fullVacantVal"+pos+"_"+indexclor+"' id='fullVacantVal"+pos+"_"+indexclor+"' value='VAC'>");
				}	
			break;	
			
			case 'Q':
		    	if(strSlot.equals("00")) 
	    		strSlot="0"; // character 'P' Fully booked Cases and Over Booking is Allowed
				borderc = "BORDERCOLOR='#FF0000'";
				if(strFromValue.equals("1")==true && ComparingDate(dateStr)){
				out.println(""+strSlot+"</td>");
				}	
				else
				{	
				%>
				<td class='OAFULL' BORDERCOLOR='#FF0000' align='center' width='21px' id='cell"+<%=pos%>+"_"+<%=indexclor%>+"' OnMouseOver="Tip(BlockedToolTip('<%=dateStr%>','<%=strOperRoomCode%>','<%=locale%>','<%=facility_id%>'));" onMouseOut='UnTip();'>
				<font color=white><a href="javascript:moveNext('<%=dateStr%>','xx'+<%=pos%>,'VACANT',<%=pos%>+'_'+<%=indexclor%>)"><%=strSlot%></a></font>
				</td>
				<input type='hidden' name='Hid_isVacant"+pos+"_"+indexclor+"' id='Hid_isVacant"+pos+"_"+indexclor+"' value='Y'>
				<input type='hidden' name='fullVacantVal' id='fullVacantVal'+<%=pos%>+'_'+<%=indexclor%>+' value='FOBY'>
				<%
				}				
			break;
			
		    //Vikash added for CRF-337 starts
			case 'R':
		    	if(strSlot.equals("00")) 
	    		strSlot="0"; // character 'R' Partial Blocked and Over Booking is Allowed
				borderc = "BORDERCOLOR='#FF0000'";
				if(strFromValue.equals("1")==true && ComparingDate(dateStr)){
				//out.print(" <td class='EMERGENT' align='center' width='21px' id='cell"+pos+"_"+indexclor+"'>");	
				out.println(""+strSlot+"</td>");
				}	
				else
				{	
				%>
				<td class='EMERGENT' BORDERCOLOR='#FF0000' align='center' width='21px' id='cell"+<%=pos%>+"_"+<%=indexclor%>+"' OnMouseOver="BlockedToolTip('<%=dateStr%>','<%=strOperRoomCode%>','<%=locale%>','<%=facility_id%>');" onMouseOut='hideToolTip1();'>
				<font color=white><a href="javascript:moveNext('<%=dateStr%>','xx'+<%=pos%>,'FULL_OVER_BOOKING_YES',<%=pos%>+'_'+<%=indexclor%>)"><%=strSlot%></a></font>
				</td>
				<input type='hidden' name='fullVacantVal' id='fullVacantVal'+<%=pos%>+'_'+<%=indexclor%>+' value='FOBY'>
				<%
				}				
			break;			
			//Vikash added for 337 ends
			//Added End for New Blocked Theatre CRF -337			
			
		}		   
	 //CRF-004.1 - 36448 
%><!-- 46615 Starts -->
	 <script>
	 	var posJS='<%=pos%>'; 
	 	var test="xx"+posJS;
		var customerId = document.getElementById('customerId').value;
	 if(customerId == 'MOHBR') //IN050472
	 	moveNext1('<%=dateStr%>', test, 'VACANT', '<%=indexclor%>', '<%=pos%>');
	 </script>
	 <!-- 46615 Ends -->
<%
	  indexclor++;
	//CRF-004.1 - 36448 
      }
		}
		out.println("</tr>");
	}
	catch(Exception ee)
	{
		ee.printStackTrace();
	}
	finally
	{
		callableStatement.close();
		hashSurgeonCode=null;
		hashSurgeonName=null;
		hashSpecificSplty=null;
		hashRoomCode=null;
		hashRoomDesc=null;
		if(overbook_rs !=null)	overbook_rs.close();
		if(overbook_pstmt!=null) overbook_pstmt.close();
		ConnectionManager.returnConnection(conn, request);
	}
%>	
<%!
	public boolean ComparingDate(String date)
	{
	boolean flag=true;
	try{
			String DATE_FORMAT = "dd/MM/yyyy";
			Calendar c1 = Calendar.getInstance(); 
			java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);

			Date preferdate = sdf.parse(date);   
			Date today = sdf.parse(sdf.format(c1.getTime()));   
	if(today.after(preferdate))    
	{    
		flag =true;
	}    
	else  
	{ 
		flag= false;
	}
	}catch(Exception ee){
		ee.printStackTrace();
	}
	return flag;
	}
%>
</table>

<input type='hidden' name='overBookingWindowYN' id='overBookingWindowYN' value="<%=overBookingWindowYN%>">
<input type='hidden' name='overbook_start_time' id='overbook_start_time' value="<%=overbook_start_time%>">
<input type='hidden' name='fpp_category' id='fpp_category' value="<%=fpp_category%>"> <!--ML-MMOH-CRF-1939-US005-->
<input type='hidden' name='selSurgeonCode' id='selSurgeonCode' id='selSurgeonCode' value="<%=selSurgeonCode%>"><!-- 051911 -->
</form>
<div name='tooltiplayer' id='tooltiplayer' style='position:absolute; width:30%; visibility:visible;' bgcolor='blue'>	
</div>
<script language='javascript'>assign();</script>
<Script src=\"../../eCommon/js/showModalDialog.js\" language=\"JavaScript\"></Script>



</body>
</html>

