  
function run() {

	
	if(f_query_add_mod.document.formDispAvgPerPres) {   
		var frmObject = f_query_add_mod.document.formDispAvgPerPres;
 //assiging values to the hidden values of report parameters
		var fields= new Array (frmObject.dt_from,frmObject.dt_to,frmObject.p_disp_time_from,frmObject.p_disp_time_to);
		var names= new Array (getLabel("Common.date.label","Common"),getLabel("Common.todate.label","Common"),getLabel("Common.from.label","Common")+" "+getLabel("ePH.TimeHH:MM.label","PH"),getLabel("Common.to.label","Common")+" "+getLabel("ePH.TimeHH:MM.label","PH"));
		if(checkFields(fields,names,messageFrame)){			
		if( f_query_add_mod.doDateCheck( f_query_add_mod.document.formDispAvgPerPres.dt_from, f_query_add_mod.document.formDispAvgPerPres.dt_to, messageFrame ) ) {
				
				var locale = frmObject.p_language_id.value;
				//alert("locale=======>" +locale);
				var p_disp_date_from1=convertDate(f_query_add_mod.document.formDispAvgPerPres.dt_from.value,"DMY",locale,"en"); //Added Variables for the incident num: on 30/12/2010==By Sandhya
				var p_disp_date_to1=convertDate(f_query_add_mod.document.formDispAvgPerPres.dt_to.value,"DMY",locale,"en");
				
				//alert("p_disp_date_from1=======>" +p_disp_date_from1);
				//alert("p_disp_date_to1=======>" +p_disp_date_to1);
				frmObject.p_disp_date_from.value = p_disp_date_from1

				frmObject.p_disp_date_to.value = p_disp_date_to1
				frmObject.p_disp_loc_code.value = frmObject.p_disp_locn.value;				
				f_query_add_mod.document.formDispAvgPerPres.submit();
			}
		}		
	}
	if(f_query_add_mod.document.formDispAvgItemsPerPres) {   
		var frmObject = f_query_add_mod.document.formDispAvgItemsPerPres;
 //assiging values to the hidden values of report parameters
		var fields= new Array (frmObject.dt_from,frmObject.dt_to,frmObject.p_fr_time,frmObject.p_to_time);
		var names= new Array (getLabel("Common.date.label","Common"),getLabel("Common.todate.label","Common"),getLabel("Common.from.label","Common")+" "+getLabel("ePH.TimeHH:MM.label","PH"),getLabel("Common.to.label","Common")+" "+getLabel("ePH.TimeHH:MM.label","PH"));
		if(checkFields(fields,names,messageFrame)){			
		if( f_query_add_mod.doDateCheck( f_query_add_mod.document.formDispAvgItemsPerPres.dt_from, f_query_add_mod.document.formDispAvgItemsPerPres.dt_to, messageFrame ) ) {
				var locale = frmObject.p_language_id.value;
				var p_disp_date_from1=convertDate(f_query_add_mod.document.formDispAvgItemsPerPres.dt_from.value,"DMY",locale,"en"); //Added Variables for the incident num: on 30/12/2010==By Sandhya
				var p_disp_date_to1=convertDate(f_query_add_mod.document.formDispAvgItemsPerPres.dt_to.value,"DMY",locale,"en");
				frmObject.p_fr_dt.value = p_disp_date_from1;
				frmObject.p_to_dt.value = p_disp_date_to1;
				frmObject.p_fr_disp_locn.value = frmObject.p_disp_locn.value;
				frmObject.p_to_disp_locn.value = frmObject.p_disp_locn1.value;
				frmObject.p_location.value = frmObject.p_locn_code.value;
				frmObject.p_fr_priv.value = frmObject.p_privilege_fm.value;
				frmObject.p_to_priv.value = frmObject.p_privilege_to.value;
				f_query_add_mod.document.formDispAvgItemsPerPres.submit();
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
	var locn_type		=	'';
	var language_id		=	'';
	var user_name		=	'';	
	if (document.formDispAvgItemsPerPres)
	{
	dataNameArray[1]	= "FACILITY_ID" ;
	dataValueArray[1]	= formDispAvgItemsPerPres.p_facility_id.value;
	dataTypeArray[1]	= STRING ;
	dataNameArray[2]	= "FACILITY_ID" ;
	dataValueArray[2]	= formDispAvgItemsPerPres.p_facility_id.value;
	dataTypeArray[2]	= STRING ;
    	
	argumentArray[1] = dataNameArray ;
	argumentArray[2] = dataValueArray ;
	argumentArray[3] = dataTypeArray ;
	argumentArray[4] = "4,5";
	argumentArray[5] = locn_txt.value;
	argumentArray[6] = DESC_LINK ;
	argumentArray[7] = DESC_CODE ;
	locn_type		 = formDispAvgItemsPerPres.p_locn_type.value;
	language_id		 = formDispAvgItemsPerPres.p_language_id.value;
	user_name		 = formDispAvgItemsPerPres.p_user_name.value;
	
	}
	else{
	dataNameArray[1]	= "FACILITY_ID" ;
	dataValueArray[1]	= formDispAvgPerPres.p_facility_id.value;
	dataTypeArray[1]	= STRING ;
	dataNameArray[2]	= "FACILITY_ID" ;
	dataValueArray[2]	= formDispAvgPerPres.p_facility_id.value;
	dataTypeArray[2]	= STRING ;
    	
	argumentArray[1] = dataNameArray ;
	argumentArray[2] = dataValueArray ;
	argumentArray[3] = dataTypeArray ;
	argumentArray[4] = "4,5";
	argumentArray[5] = locn_txt.value;
	argumentArray[6] = DESC_LINK ;
	argumentArray[7] = DESC_CODE ;
	locn_type		 = formDispAvgPerPres.p_locn_type.value;
	language_id		 =  formDispAvgPerPres.p_language_id.value;
	user_name		 =  formDispAvgPerPres.p_user_name.value;

	}
	
	

	if (locn_type == "N")
	{  
		//Search for Nursing Unit	
		argumentArray[0]   = escape(document.getElementById("sql_ph_nursing_unit_select").value)+ "'"+language_id+"' "+ " AND APPL_USER_ID =  '"+user_name+"' order by 2";	
		retVal=CommonLookup(getLabel("Common.nursingUnit.label","Common"), argumentArray );	
		if(retVal != null && retVal != "") {
			if (document.formDispAvgItemsPerPres)
			{
				formDispAvgItemsPerPres.p_locn_code.value=retVal[0];
			}
			else
				formDispAvgPerPres.p_locn_code.value=retVal[0];
			locn_txt.value = retVal[1];	
		}
		else{
			if (document.formDispAvgItemsPerPres)
			{
				formDispAvgItemsPerPres.p_locn_code.value='';
			}
			else
				formDispAvgPerPres.p_locn_code.value='';
			locn_txt.value = '';	
		}
	}
	else if (locn_type=="C")
	{
		//Search for Clinic 	
		argumentArray[0]   = escape(document.getElementById("sql_ph_clinic_select").value)+" '"+language_id+"' "+ " AND b.APPL_USER_ID = '"+user_name+"' order by 2";	
		retVal=CommonLookup(getLabel("Common.clinic.label","Common"), argumentArray );

		if(retVal != null && retVal != "") {
			if (document.formDispAvgItemsPerPres)
			{
				formDispAvgItemsPerPres.p_locn_code.value=retVal[0];
			}
			else
				formDispAvgPerPres.p_locn_code.value=retVal[0];
			locn_txt.value = retVal[1];	
		}
		else{
			if (document.formDispAvgItemsPerPres)
			{
				formDispAvgItemsPerPres.p_locn_code.value='';
			}
			else
				formDispAvgPerPres.p_locn_code.value='';
			locn_txt.value = '';	
		
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
	if (document.formDispAvgItemsPerPres)
	{
		dataValueArray[0]= formDispAvgItemsPerPres.p_language_id.value
	}
    else 
 		dataValueArray[0]= formDispAvgPerPres.p_language_id.value;
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
				if (document.formDispAvgItemsPerPres)
				{
					formDispAvgItemsPerPres.p_privilege_fm.value = retVal[0];
				}
				else 
					formDispAvgPerPres.p_privilege_fm.value = retVal[0];
			}
			else{
				if (document.formDispAvgItemsPerPres)
				{
					formDispAvgItemsPerPres.p_privilege_to.value = retVal[0];
				}
				else 
					formDispAvgPerPres.p_privilege_to.value = retVal[0];
			}
		}else{
			obj.value ="";	
			if (document.formDispAvgItemsPerPres)
			{
				formDispAvgItemsPerPres.p_privilege_fm.value = '';
				formDispAvgItemsPerPres.p_privilege_to.value = '';
			}
			else{
				formDispAvgPerPres.p_privilege_fm.value = '';
				formDispAvgPerPres.p_privilege_to.value = '';
			}
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
	
	var formObj =document.frames.formDispAvgPerPres
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
	var formObj =document.formDispAvgPerPres;
	if (eval("document.formDispAvgItemsPerPres") != undefined)
	{
		formObj =document.formDispAvgItemsPerPres;
	}
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
	
	if (document.formDispAvgItemsPerPres)
	{
		var disp_loc_len	=	document.formDispAvgItemsPerPres.p_disp_locn.options.length;
		var disp_loc_len1	=	document.formDispAvgItemsPerPres.p_disp_locn1.options.length;
		var obj = 'formDispAvgItemsPerPres.p_disp_locn';
		for(var i=0;i<disp_loc_len1;i++) {
			formDispAvgItemsPerPres.p_disp_locn1.remove("p_disp_locn1") ;
		}
	}
	else 
	{
		var disp_loc_len =document.formDispAvgPerPres.p_disp_locn.options.length;
		var obj = 'formDispAvgPerPres.p_disp_locn';
	}
	for(var i=0;i<disp_loc_len;i++) {
		eval(obj).remove("p_disp_locn") ;
	}
	
}

function addOption(code,desc){
	if(desc!="")
	  desc = decodeURIComponent(desc,"UTF-8");
	var opt = document.createElement("OPTION") ;
	if(desc == "A")
		desc = "------"+getLabel("Common.defaultSelect.label","Common")+"-----";
	opt.text = desc ;
	opt.value = code ;	
	if (document.formDispAvgItemsPerPres)
	{
		var listObj = "document.formDispAvgItemsPerPres.p_disp_locn";
	}
	else 
		var listObj = "document.formDispAvgPerPres.p_disp_locn";
	eval(listObj).add(opt);
	
	if (document.formDispAvgItemsPerPres)
	{
	var opt1 = document.createElement("OPTION") ;
	if(desc == "A")
		desc = "------"+getLabel("Common.defaultSelect.label","Common")+"-----";
	opt1.text = desc ;
	opt1.value = code ;	
	document.formDispAvgItemsPerPres.p_disp_locn1.add(opt1)

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
 if (document.formDispAvgItemsPerPres)
 {
	 formDispAvgItemsPerPres.p_locn_code.value = '';
	 formDispAvgItemsPerPres.locn_text.value = '';
 }
 else{
	formDispAvgPerPres.p_locn_code.value = '';
	formDispAvgPerPres.locn_text.value = '';
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

