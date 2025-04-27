

/*

Date        Edit History    Name                Rev.Date    Rev.Name        Description
------------------------------------------------------------------------------------------------------------------------------
03/05/2023		TFS-43531  Raja Hanumanthu		04/05/2023	Ramesh Goli   ML-MMOH-CRF-1823
------------------------------------------------------------------------------------------------------------------------------
*/

function reset() {
	var formobj=document.f_query_add_mod.formQuotaLimitQryCriteria.reset();
	document.f_price_detail.location.href="../../eCommon/html/blank.html";
	
	}
async function callPatientSearch(){
//alert("--callPatientSearch--");
	var formObj=document.formQuotaLimitQryCriteria;
	var patient_id =await PatientSearch();
	if (patient_id != "" && patient_id != undefined){
		formObj.patient_id.value = patient_id;
	}
}

async function populateSpl()
{  
//alert("------populateSpl------")
    var target			= document.forms[0].splName;
	var retVal			=  new String();
	var title			= getLabel("Common.speciality.label","common");
	//var sql="SELECT SPECIALITY_CODE CODE, SHORT_DESC DESCRIPTION FROM AM_SPECIALITY_LANG_VW WHERE EFF_STATUS = 'E' AND LANGUAGE_ID= ?");
	var argArray		= new Array();
	var namesArray		= new Array();
	var valuesArray		= new Array();
	var datatypesArray	= new Array();	
	var parNameArray  = new Array() ;
	var parValueArray  = new Array() ;	
	argArray[0] = "";
	argArray[1] = namesArray;
	argArray[2] = valuesArray;
	argArray[3] = datatypesArray;
	argArray[4] = "1,2";
	argArray[5] = target.value;
	argArray[6] = DESC_LINK;
	argArray[7] = CODE_DESC;
	
	argArray[12]  = "SQL_SPECIALITY_LOOKUP_SELECT";
	argArray[13]  = "eCA.Common.CaRepository";
	argArray[14]  = parNameArray
	argArray[15]  = parValueArray
	retVal      = await CommonLookup( title, argArray );
	var ret1=unescape(retVal);
	var arr=ret1.split('"');
		 	if(arr[1]==undefined) 
	 		{
		 		arr[0]="";	
		 		arr[1]="";	
	 		}
		
    if (retVal != null && retVal != '' && retVal != "null")
	{
		document.forms[0].splName.value = arr[1];
		document.forms[0].splCode.value = arr[0]
	}
    else
	{
		document.forms[0].splName.value = "";
		document.forms[0].splCode.value = "";
	} 
	document.forms[0].flag.value='true';
}

async function getdrugname(objCode)
{
	if(objCode.value=='')
	{
		document.forms[0].drug_name.value='';
	}else{	
		await searchDrugName1()
	}	 
}
async function searchDrugName1(obj){
	//alert("-----searchDrugName1------");
	//var formObj = document.formQuotaLimitQryCriteria;
	var formObj = document.forms[0];
	var argumentArray  = new Array() ;
	var dataNameArray  = new Array() ;
	var dataValueArray = new Array() ;
	var dataTypeArray  = new Array() ;
	//argumentArray[0]   =formObj document.queryformQuotaLimitQryCriteria.sql_ph_drug_search_select2.value+"'"+language_id+"'";
	argumentArray[0]   = formObj.sql_ph_drug_query_select2.value+"'"+formObj.p_language_id.value+"'";
	argumentArray[1]   = dataNameArray ;
	argumentArray[2]   = dataValueArray ;
	argumentArray[3]   = dataTypeArray ;
	argumentArray[4]   = "1,2";
	argumentArray[5]   = formObj.drug_name.value ;
	
	argumentArray[6]   = DESC_LINK ;
	argumentArray[7]   = DESC_CODE ; 

	var retVal = await CommonLookup( getLabel("Common.DrugName.label","Common"), argumentArray );
	
	var ret1=unescape(retVal);
	var arr=ret1.split('"');
		 	if(arr[1]==undefined) 
	 		{
		 		arr[0]="";	
		 		arr[1]="";	
	 		}
	if(retVal != null && retVal != "" )  {
		
		formObj.drug_name.value			= arr[1];
		formObj.drug_code.value			= arr[0];
	}
	
}

async function showCalendarValidate(str)
{
    var flg = await showCalendar(str);
    document.getElementById(str).focus();
    return flg;
}



function showCalendarValidate(str)
{
	var flg = showCalendar(str);
	eval("document.all."+str+".focus();");
	return flg;
}

 function CheckDateLeap1(obj){
	var locale=document.formQuotaLimitQryCriteria.p_language_id.value;
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

function loadordersResult() {
	//alert("------loadordersResult-------");
	var frmObject =parent.f_query_add_mod.document.formQuotaLimitQryCriteria;
	
	if(frmObject) { 
		var fields= new Array (frmObject.drug_name,frmObject.splName,frmObject.p_ord_fm_date,frmObject.p_ord_to_date);
		var names= new Array (getLabel("Common.DrugName.label","Common"),getLabel("Common.speciality.label","Common"),getLabel("Common.OrderDateFrom.label","common"),getLabel("Common.to.label","Common"));
		
		if(checkFields(fields,names,parent.messageFrame)) {
			if(!isBefore(frmObject.p_ord_to_date.value,frmObject.sys_date.value,"DMY",frmObject.p_language_id.value)) {
					var	errors=getMessage("TO_DATE_LESS_THAN_SYSDATE","PH") ;
					alert(errors);
					return false;
				}
			 if(!isBefore(frmObject.p_ord_fm_date.value,frmObject.p_ord_to_date.value,"DMY",frmObject.p_language_id.value)) {
			
					var errors=getMessage('FROM_DATE_GREATER_TO_DATE','FM'); 			
					alert(errors);
					return false;			
			 	}
			 var max_days=daysBetween(frmObject.p_ord_fm_date.value,frmObject.p_ord_to_date.value,"DMY",frmObject.p_language_id.value);
				if(max_days>6){
					var errors=getMessage('PH_DRUG_DATE_DIFFERENCE','PH');
					alert(errors);
					return false;
				}
		frmObject.P_FRDATE.value =	frmObject.p_ord_fm_date.value;	
		frmObject.P_TODATE.value =	frmObject.p_ord_to_date.value;	
	
	
	
	
	var drug_name		    =	parent.f_query_add_mod.document.formQuotaLimitQryCriteria.drug_name.value;
	var drug_code		    =	parent.f_query_add_mod.document.formQuotaLimitQryCriteria.drug_code.value;
	var patient_id		    =	parent.f_query_add_mod.document.formQuotaLimitQryCriteria.patient_id.value;
	var splCode				=	parent.f_query_add_mod.document.formQuotaLimitQryCriteria.splCode.value;
	var dt_from				=	parent.f_query_add_mod.document.formQuotaLimitQryCriteria.p_ord_fm_date.value;
	var dt_to				=	parent.f_query_add_mod.document.formQuotaLimitQryCriteria.p_ord_to_date.value; 
	parent.f_price_detail.location.href="../../ePH/jsp/QuotaLimitQryResult.jsp?patient_id="+patient_id+"&dt_from="+dt_from+"&dt_to="+dt_to+"&drug_code="+drug_code+"&splCode="+splCode;
		}
	}
	
} 



