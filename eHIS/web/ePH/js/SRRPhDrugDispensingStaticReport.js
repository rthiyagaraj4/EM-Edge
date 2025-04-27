//Date Validations......
function DateCheck(from,to) {
	
    /*var fromarray;
    var toarray;
    var fromdate = from.value ;
    var todate = to.value ;
	
    if(fromdate.length > 0 && todate.length > 0 ) {
            fromarray = fromdate.split("/");
            toarray = todate.split("/");
            var fromdt = new Date(fromarray[2],fromarray[1],fromarray[0]);
            var todt = new Date(toarray[2],toarray[1],toarray[0]);

            if(Date.parse(todt) > Date.parse(fromdt)) 
            {
                var invaldt = getMessage("START_DATE_GREATER_SYSDATE","Common") ;
                alert(invaldt);
                to.select();
                to.focus();
                    
            }
            else if(Date.parse(todt) <= Date.parse(fromdt)) return true;
    }
	*/
	if(from.value=="" || to.value=="")
	{ 
		
		return false;
	}
	else{
		if(!isBefore(to.value,from.value,"DMY",document.forms[0].p_language_id.value)) {
		
			
		var errors=getMessage("START_DATE_GREATER_SYSDATE","Common") ;
		alert(errors);
		return false;
	}
	}

    return true;
}


function validate_date(Obj,ref) {
                

	/*if (CheckDate(Obj))
	{
	 if(ref == "TO_DT_GR_EQ_FM_DT")
	{
	  from = document.forms[0].dt_to1;
	  to = document.forms[0].dt_from1;
	  
	  error_id = getMessage('PH_TO_TIME_ALERT','PH');
	 	 
	}
		else if(ref == "TO_DT_GR_EQ_FM_DT1")
	{
	  from = document.forms[0].dt_from1;
	  to = document.forms[0].dt_to1;
	 
	  error_id = getMessage('PH_TO_TIME_ALERT','PH');
	 	 
	}
	else if(ref == "TO_DATE_LESS_FROM")
	{
	  from = parent.frames[1].document.forms[0].dt_to1;
	  to = parent.frames[1].document.forms[0].dt_from1;
	 
	  error_id = getMessage('PH_TO_TIME_ALERT','PH');
	}
	
	var fromarray;
	var toarray;
	var fromdate = eval(from).value ;
	var todate = eval(to).value ;
	
	if(fromdate.length > 0 && todate.length > 0 ) {
		fromarray = fromdate.split("/");
		toarray = todate.split("/");
		var fromdt = new Date(fromarray[2],fromarray[1],fromarray[0]);
		var todt = new Date(toarray[2],toarray[1],toarray[0]);
		if(Date.parse(todt) > Date.parse(fromdt)) {		   
			//alert(error_id);
 		    from.focus();
		}
		else if(Date.parse(todt) <= Date.parse(fromdt))
		     {
	       //parent.messageFrame.document.location.href="../../eCommon/jsp/error.jsp?err_num= ";
		       return true;
		      } 
	}
	return true;
}*/
//===================================================================================================
	if(document.forms[0].dt_from1.value=='' || document.forms[0].dt_to1.value=='')
{ 
					return false;
}
	else{
		if(!isBefore(document.forms[0].dt_from1.value,document.forms[0].dt_to1.value,"DMY",document.forms[0].p_language_id.value)) {
			
				var errors=getMessage('FROM_DATE_GREATER_TO_DATE','FM'); 
			
				alert(errors);
				return false;
	}
			

}

	return true;
	//===================================================================================================
}

//Billing Lookup:
function selectbilling(obj,calledby)
{
	
	var argumentArray  = new Array() ;
	var dataNameArray  = new Array() ;
	var dataValueArray = new Array() ;
	var dataTypeArray  = new Array() ; 	
 	
 	argumentArray[0] ="SELECT blng_grp_id code, short_desc description FROM bl_blng_grp_lang_vw WHERE   LANGUAGE_ID like ( ?) and UPPER(blng_grp_id) LIKE UPPER(?) AND UPPER(short_desc) LIKE UPPER(?)  order by 2";

	dataNameArray[0] ="locale";
	dataValueArray[0]= FormDrugDispensingStasticreportCriteria.p_language_id.value;
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
				FormDrugDispensingStasticreportCriteria.p_fr_privilegde.value = retVal[0];
			}
			else
				FormDrugDispensingStasticreportCriteria.p_to_privilegde.value = retVal[0];
		}else{
			obj.value ="";			
		}		
		
}
//ATC Classification Lookup
function ATCClassificationLookup(obj,calledby)
{
	//alert("inside ATCClassificationLookup=====123");
	var argumentArray  = new Array() ;
	var dataNameArray  = new Array() ;
	var dataValueArray = new Array() ;
	var dataTypeArray  = new Array() ; 	
 	
 	
 	argumentArray[0] ="SELECT ATC_CLASS_LEV1_CODE CODE, ATC_CLASS_LEV1_DESC DESCRIPTION FROM PH_ATC_CLASS_LEV1_LANG_VW WHERE LANGUAGE_ID like (?) and UPPER(ATC_CLASS_LEV1_CODE) LIKE UPPER(?) AND UPPER(ATC_CLASS_LEV1_DESC) LIKE UPPER(?) order by 2 ";

	dataNameArray[0] ="locale";
	dataValueArray[0]= FormDrugDispensingStasticreportCriteria.p_language_id.value;
	dataTypeArray[0] = STRING;

	argumentArray[1] = dataNameArray ;
	argumentArray[2] = dataValueArray ;
	argumentArray[3] = dataTypeArray ;
	argumentArray[4] = "2,3"; 
	argumentArray[5] = obj.value;
	argumentArray[6] = DESC_LINK ;//CODE_LINK
	argumentArray[7] = DESC_CODE;//CODE_DESC
	retVal = CommonLookup(getLabel("Common.ATCClassification.label","Common"), argumentArray );
		
		if(retVal != null && retVal != "") {
		
			obj.value = retVal[1] ;	
			
			
			if (calledby =='from')
			{
				FormDrugDispensingStasticreportCriteria.p_atc_from_id.value = retVal[0];
			}
			else
				FormDrugDispensingStasticreportCriteria.p_atc_to_id.value = retVal[0];
		}else{
			obj.value ="";			
		}		
		
}
//Speciality Lookup
function selectspeciality()
{
	
	var argumentArray  = new Array() ;
	var dataNameArray  = new Array() ;
	var dataValueArray = new Array() ;
	var dataTypeArray  = new Array() ; 	
 	
 	//argumentArray[0] ="SELECT blng_grp_id code, short_desc description FROM bl_blng_grp_lang_vw WHERE   LANGUAGE_ID like ( ?) and UPPER(blng_grp_id) LIKE UPPER(?) AND UPPER(short_desc) LIKE UPPER(?)  order by 2";
 	argumentArray[0] ="SELECT SPECIALITY_CODE CODE, SHORT_DESC DESCRIPTION FROM AM_SPECIALITY_LANG_VW WHERE LANGUAGE_ID like (?) and UPPER(SPECIALITY_CODE) LIKE UPPER(?) AND UPPER(SHORT_DESC) LIKE UPPER(?) order by 2 ";

	dataNameArray[0] ="locale";
	dataValueArray[0]= FormDrugDispensingStasticreportCriteria.p_language_id.value;
	dataTypeArray[0] = STRING;

	argumentArray[1] = dataNameArray ;
	argumentArray[2] = dataValueArray ;
	argumentArray[3] = dataTypeArray ;
	argumentArray[4] = "2,3"; 
	argumentArray[5]   = FormDrugDispensingStasticreportCriteria.p_speciality_name.value ;
	argumentArray[6] = DESC_LINK ;//CODE_LINK
	argumentArray[7] = DESC_CODE;//CODE_DESC
	retVal = CommonLookup(getLabel("Common.SpecialtyCode.label","Common"), argumentArray );
		//alert("retVal===>" +retVal);
		if(retVal != null && retVal != "" )  {
		FormDrugDispensingStasticreportCriteria.p_speciality_name.value = retVal[1] ;
		FormDrugDispensingStasticreportCriteria.p_speciality_code.value = retVal[0];
		
		FormDrugDispensingStasticreportCriteria.p_speciality_name.disabled  = true;  //uncommented on9/03/2010
		FormDrugDispensingStasticreportCriteria.p_speciality_search.disabled = true;	
	}
		
}

//Drug Lookup -----
function searchDrugName(){
	
	var formObj = document.FormDrugDispensingStasticreportCriteria;
	var argumentArray  = new Array() ;
	var dataNameArray  = new Array() ;
	var dataValueArray = new Array() ;
	var dataTypeArray  = new Array() ;
	argumentArray[0]   = escape(document.getElementById("sql_ph_drug_search_select2").value)+"'"+formObj.p_language_id.value+"'";
	//alert("argumentArray[0]===>" +argumentArray[0]);
	argumentArray[1]   = dataNameArray ;
	argumentArray[2]   = dataValueArray ;
	argumentArray[3]   = dataTypeArray ;
	argumentArray[4]   = "1,2";
	
	argumentArray[5]   = formObj.p_drug_name.value ;
	argumentArray[6]   = DESC_LINK ;
	argumentArray[7]   = DESC_CODE ; 
	retVal = CommonLookup(getLabel("Common.DrugName.label","Common"), argumentArray );
//alert("retVal====>" +retVal);
	if(retVal != null && retVal != "" )  {
		formObj.p_drug_name.value = retVal[1] ;
		formObj.p_drug_code.value = retVal[0];
		
		//formObj.p_drug_name.disabled  = true;
		//formObj.p_drug_name_search.disabled = true;	
	}
}

//Location Lookup and clearing the Location type fuctions.....
function clearLocation(){

  FormDrugDispensingStasticreportCriteria.p_locn_code.value = '';
  //formPhDrugandMedicalsupplyAvePerReturnVoucherCriteriafrm.locn_text.value = '';
  FormDrugDispensingStasticreportCriteria.locn_text.value = '';
}

function callLocationLookup(locn_txt) {

	var argumentArray	= new Array() ;
	var dataNameArray	= new Array() ;
	var dataValueArray	= new Array() ;
	var dataTypeArray	= new Array() ;

	
	dataNameArray[1]	= "FACILITY_ID" ;
	dataValueArray[1]	= FormDrugDispensingStasticreportCriteria.p_facility_id.value;
	dataTypeArray[1]	= STRING ;
	dataNameArray[2]	= "FACILITY_ID" ;
	dataValueArray[2]	= FormDrugDispensingStasticreportCriteria.p_facility_id.value;
	dataTypeArray[2]	= STRING ;
    	
	argumentArray[1] = dataNameArray ;
	argumentArray[2] = dataValueArray ;
	argumentArray[3] = dataTypeArray ;
	argumentArray[4] = "4,5";
	argumentArray[5] = locn_txt.value;
	argumentArray[6] = DESC_LINK ;
	argumentArray[7] = DESC_CODE ;


	if (FormDrugDispensingStasticreportCriteria.p_locn_type.value == "N")
	{  
		//Search for Nursing Unit	
		argumentArray[0]   = escape(document.getElementById("sql_ph_nursing_unit_select").value)+ "'"+FormDrugDispensingStasticreportCriteria.p_language_id.value+"' "+ " AND APPL_USER_ID =  '"+FormDrugDispensingStasticreportCriteria.p_user_name.value+"' order by 2";	
		retVal=CommonLookup(getLabel("Common.nursingUnit.label","Common"), argumentArray );	
		if(retVal != null && retVal != "") {		
			FormDrugDispensingStasticreportCriteria.p_locn_code.value=retVal[0];
			locn_txt.value = retVal[1];	
		}
		else{
			FormDrugDispensingStasticreportCriteria.p_locn_code.value='';
			locn_txt.value = '';	
		}
	}
	else if (FormDrugDispensingStasticreportCriteria.p_locn_type.value=="C")
	{
		//Search for Clinic 	
		argumentArray[0]   = escape(document.getElementById("sql_ph_clinic_select").value)+" '"+FormDrugDispensingStasticreportCriteria.p_language_id.value+"' "+ " AND b.APPL_USER_ID = '"+FormDrugDispensingStasticreportCriteria.p_user_name.value+"' order by 2";	
		retVal=CommonLookup(getLabel("Common.clinic.label","Common"), argumentArray );

		if(retVal != null && retVal != "") {
			FormDrugDispensingStasticreportCriteria.p_locn_code.value=retVal[0];
			locn_txt.value = retVal[1];	
		}
	}
	else{
	alert(getMessage("PH_LOCATION_TYPE_CANNOT_BE_BLANK","PH"));//PH_LOCATION_TYPE_CANNOT_BE_BLANK
	}

}
//Practitioner Lookup:
function searchPractitioner() {
	

var formObj		=document.FormDrugDispensingStasticreportCriteria;

	var argumentArray	= new Array() ;
	var dataNameArray	= new Array() ;
	var dataValueArray	= new Array() ;
	var dataTypeArray	= new Array() ;

	
	var sql="SELECT A.PRACTITIONER_ID code,A.PRACTITIONER_NAME description FROM AM_PRACTITIONER_LANG_VW A WHERE upper(PRACTITIONER_ID) LIKE upper(?) AND upper(PRACTITIONER_NAME )LIKE upper(?) AND EFF_STATUS='E' and a.language_id=";
	var p_language_id=document.FormDrugDispensingStasticreportCriteria.p_language_id.value;
	argumentArray[0] =  sql+"'"+p_language_id+"' order by A.PRACTITIONER_NAME";
	argumentArray[1] = dataNameArray ;
	argumentArray[2] = dataValueArray ;
	argumentArray[3] = dataTypeArray ;
	argumentArray[4] = "1,2";
	argumentArray[5] = formObj.p_pract_name.value;
	argumentArray[6] = DESC_LINK ;
	argumentArray[7] = DESC_CODE ;

	retVal = CommonLookup(getLabel("Common.practitioner.label","Common"), argumentArray );
//	alert(argumentArray);
	if(retVal != null && retVal != "" )  {
		formObj.p_pract_name.value = retVal[1] ;
		formObj.pract_id.value = retVal[0];
		
		//formObj.p_pract_name.disabled  = true;
		//formObj.p_pract_search.disabled = true;	
	}
}

//Funcction for onchanging repot type as summary and billing
function changeTop(){
	
		if ((FormDrugDispensingStasticreportCriteria.p_report_type.value == 'SM')&&(FormDrugDispensingStasticreportCriteria.p_Report_By.value =='B'||FormDrugDispensingStasticreportCriteria.p_Report_By.value =='A'))
		{
			FormDrugDispensingStasticreportCriteria.p_top.disabled = false;
		}
		else
			{
			FormDrugDispensingStasticreportCriteria.p_top.value = '';
			FormDrugDispensingStasticreportCriteria.p_top.disabled = true;
			}
}




function disablebilling()
{
		if (FormDrugDispensingStasticreportCriteria.p_report_by.value == 'AC')
		{
			FormDrugDispensingStasticreportCriteria.billing_from.disabled = true;
			FormDrugDispensingStasticreportCriteria.billing_button.disabled = true;
			FormDrugDispensingStasticreportCriteria.billing_to.disabled = true;
			FormDrugDispensingStasticreportCriteria.billing_to_button.disabled = true;
			FormDrugDispensingStasticreportCriteria.p_atc_from.disabled = false;
			FormDrugDispensingStasticreportCriteria.p_atc_from_search.disabled = false;
			FormDrugDispensingStasticreportCriteria.p_atc_to.disabled = false;
			FormDrugDispensingStasticreportCriteria.p_atc_to_search.disabled = false;
			FormDrugDispensingStasticreportCriteria.p_fr_privilegde.value = '';
			FormDrugDispensingStasticreportCriteria.billing_from.value = '';
			FormDrugDispensingStasticreportCriteria.p_to_privilegde.value = '';
			FormDrugDispensingStasticreportCriteria.billing_to.value = '';
			FormDrugDispensingStasticreportCriteria.p_atc_from_id.value = '';
			FormDrugDispensingStasticreportCriteria.p_atc_from.value = '';
			FormDrugDispensingStasticreportCriteria.p_atc_to_id.value = '';
			FormDrugDispensingStasticreportCriteria.p_atc_to.value = '';
			
		}
		else if (FormDrugDispensingStasticreportCriteria.p_report_by.value == 'BG')
		{
			FormDrugDispensingStasticreportCriteria.p_atc_from.disabled = true;
			FormDrugDispensingStasticreportCriteria.p_atc_from_search.disabled = true;
			FormDrugDispensingStasticreportCriteria.p_atc_to.disabled = true;
			FormDrugDispensingStasticreportCriteria.p_atc_to_search.disabled = true;
			FormDrugDispensingStasticreportCriteria.billing_from.disabled = false;
			FormDrugDispensingStasticreportCriteria.billing_button.disabled = false;
			FormDrugDispensingStasticreportCriteria.billing_to.disabled = false;
			FormDrugDispensingStasticreportCriteria.billing_to_button.disabled = false;
			FormDrugDispensingStasticreportCriteria.p_atc_from_id.value = '';
			FormDrugDispensingStasticreportCriteria.p_atc_from.value = '';
			FormDrugDispensingStasticreportCriteria.p_atc_to_id.value = '';
			FormDrugDispensingStasticreportCriteria.p_atc_to.value = '';
			FormDrugDispensingStasticreportCriteria.p_fr_privilegde.value = '';
			FormDrugDispensingStasticreportCriteria.billing_from.value = '';
			FormDrugDispensingStasticreportCriteria.p_to_privilegde.value = '';
			FormDrugDispensingStasticreportCriteria.billing_to.value = '';

			
		}
		else
		{
				
				FormDrugDispensingStasticreportCriteria.billing_from.disabled = false;
				FormDrugDispensingStasticreportCriteria.billing_button.disabled = false;
				FormDrugDispensingStasticreportCriteria.billing_to.disabled = false;
				FormDrugDispensingStasticreportCriteria.billing_to_button.disabled = false;
				FormDrugDispensingStasticreportCriteria.p_atc_from.disabled = false;
				FormDrugDispensingStasticreportCriteria.p_atc_from_search.disabled = false;
				FormDrugDispensingStasticreportCriteria.p_atc_to.disabled = false;
				FormDrugDispensingStasticreportCriteria.p_atc_to_search.disabled = false;
				FormDrugDispensingStasticreportCriteria.p_fr_privilegde.value = '';
				FormDrugDispensingStasticreportCriteria.billing_from.value = '';
				FormDrugDispensingStasticreportCriteria.p_to_privilegde.value = '';
				FormDrugDispensingStasticreportCriteria.billing_to.value = '';
				FormDrugDispensingStasticreportCriteria.p_atc_from_id.value = '';
				FormDrugDispensingStasticreportCriteria.p_atc_from.value = '';
				FormDrugDispensingStasticreportCriteria.p_atc_to_id.value = '';
				FormDrugDispensingStasticreportCriteria.p_atc_to.value = '';
		}
}

//Validations for allowing numeric values in TOP text box
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

function run() {
	
	if(f_query_add_mod.document.FormDrugDispensingStasticreportCriteria) { 
		
		var frmObject = f_query_add_mod.document.FormDrugDispensingStasticreportCriteria
		
 //assiging values to the hidden values of report parameters
				frmObject.p_disp_date_from.value = frmObject.dt_from1.value;
				frmObject.p_disp_date_to.value = frmObject.dt_to1.value;	
				frmObject.p_facility_id.value = frmObject.p_facility_code.value;
				frmObject.p_privilege_fm.value = frmObject.p_fr_privilegde.value;
				frmObject.p_privilege_to.value = frmObject.p_to_privilegde.value;
				frmObject.p_fm_atc_class_lev.value = frmObject.p_atc_from.value;
				frmObject.p_to_atc_class_lev.value = frmObject.p_atc_to.value;
				//frmObject.p_primary_speciality_code.value = frmObject.p_speciality_name.value;
				frmObject.p_primary_speciality_code.value = frmObject.p_speciality_code.value;
				frmObject.p_pract_id.value = frmObject.pract_id.value;
				if (frmObject.p_report_by.value == 'BG'  && frmObject.p_report_type.value == 'D')
				{
					frmObject.p_report_id.value = 'PHDRGDSPBILLGRDTL';
					//alert("frmObject.p_report_id.value====>" +frmObject.p_report_id.value);
				}
				else if(frmObject.p_report_by.value == 'BG'  && frmObject.p_report_type.value == 'S'){
					frmObject.p_report_id.value = 'PHDRGDSPBILLGRSUMM';
					//alert("frmObject.p_report_id.value= 463===>" +frmObject.p_report_id.value);
				}
				else if(frmObject.p_report_by.value == 'AC'  && frmObject.p_report_type.value == 'S'){
					frmObject.p_report_id.value = 'PHDRGDSPBILLGRSUMM';
					//alert("frmObject.p_report_id.value= 475 ATC===>" +frmObject.p_report_id.value);
				}
				else if(frmObject.p_report_by.value == 'AC'  && frmObject.p_report_type.value == 'D'){
					frmObject.p_report_id.value = 'PHDRGDSPBILLGRDTL';
					//alert("frmObject.p_report_id.value= 475 ATC Detail===>" +frmObject.p_report_id.value);
				}
				else if(frmObject.p_report_by.value == ''  && frmObject.p_report_type.value == 'D'){
					frmObject.p_report_id.value = 'PHDRGDBILGATCDTL';
					//alert("frmObject.p_report_id.value= 467 ATC Vs BILL  Detail===>" +frmObject.p_report_id.value);
				}
				else if(frmObject.p_report_by.value == ''  && frmObject.p_report_type.value == 'S'){
					frmObject.p_report_id.value = 'PHDRGDBILGATCSUMM';
					//alert("frmObject.p_report_id.value= 471 ATC Vs BILL  Summ===>" +frmObject.p_report_id.value);
				}
				//================================================================================================================
if(frmObject.dt_from1.value!='' && frmObject.dt_to1.value!='')
{ 
					
	if(!isBefore(frmObject.dt_to1.value,frmObject.sysdate.value,"DMY",frmObject.p_language_id.value)) {
		var errors=getMessage("START_DATE_GREATER_SYSDATE","Common") ;
		alert(errors);
		return false
	}

    if(!isBefore(frmObject.dt_from1.value,frmObject.dt_to1.value,"DMY",frmObject.p_language_id.value)) {
			var errors=getMessage('FROM_DATE_GREATER_TO_DATE','FM'); 			
			alert(errors);
			return false;			
	}
}
//=====================================================================================================================	

					var fields= new Array (frmObject.dt_from1,frmObject.dt_to1);
					var names= new Array (getLabel("Common.date.label","Common"),getLabel("Common.to.label","Common"));
					if(checkFields(fields,names,messageFrame))	
					{		
							frmObject.p_disp_date_from.value = convertDate(frmObject.dt_from1.value,'DMY',frmObject.p_language_id.value,'en');
							frmObject.p_disp_date_to.value = convertDate(frmObject.dt_to1.value,'DMY',frmObject.p_language_id.value,'en');
							if( f_query_add_mod.doDateCheck( f_query_add_mod.document.FormDrugDispensingStasticreportCriteria.dt_from1, f_query_add_mod.document.FormDrugDispensingStasticreportCriteria.dt_to1, messageFrame ) ) {
									//var formObj=f_query_add_mod.document.FormDrugDispensingStasticreportCriteria;
									
									//alert("=====" +frmObject.p_disp_date_from.value);
									f_query_add_mod.document.FormDrugDispensingStasticreportCriteria.submit();
									
							
							}
					}	
			
	}
}

function reset() {
	
		f_query_add_mod.location.reload();
		messageFrame.document.location.href='../../eCommon/jsp/error.jsp';
}
