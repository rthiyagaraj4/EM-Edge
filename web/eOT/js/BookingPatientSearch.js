/*
*Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
* 
*Warning: This computer program is protected by copyright law and international treaties.
*Unauthorized reproduction or distribution of this program, or any portion of it, 
*may result in severe civil and criminal penalties, and will be prosecuted to 
*the maximum extent possible under the law.
*/
//lookup for Bookings Patient Search not Check In
async function callPatSearch(){
	var formObj=document.PreOperHdr;
	var patient_id = document.PreOperHdr.patient_id;
	var patient_name = document.PreOperHdr.patient_name;
	var date_of_birth = document.PreOperHdr.date_of_birth;
	var sex	= document.PreOperHdr.sex;

	var patientclass = document.PreOperHdr.episode_type.value;


	var male=getLabel("Common.male.label","Common");
	var female=getLabel("Common.female.label","Common");
	var unknown=getLabel("Common.unknown.label","Common");
	//Clearing all these values when patient ID is changed after encounter id is selected
	var frmObj=document.PreOperHdr;
	var duplPatientIdSearchFlag = true;//PMG2014-CRF-0024

	frmObj.patient_name.value="";
	frmObj.sex.value="";
	frmObj.date_of_birth.value="";
	frmObj.encounter_id.value="";
	frmObj.episode_id.value="";
	frmObj.visitid.value="";
	formObj.Source_code.value=""; 
	//sourceDesc field is used to store the code field.
	formObj.sourceDesc.value=""; 


	var return_value =	"";
	
	//return_value	=	(patient_id.value.length>0)?patient_id.value:PatientSearch();
	//modified by DhanasekarV on 20/12/2010 against incident  IN025593
	return_value	=(patient_id.value.length>0)?patient_id.value:await PatientSearch(null,null,null,null,null,null,null,null,null,null,null,patientclass);

	if(return_value==null)  return;
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest();
	var xmlStr ="<root></root>";
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST","CommonValidation.jsp?func_mode=patient_search&patient_id="+return_value,false);
	xmlHttp.send(xmlDoc);
	var retVal = localTrimString(xmlHttp.responseText); 
	//alert(retVal);
	if(retVal=="INVALID_PATIENT"){
			alert(getMessage("INVALID_PATIENT","MP"));
			patient_id.value="";
			patient_name.value="";
			date_of_birth.value="";
			sex.value = ""; 
			patient_id.focus();
			return
	}
	
	//PMG2014-CRF-0024 Start
	xmlStr ="<root></root>";
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST","CommonValidation.jsp?func_mode=duplPatientIdSearch&patient_id="+return_value+"&facilityId="+frmObj.facility_id.value,false);
	xmlHttp.send(xmlDoc);
	var duplPatientIdSearch = localTrimString(xmlHttp.responseText);
	var duplPatientIdSearchArray = duplPatientIdSearch.split("~");
	if(duplPatientIdSearchArray[0] == "REC_EXIST")
	{
		/*
		if(duplPatientIdSearchArray[1] == 'Y' && duplPatientIdSearchArray[2] == 'Y')
		{
			if(!window.confirm(getMessage("APP-OT0229","OT")))
				duplPatientIdSearchFlag = false;
		}
		else if(duplPatientIdSearchArray[1] == 'Y')
		{
			if(!window.confirm(getMessage("APP-OT0227","OT")))
				duplPatientIdSearchFlag = false;
		}*/
		if(duplPatientIdSearchArray[2] == 'Y')
		{
				if(!window.confirm(getMessage("APP-OT0228","OT")))
					duplPatientIdSearchFlag = false;
		}
		if(!duplPatientIdSearchFlag)
			patient_id.value = '';
	}
	// PMG2014-CRF-0024 end

	if(retVal!="" && duplPatientIdSearchFlag){ //PMG2014-CRF-0024
			var retVal_arr = retVal.split("##");
			patient_id.value		=return_value
			patient_name.value		= retVal_arr[0];
			date_of_birth.value 	= retVal_arr[1];
			sex.value = (retVal_arr[2]=="MALE")?male:(retVal_arr[2]=="FEMALE")?female:unknown;
			if (typeof(preOperDiagArray) != 'undefined') 
			{
				showPreOperDiagLink();
			}
		// Modified by DhanasekarV against the issue 24514 on 25/10/2010
		
	// Modified by DhanasekarV against the issue 25538 on 2/12/2010
	if(document.PreOperHdr.episode_type.value !='XT')
			callBookingEncounterSearch();	
		
		var isIncludeFpp = frmObj.isIncludeFpp.value; //Added Against ML-MMOH-CRF-1939-US2...
		if(!frmObj.encounter_id.value == "" && isIncludeFpp) enableProcedudureDtlFields(); //Added Against ML-MMOH-CRF-1939-US2...
	}
}


/*function callBookingEncounterSearch(){
	var obj = document.PreOperHdr.episode_type;
	var patient_id = document.PreOperHdr.patient_id.value;
	var patient_class=document.PreOperHdr.episode_type.value;
	if(patient_class==null || patient_class==""){
		var msg1 = getMessage("CAN_NOT_BE_BLANK","Common").replace("$",getLabel("Common.patientclass.label","Common"));
		alert(msg1);
	return false;
	}

	if(patient_id==null || patient_id==""){
		var msg1 = getMessage("CAN_NOT_BE_BLANK","Common").replace("$",getLabel("Common.patientId.label","Common"));
		alert(msg1);
	return false;
	}

	
	var formobj=document.PreOperHdr;
	var patient_class = document.PreOperHdr.episode_type.value;
	var patient_class_desc  = encodeURIComponent(document.PreOperHdr.episode_type.options[obj.selectedIndex].text,"UTF-8");
	var encounter_id = document.PreOperHdr.encounter_id;
	var episode_id = "";
	var visit_id = "";
	var episode_type= document.PreOperHdr.episode_type;
	var sql=escape("SELECT ENCOUNTER_ID,PATIENT_CLASS,EPISODE_ID,OP_EPISODE_VISIT_NUM,(SELECT EPISODE_TYPE FROM MP_EPISODE_TYPE_VW WHERE PATIENT_CLASS=?) EPISODE_TYPE   FROM PR_ENCOUNTER WHERE PATIENT_ID=? AND PATIENT_CLASS=?");
	var dir_param = "sql="+sql+"&patient_class="+patient_class+"&patient_id="+patient_id;
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest() ;
	var xmlStr ="<root><SEARCH ";
	xmlStr +=" /></root>";
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("GET","../../eOT/jsp/OTGeneralEncounterSearchResults.jsp?"+dir_param,false);
	xmlHttp.send(xmlDoc);
	//encounter_id+"##"+patient_class+"##"+episode_id+"##"+visit_id+"##"+episode_type;
	var retVal = localTrimString(xmlHttp.responseText);	
	var retVal_arr = retVal.split("::");
	if(retVal_arr[0]=="1"){
		formobj.encounter_id.value		= retVal_arr[1];
		formobj.episode_id.value 	= retVal_arr[3];
		formobj.visitid.value 	= retVal_arr[4];
		//formobj.submit();
	//	episode_type.value 	= retVal_arr[5];
		var result = getPatientDetails(patient_id);
		var arr = result.split("::");
		//alert(arr);
		formobj.sourceType.value=arr[2];
		formobj.Source_code.value=arr[0]; 
		//sourceDesc field is used to store the code field.
		formobj.sourceDesc.value=arr[3]; 

}else{
		// encounter_id,patient_class,episode_id,op_episode_visit_num
		var dialogTop  = "40";
		var dialogHeight = "10";
		var dialogWidth  = "40";
		var arguments = "";
		var features  = "dialogTop:"+dialogTop+"dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +";status=no";
		return_value=window.showModalDialog("../../eOT/jsp/OTEncounterPatientSearchFrames.jsp?"+"patient_class="+patient_class+"&patient_class_desc="+patient_class_desc+"&patient_id="+patient_id,arguments,features);
		if(return_value!=null){
			var retVal_arr = return_value.split("##");
				encounter_id.value		= retVal_arr[0];
				//patient_class.value 	= retVal_arr[1];
				episode_id.value 	= retVal_arr[2];
				visit_id.value 	= retVal_arr[3];
				episode_type.value 	= retVal_arr[4];
				var result = getPatientDetails(patient_id);
				var arr = result.split("::");
				formobj.sourceType.value=arr[2];
				formobj.Source_code.value=arr[0]; 
				formobj.sourceDesc.value=arr[3]; 
		}
	}
}*/
async function callBookingEncounterSearch(){
	var formObj=document.PreOperHdr;
	var episode_id = "";
	var visit_id = "";
	var obj		    =	formObj.episode_type;
	var patient_id      =   formObj.patient_id.value;
	var facility_id      =   formObj.facility_id.value;
	var patient_class  = formObj.episode_type.value
	var patient_class_desc  =(patient_class!="")?encodeURIComponent(obj.options[obj.selectedIndex].text,"UTF-8"):"";
	//alert(patient_class_desc);
	// mandatory validation of patient_id and patient_class


	if(patient_id==null || patient_id==""){
		var msg1 = getMessage("CAN_NOT_BE_BLANK","Common").replace("$",getLabel("Common.patientId.label","Common"));
		alert(msg1);
		return false;
	}

	if(patient_class==null || patient_class==""){
		var msg1 = getMessage("CAN_NOT_BE_BLANK","Common").replace("$",getLabel("Common.patientclass.label","Common"));
		alert(msg1);
		return false;
	}

	//Query commented against 39113
	//var sql="SELECT ENCOUNTER_ID,PATIENT_CLASS,EPISODE_ID,OP_EPISODE_VISIT_NUM,(SELECT EPISODE_TYPE FROM MP_EPISODE_TYPE_VW WHERE PATIENT_CLASS=?) EPISODE_TYPE   FROM PR_ENCOUNTER WHERE PATIENT_ID=? AND PATIENT_CLASS=? AND FACILITY_ID='"+facility_id+"' AND DISCHARGE_DATE_TIME IS NULL"; /* ADDED DISCHARGE_DATE_TIME CONDITION AGAINST CRF-303.1 AS TOLD BY VISHWA */
	/*Below query changed against 39113 on 02/04/2013 by MuthuN */
	var sql="SELECT ENCOUNTER_ID,PATIENT_CLASS,EPISODE_ID,OP_EPISODE_VISIT_NUM,(SELECT EPISODE_TYPE FROM MP_EPISODE_TYPE_VW WHERE PATIENT_CLASS=?) EPISODE_TYPE   FROM PR_ENCOUNTER WHERE PATIENT_ID=? AND PATIENT_CLASS=? AND FACILITY_ID='"+facility_id+"' AND DISCHARGE_DATE_TIME IS NULL AND ((patient_class IN ('OP', 'EM') AND visit_status != '09') OR (patient_class IN ('IP', 'DC') AND adt_status != '09'))";
	var dir_param = "sql="+sql+"&patient_class="+patient_class+"&patient_id="+patient_id;
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest() ;
	var xmlStr ="<root></root>";
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("GET","../../eOT/jsp/OTGeneralEncounterSearchResults.jsp?"+dir_param,false);
	xmlHttp.send(xmlDoc);
	var retVal = localTrimString(xmlHttp.responseText);	
	var retVal_arr = retVal.split("::");
	if(retVal_arr[0]=="1"){
		formObj.encounter_id.value		= retVal_arr[1];
		formObj.episode_id.value 	= retVal_arr[3];
		formObj.visitid.value 	= retVal_arr[4];
		var result = getPatientDetails(formObj.encounter_id.value,patient_class);
		/*formObj.sourceType.value=arr[2];
		formObj.Source_code.value=arr[0]; 
		//sourceDesc field is used to store the code field.
		formObj.sourceDesc.value=arr[3]; */
		//alert(result);
		var arr = result.split("@");
		formObj.sourceType.value=(arr[0]=='E')?'C':arr[0];
		formObj.sourceDesc.value=arr[1]; 
		formObj.Source_code.value=arr[2]; 
		if (typeof(preOperDiagArray) != 'undefined') 
		{
			showPreOperDiagLink();
		}
	}else{
		//encounter_id+"##"+patient_class+"##"+episode_id+"##"+visit_id+"##"+episode_type;
		var dialogTop  = "40";
		var dialogHeight = "76vh";
		var dialogWidth  = "93vw";
		var arguments = "";
		var features  = "dialogTop:"+dialogTop+";dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +";status=no";
		//return_value=window.showModalDialog("../../eOT/jsp/OTEncounterPatientSearchFrames.jsp?"+"patient_class="+patient_class+"&patient_class_desc="+patient_class_desc+"&patient_id="+patient_id,arguments,features);
		return_value=await top.window.showModalDialog("../../eOT/jsp/OTEncounterPatientSearchFrames.jsp?"+"patient_class="+patient_class+"&patient_class_desc="+patient_class_desc+"&patient_id="+patient_id+"&tabID=Booking",arguments,features); //Modified Against SS-SCF-0796
		if(return_value!=null){
			var retVal_arr = return_value.split("##");
			formObj.encounter_id.value		= retVal_arr[0];
			//patient_class.value 	= retVal_arr[1];
			formObj.episode_id.value 	= retVal_arr[2];
			formObj.visitid.value 	= retVal_arr[3];
			//episode_type.value 	= retVal_arr[4];
			var result = getPatientDetails(formObj.encounter_id.value,patient_class);
			var arr = result.split("@");
			formObj.sourceType.value=(arr[0]=='E')?'C':(arr[0]=="XT")?'E':arr[0];
			formObj.sourceDesc .value=arr[1]; 
			formObj.Source_code.value=arr[2]; 
			if (typeof(preOperDiagArray) != 'undefined') 
			{
				showPreOperDiagLink();
			}
		}
	}
}








function getPatientDetails(encounter_id,patient_class){
	var formObj = document.forms[0];
	//wardDesc+"::"+admitting_speciality_desc+"::"+source_type+"::"+source_code+"::"+operationStatus;
	var xmlStr ="<root><SEARCH ";
	xmlStr +=" /></root>";
	//var temp_jsp="PreOperChkListHdrTemp.jsp?patient_id="+patient_id;
	//SELECT ASSIGN_CARE_LOCN_TYPE||'@'||ASSIGN_CARE_LOCN_CODE||'@'||NVL(DECODE(ASSIGN_CARE_LOCN_TYPE,'C',(SELECT SHORT_DESC FROM OP_CLINIC_LANG_VW WHERE FACILITY_ID='HS' AND LANGUAGE_ID='en' AND CLINIC_CODE=ASSIGN_CARE_LOCN_CODE),(SELECT SHORT_DESC FROM IP_NURSING_UNIT_LANG_VW WHERE FACILITY_ID='HS' AND LANGUAGE_ID='en' AND NURSING_UNIT_CODE=ASSIGN_CARE_LOCN_CODE)),'') ASSIGN_CARE_LOCN_DESC  
	//FROM PR_ENCOUNTER WHERE FACILITY_ID='HS'  AND ENCOUNTER_ID='100002020001'
	var temp_jsp="../../eOT/jsp/TempEncounterLkup.jsp?encounter_id="+encounter_id+"&patient_class="+patient_class;
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest() ;
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST",temp_jsp,false);
	xmlHttp.send(xmlDoc);
	responseText=xmlHttp.responseText;
	var result = trimString(responseText);
	//alert(result);
	return result;
	//alert(result);
	//var arr = result.split("::");
/*
formObj.nursing_unit.value=arr[0];
	formObj.admitting_specialty.value=arr[1];
	formObj.source_type.value=arr[2];
	formObj.source_code.value=arr[3];
	formObj.operation_status.value=arr[4];
	*/
}

function messageWindow(title, msg){
  var width="300";
  var height="125";
  var left = (screen.width/2) - width/2;
  var top = (screen.height/2) - height/2;
  var styleStr = 'toolbar=no,location=no,directories=no,status=no,menubar=no,scrollbar=no,resizable=no,copyhistory=yes,width='+width+',height='+height+',left='+left+',top='+top+',screenX='+left+',screenY='+top;
  var msgWindow = window.open("","msgWindow", styleStr);
  var head = '<head><title>'+title+'</title></head>';
  var body = '<center>'+msg+'<br><p><form><input type="button" value="   OK   " onClick="self.close()"></form>';
  msgWindow.document.write(head + body);
}  


//Newly Added by Rajesh on 05/01/09 for CRF 277

function  indicatorToolTip(rownum){
	var formObj = document.VerificationDtlForm;
	//var db_msg = eval("formObj.order_status_text_"+rownum).value;

var nodata="No Information";

	var facilityid=formObj.facility_id.value;
	//var db_msg = eval("formObj.order_status_text_"+rownum).value;
	var appt_ref_num = eval("formObj.booking_num"+rownum).value;
//	alert(appt_ref_num);
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest();
	var xmlStr ="<root><SEARCH ";
	xmlStr +=" /></root>";
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST","OTCommonValidation.jsp?func_mode=slate_order_status&appt_ref_num="+appt_ref_num+"&facilityid="+facilityid,false);
	xmlHttp.send(xmlDoc);
	var retVal = trimString(xmlHttp.responseText);
	var db_msg=retVal;

	db_msg=db_msg.replace("[","");
	db_msg=db_msg.replace("]","");
	db_msg=db_msg.replace(",","");


    var currentlocation=getLabel("Common.currentlocation.label","Common");
    var roomno=getLabel("Common.roomno.label","Common");
    var bedno=getLabel("Common.bedno.label","Common");
    var bookingremarks=getLabel("eOT.BookingRemarks.Label","OT");
	var citizenid=getLabel("eOT.Citizenid.Label","OT");
    var Orderresultstatus=getLabel("eOT.Orderresultstatus/additionalinformation-forpatientid.Label","OT");
	var msg_arr = db_msg.split("##");
	var patient_id = eval("formObj.patient_id_"+rownum).value;
	var title = Orderresultstatus+patient_id;
	var cou=0;

	var tab_dat  = "<table id ='tooltiptable2' cellpadding='1' cellspacing=0 border='0' class='BOX' width='100%' height='100%' align='center'>";

	tab_dat     += "<tr>"
	tab_dat     += "<th  align=left> <B>"+title + "</B></th>"
	tab_dat     += "<th  align=center><a href = javascript:UnTip();><img src='../../eCommon/images/disabled.gif'></a></th>"
	tab_dat     += "</tr> ";
	db_msg=trimString(db_msg);
if(db_msg !="####"){

	for(i=0;i<msg_arr.length;i++){

		 tab_dat     += "<tr>"
		 tab_dat     += "<td class='label'> "

		var msg_arr2=msg_arr[i].split("!");
		for(k=0;k<msg_arr2.length;k++){
	
			
			if (msg_arr2[k]==" Citizen Id :")
			{
				tab_dat += " ,  ";
				tab_dat +="<b>"+citizenid+"</b>";
				tab_dat += ":";
			}

			else if (msg_arr2[k]=="Booking_Remarks ")
			{ //  tab_dat += " ,  ";
				tab_dat +="<b>"+bookingremarks+"</b>";
				tab_dat += ":";
			}
		 else
			{
			tab_dat += msg_arr2[k];
			}
		}
	//	}
		tab_dat     +=" </td>"
		tab_dat     += "</tr> ";
		}
	}else
	{
		 tab_dat     += "<tr>"
		 tab_dat     += "<td class='label'> "
	tab_dat +="<b>"+nodata+"</b>";
		 	tab_dat     +=" </td>"
		tab_dat     += "</tr> ";
	}
	tab_dat     += "</table> ";
	return tab_dat;
	

}
function resizeWindow2(){
	bodwidth = parent.frames[1].document.body.offsetWidth
	bodheight = parent.frames[1].document.body.offsetHeight
	var x =event.x
	var y =  event.y;

	x = x + (document.getElementById("tooltiplayer2").offsetWidth)
	y = y + (document.getElementById("tooltiplayer2").offsetHeight)

	if(x<bodwidth)
		x =event.x
	else
		x = x - (document.getElementById("tooltiplayer2").offsetWidth*1)

	if(y<bodheight){
		 y =event.y
	}else{
		y = y - (document.getElementById("tooltiplayer2").offsetHeight*1)
	}

	y+=document.body.scrollTop
	x+=document.body.scrollLeft

	document.getElementById("tooltiplayer2").style.posLeft= x
	document.getElementById("tooltiplayer2").style.posTop = y
	document.getElementById("tooltiplayer2").style.visibility='visible'
}


function hideToolTip2(){
  document.getElementById("tooltiplayer2").style.visibility = 'hidden';
}

function localTrimString(sInString) {
  //sInString = sInString.replace( /^\s+/g, "" );// strip leading space
  //return sInString.replace( /\s+$/g, "" );// strip trailing space
  return sInString.replace(/^\s+|\s+$/g,"");
}

function getLongNameRefSrc(){
	var formObj=document.forms[0];
	var ref_src_id=formObj.HLongRefSrcId.value;
	var strSourceDesc=formObj.strSourceDesc.value;
	var strSrcTypeTemp=formObj.strSrcTypeTemp.value;
	var locale=formObj.locale.value;
	var param="func_mode=ref_long_name&locale="+locale+"&ref_src_id="+ref_src_id;
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest() ;
	var xmlStr ="<root><SEARCH ";
	xmlStr +=" /></root>";
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("GET","../../eOT/jsp/OTCommonValidation.jsp?"+param,false);
	xmlHttp.send(xmlDoc);
	var retVal = localTrimString(xmlHttp.responseText);	
	if(retVal!="null"  && strSrcTypeTemp=="E" && strSourceDesc!=""){
		document.getElementById("more_img").style.visibility = 'visible';
	}else{
		document.getElementById("more_img").style.visibility = 'hidden';
	}
	return retVal;
}

function getLongNameRefSrcBkAppt(){
	var formObj=document.forms[0];
	var ref_src_id=formObj.HLongRefSrcId.value;
	var strSourceDesc=formObj.Source_code.value;
	var strSrcTypeTemp=formObj.sourceType.value;
	var locale=formObj.locale.value;
	var param="func_mode=ref_long_name&locale="+locale+"&ref_src_id="+ref_src_id;
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest() ;
	var xmlStr ="<root><SEARCH ";
	xmlStr +=" /></root>";
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("GET","../../eOT/jsp/OTCommonValidation.jsp?"+param,false);
	xmlHttp.send(xmlDoc);
	var retVal = localTrimString(xmlHttp.responseText);	
	if(retVal!="null"  && strSrcTypeTemp=="E" && strSourceDesc!=""){
		document.getElementById("more_img").style.visibility = 'visible';
	}else{
		document.getElementById("more_img").style.visibility = 'hidden';
	}
	return retVal;
}

function checkEncId(obj){
	if(obj.value=="XT"){
		document.getElementById("enc_check").style.visibility='hidden'
	}else{
		document.getElementById("enc_check").style.visibility='visible'
	}

}
//Added Against ML-MMOH-CRF-1939-US2...starts
function enableProcedudureDtlFields(){
	
	//var obj = top.message_search_frame.detailframe.message_search_frame.dtlForm;	
	//alert(" parent.detailframe.message_search_frame : "+);
	// console.log(document.PreOperHdr);
	var obj = parent.document.getElementById("dtlForm");
	//var encounter_id = document.PreOperHdr.encounter_id.value;
	var encounter_id = document.getElementById('encounter_id').value;
	if(encounter_id != "")
	{
		obj.operation_desc.disabled = false;
        obj.OperationLookUp.disabled = false;		
	}else{
		obj.operation_desc.disabled = true;
		obj.OperationLookUp.disabled = true;
		clearValues();
	}
}

function clearValues(){ 
//	var frmObj=top.message_search_frame.detailframe.message_search_frame.dtlForm;/
	var frmObj = parent.message_search_frame.dtlForm;
	var order_id = frmObj.orderid.value;
	frmObj.oper_code.value='';
	frmObj.operation_desc.value='';
	frmObj.appl_right_left_flag.value='';
	frmObj.remarks.value='';
	frmObj.duration.value='';
	frmObj.avgTime.value="";
	frmObj.mode.value='I';
	frmObj.key.value='';
	frmObj.stdduration.value='';
	//if(order_id.length==0)
		//frmObj.OperationLookUp.disabled=false;
	frmObj.OperationLookUp.disabled=true;
	//End OperationProcedureDtl.jsp
}
//Added Against ML-MMOH-CRF-1939-US2...ends

