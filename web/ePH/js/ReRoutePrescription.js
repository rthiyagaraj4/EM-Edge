var function_id = "" ;
var message		= "" ;
var flag		= "" ;
var result		= false ;
var cntr		= 0;
var releaseflag= false;

function proceedOnApply() {
	var url ="";
	var result;
	if(document.formReRoutePrescriptions!=undefined ){
		url = parent.f_query_result.location.href;
	}
	else
		url = f_query_result.location.href;
    url = url.toLowerCase();
	if (url.indexOf("blank.html")!=-1)
		result	= true;
    else
		result	=	false;
	return result;
}

function apply(){
	cntr = 0;
// added  for Bru-HIMS-CRF-090 [IN:029956] -- start
	var frmObj="";
//if else condtion newly added  for Bru-HIMS-CRF-090 [IN:029956]
	if(document.formReRoutePrescriptions!=undefined ){
		frmObj = parent.f_query_result.document.formReRoutePrescriptionsResult;
		parent.messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num=";
	}
	else{
		frmObj = f_query_result.document.formReRoutePrescriptionsResult;
		messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num=";
	}
	// added  for Bru-HIMS-CRF-090 [IN:029956] --end
	var flag="N";//Added for HSA-CRF-0155[IN048487]
	if(!proceedOnApply())	{
		if(storeCheckedRecords('apply')){
			if(cntr > 0){	
				if(checkDisInd()){
					//eval( formApply(frmObj,PH_CONTROLLER  ) ) ;//COmmented for HSA-CRF-0155 [IN048487]
					for(i=1;i<=frmObj.tot_record_count.value;i++){//Added for HSA-CRF-0155 [IN048487]-Start
						if(eval("frmObj.prescription_type_"+i).value=="E" && eval("frmObj.patient_class_"+i).value!="IP"){
							flag="Y";
						}
					}
					if(flag=="Y")
						recordextdetails(frmObj);
					else 
						eval( formApply(frmObj,PH_CONTROLLER  ) ) ;	//Added for HSA-CRF-0155 [IN048487]-End
					if(document.formReRoutePrescriptions!=undefined){ // added  for Bru-HIMS-CRF-090 [IN:029956]
						parent.messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num="+ message;
					}
					else{
						messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num="+ message;
					}
					if( result ) {
						onSuccess();
						if(frmObj.re_route_via_reg_ord.value=='Y'){ //if else condtion  added  for Bru-HIMS-CRF-090 [IN:029956]
							window.returnValue='Y';
							window.close();
						}
					}
				}
				else{
					if(document.formReRoutePrescriptions!=undefined){ // newly added if else block for [IN:033798]
						parent.messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num="+ message;
					}
					else{
						messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num="+ message;
					}
				}
			}
		}
	}
	else{
		if(document.formReRoutePrescriptions!=undefined){ // newly added if else block for [IN:033798]
			parent.messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num="+ message;
		}
		else{
			messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num="+ message;
		}
	//	messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num="+ message; 
	}
}

function checkDisInd(){
	if(document.formReRoutePrescriptions!=undefined ){
		formObj = parent.f_query_result.document.formReRoutePrescriptionsResult;
	}
	else{
		formObj = f_query_result.document.formReRoutePrescriptionsResult;
	} 
	totCount = formObj.tot_record_count.value;
	var curr_falicity_id ="";
	var reroute_falicity_id ="";
	var disch_ind ="";
	var take_home_med ="";
	for(i=1;i<=totCount; i++){
		curr_falicity_id =eval("formObj.facility_id_"+i).value;     
		reroute_falicity_id =eval("formObj.rcode_"+i).value;     
		disch_ind =eval("formObj.dis_mend_"+i).value;            
		take_home_med =eval("formObj.take_medication_yn_"+i).value;    
		if(eval("formObj.check_id"+i).checked==false){
			continue;
		}
		if(take_home_med=='Y' && curr_falicity_id!=reroute_falicity_id && disch_ind!='D'){
			alert(getMessage("PH_RE_ROUTE_DISCH_MEDICATION","PH"));
			return false;
		}
	}
	return true;
}
function onSuccess() {
	if(document.formReRoutePrescriptions==undefined) // added  for Bru-HIMS-CRF-090 [IN:029956]
	f_query_result.location.href="../../eCommon/html/blank.html";
}

function assignResult( _result, _message, _flag ) {
	result = _result ;
	message  = _message ;
	flag = _flag ;
}

function storeCheckedRecords(mode){
	var formObj;
    var flag = true;
	var loc_val;
	if(mode=='apply') {  
	//  formObj = f_query_result.document.formReRoutePrescriptionsResult;
//if else condition added  for Bru-HIMS-CRF-090 [IN:029956]
		if(document.formReRoutePrescriptions!=undefined ){
			formObj = parent.f_query_result.document.formReRoutePrescriptionsResult;
		}
		else{
			formObj = f_query_result.document.formReRoutePrescriptionsResult;
		} 
	} 
	else {  
	    formObj = f_query_result.document.formReRoutePrescriptionsResult;
		flag = true;
	}
	var arrObj = formObj.elements;
	//if else condtion  added  for Bru-HIMS-CRF-090 [IN:029956]
	if(document.formReRoutePrescriptions!=undefined ){
		loc_val=parent.messageFrame.location.href;
	}
	else{
		loc_val=messageFrame.location.href;
	}
	if(mode=='apply'){
		for(var i=0;i<arrObj.length;i++){
			if(arrObj[i].type == "checkbox"){
				if(arrObj[i+1].checked){
					var name_value = arrObj[i-5].name;
					var name_value_4 = arrObj[i-4].name;
					var name_value1 = arrObj[i-2].name;
					var prescription_type = arrObj[i-6].value;
					if(arrObj[i-6].value == '' && arrObj[i-6].value=='I'){ //changed 5 to 6  for Bru-HIMS-CRF-090 [IN:029956]
						if(document.formReRoutePrescriptions!=undefined ){ //if else condtion  added  for Bru-HIMS-CRF-090 [IN:029956]
							parent.messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num="+ getMessage("RE_ROUTE_FAC_CANNOT_BLANK","PH");
						}
						else{
							messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num="+ getMessage("RE_ROUTE_FAC_CANNOT_BLANK","PH");
						}
						arrObj[i-6].focus();
						flag = false;
						return false;
						break;
					}
					else if(arrObj[i-3].value == '' && arrObj[i-6].value=='I'){//&& arrObj[i-6].value=='I'Added for  HSA-CRF-0155 [IN048487] 

						if(document.formReRoutePrescriptions!=undefined){ //if else condtion  added  for Bru-HIMS-CRF-090 [IN:029956] 
							parent.messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num="+ getMessage("RE_ROUTE_DISP_LOC_CANNOT_BLANK","PH");
						}
						else{
							messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num="+ getMessage("RE_ROUTE_DISP_LOC_CANNOT_BLANK","PH");
						}
						arrObj[i-3].focus();
						flag = false;
						return false;
						break;
					}
					else if(arrObj[i-1].value == ''){  //changed 1 to 2  for Bru-HIMS-CRF-090 [IN:029956]
						if(document.formReRoutePrescriptions!=undefined ){ //if else condtion  added  for Bru-HIMS-CRF-090 [IN:029956]
							parent.messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num="+ getMessage("PH_REASON_NOT_SELECTED","PH");
						}
						else{
							messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num="+ getMessage("PH_REASON_NOT_SELECTED","PH");
						}
						arrObj[i-1].focus(); 
						flag = false;
						return false;
						break;
					}
					else if(prescription_type=='I' && arrObj[i-5].value == arrObj[i+3].value && arrObj[i-2].value == arrObj[i+2].value){  //the below else if block newly added for [33888]
						if(document.formReRoutePrescriptions!=undefined ){ 
							parent.messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num="+ getMessage("PH_RE_ROUTE_DIFF_DISP_LOC","PH");
						}
						else{
							messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num="+ getMessage("PH_RE_ROUTE_DIFF_DISP_LOC","PH");
						}
						flag = false;
						return false;
						break;
					}
					cntr = cntr+1;
				}
			}
		}
	}
	if(cntr==0){
		if(document.formReRoutePrescriptions!=undefined ){  //if else condtion  added  for Bru-HIMS-CRF-090 [IN:029956]
			parent.messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num="+ getMessage("PH_REASON_ONE_SELECTED","PH");
		}
		else{
			messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num="+ getMessage("PH_REASON_ONE_SELECTED","PH");
		}
		releaseflag=false;
	}
	else{
		releaseflag=true;
	}
	return true;
}

function query(){
	
	f_query_criteria.location.href="../../ePH/jsp/ReRoutePrescriptionsCireria.jsp?mode="+MODE_INSERT;
	f_query_result.location.href="../../eCommon/html/blank.html";
}

function reset()	{
	if(f_query_criteria){
		//f_query_criteria.document.formReRoutePrescriptions.patient_detail.value="";
		f_query_criteria.location.reload();
		f_query_result.location.href="../../eCommon/html/blank.html";
			
	}
}

function ValidateFromDate(obj){
	fr_dt = document.formReRoutePrescriptions.dt_to;
	if(obj.value!=""){
		if(!checkDt(obj)){ //changed doDateTimeChk -to checkDt for  SRR20056-SCF-7725 
			alert(getMessage("INVALID_DATE_TIME","PH"));
			obj.value="";
			obj.select();
			return false;
		}
		if (fr_dt.value!=""){
			if(!ValidateDate(obj,fr_dt)) { //changed ValidateDateTime - to ValidateDate for  SRR20056-SCF-7725 
				alert(getMessage("TO_DT_GR_EQ_FM_DT","PH"));
				obj.value="";
				obj.select();
				return false;
			}
		}
	}
}
function ValidateToDate(obj){
	fr_dt = document.formReRoutePrescriptions.dt_from;
	if(obj.value!=""){
		if(!checkDt(obj)){ //changed doDateTimeChk -to checkDt for  SRR20056-SCF-7725 
			alert(getMessage("INVALID_DATE_TIME","PH"));
			obj.value="";
			 obj.select();
			return false;
		}
		else
			if (fr_dt.value!=""){
				if(!ValidateDate(fr_dt,obj)){  //changed ValidateDateTime - to ValidateDate for  SRR20056-SCF-7725 
				alert(getMessage("TO_DT_GR_EQ_FM_DT","PH"));
				obj.value="";
				obj.select();
				return false;
			}
		}
	}
	return true;
}

function callPatientLin(patient_id) {
	 patient_id		= document.formReRoutePrescriptions.patient_id.value;
	 bean_id		= "ReRoutePrescriptionsBean";
	 bean_name	    = "ePH.ReRoutePrescriptionsBean";
		
	var xmlDoc="";
	var xmlHttp = new XMLHttpRequest();

	xmlStr ="<root><SEARCH " ;
	xmlStr +=" /></root>" ;
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open( "POST", "ReRoutePrescriptionsValidate.jsp?bean_id=" + bean_id + "&bean_name=" + bean_name + "&validate=CALLPATIENT"+"&patient_id=" + patient_id, false ) ;
	xmlHttp.send( xmlDoc ) ;
	responseText=xmlHttp.responseText ;
	//alert(responseText);
	eval(responseText) ;

}
function assignPatientLine(p_name,p_age,p_sex){
	document.getElementById("patient_name").value = p_name+" / "+p_age+" / " +p_sex;
}

//Patient Search from common.js
async function callPatientLookup(){
	var formObj =document.formReRoutePrescriptions;
	var patient_id =await PatientSearch();
	if(patient_id != null && patient_id != "" )  {
		formObj.patient_id.value = patient_id;
		formObj.patient_id.focus();
     }
}

function callResultPage(){
	var formObj=document.formReRoutePrescriptions;	
	var messageFrame;
	var fields = new Array (formObj.patient_id);
	var names = new Array (getLabel("Common.patientId.label","Common"));
	if(document.formReRoutePrescriptions==undefined) 
		messageFrame=parent.messageFrame;
	else
		messageFrame=parent.messageFrame;

	if(parent.f_query_criteria.checkFields( fields, names, messageFrame)){
		//disableMainForm();
		//var disp_locn=document.formReRoutePrescriptions.disp_locn.value; //commented  for Bru-HIMS-CRF-090 [IN:029956]
		var OrderId=document.formReRoutePrescriptions.OrderId.value;
		var patient_id=document.formReRoutePrescriptions.patient_id.value;
		//var dt_from=document.formReRoutePrescriptions.dt_from.value;  //commented  for Bru-HIMS-CRF-090 [IN:029956]
		//var dt_to=document.formReRoutePrescriptions.dt_to.value;		//commented  for Bru-HIMS-CRF-090 [IN:029956]
		var mode=document.formReRoutePrescriptions.mode.value;
		var facility_id=document.formReRoutePrescriptions.facility_id.value;
		var disp_locn_code=document.formReRoutePrescriptions.disp_locn_code.value;
		var re_route_via_reg_ord = document.formReRoutePrescriptions.re_route_via_reg_ord.value; // added and passed over the url  for Bru-HIMS-CRF-090 [IN:029956]
		messageFrame.location.href = "../../eCommon/jsp/error.jsp?";
		parent.f_query_result.location.href="../../ePH/jsp/ReRoutePrescriptionsResult.jsp?OrderId="+OrderId+"&mode="+mode+"&facility_id="+facility_id+"&patient_id="+patient_id+"&mode="+MODE_INSERT+"&re_route_via_reg_ord="+re_route_via_reg_ord+"&disp_locn_code="+disp_locn_code;
		return true;
	}
	else
		return false;
}

function disableMainForm(){
	var arrObj =document.formReRoutePrescriptions.elements;
    for(var i=0;i<arrObj.length;i++)
		arrObj[i].disabled=true;
}

function checkValue(obj){
	if(obj.value==""){
		document.formReRoutePrescriptions.patient_name.value="";
	}
}

async function searchReRouteDisp(obj,i){
	
	var re_route_facility=eval("document.formReRoutePrescriptionsResult.rcode_"+i).value;
	var facility_id=document.formReRoutePrescriptionsResult.facility_id.value;
	var disp_locn=document.formReRoutePrescriptionsResult.disp_locn.value;;
	var locale=document.formReRoutePrescriptionsResult.locale.value;
	var sql_Re_Route_select_lookup=document.formReRoutePrescriptionsResult.sql_Re_Route_select_lookup.value;
	var argumentArray  = new Array() ;
	var dataNameArray  = new Array() ;
	var dataValueArray = new Array() ;
	var dataTypeArray  = new Array() ;
	
	if(re_route_facility==facility_id){
    argumentArray[0] = sql_Re_Route_select_lookup+" AND a.LANGUAGE_ID ='"+locale+"' AND a.DISP_LOCN_CODE!= '"+disp_locn+"'  AND a.FACILITY_ID ='"+facility_id+"' ORDER BY 2";
	argumentArray[1]   = dataNameArray ;
	argumentArray[2]   = dataValueArray ;
	argumentArray[3]   = dataTypeArray ;
	argumentArray[4]   = "1,2";
	argumentArray[5]   = eval("document.formReRoutePrescriptionsResult.ReRouteDisp_Name_"+i).value;
	argumentArray[6]   = DESC_LINK ;
	argumentArray[7]   = DESC_CODE ;
	retVal = await CommonLookup( getLabel("ePH.ReRouteDispenseLocation.label","PH"), argumentArray );
	var str =unescape(retVal);
	var arr = str.split(",");
	if(retVal != null && retVal != "" ){
		eval("document.formReRoutePrescriptionsResult.ReRouteDisp_Name_"+i).value = arr[1];
	    eval("document.formReRoutePrescriptionsResult.ReRouteDisp_Id_"+i).value = arr[0];
	   }
	}
	else{
		argumentArray[0] = sql_Re_Route_select_lookup+" AND a.LANGUAGE_ID ='"+locale+"' AND a.FACILITY_ID ='"+facility_id+"' ORDER BY 2";
		argumentArray[1]   = dataNameArray ;
		argumentArray[2]   = dataValueArray ;
		argumentArray[3]   = dataTypeArray ;
		argumentArray[4]   = "1,2";
		argumentArray[5]   = eval("document.formReRoutePrescriptionsResult.ReRouteDisp_Name_"+i).value;
		argumentArray[6]   = DESC_LINK ;
		argumentArray[7]   = DESC_CODE ;

		retVal = await CommonLookup( getLabel("ePH.ReRouteDispenseLocation.label","PH"), argumentArray );
		var str =unescape(retVal);
		var arr = str.split(",");
		if(retVal != null && retVal != "" ){
			eval("document.formReRoutePrescriptionsResult.ReRouteDisp_Name_"+i).value = arr[1];
			eval("document.formReRoutePrescriptionsResult.ReRouteDisp_Id_"+i).value = arr[0];
		}
	}
}

function clearReRoute(obj,i){
// alert(obj.value)
	 eval("document.formReRoutePrescriptionsResult.ReRouteDisp_Name_"+i).value="";
}
 
function chkpatID(flag){
	if(flag=='Y'){
	    alert(getMessage("PH_NOT_VALID_PATIENT","PH"));
	     document.formReRoutePrescriptions.patient_id.value="";
	     document.formReRoutePrescriptions.patient_id.focus();
	}
}

function chkPatientID(){
	var  patient_id		= document.formReRoutePrescriptions.patient_id.value;
	if(patient_id!=null&&patient_id!=""){
		 bean_id		= "ReRoutePrescriptionsBean";
		 bean_name	    = "ePH.ReRoutePrescriptionsBean";
			
  		var xmlDoc="";
		var xmlHttp = new XMLHttpRequest();

		xmlStr ="<root><SEARCH " ;
		xmlStr +=" /></root>" ;
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open( "POST", "ReRoutePrescriptionsValidate.jsp?bean_id=" + bean_id + "&bean_name=" + bean_name + "&validate=CHECKPATIENTID"+"&patient_id=" + patient_id, false ) ;
		xmlHttp.send( xmlDoc ) ;
		responseText=xmlHttp.responseText ;
		//alert(responseText);
		eval(responseText) ;
	}
}
// added  for Bru-HIMS-CRF-090 [IN:029956]
function getDispLoc(obj,user_id,row_no, def_disp_locn_code){
	if(obj.value!=""){
		 bean_id		= "ReRoutePrescriptionsBean";
		 bean_name	    = "ePH.ReRoutePrescriptionsBean";
			
  		var xmlDoc="";
		var xmlHttp = new XMLHttpRequest();

		xmlStr ="<root><SEARCH " ;
		xmlStr +=" /></root>" ;
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open( "POST", "ReRoutePrescriptionsValidate.jsp?bean_id=" + bean_id + "&bean_name=" + bean_name + "&validate=GETDISPLOC"+"&facility_id="+obj.value+"&user_id="+user_id+"&row_no="+row_no, false ) ;
		xmlHttp.send( xmlDoc ) ;
		responseText=xmlHttp.responseText ;
		eval(responseText) ;
		if(def_disp_locn_code !="")
			document.getElementById('dispLocnDesc_'+row_no).value=def_disp_locn_code;
		if(document.getElementById('dispLocnDesc_'+row_no).value=="")
			document.getElementById('dispLocnDesc_'+row_no).selectedIndex=0;
		document.getElementById('ReRouteDisp_Id_'+row_no).value=document.getElementById('dispLocnDesc_'+row_no).value;
	} 
}
//the below method is  added for Bru-HIMS-CRF-090 [IN:029956]
function addDispLocnDescList(code,desc,row_no, sel_facility_id)	{
	var ordered_facility = document.getElementById('facility_id_'+row_no).value;
	var curr_disp_locn = document.getElementById('disp_locn_'+row_no).value;
	if(sel_facility_id == ordered_facility && code== curr_disp_locn)
		return false;

	var element = document.createElement('OPTION') ;
	element.value		=  code ;
	element.text		= desc ;
	document.getElementById('dispLocnDesc_'+row_no).add(element);
}
//the below method is  added  for Bru-HIMS-CRF-090 [IN:029956]
function assignDispLocDesc(obj,row_val){
	eval("document.formReRoutePrescriptionsResult.ReRouteDisp_Id_"+row_val).value=obj.value;
	eval("document.formReRoutePrescriptionsResult.ReRouteDisp_Name_"+row_val).value=obj.value;
}
//the below method is  added  for Bru-HIMS-CRF-090 [IN:029956]
function removeDispLocnDescList(row_no)	{
	var len = document.getElementById('dispLocnDesc_'+row_no).length = 0;
	var tp 		= "---"+getLabel("Common.defaultSelect.label","Common")+"---" ;
	
	var opt  	= eval("document.createElement(\"OPTION\")") ;
	opt.text 	= tp ;
	opt.value 	= "" ;
	document.getElementById('dispLocnDesc_'+row_no).add(opt);
//	eval("document.review_result_search.event_class.add(opt)") ;
}

function AssignValue(obj,i){
	if(obj.checked==true){
		eval("document.formReRoutePrescriptionsResult.chk_"+i).value = "Y";
		eval("document.getElementById('ReasonMand_')"+i).style.visibility = "visible";
	}
	else{
		eval("document.formReRoutePrescriptionsResult.chk_"+i).value = "N";
		eval("document.getElementById('ReasonMand_')"+i).style.visibility = "hidden";
	}
}
//the below method is  added  for Bru-HIMS-CRF-090 [IN:029956]
function AssignValueDisMedn(obj,i){
	if(obj.checked==true){
		eval("document.formReRoutePrescriptionsResult.dis_mend_"+i).value = "D";
	}
	else{
		eval("document.formReRoutePrescriptionsResult.dis_mend_"+i).value = "";
	}
	checkForDischarge(obj,i);  //newly added for [IN:033888]
}
//the below method is newly added for [IN:033888]
function checkForDischarge(obj,i) {
	var take_medication_yn_chk	=	eval("document.formReRoutePrescriptionsResult.take_medication_yn_"+i).value;
	if(take_medication_yn_chk!="Y" && obj.checked==true) {
		alert(getMessage("PH_DISCHARGE_ADVICE_NOT_PREP", "PH"));
		obj.value	=	"";
		obj.checked = false;
		return false;
	} 
		//return true;
}

async function Modify(obj){
	var patient_id=document.formReRoutePrescriptionsResult.patient_id.value;
	var dialogHeight= "40vh" ;
	var dialogWidth	= "50vw" ;
	var dialogTop = "10" ;   
	var center = "1" ;
	var status="no";
	var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; center: " + center + ";scroll "+scroll+"; status: " + status + "; dialogTop :" + dialogTop;
	var arguments	= "" ;
	var retVal = await window.showModalDialog("../../ePH/jsp/ChartSummaryCurrentMedications.jsp?ord_id="+obj+"&patient_id="+patient_id+"&called_from=REROUTE",arguments,features); // called_from added for Bru-HIMS-CRF-400
}
function record(formObj){//Added for HSA-CRF-0155 [IN048487]-Start
	var fields  = new Array() ;
	var names   = new Array() ;
	fields[0]   = formObj.ext_facility ;	
	names[0]    = getLabel("Common.externalfacility.label","Common");
	fields[1]   = formObj.next_collectiondate ;	
	names[1]    = getLabel("ePH.NextCollectionDate.label","PH");
	fields[2]   = formObj.referral_remarks ;	
	names[2]    = getLabel("Common.remarks.label","Common");
	fields[3]   = formObj.practioner_name ;	
	names[3]    = getLabel("ePH.ReferedBy.label","PH");
	validateDate =  checkFlds( fields, names);
	if(!validateDate)
		return false;
	var print_extr_pres;
	if(formObj.print_extr_pres.checked==true){
		print_extr_pres="Y";
	}
	else{
		print_extr_pres="N";
	}
	var ext_facility=formObj.ext_facility[formObj.ext_facility.selectedIndex].value;
	var next_collection_date=formObj.next_collectiondate.value;
	var referral_remarks=encodeURIComponent(formObj.referral_remarks.value,"UTF-8");
	var practioner_id=formObj.practioner_id.value;
	var ExtbmsReason=formObj.ExtbmsReason[formObj.ExtbmsReason.selectedIndex].value;
	bean_id			= "ReRoutePrescriptionsBean";
	bean_name	    = "ePH.ReRoutePrescriptionsBean";
	var xmlDoc="";
	var xmlHttp = new XMLHttpRequest();

	xmlStr ="<root><SEARCH " ;
	xmlStr +=" /></root>" ;
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open( "POST", "ReRoutePrescriptionsValidate.jsp?bean_id=" + bean_id + "&bean_name=" + bean_name + "&validate=InsertExternalDetails"+"&ext_facility="+ext_facility+"&print_extr_pres="+print_extr_pres+"&next_collection_date="+next_collection_date+"&referral_remarks="+encodeURIComponent(referral_remarks,"UTF-8")+"&practioner_id="+practioner_id+"&ExtbmsReason="+ExtbmsReason, false ) ;
	xmlHttp.send( xmlDoc ) ;
	responseText=xmlHttp.responseText ;
	responseText=trimString(responseText);
	window.returnValue = responseText;
	window.close();
}

function checkSysDate(sysdate,next_collection_date){
	
	if(!doDateCheckAlert(sysdate,next_collection_date)){
		alert(getMessage("NEXT_COLL_GRT_SYSDATE","PH"));
		next_collection_date.value="";
		return false;
	}
	return true;
}

function checkReferelRemarksMaxLimit(obj,maxLeng) { 
	if(obj.value.length > maxLeng) {
		val = obj.value;
		var msg = getMessage("REMARKS_CANNOT_EXCEED","Common");
		msg = msg.replace("$",getLabel("eCommon.remarks.label","Common"));
		msg = msg.replace("#",maxLeng);
		obj.value = val.substring(0,maxLeng-1);
		alert(msg);
		obj.focus();
		return false;
	} 
	else 
		return true;
}
function reset_table(formObj){
	formObj.reset();
}
function removeIn_Exlist(obj,rowVal,patient_class){
	if(obj.value=="E" && patient_class!='IP'){
		document.getElementById('rcode_'+rowVal).disabled=true;
		document.getElementById('dispLocnDesc_'+rowVal).disabled=true;
		document.getElementById('rcode_'+rowVal).value='';
		document.getElementById('dispLocnDesc_'+rowVal).value='';
	}
	else{
		document.getElementById('rcode_'+rowVal).disabled=false;
		document.getElementById('dispLocnDesc_'+rowVal).disabled=false;
	}	
}

async function searchPractioner(obj, callFrom){
	var formObj = document.formExternalPrescriptionDetail;
	if(callFrom =='ONCHANGE' && formObj.practioner_name.value=='')
		return false;
	var argumentArray  = new Array() ;
	var dataNameArray  = new Array() ;
	var dataValueArray = new Array() ;
	var dataTypeArray  = new Array() ;
	argumentArray[0]   = formObj.SQL_PH_DISP_PRACT_REFERRAL_SELECT.value;
	argumentArray[1]   = dataNameArray ;
	argumentArray[2]   = dataValueArray ;
	argumentArray[3]   = dataTypeArray ;
	argumentArray[4]   = "1,2";
	argumentArray[5]   = formObj.practioner_name.value ;
	argumentArray[6]   = DESC_LINK ;
	argumentArray[7]   = DESC_CODE ; 	
	retVal = await CommonLookup( getLabel("Common.practitioner.label","Common"), argumentArray );	
	formObj.practioner_name.value = "" ;
	formObj.practioner_id.value = "";
	var str =unescape(retVal);
	var arr = str.split(",");
	if(retVal != null && retVal != "" )  {
		formObj.practioner_name.value = arr[1] ;
		formObj.practioner_id.value = arr[0];
	}
	else{
		formObj.practioner_name.value = "" ;
		formObj.practioner_id.value = "";
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

async function recordextdetails(frmObj){
	var flag="N";
	var print_flag="N";
	var dialogHeight	="12" ;
	var dialogWidth		="50";
	var dialogTop		= "300" ;
	var dialogLeft		= "300" ;
	var center			= "1" ;
	var status			="no";
	var features		= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; center:" + center +"; status:" + status + "; dialogTop:" + dialogTop;
	var arguments		= "" ;
	retVal				=await window.showModalDialog( "../../ePH/jsp/ReRoutePrescriptionExternalFacilityDetail.jsp?called_from=external",arguments,features );
	if(retVal!=undefined && (retVal=='Y' || retVal=='N')){
		flag="Y";
		if(retVal=="N")
			print_flag="N";
		else
			print_flag="Y";
	}
	else{
		if(message!=''){
			messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num="+getMessage("RECORD_INSERTED","PH");
		}
		else{
			onSuccess();
		}
	}
	if(flag=="Y"){
		eval( formApply(frmObj,PH_CONTROLLER  ) ) ;
		if(print_flag=="Y"){
			bean_id			= "ReRoutePrescriptionsBean";
			bean_name	    = "ePH.ReRoutePrescriptionsBean";
			var xmlDoc="";
			var xmlHttp = new XMLHttpRequest();
			xmlStr ="<root><SEARCH " ;
			xmlStr +=" /></root>" ;
			xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
			xmlHttp.open( "POST", "ReRoutePrescriptionsValidate.jsp?bean_id=" + bean_id + "&bean_name=" + bean_name + "&validate=PrintExternalPrescription", false ) ;
			xmlHttp.send( xmlDoc ) ;
			responseText=xmlHttp.responseText ;
			eval(responseText);
		}
		if(frmObj!=undefined){ 
		   if(parent.messageFrame!=null){
			    parent.messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num="+ message;
		   }
		   else{
				messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num="+ message;
		   }
		}
		else{
			messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num="+ message;
		}
	}
}//Added for HSA-CRF-0155 [IN048487]-End
