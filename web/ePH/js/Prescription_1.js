/***********saved on 25th October 2005 ******************/
/*
----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
Date			Edit History 		Name		Rev.Date		Rev.Name				Description
----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
07/01/2019		IN068345		    Devindra				 		                    Required changes in item substitute mapping setup
10/01/2019	  	IN068344	     	Manickavasagam 		  								GHL-CRF-0549 [IN068344] 
28/05/2019	    IN:067951	            Devindra			                            MMS-KH-CRF-0016
26/07/2019      IN:070451           B Haribabu  27/07/2019      Manickam                 ML-MMOH-CRF-1408
07/08/2019      IN:071048           Manickavasagam J	  	   Manickavasagam J			  SKR-SCF-1262
10/10/2019  IN070786                PRATHYUSHA                       MMS-KH-CRF-0016.1
08/11/2019      IN070606           Manickavasagam J	  	   Manickavasagam J			  MMS-KH-CRF-0029[IN070606]
03/12/2019      IN070606           Manickavasagam J	  	   Manickavasagam J			  MMS-KH-CRF-0029[IN070606]
21/01/2020		IN:071595          Manickavasagam          MO-CRF-20159
29/05/2020	IN:072092	        Manickavasagam J 			     GHL-CRF-0618
09/06/2020  IN:072715              Haribabu                                           MMS-DM-CRF-0165
18/06/2020	IN:073155	        Manickavasagam J			     KDAH-SCF-0640
1/7/2020		IN073202			    Shazana												SKR-SCF-1343
20/07/2020      IN073484          Prabha                                             Exceed Dosage Limit Icon getting Server error
28/07/2020      IN:073485                   Haribabu                                PH-MMS-DM-CRF-0165/01-Normal rx-Amend order
02/09/2020  IN073795                Manickavasagam J                       MMS-KH-CRF-0034.4[73844]
19/10/2020	IN072263		Manickavasagam	 PMG2020-ICN-001
20/10/2020      IN:069886         Haribabu                       Manickam            MO-CRF-20151
02/11/2020   IN074323         	  Prabha    02/11/2020		 Manickavasagam J	     SKR-SCF-1457
06/11/2020      IN:069887              Haribabu                           MO-CRF-20152
10/11/2020	6041				Shazana       										NMC-JD-CRF-0063
16/12/2020		IN:10422			Prabha		16/12/2020	   Manickavasagam J        NMC-JD-SCF-0121
13/1/2020	12491					Shazana												NMC-JD-CRF-0063
22-05-2022                        prathyusha                                           AAKH-CRF-0140
23/05/2023   43528                SREENADH.M                   Suhail                  ML-MMOH-CRF-1823
----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
*/  
var function_id = "" ;
var result = false ;
var message = "" ;
var flag = "" ;
var allergy_result=false;
var availOrdCatCode=false;
var DuplicateDrugCode=false; 
var refresh_screen=true;
var oldrepeatvalue;
var return_val  = true;
var pres_vals	=	new Array();
var i			=	0;
var formatId	=	"";
var drug_code	=	""; 
var durn_type_list	=	new Array();
var flagbilling = "N";//added for performance issue MMS
var prn_remark_flag = true;  //SKR-SCF-1270

//common for calling TEMP JSP for Validations
async function fieldValidation(xmlStr,source){
	var xmlDoc = "" ;
    var xmlHttp = new XMLHttpRequest() ;
    xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
    xmlHttp.open("POST","PrescriptionValidation_1.jsp?func_mode="+source,false);
    xmlHttp.send(xmlDoc);
    responseText=xmlHttp.responseText ;
	await eval(responseText);
    return true;
}

//common for forming XML String
function formXMLString(formobj,fldString){
	var bean_id=formobj.bean_id.value;
	var bean_name=formobj.bean_name.value;
	if(formobj.presBean_id != undefined){
		var presBean_id=formobj.presBean_id.value;
		var presBean_name=formobj.presBean_name.value;
	}
	var mode=formobj.mode.value;
	var xmlStr ="<root><SEARCH ";
	xmlStr += " bean_id=\""+ bean_id + "\" ";
	xmlStr += " bean_name=\""+ bean_name + "\" ";
	if(formobj.presBean_id != undefined){
		xmlStr += " presBean_id=\""+ presBean_id + "\" ";
		xmlStr += " presBean_name=\""+ presBean_name + "\" ";
	}
	xmlStr += " mode=\""+ mode + "\" ";
	xmlStr +=fldString;
	xmlStr +=" /></root>";
	return xmlStr;
}

//common for Take Home(Discharge) Medication assign check box value
function assignValue(obj){
	if(obj.checked==true)
		obj.value="Y";
	else
		obj.value="N";
	checkForDischarge(obj);
}
//For (patient Brought Medication) Checkboxes
function assignValue1(obj){
	if(obj.checked==true){
		obj.value="Y";		
	}
	else{
		obj.value="N";
	}
}

function assignValue2(obj){
	if(obj!=undefined){
		if( obj.checked==true)	{
			obj.value="Y";
			document.getElementById('gross_charge_amt').innerHTML ="--";//added for ML-BRU-CRF-0469
			document.getElementById('bl_total_charge_amt').innerHTML ="--";    //added for IN21314 --10/06/2010-- priya
			document.getElementById('bl_patient_payable_amt').innerHTML = "--";		
			getChargeDetails(document.getElementById('in_formulary_yn').value); // added for IN23880 --25/10/2010-- priya
		}
		else{
			obj.value="N";
			getChargeDetails(document.getElementById('in_formulary_yn').value);
		}
	}
}

function validateBSA(){
	var height=document.prescription_header_form.height.value;
	var weight=document.prescription_header_form.weight.value;
	var presBean_id=document.prescription_header_form.presBean_id.value;
	var presBean_name=document.prescription_header_form.presBean_name.value;
	if( (height!="") && (weight!="") ){
		var fldString="  height=\""+ height + "\" ";
		fldString += " weight=\""+ weight + "\" ";
		var formobj=document.prescription_header_form;
		var xmlStr=formXMLString(formobj,fldString);
		return fieldValidation(xmlStr,"validateBSA");
	}
	else {
		document.prescription_header_form.bsa.value	=	"";
		document.prescription_header_form.bmi.value	=	"";
		document.getElementById('bsa_lbl').innerHTML	=	"";
		document.getElementById('bmi_lbl').innerHTML	=	"";
	}
}

function assignBSA(bsa,bmi){
	var index	=	bmi.indexOf(".");	
	bmi			=(bmi.substr(0,index+3));

	document.prescription_header_form.bsa.value	=	bsa;
	document.prescription_header_form.bmi.value	=	bmi;
	document.getElementById('bsa_lbl').innerHTML				=	"<b>"+bsa+"</b>";
	document.getElementById('bmi_lbl').innerHTML				=	"<b>"+bmi+"</b>";

	/*if( parent.f_detail.prescription_detail_form.drug_code.value!="") {
		//parent.f_detail.document.getElementById("rec_legend").innerText = "Recommended";
		//parent.f_detail.document.getElementById("rec_uom").innerText	=	parent.f_detail.document.prescription_detail_form.strength_uom_desc.value+"/kg";
	}*/
}

function getDrugClass(obj){
	if(document.prescription_header_form.order_type_code_yn.value="Y"){
		var order_type		= obj.value;
		var formobj			= document.prescription_header_form;
		var fldString		= " order_type=\""+ order_type + "\" ";
		var xmlStr			= formXMLString(formobj,fldString);
		return fieldValidation(xmlStr,"getDrugClass");
	}
}

function assignDrugClass(drug_class){
	document.prescription_header_form.drug_class.value=drug_class;
}

/*function displayDate(obj){
	var calculated_date=document.prescription_header_form.calculated_date;
	if(obj.value!=''){
		if(doDateTimeChk(obj)){
			if(calculated_date!=""){
				if(ValidateDateTime(obj,calculated_date)){

				}
				else{
					alert(getMessage("PH_ORDER_DATE", "PH"));
					obj.value=document.prescription_header_form.ref_sys_date.value;
				}
			}
		}
		else{
			alert(getMessage("INVALID_DATE_TIME", "PH"));
			obj.focus;
		}
	}
	else{
		obj.value=document.prescription_header_form.ref_sys_date.value;
		document.prescription_header_form.order_type.focus();
	}
}
*/

function disablePriority(obj,param){
	//obj.disabled=true;
	//loadOtherFrames(param);
}

function CheckRemMaxLen(lab,frm) { 
	var val = "";
	if(document.prescription_remarks != undefined)
		obj = document.prescription_remarks.order_remarks;
	else
		obj = parent.remarks_detail.document.prescription_remarks.order_remarks;
	val = obj.value;
	if(lab=="ClinicalComments"){
		if(obj.value.length > 1000) {
		var msg = getMessage("REMARKS_CANNOT_EXCEED","Common");
		msg = msg.replace("$","Clinical Comments");
		msg = msg.replace("#",1000);
		obj.value = val.substring(0,(val.length)-1);
		alert(msg);
		if(frm == "blr")
			obj.focus();
		return false;
	} 
	else 
		return true;
	}
}

function saveRemarks(obj,called_from){

	var remarks		= obj.order_remarks.value;
	if(called_from != "ClinicalComments" || CheckMaxLen(called_from)){
		var bean_id		= obj.bean_id.value;
		var bean_name	= obj.bean_name.value;
		var mode		= "0";	
		var xmlStr		= "<root><SEARCH ";
			xmlStr	   += " bean_id=\""+ bean_id + "\" ";
			xmlStr     += " bean_name=\""+ bean_name + "\" ";
			xmlStr     += " mode=\""+ mode + "\" ";
			xmlStr     += " remarks=\""+encodeURIComponent(remarks) + "\" ";    //order_remarks encoded for SRR20056-SCF-6664[IN026181]
			//xmlStr     += " remarks=\""+ remarks + "\" ";
			xmlStr     += " /></root>";
		parent.window.close();
		return fieldValidation(xmlStr,"saveRemarks");
	}
	else{
		return false;
	}
}

function populateFrequency(freq_code,call_mode){

	var formobj		=	document.prescription_detail_form;
	var pat_class	=	formobj.patient_class.value;
	var drug_code	=	formobj.drug_code.value;		
	var fldString	=" freq_code=\""+ freq_code + "\" ";
		fldString  +=" call_mode=\""+ call_mode + "\" ";
		fldString  +=" pat_class=\""+ pat_class + "\" ";
		fldString  +=" drug_code=\""+ drug_code + "\" ";
	var xmlStr      =formXMLString(formobj,fldString);
	return fieldValidation(xmlStr,"populateFrequency");
}

function clearFrequencyList(){
	var len =document.prescription_detail_form.frequency.options.length;
	for(var i=0;i<len;i++) {
		document.prescription_detail_form.frequency.remove("frequency") ;
	}
	/*var tp = "       --- "+getLabel("ePH.Select.label","PH")+" ---      " ;
	var opt = document.createElement("OPTION") ;
	opt.text = tp ;
	opt.value = "" ;
	document.prescription_detail_form.frequency.add(opt);*/
}

function addFrequencyList(code,desc,default_val){
	var element = document.createElement('OPTION') ;
	element.value		=  code ;
	element.text		= decodeURIComponent(desc,"UTF-8") ;
	if(default_val!='' ){
		if(code==default_val ){
			element.selected	=	true;
		}
	}
	document.prescription_detail_form.frequency.add(element); //moved this outside if(default_val!='') condition for IN22307--24/06/2010 --priya
}

function dfltFreq(default_val, callFreqChange){
	document.prescription_detail_form.frequency.value=default_val;
	if(callFreqChange=='Y')
		freqChange(document.prescription_detail_form.frequency,'Y','dfltFreq' ); //dfltFreq added for MO-GN-5490 [IN:054620] - [IN:055921]
}

function alertFrequency(){
	alert(getMessage("PH_FREQ","PH"));
	return false;
}

function populateQtyDesc(form_code, pres_base_uom){
	var formobj=document.prescription_detail_form;
	var drug_code=formobj.form_code.value;
	//var pres_base_uom=formobj.pres_base_uom.value;
	//added for IN21601reopen --03/06/2010 -- priya
	var pres_base_uom_desc=formobj.pres_base_uom_desc.value;
	if(parent.f_header==null) 
		frameobj	=	parent.parent.f_header;		
	else 
		frameobj	=	parent.f_header;		
	var rx_qty_by_pres_base_uom_yn	=	frameobj.document.prescription_header_form.rx_qty_by_pres_base_uom_yn.value;

	var fldString =" form_code=\""+ form_code + "\" ";
	fldString +=" pres_base_uom=\""+ pres_base_uom + "\" ";
	fldString +=" pres_base_uom_desc=\""+pres_base_uom_desc + "\" "; //encodeURIComponent( pres_base_uom_desc,"UTF-8")
	fldString +=" rx_qty_by_pres_base_uom_yn=\""+ rx_qty_by_pres_base_uom_yn + "\" ";
	var xmlStr=formXMLString(formobj,fldString);
	return fieldValidation(xmlStr,"populateQtyDesc");

}

function populateQtyDesc2(){
	var formobj=document.prescription_detail_form;
	var form_code=formobj.form_code.value;
	var pres_base_uom=formobj.pres_base_uom.value;
	var pres_base_uom_desc=formobj.pres_base_uom_desc.value;
	
	var drug_code=formobj.drug_code.value;
	if(parent.f_header==null) 
		frameobj	=	parent.parent.f_header;		
	else 
		frameobj	=	parent.f_header;		
	var rx_qty_by_pres_base_uom_yn	=	frameobj.document.prescription_header_form.rx_qty_by_pres_base_uom_yn.value;
	var fldString =" form_code=\""+ form_code + "\" ";
	fldString +=" drug_code=\""+ drug_code + "\" ";
	fldString +=" pres_base_uom=\""+ pres_base_uom + "\" ";
	fldString +=" pres_base_uom_desc=\""+pres_base_uom_desc + "\" "; //encodeURIComponent( pres_base_uom_desc,"UTF-8")
	fldString +=" rx_qty_by_pres_base_uom_yn=\""+ rx_qty_by_pres_base_uom_yn + "\" ";
	var xmlStr=formXMLString(formobj,fldString);
	return fieldValidation(xmlStr,"populateQtyDesc");

}

function setdfltQtyUom(code){
	if(document.prescription_detail_form.dosage_type.value=='Q'){
		if(document.prescription_detail_form.dflt_qty_uom.value==""){
			document.prescription_detail_form.dflt_qty_uom.value=code;
		}
	}
	else{
		if(document.prescription_detail_form.qty_desc.value==""){
			document.prescription_detail_form.qty_desc.value=code;
		}
		if(document.prescription_detail_form.dflt_qty_uom.value==""){
			document.prescription_detail_form.dflt_qty_uom.value=code;
		}
		else if(document.prescription_detail_form.dosage_type.value=='A'){
			document.prescription_detail_form.dflt_qty_uom.value=document.prescription_detail_form.qty_desc_code.value;
		}
	}
}

function addQtyDescList(code,desc){
	var element = document.createElement('OPTION') ;
	element.value		=  code ;
	element.text		= desc ;
	document.prescription_detail_form.qty_desc.add(element);
}

function dfltStrnQtyDescList(){
	clearQtyDescList();
	var opt1 = document.createElement("OPTION") ;
	opt1.text = document.prescription_detail_form.strength_uom_desc.value ;
	opt1.value = document.prescription_detail_form.strength_uom.value;
	if(opt1.value != undefined && opt1.value != ''){
		document.prescription_detail_form.qty_desc.add(opt1);
		document.prescription_detail_form.qty_desc.value=document.prescription_detail_form.strength_uom.value;
	}
}

function clearQtyDescList(){
	var len =document.prescription_detail_form.qty_desc.options.length;
	for(var i=0;i<len;i++) {
		document.prescription_detail_form.qty_desc.remove("qty_desc") ;
	}
	/*var tp = "       --- "+getLabel("ePH.Select.label","PH")+" ---      " ;
	var opt = document.createElement("OPTION") ;
	opt.text = tp ;
	opt.value = "" ;
	document.prescription_detail_form.qty_desc.add(opt);*/
}

function dfltQtyDesc(){
	var dosage_type	=	document.prescription_detail_form.dosage.value;
	if(dosage_type=="S"){
		document.prescription_detail_form.qty_desc.value	=	document.prescription_detail_form.strength_uom.value;
		document.prescription_detail_form.qty_desc.disabled	=	false;
	}
	else if(dosage_type=="Q"){	
		/*document.prescription_detail_form.qty_desc.value	=	document.prescription_detail_form.dflt_qty_uom.value;  
		document.prescription_detail_form.qty_desc_code.value	=	document.prescription_detail_form.qty_desc.value;*///Commented for ML-BRU-SCF-1190 [IN:045647]
		document.prescription_detail_form.qty_desc.value	=	document.prescription_detail_form.qty_desc_code.value; //Added for ML-BRU-SCF-1190 [IN:045647] 
		if(parent.f_header==null) {
		frameobj	=	parent.parent.f_header;
		} 
		else {
			frameobj	=	parent.f_header;
		}
		var rx_qty_by_pres_base_uom_yn	=	frameobj.document.prescription_header_form.rx_qty_by_pres_base_uom_yn.value;
		
		if(rx_qty_by_pres_base_uom_yn=="Y")
			document.prescription_detail_form.qty_desc.disabled	=	true;
		else
			document.prescription_detail_form.qty_desc.disabled	=	false;
	}
	else if(dosage_type=="A"){		
		//document.prescription_detail_form.qty_desc.value		=	document.prescription_detail_form.pres_base_uom.value;
		//if(document.prescription_detail_form.qty_desc.value =="")
		document.prescription_detail_form.qty_desc.value		=	document.prescription_detail_form.dflt_qty_uom.value;
		//document.prescription_detail_form.qty_desc.disabled		=	true;
		if(parent.f_header==null) { //added for IN21338 ====13-05-2010 ===priya -start
			frameobj	=	parent.parent.f_header;
		} 
		else {
			frameobj	=	parent.f_header;
		}
		var rx_qty_by_pres_base_uom_yn	=	frameobj.document.prescription_header_form.rx_qty_by_pres_base_uom_yn.value;
		if(rx_qty_by_pres_base_uom_yn=="Y")
			document.prescription_detail_form.qty_desc.disabled	=	true;
		else
			document.prescription_detail_form.qty_desc.disabled	=	false; //added for IN21338 ====13-05-2010 ===priya -end
	}
}
function makeDefaultQtyvalueEmpty(stat_yn)// Added function to set the default qty empty while loading drug  aakh-crf-089   ==Chithra   // stat_yn is added for AAKH-CRF-0091
{
		if(document.prescription_detail_form.default_dosage_by_yn.value=="N" && stat_yn!="Y"){   // stat_yn is added for AAKH-CRF-0091
			document.prescription_detail_form.qty_value.value="";
			//document.prescription_detail_form.qty_value.value.focus();
		}
}//end AAKH-CRF-089
function validateQtyDesc(mode,status){
	document.prescription_detail_form.dosage_type.value=mode;

	if(document.prescription_detail_form.split_dose.disabled==false){
		DisableSchedule();
	}
	if(mode=="S"){
		document.getElementById('dosage_label').innerText=getLabel("Common.Strength.label",'Common');	
		document.prescription_detail_form.qty_desc.disabled	=	false;
		if(status!="R") {
			var strength=parseFloat(document.prescription_detail_form.strength_value.value==null?"1":document.prescription_detail_form.strength_value.value);
			var catalog_qty=parseFloat(document.prescription_detail_form.tab_qty_value.value==null?"1":document.prescription_detail_form.tab_qty_value.value);
			var strength_per_value_pres_uom=parseFloat(document.prescription_detail_form.strength_per_value_pres_uom.value==null?"1":document.prescription_detail_form.strength_per_value_pres_uom.value);
			document.prescription_detail_form.qty_desc.value=document.prescription_detail_form.strength_uom.value;
		//	document.prescription_detail_form.qty_value.value=document.prescription_detail_form.strength_value.value;
			if(strength_per_value_pres_uom == 0)
				strength_per_value_pres_uom = 1;
			//Math.round(___*100)/100 added for IN25705 --03/01/2011-- priya
			document.prescription_detail_form.qty_value.value=Math.round(((strength*catalog_qty)/strength_per_value_pres_uom)*100)/100;
		}
	}
	else if(mode=="Q"){
		document.getElementById('dosage_label').innerText=getLabel("ePH.Dose.label",'PH');	
		if(parent.f_header==null) {
		frameobj	=	parent.parent.f_header;
		} 
		else {
			frameobj	=	parent.f_header;
		}
		var rx_qty_by_pres_base_uom_yn	=	frameobj.document.prescription_header_form.rx_qty_by_pres_base_uom_yn.value;		
		if(rx_qty_by_pres_base_uom_yn=="Y")
			document.prescription_detail_form.qty_desc.disabled	=	true;
		else
			document.prescription_detail_form.qty_desc.disabled=false;
		
		if(status!="R") {
			document.prescription_detail_form.qty_value.value=parseFloat(document.prescription_detail_form.tab_qty_value.value);
			document.prescription_detail_form.qty_desc.value=document.prescription_detail_form.dflt_qty_uom.value;
		}
	} 
	else if(mode=="A" ) {
	//else if(mode=="A" && document.prescription_detail_form.patient_class.value=="IP" && document.prescription_detail_form.freq_nature.value=="P") {
		document.getElementById('dosage_label').innerText=getLabel("Common.Quantity.label",'Common');	
	}
	if(document.prescription_detail_form.sliding_scale_yn.value == 'Y') {
		document.getElementById('dosage_label').innerText="";
	}
	if(document.prescription_detail_form.qty_desc.value== ''){
		if(document.prescription_detail_form.qty_desc.options.length > 0){
			document.prescription_detail_form.qty_desc.selectedIndex=0;
		}
	}
}

function populateDurnDesc(repeat_durn_type){
	var formobj=document.prescription_detail_form;
	var fldString=" repeat_durn_type=\""+ repeat_durn_type + "\" ";
	var xmlStr=formXMLString(formobj,fldString);
	return fieldValidation(xmlStr,"populateDurnDesc");
}

function addDurnDescList(code,desc)	{
	var element = document.createElement('OPTION') ;
	element.value		=  code ;
	element.text		= desc ;
	document.prescription_detail_form.durn_desc.add(element);
}

function removeDurnDescList()	{
	var len = document.prescription_detail_form.durn_desc.length;
	for (var i=0; i<=len; i++) {
		document.prescription_detail_form.durn_desc.remove("");
	}
}

function dfltDurnDesc(repeat_durn_type){
	var freq_nature = document.prescription_detail_form.freq_nature.value;
	if(repeat_durn_type=="L"){
		document.prescription_detail_form.durn_desc.value="L";
		//document.prescription_detail_form.durn_desc.disabled=true; //Commented for [IN:044129]
	}
	if(repeat_durn_type=="W"){
		document.prescription_detail_form.durn_desc.value="W";
		//document.prescription_detail_form.durn_desc.disabled=true; //Commented for [IN:044129]
	}
	if(repeat_durn_type=="D"){
		document.prescription_detail_form.durn_desc.value="D";
		//document.prescription_detail_form.durn_desc.disabled=true;//Commented for [IN:044129]
	}
	if(repeat_durn_type=="H"){
		document.prescription_detail_form.durn_desc.value="H";
//		document.prescription_detail_form.durn_value.value="1";
		//document.prescription_detail_form.durn_desc.disabled=true;//Commented for [IN:044129]
		document.prescription_detail_form.calcualted_durn_value.value="1"; 
	}
	if(repeat_durn_type=="M"){
		document.prescription_detail_form.durn_desc.value="M";
//		document.prescription_detail_form.durn_value.value="1";
		//document.prescription_detail_form.durn_desc.disabled=true;//Commented for [IN:044129]
	}
	if(repeat_durn_type=="Y"){
		document.prescription_detail_form.durn_desc.value="Y";
		//document.prescription_detail_form.durn_desc.disabled=true;//Commented for [IN:044129]
	}

	var interval_value = document.prescription_detail_form.interval_value.value; //added 

	if((freq_nature != "P" || freq_nature != 'O') && !(freq_nature=="F" && interval_value>1 ) && document.prescription_detail_form.taper_disable=="" ){ // added  && !(freq_nature=="F" && interval_value>1 )
		document.prescription_detail_form.durn_desc.disabled=false;
		document.prescription_detail_form.durn_value.focus; //added 
	}
	durationConversn(document.prescription_detail_form.durn_desc);//priya added for IN19200 23/02/2010
}

function populateDurationDesc(obj){

	var freq_code		=	obj.value;
	if(parent.f_header==null) {
		frameobj	=	parent.parent.f_header;
	} 
	else {
		frameobj	=	parent.f_header;
	}
	var patient_class	=	frameobj.document.prescription_header_form.patient_class.value;
	if(patient_class=="IP"){
		if(frameobj.document.prescription_header_form.take_home_medication.value=="Y")
			patient_class="OP";
	}
	var drug_code=document.prescription_detail_form.drug_code.value;
	var fldString=" freq_code=\""+ freq_code + "\" ";
	fldString+=" patient_class=\""+ patient_class + "\" ";
	fldString+=" drug_code=\""+ drug_code + "\" ";
	var formobj=document.prescription_detail_form;
	var xmlStr=formXMLString(formobj,fldString);
	return fieldValidation(xmlStr,"populateDurationDesc");
}

function assignDurnDesc(repeat_value,repeat_durn_type,freq_nature,interval_value,durn_desc,freq_value,schedule_yn){
	if(freq_value=="null" || freq_value==null) 
		freq_value=="0";
	var split_dose_yn	=	document.prescription_detail_form.split_dose_yn.value;
	document.prescription_detail_form.freq_nature.value=freq_nature;
	var allow_chk		=	"Y";

	if(freq_nature=="O" || freq_nature=="P") 
		allow_chk="N";
	if(repeat_durn_type=="null" || repeat_durn_type==null || repeat_durn_type=="")
		repeat_durn_type	=	"D";

	if(allow_chk=="Y" && schedule_yn=="Y"){
		/*if(document.prescription_detail_form.dosage.value=="A" && (document.prescription_detail_form.patient_class.value=="OP" || document.prescription_detail_form.patient_class.value=="EM")){
			document.prescription_detail_form.split_dose.disabled=true;
			document.prescription_detail_form.split_dose_yn_val.value='N';
		}
		else {*/ //Commented for MOHBRU issue Schedule button disabled for OP Absolute drugs- ML-BRU-SCF-1219 [IN:046464]
			if(document.prescription_detail_form.taper_disable.value==""){
				document.prescription_detail_form.split_dose.disabled=false;
				document.prescription_detail_form.sch_over_yn.value="Y";
			}
		//}
	}
	else {
		if(document.prescription_detail_form.sliding_scale_yn.value !='Y'){
			document.prescription_detail_form.split_dose.disabled=true;
			document.prescription_detail_form.split_dose_yn_val.value='N';
			document.prescription_detail_form.sch_over_yn.value="Y";
		}
	}
	
	if(document.prescription_detail_form.refill_yn!=undefined){
		if(document.prescription_detail_form.refill_cont_order_yn.value=="Y" && document.prescription_detail_form.calling_mode.value != "taper" && document.prescription_detail_form.calling_mode.value !="tapered" && document.prescription_detail_form.refill_yn.value=="Y" && document.prescription_detail_form.refill_yn_from_param.value=="Y"){
			 
			document.prescription_detail_form.allow_refill.disabled=false;
		}
		else{
			document.prescription_detail_form.allow_refill.disabled=true;
			if(document.prescription_detail_form.no_refill != undefined){
				document.prescription_detail_form.no_refill.value='';
				document.prescription_detail_form.refill_start_date.value='';
				document.prescription_detail_form.refill_end_date.value='';
			}
		}
	}
	document.prescription_detail_form.freq_value.value=freq_value;
	document.prescription_detail_form.durn_value.disabled=false;
	document.prescription_detail_form.end_date.disabled=false;
	document.prescription_detail_form.endDateImg.disabled=false;
	if(repeat_durn_type=="L"){
		document.prescription_detail_form.durn_desc.value="L";
		removeDurnDescList();
		populateDurnDesc(repeat_durn_type);
		//document.prescription_detail_form.durn_desc.disabled=true;
	}
	if(repeat_durn_type=="W"){
		document.prescription_detail_form.durn_desc.value="W";
		removeDurnDescList();
		populateDurnDesc(repeat_durn_type);
		//document.prescription_detail_form.durn_desc.disabled=true;
	}
	if(repeat_durn_type=="D"){
		document.prescription_detail_form.durn_desc.value="D";
		removeDurnDescList();
		populateDurnDesc(repeat_durn_type);
		//document.prescription_detail_form.durn_desc.disabled=true;
	}
	if(repeat_durn_type=="H"){
		document.prescription_detail_form.durn_desc.value="H"; //priya
		//document.prescription_detail_form.durn_value.value="1";      // commented for IN18922 == 19/02/2010 -- priya
		//document.prescription_detail_form.durn_value.disabled=true;
		//document.prescription_detail_form.durn_desc.disabled=true;
		document.prescription_detail_form.calcualted_durn_value.value="1";
		removeDurnDescList();
		populateDurnDesc(repeat_durn_type);
	}
	if(repeat_durn_type=="M"){
		document.prescription_detail_form.durn_desc.value="M"; //priya
		//document.prescription_detail_form.durn_value.value="1";  // commented for IN18922 == 19/02/2010 -- priya
		//document.prescription_detail_form.durn_value.disabled=true;
//		document.prescription_detail_form.durn_desc.disabled=true;
		document.prescription_detail_form.calcualted_durn_value.value="1";
		removeDurnDescList();
		populateDurnDesc(repeat_durn_type);
	}
	if(freq_nature=='O'){
		if(document.prescription_detail_form.in_durn_desc!=null) {
			document.prescription_detail_form.in_durn_desc.value="";
			document.prescription_detail_form.in_durn_value.value="";
			document.prescription_detail_form.allow_refill.disabled=true;
			document.prescription_detail_form.no_refill.value="";
			document.prescription_detail_form.refill_start_date.value="";
			document.prescription_detail_form.refill_end_date.value="";
		}
		document.prescription_detail_form.durn_desc.value="D";
		document.prescription_detail_form.durn_value.value="1";
		document.prescription_detail_form.durn_value.disabled=true;
//		document.prescription_detail_form.durn_desc.disabled=true;
		document.prescription_detail_form.end_date.disabled=true;
		document.prescription_detail_form.endDateImg.disabled=true;
		document.prescription_detail_form.calcualted_durn_value.value="1";
		interval_value="1";
		repeat_value="1";
	}
	else if(freq_nature=='P'){
		document.prescription_detail_form.durn_desc.value="D";
//		document.prescription_detail_form.durn_desc.disabled=true;
		document.prescription_detail_form.durn_value.disabled=false;
		document.prescription_detail_form.allow_refill.disabled=true;
		document.prescription_detail_form.end_date.disabled=false;
		document.prescription_detail_form.endDateImg.disabled=false;
		if(document.prescription_detail_form.no_refill!=null) {
			document.prescription_detail_form.no_refill.value="";
			document.prescription_detail_form.no_refill.disabled=true;
			document.prescription_detail_form.refill_start_date.value="";
			document.prescription_detail_form.refill_end_date.value="";
		}
		interval_value="1";
		repeat_value="1";
		//alert("prathyusha"+repeat_value);
	}

	document.prescription_detail_form.interval_value.value=interval_value;
	document.prescription_detail_form.repeat_value.value=repeat_value;
	document.prescription_detail_form.repeat_durn_type.value=repeat_durn_type;
	document.prescription_detail_form.calcualted_durn_value.value=repeat_value;
	document.prescription_detail_form.scheduled_yn.value=schedule_yn;
	populateEndDate();
	if(freq_nature == "F" && interval_value > 1){
		document.prescription_detail_form.durn_desc.disabled = true;
	}
	if(parent.f_header==null) {//Adding start for ARYU-SCF-0033
		var formObject	=	parent.parent.f_header.document.prescription_header_form;
	}
	else {
		var formObject	=	parent.f_header.document.prescription_header_form;
	}//Adding end for ARYU-SCF-0033
	if(formObject.alternateOrder!=undefined && formObject.alternateOrder.value=="Y"){//added for  JD-CRF-0198 [IN:058599] parent.f_header.document.prescription_header_form replaed with formObject for ARYU-SCF-0033  and modifed for TBMC-SCF-0166
		document.prescription_detail_form.allow_refill.disabled=true;
		document.prescription_detail_form.drug_search.disabled=true;
	}
		
}

function populateEndDate(callFrom){ //callFrom added for MO-GN-5490 [IN:054620] - [IN:055921]
	if(callFrom==undefined)// added for MO-GN-5490 [IN:054620] - [IN:055921]
		callFrom="";
	var frmObj_pres_dtl;
     //  parent.f_detail.f_sliding_scale_admin_dtls
	if(document.prescription_detail_form != undefined){
		frmObj_pres_dtl	= document.prescription_detail_form;
	}
	else if(parent.f_detail != undefined ){ //else if condition added for IN22255 --23/06/2010 --priya
        if(parent.f_detail.f_sliding_scale_admin_dtls!=null && parent.f_detail.f_sliding_scale_admin_dtls!=undefined){
			 frmObj_pres_dtl = parent.f_detail.f_sliding_scale_admin_dtls.prescription_detail_form;
		}
		else{
		    frmObj_pres_dtl = parent.f_detail.document.prescription_detail_form;
		}
	}
	else if (parent.parent.f_detail!=undefined){
		frmObj_pres_dtl = parent.parent.f_detail.document.prescription_detail_form;
	}
	else{
        frmObj_pres_dtl = parent.f_detail.f_sliding_scale_admin_dtls.prescription_detail_form;
	}

	var freq_nature		=	frmObj_pres_dtl.freq_nature.value;
	var start_date		=	frmObj_pres_dtl.start_date.value;
	var durn_value		=	frmObj_pres_dtl.durn_value.value;
	var durn_desc		=	frmObj_pres_dtl.durn_desc.value;
	var repeat_durn_type=	frmObj_pres_dtl.repeat_durn_type.value;
	var drug_code		=	frmObj_pres_dtl.drug_code.value;
	var srlNo			=	frmObj_pres_dtl.srl_no.value;
	var def_freq_found	=	frmObj_pres_dtl.def_freq_found.value;
	var absol_qty = "";
	if(frmObj_pres_dtl.absol_qty!=undefined){
		absol_qty = frmObj_pres_dtl.absol_qty.value; //added for IN26267 --02/02/2011-- priya
	}

	repeat_durn_type	=	durn_desc;
	/*if( repeat_durn_type=="H" || repeat_durn_type=="M" ){
		repeat_durn_type="D";
		durn_value="1";
	}*/
	//frmObj_pres_dtl.repeat_durn_type.value=repeat_durn_type; //// added for IN21609 --07/06/2010 -- priya
	if(durn_value!=''){
		var fldString="  start_date=\""+ start_date + "\" ";
		fldString += " durn_value=\""+ durn_value + "\" ";
		fldString += " repeat_durn_type=\""+ repeat_durn_type + "\" "; 
		fldString += " freq_nature=\""+ freq_nature + "\" ";
		fldString += " drug_code=\""+ drug_code + "\" ";
		fldString += " srlNo=\""+ srlNo + "\" ";
		fldString += " def_freq_found=\""+ def_freq_found + "\" ";
		fldString += " absol_qty=\""+ absol_qty + "\" ";
		fldString += " callFrom=\""+ callFrom + "\" ";// added for MO-GN-5490 [IN:054620] - [IN:055921]
//		var formobj=document.prescription_detail_form;
		var xmlStr=formXMLString(frmObj_pres_dtl,fldString);
		return fieldValidation(xmlStr,"populateEndDate");
	}
}

function assignEndDate(end_date, callFrom){// callFrom added for MO-GN-5490 [IN:054620] - [IN:055921]
	var frmObj_pres_dtl= "";
	if(callFrom == undefined || callFrom=='') // added for MO-GN-5490 [IN:054620] - [IN:055921]
		callFrom = "CHANGEDATE";

	if(document.prescription_detail_form != undefined){
		frmObj_pres_dtl	= document.prescription_detail_form;
	}
	else if(parent.f_detail != undefined ){  //else if condition added for IN22255 --23/06/2010 --priya
		if(parent.f_detail.f_sliding_scale_admin_dtls!=null && parent.f_detail.f_sliding_scale_admin_dtls!=undefined){
			 frmObj_pres_dtl = parent.f_detail.f_sliding_scale_admin_dtls.prescription_detail_form;
		}
		else{
		    frmObj_pres_dtl = parent.f_detail.document.prescription_detail_form;
		}
	}
	else if (parent.parent.f_detail!=undefined){
		frmObj_pres_dtl = parent.parent.f_detail.document.prescription_detail_form;
	}
	else{
        frmObj_pres_dtl = parent.f_detail.f_sliding_scale_admin_dtls.prescription_detail_form;
	}

	/*if(document.prescription_detail_form != undefined){
		frmObj_pres_dtl		= document.prescription_detail_form;
	}else if(parent.f_detail != undefined ){
		frmObj_pres_dtl = parent.f_detail.document.prescription_detail_form;
	}else{
		frmObj_pres_dtl = parent.parent.f_detail.document.prescription_detail_form;
	}*/
	var tempEnd_date = frmObj_pres_dtl.end_date.value; // added for MO-GN-5490 [IN:054620] - [IN:055921]
	frmObj_pres_dtl.end_date.value=end_date;
	//Added for IN:072715  start
	var frequency=frmObj_pres_dtl.frequency.value;
	if(frequency=='STAT'){
		checkDuplicateDrug(frmObj_pres_dtl, frequency, 'ChangeFreq'); //Modified for SKR-SCF-1457
	}
	//Added for IN:072715  end
	if( tempEnd_date != end_date){
		checkDuplicateDrug(frmObj_pres_dtl, '', callFrom); //CHANGEDATE changed to callFrom for MO-GN-5490 [IN:054620] - [IN:055921]
	}
	frmObj_pres_dtl.def_freq_found.value=true;
}

function validateDuration(obj,frm,sliding_scale_yn){
	var drnValue = obj.value;
	if(isNaN(drnValue)){
		alert(getMessage("ONLY_NUMBER_ALLOWED","PH"));
		obj.value="1";
		obj.focus();
	}
	var durn_value	=	parseInt(Math.abs(obj.value));
	var frmObj_pres_dtl			= "";
	obj.value = durn_value;
	var order_set_code			= "";
	if(sliding_scale_yn == "Y" ){ // condition added for IN21609 --07/06/2010 -- priya
		if(frm=="confirm") { //condition added for IN22255 -- 23/06/2010 -- priya
			parent.f_detail.f_sliding_scale_admin_dtls.document.prescription_detail_form.durn_unit.value =  parent.f_detail.f_sliding_scale_admin_dtls.document.prescription_detail_form.durn_desc.value;
		}
		else{
			document.prescription_detail_form.durn_unit.value = document.prescription_detail_form.durn_desc.value;
		}
	} 
	if(parseInt(obj.value)==0 || obj.value=="") {
		obj.value="1";
		obj.focus();
	}
	if(!CheckPositiveNumber1(obj))
		return false;

	if(validateMaxRefillDuration('durn',frm,sliding_scale_yn)){ //here
		if(frm == "confirm"){
			if(sliding_scale_yn == 'Y') //condition added for IN22255 -- 23/06/2010 -- priya
				frmObj_pres_dtl		= parent.f_detail.f_sliding_scale_admin_dtls.document.prescription_detail_form;
			else
				frmObj_pres_dtl			= parent.f_detail.document.prescription_detail_form;
			hdr_form = parent.f_header.document.prescription_header_form;
		}
		else if(frm == "release" || sliding_scale_yn == 'Y'){
			if(sliding_scale_yn == 'Y'){
				frmObj_pres_dtl		= parent.parent.f_detail.f_sliding_scale_admin_dtls.document.prescription_detail_form;
			}
			else{
				frmObj_pres_dtl		= parent.parent.f_detail.document.prescription_detail_form;	
			}
			hdr_form = parent.parent.f_header.document.prescription_header_form;
		}
		else{
			frmObj_pres_dtl		= document.prescription_detail_form;
			hdr_form = parent.f_header.document.prescription_header_form;
		}
		
		if(frmObj_pres_dtl.order_set_code != undefined && frmObj_pres_dtl.order_set_code !=null)// added by chandrashekar fo incident no SCF No. SRR20056-SCF-7537, 

			order_set_code = frmObj_pres_dtl.order_set_code.value;// SCF No. SRR20056-SCF-7537, 

		var freq_value=frmObj_pres_dtl.freq_value.value;
		var calculated_value="";
		var interval_value=frmObj_pres_dtl.interval_value.value;
		var durn_desc = frmObj_pres_dtl.durn_desc.value;
		var repeat_durn_type = frmObj_pres_dtl.repeat_durn_type.value;
		var freq_nature = frmObj_pres_dtl.freq_nature.value;
	//	var repeat_value = frmObj_pres_dtl.repeat_value.value;
		if(freq_nature=="F" && interval_value >1){
			if((durn_value % interval_value) > 0){
				var rem = durn_value % interval_value;
				var prev_day = durn_value - rem;
				//var nxt_day = durn_value + rem;
				var nxt_day = parseInt(durn_value) - parseInt(rem) + parseInt(interval_value);
				var err_msg = getMessage("DURATION_VALUE_MULTIPLE","PH");
				if(prev_day == 0){
					err_msg = err_msg.replace('$ or ',"");
				}
				else
					err_msg = err_msg.replace('$', prev_day);
				err_msg = err_msg.replace('#', nxt_day);
				err_msg = err_msg.replace('%', interval_value);
				alert(err_msg); 
				//frmObj_pres_dtl.durn_value.focus();
			}
		}
		if(freq_value=="0"){
			var calc=parseFloat(obj.value/interval_value);
			calculated_value=Math.ceil(calc);
		}
		else{
			calculated_value=freq_value;
		}

		frmObj_pres_dtl.calcualted_durn_value.value=calculated_value;

		var durn_value=obj.value;
		var source=frmObj_pres_dtl.source.value;
		if(durn_value!=""){
			var drug_code=frmObj_pres_dtl.drug_code.value;
			var patient_class=hdr_form.actual_patient_class.value; //patient_class passed directly ML-MMOH-SCF-0492 ---chithra
			var srlNo=frmObj_pres_dtl.srl_no.value;
			var freq_chng_durn_desc = frmObj_pres_dtl.durn_desc.value;
			var freq_chng_durn_value= frmObj_pres_dtl.durn_value.value;
			var repeat_durn_type = frmObj_pres_dtl.repeat_durn_type.value;// added for IN21609 --07/06/2010 -- priya
			if(patient_class=="IP" || patient_class=="DC"){  // || patient_class=="DC" added for ML-MMOH-SCF-0362.1
				if(hdr_form.take_home_medication.value=="Y")
					patient_class="OP";
			}
			var fldString=" durn_value=\""+ durn_value + "\" ";
			fldString += " drug_code=\""+ drug_code + "\" ";
			fldString += " patient_class=\""+ patient_class + "\" ";
			fldString += " source=\""+ source + "\" ";
			fldString += " srlNo=\""+ srlNo + "\" ";
			fldString += " frm=\""+ frm + "\" ";
			fldString += " freq_chng_durn_desc=\""+ freq_chng_durn_desc + "\" ";
			fldString += " freq_chng_durn_value=\""+ freq_chng_durn_value + "\" ";
			fldString += " sliding_scale_yn=\""+ sliding_scale_yn + "\" ";
			fldString += " repeat_durn_type=\""+ repeat_durn_type + "\" "; // added for IN21609 --07/06/2010 -- priya
			fldString += " interval_value=\""+ interval_value + "\" "; //added for IN24131 -- 14/10/2010-- priya
			fldString += " order_set_code=\""+order_set_code + "\" "; 
			var xmlStr=formXMLString(frmObj_pres_dtl,fldString);
			//return fieldValidation(xmlStr,"validateDuration");
			var xmlDoc = "" ;
			var xmlHttp = new XMLHttpRequest() ;
			xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
			xmlHttp.open("POST","PrescriptionValidation_1.jsp?func_mode=validateDuration",false);
			xmlHttp.send(xmlDoc);
			responseText=xmlHttp.responseText ;
			return (eval(responseText));
		}
	}
	else{
		return false;
	}
	return true; //Added for ML-BRU-SCF-0820 [IN:039500]
}

function validateAllDates(){
	var durn_value=document.prescription_detail_form.durn_value.value;
	var source=document.prescription_detail_form.source.value;
	var freq_chng_durn_desc = document.prescription_detail_form.durn_desc.value;
	var interval_value = document.prescription_detail_form.interval_value.value; //added for IN25752 reopen --13/01/2011 -- priya
	var freq_chng_durn_value= document.prescription_detail_form.durn_value.value;
	var repeat_durn_type = document.prescription_detail_form.repeat_durn_type.value; //added for IN21609 --07/06/2010 -- priya

	if(durn_value!=""){
		var drug_code=document.prescription_detail_form.drug_code.value;
		var patient_class=parent.f_header.document.prescription_header_form.patient_class.value;

		var srlNo=document.prescription_detail_form.srl_no.value;
		if(patient_class=="IP"){
			if(parent.f_header.document.prescription_header_form.take_home_medication.value=="Y")
				patient_class="OP";
		}
		var fldString=" durn_value=\""+ durn_value + "\" ";
		fldString += " drug_code=\""+ drug_code + "\" ";
		fldString += " patient_class=\""+ patient_class + "\" ";
		fldString += " source=\""+ source + "\" ";
		fldString += " srlNo=\""+ srlNo + "\" ";
		fldString += " freq_chng_durn_desc=\""+ freq_chng_durn_desc + "\" ";
		fldString += " freq_chng_durn_value=\""+ freq_chng_durn_value + "\" ";
		fldString += " repeat_durn_type=\""+ repeat_durn_type + "\" "; //added for IN21609 --07/06/2010 -- priya
		fldString += " interval_value=\""+ interval_value + "\" ";   //added for IN25752 reopen --13/01/2011 -- priya
		var formobj=document.prescription_detail_form;
		var xmlStr=formXMLString(formobj,fldString);
		return fieldValidation(xmlStr,"validateDuration");
	}
}

function assignDurnvalue(total_durn_value,max_durn_value,chk_for_max_durn_action,prompt_msg,max_durn_type,sliding_scale_yn){
	
	var frmObj_pres_dtl		= "";
	var hdr_form			= "";
	var dtl_all				= "";
	var drg_max_durn_value	= "";
	var max_durn_desc	= "";
	if(max_durn_type == "")
		max_durn_type = "D";
	
	if(document.prescription_detail_form != undefined){
		frmObj_pres_dtl		= document.prescription_detail_form;
		dtl_all = document.all;
	}
	else if(parent.f_detail != undefined){
		if(sliding_scale_yn =='Y'){ //condition added for IN22255 -- 23/06/2010 -- priya
			frmObj_pres_dtl = parent.f_detail.f_sliding_scale_admin_dtls.document.prescription_detail_form;
			dtl_all =  parent.f_detail.f_sliding_scale_admin_dtls.document.all;
		}
		else{
			frmObj_pres_dtl = parent.f_detail.document.prescription_detail_form;
			dtl_all = parent.f_detail.document.all;
		}
	}
	else{
		frmObj_pres_dtl = parent.parent.f_detail.document.prescription_detail_form;
		dtl_all = parent.parent.f_detail.document.all;
	}

	if(parent.f_header != undefined){
		hdr_form = parent.f_header.document.prescription_header_form
	}
		else{
		hdr_form = parent.parent.f_header.document.prescription_header_form
	}

	var durn_value	=	parseInt(Math.abs(frmObj_pres_dtl.durn_value.value));
	frmObj_pres_dtl.durn_value.value = durn_value;
	var durn_desc			= frmObj_pres_dtl.durn_desc.value;
	var repeat_durn_type    = frmObj_pres_dtl.repeat_durn_type.value;
	var temp1	   = "";
	// code added by rawther for scf  7732
	if(parseInt(Math.abs(max_durn_value))==0 || max_durn_value==''){ // added for SCF-6797.1
	//if( (max_durn_value=='' || parseInt(Math.abs(max_durn_value))==0 )  && hdr_form.take_home_medication.checked ){
	//if(hdr_form.take_home_medication.checked){
		var pat_class	=	hdr_form.patient_class.value;
		if(hdr_form.take_home_medication.checked){  // added for SCF-6797.1
			max_durn_value = hdr_form.max_durn_for_dm_pres.value;
			chk_for_max_durn_action = hdr_form.chk_for_dm_max_durn_action.value;
			frmObj_pres_dtl.max_durn_value.value=max_durn_value;
			frmObj_pres_dtl.chk_for_max_durn_action.value=chk_for_max_durn_action;
		}
	//}
	//else{		//commented for SCF-6797.1
		//if(parseInt(Math.abs(max_durn_value))==0 || max_durn_value==''){ //commented for skr-scf-0142 -IN 29183
			
			else  if(pat_class=='IP'){
				max_durn_value = hdr_form.max_durn_for_ip_pres.value;
				chk_for_max_durn_action = hdr_form.chk_for_ip_max_durn_action.value;
			}
			else{
				max_durn_value = hdr_form.max_durn_for_op_pres.value;
				chk_for_max_durn_action = hdr_form.chk_for_op_max_durn_action.value;
			}
			frmObj_pres_dtl.max_durn_value.value=max_durn_value;
			frmObj_pres_dtl.chk_for_max_durn_action.value=chk_for_max_durn_action;
		//}
	}
	if(repeat_durn_type != durn_desc){
		if(repeat_durn_type == 'M'){
			if(durn_desc == 'H'){
				durn_value = parseInt(durn_value) * 60;	
			}
			else if(durn_desc == 'D'){
				durn_value = parseInt(durn_value) * (24 * 60);	
			}
			else if(durn_desc == 'W'){
				durn_value = parseInt(durn_value) * (7 * 24 * 60);	
			}
			else if(durn_desc == 'L'){
				durn_value = parseInt(durn_value) * (30 * 24 * 60);	
			}
			else if(durn_desc == 'Y'){
				durn_value = parseInt(durn_value) * (365 * 24 * 60);	
			}
	   } 
	   else if(repeat_durn_type == 'H'){
			if(durn_desc == 'M'){
				durn_value = Math.ceil(parseInt(durn_value)/60) ;	
			}
			else if(durn_desc == 'D'){
				durn_value = parseInt(durn_value) * 24;	
			}
			else if(durn_desc == 'W'){
				durn_value = parseInt(durn_value) * 7 * 24;	
			}
			else if(durn_desc == 'L'){
				durn_value = parseInt(durn_value) * 30 * 24;	
			}
			else if(durn_desc == 'Y'){
				durn_value = parseInt(durn_value) * 365 * 24;	
			}
	   }
	   else if(repeat_durn_type == 'D'){
			if(durn_desc == 'M'){
				durn_value = Math.ceil(parseInt(durn_value)/(24*60));	
			}
			else if(durn_desc == 'H'){
				durn_value = Math.ceil(parseInt(durn_value)/24);	
			}
			else if(durn_desc == 'W'){
				durn_value = parseInt(durn_value) * 7 ;	
			}
			else if(durn_desc == 'L'){
				durn_value = parseInt(durn_value) * 30 ;	
			}
			else if(durn_desc == 'Y'){
				durn_value = parseInt(durn_value) * 365 ;	
			}
	   }
	   else if(repeat_durn_type == 'W'){
			if(durn_desc == 'M'){
				durn_value = Math.ceil(parseInt(durn_value)/(7*24*60));
			}
			else if(durn_desc == 'H'){
				durn_value = Math.ceil(parseInt(durn_value)/(7*24));	
			}
			else if(durn_desc == 'D'){
				durn_value = Math.ceil(parseInt(durn_value)/7);	
			}
			else if(durn_desc == 'L'){
				durn_value = parseInt(durn_value) * 4;	
			}
			else if(durn_desc == 'Y'){
				durn_value = parseInt(durn_value) * 52;	
			}
	   }
	   else if(repeat_durn_type == 'L'){
			if(durn_desc == 'M'){
				durn_value = Math.ceil(parseInt(durn_value)/(30*24*60));
			}
			else if(durn_desc == 'H'){
				durn_value = Math.ceil(parseInt(durn_value)/(30*24));	
			}
			else if(durn_desc == 'D'){
				durn_value = Math.ceil(parseInt(durn_value)/30);	
			}
			else if(durn_desc == 'W'){
				durn_value = parseInt(durn_value) / 4;	
			}
			else if(durn_desc == 'Y'){
				durn_value = parseInt(durn_value) * 12;	
			}
	   }
	   else if(repeat_durn_type == 'Y'){
			if(durn_desc == 'M'){
				durn_value = Math.ceil(parseInt(durn_value)/(365*24*60));
			}
			else if(durn_desc == 'H'){
				durn_value = Math.ceil(parseInt(durn_value)/(365*24));	
			}
			else if(durn_desc == 'D'){
				durn_value = Math.ceil(parseInt(durn_value)/365);	
			}
			else if(durn_desc == 'W'){
				durn_value = parseInt(durn_value) / 52;	
			}
			else if(durn_desc == 'L'){
				durn_value = parseInt(durn_value) / 12;	
			}
		}
	} 

	drg_max_durn_value	= max_durn_value;
	if(max_durn_type != repeat_durn_type){
	   if(max_durn_type == 'M'){
			if(repeat_durn_type == 'H'){
				temp1	   = parseInt(max_durn_value)/60;
			}
			else if(repeat_durn_type == 'D'){
				temp1	   = parseInt(max_durn_value)/(24*60);
			}
			else if(repeat_durn_type == 'W'){
				temp1	   = parseInt(max_durn_value)/(7*24*60);
			}
			else if(repeat_durn_type == 'L'){
				temp1	   = parseInt(max_durn_value)/(30*24*60);
			}
			else if(repeat_durn_type == 'Y'){
				temp1	   = parseInt(max_durn_value)/(365*24*60);
			}
			else
				temp1 = max_durn_value;
	   } 
	   else if(max_durn_type == 'H'){
			if(repeat_durn_type == 'M'){
	  			temp1 = parseInt(max_durn_value) * 60;	
			}
			else if(repeat_durn_type == 'D'){
				temp1	   = parseInt(max_durn_value)/24;
			}
			else if(repeat_durn_type == 'W'){
				temp1	   = parseInt(max_durn_value)/(7*24);
			}
			else if(repeat_durn_type == 'L'){
				temp1	   = parseInt(max_durn_value)/(30*24);
			}
			else if(repeat_durn_type == 'Y'){
				temp1	   = parseInt(max_durn_value)/(365*24);
			}
			else
				temp1 = max_durn_value;
	   }
	   else if(max_durn_type == 'W'){
			if(repeat_durn_type == 'M'){
				temp1 = parseInt(max_durn_value) * 7 * 24 * 60;	
			}
			else if(repeat_durn_type == 'H'){
				temp1 = parseInt(max_durn_value) * 7 * 24;	
			}
			else if(repeat_durn_type == 'D'){
				temp1 = parseInt(max_durn_value) * 7;	
			}
			else if(repeat_durn_type == 'L'){
				temp1	   = parseInt(max_durn_value)/4;
			}
			else if(repeat_durn_type == 'Y'){
				temp1	   = parseInt(max_durn_value)/52;
			}
			else
				temp1 = max_durn_value;
	   } 
	   else if(max_durn_type == 'L'){
			if(repeat_durn_type == 'M'){
				temp1 = parseInt(max_durn_value) * 30 * 24 * 60;	
			}
			else if(repeat_durn_type == 'H'){
				temp1 = parseInt(max_durn_value) * 30 * 24;	
			}
			else if(repeat_durn_type == 'D'){
				temp1 = parseInt(max_durn_value) * 30;	
			}
			else if(repeat_durn_type == 'W'){
					temp1	   = parseInt(max_durn_value) * 4;
			}
			else if(repeat_durn_type == 'Y'){
					temp1	   = parseInt(max_durn_value)/12;
			}
			else
				temp1 = max_durn_value;
   
	   }
	   else if(max_durn_type == 'Y'){
			if(repeat_durn_type == 'M'){
				temp1 = parseInt(max_durn_value) * 365 * 24 * 60;	
			}
			else if(repeat_durn_type == 'H'){
				temp1 = parseInt(max_durn_value) * 365 * 24;	
			}
			else if(repeat_durn_type == 'D'){
				temp1 = parseInt(max_durn_value) * 365;	
			}
			else if(repeat_durn_type == 'W'){
				temp1	   = parseInt(max_durn_value) * 52;
			}
			else if(repeat_durn_type == 'L'){
				temp1	   = parseInt(max_durn_value) * 12;
			}
			else
				temp1 = max_durn_value;
   	   } 
	   else {//if(max_durn_type == 'D'){
			if(repeat_durn_type == 'M'){
				temp1 = parseInt(max_durn_value) * 24 * 60;	
			}
			else if(repeat_durn_type == 'H'){
				temp1 = parseInt(max_durn_value) * 24;	
			}
			else if(repeat_durn_type == 'W'){
				temp1	   = parseInt(max_durn_value)/7;	
			}
			else if(repeat_durn_type == 'L'){
				temp1	   = parseInt(max_durn_value)/30;
			}
			else if(repeat_durn_type == 'Y'){
				temp1	   = parseInt(max_durn_value)/365;
			}
			else
				temp1 = max_durn_value;
	   }
		drg_max_durn_value	= max_durn_value;
		max_durn_value		= temp1 ;
	}

	var durnTypeList = "";
	if(durn_type_list.length>0){
		durnTypeList = durn_type_list.split(",");
	}
	var durn_type_value = "";
	var durn_type_code  = "";
	if(max_durn_type == 'M') //Added for ML-BRU-SCF-0820 [IN:039500] -start
		max_durn_desc = getLabel("Common.Minute(s).label","Common"); 
	else if(max_durn_type == 'H')
		max_durn_desc = getLabel("Common.Hour(s).label","Common"); 
	else if(max_durn_type == 'W')
		max_durn_desc = getLabel("ePH.WEEKS.label","PH");
	else if(max_durn_type == 'L')
		max_durn_desc = getLabel("ePH.MONTHS.label","PH");
	else if(max_durn_type == 'Y')
		max_durn_desc = getLabel("ePH.years.label","PH");
	 else
	   max_durn_desc = getLabel("Common.Day(s).label","Common");  //Added for ML-BRU-SCF-0820 [IN:039500] -ens

	/*for(i=0;i<durnTypeList.length;i++){  //Commented for ML-BRU-SCF-0820 [IN:039500] -Labels added above.
		durn_type_value = durnTypeList[i].split("=");
		durn_type_code = trimString(durn_type_value[0]);
		if(durn_type_code == max_durn_type){
			max_durn_desc	= trimString(durn_type_value[1]);
		}
	}*/
	
	var disp_durn = "";
	disp_durn = " - "+drg_max_durn_value+" "+max_durn_desc;
	var ord_auth_reqd_yn = "N";
	if(frmObj_pres_dtl.force_auth_yn != undefined && frmObj_pres_dtl.force_auth_yn.value != "Y"){
		if(durn_value>parseInt(max_durn_value)){
			if(chk_for_max_durn_action=="R"){
				alert(getMessage("PH_MAX_DURN", "PH")+disp_durn);
				frmObj_pres_dtl.durn_value.value=drg_max_durn_value; //Added for ML-BRU-SCF-0820 [IN:039500] -Start
				if(frmObj_pres_dtl.durn_desc.value != max_durn_type){
					var len1 = frmObj_pres_dtl.durn_desc.options.length;
					var durn_found=false;
					for(indx=0;indx<len1;indx++){
						if(frmObj_pres_dtl.durn_desc.options[indx].value==max_durn_type){
							frmObj_pres_dtl.durn_desc.selectedIndex= indx;
							durn_found =true;
							break;
						}
					}
				}
				if(durn_found)
					frmObj_pres_dtl.durn_value.focus();
				else
					frmObj_pres_dtl.frequency.focus();  //Added for ML-BRU-SCF-0820 [IN:039500] - end
				populateEndDate();//Added for INC#49425
				return false;
			}
			else if(chk_for_max_durn_action=="W")	{
				alert(getMessage("PH_WARN_DURN", "PH")+disp_durn);
				populateStartDate(frmObj_pres_dtl.durn_value,sliding_scale_yn); 
			}
			else if(chk_for_max_durn_action=="A") {
				ord_auth_reqd_yn = "Y";
				//if(document.prescription_detail_form != undefined){
				alert(getMessage("PH_AUTH_DURN", "PH")+disp_durn);
				getOrderCatalogAuthRule();//ADDED FOR MO-SCF-5533
				dtl_all.lbl_authorize.style.visibility='visible';
				if(dtl_all.lbl_authorize.style.color == 'green'){
					if(frmObj_pres_dtl.ord_authorized_prev_yn.value!='Y'){
						dtl_all.lbl_authorize.style.color="red";
						frmObj_pres_dtl.authroize_yn_val.value="N";
					}
				}
				else{
					if(dtl_all.lbl_authorize.style.color != 'red' && 
						dtl_all.lbl_authorize.style.color!='green'){
						if(frmObj_pres_dtl.ord_authorized_prev_yn.value=='Y'){
							dtl_all.lbl_authorize.style.color="green";
							frmObj_pres_dtl.authroize_yn_val.value="Y";
						}
						else{
							dtl_all.lbl_authorize.style.color="red";
							frmObj_pres_dtl.authroize_yn_val.value="N";
						}
					}
					//ADDED FOR MO-SCF-5533 start
					if(dtl_all.lbl_authorize.style.color == 'red'){
						
						
						if(frmObj_pres_dtl.ord_authorized_yn_durn.value=='Y'){
							dtl_all.lbl_authorize.style.color="green";
							frmObj_pres_dtl.authroize_yn_val.value="Y";
						}
					}
					//ADDED FOR MO-SCF-5533 end
					
				}

				var drug_code	=	frmObj_pres_dtl.drug_code.value;		
				var fldString	=" ord_authorized_prev_yn=\""+ frmObj_pres_dtl.ord_authorized_prev_yn.value + "\" ";
				fldString  +=" ord_auth_reqd_yn=\""+ ord_auth_reqd_yn + "\" ";
				fldString  +=" ord_authorized_yn=\""+ frmObj_pres_dtl.authroize_yn_val.value + "\" ";
				fldString  +=" quota_limit_access_yn=\""+ frmObj_pres_dtl.quota_limit_access_yn.value + "\" "; // ML-MMOH-CRF-1823 US008- 43528
				fldString  +=" srl_no=\""+ frmObj_pres_dtl.srl_no.value + "\" ";
				fldString  +=" drug_code=\""+ drug_code + "\" ";
				var xmlStr      =formXMLString(frmObj_pres_dtl,fldString);
				fieldValidation(xmlStr,"setDurationAction");
				populateStartDate(frmObj_pres_dtl.durn_value,sliding_scale_yn); 
				/*}
				else{
					alert(getMessage("PH_AUTH_DURN", "PH")+disp_durn);
					 parent.f_detail.document.getElementById("lbl_authorize").style.visibility='visible';
					if( parent.f_detail.document.getElementById("lbl_authorize").style.color == 'green'){
						if(frmObj_pres_dtl.ord_authorized_prev_yn.value!='Y'){
							 parent.f_detail.document.getElementById("lbl_authorize").style.color="red";
							frmObj_pres_dtl.authroize_yn_val.value="N";
						}
					}
					else{
						if( parent.f_detail.document.getElementById("lbl_authorize").style.color != 'red' && 
						 parent.f_detail.document.getElementById("lbl_authorize").style.color!='green'){
							if(frmObj_pres_dtl.ord_authorized_prev_yn.value=='Y'){
								 parent.f_detail.document.getElementById("lbl_authorize").style.color="green";
								frmObj_pres_dtl.authroize_yn_val.value="Y";
							}
							else{
								 parent.f_detail.document.getElementById("lbl_authorize").style.color="red";
								frmObj_pres_dtl.authroize_yn_val.value="N";
							}
						}
					}
					//chkAuthorization("auth");
					populateStartDate(frmObj_pres_dtl.durn_value);
				}*/
			}
			else{
				populateStartDate(frmObj_pres_dtl.durn_value,sliding_scale_yn); 
			}
		}
		else{
			if(frmObj_pres_dtl.sliding_scale_yn.value == 'N'){
				//if(frmObj_pres_dtl.ord_auth_reqd_yn.value == "N"){// Condition commented for IN17323 to update end date on changing duration 13/01/2010   Shyampriya
					//dtl_all.lbl_authorize.style.visibility='hidden'; ////commented on 25/02/2010
					var drug_code	=	frmObj_pres_dtl.drug_code.value;		
					var fldString	=" ord_authorized_prev_yn=\""+ frmObj_pres_dtl.ord_authorized_prev_yn.value + "\" ";
					fldString  +=" ord_auth_reqd_yn=\""+ frmObj_pres_dtl.ord_auth_reqd_yn.value + "\" ";
					fldString  +=" ord_authorized_yn=\""+ frmObj_pres_dtl.authroize_yn_val.value + "\" ";
					fldString  +=" quota_limit_access_yn=\""+ frmObj_pres_dtl.quota_limit_access_yn.value + "\" "; // ML-MMOH-CRF-1823 US008- 43528
					fldString  +=" srl_no=\""+ frmObj_pres_dtl.srl_no.value + "\" ";
					fldString  +=" drug_code=\""+ drug_code + "\" ";
					var xmlStr      =formXMLString(frmObj_pres_dtl,fldString);
					fieldValidation(xmlStr,"setDurationAction");
					populateStartDate(frmObj_pres_dtl.durn_value,sliding_scale_yn); 
				//} end of condition ord_auth_reqd_yn
			}
		}
	}
	return true; //Added for ML-BRU-SCF-0820 [IN:039500]
}

function populateStartDate(obj,sliding_scale_yn){
	var source=obj.name;
	var frmObj_pres_dtl= "";
	var hdr_frm = "";
	if(sliding_scale_yn=='Y'){	//condition added for IN22255 -- 23/06/2010 -- priya
		if(document.prescription_detail_form!=undefined){
			frmObj_pres_dtl		= document.prescription_detail_form;
			hdr_frm = parent.parent.f_header.document.prescription_header_form;
		}
		else{ //here
			frmObj_pres_dtl		=  parent.f_detail.f_sliding_scale_admin_dtls.prescription_detail_form;
			hdr_frm = parent.f_header.document.prescription_header_form;
		}
	}
	else{	
		if(document.prescription_detail_form != undefined){ //here
			frmObj_pres_dtl		= document.prescription_detail_form;
			hdr_frm = parent.f_header.document.prescription_header_form;
		}
			else if(parent.f_detail!=undefined){ //here
			frmObj_pres_dtl = parent.f_detail.document.prescription_detail_form;
			hdr_frm = parent.f_header.document.prescription_header_form;
		}
		else{
			frmObj_pres_dtl = parent.parent.f_detail.document.prescription_detail_form;
			hdr_frm = parent.parent.f_header.document.prescription_header_form;
		}
	}

//	var mode=frmObj_pres_dtl.mode.value;
	var sys_date=hdr_frm.sys_date.value;
	if(frmObj_pres_dtl.start_date.value==''){
		frmObj_pres_dtl.start_date.value=sys_date;
	}
	var start_date=frmObj_pres_dtl.start_date.value;
	var fldString=" start_date=\""+ start_date + "\" ";
	fldString += " source=\""+ source + "\" ";
	fldString += " sliding_scale_yn=\""+ sliding_scale_yn + "\" "; //added for IN22255 -- 23/06/2010 -- priya
	
	var xmlStr=formXMLString(frmObj_pres_dtl,fldString);
	return fieldValidation(xmlStr,"populateStartDate");
}

function assignStartDate(source,start_date,future_date,back_date,sliding_scale_yn){
	var frmObj_pres_dtl= "";
	if(sliding_scale_yn =='Y'){ //condition added for IN22255 -- 23/06/2010 -- priya
		if(document.prescription_detail_form != undefined){
			frmObj_pres_dtl		= document.prescription_detail_form;
		}
		else
			frmObj_pres_dtl		= parent.f_detail.f_sliding_scale_admin_dtls.prescription_detail_form;
	}
	else{
		if(document.prescription_detail_form != undefined){
			frmObj_pres_dtl		= document.prescription_detail_form;
		}
		else if(parent.f_detail != undefined ){
			frmObj_pres_dtl = parent.f_detail.document.prescription_detail_form;
		}
		else{
			frmObj_pres_dtl = parent.parent.f_detail.document.prescription_detail_form;
		}
	}

	frmObj_pres_dtl.start_date.value=start_date;

	if(source=="qty_value"){
		frmObj_pres_dtl.end_date.value=start_date;
		populateEndDate();
	}
	else if(source=="durn_value"){
		populateEndDate();
	}
}

function enableRefillDetails(obj){
	if(obj.checked==true){
		document.prescription_detail_form.no_refill.disabled=false;
	}
	else{
		document.prescription_detail_form.no_refill.value="";
		document.prescription_detail_form.refill_start_date.value="";
		document.prescription_detail_form.refill_end_date.value="";
		document.prescription_detail_form.no_refill.disabled=true;
		document.prescription_detail_form.refill_detail_link.style.visibility="hidden";
	}
}

function validateMaxRefillDuration(mode,frm,sliding_scale_yn){

	if(mode=="refill") { 
		var durn_value		=	noOfDays(document.refill_form.repeat_durn_type,document.refill_form.durn_value.value);//Modified for IN:069886
		if(durn_value=="") durn_value="0";
		durn_value			=	parseInt(durn_value);
		var max_durn_for_refill_pres	=	parseInt(document.refill_form.max_durn_for_refill_pres.value);
		var refill			=	document.refill_form.no_refill.value;
		if(refill=="") 
			refill="0";
		refill	=	parseInt(refill);
		if((refill*durn_value)<= max_durn_for_refill_pres){
			return true;
		}
		else{
			document.refill_form.no_refill.value="";
			alert(getMessage("PH_MAX_REFILL_DURN", "PH"));
			document.refill_form.no_refill.focus();
			return false;
		}
	}
	else {
		var frmObj_pres_dtl = "";
		if(frm == "confirm" && !(sliding_scale_yn=='Y')){ //sliding_scale_yn condition added for IN22255 --23/06/2010 --priya
			frmObj_pres_dtl			= parent.f_detail.document.prescription_detail_form;
		}else if(frm == "release"){
			frmObj_pres_dtl		= parent.parent.f_detail.document.prescription_detail_form;		
		}else{
			frmObj_pres_dtl		=	document.prescription_detail_form;
		}
		if(sliding_scale_yn == 'Y'){
			return true;
		}
		var durn_value		=	noOfDays(frmObj_pres_dtl.durn_desc,frmObj_pres_dtl.durn_value.value);//Modified for IN:069886
		if(durn_value=="") durn_value="0";
		durn_value			=	parseInt(durn_value);
		var max_durn_for_refill_pres	=	parseInt(frmObj_pres_dtl.max_durn_for_refill_pres.value);
		var refill			=	frmObj_pres_dtl.no_refill.value;
		
		if(refill=="") refill="0";
		    refill			=	parseInt(refill);
		if(frmObj_pres_dtl.drug_code.value != ""){
			if((refill*durn_value)<= max_durn_for_refill_pres){
					return true;
			}
			else{

				alert(getMessage("PH_MAX_REFILL_DURN", "PH"));
			/*	if(mode=="refill"){	
					frmObj_pres_dtl.refill_detail_link.style.visibility="hidden";
					frmObj_pres_dtl.refill_start_date.value="";
					frmObj_pres_dtl.refill_end_date.value="";
					frmObj_pres_dtl.no_refill.value="";
					frmObj_pres_dtl.no_refill.focus();
				}
				else{*/
					frmObj_pres_dtl.durn_value.focus();
					frmObj_pres_dtl.durn_value.select();
				//}
				return false;
			}
		}else{
			return true;
		}
	}
}

function validateNoRefill(obj){
	var max_refill_for_pres	=parseInt(document.refill_form.max_refills_for_pres.value);
	var refill	=	parseInt(obj.value==null?"0":obj.value);
	obj.value=refill;
	if(validateMaxRefillDuration("refill")){
		if(refill >=0){
			if(refill<=max_refill_for_pres){
				populateRefillDates();
			}
			else{
				alert(getMessage("PH_MAX_REFILL", "PH"));
				
			}
		}
	}
}

function assignRefillDates(refill_start,refill_end){
	var end_date			=	document.refill_form.end_date.value;
	var repeat_durn_type	=	document.refill_form.repeat_durn_type.value;
	var durn_value			=	document.refill_form.durn_value.value;
	var refill_no			=	document.refill_form.no_refill.value;
	var bean_id				=	document.refill_form.bean_id.value;
	var bean_name			=	document.refill_form.bean_name.value;
	var presBean_id			=	document.refill_form.presBean_id.value; //Added for MMS-SCF-0085 [IN:042992] 
	var presBean_name		=	document.refill_form.presBean_name.value;//Added for MMS-SCF-0085 [IN:042992] 
	var srl_no				=	document.refill_form.srl_no.value;
	var max_refills			=	document.refill_form.max_refills_for_pres.value;
	var max_durn_for_refill_pres	=	document.refill_form.max_durn_for_refill_pres.value;
	//var tmp_durn_value			=	document.refill_form.tmp_durn_value.value;//Added for IN:069886 //modified for IN:069886
	var date_range_in_muliples	=	document.refill_form.date_range_in_muliples.value;//Added for IN:069886
	var interval_value			=	document.refill_form.interval_value.value;//Added for IN:069886
	var freq_durn_type	=	document.refill_form.freq_durn_type.value;//Added for IN:069886
	parent.refill_detail.location.href="../../ePH/jsp/PrescriptionRefillDetails.jsp?bean_id="+bean_id+"&bean_name="+bean_name+"&presBean_id="+presBean_id+"&presBean_name="+presBean_name+"&end_date="+end_date+"&repeat_durn_type="+repeat_durn_type+"&durn_value="+durn_value+"&refill_no="+refill_no+"&max_refills="+max_refills+"&max_durn_for_refill_pres="+max_durn_for_refill_pres+"&srl_no="+srl_no+"&date_range_in_muliples="+date_range_in_muliples+"&freq_durn_type="+freq_durn_type+"&interval_value="+interval_value;//Modified for IN:069886
}

function populateRefillDates(){
	var end_date			=	document.refill_form.end_date.value;
	var repeat_durn_type	=	document.refill_form.repeat_durn_type.value;
	var durn_value			=	document.refill_form.durn_value.value;
	var refill_no			=	document.refill_form.no_refill.value;
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
function chkPopulateRefill(){
	var end_date			=	document.prescription_detail_form.end_date.value;
	var repeat_durn_type	=	document.prescription_detail_form.durn_desc.value;
	var durn_value			=	document.prescription_detail_form.durn_value.value;
	var refill_no			=	document.prescription_detail_form.no_refill.value;
	var srl_no				=	document.prescription_detail_form.srl_no.value;
	
	var fldString=" end_date=\""+ end_date + "\" ";
	fldString += " repeat_durn_type=\""+ repeat_durn_type + "\" ";
	fldString += " durn_value=\""+ durn_value + "\" ";
	fldString += " refill_no=\""+ refill_no + "\" ";
	fldString += " srl_no=\""+ srl_no + "\" ";
	fldString += " frm=\""+ "DurationBlur" + "\" ";
	var formobj=document.prescription_detail_form;
	var xmlStr=formXMLString(formobj,fldString);
	fieldValidation(xmlStr,"populateRefillDates");
}
async function loadRefillDetails(max_refills){
	var end_date			=	document.prescription_detail_form.end_date.value;
	var repeat_durn_type	=	document.prescription_detail_form.repeat_durn_type.value;
	var durn_desc			=	document.prescription_detail_form.durn_desc.value;
	repeat_durn_type		=	durn_desc;
	var durn_value			=	document.prescription_detail_form.durn_value.value;
	var tmp_durn_value			=	document.prescription_detail_form.tmp_durn_value.value;//Added for IN:069886
	var date_range_in_muliples = parseInt(parseInt(document.prescription_detail_form.tmp_durn_value.value)/parseInt(document.prescription_detail_form.durn_value.value));//Added for IN:069886
	var freq_durn_type	=	document.prescription_detail_form.repeat_durn_type.value;//Added for IN:069886
	var interval_value	=	document.prescription_detail_form.interval_value.value;//Added for IN:069886
	var refill_no			=	document.prescription_detail_form.no_refill.value;
	var bean_id				=	document.prescription_detail_form.bean_id.value;
	var bean_name			=	document.prescription_detail_form.bean_name.value;
	var presBean_id				=	document.prescription_detail_form.presBean_id.value; //Added for MMS-SCF-0085 [IN:042992] 
	var presBean_name			=	document.prescription_detail_form.presBean_name.value; //Added for MMS-SCF-0085 [IN:042992] 
	var srl_no				=	document.prescription_detail_form.srl_no.value;
	var max_durn_for_refill_pres = document.prescription_detail_form.max_durn_for_refill_pres.value;

	if(end_date!=""){
		var dialogHeight= "80vh" ;
		var dialogWidth	= "80vw" ;
		var dialogTop	= "" ;
		var dialogLeft	= "" ;
		var center		= "1" ;
		var status		= "no";
		var scroll		= "yes";
		var features	= "dialogLeft:" + dialogLeft + ";dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; center: " + center + ";scroll "+scroll+"; status: " + status + "; dialogTop :" + dialogTop;
		var arguments	= "" ;
		retVal = await window.showModalDialog("../../ePH/jsp/PrescriptionRefillDetailsFrame.jsp?bean_id="+bean_id+"&bean_name="+bean_name+"&presBean_id="+presBean_id+"&presBean_name="+presBean_name+"&end_date="+end_date+"&repeat_durn_type="+repeat_durn_type+"&durn_value="+durn_value+"&refill_no="+refill_no+"&max_refills="+max_refills+"&max_durn_for_refill_pres="+max_durn_for_refill_pres+"&srl_no="+srl_no+"&date_range_in_muliples="+date_range_in_muliples+"&freq_durn_type="+freq_durn_type+"&interval_value="+interval_value,arguments,features);//Modified for IN:069886

		if(retVal!="" && retVal != null) {
			var refill_vals	=	retVal.split(",");
			if(refill_vals[0]!='') {
				document.prescription_detail_form.no_refill.value=refill_vals[0];
				document.prescription_detail_form.refill_start_date.value=refill_vals[1];
				document.prescription_detail_form.refill_end_date.value=refill_vals[2];
			}
		}
		
	}
	else{
		alert(getMessages("PH_CURR_END_DATE", "PH"));
	}
}

async function callOrderRemarks(){
	//alert("call4");
	var patient_id		= document.prescription_header_form.patient_id.value;
	var encounter_id    = document.prescription_header_form.encounter_id.value;
	var bean_id         = "@PrescriptionBean_1"+patient_id+encounter_id;		
	var bean_name		= document.prescription_header_form.bean_name.value;
	var order_remarks   = document.prescription_header_form.order_remarks.value;
	var dialogHeight	= "40vh" ;
	var dialogWidth		= "50vw" ;
	var dialogTop		= "10" ;
	var dialogLeft		= "10" ;
	var center			= "1" ;
	var status			="no";
	var scroll			="yes";
	var features		= "dialogLeft:" + dialogLeft + ";dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; center: " + center + ";scroll "+scroll+"; status: " + status + "; dialogTop :" + dialogTop;
	var arguments		= "" ;
	retVal = await top.window.showModalDialog("../../ePH/jsp/PrescriptionRemarksFrame.jsp?order_remarks="+order_remarks+"&bean_id="+bean_id+"&bean_name="+bean_name,arguments,features);
	if(retVal!=null)
		document.prescription_header_form.order_remarks.value=retVal;
}

function getFormatId(frm){
	var called_frm		=	"";
	var formobj			= document.prescription_detail_form;
	var order_type		= document.prescription_detail_form.order_type_code.value;
	var form_code		= document.prescription_detail_form.form_code.value;
	var route_code		= document.prescription_detail_form.route_code.value;
	var drug_code		= document.prescription_detail_form.drug_code.value;
	var patient_id		= document.prescription_detail_form.patient_id.value;
	var encounter_id	= document.prescription_detail_form.encounter_id.value;
	var srl_no			= document.prescription_detail_form.srl_no.value;
	var calling_mode	= document.prescription_detail_form.calling_mode.value;
	if(calling_mode=="taper")
		code	=	drug_code+(parseInt(srl_no)+1);
	else
		code	=	drug_code+srl_no;

	if(frm!=undefined || frm!=null)
		called_frm=frm;

	var fldString=" drug_code=\""+ code + "\" ";
		fldString +=" order_type=\""+ order_type + "\" ";
		fldString +=" form_code=\""+ form_code + "\" ";
		fldString +=" route_code=\""+ route_code + "\" ";
		fldString +=" patient_id=\""+ patient_id + "\" ";
		fldString +=" encounter_id=\""+ encounter_id + "\" ";
		fldString +=" called_frm=\""+ called_frm + "\" ";

	var xmlStr=formXMLString(formobj,fldString);
	fieldValidation(xmlStr,"getFormatId");
}

function prescriptionValues(vals)	{
	pres_vals[i++] = vals;
}

function validateRemarks(format_id)	{
	var format	=	format_id.split("~");
	var mandatory	=	format[0];
	formatId	=	format[1];
	if(mandatory == undefined || mandatory== null || mandatory=='null' || mandatory=='')
		mandatory="N";
	drug_code	=	document.prescription_detail_form.drug_code.value;
	//added for SKR-SCF-0140 -start
	document.getElementById('DrugRemarksMandImg').style.display = 'none';
	document.prescription_detail_form.DrugRemarksMandatory.value =mandatory;
	if(format == null || format=='' || formatId==null || formatId==''){
		document.getElementById('drug_remarks').style.display = 'none';
	}
	else{
		document.getElementById('drug_remarks').style='display';
		if(mandatory == 'Y'){
			document.getElementById('DrugRemarksMandImg').style='display';
		}
	}
	//added for SKR-SCF-0140 -end
	 //callOrder();
}

function callOrder()	{

	var vals="";
	for(i=0; i<pres_vals.length; i++)	{
		if(i==pres_vals.length)
			vals	+= pres_vals[i];
		else
			vals	+= pres_vals[i]+ "::";
	}

	var drug_code		=	document.prescription_detail_form.drug_code.value;
	var srl_no			=	document.prescription_detail_form.srl_no.value;
	var calling_mode	=	document.prescription_detail_form.calling_mode.value;

	if(calling_mode=="taper")
		code	=	drug_code+(parseInt(srl_no));// removed +1 form this drug_code+(parseInt(srl_no+1)) for incident no SKR-SCF-0440( 31783)by Chandrashekar Raju Arram
	else
		code	=	drug_code+srl_no;
	if(code!="")
		callRemarks(formatId,drug_code,code,'PH','0','PH');
	else
		return;
}

async function callRemarks(format_id,catalog_code,catalog_codeSRLNO,order_category,row_value,called_from)	{
	patient_id		=document.prescription_detail_form.patient_id.value;
	encounter_id	=document.prescription_detail_form.encounter_id.value;
	order_id 		=document.prescription_detail_form.order_id_copy.value; //Added for ML-BRU-SCF-1333 [IN:049124]
	order_line_no	=document.prescription_detail_form.order_line_no_copy.value; //Added for ML-BRU-SCF-1333 [IN:049124]
	srl_no			=document.prescription_detail_form.srl_no.value;
	sliding_scale_yn	=document.prescription_detail_form.sliding_scale_yn.value;
	DrugRemarksEntered	=document.prescription_detail_form.DrugRemarksEntered.value; //Added for Antibiotic Screen using Order Entry Format ICN 29904
	form_code		=document.prescription_detail_form.form_code.value;
	if(sliding_scale_yn=="N")
		route_code		=document.prescription_detail_form.route_code.options[document.prescription_detail_form.route_code.selectedIndex].value;
	else
		route_code = document.prescription_detail_form.route_code.value;

	bean_id			= "@orderentrybean"+patient_id+encounter_id;
	bean_name		= "eOR.OrderEntryBean";
	srl_no			= "0";

	var dialogHeight= "400px" ;
	var dialogWidth	= "700px" ;
	var dialogTop	= "169" ;
	var center		= "1" ;
	var status		="no";
	var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop;
	var arguments	= "" ;
	retVal			= await window.showModalDialog("../../eOR/jsp/OrderEntryOrderFormatFrameSet.jsp?bean_id="+bean_id+"&bean_name="+bean_name+"&format_id="+format_id+"&p_catalog_code="+catalog_code+"&catalog_code="+catalog_codeSRLNO+"&p_form_code="+form_code+"&p_route_code="+route_code+"&order_category="+order_category+"&row_value=0&called_from=PH"+"&order_id="+order_id+"&order_line_num="+order_line_no,arguments,features);//order_id & order_line_no Added for ML-BRU-SCF-1333 [IN:049124]
	if(retVal!=undefined ){
		var retVals = retVal.split('~');
		if(retVals[0]=='Y' && DrugRemarksEntered!='Y') //if block Added for Antibiotic Screen using Order Entry Format ICN 29904
			document.prescription_detail_form.DrugRemarksEntered.value = 'Y'
	}
}

function callOrderAmend(order_id,order_line_no)   {
    var vals="";
    for(i=0; i<pres_vals.length; i++)   {
        if(i==pres_vals.length) 
		  vals    += pres_vals[i];
        else
		  vals    += pres_vals[i]+ "::";
    }
	var drug_code       = document.prescription_detail_form.drug_code.value;
	var srl_no			= document.prescription_detail_form.srl_no.value;

	code	=	drug_code+srl_no;
    callAmendRemarks(formatId,drug_code,code,'PH','0','PH',order_id,order_line_no);
}

async function callAmendRemarks(format_id,catalog_code,catalog_codeSRLNO,order_category,row_value,called_from,order_id,order_line_no)    {
   	patient_id		=document.prescription_detail_form.patient_id.value;
	encounter_id	=document.prescription_detail_form.encounter_id.value;
	srl_no			=document.prescription_detail_form.srl_no.value;
	sliding_scale_yn	=document.prescription_detail_form.sliding_scale_yn.value;
	form_code		=document.prescription_detail_form.form_code.value;
	route_code = document.prescription_detail_form.route_code.value;
	DrugRemarksEntered	=document.prescription_detail_form.DrugRemarksEntered.value; //Added for Antibiotic Screen using Order Entry Format ICN 29904
    bean_id     = "@orderentrybean"+patient_id+encounter_id;
    bean_name   = "eOR.OrderEntryBean";
    srl_no      = "0";
    var dialogHeight= "35vh" ;
    var dialogWidth = "50vw" ;
    var dialogTop = "169" ;
    var center = "1" ;
    var status="no";
    var features    = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop;
    var arguments   = "" ;
	//if(pres_remarks!="")
	//format_id="";
	retVal = await window.showModalDialog("../../eOR/jsp/OrderEntryOrderFormatFrameSet.jsp?bean_id="+bean_id+"&bean_name="+bean_name+"&order_id="+order_id+"&order_line_num="+order_line_no+"&format_id="+format_id+"&p_catalog_code="+catalog_code+"&catalog_code="+catalog_codeSRLNO+"&order_category="+order_category+"&row_value=0&called_from=PH"+"&p_form_code="+form_code+"&p_route_code="+route_code,arguments,features);
	if(retVal!=undefined ){
		var retVals = retVal.split('~');
		//if(retVal!=undefined && retVal=='Y' && DrugRemarksEntered!='Y') //if block Added for Antibiotic Screen using Order Entry Format ICN 29904
		if(retVals[0]=='Y' && DrugRemarksEntered!='Y') //if block added for [IN:039576]
			document.prescription_detail_form.DrugRemarksEntered.value = 'Y'
	}
}

function chkBackFutureOrderDate(obj,param,locale){
	if(obj.value!=""){
		var back_date	= document.prescription_header_form.back_date.value;
		var future_date = document.prescription_header_form.future_date.value;
		var pregnency_yn=document.prescription_header_form.pregnency_yn.value;//added for CRF RUT-CRF-0063[29601]-start
		if(pregnency_yn=="Y"){
			settrimester(obj.value);
		}//added for CRF RUT-CRF-0063[29601]-end
		if(validDate(obj.value, "DMYHM",locale )){
			if(future_date!="0"){
				if(isAfter(obj.value,future_date, "DMYHM",locale)){
					alert(getMessage("PH_BACK_DATE", "PH"));
					obj.value="";
					//obj.focus();
					return false;
				}
			}
			if(back_date!="0"){
				if(isBefore(obj.value,back_date, "DMYHM",locale)){
					alert(getMessage("PH_BACK_DATE", "PH"));
					obj.value="";
					//obj.focus();
					return false;
				}
			}
			else{
				obj.disabled=true;
				loadOtherFrames(param);
			}
		}
		else{
			alert(getMessage("INVALID_DATE_TIME", "PH"));
			obj.value="";
			//obj.focus();
			return false;
		}
	}
	else{
		alert(getMessage("PH_FROM_TIME_NOT_BLANK", "PH"));
		//obj.focus();
		return false;
	}
	//checkHomeLeave();//added  for Bru-HIMS-CRF-093[29960]//Commented for Bru-HIMS-CRF-093-DD1
	setDate(obj.value);
}

function chkBackFutureDate(obj, locale){
	if(obj.value!=""){
		var back_date=document.prescription_detail_form.back_date.value;
		var future_date=document.prescription_detail_form.future_date.value;
		var pregnency_yn=document.prescription_detail_form.pregnency_yn.value;//added for CRF RUT-CRF-0063[29601]
		if(validDate(obj.value, "DMYHM",locale )){
			if(future_date!=null && future_date!='null' && future_date!="0" ){
				if(isBefore(obj.value,future_date, "DMYHM",locale)){
					populateEndDate('DATECHANGE'); // DATECHANGE added for MO-GN-5490 [IN:054620] - [IN:055921]
				}
				else{
					alert(getMessage("PH_BACK_DATE", "PH"));
					obj.value="";
					//obj.focus();
					return false;
				}
			}
			else{
				populateEndDate('DATECHANGE'); // DATECHANGE added for MO-GN-5490 [IN:054620] - [IN:055921]
			}
			if(back_date!=null &&  back_date!='null' && back_date!="0"){
				if(isAfter(obj.value,back_date, "DMYHM",locale)){
					populateEndDate('DATECHANGE'); // DATECHANGE added for MO-GN-5490 [IN:054620] - [IN:055921]
				}
				else{
					alert(getMessage("PH_BACK_DATE", "PH"));
					obj.value="";
					//obj.focus();
					return false;
				}
			}
			else{
				populateEndDate('DATECHANGE'); // DATECHANGE added for MO-GN-5490 [IN:054620] - [IN:055921]
			}
		}
		else{
			alert(getMessage("INVALID_DATE_TIME", "PH"));
			obj.value="";
			//obj.focus();
			return false;
		}
	}
	else{
		alert(getMessage("PH_START_DATE", "PH"));
		document.prescription_detail_form.stateDateImg.click();
		return false;
	}
	//checkHomeLeave(); //added  for Bru-HIMS-CRF-093[29960]//Commented for Bru-HIMS-CRF-093-DD1
	if(pregnency_yn=="Y"){// if condition added for CRF RUT-CRF-0063[29601]
		settrimester(obj.value);
	}
	
}

function validateEndDate(dateObj, locale){
	if(dateObj.value!=""){
		if(validDate(dateObj.value, "DMYHM",locale )){
			var start_date=document.prescription_detail_form.start_date.value;
			if(isBefore(start_date,dateObj.value, "DMYHM",locale)){
				frmObj=document.prescription_detail_form;
				if(frmObj.durn_desc.value=='H')
					var durn = hoursBetween(start_date,dateObj.value,"DMYHM",locale);
				else if(frmObj.durn_desc.value=='M')
					var durn = minutesBetween(start_date,dateObj.value,"DMYHM",locale);
				else if(frmObj.durn_desc.value=='W')
					var durn = daysBetween(start_date,dateObj.value,"DMYHM",locale)/7;
				else if(frmObj.durn_desc.value=='L')
					var durn = daysBetween(start_date,dateObj.value,"DMYHM",locale)/30;
				else if(frmObj.durn_desc.value=='Y')
					var durn = daysBetween(start_date,dateObj.value,"DMYHM",locale)/365;				
				else
					var durn = daysBetween(start_date,dateObj.value,"DMYHM",locale);
				if(parseInt(durn) > 999){
					alert(getMessage("DURATION_CANNOT_GREATER999", "PH"));
					document.prescription_detail_form.durn_value.value="";
					//document.prescription_detail_form.durn_value.focus();
					return;
				}
				
				if(durn > 0){
					document.prescription_detail_form.durn_value.value = durn;
					//document.prescription_detail_form.durn_value.focus(); //commented for SKR-SCF-0520 IN[032819]
					//document.prescription_detail_form.durn_value.onchange(); //blur() is changed to onchange() for SKR-SCF-0520 IN[032819]
					document.prescription_detail_form.durn_value.onblur(); //added for SKR-SCF-0701 IN[036106]
				}
				else{
					alert(getMessage("END_DATE_GTR_THAN_START_DATE", "PH"));
					populateEndDate();
					assignHomeDuration();//Added for Bru-HIMS-CRF-093-DD1[IN047223]
				}
			}
			else{
				alert(getMessage("END_DATE_GTR_THAN_START_DATE", "PH"));
				populateEndDate();
				assignHomeDuration();//Added for Bru-HIMS-CRF-093-DD1[IN047223]
			}
		}
	}
	else{
		alert(getMessage("PH_END_DATE", "PH"));
		document.prescription_detail_form.endDateImg.click();
		return false;
	}
}

/*
function validateAuthorizeApproval(){
	var ord_auth_reqd_yn     = document.prescription_detail_form.ord_auth_reqd_yn.value;
	var ord_spl_appr_reqd_yn =
	document.prescription_detail_form.ord_spl_appr_reqd_yn.value;
	var ord_cosign_reqd_yn	 =
	document.prescription_detail_form.ord_cosign_reqd_yn.value;

	hideAuthorizeApprovalLink_1(ord_auth_reqd_yn);
	hideAuthorizeApprovalLink_2(ord_spl_appr_reqd_yn);
	hideAuthorizeApprovalLink_3(ord_cosign_reqd_yn);
}

function hideAuthorizeApprovalLink_1(val){
	document.prescription_detail_form.authroize_yn.value=val;
	if(val=='' || val=='N'){
		document.prescription_detail_form.requires_auth_gif.style.visibility="hidden";
	}
	else if(val=='Y'){

		if(document.prescription_detail_form.authroize_yn_val.value=="N"){
			document.prescription_detail_form.requires_auth_gif.style.visibility="visible";
			document.prescription_detail_form.auth_yn.innerText=getLabel("ePH.RequiresAuthorization.label","PH");
			//chkAuthorization("auth");
		}
		else{
			document.prescription_detail_form.auth_yn.innerHTML="<b>"+getLabel("Common.Authorized.label","Common")+"</b>";	document.prescription_detail_form.requires_auth_gif.src="../../eOR/images/Authorized.gif";
			document.prescription_detail_form.requires_auth_gif.style.visibility="visible";
			document.prescription_detail_form.authroize_yn_val.value="Y";
		}
	}
}

function hideAuthorizeApprovalLink_2(val){
	document.prescription_detail_form.approval_yn.value=val;
	if(val=='' || val=='N'){
		document.prescription_detail_form.spl_approval_gif.style.visibility="hidden";
	}
	else if(val=='Y'){

		if(document.prescription_detail_form.approval_yn_val.value=="N"){
			document.prescription_detail_form.spl_approval_gif.style.visibility="visible";
			document.prescription_detail_form.spl_approval.innerText=getLabel("ePH.RequiresApproval.label","PH");
			//chkAuthorization("approve");
		}
		else{
			document.prescription_detail_form.spl_approval.innerHTML="<b>"+getLabel("Common.Approved.label","Common")+"</b>";	document.prescription_detail_form.spl_approval_gif.src="../../eOR/images/SpecialApproval_click.gif";
			document.prescription_detail_form.spl_approval_gif.style.visibility="visible";
			document.prescription_detail_form.approval_yn_val.value="Y";
		}
	}
}

function hideAuthorizeApprovalLink_3(val){
	document.prescription_detail_form.cosign_yn.value=val;
	if(val=='' || val=='N'){
		document.prescription_detail_form.cosign_gif.style.visibility="hidden";
	}
	else if(val=='Y'){

		if(document.prescription_detail_form.cosign_yn_val.value=="N"){
			document.prescription_detail_form.cosign_gif.style.visibility="visible";
			document.prescription_detail_form.cosign.innerText=getLabel("Common.CosignReqd.label","Common");
			//chkAuthorization("cosign");
		}
		else{
			document.prescription_detail_form.cosign.innerHTML="<b>"+getLabel("ePH.Cosigned.label","PH")+"</b>";
			document.prescription_detail_form.cosign_gif.src="../../eOR/images/Cosign.gif";
			document.prescription_detail_form.cosign_gif.style.visibility="visible";
			document.prescription_detail_form.cosign_yn_val.value="Y";
		}
	}
}

function chkAuthorization(src){

	var allowed_click="";
	if(src=="auth"){
		allowed_click=document.prescription_detail_form.authroize_yn_val.value;
	}
	else if(src=="approve"){
		allowed_click=document.prescription_detail_form.approval_yn_val.value;
	}
	else if(src=="cosign"){
		allowed_click=document.prescription_detail_form.cosign_yn_val.value;
	}
	if(allowed_click=="N"){
		var pract_id=parent.f_header.document.prescription_header_form.pract_id.value;
		var resp_id=parent.f_header.document.prescription_header_form.resp_id.value;
		var fldString=" pract_id=\""+ pract_id + "\" ";
		fldString += " resp_id=\""+ resp_id + "\" ";
		fldString += " src=\""+ src + "\" ";
		var formobj=document.prescription_detail_form;
		var xmlStr=formXMLString(formobj,fldString);
		fieldValidation(xmlStr,"chkAuthorization");
	}
	return true;
}

function assignAuthorization(auth_yn,spl_appr_yn,cosign_yn,src){

	if(src=="auth"){
		if(auth_yn=="Y"){
			document.prescription_detail_form.authroize_yn.value			= "Y";
			document.prescription_detail_form.auth_yn.innerHTML			= "<a HREF='javascript:makeAuthorize()'>"+getLabel("Common.Authorize.label","Common")+"</a>";
			document.prescription_detail_form.auth_yn.style.visibility	= "visible";
		}
		else{
			document.prescription_detail_form.authroize_yn.value			= "N";
			document.prescription_detail_form.auth_yn.innerText			=getLabel("ePH.RequiresAuthorization.label","PH");
			document.prescription_detail_form.auth_yn.style.visibility	= "visible";
		}
	}
	if(src=="approve"){
		if(spl_appr_yn=="Y"){
			document.prescription_detail_form.approval_yn.value				="Y";
			document.prescription_detail_form.spl_approval.innerHTML	="<a HREF='javascript:makeApproval()'>"+getLabel("Common.Approve.label","Common")+"</a>";		document.prescription_detail_form.spl_approval.style.visibility="visible";
		}
		else{
			document.prescription_detail_form.approval_yn.value				="N";
			document.prescription_detail_form.spl_approval.innerText	=getLabel("ePH.RequiresApproval.label","PH");
			document.prescription_detail_form.spl_approval.style.visibility="visible";
		}
	}
	if(src=="cosign"){
		if(cosign_yn=="Y"){
			document.prescription_detail_form.cosign_yn.value				="Y";
			document.prescription_detail_form.cosign.innerHTML			="<a HREF='javascript:makeCosign()'>"+getLabel("Common.Cosign.label","Common")+"</a>";		document.prescription_detail_form.cosign.style.visibility="visible";
		}
		else{
			document.prescription_detail_form.cosign_yn.value				="N";
			document.prescription_detail_form.cosign.innerText			=getLabel("Common.CosignReqd.label","Common");
			document.prescription_detail_form.cosign.style.visibility	="visible";
		}
	}
}

function makeAuthorize(){
	var con=confirm(getMessage("PH_AUTHAPPROVE_1", "PH"));
	if(con){
		document.prescription_detail_form.auth_yn.innerHTML		="<b>"+getLabel("Common.Authorized.label","Common")+"</b>";	document.prescription_detail_form.requires_auth_gif.src="../../eOR/images/Authorized.gif";
		document.prescription_detail_form.authroize_yn_val.value	="Y";
	}
	else{
		document.prescription_detail_form.auth_yn.innerHTML		="<a HREF='javascript:makeAuthorize()'>"+getLabel("Common.Authorize.label","Common")+"</a>";
		document.prescription_detail_form.auth_yn.style.visibility="visible";document.prescription_detail_form.requires_auth_gif.src="../../eOR/images/Authorization.gif";
		document.prescription_detail_form.authroize_yn_val.value	="N";
	}
}

function makeApproval(){
	var con=confirm(getMessage("PH_AUTHAPPROVE_2", "PH"));
	//var con=confirm("you are allowed to approve this order. Approve now?");
	if(con){
		document.prescription_detail_form.spl_approval.innerHTML="<b>"+getLabel("Common.Approved.label","Common")+"</b>";	document.prescription_detail_form.spl_approval_gif.src="../../eOR/images/SpecialApproval_click.gif";
		document.prescription_detail_form.approval_yn_val.value		="Y";
		document.prescription_detail_form.auth_yn.innerHTML		="<b>"+getLabel("Common.Authorized.label","Common")+"</b>";	document.prescription_detail_form.requires_auth_gif.src="../../eOR/images/Authorized.gif";
		document.prescription_detail_form.authroize_yn_val.value	="Y";
	}
	else{
		document.prescription_detail_form.spl_approval.innerHTML="<a HREF='javascript:makeApproval()'>"+getLabel("Common.Approve.label","Common")+"</a>";		document.prescription_detail_form.spl_approval.style.visibility="visible";		document.prescription_detail_form.spl_approval_gif.src="../../eOR/images/SpecialApproval.gif";
		document.prescription_detail_form.approval_yn_val.value		="N";
	}
}

function makeCosign(){
	var con=confirm(getMessage("PH_AUTHAPPROVE_3", "PH"));
	//var con=confirm("you are allowed to cosign this order.  now?");
	if(con){
		document.prescription_detail_form.cosign.innerHTML="<b>"+getLabel("ePH.Cosigned.label","PH")+"</b>";	document.prescription_detail_form.cosign_gif.src="../../eOR/images/Cosign.gif";
		document.prescription_detail_form.cosign_yn_val.value="Y";
	}
	else{
		document.prescription_detail_form.cosign.innerHTML="<a HREF='javascript:makeCosign()'>"+getLabel("Common.Cosign.label","Common")+"</a>";		document.prescription_detail_form.cosign.style.visibility="visible";		document.prescription_detail_form.cosign_gif.src="../../eOR/images/Cosign_click.gif";
		document.prescription_detail_form.cosign_yn_val.value="N";
	}
}
*/
function DisableSchedule(){
	
	var drug_code = document.prescription_detail_form.drug_code.value;
	var srl_no	  = document.prescription_detail_form.srl_no.value;
	var calling_mode  = document.prescription_detail_form.calling_mode.value;

	if(calling_mode=="taper")
		code	=	drug_code+(parseInt(srl_no)+1);
	else
		code	=	drug_code+srl_no;

	var fldString=" drug_code=\""+ code + "\" ";
	var formobj=document.prescription_detail_form;
	var xmlStr=formXMLString(formobj,fldString);
	fieldValidation(xmlStr,"disableScheduleLink");
}

function deleteScheduleLink(){
	document.prescription_detail_form.frequency.disabled =false;
//	document.prescription_detail_form.split_dose.disabled=true;
	document.prescription_detail_form.sch_over_yn.value="Y";
	document.prescription_detail_form.admin_time.value="";
	document.prescription_detail_form.admin_qty.value="";
	var dosage_type=document.prescription_detail_form.dosage_type.value;
	validateQtyDesc(dosage_type,"R");			
}
/* Commented - Not used
function retainValue(dosage_type) {
	var init_qty		=	document.prescription_detail_form.init_qty.value;
	var tab_qty_value	=	document.prescription_detail_form.tab_qty_value.value;

	if(dosage_type=="S") {
		document.prescription_detail_form.qty_value.value=init_qty;
	}
	else if(dosage_type=="Q") {
		document.prescription_detail_form.qty_value.value=tab_qty_value;
	}
}*/

async function callSchedule(patient_id,encounter_id,bean_id,bean_name,drug_code,srl_no,freq_code,row_value,facility_id,max_qty,unit_qty,split_dose_yn,split_qty,qty_reqd_yn,called_from,uom_desc) {
	var chk_max			= "N";
	var chk_unit		= "N";

	if(max_qty!='0'){
		chk_max = "Y";
	}
	if(unit_qty!='0'){
		chk_unit = "Y";
	}
//	var uom_description		= document.prescription_detail_form.qty_desc[document.prescription_detail_form.qty_desc.selectedIndex].text;
     uom_desc=encodeURIComponent(uom_desc,"UTF-8");
	var retVal;
 	var dialogTop		= "0";
 	var dialogHeight	= "0" ;
 	var dialogWidth		= "0" ;
 	var features		= 'Width:' + dialogWidth +'; dialogHeight:' + dialogHeight + '; dialogWidth:' + dialogWidth +'; dialogTop:'+dialogTop +'; scroll=no; status=no';
 	var arguments		= "";
	code	=	drug_code+srl_no;
 	retVal 				= await window.showModalDialog("../../eOR/jsp/ScheduleFrequency.jsp?mode=1&bean_id="+bean_id+"&uom_desc="+uom_desc+"&bean_name="+bean_name+"&chk_max="+chk_max+"&chk_unit="+chk_unit+"&max_qty="+max_qty+"&split_dose_yn="+split_dose_yn+"&split_qty="+split_qty+"&qty_reqd_yn="+qty_reqd_yn+"&unit_qty="+unit_qty+"&code="+code+"&row_value="+row_value+"&facility_id="+facility_id+"&freq_code="+freq_code+"&module_id=PH&called_from="+called_from,arguments,features);
}

async function DisplaySchedule(called_from) {
	if(called_from==undefined)
		called_from=""
	var frmObj=document.prescription_detail_form;
	var patient_id		= frmObj.patient_id.value;
	var encounter_id	= frmObj.encounter_id.value;
	var bean_id			= "@PrescriptionBean_1"+patient_id+encounter_id;
	var bean_name		= "ePH.PrescriptionBean_1";
	var drug_code		= frmObj.drug_code.value;
	var srl_no			= frmObj.srl_no.value;
 	var freq_code		= frmObj.frequency.value;
	var row_value       = frmObj.rowVal.value;
	var fract_dose_appl_yn       = frmObj.fract_dose_appl_yn.value;
	var fract_dose_round_up_yn       = frmObj.fract_dose_round_up_yn.value;
	var slidingscale="N";
	if(frmObj.sliding_scale_yn!=undefined)
		slidingscale=frmObj.sliding_scale_yn.value;
	if(drug_code!=""){
		if(parent.f_header==null){
			var facility_id		= frmObj.facility_id.value;
		}
		else{
			var facility_id		= parent.f_header.document.prescription_header_form.facility_id.value;
		}
		var sliding_scale_yn = "";
		if(frmObj.sliding_scale_yn != undefined)
			sliding_scale_yn = frmObj.sliding_scale_yn.value;
		var	max_qty		    = frmObj.daily_dose.value;
		var	unit_qty		= frmObj.unit_dose.value;
		var split_dose_yn   = frmObj.split_dose_yn.value;
		var split_qty       = frmObj.qty_value.value;
		var qty_reqd_yn     = frmObj.qty_reqd_yn.value;
		var calling_mode	= frmObj.calling_mode.value;
		if(sliding_scale_yn=='Y')
			split_qty=frmObj.absol_qty.value;

		var chk_max			= "N";
		var chk_unit		= "N";

		if(max_qty!='0'){
			chk_max = "Y";
		}

		if(unit_qty!='0'){
			chk_unit = "Y";
		}

		var start_time_day_param = frmObj.start_date.value;
		var pr_duration			 = frmObj.durn_value.value;
		var pr_duration_type	 = frmObj.durn_desc.value;
		var durationType_P		 = frmObj.repeat_durn_type.value;
		var uom_desc		= frmObj.qty_desc.value;
		if(sliding_scale_yn == "Y"){
			var uom_description		=  uom_desc;
		}
		else{
			var uom_description		= frmObj.qty_desc[frmObj.qty_desc.selectedIndex].value; //replaced .text with .value for IN25425 --09/12/2010-- priya
		}
        uom_description=encodeURIComponent(uom_description,"UTF-8");
		if(uom_description!=""){
			var retVal;
			var dialogTop		= "260";
			var dialogHeight	= "55vh" ;
			var dialogWidth		= "50vw" ;
			var features		= ' dialogHeight:' + dialogHeight + '; dialogWidth:' + dialogWidth +'; dialogTop:'+dialogTop +'; scroll=no; status=no';
			var arguments		= "";
			if(calling_mode=="taper")
				code	=	drug_code+frmObj.tapper_srl_no.value;
			else
				code	=	drug_code+srl_no;

			retVal 				= await top.window.showModalDialog("../../eOR/jsp/ScheduleFrequency.jsp?mode=1&bean_id="+bean_id+"&uom_desc="+uom_description+"&bean_name="+bean_name+"&chk_max="+chk_max+"&chk_unit="+chk_unit+"&max_qty="+max_qty+"&split_dose_yn="+split_dose_yn+"&split_qty="+split_qty+"&qty_reqd_yn="+qty_reqd_yn+"&unit_qty="+unit_qty+"&code="+code+"&row_value="+row_value+"&facility_id="+facility_id+"&freq_code="+freq_code+"&sliding_scale_yn="+sliding_scale_yn+"&module_id=PH&called_from="+called_from+"&fract_value_yn="+fract_dose_appl_yn+"&start_time_day_param="+start_time_day_param+"&pr_duration="+pr_duration+"&pr_duration_type="+pr_duration_type+"&org_drug_code="+drug_code+"&interval_durn_type="+durationType_P,arguments,features);
			if(retVal!=null && retVal!=undefined){
				oldrepeatvalue=frmObj.repeat_value.value;
				frmObj.sch_over_yn.value="Y";
				if(frmObj.taper_disable.value="")
					frmObj.split_dose.disabled=false;
				
				var split_vals = retVal[1].split('~~');			
				var len = frmObj.frequency.options.length;			
				for(img=0;img<len;img++){
					if(frmObj.frequency.options[img].value==split_vals[0]){
						frmObj.frequency.selectedIndex= img	;
						break;
					}
				}
				if(slidingscale=="Y")
					freqChange(frmObj.frequency,'M','Y');
				else
					freqChange(frmObj.frequency,'M');
				var len1 = frmObj.durn_desc.options.length;
				for(img1=0;img1<len1;img1++){
					if(frmObj.durn_desc.options[img1].value==retVal[3]){
						frmObj.durn_desc.selectedIndex= img1	;
						break;
					}
				}
				frmObj.durn_value.value=retVal[2];
				if(slidingscale=="Y")
					validateDuration(frmObj.tmp_durn_value,'','Y');//durn_value to tmp_durn_valuemodified for tbmc-scf-0051
				else
					validateDuration(frmObj.tmp_durn_value);//durn_value to tmp_durn_valuemodified for tbmc-scf-0051
				putDecimal(frmObj.durn_value,3,0);

				durationConversn(frmObj.durn_desc);
				getChargeDetails(frmObj.in_formulary_yn.value);
				if(slidingscale!="Y"){
					chkPopulateRefill();
				}
				else{
					populateEndDate();
				}
				var drug_code = frmObj.drug_code.value;
				var srl_no = frmObj.srl_no.value;
				var fldString=" drug_code=\""+ code + "\" ";
				fldString += " drug_codeOnly=\""+ drug_code + "\" ";
				fldString += " srl_no=\""+ srl_no + "\" ";
				fldString += " sliding_scale_yn=\""+ sliding_scale_yn + "\" ";
				var formobj=frmObj;
				var xmlStr=formXMLString(formobj,fldString); 
				fieldValidation(xmlStr,"makeScheduleLink");
			}
			else{
				frmObj.sch_over_yn.value="Y";
				if(sliding_scale_yn != 'Y'){
					frmObj.qty_value.disabled=false;
				//	frmObj.qty_value.focus();
				}
			}
		}
		else{
			alert(getMessage("PH_QTY_DESC", "PH"));
			frmObj.split_dose.disabled=true;
			frmObj.sch_over_yn.value="Y";
			frmObj.qty_desc.focus();
			return false;
		}
	}
 }

function makeScheduleLink(admin_time,admin_qty,total_qty,freq_size,split_chk,calling_mode){
	var fract_dose_appl_yn = document.prescription_detail_form.fract_dose_appl_yn.value;
	if(fract_dose_appl_yn !='Y')
		total_qty = parseInt(total_qty);

	var legend	=	"";
	
	if(split_chk=="true"){
		legend	=	getLabel("ePH.SplitDose.label",'PH');		
		if(document.prescription_detail_form.split_dose_yn_val!=null)
		   document.prescription_detail_form.split_dose_yn_val.value="Y";
	}
	else {
		legend	=	getLabel("ePH.ScheduledDose.label",'PH');			
		if(document.prescription_detail_form.split_dose_yn_val!=null)
			document.prescription_detail_form.split_dose_yn_val.value="N";
	}

	if(document.prescription_detail_form.sliding_scale_yn.value == 'Y') {
		legend	=	getLabel("ePH.Sch.label",'PH')+".";		
		admin_qty="";
	} 

	if(admin_qty != "" && parseFloat(admin_qty) < 1)
		admin_qty = parseFloat(admin_qty);

	if(document.prescription_detail_form.taper_disable.value="")
		document.prescription_detail_form.split_dose.disabled=false;
	var title="<table border=1 cellpadding=0 cellspacing=0 align=center>"+admin_time+admin_qty+"</table>";
	document.prescription_detail_form.qty_value.value=Math.abs(total_qty); //added Math.abs for IN25779 --07/11/2011-- priya
	document.getElementById('dosage_label').innerHTML="<label nowrap style='color:red;font-size:10' onmouseover='displayToolTipDataChange(\"" + title + "\");' onmouseout='disasbleToolTipDataChange();'>"+legend+"</label>";
	document.prescription_detail_form.admin_time.value=admin_time;
	document.prescription_detail_form.admin_qty.value=admin_qty;
	var dsg_reason = document.prescription_detail_form.dsg_reason.value;
	var dup_reason = document.prescription_detail_form.dup_reason.value;
	var con_reason = document.prescription_detail_form.con_reason.value;
	var int_reason = document.prescription_detail_form.int_reason.value;
	var alg_reason = document.prescription_detail_form.alg_reason.value;
    // Added the calling moe inside reason  calling_mode!='onLoad' && dsg_reason ==""
	if(calling_mode!='onLoad' || (calling_mode!='onLoad' && dsg_reason =="" && dup_reason=="" && con_reason=="" && int_reason=="" && alg_reason=="" )){
		if(!validateDosageLimit(calling_mode)){
			return false;
		}
	}
	else{
		if(parent.f_header==null) {
		    frameobj	=	parent.parent.f_header;
	    }
	    else {
		    frameobj	=	parent.f_header;
	    }
		var bl_install_yn	            = frameobj.document.prescription_header_form.bl_install_yn.value;
	    var bl_disp_charge_dtl_in_rx_yn	= frameobj.document.prescription_header_form.bl_disp_charge_dtl_in_rx_yn.value;
		var in_formulary_yn             = document.prescription_detail_form.in_formulary_yn.value;
		if(bl_install_yn=='Y' && bl_disp_charge_dtl_in_rx_yn=='Y' && in_formulary_yn == 'Y'){
		    getChargeDetails(in_formulary_yn);
	    }
	}
}

function hideScheduleLink(){
	document.prescription_detail_form.frequency.disabled=false;
	document.prescription_detail_form.frequency.disabled=false;
	if(document.prescription_detail_form.qty_reqd_yn.value=='Y'){
		document.prescription_detail_form.qty_value.disabled=false;
	}
	if(document.prescription_detail_form.dosage.value=="Q"){
		if(parent.f_header==null) {
			frameobj	=	parent.parent.f_header;
		} 
		else {
			frameobj	=	parent.f_header;
		}
		var rx_qty_by_pres_base_uom_yn	=	frameobj.document.prescription_header_form.rx_qty_by_pres_base_uom_yn.value;
		if(rx_qty_by_pres_base_uom_yn=="Y")
			document.prescription_detail_form.qty_desc.disabled	=	true;
		else
			document.prescription_detail_form.qty_desc.disabled	=	false;
	}
	else if(document.prescription_detail_form.dosage.value=="A"){	//else if condition added for IN21941 ====10-06-2010 ===priya
		if(document.prescription_detail_form.qty_desc.value =="")
			document.prescription_detail_form.qty_desc.value		=	document.prescription_detail_form.pres_base_uom.value;
		//document.prescription_detail_form.qty_desc.disabled		=	true;
		if(parent.f_header==null) 
			frameobj	=	parent.parent.f_header;
		else 
			frameobj	=	parent.f_header;
		var rx_qty_by_pres_base_uom_yn	=	frameobj.document.prescription_header_form.rx_qty_by_pres_base_uom_yn.value;
		if(rx_qty_by_pres_base_uom_yn=="Y")
			document.prescription_detail_form.qty_desc.disabled	=	true;
		else
			document.prescription_detail_form.qty_desc.disabled	=	false;
	}
	else
		document.prescription_detail_form.qty_desc.disabled=false;
	document.prescription_detail_form.dis_split_dose.style.visibility = 'hidden';
	if(!validateDosageLimit("hideSchedLink")){
		return false;
	}
}

async function loadOtherFrames(params){
	var iv_prep_default			= document.prescription_header_form.iv_prep_default.value;
	var order_set_code			= document.prescription_header_form.order_set_code.value;	

	var allow_detail			= false;
	var ph_load_yn				= parent.parent.parent.parent.parent.orderMainTab.OrCommonForm.ph_load_yn.value;
	var patient_id				= document.prescription_header_form.patient_id.value;
	var encounter_id			= document.prescription_header_form.encounter_id.value;
	var location_type			= document.prescription_header_form.location_type.value;
	var location_code			= document.prescription_header_form.location_code.value;
	var patient_class			= document.prescription_header_form.patient_class.value;
	var bed_num					= document.prescription_header_form.bed_num.value;
	var room_num				= document.prescription_header_form.room_num.value;
	var height					= document.prescription_header_form.height.value;
	var weight					= document.prescription_header_form.weight.value;
	var licence					= document.prescription_header_form.licence.value;
	var ph_default_tab			= document.prescription_header_form.ph_default_tab.value;
	var bsa						= document.prescription_header_form.bsa.value;
	var order_date_time			= document.prescription_header_form.sys_date.value;
	var facility_id				= document.prescription_header_form.facility_id.value;
	var take_home_medication	= document.prescription_header_form.take_home_medication.value;
	//var weight					= document.prescription_header_form.weight.value;
	var allow_without_wt		= document.prescription_header_form.allow_without_wt.value;
	var allow_without_diag		= document.prescription_header_form.allow_without_diag.value;
	var patient_age				= document.prescription_header_form.patient_age.value;
	var diag_size				= document.prescription_header_form.diag_size.value;	
	var act_patient_class		= document.prescription_header_form.actual_patient_class.value;
	var problem_ind				= document.prescription_header_form.problem_ind.value;
	var attend_pract_id			= document.prescription_header_form.attend_pract_id.value;
	var pract_id				= document.prescription_header_form.pract_id.value;
	var resp_id					= document.prescription_header_form.resp_id.value;
	var priority				= document.prescription_header_form.priority.value;
	var allergic_yn				= document.prescription_header_form.allergic_yn.value;
	var drug_db_duptherapy_yn				= document.prescription_header_form.drug_db_duptherapy_yn.value;
	var drug_db_allergy_check_yn			= document.prescription_header_form.drug_db_allergy_check_yn.value;

	var drug_db_interface_yn	= document.prescription_header_form.drug_db_interface_yn.value;
	var bl_install_yn			= document.prescription_header_form.bl_install_yn.value;
	var bl_disp_charge_dtl_in_rx_yn	= document.prescription_header_form.bl_disp_charge_dtl_in_rx_yn.value;
	var trade_display_yn	= document.prescription_header_form.trade_display_yn.value;
	var bl_disp_charge_dtl_in_drug_lkp_yn		= document.prescription_header_form.disp_charge_dtl_in_drug_lkp_yn.value;
	var disp_price_type_in_drug_lkp		= document.prescription_header_form.disp_price_type_in_drug_lkp.value;
	var adr_count					= document.prescription_header_form.adr_count.value;
	var MItemsOnly					= document.prescription_header_form.MItemsOnly.value;
	var height_uom		= document.prescription_header_form.height_unit.value;
	var weight_uom		= document.prescription_header_form.weight_unit.value;
	var bsa				= document.prescription_header_form.bsa.value;
	var bsa_uom			= getLabel("Common.BSA.label","Common");
	var bmi				= document.prescription_header_form.bmi.value;
	var atc_allergy_alert_level				= document.prescription_header_form.atc_allergy_alert_level.value;
	var MAR_app_yn	= getMAR_app_yn(document.prescription_header_form);
	var home_leave_yn_chk				= document.prescription_header_form.home_leave_yn_chk.value; //added  for Bru-HIMS-CRF-093[29960]
	var Sysdate =document.prescription_header_form.sys_date.value; //added for Bru-HIMS-CRF-093[29960] 
	var pract_type =document.prescription_header_form.pract_type.value; //added for ML-BRU-SCF-0958 [IN:042045]
	var allergy_conf_reqd_yn =document.prescription_header_form.allergy_conf_reqd_yn.value; //added for RUT-CRF-0064.1 [IN:041799]
	var locale =document.prescription_header_form.language_id.value; //added for HSA-CRF-0152 [IN:048469] -start
	var episode_id =document.prescription_header_form.episode_id.value;
	var gender =document.prescription_header_form.gender.value;
	var date_of_birth =document.prescription_header_form.date_of_birth.value;
	var visit_adm_date =document.prescription_header_form.visit_adm_date.value;
	var MAR =document.prescription_header_form.MAR.value;
	var reconciliation_req_yn=document.prescription_header_form.reconciliation_req_yn.value;//ADDED FOR MMS-KH-CRF-0016
	var reconciliation_done_yn=document.prescription_header_form.reconciliation_done_yn.value;//ADDED FOR IN070786
	var episode_type ="";
	if(act_patient_class!='')
		episode_type					= episode_type.substring(0,1); //added for HSA-CRF-0152 [IN:048469] -end

	if(allergy_conf_reqd_yn=='true'){
		if(!getAllergyConf(allergy_conf_reqd_yn))
			return false;
	}
	if(allow_without_wt=="N" && weight=="" && parseInt(patient_age)<=13) {
		alert(getMessage("PAT_WEIGHT_BLANK", "PH"));
		document.prescription_header_form.weight.focus();
		return;
	}
	if(allow_without_diag=="N" && parseInt(diag_size)==0) {
		if(act_patient_class=='XT' || MAR!=""){
			alert(getMessage("PAT_DIAG_REQD", "PH"));
			if(parent.f_header.document.getElementById("medicalItem")!=undefined){ //if block added for AAKH-SCF-0008 [IN:037381]
				medicalItem.className = "CASECONDSELECTHORZ";
				change_tab_buttons("medicalItem");
			}
		}
		else{
			var recrd_diag=confirm(getMessage("PAT_DIAG_REQD_RECORD_DIAG", "PH"));  //added for HSA-CRF-0152 [IN:048469] -start
			if(recrd_diag){
				//callRecordDiagnosis();
				visit_id ="";
				episode_Status="";
				reln_req_yn="Y";
				speciality_code="";
				var dialogHeight= "35vh" ;
				var dialogWidth	= "70vw" ;
				var dialogTop = "169" ;
				var center = "1" ;
				var status="no";
				var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop;
				var arguments	= "" ;
				retVal = await window.showModalDialog("../../eMR/jsp/RecDiagnosis.jsp?option_id=PH_ORDERS&locale="+locale+"&patient_id="+patient_id+"&visit_id="+visit_id+"&episode_id="+episode_id+"&encounter_id="+encounter_id+"&location_code="+location_code+"&location_type="+location_type+"&bed_num="+bed_num+"&room_num="+room_num+"&episode_type="+episode_type+"&discharge_date=&visit_adm_date="+visit_adm_date+"&episode_Status="+episode_Status+"&Sex="+gender+"&Age="+patient_age+"&Dob="+date_of_birth+"&security_level=&protection_ind=&reln_req_yn="+reln_req_yn+"&patient_class="+act_patient_class+"&PQ=Y&CA=Y&from_service_yn=&accession_number=&accession_type=&mode=R&RelnYn=&RelnReqYn=&speciality_code="+speciality_code+"&ConsOrdChartYn=N&patChartCalledFrm=&P_MODULE_ID=CA&P_FUNCTION_ID=CLINICIAN_ACCESS&P_RESP_ID="+resp_id+"&window_name="+patient_id+encounter_id+"&child_window=Y&limit_function_id=&chartTitle=&relationship_id=CHEIF&module_id=&function_id=&reln_req_yn=Y&fromNewFunction=Y&Patient_ID="+patient_id+"&title=Record Chief Complaints&p_called_from_widget=PH",arguments,features);
				checkDiagnosis();
			}
		}  //added for HSA-CRF-0152 [IN:048469] -end
		return false; //Added for AAKH-SCF-0008 [IN:037381]
	}
/*	//added for mms-kh-crf-0016
	if(reconciliation_req_yn=="Y"){
		var reconciliation=confirm(getMessage("PH_MEDICATION_RECONCILIATION_ALERT", "PH"));
		if(reconciliation){
				medicationReconciliation();
		}
		
	}
	//added for mms-kh-crf-0016 -- commented for Inc # 70594 */
	var priority				=	"";
	if(ph_load_yn=="N"){
		var priority   =  document.prescription_header_form.priority.value;
		//commented for enhancement FS Ref 3.36
		/*if(document.prescription_header_form.priority.disabled==false){
			document.prescription_header_form.priority.value="R";
			allow_detail=true;
		}
		else{*/
			allow_detail=true;
		//}
		if(allow_detail){
			if(document.prescription_header_form.sys_date.disabled==false){
				allow_detail=true;
			}
			else{
				allow_detail=true;
			}
		}
	}
	else{
		allow_detail=true;
		order_date_time	= parent.parent.parent.parent.parent.orderMainTab.OrCommonForm.ph_order_date_time.value;
		priority   =  parent.parent.parent.parent.parent.orderMainTab.OrCommonForm.ph_priority.value;
		document.prescription_header_form.sys_date.disabled=true;
		//commented for enhancement FS Ref 3.36
		//document.prescription_header_form.priority.disabled=true;
	}

	if(allow_detail){
		if(iv_prep_default == "1" || iv_prep_default == "2" || iv_prep_default == "3" || iv_prep_default == "4" || iv_prep_default == "5" ){
			parent.PrescriptionDetailFrameSet.removeAttribute("cols");
			parent.PrescriptionDetailFrameSet.setAttribute("rows");
			parent.PrescriptionDetailFrameSet.rows="100%,0%";
			parent.f_prescription.classValue="IV";
			ivrx.className = "CASECONDSELECTHORZ";
			nonivrx.className = "CAFIRSTSELECTHORZ";
			parent.f_prescription.location.href="../../ePH/jsp/IVPrescription.jsp?act_patient_class="+act_patient_class+"&patient_id="+patient_id+"&encounter_id="+encounter_id+"&patient_class="+patient_class+"&mode="+mode+"&start_date="+order_date_time+"&iv_prep_default="+iv_prep_default+"&order_set_code="+order_set_code+"&bed_num="+bed_num+"&room_num="+room_num+"&take_home_medication="+take_home_medication+"&atc_allergy_alert_level="+atc_allergy_alert_level;
		}
		else if(iv_prep_default == "7" || iv_prep_default == "8" ){
			if(height!="" && weight!=""){
				parent.PrescriptionDetailFrameSet.removeAttribute("cols");
				parent.PrescriptionDetailFrameSet.setAttribute("rows");
				parent.PrescriptionDetailFrameSet.rows="100%,0%";
				parent.f_prescription.classValue="IV";
				parent.f_prescription.location.href="../../ePH/jsp/TPNRegimen.jsp?priority="+priority+"&location_code="+location_code+"&location_type="+location_type+"&pract_id="+pract_id+"&act_patient_class="+act_patient_class+"&patient_id="+patient_id+"&encounter_id="+encounter_id+"&patient_class="+patient_class+"&mode="+mode+"&start_date="+order_date_time+"&problem_ind="+problem_ind+"&height="+height+"&weight="+weight+"&iv_prep_default="+iv_prep_default+"&order_set_code="+order_set_code+"&bed_num="+bed_num+"&room_num="+room_num+"&take_home_medication="+take_home_medication+"&atc_allergy_alert_level="+atc_allergy_alert_level;
			}
			else{
				alert(getMessage("PH_WEIGHT_REQUIRED", "PH"));
				parent.f_prescription.location.href="../../eCommon/html/blank.html";
				parent.f_detail.location.href="../../eCommon/html/blank.html";
				parent.f_button.location.href="../../eCommon/html/blank.html";
			}
		}
		else if(iv_prep_default == "9" || iv_prep_default == "0" ||iv_prep_default == "C" ){
			ivrx.className = "CAFIRSTSELECTHORZ";
			nonivrx.className = "CAFIRSTSELECTHORZ";
			var priority_header   =  document.prescription_header_form.priority.value;  // Added to get Build MAR default value
			if(parent.f_header.document.getElementById("oncology_regimen")!=undefined){
				oncology_regimen.className = "CASECONDSELECTHORZ";
				if(height!="" && weight!=""){
					parent.PrescriptionDetailFrameSet.removeAttribute("cols");
					parent.PrescriptionDetailFrameSet.setAttribute("rows");
					parent.PrescriptionDetailFrameSet.rows="100%,0%";
					parent.f_prescription.classValue="IV";
					parent.f_prescription.location.href="../../ePH/jsp/OncologyRegimen.jsp?act_patient_class="+act_patient_class+"&patient_id="+patient_id+"&encounter_id="+encounter_id+"&patient_class="+patient_class+"&mode="+mode+"&start_date="+order_date_time+"&problem_ind="+problem_ind+"&iv_prep_default="+iv_prep_default+"&order_set_code="+order_set_code+"&bed_num="+bed_num+"&room_num="+room_num+"&take_home_medication="+take_home_medication+"&clearOrNot=Y"+"&priority_header="+priority_header+"&atc_allergy_alert_level="+atc_allergy_alert_level;  // priority_header added to get Build MAR Default value
				}
				else{
					alert(getMessage("PH_WEIGHT_REQUIRED", "PH"));
					parent.f_prescription.location.href="../../eCommon/html/blank.html";
					parent.f_detail.location.href="../../eCommon/html/blank.html";
					parent.f_button.location.href="../../eCommon/html/blank.html";
				}
			}
			else{
				alert(getMessage("ONCO_NOT_APP_FOR_MED_SER", "PH"));
					 
			}
		}
		else if(ph_default_tab=="R" || ph_default_tab==null || ph_default_tab=="") {
			if(MItemsOnly=='true'){
				medicalItem.className = "CASECONDSELECTHORZ";
				nonivrx.className = "CAFIRSTSELECTHORZ";
				//parent.PrescriptionDetailFrameSet.removeAttribute("cols");
				//parent.PrescriptionDetailFrameSet.setAttribute("rows");
				//parent.PrescriptionDetailFrameSet.rows="100%,0%";
				parent.PrescriptionDetailFrameSet.style.display="none";
				
				parent.document.getElementById("f_prescription").style.width="99vw";
				parent.f_prescription.classValue="IV";
				parent.f_prescription.location.href="../../ePH/jsp/ConsumableOrder.jsp?priority="+priority+"&location_code="+location_code+"&location_type="+location_type+"&pract_id="+pract_id+"&resp_id="+resp_id+"&act_patient_class="+act_patient_class+"&patient_id="+patient_id+"&encounter_id="+encounter_id+"&patient_class="+patient_class+"&mode="+mode+"&order_date_time="+order_date_time+"&height="+height+"&weight="+weight+"&take_home_medication="+take_home_medication+"&bl_install_yn="+bl_install_yn+"&bl_disp_charge_dtl_in_rx_yn="+bl_disp_charge_dtl_in_rx_yn+"&bl_disp_charge_dtl_in_drug_lkp_yn="+bl_disp_charge_dtl_in_drug_lkp_yn+"&bl_disp_price_type_in_drug_lkp="+disp_price_type_in_drug_lkp+"&height_unit="+height_uom+"&weight_unit="+weight_uom+"&bsa="+bsa+"&bsa_unit="+bsa_uom+"&bmi="+bmi+"&facility_id="+facility_id+"&bed_num="+bed_num+"&room_num="+room_num+"&call_mode=new"+"&called_from=ORDERSET";
			}
			else{
				var fldString="  patient_class=\""+ patient_class + "\" ";
				fldString += " facility_id=\""+ facility_id + "\" ";
				fldString += " patient_id=\""+ patient_id + "\" ";
				fldString += " encounter_id=\""+ encounter_id + "\" ";
				fldString += " priority=\""+ priority + "\" ";
				fldString += " locn_type=\""+ location_type + "\" ";
				fldString += " locn_code=\""+ location_code + "\" ";
				fldString += " sys_date=\""+ order_date_time + "\" ";
				fldString += " take_home_medication=\""+ take_home_medication + "\" ";
				fldString += " licence=\""+ licence + "\" ";
				fldString += " order_set_code=\""+ order_set_code + "\" ";
				fldString += " drug_db_interface_yn=\""+ drug_db_interface_yn + "\" ";
				fldString += " act_patient_class=\""+ act_patient_class + "\" ";
				fldString += " pract_id=\""+ pract_id + "\" ";
				fldString += " resp_id=\""+ resp_id + "\" ";
				fldString += " home_leave_yn_val=\""+ home_leave_yn_chk + "\" "; //added  for Bru-HIMS-CRF-093[29960] 
				fldString += " pract_type=\""+ pract_type + "\" "; //added   ML-BRU-SCF-0958 [IN:042045]

				var formobj=document.prescription_header_form;
				var xmlStr=formXMLString(formobj,fldString);

				fieldValidation(xmlStr,"loadDrugDetails");

				var weight = document.prescription_header_form.weight.value
				var bsa = document.prescription_header_form.bsa.value

				parent.parent.parent.parent.parent.orderMainTab.OrCommonForm.ph_order_date_time.value=order_date_time;
				parent.parent.parent.parent.parent.orderMainTab.OrCommonForm.ph_priority.value=priority;
				parent.f_prescription.location.href="../../ePH/jsp/PrescriptionFormFrame.jsp?patient_id="+patient_id+"&encounter_id="+encounter_id+"&patient_class="+patient_class+"&allow_without_diag="+allow_without_diag+"&bed_num="+bed_num+"&room_num="+room_num+"&weight="+weight+"&bsa="+bsa+"&drug_db_interface_yn="+drug_db_interface_yn+"&bl_install_yn="+bl_install_yn+"&bl_disp_charge_dtl_in_rx_yn="+bl_disp_charge_dtl_in_rx_yn+"&MAR_app_yn="+MAR_app_yn+"&adr_count="+adr_count+"&act_patient_class="+act_patient_class+"&take_home_medication="+take_home_medication+"&order_set_code="+order_set_code+"&drug_db_duptherapy_yn="+drug_db_duptherapy_yn+"&drug_db_allergy_check_yn="+drug_db_allergy_check_yn+"&drug_db_interface_yn="+drug_db_interface_yn;
				var mode="blank";
				parent.f_detail.location.href="../../ePH/jsp/PrescriptionDetail_1.jsp?patient_id="+patient_id+"&encounter_id="+encounter_id+"&patient_class="+patient_class+"&mode="+mode+"&start_date="+order_date_time+"&allow_without_diag="+allow_without_diag+"&allergic_yn="+allergic_yn+"&order_set_code="+order_set_code+"&bed_num="+bed_num+"&room_num="+room_num+"&drug_db_interface_yn="+drug_db_interface_yn+"&bl_install_yn="+bl_install_yn+"&bl_disp_charge_dtl_in_rx_yn="+bl_disp_charge_dtl_in_rx_yn+"&MAR_app_yn="+MAR_app_yn+"&act_patient_class="+act_patient_class+"&take_home_medication="+take_home_medication+"&trade_display_yn="+trade_display_yn+"&drug_db_duptherapy_yn="+drug_db_duptherapy_yn+"&drug_db_allergy_check_yn="+drug_db_allergy_check_yn+"&drug_db_interface_yn="+drug_db_interface_yn+"&pract_id="+pract_id;//pract_id addded for MMOH-CRF-01823
				parent.f_button.location.href="../../ePH/jsp/PrescriptionButton_1.jsp?patient_id="+patient_id+"&mode="+mode+"&encounter_id="+encounter_id+"&patient_class="+patient_class+"&bed_num="+bed_num+"&room_num="+room_num+"&take_home_medication="+take_home_medication;
				if(top.content != null)
					top.content.messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num=";

				/* comment removed to open up the allow without diagnosis check*/
				if((allow_without_diag=='Y') ||(allow_without_diag=='N' && parseInt(diag_size)!=0)  ){			
					//if(allergic_yn=='N'){
						if( parent.f_header.document.getElementById("nonivrx")!=undefined)
							 parent.f_header.document.getElementById("nonivrx").style.visibility='visible';
						if( parent.f_header.document.getElementById("ivrx")!=undefined)
							 parent.f_header.document.getElementById("ivrx").style.visibility='visible';
						if( parent.f_header.document.getElementById("oncology_regimen")!=undefined)
							 parent.f_header.document.getElementById("oncology_regimen").style.visibility='visible';
						if( parent.f_header.document.getElementById("tpn_regimen")!=undefined)
							 parent.f_header.document.getElementById("tpn_regimen").style.visibility='visible';
						if( parent.f_header.document.getElementById("comprx")!=undefined)
							 parent.f_header.document.getElementById("comprx").style.visibility='visible';
						if( parent.f_header.document.getElementById("tdm")!=undefined)
							 parent.f_header.document.getElementById("tdm").style.visibility='visible';
						if( parent.f_header.document.getElementById("medicalItem")!=undefined)
							 parent.f_header.document.getElementById("medicalItem").style.visibility='visible';					
						parent.f_button.location.href="../../ePH/jsp/PrescriptionButton_1.jsp?patient_id="+patient_id+"&mode="+mode+"&encounter_id="+encounter_id+"&patient_class="+patient_class+"&bed_num="+bed_num+"&room_num="+room_num+"&take_home_medication="+take_home_medication;
					/*}
					else{ 
						if( parent.f_header.document.getElementById("nonivrx")!=undefined)
							 parent.f_header.document.getElementById("nonivrx").style.visibility='hidden';
						if( parent.f_header.document.getElementById("ivrx")!=undefined)
							 parent.f_header.document.getElementById("ivrx").style.visibility='hidden';
						if( parent.f_header.document.getElementById("oncology_regimen")!=undefined)
							 parent.f_header.document.getElementById("oncology_regimen").style.visibility='hidden';
						if( parent.f_header.document.getElementById("tpn_regimen")!=undefined)
							 parent.f_header.document.getElementById("tpn_regimen").style.visibility='hidden';
						if( parent.f_header.document.getElementById("comprx")!=undefined)
							 parent.f_header.document.getElementById("comprx").style.visibility='hidden';
						if( parent.f_header.document.getElementById("tdm")!=undefined)
							 parent.f_header.document.getElementById("tdm").style.visibility='hidden';
						if( parent.f_header.document.getElementById("medicalItem")!=undefined)
							 parent.f_header.document.getElementById("medicalItem").style.visibility='hidden';

					   parent.f_button.location.href= "../../eCommon/html/blank.html";
					   parent.f_prescription.location.href= "../../eCommon/html/blank.html";
					   parent.f_detail.location.href= "../../eCommon/html/blank.html";
					
						var order_set_code =document.prescription_header_form.order_set_code.value;
						var fldString=" patient_id=\""+ patient_id + "\" ";
						fldString+=" encounter_id=\""+ encounter_id + "\" ";
						fldString+="order_set_code=\""+ order_set_code + "\" ";
						fldString+="allergic_yn=\""+ allergic_yn + "\" ";				
						var formobj=document.prescription_header_form;
						var xmlStr=formXMLString(formobj,fldString);
						var source="clearData";
						var xmlDoc = "" ;
						var xmlHttp = new XMLHttpRequest() ;
						xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
						xmlHttp.open("POST","PrescriptionValidation_1.jsp?func_mode="+source,false);
						xmlHttp.send(xmlDoc);
						responseText=xmlHttp.responseText ;
					}*/
				}	/* comment removed to open up the allow without diagnosis check*/
			}
		}
	}
	checkHomeLeave(); //added  for Bru-HIMS-CRF-093[29960]
	//added for Inc # 70594
	if(reconciliation_req_yn=="Y" && reconciliation_done_yn!="Y"){//&& reconciliation_done_yn added for IN070786
		 alert(getMessage("PH_MEDICATION_RECONCILIATION_ALERT", "PH")); //ADDED FOR IN070786
		//var reconciliation=confirm(getMessage("PH_MEDICATION_RECONCILIATION_ALERT", "PH"));//removed for MMS-KH-CRF-0016.1
		//if(reconciliation){//removed for IN070786
				medicationReconciliation();
		//}//removed for IN070786
		
	}
	//added for Inc # 70594
}

function changeButtonColor(obj,from_name){

	if(from_name=="PH_BUTTONS"){
		cellref = parent.f_header.document.getElementById("tab").rows[0].cells
		version_no = parent.f_header.document.prescription_header_form.version_no.value;
	}
	else if(from_name=="COMMON")
		cellref = document.getElementById("tab").rows[0].cells
	if(version_no==3) check_val = 7; else check_val = 2;
	for(i=0; i<cellref.length; i++){
		if(i!=check_val && i!=(check_val+1)){
			if(cellref[i].id!="dummy")
				cellref[i].className = 'CAFIRSTSELECTHORZ'
		}
	}
	obj.className = "CASECONDSELECTHORZ"
	currClass ="CASECONDSELECTHORZ";
}

function changeCol(obj){
	obj.className="FOCUSDRUGS";
}

function changeBorder(obj){
	obj.className="CLICKDRUGS";
}

function realCol(obj,classVal){
	obj.className=classVal;
}

//call the detail page for modify/taper mode
function defaultDrug(drug_code,mode,srl_no,sliding_scale_yn,recomm_yn,order_idC,modeC,parent_stat_yn,stat_yn){  //AAKH-CRF-0091

	if(srl_no!=null && srl_no!=""){//added for Bru-HIMS-CRF-079 IN[029945] -start
		var recomm_yn_flag = eval("document.prescription_form.recomm_yn_flag_"+srl_no).value; 
		var validHgtWgt = recommendDosage(drug_code,mode,srl_no,order_idC,modeC, 'defaultDrug');
		if(recomm_yn_flag=='true' && validHgtWgt==false){
			return false;
		}
	}//added for Bru-HIMS-CRF-079 IN[029945] -end
	var start_dt		 =	eval("document.prescription_form.dt"+srl_no+".value");
	if(start_dt !=undefined && start_dt!=null && start_dt !="")
		start_date	=	start_dt;
	else
		start_date=parent.parent.f_header.document.prescription_header_form.sys_date.value;
	
	var priority=parent.parent.f_header.document.prescription_header_form.priority.value;
	
	var patient_id		= parent.parent.f_header.document.prescription_header_form.patient_id.value;
	var encounter_id	= parent.parent.f_header.document.prescription_header_form.encounter_id.value;
	var bed_num		= parent.parent.f_header.document.prescription_header_form.bed_num.value;
	var room_num	= parent.parent.f_header.document.prescription_header_form.room_num.value;
	var patient_class	= parent.parent.f_header.document.prescription_header_form.patient_class.value;
	var bsa				= parent.parent.f_header.document.prescription_header_form.bsa.value;
	var drug_db_interface_yn            = parent.parent.f_header.document.prescription_header_form.drug_db_interface_yn.value;
	var drug_db_allergy_check_yn            = parent.parent.f_header.document.prescription_header_form.drug_db_allergy_check_yn.value;
	var drug_db_duptherapy_yn            = parent.parent.f_header.document.prescription_header_form.drug_db_duptherapy_yn.value;
	var bl_install_yn            = parent.parent.f_header.document.prescription_header_form.bl_install_yn.value;
	var bl_install_yn			= parent.parent.f_header.document.prescription_header_form.bl_install_yn.value;
	var bl_disp_charge_dtl_in_rx_yn	= parent.parent.f_header.document.prescription_header_form.bl_disp_charge_dtl_in_rx_yn.value;
	var take_home_medication	= parent.parent.f_header.document.prescription_header_form.take_home_medication.value;
	var MAR_app_yn	= getMAR_app_yn(parent.parent.f_header.document.prescription_header_form);
	var trade_display_yn	= parent.parent.f_header.document.prescription_header_form.trade_display_yn.value;
	var alternateOrder	=	parent.parent.f_header.document.prescription_header_form.alternateOrder.value;//added for  JD-CRF-0198 [IN:058599]
	var pract_id				= parent.parent.f_header.document.prescription_header_form.pract_id.value;//Added for ML-MMOH-CRF-01823
	var drugDtlFormObj = parent.parent.f_detail.document.prescription_detail_form;//Added for  RUT-SCF-0321 [IN044816]
	parent.parent.f_header.document.prescription_header_form.sliding_scale.value=sliding_scale_yn;
	if(sliding_scale_yn=="Y" && (recomm_yn == '' || recomm_yn == 'N') ){
		parent.parent.f_detail.location.href="../../ePH/jsp/PrescriptionSlidingScaleFrame.jsp?srl_no="+srl_no+"&drug_code="+drug_code+"&priority="+priority+"&start_date="+start_date+"&mode="+mode+"&patient_id="+patient_id+"&encounter_id="+encounter_id+"&patient_class="+patient_class+"&bsa="+bsa+"&bed_num="+bed_num+"&room_num="+room_num+"&drug_db_interface_yn="+drug_db_interface_yn+"&bl_install_yn="+bl_install_yn+"&bl_disp_charge_dtl_in_rx_yn="+bl_disp_charge_dtl_in_rx_yn+"&MAR_app_yn="+MAR_app_yn+"&take_home_medication="+take_home_medication+"&order_idC="+order_idC+"&modeC="+modeC+"&trade_display_yn="+trade_display_yn+"&drug_db_allergy_check_yn="+drug_db_allergy_check_yn+"&drug_db_duptherapy_yn="+drug_db_duptherapy_yn;
		parent.parent.f_button.location.href="../../ePH/jsp/PrescriptionButton_1.jsp?patient_id="+patient_id+"&mode="+mode+"&encounter_id="+encounter_id+"&sliding_scale_yn="+sliding_scale_yn+"&bed_num="+bed_num+"&room_num="+room_num+"&drug_db_interface_yn="+drug_db_interface_yn+"&take_home_medication="+take_home_medication+"&parent_stat_yn="+parent_stat_yn+"&stat_yn="+stat_yn;   //AAKH-CRF-0091
	}
	else{
		if(mode == 'taper'){
			amend_yn = eval("document.prescription_form.amend_yn_"+srl_no).value;
			var order_qty = parseInt(eval("document.prescription_form.order_qty"+srl_no).value);  //Added for RUT-CRF-0088 [IN036978]
			var dosage_type = parent.parent.f_header.document.prescription_header_form.bean_name.value;
			var loaded_drug_code=""; //Added for  [IN:043763] User can able to do Taper without changing the Dosage and frequency.  -Start
			var loaded_srl_no="";
			var drugDtlFormObj = parent.parent.f_detail.document.prescription_detail_form;
			if(drugDtlFormObj.drug_code.value !=""){
				loaded_drug_code = drugDtlFormObj.drug_code.value;
				loaded_srl_no = drugDtlFormObj.srl_no.value;
			} //Added for  [IN:043763] -end
			if(amend_yn=='N' || ( drug_code==loaded_drug_code && srl_no==loaded_srl_no)){ 
				alert(getMessage("PH_CONFIRM_MAIN_DRUG","PH"));
				return false;
			}
			var xmlDoc="";
			var xmlHttp = new XMLHttpRequest();
			xmlStr	="<root><SEARCH " ;
			xmlStr += "patient_id=\""+patient_id +"\" " ;
			xmlStr += "encounter_id=\""+ encounter_id +"\" " ;
			xmlStr += "drug_code=\""+ drug_code +"\" " ;
			xmlStr += "srl_no=\""+ srl_no +"\" " ;
			xmlStr += "order_qty=\""+ order_qty +"\" " ;  //Added for RUT-CRF-0088 [IN036978]
			xmlStr += "dosage_type=\""+ dosage_type +"\" " ; //Added for RUT-CRF-0088 [IN036978]
			xmlStr += "drug_db_interface_yn=\""+ drug_db_interface_yn +"\" " ;
			xmlStr += "bean_id=\""+ parent.parent.f_header.document.prescription_header_form.bean_id.value +"\" " ;
			xmlStr += "bean_name=\""+ parent.parent.f_header.document.prescription_header_form.bean_name.value +"\" " ;
			xmlStr +=" /></root>" ;
			xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
			xmlHttp.open( "POST", "PrescriptionValidation_1.jsp?func_mode=addTaperDrugDetails", false ) ;
			xmlHttp.send( xmlDoc ) ;	
			eval(xmlHttp.responseText);	
			loadDetailForm();
			//	srl_no = parseInt(srl_no)+1; // commented for IN19397 -- priya -- 26/02/2010
		}
		parent.parent.f_detail.location.href="../../ePH/jsp/PrescriptionDetail_1.jsp?srl_no="+srl_no+"&drug_code="+drug_code+"&priority="+priority+"&start_date="+start_date+"&mode="+mode+"&patient_id="+patient_id+"&encounter_id="+encounter_id+"&patient_class="+patient_class+"&bsa="+bsa+"&bed_num="+bed_num+"&room_num="+room_num+"&drug_db_interface_yn="+drug_db_interface_yn+"&bl_install_yn="+bl_install_yn+"&bl_disp_charge_dtl_in_rx_yn="+bl_disp_charge_dtl_in_rx_yn+"&MAR_app_yn="+MAR_app_yn+"&take_home_medication="+take_home_medication+"&order_idC="+order_idC+"&modeC="+modeC+"&trade_display_yn="+trade_display_yn+"&drug_db_allergy_check_yn="+drug_db_allergy_check_yn+"&drug_db_duptherapy_yn="+drug_db_duptherapy_yn+"&alternateOrder="+alternateOrder+"&pract_id="+pract_id;//added for  JD-CRF-0198 [IN:058599]//pract_id added for ML-MMOH-CRF-01823
		parent.parent.f_button.location.href="../../ePH/jsp/PrescriptionButton_1.jsp?patient_id="+patient_id+"&mode="+mode+"&encounter_id="+encounter_id+"&sliding_scale_yn="+sliding_scale_yn+"&bed_num="+bed_num+"&room_num="+room_num+"&drug_db_interface_yn="+drug_db_interface_yn+"&take_home_medication="+take_home_medication+"&parent_stat_yn="+parent_stat_yn+"&stat_yn="+stat_yn;   //AAKH-CRF-0091
	}
}

function noDrugforRelease(){
	var patient_id=parent.parent.f_detail.document.prescription_detail_form.patient_id.value;
	var encounter_id=parent.parent.f_detail.document.prescription_detail_form.encounter_id.value;
	var patient_class=parent.parent.f_header.document.prescription_header_form.patient_class.value;
	var locn_code=parent.parent.f_header.document.prescription_header_form.source_code.value;

	var print_yn="N";

	var fldString=" patient_id=\""+ patient_id + "\" ";
	fldString+=" encounter_id=\""+ encounter_id + "\" ";
	fldString+=" print_yn=\""+ print_yn + "\" ";
	fldString+=" patient_class=\""+ patient_class + "\" ";
	fldString+=" locn_code=\""+ locn_code + "\" ";

	var formobj=parent.parent.f_detail.document.prescription_detail_form;
	var xmlStr=formXMLString(formobj,fldString);
	var source="onLinePrinting";
	var xmlDoc = "" ;
    var xmlHttp = new XMLHttpRequest() ;
    xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
    xmlHttp.open("POST","PrescriptionValidation_1.jsp?func_mode="+source,false);
    xmlHttp.send(xmlDoc);
    responseText=xmlHttp.responseText ;
	eval(responseText);
    return true;
}

function alertNoAvailStock(available_stock,uom){
	alert(getMessage("PH_NO_STOCK_AVAIL_DRUG", "PH"));
	return_val=false;
}

function disasbleToolTipDataChange(){
    document.getElementById("tooltiplayer").style.visibility = "hidden" ;
}

function displayToolTipDataChange(text){
    buildTableDataChange(text);
    bodwidth  = parent.parent.frames[1].document.body.offsetWidth
    bodheight = parent.parent.frames[1].document.body.offsetHeight
	var x     = event.clientX; //changed event.x to event.clientX for SKR-SCF-1262
	var y     = event.clientY; //changed event.y to event.clientY for SKR-SCF-1262
    x     = x + (document.getElementById("tooltiplayer").offsetWidth)
    y     = y + (document.getElementById("tooltiplayer").offsetHeight)
    if(x<bodwidth)
       x = event.clientX //changed event.x to event.clientX for SKR-SCF-1262
    else
        x = x - (document.getElementById("tooltiplayer").offsetWidth*2)

    if(y<bodheight)
		y = event.clientY //changed event.y to event.clientY for SKR-SCF-1262
    else
        y = y - (document.getElementById("tooltiplayer").offsetHeight*2)
    y+=document.body.scrollTop
    x+=document.body.scrollLeft

	if(document.prescription_detail_form.sliding_scale_yn.value =='Y'){
          document.getElementById("tooltiplayer").style.posLeft= x+100;
	}else{
         document.getElementById("tooltiplayer").style.posLeft= x-60;
	}

	if(x > 600 )
		document.getElementById("tooltiplayer").style.posTop = y+15;
	else{
	   
		if(document.prescription_detail_form.sliding_scale_yn.value =='Y'){
             document.getElementById("tooltiplayer").style.posTop = y-5;
		}else{
			 document.getElementById("tooltiplayer").style.posTop = y-45;
		}
	}
    document.getElementById("tooltiplayer").style.visibility='visible';
}

function buildTableDataChange(text){
	var tab_dat  = text ;
	document.getElementById("t").innerHTML = tab_dat;
}

function searchDrugName(){
	var allow_detail=true;
	if(parent.f_header.document.prescription_header_form.order_type.value!="NO"){
		var ext_order_type=parent.f_header.document.prescription_header_form.order_type.value;
		if(ext_order_type=="") 
			ext_order_type="null";

		if(parent.f_header.document.prescription_header_form.order_type.disabled==false){

			if(parent.f_header.document.prescription_header_form.order_type.value==""){
				alert(getMessage("PH_ORDTYPE_CONFORM", "PH"));
				allow_detail=false;
				parent.f_header.document.prescription_header_form.order_type.focus();
			}
		}
		else{
			allow_detail=true;
		}
	}
	if(allow_detail){
		var order_type_code =parent.f_header.document.prescription_header_form.order_type.value;
		var source_code	    = parent.f_header.document.prescription_header_form.source_code.value;   
		var fldString=" order_type_code=\""+ order_type_code + "\" ";
		var formobj=parent.f_header.document.prescription_header_form; 
		var xmlStr=formXMLString(formobj,fldString);
		fieldValidation(xmlStr,"callSearch");
	}//allow
}

async function drugSearch(drugCode){
	var service_search_yn	=parent.f_header.document.prescription_header_form.service_search_yn.value;
	var servide_code	=parent.f_header.document.prescription_header_form.servide_code.value;
	var pat_id		  = parent.f_header.document.prescription_header_form.patient_id.value;
	var encounter_id		  = parent.f_header.document.prescription_header_form.encounter_id.value;
	var discharge_yn  = parent.f_header.document.prescription_header_form.take_home_medication.value;
	var alternateOrder = parent.f_header.document.prescription_header_form.alternateOrder.value;//added for  JD-CRF-0198 [IN:058599]
	if(discharge_yn=='Y')
		var patient_class = parent.f_header.document.prescription_header_form.patient_class.value;
	else
		var patient_class = parent.f_header.document.prescription_header_form.actual_patient_class.value;
	//var act_patient_class = parent.f_header.document.prescription_header_form.actual_patient_class.value;

	var priority	    = parent.f_header.document.prescription_header_form.priority.value;
	var source_code	    = parent.f_header.document.prescription_header_form.source_code.value;
	var source_type	    = parent.f_header.document.prescription_header_form.source_type.value;
	var date_of_birth	= parent.f_header.document.prescription_header_form.date_of_birth.value;
	var gender			= parent.f_header.document.prescription_header_form.gender.value;
	var home_leave_yn_chk= parent.f_header.document.prescription_header_form.home_leave_yn_chk.value;//added for Bru-HIMS-CRF-093[29960] -->
	var bean_id="@DrugSearchBean"+pat_id+encounter_id;
	if(parent.f_header.document.prescription_header_form.order_type.value!="NO"){
		var order_type_code=parent.f_header.document.prescription_header_form.order_type.value;
	}
	else{
		var order_type_code="";
	}
	retVal =  await DrugSearchForPres("D",document.prescription_detail_form.drug_name,order_type_code,drugCode,bean_id,service_search_yn,servide_code, patient_class,priority,discharge_yn,pat_id,encounter_id,date_of_birth,gender,source_type,source_code,"","","","",home_leave_yn_chk,alternateOrder,"Y");//added home_leave_yn_chk for Bru-HIMS-CRF-093[29960] -->//added alternateOrder for  JD-CRF-0198 [IN:058599] and 'Y' added for GHL-CRF-0549
/*	if(parent.f_header.document.prescription_header_form.take_home_medication_op_chk!=undefined)
		parent.f_header.document.prescription_header_form.take_home_medication_op_chk.disabled=true;//commented for NMC-JD-CRF-0063*/
	//added for NMC-JD-CRF-0063
	if(parent.f_header.document.prescription_header_form.take_home_medication_op_chk!=undefined){
		if(retVal.length==0 || retVal==""){
			if(parent.f_header.document.prescription_header_form.take_home_medication_op_chk.disabled==false){
				parent.f_header.document.prescription_header_form.take_home_medication_op_chk.disabled=false;
			}
		}
		else{
				parent.f_header.document.prescription_header_form.take_home_medication_op_chk.disabled=true;
		}
	}//END
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
	loadDrugDetails(Drug_Codes,Trade_Codes,Trade_Names); //converted to function call for PMG2012-CRF-0019 [IN:035859] AutoComplete
}

function updateOROrderType(order_type){
	var patient_id		= parent.f_header.document.prescription_header_form.patient_id.value;
	var encounter_id	=  parent.f_header.document.prescription_header_form.encounter_id.value;
	if(order_type!="NO" && order_type!="" ){

		var fldString=" patient_id=\""+ patient_id + "\" ";
		fldString+=" encounter_id=\""+ encounter_id + "\" ";
		fldString+=" order_type=\""+ order_type + "\" ";
		var formobj=parent.f_header.document.prescription_header_form;
		var xmlStr=formXMLString(formobj,fldString);
		fieldValidation(xmlStr,"updateOROrderType");
	}
}

function updateOROrderCatalog(retVal){
	
	var patient_id		= parent.f_header.document.prescription_header_form.patient_id.value;
	var encounter_id	=  parent.f_header.document.prescription_header_form.encounter_id.value;
	for(i=0;i<=retVal.length-1;i++){ //loop condition changed to <= from < for IN23402 reopen --06/08/2010-- priya
		drug_code=trimString(retVal[i]);
		var or_bean_id="@orderentrybean"+patient_id+encounter_id;
		var or_bean_name="eOR.OrderEntryBean";
		var mode="";
		var chk_value="Y";
		var item_code="";
		var order_catagory="PH";
		setCatalogCode("ck"+drug_code,parent.parent.parent.tabFrame,"PH");

		if(parent.parent.parent.tabFrame!=null)
			check_box_value=parent.parent.parent.tabFrame.check_box_val;

		var xmlStr ="<root><SEARCH ";
		xmlStr += " mode=\""+ mode + "\" ";
		xmlStr += " ck"+drug_code+"=\""+ chk_value + "\" ";
		xmlStr += " h1"+drug_code+"=\""+ order_catagory + "\" ";
		xmlStr += " h2"+drug_code+"=\""+ item_code + "\" ";
		xmlStr +=" /></root>";
		var xmlDoc = "" ;
		var xmlHttp = new XMLHttpRequest() ;

		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open("POST","../../eOR/jsp/OrderEntryStoreValues.jsp?bean_id=" + or_bean_id + "&check_box_value="+check_box_value+"&bean_name="+ or_bean_name,false);
		xmlHttp.send(xmlDoc);
		responseText=xmlHttp.responseText ;
		eval(responseText);
	}
}

function deleteOROrderCatalog(drug_code, called_from){
	if(called_from == "BLERROR"){
		var tabFrameObj = parent.parent.parent.parent.tabFrame;
		var patient_id		= parent.parent.f_header.document.prescription_header_form.patient_id.value;
		var encounter_id	=  parent.parent.f_header.document.prescription_header_form.encounter_id.value;
	}
	else{
		try{
			var patient_id		= parent.f_header.document.prescription_header_form.patient_id.value;
			var encounter_id	=  parent.f_header.document.prescription_header_form.encounter_id.value;
			var tabFrameObj= parent.parent.parent.tabFrame;
		}
		catch(e){//Sliding scale
			var tabFrameObj= parent.parent.parent.parent.tabFrame;
			var patient_id		= parent.parent.f_header.document.prescription_header_form.patient_id.value;
			var encounter_id	=  parent.parent.f_header.document.prescription_header_form.encounter_id.value;
		}
	}
	var or_bean_id="@orderentrybean"+patient_id+encounter_id;
	var or_bean_name="eOR.OrderEntryBean";
	var mode="";
	var chk_value="N";
	var item_code="";
	var order_catagory="PH";
//	alert(parent.parent.f_header);
if(parent.parent.f_header!=undefined)//Adding start for ML-MMOH-CRF-01823
    parent.parent.parent.deleteCatalogCode("ck"+drug_code,parent.parent.parent.parent.tabFrame,"PH");
else
	deleteCatalogCode("ck"+drug_code,tabFrameObj,"PH");

	if(tabFrameObj!=null)
		check_box_value=tabFrameObj.check_box_val;

	var xmlStr ="<root><SEARCH ";
	xmlStr += " mode=\""+ mode + "\" ";
	xmlStr += " ck"+drug_code+"=\""+ chk_value + "\" ";
	xmlStr += " h1"+drug_code+"=\""+ order_catagory + "\" ";
	xmlStr += " h2"+drug_code+"=\""+ item_code + "\" ";
	xmlStr +=" /></root>";
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest() ;
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST","../../eOR/jsp/OrderEntryStoreValues.jsp?bean_id=" + or_bean_id + "&check_box_value="+check_box_value+"&bean_name="+ or_bean_name,false);
	xmlHttp.send(xmlDoc);
	responseText=xmlHttp.responseText ;

	if(called_from == "BLERROR")
		return;
}

function deleteOROrderCatalogforNoStock(drug_code){
	var patient_id		= parent.parent.f_header.document.prescription_header_form.patient_id.value;
	var encounter_id	=  parent.parent.f_header.document.prescription_header_form.encounter_id.value;
	var or_bean_id="@orderentrybean"+patient_id+encounter_id;
	var or_bean_name="eOR.OrderEntryBean";
	var mode="";
	var chk_value="N";
	var item_code="";
	var order_catagory="PH";
	parent.parent.parent.deleteCatalogCode("ck"+drug_code,parent.parent.parent.parent.tabFrame,"PH");

	if(parent.parent.parent.parent.tabFrame!=null)
		check_box_value=parent.parent.parent.parent.tabFrame.check_box_val;

	var xmlStr ="<root><SEARCH ";
	xmlStr += " mode=\""+ mode + "\" ";
	xmlStr += " ck"+drug_code+"=\""+ chk_value + "\" ";
	xmlStr += " h1"+drug_code+"=\""+ order_catagory + "\" ";
	xmlStr += " h2"+drug_code+"=\""+ item_code + "\" ";
	xmlStr +=" /></root>";
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest() ;
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST","../../eOR/jsp/OrderEntryStoreValues.jsp?bean_id=" + or_bean_id + "&check_box_value="+check_box_value+"&bean_name="+ or_bean_name,false);
	xmlHttp.send(xmlDoc);
	responseText=xmlHttp.responseText ;
}

function chkDuplicateDrugCode(Drug_Codes, Trade_Codes, Trade_Names,order_idC,modeC){
	var facility_id=parent.f_header.document.prescription_header_form.facility_id.value;
	var patient_class=parent.f_header.document.prescription_header_form.patient_class.value;
	var patient_id=parent.f_header.document.prescription_header_form.patient_id.value;
	var encounter_id=parent.f_header.document.prescription_header_form.encounter_id.value;
	var sys_date=parent.f_header.document.prescription_header_form.sys_date.value;
	var location_type	= parent.f_header.document.prescription_header_form.location_type.value;
	var location_code	= parent.f_header.document.prescription_header_form.location_code.value;
	var priority		= parent.f_header.document.prescription_header_form.priority.value;
	var take_home_medication=parent.f_header.document.prescription_header_form.take_home_medication.value;
	var licence=parent.f_header.document.prescription_header_form.licence.value;
	var drug_db_interface_yn=parent.f_header.document.prescription_header_form.drug_db_interface_yn.value;
	var act_patient_class=parent.f_header.document.prescription_header_form.actual_patient_class.value;
	var attend_pract_id				= parent.f_header.document.prescription_header_form.attend_pract_id.value;
	var pract_id				= parent.f_header.document.prescription_header_form.pract_id.value;
	var resp_id					= parent.f_header.document.prescription_header_form.resp_id.value;
	var home_leave_yn_chk=parent.f_header.document.prescription_header_form.home_leave_yn_chk.value;//added for Bru-HIMS-CRF-093[29960] -->

	var formobj=document.prescription_detail_form;
	if(formobj==undefined || formobj==null )
		formobj = parent.f_detail.document.prescription_detail_form;
	var order_set_code=formobj.order_set_code.value;
	var order_set_occur_num=formobj.order_set_occur_num.value;

	var fldString=" drug_code=\""+ drug_code + "\" ";
			fldString+=" facility_id=\""+ facility_id + "\" ";
			fldString+=" patient_class=\""+ patient_class + "\" ";
			fldString+=" patient_id=\""+ patient_id + "\" ";
			fldString+=" encounter_id=\""+ encounter_id + "\" ";
			fldString+=" order_idC=\""+ order_idC + "\" ";
//			fldString+=" ord_line=\""+ ord_line + "\" ";
			fldString+=" modeC=\""+ modeC + "\" ";
			fldString+=" sys_date=\""+ sys_date + "\" ";
			fldString+=" drugCodes=\""+ Drug_Codes + "\" ";
			fldString+=" tradeCodes=\""+ Trade_Codes + "\" ";
			fldString+=" tradeNames=\""+ Trade_Names + "\" ";
			fldString+=" locn_type=\""+ location_type + "\" ";
			fldString+=" locn_code=\""+ location_code + "\" ";
			fldString+= " licence=\""+ licence + "\" ";
			fldString+=" priority=\""+ priority + "\" ";
			fldString+=" take_home_medication=\""+ take_home_medication + "\" ";
			fldString+=" order_set_code=\""+ order_set_code + "\" ";
			fldString+=" order_set_occur_num=\""+ order_set_occur_num + "\" ";
			fldString+=" drug_db_interface_yn=\""+ drug_db_interface_yn + "\" ";
			fldString+=" act_patient_class=\""+ act_patient_class + "\" ";
			fldString+= " pract_id=\""+ pract_id + "\" ";
			fldString+= " resp_id=\""+ resp_id + "\" ";
			fldString += " home_leave_yn_val=\""+ home_leave_yn_chk + "\" ";//added home_leave_yn_val for Bru-HIMS-CRF-093[29960] -->
		var xmlStr=formXMLString(formobj,fldString);
		fieldValidation(xmlStr,"chkDuplicateDrugCode");
}

function invalidDrug(){
	  document.prescription_detail_form.drug_search.disabled=false;
	  alert(getMessage("PH_DRUG_CODE", "PH"));
	  document.prescription_detail_form.drug_name.value="";
	  document.prescription_detail_form.drug_code.value="";
	  document.prescription_detail_form.drug_name.focus();
	  return false;
}

//called while returning the drug
function loadDetailForm(order_idC,modeC,order_line){
	
	var headerForm = "";
	if(parent.f_header == undefined)
		headerForm = parent.parent.f_header.document.prescription_header_form;
	else
		headerForm = parent.f_header.document.prescription_header_form;
	var patient_id					= headerForm.patient_id.value;
	var encounter_id				=  headerForm.encounter_id.value;
	var location_type				= headerForm.location_type.value;
	var location_code				=  headerForm.location_code.value;
	var patient_class				=  headerForm.patient_class.value;
	var act_patient_class			=  headerForm.actual_patient_class.value;
	var take_home_medication		=  headerForm.take_home_medication.value;
	var order_date_time				=  headerForm.sys_date.value;
	var bed_num						=  headerForm.bed_num.value;
	var room_num					=  headerForm.room_num.value;
	var weight						=  headerForm.weight.value;
	var bsa							=  headerForm.bsa.value;
	var drug_db_interface_yn		=  headerForm.drug_db_interface_yn.value;
	var drug_db_allergy_check_yn		=  headerForm.drug_db_allergy_check_yn.value;
	var drug_db_duptherapy_yn		= headerForm.drug_db_duptherapy_yn.value;
	var bl_install_yn				=  headerForm.bl_install_yn.value;
	var bl_disp_charge_dtl_in_rx_yn =  headerForm.bl_disp_charge_dtl_in_rx_yn.value;
	var MAR_app_yn					= getMAR_app_yn(headerForm);
	var adr_count					=  headerForm.adr_count.value;
	var order_set_code					=  headerForm.order_set_code.value;
	if (modeC == "")
		modeC = "modify";
	
	//we r passing only the first order id, 

/*	!PHIP00000031234,1& N02BE01000T1001C! PHIP00000031157,1& J01DA06520P4002
	var ind = order_idC.indexOf(",");
	if (ind != 0 && ind != -1)
	{
		order_idC = order_idC.substring(0,order_idC.indexOf(","));
	}
*/
	if(parent.f_prescription != undefined)
		parent.f_prescription.location.href="../../ePH/jsp/PrescriptionFormFrame.jsp?patient_id="+patient_id+"&encounter_id="+encounter_id+"&patient_class="+patient_class+"&bed_num="+bed_num+"&room_num="+room_num+"&weight="+weight+"&bsa="+bsa+"&drug_db_interface_yn="+drug_db_interface_yn+"&bl_install_yn="+bl_install_yn+"&bl_disp_charge_dtl_in_rx_yn="+bl_disp_charge_dtl_in_rx_yn+"&=MAR_app_yn="+MAR_app_yn+"&adr_count="+adr_count+"&act_patient_class="+act_patient_class+"&take_home_medication="+take_home_medication+"&order_set_code="+order_set_code+"&modeC="+modeC+"&order_idC="+order_idC+"&drug_db_allergy_check_yn="+drug_db_allergy_check_yn+"&drug_db_duptherapy_yn="+drug_db_duptherapy_yn;
	else
		parent.parent.f_prescription.location.href="../../ePH/jsp/PrescriptionFormFrame.jsp?patient_id="+patient_id+"&encounter_id="+encounter_id+"&patient_class="+patient_class+"&bed_num="+bed_num+"&room_num="+room_num+"&weight="+weight+"&bsa="+bsa+"&drug_db_interface_yn="+drug_db_interface_yn+"&bl_install_yn="+bl_install_yn+"&bl_disp_charge_dtl_in_rx_yn="+bl_disp_charge_dtl_in_rx_yn+"&=MAR_app_yn="+MAR_app_yn+"&adr_count="+adr_count+"&act_patient_class="+act_patient_class+"&take_home_medication="+take_home_medication+"&order_set_code="+order_set_code+"&modeC="+modeC+"&order_idC="+order_idC+"&drug_db_allergy_check_yn="+drug_db_allergy_check_yn+"&drug_db_duptherapy_yn="+drug_db_duptherapy_yn;
	if(top.content != null)
		top.content.messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num=";

//parent.f_detail.location.href="../../ePH/jsp/PrescriptionDetail_1.jsp?patient_id="+patient_id+"&srl_no="+srl_no+"&drug_code="+drug_code+"&encounter_id="+encounter_id+"&patient_class="+patient_class+"&mode="+mode+"&start_date="+order_date_time;
	return true;
}

function record(){
	var frmObj		=	parent.parent.f_detail.document;
	var headerFrame	=   parent.parent.f_header;
	//parent.frames[2].document.forms[0].release_rx.disabled=true;
	var chk_missing_sch_yn=frmObj.prescription_detail_form.chk_missing_sch_yn.value;  //AAKH-CRF-0091 
	var amend_yn=frmObj.prescription_detail_form.amend_yn.value;	//AAKH-CRF-0091 
	var chk_preview_rx=document.preview.chk_preview_rx.value; //AAKH-CRF-0091
	if(headerFrame.document.prescription_header_form.man_rem_on_prn_freq_yn != undefined && headerFrame.document.prescription_header_form.man_rem_on_prn_freq_yn.value == 'Y'){
		if(frmObj.prn_remarks !=null || frmObj.prn_remarks!=undefined ){
			if(frmObj.prn_remarks.style.visibility=="visible" && frmObj.prn_remarks_flag.value == "false" ){
				if(frmObj.prn_yn.value=='Y'){
					alert(getMessage("PRN_REMARKS_CANNOT_BE_BLANK", "PH"));
					return false;
			   }
			}
		}
	}
	//Added for Antibiotic Screen using Order Entry Format ICN 29904 -start
	if(parent.parent.f_detail.f_sliding_scale_admin_dtls!=undefined){
		var slingfrmObj = parent.parent.f_detail.f_sliding_scale_dtls.prescription_detail_form;
		var drugRemarksMandatory = slingfrmObj.DrugRemarksMandatory.value;
		var drugRemarksEntered		 = slingfrmObj.DrugRemarksEntered.value;
		if(drugRemarksMandatory == 'Y' && drugRemarksEntered != 'Y'){
			msg = getMessage("CAN_NOT_BE_BLANK","Common");
			msg = msg.replace('$', getLabel("ePH.DrugRemarks.label","PH"));
			alert(msg);
			slingfrmObj.drug_remarks.click();
			return false;
		}
	}
	else{
		if(frmObj.prescription_detail_form.DrugRemarksMandatory.value == 'Y' && frmObj.prescription_detail_form.DrugRemarksEntered.value != 'Y'){
			msg = getMessage("CAN_NOT_BE_BLANK","Common");
			msg = msg.replace('$', getLabel("ePH.DrugRemarks.label","PH"));
			alert(msg);
			parent.parent.f_detail.document.getElementById("drug_remarks").click();
			return false;
		}
	}
	//Added for Antibiotic Screen using Order Entry Format ICN 29904 -end
	if(parent.parent.f_detail.f_sliding_scale_admin_dtls!=undefined){//added for IN26429_reopen --15/02/2011-- priya
		var sld_scale_frmObj = parent.parent.f_detail.f_sliding_scale_admin_dtls.document.prescription_detail_form;
		if(sld_scale_frmObj.bl_overriden_action_reason_img.style.visibility=="visible"){
			if(sld_scale_frmObj.bl_incl_excl_override_reason_code.value == ""){
				alert(getMessage("INCL_EXCL_OVERRIDE_REASON_CANNOT_BE_BLANK","PH"));
				return false;
			}
		}
	}
	if( frmObj.prescription_detail_form !=null && frmObj.prescription_detail_form!=undefined){		
		var qty_value = frmObj.prescription_detail_form.qty_value.value;   //added for SKR-SCF-0309 start
		var drug_code   = frmObj.prescription_detail_form.drug_code.value;
		var route_code		 =  frmObj.prescription_detail_form.route_code.value;
		var preg_remarks	= frmObj.prescription_detail_form.preg_remarks.value;
		var pregnency_yn	= frmObj.prescription_detail_form.pregnency_yn.value;
		var preg_effect	= frmObj.prescription_detail_form.preg_effect.value;
		var default_freq_not_found =frmObj.prescription_detail_form.default_freq_not_found.value; //added for GHL-CRF-0508
		//added for GHL-CRF-0508 start
		if(default_freq_not_found){
	    var freq_code   = frmObj.prescription_detail_form.frequency.value;
		}
		//added for GHL-CRF-0508 end
		if(drug_code!="" && (qty_value=="" || parseFloat(qty_value)==0)) {
			alert(getMessage("PRES_DOSAGE_CANNOT_ZERO", "PH"));
			frmObj.prescription_detail_form.qty_value.focus();
			return false;
		}     //added for SKR-SCF-0309  end
		// added for GHL-CRF-0508 start
		if(default_freq_not_found){
		if(drug_code!="" && freq_code==""){
			 alert(getMessage("SELECT_FREQUENCY", "PH"));
			 frmObj.prescription_detail_form.frequency.focus();
		     	return false;
		  }
		}
		// added for GHL-CRF-0508 end

		if(frmObj.prescription_detail_form.durn_value.value != "" ){
			var retval = validateDuration(frmObj.prescription_detail_form.durn_value,'release');
			if(retval == false)
				return false;
		}
		if(frmObj.bl_overriden_action_reason_img.style.visibility=="visible"){//added for IN26429 --09/02/2011-- priya
			if(frmObj.bl_incl_excl_override_reason_code.value == ""){
				alert(getMessage("INCL_EXCL_OVERRIDE_REASON_CANNOT_BE_BLANK","PH"));
				return false;
			}
		}
		if(drug_code!="" &&(route_code == undefined || route_code =='')){
			frmObj.prescription_detail_form.route_code.focus();
			msg = getMessage("CAN_NOT_BE_BLANK","Common");
			msg = msg.replace('$', getLabel("Common.Route.label","common"));
			alert(msg);
			return false;
		}
		if((pregnency_yn=="Y" &&  preg_effect!="") && (preg_remarks==null || preg_remarks=="") ){//&& preg_warn_req_yn=="Y" ){
			alert(getMessage('PH_SELECT_PREG_OVERRIDE_RESONE','PH'));
			frmObj.preg_alert.click();
			return;
		}

		// ML-MMOH-CRF-1823 US008- 43528 START
		//var Okay = true;
		var preview_rx_yn = frmObj.prescription_detail_form.preview_rx_yn.value;
		if(preview_rx_yn!="Y"){
		var setLimitByType = frmObj.prescription_detail_form.setLimitByType.value;
		var quotaLimitReqYN = frmObj.prescription_detail_form.quotaLimitReqYN.value;
		var quotaLimitValue = frmObj.prescription_detail_form.quotaLimitValue.value;
		var quotaCurrValue = frmObj.prescription_detail_form.quotaCurrValue.value;
		if(quotaLimitReqYN == "Y" ){
			var chk_limit =checkQuotaLimit(quotaLimitValue,setLimitByType,quotaCurrValue);
			if(chk_limit!=undefined && chk_limit!= "" && chk_limit!="Y"){
				var delete_confirm = confirm(getMessage("CANCEL_SEL_DRUG","PH"))
					if(delete_confirm){
					formValidation("delete",frmObj.prescription_detail_form);
					 clearDetails();
				       return false;
				}
			}
		}
	 }
		// ML-MMOH-CRF-1823 US008- 43528 END
	}

	parent.frames[2].document.forms[0].release_rx.title=getLabel("Common.processing.label","Common");
	record1();
}

function record1(){  
	if(chkOverRideRemarks()){
	}
	/*
	var patient_class=parent.f_detail.document.prescription_detail_form.patient_class.value;
	var patient_id=parent.f_detail.document.prescription_detail_form.patient_id.value;
	var encounter_id=parent.f_detail.document.prescription_detail_form.encounter_id.value;
	var height=parent.f_header.document.prescription_header_form.height.value;
	var weight=parent.f_header.document.prescription_header_form.weight.value;
	var bsa=parent.f_header.document.prescription_header_form.bsa.value;
	var height_unit=parent.f_header.document.prescription_header_form.height_unit.value;
	var weight_unit=parent.f_header.document.prescription_header_form.weight_unit.value;
	var bsa_unit="BSA";
	if(height_unit=="")height_unit="Cms";
	if(weight_unit=="")weight_unit="Kgs";
	var fldString=" patient_class=\""+ patient_class + "\" ";
	fldString+=" patient_id=\""+ patient_id + "\" ";
	fldString+=" encounter_id=\""+ encounter_id + "\" ";
	fldString+=" height=\""+ height + "\" ";
	fldString+=" weight=\""+ weight + "\" ";
	fldString+=" bsa=\""+ bsa + "\" ";
	fldString+=" height_unit=\""+ height_unit + "\" ";
	fldString+=" weight_unit=\""+ weight_unit + "\" ";
	fldString+=" bsa_unit=\""+ bsa_unit + "\" ";
	var formobj=parent.f_detail.document.prescription_detail_form;
	var xmlStr=formXMLString(formobj,fldString);

	var source="recordData";
	var xmlDoc = "" ;
    var xmlHttp = new XMLHttpRequest() ;
    xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
    xmlHttp.open("POST","PrescriptionValidation.jsp?func_mode="+source,false);
    xmlHttp.send(xmlDoc);
    responseText=xmlHttp.responseText ;
	eval(responseText);
    return true;
	*/
}

function chkOverRideRemarks(){
	//alert("chkOverRideRemarks");
	var patient_id=parent.parent.f_header.document.prescription_header_form.patient_id.value;
	var encounter_id=parent.parent.f_header.document.prescription_header_form.encounter_id.value;
	var drug_db_interface_yn=parent.parent.f_header.document.prescription_header_form.drug_db_interface_yn.value;
	var drug_db_duptherapy_yn = parent.parent.f_header.document.prescription_header_form.drug_db_duptherapy_yn.value;
	var drug_indication_mdry=parent.parent.f_header.document.prescription_header_form.drug_indication_mdry.value;//added for jd-crf-0220
	//alert(drug_indication_mdry+"drug_indication_mdry");
	var buildMAR_yn=""; //added for SKR-SCF-0606 [IN:034766]
	var srl_no=""; //added for SKR-SCF-0606 [IN:034766]
	var preg_remarks=""; //added for CRF RUT-CRF-0063[29601]
	var allow_duplicate=""; // added for MO-GN-5490 [IN:054620]
	var quota_limit_excess_yn = "N";//Adding  for ML-MMOH-CRF-01823
	if(parent.parent.f_detail.document.prescription_detail_form != undefined){
		var drug_code = parent.parent.f_detail.document.prescription_detail_form.drug_code.value;
		var trade_code = parent.parent.f_detail.document.prescription_detail_form.trade_code.value;
		var disp_locn_code = parent.parent.f_detail.document.prescription_detail_form.disp_locn_code.value;
		//Added by Karabi
		var override_remarks = parent.parent.f_detail.document.prescription_detail_form.override_remarks.value;
		//End
		buildMAR_yn = parent.parent.f_detail.document.prescription_detail_form.buildMAR_yn.value; //added for SKR-SCF-0606 [IN:034766]
		srl_no = parent.parent.f_detail.document.prescription_detail_form.srl_no.value; //added for SKR-SCF-0606 [IN:034766]
		preg_remarks = parent.parent.f_detail.document.prescription_detail_form.preg_remarks.value; //added for CRF RUT-CRF-0063[29601]
		allow_duplicate = parent.parent.f_detail.document.prescription_detail_form.allow_duplicate.value; //  added for MO-GN-5490 [IN:054620]
		quota_limit_excess_yn = parent.parent.f_detail.document.prescription_detail_form.quota_limit_exceded_yn.value;
	}
	else{
		var drug_code = parent.parent.f_detail.f_sliding_scale_dtls.document.prescription_detail_form.drug_code.value;
		var trade_code = parent.parent.f_detail.f_sliding_scale_dtls.document.prescription_detail_form.trade_code.value;
		//var disp_locn_code = parent.parent.f_detail.f_sliding_scale_dtls.document.prescription_detail_form.disp_locn_code.value;
		var override_remarks = parent.parent.f_detail.f_sliding_scale_dtls.document.prescription_detail_form.override_remarks.value;
		buildMAR_yn =  parent.parent.f_detail.f_sliding_scale_dtls.document.prescription_detail_form.buildMAR_yn.value; //added for SKR-SCF-0606 [IN:034766]
		srl_no =  parent.parent.f_detail.f_sliding_scale_dtls.document.prescription_detail_form.srl_no.value; //added for SKR-SCF-0606 [IN:034766]
		preg_remarks =  parent.parent.f_detail.f_sliding_scale_dtls.document.prescription_detail_form.preg_remarks.value; //added for CRF RUT-CRF-0063[29601]
		allow_duplicate =  parent.parent.f_detail.f_sliding_scale_dtls.document.prescription_detail_form.allow_duplicate.value; // added for MO-GN-5490 [IN:003593]
		quota_limit_excess_yn = "N";
	}
	if(parent.parent.f_detail.document.prescription_detail_form!=undefined){//SKR-SCF-0648 [IN-35984] - if condition and else block Added to check Override remarks on Sliding Scale. 
		if(parent.parent.f_detail.document.prescription_detail_form.dosage_limit.style.visibility=="visible"){ // added if condition for the incident no:MO-GN-5406(31896) by chandrashekar raju
			// Modified for IN:069887 start
			if((parent.parent.f_detail.document.getElementById('override_remarks').style.visibility=="visible") && (override_remarks != "Y") ){
				if(parent.parent.f_detail.document.prescription_detail_form.validate_overide_on_confirm_yn.value=="Y"){
					var obj=parent.parent.f_detail.document.prescription_detail_form;
					validateOnConfirm(obj);
				}
				
				else{
					alert(getMessage("OVERRIDE_REASON_NOT_BLANK", "PH"));
				}
				// Modified for IN:069887 end
				return false;
			}
		}
	}
	else{//SKR-SCF-0648 [IN-35984] - Added to check Override remarks on Sliding Scale.
		if(override_remarks=="N"){
		// Modified for IN:069887 start
			if(parent.parent.f_detail.f_sliding_scale_dtls.document.prescription_detail_form.validate_overide_on_confirm_yn.value=="Y"){
				var obj=parent.parent.f_detail.f_sliding_scale_dtls.document.prescription_detail_form;
				validateOnConfirm(obj);
			}
			else{
				alert(getMessage("OVERRIDE_REASON_NOT_BLANK", "PH"));
			}
		// Modified for IN:069887 end	
			return false;
		}
	}
	var fldString=" patient_id=\""+ patient_id + "\" ";
	fldString+=" encounter_id=\""+ encounter_id + "\" ";
	fldString+=" drug_code=\""+ drug_code + "\" ";
	fldString+=" disp_locn_code=\""+ disp_locn_code + "\" ";
	fldString+=" drug_db_interface_yn=\""+ drug_db_interface_yn + "\" ";
	fldString+=" drug_db_duptherapy_yn=\""+ drug_db_duptherapy_yn + "\" ";
	fldString += "buildMAR_yn=\""+ buildMAR_yn +"\" " ; //added for SKR-SCF-0606 [IN:034766]
	fldString += "srl_no=\""+ srl_no +"\" " ; //added for  SKR-SCF-0606 [IN:034766]
	fldString += "preg_remarks=\""+ preg_remarks +"\" " ; //added for CRF RUT-CRF-0063[29601]
	fldString += "allow_duplicate=\""+ allow_duplicate +"\" " ; //  added for MO-GN-5490 [IN:054620]
	fldString += "drug_indication_mdry=\""+ drug_indication_mdry +"\" " ;//added for jd-crf-0220
	fldString += "quota_limit_excess_yn=\""+ quota_limit_excess_yn +"\" " ;//Adding  for ML-MMOH-CRF-01823
	var formobj=parent.parent.f_header.document.prescription_header_form;
	var xmlStr=formXMLString(formobj,fldString);
	fieldValidationOverride(xmlStr,"chkOverRideRemarks");//modified for AAKH-CRF-0140
}

function allowRelease(allow_1,allow_2,allow_3,allow_4,allow_5,allow_6,allow_7,stat_yn){//added for jd-crf-0220 allow_6 
	var allow_without_diag	=	parent.parent.f_header.document.prescription_header_form.allow_without_diag.value;
	var diag_size			=	parent.parent.f_header.document.prescription_header_form.diag_size.value;
	var diag_link			=	parent.parent.f_header.document.getElementById("diag_text").style.visibility;
	var can_allow_1 = false;
	var frmObj		=	parent.parent.f_detail.document; //AAKH-CRF-0091
	var chk_missing_sch_yn=frmObj.prescription_detail_form.chk_missing_sch_yn.value;  //AAKH-CRF-0091 
	var amend_yn=frmObj.prescription_detail_form.amend_yn.value;	//AAKH-CRF-0091 
	var chk_preview_rx=document.preview.chk_preview_rx.value;	//AAKH-CRF-0091 
	//var stat_yn=frmObj.prescription_detail_form.stat_yn.value;	//AAKH-CRF-0091 
	//alert(stat_yn);
	var scheduled_yn=frmObj.prescription_detail_form.scheduled_yn.value; //AAKH-CRF-0091 
	var patient_class=frmObj.prescription_detail_form.patient_class.value; //AAKH-CRF-0091 
//added for GHL-CRF-0482 - start
	var drug_code					= frmObj.prescription_detail_form.drug_code.value; 
	var facility_id					= parent.parent.f_header.document.prescription_header_form.facility_id.value;
	var patient_stock_flag			= frmObj.prescription_detail_form.patient_stock_required_yn.value;
	var pres_base_uom				= frmObj.prescription_detail_form.pres_base_uom.value;
	var brought_by_pat = "";
	
	if(frmObj.prescription_detail_form.brought_by_pat!=undefined){ // Added for GHL-CRF-0482 -Start
	   brought_by_pat = frmObj.prescription_detail_form.brought_by_pat.value;
	} // Added for GHL-CRF-0482 - End


	if(patient_stock_flag =="Y" && brought_by_pat!="Y" && drug_code!=""){
		var patient_id				=  parent.parent.f_header.document.prescription_header_form.patient_id.value;
		var encounter_id			=   parent.parent.f_header.document.prescription_header_form.encounter_id.value;
		getPatientStockYN(parent.parent.f_header.document.prescription_header_form,drug_code,patient_id,encounter_id,facility_id,pres_base_uom);
		var patient_stock_allow_yn = frmObj.prescription_detail_form.patient_stock_allow_yn.value;
		patientStockOrderStatusUpdate(parent.parent.f_header.document.prescription_header_form,drug_code,frmObj.prescription_detail_form.srl_no.value,frmObj.prescription_detail_form.patient_stock_yn.value)
		
	}
      //added for SKR-SCF-1270
	if(parent.parent.f_header.document.prescription_header_form.man_rem_on_prn_freq_yn != undefined && parent.parent.f_header.document.prescription_header_form.man_rem_on_prn_freq_yn.value == 'Y'){
		 validatePRNRemarks(parent.parent.f_header.document.prescription_header_form,patient_id,encounter_id);
	}
//added for GHL-CRF-0482 - end
	/*if(allow_without_diag=="N" && (parseInt(diag_size)>12 || diag_link=="hidden" ) ) {
		alert(getMessage("CHOOSE_PAT_DIAG", "PH"));
		can_allow_1=false;
		return false;
	}*/ //Commented for Diagnosis Issue from AAKH (Related with AAKH_CRF_009) & SRR20056-SCF-9714[IN038210]  And SRR20056-SCF-9733[IN038353] [IN039120]
	var can_allow   = false;
	var can_allow_2 = false;

	if(allow_5=="true"){
	 	if(allow_1=="true" && allow_2=="true"  && allow_3=="true" ){
			can_allow_1=true;
			//formGrouping();
			//setHeaderValues();
		}
		else{
			if(stat_yn != "Y" ){ //if() added for AAKH-CRF-0091 
			// Modified for IN:069887 satrt
				if(frmObj.prescription_detail_form.validate_overide_on_confirm_yn.value=="Y"){
					var obj=frmObj.prescription_detail_form;
					validateOnConfirm(obj);
				}
				else{
					alert(getMessage("OVERRIDE_REASON_NOT_BLANK", "PH"));
				}
				// Modified for IN:069887 end
			can_allow_1=false;
			return false;
			}	
		}
	//	if(frmObj.prescription_detail_form.drug_indication_mdry.value=="Y"){//jd-crf-0220
		//	if(frmObj.prescription_detail_form.DrugIndicationRemarks.value ==null || frmObj.prescription_detail_form.DrugIndicationRemarks.value ==""){
			//	alert(getMessage("DRUG_INDICATION_REASON_NOT_BLANK", "PH"));
			//	return false;
		//	}
			//alert("3821drug_indication_mdry"+document.prescription_detail_form.drug_ind_remarks.value);
	//	}	
	}
	else{
		alert(getMessage("ATC_DUPLICATION", "PH"));
		var patient_id				=  parent.parent.f_header.document.prescription_header_form.patient_id.value;
		var encounter_id			=   parent.parent.f_header.document.prescription_header_form.encounter_id.value;
		var location_type			=   parent.parent.f_header.document.prescription_header_form.location_type.value;
		var location_code			=   parent.parent.f_header.document.prescription_header_form.location_code.value;
		var patient_class			=   parent.parent.f_header.document.prescription_header_form.patient_class.value;
		var act_patient_class		=   parent.parent.f_header.document.prescription_header_form.actual_patient_class.value;
		var take_home_medication	=   parent.parent.f_header.document.prescription_header_form.take_home_medication.value;
		var order_date_time			=   parent.parent.f_header.document.prescription_header_form.sys_date.value;
		var bed_num					=   parent.parent.f_header.document.prescription_header_form.bed_num.value;
		var room_num				=	parent.parent.f_header.document.prescription_header_form.room_num.value;
		var weight					=	parent.parent.f_header.document.prescription_header_form.weight.value;
		var bsa						=	parent.parent.f_header.document.prescription_header_form.bsa.value;
		var drug_db_interface_yn	=	parent.parent.f_header.document.prescription_header_form.drug_db_interface_yn.value;
		var adr_count				=	parent.parent.f_header.document.prescription_header_form.adr_count.value;
		var order_set_code			=	parent.parent.f_header.document.prescription_header_form.order_set_code.value;
		var drug_db_allergy_check_yn =	parent.parent.f_header.document.prescription_header_form.drug_db_allergy_check_yn.value;
		var drug_db_duptherapy_yn	=	parent.parent.f_header.document.prescription_header_form.drug_db_duptherapy_yn.value;

		parent.parent.f_prescription.location.href="../../ePH/jsp/PrescriptionFormFrame.jsp?patient_id="+patient_id+"&encounter_id="+encounter_id+"&patient_class="+patient_class+"&bed_num="+bed_num+"&room_num="+room_num+"&weight="+weight+"&bsa="+bsa+"&drug_db_interface_yn="+drug_db_interface_yn+"&adr_count="+adr_count+"&act_patient_class="+act_patient_class+"&take_home_medication="+take_home_medication+"&order_set_code="+order_set_code+"&drug_db_allergy_check_yn="+drug_db_allergy_check_yn+"&drug_db_duptherapy_yn="+drug_db_duptherapy_yn;
		if(top.content != null)
			top.content.messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num=";
	}

	if(prn_remark_flag==false){ //if block added for SKR-SCF-1270
		alert(getMessage("PRN_REMARKS_CANNOT_BE_BLANK", "PH"));
		return false;
	}
	if(scheduled_yn=="Y" && patient_class== "IP" && chk_missing_sch_yn=="Y" && amend_yn=="N"){// AAKH-CRF-0091 // Removed chk_preview_rx!="Y" for AAKH-CRF-0091
		var release_chk=confirm(getMessage("PH_STAT_RELEASE_CONFIRM","PH"));
			if(release_chk==true || release_chk=="true"){
					frmObj.prescription_detail_form.chk_missing_sch_yn_1.value="Y";
					return false;
			}
	}
	//alert("3650"+allow_6);
	if(allow_6=="true"){//added for jd-crf-0220
		can_allow_1=true;
	}
	else{
		
		alert(getMessage("DRUG_INDICATION_REASON_NOT_BLANK", "PH"));
		can_allow_1=false;
		return false;
	}
	
	if(allow_7=="true"){//added for jd-crf-0220
		can_allow_1=true;
	}
	else{
		
		alert(getMessage("REQ_DIAG_PRES_NOT_FOUND", "PH"));
		can_allow_1=false;
		return false;
	}
	if(allow_4=="true"){
		can_allow_2=true;
	}
	else{
		alert(getMessage("SCH_FREQ_MANDATORY", "PH"));
		can_allow_2=false;
	}

	if(can_allow_1 && can_allow_2){
		can_allow=true;
		if(parent.frames[2].document.forms[0].rx_button_disable.value=="true"){//Added for KDAH-SCF-0382 and commented for SKR-SCF-1252 and removed comment for KDAH-CF-0640
            parent.frames[2].document.forms[0].release_rx.disabled=true;//Added for KDAH-SCF-0382

		}
	   formGrouping();
	}else{
		can_allow=false;
	}
	return can_allow;
}

function setHeaderValues(){

	var patient_id=parent.parent.f_header.document.prescription_header_form.patient_id.value;
	var encounter_id=parent.parent.f_header.document.prescription_header_form.encounter_id.value;
	var height=parent.parent.f_header.document.prescription_header_form.height.value;
	var weight=parent.parent.f_header.document.prescription_header_form.weight.value;
	var bsa=parent.parent.f_header.document.prescription_header_form.bsa.value;
	var height_unit=parent.parent.f_header.document.prescription_header_form.height_unit.value;
	var weight_unit=parent.parent.f_header.document.prescription_header_form.weight_unit.value;
	var bsa_unit="BSA";
	var priority = parent.parent.f_header.document.prescription_header_form.priority.value;
	var order_date_time = parent.parent.f_header.document.prescription_header_form.sys_date.value;
	var take_home_medication = parent.parent.f_header.document.prescription_header_form.take_home_medication.value;
	var patient_class=parent.parent.f_header.document.prescription_header_form.patient_class.value;
	if(height_unit=="")
		height_unit="Cms";
	if(weight_unit=="")
		weight_unit="Kgs";
	var location_type=parent.parent.f_header.document.prescription_header_form.location_type.value;
	var location_code=parent.parent.f_header.document.prescription_header_form.location_code.value;

	var fldString=" patient_class=\""+ patient_class + "\" ";
	fldString+=" patient_id=\""+ patient_id + "\" ";
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
	fldString+=" location_type=\""+ location_type + "\" ";
	fldString+=" location_code=\""+ location_code + "\" ";

	var formobj=parent.parent.f_header.document.prescription_header_form;
	var xmlStr=formXMLString(formobj,fldString);
	fieldValidation(xmlStr,"setHeaderValues");
  }
function clearDetails(){

	var patient_id=parent.parent.f_header.document.prescription_header_form.patient_id.value;
	var encounter_id=parent.parent.f_header.document.prescription_header_form.encounter_id.value;
	var height=parent.parent.f_header.document.prescription_header_form.height.value;
	var weight=parent.parent.f_header.document.prescription_header_form.weight.value;
	var bsa=parent.parent.f_header.document.prescription_header_form.bsa.value;
	var height_unit=parent.parent.f_header.document.prescription_header_form.height_unit.value;
	var weight_unit=parent.parent.f_header.document.prescription_header_form.weight_unit.value;
	var bsa_unit="BSA";
	var priority = parent.parent.f_header.document.prescription_header_form.priority.value;
	var order_date_time = parent.parent.f_header.document.prescription_header_form.sys_date.value;
	var take_home_medication = parent.parent.f_header.document.prescription_header_form.take_home_medication.value;
	var patient_class=parent.parent.f_header.document.prescription_header_form.patient_class.value;
	if(height_unit=="")
		height_unit="Cms";
	if(weight_unit=="")
		weight_unit="Kgs";
	var bed_num						= parent.parent.f_header.document.prescription_header_form.bed_num.value;
	var room_num					= parent.parent.f_header.document.prescription_header_form.room_num.value;
	var location_type=parent.parent.f_header.document.prescription_header_form.location_type.value;
	var location_code=parent.parent.f_header.document.prescription_header_form.location_code.value;
	var drug_db_interface_yn		= parent.parent.f_header.document.prescription_header_form.drug_db_interface_yn.value;
	var bl_install_yn				= parent.parent.f_header.document.prescription_header_form.bl_install_yn.value;
	var bl_disp_charge_dtl_in_rx_yn = parent.parent.f_header.document.prescription_header_form.bl_disp_charge_dtl_in_rx_yn.value;
	var MAR_app_yn					= getMAR_app_yn(parent.parent.f_header.document.prescription_header_form);
	var adr_count					= parent.parent.f_header.document.prescription_header_form.adr_count.value;
	var act_patient_class			= parent.parent.f_header.document.prescription_header_form.actual_patient_class.value;
	var order_set_code				= parent.parent.f_header.document.prescription_header_form.order_set_code.value;
	var trade_display_yn			= parent.parent.f_header.document.prescription_header_form.trade_display_yn.value;
	var drug_db_allergy_check_yn	= parent.parent.f_header.document.prescription_header_form.drug_db_allergy_check_yn.value;
	var drug_db_duptherapy_yn		= parent.parent.f_header.document.prescription_header_form.drug_db_duptherapy_yn.value;
	var alternateOrder				= parent.parent.f_header.document.prescription_header_form.alternateOrder.value;//added for  JD-CRF-0198 [IN:058599]
	var pract_id				    = parent.parent.f_header.document.prescription_header_form.pract_id.value;//added for 
//added for GHL-CRF-0482 - start
	var facility_id					= parent.parent.f_header.document.prescription_header_form.facility_id.value;
	


	parent.parent.f_prescription.location.href="../../ePH/jsp/PrescriptionFormFrame.jsp?patient_id="+patient_id+"&encounter_id="+encounter_id+"&patient_class="+patient_class+"&bed_num="+bed_num+"&room_num="+room_num+"&weight="+weight+"&bsa="+bsa+"&drug_db_interface_yn="+drug_db_interface_yn+"&bl_install_yn="+bl_install_yn+"&bl_disp_charge_dtl_in_rx_yn="+bl_disp_charge_dtl_in_rx_yn+"&MAR_app_yn="+MAR_app_yn+"&adr_count="+adr_count+"&act_patient_class="+act_patient_class+"&take_home_medication="+take_home_medication+"&order_set_code="+order_set_code+"&drug_db_allergy_check_yn="+drug_db_allergy_check_yn+"&drug_db_duptherapy_yn="+drug_db_duptherapy_yn;
	var mode="blank";
	parent.parent.f_detail.location.href="../../ePH/jsp/PrescriptionDetail_1.jsp?patient_id="+patient_id+"&encounter_id="+encounter_id+"&patient_class="+patient_class+"&mode="+mode+"&start_date="+order_date_time+"&bed_num="+bed_num+"&room_num="+room_num+"&drug_db_interface_yn="+drug_db_interface_yn+"&bl_install_yn="+bl_install_yn+"&bl_disp_charge_dtl_in_rx_yn="+bl_disp_charge_dtl_in_rx_yn+"&MAR_app_yn="+MAR_app_yn+"&act_patient_class="+act_patient_class+"&take_home_medication="+take_home_medication+"&trade_display_yn="+trade_display_yn+"&drug_db_allergy_check_yn="+drug_db_allergy_check_yn+"&drug_db_duptherapy_yn="+drug_db_duptherapy_yn+"&pract_id="+pract_id;

   parent.parent.f_button.location.href="../../ePH/jsp/PrescriptionButton_1.jsp?patient_id="+patient_id+"&mode="+mode+"&encounter_id="+encounter_id+"&patient_class="+patient_class+"&bed_num="+bed_num+"&room_num="+room_num+"&drug_db_interface_yn="+drug_db_interface_yn+"&act_patient_class="+act_patient_class+"&take_home_medication="+take_home_medication;

}

function formGrouping(){
	var patient_id=parent.parent.f_header.document.prescription_header_form.patient_id.value;
	var encounter_id=parent.parent.f_header.document.prescription_header_form.encounter_id.value;
	var bed_num=parent.parent.f_header.document.prescription_header_form.bed_num.value;
	var room_num=parent.parent.f_header.document.prescription_header_form.room_num.value;

	var height=parent.parent.f_header.document.prescription_header_form.height.value;
	var weight=parent.parent.f_header.document.prescription_header_form.weight.value;
	var bsa=parent.parent.f_header.document.prescription_header_form.bsa.value;
	var bmi=parent.parent.f_header.document.prescription_header_form.bmi.value;
	var height_unit=parent.parent.f_header.document.prescription_header_form.height_unit.value;
	var weight_unit=parent.parent.f_header.document.prescription_header_form.weight_unit.value;
	var bsa_unit="BSA";
	var priority = parent.parent.f_header.document.prescription_header_form.priority.value;
	var order_date_time = parent.parent.f_header.document.prescription_header_form.sys_date.value;
	var take_home_medication = parent.parent.f_header.document.prescription_header_form.take_home_medication.value;
	var patient_class	= parent.parent.f_header.document.prescription_header_form.patient_class.value;
	var allergic_yn	= parent.parent.f_header.document.prescription_header_form.allergic_yn.value;

	if(height_unit=="")
		height_unit="Cms";
	if(weight_unit=="")
		weight_unit="Kgs";
	var location_type=parent.parent.f_header.document.prescription_header_form.location_type.value;
	var location_code=parent.parent.f_header.document.prescription_header_form.location_code.value;
	var facility_id=parent.parent.f_header.document.prescription_header_form.facility_id.value;
	var attend_pract_id=parent.parent.f_header.document.prescription_header_form.attend_pract_id.value;
	var ord_pract_id=parent.parent.f_header.document.prescription_header_form.pract_id.value;
	var split_based_priority_yn=parent.parent.f_header.document.prescription_header_form.split_based_priority_yn.value;
	var split_based_drug_class_yn=parent.parent.f_header.document.prescription_header_form.split_based_drug_class_yn.value;
	var home_leave_yn_chk=parent.parent.f_header.document.prescription_header_form.home_leave_yn_chk.value;
	var function_from  = parent.parent.f_header.document.prescription_header_form.function_from.value;//added for JD-CRF-198
	var currentStage=parent.parent.f_header.document.prescription_header_form.currentStage.value;//added for  JD-CRF-0198 [IN:058599]
	var split_drug_based_auth_yn=parent.parent.f_header.document.prescription_header_form.split_drug_based_auth_yn.value;//added for ml-mmoh-crf-0864
	//alert("split_drug_based_auth_yn"+split_drug_based_auth_yn);
	var fldString=" patient_class=\""+ patient_class + "\" ";
	fldString+=" patient_id=\""+ patient_id + "\" ";
	fldString+=" encounter_id=\""+ encounter_id + "\" ";
	fldString+=" bed_num=\""+ bed_num + "\" ";
	fldString+=" room_num=\""+ room_num + "\" ";
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
	fldString+=" split_based_priority_yn=\""+ split_based_priority_yn + "\" ";	
	fldString+=" split_based_drug_class_yn=\""+ split_based_drug_class_yn + "\" ";	
	fldString+=" home_leave_yn_val=\""+ home_leave_yn_chk + "\" ";	//added  for Bru-HIMS-CRF-093[29960] -->
	fldString+=" function_from=\""+ function_from+ "\" ";	//added for JD-CRF-198
	fldString+=" currentStage=\""+ currentStage + "\" ";//added for  JD-CRF-0198 [IN:058599]
	fldString+=" split_drug_based_auth_yn=\""+ split_drug_based_auth_yn + "\" ";//added for  ml-mmoh-crf-0864
	
	var formobj=parent.parent.f_header.document.prescription_header_form;
	var xmlStr=formXMLString(formobj,fldString);
	fieldValidation(xmlStr,"formGrouping");
}

function addDrug(oper_mode,from_disc_cancel){//from_disc_cancel added for MO-CRF-20159
	var durn_desc		 = parent.f_detail.document.prescription_detail_form.durn_desc.value;
	var repeat_durn_type = parent.f_detail.document.prescription_detail_form.repeat_durn_type.value;
	var durn_value		 = parent.f_detail.document.prescription_detail_form.durn_value.value;
	var route_code		 = parent.f_detail.document.prescription_detail_form.route_code.value;
	var intr_restric_trn = parent.f_detail.document.prescription_detail_form.intr_restric_trn.value;
	var headerFrame		 = parent.f_header;
	var qty_value	= parent.f_detail.document.prescription_detail_form.qty_value.value;
	var preg_remarks	= parent.f_detail.document.prescription_detail_form.preg_remarks.value;
	var pregnency_yn	= parent.f_detail.document.prescription_detail_form.pregnency_yn.value;
	var preg_effect	= parent.f_detail.document.prescription_detail_form.preg_effect.value;
	var frmObj			= parent.f_detail.document.prescription_detail_form;
	var parent_stat_yn		 = parent.f_detail.document.prescription_detail_form.parent_stat_yn.value; //AAKH-CRF-0091
	var stat_yn		 = parent.f_detail.document.prescription_detail_form.stat_yn.value;	//AAKH-CRF-0091
	var default_freq_not_found =parent.f_detail.document.prescription_detail_form.default_freq_not_found.value; //added for GHL-CRF-0508
	var disc_cancel_flag = parent.f_detail.document.prescription_detail_form.disc_cancel_flag.value; //added for MO-CRF-20159
	var abuse_restric_trn=parent.f_detail.document.prescription_detail_form.abuse_restric_trn.value;//added for aakh-crf-0140
	var diagnosis_found_yn=parent.f_detail.document.prescription_detail_form.diagnosis_found_yn.value;//added for mms-dm-crf-0204
	//added for GHL-CRF-0508 start
	if(default_freq_not_found){
	var freq_code   = parent.f_detail.document.prescription_detail_form.frequency.value;
	}
	
	// ML-MMOH-CRF-1823 US008- 43528 START
	var Okay = true;
	var setLimitByType = parent.f_detail.document.prescription_detail_form.setLimitByType.value;
	var quotaLimitReqYN = parent.f_detail.document.prescription_detail_form.quotaLimitReqYN.value;
	var quotaLimitValue = parent.f_detail.document.prescription_detail_form.quotaLimitValue.value;
	var quotaCurrValue = parent.f_detail.document.prescription_detail_form.quotaCurrValue.value;
//	alert("quotaLimitReqYN==="+quotaLimitReqYN+"setLimitByType=="+setLimitByType);
	if(quotaLimitReqYN == "Y" && oper_mode !="delete"){
		var chk_limit =checkQuotaLimit(quotaLimitValue,setLimitByType,quotaCurrValue);
		if(chk_limit!=undefined && chk_limit!= "" && chk_limit!="Y"){
			addDrug("delete");
			return false;
		}
	}
	// ML-MMOH-CRF-1823 US008- 43528 END
	//added for GHL-CRF-0508 end
	frmObj.override_rem_mand.value='N';//Added for IN:073485 
	drug_code =frmObj.drug_code.value;
	srl_no = frmObj.srl_no.value;
	//Added for IN:073485 start
	patient_id=frmObj.patient_id.value;
	encounter_id=frmObj.encounter_id.value;
	var override_select_appl=frmObj.override_select_appl.value
	if(override_select_appl=='Y' && (oper_mode=="modify" || oper_mode=="tapered")){ //oper_mode=="tapered" Added for MMS-KH-SCF-0216
		checkMandRemarks(drug_code,srl_no,patient_id,encounter_id,frmObj);
	}
	if(parent.f_detail.document.prescription_detail_form.override_rem_mand !=undefined && parent.f_detail.document.prescription_detail_form.override_rem_mand.value=='Y'){
		// Modified for IN:069887 start
		if(parent.f_detail.document.prescription_detail_form.validate_overide_on_confirm_yn.value=="Y"){
			var obj=parent.f_detail.document.prescription_detail_form;
			validateOnConfirm(obj);
		}
		else{
		alert(getMessage("OVERRIDE_REASON_NOT_BLANK", "PH"));
		}
		// Modified for IN:069887 end
		return false;
	}
	//alert(parent.f_detail.document.prescription_detail_form.DrugIndicationRemarks.value);
	//alert(parent.f_detail.document.prescription_detail_form.drug_indication_mdry.value);
	//drug_indication
	
	//added for mms-dm-crf-0204 start
	if(diagnosis_found_yn=="N"){
			alert(getMessage("REQ_DIAG_PRES_NOT_FOUND",'PH'));
} 
	if(oper_mode!="delete" && diagnosis_found_yn=="N"){
	var ord_set_reqd_or_opt = frmObj.ord_set_reqd_or_opt.value;
	if(ord_set_reqd_or_opt == 'R'){
		alert(getMessage("PH_CANCEL_ORDERSET_DRUG_FROM_RX", "PH"));
		return false;
	}
}
//added for mms-dm-crf-0204 end
	if(oper_mode!="delete"){
	if(parent.f_detail.document.prescription_detail_form.drug_indication_mdry.value=="Y"){//jd-crf-0220
		if(parent.f_detail.document.prescription_detail_form.DrugIndicationRemarks.value ==null || parent.f_detail.document.prescription_detail_form.DrugIndicationRemarks.value ==""){
			alert(getMessage("DRUG_INDICATION_REASON_NOT_BLANK", "PH"));
			return false;
		}
		//alert("3821drug_indication_mdry"+document.prescription_detail_form.drug_ind_remarks.value);
	}
	}

	//Added for IN:073485 end
	if(oper_mode!="delete"){
		if(intr_restric_trn=='Y'){
			patient_id=frmObj.patient_id.value;
			encounter_id=frmObj.encounter_id.value;
			drug_code =frmObj.drug_code.value;
			srl_no = frmObj.srl_no.value;
			intr_restric_trn = frmObj.intr_restric_trn.value;
			alertIntr(drug_code, srl_no, patient_id, encounter_id, intr_restric_trn)
			//alertIntr(drug_name, intr_dtl)
			return false;
		}
	}//added for aakh-crf-0140 start
	if(oper_mode!="delete"){
		if(abuse_restric_trn=='Y'){
		//	alert(abuse_restric_trn);
			patient_id=frmObj.patient_id.value;
			encounter_id=frmObj.encounter_id.value;
			drug_code =frmObj.drug_code.value;
			srl_no = frmObj.srl_no.value;
			abuse_restric_trn = frmObj.abuse_restric_trn.value;
			alertAbuse(drug_code, srl_no, patient_id, encounter_id, abuse_restric_trn)
			//alertIntr(drug_name, intr_dtl)
			return false;
		}
	}
	//added for aakh-crf-0140 end
	if(parseFloat(qty_value)==0 || qty_value==""  ) {
		parent.f_detail.document.prescription_detail_form.qty_value.focus();
		alert(getMessage("PRES_DOSAGE_CANNOT_ZERO", "PH"));
		return false;
	}else
		if(default_freq_not_found){// added for GHL-CRF-0508 start
		if(freq_code==""){
		 alert(getMessage("SELECT_FREQUENCY", "PH"));
		    parent.f_detail.document.prescription_detail_form.frequency.focus();
	     	return false;
	         }
		}
		// added for GHL-CRF-0508 end
	if(oper_mode!="delete"){
		if(route_code == undefined || route_code ==''){
			parent.f_detail.document.prescription_detail_form.route_code.focus();
			msg = getMessage("CAN_NOT_BE_BLANK","Common");
			msg = msg.replace('$', getLabel("Common.Route.label","common"));
			alert(msg);
			return false;
		}
		if((pregnency_yn=="Y" &&  preg_effect!="") && (preg_remarks==null || preg_remarks=="") ){
			alert(getMessage('PH_SELECT_PREG_OVERRIDE_RESONE','PH'));
			parent.f_detail.document.prescription_detail_form.preg_alert.click();
			return;
		}
		if(durn_value == 0 || durn_value == ''){
			alert(getMessage("PRES_DURN_CANNOT_ZERO", "PH"));
			parent.f_detail.document.prescription_detail_form.durn_value.focus();
			return false;
		} 
		else if(repeat_durn_type != durn_desc){
			if(parent.f_detail.document.prescription_detail_form.tmp_durn_value.value != 0 || parent.f_detail.document.prescription_detail_form.tmp_durn_value.value != ''){
				//parent.f_detail.document.prescription_detail_form.durn_value.value = parent.f_detail.document.prescription_detail_form.tmp_durn_value.value;
				//parent.f_detail.document.prescription_detail_form.durn_desc.value = parent.f_detail.document.prescription_detail_form.tmp_durn_desc.value;
			}
		}
		//Added for Antibiotic Screen using Order Entry Format ICN 29904 -start
		var chk_for_max_durn_action = parent.f_detail.document.prescription_detail_form.chk_for_max_durn_action.value;
		if(chk_for_max_durn_action=='R'){
			var valid_durn = validateDuration(parent.f_detail.document.prescription_detail_form.durn_value,'confirm');  //Added for ML-BRU-SCF-0820 [IN:039500]
			if(!valid_durn)  //Added for ML-BRU-SCF-0820 [IN:039500]
				return false;
		}
		var drugRemarksMandatory = parent.f_detail.document.prescription_detail_form.DrugRemarksMandatory.value;
		var drugRemarksEntered		 = parent.f_detail.document.prescription_detail_form.DrugRemarksEntered.value;
		if(drugRemarksMandatory == 'Y' && drugRemarksEntered != 'Y'){
			msg = getMessage("CAN_NOT_BE_BLANK","Common");
			msg = msg.replace('$', getLabel("ePH.DrugRemarks.label","PH"));
			alert(msg);
			parent.f_detail.document.getElementById("drug_remarks").click();
			return false;
		}
	}//Added for Antibiotic Screen using Order Entry Format ICN 29904 -end
	refresh_screen=true;
	var bean_id			= "";
	var patient_id		= "";
	var encounter_id	= "";
	var patient_class	= "";
	var order_date_time	= "";
	assignDurnTypeList(frmObj.DurnDescDetails.value);

	 // commented by rawther for scf : 7732
	/* if(oper_mode!="delete"){ //condition added for allowing to cancel drug without checking for max duration --priya-- 02/03/2010
		var retval = validateDuration(frmObj.durn_value,'confirm');
		if(retval == false)
			return;
	}*/

	if(oper_mode=="modify"){
		if(frmObj.trade_code_option!=undefined && frmObj.trade_code_option.options[0] != null && frmObj.trade_code.value == ""){
			frmObj.trade_code.value = frmObj.trade_code_option.options[0].value;
			frmObj.trade_name.value = frmObj.trade_code_option.options[0].text;
		}
		if(headerFrame.document.prescription_header_form.man_rem_on_prn_freq_yn != undefined && headerFrame.document.prescription_header_form.man_rem_on_prn_freq_yn.value == 'Y'){
			if(document.getElementById('prn_remarks ')!=null || document.getElementById('prn_remarks')!=undefined ){
				if(frmObj.prn_remarks.style.visibility=="visible" && frmObj.prn_remarks_flag.value == "false" ){
					if(frmObj.prn_yn.value=='Y'){
						alert(getMessage("PRN_REMARKS_CANNOT_BE_BLANK", "PH"));
						return false;
				   }
				}
			}
		}
		if(frmObj.dosage_limit.style.visibility=="visible" ){
			if(frmObj.override_remarks.style.visibility=="visible" && frmObj.override_remarks.checked == false ){
			// Modified for IN:069887 start
				if(frmObj.validate_overide_on_confirm_yn.value == "Y"){
					validateOnConfirm(frmObj);
				}
				else{
				alert(getMessage("OVERRIDE_REASON_NOT_BLANK", "PH"));
				}
				// Modified for IN:069887 end
								return false;
			}
		}
		if(frmObj.bl_overriden_action_reason_img.style.visibility=="visible"){
			if(frmObj.bl_incl_excl_override_reason_code.value == ""){
				alert(getMessage("INCL_EXCL_OVERRIDE_REASON_CANNOT_BE_BLANK","PH"));
				return false;
			}
		}
		if(oper_mode!="delete"){
		if(parent.f_detail.document.prescription_detail_form.drug_indication_mdry.value=="Y"){//jd-crf-0220
			if(parent.f_detail.document.prescription_detail_form.DrugIndicationRemarks.value ==null || parent.f_detail.document.prescription_detail_form.DrugIndicationRemarks.value ==""){
				alert(getMessage("DRUG_INDICATION_REASON_NOT_BLANK", "PH"));
				return false;
			}
			//alert("3821drug_indication_mdry"+document.prescription_detail_form.drug_ind_remarks.value);
		}
	}
	}	
	if((oper_mode=="modify") || (oper_mode=="tapered")){
		patient_id=frmObj.patient_id.value;
		encounter_id=frmObj.encounter_id.value;
		patient_class=parent.f_header.document.prescription_header_form.patient_class.value;
		order_date_time	= parent.f_header.document.prescription_header_form.sys_date.value;
		if(frmObj.brought_by_pat!= null){//if block added for IN23880 -- 27/10/2010-- priya
			if(frmObj.brought_by_pat.checked == true)
				frmObj.brought_by_pat.value = "Y";
			else
				frmObj.brought_by_pat.value = "N";
		}
	}
	else if(oper_mode=="taper"){
		patient_id=frmObj.patient_id.value;
		encounter_id=frmObj.encounter_id.value;
		patient_class=parent.f_header.document.prescription_header_form.patient_class.value;
		order_date_time	= parent.f_header.document.prescription_header_form.sys_date.value;

		if(frmObj.brought_by_pat!= null){// if block added for IN23880 -- 27/10/2010-- priya
			if(frmObj.brought_by_pat.checked == true)
				frmObj.brought_by_pat.value = "Y";
			else
				frmObj.brought_by_pat.value = "N";
		}
	}
	else if(oper_mode=="delete"){
		if(parent_stat_yn=="Y"){	//if() added for AAKH-CRF-0091
			alert(getMessage("PH_STAT_PARENT", "PH"));
			return false;
		}
		else{	var delete_confirm; //added for MO-CRF-20159
				if(diagnosis_found_yn=="N"){//if else condtion added for mms-dm-crf-0204
					if(from_disc_cancel==null || from_disc_cancel==undefined) 
						delete_confirm =true;

				
				}	else{
					if(from_disc_cancel==null || from_disc_cancel==undefined) //if added for MO-CRF-20159
						delete_confirm = confirm(getMessage("CANCEL_SEL_DRUG","PH"))

				}	 
			
				if(from_disc_cancel=="Y") //added for MO-CRF-20159
					delete_confirm = true;
			if(!delete_confirm)
				return;
			if(delete_confirm==true){
				var ord_set_reqd_or_opt = frmObj.ord_set_reqd_or_opt.value;
				if(ord_set_reqd_or_opt == 'R'){
					alert(getMessage("PH_CANCEL_ORDERSET_DRUG_FROM_RX", "PH"));
					return false;
				}
				else{
					patient_id=frmObj.patient_id.value;
					encounter_id=frmObj.encounter_id.value;
					patient_class=parent.f_header.document.prescription_header_form.patient_class.value;
					order_date_time = parent.f_header.document.prescription_header_form.sys_date.value;
				
				}
			}
		}
	}
	var bed_num						= parent.f_header.document.prescription_header_form.bed_num.value;
	var room_num					= parent.f_header.document.prescription_header_form.room_num.value;
	var weight						= parent.f_header.document.prescription_header_form.weight.value;
	var bsa							= parent.f_header.document.prescription_header_form.bsa.value;
	var drug_db_interface_yn		= parent.f_header.document.prescription_header_form.drug_db_interface_yn.value;
	var bl_install_yn				= parent.f_header.document.prescription_header_form.bl_install_yn.value;
	var bl_disp_charge_dtl_in_rx_yn = parent.f_header.document.prescription_header_form.bl_disp_charge_dtl_in_rx_yn.value;
	var MAR_app_yn					= getMAR_app_yn(parent.f_header.document.prescription_header_form);
	var adr_count					= parent.f_header.document.prescription_header_form.adr_count.value;
	var act_patient_class			= parent.f_header.document.prescription_header_form.actual_patient_class.value;
	var take_home_medication		= parent.f_header.document.prescription_header_form.take_home_medication.value;
	var order_set_code				= parent.f_header.document.prescription_header_form.order_set_code.value;
	var trade_display_yn			= parent.f_header.document.prescription_header_form.trade_display_yn.value;
	var drug_db_allergy_check_yn	= parent.f_header.document.prescription_header_form.drug_db_allergy_check_yn.value;
	var drug_db_duptherapy_yn		= parent.f_header.document.prescription_header_form.drug_db_duptherapy_yn.value;
	var alternateOrder				= parent.f_header.document.prescription_header_form.alternateOrder.value;//added for  JD-CRF-0198 [IN:058599]
	var pract_id				    = parent.f_header.document.prescription_header_form.pract_id.value;//added for 
//added for GHL-CRF-0482 - start
	var facility_id					= parent.f_header.document.prescription_header_form.facility_id.value;
	var patient_stock_flag			= frmObj.patient_stock_required_yn.value;
	var pres_base_uom				= frmObj.pres_base_uom.value;
	var brought_by_pat				= "N";
	if(frmObj.brought_by_pat!=undefined){
	 brought_by_pat = frmObj.brought_by_pat.value;
	 	
	}
	if(oper_mode!="delete"){
		if(patient_stock_flag =="Y" && brought_by_pat!="Y"){ // frmObj.brought_by_pat!=undefined Added for GHL-CRF-0482
	getPatientStockYN(parent.f_header.document.prescription_header_form,drug_code,patient_id,encounter_id,facility_id,pres_base_uom);
		var patient_stock_allow_yn = frmObj.patient_stock_allow_yn.value;

		if(patient_stock_allow_yn=="N")
			return false;		
		}
	}
//added for GHL-CRF-0482 -end
	if(chkMandatory(oper_mode)){
		if(chkQuantity()){
			//Added by Karabi
			frmObj.practitioner_name.value=parent.f_header.document.prescription_header_form.pract_name.value;
			//End By Karabi
			if(formValidation(oper_mode,frmObj)){
				if(checkForDuplicate()){
					if(oper_mode=="taper" || oper_mode=="tapered" || oper_mode =='delete'){
						if(refresh_screen){
							if(oper_mode !='delete')
								parent.f_prescription.location.href="../../ePH/jsp/PrescriptionFormFrame.jsp?patient_id="+patient_id+"&encounter_id="+encounter_id+"&patient_class="+patient_class+"&bed_num="+bed_num+"&room_num="+room_num+"&weight="+weight+"&bsa="+bsa+"&drug_db_interface_yn="+drug_db_interface_yn+"&bl_install_yn="+bl_install_yn+"&bl_disp_charge_dtl_in_rx_yn="+bl_disp_charge_dtl_in_rx_yn+"&MAR_app_yn="+MAR_app_yn+"&adr_count="+adr_count+"&act_patient_class="+act_patient_class+"&take_home_medication="+take_home_medication+"&order_set_code="+order_set_code+"&drug_db_allergy_check_yn="+drug_db_allergy_check_yn+"&drug_db_duptherapy_yn="+drug_db_duptherapy_yn+"&conf_drug_code="+drug_code+"&conf_srl_no="+srl_no;
							else
								parent.f_prescription.location.href="../../ePH/jsp/PrescriptionFormFrame.jsp?patient_id="+patient_id+"&encounter_id="+encounter_id+"&patient_class="+patient_class+"&bed_num="+bed_num+"&room_num="+room_num+"&weight="+weight+"&bsa="+bsa+"&drug_db_interface_yn="+drug_db_interface_yn+"&bl_install_yn="+bl_install_yn+"&bl_disp_charge_dtl_in_rx_yn="+bl_disp_charge_dtl_in_rx_yn+"&MAR_app_yn="+MAR_app_yn+"&adr_count="+adr_count+"&act_patient_class="+act_patient_class+"&take_home_medication="+take_home_medication+"&order_set_code="+order_set_code+"&drug_db_allergy_check_yn="+drug_db_allergy_check_yn+"&drug_db_duptherapy_yn="+drug_db_duptherapy_yn;
							var mode="blank";
							parent.f_detail.location.href="../../ePH/jsp/PrescriptionDetail_1.jsp?patient_id="+patient_id+"&encounter_id="+encounter_id+"&patient_class="+patient_class+"&mode="+mode+"&start_date="+order_date_time+"&bed_num="+bed_num+"&room_num="+room_num+"&drug_db_interface_yn="+drug_db_interface_yn+"&bl_install_yn="+bl_install_yn+"&bl_disp_charge_dtl_in_rx_yn="+bl_disp_charge_dtl_in_rx_yn+"&MAR_app_yn="+MAR_app_yn+"&act_patient_class="+act_patient_class+"&take_home_medication="+take_home_medication+"&trade_display_yn="+trade_display_yn+"&drug_db_allergy_check_yn="+drug_db_allergy_check_yn+"&drug_db_duptherapy_yn="+drug_db_duptherapy_yn+"&pract_id="+pract_id;
							parent.f_button.location.href="../../ePH/jsp/PrescriptionButton_1.jsp?patient_id="+patient_id+"&mode="+mode+"&encounter_id="+encounter_id+"&patient_class="+patient_class+"&bed_num="+bed_num+"&room_num="+room_num+"&drug_db_interface_yn="+drug_db_interface_yn+"&act_patient_class="+act_patient_class+"&take_home_medication="+take_home_medication;
						}
					}
					else{
						if(refresh_screen){
							parent.f_prescription.location.href="../../ePH/jsp/PrescriptionFormFrame.jsp?patient_id="+patient_id+"&encounter_id="+encounter_id+"&patient_class="+patient_class+"&bed_num="+bed_num+"&room_num="+room_num+"&weight="+weight+"&bsa="+bsa+"&drug_db_interface_yn="+drug_db_interface_yn+"&bl_install_yn="+bl_install_yn+"&bl_disp_charge_dtl_in_rx_yn="+bl_disp_charge_dtl_in_rx_yn+"&MAR_app_yn="+MAR_app_yn+"&adr_count="+adr_count+"&act_patient_class="+act_patient_class+"&take_home_medication="+take_home_medication+"&order_set_code="+order_set_code+"&drug_db_allergy_check_yn="+drug_db_allergy_check_yn+"&drug_db_duptherapy_yn="+drug_db_duptherapy_yn+"&conf_drug_code="+drug_code+"&conf_srl_no="+srl_no;
							var mode="blank";
							parent.f_detail.location.href="../../ePH/jsp/PrescriptionDetail_1.jsp?patient_id="+patient_id+"&encounter_id="+encounter_id+"&patient_class="+patient_class+"&mode="+mode+"&start_date="+order_date_time+"&bed_num="+bed_num+"&room_num="+room_num+"&drug_db_interface_yn="+drug_db_interface_yn+"&bl_install_yn="+bl_install_yn+"&bl_disp_charge_dtl_in_rx_yn="+bl_disp_charge_dtl_in_rx_yn+"&MAR_app_yn="+MAR_app_yn+"&act_patient_class="+act_patient_class+"&take_home_medication="+take_home_medication+"&trade_display_yn="+trade_display_yn+"&drug_db_allergy_check_yn="+drug_db_allergy_check_yn+"&drug_db_duptherapy_yn="+drug_db_duptherapy_yn+"&alternateOrder="+alternateOrder+"&pract_id="+pract_id;//added for  JD-CRF-0198 [IN:058599]
							parent.f_button.location.href="../../ePH/jsp/PrescriptionButton_1.jsp?patient_id="+patient_id+"&mode="+mode+"&encounter_id="+encounter_id+"&patient_class="+patient_class+"&bed_num="+bed_num+"&room_num="+room_num+"&drug_db_interface_yn="+drug_db_interface_yn+"&act_patient_class="+act_patient_class+"&take_home_medication="+take_home_medication;
						}
					}
				}
				if(top.content != null)
					top.content.messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num=";
			}
		}
	}
	else{
		alert(getMessage("PH_MANDATORY", "PH"));
	}
	var formobj	=	parent.f_header.document.prescription_header_form;
	formobj.sys_date.disabled=true;
	parent.f_header.document.getElementById("Calendar").disabled=true;
	//commented for enhancement FS Ref 3.36
	//formobj.priority.disabled	=	true;
	formobj.height.disabled		=	true;
	formobj.weight.disabled		=	true;
	formobj.take_home_medication.disabled		=	true;
	if(parent.f_header.document.getElementById("tdPrescripionHdrDuration").style.visibility == 'visible'){
		parent.f_header.document.prescription_header_form.durn_value.disabled=true;
		parent.f_header.document.prescription_header_form.durn_desc.disabled=true;
	}
	if(parent.f_header.document.prescription_header_form.take_home_medication_op_chk!=undefined)
		parent.f_header.document.prescription_header_form.take_home_medication_op_chk.disabled=true;//added for NMC-JD-CRF-0063
}

function chkMandatory(oper_mode){
	var chk_man		= false;
	var qty_value	= parent.f_detail.document.prescription_detail_form.qty_value.value;
	var qty_desc	= parent.f_detail.document.prescription_detail_form.qty_desc.value;
	var freq_code	= parent.f_detail.document.prescription_detail_form.frequency.value;
	var durn_value	= parent.f_detail.document.prescription_detail_form.durn_value.value;
	var durn_desc	= parent.f_detail.document.prescription_detail_form.durn_value.value;

	var chk_split="";

	if(parent.f_detail.document.prescription_detail_form.sch_over_yn.value=="N"){
		chk_split="Y";
	}
	else{
		chk_split="Y";
	}

	if( qty_value!="" && qty_desc!="" && freq_code!="" && durn_value!="" &&  durn_desc!="" && chk_split!=""){
		chk_man = true;
	}
	else{
		chk_man = false;
	}

	if(oper_mode=='delete'){
		chk_man = true;
	}
	return chk_man;
}

function formValidation(oper_mode,frmObj){
	//alert("formValidation");
	return_val	=	true;
	var xmlStr ="<root><SEARCH ";
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
				}
				else{
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
                for(var j=0; j<arrObj[i].options.length; j++){
                    if(arrObj[i].options[j].selected){
                        val+=arrObj[i].options[j].value +"~"
					}
                }
                val= val.substring(0,val.lastIndexOf('~'))
                if(arrObj[i].name != null && arrObj[i].name != "")
                    xmlStr+= arrObj[i].name+"=\"" + checkSpl(val) + "\" " ;
            }
            else {
                val = arrObj[i].value;
                if(arrObj[i].name != null && arrObj[i].name != "" && arrObj[i].name != "practitioner_name")
                    xmlStr+= arrObj[i].name+"=\"" + checkSpl(val) + "\" " ;
            }
        }
    }
	var route_desc=frmObj.route_code.options[frmObj.route_code.selectedIndex].text;
	var freq_desc="";
//	var repeat_value = frmObj.repeat_value.value;
	if(frmObj.frequency.options.length!=0)
		freq_desc= encodeURIComponent(frmObj.frequency.options[frmObj.frequency.selectedIndex].text,"UTF-8");
	var or_qty_desc =	 frmObj.qty_desc.options[frmObj.qty_desc.selectedIndex].text;
	var or_durn_desc = frmObj.durn_desc.options[frmObj.durn_desc.selectedIndex].text;
	var patient_id=frmObj.patient_id.value;
	var encounter_id=frmObj.encounter_id.value;
	var override_remarks=frmObj.override_remarks.value;
	var patient_stock_yn = frmObj.patient_stock_yn.value;//added for GHL-CRF-0482
	//var pat_counseling_reqd = frmObj.pat_counseling_reqd.value;
	var spl_man_yn="";
	if(frmObj.split_dose.disabled==true){
		spl_man_yn="N";
	}
	else{
		spl_man_yn="Y";
	}
	var pract_name=	unescape(frmObj.practitioner_name.value);
	var split_dose_yn_val=	frmObj.split_dose_yn_val.value;
	var def_qty_value = frmObj.def_qty_value.value;//ARYU-CRF-014
	var qty_val     = frmObj.qty_value.value;//CRF-014
	var repeat_durn_type= frmObj.repeat_durn_type.value;//CRF-014
	var freq_nature		= frmObj.freq_nature.value;//CRF-014

	if(freq_nature!="O" && freq_nature!="I" && freq_nature!="P" && repeat_durn_type=="D"){
		
		if( parseFloat(def_qty_value)!=parseFloat(qty_val)){

			dose_chaged_yn = "Y";
		}
		else{

			dose_chaged_yn = "N";
		}
	}else{

	dose_chaged_yn = "N";
	}//End of ARYU-CRF-0014
	//GHL-CRF-0549 - start
	var allow_alternate = "N"; //GHL-CRF-0549

	if(frmObj.allow_alternate_yn!=undefined && frmObj.allow_alternate_yn.checked==true){
		allow_alternate = "Y";
	}
	//GHL-CRF-0549 - end
	if(parent.f_header!=undefined){//Added for ML_MMOH-CRF-01823
	var drug_db_dosecheck_yn=	parent.f_header.document.prescription_header_form.drug_db_dosecheck_yn.value;
	var drug_db_interface_yn  = parent.f_header.document.prescription_header_form.drug_db_interface_yn.value;
	var drug_db_duptherapy_yn  = parent.f_header.document.prescription_header_form.drug_db_duptherapy_yn.value;
	}else if (parent.parent.f_header)
	{
		var drug_db_dosecheck_yn=	parent.parent.f_header.document.prescription_header_form.drug_db_dosecheck_yn.value;
	    var drug_db_interface_yn  = parent.parent.f_header.document.prescription_header_form.drug_db_interface_yn.value;
	    var drug_db_duptherapy_yn  = parent.parent.f_header.document.prescription_header_form.drug_db_duptherapy_yn.value;
	}
	//var order_set_code=	parent.f_header.document.prescription_header_form.order_set_code.value;
	var quota_limit_excess_yn = frmObj.quota_limit_exceded_yn.value;
	
	//End by Karabi
	xmlStr += "oper_mode=\""+ oper_mode + "\" ";
	xmlStr += "route_desc=\""+ route_desc + "\" ";
	xmlStr += "or_qty_desc=\""+ or_qty_desc + "\" ";
	xmlStr += "or_durn_desc=\""+ or_durn_desc + "\" ";
	xmlStr += "freq_desc=\""+ freq_desc + "\" ";
	xmlStr += "spl_man_yn=\""+ spl_man_yn + "\" ";
	xmlStr += "qty_val=\""+ qty_val + "\" "; //added for ML-MMOH-SCF-1439
	xmlStr += "pract_name=\""+ encodeURIComponent(pract_name) + "\" ";
	xmlStr += "drug_db_dosecheck_yn=\""+ drug_db_dosecheck_yn + "\" ";
	xmlStr += "drug_db_interface_yn=\""+ drug_db_interface_yn + "\" ";
	xmlStr += "drug_db_duptherapy_yn=\""+ drug_db_duptherapy_yn + "\" ";
	xmlStr += "patient_stock=\""+ patient_stock_yn + "\" ";//added for GHL-CRF-0482 
	xmlStr += "dose_chaged_yn=\""+ dose_chaged_yn + "\" ";//added for //ARYU-CRF-014 
	xmlStr += "def_dose_value=\""+ def_qty_value + "\" ";//added for //ARYU-CRF-014 
	xmlStr += "allow_alternate=\""+ allow_alternate + "\" ";//added for GHL-CRF-0549 
	xmlStr += "quota_limit_excess_yn=\""+ quota_limit_excess_yn + "\" ";
	xmlStr +=" /></root>";
	var xmlDoc = "" ;
    var xmlHttp = new XMLHttpRequest() ;
    xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
    xmlHttp.open("POST","PrescriptionValidation_1.jsp?func_mode=InsertRec",false);
    xmlHttp.send(xmlDoc);
    responseText=xmlHttp.responseText ;

	if(oper_mode=="delete" || oper_mode=="modify" || oper_mode=="taper" || oper_mode=="tapered"){
		eval(responseText);
	}
	return return_val;
}

function alertNoStock(avail_stock){
	alert(getMessage("PH_PARENT_REC_1", "PH")+"("+avail_stock+")");
}

function warnNoStock(avail_stock){
	alert(getMessage("PH_NO_STOCK_AVAIL_DRUG_WARN", "PH")+"("+avail_stock+")");
}

function alertParentRecord(oper_mode,frm,prev_drun_value){
	if(oper_mode=="delete")
		alert(getMessage("PH_PARENT_REC_1", "PH"));
	else{
		alert(getMessage("PH_PARENT_REC_2", "PH"));
		 
		if(frm != undefined && frm != 'confirm' ){// if conditiion is added for insident no SCF No. SRR20056-SCF-7537, 
			document.prescription_detail_form.durn_value.value=prev_drun_value;
			//setfocus(parent.parent.f_detail.document.prescription_detail_form.durn_value);
		}
	}
   //return false;	
}

async function callPreviewOrders()	{
	//chithra aakh-crf-089  start
	if(parent.parent.f_detail != undefined ){ //Adding start for ARYU-SCF-0033
        if(parent.parent.f_detail.f_sliding_scale_admin_dtls!=null && parent.parent.f_detail.f_sliding_scale_admin_dtls!=undefined){
			 frmObj = parent.parent.f_detail.f_sliding_scale_admin_dtls;
		}else{
		    frmObj = parent.parent.f_detail.document;
		}
	}//Adding end for ARYU-SCF-0033
//var frmObj		=	parent.parent.f_detail.document;//Commented for ARYU-SCF-0033
var headerFrame	=   parent.parent.f_header;
//parent.frames[2].document.forms[0].release_rx.disabled=true;
var chk_missing_sch_yn=frmObj.prescription_detail_form.chk_missing_sch_yn.value; //AAKH-CRF-0091
var amend_yn=frmObj.prescription_detail_form.amend_yn.value; //AAKH-CRF-0091
var chk_preview_rx=document.preview.chk_preview_rx.value; //AAKH-CRF-0091
if(headerFrame.document.prescription_header_form.man_rem_on_prn_freq_yn != undefined && headerFrame.document.prescription_header_form.man_rem_on_prn_freq_yn.value == 'Y'){
	if(parent.parent.f_detail.f_sliding_scale_admin_dtls!=null && parent.parent.f_detail.f_sliding_scale_admin_dtls!=undefined){//Adding start for ARYU-SCF-0033
		var prn_frm=frmObj;
	}else{
		var prn_frm=frmObj.all;
	}//Adding end for ARYU-SCF-0033
	if(prn_frm.prn_remarks !=null || prn_frm.prn_remarks!=undefined ){//Replaced frmObj.all with prn_frm for ARYU-SCF-0033
		if(prn_frm.prn_remarks.style.visibility=="visible" && prn_frm.prn_remarks_flag.value == "false" ){//Replaced frmObj.all with prn_frm for ARYU-SCF-0033
			if(prn_frm.prn_yn.value=='Y'){//Replaced frmObj.all with prn_frm for ARYU-SCF-0033
				alert(getMessage("PRN_REMARKS_CANNOT_BE_BLANK", "PH"));
				return false;
		   }
		}
	}
}
if(parent.parent.f_detail.f_sliding_scale_admin_dtls!=undefined){
	var slingfrmObj = parent.parent.f_detail.f_sliding_scale_dtls.prescription_detail_form;
	var drugRemarksMandatory = slingfrmObj.DrugRemarksMandatory.value;
	var drugRemarksEntered		 = slingfrmObj.DrugRemarksEntered.value;
	if(drugRemarksMandatory == 'Y' && drugRemarksEntered != 'Y'){
		msg = getMessage("CAN_NOT_BE_BLANK","Common");
		msg = msg.replace('$', getLabel("ePH.DrugRemarks.label","PH"));
		alert(msg);
		slingfrmObj.drug_remarks.click();
		return false;
	}
}
else{
	if(frmObj.prescription_detail_form.DrugRemarksMandatory.value == 'Y' && frmObj.prescription_detail_form.DrugRemarksEntered.value != 'Y'){
		msg = getMessage("CAN_NOT_BE_BLANK","Common");
		msg = msg.replace('$', getLabel("ePH.DrugRemarks.label","PH"));
		alert(msg);
		parent.parent.f_detail.document.getElementById("drug_remarks").click();
		return false;
	}
}
if(parent.parent.f_detail.f_sliding_scale_admin_dtls!=undefined){
	var sld_scale_frmObj = parent.parent.f_detail.f_sliding_scale_admin_dtls.document.prescription_detail_form;
	if(sld_scale_frmObj.bl_overriden_action_reason_img.style.visibility=="visible"){
		if(sld_scale_frmObj.bl_incl_excl_override_reason_code.value == ""){
			alert(getMessage("INCL_EXCL_OVERRIDE_REASON_CANNOT_BE_BLANK","PH"));
			return false;
		}
	}
}
if( frmObj.prescription_detail_form !=null && frmObj.prescription_detail_form!=undefined){		
	var qty_value = frmObj.prescription_detail_form.qty_value.value;   
	var drug_code   = frmObj.prescription_detail_form.drug_code.value;
	var default_freq_not_found =frmObj.prescription_detail_form.default_freq_not_found.value;//added for GHL-CRF-0508
	//added for GHL-CRF-0508 start
	if(default_freq_not_found){
	var freq_code   = frmObj.prescription_detail_form.frequency.value;
	}
	//added for GHL-CRF-0508 end
	var route_code		 =  frmObj.prescription_detail_form.route_code.value;
	var preg_remarks	= frmObj.prescription_detail_form.preg_remarks.value;
	var pregnency_yn	= frmObj.prescription_detail_form.pregnency_yn.value;
	var preg_effect	= frmObj.prescription_detail_form.preg_effect.value;
	
	var chk_missing_sch_yn	= frmObj.prescription_detail_form.chk_missing_sch_yn.value;
	var amend_yn 			= frmObj.prescription_detail_form.amend_yn.value;
	
	
	if(drug_code!="" && (qty_value=="" || parseFloat(qty_value)==0)) {
		alert(getMessage("PRES_DOSAGE_CANNOT_ZERO", "PH"));
		frmObj.prescription_detail_form.qty_value.focus();
		return false;
	}     
	// added for GHL-CRF-0508 start
	if(default_freq_not_found){
	if(drug_code!="" && freq_code ==""){
		 alert(getMessage("SELECT_FREQUENCY", "PH"));
		 frmObj.prescription_detail_form.frequency.focus();
	     	return false;
	  }
	}
	// added for GHL-CRF-0508 end
	if(frmObj.prescription_detail_form.durn_value.value != "" ){
		var retval = validateDuration(frmObj.prescription_detail_form.durn_value,'release');
		if(retval == false)
			return false;
	}
	if(frmObj.bl_overriden_action_reason_img.style.visibility=="visible"){
		if(frmObj.bl_incl_excl_override_reason_code.value == ""){
			alert(getMessage("INCL_EXCL_OVERRIDE_REASON_CANNOT_BE_BLANK","PH"));
			return false;
		}
	}
	if(drug_code!="" &&(route_code == undefined || route_code =='')){
		frmObj.prescription_detail_form.route_code.focus();
		msg = getMessage("CAN_NOT_BE_BLANK","Common");
		msg = msg.replace('$', getLabel("Common.Route.label","common"));
		alert(msg);
		return false;
	}
	if((pregnency_yn=="Y" &&  preg_effect!="") && (preg_remarks==null || preg_remarks=="") ){//&& preg_warn_req_yn=="Y" ){
		alert(getMessage('PH_SELECT_PREG_OVERRIDE_RESONE','PH'));
		frmObj.preg_alert.click();
		return;
	}
	
}
//var quotaLimitReqYN = frmObj.prescription_detail_form.quotaLimitReqYN.value;
//ML-MMOH-CRF-1823 US008- 43528 START 

var setLimitByType = frmObj.prescription_detail_form.setLimitByType.value;
var quotaLimitReqYN = frmObj.prescription_detail_form.quotaLimitReqYN.value;
var quotaLimitValue = frmObj.prescription_detail_form.quotaLimitValue.value;
var quotaCurrValue = frmObj.prescription_detail_form.quotaCurrValue.value;
if(quotaLimitReqYN == "Y"){
	var chk_limit =checkQuotaLimit(quotaLimitValue,setLimitByType,quotaCurrValue);
		if(chk_limit!=undefined && chk_limit!= "" && chk_limit!="Y"){
			var delete_confirm = confirm(getMessage("CANCEL_SEL_DRUG","PH"));
			if(delete_confirm){
			  formValidation("delete",frmObj.prescription_detail_form);
			  clearDetails();
			  return false;
			 }else{
				  return false;
			 }
		   }
}
//ML-MMOH-CRF-1823 US008- 43528 END



parent.frames[2].document.forms[0].release_rx.title=getLabel("Common.processing.label","Common");//AAKH-CRF-089 end chithra
	
	var patient_id				= parent.parent.f_header.document.prescription_header_form.patient_id.value;
	var encounter_id			= parent.parent.f_header.document.prescription_header_form.encounter_id.value;
	var date					= parent.parent.f_header.document.prescription_header_form.sys_date.value;
	var locn_code				= parent.parent.f_header.document.prescription_header_form.location_code.value;
	
	var pract_name				= unescape(parent.parent.f_header.document.prescription_header_form.pract_name.value);

	var actual_patient_class	= parent.parent.f_header.document.prescription_header_form.actual_patient_class.value;
	var bl_install_yn			= parent.parent.f_header.document.prescription_header_form.bl_install_yn.value;
	var bl_disp_charge_dtl_in_rx_yn	= parent.parent.f_header.document.prescription_header_form.bl_disp_charge_dtl_in_rx_yn.value;
	var take_home_medication	=  parent.parent.f_header.document.prescription_header_form.take_home_medication.value;
	var order_Date						= parent.parent.f_header.document.prescription_header_form.sys_date.value;
	var	episode_type					= parent.parent.f_header.document.prescription_header_form.actual_patient_class.value;

	if(episode_type!='')
		episode_type					= episode_type.substring(0,1);

	var dialogHeight= "68vh" ;
	var dialogWidth	= "72vw" ;
	var dialogTop = "169" ;
	var center = "1" ;
	var status="no";
	var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop;
	var arguments	= "" ;
	retVal = await top.window.showModalDialog("../../ePH/jsp/PrescriptionPreviewOrderFrames.jsp?patient_id="+patient_id+"&encounter_id="+encounter_id+"&date="+date+"&locn_code="+locn_code+"&pract_name="+encodeURIComponent(pract_name)+"&actual_patient_class="+actual_patient_class+"&bl_install_yn="+bl_install_yn+"&bl_disp_charge_dtl_in_rx_yn="+bl_disp_charge_dtl_in_rx_yn+"&take_home_medication="+take_home_medication+"&order_Date="+order_Date+"&episode_type="+episode_type,arguments,features);
	// added below if condition for ICN NO:32735 By chandrashekar raju
	if(retVal!= undefined && retVal=='R')
		document.preview.release_rx.click();
}

function resetDrugdetails(){

	var start_date=parent.f_header.document.prescription_header_form.sys_date.value;
	var priority=parent.f_header.document.prescription_header_form.priority.value;
	var patient_id=parent.f_header.document.prescription_header_form.patient_id.value;
	var encounter_id=parent.f_header.document.prescription_header_form.encounter_id.value;
	var patient_class=parent.f_header.document.prescription_header_form.patient_class.value;
	var act_patient_class=parent.f_header.document.prescription_header_form.actual_patient_class.value;
	var bed_num=parent.f_header.document.prescription_header_form.bed_num.value;
	var room_num=parent.f_header.document.prescription_header_form.room_num.value;
	var drug_db_interface_yn=parent.f_header.document.prescription_header_form.drug_db_interface_yn.value;
	var bl_install_yn =  parent.f_header.document.prescription_header_form.bl_install_yn.value;
	var bl_disp_charge_dtl_in_rx_yn =  parent.f_header.document.prescription_header_form.bl_disp_charge_dtl_in_rx_yn.value;
	var take_home_medication =  parent.f_header.document.prescription_header_form.take_home_medication.value;
	var trade_display_yn =  parent.f_header.document.prescription_header_form.trade_display_yn.value;
	var drug_db_duptherapy_yn =  parent.f_header.document.prescription_header_form.drug_db_duptherapy_yn.value;
	var drug_db_allergy_check_yn =  parent.f_header.document.prescription_header_form.drug_db_allergy_check_yn.value;
	var pract_id =  parent.f_header.document.prescription_header_form.pract_id.value;//ML_MMOH_CRF-01823
	var MAR_app_yn	= getMAR_app_yn(parent.f_header.document.prescription_header_form);

	var drug_code=parent.f_detail.document.prescription_detail_form.drug_code.value;
	var mode='modify';
	var srl_no=parent.f_detail.document.prescription_detail_form.srl_no.value;
	parent.f_detail.location.href="../../ePH/jsp/PrescriptionDetail_1.jsp?srl_no="+srl_no+"&drug_code="+drug_code+"&priority="+priority+"&start_date="+start_date+"&mode="+mode+"&patient_id="+patient_id+"&encounter_id="+encounter_id+"&patient_class="+patient_class+"&bed_num="+bed_num+"&room_num="+room_num+"&drug_db_interface_yn="+drug_db_interface_yn+"&bl_install_yn="+bl_install_yn+"&bl_disp_charge_dtl_in_rx_yn="+bl_disp_charge_dtl_in_rx_yn+"&MAR_app_yn="+MAR_app_yn+"&act_patient_class="+act_patient_class+"&take_home_medication="+take_home_medication+"&trade_display_yn"+trade_display_yn+"&drug_db_allergy_check_yn="+drug_db_allergy_check_yn+"&drug_db_duptherapy_yn="+drug_db_duptherapy_yn+"&pract_id="+pract_id;
}

function clearDrugdetails(sliding_scale_yn){

	var header_form;
	if(sliding_scale_yn=='Y')
		header_form = parent.parent.f_header.document.prescription_header_form;
	else
	{
		if( parent.f_header!=undefined && parent.f_header != null )
			header_form = parent.f_header.document.prescription_header_form;
		else
			header_form = parent.parent.f_header.document.prescription_header_form;
	}	
	var start_date=header_form.sys_date.value;
	var priority=header_form.priority.value;
	var patient_id=header_form.patient_id.value;
	var encounter_id=header_form.encounter_id.value;
	var patient_class=header_form.patient_class.value;
	var act_patient_class=header_form.actual_patient_class.value;
	var take_home_medication=header_form.take_home_medication.value;
	var trade_display_yn=header_form.trade_display_yn.value;

	var bed_num=header_form.bed_num.value;
	var room_num=header_form.room_num.value;
	var drug_db_interface_yn=header_form.drug_db_interface_yn.value;
	var drug_db_allergy_check_yn=header_form.drug_db_allergy_check_yn.value;
	var drug_db_duptherapy_yn=header_form.drug_db_duptherapy_yn.value;
	var bl_install_yn =  header_form.bl_install_yn.value;
	var pract_id =  header_form.pract_id.value;//ML-MMOH-CRF-01823
	var bl_disp_charge_dtl_in_rx_yn =  header_form.bl_disp_charge_dtl_in_rx_yn.value;
	var MAR_app_yn	= getMAR_app_yn(header_form);
	var mode='blank';

	if(sliding_scale_yn=='Y'){
		parent.parent.f_detail.location.href="../../ePH/jsp/PrescriptionDetail_1.jsp?priority="+priority+"&start_date="+start_date+"&mode="+mode+"&patient_id="+patient_id+"&encounter_id="+encounter_id+"&patient_class="+patient_class+"&bed_num="+bed_num+"&room_num="+room_num+"&drug_db_interface_yn="+drug_db_interface_yn+"&bl_install_yn="+bl_install_yn+"&bl_disp_charge_dtl_in_rx_yn="+bl_disp_charge_dtl_in_rx_yn+"&MAR_app_yn="+MAR_app_yn+"&act_patient_class="+act_patient_class+"&take_home_medication="+take_home_medication+"&trade_display_yn="+trade_display_yn+"&drug_db_allergy_check_yn="+drug_db_allergy_check_yn+"&drug_db_duptherapy_yn="+drug_db_duptherapy_yn+"&pract_id="+pract_id;
		parent.parent.f_button.location.href="../../ePH/jsp/PrescriptionButton_1.jsp?patient_id="+patient_id+"&mode="+mode+"&encounter_id="+encounter_id+"&patient_class="+patient_class+"&bed_num="+bed_num+"&room_num="+room_num+"&drug_db_interface_yn="+drug_db_interface_yn+"&act_patient_class="+act_patient_class+"&take_home_medication="+take_home_medication;
	}
	else{
		if(parent.f_detail!=undefined){	
			parent.f_detail.location.href="../../ePH/jsp/PrescriptionDetail_1.jsp?priority="+priority+"&start_date="+start_date+"&mode="+mode+"&patient_id="+patient_id+"&encounter_id="+encounter_id+"&patient_class="+patient_class+"&bed_num="+bed_num+"&room_num="+room_num+"&drug_db_interface_yn="+drug_db_interface_yn+"&bl_install_yn="+bl_install_yn+"&bl_disp_charge_dtl_in_rx_yn="+bl_disp_charge_dtl_in_rx_yn+"&MAR_app_yn="+MAR_app_yn+"&act_patient_class="+act_patient_class+"&take_home_medication="+take_home_medication+"&trade_display_yn="+trade_display_yn+"&drug_db_allergy_check_yn="+drug_db_allergy_check_yn+"&drug_db_duptherapy_yn="+drug_db_duptherapy_yn+"&pract_id="+pract_id;
			parent.f_button.location.href="../../ePH/jsp/PrescriptionButton_1.jsp?patient_id="+patient_id+"&mode="+mode+"&encounter_id="+encounter_id+"&patient_class="+patient_class+"&bed_num="+bed_num+"&room_num="+room_num+"&drug_db_interface_yn="+drug_db_interface_yn+"&act_patient_class="+act_patient_class+"&take_home_medication="+take_home_medication;
		}
		else if( parent.parent.f_detail !=undefined){
			parent.parent.f_detail.location.href="../../ePH/jsp/PrescriptionDetail_1.jsp?priority="+priority+"&start_date="+start_date+"&mode="+mode+"&patient_id="+patient_id+"&encounter_id="+encounter_id+"&patient_class="+patient_class+"&bed_num="+bed_num+"&room_num="+room_num+"&drug_db_interface_yn="+drug_db_interface_yn+"&bl_install_yn="+bl_install_yn+"&bl_disp_charge_dtl_in_rx_yn="+bl_disp_charge_dtl_in_rx_yn+"&MAR_app_yn="+MAR_app_yn+"&act_patient_class="+act_patient_class+"&take_home_medication="+take_home_medication+"&trade_display_yn="+trade_display_yn+"&drug_db_allergy_check_yn="+drug_db_allergy_check_yn+"&drug_db_duptherapy_yn="+drug_db_duptherapy_yn;
			parent.parent.f_button.location.href="../../ePH/jsp/PrescriptionButton_1.jsp?patient_id="+patient_id+"&mode="+mode+"&encounter_id="+encounter_id+"&patient_class="+patient_class+"&bed_num="+bed_num+"&room_num="+room_num+"&drug_db_interface_yn="+drug_db_interface_yn+"&act_patient_class="+act_patient_class+"&take_home_medication="+take_home_medication;
		}
	}
}

function validateDosageLimit(calling_mode){
	var ext_prod_id = document.prescription_detail_form.ext_prod_id.value;
	var in_formulary_yn = document.prescription_detail_form.in_formulary_yn.value;
	var qty_value	= document.prescription_detail_form.qty_value.value;
//Adding start for ML-MMOH-SCF-0864
	//var formObject  = parent.f_header.document.prescription_header_form;//Commented for ARYU-SCF-0033
	if(parent.f_header==null) {//Adding start for ARYU-SCF-0033
		var formObject	=	parent.parent.f_header.document.prescription_header_form;
	}
	else {
		var formObject	=	parent.f_header.document.prescription_header_form;
	}//Adding end for ARYU-SCF-0033

	var temp_qty ="";
	//formObject.height.value.length > 0 && //removed for ml-mmoh-crf-1914
		 if(formObject.weight.value.length > 0){
			 if(document.prescription_detail_form.calc_by_ind!=undefined){//Added if condition alone for ARYU-SCF-0033
				 if(document.prescription_detail_form.calc_by_ind.value=="W") {
					temp_qty	=	(parseFloat(qty_value)/parseFloat(formObject.weight.value));
				}
				else if(document.prescription_detail_form.calc_by_ind.value=="B") {
					temp_qty	=	(parseFloat(qty_value)/parseFloat(formObject.bsa.value));
					
			   }else
				 temp_qty=qty_value;
			 }else//Added for ARYU-SCF-0033
				 temp_qty=qty_value;
		 }

		 if(temp_qty=="") //added for ML-MMOH-SCF-1232
			 temp_qty = qty_value;
	//Adding end for ML-MMOH-SCF-0864 

	//	 alert("temp_qty@@=="+temp_qty);
	var frameobj;
	if(parent.f_header==null) {
		frameobj	=	parent.parent.f_header;
	}
	else {
		frameobj	=	parent.f_header;
	}
	if((qty_value==""  || parseFloat(qty_value==0))  && calling_mode!="freqChange" ) { // && calling_mode!="freqChange" Added for AAKH-SCF-0352
		alert(getMessage("PRES_DOSAGE_CANNOT_ZERO", "PH"));
		return false;
	}
  //Added for IN:070451 start
	var height=frameobj.document.prescription_header_form.height.value;
	var weight=frameobj.document.prescription_header_form.weight.value;
  //Added for IN:070451 end
	var patient_id=frameobj.document.prescription_header_form.patient_id.value;
	var bl_install_yn	=frameobj.document.prescription_header_form.bl_install_yn.value;
	var bl_disp_charge_dtl_in_rx_yn	=frameobj.document.prescription_header_form.bl_disp_charge_dtl_in_rx_yn.value;
	var drug_db_dosecheck_yn=frameobj.document.prescription_header_form.drug_db_dosecheck_yn.value;

	if(drug_db_dosecheck_yn == 'Y' && (ext_prod_id != '')){
		extDosageCheck(calling_mode);
	}
	else{
		
		var drug_code	= document.prescription_detail_form.drug_code.value;
		var dosage_type = document.prescription_detail_form.dosage_type.value;
		var srl_no		= document.prescription_detail_form.srl_no.value;
		//var calling_mode	= document.prescription_detail_form.calling_mode.value; //comented for the script error while taper
		var start_date	=	document.prescription_detail_form.start_date.value;
		var generic_id	=	document.prescription_detail_form.generic_id.value;
		var freq_code	=	document.prescription_detail_form.frequency.value;
		var freq_nature	=	document.prescription_detail_form.freq_nature.value;
		var calc_def_dosage_yn	=	document.prescription_detail_form.calc_def_dosage_yn.value;
		document.prescription_detail_form.qty_value.value = Math.abs(qty_value);

		var repeat_value= "";
		if(oldrepeatvalue==undefined)
			repeat_value = document.prescription_detail_form.repeat_value.value;
		else
			repeat_value =oldrepeatvalue;
		if(calling_mode=="taper") {
			srl_no	=	parseInt(srl_no) + 1;
		} 
		var absol_qty	=	document.prescription_detail_form.absol_qty.value;//commented for ml-mmoh-crf-1914
		var fldString=" patient_id=\""+ patient_id + "\" ";
		fldString += " qty_value=\""+ qty_value + "\" ";
	    fldString += " temp_qty=\""+ Math.abs(temp_qty) + "\" ";//Added for Ml-MMOH-SCF-0864
		fldString += " dosage_type=\""+ dosage_type + "\" ";
		fldString += " repeat_value=\""+ repeat_value + "\" ";
		fldString += " drug_code=\""+ drug_code + "\" ";
		fldString += " srl_no=\""+ srl_no + "\" ";
		fldString += " start_date=\""+ start_date + "\" ";	
		fldString += " generic_id=\""+ generic_id + "\" ";		
		fldString += " freq_code=\""+ freq_code + "\" ";		
		fldString += " freq_nature=\""+ freq_nature + "\" ";		
		fldString += " calc_def_dosage_yn=\""+ calc_def_dosage_yn + "\" ";		
		fldString += " absol_qty=\""+ absol_qty + "\" ";	//added for ml-mmoh-crf-1914
    //Added for IN:070451 start
		fldString += " height=\""+ height + "\" ";
		fldString += " weight=\""+ weight + "\" ";
    //Added for IN:070451 end
		var formobj=document.prescription_detail_form;
		var xmlStr=formXMLString(formobj,fldString);
		fieldValidation(xmlStr,"validateDosageLimit");
	}
	// note: calling_mode != "freqChange" added on 22/11/2010 by Srikanth to avoid multiple billing call
	if(bl_install_yn=='Y' && bl_disp_charge_dtl_in_rx_yn=='Y' && in_formulary_yn == 'Y' && flagbilling == 'N'){// && calling_mode != "freqChange"){//added flagbilling for performance issue MMS
		getChargeDetails(in_formulary_yn);
	} 
	return;
}

function enableDosageLimit(limit_ind,daily_dose,unit_dose,mono_graph, min_daily_dose, min_unit_dose,dose_unit, srl_no,dose_unit_desc,max_daily_ceeling_dose,min_daily_ceeling_dose,max_unit_ceeling_dose,min_unit_ceeling_dose,dose_unit_desc1,overide_symbol){  // dose_unit_desc added for ML-MMOH-SCF-0633 [IN:063271], Modified for IN:070451,Modified for IN:073485
	// srl_no in parameter list added for	SRR20056-SCF-7690 IN 27798 & 28440 - Start
	var drug_desc ='';
	var dosage_std='';
	var dose_override = ''
//added for	SRR20056-SCF-7690 IN 27798 & 28440 - End
	if(document.getElementById('dosage_limit')==null) {
		frmObj	=	parent.f_sliding_scale_dtls.prescription_detail_form;
		frmObj.dosage_limit.style.visibility="visible";
		frmObj.override_remarks.style.visibility="visible";
		frmObj.limit_ind.value=limit_ind;
		frmObj.daily_dose.value=daily_dose;
		frmObj.unit_dose.value=unit_dose;
		frmObj.mono_graph.value=unescape(mono_graph);
		frmObj.min_daily_dose.value=min_daily_dose;
		frmObj.dosage_unit.value=dose_unit;
		//frmObj.dosage_limit.style='display';
//added for	SRR20056-SCF-7690 IN 27798 & 28440 - Start
		drug_desc = encodeURIComponent(frmObj.drug_name.value);
		drug_desc=drug_desc.replace(/'/g, "%27"); // Added for MMS-DM-SCF-0458
		dosage_std = frmObj.dosage_std.value;
		dose_override = frmObj.overrided_yn.value;
//added for	SRR20056-SCF-7690 IN 27798 & 28440 - End
	}
	else {
		document.getElementById('dosage_limit').style.visibility="visible";
		document.getElementById('override_remarks').style.visibility="visible";
		document.prescription_detail_form.limit_ind.value=limit_ind;
		document.prescription_detail_form.daily_dose.value=daily_dose;
		document.prescription_detail_form.unit_dose.value=unit_dose;
		document.prescription_detail_form.mono_graph.value=unescape(mono_graph);
		document.prescription_detail_form.min_daily_dose.value=min_daily_dose;
		document.prescription_detail_form.min_unit_dose.value=min_unit_dose;
		document.prescription_detail_form.dosage_unit.value=dose_unit;
		//document.prescription_detail_form.dosage_limit.style='display';
//added for	SRR20056-SCF-7690 IN 27798 & 28440 - Start
		drug_desc = encodeURIComponent(document.prescription_detail_form.drug_name.value); 
		drug_desc=drug_desc.replace(/'/g, "%27"); // Added for MMS-DM-SCF-0458
		dosage_std = document.prescription_detail_form.dosage_std.value;
		dose_override = document.prescription_detail_form.dose_override.value;
//added for	SRR20056-SCF-7690 IN 27798 & 28440 - End
	}
//added for	SRR20056-SCF-7690 IN 27798 & 28440 - start
	var sliding_scale_yn =document.prescription_detail_form.sliding_scale_yn.value;
	if(sliding_scale_yn == 'Y')
		var frmObjform_1 = parent.parent.f_prescription.f_prescription_form.prescription_form;
	else
		var frmObjform_1 = parent.f_prescription.f_prescription_form.prescription_form;
	var dosagemit_ind = frmObjform_1.td_dosage_override+srl_no;
	dosagemit_ind.className="DOSELIMIT";
	dosagemit_ind.title = getLabel("ePH.ExceedDosageLimit.label","PH");
	dosagemit_ind.onmouseover =  new Function('changeCursor(this);');
	dosagemit_ind.onclick = new Function( "showMonoGraph('"+drug_desc+"','"+mono_graph+"','"+daily_dose+"','"+unit_dose+"','"+min_daily_dose+"','"+min_unit_dose+"','"+dose_unit+"','"+dosage_std+"','"+dose_unit_desc+"','"+max_daily_ceeling_dose+"','"+min_daily_ceeling_dose+"','"+max_unit_ceeling_dose+"','"+min_unit_ceeling_dose+"','"+dose_unit_desc1+"');"); // dose_unit_desc Added for ML-MMOH-SCF-0633 [IN:063271], Modified for IN:070451
	if((dose_override!=null && dose_override=="N") || overide_symbol=="Y")//Modified for IN:073485
		dosagemit_ind.innerHTML = "<img src='../../ePH/images/exceed1.gif' ></img>";
//added for	SRR20056-SCF-7690 IN 27798 & 28440- end
}

function disableDosageLimit(srl_no,drug_code){
	try{
		if(document.prescription_detail_form.current_rx==null) {
			frmObj	=	parent.f_sliding_scale_dtls.prescription_detail_form;
			var current_rx= frmObj.current_rx.value;
			var allergy_yn= frmObj.allergy_yn.value;
			var interaction_exists= frmObj.interaction_exists.value;
			var abuse_exists= frmObj.abuse_exists.value;//added for AAKH-CRF-0140
			var abuse_action= frmObj.abuse_action.value;//added for AAKH-CRF-0140
		//	alert("abuse_exists"+abuse_exists+"abuse_action"+abuse_action);
			frmObj.limit_ind.value="Y";
			//modified for aakh-crf-0140
			if(current_rx=="N" && allergy_yn=="N" && interaction_exists!="Y" && (abuse_exists!="Y" && abuse_action!="B")){
				//frmObj.dosage_limit.style.display="none";
				frmObj.dosage_limit.style.visibility="hidden";
				frmObj.override_remarks.style.visibility="hidden";
				frmObj.daily_dose.value="";
				frmObj.unit_dose.value="";
				frmObj.mono_graph.value="";
			}
		} 
		else {
			var current_rx= document.prescription_detail_form.current_rx.value;
			var allergy_yn= document.prescription_detail_form.allergy_yn.value;
			var interaction_exists= document.prescription_detail_form.interaction_exists.value;
			var abuse_exists= document.prescription_detail_form.abuse_exists.value;//added for AAKH-CRF-0140
			var abuse_action= document.prescription_detail_form.abuse_action.value;//added for AAKH-CRF-0140
		//	alert("abuse_exists"+abuse_exists+"abuse_action"+abuse_action);
			document.prescription_detail_form.limit_ind.value="Y";
			//modified for aakh-crf-0140
			if(current_rx=="N" && allergy_yn=="N" && interaction_exists!="Y" && (abuse_exists!="Y" && abuse_action!="B")){
				//document.prescription_detail_form.dosage_limit.style.display="none";
				document.getElementById('dosage_limit').style.visibility="hidden";
				document.getElementById('override_remarks').style.visibility="hidden";
				document.prescription_detail_form.daily_dose.value="";
				document.prescription_detail_form.unit_dose.value="";
				document.prescription_detail_form.mono_graph.value="";
			}
		}
		//added for	SRR20056-SCF-7690 IN 27798 & 28440 - Start
		var sliding_scale_yn =document.prescription_detail_form.sliding_scale_yn.value; 
		if(sliding_scale_yn == 'Y')
			var frmObjform_1 = parent.parent.f_prescription.f_prescription_form.prescription_form;
		else
			var frmObjform_1 = parent.f_prescription.f_prescription_form.prescription_form;
		var dosagemit_ind = eval(frmObjform_1.document.getElementById("td_dosage_override"+srl_no));
		//var dosagemit_ind = frmObjform_1.document.getElementById('td_dosage_override'+srl_no);
		/*alert(getElementById('frmObjform_1.document.getElementById("drug_")'+drug_code+'_'+srl_no))
		var drugDescTD = eval('frmObjform_1.document.getElementById("drug_")'+drug_code+'_'+srl_no);//Commented for ML-MMOH-SCF-1974
		if(drugDescTD.className != 'FOCUSDRUGS'){
			dosagemit_ind.className=drugDescTD.className;
		}
		else{*///commenting end for ML-MMOH-SCF-1974
			var amend_yn = eval('frmObjform_1.amend_yn_'+srl_no).value;
			if(amend_yn == 'Y')
				dosagemit_ind.className = 'AMENDEDDRUGS';
			else
				dosagemit_ind.className = 'SELECTEDRUGS';
		//}//commenting end for ML-MMOH-SCF-1974
		dosagemit_ind.title = '';
		dosagemit_ind.onmouseover = '';
		dosagemit_ind.onclick = "";
		dosagemit_ind.innerHTML = "&nbsp;";
	}
	catch(e){
	}
	//added for	SRR20056-SCF-7690 IN 27798 & 28440 - End
}

async function showMonoGraph(drug_desc,mono_graph,daily_dose,unit_dose,min_daily_dose,min_unit_dose,dosage_unit, dosage_std,dose_unit_desc,max_daily_ceeling_dose,min_daily_ceeling_dose,max_unit_ceeling_dose,min_unit_ceeling_dose,dose_unit_desc1){ // dose_unit_desc Added for ML-MMOH-SCF-0633 [IN:063271], Modified for IN:070451
	var retVal;
	var dialogTop		= "";
 	var dialogHeight	= "65vh" ;
 	var dialogWidth		= "65vw" ;
	var dialogLeft		= "" ;
 	var features		= 'Width:' + dialogWidth +'; dialogHeight:' + dialogHeight + '; dialogWidth:' + dialogWidth +'; dialogLeft:' + dialogLeft +';  dialogTop:'+dialogTop +'; scroll=no; status=no';
 	var arguments		= "";
 	retVal 				=    await top.window.showModalDialog("../../ePH/jsp/PrescriptionDosageLimitMonoGraph.jsp?drug_desc="+drug_desc+"&mono_graph="+mono_graph+"&daily_dose="+daily_dose+"&unit_dose="+unit_dose+"&min_daily_dose="+min_daily_dose+"&min_unit_dose="+min_unit_dose+"&dosage_unit="+dosage_unit+"&dosage_std="+dosage_std+"&dose_unit_desc="+dose_unit_desc+"&max_daily_ceeling_dose="+max_daily_ceeling_dose+"&min_daily_ceeling_dose="+min_daily_ceeling_dose+"&max_unit_ceeling_dose="+max_unit_ceeling_dose+"&min_unit_ceeling_dose="+min_unit_ceeling_dose+"&dose_unit_desc1="+dose_unit_desc1,arguments,features); // encodeURIComponent(drug_desc) changed to decodeURIComponent(drug_desc) and dose_unit_desc added for ML-MMOH-SCF-0633 [IN:063271], Modified for IN:070451 //Removed Decode for drug_desc for IN073484
 	
}

async function showAllergyDetails(generic_id,patient_id,encounter_id, generic_name, drug_name ){
	var retVal;
	var dialogTop		= "";
 	var dialogHeight	= "30vh" ;
 	var dialogWidth		= "30vw" ;
	var dialogLeft		= "" ;
 	var features		= 'Width:' + dialogWidth +'; dialogHeight:' + dialogHeight + '; dialogWidth:' + dialogWidth +'; dialogLeft:' + dialogLeft +';  dialogTop:'+dialogTop +'; scroll=auto; status=no';
 	var arguments		= "";
 	retVal 				= await top.window.showModalDialog("../../ePH/jsp/PrescriptionAllergyDetailsFrames.jsp?generic_name="+generic_name+"&encounter_id="+encounter_id+"&generic_id="+generic_id+"&patient_id="+patient_id+"&drug_name="+ drug_name,arguments,features);
}

async function showMonoGraphDetail(){
	var drug_desc=document.prescription_detail_form.drug_name.value;
	var limit_ind= document.prescription_detail_form.limit_ind.value;
	var daily_dose= document.prescription_detail_form.daily_dose.value;
	var unit_dose=document.prescription_detail_form.unit_dose.value;
	var mono_graph = document.prescription_detail_form.mono_graph.value;

	var retVal;
	var dialogTop		= "310";
 	var dialogHeight	= "55vh" ;
 	var dialogWidth		= "60vw" ;
	var dialogLeft		= "180" ;
 	var features		= 'Width:' + dialogWidth +'; dialogHeight:' + dialogHeight + '; dialogWidth:' + dialogWidth +'; dialogLeft:' + dialogLeft +';  dialogTop:'+dialogTop +'; scroll=no; status=no';

 	var arguments		= "";
 	retVal 				= await window.showModalDialog("../../ePH/jsp/PrescriptionDosageLimitMonoGraph.jsp?drug_desc="+drug_desc+"&mono_graph="+mono_graph+"&daily_dose="+daily_dose+"&unit_dose="+unit_dose,arguments,features);
}

function alertNoTaper(error){

	refresh_screen=false;
	if(error=="greater"){
		alert(getMessage("PH_NO_TAPER_2", "PH"));
	}
	else if(error=="lesser") {
		alert(getMessage("PH_NO_TAPER_3", "PH"));
	}
	else if(error == 'changefreq'){
		alert(getMessage("PH_FREQ_NO_CHANGE", "PH"));
	}
	else if(error == 'stat_prn'){
	//	alert("stat prn");
	}
	else{
		alert(getMessage("PH_NO_TAPER_1", "PH"));
	}
	return false;
}

function chkQuantity(){

	var allow_refill	=parent.f_detail.document.prescription_detail_form.allow_refill.value;
	var no_refill		=parent.f_detail.document.prescription_detail_form.no_refill.value;
	var qty				=parent.f_detail.document.prescription_detail_form.qty_value.value;
	var qty_desc		=parent.f_detail.document.prescription_detail_form.qty_desc.value;
	var durn_desc		=parent.f_detail.document.prescription_detail_form.durn_desc.value;
	var repeat_durn_type=parent.f_detail.document.prescription_detail_form.repeat_durn_type.value;
	var strength_uom_code=parent.f_detail.document.prescription_detail_form.strength_uom.value;
	var freq_value=parent.f_detail.document.prescription_detail_form.freq_value.value;
	var freq=parent.f_detail.document.prescription_detail_form.frequency.value;
	var durn_val= parent.f_detail.document.prescription_detail_form.durn_value.value;
	var duration="";

	var split_dose_yn=parent.f_detail.document.prescription_detail_form.split_dose.disabled;

	if(durn_desc=='H' || durn_desc=='M'){
		duration=parent.f_detail.document.prescription_detail_form.calcualted_durn_value.value;
	}
	else{
		if(freq_value!='0'){
			duration=parent.f_detail.document.prescription_detail_form.durn_value.value;
		}
		else{
			duration=parent.f_detail.document.prescription_detail_form.calcualted_durn_value.value;
		}
	}

	var interval_value=parseInt(parent.f_detail.document.prescription_detail_form.interval_value.value);
	var repeat_value=parseInt(parent.f_detail.document.prescription_detail_form.repeat_value.value);

	if(parent.f_detail.document.prescription_detail_form.dosage.value=='Q'){
		if(parent.f_detail.document.prescription_detail_form.strength_value!=""){
			if(parent.f_detail.document.prescription_detail_form.pres_base_uom.value!=parent.f_detail.document.prescription_detail_form.qty_desc.value){
				var formobj=parent.f_detail.document.prescription_detail_form;
				var fldString="  strength_uom=\""+ parent.f_detail.document.prescription_detail_form.strength_uom.value + "\" ";
				fldString += " qty_uom=\""+ parent.f_detail.document.prescription_detail_form.qty_desc.value + "\" ";
				var xmlStr=formXMLString(formobj,fldString);
				fieldValidation(xmlStr,"calculateQuantity");
				if(parent.f_detail.document.prescription_detail_form.conv_factor.value!=""){
					var val_1=parseInt(parent.f_detail.document.prescription_detail_form.conv_factor.value);
					if(val_1 != ""){
						qty=qty*parseInt(repeat_value)*parseInt(duration);
						qty=(qty/val_1)
					}
					else{
						alert(getMessage("PH_NO_EQUVL", "PH"));
					}
				}
			}
		}

		qty=qty*parseInt(repeat_value)*parseInt(duration);

		var val_1=parseInt(parent.f_detail.document.prescription_detail_form.strength_per_pres_uom.value);
		var val_2=parseInt(parent.f_detail.document.prescription_detail_form.strength_per_value_pres_uom.value);
		var strength_value=parseInt(parent.f_detail.document.prescription_detail_form.strength_value.value);
		var tot_strength="";
		var tot_strength_uom="";
		if(strength_value>0){
			var tot_strength=( ( (val_1/val_2)) * qty );
			tot_strength_uom=strength_uom_code;
		}
		else{
			tot_strength="0";
			tot_strength_uom="";
		}

		var dispensed_qty=parseInt(qty);
		var bms_qty=parseInt(qty);
		var bms_strength=tot_strength;
		var strength_value=strength_value;
		var strength_uom=tot_strength_uom;
		var pres_qty_value=parent.f_detail.document.prescription_detail_form.qty_value.value;
		var pres_qty_uom=parent.f_detail.document.prescription_detail_form.qty_desc.value;
		parent.f_detail.document.prescription_detail_form.in_dispensed_qty.value=dispensed_qty;
		parent.f_detail.document.prescription_detail_form.in_dispensed_uom.value=parent.f_detail.document.prescription_detail_form.qty_desc.value;
		parent.f_detail.document.prescription_detail_form.in_bms_qty.value=bms_qty;
		parent.f_detail.document.prescription_detail_form.in_strength_value.value=strength_value;
		parent.f_detail.document.prescription_detail_form.in_strength_uom.value=strength_uom;
		parent.f_detail.document.prescription_detail_form.in_pres_qty_value.value=pres_qty_value;
		parent.f_detail.document.prescription_detail_form.in_pres_qty_uom.value=pres_qty_uom;
		parent.f_detail.document.prescription_detail_form.in_total_strength.value=tot_strength;
		parent.f_detail.document.prescription_detail_form.in_total_strength_uom.value=tot_strength_uom;
	}

	if(parent.f_detail.document.prescription_detail_form.dosage.value=='S'){
		var val_1=parseInt(parent.f_detail.document.prescription_detail_form.strength_per_pres_uom.value);
		var val_2=parseInt(parent.f_detail.document.prescription_detail_form.strength_per_value_pres_uom.value);
		var val_3=parseInt(parent.f_detail.document.prescription_detail_form.strength_value.value);
		var strength_value=parseInt(parent.f_detail.document.prescription_detail_form.strength_value.value);
		var val_4=qty;

		if(split_dose_yn=="true"){
			val_3=parseInt(qty)*parseInt(repeat_value)*parseInt(duration);
		}
		else{
			val_3=parseInt(qty)*parseInt(duration);
		}
		qty=( ( (val_2/val_1)) * val_3 );
		var tot_strength="";
		var tot_strength_uom="";
		tot_strength=val_3;
		tot_strength_uom=strength_uom_code;
		var dispensed_qty=parseInt(qty);
		var bms_qty=parseInt(qty);
		var bms_strength=tot_strength;
		var strength_value=strength_value;
		var strength_uom=tot_strength_uom;
		var pres_qty_value=parent.f_detail.document.prescription_detail_form.qty_value.value;
		var pres_qty_uom=parent.f_detail.document.prescription_detail_form.qty_desc.value;
		parent.f_detail.document.prescription_detail_form.in_dispensed_qty.value=dispensed_qty;
		parent.f_detail.document.prescription_detail_form.in_dispensed_uom.value=parent.f_detail.document.prescription_detail_form.qty_desc.value;
		parent.f_detail.document.prescription_detail_form.in_bms_qty.value=bms_qty;
		parent.f_detail.document.prescription_detail_form.in_strength_value.value=strength_value;
		parent.f_detail.document.prescription_detail_form.in_strength_uom.value=strength_uom;
		parent.f_detail.document.prescription_detail_form.in_pres_qty_value.value=pres_qty_value;

		parent.f_detail.document.prescription_detail_form.in_pres_qty_uom.value=pres_qty_uom;
		parent.f_detail.document.prescription_detail_form.in_total_strength.value=tot_strength;
		parent.f_detail.document.prescription_detail_form.in_total_strength_uom.value=tot_strength_uom;
	}

	if(parent.f_detail.document.prescription_detail_form.dosage.value=='A'){
		var tot_strength="0";
		var tot_strength_uom="";
		if(split_dose_yn=="true"){
			qty=qty;
		}
		else{
			qty=qty;
		}

		var pres_qty_value=parent.f_detail.document.prescription_detail_form.qty_value.value;
		var pres_qty_uom=parent.f_detail.document.prescription_detail_form.qty_desc.value;
		var strength_value=parseInt(parent.f_detail.document.prescription_detail_form.strength_value.value);
		var strength_uom=strength_uom_code;
		var dispensed_qty=parseInt(qty);
		var bms_qty=parseInt(qty);
		var bms_strength=tot_strength;
		parent.f_detail.document.prescription_detail_form.in_dispensed_qty.value=dispensed_qty;
		parent.f_detail.document.prescription_detail_form.in_dispensed_uom.value=parent.f_detail.document.prescription_detail_form.qty_desc.value;
		parent.f_detail.document.prescription_detail_form.in_bms_qty.value=bms_qty;
		parent.f_detail.document.prescription_detail_form.in_strength_value.value=strength_value;
		parent.f_detail.document.prescription_detail_form.in_strength_uom.value=strength_uom;
		parent.f_detail.document.prescription_detail_form.in_pres_qty_value.value=pres_qty_value;
		parent.f_detail.document.prescription_detail_form.in_pres_qty_uom.value=pres_qty_uom;
		parent.f_detail.document.prescription_detail_form.in_total_strength.value=tot_strength;
		parent.f_detail.document.prescription_detail_form.in_total_strength_uom.value=tot_strength_uom;
		return true;
	}
	else{
		return true;
	}
}

function updateConvFactor(conv_factor){

	if(conv_factor!=''){
		parent.f_detail.document.prescription_detail_form.conv_factor.value=conv_factor;
	}
	else{
		parent.f_detail.document.prescription_detail_form.conv_factor.value="";
	}
}

async function showRecords(print_ord_sht_rule_ind){
	var patient_id=parent.parent.f_header.document.prescription_header_form.patient_id.value;
	var encounter_id=parent.parent.f_header.document.prescription_header_form.encounter_id.value;
	var patient_class=parent.parent.f_header.document.prescription_header_form.patient_class.value;
	var dialogHeight= "100" ;
	var dialogWidth	= "200" ;
	var dialogTop = "10" ;
	var dialogLeft = "10" ;
	var center = "1" ;
	var status="no";
	var scroll="yes";
	var features	= "dialogLeft:" + dialogLeft + ";dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; center: " + center + ";scroll "+scroll+"; status: " + status + "; dialogTop :" + dialogTop;
	var arguments	= "" ;
	retVal='TEST';

	var formObj = parent.parent.f_header.document.prescription_header_form;
	
/*	var allergy_conf_reqd_yn =formObj.allergy_conf_reqd_yn.value; //added for RUT-CRF-0064.1 [IN:041799]
	if(allergy_conf_reqd_yn){
		if(!getAllergyConf(allergy_conf_reqd_yn))
			return false;
	}*/

	var weight_rec_appl_age_group_check_flag = formObj.weight_rec_appl_age_group_check_flag.value;
	var wt_mand_yn =formObj.wt_mand_yn.value; //added for Bru-HIMS-CRF-079 IN[029945]
	var ht_mand_yn = formObj.ht_mand_yn.value; //added for Bru-HIMS-CRF-079 IN[029945]
	if(weight_rec_appl_age_group_check_flag == 'Y' || (wt_mand_yn == 'Y' && ht_mand_yn == 'Y')){
		if((formObj.height.value=="" || parseFloat(formObj.height.value)==0 ) && ( formObj.weight.value=="" || parseFloat(formObj.weight.value)==0)) {	
			alert(getMessage("PAT_HEIGHT_WEIGHT_BLANK","PH"));
			formObj.weight_rec_appl_age_group_check_flag.value = 'Y';
			formObj.weight.disabled=false;
			formObj.height.disabled=false;
			//formObj.height.focus();
			if(parent.frames[2].document.forms[0].rx_button_disable.value=="true")//Added for KDAH-SCF-0382 and commented if condition for SKR-SCF-1252 and comment removed for KDAH-CF-0640
               parent.frames[2].document.forms[0].release_rx.disabled=false;//Added for KDAH-SCF-0382
			return false;
		}
		else{
			if(formObj.height.value=="" || parseFloat(formObj.height.value)==0 ){
				formObj.height.disabled=false;
				formObj.height.focus();
				try{
					parent.parent.f_detail.document.prescription_detail_form.drug_name.value="";
				}
				catch(e){}
				alert(getMessage("PAT_HEIGHT_BLANK","PH"));
				if(parent.frames[2].document.forms[0].rx_button_disable.value=="true")//Added for KDAH-SCF-0382 and commented for SKR-SCF-1252 and comment removed for KDAH-CF-0640
                   parent.frames[2].document.forms[0].release_rx.disabled=false;//Added for KDAH-SCF-0382
				return false;
			}
			else if(formObj.weight.value=="" || parseFloat(formObj.weight.value) ==0){
				formObj.weight.disabled=false;
				formObj.weight.focus();
				try{
					parent.parent.f_detail.document.prescription_detail_form.drug_name.value="";
				}
				catch(e){}
				alert(getMessage("PAT_WEIGHT_BLANK","PH"));
				if(parent.frames[2].document.forms[0].rx_button_disable.value=="true")//Added for KDAH-SCF-0382 and acommented for SKR-SCF-1252 and comment removed for KDAH-CF-0640
                   parent.frames[2].document.forms[0].release_rx.disabled=false;//Added for KDAH-SCF-0382
				return false;
			}
		}
	}
	else{ //(else block) added for Bru-HIMS-CRF-079 IN[029945] - start
		if(wt_mand_yn == 'Y' && (formObj.weight.value=="" || parseFloat(formObj.weight.value) ==0)){
			formObj.weight.disabled=false;
			formObj.weight.focus();
			alert(getMessage("PAT_WEIGHT_BLANK","PH"));
			if(parent.frames[2].document.forms[0].rx_button_disable.value=="true")//Added for KDAH-SCF-0382 and commented for SKR-SCF-1252 and comment removed for KDAH-CF-0640
               parent.frames[2].document.forms[0].release_rx.disabled=false;//Added for KDAH-SCF-0382
			return false;
		}
		else if(ht_mand_yn == 'Y' && (formObj.height.value=="" || parseFloat(formObj.weight.value)==0)){
			formObj.height.disabled=false;
			formObj.height.focus();
			alert(getMessage("PAT_HEIGHT_BLANK","PH"));
			if(parent.frames[2].document.forms[0].rx_button_disable.value=="true")//Added for KDAH-SCF-0382 and commented for SKR-SCF-1252 and comment removed for KDAH-CF-0640
               parent.frames[2].document.forms[0].release_rx.disabled=false;//Added for KDAH-SCF-0382
			return false;
		}
	} //added for Bru-HIMS-CRF-079 IN[029945] -end
	if(formObj.witness_for_verbal_order_yn.value == "Y" && formObj.MAR.value=='MAV' && formObj.pract_id.value != formObj.login_user_prac_id.value){	 //Added for AAKH-CRF-0023[IN:038259]
		var witness_retVal = callWitnessAuth();
		if(parent.frames[2].document.forms[0].rx_button_disable.value=="true")//Added for KDAH-SCF-0382 and commented for SKR-SCF-1252 and comment removed for KDAH-CF-0640
               parent.frames[2].document.forms[0].release_rx.disabled=false;//Added for KDAH-SCF-0382
		if(!witness_retVal)
			return false;
	} 	//Added for AAKH-CRF-0023[IN:038259]
	
	if(retVal!=null){
		var formarray  =new Array(parent.parent.f_header.document.prescription_header_form);
		eval( formApply( formarray,PH_CONTROLLER) ) ;
		if( result ){
			//parent.frames[2].document.forms[0].release_rx.disabled=false; //added for SKR-SCF-1252 and commented  for KDAH-CF-0640
			if(top.content!=null && top.content!=undefined && !top.document.querySelectorAll("#dialog-body")) { 
				top.content.messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num="+message;
				onSuccess();
			}
			else {
				alert(getMessage("RECORD_INSERTED", "PH"));
				if(parent.parent.f_header.document.prescription_header_form.external_prescription.value =="true"){
					if(patient_class=='OP' || patient_class=='EM'){

						var fldString="";
						var formobj=parent.parent.f_header.document.prescription_header_form;
						var xmlStr=formXMLString(formobj,fldString);
						var xmlDoc = "" ;
						var xmlHttp = new XMLHttpRequest() ;
						xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
						xmlHttp.open("POST","PrescriptionValidation_2.jsp?func_mode=GET_TRNGROUPREF",false);
						xmlHttp.send(xmlDoc);
						responseText=xmlHttp.responseText ;
						responseText=trimString(responseText);

						if(responseText != undefined && responseText!=null && responseText!=""){
							var dialogHeight	="12vh" ;
							var dialogWidth	="30vw";
							var dialogTop	= "300" ;
							var dialogLeft	= "300" ;
							var center			= "1" ;
							var status			="no";
							var features	= "dialogHeight:" + dialogHeight +"; dialogLeft:"+dialogLeft+ "; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop;
							var arguments	= "";
							retVal = await window.showModalDialog("../../ePH/jsp/TokenListForOrders.jsp?trn_group_ref="+responseText,arguments,features);
						}
					}

					var patient_id=parent.parent.f_header.document.prescription_header_form.patient_id.value;
					var encounter_id=parent.parent.f_header.document.prescription_header_form.encounter_id.value;
					var patient_class="XT";
					var locn_code=parent.parent.f_header.document.prescription_header_form.source_code.value;
					var print_yn="N";
					var print_confirm=""; //Added for Bru-HIMS-CRF-393_1.0-Start
					if(print_ord_sht_rule_ind==""){	//Code commented for HSA-SCF-0036[IN050011] --Start	
						var patient_id=parent.parent.f_detail.document.prescription_detail_form.patient_id.value;
						var encounter_id=parent.parent.f_detail.document.prescription_detail_form.encounter_id.value;
						var fldString=" patient_id=\""+ patient_id + "\" ";
						fldString+=" encounter_id=\""+ encounter_id + "\" ";
						var formobj=parent.parent.f_header.document.prescription_header_form;
						var xmlStr=formXMLString(formobj,fldString);
						var xmlDoc = "" ;
						var xmlHttp = new XMLHttpRequest() ;
						xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
						xmlHttp.open("POST","PrescriptionValidation_2.jsp?func_mode=Get_PrintOrderInd",false);
						xmlHttp.send(xmlDoc);
						responseText=xmlHttp.responseText ;
						responseText=trimString(responseText);
						print_ord_sht_rule_ind=responseText;
				    	}//Code commented for HSA-SCF-0036[IN050011] --End
					if(print_ord_sht_rule_ind=="C")
						print_confirm=confirm(getMessage("PH_PRINT_PRESCRIPTION", "PH"));
					 else if (print_ord_sht_rule_ind=="S")
						print_confirm="true"; //Added for Bru-HIMS-CRF-393_1.0-End
					/*var dialogHeight	="12" ;
					var dialogWidth	="30";
					var dialogTop	= "300" ;
					var dialogLeft	= "300" ;
					var center			= "1" ;
					var status			="no";
					var features	= "dialogHeight:" + dialogHeight +"; dialogLeft:"+dialogLeft+ "; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop;
					var arguments	= "";
					retVal = window.showModalDialog("../../ePH/jsp/PrescriptionPrintDialog.jsp",arguments,features);*/
					if(print_confirm){
						print_yn="Y";
						var fldString=" patient_id=\""+ patient_id + "\" ";
						fldString+=" encounter_id=\""+ encounter_id + "\" ";
						fldString+=" print_yn=\""+ print_yn + "\" ";
						fldString+=" patient_class=\""+ patient_class + "\" ";
						fldString+=" locn_code=\""+ locn_code + "\" ";
						fldString+=" prescriptionPrint=\""+ "Y" + "\" ";
						fldString+=" NarcoticPrint=\""+ "N" + "\" ";
						fldString+=" MARLabelPrint=\""+ "N" + "\" "; //added for MMS-QH-CRF-0080 [IN:038064]

						var formobj=parent.parent.f_header.document.prescription_header_form;
						var xmlStr=formXMLString(formobj,fldString);
						var source="onLinePrinting";
						var xmlDoc = "" ;
						var xmlHttp = new XMLHttpRequest() ;
						xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
						xmlHttp.open("POST","PrescriptionValidation_1.jsp?func_mode="+source,true);
						xmlHttp.send(xmlDoc);
						reloadPage_1();
					}
				}
				else{
					onSuccess();
				}
			//	console.log("Prescription_1.js line 5352 evada top.parent.window.close();");
				/*top.parent.window.close();*/
				top.document.querySelectorAll('#dialog_tag')[top.document.querySelectorAll('#dialog_tag').length-1].close();
			}
		}
		else{
			if(parent.frames[2].document.forms[0].rx_button_disable.value=="true")//Added for KDAH-SCF-0382 and commented for SKR-SCF-1252 and comment removed for KDAH-CF-0640
               parent.frames[2].document.forms[0].release_rx.disabled=false;//Added for KDAH-SCF-0382
			alert(getMessage("EXCEPTION_OCCURED_WHILE_INSERTION", "PH"));
		}
	}
}

function assignResult( _result, _message, _flag ) {
	result = _result ;
	message  = _message ;
	flag = _flag ;
}

async function reloadPage(print_ord_sht_rule_ind){//print_ord_sht_rule_ind,Added for Bru-HIMS-CRF-393_1.0
	var hdrFormObj = parent.parent.f_header.document.prescription_header_form;
	var patient_id=hdrFormObj.patient_id.value;
	var encounter_id=hdrFormObj.encounter_id.value;
	var patient_class=hdrFormObj.patient_class.value;
	var locn_code=hdrFormObj.source_code.value;	
	var narcotic_aprvl_form_req_yn     = hdrFormObj.narcotic_aprvl_form_req_yn.value;
	var print_narcotic_form_by_default = hdrFormObj.print_narcotic_form_by_default.value;
	var print_mar_label_yn = hdrFormObj.print_mar_label_yn.value; //added for MMS-QH-CRF-0080 [IN:038064]
	var buildMAR_yn = hdrFormObj.buildMAR_yn.value; //added for MMS-QH-CRF-0080 [IN:038064]

	var drug_class = parent.parent.f_prescription.f_prescription_form.prescription_form.drug_class.value;

	if(drug_class != "N"){
		narcotic_aprvl_form_req_yn      = "";
		print_narcotic_form_by_default  = "";
	}

	var print_yn="N";
	if(patient_class=='OP' || patient_class=='EM'){
		var fldString="";
		var formobj=parent.parent.f_header.document.prescription_header_form;
		var xmlStr=formXMLString(formobj,fldString);
		var xmlDoc = "" ;
		var xmlHttp = new XMLHttpRequest() ;
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open("POST","PrescriptionValidation_2.jsp?func_mode=GET_TRNGROUPREF",false);
		xmlHttp.send(xmlDoc);
		responseText=xmlHttp.responseText ;
		responseText=trimString(responseText);

		if(responseText != undefined && responseText!=null && responseText !=""){
			var dialogHeight	="29vh" ;
			var dialogWidth	="20vw";
			var dialogTop	= "25vh" ;
			var dialogLeft	= "-65vw" ;
			var center			= "1" ;
			var status			="no";
			var features	= "dialogHeight:" + dialogHeight +"; dialogLeft:"+dialogLeft+ "; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop;
			var arguments	= "";
			retVal = await top.window.showModalDialog("../../ePH/jsp/TokenListForOrders.jsp?trn_group_ref="+responseText,arguments,features);
		}
	}
//	var print_confirm=confirm(getMessage("PH_PRINT_PRESCRIPTION","PH"))
	var dialogHeight	="29vh" ;
	var dialogWidth	="20vw";
	var dialogTop	= "25vh" ;
	var dialogLeft	= "-65vw" ;
	var center			= "1" ;
	var status			="no";
	var features	= "dialogHeight:" + dialogHeight +"; dialogLeft:"+dialogLeft+ "; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop;
	var arguments	= "";
	
	//added for PH- print label issue start
	if(print_ord_sht_rule_ind=='null' || print_ord_sht_rule_ind==undefined || print_ord_sht_rule_ind==null ){
		print_ord_sht_rule_ind = "";
	}//end
	if((print_ord_sht_rule_ind=="C" || print_ord_sht_rule_ind=='') || (print_mar_label_yn=="Y" && buildMAR_yn=="Y") || narcotic_aprvl_form_req_yn=="Y" ){//print_ord_sht_rule_ind=="C" || print_ord_sht_rule_ind=='' added for Inc : 049877
		retVal = await top.window.showModalDialog("../../ePH/jsp/PrescriptionPrintDialog.jsp?narcotic_aprvl_form_req_yn="+narcotic_aprvl_form_req_yn+"&print_narcotic_form_by_default="+print_narcotic_form_by_default+"&called_from=RX"+"&buildMAR_yn="+buildMAR_yn+"&print_mar_label_yn="+print_mar_label_yn+"&print_ord_sht_rule_ind="+print_ord_sht_rule_ind,arguments,features);//print_ord_sht_rule_ind,Added for Bru-HIMS-CRF-393_1.0
	}	
	//if(print_confirm){
	if(((print_ord_sht_rule_ind=="C" || print_ord_sht_rule_ind=='') && retVal != undefined && retVal[0] != "CANCEL" ) || print_ord_sht_rule_ind =='S'){//print_ord_sht_rule_ind=="C" || print_ord_sht_rule_ind=='' added for Inc : 049877
		print_yn="Y";
		var fldString=" patient_id=\""+ patient_id + "\" ";
		fldString+=" encounter_id=\""+ encounter_id + "\" ";
		fldString+=" print_yn=\""+ print_yn + "\" ";
		fldString+=" patient_class=\""+ patient_class + "\" ";
		fldString+=" locn_code=\""+ locn_code + "\" ";
		if((print_ord_sht_rule_ind=="C" || print_ord_sht_rule_ind=='') && retVal.length >0){//print_ord_sht_rule_ind=="C" || print_ord_sht_rule_ind=='' added for Inc : 049877
			fldString+=" prescriptionPrint=\""+ retVal[0] + "\" ";
			fldString+=" NarcoticPrint=\""+ retVal[1] + "\" ";
			fldString+=" MARLabelPrint=\""+ retVal[2] + "\" "; //added for MMS-QH-CRF-0080 [IN:038064]
		}
		else if(print_ord_sht_rule_ind =='S')
			fldString+=" prescriptionPrint=\""+ "Y"+ "\" ";

		var formobj=parent.parent.f_header.document.prescription_header_form;
		var xmlStr=formXMLString(formobj,fldString);
		var source="onLinePrinting";
		var xmlDoc = "" ;
		var xmlHttp = new XMLHttpRequest() ;
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open("POST","PrescriptionValidation_1.jsp?func_mode="+source,true);
		xmlHttp.send(xmlDoc);
		reloadPage_1();
	}
	else{
		reloadPage_1();
		print_yn="N";			
	}
}
function printOnlinePrescription(formObj,okCancel,print_ord_sht_rule_ind){//pres_print,Added for Bru-HIMS-CRF-393_1.0
	 var retval= new Array();
	if(okCancel=='OK'){//If and Else If added for Bru-HIMS-CRF-393_1.0 
		if(print_ord_sht_rule_ind=="C" && formObj.prescriptionPrint.checked)
			retval[0]="Y";
		else if(print_ord_sht_rule_ind=="S")
			retval[0]="Y";
		else	
			retval[0]="N";
		if(formObj.NarcoticPrint != undefined && formObj.NarcoticPrint.checked)
			retval[1]="Y";
		else	
			retval[1]="N";
		if(formObj.MARLabel != undefined && formObj.MARLabel.checked) //if & else block added for MMS-QH-CRF-0080 [IN:038064]
			retval[2]="Y";
		else	
			retval[2]="N";
	}
	else{
        retval[0]='CANCEL';
	}
   //  window.returnValue=retval;
	 //window.close();
	/*let dialogBody = parent.parent.document.getElementById('dialog-body');
    dialogBody.contentWindow.returnValue = retval;
    
    const dialogTag = parent.parent.document.getElementById("dialog_tag");    
    dialogTag.close(); */
//	console.log(parent.parent.parent.parent.document.querySelectorAll('#dialog-body'))
//	console.log(parent.parent.parent.parent.parent.document.querySelectorAll('#dialog-body'))
	//console.log(parent.parent.parent.parent.parent.parent.document.querySelectorAll('#dialog-body'))
//	top.document.querySelectorAll('#dialog_tag')[top.document.querySelectorAll('#dialog_tag').length-1].close(); 
	if(top.document.querySelectorAll('#dialog_tag'))
	{
	top.document.querySelectorAll('#dialog-body')[top.document.querySelectorAll('#dialog-body').length-1].contentWindow.returnValue = retval;
	top.document.querySelectorAll('#dialog_tag')[top.document.querySelectorAll('#dialog_tag').length-1].close(); 
	}
	
}
function reloadPage_1(){
	parent.parent.parent.criteriaCategoryButtonFrame.location.reload();
}

function alertGenrericExist(){
	alert(getMessage("PH_GENERIC_NAME", "PH"));
}

function onSuccessForMIR(){
	var patient_id=parent.parent.f_detail.document.prescription_detail_form.patient_id.value;
	var encounter_id=parent.parent.f_detail.document.prescription_detail_form.encounter_id.value;
	var fldString=" patient_id=\""+ patient_id + "\" ";
	fldString+=" encounter_id=\""+ encounter_id + "\" ";
	var formobj=parent.parent.f_detail.document.prescription_detail_form;
	var xmlStr=formXMLString(formobj,fldString);

	var source="clearDataMedn";
	var xmlDoc = "" ;
    var xmlHttp = new XMLHttpRequest() ;
    xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
    xmlHttp.open("POST","PrescriptionValidation.jsp?func_mode="+source,false); //PrescriptionValidation_1.jsp to PrescriptionValidation.jsp for PMG2020-ICN-001
    xmlHttp.send(xmlDoc);
    responseText=xmlHttp.responseText ;
	eval(responseText);
}

function onSuccess(){
	if(parent.parent.f_header.prescription_header_form.sliding_scale.value!="Y") {
		var patient_id=parent.parent.f_detail.document.prescription_detail_form.patient_id.value;
		var encounter_id=parent.parent.f_detail.document.prescription_detail_form.encounter_id.value;
		var order_set_code = parent.parent.f_header.prescription_header_form.order_set_code.value;
		var pract_type = parent.parent.f_header.prescription_header_form.pract_type.value; //added for ML-BRU-SCF-0958 [IN:042045]
		var fldString=" patient_id=\""+ patient_id + "\" ";
		fldString+=" encounter_id=\""+ encounter_id + "\" ";
		fldString+="order_set_code=\""+ order_set_code + "\" ";
		fldString+="pract_type=\""+ pract_type + "\" "; //added for ML-BRU-SCF-0958 [IN:042045]
		var formobj=parent.parent.f_detail.document.prescription_detail_form;
		var xmlStr=formXMLString(formobj,fldString);
		var source="clearData";
		var xmlDoc = "" ;
		var xmlHttp = new XMLHttpRequest() ;
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open("POST","PrescriptionValidation_1.jsp?func_mode="+source,false);
		xmlHttp.send(xmlDoc);
		responseText=xmlHttp.responseText ;
		eval(responseText);
	}
	else {
		var patient_id     = parent.parent.f_header.prescription_header_form.patient_id.value;
		var encounter_id   = parent.parent.f_header.prescription_header_form.encounter_id.value;
		var fldString=" patient_id=\""+ patient_id + "\" ";
		fldString+=" encounter_id=\""+ encounter_id + "\" ";
		var formobj=parent.parent.f_header.prescription_header_form;
		//formobj.order_set_code.value = parent.parent.f_header.prescription_header_form.order_set_code.value;
		var xmlStr=formXMLString(formobj,fldString);
		var source="clearData";
		var xmlDoc = "" ;
		var xmlHttp = new XMLHttpRequest() ;
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open("POST","PrescriptionValidation_1.jsp?func_mode="+source,false);
		xmlHttp.send(xmlDoc);
		responseText=xmlHttp.responseText ;
		eval(responseText);
	}
}

async function loadDrugInfo(prodid,drugdesc){
	var dialogHeight	="85vh" ;
	var dialogWidth	="70vw";
	var dialogTop	= "110" ;
	var dialogLeft	= "80" ;
	var center			= "0" ;
	var status			="no";
	var features	= "dialogHeight:" + dialogHeight +"; dialogLeft:"+dialogLeft+ "; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop;
	var arguments	= "";
	retVal = await top.window.showModalDialog("../../ePH/jsp/DisplayDrugInfoFrames.jsp?extprodid="+prodid+"&drugdesc="+drugdesc+"&JSFile=../../ePH/js/Prescription_1.js",arguments,features);
}

function closeInfo(){
	this.window.close();
}

async function viewInteraction(patientid,orderid,encounterid){
	var dialogHeight	="38vh" ;
	var dialogWidth	="50vw";
	var dialogTop	= "270" ;
	var dialogLeft	= "200" ;
	var center			= "0" ;
	var status			="no";
	var features	= "dialogHeight:" + dialogHeight +"; dialogLeft:"+dialogLeft+ "; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop;
	var arguments	= "";
	retVal = await window.showModalDialog("../../ePH/jsp/DisplayInteractionsFrames.jsp?patientid="+patientid+"&encounterid="+encounterid+"&orderid="+orderid+"&JSFile=../../ePH/js/Prescription_1.js",arguments,features);
}

function closeInteraction(){
	this.window.close();
}
//added for AAKH-CRF-0140 start
async function viewAbuse(patientid,orderid,encounterid){
	var dialogHeight	="38vh" ;
	var dialogWidth	="50vw";
	var dialogTop	= "270" ;
	var dialogLeft	= "200" ;
	var center			= "0" ;
	var status			="no";
	var features	= "dialogHeight:" + dialogHeight +"; dialogLeft:"+dialogLeft+ "; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop;
	var arguments	= "";
	retVal = await window.showModalDialog("../../ePH/jsp/DisplayInteractionsFrames.jsp?patientid="+patientid+"&encounterid="+encounterid+"&orderid="+orderid+"&JSFile=../../ePH/js/Prescription_1.js",arguments,features);
}

function closeAbusen(){
	this.window.close();
}
//added for AAKH-CRF-0140 end
function checkSchedule(obj) {
	if(document.prescription_detail_form.init_qty!=null) {
		var init_value	=	document.prescription_detail_form.init_qty.value;
		if(document.getElementById("dosage_label").innerText==getLabel("ePH.DividedDose.label","PH")  && obj.value!=init_value) {
			document.prescription_detail_form.split_dose_chk.click();
		}
	}
}

function setfocus(obj) {
	obj.focus();
}

async function showDrugProfile(patient_id,called_frm,encounter_id){ // encounter_id added for AAKH-CRF-0088.2
	var pat_class	=	document.prescription_detail_form.patient_class.value;

	var dialogHeight	= "85vh";//"36" ;
	var dialogWidth		= "95vw";//"60" ;
	var dialogTop		= "10";//"152" ;
	var center			= "1" ;
	var status			= "no";
	var features		= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; center:" + center +"; status:" + status + "; dialogTop:" + dialogTop;
	var arguments		= "" ;
	retVal				= await top.window.showModalDialog( "../../ePH/jsp/QueryPatientDrugProfileFrames.jsp?patient_id="+encodeURIComponent(patient_id)+"&pat_class="+pat_class+"&called_frm=Prescription"+"&encounter_id="+encounter_id, arguments, features ); // encounter_id added for AAKH-CRF-0088.2
	//window.open( "../../ePH/jsp/QueryPatientDrugProfileFrames.jsp?patient_id="+encodeURIComponent(patient_id)+"&pat_class="+pat_class+"&called_frm=Prescription", arguments, features );
}

function storeSchedule() {
	var drug_code		= document.prescription_detail_form.drug_code.value;
	var start_date		= document.prescription_detail_form.start_date.value;
	var split_dose_yn	= document.prescription_detail_form.split_dose_yn_val.value; //priya 
	var qty_value		= document.prescription_detail_form.qty_value.value;
	var dose_uom = document.prescription_detail_form.qty_desc.value;  // added for SKR-SCF-0561 [IN:033486] 
	document.prescription_detail_form.init_qty.value = qty_value; //added for SRR20056-SCF-7428	27476

	var qty_uom       = document.prescription_detail_form.qty_desc.value; //added for IN23975 --28/09/2010-- priya
	var sliding_scale_yn="N";
	if(document.prescription_detail_form.sliding_scale_yn!=undefined)
		sliding_scale_yn= document.prescription_detail_form.sliding_scale_yn.value;
	if(sliding_scale_yn=="Y")
		qty_value = document.prescription_detail_form.absol_qty.value;
	//var freq_code		= document.prescription_detail_form.frequency.value;
	var freq_code		= document.prescription_detail_form.frequency.options[document.prescription_detail_form.frequency.selectedIndex].value;	
	var freq_nature	= document.prescription_detail_form.freq_nature.value;	
	var freq_desc = "";
	if(drug_code!="" && 	document.prescription_detail_form.frequency.options.length!=0)
		freq_desc		= encodeURIComponent(document.prescription_detail_form.frequency.options[document.prescription_detail_form.frequency.selectedIndex].text,"UTF-8");	

	var srl_no			= document.prescription_detail_form.srl_no.value;	
	var rowVal			= document.prescription_detail_form.rowVal.value;		
	var calling_mode	= document.prescription_detail_form.calling_mode.value;
	var scheduled_yn	= document.prescription_detail_form.scheduled_yn.value;
	var dosage_type =  document.prescription_detail_form.dosage_type.value; //added for IN24132 --07/10/2010-- priya
	var default_freq_not_found =false;//added for GHL-CRF-0508
	if(document.prescription_detail_form.default_freq_not_found!=undefined){ // if condition Added for script error ICN-67663 (this error came after commiting of GHL-CRF-0508) - Start
		default_freq_not_found=document.prescription_detail_form.default_freq_not_found.value;//added for GHL-CRF-0508
	} // if condition Added for script error (this error came after ICN-67663 commiting of GHL-CRF-0508) - End
	//if(calling_mode=="taper") {
		//srl_no	=	parseInt(srl_no)+1;
	//}
//added for GHL-CRF-0508 start
	if(!default_freq_not_found){
	if(freq_code == ""){
		alert(getMessage("SELECT_FREQUENCY", "PH"));
		document.prescription_detail_form.frequency.focus();
		return;
	   }
	}
//added for GHL-CRF-0508 end
	var fldString=" start_date=\""+ start_date + "\" ";
		fldString+=" split_dose_yn=\""+ split_dose_yn + "\" ";
		fldString+=" qty_value=\""+ qty_value + "\" ";
		fldString+=" freq_code=\""+ freq_code + "\" ";
		fldString += "freq_nature=\""+ freq_nature +"\" " ;
		fldString += "freq_desc=\""+ freq_desc +"\" " ;
		fldString+=" drug_code=\""+ drug_code + "\" ";
		fldString+=" srl_no=\""+ srl_no + "\" ";
		fldString+=" rowVal=\""+ rowVal + "\" ";
		fldString+=" scheduled_yn=\""+ scheduled_yn + "\" ";	
		fldString+=" qty_uom=\""+ qty_uom + "\" ";	//added for IN23975 --28/09/2010-- priya
		fldString+=" dosage_type=\""+ dosage_type + "\" "; //added for IN24132 --07/10/2010-- priya
		fldString+=" dose_uom=\""+ dose_uom + "\" ";  // added for SKR-SCF-0561 [IN:033486] 
	var formobj=document.prescription_detail_form;
	var xmlStr=formXMLString(formobj,fldString);
	fieldValidation(xmlStr,"storeSchedule");
	code	=	drug_code + srl_no;
	var fldString=" drug_code=\""+ code + "\" ";
	    fldString += " drug_codeOnly=\""+ drug_code + "\" ";
		fldString+=" srl_no=\""+ srl_no + "\" ";
	    fldString += " sliding_scale_yn=\""+ sliding_scale_yn + "\" ";
	var xmlStr=formXMLString(formobj,fldString);
	fieldValidation(xmlStr,"makeScheduleLink");
}

function ValidateAbs(obj, callFrom, tappered_over) {
	if(CheckPositiveNumber1(obj)){ 
		if(obj.value=="" || parseFloat(obj.value)< 1){ //parseInt((obj.value)==0 changed to parseFloat(obj.value)<= 1 and else condition added for IN25531 --22/12/2010 -- priya -- Modified parseFloat(obj.value)<= 1 to parseFloat(obj.value)< 1 for IN45356
			if(callFrom!='TAP_LVL_CHANGE'){
				if(callFrom == 'TOT_TAPER'){
					var msg = getMessage("PH_NOT_BLANK_ZERO_COMMON","PH");
					msg = msg.replace('$', getLabel("Common.total.label","Common")+" "+getLabel("Common.Taper.label","Common")+" "+getLabel("Common.Qty.label","Common"));
					alert(msg);
				}
				obj.value="1";
			}
			else{
				if(callFrom =='TAP_LVL_CHANGE'  ){
					if(tappered_over=='N' && parseFloat(obj.value)< 1){
						var msg = getMessage("PH_NOT_BLANK_ZERO_COMMON","PH");
						msg = msg.replace('$', getLabel("Common.total.label","Common")+" "+getLabel("Common.Level.label","Common")+" "+getLabel("Common.Qty.label","Common"));
						alert(msg);
						obj.value="1";
					}
					else
						if(parseFloat(obj.value)< 1)
							obj.value="0";
						else
							obj.value="1";
				}
				else{
					obj.value="0";
				}
			}
		}
		else
			obj.value = Math.abs(obj.value);
		return;
	}
	else{
		obj.value = "";
		return false;
	}
}

function lookForChange(obj) {
	if(obj!=undefined){
		var init_val	=	document.prescription_detail_form.init_qty.value;
		var curr_val	=	obj.value;
		if( prescription_detail_form.drug_code.value!="" && (curr_val==""|| parseFloat(curr_val)==0 )) {
			alert(getMessage("PRES_DOSAGE_CANNOT_ZERO", "PH"));
			return false;
		}
		if(obj.value!="" && parseFloat(curr_val)!=parseFloat(init_val)){ //obj.value!="" && parseFloat added for IN25596 reopen --24/12/2010-- priya
			document.prescription_detail_form.qty_value.value = Math.abs(curr_val);
			document.prescription_detail_form.init_qty.value = curr_val;
			//(document.prescription_detail_form.dosage.value=="A" && (document.prescription_detail_form.patient_class.value=="OP" || document.prescription_detail_form.patient_class.value=="EM"))|| --This part removed from the below if condition for IN23635 -- 17/09/2010 -- priya (Dosage was displaying wrongly in case of absolute order for Outpatients)
			if( document.prescription_detail_form.freq_nature.value=="P" ){
				deleteScheduleLink();
				DisableSchedule();
			}
			else {
				deleteScheduleLink();
				DisableSchedule();
				storeSchedule();
				if(!validateDosageLimit("lookForChange")){
					return false;
				}
				CheckPositiveNumber(obj);
				checkSchedule(obj); 
			}
		}
	}
}

function freqChange(obj,flag,sliding_scale_yn, callFrom,pBilling) {
	flagbilling = "Y";
	var in_formulary_yn = document.prescription_detail_form.in_formulary_yn.value;
	var def_disp_locn_appl_yn = document.prescription_detail_form.def_disp_locn_appl_yn.value;//Added for NMC-JD-SCF-0324
	if(callFrom==undefined || callFrom==null)
		callFrom="";
	if(prescription_detail_form.drug_code.value!=""){
		var ordPriority=document.prescription_detail_form.priority.value; //Added for MMS_BETA_0043 [IN:046240]
		var currPriority=""; //Added for MMS_BETA_0043 [IN:046240]
		var qty_value=document.prescription_detail_form.qty_value.value;
		/*if( qty_value==""|| parseFloat(qty_value)==0 ) {      // commented for AAKH-SCF-0352 - Start
			alert(getMessage("PRES_DOSAGE_CANNOT_ZERO", "PH"));
			document.prescription_detail_form.qty_value.value='0';
			document.prescription_detail_form.qty_value.focus();
			return false ;
		} */   // commented for AAKH-SCF-0352 - End
		populateDurationDesc(obj);
		checkForPRN(obj);
		if(document.prescription_detail_form.qty_value.value==''){
			document.prescription_detail_form.qty_value.value='0';
		}
//		prescription_detail_form.allow_duplicate.value != "Y" && removed for 
		if( callFrom == 'ChangeFreq' ) // added for MO-GN-5490 [IN:054620]
			checkDuplicateDrug(prescription_detail_form, obj.value, 'ChangeFreq');
		if( document.prescription_detail_form.freq_nature.value=="P" || document.prescription_detail_form.freq_nature.value=="O" || document.prescription_detail_form.sliding_scale_yn.value == 'Y'){  /*(document.prescription_detail_form.dosage.value=="A" && (document.prescription_detail_form.patient_class.value=="OP" || document.prescription_detail_form.patient_class.value=="EM") ) || */ // 'A' & 'OP' or 'EM' condition commented for IN27197 --17/05/2011-- priya
			if(document.prescription_detail_form.freq_nature.value == 'O'){ //if block added for SKR-SCF-0083.1 IN029245
				document.prescription_detail_form.tmp_durn_value.value='1';
				if(document.prescription_detail_form.sliding_scale_yn.value != 'Y'){
					var external_patient_id = document.prescription_detail_form.external_patient_id.value; //added for  [IN:040734]
					if(document.prescription_detail_form.priority.value!='U' && callFrom=='ChangeFreq' && external_patient_id ==""){ //external_patient_id  added for  [IN:040734]
						document.prescription_detail_form.priority.value='U';
						currPriority = document.prescription_detail_form.priority.value;
						if(ordPriority != currPriority)
							getBuildMARDefaulting();
						//defFreq(document.prescription_detail_form.priority);
					}
				}
			}
			else{
				if(document.prescription_detail_form.sliding_scale_yn.value != 'Y'){
					if(document.prescription_detail_form.freq_nature.value != 'O' && callFrom=='ChangeFreq'){
						document.prescription_detail_form.priority.value='R';
						currPriority = document.prescription_detail_form.priority.value;
						if(ordPriority != currPriority)
							getBuildMARDefaulting();
						//defFreq(document.prescription_detail_form.priority);
					}
					else if( callFrom=='ChangeFreq'){
						document.prescription_detail_form.priority.value='U';
						currPriority = document.prescription_detail_form.priority.value;
						if(ordPriority != currPriority)
							getBuildMARDefaulting();
					}
					//defFreq(document.prescription_detail_form.priority);//added for [IN:44163]
				}
			}
			document.prescription_detail_form.qty_value.value = Math.abs(qty_value);
			if(flag=="M" && (sliding_scale_yn!=undefined && sliding_scale_yn=="Y")){
				flag="Y";
			}
			else{
				deleteScheduleLink();		
				DisableSchedule1();	
				storeSchedule();
			}			
			if(document.prescription_detail_form.sliding_scale_yn.value == 'Y' ) {
				if(document.prescription_detail_form.freq_nature.value=="P"){
				   document.prescription_detail_form.btnSchedule.style.display='none';
				}
				if(document.prescription_detail_form.freq_nature.value!="O") {
					document.prescription_detail_form.absol_qty.style='display';
					document.getElementById("lgd_ord_qty").style='display';
					document.getElementById("lgd_qty_uom").style='display';
					document.prescription_detail_form.btnSchedule.style='display';
				}
			}
		}
		else {
			if(document.prescription_detail_form.freq_nature.value != 'O' && callFrom=='ChangeFreq'){
				document.prescription_detail_form.priority.value='R';
				currPriority = document.prescription_detail_form.priority.value;
				if(ordPriority != currPriority)
					getBuildMARDefaulting();
			}
			else if( callFrom=='ChangeFreq'){
				document.prescription_detail_form.priority.value='U';
				currPriority = document.prescription_detail_form.priority.value;
				if(ordPriority != currPriority)
					getBuildMARDefaulting();
			}
	
			if(document.prescription_detail_form.sliding_scale_yn.value == 'Y') {
				document.prescription_detail_form.btnSchedule.style='display';
				if((document.prescription_detail_form.freq_nature.value!="O")) {
					document.prescription_detail_form.absol_qty.style.display='none';
					document.getElementById("lgd_ord_qty").style.display='none';
					document.getElementById("lgd_qty_uom").style.display='none';
				}
			}
			if(flag=="M"){
				flag="Y";
			}
			else{
				deleteScheduleLink();
				DisableSchedule1();
				storeSchedule();
			}
			/* Looks like not used 
			if(!validateDosageLimit("freqChange")){
			//	return false;
			} */
			checkSchedule(document.prescription_detail_form.qty_value);
		}
		if(document.prescription_detail_form.tmp_durn_value != undefined){
			reloadDurnTypeList(sliding_scale_yn);
			populateEndDate();
		}
		if(document.prescription_detail_form.freq_nature.value=="P" || document.prescription_detail_form.freq_nature.value=="O"){
			document.prescription_detail_form.durn_desc.disabled = true;
		}
		else //else part added for [IN:044129]
			document.prescription_detail_form.durn_desc.disabled = false; 
		if( qty_value==""|| parseFloat(qty_value)==0 ) {      // Added for AAKH-SCF-0352 - Start

			if(document.prescription_detail_form.sliding_scale_yn.value!="Y") //added for TBMC-SCF-0166
			alert(getMessage("PRES_DOSAGE_CANNOT_ZERO", "PH"));
			document.prescription_detail_form.qty_value.value='0';
			document.prescription_detail_form.qty_value.focus();
			return false ;
		}   // Added for AAKH-SCF-0352 - End
	}
	if(ordPriority != currPriority && currPriority!=''){ //Added for MMS_BETA_0043 [IN:046240]
		getOrderCatalogAuthRule(); //Added for HSA-CRF-0150 [IN:048467]
		if(def_disp_locn_appl_yn =="N")//Added if condition alone for NMC-JD-SCF-0324
		 loadDispLocnForFreq(document.prescription_detail_form.priority.value);
	}
	if(pBilling!='pBilling')//added for performance issue MMS
		getChargeDetails(in_formulary_yn);//added for performance issue MMS
	flagbilling = "N";//added for performance issue MMS
}

function checkForPRN(obj) {
	if(document.prescription_detail_form.freq_nature.value=="P") {
		var headerFrame = "";
		if(parent.f_header != undefined)
			headerFrame = parent.f_header;
		else
			headerFrame = parent.parent.f_header;
		if(document.prescription_detail_form.prn_dose!=null) {
			document.prescription_detail_form.absol_qty.disabled	=	false;
			var prn_dose = parseInt(document.prescription_detail_form.prn_dose.value);
			if(prn_dose > 0)
				document.prescription_detail_form.absol_qty.value=document.prescription_detail_form.prn_dose.value;

			document.prescription_detail_form.absol_qty.style="display";
			document.getElementById("ord_qty_lbl").style="display";
			document.getElementById("ord_qty_uom").style="display";
			document.getElementById("prn_remarks").style.visibility	= "visible";
			document.getElementById("prn_yn").value= "Y";
			if(headerFrame.document.prescription_header_form.man_rem_on_prn_freq_yn != undefined && headerFrame.document.prescription_header_form.man_rem_on_prn_freq_yn.value == 'Y'){
				document.getElementById("prn_remarks_image").style.visibility	= "visible";
			}
			else{
               document.getElementById("prn_remarks_image").style.visibility	= "hidden";
			}
			document.getElementById("dis_split_dose").style.visibility	= "hidden";
		}
		ValidateAbs(document.prescription_detail_form.absol_qty);
	}
	else {
		if(document.prescription_detail_form.dosage_type.value!="A") {
			//document.prescription_detail_form.absol_qty.value		=	"";		//Commented for SRR20056-SCF7682
			document.prescription_detail_form.absol_qty.style.display ="none";
			document.getElementById("ord_qty_lbl").style.display	= "none";
			document.getElementById("ord_qty_uom").style.display	= "none";
			document.getElementById("prn_remarks").style.visibility	= "hidden";
			document.getElementById("prn_remarks_image").style.visibility	= "hidden";
			document.getElementById("dis_split_dose").style.visibility	= "visible";
		}
		else{
			document.getElementById("prn_remarks").style.visibility	= "hidden";
			document.getElementById("prn_remarks_image").style.visibility	= "hidden";
			document.getElementById("dis_split_dose").style.visibility	= "visible";
		}
	}
}

async function showPreviousOrders(){
	//alert("2");
	var patient_class	=	parent.f_header.document.prescription_header_form.patient_class.value;
	var pract_id		=	parent.f_header.document.prescription_header_form.pract_id.value;
	var patient_id		=	parent.f_header.document.prescription_header_form.patient_id.value;
	var encounter_id	=	parent.f_header.document.prescription_header_form.encounter_id.value;
	var iv_prep_yn	    =	parent.f_header.document.prescription_header_form.iv_prep_yn.value;
	var pract_type	    =	parent.f_header.document.prescription_header_form.pract_type.value;
	var discharge_ind	=	parent.f_header.document.prescription_header_form.take_home_medication.value;//Added for BRU-HIMS-CRF-403
	var dialogHeight= "67vh" ;
	var dialogWidth	=  "97vw" ;
	var dialogTop = "128" ;
	var dialogLeft = "20" ;
	var center = "1" ;
	var status="no";
	var scroll="no";
	var features	= "dialogLeft:" + dialogLeft + ";dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; center: " + center + ";scroll "+scroll+"; status: " + status + "; dialogTop :" + dialogTop;
	var arguments	= "" ;
	retVal = await top.window.showModalDialog("../../ePH/jsp/PrescriptionPrevOrders.jsp?patient_class="+patient_class+"&pract_id="+pract_id+"&patient_id="+patient_id+"&encounter_id="+encounter_id+"&rx_type="+iv_prep_yn+"&pract_type="+pract_type+"&discharge_ind="+discharge_ind+"&call_from=COPYPREVORDERS",arguments,features);
	if(retVal!=null && retVal!="") {
		updateOROrderType(parent.f_header.document.prescription_header_form.order_type.value);
		var Drugs = retVal.substring(0,retVal.indexOf("!")-1);
		var alldata = retVal.substring(retVal.indexOf("!"),retVal.length-13);
		var DrugsOrders = 0;
		DrugsOrders = alldata.split("!");
		temp = retVal.split(",");
		mode = temp[temp.length-1];
//m		updateOROrderCatalog(retVal.split(","));
		updateOROrderCatalog(Drugs.split(","));
		var trade_code = new Array((DrugsOrders.length)-1);
		var trade_name = new Array((DrugsOrders.length)-1);
		chkDuplicateDrugCode(Drugs,trade_code,trade_name,alldata,mode);
		parent.f_header.document.prescription_header_form.take_home_medication.disabled=true;
		parent.f_header.document.prescription_header_form.home_leave_yn_chk.disabled=true;
		if(parent.f_header.document.getElementById("tdPrescripionHdrDuration").style.visibility == 'visible'){
			parent.f_header.document.prescription_header_form.durn_value.disabled=true;
			parent.f_header.document.prescription_header_form.durn_desc.disabled=true;
		}
	}
	/*if(retVal!=null && retVal!="") {
		updateOROrderType(parent.f_header.document.prescription_header_form.order_type.value);
		temp = retVal.split(",");
//		for(i=temp.length-1;i>0;i--){
//				drug_code=trimString(temp[i]);
		
		mode = temp[temp.length-1];
		order_id = temp[temp.length-2];
		retVal = retVal.substring(0,retVal.indexOf(order_id)-1);
		updateOROrderCatalog(retVal.split(","));
		var trade_code = new Array(retVal.length);
		var trade_name = new Array(retVal.length);

	//	var obj = parent.f_detail.document.prescription_detail_form.trade_code_option;
	//	parent.f_detail.document.prescription_detail_form.trade_code.value = obj.options[0].value;
	//	parent.f_detail.document.prescription_detail_form.trade_name.value = obj.options[0].text;
	//	alert(parent.f_detail.document.prescription_detail_form.trade_code.value);

		chkDuplicateDrugCode(retVal,trade_code,trade_name,order_id,mode);
		parent.f_header.document.prescription_header_form.take_home_medication.disabled=true;
	}*/
}

function showPrevOrdersResults(){
	var pat_class		=	document.frmPrescriptionPrevOrdersCriteria.patient_class.value;
	var self			=	document.frmPrescriptionPrevOrdersCriteria.orders[0].checked;
	var ord_status		=	document.frmPrescriptionPrevOrdersCriteria.ord_status.value;
	var order_from		=	document.frmPrescriptionPrevOrdersCriteria.order_date_from.value;
	var order_to		=	document.frmPrescriptionPrevOrdersCriteria.order_date_to.value;
	var patient_id		=	document.frmPrescriptionPrevOrdersCriteria.patient_id.value;
	var encounter_id	=	document.frmPrescriptionPrevOrdersCriteria.encounter_id.value;
	var pat_id			=	document.frmPrescriptionPrevOrdersCriteria.pat_id.value;
	var prescription	=	document.frmPrescriptionPrevOrdersCriteria.group_by[0].checked;
	var rx_type	        =	document.frmPrescriptionPrevOrdersCriteria.rx_type.value;
	var group_by		=	"";
	var log_pract_id	=	document.frmPrescriptionPrevOrdersCriteria.pract_id.value;
	var pract_type	=	document.frmPrescriptionPrevOrdersCriteria.pract_type.value;
	//parent.parent.document.getElementById('discharerows').rows = '22%,70%,7%,0%';
	parent.document.getElementById("f_prev_orders_criteria").style.height="20vh";
	parent.document.getElementById("f_prev_orders_results").style.height="70vh";
	parent.document.getElementById("f_prev_orders_buttons").style.height="7vh";
	parent.document.getElementById("f_prev_orders_disc").style.height="0vh";

	if(order_from=="" || order_to=="") {
		alert(getMessage("PH_ORD_DATE_FM_TO_NOT_BLANK", "PH"));
	} 
	else {
		var pract_id		=	"";
		if(self==true)
			pract_id		= document.frmPrescriptionPrevOrdersCriteria.pract_id.value;
		else
			pract_id		= "";

		if(prescription==true)
			group_by		=	"PR";
		else
			group_by		=	"DR";

		parent.f_prev_orders_results.location.href   = "../../ePH/jsp/PrescriptionPrevOrdersResult.jsp?pat_class="+pat_class+"&pract_id="+pract_id+"&ord_status="+ord_status+"&order_from="+order_from+"&order_to="+order_to+"&pat_id="+pat_id+"&patient_id="+patient_id+"&encounter_id="+encounter_id+"&group_by="+group_by+"&rx_type="+rx_type+"&log_pract_id="+log_pract_id+"&call_from=SEARCH"+"&pract_type="+pract_type;
	}
}

function callButtonFrames(){
	var discharge_ind	=	parent.f_prev_orders_criteria.frmPrescriptionPrevOrdersCriteria.discharge_ind.value;//Added for BRU-HIMS-CRF-403
	var pat_id=parent.f_prev_orders_criteria.frmPrescriptionPrevOrdersCriteria.patient_id.value;//Added for BRU-HIMS-CRF-403
	var enc_id=parent.f_prev_orders_criteria.frmPrescriptionPrevOrdersCriteria.encounter_id.value;//Added for BRU-HIMS-CRF-403
	parent.f_prev_orders_buttons.location.href   = "../../ePH/jsp/PrescriptionPrevOrdersButtons.jsp?discharge_ind="+discharge_ind+"&pat_id="+pat_id+"&enc_id="+enc_id;//Modified for BRU-HIMS-CRF-403
}

function SubmitLink(from,to){
	var obj				=	document.frmPrescriptionPrevOrdersResult;
	copiedDrugs(obj, "Navigate");
	var rx_type = obj.rx_type.value;
	var sel_count =obj.checkcount.value;
	if(rx_type!='' && sel_count!=0){
		var confirm_nav	=confirm(getMessage("PH_PREVORDER_SELECTED_IV_ORDERS", "PH"));
		if(!confirm_nav){
			return;
		}
		obj.checkcount.value = 0;
	}
	//storeUpdatedSelection(obj);
	obj.from.value		=	from;
	obj.to.value		=	to;
	obj.submit();
}
function callPage(alpha){
	var form_obj				=	document.frmPrescriptionPrevOrdersResult;
	form_obj.drug_desc.value	=	alpha;
	form_obj.submit();
}

function checkValue(obj){
	if(obj.checked)
		obj.value	=	"Y";
	else
		obj.value	=	"N";
}

function duplicateWarning() {
	var msg		=	getMessage("PH_DUPLICATE_MEDICATION", "PH");	
	var all_msg	=	msg.split("||");
	alert(all_msg[0]+parent.f_detail.document.prescription_detail_form.generic_name.value+all_msg[1]); 
}

function dosageChange(obj) {
	if(obj.value!="") {
		var dosage_type = document.prescription_detail_form.dosage.value;
		var recomm_dosage_by = document.prescription_detail_form.recomm_dosage_by.value;

		if(obj.value=="A") {
			//deleteScheduleLink();
			//DisableSchedule();			
		}
		else {
			deleteScheduleLink();
			DisableSchedule1();
			if(obj.value=="S") {
				dfltStrnQtyDescList();
			}
			else {
				populateQtyDesc2();
			}
			validateQtyDesc(obj.value,'');
			storeSchedule();	
		}	
		if(document.getElementById('rec_legend').style.visibility=='visible'){
			if(dosage_type != recomm_dosage_by)
				document.getElementById('rec_legend_font').className='';
			else
				{
				
				document.getElementById('rec_legend_font').className='HYPERLINK'
					//added for ml-mmoh-crf-0978 start
					//alert(document.getElementById('default_recm_dose_yn').value);
					if(document.getElementById('default_recm_dose_yn').value =="Y" ){
						checkWtAndHt_recomm(prescription_detail_form);
					storeSchedule();
				}
				//added for ml-mmoh-crf-0978 end
					
				}
		}
	}
}

function disableItems(){
	
	var allow_without_diag=document.prescription_detail_form.allow_without_diag.value;
	if(allow_without_diag !="N"){
		if(document.prescription_detail_form.route_code!=null){	
			document.prescription_detail_form.route_code.disabled	=true;
			document.prescription_detail_form.dosage.disabled		=true;
			document.prescription_detail_form.qty_value.value		="";
			document.prescription_detail_form.qty_value.disabled	=true;
			document.prescription_detail_form.qty_desc.value		="";
			document.prescription_detail_form.qty_desc.disabled		=true;
			document.prescription_detail_form.frequency.disabled	=true;
			document.prescription_detail_form.durn_value.value		="";
			document.prescription_detail_form.durn_value.disabled	=true;
			document.prescription_detail_form.durn_desc.value		="";
			document.prescription_detail_form.durn_desc.disabled	=true;
			document.prescription_detail_form.end_date.disabled=true;
			document.prescription_detail_form.endDateImg.disabled=true;
			document.prescription_detail_form.start_date.value		="";
			document.prescription_detail_form.start_date.disabled	=true;
			//commented for enhancement FS Ref 3.36
			//document.prescription_detail_form.priority.disabled		=	true;
			if(document.prescription_detail_form.brought_by_pat!=null)
				document.prescription_detail_form.brought_by_pat.disabled	 =	true;

			document.getElementById('dosage_label').innerText =getLabel("ePH.Dose.label",'PH');
			document.prescription_detail_form.drug_name.focus();
		}
	}
}

function saveAndClose() {
	try{
		refill_vals	=	parent.refill_detail.refill_form.no_refill.value+","+parent.refill_detail.refill_form.refill_start_date.value+","+parent.refill_detail.refill_form.refill_end_date.value;
		window.returnValue	=refill_vals;
		window.close();
	}
	catch(e){
	}
}

//code added on 4/5/2004
function checkWtAndHt(frmObj){
	try{
		var formObject  = parent.f_header.document.prescription_header_form;
		var drug_db_dosecheck_yn = formObject.drug_db_dosecheck_yn.value;
		var ext_prod_id = document.prescription_detail_form.ext_prod_id.value;
		if(drug_db_dosecheck_yn!="Y" || ext_prod_id==""){
			if(formObject.height!=undefined && formObject.height!=null && formObject.weight!=null) {

				var weight		= formObject.weight.value;
				var bsa			= formObject.bsa.value;
				
				if(document.prescription_detail_form.recomm_yn.value=="Y") {
					document.getElementById('rec_legend').style.visibility='visible';
				}
			
				var dosage_type = document.prescription_detail_form.dosage.value;
				var recomm_dosage_by = document.prescription_detail_form.recomm_dosage_by.value;
			
				if(document.getElementById('rec_legend').style.visibility=='visible'){
					if(dosage_type != recomm_dosage_by)
						document.getElementById('rec_legend_font').className='';
					else
						document.getElementById('rec_legend_font').className='HYPERLINK'
				}

				var dosage_std	=	document.prescription_detail_form.dosage_std.value;
				var dosage_unit	=	document.prescription_detail_form.dosage_unit_uom.value;//code 'dosage_unit' replaced by dosage_unit_uom  for IN050721-->
				var title="<table border=1 cellpadding=0 cellspacing=0 align=center><tr><td class=TIP>&nbsp Std Dose: "+dosage_std+" "+dosage_unit+"&nbsp</td></tr></table>";
				if(document.prescription_detail_form.calc_by_ind.value=="A") {
					document.getElementById('rec_value').innerText	= dosage_std;
					document.getElementById('rec_uom').innerText		= dosage_unit;
					//if condtion added for ml-mmoh-crf-0978

					if(dosage_type == recomm_dosage_by  && document.getElementById('amend_yn').value !="Y"  && document.getElementById('default_recm_dose_yn').value =="Y" )
						document.getElementById('qty_value').value=dosage_std;							
							}
				else if(formObject.weight.value.length > 0){//formObject.height.value.length > 0 &&  removed for ML-MMOH-SCF-1142
					 if(document.prescription_detail_form.calc_by_ind.value=="W") {
						
						 var calc_value	=	parseFloat(parseFloat(weight)*parseFloat(dosage_std));//MODIFIED FOR ML-MMOH-SCF-1060
						 calc_value = calc_value.toFixed(2);//added FOR ML-MMOH-SCF-1060
						 calc_value=calc_value.toString();//added FOR ML-MMOH-SCF-1060
						
						document.getElementById('rec_value').innerHTML ="<label nowrap style='color:red;font-size:10' onmouseover='displayToolTipDataChange(\"" + title + "\");' onmouseout='disasbleToolTipDataChange();'>"+calc_value+"</label>";
						var dos_unit = dosage_unit.split("/");
						document.getElementById('rec_uom').innerHTML ="<label nowrap style='color:red;font-size:10' onmouseover='displayToolTipDataChange(\"" + title + "\");' onmouseout='disasbleToolTipDataChange();'>"+dos_unit[0]+"</label>";
						//if condtion added for ml-mmoh-crf-0978	
						if(dosage_type == recomm_dosage_by &&  document.getElementById('amend_yn').value !="Y" && document.getElementById('default_recm_dose_yn').value =="Y")
				                      	document.getElementById('qty_value').value=calc_value;
					}
					else if(formObject.height.value.length > 0 && document.prescription_detail_form.calc_by_ind.value=="B") {//formObject.height.value.length > 0 && ADDED FRO ML-MMOH-SCF-1142
						var calc_value	=	parseFloat(parseFloat(bsa)*parseFloat(dosage_std));//MODIFIED FOR ML-MMOH-SCF-1060
						calc_value = calc_value.toFixed(2);//added FOR ML-MMOH-SCF-1060
						 calc_value=calc_value.toString();//added FOR ML-MMOH-SCF-1060
						document.getElementById('rec_value').innerHTML ="<label nowrap style='color:red;font-size:10' onmouseover='displayToolTipDataChange(\"" + title + "\");' onmouseout='disasbleToolTipDataChange();'>"+calc_value+"</label>";
						var dos_unit = dosage_unit.split("/");
						document.getElementById('rec_uom').innerHTML ="<label nowrap style='color:red;font-size:10' onmouseover='displayToolTipDataChange(\"" + title + "\");' onmouseout='disasbleToolTipDataChange();'>"+dos_unit[0]+"</label>";
						//if condtion added for ml-mmoh-crf-0978
						if(dosage_type == recomm_dosage_by &&  document.getElementById('amend_yn').value !="Y" && document.getElementById('default_recm_dose_yn').value =="Y")
							document.getElementById('qty_value').value=calc_value;
					}
				}
			}
		}
	}
	catch(e){}
}

function recommendDosage(drug_code,modify,srl_no,order_idC,modeC, called_from) { //frmObj, removed for Bru-HIMS-CRF-079 IN[029945]
	formObj		= parent.parent.f_header.document.prescription_header_form;
	var wt_mand_yn = "N";
	var ht_mand_yn = "N";
	if(srl_no!=null && srl_no!=""){//added for Bru-HIMS-CRF-079 IN[029945] -start
		wt_mand_yn = eval("document.prescription_form.wt_mand_yn"+srl_no).value;
		ht_mand_yn = eval("document.prescription_form.ht_mand_yn"+srl_no).value;
		var weight_rec_appl_age_group_check_flag = eval("document.prescription_form.weight_rec_appl_age_group_check_flag"+srl_no).value;
		//added for Bru-HIMS-CRF-079 IN[029945] - start
		if(wt_mand_yn=='Y')
			formObj.wt_mand_yn.value="Y";
		if(ht_mand_yn=='Y')
			formObj.ht_mand_yn.value="Y";
	}

	if(weight_rec_appl_age_group_check_flag == 'Y'){
		if((formObj.height.value=="" || parseFloat(formObj.height.value)==0 ) && ( formObj.weight.value=="" || parseFloat(formObj.weight.value)==0)) {	
			formObj.weight.disabled=false;
			formObj.height.disabled=false;
			formObj.height.focus();
			try{
				parent.parent.f_detail.document.prescription_detail_form.drug_name.value="";
			}
			catch(e){}
			alert(getMessage("PAT_HEIGHT_WEIGHT_BLANK","PH"));
			formObj.weight_rec_appl_age_group_check_flag.value = 'Y';
			return false;
		}
		/*else{
			if(formObj.height.value==""){
				formObj.height.disabled=false;
				formObj.height.focus();
				try{
					parent.parent.f_detail.document.prescription_detail_form.drug_name.value="";
				}
				catch(e){}
				alert(getMessage("PAT_HEIGHT_BLANK","PH"));
				return false;
			}
			else if(formObj.weight.value==""){
				formObj.weight.disabled=false;
				formObj.weight.focus();
				try{
					parent.parent.f_detail.document.prescription_detail_form.drug_name.value="";
				}
				catch(e){}
				alert(getMessage("PAT_WEIGHT_BLANK","PH"));
				return false;
			}
		}*/
	}
	//else{
		if(wt_mand_yn == 'Y' && (formObj.weight.value==""  || parseFloat(formObj.height.value)==0 )){
			formObj.weight.disabled=false;
			formObj.weight.focus();
			try{
				parent.parent.f_detail.document.prescription_detail_form.drug_name.value="";
			}
			catch(e){}
			alert(getMessage("PAT_WEIGHT_BLANK","PH"));
			return false;
		}
		else if(ht_mand_yn == 'Y' && ( formObj.height.value==""|| parseFloat(formObj.weight.value)==0)){
			formObj.height.disabled=false;
			formObj.height.focus();
			try{
				parent.parent.f_detail.document.prescription_detail_form.drug_name.value="";
			}
			catch(e){}
			alert(getMessage("PAT_HEIGHT_BLANK","PH"));
			return false;
		}
	//}
	formObj.weight_rec_appl_age_group_check_flag.value = '';
	if( called_from=='defaultDrug'){ //if block added for Bru-HIMS-CRF-079 IN[029945]
		return;
	}
	if(srl_no!=null && srl_no!='null') 
		defaultDrug(drug_code,modify,srl_no,'','',order_idC,modeC);//taber dose not working
}

function checkweight_rec_appl(obj){
	formObj		= document.prescription_header_form;
	if(obj.value == "" && formObj.weight_rec_appl_age_group_check_flag.value == 'Y'){
		if(formObj.height.value=="" && formObj.weight.value==""){
			//formObj.height.focus();
			//formObj.height.focus();
		}
		else{
			/*if(formObj.height.value=="" )
				formObj.height.focus();
			else if( formObj.weight.value=="")
				formObj.weight.focus();
			*/
			try{
				parent.f_detail.document.prescription_detail_form.drug_name.value="";
			}
			catch(e){}
		//	alert(getMessage("PAT_HEIGHT_WEIGHT_BLANK","PH")); //commented for Bru-HIMS-CRF-079 IN[029945]
		}
		return false;
	}
	else if(formObj.height.value!="" && formObj.weight.value!="" && formObj.weight_rec_appl_age_group_check_flag.value==""){
		formObj.weight_rec_appl_age_group_check_flag.value = '';
		return;
	}
	else{
		if(obj.name == 'height'){
			if(formObj.weight.value=="" && formObj.weight_rec_appl_age_group_check_flag.value == 'Y' ){
				return false;
			}
		}
		if(obj.name=='weight'){
			if (formObj.height.value=="" && formObj.weight_rec_appl_age_group_check_flag.value == 'Y'){
				return false;
			}
		}
		if(formObj.height.value!="" && formObj.weight.value!="")
			formObj.weight_rec_appl_age_group_check_flag.value = '';
	}
	//obj.focus();
	return;
}

async function reloadMIR(){
	var patient_id		= parent.parent.f_detail.document.prescription_detail_form.patient_id.value;
	var encounter_id	= parent.parent.f_detail.document.prescription_detail_form.encounter_id.value;
	var patient_class	= parent.parent.f_header.document.prescription_header_form.patient_class.value;
	var locn_code		= parent.parent.f_header.document.prescription_header_form.source_code.value;
	var print_yn		= "N";
	if(patient_class=='OP' || patient_class=='EM'){
		var fldString="";
		var formobj=parent.parent.f_header.document.prescription_header_form;
		var xmlStr=formXMLString(formobj,fldString);
		var xmlDoc = "" ;
		var xmlHttp = new XMLHttpRequest() ;
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open("POST","PrescriptionValidation_2.jsp?func_mode=GET_TRNGROUPREF",false);
		xmlHttp.send(xmlDoc);
		responseText=xmlHttp.responseText ;
		responseText=trimString(responseText);

		if(responseText != undefined && responseText!=null && responseText!=""){
			var dialogHeight	="42vh" ;
			var dialogWidth	="60vw";
			var dialogTop	= "300" ;
			var dialogLeft	= "300" ;
			var center			= "1" ;
			var status			="no";
			var features	= "dialogHeight:" + dialogHeight +"; dialogLeft:"+dialogLeft+ "; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop;
			var arguments	= "";
			retVal = await window.showModalDialog("../../ePH/jsp/TokenListForOrders.jsp?trn_group_ref="+responseText,arguments,features);
		}
	}

	var print_confirm=confirm(getMessage("PH_PRINT_PRESCRIPTION", "PH"));
	if(print_confirm){
		print_yn="Y";
			var fldString=" patient_id=\""+ patient_id + "\" ";
			fldString+=" encounter_id=\""+ encounter_id + "\" ";
			fldString+=" print_yn=\""+ print_yn + "\" ";
			fldString+=" patient_class=\""+ patient_class + "\" ";
			fldString+=" locn_code=\""+ locn_code + "\" ";
			var formobj=parent.parent.f_detail.document.prescription_detail_form;
			var xmlStr=formXMLString(formobj,fldString);
			var source="onLinePrinting";
			var xmlDoc = "" ;
			var xmlHttp = new XMLHttpRequest() ;
			xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
			xmlHttp.open("POST","PrescriptionValidation_1.jsp?func_mode="+source,true);
			xmlHttp.send(xmlDoc);
			parent.window.close();
	}
	else{
		parent.window.close();
	}
}

function loadNonSlidingScreen(obj){
	var drug_code = document.prescription_detail_form.drug_code.value;
	var srl_no = document.prescription_detail_form.srl_no.value;
	if(obj.checked==false){
		parent.parent.f_prescription.f_prescription_form.prescription_form.sliding_scale_yn.value="N";
		defaultDrug1(drug_code, 'modify', srl_no, 'N', 'N');
	}
}

function defaultDrug1(drug_code,mode,srl_no,sliding_scale_yn,recomm_yn){

	var start_dt		 =	eval("parent.parent.f_prescription.frames[1].document.prescription_form.dt"+srl_no+".value");
	
	if(start_dt !=undefined && start_dt!=null && start_dt !="")
		start_date	=	start_dt;
	else
		start_date=parent.parent.f_header.document.prescription_header_form.sys_date.value;

	var priority=parent.parent.f_header.document.prescription_header_form.priority.value;
	var patient_id		= parent.parent.f_header.document.prescription_header_form.patient_id.value;
	var encounter_id	= parent.parent.f_header.document.prescription_header_form.encounter_id.value;
	var bed_num		= parent.parent.f_header.document.prescription_header_form.bed_num.value;
	var room_num	= parent.parent.f_header.document.prescription_header_form.room_num.value;
	var patient_class	= parent.parent.f_header.document.prescription_header_form.patient_class.value;
	var act_patient_class	= parent.parent.f_header.document.prescription_header_form.actual_patient_class.value;
	var bsa				= parent.parent.f_header.document.prescription_header_form.bsa.value;
	var drug_db_interface_yn				= parent.parent.f_header.document.prescription_header_form.drug_db_interface_yn.value;
	var drug_db_allergy_check_yn				= parent.parent.f_header.document.prescription_header_form.drug_db_allergy_check_yn.value;
	var drug_db_duptherapy_yn				= parent.parent.f_header.document.prescription_header_form.drug_db_duptherapy_yn.value;
	var bl_install_yn =  parent.parent.f_header.document.prescription_header_form.bl_install_yn.value;
	var bl_disp_charge_dtl_in_rx_yn =  parent.parent.f_header.document.prescription_header_form.bl_disp_charge_dtl_in_rx_yn.value;
	var take_home_medication =  parent.parent.f_header.document.prescription_header_form.take_home_medication.value;
	var trade_display_yn =  parent.parent.f_header.document.prescription_header_form.trade_display_yn.value;
	var MAR_app_yn	= getMAR_app_yn(parent.parent.f_header.document.prescription_header_form);
	var allow_without_diag		= parent.parent.f_header.document.prescription_header_form.allow_without_diag.value;
	var weight		= parent.parent.f_header.document.prescription_header_form.weight.value;
	var adr_count					=  parent.parent.f_header.document.prescription_header_form.adr_count.value;
	var order_set_code				=  parent.parent.f_header.document.prescription_header_form.order_set_code.value;
	var pract_id				=  parent.parent.f_header.document.prescription_header_form.pract_id.value;//ML-MMOH-CRF-01823

	parent.parent.f_header.document.prescription_header_form.sliding_scale.value=sliding_scale_yn;

	if(sliding_scale_yn=="Y" && recomm_yn == 'N'){
		parent.parent.f_detail.location.href="../../ePH/jsp/PrescriptionSlidingScaleFrame.jsp?srl_no="+srl_no+"&drug_code="+drug_code+"&priority="+priority+"&start_date="+start_date+"&mode="+mode+"&patient_id="+patient_id+"&encounter_id="+encounter_id+"&patient_class="+patient_class+"&bsa="+bsa+"&bed_num="+bed_num+"&room_num="+room_num+"&drug_db_interface_yn="+drug_db_interface_yn+"&bl_install_yn="+bl_install_yn+"&bl_disp_charge_dtl_in_rx_yn="+bl_disp_charge_dtl_in_rx_yn+"&MAR_app_yn="+MAR_app_yn+"&act_patient_class="+act_patient_class+"&take_home_medication="+take_home_medication+"&trade_display_yn="+trade_display_yn+"&drug_db_allergy_check_yn="+drug_db_allergy_check_yn+"&drug_db_duptherapy_yn="+drug_db_duptherapy_yn;
		parent.parent.f_button.location.href="../../ePH/jsp/PrescriptionButton_1.jsp?patient_id="+patient_id+"&mode="+mode+"&encounter_id="+encounter_id+"&sliding_scale_yn="+sliding_scale_yn+"&bed_num="+bed_num+"&room_num="+room_num+"&drug_db_interface_yn="+drug_db_interface_yn+"&act_patient_class="+act_patient_class+"&take_home_medication="+take_home_medication;
	}
	else{
//Below line commented for IN22011 -- 11/06/2010 -- priya
	//	parent.parent.f_prescription.location.href="../../ePH/jsp/PrescriptionFormFrame.jsp?patient_id="+patient_id+"&encounter_id="+encounter_id+"&patient_class="+patient_class+"&allow_without_diag="+allow_without_diag+"&bed_num="+bed_num+"&room_num="+room_num+"&weight="+weight+"&bsa="+bsa+"&drug_db_interface_yn="+drug_db_interface_yn+"&bl_install_yn="+bl_install_yn+"&bl_disp_charge_dtl_in_rx_yn="+bl_disp_charge_dtl_in_rx_yn+"&MAR_app_yn="+MAR_app_yn+"&adr_count="+adr_count+"&act_patient_class="+act_patient_class+"&take_home_medication="+take_home_medication+"&order_set_code="+order_set_code+"&sliding_scale_yn="+sliding_scale_yn+"&mode="+mode+"&drug_db_allergy_check_yn="+drug_db_allergy_check_yn+"&drug_db_duptherapy_yn="+drug_db_duptherapy_yn+"&srl_no="+srl_no+"&drug_code="+drug_code;


//				var mode="blank";
		////Below line uncommented for IN22011 -- 11/06/2010 -- priya 
		//When sliding scale was unchecked the timings of all the drugs was getting reset in the form
		parent.parent.f_detail.location.href="../../ePH/jsp/PrescriptionDetail_1.jsp?srl_no="+srl_no+"&drug_code="+drug_code+"&priority="+priority+"&start_date="+start_date+"&mode="+mode+"&patient_id="+patient_id+"&encounter_id="+encounter_id+"&patient_class="+patient_class+"&bsa="+bsa+"&bed_num="+bed_num+"&room_num="+room_num+"&drug_db_interface_yn="+drug_db_interface_yn+"&bl_install_yn="+bl_install_yn+"&bl_disp_charge_dtl_in_rx_yn="+bl_disp_charge_dtl_in_rx_yn+"&MAR_app_yn="+MAR_app_yn+"&act_patient_class="+act_patient_class+"&take_home_medication="+take_home_medication+"&pract_id="+pract_id+"&from_sliding_scale_yn=Y";//pract_id for ML-MMOH-CRF-01823
		parent.parent.f_button.location.href="../../ePH/jsp/PrescriptionButton_1.jsp?patient_id="+patient_id+"&mode="+mode+"&encounter_id="+encounter_id+"&sliding_scale_yn="+sliding_scale_yn+"&bed_num="+bed_num+"&room_num="+room_num+"&drug_db_interface_yn="+drug_db_interface_yn+"&act_patient_class="+act_patient_class+"&take_home_medication="+take_home_medication;
	}
}

function calEndDate(objValue){
	var durn_value = 1; 
	if(parseFloat(document.getElementById('durn_value').value)==0){
		alert(getMessage("PRES_DURN_CANNOT_ZERO", "PH"));
		document.getElementById('durn_value').focus();
		return false;
	}
	else if(trimString(document.getElementById('durn_value').value)==""){
		durn_value = 1;
	}
	else{
		durn_value = document.getElementById('durn_value').value ;
	}
	
	var xmlDoc="";
	var xmlHttp = new XMLHttpRequest();
	xmlStr	="<root><SEARCH " ;
	xmlStr += "start_date=\""+ document.getElementById('start_date').value +"\" " ;
	xmlStr += "durn_value=\""+ durn_value +"\" " ;
	xmlStr += "durn_unit=\""+ document.getElementById('repeat_durn_type').value +"\" " ;
	xmlStr += "patient_id=\""+ document.getElementById('patient_id').value +"\" " ;
	xmlStr += "encounter_id=\""+ document.getElementById('encounter_id').value +"\" " ;
	xmlStr += "bean_id=\""+ document.getElementById('bean_id').value +"\" " ;
	xmlStr += "bean_name=\""+ document.getElementById('bean_name').value +"\" " ;
	xmlStr +=" /></root>" ;
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open( "POST", "PrescriptionValidation_1.jsp?func_mode=POPULATEENDDATE", false ) ;
	xmlHttp.send( xmlDoc ) ;	
	eval(xmlHttp.responseText);	
}

function setEndDate(objValue){
	if(document.prescription_detail_form != undefined)
		document.prescription_detail_form.end_date.value = objValue; 
	else
		parent.f_detail.document.prescription_detail_form.end_date.value = objValue; 
}

function setPRNValidate(objValue){	
	document.prescription_detail_form.prn_remarks_flag.value = objValue; 	
	return;
}

function addSlidingScaleDrug(objValue,on_load_yn){  // // new arg on_load_yn added for IN24060 --07/10/2010-- priya
	var formObj = parent.f_prescription.f_prescription_form.prescription_form;
	var detailFormObj = parent.f_detail.f_sliding_scale_dtls.prescription_detail_form;
	var adminFormObj = parent.f_detail.f_sliding_scale_admin_dtls.prescription_detail_form;	
		//code added for PRN Remarks...
	var remarksFormObj = parent.f_detail.f_sliding_scale_remarks.f_sliding_scale_hdr.prescription_sliding_scale_remarks;
	var remarksDtlFormObj = parent.f_detail.f_sliding_scale_remarks.f_sliding_scale_dtls.prescription_sliding_scale_remarks_Dtl;
	var	headerFrame		  = parent.f_header;
	assignDurnTypeList(adminFormObj.DurnDescDetails.value); //added for IN22255 -- 23/06/2010 -- priya

	// commented by Rawther for scf : 7732
 /*	if(objValue!="delete"){ //condition added for allowing to cancel drug without checking for max duration --priya-- 02/03/2010
		var retval = validateDuration(adminFormObj.durn_value,'confirm','Y');//passed 'Y' for IN22255 -- 23/06/2010 -- priya
		if(retval == false)
			return;
	}*/
	
	
	var chk_for_max_durn_action = adminFormObj.chk_for_max_durn_action.value; //condition added for ARYU-SCF-0097 - Start
	if(chk_for_max_durn_action=='R'){
		var valid_durn = validateDuration(adminFormObj.durn_value,'confirm','Y');
		if(!valid_durn) 
			return false;
	} //condition added for ARYU-SCF-0097 - End  
	var frmObj	= detailFormObj; //TBMC-SCF-0166
	//var frmObj			= parent.f_detail.frames[0].document.prescription_detail_form;
	patient_id=frmObj.patient_id.value;
	encounter_id=frmObj.encounter_id.value;
	drug_code=frmObj.drug_code.value;
	srl_no=frmObj.srl_no.value; 
	if(frmObj.override_remarks.checked==true){
		frmObj.override_remarks.value='Y'; 
	}
	else{
		frmObj.override_remarks.value='N';
		if(on_load_yn =='N'){//SKR-SCF-0648 [IN-35984] - Added to check Override remarks on Sliding Scale. 
			alert(getMessage("OVERRIDE_REASON_NOT_BLANK", "PH"));
			frmObj.dosage_limit.click();
			return false;
		} 
	}
	if(objValue!="delete"){
	if(frmObj.drug_indication_mdry.value=="Y"){//jd-crf-0220
		if(frmObj.DrugIndicationRemarks.value ==null || frmObj.DrugIndicationRemarks.value ==""){
		//alert("6395");
			alert(getMessage("DRUG_INDICATION_REASON_NOT_BLANK", "PH"));
			return false;
		}
		//alert("3821drug_indication_mdry"+document.prescription_detail_form.drug_ind_remarks.value);
	}
}
	checkEnabled=frmObj.checkEnabled.value; 
	override_remarks=frmObj.override_remarks.value;
	//var retval = validateDuration(adminFormObj.durn_value,'confirm','Y');
	var xmlDoc="";
	var xmlHttp = new XMLHttpRequest();

	if(objValue=="delete"){
		var delete_confirm=confirm(getMessage("CANCEL_SEL_DRUG","PH"))
		if(!delete_confirm)
			return;
		var ord_set_reqd_or_opt = detailFormObj.ord_set_reqd_or_opt.value;
		if(ord_set_reqd_or_opt == 'R'){
			alert(getMessage("PH_CANCEL_ORDERSET_DRUG_FROM_RX", "PH"));
			return;
		}
		else{
			xmlStr	="<root><SEARCH " ;
			xmlStr += "patient_id=\""+patient_id   +"\" " ;
			xmlStr += "encounter_id=\""+encounter_id +"\" " ;		
			xmlStr += "drug_code=\""+ drug_code +"\" " ;		
			xmlStr += "srl_no=\""+ srl_no +"\" " ;		
			xmlStr += "oper_mode=\""+ objValue +"\" " ;		
			xmlStr += "bean_id=\"@PrescriptionBean_1"+patient_id+encounter_id+"\" ";
			xmlStr += "bean_name=\"ePH.PrescriptionBean_1\" " ;
			xmlStr +=" /></root>" ;
			xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
			xmlHttp.open( "POST", "PrescriptionValidation.jsp?func_mode=cancelSlidingScale", false ) ;//changed file name from  PrescriptionValidation_1.jsp to PrescriptionValidation.jsp ARYU-SCF-0053
			xmlHttp.send( xmlDoc ) ;	
			eval(xmlHttp.responseText);	
		}
	}
	else if(objValue=="add"){
		if(headerFrame.document.prescription_header_form.man_rem_on_prn_freq_yn != undefined && headerFrame.document.prescription_header_form.man_rem_on_prn_freq_yn.value == 'Y'){
			if(adminFormObj.prn_remarks !=null || adminFormObj.prn_remarks!=undefined ){
				if(adminFormObj.prn_remarks.style.visibility=="visible" && adminFormObj.prn_remarks_flag.value == "false" ){
					if(adminFormObj.prn_yn.value=='Y'){
						alert(getMessage("PRN_REMARKS_CANNOT_BE_BLANK", "PH"));
						return false;
				   }
				}
			}
		}
		//Added for Antibiotic Screen using Order Entry Format ICN 29904 -start
		if(on_load_yn =='N'){
			var drugRemarksMandatory = frmObj.DrugRemarksMandatory.value;
			var drugRemarksEntered		 = frmObj.DrugRemarksEntered.value;
			if(drugRemarksMandatory == 'Y' && drugRemarksEntered != 'Y'){
				msg = getMessage("CAN_NOT_BE_BLANK","Common");
				msg = msg.replace('$', getLabel("ePH.DrugRemarks.label","PH"));
				alert(msg);
				detailFormObj.drug_remarks.click();
				return false;
			}
		}
		//Added for Antibiotic Screen using Order Entry Format ICN 29904 -end
		//added for IN26429_reopen --15/02/2011-- priya -start
		if(adminFormObj.bl_overriden_action_reason_img.style.visibility=="visible"){
			if(adminFormObj.bl_incl_excl_override_reason_code.value == ""){
				alert(getMessage("INCL_EXCL_OVERRIDE_REASON_CANNOT_BE_BLANK","PH"));
				return false;
			}
		}
		//added for IN26429_reopen --15/02/2011-- priya -end
		var template_id = "";
		if(remarksDtlFormObj.template_id != null)
			 template_id = remarksDtlFormObj.template_id.value;

		var tmplDtlString= "";		
		var noOfTemplates= remarksDtlFormObj.noOfTemplates.value;
		var range_to = "";
		var rem="";
		for (var i=0; i<noOfTemplates; i++){
			range_to = (eval("remarksDtlFormObj.range_to"+i).value);
			if(range_to == "" || range_to == " ")
				range_to = "0";
			if((eval("remarksDtlFormObj.remarks"+i).value)=="")
				rem = " ";
			else
				rem = encodeURIComponent((eval("remarksDtlFormObj.remarks"+i).value),"UTF-8");
			var admin_unit = (eval("remarksDtlFormObj.admin_units"+i).value);
			if(admin_unit == "")
				admin_unit = " ";
			var range_from = (eval("remarksDtlFormObj.range_from"+i).value);
			if(range_from == "" || range_from == " ")
				range_from = "0";
			tmplDtlString += (eval("remarksDtlFormObj.srl_no"+i).value)+"~"+range_from+"~"+range_to+"~"+admin_unit+"~"+rem+"~";
		}
		var range_uom = "";
		var admin_uom = "";
		if(noOfTemplates >0){
			range_uom = remarksDtlFormObj.range_uom0.value;
			admin_uom = remarksDtlFormObj.admin_uom0.value;
		}
		
		var freq_desc = "";
		var pract_name=	unescape(parent.f_header.document.prescription_header_form.pract_name.value);
		parent.f_header.document.prescription_header_form.pract_name.value
		if(adminFormObj.frequency.options.length !=0)
			freq_desc= encodeURIComponent(adminFormObj.frequency.options[adminFormObj.frequency.selectedIndex].text,"UTF-8");

		xmlStr	="<root><SEARCH " ;
		xmlStr += "on_load_yn=\""+ on_load_yn   +"\" " ;
		xmlStr += "patient_id=\""+ formObj.patient_id.value   +"\" " ;
		xmlStr += "durn_desc=\""+ adminFormObj.durn_desc.value   +"\" " ;
		xmlStr += "repeat_durn_type=\""+ adminFormObj.repeat_durn_type.value   +"\" " ; ////added for IN21609 --07/06/2010 -- priya

		xmlStr += "encounter_id=\""+ formObj.encounter_id.value +"\" " ;		
		xmlStr += "freq_nature=\""+ adminFormObj.freq_nature.value +"\" " ;
		xmlStr += "qty_value=\""+ adminFormObj.qty_value.value +"\" " ;
		xmlStr += "dosage_type=\""+ adminFormObj.dosage_type.value +"\" " ;
		xmlStr += "repeat_value=\""+ adminFormObj.repeat_value.value +"\" " ;
		xmlStr += "absol_qty=\""+ adminFormObj.absol_qty.value +"\" " ;
		xmlStr += "qty_unit=\""+ adminFormObj.qty_unit.value +"\" " ;
		xmlStr += "frequency=\""+ adminFormObj.frequency.value +"\" " ;
		xmlStr += "freq_desc=\""+ freq_desc +"\" " ;
		xmlStr += "durn_value=\""+ adminFormObj.durn_value.value +"\" " ;
		xmlStr += "durn_unit=\""+ adminFormObj.durn_unit.value +"\" " ;
		xmlStr += "interval_value=\""+ adminFormObj.interval_value.value +"\" " ;
		xmlStr += "start_date=\""+ adminFormObj.start_date.value +"\" " ;
		xmlStr += "end_date=\""+ adminFormObj.end_date.value +"\" " ;
		xmlStr += "drug_code=\""+ drug_code +"\" " ;		
		xmlStr += "srl_no=\""+ adminFormObj.srl_no.value +"\" " ;		
		xmlStr += "override_remarks=\""+ override_remarks +"\" " ;		
		xmlStr += "checkEnabled=\""+ checkEnabled +"\" " ;		
		xmlStr += "pract_name=\""+ encodeURIComponent(pract_name) + "\" ";
		xmlStr += "template_id=\""+ template_id + "\" ";
		xmlStr += "rangeUom=\""+ range_uom + "\" ";
		xmlStr += "adminUom=\""+ admin_uom + "\" ";
		xmlStr += "tmplDtlString=\""+ tmplDtlString + "\" ";
/*===============================================================================================================*/
//added for IN26429_reopen --15/02/2011-- priya
		xmlStr += "bl_incl_excl_override_reason_code=\""+ adminFormObj.bl_incl_excl_override_reason_code.value +"\" " ;
		xmlStr += "bl_incl_excl_override_reason_desc=\""+ adminFormObj.bl_incl_excl_override_reason_desc.value +"\" " ;
		xmlStr += "bl_override_excl_incl_ind=\""+ adminFormObj.bl_override_excl_incl_ind.value +"\" " ;
		xmlStr += "bl_def_override_excl_incl_ind=\""+ adminFormObj.bl_def_override_excl_incl_ind.value +"\" " ;
		xmlStr += "bl_override_allowed_yn=\""+ adminFormObj.bl_override_allowed_yn.value +"\" " ;
/*===============================================================================================================*/
		xmlStr += "DrugIndicationRemarks=\""+ frmObj.DrugIndicationRemarks.value+"\" " ;//added for jd-crf-0220
		xmlStr += "bean_id=\"@PrescriptionBean_1"+patient_id+encounter_id+"\" ";
		xmlStr += "bean_name=\"ePH.PrescriptionBean_1\" " ;
		var remarks			= "";
		var remarks_codes	="";
		for (var i=1;i<remarksFormObj.no_of_remarks.value ;i++ ){
			if(eval("remarksFormObj.chk_select_"+i).checked){
				remarks			+= (eval("remarksFormObj.txt_remarks_"+i).value+" .. ");
				remarks_codes   += (eval("remarksFormObj.txt_remarks_code_"+i).value)+"||";
			}
		}
		for (var i=0;i<remarksDtlFormObj.noOfTemplates.value ;i++ ){ //code added for IN047654 --Start	 	
			remarks   += (eval("remarksDtlFormObj.remarks"+i).value)+" .. ";			
		}//code added for IN047654 --End  
		xmlStr += "remarks=\""+ encodeURIComponent(remarks,"UTF-8")+"\" " ;//code 'remarks' replaced by encodeURIComponent(remarks,"UTF-8") for IN047654
		xmlStr += "remarks_codes=\""+ remarks_codes +"\" " ;
		xmlStr += "sliding_scale_yn=\""+ adminFormObj.sliding_scale_yn.value +"\" " ;
		xmlStr += "buildMAR_yn=\""+ frmObj.buildMAR_yn.value +"\" " ; //added for SRR20056-SCF-7882 -29157
		xmlStr +=" /></root>" ;
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open( "POST", "PrescriptionValidation.jsp?func_mode=confirmSlidingScale", false ) ;//Changed _1.jsp to validation to reduce code in validation_1.jsp
		xmlHttp.send( xmlDoc ) ;	
		eval(xmlHttp.responseText);	
	}
}

function deleteSlidingSchedule(){	
	var drug_code		= document.prescription_detail_form.drug_code.value;
	var srl_no			= document.prescription_detail_form.srl_no.value;
	var calling_mode	= document.prescription_detail_form.calling_mode.value;
	if(calling_mode=="taper")
		code			=	drug_code+(parseInt(srl_no)+1);
	else
		code			=	drug_code+srl_no;
	var fldString=" drug_code=\""+ code + "\" ";
	var formobj=document.prescription_detail_form;
	var xmlStr=formXMLString(formobj,fldString);
	fieldValidation(xmlStr,"deleteSlidingSch");
}

function populateFreqBasedValues(obj){
	if(obj.value != ""){
		document.getElementById('btnSchedule').disabled=false;
		deleteSlidingSchedule();
		var start_date		= document.prescription_detail_form.start_date.value;
		var split_dose_yn	= document.prescription_detail_form.split_dose_yn.value;

		var qty_value		= document.prescription_detail_form.qty_value.value;
		var freq_code		= document.prescription_detail_form.frequency.value;	
		var freq_desc		= encodeURIComponent(document.prescription_detail_form.frequency.text,"UTF-8");
		var drug_code		= document.prescription_detail_form.drug_code.value;	
		var srl_no			= document.prescription_detail_form.srl_no.value;		
		var rowVal			= document.prescription_detail_form.rowVal.value;		
		var calling_mode	= document.prescription_detail_form.calling_mode.value;
		var scheduled_yn	= document.prescription_detail_form.scheduled_yn.value;
		var repeat_durn_type	= document.prescription_detail_form.repeat_durn_type.value;
		if(calling_mode=="taper") {
	//		srl_no	=	parseInt(srl_no)+1;
		}
		var fldString=" start_date=\""+ start_date + "\" ";
			fldString+=" split_dose_yn=\""+ split_dose_yn + "\" ";
			fldString+=" qty_value=\""+ qty_value + "\" ";
			fldString+=" freq_code=\""+ freq_code + "\" ";
			fldString+=" freq_desc=\""+ freq_desc + "\" ";
			fldString+=" drug_code=\""+ drug_code + "\" ";
			fldString+=" srl_no=\""+ srl_no + "\" ";
			fldString+=" rowVal=\""+ rowVal + "\" ";
			fldString+=" scheduled_yn=\""+ scheduled_yn + "\" ";			
			var formobj=document.prescription_detail_form;
			var xmlStr=formXMLString(formobj,fldString);
			fieldValidation(xmlStr,"storeSchedule");
	}
	else{
		document.getElementById('btnSchedule').disabled=true;
	}
}

function refreshSlidingScaleFrame(){
	
	var formObj						=   parent.f_prescription.f_prescription_form.prescription_form.all;
	patient_id						=	formObj.patient_id.value;
	encounter_id					=	formObj.encounter_id.value;
	bed_num							=	formObj.bed_num.value;
	room_num						=	formObj.room_num.value;
	weight							=	formObj.weight.value;
	bsa								=	formObj.bsa.value;
	drug_db_interface_yn			=   parent.f_header.document.prescription_header_form.drug_db_interface_yn.value;
	drug_db_allergy_check_yn			=   parent.f_header.document.prescription_header_form.drug_db_allergy_check_yn.value;
	drug_db_duptherapy_yn			=   parent.f_header.document.prescription_header_form.drug_db_duptherapy_yn.value;
	var bl_install_yn				=   parent.f_header.document.prescription_header_form.bl_install_yn.value;
	var bl_disp_charge_dtl_in_rx_yn =   parent.f_header.document.prescription_header_form.bl_disp_charge_dtl_in_rx_yn.value;
	var MAR_app_yn					=   getMAR_app_yn(parent.f_header.document.prescription_header_form);
	var adr_count					=   parent.f_header.document.prescription_header_form.adr_count.value;
	var patient_class				=   parent.f_header.document.prescription_header_form.patient_class.value;
	var act_patient_class			=   parent.f_header.document.prescription_header_form.actual_patient_class.value;
	var take_home_medication		=   parent.f_header.document.prescription_header_form.take_home_medication.value;
	var order_date_time				=   parent.f_header.document.prescription_header_form.sys_date.value;
	var order_set_code				=   parent.f_header.document.prescription_header_form.order_set_code.value;
	var pract_id				=   parent.f_header.document.prescription_header_form.pract_id.value;

	var mode;
	parent.f_prescription.location.href="../../ePH/jsp/PrescriptionFormFrame.jsp?patient_id="+patient_id+"&encounter_id="+encounter_id+"&patient_class="+patient_class+"&bed_num="+bed_num+"&room_num="+room_num+"&weight="+weight+"&bsa="+bsa+"&drug_db_interface_yn="+drug_db_interface_yn+"&bl_install_yn="+bl_install_yn+"&bl_disp_charge_dtl_in_rx_yn="+bl_disp_charge_dtl_in_rx_yn+"&MAR_app_yn="+MAR_app_yn+"&adr_count="+adr_count+"&act_patient_class="+act_patient_class+"&take_home_medication="+take_home_medication+"&order_set_code="+order_set_code+"&drug_db_allergy_check_yn="+drug_db_allergy_check_yn+"&drug_db_duptherapy_yn="+drug_db_duptherapy_yn;
	var mode="blank";
	parent.f_detail.location.href="../../ePH/jsp/PrescriptionDetail_1.jsp?patient_id="+patient_id+"&encounter_id="+encounter_id+"&patient_class="+patient_class+"&mode="+mode+"&start_date="+order_date_time+"&bed_num="+bed_num+"&room_num="+room_num+"&drug_db_interface_yn="+drug_db_interface_yn+"&bl_install_yn="+bl_install_yn+"&bl_disp_charge_dtl_in_rx_yn="+bl_disp_charge_dtl_in_rx_yn+"&MAR_app_yn="+MAR_app_yn+"&act_patient_class="+act_patient_class+"&take_home_medication="+take_home_medication+"&drug_db_allergy_check_yn="+drug_db_allergy_check_yn+"&drug_db_duptherapy_yn="+drug_db_duptherapy_yn+"&pract_id="+pract_id;
	parent.f_button.location.href="../../ePH/jsp/PrescriptionButton_1.jsp?patient_id="+patient_id+"&mode="+mode+"&encounter_id="+encounter_id+"&patient_class="+patient_class+"&bed_num="+bed_num+"&room_num="+room_num+"&drug_db_interface_yn="+drug_db_interface_yn+"&act_patient_class="+act_patient_class+"&take_home_medication="+take_home_medication;
	if(top.content != null)
		top.content.messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num=";
}

function trapEnterKey(event,obj) {
	if(event.keyCode==13){
		 return false;
	}
}

function disableDuplicate(){
	if(document.prescription_detail_form.current_rx==null) {
		frmObj	=	parent.f_sliding_scale_dtls.prescription_detail_form;
		frmObj.current_rx.value="N";
		var allergy_yn	= frmObj.allergy_yn.value;
		var limit_ind	= frmObj.limit_ind.value;	
		var interaction_exists	= frmObj.interaction_exists.value;	
		var abuse_exists= frmObj.abuse_exists.value;//added for AAKH-CRF-0140
		var abuse_action= frmObj.abuse_action.value;//added for AAKH-CRF-0140
		//alert("abuse_exists"+abuse_exists+"abuse_action"+abuse_action);
		//&& (abuse_exists!="Y" && abuse_action !="B") added for aakh-crf-0140
		if( allergy_yn!="Y" && limit_ind!="N" && interaction_exists!="Y" && (abuse_exists!="Y" && abuse_action !="B")){
			//parent.f_sliding_scale_dtls.document.getElementById('dosage_limit').style.display="none";
			parent.f_sliding_scale_dtls.document.getElementById('dosage_limit').style.visibility="hidden";
 			parent.f_sliding_scale_dtls.document.getElementById('override_remarks').style.visibility="hidden";
		}
	}
	else {
		document.prescription_detail_form.current_rx.value="N";
		var allergy_yn	= document.prescription_detail_form.allergy_yn.value;
		var limit_ind	= document.prescription_detail_form.limit_ind.value;	
		var interaction_exists	= document.prescription_detail_form.interaction_exists.value;	
		var abuse_exists= document.prescription_detail_form.abuse_exists.value;//added for AAKH-CRF-0140
		var abuse_action= document.prescription_detail_form.abuse_action.value;//added for AAKH-CRF-0140
	//	alert("abuse_exists"+abuse_exists+"abuse_action"+abuse_action);
		//&& (abuse_exists!="Y" && abuse_action !="B") added for aakh-crf-0140
		
		if( allergy_yn!="Y" && limit_ind!="N" && interaction_exists!="Y" && (abuse_exists!="Y" && abuse_action !="B")){
			//document.getElementById('dosage_limit').style.display="none";
			document.getElementById('dosage_limit').style.visibility="hidden";
			document.getElementById('override_remarks').style.visibility="hidden";
		}
	}
}

function enableDuplicate() {
	if(document.prescription_detail_form.allergy_yn==null) {
		frmObj	=	parent.f_sliding_scale_dtls.prescription_detail_form;
		frmObj.current_rx.value="Y";
		var allergy_yn	= frmObj.allergy_yn.value;
		var limit_ind	= frmObj.limit_ind.value;	
		var interaction_exists	= frmObj.interaction_exists.value;	
		var abuse_exists= frmObj.abuse_exists.value;//added for AAKH-CRF-0140
		var abuse_action= frmObj.abuse_action.value;//added for AAKH-CRF-0140
	//	alert("abuse_exists"+abuse_exists+"abuse_action"+abuse_action);
		//&& (abuse_exists!="Y" && abuse_action !="B") added for aakh-crf-0140
		
		if( allergy_yn!="Y" && limit_ind!="N" && interaction_exists=="Y"){
			//parent.f_sliding_scale_dtls.document.getElementById('dosage_limit').style.display="inline";
			parent.f_sliding_scale_dtls.document.getElementById('dosage_limit').style.visibility="visible";
			parent.f_sliding_scale_dtls.document.getElementById('override_remarks').style.visibility="visible";
		}
	}
	else {
		document.prescription_detail_form.current_rx.value="Y";
		var allergy_yn	= document.prescription_detail_form.allergy_yn.value;
		var limit_ind	= document.prescription_detail_form.limit_ind.value;	
		var interaction_exists	= document.prescription_detail_form.interaction_exists.value;	
		var abuse_exists= document.prescription_detail_form.abuse_exists.value;//added for AAKH-CRF-0140
		var abuse_action= document.prescription_detail_form.abuse_action.value;//added for AAKH-CRF-0140
	//	alert("abuse_exists"+abuse_exists+"abuse_action"+abuse_action);
		//&& (abuse_exists!="Y" && abuse_action !="B") added for aakh-crf-0140
		
		if( allergy_yn!="Y" && limit_ind!="N" && interaction_exists=="Y" && (abuse_exists!="Y" && abuse_action !="B")){
			//document.getElementById('dosage_limit').style.display="inline";
			document.getElementById('dosage_limit').style.visibility="visible";
			document.getElementById('override_remarks').style.visibility="visible";
		}
	}
}

function checkForDuplicate(){

	var current_rx		=	parent.f_detail.document.prescription_detail_form.current_rx.value;
	var allow_duplicate	=	parent.f_detail.document.prescription_detail_form.allow_duplicate.value;
	var patient_class	=	parent.f_detail.document.prescription_detail_form.patient_class.value;
	var take_home		=	parent.f_detail.document.prescription_detail_form.take_home.value;
	var frequency		=	parent.f_detail.document.prescription_detail_form.frequency.value;
    var freq_nature		=	parent.f_detail.document.prescription_detail_form.freq_nature.value;
	var result			=	true;

	if(current_rx=="Y" && allow_duplicate=="N" && (patient_class=="IP" || parseInt(take_home)>0) && freq_nature!="O" ) {
		result		=	false;
	}
	return result;
}

//function added for PRN Remarks
async function callPRNDetails(){	
	var headerFrame = "";
	if(parent.f_header != undefined)
		headerFrame = parent.f_header;
	else
		headerFrame = parent.parent.f_header;
		
	var dialogHeight	= "70vh" ;
	var dialogWidth		= "70vw";
	var dialogTop		= "200" ;
	var dialogLeft		= "255" ;
	var center			= "1" ;
	var status			="no";
	var features		= "dialogHeight:" + dialogHeight +"; dialogLeft"+dialogLeft+ "; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop;
	var arguments		= "";		
	
	if(document.prescription_detail_form.sliding_scale_yn.value != 'Y'){
		var frmObj = document.prescription_detail_form;
	}
	else {
		var frmObj = parent.frames[0].document.prescription_detail_form;
	}
	var drug_name =  frmObj.drug_name.value;
	var patient_id =  frmObj.patient_id.value
	var encounter_id =  frmObj.encounter_id.value
	var drug_code =  frmObj.drug_code.value
	var prn_yn =  document.prescription_detail_form.prn_yn.value;
	var man_rem_on_prn_freq_yn = headerFrame.document.prescription_header_form.man_rem_on_prn_freq_yn.value;
	var max_length_prn_reason = headerFrame.document.prescription_header_form.max_length_prn_reason.value;
	retVal				= await window.showModalDialog("../../ePH/jsp/PrescriptionRemarksFrame.jsp?drug="+escape(drug_name)+"&patient_id="+patient_id+"&encounter_id="+encounter_id+"&drug_code="+drug_code+"&prn_yn="+prn_yn+"&called_from=PRN"+"&man_rem_on_prn_freq_yn="+man_rem_on_prn_freq_yn+"&max_length_prn_reason="+max_length_prn_reason,arguments,features);
	
   if(retVal=='OK'){
		document.prescription_detail_form.prn_remarks_flag.value = "true";
   }
   else{
		document.prescription_detail_form.prn_remarks_flag.value = "false";
   }
}

function checkFlds( fields, names) {

	var errors = "" ;
	for( var i=0; i<fields.length; i++ ) {

		if(trimCheck(fields[i].value)) {
			fields[i].value = trimString(fields[i].value);
		}
		else
			errors = getMessage("REMARKS_CANNOT_BLANK","PH");
			
	}
	if ( errors.length != 0 ) {
		alert(errors) ;
		return false ;
	}
	return true ;
}

function validatePRNRemark() {

	drug_name			=	parent.frames[0].document.PrescriptionPRNRemarksForm.drug_code.value;
	drug				=	parent.frames[0].document.PrescriptionPRNRemarksForm.drug.value;
	bean_id				=	parent.frames[0].document.PrescriptionPRNRemarksForm.bean_id.value;
	bean_name			=	parent.frames[0].document.PrescriptionPRNRemarksForm.bean_name.value;
	remarks				=	parent.frames[0].document.PrescriptionPRNRemarksForm.remarks.value;	
	prn_yn				=	parent.frames[0].document.PrescriptionPRNRemarksForm.prn_yn.value;	
	remarks_code = "";
	if(parent.frames[0].document.PrescriptionPRNRemarksForm.prnRemCode.disabled == false)
		remarks_code			=	parent.frames[0].document.PrescriptionPRNRemarksForm.prnRemCode.value;	
	
	man_rem_on_prn_freq_yn	=	parent.frames[0].document.PrescriptionPRNRemarksForm.man_rem_on_prn_freq_yn.value;	
	max_length_prn_reason = parent.frames[0].document.PrescriptionPRNRemarksForm.max_length_prn_reason.value;	
	if(remarks.length > max_length_prn_reason){
		var msg = getMessage("REMARKS_CANNOT_EXCEED","Common");
		msg = msg.replace("$",getLabel("Common.remarks.label","Common"));
		msg = msg.replace("#",max_length_prn_reason);
		//message=getMessage("PH_PRN_REMARKS_MAX_LENGTH", "PH");
		alert(msg);
		if(parent.frames[0].document.PrescriptionPRNRemarksForm.remarks.disabled == false){
			parent.frames[0].document.PrescriptionPRNRemarksForm.remarks.select();
			parent.frames[0].document.PrescriptionPRNRemarksForm.remarks.focus();
		}
		return;
	}
	var fields			= new Array() ;
	var names			= new Array() ;
	if(prn_yn=='Y'){
		 fields[0]			= parent.frames[0].document.PrescriptionPRNRemarksForm.remarks ;
		 names[0]			= getLabel("Common.remarks.label","Common");
	} 

//	if(checkFlds( fields, names)){
	var xmlStr ="<root><SEARCH ";
	xmlStr+= "remarks =\"" +encodeURIComponent(remarks) + "\" " ;
	xmlStr+= "drug_code =\"" + drug_name + "\" " ;
	xmlStr+= "remarks_code =\"" + remarks_code + "\" " ;
	//xmlStr+= "drug =\"" + drug + "\" " ;
	xmlStr+= "bean_id =\"" + bean_id + "\" " ;
	xmlStr+= "bean_name=\"" + bean_name + "\" " ;
	xmlStr +=" /></root>";

	var temp_jsp="PrescriptionValidation_2.jsp?func_mode=PRNRemarks";
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest() ;
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST",temp_jsp,false);
	xmlHttp.send(xmlDoc);
	responseText=xmlHttp.responseText ;		
	eval(responseText);

	if(!trimCheck(fields[0].value)) {
		if(man_rem_on_prn_freq_yn == 'Y'){
			alert(getMessage("REMARKS_CANNOT_BLANK","PH"));
			return false;
		}
		else{
			window.close();	
			window.returnValue="OK";
		}
	}
	else{
		window.close();	
		window.returnValue="OK";
	}
}

function setRecommendDosage(){	
	var ext_prod_id = document.prescription_detail_form.ext_prod_id.value;
	var drug_db_dosecheck_yn = parent.frames[0].document.prescription_header_form.drug_db_dosecheck_yn.value;
	if(drug_db_dosecheck_yn!="Y" || ext_prod_id ==""){
		var dosage_type = document.prescription_detail_form.dosage.value;
		var recomm_dosage_by = document.prescription_detail_form.recomm_dosage_by.value;
		if(dosage_type == recomm_dosage_by){
			document.prescription_detail_form.qty_value.value =document.prescription_detail_form.dosage_std.value;
			if(parent.frames[0].prescription_header_form.height.value.length > 0 && parent.frames[0].prescription_header_form.weight.value > 0){ // condition added for ML-MMOH-SCF-0633 [IN:063271] - Start 
				if(document.prescription_detail_form.calc_by_ind.value=="W")
			       document.prescription_detail_form.qty_value.value =parseInt(parseFloat(document.prescription_detail_form.dosage_std.value)*parseFloat(parent.frames[0].prescription_header_form.weight.value)); 
			   else if(document.prescription_detail_form.calc_by_ind.value=="B") 
				   document.prescription_detail_form.qty_value.value = parseInt(parseFloat(document.prescription_detail_form.dosage_std.value)*parseFloat(parent.frames[0].prescription_header_form.bsa.value));
			} // condition added for ML-MMOH-SCF-0633 [IN:063271] - End
			document.prescription_detail_form.qty_value.focus();
		}
		changedoseoverridevalue();
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

//added on 29/11/05 to check the field length
function checkDecimal(Obj,maxdigits,mindigits,deci){ 
	var formObj = document.prescription_header_form;
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

function DisableSchedule1(){
	
	var drug_code = document.prescription_detail_form.drug_code.value;
	var srl_no	  = document.prescription_detail_form.srl_no.value;
	var calling_mode  = document.prescription_detail_form.calling_mode.value;
	if(calling_mode=="taper")
		code	=	drug_code+(parseInt(srl_no));
	else
		code	=	drug_code+srl_no;
	var fldString=" drug_code=\""+ code + "\" ";
	var formobj=document.prescription_detail_form;
	var xmlStr=formXMLString(formobj,fldString);
	fieldValidation(xmlStr,"disableScheduleLink1");
}

function changedoseoverridevalue(){
	var ext_prod_id = document.prescription_detail_form.ext_prod_id.value;
	var drug_db_dosecheck_yn = parent.frames[0].document.prescription_header_form.drug_db_dosecheck_yn.value;
	if(drug_db_dosecheck_yn!="Y" || ext_prod_id ==""){

		if(document.prescription_detail_form.recomm_yn.value=="Y") {
			var frameobj;
			if(parent.f_header==null) {
				frameobj	=	parent.parent.f_header;
			}
			else {
				frameobj	=	parent.f_header;
			}
			var patient_id=frameobj.document.prescription_header_form.patient_id.value;
			var recc_dose	=document.getElementById('rec_value').innerHTML;
			var qty_value	=document.prescription_detail_form.qty_value.value;
			var drug_code	= document.prescription_detail_form.drug_code.value;
			var dosage_type = document.prescription_detail_form.dosage_type.value;
			var srl_no		= document.prescription_detail_form.srl_no.value;
			var freq_nature		= document.prescription_detail_form.freq_nature.value;
			var bean_id		=	document.prescription_detail_form.bean_id.value;
			var bean_name	=	document.prescription_detail_form.bean_name.value;
			var calc_def_dosage_yn	=	document.prescription_detail_form.calc_def_dosage_yn.value;
			var repeat_value= "";
			if(oldrepeatvalue==undefined)
				repeat_value = document.prescription_detail_form.repeat_value.value;
			else
				repeat_value =oldrepeatvalue;

			var xmlStr ="<root><SEARCH ";
			xmlStr += " bean_id=\""+ bean_id + "\" ";
			xmlStr += " bean_name=\""+ bean_name + "\" ";
			xmlStr += " drug_code=\""+ drug_code + "\" ";
			xmlStr += " srl_no=\""+ srl_no + "\" ";
			xmlStr+=" patient_id=\""+ patient_id + "\" ";
			xmlStr += " qty_value=\""+ qty_value + "\" ";
			xmlStr += " dosage_type=\""+ dosage_type + "\" ";
			xmlStr += " repeat_value=\""+ repeat_value + "\" ";
			xmlStr += " freq_nature=\""+ freq_nature + "\" ";
			xmlStr += " calc_def_dosage_yn=\""+ calc_def_dosage_yn + "\" ";
			xmlStr +=" /></root>";
			fieldValidation(xmlStr,"changeoverridevalue");
		}
	}
}

function disableoverride(limit_ind){
	interaction_exists = document.prescription_detail_form.interaction_exists.value;
	var abuse_exists= document.getElementById('abuse_exists').value;//added for AAKH-CRF-0140
	var abuse_action= document.getElementById('abuse_action').value;//added for AAKH-CRF-0140
	
	if((limit_ind=='Y') &&(document.prescription_detail_form.allergy_yn.value =='N')&& (document.prescription_detail_form.current_rx.value == 'N') && interaction_exists!="Y" && abuse_exists!="Y" && abuse_action!="B"){
		document.getElementById('dosage_limit').style.visibility='hidden';
		//document.prescription_detail_form.dosage_limit.style.display="none";
		document.getElementById('override_remarks').style.visibility="hidden";
	}
	else{	 
      if((limit_ind=='N')||(document.prescription_detail_form.allergy_yn.value =='Y')|| (document.prescription_detail_form.current_rx.value == 'Y') || interaction_exists=="Y" || (abuse_exists!="Y" && abuse_action!="B")){	 
        document.getElementById('dosage_limit').style.visibility='visible';
		//document.prescription_detail_form.dosage_limit.style='display';		 
 		document.getElementById('override_remarks').style.visibility="visible";
	  }
	}
}

function changeschedule(){	
	if(document.getElementById("rec_legend_font").className!='HYPERLINK')
		return false;

	var ext_prod_id = document.prescription_detail_form.ext_prod_id.value;
	var drug_db_dosecheck_yn = parent.frames[0].document.prescription_header_form.drug_db_dosecheck_yn.value;
	if(drug_db_dosecheck_yn!="Y" || ext_prod_id ==""){
		setRecommendDosage();
		deleteScheduleLink();
		DisableSchedule1();
		storeSchedule();
		checkSchedule(document.prescription_detail_form.qty_value);
		changedoseoverridevalue();		
	}
}

function checkOverRideRemarks(formObj){
	if(formObj.override_remarks.checked==true){
		formObj.override_remarks.value="Y";
	}
	else{
		formObj.override_remarks.value="N";
	}
}

function allowamend(){	
	
	alert(getMessage("ATC_DUPLICATION", "PH"));
	var patient_id		= parent.f_header.document.prescription_header_form.patient_id.value;
	var encounter_id		= parent.f_header.document.prescription_header_form.encounter_id.value;
	var location_type    = parent.f_header.document.prescription_header_form.location_type.value;
	var location_code	= parent.f_header.document.prescription_header_form.location_code.value;
	var patient_class	= parent.f_header.document.prescription_header_form.patient_class.value;
	var order_date_time  = parent.f_header.document.prescription_header_form.sys_date.value;
	var weight	= parent.f_header.document.prescription_header_form.weight.value;
	var bsa  = parent.f_header.document.prescription_header_form.bsa.value;
	var drug_db_interface_yn  = parent.f_header.document.prescription_header_form.drug_db_interface_yn.value;
	var drug_db_allergy_check_yn  = parent.f_header.document.prescription_header_form.drug_db_allergy_check_yn.value;
	var drug_db_duptherapy_yn  = parent.f_header.document.prescription_header_form.drug_db_duptherapy_yn.value;
	var adr_count			 =  parent.f_header.document.prescription_header_form.adr_count.value;
	var order_set_code		 =  parent.f_header.document.prescription_header_form.order_set_code.value;
	parent.f_prescription.location.href="../../ePH/jsp/PrescriptionFormFrame.jsp?patient_id="+patient_id+"&encounter_id="+encounter_id+"&patient_class="+patient_class+"&weight="+weight+"&bsa="+bsa+"&drug_db_interface_yn="+drug_db_interface_yn+"&adr_count="+adr_count+"&order_set_code="+order_set_code+"&drug_db_allergy_check_yn="+drug_db_allergy_check_yn+"&drug_db_duptherapy_yn="+drug_db_duptherapy_yn;
	if(top.content != null)
		top.content.messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num=";
}

//function for displaying TDM Details
async function viewReasonforRequest(orderId,drug_code){
	
	var dialogHeight ='30vh' ;
	var dialogWidth = '45vw' ;
	var dialogTop	= '189';
	var dialogLeft = '167' ;
	var title = ''
	var features = 'dialogHeight:' + dialogHeight + '; dialogWidth:' + dialogWidth +';dialogTop:'+dialogTop+';dialogLeft:'+dialogLeft+';dialogTitle:'+title+'; scroll=yes; status=no';
	var arguments = "";
	var finalString	= "&readonly=readOnly&orderId="+orderId;
	var retVals = await window.showModalDialog("../../eOR/jsp/TDMReasonforrequest.jsp?"+finalString,arguments,features);
}

//to display the Taper details
async function showTaperDetails(patient_id,order_id,drug_code){

	var dialogTop		= "300";
 	var dialogHeight	= "40vh" ;
 	var dialogWidth		= "50vw" ;
	var center			= "1" ;
	var title           = "Tapering Details";
 	var features		= 'Width:' + dialogWidth +'; dialogHeight:' + dialogHeight + '; dialogWidth:' + dialogWidth + "; center: " + center +';  dialogTop:'+dialogTop +';dialogTitle:'+title+'; scroll=yes; status=no';
 	var arguments		= "";
 	await window.showModalDialog("../../ePH/jsp/DisplayTaperDrugDetail.jsp?patient_id="+patient_id+"&order_id="+order_id+"&drug_code="+drug_code,arguments,features);
}

/****************************************************************/
function checkForMax(obj){
	var prn_remarks=obj.value;
	if(prn_remarks.length > 400){
		message=getMessage("PH_PRN_REMARKS_MAX_LENGTH", "PH");
		message = message.substring(0,message.length-1);
		alert(message);
		obj.select();
		obj.focus();
	}
}

/****************************************************************/
function noSchedule(){
	alert(getMessage("NO_SCHEDULE_FOUND", "PH"));
	document.prescription_detail_form.frequency.focus();
}

/******************************************************************/
function checkMand(obj){
}

/****************************************************************/
function extDosageCheck(callfrom){
	if( parent.f_header == undefined)
		var header_formObj =	 parent.parent.f_header.document.prescription_header_form;
	else
		var header_formObj =	 parent.f_header.document.prescription_header_form;
	var drug_db_interface_yn =  header_formObj.drug_db_interface_yn.value;

	var drug_db_dosecheck_yn =  header_formObj.drug_db_dosecheck_yn.value;
	var drug_db_product_id =  header_formObj.drug_db_product_id.value;
	var drug_db_duptherapy_yn       =  header_formObj.drug_db_duptherapy_yn.value;
	var drug_db_interact_check_yn  =  header_formObj.drug_db_interact_check_yn.value;
	var drug_db_contraind_check_yn =  header_formObj.drug_db_contraind_check_yn.value;
	var drug_db_allergy_check_yn    =  header_formObj.drug_db_allergy_check_yn.value;

	if(drug_db_interface_yn == 'Y' ){
		var formObj =	  document.prescription_detail_form;
		var dose_uom = formObj.qty_desc.value;
		var ext_prod_id = formObj.ext_prod_id.value;
		var sliding_scale_yn = formObj.sliding_scale_yn.value;
	//	if(ext_prod_id != ""){    //commented  for SKR-SCF-0561 [IN:033486] 
			var weight = header_formObj.weight.value;
			var bsa  =  header_formObj.bsa.value;
			var pract_name	=	unescape(header_formObj.pract_name.value);

			var patient_id = formObj.patient_id.value;
			var encounter_id = formObj.encounter_id.value;
			var drug_code	= formObj.drug_code.value;
			var srl_no		= formObj.srl_no.value;
			var bean_id		=	formObj.bean_id.value;
			var bean_name	=	formObj.bean_name.value;
			var dosage = formObj.qty_value.value;
			var dose_uom = formObj.qty_desc.value;
			//var dose_uom = formObj.qty_desc.options[formObj.qty_desc.selectedIndex].value;
			var dosage_by = '';
			var tappered_over = '';
			if(sliding_scale_yn!='Y'){
				dosage_by = formObj.dosage.options[formObj.dosage.selectedIndex].value;
				tappered_over =formObj.tappered_over.value;
			}
			var repeat_value = formObj.repeat_value.value;
			var interval_value = formObj.interval_value.value;
			var duration = formObj.durn_value.value;
			var repeat_durn_type = document.prescription_detail_form.repeat_durn_type.value;//Code added for IN23562  --08/09/2010-- priya -Start
			var tmp_durn_value = document.prescription_detail_form.tmp_durn_value.value;
			var durn_type = document.prescription_detail_form.tmp_durn_desc.value;
			var freq_nature =  document.prescription_detail_form.freq_nature.value;//Code added for IN23562  --08/09/2010-- priya -end
			
			var fract_dose_round_up_yn = formObj.fract_dose_round_up_yn.value;
			var split_dose_yn_val = formObj.split_dose_yn_val.value;
			var strength_per_pres_uom = formObj.strength_per_pres_uom.value;
			var strength_per_value_pres_uom = formObj.strength_per_value_pres_uom.value;
			var dsg_reason	 =	encodeURIComponent(formObj.dsg_reason.value);
			var dup_reason	=	encodeURIComponent(formObj.dup_reason.value);
			var con_reason	=	encodeURIComponent(formObj.con_reason.value);

			var int_reason	=	encodeURIComponent(formObj.int_reason.value);
			var alg_reason	=	encodeURIComponent(formObj.alg_reason.value);
			if(dosage_by == "S"){
				dose_uom = formObj.pres_base_uom.value;
			}

			if(weight == '' || weight == null)
				weight='0';
			if(bsa == '' || bsa == null)
				bsa='0';

			var route_code = formObj.route_code.value; //Added in January 2014 for Dosage check
			var qty_desc_code = formObj.qty_desc.value; //Added in January 2014 for Dosage check

			var xmlStr ="<root><SEARCH ";
			xmlStr += " patient_id=\""+ patient_id + "\" ";
			xmlStr += " encounter_id=\""+ encounter_id + "\" ";
			xmlStr += " drug_code=\""+ drug_code + "\" ";
			xmlStr += " srl_no=\""+ srl_no + "\" ";
			xmlStr += " bean_id=\""+ bean_id + "\" ";
			xmlStr += " bean_name=\""+ bean_name + "\" ";
			xmlStr += " ext_prod_id=\""+ ext_prod_id + "\" ";
			xmlStr += " weight=\""+ weight + "\" ";
			xmlStr += " bsa=\""+ bsa + "\" ";
			xmlStr += " dosage=\""+ dosage+ "\" ";
			xmlStr += " dose_uom=\""+ dose_uom + "\" ";
			xmlStr += " dosage_by=\""+ dosage_by + "\" ";
			xmlStr += " repeat_value=\""+ repeat_value + "\" ";
			xmlStr += " interval_value=\""+ interval_value + "\" ";
			xmlStr += " duration=\""+ duration + "\" ";
			xmlStr += " repeat_durn_type=\""+ repeat_durn_type + "\" ";//Code added for IN23562 --08/09/2010-- priya -start
			xmlStr += " durn_type=\""+ durn_type + "\" ";
			xmlStr += " freq_nature=\""+ freq_nature + "\" ";
			xmlStr += " tmp_durn_value=\""+ tmp_durn_value + "\" ";//Code added for IN23562 --08/09/2010-- priya -end
			xmlStr += " fract_dose_round_up_yn=\""+ fract_dose_round_up_yn + "\" ";
			xmlStr += " split_dose_yn=\""+ split_dose_yn_val + "\" ";
			xmlStr += " strength_per_pres_uom=\""+ strength_per_pres_uom + "\" ";
			xmlStr += " strength_per_value_pres_uom=\""+ strength_per_value_pres_uom + "\" ";
			xmlStr += " pract_name=\""+ encodeURIComponent(pract_name) + "\" ";
			xmlStr += " dsg_reason=\""+ dsg_reason + "\" ";
			xmlStr += " dup_reason=\""+ dup_reason + "\" ";
			xmlStr += " con_reason=\""+ con_reason + "\" ";
			xmlStr += " int_reason=\""+ int_reason + "\" ";
			xmlStr += " alg_reason=\""+ alg_reason + "\" ";
			xmlStr += " drug_db_dosecheck_yn=\""+ drug_db_dosecheck_yn + "\" ";
			xmlStr += " drug_db_product_id=\""+ drug_db_product_id + "\" ";
			xmlStr += " drug_db_duptherapy_yn=\""+ drug_db_duptherapy_yn + "\" ";
			xmlStr += " drug_db_interact_check_yn=\""+ drug_db_interact_check_yn + "\" ";
			xmlStr += " drug_db_contraind_check_yn=\""+ drug_db_contraind_check_yn + "\" ";
			xmlStr += " drug_db_allergy_check_yn=\""+ drug_db_allergy_check_yn + "\" ";
			xmlStr += " tappered_over=\""+ tappered_over + "\" ";
			xmlStr += " route_code=\""+ route_code + "\" ";	  // Added in January 2014 for CIMS Dosage checks
 			xmlStr += " qty_desc_code=\""+ qty_desc_code + "\" ";	  // Added in January 2014 for CIMS Dosage checks
			xmlStr += " callfrom=\""+ callfrom + "\" ";
			xmlStr +=" /></root>";
			fieldValidation(xmlStr,"extDosageCheck");
		//}
	}
}

function extDosageCheckFromPad(drug_code, srl_no, ext_prod_id, callfrom){
	if(callfrom == 'PAD')
		if(eval(document.getElementById("ext_ddb_override_indc"+srl_no)).className != "SHIFTTOTAL")
			return false;
	var header_formObj = '';
	header_formObj = parent.parent.f_header.document.prescription_header_form;
    var drug_db_interface_yn       = header_formObj.drug_db_interface_yn.value;
	var drug_db_product_id = header_formObj.drug_db_product_id.value;
	var drug_db_dosecheck_yn =  header_formObj.drug_db_dosecheck_yn.value;
	var drug_db_duptherapy_yn       =  header_formObj.drug_db_duptherapy_yn.value;
	var drug_db_interact_check_yn  =  header_formObj.drug_db_interact_check_yn.value;
	var drug_db_contraind_check_yn =  header_formObj.drug_db_contraind_check_yn.value;
	var drug_db_allergy_check_yn    =  header_formObj.drug_db_allergy_check_yn.value;

	if(drug_db_interface_yn == 'Y' ){
		if(ext_prod_id != ""){
			var formObj = "";
			formObj = document.prescription_form;
			var patient_id = formObj.patient_id.value;
			var encounter_id = formObj.encounter_id.value;
			var weight = formObj.weight.value;
			var bsa = formObj.bsa.value;
			var pract_name	=	unescape(header_formObj.pract_name.value);
			if(weight == "")
				weight="0";
			if(bsa == "")
				bsa="0";
			var bean_id			= "@PrescriptionBean_1"+patient_id+encounter_id;
			var bean_name		= "ePH.PrescriptionBean_1";
			var xmlStr ="<root><SEARCH ";
			xmlStr += " patient_id=\""+ patient_id + "\" ";
			xmlStr += " encounter_id=\""+ encounter_id + "\" ";
			xmlStr += " bean_id=\""+ bean_id + "\" ";
			xmlStr += " bean_name=\""+ bean_name + "\" ";
			xmlStr += " weight=\""+ weight + "\" ";
			xmlStr += " bsa=\""+ bsa + "\" ";

			xmlStr += " pract_name=\""+ encodeURIComponent(pract_name) + "\" ";
			xmlStr += " drug_code=\""+ drug_code + "\" ";
			xmlStr += " srl_no=\""+ srl_no + "\" ";
			xmlStr += " ext_prod_id=\""+ ext_prod_id + "\" ";
			xmlStr += " drug_db_product_id=\""+ drug_db_product_id + "\" ";
			xmlStr += " drug_db_dosecheck_yn=\""+ drug_db_dosecheck_yn + "\" ";
			xmlStr += " drug_db_duptherapy_yn=\""+ drug_db_duptherapy_yn + "\" ";
			xmlStr += " drug_db_interact_check_yn=\""+ drug_db_interact_check_yn + "\" ";
			xmlStr += " drug_db_contraind_check_yn=\""+ drug_db_contraind_check_yn + "\" ";
			xmlStr += " drug_db_allergy_check_yn=\""+ drug_db_allergy_check_yn + "\" ";
			xmlStr += " callfrom=\""+ callfrom + "\" ";
			xmlStr +=" /></root>";
			fieldValidation(xmlStr,"extDosageCheckFromPad");
		}
	}
}

async function displayDosageCheckResult(patient_id, pract_name, encounter_id, ext_prod_id, drug_code, srl_no, drug_db_dosage_check_flag, drug_db_duptherapy_flag, drug_db_contraind_check_flag, drug_db_interact_check_flag,  drug_db_allergy_flag, dsg_reason, dup_reason, con_reason, int_reason, alg_reason, callFrom){
	pract_name = unescape(pract_name);

	var dialogHeight	= "50vh" ;
	var dialogWidth	    = "75vw";
	var dialogTop	    = "100" ;
	var dialogLeft	    = "100" ;
	var center			= "0" ;
	var status			= "no";
	var features	    = "dialogHeight:" + dialogHeight +"; dialogLeft:"+dialogLeft+ "; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop;
	var arguments	= "";

	if(callFrom =='PADLOAD'){ 
		eval(document.getElementById("ext_ddb_override_indc"+srl_nop)).className="SHIFTTOTAL";
		if( (drug_db_contraind_check_flag=="Y" && con_reason=="") || (drug_db_interact_check_flag=="Y" && int_reason=="")  || (drug_db_dosage_check_flag=="Y" && dsg_reason=="") || (drug_db_duptherapy_flag=="Y" && dup_reason=="")|| (drug_db_allergy_flag=="Y" && alg_reason=="")){
			eval(document.getElementById("ext_ddb_override_img"+srl_no)).style.visibility ="visible";
		}
		else if(drug_db_contraind_check_flag=="N" && drug_db_interact_check_flag=="N" && drug_db_dosage_check_flag=="N" && drug_db_duptherapy_flag=="N" && drug_db_allergy_flag=="N"){ //else if condition added for IN25277  --06/01/2011-- priya
			eval(document.getElementById("ext_ddb_override_img"+srl_no)).style.visibility ="hidden";
			eval(document.getElementById("ext_ddb_override_indc"+srl_no)).className =eval(document.getElementById("drug_"+drug_code+"_"+srl_no)).className;
		}
		else
			eval(document.getElementById("ext_ddb_override_img"+srl_no)).style.visibility ="hidden";
		if(eval(document.getElementById("ovr_dosage"+srl_no)) != undefined){
			if(drug_db_dosage_check_flag == 'Y')
				eval(document.getElementById("ovr_dosage"+srl_no)).style.visibility ="hidden";
			else
				eval(document.getElementById("ovr_dosage"+srl_no)).style.visibility ="visible";
		}
		/*if(eval("document.getElementById("allergy")"+srl_no) != undefined){
			if(drug_db_allergy_flag == 'Y'){
				eval("document.getElementById("allergy")"+srl_no).style.visibility ="hidden";
			}
			else{
				eval("document.getElementById("allergy")"+srl_no).style.visibility ="visible";
			}
		}*/ //Commented for SKR-SCF-0709 [IN:036138] - color indicator
		if(eval(document.getElementById("currentrx"+srl_no)) != undefined){
			if(drug_db_duptherapy_flag == 'Y'){
				eval(document.getElementById("currentrx"+srl_no)).style.visibility ="hidden";
			}
			else{
				eval(document.getElementById("currentrx"+srl_no)).style.visibility ="visible";
			}
		}	
	}
	else if(callFrom !='PAD'){
		if(eval(parent.f_prescription.f_prescription_form.document.getElementById("ext_ddb_override_indc"+srl_no)) != undefined){
			eval(parent.f_prescription.f_prescription_form.document.getElementById("ext_ddb_override_indc"+srl_no)).className="SHIFTTOTAL";
		}
		if(drug_db_dosage_check_flag=="Y" && dsg_reason=="") 
			eval("parent.f_prescription.f_prescription_form.prescription_form.ext_ddb_override_img"+srl_no+".style").visibility="visible";

		if(eval(parent.f_prescription.f_prescription_form.document.getElementById("ovr_dosage"+srl_no)) != undefined){
			if(drug_db_dosage_check_flag == 'Y')
				eval(parent.f_prescription.f_prescription_form.document.getElementById("ovr_dosage"+srl_no)).style.visibility ="hidden";
			else
				eval(parent.f_prescription.f_prescription_form.document.getElementById("ovr_dosage"+srl_no)).style.visibility ="visible";
		}
		/*if(eval("parent.f_prescription.f_prescription_form.document.getElementById("allergy")"+srl_no) != undefined){
			if(drug_db_allergy_flag == 'Y')
				eval("parent.f_prescription.f_prescription_form.document.getElementById("allergy")"+srl_no).style.visibility ="hidden";
			else
				eval("parent.f_prescription.f_prescription_form.document.getElementById("allergy")"+srl_no).style.visibility ="visible";
		}*/ //Commented for SKR-SCF-0709 [IN:036138] - color indicator
		if(eval(parent.f_prescription.f_prescription_form.document.getElementById("currentrx"+srl_no)) != undefined){
			if(drug_db_duptherapy_flag == 'Y'){
				eval(parent.f_prescription.f_prescription_form.document.getElementById("currentrx"+srl_no)).style.visibility ="hidden";
			}
			else
				eval(parent.f_prescription.f_prescription_form.document.getElementById("currentrx"+srl_no)).style.visibility ="visible";
		}	
	}
	if(callFrom =='PAD'){		
		retVal = await top.window.showModalDialog("../../ePH/jsp/MedicationAlerts.jsp?patient_id="+patient_id+"&pract_name="+encodeURIComponent(pract_name)+"&encounter_id="+encounter_id+"&external_product_id="+ext_prod_id+"&srl_no="+srl_no+"&drug_db_dosecheck_flag="+drug_db_dosage_check_flag+"&drug_db_interact_check_flag="+drug_db_interact_check_flag+"&drug_db_duptherapy_flag="+ drug_db_duptherapy_flag+"&drug_db_contraind_check_flag="+ drug_db_contraind_check_flag+"&drug_db_allergy_flag="+drug_db_allergy_flag+"&dsg_reason="+escape(dsg_reason)+"&dup_reason="+escape(dup_reason)+"&con_reason="+escape(con_reason)+"&int_reason="+escape(int_reason)+"&alg_reason="+escape(alg_reason),arguments,features);
		if(retVal != undefined && retVal[0] != 'CANCEL' ){
			var dsg_yn = "";
			var dsg_reason ="";
			var dup_yn = "";
			var dup_reason ="";
			var int_yn = "";
			var int_reason = ""; 
			var con_yn = "";
			var con_reason = "";
			var alg_yn = "";
			var alg_reason = "";
			for(var i=0;  i<retVal.length; i++){
				if( retVal[i].substring(0,3) == "DSG"){
					dsg_yn = retVal[i].substring(0,5);
					dsg_reason = retVal[i].substring(5);
				}
				else if( retVal[i].substring(0,3) == "DUP"){
					dup_yn = retVal[i].substring(0,5);
					dup_reason = retVal[i].substring(5);
				}
				else if( retVal[i].substring(0,3) == "INT"){
					int_yn = retVal[i].substring(0,5);
					int_reason = retVal[i].substring(5);
				}
				else if( retVal[i].substring(0,3) == "CON"){
					con_yn = retVal[i].substring(0,5);
					con_reason = retVal[i].substring(5);
				}
				else if( retVal[i].substring(0,3) == "ALG"){
					alg_yn = retVal[i].substring(0,5);
					alg_reason = retVal[i].substring(5);
				}
			}
			if(callFrom !='PAD'){
				if( (dsg_yn=="DSG_Y" && dsg_reason=="") || (dup_yn=="DUP_Y" && dup_reason=="") || (int_yn=="INT_Y" && int_reason=="") || (con_yn=="CON_Y" && con_reason=="") || (alg_yn=="ALG_Y" && alg_reason=="")){
					eval(parent.f_prescription.f_prescription_form.prescription_form.document.getElementById("ext_ddb_override_img"+srl_no)).style.visibility ="visible";
				}
				else{
					eval(parent.f_prescription.f_prescription_form.prescription_form.document.getElementById("ext_ddb_override_img"+srl_no)).style.visibility ="hidden";
				}
				var formObj =	  document.prescription_detail_form;
				var bean_id		=	formObj.bean_id.value;
				var bean_name	=	formObj.bean_name.value;
				formObj.dsg_reason.value = dsg_reason;
				formObj.dup_reason.value = dup_reason;
				formObj.int_reason.value = int_reason;
				formObj.con_reason.value = con_reason;
				formObj.alg_reason.value = alg_reason;
			}
			else{
				if( (dsg_yn=="DSG_Y" && dsg_reason=="") || (dup_yn=="DUP_Y" && dup_reason=="") || (int_yn=="INT_Y" && int_reason=="") || (con_yn=="CON_Y" && con_reason=="") || (alg_yn=="ALG_Y" && alg_reason=="")){
					eval(document.getElementById("ext_ddb_override_img"+srl_no)).style.visibility ="visible";
				}
				else{
					eval(document.getElementById("ext_ddb_override_img"+srl_no)).style.visibility ="hidden";
				}
				var formObj =	  document.prescription_form;
				var bean_id		=	formObj.bean_id.value;
				var bean_name	=	formObj.bean_name.value;
			}
			var xmlStr ="<root><SEARCH ";					
			xmlStr+= "dsg_reason =\"" + encodeURIComponent(dsg_reason,"UTF-8") + "\" " ;
			xmlStr+= "dup_reason =\"" + encodeURIComponent(dup_reason,"UTF-8") + "\" " ;
			xmlStr+= "int_reason =\"" + encodeURIComponent(int_reason,"UTF-8") + "\" " ;
			xmlStr+= "con_reason =\"" + encodeURIComponent(con_reason,"UTF-8") + "\" " ;
			xmlStr+= "alg_reason =\"" + encodeURIComponent(alg_reason,"UTF-8") + "\" " ;
			xmlStr+= "drug_db_dosage_check_flag =\"" +drug_db_dosage_check_flag + "\" " ;
			xmlStr+= "drug_db_interact_check_flag =\"" + drug_db_interact_check_flag+ "\" " ;
			xmlStr+= "drug_db_duptherapy_flag =\"" +drug_db_duptherapy_flag+ "\" " ;
			xmlStr+= "drug_db_contraind_check_flag =\"" + drug_db_contraind_check_flag+ "\" " ;
			xmlStr+= "drug_db_allergy_flag =\"" + drug_db_allergy_flag+ "\" " ;
			xmlStr+= "drug_code =\"" + drug_code + "\" " ;
			xmlStr+= "srl_no =\"" + srl_no + "\" " ;
			xmlStr+= "bean_id =\"" + bean_id + "\" " ;
			xmlStr+= "bean_name=\"" + bean_name + "\" " ;
			xmlStr +=" /></root>";
			fieldValidation(xmlStr,"extDosageCheckResult");
		}
		else{
			if(callFrom =='PAD'){
			//	if(dsg_reason ==""){
				if( (drug_db_contraind_check_flag=="Y" && con_reason=="") || (drug_db_interact_check_flag=="Y" && int_reason=="")  || (drug_db_dosage_check_flag=="Y" && dsg_reason=="") || (drug_db_duptherapy_flag=="Y" && dup_reason=="")|| (drug_db_allergy_flag=="Y" && alg_reason=="")){
					eval("document.prescription_form.ext_ddb_override_img"+srl_no+".style").visibility="visible";
				}
			}
		}
	}
}

function hideDosageCheckIcon(drug_code, srl_no){
	try{
		// added for incident SRR20056-SCF-6435.3[Incident No. 27028]
		var amend_yn = eval("parent.f_prescription.f_prescription_form.prescription_form.amend_yn_"+srl_no).value;
		var	classname = 'SELECTEDRUGS';
		if(amend_yn!= undefined && amend_yn!= null && amend_yn=="Y")
			classname = 'AMENDEDDRUGS';

		// End of SRR20056-SCF-6435.3[Incident No. 27028]
		eval("parent.f_prescription.f_prescription_form.prescription_form.ext_ddb_override_img"+srl_no+".style").visibility="hidden";
		//eval("parent.f_prescription.f_prescription_form.document.getElementById("ext_ddb_override_indc")"+srl_no).className =eval("parent.f_prescription.f_prescription_form.document.getElementById("drug_")"+drug_code+"_"+srl_no).className;
		eval(parent.f_prescription.f_prescription_form.document.getElementById("ext_ddb_override_indc"+srl_no)).className =classname;  // added for incident SRR20056-SCF-6435.3[Incident No. 27028]
	}
	catch(e){
	}
}

function changeCursor1(obj){
	if(obj.className == "SHIFTTOTAL")
		changeCursor(obj);
}

function assignTradeCode(obj){
	document.forms[0].trade_code.value = obj.options[obj.selectedIndex].value;
	document.forms[0].trade_name.value = obj.options[obj.selectedIndex].text;
}

function validDateFormat(obj, locale){
	if(obj.value){
		if(!validDate(obj.value, 'DMY',locale)){
			alert(getMessage("INVALID_DATE_TIME", "PH"));
			obj.value="";
			obj.select();
			obj.focus();
			return false;
		}
	}
}

function CheckPositiveNumber1(obj){
    if ( trimCheck(obj.value) && isNaN(obj.value) == false && obj.value >= 0) {
    }
    else {
        if ( obj.value.length > 0 ) {
            alert(getMessage("INVALID_POSITIVE_NUMBER", "Common"));
            obj.select();
            obj.focus();
			return false
        }
        else if ( obj.value.length == 0 )
            obj.value = 0;
    }
	return true;
}

/******************************BILLING RELATED FUNCTIONS *********************************/
function getChargeDetails(in_formulary_yn, called_from){
	var totalTaperQtyDisplay	=	document.prescription_detail_form.totalTaperQtyDisplay.value;
    if(document.prescription_detail_form!=null && called_from!='TAPER_QTY'){		   
		if(document.prescription_detail_form.bl_override_excl_incl_ind!=document.prescription_detail_form.bl_def_override_excl_incl_ind){ // condition added to display patient payable properly on load  after assign override -- priya --09/03/2010
			called_from = "ASSIGN_OVERRIDE";
		}
	}

	if(in_formulary_yn =='N')
		return;

	var frameobj;

	if(parent.f_header==null) {
		frameobj					=	parent.parent.f_header;
	}
	else {
		frameobj					=	parent.f_header;
	}

	var bl_install_yn				=	frameobj.document.prescription_header_form.bl_install_yn.value;
	var bl_disp_charge_dtl_in_rx_yn	=	frameobj.document.prescription_header_form.bl_disp_charge_dtl_in_rx_yn.value;
	if(bl_install_yn!='Y' || bl_disp_charge_dtl_in_rx_yn!='Y')
		return false;

	var patient_id						= frameobj.document.prescription_header_form.patient_id.value;
	var encounter_id					= frameobj.document.prescription_header_form.encounter_id.value;
	var order_Date						= frameobj.document.prescription_header_form.sys_date.value;
	var	episode_type					= frameobj.document.prescription_header_form.actual_patient_class.value;

	if(episode_type!='')
		episode_type					= episode_type.substring(0,1);
	var durn_value						=	document.prescription_detail_form.tmp_durn_value.value;//changed temp_drug_value to durn_value for MMS-DM-CRF-126.1 reverted for tbmc-scf-0051 and SKR-SCF-1237
	var interval_value					=	document.prescription_detail_form.interval_value.value;
	var qty_desc_code					=   document.prescription_detail_form.qty_desc.value;	
	var bl_override_excl_incl_ind	    =	document.prescription_detail_form.bl_override_excl_incl_ind.value;
	var bl_def_override_excl_incl_ind	=	document.prescription_detail_form.bl_def_override_excl_incl_ind.value;
	var bl_overriden_action_reason	    =	document.prescription_detail_form.bl_incl_excl_override_reason_code.value;
	var qty_value						=   document.prescription_detail_form.qty_value.value;
	var dosage_type						=   document.prescription_detail_form.dosage_type.value;
	var billable_item_yn				=   document.prescription_detail_form.billable_item_yn.value;
	var take_home_medication	=  frameobj.document.prescription_header_form.take_home_medication.value;
	
	var pat_brought_medn = "N";
//	if(document.prescription_detail_form.brought_by_pat!= undefined) //// added for IN23880 --25/10/2010-- priya
//	{ 
//		pat_brought_medn = document.prescription_detail_form.brought_by_pat.value;
//	} 
		//// added for IN23880 --25/10/2010-- priya
		if(document.prescription_detail_form.brought_by_pat!= undefined && document.prescription_detail_form.brought_by_pat!= null){
			if(document.prescription_detail_form.brought_by_pat.checked == true)
				document.prescription_detail_form.brought_by_pat.value = "Y";
			else
				document.prescription_detail_form.brought_by_pat.value = "N";

			//Below Line Is Added By SureshKumar T For The Incident No : SRR20056-SCF-7079 [Inc : 26839 ] */
			pat_brought_medn = 	document.prescription_detail_form.brought_by_pat.value;
		} 

	/*if(bl_def_override_excl_incl_ind == bl_override_excl_incl_ind){
		bl_override_excl_incl_ind='';
	}*///commented by naveen

	if((called_from!=undefined && called_from=="ABS_QTY")|| document.prescription_detail_form.absol_qty.style.display!= 'none'){
		qty_value	= document.prescription_detail_form.absol_qty.value;
		dosage_type = "A";
		if(qty_value==0){
			 qty_value=1;
		}
	}
	if(totalTaperQtyDisplay=='Y'){
		if( called_from!=undefined && called_from=='TAPER_QTY')
			qty_value	= document.prescription_detail_form.totTapperQty.value;
		else{
			drug_tapered =document.prescription_detail_form.drug_tapered.value;
			tappered_over =document.prescription_detail_form.tappered_over.value;
			if(drug_tapered=='Y' || tappered_over=='Y'){
				qty_value	= document.prescription_detail_form.totTapperQty.value;
				called_from='TAPER_QTY';
			}
		}
	}
	var drug_code				=	document.prescription_detail_form.drug_code.value;
	var srl_no					=	document.prescription_detail_form.srl_no.value;
	var repeat_value			=	document.prescription_detail_form.repeat_value.value;
	var sliding_scale_yn		=	document.forms[0].sliding_scale_yn.value;
	var amend_yn                =  document.prescription_detail_form.amend_yn.value;
	if(amend_yn=='N'&&bl_def_override_excl_incl_ind=='')
		 bl_override_excl_incl_ind ="";
		  
	var fldString=" patient_id=\""+ patient_id + "\" ";
		fldString += " encounter_id=\""+ encounter_id + "\" ";
		fldString += " episode_type=\""+ episode_type + "\" ";
		fldString += " qty_value=\""+ qty_value + "\" ";
		fldString += " qty_desc_code=\""+ qty_desc_code + "\" ";
		fldString += " dosage_type=\""+ dosage_type + "\" ";
		fldString += " repeat_value=\""+ repeat_value + "\" ";
		fldString += " drug_code=\""+ drug_code + "\" ";
		fldString += " srl_no=\""+ srl_no + "\" ";
		fldString += " durn_value=\""+ durn_value + "\" ";		
		fldString += " interval_value=\""+ interval_value + "\" ";		
		fldString += " order_Date=\""+ order_Date + "\" ";		
		fldString += " bl_override_excl_incl_ind=\""+ bl_override_excl_incl_ind + "\" ";		
		fldString += " bl_overriden_action_reason=\""+ bl_overriden_action_reason + "\" ";		
		fldString += " called_from=\""+ called_from + "\" ";	
		fldString += " pat_brought_medn=\""+ pat_brought_medn + "\" ";	// added for IN23880 --25/10/2010-- priya
		fldString += " sliding_scale_yn=\""+ sliding_scale_yn + "\" ";	
		fldString += " billable_item_yn=\""+ billable_item_yn + "\" ";	
		fldString += " take_home_medication=\""+ take_home_medication + "\" ";	
	var formobj=document.prescription_detail_form;
	var xmlStr=formXMLString(formobj,fldString);
	fieldValidation(xmlStr,"getChargeDetails");
	return true;
}

/*function getChargeDetails_Pad(drug_code, srl_no, dosage_type, qty_value, qty_desc_code, durn_value,repeat_value ){
	var frameobj;
	if(parent.f_header==null) {
		frameobj	=	parent.parent.f_header;
	}
	else {
		frameobj	=	parent.f_header;
	}
	var patient_id=frameobj.document.prescription_header_form.patient_id.value;
	var encounter_id	=frameobj.document.prescription_header_form.encounter_id.value;
	var order_Date  = frameobj.document.prescription_header_form.sys_date.value;
	var discharge_yn  = frameobj.document.prescription_header_form.take_home_medication.value;
	var episode_type = "";
	if(discharge_yn=='Y')
		episode_type = frameobj.document.prescription_header_form.patient_class.value;
	else
		episode_type = frameobj.document.prescription_header_form.actual_patient_class.value;

	if(episode_type!='')
		episode_type = episode_type.substring(0,1);

	var fldString=" patient_id=\""+ patient_id + "\" ";
	fldString += " encounter_id=\""+ encounter_id + "\" ";
	fldString += " episode_type=\""+ episode_type + "\" ";
	fldString += " qty_value=\""+ qty_value + "\" ";
	fldString += " qty_desc_code=\""+ qty_desc_code + "\" ";
	fldString += " dosage_type=\""+ dosage_type + "\" ";
	fldString += " repeat_value=\""+ repeat_value + "\" ";
	fldString += " drug_code=\""+ drug_code + "\" ";
	fldString += " srl_no=\""+ srl_no + "\" ";
	fldString += " durn_value=\""+ durn_value + "\" ";		
	fldString += " order_Date=\""+ order_Date + "\" ";		
	fldString += " called_from=\""+ "CHARGE_PAD" + "\" ";		
	var formobj=document.prescription_form;
	var xmlStr=formXMLString(formobj,fldString);
	fieldValidation(xmlStr,"getChargeDetails");
	return true;
}*/

function assignChargeDetails(gross_charge_amt,bl_total_charge_amt, bl_patient_payable_amt, bl_def_excl_incl_ind, bl_approval_reqd_yn, bl_override_allowed_yn, bl_error_code, bl_sys_message_id, bl_error_text,bl_override_excl_incl_ind_changed){
	//gross_charge_amt added for ML-BRU-CRF-0469

	if(bl_error_code=='' && bl_sys_message_id=='' && bl_error_text ==''){
		var bl_override_excl_incl_ind = bl_def_excl_incl_ind;
		document.getElementById("BL_HEADER").style='display';
		document.getElementById("BL_VALUES").style='display';
		document.getElementById("BL_HEADERBAR").style='display';
		document.prescription_detail_form.bl_def_override_excl_incl_ind.value =bl_def_excl_incl_ind;

        if(bl_override_allowed_yn =='I'){
			document.prescription_detail_form.bl_override_excl_incl_ind.options.length =2;
			document.prescription_detail_form.bl_override_excl_incl_ind.options[0].value = 'SEL';
			document.prescription_detail_form.bl_override_excl_incl_ind.options[0].text = '----- '+getLabel("Common.defaultSelect.label", "Common")+' -----';
			document.prescription_detail_form.bl_override_excl_incl_ind.options[1].value = 'I';
			document.prescription_detail_form.bl_override_excl_incl_ind.options[1].text = getLabel("Common.Include.label", "Common");
		}
		else if(bl_override_allowed_yn =='E'){
			document.prescription_detail_form.bl_override_excl_incl_ind.options.length =2;
			document.prescription_detail_form.bl_override_excl_incl_ind.options[0].value = 'SEL';
			document.prescription_detail_form.bl_override_excl_incl_ind.options[0].text = '----- '+getLabel("Common.defaultSelect.label", "Common")+' -----';
			document.prescription_detail_form.bl_override_excl_incl_ind.options[1].value = 'E';
			document.prescription_detail_form.bl_override_excl_incl_ind.options[1].text = getLabel("Common.Exclude.label", "Common");
		}
		else if(bl_override_allowed_yn =='B'){
			document.prescription_detail_form.bl_override_excl_incl_ind.options.length =3;
			document.prescription_detail_form.bl_override_excl_incl_ind.options[0].value = 'SEL';
			document.prescription_detail_form.bl_override_excl_incl_ind.options[0].text = '----- '+getLabel("Common.defaultSelect.label", "Common")+' -----';
			document.prescription_detail_form.bl_override_excl_incl_ind.options[1].value = 'I';
			document.prescription_detail_form.bl_override_excl_incl_ind.options[1].text = getLabel("Common.Include.label", "Common");
			document.prescription_detail_form.bl_override_excl_incl_ind.options[2].value = 'E';
			document.prescription_detail_form.bl_override_excl_incl_ind.options[2].text = getLabel("Common.Exclude.label", "Common");
		}
		else{
			document.prescription_detail_form.bl_override_excl_incl_ind.options.length =1;
			document.prescription_detail_form.bl_override_excl_incl_ind.options[0].value = 'SEL';
			document.prescription_detail_form.bl_override_excl_incl_ind.options[0].text = '----- '+getLabel("Common.defaultSelect.label", "Common")+' -----';
		}
/*================================================================================================================*/
//added while fixing IN26429_reopen --15/02/2011-- priya (to default override incl/excl value in amend mode for sld_scale)
	var bl_override_excl_incl_ind_amend_load = "";
	if(document.prescription_detail_form.sliding_scale_yn.value == "Y"){
		  bl_override_excl_incl_ind_amend_load = document.prescription_detail_form.bl_override_excl_incl_ind_amend_load.value;
	}
	if(bl_override_excl_incl_ind_amend_load!="")
		document.prescription_detail_form.bl_override_excl_incl_ind.value = bl_override_excl_incl_ind_amend_load;
/*================================================================================================================*/

		//if(bl_override_allowed_yn !='Y'){ //bl_override_allowed_yn == 'N' //commented By Naveen
		if(bl_override_allowed_yn ==''){ //bl_override_allowed_yn == 'N'
			document.prescription_detail_form.bl_override_excl_incl_ind.disabled=true;
		}
		else{
/*	//commented By Naveen
           if(document.prescription_detail_form.bl_override_excl_incl_ind.value == 'SEL'){
				document.prescription_detail_form.bl_override_excl_incl_ind.value = bl_def_excl_incl_ind;
			}
			bl_override_excl_incl_ind = document.prescription_detail_form.bl_override_excl_incl_ind.value;
			*/
            if(bl_override_excl_incl_ind_changed=='')
	              bl_override_excl_incl_ind_changed =bl_override_excl_incl_ind ;

			/*if((bl_override_allowed_yn=='I' && bl_override_excl_incl_ind_changed =='I') ||(bl_override_allowed_yn=='E' && bl_override_excl_incl_ind_changed =='E')||(bl_override_allowed_yn=='B' && bl_override_excl_incl_ind_changed =='I')){
				document.prescription_detail_form.bl_override_excl_incl_ind.selectedIndex = 1;
			}else if(bl_override_allowed_yn=='B' && bl_override_excl_incl_ind_changed =='E')
			{
                document.prescription_detail_form.bl_override_excl_incl_ind.selectedIndex = 2;

			}else{
				document.prescription_detail_form.bl_override_excl_incl_ind.selectedIndex = 0;	
			}*/
		}
		//document.prescription_detail_form.bl_override_excl_incl_ind.value = bl_override_excl_incl_ind;
	
		
		if(document.prescription_detail_form.billable_item_yn.value == "N"){
			document.getElementById('gross_charge_amt').innerHTML ="--";//gross_charge_amt added for ML-BRU-CRF-0469
			document.getElementById('bl_total_charge_amt').innerHTML ="--";
			document.getElementById('bl_patient_payable_amt').innerHTML = "--";
		}
		else if(document.prescription_detail_form.brought_by_pat!=null && document.prescription_detail_form.brought_by_pat!=undefined && document.prescription_detail_form.brought_by_pat.checked == true){
			document.getElementById('gross_charge_amt').innerHTML ="--";//gross_charge_amt added for ML-BRU-CRF-0469
			document.getElementById('bl_total_charge_amt').innerHTML ="--";
			document.getElementById('bl_patient_payable_amt').innerHTML = "--";
		}
		else{
			//added for GHL-CRF-0508 start
		var default_freq_not_found =""; //added for TBMC-SCF-0166
		if(document.prescription_detail_form.default_freq_not_found!=undefined) //added for TBMC-SCF-0166
				default_freq_not_found = document.prescription_detail_form.default_freq_not_found.value;
	    var freq_code  =document.prescription_detail_form.frequency.value;
		if(freq_code=="" && default_freq_not_found){
				document.getElementById('gross_charge_amt').innerHTML ="--";
				document.getElementById('bl_total_charge_amt').innerHTML ="--";
				document.getElementById('bl_patient_payable_amt').innerHTML = "--";
			 }else{ //added for GHL-CRF-0508 end	
			document.getElementById('bl_total_charge_amt').innerHTML = bl_total_charge_amt;
			document.getElementById('bl_patient_payable_amt').innerHTML = bl_patient_payable_amt;
			}
		}		

		document.prescription_detail_form.bl_override_excl_incl_ind.style="display";

		if(bl_approval_reqd_yn=='Y')
			document.getElementById('bl_approval_reqd_yn').innerHTML = "<img src='../../eCommon/images/enabled.gif'></img>";
		else if(bl_approval_reqd_yn=='N')
			document.getElementById('bl_approval_reqd_yn').innerHTML = "<img src='../../eCommon/images/disabled.gif'></img>" ;
		else
			document.getElementById('bl_approval_reqd_yn').innerHTML = "&nbsp" ;



		// commented By Naveen
		if(bl_def_excl_incl_ind=='I'){
			document.getElementById('bl_def_override_excl_incl_ind_gif').innerHTML = "<img src='../../eCommon/images/enabled.gif'></img>";
			//document.getElementById('bl_override_excl_incl_ind_lbl').innerText = getLabel("Common.Exclude.label","Common")+"?";
			//document.getElementById("bl_override_excl_incl_ind").checked=false;
		}
		else if(bl_def_excl_incl_ind=='E'){
			document.getElementById('bl_def_override_excl_incl_ind_gif').innerHTML = "<img src='../../eCommon/images/disabled.gif'></img>" ;
			//document.getElementById('bl_override_excl_incl_ind_lbl').innerText = getLabel("Common.Include.label","Common")+"?";
		}/*else{
			document.getElementById('bl_def_override_excl_incl_ind_gif').innerHTML = "--" ;
			document.getElementById('bl_override_excl_incl_ind_lbl').innerText = getLabel("Common.Exclude.label","Common")+"?";
			document.getElementById('td_bl_override_excl_incl_ind').innerHTML ="<input type='checkbox' name='bl_override_excl_incl_ind' id='bl_override_excl_incl_ind' value='' onclick='assignOverrideExclInclInd(this)' style='display:none;'>--" ;
		}*/
//assignOverrideExclInclInd(document.getElementById("bl_override_excl_incl_ind"));//priya
	}
}

function assignOverrideExclInclInd(obj){
	var bl_def_override_excl_incl_ind = document.prescription_detail_form.bl_def_override_excl_incl_ind.value;

	/*if(bl_def_override_excl_incl_ind=='I' && obj.checked == true){
		obj.value = "E";
	}
	else if(bl_def_override_excl_incl_ind=='E' && obj.checked == true){
		obj.value = "I";
	}
	else obj.value ="";

	
	if(obj.checked == true){
		*/

 //  if(bl_def_override_excl_incl_ind != obj.value){
	if( obj.value!='SEL'){
		document.getElementById('bl_overriden_action_reason_img').style.visibility='visible';
		document.prescription_detail_form.bl_overriden_action_reason_lkp.disabled=false;
	}
	else{
		document.getElementById('bl_overriden_action_reason_img').style.visibility='hidden';
		document.prescription_detail_form.bl_overriden_action_reason_lkp.disabled=true;
		document.prescription_detail_form.bl_incl_excl_override_reason_code.value = "";
		document.prescription_detail_form.bl_incl_excl_override_reason_desc.value = "" ;
	}	
	getChargeDetails("Y","ASSIGN_OVERRIDE");
}

async function searchBLOverrideReason(locale){

	var formObj=document.prescription_detail_form;
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
	bean_id			   = formObj.bean_id.value;
	bean_name		   = formObj.bean_name.value;

	retVal = await CommonLookup(getLabel("Common.search.label","Common"), argumentArray);
	if(retVal != null && retVal != "") {
		document.prescription_detail_form.bl_incl_excl_override_reason_code.value = retVal[0];
		document.prescription_detail_form.bl_incl_excl_override_reason_desc.value =retVal[1] ;
	}
}

function getBLErrorDrugs(){
	var formobj			= document.prescription_form;
	var	frameobj	=	parent.parent.f_header;
	var patient_id=frameobj.document.prescription_header_form.patient_id.value;
	var encounter_id	=frameobj.document.prescription_header_form.encounter_id.value;
	var order_Date  = frameobj.document.prescription_header_form.sys_date.value;
	var	episode_type = frameobj.document.prescription_header_form.actual_patient_class.value;

	if(episode_type!='')
		episode_type = episode_type.substring(0,1);

	var fldString=" patient_id=\""+ patient_id + "\" ";
	fldString += " encounter_id=\""+ encounter_id + "\" ";
	fldString += " episode_type=\""+ episode_type + "\" ";
	fldString += " order_Date=\""+ order_Date + "\" ";		

	var xmlStr			= formXMLString(formobj,fldString);
	return fieldValidation(xmlStr,"getBLErrorDrugs");
}

function alertBLErrorDrugs(blErrorDrugs, called_from){
	blErrorDrugs = blErrorDrugs.substring(1,blErrorDrugs.length-2);
	blErrorDrugs = blErrorDrugs.split(',');
	var bl_alert_msg="";

	for(var i=0; i<blErrorDrugs.length; i++){
		drug_code	= trimString(blErrorDrugs[i++]);
		srl_no		= trimString(blErrorDrugs[i++]);
		drug_desc	= decodeURIComponent(trimString(blErrorDrugs[i++]));
		bl_error_code = trimString(blErrorDrugs[i++]);
		bl_sys_message_id = trimString(blErrorDrugs[i++]);
		bl_error_text = trimString(blErrorDrugs[i]);

		if ((bl_error_code == "10" && bl_error_text =="") || bl_sys_message_id!=""){
			if(bl_sys_message_id!=""){
				bl_error_text = getMessage(bl_sys_message_id,'BL');
			}
		}
	}
	bl_alert_msg += drug_desc+"  "+ bl_error_text+"\n";
	alert(bl_alert_msg);
	oper_mode = "delete";
	var formobj			= document.forms[0];
	var patient_id = formobj.patient_id.value;
	var encounter_id = formobj.encounter_id.value;
	var bean_id = formobj.bean_id.value;
	var bean_name = formobj.bean_name.value;
	var sliding_scale_yn = formobj.sliding_scale_yn.value;
	var patient_stock_yn = formobj.patient_stock_yn.value;//added for GHL-CRF-0482
	for(var i=0; i<blErrorDrugs.length; i+=6){
		drug_code	= trimString(blErrorDrugs[i]);
		srl_no		= trimString(blErrorDrugs[i+1]);
		var xmlStr ="<root><SEARCH ";
		xmlStr+=" patient_id=\""+ patient_id + "\" ";
		xmlStr+=" encounter_id=\""+ encounter_id + "\" ";
		xmlStr+=" drug_code=\""+ drug_code + "\" ";
		xmlStr+=" srl_no=\""+ srl_no + "\" ";
		xmlStr+=" oper_mode=\""+ oper_mode + "\" ";
		xmlStr+=" bean_id=\""+ bean_id + "\" ";
		xmlStr+=" bean_name=\""+ bean_name + "\" ";
		xmlStr+= " called_from=\""+ called_from + "\" ";
		xmlStr +=" /></root>";
		var xmlDoc = "" ;
		var xmlHttp = new XMLHttpRequest() ;
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open("POST","PrescriptionValidation_1.jsp?func_mode=InsertRec",false);
		xmlHttp.send(xmlDoc);
		responseText=xmlHttp.responseText ;
		eval(responseText);
	}
	if(called_from == 'BLERROR' || sliding_scale_yn=='Y'){
		var headerFromObj = parent.parent.f_header.prescription_header_form;
	}
	else
		var headerFromObj = parent.f_header.prescription_header_form;

	patient_class	= headerFromObj.patient_class.value;
	act_patient_class	= headerFromObj.actual_patient_class.value;
	take_home_medication	= headerFromObj.take_home_medication.value;
	bed_num			= headerFromObj.bed_num.value;
	room_num		= headerFromObj.room_num.value;
	weight			= headerFromObj.weight.value;
	bsa				= headerFromObj.bsa.value;
	drug_db_interface_yn	= headerFromObj.drug_db_interface_yn.value;
	drug_db_allergy_check_yn	= headerFromObj.drug_db_allergy_check_yn.value;
	drug_db_duptherapy_yn	= headerFromObj.drug_db_duptherapy_yn.value;
	bl_install_yn	= headerFromObj.bl_install_yn.value;
	bl_disp_charge_dtl_in_rx_yn	= headerFromObj.bl_disp_charge_dtl_in_rx_yn.value;
	var MAR_app_yn	= getMAR_app_yn(headerFromObj);
	var adr_count	 =  headerFromObj.adr_count.value;
	var order_set_code	 =  headerFromObj.order_set_code.value;

	order_date_time	= headerFromObj.sys_date.value;

	if(called_from == 'BLERROR' || sliding_scale_yn=='Y'){
		parent.parent.f_prescription.location.href="../../ePH/jsp/PrescriptionFormFrame.jsp?patient_id="+patient_id+"&encounter_id="+encounter_id+"&patient_class="+patient_class+"&bed_num="+bed_num+"&room_num="+room_num+"&weight="+weight+"&bsa="+bsa+"&drug_db_interface_yn="+drug_db_interface_yn+"&bl_install_yn="+bl_install_yn+"&bl_disp_charge_dtl_in_rx_yn="+bl_disp_charge_dtl_in_rx_yn+"&MAR_app_yn="+MAR_app_yn+"&adr_count="+adr_count+"&act_patient_class="+act_patient_class+"&take_home_medication="+take_home_medication+"&order_set_code="+order_set_code+"&drug_db_allergy_check_yn="+drug_db_allergy_check_yn+"&drug_db_duptherapy_yn="+drug_db_duptherapy_yn;
		clearDrugdetails(sliding_scale_yn);
	}
	else{
		parent.f_prescription.location.href="../../ePH/jsp/PrescriptionFormFrame.jsp?patient_id="+patient_id+"&encounter_id="+encounter_id+"&patient_class="+patient_class+"&bed_num="+bed_num+"&room_num="+room_num+"&weight="+weight+"&bsa="+bsa+"&drug_db_interface_yn="+drug_db_interface_yn+"&bl_install_yn="+bl_install_yn+"&bl_disp_charge_dtl_in_rx_yn="+bl_disp_charge_dtl_in_rx_yn+"&MAR_app_yn="+MAR_app_yn+"&act_patient_class="+act_patient_class+"&take_home_medication="+take_home_medication+"&order_set_code="+order_set_code;
		clearDrugdetails(sliding_scale_yn);
	}
	if(top.content != null)
		top.content.messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num=";
}
/****************************** BILLING RELATED FUNCTIONS END *********************************/

//defFreq used to default the frequency based on the priority selectd.
function defFreq(priorityObj, callFrom){
	if(callFrom == undefined)//  added for MO-GN-5490 [IN:054620] - [IN:055921]
		callFrom="";
	var priority = priorityObj.value;
	var formobj=document.prescription_detail_form;
	if(formobj.drug_code.value!=""){
		var source_type	=	parent.f_header.document.prescription_header_form.source_type.value;
		var source_code	=	parent.f_header.document.prescription_header_form.source_code.value;
		var home_leave_yn_chk	=	parent.f_header.document.prescription_header_form.home_leave_yn_chk.value; //added  for Bru-HIMS-CRF-093[29960] -->
		var patient_id	=	parent.f_header.document.prescription_header_form.patient_id.value;
		var encounter_id	=	parent.f_header.document.prescription_header_form.encounter_id.value;
		var take_home_medication	=	parent.f_header.document.prescription_header_form.take_home_medication.value;
		var resp_id	=	parent.f_header.document.prescription_header_form.resp_id.value; //Added for HSA-CRF-0150 [IN:048467]
		var pract_id	=	parent.f_header.document.prescription_header_form.pract_id.value; //Added for HSA-CRF-0150 [IN:048467]
		var fldString=" priority=\""+ priority + "\" ";
		fldString +=" patient_class=\""+ formobj.patient_class.value + "\" ";
		fldString +=" act_patient_class=\""+ parent.f_header.document.prescription_header_form.act_patient_class.value + "\" "; //added for SRR20056-SCF-7622 IN27687
		fldString +=" calling_mode=\""+ formobj.calling_mode.value + "\" ";
		fldString +=" drug_code=\""+ formobj.drug_code.value + "\" ";
		//if(callFrom == 'ChangeFreq' && formobj.freq_nature.value=='O') //Commented for ML-BRU-SCF-1046 [IN:043889]
			fldString +=" freq_code=\""+ formobj.frequency.value + "\" ";
		/*else //Commented for ML-BRU-SCF-1046 [IN:043889]
			fldString +=" freq_code=\""+ formobj.freq_code.value + "\" ";*/
		fldString +=" dup_found=\""+ formobj.dup_found.value + "\" ";
		fldString +=" in_formulary_yn=\""+ formobj.in_formulary_yn.value + "\" ";
		fldString +=" order_type_code=\""+ formobj.order_type_code.value + "\" ";
		fldString +=" srlNo=\""+ formobj.srl_no.value + "\" ";
		fldString +=" drug_class=\""+ formobj.drug_class.value + "\" ";
		fldString +=" source_type=\""+ source_type + "\" ";
		fldString +=" source_code=\""+ source_code+ "\" ";
		fldString +=" take_home_medication=\""+ take_home_medication+ "\" ";
		fldString +=" home_leave_yn_val=\""+ home_leave_yn_chk+ "\" "; //added  for Bru-HIMS-CRF-093[29960] -->
		fldString +=" patient_id=\""+ patient_id+ "\" ";
		fldString +=" encounter_id=\""+ encounter_id+ "\" ";
		fldString +=" resp_id=\""+ resp_id+ "\" "; //Added for HSA-CRF-0150 [IN:048467]
		fldString +=" pract_id=\""+ pract_id+ "\" "; //Added for HSA-CRF-0150 [IN:048467]
		fldString +=" callFrom=\""+ callFrom+ "\" "; // DATECHANGE added for MO-GN-5490 [IN:054620] - [IN:055921]
		var xmlStr=formXMLString(formobj,fldString);
		var xmlDoc = "" ;
		var xmlHttp = new XMLHttpRequest() ;
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open("POST","PrescriptionValidation_2.jsp?func_mode=loadFreqsForPriority",false);
		xmlHttp.send(xmlDoc);
		responseText=xmlHttp.responseText ;
		eval(responseText);
		//fieldValidation(xmlStr,"loadFreqsForPriority");
	}
}

function assignDispLocn(dispLocnCode, dispLocnDesc){
	document.prescription_detail_form.disp_locn_code.value = dispLocnCode;
	document.prescription_detail_form.disp_locn_desc.value = dispLocnDesc;
}

function getMAR_app_yn(headerFormObj){
	var patient_class = headerFormObj.actual_patient_class.value;
	var take_home_med = headerFormObj.take_home_medication.value;

	var MAR_app_yn="";
	if(take_home_med=='Y')
		MAR_app_yn =  headerFormObj.disch_med_mar_appl_yn.value; 
	else if(patient_class == 'DC')
		MAR_app_yn =  headerFormObj.dc_mar_appl_yn.value; 
	else if(patient_class == 'EM')
		MAR_app_yn =  headerFormObj.em_mar_appl_yn.value; 
	else if(patient_class == 'IP')
		MAR_app_yn =  headerFormObj.ip_mar_appl_yn.value; 
	else if(patient_class == 'OP')
		MAR_app_yn =  headerFormObj.op_mar_appl_yn.value; 

	return MAR_app_yn;
}

async function showMedicalItem(){
	var hdr_formObj = parent.f_header.document.prescription_header_form;
	var patient_id			= hdr_formObj.patient_id.value;
	var encounter_id		= hdr_formObj.encounter_id.value;
	var bed_num				= hdr_formObj.bed_num.value;
	var room_num			= hdr_formObj.room_num.value;
	var location_type		= hdr_formObj.location_type.value;
	var location_code		= hdr_formObj.location_code.value;
	var patient_class		= hdr_formObj.patient_class.value;
	var act_patient_class	= hdr_formObj.actual_patient_class.value;
	var order_date_time		= hdr_formObj.sys_date.value;
	var problem_ind			= hdr_formObj.problem_ind.value;
	var height				= hdr_formObj.height.value;
	var weight				= hdr_formObj.weight.value;
	var pract_id			= hdr_formObj.pract_id.value;
	var resp_id				= hdr_formObj.resp_id.value;
	var ph_default_tab		= hdr_formObj.ph_default_tab.value;
	var priority			= hdr_formObj.priority.value;
	var bl_install_yn		= hdr_formObj.bl_install_yn.value;
	var bl_disp_charge_dtl_in_rx_yn		= hdr_formObj.bl_disp_charge_dtl_in_rx_yn.value;
	var bl_disp_charge_dtl_in_drug_lkp_yn		= hdr_formObj.disp_charge_dtl_in_drug_lkp_yn.value;
	var disp_price_type_in_drug_lkp		= hdr_formObj.disp_price_type_in_drug_lkp.value;
	var take_home_medication		    = hdr_formObj.take_home_medication.value;
	var height_uom		= hdr_formObj.height_unit.value;
	var weight_uom		= hdr_formObj.weight_unit.value;
	var bsa				= hdr_formObj.bsa.value;
	var bsa_uom			= getLabel("Common.BSA.label","Common");
	var bmi				= hdr_formObj.bmi.value;
	var facility_id		= hdr_formObj.facility_id.value ;
	var allow_alt_for_med_item = hdr_formObj.allow_alt_for_med_item.value; // Added for GHL-CRF-0548 [IN:068345] - Devindra
	var url="../../ePH/jsp/ConsumableOrder.jsp?priority="+priority+"&location_code="+location_code+"&location_type="+location_type+"&pract_id="+pract_id+"&resp_id="+resp_id+"&act_patient_class="+act_patient_class+"&patient_id="+patient_id+"&encounter_id="+encounter_id+"&patient_class="+patient_class+"&order_date_time="+order_date_time+"&height="+height+"&weight="+weight+"&take_home_medication="+take_home_medication+"&bl_install_yn="+bl_install_yn+"&bl_disp_charge_dtl_in_rx_yn="+bl_disp_charge_dtl_in_rx_yn+"&bl_disp_charge_dtl_in_drug_lkp_yn="+bl_disp_charge_dtl_in_drug_lkp_yn+"&bl_disp_price_type_in_drug_lkp="+disp_price_type_in_drug_lkp+"&height_unit="+height_uom+"&weight_unit="+weight_uom+"&bsa="+bsa+"&bsa_unit="+bsa_uom+"&bmi="+bmi+"&facility_id="+facility_id+"&bed_num="+bed_num+"&room_num="+room_num+"&allow_alt_for_med_item="+allow_alt_for_med_item+"&call_mode=new"+"&called_from=RX"; // allow_alt_for_med_item Added for GHL-CRF-0548 [IN:068345] - - Devindra

	var dialogHeight	="68vh" ;
	var dialogWidth	="72vw";
	var dialogTop	= "250" ;
	var dialogLeft	= "50" ;
	var center			= "1" ;
	var status			="no";
	var features	= "dialogHeight:" + dialogHeight +"; dialogLeft:"+dialogLeft+ "; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop;
	var arguments	= "";
	retVal = await top.window.showModalDialog(url,arguments,features);

	if(bl_disp_charge_dtl_in_rx_yn == 'Y'){
		parent.f_prescription.f_RX.location.reload();
	}
}

function defDispLocnForIV(){
	var take_home_medication_ckk_val ="";//added for NMC-JD-CRF-0063 START
	var take_home_medication_op = "";
	if(document.prescription_header_form.take_home_medication_ckk_val!=undefined){
		take_home_medication_ckk_val = document.prescription_header_form.take_home_medication_ckk_val.value ;
	}
	if(document.prescription_header_form.take_home_medication_op!=undefined){
		take_home_medication_op = document.prescription_header_form.take_home_medication_op.value ;
	}
//END
	if(document.prescription_header_form.MAR.value!='MAV'){
		try{
			if(document.getElementById('comprx').className == "CASECONDSELECTHORZ"){//added for NMC-JD-CRF-0063  				
					var location_type			= document.prescription_header_form.location_type.value;
					var location_code			= document.prescription_header_form.location_code.value;
					var take_home_medication	= document.prescription_header_form.take_home_medication.value;
					var priority				= document.prescription_header_form.priority.value;
					var patient_id		= document.prescription_header_form.patient_id.value;//Replaced parent.f_header.document.prescription_header_form with formObject for ARYU-SCF-0033
					var encounter_id    = document.prescription_header_form.encounter_id.value;//Replaced parent.f_header.document.prescription_header_form with formObject for ARYU-SCF-0033
					var bean_id= "@IVPrescriptionBean"+patient_id+encounter_id;
					var iv_prep_yn = "6";//Added for NMC-JD-CRF-0063
				    var bean_name="ePH.IVPrescriptionBean";
				    var xmlDoc			= "";
					var xmlHttp			= new XMLHttpRequest();
					
					xmlStr		="<root><SEARCH " ;
					xmlStr		+="location_type"+"=\""+ location_type+"\" " ;
					xmlStr		+="location_code"+"=\""+ location_code+"\" " ;
					xmlStr		+="priority"+"=\""+ priority+"\" " ;
					xmlStr		+="take_home_medication"+"=\""+ take_home_medication+"\" " ;
					xmlStr		+="iv_prep_yn"+"=\""+ iv_prep_yn+"\" " ;
					xmlStr+= "take_home_medication_op =\"" + take_home_medication_op + "\" " ;//ADDED FOR NMC-JD-CRF-0063
					xmlStr+= "take_home_medication_ckk_val =\"" + take_home_medication_ckk_val + "\" " ;//end
					xmlStr		+=" /></root>" ;

					var temp_jsp="PrescriptionCompValidate.jsp?validate=OrdDispenseLocation"+"&bean_id="+bean_id+"&bean_name="+bean_name;
					var xmlDoc = "" ;
					var xmlHttp = new XMLHttpRequest() ;
					xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
					xmlHttp.open("POST",temp_jsp,false);
					xmlHttp.send(xmlDoc);
					responseText=xmlHttp.responseText ;
					eval(responseText);
				}
		else if(document.getElementById('ivrx').className=="CASECONDSELECTHORZ"){
				//alert("ivrx"); 
				var iv_type = parent.f_prescription.f_ivselect.document.formIVPrescriptionOptions.type.value;
				var iv_prep_yn = "5";
				var bean_id="";
				var bean_name="";
				if(iv_type=='IVD'){
					var formObj = parent.f_prescription.f_ivdetails.f_iv_fluid.document.formIVPrescriptionDetails;
					bean_id					= formObj.bean_id.value;
					bean_name				= formObj.bean_name.value;
					var admixture_yn =formObj.admixture;
					if(admixture_yn.checked == true){
						iv_prep_yn = "2";
					}
					else{
						iv_prep_yn = "1";
					}
				}
				if(iv_type=='IVPB'){
					var formObj = parent.f_prescription.f_ivdetails.f_iv_pb_drug.document.formIVPiggyBackDrugDetails;
					bean_id					= formObj.iv_bean_id.value;
					bean_name				= formObj.iv_bean_name.value;
					var admixture_yn = formObj.admixture;
					if(admixture_yn.checked == true){
						iv_prep_yn = "4";
					}
					else{
						iv_prep_yn = "3";
					}
				}
				var location_type			= document.prescription_header_form.location_type.value;
				var location_code			= document.prescription_header_form.location_code.value;
				var take_home_medication	= document.prescription_header_form.take_home_medication.value;
				var priority				= document.prescription_header_form.priority.value;

				var xmlStr ="<root><SEARCH ";					
				xmlStr+= "location_type =\"" + location_type + "\" " ;
				xmlStr+= "location_code =\"" + location_code + "\" " ;
				xmlStr+= "take_home_medication =\"" + take_home_medication + "\" " ;
				xmlStr+= "priority =\"" + priority + "\" " ;
				xmlStr+= "iv_prep_yn =\"" + iv_prep_yn + "\" " ;
				xmlStr+= "take_home_medication_op =\"" + take_home_medication_op + "\" " ;//ADDED FOR NMC-JD-CRF-0063
				xmlStr+= "take_home_medication_ckk_val =\"" + take_home_medication_ckk_val + "\" " ;//end
				xmlStr +=" /></root>";
				if(iv_prep_yn=='5'){
					bean_id					= parent.f_prescription.f_ivdetails.formIVPrescriptionAdditives.bean_id.value;
					bean_name				= parent.f_prescription.f_ivdetails.formIVPrescriptionAdditives.bean_name.value;
				}
				var temp_jsp="IVPrescriptionValidate.jsp?validate=OrdDispenseLocation"+"&bean_id="+bean_id+"&bean_name="+bean_name;
				var xmlDoc = "" ;
				var xmlHttp = new XMLHttpRequest() ;
				xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
				xmlHttp.open("POST",temp_jsp,false);
				xmlHttp.send(xmlDoc);
				responseText=xmlHttp.responseText ;
				eval(responseText);
			}
			else if(document.getElementById('oncology_regimen').className=="CASECONDSELECTHORZ"){
				var location_type			= document.prescription_header_form.location_type.value;
				var location_code			= document.prescription_header_form.location_code.value;
				var take_home_medication	= document.prescription_header_form.take_home_medication.value;
				var priority				= document.prescription_header_form.priority.value;

				var iv_prep_yn	= parent.f_prescription.oncology_drugs.oncology_admin.document.oncologyRegimenAdminDetail.iv_prep_yn.value;
				var bean_id		= parent.f_prescription.oncology_drugs.oncology_admin.document.oncologyRegimenAdminDetail.bean_id.value;
				var bean_name	= parent.f_prescription.oncology_drugs.oncology_admin.document.oncologyRegimenAdminDetail.bean_name.value;
				var xmlDoc			="";
				var xmlHttp			= new XMLHttpRequest();

				xmlStr		="<root><SEARCH " ;
				xmlStr		+="location_type"+"=\""+ location_type+"\" " ;
				xmlStr		+="location_code"+"=\""+ location_code+"\" " ;
				xmlStr		+="priority"+"=\""+ priority+"\" " ;
				xmlStr		+="take_home_medication"+"=\""+ take_home_medication+"\" " ;
				xmlStr		+="iv_prep_yn"+"=\""+ iv_prep_yn+"\" " ;
				xmlStr		+=" /></root>" ;

				xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
				xmlHttp.open( "POST", "OncologyRegimenValidate.jsp?validate=dfltDispLocn&bean_id=" + bean_id + "&bean_name=" + bean_name, false ) ; 
				xmlHttp.send( xmlDoc ) ;
				responseText=xmlHttp.responseText ;
				eval(responseText);
			}
		/*	else if(document.getElementById("comprx").className == "CASECONDSELECTHORZ"){//added for NMC-JD-CRF-0063  
				  
						var location_type			= document.prescription_header_form.location_type.value;
						var location_code			= document.prescription_header_form.location_code.value;
						var take_home_medication	= document.prescription_header_form.take_home_medication.value;
						var priority				= document.prescription_header_form.priority.value;
						var patient_id		= document.prescription_header_form.patient_id.value;//Replaced parent.f_header.document.prescription_header_form with formObject for ARYU-SCF-0033
						var encounter_id    = document.prescription_header_form.encounter_id.value;//Replaced parent.f_header.document.prescription_header_form with formObject for ARYU-SCF-0033
						var bean_id= "@IVPrescriptionBean"+patient_id+encounter_id;
						var iv_prep_yn = "6";//Added for NMC-JD-CRF-0063
					    var bean_name="ePH.IVPrescriptionBean";
					    var xmlDoc			= new ActiveXObject( "Microsoft.XMLDom" ) ;
						var xmlHttp			= new ActiveXObject( "Microsoft.XMLHTTP" ) ;
						
						xmlStr		="<root><SEARCH " ;
						xmlStr		+="location_type"+"=\""+ location_type+"\" " ;
						xmlStr		+="location_code"+"=\""+ location_code+"\" " ;
						xmlStr		+="priority"+"=\""+ priority+"\" " ;
						xmlStr		+="take_home_medication"+"=\""+ take_home_medication+"\" " ;
						xmlStr		+="iv_prep_yn"+"=\""+ iv_prep_yn+"\" " ;
						xmlStr+= "take_home_medication_op =\"" + take_home_medication_op + "\" " ;//ADDED FOR NMC-JD-CRF-0063
						xmlStr+= "take_home_medication_ckk_val =\"" + take_home_medication_ckk_val + "\" " ;//end
						xmlStr		+=" /></root>" ;

						var temp_jsp="PrescriptionCompValidate.jsp?validate=OrdDispenseLocation"+"&bean_id="+bean_id+"&bean_name="+bean_name;
						var xmlDoc = "" ;
						var xmlHttp = new XMLHttpRequest() ;
						xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
						xmlHttp.open("POST",temp_jsp,false);
						xmlHttp.send(xmlDoc);
						responseText=xmlHttp.responseText ;
						eval(responseText);
					}*///commented and added above
			
		}
		catch(e){}
	}
	var dispPrescripionDuration = document.prescription_header_form.dispPrescripionDuration.value; //Added for Added for BRU-HIMS-CRF-403 [IN:044541] -start
	var take_home_medication = document.prescription_header_form.take_home_medication.checked;
	document.prescription_header_form.durn_value.value="";
	document.prescription_header_form.durn_desc.value="D";
	if(take_home_medication==true && dispPrescripionDuration=='Y')
		document.getElementById('tdPrescripionHdrDuration').style.visibility = 'visible';
	else
		document.getElementById('tdPrescripionHdrDuration').style.visibility = 'hidden';
}
/*function displayDispLocn(ord_disp_location){
	try{
		parent.f_prescription.f_ivbutton.document.getElementById("dflt_disp_locn_lbl").innerText = ord_disp_location;
	}
	catch(e){}
}*/

function displayDispLocn(ord_disp_location,time_flag){
	
//	try{
		parent.f_prescription.f_ivbutton.document.formIVPrescriptionButtons.time_flag.value =time_flag;	//MODIFIED for NMC-JD-CRF-0063
		parent.f_prescription.f_ivbutton.document.getElementById('dflt_disp_locn_lbl').innerText = ord_disp_location;
}
//added for NMC-JD-CRF-0063
function displayDispLocnCompRx(ord_disp_location){  
parent.f_prescription.f_compound_button.document.getElementById('dflt_disp_locn_lbl').innerText = ord_disp_location;
}

function paintDispLocn(dflt_disp_locn){
	parent.f_prescription.oncology_drugs.oncology_button.document.getElementById('dflt_disp_locn_lbl').innerText = dflt_disp_locn;
}


async function callPregnancyRemarks(){
	var dialogHeight	= "16vh" ;
	var dialogWidth		= "37vw" ;
	var dialogTop		= "305" ;
	var dialogLeft		= "203" ;
	var center			= "1" ;
	var status			="no";
	var scroll			="yes";
	var features		= "dialogLeft:" + dialogLeft + ";dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; center: " + center + ";scroll "+scroll+"; status: " + status + "; dialogTop :" + dialogTop;
	var arguments		= "" ;
	await top.window.showModalDialog("../../ePH/jsp/PregnancyRemarks.jsp",arguments,features);
}

function durationConversn(obj){
	var durn_value = document.prescription_detail_form.durn_value.value;
	var freq_nature = document.prescription_detail_form.freq_nature.value;
	var repeat_durn_type = "";
	var tmp_durn_value   = "1"; //changed from 0 to 1 for KAUH-SCF-042
	
	if(freq_nature != "P" && freq_nature != 'O'){ // || replaced with && for IN26089 reopen --28/01/2011-- priya
		repeat_durn_type = document.prescription_detail_form.repeat_durn_type.value;
		if(repeat_durn_type == obj.value){
			tmp_durn_value = durn_value;
		}
		if(repeat_durn_type == 'M'){
			if(obj.value == 'H'){
				tmp_durn_value   = (durn_value * 60);	
			}
			else if(obj.value == 'D'){
				tmp_durn_value   = (durn_value * 24 * 60);	
			}
			else if(obj.value == 'W'){
				tmp_durn_value   = (durn_value * 7 * 24 * 60);	
			}
			else if(obj.value == 'L'){
				tmp_durn_value   = (durn_value * 30 * 24 * 60);	
			}
			else if(obj.value == 'Y'){
				tmp_durn_value   = (durn_value * 365 * 24 * 60);	
			}
		}
		else if(repeat_durn_type == 'H'){
			if(obj.value == 'D'){
				tmp_durn_value   = (durn_value * 24);	
			}
			else if(obj.value == 'W'){
				tmp_durn_value   = (durn_value * 7 * 24);	
			}
			else if(obj.value == 'L'){
				tmp_durn_value   = (durn_value * 30 * 24);	
			}
			else if(obj.value == 'Y'){
				tmp_durn_value   = (durn_value * 365 * 24);	
			}
		}
		else if(repeat_durn_type == 'D'){
			if(obj.value == 'W'){
				tmp_durn_value   = (durn_value * 7);	
			}
			else if(obj.value == 'L'){
				tmp_durn_value   = (durn_value * 30);	
			} 
			else if(obj.value == 'Y'){
				tmp_durn_value   = (durn_value * 365);	
			}
		}
		else if(repeat_durn_type == 'W'){
			if(obj.value == 'L'){
				tmp_durn_value   = (durn_value * 4);	
			}
			else if(obj.value == 'Y'){
				tmp_durn_value   = (durn_value * 52);	
			}
		}
		else if(repeat_durn_type == 'L'){
			if(obj.value == 'Y'){
				tmp_durn_value   = (durn_value * 12);	
			}
		}
	}
	else{
		if(freq_nature == 'O')
			tmp_durn_value = 1;
	}
	document.prescription_detail_form.tmp_durn_value.value = tmp_durn_value;
	document.prescription_detail_form.tmp_durn_desc.value = document.prescription_detail_form.repeat_durn_type.value;
    
	var amend_yn = "" // Added for HSA-ICN-0011 - Start
    var mode_c = "";
    if(document.prescription_detail_form.amend_yn!=undefined){ 
    	amend_yn=document.prescription_detail_form.amend_yn.value;
    } 
    if(document.prescription_detail_form.calling_mode!=undefined && document.prescription_detail_form.modeC!=undefined){ //modeC added for TBMC-SCF-0166
    	mode_c=document.prescription_detail_form.modeC.value;
    }  // Added for HSA-ICN-0011 - End
    if(amend_yn!="N" || mode_c == "copied_drugs"){ // if Condition Added for HSA-ICN-0011 	   
    	validateDosageLimit("freqChange"); // added for IN23562  --08/09/2010-- priya // Commented for HSA-ICN-0011 (PE Issue) This method is calling from MakeScheduleLink which is called after loading all drug data.
    }
}

function assignDurnTypeList(DurnDescDetails){
	durn_type_list = DurnDescDetails.substring(1,DurnDescDetails.length-1);
}

function reloadDurnTypeList(sliding_scale_yn){
	var repeat_durn_type = document.prescription_detail_form.repeat_durn_type.value;
	var freq_nature = document.prescription_detail_form.freq_nature.value;
	if(freq_nature == 'O')
		document.prescription_detail_form.tmp_durn_value.value='1';

	var durnTypeList = "";
	if(durn_type_list.length>0){
		durnTypeList = durn_type_list.split(",");
	}

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
	validateDuration(document.prescription_detail_form.durn_value,'',sliding_scale_yn);
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

function displayRemarks(){
	
	i = document.PrescriptionPRNRemarksForm.prnRemCode.selectedIndex;
	if(i > 0){
		document.PrescriptionPRNRemarksForm.prnFreeTextYN.checked=false;
		document.PrescriptionPRNRemarksForm.remarks.disabled = true;
	
	val = eval("document.PrescriptionPRNRemarksForm.remarks_"+(i-1)).value;
	val = decodeURIComponent(val);
	document.PrescriptionPRNRemarksForm.remarks.value = val;
	}else{
		document.PrescriptionPRNRemarksForm.remarks.value ="";
	}
}
/*function ChkMaxLen(lab,obj,max) {

		if(obj.value.length >= max) { 
			alert("APP-SM0045 - " + lab + getLabel("ePH.Cannotexceed.label","PH") +"  "+max  +"  "+ getLabel("ePH.characters.label","PH") );
			obj.select();
			return false;
		} else return true;

}*/
function ChkMaxLen(lab,obj,max) {
	var val = "";
	val = obj.value;
	if(obj.value.length > max){
		var msg = getMessage("REMARKS_CANNOT_EXCEED","Common");
		msg = msg.replace("$",lab);
		msg = msg.replace("#",max);
		alert(msg);
		obj.focus();
		return false;
		//obj.value = val.substring(0,max);
	}
}

//function added for IN26242 --02/02/2011-- priya
function setPriorityforMI(priorityObj){
	var bean_id		= document.prescription_header_form.consumable_bean_id.value;
	var bean_name	= document.prescription_header_form.consumable_bean_name.value;
	var priority = priorityObj.value;
	var xmlDoc			= "";
	var xmlHttp			=new XMLHttpRequest();
	xmlStr		="<root><SEARCH " ;
	xmlStr		+="priority"+"=\""+ priority+"\" " ;
	xmlStr		+=" /></root>" ;

	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open( "POST", "ConsumableOrderValidate.jsp?validate=setPriorityforMI&bean_id=" + bean_id + "&bean_name=" + bean_name, false ) ; 
	xmlHttp.send( xmlDoc ) ;
	responseText=xmlHttp.responseText ;
	eval(responseText);

}
//  RUT-CRF-0062 [IN029600]  Newly added to get Build MAR Rule -- begin
function getBuildMARDefaulting(){
	var formobj				=	document.prescription_detail_form;
	var drug_code			=	formobj.drug_code.value;
	if(drug_code!=""){
	var priority			=	formobj.priority.value;
	var actualPatientClass	= 	parent.f_header.document.prescription_header_form.actual_patient_class.value;
	if(actualPatientClass=='XT')//Added for IN045300 
		return false;
	var LocationCode		=	parent.f_header.document.prescription_header_form.source_code.value;
	var formCode			= 	formobj.form_code.value;
	var facility_id			= 	parent.f_header.document.prescription_header_form.facility_id.value;
	var xmlStr				=	"";
	var bean_id				=	formobj.bean_id.value;
	var bean_name			=	formobj.bean_name.value;
	if(parent.f_header.document.prescription_header_form.take_home_medication.value=="Y" && actualPatientClass=="IP")
		actualPatientClass="DM";
	
	xmlStr		="<root><SEARCH " ;
	xmlStr		+="bean_id"+"=\""+ bean_id+"\" " ;
	xmlStr		+="bean_name"+"=\""+ bean_name+"\" " ;
	xmlStr		+="facility_id"+"=\""+ facility_id+"\" " ;
	xmlStr		+="patient_class"+"=\""+ actualPatientClass+"\" " ;
	xmlStr		+="location_code"+"=\""+ LocationCode+"\" " ;
	xmlStr		+="form_code"+"=\""+ formCode+"\" " ;
	xmlStr		+="priority"+"=\""+ priority+"\" " ;
	xmlStr		+=" /></root>" ;

	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest() ;
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open("POST","PrescriptionValidation.jsp?func_mode=getMARDefaulting",false);//changed PrescriptionValidation_1.jsp to PrescriptionValidation.jsp 
		xmlHttp.send(xmlDoc);
		responseText=xmlHttp.responseText;
		eval(responseText);
	}
}

//  RUT-CRF-0062 [IN029600]  Newly added to set Build MAR Rule 
function setBuildMAR(buildMARDefaulting){
	var buildMAR_checked	=	buildMARDefaulting.substring(0,1);
	var buildMAR_enabled	=	buildMARDefaulting.substring(1,2);
	var formobj				=	document.prescription_detail_form;
	
	var expDisp=""; //Added For NMC-JD-SCF-0121
	expDisp= formobj.ext_disp_appl_yn.value; //Added For NMC-JD-SCF-0121
	
	if(buildMAR_checked=="C"){
		formobj.buildMAR_yn.checked=true;
		formobj.buildMAR_yn.value="Y";
	}
	else{
		formobj.buildMAR_yn.checked=false;
		formobj.buildMAR_yn.value="N";
	}
	
	if(buildMAR_enabled=="E"){
		formobj.buildMAR_yn.disabled=false;
	}
	else{
		formobj.buildMAR_yn.disabled=true;
	}
	//Added For NMC-JD-SCF-0121
	if(expDisp=="Y")    
	{
		formobj.buildMAR_yn.checked=false;
		formobj.buildMAR_yn.disabled=true;
		formobj.buildMAR_yn.value="N";
	}    
	//Added For NMC-JD-SCF-0121
	
}
//  RUT-CRF-0062 [IN029600]  -- end
function getActionText(route_code,form_code){ //Add this function for SKR-CRF-0006[IN029561]	
	var route_code = route_code.value;		
  	var bean_id				=	document.prescription_detail_form.bean_id.value;
	var bean_name			=	document.prescription_detail_form.bean_name.value;
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
	xmlHttp.open("POST","PrescriptionValidation_2.jsp?func_mode=getActiontext",false);
	xmlHttp.send( xmlDoc ) ;	
	eval(xmlHttp.responseText);	
}

function assignActionText(actionText){ //Add this function for SKR-CRF-0006[IN029561]     
	document.prescription_detail_form.actionTextval.innerText=actionText;			
}

function getTotalTaperQty(in_formulary_yn, called_from,flag, pBilling){	//added pBilling for performance issue MMS
	if(flag=="N"){
		var tapperedYN				=	document.prescription_detail_form.tappered_over.value;
		var drug_tapered				=	document.prescription_detail_form.drug_tapered.value;
		var totalTaperQtyDisplay	=	document.prescription_detail_form.totalTaperQtyDisplay.value;
		if((tapperedYN=='Y' || drug_tapered=='Y') && totalTaperQtyDisplay=='Y'){

			var totTapperQty	=	document.prescription_detail_form.totTapperQty.value;
			/*	if(called_from=='TAPER_QTY'){
				var totTapperQty	=	document.prescription_detail_form.totTapperQty.value;
			//	assignTotalTaperQty(totTapperQty)
			//	getChargeDetails(in_formulary_yn, 'TAPER_QTY');
			//	return;
			}*/
			var drug_code				=	document.prescription_detail_form.drug_code.value;
			var srl_no					=	document.prescription_detail_form.srl_no.value;
			var repeat_value			=	document.prescription_detail_form.repeat_value.value;
			var durn_value					=	document.prescription_detail_form.durn_value.value;
			var interval_value					=	document.prescription_detail_form.interval_value.value;
			var qty_desc_code					=   document.prescription_detail_form.qty_desc.value;	
			var qty_value						=   document.prescription_detail_form.qty_value.value;
			var dosage_type						=   document.prescription_detail_form.dosage_type.value;
			var tap_lvl_qty			=   document.prescription_detail_form.tap_lvl_qty.value; // Added for RUT-CRF-0088 [IN036978]
			if(dosage_type=='A'){
				document.prescription_detail_form.absol_qty.value=tap_lvl_qty;

			}
			var absol_qty						=   document.prescription_detail_form.absol_qty.value;
			var durn_desc						=   document.prescription_detail_form.durn_desc.value;
			var repeat_durn_type				=   document.prescription_detail_form.repeat_durn_type.value;
			var calc_dosg_by_freq_durn_yn				=   document.prescription_detail_form.calc_dosg_by_freq_durn_yn.value;	//added for RUT-SCF-0154 [IN:033594] && RUT-SCF-0155 [IN:033595]
			var bean_id				=	document.prescription_detail_form.bean_id.value;
			var bean_name			=	document.prescription_detail_form.bean_name.value;
			var order_qty 				=	""  //Added for RUT-CRF-0088 [IN036978]
			var xmlStr ="<root><SEARCH ";	
			var xmlDoc="";
			var xmlHttp = new XMLHttpRequest();
			if(called_from == undefined)
				called_from = "ONCHANGE";
			xmlStr	="<root><SEARCH " ;
			xmlStr+= "bean_id  =\"" + bean_id + "\" " ;
			xmlStr+= "bean_name =\"" + bean_name + "\" " ;	
			xmlStr += " drug_code=\""+ drug_code + "\" ";
			xmlStr += " srl_no=\""+ srl_no + "\" ";
			xmlStr += " qty_value=\""+ qty_value + "\" ";
			//xmlStr += " qty_desc_code=\""+ qty_desc_code + "\" ";
			xmlStr += " repeat_value=\""+ repeat_value + "\" ";
			xmlStr += " durn_value=\""+ durn_value + "\" ";		
			xmlStr += " interval_value=\""+ interval_value + "\" ";		
			xmlStr += " durn_desc=\""+ durn_desc + "\" ";		
			xmlStr += " dosage_type=\""+ dosage_type + "\" ";		
			xmlStr += " repeat_durn_type=\""+ repeat_durn_type + "\" ";	
			xmlStr += " called_from=\""+ called_from + "\" ";		
			xmlStr += " totTapperQty=\""+ totTapperQty + "\" ";		
			xmlStr += " tap_lvl_qty=\""+ tap_lvl_qty + "\" ";  //Added for RUT-CRF-0088 [IN036978]
			xmlStr += " calc_dosg_by_freq_durn_yn=\""+ calc_dosg_by_freq_durn_yn + "\" ";	//added for RUT-SCF-0154 [IN:033594] && RUT-SCF-0155 [IN:033595]
			xmlStr +=" /></root>" ;
			xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml") ;	
			xmlHttp.open("POST","PrescriptionValidation_2.jsp?func_mode=getTotalTaperQty_LVL",false);
			xmlHttp.send( xmlDoc ) ;	
			var validQty = eval(xmlHttp.responseText);	
			//if(validQty){
			if(pBilling!='pBilling')//added pBilling for performance issue MMS
				getChargeDetails(in_formulary_yn, 'TAPER_QTY');
		}
	}
}

function assignTotalTaperQty(totTapperQty, tap_lvl_qty){      // Modified for  RUT-CRF-0088 [IN036978]
	/*if(prevTotalTaperQty!=undefined )    //Commented for RUT-CRF-0088 [IN036978]
		 document.prescription_detail_form.prevTotalTaperQty.value = prevTotalTaperQty;
	else
		prevTotalTaperQty = document.prescription_detail_form.prevTotalTaperQty.value;*/
	var calc_dosg_by_freq_durn_yn = document.prescription_detail_form.calc_dosg_by_freq_durn_yn.value; //added for RUT-SCF-0154 [IN:033594] && RUT-SCF-0155 [IN:033595]
	/*if(calc_dosg_by_freq_durn_yn=='Y' && parseInt(totTapperQty)<parseInt(prevTotalTaperQty)){   //Commented for RUT-CRF-0088 [IN036978] //calc_dosg_by_freq_durn_yn=='Y' && --added for RUT-SCF-0154 [IN:033594] && RUT-SCF-0155 [IN:033595]
		alert(getMessage("PH_TOT_TAPER_QTY_PREV_VALUE","PH")); 
		document.prescription_detail_form.totTapperQty.value=prevTotalTaperQty;
		return false;
	}
	else{*/
		document.prescription_detail_form.totTapperQty.value=totTapperQty;
		document.prescription_detail_form.tap_lvl_qty.value=tap_lvl_qty;
		return true;
	//}
}

async function callAllergies(patient_id){
	var retVal 			= 	new String();
	var dialogHeight 	= "55vh" ;
	var dialogWidth  	= "80vw" ;
	var dialogTop    	= "100";
    var status 			= "no";
	var features		= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; dialogTop:"+dialogTop+"; scroll=auto; status:no";
	retVal = await window.showModalDialog("../../eCA/jsp/AllergyList.jsp?called_from_ip=Y&patient_id="+patient_id,arguments,features);
}

function showDuplicateInd(srlNo, currentrx, slidingScale_yn, drug_code, callFrom, allow_duplicate){ // allow_duplicate added for MO-GN-5490 [IN:054620]
	var formObj;
	if(callFrom == 'CHANGEDATE' || callFrom =='ChangeFreq' || callFrom =='DATECHANGE')// DATECHANGE added for MO-GN-5490 [IN:054620] - [IN:055921]
		formObj = parent.f_detail.document.prescription_detail_form; //modified for SKR-SCF-1457
		
	else{
		if(currentrx == 'R')
			formObj = parent.f_detail.document.prescription_detail_form;
		else
			formObj = parent.parent.f_detail.document.prescription_detail_form;
	}
	if(currentrx == 'Y' || currentrx == 'R'){
		if(formObj!=undefined){//SKR-SCF-0648 [IN-35984] - if condition Added to check Override remarks on Sliding Scale.
			formObj.current_rx.value='Y';
			if(allow_duplicate!='Y'){ // if block and else condition added for MO-GN-5490 [IN:054620]
				formObj.priority.value='U';
				formObj.trDupDrugInfo.style='display';
				if(callFrom == 'DATECHANGE' && (formObj.dup_found.value=='false' || formObj.dup_found.value==false)){ // added for MO-GN-5490 [IN:054620] - [IN:055921]
					formObj.dup_found.value=true; 
					formObj.priority.disabled=true;
					defFreq(formObj.priority, "DATECHANGE", 'Y');
				}
			}
			else{
				formObj.dosage_limit.style.visibility="visible";
				formObj.override_remarks.style.visibility = "visible";
				if(currentrx == 'R'){
					var ATC_Duplicate_yn = formObj.ATC_Duplicate_yn.value; 
					formObj.current_rx.value="Y"; // added for MO-GN-5490 [IN:003593]
					if(callFrom == 'CHANGEDATE' || callFrom =='ChangeFreq'){
						eval(parent.f_prescription.f_prescription_form.document.getElementById("currentrx"+srlNo)).innerHTML ="<img src='../../ePH/images/exceed1.gif'></img>";
						eval(parent.f_prescription.f_prescription_form.document.getElementById("currentrx"+srlNo)).className = "CURRENTRX";
					}
				}
			}
		}
	}
	else{
		if(slidingScale_yn==undefined || slidingScale_yn=='N'){
			var ATC_Duplicate_yn = formObj.ATC_Duplicate_yn.value; 
			var doseOverride = formObj.limit_ind.value; 
			var allergy = formObj.allergy_yn.value; 
			var interaction_exists = formObj.interaction_exists.value; 
			var abuse_exists= formObj.abuse_exists.value;//added for AAKH-CRF-0140
			var abuse_action= formObj.abuse_action.value;//added for AAKH-CRF-0140
		//	alert("abuse_exists"+abuse_exists+"abuse_action"+abuse_action);
			//&& (abuse_exists!="Y" && abuse_action !="B") added for aakh-crf-0140
			
			formObj.current_rx.value=currentrx; //  added for MO-GN-5490 [IN:054620] - [IN:055921] -start
			if(callFrom == 'DATECHANGE' && (formObj.dup_found.value=='true' || formObj.dup_found.value==true)){
				formObj.priority.disabled=false;
				formObj.dup_found.value=false; 
				defFreq(formObj.priority, "DATECHANGE", currentrx);
			} // added for MO-GN-5490 [IN:054620] - [IN:055921] -end
			if(callFrom == 'CHANGEDATE' || callFrom =='ChangeFreq'|| callFrom =='DATECHANGE'){ // DATECHANGE added for MO-GN-5490 [IN:054620] - [IN:055921]
				if(eval(parent.f_prescription.f_prescription_form.document.getElementById("currentrx"+srlNo)) != undefined){
					if(ATC_Duplicate_yn!="Y"){
						eval(parent.f_prescription.f_prescription_form.document.getElementById("currentrx"+srlNo)).innerHTML ="&nbsp;";
						//eval("parent.f_prescription.f_prescription_form.document.getElementById("currentrx")"+srlNo).className = getElementById('parent.f_prescription.f_prescription_form.document.getElementById("drug_")'+drug_code+'_'+srlNo).className;
						var amend_yn = eval("parent.f_prescription.f_prescription_form.document.prescription_form.amend_yn_"+srlNo).value;
						if(amend_yn=='Y')
							eval(parent.f_prescription.f_prescription_form.document.getElementById("currentrx"+srlNo)).className ='AMENDEDDRUGS';
						else
							eval(parent.f_prescription.f_prescription_form.document.getElementById("currentrx"+srlNo)).className ='SELECTEDRUGS';
					}
				}
			}
			else{
				if(eval(parent.f_prescription_form.document.getElementById("currentrx"+srlNo)) != undefined){
					if(ATC_Duplicate_yn!="Y")
						eval(parent.f_prescription_form.document.getElementById("currentrx"+srlNo)).innerHTML ="&nbsp;";
				}
			}
			if(ATC_Duplicate_yn!="Y" && doseOverride!="N" && allergy!="Y" && interaction_exists!="Y" && (abuse_exists!="Y" && abuse_action !="B")){ //doseOverride changed to  != 'N'  for MO-GN-5490 [IN:054620]
				formObj.dosage_limit.style.visibility = "hidden";
				//formObj.dosage_limit.style.display="none";
				formObj.override_remarks.style.visibility = "hidden";
				formObj.override_remarks.disabled = false;
				formObj.override_remarks.checked = false;
				formObj.override_remarks.value = "";
				formObj.checkEnabled.value = "";
			}
		}
	}
}

async function drugindication_remarks(){//Added for  ML-BRU-CRF-072[Inc:29938] start
	var formobj		=	document.prescription_detail_form;
	if(parent.f_header==null) {//Adding start for ARYU-SCF-0033
		var formObject	=	parent.parent.f_header.document.prescription_header_form;
	}
	else {
		var formObject	=	parent.f_header.document.prescription_header_form;
	}//Adding end for ARYU-SCF-0033
	var patient_id		= formObject.patient_id.value;//Replaced parent.f_header.document.prescription_header_form with formObject for ARYU-SCF-0033
	var encounter_id    = formObject.encounter_id.value;//Replaced parent.f_header.document.prescription_header_form with formObject for ARYU-SCF-0033
	var bean_id         = "@PrescriptionBean_1"+patient_id+encounter_id;		
	var bean_name		=formObject.bean_name.value;
	var DrugIndicationRemarks	=	formobj.DrugIndicationRemarks.value;//Replaced parent.f_header.document.prescription_header_form with formObject for ARYU-SCF-0033
	var drug_code	=	formobj.drug_code.value;		
	var mode=formobj.mode.value;
	var dialogHeight= "57vh" ;
	var dialogWidth	= "47vw" ;
	var dialogTop = "300" ;
	var dialogLeft ="450";
	var center = "0" ;
	var status="no";
	var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" +dialogTop+"; dialogLeft :"+dialogLeft;
	var arguments	= "" ;
	retVal = await window.showModalDialog("../../ePH/jsp/DrugIndicationRemarks.jsp?&DrugIndicationRemarks="+encodeURIComponent(DrugIndicationRemarks)+"&drug_code="+drug_code+"&bean_id="+bean_id+"&bean_name="+bean_name,arguments,features);
	if(retVal!= undefined && retVal!=null)
		formobj.DrugIndicationRemarks.value=retVal;		
}

function savedrugIndicationRemarks(drug_indicate){
	var drug_indication_new = encodeURIComponent(drug_indicate.value);
	/*var bean_id		= frmObj.bean_id.value;
	var bean_name	= frmObj.bean_name.value;
	var xmlStr		= "<root><SEARCH ";
	xmlStr	   += " bean_id=\""+ bean_id + "\" ";
	xmlStr     += " bean_name=\""+ bean_name + "\" ";
	xmlStr     += " drug_indication_new=\""+drug_indication_new + "\" ";   
	xmlStr     += " /></root>";*/
	
	let dialogBody = parent.document.getElementById('dialog-body');
	dialogBody.contentWindow.returnValue = drug_indication_new;
	const dialogTag = parent.document.getElementById('dialog_tag');
	dialogTag.close();
	//fieldValidation(xmlStr,"saveDrugIndicationRemarks");
}
function checkDrugIndMaxLimit(obj,maxLeng) { 
	if(obj.value.length > maxLeng) {
		val = obj.value;
		var msg = getMessage("REMARKS_CANNOT_EXCEED","Common");
		msg = msg.replace("$",getLabel("ePH.DrugIndications.label","PH"));
		msg = msg.replace("#",maxLeng);
		obj.value = val.substring(0,maxLeng-1);
		alert(msg);
		obj.focus();
		return false;
	} 
	else 
		return true;
}

 //Added for  ML-BRU-CRF-072[Inc:29938] end

 function changeRoute(){ //this function added for SKR-SCF-0586 IN[034375] Reopened
	var formobj=document.prescription_detail_form;
  	var bean_id				=	formobj.bean_id.value;
	var bean_name			=	formobj.bean_name.value;
	var xmlDoc="";
	var xmlHttp = new XMLHttpRequest();

	xmlStr	="<root><SEARCH " ;
	xmlStr+= "bean_id  =\"" + bean_id + "\" " ;
	xmlStr+= "bean_name =\"" + bean_name + "\" " ;	
	if(formobj.drug_code.value!=""){ 
		xmlStr +=" drug_code=\""+ formobj.drug_code.value + "\" ";
		xmlStr +=" srlNo=\""+ formobj.srl_no.value + "\" ";		
		xmlStr +=" route_code=\""+ formobj.route_code.value + "\" ";		
		xmlStr +=" /></root>" ;
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml") ;	
		xmlHttp.open("POST","PrescriptionValidation_2.jsp?func_mode=updateRoute",false);
		xmlHttp.send( xmlDoc ) ;	
		eval(xmlHttp.responseText);	
	}
}

async function alertIntr(drug_code, srl_no, patient_id, encounter_id, intr_restric_trn){
	var retVal;
	var dialogTop		= ""; //MMS-KH-CRF-0034.4
 	var dialogHeight	= "80vh" ; //MMS-KH-CRF-0029 and modified for //MMS-KH-CRF-0034.4
 	var dialogWidth		= "80vw" ; //MMS-KH-CRF-0029
	var dialogLeft		= "" ;
	var center		= "0" ;
	var status		="no";

 	var features		= 'Width:' + dialogWidth +'; dialogHeight:' + dialogHeight + '; dialogWidth:' + dialogWidth +'; dialogLeft:' + dialogLeft +';  dialogTop:'+dialogTop +'; scroll=auto; status=no'+ "; center: " + center ;
 	var arguments		=getLabel("Common.DrugInteraction.label",'Common'); 
 	retVal 				=    await top.window.showModalDialog("../../ePH/jsp/PrescriptionOverrideReasonFrameset.jsp?called_from=normal&calledFrom=INTRACTIONDTLS&drug_code="+drug_code+"&srl_no="+srl_no+"&patient_id="+patient_id+"&encounter_id="+encounter_id+"&calledFor=Alert&intr_restric_trn="+intr_restric_trn,arguments,features);
	/*var msg = getMessage("PH_INTERACTION_ALERT","PH");
	msg = msg.replace("$$$",drug_desc);
	msg = msg.replace("###",intr_dtl);
	alert(msg);*/
	return false;
}
//added for aakh-crf-0140
async function alertAbuse(drug_code, srl_no, patient_id, encounter_id, intr_restric_trn){
	//alert("alertAbuse");
	var retVal;
	var dialogTop		= "270";
 	var dialogHeight	= "50vh" ;
 	var dialogWidth		= "75vw" ;
	var dialogLeft		= "425" ;
	var center		= "0" ;
	var status		="no";

 	var features		= 'Width:' + dialogWidth +'; dialogHeight:' + dialogHeight + '; dialogWidth:' + dialogWidth +'; dialogLeft:' + dialogLeft +';  dialogTop:'+dialogTop +'; scroll=auto; status=no'+ "; center: " + center ;
 	var arguments		="DrugAbuse"; 
 	retVal 				=    await top.window.showModalDialog("../../ePH/jsp/PrescriptionOverrideReasonFrameset.jsp?called_from=normal&calledFrom=ABUSEDTLS&drug_code="+drug_code+"&srl_no="+srl_no+"&patient_id="+patient_id+"&encounter_id="+encounter_id+"&CalledFro=Alert&intr_restric_trn="+intr_restric_trn,arguments,features);
	/*var msg = getMessage("PH_INTERACTION_ALERT","PH");
	msg = msg.replace("$$$",drug_desc);
	msg = msg.replace("###",intr_dtl);
	alert(msg);*/
	return false;
}

async function showInractionDtl(drug_code, srl_no, patient_id, encounter_id, intr_restric_trn,order_id,order_line_no){//order_id,order_line_no added for MMS-KH-CRF-0034.4
	var retVal;
	var dialogTop		= ""; // dialogTop and dialogHeight modified for FD-RUT-CRF-0066.1 [IN036975]
 	var dialogHeight	= "80vh" ;
 	var dialogWidth		= "80vw" ;
	var dialogLeft		= "" ;
//MMS-KH-CRF-0034.4 - start
	  if(order_id==undefined){
	   order_id = "";
	   order_line_no = "";
	  }
//MMS-KH-CRF-0034.4 - end
 	var features		= 'Width:' + dialogWidth +'; dialogHeight:' + dialogHeight + '; dialogWidth:' + dialogWidth +'; dialogLeft:' + dialogLeft +';  dialogTop:'+dialogTop +'; scroll=auto; status=no';
 	var arguments		=getLabel("Common.DrugInteraction.label",'Common'); 
 	retVal 				=    await top.window.showModalDialog("../../ePH/jsp/PrescriptionOverrideReasonFrameset.jsp?called_from=normal&calledFrom=INTRACTIONDTLS&drug_code="+drug_code+"&srl_no="+srl_no+"&patient_id="+patient_id+"&encounter_id="+encounter_id+"&order_id="+order_id+"&order_line_no="+order_line_no,arguments,features);
}
//added for AAKH-CRF-0140 start
async function showAbuseDtl(drug_code, srl_no, patient_id, encounter_id, intr_restric_trn,order_id,order_line_no){
	var retVal;
	var dialogTop		= "170"; 
 	var dialogHeight	= "32vw" ;
 	var dialogWidth		= "50vh" ;
	var dialogLeft		= "375" ;

	  if(order_id==undefined){
	   order_id = "";
	   order_line_no = "";
	  }

 	var features		= 'Width:' + dialogWidth +'; dialogHeight:' + dialogHeight + '; dialogWidth:' + dialogWidth +'; dialogLeft:' + dialogLeft +';  dialogTop:'+dialogTop +'; scroll=auto; status=no';
 	var arguments		=getLabel("Common.DrugInteraction.label",'Common'); 
 	retVal 				=    await window.showModalDialog("../../ePH/jsp/PrescriptionOverrideReasonFrameset.jsp?called_from=normal&calledFrom=ABUSEDTLS&drug_code="+drug_code+"&srl_no="+srl_no+"&patient_id="+patient_id+"&encounter_id="+encounter_id+"&order_id="+order_id+"&order_line_no="+order_line_no,arguments,features);
}
//added for AAKH-CRF-0140 end

 //added for Bru-HIMS-CRF-079 IN[029945] - start
function alertMandFlds(drugCode, srlNo){
	alert( getMessage("PH_MANDATORY","PH"));
	var frmObjform_1 = parent.parent.f_prescription.f_prescription_form.prescription_form;
	eval("frmObjform_1.drug_"+drugCode+"_"+srlNo).click();
}
 //added for Bru-HIMS-CRF-079 IN[029945] -end

//added below functions for Bru-HIMS-CRF-093[29960] -->
 function checkHomeLeave(){
	 var dtlFormObj;
	 var callFrom="";
	if(document.prescription_header_form != undefined) {//here
		var hdr_frm = document.prescription_header_form;
		var start_date =hdr_frm.sys_date.value;
		var end_date ="";
		dtlFormObj = parent.f_detail.document.prescription_detail_form;
		callFrom="H";
	}
	else{
		hdr_frm =  parent.f_header.document.prescription_header_form;
		dtlFormObj =document.prescription_detail_form;
		var start_date=dtlFormObj.start_date.value;
		var end_date=dtlFormObj.end_date.value;
		callFrom="D";
	}
	var patient_class			= hdr_frm.patient_class.value;
	var home_leave_yn_val				= hdr_frm.home_leave_yn_val.value;
	if(patient_class!="IP" || home_leave_yn_val!="Y")
		return false;
	var home_leave_fm				= hdr_frm.home_leave_fm.value;
	var home_leave_to				= hdr_frm.home_leave_to.value;
	var home_leave_yn_chk			= hdr_frm.home_leave_yn_chk.value;
	var bean_id				=	hdr_frm.bean_id.value;
	var bean_name			=	hdr_frm.bean_name.value;
	var retVal="";
	if(home_leave_yn_chk =='Y')
		home_leave =true;
	else
		home_leave =false;
	if( home_leave_yn_val =='Y'){
		var xmlDoc="";
		var xmlHttp = new XMLHttpRequest();
		xmlStr	="<root><SEARCH " ;
		xmlStr		+="bean_id"+"=\""+ bean_id+"\" " ;
		xmlStr		+="bean_name"+"=\""+ bean_name+"\" " ;
		xmlStr += "start_date=\""+start_date +"\" " ;
		xmlStr += "end_date=\""+ end_date +"\" " ;
		xmlStr += "home_leave_fm=\""+ home_leave_fm +"\" " ;
		xmlStr += "home_leave_to=\""+ home_leave_to +"\" " ;
		xmlStr +=" /></root>" ;
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open( "POST", "PrescriptionValidation_2.jsp?func_mode=checkHomeLeaveValues", false ) ;
		xmlHttp.send( xmlDoc ) ;	
		responseText=xmlHttp.responseText ;
		home_leave = eval(responseText);
		if(callFrom=='H'){
			hdr_frm.home_leave_yn_chk.disabled =false;
		}
	}
	if(home_leave==true && hdr_frm.home_leave_yn_chk.disabled==false){
		retVal =confirm(getMessage('PH_HOME_LEAVE_FOR_CURRENT_DATE','PH'));
		var checked_yn;//Added for Bru-HIMS-CRF-093-DD1[IN047223]--start
		if(retVal!=undefined && retVal ==true)
			checked_yn = "Y";
		else
			checked_yn = "N";
		callIntitialHomecheck(checked_yn);//Added for Bru-HIMS-CRF-093-DD1[IN047223]
		if(retVal!=undefined && retVal ==true){
			hdr_frm.home_leave_yn_chk.checked =true;
			hdr_frm.home_leave_yn_chk.value='Y';
			return;
		}
		else{
			hdr_frm.home_leave_yn_chk.checked =false;
			hdr_frm.home_leave_yn_chk.value='N';
			return;
		}
	}
	/*else if(home_leave==false && home_leave_yn_chk=='Y'){//Commented for Bru-HIMS-CRF-093-DD1[IN047223] --start
		alert(getMessage('PH_HOME_LEAVE_NOT_FALL_IN_DATE','PH'));
		if(callFrom=='H'){
			hdr_frm.home_leave_yn_chk.checked =false;
			hdr_frm.home_leave_yn_chk.disabled =true;
			hdr_frm.home_leave_yn_chk.value='N';
		}
		if(dtlFormObj.drug_code.value!=""){
			dtlFormObj.start_date.value =hdr_frm.sys_date.value;
			populateEndDate();
		}
	}*///Commented for Bru-HIMS-CRF-093-DD1[IN047223]
}
//adding end for Bru-HIMS-CRF-093[29960] -->
 function assignHomeLeave(obj){
	 var checked_yn;//Added for Bru-HIMS-CRF-093-DD1[IN047223]
	if(obj.checked==true){
		document.prescription_header_form.home_leave_yn_chk.value="Y";
		checked_yn="Y";//Added for Bru-HIMS-CRF-093-DD1[IN047223]
	}
	else{
	  document.prescription_header_form.home_leave_yn_chk.value="N";
	  checked_yn="N";//Added for Bru-HIMS-CRF-093-DD1[IN047223]
	}
	callIntitialHomecheck(checked_yn);//Added for Bru-HIMS-CRF-093-DD1[IN047223]
 }
//added for CRF RUT-CRF-0063[29601]--start 
 async function chkPregnencyAlert(){
	var formobj=document.prescription_detail_form;
	if(formobj==undefined || formobj==null )
		formobj = document.prescription_form;
	var pregnency_yn=formobj.pregnency_yn.value;
	var preg_effect=formobj.preg_effect.value;
	var pregnency_cat=formobj.pregnency_cat.value;
	var pregnency_cat_desc=formobj.pregnency_cat_desc.value;
	var preg_category_code=formobj.preg_category_code.value;
	var preg_warn_req_yn=formobj.preg_warn_req_yn.value;
	var trimester=formobj.trimester.value;
	var preg_remarks="";
	var drug_desc=formobj.drug_name.value;
	if(document.prescription_detail_form!=undefined || document.prescription_detail_form!=null)
		preg_remarks=document.prescription_detail_form.preg_remarks.value;
	//preg_remarks= decodeURIComponent(preg_remarks,"UTF-8");
	if(pregnency_yn=="Y" &&  preg_effect!="" ){
		var dialogHeight= "35vh" ;
		var dialogWidth	= "45vw" ;
		var dialogTop	= "190" ;
		var dialogLeft	= "225" ;
		var center		= "0" ;
		var status		="no";
		var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop+"; dialogLeft:"+dialogLeft;
		var arguments	= "" ;
		retVal = await window.showModalDialog("../../ePH/jsp/PregnencyDrugEffectAlert.jsp?pregnency_cat="+pregnency_cat+"&preg_effect="+encodeURIComponent(preg_effect)+"&pregnency_cat_desc="+pregnency_cat_desc+"&preg_remarks="+preg_remarks+"&drug_desc="+drug_desc+"&preg_category_code="+preg_category_code+"&trimester="+trimester,arguments,features);
		if(retVal!=undefined || retVal!=null){
			pregRemarks = retVal;
			if(document.prescription_detail_form!=undefined || document.prescription_detail_form!=null)
				document.prescription_detail_form.preg_remarks.value=pregRemarks;
		}
	}
 }

 function savePregRemarks(obj){
	var remarks		= encodeURIComponent(obj.preg_remarks.value);
	var retval="";
	if(remarks==""){
		alert(getMessage('PH_SELECT_PREG_OVERRIDE_RESONE','PH'));
		return false;
	}
	window.returnValue = remarks;
	window.close();
}

function checkPregRemarksMaxLimit(obj,maxLeng) { 
	if(obj.value.length > maxLeng) {
		val = obj.value;
		var msg = getMessage("REMARKS_CANNOT_EXCEED","Common");
		msg = msg.replace("$",getLabel("ePH.OverrideReason.label","PH"));
		msg = msg.replace("#",maxLeng);
		obj.value = val.substring(0,maxLeng);
		alert(msg);
		obj.focus();
		return false;
	} 
	else 
		return true;
}
function settrimester(start_date){
	var formobj=document.prescription_header_form;
	if(document.prescription_header_form==undefined)
		formobj=parent.f_header.document.prescription_header_form;
	var lmp_date=formobj.lmp_date.value;
	var trimster_default=formobj.trimester.value;
	var drug_code="";
	if(document.prescription_detail_form!=undefined || document.prescription_detail_form!=null)
		drug_code=document.prescription_detail_form.drug_code.value;
	var bean_id=	formobj.bean_id.value;
	var bean_name=	formobj.bean_name.value;
	var xmlDoc="";
	var xmlHttp = new XMLHttpRequest();
	xmlStr	="<root><SEARCH " ;
	xmlStr		+="bean_id"+"=\""+ bean_id+"\" " ;
	xmlStr		+="bean_name"+"=\""+ bean_name+"\" " ;
	xmlStr += "start_date=\""+start_date +"\" " ;
	xmlStr += "lmp_date=\""+ lmp_date +"\" " ;
	xmlStr += "drug_code=\""+ drug_code +"\" " ;
	xmlStr += "trimster_default=\""+ trimster_default +"\" " ;
	xmlStr +=" /></root>" ;
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open( "POST", "PrescriptionValidation_2.jsp?func_mode=settrimester", false ) ;
	xmlHttp.send( xmlDoc ) ;	
	responseText=xmlHttp.responseText ;
	eval(responseText);
}

function assignpregdrug(preg_effect,preg_warn_req_yn,preg_category_code,trimester){
	document.prescription_detail_form.preg_effect.value=preg_effect;
	document.prescription_detail_form.preg_warn_req_yn.value=preg_warn_req_yn;
	document.prescription_detail_form.preg_category_code.value=preg_category_code;
	document.prescription_detail_form.trimester.value=trimester;
	if(preg_effect!="" && preg_warn_req_yn=="Y"  ){
		document.prescription_detail_form.preg_alert.style='display';
		chkPregnencyAlert();
	}
	else
		document.prescription_detail_form.preg_alert.style.display = 'none';
}// added for CRF RUT-CRF-0063[29601]--end

function assignBuildMAR(buildMAR_yn){ //Added for MMS-QH-CRF-0080 [IN:038064]
	 parent.parent.f_header.document.prescription_header_form.buildMAR_yn.value = buildMAR_yn;
}

function getAllergyConf(allergy_conf_reqd_yn){ //added for RUT-CRF-0064.1 [IN:041799]
	var allergyConf = true;
	if(allergy_conf_reqd_yn){
		allergyConf = confirm(getMessage("PH_PRES_ALLERGY_CONF", "PH"));
	}
	if(allergyConf)
		document.prescription_header_form.allergy_conf_reqd_yn.value = false;
	else
		document.prescription_header_form.allergy_conf_reqd_yn.value = true;
	return allergyConf;
}

function onChangeUOM(){ // added for SKR-SCF-0309.1  [IN030625]-- begin
	var formobj	   		 = document.prescription_detail_form;
	var qty_desc_code	 = formobj.qty_desc.value;
	var drug_code		 = formobj.drug_code.value;
	var srlNo			 = formobj.srl_no.value;
	var bean_id			 = formobj.bean_id.value;
	var bean_name		 = formobj.bean_name.value;
	
	var xmlStr ="<root><SEARCH ";
		xmlStr += " qty_desc_code=\""+ qty_desc_code + "\" ";
		xmlStr += " drug_code=\""+ drug_code + "\" ";
		xmlStr += " srlNo=\""+ srlNo + "\" ";
		xmlStr += " bean_id=\""+ bean_id + "\" ";
		xmlStr += " bean_name=\""+ bean_name + "\" ";
		xmlStr +=" /></root>";
	fieldValidation(xmlStr,"onChangeUOM");
}//SKR-SCF-0309.1  [IN030625] -- end

function calcTotTapQty(currObj,tapSlNo){  //Added for RUT-CRF-0088 [IN036978]
	var formobj=document.prescription_detail_form;
	var curr_tot_qty=formobj.prevTotalTaperQty.value;
	if(tapSlNo=="1" && parseFloat(currObj.value)==0){
		alert(getMessage(PH_NOT_BLANK_ZERO));
	}
	else{
		var total=parseFloat(curr_tot_qty)+parseFloat(currObj.value);
		formobj.totTapperQty.value=total;
	}
}

function updateTapLvlQty(drug_code,srl_no,totTapperQty,prev_tot_qty) { //Added for RUT-CRF-0088 [IN036978]
	var formobj=document.prescription_detail_form;
	var bean_id=	formobj.bean_id.value;
	var bean_name=	formobj.bean_name.value;
	var order_type_code=	formobj.order_type_code.value;//Added for  RUT-SCF-0321 [IN044816]
	var tapqty = formobj.totTapperQty.value;//Added for  RUT-SCF-0321 [IN044816]
	var taplvl;//Added for  RUT-SCF-0321 [IN044816]
	var tap_lvl_qty	=   document.prescription_detail_form.tap_lvl_qty.value;//Added for  RUT-SCF-0321 [IN044816]
	var xmlStr	="<root><SEARCH " ;
	var xmlDoc="";
	var xmlHttp = new XMLHttpRequest();
	xmlStr		+="bean_id"+"=\""+ bean_id+"\" " ;
	xmlStr		+="bean_name"+"=\""+ bean_name+"\" " ;
	xmlStr +="drug_code=\""+ drug_code + "\" ";
	xmlStr += " totTapperQty=\""+ totTapperQty.value + "\" ";
	xmlStr += " order_type_code=\""+ order_type_code + "\" ";//Added for  RUT-SCF-0321 [IN044816]
	xmlStr += " prev_tot_qty=\""+ prev_tot_qty + "\" ";
	xmlStr += " tapqty=\""+ tapqty + "\" ";                   //Added for  RUT-SCF-0321 [IN044816]
	xmlStr += " srl_no=\""+ srl_no + "\" ";
	xmlStr += " tap_lvl_qty=\""+ tap_lvl_qty + "\" ";         //Added for  RUT-SCF-0321 [IN044816]
	xmlStr +=" /></root>" ;
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open( "POST", "PrescriptionValidation_2.jsp?func_mode=updateTapLvlQty", false ) ;
	xmlHttp.send( xmlDoc ) ;	
	responseText=xmlHttp.responseText ;
	taplvl = eval(responseText);//Added for  RUT-SCF-0321 [IN044816]
	if(taplvl!=undefined)//Added for  RUT-SCF-0321 [IN044816]
		assigntapLvl(taplvl);//Added for  RUT-SCF-0321 [IN044816]
}

function assignTapQty(tot_tap_qty){  //Added for RUT-CRF-0088 [IN036978]
	var formobj=document.prescription_detail_form;
	formobj.tap_lvl_qty.value=tot_tap_qty;
}

function assigntapLvl(taplvl){//Added for  RUT-SCF-0321 [IN044816]
	var formobj=document.prescription_detail_form;
	formobj.tap_lvl_qty.value=taplvl;
}

function alertNoApplicaFreq(priority){ //Added for  for ML-BRU-SCF-1046 [IN:043889]
	if(priority=='U'){
		alert(getMessage('APPICABLE_STAT_FREQUENCIES_NOT_DEFINED','PH'));
		document.prescription_detail_form.priority.value='R';
	}
	else{
		alert(getMessage('PH_APPICABLE_ROUTINE_FREQUENCIES_NOT_DEFINED','PH'));
		document.prescription_detail_form.priority.value='U';
	}
}

async function callWitnessAuth(){ //Added for AAKH-CRF-0023[IN:038259] start
	var hdrFormObj = parent.parent.f_header.document.prescription_header_form;
	var patient_id=hdrFormObj.patient_id.value;
	var encounter_id=hdrFormObj.encounter_id.value;
	var dialogHeight	= "40vh";
	var dialogWidth		= "70vw";
	var dialogTop		=  window.screen.availWidth - 1100;
	var dialogLeft		=  window.screen.availWidth - 1000;
	var center			= "0";
	var status			= "no";	
	var features		= "dialogHeight:" + dialogHeight +"; dialogLeft:"+dialogLeft+ "; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop;
	var retVal= await window.showModalDialog("../../ePH/jsp/UserPINAuthorization.jsp?call_from=MAR&Witness=Y&patient_id="+patient_id+"&encounter_id="+encounter_id,"",features);
	if(retVal==undefined || retVal=='C')
		return false;
	else
		return true;
}// Added for AAKH-CRF-0023[IN:038259] end

function alertATCDup(drug_desc, msg1, dusp_drug_desc, msg2){
	alert(decodeURIComponent(drug_desc,"UTF-8")+" "+msg1+" "+decodeURIComponent(dusp_drug_desc,"UTF-8")+" "+msg2);
}

function loadDispLocnForFreq(priority){ //Added for MMS_BETA_0043 [IN:046240]
	var formobj=document.prescription_detail_form;
	if(formobj.drug_code.value!=""){
		var bean_id=	formobj.bean_id.value;
		var bean_name=	formobj.bean_name.value;
		var source_type	=	parent.f_header.document.prescription_header_form.source_type.value;
		var source_code	=	parent.f_header.document.prescription_header_form.source_code.value;
		var home_leave_yn_chk	=	parent.f_header.document.prescription_header_form.home_leave_yn_chk.value; 
		var patient_id	=	parent.f_header.document.prescription_header_form.patient_id.value;
		var encounter_id	=	parent.f_header.document.prescription_header_form.encounter_id.value;
		var take_home_medication	=	parent.f_header.document.prescription_header_form.take_home_medication.value;
		var xmlStr	="<root><SEARCH " ;
		var xmlDoc="";
		var xmlHttp = new XMLHttpRequest();
		xmlStr		+="bean_id"+"=\""+ bean_id+"\" " ;
		xmlStr		+="bean_name"+"=\""+ bean_name+"\" " ;
		xmlStr +=" priority=\""+ priority + "\" ";
		xmlStr +=" act_patient_class=\""+ parent.f_header.document.prescription_header_form.act_patient_class.value + "\" "; 
		xmlStr +=" in_formulary_yn=\""+ formobj.in_formulary_yn.value + "\" ";
		xmlStr +=" order_type_code=\""+ formobj.order_type_code.value + "\" ";
		xmlStr +=" srlNo=\""+ formobj.srl_no.value + "\" ";
		xmlStr +=" drug_code=\""+ formobj.drug_code.value + "\" ";
		xmlStr +=" drug_class=\""+ formobj.drug_class.value + "\" ";
		xmlStr +=" source_type=\""+ source_type + "\" ";
		xmlStr +=" source_code=\""+ source_code+ "\" ";
		xmlStr +=" take_home_medication=\""+ take_home_medication+ "\" ";
		xmlStr +=" home_leave_yn_val=\""+ home_leave_yn_chk+ "\" "; 
		xmlStr +=" patient_id=\""+ patient_id+ "\" ";
		xmlStr +=" encounter_id=\""+ encounter_id+ "\" ";
		xmlStr +=" /></root>" ;
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open( "POST", "PrescriptionValidation_2.jsp?func_mode=loadDispLocnForFreq", false ) ;
		xmlHttp.send( xmlDoc ) ;	
		responseText=xmlHttp.responseText ;
		eval(responseText);
	}
}

function updateDefDuration(){
	var durn_value = document.prescription_header_form.durn_value.value;
	var durn_desc = document.prescription_header_form.durn_desc.value;
	var bean_id = document.prescription_header_form.bean_id.value;
	var bean_name = document.prescription_header_form.bean_name.value;
	var xmlStr	="<root><SEARCH " ;
	var xmlDoc="";
	var xmlHttp = new XMLHttpRequest();
	xmlStr		+="bean_id"+"=\""+ bean_id+"\" " ;
	xmlStr		+="bean_name"+"=\""+ bean_name+"\" " ;
	xmlStr += "durn_value=\""+durn_value +"\" " ;
	xmlStr += "durn_desc=\""+ durn_desc +"\" " ;
	xmlStr +=" /></root>" ;
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open( "POST", "PrescriptionValidation_2.jsp?func_mode=setDefaultDuration", false ) ;
	xmlHttp.send( xmlDoc ) ;	
	responseText=xmlHttp.responseText ;
	eval(responseText);
	
}

function defHdrDuration(){
	if(!parent.f_header.document.getElementById("tdPrescripionHdrDuration").style.visibility == 'visible' || document.prescription_detail_form.freq_nature.value == 'O')
		return;
	var hdr_durn_value = parent.f_header.document.prescription_header_form.durn_value.value;
	var hdr_durn_desc = parent.f_header.document.prescription_header_form.durn_desc.value;
	var durn_value = document.prescription_detail_form.durn_value.value;
	var durn_desc = document.prescription_detail_form.durn_desc.value;
	if(durn_desc=='M'|| durn_desc=='H')
		return;
	var bean_id = document.prescription_detail_form.bean_id.value;
	var bean_name = document.prescription_detail_form.bean_name.value;
	if(hdr_durn_value == '')
		hdr_durn_value = durn_value;
	var xmlStr	="<root><SEARCH " ;
	var xmlDoc="";
	var xmlHttp = new XMLHttpRequest();
	xmlStr		+="bean_id"+"=\""+ bean_id+"\" " ;
	xmlStr		+="bean_name"+"=\""+ bean_name+"\" " ;
	xmlStr += "durn_value=\""+durn_value +"\" " ;
	xmlStr += "durn_desc=\""+ durn_desc +"\" " ;
	xmlStr += "hdr_durn_value=\""+hdr_durn_value +"\" " ;
	xmlStr += "hdr_durn_desc=\""+hdr_durn_desc +"\" " ;
	xmlStr +=" /></root>" ;
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open( "POST", "PrescriptionValidation_2.jsp?func_mode=setDuration", false ) ;
	xmlHttp.send( xmlDoc ) ;	
	responseText=xmlHttp.responseText ;
	eval(responseText);
}
	  
function  returnheaderdur(duration,dur_type){
    document.prescription_detail_form.durn_value.value = duration;
    document.prescription_detail_form.durn_desc.value  = dur_type;
    document.prescription_detail_form.durn_desc.selected=true;
}//Added for BRU-HIMS-CRF-403 --end

function setDate(order_date){
	var bean_id = document.prescription_header_form.bean_id.value;
	var bean_name = document.prescription_header_form.bean_name.value;
	var xmlStr	="<root><SEARCH " ;
	var xmlDoc="";
	var xmlHttp = new XMLHttpRequest();
	xmlStr		+="bean_id"+"=\""+ bean_id+"\" " ;
	xmlStr		+="bean_name"+"=\""+ bean_name+"\" " ;
	xmlStr += "order_date=\""+order_date +"\" " ;
	xmlStr +=" /></root>" ;
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open( "POST", "PrescriptionValidation_2.jsp?func_mode=setDate", false ) ;
	xmlHttp.send( xmlDoc ) ;	
	responseText=xmlHttp.responseText ;
	eval(responseText);
}
//Added for Bru-HIMS-CRF-093-DD1[IN047223]--start
function calulateDurnValue(start_date,end_date,locale,tempstartdate1,tempenddate1,patient_class1,called_from){//Added called_from for INC#49425
	var bean_id = document.prescription_detail_form.bean_id.value;
	var bean_name = document.prescription_detail_form.bean_name.value;
	var pat_class = document.prescription_detail_form.patient_class.value;
	if(called_from=="normaldetail")//Added for INC#49425--start
		var form_obj = parent.f_header.document.prescription_header_form;
	else
		var form_obj = parent.parent.f_header.document.prescription_header_form;//Added for INC#49425--end
	var sliding_scale_yn  = document.prescription_detail_form.sliding_scale_yn.value;
	var takehome;
	var durn;
	if(form_obj.home_leave_yn_chk!=undefined && form_obj.home_leave_yn_chk.checked)
		takehome = "Y";
	else
		takehome = "N"
	if(takehome=="Y" && document.prescription_detail_form.freq_nature.value != 'O'){
		var durtype = document.forms[0].durn_desc.value;
		if(durtype!='' && (durtype=='D' ||durtype=='H' ||durtype=='M')){
		document.prescription_detail_form.start_date.value =tempstartdate1;
		document.prescription_detail_form.end_date.value =tempenddate1;
		    durn = daysBetween(tempstartdate1,tempenddate1,"DMYHM",locale);
		if(durn==0){
			durn = 1;
			alert(getMessage("PH_HOME_LEAVE_NOT_FALL_IN_DATE", "PH"));
		}
			if(durtype=='H' ||durtype=='M'){
				document.prescription_detail_form.durn_desc.value  = "D";
				document.prescription_detail_form.durn_desc.selected=true;
			}
			document.forms[0].durn_value.value=durn;
	if(called_from=="normaldetail")//Added for INC#49425--start
		assignHomeDuration();
	else
		assignHomeDurationsliding();//Added for INC#49425--end
			var drug_code=document.forms[0].drug_code.value;
			var xmlStr	="<root><SEARCH " ;
			var xmlDoc="";
			var xmlHttp = new XMLHttpRequest();
			xmlStr		+="bean_id"+"=\""+ bean_id+"\" " ;
			xmlStr		+="bean_name"+"=\""+ bean_name+"\" " ;
			xmlStr += "durn=\""+durn +"\" " ;
			xmlStr += "pat_class=\""+pat_class +"\" " ;
			xmlStr += "drug_code=\""+drug_code +"\" " ;
			xmlStr += "sliding_scale_yn=\""+sliding_scale_yn +"\" " ;
			xmlStr +=" /></root>" ;
			xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
			xmlHttp.open( "POST", "PrescriptionValidation_2.jsp?func_mode=setHomeMedDuration", false ) ;
			xmlHttp.send( xmlDoc ) ;	
			responseText=xmlHttp.responseText ;
			eval(responseText);
		}
		else{
			alert(getMessage("PH_HOME_LEAVE_NOT_FALL_IN_DATE", "PH"));
		}
	}
}

function callIntitialHomecheck(checked_yn){
	var bean_id = document.prescription_header_form.bean_id.value;
	var bean_name = document.prescription_header_form.bean_name.value;
	var xmlStr	="<root><SEARCH " ;
	var xmlDoc="";
	var xmlHttp = new XMLHttpRequest();
	xmlStr		+="bean_id"+"=\""+ bean_id+"\" " ;
	xmlStr		+="bean_name"+"=\""+ bean_name+"\" " ;
	xmlStr += "checked_yn=\""+checked_yn +"\" " ;
	xmlStr +=" /></root>" ;
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open( "POST", "PrescriptionValidation_2.jsp?func_mode=setHomeleavecheck", false ) ;
	xmlHttp.send( xmlDoc ) ;	
	responseText=xmlHttp.responseText ;
	eval(responseText);
}

function assignHomeDuration(){
	//document.prescription_detail_form.durn_value.onblur();
	var form_obj = parent.f_header.document.prescription_header_form;
	var takehome;
	if(form_obj.home_leave_yn_chk!=undefined && form_obj.home_leave_yn_chk.checked && document.prescription_detail_form.freq_nature.value != 'O'){
		var take_home_start = document.forms[0].take_home_start_date.value;
		var take_home_end = document.forms[0].take_home_end_date.value;
		var currstart_date = document.forms[0].start_date.value;
		var currend_date = document.forms[0].end_date.value;
		if(currend_date!=take_home_end || take_home_start!=currstart_date){
			if(!isBetween(take_home_start,take_home_end,currstart_date,"DMYHM","en") || !isBetween(take_home_start,take_home_end,currend_date,"DMYHM","en"))
				alert(getMessage("PH_HOME_LEAVE_NOT_FALL_IN_DATE", "PH"));
		}
	}
}//Added for Bru-HIMS-CRF-093-DD1[IN047223]--end

function assignHomeDurationsliding(){//Added for INC#49425--start
	var form_obj = parent.parent.f_header.document.prescription_header_form;
	var takehome;
	if(form_obj.home_leave_yn_chk!=undefined && form_obj.home_leave_yn_chk.checked && document.prescription_detail_form.freq_nature.value != 'O'){
		var take_home_start = document.forms[0].take_home_start_date.value;
		var take_home_end = document.forms[0].take_home_end_date.value;
		var currstart_date = document.forms[0].start_date.value;
		var currend_date = document.forms[0].end_date.value;
		if(currend_date!=take_home_end || take_home_start!=currstart_date){
		if(!isBetween(take_home_start,take_home_end,currstart_date,"DMYHM","en") || !isBetween(take_home_start,take_home_end,currend_date,"DMYHM","en"))
			alert(getMessage("PH_HOME_LEAVE_NOT_FALL_IN_DATE", "PH"));
		}
	}	
}//Added for INC#49425--end

function checkDiagnosis(patient_id, encounter_id, diag_for_medn_order_by, params){//Added for HSA-CRF-0152 [IN:048469] 
	var patient_id =document.prescription_header_form.patient_id.value;
	var encounter_id =document.prescription_header_form.encounter_id.value;
	var diag_for_medn_order_by =document.prescription_header_form.diag_for_medn_order_by.value;
	var bean_id =document.prescription_header_form.bean_id.value;
	var bean_name =document.prescription_header_form.bean_name.value;
	var xmlStr	="<root><SEARCH " ;
	var xmlDoc="";
	var xmlHttp = new XMLHttpRequest();
	xmlStr		+="bean_id"+"=\""+ bean_id+"\" " ;
	xmlStr		+="bean_name"+"=\""+ bean_name+"\" " ;
	xmlStr += "patient_id=\""+patient_id +"\" " ;
	xmlStr += "encounter_id=\""+encounter_id +"\" " ;
	xmlStr += "diag_for_medn_order_by=\""+diag_for_medn_order_by +"\" " ;
	xmlStr += "params=\""+params +"\" " ;
	xmlStr +=" /></root>" ;
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open( "POST", "PrescriptionValidation_2.jsp?func_mode=checkDiagnosis", false ) ;
	xmlHttp.send( xmlDoc ) ;	
	responseText=xmlHttp.responseText ;
	eval(responseText);
}

function callLoadOtherFrames(diag_size, params){
	document.prescription_header_form.diag_size.value = diag_size;
	document.location.reload();
	//loadOtherFrames( params);
}//Added for HSA-CRF-0152 [IN:048469] -End

function getOrderCatalogAuthRule(){//added for HSA-CRF-0150 [IN:048467]
	var formobj=document.prescription_detail_form;
	var patient_id	=	parent.f_header.document.prescription_header_form.patient_id.value;
	var act_patient_class	=	parent.f_header.document.prescription_header_form.actual_patient_class.value;//changed act_patient_class to actual_patient_class for ML-MMOH-SCF-0525 [IN:062016]
	var resp_id		=	parent.f_header.document.prescription_header_form.resp_id.value; 
	var pract_id	=	parent.f_header.document.prescription_header_form.pract_id.value;
	var take_home_medication	=	parent.f_header.document.prescription_header_form.take_home_medication.value;
	var priority	=	formobj.priority.value; 
	var fldString=" priority=\""+ priority + "\" ";
	fldString +=" act_patient_class=\""+act_patient_class + "\" "; 
	fldString +=" drug_code=\""+ formobj.drug_code.value + "\" ";
	fldString +=" srlNo=\""+ formobj.srl_no.value + "\" ";
	fldString +=" take_home_medication=\""+ take_home_medication+ "\" ";
	fldString +=" patient_id=\""+ patient_id+ "\" ";
	fldString +=" resp_id=\""+ resp_id+ "\" ";
	fldString +=" pract_id=\""+ pract_id+ "\" "; 
	var xmlStr=formXMLString(formobj,fldString);
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest() ;
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST","PrescriptionValidation_2.jsp?func_mode=getOrderCatalogAuthRule",false);
	xmlHttp.send(xmlDoc);
	responseText=xmlHttp.responseText ;
	eval(responseText);
}

function UpdateOrderCatalogAuthRule(ord_auth_reqd_yn, ord_authorized_yn){//added for HSA-CRF-0150 [IN:048467]
	var display_auth_rule = "hidden";
	var color_auth_rule = "red";
	if(ord_auth_reqd_yn=='Y'){
		display_auth_rule = "visible";
		if(ord_authorized_yn == 'Y')
			color_auth_rule = "green";
	}
	document.getElementById("lbl_authorize").style.visibility=display_auth_rule;
	document.getElementById("lbl_authorize").style.color=color_auth_rule;
	document.getElementById("ord_auth_reqd_yn").value=ord_auth_reqd_yn;
	document.getElementById("authroize_yn_val").value=ord_authorized_yn;
}

function checkDuplicateDrug(frmObj_pres_dtl, freq_code, calledFrom){//Added for ML-BRU-SCF-1431 [IN:051136]  // freq_code added for MO-GN-5490 [IN:054620]
	var  formHdrObj;
	if(freq_code == undefined) // added for MO-GN-5490 [IN:054620]
		freq_code="";
	if(parent.f_header==null) {
		formHdrObj = parent.parent.f_header.document.prescription_header_form;
	} 
	else {
		formHdrObj	=	parent.f_header.document.prescription_header_form;
	}

	var start_date		=	frmObj_pres_dtl.start_date.value;
	var end_date		=	frmObj_pres_dtl.end_date.value;//added for SKR-SCF-1343
	var durn_value		=	frmObj_pres_dtl.durn_value.value;
	var drug_code		=	frmObj_pres_dtl.drug_code.value;
	var srlNo			=	frmObj_pres_dtl.srl_no.value;
	var allow_duplicate	=	frmObj_pres_dtl.allow_duplicate.value; // added for MO-GN-5490 [IN:054620]
	var patient_id	=	frmObj_pres_dtl.patient_id.value; //Added for ML-BRU-SCF-1431 [IN:051136] -start
	var drug_db_interface_yn	=	formHdrObj.drug_db_interface_yn.value;
	var drug_db_duptherapy_yn	=	formHdrObj.drug_db_duptherapy_yn.value; //Added for ML-BRU-SCF-1431 [IN:051136] -end

	if(durn_value!=''){
		var fldString="  start_date=\""+ start_date + "\" ";
		fldString += " durn_value=\""+ durn_value + "\" ";
		fldString += " drug_code=\""+ drug_code + "\" ";
		fldString += " srlNo=\""+ srlNo + "\" ";
		fldString += " patient_id=\""+ patient_id + "\" "; //Added for ML-BRU-SCF-1431 [IN:051136] -start
		fldString += " drug_db_interface_yn=\""+ drug_db_interface_yn + "\" ";
		fldString += " drug_db_duptherapy_yn=\""+ drug_db_duptherapy_yn + "\" "; //Added for ML-BRU-SCF-1431 [IN:051136] -end
		fldString += " allow_duplicate=\""+ allow_duplicate + "\" "; // added for MO-GN-5490 [IN:054620]
		fldString += " freq_code=\""+ freq_code + "\" "; // added for MO-GN-5490 [IN:054620]
		fldString += " calledFrom=\""+ calledFrom + "\" "; // added for MO-GN-5490 [IN:054620]
		fldString += " end_date=\""+ end_date + "\" "; //ADDED for SKR-SCF-1343
		var xmlStr=formXMLString(frmObj_pres_dtl,fldString);
		var xmlDoc = "" ;
		var xmlHttp = new XMLHttpRequest() ;
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open("POST","PrescriptionValidation_2.jsp?func_mode=checkDuplicateDrug",false);
		xmlHttp.send(xmlDoc);
		responseText=xmlHttp.responseText ;
		eval(responseText);
	}
}

function loadDrugDetails(Drug_Codes, Trade_Codes, Trade_Names){//converted to function for PMG2012-CRF-0019 [IN:035859] AutoComplete
	if(Drug_Codes.length>0 )  {
		if(parent.f_header.document.prescription_header_form.order_type!=null){
			parent.f_header.document.prescription_header_form.order_type.disabled=true;
		}
		updateOROrderType(parent.f_header.document.prescription_header_form.order_type.value);
		updateOROrderCatalog(Drug_Codes);
		chkDuplicateDrugCode(Drug_Codes, Trade_Codes, Trade_Names );
		parent.f_header.document.prescription_header_form.take_home_medication.disabled=true;
		parent.f_header.document.prescription_header_form.sys_date.disabled=true;
		parent.f_header.document.prescription_header_form.Calendar.disabled=true;
		parent.f_header.document.prescription_header_form.home_leave_yn_chk.disabled=true;
		if(parent.f_header.document.getElementById("tdPrescripionHdrDuration").style.visibility == 'visible'){
			parent.f_header.document.prescription_header_form.durn_value.disabled=true;
			parent.f_header.document.prescription_header_form.durn_desc.disabled=true;
		}
	}
}

function dispPrevRecs(tdObj){
	var disp_prev_vital_signs_yn = document.querySelectorAll('#disp_prev_vital_signs_yn').value;
	if(disp_prev_vital_signs_yn != 'Y')
		return false;
    bodwidth  = parent.parent.frames[1].document.body.offsetWidth
    bodheight = parent.parent.frames[1].document.body.offsetHeight
    var x     = event.x;
    var y     = event.y;
    x     = x + (document.getElementById('divPrevHtWtDtls').offsetWidth)
    y     = y + (document.getElementById('divPrevHtWtDtls').offsetHeight)
    if(x<bodwidth)
        x = event.x
  //  else
     //   x = x - (document.getElementById("divPrevHtWtDtls").offsetWidth*2)

    if(y<bodheight)
        y = event.y
   // else
      //  y = y - (document.getElementById("divPrevHtWtDtls").offsetHeight*2)
    y+=document.body.scrollTop
    x+=document.body.scrollLeft

	if(x<30)
		document.getElementById('divPrevHtWtDtls').style.posLeft= x+20;
	else
		document.getElementById('divPrevHtWtDtls').style.posLeft= x;
	//if(y>0)
	document.getElementById('divPrevHtWtDtls').style.posTop = 0;
    document.getElementById("divPrevHtWtDtls").style='display';
}

function hidePrevRecs(){
	if(document.getElementById("divPrevHtWtDtls").style.display=='')
	    document.getElementById('divPrevHtWtDtls').style.display = "none" ;
}


 //AAKH-CRF-0091
 function checking_time(drugCode,trade_Codes,trade_Names,chk_stat_not,srl_no,chk_missing_sch_yn_1){
	if(chk_missing_sch_yn_1 !="Y"){	 
		var chk_time_confirm=confirm(getMessage("PH_SCH_TIME_STAT","PH"));
	 }
	
	if(chk_time_confirm==true || chk_time_confirm=="true" || chk_missing_sch_yn_1=="Y" ){
			var drug_arr = new Array();
			drug_arr[0]  = drugCode;
			var trade_code_arr =new Array();
			trade_code_arr[0]  =trade_Codes;
			var trade_name_arr  =new Array();
			trade_name_arr[0]   =trade_Names;
			
			loadDrugDetails1(drug_arr,trade_code_arr,trade_name_arr,"Y",srl_no);
		
		
		
	}
	else{
		
		return;
	}
 }
function loadDrugDetails1(Drug_Codes, Trade_Codes, Trade_Names,stat_YN,srl_no){//converted to function for PMG2012-CRF-0019 [IN:035859] AutoComplete
	if(Drug_Codes.length>0)  {
		
		if(parent.f_header.document.prescription_header_form.order_type!=null){
			
			parent.f_header.document.prescription_header_form.order_type.disabled=true;
		}
		
		updateOROrderType(parent.f_header.document.prescription_header_form.order_type.value);
		updateOROrderCatalog(Drug_Codes);
		chkDuplicateDrugCode(Drug_Codes, Trade_Codes, Trade_Names,"","",stat_YN);
		
		if(stat_YN=="Y"){
			checkStatYN("Y",Drug_Codes,srl_no);
		}
		
		
		parent.f_header.document.prescription_header_form.take_home_medication.disabled=true;
		parent.f_header.document.prescription_header_form.sys_date.disabled=true;
		parent.f_header.document.prescription_header_form.Calendar.disabled=true;
		parent.f_header.document.prescription_header_form.home_leave_yn_chk.disabled=true;
		if(parent.f_header.document.getElementById('tdPrescripionHdrDuration').style.visibility == 'visible'){
			parent.f_header.document.prescription_header_form.durn_value.disabled=true;
			parent.f_header.document.prescription_header_form.durn_desc.disabled=true;
		}
	}
}
function checkStatYN(stat_yn,drug_code,srl_no){
	var bean_id = parent.f_header.document.prescription_header_form.bean_id.value;
	var bean_name = parent.f_header.document.prescription_header_form.bean_name.value;
	var xmlStr	="<root><SEARCH " ;
	var xmlDoc="";
	var xmlHttp = new XMLHttpRequest();
	xmlStr		+="bean_id"+"=\""+ bean_id+"\" " ;
	xmlStr		+="bean_name"+"=\""+ bean_name+"\" " ;
	xmlStr += "stat_yn=\""+stat_yn +"\" " ;
	xmlStr += "drug_code=\""+drug_code +"\" " ;
	xmlStr += "srl_no=\""+srl_no +"\" " ;
	xmlStr +=" /></root>" ;
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open( "POST", "PrescriptionValidation.jsp?func_mode=stat_yn", false ) ;
	xmlHttp.send( xmlDoc ) ;	
	responseText=xmlHttp.responseText ;
	eval(responseText);
	
}
//MMS-KH-CRF-0029[IN070606] - start
function loadDrugInteractionForDrug(drug_code,patient_id){
	var bean_id = parent.f_header.document.prescription_header_form.bean_id.value;
	var bean_name = parent.f_header.document.prescription_header_form.bean_name.value;
	var xmlStr	="<root><SEARCH " ;
	var xmlDoc="";
	var xmlHttp = new XMLHttpRequest();
	xmlStr		+="bean_id"+"=\""+ bean_id+"\" " ;
	xmlStr		+="bean_name"+"=\""+ bean_name+"\" " ;
	xmlStr += "patient_id=\""+patient_id +"\" " ;
	xmlStr += "drug_code=\""+drug_code +"\" " ;
	xmlStr +=" /></root>" ;
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open( "POST", "PrescriptionValidation.jsp?func_mode=loadDrugInteractionForDrug", false ) ;
	xmlHttp.send( xmlDoc ) ;	
	responseText=xmlHttp.responseText ;
	eval(responseText);
	
}
//MMS-KH-CRF-0029[IN070606] - end



function statParent(oper_mode){
	if(oper_mode=="delete"){
	alert(getMessage("PH_STAT_PARENT", "PH"));
	return ;
	}
	else{
		alert(getMessage("PH_STAT_PARENT_MODIFY", "PH"));
		return true;
	}
}
//added for ml-mmoh-CRF-0978 start
function checkWtAndHt_recomm(frmObj){
	try{
		var formObject  = parent.f_header.document.prescription_header_form;
		var drug_db_dosecheck_yn = formObject.drug_db_dosecheck_yn.value;
		var ext_prod_id = document.prescription_detail_form.ext_prod_id.value;
		
		if(drug_db_dosecheck_yn!="Y" || ext_prod_id==""){
			if(formObject.height!=undefined && formObject.height!=null && formObject.weight!=null) {

				var weight		= formObject.weight.value;
				var bsa			= formObject.bsa.value;
				
				if(document.prescription_detail_form.recomm_yn.value=="Y") {
					document.getElementById('rec_legend').style.visibility='visible';
				}
			
				var dosage_type = document.prescription_detail_form.dosage.value;
				var recomm_dosage_by = document.prescription_detail_form.recomm_dosage_by.value;
			
				if(document.getElementById('rec_legend').style.visibility=='visible'){ 
					if(dosage_type != recomm_dosage_by) 
						document.getElementById('rec_legend_font').className='';
					else
						document.getElementById('rec_legend_font').className='HYPERLINK'
				}
				
				//alert(dosage_type+"dosage_type");
				//alert(recomm_dosage_by+"recomm_dosage_by");
				//alert("amendvalue"+document.getElementById("amend_yn").value);
           	var dosage_std	=	document.prescription_detail_form.dosage_std.value;
				var dosage_unit	=	document.prescription_detail_form.dosage_unit_uom.value;//code 'dosage_unit' replaced by dosage_unit_uom  for IN050721-->
				var title="<table border=1 cellpadding=0 cellspacing=0 align=center><tr><td class=TIP>&nbsp Std Dose: "+dosage_std+" "+dosage_unit+"&nbsp</td></tr></table>";
				if(document.prescription_detail_form.calc_by_ind.value=="A") {
					document.getElementById('rec_value').innerText	= dosage_std;
				//	alert(dosage_std+"dosage_std");
				//alert(dosage_unit);
					document.getElementById('rec_uom').innerText		= dosage_unit;
					//if condtion added for ml-mmoh-crf-0978

					if(dosage_type == recomm_dosage_by   && document.getElementById('default_recm_dose_yn').value =="Y")
						document.getElementById('qty_value').value=dosage_std;							
							}
				else if(formObject.weight.value.length > 0){//formObject.height.value.length > 0 &&  removed for ML-MMOH-SCF-1142
					 if(document.prescription_detail_form.calc_by_ind.value=="W") {
						var calc_value	=	parseInt(parseFloat(weight)*parseFloat(dosage_std));
						document.getElementById('rec_value').innerHTML ="<label nowrap style='color:red;font-size:10' onmouseover='displayToolTipDataChange(\"" + title + "\");' onmouseout='disasbleToolTipDataChange();'>"+calc_value+"</label>";
						var dos_unit = dosage_unit.split("/");
						document.getElementById('rec_uom').innerHTML ="<label nowrap style='color:red;font-size:10' onmouseover='displayToolTipDataChange(\"" + title + "\");' onmouseout='disasbleToolTipDataChange();'>"+dos_unit[0]+"</label>";
						//if condtion added for ml-mmoh-crf-0978	
						if(dosage_type == recomm_dosage_by  && document.getElementById('default_recm_dose_yn').value =="Y")
				                      	document.getElementById('qty_value').value=calc_value;
					}
					else if(formObject.height.value.length > 0 &&document.prescription_detail_form.calc_by_ind.value=="B") {// formObject.height.value.length > 0 &&ADDED FOR ML-MMOH-SCF-1142
						var calc_value	=	parseInt(parseFloat(bsa)*parseFloat(dosage_std));
						document.getElementById('rec_value').innerHTML ="<label nowrap style='color:red;font-size:10' onmouseover='displayToolTipDataChange(\"" + title + "\");' onmouseout='disasbleToolTipDataChange();'>"+calc_value+"</label>";
						var dos_unit = dosage_unit.split("/");
						document.getElementById('rec_uom').innerHTML ="<label nowrap style='color:red;font-size:10' onmouseover='displayToolTipDataChange(\"" + title + "\");' onmouseout='disasbleToolTipDataChange();'>"+dos_unit[0]+"</label>";
						//if condtion added for ml-mmoh-crf-0978
						if(dosage_type == recomm_dosage_by && document.getElementById('default_recm_dose_yn').value =="Y")
							document.getElementById('qty_value').value=calc_value;
				}
				}
			}
		}
	}
	catch(e){}
}

//added for ml-mmoh-CRF-0978 end
//added for GHL-CRF-0482 - start
function getPatientStockYN(frmObj,drug_code,patient_id,encounter_id,facility_id,pres_base_uom){

	var bean_id = frmObj.bean_id.value;
	var bean_name = frmObj.bean_name.value;
	
	var xmlStr	="<root><SEARCH " ;
	var xmlDoc="";
	var xmlHttp = new XMLHttpRequest();
	xmlStr		+="bean_id"+"=\""+ bean_id+"\" " ;
	xmlStr		+="bean_name"+"=\""+ bean_name+"\" " ;
	xmlStr += "drug_code=\""+drug_code +"\" " ;
	xmlStr += "patient_id=\""+patient_id +"\" " ;
	xmlStr += "encounter_id=\""+encounter_id +"\" " ;
	xmlStr += "facility_id=\""+facility_id +"\" " ;
	xmlStr += "pres_base_uom=\""+pres_base_uom+"\" " ;
	xmlStr +=" /></root>" ;
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open( "POST", "PrescriptionValidation.jsp?func_mode=CheckPatientStock", false ) ;
	xmlHttp.send( xmlDoc ) ;	
	responseText=xmlHttp.responseText ;
	eval(responseText);
}
function displayAlert(patient_stock_yn,patient_stock_str,uom){//GHL-CRF-0482
	if(parent.f_detail != undefined){
		var frmObj			= parent.f_detail.document.prescription_detail_form;
	}else{
		var frmObj			= parent.parent.f_detail.document.prescription_detail_form;
	}
	 if(patient_stock_yn=="Y"){
 		var msg = getMessage("PATIENT_STOCK_EXISTS","PH");
		msg = msg.replace("#",patient_stock_str+" "+uom);//GHL-CRF-0482
		vbC=vbConfirm(msg);
		//alert("vbC==>"+vbC);
		if(vbC==7){
			frmObj.patient_stock_yn.value = "Y";
			frmObj.patient_stock_allow_yn.value = "Y";
		}else{
			frmObj.patient_stock_yn.value = "N";
			frmObj.patient_stock_allow_yn.value = "Y";
		} 

	/*	var dialogHeight	= '10' ;
		var dialogWidth 	= '22' ;
		var features		= 'dialogHeight:' + dialogHeight + '; dialogWidth:' + dialogWidth +'; scroll=no;';
		var arguments	= "";
 	    	var returnValue = window.showModalDialog("../../ePH/jsp/PatientStockAlert.jsp",msg,features);

   	        if ( returnValue == 'N' ){
			frmObj.patient_stock_yn.value = "Y";
			frmObj.patient_stock_allow_yn.value = "Y";
		   }
	   else if(returnValue == 'Y'){
				frmObj.patient_stock_yn.value = "N";
				frmObj.patient_stock_allow_yn.value = "Y";

	   }else{
		frmObj.patient_stock_allow_yn.value = "N";
	   } */
 }

}
//added for GHL-CRF-0482 - end
function doseChange(obj){//Added for ARYU--CRF-0014

	if(obj!=undefined){
		var def_qty_value	=	document.prescription_detail_form.def_qty_value.value;
		var curr_val	=	obj.value;

		if(obj.value!="" && parseFloat(curr_val)!=parseFloat(def_qty_value)){ 
			document.prescription_detail_form.dosage_change_yn.value = "Y";
		}else{
			document.prescription_detail_form.dosage_change_yn.value = "N";
		}
	}

}
function patientStockOrderStatusUpdate(frmObj,drug_code,srl_no,patient_stock_yn){
//alert("drug_code==>"+drug_code+"==srl_no==>"+srl_no+"==patient_stock_yn==>"+patient_stock_yn);
	var bean_id = frmObj.bean_id.value;
	var bean_name = frmObj.bean_name.value;
	
	var xmlStr	="<root><SEARCH " ;
	var xmlDoc="";
	var xmlHttp = new XMLHttpRequest();
	xmlStr		+="bean_id"+"=\""+ bean_id+"\" " ;
	xmlStr		+="bean_name"+"=\""+ bean_name+"\" " ;
	xmlStr += "drug_code=\""+drug_code +"\" " ;
	xmlStr += "srl_no=\""+srl_no +"\" " ;
	xmlStr += "patient_stock_yn=\""+patient_stock_yn+"\" " ;
	xmlStr +=" /></root>" ;
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open( "POST", "PrescriptionValidation.jsp?func_mode=CheckPatientStockUpdateStatus", false ) ;
	xmlHttp.send( xmlDoc ) ;	
	responseText=xmlHttp.responseText ;
	eval(responseText);
}
async function medicationReconciliation(called_from){ // Added for MMS-KH-CRF-0016 - Start
//called_from addded for IN070786
	var patient_class	=	parent.f_header.document.prescription_header_form.patient_class.value;
	var pract_id		=	parent.f_header.document.prescription_header_form.pract_id.value;
	var patient_id		=	parent.f_header.document.prescription_header_form.patient_id.value;
	var encounter_id	=	parent.f_header.document.prescription_header_form.encounter_id.value;
	var iv_prep_yn	    =	parent.f_header.document.prescription_header_form.iv_prep_yn.value;
	var pract_type	    =	parent.f_header.document.prescription_header_form.pract_type.value;
	var discharge_ind	=	parent.f_header.document.prescription_header_form.take_home_medication.value;
	var gender          =   parent.f_header.document.prescription_header_form.gender.value;
	var patient_age     =   parent.f_header.document.prescription_header_form.patient_age.value;
	var patient_name    =   parent.f_header.document.prescription_header_form.patient_name.value;	
	var log_pract_id    =   parent.f_header.document.prescription_header_form.pract_id.value;
	var dialogHeight    =   "55vh" ;
	var dialogWidth	    =   window.screen.width+"px" ;
	var dialogTop       =   "128" ;
	var dialogLeft      =   "20" ;
	var center          =   "1" ;
	var status          =   "no";
	var scroll          =   "no";
	var features	    =   "dialogLeft:" + dialogLeft + ";dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; center: " + center + ";scroll: "+scroll+"; status: " + status + "; dialogTop :" + dialogTop;
	var arguments	    =   "" ;
	//called_from added for IN070786
	retVal              =   await window.showModalDialog("../../ePH/jsp/MedicationReconciliation.jsp?&patient_id="+patient_id+"&encounter_id="+encounter_id+"&patient_class="+patient_class+"&pract_id="+pract_id+"&iv_prep_yn="+iv_prep_yn+"&pract_type="+pract_type+"&discharge_ind="+discharge_ind+"&gender="+gender+"&patient_age="+patient_age+"&patient_name="+patient_name+"&log_pract_id="+log_pract_id+"&called_from="+called_from,arguments,features);
	
	if(retVal!=null && retVal!="") {
		updateOROrderType(parent.f_header.document.prescription_header_form.order_type.value);
		temp = retVal.split(",");
		mode = temp[temp.length-1];
		//return;
		var Drugs = "";
		var alldata = "";
		var trade_code = "";
		var trade_name = "";
		if(mode=="RecExternal"){
			Drugs = retVal.substring(0,retVal.indexOf("!")-1);
			alldata = "";
			trade_code = "";
			trade_name = "";
		}
		else{
		   Drugs = retVal.substring(0,retVal.indexOf("!")-1);
		   alldata = retVal.substring(retVal.indexOf("!"),retVal.length-13);
		   DrugsOrders = 0;
		   DrugsOrders = alldata.split("!");
		   trade_code = new Array((DrugsOrders.length)-1);
		   trade_name = new Array((DrugsOrders.length)-1);
		}
		updateOROrderCatalog(Drugs.split(","));
				
		if(mode=="RecExternal")
			mode="copied_drugs";
		
		chkDuplicateDrugCode(Drugs,trade_code,trade_name,alldata,mode);
		parent.f_header.document.prescription_header_form.take_home_medication.disabled=true;
		parent.f_header.document.prescription_header_form.home_leave_yn_chk.disabled=true;
		if(parent.f_header.document.getElementById('tdPrescripionHdrDuration').style.visibility == 'visible'){
			parent.f_header.document.prescription_header_form.durn_value.disabled=true;
			parent.f_header.document.prescription_header_form.durn_desc.disabled=true;
		}
	}
	else{//else condtion added for IN070786
		if(called_from != "recn_button"){
		bean_id="@PrescriptionBean_1";
		bean_name="ePH.PrescriptionBean_1";
		var xmlStr ="<root><SEARCH ";
		xmlStr+= "patient_id  =\"" + patient_id + "\" " ;
		xmlStr+= "encounter_id =\"" + encounter_id + "\" " ;
		xmlStr+= "bean_id =\"" + bean_id + "\" " ;
		xmlStr+= "bean_name=\"" + bean_name + "\" " ;
		xmlStr +=" /></root>";
		
		 var temp_jsp="PrescriptionValidation.jsp?func_mode=GET_EXTERNAL_STATUS";//changed PrescriptionValidation_1.jsp to PrescriptionValidation.jsp
		 var xmlDoc = "" ;
		 var xmlHttp = new XMLHttpRequest() ;
		 xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");

		 xmlHttp.open("POST",temp_jsp,false);
		 xmlHttp.send(xmlDoc);
		 responseText=xmlHttp.responseText ;   

		 eval(responseText);
	}
		//medicationReconciliation();
	}
} 
//added for IN070786 start
function recallmedication(obj){
	if (obj !="Y"){
		 alert("Either No External Drug check box need to check or copy any drug"); 
		medicationReconciliation();
	}
	
}
//added for IN070786 end
// Added for MMS-KH-CRF-0016 - End
//added for SKR-SCF-1270 - start
function validatePRNRemarks(frmObj,patient_id,encounter_id){
  
	var bean_id = frmObj.bean_id.value;
	var bean_name = frmObj.bean_name.value;
	
	var xmlStr	="<root><SEARCH " ;
	var xmlDoc="";
	var xmlHttp = new XMLHttpRequest();
	xmlStr		+="bean_id"+"=\""+ bean_id+"\" " ;
	xmlStr		+="bean_name"+"=\""+ bean_name+"\" " ;
	xmlStr += "patient_id=\""+patient_id +"\" " ;
	xmlStr += "encounter_id=\""+encounter_id +"\" " ;
	xmlStr +=" /></root>" ;
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open( "POST", "PrescriptionValidation.jsp?func_mode=validatePRNRemarks", false ) ;
	xmlHttp.send( xmlDoc ) ;	
	responseText=xmlHttp.responseText ;
	eval(responseText);
}

function displayPRNAlert(){

		var headerFrame	=   parent.parent.f_header;
		if(headerFrame.document.prescription_header_form.man_rem_on_prn_freq_yn != undefined && headerFrame.document.prescription_header_form.man_rem_on_prn_freq_yn.value == 'Y'){
			prn_remark_flag = false;
			return false;
		}
	}
 //added for SKR-SCF-1270 - end	
//MMS-KH-CRF-0029[IN070606] -start
function callDrugInteractionForDrug(){

		document.FormDrugInteractionsDetail.drug_interations.style='display';
		document.FormDrugInteractionsDetail.drug_interations.style.visibility="visible";
		document.FormDrugInteractionsDetail.food_interations.style.display="none";
		document.FormDrugInteractionsDetail.lab_interations.style.display="none";
}
 function tab_click1(id){
	selectTab(id);
	callDrugInteractionForDrug()
		
}
 function tab_click2(id){
	selectTab(id);
	callDrugInteractionForFood();
}
		 
 function tab_click3(id){
	selectTab(id);
	callDrugInteractionForLab();
}

function tab_click4(id){//Added for MMS-MD-CRF-0229
	selectTab(id);
	callDrugInteractionForDisease();
}

function selectTab(tabObj){
	if(prevTabObj!=null){
	   eval("document."+prevTabObj).className="tabA"
	   eval("document."+prevTabObj+"span").className="tabAspan"
	}
	eval("document."+tabObj).className="tabClicked"
	eval("document."+tabObj+"span").className="tabSpanclicked"
	prevTabObj=tabObj
}
		
function callDrugInteractionForFood(){
	document.FormDrugInteractionsDetail.food_interations.style='display';
	document.FormDrugInteractionsDetail.food_interations.style.visibility="visible";
	document.FormDrugInteractionsDetail.drug_interations.style.display="none";
	document.FormDrugInteractionsDetail.lab_interations.style.display="none";
	document.FormDrugInteractionsDetail.disease_interations.style.display="none";//Added for MMS-DM-CRF-0229
}
function callDrugInteractionForLab(){
	//console.log(document.FormDrugInteractionsDetail);
	//console.log(document.FormDrugInteractionsDetail.lab_interations);
	
	document.getElementById('lab_interations').style='display';
	document.getElementById('lab_interations').style.visibility="visible";
	document.getElementById('food_interations').style.display="none";
	document.getElementById('drug_interations').style.display="none";
	document.getElementById('disease_interations').style.display="none";//Added for MMS-DM-CRF-0229
}
function callDrugInteractionForDisease(){//Adding start for MMS-DM-CRF-0229
	document.FormDrugInteractionsDetail.disease_interations.style='display';
	document.FormDrugInteractionsDetail.disease_interations.style.visibility="visible";
	document.FormDrugInteractionsDetail.food_interations.style.display="none";
	document.FormDrugInteractionsDetail.drug_interations.style.display="none";
	document.FormDrugInteractionsDetail.lab_interations.style.display="none";
}//Adding end for MMS
//MMS-KH-CRF-0029[IN070606] -end		
//GHl-CRF-0618 - start
function closeRemarksWindowForDrug(){
	window.returnValue = true;
	window.close();
}

function saveNonPreRemForDrug(drug_code,patient_id,encounter_id,bean_id,bean_name){

	var bean_id				= "@PrescriptionBean_1"+patient_id+encounter_id;
	
	var bean_name			= "ePH.PrescriptionBean_1";

	var formobj = document.formNonPreferenceRemarks;
	var remarks_code = formobj.non_prefered_item_remarks.value;

	var xmlStr	="<root><SEARCH " ;
	var xmlDoc="";
	var xmlHttp = new XMLHttpRequest();
	xmlStr		+="bean_id"+"=\""+ bean_id+"\" " ;
	xmlStr		+="bean_name"+"=\""+ bean_name+"\" " ;
	xmlStr += "patient_id=\""+patient_id +"\" " ;
	xmlStr += "encounter_id=\""+encounter_id +"\" " ;
	xmlStr += "drug_code=\""+drug_code +"\" " ;
	xmlStr += "remarks_code=\""+remarks_code +"\" " ;
	
	xmlStr +=" /></root>" ;
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST","PrescriptionValidation.jsp?func_mode=nonPreferenceRemarks&bean_id="+ bean_id + "&bean_name="+bean_name, false ) ;
	xmlHttp.send( xmlDoc ) ;
	eval(xmlHttp.responseText);

} 

//GHl-CRF-0618 - end
//Added for IN:072715 START
function checkOverrideRemarks(reason_code,trn_type,frmObj,frmObj1,field){
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
		xmlStr+= "reason_code  =\"" + reason_code + "\" " ;
		xmlStr+= "trn_type =\"" + trn_type + "\" " ;
		xmlStr+= "field =\"" + field + "\" " ;
		
		xmlStr+= "bean_id =\"" + bean_id + "\" " ;
		xmlStr+= "bean_name=\"" + bean_name + "\" " ;
		xmlStr +=" /></root>";
		var temp_jsp="PrescriptionValidation.jsp?func_mode=override_remarks";
		var xmlDoc = "" ;
		var xmlHttp = new XMLHttpRequest() ;
		
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open("POST",temp_jsp,false);
		xmlHttp.send(xmlDoc);
		
		responseText=xmlHttp.responseText ;
		eval(responseText);
	}
	
}
//Added for IN:072715 end
//Added for IN:073485 start
function checkMandRemarks(drug_code,srl_no,patient_id,encounter_id,frmObj){
	
		bean_id		=	frmObj.bean_id.value;
		bean_name	=	frmObj.bean_name.value;
		var xmlStr ="<root><SEARCH ";
		xmlStr+= "drug_code  =\"" + drug_code + "\" " ;
		xmlStr+= "srl_no =\"" + srl_no + "\" " ;
		xmlStr+= "patient_id =\"" + patient_id + "\" " ;
		xmlStr+= "encounter_id =\"" + encounter_id + "\" " ;
		
		xmlStr+= "bean_id =\"" + bean_id + "\" " ;
		xmlStr+= "bean_name=\"" + bean_name + "\" " ;
		xmlStr +=" /></root>";
		var temp_jsp="PrescriptionValidation.jsp?func_mode=override_mand_check";
		var xmlDoc = "" ;
		var xmlHttp = new XMLHttpRequest() ;
		
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open("POST",temp_jsp,false);
		xmlHttp.send(xmlDoc);
		
		responseText=xmlHttp.responseText ;
		eval(responseText);
	
	
}
//Added for IN:073485 end
//Added for IN:069886 start, Modified for IN:069886 start
function validateRefillEndDate(dateObj,start_date, locale,max_durn_for_refill_pres){
	var srl_no		=	document.refill_form.srl_no.value;
	var interval_value			=	document.refill_form.interval_value.value;
	var freq_durn_type	=	document.refill_form.freq_durn_type.value;
	var repeat_durn_type	=	document.refill_form.repeat_durn_type.value;
	
	var flag =true;
	if(dateObj.value!=""){
		if(validDate(dateObj.value, "DMYHM",locale )){
			var refill_start_date_tmp=document.refill_form.refill_start_date_tmp.value;
			var date_range_in_muliples=document.refill_form.date_range_in_muliples.value;
			if(isBefore(refill_start_date_tmp,dateObj.value, "DMYHM",locale)){
				var durn = daysBetween(start_date,dateObj.value,"DMYHM",locale);
				if(freq_durn_type==repeat_durn_type){
					flag=false;
				}
				if(repeat_durn_type=="D" || repeat_durn_type=="W" || repeat_durn_type=="L" || repeat_durn_type=="Y"){
					var refill_durn = daysBetween(refill_start_date_tmp,dateObj.value,"DMYHM",locale);
					if(flag){
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
				}
				else if(repeat_durn_type=="H"){
					var refill_durn = hoursBetween(refill_start_date_tmp,dateObj.value,"DMYHM",locale);
					if(flag){
							interval_value=1;
						}
				}
				else if(repeat_durn_type=="M"){
					var refill_durn = minutesBetween(refill_start_date_tmp,dateObj.value,"DMYHM",locale);
					if(flag){
							interval_value=1;
						}
				}
				//var refill_durn = daysBetween(refill_start_date_tmp,dateObj.value,"DMYHM",locale);
				var last_refill_durn_value = parseInt(refill_durn)/parseInt(interval_value);
				var last_refill_freq_chnage_durn_value = parseInt(last_refill_durn_value)*parseInt(date_range_in_muliples);
				if(parseInt(durn)>parseInt(max_durn_for_refill_pres)){
					alert(getMessage("PH_MAX_REFILL_DURN", "PH"));
					document.refill_form.endDateImg.click();
					return false;
				}
				else if(parseInt(refill_durn)==0){
					alert(getMessage("END_DATE_GTR_THAN_START_DATE", "PH"));
					document.refill_form.endDateImg.click();
					return false;
				}
				else if((parseInt(refill_durn)%parseInt(interval_value))!=0){  //modified for IN:069886
					var err_msg = getMessage("DURATION_VALUE_MULTIPLE","PH");
					err_msg = err_msg.replace('$ or ',"");
					err_msg = err_msg.replace('#', interval_value); //modified for IN:069886
					err_msg = err_msg.replace('%', interval_value); //modified for IN:069886
					alert(err_msg);
					document.refill_form.endDateImg.click();
					return false;
				}
				else{
					document.refill_form.refill_end_date.value=dateObj.value;
					//modified for IN:069886--START
					document.refill_form.last_refill_durn_value.value=last_refill_durn_value;
					document.refill_form.last_refill_freq_chnage_durn_value.value=last_refill_freq_chnage_durn_value;
					//modified for IN:069886--END
				}
			}
			else{
				alert(getMessage("END_DATE_GTR_THAN_START_DATE", "PH"));
				document.refill_form.endDateImg.click();
				return false;
			}
		} //Added for IN:069886
		else{
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
//Added for IN:069886 end,Modified for IN:069886 end
function fieldValidation1(xmlStr,source){
	var xmlDoc = "" ;
    var xmlHttp = new XMLHttpRequest() ;
    xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
    xmlHttp.open("POST","PrescriptionValidation.jsp?func_mode="+source,false);
    xmlHttp.send(xmlDoc);
    responseText=xmlHttp.responseText ;
	eval(responseText);
    return true;
}
//Added for IN:069886 start
function saveLastRefill(){
	var refill_end_date=parent.refill_detail.refill_form.refill_end_date.value;
	var srl_no=parent.refill_detail.refill_form.srl_no.value;
	var end_date		=	parent.refill_detail.refill_form.end_date.value;
	var durn_value		=	parent.refill_detail.refill_form.durn_value.value;
	var repeat_durn_type		=	parent.refill_detail.refill_form.repeat_durn_type.value;
	var refill_no		=	parent.refill_detail.refill_form.no_refill.value;
	var last_refill_durn_value		=	parent.refill_detail.refill_form.last_refill_durn_value.value;
	var last_refill_freq_chnage_durn_value		=	parent.refill_detail.refill_form.last_refill_freq_chnage_durn_value.value;
	var fldString=" last_refill_end_date=\""+ refill_end_date + "\" ";
	fldString += " srl_no=\""+ srl_no + "\" ";
	
	fldString += " end_date=\""+ end_date + "\" ";
	fldString += " durn_value=\""+ durn_value + "\" ";
	fldString += " repeat_durn_type=\""+ repeat_durn_type + "\" ";
	fldString += " refill_no=\""+ refill_no + "\" ";
	
	fldString += " last_refill_durn_value=\""+ last_refill_durn_value + "\" ";
	fldString += " last_refill_freq_chnage_durn_value=\""+ last_refill_freq_chnage_durn_value + "\" ";
	var formobj=parent.refill_detail.document.refill_form;
	var xmlStr=formXMLString(formobj,fldString);
	fieldValidation1(xmlStr,"assinLastRefillDate");
}
//Added for IN:069886 end

//Added for NMC-JD-CRF-0063
//Added for NMC-JD-CRF-0063
function assignValueOP(obj){
	
	if(obj.checked==true){
		obj.value="Y";
		document.prescription_header_form.take_home_medication_ckk_val.value="Y";
	}		
	else{
		obj.value="N";
		document.prescription_header_form.take_home_medication_ckk_val.value="N";
	}		
	checkOpDischargeMed(obj);
}
//Added for IN:069886 start
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
function removeRefill(){
	var srl_no				=	document.prescription_detail_form.srl_no.value;
	var fldString=" srl_no=\""+ srl_no + "\" ";
	document.prescription_detail_form.no_refill.value="0";
	document.prescription_detail_form.refill_start_date.value="";
	document.prescription_detail_form.refill_end_date.value="";
	var formobj=document.prescription_detail_form;
	var xmlStr=formXMLString(formobj,fldString);
	fieldValidation1(xmlStr,"removerefill");
}
function saveRefill(){
	var change_last_refill_end_date_appl_yn		=	parent.refill_detail.refill_form.change_last_refill_end_date_appl_yn.value;
	if(change_last_refill_end_date_appl_yn=="N"){
	var srl_no=parent.refill_detail.refill_form.srl_no.value;
	var end_date		=	parent.refill_detail.refill_form.end_date.value;
	var durn_value		=	parent.refill_detail.refill_form.durn_value.value;
	var repeat_durn_type		=	parent.refill_detail.refill_form.repeat_durn_type.value;
	var refill_no		=	parent.refill_detail.refill_form.no_refill.value;
	var fldString = " srl_no=\""+ srl_no + "\" ";
	fldString += " end_date=\""+ end_date + "\" "; //Modified for MO-CRF-20151(5/3/2021)
	fldString += " durn_value=\""+ durn_value + "\" ";
	fldString += " repeat_durn_type=\""+ repeat_durn_type + "\" ";
	fldString += " refill_no=\""+ refill_no + "\" ";
	
	var formobj=parent.refill_detail.document.refill_form;
	var xmlStr=formXMLString(formobj,fldString);
	fieldValidation1(xmlStr,"saveRefill");
	}
	else{
		saveLastRefill();
	}
}
function fieldValidationOverride(xmlStr,source){//ADDED FOR AAKH-CRF-0140
	var xmlDoc = "" ;
    var xmlHttp = new XMLHttpRequest() ;
    xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
    xmlHttp.open("POST","PrescriptionValidation_3.jsp?func_mode="+source,false);
    xmlHttp.send(xmlDoc);
    responseText=xmlHttp.responseText ;
	eval(responseText);
    return true;
}
//Added for IN:069886 end

function checkQuotaLimit(quotaLimitValue,setLimitByType,quotaCurrValue){
//alert("checkQuotaLimit")
	//var formobj        =parent.f_detail.document.prescription_detail_form;
	if(parent.parent.f_detail!=undefined)
		var formobj =parent.parent.f_detail.document.prescription_detail_form;
	else if(parent.f_detail!=undefined)
		var formobj =parent.f_detail.document.prescription_detail_form
	var drug_code      =formobj.drug_code.value;
	var srl_no		   =formobj.srl_no.value;
	var repeat_value = formobj.repeat_value.value;
	var dosage_type = formobj.dosage_type.value;
	var freq_nature = formobj.freq_nature.value;
	var durn_value		=	formobj.durn_value.value;
	var pres_base_uom				= formobj.pres_base_uom.value;
	var qty_desc				= formobj.qty_desc.value;
	var patient_id				= formobj.patient_id.value;
	var specialityCd				= formobj.speciality_code.value;
	var qty_value       = formobj.qty_value.value;
	var absol_qty = "";
	var presBean_id=formobj.presBean_id.value;
		var presBean_name=formobj.presBean_name.value;
	if(formobj.absol_qty!=undefined){
		absol_qty = formobj.absol_qty.value; //added for IN26267 --02/02/2011-- priya
	}
	var fldString=" srl_no=\""+ srl_no + "\" ";
	fldString += " drug_code=\""+ drug_code + "\" ";
	fldString += " repeat_value=\""+ repeat_value + "\" ";
	fldString += " dosage_type=\""+ dosage_type + "\" ";
	fldString += " freq_nature=\""+ freq_nature + "\" ";
	fldString += " durn_value=\""+ durn_value + "\" ";
	fldString += " pres_base_uom=\""+ pres_base_uom + "\" ";
	fldString += " qty_desc=\""+ qty_desc + "\" ";
	fldString += " absol_qty=\""+ absol_qty + "\" ";
	fldString += " quotaLimitValue=\""+ quotaLimitValue + "\" ";
	fldString += " setLimitByType=\""+ setLimitByType + "\" ";
	fldString += " quotaCurrValue=\""+ quotaCurrValue + "\" ";
	fldString += " patient_id=\""+ patient_id + "\" ";
	fldString += " spec_code=\""+ specialityCd + "\" ";
	fldString  +=" quota_limit_access_yn=\""+ formobj.quota_limit_access_yn.value + "\" ";
	fldString  +=" qty_value=\""+ formobj.qty_value.value + "\" ";
	//fldString += " presBean_id=\""+ presBean_id + "\" ";
	//fldString += " presBean_name=\""+ presBean_name + "\" ";
	var xmlStr=formXMLString(formobj,fldString);
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest() ;
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST","PrescriptionValidation.jsp?func_mode=chkQuotaLimit",false);
	xmlHttp.send(xmlDoc);
	responseText=xmlHttp.responseText ;
	return (eval(responseText));
}

function alertExccedQuotaLimit(){
	var Okay = confirm(getMessage("ORDER_EXCEEDS_QUOTA_LIMIT","PH"));
	if(parent.parent.f_detail!=undefined)
		var formObj =parent.parent.f_detail.document.prescription_detail_form;
	else if(parent.f_detail!=undefined)
		var formObj =parent.f_detail.document.prescription_detail_form
		if(!Okay){
			formObj.quota_limit_exceded_yn.value='N';
			return  "N";
		  }
		else{
			formObj.quota_limit_exceded_yn.value='Y';
			return "Y";
		}
}

