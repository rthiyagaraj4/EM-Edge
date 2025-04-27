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

var prevObjID;
var prevImgObj;
var disappeardelay= 250;

function clearField(obj){
	obj.value="";
	obj.style.color="#330066";
}
function clearBean(){
	var dummy="dummy";
	var xmlStr ="<root><SEARCH ";
	xmlStr+=" dummy=\""+ dummy + "\" ";
	xmlStr +=" /></root>";
	return fieldValidation(xmlStr,"clearBean");
}
function fieldValidation(xmlStr,source){
	var xmlDoc = "" ;
    var xmlHttp = new XMLHttpRequest() ;
    xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST","WardChkOutValidation.jsp?func_mode="+source,false);
    xmlHttp.send(xmlDoc);
    responseText=xmlHttp.responseText ;
	//alert(responseText);
    responseText = responseText.replace(/<\/?[^>]+(>|$)/g, "");
	eval(trimString(responseText));
    return true;
}
function checkFlds( fields, names,show_alert) {
	var errors = "" ;
	for( var i=0; i<fields.length; i++ ) {
		if(trimCheck(fields[i].value)) {
			fields[i].value = trimString(fields[i].value);
		}else if(show_alert !="Y"){
			errors = errors + "APP-000001 " + names[i] + " cannot be blank..." + "<br>" ;				
		}else{
			errors = errors + "APP-000001 " + names[i] + " cannot be blank...\n" ;
		}
	}
	if ( errors.length != 0 && show_alert != "Y") {
		if(parent.parent.messageFrame != null)
			parent.parent.messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num="+ errors;
		else if(parent.messageFrame != null)
			parent.messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num="+ errors;
		else
			messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num="+ errors;
		return false ;
	}else if(errors.length != 0 && show_alert == "Y"){
	//	alert(errors);
		return false;
	}else{
		if(parent.parent.messageFrame != null){
			parent.parent.messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num=";
		}else if(parent.messageFrame!=null){
			parent.messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num=";
		}else
			messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num=";
	}
	return true ;
}

function validateForMandatoryFields(){
}

function assignResult( _result, _message, _flag ) {
	result = _result ;
	message  = _message ;
	flag = _flag ;
}
async function searchWard1(obj,target){
	var locale = document.forms[0].locale.value;
	var facility_id = document.forms[0].facility_id.value;
	var retVal =    new String();
	var argumentArray  = new Array() ;
	var dataNameArray  = new Array() ;
	var dataValueArray = new Array() ;
	var dataTypeArray  = new Array() ;
	var tit="";
	if(target.name == 'nursing_unit_name'){
//		tit="Ward Search";
		tit=getLabel("Common.Ward.label","common");
		// Code altered by Selvam for PHASE 3 Delivery		
//		var sql="select nursing_unit_code code, short_desc description from IP_NURSING_UNIT_LANG_VW where LANGUAGE_ID='"+locale+"' AND facility_id = '"+facility_id+"' and nvl(eff_status,'X') = 'E'  and upper(nursing_unit_code) like upper(?) and upper(short_desc) like upper(?) order by 2";
		var sql="SELECT NURSING_UNIT_CODE CODE, LONG_DESC DESCRIPTION FROM IP_NURSING_UNIT_LANG_VW WHERE LANGUAGE_ID='"+locale+"' AND FACILITY_ID = '"+facility_id+"' AND NVL(EFF_STATUS,'X') = 'E'  AND UPPER(NURSING_UNIT_CODE) LIKE UPPER(?) AND UPPER(LONG_DESC) LIKE UPPER(?) ORDER BY 2";
	}
	argumentArray[0] =sql;
	argumentArray[1] = dataNameArray ;
	argumentArray[2] = dataValueArray ;
	argumentArray[3] = dataTypeArray ;
	argumentArray[4] = "2,1";
	argumentArray[5] = target.value;
	argumentArray[6] = DESC_LINK;
	argumentArray[7] = DESC_CODE;

	retVal = await CommonLookup( tit, argumentArray );
	if(retVal != null && retVal != "" ){
		var ret1=unescape(retVal);
		arr=ret1.split(",");
		target.value=arr[1];
		if(target.name == 'nursing_unit_name')
		{
			document.forms[0].nursing_unit.value= arr[0];
			document.forms[0].nursing_unit_name.disabled=true;
		}
	}else{
		target.value='';
		obj.value='';
	}
}

async function localSearchPatient(){

	var formObj = document.WardChkOutSearchForm;
	var nursing_unit = formObj.nursing_unit.value;
	var locale = formObj.locale.value;
	if(nursing_unit!=""){
		var dialogTop  = "20px;";
		var dialogHeight = "450px";
		var dialogWidth  = "650px";
		var arguments = "";
		var column_sizes = escape("20%,60%,20%");
		//var column_descriptions = escape("Patient Id,Patient Name,Encounter Id");
		var column_descriptions = getLabel('Common.patientId.label','common')+','+getLabel('Common.PatientName.label','Common')+','+getLabel('Common.encounter.label','Common');
		column_descriptions = encodeURIComponent(column_descriptions);
		var sql=escape("SELECT I.PATIENT_ID PATIENT_ID1, DECODE('"+locale+"','en',M.PATIENT_NAME, NVL(M.PATIENT_NAME_LOC_LANG,M.PATIENT_NAME)) SHORT_NAME1,O.OPEN_EPISODE_ID OPEN_EPISODE_ID FROM MP_PATIENT M, IP_OPEN_EPISODE O, IP_EPISODE I WHERE M.PATIENT_ID = O.PATIENT_ID AND O.OPEN_EPISODE_ID=I.EPISODE_ID AND O.PATIENT_ID=I.PATIENT_ID AND I.CUR_WARD_CODE='"+nursing_unit+"'");
	//	var title='Patient Search';
		var  title = encodeURIComponent(getLabel("Common.patient.label","Common"));
		var features  = "dialogTop:"+dialogTop+"dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +";status=no";
		var param = "title="+title+"&"+"column_sizes="+column_sizes+"&"+"column_descriptions="+column_descriptions+"&"+"sql="+sql;
		retVal= await  window.showModalDialog("../../eOT/jsp/OTGeneralSearchFrames.jsp?"+param,arguments,features);

		if(retVal!=null){
		var arr = retVal.split('::');
			formObj.patient_id.value=arr[0];
			formObj.patient_name.value=arr[1];
		}else{
			formObj.patient_id.value='';
			formObj.patient_name.value='';
		}
	}else{
		//alert("Select the Nursing Unit");
	//	var msg_1 = getOTMessage("CANNOT_BE_BLANK");
		var msg_1 = getMessage("CANNOT_BE_BLANK","OT") ;
		var msgArray = msg_1.split("&");
		//alert(msgArray[0]+" Nursing Unit "+(msgArray[1]));
		alert(msgArray[0]+" "+getLabel("Common.nursingUnit.label","Common")+" "+(msgArray[1]));
		formObj.patient_id.value='';
		formObj.patient_name.value='';
	}
}

function reset(){
	clearBean();
	messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num=";
	f_search.document.location.reload();
	f_query_add_mod.document.location.href="../../eCommon/html/blank.html";
}
function searchWardChkOutDetails(){
	var formObj	= document.WardChkOutSearchForm;
	var retVal = checkForMandatory(formObj);
	if(retVal==true){
		searchOTDetails();
	}
}
function checkForMandatory(formObj){
	var fields= new Array( formObj.surgery_date, formObj.nursing_unit);
	// give the Label name on the GUI screen
	var names=new Array("Surgery Date",	"Nursing Unit");
	var retVal = checkFlds( fields, names,"N");
	return retVal;
}
function searchOTDetails(){
	//clearBean();
	var locale = document.forms[0].locale.value;
	var formObj = document.WardChkOutSearchForm;
	var params				=	formObj.params.value;
	var surgery_date		=	dateUtils(formObj.surgery_date.value,locale,"DMY");
	var nursing_unit		=	formObj.nursing_unit.value;
	var nursing_unit_name	=	formObj.nursing_unit_name.value;
	var patient_id			=	formObj.patient_id.value;
	var patient_name		=	formObj.patient_name.value;
	var view_by				=	formObj.view_by.value;
	var bookings_type		=	formObj.bookings_type.value;
	var current_ip_ward_yn	=	formObj.current_ip_ward_yn.value;

	parent.messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num=";
	parent.messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num=";
	parent.f_query_add_mod.location.href="../../eOT/jsp/WardChkOutSearchResultsFrame.jsp?"+params+"&surgery_date="+surgery_date+"&nursing_unit="+nursing_unit+"&nursing_unit_name="+nursing_unit_name+"&patient_id="+patient_id+"&patient_name="+patient_name+"&view_by="+view_by+"&bookings_type="+bookings_type+"&current_ip_ward_yn="+current_ip_ward_yn;
	parent.messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num=";

}

//to display the drop-down menu for the patient_id link
function displayToolTip(rownum,patient_id,orderctlHDR,imgObj){ // (,param1,param2,param3,......){

	var formObj = document.WardChkOutResultsForm;
	var bookings_type = formObj.bookings_type.value;
	var oper_status=eval("formObj.oper_status_"+rownum).value;
	var check_out_time=eval("formObj.check_out_time_"+rownum).value;
	var case_called_time=eval("formObj.case_called_time_"+rownum).value;
	var customer_id1 = formObj.customer_id1.value; // Added for IN:41808
	if(bookings_type=="S"){
		if(oper_status=="35"){
			var menu_name_list = ("View Booking Details");
			var url_desc_list = ("ViewBookingDetailsQuery.jsp");
		}
		else{
			var menu_name_list = ("View Booking Details,Verify Check List,Check-Out Patient");
			var url_desc_list = ("ViewBookingDetailsQuery.jsp,VerifyCheckListMain.jsp,...");
		}
	}else if(bookings_type=="R"){
		var menu_name_list = ("Verify Check List,Check-Out Patient");
		var url_desc_list = ("VerifyCheckListMain.jsp,...");
	}
	// Added for IN:41808
	if(customer_id1 =="RTN")
	{
		var menu_name_list = ("View Booking Details,Verify Check List,Check-Out Patient,Operating Site Identification");
		var url_desc_list = ("ViewBookingDetailsQuery.jsp,VerifyCheckListMain.jsp,OperatingSiteIdentification.jsp");
	
	}
	var patient_id=eval("formObj.patient_id_"+rownum).value;
	var appt_ref_num=eval("formObj.appt_ref_num_"+rownum).value;
	var order_id=eval("formObj.order_id_"+rownum).value;
	var appt_yn=eval("formObj.appt_yn_"+rownum).value;
	buildTable(rownum,patient_id,appt_ref_num,order_id,appt_yn,menu_name_list,url_desc_list,orderctlHDR,imgObj);
	}
function buildTable(rownum,patient_id,appt_ref_num,order_id,appt_yn,menu_name_list,menu_url_desc_list,orderctlHDR,imgObj){
	menu_name_list		= trimString(menu_name_list);
	menu_url_desc_list	= trimString(menu_url_desc_list);
	var id_name_rowval  = menu_name_list.split (","); // function_name
	var url_desc_rowval = menu_url_desc_list.split (","); // url_desc
	callMouseOverOnTD(orderctlHDR,imgObj);
	var tab_dat  = "<table id='tooltiptable1' style='background-color: #b6b7ba;' class='contextMenu' width='100%' height='100%' align='center'>";
	for( var i=0; i<id_name_rowval.length; i++ ){
		var id_name_colval  = id_name_rowval[i];
		var url_desc_colval  = url_desc_rowval[i];
		if(id_name_colval!=""){
			tab_dat     += "<tr>"
			tab_dat     += "<td class = 'contextMenuItem' nowrap id='mouse' onMouseOver='callMouseOver(this)' onMouseOut='callOnMouseOut(this);'><a class='contextMenuLink' href =  javascript:callMenuFunctions('"+rownum+"','"+patient_id+"','"+appt_ref_num+"','"+order_id+"','"+appt_yn+"','"+escape(id_name_colval)+"','"+escape(url_desc_colval)+"')> "+id_name_colval + " </a> </td>"
			tab_dat     += "</tr> ";
		}
	}
	tab_dat     += "</table> ";
	document.getElementById("menu_table").innerHTML = tab_dat;
	resizeWindow(orderctlHDR);
}
async function callMenuFunctions(rownum,patient_id,appt_ref_num,order_id,appt_yn,function_name,url_desc){
	var formObj			= document.WardChkOutResultsForm;
	var oper_status=eval("formObj.oper_status_"+rownum).value;
	var current_time=eval("formObj.current_time").value;
	var current_date=eval("formObj.current_date").value;
	var check_out_time=eval("formObj.check_out_time_"+rownum).value;
	var check_out_time1=eval("formObj.check_out_time_"+rownum).value;
	var case_called_time=eval("formObj.case_called_time_"+rownum).value;
	var case_called_time1=eval("formObj.case_called_time_"+rownum).value;
	if(case_called_time=="")
		case_called_time=current_date+" "+"00:00"
	else
		case_called_time=current_date+" "+case_called_time;
	check_out_time=current_date+" "+check_out_time;
	//alert(check_out_time);
	var current_time=current_date+" "+current_time;
	//alert(current_time);
	var flag=true;
	//alert(check_out_time);
	//alert(case_called_time);
	//alert(current_time);
	var called_from = formObj.called_from.value;
	var bookings_type	= formObj.bookings_type.value;
	facility_id			= formObj.facility_id.value;
	menu_id				= formObj.menu_id.value;
	var bookings_type	= formObj.bookings_type.value; // Type in search criteria Surgery or RD
	if(function_name.search("Check-Out Patient") == 0){
		var check_out_time_flag=true;
		if(oper_status!="35"){
			if(check_out_time1==""){
				//alert("check out time can not be blank...");
				//var msg = getOTMessage("CANNOT_BE_BLANK");
				var msg = getMessage("CANNOT_BE_BLANK","OT");
				var msgArray = msg.split("&");
				alert(msgArray[0]+" Check Out Time "+msgArray[1]);
				check_out_time_flag=false;
				flag=false;
			}
			if (flag==true && case_called_time1!="" && compareDateTimes(check_out_time,case_called_time))
			{
				
				//alert("check out time should be greater than case call time...");
				//var msg_1 = getOTMessage("DATE1_NOT_LESSER_THAN_DATE2");
				var msg_1 = getMessage("DATE1_NOT_LESSER_THAN_DATE2","OT");
				var msgArr = msg_1.split("#");
				var checkout_time = getLabel("eOT.CheckOutTime.Label","OT");
				var case_call_time = getLabel("eOT.CaseCalledTime.Label","OT");
				alert(msgArr[0]+checkout_time+msgArr[1]+case_call_time+msgArr[2]);
				check_out_time_flag=false;
			}
			if (flag==true && compareDateTimes1(check_out_time,current_time))
			{
				//alert(check_out_time+"<-->"+case_called_time);
				//alert("check out time should be less than or equal to system time...");
				//var msg_1 = getOTMessage("DATE1_NOT_GREATER_THAN_DATE2");
				var msg_1 = getMessage("DATE1_NOT_GREATER_THAN_DATE2","OT");
				var msgArr = msg_1.split("#");
				var checkout_time = getLabel("eOT.CheckOutTime.Label","OT");
				var systemdatetime =getLabel("Common.SystemDateTime.label","Common");
				alert(msgArr[0]+checkout_time+msgArr[1]+systemdatetime+msgArr[2]);
				check_out_time_flag=false;
			}
		/*	if(check_out_time_flag==true){
					var xmlDoc = "" ;
					var xmlHttp = new XMLHttpRequest();
					var xmlStr ="<root><SEARCH ";
					xmlStr += " check_out_time=\""+ check_out_time + "\" ";
					xmlStr +=" /></root>";
					xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");					xmlHttp.open("POST","CompareSysTime.jsp?check_out_time="+check_out_time);
					xmlHttp.send(xmlDoc);
					alert("here");
					var retVal = trimString(xmlHttp.responseText);
					alert(retVal);
				//call the jsp and pass check_out_time and compare with systime.
				//get the flag whether less or greater
				// if check_out_time_flag < sysdate ....alert and check_out_time_flag=false
			}*/
		}
		
		if(check_out_time_flag==true){
			var checklist_flag = "true";
			var check_for_check_list_compl = formObj.check_for_check_list_compl.value;
			if(bookings_type=="S"){ // only for Surgery bookings Type
				if(check_for_check_list_compl=="Y"){

					 /*  added below calling getUserInfo by Sathish.K on 04/05/2010 for PE. getUserInfo bean method, instead of calling onload of WardChkOutOTResults.jsp calli ng for at the time of clicking Check out patient */
					var appt_yn	            = eval("formObj.appt_yn_"+rownum).value;	
					var appt_ref_num        = eval("formObj.appt_ref_num_"+rownum).value;
					var order_id            = eval("formObj.order_id_"+rownum).value;
					var checklist_completed_yn="";

					//var xmlDoc  = new ActiveXObject( "Microsoft.XMLDom" ) ;
					var xmlHttp = new XMLHttpRequest();
					var xmlStr  ="<root><SEARCH ";
					xmlStr += " appt_ref_num=\""+ appt_ref_num + "\" ";
					xmlStr += " order_id=\""+ order_id + "\" ";
					xmlStr += " appt_yn=\""+ appt_yn + "\" ";
					xmlStr +=" /></root>";
					var xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");		
					xmlHttp.open("POST","WardChkOutValidation.jsp?func_mode=getUserInfo",false);
					xmlHttp.send(xmlDoc);
					var retVal1 = await trimString(xmlHttp.responseText);
          retVal1 = retVal1.replace(/<[^>]*>|\s+/g, '');

					if(retVal1!="")
					{
					retVal1=retVal1.split("$$")
					checklist_completed_yn=retVal1[1];
					}
					//var checklist_completed_yn = eval("formObj.checklist_completed_yn_"+rownum).value;
					if(checklist_completed_yn=="N"){
						checklist_flag = "false";
				//		var msg = getOTMessage("INCOMPLETE_CHECKLIST");
						var msg = getMessage("INCOMPLETE_CHECKLIST","OT");
						alert(msg);
						//parent.parent.messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num="+ msg;
					}
				}
			}
			if(checklist_flag == "true"){
				//retVal=confirm("Do you want to continue?");
				//retVal=confirm(getOTMessage("APP-OT0079"));
					retVal=confirm(getMessage("APP-OT0079","OT"));
				if(retVal==true){
					//call the bean to update the status and commit
					var xmlDoc = "" ;
					var xmlHttp = new XMLHttpRequest();
					var xmlStr ="<root><SEARCH ";
					xmlStr += " booking_num=\""+ appt_ref_num + "\" ";
					xmlStr += " bookings_type=\""+ bookings_type + "\" ";
					xmlStr += " check_out_time=\""+ check_out_time + "\" ";
					xmlStr +=" /></root>";
					xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");		
					xmlHttp.open("POST","WardChkOutValidation.jsp?func_mode=updateStatusAndCommit",false);
					xmlHttp.send(xmlDoc);
					retVal = await trimString(xmlHttp.responseText);
          retVal = retVal.replace(/<[^>]*>|\s+/g, '');
					if(retVal=="NO_ERROR_FOUND"){
						var msg = getMessage("RECORD_INSERTED","SM");
						clearBean();
						parent.document.location.reload();
						parent.parent.messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num="+ msg;
					}else{
						//alert(retVal);
						clearBean();
						parent.document.location.reload();
						parent.parent.messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num="+ msg;
					}
				}
			}
		}
	}else if(function_name.search("Verify Check List") == 0 && bookings_type=="S"){
		/*var no_of_verifications = eval("formObj.no_of_verifications_"+rownum).value;
		var role_id_1 = eval("formObj.role_id_1_"+rownum).value;
		var role_id_2 = eval("formObj.role_id_2_"+rownum).value;
		var role_id_3 = eval("formObj.role_id_3_"+rownum).value;
		var role_id_4 = eval("formObj.role_id_4_"+rownum).value;
		var checklists = eval("formObj.verify_checklist_codes_"+rownum).value;*/
        /* Commented above Code and added below calling getCheckListsDetails by Sathish.K on 04/05/2010 for PE. getOperChecklists bean method instead of calling onload of WardChkOutOTResults.jsp calli ng for at the time of clicking verifyCheckList*/
        var appt_yn	            = eval("formObj.appt_yn_"+rownum).value;	
		var appt_ref_num        = eval("formObj.appt_ref_num_"+rownum).value;
		var speciality_code     = eval("formObj.speciality_code_"+rownum).value;
		var order_id            = eval("formObj.order_id_"+rownum).value;
		var no_of_verifications = "";
		var role_id_1           = "";
		var role_id_2           = "";
		var role_id_3           = "";
		var role_id_4           = "";
		var checklists          = "";
		var xmlDoc = "" ;
		var xmlHttp = new XMLHttpRequest();
		var xmlStr ="<root><SEARCH ";
		xmlStr += " appt_ref_num=\""+ appt_ref_num + "\" ";
		xmlStr += " speciality_code=\""+ speciality_code + "\" ";
		xmlStr += " order_id=\""+ order_id + "\" ";
		xmlStr +=" /></root>";
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");		
		xmlHttp.open("POST","WardChkOutValidation.jsp?func_mode=getCheckListsDetails",false);
		xmlHttp.send(xmlDoc);
		retVal = trimString(xmlHttp.responseText);
		retVal = retVal.replace(/<[^>]*>|\s+/g, '');
		
		if(retVal!=""){
		 retVal     = retVal.split("$$");
		 checklists = retVal[0];
         no_of_verifications = retVal[1];
		 role_id_1  = retVal[2];
		 role_id_2  = retVal[3];
		 role_id_3  = retVal[4];
		 role_id_4  = retVal[5];
		}
		var checklist_arr = checklists.split("##");
		var verify_checklist_codes = "&verify_checklist_code_1="+checklist_arr[0];
		var count=1;
		for(i=1;i<checklist_arr.length;i++){
			count++;		
			//verify_checklist_codes+=verify_checklist_codes+"&verify_checklist_code_"+count+"="+checklist_arr[i];
			verify_checklist_codes=verify_checklist_codes+"&verify_checklist_code_"+count+"="+checklist_arr[i];  //Modified Against AAKH-SCF-0478
		}
		var booking_or_oper_flag = "B";
		if(order_id!=null && order_id!="null" && order_id!="" && appt_yn!="Y")
			booking_or_oper_flag = "ORD";

		//var checklist_completed_yn = eval("formObj.checklist_completed_yn_"+rownum).value;
		//var old_checklist_user_id = (eval("formObj.old_checklist_user_id_"+rownum).value).toUpperCase();
		//alert("old_checklist_user_id  : "+old_checklist_user_id)
		var old_checklist_user_id = "";
		var user_id = (formObj.user_id.value).toUpperCase();
		var disable_checklist_fields = "N";
		var access="NYNNY";

		 /*  added below calling getUserInfo by Sathish.K on 04/05/2010 for PE. getUserInfo bean method, instead of calling onload of WardChkOutOTResults.jsp calli ng for at the time of clicking verifyCheckList*/
        
        var xmlDoc = "" ;
		var xmlHttp = new XMLHttpRequest();
		var xmlStr ="<root><SEARCH ";
		xmlStr += " appt_ref_num=\""+ appt_ref_num + "\" ";
		xmlStr += " order_id=\""+ order_id + "\" ";
		xmlStr += " appt_yn=\""+ appt_yn + "\" ";
		xmlStr +=" /></root>";
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");		
		xmlHttp.open("POST","WardChkOutValidation.jsp?func_mode=getUserInfo",false);
		xmlHttp.send(xmlDoc);
		retVal1 = await trimString(xmlHttp.responseText);
    retVal1 = retVal1.replace(/<[^>]*>|\s+/g, '');
		if(retVal1!="")
		{
        retVal1=retVal1.split("$$")
			old_checklist_user_id=retVal1[0].toUpperCase();
			checklist_completed_yn=retVal1[1];
		}
		if(old_checklist_user_id!="" && old_checklist_user_id!="null" && old_checklist_user_id!="NULL"){
			if(user_id.toUpperCase()!=old_checklist_user_id.toUpperCase()){
				disable_checklist_fields = "disabled"
				access="NNNNY";
			}
		}
		if(checklist_completed_yn=="Y"){
			disable_checklist_fields = "disabled"
			access="NNNNY";
		}
		var db_param_1="module_id=OT&function_type=F"+"&menu_id="+menu_id+"&access="+access+"&home_required_yn=N";
		var function_string = getFunctionString(url_desc);
		var db_param = db_param_1 + function_string;
		var url = url_desc+"?"+db_param+"&called_from=CHK_OUT_WARD&facility_id="+facility_id+"&patient_id="+patient_id+"&booking_num="+appt_ref_num+"&order_id="+order_id+"&appt_yn="+appt_yn+verify_checklist_codes+"&checklist_codes_count="+count+"&checklist_stage=C10&pre_or_post=P&booking_or_oper_flag="+booking_or_oper_flag+"&no_of_verifications="+no_of_verifications+"&user_id="+user_id+"&slate_user_id="+user_id+"&role_id_1="+role_id_1+"&role_id_2="+role_id_2+"&role_id_3="+role_id_3+"&role_id_4="+role_id_4+"&disable_checklist_fields="+disable_checklist_fields+"&invoked_from=CHKOUTFROMWARD&oper_num=";
		//alert(url);
		var retVal;
		/*
		var dialogHeight = "40" ;
		var dialogWidth  = "52" ;
		var dialogTop    = "200";
		var dialogLeft   = "100";
		Modified By Sathish on 06/11/07 for the purpose of fullscreen
		*/
		var dialogHeight = "650px" ;
	    var dialogWidth  = "1200px" ;
	    var dialogTop    = "0";
	    var dialogLeft   = "0";
	  
		var features     = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth+ "; dialogLeft:" + dialogLeft+ "; dialogTop:" +dialogTop+ "; status=no" ;

		var arguments    = "" ;
    url = url.replace(/<[^>]*>| /g, '');
		retVal 	   = await parent.window.showModalDialog(url, arguments, features);
		clearBean();
		if(retVal==null){
		}else if(retVal=="undefined" || retVal=='undefined'){
			}else if(retVal!="null" && retVal!="" && retVal!="Y" && retVal!="N"){
				parent.messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num="+retVal;
			}else if(retVal!="null" && retVal!="" && retVal=="Y"){
				//eval("formObj.checklist_completed_yn_"+rownum).value = "Y";
			}//else
				//parent.parent.messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num=";

			if(parent.parent.document.forms[0]!=null){
				var formObj1 = parent.parent.document.forms[0];
				if(formObj1.name=="WardChkOutForm")
					slate_params=formObj1.params.value;
			}
			if (slate_params==""){
				var checkoutfromward_legend = getLabel("eOT.CheckOutFromWard.Label","OT");	
				slate_params = "module_id=OT&function_id=OT_CHK_OUT_WARD_JAVA&function_name="+checkoutfromward_legend+"&function_type=F&menu_id="+menu_id+"&access=NNNNN";
			}if(called_from!="CA")
				top.content.frames[0].location.href = "../../eCommon/jsp/commonToolbar.jsp?"+slate_params;
		var msg = getMessage("RECORD_INSERTED","SM");
		parent.document.location.reload();
		//parent.messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num="+ msg;
		//if(retVal=="N")
		//eval("formObj.checklist_completed_yn_"+rownum).value = "Y";
	}else if(function_name.search("Verify Check List") == 0 && bookings_type=="R"){
		var booking_or_oper_flag = "B";
		if(order_id!=null && order_id!="null" && order_id!="" && appt_yn!="Y")
			booking_or_oper_flag = "ORD";
		var user_id = (formObj.user_id.value).toUpperCase();
		var access="NYNNY";
		var db_param_1="module_id=OT&function_type=F"+"&menu_id="+menu_id+"&access="+access+"&home_required_yn=N";
		var function_string = getFunctionString(url_desc);
		var db_param = db_param_1 + function_string;
		var url = "ExamsCheckListMain.jsp?"+db_param+"&called_from=CHK_OUT_WARD&facility_id="+facility_id+"&patient_id="+patient_id+"&booking_num="+appt_ref_num+"&order_id="+order_id+"&booking_or_oper_flag="+booking_or_oper_flag+"&user_id="+user_id+"&slate_user_id="+user_id+"&disable_checklist_fields="+disable_checklist_fields+"&invoked_from=CHKOUTFROMWARD";
		//alert(url);
		var retVal;
		/*
		var dialogHeight = "40" ;
		var dialogWidth  = "52" ;
		var dialogTop    = "200";
		var dialogLeft   = "100";
		Modified By Sathish on 06/11/07 for the purpose of fullscreen
		*/
		var dialogHeight = "60" ;
	    var dialogWidth  = "130" ;
	    var dialogTop    = "0";
	    var dialogLeft   = "0";
		var features     = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth+ "; dialogLeft:" + dialogLeft+ "; dialogTop:" +dialogTop+ "; status=no" ;

		var arguments    = "" ;
		retVal 	   = await window.showModalDialog(url, arguments, features);
		clearBean();
		if(retVal==null){
		}else if(retVal=="undefined" || retVal=='undefined'){
			}else if(retVal!="null" && retVal!="" && retVal!="Y" && retVal!="N"){
				parent.messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num="+retVal;
			}else if(retVal!="null" && retVal!="" && retVal=="Y"){
				//eval("formObj.checklist_completed_yn_"+rownum).value = "Y";
			}//else
				//parent.parent.messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num=";

			if(parent.parent.document.forms[0]!=null){
				var formObj1 = parent.parent.document.forms[0];
				if(formObj1.name=="WardChkOutForm")
					slate_params=formObj1.params.value;
			}
			if (slate_params==""){
				var checkoutfromward_legend = getLabel("eOT.CheckOutFromWard.Label","OT");	
				slate_params = "module_id=OT&function_id=OT_CHK_OUT_WARD_JAVA&function_name="+checkoutfromward_legend+"&function_type=F&menu_id="+menu_id+"&access=NNNNN";
			}
			if(called_from!="CA")
				top.content.frames[0].location.href = "../../eCommon/jsp/commonToolbar.jsp?"+slate_params;
		var msg = getMessage("RECORD_INSERTED","SM");
		parent.document.location.reload();
		//parent.messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num="+ msg;
		//if(retVal=="N")
		//eval("formObj.checklist_completed_yn_"+rownum).value = "Y";
	}
	// Added for IN:41808
	else if(function_name.search("Operating Site Identification") == 0 && bookings_type=="S"){
	var dialogHeight	= '25' ;
	var dialogWidth		= '65' ;
	var dialogTop		= 58;
	var arguments		= ''; 
	var features    = 'dialogHeight:' + dialogHeight + '; dialogWidth:' + dialogWidth +'; status=no;';
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest() ;
	var xmlStr ="<root><SEARCH ";
	xmlStr +=" /></root>";
	var param="func_mode=pat_gender_check&patient_id="+patient_id;
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST","../../eOT/jsp/OTCommonValidation.jsp?"+param,false);
	xmlHttp.send(xmlDoc);
	var retVal = await localTrimString(xmlHttp.responseText);	
  retVal = retVal.replace(/<[^>]*>|\s+/g, '');
	var patgender = retVal;
	var url			= "../../eOT/jsp/OperatingSiteIdentification.jsp";
	url=url+"?nd_booking_num="+appt_ref_num+"&sex="+patgender+"&p_module_id="+"OT"+"&p_report_id="+"OTOSIDEN"+"&nd_facility_id="+facility_id+"&facility_id="+facility_id+"&Patient_ID=" +patient_id;
	retVal=  await  window.showModalDialog(url,arguments,features);
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
	// End for IN:41808
	else{
		var db_param_1="module_id=OT&function_type=F"+"&menu_id="+menu_id+"&access=NNNNY&home_required_yn=N";
		var function_string = getFunctionString(url_desc);
		var db_param = db_param_1 + function_string;
		var view_booking_params = "&facility_id="+facility_id;
		if(function_name=="View Booking Details") // used only for vewi booking details
			view_booking_params = view_booking_params+"&orderid=0&transfer=5";

		var url = url_desc+"?"+db_param+"&called_from=CHK_OUT_WARD&facility_id="+facility_id+"&patient_id="+patient_id+"&booking_no="+appt_ref_num+"&view_booking_params="+view_booking_params;
		//alert(url);
		var retVal;
		/*
		var dialogHeight = "40" ;
		var dialogWidth  = "52" ;
		var dialogTop    = "200";
		var dialogLeft   = "100";
		Modified By Sathish on 06/11/07 for the purpose of fullscreen
		*/
		var dialogHeight = "650px" ;
	    var dialogWidth  = "1200px" ;
	    var dialogTop    = "0";
	    var dialogLeft   = "0";
		var features     = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth+ "; dialogLeft:" + dialogLeft+ "; dialogTop:" +dialogTop+ "; status=no" ;

		var arguments    = "" ;
		retVal 	   = await parent.window.showModalDialog(url, arguments, features);

		clearBean();
		var slate_params = "";
		if(retVal==null || retVal=="" || retVal=="undefined" ||retVal=="null"){
			if(parent.parent.document.forms[0]!=null){
				var formObj1 = parent.parent.document.forms[0];
				if(formObj1.name=="WardChkOutForm")
					slate_params=formObj1.params.value;
			}
			if (slate_params==""){
				var checkoutfromward_legend = getLabel("eOT.CheckOutFromWard.Label","OT");	

				slate_params = "module_id=OT&function_id=OT_CHK_OUT_WARD_JAVA&function_name="+checkoutfromward_legend+"&function_type=F&menu_id="+menu_id+"&access=NNNNN";
			}
			if(called_from!="CA")
				top.content.frames[0].location.href = "../../eCommon/jsp/commonToolbar.jsp?"+slate_params;
		}
		var msg = getMessage("RECORD_INSERTED","SM");
		/*typeof url_desc_list!="ViewBookingDetailsQuery.jsp" condition(pls change the condition if file name changed) added by sathish for PE on 30-04-2010 for view booking details its not required to reload the frame */
		if(url_desc!="ViewBookingDetailsQuery.jsp"){
		parent.document.location.reload();
		}
		//parent.messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num="+ msg;
	}
} // End of the Function callMenuFunctions
function getFunctionString(url_desc){
	var function_string = "";
	return function_string;
}
function hideToolTip(){
  document.getElementById("tooltiplayer3").style.visibility = 'hidden';
}

function callMouseOver(obj){
	currClass = obj.className ;
	obj.className = 'OTMENU';
}

function callOnMouseOut(obj){
	obj.className = currClass;
}


function resizeWindow(){
	bodwidth = parent.frames[1].document.body.offsetWidth
	bodheight = parent.frames[1].document.body.offsetHeight

	var x =event.x
	var y =  event.y;

	x = x + (document.getElementById("tooltiplayer").offsetWidth)
	y = y + (document.getElementById("tooltiplayer").offsetHeight)

	if(x<bodwidth)
		x =event.x
	else
		x = x - (document.getElementById("tooltiplayer").offsetWidth*2)

	if(y<bodheight){
		 y =event.y
	}else{
		y = y - (document.getElementById("tooltiplayer").offsetHeight*2)
	}

	y+=document.body.scrollTop
	x+=document.body.scrollLeft

	document.getElementById("tooltiplayer").style.posLeft= x
	document.getElementById("tooltiplayer").style.posTop = y
	document.getElementById("tooltiplayer").style.visibility='visible'
}
// drop-down menu till here

function lockKey(){
    if(event.keyCode == 93){
        //alert("Welcome to eHIS");
		//alert(getOTMessage("APP-OT0084"));
		alert(getMessage("APP-OT0084","OT"));
	}
}

   function compareDateTimes(fromdate,todate) {
    var fromarray; var toarray;
    if(fromdate.length > 0 && todate.length > 0 ) {
			var from_date_array = fromdate.split(" ");
			var from_date = from_date_array[0];
			var from_time = from_date_array[1];
			var to_date_array = todate.split(" "); 
			var to_date = to_date_array[0];
			var to_time = to_date_array[1];
            var fromdatearray = from_date.split("/");
            var todatearray = to_date.split("/");
            var fromtimearray = from_time.split(":");
            var totimearray = to_time.split(":");
			var fromdt = new Date(fromdatearray[2],fromdatearray[1],fromdatearray[0],fromtimearray[0],fromtimearray[1]);
            var todt = new Date(todatearray[2],todatearray[1],todatearray[0],totimearray[0],totimearray[1]);
			//alert(new Date(2004,11,24,23,11)); is the format used above yyyy,mm,dd,hh24,mi
            if(Date.parse(todt) < Date.parse(fromdt)) {
                return false;
            }
    }
	return true;
}

 function compareDateTimes1(fromdate,todate) {
    var fromarray; var toarray;
    if(fromdate.length > 0 && todate.length > 0 ) {
			var from_date_array = fromdate.split(" ");
			var from_date = from_date_array[0];
			var from_time = from_date_array[1];
			var to_date_array = todate.split(" ");
			var to_date = to_date_array[0];
			var to_time = to_date_array[1];
            var fromdatearray = from_date.split("/");
            var todatearray = to_date.split("/");
            var fromtimearray = from_time.split(":");
            var totimearray = to_time.split(":");
			var fromdt = new Date(fromdatearray[2],fromdatearray[1],fromdatearray[0],fromtimearray[0],fromtimearray[1]);
            var todt = new Date(todatearray[2],todatearray[1],todatearray[0],totimearray[0],totimearray[1]);
			//alert(new Date(2004,11,24,23,11)); is the format used above yyyy,mm,dd,hh24,mi
            if(Date.parse(todt) >= Date.parse(fromdt)) {
                return false;
            }
    }
	return true;
}


function chkTimeFormat(obj)
{
	if(obj.value!=null && obj.value!="")
	{
	var retVal= chkTime(obj.value)
		if(retVal== false)
		{
			alert("Time Format should be hh:mi");
			obj.select();
		}
	}
}

function isValidDate(obj){
	if(obj.value!=""){
		//var RE_NUM = /^(0[1-9]|[12][0-9]|3[01])\/(0[1-9]|1[012])\/(20)[0-9]{2}$/;
		var RE_NUM =  /^\/?\d+$/;
		var str_date = obj.value;
		var arr_date = str_date.split('/');
		if (arr_date.length != 3) return cal_error ("Invalid date format: '" + str_date + "'.\nFormat accepted is dd/mm/yyyy.",obj);
		if (!arr_date[0]) return cal_error ("Invalid date format: '" + str_date + "'.\nNo day of month value can be found.",obj);
		if (!RE_NUM.exec(arr_date[0])) return cal_error ("Invalid day of month value: '" + arr_date[0] + "'.\nAllowed values are unsigned integers.",obj);
		if (!arr_date[1]) return cal_error ("Invalid date format: '" + str_date + "'.\nNo month value can be found.",obj);
		if (!RE_NUM.exec(arr_date[1])) return cal_error ("Invalid month value: '" + arr_date[1] + "'.\nAllowed values are unsigned integers.",obj);
		if (!arr_date[2]) return cal_error ("Invalid date format: '" + str_date + "'.\nNo year value can be found.",obj);
		if (arr_date[2].length!=4) return cal_error ("Invalid year value: '" + arr_date[2] + "'.\nAllowed format YYYY.",obj);
		var dt_date = new Date();
		dt_date.setDate(1);
		if (arr_date[1] < 1 || arr_date[1] > 12) return cal_error ("Invalid month value: '" + arr_date[1] + "'.\nAllowed range is 01-12.",obj);
		dt_date.setMonth(arr_date[1]-1);
		var dt_numdays = new Date(arr_date[2], arr_date[1], 0);
		dt_date.setDate(arr_date[0]);
		if (dt_date.getMonth() != (arr_date[1]-1)) return cal_error ("Invalid day of month value: '" + arr_date[0] + "'.\nAllowed range is 01-"+dt_numdays.getDate()+".",obj);
		//if(arr_date[2].length==4 && arr_date[2]>=dt_date.getFullYear() ) return cal_error ("Not a valid Year value: '" + arr_date[2] + "'.\nCurrent Year "+dt_date.getFullYear()+" Only Allowed .",obj);	
	}
	return true;
}
function cal_error (str_message,obj) {
	alert (str_message);
	obj.focus();
	obj.select();
	return null;
}


function  reasonToolTip3(stvar,indx)
{
	var arr=new Array();
	var frmObj=document.forms[0];
	var arrMsg=eval("frmObj."+stvar+""+indx+".value");
	arr=arrMsg.split(",");
	var cou=0;
	var tab_dat  = "<table id ='tooltiptable3' cellpadding=0 cellspacing=0 border='0' class='BOX' width='100%' height='100%' align='center'>";
		
	for( cou=0;cou<arr.length;cou++)
	{
			msg=arr[cou];
			tab_dat     += "<tr>"
			tab_dat     += "<td class='label' >"+msg+"</td>"		
			tab_dat     += "</tr> ";	
		}
			tab_dat     += "</table> ";	

	document.getElementById("tooltiplayer3").innerHTML = tab_dat;
	resizeWindow3();
}

function resizeWindow3(){
	bodwidth =parent.frames[1].document.body.offsetWidth;
	bodheight = parent.frames[1].document.body.offsetHeight;

	var x =event.x;
	var y =event.y;

	x = x + (document.getElementById("tooltiplayer3").offsetWidth)
	y = y + (document.getElementById("tooltiplayer3").offsetHeight)

	if(x<bodwidth)
		x =event.x
	else
		x = x - (document.getElementById("tooltiplayer3").offsetWidth*1)

	if(y<bodheight){
		 y =event.y
	}else{
		y = y - (document.getElementById("tooltiplayer3").offsetHeight*1)
	}

	y+=document.body.scrollTop
	x+=document.body.scrollLeft

	document.getElementById("tooltiplayer3").style.posLeft= x
	document.getElementById("tooltiplayer3").style.posTop = y
	document.getElementById("tooltiplayer3").style.visibility='visible'
}
function hideToolTip3(){
  document.getElementById("tooltiplayer3").style.visibility = 'hidden';
}

async function searchWard(obj){
	var locale = document.forms[0].locale.value;
	var result			=	false ;
	var message			=	"" ;
	var flag			=	"" ;
	var function_id		=	"";
	var argumentArray   = new Array();
	var dataNameArray   = new Array();
	var dataValueArray  = new Array();
	var dataTypeArray   = new Array();
	var facility_id     = document.forms[0].facility_id.value;
	// Code altered by Selvam for PHASE 3 Delivery
//	var sql="select short_desc description, nursing_unit_code code from IP_NURSING_UNIT_LANG_VW where LANGUAGE_ID='"+locale+"' AND facility_id = '"+facility_id+"' and nvl(eff_status,'X') = 'E'  and upper(short_desc) like upper(?) and upper(nursing_unit_code) like upper(?) order by 2";	
	var sql="SELECT LONG_DESC DESCRIPTION, NURSING_UNIT_CODE CODE FROM IP_NURSING_UNIT_LANG_VW WHERE LANGUAGE_ID='"+locale+"' AND FACILITY_ID = '"+facility_id+"' AND NVL(EFF_STATUS,'X') = 'E'  AND UPPER(LONG_DESC) LIKE UPPER(?) AND UPPER(NURSING_UNIT_CODE) LIKE UPPER(?) ORDER BY 2";	
	argumentArray[0] = sql;
	argumentArray[1] = dataNameArray;
	argumentArray[2] = dataValueArray;
	argumentArray[3] = dataTypeArray;
	argumentArray[4] = "2,1";
	argumentArray[5] = obj.value;
	argumentArray[6] = DESC_LINK;
	argumentArray[7] =DESC_CODE;
//	returnedValues = CommonLookup("Nursing Unit", argumentArray );
	var nursing_unit_title = getLabel("Common.nursingUnit.label","Common");
	returnedValues = await CommonLookup(nursing_unit_title, argumentArray );
	if(returnedValues.length == 1 && returnedValues[0] != null && returnedValues[0] != '')
		returnedValues=returnedValues[0].split(',') ;
	if((returnedValues != null) && (returnedValues != "") ){
		document.forms[0].nursing_unit.value= returnedValues[0];
		document.forms[0].nursing_unit_name.value= returnedValues[1];
	}else{
		obj.value='';	
	}
}
function getSysTime(obj){
	if(obj.value!=""){
		var xmlStr ="<root><SEARCH ";
		xmlStr +=" /></root>";
		var temp_jsp="HoldingAreaValidation.jsp?func_mode=getSysTime";
		var xmlDoc = "" ;
		var xmlHttp = new XMLHttpRequest() ;
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open("POST",temp_jsp,false);
		xmlHttp.send(xmlDoc);
		responseText=xmlHttp.responseText ;
		obj.value=trimString(responseText);
	}
	//alert(responseText);
	//return responseText;
}

function trimString(sInString) {
  sInString = sInString.replace( /^\s+/g, "" );// strip leading
  return sInString.replace( /\s+$/g, "" );// strip trailing
}


//newly added on 14-05 for SCR-3032

function assignChkBoxVal(obj){
	if(obj.checked==true){
		obj.value="Y";
	}
	else{
		obj.value="N";
	}
}

//Newly added for Amazon Changes......
	function callMouseOver(obj)	{

		currClass = obj.className ;
		obj.className = 'selectedcontextMenuItem';

	}

	function callOnMouseOut(obj){
		obj.className = 'contextMenuItem';
	}

 
//	function resizeWindow(orderctlHDR)
//	{
//
//	    var orderctlHDR1 = orderctlHDR.id;
//		var wdth = eval("document.all."+orderctlHDR1).offsetWidth;
//		var hght1 = eval("document.all."+orderctlHDR1).offsetHeight;		
//		var wdth1 = getPos(orderctlHDR).x +wdth;
//		var hght = getPos(orderctlHDR).y ;	
//		bodwidth  = document.body.offsetWidth
//		bodheight = document.body.offsetHeight
//		var z = bodwidth- (event.x + wdth);	
//		var x 	  = event.x;
//		var y 	  = event.y;	
//		x 	  = x + (document.getElementById("tooltiplayer").offsetWidth);
//		y 	  = hght + (document.getElementById("tooltiplayer").offsetHeight);	
//		if(x<bodwidth){
//			x= wdth1;			
//		}else{			
//			x = getPos(orderctlHDR).x;
//		}
//	/*	if(y<bodheight){			
//			y = hght;
//		}else
//		{
//			y = y - (document.getElementById("tooltiplayer").offsetHeight*2) + hght1 ;	
//		}*/
//		y = hght;
//		document.getElementById("tooltiplayer").style.posLeft= x;
//		document.getElementById("tooltiplayer").style.posTop = y;
//		document.getElementById("tooltiplayer").style.visibility='visible'
//	}
	
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
			 /*eval("document.all."+prevObjID).className = 'gridDataBlue';
			 eval("document.all."+prevImgObj).src = "../../eCommon/images/inactiveArrow.gif";*/	
			document.getElementById(prevObjID).className = 'gridDataBlue';
			document.getElementById(prevImgObj).src = "../../eCommon/images/inactiveArrow.gif";			 
		 }		 
		obj.className = 'selectedTDData';
		//eval("document.all."+imgObj).src = "../../eCommon/images/activeArrow.gif";
		document.getElementById(imgObj).src = "../../eCommon/images/activeArrow.gif";
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
            } else {
                //alert("Could not find any reference for coordinate positioning.");
            }
        }
        return coords;
    } catch(error) {
        //alert(error.msg);
        return coords;
    }
}
	function hidemenu()
	{
		document.getElementById("tooltiplayer").style.visibility = 'hidden';
	}
//Amazon Changes Ends Here....


function checkPatientId(obj){
	var formObj = document.WardChkOutSearchForm;
	var patient_id=obj.value;
	var len=getPaientIdLen();
	if(patient_id.length!=len){
		alert("Invalid Patient Id");
		formObj.patient_id.value='';
		formObj.patient_name.value='';
		return false;

	}else{
		deafaultPatientID(obj);
	}

}

function CheckForSpecChars(event)
{
    var strCheck = '0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz';
    var whichCode = (window.Event) ? event.which : event.keyCode;
    key = String.fromCharCode(whichCode);  // Get key value from key code
    if (strCheck.indexOf(key) == -1) return false;  // Not a valid key
	if( (event.keyCode >= 97) && (event.keyCode <= 122) )
	return (event.keyCode -= 32);
	return true ;
}



function deafaultPatientID(obj){
	var formObj = document.WardChkOutSearchForm;
	var nursing_unit = formObj.nursing_unit.value;
	var patient_id = obj.value;
	var locale = formObj.locale.value;
	if(nursing_unit!=""){
		var dialogTop  = ";";
		var dialogHeight = "450px";
		var dialogWidth  = "650px";
		var arguments = "";
		var column_sizes = escape("20%,60%,20%");
		//var column_descriptions = escape("Patient Id,Patient Name,Encounter Id");
		var column_descriptions = getLabel('Common.patientId.label','common')+','+getLabel('Common.PatientName.label','Common')+','+getLabel('Common.encounter.label','Common');
		column_descriptions = encodeURIComponent(column_descriptions);
		var sql=escape("SELECT I.PATIENT_ID PATIENT_ID1, DECODE('"+locale+"','en',M.PATIENT_NAME, NVL(M.PATIENT_NAME_LOC_LANG,M.PATIENT_NAME)) SHORT_NAME1,O.OPEN_EPISODE_ID OPEN_EPISODE_ID FROM MP_PATIENT M, IP_OPEN_EPISODE O, IP_EPISODE I WHERE M.PATIENT_ID = O.PATIENT_ID AND O.OPEN_EPISODE_ID=I.EPISODE_ID AND O.PATIENT_ID=I.PATIENT_ID AND I.CUR_WARD_CODE='"+nursing_unit+"' AND I.PATIENT_ID='"+patient_id+"' ");
		var  title = encodeURIComponent(getLabel("Common.patient.label","Common"));
		var features  = "dialogTop:"+dialogTop+"dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +";status=no";
		var param = "title="+title+"&"+"column_sizes="+column_sizes+"&"+"column_descriptions="+column_descriptions+"&sql="+sql+"&search_criteria="+patient_id;
		retVal=window.showModalDialog("../../eOT/jsp/OTGeneralSearchFrames.jsp?"+param,arguments,features);

		if(retVal!=null){
		var arr = retVal.split('::');
			formObj.patient_id.value=arr[0];
			formObj.patient_name.value=arr[1];
		}else{
			formObj.patient_id.value='';
			formObj.patient_name.value='';
		}
	}else{
		var msg_1 = getMessage("CANNOT_BE_BLANK","OT") ;
		var msgArray = msg_1.split("&");
		alert(msgArray[0]+" "+getLabel("Common.nursingUnit.label","Common")+" "+(msgArray[1]));
		formObj.patient_id.value='';
		formObj.patient_name.value='';
	}
}

function localTrimString(sInString) {
  return sInString.replace(/^\s+|\s+$/g,"");
}

function getPaientIdLen(){
	var sql="SELECT PATIENT_ID_LENGTH FROM MP_PARAM WHERE MODULE_ID ='MP'";
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest() ;
	var xmlStr ="<root></root>";
	param="flag=MED_SER&sql="+sql;
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST", "../../servlet/eOT.CommonQueryServlet?"+param,false);
	xmlHttp.send(xmlDoc);
	var retVal = localTrimString(xmlHttp.responseText);
	return retVal;
}
