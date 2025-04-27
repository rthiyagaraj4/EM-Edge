  //saved on 07/11/2005
var result = false ;
var message = "" ;
var flag = "" ;
var vOrderNo;
var vOrderLNum;
	var vPatientId	;
var 	 vEncounterId;

function setRForReq(obj){
	var vCmb = parent.f_tdm_request.document.formTDMPrescriptionRemarks.reason_for_req;
	document.formTDMPrescriptionRemarks.reason_for_request.value = vCmb.options(vCmb.selectedIndex).value;
}

function setCBValue(obj){
	if(obj.checked)
		obj.value ="Y";
	else
		obj.value ="N";
}

function callAdminDetailForm(objOrdNo,objOrdLineNum,objExistence,objDrugCode,drug_desc,strOrderId){
	vOrderNo		= objOrdNo;
	var strOrderId		= strOrderId;
	
	vOrderLNum		= objOrdLineNum;
	var vExistenceYN = objExistence ;
	var vDrugCode		= objDrugCode;
	vPatientId		= document.forms[0].patient_id.value;
	 vEncounterId	= document.forms[0].encounter_id.value;
	var patient_class	= document.forms[0].patient_class.value;
	var location_code	= document.forms[0].location_code.value;
	var location_type	= document.forms[0].location_type.value;
	var pract_id		= document.forms[0].pract_id.value;
	var flag			= document.forms[0].flag.value;
	
	priority			= parent.parent.f_header.document.prescription_header_form.priority.value;
	ord_date			= parent.parent.f_header.document.prescription_header_form.sys_date.value;
	var actual_patient_class			= parent.parent.f_header.document.prescription_header_form.actual_patient_class.value;//Added actual_patient_class for AMS-SCF-0424 and ML-MMOH-SCF-0500
	//parent.tdm_frames.rows="22,70,98,178,20";
	parent.document.getElementById("f_tdm_radio_button").style.height="10vh";
	parent.document.getElementById("f_tdm_drug_profile").style.height="19vh";
	parent.document.getElementById("f_tdm_request").style.height="29vh";
	parent.document.getElementById("f_tdm_add_mod").style.height="29vh";
	parent.document.getElementById("f_tdm_buttons").style.height="24vh";
	

	
	parent.frames[2].location.href = "PrescriptionTDMRemarks.jsp?order_id="+strOrderId+"&ord_line_num="+vOrderLNum+"&ExistenceYn="+vExistenceYN+"&drug_desc="+drug_desc+"&&&flag="+flag+"&patient_id="+vPatientId+"&drug_code="+vDrugCode; 
	parent.frames[3].location.href = "PrescriptionTDMAdminDetail.jsp?patient_id= "+vPatientId+"&encounter_id="+vEncounterId+"&order_no="+vOrderNo+"&ord_line_num="+vOrderLNum+"&ExistenceYn="+vExistenceYN+"&drug_code="+vDrugCode+"&patient_class="+patient_class+"&location_code="+location_code+"&location_type="+location_type+"&pract_id="+pract_id+"&priority="+priority+"&drug_desc="+drug_desc+"&ord_date="+ord_date+"&flag="+flag+"&strOrder_id="+strOrderId+"&actual_patient_class="+actual_patient_class;//Added actual_patient_class for AMS-SCF-0424 and ML-MMOH-SCF-0500
	parent.f_tdm_buttons.location.href = "PrescriptionTDMButtons.jsp";
	
//if(vExistenceYN=="Y")
	//getUpdatedVales(vOrderNo,vOrderLNum,vPatientId,vEncounterId);
}

function callButtonpage(enable_disable){
	parent.f_tdm_buttons.location.href = "PrescriptionTDMButtons.jsp?enable_disable="+enable_disable;
}

function setPrePostDose(obj,nIdxVal){
	var vCmb = obj;  //p
	var vCmbVal
	var vObj;
	if(obj.checked==true){
		vCmbVal ="P";
		 vObj;
		vObj = document.getElementById("samp_type44_"+nIdxVal);
		if(vCmbVal == "PEAK")
		vObj.innerText = getLabel("ePH.PreDose.label","PH");
		if(vCmbVal == "TROUGH")
		vObj.innerText = getLabel("ePH.PostDose.label","PH");	
	}
	else{
		vCmbVal="";
		vObj = document.getElementById("samp_type44_"+nIdxVal);
		vObj.innerText="";
	}
}

function settroughPrePostDose(obj,nIdxVal){
	var vCmb = obj;  //p
	var vCmbVal
	var vObj;
	if(obj.checked==true){
		vCmbVal ="T";
		vObj;
		vObj = document.getElementById("samp_type7_"+nIdxVal);
		 
		if(vCmbVal == "PEAK")
		vObj.innerText = getLabel("ePH.PreDose.label","PH");
		if(vCmbVal == "TROUGH")
		vObj.innerText = getLabel("ePH.PostDose.label","PH");	
	}
	else{
		vCmbVal="";
		vObj = document.getElementById("samp_type7_"+nIdxVal);
		vObj.innerText="";
	}
}

function setrandomPrePostDose(obj,nIdxVal){
	var vCmb = obj;  //p
	var vCmbVal
	var vObj;
	if(obj.checked==true){
		vCmbVal ="R";
		 vObj;
		vObj =document.getElementById("samp_type10_"+nIdxVal);
		if(vCmbVal == "PEAK")
		vObj.innerText = getLabel("ePH.PreDose.label","PH");
		if(vCmbVal == "TROUGH")
		vObj.innerText = getLabel("ePH.PostDose.label","PH");	
	}
	else{
		vCmbVal="";
		vObj = document.getElementById("samp_type10_"+nIdxVal);
		vObj.innerText="";
	}
}

function setextendedPrePostDose(obj,nIdxVal){
	var vCmb = obj;  //p
	var vCmbVal
	var vObj;
	if(obj.checked==true){
		vCmbVal ="E";
		 vObj;
		vObj = document.getElementById("samp_type14_"+nIdxVal);
		if(vCmbVal == "PEAK")
		vObj.innerText = getLabel("ePH.PreDose.label","PH");
		if(vCmbVal == "TROUGH")
		vObj.innerText = getLabel("ePH.PostDose.label","PH");	
	}
	else{
		vCmbVal="";
		vObj = document.getElementById("samp_type14_"+nIdxVal);
		vObj.innerText="";
	}
}

function getLabTests(obj,nCtr){
	if(obj.checked==true){
		var ObjName		= obj.name;	//sample_type1
		var ObjLd		= eval("document.forms[0].lab_test4_"+nCtr);
		var ObjLdName	=ObjLd.name;
		
		var bean_id		= document.forms[0].bean_id.value ;
		var bean_name	= document.forms[0].bean_name.value ;	
		var samp_type	= obj.value; //P
		var drug_code	= document.forms[0].drug_code.value;
		var xmlDoc="";
		var xmlHttp = new XMLHttpRequest();

		xmlStr	="<root><SEARCH " ;
		xmlStr += " bean_id=\"" + bean_id + "\"";
		xmlStr += " bean_name=\"" + bean_name + "\"";
		xmlStr += " "+ObjName+"=\"" + samp_type + "\"";
		xmlStr += " "+ObjLdName+"=\"" + ObjLdName + "\"";
		xmlStr += " IdxNo=\"" + nCtr + "\"";
		xmlStr +=" /></root>" ;
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open( "POST", "PrescriptionTDMValidate.jsp?bean_id="+bean_id+"&bean_name="+bean_name+"&identity=getLabTest&samp_type="+samp_type+"&drug_code="+drug_code+"&ldObj="+ObjLdName+"&IdxNo="+nCtr, false ) ;

		xmlHttp.send( xmlDoc );
		eval(xmlHttp.responseText);
	}
	else if(obj.type!='checkbox'){
				
		var ObjName		= obj.name;	//sample_type1
		var ObjLd		= eval("document.forms[0].lab_test_"+nCtr);
		var ObjLdName	=ObjLd.name;
		var bean_id		= document.forms[0].bean_id.value ;
		var bean_name	= document.forms[0].bean_name.value ;	
		var samp_type	= obj.value; 
		var drug_code	= document.forms[0].drug_code.value;
		var xmlDoc="";
		var xmlHttp = new XMLHttpRequest();
 
		xmlStr	="<root><SEARCH " ;
		xmlStr += " bean_id=\"" + bean_id + "\"";
		xmlStr += " bean_name=\"" + bean_name + "\"";
		xmlStr += " "+ObjName+"=\"" + samp_type + "\"";
		xmlStr += " "+ObjLdName+"=\"" + ObjLdName + "\"";
		xmlStr += " IdxNo=\"" + nCtr + "\"";
		xmlStr +=" /></root>" ;
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open( "POST", "PrescriptionTDMValidate.jsp?bean_id="+bean_id+"&bean_name="+bean_name+"&identity=getLabTest&samp_type="+samp_type+"&drug_code="+drug_code+"&ldObj="+ObjLdName+"&IdxNo="+nCtr, false ) ;
		xmlHttp.send( xmlDoc );
		eval(xmlHttp.responseText);
	}
}

function gettroughLabTests(obj,nCtr){
	if(obj.checked==true){
		var ObjName		= obj.name;	//sample_type1
		var ObjLd		= eval("document.forms[0].lab_test1_"+nCtr);
		var ObjLdName	=ObjLd.name;
		var bean_id		= document.forms[0].bean_id.value ;
		var bean_name	= document.forms[0].bean_name.value ;	
		var samp_type	= obj.value; //P
		var drug_code	= document.forms[0].drug_code.value;
		var xmlDoc="";
		var xmlHttp = new XMLHttpRequest();

		xmlStr	="<root><SEARCH " ;
		xmlStr += " bean_id=\"" + bean_id + "\"";
		xmlStr += " bean_name=\"" + bean_name + "\"";
		xmlStr += " "+ObjName+"=\"" + samp_type + "\"";
		xmlStr += " "+ObjLdName+"=\"" + ObjLdName + "\"";
		xmlStr += " IdxNo=\"" + nCtr + "\"";
		xmlStr +=" /></root>" ;
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open( "POST", "PrescriptionTDMValidate.jsp?bean_id="+bean_id+"&bean_name="+bean_name+"&identity=getLabTesttrough&samp_type="+samp_type+"&drug_code="+drug_code+"&ldObj="+ObjLdName+"&IdxNo="+nCtr, false ) ;

		xmlHttp.send( xmlDoc );
		eval(xmlHttp.responseText);
	}
}

function getrandomLabTests(obj,nCtr){
	
	if(obj.checked==true){
		var ObjName		= obj.name;	//sample_type1
		var ObjLd		= eval("document.forms[0].lab_test2_"+nCtr);
		var ObjLdName	=ObjLd.name;
		var bean_id		= document.forms[0].bean_id.value ;
		var bean_name	= document.forms[0].bean_name.value ;	
		var samp_type	= obj.value; //P
		var drug_code	= document.forms[0].drug_code.value;
		var xmlDoc="";
		var xmlHttp = new XMLHttpRequest();

		xmlStr	="<root><SEARCH " ;
		xmlStr += " bean_id=\"" + bean_id + "\"";
		xmlStr += " bean_name=\"" + bean_name + "\"";
		xmlStr += " "+ObjName+"=\"" + samp_type + "\"";
		xmlStr += " "+ObjLdName+"=\"" + ObjLdName + "\"";
		xmlStr += " IdxNo=\"" + nCtr + "\"";
		xmlStr +=" /></root>" ;
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open( "POST", "PrescriptionTDMValidate.jsp?bean_id="+bean_id+"&bean_name="+bean_name+"&identity=getLabTestrandom&samp_type="+samp_type+"&drug_code="+drug_code+"&ldObj="+ObjLdName+"&IdxNo="+nCtr, false ) ;
		xmlHttp.send( xmlDoc );
		eval(xmlHttp.responseText);
	}
}

function getextendedLabTests(obj,nCtr){
	if(obj.checked==true){
		var ObjName		= obj.name;	//sample_type1
		var ObjLd		= eval("document.forms[0].lab_test3_"+nCtr);
		var ObjLdName	=ObjLd.name;
		
		var bean_id		= document.forms[0].bean_id.value ;
		var bean_name	= document.forms[0].bean_name.value ;	
		var samp_type	= obj.value; //P
		var drug_code	= document.forms[0].drug_code.value;
		var xmlDoc="";
		var xmlHttp = new XMLHttpRequest();

		xmlStr	="<root><SEARCH " ;
		xmlStr += " bean_id=\"" + bean_id + "\"";
		xmlStr += " bean_name=\"" + bean_name + "\"";
		xmlStr += " "+ObjName+"=\"" + samp_type + "\"";
		xmlStr += " "+ObjLdName+"=\"" + ObjLdName + "\"";
		xmlStr += " IdxNo=\"" + nCtr + "\"";
		xmlStr +=" /></root>" ;
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open( "POST", "PrescriptionTDMValidate.jsp?bean_id="+bean_id+"&bean_name="+bean_name+"&identity=getLabTestextended&samp_type="+samp_type+"&drug_code="+drug_code+"&ldObj="+ObjLdName+"&IdxNo="+nCtr, false ) ;

		xmlHttp.send( xmlDoc );
		eval(xmlHttp.responseText);
	//alert("xmlHttp.responseText--"+xmlHttp.responseText);
	}

}

function chkTdmAttributes(){
	alert(getMessage("PH_TDM_ATTR_NOT_RECORDED","PH"));
	parent.tdm_frames.rows="36,300,*,*,*"; 
	parent.frames[2].location.href ="../../eCommon/html/blank.html";
	parent.frames[3].location.href ="../../eCommon/html/blank.html";
	parent.f_tdm_buttons.document.getElementById("Buttons").style.display="none";	   
	if(top.content!=null && top.content!=undefined) {
	   top.content.messageFrame.location.href = "../../eCommon/jsp/error.jsp";
	}
}

function addOption(code, desc, obj) {
	var opt	= eval(document.createElement('OPTION'));
	opt.value =	trimString(code);
	opt.text = desc;
	obj.add(opt);
	opt.selected="selected"; 
}

function clearData(obj) {
	obj = eval(obj);
	var len = obj.length;
	for (var i=0; i<=len; i++){
		obj.remove("");
	}
	var opt	= document.createElement('OPTION');
	opt.value =	"";
	opt.text = "             ";
	obj.add(opt);
}

/*function assignDurationValues(nCtr,ObjVal){
	if(ObjVal=='null' || ObjVal==''){
      ObjVal='1';
	}
	var Obj1 = eval("document.forms[0].samp_type42_"+nCtr);
	Obj1.value  = ObjVal;
	
}  */



function assignDurationValues(nCtr,ObjVal){
	if(ObjVal=='null' || ObjVal==''){
      ObjVal='1';
	}
	var Obj1 = eval("document.forms[0].samp_type42_"+nCtr);
	if(Obj1!=undefined)
	Obj1.value  = ObjVal;
}

 function assignDurationTypes(nCtr,ObjVal){
	if(ObjVal=='null'  || ObjVal==''){
      ObjVal='M';
	}
	var Obj1 = eval("document.forms[0].samp_type43_"+nCtr);
	if(Obj1!=undefined)
	Obj1.value  = ObjVal;
}

/*function assignDurationTypes(nCtr,ObjVal){
	if(ObjVal=='null'  || ObjVal==''){
      ObjVal='M';
	}
	var Obj1 = eval("document.forms[0].samp_type43_"+nCtr);
	Obj1.value  = ObjVal;
}*/

function assignTroughDurationValues(nCtr,ObjVal){
	
	if(ObjVal=='null' || ObjVal==''){
      ObjVal='1';
	}
	var Obj1 = eval("document.forms[0].samp_type5_"+nCtr);
	Obj1.value  = ObjVal;
}

function assignTroughDurationTypes(nCtr,ObjVal){
	if(ObjVal=='null'  || ObjVal==''){
      ObjVal='M';
	}
	var Obj1 = eval("document.forms[0].samp_type6_"+nCtr);
	Obj1.value  = ObjVal;
}

function assignRandomDurationValues(nCtr,ObjVal){
	if(ObjVal=='null' || ObjVal==''){
      ObjVal='1';
	}
	var Obj1 = eval("document.forms[0].samp_type8_"+nCtr);
	Obj1.value  = ObjVal;
}

function assignRandomDurationTypes(nCtr,ObjVal){
	if(ObjVal=='null'  || ObjVal==''){
      ObjVal='M';
	}
	var Obj1 = eval("document.forms[0].samp_type9_"+nCtr);
	Obj1.value  = ObjVal;
}

function assignExtendedDurationValues(nCtr,ObjVal){
	if(ObjVal=='null' || ObjVal==''){
      ObjVal='1';
	}
	var Obj1 = eval("document.forms[0].samp_type12_"+nCtr);
	Obj1.value  = ObjVal;
}

function assignExtendedDurationTypes(nCtr,ObjVal){
	if(ObjVal=='null'  || ObjVal==''){
      ObjVal='M';
	}
	var Obj1 = eval("document.forms[0].samp_type13_"+nCtr);
	Obj1.value  = ObjVal;
}

function clearCmbs(nCtr){
	var Obj = eval("document.forms[0].samp_type43_"+nCtr);
	Obj.value = "";
	var Obj1 = eval("document.forms[0].samp_type42_"+nCtr);
	Obj1.value = "";

	var Obj2 = eval("document.forms[0].lab_test4_"+nCtr);
	
	clearData(Obj2);
	if(eval("document.forms[0].random_option_yn_"+nCtr).value=="Y"){
		if(eval("document.forms[0].samp_type21_"+nCtr).disabled==false){
			eval("document.forms[0].samp_type8_"+nCtr).value="";
			eval("document.forms[0].samp_type9_"+nCtr).value="";
			eval("document.forms[0].lab_test2_"+nCtr).value="";
			eval("document.forms[0].samp_type21_"+nCtr).checked=false;
		}
	}
	if(eval("document.forms[0].extended_option_yn_"+nCtr).value=="Y"){
		if(eval("document.forms[0].samp_type31_"+nCtr).disabled==false){
			eval("document.forms[0].samp_type12_"+nCtr).value="";
			eval("document.forms[0].samp_type13_"+nCtr).value="";
			eval("document.forms[0].lab_test3_"+nCtr).value="";
			eval("document.forms[0].samp_type31_"+nCtr).checked=false;
		}
	}
}

function cleartroughCmbs(nCtr){
	var Obj = eval("document.forms[0].samp_type5_"+nCtr);
	Obj.value = "";
	var Obj1 = eval("document.forms[0].samp_type6_"+nCtr);
	Obj1.value = "";
	var Obj2 = eval("document.forms[0].lab_test1_"+nCtr);
	clearData(Obj2);
	if(eval("document.forms[0].random_option_yn_"+nCtr).value=="Y"){
		if(eval("document.forms[0].samp_type21_"+nCtr).disabled==false){
			eval("document.forms[0].samp_type8_"+nCtr).value="";
			eval("document.forms[0].samp_type9_"+nCtr).value="";
			eval("document.forms[0].lab_test2_"+nCtr).value="";
			eval("document.forms[0].samp_type21_"+nCtr).checked=false;
		}
	}
	if(eval("document.forms[0].extended_option_yn_"+nCtr).value=="Y"){
		if(eval("document.forms[0].samp_type31_"+nCtr).disabled==false){
			eval("document.forms[0].samp_type12_"+nCtr).value="";
			eval("document.forms[0].samp_type13_"+nCtr).value="";
			eval("document.forms[0].lab_test3_"+nCtr).value="";
			eval("document.forms[0].samp_type31_"+nCtr).checked=false;
		}
	}
}

function clearrandomCmbs(nCtr){
	var Obj = eval("document.forms[0].samp_type8_"+nCtr);
	Obj.value = "";
	var Obj1 = eval("document.forms[0].samp_type9_"+nCtr);
	Obj1.value = "";

	var Obj2 = eval("document.forms[0].lab_test2_"+nCtr);
	clearData(Obj2);
	//Trough
	if(eval("document.forms[0].trough_option_yn_"+nCtr).value=="Y")	{
		if(eval("document.forms[0].samp_type11_"+nCtr).disabled==false){
			eval("document.forms[0].samp_type5_"+nCtr).value="";
			eval("document.forms[0].samp_type6_"+nCtr).value="";
			eval("document.forms[0].lab_test1_"+nCtr).value="";
			eval("document.forms[0].samp_type11_"+nCtr).checked=false;
		}
	}
	//peak
	if(eval("document.forms[0].peak_option_yn_"+nCtr).value=="Y"){
		if(eval("document.forms[0].samp_type41_"+nCtr).disabled==false){
			eval("document.forms[0].samp_type43_"+nCtr).value="";
			eval("document.forms[0].samp_type42_"+nCtr).value="";
			eval("document.forms[0].lab_test4_"+nCtr).value="";
			eval("document.forms[0].samp_type41_"+nCtr).checked=false;
		}
	}
	//Extended
	if(eval("document.forms[0].extended_option_yn_"+nCtr).value=="Y"){
		if(eval("document.forms[0].samp_type31_"+nCtr).disabled==false){
			eval("document.forms[0].samp_type12_"+nCtr).value="";
			eval("document.forms[0].samp_type13_"+nCtr).value="";
			eval("document.forms[0].lab_test3_"+nCtr).value="";
			eval("document.forms[0].samp_type31_"+nCtr).checked=false;
		}
	}
}

function clearextendedCmbs(nCtr){
	var Obj = eval("document.forms[0].samp_type12_"+nCtr);
	Obj.value = "";
	var Obj1 = eval("document.forms[0].samp_type13_"+nCtr);
	Obj1.value = "";
	var Obj2 = eval("document.forms[0].lab_test3_"+nCtr);
	clearData(Obj2);
	//Trough
	if(eval("document.forms[0].trough_option_yn_"+nCtr).value=="Y"){
		if(eval("document.forms[0].samp_type11_"+nCtr).disabled==false){
			eval("document.forms[0].samp_type5_"+nCtr).value="";
			eval("document.forms[0].samp_type6_"+nCtr).value="";
			eval("document.forms[0].lab_test1_"+nCtr).value="";
			eval("document.forms[0].samp_type11_"+nCtr).checked=false;
		}
	}
	//peak
	if(eval("document.forms[0].peak_option_yn_"+nCtr).value=="Y"){
		if(eval("document.forms[0].samp_type41_"+nCtr).disabled==false){
			eval("document.forms[0].samp_type43_"+nCtr).value="";
			eval("document.forms[0].samp_type42_"+nCtr).value="";
			eval("document.forms[0].lab_test4_"+nCtr).value="";
			eval("document.forms[0].samp_type41_"+nCtr).checked=false;
		}
	}
	//Random
	if(eval("document.forms[0].random_option_yn_"+nCtr).value=="Y")	{
		if(eval("document.forms[0].samp_type21_"+nCtr).disabled==false)	{
			eval("document.forms[0].samp_type8_"+nCtr).value="";
			eval("document.forms[0].samp_type9_"+nCtr).value="";
			eval("document.forms[0].lab_test2_"+nCtr).value="";
			eval("document.forms[0].samp_type21_"+nCtr).checked=false;
		}
	}
}

function callRecord(){
	var remarks_form					=	parent.f_tdm_request.document.formTDMPrescriptionRemarks;
	var admin_form						=	parent.f_tdm_add_mod.document.formTDMAdminDetls;
	if(remarks_form == undefined || admin_form== undefined)
		return false;
	if(remarks_form.reason_for_req.value==""){
		 alert(getMessage("PH_REASON_NOT_SELECTED","PH"));			 
		 remarks_form.reason_for_req.focus();
		 return;
	}
	admin_form.reason.value				=	remarks_form.reason_for_req.value;
	admin_form.clinical_comments.value	=	remarks_form.clinc_comments.value;
	admin_form.smoking_yn.value			=	remarks_form.smoking.value;
	admin_form.alcohol_yn.value			=	remarks_form.alcohol.value;
	admin_form.pregnant_yn.value		=	remarks_form.pregnant.value;
	eval( formApply( admin_form,PH_CONTROLLER) ) ;

	if( result ){
		if(top.content==null && top.content!=null) {
			top.content.messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num="+message;
			//onSuccess();
			// parent.f_tdm_drug_profile.document.getElementById("chkbox").checked=true;
			// parent.f_tdm_drug_profile.document.getElementById("chkbox").value= "Y";
			parent.parent.f_header.document.getElementById("tdm_link").click();
		} 
		else{
			alert(message)	 ;
			parent.parent.f_header.document.getElementById("tdm_link").click();
		}
	}
	else{		   
		if(top.content!=null && top.content!=undefined) {
			top.content.messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num="+message;
		}
		else{
			alert(message)	 ;
		}
	}
}

function onSuccess(){
	parent.parent.parent.criteriaCategoryButtonFrame.location.reload();
}

function assignResult( _result, _message, _flag ) {
	result = _result ;
	message  = _message ;
	flag = _flag ;
}

function callClear(){
	parent.f_tdm_request.formTDMPrescriptionRemarks.reset(); 
	var count=parent.f_tdm_add_mod.formTDMAdminDetls.row_cnt.value;
	for(var i=0;i<=count;i++){
		obj=eval('parent.f_tdm_add_mod.formTDMAdminDetls.lab_test_'+(i+1));
		if(obj != undefined){
			clearData(obj);  
		}
	}
	parent.f_tdm_add_mod.formTDMAdminDetls.reset();
}

function loadresultpage(obj){
	//parent.tdm_frames.rows="30,300,*,*,20";
	parent.document.getElementById("f_tdm_radio_button").style.height="10vh";
	parent.document.getElementById("f_tdm_drug_profile").style.height="60vh";
	parent.document.getElementById("f_tdm_request").style.height="15vh";
	parent.document.getElementById("f_tdm_add_mod").style.height="15vh";
	parent.document.getElementById("f_tdm_buttons").style.height="9vh";

	var frmrdobj        = parent.f_tdm_radio_button.document.formTDMRadioButton;
	var patient_id		= frmrdobj.patient_id.value;
	var encounter_id	= frmrdobj.encounter_id.value;
	var location_code	= frmrdobj.location_code.value;	
	var location_type	= frmrdobj.location_type.value;	
	var pract_id		= frmrdobj.pract_id.value;	
	var patient_class	= frmrdobj.patient_class.value;
	var flag            = frmrdobj.flag.value;
	var form_code		= "";
	var generic_id		= "";
	
	if(flag==null) {
		flag='D';
	}
	/*	flag-->   D--->   for Against Drug Profile
		flag-->   P--->   for Against poisonous Drug */
	if(flag=='P'){
		form_code    = frmrdobj.From.value;
		generic_id   = frmrdobj.Generic.value;
		//parent.f_tdm_buttons.document.getElementById("Buttons").style.display="none";
		parent.frames[2].location.href ="../../eCommon/html/blank.html";
		parent.frames[3].location.href ="../../eCommon/html/blank.html";
	}
	if(flag=='D'){
		parent.f_tdm_drug_profile.location.href = "PrescriptionTDMDrugDetail.jsp?patient_id="+patient_id+"&encounter_id="+encounter_id+"&location_code="+location_code+"&location_type="+location_type+"&pract_id="+pract_id+"&patient_class="+patient_class+"&flag="+flag; 
	}
	else if(flag=='P'){
		 parent.f_tdm_drug_profile.location.href = "PrescriptionTDMDrugDetail.jsp?patient_id="+patient_id+"&encounter_id="+encounter_id+"&location_code="+location_code+"&location_type="+location_type+"&pract_id="+pract_id+"&patient_class="+patient_class+"&flag="+flag+"&form_code="+form_code+"&generic_id="+generic_id;
	}
}

function   timechk(time1){
	var time=time1.value;
	if(time!=""){
		var retFlag=chkTime(time)

		if(retFlag==false){
			alert(getMessage("INVALID_TIME","PH"));		
			time1.focus();
			return;
		}
		var sysdate=parent.parent.f_header.prescription_header_form.sys_date.value;
		var time2=new Array()
		time2=sysdate.split(" ");

		var sys_time = time2[1];

		var systimearr=new Array();
		systimearr=sys_time.split(":");

		var curr_time=new Array();
		curr_time=time.split(":");

		if(curr_time[0]<systimearr[0]){   
			alert(getMessage("PH_TDM_SYSDATE","PH"));			 
			time1.focus();
			return;
		}
		if(curr_time[0]==systimearr[0])	{   
			if(curr_time[1]<systimearr[1]){
				alert(getMessage("PH_TDM_SYSDATE","PH"));
				time1.focus();
				return;
			}
		}
		var admin_form		=	parent.f_tdm_add_mod.document.formTDMAdminDetls; 
		admin_form.sch_date_time1.value=time2[0]+""+time1.value ;
	}	
}

function enable(obj){
	var frmrdobj = parent.f_tdm_radio_button.document;	
	parent.f_tdm_radio_button.document.formTDMRadioButton.flag.value=obj.value;
	//flag
	if(obj.value=="P"){
		//parent.tdm_frames.rows="36,300,*,*,*";
		parent.document.getElementById("f_tdm_radio_button").style.height="10vh";
		parent.document.getElementById("f_tdm_drug_profile").style.height="60vh";
		parent.document.getElementById("f_tdm_request").style.height="15vh";
		parent.document.getElementById("f_tdm_add_mod").style.height="15vh";
		parent.document.getElementById("f_tdm_buttons").style.height="9vh";
		

		frmrdobj.Gen.style.display="inline";
		frmrdobj.Form1.style.display="inline";
		frmrdobj.Go.style.display="inline";
		parent.f_tdm_radio_button.document.formTDMRadioButton.From.selectedIndex=0;
		parent.f_tdm_radio_button.document.formTDMRadioButton.Generic.selectedIndex=0;
		parent.f_tdm_drug_profile.location.href ="../../eCommon/html/blank.html";
		parent.frames[2].location.href ="../../eCommon/html/blank.html";
		parent.frames[3].location.href ="../../eCommon/html/blank.html";
		//parent.f_tdm_buttons.document.getElementById("Buttons").style.display="none"; //Commented for [IN033196]
		if(top.content!=null && top.content!=undefined) {
			top.content.messageFrame.location.href = "../../eCommon/jsp/error.jsp";
		}
	}
	if(obj.value=="D"){
		if(parent.f_tdm_radio_button.document.formTDMRadioButton.patient_class.value=="OP"){
			alert(getMessage("PH_OP_TDM_NOT_APPLICABLE","PH"));
			parent.f_tdm_radio_button.document.formTDMRadioButton.load_table.value="P";
			parent.f_tdm_radio_button.document.formTDMRadioButton.load_table[1].checked=true;
			parent.f_tdm_radio_button.document.formTDMRadioButton.flag.value="P";
			frmrdobj.Gen.style.display="inline";
			frmrdobj.Form1.style.display="inline";
			frmrdobj.Go.style.display="inline";
			parent.frames[2].location.href ="../../eCommon/html/blank.html";
			parent.frames[3].location.href ="../../eCommon/html/blank.html";
			parent.f_tdm_buttons.document.getElementById("Buttons").style.display="none";
		}
		else{
			frmrdobj.Gen.style.display="none";
			frmrdobj.Form1.style.display="none";
			frmrdobj.Go.style.display="none";
			parent.f_tdm_buttons.document.getElementById("Buttons").style.display="none";
			parent.frames[2].location.href ="../../eCommon/html/blank.html";
			parent.frames[3].location.href ="../../eCommon/html/blank.html";
			if(top.content!=null && top.content!=undefined) {
				top.content.messageFrame.location.href = "../../eCommon/jsp/error.jsp";
			}
		}
	}
}

function setsystime(){
	//ord_date
	var admin_form			=	parent.f_tdm_add_mod.document.formTDMAdminDetls;
	var ord_date             =   admin_form.ord_date.value;
	var time2=new Array()
	time2=ord_date.split(" ");
	var sys_time = time2[1];
	if(sys_time == undefined)
		sys_time = '';
	admin_form.sch_time1.value=sys_time;
	var sysdate=parent.parent.f_header.prescription_header_form.sys_date.value;
	var time2=new Array()
	time2=sysdate.split(" ");
	var sys_date = time2[0];
	admin_form.sch_date_time1.value=sys_date+""+sys_time;
}

function getUpdatedVales(){
	var TDM_Dtl_Form1						=	parent.f_tdm_add_mod.document.formTDMAdminDetls;

	//var order_id=	vOrderNo;
	//TDM_Dtl_Form1.strOrderNo11.value;
	//alert("order_id"+order_id);
	var order_line_num=	vOrderLNum;
	//TDM_Dtl_Form1.strOrderLineNum11.value;
	var patient_id11=	vPatientId
	//TDM_Dtl_Form1.patient_id11.value;
	var encounter_id11=	TDM_Dtl_Form1.encounter_id.value;
	//TDM_Dtl_Form1.encounter_id11.value;
	var bean_id		= "@PrescriptionTDMBean"+TDM_Dtl_Form1.patient_id.value+TDM_Dtl_Form1.encounter_id.value;
	var bean_name	= "ePH.PrescriptionTDMBean" ;	
	var xmlDoc="";
	var xmlHttp = new XMLHttpRequest();

	xmlStr	="<root><SEARCH " ;
	xmlStr += " bean_id=\"" + bean_id + "\"";
	xmlStr += " bean_name=\"" + bean_name + "\"";
	//xmlStr += " "+ObjName+"=\"" + samp_type + "\"";
	//xmlStr += " "+ObjLdName+"=\"" + ObjLdName + "\"";
	//xmlStr += " IdxNo=\"" + nCtr + "\"";
	xmlStr +=" /></root>" ;
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open( "POST", "PrescriptionTDMValidate.jsp?bean_id="+bean_id+"&bean_name="+bean_name+"&identity=getUpdatedStatus"+"&order_id="+TDM_Dtl_Form1.parent_strOrderNo.value+"&order_line_num="+TDM_Dtl_Form1.strOrderLineNum.value, false ) ;
	xmlHttp.send( xmlDoc );
	eval(xmlHttp.responseText);
}

function assignTroughvalue(nOrdCtr,sampling_durn,sampling_durn_type,order_catalog_code,order_catalog_desc,sampling_indicator){
	var TDM_Dtl_Form						=	parent.f_tdm_add_mod.document.formTDMAdminDetls;
	TDM_Dtl_Form.mode_value.value="U";

	if(sampling_durn_type=="M")
			samp_durn_desc=getLabel("Common.Minutes.label","Common");	
	if(sampling_durn_type=="D")
			samp_durn_desc=getLabel("Common.days.label","Common");	
	if(sampling_durn_type=="H")
			samp_durn_desc=getLabel("Common.hours.label","Common");	

	if(sampling_indicator=="B")
		sampling_indicator_value=getLabel("ePH.BeforeDose.label","PH");	
	if(sampling_indicator=="A")
		sampling_indicator_value=getLabel("ePH.AfterDose.label","PH");	

	eval(parent.f_tdm_add_mod.document.getElementById("enable_checkT")+nOrdCtr).value="Done";
	eval(parent.f_tdm_add_mod.document.getElementById("samp_type5_")+nOrdCtr).value=sampling_durn;
	eval(parent.f_tdm_add_mod.document.getElementById("samp_type5_")+nOrdCtr).disabled=true;
	eval(parent.f_tdm_add_mod.document.getElementById("samp_type11_")+nOrdCtr).checked=true;
	eval(parent.f_tdm_add_mod.document.getElementById("samp_type11_")+nOrdCtr).disabled=true;

	//Random
	if(eval(parent.f_tdm_add_mod.document.getElementById("random_option_yn_")+nOrdCtr).value=="Y"){
		eval(parent.f_tdm_add_mod.document.getElementById("samp_type8_")+nOrdCtr).value="";
		eval(parent.f_tdm_add_mod.document.getElementById("samp_type8_")+nOrdCtr).disabled=true;
		eval(parent.f_tdm_add_mod.document.getElementById("samp_type9_")+nOrdCtr).value="";
		eval(parent.f_tdm_add_mod.document.getElementById("samp_type9_")+nOrdCtr).disabled=true;
		eval(parent.f_tdm_add_mod.document.getElementById("lab_test2_")+nOrdCtr).value="";
		eval(parent.f_tdm_add_mod.document.getElementById("lab_test2_")+nOrdCtr).disabled=true;
		eval(parent.f_tdm_add_mod.document.getElementById("samp_type21_")+nOrdCtr).disabled=true;
		eval(parent.f_tdm_add_mod.document.getElementById("samp_type21_")+nOrdCtr).checked=false;
		eval(parent.f_tdm_add_mod.document.getElementById("when_doseAB2_")+nOrdCtr).disabled=true;;
		eval(parent.f_tdm_add_mod.document.getElementById("when_doseAB2_")+nOrdCtr).value="";
	}
	//Extended
	if(eval(parent.f_tdm_add_mod.document.getElementById("extended_option_yn_")+nOrdCtr).value=="Y"){
		eval(parent.f_tdm_add_mod.document.getElementById("samp_type12_")+nOrdCtr).value="";
		eval(parent.f_tdm_add_mod.document.getElementById("samp_type12_")+nOrdCtr).disabled=true;
		eval(parent.f_tdm_add_mod.document.getElementById("samp_type13_")+nOrdCtr).value="";
		eval(parent.f_tdm_add_mod.document.getElementById("samp_type13_")+nOrdCtr).disabled=true;
		eval(parent.f_tdm_add_mod.document.getElementById("lab_test3_")+nOrdCtr).value="";
		eval(parent.f_tdm_add_mod.document.getElementById("lab_test3_")+nOrdCtr).disabled=true;
		eval(parent.f_tdm_add_mod.document.getElementById("samp_type31_")+nOrdCtr).disabled=true;
		eval(parent.f_tdm_add_mod.document.getElementById("samp_type31_")+nOrdCtr).checked=false;
		eval(parent.f_tdm_add_mod.document.getElementById("when_doseAB3_")+nOrdCtr).disabled=true;
		eval(parent.f_tdm_add_mod.document.getElementById("when_doseAB3_")+nOrdCtr).value="";
	}
	var len=eval(parent.f_tdm_add_mod.document.getElementById("samp_type6_")+nOrdCtr).length;
	for (var i=0; i<=len; i++) {
		eval(parent.f_tdm_add_mod.document.getElementById("samp_type6_")+nOrdCtr).remove("") ;
	}
	var tp = samp_durn_desc;
	var opt = document.createElement("OPTION") ;
	opt.text = tp ;
	opt.value = sampling_durn_type;
	eval(parent.f_tdm_add_mod.document.getElementById("samp_type6_")+nOrdCtr).add(opt);
	eval(parent.f_tdm_add_mod.document.getElementById("samp_type6_")+nOrdCtr).disabled=true;
	
	var index_len=eval(parent.f_tdm_add_mod.document.getElementById("when_doseAB0_")+nOrdCtr).length;
	for (var k=0; k<=index_len; k++){
		eval(parent.f_tdm_add_mod.document.getElementById("when_doseAB0_")+nOrdCtr).remove("") ;
	}
	var tp0 = sampling_indicator_value;
	var opt0 = document.createElement("OPTION") ;
	opt0.text = tp0 ;
	opt0.value = sampling_indicator;
	eval(parent.f_tdm_add_mod.document.getElementById("when_doseAB0_")+nOrdCtr).add(opt0);
	eval(parent.f_tdm_add_mod.document.getElementById("when_doseAB0_")+nOrdCtr).disabled=true;

	var lab_len=eval(parent.f_tdm_add_mod.document.getElementById("lab_test1_")+nOrdCtr).length;
	for (var j=0; j<=lab_len; j++) {
		eval(parent.f_tdm_add_mod.document.getElementById("lab_test1_")+nOrdCtr).remove("") ;
		
	}
	var tp1 = order_catalog_desc;
	var opt1 = document.createElement("OPTION") ;
	opt1.text = tp1 ;
	opt1.value = order_catalog_code;
	eval(parent.f_tdm_add_mod.document.getElementById("lab_test1_")+nOrdCtr).add(opt1);
	eval(parent.f_tdm_add_mod.document.getElementById("lab_test1_")+nOrdCtr).disabled=true;
}

function assignPeakvalue(nOrdCtr,sampling_durn,sampling_durn_type,order_catalog_code,order_catalog_desc,sampling_indicator){
	var TDM_Dtl_Form						=	parent.f_tdm_add_mod.document.formTDMAdminDetls;
	TDM_Dtl_Form.mode_value.value="U";
	if(sampling_durn_type=="M")
			samp_durn_desc=getLabel("Common.Minutes.label","Common");
	if(sampling_durn_type=="D")
			samp_durn_desc=getLabel("Common.days.label","Common");	
	if(sampling_durn_type=="H")
			samp_durn_desc=getLabel("Common.hours.label","Common");	
	if(sampling_indicator=="B")
		sampling_indicator_value=getLabel("ePH.BeforeDose.label","PH");	
	if(sampling_indicator=="A")
		sampling_indicator_value=getLabel("ePH.AfterDose.label","PH");	

	eval(parent.f_tdm_add_mod.document.getElementById("enable_checkP")+nOrdCtr).value="Done";
	eval(parent.f_tdm_add_mod.document.getElementById("samp_type41_")+nOrdCtr).checked=true;
	eval(parent.f_tdm_add_mod.document.getElementById("samp_type41_")+nOrdCtr).disabled=true;
	eval(parent.f_tdm_add_mod.document.getElementById("samp_type42_")+nOrdCtr).value=sampling_durn;
	eval(parent.f_tdm_add_mod.document.getElementById("samp_type42_")+nOrdCtr).disabled=true;

	//Random
	if(eval(parent.f_tdm_add_mod.document.getElementById("random_option_yn_")+nOrdCtr).value=="Y"){
		eval(parent.f_tdm_add_mod.document.getElementById("samp_type8_")+nOrdCtr).value="";
		eval(parent.f_tdm_add_mod.document.getElementById("samp_type8_")+nOrdCtr).disabled=true;
		eval(parent.f_tdm_add_mod.document.getElementById("samp_type9_")+nOrdCtr).value="";
		eval(parent.f_tdm_add_mod.document.getElementById("samp_type9_")+nOrdCtr).disabled=true;
		eval(parent.f_tdm_add_mod.document.getElementById("lab_test2_")+nOrdCtr).value="";
		eval(parent.f_tdm_add_mod.document.getElementById("lab_test2_")+nOrdCtr).disabled=true;
		eval(parent.f_tdm_add_mod.document.getElementById("samp_type21_")+nOrdCtr).disabled=true;
		eval(parent.f_tdm_add_mod.document.getElementById("samp_type21_")+nOrdCtr).checked=false;
		eval(parent.f_tdm_add_mod.document.getElementById("when_doseAB2_")+nOrdCtr).disabled=true;;
		eval(parent.f_tdm_add_mod.document.getElementById("when_doseAB2_")+nOrdCtr).value="";
	}
	//Extended
	if(eval(parent.f_tdm_add_mod.document.getElementById("extended_option_yn_")+nOrdCtr).value=="Y"){
		eval(parent.f_tdm_add_mod.document.getElementById("samp_type12_")+nOrdCtr).value="";
		eval(parent.f_tdm_add_mod.document.getElementById("samp_type12_")+nOrdCtr).disabled=true;
		eval(parent.f_tdm_add_mod.document.getElementById("samp_type13_")+nOrdCtr).value="";
		eval(parent.f_tdm_add_mod.document.getElementById("samp_type13_")+nOrdCtr).disabled=true;
		eval(parent.f_tdm_add_mod.document.getElementById("lab_test3_")+nOrdCtr).value="";
		eval(parent.f_tdm_add_mod.document.getElementById("lab_test3_")+nOrdCtr).disabled=true;
		eval(parent.f_tdm_add_mod.document.getElementById("samp_type31_")+nOrdCtr).disabled=true;
		eval(parent.f_tdm_add_mod.document.getElementById("samp_type31_")+nOrdCtr).checked=false;
		eval(parent.f_tdm_add_mod.document.getElementById("when_doseAB3_")+nOrdCtr).disabled=true;;
		eval(parent.f_tdm_add_mod.document.getElementById("when_doseAB3_")+nOrdCtr).value="";
	}
	var len=eval(parent.f_tdm_add_mod.document.getElementById("samp_type43_")+nOrdCtr).length;
	for (var i=0; i<=len; i++){
		eval(parent.f_tdm_add_mod.document.getElementById("samp_type43_")+nOrdCtr).remove("") ;
	}
	var tp = samp_durn_desc;
	var opt = document.createElement("OPTION") ;
	opt.text = tp ;
	opt.value = sampling_durn_type;
	eval(parent.f_tdm_add_mod.document.getElementById("samp_type43_")+nOrdCtr).add(opt);
	eval(parent.f_tdm_add_mod.document.getElementById("samp_type43_")+nOrdCtr).disabled=true;

	
	var index_len=eval(parent.f_tdm_add_mod.document.getElementById("when_doseAB1_")+nOrdCtr).length;
	for (var k=0; k<=index_len; k++) {
		eval(parent.f_tdm_add_mod.document.getElementById("when_doseAB1_")+nOrdCtr).remove("") ;
	}
	var tp0 = sampling_indicator_value;
	var opt0 = document.createElement("OPTION") ;
	opt0.text = tp0 ;
	opt0.value = sampling_indicator;
	eval(parent.f_tdm_add_mod.document.getElementById("when_doseAB1_")+nOrdCtr).add(opt0);
	eval(parent.f_tdm_add_mod.document.getElementById("when_doseAB1_")+nOrdCtr).disabled=true;

	var lab_len=eval(parent.f_tdm_add_mod.document.getElementById("lab_test4_")+nOrdCtr).length;
	for (var j=0; j<=lab_len; j++) {
		eval(parent.f_tdm_add_mod.document.getElementById("lab_test4_")+nOrdCtr).remove("") ;
	}
	var tp1 = order_catalog_desc;
	var opt1 = document.createElement("OPTION") ;
	opt1.text = tp1 ;
	opt1.value = order_catalog_code;
	eval(parent.f_tdm_add_mod.document.getElementById("lab_test4_")+nOrdCtr).add(opt1);
	eval(parent.f_tdm_add_mod.document.getElementById("lab_test4_")+nOrdCtr).disabled=true;
}

function assignRandomvalue(nOrdCtr,sampling_durn,sampling_durn_type,order_catalog_code,order_catalog_desc,sampling_indicator){
	var TDM_Dtl_Form						=	parent.f_tdm_add_mod.document.formTDMAdminDetls;
	TDM_Dtl_Form.mode_value.value="U";
	if(sampling_durn_type=="M")
			samp_durn_desc=getLabel("Common.Minutes.label","Common");	
	if(sampling_durn_type=="D")
			samp_durn_desc=getLabel("Common.days.label","Common");	
	if(sampling_durn_type=="H")
			samp_durn_desc=getLabel("Common.hours.label","Common");	

	if(sampling_indicator!=""){
		if(sampling_indicator=="B")
			sampling_indicator_value=getLabel("ePH.BeforeDose.label","PH");	
		if(sampling_indicator=="A")
			sampling_indicator_value=getLabel("ePH.AfterDose.label","PH");	
	 }
	 else{
		 sampling_indicator_value="---"+getLabel("Common.defaultSelect.label","Common")+"---";	
	}
	eval(parent.f_tdm_add_mod.document.getElementById("enable_checkR")+nOrdCtr).value="Done";
	eval(parent.f_tdm_add_mod.document.getElementById("samp_type21_")+nOrdCtr).checked=true;
	eval(parent.f_tdm_add_mod.document.getElementById("samp_type21_")+nOrdCtr).disabled=true;
	eval(parent.f_tdm_add_mod.document.getElementById("samp_type8_")+nOrdCtr).value=sampling_durn;
	eval(parent.f_tdm_add_mod.document.getElementById("samp_type8_")+nOrdCtr).disabled=true;

	//Trough
	if(eval(parent.f_tdm_add_mod.document.getElementById("trough_option_yn_")+nOrdCtr).value=="Y"){
		eval(parent.f_tdm_add_mod.document.getElementById("samp_type5_")+nOrdCtr).value="";
		eval(parent.f_tdm_add_mod.document.getElementById("samp_type5_")+nOrdCtr).disabled=true;
		eval(parent.f_tdm_add_mod.document.getElementById("samp_type6_")+nOrdCtr).value="";
		eval(parent.f_tdm_add_mod.document.getElementById("samp_type6_")+nOrdCtr).disabled=true;
		eval(parent.f_tdm_add_mod.document.getElementById("lab_test1_")+nOrdCtr).value="";
		eval(parent.f_tdm_add_mod.document.getElementById("lab_test1_")+nOrdCtr).disabled=true;
		eval(parent.f_tdm_add_mod.document.getElementById("samp_type11_")+nOrdCtr).disabled=true;
		eval(parent.f_tdm_add_mod.document.getElementById("samp_type11_")+nOrdCtr).checked=false;
		eval(parent.f_tdm_add_mod.document.getElementById("when_doseAB0_")+nOrdCtr).disabled=true;;
		eval(parent.f_tdm_add_mod.document.getElementById("when_doseAB0_")+nOrdCtr).value="";
	}
	//Peak
	if(eval(parent.f_tdm_add_mod.document.getElementById("peak_option_yn_")+nOrdCtr).value=="Y"){
		eval(parent.f_tdm_add_mod.document.getElementById("samp_type41_")+nOrdCtr).value="";
		eval(parent.f_tdm_add_mod.document.getElementById("samp_type41_")+nOrdCtr).disabled=true;
		eval(parent.f_tdm_add_mod.document.getElementById("samp_type42_")+nOrdCtr).value="";
		eval(parent.f_tdm_add_mod.document.getElementById("samp_type42_")+nOrdCtr).disabled=true;
		eval(parent.f_tdm_add_mod.document.getElementById("lab_test4_")+nOrdCtr).value="";
		eval(parent.f_tdm_add_mod.document.getElementById("lab_test4_")+nOrdCtr).disabled=true;
		eval(parent.f_tdm_add_mod.document.getElementById("samp_type43_")+nOrdCtr).disabled=true;
		eval(parent.f_tdm_add_mod.document.getElementById("samp_type43_")+nOrdCtr).checked=false;
		eval(parent.f_tdm_add_mod.document.getElementById("when_doseAB1_")+nOrdCtr).disabled=true;;
		eval(parent.f_tdm_add_mod.document.getElementById("when_doseAB1_")+nOrdCtr).value="";
	}
	//Extended
	if(eval(parent.f_tdm_add_mod.document.getElementById("extended_option_yn_")+nOrdCtr).value=="Y"){
		eval(parent.f_tdm_add_mod.document.getElementById("samp_type12_")+nOrdCtr).value="";
		eval(parent.f_tdm_add_mod.document.getElementById("samp_type12_")+nOrdCtr).disabled=true;
		eval(parent.f_tdm_add_mod.document.getElementById("samp_type13_")+nOrdCtr).value="";
		eval(parent.f_tdm_add_mod.document.getElementById("samp_type13_")+nOrdCtr).disabled=true;
		eval(parent.f_tdm_add_mod.document.getElementById("lab_test3_")+nOrdCtr).value="";
		eval(parent.f_tdm_add_mod.document.getElementById("lab_test3_")+nOrdCtr).disabled=true;
		eval(parent.f_tdm_add_mod.document.getElementById("samp_type31_")+nOrdCtr).disabled=true;
		eval(parent.f_tdm_add_mod.document.getElementById("samp_type31_")+nOrdCtr).checked=false;
		eval(parent.f_tdm_add_mod.document.getElementById("when_doseAB3_")+nOrdCtr).disabled=true;;
		eval(parent.f_tdm_add_mod.document.getElementById("when_doseAB3_")+nOrdCtr).value="";
	}

	var len=eval(parent.f_tdm_add_mod.document.getElementById("samp_type9_")+nOrdCtr).length;
	for (var i=0; i<=len; i++) {
		eval(parent.f_tdm_add_mod.document.getElementById("samp_type9_")+nOrdCtr).remove("") ;
	}
	var tp = samp_durn_desc;
	var opt = document.createElement("OPTION") ;
	opt.text = tp ;
	opt.value = sampling_durn_type;
	eval(parent.f_tdm_add_mod.document.getElementById("samp_type9_")+nOrdCtr).add(opt);
	eval(parent.f_tdm_add_mod.document.getElementById("samp_type9_")+nOrdCtr).disabled=true;

	
	var index_len=eval(parent.f_tdm_add_mod.document.getElementById("when_doseAB2_")+nOrdCtr).length;
	for (var k=0; k<=index_len; k++) {
		eval(parent.f_tdm_add_mod.document.getElementById("when_doseAB2_")+nOrdCtr).remove("") ;
	}
	var tp0 = sampling_indicator_value;
	var opt0 = document.createElement("OPTION") ;
	opt0.text = tp0 ;
	opt0.value = sampling_indicator;
	eval(parent.f_tdm_add_mod.document.getElementById("when_doseAB2_")+nOrdCtr).add(opt0);
	eval(parent.f_tdm_add_mod.document.getElementById("when_doseAB2_")+nOrdCtr).disabled=true;

	var lab_len=eval(parent.f_tdm_add_mod.document.getElementById("lab_test2_")+nOrdCtr).length;
	for (var j=0; j<=lab_len; j++) {
		eval(parent.f_tdm_add_mod.document.getElementById("lab_test2_")+nOrdCtr).remove("") ;
		
	}
	var tp1 = order_catalog_desc;
	var opt1 = document.createElement("OPTION") ;
	opt1.text = tp1 ;
	opt1.value = order_catalog_code;
	eval(parent.f_tdm_add_mod.document.getElementById("lab_test2_")+nOrdCtr).add(opt1);
	eval(parent.f_tdm_add_mod.document.getElementById("lab_test2_")+nOrdCtr).disabled=true;
}

function assignExtendedvalue(nOrdCtr,sampling_durn,sampling_durn_type,order_catalog_code,order_catalog_desc,sampling_indicator){
	var TDM_Dtl_Form						=	parent.f_tdm_add_mod.document.formTDMAdminDetls;
	TDM_Dtl_Form.mode_value.value="U";
	if(sampling_durn_type=="M")
		samp_durn_desc=getLabel("Common.Minutes.label","Common");	
	if(sampling_durn_type=="D")
		samp_durn_desc=getLabel("Common.days.label","Common");	
	if(sampling_durn_type=="H")
		samp_durn_desc=getLabel("Common.hours.label","Common");	

	if(sampling_indicator=="B")
		sampling_indicator_value=getLabel("ePH.BeforeDose.label","PH");	
	if(sampling_indicator=="A")
		sampling_indicator_value=getLabel("ePH.AfterDose.label","PH");	

	eval(parent.f_tdm_add_mod.document.getElementById("enable_checkE")+nOrdCtr).value="Done";
	eval(parent.f_tdm_add_mod.document.getElementById("samp_type31_")+nOrdCtr).checked=true;
	eval(parent.f_tdm_add_mod.document.getElementById("samp_type31_")+nOrdCtr).disabled=true;
	eval(parent.f_tdm_add_mod.document.getElementById("samp_type12_")+nOrdCtr).value=sampling_durn;
	eval(parent.f_tdm_add_mod.document.getElementById("samp_type12_")+nOrdCtr).disabled=true;
	//Trough
	if(eval(parent.f_tdm_add_mod.document.getElementById("trough_option_yn_")+nOrdCtr).value=="Y"){
		eval(parent.f_tdm_add_mod.document.getElementById("samp_type5_")+nOrdCtr).value="";
		eval(parent.f_tdm_add_mod.document.getElementById("samp_type5_")+nOrdCtr).disabled=true;
		eval(parent.f_tdm_add_mod.document.getElementById("samp_type6_")+nOrdCtr).value="";
		eval(parent.f_tdm_add_mod.document.getElementById("samp_type6_")+nOrdCtr).disabled=true;
		eval(parent.f_tdm_add_mod.document.getElementById("lab_test1_")+nOrdCtr).value="";
		eval(parent.f_tdm_add_mod.document.getElementById("lab_test1_")+nOrdCtr).disabled=true;
		eval(parent.f_tdm_add_mod.document.getElementById("samp_type11_")+nOrdCtr).disabled=true;
		eval(parent.f_tdm_add_mod.document.getElementById("samp_type11_")+nOrdCtr).checked=false;
		eval(parent.f_tdm_add_mod.document.getElementById("when_doseAB0_")+nOrdCtr).disabled=true;;
		eval(parent.f_tdm_add_mod.document.getElementById("when_doseAB0_")+nOrdCtr).value="";
	}
	//Peak
	if(eval(parent.f_tdm_add_mod.document.getElementById("peak_option_yn_")+nOrdCtr).value=="Y"){
		eval(parent.f_tdm_add_mod.document.getElementById("samp_type41_")+nOrdCtr).value="";
		eval(parent.f_tdm_add_mod.document.getElementById("samp_type41_")+nOrdCtr).disabled=true;
		eval(parent.f_tdm_add_mod.document.getElementById("samp_type42_")+nOrdCtr).value="";
		eval(parent.f_tdm_add_mod.document.getElementById("samp_type42_")+nOrdCtr).disabled=true;
		eval(parent.f_tdm_add_mod.document.getElementById("lab_test4_")+nOrdCtr).value="";
		eval(parent.f_tdm_add_mod.document.getElementById("lab_test4_")+nOrdCtr).disabled=true;
		eval(parent.f_tdm_add_mod.document.getElementById("samp_type43_")+nOrdCtr).disabled=true;
		eval(parent.f_tdm_add_mod.document.getElementById("samp_type43_")+nOrdCtr).checked=false;
		eval(parent.f_tdm_add_mod.document.getElementById("when_doseAB1_")+nOrdCtr).disabled=true;;
		eval(parent.f_tdm_add_mod.document.getElementById("when_doseAB1_")+nOrdCtr).value="";
	}
	//Random
	if(eval(parent.f_tdm_add_mod.document.getElementById("random_option_yn_")+nOrdCtr).value=="Y"){
		eval(parent.f_tdm_add_mod.document.getElementById("samp_type8_")+nOrdCtr).value="";
		eval(parent.f_tdm_add_mod.document.getElementById("samp_type8_")+nOrdCtr).disabled=true;
		eval(parent.f_tdm_add_mod.document.getElementById("samp_type9_")+nOrdCtr).value="";
		eval(parent.f_tdm_add_mod.document.getElementById("samp_type9_")+nOrdCtr).disabled=true;
		eval(parent.f_tdm_add_mod.document.getElementById("lab_test2_")+nOrdCtr).value="";
		eval(parent.f_tdm_add_mod.document.getElementById("lab_test2_")+nOrdCtr).disabled=true;
		eval(parent.f_tdm_add_mod.document.getElementById("samp_type21_")+nOrdCtr).disabled=true;
		eval(parent.f_tdm_add_mod.document.getElementById("samp_type21_")+nOrdCtr).checked=false;
		eval(parent.f_tdm_add_mod.document.getElementById("when_doseAB2_")+nOrdCtr).disabled=true;;
		eval(parent.f_tdm_add_mod.document.getElementById("when_doseAB2_")+nOrdCtr).value="";
	}

	var len=eval(parent.f_tdm_add_mod.document.getElementById("samp_type13_")+nOrdCtr).length;
	for (var i=0; i<=len; i++) 	{
		eval(parent.f_tdm_add_mod.document.getElementById("samp_type13_")+nOrdCtr).remove("") ;
	}
	var tp = samp_durn_desc;
	var opt = document.createElement("OPTION") ;
	opt.text = tp ;
	opt.value = sampling_durn_type;
	eval(parent.f_tdm_add_mod.document.getElementById("samp_type13_")+nOrdCtr).add(opt);
	eval(parent.f_tdm_add_mod.document.getElementById("samp_type13_")+nOrdCtr).disabled=true;

	var index_len=eval(parent.f_tdm_add_mod.document.getElementById("when_doseAB3_")+nOrdCtr).length;
	for (var k=0; k<=index_len; k++) {
		eval(parent.f_tdm_add_mod.document.getElementById("when_doseAB3_")+nOrdCtr).remove("") ;
	}
	var tp0 = sampling_indicator_value;
	var opt0 = document.createElement("OPTION") ;
	opt0.text = tp0 ;
	opt0.value = sampling_indicator;
	eval(parent.f_tdm_add_mod.document.getElementById("when_doseAB3_")+nOrdCtr).add(opt0);
	eval(parent.f_tdm_add_mod.document.getElementById("when_doseAB3_")+nOrdCtr).disabled=true;
	var lab_len=eval(parent.f_tdm_add_mod.document.getElementById("lab_test3_")+nOrdCtr).length;
	for (var j=0; j<=lab_len; j++) {
		eval(parent.f_tdm_add_mod.document.getElementById("lab_test3_")+nOrdCtr).remove("") ;
	}
	var tp1 = order_catalog_desc;
	var opt1 = document.createElement("OPTION") ;
	opt1.text = tp1 ;
	opt1.value = order_catalog_code;
	eval(parent.f_tdm_add_mod.document.getElementById("lab_test3_")+nOrdCtr).add(opt1);
	eval(parent.f_tdm_add_mod.document.getElementById("lab_test3_")+nOrdCtr).disabled=true;
}
