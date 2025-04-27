  //saved on 04/11.2005
function run() {

	var frmObject = f_query_add_mod.document.formPhDispDrugSummary;
	if(f_query_add_mod.document.formPhDispDrugSummary) {
	 //assiging values to the hidden values of report parameters
	f_query_add_mod.document.formPhDispDrugSummary.p_report_by.value=f_query_add_mod.document.formPhDispDrugSummary.report_by.value;
	f_query_add_mod.document.formPhDispDrugSummary.p_drug_yn.value=f_query_add_mod.document.formPhDispDrugSummary.drug_med_supply.value;
	f_query_add_mod.document.formPhDispDrugSummary.p_disp_loc.value=f_query_add_mod.document.formPhDispDrugSummary.p_disp_locn.value;
	if (frmObject.report_by.value == 'M'||frmObject.report_by.value =='Y')
	{
		if (frmObject.p_month_from.value == '' || frmObject.p_year_from.value == '')
		{
			alert(getMessage("PH_PERIOD_FROM_CANNOT_BE_BLANK","PH"));
			return false;
		}
		if (frmObject.p_month_to.value == '' || frmObject.p_year_to.value == '')
		{
			alert(getMessage("PH_PERIOD_TO_CANNOT_BE_BLANK","PH"));
			return false;
		}
		if (frmObject.p_year_to.value < frmObject.p_year_from.value)
		{
			alert(getMessage("TO_DATE_EQUAL_GREATER_FROM_DATE","PH"));
			frmObject.p_year_to.focus();
			return false;
		}else if ( (frmObject.p_year_to.value == frmObject.p_year_from.value )&& (frmObject.p_month_to.value < frmObject.p_month_from.value) )
		{
			alert(getMessage("FROM_DATE_LESS_EQ_TO_DT","PH"));
			frmObject.p_month_to.focus();
			return false;
		}
	var fields= new Array (frmObject.report_by,frmObject.drug_med_supply,frmObject.p_report_type);
	var names= new Array (getLabel("Common.ReportBy.label","Common"),getLabel("ePH.DRUG/MEDICALSUPPLY.label","ph"),getLabel("Common.reporttype.label","Common"));	

	if(checkFields(fields,names,messageFrame)){			
		if ((frmObject.report_by.value == 'M' || frmObject.report_by.value == 'Y') && frmObject.p_report_type.value == 'S')
		{
				frmObject.p_report_id.value ='PHDISPDRGSUMBYMY';
		}
		else if (frmObject.report_by.value == 'M' && frmObject.p_report_type.value == 'D')
		{
			frmObject.p_report_id.value ='PHDISPDRUGDTLBYM';
		}
			//alert(frmObject.p_report_id.value);
			frmObject.p_fm_month.value = frmObject.p_month_from.value;
			frmObject.p_to_month.value=frmObject.p_month_to.value;
/*===============================================================================================================*/
			var p_fm_year_temp1 = "01/01/"+frmObject.p_year_from.value;
			var p_to_year_temp1 = "01/01/"+frmObject.p_year_to.value;
			var p_fm_year_temp2 = convertDate(p_fm_year_temp1,'DMY',frmObject.p_language_id.value,"en");
			var p_to_year_temp2 = convertDate(p_to_year_temp1,'DMY',frmObject.p_language_id.value,"en");		
			var fm_vals = p_fm_year_temp2.split("/");
			var to_vals =  p_to_year_temp2.split("/"); 
			frmObject.p_fm_year.value = fm_vals[2];
			frmObject.p_to_year.value =  to_vals[2];
			
/*===============================================================================================================*/

			frmObject.submit();			
		}
	
	}
	else{
		var fields= new Array (frmObject.report_by,frmObject.p_enq_date_from,frmObject.p_enq_date_to,frmObject.drug_med_supply,frmObject.p_report_type);
		var names= new Array (getLabel("Common.ReportBy.label","Common"),getLabel("Common.periodfrom.label","Common"),getLabel("Common.todate.label","Common"),getLabel("ePH.DRUG/MEDICALSUPPLY.label","ph"),getLabel("Common.reporttype.label","Common"));
		if(checkFields(fields,names,messageFrame)){			
		f_query_add_mod.document.formPhDispDrugSummary.p_fm_date.value = convertDate(frmObject.p_enq_date_from.value,'DMY',frmObject.p_language_id.value,"en");
		f_query_add_mod.document.formPhDispDrugSummary.p_to_date.value = convertDate(frmObject.p_enq_date_to.value,'DMY',frmObject.p_language_id.value,"en");
		frmObject.p_report_id.value ='PHDISPDRUGDTLBYD';
		//alert(frmObject.p_report_id.value);
		if( f_query_add_mod.doDateCheck( f_query_add_mod.document.formPhDispDrugSummary.p_enq_date_from, f_query_add_mod.document.formPhDispDrugSummary.p_enq_date_to, messageFrame ) ) {
				f_query_add_mod.document.formPhDispDrugSummary.submit();
			}
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


function validate_date(Obj,ref) {
                

	if (CheckDate(Obj))
	{
	 if(ref == "TO_DT_GR_EQ_FM_DT")
	{
	  from = document.forms[0].p_enq_date_to;
	  to = document.forms[0].p_enq_date_from;
	  error_id = getMessage('TO_DATE_EQUAL_GREATER_FROM_DATE','PH');
	 	 
	}
		else if(ref == "TO_DT_GR_EQ_FM_DT1")
	{
	  from = document.forms[0].p_enq_date_from;
	  to = document.forms[0].p_enq_date_to;
	  error_id = getMessage('TO_DATE_EQUAL_GREATER_FROM_DATE','PH');
	 	 
	}
	else if(ref == "TO_DATE_LESS_FROM")
	{
	  from = parent.frames[1].document.forms[0].p_enq_date_to;
	  to = parent.frames[1].document.forms[0].p_enq_date_from;
	  error_id = getMessage('TO_DATE_EQUAL_GREATER_FROM_DATE','PH');
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
			alert(error_id);
 		    from.focus();
		}
		else if(Date.parse(todt) <= Date.parse(fromdt))
		     {
	       //parent.messageFrame.document.location.href="../../eCommon/jsp/error.jsp?err_num= ";
		       return true;
		      } 
	}
	return true;
}
}


function DateCheck(from,to) {

    var fromarray;
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
    return true;
}

function searchDrugName()
{
	var formObj = document.frames.formPhDispDrugSummary;
	var search_criteria = formObj.drug_med_supply.value
	var argumentArray  = new Array() ;
	var dataNameArray  = new Array() ;
	var dataValueArray = new Array() ;
	var dataTypeArray  = new Array() ;
	var lookup_name = getLabel("Common.ItemName.label","Common");
	if (search_criteria == 'D')
	{
	  argumentArray[0]   = escape(document.getElementById("sql_ph_drug_search_select").value)+"'"+formObj.language_id.value+"' and DRUG_YN = 'Y'";
	  lookup_name = getLabel("Common.DrugName.label","Common");
	}else if (search_criteria == 'M' )
	{
	   argumentArray[0]   = escape(document.getElementById("sql_ph_drug_search_select").value)+"'"+formObj.language_id.value+"' and DRUG_YN = 'N'";	  
	}else
	{
	argumentArray[0]   = escape(document.getElementById("sql_ph_drug_search_select").value)+"'"+formObj.language_id.value+"'";
	}
	
	argumentArray[1]   = dataNameArray ;
	argumentArray[2]   = dataValueArray ;
	argumentArray[3]   = dataTypeArray ;
	argumentArray[4]   = "1,2";
	argumentArray[5]   = formObj.drug_name.value ;
	argumentArray[6]   = DESC_LINK ;
	argumentArray[7]   = DESC_CODE ; 
	retVal = CommonLookup(lookup_name, argumentArray );

	if(retVal != null && retVal != "" )  
	{
		formObj.drug_name.value = retVal[1] ;
		formObj.p_drug_code.value = retVal[0];
		
		formObj.drug_name.disabled  = true;
		formObj.drug_search_btn.disabled = true;
		
	}
}

function callCriteriaChange(){
	var formObj = document.frames.formPhDispDrugSummary;

	formObj.generic_name_txt.value ='' ;
	formObj.p_generic_id.value = '';	
	formObj.drug_name.value = '';	
	formObj.p_drug_code.value = '';	
	
	if (formObj.drug_med_supply.value != '')
	{
		formObj.drug_search_btn.disabled = false;
	}
	else{
		formObj.drug_search_btn.disabled = true;
		formObj.generic_name_btn.disabled = true;
	}
	if (formObj.drug_med_supply.value == 'Y')
	{
		formObj.generic_name_btn.disabled = false;
	}else{
	formObj.generic_name_btn.disabled = true;
	}

}
function callLocationLookup(locn_txt) {

	var argumentArray	= new Array() ;
	var dataNameArray	= new Array() ;
	var dataValueArray	= new Array() ;
	var dataTypeArray	= new Array() ;

	
	dataNameArray[1]	= "FACILITY_ID" ;
	dataValueArray[1]	= formPhDispDrugSummary.p_facility_id.value;
	dataTypeArray[1]	= STRING ;
	dataNameArray[2]	= "FACILITY_ID" ;
	dataValueArray[2]	= formPhDispDrugSummary.p_facility_id.value;
	dataTypeArray[2]	= STRING ;
    	
	argumentArray[1] = dataNameArray ;
	argumentArray[2] = dataValueArray ;
	argumentArray[3] = dataTypeArray ;
	argumentArray[4] = "4,5";
	argumentArray[5] = locn_txt.value;
	argumentArray[6] = DESC_LINK ;
	argumentArray[7] = DESC_CODE ;


	if (formPhDispDrugSummary.p_locn_type.value == "N")
	{  
		//Search for Nursing Unit	
		argumentArray[0]   = escape(document.getElementById("sql_ph_nursing_unit_select").value)+ "'"+formPhDispDrugSummary.p_language_id.value+"' "+ " AND APPL_USER_ID =  '"+formPhDispDrugSummary.p_user_name.value+"' order by 2";	
		retVal=CommonLookup(getLabel("Common.nursingUnit.label","Common"), argumentArray );	
		if(retVal != null && retVal != "") {		
			formPhDispDrugSummary.p_locn_code.value=retVal[0];
			locn_txt.value = retVal[1];	
		}
		else{
			formPhDispDrugSummary.p_locn_code.value='';
			locn_txt.value = '';	
		}
	}
	else if (formPhDispDrugSummary.p_locn_type.value=="C")
	{
		//Search for Clinic 	
		argumentArray[0]   = escape(document.getElementById("sql_ph_clinic_select").value)+" '"+formPhDispDrugSummary.p_language_id.value+"' "+ " AND b.APPL_USER_ID = '"+formPhDispDrugSummary.p_user_name.value+"' order by 2";	
		retVal=CommonLookup(getLabel("Common.clinic.label","Common"), argumentArray );

		if(retVal != null && retVal != "") {
			formPhDispDrugSummary.p_locn_code.value=retVal[0];
			locn_txt.value = retVal[1];	
		}
	}
	else{
	alert(getMessage("PH_LOCATION_TYPE_CANNOT_BE_BLANK","PH"));//PH_LOCATION_TYPE_CANNOT_BE_BLANK
	}

}

function clearLocation(){

  formPhDispDrugSummary.p_locn_code.value = '';
  formPhDispDrugSummary.locn_text.value = '';
}

function selectbilling(obj,calledby)
{
	
	var argumentArray  = new Array() ;
	var dataNameArray  = new Array() ;
	var dataValueArray = new Array() ;
	var dataTypeArray  = new Array() ; 	
 	
 	argumentArray[0] ="SELECT blng_grp_id code, short_desc description FROM bl_blng_grp_lang_vw WHERE   LANGUAGE_ID like ( ?) and UPPER(blng_grp_id) LIKE UPPER(?) AND UPPER(short_desc) LIKE UPPER(?)  order by 2";

	dataNameArray[0] ="locale";
	dataValueArray[0]= formPhDispDrugSummary.p_language_id.value;
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
				formPhDispDrugSummary.p_fr_privilegde.value = retVal[0];
			}
			else
				formPhDispDrugSummary.p_to_privilegde.value = retVal[0];
		}else{
			obj.value ="";			
		}		
		
}

function searchGenericName()
{
	var formObj = document.frames.formPhDispDrugSummary;
	var argumentArray  = new Array() ;
	var dataNameArray  = new Array() ;
	var dataValueArray = new Array() ;
	var dataTypeArray  = new Array() ;
	var lookup_name = getLabel("Common.GenericName.label","Common");
	
	  argumentArray[0]   = escape(document.getElementById("sql_ph_generic_search_select").value)+"'"+formObj.language_id.value+"' order by generic_name";	
	
	argumentArray[1]   = dataNameArray ;
	argumentArray[2]   = dataValueArray ;
	argumentArray[3]   = dataTypeArray ;
	argumentArray[4]   = "1,2";
	argumentArray[5]   = formObj.drug_name.value ;
	argumentArray[6]   = DESC_LINK ;
	argumentArray[7]   = DESC_CODE ; 
	retVal = CommonLookup(lookup_name, argumentArray );

	if(retVal != null && retVal != "" )  
	{
		formObj.generic_name_txt.value = retVal[1] ;
		formObj.p_generic_id.value = retVal[0];	
		formObj.generic_name_txt.disabled  = true;
		formObj.generic_name_btn.disabled = true;
	}
}

function loadReportType(){
	clearCategoryList();
	var formObj = parent.f_query_add_mod.formPhDispDrugSummary;	
	if (formObj.report_by.value == 'M')
	{
		var element = document.createElement('OPTION') ;
		element.value		=  ""  ;
		element.text		=  "---------"+getLabel("Common.Select.label","Common")+"---------"; 
		formObj.p_report_type.add(element);

		var element1 = document.createElement('OPTION') ;
		element1.value		=  "D"  ;//details 
		element1.text		=  getLabel("Common.details.label","Common"); 
		formObj.p_report_type.add(element1);
		

		var element2 = document.createElement('OPTION') ;
		element2.value		=  "S" ;//summary
		element2.text		=  getLabel("Common.Summary.label","Common"); 
		formObj.p_report_type.add(element2);	
		element2.selected = true;
	}else if (formObj.report_by.value == 'Y')
	{
		
		var element = document.createElement('OPTION') ;
		element.value		=  ""  ;
		element.text		=   "---------"+getLabel("Common.Select.label","Common")+"---------"; 
		formObj.p_report_type.add(element);

		var element2 = document.createElement('OPTION') ;
		element2.value		=  "S" ;
		element2.text		=  getLabel("Common.Summary.label","Common"); 
		formObj.p_report_type.add(element2);
		element2.selected = true;
	}else if (formObj.report_by.value == 'D')
	{
		
		var element = document.createElement('OPTION') ;
		element.value		=  ""  ;
		element.text		=   "---------"+getLabel("Common.Select.label","Common")+"---------"; 
		formObj.p_report_type.add(element);

		var element2 = document.createElement('OPTION') ;
		element2.value		=  "D" ;
		element2.text		=  getLabel("Common.details.label","Common"); 
		formObj.p_report_type.add(element2);
		element2.selected = true;
	}
	else{
		var element = document.createElement('OPTION') ;
		element.value		=  ""  ;
		element.text		=   "---------"+getLabel("Common.Select.label","Common")+"---------"; 
		formObj.p_report_type.add(element);
	}

	
}

function clearCategoryList(){
   
	var len = parent.f_query_add_mod.formPhDispDrugSummary.p_report_type.options.length ;
	if (len>0)
	{
	
		for( i=0;i<len;i++)
		{
			parent.f_query_add_mod.formPhDispDrugSummary.p_report_type.remove('atc_class_l2_code') ;
		}
	}
	
}
/*function loadReportType_reset(){
       clearCategoryList_reset();

	   var element = document.createElement('OPTION') ;
		element.value		=  ""  ;
		element.text		=  "---------"+getLabel("Common.Select.label","Common")+"---------"; 
		f_query_add_mod.formPhDispDrugSummary.p_report_type.add(element);

		var element1 = document.createElement('OPTION') ;
		element1.value		=  "D"  ;//details 
		element1.text		=  getLabel("Common.details.label","Common"); 
		f_query_add_mod.formPhDispDrugSummary.p_report_type.add(element1);
		element1.selected = true;

		var element2 = document.createElement('OPTION') ;
		element2.value		=  "S" ;//summary
		element2.text		=  getLabel("Common.Summary.label","Common"); 
		f_query_add_mod.formPhDispDrugSummary.p_report_type.add(element2);
	  
}

function clearCategoryList_reset(){
   
	var len = f_query_add_mod.formPhDispDrugSummary.p_report_type.options.length ;
	if (len>0)
	{
	
		for( i=0;i<len;i++)
		{
			f_query_add_mod.formPhDispDrugSummary.p_report_type.remove('atc_class_l2_code') ;
		}
	}
	
}*/

function loadPeriodFrom(){	
	//var formObj =document.frames.formPhDispDrugSummary
     if (document.getElementById("report_by").value == 'D')
     {
		document.getElementById("month_year").style.display='none';
		document.getElementById("daily").style.display='inline';
     }else{
	    document.getElementById("month_year").style.display='inline';
		document.getElementById("daily").style.display='none';
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
	
	var formObj =document.frames.formPhDispDrugSummary
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

function clearValues(obj){
	var formObj =document.frames.formPhDispDrugSummary
	formObj.p_month_from.value ='';
	formObj.p_year_from.value ='';	
	formObj.p_month_to.value ='';
	formObj.p_year_to.value ='';

}
function populateDispLocs(obj, language_id)
{
	var formObj =document.formPhDispDrugSummary;
	var facility_id = obj.value;
	
	formObj.p_locn_type.value ='';
	formObj.locn_text.value ='';
	formObj.p_locn_code.value ='';

	var bean_id		= "SRRPHRepDispStatisByDispBean" ; ;
	var bean_name	= "ePH.SRRPHRepDispStatisByDispBean" ;
	var xmlDoc="";
	var xmlHttp = new XMLHttpRequest();
	xmlStr	="<root><SEARCH " ;
	xmlStr +=" /></root>" ;
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open( "POST", "SRRPhRepDlyDispSummValidate.jsp?bean_id="+bean_id+"&bean_name="+bean_name+"&func_mode=populateDispLocs"+"&facility_id="+facility_id+"&locale="+language_id.value, false ) ;
	xmlHttp.send( xmlDoc ) ;
	//alert(xmlHttp.responseText);
	eval(xmlHttp.responseText);

}

function clearList(){
	
	var disp_loc_len =document.formPhDispDrugSummary.p_disp_locn.options.length;
	for(var i=0;i<disp_loc_len;i++) {
		formPhDispDrugSummary.p_disp_locn.remove("p_disp_locn") ;
	}
}

function addOption(code,desc){

	var opt = document.createElement("OPTION") ;
	if(desc == "A")
		desc = "--"+getLabel("Common.defaultSelect.label","Common")+"--";
	//opt.text = desc ;
	opt.text = decodeURIComponent(desc,"UTF-8") ; //ADDED DecodeUriComponent for optdesc to convert language  into thai for the incident num:25042 on 30/Nov/2010===By Sandhya
	opt.value = code ;	
	document.formPhDispDrugSummary.p_disp_locn.add(opt);

}
function changeEDClassficationStatus(obj){
	if (obj.value == 'Y')
	{
		document.formPhDispDrugSummary.p_edl_codes.disabled=false;
	}
	else {
	document.formPhDispDrugSummary.p_edl_codes.disabled=true;
	document.formPhDispDrugSummary.p_edl_codes.value ='';
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
