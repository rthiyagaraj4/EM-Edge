/*
*Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
* 
*Warning: This computer program is protected by copyright law and international treaties.
*Unauthorized reproduction or distribution of this program, or any portion of it, 
*may result in severe civil and criminal penalties, and will be prosecuted to 
*the maximum extent possible under the law.
*/
//Declaration for Amazon Changes
var prevObjID;
var prevImgObj;
var disappeardelay= 250;

//Declaration for Amazon Changes ends

var ca_module_yn = "Y"; // Constant to check CA-OR module existence. If CA-OR exists, value is 'Y', otherwise its 'N'

function funCancelTransferSearch1(){

var frmObj=document.forms[0];
var locale = frmObj.locale.value;
var facility_id = frmObj.facility_id.value;
var change_from_date = dateUtils(frmObj.from_date.value,locale,"DMY");

var change_to_date = dateUtils(frmObj.to_date.value,locale,"DMY");


	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest();
	var params = "surgeon_code="+frmObj.SURGEON_CODE.value+"&theatre_type_code="+frmObj.theatre_type_code.value+"&speciality_code="+frmObj.SPECIALITY_CODE.value+"&room_code="+frmObj.room_code.value+"&patientid="+frmObj.patientid.value+"&patientName="+frmObj.patientName.value+"&change_from_date="+change_from_date+"&change_to_date="+change_to_date;
	var xmlStr ="<root><SEARCH ";
	xmlStr +=" /></root>";
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST","CommonValidation.jsp?func_mode=cancelTransferCount&"+params,false);
	xmlHttp.send(xmlDoc);
	var retVal = trimString(xmlHttp.responseText);

//		if (retVal==0){
//				callNoRecord1();
//		}
if(checkDate()){

if(change_from_date!=''){
		var sql="SELECT APPT_REF_NUM APPT_REF_NUM1, SURGEON_CODE SURGEON_CODE1,ORDER_ID ORDER_ID1, to_char(APPT_DATE,'dd/mm/yyyy') APPT_DATE1, PATIENT_ID PATIENT_ID1, (select decode( '"+locale+"' ,'en',nvl(patient_name,patient_name_loc_lang), nvl(patient_name_loc_lang,patient_name)) from mp_patient where patient_id = A.patient_id ) PATIENT_NAME1,OPER_ROOM_DESC OPER_ROOM_DESC1, TO_CHAR (appt_from_time, 'DD/MM/YYYY HH24:MI:SS') APPTFROMDATETIME, TO_CHAR (appt_to_time, 'DD/MM/YYYY HH24:MI:SS') APPTTODATETIME, to_char(APPT_FROM_TIME,'hh24:mi') APPT_FROM_TIME1, to_char(APPT_TO_TIME,'hh24:mi')  APPT_TO_TIME1,SPECIALITY_DESC SPECIALITY_DESC1,SPECIALITY_CODE SPECIALITY_CODE1, SURGEON_NAME SURGEON_NAME1 FROM OT_SCHD_OPERS_VW A  where OPERATING_FACILITY_ID = '"+frmObj.facility_id.value+"' and A.LANGUAGE_ID='"+locale+"' ";
		var where="";

		if(frmObj.SPECIALITY_CODE.value!=null && frmObj.SPECIALITY_CODE.value!='')
			where=escape("  and instr(NVL(ALL_SPECIALITY_CODES,SPECIALITY_CODE),'#"+frmObj.SPECIALITY_CODE.value+"#') > 0 ");


		if(frmObj.theatre_type_code.value!=null && frmObj.theatre_type_code.value!='')
		where+=escape(" and OPER_ROOM_CODE IN (SELECT OPER_ROOM_CODE FROM OT_OPER_ROOM WHERE OPERATING_FACILITY_ID='"+facility_id+"' AND THEATRE_TYPE='"+frmObj.theatre_type_code.value+"')");


		if(frmObj.SURGEON_CODE.value!=null && frmObj.SURGEON_CODE.value!='')
		where+=escape(" and SURGEON_CODE ='"+frmObj.SURGEON_CODE.value+"'");

if(frmObj.room_code.value!=null && frmObj.room_code.value!='')
	where+=escape(" and OPER_ROOM_CODE ='"+frmObj.room_code.value+"'");


		if((change_from_date!=null && change_from_date!='')||(change_to_date!=null && change_to_date!=''))
		 where +=escape(" AND APPT_DATE  BETWEEN TO_DATE(NVL('"+change_from_date+"','01/01/1900')||'00:00', 'DD/MM/YYYY HH24:MI') AND TO_DATE(NVL('"+change_to_date+"','01/01/3000')|| '23:59','DD/MM/YYYY HH24:MI')");

		if((frmObj.ref_no.value !=null && frmObj.ref_no.value!='')||(frmObj.ref_no.value!=null && frmObj.ref_no.value!=''))
			where+= escape(" AND APPT_REF_NUM ='"+frmObj.ref_no.value+"' ");


		if(frmObj.patientid.value!=null && frmObj.patientid.value!='')
			   where+=escape(" and PATIENT_ID ='"+frmObj.patientid.value+"'");
		else
		 if(frmObj.patientName.value!=null&&frmObj.patientName.value!='')
				where+= escape(" and UPPER(patient_name) like UPPER('"+frmObj.patientName.value+"%')");

		where += escape(" AND OPER_NUM IS NULL ");
		where += escape(" AND NVL(BOOKING_STATUS,'X') != '9' AND NVL(OPER_STATUS,'XX') <> '99' ");

		sql+=where;
			var param='sql='+sql+'&date_compare='+dateUtils(frmObj.date_compare.value,locale)+'&cancel_yn='+frmObj.cancel_yn.value+'&transfer_yn='+frmObj.transfer_yn.value+"&speciality_code="+frmObj.SPECIALITY_CODE.value+"&surgeon_code="+frmObj.SURGEON_CODE.value+"&ref_no="+frmObj.ref_no.value+"&patient_id="+frmObj.patientid.value+"&patient_name="+frmObj.patientName.value+"&from_date="+frmObj.from_date.value+"&to_date="+frmObj.to_date.value+"&room_code="+frmObj.room_code.value+"&theatre_type_code="+frmObj.theatre_type_code.value+"&room_code="+frmObj.room_code.value+"&restrict_theatre_booking_yn="+frmObj.restrict_theatre_booking_yn.value+"&book_yn="+frmObj.book_yn.value+"&function_id="+frmObj.function_id.value;
				//parent.qa_query_result.location.href = '../../eOT/jsp/PendingOrderDtl.jsp?'+param;
		parent.qa_query_result.location.href = '../../eOT/jsp/CancelTransferDtlFrm.jsp?'+param;
	}else{
		 var msg = getMessage("CANNOT_BE_BLANK","OT");
		 var msgArray = msg.split("&");
		 alert(msgArray[0]+getLabel("Common.AppointmentDate.label","Common")+msgArray[1]);
	}
}
}


//Newly added for Amazon Changes......

function hideToolTip(obj,imgObj,row)
	{
		dynamichide(obj, window.event,row);
	}

function callMouseOver(obj)	{
	currClass = obj.className ;
	obj.className = 'selectedcontextMenuItem';

}

function callOnMouseOut(obj){
	obj.className = 'contextMenuItem';
}


function resizeWindow(orderctlHDR)
{
	var orderctlHDR1 = orderctlHDR.id;
  //var wdth = eval("document.all."+orderctlHDR1).offsetWidth;
	//var hght1 = eval("document.all."+orderctlHDR1).offsetHeight;
	var wdth = eval(document.getElementById(orderctlHDR1)).offsetWidth;
	var hght1 = eval(document.getElementById(orderctlHDR1)).offsetHeight;

	var wdth1 = getPos(orderctlHDR).x +wdth;
	var hght = getPos(orderctlHDR).y ;

	bodwidth  = document.body.offsetWidth
	bodheight = document.body.offsetHeight

	var z = bodwidth- (event.x + wdth);

	var x 	  = event.x;
	var y 	  = event.y;

	x 	  = x + (document.getElementById("tooltiplayer").offsetWidth);
	y 	  = hght + (document.getElementById("tooltiplayer").offsetHeight);

	if(x<bodwidth){
		x= wdth1;
	}else{
		x = getPos(orderctlHDR).x;
	}
	if(y<bodheight){
		y = hght;

	}else
	{
		y = y - (document.getElementById("tooltiplayer").offsetHeight*2) + hght1 ;
	}
	document.getElementById("tooltiplayer").style.left= x+"px";
	document.getElementById("tooltiplayer").style.top = "17px";
	document.getElementById("tooltiplayer").style.visibility='visible'
}

function callMouseOverOnTD(obj,imgObj){
		 if (prevObjID != null && prevObjID != obj.id)
		 {
     	 //eval("document.all."+prevObjID).className = 'gridDataBlue';
			 //eval("document.all."+prevImgObj).src = "../../eCommon/images/inactiveArrow.gif";
			 eval(document.getElementById(prevObjID)).className = 'gridDataBlue';
			 eval(document.getElementById(prevImgObj)).src = "../../eCommon/images/inactiveArrow.gif";
		 }
		obj.className = 'selectedTDData';
    //eval("document.all."+imgObj).src = "../../eCommon/images/activeArrow.gif";
		eval(document.getElementById(imgObj)).src = "../../eCommon/images/activeArrow.gif";
		prevObjID = obj.id;
		prevImgObj = imgObj;
	}

function getPos(inputElement) {
    var coords =  new Object();
    coords.x = 0;
    coords.y = 0;
    try {
        targetElement = inputElement;
        if(targetElement.x && targetElement.y) {
            coords.x = targetElement.x;
            coords.y = targetElement.y;
        } else {
            if(targetElement.offsetParent) {
                coords.x += targetElement.offsetLeft;
                coords.y += targetElement.offsetTop;
                while(targetElement = targetElement.offsetParent) {
                    coords.x += targetElement.offsetLeft;
                    coords.y += targetElement.offsetTop;
                }
            }
        }
        return coords;
    } catch(error) {
        //alert(error.msg);
        return coords;
    }
}

function dynamichide(m, e,row)
{
		if (!this.isContained(m, e))
		{
			this.delayhidemenu(row)
		}
}

function isContained(m, e)
{
		var e=window.event || e
		var c=e.relatedTarget || ((e.type=="mouseover")? e.fromElement : e.toElement)
		while (c && c!=m)try {c=c.parentNode} catch(e){c=m}
		if (c==m)
			return true
		else
			return false
}

function delayhidemenu(row)
{
		this.delayhide=setTimeout("hidemenu()", this.disappeardelay) //hide menu
		if(eval(document.getElementById("orderctl"+row)))
			eval(document.getElementById("orderctl"+row)).className='gridDataBlue';
		if(eval(document.getElementById("imgArrow"+row)))
			eval(document.getElementById("imgArrow"+row)).src = "../../eCommon/images/inactiveArrow.gif";
}

function hidemenu()
{
	document.getElementById("tooltiplayer").style.visibility = 'hidden';
}
//Amazon Changes Ends Here....




function openHistory(patient_id)
{
 var formObj=document.forms[0];
 var encounter_id=formObj.encounter_id.value;
 var patient_class=formObj.patient_class.value;
 var HTML = "<html>"
 HTML += "<form name='historyForm' id='historyForm' action='../../eCA/jsp/OpenChartWrapper.jsp'>";
 HTML += "<input type='hidden' name='insert_op' id='insert_op' value= 'N'>";
 HTML += "<input type='hidden' name='patient_id' id='patient_id' value= '" + patient_id  + "'>";
 HTML += "<input type='text' name='encounter_id' id='encounter_id' value= '" + encounter_id + "'>";
 HTML += "<input type='text' name='patient_class' id='patient_class' value= '" + patient_class + "'>";
 HTML += "</form>";
 HTML += "</html>";

parent.parent.parent.messageFrame.document.body.insertAdjacentHTML("BeforeEnd", HTML);
parent.parent.parent.messageFrame.document.historyForm.submit();
}


function commonDisplayTooltip(arrObj,arrObj1,param,orderctlHDR,imgObj){

var menu_id_list		= new Array();
var	menu_name_list	= new Array();
menu_id_list=arrObj.split(",");
menu_name_list=arrObj1.split(",");
callMouseOverOnTD(orderctlHDR,imgObj);
var tab_dat  = "<table id='tooltiptable1' class='contextMenu' width='100%' height='100%' align='center' style=' z-index: 1000;background-color: #d9d9d9;border: 1px solid #ccc;box-shadow: 0 2px 10px rgba(0, 0, 0, 0.2);position: absolute;'>";
	for( var i=0; i<menu_name_list.length; i++ )
		{
		var id_colval		= menu_id_list[i];
		var id_name_colval  = menu_name_list[i];
		if(id_colval!=""){
			tab_dat     += "<tr>"
			tab_dat     += "<td class = 'contextMenuItem' nowrap id='mouse' onMouseOver='callMouseOver(this)' ><a class='contextMenuLink' href = \"javascript:callItemSelect1('"+id_colval+"','"+param+"');\">"+id_name_colval + " </a> </td>"
			tab_dat     += "</tr> ";
		}
	}
	tab_dat     += "</table> ";
	document.getElementById("tooltiplayer").innerHTML = tab_dat;
	resizeWindow(orderctlHDR);
}
//CRF-96.5
function commonDisplayTooltip_Oper(arrObj,arrObj1,param,orderctlHDR,imgObj){
var formObj = document.forms[0];
var customer_id=formObj.customer_id1.value;
var menu_id_list		= new Array();
var	menu_name_list	= new Array();
var	menu_name_list1	= new Array();
menu_id_list=arrObj.split(",");
menu_name_list=arrObj1.split(",");
callMouseOverOnTD(orderctlHDR,imgObj);
var tab_dat  = "<table id='tooltiptable1' class='contextMenu' width='100%' height='100%' align='center' style='z-index: 1000;background-color: #d9d9d9;border: 1px solid #ccc;box-shadow: 0 2px 10px rgba(0, 0, 0, 0.2);position: absolute;'>";
	for( var i=0; i<menu_name_list.length; i++ )
		{
		var id_colval		= menu_id_list[i];
		var id_name_colval  = menu_name_list[i];
		if(id_colval!=""){
			tab_dat     += "<tr>"
			tab_dat     += "<td class = 'contextMenuItem' nowrap id='mouse' onMouseOver='callMouseOver(this)' ><a class='contextMenuLink' href = \"javascript:callItemSelect1('"+id_colval+"','"+param+"');\">"+id_name_colval + " </a> </td>"
			tab_dat     += "</tr> ";
		}
	}
	tab_dat     += "</table> ";
	document.getElementById("tooltiplayer").innerHTML = tab_dat;
	resizeWindow(orderctlHDR);
}
//CRF-96.5
function getPatientName(patient_id){
var sql="select patient_name  from mp_patient where patient_id='"+patient_id+"' ";
var param="sql="+sql;
var xmlDoc = "";
var xmlHttp = new XMLHttpRequest();
var xmlStr="<root></root>";
//xmlDoc.loadXML(xmlStr);
xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
xmlHttp.open("POST", "../../servlet/eOT.CommonQueryServlet?"+param,false);
xmlHttp.send(xmlDoc);
var return_val=xmlHttp.responseText;
var rtn_val=eval(return_val);
return rtn_val;
}

function rescheduleCount(ref_no,patient_id)
{
var facilityid=document.forms[0].facilityid.value;
var function_id=document.forms[0].function_id.value;
var pat_name=getPatientName(patient_id);
var patient_name2=pat_name.replace("'","");//MMSSIM
var sql="select NVL(RESCHEDULED_COUNT,0)  from OT_BOOKING_HDR where BOOKING_NUM ='"+ref_no+"' and operating_facility_id='"+facilityid;
var param="sql="+sql;
var xmlDoc = "";
var xmlHttp = new XMLHttpRequest();
var xmlStr="<root></root>";
//xmlDoc.loadXML(xmlStr);
xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
xmlHttp.open("POST", "../../servlet/eOT.CommonQueryServlet?"+param,false);
xmlHttp.send(xmlDoc);;
var resTxt=xmlHttp.responseText;
var cou=eval(resTxt);
var count=parseInt(cou,10);
count=count+1;
var suffix = "";
if(count==1)
	suffix = "st";
else if(count==2)
	suffix = "nd";
else if(count==3)
	suffix = "rd";
else
	suffix = "th";
if(count == 1 || count > 1){
	var msg_1 = getMessage("APP-OT0081","OT");
	var msgArr=msg_1.split("$");
	var msgArray = msgArr[1].split("&");
	alert(msgArr[0]+" "+patient_name2+" ("+patient_id+") "+msgArray[0]+count+suffix+msgArray[1])//MMSSIM
	}

}

function setAssignValue(dat){
	return dat;
}


async function  callItemSelect1(obj,param)
{
	
	
	var frmObj=document.forms[0];
	if(obj=='CT1'){
		if(frmObj.restrict_theatre_booking_yn.value=="Y" && frmObj.cancel_yn.value=="N"){
			alert(getMessage("APP-OT0090C","OT"));
		}else{
			var arr=new Array();
			arr=param.split(",");
			var patient_id=arr[8];
			showBookingCancelTransfer(arr[0],arr[1],arr[7],patient_id);
		}
	}else if(obj=='CT2'){
		//var surgeon_code1= frmObj.login_user.value;

		//if(frmObj.restrict_theatre_booking_yn.value=="Y" && (frmObj.transfer_yn.value=="N" || frmObj.book_yn.value=="N")){ As told by dilip commented by sathish on 17-06-2010
		if(frmObj.restrict_theatre_booking_yn.value=="Y" && frmObj.transfer_yn.value=="N"){
			alert(getMessage("APP-OT0090T","OT"));
		}else{
			var par =new Array();
			par=param.split(",");
			var locale = frmObj.locale.value;
			rescheduleCount(par[0],par[8]);
			var surgeonName=eval("frmObj.xx"+par[3]).value;
			var specialityDesc=eval("frmObj.splty"+par[6]).value;
			var function_id=document.forms[0].function_id.value;
			var param="booking_no="+par[0]+"&surgeonCode="+par[2]+"&funflag=2&surgeonName="+encodeURIComponent(surgeonName)+"&prefDate="+convertDate(par[4],"DMY","en",locale)+"&speciality_code="+par[5]+"&speciality_desc="+encodeURIComponent(specialityDesc)+"&function_id="+function_id+"&startTime="+par[9]+"&endTime="+par[10]+"&patientId="+par[8];// 44528 - Chaitanya PMG MOD-0024 US-3

	parent.parent.parent.frames[1].location.href="../../eOT/jsp/CalendarFrame.jsp?"+param;
		}
	}else if(obj=='RS1'||obj=='BQ1'){

		var par =new Array();
		par=param.split(",");
		var dialogHeight 		= "100vh";
		var dialogWidth  		= "100vw";
		var dialogTop   		= "0";
		var dialogLeft   		= "0";
		var features			= "dialogLeft:"+dialogLeft+";dialogTop:"+dialogTop+";dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +";status=no";
		var arguments			= "";
		if(par[2].indexOf("*")>=0){
			par[2] = par[4];
		}
		//Modified by rajesh for reset button hiding on 12/09/07
		//var	param="booking_no="+par[0]+"&facility_id="+par[1]+"&orderid=0"+"&transfer=5&patient_id="+par[2];
		var	param="booking_no="+par[0]+"&facility_id="+par[1]+"&orderid=0"+"&transfer=5&patient_id="+par[2]+"&menu_required_yn=N";


		retVal=await top.window.showModalDialog("../../eOT/jsp/BookingDetailFrame.jsp?"+param,arguments,features);
	}

	if(obj=='RS3'){
				//Added by rajesh for INc 21173
				var fomObj=document.forms[0];
				/*var strBookingNum=frmObj.strBookingNum.value;
				var patient_id=frmObj.strPatientId.value;
				rescheduleCount(strBookingNum,patient_id);*/
				//Added if condition against SPR-6352 by sathish on 04/11/2008
				var restrictTheatreBookingYN = frmObj.restrictTheatreBookingYN.value;
				var strBookingYN = frmObj.strBookingYN.value;
				var transfer_schedule_yn = frmObj.transfer_schedule_yn.value;
				//var surgeon_code= document.forms[0].login_user.value;
				//if(restrictTheatreBookingYN=="Y" && (transfer_schedule_yn=="N" || strBookingYN=="N"))
				if(restrictTheatreBookingYN=="Y" && transfer_schedule_yn=="N" )
				{
				  alert(getMessage("APP-OT0090T","OT"));
				}
				else
				{
				var par=new Array();
				par=param.split(",");
				var frmObj=document.forms[0];
				rescheduleCount(par[0],par[2]);
				var surgeonName=eval("frmObj.xx"+par[5]+".value");
				var specialityDesc=eval("frmObj.splty"+par[5]+".value");
				var function_id=document.forms[0].function_id.value;
				//param="booking_no="+par[0]+"&surgeonCode="+par[2]+"&funflag=2&surgeonName="+surgeonName+"&speciality_code="+par[4]+"&speciality_desc="+specialityDesc;
				var param="booking_no="+par[0]+"&surgeonCode="+par[3]+"&funflag=2&surgeonName="+surgeonName+"&speciality_code="+par[4]+"&speciality_desc="+specialityDesc+"&orderid="+par[6]+"&function_id="+function_id+"&startTime="+par[7]+"&endTime="+par[8]+"&patientId="+par[2];//047067 Bharati PMG MOD-0024 US-3
				parent.parent.parent.frames[1].location.href="../../eOT/jsp/CalendarFrame.jsp?"+param;
				}
	}

	if(obj=='RS2'||obj=='BQ4'){
		var par =new Array();
		par=param.split(",");
		//var dialogHeight 		=window.screen.availWidth;// "40";
		//var dialogWidth  		= window.screen.availHeight//"80";
		var dialogHeight 		= "100vh";
		var dialogWidth  		= "100vw";
		var dialogTop   		= "0";
		var dialogLeft   		= "0";
		var features			= "dialogLeft:"+dialogLeft+";dialogTop:"+dialogTop+";dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +";status=no";
		var arguments			= "";
		var	param="booking_no="+par[0]+"&patient_id="+par[2];
		retVal=await top.window.showModalDialog("../../eOT/jsp/PreRescheduleFrame.jsp?"+param,arguments,features);
	}
	if(obj=='RS4'){
		if(ca_module_yn=="N"){
			alert(getMessage("CA_NOT_INSTALLED","Common"));
			return;
		}
		var dialogHeight 		= "100vh";
		var dialogWidth  		= "100vw";
		var dialogTop   		= "0";
		var dialogLeft   		= "0";
		var features			= "dialogLeft:"+dialogLeft+";dialogTop:"+dialogTop+";dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +";status=no";
		var arguments			= "";
		var par =new Array();
		par=param.split(",");
		var frmObj=document.forms[0];
		var objst=eval("frmObj.patsexdob"+par[5]+".value");
		var par1=new Array();
		par1=objst.split("::");
		var surgeryhistory_legend = getLabel("eOT.SurgeryHistory.Label","OT");

		var	param="patient_id="+par1[0]+"&patient_name="+par1[1]+"&sex="+par1[2]+"&dob="+par1[3]+"&called_from=OPER_REG&function_name="+encodeURIComponent(surgeryhistory_legend);
		retVal=await top.window.showModalDialog("../../eOT/jsp/SurgeryHistory.jsp?"+param,arguments,features);
	}

	if(obj=='RS5'){
		if(ca_module_yn=="N"){
			alert(getMessage("CA_NOT_INSTALLED","Common"));
			return;
		}

		var par=new Array();
		par=param.split(",");
		openHistory(par[2]);
	}

	if(obj=='RS6'){
		var par=new Array();
		par=param.split(",");
		//var dialogHeight 		= window.screen.availHeight;
		//var dialogWidth  		= window.screen.availWidth;
		var dialogHeight 		= "100vh";
		var dialogWidth  		= "100vw";
		var dialogTop   		= "0";
		var dialogLeft   		= "0";
		var features			= "dialogLeft:0dialogTop:0;dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +";status=no";
		var arguments			= "";
		var param ="booking_no="+par[0]+"&facility_id="+par[1]+"&orderid="+par[6]+"&called_from=CancelTransfer&menu_required_yn=Y";
		var restrictTheatreBookingYN = frmObj.restrictTheatreBookingYN.value;
		var strBookingYN = frmObj.strBookingYN.value;

		/* Below Two lines added against Inc.no 12400  */
		if(restrictTheatreBookingYN=="")restrictTheatreBookingYN="Y";
		if(strBookingYN=="")strBookingYN="N";

		var cancel_schedule_yn = frmObj.cancel_schedule_yn.value;
		// Added if(cancel_schedule_yn=="N"){ condition against SPR-6352 by sathish on 04/11/2008
		if(restrictTheatreBookingYN=="Y"){

			if(cancel_schedule_yn=="N"){
			alert(getMessage("APP-OT0090C","OT"));
		    }
			else if(strBookingYN=="N"){
				alert(getMessage('APP-OT0092','OT'));
			}else{
			retVal=await top.window.showModalDialog("../../eOT/jsp/BookingDetailFrame.jsp?"+param,arguments,features);
			parent.location.reload();
			}
		}else{
			retVal=await top.window.showModalDialog("../../eOT/jsp/BookingDetailFrame.jsp?"+param,arguments,features);
			parent.location.reload();
		}
	}

	if(obj=='BQ5'){
		//var dialogHeight 		= window.screen.availHeight;
		//var dialogWidth  		= window.screen.availWidth;
		var dialogHeight 		= "100vh";
		var dialogWidth  		= "100vw";
		var dialogTop   		= "0";
		var dialogLeft   		= "0";
		var features			= "dialogLeft:0dialogTop:0;dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +";status=no";
		var arguments			= "";
		var par=new Array();
		par=param.split(",");
		var param="booking_no="+par[0]+"&facility_id="+par[1]+"&Patient_ID="+par[2];
		retVal=await top.showModalDialog("../../eMP/jsp/ViewPatDetailsMain.jsp?"+param,arguments,features);
	}

	if(obj=='BQ2'){
		//var dialogHeight 		= window.screen.availHeight;
		//var dialogWidth  		= window.screen.availWidth;
		var dialogHeight 		= "100vh";
		var dialogWidth  		= "100vw";
		var dialogTop   		= "0";
		var dialogLeft   		= "0";
		var features			= "dialogLeft:0;ssdialogTop:0;dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +";status=no";
//		var features			= "dialogTop:"+dialogTop+"dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +";status=no";
		var arguments			= "";
		var par=new Array();
		par=param.split(",");
		var param = "booking_no="+par[0]+"&facility_id="+par[1]+"&cancel_flag=1&called_from=BookingQry";

		retVal=await top.window.showModalDialog("../../eOT/jsp/BookingDetailFrame.jsp?"+param,arguments,features);
	}

	if(obj=='BQ3'){
		var dialogHeight 		= "100vh";
		var dialogWidth  		= "100vw";
		var dialogTop   		= "10";
		var dialogLeft   		= "50";
		var features			= "dialogTop:"+dialogTop+"dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +";status=no";
		var arguments			= "";
		var par=new Array();
		par=param.split(",");
		//Modified by Satish for SCF 2088 on 22-05-08
		//var param = "waitlist_no="+par[3]+"&facility_id="+par[1];
		var param = "waitlist_no="+par[3]+"&facility_id="+par[1]+"&menu_required=N";
		retVal=await top.window.showModalDialog("../../eOT/jsp/WaitListDtlViewFrm.jsp?"+param,arguments,features);
	}

	//Reprint Appointment Slip IN34756 - Rajesh V 07/11/2012
	if(obj=='BQ6'){
		var par = param.split(",");
		var xmlDoc = "" ;
		var xmlHttp = new XMLHttpRequest() ;
		var xmlStr ="<root><SEARCH ";
		xmlStr +=" /></root>";
		var param="func_mode=pat_gender_check&patient_id="+par[2];
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open("POST","../../eOT/jsp/OTCommonValidation.jsp?"+param,false);
		xmlHttp.send(xmlDoc);
		var retVal = localTrimString(xmlHttp.responseText);
		var patgender = retVal;
		var params1="nd_booking_num="+par[0]+"&sex="+patgender+"&p_module_id="+"OT"+"&p_report_id="+"OTRNOTIF"+"&nd_facility_id="+par[1]+"&facility_id="+par[1]+"&Patient_ID=" + par[2];

		//Reprint Appointment Slip IN34756 - Rajesh V 30/10/2012
		var sql="select report_id, report_desc, 1 no_of_copies, module_id from sm_report_lang_vw where module_id = 'OT' AND REPORT_ID = 'OTRNOTIF' and language_id = 'en'";
		//var dialogHeight	= '25' ;
		//var dialogWidth		= '65' ;
		var dialogHeight 		= "80vh";
		var dialogWidth  		= "70vw";
		var dialogTop		= 58;
		var arguments		= '';
		var getUrl			= "../../eOT/jsp/PrintAppointmentSlip.jsp?"+params1;
		var features    = 'dialogHeight:' + dialogHeight + '; dialogWidth:' + dialogWidth +'; status=no;';
		retVal=   await window.showModalDialog(getUrl,arguments,features);
		if ( retVal != null ) {
			retVal		= "../../eCommon/jsp/report_process.jsp?" + retVal ;
			var myBars 		= 'directories=no,location=no,menubar=no' ;
			var myOptions 	= 'width=' + window.screen.availwidth + ', height=' + window.screen.availheight + ', resizable=yes' ;
			var myFeatures 	= myBars + ', ' + myOptions ;
			var reportWindow 	= open( retVal, '_blank', myFeatures ) ;
			reportWindow.title= "Medicom Report Viewer" ;
			reportWindow.resizeTo( screen.availWidth, screen.availHeight ) ;
			reportWindow.moveTo( 0,0 ) ;
			reportWindow.focus() ;
		}
		//Reprint Appointment Slip IN34756 - Rajesh V 30/10/2012
	}
	//Added for IN:41808
	if(obj=='BQ7'){
		var par = param.split(",");
		var xmlDoc = "" ;
		var xmlHttp = new XMLHttpRequest() ;
		var xmlStr ="<root><SEARCH ";
		xmlStr +=" /></root>";
		var param="func_mode=pat_gender_check&patient_id="+par[2];
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open("POST","../../eOT/jsp/OTCommonValidation.jsp?"+param,false);
		xmlHttp.send(xmlDoc);
		var retVal = localTrimString(xmlHttp.responseText);
		var patgender = retVal;
		var params1="nd_booking_num="+par[0]+"&sex="+patgender+"&p_module_id="+"OT"+"&p_report_id="+"OTOSIDEN"+"&nd_facility_id="+par[1]+"&facility_id="+par[1]+"&Patient_ID=" + par[2];
		var sql="select report_id, report_desc, 1 no_of_copies, module_id from sm_report_lang_vw where module_id = 'OT' AND REPORT_ID = 'OTOSIDEN' and language_id = 'en'";
		//var dialogHeight	= '25' ;
		//var dialogWidth		= '65' ;
		var dialogHeight 		= "80vh";
		var dialogWidth  		= "70vw";
		var dialogTop		= 58;
		var arguments		= '';
		var getUrl			= "../../eOT/jsp/OperatingSiteIdentification.jsp?"+params1;
		var features    = 'dialogHeight:' + dialogHeight + '; dialogWidth:' + dialogWidth +'; status=no;';
		retVal=   await window.showModalDialog(getUrl,arguments,features);
		if ( retVal != null ) {
			retVal		= "../../eCommon/jsp/report_process.jsp?" + retVal ;
			var myBars 		= 'directories=no,location=no,menubar=no' ;
			var myOptions 	= 'width=' + window.screen.availwidth + ', height=' + window.screen.availheight + ', resizable=yes' ;
			var myFeatures 	= myBars + ', ' + myOptions ;
			var reportWindow 	= open( retVal, '_blank', myFeatures ) ;
			reportWindow.title= "Medicom Report Viewer" ;
			reportWindow.resizeTo( screen.availWidth, screen.availHeight ) ;
			reportWindow.moveTo( 0,0 ) ;
			reportWindow.focus() ;
		}

	}
	//CRF -RUT-0092
		if(obj=='BQ8')
		{
			var fomObj = document.forms[0];
			var order_id = fomObj.order_id.value;
			var par =new Array();
			par=param.split(",");
			//var dialogHeight 		= window.screen.availWidth;
			//var dialogWidth  		= window.screen.availHeight
			var dialogHeight 		= "100vh";
			var dialogWidth  		= "100vw";
			var dialogTop   		= "0";
			var dialogLeft   		= "0";
			var features			= "dialogLeft:"+dialogLeft+";dialogTop:"+dialogTop+";dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +";status=no";
			var arguments			= "";
			if(par[2].indexOf("*")>=0)
			par[2] = par[4];
			var	param="booking_no="+par[0]+"&facility_id="+par[1]+"&transfer=8&patient_id="+par[2]+"&orderid="+par[4]+"&statusDesc="+par[5]+"&strTheatreDesc="+par[6]+"&strSurgeonName="+par[7]+"&strAneasthetistName="+par[8]+"&strBookingDate="+par[9]+"&strOperDesc="+par[10]+"&strSpecialityDesc="+par[11];
			retVal=await top.window.showModalDialog("../../eOT/jsp/ItemRequestDetail.jsp?"+param,arguments,features);
		}
	//End 0092 & 41808
	hideToolTip();
}

function hideToolTip(){
  var temp = document.getElementById("tooltiplayer");
  if(temp)
	  temp.style.visibility = 'hidden';
}



async function showBookingCancelTransfer(bookNo,facility,orderid,patient_id)
{
var frmObj=document.forms[0];

		 dialogHeight = '100vh' ;
		 dialogWidth  = '100vw' ;
		 dialogTop    = '0';
		 dialogLeft   = '30';
		 features     = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth+ "; dialogLeft:" + dialogLeft+ "; dialogTop:" +dialogTop+ "; status=no" ;


//var param = "booking_no="+bookNo+"&facility_id="+facility+"&orderid="+orderid+"&patient_id="+patient_id+"&called_from=CancelTransfer";
var param = "booking_no="+bookNo+"&facility_id="+facility+"&orderid="+orderid+"&patient_id="+patient_id+"&called_from=CancelTransfer&menu_required_yn=Y";

retVal=await top.window.showModalDialog("../../eOT/jsp/BookingDetailFrame.jsp?"+param,arguments,features);
			parent.location.reload();

//parent.frames[0].location.href="../../eOT/jsp/CancelTransferDtlFrm.jsp?"+frmObj.param1.value;
//retVal=window.showModalDialog("../../eOT/jsp/OTGeneralSearchFrames.jsp?"+param,arguments,features);
//return retVal;

}
/*function apply()
{
var messageFram = parent.content.messageFrame;
messageFram.document.location.href="../../eCommon/jsp/error.jsp?err_num="+"";
}*/

async function apply(){
	//var objFrm=parent.header_frame.document.forms[0];
	//var objCancel=	parent.message_search_frame.detailframe.document.forms[0];
	//var objOperDtl=parent.message_search_frame.message_search_frame.detailframe.document.forms[0];

	var objFrm=header_frame.document.forms[0];
	var objCancel=	message_search_frame.detailframe.document.forms[0];
	var objOperDtl=message_search_frame.message_search_frame.detailframe.document.forms[0];

	var flagtime=true;

	var flagValue=objFrm.flag.value;
	var locale=objCancel.locale.value;
	var over_booking_case_yn = objCancel.over_booking_case_yn.value;

	var facility_id = objCancel.facility_id.value;
	var booking_num = objCancel.booking_num.value;
	var startTime = objCancel.startTime.value;// 44528 - Chaitanya
	var endTime = objCancel.endTime.value;
	var overlapChkStartTime = objOperDtl.start_time.value;
	var overlapChkEndTime = objCancel.newTime.value;

	var param="";

	//var messageFrame=parent.messageFrame;
	var booking_date_time = getBookingDateTime(facility_id,booking_num);
	var reason_code = objCancel.reason_code.value;
	var called_from = objCancel.called_from.value;
	var function_id = objCancel.function_id.value;
	/*if(objCancel.reason_code.value == '' || objCancel.reason_code.value == null)
		var error=getMessage("REASON_CODE_NOT"); */
		var msg_blank = getMessage("CANNOT_BE_BLANK","OT");
		var overLapMasg = getMessage("PRC-OT0006","OT");// 44528 - Chaitanya
		var overLapMasg1 = getMessage("PRC-OT0060","OT");//047067 Bharati
		var msgArray = msg_blank.split("&");
		var msg_canot_blank = msgArray[0]+" Reason "+msgArray[1];
		var msg_blank1 = getMessage("DATE1_NOT_GREATER_THAN_DATE2","OT");
		var msg_blank2 = getMessage("DATE1_NOT_LESSER_THAN_DATE2","OT");
		var msgArray1 = msg_blank1.split("#");
		var msgArray2 = msg_blank2.split("#");

		//var error = (reason_code=='' || reason_code.length==0)?getOTMessage("REASON_CODE_NOT")+"<BR>":"";
		var error = (reason_code=='' || reason_code.length==0)?msg_canot_blank+"<BR>":"";

		var er_msg_blank = getMessage("CANNOT_BE_BLANK","OT");
		var er_msg_blank1 = getMessage("DATE1_NOT_GREATER_THAN_DATE2","OT");
		var er_msg_blank2 = getMessage("DATE1_NOT_LESSER_THAN_DATE2","OT");
		var er_msgArray = msg_blank.split("&");
		var er_msgArray1 = msg_blank1.split("#");
		var er_msgArray2 = msg_blank2.split("#");
		var er_msg_canot_blank = "";


		if(called_from=="CancelTransfer"){
			if(objCancel.ward_informed_yn.checked==true){
				var informed_date = objCancel.inform_date.value;
				var informed_time = objCancel.inform_time.value;
				var inform_date_time = trmString(objCancel.inform_date.value+" "+objCancel.inform_time.value);
				inform_date_time=convertDate(inform_date_time,"DMYHM",locale,"en");
				if(informed_date==''||informed_time==''){
					//error+="APP-OT0025 Date/Time Should be entered...<BR>";
					er_msg_canot_blank = msgArray[0]+" "+getLabel("Common.InformedDate/Time.label","Common")+" "+msgArray[1];
					error+=er_msg_canot_blank +"...<BR>";
				}
				var cancelled_remarks = trmString(objCancel.cancelled_remarks.value);
				if(cancelled_remarks.length==0 && cancelled_remarks==""){
				//	error+=" APP-OT0026 Cancel Remarks should be entered...<BR>";
					er_msg_canot_blank = msgArray[0]+" "+getLabel("Common.CancelRemarks.label","Common")+" "+msgArray[1];
					error+=er_msg_canot_blank+"...<BR>";
				}
				if(!sysDateValidation(inform_date_time)){
				//	error+="APP-OT0027 Informed Date/Time should < sysdate and Time...<BR>";
				//DATE1_NOT_GREATER_THAN_DATE2","APP-OT0007 # should not be greater than # ...
				//Common.SystemDateTime.label
				er_msg_canot_blank = msgArray1[0]+getLabel("Common.InformedDate/Time.label","Common")+" "+msgArray1[1]+" "+getLabel("Common.SystemDateTime.label","common");
				error+=er_msg_canot_blank+"...<BR>";
				}
				if(!bookingDateValidation(inform_date_time,booking_date_time)){
					//error+="APP-OT0028 Informed Date/Time should be > "+booking_date_time+"(booked date)";
					er_msg_canot_blank = msgArray2[0]+" "+getLabel("Common.InformedDate/Time.label","Common")+" "+msgArray2[1]+" "+booking_date_time+"("+getLabel("eOT.BookedDate.Label","OT")+")";
					error+=er_msg_canot_blank+booking_date_time;
				}
			}
		}
	var facilityid = objFrm.facilityid.value;
	var room_code = objFrm.room_code.value;
	var booking_date = objFrm.booking_date.value;
	var overLapResult = chkOverlapForBooking(facilityid, room_code, booking_date, booking_date+" "+overlapChkStartTime, booking_date+" "+overlapChkEndTime);
	if(overLapResult == 'PRC-OT0006')
	{
		error+=overLapMasg;
	}
	// 047067 Bharati
	if(overLapResult == 'PRC-OT0060')
	{
		error+=overLapMasg1;
	}

	if(error.length>0) {
			//messageFrame.document.location.href="../../eCommon/jsp/error.jsp?err_num="+error;
			var target;
			if(parent && parent.messageFrame)
			{
				parent.messageFrame.document.location.href="../../eCommon/jsp/error.jsp?err_num="+error;
			} else {
				messageFrame.document.location.href="../../eCommon/jsp/error.jsp?err_num="+error;
			}
			
	}
	else
	{
		if(flagValue=='6')
		{
			var frmObj=parent.document.forms[0];
			var booking_date=dateUtils(document.getElementById('booking_date').value,locale,'DMY');
			//var room_code=frmObj.room_code.value;
			var room_code=objFrm.room_code.value;
			var booking_no=objFrm.booking_no.value;
			var cancel_reason=objCancel.reason_code.value;
			var seq_change_yn=document.getElementById('seq_change_yn').value;
			param="booking_date="+booking_date+"&room_code="+room_code+"&seq_change_yn="+seq_change_yn+"&flag=1&cancel_reason="+cancel_reason+"&booking_no="+booking_no+"&over_booking_case_yn="+over_booking_case_yn;
		}
		else if(flagValue!='1')
		{
			var booking_no=objFrm.booking_no.value;
			var cancel_by=objCancel.cancel_by.value;
			var cancel_date=objCancel.cancel_date.value;
			var cancel_reason=objCancel.reason_code.value;
			var cancel_desc=objCancel.reason_desc.value;
			var orderid=objCancel.orderid.value;
			var cancel_order=objCancel.cancelorder.checked;
			var booking_date=dateUtils(objFrm.booking_date.value,locale,'DMY');
			var start_time=objFrm.start_time.value;
		//Cancel Booking  with order
		if(objCancel.ward_informed_yn.checked==true){
			param="booking_no="+booking_no+"&cancel=true&cancel_by="+cancel_by+"&cancel_date="+cancel_date+"&cancel_reason="+cancel_reason+"&cancel_desc="+cancel_desc+"&cancel_order="+cancel_order+"&orderid="+orderid+'&start_time='+start_time+"&booking_date="+booking_date+"&cancelappt=YES&ward_informed_yn=Y&ward_informed_date_time="+convertDate(objCancel.inform_date.value,'DMY',locale,"en")+" "+objCancel.inform_time.value+"&cancelled_remarks="+objCancel.cancelled_remarks.value;


		}else{
		//Cancel Booking  without order
		param="booking_no="+booking_no+"&cancel=true&cancel_by="+cancel_by+"&cancel_date="+convertDate(cancel_date,'DMYHM',locale,"en")+"&cancel_reason="+cancel_reason+"&cancel_desc="+cancel_desc+"&cancel_order="+cancel_order+"&orderid="+orderid+'&start_time='+start_time+"&booking_date="+booking_date+"&cancelappt=YES&ward_informed_yn=N&cancelled_remarks="+objCancel.cancelled_remarks.value;
		}
}else{
	//Transfer Booking
	var booking_no=objFrm.booking_no.value;
	var asst_surgeon_code=objFrm.asst_surgeon_code.value;
	var locale=objFrm.locale.value;
	var surgeon_code=objFrm.surgeon_code.value;
	var start_time=objFrm.start_time.value;
	var speciality_code=objFrm.speciality_code.value;
	var room_code=objFrm.room_code.value;
	//var booking_date=dateUtils(objFrm.booking_date.value,locale,'DMY');10/14/2010 Anitha for IN024449
	//Modified by DhanasekarV modified on 02/11/2010 against the issue IN024782
	var booking_date=objFrm.booking_date.value;
	var dat = new Array()
	var dat=		booking_date.split("/");
	if(dat[2] > 2500)
		booking_date=convertDate(booking_date,'DMY',locale,"en");
	//end
	var patient_id=objFrm.patient_id.value;
	var oper_code=objOperDtl.oper_code.value;
	var oper_multiple=objOperDtl.oper_multiple.value;
	var cancel_reason=objCancel.reason_code.value;
	var cancel_desc=objCancel.reason_desc.value;
	var cancel_by=objCancel.cancel_by.value;
	var start_time1=objOperDtl.start_time.value;
	var end_time1=objOperDtl.end_time.value;
	var tot_time1=objOperDtl.tot_time.value;

	//var th_end_time=formObj.end_time.value;
	//var start_time=formObj.start_time.value;
    end_time1=end_time1.split(":");
    start_time1=start_time1.split(":");
    tot_time1=tot_time1.split(":");
	var hr2=parseInt(Math.abs(tot_time1[0]));
	var min2=parseInt(Math.abs(tot_time1[1]));
	var h2=parseInt(Math.abs(end_time1[0]));
	var m2=parseInt(Math.abs(end_time1[1]));
	var hr1="";
	var min1="";
	var h1=parseInt(Math.abs(start_time1[0]));
	var m1=parseInt(Math.abs(start_time1[1]));
	var hr="";
    var min="";
	var hrmin1="";
	var hrmin2="";
	if(m2==m1){
		hr1=h2-h1;
		min1=0;
	}
	else if(m2>m1)
	{
		hr1=h2-h1;
		min1=m2-m1;
	}else
	{
		hr1=h2-h1-1;
		min1=m2-m1+60;
	}
    hr1=parseInt(Math.abs(hr1));
	min1=parseInt(Math.abs(min1));
    hr2=hr2*60;
	hrmin2=hr2+min2;
	hr1=hr1*60;
	hrmin1=hr1+min1;
	if(hrmin1>=hrmin2)
	{
			flagtime=true;
	}
	else{
			flagtime=false;
	}
	// added By yadav
	/*For overbooking case its not required to test duration time for transferbooking  so written this condition against Icn.13718*/
	if(over_booking_case_yn=="Y")
	{
	flagtime=true;
	}
	else
		over_booking_case_yn ="N";  // Modified by DhanasekarV against  incident 32063

	//	param="booking_date="+booking_date+"&booking_no="+booking_no+"&cancel=false&cancel_reason="+cancel_reason+"&cancel_desc="+cancel_desc+"&surgeonCode="+surgeon_code+"&speciality_code="+speciality_code+"&room_code="+room_code+'&start_time='+start_time+'&patient_id='+patient_id+"&oper_code="+oper_code+"&oper_multiple="+oper_multiple+"&cancel_by="+cancel_by+"&asst_surgeon_code="+asst_surgeon_code+"&function_id="+function_id;

// Modified by DhanasekarV against  incident 32063
		param="booking_date="+booking_date+"&booking_no="+booking_no+"&cancel=false&cancel_reason="+cancel_reason+"&cancel_desc="+cancel_desc+"&surgeonCode="+surgeon_code+"&speciality_code="+speciality_code+"&room_code="+room_code+'&start_time='+start_time+'&patient_id='+patient_id+"&oper_code="+oper_code+"&oper_multiple="+oper_multiple+"&cancel_by="+cancel_by+"&asst_surgeon_code="+asst_surgeon_code+"&function_id="+function_id+"&over_booking_case_yn="+over_booking_case_yn;
}
var xmlDoc = "";
var xmlHttp = new XMLHttpRequest();
var xmlStr="<root></root>";
//xmlDoc.loadXML(xmlStr);
xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
if(flagValue =='6')
{
	xmlHttp.open("POST", "../../servlet/eOT.BookingServlet?"+param,false);
}
else
{
	var booking_no=objFrm.booking_no.value;
	var booking_date=objFrm.booking_date.value;
	var duration=objOperDtl.duration.value;
	var facilityid=objFrm.facilityid.value;
	var retWaitList=checkWaitList(booking_date,booking_no,facilityid,duration);
	var retSpeciality='';
	if(retWaitList!="")
	{
		if(window.confirm(getMessage("APP-OT0075","OT")))
		{
		retSpeciality=callWaitListDialog(retWaitList,facilityid,duration,booking_no,booking_date);
			if(retSpeciality!='0')
			{
			   if(checkSpeciality(booking_no,retSpeciality)==true)
				param=param+"&subfunction=1&add_waitlist_no="+retWaitList;
		}
	}
	}
if(flagtime==true)
	{
xmlHttp.open("POST", "../../servlet/eOT.WaitListServlet?"+param,false);
	}
else
{
var msgtime=getMessage("APP-OT0146","OT");
//var msgFrame=parent.messageFrame;
messageFrame.document.location.href="../../eCommon/jsp/error.jsp?err_num="+msgtime;
//parent.messageFrame.document.location.href="../../eCommon/jsp/error.jsp?err_num="+msgtime;
return false;
}
}

xmlHttp.send(xmlDoc);
var resTxt=""+xmlHttp.responseText;
	if(flagValue=='6')
	{
		if(resTxt=="undefined")
			resTxt="0";
		else
			resTxt="1";
		//parent.window.returnValue=resTxt;
		let dialogBody = parent.parent.document.getElementById('dialog-body');
		dialogBody.contentWindow.returnValue = resTxt;
		alert(getMessage("RECORD_INSERTED","SM"));
	   // parent.window.close();
		const dialogTag = parent.parent.document.getElementById("dialog_tag");    
		dialogTag.close();
	}
	else if(resTxt.charAt(0)=='1')
	{
		if(flagValue=='1')
		{
			var booking_num = objFrm.booking_no.value;
			var dialogHeight	= "0vh" ;
			var dialogWidth	= "0vw" ;
			var arguments	= "" ;
			var features	= "dialogHeight:" + dialogHeight + ";dialogBottom:auto; dialogWidth:" + dialogWidth + "; status:no" ;
			var url = "../../eOT/jsp/BookingReports.jsp";
			url=url+"?booking_num="+booking_num;
			retVal 	   =await  window.showModalDialog(url, arguments, features);	
		}
		//parent.window.returnValue='1';
		
		let dialogBody = parent.parent.document.getElementById('dialog-body');
		dialogBody.contentWindow.returnValue = '1';

		alert(getMessage("RECORD_INSERTED","SM"));
	    //parent.window.close();
		const dialogTag = parent.parent.document.getElementById("dialog_tag");    
		dialogTag.close();


		}
		else
		{
		 //parent.window.returnValue='0';
		 let dialogBody = parent.parent.document.getElementById('dialog-body');
		 dialogBody.contentWindow.returnValue = '0';
     	 alert(resTxt);
	     //parent.window.close();
		 const dialogTag = parent.parent.document.getElementById("dialog_tag");    
		 dialogTag.close();
	}
  }
}

function chkOverlapForBooking(facilityid, room_code, booking_date, startTime, endTime)// 44528 - Chaitanya - start
{
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest() ;
	//var locale = parent.header_frame.document.forms[0].locale.value;
	var locale = header_frame.document.forms[0].locale.value;
	var xmlStr ="<root><SEARCH  /></root>";
	var param="func_mode=chkOverlapForBooking&facilityid="+facilityid+"&booking_date="+convertDate(booking_date,'DMY','en',locale)+"&room_code="+room_code+"&startTime="+startTime+"&endTime="+endTime;
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST","../../eOT/jsp/OTCommonValidation.jsp?"+param,false);
	xmlHttp.send(xmlDoc);
	var check_count = trimString(xmlHttp.responseText);
	return check_count;
}
// 44528 - Chaitanya - end

async function callWaitListDialog(waitlistno,facilityid,duration,booking_no,booking_date){
	var dialogHeight 		= "76vh";
	var dialogWidth  		= "68vw";
	var dialogTop   		= "0vh";
	var dialogLeft   		= "0vw";
	var features			= "dialogTop:"+dialogTop+"dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +";status=no";
	var arguments			= "";
	var	param="waitlist_no="+waitlistno+"&facility_id="+facilityid+"&booking_duration="+duration+"&booking_no="+booking_no+"&booking_date="+booking_date;
	retVal=await window.showModalDialog("../../eOT/jsp/WaitListDetailFrame.jsp?"+param,arguments,features);
	return retVal;
}

function checkSpeciality(booking_no,splty){
	var sql="SELECT NVL(SPECIALITY_CODE,'*ALL') FROM 	  OT_BOOKING_TIME_SLOTS WHERE BOOKING_NUM	= '"+booking_no+"' AND	  ROWNUM= 1";
	var param="sql="+sql;
	var xmlDoc="";
	var xmlHttp = new XMLHttpRequest();
	var xmlStr="<root></root>";
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST", "../../servlet/eOT.CommonQueryServlet?"+param,false);
	xmlHttp.send(xmlDoc);
	var resTxt=xmlHttp.responseText;
	resTxt=eval(resTxt);
	if(resTxt="*ALL" || resTxt=="SU"){

		resTxt=true;
	}else{

		resTxt=false;
	}
	return resTxt;
}

function validateWaitlistElectiveCutOffTime(booking_date,facilityid){
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest();
	var params = "booking_date="+booking_date+"&facilityid="+facilityid;
	var xmlStr ="<root><SEARCH ";
	xmlStr +=" /></root>";
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST","CommonValidation.jsp?func_mode=WaitlistElectiveCutOffTime&"+params,false);
	xmlHttp.send(xmlDoc);
	var retVal = trimString(xmlHttp.responseText);
	return retVal;

}

function checkWaitList(booking_date,booking_no,facilityid,duration){
	//Checking For Elective Case Cut Off Time
	var retVal=validateWaitlistElectiveCutOffTime(booking_date,facilityid);
	if(retVal!=""){
		var sql="SELECT MIN(WAITLIST_NUM)   FROM     OT_WAITLISTING WHERE OPERATING_FACILITY_ID = '"+facilityid+"' AND 	STATUS   = 'P'  AND BOOKING_DATE  > to_date('"+booking_date+"'  ,'dd/mm/yyyy') AND    BOOKING_NUM != '"+booking_no+"'  AND       BOOKING_NUM          IS NOT NULL  AND  TO_NUMBER(TO_CHAR(BOOKING_DURATION,'SSSSS')) <= TO_NUMBER(TO_CHAR(TO_DATE(TO_CHAR(SYSDATE,'DD/MM/YYYY ')||'"+duration+"','DD/MM/YYYY HH24:MI'),'SSSSS')) AND NATURE_TYPE='EM' ";
		var param="sql="+sql;
		var xmlDoc="";
		var xmlHttp = new XMLHttpRequest();
		var xmlStr="<root></root>";
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open("POST", "../../servlet/eOT.CommonQueryServlet?"+param,false);
		xmlHttp.send(xmlDoc);
		var resTxt=xmlHttp.responseText;
		resTxt= eval(resTxt);
	}else{
		var sql="SELECT MIN(WAITLIST_NUM)   FROM     OT_WAITLISTING WHERE OPERATING_FACILITY_ID = '"+facilityid+"' AND 	STATUS   = 'P'  AND BOOKING_DATE  > to_date('"+booking_date+"'  ,'dd/mm/yyyy') AND    BOOKING_NUM != '"+booking_no+"'  AND       BOOKING_NUM          IS NOT NULL  AND  TO_NUMBER(TO_CHAR(BOOKING_DURATION,'SSSSS')) <= TO_NUMBER(TO_CHAR(TO_DATE(TO_CHAR(SYSDATE,'DD/MM/YYYY ')||'"+duration+"','DD/MM/YYYY HH24:MI'),'SSSSS'))";
		var param="sql="+sql;
		var xmlDoc="";
		var xmlHttp = new XMLHttpRequest();
		var xmlStr="<root></root>";
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open("POST", "../../servlet/eOT.CommonQueryServlet?"+param,true);
		xmlHttp.send(xmlDoc);
		var resTxt=xmlHttp.responseText;
		resTxt= eval(resTxt);
	}
	return resTxt;
}
/*
function reset(){
	var cou=0;
	//alert('reload');
	for(cou=1;cou<parent.frames[1].length;cou++)
		parent.frames[1].frames[1].location.reload();

}
*/
function reset(){

	 if(frames[1].name=='f_query_add_mod') {

		 commontoolbarFrame.location.href="../../eCommon/jsp/commonToolbar.jsp?menu_id=OT_JAVA_DFLT&module_id=OT&function_id=OT_BOOKING_CANCEL_TRANSFER&function_name=Cancel%20%2F%20Transfer%20Booking&function_type=F&access=NYNNY"
	   if(frames[1].frames[0].name=='f_query_add_mod'){

		  f_query_add_mod.location.reload();
	commontoolbarFrame.location.href="../../eCommon/jsp/commonToolbar.jsp?menu_id=OT_JAVA_DFLT&module_id=OT&function_id=OT_BOOKING_CANCEL_TRANSFER&function_name=Cancel%20%2F%20Transfer%20Booking&function_type=F&access=NYNNY"
		  //frames[1].frames[0].document.forms[0].reset();
	   }
	   else if(frames[1].frames[1].name=='qa_query_result') {

		   commontoolbarFrame.location.href="../../eCommon/jsp/commonToolbar.jsp?menu_id=OT_JAVA_DFLT&module_id=OT&function_id=OT_BOOKING_CANCEL_TRANSFER&function_name=Cancel%20%2F%20Transfer%20Booking&function_type=F&access=NYNNY"

			  frames[1].frames[1].location.reload();
	   }
	 }
     else if(frames[3].frames[1].name=='detailframe') {
		 commontoolbarFrame.location.href="../../eCommon/jsp/commonToolbar.jsp?menu_id=OT_JAVA_DFLT&module_id=OT&function_type=F&access=NYNNY&home_required_yn=N";
		 var frameObj=frames[3].frames[1];
		 frameObj.document.forms[0].reset();
		 /*Added by Suma 19003 */
		// frameObj.document.getElementById("img1").src="../../eCommon/images/Blank1.gif";
		// frameObj.document.getElementById("img2").src="../../eCommon/images/Blank1.gif";
		//  parent.frames[3].frames[1].document.forms[0].cancelled_remarks.value="";
		  //parent.frames[3].frames[1].document.forms[0].cancelled_remarks.disabled=true;
		  /*ends here*/

     }
 }


 /*function reset(){
	alert(document.frames[1].name);
	alert(document.frames[1].frames[0].name);
	alert(document.frames[1].frames[1].name);
	//alert(parent.frames[3].frames[1].name);
	 if(document.frames[1].name=='f_query_add_mod') {

	   if(document.frames[1].frames[0].name=='f_query_add_mod') {
		   //alert("1");
		 // document.frames[1].frames[0].location.reload();
		  f_query_add_mod.location.reload();
		   //document.frames[1].frames[1].location.href = "../../eCommon/html/blank.html";
	   }
	   else if(document.frames[1].frames[1].name=='qa_query_result') {
		   		  // alert("2");
			  document.frames[1].frames[1].location.reload();
	   }
	 }
     else if(parent.frames[3].frames[1].name=='detailframe') {
		 var frameObj=frames[3].frames[1];
		 frameObj.document.forms[0].reset();
     }
 }*/

function callNoRecord1(){
	alert(getMessage("NO_RECORD_FOUND_FOR_CRITERIA","Common"));
}


async function showOperRemarks(strVal,remarks){
	strVal = encodeURIComponent(strVal);
	await window.showModalDialog('../../eOT/jsp/TextAreaRemarks.jsp?heading='+strVal+'&remarks='+remarks,window,"dialogHeight: 25vh; dialogWidth:35vw; center: yes; help: no; resizable: no; status: no;");
}
async function showOperRemarks1(strVal,fetchCount){
	var remarks = eval("document.forms[0].preOperDiag_"+fetchCount).value;
	remarks=encodeURIComponent(remarks,"UTF-8");
	strVal = encodeURIComponent(strVal,"UTF-8");
	await window.showModalDialog('../../eOT/jsp/TextAreaRemarks.jsp?heading='+strVal+'&remarks='+remarks,window,"dialogHeight: 25vh; dialogWidth:35vw; center: yes; help: no; resizable: no; status: no;");
}



function trmString(sInString) {
    return sInString.replace(/^\s+|\s+$/g,"");
}

function sysDateValidation(informed_date){
	//var sql="select decode(SIGN(to_date('"+theatre_date+"','DD/MM/YYYY HH24:MI')-TRUNC(SYSDATE)),1,'N','Y') FROM DUAL";
	//var sql="select decode(SIGN(to_date('"+informed_date+"','DD/MM/YYYY HH24:MI')-TO_DATE(SYSDATE,'DD/MM/YYYY HH24:MI')),-1,'N','Y') FROM DUAL";
	if(informed_date.length>0){
	var sql="select decode(SIGN(SYSDATE - to_date('"+informed_date+"','DD/MM/YYYY HH24:MI')),-1,'N','Y') from dual";
	//alert(sql);
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest() ;
	var xmlStr ="<root></root>";
	param="flag=MED_SER&sql="+sql;
	//alert(param);
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST", "../../servlet/eOT.CommonQueryServlet?"+param,false);
	xmlHttp.send(xmlDoc);
	var retVal = trimString(xmlHttp.responseText);
	//alert("RETVAL"+retVal);
	var bool = (retVal=="Y")?true:false;
	//alert(bool);
	return bool;
	}else
		return true;
}

function bookingDateValidation(informed_date,booking_date){
	//var sql="select decode(SIGN(to_date('"+theatre_date+"','DD/MM/YYYY HH24:MI')-TRUNC(SYSDATE)),1,'N','Y') FROM DUAL";
	if(informed_date!="" && booking_date!=""){
	var sql="select decode(SIGN(to_date('"+informed_date+"','DD/MM/YYYY HH24:MI')-to_date('"+booking_date+"','DD/MM/YYYY HH24:MI')),-1,'N','Y') FROM DUAL";

	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest() ;
	var xmlStr ="<root></root>";
	param="flag=MED_SER&sql="+sql;

	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST", "../../servlet/eOT.CommonQueryServlet?"+param,false);
	xmlHttp.send(xmlDoc);
	var retVal = trimString(xmlHttp.responseText);

	var bool = (retVal=="Y")?true:false;
	return bool;
	}else
		return true;
  }

 function trimString(sInString){
   return sInString.replace(/^\s+|\s+$/g,"");
 }

function getBookingDateTime(facility_id,booking_num){
	var sql="SELECT to_char(added_date,'DD/MM/YYYY HH24:MI') FROM ot_booking_hdr WHERE operating_facility_id='"+facility_id+"' AND booking_num ='"+booking_num+"'";

	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest() ;
	var xmlStr ="<root></root>";
	param="flag=MED_SER&sql="+sql;

	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST", "../../servlet/eOT.CommonQueryServlet?"+param,false);
	xmlHttp.send(xmlDoc);
	var retVal = trimString(xmlHttp.responseText);

	return retVal;
}


function funClearAll(){
	var frmObj=document.forms[0];
	frmObj.SURGEON.value="";
	frmObj.SURGEON_CODE.value="";
	frmObj.SPECIALITY_CODE.value="";
	frmObj.SPECIALITY_DESC.value="";
	frmObj.patientid.value="";
	frmObj.patientName.value="";
	frmObj.theatre_type_desc.value="";
	frmObj.theatre_type_code.value="";
	frmObj.room_code.value="";
	frmObj.theatre.value="";
	frmObj.ref_no.value="";
	frmObj.from_date.value="";
	frmObj.to_date.value="";
	parent.qa_query_result.location.href = "../../eCommon/html/blank.html";
}



