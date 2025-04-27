  //Patient Search from common.js
async function callPatientSearch(){
	if(document.formExternalPresEntry.patient_id.value==""){
		var formObj = document.formExternalPresEntry;
		var regPatientButton_yn	= formObj.regPatientButton_yn.value;
		var patFlag="N";//added for CRF-0216[IN050148] start
		var patient_id="";
		if(regPatientButton_yn=='A')
			regPatientButton_yn='Y';
		else
			regPatientButton_yn='N';
		var pat_id = await PatientSearch('','','','','','','Y','Y',regPatientButton_yn,'Visitreg');//Parameters passed for HSA-CRF-0216 IN[050148]
		if(pat_id!=null && pat_id != ""){
			patFlag=pat_id.charAt(0);
		}
	   	if(patFlag=="Y"&&pat_id!=null)
	   		patient_id=pat_id.substring(1,pat_id.length);
	    	else if(patFlag=="N"&&pat_id!=null)
	    		patient_id=pat_id.substring(0,pat_id.length);
	    	else
	    		patient_id=pat_id;//HSA-CRF-0216 IN[050148] end	
		if(patient_id != null && patient_id != "" )  {
			formObj.patient_id.value = patient_id;
			formObj.patient_id.disabled = true;
			formObj.patient_search.disabled = true;
			callPatientDetails(patient_id);
		}
	}
}

//Date and Time check from dchk.js
function doDateChk(obj){
	if(obj.value.indexOf('.') !=-1 || obj.value.indexOf('-') !=-1){
		retval= false
		alert(getMessage("INVALID_DATE_TIME",'PH'))
		obj.value="";
		obj.focus();
	}
	else{
		var comp=obj
		obj=obj.value
		var dttime = obj.split(" ");
		var dt
		var time
		var retval=true
		if(dttime.length>1){
			dt=dttime[0]
			time=dttime[1]

			if(!checkDt(dt) ){
				retval= false
				alert(getMessage("INVALID_DATE_TIME",'PH'))
				comp.focus()
			}
			else{
				if(time==null || time==""){
					alert(getMessage("INVALID_DATE_TIME",'PH'))
					retval= false;
					comp.focus()
				}

				else{
					if(!chkTime(time)){
							retval= false
							alert(getMessage("INVALID_DATE_TIME",'PH'))
							comp.focus()
					}
				}
			}
		}
		else{
			retval= false
			alert(getMessage("INVALID_DATE_TIME",'PH'))
			comp.focus()
		}

	   /* if(retval){
			//callDateFunction(comp)
		}*/
	}
	return retval
}

function reset(){
	f_query_criteria.document.formExternalPresEntry.reset();
	f_query_criteria.document.formExternalPresEntry.patient_id.disabled	= false ;
	f_query_criteria.document.getElementById('patient_details').innerText = "";
	f_query_criteria.document.formExternalPresEntry.patient_search.disabled	= false ;
	f_query_criteria.document.formExternalPresEntry.othr_factySearch.disabled = false;
	f_query_criteria.document.formExternalPresEntry.other_facility.value	= "" ;
	f_query_criteria.document.formExternalPresEntry.otherfacility_code.value	= "" ;
	f_query_criteria.document.formExternalPresEntry.patient_search.focus();
}

function Clear(){
	document.formExternalPresEntry.reset();
	document.formExternalPresEntry.ref_facility.disabled = false;
//	document.formExternalPresEntry.other_facility.disabled=false;
	document.formExternalPresEntry.othr_factySearch.disabled = false;
	document.formExternalPresEntry.other_facility.value	= "" ;
	document.formExternalPresEntry.otherfacility_code.value	= "" ;
	document.formExternalPresEntry.patient_id.disabled	= false ;
	document.getElementById('patient_details').innerText = "";
	document.formExternalPresEntry.patient_search.disabled	= false ;
	document.formExternalPresEntry.patient_search.focus();


}

function apply(){
	//alert("inside alert");
	var frmObj=f_query_criteria.document.formExternalPresEntry;
	var fields  = new Array() ;
	var names   = new Array() ;
	fields[0]   = frmObj.patient_id ;
	fields[1]   = frmObj.ref_facility ;
	fields[2]   = frmObj.ref_practitioner ;
	fields[3]   = frmObj.dt_ref ;
	fields[4]   = frmObj.remarks ;

	names[0]   = getLabel("Common.patientId.label","Common"); ;
	names[1]   = getLabel("Common.facility.label","Common");
	names[2]   = getLabel("Common.practitioner.label","Common");     
	names[3]   = getLabel("ePH.ReferralDate.label","PH");    
	names[4]   = getLabel("Common.remarks.label","Common");   

	if(f_query_criteria.checkFields( fields, names, messageFrame)) {
		frmObj.patient_id.disabled			= false ;
		frmObj.ref_facility.disabled		= false ;
		frmObj.ref_practitioner.disabled		= false ;
		frmObj.dt_ref.disabled			= false ;
		frmObj.remarks.disabled			= false;

	}
	/*else{
		//messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num=";
	}*/
}

/*
function callPrescription() {
	var frmObj	= document.formExternalPresEntry;
	var objFacVal	 =	frmObj.ref_facility.value;
	var frmObjOthFacility	= frmObj.other_facility;
	var objOthFacVal		= frmObjOthFacility.value;	
	var fields  = new Array() ;
	var names   = new Array() ;
	fields[0]   = frmObj.patient_id ;

//	if(!CheckMaxLen('Other Facility Name ',frmObj.other_facility,10,parent.messageFrame))
//	{
//		frmObj.other_facilty.focus();	
//		return;
//	}
	
	if (objFacVal != null && objFacVal != "")
	{
		fields[1]   = frmObj.ref_facility ;
	}
	else
	{
		fields[1]   = frmObj.other_facility;
	}
	fields[2]   = frmObj.ref_practitioner ;
	fields[3]   = frmObj.dt_ref ;
	fields[4]   = frmObj.remarks ;

	names[0]   = "Patient id" ;
	names[1]   = "Facility" ;
	names[2]   = "Practitioner" ;
	names[3]   = "Order Date" ;
	names[4]   = "Remarks";

	if(parent.f_query_criteria.checkFields( fields, names, parent.messageFrame)) {
		frmObj.patient_id.disabled			= false ;
		frmObj.ref_facility.disabled		= false ;
		frmObj.ref_practitioner.disabled		= false ;
		frmObj.dt_ref.disabled			= false ;
		frmObj.remarks.disabled			= false;
		encounter_id	=	"";
		patient_id		=	frmObj.patient_id.value;
		
		locn_type		=	"P";
		locn_code		=	"";
		patientclass	=	"OP";

		var dialogHeight ='28' ;
		var dialogWidth = '50' ;
		var dialogTop	= '105';
		var dialogLeft = '167' ;

		var title = 'rewe';
		var features = 'dialogHeight:' + dialogHeight + '; dialogWidth:' + dialogWidth +';dialogTop:'+dialogTop+';dialogLeft:'+dialogLeft+';dialogTitle:'+title+'; scroll=yes; status=no';
		
		var arguments			= "";
		var amend_called_from	= "existing_order";
		var orderId				=	"";
		var pract_reln_id		=	"";

		var p_called_from_ca	=	"Y";
	
		var finalString = "function_id=EXTERNAL_ORDERS&ammend_called_from="+amend_called_from+"&order_id="+orderId+"&patient_id="+patient_id+"&episode_id="+encounter_id+"&pract_reln_id="+pract_reln_id+"&location_type="+locn_type+"&location_code="+locn_code+"&patient_class="+patientclass+"&p_called_from_ca="+p_called_from_ca+"&Sex=&Age=&Dob=&visit_adm_date=&iv_prep_yn=&function_from=";
					//alert("frmObj.patient_id.value" + frmObj.patient_id.value);
					var xmlStr ="<root><SEARCH ";

					xmlStr+= "patient_id =\"" + frmObj.patient_id.value + "\" " ;

					if (objFacVal != null && objFacVal != "")
						xmlStr+= "ref_facility =\"" + frmObj.ref_facility.value + "\" " ;
					else
						
						xmlStr+= "other_facility =\"" + objOthFacVal + "\" " ;

					xmlStr+= "ref_practitioner =\"" + frmObj.ref_practitioner.value + "\" " ;
					xmlStr+= "dt_ref =\"" + frmObj.dt_ref.value + "\" " ;
					xmlStr+= "remarks =\"" + frmObj.remarks.value + "\" " ;
					xmlStr+= "bean_id =\"" + frmObj.bean_id.value+frmObj.patient_id.value + "\" " ;
					xmlStr+= "bean_name =\"" + frmObj.bean_name.value + "\" " ;
					xmlStr +=" /></root>";
					var temp_jsp="PrescriptionValidation_1.jsp?func_mode=ExternalPrescription";

		
					
					var xmlDoc = "" ;
					var xmlHttp = new XMLHttpRequest() ;
					xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");

					xmlHttp.open("POST",temp_jsp,false);
					xmlHttp.send(xmlDoc);
					responseText=xmlHttp.responseText ;		
					eval(responseText);
		document.formExternalPresEntry.btnClear.click();	
		document.formExternalPresEntry.all.patient_details.innerText = "";
		document.formExternalPresEntry.patient_search.focus();

		var retVals = window.showModalDialog("../../eOR/jsp/EnterOrder.jsp?"+finalString,arguments,features);
	
//		parent.parent.f_search.document.MedicationAdministrationSearchForm.Search.disabled=false;
//		parent.parent.f_search.document.MedicationAdministrationSearchForm.Search.click();

	}
}
*/

function CheckDate(object,locale){
  if(object.value!=""){   
      if(validDate(object.value,"DMYHM",locale)){
		  if(! isBeforeNow(object.value,"DMYHM",locale)){
				alert(getMessage("START_DATE_GREATER_SYSDATE",'Common'));
				document.formExternalPresEntry.dt_ref.value="";
				document.formExternalPresEntry.dt_ref.focus();
		  }
	  }
	  else{
			alert(getMessage("INVALID_DATE_FMT", "SM"));
			object.value = '';
		    object.focus();
	  }
  }

	/*var date = (object.value).substring(0,10);
	var flag = true;
	var sys_date = sysdate.value;
	if(object.value.length > 1)
	{
		if (!doDateTimeChk(object))
		{
		alert(getMessage("INVALID_DATE_FMT",'PH'));
		object.focus();
		flag = false;
		}
	}
	
	if(flag && object.value.length > 1)
	{
		if(!checkdateWithSysDate(date,sys_date))
			{
				alert(getMessage("START_DATE_GREATER_SYSDATE",'Common'));
				document.formExternalPresEntry.dt_ref.value="";
				document.formExternalPresEntry.dt_ref.focus();
				return false;
			}
	}*/	
		//alert(checkdateWithSysDate(date,sys_date));
	
}

/*function checkdateWithSysDate(entered_date,sys_date) 
{
	
	var enteredDateArray; var sysDateArray;
	var enteredDate = entered_date ;
	var sysDate = sys_date;

	if(enteredDate.length > 0 && sysDate.length > 0 ) 
	{
		enteredDateArray = enteredDate.split("/");
		sysDateArray = sysDate.split("/");
		var enteredDateObject = new Date(enteredDateArray[2],(enteredDateArray[1]-1),enteredDateArray[0]);
		var sysDateObject = new Date(sysDateArray[2],(sysDateArray[1]-1),sysDateArray[0]);	
		if(Date.parse(sysDateObject) < Date.parse(enteredDateObject)) 
		{
			/**
			  * If the sys_date is less than the entered_date date,
			  * i.e., The Entered date is greater than the Current System Date
			  * Then return false to indicate it is wrong..
			  */
			  
		/*	return false;
		}
		else if(Date.parse(sysDateObject) >= Date.parse(enteredDateObject)) return true;
		
	}	
	return true;
}*/

function firstFocus(){
	document.formExternalPresEntry.patient_search.focus();
}

function callPatientDetails(patient_id){
	var frmObj	= document.formExternalPresEntry;
	var xmlStr ="<root><SEARCH ";
	xmlStr+= "patient_id =\"" + frmObj.patient_id.value + "\" " ;
	xmlStr+= "bean_id =\"" + frmObj.bean_id.value+frmObj.patient_id.value + "\" " ;
	xmlStr+= "bean_name =\"" + frmObj.bean_name.value + "\" " ;
	xmlStr+= "locale =\"" + frmObj.locale.value + "\" " ;
	xmlStr +=" /></root>";
	
	var temp_jsp="PrescriptionValidation_2.jsp?func_mode=ExternalPrescription_PatDtls";//Modified for Code limit in PrescriptionValidation_1
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest() ;
	//alert(xmlStr);
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST",temp_jsp,false);
	xmlHttp.send(xmlDoc);
	responseText=xmlHttp.responseText ;		
	eval(responseText);
}

function assignPatientDetails(patient_name,age,sex){
	document.getElementById('patient_details').innerText = decodeURIComponent(patient_name)+" / "+age+" / " +sex;
}


// Function to allow the facility name is either selected from the list or entered 
// Written by P R Venkatasubbu on 8.12.2004 

function CheckVal(){
	var frmObj			= document.formExternalPresEntry;
	
	var frmObjFacility		= frmObj.ref_facility;
	var frmObjOthFacility	= frmObj.otherfacility_code;
	var objFacVal			= frmObjFacility.value;
	var objOthFacVal		= frmObjOthFacility.value;

	if(objOthFacVal != null && objOthFacVal != ""){
		frmObjFacility.value = "";
		objFacVal			= frmObjFacility.value;
	}

	if(objFacVal != null && objFacVal != ""){
		frmObj.other_facility.disabled = true;
		frmObj.othr_factySearch.disabled = true;
		frmObj.ref_referral_facility.disabled = true;
	}
	else{
		frmObj.other_facility.disabled = false;
		frmObj.othr_factySearch.disabled = false;
		frmObj.ref_referral_facility.disabled = false;
	}
}

//function clear_text(obj,obj1,obj2,obj3,obj4){
function clear_text(ref_referral_facility,other_facility,ref_facility,otherfacility_code,othr_factySearch){
	var OtherFacMand = document.getElementById("OtherFacMand");
	var facilityMand = document.getElementById("facilityMand");
	if(ref_referral_facility.name="ref_referral_facility" && ref_referral_facility.selectedIndex==0){
		OtherFacMand.style.display='none';
		facilityMand.style.display='inline';
		other_facility.disabled = false;
		othr_factySearch.disabled = false;
		other_facility.value="";
		otherfacility_code.value="";
		if(ref_referral_facility.value ==null ||ref_referral_facility.value=="")
			ref_facility.disabled=false;
	}
	else if(ref_referral_facility.selectedIndex >0){
		OtherFacMand.style.display='inline';
		facilityMand.style.display='none';
	}
}
/*function CheckVal1()
{
	var frmObj			= document.formExternalPresEntry;
	
	var frmObjFacility		= frmObj.ref_facility;
//	var frmObjOthFacility	= frmObj.other_facility;
	var objFacVal			= frmObjFacility.value;
//	var objOthFacVal		= frmObjOthFacility.value;	


	if(objOthFacVal != null && objOthFacVal != ""){
		frmObj.ref_facility.disabled = true;
		document.getElementById("formExternalPresEntry").mand.style.visibility='hidden';
	}
	else
	{
		frmObj.ref_facility.disabled = false;
		document.getElementById("formExternalPresEntry").mand.style.visibility='visible';
	}
}*/

async function callPrescription() {
	parent.frames[0].document.forms[0].reset.disabled=true;
	var frmObj	= document.formExternalPresEntry;
	
	var objFacVal	 =	frmObj.ref_facility.value;
	var objOtherVal   = frmObj.otherfacility_code.value;


	if(!CheckMaxLen('Other Facility Name ',frmObj.otherfacility_code,10,parent.messageFrame)){
		frmObj.otherfacility_code.focus();	
		return;
	}
	var fields  = new Array() ;
	var names   = new Array() ;
	fields[0]   = frmObj.patient_id ;
	names[0]   = getLabel("Common.patientId.label","Common");
	index = 1;
	if (objFacVal == "" && objOtherVal ==""){
		fields[index]   = frmObj.ref_facility ;
		names[index++]   = getLabel("Common.facility.label","Common")+" / "+getLabel("Common.OtherFacility.label","Common");
	}
	fields[index]   = frmObj.ref_practitioner ;
	names[index++]   =getLabel("Common.practitioner.label","Common");     
	fields[index]   = frmObj.dt_ref ;
	names[index++]   =getLabel("Common.OrderDate.label","Common");                     
	fields[index]   = frmObj.remarks ;
	names[index++]   =getLabel("Common.remarks.label","Common");                           

	if(parent.f_query_criteria.checkFields( fields, names, parent.messageFrame)) {
		frmObj.patient_id.disabled			= false ;
		frmObj.ref_facility.disabled		= false ;
		frmObj.other_facilitydisabled		= false ;
		frmObj.ref_practitioner.disabled	= false ;
		frmObj.dt_ref.disabled				= false ;
		frmObj.remarks.disabled				= false ;		
		encounter_id	=	"";
		patient_id		=	frmObj.patient_id.value;
		
		locn_type		=	"P";
		locn_code		=	"";
		patientclass	=	"OP";

		var dialogHeight ='100vh' ;
		var dialogWidth = '90vw' ;
		var dialogTop	= '10px';
		var dialogLeft = '10px' ;

		var title = 'rewe';
		var features = 'dialogHeight:' + dialogHeight + '; dialogWidth:' + dialogWidth +';dialogTop:'+dialogTop+';dialogLeft:'+dialogLeft+';dialogTitle:'+title+'; scroll=yes; status=no';
		
		var arguments			= "";
		var amend_called_from	= "existing_order";
		var orderId				=	"";
		var pract_reln_id		=	"";

		var p_called_from_ca	=	"Y";
		var finalString = "function_id=EXTERNAL_ORDERS&ammend_called_from="+amend_called_from+"&order_id="+orderId+"&patient_id="+patient_id+"&episode_id="+encounter_id+"&pract_reln_id="+pract_reln_id+"&location_type="+locn_type+"&location_code="+locn_code+"&patient_class="+patientclass+"&p_called_from_ca="+p_called_from_ca+"&Sex=&Age=&Dob=&visit_adm_date=&iv_prep_yn=&function_from=";
		//alert("frmObj.patient_id.value" + frmObj.patient_id.value);
		var xmlStr ="<root><SEARCH ";

		xmlStr+= "patient_id =\"" + frmObj.patient_id.value + "\" " ;

		if (objFacVal != null && objFacVal != "")
			xmlStr+= "ref_facility =\"" + frmObj.ref_facility.value + "\" " ;
		else
			xmlStr+= "other_facility =\"" + objOtherVal + "\" " ;

		xmlStr+= "ref_practitioner =\"" + frmObj.ref_practitioner.value + "\" " ;
		xmlStr+= "dt_ref =\"" + convertDate(frmObj.dt_ref.value,'DMYHM',frmObj.locale.value,'en') + "\" " ;
		xmlStr+= "remarks =\"" + encodeURIComponent(frmObj.remarks.value,"UTF-8") + "\" " ;  // encodeURIComponent added for ML-BRU-SCF-0234 [IN:033164]
		xmlStr+= "bean_id =\"" + frmObj.bean_id.value+frmObj.patient_id.value + "\" " ;
		xmlStr+= "bean_name =\"" + frmObj.bean_name.value + "\" " ;
		xmlStr +=" /></root>";
		var temp_jsp="PrescriptionValidation_2.jsp?func_mode=ExternalPrescription";
		var xmlDoc = "" ;
		var xmlHttp = new XMLHttpRequest() ;
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open("POST",temp_jsp,false);
		xmlHttp.send(xmlDoc);
		responseText=xmlHttp.responseText ;		
		eval(responseText);
		document.formExternalPresEntry.btnClear.click();	
		document.getElementById('patient_details').innerText = "";
		document.formExternalPresEntry.patient_search.focus();
		//[IN030566] Starts]
		var xmlDoc 		= "" ;		
		var xmlHttp 	= new XMLHttpRequest() ;
		var	xmlStr			= "<root><SEARCH " ;
		xmlStr 			+=" /></root>" ;
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open( "POST", "../../eOR/jsp/EnterOrderValidate.jsp?patient_id="+patient_id, false ) ;
		xmlHttp.send( xmlDoc ) ;
		if(trimString(xmlHttp.responseText)=="true"){
			var retVals = await top.window.showModalDialog("../../eOR/jsp/EnterOrder.jsp?"+finalString,arguments,features);
		}
		//var retVals = window.showModalDialog("../../eOR/jsp/EnterOrder.jsp?"+finalString,arguments,features);
		//[IN030566] Ends
//		parent.parent.f_search.document.MedicationAdministrationSearchForm.Search.disabled=false;
//		parent.parent.f_search.document.MedicationAdministrationSearchForm.Search.click();

	}
}

async function callOtherfactySeach(){
	var formObj				= document.formExternalPresEntry;
	var argumentArray		= new Array() ;
	var dataNameArray       = new Array() ;
	var dataValueArray		= new Array() ;
	var dataTypeArray		= new Array() ;

	dataNameArray[0]		= "HEALTHCARE_SETTING_TYPE" ;
	dataValueArray[0]		= formObj.ref_referral_facility.value;
	dataTypeArray[0]		= STRING ;

	argumentArray[0]		= formObj.othr_facty_sql.value;
	argumentArray[1]		= dataNameArray ;
	argumentArray[2]		= dataValueArray ;
	argumentArray[3]		= dataTypeArray ;
	argumentArray[4]	    = "2,3";
	argumentArray[5]		= formObj.other_facility.value ;
	argumentArray[6]		= DESC_LINK ;
	argumentArray[7]		= DESC_CODE ; 
	//alert("argumentArray   "+argumentArray);
	retVal = await CommonLookup( getLabel("Common.OtherFacility.label","Common"), argumentArray );
	var ret1=unescape(retVal);
	var arr=ret1.split(",");	
	if(retVal != null && retVal != "" )  {
		formObj.other_facility.value		=	 arr[1] ;
		formObj.otherfacility_code.value	=	 arr[0];
		formObj.other_facility.disabled				  =  true;
		formObj.othr_factySearch.disabled =	  true;
		formObj.ref_facility.disabled =	  true;
	}
}

function chkPatientID(){
	var formObj			= document.formExternalPresEntry;
	var patient_id		= formObj.patient_id.value;
	if(patient_id=="")
	formObj.patient_search.disabled=false;
	else
	formObj.patient_search.disabled=true;
	var called			="patientid"
	var bean_id			= "DirectDispensingBean" ;
	var bean_name		= "ePH.DirectDispensingBean";
	if(patient_id!=null &&patient_id!="" && patient_id!=undefined){
		xmlStr ="<root><SEARCH " ;
		xmlStr			+= " bean_id=\""+ bean_id + "\" ";
		xmlStr			+= " bean_name=\""+ bean_name + "\" ";
		xmlStr		    += " patient_id=\""+ patient_id + "\" ";
		xmlStr		    += " called=\""+ called + "\" ";
		xmlStr +=" /></root>" ;
		var temp_jsp="DirectDispValidate.jsp?func_mode=CALLPATIENT";
		var xmlDoc = "" ;
		var xmlHttp = new XMLHttpRequest() ;
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open("POST",temp_jsp,false);
		xmlHttp.send(xmlDoc);
		responseText=xmlHttp.responseText ;
		eval(responseText);
	}
}

function chkpatID(flag){
	if(flag=='Y'){
		alert(getMessage("PH_NOT_VALID_PATIENT","PH"));
		document.formExternalPresEntry.patient_id.value="";
		document.formExternalPresEntry.patient_id.focus();
	}
	else{
		document.formExternalPresEntry.patient_search.disabled=true;
	    callPatientDetails(document.formExternalPresEntry.patient_id.value);
	}
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
