/*
*Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
* 
*Warning: This computer program is protected by copyright law and international treaties.
*Unauthorized reproduction or distribution of this program, or any portion of it, 
*may result in severe civil and criminal penalties, and will be prosecuted to 
*the maximum extent possible under the law.
*/
var result     =   false ;
var message     =   "" ;
var flag        =   "" ;
async function searchSurgeons(obj){
	var formObj	= document.SlateSearchForm;
	formObj.surgeon_name.value="";
	formObj.surgeon.value="";
	var facility_id = formObj.facility_id.value;
	var retVal = 	new String();
	var dialogHeight= "28" ;
	var dialogWidth	= "43" ;
	var status = "no";
	var arguments	= "" ;
	var sql="";
	var search_code="";
	var search_desc="";
	var tit="Surgeons";
	var status = "E";
	tit="Surgeons "
	sql=escape("Select PHYSICIAN_ID,SHORT_NAME from SY_PHYSICIAN_MAST where FACILITY_ID='"+facility_id+"' and PRACT_TYPE IN ('MD','SG') AND NVL(STATUS,'E')='E'");
	search_code="PHYSICIAN_ID";
	search_desc= "SHORT_NAME";
	var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; scroll=no; status:" + status;
	retVal = await window.showModalDialog("../../eCommon/jsp/GeneralSearch.jsp?SQL="+sql+"&search_code="+search_code+"&search_desc="+search_desc+"&title="+tit+"&dispDescFirst=dispDescFirst",arguments,features);
	var arr=new Array();
	if (!(retVal == null))
	{
	    var retVal=unescape(retVal);
	    arr=retVal.split("::");
	    document.forms[0].surgeon_name.value=arr[0];
	    document.forms[0].surgeon.value=arr[1];
	}
}
function searchSlateReSchedule(){
	parent.f_query_add_mod.location.href="../../eCommon/html/blank.html";
//	parent.parent.messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num=";
	var formObj	= document.SlateSearchForm;
	formObj = document.SlateSearchForm;
	var retVal = checkForMandatoryFields(formObj);
	if(retVal==false){
		var booking_date	=	formObj.booking_date.value;
		var theatre			=	formObj.theatre.value;
		var speciality		=	formObj.speciality.value;
		var surgeon			=	formObj.surgeon.value;
		var view_status		=	formObj.view_status.value;
	parent.f_query_add_mod.location.href="../../eOT/jsp/SlateReScheduleSearchResultsFrame.jsp?booking_date="+booking_date+"&theatre="+theatre+"&speciality="+speciality+"&surgeon="+surgeon+"&view_status="+view_status;
	}else{
		var msg = getOTMessage("CANNOT_BE_BLANK");
		var msgArray = msg.split("&");
		//var errormessage  = getMessage("OT_MANDATORY");
		var errormessage = msgArray[0]+" Theatre "+(msgArray[1])
		alert(errormessage);
       // parent.parent.messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num="+ errormessage;
		//enableSearchCriteria();
	}
}
function checkForMandatoryFields(formObj){
	//var msg = getOTMessage("CANNOT_BE_BLANK");
	//var msgArray = msg.split("&");
	if(formObj.theatre.value ==""){
		//alert(msgArray[0]+" Theatre "+(msgArray[1]));
		return true;
	}
	return false;
}
function validateReScheduleTheatre(){
	var formObj = document.SlateSearchForm;
	var booking_date	=	formObj.booking_date.value;
	var theatre_type	=	formObj.theatre_type.value;
	var theatre			=	formObj.theatre.value;
	var speciality		=	formObj.speciality.value;
	var surgeon			=	formObj.surgeon.value;
	var surgeon_name	=	formObj.surgeon_name.value;
	var view_status		=	formObj.view_status.value;
	var refresh_flag = "Y";
refreshSlateReScheduleSearch(booking_date,theatre_type,theatre,speciality,surgeon,surgeon_name,view_status,refresh_flag);
}
function refreshSlateReScheduleSearch(booking_date,theatre_type,theatre,speciality,surgeon,surgeon_name,view_status,refresh_flag){
	var formObj = document.SlateSearchForm;
	var params=formObj.params.value;
	parent.f_search.location.href="../../eOT/jsp/SlateReScheduleSearch.jsp?booking_date="+booking_date+"&ttheatre="+theatre+"&speciality="+speciality+"&theatre_type="+theatre_type+"&surgeon="+surgeon+"&surgeon_name="+surgeon_name+"&view_status="+view_status+"&refresh_flag="+refresh_flag;
	parent.f_query_add_mod.location.href="../../eCommon/html/blank.html";
	parent.parent.messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num=";
}

function lockKey(){
    if(event.keyCode == 93)
        //alert("Welcome to eHIS");
	    alert(getOTMessage("APP-OT0084"));
}

function  displayToolTipReshedule(facility_id,patient_id,patient_name,sex,date_of_birth,booking_no,surgeon_code,speciality_code)
{
	var menu_id_list		= new Array("VB","PH","SH","CB","RB");//
	var param=facility_id+"::"+patient_id+"::"+patient_name+"::"+sex+"::"+date_of_birth+"::"+booking_no+"::"+surgeon_code+"::"+speciality_code;
	//alert(param);
	//var	menu_name_list	= new Array("Patient History","Surgery History","Reschedule");
	var	menu_name_list	= new Array("View Booking","Patient History","Surgery History","Cancel Booking","Reschedule Booking");//

	var tab_dat  = "<table id ='tooltiptable' cellpadding=0 cellspacing=0 border='0' class='BOX' width='100%' height='100%' align='center'>";
	for( var i=0; i<menu_name_list.length; i++ )
	{
		var id_colval		= menu_id_list[i];
		var id_name_colval  = menu_name_list[i];
		if(id_colval!="")
		{
			tab_dat     += "<tr>"
			tab_dat     += "<td class = 'ORMENULAYER' nowrap    id='mouse' onMouseOver='callMouseOver(this)' onMouseOut='callOnMouseOut(this);'><a href = \"javascript:callResheduleFunctions('"+id_colval+"','"+param+"');\")> "+id_name_colval + "  </a> </td>"
			tab_dat     += "</tr> ";
		}
	}
	tab_dat     += "</table> ";	
	document.getElementById("tooltiplayer").innerHTML = tab_dat;
	resizeWindow();
}

function callResheduleFunctions(obj,para)
{
	var par=new Array();
	par=para.split("::");
	var dialogHeight 		= "80";
	var dialogWidth  		= "80";
	var dialogTop   		= "10";
	var dialogLeft   		= "50";
	var features			= "dialogTop:"+dialogTop+"dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +";status=no";
	var arguments			= "";
	hideToolTip();
	if(obj=="VB")
	{
		
		var param="facility_id="+par[0]+"&patient_id="+par[1]+"&booking_no="+par[5]+"&orderid=0&transfer=5&access=NYNNY&home_required_yn=N";
		//	var param="module_id=OT&function_type=F&menu_id=null&access=NYNNY&home_required_yn=N&called_from=OT_SLATE&patient_id=LD00005722&oper_num=null&booking_num=238&booking_no=238&waitlist_no=&slate_user_id=true&surgeon_doc_comp_yn=N&nursing_doc_comp_yn=N&order_id=null&tab_name=SCHEDULED&speciality_code=SURG&facility_id=LD&orderid=0&booking_no=238&transfer=5";
		var retVal=window.showModalDialog('../../eOT/jsp/ViewBookingDetailsQuery.jsp?'+param,window,"dialogHeight: 700px; dialogWidth:800px; center: yes; help: no; resizable: yes; status: no;");
	}
	if(obj=="PH")
	{
		var HTML = "<html>"
		HTML += "<form name='historyForm' id='historyForm' action='../../eCA/jsp/OpenChartWrapper.jsp'>"
		HTML += "<input type='text' name='insert_op' id='insert_op' value= 'N'>";
		HTML += "<input type='text' name='patient_id' id='patient_id' value= '" +par[1]+ "'>"; 
		HTML += "</form>"
		HTML += "</html>"
		parent.parent.parent.messageFrame.document.body.insertAdjacentHTML("BeforeEnd", HTML);
		parent.parent.parent.messageFrame.document.historyForm.submit();
	}
	if(obj=="SH")
	{
		var surgeryhistory_legend = getLabel("eOT.SurgeryHistory.Label","OT");	
		var param="facility_id="+par[0]+"&patient_id="+par[1]+"&patient_name="+par[2]+"&sex="+par[3]+"&dob="+par[4]+"&function_name="+surgeryhistory_legend+"&called_from=OPER_REG";
		var retVal=window.showModalDialog('../../eOT/jsp/SurgeryHistory.jsp?'+param,window,"dialogHeight: 700px; dialogWidth:800px; center: yes; help: no; resizable: yes; status: no;");
	}
	if(obj=="CB")
	{
		var param="facility_id="+par[0]+"&patient_id="+par[1]+"&booking_no="+par[5]+"&access=NYNNY&home_required_yn=N";
	//	alert(param);
		var retVal=window.showModalDialog('../../eOT/jsp/BookingDetailFrame.jsp?'+param,window,"dialogHeight: 700px; dialogWidth:800px; center: yes; help: no; resizable: yes; status: no;");
	}
	if(obj=="RB")
	{
		var param="booking_no="+par[5]+"&surgeonCode="+par[6]+"&surgeonName="+par[7]+"&speciality_code="+par[8]+"&speciality_desc="+par[9]+"&funflag=2";
		//var retVal=window.showModalDialog('../../eOT/jsp/CalendarFrame.jsp?'+param,window,"dialogHeight: 700px; dialogWidth:800px; center: yes; help: no; resizable: yes; status: no;");
		
		parent.parent.parent.parent.f_query_add_mod.location.href="../../eOT/jsp/CalendarFrame.jsp?"+param;
	}

}

function callMouseOver(obj)
{
	currClass = obj.className ;
	obj.className = 'ORMENU';
}

function callOnMouseOut(obj)
{
	obj.className = currClass;
}

function hideToolTip()
{
	document.getElementById("tooltiplayer").style.visibility = 'hidden';
}
function applyReschedule()
{
	var action_val=document.forms[0].action_val.value;
	var reschedule_date=document.forms[0].reschedule_date.value;
	var facility_id=document.forms[0].facility_id.value;
	var login_user=document.forms[0].login_user.value;
	var client_ip_address=document.forms[0].client_ip_address.value;
	var frmObj=parent.f_reschedule_results_frame.SlateSchSearchResultForm;
	var rec_size=frmObj.rec_size.value;
	var total_records="";
	var count=0;
	
	for(var i=1;i<=rec_size;i++)
	{
	var select_checkbox="frmObj.select_checkbox_"+i;
		var record="";
		if(eval(select_checkbox).checked==true)
		{	
			count++;
			var appt_ref_num="frmObj.appt_ref_num"+i;
			var oper_room_code="frmObj.oper_room_code"+i;
			record=eval(appt_ref_num).value +"@@"+ eval(oper_room_code).value;
			//alert(record);
			total_records+=record+"::";
		}
	}
	if(total_records==""){
		//alert("Bookings are not selected");
		alert(getMessage("APP-OT0058","OT"));
		return
	}
		var param="action_val="+action_val+"&reschedule_date="+reschedule_date+"&total_records="+total_records+"&count="+count;
		var action="../../servlet/eOT.SlateRescheduleServlet?"+param;
		var xmlDoc = "" ;
		var xmlHttp = new XMLHttpRequest();
		var xmlStr ="<root></root>";
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open("POST",action,false);
		xmlHttp.send(xmlDoc);
		var retVal = trimString(xmlHttp.responseText);
		if(retVal=="S"){
			//alert("APP-SM0001 Operation Completed Successfully ....");
			alert(getMessage("RECORD_INSERTED","SM"));
			parent.parent.f_query_add_mod.location.reload();
			parent.f_reschedule_results_frame.location.reload();
			parent.f_reschedule_other_action_frame.location.reload();
		}
		else {
			alert(retVal);
		}

}

