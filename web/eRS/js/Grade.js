var qry_str="";
var message="";

//function for create mode
function create() {
	f_query_add_mod.location.href = "../../eRS/jsp/GradeAddModify.jsp?mode=1";
}
/****************************************************************/
function reset(){
	if(f_query_add_mod.document.forms[0])
	f_query_add_mod.document.forms[0].reset();
}
/****************************************************************/
function numberCheck()
	{
	if((event.keyCode>=48)&&(event.keyCode<=57))
		return true;
	else
		event.keyCode=0;
	}
/****************************************************************/
//function for query mode
function query() {
		f_query_add_mod.location.href = "../../eRS/jsp/GradeQueryCriteria.jsp";
}
/****************************************************************/
function onSuccess(){	 
	var frmobj=f_query_add_mod.document.form_add_mod ;
	var mode=frmobj.mode.value;
	if(mode == "1")
	{
		frmobj.reset();
	}
	else if(mode=="2")
	{
	qry_str="&grade_code="+frmobj.grade_code.value+"&grade_desc="+frmobj.grade_desc.value+"&grade_expl_text="+frmobj.grade_expl_text.value+"&grade_level="+frmobj.hgrade_level.value+"&allow_scheduling_yn="+frmobj.allow_scheduling_yn.value+"&ft_work_hours="+frmobj.ft_work_hours.value+"&eff_status="+frmobj.eff_status.value;
		f_query_add_mod.location.href='../../eRS/jsp/GradeAddModify.jsp?mode=2'+qry_str;
	}
}

/****************************************************************/

function onenable(target){
	if(target.checked==false)
	{
		target.value="D";
		target.checked=false;
	}
	else
	{
		target.value="E";
		target.checked=true;
	}
}
/****************************************************************/
function schedule_enable(target)
	{
		if(target.checked==false)
	{
		target.value="N";
		target.checked=false;
	}
	else
	{
		target.value="Y";
		target.checked=true;
	}
}
/****************************************************************/
//function to check whether on apply,the flow can be proceeded...
function checkIsValidForProceed()
{
		var url = f_query_add_mod.location.href;
		url = url.toLowerCase();
		if ( (url.indexOf("queryresult.jsp")==-1) && (url.indexOf("query")==-1)&&(url.indexOf("blank")==-1) )
				return true;
		else
				return false;
}
/****************************************************************/
function apply(){	
		var message="";
		messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ message;

	if (! checkIsValidForProceed()){
	     //message  = getMessage("NOT_VALID","Common");
	     message  = "";
		messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ message;	
		return false ;
	}
	var frmobj=f_query_add_mod.document.form_add_mod;
	var error_page = "../../eCommon/jsp/MstCodeError.jsp";
	var fields = new Array (frmobj.grade_code,frmobj.grade_desc,frmobj.grade_level,frmobj.ft_work_hours);			    
	var names = new Array (getLabel("Common.code.label","Common"), getLabel("Common.description.label","Common"),getLabel("eRS.GradeLevel.label","RS"),getLabel("eRS.FTWorkHours.label","RS"));		
                                                                                                                 
	var fields1 = new Array (frmobj.grade_code);			    
	var names1 = new Array (getLabel("Common.code.label","Common"));
	var disp_type="M";
	var error_jsp="../../eCommon/jsp/MstCodeError.jsp";
	var ft_wrk_hrs = parseInt(frmobj.ft_work_hours.value);
	if(ft_wrk_hrs == 0){
		message=getMessage("WORK_HRS_CANNOT_BE_ZERO","RS");

		//messageFrame.location.href= "../../eCommon/jsp/MstCodeError.jsp?err_num="+ message;
		frmobj.ft_work_hours.select();
		return false;
	}
	var mode=frmobj.mode.value;

	if(mode == '2'){
		frmobj.hallow_scheduling_yn.value = frmobj.allow_scheduling_yn.value;
	}
	if(f_query_add_mod.SpecialCharCheck( fields1, names1, messageFrame,disp_type,error_jsp))
	{
	if(f_query_add_mod.checkFieldsofMst( fields, names, messageFrame))
		frmobj.submit();
	}
	
}
//******************************************************************************
function Grade_level(target)
{
   var formObj=document.form_add_mod;
   formObj.hgrade_level.value=target.value;
}
/****************************************************************/
function checkForMax(obj){
	var expltext=obj.value;
	if(expltext.length > 4000){
		message=getMessage("EXPLTEXT_MAX_4000","RS");
		parent.messageFrame.location.href='../../eCommon/jsp/MstCodeError.jsp?err_num='+ message;
		obj.select();
		obj.focus();
	}
}
/****************************************************************/
