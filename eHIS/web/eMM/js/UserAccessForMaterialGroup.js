/*
---------------------------------------------------------------------------------------------------------
Date			Edit History    	Name			Rev. Date		Rev. By			Description
---------------------------------------------------------------------------------------------------------
31/3/2021		TFS:15977			Shazana											NMC-JD-SCF-0160
---------------------------------------------------------------------------------------------------------
*/

var xmlDom;
var xmlHttp;
var result		=	false ;
var message		=	"" ;
var flag		=	"" ;
var	function_id	=	"" ;

function assignBean(frmObject) {
	bean_id = frmObject.bean_id.value;
	bean_name = frmObject.bean_name.value;
	//xmlDom = new ActiveXObject("Microsoft.XMLDom");
	//xmlHttp = new ActiveXObject("Microsoft.XMLHTTP");
	
	xmlHttp = new XMLHttpRequest();
	xmlDom  = "";
}


function displayDetail() {
	var errorPage = "../../eCommon/jsp/error.jsp";
	var fields = new Array (document.frmItemClassForStoreHeader.store_code);
	var names = new Array (getLabel("Common.Store.label","Common"));
	var blankObject = checkMMFields( fields, names, parent.parent.messageFrame,errorPage);
	if(blankObject==true) {
		document.frmItemClassForStoreHeader.store_code.disabled = true;
		parent.parent.messageFrame.location.href=errorPage;
		parent.ItemClassForStoreDetailFrame.location.href="../../eST/jsp/ItemClassForStoreDetail.jsp?store_code="+document.frmItemClassForStoreHeader.store_code.value+"&mode="+MODE_INSERT;
	}
	else {
	}
}

function reset1() {
	if(f_query_add_mod.ItemClassForStoreHeaderFrame != null) {
	  f_query_add_mod.location.href="../../eST/jsp/ItemClassForStoreMain.jsp?mode="+MODE_INSERT+"&function_id="+function_id;
	}
	if(f_query_add_mod.document.query_form !=null ) {
		f_query_add_mod.document.query_form.reset();
	}
}

function reset() {
	location.reload();
}


function apply() {
	
	var errorPage = "../../eCommon/jsp/error.jsp";

	var user_id=f_query_add_user.document.Search_form.user_id.value;
	
	var fields = new Array (f_query_add_user.document.Search_form.user_id);
	var names = new Array (getLabel("Common.user.label","Common"));
	var blankObj	=	null;
	var blankObject	=	null;
	blankObject = checkFieldsofMst( fields, names, messageFrame);//,errorPage);
	if(blankObject!=true) {
			f_query_add_user.location.href="../../eMM/jsp/UserAccessForMaterialGroupHeader.jsp?";
			reset();
		//return;
	}
	
	var formObj = f_query_add_mod.document.formUserAccessForMaterialGroup;
	/*if (!selectvalidate()){
		messageFrame.location.href = errorPage+"?err_num="+ getMessage('MIN_ONE_DETAIL_REQUIRED','Common');
		return;
	}*/
	var responseText=formApply(formObj,MM_CONTROLLER);
	eval(responseText) ;
	messageFrame.location.href=errorPage+"?err_num="+ message;
	if(result) {
		onSuccess();
	}
}

function onSuccess() {
	f_query_add_mod.document.location.reload();
}

async function searchCode(target) 
{
	//alert("1");
	var argumentArray  = new Array() ;
	var dataNameArray  = new Array() ;
	var dataValueArray = new Array() ;
	var dataTypeArray  = new Array() ;
	
	var parNameArray  = new Array() ;
	var parValueArray  = new Array() ;
	parNameArray[0] ="~LOCALE_ID`";
	parValueArray[0]=document.forms[0].language_id.value;
	
	//var sql_sm_appl_user= "SELECT appl_user_id code, appl_user_name description FROM	sm_appl_user_lang_vw sm_appl_user where appl_user_id	like UPPER(?) AND UPPER(appl_user_name)	like UPPER(?) AND eff_status='E' AND language_id = '"+document.forms[0].language_id.value+"' ";//15977 start
	if(target.name=="user_name"){
		//argumentArray[0]   = escape(document.forms[0].SQL_SM_APPL_USER_USER_LOOK_UP.value+"'"+document.forms[0].language_id.value+"'");//commented for 15977
		//argumentArray[0]   = escape(sql_sm_appl_user);//15977 END 
		argumentArray[0]   = "";
		argumentArray[4]   = "1,2"; 
	}
	
	argumentArray[1]   = dataNameArray ;
	argumentArray[2]   = dataValueArray ;
	argumentArray[3]   = dataTypeArray ;
	argumentArray[5]   = target.value ;
	argumentArray[6]   = DESC_LINK ;
	argumentArray[7]   = DESC_CODE ; 

	argumentArray[12]  = "SQL_MM_USER_ACCESS_FOR_METERIAL_USER_LOOKUP_SELECT";
	argumentArray[13]  = "eMM.Common.MmRepository";
	argumentArray[14]  = parNameArray;
	argumentArray[15]  = parValueArray;
	
	if(target.name=="user_name"){
		if(!document.forms[0].user_name.readOnly){
			retVal = await CommonLookup( getLabel("Common.user.label","Common"), argumentArray );
			
				
	var ret1=unescape(retVal);
//	alert("ret1"+ret1);
		 	var arr=ret1.split(",");
		 	if(arr[1]==undefined) 
	 		{
		 		arr[0]="";	
		 		arr[1]="";	
	 		}
		}
		else{
		retVal="";
		}
	}
	
	if(retVal != null && retVal != "" )  {
	
		target.value = arr[1] ;
		if(target.name=="user_name")
		{
			document.forms[0].user_id.value=arr[0];
			document.forms[0].userIdSearch.disabled=true;
			document.forms[0].user_name.readOnly=true;
			
		}
	} 
}

function searchDetails(){

	parent.messageFrame.location.href='../../eCommon/jsp/error.jsp';

	var errorPage = "../../eCommon/jsp/error.jsp";
	var user_id=document.forms[0].user_id.value;
	
	var messageFrame=parent.messageFrame;
    var fields	= new Array ( document.forms[0].user_id);
	var names	= new Array ( getLabel("Common.user.label","Common"));
	var blankObject = null;

	blankObject = checkFields( fields, names, messageFrame,errorPage);

	if (blankObject==true){
    	parent.f_query_add_mod.location.href="../../eMM/jsp/UserAccessForMaterialGroupQueryResult.jsp?user_id="+user_id+"&mode="+MODE_INSERT+"&search=new&from=0&to=14";
    }
	} 
function assignResult( _result, _message, _flag ) 
{
	result		=	_result ;
	message		=	_message ;
	flag		=	_flag ;
}
function disableCreate(){
	//parent.frames[0].document.forms[0].create.disabled=true;
}





function userGroupCheck(obj, material_group_code){

	if(obj.checked == true)
   obj.value="Y";
	else
		obj.value="N";
	


	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest() ;
	var xmlStr ="<root><SEARCH ";
	xmlStr +=" /></root>";

	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST","UserAccessForMaterialGroupValidate.jsp?material_group_code="+material_group_code+"&validate=check"+"&selected="+ obj.value,false);
	xmlHttp.send(xmlDoc);
	responseText=xmlHttp.responseText ;
	eval(responseText);
} 

function submitPrevNext(from, to){
	document.forms[0].from.value = from;
	document.forms[0].to.value = to; 
	document.forms[0].submit();
	parent.messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num=";		
}
function selectvalidate(){

	var total_checkboxes =f_query_add_mod.document.formUserAccessForMaterialGroup.total_item_class.value;
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest() ;
	var xmlStr ="<root><SEARCH ";
	xmlStr +=" /></root>";

	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST","UserAccessForMaterialGroupValidate.jsp?total_checkboxes="+total_checkboxes+"&validate=selectesYN",false);
	xmlHttp.send(xmlDoc);
	responseText=xmlHttp.responseText ;
	eval(responseText);
	if(flag=="0")
		return false;
	else 
		return true;
}
