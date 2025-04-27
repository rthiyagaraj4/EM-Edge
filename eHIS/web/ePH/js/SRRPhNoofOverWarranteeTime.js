
function run() {
	
	var frmObject = f_query_add_mod.document.FormNoOfWarranteeTimeCriteria;
	if(f_query_add_mod.document.FormNoOfWarranteeTimeCriteria) {
    
		if (frmObject.p_month.value == '' || frmObject.p_year.value == '')
		{
			alert(getMessage("PH_MONTH_YEAR_CANNOT_BLANK","PH"));			
			return false;
		}
		
		var fields= new Array (frmObject.p_wr_time,frmObject.p_disp_locn);
		var names= new Array (getLabel("ePH.WarranteeTimeHH:MM.label","PH"),getLabel("ePH.DispenseLocation.label","PH"));
		
		if(checkFields(fields,names,messageFrame)){	
			
			f_query_add_mod.document.FormNoOfWarranteeTimeCriteria.submit();
		}
		
	}
	
}

function reset() {
		f_query_add_mod.location.reload();
		messageFrame.document.location.href='../../eCommon/jsp/error.jsp';
}





function callLocationLookup(locn_txt,locn_code) {
	

	var argumentArray	= new Array() ;
	var dataNameArray	= new Array() ;
	var dataValueArray	= new Array() ;
	var dataTypeArray	= new Array() ;

	if (FormNoOfWarranteeTimeCriteria.p_locn_type.value == "N")
	{  
		//Search for Nursing Unit	
		dataNameArray[1]	= "FACILITY_ID" ;
		dataValueArray[1]	= FormNoOfWarranteeTimeCriteria.p_facility_id.value;
		dataTypeArray[1]	= STRING ;
		dataNameArray[2]	= "FACILITY_ID" ;
		dataValueArray[2]	= FormNoOfWarranteeTimeCriteria.p_facility_id.value;
		dataTypeArray[2]	= STRING ;
			
		argumentArray[1] = dataNameArray ;
		argumentArray[2] = dataValueArray ;
		argumentArray[3] = dataTypeArray ;
		argumentArray[4] = "4,5";
		argumentArray[5] = locn_txt.value;
		argumentArray[6] = DESC_LINK ;
		argumentArray[7] = DESC_CODE ;
		
		argumentArray[0]   = escape(document.getElementById("sql_ph_nursing_unit_select").value)+ "'"+FormNoOfWarranteeTimeCriteria.p_language_id.value+"' "+ " AND APPL_USER_ID =  '"+FormNoOfWarranteeTimeCriteria.p_user_name.value+"' order by 2";	
		retVal=CommonLookup(getLabel("Common.nursingUnit.label","Common"), argumentArray );	
	
		if(retVal != null && retVal != "") {		
			locn_code.value=retVal[0];
			locn_txt.value = retVal[1];	
		}
		else{
			locn_code.value='';
			locn_txt.value = '';	
		}
	}
	else if (FormNoOfWarranteeTimeCriteria.p_locn_type.value=="L")
	{
		//Search for Clinic 	
		/*argumentArray[0]   = escape(document.getElementById("sql_ph_clinic_select").value)+" '"+FormNoOfWarranteeTimeCriteria.p_language_id.value+"' "+ " AND b.APPL_USER_ID = '"+FormNoOfWarranteeTimeCriteria.p_user_name.value+"' order by 2";	
		retVal=CommonLookup(getLabel("Common.clinic.label","Common"), argumentArray );*/
           FormNoOfWarranteeTimeCriteria.locn_text_from.disabled=true;
		    FormNoOfWarranteeTimeCriteria.locn_text_to.disabled=true;


			dataNameArray[0]	= "OPERATING_FACILITY_ID" ;
			dataValueArray[0]	= FormNoOfWarranteeTimeCriteria.p_facility_id.value;
			dataTypeArray[0]	= STRING ;
				
			argumentArray[1] = dataNameArray ;
			argumentArray[2] = dataValueArray ;
			argumentArray[3] = dataTypeArray ;
			argumentArray[4] = "2,3";
			argumentArray[5] = locn_txt.value;
			argumentArray[6] = DESC_LINK ;
			argumentArray[7] = DESC_CODE ;

        argumentArray[0]= "SELECT DISTINCT c.BLDNG_CODE code,C.SHORT_DESC description FROM  AM_BLDNG_LANG_VW C WHERE OPERATING_FACILITY_ID like (?) and upper(c.BLDNG_CODE)  LIKE upper(?) AND upper(C.SHORT_DESC )LIKE upper(?) AND c.EFF_STATUS='E' and c.language_id='"+FormNoOfWarranteeTimeCriteria.p_language_id.value+"'" ;

		retVal=CommonLookup(getLabel("Common.PhysicalLocation.label","Common"), argumentArray );


		if(retVal != null && retVal != "") {
			locn_code.value=retVal[0]; //Corrected locn_code as locn_code.value forreport issue on 28/sept/2010----By Sandhya
			locn_txt.value = retVal[1];	
			
		}
	}
	else{
	alert(getMessage("PH_LOCATION_TYPE_CANNOT_BE_BLANK","PH"));//PH_LOCATION_TYPE_CANNOT_BE_BLANK
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

function allowPositiveNumber() { 

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

function clearLocation(obj){
if(	obj.value =='L'){
	FormNoOfWarranteeTimeCriteria.locn_text_from.value ="";
	FormNoOfWarranteeTimeCriteria.locn_text_to.value ="";

	FormNoOfWarranteeTimeCriteria.locn_text_from.disabled =true;
	FormNoOfWarranteeTimeCriteria.locn_text_to.disabled =true;
	FormNoOfWarranteeTimeCriteria.locn_text_from_btn.disabled =true;
	FormNoOfWarranteeTimeCriteria.locn_text_to_btn.disabled =true;

	FormNoOfWarranteeTimeCriteria.phy_locn_text_from.disabled =false;
	FormNoOfWarranteeTimeCriteria.phy_locn_text_to.disabled =false;
	FormNoOfWarranteeTimeCriteria.phy_locn_text_from_btn.disabled =false;
	FormNoOfWarranteeTimeCriteria.phy_locn_text_to_btn.disabled =false;

}else if(	obj.value =='N'){
	FormNoOfWarranteeTimeCriteria.phy_locn_text_from.value ="";
	FormNoOfWarranteeTimeCriteria.phy_locn_text_to.value ="";

	FormNoOfWarranteeTimeCriteria.phy_locn_text_from.disabled =true;
	FormNoOfWarranteeTimeCriteria.phy_locn_text_to.disabled =true;
	FormNoOfWarranteeTimeCriteria.phy_locn_text_from_btn.disabled =true;
	FormNoOfWarranteeTimeCriteria.phy_locn_text_to_btn.disabled =true;

	FormNoOfWarranteeTimeCriteria.locn_text_from.disabled =false;
	FormNoOfWarranteeTimeCriteria.locn_text_to.disabled =false;
	FormNoOfWarranteeTimeCriteria.locn_text_from_btn.disabled =false;
	FormNoOfWarranteeTimeCriteria.locn_text_to_btn.disabled =false;

}else{

    FormNoOfWarranteeTimeCriteria.phy_locn_text_from.value ="";
	FormNoOfWarranteeTimeCriteria.phy_locn_text_to.value ="";
	FormNoOfWarranteeTimeCriteria.locn_text_from.value ="";
	FormNoOfWarranteeTimeCriteria.locn_text_to.value ="";
	FormNoOfWarranteeTimeCriteria.phy_locn_text_from.disabled =false;
	FormNoOfWarranteeTimeCriteria.phy_locn_text_to.disabled =false;
	FormNoOfWarranteeTimeCriteria.phy_locn_text_from_btn.disabled =false;
	FormNoOfWarranteeTimeCriteria.phy_locn_text_to_btn.disabled =false;
	FormNoOfWarranteeTimeCriteria.locn_text_from.disabled =false;
	FormNoOfWarranteeTimeCriteria.locn_text_to.disabled =false;
	FormNoOfWarranteeTimeCriteria.locn_text_from_btn.disabled =false;
	FormNoOfWarranteeTimeCriteria.locn_text_to_btn.disabled =false;
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


function clearHiddenvalues(obj1,obj2){
	
	if(obj1.value=='')
		obj2.value="";

	
}


