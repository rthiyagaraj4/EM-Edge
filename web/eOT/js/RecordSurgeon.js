/*
*Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
* 
*Warning: This computer program is protected by copyright law and international treaties.
*Unauthorized reproduction or distribution of this program, or any portion of it, 
*may result in severe civil and criminal penalties, and will be prosecuted to 
*the maximum extent possible under the law.
*/
function apply(){	
	var HdrformObj = parent.parent.common_patient_hdr_frame.CommonOperDtlsHdrForm; 
	var isRecordAnes =HdrformObj.isRecordAnes.value;//PMG2017-SS-CRF-0001-US001
	var doc_status_frame_obj = parent.parent.doc_status_frame.SurgeonDocStatusForm;
	var params = HdrformObj.params.value;
	var frmObj = parent.parent.ObjectCollect;
	var patient_class = HdrformObj.patient_class.value;
	var episode_id = HdrformObj.episode_id.value;
	var episode_type = HdrformObj.episode_type.value;
	var oper_num = HdrformObj.oper_num.value;
	var facility_id = HdrformObj.facility_id.value;
	var patient_id = HdrformObj.patient_id.value;
	var oper_date = HdrformObj.oper_date.value;
	var order_id = HdrformObj.order_id.value;
	var surgeon_code = HdrformObj.surgeon_code.value;
	var anaesthesia_code = HdrformObj.anaesthesia_code.value;//PMG2017-SS-CRF-0001-US001
	var visit_id =HdrformObj.visit_id.value;
	var slate_user_id = frmObj.OperCollectForm.slate_user_id.value;
	var trfr_to_ot_flag = HdrformObj.trfr_to_ot_flag.value;
	var booking_num=HdrformObj.booking_num.value;
	var st_interface_flag =HdrformObj.st_interface_flag.value;
	var implant_entry_cmp_yn1=doc_status_frame_obj.implant_entry_cmp_yn.value;
	var doc_level = escape(HdrformObj.doc_level.value);
	var theatre_code = escape(HdrformObj.theatre_code.value);
   	//NOTE:DocumentaionCompleted check box transfered to SurgeonDocStatus.jsp
	var nursing_doc_comp_yn=doc_status_frame_obj.nursing_doc_comp_yn.value;
	var surgeon_doc_comp_yn=doc_status_frame_obj.surgeon_doc_comp_yn.value; 
	var update_notes = ""; //Added against PMG2023-MMS-CRF-0002
	var surgeon_update_notes_yn = doc_status_frame_obj.surgeon_update_notes_yn.value;
	//var update_notes_field = doc_status_frame_obj.update_notes2.value; //Added against PMG2023-MMS-CRF-0002
	var modified_Surgeon_Note_Date=doc_status_frame_obj.modified_Surgeon_Note_Date.value;//ML-BRU-SCF-1550 [IN:053512]
	//047321
	if(doc_status_frame_obj.pros_implants_comp == null || doc_status_frame_obj.pros_implants_comp == 'undefined')
	{
	    var pros_implants_comp='N';
	}else{
		var pros_implants_comp=doc_status_frame_obj.pros_implants_comp;
	}
	//alert("doc_status_frame_obj.pros_implants_comp "+doc_status_frame_obj.pros_implants_comp.value);//sanjay
	var chk_box = doc_status_frame_obj.doc_complete;
	//047321
	
	if(doc_status_frame_obj.oper_proc == null || doc_status_frame_obj.oper_proc == 'undefined')
	{
		var oper_proc_chk='N'
	}else{
	      var oper_proc_chk = doc_status_frame_obj.oper_proc;
		 }
	var doc_complete ="";
	var pros_implants_complete ="";
	var oper_proc_comp ="";
		var pros_implants_complete_flag="N";
		var surg_doc_comp_flag="N";
	var checkInTime = '';
	var customerId = '';
	if(parent.parent.RecordFrame.RecordOperationForm != null && parent.parent.RecordFrame.RecordOperationForm != 'undefined')
	{ //[IN:48637]
		checkInTime = parent.parent.RecordFrame.RecordOperationForm.checkInTime.value;//047397
		customerId = parent.parent.RecordFrame.RecordOperationForm.customerId.value;//047397
	}
	 if(chk_box.checked==true){
		 surg_doc_comp_flag="Y";
		 doc_complete = "Y";
	 }else{
		surg_doc_comp_flag="N";
		doc_complete = "N";
	}
	//Added against PMG2023-MMS-CRF-0002	
		if(doc_complete == 'Y' && (surgeon_update_notes_yn == '' || surgeon_update_notes_yn == null)){
			update_notes = 'N';
		}else if(doc_complete == 'Y' && surgeon_update_notes_yn == 'N'){
			update_notes = 'Y';
		}else if(doc_complete == 'N' && surgeon_update_notes_yn == 'Y'){
			update_notes = 'Y';
		}else if(doc_complete == 'Y' && surgeon_update_notes_yn == 'Y'){
			update_notes = 'Y';
		}
		
	//Added against PMG2023-MMS-CRF-0002

 if(oper_proc_chk.checked==true){
		  oper_proc_comp="Y";
		
	 }else{
		 oper_proc_comp="N";
		
	 }

if(pros_implants_comp)
	{
	
 if(pros_implants_comp.checked==true){
		  pros_implants_complete_flag="Y";
	 }else{
		 
		 pros_implants_complete_flag="N";
	 }
	}


var flag1=true;
if(pros_implants_complete_flag =="Y")
{
	var rows=parent.parent.parent.ObjectCollect.implants_rows;
		if(st_interface_flag=="Y")
			{
		for(var jj=0;jj<rows.length;jj++) {
		if(rows[jj])
		{

		if((rows[jj].Stockavail =="" || rows[jj].Stockavail =="0") && rows[jj].db_mode!='D')
		{
		flag1=false;
		var msg= getMessage("PRC-OT0054","OT");
			messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num="+msg;
		pros_implants_comp.checked=false;
		break;
		}else
		{
			flag1=true;
			pros_implants_comp.checked=true
		}
		}
	    }
		}
}


	var DtlformObj = parent.parent.ObjectCollect.OperCollectForm;
	var oper_num = DtlformObj.oper_num.value;
	var diagnosis_text = encodeURIComponent(frmObj.diagnosis_text);
	//var wound_text = frmObj.wound_text;
	//var msg = "No changes to Commit";
	var msg = getMessage("NO_CHANGE_TO_SAVE","common");
	//var param =params+"&doc_level="+doc_level+"&oper_num="+oper_num+"&theatre_code="+theatre_code+"&doc_complete="+doc_complete+"&diagnosis_text="+diagnosis_text+"&surgeon_doc_comp_yn="+surg_doc_comp_flag+"&nursing_doc_comp_yn="+nursing_doc_comp_yn;
	//var param ="slate_user_id="+slate_user_id+"&doc_level="+doc_level+"&oper_num="+oper_num+"&theatre_code="+theatre_code+"&doc_complete="+doc_complete+"&diagnosis_text="+diagnosis_text+"&surgeon_doc_comp_yn="+surg_doc_comp_flag+"&nursing_doc_comp_yn="+nursing_doc_comp_yn+"&patient_id="+patient_id+"&patient_class="+patient_class+"&episode_type="+episode_type+"&episode_id="+episode_id+"&oper_date="+oper_date+"&surgeon_code="+surgeon_code+"&visit_id="+visit_id+"&order_id="+HdrformObj.order_id.value+"&xmlData="+createXMLForSubServices();
	var param ="slate_user_id="+slate_user_id+"&doc_level="+doc_level+"&oper_num="+oper_num+"&theatre_code="+theatre_code+"&doc_complete="+doc_complete+"&diagnosis_text="+diagnosis_text+"&surgeon_doc_comp_yn="+surg_doc_comp_flag+"&nursing_doc_comp_yn="+nursing_doc_comp_yn+"&patient_id="+patient_id+"&patient_class="+patient_class+"&episode_type="+episode_type+"&episode_id="+episode_id+"&oper_date="+oper_date+"&surgeon_code="+surgeon_code+"&visit_id="+visit_id+"&order_id="+HdrformObj.order_id.value+"&trfr_to_ot_flag="+trfr_to_ot_flag+"&pros_implants_complete_flag="+pros_implants_complete_flag+"&st_interface_flag="+st_interface_flag+"&booking_num="+booking_num+"&oper_proc_comp="+oper_proc_comp+"&customerId="+customerId+"&checkInTime="+checkInTime+"&anaesthesia_code="+anaesthesia_code+"&update_notes="+update_notes;//047397 & //PMG2017-SS-CRF-0001-US001 & PMG2023-MMS-CRF-0002
if(flag1==true)
	{
//ML-BRU-SCF-1550 [IN:053512] starts
	var sel = SurNotesDocComp(facility_id,oper_num,modified_Surgeon_Note_Date,surgeon_doc_comp_yn);
	if(sel !='YES' && sel !=null && sel !='' && sel !='undefined'){		
	surgeon_doc_comp_yn='N';
	chk_box.value=false;
	}
//ML-BRU-SCF-1550 [IN:053512] ends
	if( ( isRowCommit() && isTheatreNotEmpty() ) || frmObj.DIAG_MODIFIED_FLAG=="OFF"  || ( chk_box.checked==true && surgeon_doc_comp_yn!="Y" ) || ( pros_implants_comp.checked==true && pros_implants_complete_flag=="Y" ) || (oper_proc_comp=="Y" && oper_proc_chk.checked==true) || (anaesthesia_code!=null)) {//PMG2017-SS-CRF-0001-US002
	//PMG2017-SS-CRF-0001-US001
	var chkAnes="";
	if(isRecordAnes=="true"){
		chkAnes="Y";
	}
	else{
		chkAnes="N";
	}
	if(chkAnes=="Y"){
			if(anaesthesia_code.length==0){
		 	var msg = "APP-000001 Anesthesia Type cannot be blank.";	
			parent.parent.messageFrame.location.href='../../eCommon/jsp/error.jsp?err_num='+msg;
			return false; 
			}
	} 
	//PMG2017-SS-CRF-0001-US001
		if(chk_box.checked==false){
			if(window.confirm(getMessage("APP-OT0078","OT"))==false){
				messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num=";
				return;
		    }
		}

	  var rows=parent.ObjectCollect.rows;
		  var len = rows.length;
		  var oper_chk_status="";
		  var flag=true;
  for(var i=0;i<=len;i++){
	 if(rows[i]!=null){
		oper_chk_status=rows[i].chk_status;
		if(oper_chk_status == "")
		{
			   flag=true;
			 break;
		}else
		{
			flag=false;	
		}
	 }	 
  }
		if(flag == true)
		{
				var xmlDoc = "";
				var xmlHttp = new XMLHttpRequest();
				var xmlStr="<root>";
				var action = '../../servlet/eOT.RecordSurgeonServlet?'+param;
				
				xmlStr+=frmObj.createXMLForOperations();
				xmlStr+=frmObj.createXMLForPersonnel();
				xmlStr+=frmObj.createXMLForPostOperDiagnosis();
				xmlStr+=frmObj.createXMLForProblemTable();
				xmlStr+=frmObj.createXMLForWoundDetails();
				xmlStr+=frmObj.createXMLForVisitPersonnel();
				xmlStr+=frmObj.createXMLForTimeAndDetails();
				if(implant_entry_cmp_yn1 !="Y")
				xmlStr+=frmObj.createXMLForImplants();
				xmlStr+=frmObj.createXMLForICDPCS();
				xmlStr+="</root>";
				xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
				xmlHttp.open("POST",action,false);
				xmlHttp.send(xmlDoc);
				var retVal = trimString(xmlHttp.responseText);
				if(retVal!=null && retVal!=""){
		  if(retVal=="RECORD_INSERTED"){
			 alert(getMessage("RECORD_INSERTED","SM"));
			 window.returnValue=getMessage("RECORD_INSERTED","SM");
			 window.close();
		  }else{
			  retVal = messageGenerator(retVal) ;
			  parent.parent.messageFrame.location.href='../../eCommon/jsp/error.jsp?err_num='+retVal;
			  //window.close();
			}
		}
		
	}else
	{
		var errMsg=getMessage("PRC-OT0050","OT");
		parent.parent.messageFrame.location.href='../../eCommon/jsp/error.jsp?err_num='+errMsg;
	}
	}else
		{
		parent.parent.messageFrame.location.href='../../eCommon/jsp/error.jsp?err_num='+msg;
		}
}
}

//used in Time and Details function and Visiting Personnel Details.

function removeNull(rows){
	   for(var j in rows)
		 if(rows[j]==null) rows.splice(j,1); 
 }

/*function IdentifyConflictInsert(){
	var rows_pers=parent.parent.parent.ObjectCollect.visit_pers_rows;
	var rows_time=parent.parent.parent.ObjectCollect.time_rows;
	removeNull(rows_pers);
	removeNull(rows_time);
	var tab_id = document.forms[0].tab_id.value
	if(tab_id=="visit_tab"){
		if(rows_time.length>0 ){
			for(var j=0;j<rows_time.length && rows_time[j]!=null;j++)
				parent.parent.parent.ObjectCollect.splty_code+=rows_time[j].speciality_code+",";
		}
	}else if(tab_id=="TimeAndDetailsTab"){
		if(rows_time.length>0){
			for(var j=0;j<rows_pers.length&&rows_pers[j]!=null;j++)
				parent.parent.parent.ObjectCollect.splty_code+=rows_pers[j].speciality_code+",";
		}
	}
	var splty_code = parent.parent.parent.ObjectCollect.splty_code;
	var code_arr = splty_code.split(",");
	if(splty_code.length>0){
		if(tab_id=="visit_tab" ){
			for( var j=0;j<rows_pers.length && rows_pers[j]!=null;j++ ){
				for(var p=0;i<code_arr.length && code_arr[p]!="";p++){
				 if(code_arr[p]==rows_pers[j].speciality_code &&  rows_pers[p]!=null && rows_time[p].db_mode=="I")
					  setVerifyFlag(j,p);
				}
			}
		}else if(tab_id=="TimeAndDetailsTab"){
			for(var j=0;j<rows_time.length && rows_time[j]!=null;j++){
				  for(var p=0;i<code_arr.length && code_arr[p]!="";p++){
					if(code_arr[p]==rows_time[j].speciality_code && rows_pers[p]!=null && rows_pers[p].db_mode=="I")
						  setVerifyFlag(p,j);
				  }
					
			 }
		}
   }
}

 function setVerifyFlag(v_indx,t_indx){
	var rows_pers=parent.parent.parent.ObjectCollect.visit_pers_rows[v_indx];
	var rows_time=parent.parent.parent.ObjectCollect.time_rows[t_indx];
	rows_time.verify_flag="ON";
	rows_pers.verify_flag="ON";
}

 /*function setVerifyFlag(indx){
	var rows_pers=parent.parent.parent.ObjectCollect.visit_pers_rows[indx];
	var rows_time=parent.parent.parent.ObjectCollect.time_rows[indx];
	rows_time.verify_flag="ON";
	rows_pers.verify_flag="ON";
}*/


/*function setVerifyFlag(indx){
	var rows_pers=parent.parent.parent.ObjectCollect.visit_pers_rows[indx];
	var rows_time=parent.parent.parent.ObjectCollect.time_rows[indx];
	if(rows_time!=null &&  rows_pers!=null ){
		if( (rows_time.speciality_code==rows_pers.speciality_code ) && rows_time.db_mode=='I' &&  rows_pers.db_mode=='I' ) {
				rows_time.verify_flag="ON";
				rows_pers.verify_flag="ON";
		}
	}
}*/

function messageGenerator(str){
	var str_temp = "";
	var arr = new Array();
	if(str.indexOf("##")!=-1 ){
		arr = str.split("##");

		if(arr.length>0){
			for(var jj=0; arr[jj]!=null && jj<arr.length-1 ;jj++){
				str_temp+=" "+arr[jj]+" "+arr[jj+1]+"<BR>";
			}
	    }
	}
	
	if(str_temp=="")
		return str;
	else
	    return str_temp;
}
function callBillingProcedure(){
	/*var HdrformObj = parent.parent.common_patient_hdr_frame.CommonOperDtlsHdrForm; 
	var patient_class = HdrformObj.patient_class.value;
	var episode_id = HdrformObj.episode_id.value;
	var episode_type = HdrformObj.episode_type.value;
	var oper_num = HdrformObj.oper_num.value;
	var facility_id = HdrformObj.facility_id.value;
	var patient_id = HdrformObj.patient_id.value;
	var oper_date = HdrformObj.oper_date.value;
	var order_id = HdrformObj.order_id.value;
	var surgeon_code = HdrformObj.surgeon_code.value;
	var params = "facility_id="+facility_id+"&patient_id="+patient_id+"&oper_num="+oper_num+"&patient_class="+patient_class+"&episode_type="+episode_type+"&episode_id="+episode_id+"&oper_date="+oper_date+"&order_id="+order_id+"&surgeon_code="+surgeon_code;
	var xmlStr ="<root><SEARCH ";
	xmlStr +=" /></root>";
	var temp_jsp="PatientBilling.jsp?"+params;
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest() ;
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST",temp_jsp,false);
	xmlHttp.send(xmlDoc);
	responseText=trimString(xmlHttp.responseText) ;
	var str = "";
	if(responseText!="RECORD_INSERTED"){
		var arr = responseText.split("##");
		for(var jj=0;jj<arr.length;jj+=2)
			if(arr[jj]!="")
				str+=" "+arr[jj]+" "+arr[jj+1]+"\n";
		return str;
	}else
		return "RECORD_INSERTED";*/
}

function reset(){
	if(parent.parent.frames[5].frames[1].document.forms[0])
	{
	parent.parent.frames[5].frames[1].document.forms[0].reset();
	parent.parent.frames[5].frames[1].document.forms[0].chk_status.disabled=true;//PMG MOD-0005
	}
	parent.frames[6].document.forms[0].reset();

	top.ObjectCollect.cnt=0;//Adde by lakshmi for Incident 31005
}



function isRowCommit(){
	var HdrformObj = parent.parent.common_patient_hdr_frame.CommonOperDtlsHdrForm;
	var frmObj = parent.parent.ObjectCollect;
	var oper_rows = frmObj.rows;
	var pers_rows = frmObj.personnelrows;
	var diag_rows = frmObj.diagnosis_rows;
	var wound_rows = frmObj.wound_rows;
	var visit_pers_rows = parent.parent.ObjectCollect.visit_pers_rows;
	var time_rows = parent.parent.ObjectCollect.time_rows;
	var implants_rows = frmObj.implants_rows;
	var icd_pcs_rows = parent.parent.ObjectCollect.ICD_PCS_ROWS;
	var submit_flag = "F";
	var falg_doc_chk="F";

	if(isModified(oper_rows)){
		submit_flag = "T";
	}
	if(isModified(pers_rows)){
		submit_flag = "T";
	}
	if(isModified(diag_rows)){
		submit_flag = "T";
	}
	if(isModified(wound_rows)){
		submit_flag = "T";
	}
	if(isModified(visit_pers_rows)){
		submit_flag = "T";
	}
	if(isModified(time_rows)){
		submit_flag = "T";
	}

	if(isModified(implants_rows)){
		submit_flag = "T";
	}
	
	if(isModified(icd_pcs_rows)){
		submit_flag = "T";
	}

	if(HdrformObj.doc_level.value=="AS")
	{
		falg_doc_chk ="T";
	}
	if(submit_flag.indexOf("T")>=0 || falg_doc_chk.indexOf("T")>=0)
		return true;
	else
		return false;

}

function isTheatreNotEmpty(){
	var theatre=getLabel("Common.Theatre.label","common");
	var HdrformObj = parent.parent.common_patient_hdr_frame.CommonOperDtlsHdrForm;
	var fields = new Array(HdrformObj.theatre_code);
	var names = new Array(theatre);
	var messageFrame = parent.parent.messageFrame;
	if(checkFields( fields, names, messageFrame))
		return true;
}

function isModified(rows){
	var modified_flag=false;
	for(var i=0;i<rows.length;i++){
		if(rows[i]!=null){
			if(rows[i].db_mode!='L'){
				modified_flag=true;
			    break;
			}
		} 
		continue
	}
	return modified_flag;
}


/*function searchOperations()
{
	var dialogTop  = "40";
	var dialogHeight = "10";
	var dialogWidth  = "40";
	var arguments = "";
	var column_sizes = escape("20%,40%,10%,10%");               
	var column_descriptions = escape("Code,Description,Side Applicable,Speciality Code");  
	var sql=escape("SELECT OPER_CODE OPER_CODE1,SHORT_DESC SHORT_DESC1, NVL(APPL_RIGHT_LEFT_FLAG,'N') APPL_RIGHT_LEFT_FLAG1,SPECIALITY_CODE SPECIALITY_CODE1  FROM OT_OPER_MAST WHERE NVL(STATUS,'E') = 'E'");
	var title='Operation Search';
	var features  = "dialogTop:"+dialogTop+"dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +";status=no";
	var param = "title="+title+"&"+"column_sizes="+column_sizes+"&"+"column_descriptions="+column_descriptions+"&"+"sql="+sql;
	retVal=window.showModalDialog("../../eOT/jsp/OTGeneralSearchFrames.jsp?"+param,arguments,features);
	var formObj = document.forms[0];
	
	if(retVal!=null){
		var arr = retVal.split('::');
		document.forms[0].oper_code.value=arr[0];
		document.forms[0].oper_desc.value=arr[1];
		document.forms[0].side_applicable.value=arr[2];
		document.forms[0].mode.value='I';
		if(arr[2]!='Y'){
				formObj.side_applicable.value='';
				formObj.side_applicable.disabled=true;      
				formObj.imageflag.src="../../eCommon/images/Blank1.gif";
		}else                  
		  formObj.side_applicable.disabled=false;
		document.forms[0].collect_speciality_code.value+=arr[3]+",";
	}else{
	document.forms[0].oper_code.value='';
	document.forms[0].oper_desc.value='';
	document.forms[0].side_applicable.value='';
	document.forms[0].collect_speciality_code.value='';
	}
}*/

async function searchOperations(obj,target){
	var dialogTop  = "40";
	var dialogHeight = "10";
	var dialogWidth  = "40";
	var arguments = "";
		var desc=target.value;
		if(desc=="%") desc="*All";
		if(desc=="&") desc="~";
	var locale=document.forms[0].locale.value;
	var column_sizes = escape("30%,10%,10%,10%,10%");               
	var tit = getLabel('Common.description.label','Common') + ',' 
			+ getLabel('Common.code.label','Common') + ',' 
			+ getLabel('eOT.SideApplicable.Label','OT') + ','
			+ getLabel('Common.catalog.label','Common') + ','
			+ getLabel('Common.speciality.label','Common'); 
	var column_descriptions=encodeURIComponent(tit);
	
	//Added Against ML-MMOH-CRF-1939-US3...starts
	var include_fpp_yn = document.forms[0].Include_Fpp_yn.value;
	var isincludefpp = document.forms[0].isIncludeFpp.value;
	var count = document.forms[0].Fpp_count.value;
	//alert("1");
	var episode_id = document.forms[0].episode_id.value;
	var bill_flag = document.forms[0].bill_flag.value;
	var tab_name = document.forms[0].tab_name.value;
	
	if(include_fpp_yn === 'Y' && isincludefpp === 'true' && bill_flag && count === '1' && tab_name != 'UNSCHEDULED')
	{
	var sql=escape("SELECT OPER.SHORT_DESC SHORT_DESC, OPER.OPER_CODE OPER_CODE,NVL (OPER.APPL_RIGHT_LEFT_FLAG, 'N') APPL_RIGHT_LEFT_FLAG, OPER.ORDER_CATALOG_CODE CATALOG_CODE,(OPER.SPECIALITY_CODE || ' - ' ||  " +"(SELECT VW.SHORT_DESC FROM AM_SPECIALITY_LANG_VW VW WHERE VW.SPECIALITY_CODE =  OPER.SPECIALITY_CODE AND  LANGUAGE_ID='" + locale + "')) SPECIALITY_CODE " +"FROM OT_OPER_MAST_LANG_VW OPER,  OR_ORDER_CATALOG A WHERE NVL (STATUS, 'E') = 'E' AND OPER.LANGUAGE_ID = '" + locale + "' AND OPER.OPER_CODE = A.ORDER_CATALOG_CODE AND A.FPP_YN= ? AND A.ORDER_CATEGORY = 'OT'");
	}else{
	var sql=escape("SELECT LONG_DESC SHORT_DESC,OPER_CODE OPER_CODE, NVL(APPL_RIGHT_LEFT_FLAG,'N') APPL_RIGHT_LEFT_FLAG, ORDER_CATALOG_CODE CATALOG_CODE, (SPECIALITY_CODE || ' - ' ||  " +"(SELECT SHORT_DESC FROM AM_SPECIALITY_LANG_VW VW WHERE VW.SPECIALITY_CODE =  OPER.SPECIALITY_CODE AND  LANGUAGE_ID='" + locale + "')) SPECIALITY_CODE " +" FROM OT_OPER_MAST_LANG_VW OPER WHERE NVL(STATUS,'E') = 'E' AND LANGUAGE_ID='" + locale + "'");
	}//Added Against ML-MMOH-CRF-1939-US3...
	
	var SPECIALITY_CODE_SQL = escape("SELECT B.SPECIALITY_CODE SPECIALITY_CODE, A.SHORT_DESC SHORT_DESC FROM AM_SPECIALITY_LANG_VW A, OT_SPECIALITIES B " + 
			"WHERE A.LANGUAGE_ID='"+locale+"' AND NVL(EFF_STATUS,'X')= 'E' AND NVL(B.STATUS,'E') != 'D' AND A.SPECIALITY_CODE = B.SPECIALITY_CODE ORDER BY 2");
			
	var title=getLabel("Common.operation.label","common");
	title=encodeURIComponent(title);
	var features  = "dialogTop:"+dialogTop+"dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +";status=no";
	var param = "title="+title+"&"+"column_sizes="+column_sizes+"&"+"column_descriptions="+column_descriptions+"&"+"sql="+sql+"&search_criteria="+ desc + "&SPECIALITY_CODE_SQL=" + SPECIALITY_CODE_SQL;
	
	param += "&"+"episode_id="+episode_id+"&include_fpp_yn="+include_fpp_yn+"&isincludefpp="+isincludefpp+"&count="+count+"&called_from=Record_Surgeon"+"&tab_name="+tab_name;//Added Against ML-MMOH-CRF-1939-US3...
	
	retVal=await window.showModalDialog("../../eOT/jsp/OTGeneralSearchFrames.jsp?"+param,arguments,features);
	var formObj = document.forms[0];
	if(retVal!=null){
		var arr = retVal.split('::');
		document.forms[0].oper_desc.value=arr[0];
		document.forms[0].oper_code.value=arr[1];
		document.forms[0].side_applicable_yn.value=arr[2];
		var specArray = getSpecialityCodeDesc(arr[4]);
		document.forms[0].spec_code.value=specArray[0];		
		document.forms[0].order_catalog_code.value=arr[3];
		if(obj=="U")
		{
		 formObj.chk_status.disabled=false;
		 formObj.chk_status.value="";
		}else
		{
		 formObj.chk_status.disabled=true;
		 formObj.chk_status.value="";
		}
		if(arr[2]!='Y'){
				formObj.side_applicable.value='';
				formObj.side_applicable.disabled=true;      
				formObj.imageflag.src="../../eCommon/images/Blank1.gif";
		}else{                  
		  formObj.side_applicable.value='';
		  formObj.side_applicable.disabled=false;
		 
		  formObj.imageflag.src="../../eCommon/images/mandatory.gif";
		}
		document.forms[0].collect_speciality_code.value+=specArray[0]+",";
		var proc_dtls = getOrderCatlogDtls(arr[3]);
		var arr_proc = proc_dtls.split("::")
			document.forms[0].term_desc.value=arr_proc[0];	document.forms[0].proc_link.value=arr_proc[1]=="NA"?"":arr_proc[1];
			document.forms[0].proc_result.value= arr_proc[2]=="NA"?"":arr_proc[2];
			document.forms[0].term_id.value=arr_proc[3]=="NA"?"":arr_proc[3];
			document.forms[0].term_code.value=arr_proc[4]=="NA"?"":arr_proc[4];
			document.forms[0].color.value=arr_proc[5];
	}else{
	document.forms[0].oper_code.value='';
	document.forms[0].oper_desc.value='';
	document.forms[0].side_applicable.value='';
	document.forms[0].collect_speciality_code.value='';
	}
	
				//Ml-MMOH-CRF-1939 US003
				var xmlDoc = "" ;
				var xmlHttp = new XMLHttpRequest() ;
				var xmlStr ="<root><SEARCH ";
				xmlStr +=" /></root>";
				var param="func_mode=getFppList&oper_code="+arr[1];
				xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
				xmlHttp.open("POST","../../eOT/jsp/OTCommonValidation.jsp?"+param,false);
				xmlHttp.send(xmlDoc);
				var retVal = localTrimString(xmlHttp.responseText);
				if(retVal!=''){
				arr=retVal.split("::");
				if(arr[1]!=null && arr[1]!="" && arr[1]!="undefined" && arr[1]!="null")
				document.forms[0].fpp_category.value=arr[1];
				}
}

function getOrderCatlogDtls(code){
	var locale = document.forms[0].locale.value;
	var xmlStr ="<root><SEARCH";
	xmlStr +=" /></root>";
	var formObj = document.forms[0];
	var sql = "SELECT NVL(SHORT_DESC,'NA')||'::'||  NVL(PROC_LINK_APPLICABLE,'NA')||'::'||NVL(PROC_LINK_RESULTING_OPTION,'NA')||'::'||NVL(TERM_SET_ID,'NA')||'::'||NVL(TERM_CODE,'NA')||'::'||DECODE(PROC_LINK_RESULTING_OPTION,'M','MANDATORY','O','OPTIONAL',DECODE(PROC_LINK_APPLICABLE,'P','AUTO','NA')) COLOR FROM  OR_ORDER_CATALOG_LANG_VW  WHERE LANGUAGE_ID='"+locale+"' AND ORDER_CATALOG_CODE ='"+code+"' ";
	var params = "sql="+sql+"&flag=MED_SER";
	var temp_jsp="../../servlet/eOT.CommonQueryServlet?"+params;
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest() ;
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST",temp_jsp,false);
	xmlHttp.send(xmlDoc);
	responseText=trimString(xmlHttp.responseText);
	return responseText;
}



/*function searchDoctor(obj,target){
	var role_type=document.forms[0].role_type.value;
	if(role_type!=null && role_type!="" && role_type!="undefined"){
	var code_name = obj.name;
	var desc_name = target.name;
	var tcode = obj.value;
	var tdesc = target.value;
	obj.value='';
	target.value='';
	var sql='';
	var retVal =  new String();
	var argumentArray  = new Array();
	var dataNameArray  = new Array();
	var dataValueArray = new Array();
	var dataTypeArray  = new Array();
	var tit="";				
	if(target.name == desc_name){
		tit="Selected Role Search"
		if(role_type=='OS' || role_type=='AS'){
			sql="SELECT PRACTITIONER_NAME description, PRACTITIONER_ID code FROM AM_PRACTITIONER WHERE NVL(EFF_STATUS,'E') = 'E' AND PRACT_TYPE IN ('MD','SG','PS','DN')  and upper( PRACTITIONER_NAME) like upper(?) and upper(PRACTITIONER_ID) like upper(?) order by 1";
		}else if(role_type=='MA' || role_type=='AA'){
			sql="SELECT PRACTITIONER_NAME description, PRACTITIONER_ID code FROM AM_PRACTITIONER WHERE NVL(EFF_STATUS,'E') = 'E' AND PRACT_TYPE IN ('AN')  and upper(PRACTITIONER_NAME) like upper(?) and upper(PRACTITIONER_ID) like upper(?) order by 1";
		}else if(role_type=='NS'){
			sql="SELECT PRACTITIONER_NAME description, PRACTITIONER_ID code FROM AM_PRACTITIONER WHERE NVL(EFF_STATUS,'E') = 'E' AND PRACT_TYPE IN ('NS')  and upper( PRACTITIONER_NAME) like upper(?) and upper(PRACTITIONER_ID) like upper(?) order by 1";
		}
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
		if(target.name == desc_name){
			obj.value = arr[0];
			document.forms[0].target.disabled=true;
		}
	}else{
		target.value=tdesc;
		obj.value=tcode;
	}
 }else{
	 var msg="Role Cannot be blank";
	 parent.parent.parent.messageFrame.location.href='../../eCommon/jsp/error.jsp?err_num='+msg;
 }


}*/


async function searchDoctor(obj,target){
	var formObj = document.PersonnelRecordForm;
	var role=getLabel("Common.Role.label","common");
	var locale = document.forms[0].locale.value;
	var role_type=document.forms[0].role_type.value;
	if(role_type!=null && role_type!="" && role_type!="undefined"){
	var tcode = obj.value;
	var tdesc = target.value;
	var retVal =    new String();
	var argumentArray  = new Array() ;
	var dataNameArray  = new Array() ;
	var dataValueArray = new Array() ;
	var dataTypeArray  = new Array() ;
	//var tit="Selected Role Search" ;
	var tit = role;
	var sql="";
	//Added by Rajesh - 10-Sep-2012
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest();
	var xmlStr ="<root><SEARCH ";
	xmlStr +=" /></root>";
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml")
    xmlHttp.open("POST","OTCommonValidation.jsp?func_mode=check_for_speciality",false);
	xmlHttp.send(xmlDoc);
	var facilityVal = trimString(xmlHttp.responseText);
	//Added by Rajesh - 10-Sep-2012
	/*if(role_type=='OS' || role_type=='AS'){
			sql="SELECT PRACTITIONER_NAME description, PRACTITIONER_ID code FROM AM_PRACTITIONER WHERE NVL(EFF_STATUS,'E') = 'E' AND PRACT_TYPE IN ('MD','SG','PS','DN') and upper(PRACTITIONER_NAME) like upper(?) and upper(PRACTITIONER_ID) like upper(?) order by 2"; 
		}else if(role_type=='MA' || role_type=='AA'){
			sql="SELECT PRACTITIONER_NAME description, PRACTITIONER_ID code FROM AM_PRACTITIONER WHERE NVL(EFF_STATUS,'E') = 'E' AND PRACT_TYPE IN ('AN') and upper(PRACTITIONER_NAME) like upper(?) and upper(PRACTITIONER_ID) like upper(?) order by 2"; 
		}else if(role_type=='NS'){
			sql="SELECT PRACTITIONER_NAME description, PRACTITIONER_ID code FROM AM_PRACTITIONER WHERE NVL(EFF_STATUS,'E') = 'E' AND PRACT_TYPE IN ('NS') and upper(PRACTITIONER_NAME) like upper(?) and upper(PRACTITIONER_ID) like upper(?) order by 2";
		}*/
	//var sql="select physician_id code, short_name description from sy_physician_mast where facility_id = '"+facility_id+"' and pract_type in ('MD','SG')and nvl(status,'x') <> 's'  and upper(physician_id) like upper(?) and upper(short_name) like upper(?) order by 2";


var splty_value;
	if ( document.forms[0].speciality == null || document.forms[0].speciality == 'undefined')
		 splty_value = '*ALL';
	else
		 splty_value = document.forms[0].speciality.value;

//  Added by lakshmi against SCF-IN26699 filtering by speciality
//	sql="SELECT PRACTITIONER_NAME description, PRACTITIONER_ID code FROM AM_PRACTITIONER_LANG_VW WHERE LANGUAGE_ID='"+locale+"' AND NVL(EFF_STATUS,'E') = 'E' AND PRACT_TYPE IN ( SELECT PRACT_TYPE FROM OT_PRACT_TYPES_FOR_ROLE_TYPE WHERE ROLE_TYPE ='"+role_type+"') 	AND ('*ALL'  =  '"+splty_value+"' OR PRACTITIONER_ID IN ( SELECT PRACTITIONER_ID FROM AM_PRACT_SPECIALITIES where SPECIALITY_CODE = DECODE ('"+splty_value+"','*ALL',SPECIALITY_CODE,'"+splty_value+"') )) AND UPPER(PRACTITIONER_NAME) LIKE UPPER(?) AND UPPER(PRACTITIONER_ID) LIKE UPPER(?) ORDER BY 1";

// Modified by DhanasekarV against  SCF-IN26699 
//Added by Rajesh - 10-Sep-2012
if(facilityVal == "SS"){
   sql = "SELECT PRACTITIONER_NAME description, PRACTITIONER_ID code FROM AM_PRACTITIONER_LANG_VW WHERE LANGUAGE_ID='"+locale+"' AND NVL(EFF_STATUS,'E') = 'E' AND PRACT_TYPE IN ( SELECT PRACT_TYPE FROM OT_PRACT_TYPES_FOR_ROLE_TYPE WHERE ROLE_TYPE ='"+role_type+"') AND ( ('*ALL'  = '"+splty_value+"') OR PRACTITIONER_ID IN ( SELECT PRACTITIONER_ID FROM AM_PRACT_SPECIALITIES where SPECIALITY_CODE = '"+splty_value+"' UNION SELECT PRACTITIONER_ID FROM AM_PRACTITIONER where  PRIMARY_SPECIALITY_CODE ='"+splty_value+"' AND PRACT_TYPE IN  ( SELECT PRACT_TYPE FROM OT_PRACT_TYPES_FOR_ROLE_TYPE WHERE ROLE_TYPE ='"+role_type+"') AND NVL(EFF_STATUS,'E') = 'E' )) AND UPPER(PRACTITIONER_NAME) LIKE UPPER(?) AND UPPER(PRACTITIONER_ID) LIKE UPPER(?) ORDER BY 1";
}
else{
   sql = "SELECT PRACTITIONER_NAME description, PRACTITIONER_ID code FROM AM_PRACTITIONER_LANG_VW WHERE LANGUAGE_ID='"+locale+"'  AND NVL(EFF_STATUS,'E') = 'E' AND PRACT_TYPE IN ( SELECT PRACT_TYPE FROM OT_PRACT_TYPES_FOR_ROLE_TYPE WHERE ROLE_TYPE ='"+role_type+"') AND UPPER(PRACTITIONER_NAME) LIKE UPPER(?) AND UPPER(PRACTITIONER_ID) LIKE UPPER(?) ORDER BY 1"; 
}
//Added by Rajesh - 10-Sep-2012
	//Added by lakshmi against SCF-IN26699 filtering by speciality
	//sql="SELECT PRACTITIONER_NAME description, PRACTITIONER_ID code FROM AM_PRACTITIONER_LANG_VW WHERE LANGUAGE_ID='"+locale+"' AND NVL(EFF_STATUS,'E') = 'E' AND PRACT_TYPE IN ( SELECT PRACT_TYPE FROM OT_PRACT_TYPES_FOR_ROLE_TYPE WHERE ROLE_TYPE ='"+role_type+"') AND ('*ALL'  =  '11' OR PRACTITIONER_ID IN ( SELECT PRACTITIONER_ID FROM AM_PRACT_SPECIALITIES where SPECIALITY_CODE = DECODE ('11','*ALL',SPECIALITY_CODE,'11') )) AND UPPER(PRACTITIONER_NAME) LIKE UPPER(?) AND UPPER(PRACTITIONER_ID) LIKE UPPER(?) ORDER BY 1";

/*	sql="SELECT PRACTITIONER_NAME description, PRACTITIONER_ID code FROM AM_PRACTITIONER_LANG_VW WHERE LANGUAGE_ID='"+locale+"'  AND NVL(EFF_STATUS,'E') = 'E' AND PRACT_TYPE IN ( SELECT PRACT_TYPE FROM OT_PRACT_TYPES_FOR_ROLE_TYPE WHERE ROLE_TYPE ='"+role_type+"') AND UPPER(PRACTITIONER_NAME) LIKE UPPER(?) AND UPPER(PRACTITIONER_ID) LIKE UPPER(?) ORDER BY 1"; 
*/
	argumentArray[0] =sql;
	argumentArray[1] = dataNameArray ;
	argumentArray[2] = dataValueArray ;
	argumentArray[3] = dataTypeArray ;
	argumentArray[4] = "2,1";
	argumentArray[5] = target.value;
	argumentArray[6] = DESC_LINK  ;
	argumentArray[7] = DESC_CODE ;
	
	retVal = await CommonLookup( tit, argumentArray );
	if(retVal != null && retVal != "" )
	{
		var ret1=unescape(retVal);
		arr=ret1.split(",");	 	
		if(arr[1]==undefined) { 
		arr[1]="";
		arr[0]="";
		}
		obj.value = arr[0];
		target.value=arr[1];
	}else{
		//target.value=tdesc;
		//obj.value=tcode;
		target.value="";
		obj.value="";
	}
}else{
	//var msg="APP-OT35 Role Cannot be blank...";
	var msg=getMessage("CANNOT_BE_BLANK","OT");
	var msgArr=msg.split("&");
	msg=msgArr[0] + role +msgArr[1];
	parent.parent.parent.messageFrame.location.href='../../eCommon/jsp/error.jsp?err_num='+msg;
}
}



/*function searchDoctor(){
	var role_type=document.forms[0].role_type.value;
	if(role_type!=null && role_type!="" && role_type!="undefined"){
		var dialogTop  = "40";
		var dialogHeight = "10";
		var dialogWidth  = "40";
		var arguments = "";
		var column_sizes = escape("40%,10%");               
		var column_descriptions = escape("Name,Id");  
		if(role_type=='OS' || role_type=='AS'){
			sql=escape("SELECT PRACTITIONER_NAME description, PRACTITIONER_ID code FROM AM_PRACTITIONER WHERE NVL(EFF_STATUS,'E') = 'E' AND PRACT_TYPE IN ('MD','SG','PS','DN')"); 
		}else if(role_type=='MA' || role_type=='AA'){
			sql=escape("SELECT PRACTITIONER_NAME description, PRACTITIONER_ID code FROM AM_PRACTITIONER WHERE NVL(EFF_STATUS,'E') = 'E' AND PRACT_TYPE IN ('AN')"); 
		}else if(role_type=='NS'){
			sql=escape("SELECT PRACTITIONER_NAME description, PRACTITIONER_ID code FROM AM_PRACTITIONER WHERE NVL(EFF_STATUS,'E') = 'E' AND PRACT_TYPE IN ('NS')");
		}
		var title="Selected Role Search";
		var features  = "dialogTop:"+dialogTop+"dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +";status=no";
		var param ="title="+title+"&"+"column_sizes="+column_sizes+"&"+"column_descriptions="+column_descriptions+"&"+"sql="+sql;
		retVal=window.showModalDialog("../../eOT/jsp/OTGeneralSearchFrames.jsp?"+param,arguments,features);
		var formObj = document.forms[0];
		  if(retVal!=null){
			var arr = retVal.split('::');
			document.forms[0].practitioner_name.value=arr[0];
			document.forms[0].practitioner_id.value=arr[1];
		 }else{
			document.forms[0].practitioner_id.value="";
			document.forms[0].practitioner_name.value="";
		 }
	}else{
		var msg="<B>APP-OT35 Role Cannot be blank...<B>";
		 parent.parent.parent.messageFrame.location.href='../../eCommon/jsp/error.jsp?err_num='+msg;
	}
}*/


async function searchRole()
{
	var dialogTop  = "40";
	var dialogHeight = "10";
	var dialogWidth  = "40";
	var arguments = "";
	var column_sizes = escape("40%,10%,10%");               
	//var column_descriptions = escape("Description,Role ID,Role Type");  

    var column_descriptions = getLabel('Common.description.label','common') + ',' + getLabel('eOT.RoleID.Label','OT') + ',' + getLabel('Common.RoleType.label','Common');

	column_descriptions = encodeURIComponent(column_descriptions);

	var sql=escape("SELECT ROLE_DESC DES, ROLE_ID ID, ROLE_TYPE TYP FROM OT_ROLES_LANG_VW WHERE LANGUAGE_ID='"+locale+"' AND NVL(APPL_TO_OT_SLATE,'N') = 'N' AND NVL(STATUS,'E') = 'E'");
	var title=getLabel("Common.Role.label","Common");
	title=encodeURIComponent(title);
	var features  = "dialogTop:"+dialogTop+"dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +";status=no";
	var param = "title="+title+"&"+"column_sizes="+column_sizes+"&"+"column_descriptions="+column_descriptions+"&"+"sql="+sql;
	retVal=await window.showModalDialog("../../eOT/jsp/OTGeneralSearchFrames.jsp?"+param,arguments,features);
	var formObj = document.forms[0];
	if(retVal!=null){
		var arr = retVal.split('::');
		document.forms[0].role_desc.value=arr[0];
		document.forms[0].role_id.value=arr[1];
		document.forms[0].role_type.value=arr[2];
		
	}else{
		document.forms[0].role_desc.value='';
		document.forms[0].role_id.value='';
		document.forms[0].role_type.value='';
	}
}

async function searchICD()
{
	var diag_code_scheme = document.forms[0].scheme_code.value;
	var dialogTop  = "40";
	var dialogHeight = "10";
	var dialogWidth  = "40";
	var arguments = "";
	var column_sizes = escape("40%,10%,10%,10%");               
//	var column_descriptions = escape("Description,Code,Notifiable,Sensitive"); 
	var column_descriptions = getLabel('Common.description.label','common')+','+getLabel('Common.code.label','common')+','+getLabel('Common.Notifiable.label','common')+','+getLabel('Common.Sensitive.label','common');

	column_descriptions = encodeURIComponent(column_descriptions);

//	var title='ICD Search';
	var title=getLabel("Common.ICD.label","common");
	title=encodeURIComponent(title);
	var features  = "dialogTop:"+dialogTop+"dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +";status=no";


	if(diag_code_scheme=="1" || diag_code_scheme==""){
		sql=escape("SELECT SHORT_DESC description, ICD_CODE code, NOTIFIABLE_YN notify_yn,SENSITIVE_YN sen_yn FROM MR_ICD_MAST WHERE  RECORD_TYPE = 'D' AND  CAUSE_INDICATOR IS NULL AND NVL(STATUS,'E')='E' ");
	}else if(diag_code_scheme=="2"){
		sql=escape("SELECT SHORT_DESC description, ICD_CODE code,NOTIFIABLE_YN notify_yn,SENSITIVE_YN sen_yn FROM MR_ICD_MAST WHERE  NVL(RECORD_TYPE,'#')='#' AND CAUSE_INDICATOR IS NULL AND NVL(STATUS,'E') = 'E'");
	}
	var param = "title="+title+"&"+"column_sizes="+column_sizes+"&"+"column_descriptions="+column_descriptions+"&"+"sql="+sql;
	retVal=await window.showModalDialog("../../eOT/jsp/OTGeneralSearchFrames.jsp?"+param,arguments,features);
	var formObj = document.forms[0];
	if(retVal!=null){
		var arr = retVal.split('::');
		document.forms[0].icd_desc.value=arr[0];
		document.forms[0].icd_code.value=arr[1];
		document.forms[0].notifiable.value=arr[2];
		document.forms[0].sensitive.value=arr[3];
		
	}else{
		document.forms[0].icd_desc.value='';
		document.forms[0].icd_code.value='';
		document.forms[0].notifiable.value='';
		document.forms[0].sensitive.value='';
	}
}

//some doubts in the function for argumentArray[4] need to be checked
async function searchWoundText(obj,target){
	var formObj = document.forms[0];
	var locale = formObj.locale.value;
	var code_name = obj.name;
	var desc_name = target.name;
	var tcode = obj.value;
	var tdesc = target.value;
	obj.value='';
	target.value='';
	var retVal =  new String();
	var argumentArray  = new Array();
	var dataNameArray  = new Array();
	var dataValueArray = new Array();
	var dataTypeArray  = new Array();
	//var tit="Search Wound";
	var tit=getLabel("eOT.WoundType.Label","OT");
//var	sql="SELECT WOUND_TYPE_CODE code,WOUND_TEXT description  FROM OT_WOUND_TYPE WHERE NVL(STATUS,'E')='E' and upper(WOUND_TYPE_CODE) like upper(?) and upper(WOUND_TEXT) like upper(?) order by 2";
	var	sql="SELECT WOUND_TYPE_CODE code,WOUND_TEXT description  FROM OT_WOUND_TYPE_LANG_VW WHERE LANGUAGE_ID='"+locale+"' AND NVL(STATUS,'E')='E' and upper(WOUND_TYPE_CODE) like upper(?) and upper(WOUND_TEXT) like upper(?) order by 2";
	argumentArray[0] =sql;
	argumentArray[1] = dataNameArray ;
	argumentArray[2] = dataValueArray ;
	argumentArray[3] = dataTypeArray ;
	argumentArray[4] = "1,2";
	argumentArray[5] = target.value;
	argumentArray[6] = DESC_LINK;
	argumentArray[7] = DESC_CODE;

	retVal = await CommonLookup( tit, argumentArray );
	if(retVal != null && retVal != "" ){
		var ret1=unescape(retVal);
		arr=ret1.split(",");
		target.value=arr[1];
		if(target.name == desc_name){
			obj.value = arr[0];
			document.forms[0].target.disabled=true;
		}
	}else{
		target.value=tdesc;
		obj.value=tcode;
	}
}

function checkLimit(field, limit){
	 if (field.value.length > limit){
		   //var msg = getMessage("REMARKS_CANNOT_EXCEED");
		   var msg = getMessage("MAX_LENGTH_DATA","OT");
		   var msgArray = msg.split("#");
		   alert(msgArray[0]+""+msgArray[1]+limit+msgArray[2]);
		   //Truncate at the limit
		   var revertField = field.value.slice(0,limit);
		   field.value = revertField;
		   field.focus();
	  }
}


function compareDate(fromdate,todate) {
     if(fromdate.length > 0 && todate.length > 0 ) {
            if(Date.parse(todate) < Date.parse(fromdate)) {
                return false;
            }
    }
	return true;
}

function getSysDate(){
	var xmlStr ="<root><SEARCH ";
	xmlStr +=" /></root>";
	var temp_jsp="HoldingAreaValidation.jsp?func_mode=getSysDate";
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest() ;
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST",temp_jsp,false);
	xmlHttp.send(xmlDoc);
	responseText=xmlHttp.responseText ;
	return responseText;
}

function validateDate(){
	var formObj = document.PostOperDiagnosisRecordForm;
	var HdrformObj=parent.parent.common_patient_hdr_frame.CommonOperDtlsHdrForm;
	var dob = HdrformObj.date_of_birth.value;
	var onsetDate = formObj.onset_date.value;//obj.value;
	var closeDate = formObj.close_date.value;
	var cur_date = trimString(getSysDate());
	var submit_flag = true;
	
	//onset Date Comparison
	var returnVal =  compareDate(onsetDate,cur_date);
	if(returnVal==false){
		var msg = "Onset date cannot be > Current Date";
		parent.parent.messageFrame.location.href='../../eCommon/jsp/error.jsp?err_num='+msg;
		submit_flag = false;
	}

	//onset Date Comparison
	var retVal = compareDate(dob,onsetDate);
		if(retVal==false){
			var msg = "Onset date Should be < Date of Birth";
			parent.parent.messageFrame.location.href='../../eCommon/jsp/error.jsp?err_num='+msg;
			submit_flag = false;
	    }

	var retVal1 = compareDate(dob,closeDate);	
	if(retVal1==false){
		var msg = "Close date should be < Date of Birth"
		parent.parent.messageFrame.location.href='../../eCommon/jsp/error.jsp?err_num='+msg;
		submit_flag = false;
	}

	//onset Date Comparison
	var retVal2 = compareDate(onsetDate,closeDate);
		if(retVal2==false){
			var msg = "Close date Should be >= Onset date"
			parent.parent.messageFrame.location.href='../../eCommon/jsp/error.jsp?err_num='+msg;
			submit_flag = false;
	    }

	var retVal3 = compareDate(closeDate,cur_date);
		if(retVal3==false){
			var msg = "Close date Should be < Current date ";
			parent.parent.messageFrame.location.href='../../eCommon/jsp/error.jsp?err_num='+msg;
			submit_flag = false;
	    }

		return submit_flag;
 }

 function setPrimaryFlag(){
	var formObj = document.forms[0];
	var frmObj = parent.parent.ObjectCollect; 
	var primary_yn = formObj.primary_yn.value;
	if(primary_yn=="Y"){
	   frmObj.primary_flag="OFF";
	}
 }

function validatePrimaryChkBox(obj){
 var  formObj = document.forms[0];
 var frmObj = parent.parent.ObjectCollect; 
 var icd_code = formObj.icd_code.value;
 var primary_yn = formObj.primary_yn.value;
 var primary_flag = frmObj.primary_flag;
 //primary_flag="ON" --> can allow to set the one diagnosis as primary.  
//primary_flag="OFF" --> can't allow to set another diagnosis as primary already it is set. 

  if(primary_yn!='Y' && primary_flag=="ON" ){
	 //setting a new diagnosis as a primary diagnosis
	  if(obj.checked==true)
		frmObj.primary_flag="OFF";
   }else if(primary_yn!='Y' && primary_flag=="OFF" && obj.checked==false ){
	 //changing  primary diagnosis
	      frmObj.primary_flag="ON";
 }else if(primary_yn=='Y' && primary_flag=="OFF" && obj.checked==false ){
		obj.checked=true;
  }else{
	obj.checked=false;
	var msg = "One ICD can be set as Primary Diagnosis...";
	alert(msg);
	//parent.parent.messageFrame.location.href='../../eCommon/jsp/error.jsp?err_num='+msg;
  }
 
}

function assignHdrDtls(){
	var formObjHdr =parent.parent.common_patient_hdr_frame.CommonOperDtlsHdrForm;
	var formObj = document.forms[0];
	formObj.patient_id.value = formObjHdr.patient_id.value;
	formObj.surgeon_code.value = formObjHdr.surgeon_code.value;
	formObj.source_code.value = formObjHdr.source_code.value;
	formObj.source_type.value= formObjHdr.source_type.value;
	formObj.encounter_id.value = formObjHdr.encounter_id.value;
}

async function openNewDialogWindow(strVal,obj,size,disable_flag)
{
	//get rettext, assign value to hidden field
	var param='heading='+strVal+'&para='+encodeURIComponent(obj.value)+'&size='+size+"&disable_flag="+disable_flag;
	var retext= await window.showModalDialog('../../eOT/jsp/LeftFrameTextArea.jsp?'+param,window,"dialogHeight: 145px; dialogWidth:500px; center: yes; help: no; resizable: no; status: no;");
	if(retext=='undefined'|| retext==''|| retext==null)
		retext=obj.value;
	else
		obj.value=retext;
}


function assignListItems(code,desc){
	  var formObj=document.forms[0];
	  var descArr=new Array();
	  var codeArr=new Array();
	  descArr=desc.split(",");
	  codeArr=code.split(",");		  
	  listObj=formObj.speciality;
	  var len=0;
	  len=listObj.length-1;
	  var lencou=0;
	  //List Box length starts from 1 where as array starts from 0
	  for( var co=len;co>=0; co--){
		listObj.remove(co);
	  }
	var spec_code_cancel1="";
	  for(len=0;len<=codeArr.length-1;len++){
		var spec_code_cancel=parent.parent.parent.frames[4].RecordSurgeonTabForm.spec_oper_comb.value;

		var arr_spec=spec_code_cancel.split("*");

		if(arr_spec.length == 1 && listObj.options.length==0)
		  {

			listObj.options[0]=new Option("----"+getLabel("Common.defaultSelect.label","Common")+"----",'0');	
			// Modified by DhanasekarV for across speciality options  against incident IN026701  
			lencou =1;
		  }
		for (var j=0;j<arr_spec.length;j++ )
		{
		spec_code_cancel1=arr_spec[j];
		if(spec_code_cancel1 !=codeArr[len])
			  {

			listObj.options[len+lencou]=new Option(descArr[len],codeArr[len]);

		  }
		}
		listObj.selectedIndex = len+lencou;
	  }
	//  loadNotetype("*ALL");
}

function callPopulateList(flag){
	var xmlStr ="<root><SEARCH";
	xmlStr +=" /></root>";
	var formObj = document.forms[0];
	var params = formObj.params.value;
	params = params+"&flag="+flag;
	var temp_jsp="../../servlet/eOT.PopulateListItemServlet?"+params;
	//var temp_jsp="../../servlet/eOT.PopulateListItem.jsp?"+params;
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest() ;
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST",temp_jsp,false);
	xmlHttp.send(xmlDoc);
	responseText=trimString(xmlHttp.responseText);
	eval(responseText);
		if(document.forms[0].tab_id.value=="notes_tab")
		{
			var spec=document.forms[0].speciality;
				loadNotetype(spec);
		}
}

async function openDialogWindow(strVal,remarks){
	  await window.showModalDialog('../../eOT/jsp/TextArea.jsp?heading='+encodeURIComponent(strVal)+'&remarks='+encodeURIComponent(remarks),window,"dialogHeight: 145px; dialogWidth:500px; center: yes; help: no; resizable: no; status: no;");
}


function callpatientHistory()
{
	var HdrformObj = parent.parent.common_patient_hdr_frame.CommonOperDtlsHdrForm; 
	var patient_id = HdrformObj.patient_id.value;
	var encounter_id=HdrformObj.encounter_id.value;
	var patient_class = HdrformObj.patient_class.value;
	var oper_num = HdrformObj.oper_num.value;
	openHistoryinrecordsurgeon(patient_id,encounter_id,patient_class,oper_num);

}
function openHistoryinrecordsurgeon(patient_id,encounter_id,patient_class,oper_num){ 
	var cnt=top.ObjectCollect.cnt ;
	var HTML = "<html>";
	if(cnt==0)
	{
		HTML += "<form name='historyForm' id='historyForm' action='../../eCA/jsp/OpenChartWrapper.jsp' method='post' target='messageFrame'>";
		top.ObjectCollect.cnt=1;
	}
	else
	{
		HTML += "<form name='historyForm' id='historyForm' action='../../eCA/jsp/OpenChartWrapper.jsp' method='post' target='messageFrame'>";
	}
	HTML += "<input type='hidden' name='patient_id' id='patient_id' value= '"+patient_id+"'>";
	HTML += "<input type='hidden' name='source_accession_type' id='source_accession_type' value= 'OT'>";
	HTML += "<input type='hidden' name='source_accession_num' id='source_accession_num' value= '"+oper_num+"'>";
	HTML += "<input type='hidden' name='encounter_id' id='encounter_id' value= '"+encounter_id+"'>";
	HTML += "<input type='hidden' name='patient_class' id='patient_class' value= '"+patient_class+"'>";
	HTML += "<input type='hidden' name='mode' id='mode' value= 'R'>";
	HTML += "</form>";
	HTML += "</html>";
	cnt++;
	parent.parent.parent.messageFrame.document.body.insertAdjacentHTML("BeforeEnd", HTML);
	parent.parent.parent.messageFrame.document.historyForm.submit();
	setTimeout('callSamepage()',800)
}
// Added for IN:43777
function callSamepage()
        {   
		parent.document.location.reload();       	
		parent.parent.parent.messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num=";
         }
function trimString(sInString){
   return sInString.replace(/^\s+|\s+$/g,"");
}

function getPositionDesc(practitioner_id){
	var xmlStr ="<root><SEARCH";
	xmlStr +=" /></root>";
	var formObj = document.forms[0];
	var sql = "SELECT POSITION_DESC FROM AM_PRACTITIONER A,AM_POSITION B WHERE PRACTITIONER_ID = '"+practitioner_id+"' AND  A.POSITION_CODE  = B.POSITION_CODE (PLUS) ";
	var params = "sql="+sql+"&flag=PERS_RECORD";
	var temp_jsp="../../servlet/eOT.CommonQueryServlet?"+params;
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest() ;
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST",temp_jsp,false);
	xmlHttp.send(xmlDoc);
	responseText=trimString(xmlHttp.responseText);
	return responseText;
}
/*function callSQLVisitTimeInsert(){
	var xmlString="";
	var rows_pers=parent.ObjectCollect.visit_pers_rows;
	var rows_time=parent.ObjectCollect.time_rows;
	if( rows_pers!=null && rows_time!=null && rows_pers.length>0 && rows_time.length>0 ){
		for(var i=0;i<rows_time.length;i++){
			if( rows_time[i]!=null && rows_time[i].db_mode=='I' 
				&& rows_time[i]!=null && rows_pers[i].db_mode=='I' ) {
			//rows_time[i].verify_flag="ON";
			//rows_pers[i].verify_flag="ON";
			xmlString+=callClubVisitTimeSQL(i);	
			}else
				continue;
		}
		
   }
	return xmlString;
}

function callClubVisitTimeSQL(indx){
	var rows_pers=parent.ObjectCollect.visit_pers_rows[indx];
	var rows_time=parent.ObjectCollect.time_rows[indx];
	var table_name="OT_POST_OPER_DTL2";
	var xmlString="<TIME_DTL"+indx+" ";
	xmlString+="oper_num=\""+document.forms[0].oper_num.value+"\""+" ";
	xmlString+="speciality_code=\""+rows_pers.speciality_code+"\""+" ";
	xmlString+="visit_desc=\""+rows_pers.visit_desc+"\""+" ";
	xmlString+="preparation_time=\""+rows_time.db_preparation_time+"\""+" ";
	xmlString+="procedure_start_time=\""+rows_time.db_procedure_start_time+"\""+" ";
	xmlString+="procedure_end_time=\""+rows_time.db_procedure_end_time+"\""+" ";
	xmlString+="anaesthesia_start_time=\""+rows_time.db_anaesthesia_start_time+"\""+" ";
	xmlString+="anaesthesia_end_time=\""+rows_time.db_anaesthesia_end_time+"\""+" ";
	xmlString+="surgery_start_time=\""+rows_time.db_surgery_start_time+"\""+" ";
	xmlString+="surgery_end_time=\""+rows_time.db_surgery_end_time+"\""+" ";
	xmlString+="db_mode=\""+rows_time.db_mode+"\""+" ";
	xmlString+="table_name=\""+table_name+"\""+" />";
	return xmlString;
}*/

function showRemarks(obj,str){
	var str = (str.length>35)?split_string(str,35):str;
	var tabdata = "<html><body><table cellpadding=0 cellspacing=0 border=1 bordercolor=BLACK><tr><th><font size=2><b>Visiting Personnel</b></font></th><tr><td class=SEN WRAP>"+str+"</td></tr></table></body></html>";
		document.getElementById("tooltip").innerHTML = tabdata;
		document.getElementById("tooltip").style.top  = obj.offsetTop+15;
		document.getElementById("tooltip").style.left  = obj.offsetLeft+10;
		document.getElementById("tooltip").style.visibility="visible" ;
}

function split_string(str,no_const){
	var arr =new Array();
	var count=k=0;
	for(var j=0;j<str.length;){
		arr[count++]=str.slice(j,k+no_const);
		j=k=k+no_const;
	 }
	 return arr.join("<BR>");
}

function hidePopUp(){
	document.getElementById("tooltip").style.visibility="hidden" ;
}

function checkICDPCSMandatoryOperation(){
		var rows = parent.ObjectCollect.proc_mandatory
		var tab_hide_yn = parent.tab_frame.document.forms[0].tab_hide_yn.value;
			for(j in rows){
			}
		var checked_flag = true;
		if(tab_hide_yn.value=="N"){
			for(var j in rows){
				if(rows[j]=="Y"){
					continue;
				}else{
					alert(getMessage("APP-OT0085","OT"));
					checked_flag=false;
					break;
				}
			}
		}
		return checked_flag;
	}

function assignAutoLength()
{
	if(typeof(parent.parent.ObjectCollect) != 'undefined' && parent.parent.ObjectCollect != '' && parent.parent.ObjectCollect != null)
	{
		parent.parent.ObjectCollect.AUTO_LEN = parent.parent.ObjectCollect.ICD_PCS_ROWS.length;
	}
	else
	{
		setTimeout('assignAutoLength()',500);
	}
}


  function autoPopulate(str,oper_line_status){
	var obj = parent.parent.ObjectCollect;
	var rows = parent.parent.ObjectCollect.ICD_PCS_ROWS;
	var flag=true;
	var arr = str.split("::");
	for(j in rows){
	if (arr[1] == rows[j].oper_code && arr[4] == rows[j].proc_code){
	flag=false;
	break;
	}else{
	flag=true;
	}
	}

	//if(obj.AUTO_LEN==0){
    if(flag==true){
		var arr = str.split("::");
if(oper_line_status !="99")
		{
		//line_no+"::"+oper_code+"::"+oper_desc+"::"+term_set_id+"::"+term_code+"::"+color+"::"+term_desc;
		 var obj = new newRow();
		 obj.line_no=arr[0];
		 obj.oper_code=arr[1];
		 obj.oper_desc=unescape(arr[2]);
		 obj.coding_scheme=arr[3];
		 obj.proc_code=arr[4];
		 obj.color=arr[5];
		 obj.proc_desc=arr[6];
		 obj.link_enable="N";
		 obj.db_mode="I";
		 obj.rec_id=rows.length+1;
		 rows.push(obj);
		}
	}
	//}
 }
 
/*function changeTab(objStr){
	var frmObj=document.forms[0];
	var tab_hide_yn = frmObj.tab_hide_yn.value;
	var rowObj = document.getElementsByTagName('td');
	for(var i=0;i<rowObj.length;i++){
		(rowObj[i].id)?document.getElementById(rowObj[i].id).className="CAFIRSTSELECTHORZ":"";
	}
	document.getElementById(objStr).className="CASECONDSELECTHORZ";
	callTargetJSP(objStr);
}

function callTargetJSP(objStr){
	//Array URLArray = new Array();
	var param=document.forms[0].param.value;
	var messageFrame = parent.parent.messageFrame;
	var RecordFrame = parent.RecordFrame;
	var target = URLArray[objStr]+param;
	if(RecordFrame!=null)
		RecordFrame.location.href=target;	
	if(messageFrame!=null)
		messageFrame.location.href="../../eCommon/jsp/error.jsp?err_num=";
}*/

async function callPostOPDiagnosis(){
	var HdrformObj=parent.parent.common_patient_hdr_frame.CommonOperDtlsHdrForm;
	//var param = "Context=IP_Q&stage_desc=Intemediate&stage_code=I&Clinic_Code=&Dob="+HdrformObj.date_of_birth.value+"&Sex="+HdrformObj.sex.value+"&patient_id="+HdrformObj.patient_id.value+"&episode_id="+HdrformObj.episode_id.value+"&ip_practitioner_id="+HdrformObj.surgeon_code.value+"&IP_YN=Y&location_code="+HdrformObj.source_code.value+"&patient_class="+HdrformObj.patient_class.value+"&oper_num="+HdrformObj.oper_num.value;
var Age= "";		// can pass null
var Dob= HdrformObj.date_of_birth.value;
var Function= ""; 
var Sex= HdrformObj.sex.value;
var encounter_id= HdrformObj.encounter_id.value;
var episode_id= HdrformObj.episode_id.value;
var episode_type= HdrformObj.episode_type.value;
var function_id= "";
var location_code= HdrformObj.source_code.value;
var location_type= HdrformObj.source_type.value;
var modal_yn= "Y";
var occur_srl_no= "";
var patient_class= HdrformObj.patient_class.value;
var patient_id= HdrformObj.patient_id.value;
var practitioner_id= HdrformObj.surgeon_code.value;
var practitioner_type= HdrformObj.practitioner_type.value;
var relationship_id= "";
var term_code= ""; // can pass null
var term_set_id= "";
var diag_code_scheme = HdrformObj.diag_code_scheme.value;
if(diag_code_scheme=="1")
	term_set_id = "ICD9CM";
else if(diag_code_scheme=="2")
	term_set_id = "ICD10";
var child_window="Y";
var speciality_code = HdrformObj.oper_speciality_code.value;
var visit_adm_date= "";
var param = "Age=&Dob="+Dob+"&Function="+Function+"&Sex="+Sex+"&oper_num="+HdrformObj.oper_num.value+"&episode_id="+episode_id+"&encounter_id="+encounter_id+"&episode_type="+episode_type+"&function_id="+function_id+"&location_code="+location_code+"&location_type="+location_type+"&modal_yn="+modal_yn+"&occur_srl_no="+occur_srl_no+"&patient_class="+patient_class+"&patient_id="+patient_id+"&practitioner_id="+practitioner_id+"&practitioner_type="+practitioner_type+"&relationship_id="+relationship_id+"&term_code="+term_code+"&visit_adm_date="+visit_adm_date+"&speciality_code="+speciality_code+"&child_window="+child_window;

	var jsp_name = "";
	jsp_name = "../../eMR/jsp/RecDiagnosis.jsp?"+param;
	var retVal =        new String();
/*	var dialogHeight="33.4";
	var dialogWidth="49.6";
	var dialogTop="65";
*/
	var dialogHeight = screen.availHeight ;
	var dialogWidth  		= screen.availWidth;
	var dialogTop    = "0";
	var dialogLeft   = "0";

	var status = "no";
	var arguments    = "" ;
	var features        = "dialogHeight:" + dialogHeight + "; dialogTop:" + dialogTop + "; dialogLeft:" + dialogLeft + "; dialogWidth:" + dialogWidth +" ; scroll=no; status:" + status;
	retVal = await window.showModalDialog(jsp_name,arguments,features);
}

/*
function callPostOPDiagnosis(){
	var HdrformObj=parent.parent.common_patient_hdr_frame.CommonOperDtlsHdrForm;
	var param = "Context=IP_Q&stage_desc=Intemediate&stage_code=I&Clinic_Code=&Dob="+HdrformObj.date_of_birth.value+"&Sex="+HdrformObj.sex.value+"&patient_id="+HdrformObj.patient_id.value+"&episode_id="+HdrformObj.episode_id.value+"&ip_practitioner_id="+HdrformObj.surgeon_code.value+"&IP_YN=Y&location_code="+HdrformObj.source_code.value+"&patient_class="+HdrformObj.patient_class.value+"&oper_num="+HdrformObj.oper_num.value;
	var jsp_name = "";
	jsp_name = "../../eCA/jsp/PatProblemMain.jsp?"+param;
	var retVal =        new String();
	var dialogHeight="33.4";
	var dialogWidth="49.6";
	var dialogTop="65";
	var status = "no";
	var arguments    = "" ;
	var features        = "dialogHeight:" + dialogHeight + "; dialogTop:" + dialogTop + "; dialogWidth:" + dialogWidth +" ; scroll=no; status:" + status;
	retVal = window.showModalDialog(jsp_name,arguments,features);
}
*/
function changeTab(objStr){
	selectTab(objStr);
	var frmObj=document.forms[0];
	var tab_hide_yn = frmObj.tab_hide_yn.value;
	var param=frmObj.param.value;
	if(parent.RecordFrame!=null){
	switch(objStr){
		case 'OperationsProcedures':  parent.RecordFrame.location.href='../../eOT/jsp/ProcedureFrames.jsp?'+param;
									  break;

		case 'PersonnelDetails' :     parent.RecordFrame.location.href='../../eOT/jsp/PersonnelCommonFrames.jsp?'+param;
									  break;

		case 'SurgeonNotes'     :	  parent.RecordFrame.location.href='../../eOT/jsp/SurgeonNotesFrames.jsp?'+param;
									  break;

		case 'TimeAndDetails'   :	  parent.RecordFrame.location.href='../../eOT/jsp/TimeDtlsFrames.jsp?'+param;
									  break;

		case 'Implants'         : 	  parent.RecordFrame.location.href='../../eOT/jsp/NursingOperDtlsChildFrames.jsp?'+param+"&tab_id=ImplantsTab";
									  break;
		
		case 'ICDPCS'           : 	  parent.RecordFrame.location.href='../../eOT/jsp/ICDPCSFrames.jsp?'+param+"&tab_id="+objStr;
									  break;
		
	}
  }
	/* if(parent.parent.messageFrame!=null)
		parent.parent.messageFrame.location.href="../../eCommon/jsp/error.jsp?err_num=";*/
}




async function openDialog123(strVal,obj){
	 var remarks = encodeURIComponent(obj);
	//var remarks = eval(obj);
   await window.showModalDialog('../../eOT/jsp/TextArea.jsp?heading='+encodeURIComponent(strVal)+'&remarks='+remarks,window,"dialogHeight: 145px; dialogWidth:500px; center: yes; help: no; resizable: no; status: no;");
}

async function openDialog(strVal,obj){
	 var remarks = encodeURIComponent(obj);
   await window.showModalDialog('../../eOT/jsp/TextArea.jsp?heading='+encodeURIComponent(strVal)+'&remarks='+remarks,window,"dialogHeight: 145px; dialogWidth:500px; center: yes; help: no; resizable: no; status: no;");
}



function CodeArrest() 
{
    if((window.event.button == 2) || (window.event.button == 3) || (window.event.button == 4)) 
	{
        alert("Welcome to eHIS");
    }
}

function lockKey()
{
    if(event.keyCode == 93)
		alert(getMessage("WELCOME",'Common'));
	
}

function assignChkBoxVal(obj,obj2,oper_code,index,spec_code)
{
	var oper_num=document.forms[0].oper_num.value;
	var facility_id=document.forms[0].facility_id.value;
	//PMG MOD-0005 Start
	var LinkNotesFlag=document.getElementById("Link_Operation_And_Notes_in_Record_Surgeon_Notes").value;//PMG MOD-0005	
	if(LinkNotesFlag != 'Y')
	{
		assignChkBoxVal2(obj,obj2,oper_code,index,spec_code);
	}
	else
	{
	//PMG MOD-0005 End
	var rows=parent.parent.parent.ObjectCollect.rows;
	var chk_val=rows[index].db_mode;
	var oper_code=rows[index].oper_code;
	var chk_status=rows[index].oper_line_status;
	var Speciality_code_old="";
	var flag1=true;
	var rows1=parent.parent.parent.ObjectCollect.implants_rows;

	for(var jj=0;jj<rows1.length;jj++) {
		if(rows1[jj])
		{
		if(oper_code == (rows1[jj].oper_code))
		{
			 flag1=false;
			 alert(getMessage("PRC-OT0051","OT"));
			 obj.checked=false;
			 obj.value="";
	 	}

		}
	}

	if(flag1 ==true)
	{
		var per_rows=parent.parent.parent.ObjectCollect.personnelrows;
		for (var pp=0;pp<per_rows.length;pp++ )
		{
			if(per_rows[pp].db_mode!='D')//ML-BRU-SCF-1192 [IN:045650]
			{
			var speaciality_code=per_rows[pp].speciality_code;
			var arr=speaciality_code.split(",");
			if(spec_code==(arr[0]))
			{
	    	flag1=false;
			 alert(getMessage("APP-OT0176","OT"));
			 obj.checked=false;
			 obj.value="";
			 return; //against IN:046619
		}
	}
	}
	}


	if(flag1 ==true)
	{
		var visit_per_rows=parent.parent.parent.ObjectCollect.visit_pers_rows;
		for (var v=0;v< visit_per_rows.length;v++ )
		{
			if(visit_per_rows[v])
			{
				var speaciality_code=visit_per_rows[v].speciality_code;
				var arr=speaciality_code.split(",");
				if(spec_code==(arr[0]))
				{
					 flag1=false;
					 alert(getMessage("APP-OT0177","OT"));
					 obj.checked=false;
					 obj.value="";
				}
			}
		}
	}


	if(flag1 ==true)
	{
		var wound_rows=parent.parent.parent.ObjectCollect.wound_rows;
		for (var w=0;w<wound_rows.length;w++ )
		{
			if(wound_rows[w])
			{
				var speaciality_code=wound_rows[w].speciality_code;
				var arr=speaciality_code.split(",");
				if(spec_code==(arr[0]))
				{
				 flag1=false;
				 alert(getMessage("APP-OT0178","OT"));
				 obj.checked=false;
				 obj.value="";
				}
			}
		}
	}

	
	if(flag1 ==true)
	{
		var time_rows=parent.parent.parent.ObjectCollect.time_rows;
		for (var tt=0;tt<time_rows.length;tt++ )
		{
			if(time_rows[tt])
			{
			var speaciality_code=time_rows[tt].speciality_code;
			var arr=speaciality_code.split(",");
			if(spec_code==(arr[0]))
			{
		    	flag1=false;
				 alert(getMessage("APP-OT0180","OT"));
				 obj.checked=false;
				 obj.value="";
			}
		}
	}
	}
	
	if(flag1 ==true)
	{

			var contr_mod_accession_num=facility_id+oper_num+spec_code+"30";
	
			var xmlDoc = "" ;
			var xmlHttp = new XMLHttpRequest();
			var xmlStr ="<root></root>";
			xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
			xmlHttp.open("POST","CommonValidation.jsp?func_mode=check_surg_notes&contr_mod_accession_num="+contr_mod_accession_num+"&facility_id="+facility_id,false);
			xmlHttp.send(xmlDoc);
			var retVal = localTrimString(xmlHttp.responseText); 
	
			if(retVal =="true")
			{
				flag1=false;
				 alert(getMessage("APP-OT0179","OT"));
				 obj.checked=false;
				 obj.value="";
			}else
			{
				flag1=true;
			} //commented by lakshmi on 10/08/2012
		
	}

	var specialty_code=parent.parent.frames[4].RecordSurgeonTabForm.Speciality_code_val.value
	var cur_spec_code=spec_code;

	if(flag1 ==true)
	{
	if(obj2 =="U")
		{
			var flag=false;
			var xmlDoc = "" ;
			var xmlHttp = new XMLHttpRequest();
			var xmlStr ="<root></root>";
			xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
			xmlHttp.open("POST","CommonValidation.jsp?func_mode=cancel_oper_chk&oper_code="+oper_code+"&oper_num="+oper_num+"&facility_id="+facility_id+"&specialty_code_all="+specialty_code+"&cur_spec_code="+cur_spec_code,false);
			xmlHttp.send(xmlDoc);
			var retVal = localTrimString(xmlHttp.responseText); 
    		if(retVal=="true")
			{
			flag=true;
				}else
				{

					alert(getMessage("PRC-OT0051","OT"));
					obj.checked=false;
					obj.value="";
					flag=false;
				}

				if(obj.checked==true && flag==true)
			{
				obj.value="99";
				document.forms[0].remarks.style.visibility="hidden";
				document.forms[0].remarks.style.display="none";
				document.forms[0].cancel_remarks.style.visibility="visible";
				document.forms[0].cancel_remarks.style.display="inline";
				document.getElementById('remarks_one').innerText=getLabel("eOT.CancelledRemarks.Label","eOT");
				
				
			}else
			{
				obj.value=" ";
				document.getElementById('remarks_one').innerText=getLabel("Common.remarks.label","Common");
				document.forms[0].remarks.style.visibility="visible";
				document.forms[0].remarks.style.display="inline";
				document.forms[0].cancel_remarks.style.visibility="hidden";
				document.forms[0].cancel_remarks.style.display="none";
			}
	}else
	{

		obj.checked=false;
	}
}
	}//PMG MOD-0005
}


function deleteRow(oper_code,chk_status){
        var icd_pcs_rows = parent.parent.ObjectCollect.ICD_PCS_ROWS;
        var flag=true;
        if(chk_status=='99')
	{
        getMatchedRow(oper_code);
	} else 
	{
        reAutoPopulate(oper_code);
	}
}

function getMatchedRow(oper_code){
        var rows = parent.parent.ObjectCollect.ICD_PCS_ROWS;
        var frmRef = parent.parent.ObjectCollect;
        for(j in rows){

                if (oper_code == rows[j].oper_code){
						    rows[j].db_mode="D";
                        //return j;
                }
        }
        if(frmRef.mandatory_proc[oper_code]=="N")
        {
        frmRef.mandatory_proc[oper_code]="Y";
        }
}
function reAutoPopulate(oper_code)
{
var rows = parent.parent.ObjectCollect.ICD_PCS_ROWS;
var frmRef = parent.parent.ObjectCollect;
var count=0;
        for(j in rows){
                if (oper_code == rows[j].oper_code){
                        if(rows[j].color=="AUTO" )
                        {
				//rows[j].db_mode="I";  //commented for scf-6081 by Anitha		   
                        }
                        else if(rows[j].color=="MANDATORY")
                        {                             
                        frmRef.mandatory_proc[oper_code]="N";
                        if(parent.parent.parent.doc_status_frame.SurgeonDocStatusForm.doc_complete.checked==true)
                        parent.parent.parent.doc_status_frame.SurgeonDocStatusForm.doc_complete.checked = false;
                        //if(parent.parent.parent.doc_status_frame.SurgeonDocStatusForm.oper_proc.checked==true)
                    //parent.parent.parent.doc_status_frame.SurgeonDocStatusForm.oper_proc.checked = false;       
                        }

                        //return j;
                }
                //count++;
        }
        /* Setting Mandatory flag for (Only for)Mandatory Fields which are not entered in details frame of Procedure Coding Scheme tab. when Check status res assigned as blank(not 99)*/
        if(frmRef.mandatory_proc[oper_code]=="Y")
        {
        frmRef.mandatory_proc[oper_code]="N";
        if(parent.parent.parent.doc_status_frame.SurgeonDocStatusForm.doc_complete.checked==true)
        parent.parent.parent.doc_status_frame.SurgeonDocStatusForm.doc_complete.checked = false;
        //if(parent.parent.parent.doc_status_frame.SurgeonDocStatusForm.oper_proc.checked==true)
        //parent.parent.parent.doc_status_frame.SurgeonDocStatusForm.oper_proc.checked = false; 
        }
}
function getMatchedNoofRows(oper_code){
        var rows = parent.parent.ObjectCollect.ICD_PCS_ROWS;
        var k=0;
        for(j in rows){
                if (oper_code == rows[j].oper_code){
                        k++;
                }
        }
        return k;
}
function loadDBRows_pro_coding(strval){ 
  var frmRef = parent.parent.ObjectCollect;
  var rows=frmRef.ICD_PCS_ROWS;
  
  var arr = strval.split('::');
   //oper_line_no::oper_code::oper_desc::coding_scheme::proc_code::proc_desc::color
  var flag=true;
  for(j in rows){
                if (arr[1] == rows[j].oper_code && arr[4] == rows[j].proc_code){
                       
                        flag=false;
                        break;
   }else{
            flag=true;
   }
  }
  if(flag==true){
        var obj = newRow();
        obj.line_no=arr[0];
        obj.oper_code=arr[1];
        obj.oper_desc=arr[2]
        obj.coding_scheme=arr[3];
        obj.proc_code=arr[4];
        obj.proc_desc=arr[5];
        obj.color=arr[6];
        arr[6]=="AUTO"?obj.link_enable="N":obj.link_enable="Y";
        arr[6]=="MANDATORY"?frmRef.mandatory_proc[arr[4]]="Y":"";
        obj.db_mode="L";
        obj.rec_id=rows.length+1;
        rows.push(obj);
  }
}
function getSpecialityCodeDesc(specialityCodeDesc, code)
{
	 var specialityArray = specialityCodeDesc.split(" - ");
	 return specialityArray;
}
//Added by MuthuN against CRF - 011 on 2/7/2013
async function callPreOPDiagnosis(){
	var HdrformObj=parent.parent.common_patient_hdr_frame.CommonOperDtlsHdrForm;
	var Age= "";		// can pass null
	var Dob= HdrformObj.date_of_birth.value;
	var Function= ""; 
	var Sex= HdrformObj.sex.value;
	var encounter_id= HdrformObj.encounter_id.value;
	var episode_id= HdrformObj.episode_id.value;
	var episode_type= HdrformObj.episode_type.value;
	var function_id= "";
	var location_code= HdrformObj.source_code.value;
	var location_type= HdrformObj.source_type.value;
	var modal_yn= "Y";
	var occur_srl_no= "";
	var patient_class= HdrformObj.patient_class.value;
	var patient_id= HdrformObj.patient_id.value;
	var practitioner_id= HdrformObj.surgeon_code.value;
	var  param_sur="func_mode=diag_code_scheme&practitioner_id="+practitioner_id;
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest() ;
	var xmlStr ="<root><SEARCH ";
	xmlStr +=" /></root>";
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("GET","../../eOT/jsp/OTCommonValidation.jsp?"+param_sur,false);
	xmlHttp.send(xmlDoc);
	var retVal = localTrimString(xmlHttp.responseText);
	retVal_arr=retVal.split(":::");
	var diag_code_scheme = retVal_arr[0];
	var practitioner_type = retVal_arr[1];
	var relationship_id= "";
	var term_code= ""; // can pass null
	var term_set_id= "";
	var speciality_code = HdrformObj.speciality_code.value;
	var visit_adm_date= "";	
	var child_window="Y";
		var param = "Age=&Dob="+Dob+"&Function="+Function+"&Sex="+Sex+"&episode_id="+episode_id+"&encounter_id="+encounter_id+"&episode_type="+episode_type+"&function_id="+function_id+"&location_code="+location_code+"&location_type="+location_type+"&modal_yn="+modal_yn+"&occur_srl_no="+occur_srl_no+"&patient_class="+patient_class+"&patient_id="+patient_id+"&practitioner_id="+practitioner_id+"&practitioner_type="+practitioner_type+"&relationship_id="+relationship_id+"&term_code="+term_code+"&visit_adm_date="+visit_adm_date+"&child_window="+child_window+"&diag_code_scheme="+diag_code_scheme+"&speciality_code="+speciality_code;		
		var jsp_name = "";
		jsp_name = "../../eMR/jsp/RecDiagnosis.jsp?"+param;
		var retVal =        new String();
		var dialogHeight = screen.availHeight ;
		var dialogWidth  		= screen.availWidth;
		var dialogTop    = "0";
		var dialogLeft   = "0";
		var status = "no";
		var arguments    = "" ;
		var features        = "dialogHeight:" + dialogHeight + "; dialogTop:" + dialogTop + "; dialogLeft:" + dialogLeft + "; dialogWidth:" + dialogWidth +" ; scroll=no; status:" + status;
		retVal = await top.window.showModalDialog(jsp_name,arguments,features);
}
async function callPreOPDiagnosis_1(){
	var HdrformObj=parent.frames[0].document.forms[0];
	var Age= "";		// can pass null
	var Dob= HdrformObj.date_of_birth.value;
	var Function= ""; 
	var Sex= HdrformObj.sex.value;
	var encounter_id= HdrformObj.encounter_id.value;
	var episode_id= HdrformObj.episode_id.value;
	var episode_type= HdrformObj.episode_type.value;
	var function_id= "";
	var location_code= HdrformObj.source_code.value;
	var location_type= HdrformObj.source_type.value;
	var modal_yn= "Y";
	var occur_srl_no= "";
	var patient_class= HdrformObj.patient_class.value;
	var patient_id= HdrformObj.patient_id.value;
	var practitioner_id= HdrformObj.surgeon_code.value;
	var  param_sur="func_mode=diag_code_scheme&practitioner_id="+practitioner_id;
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest() ;
	var xmlStr ="<root><SEARCH ";
	xmlStr +=" /></root>";
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("GET","../../eOT/jsp/OTCommonValidation.jsp?"+param_sur,false);
	xmlHttp.send(xmlDoc);
	var retVal = localTrimString(xmlHttp.responseText);
	retVal_arr=retVal.split(":::");
	var diag_code_scheme = retVal_arr[0];
	var practitioner_type = retVal_arr[1];
	var relationship_id= "";
	var term_code= ""; // can pass null
	var term_set_id= "";
	var called_from_ot = "PRE_OPER";
	var speciality_code = HdrformObj.speciality_code.value;
	var visit_adm_date= "";	
	var child_window="Y";
	if(!checkForEmpty(parent.frames[0].document))
	{		
		var param = "Age=&Dob="+Dob+"&Function="+Function+"&Sex="+Sex+"&episode_id="+episode_id+"&encounter_id="+encounter_id+"&episode_type="+episode_type+"&function_id="+function_id+"&location_code="+location_code+"&location_type="+location_type+"&modal_yn="+modal_yn+"&occur_srl_no="+occur_srl_no+"&patient_class="+patient_class+"&patient_id="+patient_id+"&practitioner_id="+practitioner_id+"&practitioner_type="+practitioner_type+"&relationship_id="+relationship_id+"&term_code="+term_code+"&visit_adm_date="+visit_adm_date+"&called_from_ot="+called_from_ot+"&child_window="+child_window+"&diag_code_scheme="+diag_code_scheme+"&speciality_code="+speciality_code;		
		var jsp_name = "";
		jsp_name = "../../eMR/jsp/RecDiagnosis.jsp?"+param;
		var retVal =        new String();
		var dialogHeight = "90vh";
		var dialogWidth  		= "90vw";
		var dialogTop    = "0";
		var dialogLeft   = "0";
		var status = "no";
		var arguments    = "" ;
		var features        = "dialogHeight:" + dialogHeight + "; dialogTop:" + dialogTop + "; dialogLeft:" + dialogLeft + "; dialogWidth:" + dialogWidth +" ; scroll=no; status:" + status;
		retVal = await top.window.showModalDialog(jsp_name,arguments,features);
	}
}
async function callPreOPDiagnosis_2(){
	var HdrformObj=document.forms[0];
	var Age= "";		// can pass null
	var Dob= HdrformObj.date_of_birth.value;
	var Function= ""; 
	var Sex= HdrformObj.sex.value;
	var encounter_id= HdrformObj.encounter_id.value;
	var episode_id= HdrformObj.episode_id.value;
	var episode_type= HdrformObj.episode_type.value;
	var function_id= "";
	var location_code= HdrformObj.sourceDesc.value;
	var location_type= HdrformObj.sourceType.value;
	var modal_yn= "Y";
	var occur_srl_no= "";
	var patient_class= HdrformObj.episode_type.value;
	var patient_id= HdrformObj.patient_id.value;
	var practitioner_id= HdrformObj.order_id.value;
	var  param_sur="func_mode=diag_code_scheme&practitioner_id="+practitioner_id;
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest() ;
	var xmlStr ="<root><SEARCH ";
	xmlStr +=" /></root>";
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("GET","../../eOT/jsp/OTCommonValidation.jsp?"+param_sur,false);
	xmlHttp.send(xmlDoc);
	var retVal = localTrimString(xmlHttp.responseText);
	retVal_arr=retVal.split(":::");
	var diag_code_scheme = retVal_arr[0];
	var practitioner_type = retVal_arr[1];
	var relationship_id= "";
	var term_code= ""; // can pass null
	var term_set_id= "";
	var called_from_ot = "PRE_OPER";
	//var speciality_code = HdrformObj.SPECIALITY_CODE.value;
	var hiddenField = parent.window[2].window[2].window[0];
	var speciality_code = hiddenField.speciality_code.value;
	var visit_adm_date= "";	
	var child_window="Y";
	if(!checkForEmpty(parent.frames[1]))
	{
		var param = "Age=&Dob="+Dob+"&Function="+Function+"&Sex="+Sex+"&episode_id="+episode_id+"&encounter_id="+encounter_id+"&episode_type="+episode_type+"&function_id="+function_id+"&location_code="+location_code+"&location_type="+location_type+"&modal_yn="+modal_yn+"&occur_srl_no="+occur_srl_no+"&patient_class="+patient_class+"&patient_id="+patient_id+"&practitioner_id="+practitioner_id+"&practitioner_type="+practitioner_type+"&relationship_id="+relationship_id+"&term_code="+term_code+"&visit_adm_date="+visit_adm_date+"&called_from_ot="+called_from_ot+"&child_window="+child_window+"&diag_code_scheme="+diag_code_scheme+"&speciality_code="+speciality_code;
		var jsp_name = "";
		jsp_name = "../../eMR/jsp/RecDiagnosis.jsp?"+param;
		var retVal =        new String();
		var dialogHeight = screen.availHeight ;
		var dialogWidth  		= screen.availWidth;
		var dialogTop    = "0";
		var dialogLeft   = "0";
		var status = "no";
		var arguments    = "" ;
		var features        = "dialogHeight:" + dialogHeight + "; dialogTop:" + dialogTop + "; dialogLeft:" + dialogLeft + "; dialogWidth:" + dialogWidth +" ; scroll=no; status:" + status;
		retVal = await window.showModalDialog(jsp_name,arguments,features);
	}
}
function showPreOperDiagLink()
{
	var showDivLink = true;
	if(document.getElementById("showPreOperDiagDiv") == undefined)
	{
		return;
	}
	for(var index = 0; index < preOperDiagArray.length; index++)						
	{
		var objValue = document.getElementById(preOperDiagArray[index]).value;
		if( objValue == "" || objValue == "XT")
		{
			showDivLink = false;
		}
	}
	if(showDivLink)
	{
		document.getElementById("showPreOperDiagDiv").style.display='inline';
	}
	else
	{
		document.getElementById("showPreOperDiagDiv").style.display='none';
	}
}
function checkForEmpty()
{
	for(var index = 0; index < preOperDiagArray.length; index++)						
	{
		if(document.getElementById(preOperDiagArray[index]).value == '')
		{
			var msg1 = getMessage("OT_MANDATORY","OT");
			alert(msg1);	
			return true;
		}
	}
	return false;
}
//Added by MuthuN against CRF - 011  on 2/7/2013
async function viewStaffAssignment(assignmentDate, operRoomCode)
{
	var dialogUrl       = "../../eOT/jsp/StaffAssignmentView.jsp?title=Audit History"+"&assignmentDate="+assignmentDate+"&operRoomCode="+operRoomCode ;
	var dialogArguments = '';
    var dialogFeatures  = "dialogHeight:" + 25 + "; dialogWidth:" + 50 +" ; scroll=yes;resizable:yes; status:" + status;
	 await window.showModalDialog(dialogUrl, dialogArguments, dialogFeatures);		
}



//PMG MOD-0005 START
function assignChkBoxVal2(obj,obj2,oper_code,index,spec_code)
{
	var LinkNotesAvailabelData="";
	var oper_num=document.forms[0].oper_num.value;
	var facility_id=document.forms[0].facility_id.value;
	var rows=parent.parent.parent.ObjectCollect.rows;
	var chk_val=rows[index].db_mode;
	var oper_code=rows[index].oper_code;
	var chk_status=rows[index].oper_line_status;
	var Speciality_code_old="";
	var flag1=true;
	//Added vikash
	var eOT_SurgicalAccessories_Label=false;
	var eOT_PersonnelDetails_Label=false;
	var eOT_VisitingPersonnel_Label=false;
	var eOT_WoundDetails_Label=false;
	var eOT_TimeandDetails_Label=false;

	var rows1=0;
	var per_rows=0;
	var visit_per_rows=0;
	var wound_rows=0;
	var time_rows=0;
	//Added Vikash
	//var rows1=parent.parent.parent.ObjectCollect.implants_rows;

	rows1=parent.parent.parent.ObjectCollect.implants_rows;
	for(var jj=0;jj<rows1.length;jj++) {
		if(rows1[jj])
		{
		if((oper_code == rows1[jj].oper_code) && (rows1[jj].db_mode != 'D'))
		{
		
			 eOT_SurgicalAccessories_Label=true;
			 LinkNotesAvailabelData = LinkNotesAvailabelData.concat(",", getLabel("eOT.SurgicalAccessories.Label","Common"));
	 	}
		}
	}

	if(flag1 ==true)
	{
		//var per_rows=parent.parent.parent.ObjectCollect.personnelrows;
		per_rows=parent.parent.parent.ObjectCollect.personnelrows;

		for (var pp=0;pp<per_rows.length;pp++ )
		{
			if(per_rows[pp].db_mode!='D')//ML-BRU-SCF-1192 [IN:045650]
			{
			var speaciality_code=per_rows[pp].speciality_code;
			var arr=speaciality_code.split(",");
			if(spec_code==(arr[0]))
			{
					eOT_PersonnelDetails_Label=true;
				 LinkNotesAvailabelData = LinkNotesAvailabelData.concat(",", getLabel("eOT.PersonnelDetails.Label","Common"));
			}
		}
	}
}

	if(flag1 ==true)
	{
		//var visit_per_rows=parent.parent.parent.ObjectCollect.visit_pers_rows;
		visit_per_rows=parent.parent.parent.ObjectCollect.visit_pers_rows;
		for (var v=0;v< visit_per_rows.length;v++ )
		{
		if(visit_per_rows[v].db_mode!='D')//Added 54692
		{
			var speaciality_code=visit_per_rows[v].speciality_code;
			var arr=speaciality_code.split(",");
			if(spec_code==(arr[0]))
			{
				eOT_VisitingPersonnel_Label=true;
			 LinkNotesAvailabelData = LinkNotesAvailabelData.concat(",", getLabel("eOT.VisitingPersonnel.Label","Common"));
			}
		}
		}
	}


	if(flag1 ==true)
	{
		//var wound_rows=parent.parent.parent.ObjectCollect.wound_rows;
		wound_rows=parent.parent.parent.ObjectCollect.wound_rows;
		for (var w=0;w<wound_rows.length;w++ )
		{
		if(wound_rows[w].db_mode!='D')//Added 54692
		{
			var speaciality_code=wound_rows[w].speciality_code;
			var arr=speaciality_code.split(",");
			if(spec_code==(arr[0]))
			{
				eOT_WoundDetails_Label=true;
			 LinkNotesAvailabelData = LinkNotesAvailabelData.concat(",", getLabel("eOT.WoundDetails.Label","Common"));
			}
		}
	}
	}


	if(flag1 ==true)
	{
		//var time_rows=parent.parent.parent.ObjectCollect.time_rows;
		time_rows=parent.parent.parent.ObjectCollect.time_rows;
		for (var tt=0;tt<time_rows.length;tt++ )
		{
		if(time_rows[tt].db_mode!='D')//Added 54692
		{
			var speaciality_code=time_rows[tt].speciality_code;
			var arr=speaciality_code.split(",");
			if(spec_code==(arr[0]))
			{
				eOT_TimeandDetails_Label=true;
			 LinkNotesAvailabelData = LinkNotesAvailabelData.concat(",", getLabel("eOT.TimeandDetails.Label","Common"));
			}
		}
		}
	}

	if(flag1 ==true)
	{
			var contr_mod_accession_num=facility_id+oper_num+spec_code+"30";	
			var xmlDoc = "" ;
			var xmlHttp = new XMLHttpRequest();
			var xmlStr ="<root></root>";
			xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");

			xmlHttp.open("POST","CommonValidation.jsp?func_mode=check_surg_notes&contr_mod_accession_num="+contr_mod_accession_num+"&facility_id="+facility_id,false);
			xmlHttp.send(xmlDoc);
			var retVal = localTrimString(xmlHttp.responseText); 

			if(retVal =="true")
			{
			 LinkNotesAvailabelData = LinkNotesAvailabelData.concat(",", getLabel("Common.notes.label","Common"));
			}else
			{
				flag1=true;
			} 
	}

	var specialty_code=parent.parent.frames[4].RecordSurgeonTabForm.Speciality_code_val.value
	var cur_spec_code=spec_code;

	if(flag1 ==true)
	{
		if(obj2 =="U")
		{
			var flag=false;			
			var xmlDoc = "" ;
			var xmlHttp = new XMLHttpRequest();
			var xmlStr ="<root></root>";
			xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
			xmlHttp.open("POST","CommonValidation.jsp?func_mode=cancel_oper_chk&oper_code="+oper_code+"&oper_num="+oper_num+"&facility_id="+facility_id+"&specialty_code_all="+specialty_code+"&cur_spec_code="+cur_spec_code,false);
			xmlHttp.send(xmlDoc);
			var retVal = localTrimString(xmlHttp.responseText); 

    		if(retVal=="true")
				{
					flag=true;
				}
			else
				{					
					flag=false;
					//LinkNotesAvailabelData = LinkNotesAvailabelData.concat(",", getLabel("eOT.SurgicalAccessories.Label","Common"));
				}
				

				
				var contr_mod_accession_num2=facility_id+oper_num+spec_code+"30";
				var xmlDoc = "" ;
				var xmlHttp = new XMLHttpRequest();
				var xmlStr ="<root></root>";
				xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");

				xmlHttp.open("POST","CommonValidation.jsp?func_mode=check_record_surg_notes&oper_num="+oper_num+"&facility_id="+facility_id+"&spec_code="+spec_code+"&oper_code="+oper_code+"&contr_mod_accession_num="+contr_mod_accession_num2,false);
				xmlHttp.send(xmlDoc);
				var retVal = localTrimString(xmlHttp.responseText); 
				var flag2=true;
				if(retVal=='undefined'|| retVal==''|| retVal==null)
				{
					flag2 =false;
				}
				else
				{
				
				var record_surg_note_arr=retVal.split(",");
				var record_surg_note="";

				for(var i=0;i<record_surg_note_arr.length-1;i++)
				{
						record_surg_note=record_surg_note.concat(getLabel(record_surg_note_arr[i],"Common"));
						if(i<record_surg_note_arr.length-2)
						{
							record_surg_note=record_surg_note.concat(",");
						}

				}
				
				}

				



				var LinkNotesAvailabelData2=LinkNotesAvailabelData.slice(1);	

				LinkNotesAvailabelData2=LinkNotesAvailabelData2.concat(",");

				if(record_surg_note!='undefined' && record_surg_note!='' && record_surg_note!=null)
				{
					
					if(rows1.length>0 && eOT_SurgicalAccessories_Label==false){
					
					record_surg_note=record_surg_note.replace("Surgical Accessories","");
					}
					if(per_rows.length>0 && eOT_PersonnelDetails_Label==false){
					
					record_surg_note=record_surg_note.replace("Personnel Details","");
					}

					if(visit_per_rows.length>0 && eOT_VisitingPersonnel_Label==false){
					
					record_surg_note=record_surg_note.replace("Visiting Personnel","");
					}
					if(wound_rows.length>0 && eOT_WoundDetails_Label==false){
					
					record_surg_note=record_surg_note.replace("Wound Details","");
					}
					if(time_rows.length>0 && eOT_TimeandDetails_Label==false){
					
					record_surg_note=record_surg_note.replace("Time and Details","");
					}
					


				LinkNotesAvailabelData2=LinkNotesAvailabelData2.concat(record_surg_note);
				}
				
				var LinkNotesAvailabelDataArray=LinkNotesAvailabelData2.split(",");			

				LinkNotesAvailabelDataArray=eliminateDuplicates(LinkNotesAvailabelDataArray);
			
				LinkNotesAvailabelData2="";

				for(var ii=0;ii<LinkNotesAvailabelDataArray.length;ii++)
				{
					LinkNotesAvailabelData2=LinkNotesAvailabelData2.concat(LinkNotesAvailabelDataArray[ii]);
					if(ii<LinkNotesAvailabelDataArray.length-1)
					{
						LinkNotesAvailabelData2=LinkNotesAvailabelData2.concat(",");
					}					
				}

				var alertMsgArr = getMessage("APP-OT0230","OT").split("#");
				var LinkNotesAvailabelData3 = alertMsgArr[0] + " " + LinkNotesAvailabelData2 + " " + alertMsgArr[1];
				var LinkNotesFlag=true;

				if(LinkNotesAvailabelData2.length>0 && obj.checked==true && LinkNotesAvailabelData2!='undefined' && LinkNotesAvailabelData2!='' && LinkNotesAvailabelData2!=null)
				{
					LinkNotesFlag=window.confirm(LinkNotesAvailabelData3)
				}
				if(obj.checked==true && flag==true && LinkNotesFlag)
				{
					obj.value="99";
					document.forms[0].remarks.style.visibility="hidden";
					document.forms[0].remarks.style.display="none";
					document.forms[0].cancel_remarks.style.visibility="visible";
					document.forms[0].cancel_remarks.style.display="inline";
					document.getElementById('remarks_one').innerText=getLabel("eOT.CancelledRemarks.Label","eOT");			
				}
				else
				{
					obj.value="";
					document.getElementById('remarks_one').innerText=getLabel("Common.remarks.label","Common");
					document.forms[0].remarks.style.visibility="visible";
					document.forms[0].remarks.style.display="inline";
					document.forms[0].cancel_remarks.style.visibility="hidden";
					document.forms[0].cancel_remarks.style.display="none";
					obj.checked=false;
				}
			}else
			{

				obj.checked=false;
			}
	}
}

function eliminateDuplicates(arr) {
  var i,
      len=arr.length,
      out=[],
      obj={};
 
  for (i=0;i<len;i++) {
    obj[arr[i]]=0;
  }
  for (i in obj) {
    out.push(i);
  }


  return cleanArray(out);
}


function cleanArray(actual){
  var newArray = new Array();
  for(var i = 0; i<actual.length; i++){
      if (actual[i]){
        newArray.push(actual[i]);
    }
  }
  return newArray;
}

//PMG MOD-0005 END
//ML-BRU-SCF-1550 [IN:053512] start
function SurNotesDocComp(facility_id,oper_num,modified_Surgeon_Note_Date,surgeon_doc_comp_yn)
{
		var flag1="";
		if(surgeon_doc_comp_yn=='Y')
		{			
			var xmlDoc = "" ;
			var xmlHttp = new XMLHttpRequest();
			var xmlStr ="<root></root>";
			xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
			xmlHttp.open("POST","CommonValidation.jsp?func_mode=check_modified_surgeon_note_Date&oper_num="+oper_num+"&facility_id="+facility_id+"&modified_Surgeon_Note_Date="+modified_Surgeon_Note_Date,false);
			xmlHttp.send(xmlDoc);
			var retVal = localTrimString(xmlHttp.responseText); 
			return retVal;
	}
}
function localTrimString(sInString) {
   return sInString.replace(/^\s+|\s+$/g,"");
}
//ML-BRU-SCF-1550 [IN:053512] ends
//PMG2017-SS-CRF-0001-US002
function callAnaesthesia1(obj){	
var result		=	false ;
var message		=	"" ;
var flag		=	"" ;
var function_id = "";
	var argumentArray  = new Array();
	var dataNameArray  = new Array();
	var dataValueArray = new Array();
	var dataTypeArray  = new Array();
	var obj1=document.forms[0];

	var sql="SELECT ANAESTHESIA_CODE CODE,SHORT_DESC  DESCRIPTION FROM AM_ANAESTHESIA WHERE  NVL(EFF_STATUS,'E') = 'E' AND upper(ANAESTHESIA_CODE) like upper(?) AND upper(SHORT_DESC) like upper(?) order by 2";

	argumentArray[0] = sql;
	argumentArray[1] = dataNameArray;
	argumentArray[2] = dataValueArray;
	argumentArray[3] = dataTypeArray;
	argumentArray[4] = "1,2";
	argumentArray[5] = obj.value;
	argumentArray[6] = DESC_LINK;
	argumentArray[7] = DESC_CODE;
	var Anaesthesia = getLabel("Common.Anaesthesia.label","Common");
	var returnedValues = CommonLookup(Anaesthesia, argumentArray );

	if((returnedValues != null) && (returnedValues != "") )  {
		document.forms[0].anaesthesia_code.value = returnedValues[0];
		document.forms[0].anaesthesia_desc.value = returnedValues[1];	
		}
	else
		{
			document.forms[0].anaesthesia_desc.value = '';
			document.forms[0].anaesthesia_code.value = '';
		}
}

function clearDesc()
{
	document.forms[0].anaesthesia_code.value = '';
}

function CheckMandatoryFields()
{
	var submitflag = 'false';
	var messageFrame = parent.messageFrame;
	var HdrformObj = parent.parent.common_patient_hdr_frame.CommonOperDtlsHdrForm; 
	var fields= new Array(HdrformObj.anaesthesia_code);
	var names=new Array(getLabel("eOT.AnaesthesiaType.Label","OT"));	
	if(checkFields(fields,names,messageFrame)){
		submitflag=true;
	}else{
		submitflag=false;
	}
	return submitflag;
}
//PMG2017-SS-CRF-0001-US002

