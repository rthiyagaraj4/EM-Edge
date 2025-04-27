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

function cancel_disch_clearance_reultset(){
	
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
	
	parent.frames[1].location.href="../../eBL/jsp/BLDischClearCancelQueryResult.jsp?patient_id="+patient_id+"&nursing_unit="+nursing_unit+"&episode_id="+episode_id+"&disc_advice_dt_from="+disc_advice_dt_from+"&disc_advise_dt_to="+disc_advise_dt_to+"&option_val="+option_val;
	
	parent.frames[2].location.href = "../../eBL/jsp/BLDischClearCancelBtn.jsp";	
	frm.search_button.value = "As On:"+dateTime;

}

function checkAuthorization(pat_id,episode_id,episode_type,ind){
	
	var frm = document.forms[0];
	var facility_id = frm.facility_id.value;
	var login_user = frm.login_user.value;
	var p_privilege_val = "";
	var p_window = "";
	frm.is_record_selected.value = "N";
	frm.valid_user_rec_found_YN.value = "N";

	var temp_jsp = "../jsp/BLCommonAjax.jsp?functionMode=getBLDischCancelClearAuthWindowYN&facility_id="+facility_id+"&patientId="+pat_id+"&episode_id="+episode_id+"&episode_type="+episode_type;
	var xmlHttp = new XMLHttpRequest();
	xmlHttp.open("POST", temp_jsp, false);
	xmlHttp.send();
	var retVal = trimString(xmlHttp.responseText);
	
	var retVal=unescape(retVal);
	var qryParam = '';
	
	if(retVal == "N")
			login_user = "";
		
	if(retVal == "BL7489"){
		alert(getMessage("BL7489","BLEXT"));
		var x = document.getElementById("bl_disc_clear_count_"+ind);
		x.checked = false;
		return false;
	}		
		
	qryParam = '&login_user='+login_user+'&p_window='+p_window;
	var auth = 'Y';
	var retVal = new String();
	var dialogHeight= "12" ;
	var dialogWidth	= "30" ;
	var dialogTop = "330" ;
	var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; dialogTop :" + dialogTop +"; status=no";
	var arguments			= "" ;
	var message				= "" ;

	var title = getLabel("eBL.AuthToCancelDischClear.label","BL"); 

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
}

function cancelClearanceConfirmPasswdchk(){
	
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
		var temp_jsp = "../jsp/BLCommonAjax.jsp?functionMode=getBLDischCancelClearUserAuthYN&facility_id="+facility_id+"&userID="+userID+"&pinNum="+pinNum+"&reasonCode="+reasonCode+"&remark="+remark+"&window_name="+window_name;
		
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

function cancelClearanceCancelRecord(){
	var valid_user = 'N';
	window.returnValue = valid_user;
	window.close(); 
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
		location.href = "../../eBL/jsp/BLDischClearCancelQueryResult.jsp?facility_id="+facilityID+"&locale="+locale+"&patient_id="+patientId+"&nursing_unit="+nursingUnitCode+"&episode_id="+episodeId+"&disc_advice_dt_from="+discAdviceDtFrom+"&disc_advise_dt_to="+discAdviceAtTo+"&option_val="+option_val+"&from="+from_prev+"&to="+to_prev+"&total_rec="+total_rec ;
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
		location.href = "../../eBL/jsp/BLDischClearCancelQueryResult.jsp?facility_id="+facilityID+"&locale="+locale+"&patient_id="+patientId+"&nursing_unit="+nursingUnitCode+"&episode_id="+episodeId+"&disc_advice_dt_from="+discAdviceDtFrom+"&disc_advise_dt_to="+discAdviceAtTo+"&option_val="+option_val+"&from="+from_next+"&to="+to_next+"&total_rec="+total_rec ;
		
	}	
}



function cancel_disch_clearance(){

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
	var dischBillDocType = frm.getElementById('docType_'+i).value;
	var dischBillDocNum = frm.getElementById('docNumber_'+i).value;
	var reasonCode = frm.getElementById('reasonCode').value;
	var userId = frm.getElementById('userId').value;
	var authRemarks = frm.getElementById('authRemarks').value; 
		
	frmObj.episodeType.value = episodeType;
	frmObj.patientId.value = patId;
	frmObj.episodeId.value = episodeId;
	frmObj.docType.value = dischBillDocType;
	frmObj.docNumber.value = dischBillDocNum;
	frmObj.reasonCode.value = reasonCode;
	frmObj.userId.value = userId;
	frmObj.authRemarks.value = authRemarks;
	
	frmObj.target = 'messageFrame';
	frmObj.method = "post";
	frmObj.action = "../../servlet/eBL.BLDischClearanceCancelMasterServlet";
	frmObj.submit();  
	}else if(rec_selected == "Y" && vadid_user == "N"){
		alert(getMessage('BL9539', 'BL'));
	}else{
		alert(getMessage("BL6334", "BLEXT"));
	}
}

function cancelClearanceReprint(docType,docNumber,episodeId,episodeType,billDocTypeCode,billDocNumber){
	
	var qryParam = '&docType='+docType+'&docNumber='+docNumber+'&episodeId='+episodeId+'&episodeType='+episodeType+'&billDocTypeCode='+billDocTypeCode+'&billDocNum='+billDocNumber;
	var retVal = new String();
	var dialogHeight= "12" ;
	var dialogWidth	= "30" ;
	var dialogTop = "330" ;
	var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; dialogTop :" + dialogTop +"; status=no";
	var arguments			= "" ;
	var message				= "" ;

	var title = getLabel("eBL.ReprintDischClearBill.label","BL"); 
	
	var param = "title="+title+qryParam;
	
	var retVal=window.showModalDialog("../../eBL/jsp/BLDischClearCancelReprint.jsp?"+param,arguments,features); 
	
}

function reprint(){
	var frm = document.forms[0];
	var option_type = frm.option_type.value;
	
	if(option_type == 'D')
		dischClearReprint();
	else if(option_type == 'B')
		billReprint();
	else{
		dischClearReprint();
		billReprint();
	}
		
	
}

function dischClearReprint(){
	
	var frm = document.forms[0];
	var docType = frm.docType.value;
	var docNumber = frm.docNumber.value;
	var p_facility_id = frm.facility_id.value;
	var locale = frm.locale.value;
	var login_user = '';
	var episodeId = frm.episodeId.value;
	var episodeType = frm.episodeType.value;
	var detailed_yn = "Y";
	var reportId = "BLRDISCL";
	var module_id = "BL";
	var session_id = '';
	var pgm_date = '';	
	var app_server_ip =''; 
	var copies = '';
	var rep_server_key = '';
	var url = "" ;
	var reportserver = '';
	var userid = '';
	var report_option = "P";
	var message = "";
	
	var temp_jsp = "../jsp/BLCommonAjax.jsp?functionMode=ReprintReport&p_report_id="+reportId+"&param1="+docType+"&param2="+docNumber+
				"&param3="+docNumber+"&param4="+docNumber+"&param5="+"&param6="+detailed_yn+"&param7="+"R"+"&param8="+locale+
				"&param9="+
				"&param10="+				
				"&param11="+
				"&param12="+
				"&param13="+episodeId+
				"&param14="+episodeType;
		
	var xmlHttp = new XMLHttpRequest();
	xmlHttp.open("POST", temp_jsp, false);
	xmlHttp.send();
	var retVal = trimString(xmlHttp.responseText);
	
	var arr=new Array();
	arr = retVal.split(":::");
	session_id = trimString(arr[0]);
	pgm_date = trimString(arr[1]);
	
	var temp_jsp = "../jsp/BLCommonAjax.jsp?functionMode=ReprintReportValue&p_report_id="+reportId+"&reportOption="+report_option+"&module_id="+module_id;
	var xmlHttp = new XMLHttpRequest();
	xmlHttp.open("POST", temp_jsp, false);
	xmlHttp.send();
	var retVal = trimString(xmlHttp.responseText);		
	var arr=new Array();
	arr = retVal.split(":::");
	report = trimString(arr[0]);
	server = trimString(arr[1]);
	copies = trimString(arr[2]);
	app_server_ip = trimString(arr[3]);
    rep_server_key = trimString(arr[4]);
    reportserver = trimString(arr[5]);
    login_user = trimString(arr[6]);
    message = trimString(arr[7]);
   
    if(message != ""){
    	alert(message);
    	return false;
    }
    userid = "userid"+"="+login_user;
    login_user = encodeURIComponent(userid); 
	
	var params		= "&P_PGM_ID="+reportId+"&P_PGM_DATE="+pgm_date+"&P_OPERATING_FACILITY_ID="+p_facility_id+"&P_SESSION_ID="+session_id+"&P_DOC_TYPE_CODE="+docType+"&P_DOC_NUM="+docNumber;
	var regExp = /&/g ;
	params = params.replace( regExp, "+" ) ; 
			
	var myRegExp = /\\/g ;
	var desformat = "PDF";
	var destype	= "CACHE";
	
	params=params.toUpperCase();
	var report = reportId;
	url = reportserver+"?server="+server+"+report="+reportId+"+"+ login_user+"+p_language_id="+locale+"+DESTYPE="+destype+"+PARAMFORM=NO"+"+P_FACILITY_ID="+p_facility_id+"+DESFORMAT="+desformat+"+RECURSIVE_LOAD=NO"+"+MAXIMIZE=YES"	;
	url=url+params;	
	var myBars 		= 'directories=no,location=no,menubar=no' ;
	var myOptions 	= 'width=1500px !important, height=750px !important, resizable=yes' ; 
	var myFeatures 	= myBars + ', ' + myOptions ;
	var reportWindow 	= open( url, '_blank', myFeatures ) ;
	window.close();
	
}

function billReprint(){
	
	var frm = document.forms[0];
	var docType = frm.docType.value;
	var docNumber = frm.docNumber.value;
	var p_facility_id = frm.facility_id.value;
	var locale = frm.locale.value;
	var login_user = '';
	var billDocTypeCode = frm.billDocTypeCode.value;
	var billDocNum = frm.billDocNum.value;
	var episodeId = frm.episodeId.value;
	var episodeType = frm.episodeType.value;
	var detailed_yn = "N";
	var detailed_yn1 = "Y";
	var reportId = "BLRBLPRT";
	var module_id = "BL";
	var session_id = '';
	var pgm_date = '';	
	var app_server_ip =''; 
	var copies = '';
	var rep_server_key = '';
	var url = "" ;
	var reportserver = '';
	var userid = '';
	var report_option = "P";
	var message = "";
	if(billDocTypeCode == "null" || billDocNum == "null"){
		alert(getMessage("BL0974","BLEXT"));
		return false;
	}
	
	
	var temp_jsp = "../jsp/BLCommonAjax.jsp?functionMode=ReprintReport&p_report_id="+reportId+"&param1="+billDocTypeCode+"&param2="+billDocTypeCode+
				"&param3="+billDocNum+"&param4="+billDocNum+"&param5="+"&param6="+detailed_yn+"&param7="+"R"+"&param8="+locale+
				"&param9="+
				"&param10="+				
				"&param11="+
				"&param12="+
				"&param13="+
				"&param14="+episodeType+
				"&param15="+episodeId;
		
	var xmlHttp = new XMLHttpRequest();
	xmlHttp.open("POST", temp_jsp, false);
	xmlHttp.send();
	var retVal = trimString(xmlHttp.responseText);
	var arr=new Array();
	arr = retVal.split(":::");
	session_id = trimString(arr[0]);
	pgm_date = trimString(arr[1]);
	
	var temp_jsp = "../jsp/BLCommonAjax.jsp?functionMode=ReprintReportValue&p_report_id="+reportId+"&reportOption="+report_option+"&module_id="+module_id+"&dest_locn_type=&dischBillDocNum="+billDocNum;
	var xmlHttp = new XMLHttpRequest();
	xmlHttp.open("POST", temp_jsp, false);
	xmlHttp.send();
	var retVal = trimString(xmlHttp.responseText);		
	var arr=new Array();
	arr = retVal.split(":::");
	report = trimString(arr[0]);
	server = trimString(arr[1]);
	copies = trimString(arr[2]);
	app_server_ip = trimString(arr[3]);
    rep_server_key = trimString(arr[4]);
    reportserver = trimString(arr[5]);
    login_user = trimString(arr[6]);
    message = trimString(arr[7]);
    
    if(message != ""){
    	alert(message);
    	return false;
    }
    
    
    userid = "userid"+"="+login_user;
    login_user = encodeURIComponent(userid); 
	
	var params		= "+P_PGM_ID="+reportId+"+P_PGM_DATE="+pgm_date+"+P_OPERATING_FACILITY_ID="+p_facility_id+"+P_SESSION_ID="+session_id;
	var regExp = /&/g ;
	params = params.replace( regExp, "+" ) ; 
			
	var myRegExp = /\\/g ;
	var desformat = "PDF";
	var destype	= "CACHE";
	
	params=params.toUpperCase();
	var report = reportId;

	url = reportserver+"?server="+server+"+report="+reportId+"+"+login_user+"+P_LANGUAGE_ID="+locale+"+DESTYPE="+destype+"+PARAMFORM=NO+DESFORMAT="+desformat+
	"+RECURSIVE_LOAD=NO+P_FACILITY_ID="+p_facility_id+"+P_REPORT_ID="+reportId+"+P_MODULE_ID="+module_id+"+P_PGM_ID="+reportId+"+P_PRT_DIG_STAMP=N+P_LANGUAGE_ID="+locale;
	url=url+params;	
	var myBars 		= 'directories=no,location=no,menubar=no' ;
	var myOptions 	= 'width=1500px !important, height=750px !important, resizable=yes' ; 
	var myFeatures 	= myBars + ', ' + myOptions ;
	var reportWindow 	= open( url, '_blank', myFeatures ) ;
	window.close();

}


function cancelReprint(){
	var cancel_reprint = 'N';
	window.returnValue = cancel_reprint;
	window.close();
}
