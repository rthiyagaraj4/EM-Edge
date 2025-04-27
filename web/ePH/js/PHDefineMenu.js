/**	
* 	Application		:	eHIS/ePH
*	File name       :   PHDefineMenu.js   	
*	Created By		:	Gangadharan S
*	Created On		:	Thursday, February 21, 2013  
*/

function create(){   
	f_query_add_mod.location.href="../../ePH/jsp/PHDefineMenu.jsp?mode="+MODE_INSERT+ "&function_id=" + function_id;
}  
function query(){
	f_query_add_mod.location.href="../../ePH/jsp/PHDefineMenuQueryCriteria.jsp";
}
function apply(){	
	var formObj	=	f_query_add_mod.document.formPHDefineMenu ;

	if(formObj!=null){
		var fields = new Array (formObj.user_id,formObj.desktop_id, formObj.desktop_desc);
		var names = new Array ( f_query_add_mod.getLabel("Common.user.label",'common'),f_query_add_mod.getLabel("ePH.DesktopId.label",'PH'),f_query_add_mod.getLabel("Common.description.label",'common') );
		
		var blankObject = checkFields( fields, names, messageFrame);
		if(blankObject==true){		
			var responseText = formApply(formObj, PH_CONTROLLER);
			eval(responseText);
			if( result ){ 	
				messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num=" + message ;
				onSuccess();
			}
			else{
				messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num=" + message ;
				return;
			}
		}
	}
	else{	
		messageFrame.location.href='../../eCommon/jsp/error.jsp?err_num=&err_value=0';
		return false;
	}
	
}
function onSuccess(){
	f_query_add_mod.location.reload();	
}
function Modify(obj){ 
	var user_name			=	obj.cells[0].innerText;
	var user_id				=	obj.cells[1].innerText;

	document.location.href	=	"../../ePH/jsp/PHDefineMenu.jsp?function_id="+parent.function_id+"&mode="+MODE_MODIFY+"&user_id="+user_id+"&user_name="+user_name;

}
function assignResult( _result, _message, _flag ){
	result		=	 _result ;
	message		=	_message ;
	flag		=	_flag ;
}

function reset(){
	if(f_query_add_mod.document.forms[0]){
		f_query_add_mod.document.forms[0].reset();
		if(f_query_add_mod.document.forms[0].name == 'formPHDefineMenu'){
			f_query_add_mod.document.forms[0].userIdSearch.disabled=false;
			f_query_add_mod.document.forms[0].user_name.readOnly=false;
		}
	}
}


function CheckSpecChar(event){
	var strCheck = '0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ_ ';
	var whichCode = (window.Event) ? event.which : event.keyCode;
	key = String.fromCharCode(whichCode);  // Get key value from key code
	if (strCheck.indexOf(key) == -1) return false;  // Not a valid key
	if( (event.keyCode >= 97) && (event.keyCode <= 122) )
		return (event.keyCode);
	return true ;
}
/*
function fun_chk(){
	var formObj = document.formPHDefineMenu;
	if(formObj.root_menu_yn.checked==true)
	{
		document.getElementById("root").style.display="inline";
		formObj.root_menu_yn.value= "Y";				
	}
	else
	{
		document.getElementById("root").style.display="none";
		formObj.root_menu_yn.value="N";
		formObj.desktop_yn.checked=false;
		formObj.desktop_yn.value="N";
	}
}
function func_desktop_check()
{
	var formObj = document.formPHDefineMenu;
	if(formObj.desktop_yn.checked==true){
			formObj.desktop_yn.value="Y";
	}
	else{
		formObj.desktop_yn.value="N";
	}
}*/
function func_enable_check()
{
	var formObj = document.formPHDefineMenu;
	if(formObj.eff_status.checked==true){
			formObj.eff_status.value="E";
	}
	else{
		formObj.eff_status.value="D";
	}
}
async function searchCode(target) {
	//if(target.value != ""){//if condtion commented for for IN072614
		var argumentArray = new Array();
		var dataNameArray = new Array();
		var dataValueArray = new Array();
		var dataTypeArray = new Array();
		var sql = document.forms[0].SQL_ST_USER_LOOKUP_USERACCESS.value + "'" + document.forms[0].language_id.value + "'";
		if (target.name == "user_name") {
			argumentArray[0] = sql;
			argumentArray[4] = "1,2"; 
		}
		argumentArray[1] = dataNameArray;
		argumentArray[2] = dataValueArray;
		argumentArray[3] = dataTypeArray;
		argumentArray[5] = target.value;
		argumentArray[6] = DESC_LINK;
		argumentArray[7] = DESC_CODE;
		if (target.name == "user_name") {
			if (!document.forms[0].user_name.readOnly) {
				retVal =await CommonLookup(getLabel("Common.user.label", "Common"), argumentArray);
				var ret1=unescape(retVal);
					 	var arr=ret1.split(",");
					 	if(arr[1]==undefined) 
				 		{
					 		arr[0]="";	
					 		arr[1]="";	
				 		}
			} else {
				retVal = "";
			}
		}
		if (retVal != null && retVal != "") {
			target.value = arr[1];
			if (target.name == "user_name") {
				document.forms[0].user_id.value = arr[0];
				document.forms[0].userIdSearch.disabled = true;
				document.forms[0].user_name.readOnly = true;
			}
		}
	//}
		//else condtion added for IN072614
		else {
			//target.value = ""; //Commented for MO-CRF-20169
			//target.focus();
			 return false;
		}
		
}

function defDesc(obj){
	if(obj.value!="")
		document.formPHDefineMenu.desktop_desc.value= obj.options[obj.selectedIndex].text;
	else
		document.formPHDefineMenu.desktop_desc.value= "";
}
