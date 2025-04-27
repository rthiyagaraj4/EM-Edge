 //saved on 29/10/2005
function query() {
	f_query_add_mod.location.href="../../ePH/jsp/QueryDrugCatgLinkFrames.jsp";
}

function reset() {

	if ( f_query_add_mod.f_query_result.document) {
		var formObj = f_query_add_mod.f_query_criteria.document.formQueryDrugCatgLinkCriteria;
		formObj.reset();
		formObj.drug_name.value = '';
        formObj.DRUG_CODE.value = '';
		f_query_add_mod.f_query_result.location.href="../../eCommon/html/blank.html";
		formObj.drug_name.disabled		= false;
		formObj.DRUG_SEARCH.disabled	= false;
	}
}

/*
function searchDrugName1(mode) {
	var continueFlag = false;
	var formObj = parent.frames[0].document.formQueryDrugCatgLinkCriteria;

	if ( (mode == '1' && formObj.DRUG_NAME.value != "" ) || mode == '2')
		continueFlag = true;
	if (continueFlag) {
		var argumentArray  = new Array() ;
		var dataNameArray  = new Array() ;
		var dataValueArray = new Array() ;
		var dataTypeArray  = new Array() ;
		argumentArray[0]   = formObj.SELECT_SQL.value;
		argumentArray[1]   = dataNameArray ;
		argumentArray[2]   = dataValueArray ;
		argumentArray[3]   = dataTypeArray ;
		argumentArray[4]   = "1,2";
		argumentArray[5]   = formObj.DRUG_NAME.value ;
		argumentArray[6]   = DESC_LINK ;
		argumentArray[7]   = DESC_CODE ;
		retVal = await CommonLookup( "Drug Name", argumentArray );

		if(retVal != null && retVal != "" )  {
			formObj.DRUG_CODE.value			= retVal[0];
			formObj.DRUG_NAME.value			= retVal[1];
			formObj.DRUG_NAME.disabled		= true;
			formObj.DRUG_SEARCH.disabled	= true;
		}
		else {
			formObj.DRUG_NAME.value			= "";
		}
	}

}
*/
async function searchDrugName1(obj){

	var formObj = parent.frames[0].document.formQueryDrugCatgLinkCriteria;
	var argumentArray  = new Array() ;
	var dataNameArray  = new Array() ;
	var dataValueArray = new Array() ;
	var dataTypeArray  = new Array() ;
	argumentArray[0]   = formObj.SELECT_SQL.value+"'"+formObj.language_id.value+"'";
	argumentArray[1]   = dataNameArray ;
	argumentArray[2]   = dataValueArray ;
	argumentArray[3]   = dataTypeArray ;
	argumentArray[4]   = "1,2";
	argumentArray[5]   = formObj.drug_name.value ;
	argumentArray[6]   = DESC_LINK ;
	argumentArray[7]   = DESC_CODE ; 

	retVal = await CommonLookup( getLabel("Common.DrugName.label","Common"), argumentArray );
	//alert("retval"+retVal);
	//alert("retVal[0]"+retVal[0]);
	//alert("retVal[1]"+retVal[1]);
	var str =unescape(retVal);
	var arr = str.split(",");
	if(retVal != null && retVal != "" )  {
			formObj.DRUG_CODE.value			= arr[0];
			formObj.drug_name.value			= arr[1];
			formObj.drug_name.disabled		= true;
//			formObj.DRUG_SEARCH.disabled	= true;
//		obj.disabled	=	true;
	}

}
function callResultPage1()	{
	var formObj		= parent.frames[0].document.formQueryDrugCatgLinkCriteria;
	var drug_code	= formObj.DRUG_CODE.value;
	var drug_name1	= formObj.drug_name.value;
	var drug_class	= formObj.DRUG_CLASS.value;
	var linked		= "";

	if (formObj.LINKED_OR_NOT[0].checked)
		linked = formObj.LINKED_OR_NOT[0].value;
	else if (formObj.LINKED_OR_NOT[1].checked)
		linked = formObj.LINKED_OR_NOT[1].value;
	parent.frames[1].location.href="../../ePH/jsp/QueryDrugCatgLinkResult.jsp?drug_code="+drug_code+"&drug_class="+drug_class+"&drug_name="+drug_name1+"&linked="+linked;
/*	formObj.DRUG_NAME.disabled		= true;
	formObj.DRUG_SEARCH.disabled	= true;
	formObj.DRUG_CLASS.disabled		= true;
	formObj.SEARCH.disabled			= true;*/

	//showWorksheetForIVAdmixture();
}


/*function CallStock(){
	alert("Call Stock...");
	var dialogHeight= "32" ;
	var dialogWidth	= "50" ;
	var dialogTop = "60" ;
	var center = "1" ;
	var status="no";
	var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop;
	var arguments	= "" ;
	var retVal = window.showModalDialog("../../ePH/jsp/DIspQueueStkAvlFrames.jsp?",arguments,features);

}*/
