
function run() {

	var frmObject = f_query_add_mod.document.AdmixtureDrugdispStatisticReportCriteriaForm;
	
	if(f_query_add_mod.document.AdmixtureDrugdispStatisticReportCriteriaForm) {
    
		if (frmObject.P_FRM_MONTH.value == '' || frmObject.p_fm_year1.value == '')
		{
			alert(getMessage("PH_MONTH_YEAR_FROM_CANNOT_BLANK","PH"));			
			return false;
		}
		if (frmObject.P_TO_MONTH.value == '' || frmObject.p_to_year1.value == '')
		{
			
			alert(getMessage("PH_MONTH_YEAR_TO_CANNOT_BLANK","PH"));
			return false;
		}
		if (frmObject.p_to_year1.value < frmObject.p_fm_year1.value)
		{
			alert(getMessage("TO_DATE_EQUAL_GREATER_FROM_DATE","PH"));
			return false;
		}
		else if ( (frmObject.p_fm_year1.value == frmObject.p_to_year1.value )&& (frmObject.P_TO_MONTH.value < frmObject.P_FRM_MONTH.value) )
		{
			alert(getMessage("FROM_DATE_LESS_EQ_TO_DT","PH"));
			return false;
		}
		var fields= new Array (frmObject.p_report_type,frmObject.p_frm_time,frmObject.p_to_time,frmObject.p_disp_locn_code);
		var names= new Array (getLabel("Common.reporttype.label","Common"),getLabel("ePH.TimeHH:MM.label","PH"),getLabel("Common.to.label","Common"),getLabel("ePH.DispenseLocation.label","PH"));
		
		if(checkFields(fields,names,messageFrame)){	
			if (frmObject.p_report_type.value == 'D')
			{
				frmObject.p_report_id.value = 'PHNOAMD';	
			}
			else if (frmObject.p_report_type.value == 'M'){
				frmObject.p_report_id.value = 'PHNOAMT';
			}
			else{
				frmObject.p_report_id.value = '';
			}
			frmObject.p_disp_locn.value = frmObject.p_disp_locn_code.value;
			/*===============================================================================================================*/
			var p_fm_year_temp1 = "01/01/"+frmObject.p_fm_year1.value;
			var p_to_year_temp1 = "01/01/"+frmObject.p_to_year1.value;
			var p_fm_year_temp2 = convertDate(p_fm_year_temp1,'DMY',frmObject.p_language_id.value,"en");
			var p_to_year_temp2 = convertDate(p_to_year_temp1,'DMY',frmObject.p_language_id.value,"en");		
			var fm_vals = p_fm_year_temp2.split("/");
			var to_vals =  p_to_year_temp2.split("/"); 
			frmObject.p_frm_year.value = fm_vals[2];
			frmObject.p_to_year.value =  to_vals[2];
			
/*===============================================================================================================*/
			f_query_add_mod.document.AdmixtureDrugdispStatisticReportCriteriaForm.submit();
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

function populateDispLocs()
{
	var formObj =document.AdmixtureDrugdispStatisticReportCriteriaForm;
	var facility_id = formObj.p_facility_id.value;
	//var disp_locn_type = formObj.p_disp_locn_type.value;
	var language_id = formObj.p_language_id.value;	
	var bean_id		= "SRRPHDrugUsageByPractBean" ; 
	var bean_name	= "ePH.SRRPHDrugUsageByPractBean" ;
	var xmlDoc="";
	var xmlHttp = new XMLHttpRequest();

	xmlStr	="<root><SEARCH " ;
	xmlStr +=" /></root>" ;
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open( "POST", "SRRPhRepDlyDispSummValidate.jsp?bean_id="+bean_id+"&bean_name="+bean_name+"&func_mode=populateDispLocs1"+"&facility_id="+facility_id+"&locale="+language_id, false ) ;
	xmlHttp.send( xmlDoc ) ;
	//alert(xmlHttp.responseText);
	eval(xmlHttp.responseText);

}
function clearList(){
	
	var disp_loc_len =document.AdmixtureDrugdispStatisticReportCriteriaForm.p_disp_locn_code.options.length;
	//alert("disp_loc_len====>" +disp_loc_len);
	for(var i=0;i<disp_loc_len;i++) {
		AdmixtureDrugdispStatisticReportCriteriaForm.p_disp_locn_code.remove("p_disp_locn_code") ;
	}
}

function addOption(code,desc){

	var opt = document.createElement("OPTION") ;
	if(desc == "A")
		desc = "------"+getLabel("Common.defaultSelect.label","Common")+"-----";
	opt.text = decodeURIComponent(desc,"UTF-8") ; //Added decodeURIComponent on 1/Oct/2010 ==By Sandhya
	opt.value = code ;	
	document.AdmixtureDrugdispStatisticReportCriteriaForm.p_disp_locn_code.add(opt);

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
	
	var formObj =document.frames.AdmixtureDrugdispStatisticReportCriteriaForm
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
