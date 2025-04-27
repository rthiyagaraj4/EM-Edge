  //saved on 16/2/2010
function run() {

	var frmObject = f_query_add_mod.document.formDispVsReturnCPCVByATC;
	if(f_query_add_mod.document.formDispVsReturnCPCVByATC) {
    //assiging values to the hidden values of report parameters
		
			var fields= new Array (frmObject.dt_from,frmObject.dt_to,frmObject.p_time_from,frmObject.p_time_to);
			var names= new Array (getLabel("Common.DateFrom.label","Common"),getLabel("Common.todate.label","Common"),getLabel("Common.fromtime.label","Common"),getLabel("Common.totime.label","Common"));
			if(checkFields(fields,names,messageFrame)){	
				if( f_query_add_mod.doDateCheck( f_query_add_mod.document.formDispVsReturnCPCVByATC.dt_from, f_query_add_mod.document.formDispVsReturnCPCVByATC.dt_to, messageFrame ) ) {
					frmObject.p_disp_date_from.value = frmObject.dt_from.value;
					frmObject.p_disp_date_to.value = frmObject.dt_to.value;
					frmObject.p_disp_time_from.value = frmObject.p_time_from.value;
					frmObject.p_disp_time_to.value = frmObject.p_time_to.value;
					frmObject.p_disp_type.value = frmObject.p_disp_locn_type.value;
					frmObject.p_disp_loc_from.value = frmObject.p_disp_locn.value;
					frmObject.p_disp_loc_to.value = frmObject.p_disp_locn_to.value;
					frmObject.p_report_ids.value = frmObject.p_atc_level.value;
					frmObject.p_to_atc_class_lev.value = frmObject.p_atc_to.value;
					frmObject.p_fm_atc_class_lev.value = frmObject.p_atc_from.value;
					f_query_add_mod.document.formDispVsReturnCPCVByATC.submit();
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




function selectbilling(obj,calledby)
{
	
	var argumentArray  = new Array() ;
	var dataNameArray  = new Array() ;
	var dataValueArray = new Array() ;
	var dataTypeArray  = new Array() ; 	
 	
 	argumentArray[0] ="SELECT blng_grp_id code, short_desc description FROM bl_blng_grp_lang_vw WHERE   LANGUAGE_ID like ( ?) and UPPER(blng_grp_id) LIKE UPPER(?) AND UPPER(short_desc) LIKE UPPER(?)  order by 2";

	dataNameArray[0] ="locale";
	dataValueArray[0]= formDispVsReturnCPCVByATC.p_language_id.value;
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
				formDispVsReturnCPCVByATC.p_privilege_fm.value = retVal[0];
			}
			else
				formDispVsReturnCPCVByATC.p_privilege_to.value = retVal[0];
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
	
	var formObj =document.frames.formDispVsReturnCPCVByATC
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
	var formObj =document.formDispVsReturnCPCVByATC;
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
	
	var disp_loc_len =document.formDispVsReturnCPCVByATC.p_disp_locn.options.length;
	for(var i=0;i<disp_loc_len;i++) {
		formDispVsReturnCPCVByATC.p_disp_locn.remove("p_disp_locn") ;
		formDispVsReturnCPCVByATC.p_disp_locn_to.remove("p_disp_locn_to") ;
	}
	
}

function addOption(code,desc){

	var opt = document.createElement("OPTION") ;
	if(desc == "A")
		desc = "------"+getLabel("Common.defaultSelect.label","Common")+"-----";
	//opt.text = desc ;
	opt.text = decodeURIComponent(desc,"UTF-8") ; //ADDED DecodeUriComponent for optdesc to convert language into thai for the incident num:24677,24665 on 30/Oct/2010===By Sandhya
	opt.value = code ;	
	document.formDispVsReturnCPCVByATC.p_disp_locn.add(opt);

	var opt1 = document.createElement("OPTION") ;
	if(desc == "A")
		desc = "------"+getLabel("Common.defaultSelect.label","Common")+"-----";
	opt1.text = desc ;
	opt1.text = decodeURIComponent(desc,"UTF-8") ; //ADDED DecodeUriComponent for optdesc to convert language into thai for the incident num:24677,24665 on 30/Oct/2010===By Sandhya
	opt1.value = code ;	
	
	document.formDispVsReturnCPCVByATC.p_disp_locn_to.add(opt1);

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

  formDispVsReturnCPCVByATC.p_locn_code.value = '';
  formDispVsReturnCPCVByATC.locn_text.value = '';
}




function callATC(Obj){
	if(document.formDispVsReturnCPCVByATC.p_atc_level.value!="ALL"){
		document.formDispVsReturnCPCVByATC.narrationFrom.disabled=false;
		document.formDispVsReturnCPCVByATC.narrationTo.disabled=false;
		document.formDispVsReturnCPCVByATC.p_atc_from_id.value='';
		document.formDispVsReturnCPCVByATC.p_atc_to_id.value='';
		document.formDispVsReturnCPCVByATC.p_atc_level.disabled=false;

	}else{
		document.formDispVsReturnCPCVByATC.p_atc_from.value='';
		document.formDispVsReturnCPCVByATC.p_atc_from_id.value='';
		document.formDispVsReturnCPCVByATC.narrationFrom.disabled=true;
		document.formDispVsReturnCPCVByATC.p_atc_to.value='';
		document.formDispVsReturnCPCVByATC.p_atc_to_id.value='';
		document.formDispVsReturnCPCVByATC.narrationTo.disabled=true;
		document.formDispVsReturnCPCVByATC.p_atc_level.value="ALL";
		document.formDispVsReturnCPCVByATC.p_atc_level.selectedIndex=0;
		//document.formPhDrugUsageByPractCriteria.p_atc_level.disabled=true;
	}
}


function search1(target ,mode) {
	
	
	var frmObj= document.formDispVsReturnCPCVByATC;
	//alert("frmObj=====>" +frmObj.name)
	
	var lan_id=frmObj.p_language_id.value;
	//alert("lan_id=====>" +lan_id);
	if(mode == "1"){
	
		frmObj.p_atc_from_id.value='';
		frmObj.p_atc_from.value='';
	}
	if(mode == "2"){
		var frmObj= document.formDispVsReturnCPCVByATC;
		frmObj.p_atc_to_id.value='';
		frmObj.p_atc_to.value='';
		
	}	
		var searchFor = frmObj.p_atc_level.value;
	
		var argumentArray	= new Array() ;
		var dataNameArray	= new Array() ;
		var dataValueArray	= new Array() ;
		var dataTypeArray	= new Array() ;
		var retArray 		= new Array() ;


		if (searchFor == "") {
			alert(getLabel("ePH.ATCLevelmustbeselected.label","PH"));
			return false;
					
		}else if (searchFor == "ATCS1") {
			//var lan_id=f_query_add_mod.document.formPhDrugUsageByPractCriteria.Language_id.value;
			argumentArray[0] = document.getElementById("sql_ph_reports_atc1_lookup").value+"'"+lan_id+"'";
					
		}else if (searchFor == "ATCS2") {
			//var lan_id=f_query_add_mod.document.formPhDrugUsageByPractCriteria.Language_id.value;
			argumentArray[0] = document.getElementById("sql_ph_reports_atc2_lookup").value+"'"+lan_id+"'";
		}else if (searchFor == "ATCS3") {
		//	var lan_id=f_query_add_mod.document.formPhDrugUsageByPractCriteria.Language_id.value;
			argumentArray[0] = document.getElementById("sql_ph_reports_atc3_lookup").value+"'"+lan_id+"'";
		}else if (searchFor == "ATCS4") {
		//	var lan_id=f_query_add_mod.document.formPhDrugUsageByPractCriteria.Language_id.value;
			argumentArray[0] = document.getElementById("sql_ph_reports_atc4_lookup").value+"'"+lan_id+"'";
		}else if (searchFor == "ATCS5") {
		//	var lan_id=f_query_add_mod.document.formPhDrugUsageByPractCriteria.Language_id.value;
			argumentArray[0] = document.getElementById("sql_ph_reports_atc5_lookup").value+"'"+lan_id+"'";
		}
		
		argumentArray[1] = dataNameArray ;
		argumentArray[2] = dataValueArray ;
		argumentArray[3] = dataTypeArray ;
		argumentArray[4] = "1,2";
		argumentArray[5] = target.value;
		argumentArray[6] = CODE_LINK ;//CODE_LINK
		argumentArray[7] = CODE_DESC ;//CODE_DESC

		retArray = CommonLookup( searchFor, argumentArray );
		
			
		if(retArray != null && retArray != "" ) {
			target.value = retArray[1];	
			if(target.name=="p_atc_from_id"){
					frmObj.p_atc_from.value=retArray[0];
				}
			else if(target.name=="p_atc_to_id"){
				frmObj.p_atc_to.value=retArray[0];	
					}
			target.focus();
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

function callLocationLookup(locn_txt) {

	var argumentArray	= new Array() ;
	var dataNameArray	= new Array() ;
	var dataValueArray	= new Array() ;
	var dataTypeArray	= new Array() ;

	
	dataNameArray[1]	= "FACILITY_ID" ;
	dataValueArray[1]	= formDispVsReturnCPCVByATC.p_facility_id.value;
	dataTypeArray[1]	= STRING ;
	dataNameArray[2]	= "FACILITY_ID" ;
	dataValueArray[2]	= formDispVsReturnCPCVByATC.p_facility_id.value;
	dataTypeArray[2]	= STRING ;
    	
	argumentArray[1] = dataNameArray ;
	argumentArray[2] = dataValueArray ;
	argumentArray[3] = dataTypeArray ;
	argumentArray[4] = "4,5";
	argumentArray[5] = locn_txt.value;
	argumentArray[6] = DESC_LINK ;
	argumentArray[7] = DESC_CODE ;


	if (document.formDispVsReturnCPCVByATC.p_locn_type.value == "N")
	{  
		//Search for Nursing Unit	
		argumentArray[0]   = escape(document.getElementById("sql_ph_nursing_unit_select").value)+ "'"+formDispVsReturnCPCVByATC.p_language_id.value+"' "+ " AND APPL_USER_ID =  '"+formDispVsReturnCPCVByATC.p_user_name.value+"' order by 2";	
		retVal=CommonLookup(getLabel("Common.nursingUnit.label","Common"), argumentArray );	
		if(retVal != null && retVal != "") {		
			formDispVsReturnCPCVByATC.p_locn_code.value=retVal[0];
			locn_txt.value = retVal[1];	
		}
		else{
			formDispVsReturnCPCVByATC.p_locn_code.value='';
			locn_txt.value = '';	
		}
	}
	else if (document.formDispVsReturnCPCVByATC.p_locn_type.value=="C")
	{
	
		argumentArray[0]   = escape(document.getElementById("sql_ph_clinic_select").value)+" '"+formDispVsReturnCPCVByATC.p_language_id.value+"' "+ " AND b.APPL_USER_ID = '"+formDispVsReturnCPCVByATC.p_user_name.value+"' order by 2";	
		retVal=CommonLookup(getLabel("Common.clinic.label","Common"), argumentArray );

		if(retVal != null && retVal != "") {
			formDispVsReturnCPCVByATC.p_locn_code.value=retVal[0];
			locn_txt.value = retVal[1];	
		}
	}
	else{
	alert(getMessage("PH_LOCATION_TYPE_CANNOT_BE_BLANK","PH"));//PH_LOCATION_TYPE_CANNOT_BE_BLANK
	}

}
