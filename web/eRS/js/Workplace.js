var function_id = "";
var message = "";
var flag = false;
var result = false;

function create(){
	f_query_add_mod.location.href="../../eRS/jsp/WorkplaceAddModify.jsp?mode=1&function_id="+function_id ;

}

function query(){
	f_query_add_mod.location.href="../../eRS/jsp/WorkplaceQueryCriteria.jsp";
}


function reset(){
	if(f_query_add_mod.document.forms[0])
	f_query_add_mod.document.forms[0].reset();
}



function apply(){

	if (!checkIsValidForProceed()){
		message = "";
		messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ message;
		return false ;
	}
	
	var frmObj = f_query_add_mod.document.frm_workplace;
	var mode=frmObj.mode.value;
	if(mode=="2"){
		//frmObj.staff_util.value=frmObj.hstaff_util.value;
		frmObj.staff_util.value=frmObj.hstaff_util.value;
	}
	var working_from_hh = frmObj.wday_from_hh.value;
	var working_from_mm = frmObj.wday_from_mm.value;
	var working_to_hh = frmObj.wday_to_hh.value;
	var working_to_mm = frmObj.wday_to_mm.value;

	var nonworking_from_hh = frmObj.nwday_from_hh.value;
	var nonworking_from_mm = frmObj.nwday_from_mm.value;
	var nonworking_to_hh = frmObj.nwday_to_hh.value;
	var nonworking_to_mm = frmObj.nwday_to_mm.value;

	var hday_from_hh = frmObj.hday_from_hh.value;
	var hday_from_mm = frmObj.hday_from_mm.value;
	var hday_to_hh = frmObj.hday_to_hh.value;
	var hday_to_mm = frmObj.hday_to_mm.value;
//	var fields = new Array(frmObj.workplace_code,frmObj.workplace_desc,frmObj.wday_from_hh,frmObj.wday_from_mm,frmObj.wday_to_hh,frmObj.wday_to_mm,frmObj.nwday_from_hh,frmObj.nwday_from_mm,frmObj.nwday_to_hh,frmObj.nwday_to_mm,frmObj.hday_from_hh,frmObj.hday_from_mm,frmObj.hday_to_hh,frmObj.hday_to_mm);
//	var names = new Array("Workplace Code","Workplace Description","Hours From of WorkingDays","Minutes From of WorkingDays","Hours To of WorkingDays","Minutes To of WorkingDays","Hours From of Non-WorkingDays","Minutes From of Non-WorkingDays","Hours To of Non-WorkingDays","Minutes To of Non-WorkingDays","Hours From of Holidays","Minutes From of Holidays","Hours To of Holidays","Minutes To of Holidays");
	var fields = new Array(frmObj.workplace_code,frmObj.workplace_desc);
	var names = new Array(getLabel("eRS.WorkplaceCode.label","RS"),getLabel("eRS.WorkplaceDescription.label","RS"));
	var i=fields.length;

	//Check for Working days from & to times
	if(!((working_from_hh == '')||(working_from_mm ==''))){	
		if(!((working_to_hh =='')||(working_to_mm == ''))){
			if((frmObj.wday_from_hh.value)==(frmObj.wday_to_hh.value)&&	(frmObj.wday_from_mm.value)==(frmObj.wday_to_mm.value)){
					message =	getMessage("WORKING_FROM_TO_EQUAL","RS");
					messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ message;
					frmObj.wday_to_mm.focus();
					return;
				}
		}
		else{
			if(working_to_hh == ''){
				fields[i]		=	frmObj.wday_to_hh;
				names[i++]	=	"Hours To of WorkingDays";
			}
			if(working_to_mm == ''){
				fields[i]		=	frmObj.wday_to_mm;
				names[i++]	=	"Minutes To of WorkingDays";
			}
		}
	}else{
		if(!((working_to_hh=='')&&(working_to_mm == ''))){
			if(working_from_hh==''){
				fields[i]		=	frmObj.wday_from_hh;
				names[i++]	=	"Hours From of WorkingDays";
			}
			if(working_from_mm == ''){
				fields[i]		=	frmObj.wday_from_mm;
				names[i++]	=	"Minutes From of WorkingDays";
			}
		}
	}

	//Check for Non-Working days from & to times
	if(!((nonworking_from_hh == '')||(nonworking_from_mm ==''))){	
		if(!((nonworking_to_hh=='')||(nonworking_to_mm != ''))){
			if((frmObj.nwday_from_hh.value)==(frmObj.nwday_to_hh.value)&&(frmObj.nwday_from_mm.value)==(frmObj.nwday_to_mm.value)){
					message =	getMessage("NON_WORKING_FROM_TO_EQUAL","RS");
					messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ message;
					frmObj.nwday_to_mm.focus();
					return;
				}
		}
		else{
			if(nonworking_to_hh==''){
				fields[i]		=	frmObj.nwday_to_hh;
				names[i++]	=	"Hours To of Non-WorkingDays";
			}
			if(nonworking_to_mm==''){
				fields[i]		=	frmObj.nwday_to_mm;
				names[i++]	=	"Minutes To of Non-WorkingDays";
			}
		}
	}else{
		if(!((nonworking_to_hh=='')&&(nonworking_to_mm == ''))){
			if(nonworking_from_hh==''){
				fields[i]		=	frmObj.nwday_from_hh;
				names[i++]	=	"Hours From of Non-WorkingDays";
			}
			if(nonworking_from_mm==''){
				fields[i]		=	frmObj.nwday_from_mm;
				names[i++]	=	"Minutes From of Non-WorkingDays";
			}
		}
	}

	//Check for Holiday days from & to times
	if(!((hday_from_hh == '')||(hday_from_mm ==''))){	
		if(!((hday_to_hh=='')||(hday_to_mm != ''))){
			if((frmObj.hday_from_hh.value)==(frmObj.hday_to_hh.value)&&	(frmObj.hday_from_mm.value)==(frmObj.hday_to_mm.value))
				{
					message =	getMessage("HOLIDAY_FROM_TO_EQUAL","RS");
					messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ message;
					frmObj.hday_to_mm.focus();
					return;
				}
		}
		else{
			if(hday_to_hh	==''){
				fields[i]		=	frmObj.hday_to_hh;
				names[i++]	=	"Hours To of HoliDays";
			}
			if(hday_to_mm	==''){
				fields[i]		=	frmObj.hday_to_mm;
				names[i++]	=	"Minutes To of HoliDays";
			}
		}
	}else{
		if(!((hday_to_hh=='')&&(hday_to_mm == ''))){
			if(hday_from_hh==''){
				fields[i]		=	frmObj.hday_from_hh;
				names[i++]	=	"Hours From of HoliDays";
			}
			if(hday_from_mm==''){
				fields[i]		=	frmObj.hday_from_mm;
				names[i++]	=	"Minutes From of HoliDays";
			}
		}
	}

	if(f_query_add_mod.checkFieldsofMst( fields, names, messageFrame)){
	/*	else if ((frmObj.nwday_from_hh.value)==(frmObj.nwday_to_hh.value)&&(frmObj.nwday_from_mm.value)==(frmObj.nwday_to_mm.value)){
					message = "Non-Working Days From and To cannot be Equal";
					messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ message;
					frmObj.nwday_to_mm.focus();
					return;
			}
			else if((frmObj.hday_from_hh.value)==(frmObj.hday_to_hh.value)&&(frmObj.hday_from_mm.value)==(frmObj.hday_to_mm.value))	{
					message = "Holidays From and To cannot be Same";
					messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ message;
					frmObj.hday_to_mm.focus();
					return;
			}*/
		var flds=new Array(frmObj.workplace_code);
		var name=new Array(getLabel("eRS.WorkplaceCode.label","RS"));
		if(!SpecialCharCheck(flds,name,messageFrame,"M","../../eCommon/jsp/MstCodeError.jsp"))
		{
		      return false;
        	}
		frmObj.submit();		
	}
}
/****************************************/
function checkIsValidForProceed(){
		var url = f_query_add_mod.location.href;
		url = url.toLowerCase();
		if ( (url.indexOf("queryresult.jsp")==-1) && (url.indexOf("query")==-1)&&(url.indexOf("blank")==-1) )
				return true;
		else
			return false;
}

function onSuccess(){
	 	var frmObj = f_query_add_mod.document.frm_workplace;
			var mode=frmObj.mode.value;
if (mode=="1")
frmObj.reset();
//else if(mode=="2")
//		f_query_add_mod.location.href='../../eRS/jsp/SkillAddModify.jsp?mode=2'+qry_str;
}


/*************************************************/
function CheckForZero(target){
	if((target.value==0)&&(target.value!='')){
			message = getMessage("VALUE_SHOULD_BE_GR_ZERO","RS");
			parent.messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ message;
			target.focus();
			target.select();
			return;
		}
}
/*************************************************/
function assignResult(_result, _message, _flag){
	result = _result ;
	message  = _message ;
	flag = _flag ;
}

function makeDef(target){

	var frmObj = parent.f_query_add_mod.document.frm_workplace;
	var noOfWeeks = frmObj.noOfWeeks.value;
	var name = target.name;
	if(name == 'def_mon')	{
		for(var i=1;i<=noOfWeeks;i++)	{
			eval("frmObj."+"week_"+i+"_day_1").value = target.value;
			eval("frmObj."+"week_"+i+"_day_1").selected = true;
		}
	}
	if(name == 'def_tue'){
		for(var i=1;i<=noOfWeeks;i++){
			eval("frmObj."+"week_"+i+"_day_2").value = target.value;
			eval("frmObj."+"week_"+i+"_day_2").selected = true;
		}
	}
	if(name == 'def_wed'){
		for(var i=1;i<=noOfWeeks;i++){
			eval("frmObj."+"week_"+i+"_day_3").value = target.value;
			eval("frmObj."+"week_"+i+"_day_3").selected = true;
		}
	}
	if(name == 'def_thu'){
		for(var i=1;i<=noOfWeeks;i++){
			eval("frmObj."+"week_"+i+"_day_4").value = target.value;
			eval("frmObj."+"week_"+i+"_day_4").selected = true;
		}
	}
	if(name == 'def_fri'){
		for(var i=1;i<=noOfWeeks;i++)	{
			eval("frmObj."+"week_"+i+"_day_5").value = target.value;
			eval("frmObj."+"week_"+i+"_day_5").selected = true;
		}
	}
	if(name == 'def_sat'){
		for(var i=1;i<=noOfWeeks;i++){
			eval("frmObj."+"week_"+i+"_day_6").value = target.value;
			eval("frmObj."+"week_"+i+"_day_6").selected = true;
		}
	}
	if(name == 'def_sun'){
		for(var i=1;i<=noOfWeeks;i++){
			eval("frmObj."+"week_"+i+"_day_7").value = target.value;
			eval("frmObj."+"week_"+i+"_day_7").selected = true;
		}
	}
}

function CheckForHours(target){
	var value = target.value;
	if(value == '')	{

	}else{
		if(value < 0 || value > 24){
			message = getMessage("OPERATING_HOURS_0_TO_23","RS");
			parent.messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ message;
			target.focus();
			return;
		}	else	{
			message ="";
				parent.messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp";
			if(value < 10) {
				var len = value.length;
				if(len < 2)
					target.value = '0' + value;
			}
		}
	}
}

function CheckForMinutes(target){
	var value = target.value;
	if(value == ''){

	}
	else	{
		if(value < 0 || value > 60){
			message = getMessage("OPERATING_MINUTES_0_TO_59","RS");
			parent.messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ message;
			target.focus();
			return;
		}else{
			parent.messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp";
			if(value < 10)	{				
				var len = value.length;
				if(len < 2)
					target.value = '0' + value;
			}
		}
	}
}

function chkforgrt(){
	
	if((document.forms[0].wday_from_hh.value)==(document.forms[0].wday_to_hh.value)&&
	(document.forms[0].wday_from_mm.value)==(document.forms[0].wday_to_mm.value))	{
		message = getMessage("WORKING_DAYS_FROM_TO_NOT_EQUAL","RS");
			parent.messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ message;
			document.forms[0].wday_to_mm.focus();
			return;
	}
}

function chkforgrt1(){
	if((document.forms[0].nwday_from_hh.value)==(document.forms[0].nwday_to_hh.value)&&
	(document.forms[0].nwday_from_mm.value)==(document.forms[0].nwday_to_mm.value)){
			message = getMessage("NON-WORKING_DAYS_FROM_TO_NOT_EQUAL","RS");
			parent.messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ message;
			document.forms[0].nwday_to_mm.focus();
			return;
	}
}

function chkforgrt2(){

	if((document.forms[0].hday_from_hh.value)==(document.forms[0].hday_to_hh.value)&&
	(document.forms[0].hday_from_mm.value)==(document.forms[0].hday_to_mm.value)){
		message = getMessage("HOLIDAYS_FROM_TO_NOT_SAME","RS");
			parent.messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ message;
			document.forms[0].hday_to_mm.focus();
			return;
	}
}

function changeopdays(obj,target){
	target.value	=	obj.value;
}
