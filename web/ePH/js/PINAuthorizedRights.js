  
var function_id = "PIN_AUTHORIZED_RIGHT" ;
var resultGlobal = false;
var messageGlobal = "" ;
var flagGlobal = true;
var qry_string = "";
var headerDoc			=null;
var detailDoc			=null;
var formObjHeader		=null;
var formObjDetail		=null;
var detailDocUpdate		=null;
var formObjDetailUpdate	=null;
var invalidCode			=null; 


function create() {
	f_query_add_mod.location.href = "../../ePH/jsp/PINAuthorizedRightsDetail.jsp?mode=1&function_id="+function_id;
}
function query() {
f_query_add_mod.location.href="../../ePH/jsp/PINAuthorizedRightsQueryCriteria.jsp?function_id="+function_id;
}
async function show_uesr_id_window(target, cnt,desc,eff_status){ 
	var formObjDetail= parent.f_query_add_mod.document.pin_auth_rights_insert;    
	var argumentArray  = new Array() ;
	var dataNameArray  = new Array() ;
	var dataValueArray = new Array() ;
	var dataTypeArray  = new Array() ;
var language_id = document.pin_auth_rights_insert.locale.value.toUpperCase();

argumentArray[0]   = "SELECT APPL_USER_ID CODE , APPL_USER_NAME DESCRIPTION FROM SM_APPL_USER_LANG_VW SM_APPL_USER WHERE PIN_NO IS NOT NULL AND UPPER(APPL_USER_ID) LIKE UPPER(?) AND UPPER(APPL_USER_NAME) LIKE UPPER(?) AND UPPER(LANGUAGE_ID) = '"+language_id+"'";
argumentArray[1]   = dataNameArray ;
argumentArray[2]   = dataValueArray ;
argumentArray[3]   = dataTypeArray ;
argumentArray[4]   = "1,2";
	/*argumentArray[0]   = formObjDetail.user_id_sql.value+"'"+formObjDetail.language_id.value+"'";
	argumentArray[1]   = dataNameArray ;
	argumentArray[2]   = dataValueArray ;
	argumentArray[3]   = dataTypeArray ;
	argumentArray[4]   = "1,2";
	*/

	argumentArray[5]   = target.value ;
	argumentArray[6]   = CODE_LINK ;
	argumentArray[7]   = CODE_DESC ; 

	retVal = await CommonLookup( getLabel("Common.username.label","Common"), argumentArray ); 	
	var ret1=unescape(retVal);
		 	var arr=ret1.split(",");
		 	if(arr[1]==undefined) 
	 		{
		 		arr[0]="";	
		 		arr[1]="";	
	 		}
	if(retVal != null && retVal != ""){
		target.value = arr[0];
		desc.value   = arr[1];
		eff_status.checked=true;
		eff_status.value='E';
		
	}
	
}

function getHandleDetail(){
 if(f_query_add_mod.f_query_add_mod_detail == null)
	 return false;
 detailDoc		 =f_query_add_mod.document ;	
 formObjDetail	 =detailDoc.pin_auth_rights_insert ;
}

function clearvalues(user_id,User_name,select)
{
    user_id.value    ="";
	user_id.color='#FFFFFF'
	User_name.value  ="";
	select.value     ='D';
	show_uesr_id_window();

  
}

function assignResult(res,msg,mod,invCode){
	resultGlobal	= res ;
	messageGlobal	= msg ;
	flagGlobal		= mod;
	invalidCode		= invCode ;
}

function reset(){
	f_query_add_mod.document.forms[0].reset();
	messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num";
}
function onSuccess(mode)
{

if(mode=="0"){
	f_query_add_mod.location.href = "../../ePH/jsp/PINAuthorizedRightsDetail.jsp?mode=1&function_id="+function_id;
}
else f_query_add_mod.document.location.reload();
}
/*THIS FUNCTION IS USED BY THE QUERY RESULT PAGE TO RETURN VALUES BASED ON SELECTED VALUE */
function Modify(obj,obj1)
{
	var user_id=obj;
	var user_name=obj1;
	parent.f_query_add_mod.location="../../ePH/jsp/PINAuthorizedRightsDetail.jsp?function_id="+function_id+"&mode="+MODE_MODIFY+"&user_id="+user_id+"&user_name="+user_name;
}
/**********************************************************************************/

function deleterecord() {

	if ( !checkIsValidForProceed( "pinauthorizedrightsdetail" ) ) {
		messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num=";
		return false;
	}
	else {
		
		var formObjDetail= f_query_add_mod.document.pin_auth_rights_insert;
		if(formObjDetail.mode.value=='2')
		{
			var fields = new Array ( formObjDetail.user_id);
		
			var names = new Array (getLabel("Common.username.label","Common"));		

			if(checkFieldsofMst( fields, names, messageFrame)){
				if (f_query_add_mod.document.pin_auth_rights_insert.mode.value == '2') {
					f_query_add_mod.document.pin_auth_rights_insert.mode.value = MODE_DELETE;
					var confirm_val = window.confirm(getMessage("DELETE_RECORD","Common"));
				//if (confirm(f_query_add_mod.getMessage("DELETE_RECORD")))
					if(confirm_val){
						eval(formApply(formObjDetail,PH_CONTROLLER));
						if(messageGlobal=="PH_NO_SERVICE_FOUND"){
							messageGlobal = getMessage("PH_NO_SERVICE_FOUND","PH");
						}
						f_query_add_mod.location.href="../../eCommon/html/blank.html";
						messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ messageGlobal;
						if(resultGlobal) {
							onSuccess();
						}
					}else {
						f_query_add_mod.document.pin_auth_rights_insert.mode.value = MODE_MODIFY;
						messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num=";
						return false;
					}
				}
				else {
				messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num=";
				return false;
				}
			}
		}
		else 
		{
			messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num=";
			return false;
		}
	}
}



function checkIsValidForProceed( urlName ) {
	var url = f_query_add_mod.location.href;
	url = url.toLowerCase();
	if ( (url.indexOf( urlName ) != -1) )
		return true;
	else
		return false;
}




function apply() {

	if ( !checkIsValidForProceed( "pinauthorizedrightsdetail" ) ) {
		messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num=";
		return false;
	}
	var formObjDetail= f_query_add_mod.document.pin_auth_rights_insert;    
	var mode = formObjDetail.mode.value;
	
	if(mode != "2"){
	var arrFieldName		=	new Array();
	var arrLegends			=	new Array();
	var arrPKFieldNames		=	new Array();

	arrFieldName[0]			=	"user_id";
	arrLegends[0]			=	"User_name"; 
	arrPKFieldNames[0]		=	"user_id";

	var	result1	= validateMandatoryFields(formObjDetail,arrFieldName,arrLegends,arrPKFieldNames);

	if(result1)
	{
	
//		alert(formApply(formObjDetail,PH_CONTROLLER));
		eval(formApply(formObjDetail,PH_CONTROLLER));	
		if(messageGlobal=="PH_NO_SERVICE_FOUND"){
		messageGlobal = getMessage("PH_NO_SERVICE_FOUND","PH");
		}
		messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ messageGlobal;

		if(resultGlobal) {
			onSuccess();
		}else if(invalidCode != "" && invalidCode != "null"){
			showDuplicates(formObjDetail,arrPKFieldNames,invalidCode,"0",messageFrame);
			messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ messageGlobal+":-"+invalidCode;
		}
	}

	}else{
		messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num=";
	}
}
