function run() {

	var frmObject = f_query_add_mod.document.formReturnAveNoOfItemPerRetVoucherCriteria;
	
	//var frmObject3 = f_query_add_mod.document.formReturnAveNoOfItemPerRetVoucherCriteria;
	if(f_query_add_mod.document.formReturnAveNoOfItemPerRetVoucherCriteria) {
    
		

		var fields= new Array (frmObject.dt_from,frmObject.dt_to,frmObject.p_time_from,frmObject.p_time_to);
		var names= new Array (getLabel("Common.date.label","Common"),getLabel("Common.todate.label","Common"),getLabel("Common.from.label","Common")+" "+getLabel("ePH.TimeHH:MM.label","PH"),getLabel("Common.to.label","Common")+" "+getLabel("ePH.TimeHH:MM.label","PH"));
		if(checkFields(fields,names,messageFrame)){			
		if( f_query_add_mod.doDateCheck( f_query_add_mod.document.formReturnAveNoOfItemPerRetVoucherCriteria.dt_from, f_query_add_mod.document.formReturnAveNoOfItemPerRetVoucherCriteria.dt_to, messageFrame ) ) {
				
				var locale = frmObject.p_language_id.value;
				
				var P_FRM_DISPN_DATE=convertDate(frmObject.dt_from.value,"DMY",locale,"en"); //Added Variables for the incident num:==By Sandhya
				var P_TO_DISPN_DATE=convertDate(frmObject.dt_to.value,"DMY",locale,"en");

				
				
				
				//frmObject.p_fr_dt.value = frmObject.dt_from.value;
				frmObject.p_fr_dt.value = P_FRM_DISPN_DATE

				//frmObject.p_to_dt.value = frmObject.dt_to.value;
				frmObject.p_to_dt.value = P_TO_DISPN_DATE;
				frmObject.p_fr_time.value = frmObject.p_time_from.value;
				frmObject.p_to_time.value = frmObject.p_time_to.value;
				frmObject.p_to_time.value = frmObject.p_time_to.value;
				frmObject.p_disp_type.value = frmObject.p_disp_locn_type.value;
				frmObject.p_fr_disp_locn.value = frmObject.p_disp_locn.value;
				frmObject.p_to_disp_locn.value = frmObject.p_disp_locn_to.value;
				frmObject.p_location.value = frmObject.p_locn_code.value;
				frmObject.p_fr_priv.value = frmObject.p_fr_privilegde.value;
				frmObject.p_to_priv.value = frmObject.p_to_privilegde.value;
				f_query_add_mod.document.formReturnAveNoOfItemPerRetVoucherCriteria.submit();
			}
		}		
	} //ends here

	

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
	dataValueArray[1]	= formReturnAveNoOfItemPerRetVoucherCriteria.p_facility_id.value;
	dataTypeArray[1]	= STRING ;
	dataNameArray[2]	= "FACILITY_ID" ;
	dataValueArray[2]	= formReturnAveNoOfItemPerRetVoucherCriteria.p_facility_id.value;
	dataTypeArray[2]	= STRING ;
    	
	argumentArray[1] = dataNameArray ;
	argumentArray[2] = dataValueArray ;
	argumentArray[3] = dataTypeArray ;
	argumentArray[4] = "4,5";
	argumentArray[5] = locn_txt.value;
	argumentArray[6] = DESC_LINK ;
	argumentArray[7] = DESC_CODE ;


	if (formReturnAveNoOfItemPerRetVoucherCriteria.p_locn_type.value == "N")
	{  
		//Search for Nursing Unit	
		argumentArray[0]   = escape(document.getElementById("sql_ph_nursing_unit_select").value)+ "'"+formReturnAveNoOfItemPerRetVoucherCriteria.p_language_id.value+"' "+ " AND APPL_USER_ID =  '"+formReturnAveNoOfItemPerRetVoucherCriteria.p_user_name.value+"' order by 2";	
		retVal=CommonLookup(getLabel("Common.nursingUnit.label","Common"), argumentArray );	
		if(retVal != null && retVal != "") {		
			formReturnAveNoOfItemPerRetVoucherCriteria.p_locn_code.value=retVal[0];
			locn_txt.value = retVal[1];	
		}
		else{
			formReturnAveNoOfItemPerRetVoucherCriteria.p_locn_code.value='';
			locn_txt.value = '';	
		}
	}
	else if (formReturnAveNoOfItemPerRetVoucherCriteria.p_locn_type.value=="C")
	{
		//Search for Clinic 	
		argumentArray[0]   = escape(document.getElementById("sql_ph_clinic_select").value)+" '"+formReturnAveNoOfItemPerRetVoucherCriteria.p_language_id.value+"' "+ " AND b.APPL_USER_ID = '"+formReturnAveNoOfItemPerRetVoucherCriteria.p_user_name.value+"' order by 2";	
		retVal=CommonLookup(getLabel("Common.clinic.label","Common"), argumentArray );

		if(retVal != null && retVal != "") {
			formReturnAveNoOfItemPerRetVoucherCriteria.p_locn_code.value=retVal[0];
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
	dataValueArray[0]= formReturnAveNoOfItemPerRetVoucherCriteria.p_language_id.value;
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
				formReturnAveNoOfItemPerRetVoucherCriteria.p_fr_privilegde.value = retVal[0];
			}
			else
				formReturnAveNoOfItemPerRetVoucherCriteria.p_to_privilegde.value = retVal[0];
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
	
	var formObj =document.frames.formReturnAveNoOfItemPerRetVoucherCriteria
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
	
	
	var formObj =document.formReturnAveNoOfItemPerRetVoucherCriteria;
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
	
	
	var disp_loc_len =document.formReturnAveNoOfItemPerRetVoucherCriteria.p_disp_locn.options.length;
	for(var i=0;i<disp_loc_len;i++) {
		formReturnAveNoOfItemPerRetVoucherCriteria.p_disp_locn.remove("p_disp_locn") ;
		formReturnAveNoOfItemPerRetVoucherCriteria.p_disp_locn_to.remove("p_disp_locn_to") ;
	}
	
}

function addOption(code,desc){

	var opt = document.createElement("OPTION") ;
	if(desc == "A")
		desc = "------"+getLabel("Common.defaultSelect.label","Common")+"-----";
	//opt.text = desc ;
	opt.text = decodeURIComponent(desc,"UTF-8") ; //ADDED DecodeUriComponent for optdesc to convert language into thai--on 1st/Oct/2010 -By Sandhya
	
	opt.value = code ;	
	document.formReturnAveNoOfItemPerRetVoucherCriteria.p_disp_locn.add(opt);

	var opt1 = document.createElement("OPTION") ;
	if(desc == "A")
		desc = "------"+getLabel("Common.defaultSelect.label","Common")+"-----";
	//opt1.text = desc ;
	opt1.text = decodeURIComponent(desc,"UTF-8") ;  //ADDED DecodeUriComponent for optdesc to convert language into thai--on 1st/Oct/2010 -By Sandhya
	opt1.value = code ;	
	
	document.formReturnAveNoOfItemPerRetVoucherCriteria.p_disp_locn_to.add(opt1);

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

  formReturnAveNoOfItemPerRetVoucherCriteria.p_locn_code.value = '';
  //formPhDrugandMedicalsupplyAvePerReturnVoucherCriteriafrm.locn_text.value = '';
  formReturnAveNoOfItemPerRetVoucherCriteria.locn_text.value = '';
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
function selectbilling_drug(obj,calledby)
{
	//alert("inside selectbilling_drug==");
	var argumentArray  = new Array() ;
	var dataNameArray  = new Array() ;
	var dataValueArray = new Array() ;
	var dataTypeArray  = new Array() ; 	
 	
 	argumentArray[0] ="SELECT blng_grp_id code, short_desc description FROM bl_blng_grp_lang_vw WHERE   LANGUAGE_ID like ( ?) and UPPER(blng_grp_id) LIKE UPPER(?) AND UPPER(short_desc) LIKE UPPER(?)  order by 2";

	dataNameArray[0] ="locale";
	dataValueArray[0]= formDrugandMedicalsupplyDispensingStasticreportCriteria.p_language_id.value;
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
				formDrugandMedicalsupplyDispensingStasticreportCriteria.p_fr_privilegde.value = retVal[0];
			}
			else
				formDrugandMedicalsupplyDispensingStasticreportCriteria.p_to_privilegde.value = retVal[0];
		}else{
			obj.value ="";			
		}		
		
}

function callLocationLookup2(locn_txt) {

//alert("inside Location2");
	var argumentArray	= new Array() ;
	var dataNameArray	= new Array() ;
	var dataValueArray	= new Array() ;
	var dataTypeArray	= new Array() ;

	
	dataNameArray[1]	= "FACILITY_ID" ;
	dataValueArray[1]	= formDrugandMedicalsupplyDispensingStasticreportCriteria.p_facility_id.value;
	dataTypeArray[1]	= STRING ;
	dataNameArray[2]	= "FACILITY_ID" ;
	dataValueArray[2]	= formDrugandMedicalsupplyDispensingStasticreportCriteria.p_facility_id.value;
	dataTypeArray[2]	= STRING ;
    	
	argumentArray[1] = dataNameArray ;
	argumentArray[2] = dataValueArray ;
	argumentArray[3] = dataTypeArray ;
	argumentArray[4] = "4,5";
	argumentArray[5] = locn_txt.value;
	argumentArray[6] = DESC_LINK ;
	argumentArray[7] = DESC_CODE ;


	if (formDrugandMedicalsupplyDispensingStasticreportCriteria.p_locn_type.value == "N")
	{  
		//Search for Nursing Unit	
		argumentArray[0]   = escape(document.getElementById("sql_ph_nursing_unit_select").value)+ "'"+formDrugandMedicalsupplyDispensingStasticreportCriteria.p_language_id.value+"' "+ " AND APPL_USER_ID =  '"+formDrugandMedicalsupplyDispensingStasticreportCriteria.p_user_name.value+"' order by 2";	
		retVal=CommonLookup(getLabel("Common.nursingUnit.label","Common"), argumentArray );	
		if(retVal != null && retVal != "") {		
			formDrugandMedicalsupplyDispensingStasticreportCriteria.p_locn_code.value=retVal[0];
			locn_txt.value = retVal[1];	
		}
		else{
			formDrugandMedicalsupplyDispensingStasticreportCriteria.p_locn_code.value='';
			locn_txt.value = '';	
		}
	}
	else if (formDrugandMedicalsupplyDispensingStasticreportCriteria.p_locn_type.value=="C")
	{
		//Search for Clinic 	
		argumentArray[0]   = escape(document.getElementById("sql_ph_clinic_select").value)+" '"+formDrugandMedicalsupplyDispensingStasticreportCriteria.p_language_id.value+"' "+ " AND b.APPL_USER_ID = '"+formDrugandMedicalsupplyDispensingStasticreportCriteria.p_user_name.value+"' order by 2";	
		retVal=CommonLookup(getLabel("Common.clinic.label","Common"), argumentArray );

		if(retVal != null && retVal != "") {
			formDrugandMedicalsupplyDispensingStasticreportCriteria.p_locn_code.value=retVal[0];
			locn_txt.value = retVal[1];	
		}
	}
	else{
	alert(getMessage("PH_LOCATION_TYPE_CANNOT_BE_BLANK","PH"));//PH_LOCATION_TYPE_CANNOT_BE_BLANK
	}

}
function clearLocation2(){

  formDrugandMedicalsupplyDispensingStasticreportCriteria.p_locn_code.value = '';
  //formPhDrugandMedicalsupplyAvePerReturnVoucherCriteriafrm.locn_text.value = '';
  formDrugandMedicalsupplyDispensingStasticreportCriteria.locn_text.value = '';
}

