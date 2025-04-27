  //saved on 29/10/2005 
function query(){
	f_query_add_mod.location.href="../../ePH/jsp/QueryPatientsBySpecificDrugFrames.jsp";
}

function reset(){
	var formObj = document.f_query_add_mod.f_query_criteria.queryPatientsBySpecificDrugCriteria;
	//formObj.reset();
	//formObj.generic_name.disabled = false;
	//formObj.drug_name.disabled = false;
	//formObj.drug_name_search.disabled = false;
	//formObj.generic_name_search.disabled = false;
	//document.f_query_add_mod.f_query_result.location.href="../../eCommon/html/blank.html";
	//document.f_query_add_mod.f_query_status.location.href="../../eCommon/html/blank.html";
	location.reload();
}

// lookup for Generic Name
async function searchGenericName(){

	var formObj = document.queryPatientsBySpecificDrugCriteria;
	var argumentArray  = new Array() ;
	var dataNameArray  = new Array() ;
	var dataValueArray = new Array() ;
	var dataTypeArray  = new Array() ;
//	var id=formObj.locale.value;

	var language_id=document.queryPatientsBySpecificDrugCriteria.locale.value;

	argumentArray[0]   = document.queryPatientsBySpecificDrugCriteria.sql_ph_drug_search_select1.value+"'"+language_id+"'";
  	argumentArray[1]   = dataNameArray ;
	argumentArray[2]   = dataValueArray ;
	argumentArray[3]   = dataTypeArray ;
	argumentArray[4]   = "1,2";



/*	argumentArray[0]   = formObj.sql_ph_drug_search_select1.value;
	argumentArray[1]   = dataNameArray ;
	argumentArray[2]   = dataValueArray ;
	argumentArray[3]   = dataTypeArray ;
	argumentArray[4]   = "1,2";
*/ 

	argumentArray[5]   = formObj.generic_name.value ;
	argumentArray[6]   = DESC_LINK ;
	argumentArray[7]   = DESC_CODE ; 
	retVal= await  CommonLookup(getLabel("Common.GenericName.label","Common"), argumentArray ); 
	var ret1=unescape(retVal);
 	arr=ret1.split(",");

	if(retVal != null && retVal != "" )  {
		formObj.generic_name.value = arr[1] ;
		formObj.generic_id.value = arr[0];
		
		formObj.generic_name.disabled  = true;
		formObj.generic_name_search.disabled = true;

		//formObj.drug_name.value = "" ;
		//formObj.drug_code.value = "" ;
		
		//formObj.drug_name.disabled  = false;
		//formObj.drug_name_search.disabled = false;
	}
}

// lookup for Drug Name
async function searchDrugName(){
	var formObj = document.queryPatientsBySpecificDrugCriteria;

	var argumentArray  = new Array() ;
	var dataNameArray  = new Array() ;
	var dataValueArray = new Array() ;
	var dataTypeArray  = new Array() ;
	var language_id=document.queryPatientsBySpecificDrugCriteria.locale.value;

	argumentArray[0]   = document.queryPatientsBySpecificDrugCriteria.sql_ph_drug_search_select2.value+"'"+language_id+"'"; 
	argumentArray[1]   = dataNameArray ;
	argumentArray[2]   = dataValueArray ;
	argumentArray[3]   = dataTypeArray ;
	argumentArray[4]   = "2,3";
	argumentArray[5]   = formObj.drug_name.value ;

/*	argumentArray[0]   = formObj.sql_ph_drug_search_select2.value;
	argumentArray[1]   = dataNameArray ;
	argumentArray[2]   = dataValueArray ;
	argumentArray[3]   = dataTypeArray ;
	argumentArray[4]   = "1,2";
	argumentArray[5]   = formObj.drug_name.value ;
	*/

	argumentArray[6]   = DESC_LINK ;
	argumentArray[7]   = DESC_CODE ; 
	retVal= await CommonLookup(getLabel("Common.DrugName.label","Common"), argumentArray );
	var ret1=unescape(retVal);
 	arr=ret1.split(",");
	if(retVal != null && retVal != "" )  {
		formObj.drug_name.value = arr[1] ;
		formObj.drug_code.value = arr[0];
		
		formObj.drug_name.disabled  = true;
		formObj.drug_name_search.disabled = true;

		//formObj.generic_name.value = "";
		//formObj.generic_id.value = "";
		
		//formObj.generic_name.disabled  = false;
		//formObj.generic_name_search.disabled = false;
	}
}
function validateDate(){
	var formObj = document.queryPatientsBySpecificDrugCriteria;
	var locale				=	formObj.locale.value;
	var dt_from				=	convertDate(formObj.dt_from.value,'DMY',locale,"en"); 
	var dt_to				=	convertDate(formObj.dt_to.value,'DMY',locale,"en");
	if (dt_from.value!="" && dt_to.value!=""){
		if(!doDateCheck(formObj.dt_from,formObj.dt_to,parent.parent.messageFrame)){
			formObj.dt_to.select();
			return false;
		}else{
			parent.parent.messageFrame.location.href="../../eCommon/jsp/error.jsp?err_num=";
		
		}
	}
	parent.parent.messageFrame.location.href="../../eCommon/jsp/error.jsp?err_num=";
	return true;
}

function callResultPage(){
	if (!validateDate())
	{
		return;
	}
	var formObj	=	document.queryPatientsBySpecificDrugCriteria;
	
	var locale				=	formObj.locale.value;
	var dt_from				=	convertDate(formObj.dt_from.value,'DMY',locale,"en"); 
	var dt_to				=	convertDate(formObj.dt_to.value,'DMY',locale,"en");
	var generic_name	=	formObj.generic_name.value;
	var generic_id	=	formObj.generic_id.value;
	var drug_name	=	formObj.drug_name.value;
	var drug_code	=	formObj.drug_code.value;
	var pat_class = formObj.pat_class.value.trim();
	if(pat_class=="---Select---")
	{
		pat_class="";
	}
	var status		=	formObj.status.value;
	var fields= new Array (formObj.dt_from,formObj.dt_to);///added for performance tuning start
   	var names= new Array (getLabel("Common.fromdate.label","Common"),getLabel("Common.todate.label","Common"));
	if(checkFields( fields,names,parent.parent.messageFrame) ) 
	{///added for performance tuning end
	 if(drug_name!=""||(generic_name!="")||(pat_class!="   ---Select---   "))
	 {
     parent.f_query_result.location.href="../../ePH/jsp/QueryPatientsBySpecificDrugResult.jsp?dt_from="+dt_from+"&dt_to="+dt_to+"&generic_name="+generic_name+"&generic_id="+generic_id+"&drug_code="+drug_code+"&pat_class="+pat_class+"&status="+status+"&drug_name="+drug_name;
	}
	else
	{	
		parent.f_query_result.location.href="../../ePH/jsp/QueryPatientsBySpecificDrugResult.jsp?dt_from="+dt_from+"&dt_to="+dt_to+"&status="+status;
	}
	}
}

async function showDrugDetails(patient_id,order_id,order_line_num,sr_no){

	/*alert(patient_id);
	alert(order_id);
	alert(order_line_num);
	alert(sr_no);*/

	var dialogHeight= "400px" ;
	var dialogWidth	= "700px" ;
	var dialogTop = "10" ;
	var center = "1" ;
	var status="no";
	var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop;
	var arguments	= "" ;
	var retVal = await window.showModalDialog("../../ePH/jsp/QueryPatientsBySpecificDrugDetails.jsp?patient_id="+patient_id+"&sr_no="+sr_no+"&order_id="+order_id+"&order_line_num="+order_line_num,arguments,features);
}
