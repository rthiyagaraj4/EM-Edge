function loadNBPRequest(NPBRequestType, callFrom){
	if(callFrom!=undefined && (callFrom=="ExtReset"|| callFrom=="Release"))
		var query_string = parent.NPBOptionsFrame.document.NPBRequestOptions.query_string.value+"&ReqType="+NPBRequestType;
	else
		var query_string = document.NPBRequestOptions.query_string.value+"&ReqType="+NPBRequestType;
	if(NPBRequestType=='N'){
		//parent.NPBRequestFrame.rows='12%,*,0%,0%';
		parent.document.getElementById("NPBOptionsFrame").style.height="12vh";
		parent.document.getElementById("f_query_add_mod").style.height="88vh";
		parent.document.getElementById("f_query_result").style.height="0vh";
		parent.document.getElementById("f_query_result_buttons").style.height="0vh";

	}
	else
		//parent.NPBRequestFrame.rows='12%,28%,45%,15%';
		parent.document.getElementById("NPBOptionsFrame").style.height="12vh";
		parent.document.getElementById("f_query_add_mod").style.height="28vh";
		parent.document.getElementById("f_query_result").style.height="45vh";
		parent.document.getElementById("f_query_result_buttons").style.height="15vh";
	
	parent.f_query_add_mod.location.href="../../ePH/jsp/NPBRequestDetail.jsp?"+query_string;
	parent.f_query_result.location.href="../../eCommon/html/blank.html";
	parent.f_query_result_buttons.location.href="../../eCommon/html/blank.html";
	if(null!=top.content && null!=top.content.messageFrame && null!=top.content.messageFrame.location && null!=top.content.messageFrame.location.href) //if condition & els part added for CHL-CRF-0008 [IN:035914]
	top.content.messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num=";
	else
		top.frames[2].document.location.href ="../../eCommon/jsp/error.jsp?err_num=";
}

async function searchDrugNameCLP(called_from){
	var formObj=document.NPBRequestDetail;
	var locale = formObj.locale.value;
	var argumentArray  = new Array();
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
	argumentArray[5]   = formObj.DrugName.value ;
	argumentArray[6]   = DESC_LINK ;
	argumentArray[7]   = DESC_CODE ; 	
	retVal = await CommonLookup( getLabel("Common.Drug.label","Common"), argumentArray );	
	var ret1=unescape(retVal);
	//alert("ret1"+ret1);
		 	var arr=ret1.split(",");
		 	if(arr[1]==undefined) 
	 		{
		 		arr[0]="";	
		 		arr[1]="";	
	 		}
	formObj.DrugName.value="";
	
	if(retVal != null && retVal != "" )  {
		formObj.DrugName.value = arr[1] ;
		formObj.DrugCode.value = arr[0];
		if(called_from == 'N')
			loadDrugQTYUOM(arr[0]);
	}
}
/*
function searchDrugName(){
	formObj=document.NPBRequestDetail;
	var objDrug = formObj.DrugName;
	var retVal=DrugSearch("D",objDrug);
	if(retVal != null && retVal != "" ){
		formObj.DrugCode.value=retVal[0];
		formObj.DrugName.value=retVal[1];
		loadDrugQTYUOM(retVal[0]);
	}
}
*/
function checkDrug(){
	formObj=document.NPBRequestDetail;
	DrugName = trimString(formObj.DrugName.value);
	if(DrugName==''){
		formObj.DrugCode.value = "";
		loadDrugQTYUOM('');
	}
}

function loadDrugQTYUOM(drugCode){
	var bean_id					= document.NPBRequestDetail.bean_id.value;
	var bean_name				= document.NPBRequestDetail.bean_name.value;
//	var xmlDoc 				= new ActiveXObject( "Microsoft.XMLDom" ) ;
//	var xmlHttp 			= new ActiveXObject( "Microsoft.XMLHTTP" ) ;
	var xmlDoc = ""; 
	var xmlHttp = new XMLHttpRequest();
	
	xmlStr					= "<root><SEARCH " ;
	xmlStr					+= "bean_id=\"" +bean_id +"\" ";
	xmlStr					+= "bean_name=\"" +bean_name +"\" ";
	xmlStr					+= "drugCode=\"" +drugCode +"\" ";
	xmlStr 					+=" /></root>" ;
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open( "POST", "NPBRequestValidate.jsp?func_mode=loadQuantityUOM", false ) ;
	xmlHttp.send( xmlDoc ) ;
	responseText=xmlHttp.responseText ;
	eval( responseText ) ;
}

function EnableNBPFormLink(obj){
	if(obj.value !='')
		document.getElementById("NBPFormLink").style.visibility = 'visible';
	else
		document.getElementById("NBPFormLink").style.visibility = 'hidden';
}

function openNPBForm(){  	
	var dialogHeight ='450'
	var dialogWidth = document.body.clientWidth ;
	var dialogTop	= '180';
	var dialogLeft = '5';
	//var features = 'dialogHeight:' + dialogHeight + '; dialogWidth:' + dialogWidth +';dialogTop:'+dialogTop+';dialogLeft:'+dialogLeft+'; scroll=no; status=no';
	var features = 'Height=' + dialogHeight + ', Width=' + dialogWidth +',Top='+dialogTop+',Left='+dialogLeft;
	//var arguments = "";
	var bean_id = document.NPBRequestDetail.bean_id.value;
	var bean_name = document.NPBRequestDetail.bean_name.value;
	var patient_id = document.NPBRequestDetail.patient_id.value;
	var encounter_id = document.NPBRequestDetail.encounter_id.value;
	var NPBReqFormId = document.NPBRequestDetail.NPBForm.value;
	var query_string = "bean_id="+bean_id+"&bean_name="+bean_name+"&patient_id="+patient_id+"&encounter_id="+encounter_id+"&NPBReqFormId="+NPBReqFormId+"&mode=1";
	//retVal = window.showModalDialog("../../ePH/jsp/NPBRequestFormFrame.jsp?"+query_string,arguments,features);
	retVal =window.open("../../ePH/jsp/NPBRequestFormFrame.jsp?"+query_string,"",features);
}

function ValidateReqDate(obj, curr_date, locale){
	if(obj.value!=""){
		if(!validDate(obj.value, "DMYHM",locale )){
			alert(getMessage("INVALID_DATE_TIME","PH"));
			obj.value="";
			obj.select();
			return false;
		}
		var reqDate = obj.value;
		if(reqDate.indexOf(' ')!=-1){
			reqDatelst = reqDate.split(" ");
			reqDate = reqDatelst[0];
		}
		if(!isBefore(reqDate,curr_date, "DMY",locale)){
			alert(getMessage("REQ_DATE_EQL_CURR_DATE", "PH"));
			obj.value="";
			obj.focus();
			return false;
		}
		if(!isAfter(reqDate,curr_date, "DMY",locale)){
			alert(getMessage("REQ_DATE_EQL_CURR_DATE", "PH"));
			obj.value="";
			obj.focus();
			return false;
		}
	}
}

function ValidateFromDate(obj, curr_date, locale){
	fr_dt = document.NPBRequestDetail.dt_to;
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
	fr_dt = document.NPBRequestDetail.dt_from;
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
function setZoomEditorTemplate(){
 	var RTEText = parent.editor_button.document.editorButtonForm.RTEText.value;
	parent.editor.RTEditor0.document.designMode = "On";
	parent.editor.RTEditor0.document.body.focus();
	parent.editor.RTEditor0.document.body.innerHTML = "";
	parent.editor.RTEditor0.document.execCommand("formatBlock","", "Address");
   	if(RTEText!=""){
		//parent.consentdetails.rows="*,10%";
		parent.document.getElementById("editor").style="90vh";
		parent.document.getElementById("editor_button").style="10vh";
		document.editorButtonForm.zoom.title="ZoomIn";
		document.editorButtonForm.zoom.src = "../../eOR/images/Maximize.gif";
		parent.editor.RTEditor0.document.body.insertAdjacentHTML("beforeend",RTEText);
	}	
}

function zoomWindow(){
	if((parent.document.getElementById("editor").style==="90vh")&&(parent.document.getElementById("editor_button").style==="10vh")) {
		//parent.consentdetails.rows="*,30%"	;
		parent.document.getElementById("editor").style="70vh";
		parent.document.getElementById("editor_button").style="30vh";		
		document.editorButtonForm.zoom.title="ZoomOut"
		document.editorButtonForm.zoom.src = "../../eOR/images/Minimize.gif";
	} 
	else  {
		//parent.consentdetails.rows="*,10%";
		parent.document.getElementById("editor").style="90vh";
		parent.document.getElementById("editor_button").style="10vh";
		document.editorButtonForm.zoom.title="ZoomIn"
		document.editorButtonForm.zoom.src = "../../eOR/images/Maximize.gif";
	}
}

function storeEditor(callMode){
	var bean_id					= parent.editor_button.document.editorButtonForm.bean_id.value;
	var bean_name				= parent.editor_button.document.editorButtonForm.bean_name.value;
	var NPBReqFormId			= parent.editor_button.document.editorButtonForm.NPBReqFormId.value;
	var request_no			= parent.editor_button.document.editorButtonForm.request_no.value;
	var mode			= parent.editor_button.document.editorButtonForm.mode.value;
	var index			= parent.editor_button.document.editorButtonForm.index.value;
//	var xmlDoc 				= new ActiveXObject( "Microsoft.XMLDom" ) ;
//	var xmlHttp 			= new ActiveXObject( "Microsoft.XMLHTTP" ) ;
	var xmlDoc = ""; 
	var xmlHttp = new XMLHttpRequest();
	var editorText = parent.editor.RTEditor0.document.body.innerHTML;
	if(trimString(editorText) == '' || trimString(editorText) == '<ADDRESS>&nbsp;</ADDRESS>'){
		alert(getMessage("PH_SELECT_NPB_REQ_FORM_TEXT","PH"));
		return false;
	}
	xmlStr					= "<root><SEARCH " ;
	xmlStr					+= "bean_id=\"" +bean_id +"\" ";
	xmlStr					+= "bean_name=\"" +bean_name +"\" ";
	xmlStr					+= "index=\"" +index +"\" ";
	xmlStr					+= "NPBReqFormId=\"" +NPBReqFormId +"\" ";
	xmlStr					+= "request_no=\"" +request_no +"\" ";
	xmlStr					+= "NPBReqFormText=\""+encodeURIComponent(parent.editor.RTEditor0.document.body.innerHTML,"UTF-8") +"\" ";
	xmlStr 					+=" /></root>" ;
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	if(mode=='2'){
		xmlHttp.open( "POST", "NPBRequestValidate.jsp?func_mode=StoreEditorTextAmend", false ) ;
		xmlHttp.send( xmlDoc ) ;
		responseText=xmlHttp.responseText ;
		eval( responseText ) ;
	}
	else{
		xmlHttp.open( "POST", "NPBRequestValidate.jsp?func_mode=StoreEditorText", false ) ;
		xmlHttp.send( xmlDoc ) ;
		responseText=xmlHttp.responseText ;
		eval( responseText ) ;
	}
	if(callMode=="Preview")
		openPreview();
	else{
		top.window.returnValue = "y";
	}
	window.parent.close();
}

async function openPreview(){	
	//var NPBReqFormText		=encodeURIComponent( parent.editor_button.document.editorButtonForm.RTEText.value,"UTF-8");
	//var NPBReqFormText		=parent.editor_button.document.editorButtonForm.RTEText.value;
	var bean_id					= parent.editor_button.document.editorButtonForm.bean_id.value;
	var bean_name				= parent.editor_button.document.editorButtonForm.bean_name.value;
	var NPBReqFormId			= parent.editor_button.document.editorButtonForm.NPBReqFormId.value;
	var mode			= parent.editor_button.document.editorButtonForm.mode.value;
	var request_no			= parent.editor_button.document.editorButtonForm.request_no.value;
	var dialogHeight		= '80vh';
	var dialogWidth			= '60vw';
	var dialogTop			= '100';
	var dialogLeft			= '150' ;
	var title				= ''
	var	arguments			= "";	
	var	features			= 'dialogHeight:' + dialogHeight + '; dialogWidth:' + dialogWidth + ';dialogTop:'+dialogTop+';dialogLeft:'+dialogLeft+';dialogTitle:'+title+'; scroll=yes; status=no';
	var retVals				=  await window.showModalDialog("../../ePH/jsp/NPBRequestFormPreviewFrame.jsp?bean_id="+bean_id+"&bean_name="+bean_name+"&NPBReqFormId="+NPBReqFormId+"&mode="+mode+"&calledFrom=REQUEST&request_no="+request_no,arguments,features); 		  
}

function clearQtyDescList(){
	var len =document.NPBRequestDetail.qty_desc.options.length;
	for(var i=0;i<len;i++) {
		document.NPBRequestDetail.qty_desc.remove("qty_desc") ;
	}
	var element = document.createElement('OPTION') ;
	element.value		=  "" ;
	element.text		='   ---'+ getLabel("Common.defaultSelect.label","Common")+'---   ' ;
	document.NPBRequestDetail.qty_desc.add(element);
}
function addQtyDescList(code,desc){
	var element = document.createElement('OPTION') ;
	element.value		=  code ;
	element.text		=  decodeURIComponent(desc) ;
	document.NPBRequestDetail.qty_desc.add(element);
}
function setDefaultUOM(code){
	document.NPBRequestDetail.qty_desc.value=code;
}

function ConfirmRequset(){
	var formObj=document.NPBRequestDetail;	
	var messageFrame;
	var fields = new Array (formObj.DrugName, formObj.NPBForm,formObj.reqDate); //formObj.reqQty, formObj.qty_desc, removed for ML-BRU-SCF-0367 [IN:034747]
	var names = new Array (getLabel("Common.Drug.label","Common"),getLabel("ePH.RequestForm.label","ph_labels"),getLabel("Common.RequestDate.label","Common")); //getLabel("Common.Quantity.label","Common"),getLabel("ePH.QtyUOM.label","ph_labels"), -removed for ML-BRU-SCF-0367 [IN:034747]
	//IN038754 Starts
	if(null!=top.content && null!=top.content.messageFrame)
		messageFrame=top.content.messageFrame;
	else
		messageFrame = top.frames[2];
	//IN038754 Ends
	if(checkFields( fields, names, messageFrame)){
		if(checkFieldsforZero()){
			if(formObj.reqQty.value=="" ) //if block added for ML-BRU-SCF-0367 [IN:034747]
				formObj.qty_desc.value = ""

			eval(formApply(formObj,PH_CONTROLLER));
			if( result ){
				 onSuccess();
			 }
			messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ message;	
		}
		else
			return false;
	}
}

function checkFieldsforZero(){
	//IN038754 Starts
	//top.content.messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num=";	
	if(null!=top.content && null!=top.content.messageFrame && null!=top.content.messageFrame.location && null!=top.content.messageFrame.location.href) {//if condition & els part added for CHL-CRF-0008 [IN:035914]
		top.content.messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num=";	
	}
	else{
		top.frames[2].document.location.href ="../../eCommon/jsp/error.jsp?err_num=";
	}
	//IN038754 Ends
	var formObj=document.NPBRequestDetail;	
	var messageFrame;
	var reqQty =  formObj.reqQty.value;
	var validity =  formObj.validity.value;
	if( reqQty=='' || parseInt(reqQty)<=0){ //removed  reqQty=="" || for ML-BRU-SCF-0367 [IN:034747]
		msg = getMessage("PH_NOT_BLANK_ZERO_COMMON","PH");
		msg = msg.replace("$",getLabel("Common.Quantity.label","Common"));
		alert(msg);
		return false;
	}
	
	if(validity!="" && parseInt(validity)<=0){
		msg = getMessage("PH_NOT_BLANK_ZERO_COMMON","PH");
		msg = msg.replace("$",getLabel("ePH.ValidityPeriod.label","PH"));
		alert(msg);
		return false;
	}
	return true;
}

function onSuccess(){
	var NPBReqType = parent.NPBOptionsFrame.document.NPBRequestOptions.NPBRequestOptions;
	if(NPBReqType[0].checked == true)
		loadNBPRequest('N','Release');
	else
		loadNBPRequest('E','Release');
}

function assignResult( _result, _message, _flag ) {
	result = _result ;
	message  = _message ;
	flag = _flag ;
}

function CancelRequset(){
	document.NPBRequestDetail.reset();
}
function searchNPBReq(){
	parent.f_query_result.location.href="../../eCommon/html/blank.html";
	parent.f_query_result_buttons.location.href="../../eCommon/html/blank.html";
	var formObj=document.NPBRequestDetail;
	var fields = new Array (formObj.dt_from, formObj.dt_to);
	var names = new Array (getLabel("Common.Request.label","Common")+' '+getLabel("Common.from.label","Common"), getLabel("Common.Request.label","Common")+' '+getLabel("Common.to.label","Common"));
	if(null!=top.content && null!=top.content.messageFrame) //if condition & else part added for CHL-CRF-0008 [IN:035914]
	messageFrame=top.content.messageFrame;
	else
		messageFrame = top.frames[2];
	if(checkFields( fields, names, messageFrame)){
		var bean_id = formObj.bean_id.value;
		var bean_name = formObj.bean_name.value;
		var patient_id = formObj.patient_id.value;
		var encounter_id = formObj.encounter_id.value;
		var reqFromDate = formObj.dt_from.value;
		var reqToDate = formObj.dt_to.value;
		var drugName = formObj.DrugName.value;
		var drugCode = formObj.DrugCode.value;
		var NPBReqFormId = formObj.NPBForm.value;
		var reqStatus = formObj.reqStatus.value;
		var pract_id = formObj.pract_id.value;
		parent.f_query_result.location.href = "../../ePH/jsp/NPBRequestList.jsp?bean_id="+bean_id+"&bean_name="+bean_name+"&patient_id="+patient_id+"&encounter_id="+encounter_id+"&reqFromDate="+reqFromDate+"&reqToDate="+reqToDate+"&drugName="+drugName+"&drugCode="+drugCode+"&NPBReqFormId="+NPBReqFormId+"&reqStatus="+reqStatus+"&pract_id="+pract_id;
		if(null!=top.content && null!=top.content.messageFrame && null!=top.content.messageFrame.location && null!=top.content.messageFrame.location.href)  //if condition & else part added for CHL-CRF-0008 [IN:035914]
		top.content.messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num=";
		else
			top.frames[2].document.location.href ="../../eCommon/jsp/error.jsp?err_num=";
	}
}

async function openOtherDetails(index){
	var formObj=document.NPBRequestList;
	var request_form_name = eval('formObj.request_form_name_'+index).value;
	var request_pract_name = eval('formObj.request_pract_name_'+index).value;
	var reject_pract_name = eval('formObj.reject_pract_name_'+index).value;
	var can_pract_name = eval('formObj.can_pract_name_'+index).value;
	var ack_pract_name = eval('formObj.ack_pract_name_'+index).value;
	var apr_pract_name = eval('formObj.apr_pract_name_'+index).value;
	var request_date_time = eval('formObj.request_date_time_'+index).value;
	var request_can_date_time = eval('formObj.request_can_date_time_'+index).value;
	var request_rej_date_time = eval('formObj.request_rej_date_time_'+index).value;
	var request_aprv_date_time = eval('formObj.request_aprv_date_time_'+index).value;
	var request_ack_date_time = eval('formObj.request_ack_date_time_'+index).value;
	 // addeded for incident ML-BRU-SCF-0367 [IN:034747](3rd point) -start
	var request_can_reason    = eval('formObj.request_can_reason_'+index).value;
	var request_rej_reason    = eval('formObj.request_rej_reason_'+index).value;
	var request_ack_reason   = eval('formObj.request_ack_reason_'+index).value;
	var request_aprv_reason    = eval('formObj.request_aprv_reason_'+index).value;
	// addeded for incident ML-BRU-SCF-0367 [IN:034747](3rd point) -end
	var dialogHeight		= '80vh';
	var dialogWidth			= '70vw';
	var dialogTop			= '400';
	var dialogLeft			= '550' ;
	var title				= ''
	var	arguments			= "";	
	var	features			= 'dialogHeight:' + dialogHeight + '; dialogWidth:' + dialogWidth + ';dialogTop:'+dialogTop+';dialogLeft:'+dialogLeft+';dialogTitle:'+title+'; scroll=yes; status=no';
	var retVals				=  await window.showModalDialog("../../ePH/jsp/NPBRequestOtherDetails.jsp?request_form_name="+request_form_name+"&request_pract_name="+request_pract_name+"&reject_pract_name="+reject_pract_name+"&can_pract_name="+can_pract_name+"&ack_pract_name="+ack_pract_name+"&apr_pract_name="+apr_pract_name+"&request_date_time="+request_date_time+"&request_can_date_time="+request_can_date_time+"&request_rej_date_time="+request_rej_date_time+"&request_aprv_date_time="+request_aprv_date_time+"&request_ack_date_time="+request_ack_date_time+"&request_can_reason="+escape(request_can_reason)+"&request_rej_reason="+escape(request_rej_reason)+"&request_ack_reason="+escape(request_ack_reason)+"&request_aprv_reason="+escape(request_aprv_reason),arguments,features); 		  
}

async function openNPBAmend(index){
	var formObj=document.NPBRequestList;
	var bean_id = formObj.bean_id.value;
	var bean_name = formObj.bean_name.value;
	var patient_id = formObj.patient_id.value;
	var encounter_id = formObj.encounter_id.value;
	var NPBReqFormId = eval('formObj.NPBReqFormId_'+index).value;
	var request_no = eval('formObj.request_no_'+index).value;
	var request_status = eval('formObj.request_status_'+index).value;
	if(request_status != 'R'){
		//var NPBReqFormText			= encodeURIComponent( eval('formObj.request_form_content_'+index).value,"UTF-8");
		var dialogHeight		= '25vh';
		var dialogWidth			= '78vw';
		var dialogTop			= '250';
		var dialogLeft			= '25' ;
		var title				= ''
		var	arguments			= "";	
		var	features			= 'dialogHeight:' + dialogHeight + '; dialogWidth:' + dialogWidth + ';dialogTop:'+dialogTop+';dialogLeft:'+dialogLeft+';dialogTitle:'+title+'; scroll=yes; status=no';
		var retVals				=  await window.showModalDialog("../../ePH/jsp/NPBRequestFormPreviewFrame.jsp?bean_id="+bean_id+"&bean_name="+bean_name+"&request_status="+request_status+"&request_no="+request_no+"&mode=2&index="+index+"&calledFrom=REQUEST",arguments,features);	  
	}
	else{
		eval('formObj.formTXTchanged_'+index).value="Y";
		var dialogHeight ='450'
		var dialogWidth = document.body.clientWidth ;
		var dialogTop	= '180';
		var dialogLeft = '5';
		//var features = 'dialogHeight:' + dialogHeight + '; dialogWidth:' + dialogWidth +';dialogTop:'+dialogTop+';dialogLeft:'+dialogLeft+'; scroll=no; status=no';
		var features = 'Height=' + dialogHeight + ', Width=' + dialogWidth +',Top='+dialogTop+',Left='+dialogLeft;
		var query_string = "bean_id="+bean_id+"&bean_name="+bean_name+"&patient_id="+patient_id+"&encounter_id="+encounter_id+"&request_no="+request_no+"&mode=2&index="+index;
		//retVal = window.showModalDialog("../../ePH/jsp/NPBRequestFormFrame.jsp?"+query_string,arguments,features);
		retVal = window.open("../../ePH/jsp/NPBRequestFormFrame.jsp?"+query_string,"",features);
	}

	//var retVals				=  window.showModalDialog("../../ePH/jsp/NPBRequestFormPreview.jsp?bean_id="+bean_id+"&bean_name="+bean_name+"&patient_id="+patient_id+"&encounter_id="+encounter_id+"&NPBReqFormId="+NPBReqFormId,arguments,features); 		  
}

function closePreview(){
	parent.window.close();
}

function printPreview(){
	window.print();
 	//parent.NPBReqForm.focus(); 
	//t=new ActiveXObject("WScript.Shell");
	//t.RegWrite("HKCU\\Software\\Microsoft\\Internet Explorer\\PageSetup\\header","");
	//t.RegWrite("HKCU\\Software\\Microsoft\\Internet Explorer\\PageSetup\\footer","");
  	//parent.NPBReqForm.print();
}

function selectCancel(index){
	var formObj=document.NPBRequestList;
	var changedYN = eval('formObj.changed_'+index).value;
	if(eval('formObj.cancelchk_'+index).checked == true)
		eval('formObj.cancelchk_'+index).value = 'Y';
	else
		eval('formObj.cancelchk_'+index).value='N';
	var cancelChecked = eval('formObj.cancelchk_'+index).value;
	if(cancelChecked=='Y' && changedYN=='N'){
		eval('formObj.changed_'+index).value='Y';
		eval('formObj.cancelReason_'+index).disabled=false;
	}
	else{
		eval('formObj.changed_'+index).value='N';
		eval('formObj.cancelReason_'+index).disabled=true;
		eval('formObj.cancelReason_'+index).value="";
	}
}

function RecordNPB(){
	var formObj=parent.f_query_result.document.NPBRequestList;	
	var totalRec = parseInt(formObj.totalRec.value);
	var recChanged=false;
	var changed = "";
	for( k =0; k<totalRec; k++){
		changed =  eval('formObj.changed_'+k).value;
		formchanged =  eval('formObj.formTXTchanged_'+k).value;
		canReason =  eval('formObj.cancelReason_'+k).value;
		if(changed=='Y' ){
			recChanged = true;
			if(canReason==''){
				alert(getMessage("PH_NPB_REASON_FOR_CANCEL","PH"));
				return false;
			}
		}
		if(formchanged=="Y")
			recChanged=true;
	}
	if(!recChanged){
		alert(getMessage("PH_NO_CHANGE","PH"));
		return false;
	}
	eval(formApply(formObj,PH_CONTROLLER));
	//IN038754 Starts
	//top.content.messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ message;	
	if(null!=top.content && null!=top.content.messageFrame && null!=top.content.messageFrame.location && null!=top.content.messageFrame.location.href) {//if condition & els part added for CHL-CRF-0008 [IN:035914]
		top.content.messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ message;
	}
	else{
		top.frames[2].document.location.href ="../../eCommon/jsp/error.jsp?err_num="+ message;
	}//IN038754 Ends
	if( result ){
		 onSuccess();
	 }
	top.content.messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ message;	
}

//Table careation in Editor related functions -start

function hideToolTip()	{
  document.getElementById("tooltiplayer").style.visibility = 'hidden'
}

function showTable(){
	var tab_dat  = "<table id='tooltiptable1' cellpadding=3 cellspacing=0 border='0' class='BOX' width='100%' height='100%' align='center'>"
	tab_dat     += "<tr><td class='data' nowrap>"+getLabel("eCA.NoofRows.label","CA")+"</td><td class='fields'><input type='text' name='rows' id='rows' size='2' maxLength='2' value='5' onKeyPress='return OrAllowNumber()' onBlur='return OrCheckNumber(this)' ></td><td class='data' nowrap"+getLabel("eOR.NoofColumns.label","OR")+"</td><td class='fields'><input type='text' name='cols' id='cols' size='1' maxLength='1'  value='3' onKeyPress='return OrAllowNumber()' onBlur='return OrCheckNumber(this)' ></td>"
	tab_dat     += "<td class='label'><input type='button' class='button' name='ok' id='ok' value="+getLabel("Common.ok.label","Common")+" onClick='setBuildTable()'></td><td class='label'><input type='button' class='button' name='cancel' id='cancel' value="+getLabel("Common.cancel.label","Common")+" onClick='hideToolTip()'></td></tr> "
	tab_dat     += "</table> "
	resizeWindow(tab_dat);
}
 
 function resizeWindow(tab_dat){
	document.getElementById("t").innerHTML					= tab_dat;
	document.getElementById("tooltiplayer").style.posLeft		= 202+"px";
	document.getElementById("tooltiplayer").style.posTop		= 0+"px";
	document.getElementById("tooltiplayer").style.visibility	='visible'
}

function setBuildTable(){
	var rows = document.getElementById("rows").value;
	var cols = document.getElementById("cols").value;
	var table =  parent.editor.RTEditor0.document.getElementsByTagName("TABLE");
	var table_length = table.length;
	if(rows > 0 && cols > 0) {
		var htmlTable	= 	"<TABLE id='table"+table_length+"'  border=1 CELLPADDING='3' CELLSPACING='0' BORDERCOLOR='black' align=center>";
		for(i=0;i<rows;i++) {
			htmlTable	+= "<TR>";
			for(j=0;j<cols;j++) {
				htmlTable	+= "<TD></TD>";
			}
			htmlTable	+= "</TR>";
		}
		htmlTable+="</TABLE>";
		parent.editor.RTEditor0.document.body.insertAdjacentHTML("beforeend",htmlTable);
		hideToolTip();
		document.getElementById("add_table").style.visibility = 'visible'
		document.getElementById("add_table_gif").style.visibility = 'visible'
		document.getElementById("delete_table").style.visibility = 'visible'
		document.getElementById("delete_table_gif").style.visibility = 'visible'
	}
}
function deleteTable(){
	var tab_dat  = "<table id='tooltiptable1' cellpadding=3 cellspacing=0 border='0' class='BOX' width='100%' height='100%' align='center'>"
	tab_dat     += "<tr><td class='data' nowrap>"+getLabel("eOR.TableNo.label","OR")+"</td><td class='fields'><input type='text' name='table_no' id='table_no' size='2' maxLength='2' value='1' onKeyPress='return OrAllowNumber()' onBlur='return OrCheckNumber(this)' ><td class='data' nowrap>"+getLabel("eOR.RowNotobedeleted.label","OR")+"</td><td class='fields'><input type='text' name='delete_row' id='delete_row' size='2' maxLength='2' value='1' onKeyPress='return OrAllowNumber()' onBlur='return OrCheckNumber(this)' ></td>"
	tab_dat     += "<td class='label'><input type='button' class='button' name='ok' id='ok' Value="+getLabel("Common.ok.label","Common")+" onClick='deleteTableRow()'></td><td class='label'><input type='button' class='button' name='cancel' id='cancel' Value="+getLabel("Common.cancel.label","Common")+" onClick='hideToolTip()'></td></tr> "
	tab_dat     += "</table> "
	resizeWindow(tab_dat);	
}
function deleteTableRow(){
	hideToolTip();
	var table_no	= document.getElementById("table_no").value;
	if(table_no!="" && table_no!=0) {
		table_no	= parseInt(table_no-1);
	}	
	else
		table_no	= 0;
	var rows = document.getElementById("delete_row").value;
	if(rows!="")
		rows = parseInt(rows) - 1;

	if(parent.editor.RTEditor0.document.getElementById("table"+table_no) && 		parent.editor.RTEditor0.document.getElementById("table"+table_no+".rows["+rows+"]")){
		parent.editor.RTEditor0.document.getElementById("table"+table_no+".deleteRow("+rows+")");
		if(parent.editor.RTEditor0.document.getElementById("table"+table_no+".rows.length==0")){
			parent.editor.RTEditor0.document.getElementById("table"+table_no+".clear");
		}
	}
}

function addTable(){
	var tab_dat  = "<table id='tooltiptable1' cellpadding=3 cellspacing=0 border='0' class='BOX' width='100%' height='100%' align='center'>"
	tab_dat     += "<tr><td class='data' nowrap>"+getLabel("eOR.TableNo.label","OR")+"</td><td class='fields'><input type='text' name='table_no' id='table_no' size='2' maxLength='2' value='' onKeyPress='return OrAllowNumber()' onBlur='return OrCheckNumber(this)' ><td class='data' nowrap>"+getLabel("eOR.RowNo.label","OR")+"</td><td class='fields'><input type='text' name='add_row' id='add_row' size='2' maxLength='2' value='2' onKeyPress='return OrAllowNumber()' onBlur='return OrCheckNumber(this)' ></td>"
	tab_dat		+="<td class='data' nowrap>"+getLabel("eOR.ColumnNo.label","OR")+"</td><td class='fields'><input type='text' name='add_columns' id='add_columns' size='1' maxLength='1' value='1' onKeyPress='return OrAllowNumber()' onBlur='return OrCheckNumber(this)' ></td>";
	tab_dat     += "<td class='fields'><input type='button' class='button' name='ok' id='ok' Value="+getLabel("Common.ok.label","Common")+" onClick='addTableRow()'></td><td class='label'><input type='button' class='button' name='cancel' id='cancel' Value="+getLabel("Common.cancel.label","Common")+" onClick='hideToolTip()'></td></tr> "
	tab_dat     += "</table> "
	resizeWindow(tab_dat);	
}

function addTableRow(){
	hideToolTip();
	var table_no	= document.getElementById("table_no").value;
	if(table_no!="" && table_no!=0) {
 		table_no	= parseInt(table_no-1);
 	}	
	else
		table_no	= 0;
   	if(table_no>=0){
   		var rows		= document.getElementById("add_row").value;
		var cols		= document.getElementById("add_columns").value;
 		if(rows > 1) {
			rows	 = rows-1;
			if(cols!="" && cols>0)
				cols = parseInt(cols);
   	 		if(parent.editor.RTEditor0.document.getElementById("table"+table_no) && rows>0) {
				if(parent.editor.RTEditor0.document.getElementById("table"+table_no+".rows.length!=0"))
	  				parent.editor.RTEditor0.document.getElementById("table"+table_no+".insertRow("+rows+")");
			}
			for( j=0;j<cols;j++) {
				if(parent.editor.RTEditor0.document.getElementById("table"+table_no) && parent.editor.RTEditor0.document.getElementById("table"+table_no+".rows["+rows+"]"))
					parent.editor.RTEditor0.document.getElementById("table"+table_no+".rows["+rows+"].insertCell()");
	  		}
		}
	}
}

function OrAllowPositiveNumber() {
   var key = window.event.keyCode;
   if( ! ( ( key>=48 ) && ( key<58 ) ) ) {
       return false;
   }
}

function OrAllowNumber() {
   var key = window.event.keyCode;
   if( ! ( ( key>=48 ) && ( key<58 ) ) ) {
       return false;
   }
}
function OrCheckNumber(obj) {
   var sequence = "0123456789";
   var obj_value = obj.value;
   var obj_length = obj_value.length;

   for (i=0; i<obj_length; i++)   {
        if(sequence.indexOf(obj_value.charAt(i))==-1){
			alert(parent.getMessage('ONLY_POSITIVE_NUM','OR'));
			obj.focus();
			return false;
		}
   }

   return true ;
}

//Table careation in Editor related functions -End

