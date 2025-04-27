/*
--------------------------------------------------------------------------------------------------------------
Date			Edit History		Name		Rev.Date		Rev.Name				Description
--------------------------------------------------------------------------------------------------------------
05/09/2019      IN070451		   B Haribabu   06/09/2019     Manickam                 ML-MMOH-CRF-1408
24/10/2019		INO71514			Shazana												SKR-SCF-1276
04/06/2020      IN072753            Prabha											   NMC-JD-CRF-0046
17/06/2020      IN072725			Prabha											   SKR-SCF-1329
23/07/2020		IN073425			Prabha											   SKR-SCF-1392
24/08/2020      IN073486		   B Haribabu                                           PH-MMS-IV with Addictive-Amend Order
06/11/2020      IN:069887              Haribabu                 Manickavasagam J            MO-CRF-20152
17/11/2020      IN7859              Prabha      17/11/2020     Manickavasagam J        SKR-SCF-1473
4/12/2020		6041				Shazana						Manickam				NMC-JD-CRF-0063				
06/01/2021		TFS-7345           Prabha      06/01/2020	  Manickavasagam J         MMS-DM-CRF-0177
1/3/2021		15129				Shazana						Manickam				NMC-JD-CRF-0063 		
25-05-2022       AAKH-CRF-0140                     PRATHYUSHA
8-06-2023       42586       srinivasa N T  08-08-2023  Ramesh Goli  SKR-SCF-1728

--------------------------------------------------------------------------------------------------------------
*/ 
var function_id	= "IV_PRESCRIPTION";
var result		= false;
var narcotic_yn		= "";
var message		= "";
var flag		= "";
var print_ord_sht_rule_ind="";//print_ord_sht_rule_ind Added for Bru-HIMS-CRF-393_1.0
var flag1       =false;
var pres_vals	=	new Array();
var i			=	0;
var formatId	=	"";
var errorFound = false;  
//code added on 5/5/2004
/*function setIVType(){
	ivtype = formIVPrescriptionOptions.type.value;
	var bean_id				= formIVPrescriptionOptions.bean_id.value;
	var bean_name			= formIVPrescriptionOptions.bean_name.value;
	var qryString			= bean_id+"&bean_name="+bean_name+"&validate=IVTYPEDETAILS&ivtype="+ivtype;
		
		submitXML(qryString, "");
}*/

function loadIVPresDetails(frmObj,Objval,patient_id,encounter_id){

	var patient_class	= frmObj.patient_class.value;

	var start_date	= frmObj.start_date.value;
	var iv_option  =  frmObj.iv_option.value;
	var ivtype= Objval;
	var bean_id				= frmObj.bean_id.value;
	var bean_name			= frmObj.bean_name.value;
	var qryString			= bean_id+"&bean_name="+bean_name+"&validate=IVTYPEDETAILS&ivtype="+ivtype;
	submitXML(qryString, "");
}

/*function searchIVFluid(frmObj,searchBasedOn, obj,rec_no) {
	var frmObj			= document.formIVPrescriptionDetails;
	var header_form		= parent.parent.parent.f_header.document.prescription_header_form;
    var patient_class	= frmObj.patient_class.value;
	var discharge_yn	= header_form.take_home_medication.value;
	var priority		= header_form.priority.value;
	var source_code     = header_form.source_code.value;
	var source_type     = header_form.source_type.value;
	var encounter_id	= header_form.encounter_id.value;
	var patient_id		= header_form.patient_id.value;
	var date_of_birth			= header_form.date_of_birth.value;
	var gender					= header_form.gender.value;
	var act_patient_class	= header_form.actual_patient_class.value;
	var drug_codes		= parent.parent.f_ivdetails.f_iv_drug_details.f_sub_ivdrugs.document.formIVPrescriptionDrugDetails.drug_codes.value;

	var iv_prep_yn="";
	if(frmObj.admixture.checked == true){
		iv_prep_yn = "2";
	}
	else{
		iv_prep_yn = "1";
	}

	var retArray		= DrugSearchForIV(searchBasedOn, obj, '', drug_codes, 'DrugSearchBean', '', '', act_patient_class,priority, 'F',"N",discharge_yn, source_type, source_code, patient_id, encounter_id,date_of_birth,gender, iv_prep_yn);
	if (retArray != null && retArray != "" ) {

		if (frmObj.name == "formIVPrescriptionDetails"){
		
			frmObj.fluid_code.value	= retArray[0];
			var drug_code			= retArray[0];
			frmObj.fluid_name.value = retArray[1];
			
			frmObj.form_code.value	= retArray[2];
			frmObj.route_code.value	= retArray[3];
			frmObj.base_uom.value	= retArray[4];
			var base_uom			= retArray[4];
			var trade_code			= retArray[5];
			var bean_id				= frmObj.bean_id.value;
			var bean_name			= frmObj.bean_name.value;

			var location_type			= parent.parent.parent.f_header.prescription_header_form.location_type.value;
			var location_code			= parent.parent.parent.f_header.prescription_header_form.location_code.value;

			var qryString			= bean_id+"&bean_name="+bean_name+"&validate=FLUIDDETAILS&drug_code="+drug_code+"&base_uom="+base_uom+"&trade_code="+trade_code+"&location_type="+location_type+"&location_code="+location_code+"&take_home_medication="+discharge_yn+"&priority="+priority+"&iv_prep_yn="+iv_prep_yn;
			
			submitXML(qryString, ""); 
		}			
	}
	
}
*/
function submitXML(qryString, xmlStr,eval_yn) {
//commented by Anbarasi
	//var xmlDoc	= new ActiveXObject("Microsoft.XMLDom");
	//var xmlHttp	= new ActiveXObject("Microsoft.XMLHTTP");
	var xmlDoc = ""; 
	var xmlHttp = new XMLHttpRequest();
	if (xmlStr != "")
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST", "IVPrescriptionValidate.jsp?bean_id="+qryString, false);
	xmlHttp.send(xmlDoc);
	responseText = xmlHttp.responseText;
	eval(responseText);
}

function setDose(recno,dose,uom){
	var frmObj				= document.formIVPrescriptionDetails;
	eval("frmObj.dose_"+recno).value	= dose;
	eval(document.getElementById('dose_uom_'+recno)).innerHTML= uom;
	eval("frmObj.qty_"+recno).value		= ((parseInt(dose))/1000)*(parseInt((frmObj.stock_value.value)));
}

function setStockDetails(mode, stock_value, stock_uom_code, stock_uom_desc, disp_uom_desc, fluid_stock_uom_desc) {//stock_uom_desc, amendmode, disp_uom_desc,
	var frmObj = document.formIVPrescriptionDetails;
	if(document.formIVPrescriptionDetails==null) 
		frmObj	=	parent.frames[1].formIVPrescriptionDetails;
	if (mode == 1 ){//&& amendmode != "amend"
		document.getElementById('stock_display').innerHTML	= "<b>"+stock_uom_desc+"</b>";
		if(parent.f_iv_admin.formIVPrescriptionAdminDetail != undefined )
			parent.f_iv_admin.formIVPrescriptionAdminDetail.infusion_uom_display.innerHTML = "<b>&nbsp;" + stock_uom_desc + " /</b> ";
		var iv_calc_infuse_by = parent.f_iv_admin.formIVPrescriptionAdminDetail.iv_calc_infuse_by.value //Added for SKR-CRF-0035 [IN:037727]  -Start
		if(iv_calc_infuse_by=='I'){
			frmObj.volumePerUnit.value				= stock_value;
			document.getElementById('volPerUnitUom_leg').innerText	= stock_uom_desc;
			parent.f_iv_admin.document.getElementById('ord_qty_uom').innerText	= decodeURIComponent(disp_uom_desc);//fluid_stock_uom_desc;
			parent.f_iv_admin.formIVPrescriptionAdminDetail.order_qty.value=Math.ceil(parseInt(frmObj.stock_value.value)/parseInt(stock_value));
			//frmObj.STOCK_VALUE.value				= stock_value;
		} //Added for SKR-CRF-0035 [IN:037727] -End
		else{
			frmObj.stock_value.value				= stock_value;		
			frmObj.STOCK_VALUE.value				= stock_value;
		}
		frmObj.BASE_VOLUME.value				= stock_value;
		frmObj.STOCK_UOM_CODE.value				= stock_uom_code;
		parent.f_iv_admin.formIVPrescriptionAdminDetail.INFUSION_UOM_DISPLAY.value = stock_uom_code ;
		parent.f_iv_admin.formIVPrescriptionAdminDetail.EQVL_UOM_CODE.value = stock_uom_code ;
	}
	else if (mode == 2) {
		alert(getMessage("PH_EQU_UOM_NOT_DEFINED","PH"));
	}
	if (mode == 3) {
		var frmObj;
		var admin_frmObj;
		if (parent.parent.f_iv_fluid != undefined){
			frmObj			=	parent.parent.f_iv_fluid.formIVPrescriptionDetails;
			admin_frmObj	=	parent.parent.f_iv_admin.formIVPrescriptionAdminDetail;
		}
		else{
			frmObj			=	parent.parent.parent.f_iv_fluid.formIVPrescriptionDetails;
			admin_frmObj	=	parent.parent.parent.f_iv_admin.formIVPrescriptionAdminDetail;
		}

		if(stock_uom_desc != "")	{	
			//console.log(parent.parent.parent.f_iv_fluid.formIVPrescriptionDetails);
			//console.log(parent.parent.f_iv_fluid.formIVPrescriptionDetails);
			parent.parent.f_iv_fluid.document.getElementById("stock_display").innerHTML	= "<b>"+stock_uom_desc+"</b>";
		}
		else{
			frmObj.document.getElementById("stock_display").innerHTML	= "<b>"+stock_uom_code+"</b>";
		}

		if(admin_frmObj != undefined)
			//admin_frmObj.infusion_uom_display.innerHTML = "<b>&nbsp;" + stock_uom_code + " /</b> ";
			//console.log(parent.parent.f_iv_admin.formIVPrescriptionAdminDetail);
		parent.parent.f_iv_admin.document.getElementById('infusion_uom_display').innerHTML = "<b>&nbsp;" + stock_uom_desc + " /</b> ";  // Changed for SKR-SCF-0089 [Incident No. 028819]

		frmObj.stock_value.value				= stock_value;		
		frmObj.STOCK_VALUE.value				= stock_value;
		frmObj.BASE_VOLUME.value				= stock_value;
		frmObj.STOCK_UOM_CODE.value				= stock_uom_code;
		admin_frmObj.INFUSION_UOM_DISPLAY.value = stock_uom_code ;
		admin_frmObj.EQVL_UOM_CODE.value = stock_uom_code ;
		var iv_calc_infuse_by = admin_frmObj.iv_calc_infuse_by.value //Added for SKR-CRF-0035 [IN:037727]  -Start
		if(iv_calc_infuse_by=='I'){
			frmObj.volumePerUnit.value				= stock_value;
			frmObj.document.getElementById('volPerUnitUom_leg').innerText	= frmObj.document.getElementById('stock_display').innerText;
			admin_frmObj.order_qty.value=1;
			admin_frmObj.document.getElementById('ord_qty_uom').innerText	= decodeURIComponent(disp_uom_desc);//fluid_stock_uom_desc;
		} //Added for SKR-CRF-0035 [IN:037727] -End
	}
	frmObj.volume_reference.value				= stock_value;//Added for AAKH-CRF-0094
}

function setInfuseOverValue(){
	var formAdmin = parent.f_iv_admin.document.formIVPrescriptionAdminDetail;
	var formPresc = parent.f_iv_fluid.document.formIVPrescriptionDetails;
	if(formAdmin.INFUSION_VALUE.value !="" && formPresc.STOCK_VALUE.value != ""){
		var volume		   = parseFloat(formPresc.STOCK_VALUE.value); //parseInt changed to parseFloat for SKR-SCF-0120 - IN029130 
		var infusion_value = formAdmin.INFUSION_VALUE.value;//Added for aakh-scf-0317
	//	var infusion_value = formAdmin.INFUSION_VALUE_WITHOUT_ROUND.value;//added for IN61608 
		var unit = 	formAdmin.lstInfusionRateDurnUnit.value;
		if(infusion_value!="" && parseFloat(infusion_value)!=0) {
			if(unit == "H"){
				infusion_value = parseFloat(volume) * 60/parseFloat(infusion_value);
				//infusion_value = infusion_value/60;
			}
			else{
				infusion_value = parseFloat(volume)/parseFloat(infusion_value);
			}
			infusion_value = infusion_value/60;
			infusion_value = Math.round(infusion_value*100)/100;
			HrsMinStr = getHrsMinStr(infusion_value,formAdmin.lstInfusionRateDurnUnit.value);
			formAdmin.infusion_over_insert_value.value = infusion_value;
			parent.f_iv_admin.document.getElementById('infusionOverStr').innerHTML	= HrsMinStr;
			hrs = HrsMinStr.substring(1,HrsMinStr.indexOf("H")-1);
			min = HrsMinStr.substring(HrsMinStr.indexOf("H")+4,HrsMinStr.indexOf("M")-1);
			formAdmin.INFUSION_PERIOD_VALUE.value = Math.floor(hrs);
			formAdmin.INFUSION_PERIOD_VALUE_MIN.value = Math.round(min);
			var iv_calc_infuse_by = formAdmin.iv_calc_infuse_by.value;
			if(iv_calc_infuse_by!='I'){//added for for  SKR-CRF-0035 [IN:037727] 
				if(parseFloat(infusion_value) > parseFloat(24*60) ){ 
					alert(getMessage("INFUSE_OVER_CANNOT_GREATER","PH"));
					formAdmin.INFUSION_PERIOD_VALUE.focus();
					return false;
				}
			}
			else if(parseFloat(infusion_value) > parseFloat(formAdmin.DURN_VALUE.value) && iv_calc_infuse_by!='I'){
				alert(getMessage("DURATION_CANNOT_LESSTHAN","PH"));
				formAdmin.INFUSION_PERIOD_VALUE.focus();
				return false;
			}
		}
		else{
		  if(formAdmin.INFUSION_VALUE.value!=undefined && (formAdmin.INFUSION_VALUE.value=="" || formAdmin.INFUSION_VALUE.value==0)) //If condition Added for AAKH-CRF-0094
			alert(getMessage("PRES_IV_INF_RATE_NOT_BLANK","PH"));
		}
		//formAdmin.INFUSION_PERIOD_VALUE.focus();
		//setInfuseRateValue("ADMIN"); //commented for SKR-SCF-1329-->already calling in TD 
	}
}           

/*function calInfuseOverValues(){
	var formAdmin = parent.f_iv_admin.document.formIVPrescriptionAdminDetail;
	var formPresc = parent.f_iv_fluid.document.formIVPrescriptionDetails;
	var volume		   = parseInt(formPresc.STOCK_VALUE.value);
	var infusionRatevalue = parseFloat(formAdmin.INFUSION_VALUE.value);

	if(infusionRatevalue > volume){
		alert(getMessage("INFUSION_RATE_CANNOT_GREATER","PH"));
		formAdmin.INFUSION_VALUE.focus();
		return false;
	}
	else{
		if(formAdmin.lstInfusionRateDurnUnit == "H"){
			infusionRatevalue = infusionRatevalue / 60 ;
		}
		infuseOverValue = volume / infusionRatevalue ;			

		if(formAdmin.InfusionOverDurnUnit.value == "H")
			infuseOverValue = infuseOverValue * 60;
		infuseOverValue = Math.round(original*100)/100
		formAdmin.INFUSION_PERIOD_VALUE.value = infuseOverValue;
	}
}*/

function setInfuseRateValue(callFrom ){
	if (parent.f_iv_admin == undefined){
		admnFrmObj	= parent.parent.f_iv_admin.document.formIVPrescriptionAdminDetail;
		fluidFrmObj	= parent.parent.f_iv_fluid.document.formIVPrescriptionDetails;
	}
	else{
		admnFrmObj	= parent.f_iv_admin.document.formIVPrescriptionAdminDetail;
		fluidFrmObj = parent.f_iv_fluid.document.formIVPrescriptionDetails;
	}
	var volume						= fluidFrmObj.STOCK_VALUE.value;
	var infusion_period_value		= admnFrmObj.INFUSION_PERIOD_VALUE.value==""?0:admnFrmObj.INFUSION_PERIOD_VALUE.value;
	var infusion_period_value_min	= admnFrmObj.INFUSION_PERIOD_VALUE_MIN.value==""?0:admnFrmObj.INFUSION_PERIOD_VALUE_MIN.value;

	infusion_period_value_min = parseFloat(infusion_period_value_min);
	var InfuseOverInMin = getInfuseOverInMin(infusion_period_value,infusion_period_value_min); 
	var InfuseOverInHr = parseFloat(InfuseOverInMin/60); 
	InfuseOverInHr =Math.round(InfuseOverInHr*100)/100;
	if(volume == "" || volume ==0){
		alert(getMessage("FLD_VOL_CANT_BLNK_ZERO","PH"));
		fluidFrmObj.stock_value.focus();
		return false;
	}
	else if (InfuseOverInMin == 0){
		alert(getMessage("INFS_OVR_CANT_BLANK_ZERO","PH"));
		//admnFrmObj.INFUSION_PERIOD_VALUE.focus();
		return false;
	}
	else{
		if(admnFrmObj.lstInfusionRateDurnUnit.value == "H")
		{
    		var infusion_value = (volume)*60/(InfuseOverInMin);//added for SCF-7847 	//var infusion_value = (volume)/(InfuseOverInHr); //commented for SCF-7847
		}
		else
			var infusion_value = (volume)/(InfuseOverInMin);
		admnFrmObj.INFUSION_VALUE_WITHOUT_ROUND.value = infusion_value;//added for IN61608
		admnFrmObj.infusion_over_insert_value.value = InfuseOverInHr;
		infusion_value = Math.round(infusion_value*100)/100;
		admnFrmObj.INFUSION_VALUE.value = infusion_value;
		var str = getHrsMinStr(InfuseOverInHr,admnFrmObj.lstInfusionRateDurnUnit.value);
		
		
		parent.parent.f_iv_admin.document.getElementById("infusionOverStr").innerHTML	= str;
	}
	if(admnFrmObj.iv_calc_infuse_by.value=='I'){ //Added for SKR-CRF-0035 [IN:037727] -Start
		var bean_id    = admnFrmObj.BEAN_ID.value;
		var bean_name  = admnFrmObj.BEAN_NAME.value;
		var start_date = admnFrmObj.START_DATE.value;
		var durnHrs =admnFrmObj.INFUSION_PERIOD_VALUE.value;
		var durnMins =admnFrmObj.INFUSION_PERIOD_VALUE_MIN.value;
		if(trimString(durnHrs)=="")
			durnHrs = '0';
		if(trimString(durnMins)=="")
			durnMins = '0';
		var durn_unit = "M";
		var DURN_VALUE =  (parseInt(durnHrs)*60)+parseInt(durnMins);
		var mode ='';
		if(callFrom != 'ADMIN')
			mode='IV_CALC';
		if(callFrom=='LOAD')
			mode='IV_CALC_LOAD';
		var qryString	= bean_id+"&bean_name="+bean_name+"&validate=POPULATEENDDATEADMIN&start_date="+start_date+"&durn_value="+DURN_VALUE+"&durn_unit="+durn_unit+"&mode="+mode;
		submitXML(qryString, "");
	}//Added for SKR-CRF-0035 [IN:037727] -End
}

function setInfusion_uom(){
	//var stock_uom_code = parent.f_iv_fluid.formIVPrescriptionDetails.stock_uom_desc.value //commented for for SKR-SCF-0120 - IN029130
	var stock_uom_code = parent.f_iv_fluid.document.getElementById('stock_display').innerText //added for for SKR-SCF-0120 - IN029130
	document.getElementById("infusion_uom_display").value = "<b>&nbsp;" + stock_uom_code + " /</b> ";
}

function setVolumeDetails(mode, stock_value, stock_uom_code, stock_uom_desc,recno) {
	var frmObj = document.formIVPrescriptionAdditives;
	if (mode == 1) {
		if (recno == 1){
			document.getElementById('stock_display1').innerHTML	= "<b>"+stock_value + " " +stock_uom_code+"</b>";
			document.getElementById('uom_display1').innerHTML	= "<b> " +stock_uom_code+"/Hr</b>";
			frmObj.stock_value1.value				= stock_value;		
			frmObj.stock_uom_code1.value				= stock_uom_code;
			frmObj.INF_RATE_UOM1.value				= stock_uom_code;
		}
		else if (recno == 2){			
			document.getElementById('stock_display2').innerHTML	= "<b>"+stock_value + " " +stock_uom_code+"</b>";
			document.getElementById('uom_display2').innerHTML	= "<b> " +stock_uom_code+"/Hr</b>";
			frmObj.stock_value2.value				= stock_value;
			frmObj.stock_uom_code2.value				= stock_uom_code;
			frmObj.INF_RATE_UOM2.value				= stock_uom_code;
		}
		else if (recno == 3){			
			document.getElementById('stock_display3').innerHTML	= "<b>"+stock_value + " " +stock_uom_code+"</b>";
			document.getElementById('uom_display3').innerHTML	= "<b> " +stock_uom_code+"/Hr</b>";
			frmObj.stock_value3.value				= stock_value;
			frmObj.stock_uom_code3.value				= stock_uom_code;
			frmObj.INF_RATE_UOM3.value				= stock_uom_code;
		}
		else if (recno == 4){			
			document.getElementById('stock_display4').innerHTML	= "<b>"+stock_value + " " +stock_uom_code+"</b>";
			document.getElementById('uom_display4').innerHTML	= "<b> " +stock_uom_code+"/Hr</b>";
			frmObj.stock_value4.value				= stock_value;
			frmObj.stock_uom_code4.value			= stock_uom_code;
			frmObj.INF_RATE_UOM4.value				= stock_uom_code;
		}
	}
	else if (mode == 2) {
		alert(getMessage("PH_EQU_UOM_NOT_DEFINED","PH"));
	}
}

function checkFlds( fields, names) {
	var errors = "" ;
	for( var i=0; i<fields.length; i++ ) {
		if(trimCheck(fields[i].value)) {
			fields[i].value = trimString(fields[i].value);
		}
		else	errors = errors + "APP-000001 " + names[i] + " cannot be blank..." + "\n" ;
	}
	if ( errors.length != 0 ) {
		alert(errors) ;
		return false ;
	}
	return true ;
}



function checkHr(num,HrMi) {

	var iv_calc_infuse_by = document.formIVPrescriptionAdminDetail.iv_calc_infuse_by.value;
	var InfHr = document.formIVPrescriptionAdminDetail.INFUSION_PERIOD_VALUE.value;
	var InfMi = document.formIVPrescriptionAdminDetail.INFUSION_PERIOD_VALUE_MIN.value;
	if(InfHr == "")
		document.formIVPrescriptionAdminDetail.INFUSION_PERIOD_VALUE.value = "0";
	if(InfMi == "")
		document.formIVPrescriptionAdminDetail.INFUSION_PERIOD_VALUE_MIN.value = "0";
	var durn = document.formIVPrescriptionAdminDetail.DURN_VALUE.value;
	if(InfHr != null && InfHr != "")
		InfHr = parseFloat(InfHr);
	if(InfMi != null && InfMi != "")
		InfMi = parseFloat(InfMi);
	errorFound = document.formIVPrescriptionAdminDetail.errorFound.value;

	if(InfHr == 24)
		document.formIVPrescriptionAdminDetail.INFUSION_PERIOD_VALUE_MIN.value = "00";
	if(InfHr == 24 && InfMi > 0 && errorFound=="false" && iv_calc_infuse_by!='I'){
		alert(getMessage("INFUSE_OVER_CANNOT_GREATER","PH"));
		//document.formIVPrescriptionAdminDetail.INFUSION_PERIOD_VALUE_MIN.focus();
		num.focus();
		document.formIVPrescriptionAdminDetail.errorFound.value = true;
		return false;
	}
	else{
		document.formIVPrescriptionAdminDetail.errorFound.value = false;
	}

	if(HrMi == 'H' && errorFound=="false" && iv_calc_infuse_by!='I'){
		if(InfHr > 24){
			alert(getMessage("INFUSE_OVER_CANNOT_GREATER","PH"));
			document.formIVPrescriptionAdminDetail.errorFound.value = true;
			num.focus();
			return false;
		}
	}
	else{
		document.formIVPrescriptionAdminDetail.errorFound.value = false;
	}

	if(HrMi == 'M' && InfMi > 59 && errorFound=="false"){
		alert(getMessage("INVALID_TIME_MINUTE","PH"));
		num.focus();
		document.formIVPrescriptionAdminDetail.errorFound.value = true;
		return false;
	}
	else{
		document.formIVPrescriptionAdminDetail.errorFound.value = false;
	}
	if (InfMi == "")
		InfMi = 0;
	if (InfHr == ""){
		InfHr = 0;
	}
	InfHr = parseFloat(InfHr) * 60;
	durn = parseFloat(durn) * 60; //commented for  SKR-CRF-0035 [IN:037727] 
	var tot_inf = parseFloat(InfHr) + parseFloat(InfMi);
	if(iv_calc_infuse_by!='I'){ //added for for  SKR-CRF-0035 [IN:037727] 
		if(parseFloat(tot_inf) > parseFloat(24*60)  && errorFound=="false")
			alert(getMessage("INFUSE_OVER_CANNOT_GREATER","PH"));
	}
	else if(parseFloat(tot_inf) > parseFloat(durn)  && errorFound=="false" && iv_calc_infuse_by!='I'){
			alert(getMessage("DURATION_CANNOT_LESSTHAN","PH"));
		//document.formIVPrescriptionAdminDetail.INFUSION_PERIOD_VALUE.focus();
	}
	else{
		document.formIVPrescriptionAdminDetail.errorFound.value = false;
	}
}      

function chkDuration(obj, mode) {	

if(parseFloat(obj.value) > 24  )   //uncommented for SKR-SCF-1392
		alert(getMessage("IV_DURATION_CANNOT_GREATER","PH"));
	else{
		if(document.formIVPrescriptionAdminDetail != undefined)
			var frmObj		= document.formIVPrescriptionAdminDetail;
		else
			var frmObj		= parent.f_detail.f_iv_admin.document.formIVPrescriptionAdminDetail;
		
		var lstInfusionRateDurnUnit = frmObj.lstInfusionRateDurnUnit.value;
		var total_hr = frmObj.DURN_VALUE.value;

		var InfHr = frmObj.INFUSION_PERIOD_VALUE.value;
		var InfMi = frmObj.INFUSION_PERIOD_VALUE_MIN.value;
		var durn = frmObj.DURN_VALUE.value;
		
		InfMi == ""?"0":InfMi;
		InfHr == ""?"0":InfHr;
		InfHr = parseFloat(InfHr) * 60;
		durn = parseFloat(total_hr) * 60;
		var tot_inf = parseFloat(InfHr) + parseFloat(InfMi);
		var durn_value;
		if(parseFloat(durn) < parseInt(tot_inf) && !errorFound){
			alert(getMessage("DURATION_CANNOT_LESSTHAN","PH"));
			obj.focus();
			errorFound = true;
		}
		else{
			errorFound = false;
			var fields  = new Array() ;
			var names   = new Array() ;
			fields[0]	= frmObj.START_DATE;
			names[0]	= "Start Date";
			if(checkFlds( fields, names)){
				if (mode == undefined)
					mode = "";
			/*	if (mode == "1")
					frmObj		= document.formIVPrescriptionAdminDetail;
				else if(mode == "2")
					frmObj		= document.formIVPrescriptionAdminDetail;*/
				if (obj.value != "") {
					var cont_flag	= true;
					durn_value		= obj.value;
				}
			}
		}
	}

	if (cont_flag) {
		var bean_id		= frmObj.BEAN_ID.value;
		var bean_name	= frmObj.BEAN_NAME.value;
		var start_date	= frmObj.START_DATE.value;
		var durn_unit	= "H";
		var iv_calc_infuse_by = frmObj.iv_calc_infuse_by.value; //Added for SKR-CRF-0035 [IN:037727] -Start
		if(iv_calc_infuse_by == 'I'){
			var durnHrs = eval("frmObj.INFUSION_PERIOD_VALUE").value;
			var durnMins = eval("frmObj.INFUSION_PERIOD_VALUE_MIN").value;
			if(trimString(durnHrs)=="")
				durnHrs = '0';
			if(trimString(durnMins)=="")
				durnMins = '0';
			durn_unit = "M";
			durn_value =  (parseInt(durnHrs)*60)+parseInt(durnMins)
		} //Added for SKR-CRF-0035 [IN:037727] -End
		var qryString	= bean_id+"&bean_name="+bean_name+"&validate=POPULATEENDDATE&start_date="+start_date+"&durn_value="+durn_value+"&durn_unit="+durn_unit+"&mode="+mode;
		submitXML(qryString, "");		
	}
	else {
		if(frmObj != null)
			frmObj.END_DATE.value	= "";
	}
}

function setEndDate(end_date, obj) {
	//obj = eval(obj);     // commented for AAKH-CRF-0094
	//obj.value = end_date; // commented for AAKH-CRF-0094
	if(obj!="undefined"){ // if condition Added for AAKH-CRF-0094 - Start
	obj = eval(obj);
	obj.value = end_date;
  } // if condition Added for AAKH-CRF-0094 - End
}

function setInfuseOver(inf_over,rec_no, obj) {
	var val		=	inf_over.split("::");
	var infuse = val[0];
	obj = eval(obj);
	obj.value = infuse;
	chkDurationAD(obj,rec_no);
}

function resetInfuse(obj){
	
	var start_date_chk	= document.formIVPrescriptionAdminDetail.START_DATE.value;
    var locale			= parent.f_iv_fluid.document.formIVPrescriptionDetails.language_id.value;
	if(start_date_chk!=""){
		var back_date	= parent.f_iv_fluid.document.formIVPrescriptionDetails.back_date.value;
	    var future_date	= parent.f_iv_fluid.document.formIVPrescriptionDetails.future_date.value;
		if(validDate(start_date_chk, "DMYHM",locale )){
			if(future_date!=null && future_date!='null' && future_date!="0" ){
				if(!isBefore(start_date_chk,future_date, "DMYHM",locale)){
					alert(getMessage("PH_BACK_DATE", "PH"));
					obj.focus();
					return false;
				}
			}
			if(back_date!=null &&  back_date!='null' && back_date!="0"){
				if(!isAfter(start_date_chk,back_date, "DMYHM",locale)){
					alert(getMessage("PH_BACK_DATE", "PH"));
					obj.focus();
					return false;
				}
			}
		}
		else{
			alert(getMessage("INVALID_DATE_TIME", "PH"));
			document.formIVPrescriptionAdminDetail.START_DATE.focus();
			return false;
		}
	}
	else{
		alert(getMessage("PH_START_DATE", "PH"));
		document.formIVPrescriptionAdminDetail.Calendar.click();
		return false;
	}
	var durn_value = document.formIVPrescriptionAdminDetail.DURN_VALUE;
	document.formIVPrescriptionAdminDetail.END_DATE.value="";
	chkDuration(durn_value,'1');
}

function confirmAndProceed(obj, obj1,mode,iv_prep_default,order_set_code) {

	flag1=false;    
	if(parent.f_ivdetails.f_iv_fluid){ 
		if((parent.f_ivdetails.f_iv_fluid.document.formIVPrescriptionDetails)&&(parent.f_ivdetails.f_iv_admin.document.formIVPrescriptionAdminDetail)){
			if(parent.f_ivdetails.f_iv_fluid.document.formIVPrescriptionDetails.fluid.value=="") 
				flag1=true;
			else
				flag1=false;

			if(parent.f_ivdetails.f_iv_admin.document.formIVPrescriptionAdminDetail.START_DATE.value=="")
				flag1=true;
			else
				flag1=false;
		}
	}
	else if(parent.f_ivdetails.f_iv_pb_drug){         

		if(parent.f_ivdetails.f_iv_pb_drug.document.formIVPiggyBackDrugDetails.drug_name.value=="")
			flag1=true;
		else
			flag1=false;

		if(parent.f_ivdetails.f_iv_pb.document.formIVPiggyBackVehicle.vehicle.value=="")
			flag1=true;
		else
			flag1=false;

		if(parent.f_ivdetails.f_iv_pb_admin_dtls.document.formIVPrescriptionAdminDetail.START_DATE.value=="")
			flag1=true;
		else
			flag1=false; 
	}
	else{

		if(parent.f_ivdetails.document.formIVPrescriptionAdditives.FLUID_NAME1.value=="")
			flag1=true;
		else
			flag1=false;  
	}

	if(mode == "2") 
		flag1=true;
	if(flag1==false){
		if (confirm(getMessage("PH_RECOREDED_DATA_LOST","PH"))) 
			callClearAll(2,iv_prep_default,order_set_code);
	}
	else
		callClearAll(2,iv_prep_default,order_set_code);
}

async function searchIVDrugs(searchBasedOn, obj) {

	var frmObj				= document.formIVPrescriptionDrugDetails;
	var header_form			= parent.parent.parent.parent.f_header.document.prescription_header_form;
	var discharge_yn		= header_form.take_home_medication.value;
	var priority			= header_form.priority.value;
	var encounter_id		= header_form.encounter_id.value;
	var patient_id			= header_form.patient_id.value;
	var act_patient_class	= header_form.actual_patient_class.value;
	var source_code         = header_form.source_code.value;
	var source_type         = header_form.source_type.value;
	var date_of_birth		= header_form.date_of_birth.value;
	var gender				= header_form.gender.value;
	var resp_id				= header_form.resp_id.value;
	var pract_id				= header_form.pract_id.value;
	var weight			 = header_form.weight.value;//Added for IN:070451
        var bsa			 = header_form.bsa.value;//Added for IN:070451

//	var patient_class		= frmObj.patient_class.value;
	var patient_class		= header_form.patient_class.value;
	frmObj.patient_class.value = patient_class;

	var drug_codes			= frmObj.drug_codes.value;

	var iv_prep_yn="";
	if(parent.parent.f_iv_fluid.document.formIVPrescriptionDetails.admixture.checked == true)
		iv_prep_yn = "2";
	else
		iv_prep_yn = "1";

	var retArray = await DrugSearchForIV(searchBasedOn, obj, '', drug_codes, 'DrugSearchBean', '', '', act_patient_class,priority, 'D',"N",discharge_yn, source_type, source_code, patient_id, encounter_id,date_of_birth,gender,iv_prep_yn);
	var starting_date = parent.parent.parent.parent.f_header.document.prescription_header_form.ref_sys_date.value;
	/*	if(header_form.take_home_medication_op_chk!=undefined)
			header_form.take_home_medication_op_chk.disabled=true;//commented for NMC-JD-CRF-0063*/
	if(header_form.take_home_medication_op_chk!=undefined){//added for NMC-JD-CRF-0063
		if(retArray.length==0 || retArray==""){
			if(header_form.take_home_medication_op_chk.disabled==false){
				header_form.take_home_medication_op_chk.disabled=false;
			}
		}
		else{
				header_form.take_home_medication_op_chk.disabled=true;
		}
	}	//END
	var Drug_Codes	= new Array();
	var	Trade_Codes = new Array();
	var Trade_Names = new Array();
	var index		= 0;
	var disp_locn_code='';
	if (retArray != null && retArray != "") {
		var drugCodes = "";
			for(var i=0;i<retArray.length;){
				drugCodes+=	retArray[i];
				drugCodes += ",";
				Drug_Codes[index]=retArray[i++];
				Trade_Codes[index]=retArray[i++];
				Trade_Names[index++]=retArray[i++];
			}

		frmObj.drug_codes.value	= drugCodes;
		var bean_id				= frmObj.bean_id.value;
		var bean_name			= frmObj.bean_name.value;

		var location_type			= parent.parent.parent.parent.f_header.prescription_header_form.location_type.value;
		var location_code			= parent.parent.parent.parent.f_header.prescription_header_form.location_code.value;
		var xmlStr 				= "<root><SEARCH act_patient_class=\"" + act_patient_class + "\" /></root>";   // RUT-CRF-0062  Added actual patient class to get the Build MAR Rule
		var qryString			= bean_id+"&bean_name="+bean_name+"&validate=DRUGCODES&drugCodes="+drugCodes+"&starting_date="+starting_date+"&Trade_Codes="+Trade_Codes+"&Trade_Names="+Trade_Names+"&location_type="+location_type+"&location_code="+location_code+"&take_home_medication="+discharge_yn+"&priority="+priority+"&iv_prep_yn="+iv_prep_yn+"&selected_drug_codes="+drug_codes+"&resp_id="+resp_id+"&pract_id="+pract_id+"&weight="+weight+"&bsa="+bsa;//Modified for IN:070451 added weight,bsa
		submitXML(qryString, xmlStr);   // RUT-CRF-0062 
		disp_locn_code=getDispLocation(bean_id,bean_name);
		disp_locn_code=trimString(disp_locn_code);
	}
	obj.value = "";	
	parent.parent.parent.f_ivbutton.document.location.href=parent.parent.parent.f_ivbutton.document.location.href+"&disp_locn_code="+disp_locn_code;
}
function getDispLocation(bean_id,bean_name){
	//commented by Anbarasi
	//var xmlDoc	= new ActiveXObject("Microsoft.XMLDom");
	//var xmlHttp	= new ActiveXObject("Microsoft.XMLHTTP");
	var xmlDoc = ""; 
	var xmlHttp = new XMLHttpRequest();
	//xmlDoc.loadXML("<root><SEARCH /></root>");
	var xmlStr="<root><SEARCH /></root>";
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST", "IVPrescriptionValidate.jsp?bean_id="+bean_id+"&bean_name="+bean_name+"&validate=FINDDISPLOCATION", false);
	xmlHttp.send(xmlDoc);
	responseText = xmlHttp.responseText;
	return responseText;
	
}
function setOrdersetIVDrugs(drugCodes,bean_id,bean_name) {
	var qryString			= bean_id+"&bean_name="+bean_name+"&validate=DRUGCODES&drugCodes="+drugCodes+"&mode=5";
	submitXML(qryString, "");
}

function checkValidDrug(checkFor, objVal) {
	if (trimCheck(objVal) != "") {
		if (checkFor == "D")
			searchIVDrugs("D", document.formIVPrescriptionDrugDetails.DRUG_NAME);
		//else if (checkFor == "F")
			//searchIVFluid(formIVPrescriptionDetails,"D", document.formIVPrescriptionDetails.fluid_name);
	} 
/*	else {
		if (checkFor == "F") {
			var frmObj = document.formIVPrescriptionDetails;
			frmObj.fluid_code.value			= "";						
		}
	}*/
}

function changeScrDetails(objVal,frm) {
	if(frm == 'reset'){
		var frmObj		=  parent.f_sub_ivdrugs.document.formIVPrescriptionDrugDetails;
	}
	else{
		var frmObj		= document.formIVPrescriptionDrugDetails;
	}
    saved_dosage_type=frmObj.saved_dosage_type.value;
	if (objVal == "S") {
		if(frm == 'reset'){
			
			parent.f_sub_ivdrugs.document.getElementById('DOSAGE_LABEL').innerHTML = getLabel("Common.Strength.label", "Common")+"&nbsp";//"Strength&nbsp;";
		}else{
			document.getElementById('DOSAGE_LABEL').innerHTML = getLabel("Common.Strength.label", "Common")+"&nbsp";
		}
		var uom_code		 = frmObj.UOM_CODE.value;
		var uom_desc		 = frmObj.STRENGTH_UOM_DESC.value;
		var str_value		 = frmObj.strength_per_pres_uom.value; //replaced STR_VAL with strength_per_pres_uom  for IN23745 --14/09/2010-- priya 
		//var order_set_code	 = parent.parent.f_iv_fluid.document.formIVPrescriptionDetails.order_set_code.value;
		var orderSetStrength = frmObj.ORDERSET_STRENGTH.value;

		clearData(frmObj.STRENGTH_UOM, "2");
		addData(uom_code, uom_desc, frmObj.STRENGTH_UOM);
		frmObj.STRENGTH_UOM.disabled	= true;
		//frmObj.STRENGTH_VALUE.value		= str_value;
		
		if(frmObj.amend_yn.value != "Y" || saved_dosage_type != "S"){// if not yet confirmed then load the default strength value
			frmObj.STRENGTH_VALUE.value=frmObj.strength_per_pres_uom.value;
			frmObj.STR_VAL.value = frmObj.strength_per_pres_uom.value;
		}
		else{
			if(frmObj.STR_VAL.value != null && frmObj.STR_VAL.value != "null" && frmObj.STR_VAL.value >0)
				frmObj.STRENGTH_VALUE.value=frmObj.STR_VAL.value;
			else{
				frmObj.strength_value_wt_bsa.value=frmObj.strength_value_wt_bsa.value!=""?frmObj.strength_value_wt_bsa.value:"";
				frmObj.STR_VAL.value = frmObj.strength_value_wt_bsa.value;
			}
		}
	}
	else if (objVal == "Q") {
		if(frm == 'reset'){
			parent.f_sub_ivdrugs.document.getElementById('DOSAGE_LABEL').innerHTML = getLabel("ePH.Dose.label", "PH")+"&nbsp";//"Dose&nbsp;";
		}else{
			document.getElementById('DOSAGE_LABEL').innerHTML = getLabel("ePH.Dose.label", "PH")+"&nbsp";
		}
		var form_code						= frmObj.FORM_CODE.value;
		var drug_code						= frmObj.DRUG_CODE.value;
		frmObj.STRENGTH_VALUE.value		= frmObj.strength_per_value_pres_uom.value; //replaced PRES_QTY_VALUE with strength_per_value_pres_uom  for IN23745 --14/09/2010-- priya 
		//above one line is commented because while copy orders this code overwrites the existing value with pres_qty_value-Abdul-25/08/10.  // Comment removed  for IN23745 --14/09/2010-- priya
		//frmObj.STRENGTH_UOM.disabled		= false;
		if(frmObj.strength_per_value_pres_uom.value==null || frmObj.strength_per_value_pres_uom.value=="0") //Added for SKR-SCF-1473
			frmObj.STRENGTH_VALUE.value = frmObj.PRES_QTY_VALUE.value;
		var bean_id							= frmObj.bean_id.value;
		var bean_name						= frmObj.bean_name.value;
		var pres_base_uom					= frmObj.PRES_BASE_UOM.value;
		if(parent.parent.parent.parent.f_header!=undefined)
			f_header			 = parent.parent.parent.parent.f_header;
		else if(parent.parent.parent.parent.parent.f_header!=undefined)
			f_header			 = parent.parent.parent.parent.parent.f_header;
		else
			f_header			 = parent.parent.parent.f_header;

		var rx_qty_by_pres_base_uom_yn		= f_header.prescription_header_form.rx_qty_by_pres_base_uom_yn.value;
		var qryString						= bean_id+"&bean_name="+bean_name+"&validate=QUANTITY&form_code="+form_code+"&drug_code="+drug_code+"&frmObj="+frmObj+"&pres_base_uom="+pres_base_uom+"&rx_qty_by_pres_base_uom_yn="+rx_qty_by_pres_base_uom_yn;
		submitXML(qryString, "");
		if(rx_qty_by_pres_base_uom_yn=="Y")
			frmObj.STRENGTH_UOM.disabled=true;
		else
			frmObj.STRENGTH_UOM.disabled=false;
	}
	if(frmObj.recomm_yn.value=="Y") {
		var dosage_std	=	frmObj.dosage_std.value;
		var recomm_dosage_by	=	frmObj.recomm_dosage_by.value;
		var dosage_by	=	frmObj.DOSAGE.value;
		if(recomm_dosage_by == dosage_by){
			frmObj.rec_legend.innerHTML = "<font class='HYPERLINK' onmouseover='changeCursor(this);'>"+getLabel("ePH.Recom.Dose.label","PH")+'&nbsp;</font>';
		}
		else
			frmObj.querySelectorAll('#rec_legend').innerHTML = getLabel("ePH.Recom.Dose.label","PH")+'&nbsp;';
	}
	setDrugDosageDetails(frm);
}

// to disable or enable dose uom based on facility parameter and dosage by
function DisableEnableDoseUOM(){
	if(parent.parent.parent.parent.f_header!=undefined)
		f_header			 = parent.parent.parent.parent.f_header;
	else if(parent.parent.parent.parent.parent.f_header!=undefined)
		f_header			 = parent.parent.parent.parent.parent.f_header;
	else
		f_header			 = parent.parent.parent.f_header;
	
	var rx_qty_by_pres_base_uom_yn		= f_header.prescription_header_form.rx_qty_by_pres_base_uom_yn.value;
	if(document.formIVPrescriptionDrugDetails == undefined){
		var frmObj		=  parent.f_sub_ivdrugs.document.formIVPrescriptionDrugDetails;
	}
	else{
		var frmObj		= document.formIVPrescriptionDrugDetails;
	}

	if(rx_qty_by_pres_base_uom_yn=="Y")
		frmObj.STRENGTH_UOM.disabled=true;
	else
		frmObj.STRENGTH_UOM.disabled=false;
}

function setDrugDosageDetails(frm){
	if(frm == "reset"){
		formObj =  parent.f_sub_ivdrugs.document.formIVPrescriptionDrugDetails;
	}
	else{
		formObj = document.formIVPrescriptionDrugDetails;
	}
	var bean_id							= formObj.bean_id.value;
	var bean_name						= formObj.bean_name.value;
	var patient_id						= formObj.patient_id.value;
	var encounter_id					= formObj.encounter_id.value;
	var strengthUom                     = formObj.STRENGTH_UOM.value;
	var drug_dosage                     = formObj.STRENGTH_VALUE.value;
	var dosage_type                     = formObj.DOSAGE.value;
	var drug_code						= formObj.DRUG_CODE.value;
	var qryString	= 	bean_id+"&bean_name="+bean_name+"&validate=SETUOM&strengthUom="+strengthUom+"&patient_id="+patient_id+"&encounter_id="+encounter_id+"&drug_dosage="+drug_dosage+"&dosage_type="+dosage_type+"&drug_code="+drug_code;
	submitXML(qryString, "");
}

function setCalculatedQty(obj) {
	if (parseFloat(obj.value) < 1){
		obj.value = parseFloat(obj.value);
	}
	if (CheckPositiveNumber(obj)){
		var frmObj = document.formIVPrescriptionDrugDetails;
		if (frmObj.DOSAGE.value == "S") {
			var objVal				= obj.value;
			frmObj.BMS_QTY.value	= Math.ceil(objVal/frmObj.STR_VAL.value);
			setInfusionPeriod(frmObj.INFUSION_VALUE);
		}
	}
}

function setQtyUOM(objVal) {
	var frmObj = document.formIVPrescriptionDrugDetails;
}

function defaultRates(obj) {
	var fluidForm = parent.parent.f_ivfluid.document.formIVPrescriptionFluidDetail;
	var adminForm = parent.parent.f_ivadmin.document.formIVPrescriptionAdminDetail;
	fluidForm.INFUSION_PERIOD_UOM.value	= "H";
	if(obj.value=="H") {
		
		adminForm.INFUSION_UOM.value		= "H";
		parent.parent.f_ivfluid.document.getElementById('flow_unit').innerText="/Hours";
	}
	else {
//		fluidForm.INFUSION_PERIOD_UOM.value	= "M";
		adminForm.INFUSION_UOM.value		= "M";
		parent.parent.f_ivfluid.document.getElementById('flow_unit').innerText="/Minutes";
	}
}

function setOrderType(orderTypeCode) {
	if(document.formIVPrescriptionDetails != undefined){
		//parent.parent.f_iv_fluid.formIVPrescriptionDetails.ORDER_TYPE_CODE.value = orderTypeCode;
		document.formIVPrescriptionDetails.ORDER_TYPE_CODE.value = orderTypeCode;
	}
	else{
		//document.formIVPrescriptionDetails.ORDER_TYPE_CODE.value = orderTypeCode;
		if(parent.parent.f_iv_fluid != undefined)
			parent.parent.f_iv_fluid.formIVPrescriptionDetails.ORDER_TYPE_CODE.value = orderTypeCode;
		else
			parent.parent.parent.f_iv_fluid.formIVPrescriptionDetails.ORDER_TYPE_CODE.value = orderTypeCode;
	}
}

function setInfuseValue(infuse,dfltFluid) {	
	var f_iv_admin;
	var mode;
	if(dfltFluid == 1){
		f_iv_admin = parent.parent.f_iv_admin;
		mode = '1';
	}
	else
		f_iv_admin = parent.f_iv_admin;

	if(f_iv_admin == undefined){
		f_iv_admin = parent.parent.parent.f_iv_admin;
		mode = "orderset";
	}

	var val		=	infuse.split("::");
	if(val[0] != ""){
	
		if((f_iv_admin.formIVPrescriptionAdminDetail.mode.value != "amend") && (f_iv_admin.formIVPrescriptionAdminDetail.prev_order.value != "previous")){
			f_iv_admin.formIVPrescriptionAdminDetail.START_DATE.value = f_iv_admin.formIVPrescriptionAdminDetail.sys_date.value;
		}

		if(val[1] == "null")
			HrsMinStr = getHrsMinStr(val[0],"H");
		else
			HrsMinStr = getHrsMinStr(val[0],val[1]);

		hrs = HrsMinStr.substring(1,HrsMinStr.indexOf("H")-1);
		min = HrsMinStr.substring(HrsMinStr.indexOf("H")+4,HrsMinStr.indexOf("M")-1);

		f_iv_admin.formIVPrescriptionAdminDetail.INFUSION_PERIOD_VALUE.value = hrs;
		f_iv_admin.formIVPrescriptionAdminDetail.INFUSION_PERIOD_VALUE_MIN.value = min;
		if(parseFloat(min) > 0)
			f_iv_admin.formIVPrescriptionAdminDetail.infusion_over_insert_value.value = hrs+"."+Math.ceil(min/60);
		else
			f_iv_admin.formIVPrescriptionAdminDetail.infusion_over_insert_value.value = hrs+".0";
		if(val[1] == "null")
			f_iv_admin.formIVPrescriptionAdminDetail.lstInfusionRateDurnUnit.value = "H";
		else
			f_iv_admin.formIVPrescriptionAdminDetail.lstInfusionRateDurnUnit.value = val[1];
		
		f_iv_admin.document.formIVPrescriptionAdminDetail.INFUSION_PERIOD_UOM.value="H";
		if(val[1] == "M"){
			//f_iv_admin.document.getElementById("infusionOverUnit").innerHTML = "<B>Minute(s)</B>";
			f_iv_admin.document.formIVPrescriptionAdminDetail.INFUSION_UOM.value="M";
			//f_iv_admin.document.formIVPrescriptionAdminDetail.INFUSION_PERIOD_UOM.value="M";
		}
		else{
			//f_iv_admin.document.getElementById("infusionOverUnit").innerHTML = "<B>Hour(s)</B>";
			f_iv_admin.document.formIVPrescriptionAdminDetail.INFUSION_UOM.value="H";
		}
		f_iv_admin.document.getElementById('infusionOverStr').innerHTML = HrsMinStr;
		setInfuseRateValue("LOAD");
		var bean_id    = f_iv_admin.formIVPrescriptionAdminDetail.BEAN_ID.value;
		var bean_name  = f_iv_admin.formIVPrescriptionAdminDetail.BEAN_NAME.value;
		var start_date = f_iv_admin.formIVPrescriptionAdminDetail.START_DATE.value;
		var durn_value = f_iv_admin.formIVPrescriptionAdminDetail.INFUSION_PERIOD_VALUE.value;
		var durn_unit  = f_iv_admin.formIVPrescriptionAdminDetail.DURN_UNIT.value;
		var DURN_VALUE  = f_iv_admin.formIVPrescriptionAdminDetail.DURN_VALUE.value;
		var iv_calc_infuse_by = f_iv_admin.formIVPrescriptionAdminDetail.iv_calc_infuse_by.value; //Added for SKR-CRF-0035 [IN:037727] -Start
		if(iv_calc_infuse_by == 'I'){
			var durnHrs = eval("f_iv_admin.formIVPrescriptionAdminDetail.INFUSION_PERIOD_VALUE").value;
			var durnMins = eval("f_iv_admin.formIVPrescriptionAdminDetail.INFUSION_PERIOD_VALUE_MIN").value;
			if(trimString(durnHrs)=="")
				durnHrs = '0';
			if(trimString(durnMins)=="")
				durnMins = '0';
			durn_unit = "M";
			DURN_VALUE =  (parseInt(durnHrs)*60)+parseInt(durnMins)
		} //Added for SKR-CRF-0035 [IN:037727] -End
		var qryString	= bean_id+"&bean_name="+bean_name+"&validate=POPULATEENDDATEADMIN&start_date="+start_date+"&durn_value="+DURN_VALUE+"&durn_unit="+durn_unit+"&mode="+mode;
		submitXML(qryString, "");
		f_iv_admin.formIVPrescriptionAdminDetail.INFUSION_PERIOD_VALUE.disabled = false
		//f_iv_admin.formIVPrescriptionAdminDetail.INFUSION_PERIOD_VALUE.focus(); // code Commented for IN050721
	}
}

function enableFields(){

	adminForm = parent.f_iv_admin.formIVPrescriptionAdminDetail;
	adminForm.INFUSION_VALUE.disabled=false;
	adminForm.INFUSION_PERIOD_VALUE.disabled=false;
	adminForm.INFUSION_PERIOD_VALUE_MIN.disabled=false;
//	adminForm.INFUSION_VALUE.value="";
//	adminForm.INFUSION_PERIOD_VALUE.value="";
//	parent.f_iv_admin.document.getElementById("infusionOverStr").innerHTML="";
//	adminForm.INFUSION_PERIOD_VALUE_MIN.value="";
	adminForm.START_DATE.disabled=false;
	adminForm.Calendar.disabled=false;
	adminForm.END_DATE.disabled=false;
//	adminForm.START_DATE.value=retVal[2];
//	adminForm.END_DATE.value=retVal[3];
	adminForm.lstInfusionRateDurnUnit.disabled=false;
	adminForm.DURN_VALUE.disabled=false;
	adminForm.DURN_VALUE.value="24";
	adminForm.MFR_YN_Flag.value = "N";
	parent.f_iv_admin.document.getElementById('adminrate').style.visibility='visible';
	document.formIVPrescriptionDetails.mfr_yn.value="N";
	document.formIVPrescriptionDetails.mfr_remarks.value="";
	//document.formIVPrescriptionDetails.stock_value.disabled=false;  // commented for aakh-crf-0094
  if(document.formIVPrescriptionDetails.param_volume_cal.value!="N"){ // if condition added for aakh-crf-0094 - Start
	 document.formIVPrescriptionDetails.stock_value.disabled=false;
  } // if condition added for aakh-crf-0094 - End
	document.getElementById('MFR_Indicator').src="../../eCommon/images/disabled.gif";
	document.getElementById('mfrRemarksLink').style.display = 'none';
}

function deleteSchedule(called_frm) {
	var frmObj;
	var docu;
	var admin_frm;

	if(called_frm=="F") {
		frmObj		= document.formIVPrescriptionFluidDetail;
		docu		= parent.f_ivadmin.document;
		admin_frm	= parent.f_ivadmin.document.formIVPrescriptionAdminDetail;
	}
	else if(called_frm=="A") {
		frmObj		= parent.f_ivfluid.document.formIVPrescriptionFluidDetail;
		docu		= document;
		admin_frm	= document.formIVPrescriptionAdminDetail;
	}
	var bean_id		= frmObj.bean_id.value;
	var bean_name	= frmObj.bean_name.value;
	drug_code		= frmObj.fluid.value;	
	docu.SCHED_MEDN_YN.value	= "N";
	var qryString	= bean_id+"&bean_name="+bean_name+"&validate=DELETESCHEDULE&drug_code="+drug_code;
	submitXML(qryString, "");
}

function makeAutoSchedule(called_frm) {
	// check schedule chkbox is enabled & freq is selected
	// automatic scheduling
	var frmObj;
	var docu;
	var admin_frm;

	if(called_frm=="F") {
		frmObj		= document.formIVPrescriptionFluidDetail;
		docu		= parent.f_ivadmin.document;
		admin_frm	= parent.f_ivadmin.document.formIVPrescriptionAdminDetail;
	}
	else if(called_frm=="A") {
		frmObj		= parent.f_ivfluid.document.formIVPrescriptionFluidDetail;
		docu		= document;
		admin_frm	= document.formIVPrescriptionAdminDetail;
	}
	var bean_id		= frmObj.bean_id.value;
	var bean_name	= frmObj.bean_name.value;
	admin_frm		= parent.f_ivadmin.document.formIVPrescriptionAdminDetail;
	if(admin_frm.FREQUENCY.value!="") {
		start_date		= admin_frm.START_DATE.value;
		qty_value		= frmObj.STOCK_VALUE.value;
		freq_code		= admin_frm.FREQUENCY.value;
		drug_code		= frmObj.fluid.value;
		if(qty_value!="" && parseFloat(qty_value)!==0) {
			var qryString	= bean_id+"&bean_name="+bean_name+"&validate=AUTOSCHEDULE&freq_code="+freq_code+"&start_date="+start_date+"&qty_value="+qty_value+"&drug_code="+drug_code;
			submitXML(qryString, "");
		}
	}
}

function makeLink() {
	docu			= parent.f_ivadmin.document;
	docu.SCHED_MEDN_YN.value = "Y";
}

function refreshLocation(patient_id, encounter_id, mode,pc,order_type,order_id) {
	var f_header			 = "";
	if(parent.parent.parent.parent.f_header!=undefined)
		f_header			 = parent.parent.parent.parent.f_header;
	else if(parent.parent.parent.parent.parent.f_header!=undefined)
		f_header			 = parent.parent.parent.parent.parent.f_header;
	else
		f_header			 = parent.parent.parent.f_header;
	var location_type		 = f_header.prescription_header_form.location_type.value;
	var location_code		 = f_header.prescription_header_form.location_code.value;
	var take_home_medication = f_header.prescription_header_form.take_home_medication.value; 
	var bl_install_yn = f_header.prescription_header_form.bl_install_yn.value; 
	var bl_disp_charge_dtl_in_rx_yn = f_header.prescription_header_form.bl_disp_charge_dtl_in_rx_yn.value; 
	var priority			 = f_header.prescription_header_form.priority.value;
    var adr_count			 = f_header.prescription_header_form.adr_count.value;
    var weight			 = f_header.prescription_header_form.weight.value;
    var bsa			 = f_header.prescription_header_form.bsa.value;
	var preview_rx_yn			 = f_header.prescription_header_form.preview_rx_yn.value;//added for ML-MMOH-CRF-0341 [IN:057179]
	var iv_option = mode;
	//iv_prep_yn_temp = "";
	if(parent.parent.parent.f_ivselect != null){
		iv_option			 = parent.parent.parent.f_ivselect.document.formIVPrescriptionOptions.type.value;
		var iv_prep_yn = "";
		if(iv_option=='IVD')
			iv_prep_yn='1';
		else if(iv_option=='IVPB')
			iv_prep_yn='3';
		else if(iv_option=='IVWA')
			iv_prep_yn='5';
	}
	else{
		iv_prep_yn =f_header.document.prescription_header_form.iv_prep_yn.value;
		/*var iv_prep_yn = "";
		if(iv_option=='IVD')
			iv_prep_yn='1';
		else if(iv_option=='IVPB')
			iv_prep_yn='3';
		else if(iv_option=='IVWA')
			iv_prep_yn='5';*/
	}
	if (mode == "1") {
		parent.f_drug_list.location.href		= "../jsp/IVPrescriptionDrugList.jsp?patient_id="+patient_id+"&encounter_id="+encounter_id+"&adr_count="+adr_count+"&weight="+weight+"&bsa="+bsa;
		parent.parent.f_iv_fluid.document.formIVPrescriptionDetails.fluid.selectedIndex =0;
		parent.parent.f_iv_fluid.document.formIVPrescriptionDetails.stock_uom_code.value = '';
		parent.parent.f_iv_fluid.document.formIVPrescriptionDetails.stock_value.value = '';
        parent.parent.f_iv_fluid.document.getElementById('fluid_ADR_img').style.visibility='hidden';
		parent.parent.f_iv_fluid.document.getElementById('stock_display').innerText = '';
		parent.parent.f_iv_fluid.document.formIVPrescriptionDetails.volumePerUnit.value = '';
		parent.parent.f_iv_fluid.document.getElementById('volPerUnitUom_leg').innerText = '';
		parent.parent.f_iv_admin.document.formIVPrescriptionAdminDetail.order_qty.value = '';
		parent.parent.f_iv_admin.document.getElementById('ord_qty_uom').innerText = '';
		//parent.parent.parent.f_ivbutton.location.href	= "../jsp/IVPrescriptionButtons.jsp?patient_id="+patient_id+"&encounter_id="+encounter_id+"&location_type="+location_type+"&location_code="+location_code+"&take_home_medication="+take_home_medication+"&priority="+priority+"&iv_prep_yn="+iv_prep_yn+"&bl_install_yn="+bl_install_yn+"&bl_disp_charge_dtl_in_rx_yn="+bl_disp_charge_dtl_in_rx_yn;
	}
	else if(mode == "2") {
		parent.f_drug_list.location.href		= "../jsp/IVPrescriptionDrugList.jsp?patient_id="+patient_id+"&encounter_id="+encounter_id+"&adr_count="+adr_count;
		parent.f_sub_ivdrugs.location.href		= "../jsp/IVPrescriptionDrugDetails.jsp?patient_id="+patient_id+"&encounter_id="+encounter_id+"&act_patient_class="+pc;
		parent.f_drug_button.location.href		= "../jsp/IVPrescriptionDrugDetailButtons.jsp?patient_id="+patient_id+"&encounter_id="+encounter_id+"&act_patient_class="+pc;
		if(parent.parent.parent.f_ivbutton != null){
			parent.parent.parent.f_ivbutton.location.href	= "../jsp/IVPrescriptionButtons.jsp?patient_id="+patient_id+"&encounter_id="+encounter_id+"&act_patient_class="+pc+"&mode="+order_type+"&location_type="+location_type+"&location_code="+location_code+"&take_home_medication="+take_home_medication+"&priority="+priority+"&iv_prep_yn="+iv_prep_yn+"&bl_install_yn="+bl_install_yn+"&bl_disp_charge_dtl_in_rx_yn="+bl_disp_charge_dtl_in_rx_yn+"&preview_rx_yn="+preview_rx_yn;
		}
	}
	else if(mode == "3")  {
		parent.f_drug_list.location.href		= "../jsp/IVPrescriptionDrugList.jsp?patient_id="+patient_id+"&encounter_id="+encounter_id+"&mode="+order_type+"&order_id="+order_id+"&act_patient_class="+pc+"&adr_count="+adr_count+"&weight="+weight+"&bsa="+bsa;

		if(order_type != "amend"){
			parent.f_sub_ivdrugs.location.href		= "../jsp/IVPrescriptionDrugDetails.jsp?patient_id="+patient_id+"&encounter_id="+encounter_id+"&act_patient_class="+pc;
//				parent.parent.f_iv_fluid.location.href = "../jsp/IVPrescriptionFluidDetail.jsp?patient_id="+patient_id+"&encounter_id="+encounter_id+"&act_patient_class="+pc;
//parent.parent.f_iv_fluid.document.formIVPrescriptionDetails.fluid_code = "";
//parent.parent.f_iv_fluid.document.formIVPrescriptionDetails.fluid_name = "";
			if(parent.parent.f_iv_fluid.document.formIVPrescriptionDetails.admixture.checked == true)
				iv_prep_yn='2';
			else
				iv_prep_yn='1';
			if(parent.parent.parent.f_ivbutton != undefined){
				parent.parent.parent.f_ivbutton.location.href	= "../jsp/IVPrescriptionButtons.jsp?patient_id="+patient_id+"&encounter_id="+encounter_id+"&act_patient_class="+pc+"&mode="+order_type+"&location_type="+location_type+"&location_code="+location_code+"&take_home_medication="+take_home_medication+"&priority="+priority+"&iv_prep_yn="+iv_prep_yn+"&bl_install_yn="+bl_install_yn+"&bl_disp_charge_dtl_in_rx_yn="+bl_disp_charge_dtl_in_rx_yn+"&preview_rx_yn="+preview_rx_yn;
			}
		}
		else{
			if(parent.parent.f_iv_fluid.document.formIVPrescriptionDetails.admixture.checked == true)
				iv_prep_yn='2';
			else
				iv_prep_yn='1';

			parent.f_sub_ivdrugs.location.href		= "../jsp/IVAmendDrugDetails.jsp?patient_id="+patient_id+"&encounter_id="+encounter_id+"&act_patient_class="+pc+"&mode="+order_type+"&adr_count="+adr_count+"&take_home_medication="+take_home_medication+"&priority="+priority+"&iv_prep_yn="+iv_prep_yn;
			parent.parent.parent.frames[3].location.href	= "../jsp/IVPrescriptionButtons.jsp?patient_id="+patient_id+"&encounter_id="+encounter_id+"&act_patient_class="+pc+"&mode="+order_type+"&location_type="+location_type+"&location_code="+location_code+"&take_home_medication="+take_home_medication+"&priority="+priority+"&bl_install_yn="+bl_install_yn+"&bl_disp_charge_dtl_in_rx_yn="+bl_disp_charge_dtl_in_rx_yn+"&iv_prep_yn="+iv_prep_yn+"&preview_rx_yn="+preview_rx_yn;
		}
		parent.f_drug_button.location.href		= "../jsp/IVPrescriptionDrugDetailButtons.jsp?patient_id="+patient_id+"&encounter_id="+encounter_id+"&act_patient_class="+pc+"&mode="+order_type+"&location_type="+location_type+"&location_code="+location_code+"&take_home_medication="+take_home_medication+"&priority="+priority+"&iv_prep_yn="+iv_prep_yn;
	}
	else if(mode == "4"){
		parent.f_drug_list.location.href		= "../jsp/IVPrescriptionDrugListAmend.jsp?patient_id="+patient_id+"&encounter_id="+encounter_id+"&adr_count="+adr_count;
		parent.f_sub_ivdrugs.location.href		= "../jsp/IVPrescriptionDrugDetailsAmend.jsp?patient_id="+patient_id+"&encounter_id="+encounter_id+"&act_patient_class="+pc;
		parent.f_drug_button.location.href		= "../jsp/IVPrescriptionDrugDetailButtons.jsp?patient_id="+patient_id+"&encounter_id="+encounter_id+"&act_patient_class="+pc;
		parent.parent.parent.f_ivbutton.location.href	= "../jsp/IVPrescriptionButtons.jsp?patient_id="+patient_id+"&encounter_id="+encounter_id+"&location_type="+location_type+"&location_code="+location_code+"&take_home_medication="+take_home_medication+"&priority="+priority+"&iv_prep_yn="+iv_prep_yn+"&bl_install_yn="+bl_install_yn+"&bl_disp_charge_dtl_in_rx_yn="+bl_disp_charge_dtl_in_rx_yn+"&preview_rx_yn="+preview_rx_yn;
	}
	else if(mode == "5") {
		parent.location.href		= "../jsp/IVPrescriptionDrugList.jsp?patient_id="+patient_id+"&encounter_id="+encounter_id+"&adr_count="+adr_count+"&weight="+weight+"&bsa="+bsa;
		parent.parent.parent.parent.f_ivbutton.location.href	= "../jsp/IVPrescriptionButtons.jsp?patient_id="+patient_id+"&encounter_id="+encounter_id+"&location_type="+location_type+"&location_code="+location_code+"&take_home_medication="+take_home_medication+"&priority="+priority+"&iv_prep_yn="+iv_prep_yn+"&bl_install_yn="+bl_install_yn+"&bl_disp_charge_dtl_in_rx_yn="+bl_disp_charge_dtl_in_rx_yn+"&preview_rx_yn="+preview_rx_yn;
	}
}

function loadDrugCodes(){
	if(parent.parent.parent.f_iv_admin.document.forms[0] != undefined){
		 parent.parent.parent.f_iv_admin.document.forms[0].drug_codes.value =formIVPrescriptionDrugList.drug_codes.value ;
	}
}

function chkAuthorization(src) {
	var allowed_click	= "";
	var formobj			= document.formIVPrescriptionDrugDetails;

	if (src == "authorize") {
		if(confirm(getMessage("PH_AUTHAPPROVE_1","PH"))) {
			document.formIVPrescriptionDrugDetails.ORD_AUTHORIZED_YN.value			= "Y"; //AUTH_YN_VAL renamed as ORD_AUTHORIZED_YN for HSA-SCF-0149 [IN:051784] 
			document.formIVPrescriptionDrugDetails.auth_yn_img.innerHTML	= "&nbsp;<IMG SRC=\"../../eOR/images/Authorized.gif\" BORDER=\"0\"></IMG>&nbsp;<B>Authorized</B>";
		}
		else {
			document.formIVPrescriptionDrugDetails.ORD_AUTHORIZED_YN.value			= "N"; //AUTH_YN_VAL renamed as ORD_AUTHORIZED_YN for HSA-SCF-0149 [IN:051784] 
			document.formIVPrescriptionDrugDetails.auth_yn_img.innerHTML	= "&nbsp;<IMG SRC=\"../../eOR/images/Authorization.gif\" BORDER=\"0\"></IMG>&nbsp;<A HREF onMouseOver=\"changeCursor(this)\" onClick=\"chkAuthorization('authorize')\">Authorize</A>";
		}

	}
	else if (src=="approve") {
		if (confirm(getMessage("PH_AUTHAPPROVE_2","PH"))) {
			document.formIVPrescriptionDrugDetails.ORD_APPROVED_YN.value		= "Y"; //APPROVAL_YN_VAL renamed as ORD_APPROVED_YN for HSA-SCF-0149 [IN:051784]
			document.formIVPrescriptionDrugDetails.spappl_yn_img.innerHTML	= "&nbsp;<IMG SRC=\"../../eOR/images/SpecialApproval_click.gif\" BORDER=\"0\"></IMG>&nbsp;<B>Approved</B>";
		}
		else {
			document.formIVPrescriptionDrugDetails.ORD_APPROVED_YN.value		= "N"; //APPROVAL_YN_VAL renamed as ORD_APPROVED_YN for HSA-SCF-0149 [IN:051784]
			document.formIVPrescriptionDrugDetails.spappl_yn_img.innerHTML	= "&nbsp;<IMG SRC=\"../../eOR/images/SpecialApproval.gif\" BORDER=\"0\"></IMG>&nbsp;<A HREF onMouseOver=\"changeCursor(this)\" onClick=\"chkAuthorization('approve')\">Approve</A>";
		}
	}
	else if (src=="cosign") {
		if (confirm(getMessage("PH_AUTHAPPROVE_3","PH"))) {
			document.formIVPrescriptionDrugDetails.ORD_COSIGNED_YN.value			= "Y"; //COSIGN_YN_VAL renamed as ORD_AUTHORIZED_YN for HSA-SCF-0149 [IN:051784]
			document.formIVPrescriptionDrugDetails.cosign_yn_img.innerHTML	= "&nbsp;<IMG SRC=\"../../eOR/images/Cosign.gif\" BORDER=\"0\"></IMG>&nbsp;<B>Cosigned</B>";
		}
		else {
			document.formIVPrescriptionDrugDetails.ORD_COSIGNED_YN.value			= "N"; //COSIGN_YN_VAL renamed as ORD_AUTHORIZED_YN for HSA-SCF-0149 [IN:051784]
			document.formIVPrescriptionDrugDetails.cosign_yn_img.innerHTML	= "&nbsp;<IMG SRC=\"../../eOR/images/Cosign_click.gif\" BORDER=\"0\"></IMG>&nbsp;<A HREF onMouseOver=\"changeCursor(this)\" onClick=\"chkAuthorization('cosign')\">Cosign</A>";
		}
	}
}

function defaultDrug(serialNum,or_mode,classValue) {

	if(parent.parent.f_sub_ivdrugs != undefined)
		var frmObj			= parent.parent.parent.f_iv_drug_details.f_sub_ivdrugs.document.formIVPrescriptionDrugDetails;
	//added for ml-mmoh-crf-0863 start
	var iv_prep_yn	= frmObj.iv_prep_yn.value;
	var priority		= frmObj.priority.value;
	var take_home_medication		= frmObj.take_home_medication.value;
	//added for ml-mmoh-crf-0863 end
   	if(or_mode != "amend"){
		var patient_id		= frmObj.patient_id.value;
		var encounter_id	= frmObj.encounter_id.value;
		var patient_class	= frmObj.patient_class.value;
		var drug_codes		= frmObj.drug_codes.value;
		var start_date		= frmObj.start_date.value;
		var mode = frmObj.mode.value;
		var iv_option		= "";

		if(parent.parent.parent.parent.f_ivselect != undefined){
			if(parent.parent.parent.parent.f_ivselect.document.formIVPrescriptionOptions.type!=null)
				iv_option	=	parent.parent.parent.parent.f_ivselect.document.formIVPrescriptionOptions.type.value;
		}
		parent.parent.f_sub_ivdrugs.location.href="../jsp/IVPrescriptionDrugDetails.jsp?serialNum="+serialNum+"&patient_id="+patient_id+"&encounter_id="+encounter_id+"&act_patient_class="+patient_class+"&drug_codes="+drug_codes+"&iv_option="+iv_option+"&start_date="+start_date+"&mode="+mode+"&classValue="+classValue+"&patient_class="+patient_class;
	}
	else{
		var patient_id		= frmObj.patient_id.value;
		var encounter_id	= frmObj.encounter_id.value;
		var patient_class	= frmObj.patient_class.value;
		var mode = frmObj.mode.value;
		var start_date		= frmObj.start_date.value;
		var drug_codes		= frmObj.drug_codes.value;
		frmObj.edlImg.style.visibility = "visible";
		//modified for ml-mmoh-crf-0863 
		parent.parent.f_sub_ivdrugs.location.href="../jsp/IVAmendDrugDetails.jsp?or_mode="+or_mode+"&serialNum="+serialNum+"&patient_id="+patient_id+"&encounter_id="+encounter_id+"&act_patient_class="+patient_class+"&mode="+mode+"&start_date="+start_date+"&drug_codes="+drug_codes+"&classValue="+classValue+"&priority="+priority+"&iv_prep_yn="+iv_prep_yn+"&take_home_medication="+take_home_medication;
	}
}

function loadButtonsFrame(or_mode,patient_id,encounter_id) {
	var frmObj				= parent.f_sub_ivdrugs.document.formIVPrescriptionDrugDetails;
	var frmObj1				= parent.parent.f_iv_admin.document.formIVPrescriptionAdminDetail;
	var drug_array			= frmObj.drug_codes.value.split(",");
	var num_drugs			= drug_array.length-1;
	var frmObjDrugList			= parent.f_drug_list.f_drugs.document.formIVPrescriptionDrugList;
	var srl_no = frmObj.SRL_NO.value;
	if(frmObj.sRegRopt != undefined)
		var sRegRopt			= frmObj.sRegRopt.value;

	var limit_ind			= frmObj.LIMIT_IND.value;
	var allergy_yn			= frmObj.ALLERGY_YN.value;
	var current_rx			= frmObj.CURRENT_RX.value;
	var abuse_exists        = frmObj.abuse_exists.value;//added for aakh-crf-0140
	var abuse_action        = frmObj.abuse_action.value;//added for aakh-crf-0140
	var abuse_override_remarks=frmObj.abuse_override_remarks.value;
//	alert("1267"+abuse_override_remarks);
	var showButtons			= "Y";
	var order_type_flag		= frmObj1.order_type_flag.value;
    var	mode				= frmObj1.mode.value;
	var db_dosage = eval("frmObjDrugList.ext_med_alerts_fired_for_dosage_check_yn")+srl_no.value;
	var db_allergy = eval("frmObjDrugList.ext_med_alerts_fired_for_allergy_check_yn")+srl_no.value;
	var db_duplicate = eval("frmObjDrugList.ext_med_alerts_fired_for_dup_check_yn")+srl_no.value;
//abuse_action,abuse_exists added for aakh-crf-0140
	parent.f_drug_button.location.href="../jsp/IVPrescriptionDrugDetailButtons.jsp?or_mode="+or_mode+"&showButtons="+showButtons+"&limit_ind="+limit_ind+"&allergy_yn="+allergy_yn+"&current_rx="+current_rx+"&patient_id="+patient_id+"&encounter_id="+encounter_id+"&order_type_flag="+order_type_flag+"&mode="+mode+"&sRegRopt="+sRegRopt+"&db_dosage="+db_dosage+"&db_allergy="+db_allergy+"&db_duplicate="+db_duplicate+"&abuse_action="+abuse_action+"&abuse_exists="+abuse_exists;

}

function setDurationValue(objVal, frmObj) {
	frmObj = eval(frmObj);
	frmObj.DURN_VALUE.value		= objVal;
	frmObj.DURN_UNIT.disabled	= true;
}

function chkMandatoryFlds(calledMode,default_comp_fluid_falg) {//default_comp_fluid_falg added for ML-MMOH-CRF-1223
	var retStat = true;
	if (calledMode == "Amend") {
		var drgdtlsForm	= parent.f_sub_ivdrugs.document.formIVPrescriptionDrugDetails;
		if (drgdtlsForm.CALC_DOSE_BASED_ON[0].checked &&((trimCheck(drgdtlsForm.STRENGTH_VALUE.value) == "") || (parseFloat(drgdtlsForm.STRENGTH_VALUE.value) == 0) || (trimCheck(drgdtlsForm.STRENGTH_VALUE.value) == "null"))) {
			alert(getMessage("STR_VAL_CANT_BLANK_ZERO","PH"));
			drgdtlsForm.STRENGTH_VALUE.select();
			retStat = false;
		}
		else if (drgdtlsForm.CALC_DOSE_BASED_ON[1].checked && ((trimCheck(drgdtlsForm.STRENGTH_VALUE.value) == "") || (parseFloat(drgdtlsForm.STRENGTH_VALUE.value) == 0)|| (trimCheck(drgdtlsForm.STRENGTH_VALUE.value) == "null"))) {
			alert(getMessage("STR_VAL_CANT_BLANK_ZERO","PH"));
			drgdtlsForm.strength_value_wt_bsa.select();
			retStat = false;
		}
		else if (drgdtlsForm.STRENGTH_UOM.value == "") {
			alert(getMessage("STR_UOM_CANT_BLANK","PH"));
			drgdtlsForm.STRENGTH_UOM.focus();
			retStat = false;
		}
		else if ((drgdtlsForm.LIMIT_IND.value == "N" && drgdtlsForm.EXCEED_DOSE_DESC.value == "") 
				|| (drgdtlsForm.ALLERGY_YN.value == "Y" && drgdtlsForm.ALLERGY_DESC.value == "") || 
				(drgdtlsForm.CURRENT_RX.value == "Y" && drgdtlsForm.DUP_DRUG_DESC.value == "")
				||(drgdtlsForm.abuse_exists.value == "Y" && drgdtlsForm.abuse_action.value == "B" && drgdtlsForm.abuse_override_remarks.value == "") ){//MODIFIED FOR AAKH-CRF-0140
			// Modified for IN:069887 start
			if(drgdtlsForm.validate_overide_on_confirm_yn.value == "Y"){
				var allergy_remarks_yn="N";
				var dup_remarks_yn="N";
				var dose_remarks_yn="N"
					var abuse_rmk_yn="N";//ADDED FOR AAKH-CRF-0140
				if(drgdtlsForm.LIMIT_IND.value == "N" && drgdtlsForm.EXCEED_DOSE_DESC.value == ""){
					dose_remarks_yn="Y";
				}
				if(drgdtlsForm.ALLERGY_YN.value == "Y" && drgdtlsForm.ALLERGY_DESC.value == ""){
					allergy_remarks_yn="Y";
				}
				if(drgdtlsForm.CURRENT_RX.value == "Y" && drgdtlsForm.DUP_DRUG_DESC.value == ""){
					dup_remarks_yn="Y";
				}
				if(drgdtlsForm.abuse_exists.value == "Y" && drgdtlsForm.abuse_action.value == "B" && drgdtlsForm.abuse_override_remarks.value == ""){//ADDED FOR AAKH-CRF-0140
					abuse_rmk_yn="Y";
				}
				showOverideMandAlert(allergy_remarks_yn, dup_remarks_yn, dose_remarks_yn,abuse_rmk_yn);//MODIFIED FOR AAKH-CRF-0140
			}
			else{
				alert(getMessage("OVR_RDN_RSN-CANT_BLNK","PH"));
				}
				// Modified for IN:069887 end
			document.getElementById('OVERRIDE_LINK').click();
			retStat = false;
		}
		else if (drgdtlsForm.DrugRemarksMandatory.value == "Y" && drgdtlsForm.DrugRemarksEntered.value != "Y"){//if block added for [IN:039576]
			msg = getMessage("CAN_NOT_BE_BLANK","Common");
			msg = msg.replace('$', getLabel("ePH.DrugRemarks.label","PH"));
			alert(msg);
			drgdtlsForm.drug_remarks.click();
			return false;
		}
	}
	if (calledMode == "Release" || calledMode == "Preview") {
		if( parent.f_ivselect != undefined){
			var optionForm	= parent.f_ivselect.document.formIVPrescriptionOptions;
			
			var drgdtlsForm	= parent.f_ivdetails.f_iv_drug_details.f_sub_ivdrugs.document.formIVPrescriptionDrugDetails;
			var drugListForm	= parent.f_ivdetails.f_iv_drug_details.f_drug_list.f_drugs.document.formIVPrescriptionDrugList;
			var fluidForm	= parent.f_ivdetails.f_iv_fluid.document.formIVPrescriptionDetails;
			var adminForm	= parent.f_ivdetails.f_iv_admin.document.formIVPrescriptionAdminDetail;

		}
		else {
			var optionForm	= parent.f_options.formIVPrescriptionOptions;
			var drgdtlsForm	= parent.f_detail.f_iv_drug_details.f_sub_ivdrugs.document.formIVPrescriptionDrugDetails;
			var fluidForm	= parent.f_detail.f_iv_fluid.document.formIVPrescriptionDetails;
			var adminForm	= parent.f_detail.f_iv_admin.document.formIVPrescriptionAdminDetail;
			var drugListForm	= parent.f_detail.f_iv_drug_details.f_drug_list.f_drugs.document.formIVPrescriptionDrugList;
		}
		//var drgdtlsForm	= parent.f_sub_ivdrugs.document.formIVPrescriptionDrugDetails;
		//alert(drgdtlsForm.CALC_DOSE_BASED_ON[0]);
		//alert(drgdtlsForm.CALC_DOSE_BASED_ON[0].checked);
		/*if (drgdtlsForm.CALC_DOSE_BASED_ON != null && drgdtlsForm.CALC_DOSE_BASED_ON != undefined && drgdtlsForm.CALC_DOSE_BASED_ON[0] !=null && drgdtlsForm.CALC_DOSE_BASED_ON[0] != "null" && drgdtlsForm.CALC_DOSE_BASED_ON[0] != "undefined" && drgdtlsForm.CALC_DOSE_BASED_ON[0] != undefined && drgdtlsForm.CALC_DOSE_BASED_ON[0].checked &&((trimCheck(drgdtlsForm.STRENGTH_VALUE.value) == "") || (parseFloat(drgdtlsForm.STRENGTH_VALUE.value) == 0) || (trimCheck(drgdtlsForm.STRENGTH_VALUE.value) == "null"))) {
			alert(getMessage("STR_VAL_CANT_BLANK_ZERO","PH"));
			drgdtlsForm.STRENGTH_VALUE.select();
			retStat = false;
		}
		else if (drgdtlsForm.CALC_DOSE_BASED_ON != null && drgdtlsForm.CALC_DOSE_BASED_ON != undefined  && drgdtlsForm.CALC_DOSE_BASED_ON[1].checked && ((trimCheck(drgdtlsForm.STRENGTH_VALUE.value) == "") || (parseFloat(drgdtlsForm.STRENGTH_VALUE.value) == 0)|| (trimCheck(drgdtlsForm.STRENGTH_VALUE.value) == "null"))) {
			alert(getMessage("STR_VAL_CANT_BLANK_ZERO","PH"));
			drgdtlsForm.strength_value_wt_bsa.select();
			retStat = false;
		}*/
		
		/*else{
			
		}*/
		if (drgdtlsForm != undefined && drgdtlsForm.LIMIT_IND != undefined && ((drgdtlsForm.LIMIT_IND.value == "N" && drgdtlsForm.EXCEED_DOSE_DESC.value == "") ||
				(drgdtlsForm.ALLERGY_YN.value == "Y" && drgdtlsForm.ALLERGY_DESC.value == "") || 
				(drgdtlsForm.CURRENT_RX.value == "Y" && drgdtlsForm.DUP_DRUG_DESC.value == "")||
				(drugListForm.ext_med_alerts_fired_for_dup_check_yn1.value=="Y" && drugListForm.external_duplicate_override_reason1.value=="")
				||(drgdtlsForm.abuse_exists.value == "Y" && drgdtlsForm.abuse_action.value == "B" && drgdtlsForm.abuse_override_remarks.value == "")
				)){
			// Modified for IN:069887 start
			if(drgdtlsForm.validate_overide_on_confirm_yn.value == "Y"){
				var allergy_remarks_yn="N";
				var dup_remarks_yn="N";
				var dose_remarks_yn="N"
					var abuse_rmk_yn="N";
				if(drgdtlsForm.LIMIT_IND.value == "N" && drgdtlsForm.EXCEED_DOSE_DESC.value == ""){
					dose_remarks_yn="Y";
				}
				if(drgdtlsForm.ALLERGY_YN.value == "Y" && drgdtlsForm.ALLERGY_DESC.value == ""){
					allergy_remarks_yn="Y";
				}
				if(drgdtlsForm.CURRENT_RX.value == "Y" && drgdtlsForm.DUP_DRUG_DESC.value == ""){
					dup_remarks_yn="Y";
				}
				if(drgdtlsForm.abuse_exists.value == "Y" && drgdtlsForm.abuse_action.value == "B" && drgdtlsForm.abuse_override_remarks.value == ""){//ADDED FOR AAKH-CRF-0140
					abuse_rmk_yn="Y";
				}
				showOverideMandAlert(allergy_remarks_yn, dup_remarks_yn, dose_remarks_yn,abuse_rmk_yn);//MODIFIED FOR AAKH-CRF-0140
			}
			else{
				alert(getMessage("OVR_RDN_RSN-CANT_BLNK","PH"));
				}
				// Modified for IN:069887 end
			retStat = false;
		}
		else{
			var total_hr = adminForm.DURN_VALUE.value;
			total_hr = parseFloat(total_hr)*60;
			var iv_calc_infuse_by = adminForm.iv_calc_infuse_by.value;
			infuseOver = getInfuseOverInMin(adminForm.INFUSION_PERIOD_VALUE.value,adminForm.INFUSION_PERIOD_VALUE_MIN.value);
			if(iv_calc_infuse_by=='I'){
				var orderQty = adminForm.order_qty.value;
				if(orderQty=="" ||  parseInt(orderQty)==0){
					alert(getMessage("PH_ORDER_QTY_BLANK","PH"));
					return false;
				}
			}
			if (optionForm.type.value=="IVA" && drgdtlsForm.drug_codes.value == "") {
				alert(getMessage("INGRDNT_CANT_BLANK","PH"));
				drgdtlsForm.DRUG_NAME.focus();
				retStat = false;
			}
			else if (trimCheck(fluidForm.fluid.value) == "") {
				alert(getMessage("FLUID_CANT_BLANK","PH"));
				retStat = false;
			}
			else if (trimCheck(adminForm.drug_codes.value) == "") {
				alert(getMessage("ATLST_ONE_ADTV_MST","PH"));
				if(fluidForm.fluid.disabled == false)
					fluidForm.fluid.focus();
				retStat = false;
			}
			else if(adminForm.MFR_YN_Flag.value != "Y"){
				 if (trimCheck(adminForm.START_DATE.value) == "") {
					alert(getMessage("PH_START_DATE","PH"));
					adminForm.START_DATE.focus();
					retStat = false;
				}
				else if (trimCheck(adminForm.END_DATE.value) == "") {
					alert(getMessage("PH_CURR_END_DATE","PH"));
					adminForm.END_DATE.focus();
					retStat = false;
				}
				else if ((trimCheck(adminForm.INFUSION_PERIOD_VALUE.value) == "" || parseFloat(adminForm.INFUSION_PERIOD_VALUE.value) ==0.0 ) &&(trimCheck(adminForm.INFUSION_PERIOD_VALUE_MIN.value) == "" || parseFloat(adminForm.INFUSION_PERIOD_VALUE_MIN.value) ==0.0 )){
					alert(getMessage("INFS_OVR_CANT_BLANK_ZERO","PH"));
					adminForm.INFUSION_PERIOD_VALUE.focus();
					retStat = false;
				}
				else if (trimCheck(adminForm.INFUSION_VALUE.value) == "" || parseFloat(adminForm.INFUSION_VALUE.value) ==0.0 ) {
					alert(getMessage("INF_RATE_CANT_BLANK_ZERO","PH"));
					adminForm.INFUSION_VALUE.focus();
					retStat = false;
				}
				//else if (parseInt(adminForm.INFUSION_VALUE.value)  > parseInt(fluidForm.STOCK_VALUE.value) ){//Commented for AAKH-SCF-0117[Inc :49546] 
				//else if(parseInt(adminForm.INFUSION_VALUE.value) > parseInt(fluidForm.volumePerUnit.value)){//Added for AAKH-SCF-0117[Inc :49546]
				else if(iv_calc_infuse_by!='I' && parseInt(adminForm.INFUSION_VALUE.value) > parseInt(fluidForm.STOCK_VALUE.value)) {//Added for AAKH-SCF-0117[Inc :49546] AND AAKH-SCF-0119[IN:049629]
					var msg = getMessage("INFUSION_RATE_CANNOT_GREATER","PH");
					//if(iv_calc_infuse_by=='I')//if block commneted for  AAKH-SCF-0119 [IN:049629]
						//msg = msg+"/"+getLabel("Common.Unit.label",'Common');
					alert(msg);
					//alert(getMessage("INFUSION_RATE_CANNOT_GREATER","PH"));
					adminForm.INFUSION_VALUE.focus();
					retStat = false;
				}
				/*else if (parseFloat(adminForm.DURN_VALUE.value)  > 24 ) {
					alert(getMessage("IV_DURATION_CANNOT_GREATER","PH"));
					adminForm.DURN_VALUE.focus();
					retStat = false;
				}*/
                else if (infuseOver > 24*60 && default_comp_fluid_falg=="false"){     //Added for SKR-SCF-1100 [IN:057246]//default_comp_fluid_falg added for ML-MMOH-CRF-1223
					alert(getMessage("INFUSE_OVER_CANNOT_GREATER","PH"));
					retStat = false;
				}

				else if(parseFloat(total_hr) < parseInt(infuseOver) && iv_calc_infuse_by!='I'){
					//if(parseInt(adminForm.DURN_VALUE.value) < parseInt(adminForm.INFUSION_PERIOD_VALUE.value) ){
					//if(iv_calc_infuse_by=='I' ) //added for for  SKR-CRF-0035 [IN:037727] 
						alert(getMessage("DURATION_CANNOT_LESSTHAN","PH"));   // "INFUSE_OVER_CANNOT_GREATER" changed to "DURATION_CANNOT_LESSTHAN" for SKR-SCF-1100 [IN:057246]
					//else
						//alert(getMessage("DURATION_CANNOT_LESSTHAN","PH"));
					retStat = false;
				}
				else if(adminForm.INFUSION_PERIOD_VALUE_MIN.value != ""){
					min = adminForm.INFUSION_PERIOD_VALUE_MIN.value;
					if(parseInt(min) > 59 ){
						alert(getMessage("INVALID_TIME_MINUTE","PH"));
						adminForm.INFUSION_PERIOD_VALUE_MIN.focus();
						retStat = false;
					}
				}
				else{
					var lstInfusionRateDurnUnit = adminForm.lstInfusionRateDurnUnit.value;
					var total_hr = adminForm.DURN_VALUE.value;
					total_hr = parseFloat(total_hr)*60;
					infuseOver = getInfuseOverInMin(adminForm.INFUSION_PERIOD_VALUE.value,adminForm.INFUSION_PERIOD_VALUE_MIN.value);
					if(parseFloat(total_hr) < parseInt(infuseOver)){
						alert(getMessage("DURATION_CANNOT_LESSTHAN","PH"));
						retStat = false;
					}
				}	
			}
		} 
		if (drgdtlsForm != undefined && drgdtlsForm.DrugRemarksMandatory != undefined && drgdtlsForm.DrugRemarksMandatory.value == "Y" && drgdtlsForm.DrugRemarksEntered.value != "Y"){//added for [IN:039576]
			msg = getMessage("CAN_NOT_BE_BLANK","Common");
			msg = msg.replace('$', getLabel("ePH.DrugRemarks.label","PH"));
			alert(msg);
			drgdtlsForm.drug_remarks.click();
			return false;
		}
	}
	return retStat;
} 

function callAmend() {
//	alert("callAmend()");
	if (chkMandatoryFlds("Amend")) {
		var frmObj = parent.f_sub_ivdrugs.document.formIVPrescriptionDrugDetails;
		//var pclass	=frmObj.patient_class.value;
		var pclass="IP";
		var mode  = frmObj.mode.value;
		var obj = frmObj.STRENGTH_UOM;
		var patient_id = frmObj.patient_id.value;
		var encounter_id  = frmObj.encounter_id.value;
		var allergy_desc  = encodeURIComponent(frmObj.ALLERGY_DESC.value);
		var exceed_dose_desc  = encodeURIComponent(frmObj.EXCEED_DOSE_DESC.value);
		var dup_drug_desc  = encodeURIComponent(frmObj.DUP_DRUG_DESC.value);
		var DrugIndicationRemarks  = frmObj.DrugIndicationRemarks.value;
		var DrugRemarksMandatory  = frmObj.DrugRemarksMandatory.value;
		var DrugRemarksEntered  = frmObj.DrugRemarksEntered.value;
		frmObj.STR_DESC.value = obj.options[obj.selectedIndex].text;
		var abuse_override_remarks  = frmObj.abuse_override_remarks.value;
//		var abuse_override  = frmObj.abuse_override.value;
	//	alert("abuse_override_remarks"+abuse_override_remarks);
		//GHL--CRF-0549 - start
		var allow_alternate =  "N";
		var item_type_site_app = "";
		var mono_graph =encodeURIComponent(frmObj.MONO_GRAPH.value);//Added for IN:070451
		if(frmObj.item_type_site_app!=undefined)
			item_type_site_app = frmObj.item_type_site_app.value;
		
		if(frmObj.allow_alternate_yn!=undefined){
			if(frmObj.allow_alternate_yn.checked==true)
			allow_alternate = "Y";
		}
		// ADDED FOR aakh-crf-0140 start
		var abuse_action=frmObj.abuse_action.value;
		var abuse_exists=frmObj.abuse_exists.value;
		var abuse_override=frmObj.ABUSE_OVERRIDE.value;
//		var abuse_drug_override_reason=frmObj.abuse_drug_override_reason.value;
		var abuse_restric_trn=frmObj.abuse_restric_trn.value;
		//alert(abuse_override_remarks);
		//alert(abuse_action);
	//	alert(abuse_exists);
		if(abuse_restric_trn=="Y"){

//alert("frmObj.drug_codes.value"+frmObj.DRUG_CODE.value);
showAbuseDetails("", patient_id, encounter_id, "", frmObj.DRUG_CODE.value,"Alert")

return false;
}
		// ADDED FOR aakh-crf-0140 end
		//GHL--CRF-0549 - end
		//code added to include infusion_value...on 10/5/2004
		infuseOver = getInfuseOverInMin(parent.parent.f_iv_admin.formIVPrescriptionAdminDetail.INFUSION_PERIOD_VALUE.value,parent.parent.f_iv_admin.formIVPrescriptionAdminDetail.INFUSION_PERIOD_VALUE_MIN.value);
//		frmObj.INFUSION_VALUE.value = parent.parent.f_iv_admin.formIVPrescriptionAdminDetail.INFUSION_PERIOD_VALUE.value;
		frmObj.INFUSION_VALUE.value = infuseOver;
		var xmlStr		= "<root><SEARCH " + buildXMLString(frmObj) + " /></root>";
		var bean_id		= frmObj.bean_id.value;
		var bean_name	= frmObj.bean_name.value;
		
		var qryString	= bean_id+"&bean_name="+bean_name+"&validate=AMENDDRUG&patient_class="+pclass+"&mode="+mode+"&patient_id="+patient_id+"&encounter_id="+encounter_id+"&allergy_desc="+allergy_desc+"&exceed_dose_desc="+exceed_dose_desc+"&dup_drug_desc="+dup_drug_desc+"&allow_alternate="+allow_alternate+"&item_type_site_app="+item_type_site_app+"&mono_graph="+mono_graph+"&abuse_action="+abuse_action+"&abuse_exists="+abuse_exists+"&abuse_override_remarks="+abuse_override_remarks+"&ABUSE_OVERRIDE="+abuse_override;//allow_alternate added for GHL-CRF-0549
		submitXML(qryString, xmlStr);
	}
}

function callAmendDrug() {
	if (chkMandatoryFlds("Amend")) {
		var frmObj = parent.f_sub_ivdrugs.document.formIVPrescriptionDrugDetails;
		var pclass	=frmObj.patient_class.value;

		var obj = frmObj.STRENGTH_UOM;
		frmObj.STR_DESC.value = obj.options[obj.selectedIndex].text;
		//code added to include infusion_value...on 10/5/2004
//		frmObj.INFUSION_VALUE.value = parent.parent.f_iv_admin.formIVPrescriptionAdminDetail.INFUSION_PERIOD_VALUE.value;
		infuseOver = getInfuseOverInMin(parent.parent.f_iv_admin.formIVPrescriptionAdminDetail.INFUSION_PERIOD_VALUE.value,parent.parent.f_iv_admin.formIVPrescriptionAdminDetail.INFUSION_PERIOD_VALUE_MIN.value)
		frmObj.INFUSION_VALUE.value = infuseOver;

		var xmlStr		= "<root><SEARCH " + buildXMLString(frmObj) + " /></root>";
		var bean_id		= frmObj.bean_id.value;
		var bean_name	= frmObj.bean_name.value;
		var qryString	= bean_id+"&bean_name="+bean_name+"&validate=AMENDDRUG&patient_class="+pclass;
		submitXML(qryString, xmlStr);
	}
}

function callClear() {
	var frmObj			= parent.f_sub_ivdrugs.document.formIVPrescriptionDrugDetails;
	var patient_id		= frmObj.patient_id.value;
	var encounter_id	= frmObj.encounter_id.value;
	var patient_class	= frmObj.patient_class.value;
	var mode			= frmObj.mode.value;
	if(mode == 'amend'){
		parent.f_sub_ivdrugs.document.formIVPrescriptionDrugDetails.reset();
	}
	else{
		parent.f_sub_ivdrugs.location.href		= "../jsp/IVPrescriptionDrugDetails.jsp?patient_id="+patient_id+"&encounter_id="+encounter_id+"&act_patient_class="+patient_class;
		parent.f_drug_button.location.href		= "../jsp/IVPrescriptionDrugDetailButtons.jsp?patient_id="+patient_id+"&encounter_id="+encounter_id+"&act_patient_class="+patient_class;
	}

/*	parent.f_sub_ivdrugs.document.formIVPrescriptionDrugDetails.reset();	
	if(frmObj.CALC_DOSE_BASED_ON[1].checked)
	{
		setCalculateBy(frmObj.CALC_DOSE_BASED_ON[1],"AMEND_RESET");
	}
	else
	{
		setCalculateBy(frmObj.CALC_DOSE_BASED_ON[0],"AMEND_RESET");
	}	
	changeScrDetails(frmObj.DOSAGE.value,'reset');*/
}

function callCancel() {
	//added for mms-dm-crf-0204 start
	var diagnosis_found_yn=parent.f_sub_ivdrugs.document.formIVPrescriptionDrugDetails.diagnosis_found_yn.value;
	if(diagnosis_found_yn=="N"){
		alert(getMessage("REQ_DIAG_PRES_NOT_FOUND",'PH'));
		delete_confirm=true;
	}//added for mms-dm-crf-0204 end
	else{
		var delete_confirm=confirm(getMessage("CANCEL_SEL_DRUG","PH"))
		if(!delete_confirm)
			return;
	}
	
	if(delete_confirm==true){
	var frmObj			= parent.f_sub_ivdrugs.document.formIVPrescriptionDrugDetails;
	var patient_class	= frmObj.patient_class.value;

	var drug_code		= frmObj.DRUG_CODE.value;
	var srl_no			= frmObj.SRL_NO.value;
	var bean_id			= frmObj.bean_id.value;
	var bean_name		= frmObj.bean_name.value;
	var qryString		= bean_id+"&bean_name="+bean_name+"&validate=DELETEDRUG&drug_code="+drug_code+"&srl_no="+srl_no;
	submitXML(qryString, "");
	var frmObj1		= parent.parent.f_iv_admin.document.formIVPrescriptionAdminDetail;
	var drug_array	= frmObj.drug_codes.value.split(",");
	var num_drugs	= drug_array.length-1;
	}
}

function callClearAll(calledFrom,iv_prep_default,order_set_code, confirm_yn) {

	var chk_flag = false;
	if (calledFrom == 1 && confirm_yn == undefined) {
		if(parent.f_ivselect != undefined){
			if (confirm(getMessage("PH_RECOREDED_DATA_LOST","PH")))
				chk_flag = true;
		}
		else{
			parent.f_detail.f_iv_admin.document.formIVPrescriptionAdminDetail.reset();
			parent.f_detail.f_iv_fluid.document.formIVPrescriptionDetails.reset();

			if(parent.f_detail.f_iv_admin.document.formIVPrescriptionAdminDetail.MFR_YN_Flag.value != "Y")
				chkDuration(parent.f_detail.f_iv_admin.document.formIVPrescriptionAdminDetail.DURN_VALUE,'3');

		}	
	}
	if(confirm_yn)
		chk_flag = true;
	
	if (calledFrom==2 || (calledFrom==1 && chk_flag) || calledFrom == 'cancel') {
		if(calledFrom =='cancel' ){
			var frmObj	= parent.parent.parent.f_ivselect.document.formIVPrescriptionOptions;
			var frmDtl  =  parent.parent; 
		}
		else if(parent.f_ivselect != undefined){ 

			var frmObj	= parent.f_ivselect.document.formIVPrescriptionOptions;
			var frmDtl  =  parent.f_ivdetails; 
		} 
		else { 

			var frmObj		= parent.f_options.formIVPrescriptionOptions;	
		    var frmDtl   =     parent.f_detail; 
		}
		var bean_id		= frmObj.bean_id.value;
		var bean_name	= frmObj.bean_name.value;
		var patient_id		= frmObj.patient_id.value;
		var encounter_id		=  frmObj.encounter_id.value;
		var patient_class		= frmObj.patient_class.value;

		var start_date			= frmObj.start_date.value; // this contains the value when iv tab was clicked
		var hdrFormObj;
// RUT-CRF-0062 [IN029600] -- begin
		if(parent.parent.f_header != undefined){
			var sys_date			 = parent.parent.f_header.prescription_header_form.sys_date.value; // value which is present in header page
			var priority			 = parent.parent.f_header.prescription_header_form.priority.value; 
			var source_code			 = parent.parent.f_header.prescription_header_form.source_code.value; 
			hdrFormObj=parent.parent.f_header.prescription_header_form;
		}
		else{
			var sys_date			 = parent.parent.parent.parent.f_header.prescription_header_form.sys_date.value;
			var priority			 = parent.parent.parent.parent.f_header.prescription_header_form.priority.value;
			var source_code			 = parent.parent.parent.parent.f_header.prescription_header_form.source_code.value;
			hdrFormObj = parent.parent.parent.parent.f_header.prescription_header_form;
		}
// RUT-CRF-0062 [IN029600] -- end		
		start_date = sys_date;
		//var MAR_app_yn			= frmObj.MAR_app_yn.value;
		var MAR_app_yn			= getMAR_app_yn(hdrFormObj);
		var adr_count			= frmObj.adr_count.value;
		var presc_mode	= 0;

		if(calledFrom!='cancel' ){
			var qryString	= bean_id+"&bean_name="+bean_name+"&validate=CLEARBEAN&calledFrom="+calledFrom+"&presc_mode="+presc_mode;
			submitXML(qryString, "");
		}
		if(frmObj.type.value=="IVD"){
			frmDtl.location.href		= "../jsp/IVPrescriptionDetailsFrame.jsp?patient_id="+patient_id+"&encounter_id="+encounter_id+"&act_patient_class="+patient_class+"&start_date="+start_date+"&iv_prep_default="+iv_prep_default+"&order_set_code="+order_set_code+"&MAR_app_yn="+MAR_app_yn+"&adr_count="+adr_count+"&reset=Y";
		}
		else if(trimString(frmObj.type.value)=="IVPB"){

			frmDtl.location.href		= "../jsp/IVPiggyBack.jsp?patient_id="+patient_id+"&encounter_id="+encounter_id+"&act_patient_class="+patient_class+"&start_date="+start_date+"&iv_prep_default="+iv_prep_default+"&order_set_code="+order_set_code+"&MAR_app_yn="+MAR_app_yn+"&adr_count="+adr_count;
		}
		else{

			frmDtl.scrolling="yes";
			frmDtl.location.href		= "../jsp/IVFluidAdditives.jsp?patient_id="+patient_id+"&encounter_id="+encounter_id+"&act_patient_class="+patient_class+"&start_date="+start_date+"&iv_prep_default="+iv_prep_default+"&order_set_code="+order_set_code+"&MAR_app_yn="+MAR_app_yn+"&adr_count="+adr_count;
//			alert(frmDtl.scrolling);
		}
	}
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


function setInfusionPeriod(obj) {
	if (checkWholeNumber(obj)) {
		var fluidForm = parent.parent.f_ivfluid.document.formIVPrescriptionFluidDetail;
		var adminForm = parent.parent.f_ivadmin.document.formIVPrescriptionAdminDetail;
		var objVal = obj.value;

		if (trimCheck(objVal) != "") {
			var str_val = document.formIVPrescriptionDrugDetails.STRENGTH_VALUE.value;
			str_val		= Math.ceil(str_val/objVal);
			fluidForm.DEF_INF_PRD.value				= str_val;
			str = getHrsMinStr(str_val,adminForm.lstInfusionRateDurnUnit.value);
			adminForm.infusionOverStr.innerHTML	= str;
			fluidForm.INFUSION_PERIOD_VALUE.value	= str_val.substring(1,HrsMinStr.indexOf("H")-1);
			fluidForm.INFUSION_PERIOD_VALUE_MIN.value	= str_val.substring(HrsMinStr.indexOf("H")+4,HrsMinStr.indexOf("M")-1); 
			adminForm.INFUSION_VALUE.value			= str_val;
			adminForm.infusion_over_insert_value.value = str_val;

			if(document.formIVPrescriptionDrugDetails.INFUSION_UOM.value=="pres_uom") {
				if(document.formIVPrescriptionDrugDetails.license.value!="PHBASIC") {
					fluidForm.INFUSION_PERIOD_VALUE.value	= Math.ceil(document.formIVPrescriptionDrugDetails.pack_size.value/objVal);
					adminForm.INFUSION_VALUE.value			= Math.ceil(document.formIVPrescriptionDrugDetails.pack_size.value/objVal);
					adminForm.infusion_over_insert_value.value = str_val;
				}
			}
			if (trimCheck(fluidForm.EQVL_UOM_VALUE.value) != "" && fluidForm.INFUSION_PERIOD_VALUE.value!='0') {
				var str	=	parseFloat(frmObj.STOCK_VALUE.value/frmObj.INFUSION_PERIOD_VALUE.value)+"";
				var ind	=	str.lastIndexOf(".",str.length);
				if( str.length > ind+3)
					str	=	str.substring(0,ind+3);
				fluidForm.FLOW_VALUE.value	= str;
			}
		}
		else {
			fluidForm.DEF_INF_PRD.value				= "";
			fluidForm.INFUSION_PERIOD_VALUE.value	= "";
			adminForm.INFUSION_VALUE.value			= "";
			adminForm.infusionOverStr.innerHTML	= "";
		}
	}
}

function reloadScreens(calledFrom, patient_id, encounter_id, order_date, pat_class,order_id,or_mode) {
	MAR_app_yn = parent.frames[0].document.forms[0].MAR_app_yn.value;
	var location_type		 = parent.parent.f_header.prescription_header_form.location_type.value;
	var location_code		 = parent.parent.f_header.prescription_header_form.location_code.value;
	var take_home_medication = parent.parent.f_header.prescription_header_form.take_home_medication.value; 
	var priority			 = parent.parent.f_header.prescription_header_form.priority.value;
	var bed_num				 = parent.parent.f_header.prescription_header_form.bed_num.value;
	var room_num			 = parent.parent.f_header.prescription_header_form.room_num.value;
	var adr_count			 = parent.parent.f_header.prescription_header_form.adr_count.value;
	var bl_install_yn		 = parent.parent.f_header.prescription_header_form.bl_install_yn.value; 
	var bl_disp_charge_dtl_in_rx_yn = parent.parent.f_header.prescription_header_form.bl_disp_charge_dtl_in_rx_yn.value; 
	var resp_id				 = parent.parent.f_header.prescription_header_form.resp_id.value;
	var pract_id			 = parent.parent.f_header.prescription_header_form.pract_id.value;
	var sys_date			 = parent.parent.f_header.prescription_header_form.sys_date.value;
	var preview_rx_yn			 = parent.parent.f_header.prescription_header_form.preview_rx_yn.value;//added for ML-MMOH-CRF-0341 [IN:057179]

	if(order_date != null && order_date != "")
		sys_date = order_date;
	
	var iv_option            = parent.frames[0].document.formIVPrescriptionOptions.type.value;
	var iv_prep_yn = "";
	if(iv_option=='IVD')
		iv_prep_yn='1';
	else if(iv_option=='IVPB')
		iv_prep_yn='3';
	else if(iv_option=='IVWA')
		iv_prep_yn='5';

	if (calledFrom == "1") {

		parent.location.href = "../jsp/IVPrescription.jsp?patient_id="+patient_id+"&encounter_id="+encounter_id+"&act_patient_class="+pat_class+"&start_date="+sys_date+"&clearOrNot=Y"+"&MAR_app_yn="+MAR_app_yn+"&location_type="+location_type+"&location_code="+location_code+"&take_home_medication="+take_home_medication+"&priority="+priority+"&MAR_app_yn="+MAR_app_yn+"&iv_prep_yn="+"&bed_num="+bed_num+"&room_num="+room_num+"&adr_count="+adr_count+"&reset=Y"+"&resp_id="+resp_id+"&pract_id="+pract_id;
		//iv_prep_yn is passed as null to avoid the disabling the iv type select box.
	}
	else if (calledFrom == "2") {
		var iv_option = "N";
		if (document.formIVPrescriptionOptions.type!=null && document.formIVPrescriptionOptions.type.value == "IVD")
			iv_option = "Y";

		if(document.formIVPrescriptionOptions.type.value == "IVD"){  // Added for Bru-HIMS-CRF-347 [IN:037862] 
			iv_prep_yn='1';
			parent.f_ivdetails.location.href = "../jsp/IVPrescriptionDetailsFrame.jsp?patient_id="+patient_id+"&encounter_id="+encounter_id+"&act_patient_class="+pat_class+"&start_date="+order_date+"&iv_option="+iv_option+"&MAR_app_yn="+MAR_app_yn;
		}
		else if(document.formIVPrescriptionOptions.type.value=="IVPB"){

			iv_prep_yn = '3';
			parent.f_ivdetails.location.href		= "../jsp/IVPiggyBack.jsp?patient_id="+patient_id+"&encounter_id="+encounter_id+"&act_patient_class="+pat_class+"&start_date="+order_date+"&iv_option="+iv_option+"&MAR_app_ynMAR_app_yn="+MAR_app_yn+"&adr_count="+adr_count;
		}
		else{
			iv_prep_yn = '5'
			parent.f_ivdetails.location.href = "../jsp/IVFluidAdditives.jsp?patient_id="+patient_id+"&encounter_id="+encounter_id+"&act_patient_class="+pat_class+"&start_date="+order_date+"&iv_option="+iv_option+"&MAR_app_yn="+MAR_app_yn+"&adr_count="+adr_count;
		}
		parent.f_ivbutton.location.href  = "../jsp/IVPrescriptionButtons.jsp?patient_id="+patient_id+"&encounter_id="+encounter_id+"&act_patient_class="+pat_class+"&start_date="+order_date+"&iv_option="+iv_option+"&location_type="+location_type+"&location_code="+location_code+"&take_home_medication="+take_home_medication+"&priority="+priority+"&MAR_app_yn="+MAR_app_yn+"&iv_prep_yn="+iv_prep_yn+"&bl_install_yn="+bl_install_yn+"&bl_disp_charge_dtl_in_rx_yn="+bl_disp_charge_dtl_in_rx_yn+"&preview_rx_yn="+preview_rx_yn;
		
	}
	else if (calledFrom == "3") {
		if(parent.parent.parent.parent.parent.parent.orderMainTab !=null){
			var locnDet = parent.parent.parent.parent.parent.parent.orderMainTab.location.href;
			// if its a amend order then close the window or reload the window
			if(locnDet.indexOf('ammend') != -1){
				//window.close();
				
		    
				parent.parent.document.querySelectorAll("#dialog_tag")[parent.parent.document.querySelectorAll("#dialog_tag").length -1].close();
			}
			else
				parent.parent.parent.parent.parent.parent.orderMainTab.location.reload();
		}
		else if(parent.parent.parent.criteriaCategoryButtonFrame !=null){
			parent.parent.parent.criteriaCategoryButtonFrame.location.reload();
		}
		else
			//window.close();
			
			parent.parent.document.querySelectorAll("#dialog_tag")[parent.parent.document.querySelectorAll("#dialog_tag").length -1].close();
	}
	else if(calledFrom=="4"){
		document.location.href = "../jsp/IVPrescription.jsp?order_id="+order_id+"&patient_id="+patient_id+"&encounter_id="+encounter_id+"&act_patient_class="+pat_class+"&patient_class="+pat_class+"&start_date="+order_date+"&clearOrNot=N&or_mode=amend"+"&MAR_app_yn="+MAR_app_yn+"&resp_id="+resp_id+"&pract_id="+pract_id;
	}
}

function setEqvlUOMDetails(mode, uom_code, uom_desc, eqvl_value) {
	var frmObj = document.formIVPrescriptionFluidDetail;
	if (mode == 1) {
		frmObj.EQVL_UOM_CODE.value	= uom_code;
		frmObj.EQVL_UOM_DESC.value	= uom_desc;
		frmObj.EQVL_UOM_VALUE.value	= eqvl_value;

	}
	else if (mode == 2) {
		alert(getMessage("PH_EQU_UOM_NOT_DEFINED","PH"));
		frmObj.EQVL_UOM_CODE.value	= "";
		frmObj.EQVL_UOM_DESC.value	= "";
		frmObj.EQVL_UOM_VALUE.value	= "";

	}
}

function setFlowRate(obj, mode) {
//	document.formIVPrescriptionFluidDetail.STOCK_VALUE.value	= document.formIVPrescriptionFluidDetail.STOCK_VALUE.value;
	if(obj.name!="STOCK_UOM") {
		checkWholeNumber(obj);
		validateFlow(obj,mode);
	}
}

function getPresBase() {

	var frmObj = document.formIVPrescriptionFluidDetail;
	var bean_id		= frmObj.bean_id.value;
	var bean_name	= frmObj.bean_name.value;
	var drug_code	= frmObj.fluid.value;
	var qryString	= bean_id+"&bean_name="+bean_name+"&validate=GETPRESBASE&drug_code="+drug_code;
	submitXML(qryString, "");
}

function setPresBase(pres_base) {
	var val	=	pres_base.split("::");
	if(val!='null' && val!=undefined) {
	document.formIVPrescriptionFluidDetail.EQVL_UOM_DESC.value=val[0];
	document.formIVPrescriptionFluidDetail.STOCK_UOM.value=val[0];
	document.formIVPrescriptionFluidDetail.STOCK_UOM_CODE.value=val[1];
	document.formIVPrescriptionFluidDetail.EQVL_UOM_CODE.value=val[1];
	
	}
}

function validateFlow(obj,mode) {
	var frmObj = document.formIVPrescriptionFluidDetail;
	var objVal = obj.value;
	if (mode == "1") {
		if (objVal != "") {
			var bean_id		= frmObj.bean_id.value;
			var bean_name	= frmObj.bean_name.value;
			var base_uom	= frmObj.BASE_UOM.value;
			var qryString	= bean_id+"&bean_name="+bean_name+"&validate=GETEQVLUOM&uom_code="+objVal+"&base_uom="+base_uom;
			submitXML(qryString, "");
		}
		else {
			frmObj.EQVL_UOM_CODE.value	= "";
			frmObj.EQVL_UOM_DESC.value	= "";
			frmObj.EQVL_UOM_VALUE.value	= "";
		}
	}
	else if (mode == "3") {
		var inf_val_hr = frmObj.INFUSION_PERIOD_VALUE.value==""?0:frmObj.INFUSION_PERIOD_VALUE.value;
		var inf_val_min = frmObj.INFUSION_PERIOD_VALUE_MIN.value==""?0:frmObj.INFUSION_PERIOD_VALUE_MIN.value;
		var inf_val = getInfuseOverInMin(inf_val_hr,inf_val_min);
		inf_val = inf_val/60;
		if (trimCheck(objVal) != "" && trimCheck(inf_val) != "") {
			if (frmObj.INFUSION_PERIOD_UOM.value == "H")
				objVal = parseInt(objVal)*60;

			if(inf_val!='0') {
				var str	=	parseFloat(objVal/inf_val)+"";
				var ind	=	str.lastIndexOf(".",str.length);
				if( str.length > ind+3)
					str	=	str.substring(0,ind+3);

				frmObj.FLOW_VALUE.value = str;
			}
		}
	}
}

function checkValue(obj) {
	if (checkWholeNumber(obj)) {
		var frmObj	= document.formIVPrescriptionFluidDetail;
		var objVal	= obj.value;
		if (trimCheck(objVal) == "") {
			if ((trimCheck(frmObj.DEF_INF_PRD.value) != "" || trimCheck(frmObj.STOCK_VALUE.value) != "") && !errorFound) {
				alert(getMessage("INFS_PRD_CANT_BLANK","PH"));
				obj.focus();
				parent.f_ivadmin.document.formIVPrescriptionAdminDetail.FREQUENCY.disabled = true;
				errorFound = true;
			}
		}
		else {
			errorFound = false;
			if (parseInt(objVal) != parseInt(frmObj.DEF_INF_PRD.value) && frmObj.DEF_INF_PRD.value != "") 
				alert(getMessage("PH_FLUID_INF_PERIOD_NO_MATCH","PH"));
		
			infVal = getInfuseOverInMin(frmObj.INFUSION_PERIOD_VALUE.value,frmObj.INFUSION_PERIOD_VALUE_MIN.value);
			infVal = parseFloat(infVal)/60;
			infVal = Math.ceil((infVal*100)/100);
			parent.f_ivadmin.document.formIVPrescriptionAdminDetail.INFUSION_VALUE.value = infVal;
			parent.f_ivadmin.document.formIVPrescriptionAdminDetail.infusion_over_insert_value.value = infVal;
			parent.f_ivadmin.document.formIVPrescriptionAdminDetail.INFUSION_UOM.value = frmObj.INFUSION_PERIOD_UOM.value;
			parent.f_ivadmin.document.formIVPrescriptionAdminDetail.FREQUENCY.disabled = false;

			if (trimCheck(frmObj.STOCK_VALUE.value) != "" && objVal!='0') {
				var str	=	parseFloat(frmObj.STOCK_VALUE.value/objVal)+"";
				var ind	=	str.lastIndexOf(".",str.length);
				if( str.length > ind+3)
					str	=	str.substring(0,ind+3);

				frmObj.FLOW_VALUE.value = str;
			}
			if (trimCheck(parent.f_ivdrugs.f_sub_ivdrugs.document.formIVPrescriptionDrugDetails.INFUSION_VALUE.value) != "") {
				var str_val	= parent.f_ivdrugs.f_sub_ivdrugs.document.formIVPrescriptionDrugDetails.STRENGTH_VALUE.value;
				parent.f_ivdrugs.f_sub_ivdrugs.document.formIVPrescriptionDrugDetails.INFUSION_VALUE.value	= Math.ceil(str_val/objVal);
			}
		}
	}
}

function checkTotalInfusion(obj) {
	if (checkWholeNumber(obj)) {
		var objVal	= obj.value;
		var frmObj	= document.formIVPrescriptionAdminDetail;
		var frmObj1	= parent.f_ivfluid.document.formIVPrescriptionFluidDetail

		if (trimCheck(frmObj1.INFUSION_PERIOD_VALUE.value) != "" || trimCheck(frmObj1.INFUSION_PERIOD_VALUE_MIN.value != "")) {
			infVal = getInfuseOverInMin(frmObj.INFUSION_PERIOD_VALUE.value,frmObj.INFUSION_PERIOD_VALUE_MIN.value);
			infVal = parseFloat(infVal)/60;
			infVal = Math.ceil((infVal*100)/100);
			parent.f_ivadmin.document.formIVPrescriptionAdminDetail.infusion_over_insert_value.value = infVal;

			var fluid_inf_prd = parseFloat(infVal);
			var total_inf_prd = "";
			if (trimCheck(objVal) != "") {
				total_inf_prd = parseInt(objVal);
			}
			if (total_inf_prd < fluid_inf_prd) {
				frmObj.FREQUENCY.value		= "";
				alert(getMessage("PH_TOT_INFUSION_LESS_THAN_FLUID_INFUSION","PH"));
			}
		}
	}
}

async function showMonoGraph(drug_desc, mono_graph, daily_dose, unit_dose, min_daily_dose, min_unit_dose,dosage_unit, dosage_std,dose_unit_desc,max_daily_ceeling_dose,min_daily_ceeling_dose,max_unit_ceeling_dose,min_unit_ceeling_dose,dose_unit_desc1) {//Modified for IN:070451
	var dialogTop		= "310";
 	var dialogHeight	= "30vh";
 	var dialogWidth		= "50vw";
	var dialogLeft		= "180";
 	var features		= "Width:" + dialogWidth + "; dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +"; dialogLeft:" + dialogLeft +"; dialogTop:" + dialogTop +"; scroll=no; status=no";
 	var arguments		= "";
 	var retVal 			= await window.showModalDialog("../jsp/PrescriptionDosageLimitMonoGraph.jsp?drug_desc="+escape(drug_desc)+"&mono_graph="+mono_graph+"&daily_dose="+daily_dose+"&unit_dose="+unit_dose+"&min_daily_dose="+min_daily_dose+"&min_unit_dose="+min_unit_dose+"&dosage_unit="+dosage_unit+"&dosage_std="+dosage_std+"&dose_unit_desc="+dose_unit_desc+"&max_daily_ceeling_dose="+max_daily_ceeling_dose+"&min_daily_ceeling_dose="+min_daily_ceeling_dose+"&max_unit_ceeling_dose="+max_unit_ceeling_dose+"&min_unit_ceeling_dose="+min_unit_ceeling_dose+"&dose_unit_desc1="+dose_unit_desc1,arguments,features);//Modified for IN:070451
}

async function showAllergyDetails(generic_id, patient_id, encounter_id, generic_name, drug_name) {
	
	var dialogTop		= "310";
 	var dialogHeight	= "12";
 	var dialogWidth		= "25";
	var dialogLeft		= "240";
 	var features		= 'Width:' + dialogWidth +'; dialogHeight:' + dialogHeight + '; dialogWidth:' + dialogWidth +'; dialogLeft:' + dialogLeft +';  dialogTop:'+dialogTop +'; scroll=auto; status=no';
 	var arguments		= "";
 	var retVal 			=await window.showModalDialog("../jsp/PrescriptionAllergyDetailsFrames.jsp?generic_name="+generic_name+"&encounter_id="+encounter_id+"&generic_id="+generic_id+"&patient_id="+patient_id+"&drug_name="+ drug_name,arguments,features);
}

async function callCurrentMedication(patient_id, encounter_id, generic_id,patient_class) {
		//alert("3");
	if(generic_id == undefined)
		generic_id="";
	var dialogHeight	= "900px";
	var dialogWidth		= "800px";
	var dialogTop		= "";
	var center			= "1";
	var status			= "no";
	var features		= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop;
	var arguments		= "";
	var retVal			= await window.showModalDialog("../jsp/PrescriptionActiveOrderDetailsFrame.jsp?patient_id="+patient_id+"&encounter_id="+encounter_id+"&generic_id="+generic_id+"&patient_class="+patient_class+"&called_frm=PH",arguments,features);
}

async function showOverRideRemarks() {
	var frmObj			= parent.f_sub_ivdrugs.document.formIVPrescriptionDrugDetails;
	var patient_id		= frmObj.patient_id.value;
	var encounter_id	= frmObj.encounter_id.value;
	var generic_id		= frmObj.GENERIC_ID.value;
	var generic_name	= frmObj.GENERIC_NAME.value;
	var drug_desc		= frmObj.DRUG_NAME.value;
	var daily_dose		= frmObj.DAILY_DOSE.value;
	var unit_dose		= frmObj.UNIT_DOSE.value;
	var mono_graph		= frmObj.MONO_GRAPH.value;
	var limit_ind		= frmObj.LIMIT_IND.value;
	var allergy_yn		= frmObj.ALLERGY_YN.value;
	var current_rx		= frmObj.CURRENT_RX.value;
	var drug_code		= frmObj.DRUG_CODE.value;
	var srl_no			= frmObj.SRL_NO.value;
	var allergy			= frmObj.ALLERGY_DESC.value;
	var exceed_dose		= frmObj.EXCEED_DOSE_DESC.value;
	var dup_drug		= frmObj.DUP_DRUG_DESC.value;
	var min_unit_dose	= frmObj.MIN_UNIT_DOSE.value;
	var min_daily_dose	= frmObj.MIN_DAILY_DOSE.value;
	var dosage_std	= frmObj.dosage_std.value;
	var dosage_unit	= frmObj.dosage_unit.value;
	var abuse_exists        = frmObj.abuse_exists.value;//added for aakh-crf-0140
	var abuse_action        = frmObj.abuse_action.value;//added for aakh-crf-0140
//alert("abuse_action"+abuse_action);
//alert("abuse_exists"+abuse_exists);
	//Added for IN:070451 start
	var max_daily_ceeling_dose	= frmObj.max_daily_ceeling_dose.value;
	var min_daily_ceeling_dose	= frmObj.min_daily_ceeling_dose.value;
	var max_unit_ceeling_dose	= frmObj.max_unit_ceeling_dose.value;
	var min_unit_ceeling_dose	= frmObj.min_unit_ceeling_dose.value;
	//Added for IN:070451 end
        //Added for IN:072715 start
	var allergy_remarks_code=frmObj.allergy_remarks_code.value;
	var dose_remarks_code=frmObj.dose_remarks_code.value;
	var currentrx_remarks_code=frmObj.currentrx_remarks_code.value;
	var abuse_override_remarks=frmObj.abuse_override_remarks.value;//added for aakh-crf-0140
	//Added for IN:072715 end
	var dialogHeight	= "50vh";
//||(abuse_exists="Y" && abuse_action="B")
	if(current_rx=="Y" && limit_ind=="N" && allergy_yn=="Y")
		dialogHeight	= "50vh";
	else if ( (current_rx=="Y" && limit_ind=="N") || (current_rx=="Y" && allergy_yn=="Y") || (limit_ind=="N" && allergy_yn=="Y" ))
		dialogHeight	= "50vh";
	else
		dialogHeight	= "50vh";

	var dialogWidth	= "50vw";
	var dialogTop	= "";
	var dialogLeft	= "";
	var center		= "0";
	var status		= "no";
	var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop+"; dialogLeft :"+dialogLeft;
	var arguments	= "";
	//retArray		= window.showModalDialog("../jsp/PrescriptionOverRideReason.jsp?gen_id="+generic_id+"&gen_name="+escape(generic_name)+"&pat_id="+patient_id+"&enc_id="+encounter_id+"&drug_desc="+escape(drug_desc)+"&mono_graph="+escape(mono_graph)+"&daily_dose="+daily_dose+"&unit_dose="+unit_dose+"&allergy_yn="+allergy_yn+"&current_rx="+current_rx+"&limit_ind="+limit_ind+"&drug_code="+drug_code+"&srl_no="+srl_no+"&allergy="+escape(allergy)+"&exceed_dose="+escape(exceed_dose)+"&dup_drug="+escape(dup_drug)+"&min_unit_dose="+min_unit_dose+"&min_daily_dose="+min_daily_dose+"&dosage_std="+dosage_std+"&dosage_unit="+dosage_unit, arguments, features);
	//+"&abuse_action="+abuse_action+"&abuse_exists="+abuse_action added for aakh-crf-0140
	retArray		=await  top.window.showModalDialog("../../ePH/jsp/PrescriptionOverRideReason.jsp?gen_id="+generic_id+"&gen_name="+encodeURIComponent(generic_name,"UTF-8")+"&pat_id="+patient_id+"&enc_id="+encounter_id+"&drug_desc="+encodeURIComponent(drug_desc,"UTF-8")+"&mono_graph="+encodeURIComponent(mono_graph,"UTF-8")+"&daily_dose="+daily_dose+"&unit_dose="+unit_dose+"&allergy_yn="+allergy_yn+"&current_rx="+current_rx+"&limit_ind="+limit_ind+"&drug_code="+drug_code+"&srl_no="+srl_no+"&allergy="+encodeURIComponent(allergy,"UTF-8")+"&exceed_dose="+encodeURIComponent(exceed_dose,"UTF-8")+"&dup_drug="+encodeURIComponent(dup_drug,"UTF-8")+"&min_unit_dose="+min_unit_dose+"&min_daily_dose="+min_daily_dose+"&dosage_std="+dosage_std+"&dosage_unit="+dosage_unit+"&max_daily_ceeling_dose="+max_daily_ceeling_dose+"&min_daily_ceeling_dose="+min_daily_ceeling_dose+"&max_unit_ceeling_dose="+max_unit_ceeling_dose+"&min_unit_ceeling_dose="+min_unit_ceeling_dose+"&allergy_remarks_code="+allergy_remarks_code+"&dose_remarks_code="+dose_remarks_code+"&currentrx_remarks_code="+currentrx_remarks_code+"&abuse_action="+abuse_action+"&abuse_exists="+abuse_exists+"&abuse_override_remarks="+abuse_override_remarks, arguments, features);//Modified for IN:070451,Modified for IN:072715

	if ( retArray != null && retArray != "" ) {
		var split_vals	= retArray.split(":::");
		frmObj.ALLERGY_DESC.value		= split_vals[0];
		frmObj.EXCEED_DOSE_DESC.value	= split_vals[1];
		frmObj.DUP_DRUG_DESC.value		= split_vals[2];
		//Added for IN:072715 start
		frmObj.allergy_remarks_code.value		= split_vals[3];
		frmObj.dose_remarks_code.value	= split_vals[4];
		frmObj.currentrx_remarks_code.value		= split_vals[5];
		frmObj.ABUSE_OVERRIDE.value	= split_vals[6];//added for aakh-crf-0140
		frmObj.abuse_override_remarks.value		= split_vals[7];//added for aakh-crf-0140
		
		//Added for IN:072715  end
	}
}

function getFormatId(calledFrom, click_yn) {

	var formObj			= "";
	var drug_code		= "";
	var mode			= "";
	if (calledFrom == "Drug") {
		formObj		= document.formIVPrescriptionDrugDetails;
		drug_code	= formObj.DRUG_CODE.value;
		mode		= formObj.mode.value;
	}
	else if (calledFrom == "Fluid") {
		formObj		= document.formIVPrescriptionFluidDetail;
		drug_code	= formObj.fluid.value;
	}

	var order_type	= formObj.ORDER_TYPE_CODE.value;
	var form_code	= formObj.FORM_CODE.value;
	var route_code	= formObj.ROUTE_CODE.value;
	var bean_id		= formObj.bean_id.value;
	var bean_name	= formObj.bean_name.value;
	var qryString	= bean_id+"&bean_name="+bean_name+"&validate=GETFORMATID&order_type="+order_type+"&form_code="+form_code+"&route_code="+route_code+"&drug_code="+drug_code+"&called_frm="+calledFrom+"&mode="+mode+"&click_yn="+click_yn;
	submitXML(qryString, "");
}

function clearArray(){
	pres_vals	=	new Array();
	i=0;
}

function prescriptionValues(vals) {
	pres_vals[i++] = vals;
}
/*
function validateRemarks(format_id, calledFrom)	{
	var format	= format_id.split("~");
	formatId	= format[1];
	callOrder(calledFrom);
}
*/
function callOrder(format_id,calledFrom, catalog_code, form_code, route_code, click_yn) {
	var format	= format_id.split("~");
	formatId	= format[1];
	var frmObj = "";
	//added for [IN:039576]-start
	var mandatory	=	format[0];
	if(mandatory == undefined || mandatory== null || mandatory=='null' || mandatory=='')
		mandatory="N";
/*	var vals = "";
	var drug_code = "";
	for(i=0; i<pres_vals.length; i++)	{
		if(i==pres_vals.length)
			vals	+= pres_vals[i];
		else
			vals	+= pres_vals[i]+ "::";
	}*/
	document.formIVPrescriptionDrugDetails.DrugRemarksMandImg.style.display = 'none';
	document.formIVPrescriptionDrugDetails.DrugRemarksMandatory.value =mandatory;//added for [IN:039576]-end
	if (calledFrom == "Drug") {
		frmObj = document.formIVPrescriptionDrugDetails
		//drug_code = document.formIVPrescriptionDrugDetails.DRUG_CODE.value;
	}
	else if (calledFrom == "Fluid") {
		frmObj = document.formIVPrescriptionFluidDetail
		//drug_code = document.formIVPrescriptionFluidDetail.FLUID_CODE.value;
	}
	
	if(format == null || format=='' || formatId==null || formatId=='')//if&else block added for SKR-SCF-0140 -start
		document.getElementById('drug_remarks').style.display = 'none';
	else{
		document.getElementById('drug_remarks').style.display = 'inline';
		if(mandatory == 'Y'){	//added for SKR-SCF-0140 
			document.getElementById('DrugRemarksMandImg').style.display = 'inline';
		}
	}
	if(click_yn == 'Y')
		callRemarks(frmObj, formatId, catalog_code, 'PH', '0', 'PH', form_code, route_code);
}

async function callRemarks(frmObj, format_id, catalog_code, order_category, row_value, called_from, form_code, route_code) {
	
	patient_id		= frmObj.patient_id.value;
	encounter_id	= frmObj.encounter_id.value;
	//42586 start
	var order_id="";
	if(frmObj.order_id!=undefined )
		order_id	= frmObj.order_id.value;
 var order_line_num="";
 if(frmObj.order_line_num!=undefined )
	 order_line_num	= frmObj.order_line_num.value;
// 42586 end
	DrugRemarksEntered	=frmObj.DrugRemarksEntered.value; //added for [IN:039576]
	bean_id			= "@orderentrybean"+patient_id+encounter_id;
	bean_name		= "eOR.OrderEntryBean";

	var dialogHeight= "50vh";
	var dialogWidth	= "50vw";
	var dialogTop	= "";
	var center		= "1";
	var status		= "no";
	var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop;
	var arguments	= "";

	//var retVal		= window.showModalDialog("../../eOR/jsp/OrderEntryOrderFormatFrameSet.jsp?bean_id="+bean_id+"&bean_name="+bean_name+"&format_id="+format_id+"&p_catalog_code="+catalog_code+"&catalog_code="+catalog_code+"&p_form_code="+form_code+"&p_route_code="+route_code+"&order_category="+order_category+"&row_value=0&called_from=PH",arguments,features);//42586
	var retVal		=await top.window.showModalDialog("../../eOR/jsp/OrderEntryOrderFormatFrameSet.jsp?bean_id="+bean_id+"&bean_name="+bean_name+"&order_id="+order_id+"&order_line_num="+order_line_num+"&format_id="+format_id+"&p_catalog_code="+catalog_code+"&catalog_code="+catalog_code+"&p_form_code="+form_code+"&p_route_code="+route_code+"&order_category="+order_category+"&row_value=0&called_from=PH",arguments,features);//42586
	if(retVal!=undefined ){
		var retVals = retVal.split('~');
		//if(retVal!=undefined && retVal=='Y' && DrugRemarksEntered!='Y') 
		if(retVals[0]=='Y' && DrugRemarksEntered!='Y') //if block added for [IN:039576]
			frmObj.DrugRemarksEntered.value = 'Y'
	}
}

function assignValue(obj) {
	if(obj.checked==true)
		obj.value="Y";
	else
		obj.value="N";
}

function checkScheduledYN(objVal, mode) {
	var formObj		= document.formIVPrescriptionAdminDetail;

	if (objVal != "") {
		if (mode == undefined)
			mode = "";
		else if (mode == "1")
			formObj		= parent.f_ivadmin.document.formIVPrescriptionAdminDetail
		else if (mode == "2")
			formObj		= parent.parent.f_ivadmin.document.formIVPrescriptionAdminDetail
		else if(mode == "or_amend")
			formObj		= parent.f_ivadmin.document.formIVPrescriptionAdminDetail

		var bean_id		= formObj.BEAN_ID.value;
		var bean_name	= formObj.BEAN_NAME.value;
		var qryString	= bean_id+"&bean_name="+bean_name+"&validate=GETSCHEDULEDFREQORNOT&freq_code="+objVal+"&mode="+mode;
		submitXML(qryString, "");
	}
	else {
		if(document.formIVPrescriptionAdminDetail != null){
			document.formIVPrescriptionAdminDetail.REPEAT_VALUE.value	= "";
			document.formIVPrescriptionAdminDetail.FREQ_NATURE.value	= "";
		}
		else if(parent.f_ivadmin.formIVPrescriptionAdminDetail != null){
			parent.f_ivadmin.formIVPrescriptionAdminDetail.REPEAT_VALUE.value	= "";
			parent.f_ivadmin.formIVPrescriptionAdminDetail.FREQ_NATURE.value	= "";
		}
	}
}

function setSchedFreqActivated(objVal, repeat_value, mode, freq_nature) {
	var frmObj	= document.formIVPrescriptionAdminDetail;
	if (mode == "1")
		frmObj	= parent.f_ivadmin.document.formIVPrescriptionAdminDetail;
	else if (mode == "2")
		frmObj	= parent.parent.f_ivadmin.document.formIVPrescriptionAdminDetail;
	else if(mode=="or_amend")
		frmObj	= parent.f_ivadmin.document.formIVPrescriptionAdminDetail;

	var obj		= frmObj.SCHED_MEDN;
	if (eval(objVal)) {
		obj.disabled = false;
		if(mode=="or_amend")
			document.getElementById('SCHED_MEDN_YN').value = "Y";
	}
	else {
		obj.disabled = true;
	}

	frmObj.REPEAT_VALUE.value = repeat_value;
	frmObj.FREQ_NATURE.value = freq_nature;
	toggleDuration(mode);
	frmObj.DURN_VALUE.options(1).selected=true;
	chkDuration(frmObj.DURN_VALUE,mode);
}

function toggleDuration(mode) {
	var frmObj = document.formIVPrescriptionAdminDetail;
	if (mode == "1" )
		frmObj = parent.f_ivadmin.document.formIVPrescriptionAdminDetail;
	else if (mode == "2")
		frmObj = parent.parent.f_ivadmin.document.formIVPrescriptionAdminDetail;
	else if(mode=="or_amend")
		frmObj = parent.f_ivadmin.document.formIVPrescriptionAdminDetail;

	if (frmObj.FREQ_NATURE.value == "O") {
		clearData(frmObj.DURN_VALUE, "1");
		addData("1", frmObj.INFUSION_VALUE.value, frmObj.DURN_VALUE);
		frmObj.DURN_VALUE.value		= "1";
		frmObj.DURN_UNIT.value		= frmObj.INFUSION_UOM.value;
		frmObj.DURN_VALUE.disabled	= true;
		frmObj.DURN_UNIT.disabled	= true;
		chkDuration(frmObj.DURN_VALUE, "1");
	}
	else if (frmObj.FREQ_NATURE.value == "F" || frmObj.FREQ_NATURE.value == "I" || frmObj.FREQ_NATURE.value == "C") {
		frmObj.DURN_UNIT.value		= "H";
		frmObj.DURN_VALUE.disabled	= false;
		frmObj.DURN_UNIT.disabled	= true;
		var bean_id					= frmObj.BEAN_ID.value;
		var bean_name				= frmObj.BEAN_NAME.value;
		var qryString				= bean_id+"&bean_name="+bean_name+"&validate=POPULATEDURNVALS&mode="+mode;
		submitXML(qryString, "");
	}
}

async function previewRX(title_display,default_comp_fluid_falg) {//default_comp_fluid_falg added for ML-MMOH-CRF-1223
	if (chkMandatoryFlds("Preview",default_comp_fluid_falg)) {//default_comp_fluid_falg added for ML-MMOH-CRF-1223
		if( parent.f_ivselect != undefined){
			var optionForm	= parent.f_ivselect.document.formIVPrescriptionOptions;
			var drgdtlsForm	= parent.f_ivdetails.f_iv_drug_details.f_sub_ivdrugs.document.formIVPrescriptionDrugDetails;
			var fluidForm	= parent.f_ivdetails.f_iv_fluid.document.formIVPrescriptionDetails;
			var adminForm	= parent.f_ivdetails.f_iv_admin.document.formIVPrescriptionAdminDetail;
		}
		else {
			var optionForm	= parent.f_options.formIVPrescriptionOptions;
			var drgdtlsForm	= parent.f_detail.f_iv_drug_details.f_sub_ivdrugs.document.formIVPrescriptionDrugDetails;
			var fluidForm	= parent.f_detail.f_iv_fluid.document.formIVPrescriptionDetails;
			var adminForm	= parent.f_detail.f_iv_admin.document.formIVPrescriptionAdminDetail;
		}
//		var titletext		  = getLabel("ePH.IV_WITH_ADDTVS.label","PH");
		var titletext		  = title_display;

		var patient_id		  = drgdtlsForm.patient_id.value;
		var encounter_id	  = drgdtlsForm.encounter_id.value;
		var date			  = drgdtlsForm.start_date.value;
		var headerForm	= "";
		
		var mode= drgdtlsForm.mode.value; //Added for MMS-DM-CRF-0177
		
		if(drgdtlsForm.mode.value != "amend")
			headerForm	= parent.parent.f_header.prescription_header_form;		
		else
			headerForm	= parent.f_header.prescription_header_form;

		var patient_class	  = headerForm.patient_class.value;
		var ord_date		  = headerForm.sys_date.value;
		var pract_name		  = drgdtlsForm.pract_name.value;
		if(pract_name!=null && pract_name!="")
			pract_name = encodeURIComponent(pract_name);
		var bean_id			  = drgdtlsForm.bean_id.value;
		var bean_name		  = drgdtlsForm.bean_name.value;
		var fluid_code		  = fluidForm.fluid.options[fluidForm.fluid.selectedIndex].value;
		var fluid_name		  = fluidForm.fluid.options[fluidForm.fluid.selectedIndex].text;
		var infusion_rate	  = adminForm.INFUSION_VALUE.value;
		var infusion_over	  = adminForm.infusion_over_insert_value.value;
		var infusion_period_value = adminForm.INFUSION_PERIOD_VALUE.value;
		var infusion_period_value_min = adminForm.INFUSION_PERIOD_VALUE_MIN.value;
		
	//	var infusion_over_min	  = adminForm.INFUSION_PERIOD_VALUE_MIN.value;
	//	infuseOver = parseFloat(getInfuseOverInMin(infusion_over,infusion_over_min));

	//	infuseOver = parseFloat(infuseOver/60);
	//	infuseOver =Math.round((infuseOver*100)/100);

		var infusion_rate_uom = adminForm.INFUSION_UOM_DISPLAY.value;
		var lstInfusionRateDurnUnit = adminForm.lstInfusionRateDurnUnit.value;
		if(drgdtlsForm.mode.value == "amend")
			infusion_rate_uom = fluidForm.stock_uom_code.value;

		var freq_desc		= adminForm.freq_desc.value;
		var start_date		= adminForm.START_DATE.value;
		var end_date		= adminForm.END_DATE.value;
		var locn_code		= adminForm.LOCN_CODE.value;
		var tot_inf_volume	= fluidForm.STOCK_VALUE.value;

		var durn_value		= adminForm.DURN_VALUE.value;
		var iv_calc_infuse_by = adminForm.iv_calc_infuse_by.value;
		if(parseFloat(infusion_over) > parseFloat(durn_value) && !errorFound && iv_calc_infuse_by!='I'){
			alert(getMessage("DURATION_CANNOT_LESSTHAN","PH"));
			adminForm.INFUSION_PERIOD_VALUE.focus();
			errorFound = true;
			return false;
		}
		else{
			errorFound = false;
		}

		if (optionForm.type.value == "IVA") 
			titletext = getLabel("ePH.IV_ADMX.label","PH");

		var dialogHeight= "69vh";
		var dialogWidth	= "70vw";
		var dialogTop	= "";
		var center		= "1";
		var status		= "no";
		var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop;
		var arguments	= "";
		durn_value = durn_value==""?"0":durn_value;
		var retVal		=await  top.window.showModalDialog("../../ePH/jsp/IVPrescriptionPreviewFrames.jsp?titletext="+encodeURIComponent(titletext,"UTF-8")+"&patient_id="+patient_id+"&encounter_id="+encounter_id+"&date="+ord_date+"&locn_code="+locn_code+"&pract_name="+encodeURIComponent(pract_name,"UTF-8")+"&actual_patient_class="+patient_class+"&fluid_name="+encodeURIComponent(fluid_name,"UTF-8")+"&fluid_flow_rate="+""+"&fluid_inf_prd="+""+"&tot_inf_volume="+tot_inf_volume+"&frequency="+""+"&start_date="+start_date+"&end_date="+end_date+"&tot_inf_uom="+""+"&fluid_volume_uom="+""+"&fluid_code="+fluid_code+"&infusion_rate="+infusion_rate+"&infusion_over="+infusion_over+"&infusion_over_uom=H"+"&infusion_rate_uom="+infusion_rate_uom+"&freq_desc="+encodeURIComponent(freq_desc,"UTF-8")+"&durn_value="+durn_value+"&lstInfusionRateDurnUnit="+lstInfusionRateDurnUnit+"&infusion_period_value="+infusion_period_value+"&infusion_period_value_min="+infusion_period_value_min+"&mode="+mode, arguments, features); //mode added for MMS-DM-CRF-0177
		if(retVal!= undefined && retVal=='R') //if block added for ML-BRU-SCF-0533 [IN:036030]
			document.formIVPrescriptionButtons.RELEASE.click();
	}
}

function releaseRX(default_comp_fluid_falg){//default_comp_fluid_falg added for ML-MMOH-CRF-1223					                               
	if(parent.f_ivbutton!=undefined){
	var dflt_disp_locn_lbl= parent.f_ivbutton.document.getElementById('dflt_disp_locn_lbl').innerText;//NMC-JD-CRF-0063 [TFS:15129] START
	var dflt_disp_locn = dflt_disp_locn_lbl.replace(/\s+/g, ""); 
	var headerForm = parent.parent.f_header.prescription_header_form;
	var act_patient_class = headerForm.actual_patient_class.value;
	if(act_patient_class == "OP"){
		if( dflt_disp_locn== "" || dflt_disp_locn ==null  ) 
		{
			alert(getMessage("PH_MANDATORY", "PH"));
			return false;
		}
	}//END
	}
	if(parent.name == "f_prescription")	
		var formAdminObj = parent.frames[1].frames[2].formIVPrescriptionAdminDetail;
	else
		var formAdminObj =  parent.parent.frames[1].frames[2].frames[2].formIVPrescriptionAdminDetail;
	if(formAdminObj.mode.value !="amend")	
	{
		if (parseFloat(formAdminObj.DURN_VALUE.value)  > 24 )   //added for SKR-SCF-1392
		{
			alert(getMessage("IV_DURATION_CANNOT_GREATER","PH"));
			adminForm.DURN_VALUE.focus();
		}   
		else
		{
			releaseRXOrders(default_comp_fluid_falg);//default_comp_fluid_falg added for ML-MMOH-CRF-1223
		}
	}
    else
    {
    	if (parseFloat(formAdminObj.DURN_VALUE.value)  > 24 )   //added for SKR-SCF-1392
		{
			alert(getMessage("IV_DURATION_CANNOT_GREATER","PH"));
			adminForm.DURN_VALUE.focus();
		}   
		else
		{
			 releaseRXAmend(); 
		}
    }
}
async function releaseRXOrders(default_comp_fluid_falg) {//default_comp_fluid_falg added for ML-MMOH-CRF-1223
	if (chkMandatoryFlds("Release",default_comp_fluid_falg)) {//default_comp_fluid_falg added for ML-MMOH-CRF-1223
		if(parent.f_ivdetails != undefined){
			var fluidForm	= parent.f_ivdetails.f_iv_fluid.document.formIVPrescriptionDetails;
			var adminForm	= parent.f_ivdetails.f_iv_admin.document.formIVPrescriptionAdminDetail;
			var headerForm = parent.parent.f_header.prescription_header_form;
		} 
		else {
			var fluidForm	= parent.f_detail.f_iv_fluid.document.formIVPrescriptionDetails;
			var adminForm	= parent.f_detail.f_iv_admin.document.formIVPrescriptionAdminDetail;
			var headerForm = parent.f_header.prescription_header_form;
		}
	//	var drgdtlsForm	= parent.f_sub_ivdrugs.document.formIVPrescriptionDrugDetails;
		var drgdtlsForm	= parent.f_ivdetails.f_iv_drug_details.f_sub_ivdrugs.document.formIVPrescriptionDrugDetails;
		
	//	var drgdtlsForm	= parent.f_detail.f_iv_drug_details.f_sub_ivdrugs.document.formIVPrescriptionDrugDetails;
		
		//alert(drgdtlsForm.CALC_DOSE_BASED_ON[0]);
		//alert(drgdtlsForm.CALC_DOSE_BASED_ON[0].checked);
	//	alert(drgdtlsForm.DRUG_NAME.value);
		if(drgdtlsForm.DRUG_NAME.value !=""){
		if (drgdtlsForm.CALC_DOSE_BASED_ON != null && drgdtlsForm.CALC_DOSE_BASED_ON != undefined && drgdtlsForm.CALC_DOSE_BASED_ON[0] !=null && drgdtlsForm.CALC_DOSE_BASED_ON[0] != "null" && drgdtlsForm.CALC_DOSE_BASED_ON[0] != "undefined" && drgdtlsForm.CALC_DOSE_BASED_ON[0] != undefined && drgdtlsForm.CALC_DOSE_BASED_ON[0].checked &&((trimCheck(drgdtlsForm.STRENGTH_VALUE.value) == "") || (parseFloat(drgdtlsForm.STRENGTH_VALUE.value) == 0) || (trimCheck(drgdtlsForm.STRENGTH_VALUE.value) == "null"))) {
			alert(getMessage("STR_VAL_CANT_BLANK_ZERO","PH"));
			drgdtlsForm.STRENGTH_VALUE.select();
			return false;
		}
		else if (drgdtlsForm.CALC_DOSE_BASED_ON != null && drgdtlsForm.CALC_DOSE_BASED_ON != undefined  && drgdtlsForm.CALC_DOSE_BASED_ON[1].checked && ((trimCheck(drgdtlsForm.STRENGTH_VALUE.value) == "") || (parseFloat(drgdtlsForm.STRENGTH_VALUE.value) == 0)|| (trimCheck(drgdtlsForm.STRENGTH_VALUE.value) == "null"))) {
			alert(getMessage("STR_VAL_CANT_BLANK_ZERO","PH"));
			drgdtlsForm.strength_value_wt_bsa.select();
			return false;
		}
		
		else{
			
		}
		}
		headerForm.buildMAR_yn.value = fluidForm.buildMAR_yn.value; //added for  MMS-QH-CRF-0080 [IN:038064]
		
		var validate_overide_on_confirm_yn = "N"; //added for IN069887
		
		var ord_date_time	= headerForm.sys_date.value;
		var allergic_yn ="N";
		if( headerForm != null){
			var th_medn		= "N";
			if(headerForm.take_home_medication.checked==true)  //RUT-CRF-0062 Added to insert into OR_ORDER Table
				th_medn="D";
			var height		= headerForm.height.value;
			var height_unit	= headerForm.height_unit.value;
			if (height_unit == "")
				height_unit	= "Cms";

			var weight		= headerForm.weight.value;
			var weight_unit	= headerForm.weight_unit.value;
			if (weight_unit == "")
				weight_unit	= "Kgs";

			var bsa			= headerForm.bsa.value;
			var bsa_unit	= "BSA";
			var bmi			= headerForm.bmi.value;
			var priority	= headerForm.priority.value;
			
			if( headerForm.allergic_yn.value == "NO") 
				allergic_yn	=	"N";	
			else
				allergic_yn	=	"Y";	
		}
		if(fluidForm.admixture.value=="Y")
			iv_presc_yn	=	"I";
		else
			iv_presc_yn	=	"N";

		fluidForm.STOCK_VALUE.value = fluidForm.stock_value.value;
		var bean_id		= adminForm.BEAN_ID.value;
		var bean_name	= adminForm.BEAN_NAME.value;
		var	patient_id = fluidForm.patient_id.value;
		var encounter_id = fluidForm.encounter_id.value;
		//var patient_class = fluidForm.patient_class.value;
		var patient_class = headerForm.patient_class.value;
		fluidForm.patient_class.value = patient_class;

		var volume     =	fluidForm.STOCK_VALUE.value;
		if(fluidForm.buildMAR_yn.checked == true)
			buildMAR_yn     = "Y"	;
		else
			buildMAR_yn = "N";
		var iv_calc_infuse_by = adminForm.iv_calc_infuse_by.value //Added for SKR-CRF-0035 [IN:037727] -Start
		if(iv_calc_infuse_by=='I'){
			adminForm.DURN_VALUE.value=adminForm.infusion_over_insert_value.value;
		}//Added for SKR-CRF-0035 [IN:037727] -End

		var bl_install_yn = headerForm.bl_install_yn.value; 
		var bl_disp_charge_dtl_in_rx_yn = headerForm.bl_disp_charge_dtl_in_rx_yn.value; 
		var infuse_over_unit = adminForm.lstInfusionRateDurnUnit.value;//INO71514
		if(bl_install_yn == 'Y' && bl_disp_charge_dtl_in_rx_yn =='Y'){
			var actual_patient_class = headerForm.actual_patient_class.value
			var fluid_code		  = fluidForm.fluid.value;
			var infusion_over	  = adminForm.infusion_over_insert_value.value;
			var tot_inf_prd		= fluidForm.STOCK_VALUE.value;
			var durn_value		= adminForm.DURN_VALUE.value;
			var iv_prep_yn		= document.formIVPrescriptionButtons.iv_prep_yn.value;
            var discharge_yn	= headerForm.take_home_medication.value;
			if(parseFloat(infusion_over) > parseFloat(durn_value)){
				alert(getMessage("DURATION_CANNOT_LESSTHAN","PH"));
				adminForm.INFUSION_PERIOD_VALUE.focus();
				return false;
			}
			var xmlStr ="<root><SEARCH ";					

			xmlStr+= "patient_id =\"" + patient_id + "\" " ;
			xmlStr+= "fluid_code =\"" + fluid_code + "\" " ;
			xmlStr+= "infusion_over =\"" + infusion_over + "\" " ;
			xmlStr+= "tot_inf_prd =\"" + tot_inf_prd + "\" " ;
			xmlStr+= "durn_value =\"" + durn_value + "\" " ;
			xmlStr+= "actual_patient_class =\"" + actual_patient_class + "\" " ;
			xmlStr+= "INFUSE_OVER_UNIT =\"" + infuse_over_unit + "\" " ;//INO71514
			xmlStr +=" /></root>";

			var temp_jsp="IVPrescriptionValidate.jsp?validate=GET_BL_ERRORS_IVWA"+"&bean_id="+bean_id+"&bean_name="+bean_name+patient_id+"&encounter_id="+encounter_id+"&iv_prep_yn="+iv_prep_yn+"&infusion_over="+infusion_over+"&durn_value="+durn_value+"&discharge_yn="+discharge_yn;
			var xmlDoc = "" ;
			var xmlHttp = new XMLHttpRequest() ;
			xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
			xmlHttp.open("POST",temp_jsp,false);
			xmlHttp.send(xmlDoc);
			responseText=xmlHttp.responseText ;

			if(responseText != undefined){
				responseText = trimString(responseText);

				if(responseText != null && responseText !=""){
					if(!eval(responseText))
						return false;
				}
			}
		}
		var xmlStr		= "<root><SEARCH ";
		xmlStr			+= " PRIORITY=\""+ priority + "\" ";
		xmlStr			+= " HEIGHT=\""+ height + "\" ";
		xmlStr			+= " HEIGHT_UNIT=\""+ height_unit + "\" ";
		xmlStr			+= " WEIGHT=\""+ weight + "\" ";
		xmlStr			+= " WEIGHT_UNIT=\""+ weight_unit + "\" ";
		xmlStr			+= " BSA=\""+ bsa + "\" ";
		xmlStr			+= " BMI=\""+ bmi + "\" ";
		xmlStr			+= " BSA_UNIT=\""+ bsa_unit + "\" ";
		xmlStr			+= " IV_PRESC_YN=\""+ iv_presc_yn + "\" ";
		xmlStr			+= " TH_MEDN=\""+ th_medn + "\" ";
		xmlStr			+= " allergic_yn=\""+ allergic_yn + "\" ";		
		xmlStr			+= " ord_date_time=\""+ ord_date_time + "\" ";
		//xmlStr			+= " buildMAR_yn=\""+ buildMAR_yn + "\" ";
		xmlStr			+= " ROOM_NUM=\""+ headerForm.room_num.value + "\" ";  //Added for MMS-QH-CRF-0080 [IN:038064] 
		xmlStr			+= " BED_NUM=\""+ headerForm.bed_num.value + "\" ";    //Added for MMS-QH-CRF-0080 [IN:038064] 
		xmlStr			+= "INFUSE_OVER_UNIT =\"" + infuse_over_unit + "\" " ;//INO71514
		xmlStr			+= " validate_overide_on_confirm_yn=\""+ validate_overide_on_confirm_yn + "\" ";//Added for IN:069887 
		xmlStr			+= buildXMLString(adminForm) + buildXMLString(fluidForm) + " /></root>";
		var qryString	= bean_id+"&bean_name="+bean_name+"&validate=RELEASE"+"&patient_class="+patient_class+"&patient_id="+patient_id+"&encounter_id="+encounter_id+"&volume="+volume;
		submitXML(qryString, xmlStr);

		if (result) {
			reloadPage();
		}
		else if(flag=="INSUFFICIENT_STOCK") {
			var dialogHeight	= "12";
			var dialogWidth		= "45";
			var dialogTop		= "250";
			var dialogLeft		= "40";
			var center			= "0";
			var status			= "no";
			var features		= "dialogHeight:" + dialogHeight +"; dialogLeft:"+dialogLeft+ "; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop;
			var arguments		= "";
			retVal 				=await  window.showModalDialog("../../ePH/jsp/IVPrescriptionStockDetails.jsp?bean_id="+bean_id+"&bean_name="+bean_name,arguments,features);
		}
	}
}

async function releaseRXAmend() {
	if (chkMandatoryFlds("Release")) {
		if(parent.f_ivdetails != undefined){
			var fluidForm	= parent.f_ivdetails.f_iv_fluid.document.formIVPrescriptionDetails;
			var adminForm	= parent.f_ivdetails.f_iv_admin.document.formIVPrescriptionAdminDetail;
			var headerForm = parent.parent.f_header.prescription_header_form;
		} 
		else {
			var fluidForm	= parent.f_detail.f_iv_fluid.document.formIVPrescriptionDetails;
			var adminForm	= parent.f_detail.f_iv_admin.document.formIVPrescriptionAdminDetail;
			var headerForm = parent.f_header.prescription_header_form;
		}
		headerForm.buildMAR_yn.value = fluidForm.buildMAR_yn.value; //added for  MMS-QH-CRF-0080 [IN:038064]
		var validate_overide_on_confirm_yn= "N"; //Added for IN:069887 
		var order_id =adminForm.order_id.value;
		var allergic_yn ="N";
		if( headerForm != null){
			var th_medn		= "N";
			var height		= headerForm.height.value;
			var height_unit	= headerForm.height_unit.value;
			if (height_unit == "")
				height_unit	= "Cms";

			var weight		= headerForm.weight.value;
			var weight_unit	= headerForm.weight_unit.value;
			if (weight_unit == "")
				weight_unit	= "Kgs";

			var bsa			= headerForm.bsa.value;
			var bsa_unit	= "BSA";
			var bmi			= headerForm.bmi.value;
			var priority	= headerForm.priority.value;
			if( headerForm.allergic_yn.value == "NO")
				allergic_yn	=	"N";	
			else
				allergic_yn	=	"Y";	
		}
	
		if(fluidForm.admixture.value=="Y")
			iv_presc_yn	=	"I";
		else
			iv_presc_yn	=	"N";

		if(fluidForm.buildMAR_yn.checked == true)
			buildMAR_yn     = "Y"	;
		else
			buildMAR_yn = "N";

		fluidForm.STOCK_VALUE.value = fluidForm.stock_value.value;
		var bean_id		= adminForm.BEAN_ID.value;
		var bean_name	= adminForm.BEAN_NAME.value;
		var	patient_id = fluidForm.patient_id.value;
		var encounter_id = fluidForm.encounter_id.value;
		var patient_class = fluidForm.patient_class.value;
		var volume     =	fluidForm.STOCK_VALUE.value;
		if(adminForm.iv_calc_infuse_by.value=='I'){
			adminForm.DURN_VALUE.value=adminForm.infusion_over_insert_value.value;
		}//Added for SKR-CRF-0035 [IN:037727] -End
			
		var xmlStr		= "<root><SEARCH ";
		xmlStr			+= " PRIORITY=\""+ priority + "\" ";
		xmlStr			+= " HEIGHT=\""+ height + "\" ";
		xmlStr			+= " HEIGHT_UNIT=\""+ height_unit + "\" ";
		xmlStr			+= " WEIGHT=\""+ weight + "\" ";
		xmlStr			+= " WEIGHT_UNIT=\""+ weight_unit + "\" ";
		xmlStr			+= " BSA=\""+ bsa + "\" ";
		xmlStr			+= " BMI=\""+ bmi + "\" ";
		xmlStr			+= " BSA_UNIT=\""+ bsa_unit + "\" ";
		xmlStr			+= " IV_PRESC_YN=\""+ iv_presc_yn + "\" ";
		xmlStr			+= " TH_MEDN=\""+ th_medn + "\" ";
		xmlStr			+= " allergic_yn=\""+ allergic_yn + "\" ";
		xmlStr			+= " validate_overide_on_confirm_yn=\""+ validate_overide_on_confirm_yn + "\" ";//Added for IN:069887 
		xmlStr			+= buildXMLString(adminForm) + buildXMLString(fluidForm) + " /></root>";
		var qryString	= bean_id+"&bean_name="+bean_name+"&validate=AMENDRELEASE"+"&order_id="+order_id+"&patient_id="+patient_id+"&encounter_id="+encounter_id+"&patient_class="+patient_class+"&volume="+volume+"&buildMAR_yn="+buildMAR_yn;
	
		submitXML(qryString, xmlStr);

		if (result) 
			reloadPage();
		else if(flag=="INSUFFICIENT_STOCK") {
			var dialogHeight	= "12";
			var dialogWidth		= "45";
			var dialogTop		= "250";
			var dialogLeft		= "40";
			var center			= "0";
			var status			= "no";
			var features		= "dialogHeight:" + dialogHeight +"; dialogLeft:"+dialogLeft+ "; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop;
			var arguments		= "";
			retVal 				=await window.showModalDialog("../../ePH/jsp/IVPrescriptionStockDetails.jsp?bean_id="+bean_id+"&bean_name="+bean_name,arguments,features);
		}
	}
}

async function displaySchedule(obj) {
	var formObj		= document.formIVPrescriptionAdminDetail;
	var bean_id		= formObj.BEAN_ID.value;
	var bean_name	= formObj.BEAN_NAME.value;
	var freq_code	= formObj.FREQUENCY.value;
	var drug_code	= parent.f_ivfluid.document.formIVPrescriptionFluidDetail.fluid.value;
	if(drug_code =="") {
		alert(getMessage("FLUID_NAME_CANNOT_BE_BLANK","PH"));
		return;
	}
	var row_value	= "1";
	if(parent.parent.f_header != null)
		var facility_id		= parent.parent.f_header.document.prescription_header_form.facility_id.value;
	else
		var facility_id		= parent.f_header.document.prescription_header_form.facility_id.value;

	var	max_qty			= 0;
	var	unit_qty		= 0;
	var split_dose_yn	= "N";

	var split_qty		= parent.f_ivfluid.document.formIVPrescriptionFluidDetail.STOCK_VALUE.value;
	var qty_reqd_yn		= "N";
	var uom_desc		= parent.f_ivfluid.document.formIVPrescriptionFluidDetail.EQVL_UOM_CODE.value;
	 uom_desc=encodeURIComponent(uom_desc,"UTF-8");
	var chk_max			= "N";
	var chk_unit		= "N";

	if(max_qty != "0") 
		chk_max = "Y";

	if(unit_qty != "0") 
		chk_unit = "Y";

	uom_desc="MLL";
	if(uom_desc !="" && split_qty != "") {
		var dialogTop		= "260";
		var dialogHeight	= "14";
		var dialogWidth		= "28";
		var features		= 'Width:' + dialogWidth +'; dialogHeight:' + dialogHeight + '; dialogWidth:' + dialogWidth +'; dialogTop:'+dialogTop +'; scroll=no; status=no';
		var arguments		= "";
		var retVal 			=await window.showModalDialog("../../eOR/jsp/ScheduleFrequency.jsp?mode=1&bean_id="+bean_id+"&uom_desc="+uom_desc+"&bean_name="+bean_name+"&chk_max="+chk_max+"&chk_unit="+chk_unit+"&max_qty="+max_qty+"&split_dose_yn="+split_dose_yn+"&split_qty="+split_qty+"&qty_reqd_yn="+qty_reqd_yn+"&unit_qty="+unit_qty+"&code="+drug_code+"&row_value="+row_value+"&facility_id="+facility_id+"&freq_code="+freq_code+"&module_id=PH",arguments,features);

		if(retVal!=null) 
			formObj.SCHED_MEDN_YN.value = "Y";
		else
			formObj.SCHED_MEDN_YN.value	= "N";
	}
}

function mandateRemarks() {

	alert(getMessage("OVR_RDN_RSN-CANT_BLNK","PH"));
}

function assignResult(_result, _message, _flag, _narcotic_yn, _print_ord_sht_rule_ind) {//print_ord_sht_rule_ind Added for Bru-HIMS-CRF-393_1.0
	result	= _result;
	message	= _message;
	flag	= _flag;
	narcotic_yn = _narcotic_yn;
	print_ord_sht_rule_ind=_print_ord_sht_rule_ind;
}

async function reloadPage() {

	if(parent.f_ivdetails!=undefined){
	    var frmObj			= parent.f_ivdetails.f_iv_drug_details.f_sub_ivdrugs.document.formIVPrescriptionDrugDetails;
		var frmDrugList		= parent.f_ivdetails.f_iv_drug_details.f_drug_list.f_drugs.document.formIVPrescriptionDrugList;
		var frmFluid		= parent.f_ivdetails.f_iv_fluid.document.formIVPrescriptionDetails;
	}
	else{
		var frmObj			= parent.f_detail.f_iv_drug_details.f_sub_ivdrugs.document.formIVPrescriptionDrugDetails;
		var frmDrugList		= parent.f_detail.f_iv_drug_details.f_drug_list.f_drugs.document.formIVPrescriptionDrugList;
		var frmFluid		= parent.f_detail.f_iv_fluid.document.formIVPrescriptionDetails;
	}
//	alert(frmDrugList.drug_class_1.value);

	var headerForm		= "";
	var order_set_code  = "";

	if(parent.parent.f_header!=undefined){
	   hdrForm = parent.parent.f_header.document.prescription_header_form;
	   order_set_code  = hdrForm.order_set_code.value;
	}
	else{
		hdrForm = parent.f_header.document.prescription_header_form;
	}
	var narcotic_aprvl_form_req_yn=hdrForm.narcotic_aprvl_form_req_yn.value;
	var print_narcotic_form_by_default=hdrForm.print_narcotic_form_by_default.value;
	var print_mar_label_yn = hdrForm.print_mar_label_yn.value; //added for MMS-QH-CRF-0080 [IN:038064]
	var buildMAR_yn = hdrForm.buildMAR_yn.value; //added for MMS-QH-CRF-0080 [IN:038064]
	if(frmFluid.admixture.checked == true){ //added for MMS-QH-CRF-0080 [IN:038064]
		print_mar_label_yn="N";
	}

	if(narcotic_yn == "N"){
		narcotic_aprvl_form_req_yn = "";
		print_narcotic_form_by_default="";
	}
	var bean_id			= frmObj.bean_id.value;
	var bean_name		= frmObj.bean_name.value;
//	var patient_class	= frmObj.patient_class.value;
	var patient_class	= hdrForm.patient_class.value;
	var locn_code		= frmObj.locn_code.value;
	var qryString		= "";
	var retVal= new Array();//code added for IN49320

	if(top.content != null)
		top.content.messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num="+message;
	else{
		for(i=0;i<message.length;i++){
			if(message.charAt(i) == ".") break;
		}
		alert(message.substring(0,i+3));
	}
	if(patient_class=='OP' || patient_class=='EM'){
		var xmlStr 			="<root><SEARCH /></root>";
		var xmlDoc			= "";
		var xmlHttp			= new XMLHttpRequest();
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open("POST","IVPrescriptionValidate.jsp?bean_id="+bean_id+"&bean_name="+bean_name+"&validate=GET_TRNGROUPREF",false);
		xmlHttp.send(xmlDoc);
		responseText=xmlHttp.responseText ;
		responseText=trimString(responseText);

		if(responseText != undefined && responseText!=null && responseText !=""){
			var dialogHeight	="15" ;
			var dialogWidth	="30";
			var dialogTop	= "300" ;
			var dialogLeft	= "300" ;
			var center			= "1" ;
			var status			="no";
			var features	= "dialogHeight:" + dialogHeight +"; dialogLeft:"+dialogLeft+ "; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop;
			var arguments	= "";
			retVal =await window.showModalDialog("../../ePH/jsp/TokenListForOrders.jsp?trn_group_ref="+responseText,arguments,features);
		}
	}
	var dialogHeight	="12" ;
	var dialogWidth	="30";
	var dialogTop	= "300" ;
	var dialogLeft	= "300" ;
	var center			= "1" ;
	var status			="no";
	var features	= "dialogHeight:" + dialogHeight +"; dialogLeft:"+dialogLeft+ "; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop;
	var arguments	= "";
	if((print_ord_sht_rule_ind=="C" || print_ord_sht_rule_ind=='') || (print_mar_label_yn=="Y" && buildMAR_yn=="Y") || narcotic_aprvl_form_req_yn=="Y")//print_ord_sht_rule_ind=="C" || print_ord_sht_rule_ind=='' added for Inc : 049877
		retVal = window.showModalDialog("../../ePH/jsp/PrescriptionPrintDialog.jsp?narcotic_aprvl_form_req_yn="+narcotic_aprvl_form_req_yn+"&print_narcotic_form_by_default="+print_narcotic_form_by_default+"&called_from=IVD"+"&buildMAR_yn="+buildMAR_yn+"&print_mar_label_yn="+print_mar_label_yn+"&print_ord_sht_rule_ind="+print_ord_sht_rule_ind,arguments,features);//print_ord_sht_rule_ind Added for Bru-HIMS-CRF-393_1.0

	if(((print_ord_sht_rule_ind=="C" || print_ord_sht_rule_ind=='') && retVal != undefined && retVal[0] != "" && retVal[0] != "CANCEL") || print_ord_sht_rule_ind =='S'){//print_ord_sht_rule_ind Added for Bru-HIMS-CRF-393_1.0  && code '&& retVal != ""' added for IN49320 AND print_ord_sht_rule_ind=="C" || print_ord_sht_rule_ind=='' added for Inc : 049877
		var xmlStr ="<root><SEARCH ";
		xmlStr+= "locn_code =\"" + locn_code + "\" " ;
		xmlStr+= "patient_class =\"" + patient_class + "\" " ;
		xmlStr+= "order_set_code =\"" + order_set_code + "\" " 
		if((print_ord_sht_rule_ind=="C" || print_ord_sht_rule_ind=='') && retVal.length >0){//If and Else If  Added for Bru-HIMS-CRF-393_1.0 AND print_ord_sht_rule_ind=="C" || print_ord_sht_rule_ind=='' added for Inc : 049877
			xmlStr+=" prescriptionPrint=\""+ retVal[0] + "\" ";
			xmlStr+=" NarcoticPrint=\""+ retVal[1] + "\" ";
			xmlStr+=" MARLabelPrint=\""+ retVal[2] + "\" "; //added for MMS-QH-CRF-0080 [IN:038064]
		}
		else if(print_ord_sht_rule_ind =='S')
			xmlStr+=" prescriptionPrint=\""+ "Y"+ "\" ";
/*	if (confirm(getMessage("PH_PRINT_PRESCRIPTION","PH"))) 
		xmlStr+= "print_yn='Y'" ;
	else
		xmlStr+= "print_yn='N'" ;
*/
		xmlStr +=" /></root>";
		var temp_jsp="IVPrescriptionValidate.jsp?validate=PRINT&bean_id="+bean_id+"&bean_name="+bean_name;
		var xmlDoc = "" ;
		var xmlHttp = new XMLHttpRequest() ;

		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open("POST",temp_jsp,true);
		xmlHttp.send(xmlDoc);
	}

	if(frmObj.mode.value!="amend"){
		if(parent.parent.parent.parent.parent.parent.orderMainTab !=null){
			var locnDet = parent.parent.parent.parent.parent.parent.orderMainTab.location.href;
			// if its a amend order then close the window or reload the window
			if(locnDet.indexOf('ammend') != -1)
				//window.close();
				
		    
				parent.parent.document.querySelectorAll("#dialog_tag")[parent.parent.document.querySelectorAll("#dialog_tag").length -1].close();
			else{
				parent.parent.parent.parent.parent.parent.orderMainTab.self.location.reload();
				var isPopup = (window.location.href == window.parent.location.href);
				if(window.dialogArguments != null){
    			  //	window.close();
				
				    
					parent.parent.document.querySelectorAll("#dialog_tag")[parent.parent.document.querySelectorAll("#dialog_tag").length -1].close();
				}
				else{
				  parent.parent.parent.parent.parent.parent.orderMainTab.self.location.reload();
				  window.location.reload();
				}
			}
		}
		else if(parent.parent.parent.criteriaCategoryButtonFrame !=null){

			parent.parent.parent.criteriaCategoryButtonFrame.location.reload();
		}
	}
	else{
		//window.close();
	
		parent.parent.document.querySelectorAll("#dialog_tag")[parent.parent.document.querySelectorAll("#dialog_tag").length -1].close();
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
//     window.returnValue=retval;
//	 window.close();
	let dialogBody = parent.parent.document.getElementById('dialog-body');
    dialogBody.contentWindow.returnValue = retval;
    
    const dialogTag = parent.parent.document.getElementById("dialog_tag");    
    dialogTag.close();  
}

async function loadDrugInfo(prodid, drugdesc) {
	var dialogHeight	="85" ;
	var dialogWidth	="70";
	var dialogTop		= "110";
	var dialogLeft		= "70";
	var center			= "0";
	var status			= "no";
	var features		= "dialogHeight:" + dialogHeight +"; dialogLeft:"+dialogLeft+ "; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop;
	var arguments		= "";
	retVal 				=await  window.showModalDialog("../../ePH/jsp/DisplayDrugInfoFrames.jsp?extprodid="+prodid+"&drugdesc="+drugdesc+"&JSFile=../../ePH/js/Prescription_1.js",arguments,features);
}

async function viewInteraction(patientid, orderid, encounter_id) {
	var dialogHeight	= "18vh";
	var dialogWidth		= "40vw";
	var dialogTop		= "270";
	var dialogLeft		= "200";
	var center			= "0";
	var status			= "no";
	var features		= "dialogHeight:" + dialogHeight +"; dialogLeft:"+dialogLeft+ "; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop;
	var arguments		= "";
	retVal 				= await top.window.showModalDialog("../../ePH/jsp/DisplayInteractionsFrames.jsp?patientid="+patientid+"&orderid="+orderid+"&encounterid="+encounter_id+"&JSFile=../../ePH/js/Prescription_1.js",arguments,features);
}

function checkWholeNumber(obj) {
	var objVal	= obj.value;
	var retStat = true;
	if (trimCheck(objVal) != "") {
		for ( i = 0; i < objVal.length; i++ ) {
			if (objVal.charAt(i)<'0' || objVal.charAt(i)>'9') {
				alert(getMessage("PH_WHOLE_NUMS_ALLOWED","PH"));
				obj.focus();
				retStat = false;
				break;
			}
		}
	}
	return retStat;
}

function clearData(obj, mode) {

	if(document.formIVPrescriptionDrugDetails == undefined)
		obj =  parent.f_sub_ivdrugs.document.formIVPrescriptionDrugDetails.STRENGTH_UOM;
	obj = eval(obj);
	var len = obj.length;
	for (var i=0; i<=len; i++) {
		obj.remove("");
	}
	var opt	= document.createElement('OPTION');
	if (mode == "1") {
		opt.value =	"";
		opt.text = "--- Select ---";
		obj.add(opt);
	}
}

function addData(code, desc, obj) {

	if(document.formIVPrescriptionDrugDetails == undefined)
		obj =  parent.f_sub_ivdrugs.document.formIVPrescriptionDrugDetails.STRENGTH_UOM;

	obj = eval(obj);
	var opt	= eval(document.createElement('OPTION'));
	opt.value =	code;
	opt.text = desc;
	obj.add(opt);

}

function setDefaultData(code, frmObj, mode) {

	if(document.formIVPrescriptionDrugDetails == undefined)
		frmObj =  parent.f_sub_ivdrugs.document.formIVPrescriptionDrugDetails;

	frmObj = eval(frmObj);
	if (mode == 1) {
		frmObj.STRENGTH_UOM.value = code;
	/*	if (frmObj.QTY_DESC_CODE.value == "")
			frmObj.STRENGTH_UOM.value = code;
		else
			frmObj.STRENGTH_UOM.value = frmObj.QTY_DESC_CODE.value;  commented coz of 24963*/ 
	}
}

function changeCursor(obj) {
	obj.style.cursor = "pointer";
}

function realCol(obj, classVal) {
	obj.className = classVal;
}

function changeCol(obj) {
	obj.className = "FOCUSDRUGS";
}

function changeBorder(obj) {
	obj.className = "CLICKDRUGS";
}

function callOnMouseOver(obj) {
	obj.className = "CASECONDSELECTHORZ";
}

function callOnMouseOut(obj) {
	obj.className = "CAFIRSTSELECTHORZ";
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
				if(arrObj[i].checked) 
					val = "Y";
				else 
					val ="N";
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
				if(arrObj[i].value == null) arrObj[i].value = "";
				if(arrObj[i].name != null && arrObj[i].name != "")
					xmlStr+= arrObj[i].name+"=\"" + checkSpl(val) + "\" ";
			}
		}
	}
	return xmlStr;
}

function testResult(bean_id, bean_name, result) {
	var dialogHeight	= "20";
	var dialogWidth		= "50";
	var dialogTop		= "250";
	var center			= "1";
	var status			= "no";
	var features		= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop;
	var arguments		= "";
	window.open("../jsp/IVtemp.jsp?bean_id="+bean_id+"&bean_name="+bean_name+"&result="+result, arguments, features);
}

function defaultFlowUom(obj) {
	document.formIVPrescriptionFluidDetail.INFUSION_PERIOD_VALUE.focus();
	document.getElementById('flow_unit').innerText	=	" / "+obj.options(obj.selectedIndex).text;
}

function saveIVAmendRemarks(obj,patient_id,encounter_id){

    var remarks=obj.order_remarks.value;
    var bean_id= "@IVPrescriptionBean"+patient_id+encounter_id;
    var bean_name="ePH.IVPrescriptionBean";
    var page_mode=obj.page_mode.value;
	var mode=obj.mode.value;
    var srl_no=obj.srl_no.value;
    
    var xmlStr ="<root><SEARCH ";
    xmlStr += " bean_id=\""+ bean_id + "\" ";
    xmlStr += " bean_name=\""+ bean_name + "\" ";
    xmlStr += " page_mode=\""+ page_mode + "\" ";
    xmlStr += " remarks=\""+ remarks + "\" ";
    xmlStr += " srl_no=\""+ srl_no + "\" ";
    xmlStr +=" /></root>";
    
    var xmlDoc = "" ;
    var xmlHttp = new XMLHttpRequest() ;
    xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
    xmlHttp.open("POST","IVPrescriptionValidate.jsp?validate=saveRemarks&bean_id="+bean_id+"&bean_name="+bean_name,false);
    xmlHttp.send(xmlDoc);
    responseText=xmlHttp.responseText ;
    eval(responseText);
}

async function showDrugProfile(patient_id,encounter_id){ // encounter_id Added for AAKH-CRF-0088.2
	
	var dialogHeight	= "70vh";//"36" ;
	var dialogWidth		= "70vw" ;
	var dialogTop		= "" ;
	var center			= "1" ;
	var status			= "no";
	var features		= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop;
	var arguments		= "" ;
	retVal				= await top.window.showModalDialog( "../../ePH/jsp/QueryPatientDrugProfileFrames.jsp?patient_id="+escape(patient_id)+"&called_frm=Prescription"+"&encounter_id="+encounter_id, arguments, features ); // encounter_id Added for AAKH-CRF-0088.2
}

function populateFreq(obj) {
	var frmObj			= document.formIVPrescriptionFluidDetail;
	var patient_id		=	frmObj.patient_id.value;
	var encounter_id	=	frmObj.encounter_id.value;

    var bean_id= "@IVPrescriptionBean"+patient_id+encounter_id;
    var bean_name="ePH.IVPrescriptionBean";
	
	var chk_val	=	"N";
	if(obj.checked==true) 
		chk_val	=	"Y";

	var xmlStr ="<root><SEARCH ";
    xmlStr += " bean_id    =\""+ bean_id + "\" ";
    xmlStr += " bean_name  =\""+ bean_name + "\" ";
	xmlStr += " chk_val    =\""+ chk_val + "\" ";
    xmlStr +=" /></root>";

    var xmlDoc = "" ;
    var xmlHttp = new XMLHttpRequest() ;
    xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
    xmlHttp.open("POST","IVPrescriptionValidate.jsp?validate=populateFreq&bean_id="+bean_id+"&bean_name="+bean_name,false);
    xmlHttp.send(xmlDoc);
    responseText=xmlHttp.responseText ;
    eval(responseText);
}

function clearFrequency(){
	var frmObj	=	parent.f_ivadmin.document.formIVPrescriptionAdminDetail;

	frmObj.FREQUENCY.disabled	=	false;

	var len =frmObj.FREQUENCY.options.length;
	for(var i=0;i<len;i++) {
		frmObj.FREQUENCY.remove("FREQUENCY") ;
	}
	var tp = "       --- Select ---      " ;
	var opt = document.createElement("OPTION") ;
	opt.text = tp ;
	opt.value = "" ;
	frmObj.FREQUENCY.add(opt);
}

function addFrequency(code,desc,chk_val) {
	var frmObj	=	parent.f_ivadmin.document.formIVPrescriptionAdminDetail;

	var element = document.createElement('OPTION') ;
	element.value		=  code ;
	element.text		= desc ;

	frmObj.FREQUENCY.add(element);

	if(chk_val=="Y") {
		frmObj.FREQUENCY.value			= code;	
		frmObj.INFUSION_VALUE.disabled	=	true;
		frmObj.INFUSION_UOM.disabled	=	true;
		parent.f_ivadmin.document.getElementById('inf_mand').style.visibility = "hidden";
		checkScheduledYN(frmObj.FREQUENCY.value,"1");
		deleteSchedule('F');
		makeAutoSchedule('F');
		parent.f_ivadmin.document.getElementById('FREQ_CHANGED_YN').value='Y'
	}
	else {
		if(frmObj.freq_code.value=="")
			frmObj.FREQUENCY.value	= code;
		else 
			frmObj.FREQUENCY.value	= frmObj.freq_code.value;	
		frmObj.INFUSION_VALUE.disabled	=	false;
		frmObj.INFUSION_UOM.disabled	=	false;
		parent.f_ivadmin.document.getElementById('inf_mand').style.visibility = "visible";
	}
}

function duplicateWarning() {
	var msg		=	getMessage("PH_DUPLICATE_MEDICATION","PH");	
	var all_msg	=	msg.split("||");
	alert(all_msg[0]+document.formIVPrescriptionDrugDetails.GENERIC_NAME.value+all_msg[1]); 
}

function cancelDuplicate() {
	var frmObj			= document.formIVPrescriptionDrugDetails;
	var patient_class	= frmObj.patient_class.value;
	var drug_code		= frmObj.DRUG_CODE.value;
	var srl_no			= frmObj.SRL_NO.value;
	var bean_id			= frmObj.bean_id.value;
	var bean_name		= frmObj.bean_name.value;
	var qryString		= bean_id+"&bean_name="+bean_name+"&validate=DELETEDRUG&drug_code="+drug_code+"&srl_no="+srl_no;
	submitXML(qryString, "");

	var frmObj1		= parent.parent.f_ivadmin.document.formIVPrescriptionAdminDetail;
	var drug_array	= frmObj.drug_codes.value.split(",");
	var num_drugs	= drug_array.length-1;
	frmObj1.FREQUENCY.value		= "";
}

function ValidateDateTime (from,to){    

    var a=  from.split(" ")
    splitdate=a[0];
    splittime=a[1]
    var splitdate1 =splitdate.split("/")
    var splittime1= splittime.split(":")
    var from_date  =new Date(eval(splitdate1[2]), eval(splitdate1[1])-1, eval(splitdate1[0]), eval(splittime1[0]), eval(splittime1[1]))
    a=  to.split(" ")
    splitdate=a[0];
    splittime=a[1]
    splitdate1 =splitdate.split("/")
    splittime1= splittime.split(":")
    var to_date  =new Date(eval(splitdate1[2]), eval(splitdate1[1])-1, eval(splitdate1[0]), eval(splittime1[0]), eval(splittime1[1]))

    if(Date.parse(to_date) < Date.parse(from_date))
       return false
    else
        return true;
}

function setAdmixtureValue(formObj){
	var iv_prep_yn = "";
	var take_home_medication_ckk_val = "";//added for NMC-JD-CRF-0063
	if(formObj.admixture.checked == true){
		formObj.admixture.value = "Y";
		iv_prep_yn = "2";
	}
	else{
		formObj.admixture.value = "N";
		iv_prep_yn = "1";
	}
	var bean_id					= formObj.bean_id.value;
	var bean_name				= formObj.bean_name.value;
	var f_header				= "";

	if(parent.parent.parent.f_header != undefined)
		f_header				= parent.parent.parent.f_header;
	else
		f_header				= parent.parent.f_header;

	var location_type			= f_header.prescription_header_form.location_type.value;
	var location_code			= f_header.prescription_header_form.location_code.value;
	var take_home_medication	= f_header.prescription_header_form.take_home_medication.value;
	var priority				= f_header.prescription_header_form.priority.value;
	if(f_header.prescription_header_form.take_home_medication_op_chk!=undefined)//added for NMC-JD-CRF-0063
	 take_home_medication_ckk_val = f_header.prescription_header_form.take_home_medication_op_chk.value;
	var xmlStr ="<root><SEARCH ";					
	xmlStr+= "location_type =\"" + location_type + "\" " ;
	xmlStr+= "location_code =\"" + location_code + "\" " ;
	xmlStr+= "take_home_medication =\"" + take_home_medication + "\" " ;
	xmlStr+= "priority =\"" + priority + "\" " ;
	xmlStr+= "iv_prep_yn =\"" + iv_prep_yn + "\" " ;
	xmlStr+= "take_home_medication_ckk_val =\"" + take_home_medication_ckk_val + "\" " ;//added for NMC-JD-CRF-0063
	xmlStr +=" /></root>";
	var temp_jsp="IVPrescriptionValidate.jsp?validate=OrdDispenseLocation"+"&bean_id="+bean_id+"&bean_name="+bean_name;
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest() ;
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST",temp_jsp,false);
	xmlHttp.send(xmlDoc);
	responseText=xmlHttp.responseText ;
	eval(responseText);

	mfr_yn = formObj.mfr_yn.value;
	if(formObj.admixture.checked == true){
		formObj.mfr_yn.value = "N";
		if(document.getElementById('mfrLink') != undefined){
			document.getElementById('mfrLink').style.visibility = 'hidden';
			document.getElementById('MFR_Indicator').style.visibility = 'hidden';
			document.getElementById('mfrRemarksLink').style.display = 'none';
		}
	}
	else{
		if(document.getElementById('mfrLink') != undefined){
			document.getElementById('mfrLink').style.visibility = 'visible';
			document.getElementById('MFR_Indicator').style.visibility = 'visible';
			var mfrIndicatorSource=document.getElementById('MFR_Indicator').src;
			if(mfrIndicatorSource.indexOf("enabled.gif")!=-1)
				document.getElementById('mfrRemarksLink').style.display = 'inline';
		}
	}
}

function defaultDuration(obj,formObj) {
	if(trimString(formObj.INFUSION_PERIOD_VALUE.value)!="" && parseFloat(trimString(formObj.INFUSION_PERIOD_VALUE.value))!=0 && parseInt(trimString(formObj.INFUSION_PERIOD_VALUE.value))<=24) {
		obj.value	=	formObj.INFUSION_PERIOD_VALUE.value;
	}
}

// The following function is to call the Admin Rate jsp to diplay each drugs admin rate for IV Prescription With Additives  -- srijagadeesh 22/11/2004

async function adminRate(){

	if(parent.parent.parent.f_header!=undefined)
	       hdrForm = parent.parent.parent.f_header.document.prescription_header_form;
	else
		 hdrForm = parent.parent.f_header.document.prescription_header_form;

	var weight		= hdrForm.weight.value;	
	
	if(parent.parent.f_detail != undefined)
		frmObj			= parent.parent.f_detail.f_iv_drug_details.f_sub_ivdrugs.document.formIVPrescriptionDrugDetails;
	else
		frmObj			= parent.parent.f_ivdetails.f_iv_drug_details.f_sub_ivdrugs.document.formIVPrescriptionDrugDetails;

	var infuse_over_hr = document.formIVPrescriptionAdminDetail.INFUSION_PERIOD_VALUE.value;
	var infuse_over_min = document.formIVPrescriptionAdminDetail.INFUSION_PERIOD_VALUE_MIN.value;
	//var infuse_over = document.formIVPrescriptionAdminDetail.infusion_over_insert_value.value;// sri 26189:had precision error in admin rate page hence converted infuse over in min.

	if(infuse_over_min == "")
		infuse_over_min = 0;
	if(infuse_over_hr == "")
		infuse_over_min = 0;
	var infuse_over_in_min = parseInt(infuse_over_hr*60)+parseInt(infuse_over_min);


//	var infustion_uom = "H";
	var patient_id		  = frmObj.patient_id.value;
	var encounter_id	  = frmObj.encounter_id.value;
	var dosage = frmObj.STRENGTH_VALUE.value;
	var dialogHeight= "10";
	var dialogWidth	= "25";
	var dialogTop	= "250";
	var center		= "1";
	var status		= "no";
	var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop;
	var arguments	= "";

	var retVal		=await  window.showModalDialog("../jsp/IVPrescriptionAdminRate.jsp?weight="+weight+"&dosage="+dosage+"&infuse_over="+infuse_over_in_min+"&infustion_uom=M"+"&patient_id="+patient_id+"&encounter_id="+encounter_id, arguments, features);
}

function showAdminRate(){
	if(document.formIVPrescriptionAdminDetail != undefined)
		var frmObj		= document.formIVPrescriptionAdminDetail;
	else
		var frmObj		= parent.f_detail.f_iv_admin.document.formIVPrescriptionAdminDetail;

//	var infuse_over = trimString(frmObj.INFUSION_PERIOD_VALUE.value);
	var infuse_over = trimString(frmObj.infusion_over_insert_value.value);
	if(infuse_over!="" && parseFloat(infuse_over)!=0)
		frmObj =document.getElementById('adminrate').style.visibility = 'visible';
	else
		frmObj =document.getElementById('adminrate').style.visibility = 'hidden';
}

function checkadmixture(frmobj){
	
	//var time_flag=frmobj.time_flag.value;
	var time_flag=parent.parent.f_ivbutton.document.formIVPrescriptionButtons.time_flag.value;
	var alert_practitioner_yn=frmobj.alert_practitioner_yn.value;
	if(frmobj.admixture.checked==true){
		if(time_flag!='X'  ){
			if(alert_practitioner_yn=='Y')
				alert(getMessage("PREPARATION_ALERT","PH"));
		}
	}
}

function validateRemarksAmend(format_id) {
    var format  =   format_id.split("~");
    var mandatory   =   format[0];
    formatId   =   format[1];
	//added for SKR-SCF-0140 -start
	if(format == null || format=='' || formatId==null || formatId=='')
		document.formIVPrescriptionDrugDetails.drug_remarks.style.display = 'none';
	else
		document.formIVPrescriptionDrugDetails.drug_remarks.style.display = 'inline';
	//added for SKR-SCF-0140 -end
    callOrderAmend();
}

function callOrderAmend() {
	var vals = "";
	var drug_code = "";
	var frmObj = "";
	for(i=0; i<pres_vals.length; i++)	{
		if(i==pres_vals.length)
			vals	+= pres_vals[i];
		else
			vals	+= pres_vals[i]+ "::";
	}
	frmObj = document.formIVPrescriptionDrugDetails
	drug_code = document.formIVPrescriptionDrugDetails.DRUG_CODE.value;
	callRemarksAmend(frmObj, formatId, drug_code, 'PH', '0', 'PH', vals);
}

async function callRemarksAmend(frmObj, format_id, catalog_code, order_category, row_value, called_from, pres_vals) {
	
	patient_id		= frmObj.patient_id.value;
	encounter_id	= frmObj.encounter_id.value;
	order_id		= frmObj.order_id.value;
	order_line_num	= frmObj.order_line_num.value;
	pres_remarks	= frmObj.pres_remarks.value;
	bean_id			= "@orderentrybean"+patient_id+encounter_id;
	bean_name		= "eOR.OrderEntryBean";

	var dialogHeight= "25vh";
	var dialogWidth	= "50vw";
	var dialogTop	= "169";
	var center		= "1";
	var status		= "no";
	var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop;
	var arguments	= "";
	var retVal		= await window.showModalDialog("../../eOR/jsp/OrderEntryOrderFormatFrameSet.jsp?bean_id="+bean_id+"&bean_name="+bean_name+"&format_id="+format_id+"&p_catalog_code="+catalog_code+"&catalog_code="+catalog_code+"&p_form_code="+form_code+"&p_route_code="+route_code+"&order_category="+order_category+"&row_value=0&called_from=PH"+"&order_id="+order_id+"&order_line_num="+order_line_num,arguments,features);
}

function setStockValue(obj ){
	var formFluid = parent.f_iv_fluid.document.formIVPrescriptionDetails;
	if(formFluid.mfr_yn.value != "Y"){
		if(obj.value != "0" && obj.value != ""){
			frmAdminobj = parent.f_iv_admin.document.formIVPrescriptionAdminDetail;//Added for SKR-CRF-0035 [IN:037727] -Start
			var iv_calc_infuse_by = frmAdminobj.iv_calc_infuse_by.value ;
			if(iv_calc_infuse_by=='I'){
				var volume		= formFluid.stock_value;
				var orderQty = frmAdminobj.order_qty.value;
				var volumePerUnit = formFluid.volumePerUnit.value;
				var maxTotalVolume = parseInt(volumePerUnit)*parseInt(orderQty);
				var minTotalVolume = parseInt(volumePerUnit)*(parseInt(orderQty)-1);
				var totalVolume = parseInt(obj.value);
				var msg = "";
				if(parseInt(totalVolume) > parseInt(maxTotalVolume) ){
					msg = getMessage("PH_IV_TOTAL_VOLUME_MAX_RANGE","PH");
					msg = msg.replace("$",maxTotalVolume)+" "+formFluid.stock_display.innerText;
					totalVolume = maxTotalVolume;
				}
				else if(parseInt(totalVolume) <= parseInt(minTotalVolume)){
					msg = getMessage("PH_IV_TOTAL_VOLUME_MIN_RANGE","PH");
					msg = msg.replace("$",minTotalVolume+1)+" "+formFluid.stock_display.innerText;
					totalVolume = minTotalVolume+1;
				}
				if(msg!=""){
					alert(msg);
					volume.value=totalVolume;
					volume.focus();
					return false;
				}
			}//Added for SKR-CRF-0035 [IN:037727] -End
			/*if(parseInt(obj.value)  > parseInt(document.formIVPrescriptionDetails.BASE_VOLUME.value) ){
				alert(getMessage("FLD_VOL_CANTGRT_BAS_VOL","PH")+" ("+document.formIVPrescriptionDetails.BASE_VOLUME.value+")");
				document.formIVPrescriptionDetails.stock_value.focus();
				return false;
			}
			else{*/
				formFluid.STOCK_VALUE.value = obj.value;
				setInfuseOverValue();
			//}
			if(frmAdminobj.iv_calc_infuse_by.value=='I'){ //Added for SKR-CRF-0035 [IN:037727] -Start
				var bean_id    = frmAdminobj.BEAN_ID.value;
				var bean_name  = frmAdminobj.BEAN_NAME.value;
				var start_date = frmAdminobj.START_DATE.value;
				var durnHrs =frmAdminobj.INFUSION_PERIOD_VALUE.value;
				var durnMins =frmAdminobj.INFUSION_PERIOD_VALUE_MIN.value;
				if(trimString(durnHrs)=="")
					durnHrs = '0';
				if(trimString(durnMins)=="")
					durnMins = '0';
				var durn_unit = "M";
				var DURN_VALUE =  (parseInt(durnHrs)*60)+parseInt(durnMins)
				var qryString	= bean_id+"&bean_name="+bean_name+"&validate=POPULATEENDDATEADMIN&start_date="+start_date+"&durn_value="+DURN_VALUE+"&durn_unit="+durn_unit+"&mode=IV_CALC_ADMIN";
				submitXML(qryString, "");
			}//Added for SKR-CRF-0035 [IN:037727] -End
		}
		else{
			if(parent.f_iv_drug_details.f_sub_ivdrugs.formIVPrescriptionDrugDetails != undefined && parent.f_iv_drug_details.f_sub_ivdrugs.formIVPrescriptionDrugDetails.DRUG_NAME.value != ""){
				alert(getMessage("FLD_VOL_CANT_BLNK_ZERO","PH"));
				formFluid.stock_value.focus();
			}
			else{
				setInfuseOverValue();
			}
		}
	}
}

async function viewReasonforRequest(orderId){
	var dialogHeight ='9vh' ;
	var dialogWidth = '25vw' ;
	var dialogTop	= '189';
	var dialogLeft = '167' ;
	var title = ''
	var features = 'dialogHeight:' + dialogHeight + '; dialogWidth:' + dialogWidth +';dialogTop:'+dialogTop+';dialogLeft:'+dialogLeft+';dialogTitle:'+title+'; scroll=yes; status=no';
	var arguments = "";
	var finalString	= "&readonly=readOnly&orderId="+orderId;
	var retVals =await window.showModalDialog("../../eOR/jsp/TDMReasonforrequest.jsp?"+finalString,arguments,features);
}

async function showPreviousOrders(){
	//alert("1");
	var patient_class	=	parent.parent.f_header.document.prescription_header_form.patient_class.value;
	var pract_id		=	parent.parent.f_header.document.prescription_header_form.pract_id.value;
	var patient_id		=	parent.parent.f_header.document.prescription_header_form.patient_id.value;
	var encounter_id	=	parent.parent.f_header.document.prescription_header_form.encounter_id.value;
	var order_date		=	parent.parent.f_header.document.prescription_header_form.sys_date.value;
    var adr_count       =   parent.parent.f_header.document.prescription_header_form.adr_count.value; 
	var iv_prep_yn	    =	'1';
	var iv_type			= document.formIVPrescriptionOptions.type.value;
	var location_type		 = parent.parent.f_header.prescription_header_form.location_type.value;
	var location_code		 = parent.parent.f_header.prescription_header_form.location_code.value;
	var take_home_medication = parent.parent.f_header.prescription_header_form.take_home_medication.value; 
	var bl_install_yn		 = parent.parent.f_header.prescription_header_form.bl_install_yn.value; 
	var bl_disp_charge_dtl_in_rx_yn = parent.parent.f_header.prescription_header_form.bl_disp_charge_dtl_in_rx_yn.value; 
	var priority			 = parent.parent.f_header.prescription_header_form.priority.value;
	var pract_type			 = parent.parent.f_header.prescription_header_form.pract_type.value;

    var MAR_app_yn =parent.frames[0].document.forms[0].MAR_app_yn.value;
	if(iv_type == "IVD"){
		if(parent.parent.f_prescription.f_ivdetails.f_iv_fluid.document.formIVPrescriptionDetails.admixture.checked == true)
			iv_prep_yn	    =	'2';
		else
			iv_prep_yn	    =	'1';
	}
	else if(iv_type == "IVPB"){
		if(parent.f_ivdetails.f_iv_pb_drug.document.formIVPiggyBackDrugDetails.admixture.checked == true)
			iv_prep_yn	    =	'4';
		else
			iv_prep_yn	    =	'3';
	}
	else if(iv_type == "IVWA")
		iv_prep_yn	    =	'5';

	var dialogHeight= "85vh" ;         // dialogHeight changed from 28 to 29 for SKR-SCF-1119 [IN:057783]
	var dialogWidth	=  "85vw" ;
	var dialogTop = "" ;
	var dialogLeft = "" ;
	var center = "1" ;
	var status="no";
	var scroll="no";
	var features	= "dialogLeft:" + dialogLeft + ";dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; center: " + center + ";scroll "+scroll+"; status: " + status + "; dialogTop :" + dialogTop;
	var arguments	= "" ;
	retVal = await top.window.showModalDialog("../../ePH/jsp/PrescriptionPrevOrders.jsp?patient_class="+patient_class+"&pract_id="+pract_id+"&patient_id="+patient_id+"&encounter_id="+encounter_id+"&rx_type="+iv_prep_yn+"&pract_type="+pract_type+"&call_from=COPYPREVORDERS",arguments,features);

	if(retVal!=null && retVal!="") {
		var order_id = retVal.substring(0,retVal.indexOf(","));//added for IN24251 --16/12/2010-- priya
		var answer = retVal.substring(retVal.indexOf(",")+1,retVal.length);//added for IN24251 --16/12/2010-- priya
		parent.parent.PrescriptionDetailFrameSet.removeAttribute("cols");
		parent.parent.PrescriptionDetailFrameSet.setAttribute("rows");
		parent.parent.PrescriptionDetailFrameSet.rows="100%,0%";
		parent.parent.f_prescription.classValue="IV";
		prev_order = "previous";
		if(iv_type == "IVD"){
			parent.f_ivdetails.document.location.href		= "../jsp/IVPrescriptionDetailsFrame.jsp?patient_id="+patient_id+"&encounter_id="+encounter_id+"&act_patient_class="+patient_class+"&start_date="+order_date+"&iv_prep_yn="+iv_prep_yn+"&order_id="+order_id+"&order_type_flag=Existing"+"&prev_order=previous"+"&adr_count="+adr_count+"&showButtons=Y"+"&MAR_app_yn="+MAR_app_yn+"&answer="+answer;
		} 
		else if(iv_type == "IVPB"){
			parent.f_ivdetails.document.location.href		= "../jsp/IVPiggyBack.jsp?patient_id="+patient_id+"&encounter_id="+encounter_id+"&act_patient_class="+patient_class+"&start_date="+order_date+"&iv_prep_yn="+iv_prep_yn+"&order_id="+order_id+"&order_type_flag=Existing"+"&prev_order=previous"+"&adr_count="+adr_count+"&MAR_app_yn="+MAR_app_yn+"&answer="+answer;
		} 
		else if(iv_type == "IVWA"){
			parent.f_ivdetails.document.location.href		= "../jsp/IVFluidAdditives.jsp?patient_id="+patient_id+"&encounter_id="+encounter_id+"&act_patient_class="+patient_class+"&start_date="+order_date+"&iv_prep_yn="+iv_prep_yn+"&order_id="+order_id+"&order_type_flag=Existing"+"&prev_order=previous"+"&adr_count="+adr_count+"&MAR_app_yn="+MAR_app_yn+"&answer="+answer+"&take_home_medication="+take_home_medication+"&priority="+priority; // Added For IN:062361
		}
		if(parent.f_ivbutton != null){
			parent.f_ivbutton.location.href	= "../jsp/IVPrescriptionButtons.jsp?patient_id="+patient_id+"&encounter_id="+encounter_id+"&act_patient_class="+patient_class+"&mode=Existing"+"&location_type="+location_type+"&location_code="+location_code+"&take_home_medication="+take_home_medication+"&priority="+priority+"&iv_prep_yn="+iv_prep_yn+"&bl_install_yn="+bl_install_yn+"&bl_disp_charge_dtl_in_rx_yn="+bl_disp_charge_dtl_in_rx_yn+"&MAR_app_yn="+MAR_app_yn;
		}
	}
}

//  FDB interfaces.
/*function displayDosageCheckResult( srl_no ){
	var ext_med_alerts_fired_for_dup_check_yn		=	eval("document.getElementById("ext_med_alerts_fired_for_dup_check_yn")"+srl_no).value;
	var ext_med_alerts_fired_for_inte_check_yn		=	eval("document.getElementById("ext_med_alerts_fired_for_inte_check_yn")"+srl_no).value;
	var ext_med_alerts_fired_for_contra_check_yn	=	eval("document.getElementById("ext_med_alerts_fired_for_contra_check_yn")"+srl_no).value;
	
    var patient_id				 =	document.formIVPrescriptionDrugList.patient_id.value;
	var drug_code				 =  eval("document.getElementById("drug_code_")"+srl_no).value;
	var ext_prod_id				 =  eval("document.getElementById("ext_prod_id_")"+srl_no).value;
	var external_override_reason =  "";
	//eval("document.getElementById("external_override_reason_")"+srl_no).value;
	var external_db_dose_check   =  "";
	//eval("document.getElementById("external_db_dose_check_")"+srl_no).value;
   	 if(ext_med_alerts_fired_for_dup_check_yn=='Y'|| ext_med_alerts_fired_for_inte_check_yn=='Y'||ext_med_alerts_fired_for_contra_check_yn=='Y'||external_db_dose_check=='Y'){

         viewMedicationAlert(drug_code,srl_no,patient_id,ext_prod_id,ext_med_alerts_fired_for_inte_check_yn,ext_med_alerts_fired_for_dup_check_yn,ext_med_alerts_fired_for_contra_check_yn,external_db_dose_check,external_override_reason);
	 }
}*/

function viewMedicationAlert(patient_id,ext_prod_id,drug_db_interact_check_flag,drug_db_duptherapy_flag,drug_db_contraind_check_flag,drug_db_dose_check_flag,called_from,external_dosage_override_reason,drug_code,srl_no,external_duplicate_override_reason,external_interaction_override_reason,external_contra_override_reason,pract_name,external_alergy_override_reason,drug_db_dosecheck_yn,drug_db_allergy_check_flag){
	var drug_frmobj	= document.formIVPrescriptionDrugDetails;
	if((drug_db_dosecheck_yn=="Y"&&called_from=='ONLOAD')){			  
		if(called_from=='ONLOAD'){
			drug_db_dose_check_flag	=	drug_frmobj.drug_db_dose_check_flag.value;
		}
	}
	else if(called_from=='PRESPAD'){
		external_dosage_override_reason		= eval("document.formIVPrescriptionDrugList.external_dosage_override_reason"+srl_no).value;
		external_duplicate_override_reason	= eval("document.formIVPrescriptionDrugList.external_duplicate_override_reason"+srl_no).value;
		external_interaction_override_reason= eval("document.formIVPrescriptionDrugList.external_interaction_override_reason"+srl_no).value;
		external_contra_override_reason		= eval("document.formIVPrescriptionDrugList.external_contra_override_reason"+srl_no).value;
		external_alergy_override_reason		= eval("document.formIVPrescriptionDrugList.external_alergy_override_reason"+srl_no).value;

		if(external_dosage_override_reason!="")
			external_dosage_override_reason=encodeURIComponent(external_dosage_override_reason,"UTF-8");
		if(external_duplicate_override_reason!="")
			external_duplicate_override_reason=encodeURIComponent(external_duplicate_override_reason,"UTF-8");
		if(external_interaction_override_reason!="")
			external_interaction_override_reason=encodeURIComponent(external_interaction_override_reason,"UTF-8");
		if(external_contra_override_reason!="")
			external_contra_override_reason=encodeURIComponent(external_contra_override_reason,"UTF-8");
		if(external_alergy_override_reason!="")
			external_alergy_override_reason=encodeURIComponent(external_alergy_override_reason,"UTF-8");
   }
   else{
	   external_dosage_override_reason = eval("parent.f_drug_list.f_drugs.document.forms[0].external_dosage_override_reason"+srl_no).value;
	   if(external_dosage_override_reason!="")
			external_dosage_override_reason=encodeURIComponent(external_dosage_override_reason,"UTF-8");
   }
   if(drug_db_dose_check_flag=="")
		drug_db_dose_check_flag =drug_db_dose_check_flag;
	//if(called_from=='ONLOAD'){
   if(called_from !='PRESPAD'){
	   if(called_from != undefined && called_from != "undefined" && called_from != ""){ //26212: siriraj dint want the alert to appear on change of the dosage in ivd. hence this if condition was added 2/2/2011

			if(((drug_db_interact_check_flag=='Y') && (external_interaction_override_reason=="")) ||((drug_db_duptherapy_flag=='Y') && (external_duplicate_override_reason=""))||((drug_db_contraind_check_flag=='Y' )&& (external_contra_override_reason==""))||((drug_db_dose_check_flag=='Y')&& (external_dosage_override_reason==""))){
				callMedicationAlert(patient_id,ext_prod_id,drug_db_interact_check_flag,drug_db_duptherapy_flag,drug_db_contraind_check_flag,drug_db_dose_check_flag,external_dosage_override_reason,drug_code,srl_no,called_from,external_duplicate_override_reason,external_interaction_override_reason,external_contra_override_reason,pract_name,external_alergy_override_reason,drug_db_allergy_check_flag);
			}
		}
	}
	else {
		if((drug_db_interact_check_flag=='Y') ||(drug_db_duptherapy_flag=='Y')||(drug_db_contraind_check_flag=='Y')||(drug_db_dose_check_flag=='Y') || drug_db_allergy_check_flag == 'Y' ) {
			callMedicationAlert(patient_id,ext_prod_id,drug_db_interact_check_flag,drug_db_duptherapy_flag,drug_db_contraind_check_flag,drug_db_dose_check_flag,external_dosage_override_reason,drug_code,srl_no,called_from,external_duplicate_override_reason,external_interaction_override_reason,external_contra_override_reason,pract_name,external_alergy_override_reason,drug_db_allergy_check_flag);
		}
	}
}

async function callMedicationAlert(patient_id,ext_prod_id,drug_db_interact_check_flag,drug_db_duptherapy_flag,drug_db_contraind_check_flag,drug_db_dosecheck_flag,external_dosage_override_reason,drug_code,srl_no,called_from,external_duplicate_override_reason,external_interaction_override_reason,external_contra_override_reason,pract_name,external_alergy_override_reason,drug_db_allergy_check_flag){

	var drug_frmobj	= document.formIVPrescriptionDrugDetails;
	var dialogHeight	= "35" ;
	var dialogWidth	    = "65";
	var dialogTop	    = "100" ;
	var dialogLeft	    = "100" ;
	var center			= "0" ;
	var status			= "no";
	var features	    = "dialogHeight:" + dialogHeight +"; dialogLeft:"+dialogLeft+ "; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop;
	var arguments	= "";

	pract_name = encodeURIComponent(pract_name,"UTF-8"); 
	if(external_dosage_override_reason != "")
		drug_db_dosecheck_flag = "Y";

	retVal =await  window.showModalDialog("../../ePH/jsp/MedicationAlerts.jsp?&patient_id="+patient_id+"&external_product_id="+ext_prod_id+"&drug_db_interact_check_flag="+drug_db_interact_check_flag+"&drug_db_duptherapy_flag="+drug_db_duptherapy_flag+"&drug_db_contraind_check_flag="+drug_db_contraind_check_flag+"&srl_no="+srl_no+"&drug_db_dosecheck_flag="+drug_db_dosecheck_flag+"&drug_db_allergy_flag="+drug_db_allergy_check_flag+"&dsg_reason="+external_dosage_override_reason+"&dup_reason="+external_duplicate_override_reason+"&con_reason="+external_contra_override_reason+"&int_reason="+external_interaction_override_reason+"&alg_reason="+external_alergy_override_reason+"&pract_name="+pract_name ,arguments,features);
   
	bean_id		=	document.forms[0].bean_id.value;
	bean_name	=	document.forms[0].bean_name.value;

	if(retVal!=null && retVal[0]!='CANCEL'){
		 var external_dosage_override_reason		=	"";
		 var external_duplicate_override_reason		=	"";
		 var external_interaction_override_reason	=	"";
		 var external_contra_override_reason		=	"";
		 var external_alergy_override_reason		=	"";
		 var abuse_override_remarks="";
		 var reason		="";
		 var indicator	="";

		 for(i=0;i<retVal.length;i++){
			 reason=retVal[i];
			 indicator=reason.substring(0,5);
			 reason=retVal[i].substring(5,retVal[i].length);

			 if(indicator=='DSG_Y')
				external_dosage_override_reason		=reason;
			 else if(indicator=='DUP_Y')
				external_duplicate_override_reason	=reason;
			 else if(indicator=='CON_Y')
				external_contra_override_reason		=reason;
			 else if(indicator=='ALG_Y')
				external_alergy_override_reason		=reason;
			 else if(indicator=='INT_Y')
				external_interaction_override_reason=reason;
		 }
		 if(called_from=='ONLOAD'){
			 drug_frmobj.external_dosage_override_reason.value		=	escape(external_dosage_override_reason);
			 drug_frmobj.external_duplicate_override_reason.value	=	escape(external_duplicate_override_reason);
			 drug_frmobj.external_interaction_override_reason.value	=	escape(external_interaction_override_reason);
			 drug_frmobj.external_contra_override_reason.value		=	escape(external_contra_override_reason);
			 drug_frmobj.external_Alergy_override_reason.value		=	escape(external_alergy_override_reason);		
			 drug_frmobj.abuse_override_remarks.value=escape(external_alergy_override_reason);
			 //eval("document.formIVPrescriptionDrugList.external_dosage_override_reason"+srl_no).value		=	encodeURIComponent(external_dosage_override_reason,"UTF-8");  
		}
		else if(called_from=='PRESPAD'){
			eval("document.formIVPrescriptionDrugList.external_dosage_override_reason"+srl_no).value		=	encodeURIComponent(external_dosage_override_reason,"UTF-8");      
			eval("document.formIVPrescriptionDrugList.external_duplicate_override_reason"+srl_no).value		=	encodeURIComponent(external_duplicate_override_reason,"UTF-8");   
			eval("document.formIVPrescriptionDrugList.external_interaction_override_reason"+srl_no).value	=	encodeURIComponent(external_interaction_override_reason,"UTF-8"); 
			eval("document.formIVPrescriptionDrugList.external_contra_override_reason"+srl_no).value		=	encodeURIComponent(external_contra_override_reason,"UTF-8");      
			eval("document.formIVPrescriptionDrugList.external_alergy_override_reason"+srl_no).value		=	encodeURIComponent(external_alergy_override_reason,"UTF-8"); 
			eval("document.formIVPrescriptionDrugList.abuse_override_remarks"+srl_no).value		=	encodeURIComponent(abuse_override_remarks,"UTF-8"); 
			
		}
	   else{
		   eval("parent.f_drug_list.f_drugs.document.forms[0].external_dosage_override_reason"+srl_no).value		=	encodeURIComponent(external_dosage_override_reason,"UTF-8");  
		   eval("parent.f_drug_list.f_drugs.document.forms[0].external_duplicate_override_reason"+srl_no).value		=	encodeURIComponent(external_duplicate_override_reason,"UTF-8");  
		   eval("parent.f_drug_list.f_drugs.document.forms[0].abuse_override_remarks"+srl_no).value		=	encodeURIComponent(abuse_override_remarks,"UTF-8");  
			
	   }
	   var formObj = document.forms[0];
	   var external_database_overrided_reason = "N";
	   if(formObj.name=="formIVPrescriptionDrugDetails")
		   formObj = parent.f_drug_list.f_drugs.document.formIVPrescriptionDrugList;

		if(eval("formObj.ext_ddb_override_indc"+srl_no) == undefined)
			eval("formObj.override_indc"+srl_no).className='SHIFTTOTAL';
		else{
			eval("formObj.ext_ddb_override_indc"+srl_no).className='SHIFTTOTAL';
 			eval("formObj.ext_ddb_override_img"+srl_no+".style").visibility='visible';
		}
		
		if(((drug_db_interact_check_flag=="Y")&&(external_interaction_override_reason==""))||((drug_db_duptherapy_flag=="Y")&&(external_duplicate_override_reason==""))||((drug_db_contraind_check_flag=="Y")&&(external_contra_override_reason==""))||((drug_db_dosecheck_flag=="Y")&&(external_dosage_override_reason=="")) || (eval("formObj.ext_med_alerts_fired_for_dup_check_yn"+srl_no).value=="Y" && eval("formObj.external_duplicate_override_reason"+srl_no).value=="") ){
			eval("formObj.ext_ddb_override_img"+srl_no+".style").visibility='visible';
		}
		else{
			if(eval("formObj.ext_ddb_override_img"+srl_no) != undefined)
			eval("formObj.ext_ddb_override_img"+srl_no+".style").visibility='hidden';
			external_database_overrided_reason = "Y";
		}

		var xmlStr ="<root><SEARCH ";					
		xmlStr+= "External_Dosage_Override_Reason =\"" + encodeURIComponent(external_dosage_override_reason,"UTF-8") + "\" " ;
		xmlStr+= "External_Duplicate_Override_Reason =\"" + encodeURIComponent(external_duplicate_override_reason,"UTF-8") + "\" " ;
		xmlStr+= "External_Interaction_Override_Reason =\"" + encodeURIComponent(external_interaction_override_reason,"UTF-8") + "\" " ;
		xmlStr+= "External_Contra_Override_Reason =\"" + encodeURIComponent(external_contra_override_reason,"UTF-8") + "\" " ;
		xmlStr+= "External_Alergy_Override_Reason =\"" + encodeURIComponent(external_alergy_override_reason,"UTF-8") + "\" " ;
		xmlStr+= "External_database_overrided_reason =\"" +encodeURIComponent(external_database_overrided_reason,"UTF-8") + "\" " ;
		xmlStr+= "drug_code =\"" + drug_code + "\" " ;
		xmlStr+= "srl_no =\"" + srl_no + "\" " ;
		xmlStr+= "bean_id =\"" + bean_id + "\" " ;
		xmlStr+= "bean_name=\"" + bean_name + "\" " ;
		xmlStr+= "abuse_override_remarks=\"" + abuse_override_remarks + "\" " ;
		
		xmlStr +=" /></root>";

		var temp_jsp="IVPrescriptionValidate.jsp?validate=InsertExternalOverrideReason"+"&bean_id="+bean_id+"&bean_name="+bean_name;
		var xmlDoc = "" ;
		var xmlHttp = new XMLHttpRequest() ;
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open("POST",temp_jsp,false);
		xmlHttp.send(xmlDoc);
		responseText=xmlHttp.responseText ;
		eval(responseText);
	}
}

function DisplayFDBOverrideImage(srl_no,called_from){	
	var frmObj		= parent.f_iv_drug_details.f_drug_list.f_drugs;
	if(eval("parent.f_iv_drug_details.f_drug_list.f_drugs.document.forms[0].ext_ddb_override_img"+srl_no) != undefined){
		eval("parent.f_iv_drug_details.f_drug_list.f_drugs.document.forms[0].ext_ddb_override_img"+srl_no+".style").visibility='visible';
		eval("parent.f_iv_drug_details.f_drug_list.f_drugs.formIVPrescriptionDrugList.ext_ddb_override_img"+srl_no+".style").visibility="visible";
		eval(parent.f_iv_drug_details.f_drug_list.f_drugs.document.getElementById("ext_ddb_override_indc"+srl_no)).className="SHIFTTOTAL";
	}

    if(called_from=='DOSAGE'){
		external_db_dose_check     = eval(document.getElementById("external_db_dose_check_"+srl_no));
		if(external_db_dose_check != undefined)
			external_db_dose_check.value='Y';
		else
			eval(parent.f_iv_drug_details.f_drug_list.f_drugs.document.getElementById('external_db_dose_check_'+srl_no)).value = "Y";
	}
}

function HideFDBOverrideImage(srl_no,called_from){
	var frmObj		= parent.f_iv_drug_details.f_drug_list.f_drugs.document.formIVPrescriptionDrugList;
    var ext_med_alerts_fired_for_dup_check_yn		=	eval("frmObj.ext_med_alerts_fired_for_dup_check_yn"+srl_no).value;
	var ext_med_alerts_fired_for_inte_check_yn		=	eval("frmObj.ext_med_alerts_fired_for_inte_check_yn"+srl_no).value;
	var ext_med_alerts_fired_for_contra_check_yn	=	eval("frmObj.ext_med_alerts_fired_for_contra_check_yn"+srl_no).value;
    var external_db_dose_check			 = eval("frmObj.external_db_dose_check_"+srl_no);
	if(called_from=='DOSAGE')
		external_db_dose_check.value	 = 'N';

	 if(ext_med_alerts_fired_for_dup_check_yn=='N'&& ext_med_alerts_fired_for_inte_check_yn=='N'&&ext_med_alerts_fired_for_contra_check_yn=='N'&&external_db_dose_check.value=='N' && eval("parent.f_iv_drug_details.f_drug_list.f_drugs.formIVPrescriptionDrugList.ext_ddb_override_img"+srl_no) != undefined){
		eval("parent.f_iv_drug_details.f_drug_list.f_drugs.formIVPrescriptionDrugList.ext_ddb_override_img"+srl_no+".style").visibility="hidden";
		eval(parent.f_iv_drug_details.f_drug_list.f_drugs.document.getElementById('ext_ddb_override_indc'+srl_no)).className="SELECTEDRUGS";
	 }
}

function ExternalDosageCheck(called_from,adm_prsc){

	if(adm_prsc == 'presc'){
		if(called_from == 'amend')
			var formObject			=  parent.parent.parent.f_header.document.prescription_header_form;
		else
			var formObject			=  parent.parent.parent.parent.f_header.document.prescription_header_form;
		var drug_frmobj		    =  document.formIVPrescriptionDrugDetails;
		var adminObj			=  parent.parent.f_iv_admin.formIVPrescriptionAdminDetail;
		var fluidFormObj		=	parent.parent.f_iv_fluid.document.formIVPrescriptionDetails;
	}
	else if(adm_prsc == 'admndtl'){
		var formObject			=  "";
		if(parent.parent.parent.f_header != undefined)
			formObject			=  parent.parent.parent.f_header.document.prescription_header_form;
		else
			formObject			=	parent.parent.f_header.document.prescription_header_form;
		var drug_frmobj		    =	parent.f_iv_drug_details.f_sub_ivdrugs.formIVPrescriptionDrugDetails;
		var adminObj			=	parent.f_iv_admin.formIVPrescriptionAdminDetail;
		var fluidFormObj		=	parent.f_iv_fluid.document.formIVPrescriptionDetails;
		var inf_prd_value = adminObj.INFUSION_PERIOD_VALUE.value;
		var inf_prd_value_min= adminObj.INFUSION_PERIOD_VALUE_MIN.value;
		if(((inf_prd_value=="" || parseInt(inf_prd_value)==0)&& (inf_prd_value_min=="" || parseInt(inf_prd_value_min) == 0)) && fluidFormObj.fluid.value != "" ){
			if(fluidFormObj.stock_value.value == ""){
				fluidFormObj.stock_value.focus();
			}
			/*else{
			alert(getMessage("PRES_IV_INF_OVER_NOT_BLANK","PH"));
			adminObj.INFUSION_PERIOD_VALUE.focus();
			}*/
			return false;
		}
	}
	else{
		var formObject			=  parent.parent.parent.f_header.document.prescription_header_form;
		var drug_frmobj		    =  parent.f_iv_drug_details.f_sub_ivdrugs.formIVPrescriptionDrugDetails;
		var adminObj			=  parent.f_iv_admin.formIVPrescriptionAdminDetail;
	}
	var mfr_yn_flag=adminObj.MFR_YN_Flag.value;
	if(fluidFormObj.fluid.value == "")
		return false;
	if(fluidFormObj.fluid.value != "" && ((adminObj.DURN_VALUE.value=="" || parseFloat(adminObj.DURN_VALUE.value)==0) && mfr_yn_flag!="Y")) {
		alert(getMessage("PRES_DURN_CANNOT_ZERO","PH"));
		return false;
	}
	var external_prod_id    = "";
    if(drug_frmobj.external_product_id != undefined)
		external_prod_id    = drug_frmobj.external_product_id.value;

    var drug_db_dosechk_yn  = formObject.drug_db_dosecheck_yn.value;
	var drug_db_interface_yn = formObject.drug_db_interface_yn.value;

	if(drug_db_interface_yn == "Y"){
		var route_code						= drug_frmobj.ROUTE_CODE.value ;// Added in January 2014 for CIMS dosage check -start
		var qty_desc_code					= drug_frmobj.QTY_DESC_CODE.value; 
		var repeat_durn_type				= drug_frmobj.DURN_TYPE.value;
		var freq_nature						= "I";// Added in January 2014 for CIMS dosage check -End
		if((external_prod_id!='') && (drug_db_dosechk_yn=="Y")){
			var bean_id							= drug_frmobj.bean_id.value;
			var bean_name						= drug_frmobj.bean_name.value;
			var patient_id						= drug_frmobj.patient_id.value;
			var weight							= formObject.weight.value;
			if(weight=="")
				weight="0";
			var bsa								= formObject.bsa.value;
			if(bsa=="")
				bsa="0";
			var dose							= drug_frmobj.STRENGTH_VALUE.value;
			var dosage_by						= drug_frmobj.DOSAGE.value;
			var dose_uom						= "";
			if(dosage_by=='S')
				dose_uom    =  drug_frmobj.PRES_BASE_UOM.value;
			else
				 dose_uom   =  drug_frmobj.STRENGTH_UOM.value;
			var inf_prd_value = adminObj.INFUSION_PERIOD_VALUE.value;
			var inf_prd_value_min = adminObj.INFUSION_PERIOD_VALUE_MIN.value;
			if((inf_prd_value=="" || parseFloat(inf_prd_value)==0) && (inf_prd_value_min=="" || parseFloat(inf_prd_value_min)==0)){
				if(!adminObj.INFUSION_PERIOD_VALUE.disabled){
					adminObj.INFUSION_PERIOD_VALUE.focus();
					return false;
				}
			}
			var durn_value	  = adminObj.DURN_VALUE.value;
			infuseOverInMin = getInfuseOverInMin(inf_prd_value,inf_prd_value_min);
			infuseOverInMin = infuseOverInMin/60;
			var repeat_value					= Math.ceil(parseFloat(durn_value)/parseFloat(infuseOverInMin));
			if(fluidFormObj.mfr_yn.value == "Y")
				repeat_value = 1;
			durn_value = "1";
			var interval_value					= drug_frmobj.interval_value.value;
			if(interval_value=="") 
				interval_value="1";
			var drug_code						= drug_frmobj.DRUG_CODE.value; 
			var srl_no							= drug_frmobj.SRL_NO.value; 
			var strength_per_pres_uom			= drug_frmobj.strength_per_pres_uom.value; 
			var strength_per_value_pres_uom		= drug_frmobj.strength_per_value_pres_uom.value; 
			var fract_dose_round_up_yn			= drug_frmobj.fract_dose_round_up_yn.value; 
			var external_dosage_override_reason	= drug_frmobj.external_dosage_override_reason.value;

			var pract_name						= drug_frmobj.pract_name.value
			var xmlStr ="<root><SEARCH ";					
			xmlStr+= "patient_id =\"" + patient_id + "\" " ;
			xmlStr+= "external_prod_id =\"" + external_prod_id + "\" " ;
			xmlStr+= "weight =\"" + weight + "\" " ;
			xmlStr+= "bsa =\"" + bsa + "\" " ;
			xmlStr+= "dose =\"" + dose + "\" " ;
			xmlStr+= "dosage_by =\"" + dosage_by + "\" " ;
			xmlStr+= "dose_uom =\"" + dose_uom + "\" " ;
			xmlStr+= "repeat_value =\"" + repeat_value + "\" " ;
			xmlStr+= "interval_value=\"" + interval_value + "\" " ;
			xmlStr+= "durn_value =\"" + durn_value + "\" " ;
			xmlStr+= "drug_code =\"" + drug_code + "\" " ;
			xmlStr+= "srl_no =\"" + srl_no + "\" " ;
			xmlStr+= "strength_per_pres_uom =\"" + strength_per_pres_uom + "\" " ;
			xmlStr+= "strength_per_value_pres_uom =\"" + strength_per_value_pres_uom + "\" " ;
			xmlStr+= "fract_dose_round_up_yn =\"" + fract_dose_round_up_yn + "\" " ;
			xmlStr+= "adm_prsc =\"" + adm_prsc + "\" " ;
			xmlStr+= "called_from =\"" + called_from + "\" " ;
			xmlStr+= "external_dosage_override_reason=\"" + external_dosage_override_reason + "\" " ;
			xmlStr+= "pract_name=\"" + pract_name + "\" " ;
			xmlStr+= "route_code=\"" + route_code + "\" " ; // Added in January 2014 for CIMS dosage check -start
			xmlStr+= "qty_desc_code=\"" + qty_desc_code + "\" " ;
			xmlStr+= "repeat_durn_type=\"" + repeat_durn_type + "\" " ;
			xmlStr+= "freq_nature=\"" + freq_nature + "\" " ;  //Added in January 2014, CIMS Dosage Check -end
			xmlStr +=" /></root>";
			var temp_jsp="IVPrescriptionValidate.jsp?validate=ExternalDoseCheck"+"&bean_id="+bean_id+"&bean_name="+bean_name;
			var xmlDoc = "" ;
			var xmlHttp = new XMLHttpRequest() ;
			xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
			xmlHttp.open("POST",temp_jsp,false);
			xmlHttp.send(xmlDoc);
			responseText=xmlHttp.responseText ;
			eval(responseText);
		}
		else if(drug_db_dosechk_yn=="Y"){
			var bean_id							= drug_frmobj.bean_id.value;
			var bean_name						= drug_frmobj.bean_name.value;
			var patient_id						= drug_frmobj.patient_id.value;
			var weight							= formObject.weight.value;
			if(weight=="")
				weight="0";
			var bsa								= formObject.bsa.value;
			if(bsa=="")
				bsa="0";
			var inf_prd_value = adminObj.INFUSION_PERIOD_VALUE.value;
			var inf_prd_value_min = adminObj.INFUSION_PERIOD_VALUE_MIN.value;
			if(fluidFormObj.fluid.value != "" && ((inf_prd_value=="" || parseFloat(inf_prd_value)==0) && (inf_prd_value_min=="" || parseFloat(inf_prd_value_min)==0))){
				alert(getMessage("PRES_IV_INF_OVER_NOT_BLANK","PH"));
				return false;
			}
			var durn_value	  = adminObj.DURN_VALUE.value;
			inf_prd_value_hr = (parseFloat(getInfuseOverInMin(inf_prd_value,inf_prd_value_min)))/60;
			var repeat_value					= Math.round(parseFloat(durn_value)/parseFloat(inf_prd_value_hr));
			durn_value = "1";
			var interval_value="1";
			var pract_name						= formObject.pract_name.value
			var xmlStr ="<root><SEARCH ";					
			xmlStr+= "patient_id =\"" + patient_id + "\" " ;
			xmlStr+= "weight =\"" + weight + "\" " ;
			xmlStr+= "bsa =\"" + bsa + "\" " ;
			xmlStr+= "repeat_value =\"" + repeat_value + "\" " ;
			xmlStr+= "interval_value=\"" + interval_value + "\" " ;
			xmlStr+= "durn_value =\"" + durn_value + "\" " ;
			xmlStr+= "adm_prsc =\"" + adm_prsc + "\" " ;
			xmlStr+= "called_from =\"" + called_from + "\" " ;
			xmlStr+= "pract_name=\"" + pract_name + "\" " ;
			xmlStr+= "route_code=\"" + route_code + "\" " ; // Added in January 2014 for CIMS dosage check -start
			xmlStr+= "qty_desc_code=\"" + qty_desc_code + "\" " ;
			xmlStr+= "repeat_durn_type=\"" + repeat_durn_type + "\" " ;
			xmlStr+= "freq_nature=\"" + freq_nature + "\" " ;  //Added in January 2014, CIMS Dosage Check -end
			xmlStr +=" /></root>";
			var temp_jsp="IVPrescriptionValidate.jsp?validate=ExternalDoseCheck"+"&bean_id="+bean_id+"&bean_name="+bean_name;
			var xmlDoc = "" ;
			var xmlHttp = new XMLHttpRequest() ;
			xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
			xmlHttp.open("POST",temp_jsp,false);
			xmlHttp.send(xmlDoc);
			responseText=xmlHttp.responseText ;
			eval(responseText);
		}
	}
}

function setextdoseflag(drug_db_dose_check_flag){
	var drug_frmobj	    = document.formIVPrescriptionDrugDetails; 
	drug_frmobj.drug_db_dose_check_flag.value	=	drug_db_dose_check_flag;
}

function displayDispLocn(ord_disp_location,time_flag){
	if(parent.parent.parent.parent.f_ivbutton != undefined){
		parent.parent.parent.parent.f_ivbutton.document.getElementById('dflt_disp_locn_lbl').innerText = ord_disp_location;
	    parent.parent.parent.parent.f_ivbutton.document.formIVPrescriptionButtons.time_flag.value =time_flag;
	}
	else if(parent.parent.parent.f_ivbutton != undefined){
		parent.parent.parent.f_ivbutton.document.getElementById('dflt_disp_locn_lbl').innerText = ord_disp_location;
	    parent.parent.parent.f_ivbutton.document.formIVPrescriptionButtons.time_flag.value =time_flag;
	}
	else if(parent.parent.f_ivbutton != undefined){
		parent.parent.f_ivbutton.document.getElementById('dflt_disp_locn_lbl').innerText = ord_disp_location;
	    parent.parent.f_ivbutton.document.formIVPrescriptionButtons.time_flag.value =time_flag;
	}
	else{
		parent.parent.frames[3].document.getElementById('dflt_disp_locn_lbl').innerText = ord_disp_location;
	    parent.parent.frames[3].document.formIVPrescriptionButtons.time_flag.value =time_flag;
	}
}

function assignDfltVehicle(fluid_code,dflt_drug_desc, volume_of_drug, default_yn, trade_code, trade_name, fluid_adr_count){ 
	var frmVehicleObj="";
	if(parent.parent.f_iv_fluid != undefined){
		frmVehicleObj	= parent.parent.f_iv_fluid.formIVPrescriptionDetails;
		frmAdminObj	= parent.parent.f_iv_admin.formIVPrescriptionAdminDetail;
	}
	else{
		frmVehicleObj	= parent.parent.parent.f_iv_fluid.formIVPrescriptionDetails;
		frmAdminObj	= parent.parent.f_iv_admin.formIVPrescriptionAdminDetail;
	}
	var element = document.createElement('OPTION') ;
	element.value		=  fluid_code ;
	element.volume_of_drug		= volume_of_drug ;
	element.trade_code				= trade_code;
	if(trade_name!= "")
		trade_name = "  ("+decodeURIComponent(trade_name)+")";
	element.text		= decodeURIComponent(dflt_drug_desc) +trade_name;
	if(default_yn =='Y'){
		element.selected	=	true;
		frmVehicleObj.stock_value.value	= volume_of_drug;
		if(frmAdminObj.iv_calc_infuse_by.value=='I'){
			frmVehicleObj.volumePerUnit.value	= volume_of_drug;
			frmVehicleObj.volume_reference.value	= volume_of_drug;//Added for AAKH-CRF-0094
			frmAdminObj.order_qty.value	= "1";
		}
		if(parseInt(fluid_adr_count)>0)
			 frmVehicleObj.document.fluid_ADR_img.style.visibility='visible';
		else{
			//console.log(parent.f_iv_fluid.formIVPrescriptionDetails);
//			
			frmVehicleObj=parent.parent.f_iv_fluid.formIVPrescriptionDetails;
			parent.parent.f_iv_fluid.document.getElementById('fluid_ADR_img').style.visibility='hidden';
		}
	}
	frmVehicleObj.fluid.add(element);
	if(frmVehicleObj.edl_info.style.visibility != "visible")
		frmVehicleObj.edl_info.style.visibility="visible";
}

/*function assignDfltVehicle(dflt_drug_code,dflt_drug_desc,volume_of_drug,fluid_adr_count){ 
	var frmVehicleObj	= parent.parent.f_iv_fluid.formIVPrescriptionDetails;
	frmVehicleObj.fluid_code.value		= dflt_drug_code; 
	frmVehicleObj.fluid_name.value		= dflt_drug_desc;
	//frmVehicleObj.default_fluid_name.value		= dflt_drug_desc;
	frmVehicleObj.stock_value.value				= volume_of_drug;   
    displayADRimage(fluid_adr_count)
}*/

function clearDfltVehicle(){
	var frmVehicleObj;
	if(parent.parent.f_iv_fluid != undefined)
		frmVehicleObj	= parent.parent.f_iv_fluid.formIVPrescriptionDetails;
	else
		frmVehicleObj	= parent.parent.parent.f_iv_fluid.formIVPrescriptionDetails;
	var len =frmVehicleObj.fluid.options.length;
	for(var i=0;i<len;i++) {
		frmVehicleObj.fluid.remove("frequency") ;
	}
}

function changeFluid(obj,param_volume_cal){//parameter "param_volume_cal " passed , added for AAKH-CRF-0094 
	var frmObj			= document.formIVPrescriptionDetails;
	var frmAdminObj		= parent.f_iv_admin.document.formIVPrescriptionAdminDetail;
	if(parent.parent.parent.f_header!=undefined)
		header_form = parent.parent.parent.f_header.document.prescription_header_form;
    else
		header_form = parent.parent.f_header.document.prescription_header_form;
		
	if(obj.value != "")
		frmObj.edl_info.style.visibility="visible";
	var fluid_code		= frmObj.fluid.value;
	var trade_code			= frmObj.fluid.trade_code;
	if(trade_code == undefined)
		trade_code="";
	var bean_id				= frmAdminObj.BEAN_ID.value;
	var bean_name			= frmAdminObj.BEAN_NAME.value;
	var priority				= header_form.priority.value;
	var location_type			= header_form.location_type.value;
	var location_code			= header_form.location_code.value;
	var take_home_medication	= header_form.take_home_medication.value;
	var iv_prep_yn = "";
	if(frmObj.admixture.checked == true)
		iv_prep_yn = "2";
	else
		iv_prep_yn = "1";
		var pres_drug_code= frmAdminObj.drug_codes.value;//Added for ML-MMOH-CRF-1223
	//added for AAKH-CRF-0094 Start
if(param_volume_cal=="N")
	{
	frmAdminObj.INFUSION_VALUE.value="";
	}//AAKH-CRF-0094 End
	var qryString			= bean_id+"&bean_name="+bean_name+"&validate=FLUIDDETAILS&drug_code="+fluid_code+"&patient_id="+frmObj.patient_id.value+"&encounter_id="+frmObj.encounter_id.value+"&lang_id="+frmObj.language_id.value+"&trade_code="+trade_code+"&location_type="+location_type+"&location_code="+location_code+"&take_home_medication="+take_home_medication+"&priority="+priority+"&iv_prep_yn="+iv_prep_yn+"&pres_drug_code="+pres_drug_code;//pres_drug_code added for ML-MMOH-CRF-1223
	submitXML(qryString, "");
}

function displayADRimage(count){		

	var frmVehicleObj= "";
	if(parent.parent.f_iv_fluid!= undefined)
        frmVehicleObj= parent.parent.f_iv_fluid.formIVPrescriptionDetails;
	else
        frmVehicleObj= parent.f_iv_fluid.formIVPrescriptionDetails;
			
	if(parseInt(count)>0)
        frmVehicleObj.document.getElementById('fluid_ADR_img').style.visibility='visible';
	else
		frmVehicleObj.document.getElementById('fluid_ADR_img').style.visibility='hidden';
}

function DosageLimitCheck(obj){
	if(obj.value == "" || parseInt(obj.value) ==0)
		return false;
	var drug_frmobj		    =  document.formIVPrescriptionDrugDetails;
	var mode = drug_frmobj.mode.value;
	if(mode=='amend'){
		var formObject			=  parent.parent.parent.f_header.document.prescription_header_form;
		var adminObj			=  parent.parent.f_iv_admin.formIVPrescriptionAdminDetail;
	}
	else{
		var formObject			=  parent.parent.parent.parent.f_header.document.prescription_header_form;
		var adminObj			=  parent.parent.f_iv_admin.formIVPrescriptionAdminDetail;
	}

	var external_prod_id    = "";
    if(drug_frmobj.external_product_id != undefined){
		external_prod_id    = drug_frmobj.external_product_id.value;
	}
    var drug_db_dosechk_yn  = formObject.drug_db_dosecheck_yn.value;
	var drug_db_interface_yn = formObject.drug_db_interface_yn.value;
	if(drug_db_interface_yn == "Y"){
		if((external_prod_id!='') && (drug_db_dosechk_yn=="Y")){
			ExternalDosageCheck(mode,'presc');
			return;
		}
	}
	var bean_id = drug_frmobj.bean_id.value;
	var bean_name = drug_frmobj.bean_name.value;
	var patient_id = drug_frmobj.patient_id.value;
	var drug_code = drug_frmobj.DRUG_CODE.value;
	var srl_no = drug_frmobj.SRL_NO.value;
	var qty_value = drug_frmobj.STRENGTH_VALUE.value;
	var dosage_type = drug_frmobj.DOSAGE.value;
	//ML-MMOH-CRF-1408 - start
	var weight			 = formObject.weight.value;
	var bsa			 = formObject.bsa.value;
	var calc_by_ind =drug_frmobj.calc_by_ind.value;
	var factor;
	var mode="1";
	var temp_qty ="";
	//Modified for IN:073486 start
	 //if(formObject.bsa.value.length > 0){
		 if(drug_frmobj.calc_by_ind!=undefined){ 
			 if(calc_by_ind=="W") {
				 if(formObject.weight.value.length > 0){
				 temp_qty	=	(parseFloat(qty_value)/parseFloat(weight));
				factor=weight;
				 }
				 else{
					 temp_qty=qty_value;
					 factor="1"; 
				 }
			}
			else if(calc_by_ind=="B") {
				 if(formObject.bsa.value.length > 0){
				temp_qty	=	(parseFloat(qty_value)/parseFloat(bsa));
				factor=bsa;
				 }
				 else{
					 temp_qty=qty_value;
					 factor="1"; 
				 }
		   }else{
			 temp_qty=qty_value;
			 factor="1";
		   }
		 }else{
			 temp_qty=qty_value;
		 factor="1";
		 }
	// }
		//Modified for IN:073486 END
	 if(temp_qty==""){ 
		 temp_qty = qty_value;
		 factor="1";
	 }
	 //ML-MMOH-CRF-1408 - end
	var repeat_value = '1';
	var xmlStr ="<root><SEARCH ";					
	xmlStr+= "patient_id =\"" + patient_id + "\" " ;
	xmlStr+= "drug_code =\"" + drug_code + "\" " ;
	xmlStr+= "srl_no =\"" + srl_no + "\" " ;
	xmlStr+= "repeat_value =\"" + repeat_value + "\" " ;
	xmlStr+= "qty_value =\"" + temp_qty + "\" " ;//Modified for IN:070451
	xmlStr+= "dosage_type =\"" + dosage_type + "\" " ;
	xmlStr+= "factor =\"" + factor + "\" " ;//Added for IN:070451
	xmlStr+= "mode =\"" + mode + "\" " ;//Added for IN:070451
	xmlStr +=" /></root>";
	var temp_jsp="IVPrescriptionValidate.jsp?validate=DosageLimitCheck"+"&bean_id="+bean_id+"&bean_name="+bean_name;
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest() ;
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST",temp_jsp,false);
	xmlHttp.send(xmlDoc);
	responseText=xmlHttp.responseText ;
	eval(responseText);
}

function enableDosageLimit(limit_ind,daily_dose,unit_dose,mono_graph, min_daily_dose, min_unit_dose,mode){//Modified for IN:070451 added mode
	
	var drug_frmobj		    =  document.formIVPrescriptionDrugDetails;
	drug_frmobj.LIMIT_IND.value=limit_ind;
	drug_frmobj.DAILY_DOSE.value=daily_dose;
	drug_frmobj.UNIT_DOSE.value=unit_dose;
	drug_frmobj.MONO_GRAPH.value=unescape(mono_graph);
	drug_frmobj.MIN_DAILY_DOSE.value=min_daily_dose;
	drug_frmobj.MIN_UNIT_DOSE.value=min_unit_dose;
	var button_formobj = parent.parent.frames[0].f_drug_button.formIVPrescriptionDrugDetailButtons;
	button_formobj.OVERRIDE_LINK.style.display="inline";
}

function disableDosageLimit(mode){//Modified for IN:070451 added mode
	try{
		var drug_frmobj		    =  document.formIVPrescriptionDrugDetails;
		var current_rx= drug_frmobj.CURRENT_RX.value;
		var allergy_yn= drug_frmobj.ALLERGY_YN.value;
		var abuse_action= drug_frmobj.abuse_action.value;//added for aakh-crf-0140
		drug_frmobj.LIMIT_IND.value="Y";
		if(current_rx=="N" && allergy_yn=="N" && abuse_action=="U"){//modified for aakh-crf-0140
			drug_frmobj.DAILY_DOSE.value="";
			drug_frmobj.UNIT_DOSE.value="";
			drug_frmobj.MONO_GRAPH.value="";
			drug_frmobj.MIN_DAILY_DOSE.value="";
			drug_frmobj.MIN_UNIT_DOSE.value="";
			var button_formobj = parent.parent.frames[0].f_drug_button.formIVPrescriptionDrugDetailButtons;
			button_formobj.OVERRIDE_LINK.style.display="none";
		}
	}
	catch(e){
	}
}

function defaultRecomDose(){
	var drug_frmobj		    =  document.formIVPrescriptionDrugDetails;
	mode = drug_frmobj.mode.value;
	if(mode == 'amend'){
		var formObject			=  parent.parent.parent.f_header.document.prescription_header_form;
		var adminObj			=  parent.parent.f_iv_admin.formIVPrescriptionAdminDetail;
	}
	else{
		var formObject			=  parent.parent.parent.parent.f_header.document.prescription_header_form;
		var adminObj			=  parent.parent.f_iv_admin.formIVPrescriptionAdminDetail;
	}
	if(formObject.height!=undefined && formObject.height!=null && formObject.weight!=null) {
		var weight		= formObject.weight.value;
		var bsa			= formObject.bsa.value;
		var dosage_std	=	drug_frmobj.dosage_std.value;
		var recom_dosage_unit	=	drug_frmobj.dosage_unit.value;
		var recomm_dosage_by	=	drug_frmobj.recomm_dosage_by.value;
		var dosage_by	=	drug_frmobj.DOSAGE.value;
		var pres_dosage_unit	=	drug_frmobj.STRENGTH_UOM.value;
		var prescrib_uom	=	drug_frmobj.STRENGTH_UOM.value;
		if(recomm_dosage_by == dosage_by && prescrib_uom == recom_dosage_unit){
			drug_frmobj.STRENGTH_VALUE.value = dosage_std;
			drug_frmobj.STRENGTH_VALUE.focus();
		}

	/*	var title="<table border=1 cellpadding=0 cellspacing=0 align=center><tr><td class=TIP>&nbsp Std Dose: "+dosage_std+" "+recom_dosage_unit+"&nbsp</td></tr></table>";
		if(drug_frmobj.calc_by_ind.value=="A") {
			drug_frmobj.rec_value.innerHTML	= dosage_std;
			drug_frmobj.rec_uom.innerHTML		= recom_dosage_unit;
		}
		else if(formObject.height.value.length > 0 && formObject.weight.value.length > 0){
			 if(drug_frmobj.calc_by_ind.value=="W") {
				var calc_value	=	parseInt(parseFloat(weight)*parseFloat(dosage_std));
				drug_frmobj.rec_value.innerHTML ="<label nowrap style='color:red;font-size:10' onmouseover='displayToolTipDataChange(\"" + title + "\");' onmouseout='disasbleToolTipDataChange();'>"+calc_value+"</label>";
				var dos_unit = dosage_unit.split("/");
				drug_frmobj.rec_uom.innerHTML ="<label nowrap style='color:red;font-size:10' onmouseover='displayToolTipDataChange(\"" + title + "\");' onmouseout='disasbleToolTipDataChange();'>"+dos_unit[0]+"</label>";
			}
			else if(drug_frmobj.calc_by_ind.value=="B") {
				var calc_value	=	parseInt(parseFloat(bsa)*parseFloat(dosage_std));
				drug_frmobj.rec_value.innerHTML ="<label nowrap style='color:red;font-size:10' onmouseover='displayToolTipDataChange(\"" + title + "\");' onmouseout='disasbleToolTipDataChange();'>"+calc_value+"</label>";
				var dos_unit = dosage_unit.split("/");
				drug_frmobj.rec_uom.innerHTML ="<label nowrap style='color:red;font-size:10' onmouseover='displayToolTipDataChange(\"" + title + "\");' onmouseout='disasbleToolTipDataChange();'>"+dos_unit[0]+"</label>";
			}
		}*/
	}
}

async function displayChargeDetails(iv_prep_yn,default_comp_fluid_falg){//default_comp_fluid_falg added for ML-MMOH-CRF-1223
	if(parent.parent.f_header != undefined){
		var headerForm = parent.parent.f_header.document.prescription_header_form;
		var adminForm = parent.f_ivdetails.f_iv_admin.document.formIVPrescriptionAdminDetail;
		var fluidForm	= parent.f_ivdetails.f_iv_fluid.document.formIVPrescriptionDetails;
	}
	else{
		var headerForm = parent.f_header.document.prescription_header_form;
		var adminForm = parent.f_detail.f_iv_admin.document.formIVPrescriptionAdminDetail;
		var fluidForm	= parent.f_detail.f_iv_fluid.document.formIVPrescriptionDetails;
	}
	var bean_id = adminForm.BEAN_ID.value;
	var bean_name = adminForm.BEAN_NAME.value
	var patient_id = headerForm.patient_id.value
	var take_home_medication = headerForm.take_home_medication.value
	var encounter_id = headerForm.encounter_id.value
	var actual_patient_class = headerForm.actual_patient_class.value
	var infuseOver = "";
	var lstInfusionRateDurnUnit="";
	var fluid_code		  = fluidForm.fluid.value;
	if(fluid_code==undefined || fluid_code==''){
		alert(getMessage("FLUID_CANT_BLANK","PH"));
		return false;
	}
	else if(adminForm.MFR_YN_Flag.value != "Y"){ 
		if((trimCheck(adminForm.INFUSION_PERIOD_VALUE.value) == "" || parseFloat(adminForm.INFUSION_PERIOD_VALUE.value) == 0) && (trimCheck(adminForm.INFUSION_PERIOD_VALUE_MIN.value) == "" || parseFloat(adminForm.INFUSION_PERIOD_VALUE_MIN.value) == 0) ) {
			alert(getMessage("INFS_OVR_CANT_BLANK_ZERO","PH"));
			adminForm.INFUSION_PERIOD_VALUE.focus();
			return false;
		}
		else if (trimCheck(adminForm.INFUSION_VALUE.value) == "" || parseFloat(adminForm.INFUSION_VALUE.value) ==0 ) {
			iv_calc_infuse_by = adminForm.iv_calc_infuse_by.value;
			var msg = getMessage("INFUSION_RATE_CANNOT_GREATER","PH");
			if(iv_calc_infuse_by=='I')
				msg = msg+"/"+getLabel("Common.Unit.label",'Common');
			alert(msg);
			//alert(getMessage("INF_RATE_CANT_BLANK_ZERO","PH"));
			adminForm.INFUSION_VALUE.focus();
			return false;
		}
		/*else if (parseInt(adminForm.INFUSION_VALUE.value)  > parseFloat(fluidForm.STOCK_VALUE.value) ){
			alert(getMessage("INFUSION_RATE_CANNOT_GREATER","PH"));
			adminForm.INFUSION_VALUE.focus();
			return false;
		}
		else if (parseFloat(adminForm.DURN_VALUE.value)  > 24 ) {
			alert(getMessage("IV_DURATION_CANNOT_GREATER","PH"));
			adminForm.DURN_VALUE.focus();
			return false;
		}*/
		else{
			lstInfusionRateDurnUnit = adminForm.lstInfusionRateDurnUnit.value;
			total_hr = adminForm.DURN_VALUE.value;
			total_hr = parseFloat(total_hr)*60;
			infuseOver = getInfuseOverInMin(adminForm.INFUSION_PERIOD_VALUE.value,adminForm.INFUSION_PERIOD_VALUE_MIN.value)
			var iv_calc_infuse_by = adminForm.iv_calc_infuse_by.value;
			if(infuseOver > 24*60 && default_comp_fluid_falg=="false"){ //Added for SKR-SCF-1100 [IN:057246]//default_comp_fluid_falg added for ML-MMOH-CRF-1223
				alert(getMessage("INFUSE_OVER_CANNOT_GREATER","PH"));
				return false;
			}
			else if(parseFloat(total_hr) < parseFloat(infuseOver) && iv_calc_infuse_by!='I'){
				//if(parseInt(adminForm.DURN_VALUE.value) < parseInt(adminForm.INFUSION_PERIOD_VALUE.value) ){
				//if(iv_calc_infuse_by=='I')//added for for  SKR-CRF-0035 [IN:037727] 
                   		alert(getMessage("DURATION_CANNOT_LESSTHAN","PH"));   // "INFUSE_OVER_CANNOT_GREATER" changed to "DURATION_CANNOT_LESSTHAN" for SKR-SCF-1100 [IN:057246]
				//else
					//alert(getMessage("DURATION_CANNOT_LESSTHAN","PH"));
				adminForm.INFUSION_PERIOD_VALUE.focus();
				return false;
			}
		}
	}

	var infusion_over	  = "";
	var tot_inf_prd		= "";
	var durn_value		= "";
	if(adminForm.MFR_YN_Flag.value != "Y"){
		infuseOver = parseFloat(infuseOver/60);
		infuseOver = (infuseOver*100)/100;
		infusion_over	  = adminForm.INFUSION_PERIOD_VALUE.value;
		durn_value		= adminForm.DURN_VALUE.value;
		lstInfusionRateDurnUnit		= adminForm.lstInfusionRateDurnUnit.value;
	}
	tot_inf_prd		= fluidForm.STOCK_VALUE.value;
	var orderDate = headerForm.sys_date.value;
	var xmlStr ="<root><SEARCH ";					
	xmlStr+= "patient_id =\"" + patient_id + "\" " ;
	xmlStr+= "fluid_code =\"" + fluid_code + "\" " ;
	xmlStr+= "infusion_over =\"" + infuseOver + "\" " ;
	xmlStr+= "tot_inf_prd =\"" + tot_inf_prd + "\" " ;
	xmlStr+= "durn_value =\"" + durn_value + "\" " ;
	xmlStr+= "lstInfusionRateDurnUnit =\"" + lstInfusionRateDurnUnit + "\" " ;
	xmlStr+= "orderDate =\"" + orderDate + "\" " ;
	xmlStr+= "MFR_YN =\"" + adminForm.MFR_YN_Flag.value + "\" " ;
	xmlStr+= "iv_calc_infuse_by =\"" + adminForm.iv_calc_infuse_by.value + "\" " ;
	xmlStr +=" /></root>";
	var temp_jsp="IVPrescriptionValidate.jsp?validate=SAVE_FLUIDDETAILS"+"&bean_id="+bean_id+"&bean_name="+bean_name;
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest() ;
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST",temp_jsp,false);
	xmlHttp.send(xmlDoc);
	responseText=xmlHttp.responseText ;
	eval(responseText);
	var dialogHeight= "45vh" ;
	var dialogWidth	= "80vw" ;
	var dialogTop	= "305" ;
	var dialogLeft	= "0" ;
	var center		= "1" ;
	var status		= "no";
	var scroll		= "yes";
	var features	= "dialogLeft:" + dialogLeft + ";dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; center: " + center + ";scroll "+scroll+"; status: " + status + "; dialogTop :" + dialogTop;
	var arguments	= "" ;
	retVal = await top.window.showModalDialog("../../ePH/jsp/ChargeDetail.jsp?bean_id="+bean_id+"&bean_name="+bean_name+"&patient_id="+patient_id+"&encounter_id="+encounter_id+"&actual_patient_class="+actual_patient_class+"&iv_prep_yn="+iv_prep_yn+"&fluid_code="+fluid_code+"&infusion_over="+infuseOver+"&durn_value="+durn_value+"&lstInfusionRateDurnUnit="+lstInfusionRateDurnUnit+"&take_home_medication="+take_home_medication+"&MFR_YN="+adminForm.MFR_YN_Flag.value+"&iv_calc_infuse_by="+adminForm.iv_calc_infuse_by.value,arguments,features);
	if(retVal!= undefined && retVal!=null && retVal!="")
		alertBLErrorDrugs(retVal);
}

/*function assignOverrideExclInclInd(obj, bl_included_IE){
	if(bl_included_IE=='I' && obj.checked == true){
		obj.value = "E";
	}
	else if(bl_included_IE=='E' && obj.checked == true){
		obj.value = "I";
	}
	else obj.value ="";
	if(obj.checked == true){
		document.getElementById("bl_overriden_action_reason_img").style.visibility='visible';
		document.prescription_detail_form.bl_overriden_action_reason_lkp.disabled=false;
	}
	else{
		document.getElementById("bl_overriden_action_reason_img").style.visibility='hidden';
		document.prescription_detail_form.bl_overriden_action_reason_lkp.disabled=true;
		document.prescription_detail_form.bl_incl_excl_override_reason_code.value = "";
		document.prescription_detail_form.bl_incl_excl_override_reason_desc.value = "" ;
	}
	getChargeDetails("Y");
}*/

function alertBLErrorDrugs(blErrorDrugs, called_from){
	blErrorDrugs = blErrorDrugs.substring(1,blErrorDrugs.length-2);
	blErrorDrugs = blErrorDrugs.split(',');
	var bl_alert_msg=getMessage("ERROR_IN_BILLING",'PH')+"\n";
	var drug_or_fluid="";
	for(var i=0; i<blErrorDrugs.length; i++){
		if(drug_or_fluid == "")
			drug_or_fluid	= trimString(blErrorDrugs[i++]);
		else
			i++;
		drug_desc	= decodeURIComponent(trimString(blErrorDrugs[i++]));
		bl_error_code = trimString(blErrorDrugs[i++]);
		bl_sys_message_id = trimString(blErrorDrugs[i++]);
		bl_error_text = trimString(blErrorDrugs[i]);
		if ((bl_error_code == "10" && bl_error_text =="") || bl_sys_message_id!=""){
			if(bl_sys_message_id!=""){
				bl_error_text = getMessage(bl_sys_message_id,'BL');
			}
		}
		bl_alert_msg += drug_desc+" --> "+ bl_error_text+"\n";
	}
	alert(bl_alert_msg);
	callClearAll(1,'','', true);
	return false;
}

function ChangeInfuseOverTime(obj){
	var frmAdminObj	= document.formIVPrescriptionAdminDetail;
	frmAdminObj.INFUSION_PERIOD_UOM.value		=	"H";
	if(obj.value=="H"){
		frmAdminObj.infusionOverStr.innerHTML	= getHrsMinStr(frmAdminObj.INFUSION_PERIOD_VALUE.value,"H");
		frmAdminObj.INFUSION_UOM.value				=	"H";
	}
	else if(obj.value=="M"){
		frmAdminObj.infusionOverStr.innerHTML	= getHrsMinStr(frmAdminObj.INFUSION_PERIOD_VALUE.value,"M");
		//frmAdminObj.INFUSION_PERIOD_UOM.value		=	"M";
		frmAdminObj.INFUSION_UOM.value				=	"M";
	}
}

async function openEDLDetails(DrugCode){
	if(DrugCode!=''&&DrugCode!=null){
		var dialogHeight	= "40vh";
		var dialogWidth		= "35vw";
		var center			= "1";
		var status			= "no";
		var features		= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status;
		var arguments		= "";
		await window.showModalDialog("../jsp/EDLAssociateListViewFrames.jsp?DrugCode="+DrugCode, arguments, features);
	}
}//end function

 function getHrsMinStr(HMvalue,HMunit ){
//	 if( HMunit == 'H' ) {
		 hrs = Math.floor(HMvalue);
		 HMvalue = HMvalue * 60;
/*	 } 
	 else {
		 hrs = HMvalue / 60;
	 }*/
	 min = HMvalue % 60;
	 return( '['+Math.floor(hrs) + ' Hrs ' + Math.round(min) + ' Mins]' );
 }
 
 function getInfuseOverInMin(hr, mi){
	if(hr == "")
		hr = 0;
	if(mi == "")
		mi = 0;
	tot = parseFloat(hr*60)+parseFloat(mi);
	return tot;
 }

 async function showMultipleFlowRate(patient_id,encounter_id,mode,site_MFR_greater_than_24hr){ //site_MFR_greater_than_24hr added for ML-MMOH-CRF-1222
	var adminForm		= parent.f_iv_admin.formIVPrescriptionAdminDetail;
	var volume			= document.formIVPrescriptionDetails.stock_value.value;
	var base_volume		= document.formIVPrescriptionDetails.BASE_VOLUME.value;
	var stock_uom_code	= document.formIVPrescriptionDetails.STOCK_UOM_CODE.value;
	var fluid			= document.formIVPrescriptionDetails.fluid.value;
	var inf_rate		= "";
	var inf_over_hr		= "";
	var inf_over_min	= "";
	var start_date		= "";
	var end_date		= "";
	var InfRateHrMin	= "";
	var infusion_over_insert_value = "";
	previous		= adminForm.previous.value;
	if(fluid != ""){
		if(mode != 'amend'){
			inf_rate		= adminForm.INFUSION_VALUE.value;
			inf_over_hr		= adminForm.INFUSION_PERIOD_VALUE.value;
			inf_over_min	= adminForm.INFUSION_PERIOD_VALUE_MIN.value;
			start_date		= adminForm.START_DATE.value;
			end_date		= adminForm.END_DATE.value;
			InfRateHrMin	= adminForm.lstInfusionRateDurnUnit.value;

			infusion_over_insert_value = adminForm.infusion_over_insert_value.value;
			header_form		= parent.parent.parent.f_header.document.prescription_header_form;
		}
		else{
			header_form	= parent.parent.f_header.document.prescription_header_form;
		}
		var height			= header_form.height.value;
		var weight			= header_form.weight.value;
		var bean_id			= adminForm.BEAN_ID.value;
		var bean_name		= adminForm.BEAN_NAME.value

		var dialogTop		= "";
		var dialogHeight	= "50vh";
		var dialogWidth		= "80vw";
		var dialogLeft		= "";
		var features		= "Width:" + dialogWidth + "; dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +"; dialogLeft:" + dialogLeft +"; dialogTop:" + dialogTop +"; scroll=auto; status=no";
		var arguments		= "";
		//var previous is passed to the jsp for - prev order copy MFR issue : 26465

		var retVal 			=await top. window.showModalDialog("../../ePH/jsp/IVPrescriptionMFR.jsp?patient_id="+patient_id+"&encounter_id="+encounter_id+"&height="+height+"&weight="+weight+"&volume="+volume+"&inf_rate="+inf_rate+"&inf_over_hr="+inf_over_hr+"&inf_over_min="+inf_over_min+"&start_date="+start_date+"&end_date="+end_date+"&stock_uom_code="+stock_uom_code+"&InfRateHrMin="+InfRateHrMin+"&ivType=ivd"+"&mode="+mode+"&infusion_over_insert_value="+infusion_over_insert_value+"&bean_id="+bean_id+"&bean_name="+bean_name+"&base_volume="+base_volume+"&previous="+previous+"&site_MFR_greater_than_24hr="+site_MFR_greater_than_24hr,arguments,features);
		if(!retVal){
		}
		else if( retVal != undefined && retVal[1] > 1){
			document.formIVPrescriptionDetails.stock_value.value = retVal[0];
			document.formIVPrescriptionDetails.mfr_yn.value = "Y";
			adminForm.MFR_YN_Flag.value = "Y";
			document.formIVPrescriptionDetails.admixture.checked=false;
			document.formIVPrescriptionDetails.admixture.disabled=true;
			if(mode != 'amend'){
				adminForm.INFUSION_VALUE.disabled=true;
				adminForm.INFUSION_PERIOD_VALUE.disabled=true;
				adminForm.INFUSION_PERIOD_VALUE_MIN.disabled=true;
				adminForm.INFUSION_VALUE.value="";
				adminForm.INFUSION_PERIOD_VALUE.value="";
				parent.f_iv_admin.document.getElementById('infusionOverStr').innerHTML="";
				adminForm.INFUSION_PERIOD_VALUE_MIN.value="";
				adminForm.START_DATE.disabled=true;
				adminForm.Calendar.disabled=true;
				adminForm.END_DATE.disabled=true;
				adminForm.START_DATE.value=retVal[2];
				adminForm.END_DATE.value=retVal[3];
				adminForm.lstInfusionRateDurnUnit.disabled=true;
				adminForm.DURN_VALUE.disabled=true;
				adminForm.DURN_VALUE.value="";
				parent.f_iv_admin.document.getElementById('adminrate').style.visibility='hidden';
				document.getElementById('MFR_Indicator').src="../../eCommon/images/enabled.gif";
				document.getElementById('mfrRemarksLink').style.display = 'inline';
			}
			else{
				adminForm.START_DATE.value=retVal[2];
				adminForm.END_DATE.value=retVal[3];
			}
			document.formIVPrescriptionDetails.stock_value.disabled=true;
			var iv_calc_infuse_by = adminForm.iv_calc_infuse_by.value ;  //Added for SKR-CRF-0035 [IN:037727] -start
			if(iv_calc_infuse_by=='I'){
				var volumePerUnit = document.formIVPrescriptionDetails.volumePerUnit.value;
				var totVolume = retVal[0];
				var orderQty = parseInt(totVolume)/parseInt(volumePerUnit);
				adminForm.order_qty.value =Math.ceil(orderQty);
				adminForm.order_qty.disabled=true;
			}  //Added for SKR-CRF-0035 [IN:037727] -End
		}
	}
}

function setCalculateBy(obj,mode){
	DosageLimitCheck(obj);//Added for IN:070451
	val1=obj.value;
	if(mode!="AMEND_RESET")	{
		frmobj=document.formIVPrescriptionDrugDetails;
	}
	else{
		frmobj=parent.f_sub_ivdrugs.document.formIVPrescriptionDrugDetails;
	}

// on click of the same radio button the value was getting changed. to avoid that, we have used this condition
	if(val1 == frmobj.current_CALC_DOSE_BASED_ON.value)
		return;
	else{
		if((val1=="B" && !(weight=="" || weight=="0" || height=="" || height=="0")) || val1=="D")
			frmobj.current_CALC_DOSE_BASED_ON.value = val1;
	}

/*	if(mode=="IVAD_AMEND" || mode=="AMEND_RESET" )
		var headerfrmobj=	parent.parent.parent.f_header.prescription_header_form;
	else
		var headerfrmobj=	parent.parent.parent.parent.f_header.prescription_header_form;
*/
	if(parent.parent.parent.f_header == undefined)
		headerfrmobj=	parent.parent.parent.parent.f_header.prescription_header_form;
	else
		headerfrmobj=	parent.parent.parent.f_header.prescription_header_form;

	var weight		=	headerfrmobj.weight.value;
    var height		=	headerfrmobj.height.value;
	
	if(frmobj.STR_VAL.value == "null")
		frmobj.STR_VAL.value = frmobj.STRENGTH_VALUE.value;

	if(obj.value=="B"){		
		if(weight=="" || weight=="0" || height=="" || height=="0"){
			alert(getMessage("PAT_HEIGHT_WEIGHT_BLANK","PH"));
			frmobj.CALC_DOSE_BASED_ON_D.checked=true;
			frmobj.CALC_DOSE_BASED_ON_B.checked=false;
			frmobj.current_CALC_DOSE_BASED_ON.value = "D";
			return false;
		}
		if(frmobj.DOSAGE.value=="Q"){
			frmobj.DOSAGE.value= "S";
			changeScrDetails("S");
		}
		frmobj.calc_by_row2.style.display="inline";
		frmobj.calc_by_row1.style.display="none";
		calculateDosage_By_BSA_or_Weight(mode);
		//alert(frmobj.STRENGTH_VALUE.value);
		//frmobj.strength_value_wt_bsa.value=frmobj.STR_VAL.value;
	}
	else{
		frmobj.calc_by_row1.style.display="inline";
		frmobj.calc_by_row2.style.display="none";	

		if(frmobj.amend_yn.value != "Y"){// if not yet confirmed then load the default strength value
			frmobj.STRENGTH_VALUE.value=frmobj.strength_per_pres_uom.value;
			frmobj.STR_VAL.value = frmobj.strength_per_pres_uom.value;
		}
		else{
			if(frmobj.STR_VAL.value != null && frmobj.STR_VAL.value != "null" && frmobj.STR_VAL.value >0)
				frmobj.STRENGTH_VALUE.value=frmobj.STR_VAL.value;
			else{
				frmobj.strength_value_wt_bsa.value=frmobj.strength_value_wt_bsa.value!=""?frmobj.strength_value_wt_bsa.value:"";
				frmobj.STR_VAL.value = frmobj.strength_value_wt_bsa.value;
			}
		}
		//frmobj.STRENGTH_VALUE.value="";
	}
}

function calculateDosage_By_BSA_or_Weight(mode){
	if(mode!="AMEND_RESET"){
		var frmobj		=	document.formIVPrescriptionDrugDetails;
	}
	else{
		var frmobj		=	parent.f_sub_ivdrugs.document.formIVPrescriptionDrugDetails;
	}
	if(mode=="IVAD_AMEND" || mode=="AMEND_RESET")
	var headerfrmobj=	parent.parent.parent.f_header.prescription_header_form;
	else
	var headerfrmobj=	parent.parent.parent.parent.f_header.prescription_header_form;

	var baseDoseValue=	frmobj.CALC_DOSE_VALUE.value;
	var kg_m2_value	=	frmobj.CALC_DOSE_BY.value;
	var weight		=	headerfrmobj.weight.value;
    var bsa			=	headerfrmobj.bsa.value;
	
	if(baseDoseValue!="" && baseDoseValue!="0"){
		totDoseValue="";
		if(kg_m2_value=="KG"){
			totDoseValue=parseFloat(baseDoseValue)*parseFloat(weight);
		}
		else{
			totDoseValue=parseFloat(baseDoseValue)*parseFloat(bsa);
		}
		
		if(isNaN(totDoseValue)){
			//totDoseValue=frmobj.STR_VAL.value;
			frmobj.strength_value_wt_bsa.value=frmobj.STR_VAL.value;
		}
		else{
			frmobj.strength_value_wt_bsa.value=Math.round(parseFloat(totDoseValue)*1000)/1000;
		}		
	}
	else{
		//frmobj.strength_value_wt_bsa.value="0";
		if(frmobj.STR_VAL.value != null && frmobj.STR_VAL.value != "null" && frmobj.STR_VAL.value > 0 )
			frmobj.strength_value_wt_bsa.value=frmobj.STR_VAL.value;
		else
			frmobj.strength_value_wt_bsa.value=frmobj.strength_value_wt_bsa.value!=""?frmobj.strength_value_wt_bsa.value:"";
	}
	frmobj.STRENGTH_VALUE.value=frmobj.strength_value_wt_bsa.value;
}

function assignStrengthForBSA(){
	var frmobj		=	document.formIVPrescriptionDrugDetails;
	frmobj.STRENGTH_VALUE.value=frmobj.strength_value_wt_bsa.value;
}

async function showMFRRemarks(){
	var frmObj=document.formIVPrescriptionDetails;
	var bean_id = frmObj.bean_id.value;
	var bean_name = frmObj.bean_name.value;
	var mfr_remarks=frmObj.mfr_remarks.value;

	var dialogTop		= "400";
	var dialogHeight	= "14";
	var dialogWidth		= "25";
	var dialogLeft		= "500";
	var features		= "Width:" + dialogWidth + "; dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +"; dialogLeft:" + dialogLeft +"; dialogTop:" + dialogTop +"; scroll=NO; status=no";
	var arguments		= "";
	var retVal 			=await  window.showModalDialog("../jsp/IVPrescriptionMFRRemarks.jsp?mfr_remarks="+mfr_remarks,arguments,features);		
	if(retVal != undefined ){		
		frmObj.mfr_remarks.value= retVal[0];		
	}
}

function callCheckMaxLen(obj,noOfChars,Legend){	
	if(trimCheck(obj.value)==""){
		return false;
	}
	if(obj.value.length > noOfChars) {
        alert("APP-SM0045 - " + Legend + " "+getLabel("ePH.Cannotexceed.label",'PH')+" " + noOfChars  + getLabel("ePH.characters.label",'PH')) ;
		obj.focus(); 
	}
	else{		
		return true;
	}
}

function setBackFutureDate(back_date, future_date) {
	parent.parent.f_iv_fluid.document.formIVPrescriptionDetails.back_date.value=back_date ;
	parent.parent.f_iv_fluid.document.formIVPrescriptionDetails.future_date.value=future_date;
}

// RUT-CRF-0062 [IN029600]  Function added to set Build MAR Value -- begin
function setBuildMAR(buildMARDefaulting){
	// buildMARDefaulting may  get   'CE' - Checked Enabled  'UE' - Un-Checked Enabled  'CD' - Checked Disabled  'UD' - Un-Checked Disabled
	var buildMAR_checked=buildMARDefaulting.substring(0,1);
	var buildMAR_enabled=buildMARDefaulting.substring(1,2);
	var formobj		=	"";
	var expDisp=""; //Added for nmc-jd-crf-0046
	
	 if(parent.parent.f_iv_fluid.formIVPrescriptionDetails!=undefined)
	 {
		formobj			=	parent.parent.f_iv_fluid.formIVPrescriptionDetails;
	 }
	else if(parent.parent.parent.f_iv_fluid.formIVPrescriptionDetails!=undefined)
	{
		formobj			=	parent.parent.parent.f_iv_fluid.formIVPrescriptionDetails;
	}
	 expDisp= formobj.ext_disp_appl_yn.value; //Added for nmc-jd-crf-0046
	
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
	
	if(expDisp=="Y")    //Start of NMC-JD-0046
	{
		formobj.buildMAR_yn.checked=false;
		formobj.buildMAR_yn.disabled=true;
		formobj.buildMAR_yn.value="N";
	}
	else
	{
		formobj.buildMAR_yn.checked=true;
		formobj.buildMAR_yn.disabled=false;
		formobj.buildMAR_yn.value="Y";
	}             // End of NMC-JD-CRF-0046
}// RUT-CRF-0062 [IN029600]  -- end

async function drugindication_remarks(){//Added for  ML-BRU-CRF-072[Inc:29938]  start
	var formobj		=	document.formIVPrescriptionDrugDetails;
	var bean_id				= formobj.bean_id.value;
	var bean_name			= formobj.bean_name.value;
	var DrugIndicationRemarks	=	formobj.DrugIndicationRemarks.value;
	var dialogHeight= "40vh" ;
	var dialogWidth	= "50vw" ;
	var dialogTop = "" ;
	var dialogLeft ="";
	var center = "0" ;
	var status="no";
	var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" +dialogTop+"; dialogLeft :"+dialogLeft;
	var arguments	= "" ;
	retVal =await  top.window.showModalDialog("../../ePH/jsp/DrugIndicationRemarks.jsp?&DrugIndicationRemarks="+encodeURIComponent(DrugIndicationRemarks)+"&bean_id="+bean_id+"&bean_name="+bean_name+"&iv_prep_yn=1",arguments,features);//remove escape and add encodeURIComponent for MMS Adhoc Testing
	if(retVal!=null)
		formobj.DrugIndicationRemarks.value=retVal;	
}

function savedrugIndicationRemarks(drug_indicate){
	var drug_indication_new = encodeURIComponent(drug_indicate.value);
//	window.returnValue=drug_indication_new;
//	window.close();
	let dialogBody = parent.parent.document.getElementById('dialog-body');
    dialogBody.contentWindow.returnValue = drug_indication_new;
    
    const dialogTag = parent.parent.document.getElementById("dialog_tag");    
    dialogTag.close();  
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
}//Added for  ML-BRU-CRF-072[Inc:29938]  End

function calcTotalVolume(){
	if (parent.f_iv_admin == undefined){
		admnFrmObj	= parent.parent.f_iv_admin.document.formIVPrescriptionAdminDetail;
		fluidFrmObj	= parent.parent.f_iv_fluid.document.formIVPrescriptionDetails;
	}
	else{
		admnFrmObj	= parent.f_iv_admin.document.formIVPrescriptionAdminDetail;
		fluidFrmObj = parent.f_iv_fluid.document.formIVPrescriptionDetails;
	}
	var orderQty = admnFrmObj.order_qty.value;
	if(orderQty=="" ||  parseInt(orderQty)==0){
		alert(getMessage("PH_ORDER_QTY_BLANK","PH"));
		return false;
	}
	orderQty = parseInt(orderQty);
	var volumePerUnit = parseInt(fluidFrmObj.volumePerUnit.value);
	var totalVolume = volumePerUnit*orderQty;
	var volumeObj = fluidFrmObj.stock_value;
	volumeObj.value = totalVolume;
	setStockValue(volumeObj);
	var END_DATEObj = admnFrmObj.END_DATE;
	var INF_RATEObj = admnFrmObj.INFUSION_VALUE;
	var bean_id    = admnFrmObj.BEAN_ID.value;
	var bean_name  = admnFrmObj.BEAN_NAME.value;
	var start_date = admnFrmObj.START_DATE.value;
	var durnHrs =admnFrmObj.INFUSION_PERIOD_VALUE.value;
	var durnMins = admnFrmObj.INFUSION_PERIOD_VALUE_MIN.value;
	if(trimString(durnHrs)=="")
		durnHrs = '0';
	if(trimString(durnMins)=="")
		durnMins = '0';
	var durn_unit = "M";
	var DURN_VALUE =  (parseInt(durnHrs)*60)+parseInt(durnMins)
	var qryString	= bean_id+"&bean_name="+bean_name+"&validate=POPULATEENDDATEADMIN&start_date="+start_date+"&durn_value="+DURN_VALUE+"&durn_unit="+durn_unit+"&mode=IV_CALC";
	submitXML(qryString, "");
}
//AAKH-CRF-0089 starts
function setEmptyDose(){
	var dosage_applicable=document.formIVPrescriptionDrugDetails.def_dosage_yn.value;
	if(dosage_applicable=="N"){
		document.formIVPrescriptionDrugDetails.STRENGTH_VALUE.value="";
	}
}
//AAKH-CRF-0089 ends

// Added for AAKH-CRF-0094 START
function calVolumeInfuseOver(call_mode) {
	var frmObj = parent.f_iv_fluid.formIVPrescriptionDetails;
	var frmAdminObj = parent.f_iv_admin.formIVPrescriptionAdminDetail;
	var volume_reference = frmObj.volume_reference.value;
	var infusion_value = frmAdminObj.INFUSION_VALUE.value;
    var infusion_over;
	var INFUSION_PERIOD_VALUE = frmAdminObj.INFUSION_PERIOD_VALUE.value;
    INFUSION_PERIOD_VALUE = Math.floor(INFUSION_PERIOD_VALUE);
	var INFUSION_PERIOD_VALUE_MIN = frmAdminObj.INFUSION_PERIOD_VALUE_MIN.value;
	INFUSION_PERIOD_VALUE_MIN = Math.round(INFUSION_PERIOD_VALUE_MIN);
	var temp_volume;
	
	if(infusion_value == "" || parseFloat(infusion_value) == 0){
		alert(getMessage("INF_RATE_CANT_BLANK_ZERO", "PH"));
		frmAdminObj.INFUSION_VALUE.focus();
	}
	else if(((INFUSION_PERIOD_VALUE == "" || parseFloat(INFUSION_PERIOD_VALUE) == 0) && (INFUSION_PERIOD_VALUE_MIN == "" || parseFloat(INFUSION_PERIOD_VALUE_MIN) == 0))){
		alert(getMessage("INFS_OVR_CANT_BLANK_ZERO", "PH"));
		frmAdminObj.INFUSION_PERIOD_VALUE.focus();
		
	}
	
	else {
		var unit = frmAdminObj.lstInfusionRateDurnUnit.value;
		if (unit == "H") {
			var infusion_over_min = INFUSION_PERIOD_VALUE_MIN / 60;
				temp_volume = infusion_value * (INFUSION_PERIOD_VALUE + infusion_over_min);
			var temp2 = (Math.ceil(temp_volume / volume_reference)) * volume_reference;
			  frmObj.stock_value.value = temp2;
			  frmAdminObj.order_qty.value = Math.ceil(temp_volume / volume_reference);
		} else {
			infusion_over = (INFUSION_PERIOD_VALUE * 60) + INFUSION_PERIOD_VALUE_MIN;
			temp_volume = Math.ceil((infusion_value * infusion_over) / volume_reference);
			frmAdminObj.order_qty.value = temp_volume;
			frmObj.stock_value.value = temp_volume * volume_reference;
		}
		showAdminRate();
		calcQantityobVolume();
		//frmAdminObj.stock_value.value=temp_volume * volume_reference;
	}
	var str =   '['+Math.floor(INFUSION_PERIOD_VALUE) + ' Hrs ' + Math.round(INFUSION_PERIOD_VALUE_MIN) + ' Mins]' ;
	frmAdminObj.infusionOverStr.innerHTML	= str;
	
}
function calVolumeInfuseRate() {
	var frmObj = parent.f_iv_fluid.formIVPrescriptionDetails;
	var frmAdminObj = parent.f_iv_admin.formIVPrescriptionAdminDetail;
	var infusion_value = frmAdminObj.INFUSION_VALUE.value;
	var volume_reference = frmObj.volume_reference.value;
	var infusion_over;
	var INFUSION_PERIOD_VALUE = frmAdminObj.INFUSION_PERIOD_VALUE.value;
	INFUSION_PERIOD_VALUE = Math.floor(INFUSION_PERIOD_VALUE);
	var INFUSION_PERIOD_VALUE_MIN = frmAdminObj.INFUSION_PERIOD_VALUE_MIN.value;
	INFUSION_PERIOD_VALUE_MIN = Math.round(INFUSION_PERIOD_VALUE_MIN);
	var temp_volume;
    
	if(infusion_value == "" || parseFloat(infusion_value) == 0){
		alert(getMessage("INF_RATE_CANT_BLANK_ZERO", "PH"));
		frmAdminObj.INFUSION_VALUE.focus();
	}
	else if(((INFUSION_PERIOD_VALUE == "" || parseFloat(INFUSION_PERIOD_VALUE) == 0) && (INFUSION_PERIOD_VALUE_MIN == "" || parseFloat(INFUSION_PERIOD_VALUE_MIN) == 0))){
		alert(getMessage("INFS_OVR_CANT_BLANK_ZERO", "PH"));
		frmAdminObj.INFUSION_PERIOD_VALUE.focus();
		
	}
	else {
		var unit = frmAdminObj.lstInfusionRateDurnUnit.value;
		if (unit == "H") {
			var infusion_over_min = INFUSION_PERIOD_VALUE_MIN / 60;

			temp_volume = infusion_value * (INFUSION_PERIOD_VALUE + infusion_over_min);
			var volume = (Math.ceil(temp_volume / volume_reference)) * volume_reference;
			frmObj.stock_value.value = volume;
			frmAdminObj.order_qty.value = Math.ceil(temp_volume / volume_reference);
		} else {
			infusion_over = (INFUSION_PERIOD_VALUE * 60) + INFUSION_PERIOD_VALUE_MIN;
			temp_volume = Math.ceil((infusion_value * infusion_over) / volume_reference);
			frmAdminObj.order_qty.value = temp_volume;
			frmObj.stock_value.value = temp_volume * volume_reference;
		}
		showAdminRate();
		calcQantityobVolume();
		//frmAdminObj.stock_value.value=temp_volume * volume_reference;
	} 
	var str =   '['+Math.floor(INFUSION_PERIOD_VALUE) + ' Hrs ' + Math.round(INFUSION_PERIOD_VALUE_MIN) + ' Mins]' ;
	frmAdminObj.infusionOverStr.innerHTML	= str;
	
}
function calcQantityobVolume(){
	if (parent.f_iv_admin == undefined){
		admnFrmObj	= parent.parent.f_iv_admin.document.formIVPrescriptionAdminDetail;
		fluidFrmObj	= parent.parent.f_iv_fluid.document.formIVPrescriptionDetails;
	}
	else{
		admnFrmObj	= parent.f_iv_admin.document.formIVPrescriptionAdminDetail;
		fluidFrmObj = parent.f_iv_fluid.document.formIVPrescriptionDetails;
	}
	var orderQty = admnFrmObj.order_qty.value;
	if(orderQty=="" ||  parseInt(orderQty)==0){
		alert(getMessage("PH_ORDER_QTY_BLANK","PH"));
		return false;
	}
	orderQty = parseInt(orderQty);
	var volumePerUnit = parseInt(fluidFrmObj.volumePerUnit.value);
	var totalVolume = volumePerUnit*orderQty;
	var volumeObj = fluidFrmObj.stock_value;
	var durnMins = admnFrmObj.INFUSION_PERIOD_VALUE_MIN.value;
	var durnHrs =admnFrmObj.INFUSION_PERIOD_VALUE.value;
	var INF_RATEObj = admnFrmObj.INFUSION_VALUE;
	var inf_value=INF_RATEObj.value;
	 setStockValue(volumeObj);
	
	var END_DATEObj = admnFrmObj.END_DATE;
	
	var bean_id    = admnFrmObj.BEAN_ID.value;
	var bean_name  = admnFrmObj.BEAN_NAME.value;
	var start_date = admnFrmObj.START_DATE.value;
	
	if(trimString(durnHrs)=="")
		durnHrs = '0';
	if(trimString(durnMins)=="")
		durnMins = '0';
	var durn_unit = "M";
	var DURN_VALUE =  (parseInt(durnHrs)*60)+parseInt(durnMins)
	var qryString	= bean_id+"&bean_name="+bean_name+"&validate=POPULATEENDDATEADMIN&start_date="+start_date+"&durn_value="+DURN_VALUE+"&durn_unit="+durn_unit+"&mode=IV_CALC";
	submitXML(qryString, "");
	admnFrmObj.INFUSION_PERIOD_VALUE_MIN.value=durnMins;
	admnFrmObj.INFUSION_PERIOD_VALUE.value=durnHrs;
	
	admnFrmObj.INFUSION_VALUE.value=inf_value;
	
	var str =   '['+Math.floor(durnHrs) + ' Hrs ' + Math.round(durnMins) + ' Mins]' ;
	admnFrmObj.infusionOverStr.innerHTML	= str;
	
}
//Added for AAKH-CRF-0094 END
//Added for IN:069887  start
function showOverideMandAlert(allergy_remarks_yn, dup_remarks_yn, dose_remarks_yn,abuse_rmk_yn){//abuse_rmk_yn ADDED FOR FOR AAKH-CRF-0140
	
	
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
	if(abuse_rmk_yn==='Y') {
		names[i]	="Drug Abuse Override Reason"; 
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
//added for aakh-crf-0140
async function showAbuseDetails(generic_id, patient_id, encounter_id, generic_name, drug_code,calledFro){
	var dialogTop		= "200";
 	var dialogHeight	= "20";
 	var dialogWidth		= "40";
	var dialogLeft		= "240";
 	var features		= 'Width:' + dialogWidth +'; dialogHeight:' + dialogHeight + '; dialogWidth:' + dialogWidth +'; dialogLeft:' + dialogLeft +';  dialogTop:'+dialogTop +'; scroll=auto; status=no';
 	var arguments		= "";
 	var retVal 			=await  window.showModalDialog("../jsp/PrescriptionAbuseDetailsFrames.jsp?generic_name="+generic_name+"&encounter_id="+encounter_id+"&generic_id="+generic_id+"&patient_id="+patient_id+"&CalledFro="+calledFro+"&drug_code="+drug_code,arguments,features);
} 

async function showAbuseDetailsrestric(generic_id, patient_id, encounter_id, generic_name, drug_code,calledFro){
	
	var dialogTop		= "";
 	var dialogHeight	= "40vh";
 	var dialogWidth		= "50vw";
	var dialogLeft		= "240";
 	var features		= 'Width:' + dialogWidth +'; dialogHeight:' + dialogHeight + '; dialogWidth:' + dialogWidth +'; dialogLeft:' + dialogLeft +';  dialogTop:'+dialogTop +'; scroll=auto; status=no';
 	var arguments		= "";
 	var retVal 			= await window.showModalDialog("../jsp/PrescriptionAbuseDetailsFrames.jsp?generic_name="+generic_name+"&encounter_id="+encounter_id+"&generic_id="+generic_id+"&patient_id="+patient_id+"&CalledFro="+calledFro+"&drug_code="+drug_code,arguments,features);
return false;
}
//Added for IN:069887  end
