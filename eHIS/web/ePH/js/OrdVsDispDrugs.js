/*
---------------------------------------------------------------------------------------------------------
Date			Edit History    	Name			Rev. Date		Rev. By			Description
---------------------------------------------------------------------------------------------------------
31/3/2021		TFS:15977			Shazana											NMC-JD-SCF-0160
---------------------------------------------------------------------------------------------------------
*/   
//saved on 02.11.2005
//Patient Search from common.js
async function callPatientLookup(){
	var formObj = parent.f_query_add_mod.document.forms[0];
	var P_PAT_ID =await PatientSearch();
	if(P_PAT_ID != null && P_PAT_ID != "" )  {
		formObj.P_PAT_ID1.value = P_PAT_ID;
		formObj.P_PAT_ID.value = P_PAT_ID;
		//formObj.P_PATIENT_ID.value = P_PAT_ID;
		//formObj.patient_id.focus();
		formObj.P_PAT_ID1.disabled  = true;
		//formObj.patient_search.disabled = true;
     }
}

// lookup for Drug Name
async function callDrugSearch(obj,mode) {

	var arrCodeDesc =await DrugSearch("D",obj);
	var str =unescape(arrCodeDesc);
	var arr = str.split(",");
	

	if(arrCodeDesc != null && arrCodeDesc != "" ) {
		if (mode == 1)
		{  document.formOrderDispDrugs.p_drug_code.value	=	arr[0];
		   document.formOrderDispDrugs.P_RET_DRUG.value	    =	arr[0];
		   
		}
		if (mode == 2)
		{		document.formOrderDispDrugs.p_drug_code.value	=	arr[0];
		}
//		document.formPhDrugUsageByPractCriteria.drug_code.value	=	arrCodeDesc[0];
		obj.value =	arr[1];


	}else{
		if (mode == 1)
		{  document.formOrderDispDrugs.p_drug_code.value	=	"";
		   document.formOrderDispDrugs.P_RET_DRUG.value	    =	"";
		   
		}

	}
}

	// the below method is used for leap year calculation
	function CheckDateT(obj){
		var locale=document.formOrderDispDrugs.p_language_id.value;
	
		if(obj.value!=""){
			if(!validDate(obj.value, 'DMY',locale)){
				alert(getMessage("INVALID_DATE_FMT", "SM"));
				obj.select();
				obj.focus();
				return false;
			}
		}
		else{
			obj.value=convertDate(obj,'DMY',locale,'en');
		}
	}

async function searchDrugName(){

	var formObj = document.formOrderDispDrugs;
	var argumentArray  = new Array() ;
	var dataNameArray  = new Array() ;
	var dataValueArray = new Array() ;
	var dataTypeArray  = new Array() ;
	argumentArray[0]   = escape(document.getElementById("sql_ph_drug_search_select2").value)+"'"+formObj.language_id.value+"'";
	argumentArray[1]   = dataNameArray ;
	argumentArray[2]   = dataValueArray ;
	argumentArray[3]   = dataTypeArray ;
	argumentArray[4]   = "1,2";
	
	argumentArray[5]   = formObj.p_drug_name.value ;
	argumentArray[6]   = DESC_LINK ;
	argumentArray[7]   = DESC_CODE ; 
	retVal =await CommonLookup(getLabel("Common.DrugName.label","Common"), argumentArray );
	var str =unescape(retVal);
	var arr = str.split(",");
	if(retVal != null && retVal != "" )  {
		formObj.p_drug_name.value = arr[1] ;
		formObj.p_drug_code.value = arr[0];
		
		formObj.p_drug_name.disabled  = true;
		formObj.p_drug_name_search.disabled = true;	
	}
}


async function locationLookup(target){
	var formObj = document.formOrderDispDrugs;
	var locn_type=formObj.p_locn_type.value;
	var argumentArray  = new Array() ;
	var dataNameArray  = new Array() ;
	var dataValueArray = new Array() ;
	var dataTypeArray  = new Array() ;
	var sql_ph_printprescriotions_select2 = "SELECT NURSING_UNIT_CODE code, SHORT_DESC description FROM IP_NURSING_UNIT_LANG_VW IP_NURSING_UNIT  WHERE  UPPER(NURSING_UNIT_CODE) LIKE UPPER(?) AND UPPER(SHORT_DESC) LIKE UPPER(?) AND EFF_STATUS='E' AND LANGUAGE_ID = '"+formObj.language_id.value+"' ";//15977 START
	var sql_ph_printprescriotions_select1 = "SELECT CLINIC_CODE code, SHORT_DESC description FROM OP_CLINIC_LANG_VW OP_CLINIC  WHERE  UPPER(CLINIC_CODE) LIKE UPPER(?) AND UPPER(SHORT_DESC) LIKE UPPER(?) AND EFF_STATUS='E' AND LANGUAGE_ID = '"+formObj.language_id.value+"' "; //15977 end
	if (locn_type!=""){
		if (locn_type=="N"){
			//argumentArray[0]   = escape(document.getElementById("SQL_PH_PRINT_PRESCRIPTIONS_SELECT2").value)+"'"+formObj.language_id.value+"'";//commented for 15977 
			argumentArray[0]   = escape(sql_ph_printprescriotions_select2);//MODIFIED for 15977
			argumentArray[1]   = dataNameArray ;
			argumentArray[2]   = dataValueArray ;
			argumentArray[3]   = dataTypeArray ;
			argumentArray[4]   = "1,2";
			argumentArray[5]   = target.value ;
			argumentArray[6]   = DESC_LINK ;
			argumentArray[7]   = CODE_DESC ;

			var retVal = await CommonLookup( getLabel("Common.Location.label","Common"), argumentArray );
			var str =unescape(retVal);
			var arr = str.split(",");
			if(retVal != null && retVal != "" )  {
				formObj.p_locn_code.value=arr[0];
				target.value = arr[1] ;
			} 
		}else if (locn_type=="C"){
			//argumentArray[0]   =  escape(document.getElementById("SQL_PH_PRINT_PRESCRIPTIONS_SELECT1").value)+"'"+formObj.language_id.value+"'";//commented for 15977 
			argumentArray[0]   =  escape(sql_ph_printprescriotions_select1);//MODIFIED for 15977 
			argumentArray[1]   = dataNameArray ; 
			argumentArray[2]   = dataValueArray ;
			argumentArray[3]   = dataTypeArray ;
			argumentArray[4]   = "1,2";
			argumentArray[5]   = target.value ;
			argumentArray[6]   = DESC_LINK ;
			argumentArray[7]   = CODE_DESC ;

			var retVal = await CommonLookup( getLabel("Common.Location.label","Common"), argumentArray );
			var str =unescape(retVal);
			var arr = str.split(",");
			if(retVal != null && retVal != "" )  {
				formObj.p_locn_code.value=arr[0];
				target.value = arr[1] ;
			}
		}
	}
	else{
		formObj.p_locn_type.focus()
	}
}


/*function validateDate(){

	var formObj = document.frames.formOrderDispDrugs;
	if (formObj.P_FROM_DATE.value!="" && formObj.P_TO_DATE.value!=""){

	}
}*/

function reset()
{
	var formObj=f_query_add_mod.document.formOrderDispDrugs;
	f_query_add_mod.document.formOrderDispDrugs.reset();
	formObj.p_drug_name_search.disabled=false;
}


function run() {
	
	var frmObject = f_query_add_mod.document.formOrderDispDrugs;
	if(f_query_add_mod.document.formOrderDispDrugs) {
	 //alert("P_PATIENT_ID--->"+frmObject.P_PAT_ID.value);
	var fields= new Array (frmObject.p_from_dt1,frmObject.p_to_dt1);
	var names = new Array (getLabel("Common.DateFrom.label","Common"),getLabel("Common.DateTo.label","Common"));
      if(f_query_add_mod.checkFields( fields, names, messageFrame))
		{
			if(f_query_add_mod.doDateCheck( f_query_add_mod.document.formOrderDispDrugs.p_from_dt, f_query_add_mod.document.formOrderDispDrugs.p_to_dt, messageFrame ) )  {
			 frmObject.p_from_dt.value=convertDate( frmObject.p_from_dt1.value,'DMY', frmObject.p_language_id.value,'en');
			 frmObject.p_to_dt.value=convertDate( frmObject.p_to_dt1.value,'DMY', frmObject.p_language_id.value,'en');
			 if(frmObject.P_PAT_ID.value==''){
			 frmObject.P_PAT_ID.value=frmObject.P_PAT_ID1.value;
			 }
			 f_query_add_mod.document.forms[0].action="../../eCommon/jsp/report_options.jsp";
			 f_query_add_mod.document.forms[0].target="messageFrame";
			 f_query_add_mod.document.formOrderDispDrugs.submit();
			}
		}
	}
}	
	

function clear1(obj)
{
	
if(document.formOrderDispDrugs.p_locn_type.value==""){
	document.formOrderDispDrugs.p_locn_name.disabled=false;
	document.formOrderDispDrugs.p_locn_name.value='';	
	document.formOrderDispDrugs.p_locn_code.value='';	
			}
else
	{
	document.formOrderDispDrugs.p_locn_name.value='';
		document.formOrderDispDrugs.p_locn_code.value='';	
	}
}

function clearvalues(){
           document.formOrderDispDrugs.p_drug_code.value	=	"";
		   document.formOrderDispDrugs.P_RET_DRUG.value	    =	"";
}
//Added for BRUSIM Adhoc Testing-Start
function validate_date(Obj) {

	if(document.formOrderDispDrugs.p_from_dt1.value=='' || document.formOrderDispDrugs.p_to_dt1.value=='')
	{
					return false;
	}
	else{
		if(!isBefore(document.formOrderDispDrugs.p_from_dt1.value,document.formOrderDispDrugs.p_to_dt1.value,"DMY",document.formOrderDispDrugs.p_language_id.value)) {			
				var errors=getMessage('FROM_DATE_GREATER_TO_DATE','FM');			
				alert(errors);
				Obj.value = "";  
				return false;
			}
	}return true;
}
function DateCheck(from,to) {
    if(from=="" || to.value=="")
	{ 		
		return false;
	}
	else{
		if(!isBefore(to.value,from,"DMY",document.formOrderDispDrugs.p_language_id.value)) {
			var errors=getMessage("START_DATE_GREATER_SYSDATE","Common") ;
			alert(errors);
			to.value=""
			return false;
		}
	}  
  return true;
}

function CheckDateT(obj){
	
	var locale=document.formOrderDispDrugs.p_language_id.value;
	if(obj.value!=""){
		if(!validDate(obj.value, 'DMY',locale)){
			alert(getMessage("INVALID_DATE_FMT", "SM"));
			obj.value="";
			obj.focus();
			return false;
		}
	}
	else{
		obj.value=convertDate(obj,'DMY',locale,'en');
	}
}//Added for BRUSIM Adhoc Testing-End
