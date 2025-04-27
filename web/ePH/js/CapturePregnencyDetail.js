var function_id = "" ;
var result = false ;
var message = "" ;
var flag = "" ;
var allow=true;
var result1		=	false;

//for patient lookup
async function callPatientSearch(target){
	var patient_id = await PatientSearch();
	if (typeof(patient_id)=="string"){
		target.value = patient_id;
		populateEncounter(patient_id);
	}
}

function populateEncounter(patient_id) {
	if(patient_id==''){
		Clear();
		return false;
	}
	parent.f_query_result.location.href="../../eCommon/html/blank.html";
	frmObj=document.FormCapturePregnenyQueryCriteria;
	document.getElementById("locn_desc").innerText ="";
	patient_id   =   frmObj.Patient_Id.value;
	frmObj.encounterId.selectedIndex= 0 ;
	var bean_id		= "CapturePregnencyDetailBean";
	var bean_name	= "ePH.CapturePregnencyDetailBean";
	var xmlDoc="";
	var xmlHttp = new XMLHttpRequest();					
	xmlStr	="<root><SEARCH " ;												
	xmlStr +=" /></root>" ;
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open( "POST", "CapturePregnencyDetailValidation.jsp?&identity=POPULATEENCOUNTER"+"&bean_id="+bean_id+"&bean_name="+bean_name+ "&patient_id="+ patient_id, false ) ;
	xmlHttp.send( xmlDoc ) ;	
	eval(xmlHttp.responseText);
}

function addEncList(encId) {
	obj = document.FormCapturePregnenyQueryCriteria.encounterId;
	var opt	= eval(document.createElement('OPTION'));
	opt.value =	encId;
	opt.text = encId;
	obj.add(opt);
}

function defCurrEncounter(defEncId){
	obj = document.FormCapturePregnenyQueryCriteria.encounterId;
	obj.value = defEncId;
	getlocation(obj.value);
}

function clearEncList() {
	obj = document.FormCapturePregnenyQueryCriteria.encounterId;
	var len = obj.length;
	for (var i=0; i<=len; i++) {
		obj.remove("");
	}
	var opt	= document.createElement('OPTION');
}

 function getlocation(encounter_id){
	frmObj=document.FormCapturePregnenyQueryCriteria;
	var bean_id		= "CapturePregnencyDetailBean";
	var bean_name	= "ePH.CapturePregnencyDetailBean";
	var xmlDoc="";
	var xmlHttp = new XMLHttpRequest();					
	xmlStr	="<root><SEARCH " ;												
	xmlStr +=" /></root>" ;
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open( "POST", "CapturePregnencyDetailValidation.jsp?&identity=POPULATELOCATION"+"&bean_id="+bean_id+"&bean_name="+bean_name+ "&encounter_id="+ encounter_id, false ) ;
	xmlHttp.send( xmlDoc ) ;	
	eval(xmlHttp.responseText);
}

function addlocation(locn_desc,locn_code,pract_name,admin_date){
   document.getElementById('locn_desc').innerText =decodeURIComponent( locn_desc,"UTF-8");;
   document.FormCapturePregnenyQueryCriteria.locn_code.value=locn_code;
   document.FormCapturePregnenyQueryCriteria.pract_name.value=decodeURIComponent( pract_name,"UTF-8");
   document.FormCapturePregnenyQueryCriteria.admin_date.value=admin_date;
}

function Clear(){
	document.FormCapturePregnenyQueryCriteria.Patient_Id.value="";
	document.getElementById("locn_desc").innerText ="";
	var len =document.FormCapturePregnenyQueryCriteria.encounterId.options.length;
	for(var i=0;i<len;i++) {
		document.FormCapturePregnenyQueryCriteria.encounterId.remove("DefTrackAction") ;
	}
	var opt = document.createElement("OPTION") ;
	opt.text = "   ---"+getLabel("ePH.Select.label","PH")+"---   "  ;
	opt.value = "" ;
	document.FormCapturePregnenyQueryCriteria.encounterId.add(opt);
	parent.parent.document.f_query_add_mod.f_query_result.location.href="../../eCommon/html/blank.html";//DU00001578
	parent.parent.messageFrame.document.location.href='../../eCommon/jsp/error.jsp';
}

 function callResultPage(){
	parent.parent.messageFrame.document.location.href='../../eCommon/jsp/error.jsp';
	frmObj=document.FormCapturePregnenyQueryCriteria;
	var patient_id =frmObj.Patient_Id.value;
	var encounter_id =frmObj.encounterId.value;
	if(patient_id==null || patient_id==""){
		alert(getMessage("PH_SELECT_PATIENT_ID","PH"));
		frmObj.Patient_Id.focus();
		return;
	}
	if(encounter_id==null || encounter_id==""){
		alert(getMessage("ENCOUNTER_NOT_FOUND","Common"));
		return;
	}
	var encounter_id=frmObj.encounterId.value;
	var locn_desc   =document.getElementById("locn_desc").innerText;
	var locn_code   =frmObj.locn_code.value;
	var pract_name   =frmObj.pract_name.value;
	var admin_date   =frmObj.admin_date.value;
	parent.f_query_result.location.href="../../ePH/jsp/CapturePregnencyDetailsResultFrame.jsp?patient_id="+patient_id+"&encounter_id="+encounter_id+"&locn_desc="+locn_desc+"&locn_code="+locn_code+"&pract_name="+pract_name+"&admin_date="+admin_date;
}

function calExpDate(lmp_date){
	frmObj=document.FormCapturePregnenyQueryResult;
	var bean_id		= "CapturePregnencyDetailBean";
	var bean_name	= "ePH.CapturePregnencyDetailBean";
	var xmlDoc="";
	var xmlHttp = new XMLHttpRequest();					
	xmlStr	="<root><SEARCH " ;												
	xmlStr +=" /></root>" ;
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open( "POST", "CapturePregnencyDetailValidation.jsp?&identity=CALEXPECTEDDATE"+"&bean_id="+bean_id+"&bean_name="+bean_name+ "&lmp_date="+ lmp_date, false ) ;
	xmlHttp.send( xmlDoc ) ;	
	eval(xmlHttp.responseText);
}

async function searchPractitionerName() {
// Commented and added for CRF-PH- RUT-CRF-0063/09-Practitioner [IN:041141] 
	/*var argumentArray	= new Array() ;
	var dataNameArray	= new Array() ;
	var dataValueArray	= new Array() ;
	var dataTypeArray	= new Array() ;

	dataNameArray[0]	= "APPL_USER_ID" ;
	dataValueArray[0]	= f_query_result1.document.FormCapturePregnenyQueryResult.p_user_id.value;
	dataTypeArray[0]	= STRING ;
	dataNameArray[1]	= "FACILITY_ID" ;
	dataValueArray[1]	= f_query_result1.document.FormCapturePregnenyQueryResult.p_facility_id.value;
	dataTypeArray[1]	= STRING ;
	dataNameArray[2]	= "FACILITY_ID" ;
	dataValueArray[2]	= f_query_result1.document.FormCapturePregnenyQueryResult.p_facility_id.value;
	dataTypeArray[2]	= STRING ;
	dataValueArray[3]	= f_query_result1.document.FormCapturePregnenyQueryResult.p_job_title.value;
	dataTypeArray[3]	= STRING ;
	argumentArray[0] = escape(f_query_result1.document.FormCapturePregnenyQueryResult.sql_ph_medn_stat_pract_select1.value)+"'"+f_query_result1.document.FormCapturePregnenyQueryResult.language_id.value+"'";
	argumentArray[1] = dataNameArray ;
	argumentArray[2] = dataValueArray ;
	argumentArray[3] = dataTypeArray ;
	argumentArray[4] = "5,6";
	argumentArray[5] = "";

	argumentArray[6] = DESC_LINK ;
	argumentArray[7] = DESC_CODE ;

	retArray = CommonLookup( getLabel("Common.practitioner.label","Common"), argumentArray );

	if(retArray != null && retArray != "") {
		f_query_result1.document.FormCapturePregnenyQueryResult.practitioner_id.value = retArray[0];

		f_query_result1.document.FormCapturePregnenyQueryResult.practitioner_name.value = retArray[1];
	}	
	*/	
	var facility= f_query_result1.document.FormCapturePregnenyQueryResult.p_facility_id.value;
	var locale= f_query_result1.document.FormCapturePregnenyQueryResult.language_id.value;
	var title=getLabel("Common.practitioner.label","Common");
	var sql=f_query_result1.document.FormCapturePregnenyQueryResult.sql_ph_medn_stat_pract_select1.value;

	var argumentArray		= new Array();
	var dataNameArray		= new Array();
	var dataValueArray		= new Array();
	var dataTypeArray		= new Array();
	
	argumentArray[0] = sql;
	argumentArray[1] = dataNameArray;
	argumentArray[2] = dataValueArray;
	argumentArray[3] = dataTypeArray;
	argumentArray[4] = "2,1";
	argumentArray[5] = f_query_result1.document.FormCapturePregnenyQueryResult.practitioner_name.value;
	argumentArray[6] = DESC_LINK;
	argumentArray[7] = CODE_DESC;
	f_query_result1.document.FormCapturePregnenyQueryResult.practitioner_id.value = "";
	f_query_result1.document.FormCapturePregnenyQueryResult.practitioner_name.value ="";
	retArray = await CommonLookup( title, argumentArray );	
	if(retArray != null && retArray !=""){
		retArray =unescape(retArray);
		var arr = retArray.split(",");
		
	   f_query_result1.document.FormCapturePregnenyQueryResult.practitioner_name.value = arr[1];
	   f_query_result1.document.FormCapturePregnenyQueryResult.practitioner_id.value = arr[0];
	}
}

function addexpecteddate(exp_preg_date){
	if(exp_preg_date!=""){
		document.FormCapturePregnenyQueryResult.exp_date.value=exp_preg_date;
		parent.f_patientline.frmPatientDetails.expd_delv_date.value=exp_preg_date;
		document.FormCapturePregnenyQueryResult.act_del_date.value=exp_preg_date;
		parent.f_patientline.frmPatientDetails.actu_delv_date.value=exp_preg_date;
	}
}

function callCancel(calledFrom){
	document.FormCapturePregnenyQueryResult.lmp_date.value	= "" ;
	document.FormCapturePregnenyQueryResult.exp_date.value	= "" ;
	document.FormCapturePregnenyQueryResult.exp_date.value	= "" ;
	document.FormCapturePregnenyQueryResult.act_del_date.value	= "" ;
	//document.FormCapturePregnenyQueryResult.practitioner_id.value	= "" ;
	if(calledFrom!="P")
		document.FormCapturePregnenyQueryResult.preg_remarks.value	= "" ;
	//document.FormCapturePregnenyQueryResult.pregnent_yn.value	= "" ;
	//document.FormCapturePregnenyQueryResult.pregnent_yn.checked	= false;
	document.getElementById("trimster").innerText	= "" ;
	document.getElementById("preg_week").innerText	= "" ;
}

function apply() {	
	var frmObject = document.FormCapturePregnenyQueryResult;
	parent.parent.parent.messageFrame.document.location.href='../../eCommon/jsp/error.jsp';
	if(document.FormCapturePregnenyQueryResult) {
		var fields= new Array ();
		var names= new Array ();
		fields[0] = frmObject.practitioner_name;
		names[0] = getLabel("Common.practitioner.label","Common");
		if(frmObject.lmp_date.disabled == false){
			fields[1] = frmObject.lmp_date;
			fields[2] = frmObject.exp_date;
			names[1] = getLabel("ePH.Lmp.label","ePH");
			names[2] = getLabel("ePH.ExpectedDeliveryDate.label","ePH");
		}
		var	flag1=checkFields(fields,names,parent.parent.parent.messageFrame) 
		if(flag1==true){
			eval( formApply( frmObject, PH_CONTROLLER ) ) ;
			if( result ) {
				alert(message);
				parent.parent.f_query_result.document.location.href='../../eCommon/html/blank.html';
				parent.parent.f_query_criteria.document.location.href =	 parent.parent.f_query_criteria.document.location.href
			}
		}
		else{
			return false;
		}
	}
}

function reset() {
	 
	//document.frames.f_query_add_mod.f_query_criteria.location.reload();
	//document.frames.f_query_add_mod.f_query_result.location.href="../../eCommon/html/blank.html";
	document.f_query_add_mod.f_query_criteria.location.reload();
	document.f_query_add_mod.f_query_result.location.href="../../eCommon/html/blank.html";
}

function assignResult( _result, _message, _flag ) {
	result	= _result ;
	message	= _message ;
	flag	= _flag ;
}

function calvalues(pregenant_yn,lmp_date,expd_delv_date,actu_delv_date,pregn_status_ind,pract_id,remarks,mode,srl_no,visibility,pregn_status_ind_flag,pregn_yn_ind_flag,locale,practitioner_id){// pregn_status_ind_flag,pregn_yn_ind_flag,locale added for 40685
	var frmObject = parent.f_query_result1.document.FormCapturePregnenyQueryResult;
	//var temp_falg="Y";
	parent.f_query_result1.document.getElementById("reultpage").style.visibility="visible";
	parent.f_patientline.frmPatientDetails.expd_delv_date.value=expd_delv_date;
	parent.f_patientline.frmPatientDetails.actu_delv_date.value=actu_delv_date;
	frmObject.mode.value =mode;
	frmObject.pregn_status_ind.value =pregn_status_ind;
	frmObject.srl_no.value =srl_no;
	if(pregn_yn_ind_flag=="Y"){
		//frmObject.document.getElementById('yes').checked = true;
        //frmObject.document.getElementById('no').checked = false;
		parent.f_query_result1.document.getElementById('yes').checked = true;
		parent.f_query_result1.document.getElementById('no').checked = false;
		enableDisableCriteriaFields(frmObject, false);
		calpregStage(lmp_date,locale);//locale added for 40685
	}
	else{
		//frmObject.document.getElementById('yes').checked = false;
        //frmObject.document.getElementById('no').checked = true;
		parent.f_query_result1.document.getElementById('yes').checked = false;
		parent.f_query_result1.document.getElementById('no').checked = true;
		enableDisableCriteriaFields(frmObject, true);
	}

	if(lmp_date!=""){
		frmObject.lmp_date.value =lmp_date;
	}
	if(expd_delv_date!=""){
		frmObject.exp_date.value =expd_delv_date;
	}
	if(actu_delv_date!=""){
		frmObject.act_del_date.value =actu_delv_date;
	}
	if(pregn_status_ind_flag==true)
		frmObject.preg_status.value ="A";
	else if(pregn_status_ind_flag==false)
		frmObject.preg_status.value ="C";
	frmObject.practitioner_name.value =decodeURIComponent(pract_id); 
	frmObject.practitioner_id.value =practitioner_id; 
	if(remarks!=""){
		frmObject.preg_remarks.value =decodeURIComponent(remarks);
	}
	var result=chkPregDays('',lmp_date,"Y",locale);
	//if(result!="" || result==false)
	//	return;
}

function SubmitLink(from,to,patient_id){
	var obj						=	document.frmPatientDetails;
	obj.from.value				=	from;
	obj.to.value				=	to;
	obj.patient_id.value		=	patient_id;
	obj.submit();
}

function calpregStage(lmp_date,locale){//locale added for 40685
	lmp_date=convertDate(lmp_date,'DMY',locale,"en");//locale added for 40685
	frmObj=document.FormCapturePregnenyQueryResult;
	var bean_id		= "CapturePregnencyDetailBean";
	var bean_name	= "ePH.CapturePregnencyDetailBean";
	var xmlDoc="";
	var xmlHttp = new XMLHttpRequest();					
	xmlStr	="<root><SEARCH " ;												
	xmlStr +=" /></root>" ;
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open( "POST", "CapturePregnencyDetailValidation.jsp?&identity=CALPERGSTAGE"+"&bean_id="+bean_id+"&bean_name="+bean_name+ "&lmp_date="+ lmp_date, false ) ;
	xmlHttp.send( xmlDoc ) ;	
	eval(xmlHttp.responseText);
}

function addpregweek(preg_week){
	var preg_week=Math.ceil(preg_week);
	calTrimster(preg_week);
	formobj =document.FormCapturePregnenyQueryResult;
	if(formobj!="undifine")
		formobj =parent.f_query_result1;
	parent.f_query_result1.document.getElementById("preg_week").innerText =getLabel("ePH.PregnencyStage.label","PH")+" "+"-"+" "+Math.round(preg_week)+" "+" "+getLabel("Common.weeks.label","Common");
}

function calTrimster(preg_week){
	frmObj=document.FormCapturePregnenyQueryResult;
	var bean_id		= "CapturePregnencyDetailBean";
	var bean_name	= "ePH.CapturePregnencyDetailBean";
	var xmlDoc="";
	var xmlHttp = new XMLHttpRequest();					
	xmlStr	="<root><SEARCH " ;												
	xmlStr +=" /></root>" ;
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open( "POST", "CapturePregnencyDetailValidation.jsp?&identity=GETTRIMSTER"+"&bean_id="+bean_id+"&bean_name="+bean_name+ "&preg_week="+ preg_week, false ) ;
	xmlHttp.send( xmlDoc ) ;	
	eval(xmlHttp.responseText);
}

function assignTrimster(trimster){
	formobj =document.FormCapturePregnenyQueryResult;
	if(formobj!="undifine")
		formobj =parent.f_query_result1;

	if(trimster!=""){
		formobj.document.getElementById("trimster").innerText =trimster;
	}
}

function checkToDate(obj,systemdate,locale){
	var lmp_date =obj.value;
	if(lmp_date!=""){
		if(!isAfter(systemdate,lmp_date, "DMY",locale)){
			alert(getMessage("LMP_DATE_GREAT_CURR_DATE", "PH"));
			obj.value="";
			document.FormCapturePregnenyQueryResult.exp_date.value="";
			document.FormCapturePregnenyQueryResult.act_del_date.value="";
			document.getElementById("trimster").innerText="";
			document.getElementById("preg_week").innerText="";
			return false;
		}
	}
	return true;
}

function chkLmpDate(obj,lmp_date,locale){
	var temp_date =obj.value;
	var temp_falg="N";
	chkPregDays(obj,lmp_date,"N",locale);
	if(temp_date!=""){
		if(lmp_date==""){
			msg = getMessage("CAN_NOT_BE_BLANK","Common");
			msg = msg.replace('$', getLabel("ePH.Lmp.label","ePH"));
			alert(msg);
			obj.value="";
			document.getElementById("trimster").innerText="";
			document.getElementById("preg_week").innerText="";
			return false;
		}
		if(!isBefore(lmp_date,temp_date, "DMY",locale)){
			msg= getMessage("DATE_GREAT_LMP_DATE", "PH");
			if(obj.name=="exp_date")
				msg = msg.replace('$', getLabel("ePH.ExpectedDeliveryDate.label","PH"));
			if(obj.name=="act_del_date")
				msg = msg.replace('$', getLabel("ePH.ActualDeliveryDate.label","PH"));
			alert(msg);
			obj.value="";
			return false;
		}
	}
	return true;
}

function chkLmpDate1(obj,lmp_date,locale){
	var temp_date =obj.value;
	if(temp_date!=""){
		if(!isBefore(lmp_date,temp_date, "DMY",locale)){
			msg= getMessage("DATE_GREAT_LMP_DATE", "PH");
			msg = msg.replace('$', getLabel("ePH.ActualDeliveryDate.label","PH"));
			alert(msg);
			obj.value="";
			return false;
		}
	}
	return true;
}

function assignValue(){
	formObj=document.FormCapturePregnenyQueryResult;
	var no=document.getElementById('no').checked;
	var yes=document.getElementById('yes').checked;

	if(yes==true){
		//formObj.document.getElementById('no').checked=false;
		document.getElementById('no').checked=false;
		enableDisableCriteriaFields(formObj, false);
	}
	else{
		enableDisableCriteriaFields(formObj, true);
	}
}

function enableDisableCriteriaFields(formObj, disable){
	//formObj.document.ge	tElementById('no').checked =
 
	
	if( (document.getElementById('no')!= null && (document.getElementById('no').checked == true)) || (parent.f_query_result1.document.getElementById('no')!= null && parent.f_query_result1.document.getElementById('no').checked == true)) {
		formObj.lmp_date.disabled= disable;
		formObj.exp_date.disabled= disable;
		formObj.act_del_date.disabled= disable;
		formObj.expCalendar.disabled= disable;
		formObj.LmpCalendar.disabled= disable;
		formObj.ActCalendar.disabled= disable;
		
		formObj.lmp_date.value= "";
		formObj.exp_date.value= "";
		formObj.act_del_date.value= "";
		//formObj.document.getElementById("trimster").innerText="";
		//formObj.document.getElementById("preg_week").innerText="";
		if(document.getElementById("trimster"))
			document.getElementById("trimster").innerText="";
		if(document.getElementById("preg_week"))
			document.getElementById("preg_week").innerText="";
	}
	else{
		formObj.lmp_date.disabled= disable;
		formObj.exp_date.disabled= disable;
		formObj.act_del_date.disabled= disable;
		formObj.expCalendar.disabled= disable;
		formObj.LmpCalendar.disabled= disable;
		formObj.ActCalendar.disabled= disable;
	}
}

function CheckRemMaxLen() { 
	var val = "";
	obj = document.FormCapturePregnenyQueryResult.preg_remarks;
	val = obj.value;
	if(obj.value.length > 2000) {
		var msg = getMessage("REMARKS_CANNOT_EXCEED","Common");
		msg = msg.replace("$",getLabel("Common.remarks.label",'Common'));
		msg = msg.replace("#",2000);
		obj.value = val.substring(0,2000);
		alert(msg);
		obj.focus();
		return false;
	} 
}

function chkpatID(flag){
	if(flag=='Y'){
		alert(getMessage("PH_NOT_VALID_PATIENT","PH"));
		Clear();
		document.FormCapturePregnenyQueryCriteria.Patient_Id.value="";
		document.FormCapturePregnenyQueryCriteria.Patient_Id.focus();
	}
}
function chk(obj,sys_date,locale,lmp_date){
	if(lmp_date!=""){
		if (CheckDate(obj)){
			if(checkToDate(obj,sys_date,lmp_date)){
				calExpDate(lmp_date);
				calpregStage(lmp_date,locale);//locale added for 40685
			}
			else
				return false ;
		}
		else
			return false ;
	}
	return true;
}
function  checkdates(obj,lmp_date){
	if (CheckDate(obj)){
		chkLmpDate(obj,FormCapturePregnenyQueryResult.lmp_date.value);
	}
	else
		return false;
	return true;
}
function chkPregDays(obj,lmp_date,flag,locale){
	var temp_name=obj.name;
	var temp_date="";
	if(flag=="Y")
		temp_date=parent.f_patientline.frmPatientDetails.sys_date.value
	else
		temp_date=obj.value;
	lmp_date=convertDate(lmp_date,'DMY',locale,"en");//locale added for 40685
	temp_date=convertDate(temp_date,'DMY',locale,"en");//locale added for 40685
	var bean_id		= "CapturePregnencyDetailBean";
	var bean_name	= "ePH.CapturePregnencyDetailBean";
	var xmlDoc="";
	var xmlHttp = new XMLHttpRequest();					
	xmlStr	="<root><SEARCH " ;												
	xmlStr +=" /></root>" ;
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open( "POST", "CapturePregnencyDetailValidation.jsp?&identity=PREG_DAYS"+"&bean_id="+bean_id+"&bean_name="+bean_name+ "&lmp_date="+ lmp_date+"&temp_date="+ temp_date+"&temp_name="+ temp_name+ "&flag="+ flag, false ) ;
	xmlHttp.send( xmlDoc ) ;	
	var retval=eval(xmlHttp.responseText);
	if(retval!=undefined){
		if(flag=="N"){
        if(obj.name=="exp_date")
		obj.value= parent.f_patientline.frmPatientDetails.expd_delv_date.value;
		else if(obj.name=="act_del_date")
		obj.value= parent.f_patientline.frmPatientDetails.actu_delv_date.value;
		}
		else if(flag=="Y"){
			var formObj=parent.f_query_result1.FormCapturePregnenyQueryResult
				    formObj.document.getElementById('yes').disabled=true;
				    formObj.document.getElementById('no').disabled=true;
					formObj.lmp_date.disabled= true;
					formObj.exp_date.disabled= true;
					formObj.act_del_date.disabled= true;
					formObj.expCalendar.disabled= true;
					formObj.LmpCalendar.disabled= true;
					formObj.ActCalendar.disabled= true;
					formObj.document.getElementById("trimster").innerText="";
		            formObj.document.getElementById("preg_week").innerText="";
					return false;
		}
	}
}
function chkpregDaysAlert(preg_days,obj,falg){
	if(parseInt(preg_days)>parseInt(308)){
		var msg= getMessage("EXP_GREAT_LMP_DATE", "PH");
		if(falg=="N"){
			if(obj=="exp_date"){
				msg = msg.replace('$', getLabel("ePH.ExpectedDeliveryDate.label","PH"));
                	alert(msg);
					return false ;
			}
			if(obj=="act_del_date"){
				msg = msg.replace('$', getLabel("ePH.ActualDeliveryDate.label","PH"));
					alert(msg);
					return false ;
				}
		   }
		   else if(falg=="Y"){
					return false;
		 }
     }
}

async function showRemarks(patient_id, srl_no){
	var dialogHeight= "35vh" ;
	var dialogWidth	= "30vw" ;
	var dialogTop 	= "240" ;
	var dialogLeft 	= '700' ;
	var status="no";
	var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; dialogLeft: " + dialogLeft + "; status: " + status + "; dialogTop :" + dialogTop+" scroll=no; ";
	var arguments	= "" ;
	var retVal = await top.window.showModalDialog("../../ePH/jsp/CapturePregnencyDetailRemarks.jsp?patient_id="+patient_id+'&srl_no='+srl_no,arguments,features);
}
