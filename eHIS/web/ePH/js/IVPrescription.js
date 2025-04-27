/*
--------------------------------------------------------------------------------------------------------------
Date			Edit History		Name		Rev.Date		Rev.Name				Description
--------------------------------------------------------------------------------------------------------------
24/10/2019		INO71514			Shazana												SKR-SCF-1276
07/06/2020      IN072753            Prabha											   NMC-JD-CRF-0046
4/12/2020		6041				Shazana						Manickam				NMC-JD-CRF-0063		
06/01/2021		TFS-7345          Prabha      06/01/2020	  Manickavasagam J         MMS-DM-CRF-0177
2/3/2021		15129				Shazana						Manickam				NMC-JD-CRF-0063 		
 
--------------------------------------------------------------------------------------------------------------
*/





//code added on 5/5/2004
var blError = false;
/*
function setIVType(){
	//alert(formIVPrescriptionOptions.type.value);
	ivtype = formIVPrescriptionOptions.type.value;
	var bean_id				= formIVPrescriptionOptions.bean_id.value;
	var bean_name			= formIVPrescriptionOptions.bean_name.value;
	var qryString			= bean_id+"&bean_name="+bean_name+"&validate=IVTYPEDETAILS&ivtype="+ivtype;
		
	submitXML(qryString, "");
}
*/
function loadIVPresDetails(frmObj,Objval,patient_id,encounter_id){
//	var patient_class	= frmObj.patient_class.value;
	var patient_class	= parent.parent.f_header.document.prescription_header_form.patient_class.value;
	var act_patient_class	= parent.parent.f_header.document.prescription_header_form.act_patient_class.value;
//	var preview_rx_yn	= parent.parent.f_header.document.prescription_header_form.preview_rx_yn.value;//added for ML-MMOH-CRF-0341 [IN:057179]
	var start_date	= frmObj.start_date.value;
	var iv_option  =  frmObj.iv_option.value;
	var ivtype= Objval;
	var bean_id				= frmObj.bean_id.value;
	var bean_name			= frmObj.bean_name.value;
	var qryString			= bean_id+"&bean_name="+bean_name+"&validate=IVTYPEDETAILS&ivtype="+ivtype;
	submitXML(qryString, "");

	if (Objval=="IVD"){
		parent.f_ivdetails.location.href		= "../jsp/IVPrescriptionDetailsFrame.jsp?patient_id="+patient_id+"&encounter_id="+encounter_id+"&act_patient_class="+patient_class+"&start_date="+start_date+"&iv_option="+iv_option;
	}
	else if (Objval=="IVWA"){
		parent.parent.f_detail.scrolling="yes";
		parent.f_ivdetails.scrolling="yes";
//		parent.f_ivdetails.location.href		= "../jsp/IVFluidAdditives.jsp?patient_id="+patient_id+"&encounter_id="+encounter_id+"&act_patient_class="+act_patient_class+"&patient_class="+patient_class+"&start_date="+start_date+"&iv_option="+iv_option;
		parent.f_ivdetails.location.href		= "../jsp/IVFluidAdditives.jsp?patient_id="+patient_id+"&encounter_id="+encounter_id+"&act_patient_class="+patient_class+"&start_date="+start_date+"&iv_option="+iv_option;
	}

}

async function searchIVFluid1(frmObj,searchBasedOn, obj,rec_no) {	
	var header_form		= parent.parent.f_header.document.prescription_header_form;
	var discharge_yn	= header_form.take_home_medication.value;
	var priority		= header_form.priority.value;
	var source_code		= header_form.source_code.value;
	var source_type		= header_form.source_type.value;
	var encounter_id	= header_form.encounter_id.value;
	var patient_id		= header_form.patient_id.value;
	var act_patient_class	= header_form.actual_patient_class.value;
	var patient_class	= header_form.patient_class.value;
	var date_of_birth			= header_form.date_of_birth.value;
	var gender					= header_form.gender.value;

	var iv_prep_yn="5";
	
	var mode = formIVPrescriptionAdditives.mode1.value; //Added for MMS-DM-CRF-0177
	
	var retArray		= await DrugSearchForIV(searchBasedOn, obj, '', '', 'DrugSearchBean', '', '', act_patient_class, priority, 'IVF',"N",discharge_yn, source_type, source_code, patient_id, encounter_id, date_of_birth, gender,iv_prep_yn);
//	alert("retArray value :"+retArray.value);
	/*	if(header_form.take_home_medication_op_chk!=undefined)
			header_form.take_home_medication_op_chk.disabled=true;//added for NMC-JD-CRF-0063*/
	//added for NMC-JD-CRF-0063 START
	if(header_form.take_home_medication_op_chk!=undefined){
		if(retArray.length==0 || retArray==""){
			if(header_form.take_home_medication_op_chk.disabled==false){
				header_form.take_home_medication_op_chk.disabled=false;
			}
		}
		else{
				header_form.take_home_medication_op_chk.disabled=true;
		}
	}//END
	if (retArray != null && retArray != "" ) {
		var frmObj1				= document.formIVPrescriptionAdditives;	
		var item_type_site_app  = frmObj1.item_type_site_app.value;//added for ghl-crf-0549
		
		var fluid_vals	=	retArray[0].split(":::");		
		var fluid_code	=	fluid_vals[0];		
		if(checkSameFluidMFR(fluid_code, rec_no)){
			alert(getMessage("PH_DUPLICATE_WITH_MFR","PH"));		
			return false;
		}
		var fluid_name	=	retArray[1];
 		//frmObj.fluid_code.value	= retArray[0];
 		var drug_code				= fluid_vals[0];		
		// document.getElementById("flude_img1").style.visibility = 'visible';
		
		if(eval(document.getElementById("flude_img"+rec_no))) //if added for script error handling while select fluid from copy previous
		eval(document.getElementById("flude_img"+rec_no)).style.visibility = 'visible';
		obj.value = fluid_name;	
		frmObj.new_generic_name.value=fluid_name; //Added for MMS-DM-CRF-0177
		
		eval("frmObj1.FLUID_CODE"+rec_no).value=fluid_code;		
 		frmObj1.form_code.value	= retArray[2];
 		frmObj1.route_code.value	= retArray[3];
 		frmObj1.base_uom.value	= retArray[4];
		var base_uom			= retArray[4];
		var bean_id				= frmObj1.bean_id.value;
		var bean_name			= frmObj1.bean_name.value;

		var location_type			= header_form.location_type.value;
		var location_code			= header_form.location_code.value;
		var take_home_medication	= header_form.take_home_medication.value;
		var priority				= header_form.priority.value;
		
		var xmlStr 			="<root><SEARCH act_patient_class=\"" + act_patient_class + "\" /></root>";   // RUT-CRF-0062 
		//modified for ghl-crf-0549
		var qryString			= bean_id+"&bean_name="+bean_name+"&validate=VOLUMEDETAILS&drug_code="+drug_code+"&base_uom="+base_uom+"&rec_no="+rec_no+"&location_type="+location_type+"&location_code="+location_code+"&take_home_medication="+take_home_medication+"&priority="+priority+"&iv_prep_yn="+iv_prep_yn+"&item_type_site_app="+item_type_site_app+"&mode="+mode; //mode Added for MMS-DM-CRF-0177
		submitXML(qryString,xmlStr);// RUT-CRF-0062  Added actual patient class to get the Build MAR Rule
		obj.value = frmObj.new_generic_name.value;  //Added for MMS-DM-CRF-0177
	}	
}

function submitXML(qryString, xmlStr) {
	//commented by Anbarasi
//	var xmlDoc	= new ActiveXObject("Microsoft.XMLDom");
//	var xmlHttp	= new ActiveXObject("Microsoft.XMLHTTP");
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
	eval(document.getElementById("dose_uom_"+recno)).innerHTML= uom;
	eval("frmObj.qty_"+recno).value		= ((parseInt(dose))/1000)*(parseInt((frmObj.stock_value.value)));		
		
}
function setStockDetails(mode, stock_value, stock_uom_code, stock_uom_desc) {
	var frmObj = document.formIVPrescriptionDetails;
	infusion_uom_display = stock_uom_code;
	if (mode == 1) {
		document.getElementById("stock_display").innerHTML	= "<b>"+stock_value + " " +stock_uom_code+"</b>";
		parent.f_iv_admin.formIVPrescriptionAdminDetail.infusion_uom_display.innerHTML = "<b>&nbsp;" + stock_uom_code + "/Hr </b> ";
		frmObj.stock_value.value				= stock_value;
		frmObj.stock_uom_code.value				= stock_uom_code;		
	}
	else if (mode == 2) {
		alert(getMessage("PH_EQU_UOM_NOT_DEFINED","PH"));		
	}
}

function enableElements(rec_no) {
	var iv_calc_infuse_by = document.formIVPrescriptionAdditives.iv_calc_infuse_by.value //Added for SKR-CRF-0035 [IN:037727] 
	var param_volume_cal = document.formIVPrescriptionAdditives.param_volume_cal.value;//Added for AAKH-CRF-0094
document.getElementById("inf_rate_leg"+rec_no).style.visibility ='visible';
	document.getElementById("INF_RATE"+rec_no).style.visibility	='visible';
	document.getElementById("INFUSION_PERIOD_VALUE"+rec_no).style.visibility	='visible';
	document.getElementById("INFUSION_PERIOD_VALUE_MIN"+rec_no).style.visibility	='visible';
	document.getElementById("infusionOverStr"+rec_no).style.visibility	='visible';
	document.getElementById("infuse_over_leg"+rec_no).style.visibility	='visible';
	if(eval(document.getElementById("TDstrenght"+rec_no)) != undefined )
	eval(document.getElementById("TDstrenght"+rec_no)).style.display	='inline';	//ADDED FOR NMC-JD-CRF-0026
	if(iv_calc_infuse_by!='I'){ //Added for SKR-CRF-0035 [IN:037727]
		/*eval("document.getElementById("duration")"+rec_no+".style.visibility	='visible'");
		eval("document.getElementById("DURATION")"+rec_no+".style.visibility	='visible'");	
		eval("document.getElementById("durn_unit")"+rec_no+".style.visibility	='visible'");*/
		eval(document.getElementById("tdDuration"+rec_no)).style.visibility	='visible';	//changed for SKR-CRF-0035 [IN:037727] 
		document.getElementById("tdOrderQty_leg"+rec_no).style.display	='none';	//Added for SKR-CRF-0035 [IN:037727] -Start
		eval(document.getElementById("tdOrd_qty"+rec_no)).style.display	='none';	
		eval(document.getElementById("tdVolumePerUnit"+rec_no)).style.display	='none';	
		eval(document.getElementById("Totalvolume_leg"+rec_no)).style.display	='none';
	}
	else{
		eval(document.getElementById("tdDuration"+rec_no)).style.visibility	='hidden';	//changed for SKR-CRF-0035 [IN:037727] 
		eval(document.getElementById("tdOrderQty_leg"+rec_no)).style.display	='inline';	
		eval(document.getElementById("tdOrd_qty"+rec_no)).style.display	='inline';	
		eval(document.getElementById("tdVolumePerUnit"+rec_no)).style.display	='inline';	
		eval(document.getElementById("Totalvolume_leg"+rec_no)).style.display	='inline';
	} //Added for SKR-CRF-0035 [IN:037727] -end
	eval(document.getElementById("volume_leg"+rec_no)).style.visibility	='visible';	
	document.getElementById("volume"+rec_no).style.visibility	='visible';
	
	
//Added for AAKH-CRF-0094 START
	if(param_volume_cal == 'N'){
		eval(document.getElementById("volume"+rec_no)).disabled=true;
		}
	//ADDED FOR AAKH-CRF-0094 END
	document.getElementById("vol_uom"+rec_no).style.visibility	='visible';
	document.getElementById("hr"+rec_no).style.visibility	='visible';
	document.getElementById("colon"+rec_no).style.visibility	='visible';
	document.getElementById("start_time_leg"+rec_no).style.visibility	='visible';
	document.getElementById("START_DATE"+rec_no).style.visibility	='visible';
	document.getElementById("end_time_leg"+rec_no).style.visibility	='visible';
	document.getElementById("END_DATE"+rec_no).style.visibility	='visible';
	document.getElementById("active"+rec_no).style.visibility	='visible';
	document.getElementById("Calendar"+rec_no).style.visibility	='visible';
	document.getElementById("mfrLink"+rec_no).style.visibility	='visible';
	document.getElementById("MFR_Indicator"+rec_no).style.visibility	='visible';
	document.getElementById("mfrRemarksLink"+rec_no).style.visibility	='visible';
	document.getElementById("mfrRemarksLink"+rec_no).style.display	='inline';
	document.getElementById("disp_locn"+rec_no).style.visibility	='visible';// added  for Bru-HIMS-CRF-347 [IN:037862]

//	eval("document.getElementById("inf_unit")"+rec_no+".style.visibility	='visible'");
	var new_rec	=	parseInt(rec_no)+1;
	if(eval("document.formIVPrescriptionAdditives.FLUID_NAME"+new_rec)!=null ) {
		eval("document.formIVPrescriptionAdditives.FLUID_NAME"+new_rec+".style.visibility	='visible'");
		document.getElementById("fluid_leg"+new_rec).style.visibility	='visible';	
		eval("document.formIVPrescriptionAdditives.fluid_search"+new_rec+".style.visibility	='visible'");	
	}
}

function setInfusion_uom(){
	var stock_uom_code = parent.f_iv_fluid.formIVPrescriptionDetails.stock_uom_code.value
	document.getElementById("infusion_uom_display").innerHTML = "<b>&nbsp;" + stock_uom_code + "/Hr </b> ";
}
//strength_disply ADDED FOR NMC-JD-CRF-0026
function setVolumeDetails(mode, stock_value, stock_uom_code, stock_uom_desc,recno,fluid_adr_count, fluid_stock_uom_desc,strength_disply) {
	
	var frmObj = document.formIVPrescriptionAdditives;
	if (mode == 1) {
		document.getElementById("InfusionRateUnit"+recno).style.visibility ="visible";
		//eval("document.getElementById("uom_display")"+recno).innerHTML	= "<b> " +stock_uom_code+" /</b>";
		document.getElementById("uom_display"+recno).innerHTML	= "<b> " +stock_uom_desc+" /</b>";
		var iv_calc_infuse_by = document.formIVPrescriptionAdditives.iv_calc_infuse_by.value //Added for SKR-CRF-0035 [IN:037727] 
		for(rec=1;rec<=6;rec++){
			if(recno == rec){
				eval("frmObj.active"+rec).checked           =   true;
				eval("frmObj.volume"+rec).value				= stock_value;
				eval("frmObj.volume_reference"+rec).value	= stock_value; //Added for AAKH-CRF-0094 
				document.getElementById("vol_uom"+rec).innerHTML	= stock_uom_desc;
				eval("frmObj.stock_value"+rec).value		= stock_value;
				eval("frmObj.base_volume"+rec).value		= stock_value;
				eval("frmObj.stock_uom_code"+rec).value		= stock_uom_code;
				eval("frmObj.INF_RATE_UOM"+rec).value		= stock_uom_code;
				if(iv_calc_infuse_by=='I'){ //Added for SKR-CRF-0035 [IN:037727] -Start
					eval("frmObj.order_qty"+rec).value		= "1";
					eval("frmObj.ord_qty_uom"+rec).innerText	= decodeURIComponent(fluid_stock_uom_desc);
					eval("frmObj.volumePerUnit"+rec).value		= stock_value;
					eval("frmObj.volPerUnitUom_leg"+rec).innerHTML	= stock_uom_desc;
				} //Added for SKR-CRF-0035 [IN:037727] -end
				if(rec>1){
					if (eval("frmObj.FLUID_CODE"+parseInt(rec-1)).value==eval("frmObj.FLUID_CODE"+rec).value) { // parseInt added for [IN:045055]
						document.getElementById("Calendar"+rec).disabled	=	true;
						CalculateDateTime(eval("frmObj.END_DATE"+parseInt(rec-1)),eval("frmObj.START_DATE"+rec)); //(rec-1) added for Internal ADHOC Testing
						eval("frmObj.START_DATE"+rec).disabled	=	true;
					}
					else{
						CalculateDateTime(eval("frmObj.END_DATE"+parseInt(rec-1)),eval("frmObj.START_DATE"+rec)); // parseInt added for [IN:045055]
					}
				}
				if(parseInt(fluid_adr_count)>0){
					 document.getElementById("ADR_img_"+rec).style.visibility ="visible" ;
				}
				else{
					 document.getElementById("ADR_img_"+rec).style.visibility ="hidden" ;
				}
				if(eval("frmObj.strength_label"+rec) != undefined )
				eval("frmObj.strength_label"+rec).innerHTML	= strength_disply;//ADDED FOR NMC-JD-CRF-0026
			}
			/*if (recno == 1)	{
				frmObj.active1.checked              =   true;
				frmObj.volume1.value				=	stock_value;
				//document.getElementById("vol_uom1").innerHTML		=	stock_uom_code;
				document.getElementById("vol_uom1").innerHTML		=	stock_uom_desc;
				frmObj.stock_value1.value			= stock_value;
				frmObj.base_volume1.value			= stock_value;
				frmObj.stock_uom_code1.value		= stock_uom_code;
				frmObj.INF_RATE_UOM1.value			= stock_uom_code;
				if(parseInt(fluid_adr_count)>0){
					 document.getElementById("ADR_img_1").style.visibility ="visible" ;   
				}else{
					 document.getElementById("ADR_img_1").style.visibility ="hidden" ;
				}

			} else if (recno == 2){
				frmObj.active2.checked              =   true;
				frmObj.volume2.value				=	stock_value;
				//document.getElementById("vol_uom2").innerHTML		=	stock_uom_code;
				document.getElementById("vol_uom2").innerHTML		=	stock_uom_desc;

				frmObj.stock_value2.value			= stock_value;
				frmObj.base_volume2.value			= stock_value;
				frmObj.stock_uom_code2.value		= stock_uom_code;
				frmObj.INF_RATE_UOM2.value			= stock_uom_code;

				if (frmObj.FLUID_CODE1.value ==frmObj.FLUID_CODE2.value) {
					document.getElementById("Calendar2").disabled	=	true;
					CalculateDateTime(frmObj.END_DATE1,frmObj.START_DATE2);
					frmObj.START_DATE2.disabled	=	true;
				}else{	
					CalculateDateTime(frmObj.END_DATE1,frmObj.START_DATE2);
				}


				if(parseInt(fluid_adr_count)>0){
					 document.getElementById("ADR_img_2").style.visibility ="visible" ;   
				}else{
					 document.getElementById("ADR_img_2").style.visibility ="hidden" ;
				}


			}else if (recno == 3){
				frmObj.active3.checked              =   true;
				frmObj.volume3.value				=	stock_value;
	//			document.getElementById("vol_uom3").innerHTML		=	stock_uom_code;
				document.getElementById("vol_uom3").innerHTML		=	stock_uom_desc;

				frmObj.stock_value3.value			= stock_value;
				frmObj.base_volume3.value			= stock_value;
				frmObj.stock_uom_code3.value		= stock_uom_code;
				frmObj.INF_RATE_UOM3.value			= stock_uom_code;
				if (frmObj.FLUID_CODE2.value ==frmObj.FLUID_CODE3.value) {
					document.getElementById("Calendar2").disabled	=	true;
					CalculateDateTime(frmObj.END_DATE2,frmObj.START_DATE3);
					frmObj.START_DATE3.disabled= true;
				}else {
					CalculateDateTime(frmObj.END_DATE2,frmObj.START_DATE3);
				}
				if(parseInt(fluid_adr_count)>0){
					 document.getElementById("ADR_img_3").style.visibility ="visible" ;   
				}else{
					 document.getElementById("ADR_img_3").style.visibility ="hidden" ;
				}
			}else if (recno == 4){	
				frmObj.active4.checked              =   true;
				frmObj.volume4.value				=	stock_value;
	//			document.getElementById("vol_uom4").innerHTML		=	stock_uom_code;
				document.getElementById("vol_uom4").innerHTML		=	stock_uom_desc;

				frmObj.stock_value4.value			= stock_value;
				frmObj.base_volume4.value			= stock_value;
				frmObj.stock_uom_code4.value		= stock_uom_code;
				frmObj.INF_RATE_UOM4.value			= stock_uom_code;
				if (frmObj.FLUID_CODE3.value ==frmObj.FLUID_CODE4.value) {
						document.getElementById("Calendar4").disabled	=	true;
					CalculateDateTime(frmObj.END_DATE3,frmObj.START_DATE4)	;	
					frmObj.START_DATE4.disabled = true;
				}else{
					CalculateDateTime(frmObj.END_DATE3,frmObj.START_DATE4);
				}
				if(parseInt(fluid_adr_count)>0){
					 document.getElementById("ADR_img_4").style.visibility ="visible" ;   
				}else{
					 document.getElementById("ADR_img_4").style.visibility ="hidden" ;
				}
			}else if (recno == 5){
				frmObj.active5.checked              =   true;
				frmObj.volume5.value				=	stock_value;
	//			document.getElementById("vol_uom5").innerHTML		=	stock_uom_code;
				document.getElementById("vol_uom5").innerHTML		=	stock_uom_desc;

				frmObj.stock_value5.value			= stock_value;
				frmObj.base_volume5.value			= stock_value;
				frmObj.stock_uom_code5.value		= stock_uom_code;
				frmObj.INF_RATE_UOM5.value			= stock_uom_code;
				if (frmObj.FLUID_CODE4.value ==frmObj.FLUID_CODE5.value) {
					document.getElementById("Calendar5").disabled	=	true;
					CalculateDateTime(frmObj.END_DATE4,frmObj.START_DATE5);
					frmObj.START_DATE5.disabled=true;
				}else{
					CalculateDateTime(frmObj.END_DATE4,frmObj.START_DATE5);
				}
				
				if(parseInt(fluid_adr_count)>0){
					 document.getElementById("ADR_img_5").style.visibility ="visible" ;   
				}else{
					 document.getElementById("ADR_img_5").style.visibility ="hidden" ;
				}
			}else if (recno == 6){
				frmObj.active6.checked              =   true;
				frmObj.volume6.value				=	stock_value;
	//			document.getElementById("vol_uom6").innerHTML		=	stock_uom_code;
				document.getElementById("vol_uom6").innerHTML		=	stock_uom_desc;

				frmObj.stock_value6.value			= stock_value;
				frmObj.base_volume6.value			= stock_value;
				frmObj.stock_uom_code6.value		= stock_uom_code;
				frmObj.INF_RATE_UOM6.value			= stock_uom_code;
				if (frmObj.FLUID_CODE5.value ==frmObj.FLUID_CODE6.value) {
					document.getElementById("Calendar6").disabled	=	true;
					CalculateDateTime(frmObj.END_DATE5,frmObj.START_DATE6);
					frmObj.START_DATE6.disabled = true;
				}else{	
					CalculateDateTime(frmObj.END_DATE5,frmObj.START_DATE6);
				}
				if(parseInt(fluid_adr_count)>0){
					 document.getElementById("ADR_img_6").style.visibility ="visible" ;   
				}else{
					 document.getElementById("ADR_img_6").style.visibility ="hidden" ;
				}
			}*/	
			enableElements(recno);
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
		else	errors = errors + "APP-000001 " + names[i] +" "+getMessage("CANT_BE_BLANK","PH")+" "+ "\n" ;
	}
	if ( errors.length != 0 ) {
		alert(errors) ;
		return false ;
	}
	return true ;
}



function checkHr(obj,duration,i) {	

unit = eval("document.formIVPrescriptionAdditives.InfusionRateUnit"+i).value;
	if(unit == "H")
		val = obj.value;
	else
		val = (obj.value)/60;
	minVal =  eval("document.formIVPrescriptionAdditives.INFUSION_PERIOD_VALUE_MIN"+i).value;
	if(minVal == "")
		 eval("document.formIVPrescriptionAdditives.INFUSION_PERIOD_VALUE_MIN"+i).value = 0;
	if(minVal > 59){
		alert(getMessage("INVALID_TIME_MINUTE","PH"));
		//eval("document.formIVPrescriptionAdditives.INFUSION_PERIOD_VALUE_MIN"+i).focus();
		return false;
	}
}

function chkDuration(obj, mode) {

	var frmObj		= document.formIVPrescriptionAdminDetail;
	//parent.parent.f_ivbutton.formIVPrescriptionButtons.PREVIEW.focus();
	var fields  = new Array() ;
	var names   = new Array() ;
	fields[0]	= frmObj.START_DATE;
	names[0]	= "Start Date";
	frmObj.DURN_VALUE.value = frmObj.INFUSION_PERIOD_VALUE.value;
	if(checkFlds( fields, names)){

		if (mode == undefined)
			mode = "";

		if (mode == "1")
			frmObj		= document.formIVPrescriptionAdminDetail;
		else if(mode == "2")
			frmObj		= document.formIVPrescriptionAdminDetail;

		if (obj.value != "") {
			var cont_flag	= true;
			var objVal		= obj.value;
		}
		if (cont_flag) {
			var bean_id		= frmObj.BEAN_ID.value;
			var bean_name	= frmObj.BEAN_NAME.value;
			var start_date	= frmObj.START_DATE.value;
			var durn_unit	= "H";
			
			var qryString	= bean_id+"&bean_name="+bean_name+"&validate=POPULATEENDDATE&start_date="+start_date+"&durn_value="+objVal+"&durn_unit="+durn_unit+"&mode="+mode;
			submitXML(qryString, "");
		}
		else{
			frmObj.END_DATE.value	= "";
		}
	}
	else{
		return false;
	}
}

function overlap(obj,rec_no,mode){
	rec = (rec_no)-1;
	var frmObj		= document.formIVPrescriptionAdditives;
	var end_date = eval("frmObj.END_DATE"+rec).value;
	var start_date1	= eval("frmObj.START_DATE"+rec_no).value;
	var fluid_code_prev = eval("frmObj.FLUID_CODE"+rec).value;
	var fluid_code	= eval("frmObj.FLUID_CODE"+rec_no).value;
	if (fluid_code != fluid_code_prev){
		chkDurationAD(obj,rec_no, mode)
	}
	else{		
		if(ValidateDateTime (end_date,start_date1)){
			chkDurationAD(obj,rec_no, mode)
		}
		else{
			alert(getMessage("TME_SHLDNT_OVRLP","PH"));
			eval("frmObj.START_DATE"+rec_no).value="";
			eval("frmObj.START_DATE"+rec_no).focus
		}
	}
}

function chkDurationAD(obj,rec_no) {
   	var frmObj		= document.formIVPrescriptionAdditives;
	var start_date_chk	= eval("frmObj.START_DATE"+rec_no).value;	
    var locale = document.formIVPrescriptionAdditives.language_id.value;
	if(start_date_chk!=""){
		var back_date = document.formIVPrescriptionAdditives.back_date.value;
	    var future_date= document.formIVPrescriptionAdditives.future_date.value;
		var end_date	= eval("frmObj.END_DATE"+rec_no).value;
		if(validDate(start_date_chk, "DMYHM",locale )){
			if(future_date!=null && future_date!='null' && future_date!="0" && future_date!="" ){ //future_date!="" is added for 33048
				if(!isBefore(start_date_chk,future_date, "DMYHM",locale)){
					alert(getMessage("PH_BACK_DATE", "PH"));
					eval("document.formIVPrescriptionAdditives.START_DATE"+rec_no).value=document.formIVPrescriptionAdditives.future_date.value;
              		return false;
				}
			}
			if(back_date!=null &&  back_date!='null' && back_date!="0" && back_date!=""){ //back_date!="" is added for 33048
				if(!isAfter(start_date_chk,back_date, "DMYHM",locale)){
					alert(getMessage("PH_BACK_DATE", "PH"));
					eval("document.formIVPrescriptionAdditives.START_DATE"+rec_no).value=document.formIVPrescriptionAdditives.back_date.value;
					return false;
				}
			}
		}
		else{
			alert(getMessage("INVALID_DATE_TIME", "PH"));
			//document.formIVPrescriptionAdminDetail.START_DATE.focus();
			eval("document.formIVPrescriptionAdditives.START_DATE"+rec_no).value=document.formIVPrescriptionAdditives.back_date.value;
			return false;
		}
	} 
	else{
		//alert(getMessage("PH_START_DATE", "PH"));
		alert(getMessage("INVALID_DATE_TIME", "PH"));
		//document.formIVPrescriptionAdminDetail.Calendar.click();
		eval("document.formIVPrescriptionAdditives.Calendar"+rec_no).click();
		return false;
	}
	var fields  = new Array() ;
	var names   = new Array() ;
	fields[0]	= eval("frmObj.START_DATE"+rec_no);
	names[0]	= "Start Date";
	var cont_flag	= false;
	var durn_unit	= "H";
	if(checkFlds( fields, names)){
		if (obj.value!="0" && obj.value != "") {
			cont_flag	= true;
			durn_value		= obj.value;
		}
		if(obj.value == undefined){
			durn_value = 0;
		}
		if (cont_flag) {
			var iv_calc_infuse_by = document.formIVPrescriptionAdditives.iv_calc_infuse_by.value; //Added for SKR-CRF-0035 [IN:037727] -Start
			if(iv_calc_infuse_by == 'I'){
				var durnHrs = eval("frmObj.INFUSION_PERIOD_VALUE"+rec_no).value;
				var durnMins = eval("frmObj.INFUSION_PERIOD_VALUE_MIN"+rec_no).value;
				if(trimString(durnHrs)=="")
					durnHrs = '0';
				if(trimString(durnMins)=="")
					durnMins = '0';
				durn_unit = "M";
				durn_value =  (parseInt(durnHrs)*60)+parseInt(durnMins)
			} //Added for SKR-CRF-0035 [IN:037727] -End

			//INO71514 START
			else{
				
				var durnHrs = eval("frmObj.INFUSION_PERIOD_VALUE"+rec_no).value;
				var durnMins = eval("frmObj.INFUSION_PERIOD_VALUE_MIN"+rec_no).value;
				if(trimString(durnHrs)=="")
					durnHrs = '0';
				if(trimString(durnMins)=="")
					durnMins = '0';
				durn_unit = "M";
				durn_value =  (parseInt(durn_value)*60);
			}
			//INO71514 END
			
			var start_date	= eval("frmObj.START_DATE"+rec_no).value;
			var bean_id		= frmObj.bean_id.value;
			var bean_name	= frmObj.bean_name.value;
			var qryString	= bean_id+"&bean_name="+bean_name+"&validate=POPULATEENDDATEAD&start_date="+start_date+"&durn_value="+durn_value+"&durn_unit="+durn_unit+"&rec_no="+rec_no;
			submitXML(qryString, "");			
		} 
	}
	else{
		return false;
	}
	//}
 }

function setEndDate(end_date, obj) {
	obj = eval(obj);
	obj.value = end_date;
}

function setInfuseOver(inf_over,rec_no, obj) {
	var val		  =	inf_over.split("::");
	var infuse    = val[0];
	var duration  = "";

	if(val[1]=="M") {
		infuse	=	Math.round(Math.ceil(parseInt(val[0])/60));
	}

	obj = eval(obj);
	var HrsMinStr = getHrsMinStr(infuse,val[1]);
	eval("document.formIVPrescriptionAdditives.infusion_over_insert_value"+rec_no).value = infuse;
	infStr = document.getElementById('infusionOverStr'+rec_no);
	infStr.innerHTML = HrsMinStr;

	
	hrs = HrsMinStr.substring(1,HrsMinStr.indexOf("H")-1);
	min = HrsMinStr.substring(HrsMinStr.indexOf("H")+4,HrsMinStr.indexOf("M")-1);

	eval("document.formIVPrescriptionAdditives.INFUSION_PERIOD_VALUE"+rec_no).value = Math.floor(hrs);
	eval("document.formIVPrescriptionAdditives.INFUSION_PERIOD_VALUE_MIN"+rec_no).value = Math.round(min);
	if(parseFloat(infuse)!=0 && infuse!="") {
		infusion_rate	=	document.getElementById("INF_RATE"+rec_no);
		volume		=	 document.getElementById("volume"+rec_no).value; 
		period		=	 document.getElementById("infusion_over_insert_value"+rec_no).value;
		//duration		=	 eval("document.getElementById("DURATION")"+rec_no);//Commented for [IN:045055]
		temp = parseFloat(volume)/parseFloat(period)
		infusion_rate.value	= 	Math.round(temp*100)/100;
	}
	duration		=	 document.getElementById("DURATION"+rec_no);//Moved from if condition to outside for [IN:045055]
	/*if(infuse!=null && infuse!="" && infuse!="0") {
		//duration.value	=	infuse;
	}*/
	chkDurationAD(duration,rec_no);
}


function resetInfuse(){	
	document.formIVPrescriptionAdminDetail.INFUSION_PERIOD_VALUE.value="";
	document.formIVPrescriptionAdminDetail.END_DATE.value="";
}

var function_id	= "IV_PRESCRIPTION";
var result		= false;
var message		= "";
var flag		= "";
var narcotic_yn	= "";
var print_ord_sht_rule_ind="";//Added for Bru-HIMS-CRF-393_1.0

function confirmAndProceed(obj, obj1) {
	//if (obj.value == "N") {
		//obj.checked = false;
		//if (confirm(getMessage("PH_RECOREDED_DATA_LOST"))) {
			//obj.value = "Y";
		//obj1.value = "N";
			//obj.checked = true;
			//obj1.checked = false;
			if (confirm(getMessage("PH_RECOREDED_DATA_LOST","PH"))) {
				callClearAll(2);
			}
		//}
		//else {
		//	obj.value = "N";
		//	obj1.value = "Y";
			//obj.checked = false;
			//obj1.checked = true;
		//}
	//}
}

function searchIVDrugs(searchBasedOn, obj) {
	var frmObj				= document.formIVPrescriptionDrugDetails;
	var discharge_yn		= parent.parent.parent.parent.f_header.document.prescription_header_form.take_home_medication.value;
	var priority		= parent.parent.parent.parent.f_header.document.prescription_header_form.priority.value;
	var	encounter_id		= parent.parent.parent.parent.f_header.document.prescription_header_form.encounter_id.value;
	var	patient_id		= parent.parent.parent.parent.f_header.document.prescription_header_form.patient_id.value;
	var	act_patient_class		= parent.parent.parent.parent.f_header.document.prescription_header_form.actual_patient_class.value;
	var drug_codes			= frmObj.drug_codes.value;
	var patient_class		= parent.parent.parent.parent.f_header.patient_class.value;
	var source_code			= parent.parent.parent.parent.f_header.document.prescription_header_form.source_code.value;
	var source_type			= parent.parent.parent.parent.f_header.document.prescription_header_form.source_type.value;
	var date_of_brith			= parent.parent.parent.parent.f_header.document.prescription_header_form.date_of_brith.value;
	var gender			= parent.parent.parent.parent.f_header.document.prescription_header_form.gender.value;
	var iv_prep_yn="5";

	var location_type			= parent.parent.parent.parent.f_header.prescription_header_form.location_type.value;
	var location_code			= parent.parent.parent.parent.f_header.prescription_header_form.location_code.value;
	var take_home_medication	= parent.parent.parent.parent.f_header.prescription_header_form.take_home_medication.value;
	var retArray = DrugSearchForIV(searchBasedOn, obj, '', drug_codes, 'DrugSearchBean', '', '', act_patient_class, priority, 'D',"N",discharge_yn ,source_type, source_code, patient_id, encounter_id,date_of_brith, gender,iv_prep_yn);

	if (retArray != null && retArray != "") {
		frmObj.drug_codes.value	= retArray;
		var bean_id				= frmObj.bean_id.value;
		var bean_name			= frmObj.bean_name.value;
		var xmlStr 				= "<root><SEARCH act_patient_class=\"" + act_patient_class + "\" /></root>";   // RUT-CRF-0062  Added actual patient class to get the Build MAR Rule
		var qryString			= bean_id+"&bean_name="+bean_name+"&validate=DRUGCODES&drugCodes="+retArray+"&location_type="+location_type+"&location_code="+location_code+"&take_home_medication="+take_home_medication+"&priority="+priority+"&iv_prep_yn="+iv_prep_yn;
		submitXML(qryString, xmlStr);  // RUT-CRF-0062 
	}
	obj.value = "";
}


function checkValidDrug(checkFor, objVal) {
	if (trimCheck(objVal) != "") {
		if (checkFor == "D")
			searchIVDrugs("D", document.formIVPrescriptionDrugDetails.DRUG_NAME);
		else if (checkFor == "F")
			searchIVFluid("D", document.formIVPrescriptionFluidDetail.FLUID_NAME);
	}
	else {
		if (checkFor == "F") {
			var frmObj = document.formIVPrescriptionFluidDetail;
			frmObj.fluid_code.value			= "";
			document.getElementById("FLUID_REMARKS").style.visibility = "hidden";
		}
	}
}

function changeScrDetails(objVal) {
	var frmObj		= document.formIVPrescriptionDrugDetails;

	if (objVal == "S") {
		document.getElementById("DOSAGE_LABEL").innerHTML = "Dose&nbsp;";
		var uom_code	= frmObj.UOM_CODE.value;
		var uom_desc	= frmObj.STRENGTH_UOM_DESC.value;
		var str_value	= frmObj.STR_VAL.value;

	//	frmObj.INFUSION_UOM.disabled	= false;

		clearData(frmObj.STRENGTH_UOM, "2");
		addData(uom_code, uom_desc, frmObj.STRENGTH_UOM);
	
		frmObj.STRENGTH_UOM.disabled	= true;
	//	frmObj.INFUSION_UOM.value		= "strength_uom";
		frmObj.STRENGTH_VALUE.value		= str_value;
	}
	else if (objVal == "Q") {
		document.getElementById("DOSAGE_LABEL").innerHTML = "Dose&nbsp;";
		var form_code						= frmObj.FORM_CODE.value;
		frmObj.STRENGTH_VALUE.value			= frmObj.PRES_QTY_VALUE.value;
		frmObj.STRENGTH_UOM.disabled		= false;
	//	frmObj.INFUSION_UOM.disabled		= true;
	//	frmObj.INFUSION_UOM.value			= "";
	//	frmObj.INFUSION_VALUE.disabled		= true;
	//	frmObj.INFUSION_VALUE.value			= "";
		var bean_id							= frmObj.bean_id.value;
		var bean_name						= frmObj.bean_name.value;
		var qryString						= bean_id+"&bean_name="+bean_name+"&validate=QUANTITY&form_code="+form_code;
		submitXML(qryString, "");
	}
	
}

function setCalculatedQty(obj) {
	/*if (checkWholeNumber(obj)) {
		var frmObj = document.formIVPrescriptionDrugDetails;
		if (frmObj.DOSAGE.value == "S") {
			var objVal				= obj.value;
			frmObj.BMS_QTY.value	= Math.ceil(objVal/frmObj.STR_VAL.value);
			setInfusionPeriod(frmObj.INFUSION_VALUE);
		}
	}*/
	if (CheckPositiveNumber(obj)) {
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
	if(obj.value=="H") {
		fluidForm.INFUSION_PERIOD_UOM.value	= "H";
		adminForm.INFUSION_UOM.value		= "H";
		parent.parent.f_ivfluid.document.getElementById("flow_unit").innerText="/Hours";
	} else {
		fluidForm.INFUSION_PERIOD_UOM.value	= "M";
		adminForm.INFUSION_UOM.value		= "M";
		parent.parent.f_ivfluid.document.getElementById("flow_unit").innerText="/Minutes";
	}

}


function setOrderType(orderTypeCode) {
	document.formIVPrescriptionDetails.ORDER_TYPE_CODE.value = orderTypeCode;
	//document.getElementById("FLUID_REMARKS").style.visibility = "visible";
}
function setOrderType1(orderTypeCode) {
	document.formIVPrescriptionAdditives.order_type_code.value = orderTypeCode;
	//document.getElementById("FLUID_REMARKS").style.visibility = "visible";
}

function setInfuseValue(infuse) {	
	getPresBase();
	var val		=	infuse.split("::");
	//document.formIVPrescriptionFluidDetail.STOCK_UOM.value		= val[2];
	document.formIVPrescriptionFluidDetail.STOCK_VALUE.value	=  val[3];
	var obj1	=	document.formIVPrescriptionFluidDetail.INFUSION_PERIOD_VALUE;
	var obj2	=	document.formIVPrescriptionFluidDetail.INFUSION_PERIOD_UOM;	
	frmObj	=	document.formIVPrescriptionFluidDetail;
	if(parent.f_ivadmin.document.formIVPrescriptionAdminDetail !=null){
		parent.f_ivadmin.document.formIVPrescriptionAdminDetail.FREQUENCY.disabled = false;
	}
	
	if(trimString(obj1.value)=='') {
		obj1.value	=  val[0];
	
		parent.f_ivadmin.formIVPrescriptionAdminDetail.INFUSION_VALUE.value=val[0];
		
		if(val[1]=='' || val[1]=='null')
			val[1]='M';
	    obj2.value	=   val[1];
		parent.f_ivadmin.formIVPrescriptionAdminDetail.INFUSION_UOM.value=val[1];

		if(parseFloat(frmObj.STOCK_VALUE.value) > 0 && parseFloat(frmObj.INFUSION_PERIOD_VALUE.value) > 0) {
			var str	=	parseFloat(frmObj.STOCK_VALUE.value/frmObj.INFUSION_PERIOD_VALUE.value)+"";
			var ind	=	str.lastIndexOf(".",str.length);
			if( str.length > ind+3)
				str	=	str.substring(0,ind+3);
			document.formIVPrescriptionFluidDetail.FLOW_VALUE.value	= str;	
				
		}
		document.getElementById("flow_unit").innerText						=	"/"+obj2.options(obj2.selectedIndex).text;
		parent.f_ivadmin.document.formIVPrescriptionAdminDetail.INFUSION_VALUE.value=obj1.value;
	}
	
	
}
/*
function setStockDetails(mode, stock_value, stock_uom_code, stock_uom_desc, eqvl_uom, eqvl_value, eqvl_uom_desc) {
	var frmObj = document.formIVPrescriptionFluidDetail;
	if (mode == 1) {
		frmObj.STOCK_VALUE.value	= stock_value;
		frmObj.STOCK_UOM_CODE.value	= stock_uom_code;
		frmObj.STOCK_UOM.value		= stock_uom_desc;
		frmObj.EQVL_UOM_CODE.value	= eqvl_uom;
		//frmObj.EQVL_UOM_DESC.value	= eqvl_uom_desc;
		//frmObj.EQVL_UOM_VALUE.value	= eqvl_value;

		if (trimCheck(frmObj.INFUSION_PERIOD_VALUE.value) != "") {
			frmObj.FLOW_VALUE.value	= Math.ceil(frmObj.EQVL_UOM_VALUE.value/frmObj.INFUSION_PERIOD_VALUE.value);
		}
	}
	else if (mode == 2) {
		alert(getMessage("PH_EQU_UOM_NOT_DEFINED"));
		frmObj.EQVL_UOM_CODE.value	= "";
		frmObj.EQVL_UOM_DESC.value	= "";
		frmObj.EQVL_UOM_VALUE.value	= "";
	}
}
*/

function deleteSchedule(called_frm) {
	var frmObj;
	var docu;
	var admin_frm;

	if(called_frm=="F") {
		frmObj		= document.formIVPrescriptionFluidDetail;
		docu		= parent.f_ivadmin.document;
		admin_frm	= parent.f_ivadmin.document.formIVPrescriptionAdminDetail;
	} else if(called_frm=="A") {
		frmObj		= parent.f_ivfluid.document.formIVPrescriptionFluidDetail;
		docu		= document;
		admin_frm	= document.formIVPrescriptionAdminDetail;
	}

	var bean_id		= frmObj.bean_id.value;
	var bean_name	= frmObj.bean_name.value;
	drug_code		= frmObj.FLUID_CODE.value;	

   //if(docu.SCHED_MEDN.checked==true) {		
	   	//docu.SCHED_MEDN.checked		= false;
		//docu.SCHED_MEDN.value		= "N";
		docu.SCHED_MEDN_YN.value	= "N";
		//docu.SCHED_LINK.innerText	= "Scheduled Medication";
		var qryString	= bean_id+"&bean_name="+bean_name+"&validate=DELETESCHEDULE&drug_code="+drug_code;
		submitXML(qryString, "");
   //}
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
		drug_code		= frmObj.FLUID_CODE.value;
		if(qty_value!="" && qty_value!=="0") {
			var qryString	= bean_id+"&bean_name="+bean_name+"&validate=AUTOSCHEDULE&freq_code="+freq_code+"&start_date="+start_date+"&qty_value="+qty_value+"&drug_code="+drug_code;
			submitXML(qryString, "");
		}
	}
}

function makeLink() {
	docu			= parent.f_ivadmin.document;
	//docu.SCHED_LINK.innerHTML = "<A HREF onMouseOver=\"changeCursor(this)\" onClick=\"displaySchedule(parent.f_ivadmin.document.formIVPrescriptionAdminDetail.SCHED_MEDN)\">Scheduled Medication</A>";
	//docu.SCHED_MEDN.checked	= true;
	//docu.SCHED_MEDN.value	= "Y";
	docu.SCHED_MEDN_YN.value = "Y";
	//docu.FREQUENCY.disabled	= true;
	//docu.SCHED_MEDN.disabled= true;		
}

/*function setStockDetails(mode, stock_value, stock_uom_code, stock_uom_desc) {
	var frmObj = document.formIVPrescriptionFluidDetail;

	if (mode == 1) {
		frmObj.STOCK_VALUE.value	= stock_value;
		frmObj.STOCK_UOM_CODE.value	= stock_uom_code;
		frmObj.STOCK_UOM.value		= stock_uom_desc;
		frmObj.EQVL_UOM_CODE.value	= stock_uom_code;
		frmObj.EQVL_UOM_DESC.value	= stock_uom_desc;
		//frmObj.EQVL_UOM_VALUE.value	= eqvl_value;

		if (trimCheck(frmObj.INFUSION_PERIOD_VALUE.value) != "" && frmObj.INFUSION_PERIOD_VALUE.value!='0') {
			//frmObj.FLOW_VALUE.value	= Math.ceil(frmObj.EQVL_UOM_VALUE.value/frmObj.INFUSION_PERIOD_VALUE.value);
			var str	=	parseFloat(frmObj.STOCK_VALUE.value/frmObj.INFUSION_PERIOD_VALUE.value)+"";
			var ind	=	str.lastIndexOf(".",str.length);
			if( str.length > ind+3)
				str	=	str.substring(0,ind+3);

				frmObj.FLOW_VALUE.value	= str;

				
			}

				// check schedule chkbox is enabled & freq is selected
				// automatic scheduling
				
				var bean_id		= frmObj.bean_id.value;
				var bean_name	= frmObj.bean_name.value;
				admin_frm		= parent.f_ivadmin.document.formIVPrescriptionAdminDetail;

				if( (!admin_frm.SCHED_MEDN.disabled) && admin_frm.FREQUENCY.value!="") {
						start_date		= admin_frm.START_DATE.value;
						qty_value		= frmObj.STOCK_VALUE.value;
						freq_code		= admin_frm.FREQUENCY.value;
						drug_code		= frmObj.FLUID_CODE.value;

						var qryString	= bean_id+"&bean_name="+bean_name+"&validate=AUTOSCHEDULE&freq_code="+freq_code+"&start_date="+start_date+"&qty_value="+qty_value+"&drug_code="+drug_code;
						submitXML(qryString, "");

					docu			= parent.f_ivadmin.document;
					//docu.SCHED_LINK.innerHTML = "<A HREF onMouseOver=\"changeCursor(this)\" onClick=\"displaySchedule(parent.f_ivadmin.document.formIVPrescriptionAdminDetail.SCHED_MEDN)\">Scheduled Medication</A>";
					//docu.SCHED_MEDN.checked	= true;
					//docu.SCHED_MEDN.value	= "Y";
					docu.SCHED_MEDN_YN.value = "Y";
					//docu.FREQUENCY.disabled	= true;
					//docu.SCHED_MEDN.disabled=true;				

				}


	}
	else if (mode == 2) {
		alert(getMessage("PH_EQU_UOM_NOT_DEFINED"));
		frmObj.EQVL_UOM_CODE.value	= "";
		frmObj.EQVL_UOM_DESC.value	= "";
		frmObj.EQVL_UOM_VALUE.value	= "";
	}
}

*/
/*function refreshLocation(patient_id, encounter_id, mode,pc) {
	

	if (mode == "1") {
		
		parent.f_drug_list.location.href		= "../jsp/IVPrescriptionDrugList.jsp?patient_id="+patient_id+"&encounter_id="+encounter_id;
		parent.parent.f_ivbutton.location.href	= "../jsp/IVPrescriptionButtons.jsp?patient_id="+patient_id+"&encounter_id="+encounter_id;
		//parent.parent.f_iv_admin.location.href	= "../jsp/IVPrescriptionAdminDetail.jsp?patient_id="+patient_id+"&encounter_id="+encounter_id;
		
	}
	else if(mode == "2") {		
		
		parent.parent.f_ivbutton.location.href	= "../jsp/IVPrescriptionButtons.jsp?patient_id="+patient_id+"&encounter_id="+encounter_id;
		
	}
	else if(mode == "3") {		
		
		parent.parent.f_ivbutton.location.href	= "../jsp/IVPrescriptionButtons.jsp?patient_id="+patient_id+"&encounter_id="+encounter_id;
	}else if(mode == "4"){	
		
		parent.parent.f_ivbutton.location.href	= "../jsp/IVPrescriptionButtons.jsp?patient_id="+patient_id+"&encounter_id="+encounter_id;
	}
}
*/
function chkAuthorization(src) {
	var allowed_click	= "";
	var formobj			= document.formIVPrescriptionDrugDetails;

	if (src == "authorize") {
		if(confirm(getMessage("PH_AUTHAPPROVE_1","PH"))) {
			document.formIVPrescriptionDrugDetails.AUTH_YN_VAL.value			= "Y";
			document.formIVPrescriptionDrugDetails.auth_yn_img.innerHTML	= "&nbsp;<IMG SRC=\"../../eOR/images/Authorized.gif\" BORDER=\"0\"></IMG>&nbsp;<B>Authorized</B>";
		}
		else {
			document.formIVPrescriptionDrugDetails.AUTH_YN_VAL.value			= "N";
			document.formIVPrescriptionDrugDetails.auth_yn_img.innerHTML	= "&nbsp;<IMG SRC=\"../../eOR/images/Authorization.gif\" BORDER=\"0\"></IMG>&nbsp;<A HREF onMouseOver=\"changeCursor(this)\" onClick=\"chkAuthorization('authorize')\">Authorize</A>";
		}

	}
	else if (src=="approve") {
		if (confirm(getMessage("PH_AUTHAPPROVE_2","PH"))) {
			document.formIVPrescriptionDrugDetails.APPROVAL_YN_VAL.value		= "Y";
			document.formIVPrescriptionDrugDetails.spappl_yn_img.innerHTML	= "&nbsp;<IMG SRC=\"../../eOR/images/SpecialApproval_click.gif\" BORDER=\"0\"></IMG>&nbsp;<B>Approved</B>";
		}
		else {
			document.formIVPrescriptionDrugDetails.APPROVAL_YN_VAL.value		= "N";
			document.formIVPrescriptionDrugDetails.spappl_yn_img.innerHTML	= "&nbsp;<IMG SRC=\"../../eOR/images/SpecialApproval.gif\" BORDER=\"0\"></IMG>&nbsp;<A HREF onMouseOver=\"changeCursor(this)\" onClick=\"chkAuthorization('approve')\">Approve</A>";
		}
	}
	else if (src=="cosign") {
		if (confirm(getMessage("PH_AUTHAPPROVE_3","PH"))) {
			document.formIVPrescriptionDrugDetails.COSIGN_YN_VAL.value			= "Y";
			document.formIVPrescriptionDrugDetails.cosign_yn_img.innerHTML	= "&nbsp;<IMG SRC=\"../../eOR/images/Cosign.gif\" BORDER=\"0\"></IMG>&nbsp;<B>Cosigned</B>";
		}
		else {
			document.formIVPrescriptionDrugDetails.COSIGN_YN_VAL.value			= "N";
			document.formIVPrescriptionDrugDetails.cosign_yn_img.innerHTML	= "&nbsp;<IMG SRC=\"../../eOR/images/Cosign_click.gif\" BORDER=\"0\"></IMG>&nbsp;<A HREF onMouseOver=\"changeCursor(this)\" onClick=\"chkAuthorization('cosign')\">Cosign</A>";
		}
	}
}


function setDurationValue(objVal, frmObj) {
	frmObj = eval(frmObj);
	frmObj.DURN_VALUE.value		= objVal;
	frmObj.DURN_UNIT.disabled	= true;
}

function chkMandatoryFlds(calledMode) {
	var retStat = true;	
	if (calledMode == "Amend") {
		var drgdtlsForm	= parent.f_sub_ivdrugs.document.formIVPrescriptionAdditives;
		
		//alert(drgdtlsForm);
		if (trimCheck(drgdtlsForm.STRENGTH_VALUE.value) == "") {
			alert(getMessage("STR_VAL_CANT_BLANK_ZERO","PH"));
			drgdtlsForm.STRENGTH_VALUE.select();
			retStat = false;
		}
		else if (drgdtlsForm.STRENGTH_UOM.value == "") {
			alert(getMessage("STR_UOM_CANT_BLANK","PH"));
			drgdtlsForm.STRENGTH_UOM.focus();
			retStat = false;
		}
		else if ((drgdtlsForm.LIMIT_IND.value == "N" && drgdtlsForm.EXCEED_DOSE_DESC.value == "") || (drgdtlsForm.ALLERGY_YN.value == "Y" && drgdtlsForm.ALLERGY_DESC.value == "") || (drgdtlsForm.CURRENT_RX.value == "Y" && drgdtlsForm.DUP_DRUG_DESC.value == "")) {
			alert(getMessage("OVR_RDN_RSN-CANT_BLNK","PH"));
			document.getElementById("OVERRIDE_LINK").click();
			retStat = false;
		}
		else if ((trimCheck(drgdtlsForm.INFUSION_PERIOD_VALUE.value) == "" || parseFloat(trimCheck(drgdtlsForm.INFUSION_PERIOD_VALUE.value)) == 0) && (trimCheck(drgdtlsForm.INFUSION_PERIOD_VALUE_MIN.value) == "" || parseFloat(trimCheck(drgdtlsForm.INFUSION_PERIOD_VALUE_MIN.value)) == 0)) {
			alert(getMessage("INFS_OVR_CANT_BLANK_ZERO","PH"));
			fluidForm.INFUSION_PERIOD_VALUE.value="";
			
			fluidForm.INFUSION_PERIOD_VALUE.focus();
			retStat = false;
		} 
		else if (drgdtlsForm.INFUSION_PERIOD_VALUE_MIN.style.visibility=="visible" && (parseInt(drgdtlsForm.INFUSION_PERIOD_VALUE_MIN.value) > 59  ) ) {
			alert(getMessage("INVALID_TIME_MINUTE","PH"));
			fluidForm.INFUSION_PERIOD_VALUE_MIN.focus();
			retStat = false;
		}
	}
	if (calledMode == "chargedetail" ){
		var fluidForm	="";
		if( parent.f_ivdetails!=undefined)
		     fluidForm	= parent.f_ivdetails.document.formIVPrescriptionAdditives;
	     else
             fluidForm	=parent.f_detail.document.formIVPrescriptionAdditives;
		var iv_calc_infuse_by = fluidForm.iv_calc_infuse_by.value //Added for SKR-CRF-0035 [IN:037727] 
		for(i=1;i<=6;i++){
			if((eval("fluidForm.active"+i).style.visibility =='visible' && eval("fluidForm.active"+i).checked) || (parent.f_ivdetails == undefined && eval("fluidForm.FLUID_CODE"+i).value!="") ) {
				if(iv_calc_infuse_by=='I'){
					var orderQty = eval('fluidForm.order_qty'+i).value;
					if(orderQty=="" ||  parseInt(orderQty)==0){
						alert(getMessage("PH_ORDER_QTY_BLANK","PH"));
						return false;
					}
				}
				mfrYN = eval("fluidForm.mfr_yn"+i).value;

				if(mfrYN != "Y"){ 
					var InfuseOverInMin = getInfuseOverInMin( eval("fluidForm.INFUSION_PERIOD_VALUE"+i).value,eval("fluidForm.INFUSION_PERIOD_VALUE_MIN"+i).value); 
					var InfuseOverInHr = parseFloat(InfuseOverInMin/60); 
					infuse_over =Math.round(InfuseOverInHr*100)/100;

					if(eval("fluidForm.DURATION"+i).value == "" || eval("fluidForm.DURATION"+i).value == "0") {
						alert(getMessage("DURATION_CANT_BLANK","PH"));
						var onBlur = document.getElementById("DURATION"+i).onblur;
						document.getElementById("DURATION"+i).onblur = null;
						document.getElementById("DURATION"+i).focus();
											setTimeout(function() {
												document.getElementById("DURATION"+i).onblur = onBlur;
											}, 500);
						eval("fluidForm.DURATION"+i).focus();
						retStat = false;
						break;
					} 
					else if ((eval("fluidForm.INFUSION_PERIOD_VALUE"+i).value== "" || parseFloat(eval("fluidForm.INFUSION_PERIOD_VALUE"+i).value)== 0) && (eval("fluidForm.INFUSION_PERIOD_VALUE_MIN"+i).value== "" || parseFloat(eval("fluidForm.INFUSION_PERIOD_VALUE_MIN"+i).value)== 0)) {
						alert(getMessage("INFS_OVR_CANT_BLANK_ZERO","PH"));
						var onBlur = document.getElementById("INFUSION_PERIOD_VALUE"+i).onblur;
						document.getElementById("INFUSION_PERIOD_VALUE"+i).onblur = null;
						document.getElementById("INFUSION_PERIOD_VALUE"+i).focus();
											setTimeout(function() {
												document.getElementById("INFUSION_PERIOD_VALUE"+i).onblur = onBlur;
											}, 500);
					
						eval("fluidForm.INFUSION_PERIOD_VALUE"+i).focus();
						retStat = false;
						break;
					} 
					else if ( parseInt(eval("fluidForm.INFUSION_PERIOD_VALUE_MIN"+i).value) > 59 ) {
						alert(getMessage("INVALID_TIME_MINUTE","PH"));
						var onBlur = document.getElementById("INFUSION_PERIOD_VALUE_MIN"+i).onblur;
						document.getElementById("INFUSION_PERIOD_VALUE_MIN"+i).onblur = null;
						document.getElementById("INFUSION_PERIOD_VALUE_MIN"+i).focus();
											setTimeout(function() {
												document.getElementById("INFUSION_PERIOD_VALUE_MIN"+i).onblur = onBlur;
											}, 500);
						
						
						eval("fluidForm.INFUSION_PERIOD_VALUE_MIN"+i).focus();
						retStat = false;
						break;
					}
					else if (eval("fluidForm.INF_RATE"+i).value == "" || parseFloat(eval("fluidForm.INF_RATE"+i).value) == 0) {
						alert(getMessage("INF_RATE_CANT_BLANK_ZERO","PH"));
						var onBlur = document.getElementById("INF_RATE"+i).onblur;
						document.getElementById("INF_RATE"+i).onblur = null;
						document.getElementById("INF_RATE"+i).focus();
											setTimeout(function() {
												document.getElementById("INF_RATE"+i).onblur = onBlur;
											}, 500);
						
						
						
						
						
						
						eval("fluidForm.INF_RATE"+i).focus();
						retStat = false;
						break;
					}
					else if(parseInt(eval("fluidForm.DURATION"+i).value) > 168  ) {
						alert(getMessage("DURATION_CANNOT_GREATER","PH"));
						var onBlur = document.getElementById("DURATION"+i).onblur;
						document.getElementById("DURATION"+i).onblur = null;
						document.getElementById("DURATION"+i).focus();
											setTimeout(function() {
												document.getElementById("DURATION"+i).onblur = onBlur;
											}, 500);
						
						
						
						
						
						retStat = false;
						break;
					}
					else if( parseFloat(infuse_over) > parseFloat(eval("fluidForm.DURATION"+i).value)  && iv_calc_infuse_by!='I' ){ // iv_calc_infuse_by Added for AAKH-SCF-0121 [IN:049680]
						/*if(iv_calc_infuse_by=='I')
							alert(getMessage("INFUSE_OVER_CANNOT_GREATER","PH"));
						else*/ //commented for AAKH-SCF-0121 [IN:049680]
							alert(getMessage("DURATION_CANNOT_LESSTHAN","PH"));
						retStat = false;
						break;
					}
				}
			}
		}
	}
	
	if (calledMode == "Release" || calledMode == "Preview" || calledMode == "AmendRelease" || calledMode == "PreviewAmend") {
		if(calledMode == "AmendRelease" || calledMode == "PreviewAmend"){
			var fluidForm	= parent.f_detail.formIVPrescriptionAdditives;	
			var drgdtlsForm	= parent.f_detail.formIVPrescriptionAdditives;	
			var optionForm	=	parent.f_options.document.formIVPrescriptionOptions;
		}
		else{
			var optionForm	= parent.f_ivselect.document.formIVPrescriptionOptions;		
			var drgdtlsForm	= parent.f_ivdetails.formIVPrescriptionAdditives;
			var fluidForm	= parent.f_ivdetails.formIVPrescriptionAdditives;
		}
		var iv_calc_infuse_by = fluidForm.iv_calc_infuse_by.value //Added for SKR-CRF-0035 [IN:037727] -start
		for(i=1;i<=6;i++){
			if((eval("fluidForm.active"+i).style.visibility =='visible' && eval("fluidForm.active"+i).checked) || (parent.f_ivdetails == undefined && eval("fluidForm.FLUID_CODE"+i).value!="") ) {
				if(iv_calc_infuse_by=='I'){
					var orderQty = eval('fluidForm.order_qty'+i).value;
					if(orderQty=="" ||  parseInt(orderQty)==0){
						alert(getMessage("PH_ORDER_QTY_BLANK","PH"));
						return false;
					}
				}
			}
		} //Added for SKR-CRF-0035 [IN:037727] -end

		if(drgdtlsForm.FLUID_NAME1.value != ""){
			var InfuseOverInMin = getInfuseOverInMin( drgdtlsForm.INFUSION_PERIOD_VALUE1.value,drgdtlsForm.INFUSION_PERIOD_VALUE_MIN1.value); 
			var InfuseOverInHr = parseFloat(InfuseOverInMin/60); 
			var infuse_over =Math.round(InfuseOverInHr*100)/100;
		}
		if(drgdtlsForm.FLUID_NAME2.value != ""){
			InfuseOverInMin = getInfuseOverInMin( drgdtlsForm.INFUSION_PERIOD_VALUE2.value,drgdtlsForm.INFUSION_PERIOD_VALUE_MIN2.value); 
			InfuseOverInHr = parseFloat(InfuseOverInMin/60); 
			infuse_over2 =Math.round(InfuseOverInHr*100)/100;
		}
		if(drgdtlsForm.FLUID_NAME3.value != ""){
			InfuseOverInMin = getInfuseOverInMin( drgdtlsForm.INFUSION_PERIOD_VALUE3.value,drgdtlsForm.INFUSION_PERIOD_VALUE_MIN3.value); 
			InfuseOverInHr = parseFloat(InfuseOverInMin/60); 
			infuse_over3 =Math.round(InfuseOverInHr*100)/100;
		}
		if(drgdtlsForm.FLUID_NAME4.value != ""){
			InfuseOverInMin = getInfuseOverInMin( drgdtlsForm.INFUSION_PERIOD_VALUE4.value,drgdtlsForm.INFUSION_PERIOD_VALUE_MIN4.value); 
			InfuseOverInHr = parseFloat(InfuseOverInMin/60); 
			infuse_over4 =Math.round(InfuseOverInHr*100)/100;
		}
		if(drgdtlsForm.FLUID_NAME5.value != ""){
			InfuseOverInMin = getInfuseOverInMin( drgdtlsForm.INFUSION_PERIOD_VALUE5.value,drgdtlsForm.INFUSION_PERIOD_VALUE_MIN5.value); 
			InfuseOverInHr = parseFloat(InfuseOverInMin/60); 
			infuse_over5 =Math.round(InfuseOverInHr*100)/100;
		}
		if(drgdtlsForm.FLUID_NAME6.value != ""){
			InfuseOverInMin = getInfuseOverInMin( drgdtlsForm.INFUSION_PERIOD_VALUE6.value,drgdtlsForm.INFUSION_PERIOD_VALUE_MIN6.value); 
			InfuseOverInHr = parseFloat(InfuseOverInMin/60); 
			infuse_over6 =Math.round(InfuseOverInHr*100)/100;
		}
		mfrYN = drgdtlsForm.mfr_yn1.value;
		if(mfrYN != "Y"){ 

		if (optionForm.type.value=="IVWA" && (drgdtlsForm.FLUID_CODE1.value == null || drgdtlsForm.FLUID_CODE1.value == "")) {
			alert(getMessage("FLUID_CANT_BLANK","PH"));
			drgdtlsForm.FLUID_NAME1.focus();
			retStat = false;
		} 
		else if(drgdtlsForm.mfr_yn1.value != "Y"){
			if (drgdtlsForm.START_DATE1.style.visibility=="visible" && trimCheck(drgdtlsForm.START_DATE1.value) == "") {
				alert(getMessage("PH_START_DATE","PH"));
				fluidForm.START_DATE1.focus();
				retStat = false;
			} 
			else if (drgdtlsForm.DURATION1.style.visibility=="visible" && trimCheck(drgdtlsForm.DURATION1.value) == "") {
				alert(getMessage("DURATION_CANT_BLANK","PH"));
				fluidForm.DURATION1.focus();
				retStat = false;
			} 
			else if(infuse_over > parseFloat(drgdtlsForm.DURATION1.value) && iv_calc_infuse_by!='I'){ // iv_calc_infuse_by Added for AAKH-SCF-0121 [IN:049680]
				/*if(iv_calc_infuse_by=='I')
					alert(getMessage("INFUSE_OVER_CANNOT_GREATER","PH"));
				else*/ //commented for AAKH-SCF-0121 [IN:049680]
					alert(getMessage("DURATION_CANNOT_LESSTHAN","PH"));
				retStat =  false;
			}
			else if (drgdtlsForm.INFUSION_PERIOD_VALUE1.style.visibility=="visible" && (trimCheck(drgdtlsForm.INFUSION_PERIOD_VALUE1.value) == "" || parseFloat(trimCheck(drgdtlsForm.INFUSION_PERIOD_VALUE1.value)) == 0) && (trimCheck(drgdtlsForm.INFUSION_PERIOD_VALUE_MIN1.value) == "" || parseFloat(trimCheck(drgdtlsForm.INFUSION_PERIOD_VALUE_MIN1.value)) == 0)) {
				alert(getMessage("INFS_OVR_CANT_BLANK_ZERO","PH"));
				fluidForm.INFUSION_PERIOD_VALUE1.focus();
				retStat = false;
			} 
			else if (drgdtlsForm.INFUSION_PERIOD_VALUE_MIN1.style.visibility=="visible" && (parseInt(drgdtlsForm.INFUSION_PERIOD_VALUE_MIN1.value) > 59  ) ) {
				alert(getMessage("INVALID_TIME_MINUTE","PH"));
				fluidForm.INFUSION_PERIOD_VALUE_MIN1.focus();
				retStat = false;
			}
			else if (drgdtlsForm.INF_RATE1.style.visibility=="visible" && trimCheck(drgdtlsForm.INF_RATE1.value) == "") {
				alert(getMessage("INF_RATE_CANT_BLANK_ZERO","PH"));
				fluidForm.INF_RATE1.focus();
				retStat = false;
			} 
		}
	}
	else if (drgdtlsForm.mfr_yn2.value != "Y"){
		if (drgdtlsForm.START_DATE2.style.visibility=="visible" && trimCheck(drgdtlsForm.START_DATE2.value) == "") {
			alert(getMessage("PH_START_DATE","PH"));
			fluidForm.START_DATE2.focus();
			retStat = false;
		} 
		else if (drgdtlsForm.DURATION2.style.visibility=="visible" && trimCheck(drgdtlsForm.DURATION2.value) == "") {
			alert(getMessage("DURATION_CANT_BLANK","PH"));
			fluidForm.DURATION2.focus();
			retStat = false;
		}
		else if(drgdtlsForm.DURATION2.style.visibility=="visible" && infuse_over2 > parseFloat(drgdtlsForm.DURATION2.value)  && iv_calc_infuse_by!='I'){ // iv_calc_infuse_by Added for AAKH-SCF-0121 [IN:049680]
			/*if(iv_calc_infuse_by=='I')
				alert(getMessage("INFUSE_OVER_CANNOT_GREATER","PH"));
			else*/ //commented for AAKH-SCF-0121 [IN:049680]
				alert(getMessage("DURATION_CANNOT_LESSTHAN","PH"));
			retStat =  false;
		}
		else if (drgdtlsForm.INFUSION_PERIOD_VALUE2.style.visibility=="visible" && (trimCheck(drgdtlsForm.INFUSION_PERIOD_VALUE2.value) == "" || parseFloat(trimCheck(drgdtlsForm.INFUSION_PERIOD_VALUE2.value)) == 0) && (trimCheck(drgdtlsForm.INFUSION_PERIOD_VALUE_MIN2.value) == "" || parseFloat(trimCheck(drgdtlsForm.INFUSION_PERIOD_VALUE_MIN2.value)) == 0)) {
			alert(getMessage("INFS_OVR_CANT_BLANK_ZERO","PH"));
			fluidForm.INFUSION_PERIOD_VALUE2.focus();
			retStat = false;
		} 
		else if (drgdtlsForm.INFUSION_PERIOD_VALUE_MIN2.style.visibility=="visible" && (parseInt(drgdtlsForm.INFUSION_PERIOD_VALUE_MIN2.value) > 59  ) ) {
			alert(getMessage("INVALID_TIME_MINUTE","PH"));
			fluidForm.INFUSION_PERIOD_VALUE_MIN2.focus();
			retStat = false;
		}
		else if (drgdtlsForm.INF_RATE2.style.visibility=="visible" && trimCheck(drgdtlsForm.INF_RATE2.value) == "") {
			alert(getMessage("INF_RATE_CANT_BLANK_ZERO","PH"));
			fluidForm.INF_RATE2.focus();
			retStat = false;
		} 
	}
	else if (drgdtlsForm.mfr_yn3.value != "Y"){
		 if (drgdtlsForm.START_DATE3.style.visibility=="visible" && trimCheck(drgdtlsForm.START_DATE3.value) == "") {
			alert(getMessage("PH_START_DATE","PH"));
			fluidForm.START_DATE3.focus();
			retStat = false;
		} 
		else if (drgdtlsForm.DURATION3.style.visibility=="visible" && trimCheck(drgdtlsForm.DURATION3.value) == "") {
			alert(getMessage("DURATION_CANT_BLANK","PH"));
			fluidForm.DURATION3.focus();
			retStat = false;
		} 
		else if(drgdtlsForm.DURATION3.style.visibility=="visible" && infuse_over3 > parseFloat(drgdtlsForm.DURATION3.value)  && iv_calc_infuse_by!='I'){ // iv_calc_infuse_by Added for AAKH-SCF-0121 [IN:049680]
			/*if(iv_calc_infuse_by=='I')
				alert(getMessage("INFUSE_OVER_CANNOT_GREATER","PH"));
			else*/ //commented for AAKH-SCF-0121 [IN:049680]
				alert(getMessage("DURATION_CANNOT_LESSTHAN","PH"));
			retStat =  false;
		}
		else if (drgdtlsForm.INFUSION_PERIOD_VALUE3.style.visibility=="visible" && (trimCheck(drgdtlsForm.INFUSION_PERIOD_VALUE3.value) == "" || parseFloat(trimCheck(drgdtlsForm.INFUSION_PERIOD_VALUE3.value)) == 0) && (trimCheck(drgdtlsForm.INFUSION_PERIOD_VALUE_MIN3.value) == "" || parseFloat(trimCheck(drgdtlsForm.INFUSION_PERIOD_VALUE_MIN3.value)) == 0)) {
			alert(getMessage("INFS_OVR_CANT_BLANK_ZERO","PH"));
			fluidForm.INFUSION_PERIOD_VALUE3.focus();
			retStat = false;
		}
		else if (drgdtlsForm.INFUSION_PERIOD_VALUE_MIN3.style.visibility=="visible" && (parseInt(drgdtlsForm.INFUSION_PERIOD_VALUE_MIN3.value) > 59  ) ) {
			alert(getMessage("INVALID_TIME_MINUTE","PH"));
			fluidForm.INFUSION_PERIOD_VALUE_MIN3.focus();
			retStat = false;
		}
		else if (drgdtlsForm.INF_RATE3.style.visibility=="visible" && trimCheck(drgdtlsForm.INF_RATE3.value) == "") {
			alert(getMessage("INF_RATE_CANT_BLANK_ZERO","PH"));
			fluidForm.INF_RATE3.focus();
			retStat = false;
		} 
	}
	else if (drgdtlsForm.mfr_yn4.value != "Y"){
		 if (drgdtlsForm.START_DATE4.style.visibility=="visible" && trimCheck(drgdtlsForm.START_DATE4.value) == "") {
			alert(getMessage("PH_START_DATE","PH"));
			fluidForm.START_DATE4.focus();
			retStat = false;
		}
		else if (drgdtlsForm.DURATION4.style.visibility=="visible" && trimCheck(drgdtlsForm.DURATION4.value) == "") {
			alert(getMessage("DURATION_CANT_BLANK","PH"));
			fluidForm.DURATION4.focus();
			retStat = false;
		}
		else if(drgdtlsForm.DURATION4.style.visibility=="visible" && infuse_over4 > parseFloat(drgdtlsForm.DURATION4.value)  && iv_calc_infuse_by!='I'){ // iv_calc_infuse_by Added for AAKH-SCF-0121 [IN:049680]
			/*if(iv_calc_infuse_by=='I')
				alert(getMessage("INFUSE_OVER_CANNOT_GREATER","PH"));
			else*/ //commented for AAKH-SCF-0121 [IN:049680]
				alert(getMessage("DURATION_CANNOT_LESSTHAN","PH"));
			retStat =  false;
		}
		else if (drgdtlsForm.INFUSION_PERIOD_VALUE4.style.visibility=="visible" && (trimCheck(drgdtlsForm.INFUSION_PERIOD_VALUE4.value) == "" || parseFloat(trimCheck(drgdtlsForm.INFUSION_PERIOD_VALUE4.value)) == 0) && (trimCheck(drgdtlsForm.INFUSION_PERIOD_VALUE_MIN4.value) == "" || parseFloat(trimCheck(drgdtlsForm.INFUSION_PERIOD_VALUE_MIN4.value)) == 0)){
			alert(getMessage("INFS_OVR_CANT_BLANK_ZERO","PH"));
			fluidForm.INFUSION_PERIOD_VALUE4.focus();
			retStat = false;
		}
		else if (drgdtlsForm.INFUSION_PERIOD_VALUE_MIN4.style.visibility=="visible" && (parseInt(drgdtlsForm.INFUSION_PERIOD_VALUE_MIN4.value) > 59  ) ) {
			alert(getMessage("INVALID_TIME_MINUTE","PH"));
			fluidForm.INFUSION_PERIOD_VALUE_MIN4.focus();
			retStat = false;
		}
		else if (drgdtlsForm.INF_RATE4.style.visibility=="visible" && trimCheck(drgdtlsForm.INF_RATE4.value) == "") {
			alert(getMessage("INF_RATE_CANT_BLANK_ZERO","PH"));
			fluidForm.INF_RATE4.focus();
			retStat = false;
		}
	}
	else if (drgdtlsForm.mfr_yn5.value != "Y"){
		 if (drgdtlsForm.START_DATE5.style.visibility=="visible" && trimCheck(drgdtlsForm.START_DATE5.value) == "") {
			alert(getMessage("PH_START_DATE","PH"));
			fluidForm.START_DATE5.focus();
			retStat = false;
		} 
		else if (drgdtlsForm.DURATION5.style.visibility=="visible" && trimCheck(drgdtlsForm.DURATION5.value) == "") {
			alert(getMessage("DURATION_CANT_BLANK","PH"));
			fluidForm.DURATION5.focus();
			retStat = false;
		}
		else if(drgdtlsForm.DURATION5.style.visibility=="visible" && infuse_over5 > parseFloat(drgdtlsForm.DURATION5.value)  && iv_calc_infuse_by!='I'){ // iv_calc_infuse_by Added for AAKH-SCF-0121 [IN:049680]
			/*if(iv_calc_infuse_by=='I')
				alert(getMessage("INFUSE_OVER_CANNOT_GREATER","PH"));
			else*/ //commented for AAKH-SCF-0121 [IN:049680]
				alert(getMessage("DURATION_CANNOT_LESSTHAN","PH"));
			retStat =  false;
		}
		else if (drgdtlsForm.INFUSION_PERIOD_VALUE5.style.visibility=="visible" && (trimCheck(drgdtlsForm.INFUSION_PERIOD_VALUE5.value) == "" || parseFloat(trimCheck(drgdtlsForm.INFUSION_PERIOD_VALUE5.value)) == 0) && (trimCheck(drgdtlsForm.INFUSION_PERIOD_VALUE_MIN5.value) == "" || parseFloat(trimCheck(drgdtlsForm.INFUSION_PERIOD_VALUE_MIN5.value)) == 0)) {
			alert(getMessage("INFS_OVR_CANT_BLANK_ZERO","PH"));
			fluidForm.INFUSION_PERIOD_VALUE5.focus();
			retStat = false;
		}
		else if (drgdtlsForm.INFUSION_PERIOD_VALUE_MIN5.style.visibility=="visible" && (parseInt(drgdtlsForm.INFUSION_PERIOD_VALUE_MIN5.value) > 59  ) ) {
			alert(getMessage("INVALID_TIME_MINUTE","PH"));
			fluidForm.INFUSION_PERIOD_VALUE_MIN5.focus();
			retStat = false;
		}
		else if (drgdtlsForm.INF_RATE5.style.visibility=="visible" && trimCheck(drgdtlsForm.INF_RATE5.value) == "") {
			alert(getMessage("INF_RATE_CANT_BLANK_ZERO","PH"));
			fluidForm.INF_RATE5.focus();
			retStat = false;
		}
	}
	else if (drgdtlsForm.mfr_yn6.value != "Y"){
		 if (drgdtlsForm.START_DATE6.style.visibility=="visible" && trimCheck(drgdtlsForm.START_DATE6.value) == "") {
			alert(getMessage("PH_START_DATE","PH"));
			fluidForm.START_DATE6.focus();
			retStat = false;
		} 
		else if (drgdtlsForm.DURATION6.style.visibility=="visible" && trimCheck(drgdtlsForm.DURATION6.value) == "") {
			alert(getMessage("DURATION_CANT_BLANK","PH"));
			fluidForm.DURATION6.focus();
			retStat = false;
		}
		else if(drgdtlsForm.DURATION6.style.visibility=="visible" && infuse_over6 > parseFloat(drgdtlsForm.DURATION6.value)  && iv_calc_infuse_by!='I'){ // iv_calc_infuse_by Added for AAKH-SCF-0121 [IN:049680]
			/*if(iv_calc_infuse_by=='I')
				alert(getMessage("INFUSE_OVER_CANNOT_GREATER","PH"));
			else*/ //commented for AAKH-SCF-0121 [IN:049680]
				alert(getMessage("DURATION_CANNOT_LESSTHAN","PH"));
			retStat =  false;
		}
		else if (drgdtlsForm.INFUSION_PERIOD_VALUE6.style.visibility=="visible" && (trimCheck(drgdtlsForm.INFUSION_PERIOD_VALUE6.value) == "" || parseFloat(trimCheck(drgdtlsForm.INFUSION_PERIOD_VALUE6.value)) == 0) && (trimCheck(drgdtlsForm.INFUSION_PERIOD_VALUE_MIN6.value) == "" || parseFloat(trimCheck(drgdtlsForm.INFUSION_PERIOD_VALUE_MIN6.value)) == 0)) {
			alert(getMessage("INFS_OVR_CANT_BLANK_ZERO","PH"));
			fluidForm.INFUSION_PERIOD_VALUE6.focus();
			retStat = false;
		}
		else if (drgdtlsForm.INFUSION_PERIOD_VALUE_MIN6.style.visibility=="visible" && (parseInt(drgdtlsForm.INFUSION_PERIOD_VALUE_MIN6.value) > 59  ) ) {
			alert(getMessage("INVALID_TIME_MINUTE","PH"));
			fluidForm.INFUSION_PERIOD_VALUE_MIN6.focus();
			retStat = false;
		}
		else if (drgdtlsForm.INF_RATE6.style.visibility=="visible" && trimCheck(drgdtlsForm.INF_RATE6.value) == "") {
			alert(getMessage("INF_RATE_CANT_BLANK_ZERO","PH"));
			fluidForm.INF_RATE6.focus();
			retStat = false;
		} 
	}
	}
	return retStat;
}

function callAmend() {

	if (chkMandatoryFlds("Amend")) {

		var frmObj = parent.f_sub_ivdrugs.document.formIVPrescriptionDrugDetails;
		
		var pclass	=frmObj.patient_class.value;
		var obj = frmObj.STRENGTH_UOM;
		frmObj.STR_DESC.value = obj.options[obj.selectedIndex].text;

		//code added to include infusion_value...on 10/5/2004
		//alert(parent.parent.f_iv_admin.formIVPrescriptionAdminDetail.infusion_over.value);
		frmObj.INFUSION_VALUE.value = parent.parent.f_iv_admin.formIVPrescriptionAdminDetail.INFUSION_PERIOD_VALUE.value;
		var xmlStr		= "<root><SEARCH " + buildXMLString(frmObj) + " /></root>";
		var bean_id		= frmObj.bean_id.value;
		var bean_name	= frmObj.bean_name.value;
		var qryString	= bean_id+"&bean_name="+bean_name+"&validate=AMENDDRUG&patient_class="+pclass;

		submitXML(qryString, xmlStr);
	}
}

function callClear() {
	var frmObj			= parent.f_ivdetails.document.formIVPrescriptionAdditives;
	var patient_id		= frmObj.patient_id.value;
	var encounter_id	= frmObj.encounter_id.value;
	var patient_class	= parent.parent.f_header.document.prescription_header_form.patient_class.value;
	var act_patient_class	= parent.parent.f_header.document.prescription_header_form.act_patient_class.value;

	parent.f_ivdetails.location.href = "../jsp/IVFluidAdditives.jsp?patient_id="+patient_id+"&encounter_id="+encounter_id+"&act_patient_class="+patient_class;
	
}

function callCancel(diagnosis_found_yn) {
	//alert(diagnosis_found_yn);
	var chk_flag = false;
	var calledFrom=1;
	if(parent.f_ivdetails !=undefined){
		var frmobj	= parent.f_ivdetails.document.formIVPrescriptionAdditives;	
		
			if(diagnosis_found_yn=="N"){
				alert(getMessage("REQ_DIAG_PRES_NOT_FOUND",'PH'));
				confirm_yn=true;
			}
		
		
		if(confirm_yn)
			chk_flag = true;
		
		
			var frmObj		= parent.f_ivdetails.document.formIVPrescriptionAdditives;
			var bean_id		= frmObj.bean_id.value;
			var bean_name	= frmObj.bean_name.value;
			var presc_mode	= 0;
			if (parent.f_ivselect.document.formIVPrescriptionOptions.type.value == "IVWA"){
			presc_mode	= 2;
            }
			var qryString	= bean_id+"&bean_name="+bean_name+"&validate=CLEARBEAN&calledFrom="+calledFrom+"&presc_mode="+presc_mode;
			submitXML(qryString, "");
		
		
	}
	
}

function callClearAll(calledFrom, confirm_yn) {

	var chk_flag = false;
	if(parent.f_ivdetails !=undefined){
		var frmobj	= parent.f_ivdetails.document.formIVPrescriptionAdditives;	
		if (calledFrom == 1 && confirm_yn == undefined) {
			if (confirm(getMessage("PH_RECOREDED_DATA_LOST","PH"))) {
			chk_flag = true;
			}
		}
		if(confirm_yn)
			chk_flag = true;
		if (calledFrom==2 || (calledFrom==1 && chk_flag)) {
		
			var frmObj		= parent.f_ivdetails.document.formIVPrescriptionAdditives;
			var bean_id		= frmObj.bean_id.value;
			var bean_name	= frmObj.bean_name.value;
			var presc_mode	= 0;
			if (parent.f_ivselect.document.formIVPrescriptionOptions.type.value == "IVWA"){
			presc_mode	= 2;
            }
			var qryString	= bean_id+"&bean_name="+bean_name+"&validate=CLEARBEAN&calledFrom="+calledFrom+"&presc_mode="+presc_mode;
			submitXML(qryString, "");
		
		}
	}
	else if(calledFrom==1)	{
		var frmobj	= parent.f_detail.formIVPrescriptionAdditives;
		frmobj.reset();
	 }
 }

function setInfusionPeriod(obj) {
	if (checkWholeNumber(obj)) {
		var fluidForm = parent.parent.f_ivfluid.document.formIVPrescriptionFluidDetail;
		var adminForm = parent.parent.f_ivadmin.document.formIVPrescriptionAdminDetail;
		var objVal = obj.value;

		if (trimCheck(objVal) != "") {
			var str_val = document.formIVPrescriptionDrugDetails.STRENGTH_VALUE.value;
			str_val		= Math.round(Math.ceil(str_val/objVal));
			fluidForm.DEF_INF_PRD.value				= str_val;
			fluidForm.INFUSION_PERIOD_VALUE.value	= str_val;
			adminForm.INFUSION_VALUE.value			= str_val;
		
			if(document.formIVPrescriptionDrugDetails.INFUSION_UOM.value=="pres_uom") {
				if(document.formIVPrescriptionDrugDetails.license.value!="PHBASIC") {
					fluidForm.INFUSION_PERIOD_VALUE.value	= Math.ceil(document.formIVPrescriptionDrugDetails.pack_size.value/objVal);
					adminForm.INFUSION_VALUE.value			= Math.ceil(document.formIVPrescriptionDrugDetails.pack_size.value/objVal);
				}
			}
			if (trimCheck(fluidForm.EQVL_UOM_VALUE.value) != "" && fluidForm.INFUSION_PERIOD_VALUE.value!='0') {
				//fluidForm.FLOW_VALUE.value	= Math.ceil(fluidForm.EQVL_UOM_VALUE.value/fluidForm.INFUSION_PERIOD_VALUE.value);
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
		}
		//fluidForm.INFUSION_PERIOD_UOM.value = "M";
		//adminForm.INFUSION_UOM.value		= "M";
	}
}

function reloadScreens(calledFrom, patient_id, encounter_id, order_date, pat_class,order_id,or_mode,presc_mode) {
	order_date = parent.parent.f_header.document.prescription_header_form.sys_date.value;
	MAR_app_yn = parent.frames[0].document.forms[0].MAR_app_yn.value;
	var bl_install_yn		 = parent.parent.f_header.prescription_header_form.bl_install_yn.value; 
	var bl_disp_charge_dtl_in_rx_yn = parent.parent.f_header.prescription_header_form.bl_disp_charge_dtl_in_rx_yn.value; 
	var preview_rx_yn	=	parent.parent.f_header.prescription_header_form.preview_rx_yn.value; //added for ML-MMOH-CRF-0341 [IN:057179]
	var act_patient_class = parent.parent.f_header.document.prescription_header_form.act_patient_class.value;
	var patient_class = parent.parent.f_header.document.prescription_header_form.patient_class.value;
	if (calledFrom == "1" && presc_mode == "2") {
		parent.f_ivdetails.location.href		= "../jsp/IVFluidAdditives.jsp?patient_id="+patient_id+"&encounter_id="+encounter_id+"&act_patient_class="+patient_class+"&start_date="+order_date+"&iv_option="+iv_option+"&MAR_app_yn="+MAR_app_yn;
	}else if(calledFrom == "1" && presc_mode == "0"){
		parent.location.href = "../jsp/IVPrescription.jsp?patient_id="+patient_id+"&encounter_id="+encounter_id+"&act_patient_class="+patient_class+"&start_date="+order_date+"&clearOrNot=Y"+"&MAR_app_yn="+MAR_app_yn+"&preview_rx_yn="+preview_rx_yn;

	}else if (calledFrom == "2") {
		var iv_option = "N";
		if (document.formIVPrescriptionOptions.type!=null && document.formIVPrescriptionOptions.type.value == "IVA")
			iv_option = "Y";
		var iv_prep_yn = "";
		if(iv_option=='IVD')
			iv_prep_yn='1';
		else if(iv_option=='IVPB')
			iv_prep_yn='3';
		else if(iv_option=='IVWA')
			iv_prep_yn='5';
		parent.f_ivdrugs.location.href	= "../jsp/IVPrescriptionDrugDetailFrames.jsp?patient_id="+patient_id+"&encounter_id="+encounter_id+"&act_patient_class="+patient_class+"&start_date="+order_date+"&iv_option="+iv_option+"&MAR_app_yn="+MAR_app_yn;
		parent.f_ivfluid.location.href	= "../jsp/IVPrescriptionFluidDetail.jsp?patient_id="+patient_id+"&encounter_id="+encounter_id+"&act_patient_class="+patient_class+"&start_date="+order_date+"&iv_option="+iv_option+"&MAR_app_yn="+MAR_app_yn;
		parent.f_ivadmin.location.href	= "../jsp/IVPrescriptionAdminDetail.jsp?patient_id="+patient_id+"&encounter_id="+encounter_id+"&act_patient_class="+patient_class+"&start_date="+order_date+"&iv_option="+iv_option+"&MAR_app_yn="+MAR_app_yn;
		parent.f_ivbutton.location.href	= "../jsp/IVPrescriptionButtons.jsp?patient_id="+patient_id+"&encounter_id="+encounter_id+"&act_patient_class="+patient_class+"&start_date="+order_date+"&iv_option="+iv_option+"&MAR_app_yn="+MAR_app_yn+"&iv_prep_yn="+iv_prep_yn+"&bl_install_yn="+bl_install_yn+"&bl_disp_charge_dtl_in_rx_yn="+bl_disp_charge_dtl_in_rx_yn+"&preview_rx_yn="+preview_rx_yn;
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
		else{
			//window.close();
			
		    
		    const dialogTag = parent.parent.document.getElementById("dialog_tag");    
		    dialogTag.close();  
		}
	}else if(calledFrom=="4"){
		document.location.href = "../jsp/IVPrescription.jsp?order_id="+order_id+"&patient_id="+patient_id+"&encounter_id="+encounter_id+"&act_patient_class="+patient_class+"&start_date="+order_date+"&clearOrNot=N&or_mode=amend"+"&MAR_app_yn="+MAR_app_yn+"&preview_rx_yn="+preview_rx_yn;
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
	document.formIVPrescriptionFluidDetail.STOCK_VALUE.value	= document.formIVPrescriptionFluidDetail.STOCK_VALUE.value;
	if(obj.name!="STOCK_UOM") {
		checkWholeNumber(obj);
		validateFlow(obj,mode);
	}
	else {
		//if(obj.value!="")
		//document.formIVPrescriptionFluidDetail.EQVL_UOM_DESC.value=obj.options[obj.selectedIndex].text;
		//getPresBase();
		//validateFlow(obj,mode);
		
	}
}

function getPresBase() {
	//alert('get pres called');
	var frmObj = document.formIVPrescriptionFluidDetail;
	var bean_id		= frmObj.bean_id.value;
	var bean_name	= frmObj.bean_name.value;
	var drug_code	= frmObj.FLUID_CODE.value;
	var qryString	= bean_id+"&bean_name="+bean_name+"&validate=GETPRESBASE&drug_code="+drug_code;
	submitXML(qryString, "");
}

function setPresBase(pres_base) {
	var val	=	pres_base.split("::");
	if(val!='null' && val!=undefined) {
	document.formIVPrescriptionFluidDetail.EQVL_UOM_DESC.value=val[0];
	document.formIVPrescriptionFluidDetail.STOCK_UOM.value=val[0];
	//document.formIVPrescriptionFluidDetail.BASE_UOM.value = val[1]; 
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
			var inf_val = frmObj.INFUSION_PERIOD_VALUE.value;
			if (trimCheck(objVal) != "" && trimCheck(inf_val) != "") {
				if (frmObj.INFUSION_PERIOD_UOM.value == "H")
					objVal = parseFloat(objVal)*60;
				
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
			if (trimCheck(frmObj.DEF_INF_PRD.value) != "" || trimCheck(frmObj.STOCK_VALUE.value) != "") {
				alert(getMessage("INFS_PRD_CANT_BLANK","PH"));
				obj.focus();
				parent.f_ivadmin.document.formIVPrescriptionAdminDetail.FREQUENCY.disabled = true;
			}
		}
		else {
			//if (frmObj.INFUSION_PERIOD_UOM.value == "H")
				//objVal = 60*(parseInt(objVal));

			if (parseInt(objVal) != parseInt(frmObj.DEF_INF_PRD.value) && frmObj.DEF_INF_PRD.value != "") {
				alert(getMessage("PH_FLUID_INF_PERIOD_NO_MATCH","PH"));
			}

			parent.f_ivadmin.document.formIVPrescriptionAdminDetail.INFUSION_VALUE.value				= frmObj.INFUSION_PERIOD_VALUE.value;
			parent.f_ivadmin.document.formIVPrescriptionAdminDetail.INFUSION_UOM.value					= frmObj.INFUSION_PERIOD_UOM.value;
			parent.f_ivadmin.document.formIVPrescriptionAdminDetail.FREQUENCY.disabled = false;

			if (trimCheck(frmObj.STOCK_VALUE.value) != "" && objVal!='0') {
				var str	=	parseFloat(frmObj.STOCK_VALUE.value/objVal)+"";
				var ind	=	str.lastIndexOf(".",str.length);
				if( str.length > ind+3)
					str	=	str.substring(0,ind+3);


				frmObj.FLOW_VALUE.value = str;
				
//				frmObj.FLOW_VALUE.value = Math.ceil((frmObj.EQVL_UOM_VALUE.value/objVal)*(frmObj.STOCK_VALUE.value));
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

		if (trimCheck(frmObj1.INFUSION_PERIOD_VALUE.value) != "") {
			var fluid_inf_prd = parseInt(frmObj1.INFUSION_PERIOD_VALUE.value);
			//if (frmObj1.INFUSION_PERIOD_UOM.value == "H")
			//	fluid_inf_prd = parseInt(60*(fluid_inf_prd));

			var total_inf_prd = "";

			if (trimCheck(objVal) != "") {
				total_inf_prd = parseInt(objVal);
				//if (frmObj.INFUSION_UOM.value == "H")
					//total_inf_prd = parseInt(60*(total_inf_prd));
			}

			if (total_inf_prd < fluid_inf_prd) {
				frmObj.FREQUENCY.value		= "";
				alert(getMessage("PH_TOT_INFUSION_LESS_THAN_FLUID_INFUSION","PH"));
			}
		}
	}
}

async function showMonoGraph(drug_desc, mono_graph, daily_dose, unit_dose, min_daily_dose, min_unit_dose) {
	var dialogTop		= "310";
 	var dialogHeight	= "15";
 	var dialogWidth		= "36";
	var dialogLeft		= "180";
 	var features		= "Width:" + dialogWidth + "; dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +"; dialogLeft:" + dialogLeft +"; dialogTop:" + dialogTop +"; scroll=no; status=no";
 	var arguments		= "";
 	var retVal 			=await  window.showModalDialog("../jsp/PrescriptionDosageLimitMonoGraph.jsp?drug_desc="+drug_desc+"&mono_graph="+mono_graph+"&daily_dose="+daily_dose+"&unit_dose="+unit_dose+"&min_daily_dose="+min_daily_dose+"&min_unit_dose="+min_unit_dose,arguments,features);
}

async function showAllergyDetails(generic_id, patient_id, encounter_id, generic_name, drug_name) {
	var dialogTop		= "310";
 	var dialogHeight	= "12";
 	var dialogWidth		= "25";
	var dialogLeft		= "240";
 	var features		= 'Width:' + dialogWidth +'; dialogHeight:' + dialogHeight + '; dialogWidth:' + dialogWidth +'; dialogLeft:' + dialogLeft +';  dialogTop:'+dialogTop +'; scroll=auto; status=no';
 	var arguments		= "";
 	var retVal 			= await window.showModalDialog("../jsp/PrescriptionAllergyDetailsFrames.jsp?generic_name="+generic_name+"&encounter_id="+encounter_id+"&generic_id="+generic_id+"&patient_id="+patient_id+"&drug_name="+drug_name,arguments,features);
}

async function callCurrentMedication(patient_id, encounter_id, generic_id,patient_class) {
	//alert("2");
	if(generic_id == undefined)
		generic_id="";
	var dialogHeight	= "20";
	var dialogWidth		= "50";
	var dialogTop		= "250";
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
	var abuse_override=frmObj.abuse_override.value;//added for akkh-crf-0140
	var abuse_override_remarks=frmObj.abuse_override_remarks.value;//added for akkh-crf-0140

	var dialogHeight	= "18";


	if(current_rx=="Y" && limit_ind=="N" && allergy_yn=="Y")
		dialogHeight	= "21";
	else if ( (current_rx=="Y" && limit_ind=="N") || (current_rx=="Y" && allergy_yn=="Y") || (limit_ind=="N" && allergy_yn=="Y" ))
		dialogHeight	= "16";
	else
		dialogHeight	= "12";

	var dialogWidth	= "40";
	var dialogTop	= "285";
	var dialogLeft	= "300";
	var center		= "0";
	var status		= "no";
	var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop+"; dialogLeft :"+dialogLeft;
	var arguments	= "";
	//retArray		= window.showModalDialog("../jsp/PrescriptionOverRideReason.jsp?gen_id="+generic_id+"&gen_name="+escape(generic_name)+"&pat_id="+patient_id+"&enc_id="+encounter_id+"&drug_desc="+escape(drug_desc)+"&mono_graph="+escape(mono_graph)+"&daily_dose="+daily_dose+"&unit_dose="+unit_dose+"&allergy_yn="+allergy_yn+"&current_rx="+current_rx+"&limit_ind="+limit_ind+"&drug_code="+drug_code+"&srl_no="+srl_no+"&allergy="+escape(allergy)+"&exceed_dose="+escape(exceed_dose)+"&dup_drug="+escape(dup_drug)+"&min_unit_dose="+min_unit_dose+"&min_daily_dose="+min_daily_dose, arguments, features);
	//modified for akkh-crf-0140
	retArray		=await  window.showModalDialog("../../ePH/jsp/PrescriptionOverRideReason.jsp?gen_id="+generic_id+"&gen_name="+encodeURIComponent(generic_name,"UTF-8")+"&pat_id="+patient_id+"&enc_id="+encounter_id+"&drug_desc="+encodeURIComponent(drug_desc,"UTF-8")+"&mono_graph="+encodeURIComponent(mono_graph,"UTF-8")+"&daily_dose="+daily_dose+"&unit_dose="+unit_dose+"&allergy_yn="+allergy_yn+"&current_rx="+current_rx+"&limit_ind="+limit_ind+"&drug_code="+drug_code+"&srl_no="+srl_no+"&allergy="+encodeURIComponent(allergy,"UTF-8")+"&exceed_dose="+encodeURIComponent(exceed_dose,"UTF-8")+"&dup_drug="+encodeURIComponent(dup_drug,"UTF-8")+"&min_unit_dose="+min_unit_dose+"&min_daily_dose="+min_daily_dose+"&abuse_override_remarks="+abuse_override_remarks+"&abuse_override="+abuse_override, arguments, features);
	if ( retArray != null && retArray != "" ) {
		var split_vals	= retArray.split(":::");
		frmObj.ALLERGY_DESC.value		= split_vals[0];
		frmObj.EXCEED_DOSE_DESC.value	= split_vals[1];
		frmObj.DUP_DRUG_DESC.value		= split_vals[2];
		frmObj.abuse_override.value		= split_vals[6];//added for akkh-crf-0140
		frmObj.abuse_override_remarks.value= split_vals[7];//added for akkh-crf-0140
		//alert(split_vals[7]);
	}
}

function getFormatId(calledFrom) {
	var formObj			= "";
	var drug_code		= "";
	if (calledFrom == "Drug") {
		formObj		= document.formIVPrescriptionDrugDetails;
		drug_code	= formObj.DRUG_CODE.value;
	}
	else if (calledFrom == "Fluid") {
		formObj		= document.formIVPrescriptionFluidDetail;
		drug_code	= formObj.FLUID_CODE.value;
	}

	var order_type	= formObj.ORDER_TYPE_CODE.value;
	var form_code	= formObj.FORM_CODE.value;
	var route_code	= formObj.ROUTE_CODE.value;
	var bean_id		= formObj.bean_id.value;
	var bean_name	= formObj.bean_name.value;
	var qryString	= bean_id+"&bean_name="+bean_name+"&validate=GETFORMATID&order_type="+order_type+"&form_code="+form_code+"&route_code="+route_code+"&drug_code="+drug_code+"&called_frm="+calledFrom;
	submitXML(qryString, "");
}

var pres_vals	=	new Array();
var i			=	0;
var formatId	=	"";

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
}*/

function callOrder(format_id,calledFrom, catalog_code, form_code, route_code) {
	var format	= format_id.split("~");
	formatId	= format[1];
	var frmObj = "";
	/*var vals = "";
	var drug_code = "";
	for(i=0; i<pres_vals.length; i++)	{
		if(i==pres_vals.length)
			vals	+= pres_vals[i];
		else
			vals	+= pres_vals[i]+ "::";
	}*/
	if (calledFrom == "Drug") {
		frmObj = document.formIVPrescriptionDrugDetails
		//drug_code = document.formIVPrescriptionDrugDetails.DRUG_CODE.value;
	}
	else if (calledFrom == "Fluid") {
		frmObj = document.formIVPrescriptionFluidDetail
		//drug_code = document.formIVPrescriptionFluidDetail.FLUID_CODE.value;
	}
	//added for SKR-SCF-0140 -start
	if(format == null || format=='' || formatId==null || formatId=='')
		frmObj.drug_remarks.style.display = 'none';
	else
		frmObj.drug_remarks.style.display = 'inline';
	//added for SKR-SCF-0140 -end

	callRemarks(frmObj, formatId, catalog_code, 'PH', '0', 'PH', form_code, route_code);
}

async function callRemarks(frmObj, format_id, catalog_code, order_category, row_value, called_from, form_code, route_code) {
	patient_id		= frmObj.patient_id.value;
	encounter_id	= frmObj.encounter_id.value;
	bean_id			= "@orderentrybean"+patient_id+encounter_id;
	bean_name		= "eOR.OrderEntryBean";

	var dialogHeight= "25";
	var dialogWidth	= "50";
	var dialogTop	= "169";
	var center		= "1";
	var status		= "no";
	var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop;
	var arguments	= "";
	var retVal		=await  window.showModalDialog("../../eOR/jsp/OrderEntryOrderFormatFrameSet.jsp?bean_id="+bean_id+"&bean_name="+bean_name+"&format_id="+format_id+"&p_catalog_code="+catalog_code+"&catalog_code="+catalog_code+"&p_form_code="+form_code+"&p_route_code="+route_code+"&order_category="+order_category+"&row_value=0&called_from=PH",arguments,features);
}

function assignValue(obj) {
	if(obj.checked==true){
		obj.value="Y";
	}
	else{
		obj.value="N";
		//document.formIVPrescriptionAdminDetail.FREQUENCY.disabled=false;
		//document.formIVPrescriptionAdminDetail.FREQUENCY.value="";
		//document.getElementById("SCHED_LINK").innerText	= "Scheduled Medication";
		//document.formIVPrescriptionAdminDetail.SCHED_MEDN.disabled=true;
		//document.formIVPrescriptionAdminDetail.mandate_sched.style.visibility="hidden";
	}
}

/*function setEndDate(end_date, obj) {
	obj = eval(obj);
	obj.value = end_date;
}

function chkDuration(obj, mode) {
	var frmObj		= document.formIVPrescriptionAdminDetail;

	if (mode == undefined)
		mode = "";

	if (mode == "1")
		frmObj		= parent.f_ivadmin.document.formIVPrescriptionAdminDetail;
	else if(mode == "2")
		frmObj		= parent.parent.f_ivadmin.document.formIVPrescriptionAdminDetail;
	if (obj.value != "") {
		var cont_flag	= true;
		var objVal		= obj.options[obj.selectedIndex].text;
		var totInfPrd	= parseInt(frmObj.INFUSION_VALUE.value);
		if (frmObj.INFUSION_UOM.value == "H")
			totInfPrd	= parseInt(totInfPrd)*60;

		var totDurn		= parseInt(objVal);
		if (frmObj.DURN_UNIT.value == "H")
			totDurn		= parseInt(totDurn)*60;

		if (totDurn < totInfPrd) {
			alert(getMessage("PH_DURATION_LESS_THAN_TOT_INF_PERIOD"));
			cont_flag = false;
		}

		if (cont_flag) {
			var bean_id		= frmObj.BEAN_ID.value;
			var bean_name	= frmObj.BEAN_NAME.value;
			var start_date	= frmObj.START_DATE.value;
			var durn_unit	= frmObj.DURN_UNIT.value;
			var qryString	= bean_id+"&bean_name="+bean_name+"&validate=POPULATEENDDATE&start_date="+start_date+"&durn_value="+objVal+"&durn_unit="+durn_unit+"&mode="+mode;
			submitXML(qryString, "");
		}
	}
	else {
		frmObj.END_DATE.value	= "";
	}
}
*/
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
	}else {
		if(document.formIVPrescriptionAdminDetail != null){
			document.formIVPrescriptionAdminDetail.REPEAT_VALUE.value	= "";
			document.formIVPrescriptionAdminDetail.FREQ_NATURE.value	= "";
		}else if(parent.f_ivadmin.formIVPrescriptionAdminDetail != null){
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
	//obj.checked = false;

	if (eval(objVal)) {
		obj.disabled = false;

	 if(mode=="or_amend"){
			//document.getElementById("mandate_sched").style.visibility = "visible";
			//document.getElementById("SCHED_LINK").innerHTML = "<A HREF onMouseOver=\"changeCursor(this)\" onClick=\"displaySchedule(document.formIVPrescriptionAdminDetail.SCHED_MEDN)\">Scheduled Medication</A>";
			//document.getElementById("SCHED_MEDN").checked	= true;
			//document.getElementById("SCHED_MEDN").value	= "Y";
			document.getElementById("SCHED_MEDN_YN").value = "Y";
			//document.getElementById("FREQUENCY").disabled	= true;
			//document.getElementById("SCHED_MEDN").disabled=true;

		}
		
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
		//chkDuration(frmObj.DURN_VALUE.value, "1");
	}
}

async function previewRX(title_display) { 
	if(parent.f_ivdetails !=undefined){
		if (chkMandatoryFlds("Preview")) {
			var optionForm	= parent.f_ivselect.document.formIVPrescriptionOptions;		
			var fladtForm	= parent.f_ivdetails.formIVPrescriptionAdditives;
			var hdrForm		= parent.parent.f_header.prescription_header_form;
			var titletext		= title_display;
			var patient_class	= hdrForm.patient_class.value;
			var patient_id		= fladtForm.patient_id.value;
			var encounter_id	= fladtForm.encounter_id.value;
			var date			= hdrForm.sys_date.value;
			var pract_name		= fladtForm.pract_name.value;
			if(pract_name!=null && pract_name!="")
				pract_name = encodeURIComponent(pract_name);
			var bean_id			= fladtForm.bean_id.value;
			var bean_name		= fladtForm.bean_name.value;
			var locn_code		= fladtForm.LOCN_CODE.value;
			var fluid_code		= "";
			var fluid_name		= "";
			var inf_prd			= "";
			var start_date		= "";
			var end_date		= "";
			var tot_inf_prd		= "";
			var duration1		= "";
			var volume			= "";
			var vol_uom			= "";
			var iv_calc_infuse_by = fladtForm.iv_calc_infuse_by.value //Added for SKR-CRF-0035 [IN:037727] 
			// Commented and moved the below variables inside loop - to reduce lines
			for(var row=1;row<=6;row++){
				if(row!="1"){
					eval("var fluid_code"+row+"= ''");
					eval("var fluid_name"+row+"= ''");
					eval("var inf_prd"+row+"= ''");
					eval("var start_date"+row+"= ''");
					eval("var end_date"+row+"=''");
					eval("var tot_inf_prd"+row+"=''");
					eval("var inf_rate_uom"+row+"=''");
					eval("var inf_rate_uom"+row+"_code=''");
					eval("var duration"+row+"=''");
					eval("var volume"+row+"=''");
					eval("var vol_uom"+row+"=''");
				}
				else{
					eval("var fluid_code= ''");
					eval("var fluid_name= ''");
					eval("var inf_prd= ''");
					eval("var start_date= ''");
					eval("var end_date=''");
					eval("var tot_inf_prd=''");
					eval("var inf_rate_uom=''");
					eval("var inf_rate_uom_code=''");
					eval("var duration=''");
					eval("var volume=''");
					eval("var vol_uom=''");
				}
				
				if(eval("fladtForm.active"+row).checked && eval("fladtForm.active"+row).style.visibility!= 'hidden'){
					//validateDuration(fladtForm.DURATION1,fladtForm.INFUSION_PERIOD_VALUE1);
					if(eval("fladtForm.mfr_yn"+row).value != "Y" && !validateRate1(eval("fladtForm.INF_RATE"+row),eval("fladtForm.stock_value"+row),eval("fladtForm.infusion_over_insert_value"+row),eval("fladtForm.DURATION"+row),eval("fladtForm.InfusionRateUnit"+row),eval("fladtForm.INFUSION_PERIOD_VALUE"+row), iv_calc_infuse_by)){
						return false;
					}
					else{
						//calculateRate(fladtForm.INFUSION_PERIOD_VALUE1, fladtForm.stock_value1,fladtForm.INF_RATE1);
						if(row!='1'){
							eval("var fluid_code"+row+"=fladtForm.FLUID_CODE"+row+".value");
							eval("var fluid_name"+row+"=fladtForm.FLUID_NAME"+row+".value");
							eval("var inf_prd"+row+"=fladtForm.INF_RATE"+row+".value");
							eval("var start_date"+row+"=fladtForm.START_DATE"+row+".value");
							eval("var end_date"+row+"=fladtForm.END_DATE"+row+".value");
							eval("var tot_inf_prd"+row+"=fladtForm.infusion_over_insert_value"+row+".value");
							eval("var inf_rate_uom"+row+"=fladtForm.InfusionRateUnit"+row+"[fladtForm.InfusionRateUnit"+row+".selectedIndex].innerText");
							eval("var inf_rate_uom"+row+"_code =fladtForm.InfusionRateUnit"+row+".value");
							//eval("var inf_rate_uom"+row+"_code")+eval("=fladtForm.InfusionRateUnit"+row+".value");
							eval("var duration"+row+"=fladtForm.DURATION"+row+".value");
							if(iv_calc_infuse_by=='I')
								eval("var volume"+row+"=fladtForm.volume"+row+".value");
							else
								eval("var volume"+row+"=fladtForm.stock_value"+row+".value");
							eval("var vol_uom"+row+"=fladtForm.stock_uom_code"+row+".value");
						}
						else{
							fluid_code		    = eval("fladtForm.FLUID_CODE"+row).value;
							fluid_name		    = eval("fladtForm.FLUID_NAME"+row).value;
							inf_prd		    	= eval("fladtForm.INF_RATE"+row).value;
							start_date		    = eval("fladtForm.START_DATE"+row).value;
							end_date		    = eval("fladtForm.END_DATE"+row).value;
							tot_inf_prd			= eval("fladtForm.infusion_over_insert_value"+row).value;
							//inf_rate_uom		= eval("fladtForm.InfusionRateUnit"+)[eval("fladtForm.InfusionRateUnit").selectedIndex].innerText;
							//eval("var inf_rate_uom"+row+"=fladtForm.InfusionRateUnit"+row+"[fladtForm.InfusionRateUnit"+row+".selectedIndex].innerText");
							inf_rate_uom		= eval("fladtForm.InfusionRateUnit"+row+"[fladtForm.InfusionRateUnit"+row+".selectedIndex].innerText");
							inf_rate_uom_code	= eval("fladtForm.InfusionRateUnit"+row).value;
							duration		    = eval("fladtForm.DURATION"+row).value;
							if(iv_calc_infuse_by=='I')
								volume	  = eval("fladtForm.volume"+row).value;
							else
								volume	    = eval("fladtForm.stock_value"+row).value;
							vol_uom		= eval("fladtForm.stock_uom_code"+row).value;
						}
					 }
				}
			/*if(fladtForm.active1.checked && fladtForm.active1.style.visibility!= 'hidden'){
				//validateDuration(fladtForm.DURATION1,fladtForm.INFUSION_PERIOD_VALUE1);

				if(fladtForm.mfr_yn1.value != "Y" && !validateRate1(fladtForm.INF_RATE1,fladtForm.stock_value1,fladtForm.infusion_over_insert_value1,fladtForm.DURATION1,fladtForm.InfusionRateUnit1,fladtForm.INFUSION_PERIOD_VALUE1)){
					return false;
				}
				else{
					//calculateRate(fladtForm.INFUSION_PERIOD_VALUE1, fladtForm.stock_value1,fladtForm.INF_RATE1);
					fluid_code		    = fladtForm.FLUID_CODE1.value;
					fluid_name		    = fladtForm.FLUID_NAME1.value;
					inf_prd		    = fladtForm.INF_RATE1.value;
					start_date		    = fladtForm.START_DATE1.value;
					end_date		    = fladtForm.END_DATE1.value;
					tot_inf_prd		= fladtForm.infusion_over_insert_value1.value;
					inf_rate_uom		= fladtForm.InfusionRateUnit1[fladtForm.InfusionRateUnit1.selectedIndex].innerText;
					inf_rate_uom_code	= fladtForm.InfusionRateUnit1.value;
					duration		    = fladtForm.DURATION1.value;
					volume			    = fladtForm.stock_value1.value;
					vol_uom			= fladtForm.stock_uom_code1.value;
				 }
			}
			var fluid_code2			= "";
			var fluid_name2			= "";
			var inf_prd2			= "";
			var start_date2			= "";
			var end_date2			= "";
			var tot_inf_prd2		= "";
			var duration2			= "";
			var volume2				= "";
			var vol_uom2			= "";
			var inf_rate_uom2		= "";
			var inf_rate_uom2_code	= "";
			
			if(fladtForm.active2.checked && fladtForm.active2.style.visibility!= 'hidden'){
				//validateDuration(fladtForm.DURATION2,fladtForm.INFUSION_PERIOD_VALUE2);
				if(fladtForm.mfr_yn2.value != "Y" && !validateRate1(fladtForm.INF_RATE2,fladtForm.stock_value2,fladtForm.infusion_over_insert_value2,fladtForm.DURATION2,fladtForm.InfusionRateUnit2,fladtForm.INFUSION_PERIOD_VALUE2)){
					return false;
				}
				else{
					//calculateRate(fladtForm.INFUSION_PERIOD_VALUE2, fladtForm.stock_value2,fladtForm.INF_RATE2);
					fluid_code2		= fladtForm.FLUID_CODE2.value;
					fluid_name2		= fladtForm.FLUID_NAME2.value;
					inf_prd2		    = fladtForm.INF_RATE2.value;
					inf_rate_uom2		= fladtForm.InfusionRateUnit2[fladtForm.InfusionRateUnit2.selectedIndex].innerText;
					inf_rate_uom2_code	= fladtForm.InfusionRateUnit2.value;
					start_date2		= fladtForm.START_DATE2.value;
					end_date2			= fladtForm.END_DATE2.value;
					tot_inf_prd2		= fladtForm.infusion_over_insert_value2.value;
					duration2			= fladtForm.DURATION2.value;
					volume2			= fladtForm.stock_value2.value;
					vol_uom2			= fladtForm.stock_uom_code2.value;
				}
			}
			
			var fluid_code3			= "";
			var fluid_name3		    = "";
			var inf_prd3			= "";
			var start_date3			= "";
			var end_date3			= "";
			var tot_inf_prd3		= "";
			var duration3			= "";
			var volume3				= "";
			var vol_uom3			= "";
			var inf_rate_uom3		= "";
			var inf_rate_uom3_code	= "";
			if(fladtForm.active3.checked && fladtForm.active3.style.visibility!= 'hidden'){
				//validateDuration(fladtForm.DURATION3,fladtForm.INFUSION_PERIOD_VALUE3);
				if(fladtForm.mfr_yn3.value != "Y" && !validateRate1(fladtForm.INF_RATE3,fladtForm.stock_value3,fladtForm.infusion_over_insert_value3,fladtForm.DURATION3,fladtForm.InfusionRateUnit3,fladtForm.INFUSION_PERIOD_VALUE3)){
					return false;
				}
				else{
					//calculateRate(fladtForm.INFUSION_PERIOD_VALUE3, fladtForm.stock_value3,fladtForm.INF_RATE3);
					fluid_code3		= fladtForm.FLUID_CODE3.value;
					fluid_name3		= fladtForm.FLUID_NAME3.value;
					inf_prd3		    = fladtForm.INF_RATE3.value;
					inf_rate_uom3		= fladtForm.InfusionRateUnit3[fladtForm.InfusionRateUnit3.selectedIndex].innerText;
					inf_rate_uom3_code	= fladtForm.InfusionRateUnit3.value;
					start_date3		= fladtForm.START_DATE3.value;
					end_date3			= fladtForm.END_DATE3.value;
					tot_inf_prd3		= fladtForm.infusion_over_insert_value3.value;
					duration3			= fladtForm.DURATION3.value;
					volume3			= fladtForm.stock_value3.value;
					vol_uom3			= fladtForm.stock_uom_code3.value;
				}
			}
			
			var fluid_code4			= "";
			var fluid_name4			= "";
			var inf_prd4			= "";
			var start_date4			= "";
			var end_date4			= "";
			var tot_inf_prd4		= "";
			var duration4			= "";
			var volume4				= "";
			var vol_uom4			= "";
			var inf_rate_uom4		= "";
			var inf_rate_uom4_code	= "";

			if(fladtForm.active4.checked&& fladtForm.active4.style.visibility!= 'hidden'){
				//validateDuration(fladtForm.DURATION4,fladtForm.INFUSION_PERIOD_VALUE4);
				if(fladtForm.mfr_yn4.value != "Y" && !validateRate1(fladtForm.INF_RATE4,fladtForm.stock_value4,fladtForm.infusion_over_insert_value4,fladtForm.DURATION4,fladtForm.InfusionRateUnit4,fladtForm.INFUSION_PERIOD_VALUE4)){
					return false;
				}
				else{
					//calculateRate(fladtForm.INFUSION_PERIOD_VALUE4, fladtForm.stock_value4,fladtForm.INF_RATE4);
					fluid_code4		= fladtForm.FLUID_CODE4.value;
					fluid_name4		= fladtForm.FLUID_NAME4.value;
					inf_prd4		    = fladtForm.INF_RATE4.value;
					inf_rate_uom4		= fladtForm.InfusionRateUnit4[fladtForm.InfusionRateUnit4.selectedIndex].innerText;
					inf_rate_uom4_code	= fladtForm.InfusionRateUnit4.value;
					start_date4	    = fladtForm.START_DATE4.value;
					end_date4		    = fladtForm.END_DATE4.value;
					tot_inf_prd4	    = fladtForm.infusion_over_insert_value4.value;
					duration4		    = fladtForm.DURATION4.value;
					volume4		    = fladtForm.stock_value4.value;
					vol_uom4		    = fladtForm.stock_uom_code4.value;
				}
			 }	
			
			var fluid_code5			= "";
			var fluid_name5			= "";
			var inf_prd5			= "";
			var start_date5			= "";
			var end_date5			= "";
			var tot_inf_prd5		= "";
			var duration5			= "";
			var volume5				= "";
			var vol_uom5			= "";
			var inf_rate_uom5		= "";
			var inf_rate_uom5_code	= "";
			 if(fladtForm.active5.checked && fladtForm.active5.style.visibility!= 'hidden'){
				 //validateDuration(fladtForm.DURATION5,fladtForm.INFUSION_PERIOD_VALUE5);
				if(fladtForm.mfr_yn5.value != "Y" && !validateRate1(fladtForm.INF_RATE5,fladtForm.stock_value5,fladtForm.infusion_over_insert_value5,fladtForm.DURATION5,fladtForm.InfusionRateUnit5,fladtForm.INFUSION_PERIOD_VALUE5)){
					return false;
				}
				else{
					//calculateRate(fladtForm.INFUSION_PERIOD_VALUE5, fladtForm.stock_value5,fladtForm.INF_RATE5);
					fluid_code5		= fladtForm.FLUID_CODE5.value;
					fluid_name5		= fladtForm.FLUID_NAME5.value;
					inf_prd5		    = fladtForm.INF_RATE5.value;
					inf_rate_uom5		= fladtForm.InfusionRateUnit5[fladtForm.InfusionRateUnit5.selectedIndex].innerText;
					inf_rate_uom5_code	= fladtForm.InfusionRateUnit5.value;
					start_date5		= fladtForm.START_DATE5.value;
					end_date5		= fladtForm.END_DATE5.value;
					tot_inf_prd5	= fladtForm.infusion_over_insert_value5.value;
					duration5		= fladtForm.DURATION5.value;
					volume5 		= fladtForm.stock_value5.value;
					vol_uom5		= fladtForm.stock_uom_code5.value;
				 }
			 }
			
			var fluid_code6			= "";
			var fluid_name6			= "";
			var inf_prd6			= "";
			var start_date6			= "";
			var end_date6			= "";
			var tot_inf_prd6		= "";
			var duration6			= "";
			var volume6			    = "";
			var vol_uom6			= "";
			var inf_rate_uom6		= "";
			var inf_rate_uom6_code	= "";
			if(fladtForm.active6.checked && fladtForm.active6.style.visibility!= 'hidden'){
				 // validateDuration(fladtForm.DURATION6,fladtForm.INFUSION_PERIOD_VALUE6);
				if(fladtForm.mfr_yn6.value != "Y" && !validateRate1(fladtForm.INF_RATE6,fladtForm.stock_value6,fladtForm.infusion_over_insert_value6,fladtForm.DURATION6,fladtForm.InfusionRateUnit6,fladtForm.INFUSION_PERIOD_VALUE6)){return false}else{
					//calculateRate(fladtForm.INFUSION_PERIOD_VALUE6, fladtForm.stock_value6,fladtForm.INF_RATE6);
					 fluid_code6		= fladtForm.FLUID_CODE6.value;
					 fluid_name6		= fladtForm.FLUID_NAME6.value;
					 inf_prd6		    = fladtForm.INF_RATE6.value;
					 inf_rate_uom6		= fladtForm.InfusionRateUnit6[fladtForm.InfusionRateUnit6.selectedIndex].innerText;
					 inf_rate_uom6_code	= fladtForm.InfusionRateUnit6.value;
					 start_date6		= fladtForm.START_DATE6.value;
					 end_date6		= fladtForm.END_DATE6.value;
					 tot_inf_prd6	= fladtForm.infusion_over_insert_value6.value;
					 duration6		= fladtForm.DURATION6.value;
					 volume6		= fladtForm.stock_value6.value;
					 vol_uom6		= fladtForm.stock_uom_code6.value;
				 }
			 }
			*/
			}
			if (optionForm.type.value == "IVWA") 
				titletext = title_display;

			var dialogHeight= "80vh";
			var dialogWidth	= "70vw";
			var dialogTop	= "";
			var center		= "1";
			var status		= "no";
			var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop;
			var arguments	= "";
			//var retVal		= window.showModalDialog("../jsp/IVPrescriptionPreviewFrames.jsp?titletext="+titletext+"&patient_id="+patient_id+"&encounter_id="+encounter_id+"&date="+start_date+"&locn_code="+locn_code+"&pract_name="+pract_name+"&actual_patient_class="+patient_class+"&fluid_name="+escape(fluid_name)+"&fluid_flow_rate="+fluid_flow_rate+"&fluid_inf_prd="+fluid_inf_prd+"&tot_inf_prd="+tot_inf_prd+"&frequency="+frequency+"&start_date="+start_date+"&end_date="+end_date+"&tot_inf_uom="+tot_inf_uom+"&fluid_volume_uom="+fluid_volume_uom+"&fluid_code="+fluid_code, arguments, features);
			var retVal		=		await top.window.showModalDialog("../../ePH/jsp/IVPrescriptionWithoutAdditivesPreFrame.jsp?titletext="+encodeURIComponent(titletext,"UTF-8")+"&patient_id="+patient_id+"&encounter_id="+encounter_id+"&date="+date+"&locn_code="+locn_code+"&pract_name="+encodeURIComponent(pract_name)+"&actual_patient_class="+patient_class+"&fluid_name="+encodeURIComponent(fluid_name,"UTF-8")+"&fluid_name2="+encodeURIComponent(fluid_name2,"UTF-8")+"&fluid_name3="+encodeURIComponent(fluid_name3,"UTF-8")+"&fluid_name4="+encodeURIComponent(fluid_name4,"UTF-8")+"&fluid_name5="+encodeURIComponent(fluid_name5,"UTF-8")+"&fluid_name6="+encodeURIComponent(fluid_name6)+"&tot_inf_prd="+tot_inf_prd+"&tot_inf_prd2="+tot_inf_prd2+"&tot_inf_prd3="+tot_inf_prd3+"&tot_inf_prd4="+tot_inf_prd4+"&tot_inf_prd5="+tot_inf_prd5+"&tot_inf_prd6="+tot_inf_prd6+"&volume="+volume+"&volume2="+volume2+"&volume3="+volume3+"&volume4="+volume4+"&volume5="+volume5+"&volume6="+volume6+"&vol_uom="+vol_uom+"&vol_uom2="+vol_uom2+"&vol_uom3="+vol_uom3+"&vol_uom4="+vol_uom4+"&vol_uom5="+vol_uom5+"&vol_uom6="+vol_uom6+"&frequency="+""+"&start_date="+start_date+"&start_date2="+start_date2+"&start_date3="+start_date3+"&start_date4="+start_date4+"&start_date5="+start_date5+"&start_date6="+start_date6+"&end_date="+end_date+"&end_date2="+end_date2+"&end_date3="+end_date3+"&end_date4="+end_date4+"&end_date5="+end_date5+"&end_date6="+end_date6+"&inf_prd="+inf_prd+"&inf_prd2="+inf_prd2+"&inf_prd3="+inf_prd3+"&inf_prd4="+inf_prd4+"&inf_prd5="+inf_prd5+"&inf_prd6="+inf_prd6+"&fluid_code2="+fluid_code2+"&fluid_code3="+fluid_code3+"&fluid_code4="+fluid_code4+"&fluid_code="+fluid_code+"&fluid_code5="+fluid_code5+"&fluid_code6="+fluid_code6+"&duration1="+duration+"&duration2="+duration2+"&duration3="+duration3+"&duration4="+duration4+"&duration5="+duration5+"&duration6="+duration6+"&inf_rate_uom_code="+inf_rate_uom_code+"&inf_rate_uom2_code="+inf_rate_uom2_code+"&inf_rate_uom3_code="+inf_rate_uom3_code+"&inf_rate_uom4_code="+inf_rate_uom4_code+"&inf_rate_uom5_code="+inf_rate_uom5_code+"&inf_rate_uom6_code="+inf_rate_uom6_code+"&inf_rate_uom="+inf_rate_uom+"&inf_rate_uom2="+inf_rate_uom2+"&inf_rate_uom3="+inf_rate_uom3+"&inf_rate_uom4="+inf_rate_uom4+"&inf_rate_uom5="+inf_rate_uom5+"&inf_rate_uom6="+inf_rate_uom6, arguments, features);			
			if(retVal!= undefined && retVal=='R') //if block added for ML-BRU-SCF-0533 [IN:036030]
				document.formIVPrescriptionButtons.RELEASE.click();
		}
	}
	else{
		if (chkMandatoryFlds("PreviewAmend")) {
			var fladtForm	= parent.f_detail.formIVPrescriptionAdditives;
			var optionForm	= parent.f_options.formIVPrescriptionOptions;	
			var hdrForm		= parent.f_header.prescription_header_form;
			
			var titletext		= title_display;
			var patient_id		= fladtForm.patient_id.value;
			var encounter_id	= fladtForm.encounter_id.value;
			var date			= hdrForm.sys_date.value;
			var pract_name		= fladtForm.pract_name.value;
			var patient_class	= fladtForm.patient_class.value;
			var bean_id			= fladtForm.bean_id.value;
			var bean_name		= fladtForm.bean_name.value;
			var locn_code		= fladtForm.LOCN_CODE.value;
			var iv_calc_infuse_by = fladtForm.iv_calc_infuse_by.value //Added for SKR-CRF-0035 [IN:037727] 
			// Commented and moved the below variables inside loop - to reduce lines
			for(row=1;row<=6;row++){
				eval("var fluid_code"+row+" = fladtForm.FLUID_CODE"+row+".value");
				eval("var fluid_name"+row+" = fladtForm.FLUID_NAME"+row+".value");
				eval("var inf_prd"+row+"	= fladtForm.INF_RATE"+row+".value");
				eval("var start_date"+row+" = fladtForm.START_DATE"+row+".value");
				eval("var end_date"+row+"	= fladtForm.END_DATE"+row+".value");
				eval("var tot_inf_prd"+row+" = fladtForm.infusion_over_insert_value"+row+".value");
				eval("var duration"+row+" = fladtForm.DURATION"+row+".value");
				if(iv_calc_infuse_by=='I')
					eval("var volume"+row+"	= fladtForm.volume"+row+".value");
				else
					eval("var volume"+row+"	= fladtForm.stock_value"+row+".value");
				eval("var vol_uom"+row+" = fladtForm.stock_uom_code"+row+".value");
				eval("var inf_rate_uom"+row+" = fladtForm.InfusionRateUnit"+row+"[fladtForm.InfusionRateUnit"+row+".selectedIndex].innerText");
				eval("var inf_rate_uom"+row+"_code = fladtForm.InfusionRateUnit"+row+".value");
			}
			/*var fluid_code		= fladtForm.FLUID_CODE1.value;
			var fluid_name		= fladtForm.FLUID_NAME1.value;
			var fluid_code2		= fladtForm.FLUID_CODE2.value;
			var fluid_name2		= fladtForm.FLUID_NAME2.value;
			var fluid_code3		= fladtForm.FLUID_CODE3.value;
			var fluid_name3		= fladtForm.FLUID_NAME3.value;
			var fluid_code4		= fladtForm.FLUID_CODE4.value;
			var fluid_name4		= fladtForm.FLUID_NAME4.value;
			var fluid_code5	    = fladtForm.FLUID_CODE5.value;
			var fluid_name5		= fladtForm.FLUID_NAME5.value;
			var fluid_code6		= fladtForm.FLUID_CODE6.value;
			var fluid_name6		= fladtForm.FLUID_NAME6.value;
			var inf_prd			= fladtForm.INF_RATE1.value;	
			var inf_prd2		= fladtForm.INF_RATE2.value;
			var inf_prd3		= fladtForm.INF_RATE3.value;
			var inf_prd4		= fladtForm.INF_RATE4.value;
			var inf_prd5		= fladtForm.INF_RATE5.value;
			var inf_prd6		= fladtForm.INF_RATE6.value;	
			var start_date		= fladtForm.START_DATE1.value;
			var end_date		= fladtForm.END_DATE1.value;
			var start_date2		= fladtForm.START_DATE2.value;
			var end_date2		= fladtForm.END_DATE2.value;
			var start_date3		= fladtForm.START_DATE3.value;
			var end_date3		= fladtForm.END_DATE3.value;
			var start_date4		= fladtForm.START_DATE4.value;
			var end_date4		= fladtForm.END_DATE4.value;
			var start_date5		= fladtForm.START_DATE5.value;
			var end_date5		= fladtForm.END_DATE5.value;
			var start_date6	    = fladtForm.START_DATE6.value;
			var end_date6		= fladtForm.END_DATE6.value;
			var locn_code		= fladtForm.LOCN_CODE.value;
	/*		var tot_inf_prd		= fladtForm.INFUSION_PERIOD_VALUE1.value;
			var tot_inf_prd2	= fladtForm.INFUSION_PERIOD_VALUE2.value;
			var tot_inf_prd3	= fladtForm.INFUSION_PERIOD_VALUE3.value;
			var tot_inf_prd4	= fladtForm.INFUSION_PERIOD_VALUE4.value;
			var tot_inf_prd5	= fladtForm.INFUSION_PERIOD_VALUE5.value;
			var tot_inf_prd6	= fladtForm.INFUSION_PERIOD_VALUE6.value;*/
			/*var tot_inf_prd		= fladtForm.infusion_over_insert_value1.value;
			var tot_inf_prd2	= fladtForm.infusion_over_insert_value2.value;
			var tot_inf_prd3	= fladtForm.infusion_over_insert_value3.value;
			var tot_inf_prd4	= fladtForm.infusion_over_insert_value4.value;
			var tot_inf_prd5	= fladtForm.infusion_over_insert_value5.value;
			var tot_inf_prd6	= fladtForm.infusion_over_insert_value6.value;
			var duration1		= fladtForm.DURATION1.value;
			var duration2		= fladtForm.DURATION2.value;
			var duration3		= fladtForm.DURATION3.value;
			var duration4		= fladtForm.DURATION4.value;
			var duration5		= fladtForm.DURATION5.value;
			var duration6		= fladtForm.DURATION6.value;
			var volume			= fladtForm.stock_value1.value;
			var volume2			= fladtForm.stock_value2.value;
			var volume3			= fladtForm.stock_value3.value;
			var volume4			= fladtForm.stock_value4.value;
			var volume5			= fladtForm.stock_value5.value;
			var volume6			= fladtForm.stock_value6.value;
			var vol_uom			= fladtForm.stock_uom_code1.value;
			var vol_uom2		= fladtForm.stock_uom_code2.value;
			var vol_uom3		= fladtForm.stock_uom_code3.value;
			var vol_uom4		= fladtForm.stock_uom_code4.value;		
			var vol_uom5		= fladtForm.stock_uom_code5.value;	
			var vol_uom6		= fladtForm.stock_uom_code6.value;	
			var inf_rate_uom		= fladtForm.InfusionRateUnit1[fladtForm.InfusionRateUnit1.selectedIndex].innerText;
			var inf_rate_uom2		= fladtForm.InfusionRateUnit2[fladtForm.InfusionRateUnit2.selectedIndex].innerText;
			var inf_rate_uom3		= fladtForm.InfusionRateUnit3[fladtForm.InfusionRateUnit3.selectedIndex].innerText;
			var inf_rate_uom4		= fladtForm.InfusionRateUnit4[fladtForm.InfusionRateUnit4.selectedIndex].innerText;
			var inf_rate_uom5		= fladtForm.InfusionRateUnit5[fladtForm.InfusionRateUnit5.selectedIndex].innerText;
			var inf_rate_uom6		= fladtForm.InfusionRateUnit6[fladtForm.InfusionRateUnit6.selectedIndex].innerText;
			var inf_rate_uom_code		= fladtForm.InfusionRateUnit1.value;
			var inf_rate_uom2_code		= fladtForm.InfusionRateUnit2.value;
			var inf_rate_uom3_code		= fladtForm.InfusionRateUnit3.value;
			var inf_rate_uom4_code		= fladtForm.InfusionRateUnit4.value;
			var inf_rate_uom5_code		= fladtForm.InfusionRateUnit5.value;
			var inf_rate_uom6_code		= fladtForm.InfusionRateUnit6.value;*/
	//		if (optionForm.type.value == "IVWA") titletext = getLabel("ePH.IVwithoutAdditives.label","PH");
			var dialogHeight= "80vh";
			var dialogWidth	= "70vw";
			var dialogTop	= "250";
			var center		= "1";
			var status		= "no";
			var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop;
			var arguments	= "";
			//alert(fluid_name);
			//var retVal		= window.showModalDialog("../jsp/IVPrescriptionPreviewFrames.jsp?titletext="+titletext+"&patient_id="+patient_id+"&encounter_id="+encounter_id+"&date="+start_date+"&locn_code="+locn_code+"&pract_name="+pract_name+"&actual_patient_class="+patient_class+"&fluid_name="+escape(fluid_name)+"&fluid_flow_rate="+fluid_flow_rate+"&fluid_inf_prd="+fluid_inf_prd+"&tot_inf_prd="+tot_inf_prd+"&frequency="+frequency+"&start_date="+start_date+"&end_date="+end_date+"&tot_inf_uom="+tot_inf_uom+"&fluid_volume_uom="+fluid_volume_uom+"&fluid_code="+fluid_code, arguments, features);
			var retVal		=await  top.window.showModalDialog("../../ePH/jsp/IVPrescriptionWithoutAdditivesPreFrame.jsp?titletext="+encodeURIComponent(titletext,"UTF-8")+"&patient_id="+patient_id+"&encounter_id="+encounter_id+"&date="+date+"&locn_code="+locn_code+"&pract_name="+pract_name+"&actual_patient_class="+patient_class+"&fluid_name="+escape(fluid_name1)+"&fluid_name2="+escape(fluid_name2)+"&fluid_name3="+escape(fluid_name3)+"&fluid_name4="+escape(fluid_name4)+"&fluid_name5="+escape(fluid_name5)+"&fluid_name6="+escape(fluid_name6)+"&tot_inf_prd="+tot_inf_prd1+"&tot_inf_prd2="+tot_inf_prd2+"&tot_inf_prd3="+tot_inf_prd3+"&tot_inf_prd4="+tot_inf_prd4+"&tot_inf_prd5="+tot_inf_prd5+"&tot_inf_prd6="+tot_inf_prd6+"&volume="+volume1+"&volume2="+volume2+"&volume3="+volume3+"&volume4="+volume4+"&volume5="+volume5+"&volume6="+volume6+"&vol_uom="+vol_uom1+"&vol_uom2="+vol_uom2+"&vol_uom3="+vol_uom3+"&vol_uom4="+vol_uom4+"&vol_uom5="+vol_uom5+"&vol_uom6="+vol_uom6+"&frequency="+""+"&start_date="+start_date1+"&start_date2="+start_date2+"&start_date3="+start_date3+"&start_date4="+start_date4+"&start_date5="+start_date5+"&start_date6="+start_date6+"&end_date="+end_date1+"&end_date2="+end_date2+"&end_date3="+end_date3+"&end_date4="+end_date4+"&end_date5="+end_date5+"&end_date6="+end_date6+"&inf_prd="+inf_prd1+"&inf_prd2="+inf_prd2+"&inf_prd3="+inf_prd3+"&inf_prd4="+inf_prd4+"&inf_prd5="+inf_prd5+"&inf_prd6="+inf_prd6+"&fluid_code2="+fluid_code2+"&fluid_code3="+fluid_code3+"&fluid_code4="+fluid_code4+"&fluid_code="+fluid_code1+"&fluid_code5="+fluid_code5+"&fluid_code6="+fluid_code6+"&duration1="+duration1+"&duration2="+duration2+"&duration3="+duration3+"&duration4="+duration4+"&duration5="+duration5+"&duration6="+duration6+"&inf_rate_uom_code="+inf_rate_uom1_code+"&inf_rate_uom2_code="+inf_rate_uom2_code+"&inf_rate_uom3_code="+inf_rate_uom3_code+"&inf_rate_uom4_code="+inf_rate_uom4_code+"&inf_rate_uom5_code="+inf_rate_uom5_code+"&inf_rate_uom6_code="+inf_rate_uom6_code+"&inf_rate_uom="+inf_rate_uom1+"&inf_rate_uom2="+inf_rate_uom2+"&inf_rate_uom3="+inf_rate_uom3+"&inf_rate_uom4="+inf_rate_uom4+"&inf_rate_uom5="+inf_rate_uom5+"&inf_rate_uom6="+inf_rate_uom6, arguments, features);
			if(retVal!= undefined && retVal=='R') //if block added for ML-BRU-SCF-0533 [IN:036030]
				document.formIVPrescriptionButtons.RELEASE.click();
		}
    }
}

function releaseRX(){
	
	if(parent.f_ivdetails == undefined){
		var frmobj	= parent.f_detail.formIVPrescriptionAdditives;
		var mode1= frmobj.mode1.value;
		if(mode1== null){ mode1="";}
		if(mode1=="amend"){
			releaseRX2();
        }
		else{
			releaseRX1();
		}
	}
	else {
		releaseRX1();
	}
}
async function releaseRX2(){	
	if (parent.f_detail.formIVPrescriptionAdditives.mfr_yn1.value == "Y" || chkMandatoryFlds("AmendRelease")){
		var frmobj	= parent.f_detail.formIVPrescriptionAdditives;	
		var mode1=frmobj.mode1.value;
	
	//form the xmlString
	//xmlStr 
	// invoke the IVPrescriptionValidate.jsp with some identity like "RELEASE_FLUIDS"
	// use the logic wat we incorporated in setall method
	// set all the fluid details into the bean
	// invoke modify

		var patient_id		= frmobj.patient_id.value;
		var encounter_id	= frmobj.encounter_id.value;
		var date			= frmobj.START_DATE1.value;
		var pract_name		= frmobj.pract_name.value;
		var locn_code		= frmobj.LOCN_CODE.value;
		var bean_id			= frmobj.bean_id.value;
		var bean_name		= frmobj.bean_name.value;
		var mode			= frmobj.mode.value;
		var iv_calc_infuse_by = frmobj.iv_calc_infuse_by.value //Added for SKR-CRF-0035 [IN:037727] 
		// Commented and moved the below variables inside loop to reduce lines
		for(row=1;row<=6;row++){
			eval("var fluid_code"+row+"=frmobj.FLUID_CODE"+row+".value");
			//eval("var fluid_name"+row+"=frmobj.FLUID_NAME"+row+".value");
			eval("var inf_prd"+row+"=frmobj.INF_RATE"+row+".value");	
			eval("var start_date"+row+"=frmobj.START_DATE"+row+".value");
			eval("var end_date"+row+"=frmobj.END_DATE"+row+".value");
			eval("var tot_inf_prd"+row+"=frmobj.infusion_over_insert_value"+row+".value");
			eval("var volume"+row+"=frmobj.volume"+row+".value");
			eval("var mfr_yn"+row+"=frmobj.mfr_yn"+row+".value");
			if(iv_calc_infuse_by=='I'){//if block Added for AAKH-SCF-0121IN[049680]  //Added for AAKH-SCF-0121 [IN:049680]
				eval("frmobj.DURATION"+row).value=eval("frmobj.infusion_over_insert_value"+row+".value");
			}
			eval("var duration"+row+"=frmobj.DURATION"+row+".value");
			eval("var SELECT"+row+" = 'N'");
			eval("var inf_rate_uom"+row+"=frmobj.InfusionRateUnit"+row+".value");
		}
		/*var fluid_code		= frmobj.FLUID_CODE1.value;
		var fluid_name		= frmobj.FLUID_NAME1.value;
		var fluid_code2		= frmobj.FLUID_CODE2.value;
		/*var fluid_name		= frmobj.FLUID_NAME1.value;
		var fluid_name2		= frmobj.FLUID_NAME2.value;
		var fluid_name3		= frmobj.FLUID_NAME3.value;
		var fluid_name4		= frmobj.FLUID_NAME4.value;
		var fluid_name5		= frmobj.FLUID_NAME5.value;
		var fluid_name6		= frmobj.FLUID_NAME6.value;*/
		var inf_prd			= frmobj.INF_RATE1.value;	
		var inf_prd2		= frmobj.INF_RATE2.value;
		var inf_prd3		= frmobj.INF_RATE3.value;
		var inf_prd4		= frmobj.INF_RATE4.value;
		var inf_prd5		= frmobj.INF_RATE5.value;	
		var inf_prd6		= frmobj.INF_RATE6.value;	
		var start_date		= frmobj.START_DATE1.value;
		var end_date		= frmobj.END_DATE1.value;
		var start_date2		= frmobj.START_DATE2.value;
		var end_date2		= frmobj.END_DATE2.value;
		var start_date3		= frmobj.START_DATE3.value;
		var end_date3		= frmobj.END_DATE3.value;
		var start_date4		= frmobj.START_DATE4.value;
		var end_date4		= frmobj.END_DATE4.value;
		var start_date5		= frmobj.START_DATE5.value;
		var end_date5		= frmobj.END_DATE5.value;
		var start_date6	    = frmobj.START_DATE6.value;
		var end_date6		= frmobj.END_DATE6.value;
		var locn_code		= frmobj.LOCN_CODE.value;
		var tot_inf_prd		= frmobj.infusion_over_insert_value1.value;
		var tot_inf_prd2	= frmobj.infusion_over_insert_value2.value;
		var tot_inf_prd3	= frmobj.infusion_over_insert_value3.value;
		var tot_inf_prd4	= frmobj.infusion_over_insert_value4.value;
		var tot_inf_prd5	= frmobj.infusion_over_insert_value5.value;
		var tot_inf_prd6	= frmobj.infusion_over_insert_value6.value;
		var volume1			= frmobj.volume1.value;
		var volume2			= frmobj.volume2.value;
		var volume3			= frmobj.volume3.value;
		var volume4			= frmobj.volume4.value;
		var volume5			= frmobj.volume5.value;
		var volume6		    = frmobj.volume6.value;
		var mfr_yn1			= frmobj.mfr_yn1.value;
		var mfr_yn2			= frmobj.mfr_yn2.value;
		var mfr_yn3			= frmobj.mfr_yn3.value;
		var mfr_yn4			= frmobj.mfr_yn4.value;
		var mfr_yn5			= frmobj.mfr_yn5.value;
		var mfr_yn6		    = frmobj.mfr_yn6.value;
		
		if(mfr_yn1=="Y"){
			var mfr_remarks1	= frmobj.mfr_remarks1.value;
			var mfr_remarks2	= frmobj.mfr_remarks2.value;
			var mfr_remarks3	= frmobj.mfr_remarks3.value;
			var mfr_remarks4	= frmobj.mfr_remarks4.value;
			var mfr_remarks5	= frmobj.mfr_remarks5.value;
			var mfr_remarks6    = frmobj.mfr_remarks6.value;
		}
		else{
			var mfr_remarks1	= frmobj.mfr_remarks1.value;
			var mfr_remarks2	= "";
			var mfr_remarks3	= "";
			var mfr_remarks4	= "";
			var mfr_remarks5	= "";
			var mfr_remarks6    = "";
		}

		/* Commented and moved into loop 
		var duration1		= frmobj.DURATION1.value;
		var duration2		= frmobj.DURATION2.value;
		var duration3		= frmobj.DURATION3.value;
		var duration4		= frmobj.DURATION4.value;
		var duration5		= frmobj.DURATION5.value;
		var duration6		= frmobj.DURATION6.value;
		var SELECT1 = "N";
		var SELECT2 = "N";
		var SELECT3 = "N";
		var SELECT4 = "N";
		var SELECT5 = "N";
		var SELECT6 = "N";
		var inf_rate_uom1		= frmobj.InfusionRateUnit1.value;
		var inf_rate_uom2		= frmobj.InfusionRateUnit2.value;
		var inf_rate_uom3		= frmobj.InfusionRateUnit3.value;
		var inf_rate_uom4		= frmobj.InfusionRateUnit4.value;
		var inf_rate_uom5		= frmobj.InfusionRateUnit5.value;
		var inf_rate_uom6		= frmobj.InfusionRateUnit6.value;*/
		var patient_class	= parent.f_header.prescription_header_form.patient_class.value;
		var buildMAR_yn		= frmobj.buildMAR_yn.value; //added for SRR20056-SCF-7882 -29157
		parent.f_header.prescription_header_form.buildMAR_yn.value=buildMAR_yn; //added for  MMS-QH-CRF-0080 [IN:038064]
//		var act_patient_class	= parent.f_header.prescription_header_form.act_patient_class.value;
		
		var fladtForm	= parent.f_detail.formIVPrescriptionAdditives;
		if(frmobj.active1.checked ){
			if(parent.f_detail.formIVPrescriptionAdditives.mfr_yn1.value == "Y")
				SELECT1			= "Y";
			else{
				if(fladtForm.mfr_yn1.value != "Y" && !validateRate1(fladtForm.INF_RATE1,fladtForm.stock_value1,fladtForm.infusion_over_insert_value1,fladtForm.DURATION1,fladtForm.InfusionRateUnit1,fladtForm.INFUSION_PERIOD_VALUE1, iv_calc_infuse_by)){
				return false;
			}else{
			SELECT1			= "Y"; }}
		}

		var priority		= parent.f_header.prescription_header_form.priority.value;
		var height			= parent.f_header.prescription_header_form.height.value;
		var height_uom		= parent.f_header.prescription_header_form.height_unit.value;
		var weight			= parent.f_header.prescription_header_form.weight.value;
		var weight_uom		= parent.f_header.prescription_header_form.weight_unit.value;
        var bsa				= parent.f_header.prescription_header_form.bsa.value;
		var bmi				= parent.f_header.prescription_header_form.bmi.value;
			
		var allergic_yn ="N";

		if(parent.f_header.prescription_header_form.allergic_yn.checked) {
			allergic_yn	=	"Y";	
		} 
		else {
			allergic_yn	=	"N";	
		}


		var xmlStr		= "<root><SEARCH ";
		// Commented and added the below variables inside loop to reduce lines
		for(row=1;row<=6;row++){
			xmlStr			+= " FLUID_CODE"+row+"=\""+ eval("fluid_code"+row) + "\" ";
			//xmlStr			+= " FLUID_NAME"+row+"=\""+ eval("fluid_name"+row) + "\" ";
			xmlStr			+= " INF_RATE"+row+"=\""+ eval("inf_prd"+row) + "\" ";
			xmlStr			+= " INFUSION_PERIOD_VALUE"+row+"=\""+ eval("tot_inf_prd"+row) + "\" ";
			xmlStr			+= " START_DATE"+row+"=\""+ eval("start_date"+row) + "\" ";
			xmlStr			+= " END_DATE"+row+"=\""+ eval("end_date"+row) + "\" ";
			xmlStr			+= " volume"+row+"=\""+ eval("volume"+row) + "\" ";
			xmlStr			+= " DURATION"+row+"=\""+ eval("duration"+row) + "\" ";
			xmlStr			+= " SELECT"+row+"=\""+ eval("SELECT"+row) + "\" ";
			xmlStr			+= " inf_rate_uom"+row+"=\""+ eval("inf_rate_uom"+row) + "\" ";
			xmlStr			+= " mfr_yn"+row+"=\""+ eval("mfr_yn"+row)+ "\" ";
			xmlStr			+= " mfr_remarks"+row+"=\""+ eval("mfr_remarks"+row) + "\" ";
		}
		
		/*xmlStr			+= " FLUID_CODE1=\""+ fluid_code + "\" ";
		xmlStr			+= " FLUID_CODE2=\""+ fluid_code2 + "\" ";
		xmlStr			+= " FLUID_CODE3=\""+ fluid_code3 + "\" ";
		xmlStr			+= " FLUID_CODE4=\""+ fluid_code4 + "\" ";
		xmlStr			+= " FLUID_CODE5=\""+ fluid_code5 + "\" ";
		xmlStr			+= " FLUID_CODE6=\""+ fluid_code6 + "\" ";
		xmlStr			+= " FLUID_NAME1=\""+ fluid_name + "\" ";
		xmlStr			+= " FLUID_NAME2=\""+ fluid_name2 + "\" ";
		xmlStr			+= " FLUID_NAME3=\""+ fluid_name3 + "\" ";
		xmlStr			+= " FLUID_NAME4=\""+ fluid_name4 + "\" ";
		xmlStr			+= " FLUID_NAME5=\""+ fluid_name5 + "\" ";
		xmlStr			+= " FLUID_NAME6=\""+ fluid_name6 + "\" ";
		xmlStr			+= " INF_RATE1=\""+ inf_prd + "\" ";
		xmlStr			+= " INF_RATE2=\""+ inf_prd2 + "\" ";
		xmlStr			+= " INF_RATE3=\""+ inf_prd3 + "\" ";
		xmlStr			+= " INF_RATE4=\""+ inf_prd4 + "\" ";
		xmlStr			+= " INF_RATE5=\""+ inf_prd5 + "\" ";
		xmlStr			+= " INF_RATE6=\""+ inf_prd6 + "\" ";
		xmlStr			+= " INFUSION_PERIOD_VALUE1=\""+ tot_inf_prd + "\" ";
		xmlStr			+= " INFUSION_PERIOD_VALUE2=\""+ tot_inf_prd2 + "\" ";
		xmlStr			+= " INFUSION_PERIOD_VALUE3=\""+ tot_inf_prd3 + "\" ";
		xmlStr			+= " INFUSION_PERIOD_VALUE4=\""+ tot_inf_prd4 + "\" ";
		xmlStr			+= " INFUSION_PERIOD_VALUE5=\""+ tot_inf_prd5 + "\" ";
		xmlStr			+= " INFUSION_PERIOD_VALUE6=\""+ tot_inf_prd6 + "\" ";
		xmlStr			+= " START_DATE1=\""+ start_date + "\" ";
		xmlStr			+= " START_DATE2=\""+ start_date2 + "\" ";
		xmlStr			+= " START_DATE3=\""+ start_date3 + "\" ";
		xmlStr			+= " START_DATE4=\""+ start_date4 + "\" ";
		xmlStr			+= " START_DATE5=\""+ start_date5 + "\" ";
		xmlStr			+= " START_DATE6=\""+ start_date6 + "\" ";
		xmlStr			+= " END_DATE1=\""+ end_date + "\" ";
		xmlStr			+= " END_DATE2=\""+ end_date2 + "\" ";
		xmlStr			+= " END_DATE3=\""+ end_date3 + "\" ";
		xmlStr			+= " END_DATE4=\""+ end_date4 + "\" ";
		xmlStr			+= " END_DATE5=\""+ end_date5 + "\" ";
		xmlStr			+= " END_DATE6=\""+ end_date6 + "\" ";
		xmlStr			+= " volume1=\""+ volume1 + "\" ";
		xmlStr			+= " volume2=\""+ volume2 + "\" ";
		xmlStr			+= " volume3=\""+ volume3 + "\" ";
		xmlStr			+= " volume4=\""+ volume4 + "\" ";
		xmlStr			+= " volume5=\""+ volume5 + "\" ";
		xmlStr			+= " volume6=\""+ volume6 + "\" ";
		xmlStr			+= " DURATION1=\""+ duration1 + "\" ";
		xmlStr			+= " DURATION2=\""+ duration2 + "\" ";
		xmlStr			+= " DURATION3=\""+ duration3 + "\" ";
		xmlStr			+= " DURATION4=\""+ duration4 + "\" ";
		xmlStr			+= " DURATION5=\""+ duration5 + "\" ";
		xmlStr			+= " DURATION6=\""+ duration6 + "\" ";
		xmlStr			+= " SELECT1=\""+ SELECT1 + "\" ";
		xmlStr			+= " SELECT2=\""+ SELECT2 + "\" ";
		xmlStr			+= " SELECT3=\""+ SELECT3 + "\" ";
		xmlStr			+= " SELECT4=\""+ SELECT4 + "\" ";
		xmlStr			+= " SELECT5=\""+ SELECT5 + "\" ";
		xmlStr			+= " SELECT6=\""+ SELECT6 + "\" ";
		xmlStr			+= " inf_rate_uom1=\""+ inf_rate_uom1 + "\" ";
		xmlStr			+= " inf_rate_uom2=\""+ inf_rate_uom2 + "\" ";
		xmlStr			+= " inf_rate_uom3=\""+ inf_rate_uom3 + "\" ";
		xmlStr			+= " inf_rate_uom4=\""+ inf_rate_uom4 + "\" ";
		xmlStr			+= " inf_rate_uom5=\""+ inf_rate_uom5 + "\" ";
		xmlStr			+= " inf_rate_uom6=\""+ inf_rate_uom6 + "\" ";
		xmlStr			+= " mfr_yn1=\""+ mfr_yn1 + "\" ";
		xmlStr			+= " mfr_yn2=\""+ mfr_yn2 + "\" ";
		xmlStr			+= " mfr_yn3=\""+ mfr_yn3 + "\" ";
		xmlStr			+= " mfr_yn4=\""+ mfr_yn4 + "\" ";
		xmlStr			+= " mfr_yn5=\""+ mfr_yn5 + "\" ";
		xmlStr			+= " mfr_yn6=\""+ mfr_yn6 + "\" ";
		xmlStr			+= " mfr_remarks1=\""+ mfr_remarks1 + "\" ";
		xmlStr			+= " mfr_remarks2=\""+ mfr_remarks2 + "\" ";
		xmlStr			+= " mfr_remarks3=\""+ mfr_remarks3 + "\" ";
		xmlStr			+= " mfr_remarks4=\""+ mfr_remarks4 + "\" ";
		xmlStr			+= " mfr_remarks5=\""+ mfr_remarks5 + "\" ";
		xmlStr			+= " mfr_remarks6=\""+ mfr_remarks6 + "\" ";*/
		xmlStr			+= " priority=\""+ priority + "\" ";	
		xmlStr			+= " height=\""+ height + "\" ";
		xmlStr			+= " height_uom=\""+ height_uom + "\" ";
		xmlStr			+= " weight=\""+ weight + "\" ";
		xmlStr			+= " weight_uom=\""+ weight_uom + "\" ";	
		xmlStr			+= " bsa=\""+ bsa + "\" ";	
		xmlStr			+= " allergic_yn=\""+ allergic_yn + "\" ";	
		xmlStr			+= " bmi=\""+ bmi + "\" ";			
		xmlStr			+= " buildMAR_yn=\""+ buildMAR_yn + "\" ";	 //added for SRR20056-SCF-7882 -29157		
		xmlStr			+=  " /></root>";

		var qryString			= bean_id+"&bean_name="+bean_name+"&mode="+mode+"&validate=AMEND_RELEASE_FLUIDS&patient_id="+patient_id+"&encounter_id="+encounter_id+"&date="+start_date1+"&locn_code="+locn_code+"&pract_name="+pract_name+"&patient_class="+patient_class+"&mode1="+mode1;
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

async function releaseRX1() {
	if(parent.f_ivdetails !=undefined){
		if (chkMandatoryFlds("Release")) {
			var frmobj	= parent.f_ivdetails.document.formIVPrescriptionAdditives;	
			//form the xmlString
			//xmlStr 
			// invoke the IVPrescriptionValidate.jsp with some identity like "RELEASE_FLUIDS"
			// use the logic wat we incorporated in setall method
			// set all the fluid details into the bean
			// invoke modify
			var headerForm = parent.parent.f_header.document.prescription_header_form;
			var bl_install_yn		= headerForm.bl_install_yn.value;
			var bl_disp_charge_dtl_in_rx_yn		= headerForm.bl_disp_charge_dtl_in_rx_yn.value;
			sys_date = headerForm.sys_date.value;
			if(bl_install_yn=="Y" && bl_disp_charge_dtl_in_rx_yn=="Y"){
				blError = false;
				getBLErrorDrugs();
				if(blError){
					return false;
				}
			}

			var patient_id		= frmobj.patient_id.value;
			var encounter_id	= frmobj.encounter_id.value;
			var date			= frmobj.START_DATE1.value;
			var pract_name		= frmobj.pract_name.value;
			
			var bean_id			= frmobj.bean_id.value;
			var bean_name		= frmobj.bean_name.value;
			var mode			= frmobj.mode.value;
			var locn_code		= frmobj.LOCN_CODE.value;
			var act_patient_class = frmobj.act_patient_class.value;//added for NMC-JD-CRF-0063 start
			var dflt_disp_locn_lbl = "";//end
			
			//var infuse_over_unit	= "H"; //commented for INO71514 
			var buildMAR_yn		= frmobj.buildMAR_yn.value;
			var item_type_site_app =  frmobj.item_type_site_app.value;//GHL-CRF-0549
			var SELECT2 = "N";
			var fladtForm	= parent.f_ivdetails.formIVPrescriptionAdditives;
			headerForm.buildMAR_yn.value=buildMAR_yn; //added for  MMS-QH-CRF-0080 [IN:038064]
			var iv_calc_infuse_by = fladtForm.iv_calc_infuse_by.value; //Added for SKR-CRF-0035 [IN:037727] 
			// Commented and moved the below variables inside loop - to reduce lines
			for(row=1;row<=6;row++){
				eval("var fluid_code"+row+"= frmobj.FLUID_CODE"+row+".value");
				eval("var inf_prd"+row+"= frmobj.INF_RATE"+row+".value");	
				eval("var start_date"+row+"= frmobj.START_DATE"+row+".value");
				eval("var end_date"+row+"= frmobj.END_DATE"+row+".value");
				eval("var tot_inf_prd"+row+"= frmobj.infusion_over_insert_value"+row+".value");
				eval("var volume"+row+"= frmobj.volume"+row+".value");
				eval("var mfr_yn"+row+"= frmobj.mfr_yn"+row+".value");
				eval("var mfr_remarks"+row+"= frmobj.mfr_remarks"+row+".value");
				if(iv_calc_infuse_by=='I'){//if block Added for SKR-CRF-0035 [IN:037727]  //Added for AAKH-SCF-0121 [IN:049680]
					eval("frmobj.DURATION"+row).value=eval("frmobj.infusion_over_insert_value"+row+".value");
				}
				eval("var duration"+row+"= frmobj.DURATION"+row+".value");
				eval("var inf_rate_uom"+row+"= frmobj.InfusionRateUnit"+row+".value");
				eval("var SELECT"+row+" = 'N'");
				eval("var disp_locn_code"+row+"= frmobj.disp_locn_code"+row+".value");	
				eval("var disp_locn_type"+row+"= frmobj.disp_locn_type"+row+".value");	
				eval("var per_facility_id"+row+"= frmobj.per_facility_id"+row+".value");	
				//GHL-CRF-0549 - start
				var allow_alternate = "N";
				if(eval("frmobj.allow_alternate_yn"+row)!=undefined){
					if(eval("frmobj.allow_alternate_yn"+row).checked==true)
						eval("frmobj.allow_alternate_yn"+row).value = "Y";
					eval("var allow_alternate"+row+"=frmobj.allow_alternate_yn"+row+".value");
				}
				eval("var infuse_over_unit"+row+"= frmobj.InfusionRateUnit"+row+".value");//INO71514
				if(act_patient_class=="OP"){//NMC-JD-CRF-0063 [15129]
					if(eval("frmobj.disp_locn_code"+row)!=undefined){
						dflt_disp_locn_lbl =eval("frmobj.disp_locn_code"+1).value ;
						if(dflt_disp_locn_lbl ==""){
							alert(getMessage("PH_MANDATORY", "PH"));
							return false;
						}
					}
				}//[15129] END
				//GHL-CRF-0549 - end
			}
			
			/*var fluid_code		= frmobj.FLUID_CODE1.value;
			var fluid_code2		= frmobj.FLUID_CODE2.value;
			var fluid_code3		= frmobj.FLUID_CODE3.value;
			var fluid_code4		= frmobj.FLUID_CODE4.value;
			var fluid_code5		= frmobj.FLUID_CODE5.value;
			var fluid_code6		= frmobj.FLUID_CODE6.value;
			/*var fluid_name		= frmobj.FLUID_NAME1.value;
			var fluid_name2		= frmobj.FLUID_NAME2.value;
			var fluid_name3		= frmobj.FLUID_NAME3.value;
			var fluid_name4		= frmobj.FLUID_NAME4.value;
			var fluid_name5		= frmobj.FLUID_NAME5.value;
			var fluid_name6		= frmobj.FLUID_NAME6.value;*/
			/*var inf_prd			= frmobj.INF_RATE1.value;	
			var inf_prd2		= frmobj.INF_RATE2.value;
			var inf_prd3		= frmobj.INF_RATE3.value;
			var inf_prd4		= frmobj.INF_RATE4.value;
			var inf_prd5		= frmobj.INF_RATE5.value;	
			var inf_prd6		= frmobj.INF_RATE6.value;	
			var start_date		= frmobj.START_DATE1.value;
			var end_date		= frmobj.END_DATE1.value;
			var start_date2		= frmobj.START_DATE2.value;
			var end_date2		= frmobj.END_DATE2.value;
			var start_date3		= frmobj.START_DATE3.value;
			var end_date3		= frmobj.END_DATE3.value;
			var start_date4		= frmobj.START_DATE4.value;
			var end_date4		= frmobj.END_DATE4.value;
			var start_date5		= frmobj.START_DATE5.value;
			var end_date5		= frmobj.END_DATE5.value;
			var start_date6	    = frmobj.START_DATE6.value;
			var end_date6		= frmobj.END_DATE6.value;
			var locn_code		= frmobj.LOCN_CODE.value;
			var tot_inf_prd		= frmobj.infusion_over_insert_value1.value;
			var tot_inf_prd2	= frmobj.infusion_over_insert_value2.value;
			var tot_inf_prd3	= frmobj.infusion_over_insert_value3.value;
			var tot_inf_prd4	= frmobj.infusion_over_insert_value4.value;
			var tot_inf_prd5	= frmobj.infusion_over_insert_value5.value;
			var tot_inf_prd6	= frmobj.infusion_over_insert_value6.value;
			var volume1			= frmobj.volume1.value;
			var volume2			= frmobj.volume2.value;
			var volume3			= frmobj.volume3.value;
			var volume4			= frmobj.volume4.value;
			var volume5			= frmobj.volume5.value;
			var volume6		    = frmobj.volume6.value;
			var mfr_yn1			= frmobj.mfr_yn1.value;
			var mfr_yn2			= frmobj.mfr_yn2.value;
			var mfr_yn3			= frmobj.mfr_yn3.value;
			var mfr_yn4			= frmobj.mfr_yn4.value;
			var mfr_yn5			= frmobj.mfr_yn5.value;
			var mfr_yn6		    = frmobj.mfr_yn6.value;
			var mfr_remarks1	= frmobj.mfr_remarks1.value;
			var mfr_remarks2	= frmobj.mfr_remarks2.value;
			var mfr_remarks3	= frmobj.mfr_remarks3.value;
			var mfr_remarks4	= frmobj.mfr_remarks4.value;
			var mfr_remarks5	= frmobj.mfr_remarks5.value;
			var mfr_remarks6    = frmobj.mfr_remarks6.value;
			var duration1		= frmobj.DURATION1.value;
			var duration2		= frmobj.DURATION2.value;
			var duration3		= frmobj.DURATION3.value;
			var duration4		= frmobj.DURATION4.value;
			var duration5		= frmobj.DURATION5.value;
			var duration6		= frmobj.DURATION6.value;
			var inf_rate_uom1		= frmobj.InfusionRateUnit1.value;
			var inf_rate_uom2		= frmobj.InfusionRateUnit2.value;
			var inf_rate_uom3		= frmobj.InfusionRateUnit3.value;
			var inf_rate_uom4		= frmobj.InfusionRateUnit4.value;
			var inf_rate_uom5		= frmobj.InfusionRateUnit5.value;
			var inf_rate_uom6		= frmobj.InfusionRateUnit6.value;
			var infuse_over_unit	= "H";
			var buildMAR_yn		= frmobj.buildMAR_yn.value;
			var SELECT1 = "N";
			var SELECT2 = "N";
			var SELECT3 = "N";
			var SELECT4 = "N";
			var SELECT5 = "N";
			var SELECT6 = "N";
			var fladtForm	= parent.f_ivdetails.formIVPrescriptionAdditives;
			headerForm.buildMAR_yn.value=buildMAR_yn; //added for  MMS-QH-CRF-0080 [IN:038064]*/
			for(row=1;row<=6;row++){
				if(eval("frmobj.active"+row).checked && eval("fladtForm.active"+row).style.visibility!= 'hidden'){
					if(eval("fladtForm.mfr_yn"+row).value != "Y" && !validateRate1(eval("fladtForm.INF_RATE"+row),eval("fladtForm.stock_value"+row),eval("fladtForm.infusion_over_insert_value"+row),eval("fladtForm.DURATION"+row),eval("fladtForm.InfusionRateUnit"+row),eval("fladtForm.INFUSION_PERIOD_VALUE"+row), iv_calc_infuse_by)){
						return false;
					}
					else{
						eval("SELECT"+row+"			= 'Y'"); 
					}
				}
			}
			/*
			if(frmobj.active1.checked && fladtForm.active1.style.visibility!= 'hidden'){

				if(fladtForm.mfr_yn1.value != "Y" && !validateRate1(fladtForm.INF_RATE1,fladtForm.stock_value1,fladtForm.infusion_over_insert_value1,fladtForm.DURATION1,fladtForm.InfusionRateUnit1,fladtForm.INFUSION_PERIOD_VALUE1)){

					return false;
				}
				else{
					SELECT1			= "Y"; 
				}
			}
			if(frmobj.active2.checked && fladtForm.active2.style.visibility!= 'hidden'){
				if(fladtForm.mfr_yn2.value != "Y" && !validateRate1(fladtForm.INF_RATE2,fladtForm.stock_value2,fladtForm.infusion_over_insert_value2,fladtForm.DURATION2,fladtForm.InfusionRateUnit2,fladtForm.INFUSION_PERIOD_VALUE2)){
					return false;
				}
				else{
					SELECT2			= "Y"; 
				}
			}
			if(frmobj.active3.checked && fladtForm.active3.style.visibility!= 'hidden'){
				 if(fladtForm.mfr_yn3.value != "Y" && !validateRate1(fladtForm.INF_RATE3,fladtForm.stock_value3,fladtForm.infusion_over_insert_value3,fladtForm.DURATION3,fladtForm.InfusionRateUnit3,fladtForm.INFUSION_PERIOD_VALUE3)){
					return false;
				}
				else{
					SELECT3			= "Y"; 
				}
			}
			if(frmobj.active4.checked && fladtForm.active4.style.visibility!= 'hidden'){
				if(fladtForm.mfr_yn4.value != "Y" && !validateRate1(fladtForm.INF_RATE4,fladtForm.stock_value4,fladtForm.infusion_over_insert_value4,fladtForm.DURATION4,fladtForm.InfusionRateUnit4,fladtForm.INFUSION_PERIOD_VALUE4)){
					return false;
				}
				else{
					SELECT4			= "Y"; 
				}
			}
			if(frmobj.active5.checked && fladtForm.active5.style.visibility!= 'hidden'){
				if(fladtForm.mfr_yn5.value != "Y" && !validateRate1(fladtForm.INF_RATE5,fladtForm.stock_value5,fladtForm.infusion_over_insert_value5,fladtForm.DURATION5,fladtForm.InfusionRateUnit5,fladtForm.INFUSION_PERIOD_VALUE5)){
					return false;
				}
				else{
					SELECT5			= "Y"; 
				}
			}
			if(frmobj.active6.checked && fladtForm.active6.style.visibility!= 'hidden'){
				if(fladtForm.mfr_yn6.value != "Y" && !validateRate1(fladtForm.INF_RATE6,fladtForm.stock_value6,fladtForm.infusion_over_insert_value6,fladtForm.DURATION6,fladtForm.InfusionRateUnit6,fladtForm.INFUSION_PERIOD_VALUE6)){
					return false;
				}
				else{
					SELECT6			= "Y"; 
				}
			}
			*/
			if(SELECT1=='N' && SELECT2 =='N' && SELECT3=='N' && SELECT4=='N' && SELECT5=='N' && SELECT6=='N'){
				alert(getMessage("ATLEAST_ONE_SELECTED",'Common'));
				return false;
			}
			var priority		= parent.parent.f_header.prescription_header_form.priority.value;
			var height			= parent.parent.f_header.prescription_header_form.height.value;
			var height_uom		= parent.parent.f_header.prescription_header_form.height_unit.value;
			var weight			= parent.parent.f_header.prescription_header_form.weight.value;
			var weight_uom		= parent.parent.f_header.prescription_header_form.weight_unit.value;
			var bsa				= parent.parent.f_header.prescription_header_form.bsa.value;
			var bmi				= parent.parent.f_header.prescription_header_form.bmi.value;
			var patient_class	= parent.parent.f_header.prescription_header_form.patient_class.value;
			var act_patient_class	= parent.parent.f_header.prescription_header_form.act_patient_class.value;
			// RUT-CRF-0062 Added to insert into OR_ORDER table	
			var take_home_medication="";
			if(parent.parent.f_header.prescription_header_form.take_home_medication.checked==true)
				take_home_medication="D";
			
			var allergic_yn ="N";
		/*	if( parent.parent.f_header.prescription_header_form.allergic_yn(0).checked) {
					allergic_yn	=	"Y";	
			} else {
					allergic_yn	=	"N";	
			}*/
			 allergic_yn	= parent.parent.f_header.prescription_header_form.allergic_yn.value;
			var xmlStr		= "<root><SEARCH ";
			
			for(row=1;row<=6;row++){
				xmlStr			+= " FLUID_CODE"+row+"=\""+eval("fluid_code"+row) + "\" ";	
				xmlStr			+= " INF_RATE"+row+"=\""+eval("inf_prd"+row) + "\" ";
				xmlStr			+= " INFUSION_PERIOD_VALUE"+row+"=\""+eval("tot_inf_prd"+row) + "\" ";
				xmlStr			+= " inf_rate_uom"+row+"=\""+eval("inf_rate_uom"+row) + "\" ";
				xmlStr			+= " START_DATE"+row+"=\""+eval("start_date"+row) + "\" ";
				xmlStr			+= " END_DATE"+row+"=\""+eval("end_date"+row) + "\" ";
				xmlStr			+= " volume"+row+"=\""+eval("volume"+row) + "\" ";
				xmlStr			+= " mfr_yn"+row+"=\""+eval("mfr_yn"+row) + "\" ";
				xmlStr			+= " DURATION"+row+"=\""+eval("duration"+row) + "\" ";
				xmlStr			+= " SELECT"+row+"=\""+eval("SELECT"+row) + "\" ";
				xmlStr			+= " mfr_remarks"+row+"=\""+eval("mfr_remarks"+row) + "\" ";
				xmlStr			+= " DISP_LOCN_CODE"+row+"=\""+ eval("disp_locn_code"+row) + "\" "; 
				xmlStr			+= " DISP_LOCN_TYPE"+row+"=\""+ eval("disp_locn_type"+row) + "\" ";
				xmlStr			+= " PER_FACILITY_ID"+row+"=\""+ eval("per_facility_id"+row) + "\" ";
				xmlStr          += " INFUSE_OVER_UNIT"+row+"=\""+ eval("inf_rate_uom"+row) + "\" "; //INO71514
				if(item_type_site_app=="true") //GHL-CRF-0549
				xmlStr			+= " allow_alternate"+row+"=\""+ eval("allow_alternate"+row) + "\" ";
				
			}
			
			/*xmlStr			+= " FLUID_CODE1=\""+ fluid_code1 + "\" ";
			xmlStr			+= " FLUID_CODE2=\""+ fluid_code2 + "\" ";
			xmlStr			+= " FLUID_CODE3=\""+ fluid_code3 + "\" ";
			xmlStr			+= " FLUID_CODE4=\""+ fluid_code4 + "\" ";
			xmlStr			+= " FLUID_CODE5=\""+ fluid_code5 + "\" ";
			xmlStr			+= " FLUID_CODE6=\""+ fluid_code6 + "\" ";
			/*xmlStr			+= " FLUID_NAME1=\""+ fluid_name + "\" ";
			xmlStr			+= " FLUID_NAME2=\""+ fluid_name2 + "\" ";
			xmlStr			+= " FLUID_NAME3=\""+ fluid_name3 + "\" ";
			xmlStr			+= " FLUID_NAME4=\""+ fluid_name4 + "\" ";
			xmlStr			+= " FLUID_NAME5=\""+ fluid_name5 + "\" ";
			xmlStr			+= " FLUID_NAME6=\""+ fluid_name6 + "\" ";*/
			/*xmlStr			+= " INF_RATE1=\""+ inf_prd1 + "\" ";
			xmlStr			+= " INF_RATE2=\""+ inf_prd2 + "\" ";
			xmlStr			+= " INF_RATE3=\""+ inf_prd3 + "\" ";
			xmlStr			+= " INF_RATE4=\""+ inf_prd4 + "\" ";
			xmlStr			+= " INF_RATE5=\""+ inf_prd5 + "\" ";
			xmlStr			+= " INF_RATE6=\""+ inf_prd6 + "\" ";
			xmlStr			+= " INFUSION_PERIOD_VALUE1=\""+ tot_inf_prd1 + "\" ";
			xmlStr			+= " INFUSION_PERIOD_VALUE2=\""+ tot_inf_prd2 + "\" ";
			xmlStr			+= " INFUSION_PERIOD_VALUE3=\""+ tot_inf_prd3 + "\" ";
			xmlStr			+= " INFUSION_PERIOD_VALUE4=\""+ tot_inf_prd4 + "\" ";
			xmlStr			+= " INFUSION_PERIOD_VALUE5=\""+ tot_inf_prd5 + "\" ";
			xmlStr			+= " INFUSION_PERIOD_VALUE6=\""+ tot_inf_prd6 + "\" ";
			
			xmlStr			+= " inf_rate_uom1=\""+ inf_rate_uom1 + "\" ";
			xmlStr			+= " inf_rate_uom2=\""+ inf_rate_uom2 + "\" ";
			xmlStr			+= " inf_rate_uom3=\""+ inf_rate_uom3 + "\" ";
			xmlStr			+= " inf_rate_uom4=\""+ inf_rate_uom4 + "\" ";
			xmlStr			+= " inf_rate_uom5=\""+ inf_rate_uom5 + "\" ";
			xmlStr			+= " inf_rate_uom6=\""+ inf_rate_uom6 + "\" ";
			xmlStr			+= " START_DATE1=\""+ start_date1 + "\" ";
			xmlStr			+= " START_DATE2=\""+ start_date2 + "\" ";
			xmlStr			+= " START_DATE3=\""+ start_date3 + "\" ";
			xmlStr			+= " START_DATE4=\""+ start_date4 + "\" ";
			xmlStr			+= " START_DATE5=\""+ start_date5 + "\" ";
			xmlStr			+= " START_DATE6=\""+ start_date6 + "\" ";
			xmlStr			+= " END_DATE1=\""+ end_date1 + "\" ";
			xmlStr			+= " END_DATE2=\""+ end_date2 + "\" ";
			xmlStr			+= " END_DATE3=\""+ end_date3 + "\" ";
			xmlStr			+= " END_DATE4=\""+ end_date4 + "\" ";
			xmlStr			+= " END_DATE5=\""+ end_date5 + "\" ";
			xmlStr			+= " END_DATE6=\""+ end_date6 + "\" ";
			xmlStr			+= " volume1=\""+ volume1 + "\" ";
			xmlStr			+= " volume2=\""+ volume2 + "\" ";
			xmlStr			+= " volume3=\""+ volume3 + "\" ";
			xmlStr			+= " volume4=\""+ volume4 + "\" ";
			xmlStr			+= " volume5=\""+ volume5 + "\" ";
			xmlStr			+= " volume6=\""+ volume6 + "\" ";
			xmlStr			+= " mfr_yn1=\""+ mfr_yn1 + "\" ";
			xmlStr			+= " mfr_yn2=\""+ mfr_yn2 + "\" ";
			xmlStr			+= " mfr_yn3=\""+ mfr_yn3 + "\" ";
			xmlStr			+= " mfr_yn4=\""+ mfr_yn4 + "\" ";
			xmlStr			+= " mfr_yn5=\""+ mfr_yn5 + "\" ";
			xmlStr			+= " mfr_yn6=\""+ mfr_yn6 + "\" ";
			xmlStr			+= " DURATION1=\""+ duration1 + "\" ";
			xmlStr			+= " DURATION2=\""+ duration2 + "\" ";
			xmlStr			+= " DURATION3=\""+ duration3 + "\" ";
			xmlStr			+= " DURATION4=\""+ duration4 + "\" ";
			xmlStr			+= " DURATION5=\""+ duration5 + "\" ";
			xmlStr			+= " DURATION6=\""+ duration6 + "\" ";
			xmlStr			+= " SELECT1=\""+ SELECT1 + "\" ";
			xmlStr			+= " SELECT2=\""+ SELECT2 + "\" ";
			xmlStr			+= " SELECT3=\""+ SELECT3 + "\" ";
			xmlStr			+= " SELECT4=\""+ SELECT4 + "\" ";
			xmlStr			+= " SELECT5=\""+ SELECT5 + "\" ";
			xmlStr			+= " SELECT6=\""+ SELECT6 + "\" ";
			xmlStr			+= " mfr_remarks1=\""+ mfr_remarks1 + "\" ";
			xmlStr			+= " mfr_remarks2=\""+ mfr_remarks2 + "\" ";
			xmlStr			+= " mfr_remarks3=\""+ mfr_remarks3 + "\" ";
			xmlStr			+= " mfr_remarks4=\""+ mfr_remarks4 + "\" ";
			xmlStr			+= " mfr_remarks5=\""+ mfr_remarks5 + "\" ";
			xmlStr			+= " mfr_remarks6=\""+ mfr_remarks6 + "\" ";*/
			//xmlStr			+= " INFUSE_OVER_UNIT=\""+ infuse_over_unit + "\" ";//Commented for INO71514
			xmlStr			+= " priority=\""+ priority + "\" ";	
			xmlStr			+= " height=\""+ height + "\" ";
			xmlStr			+= " height_uom=\""+ height_uom + "\" ";
			xmlStr			+= " weight=\""+ weight + "\" ";
			xmlStr			+= " weight_uom=\""+ weight_uom + "\" ";	
			xmlStr			+= " bsa=\""+ bsa + "\" ";	
			xmlStr			+= " allergic_yn=\""+ allergic_yn + "\" ";	
			xmlStr			+= " bmi=\""+ bmi + "\" ";			
			xmlStr			+= " buildMAR_yn=\""+ buildMAR_yn + "\" ";			
			xmlStr			+= " take_home_medication=\""+ take_home_medication + "\" ";   //RUT-CRF-0062 Added to update in the OR_ORDER Table
			xmlStr			+= " ROOM_NUM=\""+ parent.parent.f_header.prescription_header_form.room_num.value + "\" ";  //Added for MMS-QH-CRF-0080 [IN:038064] 
			xmlStr			+= " BED_NUM=\""+ parent.parent.f_header.prescription_header_form.bed_num.value + "\" ";    //Added for MMS-QH-CRF-0080 [IN:038064] 
			xmlStr			+=  " /></root>";
		
		// sys_date added coz order date was going null in or_order table. sri:14th jan 2011

			var qryString			= bean_id+"&bean_name="+bean_name+"&mode="+mode+"&validate=RELEASE_FLUIDS&patient_id="+patient_id+"&encounter_id="+encounter_id+"&date="+start_date1+"&locn_code="+locn_code+"&pract_name="+pract_name+"&actual_patient_class="+act_patient_class+"&patient_class="+patient_class+"&sys_date="+sys_date;
				
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
				retVal 				= await window.showModalDialog("../../ePH/jsp/IVPrescriptionStockDetails.jsp?bean_id="+bean_id+"&bean_name="+bean_name,arguments,features);
			}
		}
	}
	else {
		var frmobj	= parent.f_detail.formIVPrescriptionAdditives;	
		var patient_id		= frmobj.patient_id.value;
		var encounter_id	= frmobj.encounter_id.value;
		var date			= frmobj.START_DATE1.value;
		var pract_name		= frmobj.pract_name.value;
		
		var bean_id			= frmobj.bean_id.value;
		var bean_name		= frmobj.bean_name.value;
		var mode			= frmobj.mode.value;
		var locn_code		= frmobj.LOCN_CODE.value;
		var iv_calc_infuse_by = frmobj.iv_calc_infuse_by.value //Added for SKR-CRF-0035 [IN:037727] 
		// Commented and moved the below variables inside loop - to reduce lines
		for(row=1;row<=4;row++){
			eval("var fluid_code"+row+"= frmobj.FLUID_CODE"+row+".value");
			eval("var inf_prd"+row+"= frmobj.INF_RATE"+row+".value");	
			eval("var start_date"+row+"= frmobj.START_DATE"+row+".value");
			eval("var end_date"+row+"= frmobj.END_DATE"+row+".value");
			eval("var tot_inf_prd"+row+"= frmobj.infusion_over_insert_value"+row+".value");
			eval("var volume"+row+"= frmobj.volume"+row+".value");
			eval("var duration"+row+"= frmobj.DURATION"+row+".value");
			eval("var inf_rate_uom"+row+"= frmobj.InfusionRateUnit"+row+".value");
			eval("var infuse_over_unit"+row+"= frmobj.InfusionRateUnit"+row+".value");//INO71514
			eval("var SELECT"+row+"= 'N'");
			}
		var tot_inf_prd5	= frmobj.infusion_over_insert_value5.value;
		var tot_inf_prd6	= frmobj.infusion_over_insert_value6.value;
		
		/*var fluid_code		= frmobj.FLUID_CODE1.value;
		var fluid_code2		= frmobj.FLUID_CODE2.value;
		var fluid_code3		= frmobj.FLUID_CODE3.value;
		var fluid_code4		= frmobj.FLUID_CODE4.value;
		/*var fluid_name		= frmobj.FLUID_NAME1.value;
		var fluid_name2		= frmobj.FLUID_NAME2.value;
		var fluid_name3		= frmobj.FLUID_NAME3.value;
		var fluid_name4		= frmobj.FLUID_NAME4.value;*/
		/*var inf_prd			= frmobj.INF_RATE1.value;	
		var inf_prd2		= frmobj.INF_RATE2.value;
		var inf_prd3		= frmobj.INF_RATE3.value;
		var inf_prd4		= frmobj.INF_RATE4.value;		
		var start_date		= frmobj.START_DATE1.value;
		var end_date		= frmobj.END_DATE1.value;
		var start_date2		= frmobj.START_DATE2.value;
		var end_date2		= frmobj.END_DATE2.value;
		var start_date3		= frmobj.START_DATE3.value;
		var end_date3		= frmobj.END_DATE3.value;
		var start_date4		= frmobj.START_DATE4.value;
		var end_date4		= frmobj.END_DATE4.value;
		var locn_code		= frmobj.LOCN_CODE.value;
		var tot_inf_prd		= frmobj.infusion_over_insert_value1.value;
		var tot_inf_prd2	= frmobj.infusion_over_insert_value2.value;
		var tot_inf_prd3	= frmobj.infusion_over_insert_value3.value;
		var tot_inf_prd4	= frmobj.infusion_over_insert_value4.value;
		var tot_inf_prd5	= frmobj.infusion_over_insert_value5.value;
		var tot_inf_prd6	= frmobj.infusion_over_insert_value6.value;
		var volume1			= frmobj.volume1.value;
		var volume2			= frmobj.volume2.value;
		var volume3			= frmobj.volume3.value;
		var volume4			= frmobj.volume4.value;
		var duration1		= frmobj.DURATION1.value;
		var duration2		= frmobj.DURATION2.value;
		var duration3		= frmobj.DURATION3.value;
		var duration4		= frmobj.DURATION4.value;
		var inf_rate_uom1		= frmobj.InfusionRateUnit1.value;
		var inf_rate_uom2		= frmobj.InfusionRateUnit2.value;
		var inf_rate_uom3		= frmobj.InfusionRateUnit3.value;
		var inf_rate_uom4		= frmobj.InfusionRateUnit4.value;*/
		var buildMAR_yn			= frmobj.buildMAR_yn.value;  //RUT-CRF-0062
		parent.parent.f_header.prescription_header_form.buildMAR_yn.value=buildMAR_yn; //added for  MMS-QH-CRF-0080 [IN:038064]
		var take_home_medication="";
		if(parent.parent.f_header.prescription_header_form.take_home_medication.checked==true)
			take_home_medication="D";

		xmlStr			+= " inf_rate_uom1=\""+ inf_rate_uom1 + "\" ";
		xmlStr			+= " inf_rate_uom2=\""+ inf_rate_uom2 + "\" ";
		xmlStr			+= " inf_rate_uom3=\""+ inf_rate_uom3 + "\" ";
		xmlStr			+= " inf_rate_uom4=\""+ inf_rate_uom4 + "\" ";
		
		/*var SELECT1 = "N";
		var SELECT2 = "N";
		var SELECT3 = "N";
		var SELECT4 = "N";*/
		var fladtForm	= parent.f_ivdetails.formIVPrescriptionAdditives;
		if(frmobj.active1.checked && fladtForm.active1.style.visibility!= 'hidden'){
			if(fladtForm.mfr_yn1.value != "Y" && !validateRate1(fladtForm.INF_RATE1,fladtForm.stock_value1,fladtForm.infusion_over_insert_value1,fladtForm.DURATION1,fladtForm.InfusionRateUnit1,fladtForm.INFUSION_PERIOD_VALUE1, iv_calc_infuse_by)){
				return false;
			}
			else
				SELECT1			= "Y";
		 }
		if(frmobj.active2.checked)
			SELECT2			= "Y"; 
		if(frmobj.active3.checked)
			SELECT3			= "Y"; 
		if(frmobj.active4.checked)
			SELECT4			= "Y"; 
		 	
		var priority		= parent.f_header.prescription_header_form.priority.value;
		var height			= parent.f_header.prescription_header_form.height.value;
		var height_uom		= parent.f_header.prescription_header_form.height_unit.value;
		var weight			= parent.f_header.prescription_header_form.weight.value;
		var weight_uom		= parent.f_header.prescription_header_form.weight_unit.value;
        var bsa				= parent.f_header.prescription_header_form.bsa.value;
		var bmi				= parent.f_header.prescription_header_form.bmi.value;
		var patient_class	= parent.parent.f_header.prescription_header_form.patient_class.value;
		var act_patient_class	= parent.parent.f_header.prescription_header_form.act_patient_class.value;

		var allergic_yn ="N";

		if(parent.f_header.prescription_header_form.allergic_yn.checked) {
				allergic_yn	=	"Y";	
		} else {
				allergic_yn	=	"N";	
		}


		var xmlStr		= "<root><SEARCH ";
		
		for(row=1;row<=6;+row++){
		xmlStr			+= " FLUID_CODE"+row+"=\""+ eval("fluid_code"+row)+ "\" ";
		xmlStr			+= " INF_RATE"+row+"=\""+ eval("inf_prd"+row) + "\" ";
		xmlStr			+= " INFUSION_PERIOD_VALUE"+row+"=\""+eval(" tot_inf_prd"+row) + "\" ";
		xmlStr			+= " START_DATE"+row+"=\""+ eval("start_date"+row) + "\" ";
		xmlStr			+= " END_DATE"+row+"=\""+ eval("end_date"+row) + "\" ";
		xmlStr			+= " volume"+row+"=\""+ eval("volume"+row) + "\" ";
		xmlStr			+= " DURATION"+row+"=\""+ eval("duration"+row) + "\" ";
		xmlStr			+= " SELECT"+row+"=\""+ eval("SELECT"+row) + "\" ";
		}
		
		/*xmlStr			+= " FLUID_CODE1=\""+ fluid_code1 + "\" ";
		xmlStr			+= " FLUID_CODE2=\""+ fluid_code2 + "\" ";
		xmlStr			+= " FLUID_CODE3=\""+ fluid_code3 + "\" ";
		xmlStr			+= " FLUID_CODE4=\""+ fluid_code4 + "\" ";
		xmlStr			+= " FLUID_CODE5=\""+ fluid_code5 + "\" ";
		xmlStr			+= " FLUID_CODE6=\""+ fluid_code6 + "\" ";
		/*xmlStr			+= " FLUID_NAME1=\""+ fluid_name + "\" ";
		xmlStr			+= " FLUID_NAME2=\""+ fluid_name2 + "\" ";
		xmlStr			+= " FLUID_NAME3=\""+ fluid_name3 + "\" ";
		xmlStr			+= " FLUID_NAME4=\""+ fluid_name4 + "\" ";
		xmlStr			+= " FLUID_NAME5=\""+ fluid_name5 + "\" ";
		xmlStr			+= " FLUID_NAME6=\""+ fluid_name6 + "\" ";*/
		/*xmlStr			+= " INF_RATE1=\""+ inf_prd1 + "\" ";
		xmlStr			+= " INF_RATE2=\""+ inf_prd2 + "\" ";
		xmlStr			+= " INF_RATE3=\""+ inf_prd3 + "\" ";
		xmlStr			+= " INF_RATE4=\""+ inf_prd4 + "\" ";
		xmlStr			+= " INF_RATE5=\""+ inf_prd5 + "\" ";
		xmlStr			+= " INF_RATE6=\""+ inf_prd6 + "\" ";
		xmlStr			+= " INFUSION_PERIOD_VALUE1=\""+ tot_inf_prd1 + "\" ";
		xmlStr			+= " INFUSION_PERIOD_VALUE2=\""+ tot_inf_prd2 + "\" ";
		xmlStr			+= " INFUSION_PERIOD_VALUE3=\""+ tot_inf_prd3 + "\" ";
		xmlStr			+= " INFUSION_PERIOD_VALUE4=\""+ tot_inf_prd4 + "\" ";
		xmlStr			+= " INFUSION_PERIOD_VALUE5=\""+ tot_inf_prd5 + "\" ";
		xmlStr			+= " INFUSION_PERIOD_VALUE6=\""+ tot_inf_prd6 + "\" ";
		xmlStr			+= " START_DATE1=\""+ start_date1 + "\" ";
		xmlStr			+= " START_DATE2=\""+ start_date2 + "\" ";
		xmlStr			+= " START_DATE3=\""+ start_date3 + "\" ";
		xmlStr			+= " START_DATE4=\""+ start_date4 + "\" ";
		xmlStr			+= " START_DATE5=\""+ start_date5 + "\" ";
		xmlStr			+= " START_DATE6=\""+ start_date6 + "\" ";
		xmlStr			+= " END_DATE1=\""+ end_date1 + "\" ";
		xmlStr			+= " END_DATE2=\""+ end_date2 + "\" ";
		xmlStr			+= " END_DATE3=\""+ end_date3 + "\" ";
		xmlStr			+= " END_DATE4=\""+ end_date4 + "\" ";
		xmlStr			+= " END_DATE5=\""+ end_date5 + "\" ";
		xmlStr			+= " END_DATE6=\""+ end_date6 + "\" ";
		xmlStr			+= " volume1=\""+ volume1 + "\" ";
		xmlStr			+= " volume2=\""+ volume2 + "\" ";
		xmlStr			+= " volume3=\""+ volume3 + "\" ";
		xmlStr			+= " volume4=\""+ volume4 + "\" ";
		xmlStr			+= " volume5=\""+ volume5 + "\" ";
		xmlStr			+= " volume6=\""+ volume6 + "\" ";
		xmlStr			+= " DURATION1=\""+ duration1 + "\" ";
		xmlStr			+= " DURATION2=\""+ duration2 + "\" ";
		xmlStr			+= " DURATION3=\""+ duration3 + "\" ";
		xmlStr			+= " DURATION4=\""+ duration4 + "\" ";
		xmlStr			+= " DURATION5=\""+ duration5 + "\" ";
		xmlStr			+= " DURATION6=\""+ duration6 + "\" ";
		xmlStr			+= " SELECT1=\""+ SELECT1 + "\" ";
		xmlStr			+= " SELECT2=\""+ SELECT2 + "\" ";
		xmlStr			+= " SELECT3=\""+ SELECT3 + "\" ";
		xmlStr			+= " SELECT4=\""+ SELECT4 + "\" ";
		xmlStr			+= " SELECT5=\""+ SELECT5 + "\" ";
		xmlStr			+= " SELECT6=\""+ SELECT6 + "\" ";*/
		xmlStr			+= " priority=\""+ priority + "\" ";	
		xmlStr			+= " height=\""+ height + "\" ";
		xmlStr			+= " height_uom=\""+ height_uom + "\" ";
		xmlStr			+= " weight=\""+ weight + "\" ";
		xmlStr			+= " weight_uom=\""+ weight_uom + "\" ";	
		xmlStr			+= " bsa=\""+ bsa + "\" ";	
		xmlStr			+= " allergic_yn=\""+ allergic_yn + "\" ";	
		xmlStr			+= " bmi=\""+ bmi + "\" ";			
		xmlStr			+= " buildMAR_yn=\""+ buildMAR_yn + "\" ";  //CRF-0062
		xmlStr			+= " take_home_medication=\""+ take_home_medication + "\" ";   //RUT-CRF-0062 
		xmlStr			+=  " /></root>";
					
		var qryString			= bean_id+"&bean_name="+bean_name+"&mode="+mode+"&validate=RELEASE_FLUIDS&patient_id="+patient_id+"&encounter_id="+encounter_id+"&date="+start_date1+"&locn_code="+locn_code+"&pract_name="+pract_name+"&actual_patient_class="+act_patient_class+"&patient_class="+patient_class;
		//alert(qryString);
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

async function displaySchedule(obj) {
	var formObj		= document.formIVPrescriptionAdminDetail;
	var bean_id		= formObj.BEAN_ID.value;
	var bean_name	= formObj.BEAN_NAME.value;
	var freq_code	= formObj.FREQUENCY.value;
	var drug_code	= parent.f_ivfluid.document.formIVPrescriptionFluidDetail.FLUID_CODE.value;

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

/*
	var inf_val			= parseInt(formObj.INFUSION_VALUE.value);
	if (formObj.INFUSION_UOM.value == "H")
		inf_val = 60*parseInt(inf_val);

	var split_qty		= parseInt(inf_val)*parseInt(parent.f_ivfluid.document.formIVPrescriptionFluidDetail.FLOW_VALUE.value);
*/
	var split_qty		= parent.f_ivfluid.document.formIVPrescriptionFluidDetail.STOCK_VALUE.value;
	var qty_reqd_yn		= "N";
	var uom_desc		= parent.f_ivfluid.document.formIVPrescriptionFluidDetail.EQVL_UOM_CODE.value;
		uom_desc=encodeURIComponent(uom_desc,"UTF-8");
	var chk_max			= "N";
	var chk_unit		= "N";

	if(max_qty != "0") {
		chk_max = "Y";
	}

	if(unit_qty != "0") {
		chk_unit = "Y";
	}
	uom_desc="MLL";
	if(uom_desc !="" && split_qty != "") {
		var dialogTop		= "260";
		var dialogHeight	= "14";
		var dialogWidth		= "28";
		var features		= 'Width:' + dialogWidth +'; dialogHeight:' + dialogHeight + '; dialogWidth:' + dialogWidth +'; dialogTop:'+dialogTop +'; scroll=no; status=no';
		var arguments		= "";
		var retVal 			=await window.showModalDialog("../../eOR/jsp/ScheduleFrequency.jsp?mode=1&bean_id="+bean_id+"&uom_desc="+uom_desc+"&bean_name="+bean_name+"&chk_max="+chk_max+"&chk_unit="+chk_unit+"&max_qty="+max_qty+"&split_dose_yn="+split_dose_yn+"&split_qty="+split_qty+"&qty_reqd_yn="+qty_reqd_yn+"&unit_qty="+unit_qty+"&code="+drug_code+"&row_value="+row_value+"&facility_id="+facility_id+"&freq_code="+freq_code+"&module_id=PH",arguments,features);

		if(retVal!=null) {
			
			//formObj.SCHED_MEDN.checked	= true;
			//formObj.SCHED_MEDN.value	= "Y";
			formObj.SCHED_MEDN_YN.value = "Y";
			//formObj.FREQUENCY.disabled	= true;
		}
		else {
			//document.getElementById("SCHED_LINK").innerText	= "Scheduled Medication";
			//formObj.SCHED_MEDN.checked			= false;
			//formObj.SCHED_MEDN.value			= "N";
			formObj.SCHED_MEDN_YN.value			= "N";
		}
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

	if(parent.f_ivdetails !=undefined){
		var frmObj			= parent.f_ivselect.document.formIVPrescriptionOptions;
		//alert(frmObj);
		var bean_id			= frmObj.bean_id.value;
		var bean_name		= frmObj.bean_name.value;
		var patient_class	= frmObj.patient_class.value;
		var locn_code		= frmObj.locn_code.value;
		var hdrForm		= "";
		var order_set_code  = "";
		
		if(parent.parent.f_header!=undefined){
			hdrForm = parent.parent.f_header.prescription_header_form;
			order_set_code  = hdrForm.order_set_code.value;		
			patient_class = hdrForm.patient_class.value;
		}
		
		var narcotic_aprvl_form_req_yn=hdrForm.narcotic_aprvl_form_req_yn.value;
		var print_narcotic_form_by_default=hdrForm.print_narcotic_form_by_default.value;
		var print_mar_label_yn = hdrForm.print_mar_label_yn.value; //added for MMS-QH-CRF-0080 [IN:038064]
		var buildMAR_yn = hdrForm.buildMAR_yn.value; //added for MMS-QH-CRF-0080 [IN:038064]
		var retVal = new Array();//code added for IN49320

		if(narcotic_yn == "N"){ 
			narcotic_aprvl_form_req_yn = "";
			print_narcotic_form_by_default="";
		}

		if(top.content != null)
			top.content.messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num="+message;
		else{
			for(i=0;i<message.length;i++){
				if(message.charAt(i) == ".") break;
			}
			alert(message.substring(0,i+3));
			//alert(message);
		}

		if(patient_class=='OP' || patient_class=='EM'){
			var xmlStr 			="<root><SEARCH /></root>";
			//commented by Anbarasi 
			var xmlDoc = ""; 
			var xmlHttp = new XMLHttpRequest();
		//	var xmlDoc			= new ActiveXObject( "Microsoft.XMLDom" ) ;
		//	var xmlHttp			= new ActiveXObject( "Microsoft.XMLHTTP" ) ;
			xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
			xmlHttp.open("POST","IVPrescriptionValidate.jsp?bean_id="+bean_id+"&bean_name="+bean_name+"&validate=GET_TRNGROUPREF",false);
			xmlHttp.send(xmlDoc);
			responseText=xmlHttp.responseText ;
			responseText=trimString(responseText);

			if(responseText != undefined && responseText!=null && responseText!=""){
				var dialogHeight	="15" ;
				var dialogWidth	="30";
				var dialogTop	= "300" ;
				var dialogLeft	= "300" ;
				var center			= "1" ;
				var status			="no";
				var features	= "dialogHeight:" + dialogHeight +"; dialogLeft:"+dialogLeft+ "; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop;
				var arguments	= "";
				retVal = await window.showModalDialog("../../ePH/jsp/TokenListForOrders.jsp?trn_group_ref="+responseText,arguments,features);
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
		if((print_ord_sht_rule_ind=="C" || print_ord_sht_rule_ind=='') || (print_mar_label_yn=="Y" && buildMAR_yn=="Y") || narcotic_aprvl_form_req_yn=="Y"){//AND print_ord_sht_rule_ind=="C" || print_ord_sht_rule_ind=='' added for Inc : 049877
			retVal = await window.showModalDialog("../../ePH/jsp/PrescriptionPrintDialog.jsp?narcotic_aprvl_form_req_yn="+narcotic_aprvl_form_req_yn+"&print_narcotic_form_by_default="+print_narcotic_form_by_default+"&called_from=IVWA"+"&buildMAR_yn="+buildMAR_yn+"&print_mar_label_yn="+print_mar_label_yn+"&print_ord_sht_rule_ind="+print_ord_sht_rule_ind,arguments,features);//print_ord_sht_rule_ind Added for Bru-HIMS-CRF-393_1.0
      		}
		if(((print_ord_sht_rule_ind=="C" || print_ord_sht_rule_ind=='') && retVal != undefined && retVal[0] != "" && retVal[0] != "CANCEL") || print_ord_sht_rule_ind =='S'){//print_ord_sht_rule_ind Added for Bru-HIMS-CRF-393_1.0  && code '&& retVal != ""' added for IN49320 AND print_ord_sht_rule_ind=="C" || print_ord_sht_rule_ind=='' added for Inc : 049877		
			var xmlStr ="<root><SEARCH ";
			xmlStr+= "locn_code =\"" + locn_code + "\" " ;
			xmlStr+= "patient_class =\"" + patient_class + "\" " ;
			xmlStr+= "order_set_code =\"" + order_set_code + "\" ";
			if((print_ord_sht_rule_ind=="C" || print_ord_sht_rule_ind=='') && retVal.length >0){//If and Else If  Added for Bru-HIMS-CRF-393_1.0 AND print_ord_sht_rule_ind=="C" || print_ord_sht_rule_ind=='' added for Inc : 049877
				xmlStr+=" prescriptionPrint=\""+ retVal[0] + "\" ";
				xmlStr+=" NarcoticPrint=\""+ retVal[1] + "\" ";
				xmlStr+=" MARLabelPrint=\""+ retVal[2] + "\" "; //added for MMS-QH-CRF-0080 [IN:038064]
			}
			else if(print_ord_sht_rule_ind =='S')
				xmlStr+=" prescriptionPrint=\""+ "Y"+ "\" ";
			/*if (confirm(getMessage("PH_PRINT_PRESCRIPTION","PH"))) {
				xmlStr+= "print_yn='Y'" ;
			} 
			else {
				xmlStr+= "print_yn='N'" ;
			}*/
			xmlStr +=" /></root>";
			
			var temp_jsp="IVPrescriptionValidate.jsp?validate=PRINT&bean_id="+bean_id+"&bean_name="+bean_name;
			var xmlDoc = "" ;
			var xmlHttp = new XMLHttpRequest() ;
			
			xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
			xmlHttp.open("POST",temp_jsp,true);
			xmlHttp.send(xmlDoc);
			//responseText=xmlHttp.responseText ;
			//alert(responseText);
			//eval(responseText);
		}
		if(parent.parent.parent.parent.parent.parent.orderMainTab !=null){
			var locnDet = parent.parent.parent.parent.parent.parent.orderMainTab.location.href;
			// if its a amend order then close the window or reload the window
			if(locnDet.indexOf('ammend') != -1){
			//	window.close();
				
			    
			    const dialogTag = parent.parent.document.getElementById("dialog_tag");    
			    dialogTag.close();  
			}
			else{
				parent.parent.parent.parent.parent.parent.orderMainTab.location.reload();
				var isPopup = (window.location.href == window.parent.location.href);//added for SKR-SCF-0503 [IN032732] -- Start
				
				if(window.dialogArguments != null){					
					//window.close();
				
			    
			   	parent.parent.document.querySelectorAll("#dialog_tag")[parent.parent.document.querySelectorAll("#dialog_tag").length -1].close();  
				}
				else{				
					parent.parent.parent.parent.parent.parent.orderMainTab.location.reload();
					window.location.reload();
				}	//added for SKR-SCF-0503 [IN032732] -- End
			}
		}
		else if(parent.parent.parent.criteriaCategoryButtonFrame !=null){
			parent.parent.parent.criteriaCategoryButtonFrame.location.reload();
		}
		else{
			//window.close();
			
		    
		    const dialogTag = parent.parent.document.getElementById("dialog_tag");    
		    dialogTag.close();  
		}
	}
	else{
		var frmObj			= parent.f_detail.formIVPrescriptionAdditives;	
		var bean_id			= frmObj.bean_id.value;
		var bean_name		= frmObj.bean_name.value;
		var patient_class	= frmObj.patient_class.value;
		var locn_code		= frmObj.LOCN_CODE.value;
		var qryString		= "";
	
		if(top.content != null)
			top.content.messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num="+message;
		else{
			for(i=0;i<message.length;i++){
				if(message.charAt(i) == ".") break;
			}
			alert(message.substring(0,i+3));
		}

		if(parent.parent.f_header == undefined)
			hdrForm = parent.f_header.prescription_header_form;
		else
			hdrForm = parent.parent.f_header.prescription_header_form;
		var narcotic_aprvl_form_req_yn=hdrForm.narcotic_aprvl_form_req_yn.value;
		var print_narcotic_form_by_default=hdrForm.print_narcotic_form_by_default.value;
		var print_mar_label_yn = hdrForm.print_mar_label_yn.value; //added for MMS-QH-CRF-0080 [IN:038064]
		var buildMAR_yn = hdrForm.buildMAR_yn.value; //added for MMS-QH-CRF-0080 [IN:038064]

		if(narcotic_yn == "N"){
			narcotic_aprvl_form_req_yn = "";
			print_narcotic_form_by_default="";
		}
		
		var dialogHeight	="12" ;
		var dialogWidth	="30";
		var dialogTop	= "300" ;
		var dialogLeft	= "300" ;
		var center			= "1" ;
		var status			="no";
		var features	= "dialogHeight:" + dialogHeight +"; dialogLeft:"+dialogLeft+ "; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop;
		var arguments	= "";
	   if((print_ord_sht_rule_ind=="C" || print_ord_sht_rule_ind=='') || (print_mar_label_yn=="Y" && buildMAR_yn=="Y") || narcotic_aprvl_form_req_yn=="Y"){//AND print_ord_sht_rule_ind=="C" || print_ord_sht_rule_ind=='' added for Inc : 049877
		retVal =await  window.showModalDialog("../../ePH/jsp/PrescriptionPrintDialog.jsp?narcotic_aprvl_form_req_yn="+narcotic_aprvl_form_req_yn+"&print_narcotic_form_by_default="+print_narcotic_form_by_default+"&called_from=IVWA"+"&buildMAR_yn="+buildMAR_yn+"&print_mar_label_yn="+print_mar_label_yn+"&print_ord_sht_rule_ind="+print_ord_sht_rule_ind,arguments,features);
		}
		if((print_ord_sht_rule_ind=="C" || print_ord_sht_rule_ind=='') && retVal != undefined && retVal[0] != "CANCEL"){//AND print_ord_sht_rule_ind=="C" || print_ord_sht_rule_ind=='' added for Inc : 049877	
			var xmlStr ="<root><SEARCH ";
			xmlStr+= "locn_code =\"" + locn_code + "\" " ;
			xmlStr+= "patient_class =\"" + patient_class + "\" " ;
			if((print_ord_sht_rule_ind=="C" || print_ord_sht_rule_ind=='') && retVal.length >0){//If and Else If  Added for Bru-HIMS-CRF-393_1.0 AND print_ord_sht_rule_ind=="C" || print_ord_sht_rule_ind=='' added for Inc : 049877
				xmlStr +="prescriptionPrint=\""+ retVal[0] + "\" ";
				xmlStr +="NarcoticPrint=\""+ retVal[1] + "\" ";
				xmlStr+=" MARLabelPrint=\""+ retVal[2] + "\" "; //added for MMS-QH-CRF-0080 [IN:038064]
			}
			else if(print_ord_sht_rule_ind =='S')
				xmlStr+=" prescriptionPrint=\""+ "Y"+ "\" ";
			xmlStr +=" /></root>";
		/*	if (confirm(getMessage("PH_PRINT_PRESCRIPTION","PH"))) {
				xmlStr+= "print_yn='Y'" ;
			}
			else{
				xmlStr+= "print_yn='N'" ;
			}*/
			var temp_jsp="IVPrescriptionValidate.jsp?validate=PRINT&bean_id="+bean_id+"&bean_name="+bean_name;
			var xmlDoc = "" ;
			var xmlHttp = new XMLHttpRequest() ;
			xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
			xmlHttp.open("POST",temp_jsp,true);
			xmlHttp.send(xmlDoc);
		}
		if(parent.parent.parent.parent.parent.parent.orderMainTab !=null){
			var locnDet = parent.parent.parent.parent.parent.parent.orderMainTab.location.href;
			// if its a amend order then close the window or reload the window
			if(locnDet.indexOf('ammend') != -1){
				//window.close();
			
		    
		  	parent.parent.document.querySelectorAll("#dialog_tag")[parent.parent.document.querySelectorAll("#dialog_tag").length -1].close();  
			}
			else{
				parent.parent.parent.parent.parent.parent.orderMainTab.location.reload();				
				/*  Below code added for SKR-SCF-0503 [IN032732] -- Start*/ 
				var isPopup = (window.location.href == window.parent.location.href);
				
					if(window.dialogArguments != null){				
						//window.close();
					
				    
				    	parent.parent.document.querySelectorAll("#dialog_tag")[parent.parent.document.querySelectorAll("#dialog_tag").length -1].close();  
					}
					else{				
						parent.parent.parent.parent.parent.parent.orderMainTab.location.reload();
						window.location.reload();
						}
				/*  code added for SKR-SCF-0503 [IN032732] -- End*/ 				
				}
		}
		else if(parent.parent.parent.criteriaCategoryButtonFrame !=null){
			parent.parent.parent.criteriaCategoryButtonFrame.location.reload();
		}
		else{
			//window.close();
			
		    
		 	parent.parent.document.querySelectorAll("#dialog_tag")[parent.parent.document.querySelectorAll("#dialog_tag").length -1].close();  
		}
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
	let dialogBody = parent.document.getElementById('dialog-body');
    dialogBody.contentWindow.returnValue = retval;
    
    const dialogTag =parent.document.getElementById("dialog_tag");    
    dialogTag.close();  
}
function reloadOnRelease(){
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
	else{
		//window.close();
		
	    
	    const dialogTag = parent.parent.document.getElementById("dialog_tag");    
	    dialogTag.close();  
	}
}

async function loadDrugInfo(prodid, drugdesc) {
	var dialogHeight	="85" ;
	var dialogWidth	="70";
	var dialogTop		= "270";
	var dialogLeft		= "200";
	var center			= "0";
	var status			= "no";
	var features		= "dialogHeight:" + dialogHeight +"; dialogLeft:"+dialogLeft+ "; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop;
	var arguments		= "";
	retVal 				=await  window.showModalDialog("../../ePH/jsp/DisplayDrugInfoFrames.jsp?extprodid="+prodid+"&drugdesc="+drugdesc+"&JSFile=../../ePH/js/Prescription_1.js",arguments,features);
}

async function viewInteraction(patientid, orderid, encounter_id) {
	var dialogHeight	= "18";
	var dialogWidth		= "40";
	var dialogTop		= "270";
	var dialogLeft		= "200";
	var center			= "0";
	var status			= "no";
	var features		= "dialogHeight:" + dialogHeight +"; dialogLeft:"+dialogLeft+ "; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop;
	var arguments		= "";
	retVal 				=await  window.showModalDialog("../../ePH/jsp/DisplayInteractionsFrames.jsp?patientid="+patientid+"&orderid="+orderid+"&encounterid="+encounter_id+"&JSFile=../../ePH/js/Prescription_1.js",arguments,features);
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
	obj = eval(obj);
	var opt	= eval(document.createElement('OPTION'));
	opt.value =	code;
	opt.text = desc;
	obj.add(opt);
}

function setDefaultData(code, frmObj, mode) {
	frmObj = eval(frmObj);
	if (mode == 1) {
		if (frmObj.QTY_DESC_CODE.value == "")
			frmObj.STRENGTH_UOM.value = code;
		else
			frmObj.STRENGTH_UOM.value = frmObj.QTY_DESC_CODE.value;
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

async function testResult(bean_id, bean_name, result) {
	var dialogHeight	= "20";
	var dialogWidth		= "50";
	var dialogTop		= "250";
	var center			= "1";
	var status			= "no";
	var features		= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop;
	var arguments		= "";
	await window.open("../jsp/IVtemp.jsp?bean_id="+bean_id+"&bean_name="+bean_name+"&result="+result, arguments, features);
}

function defaultFlowUom(obj) {
	document.formIVPrescriptionFluidDetail.INFUSION_PERIOD_VALUE.focus();
	document.getElementById("flow_unit").innerText	=	"/"+obj.options(obj.selectedIndex).text;
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
    
//	window.close();
    var xmlDoc = "" ;
    var xmlHttp = new XMLHttpRequest() ;
    xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
    xmlHttp.open("POST","IVPrescriptionValidate.jsp?validate=saveRemarks&bean_id="+bean_id+"&bean_name="+bean_name,false);
    xmlHttp.send(xmlDoc);
    responseText=xmlHttp.responseText ;
    //alert(responseText);
    eval(responseText);
}

function showDrugProfile(patient_id){
	var dialogHeight	= "28" ;
	var dialogWidth		= "50" ;
	var dialogTop		= "122" ;
	var center			= "1" ;
	var status			= "no";
	var features		= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop;
	var arguments		= "" ;
	retVal				= window.showModalDialog( "../../ePH/jsp/QueryPatientDrugProfileFrames.jsp?patient_id="+escape(patient_id)+"&called_frm=Prescription", arguments, features );
}

function populateFreq(obj) {
	var frmObj			= document.formIVPrescriptionFluidDetail;
	var patient_id		=	frmObj.patient_id.value;
	var encounter_id	=	frmObj.encounter_id.value;

    var bean_id= "@IVPrescriptionBean"+patient_id+encounter_id;
    var bean_name="ePH.IVPrescriptionBean";
	
	var chk_val	=	"N";
	if(obj.checked==true) {
		chk_val	=	"Y";
	} 

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
    //alert(responseText);
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
	} else {
		if(frmObj.freq_code.value=="") {
			frmObj.FREQUENCY.value	= code;
		} else {
			frmObj.FREQUENCY.value	= frmObj.freq_code.value;	
		}
		frmObj.INFUSION_VALUE.disabled	=	false;
		frmObj.INFUSION_UOM.disabled	=	false;
		parent.f_ivadmin.document.getElementById('inf_mand').style.visibility = "visible";		
	}
}

function duplicateWarning() {
	var msg		=	getMessage("PH_DUPLICATE_MEDICATION","PH");	
	var all_msg	=	msg.split("||");
		alert(all_msg[0]+document.formIVPrescriptionDrugDetails.GENERIC_NAME.value+all_msg[1]); 
        //addDrug('delete');
		cancelDuplicate();
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

function ValidateDateTime (from,to)
{    

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
    {
        //msgframe.location.href='../../eCommon/jsp/error.jsp?err_num='+parent.parent.frames[0].getMessage("TO_DT_GR_EQ_FM_DT")
        return false
    }
    else
        return true;
}
function searchIVFluid(frmObj,searchBasedOn, obj,rec_no) {
	var frmObj			= document.formIVPrescriptionDetails;
	var header_form			= parent.parent.parent.f_header.document.prescription_header_form;
	//alert(frmObj);
	var patient_class			= frmObj.patient_class.value;
	var discharge_yn			= header_form.take_home_medication.value;
	var priority				= header_form.priority.value;
	var source_code				= header_form.source_code.value;
	var source_type				= header_form.source_type.value;
	var encounter_id			= header_form.encounter_id.value;
	var patient_id				= header_form.patient_id.value;
	var act_patient_class		= header_form.actual_patient_class.value;
	var location_type			= header_form.location_type.value;
	var location_code			= header_form.location_code.value;
	var take_home_medication	= header_form.take_home_medication.value;
	var date_of_birth			= header_form.date_of_birth.value;
	var gender					= header_form.gender.value;

	var iv_prep_yn="5";

	var retArray		= DrugSearchForIV(searchBasedOn, obj, '', '', 'DrugSearchBean', '', '', act_patient_class, priority, 'F',"N",discharge_yn,source_type, source_code, patient_id, encounter_id,date_of_birth,gender, iv_prep_yn);
	
	if (retArray != null && retArray != "" ) {
		if (frmObj.name == "formIVPrescriptionDetails"){	
			frmObj.fluid_code.value	= retArray[0];
			var drug_code			= retArray[0];
			frmObj.fluid_name.value = retArray[1];
			
			frmObj.form_code.value	= retArray[2];
			frmObj.route_code.value	= retArray[3];
			frmObj.base_uom.value	= retArray[4];
			//alert(retArray[4]);
			var base_uom			= retArray[4];
			var bean_id				= frmObj.bean_id.value;
			var bean_name			= frmObj.bean_name.value;
			var qryString			= bean_id+"&bean_name="+bean_name+"&validate=FLUIDDETAILS&drug_code="+drug_code+"&base_uom="+base_uom+"&location_type="+location_type+"&location_code="+location_code+"&take_home_medication="+take_home_medication+"&priority="+priority+"&iv_prep_yn="+iv_prep_yn;
			
			submitXML(qryString, "");
		}			
	}	
}
/*
function defaultDrug(serialNum,or_mode) {

	var frmObj			= parent.parent.f_sub_ivdrugs.document.formIVPrescriptionDrugDetails;
	
	var patient_id		= frmObj.patient_id.value;
	var encounter_id	= frmObj.encounter_id.value;
	var patient_class	= frmObj.patient_class.value;
	var drug_codes		= frmObj.drug_codes.value;
	var start_date		= frmObj.start_date.value;
	var iv_option		= "";

	if(parent.parent.parent.parent.f_ivselect.document.formIVPrescriptionOptions.type!=null)
		iv_option	=	parent.parent.parent.parent.f_ivselect.document.formIVPrescriptionOptions.type.value;
	
	
	if(or_mode != "amend"){

		parent.f_sub_ivdrugs.location.href="../jsp/IVPrescriptionDrugDetails.jsp?serialNum="+serialNum+"&patient_id="+patient_id+"&encounter_id="+encounter_id+"&act_patient_class="+patient_class+"&drug_codes="+drug_codes+"&iv_option="+iv_option+"&start_date="+start_date;
	}else{
			parent.parent.f_sub_ivdrugs.location.href="../jsp/IVPrescriptionDrugDetailsAmend.jsp?or_mode="+or_mode+"&serialNum="+serialNum+"&patient_id="+patient_id+"&encounter_id="+encounter_id+"&act_patient_class="+patient_class+"&drug_codes="+drug_codes+"&iv_option="+iv_option+"&start_date="+start_date;
	}
}
*/
function loadButtonsFrame(or_mode,patient_id,encounter_id) {
	var frmObj		= parent.f_sub_ivdrugs.document.formIVPrescriptionDrugDetails;
	var frmObj1		= parent.parent.f_iv_admin.document.formIVPrescriptionAdminDetail;
	var drug_array	= frmObj.drug_codes.value.split(",");
	var num_drugs	= drug_array.length-1;
	var limit_ind	= frmObj.LIMIT_IND.value;
	var allergy_yn	= frmObj.ALLERGY_YN.value;
	var current_rx	= frmObj.CURRENT_RX.value;
	parent.f_drug_button.location.href="../jsp/IVPrescriptionDrugDetailButtons.jsp?or_mode="+or_mode+"&showButtons=Y"+"&limit_ind="+limit_ind+"&allergy_yn="+allergy_yn+"&current_rx="+current_rx+"&patient_id="+patient_id+"&encounter_id="+encounter_id;

	/*if (num_drugs == 1) {	
	//	frmObj1.FREQUENCY.value		= frmObj.FREQ_CODE.value;
	//	frmObj1.FREQUENCY.disabled	= false;	
	//	checkScheduledYN(frmObj1.FREQUENCY.value, "2");
	}*/
}

function CalculateDateTime(from,obj){
    //from = from.value    
    obj.value = from.value;
	//obj.disabled	=	true;
}

function getInfuseOverInMin(hr, mi){
	if(hr == "")
		hr = 0;
	if(mi == "")
		mi = 0;
	tot = parseFloat(hr*60)+parseFloat(mi);
	return tot;
}

function validateRate(rate,volume1,infuse_over,duration,infusionOverStr,rec){
	var iv_calc_infuse_by = document.formIVPrescriptionAdditives.iv_calc_infuse_by.value //Added for SKR-CRF-0035 [IN:037727] 
	if(parseFloat(rate.value) >0&& rate.value!="" && parseFloat(duration.value)>0 && duration.value!="" ){
		var infusion_value = rate.value;
		var volume = volume1.value;
		var unit = 	eval("document.formIVPrescriptionAdditives.InfusionRateUnit"+rec).value;
		if(unit == "H"){
			infusion_value = volume * 60/infusion_value;
			//infusion_value = infusion_value/60;
		}
		else{
			infusion_value = volume/infusion_value;
		}
		infusion_value = infusion_value/60;
		infusion_value = Math.round(infusion_value*100)/100;
		HrsMinStr = getHrsMinStr(infusion_value,unit.value);
		eval("document.formIVPrescriptionAdditives.infusion_over_insert_value"+rec).value = infusion_value;
		infusionOverStr.innerHTML	= HrsMinStr;
		hrs = HrsMinStr.substring(1,HrsMinStr.indexOf("H")-1);
		min = HrsMinStr.substring(HrsMinStr.indexOf("H")+4,HrsMinStr.indexOf("M")-1);
		eval("document.formIVPrescriptionAdditives.INFUSION_PERIOD_VALUE"+rec).value = Math.floor(hrs);
		eval("document.formIVPrescriptionAdditives.INFUSION_PERIOD_VALUE_MIN"+rec).value = Math.round(min);
		if(duration.value > 0 && parseFloat(infusion_value) > duration.value  && iv_calc_infuse_by!='I'){ // iv_calc_infuse_by Added for AAKH-SCF-0121 [IN:049680]
			/*if(iv_calc_infuse_by=='I')
				alert(getMessage("INFUSE_OVER_CANNOT_GREATER","PH"));
			else*/ //commented for AAKH-SCF-0121 [IN:049680]
				alert(getMessage("DURATION_CANNOT_LESSTHAN","PH"));
			//duration.select();
			//eval("document.formIVPrescriptionAdditives.INFUSION_PERIOD_VALUE"+rec).focus();
			return false;
		}
	}
	else{
		infuse_over.focus();
	}
}

function calculateRate(obj, volume1,infusion_rate,infusionOverStr,rec) {
	var Infovr = parseFloat(obj.value);
	var unit = eval("document.formIVPrescriptionAdditives.InfusionRateUnit"+rec).value;
	var volume						= volume1.value;
	var infusion_period_value		= eval("document.formIVPrescriptionAdditives.INFUSION_PERIOD_VALUE"+rec).value;
	var infusion_period_value_min	=eval("document.formIVPrescriptionAdditives.INFUSION_PERIOD_VALUE_MIN"+rec).value;
	var duration = eval("document.formIVPrescriptionAdditives.DURATION"+rec);
	var infusion_period		= eval("document.formIVPrescriptionAdditives.INFUSION_PERIOD_VALUE"+rec);
	if(((parseFloat(infusion_period_value) !=0 && infusion_period_value !="") || (parseFloat(infusion_period_value_min) !=0 && infusion_period_value_min !="")) && volume !="" && parseFloat(volume) !=0) {
		if(infusion_period_value_min < 60){
			var InfuseOverInMin = getInfuseOverInMin(infusion_period_value,infusion_period_value_min); 
			var InfuseOverInHr = parseFloat(InfuseOverInMin/60); 
			var total_hr = duration.value;
			total_hr = parseInt(total_hr)*60;
			if(total_hr != 0 && parseFloat(total_hr) < parseFloat(InfuseOverInMin)){
				var iv_calc_infuse_by = document.formIVPrescriptionAdditives.iv_calc_infuse_by.value //Added for SKR-CRF-0035 [IN:037727] 
				/*if(iv_calc_infuse_by=='I'){
					alert(getMessage("INFUSE_OVER_CANNOT_GREATER","PH"));
					//eval("document.formIVPrescriptionAdditives.INFUSION_PERIOD_VALUE"+rec).value = duration.value;
					//eval("document.formIVPrescriptionAdditives.INFUSION_PERIOD_VALUE_MIN"+rec).value = 0;
				}
				else*/ //commented for AAKH-SCF-0121 [IN:049680]
				if(iv_calc_infuse_by!='I')
					{
					alert(getMessage("DURATION_CANNOT_LESSTHAN","PH"));
					}
				//infusion_period.focus();
				return false;
			}

			InfuseOverInHr =Math.round(InfuseOverInHr*100)/100;
			if(volume == "" || volume ==0){
				alert(getMessage("FLD_VOL_CANT_BLNK_ZERO","PH"));
				volume1.focus();
				return false;
			}			
			else{
				if(unit == "H")
					var infusion_value = (volume)*60/(InfuseOverInMin); //SCF-7847 
				else
					var infusion_value = (volume)/(InfuseOverInMin);
				eval("document.formIVPrescriptionAdditives.infusion_over_insert_value"+rec).value = InfuseOverInHr;
				infusion_value = Math.round(infusion_value*100)/100;
				infusion_rate.value = infusion_value;
				var str = getHrsMinStr(InfuseOverInHr,unit);
				infusionOverStr.innerHTML	= str; 
			} 
		}
	}
	else{
		alert(getMessage("INFS_OVR_CANT_BLANK_ZERO","PH"));
		//eval("document.formIVPrescriptionAdditives.INFUSION_PERIOD_VALUE_MIN"+rec).focus(); //Commented for [IN:046215]
		return false;
	}
}

function validateDuration(duration,infuse_over,infusionRateUnit,infusion_period_value_min, iv_calc_infuse_by) {
	var total_hr = duration.value;
	if(infusionRateUnit.value == 'M')
		total_hr = parseFloat(total_hr)*60;
	if(parseFloat(duration.value)==0 || duration.value==""){
		alert(getMessage("PRES_IV_DUR_NOT_BLANK","PH"));
		//duration.focus();
		//duration.select();
		return false;
	}
	else if((infuse_over.value=="" || parseInt(infuse_over.value)== 0) && (infusion_period_value_min == "" || parseInt(infusion_period_value_min) == 0)) {
		alert(getMessage("PRES_IV_INF_OVER_NOT_BLANK","PH"));
		//infuse_over.focus();
		//infuse_over.select();
		return false;
	}
	else 
	if( parseFloat(infuse_over.value) > parseInt(duration.value)){
		alert(getMessage("DURATION_CANNOT_LESSTHAN","PH"));
		return false;
	}
	else if(parseInt(duration.value) > 168 ){
		alert(getMessage("DURATION_CANNOT_GREATER","PH"));
		return false;
	}
	else if(parseInt(infuse_over.value) > parseInt(duration.value) && iv_calc_infuse_by!='I') { 
		//removed 24 and added parseInt(duration.value) SKR-SCF-1221

		alert(getMessage("INFUSION_OVER_CANNOT_GREATER","PH"));
		infuse_over.select();
		infuse_over.focus();
		return false;
	}
	else {
		var total_hr = duration.value;
		total_hr = parseInt(total_hr)*60;
		infuseOver = getInfuseOverInMin(infuse_over.value,infusion_period_value_min.value);
		if(total_hr > 0 && parseInt(total_hr) < parseInt(infuseOver)){
			alert(getMessage("DURATION_CANNOT_LESSTHAN","PH"));
			infuse_over.focus();
			return false;
		}
		/*else {
			return true;
		}*/
	}

	srl = duration.name;
	srl = srl.substring(srl.length-1,srl.length);
	var InfuseOverInMin = getInfuseOverInMin(infuse_over.value,infusion_period_value_min.value); 
	var InfuseOverInHr = parseFloat(InfuseOverInMin/60); 
	InfuseOverInHr =Math.round(InfuseOverInHr*100)/100;
	var str = getHrsMinStr(InfuseOverInHr,"");
	document.getElementById("infusionOverStr"+srl).innerHTML	= str;
}

function validateRate1(rate,volume,infuse_over,duration,InfusionRateUnit,infusion_period_value, iv_calc_infuse_by){
	var temp = "0";
	var calDuration = duration.value;
	//INO71514
	if(InfusionRateUnit.value == "M"){ 
		calDuration = calDuration * 60;
	}
		 
		
	if(rate.value != null && rate.value != "" && parseFloat(rate.value) != 0 ){
		temp = parseFloat(volume.value)/parseFloat(rate.value);
		if(iv_calc_infuse_by=='I' && InfusionRateUnit.value == "M") //if block added for AAKH-SCF-0119 [IN:049629]
			temp = temp/60;
		temp = Math.round(temp*100)/100;
	}
	//infuse_over.value=temp;
	//if(infusionOverStr != "" && infusionOverStr != undefined)
	//infusionOverStr.innerHTML = getHrsMinStr(Infovr,'H');
	//duration.value=temp;
	if(parseFloat(rate.value)==0 || rate.value==""  ){
		alert(getMessage("PRES_IV_INF_RATE_NOT_BLANK","PH"));
		rate.focus();
		rate.select();
		return false;
	}
	else if(parseFloat(duration.value)==0 || duration.value==""){
		alert(getMessage("PRES_IV_DUR_NOT_BLANK","PH"));
		duration.focus();
		duration.select();
		return false;
	}
	else if(parseFloat(infuse_over.value)==0 || infuse_over.value=="") {
		alert(getMessage("PRES_IV_INF_OVER_NOT_BLANK","PH"));
		infusion_period_value.focus();
		//infuse_over.select();
		return false;
	}
	else if(iv_calc_infuse_by!='I' && parseInt(rate.value) > parseInt(volume.value)) {//Uncommented SKR-CRF-0035 // iv_calc_infuse_by added for AAKH-SCF-0119 [IN:049629]
		var msg = getMessage("INFUSION_RATE_CANNOT_GREATER","PH");
		//if(iv_calc_infuse_by=='I') //if block commneted for  AAKH-SCF-0119 [IN:049629]
			//msg = msg+"/"+getLabel("Common.Unit.label",'Common');
		alert(msg);
		rate.focus();
		rate.select();
		return false;
	}
	else if(parseInt(temp) > parseInt(calDuration) && iv_calc_infuse_by!='I') { //Uncommented SKR-CRF-0035 and removed 24 and added parseInt(calDuration) SKR-SCF-1221

		alert(getMessage("INFUSION_OVER_CANNOT_GREATER","PH"));
		rate.select();
		rate.focus();
		return false;
	}
	else if(calDuration > 0 && parseFloat(infuse_over.value) > parseFloat(calDuration) && iv_calc_infuse_by!='I') { // iv_calc_infuse_by Added for AAKH-SCF-0121 [IN:049680]
		/*if(iv_calc_infuse_by=='I')
			alert(getMessage("INFUSE_OVER_CANNOT_GREATER","PH"));
		else*/ //commented for AAKH-SCF-0121 [IN:049680]
			alert(getMessage("DURATION_CANNOT_LESSTHAN","PH"));
		//infusion_period_value.select();
		infusion_period_value.focus();
		return false;
	}
	else if(parseFloat(temp) > parseFloat(calDuration.value)  && iv_calc_infuse_by!='I'){ //Uncommented SKR-CRF-0035 // iv_calc_infuse_by Added for AAKH-SCF-0121 [IN:049680] //modified for INO71514		
		/*if(iv_calc_infuse_by=='I')
			alert(getMessage("INFUSE_OVER_CANNOT_GREATER","PH"));
		else*/ //commented for AAKH-SCF-0121 [IN:049680]
			alert(getMessage("DURATION_CANNOT_LESSTHAN","PH"));
	    duration.select();
		duration.focus();
		return false;
	}
	else if(parseInt(duration.value) > 168 && iv_calc_infuse_by!='I') {
		alert(getMessage("DURATION_CANNOT_GREATER","PH"));
		return false;
	}
	else {
		return true;
	}
}

function roundDigits(a){
	var a=a+"";
	if (a.indexOf(".")==-1){
		bb=a.substr(0,a.length);
	}
	else{
		bb=a.substr(a.indexOf("."),a.length);
		if (bb.length>1){
			   var temp=bb.substr(1,1);
			if(temp >= 5 ){
				bb=parseInt(a.substr(0,a.indexOf(".")-1)+1);
			}
			else{
				bb=a.substr(0,a.indexOf(".")-1);
			}
		}
	}
	return bb;
}

function setStockValue(obj,rec_no){
	volume		= eval("document.formIVPrescriptionAdditives.volume"+rec_no);
	if(obj.value != "0" && obj.value != "" && parseFloat(obj.value) > 0){
		stock_val	= eval("document.formIVPrescriptionAdditives.stock_value"+rec_no);
		base_volume = eval("document.formIVPrescriptionAdditives.base_volume"+rec_no);
		frmobj = document.formIVPrescriptionAdditives;//Added for SKR-CRF-0035 [IN:037727] -Start
		var iv_calc_infuse_by = frmobj.iv_calc_infuse_by.value ;
		if(iv_calc_infuse_by=='I'){
			var orderQty = eval('frmobj.order_qty'+rec_no).value;
			var volumePerUnit = eval('frmobj.volumePerUnit'+rec_no).value;
			var maxTotalVolume = parseInt(volumePerUnit)*parseInt(orderQty);
			var minTotalVolume = parseInt(volumePerUnit)*(parseInt(orderQty)-1);
			var totalVolume = parseInt(obj.value);
			var msg = "";
			if(parseInt(totalVolume) > parseInt(maxTotalVolume) ){
				msg = getMessage("PH_IV_TOTAL_VOLUME_MAX_RANGE","PH");
				msg = msg.replace("$",maxTotalVolume)+" "+eval('frmobj.vol_uom'+rec_no).innerText;
				totalVolume = maxTotalVolume;
			}
			else if(parseInt(totalVolume) <= parseInt(minTotalVolume)){
				msg = getMessage("PH_IV_TOTAL_VOLUME_MIN_RANGE","PH");
				msg = msg.replace("$",minTotalVolume+1)+" "+eval('frmobj.vol_uom'+rec_no).innerText;
				totalVolume = minTotalVolume+1;
			}
			if(msg!=""){
				alert(msg);
				volume.value=totalVolume;
				volume.focus();
				return false;
			}
			//else
			//	stock_val.value = obj.value;
		}
		else{//Added for SKR-CRF-0035 [IN:037727] -End
			/*if(parseInt(obj.value)  > parseInt(base_volume.value) ){
				alert(getMessage("FLD_VOL_CANTGRT_BAS_VOL","PH")+" ("+base_volume.value+")");
				volume.focus();
			}
			else{*/
				stock_val.value = obj.value;
			//}
		}
	}
	else{
		alert(getMessage("FLD_VOL_CANT_BLNK_ZERO","PH"));
		volume.focus();
	}
}

function strtEndDateTime(Recno){
	var form = formIVPrescriptionAdditives;
	var nextRec = 0;
	for(var rec_no = Recno; rec_no<6; rec_no++){
		nextRec = parseInt(rec_no)+1;
		fld_code   = eval("form.FLUID_CODE"+nextRec);
		if( fld_code.value != ""){
			duration	  = eval("form.DURATION"+nextRec);
			end_dateObj	  = eval("form.END_DATE"+rec_no);
			end_dateVal	  = eval("form.END_DATE"+rec_no).value;		
			strt_date	  = eval("form.START_DATE"+nextRec);
			
			if(eval("form.sTimeFrame"+(rec_no+1)) != undefined){
				sTimeFrame	  = eval("form.sTimeFrame"+nextRec).value;	
			}
			else{
				sTimeFrame	  = '0';
			}
			// added for INO71514
		//	durn_unit	  = "H"; 
			durn_unit	  = "";
			if(sTimeFrame != '0'){
				var bean_id		= form.bean_id.value;
				var bean_name	= form.bean_name.value;
				var qryString	= bean_id+"&bean_name="+bean_name+"&validate=POPULATESTARTDATE&end_date="+end_dateVal+"&durn_unit="+durn_unit+"&rec_no="+nextRec+"&sTimeFrame="+sTimeFrame;
				submitXML(qryString, "");
			}
			else{
				strt_date.value  = end_dateVal;
			}
			chkDurationAD(duration,nextRec);
		}
	}
}

function displayDispLocn(ord_disp_location,time_flag){
	if(parent.f_ivbutton != undefined){
		parent.f_ivbutton.document.getElementById('dflt_disp_locn_lbl').innerText = ord_disp_location;
		parent.f_ivbutton.document.formIVPrescriptionButtons.time_flag.value =time_flag;
	}
}

async function displayChargeDetails(iv_prep_yn){
	var headerForm =""
	if(parent.parent.f_header!=undefined)
	    headerForm = parent.parent.f_header.document.prescription_header_form;
	else
        headerForm = parent.f_header.document.prescription_header_form;

	var fluidForm	="";

	if( parent.f_ivdetails!=undefined)
		fluidForm	= parent.f_ivdetails.document.formIVPrescriptionAdditives;
	else
        fluidForm	=parent.f_detail.document.formIVPrescriptionAdditives;
	
	
	if (!chkMandatoryFlds("chargedetail")) {
		return false;
	}
	
	var bean_id = fluidForm.bean_id.value;
	var bean_name = fluidForm.bean_name.value
	var patient_id = headerForm.patient_id.value
	var take_home_medication = headerForm.take_home_medication.value
	var encounter_id = headerForm.encounter_id.value
	var actual_patient_class = headerForm.actual_patient_class.value;
	var orderDateTime = headerForm.sys_date.value;
	var fluids_added = false;
	var mode1 =fluidForm.mode1.value;
	var iv_calc_infuse_by = fluidForm.iv_calc_infuse_by.value //Added for SKR-CRF-0035 [IN:037727] 

	var xmlStr ="<root><SEARCH ";					
	xmlStr+= "patient_id =\"" + patient_id + "\" " ;
	xmlStr+= "orderDateTime =\"" + orderDateTime + "\" " ;
	if(mode1!='amend'){
		for(i=1; i<=6;i++){
			if(eval("fluidForm.active"+i).style.visibility =='visible' && eval("fluidForm.active"+i).checked){
				fluids_added = true;
				xmlStr+= "fluid_code"+i+" =\"" + eval("fluidForm.FLUID_CODE"+i).value + "\" " ;
				xmlStr+= "infusion_over"+i+" =\"" + eval("fluidForm.infusion_over_insert_value"+i).value + "\" " ;
				xmlStr+= "tot_inf_prd"+i+" =\"" + eval("fluidForm.stock_value"+i).value + "\" " ;
				xmlStr+= "durn_value"+i+" =\"" + eval("fluidForm.DURATION"+i).value + "\" " ;
				xmlStr+= "MFR_YN"+i+" =\"" + eval("fluidForm.mfr_yn"+i).value + "\" " ;
				if(iv_calc_infuse_by=='I')
					xmlStr+= "order_qty"+i+" =\"" + eval("fluidForm.order_qty"+i).value + "\" " ;
			}
		}
	}
	else{
		xmlStr+= "fluid_code1 =\"" + fluidForm.FLUID_CODE1.value + "\" " ;
		xmlStr+= "infusion_over1 =\"" +fluidForm.infusion_over_insert_value1.value + "\" " ;
		xmlStr+= "tot_inf_prd1 =\"" + fluidForm.stock_value1.value + "\" " ;
		xmlStr+= "durn_value1 =\"" + fluidForm.DURATION1.value + "\" " ;
		xmlStr+= "MFR_YN1 =\"" + fluidForm.mfr_yn1.value + "\" " ;
		if(iv_calc_infuse_by=='I')
		xmlStr+= "order_qty1 =\"" + fluidForm.order_qty1.value + "\" " ;
		fluids_added = true;	
	}
	xmlStr+= "iv_calc_infuse_by =\"" + fluidForm.iv_calc_infuse_by.value + "\" " ;
	xmlStr +=" /></root>";

	if(!fluids_added)
		return false;

	var temp_jsp="IVPrescriptionValidate.jsp?validate=SAVE_ALL_FLUIDDETAILS"+"&bean_id="+bean_id+"&bean_name="+bean_name;
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest() ;
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST",temp_jsp,false);
	xmlHttp.send(xmlDoc);
	responseText=xmlHttp.responseText ;
	eval(responseText);
	var dialogHeight= "15" ;
	var dialogWidth	= "65" ;
	var dialogTop	= "305" ;
	var dialogLeft	= "0" ;
	var center		= "1" ;
	var status		= "no";
	var scroll		= "yes";
	var features	= "dialogLeft:" + dialogLeft + ";dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; center: " + center + ";scroll "+scroll+"; status: " + status + "; dialogTop :" + dialogTop;
	var arguments	= "" ;

	retVal =await  window.showModalDialog("../../ePH/jsp/ChargeDetail.jsp?bean_id="+bean_id+"&bean_name="+bean_name+"&patient_id="+patient_id+"&encounter_id="+encounter_id+"&actual_patient_class="+actual_patient_class+"&iv_prep_yn="+iv_prep_yn+"&take_home_medication="+take_home_medication,arguments,features);

	if(retVal!= undefined && retVal!=null && retVal!="")
		alertBLErrorDrugs(retVal);
}

function alertBLErrorDrugs(blErrorDrugs, called_from){

	blError = true;
	blErrorDrugs = blErrorDrugs.substring(1,blErrorDrugs.length-2);
	blErrorDrugs = blErrorDrugs.split(',');
	var bl_alert_msg=getMessage("ERROR_IN_BILLING",'PH')+"\n";
	var drug_or_fluid="";
	for(var i=0; i<blErrorDrugs.length; i++){
		if(drug_or_fluid == "")
			drug_or_fluid	= trimString(blErrorDrugs[i++]);
		else
			i++;

		drug_desc	= trimString(blErrorDrugs[i++]);
		bl_error_code = trimString(blErrorDrugs[i++]);
		bl_sys_message_id = trimString(blErrorDrugs[i++]);
		bl_error_text = trimString(blErrorDrugs[i]);

		if ((bl_error_code == "10" && bl_error_text =="") || bl_sys_message_id!=""){
			if(bl_sys_message_id!=""){
				bl_error_text = getMessage(bl_sys_message_id,'BL');
			}
		}
		bl_alert_msg += drug_desc+"  "+ bl_error_text+"\n";
	}
	alert(bl_alert_msg);
	/*if(drug_or_fluid == "F")
		document.formIVPrescriptionButtons.reset();
		//parent.f_sub_ivdrugs.document.formIVPrescriptionDrugDetails.reset();
	else if (drug_or_fluid == "D"){*/
		//parent.f_ivdetails.f_iv_drug_details.f_drug_button.document.formIVPrescriptionDrugDetailButtons.CLEAR.click()
	//}
	callClearAll(1, true);
	return false;
}

function getBLErrorDrugs(){

	var headerForm = parent.parent.f_header.document.prescription_header_form;
	var fluidForm	= parent.f_ivdetails.document.formIVPrescriptionAdditives;

	var bean_id = fluidForm.bean_id.value;
	var bean_name = fluidForm.bean_name.value
	var iv_prep_yn = document.forms[0].iv_prep_yn.value
	var patient_id = headerForm.patient_id.value
	var encounter_id = headerForm.encounter_id.value
	var actual_patient_class = headerForm.actual_patient_class.value;
	var orderDateTime = headerForm.sys_date.value;

	var xmlStr ="<root><SEARCH ";					
	xmlStr+= "patient_id =\"" + patient_id + "\" " ;
	xmlStr+= "orderDateTime =\"" + orderDateTime + "\" " ;
	for(i=1; i<=6;i++){
		if(eval("fluidForm.active"+i).style.visibility =='visible' && eval("fluidForm.active"+i).checked){
			xmlStr+= "fluid_code"+i+" =\"" + eval("fluidForm.FLUID_CODE"+i).value + "\" " ;
//			xmlStr+= "infusion_over"+i+" =\"" + eval("fluidForm.INFUSION_PERIOD_VALUE"+i).value + "\" " ; inc 25021
			xmlStr+= "infusion_over"+i+" =\"" + eval("fluidForm.infusion_over_insert_value"+i).value + "\" " ;
			xmlStr+= "tot_inf_prd"+i+" =\"" + eval("fluidForm.stock_value"+i).value + "\" " ;
			xmlStr+= "durn_value"+i+" =\"" + eval("fluidForm.DURATION"+i).value + "\" " ;
			xmlStr+= "MFR_YN"+i+" =\"" + eval("fluidForm.mfr_yn"+i).value + "\" " ;

		}
	}

	xmlStr +=" /></root>";
	


	var temp_jsp="IVPrescriptionValidate.jsp?validate=SAVE_ALL_FLUIDDETAILS"+"&bean_id="+bean_id+"&bean_name="+bean_name;
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest() ;
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST",temp_jsp,false);
	xmlHttp.send(xmlDoc);
	responseText=xmlHttp.responseText ;
	eval(responseText);

	var xmlStr ="<root><SEARCH ";					
	xmlStr+= "patient_id =\"" + patient_id+ "\" " ;
	xmlStr+= "encounter_id =\"" + encounter_id+ "\" " ;
	xmlStr+= "actual_patient_class =\"" + actual_patient_class+ "\" " ;
	xmlStr+= "iv_prep_yn =\"" + iv_prep_yn+ "\" " ;
	xmlStr +=" /></root>";
	var temp_jsp="IVPrescriptionValidate.jsp?validate=GET_BL_ERROR_DRUGS_FLUIDS"+"&bean_id="+bean_id+"&bean_name="+bean_name;
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest() ;
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST",temp_jsp,false);
	xmlHttp.send(xmlDoc);
	responseText=xmlHttp.responseText ;
	eval(responseText);
}

async function openEDLDetails(DrugCode)
{

  if(DrugCode!=''&&DrugCode!=null){
	var dialogHeight	= "40";
	var dialogWidth		= "35";
	var center			= "1";
	var status			= "no";
	var features		= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status;
	var arguments		= "";
	
await 	window.showModalDialog("../jsp/EDLAssociateListViewFrames.jsp?DrugCode="+DrugCode, arguments, features);
	}
 
}//end function
 
 function ChangeInfuseOverTime(obj,recNo){
	var frmAdminObj	= document.formIVPrescriptionAdditives;
	if(obj.value=="H"){
		eval("frmAdminObj.infusionOverStr"+recNo).innerHTML	= getHrsMinStr(eval("frmAdminObj.INFUSION_PERIOD_VALUE"+recNo).value,"H");
		eval("frmAdminObj.INFUSION_PERIOD_UOM"+recNo).value		=	"H";
	}
	else if(obj.value=="M"){
		eval("frmAdminObj.infusionOverStr"+recNo).innerHTML	= 
		getHrsMinStr(eval("frmAdminObj.INFUSION_PERIOD_VALUE"+recNo).value,"M");
		eval("frmAdminObj.INFUSION_PERIOD_UOM"+recNo).value		=	"M";
		
	}
}


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

function setInf_unit(i){
	obj = eval("document.formIVPrescriptionAdditives.InfusionRateUnit"+i)
	ind = 	obj.selectedIndex;
	val = obj[ind].innerText;
	
//	eval("document.getElementById("inf_unit")"+i).innerHTML = val;
}

async function showMultipleFlowRate(patient_id,encounter_id,mode1,i){
	frmobj = document.formIVPrescriptionAdditives;
	if(checkForDuplicate( i)){
		alert(getMessage("PH_MFR_WITH_DUPLICATE","PH"));		
		return false;
	}
	var patient_id		= frmobj.patient_id.value;
	var encounter_id	= frmobj.encounter_id.value;
	var pract_name		= frmobj.pract_name.value;
	
	var bean_id			= frmobj.bean_id.value;
	var bean_name		= frmobj.bean_name.value;
	var mode			= frmobj.mode.value;
	var locn_code		= frmobj.LOCN_CODE.value;

	var fluid_code		= eval("frmobj.FLUID_CODE"+i).value;
	var fluid_name		= eval("frmobj.FLUID_NAME"+i).value;
	var inf_rate			= eval("frmobj.INF_RATE"+i).value;	
	var start_date		= eval("frmobj.START_DATE"+i).value;
	var end_date		= eval("frmobj.END_DATE"+i).value;
	var infusion_over_insert_value		= eval("frmobj.infusion_over_insert_value"+i).value;
	var volume			= eval("frmobj.volume"+i).value;
	var base_volume		= eval("frmobj.base_volume"+i).value;
	var stock_uom_code	= eval("frmobj.stock_uom_code"+i).value;
	//var duration1		= eval("frmobj.DURATION1.value;
	var InfRateHrMin	= eval("frmobj.InfusionRateUnit"+i).value;
	var inf_over_hr		= eval("frmobj.INFUSION_PERIOD_VALUE"+i).value;
	var inf_over_min	= eval("frmobj.INFUSION_PERIOD_VALUE_MIN"+i).value;

	if(mode1 != 'amend'){
		header_form		= parent.parent.f_header.document.prescription_header_form;
	}
	else{
		header_form	= parent.f_header.document.prescription_header_form;
	}

	var height			= header_form.height.value;
	var weight			= header_form.weight.value;


	var dialogTop		= "";
 	var dialogHeight	= "60vh";
 	var dialogWidth		= "60vw";
	var dialogLeft		= "180";
 	var features		= "Width:" + dialogWidth + "; dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +"; dialogLeft:" + dialogLeft +"; dialogTop:" + dialogTop +"; scroll=auto; status=no";
 	var arguments		= "";
 	var retVal 			= await top.window.showModalDialog("../../ePH/jsp/IVPrescriptionMFR.jsp?patient_id="+patient_id+"&encounter_id="+encounter_id+"&height="+height+"&weight="+weight+"&volume="+volume+"&inf_rate="+inf_rate+"&inf_over_hr="+inf_over_hr+"&inf_over_min="+inf_over_min+"&start_date="+start_date+"&end_date="+end_date+"&stock_uom_code="+stock_uom_code+"&InfRateHrMin="+InfRateHrMin+"&ivType=ivwa"+"&mode="+mode1+"&infusion_over_insert_value="+infusion_over_insert_value+"&adminRateHidden=hidden"+"&bean_id="+bean_id+"&bean_name="+bean_name+"&fluid_code="+fluid_code+"&base_volume=NO",arguments,features);
 	//var retVal 			= window.open("../jsp/IVPrescriptionMFR.jsp?patient_id="+patient_id+"&encounter_id="+encounter_id+"&height="+height+"&weight="+weight+"&volume="+volume+"&inf_rate="+inf_rate+"&inf_over_hr="+inf_over_hr+"&inf_over_min="+inf_over_min+"&start_date="+start_date+"&end_date="+end_date+"&stock_uom_code="+stock_uom_code+"&InfRateHrMin="+InfRateHrMin+"&ivType=ivwa"+"&mode="+mode1+"&infusion_over_insert_value="+infusion_over_insert_value+"&adminRateHidden=hidden"+"&bean_id="+bean_id+"&bean_name="+bean_name+"&fluid_code="+fluid_code,arguments,features);

	if(!retVal){
	}
	else{
		if( retVal != undefined && retVal[1] > 1){
			if(mode != 'amend'){
				eval("frmobj.INF_RATE"+i).disabled=true;	
				eval("frmobj.INF_RATE"+i).value="";;	
				eval("frmobj.InfusionRateUnit"+i).disabled=true;
				eval(document.getElementById("infusionOverStr"+i)).style.visibility ="hidden";
				eval("frmobj.START_DATE"+i).disabled=true;
				eval("frmobj.Calendar"+i).disabled=true;
				eval("frmobj.END_DATE"+i).disabled=true;
				eval("frmobj.volume"+i).disabled=true;
				eval("frmobj.DURATION"+i).disabled=true;
				eval("frmobj.DURATION"+i).value="";
				eval("frmobj.INFUSION_PERIOD_VALUE"+i).disabled=true;
				eval("frmobj.INFUSION_PERIOD_VALUE_MIN"+i).disabled=true;
				eval("frmobj.INFUSION_PERIOD_VALUE"+i).value="";
				eval("frmobj.INFUSION_PERIOD_VALUE_MIN"+i).value="";
				eval(document.getElementById("MFR_Indicator"+i)).src="../../eCommon/images/enabled.gif";
				//eval("document.getElementById("mfrRemarksLink")"+i).style.display="inline";
				eval(document.getElementById("mfrRemarksLink"+i)).innerHTML="&nbsp;&nbsp;&nbsp;"+getLabel("ePH.MFRRemarks.label","PH");
			}
			eval("frmobj.volume"+i).value = retVal[0];
			eval("frmobj.mfr_yn"+i).value = "Y";
			eval("frmobj.START_DATE"+i).value = retVal[2];
			eval("frmobj.END_DATE"+i).value = retVal[3];
			var iv_calc_infuse_by = frmobj.iv_calc_infuse_by.value //Added for SKR-CRF-0035 [IN:037727] -start
			if(iv_calc_infuse_by=='I'){
				var ord_qty = Math.ceil(parseInt(eval("frmobj.volume"+i).value)/parseInt(eval("frmobj.volumePerUnit"+i).value));
				eval("frmobj.order_qty"+i).value = ord_qty;
				eval("frmobj.order_qty"+i).disabled=true;
			} //Added for SKR-CRF-0035 [IN:037727] -End
		}
	}
 }

function enableFields(i){
	frmobj = document.formIVPrescriptionAdditives;
	eval("frmobj.INF_RATE"+i).disabled=false;	
	//eval("frmobj.INF_RATE"+i).value="";;	
	eval("frmobj.InfusionRateUnit"+i).disabled=false;
	eval(document.getElementById("infusionOverStr"+i)).style.visibility ="visible";
	eval("frmobj.START_DATE"+i).disabled=false;
	eval("frmobj.Calendar"+i).disabled=false;
	eval("frmobj.END_DATE"+i).disabled=false;
	//eval("frmobj.volume"+i).disabled=false; // commented for aakh-crf-0094
	 if(frmobj.param_volume_cal.value!="N"){ // Added for aakh-crf-0094 - Start
	   eval("frmobj.volume"+i).disabled=false;
     }  // Added for aakh-crf-0094 - End
	eval("frmobj.DURATION"+i).disabled=false;
	eval("frmobj.DURATION"+i).value="24";
	eval("frmobj.INFUSION_PERIOD_VALUE"+i).disabled=false;
	eval("frmobj.INFUSION_PERIOD_VALUE_MIN"+i).disabled=false;
	//eval("frmobj.INFUSION_PERIOD_VALUE"+i).value="";
	//eval("frmobj.INFUSION_PERIOD_VALUE_MIN"+i).value="";
	eval(document.getElementById("MFR_Indicator"+i)).src="../../eCommon/images/disabled.gif";
	eval("frmobj.mfr_remarks"+i).value="";
	eval(document.getElementById("mfrRemarksLink"+i)).style.display="none";
	//eval("document.getElementById("mfrRemarksLink")"+i).innerHTML="&nbsp;&nbsp;&nbsp;"+getLabel("ePH.MFRRemarks.label","PH");
	//eval("frmobj.volume"+i).value = retVal[0];
	eval("frmobj.mfr_yn"+i).value = "N";
	//eval("frmobj.START_DATE"+i).value = retVal[2];
	//eval("frmobj.END_DATE"+i).value = retVal[3];
}

async function showMFRRemarks(num){
	var frmObj=document.formIVPrescriptionAdditives;	
	var mfr_remarks=eval("frmObj.mfr_remarks"+num).value;
	var mfr_yn=eval("frmObj.mfr_yn"+num).value;

	var dialogTop		= "";
	var dialogHeight	= "50vh";
	var dialogWidth		= "50vw";
	var dialogLeft		= "";
	var features		= "Width:" + dialogWidth + "; dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +"; dialogLeft:" + dialogLeft +"; dialogTop:" + dialogTop +"; scroll=NO; status=no";
	var arguments		= "";
	var retVal 			= await top.window.showModalDialog("../../ePH/jsp/IVPrescriptionMFRRemarks.jsp?mfr_yn="+mfr_yn+"&mfr_remarks="+mfr_remarks,arguments,features);		
	if(retVal != undefined ){		
		eval("frmObj.mfr_remarks"+num).value= retVal[0];		
	}
}

function setBackFutureDate(back_date, future_date) {
	document.formIVPrescriptionAdditives.back_date.value=back_date ;
	document.formIVPrescriptionAdditives.future_date.value=future_date;
}
// RUT-CRF-0062 [IN029600]  Function added to set Build MAR Value -- begin
function setBuildMAR(buildMARDefaulting){
	// buildMARDefaulting may  get   'CE' - Checked Enabled  'UE' - Un-Checked Enabled  'CD' - Checked Disabled  'UD' - Un-Checked Disabled
	var buildMAR_checked=buildMARDefaulting.substring(0,1);
	var buildMAR_enabled=buildMARDefaulting.substring(1,2);
	var formobj		=	document.formIVPrescriptionAdditives;
	var expDisp=""; //Added for nmc-jd-crf-0046
	
	expDisp= formobj.ext_disp_appl_yn.value; //Added for nmc-jd-crf-0046
	 
	if(buildMAR_checked=="C"){
		formobj.querySelectorAll('#buildMAR_yn').checked=true;
		formobj.querySelectorAll('#buildMAR_yn').value="Y";
	}
	else{
		formobj.querySelectorAll('#buildMAR_yn').checked=false;
		formobj.querySelectorAll('#buildMAR_yn').value="N";
	}
	if(buildMAR_enabled=="E"){
		formobj.querySelectorAll('#buildMAR_yn').disabled=false;
	}
	else{
		formobj.querySelectorAll('#buildMAR_yn').disabled=true;
	}
	
	if(expDisp=="Y")    //Start of NMC-JD-0046
	{
	formobj.querySelectorAll('#buildMAR_yn').checked=false;
	formobj.querySelectorAll('#buildMAR_yn').disabled=true;
	formobj.querySelectorAll('#buildMAR_yn').value="N";
	}
	else
	{
	formobj.querySelectorAll('#buildMAR_yn').checked=true;
	formobj.querySelectorAll('#buildMAR_yn').disabled=false;
	formobj.querySelectorAll('#buildMAR_yn').value="Y";
	}             // End of NMC-JD-CRF-0046
	
}
// RUT-CRF-0062 [IN029600]  -- end
//Added for  ML-BRU-CRF-072[Inc:29938] start
async function drugindication_remarks(){
	var formobj		=	document.formIVPrescriptionAdditives;
	var bean_id = formobj.bean_id.value;
	var bean_name = formobj.bean_name.value;
	var DrugIndicationRemarks	=	formobj.DrugIndicationRemarks.value;
	var dialogHeight= "38vh" ;
	var dialogWidth	= "40vw" ;
	var dialogTop = "225" ;
	var dialogLeft ="100";
	var center = "0" ;
	var status="no";
	var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" +dialogTop+"; dialogLeft :"+dialogLeft;
	var arguments	= "" ;
	retVal = await window.showModalDialog("../../ePH/jsp/DrugIndicationRemarks.jsp?&DrugIndicationRemarks="+encodeURIComponent(DrugIndicationRemarks)+"&bean_id="+bean_id+"&bean_name="+bean_name+"&iv_prep_yn=5",arguments,features);//encodeURIComponent Added for MMS Adhoc Testing
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
}
//Added for  ML-BRU-CRF-072[Inc:29938] End
// Added for Bru-HIMS-CRF-347 [IN:037862] -- Begin
function displayDispLocnDrugLevel(disp_locn_desc,disp_locn_code,disp_locn_type,per_facility_id,fluid_num){
	eval(document.getElementById("disp_locn_desc"+fluid_num)).innerText=disp_locn_desc;
	eval(document.getElementById("disp_locn_code"+fluid_num)).innerText=disp_locn_code;
	eval(document.getElementById("disp_locn_type"+fluid_num)).innerText=disp_locn_type;
	eval(document.getElementById("per_facility_id"+fluid_num)).innerText=per_facility_id;
}
//Bru-HIMS-CRF-347 [IN:037862] -- End

function checkSameFluidMFR(fluid_code, rec_no){
	frmobj = document.formIVPrescriptionAdditives;
	var tmpFluidCode ="";
	var tmpMFR_YN ="";
	for(i=1; i<=6; i++){
		tmpFluidCode =  eval("frmobj.FLUID_CODE"+i).value;
		tmpMFR_YN =  eval("frmobj.mfr_yn"+i).value;
		if(tmpFluidCode!="" && tmpFluidCode == fluid_code && tmpMFR_YN=="Y" && i!=rec_no){
			return true;
		}
	}
	return false;
}

function checkForDuplicate( rec_no){
	frmobj = document.formIVPrescriptionAdditives;
	var	fluid_code =  eval("frmobj.FLUID_CODE"+rec_no).value;
	var tmpFluidCode ="";
	var tmpMFR_YN ="";
	for(i=1; i<=6; i++){
		tmpFluidCode =  eval("frmobj.FLUID_CODE"+i).value;
		tmpMFR_YN =  eval("frmobj.mfr_yn"+i).value;
		if(tmpFluidCode!="" && tmpFluidCode == fluid_code && i!=rec_no){
			return true;
		}
	}
	return false;
}

function calcTotalVolume(rec_no){//added for SKR-CRF-0035
	frmobj = document.formIVPrescriptionAdditives;
	var orderQty = eval('frmobj.order_qty'+rec_no).value;
	if(orderQty=="" ||  parseInt(orderQty)==0){
		alert(getMessage("PH_ORDER_QTY_BLANK","PH"));
		return false;
	}
	orderQty = parseInt(orderQty);
	var volumePerUnit = parseInt(eval('frmobj.volumePerUnit'+rec_no).value);
	var totalVolume = volumePerUnit*orderQty;
	eval('frmobj.volume'+rec_no).value = totalVolume;
	var END_DATEObj = eval('frmobj.END_DATE'+rec_no);
	var NextSTART_DATEObj = eval('frmobj.START_DATE'+(parseInt(rec_no)+1));
	var durnObj = eval('frmobj.DURATION'+rec_no);
	var volumeObj = eval('frmobj.volume'+rec_no);
	var INF_RATEObj = eval('frmobj.INF_RATE'+rec_no);
	var INFUSION_PERIOD_VALUEObj = eval('frmobj.INFUSION_PERIOD_VALUE'+rec_no);
	var infusionOverStrObj = eval('frmobj.infusionOverStr'+rec_no);
	setStockValue(volumeObj,rec_no);
	validateRate(INF_RATEObj,volumeObj,INFUSION_PERIOD_VALUEObj,durnObj,infusionOverStrObj,rec_no); 
	chkDurationAD(durnObj,rec_no);
	CalculateDateTime(END_DATEObj,NextSTART_DATEObj); 
	strtEndDateTime(rec_no);
}


//Added for AAKH-CRF-0094 start
function calVolumeInfuseRate(obj, volume1,infusion_rate,infusionOverStr,rec) {
	var frmobj = document.formIVPrescriptionAdditives;
	var iv_calc_infuse_by = frmobj.iv_calc_infuse_by.value ;
	if(iv_calc_infuse_by !='I'){
		volume1=eval(document.getElementById("volume_reference"+rec));
	}
	var infusion_over;
	var temp_volume;
	var total_volume;
    var volume_reference						= volume1.value;
	var INFUSION_PERIOD_VALUE		= eval("document.formIVPrescriptionAdditives.INFUSION_PERIOD_VALUE"+rec).value;
	var INFUSION_PERIOD_VALUE_MIN	=eval("document.formIVPrescriptionAdditives.INFUSION_PERIOD_VALUE_MIN"+rec).value;
	var InfuseOverInMin = getInfuseOverInMin(parseInt(INFUSION_PERIOD_VALUE),parseInt(INFUSION_PERIOD_VALUE_MIN));
	if(((INFUSION_PERIOD_VALUE == "" || parseFloat(INFUSION_PERIOD_VALUE) == 0) && (INFUSION_PERIOD_VALUE_MIN == "" || parseFloat(INFUSION_PERIOD_VALUE_MIN) == 0 || INFUSION_PERIOD_VALUE_MIN >59 ) )){
		
		alert(getMessage("INFS_OVR_CANT_BLANK_ZERO","PH"));
		 eval("document.formIVPrescriptionAdditives.INFUSION_PERIOD_VALUE"+rec).focus();
		
		
	}else if(infusion_rate.value == "" || infusion_rate.value == 0 ){
		
		alert(getMessage("INF_RATE_CANT_BLANK_ZERO","PH"));
		 eval("document.formIVPrescriptionAdditives.INF_RATE"+rec).focus();
		
		
	}
	else {
		var unit = eval("document.formIVPrescriptionAdditives.InfusionRateUnit"+rec).value;
		
		if (unit == "H") {
			var infusion_over_min = INFUSION_PERIOD_VALUE_MIN / 60;
				temp_volume = infusion_rate.value * (parseFloat(INFUSION_PERIOD_VALUE) + parseFloat(infusion_over_min));
			total_volume = (Math.ceil(temp_volume / volume_reference)) * volume_reference;
			//volume1.value = volume;
			eval("document.formIVPrescriptionAdditives.volume"+rec).value=total_volume;
			eval("document.formIVPrescriptionAdditives.volume"+rec).disabled=true;
			if(iv_calc_infuse_by == 'I'){eval("document.formIVPrescriptionAdditives.order_qty"+rec).value = Math.ceil(temp_volume / volume_reference);}
		} else {
			infusion_over = (INFUSION_PERIOD_VALUE * 60) + INFUSION_PERIOD_VALUE_MIN;
			temp_volume = Math.ceil((infusion_rate.value * infusion_over) / volume_reference);
			total_volume=temp_volume * volume_reference
			if(iv_calc_infuse_by == 'I'){eval("document.formIVPrescriptionAdditives.order_qty"+rec).value = temp_volume;}
			eval("document.formIVPrescriptionAdditives.volume"+rec).value= total_volume;
		}
		
		
	} 

	var str =   '['+Math.floor(INFUSION_PERIOD_VALUE) + ' Hrs ' + Math.round(INFUSION_PERIOD_VALUE_MIN) + ' Mins]' ;
	infusionOverStr.innerHTML	= str;
	stock_val	= eval("document.formIVPrescriptionAdditives.stock_value"+rec);
	base_volume = eval("document.formIVPrescriptionAdditives.base_volume"+rec);
	
    eval("document.formIVPrescriptionAdditives.infusion_over_insert_value"+rec).value = Math.ceil(InfuseOverInMin/60);
	eval("document.formIVPrescriptionAdditives.stock_value"+rec).value = total_volume;
	
	

	}
//Added for AAKH_CRF-0094 end 
//GHL-CRF-0549 - start
function enableAllowAlternate(allow_alternate_disabled,rec_no,allow_alternate_checked){
		eval(document.getElementById("allow_alternate"+rec_no)).style.visibility = 'visible';
		if(allow_alternate_checked=="checked"){
			eval(document.getElementById("allow_alternate_yn"+rec_no)).checked=true;
			eval(document.getElementById("allow_alternate_yn"+rec_no)).value="Y";
		}
		if(allow_alternate_disabled=="disabled"){
			eval(document.getElementById("allow_alternate_yn"+rec_no)).checked=false;
			eval(document.getElementById("allow_alternate_yn"+rec_no)).value="N";
		}
}

function setAllowAlternate(obj){

if(obj.checked==true)
	 obj.value = "Y";
else
	 obj.value = "N";

}//GHL-CRF-0549 - end

//Added for MMS-DM-CRF-0177
function setNewFluidName(new_generic_name)
{
	var frmObj = formIVPrescriptionAdditives;
	frmObj.new_generic_name.value =  decodeURIComponent(new_generic_name);//added for ML-BRU-SCF-2211
}
//Added for MMS-DM-CRF-0177
