
function run() {

	var frmObject = f_query_add_mod.document.AveWaitingTimeforIPDispensingCriteriaform;
	//alert("Report is Under Process");
	if(f_query_add_mod.document.AveWaitingTimeforIPDispensingCriteriaform) {
		var fields= new Array (frmObject.p_frm_date,frmObject.p_to_date,frmObject.p_frm_time,frmObject.p_to_time,frmObject.p_frm_disp_locn,frmObject.p_to_disp_locn,frmObject.p_interval_opt);
		var names= new Array (getLabel("Common.date.label","Common"),getLabel("Common.todate.label","Common"),getLabel("Common.from.label","Common")+" "+getLabel("ePH.TimeHH:MM.label","PH"),getLabel("Common.to.label","Common")+" "+getLabel("ePH.TimeHH:MM.label","PH"),getLabel("ePH.DispenseLocation.label","PH"),getLabel("Common.to.label","Common"),getLabel("ePH.IntervalOption.label","PH"));
		if(checkFields(fields,names,messageFrame)){	
			
			f_query_add_mod.document.AveWaitingTimeforIPDispensingCriteriaform.submit();
		}


	}
	
}

function reset() {
		f_query_add_mod.location.reload();
		messageFrame.document.location.href='../../eCommon/jsp/error.jsp';
}


function populateDispLocs()
{
	var formObj =document.AveWaitingTimeforIPDispensingCriteriaform;
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
	
	var disp_loc_len =document.AveWaitingTimeforIPDispensingCriteriaform.p_frm_disp_locn.options.length;
	for(var i=0;i<disp_loc_len;i++) {
		AveWaitingTimeforIPDispensingCriteriaform.p_frm_disp_locn.remove("p_frm_disp_locn") ;
		AveWaitingTimeforIPDispensingCriteriaform.p_to_disp_locn.remove("p_to_disp_locn") ;
	}
	
}

function addOption(code,desc){
	if(desc!="")
	  desc = decodeURIComponent(desc,"UTF-8"); //Passesd UTF_8 for desc regarding incident num:25042==By Sandhya
	var opt = document.createElement("OPTION") ;
	if(desc == "A")
		desc = "------"+getLabel("Common.defaultSelect.label","Common")+"------------";
	opt.text = desc ;
	opt.value = code ;	
	document.AveWaitingTimeforIPDispensingCriteriaform.p_frm_disp_locn.add(opt);

	var opt1 = document.createElement("OPTION") ;
	if(desc == "A")
		desc = "------"+getLabel("Common.defaultSelect.label","Common")+"------------";
	opt1.text = desc ;
	opt1.value = code ;	
	
	document.AveWaitingTimeforIPDispensingCriteriaform.p_to_disp_locn.add(opt1);

}

function callLocationLookup(locn_txt) {
	

	var argumentArray	= new Array() ;
	var dataNameArray	= new Array() ;
	var dataValueArray	= new Array() ;
	var dataTypeArray	= new Array() ;
	var formobj=document.AveWaitingTimeforIPDispensingCriteriaform
		if (document.AveWaitingTimeforIPDispensingCriteriaform)      //Condition for geting Locatyion values in the report Drug and Medical supply StasticReport
		{	
			formobj=document.AveWaitingTimeforIPDispensingCriteriaform
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
			formobj.p_locn.value=retVal[0];
			locn_txt.value = retVal[1];	
		}
		else{
			formobj.p_locn.value='';
			locn_txt.value = '';	
		}
	}
	else if (formobj.p_locn_type.value=="C")
	{
		//Search for Clinic 	
		argumentArray[0]   = escape(document.getElementById("sql_ph_clinic_select").value)+" '"+formobj.p_language_id.value+"' "+ " AND b.APPL_USER_ID = '"+formobj.p_user_name.value+"' order by 2";	
		retVal=CommonLookup(getLabel("Common.clinic.label","Common"), argumentArray );

		if(retVal != null && retVal != "") {
			formobj.p_locn.value=retVal[0];
			locn_txt.value = retVal[1];	
		}
		/*else{
			formobj.p_locn.value='';
			locn_txt.value = '';	
		}*/
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
 	var formobj=document.AveWaitingTimeforIPDispensingCriteriaform;
	
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
				formobj.p_frm_bill_grp.value = retVal[0];
			}
			else
				formobj.p_to_bill_grp.value = retVal[0];
		}else{
			obj.value ="";			
		}		
		
}


function allowPositiveNumber() { //alert()
   var key = window.event.keyCode;// allows only numbers to be entered
   if( ! ( ( key>=48 ) && ( key<=58 ) ) ) {
       return false;
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
	
		
		AveWaitingTimeforIPDispensingCriteriaform.p_locn.value = '';
		AveWaitingTimeforIPDispensingCriteriaform.locn_text.value = '';
	
	

  
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


function disable()
{
		
		if(AveWaitingTimeforIPDispensingCriteriaform.p_report_type.value == 'V')
		 {	
			
			AveWaitingTimeforIPDispensingCriteriaform.p_frm_seqno.disabled = true;
			AveWaitingTimeforIPDispensingCriteriaform.p_to_seqno.disabled = true;
			AveWaitingTimeforIPDispensingCriteriaform.p_warantee_time.disabled = true;

		}
		else
		{
			AveWaitingTimeforIPDispensingCriteriaform.p_frm_seqno.disabled = false;
			AveWaitingTimeforIPDispensingCriteriaform.p_to_seqno.disabled = false;
			AveWaitingTimeforIPDispensingCriteriaform.p_warantee_time.disabled = false;
		}
}

