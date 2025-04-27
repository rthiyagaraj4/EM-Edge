/*
*Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
* 
*Warning: This computer program is protected by copyright law and international treaties.
*Unauthorized reproduction or distribution of this program, or any portion of it, 
*may result in severe civil and criminal penalties, and will be prosecuted to 
*the maximum extent possible under the law.
*/
var function_id = "" ;
var resultGlobal = false;
var messageGlobal = "" ;
var flagGlobal = true;

/*************Handle to the Frame 's and the form Object ****************/
var headerDoc			=null;
var detailDoc			=null;
var formObjHeader		=null;
var formObjDetail		=null;
var detailDocUpdate		=null;
var formObjDetailUpdate	=null;
var invalidCode			=null;
/*******************************************************************/
function create() {
	f_query_add_mod.location.href = "../../eOR/jsp/OrganismAddModifyframe.jsp?mode=1&function_id="+function_id;
}
/******************************************************************************/
function query() {
f_query_add_mod.location.href="../../eOR/jsp/OrganismQueryCriteria.jsp?function_id="+function_id;
}
/******************************************************************************/
function apply() {
	if (! checkIsValidForProceed() ) {
		var message  = getOrMessage("NOT_VALID");
		messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ message;
		return false ;
	}
	getHandleDetail();
	getHandleHeader();
	getHandleDetailUpdate();
	var mode = headerDoc.mode;

	if(mode.value == "2") //in Update mode
	{
		applyModify();
		return ;
	}

	var flag		= true ;
	var msgID		= "" ;
	var msgDesc		= "" ;
	var arrIDS		= new Array();
	var size = 0;

	for(i = 0 ; i < 10 ; i++){
		var flds=new Array(eval("formObjDetail.org_code"+i));
		var name=new Array(getLabel("Common.cm.label","Common"));
		if(!SpecialCharCheck(flds,name,messageFrame,"M","../../eCommon/jsp/MstCodeError.jsp")){
			return false
		}
	}


	var arrFieldName		=	new Array();
	var arrLegends			=	new Array();
	var arrPKFieldNames		=	new Array();

	arrFieldName[0]			=	"org_code";
	arrFieldName[1]			=	"org_long_desc";
	arrFieldName[2]			=	"org_short_desc";

	arrLegends[0]			=	getLabel("Common.cm.label","Common");
	arrLegends[1]			=	getLabel("Common.longdescription.label","Common");
	arrLegends[2]			=	getLabel("Common.shortdescription.label","Common");

	arrPKFieldNames[0]		=	"org_code";

	
	resetDuplicateClass( formObjDetail, arrPKFieldNames );

	var	result1	=	validateMandatoryFields(formObjDetail,arrFieldName,arrLegends,arrPKFieldNames);
	
	if(result1)
	{
	//	alert(formApply(formObjDetail,OR_CONTROLLER));
		eval(formApply(formObjDetail,OR_CONTROLLER));
		messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ messageGlobal;
		if(resultGlobal) {
			onSuccess();
		}else if(invalidCode != "" && invalidCode != "null"){
		showDuplicates(formObjDetail,arrPKFieldNames,invalidCode,"0",messageFrame );
		}
	}


}
/*****************************************************************************/
function resetColorCode(obj)
{
	var arrPKFieldNames	=	new Array();
	var formObj			=	f_query_add_mod.f_query_add_mod_detail.document.Org_insert;
	arrPKFieldNames[0]	=	"org_code";
	resetDuplicateClass( formObj, arrPKFieldNames, 0, obj );
	
}


/******************************************************************************/
function onSuccess() {
	if(f_query_add_mod.f_query_add_mod_header.document.forms[0].name == "Org_header"){//insert mode
	getHandleDetail();
	getHandleHeader();
	if(flagGlobal == "insert" ){
	formObjDetail.reset();
	}
	}else{//Update Mode
	f_query_add_mod.document.location.href="../../eOR/jsp/OrganismAddModifyframe.jsp?"+detailDocUpdate.qry_str.value;
	}
}
/******************************************************************************/
function reset() {
	if(f_query_add_mod.f_query_add_mod_header !=null){//Add-Mod Mode
		if(f_query_add_mod.f_query_add_mod_header.document.forms[0].name =="Org_update"){//Update mode
		getHandleDetailUpdate();
		formObjDetailUpdate.reset();
		return ;
		}
	getHandleDetail();
	getHandleHeader();
	formObjDetail.reset();
	formObjHeader.reset();
	}else{//Query Mode
	f_query_add_mod.document.forms[0].reset(); //reset in query mode
	}

	messageFrame.document.href ='../../eCommon/jsp/MstCodeError.jsp' ;
}

/******************************************************************************/
function assignResult(res,msg,mod,invCode){
	resultGlobal	= res ;
	messageGlobal	= msg ;
	flagGlobal		= mod;
	invalidCode		= invCode ;
}
/***************************************************************************/
function applyModify(){
getHandleDetailUpdate();

var fields = new Array ( formObjDetailUpdate.org_long_desc,formObjDetailUpdate.org_short_desc);
var names = new Array ( getLabel("Common.longdescription.label","Common"),getLabel("Common.shortdescription.label","Common"));

if(checkFieldsofMst( fields, names, messageFrame)) {

	//	alert(formApply(formObjDetailUpdate,OR_CONTROLLER));
		eval(formApply(formObjDetailUpdate,OR_CONTROLLER));
		messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ messageGlobal;
		if(resultGlobal) {
			onSuccess();
		}
	}
}
/**************************************************************************/
function resetLower(){
	getHandleDetail();
	formObjDetail.reset();
}
/*********************Header Handle*****************************/
function getHandleHeader(){
	
	 headerDoc	     =f_query_add_mod.f_query_add_mod_header.document ;
	 formObjHeader   =headerDoc.Org_header ;
}
/**********************Detail Handle**********************************/
function getHandleDetail(){
 if(f_query_add_mod.f_query_add_mod_detail == null)
	 return false;
 detailDoc		 =f_query_add_mod.f_query_add_mod_detail.document ;
 formObjDetail	 =detailDoc.Org_insert ;
}
/**********************Detail Handle for Update***************************/
function getHandleDetailUpdate(){
 if(f_query_add_mod.f_query_add_mod_detail == null)
	 return false;
 detailDocUpdate		    =f_query_add_mod.f_query_add_mod_header.document;
 formObjDetailUpdate		=detailDocUpdate.Org_update ;
}
/**********************Check for Valid Operation***************************/
function checkIsValidForProceed()
{
		 var url = f_query_add_mod.location.href;
		url = url.toLowerCase();
		if ( (url.indexOf("queryresult.jsp")==-1) && (url.indexOf("query")==-1)&&(url.indexOf("blank")==-1) )
				return true;
		else
				return false;
}
/****************************************************************************/
/**Reference Pattern for Frame's and form Object For Catalog By section

Menu
	|
	Organism.jsp---->Orgagnism.js
		|
		|------MstToolBar
		|
		|------OrganismAddModifyframe.jsp
		|		|
		|		|---OrganismAdd.jsp													/OrganimsAddModifySingle.jsp		=>modify mode
		|		|		Document ---headerDoc				/Document ---detailDocUpdate		=>modify mode
		|		|		FormObect---formObjHeader			/FormObect---formObjDetailUpdate	=>modify mode
		|		|
		|		|---OrganismAddModify.jsp =>insert mode
		|		|		Document ---detailDoc
		|		|		FormObect---formObjDetail
		|
		|------MessageFrame
		|
**/
