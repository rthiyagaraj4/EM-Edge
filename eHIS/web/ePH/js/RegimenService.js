 
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
/*******************************************************************/
function create() {
	f_query_add_mod.location.href = "../../ePH/jsp/RegimenServiceAddModify.jsp?mode=1&function_id="+function_id;
}
/******************************************************************************/
function query() {
f_query_add_mod.location.href="../../ePH/jsp/RegimenServiceQueryCriteria.jsp?function_id="+function_id;
}
/******************************************************************************/
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
		var frmobj	= f_query_add_mod.f_query_add_mod_detail.document.Regimen_service_insert;
		if(frmobj.regimen_yn.checked==false && frmobj.tpn_yn.checked==false){
			messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ getMessage("REGIMEN_OR_TPN_MAND","PH");						
			return;
		}
		
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
	var names = new Array (getLabel("Common.INDICATOR.label","PH"));
	if(!checkFieldsofMst( fields, names, messageFrame)) {
	  return false;
	}
	
/*	for(i = 0 ; i < 10 ; i++){
		var flds=new Array(eval("formObjDetail.service_code"+i));
		var name=new Array("Code");
		if(!SpecialCharCheck(flds,name,messageFrame,"M","../../eCommon/jsp/MstCodeError.jsp")){  
			return false
		}
	}							
	*/

	
	var arrFieldName		=	new Array();
	var arrLegends			=	new Array();
	var arrPKFieldNames		=	new Array();

	arrFieldName[0]			=	"service_desc";

	arrLegends[0]			=	getLabel("Common.service.label","Common"); 

	arrPKFieldNames[0]		=	"service_desc";

//	var formObj				=	f_query_add_mod.document.formMasterCode ;
	
	resetDuplicateClass( formObjDetail, arrPKFieldNames );
	
	var	result1	=	validateMandatoryFields(formObjDetail,arrFieldName,arrLegends,arrPKFieldNames);

	if(result1){
		//alert(formApply(formObjDetail,PH_CONTROLLER));
		eval(formApply(formObjDetail,PH_CONTROLLER));	
		if(messageGlobal=="PH_NO_SERVICE_FOUND"){
			messageGlobal = getMessage("PH_NO_SERVICE_FOUND","PH");
		}

		messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ messageGlobal;
		
		if(resultGlobal) {
			onSuccess();
		}
		else if(invalidCode != "" && invalidCode != "null"){
			showDuplicates(formObjDetail,arrPKFieldNames,invalidCode,"0",messageFrame );
			messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ messageGlobal+":-"+invalidCode;
		}
	}

	var frmobj	= f_query_add_mod.f_query_add_mod_detail.document.Regimen_service_insert;
	for(i = 0 ; i < 10 ; i++){
		if(eval("frmobj.service_desc"+i).value != ""){

				if(eval("frmobj.regimen_yn"+ i).checked==false && eval("frmobj.tpn_yn" + i).checked==false){
						messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ getMessage("REGIMEN_OR_TPN_MAND","PH");						
					}
		}
	}

	
}

function resetColorCode(obj)
{	
	var arrPKFieldNames	=	new Array();      
	var formObj			=	f_query_add_mod.f_query_add_mod_detail.document.Regimen_service_insert;      
	arrPKFieldNames[0]	=	"service_desc";      
	resetDuplicateClass( formObj, arrPKFieldNames, 0, obj );
}


/******************************************************************************/
function onSuccess() {
	if(flagGlobal == "insert" ){
		f_query_add_mod.location.href = "../../ePH/jsp/RegimenServiceAddModify.jsp?mode=1&function_id="+function_id;
	}else{//Update Mode
		f_query_add_mod.document.location.href="../../ePH/jsp/RegimenServiceAddModify.jsp?"+qry_string;
	}	
}
/******************************************************************************/
function reset() {

	if(f_query_add_mod.f_query_add_mod_header !=null){//Add-Mod Mode

		if(f_query_add_mod.f_query_add_mod_detail !=null){
			if(f_query_add_mod.f_query_add_mod_detail.document.forms[0].name!=null){
				f_query_add_mod.f_query_add_mod_detail.document.forms[0].reset();
			}
		}
		else if(f_query_add_mod.f_query_add_mod_header.document.forms[0].name =="Tick_Sheets_update"){//Update mode
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
	}
	else{//Query Mode

		if(f_query_add_mod.document.forms[0]!=null){
			f_query_add_mod.document.forms[0].reset();
		}//reset in query mode
	}
	messageFrame.document.href ='../../eCommon/jsp/MstCodeError.jsp' ;
}

/******************************************************************************/
function assignResult(res,msg,mod,invCode){
	resultGlobal	= res ;
	messageGlobal	= msg ;
	flagGlobal		= mod;
	if( flagGlobal == 'Duplicate'){
		dupCode = invCode.split(',');
		var dupDesc="";
		//var formObj = parent.frames[1].frames[1].frames[1].document.forms[0];
		var formObj = parent.frames[2].frames[1].frames[1].document.forms[0];
		for(j=0; j<dupCode.length; j++){
			for(i = 0 ; i < 10 ; i++){
				if(eval("formObj.service_desc"+i).value != ""){
					if(eval("formObj.service_code"+i).value == dupCode[j])
						dupDesc += eval("formObj.service_desc"+i).value+", ";
				}
			}
		}
		dupDesc = dupDesc.substring(0,dupDesc.length-2);
		invalidCode		= dupDesc ;
	}
	else
		invalidCode		= invCode ;
}
/******************************************************************************/
function applyModify(){
	getHandleDetailUpdate();
	qry_string = "mode=2&function_id="+function_id+"&code="+formObjDetailUpdate.service_code.value+"&desc="+escape(formObjDetailUpdate.service_code_desc.value);

	//alert(formApply(formObjDetailUpdate,PH_CONTROLLER));
	eval(formApply(formObjDetailUpdate,PH_CONTROLLER));	
	messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ messageGlobal;

	if(resultGlobal) {
		onSuccess();
	}
}

function activateRegimen(count){
	getHandleDetail();
	eval("formObjDetail.regimen_yn"+count).checked = true;
}

async function show_service_code_window(target, codeobj, cnt){
	getHandleDetail();

	var argumentArray  = new Array() ;
	var dataNameArray  = new Array() ;
	var dataValueArray = new Array() ;
	var dataTypeArray  = new Array() ;


	argumentArray[0]   = formObjDetail.service_code_sql.value;
	argumentArray[1]   = dataNameArray ;
	argumentArray[2]   = dataValueArray ;
	argumentArray[3]   = dataTypeArray ;
	argumentArray[4]   = "1,2";
	argumentArray[5]   = target.value ;
	argumentArray[6]   = CODE_LINK ;
	argumentArray[7]   = CODE_DESC ; 

	retVal=await CommonLookup(getLabel("Common.service.label","Common"), argumentArray );

	if(retVal != null && retVal != ""){
		var ret1 =unescape(retVal);
			var arr=ret1.split(",");
		 	if(arr[1]==undefined) 
	 		{
		 		arr[0]="";	
		 		arr[1]="";	
	 		}
		target.value = arr[1];
		codeobj.value = arr[0];
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
 formObjHeader   =headerDoc.Regimen_service_header ;
}
/**********************Detail Handle**********************************/
function getHandleDetail(){
 if(f_query_add_mod.f_query_add_mod_detail == null)
	 return false;
 detailDoc		 =f_query_add_mod.f_query_add_mod_detail.document ;	
 formObjDetail	 =detailDoc.Regimen_service_insert ;
}
/**********************Detail Handle for Update***************************/
function getHandleDetailUpdate(){
	
 if(f_query_add_mod.f_query_add_mod_detail == null)
	 return false;
 detailDocUpdate		    =f_query_add_mod.f_query_add_mod_detail.document;
 formObjDetailUpdate		=detailDocUpdate.Regimen_service_insert ;
}

/*function beforePost(str){
	alert(str);
}*/
function proceedOnApply() {
    var url = f_query_add_mod.location.href;
    url = url.toLowerCase();
    if ( (url.indexOf("blank.html")==-1) && (url.indexOf("regimenservicequery")==-1) )
        return true;
    else
        return false;
}
