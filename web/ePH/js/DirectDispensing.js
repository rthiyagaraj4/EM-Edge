/*
----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
Date			Edit History		Name		Rev.Date		Rev.Name				Description
----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
29/08/2019      IN:070451           B Haribabu  29/08/2019      Manickam                 ML-MMOH-CRF-1408
06/12/2019      IN:070451           Manickavasagam                         		 MMS-KH-CRF-0029
18/02/2020		IN071362                Manickavasagam J                       AAKH-CRF-0117
06/07/2020      IN:072715          Haribabu     06/07/2020     Manickavasagam     MMS-DM-CRF-0165
28/07/2020      IN:073485                   Haribabu                                PH-MMS-DM-CRF-0165/01-Normal rx-Amend order
24/08/2020      IN073488		   B Haribabu                                           PH-MMS-Direct Dispensing
20/10/2020      IN:069886         Haribabu                       Manickam            MO-CRF-20151
12/11/2020     IN:069887       Haribabu         13/11/2020     Manickavasagam     MO-CRF-20152
----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
*/   
var oldrepeatvalue;
var return_val  = true;
var result      =false;
var current_facility="C";
var chkBMSTab="";
var message = "" ;
function changeCol(obj){
	obj.className="FOCUSDRUGS";
}
function changeBorder(obj){
	obj.className="CLICKDRUGS";
}
function realCol(obj,classVal){
	obj.className=classVal;
}
function reset(){
	var formObj			= f_query_add_mod.document.DirectDispensingQueryCriteria;
	var bean_id			= formObj.bean_id.value ;
	var bean_name	    = formObj.bean_name.value ;	
	var xmlStr			= "<root><SEARCH ";
	xmlStr			+= " bean_id=\""+ bean_id + "\" ";
	xmlStr			+= " bean_name=\""+ bean_name + "\" ";
	xmlStr			+= " /></root>";	
	fieldValidation(xmlStr,"reset");		
}
function reset1(){	
	f_query_add_mod.location.reload();
	f_detail.location.href="../../eCommon/html/blank.html"; 
}

function reset2(){	
	parent.parent.parent.f_query_add_mod.location.reload();
	parent.parent.parent.f_detail.location.href="../../eCommon/html/blank.html"; 
}

function ChkMaxLen(lab,obj,max) {
	if(obj.value.length >= max) { 
		alert("APP-SM0045 - " + lab + getLabel("ePH.Cannotexceed.label","PH") +"  "+max  +"  "+ getLabel("ePH.characters.label","PH") );
		obj.select();
		return false;
	}
	else
		return true;
}

// This will call common patient search
async function callPatientSearch(){	 
	var patient_id= await PatientSearch();
	if(patient_id!=null && patient_id!='undefined'&& patient_id!=""){
		parent.f_query_add_mod.document.DirectDispensingQueryCriteria.patient_id.value=patient_id;
	}
}

async function searchPractioner1(){ 
	
	var argumentArray  = new Array() ;
	var dataNameArray  = new Array() ;
	var dataValueArray = new Array() ;
	var dataTypeArray  = new Array() ;

	var formObj		   = parent.f_query_add_mod.document.DirectDispensingQueryCriteria;	
	formObj.practioner_name.value="";
	argumentArray[0]   = formObj.SQL_PH_DISP_LOCN_SELECT10.value;
	argumentArray[1]   = dataNameArray ;
	argumentArray[2]   = dataValueArray ;
	argumentArray[3]   = dataTypeArray ;
	argumentArray[4]   = "1,2";
	argumentArray[5]   = formObj.practioner_name.value ;
	argumentArray[6]   = DESC_LINK ;
	argumentArray[7]   = DESC_CODE ; 	
	retVal = await CommonLookup( getLabel("Common.practitioner.label","Common"), argumentArray );	
	var ret1=unescape(retVal);
 	var arr=ret1.split(",");
	if(retVal != null && retVal != "" )  {
		formObj.practioner_name.value = arr[1] ;
		formObj.practioner_id.value = arr[0];
		var bean_id			 =  formObj.bean_id.value;//Added for INC#048044 --start
		var bean_name		 =  formObj.bean_name.value;
		var xmlStr			 = "<root><SEARCH ";
		xmlStr			+= " bean_id=\""+ bean_id + "\" ";
		xmlStr			+= " bean_name=\""+ bean_name + "\" ";
		xmlStr			+= " practioner_id=\""+ arr[0] + "\" ";
		xmlStr		    += " practioner_name=\""+encodeURIComponent(arr[1]) + "\" ";
		xmlStr			+= " /></root>";
		fieldValidation(xmlStr,"savePractDetails");//Added for INC#048044 --end
		
	}
}
async function searchEncounterId(obj){
	var formObj			= parent.f_query_add_mod.document.DirectDispensingQueryCriteria;
    formObj.encounter_id.value="";
	formObj.practioner_name.value="";
	var patient_id		= formObj.patient_id.value;
	var disp_locn_code	= formObj.disp_locn_code.value;
	var encounter_id    = formObj.encounter_id.value;
	if(encounter_id==null)
		encounter_id="";
	var dialogHeight	= "400px" ;
	var dialogWidth		= "700px" ;
	var dialogTop		= "10" ;
	var dialogLeft		= "20" ;
	var center			= "1" ;
	var status			="no";
	var features		= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop+ "; dialogLeft :" + dialogLeft;
	var arguments	= "" ;
	retVal = await window.showModalDialog("../../ePH/jsp/DirectDispensingEncounter.jsp?patient_id="+patient_id+"&disp_locn_code="+disp_locn_code+"&encounter_id="+encounter_id,arguments,features);
	  if(retVal){
		  parent.document.getElementById('dialog_tag').close();   
		  parent.f_query_add_mod.location.reload();
	  }
}
function ValidateAbs(obj) {
	if(parseInt(obj.value)==0 || obj.value=="") {
		alert(getMessage("ABS_QTY_CANNOT_ZERO","PH"));
		obj.focus();
		return;
	}
	loadallocatedetail('allocate','ONCLICK');
}

//this method will be called on click of proceed
function chkPatientID1(){
	var formObj			= parent.f_query_add_mod.document.DirectDispensingQueryCriteria;
	var patient_id		= formObj.patient_id.value;
	var encounter_id		= formObj.encounter_id.value;
	var disp_locn_code	= formObj.disp_locn_code.value;
	var called			="proceed";
	if(patient_id!=null &&patient_id!="" && patient_id!=undefined){
		var bean_id			= formObj.bean_id.value ;
		var bean_name	    = formObj.bean_name.value ;	
		xmlStr ="<root><SEARCH " ;
		xmlStr			+= " bean_id=\""+ bean_id + "\" ";
		xmlStr			+= " bean_name=\""+ bean_name + "\" ";
		xmlStr		    += " patient_id=\""+ patient_id + "\" ";
		xmlStr		    += " encounter_id=\""+ encounter_id + "\" ";
		xmlStr		    += " disp_locn_code=\""+ disp_locn_code + "\" ";
		xmlStr		    += " called=\""+ called + "\" ";

		xmlStr +=" /></root>" ;
		fieldValidation(xmlStr,"CALLPATIENT");	
	}		
}

function calldrugframes(allergy_conf_reqd_yn){
	var flag		   = mandvalues();
	var formObj		   = parent.f_query_add_mod.document.DirectDispensingQueryCriteria;
	if(flag=='true'){
		if(allergy_conf_reqd_yn=='true'){  //if block added for RUT-CRF-0064.1 [IN:041799]
			var allergyConf = true;
			if(allergy_conf_reqd_yn){
				allergyConf = confirm(getMessage("PH_PRES_ALLERGY_CONF", "PH"));
			}
			if(!allergyConf)
				return false;
		}
		formObj.disp_locn_code.disabled		= true;        
		formObj.patient_id.disabled			= true;
		formObj.btnPatientID.disabled		= true; 
		formObj.encounter_id.disabled		= true;  
        formObj.btnencounter.disabled		= true;
		formObj.practioner_name.disabled	= true;  
        formObj.btnpractsearch.disabled		= true;
		formObj.btnProceed.disabled			= true;
		var pract_id   = formObj.practioner_id.value;
		var pract_name = formObj.practioner_name.value;
		parent.f_detail.location.href="../../ePH/jsp/DirectDispFrames.jsp?pract_id="+pract_id+"&pract_name="+pract_name;		
	}
	else{
		alert(getMessage("PH_MANDATORY","PH"));
	}
}

function mandvalues(){
   var formObj		   = parent.f_query_add_mod.document.DirectDispensingQueryCriteria;
   var flag			   = 'true';
   if(formObj.patient_id.value==""){
	   flag='false'
   }
   if(formObj.enctr_dtls.value=="Y"){
	   if(formObj.encounter_id.value==""){
		   flag='false'
	   }
   }
   if(formObj.disp_locn_code.value==""){
	   flag='false'
   }
     if(formObj.practioner_name.value==""){
	   flag='false'
   }
   return flag;
}
function saveEncounterIDDetails(frmobj,i){
	
    var patient_class	 =	eval("frmobj.patient_class_"+i+".value");
	var practioner_id	 =	eval("frmobj.practioner_id_"+i+".value");
	var ord_locn		 =	eval("frmobj.ord_locn_"+i+".value");
	var encounter_id	 =	eval(document.getElementById("encounter_id_"+i)).innerText;
	var practioner_name  =	eval(document.getElementById("pract_name_"+i)).innerText;
	var ord_locn_name	 =  eval(document.getElementById("ord_locn_name_"+i)).innerText;
	var bean_id			 =  frmobj.bean_id.value;
	var bean_name		 =  frmobj.bean_name.value;
	var xmlStr			 = "<root><SEARCH ";
	xmlStr			+= " bean_id=\""+ bean_id + "\" ";
	xmlStr			+= " bean_name=\""+ bean_name + "\" ";
	xmlStr		    += " patient_class=\""+ patient_class + "\" ";
	xmlStr			+= " practioner_id=\""+ practioner_id + "\" ";
	xmlStr		    += " ord_locn=\""+ ord_locn + "\" ";
	xmlStr			+= " encounter_id=\""+ encounter_id + "\" ";
	xmlStr		    += " practioner_name=\""+encodeURIComponent( practioner_name) + "\" ";
	xmlStr			+= " ord_locn_name=\""+ encodeURIComponent(ord_locn_name) + "\" ";
	xmlStr			+= " /></root>";
	fieldValidation(xmlStr,"saveEncounterIDDetails");
	parent.document.getElementById('dialog-body').contentWindow.returnValue = 'true';
	parent.document.getElementById('dialog_tag').close();   

}
function fieldValidation(xmlStr,source){
    var xmlHttp = new XMLHttpRequest() ;
    var xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
    xmlHttp.open("POST","DirectDispValidate.jsp?func_mode="+source,false);	
    xmlHttp.send(xmlDoc);
    responseText=xmlHttp.responseText ;
	eval(responseText);
    return true;
}
function formXMLString(formobj,fldString){
	
	var bean_id=formobj.bean_id.value;
	var bean_name=formobj.bean_name.value;
	var mode=formobj.mode.value;
	var xmlStr ="<root><SEARCH ";
	xmlStr += " bean_id=\""+ bean_id + "\" ";
	xmlStr += " bean_name=\""+ bean_name + "\" ";
	xmlStr += " mode=\""+ mode + "\" ";
	xmlStr +=fldString;
	xmlStr +=" /></root>";
	return xmlStr;
}
function validateBSA(){
	
	var formobj		= parent.parent.f_detail.f_header.document.dir_disp_header_form;
	var height		= formobj.height.value;
	var weight		= formobj.weight.value;
    var bean_id     = formobj.bean_id.value;
	var bean_name   = formobj.bean_name.value;

	if( (height!="") && (weight!="") ){		
		var xmlStr		 = "<root><SEARCH ";
		xmlStr			+= " height=\""+ height + "\" ";
		xmlStr			+= " weight=\""+ weight + "\" ";
		xmlStr			+= " bean_id=\""+ bean_id + "\" ";
	    xmlStr			+= " bean_name=\""+ bean_name + "\" ";

		xmlStr			+= " /></root>";
		return fieldValidation(xmlStr,"validateBSA");
	} else {
		formobj.bsa.value	=	"";
		formobj.bmi.value	=	"";
		parent.parent.f_detail.f_header.document.getElementById('bsa_lbl').innerHTML	=	"";
		parent.parent.f_detail.f_header.document.getElementById('bmi_lbl').innerHTML	=	"";
	}
}
function assignBSA(bsa,bmi){
	var index	=	bmi.indexOf(".");	
	bmi			=  (bmi.substr(0,index+3));
	parent.parent.f_detail.f_header.document.getElementById('bsa_lbl').innerHTML				=	"<b>"+bsa+"</b>";
	parent.parent.f_detail.f_header.document.getElementById('bmi_lbl').innerHTML				=	"<b>"+bmi+"</b>";
	parent.parent.f_detail.f_header.document.dir_disp_header_form.bsa.value		=	bsa;
	parent.parent.f_detail.f_header.document.dir_disp_header_form.bmi.value		=	bmi;
	
}
/*
function checkWeight(weight) {
	var formobj		= parent.parent.f_detail.f_header.document.dir_disp_header_form;
	var weight_min	= formobj.weight_min.value;
	var weight_max	= formobj.weight_max.value;

	if(weight.value!=null && weight.value!="" && weight_min!=null && weight_min!="") {
		if( (parseFloat(weight.value) < parseFloat(weight_min) ) || (parseFloat(weight.value) > parseFloat(weight_max) ) ) {
				alert(getMessage("WEIGHT_BETWEEN","PH") + weight_min +" and "+weight_max);
				weight.focus();
		} else {
			putDecimal(weight,8,2);
			
		}
	} else {
		putDecimal(weight,8,2);
		
	}
}*/
function checkDecimal(Obj,maxdigits,mindigits,deci){  
	var formObj = document.dir_disp_header_form;
	var temp1=Obj.value;
	var temp4=Obj.value.length;
	var count=parseInt(maxdigits) -parseInt(deci);
	var flag=false;
	var msg="";
	if(maxdigits=='' && mindigits=='')
		return false;
	if(temp4 >0){
		if(temp4 >= parseInt(mindigits)){
			if(temp4 > parseInt(maxdigits)){
				flag= false;
				msg= getMessage("MAXIMUM_DIGIT_VALUE",'PH')+" "+maxdigits;
			}
			else if (parseInt(deci) > 0){
				if(temp1.indexOf('.') <0){
					if (temp4 <= parseInt(maxdigits)){
						if(temp1.length <= (parseInt(maxdigits) -parseInt(deci))){
							var temp2=temp1.substring(0,count);
							var temp3=temp2+"."+temp1.substring(count,temp1.length)
							if(temp3.length-1 < parseInt(maxdigits)){
								for(var t=0;t <=(parseInt(maxdigits)-temp3.length);t++)	{
									temp3+="0";
								}
							}
							Obj.value=temp3;
						}
						else if(temp1.length <= (parseInt(maxdigits) -parseInt(deci)) && temp1.length <= maxvalue){
							var temp3=temp1+'.';
							for(var m=0;m<deci;m++)
								temp3+="0";
							Obj.value=temp3;
						}
						flag=true;
					}
					else{
						msg=getMessage("MAXIMUM_DIGIT_VALUE",'PH')+" "+maxdigits;
						flag= false;
					}
				}
				else{
					var temp5=temp1.indexOf('.');
					if (parseInt(temp5) < parseInt(maxdigits)){
						var temp7=temp1.substring(0,temp5);
						var temp6=temp1.substring((temp5+1),(parseInt(temp7.length)+parseInt(deci)+1));
						if (temp6 == ""){
							temp6 = 0;
						}
						if(temp7=="")
							temp7=0;
						Obj.value=temp7+"."+temp6;
						flag=true;
					}
					else{
						flag= false;
						msg= getMessage("MAXIMUM_DIGIT_VALUE",'PH')+" "+maxdigits;
					}
				}
			}
			else{
				if(temp1.indexOf('.') >0){
					flag=false;
					msg=getMessage("DECIMAL_FRACTION_NOT_ALLOWED",'PH');
				}
				else 
					flag=true;
			}
		}
		else {
			if(mindigits!=''){
				msg=getMessage("MINIMUM_NUMBERS_DIGIT",'PH')+" "+mindigits;
				flag=false;
			}
			else{
				flag=true;
			}
		}
		if(flag){
			if(Obj.name=='height')
				checkHeight(formObj);
			else if(Obj.name='weight')
				checkWeight(formObj);
		}
		else{
			alert(msg);
			Obj.value="";
			//Obj.focus();
		}
	}
}

function checkHeight(formObj){
	var height_min	=	formObj.height_min_value.value;
	var height_max	=	formObj.height_max_value.value;
	var fieldname = getLabel("Common.height.label","Common");
	if(formObj.height.value!="" && parseFloat(formObj.height.value)==0){
		var msg = getMessage("HEIGHT_WEIGHT_CANNOT_ZERO", "PH")
		msg = msg.replace('$', fieldname);
		alert(msg);
		formObj.height.value="";
		formObj.height.focus();
		return false;
	}
	if(formObj.height.value!=null && formObj.height.value!="" && height_min!=null && height_min!="") {
		if( (parseFloat(formObj.height.value) < parseFloat(height_min) ) || (parseFloat(formObj.height.value) > parseFloat(height_max) ) ) {
			var msg = getMessage("HEIGHT_WEIGHT_RANGE", "PH");
		    msg = msg.replace('$', fieldname);
		    msg = msg.replace('#', height_min)+" "+height_max;
			alert(msg);
			formObj.height.select();
			formObj.height.focus();
			formObj.height.value="";
			return false;
		}
	}
}

function checkWeight(formObj) {
	var weight_min	=	formObj.weight_min_value.value;
	var weight_max	=	formObj.weight_max_value.value;
	var fieldname = getLabel("Common.weight.label","Common");
	if(formObj.weight.value!="" && parseFloat(formObj.weight.value)==0){
		var msg = getMessage("HEIGHT_WEIGHT_CANNOT_ZERO", "PH");
		msg = msg.replace('$', fieldname);
		alert(msg);
		formObj.weight.value="";
		formObj.weight.focus();
		return false;
	}

	if(formObj.weight.value!=null && formObj.weight.value!="" && weight_min!=null && weight_min!="") {
		if( (parseFloat(formObj.weight.value) < parseFloat(weight_min) ) || (parseFloat(formObj.weight.value) > parseFloat(weight_max) ) ) {
			var msg = getMessage("HEIGHT_WEIGHT_RANGE", "PH");
			msg = msg.replace('$', fieldname);
			msg = msg.replace('#', weight_min)+" "+weight_max;
			alert(msg);
			formObj.weight.value="";
			formObj.weight.select();
			formObj.weight.focus();
			return false;
		}
	}
}

function chkBackFutureOrderDate(obj){
if(obj.value!=""){
	var formobj		= parent.parent.f_detail.f_header.document.dir_disp_header_form;
	var back_date	= formobj.back_date;
	var future_date = formobj.future_date;
	if(doDateTimeChk(obj)){
		if(future_date!="0"){
			if(ValidateDateTime(obj,future_date)){
			}else{
				alert(getMessage("PH_BACK_DATE","PH"));
				obj.focus();
				return false;
			}
		}
		if(back_date!="0"){
			if(! ValidateDateTime(back_date,obj)){				
				alert(getMessage("PH_BACK_DATE","PH"));
				obj.focus();
				return false;
			}
		}else{
		   obj.disabled=true;
		}
	}else{
		alert(getMessage("INVALID_DATE_TIME","PH"));
		obj.focus;
		return false;
	}
	}
}
async function callDiagText(patient_id,called_frm) {
	var dialogHeight= "10";
	var dialogWidth	= "34" ;
	var dialogTop = "169" ;
	var center = "1" ;
	var status="no";
	var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop;
	var arguments	= "" ;
	retVal = await window.showModalDialog("../../ePH/jsp/DirectDispDiagTextFrames.jsp?patient_id="+patient_id+"&called_frm="+escape(called_frm),arguments,features);
	
}
async function callOrderRemarks(){
	   	var patient_id=document.dir_disp_header_form.patient_id.value;
		var encounter_id	= document.dir_disp_header_form.encounter_id.value;
		var order_remarks	= document.dir_disp_header_form.order_remarks.value;
		var dialogHeight= "50vh" ;
		var dialogWidth	= "35vw" ;
		var dialogTop = "0" ;
		var dialogLeft = "10" ;
		var center = "1" ;
		var status="no";
		var scroll="yes";
		var features	= "dialogLeft:" + dialogLeft + ";dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; center: " + center + ";scroll "+scroll+"; status: " + status + "; dialogTop :" + dialogTop;
		var arguments	= "" ;
		retVal = await window.showModalDialog("../../ePH/jsp/DirectDispRemarksFrame.jsp?order_remarks="+order_remarks,arguments,features);		
		if(retVal!=null)
			document.dir_disp_header_form.order_remarks.value=retVal;

}
function saveRemarks(obj){

	var remarks		= obj.order_remarks.value;
	var bean_id		= obj.bean_id.value;
	var bean_name	= obj.bean_name.value;
	var mode		= "0";	
	var xmlStr		= "<root><SEARCH ";
		xmlStr	   += " bean_id=\""+ bean_id + "\" ";
		xmlStr     += " bean_name=\""+ bean_name + "\" ";
		xmlStr     += " mode=\""+ mode + "\" ";
		xmlStr     += " remarks=\""+ remarks + "\" ";
		xmlStr     += " /></root>";
	
	parent.parent.parent.window[2].document.getElementById('dialog_tag').close();
	return fieldValidation(xmlStr,"saveRemarks");

}
 function loadOtherFrames(){
	var hdr_formobj		 = parent.parent.f_detail.f_header.document.dir_disp_header_form;
	var mode               ='blank';
	var order_date_time	 = hdr_formobj.sys_date.value;
	var allow_without_diag = hdr_formobj.allow_without_diag.value;
	var allergic_yn        = hdr_formobj.allergic_yn1.value;
	parent.parent.f_detail.f_ord_detail.f_drug_detail.f_drug.location.href="../../ePH/jsp/DirectDispDrugDetails.jsp?mode="+mode+"&start_date="+order_date_time+"&allow_without_diag="+allow_without_diag+"&allergic_yn="+allergic_yn;  parent.parent.f_detail.f_ord_detail.f_drug_detail.f_button_1.location.href="../../ePH/jsp/DirectDispButtons_1.jsp?&mode="+mode+"&display1_yn=N"+"&display2_yn=N";
}

function chkPatientID(){
	var formObj			= parent.f_query_add_mod.document.DirectDispensingQueryCriteria;
	var patient_id		= formObj.patient_id.value;
	var disp_locn_code	= formObj.disp_locn_code.value;
	var called			="patientid";
	if(patient_id!=null &&patient_id!="" && patient_id!=undefined){
		var bean_id			= formObj.bean_id.value ;
		var bean_name	    = formObj.bean_name.value ;	
		xmlStr ="<root><SEARCH " ;
		xmlStr			+= " bean_id=\""+ bean_id + "\" ";
		xmlStr			+= " bean_name=\""+ bean_name + "\" ";
		xmlStr		    += " patient_id=\""+ patient_id + "\" ";
		xmlStr		    += " disp_locn_code=\""+ disp_locn_code + "\" ";
		xmlStr		    += " called=\""+ called + "\" ";
		xmlStr +=" /></root>" ;
		fieldValidation(xmlStr,"CALLPATIENT");	
	}
}

function chkpatID(flag){
	if(flag=='Y'){
	    alert(getMessage("PH_NOT_VALID_PATIENT","PH"));
	    parent.f_query_add_mod.document.DirectDispensingQueryCriteria.patient_id.focus();
	}
	else{
		parent.f_query_add_mod.document.DirectDispensingQueryCriteria.encounter_id.value="";
		searchEncounterId( parent.f_query_add_mod.document.DirectDispensingQueryCriteria.patient_id);
	}
}
async function drugSearch(drugCode){
	
    var hdr_formobj		 = parent.parent.parent.parent.f_detail.f_header.document.dir_disp_header_form;

	var quecrt_frmobj    = parent.parent.parent.parent.f_query_add_mod.document.DirectDispensingQueryCriteria;

	var service_search_yn	= hdr_formobj.service_search_yn.value;
	var servide_code		= hdr_formobj.servide_code.value;
	var pat_id				= hdr_formobj.patient_id.value;
	var enc_id				= hdr_formobj.encounter_id.value;
	var patient_class		= hdr_formobj.patient_class.value;
	var discharge_yn		= 'N';
	var priority			= hdr_formobj.priority.value;
	var source_code			= hdr_formobj.source_code.value;	
	var source_type         = hdr_formobj.source_type.value;
    var disp_locn_code      =quecrt_frmobj.disp_locn_code.value;
	var date_of_birth		= hdr_formobj.date_of_birth.value;
	var gender				= hdr_formobj.gender.value;

	var bean_id				= "@DrugSearchBean"+pat_id+enc_id;
	var order_type_code="";	
	if(enc_id==""){
	   patient_class="R";
	}
	retVal = await DrugSearchForDirectDispensing("D",	parent.parent.parent.parent.f_detail.f_ord_detail.f_drug_detail.f_drug.document.prescription_detail_form.drug_name,order_type_code,drugCode,bean_id,service_search_yn,servide_code,patient_class,priority,discharge_yn,pat_id,enc_id,date_of_birth,gender,source_type,source_code,'','','DIRECT',disp_locn_code,"","","Y");//Y added for GHL-CRF-0549
	var Drug_Codes =  new Array();
	var	Trade_Codes = new Array();
	var Trade_Names = new Array();
	var i=0;
	var index=0;

	if(retVal.length>0){
		while(i<retVal.length){
			Drug_Codes[index]=retVal[i++];
			Trade_Codes[index]=retVal[i++];
			Trade_Names[index++]=retVal[i++];
		}
	}
	
	if(Drug_Codes.length>0 )  {		
		
		chkDuplicateDrugCode(Drug_Codes, Trade_Codes, Trade_Names );
	}

}
//for checking duplicate drug and setting drug details in bean
function chkDuplicateDrugCode(retVal,Trade_Codes, Trade_Names){
	var formObj					= parent.parent.parent.parent.f_query_add_mod.document.DirectDispensingQueryCriteria;	
    var hdr_formobj				= parent.parent.parent.parent.f_detail.f_header.document.dir_disp_header_form;	
	var language_id				= hdr_formobj.language_id.value;
	var bean_id					= formObj.bean_id.value ;
	var bean_name				= formObj.bean_name.value ;
	var facility_id				= hdr_formobj.facility_id.value;
	var patient_class			= hdr_formobj.patient_class.value;
	var patient_id				= hdr_formobj.patient_id.value;
	var encounter_id			= hdr_formobj.encounter_id.value;
	var sys_date				= convertDate(hdr_formobj.sys_date.value,"DMYHM",language_id,"en");
	var location_type			= hdr_formobj.location_type.value;
	var location_code			= hdr_formobj.location_code.value;
	var priority				= hdr_formobj.priority.value;
	var take_home_medication	= hdr_formobj.take_home_medication.value;
	var drug_db_interface_yn	= hdr_formobj.drug_db_interface_yn.value;
	var atc_allergy_alert_level	= hdr_formobj.atc_allergy_alert_level.value;
	var Drug_db_prod_id			= hdr_formobj.Drug_db_prod_id.value;
	//var drug_db_duptherapy_yn	= hdr_formobj.drug_db_duptherapy_yn.value;
	//var drug_db_dosecheck_yn	= hdr_formobj.drug_db_dosecheck_yn.value;

	var licence			= hdr_formobj.licence.value;
	xmlStr	 ="<root><SEARCH " ;
	xmlStr	+=" bean_id=\""+ bean_id + "\" ";
	xmlStr	+=" bean_name=\""+ bean_name + "\" ";
	xmlStr	+=" drug_code=\""+ retVal + "\" ";
	xmlStr	+=" facility_id=\""+ facility_id + "\" ";
	xmlStr	+=" patient_class=\""+ patient_class + "\" ";
	xmlStr	+=" patient_id=\""+ patient_id + "\" ";
	xmlStr	+=" encounter_id=\""+ encounter_id + "\" ";
	xmlStr	+=" sys_date=\""+ sys_date + "\" ";
	xmlStr	+=" drugCodes=\""+ retVal + "\" ";
	xmlStr	+=" locn_type=\""+ location_type + "\" ";
	xmlStr	+=" locn_code=\""+ location_code + "\" ";
	xmlStr	+= " licence=\""+ licence + "\" ";
	xmlStr	+=" priority=\""+ priority + "\" ";
	xmlStr	+=" take_home_medication=\""+ take_home_medication  + "\" ";
	xmlStr  +=" drug_db_interface_yn=\""+ drug_db_interface_yn +"\" ";
	xmlStr  +=" Drug_db_prod_id=\""+ Drug_db_prod_id +"\" ";
	xmlStr  +=" trade_codes=\""+ Trade_Codes +"\" "; 
	xmlStr  +=" trade_names=\""+ Trade_Names +"\" "; 
	xmlStr  +=" atc_allergy_alert_level=\""+ atc_allergy_alert_level +"\" "; 
	xmlStr	+=" /></root>" ;	
	fieldValidation(xmlStr,"chkDuplicateDrugCode");
}

function loadDetailForm(){
	var adr_count		= parent.parent.parent.parent.f_detail.f_header.document.dir_disp_header_form.adr_count.value;
	parent.parent.parent.parent.f_detail.f_ord_detail.f_drug_list.f_list.location.href="../../ePH/jsp/DirectDispDrugList.jsp?&adr_count="+adr_count;
}

function invalidDrug(){
	alert(getMessage("PH_DRUG_CODE","PH"));
}

function recommendDosage(drug_code,modify,srl_no, called_from) {
	var hdr_formobj		= parent.parent.parent.parent.f_detail.f_header.document.dir_disp_header_form;
	//added for Bru-HIMS-CRF-079 IN[029945] - start
	var wt_mand_yn = eval("document.prescription_form.wt_mand_yn"+srl_no).value;
	var ht_mand_yn = eval("document.prescription_form.ht_mand_yn"+srl_no).value;
	var weight_rec_appl_age_group_check_flag = eval("document.prescription_form.weight_rec_appl_age_group_check_flag"+srl_no).value;
	if(wt_mand_yn=='Y')
		hdr_formobj.wt_mand_yn.value="Y";
	if(ht_mand_yn=='Y')
		hdr_formobj.ht_mand_yn.value="Y";

	if(weight_rec_appl_age_group_check_flag == 'Y'){
		if((hdr_formobj.height.value=="" ||  parseFloat(hdr_formobj.height.value) == 0) && (	hdr_formobj.weight.value==""  || parseFloat(hdr_formobj.weight.value) == 0)) {	
			hdr_formobj.height.disabled=false;//code added for IN042345
			hdr_formobj.weight.disabled=false;//code added for IN042345			
			hdr_formobj.height.select();
			alert(getMessage("PAT_HEIGHT_WEIGHT_BLANK","PH"));
			hdr_formobj.height.focus();
			return false;
		} 
		if(hdr_formobj.weight.value=="" || parseFloat(hdr_formobj.weight.value) == 0){
			hdr_formobj.weight.disabled=false;
			hdr_formobj.weight.focus();
			alert(getMessage("PAT_WEIGHT_BLANK","PH"));
			return false;
		}
		else if(hdr_formobj.height.value=="" || parseFloat(hdr_formobj.height.value) == 0){
			hdr_formobj.height.disabled=false;
			hdr_formobj.height.focus();
			alert(getMessage("PAT_HEIGHT_BLANK","PH"));
			return false;
		}
	}
	else{
		if(wt_mand_yn == 'Y' && (hdr_formobj.weight.value=="" || parseFloat(hdr_formobj.weight.value) == 0)){
			hdr_formobj.weight.disabled=false;
			hdr_formobj.weight.focus();
			alert(getMessage("PAT_WEIGHT_BLANK","PH"));
			return false;
		}
		else if(ht_mand_yn == 'Y' && (hdr_formobj.height.value=="" || parseFloat(hdr_formobj.height.value) == 0)){
			hdr_formobj.height.disabled=false;
			hdr_formobj.height.focus();
			alert(getMessage("PAT_HEIGHT_BLANK","PH"));
			return false;
		}
	}
	if( called_from=='defaultDrug'){ //if block added for Bru-HIMS-CRF-079
		return;
	}
	if(srl_no!=null && srl_no!='null') {
		defaultDrug(drug_code,'modify',srl_no);
	}
}

function defaultDrug(drug_code,mode,srl_no){
	var recomm_yn_flag = eval("document.prescription_form.recomm_yn_flag_"+srl_no).value; //added for Bru-HIMS-CRF-079 IN[029945] -start
	var validHgtWgt = recommendDosage(drug_code,mode,srl_no, 'defaultDrug');
	if(recomm_yn_flag=='true' && validHgtWgt==false){
		return false;
	} //added for Bru-HIMS-CRF-079 IN[029945] -end

	var hdr_formobj		= parent.parent.parent.parent.f_detail.f_header.document.dir_disp_header_form;
	var start_dt		= eval("document.prescription_form.dt"+srl_no+".value");
	
	if(start_dt !=undefined && start_dt!=null && start_dt !="")
		start_date		= start_dt;
	else
		start_date		= hdr_formobj.sys_date.value;

	var priority		= hdr_formobj.priority.value;
	var patient_id		= hdr_formobj.patient_id.value;
	var encounter_id	= hdr_formobj.encounter_id.value;
	var patient_class	= hdr_formobj.patient_class.value;
	var	bsa				= hdr_formobj.bsa.value;
	var weight          = hdr_formobj.weight.value; // Added for ML-MMOH-CRF-0978
	var drug_db_interface_yn		=  hdr_formobj.drug_db_interface_yn.value;
	var drug_db_dosecheck_yn		=  hdr_formobj.drug_db_dosecheck_yn.value;
	var drug_db_duptherapy_yn		=  hdr_formobj.drug_db_duptherapy_yn.value;
	var drug_db_interact_check_yn	=  hdr_formobj.drug_db_interact_check_yn.value;
	var drug_db_contraind_check_yn  =  hdr_formobj.drug_db_contraind_check_yn.value;
	var drug_db_allergy_check_yn	=  hdr_formobj.drug_db_allergy_check_yn.value;
	var drug_db_prod_id				=  hdr_formobj.Drug_db_prod_id.value;

	
	//parent.parent.parent.parent.f_detail.DispensingFrames.rows = "8%,*,35%"; //"8%,40%,*";
	parent.parent.parent.parent.window[2].document.getElementById('f_header').style.height="8vh";
	parent.parent.parent.parent.window[2].document.getElementById('f_ord_detail').style.height="60vh";
	parent.parent.parent.parent.window[2].document.getElementById('f_disp_detail').style.height="25vh";
	
	//parent.parent.parent.parent.f_detail.f_ord_detail.f_drug_detail.OrderDrugDetailsFrames.rows = "*,0%,10%";
	parent.parent.window[1].document.getElementById('f_drug').style.height="75vh";
	parent.parent.window[1].document.getElementById('f_allocate').style.height="0vh";
	parent.parent.window[1].document.getElementById('f_button_1').style.height="10vh";
	
	//parent.parent.parent.parent.f_detail.f_ord_detail.f_drug_list.DrugListframes.rows = "*,20%";
	parent.parent.window[0].document.getElementById('f_list').style.height="70vh";
	parent.parent.window[0].document.getElementById('f_button_2').style.height="18vh";
	
	//parent.parent.parent.parent.f_detail.f_disp_detail.dispframes.rows = "*,14%";
	parent.parent.parent.window[2].document.getElementById('f_allocated_detail').style.height="70vh";
	parent.parent.parent.window[2].document.getElementById('f_button3').style.height="19vh";
	
	parent.parent.parent.parent.f_detail.f_ord_detail.f_drug_detail.f_drug.location.href="../../ePH/jsp/DirectDispDrugDetails.jsp?srl_no="+srl_no+"&drug_code="+drug_code+"&priority="+priority+"&start_date="+start_date+"&mode="+mode+"&patient_id="+patient_id+"&encounter_id="+encounter_id+"&patient_class="+patient_class+"&bsa="+bsa+"&drug_db_interface_yn="+drug_db_interface_yn+"&drug_db_dosecheck_yn="+drug_db_dosecheck_yn+"&drug_db_duptherapy_yn="+drug_db_duptherapy_yn+"&drug_db_interact_check_yn="+drug_db_interact_check_yn+"&drug_db_contraind_check_yn="+drug_db_contraind_check_yn+"&drug_db_allergy_check_yn="+drug_db_allergy_check_yn+"&drug_db_prod_id="+drug_db_prod_id+"&weight="+weight; // weight Added for ML-MMOH-CRF-0978
	parent.parent.parent.parent.f_detail.f_ord_detail.f_drug_detail.f_button_1.location.href="../../ePH/jsp/DirectDispButtons_1.jsp?&mode="+mode+"&display1_yn=Y"+"&display2_yn=N";
	
}

function callActiveOrders(patient_id,encounter_id,generic_id)	{
	if(generic_id==undefined)
		generic_id="";
	
	var dialogHeight= "400px" ;
	var dialogWidth	= "700px" ;
	var dialogTop = "250" ;
	var center = "1" ;
	var status="no";
	var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop;
	var arguments	= "" ;
	retVal = parent.parent.parent.window[2].showModalDialog("../../ePH/jsp/PrescriptionActiveOrderDetailsFrame.jsp?patient_id="+patient_id+"&encounter_id="+encounter_id+"&generic_id="+generic_id+"&called_frm=PH",arguments,features);

}

function showDrugProfile(patient_id,called_frm,encounter_id){ // encounter_id added for AAKH-CRF-0088.2
	var pat_class	=	document.prescription_detail_form.patient_class.value;

	var dialogHeight	= "700px" ;
	var dialogWidth		= "1200px" ;
	var dialogTop		= "100" ;
	var center			= "1" ;
	var status			= "no";
	var features		= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop;
	var arguments		= "" ;
	retVal				= parent.parent.parent.parent.window[2].showModalDialog( "../../ePH/jsp/QueryPatientDrugProfileFrames.jsp?patient_id="+escape(patient_id)+"&pat_class="+pat_class+"&encounter_id="+encounter_id+"&called_frm=Prescription", arguments, features ); // encounter_id added for AAKH-CRF-0088.2
}
async function callPreviewOrders()	{
	var hdr_formobj		        = parent.parent.parent.f_detail.f_header.document.dir_disp_header_form;

	var patient_id				= hdr_formobj.patient_id.value;
	var encounter_id			= hdr_formobj.encounter_id.value;
	var date					= hdr_formobj.sys_date.value;
	var locn_code				= hdr_formobj.location_code.value;
	var pract_name				= hdr_formobj.pract_name.value;
	var actual_patient_class	= hdr_formobj.patient_class.value;
	var dialogHeight			= "600px" ;
	var dialogWidth				= "1200px" ;
	var dialogTop				= "169" ;
	var center					= "1" ;
	var status					= "no";
	var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop;
	var arguments				= "" ;
	
	//added top.window.showModalDialog by Vedesh A D for EDGE Conversion
	retVal = await top.window.showModalDialog("../../ePH/jsp/DirectDispPreviewOrderFrames.jsp?patient_id="+patient_id+"&encounter_id="+encounter_id+"&date="+date+"&locn_code="+locn_code+"&pract_name="+pract_name+"&actual_patient_class="+actual_patient_class,arguments,features);

}
async function showOverRideRemarks(frmObj) {
	
	if(checkReasonDuplicate(frmObj)) {
		generic_id		=	frmObj.generic_id.value;
		generic_name	=	encodeURIComponent(frmObj.generic_name.value);
		patient_id		=	frmObj.patient_id.value;
		encounter_id	=	frmObj.encounter_id.value;
		drug_desc		=	encodeURIComponent(frmObj.drug_name.value);
		daily_dose		=	frmObj.daily_dose.value;
		unit_dose		=	frmObj.unit_dose.value;
		mono_graph		=	encodeURIComponent(frmObj.monograph.value);
		limit_ind		=	frmObj.limit_ind.value;
		allergy_yn		=	frmObj.allergy_yn.value;
		current_rx		=	frmObj.current_rx.value;
		drug_code		=	frmObj.drug_code.value;
		srl_no			=	frmObj.srl_no.value;
		calling_mode	=	frmObj.calling_mode.value;
		//if(calling_mode=="taper")
			//srl_no=parseInt(srl_no)+1;
		min_unit_dose	=	frmObj.min_unit_dose.value;
		min_daily_dose	=	frmObj.min_daily_dose.value;
		dosage_unit		=	frmObj.dosage_unit.value;
		dosage_std		=	frmObj.dosage_std.value;// added for ML-MMOH-SCF-0864
		interaction_exists	=	frmObj.interaction_exists.value;
		//Added for IN:070451 start
		var max_daily_ceeling_dose	= frmObj.max_daily_ceeling_dose.value;
		var min_daily_ceeling_dose	= frmObj.min_daily_ceeling_dose.value;
		var max_unit_ceeling_dose	= frmObj.max_unit_ceeling_dose.value;
		var min_unit_ceeling_dose	= frmObj.min_unit_ceeling_dose.value;
		var dose_unit_desc	= frmObj.dose_unit_desc.value;
		var dose_unit_desc1	= frmObj.dose_unit_desc1.value;
		//var dosage_std	= frmObj.dosage_std.value;
		//Added for IN:070451 end
		//Added for IN:072715 start
		var allergy_remarks_code=frmObj.allergy_remarks_code.value;
		var dose_remarks_code=frmObj.dose_remarks_code.value;
		var currentrx_remarks_code=frmObj.currentrx_remarks_code.value;
		var interaction_remarks_code=frmObj.interaction_remarks_code.value;
		var food_interaction_remarks_code=frmObj.food_interaction_remarks_code.value;
		var lab_interaction_remarks_code=frmObj.lab_interaction_remarks_code.value;
		//Added for IN:072715 end
		var disease_interaction_remarks_code=frmObj.disease_interaction_remarks_code.value;//Added for MMS-DM-CRF-0229

		var dialogHeight = 5;

		if(current_rx=="Y" )
			dialogHeight +=10; 
		if(limit_ind=="y" )
			dialogHeight +=10; 
		if(allergy_yn=="Y")
			dialogHeight +=10; 
		if ( interaction_exists=="Y")
			dialogHeight +=10; 

			var dialogWidth	= "650px" ;
			var dialogTop	= "10" ;
			var dialogLeft	= "100";
			var center		= "0" ;
			var status		= "no";
			var features	= "dialogHeight: 220px" + "; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop+"; dialogLeft :"+dialogLeft;
			var arguments	= "" ;
			////dosage_std added for ML-MMOH-SCF-0864
			retVal =  await window.showModalDialog("../../ePH/jsp/DirectDispOverrideReason.jsp?gen_id="+generic_id+"&gen_name="+generic_name+"&pat_id="+patient_id+"&enc_id="+encounter_id+"&drug_desc="+drug_desc+"&mono_graph="+escape(mono_graph)+"&daily_dose="+daily_dose+"&unit_dose="+unit_dose+"&allergy_yn="+allergy_yn+"&current_rx="+current_rx+"&limit_ind="+limit_ind+"&drug_code="+drug_code+"&srl_no="+srl_no+"&min_unit_dose="+min_unit_dose+"&min_daily_dose="+min_daily_dose+"&dosage_unit="+dosage_unit+"&dosage_std="+dosage_std+"&interaction_exists="+interaction_exists+"&max_daily_ceeling_dose="+max_daily_ceeling_dose+"&min_daily_ceeling_dose="+min_daily_ceeling_dose+"&max_unit_ceeling_dose="+max_unit_ceeling_dose+"&min_unit_ceeling_dose="+min_unit_ceeling_dose+"&dose_unit_desc="+dose_unit_desc+"&dose_unit_desc1="+dose_unit_desc1+"&allergy_remarks_code="+allergy_remarks_code+"&dose_remarks_code="+dose_remarks_code+"&currentrx_remarks_code="+currentrx_remarks_code+"&interaction_remarks_code="+interaction_remarks_code+"&food_interaction_remarks_code="+food_interaction_remarks_code+"&lab_interaction_remarks_code="+lab_interaction_remarks_code+"&disease_interaction_remarks_code="+disease_interaction_remarks_code,arguments,features);//Modified for IN:070451
			if(retVal=='OK'){
				frmObj.override_chk.checked=true;
				frmObj.override_chk.disabled=true;
				frmObj.override_chk.value='Y';
			}
			else{
				frmObj.override_chk.checked=false;
				frmObj.override_chk.disabled=false;
				frmObj.override_chk.value='N';
			}
	}
}

function validate(frmObj) {

	var fields	= new Array();
	var names	= new Array();
	var   i		= 0;

	if(frmObj.allergy!=null) {
		fields[i]	= frmObj.allergy;
		names[i]	= getLabel("ePH.AllergicOverrideReason.label","PH");
		i++;
	}

	if(frmObj.exceed_dose!=null) {
		fields[i]	= frmObj.exceed_dose;  
		names[i]	= getLabel("ePH.ExceedDosageOverrideReason.label","PH");
		i++;
	}

	if(frmObj.dup_drug!=null) {
		fields[i]	= frmObj.dup_drug;  
		names[i]	= getLabel("ePH.DuplicateDrugOverrideReason.label","PH");
		i++;
	}
// Modified for IN:072715
	if(frmObj.interaction_remarks!=null && frmObj.interaction_remarks!=undefined && frmObj.interaction_remarks!=null && frmObj.interaction_remarks!=undefined && frmObj.drug_drug_display.value=="inline") { // added for FD-RUT-CRF-0066.1 [IN036975]
		fields[i]	= frmObj.interaction_remarks;  
		names[i]	= getLabel("ePH.Drug-DrugInteractionOverrideReason.label","PH");
		i++;
	}
	// Modified for IN:072715
	// added for MMS-KH-CRF-0029 - start
	if(frmObj.lab_interaction_remarks!=null && frmObj.lab_interaction_remarks!=undefined && frmObj.drug_lab_display!=null && frmObj.drug_lab_display!=undefined && frmObj.drug_lab_display.value=="inline") { 
		fields[i]	= frmObj.lab_interaction_remarks;  
		names[i]	= getLabel("ePH.Drug-LabInteractionOverrideReason.label","PH");
		i++;
	}

	if(frmObj.food_interaction_remarks!=null && frmObj.food_interaction_remarks!=undefined && frmObj.drug_food_display!=null && frmObj.drug_food_display!=undefined && frmObj.drug_food_display.value=="inline") { 
		fields[i]	= frmObj.food_interaction_remarks;  
		names[i]	= getLabel("ePH.Drug-FoodInteractionOverrideReason.label","PH");
		i++;
	}
// added for MMS-KH-CRF-0029 - end
    if(frmObj.disease_interaction_remarks!=null && frmObj.disease_interaction_remarks!=undefined && frmObj.drug_disease_display!=null && frmObj.drug_disease_display!=undefined && frmObj.drug_disease_display.value=="inline") {//Added for MMS-DM-CRF-0229
			fields[i]	= frmObj.disease_interaction_remarks;
			names[i]	=getLabel("ePH.Drug-DiseaseOverrideReason.label", "PH");
			i++;
		}
	if(checkFlds(fields,names)){
		if(checkMaxSize(fields,names))
			storeOverRideReason(frmObj);
	}
}

function checkMaxSize(fields) {
	var errors = "" ;
	for( var i=0; i<fields.length; i++ ) {
		if(fields[i].value.length > 255)
			errors = errors + "APP-000001 " + names[i] + getLabel("ePH.cannotexceed255characters.label","PH") + "\n" ;
	}
	if ( errors.length != 0 ) {
		alert(errors) ;
		return false ;
	}
	return true ;
}
function storeOverRideReason(frmObj) {

	current_rx	=	frmObj.current_rx.value;
	limit_ind	=	frmObj.limit_ind.value;
	allergy_yn	=	frmObj.allergy_yn.value;
	drug_code	=	frmObj.drug_code.value;
	srl_no		=	frmObj.srl_no.value;
	bean_id		=	frmObj.bean_id.value;
	bean_name	=	frmObj.bean_name.value;
	interaction_exists	=	frmObj.interaction_exists.value; // added for FD-RUT-CRF-0066.1 [IN036975]
	allergy		=	"";
	exceed_dose	=	"";
	dup_drug	=	"";
	interaction_remarks ="";
	lab_interaction_remarks = ""; //MMS-KH-CRF-0029[IN070606]
	food_interaction_remarks = "";//MMS-KH-CRF-0029[IN070606]
	//Added for IN:072715  start
	dose_remarks_code = "";
	allergy_remarks_code = "";
	dup_drug_remarks_code = "";
	interaction_remarks_code = "";
	lab_interaction_remarks_code = "";
	food_interaction_remarks_code = "";
	//Added for IN:072715  end
	disease_interaction_remarks = "";//Added for MMS-DM-CRF-0229
	disease_interaction_remarks_code = "";//Added for MMS-DM-CRF-0229
	// Modified for IN:072715 start
	if(frmObj.allergy!=null){
		allergy		=	encodeURIComponent(frmObj.allergy.value);
		if(frmObj.allergy_remarks_code!=null && frmObj.allergy_remarks_code!=undefined)
			allergy_remarks_code=encodeURIComponent(frmObj.allergy_remarks_code.value);
	}
	if(frmObj.exceed_dose!=null){
		exceed_dose	=	encodeURIComponent(frmObj.exceed_dose.value);
		if(frmObj.dose_remarks_code!=null && frmObj.dose_remarks_code!=undefined)
			dose_remarks_code=encodeURIComponent(frmObj.dose_remarks_code.value);
	}
	if(frmObj.dup_drug!=null){
		dup_drug	=	encodeURIComponent(frmObj.dup_drug.value);
		if(frmObj.dup_drug_remarks_code!=null && frmObj.dup_drug_remarks_code!=undefined)
			dup_drug_remarks_code=encodeURIComponent(frmObj.dup_drug_remarks_code.value);
	}
	if(interaction_exists == 'Y'){
		interaction_remarks	=	encodeURIComponent( frmObj.interaction_remarks.value,"UTF-8");//escape(frmObj.interaction_remarks.value);
		if(frmObj.interaction_remarks_code!=null && frmObj.interaction_remarks_code!=undefined)
			interaction_remarks_code=encodeURIComponent(frmObj.interaction_remarks_code.value);
	} // added for FD-RUT-CRF-0066.1 [IN036975]
	//MMS-KH-CRF-0029[IN070606] - start
	if(frmObj.food_interaction_remarks!=null){
		food_interaction_remarks	=	encodeURIComponent(frmObj.food_interaction_remarks.value);
		if(frmObj.food_interaction_remarks_code!=null && frmObj.food_interaction_remarks_code!=undefined)
			food_interaction_remarks_code=encodeURIComponent(frmObj.food_interaction_remarks_code.value);
	}
	if(frmObj.lab_interaction_remarks!=null){
		lab_interaction_remarks	=	encodeURIComponent(frmObj.lab_interaction_remarks.value);
		if(frmObj.lab_interaction_remarks_code!=null && frmObj.lab_interaction_remarks_code!=undefined)
			lab_interaction_remarks_code=encodeURIComponent(frmObj.lab_interaction_remarks_code.value);
	}
	//MMS-KH-CRF-0029[IN070606] - end
	// Modified for IN:072715 end
   if(frmObj.disease_interaction_remarks!=null){//Added for MMS-DM-CRF-0229
		disease_interaction_remarks	=	encodeURIComponent(frmObj.disease_interaction_remarks.value);
		if(frmObj.disease_interaction_remarks_code!=null && frmObj.disease_interaction_remarks_code!=undefined)
			disease_interaction_remarks_code=encodeURIComponent(frmObj.disease_interaction_remarks_code.value);
	}

	var xmlStr ="<root><SEARCH ";
	xmlStr+= "current_rx  =\"" + current_rx + "\" " ;
	xmlStr+= "limit_ind =\"" + limit_ind + "\" " ;
	xmlStr+= "allergy_yn  =\"" + allergy_yn + "\" " ;
	xmlStr+= "allergy =\"" + allergy + "\" " ;
	xmlStr+= "exceed_dose =\"" + exceed_dose + "\" " ;
	xmlStr+= "dup_drug =\"" + dup_drug + "\" " ;
	xmlStr+= "drug_code =\"" + drug_code + "\" " ;
	xmlStr+= "srl_no =\"" + srl_no + "\" " ;
	xmlStr+= "bean_id =\"" + bean_id + "\" " ;
	xmlStr+= "bean_name=\"" + bean_name + "\" " ;
	xmlStr+= "interaction_exists=\"" + interaction_exists + "\" " ; // added for FD-RUT-CRF-0066.1 [IN036975]
	xmlStr+= "interaction_remarks=\"" + interaction_remarks + "\" " ; // added for FD-RUT-CRF-0066.1 [IN036975]
	xmlStr+= "food_interaction_remarks =\"" + food_interaction_remarks + "\" " ; //MMS-KH-CRF-0029[IN070606]
	xmlStr+= "lab_interaction_remarks =\"" + lab_interaction_remarks + "\" " ;//MMS-KH-CRF-0029[IN070606]
	//Added for IN:072715 start
	xmlStr+= "dose_remarks_code =\"" + dose_remarks_code + "\" " ;
	xmlStr+= "allergy_remarks_code =\"" + allergy_remarks_code + "\" " ;
	xmlStr+= "dup_drug_remarks_code =\"" + dup_drug_remarks_code + "\" " ;
	xmlStr+= "interaction_remarks_code =\"" + interaction_remarks_code + "\" " ;
	xmlStr+= "lab_interaction_remarks_code =\"" + lab_interaction_remarks_code + "\" " ;
	xmlStr+= "food_interaction_remarks_code =\"" + food_interaction_remarks_code + "\" " ;
	//Added for IN:072715 end
	//alert("disease_interaction_remarks=="+disease_interaction_remarks+"disease_interaction_remarks_code=="+disease_interaction_remarks_code);
	xmlStr+= "disease_interaction_remarks =\"" + disease_interaction_remarks + "\" " ;//Added for MMS-DM-CRF-0229
	xmlStr+= "disease_interaction_remarks_code =\"" + disease_interaction_remarks_code + "\" " ;//Added for MMS-DM-CRF-0229
	xmlStr +=" /></root>";
	fieldValidation(xmlStr,"override_reason");
	/*window.returnValue = ;//allergy + ":::" + exceed_dose + ":::" + dup_drug + ":::"+ interaction_remarks + ":::";
	parent.window.close();*/
	parent.document.getElementById('dialog-body').contentWindow.returnValue = 'OK'; 
	parent.document.getElementById('dialog_tag').close();  
}
async function showAllergyDetails(generic_id,patient_id,encounter_id,generic_name,drug_name){
	var retVal;
	var dialogTop		= "310";
 	var dialogHeight	= "120px" ;
 	var dialogWidth		= "250px" ;
	var dialogLeft		= "240" ;
 	var features		= 'Width:' + dialogWidth +'; dialogHeight:' + dialogHeight + '; dialogWidth:' + dialogWidth +'; dialogLeft:' + dialogLeft +';  dialogTop:'+dialogTop +'; scroll=auto; status=no';
 	var arguments		= "";
 	retVal 				= await window.showModalDialog("../../ePH/jsp/PrescriptionAllergyDetailsFrames.jsp?generic_name="+generic_name+"&encounter_id="+encounter_id+"&generic_id="+generic_id+"&patient_id="+patient_id+"&drug_name="+drug_name,arguments,features);
}
async function showMonoGraph(drug_desc,mono_graph,daily_dose,unit_dose,min_daily_dose,min_unit_dose,dosage_unit,dosage_std,dose_unit_desc,max_daily_ceeling_dose,min_daily_ceeling_dose,max_unit_ceeling_dose,min_unit_ceeling_dose,dose_unit_desc1){//dosage_std,dose_unit_desc added for ML-MMOH-SCF-0864 and dosage_std for  ML-MMOH-CRF-0978,Modified for IN:070451
	var retVal;
	var dialogTop		= "310";
 	var dialogHeight	= "17" ;
 	var dialogWidth		= "36" ;
	var dialogLeft		= "180" ;
	
 	var features		= 'Width:' + dialogWidth +'; dialogHeight:' + dialogHeight + '; dialogWidth:' + dialogWidth +'; dialogLeft:' + dialogLeft +';  dialogTop:'+dialogTop +'; scroll=no; status=no';
 	var arguments		= "";
 	retVal 				=    await window.showModalDialog("../../ePH/jsp/PrescriptionDosageLimitMonoGraph.jsp?drug_desc="+encodeURIComponent(drug_desc,"UTF-8")+"&mono_graph="+mono_graph+"&daily_dose="+daily_dose+"&unit_dose="+unit_dose+"&min_daily_dose="+min_daily_dose+"&min_unit_dose="+min_unit_dose+"&dosage_unit="+dosage_unit+"&dosage_std="+dosage_std+"&dose_unit_desc="+dose_unit_desc+"&max_daily_ceeling_dose="+max_daily_ceeling_dose+"&min_daily_ceeling_dose="+min_daily_ceeling_dose+"&max_unit_ceeling_dose="+max_unit_ceeling_dose+"&min_unit_ceeling_dose="+min_unit_ceeling_dose+"&dose_unit_desc1="+dose_unit_desc1,arguments,features); //dosage_std,dose_unit_desc added for ML-MMOH-SCF-0864,Modified for IN:070451
}
function callCurrentMedication(patient_id,encounter_id,generic_id) {
callActiveOrders(patient_id,encounter_id,generic_id);
}

function checkReasonDuplicate(frmObj){
	var frequency;
	var current_rx		=	frmObj.current_rx.value;
	var allow_duplicate	=	frmObj.allow_duplicate.value;
	var patient_class	=	frmObj.patient_class.value;
	var take_home		=	frmObj.take_home.value;
	var sliding_scale	=	false;
	if(frmObj.frequency==null) {
		frequency		=	parent.f_sliding_scale_admin_dtls.prescription_detail_form.frequency.value;
		sliding_scale	=	true;
	} else {
		frequency		=	frmObj.frequency.value;
	}
    var freq_nature		=	frmObj.freq_nature.value;
	var result			=	true;
	if(current_rx=="Y" && allow_duplicate=="N" && (patient_class=="IP" || parseInt(take_home)>0) && freq_nature!="O" ) {
		result		=	false;
	}
	
	if(sliding_scale) {
		result		=	true;
	}

	return result;

}

function changeschedule(){	   
	    deleteScheduleLink();
		DisableSchedule1();
		storeSchedule();
		checkSchedule(document.prescription_detail_form.qty_value);
		changedoseoverridevalue();		
 }

 function deleteScheduleLink(){
	var drug_frmobj=parent.parent.parent.parent.f_detail.f_ord_detail.f_drug_detail.f_drug.prescription_detail_form;
	drug_frmobj.frequency.disabled	=	false;
	drug_frmobj.split_dose_yn.disabled	=	true;
	drug_frmobj.sch_over_yn.value	=	"Y";
	drug_frmobj.admin_time.value	=	"";
	drug_frmobj.admin_qty.value		=	"";
	var dosage_type=drug_frmobj.dosage_type.value;
	validateQtyDesc(dosage_type,"R");			
}
function validateQtyDesc(mode,status){
	var drug_frmobj=parent.parent.parent.parent.f_detail.f_ord_detail.f_drug_detail.f_drug.prescription_detail_form;
	drug_frmobj.dosage_type.value = mode;

	if(drug_frmobj.split_dose_yn.disabled==false){
		//DisableSchedule();
	}

	if(mode=="S"){
		drug_frmobj.dosage_label.innerText= getLabel("Common.Strength.label","Common");	 

		if(status!="R") {
			drug_frmobj.qty_desc.value  = drug_frmobj.strength_uom.value;
			drug_frmobj.qty_value.value = drug_frmobj.strength_value.value;
		}
	}
	else if(mode=="Q"){
		var rx_qty_by_pres_base_uom_yn	=	 parent.parent.parent.parent.f_detail.f_header.document.dir_disp_header_form.rx_qty_by_pres_base_uom_yn.value;		
		if(rx_qty_by_pres_base_uom_yn=="Y")
			drug_frmobj.qty_desc.disabled	=	true;
		else
			drug_frmobj.qty_desc.disabled=false;
		document.getElementById('dosage_label').innerText=getLabel("ePH.Dose.label","PH");  
		//drug_frmobj.qty_desc.disabled   = false;
		if(status!="R") {
			drug_frmobj.qty_value.value=drug_frmobj.tab_qty_value.value;
			drug_frmobj.qty_desc.value=drug_frmobj.dflt_qty_uom.value;
		}
	} 
	else if(mode=="A" && drug_frmobj.patient_class.value=="IP" &&     drug_frmobj.freq_nature.value=="P") {
		drug_frmobj.dosage_label.innerText=getLabel("Common.Quantity.label","Common"); 
	}
	if(drug_frmobj.sliding_scale_yn.value == 'Y') {
		drug_frmobj.dosage_label.innerText="";
	}
	if(drug_frmobj.qty_desc.value== ''){
		if(drug_frmobj.qty_desc.options.length > 0){
			drug_frmobj.qty_desc.selectedIndex=0;
		}
	}
}
async function DisplaySchedule(called_from) {
    var drug_frmobj=parent.parent.parent.parent.f_detail.f_ord_detail.f_drug_detail.f_drug.prescription_detail_form;
	var patient_id		= drug_frmobj.patient_id.value;
	var encounter_id	= drug_frmobj.encounter_id.value;
	var bean_id			= "DirectDispensingBean";	
	var bean_name		= "ePH.DirectDispensingBean";
	var drug_code		= drug_frmobj.drug_code.value;
	var srl_no			= drug_frmobj.srl_no.value;
 	var freq_code		= drug_frmobj.frequency.value;
	var row_value       = drug_frmobj.rowVal.value;
    var facility_id		= parent.parent.parent.parent.f_detail.f_header.document.dir_disp_header_form.facility_id.value;	
 	var	max_qty		    = drug_frmobj.daily_dose.value;
	var	unit_qty		= drug_frmobj.unit_dose.value;
	var split_dose_yn   = drug_frmobj.split_dose_yn.value;
	var split_qty       = drug_frmobj.qty_value.value;
	var qty_reqd_yn     = drug_frmobj.qty_reqd_yn.value;
	var calling_mode	= drug_frmobj.calling_mode.value;

	var chk_max			= "N";
	var chk_unit		= "N";
	
	if(max_qty!='0'){
		chk_max = "Y";
	}

	if(unit_qty!='0'){
		chk_unit = "Y";
	}
	var uom_desc		= drug_frmobj.qty_desc.value;
	uom_desc=encodeURIComponent(uom_desc,"UTF-8");
	var start_time_day_param = document.prescription_detail_form.start_date.value;
	var pr_duration			 = document.prescription_detail_form.durn_value.value;
	var pr_duration_type	 = document.prescription_detail_form.durn_desc.value;
	var durationType_P		 = document.prescription_detail_form.repeat_durn_type.value; 

	if(uom_desc!=""){
		var retVal;
		var dialogTop		= "260";
		var dialogHeight	= "24" ;
		var dialogWidth		= "35" ;
		var features		= 'Width:' + dialogWidth +'; dialogHeight:' + dialogHeight + '; dialogWidth:' + dialogWidth +'; dialogTop:'+dialogTop +'; scroll=no; status=no';
		var arguments		= "";
		if(calling_mode=="taper")
			code	=	drug_code+(parseInt(srl_no)+1);
		else
			code	=	drug_code+srl_no;

		retVal 				= await window.showModalDialog("../../eOR/jsp/ScheduleFrequency.jsp?mode=1&bean_id="+bean_id+"&uom_desc="+uom_desc+"&bean_name="+bean_name+"&chk_max="+chk_max+"&chk_unit="+chk_unit+"&max_qty="+max_qty+"&split_dose_yn="+split_dose_yn+"&split_qty="+split_qty+"&qty_reqd_yn="+qty_reqd_yn+"&unit_qty="+unit_qty+"&code="+code+"&row_value="+row_value+"&facility_id="+facility_id+"&freq_code="+freq_code+"&module_id=PH&called_from="+called_from+"&start_time_day_param="+start_time_day_param+"&pr_duration="+pr_duration+"&pr_duration_type="+pr_duration_type+"&org_drug_code="+drug_code+"&interval_durn_type="+durationType_P+"&patient_id="+patient_id+"&encounter_id="+encounter_id,arguments,features);
		if(retVal!=null){
			oldrepeatvalue=drug_frmobj.repeat_value.value;			
			drug_frmobj.sch_over_yn.value="Y";
			drug_frmobj.split_dose.disabled=false;
			//===
			var split_vals = retVal[1].split('~~');	
			var len = document.prescription_detail_form.frequency.options.length;			
			for(img=0;img<len;img++){
				if(document.prescription_detail_form.frequency.options[img].value==split_vals[0]){
					document.prescription_detail_form.frequency.selectedIndex= img	;
					break;
				}
			}
			freqChange(document.prescription_detail_form.frequency,"M");
			var len1 = document.prescription_detail_form.durn_desc.options.length;
			for(img1=0;img1<len1;img1++){
				if(document.prescription_detail_form.durn_desc.options[img1].value==retVal[3]){
					document.prescription_detail_form.durn_desc.selectedIndex= img1	;
					break;
				}
			}
			document.prescription_detail_form.durn_value.value=retVal[2];
			durationConversn(document.prescription_detail_form.durn_desc,'form');
			ExternalDosageCheck();
			//===
			var drug_code = drug_frmobj.drug_code.value;
			var fldString=" drug_code=\""+ code + "\" ";
			var formobj=drug_frmobj;
			var xmlStr=formXMLString(formobj,fldString);
			fieldValidation(xmlStr,"makeScheduleLink");
			loadallocatedetail('allocate','ONCLICK');   //Added for the incident number 21510 on 20/May/2010
		}
		else{
			drug_frmobj.sch_over_yn.value="Y";
			drug_frmobj.qty_value.disabled=false;
			drug_frmobj.qty_value.focus();
		}
	}
	else{
		alert(getMessage("PH_QTY_DESC","PH"));
		drug_frmobj.split_dose.disabled=true;
		drug_frmobj.sch_over_yn.value="Y";
		drug_frmobj.qty_desc.focus();
		return false;
	}
 }

 function makeScheduleLink(admin_time,admin_qty,total_qty,freq_size,split_chk,ad_qty){
	 var drug_frmobj=parent.parent.parent.parent.f_detail.f_ord_detail.f_drug_detail.f_drug.prescription_detail_form;
	var legend	=	"";
	var default_recm_dose_yn = drug_frmobj.default_recm_dose_yn.value; // Added for ML-MMOH-CRF-0978
	if(split_chk=="true") {
		legend	=		getLabel("ePH.SplitDose.label","PH") ;  
		drug_frmobj.split_dose_yn_val.value="Y";
	}
	else { 
		legend	=	getLabel("ePH.ScheduledDose.label","PH") ;  
		drug_frmobj.split_dose_yn_val.value = "N";
	}
	if(drug_frmobj.sliding_scale_yn!=null) {
		legend	=	 getLabel("ePH.Sch.label","PH") ;
	} 
	drug_frmobj.split_dose_yn.disabled=false;
	var title="<table border=1 cellpadding=0 cellspacing=0 align=center>"+admin_time+admin_qty+"</table>";
	if(!(drug_frmobj.recom_value.value!=undefined && drug_frmobj.recom_value.value!="" && default_recm_dose_yn=="true")) // if condition Added for ML-MMOH-CRF-0978
	drug_frmobj.qty_value.value = total_qty;
	document.getElementById("dosage_label").innerHTML="<label nowrap style='color:red;font-size:10' onmouseover='displayToolTipDataChange(\"" + title + "\");' onmouseout='disasbleToolTipDataChange();'>"+legend+"</label>";
	drug_frmobj.admin_time.value = admin_time;
	drug_frmobj.admin_qty.value  = admin_qty;
	validateDosageLimit();
	//loadallocatedetail('allocate','ONCLICK');
}

function hideScheduleLink(){
	var drug_frmobj=parent.parent.parent.parent.f_detail.f_ord_detail.f_drug_detail.f_drug.document.prescription_detail_form;
	drug_frmobj.frequency.disabled = false;
	if(drug_frmobj.qty_reqd_yn.value=='Y'){
		drug_frmobj.qty_value.disabled=false;
	}
	drug_frmobj.qty_desc.disabled = false;
	validateDosageLimit();
}

function populateQtyDesc(form_code,pres_base_uom){
	var drug_frmobj=parent.parent.parent.parent.f_detail.f_ord_detail.f_drug_detail.f_drug.document.prescription_detail_form;
	var hdr_formobj		= parent.parent.parent.parent.f_detail.f_header.document.dir_disp_header_form;	
	var bean_id	 = hdr_formobj.bean_id.value ;
	var bean_name = hdr_formobj.bean_name.value ;
	var drug_code = drug_frmobj.form_code.value;
	var pres_base_uom_desc=drug_frmobj.pres_base_uom_desc.value;
	var rx_qty_by_pres_base_uom_yn = hdr_formobj.rx_qty_by_pres_base_uom_yn.value;
	xmlStr	 ="<root><SEARCH " ;
	xmlStr	+=" bean_id=\""+ bean_id + "\" ";
	xmlStr	+=" bean_name=\""+ bean_name + "\" ";
	xmlStr	+=" form_code=\""+ form_code + "\" ";
	xmlStr	+=" rx_qty_by_pres_base_uom_yn=\""+ rx_qty_by_pres_base_uom_yn + "\" ";
	xmlStr +=" pres_base_uom=\""+ pres_base_uom + "\" ";
	xmlStr +=" pres_base_uom_desc=\""+pres_base_uom_desc + "\" "; //encodeURIComponent( pres_base_uom_desc,"UTF-8")
	xmlStr	+=" /></root>" ;
	return fieldValidation(xmlStr,"populateQtyDesc");
}
function clearQtyDescList(){
	 var drug_frmobj=parent.parent.parent.parent.f_detail.f_ord_detail.f_drug_detail.f_drug.document.prescription_detail_form;
	var len   = drug_frmobj.qty_desc.options.length;
	for(var i=0;i<len;i++) {
		drug_frmobj.qty_desc.remove("qty_desc") ;
	}
	//---<fmt:message key="ePH.Select.label" bundle="${ph_labels}"/>---
	var tp    = "  ---"+getLabel("ePH.Select.label","PH")+"---  " ;
	
	var opt   = document.createElement("OPTION") ;
	opt.text  = tp ;
	opt.value = "" ;
}
function addQtyDescList(code,desc)	{
	var element         = document.createElement('OPTION') ;
	element.value		=  code ;
	element.text		= desc ;
	parent.parent.parent.parent.f_detail.f_ord_detail.f_drug_detail.f_drug.document.prescription_detail_form.qty_desc.add(element);
}
function setdfltQtyUom(code){
	var drug_frmobj = parent.parent.parent.parent.f_detail.f_ord_detail.f_drug_detail.f_drug.document.prescription_detail_form;
	if(drug_frmobj.dosage_type.value=='Q'){
		if(drug_frmobj.dflt_qty_uom.value==""){
			drug_frmobj.dflt_qty_uom.value = code;
		}
		else{
			drug_frmobj.dflt_qty_uom.value = drug_frmobj.qty_desc_code.value;
		}
	 }
	 else{
		if(drug_frmobj.dflt_qty_uom.value==""){
			drug_frmobj.dflt_qty_uom.value = code;
		}
	 }
}
function dfltQtyDesc(){
	var drug_frmobj=parent.parent.parent.parent.f_detail.f_ord_detail.f_drug_detail.f_drug.document.prescription_detail_form;
	var dosage_type	=	drug_frmobj.dosage.value;
	if(dosage_type=="S"){
		drug_frmobj.qty_desc.value		=	drug_frmobj.strength_uom.value;
	}
	else if(dosage_type=="Q"){	
		if(drug_frmobj.dflt_qty_uom.value!="")
			drug_frmobj.qty_desc.value		=	drug_frmobj.dflt_qty_uom.value;
		if(drug_frmobj.qty_desc_code.value!="")
			drug_frmobj.qty_desc_code.value		=	drug_frmobj.qty_desc.value;
		drug_frmobj.qty_desc.disabled	=	false;
	}
	else if(dosage_type=="A"){		

		drug_frmobj.qty_desc.value		=	drug_frmobj.pres_base_uom.value;	
	}
}

function dfltDurnDesc(repeat_durn_type){
    var drug_frmobj = parent.parent.parent.parent.f_detail.f_ord_detail.f_drug_detail.f_drug.document.prescription_detail_form;
	if(repeat_durn_type=="L"){
		drug_frmobj.durn_desc.value		=	"L";
		//drug_frmobj.durn_desc.disabled	=	true;
	}
	if(repeat_durn_type=="W"){
		drug_frmobj.durn_desc.value		=	"W";
		//drug_frmobj.durn_desc.disabled	=	true;
	}
	if(repeat_durn_type=="D"){
		drug_frmobj.durn_desc.value		=	"D";
		//drug_frmobj.durn_desc.disabled	=	true;
	}
	if(repeat_durn_type=="H"){
		drug_frmobj.durn_desc.value		=	"H";
		//drug_frmobj.durn_value.value	=	"1";
		//drug_frmobj.durn_desc.disabled	=	true;
		drug_frmobj.calcualted_durn_value.value="1";
	}
	if(repeat_durn_type=="M"){
		drug_frmobj.durn_desc.value		=	"M";
		//drug_frmobj.durn_value.value	=	"1";
		//drug_frmobj.durn_desc.disabled	=	true;
	}
}

function populateEndDate(){
	var drug_frmobj				=parent.parent.parent.parent.f_detail.f_ord_detail.f_drug_detail.f_drug.document.prescription_detail_form;
	var freq_nature		= drug_frmobj.freq_nature.value;
	var start_date		= drug_frmobj.start_date.value;
	var durn_value		= drug_frmobj.durn_value.value;
	var durn_desc		= drug_frmobj.durn_desc.value;
	var repeat_durn_type= drug_frmobj.repeat_durn_type.value;
	repeat_durn_type=durn_desc;
	if( repeat_durn_type=="H" || repeat_durn_type=="M" ){
		repeat_durn_type="D";
		durn_value="1";
	}
	var hdr_formobj		= parent.parent.parent.parent.f_detail.f_header.document.dir_disp_header_form;	
	var bean_id			= hdr_formobj.bean_id.value ;
	var bean_name		= hdr_formobj.bean_name.value ;

	if(durn_value!=''){
		xmlStr	 ="<root><SEARCH " ;
		xmlStr	+=" bean_id=\""+ bean_id + "\" ";
		xmlStr	+=" bean_name=\""+ bean_name + "\" ";
		xmlStr	+=" start_date=\""+ start_date + "\" ";
		xmlStr	+=" durn_value=\""+ durn_value + "\" ";
		xmlStr	+=" repeat_durn_type=\""+ repeat_durn_type + "\" ";
		xmlStr	+=" freq_nature=\""+ freq_nature + "\" ";	
		xmlStr	+=" /></root>" ;
		return fieldValidation(xmlStr,"populateEndDate");
	}
}

function assignEndDate(end_date){
	 var drug_frmobj				= parent.parent.parent.parent.f_detail.f_ord_detail.f_drug_detail.f_drug.document.prescription_detail_form;
	 drug_frmobj.end_date.value		= end_date;
}

function getFormatId(frm){
	var hdr_formobj		= parent.parent.parent.parent.f_detail.f_header.document.dir_disp_header_form;	
	var bean_id			= hdr_formobj.bean_id.value ;
	var bean_name		= hdr_formobj.bean_name.value ;
	var called_frm		=	"";
	var drug_frmobj				=parent.parent.parent.parent.f_detail.f_ord_detail.f_drug_detail.f_drug.document.prescription_detail_form;
	var order_type		= drug_frmobj.order_type_code.value;
	var form_code		= drug_frmobj.form_code.value;
	var route_code		= drug_frmobj.route_code.value;
	var drug_code		= drug_frmobj.drug_code.value;
	var patient_id		= drug_frmobj.patient_id.value;
	var encounter_id	= drug_frmobj.encounter_id.value;
	var srl_no			= drug_frmobj.srl_no.value;
	var calling_mode	= drug_frmobj.calling_mode.value;

	if(calling_mode=="taper")
		code	=	drug_code+(parseInt(srl_no)+1);
	else
		code	=	drug_code+srl_no;

	if(frm!=undefined || frm!=null)
		called_frm=frm;
		
	xmlStr	 ="<root><SEARCH " ;
	xmlStr	+=" bean_id=\""+ bean_id + "\" ";
	xmlStr	+=" bean_name=\""+ bean_name + "\" ";
	xmlStr	+=" drug_code=\""+ drug_code + "\" ";
	xmlStr	+=" form_code=\""+ form_code + "\" ";
	xmlStr	+=" route_code=\""+ route_code + "\" ";
	xmlStr	+=" patient_id=\""+ patient_id + "\" ";	
	xmlStr	+=" encounter_id=\""+ encounter_id + "\" ";
	xmlStr	+=" called_frm=\""+ called_frm + "\" ";	
	xmlStr	+=" /></root>" ;		
	fieldValidation(xmlStr,"getFormatId");
}

var pres_vals	=	new Array();
var i			=	0;
var formatId	=	"";
var drug_code	=	"";

function prescriptionValues(vals)	{
	pres_vals[i++] = vals;
}

function getActionText(route_code,form_code){ //Add this function for SKR-CRF-0006[IN029561]	

	var route_code = route_code.value;
  	var bean_id			= "DirectDispensingBean";
	var bean_name       = "ePH.DirectDispensingBean";
	var xmlStr ="<root><SEARCH ";	
	var xmlDoc="";
	var xmlHttp = new XMLHttpRequest();
	xmlStr	="<root><SEARCH " ;
	xmlStr+= "bean_id  =\"" + bean_id + "\" " ;
	xmlStr+= "bean_name =\"" + bean_name + "\" " ;	
	xmlStr += "form_code=\""+form_code +"\" " ;
	xmlStr += "route_code=\""+ route_code +"\" " ;			
	xmlStr +=" /></root>" ;
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml") ;
	xmlHttp.open("POST", "DirectDispValidate.jsp?func_mode=getActiontext", false ) ;
	xmlHttp.send( xmlDoc ) ;	
	eval(xmlHttp.responseText);	

	
}
function assignactionText(actionText){ //Add this function for SKR-CRF-0006[IN029561]				
	var 	drug_frmobj =parent.parent.parent.parent.f_detail.f_ord_detail.f_drug_detail.f_drug.prescription_detail_form;
	document.getElementById('actionTextval').innerText=actionText;	
}

function validateRemarks(format_id)	{
	var format		=	format_id.split("~");
	var mandatory	=	format[0];
	 formatId		=	format[1];
	 drug_code	    =	parent.parent.parent.parent.f_detail.f_ord_detail.f_drug_detail.f_drug.document.prescription_detail_form.drug_code.value; 
	//added for SKR-SCF-0140 -start
/*	if(format == null || format=='' || formatId==null || formatId=='')
		parent.parent.parent.parent.f_detail.f_ord_detail.f_drug_detail.f_drug.document.prescription_detail_form.all.drug_remarks.style.display = 'none';
	else
		parent.parent.parent.parent.f_detail.f_ord_detail.f_drug_detail.f_drug.document.prescription_detail_form.all.drug_remarks.style.display = 'inline';
	*///added for SKR-SCF-0140 -end

}
function checkWtAndHt(frmObj){
	var drug_frmobj				=parent.parent.parent.parent.f_detail.f_ord_detail.f_drug_detail.f_drug.document.prescription_detail_form;
	var formObject	= parent.parent.parent.parent.f_detail.f_header.document.dir_disp_header_form;
	var drug_doc=parent.parent.parent.parent.f_detail.f_ord_detail.f_drug_detail.f_drug.document;
	
	if(formObject.height!=undefined && formObject.height!=null && formObject.weight!=null) {

		var weight		= formObject.weight.value;
		var bsa			= formObject.bsa.value;

		if(formObject.height.value.length > 0 && formObject.weight.value.length > 0){
			if(drug_frmobj.recomm_yn.value=="Y") {
				drug_doc.rec_legend.style.visibility='visible';
			}
			var default_recm_dose_yn = document.getElementById('default_recm_dose_yn').value; // Added for ML-MMOH-CRF-0978
			if(document.getElementById('rec_legend').style.visibility=='visible' && default_recm_dose_yn=="true" ){ // Added for ML-MMOH-CRF-0978 - Start
				
				if(document.getElementById('dosage_type').value == document.getElementById('recomm_dosage_by').value){
				 if(document.getElementById('amend_yn').value=="N"){
					  document.getElementById('qty_value').value = document.getElementById('recom_value').value;
					  document.getElementById('strength').value = document.getElementById('recom_value').value;
				  }
					document.getElementById('rec_legend').disabled=false;
				}
				else
					document.getElementById('rec_legend').disabled=true;
			}  // Added for ML-MMOH-CRF-0978 - End

			var dosage_std	=	drug_frmobj.dosage_std.value;
			var dosage_unit	=	drug_frmobj.dosage_unit.value;
			if(drug_frmobj.calc_by_ind.value=="A") {
				if(isNaN(dosage_std))
						dosage_std="0";
				drug_doc.rec_value.innerHTML	= dosage_std;
				drug_doc.rec_uom.innerHTML		= dosage_unit;
			} 
			else if(drug_frmobj.calc_by_ind.value=="W") {
				var calc_value	=	parseInt(parseFloat(weight)*parseFloat(dosage_std));
				if(isNaN(calc_value))
					calc_value="0";
				drug_doc.rec_value.innerHTML	= calc_value;
				drug_doc.rec_uom.innerHTML		= dosage_unit;
			}
			else if(drug_frmobj.calc_by_ind.value=="B") {
				var calc_value	=	parseInt(parseFloat(bsa)*parseFloat(dosage_std));
				if(isNaN(calc_value))
					calc_value="0";
				drug_doc.rec_value.innerHTML	= calc_value;
				drug_doc.rec_uom.innerHTML		= dosage_unit;
			}
		}
	}
}

function callOrder()	{

	var vals="";
	for(i=0; i<pres_vals.length; i++)	{
		if(i==pres_vals.length)
		vals	+= pres_vals[i];
		else
		vals	+= pres_vals[i]+ "::";
	}
	var drug_frmobj				=parent.parent.parent.parent.f_detail.f_ord_detail.f_drug_detail.f_drug.document.prescription_detail_form;
	var drug_code		=	drug_frmobj.drug_code.value;
	var srl_no			=	drug_frmobj.srl_no.value;
	var calling_mode	=	drug_frmobj.calling_mode.value;

	if(calling_mode=="taper")
		code	=	drug_code+(parseInt(srl_no)+1);
	else
		code	=	drug_code+srl_no;

	callRemarks(formatId,code,'PH','0','PH',vals);

}

async function callRemarks(format_id,catalog_code,order_category,row_value,called_from,pres_vals)	{
	var drug_frmobj				=parent.parent.parent.parent.f_detail.f_ord_detail.f_drug_detail.f_drug.document.prescription_detail_form;
	patient_id		=drug_frmobj.patient_id.value;
	encounter_id	=drug_frmobj.encounter_id.value;
	srl_no			=drug_frmobj.srl_no.value;
	bean_id			= "@orderentrybean"+patient_id+encounter_id;
	bean_name		= "eOR.OrderEntryBean";
	srl_no			= "0";

	var dialogHeight= "25vh" ;
	var dialogWidth	= "50vw" ;
	var dialogTop	= "169" ;
	var center		= "1" ;
	var status		="no";
	var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop;
	var arguments	= "" ;
	retVal			= await window.showModalDialog("../../eOR/jsp/OrderEntryOrderFormatFrameSet.jsp?bean_id="+bean_id+"&bean_name="+bean_name+"&format_id="+format_id+"&catalog_code="+catalog_code+"&order_category="+order_category+"&row_value=0&called_from=PH&ph_list_vals="+pres_vals,arguments,features);
}

function dosageChange(obj, callFrom) {
	if(obj.value!="") {
		parent.parent.parent.parent.f_detail.f_ord_detail.f_drug_detail.f_drug.document.getElementById("rec_uom").innerText	=	"";
        var default_recm_dose_yn = document.getElementById("default_recm_dose_yn").value; // Added for ML-MMOH-CRF-0978
		if(obj.value!="A") {					
			deleteScheduleLink();
			DisableSchedule1();
			if(obj.value=="S") {
				dfltStrnQtyDescList();
			} 
			else {
				populateQtyDesc2();
			}
			validateQtyDesc(obj.value,'');
			validateDosageLimit();
			storeSchedule();	
			if(callFrom != 'ONLOAD')
				loadallocatedetail('allocate','ONCLICK');
		}
		if(document.getElementById('rec_legend').style.visibility=='visible' && default_recm_dose_yn=="true"){ // Added for ML-MMOH-CRF-0978 - Start
			if(document.getElementById('dosage_type').value == document.getElementById('recomm_dosage_by').value){
				document.getElementById('rec_legend').disabled=false;
				document.getElementById('rec_uom').innerHTML		= document.getElementById('dosage_unit').value;
				document.getElementById('qty_value').value = document.getElementById('recom_value').value;
				document.prescription_detail_form.qty_value.onblur();
			}
			else{
				document.getElementById('rec_legend').disabled=true;
				document.getElementById('rec_uom').innerHTML		= document.getElementById('dosage_unit').value;
			}
		}  // Added for ML-MMOH-CRF-0978 - End
	}
}

function dfltStrnQtyDescList(){
	clearQtyDescList();
	var opt1	= document.createElement("OPTION") ;
	opt1.text	= document.prescription_detail_form.strength_uom_desc.value ;
	opt1.value	= document.prescription_detail_form.strength_uom.value;
	document.prescription_detail_form.qty_desc.add(opt1);
	document.prescription_detail_form.qty_desc.value = document.prescription_detail_form.strength_uom.value;
}
function populateQtyDesc2(){
	var formobj=document.prescription_detail_form;
	var hdr_formobj		= parent.parent.parent.parent.f_detail.f_header.document.dir_disp_header_form;	
	var form_code=formobj.form_code.value;
	var drug_code=formobj.drug_code.value;
	var pres_base_uom=formobj.pres_base_uom.value;
	var pres_base_uom_desc=formobj.pres_base_uom_desc.value;
	var rx_qty_by_pres_base_uom_yn	=	hdr_formobj.rx_qty_by_pres_base_uom_yn.value;
	var fldString=" form_code=\""+ form_code + "\" ";
	fldString +=" pres_base_uom=\""+ pres_base_uom + "\" ";
	fldString +=" pres_base_uom_desc=\""+pres_base_uom_desc + "\" "; //encodeURIComponent( pres_base_uom_desc,"UTF-8")
	fldString +=" rx_qty_by_pres_base_uom_yn=\""+ rx_qty_by_pres_base_uom_yn + "\" ";
	var xmlStr=formXMLString(formobj,fldString);
	return fieldValidation(xmlStr,"populateQtyDesc");
}

function DisableSchedule1(){
	var drug_frmobj		=  parent.parent.parent.parent.f_detail.f_ord_detail.f_drug_detail.f_drug.document.prescription_detail_form;
	var drug_code		= drug_frmobj.drug_code.value;
	var srl_no			= drug_frmobj.srl_no.value;
	var calling_mode	= drug_frmobj.calling_mode.value;

	if(calling_mode=="taper")
		code	=	drug_code+(parseInt(srl_no)+1);
	else
		code	=	drug_code+srl_no;

	var fldString=" drug_code=\""+ code + "\" ";
	var formobj=drug_frmobj;
	var xmlStr=formXMLString(formobj,fldString);
	fieldValidation(xmlStr,"disableScheduleLink1");
}
function storeSchedule() {
	var drug_frmobj				=parent.parent.parent.parent.f_detail.f_ord_detail.f_drug_detail.f_drug.document.prescription_detail_form;
	var start_date		= drug_frmobj.start_date.value;
	var split_dose_yn	= drug_frmobj.split_dose_yn.value;
	var qty_value		= drug_frmobj.qty_value.value;
	var freq_code		= drug_frmobj.frequency.value;	
	var drug_code		= drug_frmobj.drug_code.value;	
	var srl_no			= drug_frmobj.srl_no.value;		
	var rowVal			= drug_frmobj.rowVal.value;		
	var calling_mode	= drug_frmobj.calling_mode.value;
	var scheduled_yn	= drug_frmobj.scheduled_yn.value;
	if(calling_mode=="taper") {
		srl_no	=	parseInt(srl_no)+1;
	}
	var fldString=" start_date=\""+ start_date + "\" ";
		fldString+=" split_dose_yn=\""+ split_dose_yn + "\" ";
		fldString+=" qty_value=\""+ qty_value + "\" ";
		fldString+=" freq_code=\""+ freq_code + "\" ";
		fldString+=" drug_code=\""+ drug_code + "\" ";
		fldString+=" srl_no=\""+ srl_no + "\" ";
		fldString+=" rowVal=\""+ rowVal + "\" ";
		fldString+=" scheduled_yn=\""+ scheduled_yn + "\" ";			

	var formobj=drug_frmobj;
	var xmlStr=formXMLString(formobj,fldString);
	fieldValidation(xmlStr,"storeSchedule");

	code	=	drug_code + srl_no;

	var fldString=" drug_code=\""+ code + "\" ";
	var xmlStr=formXMLString(formobj,fldString);
	
	fieldValidation(xmlStr,"makeScheduleLink");
}
function checkSchedule(obj) {
	var drug_frmobj				=parent.parent.parent.parent.f_detail.f_ord_detail.f_drug_detail.f_drug.document.prescription_detail_form;
	var drug_doc =parent.parent.parent.parent.f_detail.f_ord_detail.f_drug_detail.f_drug.document;
	if(drug_frmobj.init_qty!=null) {
		var init_value	=	drug_frmobj.init_qty.value;
		if(drug_doc.dosage_label.innerText==getLabel("ePH.DividedDose.label","PH") && obj.value!=init_value) {
			drug_frmobj.split_dose_chk.click();
		}
	}
}
function changedoseoverridevalue()
{
	 var drug_frmobj				=parent.parent.parent.parent.f_detail.f_ord_detail.f_drug_detail.f_drug.document.prescription_detail_form;
	 var drug_doc				=parent.parent.parent.parent.f_detail.f_ord_detail.f_drug_detail.f_drug.document.prescription_detail_form;
     var perform_external_database_checks_yn =drug_frmobj.perform_external_database_checks_yn.value;
	 if(perform_external_database_checks_yn =='N'){
			if(drug_frmobj.recomm_yn.value=="Y") {
				var recc_dose	= drug_doc.rec_value.innerHTML;
				var qty_value	= drug_frmobj.qty_value.value;
				var drug_code	= drug_frmobj.drug_code.value;
				var srl_no		= drug_frmobj.srl_no.value;
				var bean_id		= drug_frmobj.bean_id.value;
				var bean_name	= drug_frmobj.bean_name.value;
				var limit_ind	="";
				if(recc_dose!=qty_value){
					limit_ind='N';
					drug_frmobj.limit_ind.value = 'N';
					drug_frmobj.limit_ind.value = 'N';			
					drug_frmobj.dosage_limit.style.visibility='visible';
					drug_frmobj.dosage_limit.style.display="inline";
				}else{			
					drug_frmobj.limit_ind.value = 'Y';
					limit_ind='Y';					
				}
				var xmlStr ="<root><SEARCH ";
				xmlStr += " bean_id=\""+ bean_id + "\" ";
				xmlStr += " bean_name=\""+ bean_name + "\" ";
				xmlStr += " limit_ind=\""+ limit_ind + "\" ";
				xmlStr += " drug_code=\""+ drug_code + "\" ";
				xmlStr += " srl_no=\""+ srl_no + "\" ";
				xmlStr +=" /></root>";
				fieldValidation(xmlStr,"changeoverridevalue");
			}
	 }
}
function disableoverride(limit_ind){
	interaction_exists = document.prescription_detail_form.interaction_exists.value; // added for FD-RUT-CRF-0066.1 [IN036975]
	var drug_frmobj				=parent.parent.parent.parent.f_detail.f_ord_detail.f_drug_detail.f_drug.document.prescription_detail_form;
	if(limit_ind=='Y' && drug_frmobj.allergy_yn.value =='N' && drug_frmobj.current_rx.value == 'N' && interaction_exists!="Y" ){
		drug_frmobj.dosage_limit.style.visibility='hidden';
		drug_frmobj.dosage_limit.style.display="none";
	}
	else{	 
		if(limit_ind=='N'||drug_frmobj.allergy_yn.value =='Y'|| drug_frmobj.current_rx.value == 'Y' || interaction_exists=="Y"){		 
			drug_frmobj.dosage_limit.style.visibility='visible';
			drug_frmobj.dosage_limit.style.display="inline";		 
		}
	}
}

function setRecommendDosage(){	
	var drug_frmobj				=parent.parent.parent.parent.f_detail.f_ord_detail.f_drug_detail.f_drug.document.prescription_detail_form;
  if(document.getElementById('rec_legend').disabled!=true){ // only if condition Added for ML-MMOH-CRF-0978 -Start
	drug_frmobj.qty_value.value = document.getElementById('rec_value').innerHTML;	
	drug_frmobj.qty_value.focus();
	changedoseoverridevalue();
	changeschedule();
  }  // only if condition Added for ML-MMOH-CRF-0978 -End
}

function freqChange(obj,flag) {
	populateDurationDesc(obj);
	checkForPRN(obj);
	validateDosageLimit();
	var drug_frmobj				= parent.parent.parent.parent.f_detail.f_ord_detail.f_drug_detail.f_drug.document.prescription_detail_form;
	var drug_doc				= parent.parent.parent.parent.f_detail.f_ord_detail.f_drug_detail.f_drug.document.prescription_detail_form;

	//if( (drug_frmobj.dosage.value=="A" && (drug_frmobj.patient_class.value=="OP" || drug_frmobj.patient_class.value=="EM") ) || drug_frmobj.freq_nature.value=="P" || drug_frmobj.freq_nature.value=="O") {
	if( drug_frmobj.dosage.value=="A" || drug_frmobj.freq_nature.value=="P" || drug_frmobj.freq_nature.value=="O") {//removed && (drug_frmobj.patient_class.value=="OP" || drug_frmobj.patient_class.value=="EM") to display order quantity for absolute drugs
		deleteScheduleLink();
		DisableSchedule1();
		
		if(drug_frmobj.sliding_scale_yn!=null && (drug_frmobj.freq_nature.value=="P") || (drug_frmobj.freq_nature.value=="O")) {
			if(drug_frmobj.btnSchedule!=undefined)
				drug_frmobj.btnSchedule.style.display='none';
			//document.prescription_detail_form.btnSchedule.disabled	=	true;
			if((drug_frmobj.freq_nature.value!="O")) {
				drug_frmobj.absol_qty.style='display';
				drug_doc.ord_qty_lbl.style='display';
				drug_doc.ord_qty_uom.style='display';
			}
		}
	} 
	else { 
		//if(drug_frmobj.sliding_scale_yn!=undefined ) {
			if((drug_frmobj.freq_nature.value!="O")) {
				drug_frmobj.absol_qty.style.display='none';
				drug_doc.ord_qty_lbl.style.display='none';
				drug_doc.ord_qty_uom.style.display='none';
			}
		//}
		if(flag=="M"){ // flag will come as "M" when the shchedule button returns a frequency
			flag="Y";		
		}
		else{
			deleteScheduleLink();
			DisableSchedule1();
			storeSchedule();			
		}
		checkSchedule(drug_frmobj.qty_value);
		reloadDurnTypeList(flag);
	}
	if(flag=="Y")
		loadallocatedetail('allocate','ONCLICK');
	else
		loadallocatedetail('allocate','ONLOAD');
}

function populateDurationDesc(obj){
	var freq_code		=	obj.value;
	var hdr_formobj		= parent.parent.parent.parent.f_detail.f_header.document.dir_disp_header_form;
	var drug_frmobj				=parent.parent.parent.parent.f_detail.f_ord_detail.f_drug_detail.f_drug.document.prescription_detail_form;
	var patient_class	=	hdr_formobj.patient_class.value;			
	var drug_code=drug_frmobj.drug_code.value;
	var fldString =" freq_code=\""+ freq_code + "\" ";
		fldString+=" patient_class=\""+ patient_class + "\" ";
		fldString+=" drug_code=\""+ drug_code + "\" ";
	var formobj=drug_frmobj;
	var xmlStr=formXMLString(formobj,fldString);
	return fieldValidation(xmlStr,"populateDurationDesc");
}

function validateDuration(obj,onclick_flag, callFrom){
	if(onclick_flag==undefined)
		onclick_flag='Y';
	if(parseInt(obj.value)==0 || obj.value=="") {
		alert(getMessage("PRES_DURN_CANNOT_ZERO","PH"));
		obj.focus();
		return;
	}
	var drug_frmobj				=parent.parent.parent.parent.f_detail.f_ord_detail.f_drug_detail.f_drug.document.prescription_detail_form; 
	if(drug_frmobj.repeat_durn_type.value!=drug_frmobj.durn_desc.value){
		durationConversn(drug_frmobj.durn_desc,"");
		obj=drug_frmobj.tmp_durn_value;
	}
	if(validateMaxRefillDuration('durn')){			
		var freq_value			=	drug_frmobj.freq_value.value;
		var calculated_value	=	"";
		var interval_value		=	drug_frmobj.interval_value.value;
		if(freq_value=="0"){
			var calc			=   parseFloat(obj.value/interval_value);
			calculated_value	=	Math.ceil(calc);
		}else{
			calculated_value	=	freq_value;
		}		
		drug_frmobj.calcualted_durn_value.value	=	calculated_value;
		var durn_value		=	obj.value;
		var source			=	drug_frmobj.source.value;
		
		if(durn_value!=""){
			var drug_code		=	drug_frmobj.drug_code.value;
			var patient_class	=	parent.parent.parent.parent.f_detail.f_header.document.dir_disp_header_form.patient_class.value;
			var srlNo			=	drug_frmobj.srl_no.value;

			var fldString=" durn_value=\""+ durn_value + "\" ";
			fldString += " drug_code=\""+ drug_code + "\" ";
			fldString += " patient_class=\""+ patient_class + "\" ";
			fldString += " source=\""+ source + "\" ";
			fldString += " srlNo=\""+ srlNo + "\" ";
			var formobj=drug_frmobj;
			var xmlStr=formXMLString(formobj,fldString);
			if(fieldValidation(xmlStr,"validateDuration") && callFrom!='ONLOAD'){
				if(onclick_flag=='N')
					loadallocatedetail('allocate','ONLOAD');
				else
					loadallocatedetail('allocate','ONCLICK');
				//return fieldValidation(xmlStr,"validateDuration"); // comment for ML-BRU-SCF-0396 [IN034906]
			}
			else{
				return fieldValidation(xmlStr,"validateDuration");
			}
		}
	}		
}

function assignDurnvalue(total_durn_value,max_durn_value,chk_for_max_durn_action,prompt_msg){
	var durn_value	=	parseInt(document.prescription_detail_form.durn_value.value);	
	/* Below code added for ML-BRU-SCF-0396 [IN034906] */
	var tmp_durn_value	=	parseInt(document.prescription_detail_form.tmp_durn_value.value);	
	if(durn_value < tmp_durn_value)	 
	   durn_value = tmp_durn_value;	  
	/* Above code added for ML-BRU-SCF-0396 [IN034906] */	
	if(durn_value>parseInt(max_durn_value)){	
		if(chk_for_max_durn_action=="R"){
			alert(getMessage("PH_MAX_DURN","PH"));
			document.prescription_detail_form.durn_value.focus();
			return false;	
		}else if(chk_for_max_durn_action=="W")	{
			alert(getMessage("PH_WARN_DURN","PH"));
			populateStartDate(document.prescription_detail_form.durn_value);
		} else if(chk_for_max_durn_action=="A") {
			alert(getMessage("PH_AUTH_DURN","PH"));					
			populateStartDate(document.prescription_detail_form.durn_value);
					
		}
	}
	else{
		populateStartDate(document.prescription_detail_form.durn_value);
	}
}

function populateStartDate(obj){
		var source		=	obj.name;
		var mode		=	document.prescription_detail_form.mode.value;
		var sys_date	=	parent.parent.parent.parent.f_detail.f_header.document.dir_disp_header_form.sys_date.value;
		if(document.prescription_detail_form.start_date.value==''){
		document.prescription_detail_form.start_date.value	=	sys_date;
		}
		var start_date	=	document.prescription_detail_form.start_date.value;
		var fldString=" start_date=\""+ start_date + "\" ";
			fldString += " source=\""+ source + "\" ";
		var formobj		=	document.prescription_detail_form;
		var xmlStr=formXMLString(formobj,fldString);
		return fieldValidation(xmlStr,"populateStartDate");
}
function assignStartDate(source,start_date,future_date,back_date){
			document.prescription_detail_form.start_date.value	=	start_date;
	if(source=="qty_value"){
			document.prescription_detail_form.end_date.value	=	start_date;
			populateEndDate();
	}else if(source=="durn_value"){
		populateEndDate();
	}
}
function chkBackFutureDate(obj){
if(obj.value!=""){
		var back_date	=	document.prescription_detail_form.back_date;
		var future_date	=	document.prescription_detail_form.future_date;
		if(doDateTimeChk(obj)){
			if(future_date!=null && future_date!='null' && future_date!="0" ){
				if(ValidateDateTime(obj,future_date)){
						populateEndDate();
				}else{		
						alert(getMessage("PH_BACK_DATE","PH"));
						obj.focus();
				}
			}else{
				populateEndDate();
			}
			if(back_date!=null &&  back_date!='null' && back_date!="0"){
				   if(ValidateDateTime(back_date,obj)){					
						populateEndDate();
					}else{					
						alert(getMessage("PH_BACK_DATE","PH"));
						obj.focus();
				   }
			}else{
			populateEndDate();
			}
		}else{
			
			alert(getMessage("INVALID_DATE_TIME","PH"));
			obj.focus;
		}
	}
}
function assignDurnDesc(repeat_value,repeat_durn_type,freq_nature,interval_value,durn_desc,freq_value,schedule_yn){
	
	var drug_frmobj				=parent.parent.parent.parent.f_detail.f_ord_detail.f_drug_detail.f_drug.document.prescription_detail_form;

	if(freq_value=="null" || freq_value==null) 
		freq_value=="0";

	var split_dose_yn	=	drug_frmobj.split_dose_yn.value;
	var allow_chk		=	"Y";

	if(freq_nature=="O" || freq_nature=="P") 
		allow_chk="N";

	if(repeat_durn_type=="null" || repeat_durn_type==null || repeat_durn_type=="")
		repeat_durn_type	=	"D";

	if(allow_chk=="Y" && schedule_yn=="Y"){
		if(drug_frmobj.dosage.value=="A" && (drug_frmobj.patient_class.value=="OP" || drug_frmobj.patient_class.value=="EM")){
			drug_frmobj.split_dose.disabled=true;
		} else {
			drug_frmobj.split_dose.disabled=false;
			drug_frmobj.sch_over_yn.value="Y";
		}
	} else {
		drug_frmobj.split_dose.disabled=true;
		drug_frmobj.sch_over_yn.value="Y";
	}
	
	if(drug_frmobj.refill_cont_order_yn.value=="Y"){
		drug_frmobj.allow_refill.disabled=false;
	}else{
		drug_frmobj.allow_refill.disabled=true;
	}
		drug_frmobj.freq_value.value=freq_value;
		drug_frmobj.durn_value.disabled=false;
		drug_frmobj.durn_desc.disabled=false;
		if(repeat_durn_type=="L"){
			drug_frmobj.durn_desc.value="L";
			//drug_frmobj.durn_desc.disabled=true;
		}
		if(repeat_durn_type=="W"){
			drug_frmobj.durn_desc.value="W";
			//drug_frmobj.durn_desc.disabled=true;
		}
		if(repeat_durn_type=="D"){
			drug_frmobj.durn_desc.value="D";
			//drug_frmobj.durn_desc.disabled=true;
		}
		if(repeat_durn_type=="H"){
			drug_frmobj.durn_desc.value="M";
			drug_frmobj.durn_value.value="1";
			//drug_frmobj.durn_desc.disabled=true;
			drug_frmobj.calcualted_durn_value.value="1";
		}
		if(repeat_durn_type=="H"){
			drug_frmobj.durn_desc.value="D";
			drug_frmobj.durn_value.value="1";
			//drug_frmobj.durn_desc.disabled=true;
			drug_frmobj.calcualted_durn_value.value="1";
		}
		if(freq_nature=='O'){
			if(drug_frmobj.in_durn_desc!=null) {
				drug_frmobj.in_durn_desc.value="";
				drug_frmobj.in_durn_value.value="";
				drug_frmobj.allow_refill.disabled=true;
				drug_frmobj.no_refill.value="";
				drug_frmobj.refill_start_date.value="";
				drug_frmobj.refill_end_date.value="";
			}
			drug_frmobj.durn_desc.value="D";
			drug_frmobj.durn_value.value="1";
			drug_frmobj.durn_value.disabled=true;
			drug_frmobj.durn_desc.disabled=true;
			drug_frmobj.calcualted_durn_value.value="1";
			interval_value="1";
			repeat_value="1";
		}else if(freq_nature=='P'){

			drug_frmobj.durn_desc.value="D";
			drug_frmobj.durn_desc.disabled=true;
			drug_frmobj.durn_value.disabled=false;
			drug_frmobj.allow_refill.disabled=true;
			if(drug_frmobj.no_refill!=null) {

				drug_frmobj.no_refill.value="";
				drug_frmobj.no_refill.disabled=true;
				drug_frmobj.refill_start_date.value="";
				drug_frmobj.refill_end_date.value="";
			}
			interval_value="1";
			repeat_value="1";

		}
		drug_frmobj.interval_value.value=interval_value;
		drug_frmobj.repeat_value.value=repeat_value;
		drug_frmobj.freq_nature.value=freq_nature;
		drug_frmobj.repeat_durn_type.value=repeat_durn_type;
		drug_frmobj.calcualted_durn_value.value=repeat_value;
		drug_frmobj.scheduled_yn.value=schedule_yn;
	populateEndDate();
}
function checkForPRN(obj) {
	var drug_frmobj				=parent.parent.parent.parent.f_detail.f_ord_detail.f_drug_detail.f_drug.document.prescription_detail_form;
	var drug_doc				=parent.parent.parent.parent.f_detail.f_ord_detail.f_drug_detail.f_drug.document;
	var man_rem_on_prn_freq_yn = parent.parent.parent.f_header.document.dir_disp_header_form.man_rem_on_prn_freq_yn.value;

	
	if(drug_frmobj.freq_nature.value=="P") {
		if(drug_frmobj.prn_dose!=null) {
			drug_frmobj.absol_qty.disabled					=	false;
			drug_frmobj.absol_qty.value						= drug_frmobj.prn_dose.value;
			drug_frmobj.absol_qty.style.visibility			= "visible";
			drug_doc.ord_qty_lbl.style.visibility		= "visible";
			drug_doc.ord_qty_uom.style.visibility		= "visible";
			drug_doc.prn_remarks.style.visibility		= "visible";
			if(man_rem_on_prn_freq_yn=="Y")
			    drug_doc.prn_remarks_image.style.visibility	= "visible";
			drug_doc.dis_split_dose.style.visibility	= "hidden";
			drug_doc.dis_split_dose.style.dispay		= "none";
			
		}
	} else {
		
			if(drug_frmobj.dosage_type.value!="A") {		
			drug_frmobj.absol_qty.value						=  "";		
			drug_frmobj.absol_qty.style.visibility			= "hidden";
			drug_doc.ord_qty_lbl.style.visibility		= "hidden";
			drug_doc.ord_qty_uom.style.visibility		= "hidden";
			drug_doc.prn_remarks.style.visibility		= "hidden";
			if(man_rem_on_prn_freq_yn=="Y")
			    drug_doc.prn_remarks_image.style.visibility	= "hidden";
			drug_doc.dis_split_dose.style.visibility	= "visible";
			drug_doc.dis_split_dose.style="display";

		}
	}
}
function validateDosageLimit(){
	var formObject			= parent.parent.parent.parent.f_detail.f_header.document.dir_disp_header_form;//Added for IN:070451
    var drug_frmobj	= parent.parent.parent.parent.f_detail.f_ord_detail.f_drug_detail.f_drug.document.prescription_detail_form;
	var patient_id	= drug_frmobj.patient_id.value;
	var qty_value	= drug_frmobj.qty_value.value;
	var drug_code	= drug_frmobj.drug_code.value;
	var dosage_type = drug_frmobj.dosage_type.value;
	var srl_no		= drug_frmobj.srl_no.value;
	var calling_mode= drug_frmobj.calling_mode.value;
	var start_date	= drug_frmobj.start_date.value;
	var generic_id	= drug_frmobj.generic_id.value;
	var freq_code	= drug_frmobj.frequency.value;
	var perform_external_database_checks_yn = drug_frmobj.perform_external_database_checks_yn.value;
        //Added for IN:070451 start
	var weight = formObject.weight.value;
	var bsa	= formObject.bsa.value;
	var calc_by_ind	= drug_frmobj.calc_by_ind.value;
	var factor;
	//ML-MMOH-CRF-1408 - start
	var temp_qty ="";
	//alert(weight);
	//alert(bsa);
	//alert(calc_by_ind);
	//alert(formObject.bsa.value.length > 0);

	 if(formObject.bsa.value.length > 0){
		 if(drug_frmobj.calc_by_ind!=undefined){ 
			 if(calc_by_ind=="W") {
				temp_qty	=	(parseFloat(qty_value)/parseFloat(weight));
				factor=weight;
			}
			else if(calc_by_ind=="B") {
				temp_qty	=	(parseFloat(qty_value)/parseFloat(bsa));
				factor=bsa;
				
		   }else{
			 temp_qty=qty_value;
			 factor="1";
		   }
		 }else{
			 temp_qty=qty_value;
		 factor="1";
		 }
	 }

	 if(temp_qty==""){ 
		 temp_qty = qty_value;
		 factor="1";
	 }
	//Added for IN:070451 end
//alert(temp_qty);

	if(parseFloat(qty_value)==0 || qty_value=="") {
		alert(getMessage("PRES_DOSAGE_CANNOT_ZERO","PH"));
		drug_frmobj.qty_value.focus();
		return;
	}

	var repeat_value= "";
	if(oldrepeatvalue==undefined)
		repeat_value = drug_frmobj.repeat_value.value;
	else
		repeat_value =oldrepeatvalue;

	if(calling_mode=="taper") {
		srl_no	=	parseInt(srl_no) + 1;
	}

	var fldString  = " patient_id=\""+ patient_id + "\" ";
		fldString += " qty_value=\""+ temp_qty + "\" ";//Modified for IN:070451 start
		fldString += " dosage_type=\""+ dosage_type + "\" ";
		fldString += " repeat_value=\""+ repeat_value + "\" ";
		fldString += " drug_code=\""+ drug_code + "\" ";
		fldString += " srl_no=\""+ srl_no + "\" ";
		fldString += " start_date=\""+ start_date + "\" ";	
		fldString += " generic_id=\""+ generic_id + "\" ";		
		fldString += " freq_code=\""+ freq_code + "\" ";
		fldString += " perform_external_database_checks_yn=\""+perform_external_database_checks_yn +"\" ";
		fldString += " factor=\""+ factor + "\" "//Added for IN:070451 
		
		var formobj=drug_frmobj;
		var xmlStr=formXMLString(formobj,fldString);
		fieldValidation(xmlStr,"validateDosageLimit");

}
function enableDosageLimit(limit_ind,daily_dose,unit_dose,mono_graph, min_daily_dose, min_unit_dose){
	 var drug_frmobj				=parent.parent.parent.parent.f_detail.f_ord_detail.f_drug_detail.f_drug.document.prescription_detail_form;
	drug_frmobj.dosage_limit.style.visibility	= "visible";
	drug_frmobj.limit_ind.value						= limit_ind;
	drug_frmobj.daily_dose.value					= daily_dose;
	drug_frmobj.unit_dose.value						= unit_dose;
	drug_frmobj.mono_graph.value					= mono_graph;
	drug_frmobj.min_daily_dose.value				= min_daily_dose;
	drug_frmobj.min_unit_dose.value					= min_unit_dose;
	drug_frmobj.dosage_limit.style="display";
}

function disableDosageLimit(){
	var drug_frmobj				=parent.parent.parent.parent.f_detail.f_ord_detail.f_drug_detail.f_drug.document.prescription_detail_form;
	var current_rx	= drug_frmobj.current_rx.value;
	var allergy_yn	= drug_frmobj.allergy_yn.value;
	var interaction_exists= drug_frmobj.interaction_exists.value; // added for FD-RUT-CRF-0066.1 [IN036975]
	drug_frmobj.limit_ind.value		= "Y";
	if( allergy_yn!="Y" && interaction_exists!="Y" && current_rx!="Y"){//Modified for IN:073488
		drug_frmobj.dosage_limit.style.visibility='hidden';
		drug_frmobj.dosage_limit.style.display="none";
		//drug_frmobj.daily_dose.value	= "";
		//drug_frmobj.unit_dose.value		= "";
		//drug_frmobj.mono_graph.value	= "";
	}	
}

function setfocus(obj) {
	obj.focus();
}

function lookForChange(obj,onclick_flag) {
	if(onclick_flag==undefined)
			onclick_flag='Y';
	var drug_frmobj				= parent.parent.parent.parent.f_detail.f_ord_detail.f_drug_detail.f_drug.document.prescription_detail_form;
	var curr_val	=	obj.value;
    var init_val	=	drug_frmobj.init_qty.value;
	
	if(curr_val!=init_val) {
		if((drug_frmobj.dosage.value=="A" && (drug_frmobj.patient_class.value=="OP" || drug_frmobj.patient_class.value=="EM"))|| drug_frmobj.freq_nature.value=="P" ) {
			deleteScheduleLink();
			DisableSchedule();
		}
		else {
			deleteScheduleLink();			
			DisableSchedule();
			storeSchedule();
			validateDosageLimit();		
			CheckPositiveNumber(obj);
			if(obj.value=="0") obj.value="1";
			checkSchedule(obj);
		}
		if(onclick_flag=="N")
			loadallocatedetail('allocate','ONLOAD');
		else
			loadallocatedetail('allocate','ONCLICK');
	}
}

function disasbleToolTipDataChange(){//code for too schedule tool tip
    document.getElementById('tooltiplayer').style.visibility = "hidden" ;
}

function displayToolTipDataChange(text){
    buildTableDataChange(text);
    bodwidth  = parent.parent.frames[1].document.body.offsetWidth
    bodheight = parent.parent.frames[1].document.body.offsetHeight
    var x     = event.x;
    var y     = event.y;
    x     = x + (document.getElementById('tooltiplayer').offsetWidth)
    y     = y + (document.getElementById('tooltiplayer').offsetHeight)
    if(x<bodwidth)
        x = event.x
    else
        x = x - (document.getElementById('tooltiplayer').offsetWidth*2)
    if(y<bodheight)
        y = event.y
    else
        y = y - (document.getElementById('tooltiplayer').offsetHeight*2)

	y+=document.body.scrollTop ;
	x+=document.body.scrollLeft;
    /*document.getElementById("tooltiplayer").style.posLeft= x+100;
    document.getElementById("tooltiplayer").style.posTop = y-80;*/
	if(document.prescription_detail_form.sliding_scale_yn.value =='Y')
          document.getElementById('tooltiplayer').style.posLeft= x+2;
	else
         document.getElementById('tooltiplayer').style.posLeft= x-5;

	if(x > 600 )
		document.getElementById('tooltiplayer').style.posTop = y+2;
	else{
		if(document.prescription_detail_form.sliding_scale_yn.value =='Y')
             document.getElementById('tooltiplayer').style.posTop = y-5;
		else
			 document.getElementById('tooltiplayer').style.posTop = y-15;
	}
	document.getElementById('tooltiplayer').style.visibility='visible';
 }

//code for too schedule tool tip
function buildTableDataChange(text){
	var tab_dat  = text ;
	document.getElementById('t').innerHTML = tab_dat;
}

function DisableSchedule(){
	var drug_frmobj				=parent.parent.parent.parent.f_detail.f_ord_detail.f_drug_detail.f_drug.document.prescription_detail_form; 
	var drug_code		= drug_frmobj.drug_code.value;
	var srl_no			= drug_frmobj.srl_no.value;
	var calling_mode	= drug_frmobj.calling_mode.value;
	var split_dose_yn_val	= drug_frmobj.split_dose_yn_val.value;

	if(calling_mode=="taper")
		code	=	drug_code+(parseInt(srl_no)+1);
	else
		code	=	drug_code+srl_no;

	var fldString=" drug_code=\""+ code + "\" ";
	fldString += " split_dose_yn_val=\""+ split_dose_yn_val + "\" ";	
	fldString += " calling_mode=\""+ calling_mode + "\" ";	

	var formobj=drug_frmobj;
	var xmlStr=formXMLString(formobj,fldString);
	fieldValidation(xmlStr,"disableScheduleLink");
}

async function loadRefillDetails(max_refills){
	var drug_frmobj				=parent.parent.parent.parent.f_detail.f_ord_detail.f_drug_detail.f_drug.document.prescription_detail_form;
	var end_date			=	drug_frmobj.end_date.value;
	var repeat_durn_type	=	drug_frmobj.repeat_durn_type.value;
	var durn_desc			=	drug_frmobj.durn_desc.value;
	repeat_durn_type		=	durn_desc;
	var durn_value			=	drug_frmobj.durn_value.value;
	var refill_no			=	drug_frmobj.no_refill.value;
	var bean_id				=	drug_frmobj.bean_id.value;
	var bean_name			=	drug_frmobj.bean_name.value;
	var srl_no				=	drug_frmobj.srl_no.value;
	//var tmp_durn_value		=	drug_frmobj.tmp_durn_value.value;//Added for IN:069886 //Commented for IN:069886
	var max_durn_for_refill_pres = drug_frmobj.max_durn_for_refill_pres.value;
	var date_range_in_muliples = parseInt(parseInt(drug_frmobj.tmp_durn_value.value)/parseInt(drug_frmobj.durn_value.value));//Added for IN:069886
	var freq_durn_type	=	drug_frmobj.frequency.value;   //ADDED for IN:069886
	var interval_value	=	drug_frmobj.interval_value.value;   //ADDED for IN:069886
	if(end_date!=""){
		var dialogHeight= "57vh" ;
		var dialogWidth	= "50vw" ;
		var dialogTop	= "10" ;
		var dialogLeft	= "10" ;
		var center		= "1" ;
		var status		= "no";
		var scroll		= "yes";
		var features	= "dialogLeft:" + dialogLeft + ";dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; center: " + center + ";scroll "+scroll+"; status: " + status + "; dialogTop :" + dialogTop;
		var arguments	= "" ;
		retVal = await window.showModalDialog("../../ePH/jsp/DirectDispRefillDetailsFrame.jsp?dir_bean_id="+bean_id+"&dir_bean_name="+bean_name+"&end_date="+end_date+"&repeat_durn_type="+repeat_durn_type+"&durn_value="+durn_value+"&refill_no="+refill_no+"&max_refills="+max_refills+"&max_durn_for_refill_pres="+max_durn_for_refill_pres+"&srl_no="+srl_no+"&date_range_in_muliples="+date_range_in_muliples+"&freq_durn_type="+freq_durn_type+"&interval_value="+interval_value,arguments,features);//Modified for IN:069886 //Modified for IN:069886

		if(retVal!=undefined && retVal!="") {
			var refill_vals	=	retVal.split(",");
			if(refill_vals[0]!='') {
				drug_frmobj.no_refill.value=refill_vals[0];
				drug_frmobj.refill_start_date.value=refill_vals[1];
				drug_frmobj.refill_end_date.value=refill_vals[2];
			}
		}
	}
	else{
		alert(getMessages("PH_CURR_END_DATE","PH"));
	}
}
//for validating max no of refills allowewd
function validateNoRefill(obj){
	var max_refill_for_pres	=parseInt(document.refill_form.max_refills_for_pres.value);
	var refill	=	parseInt(obj.value);
	obj.value=refill;
	if(validateMaxRefillDuration("refill")){
		if(refill >=0){
			if(refill<=max_refill_for_pres){
				populateRefillDates();
			}
			else{
				alert(getMessage("PH_MAX_REFILL","PH"));
				document.refill_form.no_refill.focus();
			}
		}
	}
}

function populateRefillDates(){
	
	var end_date			=	document.refill_form.end_date.value;
	var repeat_durn_type	=	document.refill_form.repeat_durn_type.value;
	var durn_value			=	document.refill_form.durn_value.value;
	var refill_no			=	document.refill_form.no_refill.value;
	var bean_id				=	document.refill_form.bean_id.value;
	var bean_name			=	document.refill_form.bean_name.value;
	var srl_no				=	document.refill_form.srl_no.value;

	var fldString=" end_date=\""+ end_date + "\" ";
	fldString += " repeat_durn_type=\""+ repeat_durn_type + "\" ";		
	fldString += " durn_value=\""+ durn_value + "\" ";
	fldString += " refill_no=\""+ refill_no + "\" ";
	fldString += " srl_no=\""+ srl_no + "\" ";
	var formobj=document.refill_form;
	var xmlStr=formXMLString(formobj,fldString);
	fieldValidation(xmlStr,"populateRefillDates");
}

function assignRefillDates(refill_start,refill_end){
	var end_date					=	document.refill_form.end_date.value;
	var repeat_durn_type			=	document.refill_form.repeat_durn_type.value;
	var durn_value					=	document.refill_form.durn_value.value;
	var refill_no					=	document.refill_form.no_refill.value;
	var bean_id						=	document.refill_form.bean_id.value;
	var bean_name					=	document.refill_form.bean_name.value;
	var srl_no						=	document.refill_form.srl_no.value;
	var max_refills					=	document.refill_form.max_refills_for_pres.value;
	var max_durn_for_refill_pres	=	document.refill_form.max_durn_for_refill_pres.value;
	//var tmp_durn_value			=	document.refill_form.tmp_durn_value.value;//Added for IN:069886  //Commented for IN:069886
	var date_range_in_muliples	=	document.refill_form.date_range_in_muliples.value;//Added for IN:069886
	var interval_value			=	document.refill_form.interval_value.value;//Added for IN:069886
	var freq_durn_type	=	document.refill_form.freq_durn_type.value;//Added for IN:069886
	parent.refill_detail.location.href="../../ePH/jsp/DirectDispRefillDetails.jsp?dir_bean_id="+bean_id+"&dir_bean_name="+bean_name+"&end_date="+end_date+"&repeat_durn_type="+repeat_durn_type+"&durn_value="+durn_value+"&refill_no="+refill_no+"&max_refills="+max_refills+"&max_durn_for_refill_pres="+max_durn_for_refill_pres+"&srl_no="+srl_no+"&date_range_in_muliples="+date_range_in_muliples+"&freq_durn_type="+freq_durn_type+"&interval_value="+interval_value;//Modified for IN:069886

}
function saveAndClose() {
	refill_vals	=      parent.refill_detail.document.refill_form.no_refill.value+","+parent.refill_detail.document.refill_form.refill_start_date.value+","+parent.refill_detail.document.refill_form.refill_end_date.value;
	window.returnValue	=refill_vals;
	window.close();
}

function validateMaxRefillDuration(mode){

	if(mode=="refill") { 
		var durn_value		=	noOfDays(document.refill_form.repeat_durn_type,document.refill_form.durn_value.value);//Modified for IN:069886 //Modified for IN:069886
		if(durn_value=="") durn_value="0";
		durn_value			=	parseInt(durn_value);
		var max_durn_for_refill_pres	=	parseInt(document.refill_form.max_durn_for_refill_pres.value);
		var refill			=	document.refill_form.no_refill.value;
		if(refill=="") refill="0";
		refill	=	parseInt(refill);
		if((refill*durn_value)<= max_durn_for_refill_pres){
			return true;
		}
		else{
			alert(getMessage("PH_MAX_REFILL_DURN","PH"));
			document.refill_form.no_refill.value="";
			document.refill_form.no_refill.focus();
		}
	}
	else {
		var drug_frmobj		=	document.prescription_detail_form;
		var durn_value		=	drug_frmobj.durn_value.value;

		if(drug_frmobj.repeat_durn_type.value!=drug_frmobj.durn_desc.value){			
			durn_value=drug_frmobj.tmp_durn_value.value;
		}		
		if(durn_value=="") durn_value="0";
		durn_value			=	parseInt(durn_value);
		var max_durn_for_refill_pres	=	parseInt(document.prescription_detail_form.max_durn_for_refill_pres.value);
		var refill			=	document.prescription_detail_form.no_refill.value;
		if(refill=="") refill="0";
		    refill			=	parseInt(refill);

		if((refill*durn_value)<= max_durn_for_refill_pres){
			return true;
		}
		else{
			alert(getMessage("PH_MAX_REFILL_DURN","PH"));
			if(mode=="refill"){	
				document.prescription_detail_form.refill_detail_link.style.visibility="hidden";
				document.prescription_detail_form.refill_start_date.value="";
				document.prescription_detail_form.refill_end_date.value="";
				document.prescription_detail_form.no_refill.value="";
				document.prescription_detail_form.no_refill.focus();
			}
			else{
				if(drug_frmobj.repeat_durn_type.value!=drug_frmobj.durn_desc.value){	
					document.prescription_detail_form.durn_desc.focus();
				}
				else{
					document.prescription_detail_form.durn_value.focus();
					document.prescription_detail_form.durn_value.select();
				}
			}
			return false;
		}
	}
}

function loadallocatedetail(called_from,called_when){
    var drug_frmobj			= parent.parent.parent.parent.f_detail.f_ord_detail.f_drug_detail.f_drug.document.prescription_detail_form;
	var drug_code			= drug_frmobj.drug_code.value;
	var srl_no				= drug_frmobj.srl_no.value;
	
	var dosage_by			= drug_frmobj.dosage.value;	
	var durn_value			= drug_frmobj.durn_value.value;	
	if(drug_frmobj.repeat_durn_type.value!=drug_frmobj.durn_desc.value){
		durn_value			= drug_frmobj.tmp_durn_value.value;
	}
	var end_date			= drug_frmobj.end_date.value;

	var split_dose_yn_val   = drug_frmobj.split_dose_yn_val.value;
	var calling_mode		= drug_frmobj.calling_mode.value;
	if(calling_mode=="taper")
		srl_no=parseInt(srl_no)+1;

	var time2=new Array();
	var sys_time ="";
	if(end_date!='' && end_date!=null && end_date!='null'){
		time2=end_date.split(" ");
		sys_time = time2[0];
	}
	var qty_value			= drug_frmobj.qty_value.value;	
	if(drug_frmobj.freq_nature.value=='P' ){
       dosage_by="A";
	   qty_value=drug_frmobj.absol_qty.value;
	}
	if(drug_frmobj.freq_nature.value=='O'){
		qty_value=drug_frmobj.qty_value.value;
	}
	var flag="N";
	var repeat_val="";
   	if(drug_frmobj.freq_nature.value!='O'&&drug_frmobj.freq_nature.value!='P'&&(drug_frmobj.split_dose_yn.disabled==true)){
	   flag="Y";
       qty_value	=	drug_frmobj.qty_value.value;
	   repeat_val	=   drug_frmobj.repeat_value.value; 

	}
	if(dosage_by=='A'){
         qty_value=drug_frmobj.absol_qty.value;
	}

    //parent.parent.parent.parent.f_detail.DispensingFrames.rows="8%,*,35%";

	parent.parent.parent.parent.window[2].document.getElementById('f_header').style.height="8vh";
	parent.parent.parent.parent.window[2].document.getElementById('f_ord_detail').style.height="60vh";
	parent.parent.parent.parent.window[2].document.getElementById('f_disp_detail').style.height="25vh";
	
	//parent.parent.parent.parent.f_detail.f_ord_detail.f_drug_detail.OrderDrugDetailsFrames.rows="*,20%,10%";
	parent.parent.window[1].document.getElementById('f_drug').style.height="65vh";
	parent.parent.window[1].document.getElementById('f_allocate').style.height="20vh";
	parent.parent.window[1].document.getElementById('f_button_1').style.height="10vh";
	
	//parent.parent.parent.parent.f_detail.f_ord_detail.f_drug_list.DrugListframes.rows="*,18%";
	parent.parent.window[0].document.getElementById('f_list').style.height="70vh";
	parent.parent.window[0].document.getElementById('f_button_2').style.height="18vh";
	
	//parent.parent.parent.parent.f_detail.f_disp_detail.dispframes.rows="*,19%";
	parent.parent.parent.window[2].document.getElementById('f_allocated_detail').style.height="70vh";
	parent.parent.parent.window[2].document.getElementById('f_button3').style.height="19vh";
	
	
	var mode=calling_mode;
    var qty_desc    = drug_frmobj.qty_desc.value;
	parent.parent.parent.parent.f_detail.f_ord_detail.f_drug_detail.f_allocate.location.href="../../ePH/jsp/DirectDispAllocateDetails.jsp?drug_code="+drug_code+"&srl_no="+srl_no+"&dosage_type="+dosage_by+"&qty_desc="+qty_desc+"&durn_value="+durn_value+"&end_date="+sys_time+"&called_from="+called_from+"&mode="+mode+"&split_dose_yn_val="+split_dose_yn_val+"&qty_value="+qty_value+"&flag="+flag+"&repeat_val="+repeat_val+"&called_when="+called_when+"&freq_nature="+drug_frmobj.freq_nature.value+"&interval_value="+drug_frmobj.interval_value.value;	
	parent.parent.parent.parent.f_detail.f_ord_detail.f_drug_detail.f_button_1.location.href="../../ePH/jsp/DirectDispButtons_1.jsp?&mode="+mode+"&display1_yn=Y"+"&display2_yn=Y";
}

function validateQty(obj,rec_no) {
	confirmflag=false;
	if(rec_no=='confirm'){
		rec_no="0";
		confirmflag=true;
	}		
	var valid							=	true;
	if(confirmflag)
		var formObj							=	parent.parent.parent.parent.f_detail.f_ord_detail.f_drug_detail.f_allocate.document.Directdispensingallocateform;
	else
		var formObj							=	document.Directdispensingallocateform;
	var arrObj							=	formObj.elements;
	var	pres_qty						=	parseInt(formObj.tot_qty.value);
	var	tot_qty							=	0;

	var issueUom_code_value				= formObj.issue_uom_select.value;
	var issueuomarray					= issueUom_code_value.split("_");
	var iss_qty_eq_val					= issueuomarray[1];
	var iss_qty_eq_val					= issueuomarray[1];
	var base_to_disp_uom_equl_val		= formObj.base_to_disp_uom_equl_val.value;
	var base_to_def_uom_equl_val		= formObj.base_to_def_uom_equl_val.value;
	var base_to_orig_def_uom_equl_val   = formObj.base_to_orig_def_uom_equl_val.value;	
	//var conv_factor                     = CalculateConversionfactor(base_to_orig_def_uom_equl_val,iss_qty_eq_val,base_to_disp_uom_equl_val);
	if(formObj.issuebyuom.value=="I")
		var conv_factor = CalculateConversionfactor(iss_qty_eq_val,iss_qty_eq_val,base_to_disp_uom_equl_val);
	else
		var conv_factor = CalculateConversionfactor(base_to_def_uom_equl_val,iss_qty_eq_val,base_to_disp_uom_equl_val);
	// var act_bms_qty_equl			    =  Math.ceil(parseInt(pres_qty)/parseInt(conv_factor));
	var alloc_equl					    =  "";
	var base_qty =   parseInt(pres_qty)*(parseInt(base_to_disp_uom_equl_val));
	var act_bms_qty_equl ="";
	if(parseInt(base_qty) >parseInt(conv_factor)){
		var val1=(parseInt(base_qty)%parseInt(conv_factor));  
		if(parseInt(val1)!=0){
			act_bms_qty_equl = parseInt(base_qty)+(parseInt(parseInt(conv_factor)-(parseInt(base_qty)%parseInt(conv_factor))));
		}
		else{
			act_bms_qty_equl =base_qty
		}
	}
	else{
		act_bms_qty_equl = conv_factor;	
	}
	for(i=0; i<arrObj.length; i++){
		if(arrObj[i].name.substr(0,13)!="issue_qty_old"){//condition addeed during variable uom enhancement
			if(arrObj[i].name.substr(0,10)=="issue_qty_"){
				issue_qty		=	arrObj[i].value;
				if(issue_qty!="")
					tot_qty		+=	parseInt(issue_qty);
				alloc_equl		=  parseInt(tot_qty)*parseInt(base_to_disp_uom_equl_val);
				if(parseInt(alloc_equl)>parseInt(act_bms_qty_equl)){
					if(tot_qty > pres_qty) {
						valid = false;
						alert(getMessage("PH_ISSUEQTY_GREATER_PRESQTY","PH"));
						obj.value="0";
						if(confirmflag)
							arrObj[i].select();								
						break;
					}
				}
			}
		}
	}
	/*  var issueUom_code_value				= formObj.issue_uom_select.value;
	var issueuomarray					= issueUom_code_value.split("_");
	var iss_qty_eq_val					= issueuomarray[1];
    var iss_qty_eq_val					= issueuomarray[1];
	var base_to_disp_uom_equl_val		= formObj.base_to_disp_uom_equl_val.value;
	var base_to_def_uom_equl_val		= formObj.base_to_def_uom_equl_val.value;
	var base_to_orig_def_uom_equl_val   = formObj.base_to_orig_def_uom_equl_val.value;	
    var conv_factor                     = CalculateConversionfactor(base_to_orig_def_uom_equl_val,iss_qty_eq_val,base_to_disp_uom_equl_val);

    if(tot_qty<=conv_factor){
			valid  =true;
	 }*/
	if(!confirmflag){
		if(valid){
			setQtyBsdOnIssueUOM(obj,rec_no);
		}
	}
	return valid;
}

function resetDrugdetails(){
	var hdr_formobj					=  parent.parent.parent.parent.f_detail.f_header.document.dir_disp_header_form;
	var drug_frmobj					=  parent.parent.parent.parent.f_detail.f_ord_detail.f_drug_detail.f_drug.document.prescription_detail_form;
	var start_date					=  hdr_formobj.sys_date.value;
	var priority					=  hdr_formobj.priority.value;
	var patient_id					=  hdr_formobj.patient_id.value;
	var encounter_id				=  hdr_formobj.encounter_id.value;
	var patient_class				=  hdr_formobj.patient_class.value;
	var drug_db_interface_yn		=  hdr_formobj.drug_db_interface_yn.value;
	var drug_db_dosecheck_yn		=  hdr_formobj.drug_db_dosecheck_yn.value;
	var drug_db_duptherapy_yn		=  hdr_formobj.drug_db_duptherapy_yn.value;
	var drug_db_interact_check_yn	=  hdr_formobj.drug_db_interact_check_yn.value;
	var drug_db_contraind_check_yn  =  hdr_formobj.drug_db_contraind_check_yn.value;
	var drug_db_allergy_check_yn	=  hdr_formobj.drug_db_allergy_check_yn.value;
	var drug_db_prod_id				=  hdr_formobj.Drug_db_prod_id.value;
	var drug_code					=  drug_frmobj.drug_code.value;
	var mode						= 'modify';
	var srl_no						=  drug_frmobj.srl_no.value;
	parent.parent.parent.parent.f_detail.f_ord_detail.f_drug_detail.f_drug.location.href="../../ePH/jsp/DirectDispDrugDetails.jsp?srl_no="+srl_no+"&drug_code="+drug_code+"&priority="+priority+"&start_date="+start_date+"&mode="+mode+"&patient_id="+patient_id+"&encounter_id="+encounter_id+"&patient_class="+patient_class+"&drug_db_interface_yn="+drug_db_interface_yn+"&drug_db_dosecheck_yn="+drug_db_dosecheck_yn+"&drug_db_duptherapy_yn="+drug_db_duptherapy_yn+"&drug_db_interact_check_yn="+drug_db_interact_check_yn+"&drug_db_contraind_check_yn="+drug_db_contraind_check_yn+"&drug_db_allergy_check_yn="+drug_db_allergy_check_yn+"&drug_db_prod_id="+drug_db_prod_id;
	parent.parent.parent.parent.f_detail.f_ord_detail.f_drug_detail.f_allocate.location.href="../../ePH/jsp/DirectDispAllocateDetails.jsp?mode=blank";
}

function clearDrugdetails(){
	var hdr_formobj		= parent.parent.parent.parent.f_detail.f_header.document.dir_disp_header_form;
	var start_date		= hdr_formobj.sys_date.value;
	var priority		= hdr_formobj.priority.value;
	var patient_id		= hdr_formobj.patient_id.value;
	var encounter_id	= hdr_formobj.encounter_id.value;
	var patient_class	= hdr_formobj.patient_class.value;
	var mode			= 'blank';	parent.parent.parent.parent.f_detail.f_ord_detail.f_drug_detail.f_drug.location.href="../../ePH/jsp/DirectDispDrugDetails.jsp?priority="+priority+"&start_date="+start_date+"&mode="+mode+"&patient_id="+patient_id+"&encounter_id="+encounter_id+"&patient_class="+patient_class;
	parent.parent.parent.parent.f_detail.f_ord_detail.f_drug_detail.f_allocate.location.href="../../ePH/jsp/DirectDispAllocateDetails.jsp?mode="+mode;
	parent.parent.parent.parent.f_detail.f_ord_detail.f_drug_detail.f_button_1.location.href="../../ePH/jsp/DirectDispButtons_1.jsp?mode="+mode+"&display1_yn=N"+"&display2_yn=N";
}

//For Calling Batch Search window
async function callBatchSearch() {
	var drug_frmobj		=parent.parent.parent.parent.f_detail.f_ord_detail.f_drug_detail.f_drug.document.prescription_detail_form;
	var item_code		= drug_frmobj.item_code.value;
	var store_code		= drug_frmobj.store_code.value;	
	var trade_code		= drug_frmobj.trade_code.value;	
	
	var includeZeroStockBatches = "N";
	var includeExpiredBatches	= "N";
	var includeSuspendedBatches = "N";
	var searchFunction			= "Y";
	var multipleSelect			= "Y";
	var end_date				= drug_frmobj.end_date.value;
	var retval=await callBatchSearchWindow(item_code,store_code,includeZeroStockBatches,includeExpiredBatches,includeSuspendedBatches,searchFunction,multipleSelect,end_date,trade_code);	
	if(retval!=undefined && retval!="") {	
		loadallocatedetail('stock');
	}
}

async function callBatchSearchWindow(item_code,store_code,includeZeroStockBatches,includeExpiredBatches,includeSuspendedBatches,searchFunction,multipleSelect,end_date,trade_code){
	var dialogHeight	= "95vh" ;
	var dialogWidth		= "75vw";
	var dialogTop		= "10" ;
	var dialogLeft		= "10" ;
	var center			= "0" ;
	var status			="no";
	var features	= "dialogHeight:" + dialogHeight +"; dialogLeft"+dialogLeft+ "; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop;
	var arguments	= "";
	retVal=await top.window.showModalDialog("../../eST/jsp/BatchSearchFrame.jsp?item_code="+item_code+"&store_code="+store_code+"&includeZeroStockBatches="+includeZeroStockBatches+"&includeExpiredBatches="+includeExpiredBatches+"&includeSuspendedBatches="+includeSuspendedBatches+"&searchFunction="+searchFunction+"&multipleSelect="+multipleSelect+"&trade_code="+trade_code,arguments,features);
	return retVal;
}


//function will be called on click of confirm button
function addDrug(oper_mode){	
	refresh_screen				= true;
	var bean_id					= "";
	var patient_id				= "";
	var encounter_id			= "";
	var patient_class			= "";
	var order_date_time			= "";
	var frmObj					= parent.parent.parent.parent.f_detail.f_ord_detail.f_drug_detail.f_drug.document.prescription_detail_form;
	assignDurnTypeList(frmObj.DurnDescDetails.value);
	var hdr_formobj				= parent.parent.parent.parent.f_detail.f_header.document.dir_disp_header_form;
	var adr_count				= hdr_formobj.adr_count.value;
	var man_rem_on_prn_freq_yn	=	hdr_formobj.man_rem_on_prn_freq_yn.value;
	var default_freq_not_found = frmObj.default_freq_not_found.value; // added for GHL-CRF-0508
	//added for GHL-CRF-0508 start
	if(default_freq_not_found){
	var freq_code	            = frmObj.frequency.value;
	}
	//Added for IN:073485 start
	frmObj.override_rem_mand.value='N';
	drug_code =frmObj.drug_code.value;
	srl_no = frmObj.srl_no.value;
	var override_select_appl=frmObj.override_select_appl.value
	if(override_select_appl=='Y' && oper_mode=="modify"){
		checkMandRemarks(drug_code,srl_no,frmObj);
	}
	var validate_overide_on_confirm_yn=frmObj.validate_overide_on_confirm_yn.value;//Added for IN:069887 
	if(frmObj.override_rem_mand !=undefined && frmObj.override_rem_mand.value=='Y'){
		// Modified for IN:069887 START
		if(validate_overide_on_confirm_yn=='Y'){
			validateOnConfirm();
		}
		else{
			alert(getMessage("OVERRIDE_REASON_NOT_BLANK", "PH"));
		}
		// Modified for IN:069887 END
		return false;
	}
	//Added for IN:073485 end
	//added for GHL-CRF-0508 end
	if(oper_mode=="modify"||oper_mode=="taper"||oper_mode=="delete"){
		patient_id		= frmObj.patient_id.value;
		encounter_id	= frmObj.encounter_id.value;
		patient_class	= frmObj.patient_class.value;
		order_date_time	= hdr_formobj.sys_date.value;
	}
	//added for GHL-CRF-0508 start
	if(default_freq_not_found){
	if(freq_code==""){
		alert(getMessage("SELECT_FREQUENCY", "PH"));
		frmObj.freq_code.focus();
		 return true;
	   }
	}
    //added for GHL-CRF-0508 end
	if(oper_mode=="modify"){
		intr_restric_trn = frmObj.intr_restric_trn.value; // added for FD-RUT-CRF-0066.1 [IN036975] -Start
		if(intr_restric_trn == 'Y' ){
			drug_code =frmObj.drug_code.value;
			srl_no = frmObj.srl_no.value;
			alertIntr(drug_code, srl_no, patient_id, encounter_id, intr_restric_trn)
			return;
		} // added for FD-RUT-CRF-0066.1 [IN036975] - End

		var weight_rec_appl_age_group_check_flag = frmObj.weight_rec_appl_age_group_check_flag.value;
		var wt_mand_yn = frmObj.wt_mand_yn.value;
		var ht_mand_yn = frmObj.ht_mand_yn.value;
		if(wt_mand_yn=='Y')
			hdr_formobj.wt_mand_yn.value="Y";
		if(ht_mand_yn=='Y')
			hdr_formobj.ht_mand_yn.value="Y";
			hdr_formobj.weight_rec_appl_age_group_check_flag.value=weight_rec_appl_age_group_check_flag;
		if(parent.parent.parent.parent.f_detail.f_ord_detail.f_drug_list.f_list.document.prescription_form.recomm_yn_flag.value== "true"  || weight_rec_appl_age_group_check_flag=='Y'){
			if((hdr_formobj.height.value=="" || parseFloat(hdr_formobj.height.value) == 0) &&(hdr_formobj.weight.value==""  || parseFloat(hdr_formobj.weight.value) == 0)) {	
				alert(getMessage("PAT_HEIGHT_WEIGHT_BLANK","PH"));
				hdr_formobj.height.disabled=false;
				hdr_formobj.height.focus();
				return false;
			}
		}
		//added for Bru-HIMS-CRF-079 IN[029945] - start
		if(wt_mand_yn == 'Y' && (hdr_formobj.weight.value=="" || parseFloat(hdr_formobj.weight.value) == 0)){
			hdr_formobj.weight.disabled=false;
			hdr_formobj.weight.focus();
			alert(getMessage("PAT_WEIGHT_BLANK","PH"));
			return false;
		}
		else if(ht_mand_yn == 'Y' && (hdr_formobj.height.value=="" || parseFloat(hdr_formobj.height.value) == 0)){
			hdr_formobj.height.disabled=false;
			hdr_formobj.height.focus();
			alert(getMessage("PAT_HEIGHT_BLANK","PH"));
			return false;
		}

		if(frmObj.prn_remarks !=null || frmObj.prn_remarks!=undefined ){
			if(frmObj.prn_remarks.style.visibility=="visible" && frmObj.prn_remarks_flag.value == "false" && man_rem_on_prn_freq_yn=="Y"){
				alert(getMessage("PRN_REMARKS_CANNOT_BE_BLANK","PH"));
				return false;
			}
		}
	}		
	if(oper_mode!="delete"){
		var route_code		 = frmObj.route_code.value;
		if(route_code == undefined || route_code ==''){
			frmObj.route_code.focus();
			msg = getMessage("CAN_NOT_BE_BLANK","Common");
			msg = msg.replace('$', getLabel("Common.Route.label","common"));
			alert(msg);
			return false;
		}
	}

	//=====IN013482==if allocated Quantity is greater than available quantity in a batch it will show a messgae and return false
	var frmAllocate=parent.parent.parent.parent.f_detail.f_ord_detail.f_drug_detail.f_allocate.document.Directdispensingallocateform;
	var tot_records=frmAllocate.tot_rec.value;
	lessStockFlag=false;
	for(numIndex=0;numIndex<=tot_records;numIndex++){
		if(eval("frmAllocate.issue_qty_"+numIndex)!=null){
			var allocQty=eval("frmAllocate.issue_qty_"+numIndex);
			var bat_avl_qty=eval("frmAllocate.batch_avl_qty_"+numIndex);
			var checkbox=eval("frmAllocate.select_"+numIndex);
			var issue_uom_lbl=eval("frmAllocate.issue_uom_lbl_"+numIndex);
			var base_to_disp_uom_equl_val = frmAllocate.base_to_disp_uom_equl_val.value;
			base_to_disp_uom_equl_val=parseFloat(base_to_disp_uom_equl_val);
			if(allocQty.value!=""&&bat_avl_qty.value!=""){
				var allocQty1=parseInt(allocQty.value)* base_to_disp_uom_equl_val;
				var bat_avl_qty1=parseInt(bat_avl_qty.value);
				if(allocQty1>bat_avl_qty1){
					lessStockFlag=true;
					alert(getMessage("PH_ALLOC_QTY_LESS_AVAIL_QTY","PH")+" AT ROW "+(numIndex+1));
					if(base_to_disp_uom_equl_val>bat_avl_qty1){
						checkbox.checked=false;
						checkbox.disabled=true;
						allocQty.value='';
						allocQty.disabled=true;
						issue_uom_lbl.style.visibility="hidden";
					}
					else{
						allocQty.value='0';
						//allocQty.select();
					}
				}
			}
		}
	}
	if(lessStockFlag){
		return false;
	}
	if(frmAllocate.issue_qty_0!=null){
		if(!validateQty(frmAllocate.issue_qty_0,'confirm')){
			return false;
		}
	}

	//==end IN013482==
	/*================================================================variable uom=================================================*/
	var valid						= true;
	var formObj						= parent.parent.parent.parent.f_detail.f_ord_detail.f_drug_detail.f_allocate.document.Directdispensingallocateform;
	var arrObj						= formObj.elements;
	var	pres_qty					= parseInt(formObj.tot_qty.value);
	var	tot_qty						= 0;
	if(oper_mode!="delete"){
		var issueUom_code_value			= formObj.issue_uom_select.value;
		var issueuomarray				= issueUom_code_value.split("_");
		var iss_qty_eq_val				= issueuomarray[1];
		var iss_qty_eq_val				= issueuomarray[1];
	}
	var base_to_disp_uom_equl_val	= formObj.base_to_disp_uom_equl_val.value;
	var base_to_def_uom_equl_val    = formObj.base_to_def_uom_equl_val.value;
	var base_to_orig_def_uom_equl_val   = formObj.base_to_orig_def_uom_equl_val.value;	

	var conv_factor                 =  CalculateConversionfactor(base_to_orig_def_uom_equl_val,iss_qty_eq_val,base_to_disp_uom_equl_val);

	var alloc_equl					=  "";
	var base_qty					=  parseInt(pres_qty)*(parseInt(base_to_disp_uom_equl_val));
	var act_bms_qty_equl			=  "";
	if(parseInt(base_qty) >parseInt(conv_factor)){
	   var val1=(parseInt(base_qty)%parseInt(conv_factor));  
	   if(parseInt(val1)!=0){
			act_bms_qty_equl = parseInt(base_qty)+(parseInt(parseInt(conv_factor)-(parseInt(base_qty)%parseInt(conv_factor))));
	   }
	   else{
			 act_bms_qty_equl =base_qty
	   }
	}
	else{
	  act_bms_qty_equl = conv_factor;	
	}

	for(i=0; i<arrObj.length; i++){
		if(arrObj[i].name.substr(0,13)!="issue_qty_old"){//condition addeed during variable uom enhancement
			if(arrObj[i].name.substr(0,10)=="issue_qty_"){
				issue_qty		=	arrObj[i].value;
				if(issue_qty!="")
				tot_qty		+=	parseInt(issue_qty);
				alloc_equl		=  parseInt(tot_qty)*parseInt(base_to_disp_uom_equl_val);

				if(parseInt(alloc_equl)>parseInt(act_bms_qty_equl)){
					if(tot_qty > pres_qty) {
						valid = false;							
						break;
					}
				}
			}
		}
	}
	if(tot_qty<=0 && oper_mode!="delete"){
		alert(getMessage("ALLOC_QTY_CANNOT_ZERO","PH"));
		return false;
	}
	if(tot_qty<=conv_factor){
		valid  =true;   
	}
/*=============================================================================================================================*/
	if(valid){
		if(chkMandatory(oper_mode)){
			if(chkQuantity()){
				if(submit(oper_mode)){
					if(checkForDuplicate()){
						if(oper_mode=="taper"){
							if(refresh_screen){
								//parent.parent.parent.parent.f_detail.DispensingFrames.rows="8%,*,35%";
								parent.parent.parent.parent.window[2].document.getElementById('f_header').style.height="8vh";
								parent.parent.parent.parent.window[2].document.getElementById('f_ord_detail').style.height="60vh";
								parent.parent.parent.parent.window[2].document.getElementById('f_disp_detail').style.height="25vh";
								
								//parent.parent.parent.parent.f_detail.f_ord_detail.f_drug_detail.OrderDrugDetailsFrames.rows="*,0%,0%";
								parent.parent.window[1].document.getElementById('f_drug').style.height="85vh";
								parent.parent.window[1].document.getElementById('f_allocate').style.height="0vh";
								parent.parent.window[1].document.getElementById('f_button_1').style.height="0vh";
								
								//parent.parent.parent.parent.f_detail.f_ord_detail.f_drug_list.DrugListframes.rows="*,21%";
								parent.parent.window[0].document.getElementById('f_list').style.height="70vh";
								parent.parent.window[0].document.getElementById('f_button_2').style.height="18vh";
								
								//parent.parent.parent.parent.f_detail.f_disp_detail.dispframes.rows="*,14%";
								parent.parent.parent.window[2].document.getElementById('f_allocated_detail').style.height="70vh";
								parent.parent.parent.window[2].document.getElementById('f_button3').style.height="19vh";
								parent.parent.parent.parent.f_detail.f_ord_detail.f_drug_list.f_list.location.href="../../ePH/jsp/DirectDispDrugList.jsp?&adr_count="+adr_count;			    	
								
								var mode="blank";
								
								parent.parent.parent.parent.f_detail.f_ord_detail.f_drug_detail.f_drug.location.href="../../ePH/jsp/DirectDispDrugDetails.jsp?mode="+mode;				
								parent.parent.parent.parent.f_detail.f_ord_detail.f_drug_detail.f_button_1.location.href="../../ePH/jsp/DirectDispButtons_1.jsp?&mode="+mode+"&display1_yn=N"+"&display2_yn=N";
								calldispframes(oper_mode);
							}
						}
						else{
							//parent.parent.parent.parent.f_detail.DispensingFrames.rows="8%,*,35%";
							parent.parent.parent.parent.window[2].document.getElementById('f_header').style.height="8vh";
							parent.parent.parent.parent.window[2].document.getElementById('f_ord_detail').style.height="60vh";
							parent.parent.parent.parent.window[2].document.getElementById('f_disp_detail').style.height="25vh";
							
							//parent.parent.parent.parent.f_detail.f_ord_detail.f_drug_detail.OrderDrugDetailsFrames.rows="*,0%,0%";
							parent.parent.window[1].document.getElementById('f_drug').style.height="85vh";
							parent.parent.window[1].document.getElementById('f_allocate').style.height="0vh";
							parent.parent.window[1].document.getElementById('f_button_1').style.height="0vh";
							
							//parent.parent.parent.parent.f_detail.f_ord_detail.f_drug_list.DrugListframes.rows="*,21%";
							parent.parent.window[0].document.getElementById('f_list').style.height="70vh";
							parent.parent.window[0].document.getElementById('f_button_2').style.height="18vh";
							
							//parent.parent.parent.parent.f_detail.f_disp_detail.dispframes.rows="*,14%";
							parent.parent.parent.window[2].document.getElementById('f_allocated_detail').style.height="70vh";
							parent.parent.parent.window[2].document.getElementById('f_button3').style.height="19vh";
							parent.parent.parent.parent.f_detail.f_ord_detail.f_drug_list.f_list.location.href="../../ePH/jsp/DirectDispDrugList.jsp?&adr_count="+adr_count;		    	
							var mode="blank";
							parent.parent.parent.parent.f_detail.f_ord_detail.f_drug_detail.f_drug.location.href="../../ePH/jsp/DirectDispDrugDetails.jsp?mode="+mode;	
							parent.parent.parent.parent.f_detail.f_ord_detail.f_drug_detail.f_button_1.location.href="../../ePH/jsp/DirectDispButtons_1.jsp?&mode="+mode+"&display1_yn=N"+"&display2_yn=N";
							calldispframes(oper_mode);
						}
					}
				}
			}
		}
		else{
			alert(getMessage("PH_MANDATORY","PH"));
		}
	}
	else{
		alert(getMessage("PH_ISSUEQTY_GREATER_PRESQTY","PH"));
	}
	var formobj							  =	 hdr_formobj;
	formobj.sys_date.disabled			  =  true;
	parent.parent.parent.parent.f_detail.f_header.document.getElementById('Calendar').disabled=true;
	formobj.priority.disabled			  =	true;
	formobj.height.disabled				  =	true;
	formobj.weight.disabled				  =	true;
	formobj.take_home_medication.disabled =	true;
}

function chkMandatory(oper_mode){
	var frmObj		= parent.parent.parent.parent.f_detail.f_ord_detail.f_drug_detail.f_drug.document.prescription_detail_form;
	var chk_man		= false;
	var qty_value	= frmObj.qty_value.value;
	var qty_desc	= frmObj.qty_desc.value;
	var freq_code	= frmObj.frequency.value;
	var durn_value	= frmObj.durn_value.value;
	var durn_desc	= frmObj.durn_value.value;
	var chk_split	= "";

	if(frmObj.sch_over_yn.value=="N"){
		chk_split = "Y";
	}else{
		chk_split = "Y";
	}

	if( qty_value!="" && qty_desc!="" && freq_code!="" && durn_value!="" &&  durn_desc!="" && chk_split!=""){
			chk_man = true;
	}else{
			chk_man = false;
	}

	if(oper_mode=='delete'){
			chk_man = true;
	}

return chk_man;
}

function chkQuantity(){
	    var drug_frmObj		= parent.parent.parent.parent.f_detail.f_ord_detail.f_drug_detail.f_drug.document.prescription_detail_form;
		var allow_refill	= drug_frmObj.allow_refill.value;
		var no_refill		= drug_frmObj.no_refill.value;
		var qty				= drug_frmObj.qty_value.value;
		var qty_desc		= drug_frmObj.qty_desc.value;
		var durn_desc		= drug_frmObj.durn_desc.value;
		var repeat_durn_type= drug_frmObj.repeat_durn_type.value;
		var strength_uom_code=drug_frmObj.strength_uom.value;
		var freq_value		= drug_frmObj.freq_value.value;
		var freq			= drug_frmObj.frequency.value;
		var durn_val		= drug_frmObj.durn_value.value;
		var duration		= "";
		var split_dose_yn	= drug_frmObj.split_dose_yn.disabled;


		if(durn_desc=='H' || durn_desc=='M'){
			duration = drug_frmObj.calcualted_durn_value.value;
		}else{
			if(freq_value!='0'){
				duration = drug_frmObj.durn_value.value;
			}else{
			    duration = drug_frmObj.calcualted_durn_value.value;
			}
		}


	var interval_value	= parseInt(drug_frmObj.interval_value.value);
	var repeat_value	= parseInt(drug_frmObj.repeat_value.value);

	if(drug_frmObj.dosage.value=='Q'){
		if(drug_frmObj.strength_value!=""){
			if(drug_frmObj.pres_base_uom.value!=drug_frmObj.qty_desc.value){

				var formobj=drug_frmObj;
				var fldString="  strength_uom=\""+ drug_frmObj.strength_uom.value + "\" ";
				    fldString += " qty_uom=\""+ drug_frmObj.qty_desc.value + "\" ";
				var xmlStr=formXMLString(formobj,fldString);
				fieldValidation(xmlStr,"calculateQuantity");

				if(drug_frmObj.conv_factor.value!=""){
					var val_1=parseInt(drug_frmObj.conv_factor.value);
					if(val_1 != ""){
						qty  = qty*parseInt(repeat_value)*parseInt(duration);
						qty  = (qty/val_1)
					}else{
						alert(getMessage("PH_NO_EQUVL","PH"));
					}
				}
		}
	}

		qty=qty*parseInt(repeat_value)*parseInt(duration);

		var val_1=parseInt(drug_frmObj.strength_per_pres_uom.value);
		var val_2=parseInt(drug_frmObj.strength_per_value_pres_uom.value);
		var strength_value=parseInt(drug_frmObj.strength_value.value);
		var tot_strength="";
		var tot_strength_uom="";
		if(strength_value>0){
			var tot_strength=( ( (val_1/val_2)) * qty );
			tot_strength_uom=strength_uom_code;
		}else{
				tot_strength="0";
				tot_strength_uom="";
		}

		var dispensed_qty	= parseInt(qty);
		var bms_qty			= parseInt(qty);
		var bms_strength	= tot_strength;
		var strength_value	= strength_value;
		var strength_uom	= tot_strength_uom;
		var pres_qty_value	= drug_frmObj.qty_value.value;
		var pres_qty_uom	= drug_frmObj.qty_desc.value;
		drug_frmObj.in_dispensed_qty.value	= dispensed_qty;
		drug_frmObj.in_dispensed_uom.value	= drug_frmObj.qty_desc.value;
		drug_frmObj.in_bms_qty.value		= bms_qty;
		drug_frmObj.in_strength_value.value = strength_value;
		drug_frmObj.in_strength_uom.value   = strength_uom;
		drug_frmObj.in_pres_qty_value.value = pres_qty_value;
		drug_frmObj.in_pres_qty_uom.value   = pres_qty_uom;
		drug_frmObj.in_total_strength.value = tot_strength;
		drug_frmObj.in_total_strength_uom.value=tot_strength_uom;
	}

	if(drug_frmObj.dosage.value=='S'){
		var val_1 = parseInt(drug_frmObj.strength_per_pres_uom.value);
		var val_2 = parseInt(drug_frmObj.strength_per_value_pres_uom.value);
		var val_3 = parseInt(drug_frmObj.strength_value.value);
		var strength_value=parseInt(drug_frmObj.strength_value.value);
		var val_4 = qty;

		if(split_dose_yn=="true"){
			val_3 = parseInt(qty)*parseInt(repeat_value)*parseInt(duration);
		}else{
			val_3 = parseInt(qty)*parseInt(duration);
		}
		qty=( ( (val_2/val_1)) * val_3 );
		var tot_strength		= "";
		var tot_strength_uom	= "";
		tot_strength			= val_3;
		tot_strength_uom		= strength_uom_code;
		var dispensed_qty		= parseInt(qty);
		var bms_qty				= parseInt(qty);
		var bms_strength		= tot_strength;
		var strength_value		= strength_value;
		var strength_uom		= tot_strength_uom;
		var pres_qty_value		= drug_frmObj.qty_value.value;
		var pres_qty_uom		= drug_frmObj.qty_desc.value;
					 
		drug_frmObj.in_dispensed_qty.value	= dispensed_qty;
		drug_frmObj.in_dispensed_uom.value  = drug_frmObj.qty_desc.value;
		drug_frmObj.in_bms_qty.value		= bms_qty;
		drug_frmObj.in_strength_value.value = strength_value;
		drug_frmObj.in_strength_uom.value	= strength_uom;
		drug_frmObj.in_pres_qty_value.value = pres_qty_value;
		drug_frmObj.in_pres_qty_uom.value   = pres_qty_uom;
		drug_frmObj.in_total_strength.value = tot_strength;
		drug_frmObj.in_total_strength_uom.value=tot_strength_uom;
	}

	if(drug_frmObj.dosage.value=='A'){
		var tot_strength="0";
		var tot_strength_uom="";
		if(split_dose_yn=="true"){
			qty=qty;
		}else{
			qty=qty;
		}

		var pres_qty_value	= drug_frmObj.qty_value.value;
		var pres_qty_uom	= drug_frmObj.qty_desc.value;
		var strength_value  = parseInt(drug_frmObj.strength_value.value);
		var strength_uom    = strength_uom_code;
		var dispensed_qty   = parseInt(qty);
		var bms_qty         = parseInt(qty);
		var bms_strength    = tot_strength;
		drug_frmObj.in_dispensed_qty.value = dispensed_qty;
        drug_frmObj.in_dispensed_uom.value = drug_frmObj.qty_desc.value;
		drug_frmObj.in_bms_qty.value	   = bms_qty;
		drug_frmObj.in_strength_value.value= strength_value;
		drug_frmObj.in_strength_uom.value  = strength_uom;
		drug_frmObj.in_pres_qty_value.value= pres_qty_value;
		drug_frmObj.in_pres_qty_uom.value  = pres_qty_uom;
		drug_frmObj.in_total_strength.value= tot_strength;
		drug_frmObj.in_total_strength_uom.value = tot_strength_uom;

			return true;
		}else{
			return true;
		}

}



function formValidation(oper_mode,frmObj){
	return_val	=	true;
	var xmlStr   ="";
	var arrObj = frmObj.elements;
    var frmObjs = new Array()
    if(frmObj.name == null)
        frmObjs = frmObj ;
    else frmObjs[0] = frmObj ;

	for(var frmCount=0; frmCount<frmObjs.length; frmCount++) {
        frmObj = frmObjs[frmCount]
        var arrObj = frmObj.elements;

        for(var i=0;i<arrObj.length;i++) {
            var val = "" ;
            if(arrObj[i].type == "checkbox") {
                if(arrObj[i].checked){
                    val = "Y";
				}else{
					val ="N";
				}
                if(arrObj[i].name != null && arrObj[i].name != "")
                    xmlStr+= arrObj[i].name+"=\"" + checkSpl(val) + "\" " ;
            }
            else if(arrObj[i].type == "radio") {
                if(arrObj[i].checked) {
                    val = arrObj[i].value;
                    if(arrObj[i].name != null && arrObj[i].name != "")
                        xmlStr+= arrObj[i].name+"=\"" + checkSpl(val) + "\" " ;
                }
            }
            else if(arrObj[i].type == "select-multiple" ) {
                for(var j=0; j<arrObj[i].options.length; j++)
                {
                    if(arrObj[i].options[j].selected)
                        val+=arrObj[i].options[j].value +"~"
                }
                val= val.substring(0,val.lastIndexOf('~'))
                if(arrObj[i].name != null && arrObj[i].name != "")
                    xmlStr+= arrObj[i].name+"=\"" + checkSpl(val) + "\" " ;
				

            }
            else {
                val = arrObj[i].value;
                if(arrObj[i].name != null && arrObj[i].name != "")
                    xmlStr+= arrObj[i].name+"=\"" + checkSpl(val) + "\" " ;
            }
        }
    }
	var route_desc	 = frmObj.route_code.options[frmObj.route_code.selectedIndex].text
	var freq_desc	 = frmObj.frequency.options[frmObj.frequency.selectedIndex].text
	var or_qty_desc  = frmObj.qty_desc.options[frmObj.qty_desc.selectedIndex].text
	var or_durn_desc = frmObj.durn_desc.options[frmObj.durn_desc.selectedIndex].text;
	var patient_id	 = frmObj.patient_id.value;
	var encounter_id = frmObj.encounter_id.value;
	var spl_man_yn="";
	if(frmObj.split_dose_yn.disabled==true){
		spl_man_yn="N";
	}
	else{
		spl_man_yn="Y";
	}

	xmlStr += " oper_mode=\""+ oper_mode + "\" ";
	xmlStr += "route_desc=\""+ route_desc + "\" ";
	xmlStr += "or_qty_desc=\""+ or_qty_desc + "\" ";
	xmlStr += "or_durn_desc=\""+ or_durn_desc + "\" ";
	xmlStr += "freq_desc=\""+ encodeURIComponent(freq_desc) + "\" ";
	xmlStr += "spl_man_yn=\""+ spl_man_yn + "\" ";
	return xmlStr;
	}

function checkForDuplicate(){
	var drug_frmObj		= parent.parent.parent.parent.f_detail.f_ord_detail.f_drug_detail.f_drug.document.prescription_detail_form;
	var current_rx		=	drug_frmObj.current_rx.value;
	var allow_duplicate	=	drug_frmObj.allow_duplicate.value;
	var patient_class	=	drug_frmObj.patient_class.value;
	var take_home		=	drug_frmObj.take_home.value;
	var frequency		=	drug_frmObj.frequency.value;
    var freq_nature		=	drug_frmObj.freq_nature.value;
	var result			=	true;
	if(current_rx=="Y" && allow_duplicate=="N" && (patient_class=="IP" || parseInt(take_home)>0) && freq_nature!="O" ) {
		result		=	false;
	}
	return result;
}

function alertNoAvailStock(available_stock,uom){
	alert(getMessage("PH_NO_STOCK_AVAIL_DRUG","PH"));
	return_val=false;
}

function alertParentRecord(oper_mode){
	if(oper_mode=="delete")
		alert(getMessage("PH_PARENT_REC_1","PH"));
	else
		alert(getMessage("PH_PARENT_REC_2","PH"));
}


function calldispframes(oper_mode){
	parent.parent.parent.parent.f_detail.f_disp_detail.f_allocated_detail.location.href="../../ePH/jsp/DirectDispensingDetails.jsp?oper_mode="+oper_mode;
	parent.parent.parent.parent.f_detail.f_disp_detail.f_button3.location.href="../../ePH/jsp/DirectDispButtons_3.jsp?";
}

function submit(oper_mode){
	return_val			=	true;
	var drug_frmObj			= parent.parent.parent.parent.f_detail.f_ord_detail.f_drug_detail.f_drug.document.prescription_detail_form;
	var alloc_formobj		= parent.parent.parent.parent.f_detail.f_ord_detail.f_drug_detail.f_allocate.document.Directdispensingallocateform;
	var tmp_durn_value=drug_frmObj.tmp_durn_value.value;
	var xmlStr ="<root><SEARCH ";	 
	var xmlStr_1 = formValidation(oper_mode,drug_frmObj); //DrugForm
	var xmlStr_2 = buildXMLString(alloc_formobj); //Allocate Details	 
	xmlStr+=xmlStr_1+xmlStr_2;	 
	xmlStr +=" /></root>";		
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest() ;
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST","DirectDispValidate.jsp?func_mode=InsertRec&tmp_durn_value="+tmp_durn_value,false);
	xmlHttp.send(xmlDoc);
	responseText=xmlHttp.responseText ;
	if(oper_mode=="delete" || oper_mode=="modify" || oper_mode=="taper" || oper_mode=="tapered"){			
		eval(responseText);
	}	
	return return_val;
}

function alertNoTaper(error){
	refresh_screen=false;
	if(error=="greater")
		alert(getMessage("PH_NO_TAPER_2","PH"));
	else if(error=="lesser") 
		alert(getMessage("PH_NO_TAPER_3","PH"));
	else
		alert(getMessage("PH_NO_TAPER_1","PH"));
	return false;
}

function buildXMLString(frmObj) {
	var xmlStr = "";
	var arrObj = frmObj.elements;
	var frmObjs = new Array()
	if(frmObj.name == null)
		frmObjs = frmObj;
	else frmObjs[0] = frmObj;

	for(var frmCount=0; frmCount<frmObjs.length; frmCount++) {
		frmObj = frmObjs[frmCount]
		var arrObj = frmObj.elements;

		for(var i=0;i<arrObj.length;i++) {
			var val = "";
			if(arrObj[i].type == "checkbox") {
				if(arrObj[i].checked) {
					val = "Y";
				}
				else {
					val ="N";
				}
				if(arrObj[i].name != null && arrObj[i].name != "")
					xmlStr+= arrObj[i].name+"=\"" + checkSpl(val) + "\" ";
			}
			else if(arrObj[i].type == "radio") {
				if(arrObj[i].checked) {
					val = arrObj[i].value;
					if(arrObj[i].name != null && arrObj[i].name != "")
						xmlStr+= arrObj[i].name+"=\"" + checkSpl(val) + "\" ";
				}
			}
			else if(arrObj[i].type == "select-multiple") {
				for(var j=0; j<arrObj[i].options.length; j++) {
					if(arrObj[i].options[j].selected)
						val+=arrObj[i].options[j].value +"~"
				}
				val= val.substringing(0,val.lastIndexOf('~'))
				if(arrObj[i].name != null && arrObj[i].name != "")
					xmlStr+= arrObj[i].name+"=\"" + checkSpl(val) + "\" ";
			}
			else {
				val = arrObj[i].value;
				if(arrObj[i].name != null && arrObj[i].name != "")
					xmlStr+= arrObj[i].name+"=\"" + checkSpl(val) + "\" ";
			}
		}
	}
	return xmlStr;
}

async function callEditDetails(obj,drug_code,recno,chk,srl_no){	
	var dialogHeight	= "95vh" ;  //changed 20 to 95 for RUT-CRF-0067
	var dialogWidth		= "75vw";  //changed 50 to 55 for RUT-CRF-0067
	var dialogTop		= "10" ; // changed for RUT-CRF-0067
	var dialogLeft		= "10" ; //50 to 250 for RUT-CRF-0067
	var center			= "1" ;
	var status			="no";
	var features	= "dialogHeight:" + dialogHeight +"; dialogLeft"+dialogLeft+ "; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop;
	var arguments	= "";
	if(chk=="D" )
		retVal = await top.window.showModalDialog("../../ePH/jsp/DirectDispEditLabelFrames.jsp?chk="+chk+"&recno="+recno+"&drug_code="+drug_code+"&srl_no="+srl_no,arguments,features);
	if(retVal=="OK") {
		obj.style.color='green';
	}
	else {
		obj.style.color='blue';
	}
}

function validateEditDetailsReset(frmObj){
	frmObj.reset();
}

function validateEditDetails(frmObj) {
	frmObj.submit();
	if(returnValue=="OK") {
		obj.style.color='green';
	}
	else {
		frmObj.style.color='blue';
	}
}

function validateEditDetails(frmObj,calledFrom) {

	frmObj.calledFrom.value = calledFrom;
    //Code Added For RUT-CRF-0067 Start
	var noOfDrugs = frmObj.totalRecordds.value;
	for(var i=0;i<noOfDrugs;i++){
		try{
			var noOfPrint = frmObj.document.getElementById('noOfPrints'+i).value;
			var allocQty = frmObj.document.getElementById('allocQty'+i).value;
			if(noOfPrint == "" || parseInt(noOfPrint)==0){
			  alert(getMessage("PH_NO_OF_PRINT_CANNOT_BALNK","PH"));
			  frmObj.document.getElementById('noOfPrints'+i).focus();
			  return false;
			}
			else{
				if(parseInt(noOfPrint)> parseInt(allocQty) && parseInt(noOfPrint) <1000){
					var contiueYN = confirm(getMessage("PH_NO_OF_PRINTS_GREATER_THAN_DISP_QTY", "PH")); 
					if(!contiueYN){
						obj.focus();
						return false;
					}
				}
				if (parseInt(noOfPrint) >999){
					if(parseInt(allocQty) >999){
						var contiueYN = confirm(getMessage("PH_NO_OF_PRINT_MORE_THAN_1000", "PH")); 
						if(!contiueYN){
							obj.focus();
							return false;
						}
					}
					else{
						alert(getMessage("PH_NO_OF_PRINT_MORE_THAN_1000", "PH"));
						obj.focus();
						return false;
					}
				}  
			}
		}
		catch(e){}
	}//Code Added For RUT-CRF-0067 End 	 
	/*var chkTabBMS = parent.printSelectFrame.document.getElementById("Bal_Med_table");//Code Added For FD-Bru-HIMS-CRF-074 & FD-Bru-HIMS-CRF-075 Start
	alert("First Alert");
	if(chkTabBMS.style.visibility=="visible"){
	 var lang = parent.printSelectFrame.document.DispMedicationPrintDialog.select_loc_lang.value;
	    if(lang =="---Select---" || lang==""){
			alert(getMessage("PH_SELECT_LANGUAGE", "PH"));
			parent.printSelectFrame.document.DispMedicationPrintDialog.select_loc_lang.focus();
			return false;
		}
	}else{
	if(parent.printSelectFrame.document.DispMedicationPrintDialog.select_loc_lang!=undefined){
	if( parent.printSelectFrame.document.DispMedicationPrintDialog.select_loc_lang.value==null||parent.printSelectFrame.document.DispMedicationPrintDialog.select_loc_lang.value==undefined  ){
	        parent.printSelectFrame.document.DispMedicationPrintDialog.select_loc_lang.value =parent.printSelectFrame.document.DispMedicationPrintDialog.defaultLanguage.value;
		}
		}
		else{
			if(parent.printSelectFrame.document.DispMedicationPrintDialog.select_loc_lang!=undefined){
       var lang = parent.printSelectFrame.document.DispMedicationPrintDialog.select_loc_lang.value;
	  	    if(lang =="---Select---" || lang==""){
			alert(getMessage("PH_SELECT_LANGUAGE", "PH"));
			parent.printSelectFrame.document.DispMedicationPrintDialog.select_loc_lang.focus();
			return false;
		}
		}
	}
	} *///Code Added For FD-Bru-HIMS-CRF-074 & FD-Bru-HIMS-CRF-075 End  

	var computeSetOrder = "false";
	if(parent.printSelectFrame != undefined && parent.printSelectFrame.document.DispMedicationPrintDialog != undefined){

		if(parent.printSelectFrame.document.DispMedicationPrintDialog.enable_tab != undefined && parent.printSelectFrame.document.DispMedicationPrintDialog.enable_tab.value == 'Y'){
			computeSetOrder = "true";
		}
	}
	frmObj.ComputeSetOrder.value = computeSetOrder;
	frmObj.submit();
	if(parent.parent.parent.parent.window[2].returnValue=="OK") {
		changeColor(frmObj);
	} 
	else {
		frmObj.style.color='blue';
	}
}

async function callFillingRemarks(obj,drug_code,recno,chk,srl_no){	
	
	var dialogHeight	= "30vh" ;
	var dialogWidth		= "30vw";
	var dialogTop		= "10" ;
	var dialogLeft		= "10" ;
	var center			= "1" ;
	var status			="no";
	var features	= "dialogHeight:" + dialogHeight +"; dialogLeft"+dialogLeft+ "; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop;
	var arguments	= "";	
	retVal = await top.window.showModalDialog("../../ePH/jsp/DirectDispFillingRemarks.jsp?title=Findings"+"&chk="+chk+"&drug_code="+drug_code+"&recno="+recno+"&obj="+obj+"&srl_no="+srl_no,arguments,features);
	
	if(retVal=="OK") {
		changeColor(obj);
	}
	else {
		obj.style.color='blue';
	}
}

function setFocusRem(formObj){
	formObj.remarks.focus();
}

function setAmendRemarks(frmObj){
	var xmlStr ="<root><SEARCH ";
	xmlStr+= "reason  =\"" + frmObj.reason.value + "\" " ;
	xmlStr+= "bean_id =\"" + frmObj.bean_id.value + "\" " ;
	xmlStr+= "bean_name=\"" + frmObj.bean_name.value + "\" " ;
	xmlStr+= "appl_trn_type=\"" + frmObj.chk.value + "\" " ;
	xmlStr+= "frmObj=\"" + frmObj.name + "\" " ;
	xmlStr +=" /></root>";
   fieldValidation(xmlStr,"setAmendDetails");
	
}

function assignRemarksValue(remarks){
	document.DirectDispFillingRemarks.remarks.value=decodeURIComponent(remarks);
}

function callFillVal(frmObj,obj){		
	if(frmObj.remarks.value.length < 500){		
		validateFillRemarks(frmObj,"filling");		
	}
	else{
		var val=frmObj.remarks.value;//code added for ML-BRU-SCF-0971[IN042220]
		frmObj.remarks.value = val.substring(0,500);//code added for ML-BRU-SCF-0971[IN042220]
		alert(getMessage("PH_REMARKS_NOT_EXCEED","PH"));					
		frmObj.remarks.focus();//code added for ML-BRU-SCF-0971[IN042220]
	}
}

function callCancelFillVal(frmObj){
	/*var reason=document.DirectDispFillingRemarks.reason.value;
	
	if(reason!=""){
		validateFillRemarks(frmObj,"cancel");
	}else{*/
	//window.close();
	parent.document.getElementById('dialog_tag').close();  

	//}
}

function validateFillRemarks(frmObj,func_mode) {
	reason			    =	frmObj.reason.value;
	recno				=	frmObj.recno.value;
	drug_code			=	frmObj.drug_code.value;
	var srl_no			=	frmObj.srl_no.value;
	bean_id				=	frmObj.bean_id.value;
	bean_name			=	frmObj.bean_name.value;
	remarks				=	encodeURIComponent(frmObj.remarks.value);
	chk					=	frmObj.chk.value;
	
	var fields  = new Array() ;
	var names   = new Array() ;
	fields[1]   = frmObj.remarks;
	fields[0]	= frmObj.reason;
	names[1]    = getLabel("Common.remarks.label","Common") ; 
	names[0]	= getLabel("Common.Findings.label","Common") ;

	if(checkFlds( fields, names)){
		var xmlStr ="<root><SEARCH ";
		xmlStr+= "reason  =\"" + reason + "\" " ;
		xmlStr+= "remarks =\"" + remarks + "\" " ;
		xmlStr+= "recno =\"" + recno + "\" " ;
		xmlStr+= "drug_code =\"" + drug_code + "\" " ;
		xmlStr+= "bean_id =\"" + bean_id + "\" " ;
		xmlStr+= "bean_name=\"" + bean_name + "\" " ;
		xmlStr+= "chk=\"" + chk + "\" " ;
		xmlStr+= "srl_no=\"" + srl_no + "\" " ;
		xmlStr +=" /></root>";
		fieldValidation(xmlStr,func_mode);
		//window.close();
		parent.document.getElementById('dialog_tag').close();  

	}
	else{
		return false;
	}
}

function checkFlds( fields, names) {
	var errors = "" ;
	for( var i=0; i<fields.length; i++ ) {
		if(trimCheck(fields[i].value)) {
			fields[i].value = trimString(fields[i].value);
		}
		else	errors = errors + "APP-000001 " + names[i] + " "+getLabel("Common.Cannotbeblank.label","Common") + "\n" ;//Modified for IN:069887 
	}
	if ( errors.length != 0 ) {
		alert(errors) ;
		return false ;
	}
	return true ;
}


function updateValue(obj) {
	if(obj.checked==true)
		obj.value	="Y";
	else
		obj.value	="N";
}

function CompleteDispensing(){
    var formdispobj			  = parent.parent.parent.f_detail.f_disp_detail.f_allocated_detail.document.DirectDispDispensingDetails;
    var formObject			  = parent.parent.parent.f_detail.f_header.document.dir_disp_header_form;
	var drug_db_interface_yn  = formObject.drug_db_interface_yn.value;
	var approval_no_appl_flag = formdispobj.approval_no_flag.value; //AAKH-CRF-0117
	var encounter_id          = formObject.encounter_id.value; //AAKH-CRF-0117
	var approval_no_app_for_patient_class = formdispobj.approval_no_app_for_patient_class.value; //AAKH-CRF-0117
	 if(encounter_id!="" && approval_no_app_for_patient_class=="Y" && (approval_no_appl_flag==true || approval_no_appl_flag=="true")){
		
		var approval_proceed_flag = true;
		approval_proceed_flag = getApprovalNoValidation("D",formdispobj);

		if(!approval_proceed_flag){
			alert(getMessage("PH_APPROVAL_NO_CANT_BE_BLANK","PH"));
			return false;
		}
	 }
    if(drug_db_interface_yn=="Y"){
		var xmlStr  ="<root><SEARCH ";
        xmlStr+= "bean_id=\"" + formObject.bean_id.value + "\" " ;
		xmlStr+= "bean_name=\"" + formObject.bean_name.value + "\" " ;
		xmlStr +=" /></root>";	
       fieldValidation(xmlStr,"CheckForExternalOverrideReasons");
	}
	else{
		insertdetails("Y");
	}

}

function insertdetails(proceed_yn){
	if(proceed_yn=='Y'){
		 var formdispobj	 = parent.parent.parent.f_detail.f_disp_detail.f_allocated_detail.document.DirectDispDispensingDetails;
		 var xmlStr  ="<root><SEARCH ";
		 xmlStr +=  buildXMLString(formdispobj);
		 xmlStr +=" /></root>";	
		fieldValidation(xmlStr,"InsertDispenseDetails");
		formGrouping();
	}
	else{
		if(proceed_yn=='M')
			alert("App-PH999 Batch Details not updated. Please Click Confirm Button and Proceed");
		else
			alert(getMessage("PLS_GVE_OVRD_RSN","PH"));
	}
}


//this method will be invoked on click of complete dispensing button
function formGrouping(){
    var hdr_formobj	 = parent.parent.parent.f_detail.f_header.document.dir_disp_header_form;
	var drug_frmobj	 = parent.parent.parent.f_detail.f_ord_detail.f_drug_detail.f_drug.prescription_detail_form;	
	var patient_id	 = hdr_formobj.patient_id.value;
	var encounter_id = hdr_formobj.encounter_id.value;
	var height		 = hdr_formobj.height.value;
	var weight		 = hdr_formobj.weight.value;
	var bsa			 = hdr_formobj.bsa.value;
	var bmi			 = hdr_formobj.bmi.value;
	var height_unit  = hdr_formobj.height_unit.value;
	var weight_unit  = hdr_formobj.weight_unit.value;
	var bsa_unit     = "BSA";
	var priority     = hdr_formobj.priority.value;
	var order_date_time		 = hdr_formobj.sys_date.value;
	var take_home_medication = hdr_formobj.take_home_medication.value;
	var patient_class		 = hdr_formobj.patient_class.value;
	var allergic_yn  ="N";
	var patient_name = hdr_formobj.patient_name.value;

	if(height_unit=="")height_unit="Cms";
	if(weight_unit=="")weight_unit="Kgs";

	var location_type  = hdr_formobj.location_type.value;
	var location_code  = hdr_formobj.location_code.value;
	var facility_id    = hdr_formobj.facility_id.value;
	var attend_pract_id= hdr_formobj.pract_id.value;
	var ord_pract_id   = hdr_formobj.pract_id.value;
	var language_id	   = hdr_formobj.language_id.value;

	var fldString=" patient_class=\""+ patient_class + "\" ";
	fldString+=" patient_id=\""+ patient_id + "\" ";
	fldString+=" patient_name=\""+ encodeURIComponent(patient_name,"UTF-8") + "\" ";
	fldString+=" encounter_id=\""+ encounter_id + "\" ";
	fldString+=" height=\""+ height + "\" ";
	fldString+=" weight=\""+ weight + "\" ";
	fldString+=" bsa=\""+ bsa + "\" ";
	fldString+=" height_unit=\""+ height_unit + "\" ";
	fldString+=" weight_unit=\""+ weight_unit + "\" ";
	fldString+=" bsa_unit=\""+ bsa_unit + "\" ";
	fldString+=" order_date_time=\""+ order_date_time + "\" ";
	fldString+=" priority=\""+ priority + "\" ";
	fldString+=" take_home_medication=\""+ take_home_medication + "\" ";
	fldString+=" source_type=\""+ location_type + "\" ";
	fldString+=" source_code=\""+ location_code + "\" ";
	fldString+=" facility_id=\""+ facility_id + "\" ";
	fldString+=" attend_pract_id=\""+ attend_pract_id + "\" ";
	fldString+=" ord_pract_id=\""+ ord_pract_id + "\" ";
	fldString+=" allergic_yn=\""+ allergic_yn + "\" ";
	fldString+=" bmi=\""+ bmi + "\" ";	
	fldString+=" language_id=\""+ language_id + "\" ";	
	
	var formobj=drug_frmobj;
	var xmlStr=formXMLString(formobj,fldString);
	fieldValidation(xmlStr,"formGrouping");
}

async function showRecords(){
	var hdr_formobj		= parent.parent.parent.f_detail.f_header.document.dir_disp_header_form;
	var patient_id      = hdr_formobj.patient_id.value;
	var encounter_id    = hdr_formobj.encounter_id.value;	
	var patient_class    = hdr_formobj.patient_class.value;	
	disp_locn_code = parent.parent.parent.f_query_add_mod.document.DirectDispensingQueryCriteria.disp_locn_code.value
	retVal		='TEST';
	var alertForOutStandingReturn = false;//added for MMS-QH-CRF-0201 [IN:052255] -start
	if(retVal!=null){
		var formarray  =new Array(hdr_formobj);
		retn_disp_med_for_outstanding = document.getElementById('retn_disp_med_for_outstanding').value;//added for MMS-QH-CRF-0201 [IN:052255] -start
		disp_cash_coll_stage  =	document.getElementById('disp_cash_coll_stage').value;
		var tot_groos_pat_payable = document.getElementById('tot_groos_pat_payable').value;
		
		if(isNaN(tot_groos_pat_payable))
			tot_groos_pat_payable = 0;
		if(retn_disp_med_for_outstanding == 'Y' && disp_cash_coll_stage == 'D' && parseFloat(tot_groos_pat_payable)>0 ){
			alertForOutStandingReturn = true;
			if(!confirm(getMessage("PH_CONFIRM_PATIENT_PAYABLE_AMOUNT","PH").replace("$$",tot_groos_pat_payable))){
				return false;
			}
		} //added for MMS-QH-CRF-0201 [IN:052255] -end
	
		// RUT-CRF-0035 [IN029926] PIN Authentication -- begin  
		if(parent.parent.parent.f_query_add_mod.document.DirectDispensingQueryCriteria.userAuthPINYN.value=="Y"){
			var dialogHeight	= "10";
			var dialogWidth		= "30";
			var dialogTop		=  window.screen.availWidth - 1100;
			var dialogLeft		=  window.screen.availWidth - 1000;
			var center			= "0";
			var status			= "no";	
			var features		= "dialogHeight:" + dialogHeight +"; dialogLeft:"+dialogLeft+ "; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop;
			var retVal1=await window.showModalDialog("../../ePH/jsp/UserPINAuthorization.jsp?call_from=DD&disp_category="+patient_class+"&disp_locn_code="+disp_locn_code,"",features);
			if(retVal1==undefined || retVal1=='C')
				 return;
			else if(trimString(retVal1)!="0") // && trimString(retVal1)!="")
				storeAuthUserInBean(trimString(retVal1));
		}// RUT-CRF-0035 [IN029926] PIN Authentication  -- end
		eval( formApply( formarray,PH_CONTROLLER) ) ;
	   if( result ){
			if(flag!=''&&flag!='0'){	
				parent.parent.parent.messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num="+ getMessage("RECORD_INSERTED","PH") + getLabel("ePH.TokenNo.label","PH")+" : <label style='font-size:18'><b>"+flag+"</b></label>";
				var print_yn="N";
				var print_confirm=confirm(getMessage("PH_PRINT_TOKEN", "PH"));
				parent.parent.parent.messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num=";
				if(print_confirm){
					print_yn="Y";
					var bean_id			= "DirectDispensingBean";
					var bean_name       = "ePH.DirectDispensingBean";
					var xmlStr ="<root><SEARCH ";
					xmlStr+= "bean_id  =\"" + bean_id + "\" " ;
					xmlStr+= "bean_name =\"" + bean_name + "\" " ;	
					xmlStr+= "print_yn  =\"" + print_yn + "\" " ;
					xmlStr+= "flag  =\"" + flag + "\" " ;
					xmlStr +=" /></root>";
					var temp_jsp="DirectDispValidate.jsp?func_mode=onLinePrinting";
					var xmlDoc = "" ;
					var xmlHttp = new XMLHttpRequest() ;
					xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
					xmlHttp.open("POST",temp_jsp,true);
					xmlHttp.send(xmlDoc);
				}
			}
			else{
				parent.parent.parent.messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num="+getMessage("RECORD_INSERTED",'PH');
			}
					
			var bean_id			= "DirectDispensingBean";
			var bean_name       = "ePH.DirectDispensingBean";
			var xmlStr ="<root><SEARCH ";
			xmlStr+= "bean_id =\"" + bean_id + "\" " ;
			xmlStr+= "bean_name=\"" + bean_name + "\" " ;	
			xmlStr +=" /></root>";
			fieldValidation(xmlStr,"CHECKBMS");	
	   }
		else{
			//parent.parent.parent.messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num="+message;
			parent.parent.parent.messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num="+getMessage("EXCEPTION_OCCURED_WHILE_INSERTION",'PH')+":"+message;
		}
	}
	else{
		parent.parent.parent.messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num="+getMessage("EXCEPTION_OCCURED_WHILE_INSERTION",'PH');
			
	}
}

async function showPrintDialog(flag,label_format,bal_sheet,disp_sheet,login_user,facility_id,billing_interface_yn,Disp_label_yn,med_plan,disp_cash_coll_stage,bl_det,token_no,disp_locn_code,encounterId) {// Added encounterId for HSA-CRF-0113 [IN:048166]

	var dialogHeight= "600px" ;	//changed  32 to 95	for RUT-CRF-0067
	var dialogWidth	= "1000px" ;   //changed 50 to 55 for RUT-CRF-0067
	var dialogTop   = "300" ;  //changed 195 to 300 for RUT-CRF-0067
	var dialogLeft	= "250" ; //newly added for RUT-CRF-0067
	var center      = "1" ;
	var status      ="no";

	var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" +dialogTop+";scroll=no";
	var arguments	= "" ;	
//	retVal = window.showModalDialog("../../ePH/jsp/DirectDispPrintDialog.jsp?flag="+flag+"&label_format="+label_format+"&bal_sheet="+bal_sheet+"&disp_sheet="+disp_sheet+"&login_user="+login_user+"&facility_id="+facility_id+"&Disp_label_yn="+Disp_label_yn,arguments,features);

	//file name changed in  the below line For FD-RUT-CRF-0067 Start
	 retVal = await parent.parent.parent.parent.window[2].showModalDialog("../../ePH/jsp/DirectDispPrintDialogFrame.jsp?flag="+flag+"&label_format="+label_format+"&bal_sheet="+bal_sheet+"&disp_sheet="+disp_sheet+"&login_user="+login_user+"&facility_id="+facility_id+"&Disp_label_yn="+Disp_label_yn+"&med_plan="+med_plan+"&encounterId="+encounterId,arguments,features);//Added med_plan  for  ML-BRU-CRF-072[Inc:29938]// Added encounterId for HSA-CRF-0113 [IN:048166]
	 //Code Added For FD-RUT-CRF-0067 End
	if(retVal==undefined || retVal=="" || retVal=="false"){
		showPrintDialog(flag,label_format,bal_sheet,disp_sheet,login_user,facility_id,billing_interface_yn,Disp_label_yn,med_plan,disp_cash_coll_stage,bl_det,token_no,disp_locn_code,encounterId)
	}
	if(retVal=='OK' || retVal=='CANCEL'){
	   if(billing_interface_yn='Y' && disp_cash_coll_stage=='D'){
		   callbillingwindow(bl_det,disp_locn_code)
	   }
	   else{
		   clearframes();
	   }
	}
	parent.parent.parent.f_query_add_mod.location.reload();
}

async function callbillingwindow(doc_det_for_bl,disp_locn_code){

	detail = doc_det_for_bl.split(",");
	/*var doc_no   =  detail[0];
	var doc_type =  detail[1];
	var bill_group_code =  detail[2];
	var error_text =  detail[3];
	*/

	var bill_doc_no			    =  detail[0];
	var bill_doc_type			=  detail[1];
	var bill_group_code			=  detail[2];
	var call_disc_function_yn	=  detail[3];
	var l_slmt_reqd_yn			=  detail[4];
	var doc_no					=  detail[5];
	var patient_id				=  detail[6];
	var encounter_id			=  detail[7];
	var patient_class			=  detail[8];
	var error_text				=  detail[9];
	
	if(error_text==''){
		if(patient_class=="E"||patient_class=="O"){
			  episode_id = (encounter_id).substring(0,encounter_id.length-4);
			  visit_id = (encounter_id).substring(encounter_id.length-4,encounter_id.length);
		}
		else if(patient_class=="I"||patient_class=="D"){
			  episode_id = formObj.encounter_id.value;
			  visit_id   = "1";
		}
		else{
			 episode_id ='';	
			 visit_id   = '';
		}

		var retVal = new Array();		
		var center='1';
		var dialogTop = "100";
		var dialogHeight = "700px" ;
		var dialogWidth = "1100px" ;
		var features= "dialogTop:" + dialogTop + "; dialogHeight:" + dialogHeight + "; center:" + center + "; dialogWidth:" + dialogWidth +";status=no" ;	
		var arguments = "" ;
		var column_sizes = escape("");               
		var column_descriptions ="";		

		//var param = "column_sizes="+column_sizes+"&"+"column_descriptions="+column_descriptions+"&"+"billdoctypecode="+doc_type+"&"+"billdocnum="+doc_no+"&"+"storecode="+disp_locn_code+"&"+"blnggrp="+bill_group_code+"&"+"module_id=PH";	
		//retVal=window.showModalDialog("../../eBL/jsp/BLStoreBillSlmtMain.jsp?"+param,arguments,features);

		var url = "../../eBL/jsp/BLCallDiscOrSlmtPage.jsp?bill_doc_type_code=" + bill_doc_type + "&bill_doc_num=" + bill_doc_no + "&store_code=" + disp_locn_code + "&blng_grp=" + bill_group_code + "&module_id=PH&column_sizes=" + column_sizes + "&column_descriptions=" + column_descriptions+"&patient_id="+patient_id+"&encounter_id="+encounter_id+"&call_disc_function_yn="+call_disc_function_yn+"&doc_no="+doc_no+"&episode_id="+episode_id+"&visit_id="+visit_id+"&slmt_reqd_yn="+l_slmt_reqd_yn+"&episode_type="+patient_class;
		
		//added top.window.showModalDialog by Vedesh for EDGE Conversion
		retVal  =  await top.window.showModalDialog(url,arguments,features);
				
		 if((retVal == "N" || retVal == "P") && retn_disp_med_for_outstanding == 'Y' && disp_cash_coll_stage=='D'){//added for MMS-QH-CRF-0201 [IN:052255] -start
			if(confirm(getMessage("PH_CONFIRM_FOR_RETURN_MEDN","PH"))){
				if(checkReturnAccess(disp_locn_code)){
					showReturnMedication(patient_id,disp_locn_code, 'O' );
				}
				else
					alert(getMessage("PH_RET_MED_RIGHTS","PH"));
			}
		 } //added for MMS-QH-CRF-0201 [IN:052255] -end
		if(retVal==undefined){
			callbillingwindow(doc_det_for_bl,disp_locn_code);
		}
		else{
			clearframes();
		}
	}
	else{
		if(error_text!=''&& error_text!=undefined){
			 alert(error_text);
		}
		clearframes();
	}	
}


function clearframes(){
	
	var bean_id			= "DirectDispensingBean";
	var bean_name	    = "ePH.DirectDispensingBean";
	var xmlStr			= "<root><SEARCH ";
		xmlStr			+= " bean_id=\""+ bean_id + "\" ";
		xmlStr			+= " bean_name=\""+ bean_name + "\" ";
		xmlStr			+= " /></root>";
		
	fieldValidation(xmlStr,"reset1");
}

function assignResult( _result, _message, _flag ) {
	
	result = _result ;
	message  = _message ;
	flag = _flag ;
}
function changeButtonColor(obj,from_name)
{

	if(from_name=="PH_BUTTONS"){
		cellref = document.DispMedicationPrintDialog.tab.rows[0].cells
		//version_no = parent.f_header.document.prescription_header_form.version_no.value;
		}
	//else if(from_name=="COMMON")
		//cellref = document.getElementById("tab").rows[0].cells
	//if(version_no==3) check_val = 4; else check_val = 2;
	for(i=0; i<cellref.length; i++)
	{
		//if(i!=check_val && i!=(check_val+1)){
		if(cellref[i].id!="dummy")
		cellref[i].className = 'CAFIRSTSELECTHORZ'
		}
	//}
	obj.className = "CASECONDSELECTHORZ"
	currClass ="CASECONDSELECTHORZ";
}
function calltable(str){
	
	var print_report=document.getElementById("print_report_table");
	var bal_med_dtl= document.getElementById("Bal_Med_table");
	var cuu_facility=document.getElementById("curr_facility_table");
	var extr_facility= document.DispMedicationPrintDialog.extr_facility_table;
	var extr_facility_btn_table= document.DispMedicationPrintDialog.extr_facility_btn_table;
	var trCurBMSReason=document.DispMedicationPrintDialog.trCurBMSReason;
	var trCurBMSReasonVisibility=document.DispMedicationPrintDialog.curBMSReasonVisibility.value;
	var trExtBMSReason=document.DispMedicationPrintDialog.trExtBMSReason;
	var trExtBMSReasonVisibility=document.DispMedicationPrintDialog.all.extBMSReasonVisibility.value;

	  if(str=='print_report'){
		   print_report.style='display';
		   print_report.style.visibility='visible';
		   bal_med_dtl.style.display='none';
		   bal_med_dtl.style.visibility='hidden';
		   cuu_facility.style.display='none';
		   cuu_facility.style.visibility='hidden';
		   trCurBMSReason.style.visibility='hidden';
		   extr_facility.style.display='none';
		   extr_facility.style.visibility='hidden';
		   trExtBMSReason.style.visibility='hidden';
		   extr_facility_btn_table.style.display='none';
		   extr_facility_btn_table.style.visibility='hidden';
	  }
	  else if(str=='bal_med_dtl'){
		   bal_med_dtl.style='display';
		   bal_med_dtl.style.visibility='visible';
		   print_report.style.display='none';
		   print_report.style.visibility='hidden';
		   extr_facility.style.display='none';
		   trExtBMSReason.style.visibility='hidden';
		   extr_facility.style.visibility='hidden';
		   cuu_facility.style='display';
		   cuu_facility.style.visibility='visible';
		   trCurBMSReason.style.visibility=trCurBMSReasonVisibility;
		   extr_facility_btn_table.style='display';
		   extr_facility_btn_table.style.visibility='visible';
	  }
}


//for printing on-line reports
function printOnlineDispense(frmObj,type) { 
	var bean_id		= "DirectDispensingBean" ;
	var bean_name	= "ePH.DirectDispensingBean";
	var fields		= new Array() ;
	var names		= new Array() ;			
	var select_lang = "E";
	var bms_sel_lang = "";
	var	print_Dialog_Lang="";
	var formObj = parent.printSelectFrame.document.DispMedicationPrintDialog; //newly added for RUT-CRF-0067
//if condition newly added for CRF-0075 by manickam
	/*if(formObj.select_lang.value==""){
		formObj.select_lang.value=formObj.defaultLanguage.value;
	}*/
	bms_sel_lang = formObj.bmsTabLang.value;		//newly added by manickam for CRF-0074
	print_Dialog_Lang=formObj.printDialogLang.value; //newly added by manickam for CRF-0074
    login_user		=	formObj.login_user.value;
	facility_id		=	formObj.facility_id.value;
	patient_id		=	formObj.patient_id.value;
	locn_code		=	formObj.disp_locn.value;
	
	patient_class	=	formObj.patient_class.value;	
	
    var print_disp_sheet_yn   =   "N";
	var print_bal_sheet_yn    =   "N";
	var print_disp_label_yn   =   "N";
	var med_plan_sheet_yn	  =   "N";//Newly Added   For ML-BRU-CRF-072[Inc:29938] start
	var print_pres_yn         =   "N";
//changed frmObj to formObj for RUT-CRF-0067 - start
    if(formObj.disp_sheet.checked){ 
        print_disp_sheet_yn  = "Y";
	}
	if(formObj.bal_sheet.checked && formObj.enable_tab.value=='Y'){
        print_bal_sheet_yn   = "Y";
	}
	if(formObj.disp_label.checked){
        print_disp_label_yn  = "Y";
	}
	if(formObj.print_pres.checked){
		print_pres_yn="Y";
	}
	//Newly Added   For ML-BRU-CRF-072[Inc:29938]
	if(formObj.med_plan.checked){
		med_plan_sheet_yn="Y";
	}
	
  /*  if( print_disp_sheet_yn=="N" &&  print_bal_sheet_yn=="N" &&  print_disp_label_yn=="N"){
		alert(getMessage("ATLT_ONE_SLCTD","PH"));
		return false;
	}
	*/


	var enable_tab= formObj.enable_tab.value;
	var print_extr_pres    = "N";
	if(type=="OK")
    {
	if(enable_tab=='Y')
	{
		flag=current_facility;
		if(formObj.curr_facility[0].checked==true)
	           curr_facility=formObj.curr_facility[0].value;
	    else
		       curr_facility=formObj.curr_facility[1].value;
		  if(curr_facility=='C')
			 {
				next_collection_date=	formObj.next_collection_date1.value;//next collection_date
				next_collection_date_ref=formObj.next_collection_date1;
				
			 }else if(curr_facility=='E'){
				 next_collection_date=	formObj.next_collectiondate.value ;//next collection_date
				 next_collection_date_ref=formObj.next_collectiondate;
			 
			 var referral_facility	="";
	
		if(formObj.referral_location.value!=""){
				referral_facility	=	formObj.referral_location.value;//other_facility_id
			}else{
				referral_facility	=	formObj.referral_facility.value ;//facility_name
			}
		 }
	 var referral_remarks	=	formObj.referral_remarks.value;//remarks
	 var practioner_id		=	formObj.practioner_id.value;//reffered by
	 
	   if(formObj.print_extr_pres.checked==true){
           print_extr_pres    ="Y";
	    }else{
			print_extr_pres    ="N";
        }
	 
	 if(curr_facility=='C')
			   {
			    fields[0]   = formObj.next_collection_date1 ;	
				names[0]    = getLabel("ePH.NextCollectionDate.label","PH") ;				
				fields[1]   = formObj.disp_locations ;	
				names[1]    = getLabel("ePH.NextCollectionFrom.label","PH") ;  
			   }else if(curr_facility=='E')
			   {
				   var cnt	=	0;

                if(formObj.referral_location.value!="" && formObj.referral_facility.value!=""){ 
					fields[cnt]   = formObj.referral_location ;	
					names[cnt]    = getLabel("Common.FacilityName.label","Common") ; 
					cnt++;
				}

				fields[cnt]   = formObj.next_collectiondate ;	
				names[cnt]    = getLabel("ePH.NextCollectionDate.label","PH") ; ;
				cnt++;

				fields[cnt]   = formObj.referral_remarks ;	
				names[cnt]    = getLabel("Common.remarks.label","Common") ;  
				cnt++;

				fields[cnt]   = formObj.practioner_name ;	
				names[cnt]    = getLabel("ePH.ReferedBy.label","PH");
				
			   }
		if(checkFlds( fields, names)){

        var xmlStr ="<root><SEARCH ";
		xmlStr+= "bean_id  =\"" + bean_id + "\" " ;
		xmlStr+= "bean_name =\"" + bean_name + "\" " ;		
		xmlStr+= "login_user  =\"" + login_user + "\" " ;
		xmlStr+= "facility_id =\"" + facility_id + "\" " ;
		xmlStr+= "patient_id =\"" + patient_id + "\" " ;		
		xmlStr+= "locn_code=\"" + locn_code + "\" " ;
		xmlStr+= "patient_class=\"" + patient_class + "\" " ;		
		xmlStr+= "print_extr_pres=\"" + print_extr_pres + "\" " ;		
		xmlStr+= "select_loc_lang=\"" + print_Dialog_Lang + "\" " ;  //replaced formObj.select_loc_lang.value to print_Dialog_Lang
		xmlStr+= "bms_sel_lang=\"" + bms_sel_lang + "\" " ;  //replaced formObj.select_loc_lang.value to formObj.select_lang.value
		xmlStr+= "print_disp_sheet_yn  =\"" + print_disp_sheet_yn + "\" " ;
		xmlStr+= "print_bal_sheet_yn =\"" + print_bal_sheet_yn + "\" " ;
		xmlStr+= "print_disp_label_yn=\"" + print_disp_label_yn + "\" " ;
		xmlStr+= "med_plan_sheet_yn=\"" + med_plan_sheet_yn + "\" " ;//Newly Added   For ML-BRU-CRF-072[Inc:29938]
		xmlStr+= "print_pres_yn=\"" + print_pres_yn + "\" " ;		

		xmlStr +=" /></root>";
		var temp_jsp="DirectDispValidate.jsp?func_mode=print_dispense";
		var xmlDoc = "" ;
		var xmlHttp = new XMLHttpRequest() ;
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open("POST",temp_jsp,true);
		xmlHttp.send(xmlDoc);
		//parent.window.close();
		parent.document.getElementById('dialog_tag').close();
	}
    }else{
			
		var xmlStr ="<root><SEARCH ";
		xmlStr+= "bean_id  =\"" + bean_id + "\" " ;
		xmlStr+= "bean_name =\"" + bean_name + "\" " ;	
		xmlStr+= "login_user  =\"" + login_user + "\" " ;
		xmlStr+= "facility_id =\"" + facility_id + "\" " ;
		xmlStr+= "patient_id =\"" + patient_id + "\" " ;		
		xmlStr+= "locn_code=\"" + locn_code + "\" " ;
		xmlStr+= "patient_class=\"" + patient_class + "\" " ;
		xmlStr+= "print_extr_pres=\"" + print_extr_pres + "\" " ;
		xmlStr+= "select_loc_lang=\"" + print_Dialog_Lang + "\" " ;  //replaced formObj.select_loc_lang.value to select_lang
		xmlStr+= "bms_sel_lang=\"" + bms_sel_lang + "\" " ;  //replaced formObj.select_loc_lang.value to formObj.select_lang.value
		xmlStr+= "print_disp_sheet_yn  =\"" + print_disp_sheet_yn + "\" " ;
		xmlStr+= "print_bal_sheet_yn =\"" + print_bal_sheet_yn + "\" " ;
		xmlStr+= "print_disp_label_yn=\"" + print_disp_label_yn + "\" " ;
		xmlStr+= "med_plan_sheet_yn=\"" + med_plan_sheet_yn + "\" " ;//Newly Added   For ML-BRU-CRF-072[Inc:29938]
		xmlStr+= "print_pres_yn=\"" + print_pres_yn + "\" " ;
		xmlStr +=" /></root>";
		var temp_jsp="DirectDispValidate.jsp?func_mode=print_dispense";
		var xmlDoc = "" ;
		var xmlHttp = new XMLHttpRequest() ;
//changed frmObj to formObj for RUT-CRF-0067 - end		
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open("POST",temp_jsp,true);
		xmlHttp.send(xmlDoc);
		//responseText=xmlHttp.responseText ;
		parent.parent.document.getElementById('dialog_tag').close();
		//parent.window.close();
	}
  }else
  { 
   
   //parent.window.close();
   parent.parent.document.getElementById('dialog_tag').close();
  }
}

function callOnMouseOver(obj){
	currClass = obj.className ;
	obj.className = 'CASECONDSELECTHORZ';
}

function callOnMouseOut(obj){
	obj.className = currClass;
}

function callfacillity(obj){
	
	var cuu_facility=document.DispMedicationPrintDialog.curr_facility_table;
	var extr_facility= document.DispMedicationPrintDialog.extr_facility_table;
	var extr_facility_btn_table= document.DispMedicationPrintDialog.extr_facility_btn_table;
	var trCurBMSReason=document.DispMedicationPrintDialog.trCurBMSReason;
	var trCurBMSReasonVisibility=document.DispMedicationPrintDialog.curBMSReasonVisibility.value;
	var trExtBMSReason=document.DispMedicationPrintDialog.trExtBMSReason;
	var trExtBMSReasonVisibility=document.DispMedicationPrintDialog.extBMSReasonVisibility.value;
     current_facility=obj.value;
	  if(obj.value=='C'){
		   cuu_facility.style='display';
		   cuu_facility.style.visibility='visible';
		   trCurBMSReason.style.visibility=trCurBMSReasonVisibility;
		   extr_facility.style.display='none';
		   extr_facility.style.visibility='hidden';
		   trExtBMSReason.style.visibility='hidden';
		   extr_facility_btn_table.style='display';
		   extr_facility_btn_table.style.visibility='visible';
		   document.DispMedicationPrintDialog.print_extr_pres.checked=false;
		   document.DispMedicationPrintDialog.print_extr_pres.value='N';
	  }
	  else if(obj.value=='E') {
		   extr_facility.style='display';
		   extr_facility.style.visibility='visible';
		   trExtBMSReason.style.visibility=trExtBMSReasonVisibility;
		   cuu_facility.style.display='none';
		   cuu_facility.style.visibility='hidden';
		   trCurBMSReason.style.visibility='hidden';
		   extr_facility_btn_table.style='display';
		   extr_facility_btn_table.style.visibility='visible';
		   document.DispMedicationPrintDialog.print_extr_pres.checked=true;
			document.DispMedicationPrintDialog.print_extr_pres.value='Y';
	  }
}

function disable_facility(obj,obj1){
	if(obj.name=='referral_facility'&& obj.value!=""&&obj.value!=null){
       obj1.disabled=true;   
	}
	else{
       obj1.disabled=false; 
	}
}

function disable_facility1(obj,obj1){
	if(obj.name=='referral_location'&& obj.value!=""&&obj.value!=null){
       obj1.disabled=true;   
	}
	else{
		 obj1.disabled=false;
	}
}

function reset_table(frmobj){
  frmobj.reset();	
  
}

function checkSysDate(sysdate,next_collection_date,pres_date){
	
	if(!doDateCheckAlert(sysdate,next_collection_date)){
		alert(getMessage("NEXT_COLL_GRT_SYSDATE","PH"));
		next_collection_date.focus();
		return false;
	}
	else{
		if(!doDateCheckAlert(next_collection_date,pres_date)){
			alert(getMessage("NEXT_COLL_NOT_BLANK","PH"));
			next_collection_date.focus();
			return false;
		}
	}
	return true;
}

function setOrOrder(frmObj){
	order_id				=	frmObj.order_id.value;
	order_line_no			=	frmObj.order_line_no.value;
	var bean_id				=   "DirectDispensingBean";
	var bean_name			=   "ePH.DirectDispensingBean";
    var language_id			=   frmObj.language_id.value;
    // flag   C--->current facility
	// flag   E-->External facility
	flag     =     current_facility;
	var bmsReasonCode="";
    if(flag=='C'){
		next_collection_date=	frmObj.next_collection_date1.value;//next collection_date
        next_collection_date_ref=frmObj.next_collection_date1;
		bmsReasonCode=frmObj.CurbmsReason.value;
	}
	else if(flag=='E'){
		next_collection_date=	frmObj.next_collectiondate.value ;//next collection_date
		next_collection_date_ref=frmObj.next_collectiondate;
		bmsReasonCode=frmObj.ExtbmsReason.value;
	}
	//bmsReasonCode=	frmObj.bmsReason.value ;//next collection_date
 
	visible					=   frmObj.visible.value;
	var referral_facility	="";

    if(frmObj.referral_location.disabled==false)
	    referral_facility	=	frmObj.referral_location.value;//other_facility_id
	else
	    referral_facility	=	frmObj.referral_facility.value ;//facility_name
	
	var referral_remarks	=	frmObj.referral_remarks.value;//remarks
	var practioner_id		=	frmObj.practioner_id.value;//reffered by
	//disp_no		=	frmObj.disp_no.value;
	//srl_no		=	frmObj.srl_no.value;
	var  disp_locn      =	"";
	if(frmObj.disp_locations!=null)
	    var   disp_location     =	frmObj.disp_locations.value;//next collection from
	if(checkSysDate(frmObj.sysdate,next_collection_date_ref,frmObj.pres_date)){
		var curr_facility;
		var fields  = new Array() ;
		var names   = new Array() ;

		if(frmObj.curr_facility[0].checked==true)
			curr_facility=frmObj.curr_facility[0].value;
		else
			curr_facility=frmObj.curr_facility[1].value;			
					
		if(visible == "true"){
			if(curr_facility=='C'){
				fields[0]   = frmObj.next_collection_date1 ;	
				names[0]    = getLabel("ePH.NextCollectionDate.label","PH") ; ;	
				fields[1]   = frmObj.disp_locations ;	
				names[1]    = getLabel("ePH.NextCollectionFrom.label","PH") ; 
			}
			else if(curr_facility=='E'){
				if(frmObj.referral_location.disabled==false){ 
					fields[0]   = frmObj.referral_location ;	
					names[0]    = getLabel("Common.FacilityName.label","Common") ; 
				}
				else{
					fields[0]   = frmObj.referral_facility ;	
					names[0]    = getLabel("Common.FacilityName.label","Common") ;
				}
				fields[1]   = frmObj.next_collectiondate ;	
				names[1]    = getLabel("ePH.NextCollectionDate.label","PH") ; ;
				fields[2]   = frmObj.referral_remarks ;	
				names[2]    = getLabel("Common.remarks.label","Common") ; 
				fields[3]   = frmObj.practioner_name ;	
				names[3]    = getLabel("ePH.ReferedBy.label","PH") ; 
			}
			if(checkFlds( fields, names)){					
				var xmlStr ="<root><SEARCH ";
				//xmlStr+= "order_id =\"" + order_id + "\" " ;
				//xmlStr+= "order_line_no =\"" + order_line_no + "\" " ;
				//xmlStr+= "disp_no =\"" + disp_no + "\" " ;
				//xmlStr+= "srl_no =\"" + srl_no + "\" " ;					
				xmlStr+= "bean_id =\"" + bean_id + "\" " ;
				xmlStr+= "bean_name=\"" + bean_name + "\" " ;	
				xmlStr+= "next_collection_date=\"" +convertDate(next_collection_date,"DMY",language_id,"en")  + "\" " ;
				xmlStr+= "bmsReasonCode=\"" +bmsReasonCode  + "\" " ;
				xmlStr+= "flag=\"" + flag + "\" " ;					
				if(flag=='C'){					 
					xmlStr+= "disp_location=\"" + disp_location + "\" " ;
				}
				else if(flag=='E'){
					xmlStr+= "referral_facility=\"" + referral_facility + "\" " ;
					xmlStr+= "referral_remarks=\"" + referral_remarks + "\" " ;
					xmlStr+= "practioner_id=\"" + practioner_id + "\" " ;
				}
				xmlStr +=" /></root>";

				var temp_jsp="DirectDispValidate.jsp?func_mode=orOrder";
				var xmlDoc = "" ;
				var xmlHttp = new XMLHttpRequest() ;
				xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
				xmlHttp.open("POST",temp_jsp,false);
				xmlHttp.send(xmlDoc);
				responseText=xmlHttp.responseText ;	
				eval(responseText);

				/*if(type=="OK"){
					printOnlineDispense(frmObj);
				}
				else if(type=="Cancel")
					parent.window.close();*/
				//  document.DispMedicationPrintDialog.print_report.click();  //commented for CRF-0067
				if(document.DispMedicationPrintDialog != undefined)
					document.DispMedicationPrintDialog.print_report.click();
				else
					parent.printSelectFrame.document.DispMedicationPrintDialog.print_report.click();
			}
			else{
				parent.window.returnValue='false';
				return false;
			}
		}
		else{
			//alert("type" + type);
			/*if(type=="OK")
				printOnlineDispense(frmObj);
			else if(type=="Cancel")
					parent.window.close();*/
		}
	}
	else{
		parent.window.returnValue='false';
	}
}

async function searchPractioner(obj){

	var argumentArray  = new Array() ;
	var dataNameArray  = new Array() ;
	var dataValueArray = new Array() ;
	var dataTypeArray  = new Array() ;

	var formObj = document.DispMedicationPrintDialog;
	
	argumentArray[0]   = formObj.SQL_PH_DISP_PRACT_REFERRAL_SELECT.value;
	argumentArray[1]   = dataNameArray ;
	argumentArray[2]   = dataValueArray ;
	argumentArray[3]   = dataTypeArray ;
	argumentArray[4]   = "1,2";
	argumentArray[5]   = formObj.practioner_name.value ;
	argumentArray[6]   = DESC_LINK ;
	argumentArray[7]   = DESC_CODE ; 	
	retVal = await CommonLookup( getLabel("Common.practitioner.label","Common"), argumentArray );	
	if(retVal != null && retVal != "" )  {
		formObj.practioner_name.value = retVal[1] ;
		formObj.practioner_id.value = retVal[0];
		obj.disabled	=	true;
		
	}
}

function alertoverride(){	
	alert(getMessage("OVERRIDE_REASON_NOT_BLANK","PH"));
	return_val=false;
}

async function loadDrugInfo(prodid,drugdesc){
	var dialogHeight	="35" ;
	var dialogWidth	="65";
	var dialogTop		= "110" ;
	var dialogLeft		= "70" ;

	var center			= "0" ;
	var status			="no";
	var features	= "dialogHeight:" + dialogHeight +"; dialogLeft:"+dialogLeft+ "; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop;
	var arguments	= "";
	retVal = await window.showModalDialog("../../ePH/jsp/DisplayDrugInfoFrames.jsp?extprodid="+prodid+"&drugdesc="+drugdesc+"&JSFile=../../ePH/js/Prescription_1.js",arguments,features);
}

async function viewMedicationAlert(patient_id,ext_prod_id,drug_db_interact_check_flag,drug_db_duptherapy_flag,drug_db_contraind_check_flag,drug_db_dose_check_flag,called_from,external_dosage_override_reason,drug_code,srl_no,external_duplicate_override_reason,external_interaction_override_reason,external_contra_override_reason,pract_name,external_alergy_override_reason,drug_db_dosecheck_yn,drug_db_allergy_flag){
    var drug_frmobj	= parent.parent.parent.parent.f_detail.f_ord_detail.f_drug_detail.f_drug.document.prescription_detail_form;
      
	   
	   if((drug_db_dosecheck_yn=="Y"&&called_from=='ONLOAD')){			  
			ExternalDosageCheck(called_from);
			if(called_from=='ONLOAD'){
				drug_db_dose_check_flag	=	drug_frmobj.drug_db_dose_check_flag.value;
			}
	   }
	   else if(called_from=='PRESPAD'){

           external_dosage_override_reason		= eval("document.prescription_form.external_dosage_override_reason"+srl_no).value;
		   external_duplicate_override_reason	= eval("document.prescription_form.external_duplicate_override_reason"+srl_no).value;
		   external_interaction_override_reason	= eval("document.prescription_form.external_interaction_override_reason"+srl_no).value;
		   external_contra_override_reason		= eval("document.prescription_form.external_contra_override_reason"+srl_no).value;
		   external_alergy_override_reason		= eval("document.prescription_form.external_alergy_override_reason"+srl_no).value;

	   }
	   if(drug_db_dose_check_flag==""){
		    drug_db_dose_check_flag =drug_db_dose_check_flag;
	   }


      if(called_from=='ONLOAD'){
            if(((drug_db_interact_check_flag=='Y') && (external_interaction_override_reason=="")) ||((drug_db_duptherapy_flag=='Y') && (external_duplicate_override_reason==""))||((drug_db_contraind_check_flag=='Y' )&& (external_contra_override_reason==""))||((drug_db_dose_check_flag=='Y')&& (external_dosage_override_reason==""))||((drug_db_allergy_flag=='Y')&& (external_alergy_override_reason==""))){
				callMedicationAlert(patient_id,ext_prod_id,drug_db_interact_check_flag,drug_db_duptherapy_flag,drug_db_contraind_check_flag,drug_db_dose_check_flag,external_dosage_override_reason,drug_code,srl_no,called_from,external_duplicate_override_reason,external_interaction_override_reason,external_contra_override_reason,unescape(pract_name),external_alergy_override_reason,drug_db_allergy_flag);
			}
	  }
	  else{
          if((drug_db_interact_check_flag=='Y') ||(drug_db_duptherapy_flag=='Y')||(drug_db_contraind_check_flag=='Y')||(drug_db_dose_check_flag=='Y')){
			   //if(((drug_db_interact_check_flag=='Y') && (external_interaction_override_reason=="")) ||((drug_db_duptherapy_flag=='Y') && (external_duplicate_override_reason==""))||((drug_db_contraind_check_flag=='Y' )&& (external_contra_override_reason==""))||((drug_db_dose_check_flag=='Y')&& (external_dosage_override_reason==""))){
				callMedicationAlert(patient_id,ext_prod_id,drug_db_interact_check_flag,drug_db_duptherapy_flag,drug_db_contraind_check_flag,drug_db_dose_check_flag,unescape(external_dosage_override_reason),drug_code,srl_no,called_from,unescape(external_duplicate_override_reason),unescape(external_interaction_override_reason),unescape(external_contra_override_reason),unescape(pract_name),unescape(external_alergy_override_reason),drug_db_allergy_flag);
		   }
	  }
}

async function callMedicationAlert(patient_id,ext_prod_id,drug_db_interact_check_flag,drug_db_duptherapy_flag,drug_db_contraind_check_flag,drug_db_dosecheck_flag,external_dosage_override_reason,drug_code,srl_no,called_from,external_duplicate_override_reason,external_interaction_override_reason,external_contra_override_reason,pract_name,external_alergy_override_reason,drug_db_allergy_flag){
     var alg_reason ="";
	 var drug_frmobj	= parent.parent.parent.parent.f_detail.f_ord_detail.f_drug_detail.f_drug.document.prescription_detail_form;
	// var drug_code	    = drug_frmobj.drug_code.value;
	// var srl_no		    = drug_frmobj.srl_no.value;
	if(called_from =='undefined'){
		setextdoseflag(drug_db_dosecheck_flag);
	}

    if(called_from=='PRESPAD'){
			var dialogHeight	= "85" ;
			var dialogWidth	    = "70";
			var dialogTop	    = "100" ;
			var dialogLeft	    = "100" ;
			var center			= "0" ;
			var status			= "no";
			var features	    = "dialogHeight:" + dialogHeight +"; dialogLeft:"+dialogLeft+ "; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop;
			var arguments	    = "";
				retVal          = await window.showModalDialog("../../ePH/jsp/MedicationAlerts.jsp?&patient_id="+patient_id+"&external_product_id="+ext_prod_id+"&drug_db_interact_check_flag="+drug_db_interact_check_flag+"&drug_db_duptherapy_flag="+drug_db_duptherapy_flag+"&drug_db_contraind_check_flag="+drug_db_contraind_check_flag+"&srl_no="+srl_no+"&drug_db_dosecheck_flag="+drug_db_dosecheck_flag+"&dsg_reason="+external_dosage_override_reason+"&dup_reason="+external_duplicate_override_reason+"&con_reason="+external_contra_override_reason+"&int_reason="+external_interaction_override_reason+"&alg_reason="+external_alergy_override_reason+"&pract_name="+pract_name+"&drug_db_allergy_flag="+drug_db_allergy_flag ,arguments,features);

			
			if(retVal!=null && retVal[0]!='CANCEL'){
				// var external_dosage_override_reason		=	"";
				// var external_duplicate_override_reason		=	"";
				// var external_interaction_override_reason	=	"";
				// var external_contra_override_reason		=	"";
				// var external_alergy_override_reason		=	"";
				 var reason		="";
				 var indicator	="";

				 for(i=0;i<retVal.length;i++){
					 reason=retVal[i];
					 indicator=reason.substring(0,5);
					 reason=retVal[i].substring(5,retVal[i].length);
					 if(indicator=='DSG_Y'){
							external_dosage_override_reason		=reason;
					 }else if(indicator=='DUP_Y'){
							external_duplicate_override_reason	=reason;
					 }else if(indicator=='CON_Y'){
							external_contra_override_reason		=reason;
					 }else if(indicator=='ALG_Y'){
							external_alergy_override_reason		=reason;
					 }else if(indicator=='INT_Y'){
							external_interaction_override_reason=reason;
					 }
					   
				 }
				
				if(called_from=='ONLOAD'){
					 drug_frmobj.external_dosage_override_reason.value		=	escape(external_dosage_override_reason);
					 drug_frmobj.external_duplicate_override_reason.value	=	escape(external_duplicate_override_reason);
					 drug_frmobj.external_interaction_override_reason.value	=	escape(external_interaction_override_reason);
					 drug_frmobj.external_contra_override_reason.value		=	escape(external_contra_override_reason);
					 drug_frmobj.external_Alergy_override_reason.value		=	escape(external_alergy_override_reason);
					 

				}else if(called_from=='PRESPAD'){
					  eval("document.prescription_form.external_dosage_override_reason"+srl_no).value		=	escape(external_dosage_override_reason);      
					  eval("document.prescription_form.external_duplicate_override_reason"+srl_no).value	=	escape(external_duplicate_override_reason);   
					  eval("document.prescription_form.external_interaction_override_reason"+srl_no).value	=	escape(external_interaction_override_reason); 
					  eval("document.prescription_form.external_contra_override_reason"+srl_no).value		=	escape(external_contra_override_reason);      
					  eval("document.prescription_form.external_alergy_override_reason"+srl_no).value		=	escape(external_alergy_override_reason); 

					  if(((drug_db_interact_check_flag=="Y")&&(external_interaction_override_reason==""))||((drug_db_duptherapy_flag=="Y")&&(external_duplicate_override_reason==""))||((drug_db_contraind_check_flag=="Y")&&(external_contra_override_reason==""))||((drug_db_dosecheck_flag=="Y")&&(external_dosage_override_reason==""))){
								
								eval("document.prescription_form.external_img"+srl_no).style.visibility ="visible";

						}else{
								 eval("document.prescription_form.external_img"+srl_no).style.visibility="hidden";
						}  

			   }else{
					 drug_frmobj.external_dosage_override_reason.value		=	escape(external_dosage_override_reason);
			   }			 


				 var fldString = " drug_code=\""+ drug_code + "\" ";
					 fldString += " srl_no=\""+ srl_no + "\" ";	
					 fldString += " External_Dosage_Override_Reason=\""+ escape(external_dosage_override_reason) + "\" ";	
					 fldString += " External_Duplicate_Override_Reason=\""+ escape(external_duplicate_override_reason) + "\" ";	
					 fldString += " External_Interaction_Override_Reason=\""+ escape(external_interaction_override_reason) + "\" ";	
					 fldString += " External_Contra_Override_Reason=\""+ escape(external_contra_override_reason) + "\" ";	
					 fldString += " External_Alergy_Override_Reason=\""+ escape(external_alergy_override_reason) + "\" ";	
					 fldString += " called_from=\""+ called_from + "\" ";	
					
					var formobj=drug_frmobj;
					var xmlStr=formXMLString(formobj,fldString);
					fieldValidation(xmlStr,"InsertExternalOverrideReason");
					
			}
		}
}

function ExternalDosageCheck(called_from){
	//alert("called external check");
    var formObject			= parent.parent.parent.parent.f_detail.f_header.document.dir_disp_header_form;
    var drug_frmobj		    = parent.parent.parent.parent.f_detail.f_ord_detail.f_drug_detail.f_drug.document.prescription_detail_form;
	var external_prod_id    = drug_frmobj.external_product_id.value;
    var drug_db_dosechk_yn  = formObject.drug_db_dosecheck_yn.value;
	    
	if((external_prod_id!='') && (drug_db_dosechk_yn=="Y")){
		var patient_id						= drug_frmobj.patient_id.value;
		var weight							= formObject.weight.value;
		if(weight=="")
			weight="0";
		var bsa								= formObject.bsa.value;
		if(bsa=="")
			bsa="0";
		var dose							= drug_frmobj.qty_value.value;
		var dosage_by						= drug_frmobj.dosage.value;
		var dose_uom						= "";

		if(dosage_by=='S'){
			dose_uom    =  drug_frmobj.pres_base_uom.value;
		}
		else{
			dose_uom   =  drug_frmobj.qty_desc.value;
		}

		var repeat_value					= drug_frmobj.repeat_value.value;
		if(repeat_value=="")
			repeat_value="0";

		var interval_value					= drug_frmobj.interval_value.value;
		if(interval_value=="")
			interval_value="1";

		var durn_value						= drug_frmobj.durn_value.value; 
		var drug_code						= drug_frmobj.drug_code.value; 
		var srl_no							= drug_frmobj.srl_no.value; 
		var strength_per_pres_uom			= drug_frmobj.strength_per_pres_uom.value; 
		var strength_per_value_pres_uom		= drug_frmobj.strength_per_value_pres_uom.value; 
		var fract_dose_round_up_yn			= drug_frmobj.fract_dose_round_up_yn.value; 
		var split_dose_yn					= drug_frmobj.split_dose_yn_val.value; 
		var external_dosage_override_reason	= drug_frmobj.external_dosage_override_reason.value;
		var pract_name						= drug_frmobj.pract_name.value 
		var route_code						= drug_frmobj.route_code.value; // Added in January 2014 for CIMS dosage check -start
		var qty_desc_code					= drug_frmobj.qty_desc.value; 
		var repeat_durn_type				= drug_frmobj.repeat_durn_type.value; 
		var freq_nature						= drug_frmobj.freq_nature.value; // Added in January 2014 for CIMS dosage check -End

		var fldString =  " patient_id=\""+ patient_id + "\" ";
		fldString +=  "external_prod_id=\""+ external_prod_id +"\" ";
		fldString += " weight=\""+ weight + "\" ";	
		fldString += " bsa=\""+ bsa + "\" ";	
		fldString += " dose=\""+ dose + "\" ";	
		fldString += " dosage_by=\""+ dosage_by + "\" ";	
		fldString += " dose_uom=\""+ dose_uom + "\" ";	
		fldString += " repeat_value=\""+ repeat_value + "\" ";	
		fldString += " interval_value=\""+ interval_value + "\" ";	
		fldString += " durn_value=\""+ durn_value + "\" ";	
		fldString += " drug_code=\""+ drug_code + "\" ";	
		fldString += " srl_no=\""+ srl_no + "\" ";	
		fldString += " strength_per_pres_uom=\""+ strength_per_pres_uom + "\" ";	
		fldString += " strength_per_value_pres_uom=\""+ strength_per_value_pres_uom + "\" ";	
		fldString += " fract_dose_round_up_yn=\""+ fract_dose_round_up_yn + "\" ";	
		fldString += " split_dose_yn=\""+ split_dose_yn + "\" ";
		fldString += " called_from=\""+ called_from + "\" ";
		fldString += " external_dosage_override_reason=\""+ unescape(external_dosage_override_reason) + "\" ";
		fldString += " pract_name=\""+ pract_name + "\" ";
		fldString+= "route_code=\"" + route_code + "\" " ; // Added in January 2014 for CIMS dosage check -start
		fldString+= "qty_desc_code=\"" + qty_desc_code + "\" " ;
		fldString+= "repeat_durn_type=\"" + repeat_durn_type + "\" " ;
		fldString+= "freq_nature=\"" + freq_nature + "\" " ;  //Added in January 2014, CIMS Dosage Check -end
		var formobj	=	drug_frmobj;
		var xmlStr	=	formXMLString(formobj,fldString);
		fieldValidation(xmlStr,"ExternalDoseCheck");
	}
}	


function setextdoseflag(drug_db_dose_check_flag){
      var drug_frmobj	    = parent.parent.parent.parent.f_detail.f_ord_detail.f_drug_detail.f_drug.document.prescription_detail_form;
      drug_frmobj.drug_db_dose_check_flag.value	=	drug_db_dose_check_flag;
}

function validateCheck(obj,no) {
	if(obj.checked==false) {
	obj	=	eval("document.Directdispensingallocateform.issue_qty_"+no);
	obj.value	=	"";
	}
}

async function callIncludeExclude(recnum,drug_code){
	var  patient_id     =  document.DirectDispDispensingDetails.patient_id.value;
	var  encounter_id   =  document.DirectDispDispensingDetails.encounter_id.value;
	var  sal_trn_type   =  document.DirectDispDispensingDetails.sal_trn_type.value;
	var  sysdate        =  document.DirectDispDispensingDetails.sysdate.value;
	var  store_code     =  document.DirectDispDispensingDetails.store_code.value;	  

	var override_allowed_yn				 = eval("document.DirectDispDispensingDetails.override_allowed_yn_"+recnum).value;
	var excl_incl_ind						 = eval("document.DirectDispDispensingDetails.excl_incl_ind_"+recnum).value;
	var approval_reqd_yn					 = eval("document.DirectDispDispensingDetails.approval_reqd_yn_"+recnum).value;
	var bl_incl_excl_override_reason_desc  = eval("document.DirectDispDispensingDetails.bl_incl_excl_override_reason_desc_"+recnum).value;
	var bl_incl_excl_override_reason_code  = eval("document.DirectDispDispensingDetails.bl_incl_excl_override_reason_code_"+recnum).value;
	var excl_incl_ind_default			     = eval("document.DirectDispDispensingDetails.excl_incl_ind_default_"+recnum).value;
	var tot_alloc_qty 					 = eval("document.DirectDispDispensingDetails.tot_alloc_qty_"+recnum).value;	
	var batch_str						     = eval("document.DirectDispDispensingDetails.batch_str_"+recnum).value;	
	var dialogHeight	= "25vh" ;
	var dialogWidth	    = "50vw";
	var dialogTop	    = "10" ;
	var dialogLeft	    = "10" ;
	var center			= "0" ;
	var status			= "no";
	var scroll			= "no";
	var features	    = "dialogHeight:" + dialogHeight +"; dialogLeft:"+dialogLeft+ "; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop+ ";scroll "+scroll;
	var arguments	    = "";
	retVal          = await top.window.showModalDialog("../../ePH/jsp/BillingIncludeExclude.jsp?override_allowed_yn="+override_allowed_yn+"&excl_incl_ind="+excl_incl_ind+"&approval_reqd_yn="+approval_reqd_yn+"&bl_incl_excl_override_reason_desc="+encodeURIComponent(bl_incl_excl_override_reason_desc)+"&bl_incl_excl_override_reason_code="+bl_incl_excl_override_reason_code+"&recnum="+recnum+"&excl_incl_ind_default="+excl_incl_ind_default ,arguments,features);

	if(retVal!=undefined && retVal!="") {
		var billing_vals	=	retVal.split("::");

		var excl_incl_ind					 =billing_vals[1];
		var bl_incl_excl_override_reason_code =billing_vals[2];
		var bl_incl_excl_override_reason_desc =billing_vals[3];

		eval("document.DirectDispDispensingDetails.excl_incl_ind_"+recnum).value					 = excl_incl_ind;
		eval("document.DirectDispDispensingDetails.bl_incl_excl_override_reason_code_"+recnum).value = bl_incl_excl_override_reason_code;
		eval("document.DirectDispDispensingDetails.bl_incl_excl_override_reason_desc_"+recnum).value = bl_incl_excl_override_reason_desc;
		   
		if(excl_incl_ind!=''){
			if(excl_incl_ind=='SEL') 
				excl_incl_ind ="";

			var xmlStr ="<root><SEARCH ";										
			xmlStr+= "bean_id =\"" + document.DirectDispDispensingDetails.bean_id.value + "\" " ;
			xmlStr+= "bean_name=\"" + document.DirectDispDispensingDetails.bean_name.value + "\" " ;	
			xmlStr+= "Srl_no=\"" + recnum + "\" " ;	
			xmlStr+= "drug_code=\"" + drug_code + "\" " ;
			xmlStr+= "excl_incl_ind=\"" + excl_incl_ind + "\" " ;	
			xmlStr+= "bl_incl_excl_override_reason_code=\"" + bl_incl_excl_override_reason_code + "\" " ;	
			xmlStr+= "bl_incl_excl_override_reason_desc=\"" + encodeURIComponent(bl_incl_excl_override_reason_desc) + "\" " ;
			xmlStr+= "tot_alloc_qty=\"" + tot_alloc_qty + "\" " ;
			xmlStr+= "patient_id=\"" + patient_id + "\" " ;
			xmlStr+= "encounter_id=\"" + encounter_id + "\" " ;
			xmlStr+= "sal_trn_type=\"" + sal_trn_type + "\" " ;
			xmlStr+= "sysdate=\"" + sysdate + "\" " ;
			xmlStr+= "store_code=\"" + store_code + "\" " ;
			xmlStr+= "batch_str=\"" + batch_str + "\" " ;
			xmlStr +=" /></root>";		
			var temp_jsp="DirectDispValidate.jsp?func_mode=StoreBillingDetails";
			var xmlHttp = new XMLHttpRequest() ;
			var xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
			xmlHttp.open("POST",temp_jsp,false);
			xmlHttp.send(xmlDoc);
			responseText=xmlHttp.responseText ;	
			eval(responseText);
		}
	}
}


function searchBLOverrideReason(locale){
	var formObj=document.BlincludeexcludeForm;
	var argumentArray  = new Array();
	var dataNameArray  = new Array();
	var dataValueArray = new Array();
	var dataTypeArray  = new Array();
	var sql1 = formObj.sql_ph_prescription_bl_action_select_lookup.value;

	dataNameArray[0]	="a.language_id";
	dataValueArray[0]	=locale;
	dataTypeArray[0]	=STRING;

	argumentArray[0]	= sql1;
	argumentArray[1]   = dataNameArray ;
	argumentArray[2]   = dataValueArray ;
	argumentArray[3]   = dataTypeArray ;
	argumentArray[4]   = "2,3";
	argumentArray[5]   = formObj.bl_incl_excl_override_reason_desc.value ;
	argumentArray[6]   = CODE_LINK ;
	argumentArray[7]   = CODE_DESC ;
	

	retVal = CommonLookup(getLabel("Common.search.label","Common"), argumentArray);
	if(retVal != null && retVal != "") {
		formObj.bl_incl_excl_override_reason_code.value = retVal[0];
		formObj.bl_incl_excl_override_reason_desc.value =retVal[1] ;
	}
}

function assignOverrideExclInclInd(obj){
	/*if(obj.checked == true){
		obj.value = "I";
	}
	else{
		obj.value = "E";
	}*/
    var formObj=document.BlincludeexcludeForm;

	var bl_def_override_excl_incl_ind = formObj.bl_def_override_excl_incl_ind.value

	//if(bl_def_override_excl_incl_ind != obj.value){
	if( obj.value!='SEL'){
		document.getElementById("bl_overriden_action_reason_img").style.visibility='visible';
		formObj.bl_overriden_action_reason_lkp.disabled=false;
	}else{		
		document.getElementById("bl_overriden_action_reason_img").style.visibility='hidden';
		formObj.bl_overriden_action_reason_lkp.disabled=true;
		formObj.bl_incl_excl_override_reason_code.value = "";
		formObj.bl_incl_excl_override_reason_desc.value = "" ;
	}	
}

function savedetails(){

    var formObj								= document.BlincludeexcludeForm; 

	if(formObj.bl_overriden_action_reason_img.style.visibility=="visible"){
		if(formObj.override_allowed_yn.value !=''){
			if(formObj.bl_incl_excl_override_reason_code.value == ""){
				alert(getMessage("INCL_EXCL_OVERRIDE_REASON_CANNOT_BE_BLANK","PH"));
				return false;
			}
		}
	}

	var recnum								= formObj.recnum.value;
	var bl_incl_excl_override_reason_code   = formObj.bl_incl_excl_override_reason_code.value;
	var bl_incl_excl_override_reason_desc   = formObj.bl_incl_excl_override_reason_desc.value;
    var bl_override_excl_incl_ind			= formObj.bl_override_excl_incl_ind.value;
     
    var ret_val=recnum+"::"+bl_override_excl_incl_ind+"::"+bl_incl_excl_override_reason_code+"::"+bl_incl_excl_override_reason_desc;
	
	//parent.window.close();
	//parent.window.returnValue = ret_val;  
   // parent.parent.document.getElementById('dialog-body').contentWindow.returnValue = ret_val;  
   // parent.parent.document.getElementById('dialog_tag').close(); 
    parent.parent.document.querySelectorAll('#dialog-body')[parent.parent.document.querySelectorAll('#dialog-body').length-1].contentWindow.returnValue=ret_val; 
    parent.parent.document.querySelectorAll('#dialog_tag')[parent.parent.document.querySelectorAll('#dialog_tag').length-1].close();

}
function setBillingAmounts(srl_no,gross_charge_amount,groos_pat_payable,gross_charge_amount_payable){
	//alert("gross_charge_amount="+gross_charge_amount+",groos_pat_payable="+groos_pat_payable);
	eval(document.getElementById("gross_charge_amount_"+srl_no)).innerHTML	="<label style='font-size:9;color:black'>&nbsp;"+gross_charge_amount+"</label>"
    eval(document.getElementById("pat_charge_amount_"+srl_no)).innerHTML	="<label style='font-size:9;color:black'>&nbsp;"+groos_pat_payable+"</label>"
    eval(document.getElementById("gross_charge_amount_payable_"+srl_no)).innerHTML	="<label style='font-size:9;color:black'>&nbsp;"+gross_charge_amount_payable+"</label>"
}

function calldispbuttonsframes(tot_gross_charge_amount_str,tot_groos_pat_payable_str,tot_gross_charge_amount_payable_str){
       
	parent.parent.parent.f_detail.f_disp_detail.f_button3.location.href="../../ePH/jsp/DirectDispButtons_3.jsp?tot_gross_charge_amount_str="+tot_gross_charge_amount_str+"&tot_groos_pat_payable_str="+tot_groos_pat_payable_str+"&tot_gross_charge_amount_payable_str="+tot_gross_charge_amount_payable_str;
}




function setBillingTotalAmounts(tot_gross_charge_amount_str,tot_groos_pat_payable_str,tot_gross_charge_amount_payable_str){
	eval(parent.parent.parent.f_detail.f_disp_detail.f_button3.document.getElementById("total_payable")).innerHTML	  = getLabel("eBL.TOTAL_PAYABLE.label","BL")+" : "+tot_gross_charge_amount_str;
    eval(parent.parent.parent.f_detail.f_disp_detail.f_button3.document.getElementById("patient_payable")).innerHTML = getLabel("Common.PatientPayable.label","Common")+" : "+tot_groos_pat_payable_str;
    eval(parent.parent.parent.f_detail.f_disp_detail.f_button3.document.getElementById("total_gross_payable")).innerHTML = getLabel("Common.GrossPayable.label","Common")+" : "+tot_gross_charge_amount_payable_str;
}

async function callADRdetails(patient_id){
	var dialogHeight= "900px" ;
	var dialogWidth	= "1300px" ;
	var dialogTop = "10" ;
	var dialogLeft = "20" ;
	var center = "1" ;
	var status="no";
	var scroll="no";
	var features	= "dialogLeft:" + dialogLeft + ";dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; center: " + center + ";scroll "+scroll+"; status: " + status + "; dialogTop :" + dialogTop;
	var arguments	= "" ;
	retVal = await window.showModalDialog("../../ePH/jsp/AdrReportingFrame_1.jsp?type=query "+"&status=S"+"&patient_id="+patient_id ,arguments,features);
}

async function callMedicalItemdetails(patient_id,encounter_id,billing_interface_yn,disp_locn_code,bl_patient_class,sysdate,store_desc){
	var dialogHeight	= "600px" ;
	var dialogWidth	    = "1200px";
	var dialogTop	    = "650" ;
	var dialogLeft	    = "30" ;
	var center			= "0" ;
	var status			= "no";
	var scroll			= "no";
	var features	    = "dialogHeight:" + dialogHeight +"; dialogLeft:"+dialogLeft+ "; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop+ ";scroll "+scroll;
	var arguments	    = "";
	//added top.window.showModalDialog by Vedesh A D for EDGE Conversion
	retVal          =  await top.window.showModalDialog("../../ePH/jsp/DirectDispensingConsumables.jsp?patient_id="+patient_id+"&encounter_id="+encounter_id+"&billing_interface_yn="+billing_interface_yn+"&disp_locn_code="+disp_locn_code+"&bl_patient_class="+bl_patient_class+"&sysdate="+sysdate+"&store_desc="+unescape(encodeURIComponent(store_desc)) ,arguments,features);
	
	//Added for MMS AdhocTesting-Start
	if(retVal!=undefined && retVal!=''){
		var	tot_gross_charge_amount_drug	  = "0";
		var	tot_groos_pat_payable_drug		  = "0";
		var tot_groos_amt_drug                = "0"; // Added for ML-BRU-CRF-0469 [IN:065426]
		if(parent.parent.parent.f_detail.f_disp_detail.f_button3.prescription_button) {
			tot_gross_charge_amount_drug	  = parent.parent.parent.f_detail.f_disp_detail.f_button3.prescription_button.tot_gross_charge_amount.value;
			tot_groos_pat_payable_drug		  = parent.parent.parent.f_detail.f_disp_detail.f_button3.prescription_button.tot_groos_pat_payable.value;
			tot_groos_amt_drug                = parent.parent.parent.f_detail.f_disp_detail.f_button3.prescription_button.tot_gross_charge_amount_payable.value; // Added for ML-BRU-CRF-0469 [IN:065426]
			record								= retVal.split("|");
			tot_gross_charge_amount				= record[0];
			tot_groos_pat_payable				= record[1];
			tot_groos_amt                       = record[2]; // Added for ML-BRU-CRF-0469 [IN:065426]
			var tot_charge_amount_medical	   = parseFloat(tot_gross_charge_amount_drug)+parseFloat(tot_gross_charge_amount);
			var tot_groos_pat_payable_medical  = parseFloat(tot_groos_pat_payable_drug)+parseFloat(tot_groos_pat_payable);
			var tot_groos_amt_medical          = parseFloat(tot_groos_amt_drug)+parseFloat(tot_groos_amt); // Added for ML-BRU-CRF-0469 [IN:065426] 
			tot_charge_amount_medical			=(tot_charge_amount_medical).toFixed(2);
			tot_groos_pat_payable_medical		=(tot_groos_pat_payable_medical).toFixed(2);
			tot_groos_amt_medical               = (tot_groos_amt_medical).toFixed(2); // Added for ML-BRU-CRF-0469 [IN:065426]
			eval(parent.parent.parent.f_detail.f_disp_detail.f_button3.document.getElementById('total_payable')).innerHTML = getLabel("eBL.TOTAL_PAYABLE.label","BL")+" : "+tot_charge_amount_medical;
			eval(parent.parent.parent.f_detail.f_disp_detail.f_button3.document.getElementById('patient_payable')).innerHTML = getLabel("Common.PatientPayable.label","Common")+" : "+tot_groos_pat_payable_medical;
		if(parent.parent.parent.f_detail.f_disp_detail.f_button3.document.getElementById('displayGrossAmtYn')!=undefined && parent.parent.parent.f_detail.f_disp_detail.f_button3.document.getElementById('displayGrossAmtYn').value){ // Added for ML-BRU-CRF-0469 [IN:065426] - Start
				eval(parent.parent.parent.f_detail.f_disp_detail.f_button3.document.getElementById('total_gross_payable')).innerHTML = getLabel("ePH.TotalGrossAmount.label","PH")+" : "+tot_groos_amt_medical;
		} // Added for ML-BRU-CRF-0469 [IN:065426] - End
		 }
	}//Added for MMS AdhocTesting-End
}

function showMessage(){
	alert(getMessage('NO_ORDER_FOR_DISP','PH'));
	clearframes();
}

function validmaxlength(obj){

	var 	field_label = getLabel("Common.PatientInstructions.label","Common");
	if(!SPCheckMaxLen(field_label,obj,150)){
		obj.select();
		obj.focus();
	}
}


function searchDrugName(drugNameObj){
	var bean_id="DirectDispensingBean";
	var bean_name="ePH.DirectDispensingBean";
	xmlStr	 ="<root><SEARCH " ;
	xmlStr	+=" bean_id=\""+ bean_id + "\" ";
	xmlStr	+=" bean_name=\""+ bean_name + "\" ";
	xmlStr	+=" /></root>" ;	
	fieldValidation(xmlStr,"callSearch");
}

function issueUOM(obj,drug_code,srl_no){
	var issueUom_code_value = obj.value;
	var issueuomarray		= issueUom_code_value.split("_");
	var iss_qty_uom			= issueuomarray[0];
	var iss_qty_eq_val		= issueuomarray[1];
	var iss_qty_uom_desc	= issueuomarray[2];

	var bean_id="DirectDispensingBean";
	var bean_name="ePH.DirectDispensingBean";
	xmlStr	 ="<root><SEARCH " ;
	xmlStr	+=" bean_id=\""+ bean_id + "\" ";
	xmlStr	+=" bean_name=\""+ bean_name + "\" ";
	xmlStr	+=" drug_code=\""+ drug_code + "\" ";
	xmlStr	+=" srl_no=\""+ srl_no + "\" ";
	xmlStr	+=" issue_uom=\""+ iss_qty_uom + "\" ";
	xmlStr	+=" /></root>" ;	
	fieldValidation(xmlStr,"IssueUom");
	loadallocatedetail('allocate','ONCLICK');
}

function setQtyBsdOnIssueUOM(obj,no){
	var qty							 = obj.value;
	var formObj						 = document.Directdispensingallocateform;
	var issueUom_code_value			 = formObj.issue_uom_select.value;
	var issueuomarray				 = issueUom_code_value.split("_");
	var iss_qty_uom					 = issueuomarray[0];
	var iss_qty_eq_val				 = issueuomarray[1];
	var iss_qty_uom_desc			 = issueuomarray[2];
	var act_stk_equval_value		 = issueuomarray[3];
	var base_to_disp_uom_equl_val	 = formObj.base_to_disp_uom_equl_val.value;
	var base_to_def_uom_equl_val     = formObj.base_to_orig_def_uom_equl_val.value;
    var issuebyuom					 = formObj.issuebyuom.value;
	var issue_qty					 = eval("formObj.issue_qty_"+no);//allocated quantity
	var issue_qty_old				 = eval("formObj.issue_qty_old"+no);//old allocated quantity
	var issue_uom_lbl				 = eval(document.getElementById('issue_uom_lbl_'+no));
	var issue_uom_qty				 = eval("formObj.issue_uom_qty"+no);
	var issue_uom_uom				 = eval("formObj.issue_uom_uom"+no);
	var issue_uom_desc				 = eval("formObj.issue_uom_desc"+no);
	    avail_qty	                 = parseInt(eval("formObj.alloc_qty_"+no+".value"));
	if(formObj.issuebyuom.value=="I")// && base_to_disp_uom_equl_val == base_to_def_uom_equl_val)//if else Added for AAKH-SCF-0103 [IN:047628] //&& base_to_disp_uom_equl_val == base_to_def_uom_equl_val Added for AAKH-SCF-0113[IN:048937]
		var conv_factor = CalculateConversionfactor(iss_qty_eq_val,iss_qty_eq_val,base_to_disp_uom_equl_val);
	else
		var conv_factor = CalculateConversionfactor(base_to_def_uom_equl_val,iss_qty_eq_val,base_to_disp_uom_equl_val);

	if(issueUom_code_value != ""){
       	//var conv_factor		=	lcm(base_to_def_uom_equl_val, iss_qty_eq_val);//commented for AAKH-SCF-0189 [IN:054663] 
       	//var conv_factor		=	lcm(act_stk_equval_value, iss_qty_eq_val);//added for AAKH-SCF-0189 [IN:054663]
	    //conv_factor			=	lcm(conv_factor, base_to_disp_uom_equl_val);
		if(((qty*base_to_disp_uom_equl_val)%conv_factor) != '0'){
			alert(getMessage("PH_ISSUE_UOM_MUL","PH")+(conv_factor/base_to_disp_uom_equl_val));
			eval("formObj.issue_qty_"+no).focus();	// Validation for quantity change 
			return;
		}
		var issue_qty_val_1="";
		var alloc_qty       ="";
		if(iss_qty_eq_val!=base_to_disp_uom_equl_val){//base_to_disp_uom_equl_val
			var alloc_qty       = Math.ceil(((Math.ceil((qty*base_to_disp_uom_equl_val)/conv_factor))*(conv_factor))/base_to_disp_uom_equl_val);//to calculte allocated quantity 
			//var issue_qty_val_1	= Math.ceil(((Math.ceil((qty*base_to_disp_uom_equl_val)/conv_factor))*(conv_factor))/iss_qty_eq_val);//to
		    issue_qty_val_1	= Math.ceil(((Math.ceil((qty*base_to_disp_uom_equl_val)/conv_factor))*(conv_factor))/act_stk_equval_value);//to
		}
		else{
            issue_qty_val_1 =qty;
			alloc_qty=qty;
		}
	    if(alloc_qty > avail_qty) {
			alert(getMessage("PH_ALLOC_QTY_LESS_AVAIL_QTY","PH"));
			obj.value="0";
			//obj.disabled=true;			
			//obj.select();
		}
		else{
		    issue_qty.value				= alloc_qty;
			 if(issuebyuom=='I'){
			    issue_uom_lbl.innerHTML		= "<b>( "+issue_qty_val_1+" "+iss_qty_uom_desc+" )</b>";
			 }
			issue_uom_qty.value			= issue_qty_val_1;
			issue_uom_uom.value			= iss_qty_uom;
			issue_uom_desc.value		= iss_qty_uom_desc;
		}
	}
}


function CalculateConversionfactor(base_to_def_uom_equl_val,iss_qty_eq_val,base_to_disp_uom_equl_val){
  var conv_factor="";
	if(parseInt(base_to_def_uom_equl_val)!=0 &&parseInt(base_to_disp_uom_equl_val)!=0){
	    var conv_factor = lcm(base_to_def_uom_equl_val, iss_qty_eq_val);	
		    conv_factor = lcm(conv_factor, base_to_disp_uom_equl_val);
	}			
		return conv_factor;
}

function lcm(frm_tmp, to_tmp) {
	var lowest = frm_tmp < to_tmp ? frm_tmp : to_tmp;
	var hcd = 1;
	for (var i = lowest; i > 1; i--) {
		if (frm_tmp % i == 0 && to_tmp % i == 0) {
			hcd = i;
			break;
		}
	}
	var lcm = (frm_tmp * to_tmp) / hcd;
	return lcm;
}

function loadCmb(obj){
//	var bean_id		= parent.frames[2].f_detail.document.DireciDispensingEditLabel.bean_id.value
	var bean_id		= document.DireciDispensingEditLabel.bean_id.value;
	
//	var bean_name	= parent.frames[2].f_detail.document.DireciDispensingEditLabel.bean_name.value	
	var bean_name	= document.DireciDispensingEditLabel.bean_name.value	
	var CmbSelVal = obj.options[obj.selectedIndex].value;
	var varguments =  "xcludeRecInCmb&selCmbVal="+CmbSelVal;
	varguments+= "&cmbLoad=caution_label_test_id_1";

	var xmlStr ="<root><SEARCH ";
	xmlStr += " bean_id=\""+bean_id+"\"";
	xmlStr += " bean_name=\""+bean_name+"\"";
	xmlStr +=" /></root>";
 //fieldValidation(xmlStr,varguments);

}

function asgnLocCAU(label_text_loc_lang){
	
	document.DireciDispensingEditLabel.loc_caution_1.value = label_text_loc_lang;
}

function loadCmbSplInstr(obj){
	var bean_id		= document.DireciDispensingEditLabel.bean_id.value	
	var bean_name	= document.DireciDispensingEditLabel.bean_name.value	
	var CmbSelVal = obj.options[obj.selectedIndex].value;
	
	var varguments =  "xcludeRecInCmbSplInstr&selCmbVal="+CmbSelVal;
	varguments+= "&cmbLoad=spl_instr_label_text_id";

	var xmlStr ="<root><SEARCH ";
	xmlStr += " bean_id=\""+bean_id+"\"";
	xmlStr += " bean_name=\""+bean_name+"\"";
	xmlStr +=" /></root>";

	//fieldValidation(xmlStr,varguments);
}
 function asgnLocSPL(label_text_loc_lang){

	document.DireciDispensingEditLabel.loc_special_1.value = label_text_loc_lang;
}
 

function getlocalinstruction(obj,srlNo,label_text_type){
		var bean_id="DirectDispensingBean";
		var bean_name="ePH.DirectDispensingBean";
		    xmlStr	 ="<root><SEARCH " ;
			xmlStr	+=" bean_id=\""+ bean_id + "\" ";
			xmlStr	+=" bean_name=\""+ bean_name + "\" ";
			xmlStr	+=" label_id=\""+ obj.value + "\" ";
			xmlStr	+=" srlNo=\""+ srlNo + "\" ";
			xmlStr	+=" label_text_type=\""+ label_text_type + "\" ";
			xmlStr	+=" /></root>" ;	
		    fieldValidation(xmlStr,"GetLocalInstrunction");		
}

function setLocalInstrunction(localinstrunction,srlNo,label_text_type){
var srlNo = parseInt(srlNo);  //newly added for RUT-CRF-0067

	if(label_text_type=='S'){
  //         document.DireciDispensingEditLabel.loc_special_1.value=localinstrunction;	
  eval("document.DireciDispensingEditLabel.loc_special_1_"+srlNo).value=localinstrunction;		// added the srlNo for CRF-0067

	}else{
//          document.DireciDispensingEditLabel.loc_caution_1.value=localinstrunction;
  eval("document.DireciDispensingEditLabel.loc_caution_1_"+srlNo).value=localinstrunction;  // added the srlNo for CRF-0067
	}
}


var durn_type_list	=	new Array();

function assignDurnTypeList(DurnDescDetails){
	durn_type_list = DurnDescDetails.substring(1,DurnDescDetails.length-1);
}

function reloadDurnTypeList(onclick_flag, callFrom){
	if(onclick_flag==undefined)
		onclick_flag='Y';
	var repeat_durn_type = document.prescription_detail_form.repeat_durn_type.value;
	if(durn_type_list!=""){
		var durnTypeList = durn_type_list.split(",");
		clearDurationTypeList();
		var durn_type_value = "";
		var durn_type_code  = "";
		for(i=0;i<durnTypeList.length;i++){
			durn_type_value = durnTypeList[i].split("=");
			durn_type_code = trimString(durn_type_value[0]);
		
			if(repeat_durn_type == 'M'){
				if(durn_type_code == 'M' || durn_type_code == 'H' || durn_type_code == 'D' || durn_type_code == 'W' ){
					addDurationTypeList(durn_type_code,durn_type_value[1],repeat_durn_type);			
					//|| durn_type_code == 'L' || durn_type_code == 'Y'
				}
			} 
			else if(repeat_durn_type == 'H'){
				if(durn_type_code == 'H' || durn_type_code == 'D' || durn_type_code == 'W' ){
					addDurationTypeList(durn_type_code,durn_type_value[1],repeat_durn_type);
					//|| durn_type_code == 'L' || durn_type_code == 'Y'
				}
			} 
			else if(repeat_durn_type == 'D'){
				if(durn_type_code == 'D' || durn_type_code == 'W' || durn_type_code == 'L' || durn_type_code == 'Y'){
					addDurationTypeList(durn_type_code,durn_type_value[1],repeat_durn_type);			
				}
			} 
			else if(repeat_durn_type == 'W'){
				if(durn_type_code == 'W' || durn_type_code == 'L' || durn_type_code == 'Y'){
					addDurationTypeList(durn_type_code,durn_type_value[1],repeat_durn_type);			
				}
			} 
			else if(repeat_durn_type == 'L'){
				if(durn_type_code == 'L' || durn_type_code == 'Y'){
					addDurationTypeList(durn_type_code,durn_type_value[1],repeat_durn_type);			
				}
			}
		}
		dfltDurnDesc(repeat_durn_type);
		validateDuration(document.prescription_detail_form.durn_value,onclick_flag, callFrom);
	}
}

function clearDurationTypeList(){
	var len =document.prescription_detail_form.durn_desc.options.length;
	for(var i=0;i<len;i++) {
		document.prescription_detail_form.durn_desc.remove("durn_desc") ;
	}
}

function addDurationTypeList(code,desc,default_val)	{
	var element = document.createElement('OPTION') ;
	element.value		=  code ;
	element.text		= desc ;
	if(default_val!=''){
		if(code==default_val)	{
			element.selected	=	true;
		}
		document.prescription_detail_form.durn_desc.add(element);
	}
}
function durationConversn(obj,calledfrm,onclick_flag){
	if(onclick_flag==undefined)
		onclick_flag='Y';
	var durn_value = document.prescription_detail_form.durn_value.value;
	var freq_nature = document.prescription_detail_form.freq_nature.value;
	var repeat_durn_type = "";
	var tmp_durn_value   = "";
	if(freq_nature != "P" || freq_nature != 'O'){
		repeat_durn_type = document.prescription_detail_form.repeat_durn_type.value;
		if(repeat_durn_type == 'M'){
			if(obj.value == 'H')
				tmp_durn_value   = (durn_value * 60);	
			else if(obj.value == 'D')
				tmp_durn_value   = (durn_value * 24 * 60);	
			else if(obj.value == 'W')
				tmp_durn_value   = (durn_value * 7 * 24 * 60);	
			else if(obj.value == 'L')
				tmp_durn_value   = (durn_value * 30 * 24 * 60);	
			else if(obj.value == 'Y')
				tmp_durn_value   = (durn_value * 365 * 24 * 60);	
		}
		else if(repeat_durn_type == 'H'){
			if(obj.value == 'D')
				tmp_durn_value   = (durn_value * 24);	
			else if(obj.value == 'W')
				tmp_durn_value   = (durn_value * 7 * 24);	
			else if(obj.value == 'L')
				tmp_durn_value   = (durn_value * 30 * 24);	
			else if(obj.value == 'Y')
				tmp_durn_value   = (durn_value * 365 * 24);	
		}
		else if(repeat_durn_type == 'D'){
			if(obj.value == 'W')
				tmp_durn_value   = (durn_value * 7);				
			else if(obj.value == 'L')
				tmp_durn_value   = (durn_value * 30);	
			else if(obj.value == 'Y')
				tmp_durn_value   = (durn_value * 365);	
		}
		else if(repeat_durn_type == 'W'){
			if(obj.value == 'L')
				tmp_durn_value   = (durn_value * 4);	
			else if(obj.value == 'Y')
				tmp_durn_value   = (durn_value * 52);	
		}
		document.prescription_detail_form.tmp_durn_value.value = tmp_durn_value;
		document.prescription_detail_form.tmp_durn_desc.value = document.prescription_detail_form.repeat_durn_type.value;		
		if(calledfrm=="form"){
			validateDuration(document.prescription_detail_form.durn_value,onclick_flag);
		}
	}
}

function validateAllDates(){
	var durn_value=document.prescription_detail_form.durn_value.value;
	var source=document.prescription_detail_form.source.value;
	var freq_chng_durn_desc = document.prescription_detail_form.durn_desc.value;
	var freq_chng_durn_value= document.prescription_detail_form.durn_value.value;
	if(durn_value!=""){
		var drug_code=document.prescription_detail_form.drug_code.value;
		var patient_class=document.prescription_detail_form.patient_class.value;

		var srlNo=document.prescription_detail_form.srl_no.value;
		if(patient_class=="IP"){
			//if(parent.f_header.document.prescription_header_form.take_home_medication.value=="Y")
				patient_class="OP";
		}
		var fldString=" durn_value=\""+ durn_value + "\" ";
		fldString += " drug_code=\""+ drug_code + "\" ";
		fldString += " patient_class=\""+ patient_class + "\" ";
		fldString += " source=\""+ source + "\" ";
		fldString += " srlNo=\""+ srlNo + "\" ";
		fldString += " freq_chng_durn_desc=\""+ freq_chng_durn_desc + "\" ";
		fldString += " freq_chng_durn_value=\""+ freq_chng_durn_value + "\" ";
		var formobj=document.prescription_detail_form;
		var xmlStr=formXMLString(formobj,fldString);
		return fieldValidation(xmlStr,"validateDuration");
	}
}

function selectCorrectDurationDesc(dur_des_value,onclick_flag){
	if(onclick_flag==undefined)
		onclick_flag='Y';
	if(dur_des_value!=undefined){
		var dur_des=document.prescription_detail_form.durn_desc;
		for(i=0;i<dur_des.options.length;i++){
			if(dur_des.options[i].value==dur_des_value){
				dur_des.options[i].selected=true;
				durationConversn(dur_des,'form',onclick_flag)
				break;
			}
		}	
	}
}

async function callPRNDetails(){	
	var dialogHeight	= "18" ;
	var dialogWidth		= "30";
	var dialogTop		= "200" ;
	var dialogLeft		= "255" ;
	var center			= "1" ;
	var status			="no";
	var features		= "dialogHeight:" + dialogHeight +"; dialogLeft"+dialogLeft+ "; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop;
	var arguments		= "";		
	
	var man_rem_on_prn_freq_yn = parent.parent.parent.f_header.document.dir_disp_header_form.man_rem_on_prn_freq_yn.value;
	var max_length_prn_reason = parent.parent.parent.f_header.document.dir_disp_header_form.max_length_prn_reason.value;

	var frmObj       = document.prescription_detail_form;	
	var drug_name    =  frmObj.drug_name.value;
	var drug_code    =  frmObj.drug_code.value
	//var prn_yn       =  frmObj.prn_yn.value;

	retVal				= await window.showModalDialog("../../ePH/jsp/DirectDispPRNRemarks.jsp?drug="+escape(drug_name)+"&drug_code="+drug_code+"&man_rem_on_prn_freq_yn="+man_rem_on_prn_freq_yn+"&max_length_prn_reason="+max_length_prn_reason,arguments,features);

   if(retVal=='OK'){
		document.prescription_detail_form.prn_remarks_flag.value = "true";
   }
   else{
		document.prescription_detail_form.prn_remarks_flag.value = "false";
   }
}

function validatePRNRemark() {
	drug_code				=	document.PrescriptionPRNRemarksForm.drug_code.value;
	drug					=	document.PrescriptionPRNRemarksForm.drug.value;
	bean_id					=	document.PrescriptionPRNRemarksForm.bean_id.value;
	bean_name				=	document.PrescriptionPRNRemarksForm.bean_name.value;
	remarks					=	document.PrescriptionPRNRemarksForm.remarks.value;	
	remarks_code			=	document.PrescriptionPRNRemarksForm.prnRemCode.value;	
	//prn_yn					=	document.PrescriptionPRNRemarksForm.prn_yn.value;	
	man_rem_on_prn_freq_yn	=	document.PrescriptionPRNRemarksForm.man_rem_on_prn_freq_yn.value;	
	max_length_prn_reason = document.PrescriptionPRNRemarksForm.max_length_prn_reason.value;
	if(remarks.length > max_length_prn_reason){
		var msg = getMessage("REMARKS_CANNOT_EXCEED","Common");
		msg = msg.replace("$",'Remarks');
		msg = msg.replace("#",max_length_prn_reason);
		alert(msg);
		if(document.PrescriptionPRNRemarksForm.remarks.disabled == false){
			document.PrescriptionPRNRemarksForm.remarks.select();
			document.PrescriptionPRNRemarksForm.remarks.focus();
		}
		return;
	}
	var fields			= new Array() ;
	var names			= new Array() ;
	//if(prn_yn=='Y'){
		 fields[0]			= document.PrescriptionPRNRemarksForm.remarks ;
		 names[0]			= "Remarks" ;
	//}
	
	if(trimCheck(fields[0].value)) {
	    var xmlStr ="<root><SEARCH ";
		xmlStr+= "remarks =\"" +encodeURIComponent(remarks) + "\" " ;
		xmlStr+= "remarks_code =\"" +remarks_code + "\" " ;
		xmlStr+= "drug_code =\"" + drug_code + "\" " ;
		xmlStr+= "bean_id =\"" + bean_id + "\" " ;
		xmlStr+= "bean_name=\"" + bean_name + "\" " ;
		xmlStr +=" /></root>";
		var temp_jsp="DirectDispValidate.jsp?func_mode=PRNRemarks";
		var xmlDoc = "" ;
		var xmlHttp = new XMLHttpRequest() ;
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open("POST",temp_jsp,false);
		xmlHttp.send(xmlDoc);
		responseText=xmlHttp.responseText ;		
		eval(responseText);
		//window.close();	
		//window.returnValue="OK";
		parent.document.getElementById('dialog-body').contentWindow.returnValue = "OK";
		parent.document.getElementById('dialog_tag').close();  

	}
	else{
		if(man_rem_on_prn_freq_yn == 'Y'){
			alert(getMessage("REMARKS_CANNOT_BLANK","PH"));
			return false;
		}
		else{
			parent.document.getElementById('dialog-body').contentWindow.returnValue = "OK";
			parent.document.getElementById('dialog_tag').close();  
		}
	}
}

function changeRemType(){
	if(document.PrescriptionPRNRemarksForm.prnFreeTextYN.checked==true){
		document.PrescriptionPRNRemarksForm.prnRemCode.selectedIndex = 0;
		document.PrescriptionPRNRemarksForm.prnRemCode.disabled = true;
		document.PrescriptionPRNRemarksForm.remarks.disabled = false;
	}
	else{
		document.PrescriptionPRNRemarksForm.prnRemCode.selectedIndex = 0;
		document.PrescriptionPRNRemarksForm.prnRemCode.disabled = false;
		document.PrescriptionPRNRemarksForm.remarks.disabled = true;
	}
	document.PrescriptionPRNRemarksForm.remarks.value = "";
}

function displayRemarks(obj){
	document.PrescriptionPRNRemarksForm.remarks.value = "";
	document.PrescriptionPRNRemarksForm.remarks.disabled = true;
	var xmlStr ="<root><SEARCH ";
	xmlStr+= "drug_code =\"" + document.PrescriptionPRNRemarksForm.drug_code.value + "\" " ;
	xmlStr+= "remarks_code =\"" + obj.value + "\" " ;
	xmlStr+= "bean_id =\"" + document.PrescriptionPRNRemarksForm.bean_id.value + "\" " ;
	xmlStr+= "bean_name=\"" + document.PrescriptionPRNRemarksForm.bean_name.value + "\" " ;
	xmlStr +=" /></root>";
	var temp_jsp="DirectDispValidate.jsp?func_mode=PRNText";
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest() ;
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST",temp_jsp,false);
	xmlHttp.send(xmlDoc);
	responseText=xmlHttp.responseText ;		
	eval(responseText);
}

function setPRNRemarks(prn_remarks_text){
	document.PrescriptionPRNRemarksForm.remarks.value =unescape(prn_remarks_text);
}

function checkBMSTab(str){ 
	chkBMSTab = str;
	//chkBalanceTab = "true";
}

function validateNoOfPrints(obj, allocQty){  //Code Added for RUT-CRF-0067 Start
	var noOfPrint = obj.value;
	if(noOfPrint == "" || parseInt(noOfPrint)==0){
		alert(getMessage("PH_NO_OF_PRINT_CANNOT_BALNK", "PH"));
		obj.focus();
		return false;
	}
	else{
		if(parseInt(noOfPrint)> parseInt(allocQty) && parseInt(noOfPrint) <1000){
			var contiueYN = confirm(getMessage("PH_NO_OF_PRINTS_GREATER_THAN_DISP_QTY", "PH")); 
			if(!contiueYN){
				obj.value=parseInt(allocQty);
				obj.focus();
				return false;
			}
		}
		if (parseInt(noOfPrint) >999){
			if(parseInt(allocQty) >999){
				var contiueYN = confirm(getMessage("PH_NO_OF_PRINT_MORE_THAN_1000", "PH")); 
				if(!contiueYN){
					obj.focus();
					return false;
				}
			}
			else{
				alert(getMessage("PH_NO_OF_PRINT_MORE_THAN_1000", "PH"));
				obj.focus();
				return false;
			}
		}   
	}
} 

function validateRecordMandatory(){//newly added for RUT-CRF-0067
	var formObj			= parent.printSelectFrame.document.DispMedicationPrintDialog;
	//var currentStage	= formObj.curr_stage.value;
	var validate		= true;
	var currentFacility	= "C";
	var fields			= new Array() ;
	var names			= new Array() ;		

	if(formObj.curr_facility != undefined && formObj.curr_facility[1].checked == true)
		currentFacility	= "E";
		
	if(formObj.enable_tab != undefined && formObj.enable_tab.value == 'Y'){
		if(currentFacility=='C'){
			fields[0]   = formObj.next_collection_date1 ;	
			names[0]    = getLabel("ePH.NextCollectionDate.label","Common");				
			fields[1]   = formObj.disp_locations ;	
			names[1]    = getLabel("ePH.NextCollectionFrom.label","Common"); 
		}
		else if(currentFacility=='E'){
			var cnt	=	0;
			if(formObj.referral_location.value =="" && formObj.referral_facility.value ==""){ 
				fields[cnt]   = formObj.referral_location ;	
				names[cnt]    = getLabel("Common.FacilityName.label","Common");
				cnt++;
			}
			fields[cnt]   = formObj.next_collectiondate ;	
			names[cnt]    = getLabel("ePH.NextCollectionDate.label","PH");	
			cnt++;
			fields[cnt]   = formObj.referral_remarks ;	
			names[cnt]    = getLabel("Common.remarks.label","Common");
			cnt++;
			fields[cnt]   = formObj.practioner_name ;	
			names[cnt]    = getLabel("ePH.ReferedBy.label","PH");
		}
		validate =  checkFlds( fields, names);
	}
	return validate;
}//Code Added for RUT-CRF-0067 End

async function drugindication_remarks(){//Added for  ML-BRU-CRF-072[Inc:29938]
	var drug_frmobj=parent.parent.parent.parent.f_detail.f_ord_detail.f_drug_detail.f_drug.prescription_detail_form;
	var patient_id		= drug_frmobj.patient_id.value;
	var encounter_id	= drug_frmobj.encounter_id.value;
	var bean_id			= drug_frmobj.bean_id.value;
	var bean_name		= drug_frmobj.bean_name.value;
	var drug_code		= drug_frmobj.drug_code.value;
    var DrugIndicationRemarks	=	drug_frmobj.DrugIndicationRemarks.value;
	var mode=drug_frmobj.mode.value;
	var dialogHeight= "230px" ;
	var dialogWidth	= "600px" ;
	var dialogTop = "300" ;
	var dialogLeft ="450";
	var center = "0" ;
	var status="no";
	var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" +dialogTop+"; dialogLeft :"+dialogLeft;
	var arguments	= "" ;
	retVal = await window.showModalDialog("../../ePH/jsp/DrugIndicationRemarks.jsp?&DrugIndicationRemarks="+escape(DrugIndicationRemarks)+"&drug_code="+drug_code+"&bean_id="+bean_id+"&bean_name="+bean_name+"&mode=DD",arguments,features);
	
	if(retVal!= undefined && retVal!=null)
		drug_frmobj.DrugIndicationRemarks.value=retVal;		
}

function savedrugIndicationRemarks(drug_indicate){
	var drug_indication_new = encodeURIComponent(drug_indicate.value);
	window.returnValue=drug_indication_new;
	window.close();
	parent.document.getElementById('dialog-body').contentWindow.returnValue = drug_indication_new; 
	parent.document.getElementById('dialog_tag').close();  
}

function checkDrugIndMaxLimit(obj,maxLeng) { 
	if(obj.value.length > maxLeng) {
		val = obj.value;
		var msg = getMessage("REMARKS_CANNOT_EXCEED","Common");
		msg = msg.replace("$",getLabel("ePH.DrugIndications.label","PH"));
		msg = msg.replace("#",maxLeng);
		obj.value = val.substring(0,(val.length)-1);
		alert(msg);
		obj.focus();
		return false;
	} 
	else 
		return true;
}//Added for  ML-BRU-CRF-072[Inc:29938] end

function duplicateWarning() {
	var msg		=	getMessage("PH_DUPLICATE_MEDICATION", "PH");	
	var all_msg	=	msg.split("||");
	alert(all_msg[0]+parent.parent.f_drug_detail.f_drug.document.prescription_detail_form.generic_name.value+all_msg[1]); 
}

function storeAuthUserInBean(user_id){// RUT-CRF-0035 [IN029926] PIN Authentication  =--begin
	var bean_id			= parent.parent.parent.f_query_add_mod.document.DirectDispensingQueryCriteria.bean_id.value ;
	var bean_name	    = parent.parent.parent.f_query_add_mod.document.DirectDispensingQueryCriteria.bean_name.value ;	
	var xmlDoc = "" ;
    var xmlHttp = new XMLHttpRequest() ;
	var xmlStr			= "<root><SEARCH ";
	xmlStr			+= " bean_id=\""+ bean_id + "\" ";
	xmlStr			+= " bean_name=\""+ bean_name + "\" ";
	xmlStr			+= " auth_user_id=\""+ user_id + "\" ";
	xmlStr			+= " /></root>";	
    xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
    xmlHttp.open("POST","DirectDispValidate.jsp?func_mode=storeAuthUserInBean",false);	
    xmlHttp.send(xmlDoc);
    responseText=xmlHttp.responseText ;
	eval(responseText);
    return true;
}// RUT-CRF-0035 [IN029926] PIN Authentication  -- end

async function alertIntr(drug_code, srl_no, patient_id, encounter_id, intr_restric_trn){ // added for FD-RUT-CRF-0066.1 [IN036975] -Start
	var retVal;
	var dialogTop		= "300";
 	var dialogHeight	= "15" ;//MMS-KH-CRF-0029
 	var dialogWidth		= "35" ;//MMS-KH-CRF-0029
	var dialogLeft		= "425" ;
	var center		= "0" ;
	var status		="no";

 	var features		= 'Width:' + dialogWidth +'; dialogHeight:' + dialogHeight + '; dialogWidth:' + dialogWidth +'; dialogLeft:' + dialogLeft +';  dialogTop:'+dialogTop +'; scroll=auto; status=no'+ "; center: " + center ;
 	var arguments		=getLabel("Common.DrugInteraction.label",'Common'); 
 	retVal 				=    await window.showModalDialog("../../ePH/jsp/PrescriptionOverrideReasonFrameset.jsp?called_from=normal&calledFrom=INTRACTIONDTLS&drug_code="+drug_code+"&srl_no="+srl_no+"&patient_id="+patient_id+"&encounter_id="+encounter_id+"&calledFor=Alert&intr_restric_trn="+intr_restric_trn+"&CalledFrom=DD",arguments,features);
	return false;
}

async function showInractionDtl(drug_code, srl_no, patient_id, encounter_id, intr_restric_trn){
	var retVal;
	var dialogTop		= "170"; 
 	var dialogHeight	= "32" ;
 	var dialogWidth		= "50" ;
	var dialogLeft		= "375" ;
 	var features		= 'Width:' + dialogWidth +'; dialogHeight:' + dialogHeight + '; dialogWidth:' + dialogWidth +'; dialogLeft:' + dialogLeft +';  dialogTop:'+dialogTop +'; scroll=auto; status=no';
 	var arguments		=getLabel("Common.DrugInteraction.label",'Common'); 
 	retVal 				=    await window.showModalDialog("../../ePH/jsp/PrescriptionOverrideReasonFrameset.jsp?called_from=normal&calledFrom=INTRACTIONDTLS&drug_code="+drug_code+"&srl_no="+srl_no+"&patient_id="+patient_id+"&encounter_id="+encounter_id+"&CalledFrom=DD",arguments,features);
}  // added for FD-RUT-CRF-0066.1 [IN036975] -End

function callFinancialDetailScreen(patient_id,episodeid, visitid) { //code added for JD-CRF-0156[IN041737] --Start
	ViewBLDtl(episodeid,visitid,patient_id);
	/*var retVal       =  new String();
	var episode1     ="";
	var dialogTop    = "200";
	var dialogHeight = "42" ; 
	var dialogWidth  = "70" ; 
	var features     = "dialogTop:" + dialogTop + "; dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +";status=no" ;
	var arguments    = "" ;
	var search_desc  =""; 
	var title   =getLabel("eBL.PAT_ENCOUNTER_FIN_DTLS.label","BL");
	var column_sizes = escape("");               
	var column_descriptions ="";       
	var param =   "title="+title+"&column_sizes="+column_sizes+"&column_descriptions="+column_descriptions+"&episodeid="+	episodeid+"&visitid="+visitid+"&patientid="+patient_id+"&episode1="+episodeid;
	retVal=window.showModalDialog("../../eBL/jsp/BLFinDtlQryMain.jsp?"+param,arguments,features);*/
}

function blinkText(name,textId,timeA,timeB,colourA,colourB){
	if(document.getElementById){
		this.isEnabled=true;
		this.textId=document.getElementById(textId);
		this.name=name;
		this.timeA=timeA;
		this.timeB=timeB;
		this.colourA=colourA;
		this.colourB=colourB; 
		this.state=0;
		this.timer=null;
		setTimeout(this.name+'.tBlink()',10);
	}
}

blinkText.prototype.tBlink=function(){
	if(this.isEnabled){
		this.textId.style.color = (this.state^=1) ? this.colourA : this.colourB;
		this.timer=setTimeout(this.name+".tBlink()", this.state ? 
		this.timeA : this.timeB )
	}
}

blinkText.prototype.stopBlink=function(){
	this.isEnabled=false;
}

blinkText.prototype.startBlink=function(){
	if(this.isEnabled==false){
		this.isEnabled=true;
		this.tBlink();
	}
}

blinkText.prototype.toggleBlink=function(){
	if(this.isEnabled^=true);
		this.tBlink();
}   //code added for JD-CRF-0156[IN041737]--End

function callAllergies(patient_id){ //Added for RUT-CRF-065.1 [IN:043255]
	var retVal 			= 	new String();
	var dialogHeight 	= "700px" ;
	var dialogWidth  	= "1200px" ;
	var dialogTop    	= "10";
    var status 			= "no";
	var features		= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; dialogTop:"+dialogTop+"; scroll=auto; status:no";
	retVal = parent.parent.parent.parent.window[2].showModalDialog("../../eCA/jsp/AllergyList.jsp?called_from_ip=Y&patient_id="+patient_id,arguments,features);
}

async function showReturnMedication(patient_id,disp_locn_code, disp_locn_catg){//added for MMS-QH-CRF-0201 [IN:052255] -start
	var formObj = "";
	var from_date;
	var to_date;
	var Agdate;
	var frompage="directDisp";
	var dialogHeight	= "48" ;
	var dialogWidth		= "80" ;
	var dialogTop		= "100" ;
	var center			= "1" ;
	var status			= "no";
	var features		= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop;
	var arguments		= getLabel("ePH.ReturnMedication.label","PH") ;
	retVal			= await window.showModalDialog( "../../ePH/jsp/ReturnMedicationFrames.jsp?patientcat="+disp_locn_catg+"&dispLocn="+disp_locn_code+"&homepage="+frompage+"&patient_id="+patient_id, arguments, features );
}

function checkReturnAccess(disp_locn_code){//added for MMS-QH-CRF-0201 [IN:052255] -start
	var retVal = "";
	var bean_id		= "DispMedicationBean";
	var bean_name	= "ePH.DispMedicationBean";
	var xmlDoc="";
	var xmlHttp = new XMLHttpRequest();
	var xmlStr ="<root><SEARCH ";
	xmlStr +=" /></root>" ;
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open( "POST", "DispMedicationValidate.jsp?identity=getRightsForReturnMed&disp_locn_code="+disp_locn_code+"&bean_id="+bean_id+"&bean_name="+bean_name, false ) ;
	xmlHttp.send(xmlDoc);
	retVal = eval(xmlHttp.responseText);
	if(retVal=="Y")
		return true;
	else
		return false;
}
function SearchDrugBasedOnBarcode(obj,patient_id,gender,date_of_birth){ //MMS-DM-CRF-0112  - Start
	var barcode_id  ="";
	var hdr_formobj		 = parent.parent.parent.parent.f_detail.f_header.document.dir_disp_header_form;
	var enc_id				= "";
	var patient_clas        ="";
	if(hdr_formobj.encounter_id!=undefined)
		enc_id				= hdr_formobj.encounter_id.value;
	if(hdr_formobj.patient_class!=undefined)
		patient_class		= hdr_formobj.patient_class.value;
		
	barcode_id = obj.value;
	
	if(enc_id==""){
		patient_class="R";
	}
	
	if(barcode_id==""){
		alert(getMessage("PH_NOTMATCHING_BAR_CODE","PH"));
		return false;
	}
	else{
      var dir_bean_id      = "DirectDispensingBean" ;
	  var dir_bean_name    = "ePH.DirectDispensingBean"
	  var identity         = "MedicationOrder";
	  var xmlStr ="<root><SEARCH ";
	  xmlStr += " bean_id=\""+ dir_bean_id + "\" ";
	  xmlStr += " bean_name=\""+ dir_bean_name + "\" ";
 	  xmlStr += " identity=\""+ identity + "\" ";
	  xmlStr+= "barcode_id=\"" + barcode_id + "\" " ;
	  xmlStr+= "gender=\"" + gender + "\" " ;
	  xmlStr+= "date_of_birth=\"" + date_of_birth + "\" " ;
	  xmlStr+= "patient_id=\"" + patient_id + "\" " ;
	  xmlStr+= "patient_class=\"" + patient_class + "\" " ;
	  xmlStr +=" /></root>" ;
	
	  fieldValidation(xmlStr,"directDispBarcode");
	}
}

function CallDrugBasedOnBarcode(barcode_drug,drugPrivilige,identity1,orderingPrivilige,diagnosis_found_yn,appl_for_age_grp_yn,flag){ 
	var Drug_Codes =  new Array();
	var	Trade_Codes = new Array();
	var Trade_Names = new Array();
	Drug_Codes[0] = barcode_drug;
	
	if(barcode_drug==""){
		alert(getMessage("SCANNED_ITEM_AVAILABILITY","PH"));
		if(document.prescription_detail_form.barcode_id!=undefined){
			document.prescription_detail_form.barcode_id.value ="";
			document.prescription_detail_form.barcode_id.focus();
		}
		return false;
	}
	else if(flag=="true" || flag==true){
		alert(getMessage('SCANNED_ITEM_EXISTS','PH'));
		if(document.prescription_detail_form.barcode_id!=undefined){
			document.prescription_detail_form.barcode_id.value ="";
			document.prescription_detail_form.barcode_id.focus();
			return false;
		}
	}
	else{
	if (identity1 == "MedicationOrder"){
		if (identity1 == "MedicationOrder" && drugPrivilige =='A' && orderingPrivilige =='N'){
			alert(getMessage("INSUFFICIENT_PRIVILEGE_FOR_ORDERING_THE_DRUG","PH"));
			if(document.prescription_detail_form.barcode_id!=undefined){
				document.prescription_detail_form.barcode_id.value ="";
				document.prescription_detail_form.barcode_id.focus();
			}
			return false;
		}
		else if(identity1 == "MedicationOrder" && drugPrivilige =='S' && orderingPrivilige=="" ){
			alert(getMessage("INSUFFICIENT_PRIVILEGE_FOR_ORDERING_THE_DRUG","PH"));
			if(document.prescription_detail_form.barcode_id!=undefined){
				document.prescription_detail_form.barcode_id.value ="";
				document.prescription_detail_form.barcode_id.focus();
			}
			return false;
		}
	}
	msg=true;
	checkforpromptalertmsg(barcode_drug);
	if(msg==true){
		var message="";
		if(identity1 == "MedicationOrder"){
			if(diagnosis_found_yn =='N'){
				message = getMessage("REQ_DIAG_PRES_NOT_FOUND",'PH');
			}
			if(appl_for_age_grp_yn =='N'){
				message =message+"\n"+getMessage("DRUG_NOT_APPL_TO_PAT_AGE_GRP",'PH');
			}
			if(message !=""){
				alert(message);
				return false;
			}
		}
	}
	chkDuplicateDrugCode(Drug_Codes, "", "" );
}
}//MMS-DM-CRF-0112  - End


	//MMS-KH-CRF-0029[IN070606] - start
function loadDrugInteractionForDrug(drug_code,patient_id,srl_no){
	var bean_id="DirectDispensingBean";
	var bean_name="ePH.DirectDispensingBean";
	var xmlStr	="<root><SEARCH " ;
	xmlStr		+="bean_id"+"=\""+ bean_id+"\" " ;
	xmlStr		+="bean_name"+"=\""+ bean_name+"\" " ;
	xmlStr += "patient_id=\""+patient_id +"\" " ;
	xmlStr += "drug_code=\""+drug_code +"\" " ;
	xmlStr += "srl_no=\""+srl_no +"\" " ;
	
	xmlStr +=" /></root>" ;
	var xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	var xmlHttp = new XMLHttpRequest() ;
	xmlHttp.open( "POST", "DirectDispValidate.jsp?func_mode=loadDrugInteractionForDrug", false ) ;
	xmlHttp.send( xmlDoc ) ;	
	responseText=xmlHttp.responseText ;
	eval(responseText);
	
}
//MMS-KH-CRF-0029[IN070606] - end
//added for AAKH-CRF-0117 - start
function getApprovalNumForDrug(obj,drug_code,srl_no){
		var approval_no=obj.value;
  		var bean_id		=  document.DirectDispDispensingDetails.bean_id.value; //AAKH-CRF-0117
		var bean_name		=  document.DirectDispDispensingDetails.bean_name.value;//AAKH-CRF-0117

		var xmlStr ="<root><SEARCH ";
		xmlStr += " bean_id=\""+bean_id+"\"";
		xmlStr += " bean_name=\""+bean_name+"\"";
		xmlStr += " drug_code=\""+drug_code+"\"";
		xmlStr += " srl_no=\""+srl_no+"\"";
 		xmlStr += " approval_no=\""+approval_no+"\"";

		
		xmlStr +=" /></root>" ;
		var xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		var xmlHttp = new XMLHttpRequest();
		xmlHttp.open( "POST", "DirectDispValidate.jsp?func_mode=ApprovalNoForDrug", false ) ;
		xmlHttp.send(xmlDoc);
		eval(xmlHttp.responseText);
}
//added for AAKH-CRF-0117 - end
//added for AAKH-CRF-0117 - start
function getApprovalNoValidation(disp_stage,formObj){
	 
	var approval_flag=true;
	tot_rec =formObj.tot_rec.value;
	 if(disp_stage=="D") {  
  		  for (var i=1;i<parseInt(tot_rec);i++ )
	      {
			// alert(eval("formObj.approval_no_"+i));
		    if(eval("formObj.approval_no_"+i).disabled==false){
		     if(eval("formObj.approval_no_"+i).value ==""){
			 approval_flag = false;
			 break;
			 }
			}
	      }
	}   

	if(approval_flag==false)
		return false;
	else
		return true;
} //added for AAKH-CRF-0117 - end
	//added for AAKH-CRF-0117 - start
function KeyPressSpecCharsForApprovalNo(event){
	var strCheck = '0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ!@#%^*()';
    var whichCode = (window.Event) ? event.which : event.keyCode;

	key = String.fromCharCode(whichCode);  // Get key value from key code
	
    if (strCheck.indexOf(key) == -1) return false;  // Not a valid key
	
	return true ;
  
}
function CheckForSpecCharApprovalno(Obj,stage,recCount){
		
        var str = Obj.value;
        var strvalidate = "";
        for (u=0;u<str.length;u++){
            if (((str.charCodeAt(u)>=48) && (str.charCodeAt(u)<=57))||((str.charCodeAt(u)>=65) && (str.charCodeAt(u)<=90))||((str.charCodeAt(u)>=97) && (str.charCodeAt(u)<=122))||(str.charCodeAt(u)==33)||(str.charCodeAt(u)==64)||(str.charCodeAt(u)==35)||(str.charCodeAt(u)==37)||(str.charCodeAt(u)==94)||(str.charCodeAt(u)==42)||(str.charCodeAt(u)==40)||(str.charCodeAt(u)==41)){//To allow only !,@,#,%,^,*,(,) special characters
            	 
            	strvalidate=strvalidate+str.charAt(u);
            }
		}
		 if( stage=="D")
			 eval("document.DirectDispDispensingDetails.approval_no_"+recCount).value = strvalidate;
		 else if(stage=="H")
			document.prescription_detail_form.approval_no.value = strvalidate; 
 }	//added for AAKH-CRF-0117 - end
//Added for IN:072715 START
function checkOverrideRemarks(reason_code,trn_type,frmObj,frmObj1,field,patient_id,encounter_id){
	
	var reason_code=reason_code.value;
	if(reason_code==""){
		frmObj1.value="";
		frmObj1.readOnly = true;
	}
	else if(reason_code=="OTHR"){
		frmObj1.value="";
		frmObj1.readOnly = false;
	}
	else{
		bean_id		=	frmObj.bean_id.value;
		bean_name	=	frmObj.bean_name.value;
	
		
		var xmlStr ="<root><SEARCH ";
		xmlStr+= "bean_id  =\"" + bean_id + "\" " ;
		xmlStr+= "bean_name =\"" + bean_name + "\" " ;
		xmlStr+= "reason_code  =\"" + reason_code + "\" " ;
		xmlStr+= "trn_type =\"" + trn_type + "\" " ;
		xmlStr+= "field =\"" + field + "\" " ;
		xmlStr+= "patient_id =\"" + patient_id + "\" " ;
		xmlStr+= "encounter_id =\"" + encounter_id + "\" " ;
		xmlStr +=" /></root>";
		var xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		var xmlHttp = new XMLHttpRequest() ;
		xmlHttp.open( "POST", "DirectDispValidate.jsp?func_mode=override_remarks", false ) ;
		xmlHttp.send(xmlDoc);
		eval(xmlHttp.responseText);

	}
	
}
//Added for IN:072715 end
//Added for IN:073485 start
function checkMandRemarks(drug_code,srl_no,frmObj){
	bean_id		=	frmObj.bean_id.value;
	bean_name	=	frmObj.bean_name.value;
	var allergy_yn=frmObj.allergy_yn.value;
	var current_rx=frmObj.current_rx.value;
	var limit_ind=frmObj.limit_ind.value;
		
	frmObj.limit_ind.value;
	var xmlStr ="<root><SEARCH ";
	xmlStr+= "drug_code  =\"" + drug_code + "\" " ;
	xmlStr+= "srl_no =\"" + srl_no + "\" " ;
	xmlStr+= "allergy_yn  =\"" + allergy_yn + "\" " ;
	xmlStr+= "current_rx =\"" + current_rx + "\" " ;
	xmlStr+= "limit_ind  =\"" + limit_ind + "\" " ;
	
	xmlStr+= "bean_id =\"" + bean_id + "\" " ;
	xmlStr+= "bean_name=\"" + bean_name + "\" " ;
	xmlStr +=" /></root>";

	var xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	var xmlHttp = new XMLHttpRequest() ;
	xmlHttp.open( "POST", "DirectDispValidate.jsp?func_mode=override_mand_check", false ) ;
	xmlHttp.send(xmlDoc);
	eval(xmlHttp.responseText);


}
//Added for IN:073485 end
//Added for IN:069886 start
function validateRefillEndDate(dateObj,start_date, locale,max_durn_for_refill_pres){
	var srl_no		=	document.refill_form.srl_no.value;
	var interval_value			=	1; //Added for IN:069886
	var freq_durn_type	=	document.refill_form.freq_durn_type.value; //Added for IN:069886
	var repeat_durn_type	=	document.refill_form.repeat_durn_type.value; //Added for IN:069886
	if(dateObj.value!=""){
		if(validDate(dateObj.value, "DMYHM",locale )){
			var refill_start_date_tmp=document.refill_form.refill_start_date_tmp.value;
			var date_range_in_muliples=document.refill_form.date_range_in_muliples.value;
			if(isBefore(refill_start_date_tmp,dateObj.value, "DMYHM",locale)){ //Modified for IN:069886

				var durn = daysBetween(start_date,dateObj.value,"DMYHM",locale);
				if(repeat_durn_type=="D" || repeat_durn_type=="W" || repeat_durn_type=="L" || repeat_durn_type=="Y"){ //Added for IN:069886
				var refill_durn = daysBetween(refill_start_date_tmp,dateObj.value,"DMYHM",locale);
					//Added for IN:069886 -Start
						if(repeat_durn_type=="D"){
							interval_value=1;
						}
						if(repeat_durn_type=="W"){
							interval_value=7;
						}
						if(repeat_durn_type=="L"){
							interval_value=30;
						}
						if(repeat_durn_type=="Y"){
							interval_value=365;
						}
					}
				else if(repeat_durn_type=="H"){
					var refill_durn = hoursBetween(refill_start_date_tmp,dateObj.value,"DMYHM",locale);
							interval_value=1;
						
				}
				else if(repeat_durn_type=="M"){
					var refill_durn = minutesBetween(refill_start_date_tmp,dateObj.value,"DMYHM",locale);
							interval_value=1;
				}
				//Added for IN:069886- end
				var last_refill_durn_value = parseInt(refill_durn)/parseInt(interval_value);
				var last_refill_freq_chnage_durn_value = parseInt(last_refill_durn_value)*parseInt(date_range_in_muliples);
				if(parseInt(durn)>parseInt(max_durn_for_refill_pres)){
					alert(getMessage("PH_MAX_REFILL_DURN", "PH"));
					document.refill_form.refill_end_date_tmp.select();
					//document.refill_form.refill_end_date_tmp.focus();
					document.refill_form.endDateImg.click();
					return false;
				}
				else if(parseInt(refill_durn)==0){
					alert(getMessage("END_DATE_GTR_THAN_START_DATE", "PH"));
					document.refill_form.endDateImg.click();
					return false;
				}
				else if((parseInt(refill_durn)%parseInt(interval_value))!=0){ //Modified for IN:069886
					var err_msg = getMessage("DURATION_VALUE_MULTIPLE","PH");
					err_msg = err_msg.replace('$ or ',"");
					err_msg = err_msg.replace('#', interval_value); //Modified for IN:069886
					err_msg = err_msg.replace('%', interval_value); //Modified for IN:069886
					alert(err_msg);
					document.refill_form.endDateImg.click();
					return false;
				}
				else{
					document.refill_form.refill_end_date.value=dateObj.value;
					document.refill_form.last_refill_durn_value.value=last_refill_durn_value; //Added for IN:069886
					document.refill_form.last_refill_freq_chnage_durn_value.value=last_refill_freq_chnage_durn_value; //Added for IN:069886
//					var fldString=" end_date=\""+ dateObj.value + "\" ";
//					fldString += " srl_no=\""+ srl_no + "\" ";
//					fldString += " last_refill_durn_value=\""+ last_refill_durn_value + "\" ";
//					var formobj=document.refill_form;
//					var xmlStr=formXMLString(formobj,fldString);
//					fieldValidation1(xmlStr,"assinLastRefillDate");
					//Commented for IN:069886
				/*	var xmlDoc	= new ActiveXObject("Microsoft.XMLDom");
					var xmlHttp	= new ActiveXObject("Microsoft.XMLHTTP");
					var xmlStr ="<root><SEARCH ";
					xmlStr+= "end_date  =\"" + dateObj.value + "\" " ;
					xmlStr+= "srl_no =\"" + srl_no + "\" " ;
					xmlStr+= "last_refill_durn_value  =\"" + last_refill_durn_value + "\" " ;
					xmlStr+= "last_refill_freq_chnage_durn_value  =\"" + last_refill_freq_chnage_durn_value + "\" " ;
					
					xmlStr+= "bean_id =\"" + bean_id + "\" " ;
					xmlStr+= "bean_name=\"" + bean_name + "\" " ;
					xmlStr +=" /></root>";

					xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
					xmlHttp.open( "POST", "DirectDispValidate.jsp?func_mode=assinLastRefillDate", false ) ;
					xmlHttp.send(xmlDoc);
					eval(xmlHttp.responseText); */
                                 	//Commented for IN:069886
				}
			}
			else{
				alert(getMessage("END_DATE_GTR_THAN_START_DATE", "PH"));
				//document.refill_form.refill_end_date_tmp.focus();
				document.refill_form.endDateImg.click();
				return false;
			}
		}
		else{ //Added for IN:069886
			alert(getMessage("INVALID_DATE_TIME", "PH"));
			dateObj.focus();
			return false;
	}
	}
	else{
		alert(getMessage("PH_END_DATE", "PH"));
		document.refill_form.endDateImg.click();
		return false;
	}
}
//Added for IN:069886 end
//Added for IN:069887  START

function validateOnConfirm() {
	var frmObj					= parent.parent.parent.parent.f_detail.f_ord_detail.f_drug_detail.f_drug.document.prescription_detail_form;
	patient_id		=	frmObj.patient_id.value;
	encounter_id	=	frmObj.encounter_id.value;
	limit_ind		=	frmObj.limit_ind.value;
	allergy_yn		=	frmObj.allergy_yn.value;
	current_rx		=	frmObj.current_rx.value;
	drug_code		=	frmObj.drug_code.value;
	srl_no			=	frmObj.srl_no.value;
	interaction_exists			=	frmObj.interaction_exists.value;
	bean_id		=	frmObj.bean_id.value;
	bean_name	=	frmObj.bean_name.value;
	var xmlStr ="<root><SEARCH ";
	xmlStr+= "drug_code  =\"" + drug_code + "\" " ;
	xmlStr+= "srl_no =\"" + srl_no + "\" " ;
	xmlStr+= "allergy_yn  =\"" + allergy_yn + "\" " ;
	xmlStr+= "current_rx =\"" + current_rx + "\" " ;
	xmlStr+= "limit_ind  =\"" + limit_ind + "\" " ;
	xmlStr+= "interaction_exists  =\"" + interaction_exists + "\" " ;
	xmlStr+= "patient_id =\"" + patient_id + "\" " ;
	xmlStr+= "encounter_id =\"" + encounter_id + "\" " ;
	
	xmlStr+= "bean_id =\"" + bean_id + "\" " ;
	xmlStr+= "bean_name=\"" + bean_name + "\" " ;
	xmlStr +=" /></root>";
	var temp_jsp="DirectDispValidate.jsp?func_mode=override_mand_check_on_confirm";

	var xmlHttp = new XMLHttpRequest() ;
	var xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST",temp_jsp,false);
	xmlHttp.send(xmlDoc);
	
	responseText=xmlHttp.responseText ;
	eval(responseText);
	return_val=false;
}
function showOverideMandAlert(allergy_remarks_yn, dup_remarks_yn, dose_remarks_yn, drug_drug_remarks_yn, drug_lab_remarks_yn,drug_food_remarks_yn){
	
	
	var names	= new Array();
	var   i		= 0;

	if(allergy_remarks_yn==='Y') {
		names[i]	=getLabel("ePH.AllergicOverrideReason.label", "PH");
		i++;
	}
	if(dose_remarks_yn==='Y') {
		names[i]	=getLabel("ePH.ExceedDosageOverrideReason.label", "PH");
		i++;
	}
	if(dup_remarks_yn==='Y') {
		names[i]	=getLabel("ePH.DuplicateDrugOverrideReason.label", "PH");
		i++;
	}
	if(drug_drug_remarks_yn==='Y') {
		names[i]	=getLabel("ePH.Drug-DrugInteractionOverrideReason.label", "PH");
		i++;
	}
	if(drug_lab_remarks_yn==="Y") {
		names[i]	=getLabel("ePH.Drug-LabInteractionOverrideReason.label", "PH");
		i++;
	}
	if(drug_food_remarks_yn==='Y') {
		names[i]	=getLabel("ePH.Drug-FoodInteractionOverrideReason.label", "PH");
		i++;
	}
	var errors = "" ;
	for( var i=0; i<names.length; i++ ) {
			
			errors = errors + "APP-000001 " + names[i] +" "+ getLabel("ePH.CANT_BE_BLANK.label","PH") + "\n" ;
	}
	if ( errors.length != 0 ) {
		alert(errors) ;
		return false ;
	}
	return true ;
}
//Added for IN:069887  END
//Added for IN:069886 - Start
function saveLastRefill(){
	var bean_id=parent.refill_detail.refill_form.bean_id.value;
	var bean_name=parent.refill_detail.refill_form.bean_name.value;
	var refill_end_date=parent.refill_detail.refill_form.refill_end_date.value;
	var srl_no=parent.refill_detail.refill_form.srl_no.value;
	var end_date		=	parent.refill_detail.refill_form.end_date.value;
	var durn_value		=	parent.refill_detail.refill_form.durn_value.value;
	var repeat_durn_type		=	parent.refill_detail.refill_form.repeat_durn_type.value;
	var refill_no		=	parent.refill_detail.refill_form.no_refill.value;
	var last_refill_durn_value		=	parent.refill_detail.refill_form.last_refill_durn_value.value;
	var last_refill_freq_chnage_durn_value		=	parent.refill_detail.refill_form.last_refill_freq_chnage_durn_value.value;
	
	var xmlStr ="<root><SEARCH ";
	xmlStr +=" last_refill_end_date=\""+ refill_end_date + "\" ";
	xmlStr += " srl_no=\""+ srl_no + "\" ";
	
	xmlStr += " end_date=\""+ end_date + "\" ";
	xmlStr += " durn_value=\""+ durn_value + "\" ";
	xmlStr += " repeat_durn_type=\""+ repeat_durn_type + "\" ";
	xmlStr += " refill_no=\""+ refill_no + "\" ";
	
	xmlStr += " last_refill_durn_value=\""+ last_refill_durn_value + "\" ";
	xmlStr += " last_refill_freq_chnage_durn_value=\""+ last_refill_freq_chnage_durn_value + "\" ";
	xmlStr+= "bean_id =\"" + bean_id + "\" " ;
	xmlStr+= "bean_name=\"" + bean_name + "\" " ;
	xmlStr +=" /></root>";
	var xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	var xmlHttp = new XMLHttpRequest() ;
	xmlHttp.open( "POST", "DirectDispValidate.jsp?func_mode=assinLastRefillDate", false ) ;
	xmlHttp.send(xmlDoc);
	eval(xmlHttp.responseText);
}
function noOfDays(obj,durn_value){
	var tmp_durn_value=1;
	if(obj.value == 'M'){
		tmp_durn_value   = Math.ceil(durn_value / (24*60));	
	}
	else if(obj.value == 'H'){
		tmp_durn_value   = Math.ceil(durn_value / 24);	
	}
	else if(obj.value == 'D'){
		tmp_durn_value   = (durn_value );	
	}
	else if(obj.value == 'W'){
		tmp_durn_value   = (durn_value * 7 );	
	}
	else if(obj.value == 'L'){
		tmp_durn_value   = (durn_value * 30);	
	}
	else if(obj.value == 'Y'){
		tmp_durn_value   = (durn_value * 365);	
	}
	return tmp_durn_value;
}
function removeRefill(bean_id,bean_name){
	var drug_frmobj				=parent.parent.parent.parent.f_detail.f_ord_detail.f_drug_detail.f_drug.document.prescription_detail_form;
	var srl_no			=	drug_frmobj.srl_no.value;
	drug_frmobj.no_refill.value="0";
	drug_frmobj.refill_start_date.value="";
	drug_frmobj.refill_end_date.value="";
	var xmlStr ="<root><SEARCH ";
	xmlStr += " srl_no=\""+ srl_no + "\" ";
	xmlStr+= "bean_id =\"" + bean_id + "\" " ;
	xmlStr+= "bean_name=\"" + bean_name + "\" " ;
	xmlStr +=" /></root>";
	var xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	var xmlHttp = new XMLHttpRequest() ;
	xmlHttp.open( "POST", "DirectDispValidate.jsp?func_mode=removerefill", false ) ;
	xmlHttp.send(xmlDoc);
	eval(xmlHttp.responseText);
}
function saveRefill(){
	var change_last_refill_end_date_appl_yn		=	parent.refill_detail.refill_form.change_last_refill_end_date_appl_yn.value;
	if(change_last_refill_end_date_appl_yn=="N"){
	var bean_id=parent.refill_detail.refill_form.bean_id.value;
	var bean_name=parent.refill_detail.refill_form.bean_name.value;
	var srl_no		=	parent.refill_detail.refill_form.srl_no.value;
	var end_date		=	parent.refill_detail.refill_form.end_date.value;
	var durn_value		=	parent.refill_detail.refill_form.durn_value.value;
	var repeat_durn_type		=	parent.refill_detail.refill_form.repeat_durn_type.value;
	var refill_no		=	parent.refill_detail.refill_form.no_refill.value;
	var xmlStr ="<root><SEARCH ";
	xmlStr += " srl_no=\""+ srl_no + "\" ";
	xmlStr += " end_date=\""+ end_date + "\" ";
	xmlStr += " durn_value=\""+ durn_value + "\" ";
	xmlStr += " repeat_durn_type=\""+ repeat_durn_type + "\" ";
	xmlStr += " refill_no=\""+ refill_no + "\" ";
	xmlStr+= "bean_id =\"" + bean_id + "\" " ;
	xmlStr+= "bean_name=\"" + bean_name + "\" " ;
	xmlStr +=" /></root>";
	var xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	var xmlHttp = new XMLHttpRequest() ;
	xmlHttp.open( "POST", "DirectDispValidate.jsp?func_mode=saveRefill", false ) ;
	xmlHttp.send(xmlDoc);
	eval(xmlHttp.responseText);
	}
	else{
		saveLastRefill();
	}
}
//Added for IN:069886- End

async function DrugSearchForDirectDispensing(searchBasedOn,target,order_type_code,drug_codes,bean_id,res_by_service,service_code,patient_class,priority,discharge_yn,patient_id,encounter_id,date_of_birth,gender,source_type,source_code,drugorfluid,iv_prep_yn,calledfrom,disp_locn_code,home_leave_yn_val,alternateOrder,normalRx_yn) {//added home_leave_yn_val for Bru-HIMS-CRF-093[29960] -->//added for  JD-CRF-0198 [IN:058599] and normalRx_yn added for GHL-CRF-0549
	//alert("inside DrugNameCommonLookup===38);
		var default_text	=	"";
		returnVal = new String();

		if (target!=""){
			 default_text =encodeURIComponent(target.value,"UTF-8");
		}
		if(iv_prep_yn == undefined || iv_prep_yn==null)
			iv_prep_yn="";

		if(calledfrom == undefined || calledfrom==null)
			calledfrom="";
		
		if(disp_locn_code == undefined || disp_locn_code==null)
			disp_locn_code="";

		var dialogHeight= "700px" ;
		var dialogWidth	= "900px" ;
		var status = "no";
		var dialogUrl		= "../../ePH/jsp/DrugNameCommonLookup.jsp?discharge_yn="+discharge_yn+"&priority="+priority+"&select="+searchBasedOn+"&default_text="+escape(default_text)+"&order_type_code="+order_type_code+"&drug_codes="+drug_codes+"&identity=MedicationOrder&modalYN=Y&bean_id="+bean_id+"&res_by_service="+res_by_service+"&service_code="+service_code+"&patient_class="+patient_class+"&patient_id="+patient_id+"&encounter_id="+encounter_id+"&date_of_birth="+date_of_birth+"&gender="+gender+"&source_type="+source_type+"&source_code="+source_code+"&drugorfluid="+drugorfluid+"&iv_prep_yn="+iv_prep_yn+"&calledfrom="+calledfrom+"&disp_locn_code="+disp_locn_code+"&home_leave_yn_val="+home_leave_yn_val+"&alternateOrder="+alternateOrder+"&normalRx_yn="+normalRx_yn;//added for  JD-CRF-0198 [IN:058599] and normalRx_yn added for GHL-CRF-0549
		var dialogFeatures	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; scroll=no; status:" + status;
		
		returnVal = await parent.parent.parent.parent.window[2].showModalDialog(dialogUrl,"", dialogFeatures);
		if( returnVal == null || returnVal == "" || returnVal == undefined ){
			return "";
		}else{
			return returnVal.split(":::") ;
		}
	}

