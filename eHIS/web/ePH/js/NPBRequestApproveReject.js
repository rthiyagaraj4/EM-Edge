function query(){
	
	f_query_criteria.location.href="../../ePH/jsp/NPBRequestApproveRejectQueryCriteria.jsp";
	f_query_result.location.href="../../eCommon/html/blank.html";
}

function reset()	{
	if(f_query_criteria){
		f_query_criteria.document.NPBRequestQueryCriteria.reset();
		f_query_result.location.href="../../eCommon/html/blank.html";
			
	}
}

function fieldValidation(xmlStr,source){
	var xmlDoc = "" ;
    var xmlHttp = new XMLHttpRequest() ;
    xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
    xmlHttp.open("POST","NPBRequestApproveRejectValidate.jsp?func_mode="+source,false);	
    xmlHttp.send(xmlDoc);
    responseText=xmlHttp.responseText ;
	eval(responseText);
    return true;
}
async function callPatientSearch(){		
	var patient_id=await PatientSearch();
	if(patient_id!=null && patient_id!='undefined'&& patient_id!=""){
		parent.f_query_criteria.document.NPBRequestQueryCriteria.patient_id.value=patient_id;
	}	
}

async function searchPractioner(){
	
	var argumentArray  = new Array() ;
	var dataNameArray  = new Array() ;
	var dataValueArray = new Array() ;
	var dataTypeArray  = new Array() ;

	var formObj		   = parent.f_query_criteria.document.NPBRequestQueryCriteria;	
	formObj.req_pract_name.value="";
	argumentArray[0]   = formObj.SQL_SELECT_PRACT.value;
	argumentArray[1]   = dataNameArray ;
	argumentArray[2]   = dataValueArray ;
	argumentArray[3]   = dataTypeArray ;
	argumentArray[4]   = "1,2";
	argumentArray[5]   = formObj.req_pract_name.value ;
	argumentArray[6]   = DESC_LINK ;
	argumentArray[7]   = DESC_CODE ; 	
	retVal = await CommonLookup( getLabel("Common.practitioner.label","Common"), argumentArray );	
	var ret1=unescape(retVal);
		 	var arr=ret1.split(",");
		 	if(arr[1]==undefined) 
	 		{
		 		arr[0]="";	
		 		arr[1]="";	
	 		}
	if(retVal != null && retVal != "" )  {
		formObj.req_pract_name.value = arr[1] ;
		formObj.req_pract_id.value = arr[0];
	}
}

function ValidateFromDate(obj, curr_date, locale){
	fr_dt = document.NPBRequestQueryCriteria.dt_to;
	if(obj.value!=""){
		if(!checkDt(obj)){ 
			alert(getMessage("INVALID_DATE_TIME","PH"));
			obj.value="";
			obj.select();
			return false;
		}
		if (fr_dt.value!=""){
			if(!ValidateDate(obj,fr_dt)) { 
				alert(getMessage("TO_DT_GR_EQ_FM_DT","PH"));
				obj.value="";
				obj.select();
				return false;
			}
		}
		if(!isBefore(obj.value,curr_date, "DMY",locale)){
			alert(getMessage("FROM_DATE_LESS_THAN_SYSDATE", "PH"));
			obj.value="";
			obj.focus();
			return false;
		}
	}
}
function ValidateToDate(obj, curr_date, locale){
	fr_dt = document.NPBRequestQueryCriteria.dt_from;
	if(obj.value!=""){
		if(!checkDt(obj)){
			alert(getMessage("INVALID_DATE_TIME","PH"));
			obj.value="";
			 obj.select();
			return false;
		}
		else
			if (fr_dt.value!=""){
				if(!ValidateDate(fr_dt,obj)){
				alert(getMessage("TO_DT_GR_EQ_FM_DT","PH"));
				obj.value="";
				obj.select();
				return false;
			}
		}
		if(!isBefore(obj.value,curr_date, "DMY",locale)){
			alert(getMessage("TO_DATE_LESS_THAN_SYSDATE", "PH"));
			obj.value="";
			obj.focus();
			return false;
		}
	}
	return true;
}
function ValidateValidityDate(obj, curr_date, locale){
	if(obj.value!=""){
		if(!checkDt(obj)){ 
			alert(getMessage("INVALID_DATE_TIME","PH"));
			obj.value="";
			obj.select();
			return false;
		}
		if(!isAfter(obj.value,curr_date, "DMY",locale)){
			alert(getMessage("VALIDITY_DATE_LESS_SYSDATE", "PH"));
			obj.value="";
			obj.focus();
			return false;
		}
	}
}

function searchNPBReq(){
	var formObj=document.NPBRequestQueryCriteria;
	var fields = new Array (formObj.dt_from, formObj.dt_to );
	var names = new Array (getLabel("Common.requesteddate.label","Common")+getLabel("Common.from.label","Common"), getLabel("Common.requesteddate.label","Common")+getLabel("Common.to.label","Common"));
	messageFrame=top.content.messageFrame;
	if(checkFields( fields, names, messageFrame)){
		var bean_id = formObj.bean_id.value;
		var bean_name = formObj.bean_name.value;
		var patient_id = formObj.patient_id.value;
		var req_pract_id = formObj.req_pract_id.value;
		var reqFromDate = formObj.dt_from.value;
		var reqToDate = formObj.dt_to.value;
		var drugName = formObj.DrugName.value;
		var drugCode = formObj.DrugCode.value;
		var reqStatus = formObj.reqStatus.value;
		parent.f_query_result.location.href = "../../ePH/jsp/NPBRequestApproveRejectQueryResult.jsp?bean_id="+bean_id+"&bean_name="+bean_name+"&patient_id="+patient_id+"&reqFromDate="+reqFromDate+"&reqToDate="+reqToDate+"&drugName="+drugName+"&drugCode="+drugCode+"&reqStatus="+reqStatus+"&req_pract_id="+req_pract_id;
		top.content.messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num=";
	}
}

async function searchDrugName(){
	var formObj=document.NPBRequestQueryCriteria;
	locale = formObj.locale.value;
	var argumentArray  = new Array() ;
	var dataNameArray  = new Array() ;
	var dataValueArray = new Array() ;
	var dataTypeArray  = new Array() ;
	var SQL_PH_SELECT_NPB_DRUG_LOOKUP="SELECT  drug_code code, drug_desc description FROM ph_drug_vw_lang_vw WHERE NPB_DRUG_YN ='Y' and  LANG1 ='"+locale+"' AND DECODE(LANG2,NULL,'"+locale+"',LANG2)= '"+locale+"' AND  DECODE(LANG3,NULL,'"+locale+"',LANG3)= '"+locale+"' AND UPPER (drug_code) LIKE UPPER (?) AND UPPER (drug_desc) LIKE UPPER (?)  ORDER BY 2"; 

	argumentArray[0]   = SQL_PH_SELECT_NPB_DRUG_LOOKUP;
	argumentArray[1]   = dataNameArray ;
	argumentArray[2]   = dataValueArray ;
	argumentArray[3]   = dataTypeArray ;
	argumentArray[4]   = "1,2";
	argumentArray[5]   = formObj.DrugName.value ;
	argumentArray[6]   = DESC_LINK ;
	argumentArray[7]   = DESC_CODE ; 	
	
	retVal = await CommonLookup( getLabel("Common.Drug.label","Common"), argumentArray );
	var ret1=unescape(retVal);
		 	var arr=ret1.split(",");
		 	if(arr[1]==undefined) 
	 		{
		 		arr[0]="";	
		 		arr[1]="";	
	 		}	
	formObj.DrugCode.value = "";
	
	if(retVal != null && retVal != "" )  {
		formObj.DrugName.value = arr[1];
		formObj.DrugCode.value = arr[0];
	}
}

async function searchDrugNameCLP(index){
	var formObj=document.NPBRequestQueryResult;
	locale = formObj.locale.value;
	var argumentArray  = new Array() ;
	var dataNameArray  = new Array() ;
	var dataValueArray = new Array() ;
	var dataTypeArray  = new Array() ;
	var SQL_PH_SELECT_NPB_DRUG_LOOKUP="SELECT  drug_code code, drug_desc description FROM ph_drug_vw_lang_vw WHERE NPB_DRUG_YN ='Y' and  LANG1 ='"+locale+"' AND DECODE(LANG2,NULL,'"+locale+"',LANG2)= '"+locale+"' AND  DECODE(LANG3,NULL,'"+locale+"',LANG3)= '"+locale+"' AND UPPER (drug_code) LIKE UPPER (?) AND UPPER (drug_desc) LIKE UPPER (?)  ORDER BY 2"; 

	//argumentArray[0]   = formObj.SQL_PH_SELECT_NPB_DRUG_LOOKUP.value;
	argumentArray[0]   = SQL_PH_SELECT_NPB_DRUG_LOOKUP;
	argumentArray[1]   = dataNameArray ;
	argumentArray[2]   = dataValueArray ;
	argumentArray[3]   = dataTypeArray ;
	argumentArray[4]   = "1,2";
	argumentArray[5]   = eval('formObj.request_drug_code_'+index).value ;
	argumentArray[6]   = DESC_LINK ;
	argumentArray[7]   = DESC_CODE ; 	
	retVal = await CommonLookup( getLabel("Common.Drug.label","Common"), argumentArray );	
	eval('formObj.request_drug_code_'+index).value.value="";
	var ret1=unescape(retVal);
		 	var arr=ret1.split(",");
		 	if(arr[1]==undefined) 
	 		{
		 		arr[0]="";	
		 		arr[1]="";	
	 		}
	
	if(retVal != null && retVal != "" )  {
		eval('formObj.RequestDrugName_'+index).innerHTML = arr[1] ;
		eval('formObj.approved_drug_code_'+index).value = arr[0];
		eval('formObj.request_drug_name_'+index).value = arr[1];
		eval('formObj.request_drug_code_'+index).value = arr[0];
	}
}

function selectRec(index){
	var formObj = document.NPBRequestQueryResult;
	var regStatus = eval("formObj.ReqAction_"+index).value;
	var selectYN = eval("formObj.select_"+index);
	if(selectYN.checked == true){
		eval("formObj.ReqActionMand_"+index).style.visibility='visible';
		if(regStatus=='' || regStatus == 'J'){
			if(regStatus=='J')
				eval("formObj.remarksMand_"+index).style.visibility='visible';
			eval("formObj.validityDateMand_"+index).style.visibility='hidden';
			eval("formObj.reqDrugCodeMand_"+index).style.visibility='hidden';
		}
		else{
			eval("formObj.validityDateMand_"+index).style.visibility='hidden';//changed to hidden for Adhoc testing ICN_ADHOC_021
			eval("formObj.remarksMand_"+index).style.visibility='hidden';
			if( regStatus == 'P'){
				eval("formObj.reqDrugCodeMand_"+index).style.visibility='visible';
			    	eval("formObj.validityDateMand_"+index).style.visibility='visible';//added for Adhoc testing ICN_ADHOC_021
			}
			//else
				//eval("formObj.all.reqDrugCodeMand_"+index).style.visibility='hidden';
		}
	}
	else{
		eval("formObj.ReqAction_"+index).value = "";
		eval("formObj.ReqActionMand_"+index).style.visibility='hidden';
		eval("formObj.validityDateMand_"+index).style.visibility='hidden';
		eval("formObj.remarksMand_"+index).style.visibility='hidden';
		eval("formObj.reqDrugCodeMand_"+index).style.visibility='hidden';
	}
}
async function openNPBFormPreview(index){	
	var formObj = document.NPBRequestQueryResult;
	//var NPBReqFormText			= eval("formObj.request_form_content_"+index).value;
	var request_status			= eval("formObj.request_status_"+index).value;
	var request_no			= eval("formObj.request_no_"+index).value;
	var bean_id			= formObj.bean_id.value ;
	var bean_name	    = formObj.bean_name.value ;	
	var dialogHeight		= '85vh';
	var dialogWidth			= '80vw';
	var dialogTop			= '250';
	var dialogLeft			= '25' ;
	var title				= ''
	var	arguments			= "";	
	var	features			= 'dialogHeight:' + dialogHeight + '; dialogWidth:' + dialogWidth + ';dialogTop:'+dialogTop+';dialogLeft:'+dialogLeft+';dialogTitle:'+title+'; scroll=yes; status=no';
	var retVals				=  await top.window.showModalDialog("../../ePH/jsp/NPBRequestFormPreviewFrame.jsp?bean_id="+bean_id+"&bean_name="+bean_name+"&request_status="+request_status+"&request_no="+request_no+"&mode=2&index="+index+"&calledFrom=APPRV",arguments,features); 		  
}

function ActionChange(index){
	var formObj = document.NPBRequestQueryResult;
	var regStatus = eval("formObj.ReqAction_"+index).value;
	if(regStatus=='' || regStatus == 'J'){
		if(regStatus=='J')
			eval("formObj.remarksMand_"+index).style.visibility='visible';
		eval("formObj.validityDateMand_"+index).style.visibility='hidden';
		eval("formObj.reqDrugCodeMand_"+index).style.visibility='hidden';
	}
	else{
		eval("formObj.validityDateMand_"+index).style.visibility='hidden';//changed to hidden for Adhoc testing ICN_ADHOC_021
		eval("formObj.remarksMand_"+index).style.visibility='hidden';
		if( regStatus == 'P'){
			eval("formObj.reqDrugCodeMand_"+index).style.visibility='visible';
		    	eval("formObj.validityDateMand_"+index).style.visibility='visible';//added for Adhoc testing ICN_ADHOC_021
		}
		//else
			//eval("formObj.all.reqDrugCodeMand_"+index).style.visibility='hidden';
	}
}
	
function apply(){
	var formObj=f_query_result.document.NPBRequestQueryResult;	
	messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num=";
	if(checkMandFields( )){
		storeChangedValues();
		eval(formApply(formObj,PH_CONTROLLER));
		messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num="+ message;	
		if( result ){
			onSuccess();
			homePage = f_query_criteria.document.NPBRequestQueryCriteria.homepage.value;//Added for  Bru-HIMS-CRF-073.1 [IN:047222]
			if(homePage=='Y'){ //Added for  Bru-HIMS-CRF-073.1 [IN:047222]
				parent.menuFrame.location.reload();
			}
		 }
	}
}

function checkMandFields(){
	var formObj=f_query_result.document.NPBRequestQueryResult;	
	var totalRec=0;//added for ICN_ADHOC_029 start
	if(formObj!=null && formObj!=undefined)//added for ICN_ADHOC_029 end
		totalRec = parseInt(formObj.totalRec.value);
	var reqAction ="", selectedYN="", NPBRemarks="", validityDate="";
	var recSelected = false;
	for(index=0; index<totalRec; index++){
		selectedYN = eval("formObj.select_"+index);
		if(selectedYN.checked == true){
			recSelected = true;
			reqAction = eval("formObj.ReqAction_"+index).value;
			if(reqAction==""){
					alert(getMessage("PH_SELECT_NPB_REQ_APPR_REJ_BLANK","PH"));
					return false;
			}
			if(reqAction == "J"){
				NPBRemarks = eval("formObj.request_rej_reason_"+index).value;
				if(NPBRemarks == ""){
					alert(getMessage("PH_SELECT_NPB_REQ_REJ_REMARKS_BLANK","PH"));
					return false;
				}
			}
			else if(reqAction=="P"){ //reqAction == "A" || 
				validityDate =eval("formObj.validityDate_"+index).value;
				approved_drug_code = eval("formObj.approved_drug_code_"+index).value;
				if(validityDate==""){
					msg = getMessage("PH_SELECT_NPB_REQ_VALIDUPTO_BLANK","PH");
					alert(msg);
					return false;
				}
				if(approved_drug_code=="" && reqAction=="P"){
					msg = getMessage("CAN_NOT_BE_BLANK","Common");
					msg = msg.replace('$', getLabel("Common.DrugCode.label","Common"));
					alert(msg);
					return false;
				}
			}
		}
	}
	if(!recSelected){
		alert(getMessage("PH_NO_CHANGE","PH"));
		return false;
	}
	return true;
}

function storeChangedValues(){
	var formObj=f_query_result.document.NPBRequestQueryResult;	
	var totalRec = parseInt(formObj.totalRec.value);
	var req_no, validityDate, reqAction, NPBRemarks, selctedYN, reqStatus;
	var bean_id			= formObj.bean_id.value ;
	var bean_name	    = formObj.bean_name.value ;	
	xmlStr ="<root><SEARCH " ;
	xmlStr			+= " bean_id=\""+ bean_id + "\" ";
	xmlStr			+= " bean_name=\""+ bean_name + "\" ";
	for(index=0; index<totalRec; index++){
		reqStatus = eval("formObj.request_status_"+index).value;
		selectedYN = eval("formObj.select_"+index).checked;
		approved_drug_code = eval("formObj.approved_drug_code_"+index).value;
		request_drug_name = eval("formObj.request_drug_name_"+index).value;
		if(selectedYN == true)
			selectedYN = "Y";
		else
			selectedYN="N";
		req_no = eval("formObj.request_no_"+index).value;
		validityDate = eval("formObj.validityDate_"+index).value;
		reqAction = eval("formObj.ReqAction_"+index).value;
		if(reqAction == "J")
			NPBRemarks =eval("formObj.request_rej_reason_"+index).value;
		else if(reqAction == "A")
			NPBRemarks =eval("formObj.request_ack_reason_"+index).value;
		else if(reqAction == "P")
			NPBRemarks =eval("formObj.request_aprv_reason_"+index).value;
			xmlStr		    += " request_no_"+index+"=\""+ req_no + "\" ";
			xmlStr		    += " validityDate_"+index+"=\""+ validityDate + "\" ";
			xmlStr		    += " reqAction_"+index+"=\""+reqAction + "\" ";
			xmlStr		    += " NPBRemarks_"+index+"=\""+ encodeURIComponent(NPBRemarks,"UTF-8") + "\" ";
			xmlStr		    += " selectedYN_"+index+"=\""+ selectedYN + "\" ";
			xmlStr		    += " approved_drug_code_"+index+"=\""+ approved_drug_code + "\" ";
			xmlStr		    += " request_drug_name_"+index+"=\""+ encodeURIComponent(request_drug_name,"UTF-8") + "\" ";
	}
	xmlStr +=" /></root>" ;
	fieldValidation(xmlStr,"storeChangedValues");	
	return true;
}

function onSuccess(){
	query();
}

function assignResult( _result, _message, _flag ) {
	result = _result ;
	message  = _message ;
	flag = _flag ;
}

async function openNPBRemarks(index){
	var formObj = document.NPBRequestQueryResult;
	var reqStatus = eval("formObj.request_status_"+index).value;
	var reqAction = eval("formObj.ReqAction_"+index).value;
	var NPBRemarks="";
	var editOption="N";
	if(reqAction == "C")
		NPBRemarks =eval("formObj.request_can_reason_"+index).value;
	else if(reqAction == "J")
		NPBRemarks =eval("formObj.request_rej_reason_"+index).value;
	else if(reqAction == "A")
		NPBRemarks =eval("formObj.request_ack_reason_"+index).value;
	else if(reqAction == "P")
		NPBRemarks =eval("formObj.request_aprv_reason_"+index).value;
	if(reqStatus == reqAction || reqAction=="")
		editOption = "N";
	else
		editOption="Y"
	if(reqAction == ''){
		if(reqStatus == "C")
			NPBRemarks =eval("formObj.request_can_reason_"+index).value;
		else if(reqStatus == "J")
			NPBRemarks =eval("formObj.request_rej_reason_"+index).value;
		else if(reqStatus == "A")
			NPBRemarks =eval("formObj.request_ack_reason_"+index).value;
		else if(reqStatus == "P")
			NPBRemarks =eval("formObj.request_aprv_reason_"+index).value;
	}
	var dialogHeight		= '37vh';
	var dialogWidth			= '45vw';
	var dialogTop			= '';
	var dialogLeft			= '' ;
	var title				= ''
	var	arguments			= "";	
	var	features			= 'dialogHeight:' + dialogHeight + '; dialogWidth:' + dialogWidth + ';dialogTop:'+dialogTop+';dialogLeft:'+dialogLeft+';dialogTitle:'+title+'; scroll=yes; status=no';
	var retVals	=  await top.window.showModalDialog("../../ePH/jsp/NPBRequestApproveRejectRemarks.jsp?NPBRemarks="+escape(NPBRemarks)+"&editOption="+editOption,arguments,features); 
	if(retVals != undefined && retVals[0] == 'Y' ){
		NPBRemarks = decodeURIComponent(retVals[1],"UTF-8");
		if(editOption=="Y"){
			if(reqAction == "C")
				eval("formObj.request_can_reason_"+index).value=NPBRemarks;
			else if(reqAction == "J")
				eval("formObj.request_rej_reason_"+index).value=NPBRemarks;
			else if(reqAction == "A")
				eval("formObj.request_ack_reason_"+index).value=NPBRemarks;
			else if(reqAction == "P")
				eval("formObj.request_aprv_reason_"+index).value=NPBRemarks;
		}	
	}
}

function storeNPBRemarks(){
	var retval= new Array();
	var NPBRemarks = encodeURIComponent(document.NPBRemarksForm.NPBRemarks.value,"UTF-8");
	if(trimString(NPBRemarks) == ""){
		var msg = getMessage("SHOULD_NOT_BE_BLANK","Common");
		msg = msg.replace("{1}",getLabel("Common.remarks.label",'Common'));
		alert(msg);
		return false;
	}
	retval[0]="Y";
	retval[1]=NPBRemarks;
	window.returnValue=retval;
	window.close();
}

function CheckRemMaxLen() { 
	var val = "";
	obj = document.NPBRemarksForm.NPBRemarks;
	val = obj.value;
	if(obj.value.length > 1000) {
		var msg = getMessage("REMARKS_CANNOT_EXCEED","Common");
		msg = msg.replace("$",getLabel("Common.remarks.label",'Common'));
		msg = msg.replace("#",1000);
		obj.value = val.substring(0,(val.length)-1);
		alert(msg);
		obj.focus();
		return false;
	} 
}

function printPreview(){
 	//parent.NPBReqForm.focus(); 
	//t=new ActiveXObject("WScript.Shell");
	//t.RegWrite("HKCU\\Software\\Microsoft\\Internet Explorer\\PageSetup\\header","");
	//t.RegWrite("HKCU\\Software\\Microsoft\\Internet Explorer\\PageSetup\\footer","");
  	//parent.NPBReqForm.print();
	window.print();
}
