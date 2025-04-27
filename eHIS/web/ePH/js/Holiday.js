var function_id	= "PH_HOLIDAY" ;
var result		= false ;
var message		= "" ;
var flag		= "" ;

function create() {
	f_query_add_mod.location.href="../../ePH/jsp/HolidayFrames.jsp?function_id="+function_id+"&mode="+MODE_INSERT;
}

function reset() {
	f_query_add_mod.location.reload();
}

function apply() {
	var errorPage = "../../eCommon/jsp/MstCodeError.jsp";
	if(f_query_add_mod.holidayMainFrame.document.HolidayMainform==null)
		return;
	var formObj=  f_query_add_mod.holidayMainFrame.document.HolidayMainform;
	var arrayObject = new Array(formObj.holiday_date,formObj.reason);
	var names = new Array("Holiday Date", "Reason");
	if( checkFieldsofMst(arrayObject, names, messageFrame)){
			var responseText	=	formApply(formObj,PH_CONTROLLER);
			//alert(responseText);
			eval(responseText);
			messageFrame.location.href = errorPage+"?err_num="+ message;
	}
	if( result )
		onSuccess();
}
function deleterecord(){
//	if(f_query_add_mod.holidayMainFrame.document.HolidayMainform != undefined){
	if (f_query_add_mod.holidayMainFrame.document.HolidayMainform.holiday_date.value!=""){

		if (f_query_add_mod.holidayMainFrame.document.HolidayMainform.mode.value == MODE_MODIFY) {
				
				f_query_add_mod.holidayMainFrame.document.HolidayMainform.mode.value = MODE_DELETE;
				if (confirm(f_query_add_mod.holidayMainFrame.getMessage("DELETE_RECORD","Common"))){
					eval(formApply(f_query_add_mod.holidayMainFrame.document.HolidayMainform,PH_CONTROLLER ));
					messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ message;
				if( result ) 
						onSuccess();
					
				}else{
				
					f_query_add_mod.holidayMainFrame.document.HolidayMainform.mode.value = MODE_MODIFY;
					messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num=";
				return false;

				}
			}
			else{ 
				messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="; //for IE11_PHIS_PH_Admin Setup [IN:058932] 
			}
	}else{
		messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num=";
		}
 //}
}

function onSuccess() {
	f_query_add_mod.location.href="../../ePH/jsp/HolidayFrames.jsp?function_id="+function_id+"&mode="+MODE_INSERT;
}

function Modify(obj) {
	var holiday_date = obj.cells[0].innerText;
	var reason		 = obj.cells[1].innerText;
	parent.frames[0].location.href="../../ePH/jsp/HolidayAddModify.jsp?function_id="+function_id+"&mode="+MODE_MODIFY+"&holiday_date="+holiday_date+"&reason="+encodeURIComponent(reason);
}
function assignResult( _result, _message, _flag ) {
	result	= _result ;
	message	= _message ;
	flag	= _flag ;
}


