var function_id	= "PH_TRACK_OUTSCOURCE_MEDICATION" ;
var result		= false ;
var message		= "" ;
var flag		= "" ;
var pswd_flag = "N";
var homepage="";

async function showLoginWindow(identityForSwitch, homepage, store_code){
	if(homepage!='Y' || store_code=='' || store_code == undefined){ //if condition and else block Added for Bru-HIMS-CRF-073.1 [IN:047222]
	var dialogHeight= "250px" ;
	var dialogWidth	= "500px" ;
	var dialogTop = "0" ;
	var center = "1" ;
	var status="no";
	var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop+";scroll:no";
	var arguments	= "" ;
		retVal = await top.window.showModalDialog("../../ePH/jsp/TrackingOutsourceMedicationLogin.jsp?identityForSwitch="+identityForSwitch+"&homepage="+homepage+"&store_code="+store_code,arguments,features);
		if(retVal=="GOHOME" || retVal == undefined){
			//history.go(-1);
			window.location.href = '../../eCommon/jsp/dmenu.jsp';
		}
		else{
			window.close();
			document.location.href ="../../ePH/jsp/TrackingOutsourceMedicationFrame.jsp";
		}
	}
	else{ //added for Bru-HIMS-CRF-073.1 [IN:047222] -start
		var retVal = '';
		var bean_id		= "TrackingOutsourceMedicationBean";
		var bean_name	= "ePH.TrackingOutsourceMedicationBean" ;
		var xmlDoc="";
		var xmlHttp = new XMLHttpRequest();
		xmlStr	="<root><SEARCH " ;
		xmlStr += " disp_locn_code=\"" + store_code + "\"";
		xmlStr += " homepage=\"" + homepage + "\"";
		xmlStr +=" /></root>" ;
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open( "POST", "TrackingOutsourceMedicationValidate.jsp?bean_id="+bean_id+"&bean_name="+bean_name+"&identity=validateLogin", false ) ;
		xmlHttp.send( xmlDoc ) ;
		eval(xmlHttp.responseText);
		if(retVal == 'GOQUERYCRITERIA'){
			document.location.href ="../../ePH/jsp/TrackingOutsourceMedicationFrame.jsp?homepage="+homepage;
		}
		else{
			alert(getMessage('ACCESS_DENIED',"PH"));
			parent.CommonToolbar.ShowMenu.click();
			parent.CommonToolbar.unLoadTitleName();
		}
	} //added for Bru-HIMS-CRF-073.1 [IN:047222] -end
}

function focusInToPassword(identityForSwitch){
	if(identityForSwitch!='Switch')
		document.getElementById("password").focus();
}

function uppercase() {
	key = window.event.keyCode;
	if((key>0x60) && (key< 0x7B))
		window.event.keyCode=key-0x20;
}

function goHome(){
	window.returnValue="GOHOME";
	window.close();
}

function proceedTracking(){

	var formObj = document.frmTrackingOutsourceMedicationLogin;
	var disp_locn = formObj.disp_locn.value;
	var password  = formObj.password.value;
	var disp_locn_name 	= formObj.disp_locn.options[formObj.disp_locn.selectedIndex].text;

	var fields  = new Array() ;
	var names   = new Array() ;

	if(password==""){
		fields[0]   = formObj.password ;
		names[0]   = getLabel("Common.password.label","Common");
	}
	else if(disp_locn=="") {
		fields[0]   = formObj.disp_locn ;
		names[0]   = getLabel("ePH.DispenseLocation.label","PH");
	}
	if(checkFlds( fields, names)){
		var bean_id		= formObj.bean_id.value ;
		var bean_name	= formObj.bean_name.value ;
		var xmlDoc="";
		var xmlHttp = new XMLHttpRequest();
		xmlStr	="<root><SEARCH " ;
		xmlStr += " password=\"" + password + "\"";
		xmlStr += " disp_locn_code=\"" + disp_locn + "\"";
		xmlStr += " disp_locn_name=\"" + encodeURIComponent(disp_locn_name,"UTF-8") + "\"";
		xmlStr +=" /></root>" ;
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open( "POST", "TrackingOutsourceMedicationValidate.jsp?bean_id="+bean_id+"&bean_name="+bean_name+"&identity=validateLogin", false ) ;
		xmlHttp.send( xmlDoc ) ;
		eval(xmlHttp.responseText);
		if(pswd_flag !="Y"){
			window.returnValue="PROCEED";
			window.close();
		}
		else{
			document.getElementById("password").focus();
		}
	}	
}

function checkFlds( fields, names) {
	var errors = "" ;
	for( var i=0; i<fields.length; i++ ) {
		if(trimCheck(fields[i].value)) {
			fields[i].value = trimString(fields[i].value);
		}
		else{
			errors = errors + "APP-000001 " + names[i] +getLabel("Common.Cannotbeblank.label","Common") +" ..." + "\n" ;
		}
	}
	if ( errors.length != 0 ) {
		alert(errors) ;
		return false ;
	}
	return true ;
}

function focusOnPasswordField(obj){
	pswd_flag = obj;
}

function create() {
	f_query_add_mod.location.href="../../ePH/jsp/TrackingOutsourceMedicationFrameSet.jsp?function_id="+function_id+"&mode="+MODE_INSERT+"&callFrom=RESULT&homepage="+homepage;
	//f_query_add_mod.location.reload();
}

function query() {
	f_query_add_mod.location.href="../../ePH/jsp/TrackingOutsourceMedicationQueryCriteria.jsp?function_id="+function_id+"&homepage="+homepage;
}

/*function apply() {
	messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num="+message;
	return false;
}*/

function reset() {
	queryURL = 	f_query_add_mod.location.href;
	if(queryURL.indexOf('Query')>0){
		if(queryURL.indexOf('Criteria')>0)
			f_query_add_mod.document.query_form.reset();
	}
	else{
		var formObj = f_query_add_mod.f_criteria.document.frmTrackingOutsourceMedicationCriteria
		formObj.reset();
		enableDisableCriteriaFields(formObj, false);
		formObj.commonOutSourceDtl.style.display = 'none';
		formObj.commonOutSourceDtlHR.style.display = 'none';
		f_query_add_mod.f_result.location.href = "../../eCommon/html/blank.html";
		//f_query_add_mod.f_button.location.href = "../../eCommon/html/blank.html";
	}
	messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num=";
}

function callCheckMaxLen(obj,noOfChars, frm) { 
	var val = obj.value;
	if(obj.value.length > noOfChars) {
		var msg = getMessage("REMARKS_CANNOT_EXCEED","Common");
		msg = msg.replace("$",getLabel("Common.remarks.label","common"));
		msg = msg.replace("#",noOfChars);
		obj.value = val.substring(0,noOfChars);
		alert(msg);
		if(frm == "blr")
			obj.select();
		return false;
	}
}

function changeAction(action){
	var formObj = document.frmTrackingOutsourceMedicationCriteria;
	formObj.trackingAction.value = action;
	formObj.remarks.value = "";
	document.getElementById("commonOutSourceDtl").style.display = 'none';
	document.getElementById("commonOutSourceDtlHR").style.display = 'none';
	if(action == 'S'){
		document.getElementById("refFacLblDisplay").style.display = 'none';
		document.getElementById("refFacDisplay").style.display = 'none';
		document.getElementById("refFacLblDisplaySend").style='display';
		document.getElementById("refFacDisplaySend").style='display';
	}
	else{
		document.getElementById("refFacLblDisplay").style='display';
		document.getElementById("refFacDisplay").style='display';
		document.getElementById("refFacLblDisplaySend").style.display = 'none';
		document.getElementById("refFacDisplaySend").style.display = 'none';
	}
	parent.f_result.location.href = "../../eCommon/html/blank.html";
	//parent.f_button.location.href = "../../eCommon/html/blank.html";
	parent.parent.messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num=";
	enableDisableCriteriaFields(formObj, false);
}

function CheckDateT(obj, locale){
	if(obj.value!=""){
		if(!validDate(obj.value, 'DMY',locale)){
			alert(getMessage("INVALID_DATE_FMT", "SM"));
			obj.select();
			obj.focus();
			return false;
		}
	}
	else{
		obj.value=convertDate(obj,'DMY',locale,'en');
	}
	return true;
}

async function callPatientSearch(callFrom){
	if(callFrom=='QUERY'){
		var formObj=document.frames.query_form;
	}
		
	else{
		//var formObj=document.frames.frmTrackingOutsourceMedicationCriteria;
		var formObj=document.frmTrackingOutsourceMedicationCriteria;
	}
		
	var patient_id = formObj.patient_id.value
	if(patient_id == ""){
		patient_id=await PatientSearch();//added for ICN_ADHOC_025 start
		if(patient_id!=undefined && patient_id!=null)
			formObj.patient_id.value = patient_id;//added for ICN_ADHOC_025 end
	}
}

async function searchDrugName(callFrom){
	if(callFrom=='QUERY')
		var formObj=document.frames.query_form;
	else
		var formObj=document.frmTrackingOutsourceMedicationCriteria;
	locale =formObj.language_id.value;
	var argumentArray  = new Array();
	var dataNameArray  = new Array();
	var dataValueArray = new Array();
	var dataTypeArray  = new Array();
	var drugLookupSql = formObj.drugLookupSql.value+ "'"+locale+"'"+' order by 2' ;
	argumentArray[0]	= drugLookupSql;
	argumentArray[1]   = dataNameArray ;
	argumentArray[2]   = dataValueArray ;
	argumentArray[3]   = dataTypeArray ;
	argumentArray[4]   = "1,2";
	argumentArray[5]   = formObj.drug_name.value ;
	argumentArray[6] = DESC_LINK ;
	argumentArray[7] = CODE_DESC ;
	retVal =await CommonLookup(getLabel("Common.search.label","Common"), argumentArray);
	formObj.drug_code.value="";
	formObj.drug_name.value="";

	var ret1=unescape(retVal);
	var arr=ret1.split(",");
		 	if(arr[1]==undefined) 
	 		{
		 		arr[0]="";	
		 		arr[1]="";	
	 		}
	if(retVal != null && retVal != "") {
		formObj.drug_code.value = arr[0];
		formObj.drug_name.value =arr[1] ;
	}
}

function switchToLogin(){
	var formObj=document.frmTrackingOutsourceMedicationCriteria;
	var sourceURL = formObj.sourceURL.value;
	parent.parent.document.location.href="../../ePH/jsp/TrackingOutsourceMedication.jsp?identityForSwitch=Switch&source="+sourceURL;
}

function getResult(){
	var formObj=document.frmTrackingOutsourceMedicationCriteria;
	var trackingAction = formObj.trackingAction.value;
	var tracking_ref_facility = formObj.TRACKING_REF_FACILITY.value;
	var order_date_from = formObj.order_date_from.value;
	var order_date_to = formObj.order_date_to.value;
	var patient_id = formObj.patient_id.value;
	var order_type = formObj.order_type.options[formObj.order_type.selectedIndex].value;
	var locale = formObj.language_id.value;

	parent.parent.messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num=";
	//var errorPage	= "../../eCommon/jsp/MstCodeError.jsp?" ;
	var fields	= new Array ( formObj.order_date_from , formObj.order_date_to );
	var names	= new Array ( getLabel("Common.OrderDateFrom.label","Common"), getLabel("Common.OrderDate.label","Common")+getLabel("Common.to.label","Common"));
	if(trackingAction!='S'){
		fields[2] = formObj.TRACKING_REF_FACILITY;
		names[2] = getLabel("Common.ReferralFacility.label","Common");
	}
	blankObject  = checkFields( fields, names, parent.parent.messageFrame, 'N') ;
	//blankObject  = checkField( fields, names) ;
	if(!blankObject) {
		return false;
	}
	if(!isAfter(order_date_to,order_date_from, "DMY", locale)){
		parent.parent.messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num="+ getMessage("TO_DATE_EQUAL_GREATER_FROM_DATE", "PH");
		return false;
	}
	var drug_code = formObj.drug_code.value;
	var bean_id		= formObj.bean_id.value ;
	var bean_name	= formObj.bean_name.value ;
	var xmlDoc="";
	var xmlHttp = new XMLHttpRequest();
	xmlStr	="<root><SEARCH " ;
	xmlStr += " trackingAction=\"" + trackingAction + "\"";
	//xmlStr += " order_date_from=\"" + order_date_from + "\"";
	//xmlStr += " order_date_to=\"" + order_date_to + "\"";
	//xmlStr += " patient_id=\"" + patient_id + "\"";
	xmlStr += " tracking_ref_facility=\"" + tracking_ref_facility + "\"";
	xmlStr += " order_type=\"" + order_type + "\"";
	xmlStr +=" /></root>" ;
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open( "POST", "TrackingOutsourceMedicationValidate.jsp?bean_id="+bean_id+"&bean_name="+bean_name+"&identity=getResult", false ) ;
	xmlHttp.send( xmlDoc ) ;
	eval(xmlHttp.responseText);
	parent.f_result.location.href = "../../ePH/jsp/TrackingOutsourceMedicationResult.jsp?trackingAction="+trackingAction+"&order_date_from="+order_date_from+"&order_date_to="+order_date_to+"&patient_id="+patient_id+"&drug_code="+drug_code+"&order_type="+order_type+"&called_from=getResult";
}

function enableDisableCriteriaFields(formObj, disable){
	trackingAction = formObj.trackingAction.value;
	formObj.trackingAction.diasbled = disable;
	if(trackingAction!='S')
		formObj.TRACKING_REF_FACILITY.disabled= disable;
	formObj.order_date_from.disabled= disable;
	formObj.CalendarFromDate.disabled= disable;
	formObj.order_date_to.disabled= disable;
	formObj.CalendarToDate.disabled= disable;
	formObj.patient_id.disabled= disable;
	formObj.btnPatientID.disabled= disable;
	formObj.drug_name.disabled= disable;
	formObj.drug_search.disabled= disable;
	formObj.order_type.disabled= disable;
}

function displayResult(display, called_from,trackingAction){
	if(called_from == 'getResult'){
		if(display=='Y' ){
			if(trackingAction!='D')
				parent.f_criteria.document.getElementById("commonOutSourceDtl").style='display';

			parent.f_criteria.document.getElementById("commonOutSourceDtlHR").style='display';
			//parent.f_button.location.href = "../../ePH/jsp/TrackingOutsourceMedicationButton.jsp?trackingAction="+trackingAction+"&callFrom=RESULT";
			enableDisableCriteriaFields(parent.f_criteria.document.frmTrackingOutsourceMedicationCriteria, true);
		}
		else{
			parent.f_criteria.document.getElementById("commonOutSourceDtl").style.display='none';
			parent.f_criteria.document.getElementById("commonOutSourceDtlHR").style.display='none';
			//parent.f_button.location.href = "./../eCommon/html/blank.html";
			enableDisableCriteriaFields(parent.f_criteria.document.frmTrackingOutsourceMedicationCriteria, false);
		}
		parent.f_criteria.document.frmTrackingOutsourceMedicationCriteria.remarks.value="";
		outsourcing_ref_facility = parent.f_criteria.document.frmTrackingOutsourceMedicationCriteria.defFacilicty.value;
		if(trackingAction=='S' && outsourcing_ref_facility!=""){
			parent.f_criteria.document.frmTrackingOutsourceMedicationCriteria.OUTSOURCING_REF_FACILITY.value=parent.f_criteria.document.frmTrackingOutsourceMedicationCriteria.defFacilicty.value
		}
	}
}

async function showDrugProfile(patient_id,disp_locn_code){
	var dialogHeight	= "84vh" ;
	var dialogWidth		= "71vw" ;
	var dialogTop		= "0" ;
	var center			= "1" ;
	var status			= "no";
	var features		= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop;
	var arguments		= "" ;
	retVal				=await top.window.showModalDialog( "../../ePH/jsp/QueryPatientDrugProfileFrames.jsp?patient_id="+patient_id+"&called_frm=Prescription&disp_locn_code="+disp_locn_code, arguments, features );
}

async function callMenuFunctions(colval1,colval,patient_id,encounter_id,orderId,order_line_num,order_status,cont_order_ind,ord_cat,catalog_code,generic_id,sex,ord_typ_code,source_accession_type){

	var dialogHeight   = "90vh" ;
	var dialogWidth    = "70vw" ;
	var dialogTop	   = '0';
	var dialogLeft     = '8' ;		
	var title = 'rewe'
	var features = 'dialogHeight:' + dialogHeight + '; dialogWidth:' + dialogWidth +';dialogTop:'+dialogTop+';dialogLeft:'+dialogLeft+';dialogTitle:'+title+'; scroll=yes; status=no';
	var arguments = "";
	var finalString	= "from=line&colval1="+colval1+"&colval="+colval+"&orderId="+orderId+"&val1="+ord_cat+"&patient_id="+patient_id+"&cont_order_ind="+cont_order_ind+"&order_status="+order_status+"&sex="+sex+"&ord_cat="+colval+"&ord_typ_code="+ord_typ_code+"&catalog_code="+catalog_code+"&ord_cat_id="+ord_cat+"&source_accession_type="+source_accession_type+"&order_line_num="+order_line_num+"&catalog_code="+catalog_code;
	var retVals =await top.window.showModalDialog("../../eOR/jsp/ExistingOrderTasks.jsp?"+finalString,arguments,features);
}

function selectDrug(obj, index){
	var formObj=document.frmTrackingOutsourceMedicationResult;
	var trackingAction = formObj.trackingAction.value;
	var selectYN  ="N";
	var selectedCount = formObj.selectedCount.value
	if(obj.checked == true){
		selectYN= "Y";
		selectedCount = parseInt(selectedCount)+1;
	}
	else{
		selectedCount = parseInt(selectedCount)-1;
	}
	obj.value=selectYN;
	formObj.selectedCount.value = selectedCount;

	var bean_id		= formObj.bean_id.value ;
	var bean_name	= formObj.bean_name.value ;
	var patientId = eval("formObj.patientId"+index).value;
	var orderId  = eval("formObj.orderId"+index).value;
	var orderLineNum  = eval("formObj.orderLineNum"+index).value;
	var outsourceId = eval("formObj.outsourceId"+index).value;
	var xmlDoc="";
	var xmlHttp = new XMLHttpRequest();
	xmlStr	="<root><SEARCH " ;
	xmlStr += " patientId=\"" + patientId + "\"";
	xmlStr += " orderId=\"" + orderId + "\"";
	xmlStr += " orderLineNum=\"" + orderLineNum + "\"";
	xmlStr += " selectYN=\"" + selectYN + "\"";
	xmlStr += " outsourceId=\"" + outsourceId + "\"";
	xmlStr += " trackingAction=\"" + trackingAction + "\"";
	xmlStr += " index=\"" + index + "\"";
	xmlStr +=" /></root>" ;
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open( "POST", "TrackingOutsourceMedicationValidate.jsp?bean_id="+bean_id+"&bean_name="+bean_name+"&identity=selectDrug", false ) ;
	xmlHttp.send( xmlDoc ) ;
	eval(xmlHttp.responseText);
	recCount= formObj.recCount.value;
}

function selectALL(obj){
	var selectYN  ="N";
	var formObj=document.frmTrackingOutsourceMedicationResult;
	var recCount = formObj.recCount.value;
	if(obj.checked == true)
		selectYN= "Y";
	obj.value=selectYN;
	for(i=1; i <=parseInt(recCount); i++){
		selectObj =  eval("formObj.select"+i);
		if(obj.checked != selectObj.checked){
			selectObj.click();
			selectObj.value = obj.value;
		}
	}
}

function SubmitLinkOutSource(from,to){
	var formObj				=	document.frmTrackingOutsourceMedicationResult;
	trackingAction = formObj.trackingAction.value;
	if(trackingAction =='D'){
		if(!storeDeliverDetails(formObj))
			return false;
	}
	formObj.from.value	=	from;
	formObj.to.value =	to;
	formObj.submit();
}

function storeDeliverDetails(formObj){
	var selectCount=0;
	var bean_id		= formObj.bean_id.value ;
	var bean_name	= formObj.bean_name.value ;
	var xmlDoc="";
	var xmlHttp = new XMLHttpRequest();
	xmlStr	="<root><SEARCH " ;
	var recCount = formObj.recCount.value;
	for(i=1; i <=parseInt(recCount); i++){
		selectYN =  eval("formObj.select"+i).value;
		outsourceId = eval("formObj.outsourceId"+i).value;
		orderId = eval("formObj.orderId"+i).value;
		orderLineNum = eval("formObj.orderLineNum"+i).value;
		if(selectYN=='Y'){
			deliverSource = eval("formObj.deliverSource"+i).value;
			deliverSourceCode = eval("formObj.deliverSourceCode"+i).value;
			deliverToInd  = eval("formObj.deliverToIndr"+i).value;
			deliverTo  = eval("formObj.deliverTo"+i).value;
			deliverToName = eval("formObj.deliverToName"+i).value;
			if(deliverSourceCode == "" || trimString(deliverSource)==""){ 
				msg = getMessage("CAN_NOT_BE_BLANK","Common");
				msg = msg.replace('$', getLabel("Common.Location.label","common"));
				alert(msg);
				eval("formObj.deliverSource"+i).focus();
				return false;
			}
			else if(deliverToInd =='L' &&  deliverTo ==""){
				msg = getMessage("CAN_NOT_BE_BLANK","Common");
				msg = msg.replace('$', getLabel("ePH.Deliver.label","PH")+" "+getLabel("Common.to.label","common"));
				alert(msg);
				return false;
			}
			else if(deliverToInd =='O' &&  deliverTo ==""){
				msg = getMessage("CAN_NOT_BE_BLANK","Common");
				msg = msg.replace('$', getLabel("ePH.Deliver.label","PH")+" "+getLabel("Common.to.label","common"));
				alert(msg);
				return false;
			}
			xmlStr += " deliverSource"+selectCount+"=\"" + deliverSource + "\"";
			xmlStr += " deliverSourceCode"+selectCount+"=\"" + deliverSourceCode + "\"";
			xmlStr += " deliverToInd"+selectCount+"=\"" + deliverToInd + "\"";
			xmlStr += " deliverTo"+selectCount+"=\"" + deliverTo + "\"";
			xmlStr += " deliverToName"+selectCount+"=\"" + deliverToName + "\"";
		}
		xmlStr += " selectYN"+selectCount+"=\"" + selectYN + "\"";
		xmlStr += " outsourceId"+selectCount+"=\"" + outsourceId + "\"";
		xmlStr += " orderId"+selectCount+"=\"" + orderId + "\"";
		xmlStr += " orderLineNum"+selectCount+"=\"" + orderLineNum + "\"";
		selectCount++;
	}
	xmlStr += " selectCount=\"" + selectCount + "\"";
	xmlStr +=" /></root>" ;
	if(selectCount>0){
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open( "POST", "TrackingOutsourceMedicationValidate.jsp?bean_id="+bean_id+"&bean_name="+bean_name+"&identity=storeDeliverDetails", false ) ;
		xmlHttp.send( xmlDoc ) ;
		eval(xmlHttp.responseText);
	}
	return true;
}
	
//function callOutsourceAction(trackingAction){
function apply(){
	queryURL = 	f_query_add_mod.location.href;
	if(queryURL.indexOf('Query')>0){
		messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num=";
		return false
	}

	var formObj=f_query_add_mod.f_criteria.document.frmTrackingOutsourceMedicationCriteria;
	resultURL = f_query_add_mod.f_result.location.href;
	if(resultURL.indexOf('blank')>0){
		message = getMessage("NO_RECORDS_HAVE_BEEN_SELECTED", "PH") ;
		messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num="+message;
		return false
	}
	var formObjResult=f_query_add_mod.f_result.document.frmTrackingOutsourceMedicationResult;
	var trackingAction = formObjResult.trackingAction.value;
	messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num=";
	if(trackingAction!='D'){
		formObj.mode.value='2';
		if(trackingAction=='S'){
			var fields	= new Array ( formObj.OUTSOURCING_REF_FACILITY  ); //, formObj.remarks
			formObj.mode.value='1';
			var names	= new Array ( getLabel("Common.ReferralFacility.label","Common") );// , getLabel("Common.remarks.label","Common")
			blankObject  = checkFields( fields, names, messageFrame, 'N') ;
			if(!blankObject) {
				return false;
			}
		}
		/*else {
			var fields	= new Array ( formObj.TRACKING_REF_FACILITY , formObj.remarks);
		}*/
		if(formObj.remarks.value !=""){
			var bean_id		= formObj.bean_id.value ;
			var bean_name	= formObj.bean_name.value ;
			var xmlDoc="";
			var xmlHttp = new XMLHttpRequest();
			var remarks = encodeURIComponent(formObj.remarks.value,"UTF-8");
			xmlStr	="<root><SEARCH " ;
			xmlStr += " remarks=\"" + remarks + "\"";
			xmlStr +=" /></root>" ;
			xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
			xmlHttp.open( "POST", "TrackingOutsourceMedicationValidate.jsp?bean_id="+bean_id+"&bean_name="+bean_name+"&identity=storeRemarks", false ) ;
			xmlHttp.send( xmlDoc ) ;
			eval(xmlHttp.responseText);
		}
	}
	else if(trackingAction=='D'){
		formObj.mode.value='2';
		if(!storeDeliverDetails(formObjResult)){
			return false;
		}
	}

	var bean_id		= formObj.bean_id.value ;
	var bean_name	= formObj.bean_name.value ;
	var xmlDoc="";
	var xmlHttp = new XMLHttpRequest();
	var remarks = encodeURIComponent(formObj.remarks.value,"UTF-8");
	xmlStr	="<root><SEARCH " ;
	xmlStr +=" /></root>" ;
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open( "POST", "TrackingOutsourceMedicationValidate.jsp?bean_id="+bean_id+"&bean_name="+bean_name+"&identity=getUpdateRecCount", false ) ;
	xmlHttp.send( xmlDoc ) ;
	retVal = eval(xmlHttp.responseText);
	count = formObj.updateRecCount.value;
	if(isNaN(count) == true || parseInt(count)<1){
		message = getMessage("PH_ATLEAST_ONE_SELECTED", "PH") ;
		messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num="+message;
		return false;
	}
	eval(formApply( formObj,PH_CONTROLLER ));
	if( result ){
		var homePage = formObj.homepage.value; //added for  Bru-HIMS-CRF-073.1 [IN:047222]
		if(homePage=='Y' && trackingAction=='D'){  //added for  Bru-HIMS-CRF-073.1 [IN:047222]
			parent.menuFrame.document.location.reload();
		}
		onSuccess();
	}
	else {
		messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num="+message;
		return false;
	}
}

function assignUpdateRecCount(count){
	var formObj=f_query_add_mod.f_criteria.document.frmTrackingOutsourceMedicationCriteria;
	formObj.updateRecCount.value = count;
}

function assignResult( _result, _message, _flag ) {
	result = _result ;
	message  = _message ;
	flag = _flag ;
}

function onSuccess() {	
	messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num="+message;
	create();
}

async function viewSentDtls(index){
	var formObj = document.frmTrackingOutsourceMedicationResult;
	var outsourced_pract_name = eval("formObj.outsourced_pract_name"+index).value;
	var outsourced_date = eval("formObj.outsourced_date"+index).value;
	var remarks = eval("formObj.remarks"+index).value;
	var dialogHeight= "40vh" ;
	var dialogWidth	= "40vw" ;
	var dialogTop	= "225" ;
	var dialogLeft	= "350" ;
	var center		= "1" ;
	var status		= "no";
	var scroll		= "auto";
	var features	= "dialogLeft:" + dialogLeft + ";dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; center: " + center + ";scroll "+scroll+"; status: " + status + "; dialogTop :" + dialogTop;
	var arguments	= "" ;
	retVal =await top.window.showModalDialog("../../ePH/jsp/TrackingOutsourceMedicationFrameSet.jsp?callFrom=SENTDTL&outsourced_pract_name="+outsourced_pract_name+"&outsourced_date="+outsourced_date+"&remarks="+remarks,arguments,features);
}

async function editReceiveDtls(index ){
	var formObj = document.frmTrackingOutsourceMedicationResult;
	var trackingAction = formObj.trackingAction.value;
	if(trackingAction!='R')
		return;
	var outsourceId = eval("formObj.outsourceId"+index).value;
	var facility_id = eval("formObj.facility_id"+index).value;
	var orderId = eval("formObj.orderId"+index).value;
	var orderLineNum = eval("formObj.orderLineNum"+index).value;
	var selectedYN = eval("formObj.select"+index);
	var dialogHeight= "90vh" ;
	var dialogWidth	= "60vw" ;
	var dialogTop	= "0" ;
	var dialogLeft	= "200" ;
	var center		= "1" ;
	var status		= "no";
	var scroll		= "auto";
	var features	= "dialogLeft:" + dialogLeft + ";dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; center: " + center + ";scroll "+scroll+"; status: " + status + "; dialogTop :" + dialogTop;
	var arguments	= "" ;
	retVal =await top.window.showModalDialog("../../ePH/jsp/TrackingOutsourceMedicationFrameSet.jsp?callFrom=EDITRECEIVEDDTL&outsourceId="+outsourceId+"&facility_id="+facility_id+"&orderId="+orderId+"&orderLineNum="+orderLineNum,arguments,features);
	if(retVal==undefined || retVal!='OK'){
		if(selectedYN.checked == true)
			checkForReceivedDtls(outsourceId,orderId, orderLineNum, index)
	}
	else{
		selectRecord(index,true);
	}
}

async function viewOutsourceDtls(outsourceId, orderId , orderLineNum, status){
/*	var formObj = document.frmTrackingOutsourceMedicationResult;
	var outsourceId = eval("formObj.outsourceId"+index).value;
	var facility_id = eval("formObj.facility_id"+index).value;
	var orderId = eval("formObj.orderId"+index).value;
	var orderLineNum = eval("formObj.orderLineNum"+index).value;*/
	var dialogHeight= "46vh" ;
	var dialogWidth	= "45vw" ;
	var dialogTop	= "225" ;
	var dialogLeft	= "350" ;
	if(status == 'SE'){
		dialogHeight= "17" ;
		dialogWidth	= "35" ;
	}
	var center		= "1" ;
	var status		= "no";
	var scroll		= "auto";
	var features	= "dialogLeft:" + dialogLeft + ";dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; center: " + center + ";scroll "+scroll+"; status: " + status + "; dialogTop :" + dialogTop;
	var arguments	= "" ;
	retVal = await window.showModalDialog("../../ePH/jsp/TrackingOutsourceMedicationFrameSet.jsp?callFrom=VIEWOUTSOURCEDTL&outsourceId="+outsourceId+"&orderId="+orderId+"&orderLineNum="+orderLineNum,arguments,features);
}

function searchLocation(index, calledFrom){
	var formObj=document.frmTrackingOutsourceMedicationResult;
	var sourceType = eval("formObj.sourceType"+index).value;
	var  deliverSource= eval("formObj.deliverSource"+index);
	var  deliverSourceCode= eval("formObj.deliverSourceCode"+index);
	if(calledFrom=='TEXT' && trimString(deliverSource.value) ==""){
		deliverSourceCode.value ="" ;
		deliverSource.value = "";
		return false;
	}
	locale =formObj.language_id.value;
	var argumentArray  = new Array();
	var dataNameArray  = new Array();
	var dataValueArray = new Array();
	var dataTypeArray  = new Array();
	var  sourceLookupSql="";
	if(sourceType=='C')
		sourceLookupSql = formObj.opLocnLookupSql.value ;
	else
		sourceLookupSql = formObj.ipLocnLookupSql.value ;
	/*dataNameArray[0] ="facility_id";
	dataValueArray[0]= formObj.login_facility_id.value;
	dataTypeArray[0] = STRING;

	dataNameArray[1] ="locale";
	dataValueArray[1]= locale;
	dataTypeArray[1] = STRING;*/
	argumentArray[0]	= sourceLookupSql;
	argumentArray[1]   = dataNameArray ;
	argumentArray[2]   = dataValueArray ;
	argumentArray[3]   = dataTypeArray ;
	argumentArray[4]   = "1,2";
	argumentArray[5]   = deliverSource.value ;
	argumentArray[6] = DESC_LINK ;
	argumentArray[7] = CODE_DESC ;
	retVal = CommonLookup(getLabel("Common.search.label","Common"), argumentArray);
	deliverSourceCode.value ="" ;
	deliverSource.value = "";
	if(retVal != null && retVal != "") {
		deliverSourceCode.value =retVal[0] ;
		deliverSource.value = retVal[1];
	}
}

function changeDeliverTo(obj,index){
	var formObj=document.frmTrackingOutsourceMedicationResult;
	var deliverTo = eval("formObj.deliverTo"+index);
	var deliverToName = eval("formObj.deliverToName"+index);
	var deliverOthers = eval(document.getElementById("deliverOthers"+index));
	var deliverToIndr = eval(document.getElementById("deliverToIndr")+index);
	deliverOthers.title ="";
	if(obj.value == 'P'){
		deliverTo.value = eval("formObj.patientId"+index).value;
		deliverToIndr.value='P';
	}
	else if(obj.value == 'L'){
		deliverTo.value = eval("formObj.deliverSourceCode"+index).value;
		deliverToIndr.value='L';
	}
	else if(obj.value == 'O'){
		deliverTo.value = "";
		deliverToName.value ="";
		deliverToIndr.value='O';
		var argumentArray  = new Array();
		var dataNameArray  = new Array();
		var dataValueArray = new Array();
		var dataTypeArray  = new Array();
		var userLookupSql = formObj.userLookupSql.value
		argumentArray[0]	= userLookupSql;
		argumentArray[1]   = dataNameArray ;
		argumentArray[2]   = dataValueArray ;
		argumentArray[3]   = dataTypeArray ;
		argumentArray[4]   = "1,2";
		argumentArray[5]   = "" ;
		argumentArray[6] = DESC_LINK ;
		argumentArray[7] = CODE_DESC ;
		retVal = CommonLookup(getLabel("Common.search.label","Common"), argumentArray);
		if(retVal != null && retVal != "") {
			deliverTo.value = retVal[0];
			deliverToName.value =retVal[1] ;
			deliverOthers.title = getLabel("ePH.Deliver.label","PH")+getLabel("Common.to.label","Common")+": "+retVal[0]+" / "+ retVal[1];
		}
	}
}

function toUpper(obj) {
	obj.value=obj.value.toUpperCase();
}

function changeCursor(obj) {
	obj.style.cursor = "pointer";
}
function addIngredient(prodNum, ingNum){
	if(validateCurrentIngnt(prodNum, ingNum)){
		generateIngnt(prodNum, ingNum);
	}
}

function validateCurrentIngnt(prodNum, ingNum){
	formObj		= parent.f_details.document.frmTrackingOutsourceMedicationActionDtls;
	var ingredient = eval("formObj.ingredient"+prodNum+"_"+ingNum);
	if(ingredient.value==""){
		alert(getMessage("PH_INGREDIANT_CAN_NOT_BLANK", "PH"));
		ingredient.focus();
		return false;
	}
	else{
		ingntCount= eval("formObj.noOfIngnts"+prodNum).value;
		for(ing=0 ; ing<parseInt(ingntCount); ing++){
			ingnt= eval("formObj.ingredient"+prodNum+"_"+ing).value;
			for(inext=(ing+1) ; inext<parseInt(ingntCount); inext++){
				nextingnt= eval("formObj.ingredient"+prodNum+"_"+inext).value;
				if(nextingnt !="" && nextingnt == ingnt){
					alert(getMessage("PH_DUP_INGREDIANT_NOT_ALLOWED","PH"));
					eval("formObj.ingredient"+prodNum+"_"+inext).focus();
					return false;
				}
			}
		}
	}
	return true;
}

function generateIngnt( prodNum, ingNum){
	var ingTable = document.getElementById('IngredientDtls'+prodNum);
	var rwid=parseInt(ingNum)+1;
	var row = ingTable.insertRow(rwid);
	var noOfIngnts = eval("document.frmTrackingOutsourceMedicationActionDtls.noOfIngnts"+prodNum).value;
	noOfIngnts = parseInt(noOfIngnts)+1;
	eval("document.frmTrackingOutsourceMedicationActionDtls.noOfIngnts"+prodNum).value = noOfIngnts;
	var maxIngCount = document.frmTrackingOutsourceMedicationActionDtls.maxIngredientCount.value
	var oCell = "";

	oCell = row.insertCell(0);
	oCell.className='label';
	label = " ";
	oCell.innerHTML="<td class='label'>&nbsp;</td>";

	oCell = row.insertCell(1);
	oCell.className='label';
	//oCell.innerHTML="<td class='label'>&nbsp;<input type='text' name='ingredient"+prodNum+"_"+ingNum+"' id='ingredient"+prodNum+"_"+ingNum+"'  maxlength='60' ></td>";

	if(parseInt(rwid) == (parseInt(maxIngCount)-1))
		oCell.innerHTML="<td class='label'><input type='text' name='ingredient"+prodNum+"_"+rwid+"' id='ingredient"+prodNum+"_"+rwid+"'  maxlength='60' size='62' >&nbsp;<img src='../../eCommon/images/disabled.gif'  onMouseOver='changeCursor(this)' onclick='deleteIngredient("+prodNum+","+rwid+")' id='deleteIngredient"+prodNum+"_"+rwid+"'></td>";
	else

		oCell.innerHTML="<td class='label'><input type='text' name='ingredient"+prodNum+"_"+rwid+"' id='ingredient"+prodNum+"_"+rwid+"'  maxlength='60' size='62'>&nbsp;<img src='../../eCommon/images/nolines_plus.gif'  onMouseOver='changeCursor(this)' onclick='addIngredient("+prodNum+","+rwid+")' id='addIngredient"+prodNum+"_"+rwid+"'>&nbsp;<img src='../../eCommon/images/disabled.gif'  onMouseOver='changeCursor(this)' onclick='deleteIngredient("+prodNum+","+rwid+")' id='deleteIngredient"+prodNum+"_"+rwid+"'></td>";
	eval(document.getElementById("addIngredient"+prodNum+"_"+ingNum)).style.display = "none";
	if(ingNum != 0)
		eval(document.getElementById("deleteIngredient"+prodNum+"_"+ingNum)).style.display = "none";
}

function deleteIngredient(prodNum, ingNum) {
	var ingTable = document.getElementById('IngredientDtls'+prodNum);
	//var rwid=obj.parentNode.parentNode.rowIndex;
	ingTable.deleteRow(ingNum);
	currentRow = parseInt(ingNum)-1;
	eval("document.frmTrackingOutsourceMedicationActionDtls.noOfIngnts"+prodNum).value = currentRow;
	eval(document.getElementById("addIngredient"+prodNum+"_"+currentRow)).style="display";
	if(currentRow != 0)
		eval(document.getElementById("deleteIngredient"+prodNum+"_"+currentRow)).style="display";
}

function addProduct(prodNum){
	if(validateCurrentProduct(prodNum)){
		generateProduct(prodNum);
	}
}

function validateCurrentProduct(rowNum){
	formObj			= parent.f_details.document.frmTrackingOutsourceMedicationActionDtls;
	productId		= eval("formObj.productId"+rowNum).value;
	productName		= eval("formObj.productName"+rowNum).value;
	batchId		= eval("formObj.batchId"+rowNum).value;
	expiryDate		= eval("formObj.expiryDate"+rowNum).value;
	quantity		= eval("formObj.quantity"+rowNum).value;
	quantityUOM		= eval("formObj.quantityUOM"+rowNum).value;
	msg = getMessage("CAN_NOT_BE_BLANK","Common");
	if(productId=="" ){
		msg = msg.replace('$' ,getLabel("ePH.ProductID.label", "PH"));
		alert(msg);
		eval("formObj.productId"+rowNum).focus();
		return false
	}
	else if(productName==""){
		msg = msg.replace('$' ,getLabel("Common.ProductName.label", "Common"));
		alert(msg);
		return false
	}
	else if(batchId==""){
		msg = msg.replace('$' ,getLabel("Common.BatchID.label", "Common"));
		alert(msg);
		eval("formObj.batchId"+rowNum).focus();
		return false
	}
	else if(expiryDate==""){
		msg = msg.replace('$' ,getLabel("Common.expiryDate.label", "Common"));
		alert(msg);
		eval("formObj.expiryDate"+rowNum).focus();
		return false
	}
	else if(quantity=="" || parseInt(quantity)<1){
		msg = getMessage("PH_NOT_BLANK_ZERO_COMMON","PH");
		msg = msg.replace('$' ,getLabel("Common.Quantity.label", "Common"));
		alert(msg);
		eval("formObj.quantity"+rowNum).focus();
		return false;
	}
	else if(quantityUOM==""){
		msg = msg.replace('$' ,getLabel("Common.Quantity.label", "Common")+" "+getLabel("Common.uom.label", "Common"));
		alert(msg);
		eval("formObj.quantityUOM"+rowNum).focus();
		return false;
	}
	return true;
}


function generateProduct(prodNum) {
	var prodTable = document.getElementById('OutsourceMedicationActionDtls');
	var rwid=parseInt(prodNum)+1;
	var row = prodTable.insertRow(rwid);
	var productCount = document.frmTrackingOutsourceMedicationActionDtls.noOfProducts.value;
	productCount = parseInt(productCount)+1;
	document.frmTrackingOutsourceMedicationActionDtls.noOfProducts.value = productCount;
	var maxProductCount = document.frmTrackingOutsourceMedicationActionDtls.maxProductCount.value
	var locale = document.frmTrackingOutsourceMedicationActionDtls.locale.value
	var oCell = "";
	var tx_htmlText=""

	oCell = row.insertCell(0);
	oCell.className='label';
	tx_htmlText="<br><tr><td><table cellpadding='0' cellspacing='0' width='100%' align='center' border='0' id='productDtls"+rwid+"'>";
	tx_htmlText+="<tr> <td colspan='2'>&nbsp;</td></tr>";
	tx_htmlText+="<tr> <td class='label' width='30%'>"+getLabel("ePH.ProductID.label","PH")+"&nbsp;"+(parseInt(rwid)+1) +"</td>";
	tx_htmlText+="<td class='label' width='70%'><input type='text' name='productId"+rwid+"' id='productId"+rwid+"' value='' maxlength='20' size='20' onBlur='toUpper(this);checkForSplChars(this);' onKeyPress='return CheckForSpecChars(event);'>&nbsp;<img src='../../eCommon/images/mandatory.gif'></img></td></tr>";
	tx_htmlText+="<tr> <td class='label'>"+getLabel("Common.ProductName.label", "Common")+"</td>";
	tx_htmlText+="<td class='label'><input type='text' name='productName"+rwid+"' id='productName"+rwid+"' value='' maxlength='60' size='62'>&nbsp;<img src='../../eCommon/images/mandatory.gif'></img></td>	</tr>";
	tx_htmlText+="<tr> <td class='label'>"+getLabel("Common.BatchID.label", "Common")+"</td>";
	tx_htmlText+="<td class='label'><input type='text' name='batchId"+rwid+"' id='batchId"+rwid+"' value='' maxlength='60' size='50' onBlur='toUpper(this);checkForSplChars(this);' onKeyPress='return CheckForSpecChars(event);'>&nbsp;<img  src='../../eCommon/images/mandatory.gif'></img></td> </tr>";
	tx_htmlText+="<tr> <td class='label' >"+getLabel("Common.expiryDate.label", "Common")+"</td>";
	tx_htmlText+="<td class='label' ><input type='text' name='expiryDate"+rwid+"' id='expiryDate"+rwid+"' size='12' maxlength='10' value='' onblur='checkForExpiryDate(this,\""+locale+"\");'><IMG SRC='../../eCommon/images/CommonCalendar.gif' id='CalExpiryDate"+rwid+"' onclick='showCalendar(\"expiryDate"+rwid+"\"); document.frmTrackingOutsourceMedicationActionDtls.expiryDate"+rwid+".focus();return false;'>&nbsp;<img  src='../../eCommon/images/mandatory.gif'></img></td></tr>";
	tx_htmlText+="<tr> <td class='label'>"+getLabel("Common.Quantity.label", "Common")+"</td>";
	tx_htmlText+="<td class='label'><input type='text' class='NUMBER'  onKeyPress='return allowValidNumber(this,event,8,2);' name='quantity"+rwid+"' id='quantity"+rwid+"' value='' maxlength='5' size='5'>&nbsp;<input type='text' name='quantityUOM"+rwid+"' id='quantityUOM"+rwid+"' value='' maxlength='20' size='50'>&nbsp;<img  src='../../eCommon/images/mandatory.gif'></img></td> </tr>";
	tx_htmlText+="<tr> <td colspan='2'> <table cellpadding='0' cellspacing='0' width='99%' align='center' border='0' id='IngredientDtls"+rwid+"'> <tr> <td class='label' width='30%'>Ingredients</td>"; //+getLabel("ePH.Ingredients.label","PH")+" </td>";
	tx_htmlText+="<td class='label' ><input type='text' name='ingredient"+rwid+"_0' id='ingredient"+rwid+"_0' value='' maxlength='60' size='62'>&nbsp;<img src='../../eCommon/images/nolines_plus.gif' onMouseOver='changeCursor(this);' onclick='addIngredient(\""+rwid+"\",\"0\");' id='addIngredient"+rwid+"_0'></td></tr></table></td></tr> ";
	//tx_htmlText+="<img src='../../eCommon/images/nolines_plus.gif' onMouseOver='changeCursor(this);' onclick='addIngredient(\""+rwid+"\",\"0\");' id='addIngredient"+rwid+"_0'>&nbsp;<img src='../../eCommon/images/disabled.gif' onMouseOver='changeCursor(this);' onclick='deleteIngredient(\""+rwid+"\",\"0\");' id='deleteIngredient"+rwid+"_0'> </td></tr></table></td></tr> ";
	//tx_htmlText+="<tr> <td class='label'>"+getLabel("Common.ReceivedBy.label", "Common")+"</td>";
	//tx_htmlText+="<td class='label'><input type='text' name='receivedBy"+rwid+"' id='receivedBy"+rwid+"' value='' maxlength='20' >&nbsp;<img  src='../../eCommon/images/mandatory.gif'></img></td> </tr>";
	//tx_htmlText+="<tr> <td class='label' >"+getLabel("Common.ReceivedDate.label", "Common")+" </td>";
	//tx_htmlText+="<td class='label' ><input type='text' name='receivedDate"+rwid+"' id='receivedDate"+rwid+"' value='' size='8' maxlength='10' onblur='if(CheckDateT(this,\""+locale+"\")) validateDate();'><IMG SRC='../../eCommon/images/CommonCalendar.gif' id='CalreceivedDate"+rwid+"' onclick='showCalendar(\"receivedDate"+rwid+"\");document.frmTrackingOutsourceMedicationActionDtls.receivedDate"+rwid+".focus();return false;'>&nbsp;<img  src='../../eCommon/images/mandatory.gif'></img></td> </tr>";
	tx_htmlText+="<tr> <td class='label' style='vertical-align:top;'>"+getLabel("Common.remarks.label", "Common")+"</td>";
	if(parseInt(rwid) == (parseInt(maxProductCount)-1))
		tx_htmlText+="<td class='label'><textarea  rows='6' cols='60' name='remarks"+rwid+"' onKeyPress='return checkMaxLimit(this,2000,\"\");' onBlur='callCheckMaxLen(this,2000,\"blr\");'></textarea>&nbsp;<img src='../../eCommon/images/disabled.gif'  onMouseOver='changeCursor(this)' onclick='deleteProduct(\""+rwid+"\");' id='deleteProduct"+rwid+"'></td>";
	else
		tx_htmlText+="<td class='label'><textarea  rows='6' cols='60' name='remarks"+rwid+"' onKeyPress='return checkMaxLimit(this,2000,\"\");' onBlur='callCheckMaxLen(this,2000,\"blr\");'></textarea>&nbsp;<img src='../../eCommon/images/nolines_plus.gif'  onMouseOver='changeCursor(this)' onclick='addProduct(\""+rwid+"\");' id='addProduct"+rwid+"'>&nbsp;<img src='../../eCommon/images/disabled.gif'  onMouseOver='changeCursor(this)' onclick='deleteProduct(\""+rwid+"\");' id='deleteProduct"+rwid+"'></td>";

	tx_htmlText+="<input type='hidden' name='noOfIngnts"+rwid+"' id='noOfIngnts"+rwid+"' value='1'> </tr></table></td></table>";
	oCell.innerHTML=tx_htmlText;
	eval(document.getElementById("addProduct"+prodNum)).style.display = "none";
	eval(document.getElementById("deleteProduct"+prodNum)).style.display = "none";
}

function deleteProduct(prodNum) {
	var productTable = document.getElementById('OutsourceMedicationActionDtls');
	productTable.deleteRow(prodNum);
	currentRow = parseInt(prodNum)-1;
	document.frmTrackingOutsourceMedicationActionDtls.noOfProducts.value = currentRow;
	eval(document.getElementById("addProduct"+currentRow)).style="display";
	if(currentRow != 0)
		eval(document.getElementById("deleteProduct"+currentRow)).style="display";
}

function storeReceivedDtls(outsourceId){
	var formObj = parent.f_details.document.frmTrackingOutsourceMedicationActionDtls;
	var productCount = formObj.noOfProducts.value;
	var orderId = formObj.orderId.value;
	var orderLineNum = formObj.orderLineNum.value;
	var dupFound = false;
	for(p=0 ; p<(parseInt(productCount)-1); p++){
		productId= eval("formObj.productId"+p).value;
		for(pnext=(p+1) ; pnext<parseInt(productCount); pnext++){
			nextproductId= eval("formObj.productId"+pnext).value;
			if(nextproductId !="" && nextproductId == productId){
				alert(getMessage("PH_DUP_PRODUCT_NOT_ALLOWED","PH"));
				eval("formObj.productId"+pnext).focus();
				return false;
			}
		}
	}
	for(p=0 ; p<parseInt(productCount); p++){
		ingntCount= eval("formObj.noOfIngnts"+p).value;
		for(ing=0 ; ing<parseInt(ingntCount); ing++){
			ingnt= eval("formObj.ingredient"+p+"_"+ing).value;
			for(inext=(ing+1) ; inext<parseInt(ingntCount); inext++){
				nextingnt= eval("formObj.ingredient"+p+"_"+inext).value;
				if(nextingnt !="" && nextingnt == ingnt){
					alert(getMessage("PH_DUP_INGREDIANT_NOT_ALLOWED","PH"));
					eval("formObj.ingredient"+p+"_"+inext).focus();
					return false;
				}
			}
		}
	}
	var bean_id		= formObj.bean_id.value ;
	var bean_name	= formObj.bean_name.value ;
	var xmlDoc="";
	var xmlHttp = new XMLHttpRequest();
	xmlStr	="<root><SEARCH " ;
	xmlStr += " outsourceId=\"" + outsourceId + "\"";
	xmlStr += " productCount=\"" + productCount + "\"";
	xmlStr += " orderId=\"" + orderId + "\"";
	xmlStr += " orderLineNum=\"" + orderLineNum + "\"";
	for(p=0 ; p<parseInt(productCount); p++){
		if(!validateCurrentProduct(p)){
			return false;
		}
		productId= eval("formObj.productId"+p).value;
		productName= encodeURIComponent(eval("formObj.productName"+p).value,"UTF-8");
		batchId= eval("formObj.batchId"+p).value;
		expiryDate= eval("formObj.expiryDate"+p).value;
		quantity= eval("formObj.quantity"+p).value;
		quantityUOM= encodeURIComponent(eval("formObj.quantityUOM"+p).value,"UTF-8");
		quantity= eval("formObj.quantity"+p).value;
		ingntCount= eval("formObj.noOfIngnts"+p).value;
		xmlStr += " productId"+p+"=\"" + productId + "\"";
		xmlStr += " productName"+p+"=\"" + productName + "\"";
		xmlStr += " batchId"+p+"=\"" + batchId + "\"";
		xmlStr += " expiryDate"+p+"=\"" + expiryDate + "\"";
		xmlStr += " quantity"+p+"=\"" + quantity + "\"";
		xmlStr += " quantityUOM"+p+"=\"" + quantityUOM + "\"";
		xmlStr += " ingntCount"+p+"=\"" + ingntCount + "\"";
		for(ing=0;ing<parseInt(ingntCount);ing++){
			ingredient= encodeURIComponent(eval("formObj.ingredient"+p+"_"+ing).value,"UTF-8");
			xmlStr += " ingredient"+p+"_"+ing+"=\"" + ingredient + "\"";
		}

		remarks = encodeURIComponent(eval("formObj.remarks"+p).value,"UTF-8");
		xmlStr += " remarks"+p+"=\"" + remarks + "\"";
	}
	xmlStr +=" /></root>" ;
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open( "POST", "TrackingOutsourceMedicationValidate.jsp?bean_id="+bean_id+"&bean_name="+bean_name+"&identity=storeReceivedDtls", false ) ;
	xmlHttp.send( xmlDoc ) ;
	eval(xmlHttp.responseText);
    window.returnValue="OK";
	window.close();
}

function checkForReceivedDtls(outsourceId,orderId, orderLineNum, index){
	var formObj = document.frmTrackingOutsourceMedicationResult;
	var bean_id		= formObj.bean_id.value ;
	var bean_name	= formObj.bean_name.value ;
	var xmlDoc="";
	var xmlHttp = new XMLHttpRequest();
	xmlStr	="<root><SEARCH " ;
	xmlStr += " outsourceId=\"" + outsourceId + "\"";
	xmlStr += " orderId=\"" + orderId + "\"";
	xmlStr += " orderLineNum=\"" + orderLineNum + "\"";
	xmlStr += " index=\"" + index + "\"";
	xmlStr +=" /></root>" ;
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open( "POST", "TrackingOutsourceMedicationValidate.jsp?bean_id="+bean_id+"&bean_name="+bean_name+"&identity=checkForReceivedDtls", false ) ;
	xmlHttp.send( xmlDoc ) ;
	eval(xmlHttp.responseText);
}

function selectRecord(index, check){
	var formObj = document.frmTrackingOutsourceMedicationResult;
	//eval("formObj.select"+index).value ="N";
	eval("formObj.select"+index).checked=check;
}

function checkForSplChars(obj){
	if(!CheckChars(obj)){
		alert(getMessage("SPECIAL_CHARCTERS_NOT_ALLOWED","PH"));
		obj.focus();
		return false;
	}
}

function checkForPositiveNumber(obj) {
    if(!( trimCheck(obj.value) && isNaN(obj.value) == false && obj.value >= 0)) {
        if ( obj.value.length > 0 ) {
            alert(getMessage("INVALID_POSITIVE_NUMBER", "Common"));
            obj.focus();
			return false;
        }
    }
	else if( obj.value.length == 0 || parseInt(obj.value)<=0){
		msg = getMessage("PH_NOT_BLANK_ZERO_COMMON","PH");
		msg = msg.replace('$' ,getLabel("Common.Quantity.label", "Common"));		alert(msg);
		obj.focus();
		return false;
	}
}


function checkForExpiryDate(obj, locale){
	var formObj = document.frmTrackingOutsourceMedicationActionDtls;
	var sys_date=formObj.sys_date.value;
	if(obj.value!=""){
		if(CheckDateT(obj, "DMY",locale)){
			if(!isAfter(obj.value,sys_date, "DMY", locale)){
				alert(getMessage("PH_EXPDATE_GREATER_SYSDATE",'PH'));
				// obj.focus();	
				// obj.select();
				obj.value='';
				return false;
			}	
		}
		/*else{
			alert(getMessage("INVALID_DATE_TIME",'PH'));
			obj.focus();
			return false;
		}*/
	}
}


function addOrderByCol(){  
	var i=0;
	var from = document.getElementById("item")('orderbycols'); 
	if ( from.options.length > 0 ) {
		var to = document.getElementById("item")('orderbycolumns'); 
		var element = document.createElement('OPTION');
		var seltdIndex = from.selectedIndex;
		if(seltdIndex > -1){
			element.text = from.options[from.selectedIndex].text;
			element.value= from.options[from.selectedIndex].value; 
			to.add(element);      
			from.remove(from.selectedIndex);
			if(from.options[i])
				from.options[i].selected=true ;
			i++;
		}
	} 
} 

function removeOrderByCol(){
	var j=0;
	var from = document.getElementById("item")('orderbycolumns');
	if ( from.options.length > 0 ){ 
		var to = document.getElementById("item")('orderbycols');
		var element = document.createElement('OPTION');
		var seltdIndex = from.selectedIndex;
		if(seltdIndex > -1){
			element.text = from.options[from.selectedIndex].text;
			element.value = from.options[from.selectedIndex].value;
			to.add(element);    from.remove(from.selectedIndex);
			if(from.options[j]) 
				from.options[j].selected=true; 
			j++;
		}
	}
}  

function SelectAll(){
	var i = 0;
	document.getElementById("orderbycolumns").selectedIndex=0; 
	while ( i < document.getElementById("orderbycolumns").length) {
		document.getElementById("orderbycolumns").options[i].selected=true;
		i++; 
	}
}  

function execQuery(){
	var formObj = document.query_form;
	fromDate = formObj.order_date_from.value;
	toDate =  formObj.order_date_to.value;
	locale =  formObj.language_id.value;
	if(fromDate!="" && toDate!=""){
		if(!isAfter(toDate,fromDate, "DMY", locale)){
			parent.messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num="+ getMessage("TO_DATE_EQUAL_GREATER_FROM_DATE", "PH");
			return false;
		}
	}

	if(document.getElementById("orderbycolumns").options.length >0 ){
		SelectAll(); 
		document.query_form.submit();
	}
	else{
		alert(getMessage('ORDERBY_NOT_BLANK', "Common"))
	}
}

function assignHomepage(hompageYN){
	homepage= homepageYN;
}

