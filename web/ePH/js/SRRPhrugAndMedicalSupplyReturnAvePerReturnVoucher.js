
function run() {

	
	//Run for the function  Drug and Medical supplyAvg per Return VoucherReport
	if(f_query_add_mod.document.formPhDrugandMedicalsupplyAvePerReturnVoucherCriteriafrm) {
		
		var frmObject = f_query_add_mod.document.formPhDrugandMedicalsupplyAvePerReturnVoucherCriteriafrm;
		
				frmObject.p_disp_date_from.value = convertDate(frmObject.dt_from.value,'DMY',frmObject.p_language_id.value,"en");
				frmObject.p_disp_date_to.value = convertDate(frmObject.dt_to.value,'DMY',frmObject.p_language_id.value,"en");	
				frmObject.p_disp_type.value = frmObject.p_disp_locn_type.value;	
				frmObject.p_disp_loc_code.value = frmObject.p_disp_locn.value;
				frmObject.p_disp_time_from.value = frmObject.p_time_from.value;
				frmObject.p_disp_time_to.value = frmObject.p_time_to.value;
				if (frmObject.p_rep_type.value != 'D' )
					{
						
						frmObject.p_report_id.value = 'PHREDMAPL';
						//frmObject.p_report_id.value = 'PHREDMAP';
					}
				else{
						
						frmObject.p_report_id.value = 'PHREDMAP';
						
					}

						var fields= new Array (frmObject.dt_from,frmObject.dt_to,frmObject.p_time_from,frmObject.p_time_to);
						var names= new Array (getLabel("Common.date.label","Common"),getLabel("Common.todate.label","Common"),getLabel("Common.from.label","Common")+" "+getLabel("ePH.TimeHH:MM.label","PH"),getLabel("Common.to.label","Common")+" "+getLabel("ePH.TimeHH:MM.label","PH"));
						if(checkFields(fields,names,messageFrame)){			
						if( f_query_add_mod.doDateCheck( f_query_add_mod.document.formPhDrugandMedicalsupplyAvePerReturnVoucherCriteriafrm.dt_from, f_query_add_mod.document.formPhDrugandMedicalsupplyAvePerReturnVoucherCriteriafrm.dt_to, messageFrame ) ) {
								f_query_add_mod.document.formPhDrugandMedicalsupplyAvePerReturnVoucherCriteriafrm.submit();
							}
						}	
					
				
			
	}  //end
						//
					//
	//Run for the function  Drug and Medical supply dispensing statstic Report
	if(f_query_add_mod.document.formDrugandMedicalsupplyDispensingStasticreportCriteria)
	{
		var frmObject = f_query_add_mod.document.formDrugandMedicalsupplyDispensingStasticreportCriteria;
		//assiging values to the hidden values of report parameters
		 frmObject.p_month_from.value		=	frmObject.p_month_frm.value;
		// frmObject.p_month_to.value		=	frmObject.p_month_to.value;
		 frmObject.p_year_from.value		=	frmObject.p_year_frm.value;
		 frmObject.p_disp_time_from.value		=	frmObject.p_time_from.value;
		 frmObject.p_disp_time_to.value		=	frmObject.p_time_to.value;
		 frmObject.P_disp_type.value		=	frmObject.p_disp_locn_type.value;
		 frmObject.p_disp_loc_from.value		=	frmObject.p_disp_locn.value;
		 frmObject.p_disp_loc_to.value		=	frmObject.p_disp_locn_to.value;
		 frmObject.p_privilege_fm.value		=	frmObject.p_fr_privilegde.value;
		 frmObject.p_privilege_to.value		=	frmObject.p_to_privilegde.value;
		var fields= new Array (frmObject.p_month_frm,frmObject.p_month_to,frmObject.p_year_frm,frmObject.p_year_to,frmObject.p_time_from,frmObject.p_time_to);
		var names= new Array (getLabel("Common.MonthFrom.label","Common"),getLabel("Common.MonthTo.label","Common"),getLabel("Common.year.label","Common"),getLabel("Common.to.label","Common"),getLabel("Common.from.label","Common")+" "+getLabel("ePH.TimeHH:MM.label","PH"),getLabel("Common.to.label","Common")+" "+getLabel("ePH.TimeHH:MM.label","PH"));
		
		if(checkFields(fields,names,messageFrame)){			
		//if( f_query_add_mod.doDateCheck( f_query_add_mod.document.formDrugandMedicalsupplyDispensingStasticreportCriteria.dt_from, f_query_add_mod.document.formDrugandMedicalsupplyDispensingStasticreportCriteria.dt_to, messageFrame ) ) {
				f_query_add_mod.document.formDrugandMedicalsupplyDispensingStasticreportCriteria.submit();
			//}
		}		
	} //ends

	//Run for the function  Compounding drug dispensing Stastic report
	if(f_query_add_mod.document.FormCompoundingDrugDispensingStaticReportCriteria) {
		
		var frmObject = f_query_add_mod.document.FormCompoundingDrugDispensingStaticReportCriteria;
		
		 //assiging values to the hidden values of report parameters
		 frmObject.p_frm_date.value		=	convertDate(frmObject.dt_from.value,'DMY',frmObject.p_language_id.value,"en");
		 frmObject.p_to_date.value		=	convertDate(frmObject.dt_to.value,'DMY',frmObject.p_language_id.value,"en");
		 frmObject.p_frm_time.value		=	frmObject.p_time_from.value;
		 frmObject.p_to_time.value		=	frmObject.p_time_to.value;
		 frmObject.p_disp_locn_code.value		=	frmObject.p_disp_locn.value;
		 var fields= new Array (frmObject.dt_from,frmObject.dt_to,frmObject.p_time_from,frmObject.p_time_to);
		
		var names= new Array (getLabel("Common.date.label","Common"),getLabel("Common.todate.label","Common"),getLabel("Common.from.label","Common")+" "+getLabel("ePH.TimeHH:MM.label","PH"),getLabel("Common.to.label","Common")+" "+getLabel("ePH.TimeHH:MM.label","PH"));
		if(checkFields(fields,names,messageFrame)){			
		if( f_query_add_mod.doDateCheck( f_query_add_mod.document.FormCompoundingDrugDispensingStaticReportCriteria.dt_from, f_query_add_mod.document.FormCompoundingDrugDispensingStaticReportCriteria.dt_to, messageFrame ) ) {
			
				f_query_add_mod.document.FormCompoundingDrugDispensingStaticReportCriteria.submit();
			}
		}		
	} //ends



	//Run for the function  Clinical Alert Report
	if(f_query_add_mod.document.FormClinicalalertReportCriteria) {
		
		var frmObject = f_query_add_mod.document.FormClinicalalertReportCriteria
		 //assiging values to the hidden values of report parameters
		frmObject.p_frm_order_date.value		=	convertDate(frmObject.dt_from1.value,'DMY',frmObject.p_language_id.value,"en");
		frmObject.p_to_order_date.value		=	convertDate(frmObject.dt_to1.value,'DMY',frmObject.p_language_id.value,"en");
		frmObject.P_facility_id.value		=	frmObject.p_facility_code.value;
		frmObject.p_patient_id.value		=	frmObject.P_PAT_ID1.value;
		frmObject.p_locn_type.value		=	frmObject.Location_Type.value;
		frmObject.p_frm_locn_code.value		=	frmObject.loc_id.value;
		frmObject.p_to_locn_code.value		=	frmObject.tloc_id.value;
		frmObject.p_frm_spec_code.value		=	frmObject.p_specialty_id.value;
		frmObject.p_to_spec_code.value		=	frmObject.tp_specialty_id.value;
		frmObject.p_frm_pract_code.value		=	frmObject.pract_id.value;
		frmObject.p_to_pract_code.value		=	frmObject.tpract_id.value;
		var fields= new Array (frmObject.dt_from1,frmObject.dt_to1,frmObject.p_group_by);
		var names= new Array (getLabel("Common.date.label","Common"),getLabel("Common.todate.label","Common"),getLabel("Common.groupby.label","Common"));
		if(checkFields(fields,names,messageFrame)){			
		if( f_query_add_mod.doDateCheck( f_query_add_mod.document.FormClinicalalertReportCriteria.dt_from1, f_query_add_mod.document.FormClinicalalertReportCriteria.dt_to1, messageFrame ) ) {
				//alert("frmObject.p_report_type.value=======110===>" +frmObject.p_report_type.value);
			if (frmObject.p_report_type.value == 'S' && frmObject.p_group_by.value!='')
			{
				
				if(frmObject.p_clinical_Alert_Type.value == 'DA' && (frmObject.p_group_by.value == 'P' || frmObject.p_group_by.value == 'S' ||frmObject.p_group_by.value == 'L'))
				{
				//alert("frmObject.p_report_id.value====102===>" +frmObject.p_report_id.value);
				frmObject.p_report_id.value = 'PHCLIALTSUMM';
			
				
				}
				//Added Else If conditions for DI,DDUP,DDOS,DD=====For the report SRR20056-RPT-0043: By sandhya
				else if(frmObject.p_clinical_Alert_Type.value == 'DI' && (frmObject.p_group_by.value == 'P' || frmObject.p_group_by.value == 'S' ||frmObject.p_group_by.value == 'L')){
					
					
				frmObject.p_report_id.value = 'PHCLIALTSUMM';
				
				}
				else if(frmObject.p_clinical_Alert_Type.value == 'DDUP' && (frmObject.p_group_by.value == 'P' || frmObject.p_group_by.value == 'S' ||frmObject.p_group_by.value == 'L')){
					
					
				frmObject.p_report_id.value = 'PHCLIALTSUMM';
				
				}
				else if(frmObject.p_clinical_Alert_Type.value == 'DDOS' && (frmObject.p_group_by.value == 'P' || frmObject.p_group_by.value == 'S' ||frmObject.p_group_by.value == 'L')){
					
					
				frmObject.p_report_id.value = 'PHCLIALTSUMM';
				
				}
				else if(frmObject.p_clinical_Alert_Type.value == 'DD' && (frmObject.p_group_by.value == 'P' || frmObject.p_group_by.value == 'S' ||frmObject.p_group_by.value == 'L')){
					
					//alert("frmObject.p_report_id.value====141===>" +frmObject.p_report_id.value);
				frmObject.p_report_id.value = 'PHCLIALTSUMM';
				
				}
				
			
			}
			else if(frmObject.p_report_type.value == 'D' && frmObject.p_group_by.value!='')
			{		//alert("D");
				if(frmObject.p_clinical_Alert_Type.value == 'DA' && (frmObject.p_group_by.value == 'P' || frmObject.p_group_by.value == 'S' ||frmObject.p_group_by.value == 'L'))
				{
					frmObject.p_report_id.value = 'PHCLIALTDTL';				
				}
				//Added Else If conditions for DI,DDUP,DDOS,DD=====For the report SRR20056-RPT-0043: By sandhya
				else if(frmObject.p_clinical_Alert_Type.value == 'DI' && (frmObject.p_group_by.value == 'P' || frmObject.p_group_by.value == 'S' ||frmObject.p_group_by.value == 'L')){
					
					
				frmObject.p_report_id.value = 'PHCLIALTDTL';
				
				}
				else if(frmObject.p_clinical_Alert_Type.value == 'DDUP' && (frmObject.p_group_by.value == 'P' || frmObject.p_group_by.value == 'S' ||frmObject.p_group_by.value == 'L')){
					
					
				frmObject.p_report_id.value = 'PHCLIALTDTL';
				
				}
				else if(frmObject.p_clinical_Alert_Type.value == 'DDOS' && (frmObject.p_group_by.value == 'P' || frmObject.p_group_by.value == 'S' ||frmObject.p_group_by.value == 'L')){
					
					
				frmObject.p_report_id.value = 'PHCLIALTDTL';
				
				}
				else if(frmObject.p_clinical_Alert_Type.value == 'DD' && (frmObject.p_group_by.value == 'P' || frmObject.p_group_by.value == 'S' ||frmObject.p_group_by.value == 'L')){
					
					
				frmObject.p_report_id.value = 'PHCLIALTDTL';
				
				}
				
			}
			else if(frmObject.p_report_type.value == 'M' && frmObject.p_group_by.value!='')
			{		
				if(frmObject.p_clinical_Alert_Type.value == 'DA' && (frmObject.p_group_by.value == 'P' || frmObject.p_group_by.value == 'S' ||frmObject.p_group_by.value == 'L'))
				{
					frmObject.p_report_id.value = 'PHCLIALTMON';
					
				
				}
				else if(frmObject.p_clinical_Alert_Type.value == 'DI' && (frmObject.p_group_by.value == 'P' || frmObject.p_group_by.value == 'S' ||frmObject.p_group_by.value == 'L')){
					
					
				frmObject.p_report_id.value = 'PHCLIALTMON';
				
				}
				else if(frmObject.p_clinical_Alert_Type.value == 'DDUP' && (frmObject.p_group_by.value == 'P' || frmObject.p_group_by.value == 'S' ||frmObject.p_group_by.value == 'L')){
					
					
				frmObject.p_report_id.value = 'PHCLIALTMON';
				
				}
				else if(frmObject.p_clinical_Alert_Type.value == 'DDOS' && (frmObject.p_group_by.value == 'P' || frmObject.p_group_by.value == 'S' ||frmObject.p_group_by.value == 'L')){
					
					
				frmObject.p_report_id.value = 'PHCLIALTMON';
				
				}
				else if(frmObject.p_clinical_Alert_Type.value == 'DD' && (frmObject.p_group_by.value == 'P' || frmObject.p_group_by.value == 'S' ||frmObject.p_group_by.value == 'L')){
					
					
				frmObject.p_report_id.value = 'PHCLIALTMON';
				
				}
				
			}
		/*else {
				alert("group by is mandatory");
				return false;
		}*/		
				f_query_add_mod.document.FormClinicalalertReportCriteria.submit();
	}
		}		
	}  //end
}

function reset() {
		f_query_add_mod.location.reload();
		messageFrame.document.location.href='../../eCommon/jsp/error.jsp';
}



function GoBack() {
	alert(getMessage("PH_MEDN_ORD_PRACT_WARN","PH"));
	history.go(-1);
}

function callLocationLookup(locn_txt) {
	

	var argumentArray	= new Array() ;
	var dataNameArray	= new Array() ;
	var dataValueArray	= new Array() ;
	var dataTypeArray	= new Array() ;
	var formobj=document.formPhDrugandMedicalsupplyAvePerReturnVoucherCriteriafrm
		if (document.formDrugandMedicalsupplyDispensingStasticreportCriteria)      //Condition for geting Locatyion values in the report Drug and Medical supply StasticReport
		{	
			formobj=document.formDrugandMedicalsupplyDispensingStasticreportCriteria
		}
	
	dataNameArray[1]	= "FACILITY_ID" ;
	dataValueArray[1]	= formobj.p_facility_id.value;
	dataTypeArray[1]	= STRING ;
	dataNameArray[2]	= "FACILITY_ID" ;
	dataValueArray[2]	= formobj.p_facility_id.value;
	dataTypeArray[2]	= STRING ;
    	
	argumentArray[1] = dataNameArray ;
	argumentArray[2] = dataValueArray ;
	argumentArray[3] = dataTypeArray ;
	argumentArray[4] = "4,5";
	argumentArray[5] = locn_txt.value;
	argumentArray[6] = DESC_LINK ;
	argumentArray[7] = DESC_CODE ;


	if (formobj.p_locn_type.value == "N")
	{  
		//Search for Nursing Unit	
		argumentArray[0]   = escape(document.getElementById("sql_ph_nursing_unit_select").value)+ "'"+formobj.p_language_id.value+"' "+ " AND APPL_USER_ID =  '"+formobj.p_user_name.value+"' order by 2";	
		retVal=CommonLookup(getLabel("Common.nursingUnit.label","Common"), argumentArray );	
		if(retVal != null && retVal != "") {		
			formobj.p_locn_code.value=retVal[0];
			locn_txt.value = retVal[1];	
		}
		else{
			formobj.p_locn_code.value='';
			locn_txt.value = '';	
		}
	}
	else if (formobj.p_locn_type.value=="C")
	{
		//Search for Clinic 	
		argumentArray[0]   = escape(document.getElementById("sql_ph_clinic_select").value)+" '"+formobj.p_language_id.value+"' "+ " AND b.APPL_USER_ID = '"+formobj.p_user_name.value+"' order by 2";	
		retVal=CommonLookup(getLabel("Common.clinic.label","Common"), argumentArray );

		if(retVal != null && retVal != "") {
			formobj.p_locn_code.value=retVal[0];
			locn_txt.value = retVal[1];	
		}
	}
	else{
	alert(getMessage("PH_LOCATION_TYPE_CANNOT_BE_BLANK","PH"));//PH_LOCATION_TYPE_CANNOT_BE_BLANK
	}

}



function selectbilling(obj,calledby)
{
	
	var argumentArray  = new Array() ;
	var dataNameArray  = new Array() ;
	var dataValueArray = new Array() ;
	var dataTypeArray  = new Array() ; 	
 	var formobj=document.formPhDrugandMedicalsupplyAvePerReturnVoucherCriteriafrm;
	if (document.formDrugandMedicalsupplyDispensingStasticreportCriteria)    //Condition for the report Drug and Medical Supply StsticReport--billing details
		{	
			formobj=document.formDrugandMedicalsupplyDispensingStasticreportCriteria
		}
 	argumentArray[0] ="SELECT blng_grp_id code, short_desc description FROM bl_blng_grp_lang_vw WHERE   LANGUAGE_ID like ( ?) and UPPER(blng_grp_id) LIKE UPPER(?) AND UPPER(short_desc) LIKE UPPER(?)  order by 2";

	dataNameArray[0] ="locale";
	dataValueArray[0]= formobj.p_language_id.value;
	dataTypeArray[0] = STRING;

	argumentArray[1] = dataNameArray ;
	argumentArray[2] = dataValueArray ;
	argumentArray[3] = dataTypeArray ;
	argumentArray[4] = "2,3"; 
	argumentArray[5] = obj.value;
	argumentArray[6] = DESC_LINK ;//CODE_LINK
	argumentArray[7] = DESC_CODE;//CODE_DESC
	retVal = CommonLookup(getLabel("Common.BillingGroup.label","Common"), argumentArray );
		
		if(retVal != null && retVal != "") {
		
			obj.value = retVal[1] ;	
			if (calledby =='from')
			{
				formobj.p_fr_privilegde.value = retVal[0];
			}
			else
				formobj.p_to_privilegde.value = retVal[0];
		}else{
			obj.value ="";			
		}		
		
}
function checkMonth(obj){
	if ((obj.value <1 ||obj.value >12) && obj.value !='')
	{
		
		if (obj.value <1)
		{
		alert(getMessage("PH_MONTH_CANNOT_BE_LESS_THAN_1","PH"));
		obj.focus();
		}
		if (obj.value >12)
		{
		alert(getMessage("MONTH_IS_GR_12","Common"));
		obj.focus();
		}
	}

}
function checkYear(obj){
	
	var formObj =document.frames.formPhDrugandMedicalsupplyAvePerReturnVoucherCriteriafrm
    if (obj.value.length<4 && obj.value != '')
    {
		alert(getMessage("PH_INVALID_YEAR","PH"));
		obj.focus();
		return false;
    }
	if (obj.value <=0 && obj.value != '')
	{
		alert(getMessage("PH_INVALID_YEAR","PH"));
		obj.focus();
		return false;
	}
	
}

function allowPositiveNumber() { //alert()
   var key = window.event.keyCode;// allows only numbers to be entered
   if( ! ( ( key>=48 ) && ( key<=58 ) ) ) {
       return false;
   }
}


function populateDispLocs()
{
	var formObj =document.formPhDrugandMedicalsupplyAvePerReturnVoucherCriteriafrm;
	if (document.FormCompoundingDrugDispensingStaticReportCriteria)
	{
		formObj =document.FormCompoundingDrugDispensingStaticReportCriteria
	}
	else if (document.formDrugandMedicalsupplyDispensingStasticreportCriteria)
	{
		formObj =document.formDrugandMedicalsupplyDispensingStasticreportCriteria
		
	}
		
	var facility_id = formObj.p_facility_id.value;
	var disp_locn_type = formObj.p_disp_locn_type.value;
	var language_id = formObj.p_language_id.value;	
	var bean_id		= "SRRPHDrugUsageByPractBean" ; 
	var bean_name	= "ePH.SRRPHDrugUsageByPractBean" ;
	var xmlDoc="";
	var xmlHttp = new XMLHttpRequest();

	xmlStr	="<root><SEARCH " ;
	xmlStr +=" /></root>" ;
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open( "POST", "SRRPhRepDlyDispSummValidate.jsp?bean_id="+bean_id+"&bean_name="+bean_name+"&func_mode=populateDispLocsByLocationType"+"&facility_id="+facility_id+"&locale="+language_id+"&disp_locn_type="+disp_locn_type, false ) ;
	xmlHttp.send( xmlDoc ) ;
	//alert(xmlHttp.responseText);
	eval(xmlHttp.responseText);

}

function clearList(){
	
	if (document.FormCompoundingDrugDispensingStaticReportCriteria)
	{
		var disp_loc_len = eval("document.FormCompoundingDrugDispensingStaticReportCriteria.p_disp_locn").length
		obj = "FormCompoundingDrugDispensingStaticReportCriteria.p_disp_locn";
		
	}
	else if (document.formDrugandMedicalsupplyDispensingStasticreportCriteria)
	{
			var disp_loc_len = eval("document.formDrugandMedicalsupplyDispensingStasticreportCriteria.p_disp_locn").length
			obj = "document.formDrugandMedicalsupplyDispensingStasticreportCriteria.p_disp_locn";
			
	}
	else 
	{
		var disp_loc_len =document.formPhDrugandMedicalsupplyAvePerReturnVoucherCriteriafrm.p_disp_locn.options.length;
		obj = "formPhDrugandMedicalsupplyAvePerReturnVoucherCriteriafrm.p_disp_locn";
	}
	for(var i=0;i<disp_loc_len;i++) {
		eval(obj).remove("p_disp_locn") ;
	}
	if(document.formDrugandMedicalsupplyDispensingStasticreportCriteria)
	{
		
		for(var i=0;i<disp_loc_len;i++) {
		formDrugandMedicalsupplyDispensingStasticreportCriteria.p_disp_locn.remove("p_disp_locn") ;
		formDrugandMedicalsupplyDispensingStasticreportCriteria.p_disp_locn_to.remove("p_disp_locn_to") ;
		}
	}
	
}

function addOption(code,desc){

	var opt = document.createElement("OPTION") ;
	if(desc == "A")
		desc = "------"+getLabel("Common.defaultSelect.label","Common")+"-----";
	opt.text = decodeURIComponent(desc,"UTF-8") ;  //Used decodeURIcomponet For getting data into thai language---By Sandhya
	//opt.text = desc;
	opt.value = code ;
	
	if (document.FormCompoundingDrugDispensingStaticReportCriteria) // Dispense locations for the function Compunding drug dispensing Report
	{
		document.FormCompoundingDrugDispensingStaticReportCriteria.p_disp_locn.add(opt);
    }
	else if (document.formDrugandMedicalsupplyDispensingStasticreportCriteria) //  Dispense locations for the function Drug and Medical supply Dispensing stastic report
	{
			document.formDrugandMedicalsupplyDispensingStasticreportCriteria.p_disp_locn.add(opt);
			var opt1 = document.createElement("OPTION") ;
			if(desc == "A")
			desc = "------"+getLabel("Common.defaultSelect.label","Common")+"-----";
			//opt1.text = desc ;
			opt1.text = decodeURIComponent(desc,"UTF-8");  //Used decodeURIcomponet For getting data into thai language- on 1st/Oct/2010--By Sandhya
			opt1.value = code ;	
	
			document.formDrugandMedicalsupplyDispensingStasticreportCriteria.p_disp_locn_to.add(opt1);
	}
	else                                                                                   
	{
		document.formPhDrugandMedicalsupplyAvePerReturnVoucherCriteriafrm.p_disp_locn.add(opt);
	}
	
}

function ChkSplChars(obj)
{
	var str=obj.value;
	
	var chk="1234567890";
	for(var i=0; i<str.length; i++)
	{
		
		  if (chk.indexOf(str.charAt(i)) == -1) 
			{
				  alert(getMessage("INVALID_NUMBER_FORMAT", "PH"));
				  obj.select();
				  obj.focus();
				  return;
			}
	}
}

function clearLocation(){
	if (document.formDrugandMedicalsupplyDispensingStasticreportCriteria)
	{	
		formDrugandMedicalsupplyDispensingStasticreportCriteria.p_locn_code.value = '';
		formDrugandMedicalsupplyDispensingStasticreportCriteria.locn_text.value = '';
	}
	else 
	{
		formPhDrugandMedicalsupplyAvePerReturnVoucherCriteriafrm.p_locn_code.value = '';
		formPhDrugandMedicalsupplyAvePerReturnVoucherCriteriafrm.locn_text.value = '';
	}

  
}


function ChkSplChars_time(obj)
{
	var str=obj.value;
	
	var chk="1234567890:";
	for(var i=0; i<str.length; i++)
	{
		
		  if (chk.indexOf(str.charAt(i)) == -1) 
			{
				  alert(getMessage("INVALID_TIME_FMT", "PH"));
				  obj.select();
				  obj.focus();
				  return;
			}
	}
	if (obj.value != '')
	{
		var splitVal = obj.value.split(":");
		
		if (splitVal.length == 2)
		{
			var hrVal = splitVal[0];
			var minVal = splitVal[1];
			
			if (hrVal != '' && minVal != '')
			{
				if (hrVal < 0 || hrVal > 23 || minVal <0 || minVal >59)
				{
					alert(getMessage("INVALID_TIME_FMT", "PH"));
					obj.select();
					obj.focus();
					return;
				}
				if (hrVal.length != 2 || minVal.length != 2)
				{
					alert(getMessage("INVALID_TIME_FMT", "PH"));
					obj.select();
					obj.focus();
					return;
				}
				
			}
			else{
				alert(getMessage("INVALID_TIME_FMT", "PH"));
				obj.select();
				obj.focus();
				return;
				
			}
		}
		else{
				alert(getMessage("INVALID_TIME_FMT", "PH"));
				obj.select();
				obj.focus();
				return;	
		
		}
	}
	
}
function changeLegends(obj){
	var report_type =obj.value;
	if (report_type == 'M')
		 {
			document.getElementById("month_year_from").style.display='inline';
			document.getElementById("month_year_to").style.display='inline';
			document.getElementById("month_year_from_txt").style.display='inline';
			document.getElementById("date_from").style.display='none';
			document.getElementById("date_from_txt").style.display='none';
			document.getElementById("date_to").style.display='none';

		 }else{
			document.getElementById("month_year_from").style.display='none';
			document.getElementById("month_year_to").style.display='none';
			document.getElementById("month_year_from_txt").style.display='none';
			document.getElementById("date_from").style.display='inline';
			document.getElementById("date_from_txt").style.display='inline';
			document.getElementById("date_to").style.display='inline';
		 }
	
}

