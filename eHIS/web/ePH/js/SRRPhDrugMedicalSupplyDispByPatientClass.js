  //saved on 16/2/2010
function run() {

	var frmObject = f_query_add_mod.document.formDispByPatientClass;
	var frmObject1 = f_query_add_mod.document.formRxBillingReconicle;
	var frmObject2 = f_query_add_mod.document.formPHAdverseEvent;
	if(f_query_add_mod.document.formDispByPatientClass) {
    //assiging values to the hidden values of report parameters
		if (frmObject.p_month_from.value == '' || frmObject.p_fm_year.value == '')
		{
			alert(getMessage("PH_MONTH_YEAR_FROM_CANNOT_BLANK","PH"));			
			return false;
		}
		if (frmObject.p_month_to.value == '' || frmObject.p_to_year.value == '')
		{
			
			alert(getMessage("PH_MONTH_YEAR_TO_CANNOT_BLANK","PH"));
			return false;
		}
		if (frmObject.p_to_year.value < frmObject.p_fm_year.value)
		{
			alert(getMessage("TO_DATE_EQUAL_GREATER_FROM_DATE","PH"));
			return false;
		}else if ( (frmObject.p_to_year.value == frmObject.p_fm_year.value )&& (frmObject.p_month_to.value < frmObject.p_month_from.value) )
		{
			alert(getMessage("FROM_DATE_LESS_EQ_TO_DT","PH"));
			return false;
		}
		var fields= new Array (frmObject.p_time_from,frmObject.p_time_to);
		var names= new Array (getLabel("Common.from.label","Common")+" "+getLabel("ePH.TimeHH:MM.label","PH"),getLabel("Common.to.label","Common")+" "+getLabel("ePH.TimeHH:MM.label","PH"));
		
		if(checkFields(fields,names,messageFrame)){	
			//alert("inside dates=====33==");
			frmObject.p_disp_time_from.value = frmObject.p_time_from.value;
			frmObject.p_disp_time_to.value = frmObject.p_time_to.value;
			frmObject.p_disp_loc.value = frmObject.p_disp_locn.value;
			frmObject.p_disp_loc_from.value = frmObject.p_locn_code.value;
			/*===============================================================================================================*/
			var p_fm_year_temp1 = "01/01/"+frmObject.p_fm_year.value;
			var p_to_year_temp1 = "01/01/"+frmObject.p_to_year.value;
			var p_fm_year_temp2 = convertDate(p_fm_year_temp1,'DMY',frmObject.p_language_id.value,"en");
			var p_to_year_temp2 = convertDate(p_to_year_temp1,'DMY',frmObject.p_language_id.value,"en");		
			var fm_vals = p_fm_year_temp2.split("/");
			var to_vals =  p_to_year_temp2.split("/"); 
			frmObject.p_year_from.value = fm_vals[2];
			frmObject.p_year_to.value =  to_vals[2];
			
/*===============================================================================================================*/

			
			//frmObject.p_sale_flag.value = frmObject.p_sale_return.value; commented on 20/sept/2010 by sandhya regarding incident  23813 in spira
			
			f_query_add_mod.document.formDispByPatientClass.submit();
		}
		
	}
	if (frmObject1)
	{
		var fields= new Array (frmObject1.p_store_text,frmObject1.dt_from,frmObject1.dt_to,frmObject1.p_time_from,frmObject1.p_time_to);
		var names= new Array (getLabel("Common.StoreCode.label","Common"),getLabel("Common.date.label","Common"),getLabel("Common.todate.label","Common"),getLabel("Common.from.label","Common")+" "+getLabel("ePH.TimeHH:MM.label","PH"),getLabel("Common.to.label","Common")+" "+getLabel("ePH.TimeHH:MM.label","PH"));
		
		if(checkFields(fields,names,messageFrame)){	
			frmObject1.p_frm_time.value = frmObject1.p_time_from.value;
			frmObject1.p_to_time.value = frmObject1.p_time_to.value;			
			if( f_query_add_mod.doDateCheck( f_query_add_mod.document.formRxBillingReconicle.dt_from, f_query_add_mod.document.formRxBillingReconicle.dt_to, messageFrame ) ) {
				
				var locale = frmObject1.p_language_id.value;
				//alert("locale=======>" +locale);
				var p_disp_date_from1=convertDate(f_query_add_mod.document.formRxBillingReconicle.dt_from.value,"DMY",locale,"en"); //Added Variables for the incident num:Billing Reconcile report on 30/12/2010==By Sandhya
				var p_disp_date_to1=convertDate(f_query_add_mod.document.formRxBillingReconicle.dt_to.value,"DMY",locale,"en");
				//alert("p_disp_date_from1==71====>" +p_disp_date_from1);
				//alert("p_disp_date_to1====72==>" +p_disp_date_to1);
				//frmObject1.p_frm_date.value = frmObject1.dt_from.value;
				frmObject1.p_frm_date.value = p_disp_date_from1;
				//frmObject1.p_to_date.value = frmObject1.dt_to.value;
				frmObject1.p_to_date.value = p_disp_date_to1;
				frmObject1.p_frm_token_no .value = frmObject1.p_token_from.value;
				frmObject1.p_to_token_no .value = frmObject1.p_token_to.value;
				frmObject1.p_sale_flag .value = frmObject1.p_sale_return.value;
				if (frmObject1.p_report_type.value =='S')
				{
					frmObject1.p_report_id .value ="PHBLRECSUM";
				}
				else{
					frmObject1.p_report_id .value ="PHBLRECBLNG";
				}
				

				f_query_add_mod.document.formRxBillingReconicle.submit();
			}
		}
	}
	if (frmObject2)
	{
		var fields= new Array (frmObject2.p_hypersensitivity_type,frmObject2.p_event_type);
		var names= new Array (getLabel("ePH.Hypersensitivity.label","PH"),getLabel("Common.EventType.label","Common"));
		
		if(checkFields(fields,names,messageFrame)){	
			if( f_query_add_mod.doDateCheck( f_query_add_mod.document.formPHAdverseEvent.dt_from, f_query_add_mod.document.formPHAdverseEvent.dt_to, messageFrame ) ) {
				
				frmObject2.p_adv_hyper.value			= frmObject2.p_hypersensitivity_type.value;
				frmObject2.p_adv_event_type.value		= frmObject2.p_event_type.value;
				frmObject2.p_causative_substance.value	= frmObject2.p_substance_code.value;
				frmObject2.p_frm_onset_date.value		= convertDate(frmObject2.dt_from.value,'DMY',frmObject2.p_language_id.value,"en");
				frmObject2.p_to_onset_date.value		=  convertDate(frmObject2.dt_to.value,'DMY',frmObject2.p_language_id.value,"en");
				frmObject2.p_items_by.value				= frmObject2.p_patient_certainity.value;
				frmObject2.p_certainty.value			= frmObject2.p_certainity.value;
				if (frmObject2.p_report_type.value	== 'S')
				{
					frmObject2.p_report_id.value = 'PHADVEVENTSUM';					
				}
				else if (frmObject2.p_report_type.value	== 'D')
				{
					frmObject2.p_report_id.value = 'PHADVEVENTDTL';
				}
				else{
					frmObject2.p_report_id.value = '';
				}
				
				f_query_add_mod.document.formPHAdverseEvent.submit();
			}
		}
	}
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

	
	dataNameArray[1]	= "FACILITY_ID" ;
	dataValueArray[1]	= formDispByPatientClass.p_facility_id.value;
	dataTypeArray[1]	= STRING ;
	dataNameArray[2]	= "FACILITY_ID" ;
	dataValueArray[2]	= formDispByPatientClass.p_facility_id.value;
	dataTypeArray[2]	= STRING ;
    	
	argumentArray[1] = dataNameArray ;
	argumentArray[2] = dataValueArray ;
	argumentArray[3] = dataTypeArray ;
	argumentArray[4] = "4,5";
	argumentArray[5] = locn_txt.value;
	argumentArray[6] = DESC_LINK ;
	argumentArray[7] = DESC_CODE ;


	if (formDispByPatientClass.p_locn_type.value == "N")
	{  
		//Search for Nursing Unit	
		
		argumentArray[0]   = escape(document.getElementById("sql_ph_nursing_unit_select").value)+ "'"+formDispByPatientClass.p_language_id.value+"' "+ " AND APPL_USER_ID =  '"+formDispByPatientClass.p_user_name.value+"' order by 2";	
		retVal=CommonLookup(getLabel("Common.nursingUnit.label","Common"), argumentArray );	
	
		if(retVal != null && retVal != "") {		
			formDispByPatientClass.p_locn_code.value=retVal[0];
			locn_txt.value = retVal[1];	
		}
		else{
			formDispByPatientClass.p_locn_code.value='';
			locn_txt.value = '';	
		}
	}
	else if (formDispByPatientClass.p_locn_type.value=="C")
	{
		//Search for Clinic 	
		argumentArray[0]   = escape(document.getElementById("sql_ph_clinic_select").value)+" '"+formDispByPatientClass.p_language_id.value+"' "+ " AND b.APPL_USER_ID = '"+formDispByPatientClass.p_user_name.value+"' order by 2";	
		retVal=CommonLookup(getLabel("Common.clinic.label","Common"), argumentArray );

		if(retVal != null && retVal != "") {
			formDispByPatientClass.p_locn_code.value=retVal[0];
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
 	
 	argumentArray[0] ="SELECT blng_grp_id code, short_desc description FROM bl_blng_grp_lang_vw WHERE   LANGUAGE_ID like ( ?) and UPPER(blng_grp_id) LIKE UPPER(?) AND UPPER(short_desc) LIKE UPPER(?)  order by 2";

	dataNameArray[0] ="locale";
	dataValueArray[0]= formDispByPatientClass.p_language_id.value;
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
				formDispByPatientClass.p_privilege_fm.value = retVal[0];
			}
			else
				formDispByPatientClass.p_privilege_to.value = retVal[0];
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
	
	var formObj =document.frames.formDispByPatientClass
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
	var formObj =document.formDispByPatientClass;
	var facility_id = formObj.p_facility_id.value;
	var disp_locn_type = formObj.p_disp_type.value;
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
	
	var disp_loc_len =document.formDispByPatientClass.p_disp_locn.options.length;
	for(var i=0;i<disp_loc_len;i++) {
		formDispByPatientClass.p_disp_locn.remove("p_disp_locn") ;
	}
}

function addOption(code,desc){

	var opt = document.createElement("OPTION") ;
	if(desc == "A")
		desc = "--"+getLabel("Common.defaultSelect.label","Common")+"--";
	//opt.text = desc ;
	opt.text = decodeURIComponent(desc,"UTF-8") ; //ADDED DecodeUriComponent for optdesc to convert language  into thai for the incident num:24677,24678 on 25/Oct/2010===By Sandhya
	opt.value = code ;	
	document.formDispByPatientClass.p_disp_locn.add(opt);

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

  formDispByPatientClass.p_locn_code.value = '';
  formDispByPatientClass.locn_text.value = '';
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

function checkSaleReturn(obj){
 if (obj != undefined && obj != null)
 {
	 if (obj.checked)
	 {
		 obj.value = 'Y';
	 }
	 else
		 obj.value = 'N';
 }
}

function changePateintCertainity(object){
if (formPHAdverseEvent.p_report_type.value == 'S')
{	
	if (formPHAdverseEvent.p_certainity.value == 'D' || formPHAdverseEvent.p_certainity.value == '' )
	{
		formPHAdverseEvent.p_patient_certainity.value='D';
		if (formPHAdverseEvent.p_certainity.value == '')
		{
			formPHAdverseEvent.p_patient_certainity.disabled =false;
		}
		else{
			formPHAdverseEvent.p_patient_certainity.disabled =true;
		}
	}
	else if (formPHAdverseEvent.p_certainity.value == 'P')
	{
		formPHAdverseEvent.p_patient_certainity.value='P';
		formPHAdverseEvent.p_patient_certainity.disabled =true;
	}
	

}
else{
	//formPHAdverseEvent.p_order_by.disabled =true;
	formPHAdverseEvent.p_patient_certainity.disabled =true;
	formPHAdverseEvent.p_patient_certainity.value ='';
}

}

function callPatientSearch(target)
{
	alert("sandy");
	var patient_id = PatientSearch();
 if(patient_id != null && patient_id != "" )  
	 {		
		target.value = patient_id;
	 }
}


function populateEventType(obj){
	var formObj =document.formPHAdverseEvent;	
	var language_id = formObj.p_language_id.value;	
	var hypersensitivity = obj.value;	
	var bean_id		= "SRRPHDrugUsageByPractBean" ; 
	var bean_name	= "ePH.SRRPHDrugUsageByPractBean" ;
	var xmlDoc="";
	var xmlHttp = new XMLHttpRequest();

	xmlStr	="<root><SEARCH " ;
	xmlStr +=" /></root>" ;
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open( "POST", "SRRPhRepDlyDispSummValidate.jsp?bean_id="+bean_id+"&bean_name="+bean_name+"&locale="+language_id+"&func_mode=populateEventType"+"&hypersensitivity="+hypersensitivity, false ) ;
	xmlHttp.send( xmlDoc ) ;
	//alert(xmlHttp.responseText);
	eval(xmlHttp.responseText);

}
function clearList_eventType(){
	
	var p_event_type_len =document.formPHAdverseEvent.p_event_type.options.length;
	for(var i=0;i<p_event_type_len;i++) {
		formPHAdverseEvent.p_event_type.remove("p_event_type") ;
	}
}

function addOption_eventType(code,desc){

	var opt = document.createElement("OPTION") ;
	if(desc == "A")
		desc = "--"+getLabel("Common.defaultSelect.label","Common")+"--";
	opt.text = desc ;
	opt.value = code ;	
	document.formPHAdverseEvent.p_event_type.add(opt);

}

function callAllergenLookup(obj) {

	var hypersensitivity	= formPHAdverseEvent.p_hypersensitivity_type.value;
	var eventType			= formPHAdverseEvent.p_event_type.value;
	if (eventType == 'DA')
	{
		callGenericSearch(obj,hypersensitivity,eventType);
	}
	else{
		callotherSearch(obj,hypersensitivity,eventType);
	}


}


function callGenericSearch(obj,hypersensitivity,eventType){
	
		var locale = formPHAdverseEvent.p_language_id.value
		var argumentArray  = new Array() ;
		var dataNameArray  = new Array() ;
		var dataValueArray = new Array() ;
		var dataTypeArray  = new Array() ;
		var target="";
		var sql="select code, description from (SELECT GENERIC_ID code, GENERIC_NAME description FROM PH_GENERIC_NAME_LANG_VW where LANGUAGE_ID='"+locale+"' UNION select ALLERGEN_CODE code, LONG_DESC || '**' description  from  MR_ALLERGEN_LANG_VW  where ADV_EVENT_TYPE_IND='"+hypersensitivity+"' and LANGUAGE_ID='"+locale+"' and ADV_EVENT_TYPE_CODE='"+eventType+"') where upper(code) like upper(?) and upper(ltrim(description,'*')) like upper(?) order by 2";

		argumentArray[0] = sql ;
		argumentArray[1] = dataNameArray ;
		argumentArray[2] = dataValueArray ;
		argumentArray[3] = dataTypeArray ;
		argumentArray[4] = "1,2";
		argumentArray[5] = obj.value;
		argumentArray[6] = CODE_LINK ;
		argumentArray[7] = CODE_DESC ; 

		retVal = await CommonLookup(  getLabel("Common.GenericNameLookup.label","Common"), argumentArray );		
	
		var arr=new Array();
		if (retVal != null && retVal != '' && retVal != undefined)
		{

			var retVal=unescape(retVal);
		   	 arr=retVal.split(",");
			var arr_desc=arr[1];

			if(arr_desc.indexOf("**") !=-1)
			{
				arr_desc=arr_desc.substring(0,arr_desc.length-2);
			}else
			{
			}
		    formPHAdverseEvent.p_allergen_text.value=arr_desc;
			formPHAdverseEvent.p_allergen_code.value=arr[0];
		}
		else{
			formPHAdverseEvent.p_allergen_text.value='';
			formPHAdverseEvent.p_allergen_code.value='';
		
		}

}

function callotherSearch(obj,hypersensitivity,eventType)
{
	
		var argumentArray  = new Array() ;
		var dataNameArray  = new Array() ;
		var dataValueArray = new Array() ;
		var dataTypeArray  = new Array() ;
		var locale = formPHAdverseEvent.p_language_id.value
		var sql="select b.ALLERGEN_CODE code ,b.LONG_DESC description  from  MR_ADV_EVENT_TYPE_IND a ,MR_ALLERGEN_lang_vw b, MR_ADV_EVENT_TYPE c where a.ADV_EVENT_TYPE_IND='"+hypersensitivity+"' and c.ADV_EVENT_TYPE_CODE='"+eventType+"' and b.language_id='"+locale+"' and b.ADV_EVENT_TYPE_IND=a.ADV_EVENT_TYPE_IND  and c.ADV_EVENT_TYPE_CODE = b.ADV_EVENT_TYPE_CODE and upper(b.ALLERGEN_CODE) like upper(?) and upper(b.LONG_DESC) like upper(?)   Order by b.LONG_DESC ";
		argumentArray[0] = sql ;
		argumentArray[1] = dataNameArray ;
		argumentArray[2] = dataValueArray ;
		argumentArray[3] = dataTypeArray ;
		argumentArray[4] = "1,2";
		argumentArray[5] = obj.value;
		argumentArray[6] = CODE_LINK ;
		argumentArray[7] = CODE_DESC ; 

		retVal = await CommonLookup( getLabel("eMR.Allergen.label","MR"), argumentArray );
		var arr=new Array();
		if (retVal != null && retVal != '' && retVal != undefined)
		{
			var retVal=unescape(retVal);

			arr=retVal.split(",");
			var desc=arr[1];
			var code=arr[0];
			formPHAdverseEvent.p_allergen_text.value=desc;
			formPHAdverseEvent.p_allergen_code.value=code;
		}
		else{
			formPHAdverseEvent.p_allergen_text.value='';
			formPHAdverseEvent.p_allergen_code.value='';
		
		}
}


function open_cause_subs_lup()
{
		if (formPHAdverseEvent.p_event_type.value == 'DA')
		{
			var allergen_code=formPHAdverseEvent.p_allergen_code.value;
			var locale=formPHAdverseEvent.p_language_id.value;

			var argumentArray  = new Array() ;
			var dataNameArray  = new Array() ;
			var dataValueArray = new Array() ;
			var dataTypeArray  = new Array() ;
			var target="";
			var sql="select DRUG_CODE code , DRUG_DESC description from  ph_drug_lang_vw where GENERIC_ID='"+allergen_code+"' and language_id='"+locale+"' AND upper(DRUG_CODE) like upper(?) and upper(DRUG_DESC) like upper(?) ";

			argumentArray[0] = sql ;
			argumentArray[1] = dataNameArray ;
			argumentArray[2] = dataValueArray ;
			argumentArray[3] = dataTypeArray ;
			argumentArray[4] = "1,2";
			argumentArray[5] = formPHAdverseEvent.p_substance_text.value;
			argumentArray[6] = CODE_LINK ;
			argumentArray[7] = CODE_DESC ; 
			var arr=new Array();
			retVal = CommonLookup(getLabel("eMR.DrugLookup.label","MR"), argumentArray );
			
			if (retVal != null && retVal != '' && retVal != "null")
			{
				var retVal=unescape(retVal);
				arr=retVal.split(",");
				formPHAdverseEvent.p_substance_text.value=arr[1];
				formPHAdverseEvent.p_substance_code.value=arr[0];
			}else
			{
				formPHAdverseEvent.p_substance_text.value='';
				formPHAdverseEvent.p_substance_code.value='';
			}
		}
		else{
		
		}
	
}

function changeTop(){
	
		if (formPHAdverseEvent.p_report_type.value == 'S')
		{
			formPHAdverseEvent.p_top.disabled = false;
		}
		else
			{
			formPHAdverseEvent.p_top.value = '';
			formPHAdverseEvent.p_top.disabled = true;
			}
}
function changeOrderBy(){
	
	if ((formPHAdverseEvent.p_report_type.value == 'S') && (formPHAdverseEvent.p_certainity.value == ''))
  {		
	clearList_orderby();
	addOption_orderby('',"--"+getLabel("Common.defaultSelect.label","Common")+"--");
	addOption_orderby('D','No. of Patient(Definitive)');
	addOption_orderby('P','No. of Patient(Probable)');
	addOption_orderby('T','No. of Patient(Total)');
	addOption_orderby('A','Allergen (Description)');	
	formPHAdverseEvent.p_order_by.disabled =false;
	formPHAdverseEvent.p_order_by.value = 'A';
  }
 else if ((formPHAdverseEvent.p_report_type.value == 'S') && (formPHAdverseEvent.p_certainity.value == 'D'))
  {
	clearList_orderby();
	addOption_orderby('',"--"+getLabel("Common.defaultSelect.label","Common")+"--");
	addOption_orderby('D','No. of Patient(Definitive)');
	addOption_orderby('A','Allergen (Description)');	
	formPHAdverseEvent.p_order_by.disabled =false;
	formPHAdverseEvent.p_order_by.value = 'D';
  }
  else if ((formPHAdverseEvent.p_report_type.value == 'S') && (formPHAdverseEvent.p_certainity.value == 'P'))
  {
	clearList_orderby();
	addOption_orderby('',"--"+getLabel("Common.defaultSelect.label","Common")+"--");
	addOption_orderby('P','No. of Patient(Probable)');
	addOption_orderby('A','Allergen (Description)');	
	formPHAdverseEvent.p_order_by.disabled =false;
	formPHAdverseEvent.p_order_by.value = 'P';
  }
  else
	{
	clearList_orderby();
	addOption_orderby('',"--"+getLabel("Common.defaultSelect.label","Common")+"--");
	formPHAdverseEvent.p_order_by.disabled =true;
   }
  
}
function clearList_orderby(){	
	var order_by_len =document.formPHAdverseEvent.p_order_by.options.length;
	for(var i=0;i<order_by_len;i++) {
		formPHAdverseEvent.p_order_by.remove("p_order_by") ;
	}
}

function addOption_orderby(code,desc){
	var opt = document.createElement("OPTION") ;
	if(desc == "A")
		desc = "--"+getLabel("Common.defaultSelect.label","Common")+"--";
	opt.text = desc ;
	opt.value = code ;	
	document.formPHAdverseEvent.p_order_by.add(opt);

}

function callStoreLookup(obj){	
				
			var locale=formRxBillingReconicle.p_language_id.value;
			var argumentArray  = new Array() ;
			var dataNameArray  = new Array() ;
			var dataValueArray = new Array() ;
			var dataTypeArray  = new Array() ;
			var target="";
			var sql="select STORE_CODE code , SHORT_DESC description  from PH_DISP_LOCN_LANG_VW where language_id='"+locale+"' and eff_status ='E' and upper(STORE_CODE) like upper(?) AND upper(SHORT_DESC) like upper(?)";

			argumentArray[0] = sql ;
			argumentArray[1] = dataNameArray ;
			argumentArray[2] = dataValueArray ;
			argumentArray[3] = dataTypeArray ;
			argumentArray[4] = "1,2";
			argumentArray[5] = obj.value;
			argumentArray[6] = CODE_LINK ;
			argumentArray[7] = CODE_DESC ; 
			var arr=new Array();
			retVal = CommonLookup(getLabel("ePH.StoreLookup.label","PH"), argumentArray );
			
			if (retVal != null && retVal != '')
			{
				var retVal=unescape(retVal);
				arr=retVal.split(",");
				formRxBillingReconicle.p_store_text.value=arr[1];
				formRxBillingReconicle.p_store_code.value=arr[0];
			}else
			{
				formRxBillingReconicle.p_store_text.value='';
				formRxBillingReconicle.p_store_code.value='';
			}
			
}

function enable_cSubstance(){
 if (formPHAdverseEvent.p_event_type.value == 'DA')
 {
		formPHAdverseEvent.p_substance_text.disabled =false;
		formPHAdverseEvent.sub_lookup_btn.disabled =false;

 }
 else{
		formPHAdverseEvent.p_substance_text.disabled =true;
		formPHAdverseEvent.sub_lookup_btn.disabled =true;
		formPHAdverseEvent.p_substance_code.value='';
		formPHAdverseEvent.p_substance_text.value ='';
 }
}


function callPatientSearch(){
	
	
	var patient_id = PatientSearch();
	if (patient_id!= "" && patient_id != undefined){

		formPHAdverseEvent.p_patient_id.value = patient_id;
		

		/*var bean_id		= "ADRReportBean" ;
		  var bean_name	= "ePH.ADRReportBean";  Commented  code on 19/aug/2010 bcoz Reference is not taking properly regdng incident :23328 in spira */
	
		var bean_id		= formPHAdverseEvent.bean_id1.value ;
		var bean_name	= formPHAdverseEvent.bean_name1.value;
		//alert("bean_id====>" +bean_id);
		//alert("bean_name====>" +bean_name);
		var xmlDoc="";
		var xmlHttp = new XMLHttpRequest();
		xmlStr	="<root><SEARCH " ;
		xmlStr +=" /></root>" ;
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open( "POST", "SRRPhRepDlyDispSummValidate.jsp?bean_id="+bean_id+"&bean_name="+bean_name+"&patient_id="+patient_id+"&func_mode=CALLPATIENT", false ) ;
		xmlHttp.send( xmlDoc ) ;
//		alert('xmlHttp.responseText  ---  :'+xmlHttp.responseText);
		eval(xmlHttp.responseText);
	}
	else{
		formPHAdverseEvent.p_patient_name.style.display="none";
		formPHAdverseEvent.p_patient_name.innerText='';
	}
}

function assignPatientLine(p_name){


	formPHAdverseEvent.p_patient_name.style.display="inline";
	//formPHAdverseEvent.p_patient_name.innerText=p_name; Commented code for the incident num:23328 in spira on 19/Aug/2010
	formPHAdverseEvent.p_patient_name.innerText=decodeURIComponent(p_name,"UTF-8"); //Added decode URIComponent regdng incident num:23328
	
	
}

function changePatientEnable(obj){
	
	//if ( obj.value== 'S') Commented on 12/Aug/2010 for the incident num:23205 
	if ( obj.value== 'D')
	{
		formPHAdverseEvent.p_patient_id.disabled = false;
		formPHAdverseEvent.Patient_Button.disabled = false;
	}
	else{
		
		formPHAdverseEvent.p_patient_name.style.display="none";
		formPHAdverseEvent.p_patient_name.innerText='';
		formPHAdverseEvent.p_patient_id.value = '';
		formPHAdverseEvent.p_patient_id.disabled = true;
		formPHAdverseEvent.Patient_Button.disabled = true;
	}
}

//Validations for Billing Lookup----Onblur event on 20/sept/2010 for the incident num:23813
function chkbill()
{
		//alert("document.formDispByPatientClass.billing_from.value======69" +document.formDispByPatientClass.billing_from.value);
		//alert("document.formDispByPatientClass.p_privilege_fm.value=====70" +document.formDispByPatientClass.p_privilege_fm.value);
	if(document.formDispByPatientClass.billing_from.value==null || document.formDispByPatientClass.billing_from.value=="")
	{
		
		document.formDispByPatientClass.p_privilege_fm.value="";
	}
	if(document.formDispByPatientClass.billing_to.value==null || document.formDispByPatientClass.billing_to.value=="")
	{
		
		document.formDispByPatientClass.p_privilege_to.value="";
	}
	

}
