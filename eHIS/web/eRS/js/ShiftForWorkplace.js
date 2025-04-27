var function_id = "";

var message = "";
var result = false;
var show_list = false;
var message = "";
var show_facility = false;
var show_shift = false;
/*************************************************************/
function create(){

	f_query_add_mod.location.href='../../eRS/jsp/ShiftForWorkplaceFrameSet.jsp?mode='+MODE_INSERT+"&function_id="+function_id ;
}
/*************************************************************/
function query() {

	f_query_add_mod.location.href ="../../eRS/jsp/ShiftForWorkplaceQueryCriteria.jsp?function=service";
}
/*************************************************************/
function apply() {

	if (!checkIsValidForProceed()){
		message  = ""
		messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ message;
		return false ;
	}
	if (!checkIsValidForProceed1()){
		message  = ""
		messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ message;
		return false ;
	}
	if (!checkIsValidForProceed2()){
		//message  = getMessage("NOT_VALID","Common");
		//messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ message;

		var frmobj=f_query_add_mod.f_query_add_mod_select.document.forms[0];
		if(frmobj==f_query_add_mod.f_query_add_mod_select.document.frm_by_workplace)
		{

			var fields = new Array (frmobj.workplace);
			var names = new Array (getLabel("eRS.WorkPlace.label","RS"));
			if(f_query_add_mod.f_query_add_mod_select.checkFieldsofMst( fields, names, messageFrame))
			parent.frames[1].messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num=";
		}

		else if(frmobj==f_query_add_mod.f_query_add_mod_select.document.frm_by_shift)
		{
		
			var fields = new Array (frmobj.shift_code);
			var names = new Array (getLabel("Common.SHIFT.label","Common"));
			if(f_query_add_mod.f_query_add_mod_select.checkFieldsofMst( fields, names, messageFrame))
			parent.frames[1].messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num=";
		}
		return false ;
	}
	var frmObj=frames[1].frames[2].document.forms[0];
	var frmName=frmObj.name;
	for(cnt=0;cnt<frmObj.totalRecords.value; cnt++){
		var select=eval("frmObj.select_yn"+cnt);
		if(select.checked==true){
				select.value="Y";
		}else{
			select.value="N"
		}
	}

	frmObj.submit();
}
/*************************************************************************/
function assignResult(_result, _message, _flag){
	result = _result ;
	message  = _message ;
	flag = _flag ;
}
/****************************************************************************/
function onSuccess() {

//var mode = parent.frames[1].frames[1].frames[2].document.forms[0].mode.value -----commented on 19/11/08---
 var mode = parent.frames[2].frames[1].frames[2].document.forms[0].mode.value
	if( mode == "1" ) {
			//parent.frames[1].frames[1].frames[2].location.href='../../eCommon/html/blank.html'; -----commented on 19/11/08
			parent.frames[2].frames[1].frames[2].location.href='../../eCommon/html/blank.html';
			//parent.frames[1].frames[1].frames[1].document.forms[0].reset(); ---commented on 19/11/08
			parent.frames[2].frames[1].frames[1].document.forms[0].reset();
			var frmObj=frames[1].f_query_add_mod_select.document.forms[0]
			frmObj.reset();
			var i=0;
			while(frmObj.elements(i)!=null){
				frmObj.elements(i).disabled=false;
				i++;
			}
			frmObj.elements(0).focus()
	}
}
/****************************************************************************/
function reset() {

	var url=f_query_add_mod.location.href;
	if(url.indexOf("blank")==-1) {
		if(url.indexOf("Query")==-1){
			url=frames[1].f_query_add_mod_select.location.href;
			if(url.indexOf("blank")==-1) {
				var frmObj=frames[1].f_query_add_mod_select.document.forms[0]
				url=frames[1].f_query_add_mod_list .location.href;
				if(url.indexOf("blank")==-1) {
					frames[1].f_query_add_mod_list.document.forms[0].reset();
					messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp";
				}
				else{
					frmObj.reset();
					var i=0;
					while(frmObj.elements(i)!=null){
						frmObj.elements(i).disabled=false;
						i++;
					}
					frmObj.elements(0).focus()
				}
			}
			else
				f_query_add_mod.location.href='../../eCommon/html/blank.html';
			}
		else
			f_query_add_mod.document.forms[0].reset();
	}	
}
/*************************************************************/
function showWorkplace(){
	parent.f_query_add_mod_select.location.href="../../eRS/jsp/ShiftForWorkplaceByWorkplace.jsp?mode=1";
	parent.f_query_add_mod_list.location.href="../../eCommon/html/blank.html";
	parent.parent.messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ message;
}
/*************************************************************/
function showShift(){

	parent.f_query_add_mod_select.location.href="../../eRS/jsp/ShiftForWorkplaceByShift.jsp?mode=1";
	parent.f_query_add_mod_list.location.href="../../eCommon/html/blank.html";
	show_list = false;
	show_facility = false;
	show_shift = true;
	message = "";
	parent.parent.messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ message;
}
/*************************************************************/
function selectShift(){
	var frmObj = parent.f_query_add_mod_select.frm_by_shift;
	var shift_code = frmObj.shift_code[frmObj.shift_code.selectedIndex].value;
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest() ;
	xmlStr ="<root><SEARCH " ;
	xmlStr +=" /></root>" ;
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open( "POST","../../eRS/jsp/ShiftForWorkplaceByShiftValidate.jsp?shift_code="+shift_code, false ) ;
	xmlHttp.send( xmlDoc ) ;
	responseText=xmlHttp.responseText ;
	eval(responseText);
	
	show_list = false;
	show_facility = false;
	show_shift = true;

}
/*************************************************************/
function showValues(shift_indicator,  appl_for_working_days, appl_for_nonworking_days, appl_for_holidays, shift_start_time, shift_end_time, shift_mnemonic){

	if(shift_indicator=="P")
		shift_indicator = "Productive";
	else{
		if(shift_indicator=="U")
			shift_indicator = "Unproductive";
		else{
			if(shift_indicator=="A")
				shift_indicator = "Absence";
			else
				shift_indicator = "Leave";
		}
	}

	var frmObj=document.frm_by_shift;
	frmObj.shift_indicator.value=shift_indicator;
	if(appl_for_working_days=="Y")
		frmObj.appl_for_working_days.checked = true;
	else
		frmObj.appl_for_working_days.checked = false;

	if(appl_for_nonworking_days=="Y")
		frmObj.appl_for_nonworking_days.checked = true;
	else
		frmObj.appl_for_nonworking_days.checked = false;

	if(appl_for_holidays=="Y")
		frmObj.appl_for_holidays.checked = true;
	else
		frmObj.appl_for_holidays.checked = false;

	frmObj.shift_start_time.value=shift_start_time;
	frmObj.shift_end_time.value=shift_end_time;
	frmObj.shift_mnemonic.value=shift_mnemonic;
}
/*************************************************************/
function showShiftsList(){

	var frmObj=document.frm_by_workplace;
	var fields = new Array ( frmObj.workplace);	
	var names = new Array (getLabel("eRS.Workplace.label","RS"));	
	var mode				= frmObj.mode.value;

	if(parent.parent.f_query_add_mod.checkFieldsofMst( fields, names, parent.parent.messageFrame)) {	

			var locn_type = frmObj.locn_type[frmObj.locn_type.selectedIndex].value;
			var workplace_code = frmObj.workplace_code.value;
			var facility_id = frmObj.facility_id.value;
			message = "";
			parent.parent.messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ message;
			parent.f_query_add_mod_list.location.href="../../eRS/jsp/ShiftForWorkplaceShowShift.jsp?mode="+mode+"&locn_type="+locn_type+"&facility_id="+facility_id+"&workplace_code="+workplace_code;
			for(var i=0;i<frmObj.elements.length;i++)
				frmObj.elements[i].disabled=true;
	}
}
/*************************************************************/
function showWorkplacesList()
{
	form_show_shifts = false;
	form_show_workplaces = true;
	var frmObj=document.frm_by_shift;
	var fields = new Array (frmObj.shift_code);

	var names = new Array (getLabel("Common.SHIFT.label","Common"));	
	if(parent.parent.f_query_add_mod.checkFieldsofMst( fields, names, parent.parent.messageFrame)) 
		{
	
		var shift_code = frmObj.shift_code.value;
		var locn_type = frmObj.locn_type.value;
		var shift_mnemonic = frmObj.shift_mnemonic.value;

		message = "";
		parent.parent.messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ message;	
		parent.f_query_add_mod_list.location.href = "../../eRS/jsp/ShiftForWorkplaceShowWorkplace.jsp?mode=1&shift_code="+shift_code+"&locn_type="+locn_type+"&shift_mnemonic="+shift_mnemonic;
		for(var i=0;i<frmObj.elements.length;i++)
			frmObj.elements[i].disabled=true;
		}
}
/*************************************************************/
function checkActiveApplicable(target)
{
	if(target.checked == false)
	{
		target.value = "N";
		target.checked = false;
	}
	else
	{
		target.value = "Y";
		target.checked = true;
	}
}

/*************************************************************/
function showWorkplaceLookup(call_mode, target)
{
	var argumentArray  = new Array() ;
	var dataNameArray  = new Array() ;
	var dataValueArray = new Array() ;
	var dataTypeArray  = new Array() ;
	var frmObj=document.frm_by_workplace;
	var workplace = frmObj.workplace.value;
	var locale = frmObj.locale.value;
	//alert("workplace---->"+workplace);
		//alert("locale---->"+locale);
	if((call_mode =='T')&&(workplace =='')){
		frmObj.workplace_code.value='';
		return false;
	}

	var locn_type = frmObj.locn_type[frmObj.locn_type.selectedIndex].value;
	if(frmObj.workplace_code.value !=''){
		frmObj.workplace_code.value='';
		frmObj.workplace.value='';
	}
	//var sql_workplace_lookup = "select workplace_code code,workplace_desc description from rs_workplace where ('"+locn_type+"' is null or locn_type='"+locn_type+"') and eff_status='E' and upper(workplace_code) like(upper(?))  and upper(workplace_desc) like(upper(?))";
	var sql_workplace_lookup = "select workplace_code code,workplace_desc description from rs_workplace_lang_vw where ('"+locn_type+"' is null or locn_type='"+locn_type+"') and eff_status='E' and upper(workplace_code) like(upper(?))  and upper(workplace_desc) like(upper(?)) and language_id = '"+locale+"'";
	argumentArray[0] = sql_workplace_lookup;
	argumentArray[1] = dataNameArray ;
	argumentArray[2] = dataValueArray ;
	argumentArray[3] = dataTypeArray ;
	argumentArray[4] = "1,2";
	argumentArray[5] = target.value;
	argumentArray[6] = CODE_LINK ;//CODE_LINK
	argumentArray[7] = CODE_DESC ;//CODE_DESC

	retVal = CommonLookup(getLabel("eRS.FindWorkplace.label","RS"),argumentArray);
	if(retVal != null && retVal != "" )
	{
		frmObj.workplace_code.value = retVal[0];
		frmObj.workplace.value = retVal[1];
		target.value = retVal[1];
	}else
	{
		////
	}
}
/**************************************************/
function click_selectall()
{
	var frmObj=parent.f_query_add_mod_list.document.forms[0];
	var select=frmObj.selectall;
	if(select.checked == true){
		for(cnt=0;cnt<frmObj.totalRecords.value; cnt++){
			val = eval("frmObj.select_yn"+cnt);
			val.checked = true;
		}
	}else{
		for(cnt=0; cnt<frmObj.totalRecords.value; cnt++){
			val = eval("frmObj.select_yn"+cnt);
			val.checked = false;
		}
	}
}
/*************************************************************/
function click_select(target){
	if(target.checked == false){
		target.value = "N";
	}	else	{
		target.value = "Y";
		target.checked = true;
	}
}
/*************************************************************/
function assignResult(_result, _message, _flag)
{
	result = _result ;
	message  = _message ;
	flag = _flag ;
}
/*************************************************************/
function locnchange(){
	var frmObj=document.frm_by_workplace;
	frmObj.workplace.value='';
}
/****************************************/
function checkIsValidForProceed()
{		var url = f_query_add_mod.location.href;
		url = url.toLowerCase();
		if ( (url.indexOf("queryresult.jsp")==-1) && (url.indexOf("query")==-1)&&(url.indexOf("blank")==-1) )
				return true;
		else
			return false;
}
/*********************************************/
function checkIsValidForProceed1()
{		var url = f_query_add_mod.f_query_add_mod_select.location.href;
		url = url.toLowerCase();
		if ( (url.indexOf("queryresult.jsp")==-1) && (url.indexOf("query")==-1)&&(url.indexOf("blank")==-1) )
				return true;
		else
			return false;
}
/**************************************************/
function checkIsValidForProceed2()
{		var url = f_query_add_mod.f_query_add_mod_list.location.href;
		url = url.toLowerCase();
		if ( (url.indexOf("queryresult.jsp")==-1) && (url.indexOf("query")==-1)&&(url.indexOf("blank")==-1) )
				return true;
		else
			return false;
}

/*************************************************************************/
