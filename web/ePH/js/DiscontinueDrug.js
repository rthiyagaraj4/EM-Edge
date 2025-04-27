  var function_id	=   "" ;
var result		=   false ;
var message		=   "" ;
var flag		=   "" ;

function query() {
	
//	var arrCodeDesc = DrugSearch("D","");
//	if (arrCodeDesc != "")
	//	f_query_add_mod.location.href="../../ePH/jsp/DiscontinueDrugAddModify.jsp?mode="+MODE_MODIFY//+"&drug_code="+arrCodeDesc[0];
f_query_add_mod.location.href="../../ePH/jsp/DiscontinueDrugAddModify.jsp?mode="+MODE_INSERT;


}

function apply() {
	var frmObj = f_query_add_mod.document.DiscontinueDrugForm;
	if(!checkIsValidForProceed("discontinuedrugaddmodify")) {
		messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num=";
		return false;
	}

	var mode = frmObj.mode.value;

	if( mode == MODE_MODIFY ) {
		var errorPage	= "../../eCommon/jsp/error.jsp" ;
		var blankObj 	= null ;
		var fields		= new Array ( frmObj.DISCONTINUED_REASON );
		var names		= new Array ( getLabel("Common.reason.label","common_labels") );
		blankObject  = getBlankField( fields, names, messageFrame, errorPage) ;
		if(blankObject==null) {
			eval( formApply( frmObj, PH_CONTROLLER ) ) ;
			messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num="+ message;
			f_query_add_mod.location.href="../../ePH/jsp/DiscontinueDrugAddModify.jsp?mode="+MODE_INSERT;
			if( result ) {
				
				f_query_add_mod.location.href="../../eCommon/html/blank.html";
			}
		}
		else {
			if (frmObj.DISCONTINUED_YN.checked)
				blankObject.focus() ;
		}
	}
}

function reset() {
	f_query_add_mod.location.href="../../eCommon/html/blank.html";
}

function checkIsValidForProceed( urlName ) {
	var url = f_query_add_mod.location.href;
	url = url.toLowerCase();

	if ( (url.indexOf( urlName ) != -1) )
		return true;
	else
		return false;
}

function assignResult( _result, _message, _flag) {
	result1		= _result ;
	message		= _message ;
	flag		= _flag ;
}

function disableReason(obj) {
	var frmObj = document.DiscontinueDrugForm;
	if(obj.checked) {
		obj.value = "Y";
		//frmObj.MANDATE_REASON.style.visibility	= "visible";
		//frmObj.DISCONTINUED_REASON.disabled=false;
		//frmObj.DISCONTINUED_REASON.focus();
	}
	else {
		obj.value = "N";
		//frmObj.MANDATE_REASON.style.visibility	= "hidden";
		//frmObj.DISCONTINUED_REASON.disabled=true;
		//frmObj.DISCONTINUED_REASON.value="";
	}
}
async function PatientEducation(DrugCode)
  {
	    var dialogHeight	= "80vh";
		var dialogWidth		= "75vw";
		var dialogTop		= "300";
		var dialogLeft		= "8";
		var status			= "no";
		var features		= "dialogHeight:" + dialogHeight +"; dialogLeft"+dialogLeft+ "; dialogWidth:" + dialogWidth + "; status: " + status + "; dialogTop :" + dialogTop;
		var arguments		= "";
		var retVal			= await top.window.showModalDialog("../../ePH/jsp/ViewDrugInfo.jsp?DrugCode="+DrugCode,arguments,features);
  }
/*
function onSuccess() {
	var mode = f_query_add_mod.document.DiscontinueDrugForm.mode.value;
	f_query_add_mod.location.href="../../ePH/jsp/DiscontinueDrugAddModify.jsp?mode="+MODE_MODIFY+"&drug_code="+globalCode+"&drug_desc="+globalDesc;
}

function beforePost(xmlStr) {
	alert(xmlStr);
}

function getDrugRelatedInfo( obj ) {
	var mode = document.frames.DiscontinueDrugForm.mode.value;
	if(mode == MODE_MODIFY && obj.value != "") {
		var bean_id		= document.DiscontinueDrugForm.bean_id.value ;
		var bean_name	= document.DiscontinueDrugForm.bean_name.value ;
		var xmlDoc="";
		var xmlHttp = new XMLHttpRequest();

		xmlStr	="<root><SEARCH " ;
		xmlStr += "drug_code=\""+ checkSpl(obj.value) +"\" " ;
		xmlStr +=" /></root>" ;
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open( "POST", "getdataDiscontinueDrug.jsp?bean_id=" + bean_id + "&bean_name=" + bean_name + "&drug_code="+obj.value+"&function_name=DiscontinueDrug", false ) ;
		xmlHttp.send( xmlDoc ) ;
		alert(xmlHttp.responseText);
		//	eval(xmlHttp.responseText) ;

		//	Assigning the values starts from here...
		if (globalDrugRelated[2]!='null')
			document.frames.DiscontinueDrugForm.generic_name.value=globalDrugRelated[2];
		else
			document.frames.DiscontinueDrugForm.generic_name.value="";

		if (globalDrugRelated[3]!='null')
			document.frames.DiscontinueDrugForm.strength_value.value=globalDrugRelated[3];
		else
			document.frames.DiscontinueDrugForm.strength_value.value="";

	if (globalDrugRelated[4]!='null')
		document.frames.DiscontinueDrugForm.form_desc.value=globalDrugRelated[4];
	else
		document.frames.DiscontinueDrugForm.form_desc.value="";

	if (globalDrugRelated[5]!='null')
		document.frames.DiscontinueDrugForm.compound_drug_yn.value=globalDrugRelated[5];
	else
		document.frames.DiscontinueDrugForm.compound_drug_yn.value="";


	if (globalDrugRelated[6]!='null')
		document.frames.DiscontinueDrugForm.pres_base_uom.value=globalDrugRelated[6];
	else
		document.frames.DiscontinueDrugForm.pres_base_uom.value="";

	if (globalDrugRelated[7]!='null')
		document.frames.DiscontinueDrugForm.route_desc.value=globalDrugRelated[7];
	else
		document.frames.DiscontinueDrugForm.route_desc.value="";

	if (globalDrugRelated[8]!='null')
		{
		document.frames.DiscontinueDrugForm.compound_drug_yn.checked=true;
		document.frames.DiscontinueDrugForm.compound_drug_yn.disabled=true;
		}
	else{
		document.frames.DiscontinueDrugForm.compound_drug_yn.checked=false;
	}

	if (globalDrugRelated[9]!='null' && globalDrugRelated[9]=="Y")
		{
		document.frames.DiscontinueDrugForm.discontinued_yn.checked=true;

		//document.frames.DiscontinueDrugForm.compound_drug_yn.disabled=true;
		}
	else{
		alert("yn-"+globalDrugRelated[9]);
		document.frames.DiscontinueDrugForm.discontinued_yn.checked=false;
		document.frames.DiscontinueDrugForm.discontinued_reason.disabled=true;
	}

	if (globalDrugRelated[10]!='null')
		{
	globalreason=globalDrugRelated[10];
	document.frames.DiscontinueDrugForm.discontinued_reason.value=globalDrugRelated[10];
//	document.frames.DiscontinueDrugForm.compound_drug_yn.disabled=true;
		}
	else{
	document.frames.DiscontinueDrugForm.discontinued_reason.value="";
	}


if (globalDrugRelated[9]!='null' && globalDrugRelated[9]=="Y")
		{
		document.frames.DiscontinueDrugForm.discontinued_yn.checked=true;
		document.frames.DiscontinueDrugForm.discontinued_ynH.value=globalDrugRelated[9];

		//document.frames.DiscontinueDrugForm.compound_drug_yn.disabled=true;
		}
	else{
		document.frames.DiscontinueDrugForm.discontinued_yn.checked=false;
		document.frames.DiscontinueDrugForm.discontinued_ynH.value=globalDrugRelated[9];

	}

if (globalDrugRelated[10]!='null')
{
document.frames.DiscontinueDrugForm.discontinued_reason.value=globalDrugRelated[10];
document.frames.DiscontinueDrugForm.discontinued_reasonH.value=globalDrugRelated[10];

//	document.frames.DiscontinueDrugForm.compound_drug_yn.disabled=true;
}
else
{

document.frames.DiscontinueDrugForm.discontinued_reason.value="";
document.frames.DiscontinueDrugForm.discontinued_reasonH.value=globalDrugRelated[10];

}
}
}*/
//**************************************************************************/
/*function addToGlobalDrugRelated(str) {
	globalDrugRelated[index]=str;
	index++;
}*/

/***********************************************************************************/

/************************************************************************************
function DrugCodeDescCall()
{
	var arrCodeDesc=new Array();
	arrCodeDesc=DrugSearch();
}
/*******************************************************************************/



async function searchDrugName1(obj){

	var formObj = document.DiscontinueDrugForm;
	var argumentArray  = new Array() ;
	var dataNameArray  = new Array() ;
	var dataValueArray = new Array() ;
	var dataTypeArray  = new Array() ;
	argumentArray[0]   = formObj.sql_ph_drug_query_select1.value+"'"+formObj.language_id.value+"'";
	argumentArray[1]   = dataNameArray ;
	argumentArray[2]   = dataValueArray ;
	argumentArray[3]   = dataTypeArray ;
	argumentArray[4]   = "1,2";
	argumentArray[5]   = formObj.DRUG_NAME.value ;
	argumentArray[6]   = DESC_LINK ;
	argumentArray[7]   = DESC_CODE ; 
	retVal = await CommonLookup(getLabel("Common.DrugName.label","Common"), argumentArray );
	
	var ret1=unescape(retVal);
	var arr=ret1.split(",");
		 	if(arr[1]==undefined) 
	 		{
		 		arr[0]="";	
		 		arr[1]="";	
	 		}
	if(retVal != null && retVal != "" )  {
		formObj.DRUG_NAME.value = arr[1] ;
		formObj.DRUG_CODE.value = arr[0];
		parent.f_query_add_mod.location.href="../../ePH/jsp/DiscontinueDrugAddModify.jsp?mode="+MODE_MODIFY+"&drug_code="+arr[0];
			
			}

}
