var function_id="";
var isCreate = "false";
var isApply = "false";
var isQuery = "false";
var atleastOne = false;
var flg = false;
var OTHER_STAFF_TYPE = "";
var LONG_DESC = "";
var SHORT_DESC = "";
var EFF_STATUS = ""; 
var operation_fun = "";

function create(){
	isCreate = "true";
		f_query_add_mod.location.href = "../../eAM/jsp/OtherStaffTypeAddModify.jsp?mode=1&function_id="+function_id;
}
/***************************************************************************/
function query() {

	f_query_add_mod.location.href ="../../eAM/jsp/OtherStaffTypeQueryCriteria.jsp?function=service";
	isQuery = "true";
	isCreate = "false";
}
/***************************************************************************/
function apply(){	

	var message="";
	//var messageFrame = parent.frames[1].frames[2]; 
	var messageFrame = frames[2]; 
	if (!checkIsValidForProceed()){

	    message  = getRsMessage("NOT_VALID");
		messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ message;	
		return false ;
	}
	
	var frmObj=f_query_add_mod.document.form_AddModifyOtherStaffType;
					
	var fields = new Array (frmObj.StaffTypeCode,frmObj.LongDescription,frmObj.ShortDescription);
	var names = new Array (getLabel("Common.code.label","Common"), getLabel("Common.longdescription.label","Common")
,getLabel("Common.shortdescription.label","Common"));

	var fields1 = new Array (frmObj.StaffTypeCode);			    
	var names1 = new Array (getLabel("Common.code.label","Common")
);
	var disp_type="M";
	var error_jsp="../../eCommon/jsp/MstCodeError.jsp";
	if(f_query_add_mod.SpecialCharCheck( fields1, names1, messageFrame,disp_type,error_jsp)){
		if(checkFieldsofMst( fields, names, messageFrame))
		{
				//if(parent.frames[1].frames[1].document.forms[0].eff_status.checked==true)
					if(frames[1].document.forms[0].eff_status.checked==true)
		{
			//parent.frames[1].frames[1].document.forms[0].eff_status.value="E";
			frames[1].document.forms[0].eff_status.value="E";
		}
			frmObj.submit();

		}
			
	}
}//end of apply
/***************************************************************************/
function checkIsValidForProceed(){

	var url = f_query_add_mod.location.href;
	url = url.toLowerCase();
	if((url.indexOf("queryresult.jsp")==-1) && (url.indexOf("query")==-1)&&(url.indexOf("blank")==-1) )
			return true;
	else
			return false;
}
/***************************************************************************/
function reset(){
	if(f_query_add_mod.document.forms[0])
	f_query_add_mod.document.location.reload();
}
/***************************************************************************/
function checkActive(target){

	if(target.checked == false){
		target.value = "D";
		target.checked = false;
	}
	else{
		target.value = "E";
		target.checked = true;
	}
}
/***************************************************************************/
function onSuccess(){

	var frmobj=f_query_add_mod.document.forms[0];
	var mode=frmobj.mode.value;

	if(mode == "1" ){
		frmobj.reset();
	}
	else{
		qry_str="&OTHER_STAFF_TYPE="+frmobj.StaffTypeCode.value+"&LONG_DESC="+escape(frmobj.LongDescription.value)+"&SHORT_DESC="+escape(frmobj.ShortDescription.value)+"&EFF_STATUS="+frmobj.eff_status.value;
		f_query_add_mod.location.href='../../eAM/jsp/OtherStaffTypeAddModify.jsp?mode=2'+qry_str;
		
	}		
}
/***************************************************************************/
