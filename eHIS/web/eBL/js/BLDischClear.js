function onLoad(){
	parent.frames[1].location.href="../../eBL/jsp/BLDischClearGenerateFrameSet.jsp";
}

function reset(){
	frames[0].location.reload();
	frames[1].location.reload();
	frames[2].location.href = "../../eCommon/jsp/error.jsp";
}

function onSuccess()
{
	frames[0].location.reload();
	frames[1].location.reload();
}

function gen_disch_clearance_reultset(){
	
	var today = new Date();
	var date = (today.getDate()<10 ? '0'+today.getDate():today.getDate())+'/'+((today.getMonth()+1)<10 ? '0'+(today.getMonth()+1):(today.getMonth()+1))+'/'+today.getFullYear();
	var time = today.getHours() + ":" +(today.getMinutes()<10 ? '0'+today.getMinutes():today.getMinutes()) + ":" + (today.getSeconds()<10 ? '0'+today.getSeconds():today.getSeconds());
	var dateTime = date+' '+time;
	
	var frm = document.forms[0];
	var patient_id = frm.patient_id.value;
	var nursing_unit = frm.nursing_unit_code.value;
	var episode_id = frm.episode_id.value;
	var disc_advice_dt_from = frm.Effective_from.value;
	var disc_advise_dt_to = frm.Effective_to.value;
	var option_val = frm.option_type.value;	
	
	parent.parent.parent.frames[2].location.href = "../../eCommon/jsp/error.jsp";
	
	parent.frames[1].location.href="../../eBL/jsp/BLDischClearGenerateResult.jsp?patient_id="+patient_id+"&nursing_unit="+nursing_unit+"&episode_id="+episode_id+"&disc_advice_dt_from="+disc_advice_dt_from+"&disc_advise_dt_to="+disc_advise_dt_to+"&option_val="+option_val;
	
	parent.frames[2].location.href = "../../eBL/jsp/BLDischClearGenerateBtn.jsp";	
	frm.search_button.value = "As On:"+dateTime;
	
	
	
}


async function PatientIdLookup()
	{	
		var pat_id=await PatientSearch();	
		
		var frm = document.forms[0];
		if( pat_id != null ){
			document.getElementById('patient_id').value = pat_id ;		
		}						
		else{
			frm.patient_id.value = '';
		}
}	

function callEpisodeDialog(episode_id){
	
	var frm = document.forms[0];
	var patient_id = frm.patient_id.value;
	var facility_id = document.forms[0].facility_id.value;
	var episode_id_value = episode_id.value;
	var qryParam = '&patient_id='+patient_id+'&episode_id='+episode_id+'&facility_id='+facility_id+'&target='+episode_id_value;
	
	
	var retVal				= new String();
	var dialogTop			= "40" ;
	var dialogHeight		= "10" ;
	var dialogWidth			= "40" ;
	var features			= "dialogTop:"+dialogTop+" dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +";status=no" ;
	var arguments			= "" ;
	var message				= "";
	
	var title = "Select Episode";		

	var column_sizes = escape("50%,50%");
		
	var column_descriptions = 'PATIENT ID'+','+'EPISODE ID';
	var sql="";			
	var param = "title="+title+"&"+"column_sizes="+column_sizes+"&"+"column_descriptions="+column_descriptions+"&col_show_hide=YY"+qryParam;
	
	var  retVal=window.showModalDialog("../../eBL/jsp/BLLookupMain.jsp?called_for=DISCCLEAR_HDR_EPISODE_LOOKUP&"+param,arguments,features);
	
	if (retVal != null && retVal!="" && retVal!="undefined" )
	{
		retVal=unescape(retVal);
		var arr=retVal.split("^~^");
		frm.episode_id.value = arr[1];
	}
    else{
		 frm.episode_id.value = '';
	}
	
}


function getNursingUnit(nursing_unit_desc,nursing_unit_code){
	
	var frm = document.forms[0];
	var nursing_unit_desc_val = frm.nursing_unit_desc.value;
	var nursing_unit_code_val = frm.nursing_unit_code.value;
	var facility_id = document.forms[0].facility_id.value;
	var target_val = '';

	if(nursing_unit_desc_val != "")
		target_val = nursing_unit_desc_val;
	else
		target_val = nursing_unit_code_val;
		
	var qryParam='&facility_id='+facility_id+'&nursing_unit_desc_val='+nursing_unit_desc_val+'&nursing_unit_code_val='+nursing_unit_code_val+'&target='+target_val;
	
	
	var retVal				= new String();
	var dialogTop			= "40";
	var dialogHeight		= "10" ;
	var dialogWidth			= "40" ;
	var features			= "dialogTop:"+dialogTop+"dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +";status=no" ;
	var arguments			= "" ;
	var message				="";
	
	var title = "Select Nursing Unit";		

	var column_sizes = escape("50%,50%");

	var column_descriptions = 'DESCRIPTION'+','+'CODE';
	var sql="";			
	var param = "title="+title+"&"+"column_sizes="+column_sizes+"&"+"column_descriptions="+column_descriptions+"&col_show_hide=YY"+qryParam;
	
	var  retVal=window.showModalDialog("../../eBL/jsp/BLLookupMain.jsp?called_for=DISCCLEAR_HDR_NURSINGUNIT_LOOKUP&"+param,arguments,features);
	
	if (retVal != null && retVal!="" && retVal!="undefined" )
	 {
		retVal=unescape(retVal);
		var arr=retVal.split("^~^");
		frm.nursing_unit_desc.value = arr[0];
		frm.nursing_unit_code.value = arr[1];
		  
	 }
	 else{
		frm.nursing_unit_desc.value = '';
		frm.nursing_unit_code.value = '';
	 }
}

function callAuthReasonDialog(codeDesc,sqlSelect){
	
	var frm = document.forms[0];
	var reason_code = frm.reason_code.value;
	var reason_value = frm.reason_value.value;
	var target_val = '';
	var column_descriptions = '';
	if(codeDesc == 1){
		target_val = reason_code;
		column_descriptions = 'CODE'+','+'DESCRIPTION';
	}else if(codeDesc == 2){
		target_val = reason_value;
		column_descriptions = 'DESCRIPTION'+','+'CODE';
	}
	var qryParam = '&reason_code='+reason_code+'&reason_value='+reason_value+'&target='+target_val+'&sqlSelect='+sqlSelect+'&codeDesc='+codeDesc;
	
	var retVal				= new String();
	var dialogTop			= "40";
	var dialogHeight		= "10" ;
	var dialogWidth			= "40" ;
	var features			= "dialogTop:"+dialogTop+"dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +";status=no" ;
	var arguments			= "" ;
	var message				="";
	
	var title = "Authentication Reason";		

	var column_sizes = escape("50%,50%");

	var sql="";			
	var param = "title="+title+"&"+"column_sizes="+column_sizes+"&"+"column_descriptions="+column_descriptions+"&col_show_hide=YY"+qryParam;
	
	var  retVal=window.showModalDialog("../../eBL/jsp/BLLookupMain.jsp?called_for=AUTH_REASON_LOOKUP&"+param,arguments,features);
	
	if (retVal != null && retVal!="" && retVal!="undefined" )
	 {
		retVal=unescape(retVal);
		var arr=retVal.split("^~^");
		if(codeDesc == 1){
		frm.reason_value.value = arr[1];
		frm.reason_code.value = arr[0];
		}else{
		frm.reason_value.value = arr[0];
		frm.reason_code.value = arr[1];
		}
		  
	 }
	 else{
		frm.reason_code.value = '';
		frm.reason_value.value = '';
	 }
	
}





function effFromDateValidation(obj, startDt, endDt){
	var locale = document.forms[0].locale.value; 
	if(obj.value != "") {
		var valid_status = validDateObj(obj,"DMY",locale);  
		
		if(valid_status == true || valid_status == "true"){
			valid_status = compareDates(startDt, endDt);
		}
	}	
}


function effToDateValidation(obj, startDt, endDt ){
	var locale = document.forms[0].locale.value;
	if(obj.value != "") {	
		var valid_status = validDateObj(obj,"DMY",locale);   
		if(valid_status == true){
			valid_status = compareDates(startDt, endDt)
		}	
	}
}

function compareDates(startDate, endDate) {
    var starr = startDate.value.split("/");
    var enarr = endDate.value.split("/");
	
	var startdt = new Date();
    var enddt = new Date();
	startdt.setFullYear(starr[2], starr[1] - 1, starr[0]);
    enddt.setFullYear(enarr[2], enarr[1] - 1, enarr[0]);
	
	if (startDate.value.length > 0 && endDate.value.length > 0) {
        if(startdt > enddt) {
            alert(getMessage('BL1344', 'BL'));
            endDate.value = '';
			return false;
        }
    }
	return true;
}

function clearCode(obj){
	obj.value='';
}

function fnclearCode(obj,code){
	obj.value='';
	code.value='';
}

function checkAuthorization(pat_id,doc_num,pat_outs_bill,ind){
	
	var frm = document.forms[0];
	var facility_id = frm.facility_id.value;
	var login_user = frm.login_user.value;
	var p_privilege_val = "";
	var p_window = "";
	frm.is_record_selected.value = "N";
	frm.valid_user_rec_found_YN.value = "N";

	var temp_jsp = "../jsp/BLCommonAjax.jsp?functionMode=getBLDischAuthWindowYN&facility_id="+facility_id+"&docNum="+doc_num+"&pat_outs_bill="+pat_outs_bill;
	var xmlHttp = new XMLHttpRequest();
	xmlHttp.open("POST", temp_jsp, false);
	xmlHttp.send();
	var retVal = trimString(xmlHttp.responseText);

	var retVal=unescape(retVal);
	
	var qryParam = '';
	var arr=new Array();
	if(retVal != null && retVal.length>0)
	{
		arr=retVal.split(":::");
		p_privilege_val = arr[0];
		p_window = arr[1];
	}
	if(p_window != 'null')
	{
		if(p_privilege_val == "N")
			login_user = "";
		
		qryParam = '&login_user='+login_user+'&p_window='+p_window+'&p_privilege_val='+p_privilege_val+'&doc_num='+doc_num+'&pat_outs_bill='+pat_outs_bill;
		var auth = 'Y';
		var retVal				= new String();
		var dialogHeight= "12" ;
		var dialogWidth	= "30" ;
		var dialogTop = "330" ;
		var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; dialogTop :" + dialogTop +"; status=no";
		var arguments			= "" ;
		var message				= "" ;
		var title = "";

		if(doc_num == "")
			title = getLabel("eBL.AuthForDischClearWithoutBill.label","BL"); 
		else if(doc_num != "" && pat_outs_bill <=0)			
			title = getLabel("eBL.AuthForDischClearWithBill.label","BL"); 
		else if(doc_num != "" && pat_outs_bill >0)
			title = getLabel("eBL.AuthForDischClearWithOutsBill.label","BL");
		
		var param = "title="+title+qryParam;
		
		var retVal=window.showModalDialog("../../eBL/jsp/BLDischClearAuthorise.jsp?"+param,arguments,features); 
		var retVal=unescape(retVal);
		var arr=new Array();
		if(retVal != null && retVal.length>0)
		{
			arr=retVal.split("~");
			
			if(arr[0]=="Y"){
				frm.is_record_selected.value = "Y";	
				frm.valid_user_rec_found_YN.value = arr[0];
				frm.userId.value = arr[1];
				frm.reasonCode.value = arr[2];
				frm.authRemarks.value = arr[3];
				frm.row_count.value = ind;
			}else{
				var x = document.getElementById("bl_disc_clear_count_"+ind);
				x.checked = false;
			}
		}	
	}else{
		if(p_privilege_val == "Y"){
			frm.is_record_selected.value = "Y";	
			frm.valid_user_rec_found_YN.value = arr[0];
			frm.row_count.value = ind;
		}
	}		
}

function confirmPasswdchk(){
	
	var frm = document.forms[0];
	var facility_id = frm.facility_id.value;

	var userID = frm.user_id.value;
	var pinNum = frm.passwd.value;
	var reasonCode = frm.reason_code.value;
	var remark = frm.remarks.value;
	var window_name = frm.window_name.value;
	var valid_user ="N";
		
	if(userID != "" && pinNum != "" && reasonCode != "" && remark != "")
	{
		var qryparam = userID+"~"+reasonCode+"~"+remark;
		var temp_jsp = "../jsp/BLCommonAjax.jsp?functionMode=getBLDischUserAuthYN&facility_id="+facility_id+"&userID="+userID+"&pinNum="+pinNum+"&reasonCode="+reasonCode+"&remark="+remark+"&window_name="+window_name;
		
		var xmlHttp = new XMLHttpRequest();
		xmlHttp.open("POST", temp_jsp, false);
		xmlHttp.send();
		var retVal = trimString(xmlHttp.responseText);
		
		if(retVal == "" || retVal == "null"){ 	
		   valid_user = "Y";
		   window.returnValue = valid_user+"~"+qryparam;
		   window.close();
		}else{
			alert(getMessage(retVal, 'BL'));
		}
	}else{
		alert(getMessage("ALL_MANDATORY_FIELDS", 'Common'));
	}
 	
}

function gen_disch_clearance(){
	
	var frmObj = document.forms[0];
		
	var frm = parent.frames[1].document;
	var facilityID = frm.getElementById('facility_id').value;
	var i = frm.getElementById('row_count').value;
	var rec_selected = frm.getElementById('is_record_selected').value;
	var vadid_user = frm.getElementById('valid_user_rec_found_YN').value;
	if(rec_selected == "Y" && vadid_user == "Y")
	{
		
	var episodeType = frm.getElementById('episodeType_'+i).value;
	var patId = frm.getElementById('patientId_'+i).value;
	var episodeId = frm.getElementById('episodeId_'+i).value;
	var encounterId = frm.getElementById('encounterId_'+i).value;
	var acctSeqNo = frm.getElementById('acctSeqNo_'+i).value;
	var admissionDt = frm.getElementById('admissionDt_'+i).value;
	var curWardCode = frm.getElementById('curWardCode_'+i).value;
	var curBedClass = frm.getElementById('curBedClassCode_'+i).value;
	var curRoomNum = frm.getElementById('curRoomNum_'+i).value;
	var curBedNum = frm.getElementById('curBedNum_'+i).value;
	var curPhysicianId = frm.getElementById('curPhysicianId_'+i).value;
	var dischBillDocType = frm.getElementById('docType_'+i).value;
	var dischBillDocNum = frm.getElementById('docNumber_'+i).value;
	var dischBillDtTime = frm.getElementById('discAdviceAtTo_'+i).value;
	var patOutstAmt = frm.getElementById('patOutsAmt_'+i).value;
	
	var reasonCode = frm.getElementById('reasonCode').value;
	var userId = frm.getElementById('userId').value;
	var authRemarks = frm.getElementById('authRemarks').value; 
		
	frmObj.episodeType.value = episodeType;
	frmObj.patientId.value = patId;
	frmObj.episodeId.value = episodeId;
	frmObj.encounterId.value = encounterId;
	frmObj.acctSeqNo.value = acctSeqNo;
	frmObj.admissionDt.value = admissionDt;
	frmObj.curWardCode.value = curWardCode;
	frmObj.curBedClassCode.value = curBedClass;
	frmObj.curRoomNum.value = curRoomNum;
	frmObj.curBedNum.value = curBedNum;
	frmObj.curPhysicianId.value = curPhysicianId;
	frmObj.docType.value = dischBillDocType;
	frmObj.docNumber.value = dischBillDocNum;
	frmObj.discAdviceAtTo.value = dischBillDtTime;
	frmObj.patOutsAmt.value = patOutstAmt;
	frmObj.reasonCode.value = reasonCode;
	frmObj.userId.value = userId;
	frmObj.authRemarks.value = authRemarks;
		
	frmObj.target = 'messageFrame';
	frmObj.method = "post";
	frmObj.action = "../../servlet/eBL.BLDischClearanceGenerateMasterServlet";
	frmObj.submit();  
	}else if(rec_selected == "Y" && vadid_user == "N"){
		alert(getMessage('BL9539', 'BL'));
	}else{
		alert(getMessage('BL6334', 'BLEXT'));
	}
}

function prevbtn(){
	
	var frm = parent.frames[1].document;
	var i = frm.getElementById('row_count').value;
	var rec_selected = frm.getElementById('is_record_selected').value;
	var facilityID = frm.getElementById('facility_id').value;
	var locale = frm.getElementById('locale').value;
	var patientId = frm.getElementById('patientId').value; 
	var nursingUnitCode = frm.getElementById('nursingUnitCode').value;
	var episodeId = frm.getElementById('episodeId').value;
	var discAdviceDtFrom = frm.getElementById('discAdviceDtFrom').value;
	var discAdviceAtTo = frm.getElementById('discAdviceAtTo').value;
	var option_val = frm.getElementById('option_val').value;
	var from_prev = frm.getElementById('from_prev').value;
	var to_prev = frm.getElementById('to_prev').value;
	var total_rec = frm.getElementById('total_rec').value;
	var retVal = "Y";
	
	if(rec_selected=="Y"){
		retVal = "Selected record will be cleared, do you want to continue ?";
		if (confirm(retVal) == true) {
			retVal = "Y";
		} else {
			retVal = "N";
		}
	}
	
	if(retVal=="Y"){
		location.href = "../../eBL/jsp/BLDischClearGenerateResult.jsp?facility_id="+facilityID+"&locale="+locale+"&patient_id="+patientId+"&nursing_unit="+nursingUnitCode+"&episode_id="+episodeId+"&disc_advice_dt_from="+discAdviceDtFrom+"&disc_advise_dt_to="+discAdviceAtTo+"&option_val="+option_val+"&from="+from_prev+"&to="+to_prev+"&total_rec="+total_rec ;
	}	
}

function nextbtn(){
	
	var frm = parent.frames[1].document;
	var i = frm.getElementById('row_count').value;
	var rec_selected = frm.getElementById('is_record_selected').value;
	var facilityID = frm.getElementById('facility_id').value;
	var locale = frm.getElementById('locale').value;
	var patientId = frm.getElementById('patientId').value; 
	var nursingUnitCode = frm.getElementById('nursingUnitCode').value;
	var episodeId = frm.getElementById('episodeId').value;
	var discAdviceDtFrom = frm.getElementById('discAdviceDtFrom').value;
	var discAdviceAtTo = frm.getElementById('discAdviceAtTo').value;
	var option_val = frm.getElementById('option_val').value;
	var from_next = frm.getElementById('from_next').value;
	var to_next = frm.getElementById('to_next').value;
	var total_rec = frm.getElementById('total_rec').value;
	var retVal = "Y";
	
	if(rec_selected=="Y"){
		retVal = "Selected record will be cleared, do you want to continue ?";
		if (confirm(retVal) == true) {
			retVal = "Y";
		} else {
			retVal = "N";
		}
	}
	
	if(retVal=="Y"){
		location.href = "../../eBL/jsp/BLDischClearGenerateResult.jsp?facility_id="+facilityID+"&locale="+locale+"&patient_id="+patientId+"&nursing_unit="+nursingUnitCode+"&episode_id="+episodeId+"&disc_advice_dt_from="+discAdviceDtFrom+"&disc_advise_dt_to="+discAdviceAtTo+"&option_val="+option_val+"&from="+from_next+"&to="+to_next+"&total_rec="+total_rec ;
		
	}	
}

function cancelRecord(){
	var valid_user = 'N';
	window.returnValue = valid_user;
	window.close(); 
}

function fnShowMainTabDetails(object){
	link = object;
	if (link == "GenDiscClearance"){
		changeMainTabClass(link, parent.BLDischClearTabs);
		parent.frames[1].location.href="../../eBL/jsp/BLDischClearGenerateFrameSet.jsp";
		document.forms[0].last_link.value = link;
	}else if(link == 'CancelDiscClearance'){
		changeMainTabClass(link, parent.BLDischClearTabs);		
		parent.frames[1].location.href="../../eBL/jsp/BLDischClearCancelFrameSet.jsp";
		document.forms[0].last_link.value = link;
	}
}

function changeMainTabClass(tabObj, tabFrame) {
	
	if (tabFrame.document.forms[0] != null) {
		prevTabObj = tabFrame.document.forms[0].prevTabObj.value;
		if (prevTabObj != null && prevTabObj != "") {
			eval(tabFrame.document.getElementById('prevTabObj')).className = "tabA"
			eval(tabFrame.document.getElementById('prevTabObj') + "span").className = "tabAspan"
		}
		eval(tabFrame.document.getElementById('tabObj')).className = "tabClicked"
		eval(tabFrame.document.getElementById('tabObj') + "span").className = "tabSpanclicked"
		tabFrame.document.forms[0].prevTabObj.value = tabObj
	}
}




