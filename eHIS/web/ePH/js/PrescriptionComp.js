/*
--------------------------------------------------------------------------------------------------------------
Date			Edit History		Name		Rev.Date		Rev.Name				Description
--------------------------------------------------------------------------------------------------------------
04/09/2019      IN:071108		    Manickavasagam                                          ML-MMOH-CRF-1408
10/06/2020      IN072753           Prabha											   NMC-JD-CRF-0046
25/06/2020      IN:072715       Haribabu        25/06/2020     Manickavasagam     MMS-DM-CRF-0165
12/11/2020     IN:069887       Haribabu         13/11/2020     Manickavasagam     MO-CRF-20152
4/12/2020		    6041				Shazana						Manickam				NMC-JD-CRF-0063	
23/12/2020		11525				Shazana												NMC-JD-CRF-0063
--------------------------------------------------------------------------------------------------------------
*/
var rec_no;
var pres_vals	=	new Array();
var result		=   false ;
var message		=   "" ;
var flag		=   "" ;
var print_ord_sht_rule_ind="";//Added for Bru-HIMS-CRF-393_1.0
var formatId	=	"";
var function_id =	"" ;
var blError		=	false;
var PrescribingBase="S";

async function searchDrug(frmObj,searchBasedOn, obj,recno) {
	var drug_codes;
	
	//alert("recno-14-->"+recno);
	//alert("searchBasedOn-15-->"+searchBasedOn);
	//alert("obj-16-->"+obj.value);
	

	rec_no				=	recno;
	//alert("rec_no--20->"+rec_no);
	var frmObj			= document.prescription_compdetail_form;
	drug_codes			=	frmObj.drug_code1.value;
	//alert("frmObj.drug_code1.value==23==" +frmObj.drug_code1.value);
	//alert("drug_codes===24=" +drug_codes);
	if(frmObj.drug_code2.value!="") {
		drug_codes	+=","+frmObj.drug_code2.value;	
	}

	if(frmObj.drug_code3.value!="") {
		drug_codes	+=","+frmObj.drug_code3.value;	
	}
	if(frmObj.drug_code4.value!="") {
		drug_codes	+=","+frmObj.drug_code4.value;	
	}
	for(drno=5;drno<=10;drno++)
	{
		if(eval("frmObj.drug_code"+drno).value!="") 
		{
			drug_codes	+=","+eval("frmObj.drug_code"+drno).value;	
		}
	}
	//alert("drug_codes===42" +drug_codes);	
	var order_type_code				= parent.parent.f_header.document.prescription_header_form.order_type.value;	
	var service_search_yn			= parent.parent.f_header.document.prescription_header_form.service_search_yn.value;
	var servide_code				= parent.parent.f_header.document.prescription_header_form.servide_code.value;
	var pat_id						= parent.parent.f_header.document.prescription_header_form.patient_id.value;
	var enc_id						= parent.parent.f_header.document.prescription_header_form.encounter_id.value;
	var patient_class				= parent.parent.f_header.document.prescription_header_form.patient_class.value;
	var act_patient_class			= parent.parent.f_header.document.prescription_header_form.actual_patient_class.value;
	var discharge_yn				= parent.parent.f_header.document.prescription_header_form.take_home_medication.value;
	var priority					= parent.parent.f_header.document.prescription_header_form.priority.value;
	var source_code					= parent.parent.f_header.document.prescription_header_form.source_code.value;
	var source_type					= parent.parent.f_header.document.prescription_header_form.source_type.value;
	var drug_db_interface_yn        = parent.parent.f_header.document.prescription_header_form.drug_db_interface_yn.value;
   	var drug_db_dosecheck_yn        = parent.parent.f_header.document.prescription_header_form.drug_db_dosecheck_yn.value;
	var drug_db_duptherapy_yn       = parent.parent.f_header.document.prescription_header_form.drug_db_duptherapy_yn.value;
   	var drug_db_interact_check_yn   = parent.parent.f_header.document.prescription_header_form.drug_db_interact_check_yn.value;
  	var drug_db_contraind_check_yn  = parent.parent.f_header.document.prescription_header_form.drug_db_contraind_check_yn.value;
   	var drug_db_allergy_check_yn    = parent.parent.f_header.document.prescription_header_form.drug_db_allergy_check_yn.value;
	var drug_db_product_id			= parent.parent.f_header.document.prescription_header_form.drug_db_product_id.value;
	var date_of_birth				= parent.parent.f_header.document.prescription_header_form.date_of_birth.value;
	var gender						= parent.parent.f_header.document.prescription_header_form.gender.value;
	var pract_id					= parent.parent.f_header.document.prescription_header_form.pract_id.value;
	var resp_id						= parent.parent.f_header.document.prescription_header_form.resp_id.value;
	var iv_prep_yn					= '6';
	var adr_count					= parent.parent.f_header.document.prescription_header_form.adr_count.value;
	var bean_id						="DrugSearchBean"+pat_id+enc_id;
	var retArray					= await DrugSearchForPres("D",obj,order_type_code,drug_codes,bean_id,service_search_yn,servide_code,act_patient_class,priority,discharge_yn,pat_id,enc_id,date_of_birth,gender,source_type,source_code,"CO",iv_prep_yn,"","","","","Y");//Y added for GHL-CRF-0549
/*	if(parent.parent.f_header.document.prescription_header_form.take_home_medication_op_chk!=undefined)
	parent.parent.f_header.document.prescription_header_form.take_home_medication_op_chk.disabled=true;//commented for NMC-JD-CRF-0063*/
	//added for NMC-JD-CRF-0063 START
	if(parent.parent.f_header.document.prescription_header_form.take_home_medication_op_chk!=undefined){
		if(retArray.length==0 || retArray==""){
			if(parent.parent.f_header.document.prescription_header_form.take_home_medication_op_chk.disabled==false){
				parent.parent.f_header.document.prescription_header_form.take_home_medication_op_chk.disabled=false;
			}
		}
		else{
			parent.parent.f_header.document.prescription_header_form.take_home_medication_op_chk.disabled=true;
		}
	}//END
	var Drug_Codes	= new Array();
	var	Trade_Codes = new Array();
	var Trade_Names = new Array();
	var index		= 0;

	if (retArray != null && retArray != "" ){
		var drugCodes = "";
		var selected_drug_code ="";

		for(var i=0;i<retArray.length;i=i++){
			drugCodes+=	retArray[i];
			drugCodes += ",";
			selected_drug_code=retArray[i];//added newly for compounding Rx regarding loading duplicate drug in chargedetila window==By Naveen
			Drug_Codes[index]=retArray[i++];
			Trade_Codes[index]=retArray[i++];
			Trade_Names[index++]=retArray[i++];
		}
//alert("@@@@@86===selected="+selected_drug_code+"===old===="+eval("frmObj.drug_code"+recno).value);
//added newly for compounding Rx regarding loading duplicate drug in chargedetila window==By Naveen==From line num:90 to 95 on 11/JAN/2011.
      var old_drug_code= eval("frmObj.drug_code"+recno).value;
      if(old_drug_code!='' && old_drug_code!=selected_drug_code){
		 // alert("===indise---1");
           deleteDrug(obj,recno, "DRUGSELECT");
		  //  alert("===indise---2");
	  }


		var bean_id		= bean_id;
		//alert("bean_id---->"+bean_id);
		var bean_name	= "";
		parent.f_compound_title.formPrescriptionCompTitle.drug_codes.value	= retArray;
		patient_id=frmObj.patient_id.value;
		encounter_id=frmObj.encounter_id.value;
		var startdate	= 	frmObj.start_date.value; // Added for ML-BRU-SCF-0811 [IN:039394]
		var enddate		= 	frmObj.end_date.value; // Added for ML-BRU-SCF-0811 [IN:039394]
		if(Trade_Codes.length==0)
		   Trade_Codes="";
		 if(Trade_Names.length==0)
		   Trade_Names="";
		 if(Drug_Codes.length==0)
		   Drug_Codes="";

		   //alert("Trade_Codes.length--->"+Trade_Codes.length);
		  // alert("Trade_Names.length--->"+Trade_Names.length);
		   //alert("Trade_Codes--->"+Trade_Codes);
		   //alert("Trade_Names--->"+Trade_Names);
		//var qryString	= "&drugCodes="+drugCodes+"&patient_id="+frmObj.patient_id.value+"&encounter_id="+frmObj.encounter_id.value+"&drug_db_interface_yn="+drug_db_interface_yn+"&drug_db_dosecheck_yn="+drug_db_dosecheck_yn+"&drug_db_duptherapy_yn="+drug_db_duptherapy_yn+"&drug_db_interact_check_yn="+drug_db_interact_check_yn+"&drug_db_contraind_check_yn="+drug_db_contraind_check_yn+"&drug_db_allergy_check_yn="+drug_db_allergy_check_yn+"&drug_db_product_id="+drug_db_product_id+"&Trade_Codes="+Trade_Codes+"&Trade_Names="+Trade_Names+"&adr_count="+adr_count+"&pract_id="+pract_id+"&resp_id="+resp_id;
		 //alert("qryString---->"+qryString);


			var xmlStr		= "<root><SEARCH ";
			xmlStr			+= " drugCodes=\""+ drugCodes + "\" ";
			xmlStr			+= " patient_id=\""+ patient_id + "\" ";
			xmlStr			+= " encounter_id=\""+ encounter_id + "\" "; 
			xmlStr			+= " drug_db_interface_yn=\""+ drug_db_interface_yn + "\" ";
			xmlStr			+= " drug_db_dosecheck_yn=\""+ drug_db_dosecheck_yn + "\" ";
			xmlStr			+= " drug_db_duptherapy_yn=\""+ drug_db_duptherapy_yn + "\" ";
			xmlStr			+= " drug_db_interact_check_yn=\""+ drug_db_interact_check_yn + "\" ";
			xmlStr			+= " drug_db_contraind_check_yn=\""+ drug_db_contraind_check_yn + "\" ";
			xmlStr			+= " drug_db_allergy_check_yn=\""+ drug_db_allergy_check_yn + "\" ";
			xmlStr			+= " drug_db_product_id=\""+ drug_db_product_id + "\" ";
			xmlStr			+= " Trade_Codes=\""+ Trade_Codes + "\" ";
			xmlStr			+= " Trade_Names=\""+ Trade_Names + "\" ";
			xmlStr			+= " adr_count=\""+ adr_count + "\" ";
			xmlStr			+= " pract_id=\""+ pract_id + "\" ";
			xmlStr			+= " resp_id=\""+ resp_id + "\" ";
			xmlStr			+= " act_patient_class=\""+ act_patient_class + "\" ";    // RUT-CRF-0062 [IN029600] Added to get Build MAR Rule
			xmlStr			+= " priority=\""+ priority + "\" ";					// RUT-CRF-0062 [IN029600] Added to get Build MAR Rule
			xmlStr			+= " source_code=\""+ source_code + "\" ";				// RUT-CRF-0062 [IN029600] Added to get Build MAR Rule
			xmlStr			+= " take_home_medication=\""+ discharge_yn + "\" ";	 // RUT-CRF-0062 [IN029600] Added to get Build MAR Rule
			xmlStr 			+= " startdate=\""+ startdate + "\" ";	// Added for ML-BRU-SCF-0811 [IN:039394]
			xmlStr 			+= " enddate=\""+ enddate + "\" ";	// Added for ML-BRU-SCF-0811 [IN:039394]
			xmlStr			+= " recno=\""+ recno + "\" ";
			xmlStr			+=  " /></root>";	

		   //window.prompt("suri",xmlStr);

		//	submitXML(qryString, xmlStr);
			 var qryString			= bean_id+"&bean_name="+bean_name+"&validate=DRUGCODE";
			 submitXML(qryString, xmlStr,"");	

		//submitXML(qryString, "");
	}
}

function submitXML(qryString, xmlStr,eval_yn) {
	var xmlDoc = ""; 
	var xmlHttp = new XMLHttpRequest();
	if (xmlStr != "")
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
    xmlHttp.open("POST", "PrescriptionCompValidate.jsp?bean_id="+qryString, false);
	xmlHttp.send(xmlDoc);
	responseText = xmlHttp.responseText;
//alert(responseText);
	eval(responseText);
}

function assignDosageDetails(drug_code,drug_desc,strength,strength_uom,strength_uom_need,dosage,dosage_uom,form_desc,stock_uom,pres_base_uom,pres_base_uom_need,external_prod_id,perform_ext_db_checks,drug_class, generic_id, generic_name){	

	var frmObj						=   document.prescription_compdetail_form;
	drug_obj						=	eval("document.prescription_compdetail_form.drug_name"+rec_no);
	drug_code_obj					=	eval("document.prescription_compdetail_form.drug_code"+rec_no);
    external_prod_id_obj			=	eval("document.prescription_compdetail_form.external_prod_id_"+rec_no);
    Perform_ext_db_checks_obj		=	eval("document.prescription_compdetail_form.Perform_ext_db_checks_YN"+rec_no);

	strength_obj					=	document.getElementById("strength"+rec_no);
	form_obj						=	document.getElementById("form"+rec_no);
	stockuom_obj					=	document.getElementById("qty"+rec_no);
	remarks_obj						=	document.getElementById("remarks_"+rec_no);
	drugInd_obj						=	document.getElementById("drug_ind_remarks_"+rec_no);
	drug_obj.value					=	decodeURIComponent(drug_desc,"UTF-8") ;
	drug_code_obj.value				=   drug_code;	
	eval("document.prescription_compdetail_form.drug_class"+rec_no).value = drug_class;
	external_prod_id_obj.value		=	external_prod_id;
	Perform_ext_db_checks_obj.value	=	perform_ext_db_checks;
   
   var drug_db_interface_yn     = parent.parent.f_header.document.prescription_header_form.drug_db_interface_yn.value;

	if(external_prod_id!="" && drug_db_interface_yn=="Y"){
		drug_info_obj	=	document.getElementById("drug_info_"+rec_no);
		drug_info_obj.style.visibility="visible";
	}

	if(drug_obj != null && drug_obj.value != ""){
		eval("document.prescription_compdetail_form.edl_info_"+rec_no).style.visibility="visible";
	}

    eval("document.prescription_compdetail_form.strength_uom"+rec_no).value=strength_uom;
	eval("document.prescription_compdetail_form.strength_uom_need"+rec_no).value=strength_uom_need;//Modified for CRF--0749
	eval("document.prescription_compdetail_form.pres_base_uom"+rec_no).value=pres_base_uom;
	eval("document.prescription_compdetail_form.pres_base_uom_need"+rec_no).value=pres_base_uom_need;//Modified for CRF--0749
	eval("document.prescription_compdetail_form.generic_id"+rec_no).value=generic_id;
	eval("document.prescription_compdetail_form.generic_name"+rec_no).value=generic_name;
	if(strength!="" && strength!="0") { 
		strength_obj.innerText	=strength+" "+strength_uom_need;//strength_uom//Modified for CRF--0749
	}
	form_obj.innerText		=form_desc;
	stockuom_obj.innerText	=pres_base_uom_need;//pres_base_uom;//Modified for CRF--0749
	remarks_obj.style.visibility='visible';
	drugInd_obj.style.visibility='visible';
	if(PrescribingBase=="S"){
		if(strength_uom != "" && strength_uom != undefined){
			var len =document.prescription_compdetail_form.uom.options.length;
			for(var i=0;i<len;i++) {
				document.prescription_compdetail_form.uom.remove("uom") ;
			}
			for(var i =1;i<=10 ;i++){

				if(	eval("document.prescription_compdetail_form.strength_uom"+i).value !=""){
					var len1 =document.prescription_compdetail_form.uom.options.length;
					foundflag=false;
					for(var k=0;k<len1;k++) {
							var tempUOMVal=document.prescription_compdetail_form.uom.options[k].value;//text Modified crf-749;		
							//alert("tempUOMVal--->"+tempUOMVal);	
							if(tempUOMVal==(eval("document.prescription_compdetail_form.strength_uom"+i).value))
						    {
								foundflag=true;
								break;
							}
					}					
					if(!foundflag)
					{
						var element = document.createElement('OPTION') ;
							element.value		= (eval("document.prescription_compdetail_form.strength_uom"+i).value);// i ;modified CRF-749
						element.text		=  (eval("document.prescription_compdetail_form.strength_uom_need"+i).value)+"            ";
						frmObj.uom.add(element);
						frmObj.uom.selectedIndex= 0 ;
					}
				}
			}
			}else{ 
			var drug_count =0;
			var str_count = 0;

			/*if(frmObj.drug_code1.value !="") drug_count+=1;
			if(frmObj.drug_code2.value !="") drug_count+=1;
			if(frmObj.drug_code3.value !="") drug_count+=1;
			if(frmObj.drug_code4.value !="") drug_count+=1;*/
			for(dcno=1;dcno<=10;dcno++)
			{
				if(eval("frmObj.drug_code"+dcno).value !="") drug_count+=1;
			}

			/*if(frmObj.strength_uom1.value !="") str_count+=1;
			if(frmObj.strength_uom2.value !="") str_count+=1;
			if(frmObj.strength_uom3.value !="") str_count+=1;
			if(frmObj.strength_uom4.value !="") str_count+=1;*/
			for(dcno=1;dcno<=10;dcno++)
			{
				if(eval("frmObj.strength_uom"+dcno).value !="") str_count+=1;
			}

			if(drug_count>1 && str_count =="0" ){
				var len =document.prescription_compdetail_form.uom.options.length;
				for(var i=0;i<len;i++) {
					document.prescription_compdetail_form.uom.remove("uom") ;
				}
				for(var i =1;i<=10 ;i++){
					if(	eval("document.prescription_compdetail_form.pres_base_uom"+i).value !=""){
						var len1 =document.prescription_compdetail_form.uom.options.length;
						foundflag=false;
						for(var k=0;k<len1;k++) {
							var tempUOMVal=document.prescription_compdetail_form.uom.options[k].value;//text Modified for crf-749;							
							if(tempUOMVal==(eval("document.prescription_compdetail_form.pres_base_uom"+i).value))
						    {
								foundflag=true;
								break;
							}
						}
						if(!foundflag)
						{
							var element = document.createElement('OPTION') ;
							//element.value		=  rec_no Modified for CRF-0749;
							element.value		=(eval("document.prescription_compdetail_form.pres_base_uom"+i).value);
							element.text		=  (eval("document.prescription_compdetail_form.pres_base_uom_need"+i).value)+"            ";
							frmObj.uom.add(element);
							frmObj.uom.selectedIndex= 0 ;
						}
					}
				}
			 }
		}
	}
	getRemarks(rec_no,'N');
}

function overrideImg(allergy_yn,allergy_override,limit_ind,dose_override,current_rx,currentrx_override,calledFrom,ext_yn,ext_override,adr_yn,adr_override,max_daily_celing_dose,min_daily_ceiling_dose,max_unit_ceiling_dose,min_unit_ceiling_dose){
//modified for ML-MMOH-CRF-1408
	if(calledFrom == 'BLERROR'){
		var docObj			= parent.f_compound_detail.document;
	}
	else{
		var docObj			= document;
	}

	allergy = eval("docObj.allergy_"+rec_no);
	allergy_img = eval("docObj.allergy_img"+rec_no);
	dosage = eval("docObj.dosage_"+rec_no);
	dosage_img = eval("docObj.dosage_img"+rec_no);
	currentrx = eval("docObj.currentrx_"+rec_no);	
	currentrx_img = eval("docObj.currentrx_img"+rec_no);
	if(ext_yn=="undefined"||ext_override=="undefined"){
		ext_yn="N";
		ext_override="N";
	}
	if(adr_yn=="undefined"||adr_override=="undefined"){
		adr_yn="N";
		adr_override="N";
	}
	var ADR = eval("docObj.ADR_"+rec_no);
	var ADR_img = eval("docObj.ADR_img_"+rec_no);
	var external = eval("docObj.external_"+rec_no);
	var external_img = eval("docObj.external_img"+rec_no);

	if(allergy_yn == "Y"){
		allergy.style.visibility='visible';
		if(allergy_override == "Y"){
			allergy_img.style.visibility='hidden';
		}
		else{
			allergy_img.style.visibility='visible';
		}
	 }
	 else{
		allergy.style.visibility='hidden';
		allergy_img.style.visibility='hidden';
	 }
	if(limit_ind == "N"){
		dosage.style.visibility='visible';
		if(dose_override == "Y"){
			dosage_img.style.visibility='hidden';

		}
		else{
			dosage_img.style.visibility='visible';
		}
	}
	else{
		dosage.style.visibility='hidden';
		dosage_img.style.visibility='hidden';
	}
	if(current_rx == "Y"){
		currentrx.style.visibility='visible';
		if(currentrx_override == "Y"){
			currentrx_img.style.visibility='hidden';
		}
		else{
			currentrx_img.style.visibility='visible';
		}
	}
	else{
		currentrx.style.visibility='hidden';	
		currentrx_img.style.visibility='hidden';
	}
	if(ext_yn== "Y"){
		external.style.visibility='visible';
		if(ext_override == "Y"){
			external_img.style.visibility='visible';			
		}
		else{
			external_img.style.visibility='hidden';
		}
	}
	else{
		external.style.visibility='hidden';
		external_img.style.visibility='hidden';
	}
	if(adr_yn== "Y"){
		ADR.style.visibility='visible';
		if(adr_override == "Y"){
			ADR_img.style.visibility='visible';			
		}
		else{
		   ADR_img.style.visibility='hidden';
		}
	}
	else{
		ADR.style.visibility='hidden';
		ADR_img.style.visibility='hidden';
	}		
	eval("docObj.dosage_limit"+rec_no).style.visibility='visible';
	if(current_rx== "Y"){
		eval("docObj.chk_ovr"+rec_no).style.visibility='visible';
	}
}

function populateDurationDesc(obj){
	
	var freq_code		=	obj.value;
	var patient_class	=	parent.parent.f_header.document.prescription_header_form.patient_class.value;
	var frmObj			=	parent.parent.f_header.document.prescription_header_form;

	if(patient_class=="IP"){
		if(parent.parent.f_header.document.prescription_header_form.take_home_medication.value=="Y")
			patient_class="OP";
	}

	var qryString	= frmObj.bean_id.value+"&bean_name="+frmObj.bean_name.value+"&validate=populateDurationDesc&freq_code="+freq_code+"&patient_id="+frmObj.patient_id.value+"&encounter_id="+frmObj.encounter_id.value+"&patient_class="+patient_class;
	submitXML(qryString, "");
}


function assignDurnDesc(repeat_value,repeat_durn_type,freq_nature,interval_value,durn_desc,freq_value,schedule_yn){
	var frmObj=parent.f_compound_detail.document.prescription_compdetail_form;
	var docObj= parent.f_compound_detail.document;
	var len =frmObj.durn_type_desc.options.length;
	for(var i=0;i<len;i++) {
		frmObj.durn_type_desc.remove("durn_type_desc") ;
	}
	if(repeat_durn_type=="L"){
		//document.getElementById("durn_desc").innerHTML="<b>Month(s)</b>";		
		frmObj.durn_type.value	=	repeat_durn_type;
		var element = docObj.createElement('OPTION') ;
		element.value		=  repeat_durn_type ;
		element.text		=  "Month(s)";
		frmObj.durn_type_desc.add(element);
		var element = docObj.createElement('OPTION') ;
		element.value		=  "Y";
		element.text		=  "Year(s)";
		frmObj.durn_type_desc.add(element);

		frmObj.durn_type_desc.selectedIndex= 0 ;
	} 
	else if(repeat_durn_type=="W"){
		//document.getElementById("durn_desc").innerHTML="<b>Week(s)</b>";
		frmObj.durn_type.value	=	repeat_durn_type;
		var element = docObj.createElement('OPTION') ;
		element.value		=  repeat_durn_type ;
		element.text		=  "Week(s)";
		frmObj.durn_type_desc.add(element);
		var element = docObj.createElement('OPTION') ;
		element.value		=  "L" ;
		element.text		=  "Month(s)";
		frmObj.durn_type_desc.add(element);
		var element = docObj.createElement('OPTION') ;
		element.value		=  "Y";
		element.text		=  "Year(s)";
		frmObj.durn_type_desc.add(element);
		frmObj.durn_type_desc.selectedIndex= 0 ;
	} 
	else if(repeat_durn_type=="D"){
		//document.getElementById("durn_desc").innerHTML="<b>Day(s)</b>";
		frmObj.durn_type.value	=	repeat_durn_type;
		var element = docObj.createElement('OPTION') ;
		element.value		=  repeat_durn_type ;
		element.text		=  "Day(s)";
		frmObj.durn_type_desc.add(element);
		var element = docObj.createElement('OPTION') ;
		element.value		=  "W" ;
		element.text		=  "Week(s)";
		frmObj.durn_type_desc.add(element);
		var element = docObj.createElement('OPTION') ;
		element.value		=  "L" ;
		element.text		=  "Month(s)";
		frmObj.durn_type_desc.add(element);
		var element = docObj.createElement('OPTION') ;
		element.value		=  "Y";
		element.text		=  "Year(s)";
		frmObj.durn_type_desc.add(element);
		frmObj.durn_type_desc.selectedIndex= 0 ;
	} 
	else if(repeat_durn_type=="H"){
		//document.getElementById("durn_desc").innerHTML="<b>Days(s)</b>";
		//document.prescription_compdetail_form.durn_value.value="1";
		frmObj.durn_type.value	=	repeat_durn_type;
		var element = docObj.createElement('OPTION') ;
		element.value		=  repeat_durn_type ;
		element.text		=  "Hour(s)";
		frmObj.durn_type_desc.add(element);
		var element = docObj.createElement('OPTION') ;
		element.value		=  "D" ;
		element.text		=  "Day(s)";
		frmObj.durn_type_desc.add(element);
		var element = docObj.createElement('OPTION') ;
		element.value		=  "W" ;
		element.text		=  "Week(s)";
		frmObj.durn_type_desc.add(element);

		frmObj.durn_type_desc.selectedIndex= 0 ;
	} 
	else if(repeat_durn_type=="M"){
		//document.getElementById("durn_desc").innerHTML="<b>Day(s)</b>";
		//document.prescription_compdetail_form.durn_value.value="1";
		frmObj.durn_type.value	=	repeat_durn_type;
		var element = docObj.createElement('OPTION') ;
		element.value		=  repeat_durn_type ;
		element.text		=  "Minute(s)";
		frmObj.durn_type_desc.add(element);
		var element = docObj.createElement('OPTION') ;
		element.value		=  "H" ;
		element.text		=  "Hour(s)";
		frmObj.durn_type_desc.add(element);
		var element = docObj.createElement('OPTION') ;
		element.value		=  "D" ;
		element.text		=  "Day(s)";
		frmObj.durn_type_desc.add(element);
		var element = docObj.createElement('OPTION') ;
		element.value		=  "W" ;
		element.text		=  "Week(s)";
		frmObj.durn_type_desc.add(element);

		frmObj.durn_type_desc.selectedIndex= 0 ;
	}

	if(repeat_durn_type!=null && repeat_durn_type!="null" && repeat_durn_type!="") {
		frmObj.durn_type.value	=	repeat_durn_type;
	}  
	else {
		frmObj.durn_type.value	=	"D";
		//document.getElementById("durn_desc").innerHTML="<b>Day(s)</b>";
		frmObj.durn_value.value="1";
		
		var element = docObj.createElement('OPTION') ;
		element.value		=  "D"; //replaced repeat_durn_type with "D" for IN2487  --19/10/2010-- priya
		element.text		=  "Day(s)";
		frmObj.durn_type_desc.add(element);
		var element = docObj.createElement('OPTION') ;
		element.value		=  "W" ;
		element.text		=  "Week(s)";
		frmObj.durn_type_desc.add(element);
		var element = docObj.createElement('OPTION') ;
		element.value		=  "L" ;
		element.text		=  "Month(s)";
		frmObj.durn_type_desc.add(element);
		var element = docObj.createElement('OPTION') ;
		element.value		=  "Y";
		element.text		=  "Year(s)";
		frmObj.durn_type_desc.add(element);
		frmObj.durn_type_desc.selectedIndex= 0 ;

	}
	document.prescription_compdetail_form.freq_nature.value	=	freq_nature;
	//frmObj.durn_type_desc.disabled=true;
	populateEndDate();
}

function populateEndDate(){
		var frmObj			=	document.prescription_compdetail_form;
		var freq_nature		=	document.prescription_compdetail_form.freq_nature.value;
		var start_date		=	document.prescription_compdetail_form.start_date.value;
		var durn_value		=	document.prescription_compdetail_form.durn_value.value;
		//var repeat_durn_type=	document.prescription_compdetail_form.durn_type.value;
		var repeat_durn_type=	document.prescription_compdetail_form.durn_type_desc.value;
		//alert("repeat_durn_type="+repeat_durn_type);
		if(repeat_durn_type=="")
			repeat_durn_type="D";				
		var bean_id		=	"DUMMY";
		var bean_name	=	"DUMMY";
		if(trimString(start_date)!="" && durn_value!="" && durn_value!="0") {
			var qryString	= bean_id+"&bean_name="+bean_name+"&validate=POPULATEENDDATE&start_date="+start_date+"&patient_id="+frmObj.patient_id.value+"&encounter_id="+frmObj.encounter_id.value+"&durn_value="+durn_value+"&durn_unit="+repeat_durn_type+"&freq_nature="+freq_nature;
			submitXML(qryString, "");
		}
}

function validateDuration(obj){		
		if(parseInt(obj.value)==0 || obj.value=="") {
			alert(getMessage("PRES_DURN_CANNOT_ZERO","PH")); 
			//obj.focus();
			return;
		}
		var flag = false;
		var discharge_yn	= parent.parent.f_header.document.prescription_header_form.take_home_medication.value;
		patient_class = document.prescription_compdetail_form.patient_class.value;
		var durn_type_desc = document.prescription_compdetail_form.durn_type_desc.value;
		buttonForm = parent.f_compound_button.formIVPrescriptionButtons;
		var objValue=obj.value;
		if(durn_type_desc=="W")
				objValue=parseInt(objValue)*7;
		else if(durn_type_desc=="L")
				objValue=parseInt(objValue)*30;
		else if(durn_type_desc=="Y")
				objValue=parseInt(objValue)*365;
		else if(durn_type_desc=="H")
				objValue=Math.ceil(parseInt(objValue)/24);
		else if(durn_type_desc=="M")
				objValue=Math.ceil(parseInt(objValue)/(24*60));
		//alert(objValue);
		max_durn_for_ip_pres = buttonForm.MAX_DURN_FOR_IP_PRES.value;
		max_durn_for_op_pres = buttonForm.MAX_DURN_FOR_OP_PRES.value;
		max_durn_for_dm_pres = buttonForm.MAX_DURN_FOR_DM_PRES.value;
		
		var disp_durn = ""; 

		if(discharge_yn == "Y" && parseInt(objValue) > parseInt(max_durn_for_dm_pres)){
			disp_durn = " - "+parseInt(max_durn_for_dm_pres)+" "+getLabel("Common.days.label","Common");
			flag = true;
		}
		else{
			if(patient_class == "IP" && parseInt(objValue) > parseInt(max_durn_for_ip_pres)){
				disp_durn = " - "+parseInt(max_durn_for_ip_pres)+" "+getLabel("Common.days.label","Common");
				flag = true;
			}
			if(patient_class == "OP" && parseInt(objValue) > parseInt(max_durn_for_op_pres)){
				disp_durn = " - "+parseInt(max_durn_for_op_pres)+" "+getLabel("Common.days.label","Common");
				flag = true;
			}
		}

		if(flag){
			alert(getMessage("PH_MAX_DURN", "PH")+disp_durn);
			document.prescription_compdetail_form.durn_type_desc.selectedIndex=0;
			obj.focus();
			return false;
		}
		
}

function setEndDate(end_date) {
	document.prescription_compdetail_form.end_date.value	=	end_date;
}

function assignResult(_result, _message, _flag, _print_ord_sht_rule_ind) {//print_ord_sht_rule_ind Added for Bru-HIMS-CRF-393_1.0
	result	= _result;
	message	= _message;
	flag	= _flag;
	print_ord_sht_rule_ind=_print_ord_sht_rule_ind;
}

async function releaseRX() {
	  
	var frmobj	                        = parent.f_compound_detail.document.prescription_compdetail_form;	
	var headerForm                      = parent.parent.f_header.document.prescription_header_form;
	var mode                            = frmobj.mode.value
	var bl_install_yn		            = headerForm.bl_install_yn.value;
	var bl_disp_charge_dtl_in_rx_yn		= headerForm.bl_disp_charge_dtl_in_rx_yn.value;
	var discharge_yn				    = headerForm.take_home_medication.value;
	var buttonform = parent.f_compound_button.formIVPrescriptionButtons;//added for NMC-JD-CRF-0063
	if(mode == 'amend'){
		if (chkMandatoryFlds("amend")) {

		  var dosage          = frmobj.dosage.value;
		  var patient_id	  = frmobj.patient_id.value;
		  var encounter_id	  = frmobj.encounter_id.value;
		  var freq_code		  = frmobj.frequency.value;
		  var durn_value	  = frmobj.durn_value.value;
		  var durn_type		  = frmobj.durn_type.value;
		  var start_date	  = frmobj.start_date.value;
		  var end_date		  = frmobj.end_date.value;
		  var ord_qty1		  = frmobj.absol_qty1.value;
		  var ord_qty2		  = frmobj.absol_qty2.value;
		  var ord_qty3		  = frmobj.absol_qty3.value;
		  var ord_qty4		  = frmobj.absol_qty4.value;
		  //Added for  ML-BRU-CRF-072[Inc:29938] Start
		  var DrugIndicationRemarks1=frmobj.DrugIndicationRemarks_1.value;
		  var DrugIndicationRemarks2=frmobj.DrugIndicationRemarks_2.value;
		  var DrugIndicationRemarks3=frmobj.DrugIndicationRemarks_3.value;
		  var DrugIndicationRemarks4=frmobj.DrugIndicationRemarks_4.value
		  //Added for  ML-BRU-CRF-072[Inc:29938] End
		  var order_id        = frmobj.order_id.value;
		  var bean_id         = frmobj.bean_id.value;   
		  var bean_name       = frmobj.bean_name.value;
		  var drug_code1	  = frmobj.drug_code1.value;
		  var drug_code2	  = frmobj.drug_code2.value;
		  var drug_code3	  = frmobj.drug_code3.value;
		  var drug_code4	  = frmobj.drug_code4.value;
  		  var no_of_drugs	  = frmobj.no_of_drugs.value;
		  var act_patient_class = frmobj.act_patient_class.value; 
		  var drug_codes	  =	"";
		  var amnd_drg_code   = "";
	
		  if(drug_code1!="") {
		    drug_codes	+=drug_code1+",";	
			if(amnd_drg_code == ""){amnd_drg_code = drug_code1}
		  }
		  if(drug_code2!="") {
		    drug_codes	+=drug_code2+",";	
			if(amnd_drg_code == ""){amnd_drg_code = drug_code2}
		  }
		  if(drug_code3!="") {
		    drug_codes	+=drug_code3+",";	
			if(amnd_drg_code == ""){amnd_drg_code = drug_code3}
		  }
		  if(drug_code4!="") {
		    drug_codes	+=drug_code4+",";	
			if(amnd_drg_code == ""){amnd_drg_code = drug_code4}
		  }

		  var patient_class	=	parent.parent.f_header.document.prescription_header_form.patient_class.value;
			
		  var allergic_yn ="N";

		  var external_dosage_override_reason1		= frmobj.external_dosage_override_reason1.value;
		  var external_dosage_override_reason2		= frmobj.external_dosage_override_reason2.value;
		  var external_dosage_override_reason3		= frmobj.external_dosage_override_reason3.value;
		  var external_dosage_override_reason4		= frmobj.external_dosage_override_reason4.value;
 
          var allow_yn="Y" ;
		  for(i=1;i<=4;i++){

			  dose_chk_flag =eval("parent.f_compound_detail.document.prescription_compdetail_form.external_db_dose_check_"+i).value;
			  dose_reason   =eval("parent.f_compound_detail.document.prescription_compdetail_form.external_dosage_override_reason"+i).value;
			  if(dose_chk_flag=='Y'&& dose_reason!=""){
					allow_yn  ="Y";
					break;
			  }
		  }

          if(allow_yn=="Y"){
				  var xmlStr		= "<root><SEARCH ";
					xmlStr			+= " patient_id=\""+ patient_id + "\" ";
					xmlStr			+= " encounter_id=\""+ encounter_id + "\" ";
					xmlStr			+= " act_patient_class=\""+ act_patient_class + "\" "; 
					xmlStr			+= " freq_code=\""+ freq_code + "\" ";
					xmlStr			+= " durn_value=\""+ durn_value + "\" ";
					xmlStr			+= " durn_type=\""+ durn_type + "\" ";
					xmlStr			+= " dosage=\""+ dosage + "\" ";
					xmlStr			+= " start_date=\""+ start_date + "\" ";
					xmlStr			+= " end_date=\""+ end_date + "\" ";
					xmlStr			+= " ord_qty1=\""+ ord_qty1 + "\" ";
					xmlStr			+= " ord_qty2=\""+ ord_qty2 + "\" ";
					xmlStr			+= " ord_qty3=\""+ ord_qty3 + "\" ";
					xmlStr			+= " ord_qty4=\""+ ord_qty4 + "\" ";
					//Added for  ML-BRU-CRF-072[Inc:29938] Start
					xmlStr			+= " DrugIndicationRemarks1=\""+ DrugIndicationRemarks1 + "\" ";
					xmlStr			+= " DrugIndicationRemarks2=\""+ DrugIndicationRemarks2 + "\" ";
					xmlStr			+= " DrugIndicationRemarks3=\""+ DrugIndicationRemarks3 + "\" ";
					xmlStr			+= " DrugIndicationRemarks4=\""+ DrugIndicationRemarks4 + "\" ";
					//Added for  ML-BRU-CRF-072[Inc:29938] End
					xmlStr			+= " order_id=\""+ order_id + "\" ";
					xmlStr			+= " allergic_yn=\""+ allergic_yn + "\" ";	
					xmlStr			+= " no_of_drugs=\""+ no_of_drugs + "\" ";	
					xmlStr			+= " drug_codes=\""+ drug_codes + "\" ";
					xmlStr			+= " amnd_drg_code=\""+ amnd_drg_code + "\" ";
					xmlStr			+= " mode=\""+ mode + "\" ";
					xmlStr			+= " external_dosage_override_reason1=\""+ external_dosage_override_reason1 + "\" ";
					xmlStr			+= " external_dosage_override_reason2=\""+ external_dosage_override_reason2 + "\" ";
					xmlStr			+= " external_dosage_override_reason3=\""+ external_dosage_override_reason3 + "\" ";
					xmlStr			+= " external_dosage_override_reason4=\""+ external_dosage_override_reason4 + "\" ";
					xmlStr			+= " discharge_yn=\""+ discharge_yn + "\" ";
					xmlStr			+=  " /></root>";
		//	submitXML(qryString, xmlStr);
				
				 var qryString			= bean_id+"&bean_name="+bean_name+"&validate=AMEND_RELEASE";

				 submitXML(qryString, xmlStr);
		
			if (result) {
					var xmlStr ="<root><SEARCH ";
					xmlStr += " patient_id=\""+ patient_id + "\" ";
					xmlStr += " encounter_id=\""+ encounter_id + "\" ";
					xmlStr += " patient_class =\"" + act_patient_class + "\" " ;

					if (confirm(getMessage("PH_PRINT_PRESCRIPTION","PH"))) {
							xmlStr+= "print_yn='Y'" ;
					} else {
							xmlStr+= "print_yn='N'" ;
					}
					xmlStr +=" /></root>";
					
					var temp_jsp="PrescriptionCompValidate.jsp?validate=PRINT&bean_id="+bean_id+"&bean_name="+bean_name;
					var xmlDoc = "" ;
					var xmlHttp = new XMLHttpRequest() ;
					xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
					xmlHttp.open("POST",temp_jsp,true);
					xmlHttp.send(xmlDoc);
					
					//window.close();
					
				    const dialogTag = parent.parent.document.getElementById("dialog_tag");    
				    dialogTag.close();  
				} else if(flag=="INSUFFICIENT_STOCK") {
						iv_bean_id		= "IVPrescriptionBean"+patient_id+encounter_id;
						iv_bean_name	= "ePH.IVPrescriptionBean";

					var dialogHeight	= "32vh";
					var dialogWidth		= "45vw";
					var dialogTop		= "250";
					var dialogLeft		= "40";
					var center			= "0";
					var status			= "no";
					var features		= "dialogHeight:" + dialogHeight +"; dialogLeft:"+dialogLeft+ "; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop;
					var arguments		= "";
					retVal 				= await window.showModalDialog("../../ePH/jsp/IVPrescriptionStockDetails.jsp?bean_id="+iv_bean_id+"&bean_name="+iv_bean_name+"&called_from=COMP",arguments,features);
				}

		}else{

			alert(getMessage("PLS_GVE_OVRD_RSN","PH"));
		}

	  }
	}
	else{ 
		var patient_class	=	parent.parent.f_header.document.prescription_header_form.patient_class.value;//added for NMC-JD-CRF-0063 START
		var disp_locn = "";
		if(patient_class=="OP"){
			disp_locn=	parent.f_compound_button.document.getElementById('dflt_disp_locn_lbl').innerText ; 
			disp_locn = disp_locn.replace(/\s+/g, "");  //added for NMC-JD-CRF-0063 [13355]  
			if(disp_locn=="" || disp_locn==null)
			{
				alert(getMessage("PH_MANDATORY", "PH"));
				return false;
			}
		}//END
		if (chkMandatoryFlds("Release")) {
			
			if(bl_install_yn=="Y" && bl_disp_charge_dtl_in_rx_yn=="Y"){
				blError = false;
				getBLErrorDrugs();
				if(blError){
					return false;
				}
			}
			var PresByBase="S";
			for(inum=0;inum<3;inum++)
			{
				if(frmobj.pres_by[inum].checked)
						PresByBase=frmobj.pres_by[inum].value;	
			}
			if(PresByBase=='P')  //checking Base drug selection while Percentage base
			{
				
				var tmpBaseDrug="";
				for(ino=1;ino<10;ino++)
				{				
					if(frmobj.baseDrug[ino].checked)
						tmpBaseDrug=frmobj.baseDrug[ino].value;
				}
				
				if(tmpBaseDrug=="")
				{
					alert(getMessage("PH_SEL_BASE_DRUG","PH"));
					return false;
				}
			}
			
			var priority		= headerForm.priority.value;
			var patient_id		= frmobj.patient_id.value;
			var encounter_id	= frmobj.encounter_id.value;
			var freq_code		= frmobj.frequency.value;
			var durn_value		= frmobj.durn_value.value;
			//var durn_type		= frmobj.durn_type.value;
			var durn_type		= frmobj.durn_type_desc.value;
			var start_date		= frmobj.start_date.value;
			var end_date		= frmobj.end_date.value;
			var ord_qty1		= frmobj.absol_qty1.value;
			var ord_qty2		= frmobj.absol_qty2.value;
			var ord_qty3		= frmobj.absol_qty3.value;
			var ord_qty4		= frmobj.absol_qty4.value;
			var ord_qty5		= frmobj.absol_qty5.value;
			var ord_qty6		= frmobj.absol_qty6.value;
			var ord_qty7		= frmobj.absol_qty7.value;
			var ord_qty8		= frmobj.absol_qty8.value;
			var ord_qty9		= frmobj.absol_qty9.value;
			var ord_qty10		= frmobj.absol_qty10.value;			
			var drug_code1		= frmobj.drug_code1.value;
			var drug_code2		= frmobj.drug_code2.value;
			var drug_code3		= frmobj.drug_code3.value;
			var drug_code4		= frmobj.drug_code4.value;
			var drug_code5		= frmobj.drug_code5.value;
			var drug_code6		= frmobj.drug_code6.value;
			var drug_code7		= frmobj.drug_code7.value;
			var drug_code8		= frmobj.drug_code8.value;
			var drug_code9		= frmobj.drug_code9.value;
			var drug_code10		= frmobj.drug_code10.value;
			//Added for  ML-BRU-CRF-072[Inc:29938] Start
			var DrugIndicationRemarks1=frmobj.DrugIndicationRemarks_1.value;
			var DrugIndicationRemarks2=frmobj.DrugIndicationRemarks_2.value;
			var DrugIndicationRemarks3=frmobj.DrugIndicationRemarks_3.value;
			var DrugIndicationRemarks4=frmobj.DrugIndicationRemarks_4.value
			var DrugIndicationRemarks5=frmobj.DrugIndicationRemarks_5.value;
			var DrugIndicationRemarks6=frmobj.DrugIndicationRemarks_6.value;
			var DrugIndicationRemarks7=frmobj.DrugIndicationRemarks_7.value;
			var DrugIndicationRemarks8=frmobj.DrugIndicationRemarks_8.value;
			var DrugIndicationRemarks9=frmobj.DrugIndicationRemarks_9.value;
			var DrugIndicationRemarks10=frmobj.DrugIndicationRemarks_10.value;
			//Added for  ML-BRU-CRF-072[Inc:29938] End
		

			var RP=new Array(10);
			var reqQty=new Array(10);
			var ordQty=new Array(10);
			var ordQtyUOM=new Array(10);
			var narcotic_yn = "N" ;
			for(intex=1;intex<=10;intex++)
			{
				RP[intex-1]= eval("frmobj.percent_ratio"+intex).value;
				reqQty[intex-1]= eval("frmobj.req_qty"+intex).value;
				ordQty[intex-1]= eval("frmobj.orderQty"+intex).value;
				ordQtyUOM[intex-1]= eval("frmobj.orderQtyUOM"+intex).value;
				drug_class= eval("frmobj.drug_class"+intex).value;
				if(drug_class == "N")
					narcotic_yn = "Y";
			}
			var dosage          = frmobj.dosage.value;
			var buildMAR_yn     = frmobj.buildMAR_yn.value;
			var mode            = frmobj.mode.value;
			if(PresByBase=='S')
			{
				var totalQty        = "";
			}
			else
			{
				var totalQty        = frmobj.txt_total_quantity.value;
			}
			var dosage_uom;
			if(frmobj.uom  == null){
				dosage_uom  =  frmobj.document.getElementById('qty_uom').innerText; 
			}
			else
			{				
				dosage_uom	= frmobj.uom.options[frmobj.uom.selectedIndex].value;
			}
			var patient_class	=	parent.parent.f_header.document.prescription_header_form.patient_class.value;
			
			var allergic_yn ="N";	

			allergic_yn =parent.parent.f_header.prescription_header_form.allergic_yn.value;

			var xmlStr		= "<root><SEARCH ";
			xmlStr			+= " patient_id=\""+ patient_id + "\" ";
			xmlStr			+= " encounter_id=\""+ encounter_id + "\" ";
			xmlStr			+= " freq_code=\""+ freq_code + "\" ";
			xmlStr			+= " durn_value=\""+ durn_value + "\" ";
			xmlStr			+= " durn_type=\""+ durn_type + "\" ";
			xmlStr			+= " start_date=\""+ start_date + "\" ";
			xmlStr			+= " end_date=\""+ end_date + "\" ";
			xmlStr			+= " allergic_yn=\""+ allergic_yn + "\" ";	
			xmlStr			+= " buildMAR_yn=\""+ buildMAR_yn + "\" ";	
			xmlStr			+= " discharge_yn=\""+ discharge_yn + "\" ";
			//Added for  ML-BRU-CRF-072[Inc:29938] Start
			xmlStr			+= " DrugIndicationRemarks1=\""+ DrugIndicationRemarks1 + "\" ";
			xmlStr			+= " DrugIndicationRemarks2=\""+ DrugIndicationRemarks2 + "\" ";
			xmlStr			+= " DrugIndicationRemarks3=\""+ DrugIndicationRemarks3 + "\" ";
			xmlStr			+= " DrugIndicationRemarks4=\""+ DrugIndicationRemarks4 + "\" ";
			xmlStr			+= " DrugIndicationRemarks5=\""+ DrugIndicationRemarks5 + "\" ";
			xmlStr			+= " DrugIndicationRemarks6=\""+ DrugIndicationRemarks6 + "\" ";
			xmlStr			+= " DrugIndicationRemarks7=\""+ DrugIndicationRemarks7 + "\" ";
			xmlStr			+= " DrugIndicationRemarks8=\""+ DrugIndicationRemarks8 + "\" ";
			xmlStr			+= " DrugIndicationRemarks9=\""+ DrugIndicationRemarks9 + "\" ";
			xmlStr			+= " DrugIndicationRemarks10=\""+ DrugIndicationRemarks10 + "\" ";
			//Added for  ML-BRU-CRF-072[Inc:29938] End
			xmlStr			+= " priority=\""+ priority + "\" ";
			xmlStr			+=  " /></root>";

			var bean_id		=	"DUMMY";
			var bean_name	=	"DUMMY";
			//var mode		= MODE_INSERT;	
			var rpString="";
			var reqQtyString="";
			var ordQtyString="";
			var ordQtyUOMString="";
			for(intex=1;intex<=10;intex++)
			{
				rpString += "&RP"+intex+"="+RP[intex-1];
				reqQtyString += "&reqQty"+intex+"="+reqQty[intex-1];
				ordQtyString += "&ordQty"+intex+"="+ordQty[intex-1];
				ordQtyUOMString += "&ordQtyUOM"+intex+"="+ordQtyUOM[intex-1];
			}
			var qryString			= bean_id+"&bean_name="+bean_name+"&mode="+mode+"&freq_code="+freq_code+"&validate=RELEASE&patient_id="+patient_id+"&encounter_id="+encounter_id+"&start_date="+start_date+"&end_date="+end_date+"&durn_value="+durn_value+"&durn_type="+durn_type+"&ord_qty1="+ord_qty1+"&ord_qty2="+ord_qty2+"&ord_qty3="+ord_qty3+"&ord_qty4="+ord_qty4+"&ord_qty5="+ord_qty5+"&ord_qty6="+ord_qty6+"&ord_qty7="+ord_qty7+"&ord_qty8="+ord_qty8+"&ord_qty9="+ord_qty9+"&ord_qty10="+ord_qty10+"&drug_code1="+drug_code1+"&drug_code2="+drug_code2+"&drug_code3="+drug_code3+"&drug_code4="+drug_code4+"&drug_code5="+drug_code5+"&drug_code6="+drug_code6+"&drug_code7="+drug_code7+"&drug_code8="+drug_code8+"&drug_code9="+drug_code9+"&drug_code10="+drug_code10+rpString+reqQtyString+ordQtyString+ordQtyUOMString+"&dosage="+dosage+"&dosage_uom="+dosage_uom+"&discharge_yn="+discharge_yn+"&PresByBase="+PresByBase+"&totalQty="+totalQty+"&narcotic_yn="+narcotic_yn+"&priority="+priority+"&DrugIndicationRemarks1="+DrugIndicationRemarks1+"&DrugIndicationRemarks2="+DrugIndicationRemarks2+"&DrugIndicationRemarks3="+DrugIndicationRemarks3+"&DrugIndicationRemarks4="+DrugIndicationRemarks4+"&DrugIndicationRemarks5="+DrugIndicationRemarks5+"&DrugIndicationRemarks6="+DrugIndicationRemarks6+"&DrugIndicationRemarks7="+DrugIndicationRemarks7+"&DrugIndicationRemarks8="+DrugIndicationRemarks8+"&DrugIndicationRemarks9="+DrugIndicationRemarks9+"&DrugIndicationRemarks10="+DrugIndicationRemarks10;
			submitXML(qryString, xmlStr);//Added DrugIndicationRemarks1 to DrugIndicationRemarks10 for  ML-BRU-CRF-072[Inc:29938]
			if (result) {

				if(patient_class=='OP' || patient_class=='EM'){
					var xmlStr 			="<root><SEARCH /></root>";
					var xmlDoc = ""; 
					var xmlHttp = new XMLHttpRequest();
					xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
					iv_bean_id		= "IVPrescriptionBean"+patient_id+encounter_id;
					iv_bean_name	= "ePH.IVPrescriptionBean";
					xmlHttp.open("POST","PrescriptionCompValidate.jsp?bean_id="+iv_bean_id+"&bean_name="+iv_bean_name+"&validate=GET_TRNGROUPREF",false);
					xmlHttp.send(xmlDoc);
					responseText=xmlHttp.responseText ;
					responseText=trimString(responseText);

					if(responseText != undefined && responseText!=null && responseText !=""){
						var dialogHeight	="35vh" ;
						var dialogWidth	="40vw";
						var dialogTop	= "300" ;
						var dialogLeft	= "300" ;
						var center			= "1" ;
						var status			="no";
						var features	= "dialogHeight:" + dialogHeight +"; dialogLeft:"+dialogLeft+ "; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop;
						var arguments	= "";
						retVal = await window.showModalDialog("../../ePH/jsp/TokenListForOrders.jsp?trn_group_ref="+responseText,arguments,features);
					}
				}

				parent.parent.f_header.document.prescription_header_form
				var narcotic_aprvl_form_req_yn=parent.parent.f_header.document.prescription_header_form.narcotic_aprvl_form_req_yn.value;
				var print_narcotic_form_by_default=parent.parent.f_header.document.prescription_header_form.print_narcotic_form_by_default.value;
//alert("==narcotic_yn==="+narcotic_yn+"==narcotic_aprvl_form_req_yn=="+narcotic_aprvl_form_req_yn+"==print_narcotic_form_by_default=="+print_narcotic_form_by_default);
				if(narcotic_yn == "N"){
					narcotic_aprvl_form_req_yn = "";
					print_narcotic_form_by_default="";
				}
				var dialogHeight	="32vh" ;
				var dialogWidth	="40vw";
				var dialogTop	= "300" ;
				var dialogLeft	= "300" ;
				var center			= "1" ;
				var status			="no";
				var features	= "dialogHeight:" + dialogHeight +"; dialogLeft:"+dialogLeft+ "; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop;
				var arguments	= "";
				if((print_ord_sht_rule_ind=="C" || print_ord_sht_rule_ind=='') || narcotic_aprvl_form_req_yn=="Y")//print_ord_sht_rule_ind=="C" || print_ord_sht_rule_ind=='' added for Inc : 049877
					retVal = await window.showModalDialog("../../ePH/jsp/PrescriptionPrintDialog.jsp?narcotic_aprvl_form_req_yn="+narcotic_aprvl_form_req_yn+"&print_narcotic_form_by_default="+print_narcotic_form_by_default+"&called_from=COMP"+"&print_ord_sht_rule_ind="+print_ord_sht_rule_ind,arguments,features);//print_ord_sht_rule_ind Added for Bru-HIMS-CRF-393_1.0
//alert("retVal =1111comp11111== "+retVal);	
				if(((print_ord_sht_rule_ind=="C" || print_ord_sht_rule_ind=='') && retVal != undefined && retVal[0] != "CANCEL") || print_ord_sht_rule_ind =='S'){//print_ord_sht_rule_ind Added for Bru-HIMS-CRF-393_1.0 AND print_ord_sht_rule_ind=="C" || print_ord_sht_rule_ind=='' added for Inc : 049877
					var xmlStr ="<root><SEARCH ";
					xmlStr += " patient_id=\""+ patient_id + "\" ";
					xmlStr += " encounter_id=\""+ encounter_id + "\" ";
					xmlStr += " patient_class =\"" + patient_class + "\" " ;
					if((print_ord_sht_rule_ind=="C" || print_ord_sht_rule_ind=='') && retVal.length >0){//If and Else if for Bru-HIMS-CRF-393_1.0 AND print_ord_sht_rule_ind=="C" || print_ord_sht_rule_ind=='' added for Inc : 049877
						xmlStr+=" prescriptionPrint=\""+ retVal[0] + "\" ";
						xmlStr+=" NarcoticPrint=\""+ retVal[1] + "\" ";
					}
					else if(print_ord_sht_rule_ind =='S')
						xmlStr+=" prescriptionPrint=\""+ "Y"+ "\" ";
					/*if (confirm(getMessage("PH_PRINT_PRESCRIPTION","PH"))) {
							xmlStr+= "print_yn='Y'" ;
					} else {
							xmlStr+= "print_yn='N'" ;
					}*/
					xmlStr +=" /></root>";
//alert("----xmlStr----"+xmlStr);					
					var temp_jsp="PrescriptionCompValidate.jsp?validate=PRINT&bean_id="+bean_id+"&bean_name="+bean_name;
					var xmlDoc = "" ;
					var xmlHttp = new XMLHttpRequest() ;
					xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
					xmlHttp.open("POST",temp_jsp,true);
					xmlHttp.send(xmlDoc);
				}
				if(mode == "RENEW_ORDER" ){
				  // window.close()
				
				    const dialogTag = parent.parent.document.getElementById("dialog_tag");    
				    dialogTag.close();  
				}else{
					reloadPage();
				}
			} else if(flag=="INSUFFICIENT_STOCK") {
					iv_bean_id		= "IVPrescriptionBean"+patient_id+encounter_id;
					iv_bean_name	= "ePH.IVPrescriptionBean";

				var dialogHeight	= "32vh";
				var dialogWidth		= "45vw";
				var dialogTop		= "250";
				var dialogLeft		= "40";
				var center			= "0";
				var status			= "no";
				var features		= "dialogHeight:" + dialogHeight +"; dialogLeft:"+dialogLeft+ "; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop;
				var arguments		= "";
				retVal 				= await window.showModalDialog("../../ePH/jsp/IVPrescriptionStockDetails.jsp?bean_id="+iv_bean_id+"&bean_name="+iv_bean_name+"&called_from=COMP",arguments,features);
			}
		}
	}
}

function printOnlinePrescription(formObj,okCancel,print_ord_sht_rule_ind){//pres_print,Added for Bru-HIMS-CRF-393_1.0
//	alert("COMPPP dialog close");
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
	}else{
        retval[0]='CANCEL';
	 
	}
//	alert("return comp="+retval);
//     window.returnValue=retval;
//	 window.close();
	
	let dialogBody = parent.parent.document.getElementById('dialog-body');
    dialogBody.contentWindow.returnValue = retval;
    
    const dialogTag = parent.parent.document.getElementById("dialog_tag");    
    dialogTag.close();  
}

function reloadPage() {
	if(top.messageframe!=null) {
		top.messageframe.location.href = "../../eCommon/jsp/error.jsp?err_num="+message;
	} else {
		alert(message);
	}
	parent.parent.parent.criteriaCategoryButtonFrame.location.reload();
	//window.close(); // Added for ICN:41114
	
    
    const dialogTag = parent.document.getElementById("dialog_tag");    
    dialogTag.close();  
}

function chkMandatoryFlds(calledMode) {
	var retStat = true;
	var noOfDrgus = 0;

	var frmObj	= parent.f_compound_detail.document.prescription_compdetail_form;
	//Added for IN:069887 START
	var allergy_remarks_yn="N"; 
	var dup_remarks_yn="N";
	var dose_remarks_yn="N";
	var validate_overide_on_confirm_yn=frmObj.validate_overide_on_confirm_yn.value;
	//Added for IN:069887 END

	if (calledMode == "Release" || calledMode == "amend") {	

		if(frmObj.drug_code1.value !="") noOfDrgus+=1;
		if(frmObj.drug_code2.value !="") noOfDrgus+=1;
		if(frmObj.drug_code3.value !="") noOfDrgus+=1;
		if(frmObj.drug_code4.value !="") noOfDrgus+=1;
		for(dcno=5;dcno<=10;dcno++)
		{
			if(eval("frmObj.drug_code"+dcno).value !="") noOfDrgus+=1;
		}
		if(noOfDrgus < 2){
			alert(getMessage("PH_ATLEAST_TWO_DRUGS","PH"));
			retStat = false;
		}
		else if( ((frmObj.absol_qty1.value=="" || frmObj.absol_qty1.value=="0" || frmObj.absol_qty1.value=="0.00") && frmObj.drug_code1.value!="") 
			|| ((frmObj.absol_qty2.value=="" || frmObj.absol_qty2.value=="0" || frmObj.absol_qty2.value=="0.00")&& frmObj.drug_code2.value!="") 
			|| ((frmObj.absol_qty3.value=="" || frmObj.absol_qty3.value=="0" || frmObj.absol_qty3.value=="0.00")&& frmObj.drug_code3.value!="") 
			|| ((frmObj.absol_qty4.value=="" || frmObj.absol_qty4.value=="0" || frmObj.absol_qty4.value=="0.00")&& frmObj.drug_code4.value!="") 
			|| ((frmObj.absol_qty5.value=="" || frmObj.absol_qty5.value=="0" || frmObj.absol_qty5.value=="0.00")&& frmObj.drug_code5.value!="") 
			|| ((frmObj.absol_qty6.value=="" || frmObj.absol_qty6.value=="0" || frmObj.absol_qty6.value=="0.00")&& frmObj.drug_code6.value!="") 
			|| ((frmObj.absol_qty7.value=="" || frmObj.absol_qty7.value=="0" || frmObj.absol_qty7.value=="0.00")&& frmObj.drug_code7.value!="") 
			|| ((frmObj.absol_qty8.value=="" || frmObj.absol_qty8.value=="0" || frmObj.absol_qty8.value=="0.00")&& frmObj.drug_code8.value!="") 
			|| ((frmObj.absol_qty9.value=="" || frmObj.absol_qty9.value=="0" || frmObj.absol_qty9.value=="0.00")&& frmObj.drug_code9.value!="") 
			|| ((frmObj.absol_qty10.value=="" || frmObj.absol_qty10.value=="0" || frmObj.absol_qty10.value=="0.00")&& frmObj.drug_code10.value!="")) {
			alert(getMessage("PH_ORDER_QTY_BLANK","PH"));
			retStat = false;
		}
		else if (trimCheck(frmObj.durn_value.value) =="" || frmObj.durn_value.value=="0") {
			alert(getMessage("PRES_DURN_CANNOT_ZERO","PH"));
			frmObj.durn_value.focus();
			retStat = false;
		}
		else if (trimCheck(frmObj.start_date.value) == "") {
			alert(getMessage("PH_START_DATE","PH"));
			frmObj.start_date.focus();
			retStat = false;
		}
		else if (trimCheck(frmObj.frequency.value) == "") {
			alert(getMessage("PH_FREQ","PH"));
			frmObj.frequency.focus();
			retStat = false;
		}
		else if(calledMode != "amend"){
			var docObj = parent.f_compound_detail.document.all;
			//var drug_db_interface_yn        = parent.parent.f_header.document.prescription_header_form.drug_db_interface_yn.value;
			for(var i =1;i<=10 ;i++){

				allergy				= eval("docObj.allergy_"+i);
				allergy_remarks		= eval("docObj.ALLERGY_DESC"+i).value;
				dosage				= eval("docObj.dosage_"+i);
				dose_remarks		= eval("docObj.EXCEED_DOSE_DESC"+i).value;
				currentrx			= eval("docObj.currentrx_"+i);
				currentrx_remarks	= eval("docObj.DUP_DRUG_DESC"+i).value;
				//added for [IN:039576]-start
				var drugRemarksMandatory = eval("docObj.DrugRemarksMandatory_"+i).value;
		        var drugRemarksEntered		 = eval("docObj.DrugRemarksEntered_"+i).value;
				if(drugRemarksMandatory == 'Y' && drugRemarksEntered != 'Y'){
					 msg = getMessage("CAN_NOT_BE_BLANK","Common");
					 msg = msg.replace('$', getLabel("ePH.DrugRemarks.label","PH"));
					 alert(msg);
					 eval("docObj.remarks_"+i).click();
					 return false;
				 }//added for [IN:039576]-end

                var Perform_ext_db_checks_YN =eval("docObj.Perform_ext_db_checks_YN"+i).value;

                	//if(Perform_ext_db_checks_YN!='Y'){					   
							if((allergy.style.visibility=='visible')&&(allergy_remarks =="")|| (dosage.style.visibility=='visible')&&(dose_remarks =="") || (currentrx.style.visibility=='visible')&&(currentrx_remarks =="")){
					// Modified for IN:069887 start			
								if((dosage.style.visibility=='visible')&&(dose_remarks =="")){
									dose_remarks_yn="Y";
								}
								if((allergy.style.visibility=='visible')&&(allergy_remarks =="")){
									allergy_remarks_yn="Y";
								}
								if((currentrx.style.visibility=='visible')&&(currentrx_remarks =="")){
									dup_remarks_yn="Y";
								}   
								if(validate_overide_on_confirm_yn=="Y"){
									if(dup_remarks_yn=="Y" && dose_remarks_yn=="Y" && allergy_remarks_yn=="Y"){
										break;
									}   	
                                    } 
                                    else{
								    alert(getMessage("OVERRIDE_REASON_NOT_BLANK","PH"));
									retStat = false;
					     			break;	
                                    }
				    // Modified for IN:069887 end
							 }
					//}else{
						if(eval("docObj.absol_qty"+i).value!=""){
							 external_db_dose_check						= eval("docObj.external_db_dose_check_"+i).value;
							 ext_med_alerts_fired_for_dup_check_yn		= eval("docObj.ext_med_alerts_fired_for_dup_check_yn"+i).value;
							 ext_med_alerts_fired_for_inte_check_yn		= eval("docObj.ext_med_alerts_fired_for_inte_check_yn"+i).value;
							 ext_med_alerts_fired_for_contra_check_yn	= eval("docObj.ext_med_alerts_fired_for_contra_check_yn"+i).value;
							 
							 external_dosage_override_reason			= eval("docObj.external_dosage_override_reason"+i).value;
							 external_duplicate_override_reason			= eval("docObj.external_duplicate_override_reason"+i).value;
							 external_interaction_override_reason		= eval("docObj.external_interaction_override_reason"+i).value;
							 external_contra_override_reason			= eval("docObj.external_contra_override_reason"+i).value;

							// if((external_override_reason=="")&& ( ext_med_alerts_fired_for_dup_check_yn.equals=="Y" || ext_med_alerts_fired_for_inte_check_yn=="Y" || ext_med_alerts_fired_for_conra_check_yn=="Y"|| ext_med_alerts_fired_for_dosage_check_yn=="Y")){                             
							 if( ((ext_med_alerts_fired_for_dup_check_yn=="Y")&&( external_duplicate_override_reason==""))
								 ||((ext_med_alerts_fired_for_inte_check_yn=="Y")&&( external_interaction_override_reason==""))
								 ||((ext_med_alerts_fired_for_contra_check_yn=="Y")&&( external_contra_override_reason==""))
								 ||((external_db_dose_check=="Y")&&( external_dosage_override_reason==""))){

								 //alert("external override reason cannot be blank");

								  alert(getMessage("OVERRIDE_REASON_NOT_BLANK","PH"));
								 retStat = false;
								 break;

							 }
						}
				}
			//Added for IN:069887 	
			if(validate_overide_on_confirm_yn=="Y"){
			if(dup_remarks_yn=="Y" || dose_remarks_yn=="Y" || allergy_remarks_yn=="Y"){
				showOverideMandAlert(allergy_remarks_yn, dup_remarks_yn, dose_remarks_yn);
				retStat = false;
			}
			//Added for IN:069887 
			}
			}
			else if(calledMode == "amend"){
				var docObj = parent.f_compound_detail.document.all;
				for(var i =1;i<=4 ;i++){				

              //  var Perform_ext_db_checks_YN =eval("docObj.Perform_ext_db_checks_YN"+i).value;

                	// if(Perform_ext_db_checks_YN!='Y'){
						if(eval("docObj.absol_qty"+i).value!=""){
							 external_db_dose_check						= eval("docObj.external_db_dose_check_"+i).value;
							 ext_med_alerts_fired_for_dup_check_yn		= eval("docObj.ext_med_alerts_fired_for_dup_check_yn"+i).value;
							 ext_med_alerts_fired_for_inte_check_yn		= eval("docObj.ext_med_alerts_fired_for_inte_check_yn"+i).value;
							 ext_med_alerts_fired_for_contra_check_yn	= eval("docObj.ext_med_alerts_fired_for_contra_check_yn"+i).value;
							 
							 external_dosage_override_reason			= eval("docObj.external_dosage_override_reason"+i).value;
							 external_duplicate_override_reason			= eval("docObj.external_duplicate_override_reason"+i).value;
							 external_interaction_override_reason		= eval("docObj.external_interaction_override_reason"+i).value;
							 external_contra_override_reason			= eval("docObj.external_contra_override_reason"+i).value;

							 if( ((ext_med_alerts_fired_for_dup_check_yn=="Y")&&( external_duplicate_override_reason==""))||((ext_med_alerts_fired_for_inte_check_yn=="Y")&&( external_interaction_override_reason==""))||((ext_med_alerts_fired_for_contra_check_yn=="Y")&&( external_contra_override_reason==""))||((external_db_dose_check=="Y")&&( external_dosage_override_reason==""))){
								alert(getMessage("EXT_OVR_RSN_CANT_BLANK","PH"));
								retStat = false;
								break;
							 }
						}
					//}
				}
			}
		}
	
	return retStat;
}
function getRemarks(rec, click_yn) {

	var	formObj		= document.prescription_compdetail_form;
	var	drug_code	= eval("formObj.drug_code"+rec).value;
	var	form_code	= eval("formObj.drug_code"+rec).value;
	bean_id		    = formObj.bean_id;
	bean_name	    = formObj.bean_name;
	patient_id		= formObj.patient_id.value;
	encounter_id	= formObj.encounter_id.value;
	mode			= formObj.mode.value;
		
	var qryString	= bean_id+"&bean_name="+bean_name+"&validate=REMARKS&patient_id="+patient_id+"&encounter_id="+encounter_id+"&drug_code="+drug_code+"&mode="+mode+"&rec_no="+rec+"&click_yn="+click_yn;
	submitXML(qryString, "");
}

async function showOverRideRemarks(patient_id,encounter_id,generic_id,generic_name,drug_desc,daily_dose,unit_dose,mono_graph,limit_ind,allergy_yn,current_rx,drug_code,srl_no,allergy_remarks,dose_remarks,currentrx_remarks,min_unit_dose,min_daily_dose,drug_db_interface_yn,drug_db_allergy_flag,drug_db_duptherapy_flag,dosage_std,max_daily_celing_dose,min_daily_ceiling_dose,max_unit_ceiling_dose,min_unit_ceiling_dose,dose_unit_desc,dose_unit_desc1,drug_db_dosecheck_yn,allergy_remarks_code,dose_remarks_code,currentrx_remarks_code){//Added for IN:072715 allergy_remarks_code,dose_remarks_code,currentrx_remarks_code
	//modified for ML-MMOH-CRF-1408 and drug_db_dosecheck_yn added for ML-MMOH-CRF-1408

	var allergy_override    = "N";
	var dose_override	    = "N";
	var currentrx_override  = "N";

	if(document.getElementById("ALLERGY_DESC"+rec_no).value!="")
		allergy_remarks = document.getElementById("ALLERGY_DESC"+rec_no).value;

	if(document.getElementById("EXCEED_DOSE_DESC"+rec_no)+rec_no.alue!="")
		dose_remarks = document.getElementById("EXCEED_DOSE_DESC"+rec_no).value;

	if(document.getElementById("DUP_DRUG_DESC"+rec_no).value!="")
		currentrx_remarks = document.getElementById("DUP_DRUG_DESC"+rec_no).value;

	var dialogHeight	= "18";

	if(current_rx=="Y" && limit_ind=="N" && allergy_yn=="Y")
		dialogHeight	= "21";
	else if ( (current_rx=="Y" && limit_ind=="N") || (current_rx=="Y" && allergy_yn=="Y") || (limit_ind=="N" && allergy_yn=="Y" ))
		dialogHeight	= "80vh";
	else
		dialogHeight	= "12";

	var dialogWidth	= "61vw";
	var dialogTop	= "285";
	var dialogLeft	= "100";
	var center		= "0";
	var status		= "no";
	var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop+"; dialogLeft :"+dialogLeft;
	var arguments	= "";
	// encoding and decoding  is added for drug_desc  IN062487

	retArray		= await window.showModalDialog("../jsp/CompoundingOverRideReason.jsp?gen_id="+generic_id+"&gen_name="+escape(generic_name)+"&pat_id="+patient_id+"&enc_id="+encounter_id+"&drug_desc="+escape(encodeURIComponent(drug_desc,"UTF-8"))+"&mono_graph="+escape(mono_graph)+"&daily_dose="+daily_dose+"&unit_dose="+unit_dose+"&allergy_yn="+allergy_yn+"&current_rx="+current_rx+"&limit_ind="+limit_ind+"&drug_code="+drug_code+"&srl_no="+srl_no+"&allergy="+encodeURIComponent(allergy_remarks,"UTF-8")+"&exceed_dose="+encodeURIComponent(dose_remarks,"UTF-8")+"&dup_drug="+encodeURIComponent(currentrx_remarks,"UTF-8")+"&min_unit_dose="+min_unit_dose+"&min_daily_dose="+min_daily_dose+"&drug_db_interface_yn="+drug_db_interface_yn+"&drug_db_allergy_flag="+drug_db_allergy_flag+"&drug_db_duptherapy_flag="+drug_db_duptherapy_flag+"&max_daily_celing_dose="+max_daily_celing_dose+"&min_daily_ceiling_dose="+min_daily_ceiling_dose+"&max_unit_ceiling_dose="+max_unit_ceiling_dose+"&min_unit_ceiling_dose="+min_unit_ceiling_dose+"&dose_unit_desc="+dose_unit_desc+"&dose_unit_desc1="+dose_unit_desc1+"&dosage_std="+dosage_std+"&drug_db_dosecheck_yn="+drug_db_dosecheck_yn+"&allergy_remarks_code="+allergy_remarks_code+"&dose_remarks_code="+dose_remarks_code+"&currentrx_remarks_code="+currentrx_remarks_code, arguments, features);//Modified for IN:072715 added allergy_remarks_code,dose_remarks_code,currentrx_remarks_code
//modified for ML-MMOH-CRF-1408 and drug_db_dosecheck_yn added for ML-MMOH-CRF-1408
	if ( retArray != null && retArray != "" ) {
		var split_vals	= retArray.split(":::");
		document.getElementById("ALLERGY_DESC"+rec_no).value		= split_vals[0];
		document.getElementById("EXCEED_DOSE_DESC"+rec_no).value	= split_vals[1];
		document.getElementById("DUP_DRUG_DESC"+rec_no).value		= split_vals[2];
		
		if(split_vals[0] !="") allergy_override = "Y"; 
		if(split_vals[1] !="") dose_override = "Y"; 
		if(split_vals[2] !="") currentrx_override = "Y"; 

		overrideImg(allergy_yn,allergy_override,limit_ind,dose_override,current_rx,currentrx_override);
	}
	//Added for IN:072715
	else{
		document.getElementById("chk_ovr"+rec_no).checked=false;
	}
	//Added for IN:072715
}

function clearArray(){
	i=0;
}
function prescriptionValues(vals) {
	pres_vals[i++] = vals;
}
async function validateRemarks(format_id,drug_code,form_code,route_code,rec_no,click_yn)	{
	var format	= format_id.split("~");
	var mandatory	=	format[0];//added for [IN:039576]
	formatId	= format[1];
	if(mandatory == undefined || mandatory== null || mandatory=='null' || mandatory=='')//added for [IN:039576]
		mandatory="N";//added for [IN:039576]
	var frmObj	= "";
/*	var vals	= "";
	for(i=0; i<pres_vals.length; i++)	{
		if(i==pres_vals.length)
			vals	+= pres_vals[i];
		else
			vals	+= pres_vals[i]+ "::";
	}*/

    var	formObj		= document.prescription_compdetail_form;
	document.getElementById('DrugRemarksMandImg_'+rec_no).style.display = 'none';//added for [IN:039576]
	document.getElementById('DrugRemarksMandatory_'+rec_no).value =mandatory;//added for [IN:039576]
	//added for SKR-SCF-0140 -start
	if(format == null || format=='' || formatId==null || formatId=='')
	document.getElementById('remarks_'+rec_no).style.visibility = 'hidden';
	else{
		document.getElementById('remarks_'+rec_no).style.visibility = 'visible';
	   if(mandatory == 'Y'){//if block added for [IN:039576]
			document.getElementById('DrugRemarksMandImg_'+rec_no).style.display = 'inline';
		}
	}
	//added for SKR-SCF-0140 -end
	if(click_yn =='Y'){
		patient_id		= formObj.patient_id.value;
		encounter_id	= formObj.encounter_id.value;
		DrugRemarksEntered	=document.getElementById('DrugRemarksEntered_'+rec_no).value;//added for [IN:039576]
		bean_id			= "@orderentrybean"+patient_id+encounter_id;
		bean_name		= "eOR.OrderEntryBean";
		mode		= formObj.mode.value;
		var order_id = "";
		var order_line_no = "";

		if(mode=='amend' || mode=='RENEW_ORDER'){
			//formatId="";
			order_id		= formObj.order_id.value;
			order_line_no		= eval("formObj.srl_no"+rec_no).value;
		}

		var dialogHeight= "900px";
		var dialogWidth	= "800px";
		var dialogTop	= "169";
		var center		= "1";
		var status		= "no";
		var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop;
		var arguments	= "";
		var retVal		= await window.showModalDialog("../../eOR/jsp/OrderEntryOrderFormatFrameSet.jsp?bean_id="+bean_id+"&bean_name="+bean_name+"&format_id="+formatId+"&p_catalog_code="+drug_code+"&catalog_code="+drug_code+"&order_category=PH&row_value=0&called_from=PH"+"&p_form_code="+form_code+"&p_route_code="+route_code+"&order_id="+order_id+"&order_line_num="+order_line_no,arguments,features);
		if(retVal!=undefined ){
			var retVals = retVal.split('~');
			//if(retVal!=undefined && retVal=='Y' && eval("formObj.DrugRemarksEntered_"+rec_no).value!='Y') //if block added for [IN:039576]
			if(retVals[0]=='Y' && DrugRemarksEntered!='Y') //if block added for [IN:039576]
				eval("formObj.DrugRemarksEntered_"+rec_no).value = 'Y'
		}
	}
}

function overRideRemarks(drug_code,recno){
	
	rec_no = recno;
	var formObj			= document.prescription_compdetail_form;
	var patient_id		= formObj.patient_id.value;
	var encounter_id	= formObj.encounter_id.value;
	var bean_id			= formObj.bean_id.value;
	var bean_name		= formObj.bean_name.value;
	var drug_db_interface_yn = formObj.drug_db_interface_yn.value;
	var drug_db_dosecheck_yn = formObj.drug_db_dosecheck_yn.value;//ML-MMOH-CRF-1408
	
	var drug_db_allergy_flag		 = document.getElementById("ext_med_alerts_fired_for_allergy_check_yn"+recno).value; 
	var drug_db_duptherapy_flag	 = document.getElementById("ext_med_alerts_fired_for_dup_check_yn"+recno).value;

	var qryString		= bean_id+"&bean_name="+bean_name+"&validate=OVERRIDEREMARKS&patient_id="+patient_id+"&encounter_id="+encounter_id+"&drug_code="+drug_code+"&rec_no="+rec_no+"&drug_db_interface_yn="+drug_db_interface_yn+"&drug_db_allergy_flag="+drug_db_allergy_flag+"&drug_db_duptherapy_flag="+drug_db_duptherapy_flag+"&drug_db_dosecheck_yn="+drug_db_dosecheck_yn;
	submitXML(qryString, "");//modified for //ML-MMOH-CRF-1408
}

function deleteDrug(obj,recNo, calledFrom){
	if(calledFrom == 'BLERROR'){
		var frmObj			= parent.f_compound_detail.document.prescription_compdetail_form;
		var docObj			= parent.f_compound_detail.document;
	}
	else{
		var frmObj			= document.prescription_compdetail_form;
		var docObj			= document;
	}

	rec_no				= recNo;
	drug_obj			=	eval("frmObj.drug_name"+rec_no);
	drug_code_obj		=	eval("frmObj.drug_code"+rec_no);
	strength_obj		=	eval("docObj.strength"+rec_no);
	form_obj			=	eval("docObj.form"+rec_no);
	absol_qty			=	eval("docObj.absol_qty"+rec_no);
	stockuom_obj		=	eval("docObj.qty"+rec_no);
	remarks_obj			=	eval("docObj.remarks_"+rec_no);
	drugInd_obj			=	document.getElementById('drug_ind_remarks_'+rec_no);
	dosage_limit_obj    =   eval("docObj.dosage_limit"+rec_no);
	strength_uom        =   eval("docObj.strength_uom"+rec_no);
	pres_base_uom       =   eval("docObj.pres_base_uom"+rec_no);
	chk_ovr_obj		    =   eval("docObj.chk_ovr"+rec_no);
	var tdmRslt_obj		=	eval("docObj.tdmRslt_"+rec_no);
	drug_info_obj		=   eval("docObj.drug_info_"+rec_no);
	req_qty_obj			=	eval("frmObj.req_qty"+rec_no);
	percent_ratio_obj	=	eval("frmObj.percent_ratio"+rec_no);
	equvalentUOM_conversion_obj		=	eval("frmObj.equvalentUOM_conversion_value"+rec_no);
	equvalentUOM_conversion_fac_obj	=	eval("frmObj.equvalentUOM_conversion_factor"+rec_no);
	contentInPresBaseUOM_obj		=	eval("frmObj.contentInPresBaseUOM"+rec_no);
	orderQty_obj		=	eval("frmObj.orderQty"+rec_no);
	orderQtyUOM_obj		=	eval("frmObj.orderQtyUOM"+rec_no);
	baseDrugId_obj		=	eval("frmObj.baseDrugId"+rec_no);
	edl_info_obj		=	eval("frmObj.edl_info_"+rec_no);	//SRR20056-SCF-6572

	if((obj.value == "" && drug_code_obj.value != "")|| calledFrom == 'DRUGSELECT'){

		var drug_code       =  "";
		var bean_id			=  frmObj.bean_id.value;
		var bean_name	    =  frmObj.bean_name.value; 	
		var patient_id      =  frmObj.patient_id.value;
		var encounter_id    =  frmObj.encounter_id.value;

		drug_code = drug_code_obj.value;

		drug_obj.value		=	"";
		drug_code_obj.value	=   "";
		absol_qty.value     =   "";
		strength_obj.innerText	="";
		form_obj.innerText		="";
		stockuom_obj.innerText	="";
		strength_uom.value      ="";
		pres_base_uom.value     ="";
		req_qty_obj.value		="";
		percent_ratio_obj.value	="";
		orderQty_obj.value		="";
		orderQtyUOM_obj.value	="";
		baseDrugId_obj.checked	=false;
		equvalentUOM_conversion_obj.value="";
		equvalentUOM_conversion_fac_obj.value="";
		contentInPresBaseUOM_obj.value="";
		remarks_obj.style.visibility='hidden';	
		drugInd_obj.style.visibility='hidden';	
		overrideImg('N','N','Y','N','N','N', calledFrom,'N','N','N','N');
		dosage_limit_obj.style.visibility='hidden';
		chk_ovr_obj.checked		= false;
		chk_ovr_obj.style.visibility='hidden';
		drug_info_obj.style.visibility='hidden';
		edl_info_obj.style.visibility='hidden';	   //SRR20056-SCF-6572
		
		eval("docObj.ALLERGY_DESC"+rec_no).value		= "";
		eval("docObj.EXCEED_DOSE_DESC"+rec_no).value	= "";
		eval("docObj.DUP_DRUG_DESC"+rec_no).value		= "";

		var qryString	= bean_id+"&bean_name="+bean_name+"&validate=DELETEDRUG&patient_id="+patient_id+"&encounter_id="+encounter_id+"&drug_code="+drug_code;
		submitXML(qryString, "");

		var noOfDrgus = 0;
		var str_count = 0;
		if(frmObj.drug_code1.value !="") noOfDrgus+=1;
		if(frmObj.drug_code2.value !="") noOfDrgus+=1;
		if(frmObj.drug_code3.value !="") noOfDrgus+=1;
		if(frmObj.drug_code4.value !="") noOfDrgus+=1;
		for(dcno=5;dcno<=10;dcno++)
		{
			if(eval("frmObj.drug_code"+dcno).value !="") noOfDrgus+=1;
		}
		if(frmObj.strength_uom1.value !="") str_count+=1;
		if(frmObj.strength_uom2.value !="") str_count+=1;
		if(frmObj.strength_uom3.value !="") str_count+=1;
		if(frmObj.strength_uom4.value !="") str_count+=1;
		for(dcno=5;dcno<=10;dcno++)
		{
			if(eval("frmObj.strength_uom"+dcno).value !="") str_count+=1;
		}
		
		if(noOfDrgus == "0"){
			frmObj.dosage.value = "";
			frmObj.uom.selectedIndex= 0 ;
			frmObj.frequency.selectedIndex=0;
			frmObj.dosage_label.innerHTML="<label></label>";
			
		}
		if(PrescribingBase=="S")
		{
			var len =frmObj.uom.options.length;
			for(var i=0;i<len;i++) {
				frmObj.uom.remove("uom") ;
			}

			if(noOfDrgus>1 && str_count =="0" ){
				for(var i =1;i<=10 ;i++){
					if(	eval("frmObj.pres_base_uom"+i).value !=""){
						var element = docObj.createElement('OPTION') ;
						//element.value		=  rec_no ; //Modified for CRF--0749 INC-13640
						element.value		= (eval("frmObj.pres_base_uom"+i).value);
						element.text		=  (eval("frmObj.pres_base_uom_need"+i).value)+"            ";
						frmObj.uom.add(element);
						frmObj.uom.selectedIndex= 0 ;
					}
				}
			}
			else{
				for(var i =1;i<=10 ;i++){
					if(	eval("frmObj.strength_uom"+i).value !=""){
						var element = docObj.createElement('OPTION') ;
						//element.value		=  i ;//Modified for CRF--0749 INC-13640
						element.value		= (eval("frmObj.strength_uom"+i).value);
						element.text		=  (eval("frmObj.strength_uom_need"+i).value)+"            ";
						frmObj.uom.add(element);
						frmObj.uom.selectedIndex= 0 ;
					}
				}
			}
			if(noOfDrgus == "0" || (noOfDrgus == "1" && str_count =="0")){
				var element = docObj.createElement('OPTION') ;
				element.value		=  "" ;
				element.text		= "  --- "+getLabel("ePH.Select.label","PH")+" ---  " ;
				frmObj.uom.add(element);
				frmObj.uom.selectedIndex= 0 ;
			}
		}
		if(PrescribingBase=="R" || PrescribingBase=="P" )
			percentageRatioCalculation('N');
	}	
}

function makeScheduleLink(admin_time,admin_qty,total_qty,freq_size,split_chk){
		
	   	if(parent.f_compound_detail.document.prescription_compdetail_form.btn_schedule)
			parent.f_compound_detail.document.prescription_compdetail_form.btn_schedule.disabled=false;

		var title="<table border=1 cellpadding=0 cellspacing=0 align=center>"+admin_time+admin_qty+"</table>";
		parent.f_compound_detail.document.querySelectorAll('#dosage_label').innerHTML="<label nowrap style='color:red;font-size:10' onmouseover='displayToolTipDataChange(\"" + title + "\");' onmouseout='disasbleToolTipDataChange();'>&nbsp;&nbsp;&nbsp;&nbsp;Schedule</label>";
}

function displayToolTipDataChange(text){
	buildTableDataChange(text);
	bodwidth  = parent.parent.parent.frames[1].document.body.offsetWidth
    bodheight = parent.parent.parent.frames[1].document.body.offsetHeight

	var x     = event.x;
    var y     = event.y;
    x     = x + (document.getElementById("tooltiplayer").offsetWidth)
    y     = y + (document.getElementById("tooltiplayer").offsetHeight)

    if(x<bodwidth)
        x = event.x
    else
        x = x - (document.getElementById("tooltiplayer").offsetWidth*2)
    if(y<bodheight)
        y = event.y
    else
        y = y - (document.getElementById("tooltiplayer").offsetHeight*2)

    y+=document.body.scrollTop
    x+=document.body.scrollLeft
    document.getElementById("tooltiplayer").style.posLeft= x+40;
    document.getElementById("tooltiplayer").style.posTop = y-50;
    document.getElementById("tooltiplayer").style.visibility='visible';
    }
function buildTableDataChange(text){
    document.getElementById("t").innerHTML = text;
}
function disasbleToolTipDataChange(){
    document.getElementById("tooltiplayer").style.visibility = "hidden" ;
}
function autoschedule1(){
	 var frmObj				= parent.f_compound_detail.document.prescription_compdetail_form;
	 var bean_id			= frmObj.bean_id.value;
	 var bean_name			= frmObj.bean_name.value;
	 var patient_id			= frmObj.patient_id.value;
	 var encounter_id		= frmObj.encounter_id.value;
	 var drug_code		    = frmObj.drug_code1.value;	
	 var qryString	= bean_id+"&bean_name="+bean_name+"&validate=AUTOSCHEDULE1&drug_code="+drug_code+"&patient_id="+patient_id+"&encounter_id="+encounter_id;
	submitXML(qryString, "");
}

async function DisplaySchedule(obj) {
	var noOfDrgus	= 0;
	var frmObj		= parent.f_compound_detail.document.prescription_compdetail_form;
	var bean_id		= frmObj.bean_id.value;
	var bean_name	= frmObj.bean_name.value;
	var freq_code	= frmObj.frequency.value;
	var facility_id	= frmObj.facility_id.value;
	
	for(dcno=1;dcno<=10;dcno++){
		if(eval("frmObj.drug_code"+dcno).value !="") noOfDrgus+=1;
	}
	var drug_code = frmObj.drug_code1.value;
	if(noOfDrgus == "0"){
    	alert(getMessage("DRUG_CANT_BE_BLANK","PH"));
		return;
	}
	var row_value		= "1";
	var	max_qty			= 0;
	var	unit_qty		= 0;
	var split_dose_yn	= "N";
	var split_qty		= frmObj.dosage.value;;
	var qty_reqd_yn		= "N";
	var uom_desc;
	if(frmObj.uom  == null){
         uom_desc  =  document.getElementById('qty_uom').innerText; 
	}
	else{
		 uom_desc		= frmObj.uom.options[frmObj.uom.selectedIndex].value;
	}
	uom_desc=encodeURIComponent(uom_desc,"UTF-8");//Modified for CRF--0749 INC-13640
	var chk_max			= "N";
	var chk_unit		= "N";
	if(max_qty != "0"){
		chk_max = "Y";   
	}
	if(unit_qty != "0"){
		chk_unit = "Y";
	}
	var start_time_day_param = frmObj.start_date.value;
	var pr_duration			 = frmObj.durn_value.value;
	var pr_duration_type	 = frmObj.durn_type_desc.value;
	var durationType_P		 = frmObj.durn_type.value;
	if(uom_desc !="" && split_qty != "") {
		var dialogTop		= "260";
		var dialogHeight	= "40vh";
		var dialogWidth		= "50vw";
		var features		= 'Width:' + dialogWidth +'; dialogHeight:' + dialogHeight + '; dialogWidth:' + dialogWidth +'; dialogTop:'+dialogTop +'; scroll=no; status=no';
		var arguments		= "";
		var retVal 			= await window.showModalDialog("../../eOR/jsp/ScheduleFrequency.jsp?mode=1&bean_id="+bean_id+"&uom_desc="+uom_desc+"&bean_name="+bean_name+"&chk_max="+chk_max+"&chk_unit="+chk_unit+"&max_qty="+max_qty+"&split_dose_yn="+split_dose_yn+"&split_qty="+split_qty+"&qty_reqd_yn="+qty_reqd_yn+"&unit_qty="+unit_qty+"&code="+drug_code+"&row_value="+row_value+"&facility_id="+facility_id+"&freq_code="+freq_code+"&module_id=PH&called_from=&start_time_day_param="+start_time_day_param+"&pr_duration="+pr_duration+"&pr_duration_type="+pr_duration_type+"&org_drug_code=null&interval_durn_type="+durationType_P,arguments,features);
	    if(retVal!=null) {
			var split_vals = retVal[1].split('~~');			
			var len = frmObj.frequency.options.length;			
			for(img=0;img<len;img++){
				if(frmObj.frequency.options[img].value==split_vals[0]){
					frmObj.frequency.selectedIndex= img	;
					break;
				}
			}
			ValidateDosage();	
			//setSchedule(frmObj.dosage.value);
			var len1 = frmObj.durn_type_desc.options.length;
			for(img1=0;img1<len1;img1++){
				if(frmObj.durn_type_desc.options[img1].value==retVal[3]){
					frmObj.durn_type_desc.selectedIndex= img1	;
					break;
				}
			}
			frmObj.durn_value.value=retVal[2];
			frmObj.durn_value.focus();
			frmObj.durn_value.blur();

			frmObj.sched_medn_yn.value = "Y";
		}
		else {
			frmObj.sched_medn_yn.value	= "N";
		}
	}	
	autoschedule1();
}

function setSchedule(dosage) {
	if(dosage == null) 
		dosage = "";
	var frmObj			= parent.f_compound_detail.document.prescription_compdetail_form;
	var mode = frmObj.mode.value;
	var qty_value = frmObj.qty_value.value;
	//alert("qty_value="+qty_value+",dosage="+dosage)
	if(qty_value != dosage){
		//alert("inside");
		deleteSchedule();
		makeAutoSchedule();
		if(dosage!="")
			frmObj.qty_value.value = dosage;
	}
}

function deleteSchedule() {
	var frmObj			= parent.f_compound_detail.document.prescription_compdetail_form;
	var bean_id			= frmObj.bean_id.value;
	var bean_name		= frmObj.bean_name.value;
	var patient_id		= frmObj.patient_id.value;
	var encounter_id	= frmObj.encounter_id.value;	
	var drug_code		= frmObj.drug_code1.value;
	var freq_code		= frmObj.frequency.value;

		if(frmObj.btn_schedule)
			frmObj.querySelectorAll('#btn_schedule').disabled=true;
		frmObj.querySelectorAll('#dosage_label').innerHTML="<label></label>";

   	var qryString	= bean_id+"&bean_name="+bean_name+"&validate=DELETESCHEDULE&drug_code="+drug_code+"&patient_id="+patient_id+"&encounter_id="+encounter_id+"&freq_code="+freq_code;
	submitXML(qryString, "");

}

function makeAutoSchedule() {
	// check schedule chkbox is enabled & freq is selected
	// automatic scheduling
	var frmObj	= parent.f_compound_detail.document.prescription_compdetail_form;
	var bean_id			= frmObj.bean_id.value;
	var bean_name		= frmObj.bean_name.value;
	var patient_id		= frmObj.patient_id.value;
	var encounter_id	= frmObj.encounter_id.value;	
	
	if(frmObj.frequency.value!="") {
		start_date		= frmObj.start_date.value;
		qty_value		= frmObj.dosage.value;
		freq_code		= frmObj.frequency.value;
		drug_code		= frmObj.drug_code1.value;	

		if(qty_value!="" && qty_value!=="0") {
			var qryString	= bean_id+"&bean_name="+bean_name+"&validate=AUTOSCHEDULE&freq_code="+freq_code+"&start_date="+start_date+"&qty_value="+qty_value+"&drug_code="+drug_code+"&patient_id="+patient_id+"&encounter_id="+encounter_id;
			submitXML(qryString, "");
		}
	}
}

function chkBlank(){
	
	var noOfDrgus = 0;
	var frmObj	= document.prescription_compdetail_form;
	var dosage  = frmObj.dosage;
	if(frmObj.drug_code1.value !="") noOfDrgus+=1;
	if(frmObj.drug_code2.value !="") noOfDrgus+=1;
	if(frmObj.drug_code3.value !="") noOfDrgus+=1;
	if(frmObj.drug_code4.value !="") noOfDrgus+=1;
	for(dcno=5;dcno<=10;dcno++)
	{
		if(eval("frmObj.drug_code"+dcno).value !="") noOfDrgus+=1;
	}
	if(noOfDrgus >=2){
		if(dosage.value == '' || dosage.value == '0'){
		   document.prescription_compdetail_form.frequency.selectedIndex=0;
		   document.prescription_compdetail_form.btn_schedule.disabled=true;
		   document.prescription_compdetail_form.dosage_label.innerHTML="<label></label>";
		   
		   alert(getMessage("DSG_CANT_ZERO_BLANK","PH"));
			dosage.focus();
			dosage.select();
		}
	}
}

function ValidateDosage(){
	
	var dosage=document.prescription_compdetail_form.dosage;
	var frequency=document.prescription_compdetail_form.frequency;
	var noOfDrgus = 0;
	var frmObj	= document.prescription_compdetail_form;
	
	if(frmObj.drug_code1.value !="") noOfDrgus+=1;
	if(frmObj.drug_code2.value !="") noOfDrgus+=1;
	if(frmObj.drug_code3.value !="") noOfDrgus+=1;
	if(frmObj.drug_code4.value !="") noOfDrgus+=1;
	for(dcno=5;dcno<=10;dcno++)
	{
		if(eval("frmObj.drug_code"+dcno).value !="") noOfDrgus+=1;
	}
	if(noOfDrgus >=2){
		if(dosage.value == '' || dosage.value == '0'){
			frequency.selectedIndex=0;
			document.prescription_compdetail_form.btn_schedule.disabled=true;
			document.prescription_compdetail_form.dosage_label.innerHTML="<label></label>";
			alert(getMessage("DSG_CANT_ZERO_BLANK","PH"));
			dosage.focus();
			dosage.select();
			return false;
		}else{
			populateDurationDesc(frequency);
			//setSchedule(frequency);
			setSchedule(dosage.value);
			document.prescription_compdetail_form.btn_schedule.disabled=false;
		}
		if(document.prescription_compdetail_form.durn_value.value=="" || document.prescription_compdetail_form.durn_value.value==null)
		document.prescription_compdetail_form.durn_value.value="1";
	}


}

function reconstructlist(){
	if(PrescribingBase=="S")
	{
		var frmObj	= document.prescription_compdetail_form;
		var len =document.prescription_compdetail_form.uom.options.length;
		for(var i=0;i<len;i++) {
			document.prescription_compdetail_form.uom.remove("uom") ;
		}
		var element = document.createElement("OPTION") ;
		element.value = "" ;
		element.text = "--Select--";
		frmObj.uom.add(element);
		if(frmObj.strength_uom1.value != "" && frmObj.strength_uom1.value != undefined){
			element = document.createElement('OPTION') ;
			element.value		=  1 ;
			element.text		=  (frmObj.strength_uom1.value)+"            ";
			frmObj.uom.add(element);
		}
		if(frmObj.strength_uom2.value != "" && frmObj.strength_uom2.value != undefined){
			element = document.createElement('OPTION') ;
			element.value		=  2 ;
			element.text		=  (frmObj.strength_uom2.value)+"            ";
			frmObj.uom.add(element);
		}
		if(frmObj.strength_uom3.value != "" && frmObj.strength_uom3.value != undefined){
			element = document.createElement('OPTION') ;
			element.value		=  3 ;
			element.text		=  (frmObj.strength_uom3.vlaue)+"            ";
			frmObj.uom.add(element);
		}
		if(frmObj.strength_uom4.value != "" && frmObj.strength_uom4.value != undefined){
			element = document.createElement('OPTION') ;
			element.value		=  4 ;
			element.text		=  (frmObj.strength_uom4.vlaue)+"            ";
			frmObj.uom.add(element);
		}
		for(var j=5;j<=10;j++)
		{
			if(eval("frmObj.strength_uom"+j).value != "" && eval("frmObj.strength_uom"+j).value != undefined){
				element = document.createElement('OPTION') ;
				element.value		=  j ;
				element.text		=  (eval("frmObj.strength_uom"+j).vlaue)+"            ";
				frmObj.uom.add(element);
			}
		}
	}
}
function callClearAll(){
//	parent.f_compound_detail.document.prescription_compdetail_form.reset();
	var drugForm	= parent.f_compound_detail.document.prescription_compdetail_form;

	var bean_id = drugForm.bean_id.value;
	var bean_name = drugForm.bean_name.value
	var xmlStr ="<root><SEARCH ";
	xmlStr +=" /></root>";

	var temp_jsp="PrescriptionCompValidate.jsp?validate=DELETE_ALL_DRUGs"+"&bean_id="+bean_id+"&bean_name="+bean_name;
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest() ;
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST",temp_jsp,false);
	xmlHttp.send(xmlDoc);
	responseText=xmlHttp.responseText ;
	eval(responseText);
    parent.f_compound_detail.location.reload();
 }

function validate(frmObj) {

	var fields	= new Array();
	var names	= new Array();
	var   i		= 0;

	if(frmObj.allergy!=null) {
		fields[i]	= frmObj.allergy;
		names[i]	= "Allergic Override Reason";
		i++;
	}

	if(frmObj.exceed_dose!=null) {
		fields[i]	= frmObj.exceed_dose;
		names[i]	= "Exceed Dosage Override Reason";
		i++;

	}

	if(frmObj.dup_drug!=null) {
		fields[i]	= frmObj.dup_drug;
		names[i]	= "Duplicate Drug Override Reason";
		i++;
	}


	if(checkFlds(fields,names))
			if(checkMaxSize(fields,names))
			storeOverRideReason(frmObj);
}

function storeOverRideReason(frmObj) {
	
	current_rx	=	frmObj.current_rx.value;
	limit_ind	=	frmObj.limit_ind.value;
	allergy_yn	=	frmObj.allergy_yn.value;
	drug_code	=	frmObj.drug_code.value;
	srl_no		=	frmObj.srl_no.value;
	bean_id		=	frmObj.bean_id.value;
	bean_name	=	frmObj.bean_name.value;
	allergy		=	"";
	exceed_dose	=	"";
	dup_drug	=	"";
	//Added for IN:072715  start
	dose_remarks_code = "";
	allergy_remarks_code = "";
	dup_drug_remarks_code = ""
	//Added for IN:072715  end
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
// Modified for IN:072715 end	

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
		
		//Added for IN:072715 start
		xmlStr+= "dose_remarks_code =\"" + dose_remarks_code + "\" " ;
		xmlStr+= "allergy_remarks_code =\"" + allergy_remarks_code + "\" " ;
		xmlStr+= "dup_drug_remarks_code =\"" + dup_drug_remarks_code + "\" " ;
		//Added for IN:072715 end
		
		xmlStr +=" /></root>";

		var temp_jsp="PrescriptionCompValidate.jsp?validate=override_reason"+"&bean_id="+bean_id+"&bean_name="+bean_name;
		var xmlDoc = "" ;
		var xmlHttp = new XMLHttpRequest() ;
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open("POST",temp_jsp,false);
		xmlHttp.send(xmlDoc);
		responseText=xmlHttp.responseText ;

//		window.returnValue = allergy + ":::" + exceed_dose + ":::" + dup_drug + ":::" +  +allergy_remarks_code + ":::" + dose_remarks_code + ":::" + dup_drug_remarks_code + ":::";// Modified for IN:072715
//		parent.window.close();
		
		let dialogBody = parent.document.getElementById('dialog-body');
	    dialogBody.contentWindow.returnValue = allergy + ":::" + exceed_dose + ":::" + dup_drug + ":::" +  +allergy_remarks_code + ":::" + dose_remarks_code + ":::" + dup_drug_remarks_code + ":::";
	    
	    const dialogTag = parent.document.getElementById("dialog_tag");    
	    dialogTag.close();  
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

function checkMaxSize(fields,names) {
	var errors = "" ;
	for( var i=0; i<fields.length; i++ ) {
		if(fields[i].value.length > 255)
			errors = errors + "APP-000002 " + names[i] + " cannot exceed 255 characters" + "\n" ;
	}
	if ( errors.length != 0 ) {
		alert(errors) ;
		return false ;
	}
	return true ;
}

async function showAllergyDetails(generic_id, patient_id, encounter_id, generic_name, drug_name) {
	var dialogTop		= "";
 	var dialogHeight	= "42vh";
 	var dialogWidth		= "55vw";
	var dialogLeft		= "240";
 	var features		= 'Width:' + dialogWidth +'; dialogHeight:' + dialogHeight + '; dialogWidth:' + dialogWidth +'; dialogLeft:' + dialogLeft +';  dialogTop:'+dialogTop +'; scroll=auto; status=no';
 	var arguments		= "";
 	var retVal 			= await window.showModalDialog("../jsp/PrescriptionAllergyDetailsFrames.jsp?generic_name="+generic_name+"&encounter_id="+encounter_id+"&generic_id="+generic_id+"&patient_id="+patient_id+"&drug_name="+drug_name,arguments,features);
}
async function showMonoGraph(drug_desc,mono_graph,daily_dose,unit_dose,min_daily_dose,min_unit_dose,dosage_unit,dosage_std,max_daily_ceiling_dose,min_daily_ceiling_dose,max_unit_ceiling_dose,min_unit_ceiling_dose,dose_unit_desc,dose_unit_desc1){
//modified for ML-MMOH-CRF-1408

	var retVal;
	var dialogTop		= "";
 	var dialogHeight	= "35vh" ;
 	var dialogWidth		= "50vw" ;
	var dialogLeft		= "" ;
 	var features		= 'Width:' + dialogWidth +'; dialogHeight:' + dialogHeight + '; dialogWidth:' + dialogWidth +'; dialogLeft:' + dialogLeft +';  dialogTop:'+dialogTop +'; scroll=no; status=no';
 	var arguments		= "";
 	retVal 				=    await top.window.showModalDialog("../../ePH/jsp/PrescriptionDosageLimitMonoGraph.jsp?drug_desc="+decodeURIComponent(drug_desc,"UTF-8")+"&mono_graph="+mono_graph+"&daily_dose="+daily_dose+"&unit_dose="+unit_dose+"&min_daily_dose="+min_daily_dose+"&min_unit_dose="+min_unit_dose+"&dosage_unit="+dosage_unit+"&max_daily_ceeling_dose="+max_daily_ceiling_dose+"&min_daily_ceeling_dose="+min_daily_ceiling_dose+"&max_unit_ceeling_dose="+max_unit_ceiling_dose+"&min_unit_ceeling_dose="+min_unit_ceiling_dose+"&dose_unit_desc="+dose_unit_desc+"&dose_unit_desc1="+dose_unit_desc1+"&dosage_std="+dosage_std,arguments,features);
	//max_unit_ceiling_dose added for ML-MMOH-CRF-1408
}

async function callCurrentMedication(patient_id, encounter_id, generic_id) {
	if(generic_id == undefined)
		generic_id="";
	var dialogHeight	= "900px";
	var dialogWidth		= "800px";
	var dialogTop		= "250";
	var center			= "1";
	var status			= "no";
	var features		= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop;
	var arguments		= "";
	var retVal			= await window.showModalDialog("../jsp/PrescriptionActiveOrderDetailsFrame.jsp?patient_id="+patient_id+"&encounter_id="+encounter_id+"&generic_id="+generic_id,arguments,features);
}

async function showOverrideReason(order_id,rec_count,drug_db_interface_yn,drug_db_duptherapy_flag,drug_db_allergy_flag,allergy_yn,current_rx,limit_ind,drug_db_dosecheck_yn){
//drug_db_dosecheck_yn addedf or ML-MMOH-CRF-1408
	var allergy_override    = "N";
	var dose_override	    = "N";
	var currentrx_override  = "N";
	var dose_override		= "";
	var allergy_remarks		= ""; 
	var currentrx_remarks	= "";
	var dose_remarks		= "";

	var frmObj			= document.prescription_compdetail_form;
	var drug_code		= eval("document.prescription_compdetail_form.drug_code"+rec_count).value;
	var srl_no=rec_count;
		rec_no	=	rec_count;
		patient_id		= frmObj.patient_id.value;
		encounter_id	= frmObj.encounter_id.value;
	var bean_id			= frmObj.bean_id.value;
	var bean_name		= frmObj.bean_name.value;

	if(document.getElementById("ALLERGY_DESC"+rec_no) != undefined && document.getElementById("ALLERGY_DESC"+rec_no).value!="")
		allergy_remarks = document.getElementById("ALLERGY_DESC"+rec_no).value;

	if(document.getElementById("EXCEED_DOSE_DESC"+rec_no).value!="")
		dose_remarks = document.getElementById("EXCEED_DOSE_DESC"+rec_no).value;

	if(document.getElementById("DUP_DRUG_DESC"+rec_no).value!="")
		currentrx_remarks = document.getElementById("DUP_DRUG_DESC"+rec_no).value;

	var dialogHeight	= "20";
	
	if(current_rx=="Y" && limit_ind=="N" && allergy_yn=="Y")
		dialogHeight	= "21";
	else if ( (current_rx=="Y" && limit_ind=="N") || (current_rx=="Y" && allergy_yn=="Y") || (limit_ind=="N" && allergy_yn=="Y" ))
		dialogHeight	= "16";
	else
		dialogHeight	= "12";

	var dialogWidth		= "40";
	var dialogTop		= "285";
	var dialogLeft		= "100";
	var center			= "0";
	var status			= "no";
	var features		= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop+"; dialogLeft :"+dialogLeft;
	var arguments		= "";
	retArray			= await window.showModalDialog("../jsp/CompoundingOverRideReason.jsp?order_id="+order_id+"&bean_id="+bean_id+"&order_line_num="+rec_count+"&srl_no="+srl_no+"&bean_name="+bean_name+"&drug_code="+drug_code+"&pat_id="+patient_id+"&enc_id="+encounter_id+"&drug_db_duptherapy_flag="+drug_db_duptherapy_flag+"&drug_db_allergy_flag="+drug_db_allergy_flag+"&allergy_yn="+allergy_yn+"&current_rx="+current_rx+"&limit_ind="+limit_ind+"&drug_db_interface_yn="+drug_db_interface_yn+"&allergy="+encodeURIComponent(allergy_remarks,"UTF-8")+"&dup_drug="+encodeURIComponent(currentrx_remarks,"UTF-8")+"&drug_db_dosecheck_yn="+drug_db_dosecheck_yn, arguments, features);
//modified for ML-MMOH-CRF-1408
	
	if ( retArray != null && retArray != "" ) {
		
		var split_vals	= retArray.split(":::");
		document.getElementById("ALLERGY_DESC"+srl_no).value		= split_vals[0];
		document.getElementById("EXCEED_DOSE_DESC"+srl_no).value	= split_vals[1];
		document.getElementById("DUP_DRUG_DESC"+srl_no).value		= split_vals[2];
		
		if(split_vals[0] !="") allergy_override = "Y"; 
		if(split_vals[1] !="") dose_override = "Y"; 
		if(split_vals[2] !="") currentrx_override = "Y"; 


		if(allergy_yn == "N"){allergy_override = "N";}
		if(current_rx == "N"){currentrx_override = "N";}
		overrideImg(allergy_yn,allergy_override,limit_ind,dose_override,current_rx,currentrx_override);
		//showOverride(rec_count);
	}
}

function showOverride(rec_count){
    drug_code		=  eval("document.prescription_compdetail_form.drug_code"+rec_count).value;

	overRideRemarks(drug_code,rec_count);
}


function callOrderAmend(rec_count) {
	
	getRemarks(rec_count);
	/*var vals		 = "";
	var drug_code	 = "";
	var frmObj		 = "";
	
	var pres_remarks = eval("document.prescription_compdetail_form.pres_remarks"+rec_count).value;
	var ret_rmrks	 = pres_remarks.split(",");

	for(i=0; i<pres_vals.length; i++)	{
		if(i==pres_vals.length)
			vals	+= pres_vals[i];
		else
			vals	+= pres_vals[i]+ "::";
	}

		frmObj		= document.prescription_compdetail_form
		var drug_code =eval("document.prescription_compdetail_form.drug_code"+rec_count).value;

	callAmendRemarks( formatId, drug_code,'PH', '0', 'PH', vals,rec_count,pres_remarks);*/
}
/*
function callAmendRemarks(format_id,catalog_code,order_category,row_value,called_from,pres_vals,rec_count,pres_remarks)    {
		
	var patient_id      = parent.parent.f_header.document.prescription_header_form.patient_id.value;
	var encounter_id	= parent.parent.f_header.document.prescription_header_form.encounter_id.value;
	order_id			= document.prescription_compdetail_form.order_id.value;	 
	order_line_no		= rec_count;
	
	
    bean_id				= "@orderentrybean"+patient_id+encounter_id;
    bean_name			= "eOR.OrderEntryBean";
    srl_no				= "0";
    var dialogHeight	= "25" ;
    var dialogWidth		= "50" ;
    var dialogTop		= "169" ;
    var center			= "1" ;
    var status			="no";
    var features    = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop;
    var arguments   = "" ;
	
	if(pres_remarks!="")
		format_id="";
	retVal = window.showModalDialog("../../eOR/jsp/OrderEntryOrderFormatFrameSet.jsp?bean_id="+bean_id+"&bean_name="+bean_name+"&order_id="+order_id+"&order_line_num="+order_line_no+"&format_id="+format_id+"&p_catalog_code="+catalog_code+"&order_category="+order_category+"&row_value=0&called_from=PH"+"&p_form_code="+form_code+"&p_route_code="+route_code,arguments,features);
}*/
 
 function validateRemarksAmend(format_id)    {
	var format		=   format_id.split("~");
	var mandatory   =   format[0];
	formatId		=   format[1];
}

function default_override_rsn(sel_rec){
	currentrx		= document.getElementById("currentrx_"+sel_rec);
	currentrx_img	= document.getElementById("currentrx_img"+sel_rec);
	dup_drug_desc	= document.getElementById("DUP_DRUG_DESC"+sel_rec);
	drug_name		= document.getElementById("drug_name"+sel_rec);
	drug_code_obj	= document.getElementById("drug_code"+sel_rec);
	chk_ovr			= document.getElementById("chk_ovr"+sel_rec);

	if(drug_name != undefined){
		if(currentrx.style.visibility == 'visible'){

			if(dup_drug_desc.value == ""){
				dup_drug_desc.value = "Overridden by Practitioner";
				currentrx_img.style.visibility = 'hidden';
			}

			current_rx	=	"Y";
			limit_ind	=	"";
			allergy_yn	=	"";
			drug_code	=	drug_code_obj.value;
			srl_no		=	sel_rec;
			bean_id		=	document.prescription_compdetail_form.bean_id.value;
			bean_name	=	document.prescription_compdetail_form.bean_name.value;
			allergy		=	"";
			exceed_dose	=	"";
			dup_drug	=	dup_drug_desc.value;


			var xmlStr ="<root><SEARCH ";
			xmlStr+= "current_rx  =\"" + current_rx + "\" " ;
			xmlStr+= "limit_ind =\"" + limit_ind + "\" " ;
			xmlStr+= "allergy_yn  =\"" + allergy_yn + "\" " ;
			//					xmlStr+= "allergy =\"" + allergy + "\" " ;
			//					xmlStr+= "exceed_dose =\"" + exceed_dose + "\" " ;
			xmlStr+= "dup_drug =\"" + dup_drug + "\" " ;
			xmlStr+= "drug_code =\"" + drug_code + "\" " ;
			xmlStr+= "srl_no =\"" + srl_no + "\" " ;
			xmlStr+= "bean_id =\"" + bean_id + "\" " ;
			xmlStr+= "bean_name=\"" + bean_name + "\" " ;
			xmlStr +=" /></root>";

			var temp_jsp="PrescriptionCompValidate.jsp?validate=override_reason"+"&bean_id="+bean_id+"&bean_name="+bean_name;
			var xmlDoc = "" ;
			var xmlHttp = new XMLHttpRequest() ;
			xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
			xmlHttp.open("POST",temp_jsp,false);
			xmlHttp.send(xmlDoc);
			responseText=xmlHttp.responseText ;
		}	
	}
}

function assignTdmOrderid(tdmOrderId){
	var tdmOrderId_obj				=	eval("document.prescription_compdetail_form.tdmOrderId"+rec_no);
	var tdmRslt_obj					=	document.getElementById("tdmRslt_"+rec_no);
	tdmOrderId_obj.value			= tdmOrderId;
	tdmRslt_obj.style.visibility	='visible';
}

async function viewReasonforRequest(orderId){
	var dialogHeight ='9' ;
	var dialogWidth = '25' ;
	var dialogTop	= '189';
	var dialogLeft = '167' ;
	var title = ''
	var features = 'dialogHeight:' + dialogHeight + '; dialogWidth:' + dialogWidth +';dialogTop:'+dialogTop+';dialogLeft:'+dialogLeft+';dialogTitle:'+title+'; scroll=yes; status=no';
	var arguments = "";
	var finalString	= "&readonly=readOnly&orderId="+orderId;
	var retVals = await window.showModalDialog("../../eOR/jsp/TDMReasonforrequest.jsp?"+finalString,arguments,features);
}

function extdosechk(){
	var drug_db_interface_yn	  = parent.parent.f_header.document.prescription_header_form.drug_db_interface_yn.value;
	var drug_db_dosecheck_yn	  = parent.parent.f_header.document.prescription_header_form.drug_db_dosecheck_yn.value;
	if(drug_db_interface_yn=='Y'&& drug_db_dosecheck_yn=='Y'){

		var pat_id			      = parent.parent.f_header.document.prescription_header_form.patient_id.value;
		var weight			      = parent.parent.f_header.document.prescription_header_form.weight.value;
		if(weight=="")
			weight="0";
		var bsa			      = parent.parent.f_header.document.prescription_header_form.bsa.value;
		if(bsa=="")
			bsa="0";

		var bean_id			  =	document.prescription_compdetail_form.bean_id.value;
		var bean_name	      =	document.prescription_compdetail_form.bean_name.value;
		var frequency         =	document.prescription_compdetail_form.frequency.value; 
		var duration          =	document.prescription_compdetail_form.durn_value.value;
		var dosage_1		  =	document.prescription_compdetail_form.absol_qty1.value;
		var dosage_2		  =	document.prescription_compdetail_form.absol_qty2.value;
		var dosage_3		  =	document.prescription_compdetail_form.absol_qty3.value;
		var dosage_4		  =	document.prescription_compdetail_form.absol_qty4.value;
		var dosage_5		  =	document.prescription_compdetail_form.absol_qty5.value;
		var dosage_6		  =	document.prescription_compdetail_form.absol_qty6.value;
		var dosage_7		  =	document.prescription_compdetail_form.absol_qty7.value;
		var dosage_8		  =	document.prescription_compdetail_form.absol_qty8.value;
		var dosage_9		  =	document.prescription_compdetail_form.absol_qty9.value;
		var dosage_10		  =	document.prescription_compdetail_form.absol_qty10.value;        
		var durn_type_desc = document.prescription_compdetail_form.durn_type_desc.value;   //added for IN2487  --19/10/2010-- priya
		var repeat_durn_type= document.prescription_compdetail_form.durn_type.value;// Added in January 2014 for CIMS dosage check -start
		var freq_nature       =	document.prescription_compdetail_form.freq_nature.value;//Added in January 2014, CIMS Dosage Check
		var route_code       =	document.prescription_compdetail_form.route_code.value;// Added in January 2014 for CIMS dosage check 
		var qty_desc_code       =	document.prescription_compdetail_form.qty_desc_code.value;// Added in January 2014 for CIMS dosage check 
		if(frequency!="" && duration!="" && frequency!=null && duration!=null){
			if(dosage_1!=""||dosage_2!=""||dosage_3!=""||dosage_4!=""||dosage_5!=""||dosage_6!=""||dosage_7!=""||dosage_8!=""||dosage_9!=""||dosage_10!=""){
				var xmlStr ="<root><SEARCH ";
				xmlStr+= "patient_id=\"" + pat_id + "\" ";
				xmlStr+= "weight=\"" + weight + "\" ";
				xmlStr+= "bsa=\"" + bsa + "\" ";		
				xmlStr+= "frequency=\"" + frequency + "\" ";
				xmlStr+= "duration=\"" + duration + "\" ";
				xmlStr+= "dosage_1=\"" + dosage_1 + "\" ";
				xmlStr+= "dosage_2=\"" + dosage_2 + "\" ";
				xmlStr+= "dosage_3=\"" + dosage_3 + "\" ";
				xmlStr+= "dosage_4=\"" + dosage_4 + "\" ";						
				xmlStr+= "dosage_5=\"" + dosage_5 + "\" ";						
				xmlStr+= "dosage_6=\"" + dosage_6 + "\" ";						
				xmlStr+= "dosage_7=\"" + dosage_7 + "\" ";						
				xmlStr+= "dosage_8=\"" + dosage_8 + "\" ";						
				xmlStr+= "dosage_9=\"" + dosage_9 + "\" ";						
				xmlStr+= "dosage_10=\"" + dosage_10 + "\" ";						
				xmlStr+= "bean_id =\"" + bean_id + "\" " ;
				xmlStr+= "bean_name=\"" + bean_name + "\" " ;
				xmlStr+= "durn_type_desc=\"" + durn_type_desc + "\" "; //added for IN2487  --19/10/2010-- priya
				xmlStr+= "route_code=\"" + route_code + "\" " ; // Added in January 2014 for CIMS dosage check -start
				xmlStr+= "qty_desc_code=\"" + qty_desc_code + "\" " ;
				xmlStr+= "repeat_durn_type=\"" + repeat_durn_type + "\" " ;
				xmlStr+= "freq_nature=\"" + freq_nature + "\" " ;  //Added in January 2014, CIMS Dosage Check -end
				xmlStr +=" /></root>";
				var temp_jsp="PrescriptionCompValidate.jsp?validate=External_Dosage_Check"+"&bean_id="+bean_id+"&bean_name="+bean_name+"&drug_db_interface_yn="+drug_db_interface_yn;
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
}

async function loadDrugInfo(formname,row_no){

	var prodid			= document.getElementById("external_prod_id_"+row_no).value;
    var drugdesc		= document.getElementById("drug_name"+row_no).value;

	var dialogHeight	="85" ;
	var dialogWidth	="70";
	var dialogTop		= "110" ;
	var dialogLeft		= "80" ;
	var center			= "0" ;
	var status			= "no";
	var features	    = "dialogHeight:" + dialogHeight +"; dialogLeft:"+dialogLeft+ "; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop;
	var arguments	= "";
	retVal = await window.showModalDialog("../../ePH/jsp/DisplayDrugInfoFrames.jsp?extprodid="+prodid+"&drugdesc="+drugdesc+"&JSFile=../../ePH/js/PrescriptionComp.js",arguments,features);
}

function closeInfo(){
	//this.window.close();
	
    
    const dialogTag = parent.parent.document.getElementById("dialog_tag");    
    dialogTag.close();  
}


async function viewMedicationAlert(drug_code,srl_no,patient_id,ext_prod_id,drug_db_interact_check_flag,drug_db_duptherapy_flag,drug_db_contraind_check_flag,drug_db_dose_check_flag,called_from,external_dosage_override_reason,external_duplicate_override_reason,external_interaction_override_reason,external_contra_override_reason,external_alergy_override_reason,drug_db_allergy_flag){
	var pract_name= parent.parent.f_header.document.prescription_header_form.pract_name.value;
	if(drug_db_interact_check_flag=="Y"||drug_db_duptherapy_flag=="Y"||drug_db_contraind_check_flag=="Y"||drug_db_dose_check_flag=="Y" ||drug_db_allergy_flag=="Y"){
		DisplayFDBOverrideImage(srl_no,called_from);
		if(called_from=='ON_LOAD'){
			document.getElementById("ext_med_alerts_fired_for_dup_check_yn"+srl_no).value		=	drug_db_duptherapy_flag;
			document.getElementById("ext_med_alerts_fired_for_inte_check_yn"+srl_no).value		=	drug_db_interact_check_flag;
			document.getElementById("ext_med_alerts_fired_for_contra_check_yn"+srl_no).value	=	drug_db_contraind_check_flag;
			document.getElementById("ext_med_alerts_fired_for_allergy_check_yn"+srl_no).value	=	drug_db_allergy_flag;
		}
	}
	if(called_from!='ON_LOAD'){
		var dialogHeight	= "35" ;
		var dialogWidth	    = "65";
		var dialogTop	    = "100" ;
		var dialogLeft	    = "100" ;
		var center			= "0" ;
		var status			= "no";
		var features	    = "dialogHeight:" + dialogHeight +"; dialogLeft:"+dialogLeft+ "; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop;
		var arguments	= "";
//replaced escape with encodeURIComponent and encoded pract_name in the below line for IN23093 reopen --18/08/2010-- priya
		retVal = await window.showModalDialog("../../ePH/jsp/MedicationAlerts.jsp?&patient_id="+patient_id+"&external_product_id="+ext_prod_id+"&drug_db_interact_check_flag="+drug_db_interact_check_flag+"&drug_db_duptherapy_flag="+drug_db_duptherapy_flag+"&drug_db_contraind_check_flag="+drug_db_contraind_check_flag+"&drug_db_dosecheck_flag="+drug_db_dose_check_flag+"&srl_no="+srl_no+"&pract_name="+encodeURIComponent(pract_name,"UTF-8")+"&dsg_reason="+encodeURIComponent(external_dosage_override_reason,"UTF-8")+"&dup_reason="+encodeURIComponent(external_duplicate_override_reason,"UTF-8")+"&con_reason="+encodeURIComponent(external_contra_override_reason,"UTF-8")+"&int_reason="+encodeURIComponent(external_interaction_override_reason,"UTF-8")+"&alg_reason="+encodeURIComponent(external_alergy_override_reason,"UTF-8")+"&drug_db_allergy_flag="+drug_db_allergy_flag ,arguments,features);
		if(retVal!=null && retVal[0]!='CANCEL'){
			 var external_dosage_override_reason		=	"";
			 var external_duplicate_override_reason		=	"";
			 var external_interaction_override_reason	=	"";
			 var external_contra_override_reason		=	"";
			 var external_alergy_override_reason		=	"";
			 var reason		="";
			 var indicator	="";
			 for(i=0;i<retVal.length;i++){
				 reason=retVal[i];
				 indicator=reason.substring(0,5);
				 reason=retVal[i].substring(5,retVal[i].length);
				 if(indicator=='DSG_Y'){
					external_dosage_override_reason		=reason;
				 }
				 else if(indicator=='DUP_Y'){
					external_duplicate_override_reason	=reason;
				 }
				 else if(indicator=='CON_Y'){
					external_contra_override_reason		=reason;
				 }
				 else if(indicator=='ALG_Y'){
					external_alergy_override_reason		=reason;
				 }
				 else if(indicator=='INT_Y'){
					external_interaction_override_reason=reason;
				 }				   
			 }
			if(((drug_db_interact_check_flag=="Y")&&(external_interaction_override_reason==""))||((drug_db_duptherapy_flag=="Y")&&(external_duplicate_override_reason==""))||((drug_db_contraind_check_flag=="Y")&&(external_contra_override_reason==""))||((drug_db_dose_check_flag=="Y")&&(external_dosage_override_reason==""))||((drug_db_allergy_flag=="Y")&&(external_alergy_override_reason==""))){
				dosage_img				    = document.getElementById("external_img"+srl_no);
				dosage_img.style.visibility ='visible';
			}
			else{
				dosage_img				    = document.getElementById("external_img"+srl_no);
				dosage_img.style.visibility ='hidden';
			}   

			if(called_from=='DOSAGE'){
				external_db_dose_check     = document.getElementById("external_db_dose_check_"+srl_no);
				external_db_dose_check.value='Y';
			}

	   		bean_id		=	document.prescription_compdetail_form.bean_id.value;
			bean_name	=	document.prescription_compdetail_form.bean_name.value;

            document.getElementById("external_dosage_override_reason"+srl_no).value=external_dosage_override_reason;
			document.getElementById("external_interaction_override_reason"+srl_no).value=external_interaction_override_reason;
			document.getElementById("external_duplicate_override_reason"+srl_no).value=external_duplicate_override_reason;
		document.getElementById("external_contra_override_reason"+srl_no).value=external_contra_override_reason;
			document.getElementById("external_Alergy_override_reason"+srl_no).value=external_alergy_override_reason;
			//replaced escape with encodeURIComponent  in the below code for IN23093 reopen --18/08/2010-- priya

			var xmlStr ="<root><SEARCH ";					
			//xmlStr+= "External_Override_Reason =\"" + escape(retVal) + "\" " ;
			xmlStr+= "External_Dosage_Override_Reason =\"" + encodeURIComponent(external_dosage_override_reason,"UTF-8") + "\" " ;
			xmlStr+= "External_Duplicate_Override_Reason =\"" + encodeURIComponent(external_duplicate_override_reason,"UTF-8") + "\" " ;
			xmlStr+= "External_Interaction_Override_Reason =\"" + encodeURIComponent(external_interaction_override_reason,"UTF-8") + "\" " ;
			xmlStr+= "External_Contra_Override_Reason =\"" + encodeURIComponent(external_contra_override_reason,"UTF-8") + "\" " ;
			xmlStr+= "External_Alergy_Override_Reason =\"" + encodeURIComponent(external_alergy_override_reason,"UTF-8") + "\" " ;
			xmlStr+= "EXT_MED_ALERTS_FIRED_FOR_DOSAGE_CHECK_YN =\"" + drug_db_dose_check_flag + "\" " ;
			xmlStr+= "EXT_MED_ALERTS_FIRED_FOR_DUP_CHECK_YN =\"" + drug_db_duptherapy_flag + "\" " ;
			xmlStr+= "EXT_MED_ALERTS_FIRED_FOR_INTE_CHECK_YN =\"" + drug_db_interact_check_flag + "\" " ;
			xmlStr+= "EXT_MED_ALERTS_FIRED_FOR_CONTRA_CHECK_YN =\"" + drug_db_contraind_check_flag + "\" " ;
			xmlStr+= "EXT_MED_ALERTS_FIRED_FOR_ALLERGY_CHECK_YN =\"" + drug_db_allergy_flag + "\" " ;
			xmlStr+= "drug_code =\"" + drug_code + "\" " ;
			xmlStr+= "srl_no =\"" + srl_no + "\" " ;
			xmlStr+= "bean_id =\"" + bean_id + "\" " ;
			xmlStr+= "bean_name=\"" + bean_name + "\" " ;
			xmlStr +=" /></root>";

			var temp_jsp="PrescriptionCompValidate.jsp?validate=InsertExternalOverrideReason"+"&bean_id="+bean_id+"&bean_name="+bean_name;
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

function DisplayFDBOverrideImage(srl_no,called_from){	
	if(called_from=='DOSAGE'||called_from=='ON_LOAD'){
		ext_dose_ovrrdn_reason		= document.getElementById("external_dosage_override_reason"+srl_no).value;
		dosage_img				    = document.getElementById("external_img"+srl_no);
		dosage					    =document.getElementById("external_"+srl_no);	
		if(ext_dose_ovrrdn_reason!=""){
			dosage_img.style.visibility ='hidden';
		}
		else{
			dosage_img.style.visibility ='visible';
		}
		dosage.style.visibility     ='visible';
	}
    if(called_from=='DOSAGE'){
		external_db_dose_check     = document.getElementById("external_db_dose_check_"+srl_no);
		external_db_dose_check.value='Y';
	}
}

function HideFDBOverrideImage(srl_no,called_from){
    var ext_med_alerts_fired_for_dup_check_yn		=	document.getElementById("ext_med_alerts_fired_for_dup_check_yn"+srl_no).value;
	var ext_med_alerts_fired_for_inte_check_yn		=	document.getElementById("ext_med_alerts_fired_for_inte_check_yn"+srl_no).value;
	var ext_med_alerts_fired_for_contra_check_yn	=	document.getElementById("ext_med_alerts_fired_for_contra_check_yn"+srl_no).value;
    var external_db_dose_check			 = document.getElementById("external_db_dose_check_"+srl_no);
	if(called_from=='DOSAGE'){
		external_db_dose_check.value	 = 'N';
	}
	if(ext_med_alerts_fired_for_dup_check_yn=='N'&& ext_med_alerts_fired_for_inte_check_yn=='N'&&ext_med_alerts_fired_for_contra_check_yn=='N'&&external_db_dose_check.value=='N'){
		dosage_img					=document.getElementById("external_img"+srl_no);
		dosage						= document.getElementById("external_"+srl_no);
		dosage_img.style.visibility	='hidden';
		dosage.style.visibility		='hidden';
	}
}

function displayDosageCheckResult( srl_no ){

	var ext_med_alerts_fired_for_dup_check_yn		=	document.getElementById("ext_med_alerts_fired_for_dup_check_yn"+srl_no).value;
	var ext_med_alerts_fired_for_inte_check_yn		=	document.getElementById("ext_med_alerts_fired_for_inte_check_yn"+srl_no).value;
	var ext_med_alerts_fired_for_contra_check_yn	=	document.getElementById("ext_med_alerts_fired_for_contra_check_yn"+srl_no).value;
	var ext_med_alerts_fired_for_allergy_check_yn	=	document.getElementById("ext_med_alerts_fired_for_allergy_check_yn"+srl_no).value;

	var patient_id									=	document.prescription_compdetail_form.patient_id.value;
	var drug_code									=  document.getElementById("drug_code"+srl_no).value;
	var ext_prod_id									=  document.getElementById("external_prod_id_"+srl_no).value;

	var external_dosage_override_reason		=	document.getElementById("external_dosage_override_reason"+srl_no).value;
	var external_duplicate_override_reason		=	document.getElementById("external_duplicate_override_reason"+srl_no).value;
	var external_interaction_override_reason	=	document.getElementById("external_interaction_override_reason"+srl_no).value;
	var external_contra_override_reason		=	document.getElementById("external_contra_override_reason"+srl_no).value;
	var external_alergy_override_reason		=	document.getElementById("external_Alergy_override_reason"+srl_no).value;
		//var external_override_reason =  eval("document.getElementById("external_override_reason_")"+srl_no).value;
	var external_db_dose_check   =  document.getElementById("external_db_dose_check_"+srl_no).value;
	if(ext_med_alerts_fired_for_dup_check_yn=='Y' || ext_med_alerts_fired_for_inte_check_yn=='Y' || ext_med_alerts_fired_for_contra_check_yn=='Y' || external_db_dose_check=='Y' || ext_med_alerts_fired_for_allergy_check_yn=='Y'){
		viewMedicationAlert(drug_code,srl_no,patient_id,ext_prod_id,ext_med_alerts_fired_for_inte_check_yn,ext_med_alerts_fired_for_dup_check_yn,ext_med_alerts_fired_for_contra_check_yn,external_db_dose_check,"",external_dosage_override_reason,external_duplicate_override_reason,external_interaction_override_reason,external_contra_override_reason,external_alergy_override_reason,ext_med_alerts_fired_for_allergy_check_yn);
	}
}

function returnoverridereason(objname){
	var proceed = true;
	var retval= new Array();
	if(objname=='OK'){
		var formobj							=	parent.FrameMedicationAlertDetails.document.medication_alert_detail;
		var dosage_Override_Reason		="";
		var Duplicate_Override_Reason		="";
		var Interaction_Override_Reason	="";
		var Contra_Override_Reason		="";
		var Alergy_Override_Reason		="";

		if(formobj.Dosage_Override_Reason!=undefined)
		     dosage_Override_Reason			=	formobj.Dosage_Override_Reason.value;
		if(formobj.Duplicate_Override_Reason!=undefined)
		     Duplicate_Override_Reason		=	formobj.Duplicate_Override_Reason.value;
		if(formobj.Interaction_Override_Reason!=undefined)
			 Interaction_Override_Reason		=	formobj.Interaction_Override_Reason.value;
		if(formobj.Contra_Override_Reason!=undefined)
			 Contra_Override_Reason			=	formobj.Contra_Override_Reason.value;
		if(formobj.Alergy_Override_Reason!=undefined)
			 Alergy_Override_Reason			=	formobj.Alergy_Override_Reason.value;

		var drug_db_dosecheck_flag						=	formobj.drug_db_dosecheck_flag.value;
		var	drug_db_duptherapy_flag			=	formobj.drug_db_duptherapy_flag.value;
		var	drug_db_interact_check_flag		=	formobj.drug_db_interact_check_flag.value;
		var	drug_db_contraind_check_flag	=	formobj.drug_db_contraind_check_flag.value;	
		var drug_db_allergy_flag				=	formobj.drug_db_allergy_flag.value;			

		var external_db_interface			= 	 formobj.external_db_interface.value;		 //	   ADDED in JUNE 2012
		// ADDED in JUNE 2012 - CIMS Dosage
		if(formobj.dosage_interface!=undefined)
			dosage_interface			=	formobj.dosage_interface.value;
	    else
			dosage_interface			= "";
		if(external_db_interface!=null && external_db_interface=="CIMS"){  //Added in June 2012
			// Now only one reason. so add it condition based
			var overrideReason = Duplicate_Override_Reason;
			Duplicate_Override_Reason = "";
			if(drug_db_duptherapy_flag=="Y")
				Duplicate_Override_Reason =   overrideReason; // only ony reason and it will be stored here
			if(drug_db_interact_check_flag=="Y")
				Interaction_Override_Reason =   overrideReason; // only ony reason and it will be stored here
			if(drug_db_contraind_check_flag=="Y")
				Contra_Override_Reason =   overrideReason; // only ony reason and it will be stored here
			if(drug_db_allergy_flag=="Y")
				Alergy_Override_Reason =   overrideReason; // only ony reason and it will be stored here
			retval[0]="DSG_"+"N"+"";
			retval[1]="DUP_"+drug_db_duptherapy_flag+Duplicate_Override_Reason;
			retval[2]="INT_"+drug_db_interact_check_flag+Interaction_Override_Reason;
			retval[3]="CON_"+drug_db_contraind_check_flag+Contra_Override_Reason;
			retval[4]="ALG_"+drug_db_allergy_flag+Alergy_Override_Reason;
			// Modified condition - JUNE 2012 - CIMS - Dosage 
			if( dosage_interface!="DOSAGE" && (drug_db_duptherapy_flag=="Y" && Duplicate_Override_Reason=="") || (drug_db_interact_check_flag=="Y" && Interaction_Override_Reason=="") || (drug_db_contraind_check_flag=="Y" && Contra_Override_Reason=="") || (drug_db_allergy_flag=="Y" && Alergy_Override_Reason==""))	{
				alert(getMessage("OVERRIDE_REASON_NOT_BLANK", "PH"));
				proceed = false;
			}else{
				if(Duplicate_Override_Reason.length > 255 || Interaction_Override_Reason.length>255 || Alergy_Override_Reason.length>255 || Contra_Override_Reason.length>255){ //added for ML-MMOH-SCF-1381 and modifed 
					var msg = getMessage("REMARKS_CANNOT_EXCEED","Common");
					msg = msg.replace("$",getLabel("ePH.OverrideReason.label","PH"));
					msg = msg.replace("#",255);//modified
					alert(msg);
					proceed = false;
				}
			} 
		}
		else{
			retval[0]="DSG_"+drug_db_dosecheck_flag+dosage_Override_Reason;
			retval[1]="DUP_"+drug_db_duptherapy_flag+Duplicate_Override_Reason;
			retval[2]="INT_"+drug_db_interact_check_flag+Interaction_Override_Reason;
			retval[3]="CON_"+drug_db_contraind_check_flag+Contra_Override_Reason;
			retval[4]="ALG_"+drug_db_allergy_flag+Alergy_Override_Reason;
			// if condition added for IN18173  ==dt==18/01/2010 == Shyampriya
			if( (drug_db_dosecheck_flag=="Y" && dosage_Override_Reason=="") || (drug_db_duptherapy_flag=="Y" && Duplicate_Override_Reason=="") || (drug_db_interact_check_flag=="Y" && Interaction_Override_Reason=="") || (drug_db_contraind_check_flag=="Y" && Contra_Override_Reason=="") || (drug_db_allergy_flag=="Y" && Alergy_Override_Reason=="")){
				alert(getMessage("OVERRIDE_REASON_NOT_BLANK", "PH"));
				proceed = false;
			}
		}
	}
	else{
        retval[0]='CANCEL';
	}
	if(proceed==true){
//		window.returnValue=retval;
//		window.close();
		let dialogBody = parent.parent.document.getElementById('dialog-body');
	    dialogBody.contentWindow.returnValue = retval;
	    
	    const dialogTag = parent.parent.document.getElementById("dialog_tag");    
	    dialogTag.close();  
	}
}

function DefaultReason(obj1,obj2){
	var reason	=getLabel("ePH.OverriddenBy.label","PH")+" "+obj2.value;
	
	if(obj1.value==""){
	    obj1.value	=reason;
	}
}

function DefaultOverrideReasonForAll(){
    var formobj							=	parent.FrameMedicationAlertDetails.document.medication_alert_detail;
	var extProdid			=	formobj.external_db_interface.value;
	var Dosage_Override_Reason			=	formobj.Dosage_Override_Reason;
	var Duplicate_Override_Reason		=	formobj.Duplicate_Override_Reason;
	var Interaction_Override_Reason		=	formobj.Interaction_Override_Reason;
	var Contra_Override_Reason			=	formobj.Contra_Override_Reason;
	var Alergy_Override_Reason			=	formobj.Alergy_Override_Reason;
	var drug_db_dosecheck_flag			=	formobj.drug_db_dosecheck_flag.value;
	var	drug_db_duptherapy_flag			=	formobj.drug_db_duptherapy_flag.value;
	var	drug_db_interact_check_flag		=	formobj.drug_db_interact_check_flag.value;
	var	drug_db_contraind_check_flag	=	formobj.drug_db_contraind_check_flag.value;	
	var drug_db_allergy_flag				=	formobj.drug_db_allergy_flag.value;
	var pract_name						=	formobj.pract_name.value;
    var reason	="Overridden by "+pract_name;
	if(extProdid!='CIMS'){
		if((drug_db_duptherapy_flag=='Y')&&(Duplicate_Override_Reason!=undefined)&&(Duplicate_Override_Reason.value=="")){
			Duplicate_Override_Reason.value=reason;
		}
		if((drug_db_dosecheck_flag=='Y')&& (Dosage_Override_Reason!=undefined) &&(Dosage_Override_Reason.value=="")){
			Dosage_Override_Reason.value=reason;        
		}
		if((drug_db_interact_check_flag=='Y')&&(Interaction_Override_Reason!=undefined)&&(Interaction_Override_Reason.value=="")){
			Interaction_Override_Reason.value=reason;
		}
		if((drug_db_allergy_flag=='Y')&&(Alergy_Override_Reason!=undefined)&&(Alergy_Override_Reason.value=="")){
			Alergy_Override_Reason.value=reason;
		}
		if((drug_db_contraind_check_flag=='Y')&&(Contra_Override_Reason!=undefined)&&(Contra_Override_Reason.value=="")){
			Contra_Override_Reason.value=reason;
		}
	}
	else{
		Duplicate_Override_Reason.value=reason;
	}
}

function assignCheckValue(obj){
	if(obj.checked==true)
		obj.value="Y"
	else
		obj.value="N";
}


function adrdisplay(display_yn)	{

  // alert("calling ---->"+display_yn);

    if(display_yn=='Y'){
	   adr      = document.getElementById("ADR_"+rec_no);
	   adr_img  = document.getElementById("ADR_img_"+rec_no);

	    adr.style.visibility='visible';
		adr_img.style.visibility='visible';
	}

}

function displayChargeDetails(iv_prep_yn){

	var headerForm = parent.parent.f_header.document.prescription_header_form;
	var drugForm	= parent.f_compound_detail.document.prescription_compdetail_form;
	var drug_code1 = drugForm.drug_code1.value; 
	var drug_code2 = drugForm.drug_code2.value; 
	var drug_code3 = drugForm.drug_code3.value; 
	var drug_code4 = drugForm.drug_code4.value; 
	var drug_code5 = drugForm.drug_code5.value; 
	var drug_code6 = drugForm.drug_code6.value; 
	var drug_code7 = drugForm.drug_code7.value; 
	var drug_code8 = drugForm.drug_code8.value; 
	var drug_code9 = drugForm.drug_code9.value; 
	var drug_code10 = drugForm.drug_code10.value; 

	var absol_qty1 = drugForm.orderQty1.value; 
	var absol_qty2 = drugForm.orderQty2.value; 
	var absol_qty3 = drugForm.orderQty3.value; 
	var absol_qty4 = drugForm.orderQty4.value; 
	var absol_qty5 = drugForm.orderQty5.value; 
	var absol_qty6 = drugForm.orderQty6.value; 
	var absol_qty7 = drugForm.orderQty7.value; 
	var absol_qty8 = drugForm.orderQty8.value; 
	var absol_qty9 = drugForm.orderQty9.value; 
	var absol_qty10 = drugForm.orderQty10.value; 

	var noOfDrgus = 0;
	if(drug_code1!="") noOfDrgus+=1;
	if(drug_code2!="") noOfDrgus+=1;
	if(drug_code3!="") noOfDrgus+=1;
	if(drug_code4!="") noOfDrgus+=1;
	if(drug_code5!="") noOfDrgus+=1;
	if(drug_code6!="") noOfDrgus+=1;
	if(drug_code7!="") noOfDrgus+=1;
	if(drug_code8!="") noOfDrgus+=1;
	if(drug_code9!="") noOfDrgus+=1;
	if(drug_code10!="") noOfDrgus+=1;
	

	if(noOfDrgus < 2){
		alert(getMessage("PH_ATLEAST_TWO_DRUGS","PH"));
		return false;
	}
	else if( ((absol_qty1 =="" || absol_qty1=="0") && drug_code1!="") || ((absol_qty2=="" || absol_qty2=="0")&& drug_code2!="") || ((absol_qty3=="" || absol_qty3=="0")&& drug_code3!="") || ((absol_qty4=="" || absol_qty4=="0")&& drug_code4!="") || ((absol_qty5=="" || absol_qty5=="0")&& drug_code5!="") || ((absol_qty6=="" || absol_qty6=="0")&& drug_code6!="") || ((absol_qty7=="" || absol_qty7=="0")&& drug_code7!="") || ((absol_qty8=="" || absol_qty8=="0")&& drug_code8!="") || ((absol_qty9=="" || absol_qty9=="0")&& drug_code9!="") || ((absol_qty10=="" || absol_qty10=="0")&& drug_code10!="") ) {
		alert(getMessage("PH_ORDER_QTY_BLANK","PH"));
		return false;
	}

	var bean_id = drugForm.bean_id.value;
	var bean_name = drugForm.bean_name.value

	var patient_id = headerForm.patient_id.value
	var encounter_id = headerForm.encounter_id.value
	var actual_patient_class = headerForm.actual_patient_class.value;

	var xmlStr ="<root><SEARCH ";					
	xmlStr+= "drug_code1 =\"" + drug_code1+ "\" " ;
	xmlStr+= "drug_code2 =\"" + drug_code2+ "\" " ;
	xmlStr+= "drug_code3 =\"" + drug_code3+ "\" " ;
	xmlStr+= "drug_code4 =\"" + drug_code4+ "\" " ;
	xmlStr+= "drug_code5 =\"" + drug_code5+ "\" " ;
	xmlStr+= "drug_code6 =\"" + drug_code6+ "\" " ;
	xmlStr+= "drug_code7 =\"" + drug_code7+ "\" " ;
	xmlStr+= "drug_code8 =\"" + drug_code8+ "\" " ;
	xmlStr+= "drug_code9 =\"" + drug_code9+ "\" " ;
	xmlStr+= "drug_code10 =\"" + drug_code10+ "\" " ;
	xmlStr+= "absol_qty1 =\"" + absol_qty1+ "\" " ;
	xmlStr+= "absol_qty2 =\"" + absol_qty2+ "\" " ;
	xmlStr+= "absol_qty3 =\"" + absol_qty3+ "\" " ;
	xmlStr+= "absol_qty4 =\"" + absol_qty4+ "\" " ;
	xmlStr+= "absol_qty5 =\"" + absol_qty5+ "\" " ;
	xmlStr+= "absol_qty6 =\"" + absol_qty6+ "\" " ;
	xmlStr+= "absol_qty7 =\"" + absol_qty7+ "\" " ;
	xmlStr+= "absol_qty8 =\"" + absol_qty8+ "\" " ;
	xmlStr+= "absol_qty9 =\"" + absol_qty9+ "\" " ;
	xmlStr+= "absol_qty10 =\"" + absol_qty10+ "\" " ;
	xmlStr+= "iv_prep_yn =\"" + iv_prep_yn+ "\" " ;

	xmlStr +=" /></root>";
	var temp_jsp="PrescriptionCompValidate.jsp?validate=SAVE_QTYDETAILS"+"&bean_id="+bean_id+"&bean_name="+bean_name;
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest() ;
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST",temp_jsp,false);
	xmlHttp.send(xmlDoc);
	responseText=xmlHttp.responseText ;
	eval(responseText);
	//displayChargeDetailsPage(iv_prep_yn);
	
}

async function displayChargeDetailsPage(iv_prep_yn){

	var headerForm = parent.parent.f_header.document.prescription_header_form;
	var drugForm	= parent.f_compound_detail.document.prescription_compdetail_form;
	

	var bean_id = drugForm.bean_id.value;
	var bean_name = drugForm.bean_name.value
	var patient_id = headerForm.patient_id.value
	var take_home_medication = headerForm.take_home_medication.value
	var encounter_id = headerForm.encounter_id.value
	var actual_patient_class = headerForm.actual_patient_class.value;

	var dialogHeight= "45vh" ;
	var dialogWidth	= "65vw" ;
	var dialogTop	= "305" ;
	var dialogLeft	= "0" ;
	var center		= "1" ;
	var status		= "no";
	var scroll		= "yes";
	var features	= "dialogLeft:" + dialogLeft + ";dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; center: " + center + ";scroll "+scroll+"; status: " + status + "; dialogTop :" + dialogTop;
	var arguments	= "" ;
	//alert("bean_id="+bean_id+"&bean_name="+bean_name+"&patient_id="+patient_id+"&encounter_id="+encounter_id+"&actual_patient_class="+actual_patient_class+"&iv_prep_yn="+iv_prep_yn+"&fluid_code="+fluid_code+"&fluid_name="+fluid_name+"&infusion_over="+infusion_over+"&tot_inf_prd="+tot_inf_prd+"&durn_value="+durn_value);
	retVal = await window.showModalDialog("../../ePH/jsp/ChargeDetail.jsp?bean_id="+bean_id+"&bean_name="+bean_name+"&patient_id="+patient_id+"&encounter_id="+encounter_id+"&actual_patient_class="+actual_patient_class+"&iv_prep_yn="+iv_prep_yn+"&take_home_medication="+take_home_medication,arguments,features);

	if(retVal!= undefined && retVal!=null && retVal!="")
		alertBLErrorDrugs(retVal);
}

function getBLErrorDrugs(){

	var headerForm = parent.parent.f_header.document.prescription_header_form;
	var drugForm	= parent.f_compound_detail.document.prescription_compdetail_form;

	var bean_id = drugForm.bean_id.value;
	var bean_name = drugForm.bean_name.value
	var iv_prep_yn = document.forms[0].iv_prep_yn.value
	var patient_id = headerForm.patient_id.value
	var encounter_id = headerForm.encounter_id.value
	var actual_patient_class = headerForm.actual_patient_class.value;
	var take_home_medication				    = headerForm.take_home_medication.value;

	var xmlStr ="<root><SEARCH ";					
	xmlStr+= "patient_id =\"" + patient_id+ "\" " ;
	xmlStr+= "encounter_id =\"" + encounter_id+ "\" " ;
	xmlStr+= "drug_code1 =\"" + drugForm.drug_code1.value+ "\" " ;
	xmlStr+= "drug_code2 =\"" + drugForm.drug_code2.value+ "\" " ;
	xmlStr+= "drug_code3 =\"" + drugForm.drug_code3.value+ "\" " ;
	xmlStr+= "drug_code4 =\"" + drugForm.drug_code4.value+ "\" " ;
	xmlStr+= "drug_code5 =\"" + drugForm.drug_code5.value+ "\" " ;
	xmlStr+= "drug_code6 =\"" + drugForm.drug_code6.value+ "\" " ;
	xmlStr+= "drug_code7 =\"" + drugForm.drug_code7.value+ "\" " ;
	xmlStr+= "drug_code8 =\"" + drugForm.drug_code8.value+ "\" " ;
	xmlStr+= "drug_code9 =\"" + drugForm.drug_code9.value+ "\" " ;
	xmlStr+= "drug_code10 =\"" + drugForm.drug_code10.value+ "\" " ;
	xmlStr+= "absol_qty1 =\"" + drugForm.absol_qty1.value+ "\" " ;
	xmlStr+= "absol_qty2 =\"" + drugForm.absol_qty2.value+ "\" " ;
	xmlStr+= "absol_qty3 =\"" + drugForm.absol_qty3.value+ "\" " ;
	xmlStr+= "absol_qty4 =\"" + drugForm.absol_qty4.value+ "\" " ;
	xmlStr+= "absol_qty5 =\"" + drugForm.absol_qty5.value+ "\" " ;
	xmlStr+= "absol_qty6 =\"" + drugForm.absol_qty6.value+ "\" " ;
	xmlStr+= "absol_qty7 =\"" + drugForm.absol_qty7.value+ "\" " ;
	xmlStr+= "absol_qty8 =\"" + drugForm.absol_qty8.value+ "\" " ;
	xmlStr+= "absol_qty9 =\"" + drugForm.absol_qty9.value+ "\" " ;
	xmlStr+= "absol_qty10 =\"" + drugForm.absol_qty10.value+ "\" " ;
	xmlStr+= "actual_patient_class =\"" + actual_patient_class+ "\" " ;
	xmlStr+= "iv_prep_yn =\"" + iv_prep_yn+ "\" " ;
    xmlStr+= "take_home_medication =\"" + take_home_medication+ "\" " ;

	xmlStr +=" /></root>";

	var temp_jsp="PrescriptionCompValidate.jsp?validate=GET_BL_ERROR_DRUGS"+"&bean_id="+bean_id+"&bean_name="+bean_name;
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest() ;
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST",temp_jsp,false);
	xmlHttp.send(xmlDoc);
	responseText=xmlHttp.responseText ;
	eval(responseText);
}

function alertBLErrorDrugs(blErrorDrugs){

	blError = true;
	blErrorDrugs = blErrorDrugs.substring(1,blErrorDrugs.length-2);
	blErrorDrugs = blErrorDrugs.split(',');
	var bl_alert_msg=getMessage("ERROR_IN_BILLING",'PH')+"\n";
	var count=0;
	var drug_codes = new Array();

	for(var i=0; i<blErrorDrugs.length; i++){
		drug_codes[count++]	= trimString(blErrorDrugs[i++]);
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
	var drugForm	= parent.f_compound_detail.document.prescription_compdetail_form;
	for(count=0; count<drug_codes.length;count++){
		for(var i=1; i<=10; i++){
			if(eval("drugForm.drug_code"+i).value == drug_codes[count]){
				eval("drugForm.drug_name"+i).value="";
				deleteDrug(eval("drugForm.drug_name"+i),i,'BLERROR');
			}
		}
	}
}


async function openEDLDetails(DrugCode)
{
	//alert("DrugCode--->"+DrugCode)
  if(DrugCode!=''&&DrugCode!=null){
	var dialogHeight	= "40vh";
	var dialogWidth		= "55vw";
	var center			= "1";
	var status			= "no";
	var features		= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status;
	var arguments		= "";
	
	await window.showModalDialog("../jsp/EDLAssociateListViewFrames.jsp?DrugCode="+DrugCode, arguments, features);
	}
 
}//end function

function changePrescribingBy(obj)
{
	var objValue=obj.value;
	PrescribingBase=obj.value;
	var frmObj=parent.f_compound_detail.document.prescription_compdetail_form;
	if(objValue=='R')
	{
		frmObj.final_prod_qty.disabled=false;
		frmObj.final_prod_qty_uom.disabled=false;		
		frmObj.mandImage1.style.display="inline";	
		
		
		//frmObj.perc_rat_header.style.display="";
		frmObj.querySelector('#perc_rat_header').style.display="";
//		frmObj.getElementById('perc_rat_header').innerText="Ratio";
		frmObj.querySelector('#perc_rat_header').innerText = "Ratio";

		frmObj.querySelector('#ratiolabel').style.display="inline";
		frmObj.querySelector('#req_qty_header').style.display="";
		frmObj.querySelector('#absol_qty_header').innerText=getLabel("ePH.DerivedQty.label","PH");		
		for(i=1;i<=10;i++)
		{
			eval("frmObj.percent_ratio"+i).value="";
			eval("frmObj.percent_ratio"+i).disabled=false;
			frmObj.querySelector('#perc_rat_col'+i).style.display="";
			frmObj.querySelector('#perc'+i).style.display="none";
			frmObj.querySelector('#absol_qty'+i).disabled=true;
			frmObj.querySelector('#absol_qty'+i).value="";
			frmObj.querySelector('#lblBaseDrugId'+i).checked=false;
			frmObj.querySelector('#lblBaseDrugId'+i).style.display="none";
			frmObj.querySelector('#percent_ratio'+i).maxLength="2";
			frmObj.querySelector('#percent_ratio'+i).onBlur="percentageRatioValidation";

			frmObj.querySelector('#req_qty'+i).value="";
			frmObj.querySelector('#req_qty_col'+i).style.display="inline";
		}
		//frmObj.ratiofooter.width="28.5vw";
		document.getElementById("ratiofooter").style.height="2vw";
		frmObj.txt_total_quantity.value="";
		/*var len =frmObj.uom.options.length;
		for(var i=0;i<len;i++) 
		{
			frmObj.uom.remove("uom") ;
		}*/
	}
	else if(objValue=='P')
	{		
		frmObj.final_prod_qty.disabled=false;
		frmObj.final_prod_qty_uom.disabled=false;		
		frmObj.mandImage1.style.display="inline";		
		frmObj.querySelector('#perc_rat_header').style.display="";
		frmObj.querySelector('#perc_rat_header').innerText="   %  ";
		frmObj.querySelector('#ratiolabel').style.display="none";
		frmObj.querySelector('#req_qty_header').style.display="";
		frmObj.querySelector('#absol_qty_header').innerText=getLabel("ePH.DerivedQty.label","PH");
		for(i=1;i<=10;i++)
		{
			frmObj.querySelector('#percent_ratio'+i).value="";
			frmObj.querySelector('#perc_rat_col'+i).style.display="";			
			frmObj.querySelector('#perc'+i).style.display="inline";			
			frmObj.querySelector('#absol_qty'+i).disabled=true;	
			frmObj.querySelector('#absol_qty'+i).value="";	
			frmObj.querySelector('#lblBaseDrugId'+i).style.display="inline";	
			if(i==1)
			{
				frmObj.querySelector('#lblBaseDrugId'+i).style.visibility="hidden";	
			}
			frmObj.querySelector('#percent_ratio'+i).maxLength="5";
			frmObj.querySelector('#req_qty'+i).value="";
			frmObj.querySelector('#req_qty_col'+i).style.display="inline";
		}
		document.getElementById("ratiofooter").style.height="2vw";
		frmObj.txt_total_quantity.value="";
		/*var len =frmObj.uom.options.length;
		for(var i=0;i<len;i++) 
		{
			frmObj.uom.remove("uom") ;
		}*/
	}
	else
	{		
		var len =frmObj.uom.options.length;
		for(var i=0;i<len;i++) 
		{
			frmObj.uom.remove("uom") ;
		}
		element = document.createElement('OPTION') ;
		element.value		=  "";
		element.text		=  "  --- "+getLabel("ePH.Select.label","PH")+" ---  ";		
		frmObj.uom.add(element);
		frmObj.uom.selectedIndex=0;	
		frmObj.uom.disabled=false;

		frmObj.final_prod_qty.disabled=true;
		frmObj.final_prod_qty.value="";
		frmObj.final_prod_qty_uom.disabled=true;		
		frmObj.final_prod_qty_uom.selectedIndex=0;
			
		frmObj.mandImage1.style.display="none";		
		frmObj.querySelector('#perc_rat_header').style.display="none";
		frmObj.querySelector('#req_qty_header').style.display="none";	
		frmObj.querySelector('#absol_qty_header').innerText=getLabel("Common.Quantity.label","Common");
		for(i=1;i<=10;i++)
		{
			frmObj.querySelector('#percent_ratio'+i).value="";
			frmObj.querySelector('#percent_ratio'+i).disabled=false;
			frmObj.querySelector('#perc_rat_col'+i).style.display="none";
			frmObj.querySelector('#absol_qty'+i).disabled=false;
			frmObj.querySelector('#absol_qty'+i).value="";
			frmObj.querySelector('#lblBaseDrugId'+i).checked=false;
			frmObj.querySelector('#lblBaseDrugId'+i).style.display="none";
			frmObj.querySelector('#req_qty'+i).value="";
			frmObj.querySelector('#req_qty_col'+i).style.display="none";
			frmObj.querySelector('#req_qty_uom'+i).innerText="";
		}
		//frmObj.ratiofooter.width="30%";
		document.getElementById("ratiofooter").style.height="2vw";
		frmObj.querySelector('#txt_total_quantity_uom').innerText="";
		frmObj.querySelector('#txt_total_quantity_uom').style.display="none";
		frmObj.querySelector('#ratiolabel').style.display="none";
		frmObj.querySelector('#txt_total_quantity').value="";
		assignPresBaseUOM();
	}
}

function changeFinalProductQtyUOM(obj)
{	
	var frmObj=parent.f_compound_detail.document.prescription_compdetail_form;
	var len =frmObj.uom.options.length;
		for(var i=0;i<len;i++) {
			frmObj.uom.remove("uom") ;
	}
	var pos = obj.selectedIndex;
	var optText = obj.options[pos].text;
	element = document.createElement('OPTION') ;
	element.value		=  obj.value ;
	element.text		=  optText;
	frmObj.uom.add(element);
	frmObj.uom.disabled=true;
	if(pos!=0)
	{
		frmObj.querySelector('#txt_total_quantity_uom').innerText=optText;
		frmObj.querySelector('#txt_total_quantity_uom').style.display="inline";
		var index=0;
		for(intexnumber=1;intexnumber<=10;intexnumber++)
		{
			frmObj.querySelector('#req_qty_uom'+intexnumber).innerText=optText
			frmObj.querySelector('#req_qty_uom'+intexnumber).style.display="inline";
			frmObj.querySelector('#equvalentUOM_conversion_value'+intexnumber).value="";
			frmObj.querySelector('#equvalentUOM_conversion_factor'+intexnumber).value="";
			if(frmObj.querySelector('#drug_name'+intexnumber).value!="") index++;
		}
		if(index>0)
			percentageRatioCalculation("N");
	}
	else
	{
		frmObj.querySelector('#txt_total_quantity_uom').innerText="";
		frmObj.querySelector('#txt_total_quantity_uom').style.display="inline";
		for(intexnumber=1;intexnumber<=10;intexnumber++)
		{
			frmObj.querySelector('#req_qty_uom'+intexnumber).innerText="";
			frmObj.querySelector('#req_qty_uom'+intexnumber).style.display="inline";
			frmObj.querySelector('#equvalentUOM_conversion_value'+intexnumber).value="";
			frmObj.querySelector('#equvalentUOM_conversion_factor'+intexnumber).value="";
		}
	}

	
}
function percentageRatioValidation(obj)
{	
	if(PrescribingBase=='R')
	{
		return allowValidNumber(obj,event,2,0);
	}
	else if(PrescribingBase=='P')
	{
		return allowValidNumber(obj,event,2,2);
	}
	else
	{
		return false;
	}
	 
}
function percentageRatioCalculation(rownum,fromwhere)
{

	
	
	var frmObj=parent.f_compound_detail.document.prescription_compdetail_form;
	var finalProdQtyObj=frmObj.final_prod_qty;
	var finalProdQtyUOMObj=frmObj.final_prod_qty_uom;
	var percent_ratio="";
	var drugObj="";
	if(fromwhere!=undefined)
	{
		if(fromwhere=="PR");
		{
			var percent_ratio1=eval("frmObj.percent_ratio"+rownum);
			var req_qty1=eval("frmObj.req_qty"+rownum);
			if(percent_ratio1.value=="" && req_qty1.value=="")
			{
				return false;
			}
		}
	}
	if(rownum =="NX")
	{
		if(finalProdQtyObj.value=="")
		{
				alert(getMessage("ENTER_FINAL_PRODUCT_QTY","PH"));
				percent_ratio.value="";
				finalProdQtyObj.focus();
				return false;
		}
	}
	if(rownum!="N" && rownum!="NX")
	{
		percent_ratio=eval("frmObj.percent_ratio"+rownum);
		drugObj=eval("frmObj.drug_name"+rownum);
		//if(percent_ratio.value!="")
		//{
			if(finalProdQtyObj.value=="")
			{
				alert(getMessage("ENTER_FINAL_PRODUCT_QTY","PH"));
				percent_ratio.value="";
				finalProdQtyObj.focus();
				return false;
			}
			if(finalProdQtyUOMObj.value=="")
			{
				alert(getMessage("SELECT_FINAL_PRODUCT_QTY_UOM","PH"));
				percent_ratio.value="";
				finalProdQtyUOMObj.focus();
				return false;
			}
			if(drugObj.value=="")
			{
				alert(getMessage("PH_SELECT_DRUG",'PH')); //if drug not selected
				percent_ratio.value="";
				drugObj.focus();
				return false;
			}
		//}
	}
	else
	{
		rownum=1;
		percent_ratio=eval("frmObj.percent_ratio"+rownum);
		drugObj=eval("frmObj.drug_name"+rownum);
	}	
	if(PrescribingBase=='R')
	{
		var sumOfRatio=0;
		for (i=1; i<=10;i++)
		{
			if(eval("frmObj.percent_ratio"+i).value!="")
				sumOfRatio=sumOfRatio+parseInt(eval("frmObj.percent_ratio"+i).value);
		}
		perRatio=parseInt(finalProdQtyObj.value)/sumOfRatio;
		for (i=1; i<=10;i++)
		{
			if(eval("frmObj.percent_ratio"+i).value!="")
			{
				eval("frmObj.req_qty"+i).value=(perRatio*parseInt(eval("frmObj.percent_ratio"+i).value)).toFixed(2);	
				calculateDerivedQuantity(i);
			}
			else
			{
				eval("frmObj.req_qty"+i).value="";
				eval("frmObj.absol_qty"+i).value="";
				eval("frmObj.orderQty"+i).value="";
				eval("frmObj.orderQtyUOM"+i).value="";
			}
		}	
		var showLabel="Ratio: ";
		var next=0;
		for(i=1;i<=10;i++)
		{
			if(eval("frmObj.percent_ratio"+i).value!="")
			{
				if(next==1)
				{
					showLabel=showLabel+":"+eval("frmObj.percent_ratio"+i).value;					
				}
				else
				{
					showLabel=showLabel+eval("frmObj.percent_ratio"+i).value;
					next=1;	
				}
			}
		}
		frmObj.querySelectorAll('#ratiolabel').innerText=showLabel;
		var sumOfQty=0;
		for(i=1;i<=10;i++)
		{
			if(eval("frmObj.req_qty"+i).value!="")
			{
				sumOfQty=sumOfQty+parseFloat(eval("frmObj.req_qty"+i).value);
			}
		}
		frmObj.txt_total_quantity.value=sumOfQty.toFixed(2);
		return true;
	}
	else if(PrescribingBase=='P')
	{   					
		for (i=1; i<=10;i++)
		{
			if(eval("frmObj.percent_ratio"+i).value!="")
			{
				eval("frmObj.req_qty"+i).value=(parseInt(finalProdQtyObj.value)* parseFloat(eval("frmObj.percent_ratio"+i).value)/100).toFixed(2);
				calculateDerivedQuantity(i);
			}
			else
			{
				eval("frmObj.req_qty"+i).value="";
				eval("frmObj.absol_qty"+i).value="";
				eval("frmObj.orderQty"+i).value="";
				eval("frmObj.orderQtyUOM"+i).value="";

			}
		}
		var sumOfQty=0;	
		var baseDrugValue=0;
		for(i=1;i<=10;i++)
		{
			if(eval("frmObj.req_qty"+i).value!="")
			{
				sumOfQty=sumOfQty+parseFloat(eval("frmObj.req_qty"+i).value);				
			}
			if(i==10) continue;
			if(frmObj.baseDrug[i].checked)
					baseDrugValue=frmObj.baseDrug[i].value;
		}		
		if(baseDrugValue==0) //base not selected yet
		{
			if(sumOfQty>parseInt(finalProdQtyObj.value))
			{
				alert(getMessage("TOT_QTY_EXCEEDS_FINAL_PRODUCT_QTY","PH"));
				percent_ratio.value="";
				eval("frmObj.req_qty"+rownum).value="";
				eval("frmObj.absol_qty"+rownum).value="";
				eval("frmObj.orderQty"+rownum).value="";
				eval("frmObj.orderQtyUOM"+rownum).value="";
				return false;
			}			
		}
		else //base selected
		{
			var tempSumOfQty=0;
			for(i=1;i<=10;i++)
			{
				if(i==baseDrugValue)
					continue;
				if(eval("frmObj.req_qty"+i).value!="")
					tempSumOfQty=tempSumOfQty + parseFloat(eval("frmObj.req_qty"+i).value);				
			}						
			var baseQty=parseInt(finalProdQtyObj.value)-tempSumOfQty;
			//alert("baseQty=="+baseQty);
			if(baseQty>0)
			{
				eval("frmObj.req_qty"+baseDrugValue).value=baseQty.toFixed(2);
				calculateDerivedQuantity(baseDrugValue);
				sumOfQty=baseQty+tempSumOfQty;				
			}
			else
			{
				if(!isNaN(baseQty))
				{
					alert(getMessage("TOT_QTY_EXCEEDS_FINAL_PRODUCT_QTY","PH"));
					percent_ratio.value="";
					eval("frmObj.req_qty"+rownum).value="";
					eval("frmObj.absol_qty"+rownum).value="";
					eval("frmObj.orderQty"+rownum).value="";
					eval("frmObj.orderQtyUOM"+rownum).value="";
				}
				return false;
			}
		}
		frmObj.txt_total_quantity.value=sumOfQty.toFixed(2);
		return true;
	}
	else
	{
		return false;		
	}
}
previouslySelected="";
function selectBaseDrug(selectedObj)
{
	
	var frmObj=parent.f_compound_detail.document.prescription_compdetail_form;
	var rownum=selectedObj.value;
	var perc_ratio;	
	for(ino=1;ino<=10;ino++)
	{
		perc_ratio=eval("frmObj.percent_ratio"+ino);
		perc_ratio.disabled=false;		
		if(ino==parseInt(rownum))
		{
			if(percentageRatioCalculation(rownum))
			{				
				perc_ratio.value="";
				perc_ratio.disabled=true;
				previouslySelected=ino;
				//alert("ino--->"+ino);
			}
			else
			{
				selectedObj.checked=false;
				if(previouslySelected!="")
				{	
					eval("frmObj.baseDrugId"+previouslySelected).checked=true;						
				}
			}
		}		
	}
	
}
function assignPresBaseUOM()
{ 
	var drug_count =0;
	var str_count = 0;
	var frmObj=parent.f_compound_detail.document.prescription_compdetail_form;	
	for(dcno=1;dcno<=10;dcno++)
	{
		if(eval("frmObj.drug_code"+dcno).value !="") drug_count+=1;
	}
	for(dcno=1;dcno<=10;dcno++)
	{
		if(eval("frmObj.strength_uom"+dcno).value !="") str_count+=1;
	}

	if(drug_count>1 && str_count ==0 ){
		var len =document.prescription_compdetail_form.uom.options.length;
		for(var i=0;i<len;i++) {
			document.prescription_compdetail_form.uom.remove("uom") ;
		}
		for(var i =1;i<=10 ;i++){
			if(	eval("document.prescription_compdetail_form.pres_base_uom"+i).value !=""){
				var len1 =document.prescription_compdetail_form.uom.options.length;
				foundflag=false;
				for(var k=0;k<len1;k++) {
					var tempUOMVal=document.prescription_compdetail_form.uom.options[k].value ;							
					if(tempUOMVal==(eval("document.prescription_compdetail_form.pres_base_uom"+i).value))
					{
						foundflag=true;
						break;
					}
				}
				if(!foundflag)
				{
					var element = document.createElement('OPTION') ;
					//element.value		=  i ; Modified for CRF-0749;
							element.value		=(eval("document.prescription_compdetail_form.pres_base_uom"+i).value);
					element.text		=  (eval("document.prescription_compdetail_form.pres_base_uom_need"+i).value)+"            ";
					frmObj.uom.add(element);
					frmObj.uom.selectedIndex= 0 ;
				}
			}
		}
	 }
	 else
	{
		if(drug_count>1)
		{
			var len =document.prescription_compdetail_form.uom.options.length;
			for(var i=0;i<len;i++) {
				document.prescription_compdetail_form.uom.remove("uom") ;
			}
		}
		 for(var j=1;j<=10;j++) {
			if(	eval("document.prescription_compdetail_form.strength_uom"+j).value !=""){
				var len1 =document.prescription_compdetail_form.uom.options.length;
				foundflag=false;
				for(var k=0;k<len1;k++) {
					var tempUOMVal=document.prescription_compdetail_form.uom.options[k].value ;							
					if(tempUOMVal==(eval("document.prescription_compdetail_form.strength_uom"+j).value))
					{
						foundflag=true;
						break;
					}
				}
				if(!foundflag)
				{
					var element = document.createElement('OPTION') ;
					//element.value		=  i;  Modified for CRF-0749;
					element.value		=  (eval("document.prescription_compdetail_form.strength_uom"+j).value)
					element.text		=  (eval("document.prescription_compdetail_form.strength_uom_need"+j).value)+"            ";
					frmObj.uom.add(element);
					frmObj.uom.selectedIndex= 0 ;
				}
			}
		}
	}
}
function setDerivedQuantity(equVal,factor,rowvalue,contentInPresBaseUOM,orderQtyUOM)
{
	var frmObj=parent.f_compound_detail.document.prescription_compdetail_form;
	var drugobj=eval("frmObj.drug_name"+rowvalue);	
	if(factor=="N")
	{
		alert(getMessage("PH_EQU_UOM_NOT_DEFINED","PH"));		
		drugobj.value="";
		deleteDrug(drugobj,rowvalue,'');		
		return false;
	}
	
	var reqQtyValue=eval("frmObj.req_qty"+rowvalue).value;	
	var derqtyObj=eval("frmObj.absol_qty"+rowvalue);
	var result="";
	if(factor=="M")
	{
		result=(parseFloat(reqQtyValue)*parseFloat(equVal)).toFixed(2);
	}
	if(factor=="D")
	{
		result=(parseFloat(reqQtyValue)/parseFloat(equVal)).toFixed(2);
	}
	derqtyObj.value=result;
	var ord_qty=Math.ceil(result/parseFloat(contentInPresBaseUOM));
	eval("frmObj.equvalentUOM_conversion_value"+rowvalue).value=equVal;
	eval("frmObj.equvalentUOM_conversion_factor"+rowvalue).value=factor;
	eval("frmObj.contentInPresBaseUOM"+rowvalue).value=contentInPresBaseUOM;
	eval("frmObj.orderQty"+rowvalue).value=ord_qty;
	eval("frmObj.orderQtyUOM"+rowvalue).value=orderQtyUOM;
	//alert("ord_qty="+ord_qty+"-"+orderQtyUOM);
}
function calculateDerivedQuantity(rowvalue)
{	
	
	var frmObj=parent.f_compound_detail.document.prescription_compdetail_form;
	var prevEquValue=eval("frmObj.equvalentUOM_conversion_value"+rowvalue).value;
	var prevEquFactor=eval("frmObj.equvalentUOM_conversion_factor"+rowvalue).value;
	var contentInPresBaseUOM=eval("frmObj.contentInPresBaseUOM"+rowvalue).value;
	var orderQty=eval("frmObj.orderQty"+rowvalue).value;
	var orderQtyUOM=eval("frmObj.orderQtyUOM"+rowvalue).value;
	if(prevEquValue==""||orderQty=="")
	{
		var bean_id = frmObj.bean_id.value;
		var bean_name = frmObj.bean_name.value
		var finalUOM = frmObj.final_prod_qty_uom.value
		//var drugUom=eval("frmObj.qty"+rowvalue).innerText;	
		var drugUom=eval("frmObj.pres_base_uom"+rowvalue).value;	
		var drugCode=eval("frmObj.drug_code"+rowvalue).value;		
		var qryString = bean_id+"&bean_name="+bean_name+"&validate=EQUIVALENT_UOM&finalUOM="+finalUOM+"&drugUOM="+drugUom+"&rownumber="+rowvalue+"&drugCode="+drugCode;
		submitXML(qryString,"");	
	}
	else
	{
		setDerivedQuantity(prevEquValue,prevEquFactor,rowvalue,contentInPresBaseUOM,orderQtyUOM);
	}
}
function updateOrderQuantiyInStrengthMode(content,orderQtyUOM,rowValue)
{
	var frmObj=parent.f_compound_detail.document.prescription_compdetail_form;
	var enteredValue=eval("frmObj.absol_qty"+rowValue).value;
	var orderQty=Math.ceil(parseFloat(enteredValue)/parseFloat(content));
	eval("frmObj.orderQty"+rowValue).value=orderQty;
	eval("frmObj.orderQtyUOM"+rowValue).value=orderQtyUOM;
}
function calculateOrderQuantiyInStrengthMode(rowValue)
{
	var frmObj=parent.f_compound_detail.document.prescription_compdetail_form;
	var bean_id = frmObj.bean_id.value;
	var bean_name = frmObj.bean_name.value
	var drugCode=eval("frmObj.drug_code"+rowValue).value;	
	var qryString =bean_id+"&bean_name="+bean_name+"&validate=CALC_ORDER_QTY&rownumber="+rowValue+"&drugCode="+drugCode;
	submitXML(qryString,"");	
}

async function previewCompRX()
{
	var headerForm	      = parent.parent.f_header.prescription_header_form;
	var frmObj			  = parent.f_compound_detail.document.prescription_compdetail_form;
	//alert(frmObj.name);
	var patient_id		  = headerForm.patient_id.value;
	var encounter_id	  = headerForm.encounter_id.value;
	var ord_date		  = headerForm.sys_date.value;
	var locn_code		  = headerForm.location_code.value;
	var pract_name		  = headerForm.pract_name.value;
	if(pract_name!=null && pract_name!="")
			pract_name = encodeURIComponent(pract_name);
	var patient_class	  = headerForm.actual_patient_class.value;
	var drug_codes		  =	"";	
	var absol_qtys		  =	"";
	var percent_ratio	  =	"";
	var pres_by			= "";
	var DrugIndicationRemarks="";//DrugIndicationRemarks added for MMS Adhoc Testing
	var freq_code		= frmObj.frequency.value;
	var dosage			= frmObj.dosage.value;
	var duration		= frmObj.durn_value.value;
	var start_date		= frmObj.start_date.value;
	var end_date		= frmObj.end_date.value;
	var freq_desc		= frmObj.frequency.options[frmObj.frequency.selectedIndex].text;
	var dosage_unit		= frmObj.uom.options[frmObj.uom.selectedIndex].text;
	var durn_unit		= frmObj.durn_type_desc.options[frmObj.durn_type_desc.selectedIndex].text;
	var titletext		= "View Orders";
	if(frmObj.pres_by[0].checked)
		pres_by=frmObj.pres_by[0].value;
	else if(frmObj.pres_by[1].checked)
		pres_by=frmObj.pres_by[1].value;
	else if(frmObj.pres_by[2].checked)
		pres_by=frmObj.pres_by[2].value;
	//alert("&pres_by="+pres_by+"&freq_code="+freq_code+"&dosage="+dosage+"&duration="+duration+"&start_date="+start_date+"&end_date="+end_date+"&freq_desc="+freq_desc+"&dosage_unit="+dosage_unit+"&durn_unit="+durn_unit);
	for(drno=1;drno<=10;drno++)
	{
		if(eval("frmObj.drug_code"+drno).value!="") 
		{			
			absol_qtys	+="&absol_qty"+drno+"="+eval("frmObj.absol_qty"+drno).value;
			DrugIndicationRemarks +="&DrugIndicationRemarks"+drno+"="+eval("frmObj.DrugIndicationRemarks_"+drno).value;//DrugIndicationRemarks added for MMS Adhoc Testing
			drug_codes	+="&drug_code"+drno+"="+eval("frmObj.drug_code"+drno).value;
			if(pres_by!="S")
			percent_ratio	+="&percent_ratio"+drno+"="+eval("frmObj.percent_ratio"+drno).value;
		}
	}
	//alert(absol_qtys);
	var dialogHeight	= "64vh";
	var dialogHeight	= "33vw";
	var dialogWidth		= "58vw";
	var dialogTop		= "169";
	//var dialogLeft		= "40";
	var center			= "1";
	var status			= "no";
	var features		= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop;
	var arguments		= "";
	
	retVal 				= await top.window.showModalDialog("../../ePH/jsp/PrescriptionCmpPrevOrderDetails.jsp?titletext="+titletext+"&patient_id="+patient_id+"&encounter_id="+encounter_id+"&locn_code="+locn_code+"&pract_name="+encodeURIComponent(pract_name,"UTF-8")+"&patient_class="+patient_class+"&ord_date="+ord_date+"&pres_by="+pres_by+"&freq_code="+freq_code+"&dosage="+dosage+"&duration="+duration+"&start_date="+start_date+"&end_date="+end_date+"&freq_desc="+encodeURIComponent(freq_desc,"UTF-8")+"&dosage_unit="+encodeURIComponent(dosage_unit,"UTF-8")+"&durn_unit="+durn_unit+drug_codes+absol_qtys+percent_ratio+DrugIndicationRemarks,arguments,features);//DrugIndicationRemarks added for MMS Adhoc Testing
	if(retVal!= undefined && retVal == 'R')//added for ML-MMOH-CRF-0341 [IN:057179]
		parent.f_compound_button.formIVPrescriptionButtons.RELEASE.click();
}
// RUT-CRF-0062 [IN029600] Added to set Build MAR Rule -- begin
function setBuildMAR(buildMARDefaulting){
	var buildMAR_checked=buildMARDefaulting.substring(0,1);
	var buildMAR_enabled=buildMARDefaulting.substring(1,2);
	var formobj		=	document.prescription_compdetail_form;;
	
	var expDisp=""; //Added for nmc-jd-crf-0046
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
             // End of NMC-JD-CRF-0046
	
	
}
// RUT-CRF-0062 [IN029600] Added to set Build MAR Rule -- end
//Added for  ML-BRU-CRF-072[Inc:29938] start
async function drugindication_remarks(index){
	var formobj		=	document.prescription_compdetail_form;
	var DrugIndicationRemarks	=	eval("formobj.DrugIndicationRemarks_"+index).value;
	var mode=formobj.mode.value;
	var dialogHeight= "35vh" ;
	var dialogWidth	= "50vw" ;
	var dialogTop = "" ;
	var dialogLeft ="";
	var center = "0" ;
	var status="no";
	var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" +dialogTop+"; dialogLeft :"+dialogLeft;
	var arguments	= "" ;
	retVal = await top.window.showModalDialog("../../ePH/jsp/DrugIndicationRemarks.jsp?&DrugIndicationRemarks="+encodeURIComponent(DrugIndicationRemarks)+"&iv_prep_yn=6",arguments,features);//remove escape and add encodeURIComponent for MMS Adhoc Testing
	if(retVal!= undefined && retVal!=null)
		eval("formobj.DrugIndicationRemarks_"+index).value=retVal;		
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
		var xmlDoc = ""; 
	var xmlHttp = new XMLHttpRequest();
		var xmlStr ="<root><SEARCH ";
		xmlStr+= "reason_code  =\"" + reason_code + "\" " ;
		xmlStr+= "trn_type =\"" + trn_type + "\" " ;
		xmlStr+= "field =\"" + field + "\" " ;
		xmlStr+= "patient_id =\"" + patient_id + "\" " ;
		xmlStr+= "encounter_id =\"" + encounter_id + "\" " ;
		xmlStr +=" /></root>";
		var temp_jsp="PrescriptionCompValidate.jsp?bean_id="+bean_id+"&bean_name="+bean_name+"&validate=override_remarks";
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
//Added for IN:069887  start
function showOverideMandAlert(allergy_remarks_yn, dup_remarks_yn, dose_remarks_yn){
	
	
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
//Added for IN:069887 end
