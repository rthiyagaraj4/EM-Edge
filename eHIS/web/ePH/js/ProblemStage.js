 //saved on 07/11/2005
var function_id = "" ;
var resultGlobal = false;
var messageGlobal = "" ;
var flagGlobal = true;
var qry_string = "";

/*************Handle to the Frame 's and the form Object ****************/
var headerDoc			=null;
var detailDoc			=null;
var formObjHeader		=null;
var formObjDetail		=null;
var detailDocUpdate		=null;
var formObjDetailUpdate	=null;
var invalidCode			=null; 
/******************************************************************************/
function create() {
	f_query_add_mod.location.href = "../../ePH/jsp/ProblemStageAddModify.jsp?mode=1&function_id="+function_id;
}
/*************************************************************************************************/
function query() {
f_query_add_mod.location.href="../../ePH/jsp/ProblemStageQueryCriteria.jsp?function_id="+function_id;
}
/*************************************************************************************************/
function apply() {

	if(!proceedOnApply())
    {
        messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num=";
        return false;
    }
	getHandleDetail();
	getHandleHeader();
	getHandleDetailUpdate(); 
	var mode

	if( headerDoc.mode)
		mode = headerDoc.mode
	else 
		mode = detailDoc.mode

	if(mode.value == "2") //in Update mode
	{
		formObjDetail.indicator.value = "O"  // this is been temporarily hardocded as the parameter is only one
		applyModify();
		return ;
	}
	
	var flag		= true ;
	var msgID		= "" ;
	var msgDesc		= "" ;
	var arrIDS		= new Array();
	var size = 0;
	
	formObjDetail.indicator.value = formObjHeader.indicator.value;

	var fields = new Array ( formObjHeader.indicator);
	var names = new Array (getLabel("Common.INDICATOR.label","Common"));
	if(!checkFieldsofMst( fields, names, messageFrame)) {
	  return false;
	}
	
	for(i = 0 ; i < 10 ; i++){
		var flds=new Array(eval("formObjDetail.problem_stage_id"+i));
		var name=new Array("Common.identification.label","Common");
		if(!SpecialCharCheck(flds,name,messageFrame,"M","../../eCommon/jsp/MstCodeError.jsp")){  
			return false
		}
	}							
	
	
	var arrFieldName		=	new Array();
	var arrLegends			=	new Array();
	var arrPKFieldNames		=	new Array();

	arrFieldName[0]			=	"problem_stage_id";
	arrFieldName[1]			=	"problem_stage_short_desc";
	arrFieldName[2]			=	"problem_stage_long_desc";

	arrLegends[0]			=	getLabel("Common.code.label","Common");
	arrLegends[1]			=	getLabel("Common.shortdescription.label","Common");
	arrLegends[2]			=	getLabel("Common.longdescription.label","Common");

	arrPKFieldNames[0]		=	"problem_stage_id";

//	var formObj				=	f_query_add_mod.document.formMasterCode ;
	
	resetDuplicateClass( formObjDetail, arrPKFieldNames );
	var	result1	=	validateMandatoryFields(formObjDetail,arrFieldName,arrLegends,arrPKFieldNames);
	if(result1)
	{
		//alert(eval(formApply(formObjDetail,PH_CONTROLLER)));
		eval(formApply(formObjDetail,PH_CONTROLLER));	

		if(resultGlobal) {
        		messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ messageGlobal;
			onSuccess();
		}else if(invalidCode != "" && invalidCode != "null"){
			showDuplicates(formObjDetail,arrPKFieldNames,invalidCode,"0",messageFrame );
			messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ messageGlobal+":-"+invalidCode;
		}
	}
}

//********************************************************************************************************
function resetColorCode(obj)
{	
	var arrPKFieldNames	=	new Array();      
	var formObj			=	f_query_add_mod.f_query_add_mod_detail.document.Problem_Stage_insert;      
	arrPKFieldNames[0]	=	"problem_stage_id";      
	resetDuplicateClass( formObj, arrPKFieldNames, 0, obj );
}


/******************************************************************************/
function onSuccess() {
	if(flagGlobal == "insert" ){
		f_query_add_mod.location.href = "../../ePH/jsp/ProblemStageAddModify.jsp?mode=1&function_id="+function_id;
	}else{//Update Mode
		f_query_add_mod.document.location.href="../../ePH/jsp/ProblemStageAddModify.jsp?"+qry_string;
	}	
}
/******************************************************************************/
/*function reset() {
	if(f_query_add_mod.f_query_add_mod_header !=null){//Add-Mod Mode
		if(f_query_add_mod.f_query_add_mod_header.document.forms[0].name =="Tick_Sheets_update"){//Update mode
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
*/
function reset() {

	if(f_query_add_mod.f_query_add_mod_header !=null){//Add-Mod Mode

		if(f_query_add_mod.f_query_add_mod_detail !=null){
			if(f_query_add_mod.f_query_add_mod_detail.document.forms[0].name!=null){
				f_query_add_mod.f_query_add_mod_detail.document.forms[0].reset();
			}
		}else if(f_query_add_mod.f_query_add_mod_header.document.forms[0].name =="Tick_Sheets_update"){//Update mode
		getHandleDetailUpdate();
		formObjDetailUpdate.reset();
		return ;
		}
	getHandleDetail();
	getHandleHeader();
	formObjDetail.reset();
		if(	formObjHeader!=null){
			formObjHeader.reset();
		}
	}else{//Query Mode
	
	if(f_query_add_mod.document.forms[0]!=null){
		f_query_add_mod.document.forms[0].reset(); //reset in query mode
	}
	}
	
	messageFrame.document.href ='../../eCommon/jsp/MstCodeError.jsp' ;
}

/******************************************************************************/
function assignResult(res,msg,mod,invCode)
{
	resultGlobal	= res ;
	messageGlobal	= msg ;
	flagGlobal	= mod;
	invalidCode	= invCode ;
}
/******************************************************************************/
function applyModify(){
getHandleDetailUpdate();

qry_string = "mode=2&function_id="+function_id+"&code="+formObjDetailUpdate.problem_stage_id.value
var fields = new Array ( formObjDetailUpdate.problem_stage_short_desc
						 ,formObjDetailUpdate.problem_stage_long_desc);
var names = new Array (getLabel("Common.shortdescription.label","Common"),getLabel("Common.longdescription.label","Common"));
if(checkFieldsofMst( fields, names, messageFrame)) {

		//alert(formApply(formObjDetailUpdate,PH_CONTROLLER));
		eval(formApply(formObjDetailUpdate,PH_CONTROLLER));	
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
if(f_query_add_mod.f_query_add_mod_header == null)
	 return false;
 headerDoc	     =f_query_add_mod.f_query_add_mod_header.document ;	
 formObjHeader   =headerDoc.Problem_Stage_header ;
}
/**********************Detail Handle**********************************/
function getHandleDetail(){
 if(f_query_add_mod.f_query_add_mod_detail == null)
	 return false;
 detailDoc		 =f_query_add_mod.f_query_add_mod_detail.document ;	
 formObjDetail	 =detailDoc.Problem_Stage_insert ;
}
/**********************Detail Handle for Update***************************/
function getHandleDetailUpdate(){
 if(f_query_add_mod.f_query_add_mod_detail == null)
	 return false;
 detailDocUpdate		    =f_query_add_mod.f_query_add_mod_detail.document;
 formObjDetailUpdate		=detailDocUpdate.Problem_Stage_insert ;
}

/*function beforePost(str){
	alert(str);
}*/
function proceedOnApply() {
    var url = f_query_add_mod.location.href;
    url = url.toLowerCase();
    if ( (url.indexOf("blank.html")==-1) && (url.indexOf("problemstagequery")==-1) )
        return true;
    else
        return false;
}
