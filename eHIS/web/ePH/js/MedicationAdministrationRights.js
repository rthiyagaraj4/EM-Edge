
/*
---------------------------------------------------------------------------------------------------------------------------------	
	Date		Edit History	Name		Rev.Date   	Rev.By 		Description
--------------------------------------------------------------------------------------------------------------------------------

28/11/2019        IN059899        PRATHYUSHA                          JD-CRF-0200
-------------------------------------------------------------------------------------------------------------------------------
*/
var function_id = "";
var bean_id = "";
var bean_name = "";
var xmlDoc;
var xmlDom;
var xmlHttp;
var checkArray = new Array();
var obj=null;

function create(){		//ADDED FOR JD-CRF-0200
	f_query_add_mod.location.href = "../../ePH/jsp/MedicationAdministrationRightsMain.jsp?mode="+MODE_INSERT+"&function_id="+function_id;
}

function query() {
	
	f_query_add_mod.location.href="../../ePH/jsp/MedicationAdministrationRightsQueryCriteria.jsp?function_id="+function_id+"&mode="+MODE_MODIFY;
	
}


function apply()
{
	//ADDED FOR JD-CRF-0200

	if(!proceedOnApply())
    {
        messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num=";
        return false;
    }
		var formObj		=	f_query_add_mod.MedicationAdministrationRightsHeaderFrame.document.Search_form;
	
	var blankObject	=	null;
	
	var fields		=	new Array(formObj.user_name);
	
	var fieldNames	=	new Array(getLabel("Common.user.label","Common"));
	
	var queryString =	"";
	var errorPage	=	"../../eCommon/jsp/error.jsp";
	
	blankObject		=	getBlankField( fields, fieldNames, messageFrame);
	
	if(blankObject==null) {
		

		eval(formApply(f_query_add_mod.MedicationAdministrationRightsListFrame.document.MedicationAdministrationRightsListForm,PH_CONTROLLER));
	
	messageFrame.location.href = errorPage+"?err_num="+ message+"<br>"+flag;
	create();
		if( result ) {
			onSuccess();
		}
	}
	else{
		blankObject.focus();
	}
}

function assignValue(obj){//ADDED FOR JD-CRF-0200
	if(obj.checked)
		obj.value="Y";
	else
		obj.value="N";
}

function assignResult( _result, _message, _flag ) {//ADDED FOR JD-CRF-0200

	result	= _result ;
	message	= _message ;
    flag	= _flag ;
}
  
function proceedOnApply() {
    var url = f_query_add_mod.location.href;
    url = url.toLowerCase();
    if ( (url.indexOf("blank.html")==-1) && (url.indexOf("MedicationAdministrationRightsquery")==-1) )
        return true;
    else
        return false;
}
function onSuccess(){

	messageFrame.location.href = "../../eCommon/jsp/error.jsp"+"?err_num="+ message;
}

function reset() {
	
	if (f_query_add_mod.MedicationAdministrationRightsHeaderFrame != null) {
		
	   if (f_query_add_mod.MedicationAdministrationRightsListFrame != null) {
		   
		   f_query_add_mod.location.reload();
	     }else{
	    	 
		  f_query_add_mod.location.href = "../../ePH/jsp/MedicationAdministrationRightsMain.jsp?mode="+MODE_INSERT+"&function_id="+function_id;
		}
	  }
	if (f_query_add_mod.document.query_form != null) {
		
		f_query_add_mod.document.query_form.reset();
	} //ends
}


function searchDetails(mode) {//ADDED FOR JD-CRF-0200
   
	top.content.messageFrame.location.href='../../eCommon/jsp/error.jsp';
	var user_id=document.forms[0].user_id.value;
	
	if(user_id!="") {
	   parent.MedicationAdministrationRightsListFrame.location.href="../../ePH/jsp/MedicationAdministrationRightsDetail.jsp?user_id="+user_id+"&mode="+mode;
	}
	else
	{
		alert(getMessage("USER_CANNOT_BLANK","SS"));
		document.forms[0].user_id.focus();
	}
}

async function searchCode( target ) 
{//ADDED FOR JD-CRF-0200
	parent.parent.messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num=";
	var argumentArray	= new Array() ;
	var dataNameArray	= new Array() ;
	var dataValueArray	= new Array() ;
	var dataTypeArray	= new Array() ;

	argumentArray[0] = document.forms[0].SQL_PH_DISP_RIGHTS_SELECT1.value;
	argumentArray[1] = dataNameArray ;
	argumentArray[2] = dataValueArray ;
	argumentArray[3] = dataTypeArray ;
	argumentArray[4] = "1,2";
	argumentArray[5] = target.value;
	argumentArray[6] = CODE_LINK ;
	argumentArray[7] = CODE_DESC ;

	retVal = await CommonLookup( getLabel("Common.username.label","Common"), argumentArray );
	var str =unescape(retVal);
	var arr = str.split(",");	
	if(retVal != null && retVal != "" )  {
	
		target.value = arr[1] ;
		if(target.name=="user_name")
		{
			document.forms[0].user_id.value=arr[0];
			document.forms[0].userIdSearch.disabled=true;
			document.forms[0].user_name.disabled=true;
			document.forms[0].user_name.readOnly=true;
			searchDetails("MODE_INSERT");
		}
	} 
}



function Modify(obj){
	var user_id=obj.cells[0].innerText;
	var user_name=obj.cells[1].innerText;
	parent.frames[2].f_query_add_mod.location.href="../../ePH/jsp/MedicationAdministrationRightsMain.jsp?mode="+MODE_MODIFY+"&function_id="+parent.function_id+"&user_name="+user_name+"&user_id="+user_id;

}

function disableClick(){
return false;
}
 
