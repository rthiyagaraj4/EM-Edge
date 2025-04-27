var function_id = "";
var message="";
var p_facility_id="";
var p_workplace_code="";
var p_position_code="";
var p_role_type="";
var p_staff_id="";
var p_staff_type="";
var p_schedule_date="";
var p_date;
var p_cell_no;
var p_shift_code="";
var p_shift_mnemonic="";
var p_productive_flag="";
var day;
var s_shift_code="";
var s_shift_mnemonic="";
var prev_cell;
var curr_cell;
var curr_obj;
var curr_class="";
var prev_class="StaffList";
var curr_total;
var curr_shift;
var curr_posit;
var curr_posit_shift;
var prev_total;
var prev_shift;
var prev_posit;
var prev_posit_shift;
var show=0;
var menu='';
var prev_opt="";
var retVal="";
var CnlFlag="";

function apply(){
	if (!checkIsValidForProceed()){
		message  = getMessage("NOT_VALID","Common");
		messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ message;
		return false ;
	}
	if (!checkIsValidForProceed1()){
		message  = getMessage("NOT_VALID","Common");
		messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ message;
		return false ;
	}
	if (!checkIsValidForProceed2()){
		message  = getMessage("NOT_VALID","Common");
		messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ message;
		return false ;
	}
	var frmObj=frames[1].frameResult.frames[1].document.forms[0];
	frmObj.submit();
}
/*****************************************************************/
function reset(){
	var frmObj=frames[1].document.forms[0];
	frmObj.reset();
}
/*****************************************************************/
function selectWorplace(call_mode, target){
	
	var argumentArray  = new Array() ;
	var dataNameArray  = new Array() ; 
	var dataValueArray = new Array() ;
	var dataTypeArray  = new Array() ;
	var frmObj		=parent.frameManageWorkScheduleCriteria.document.forms[0];
	
	var workplace	 =frmObj.workplace_desc.value;
	
	
	if((call_mode == 'T')&&(workplace == '')){
		frmObj.workplace_code.value='';
		return false;
	}
	var facility_id		=frmObj.facility_id.value;
	var user_id		=frmObj.user_id.value;
	var locale	=frmObj.locale.value;
	var locn_type		=frmObj.locn_type[frmObj.locn_type.selectedIndex].value;
	var locn_desc	=frmObj.locn_type[frmObj.locn_type.selectedIndex].text;
		if(frmObj.workplace_code.value !=''){
		frmObj.workplace_code.value='';
		frmObj.workplace_desc.value='';
	}
	
	//argumentArray[0] ="select workplace_code code, workplace_desc description from rs_workplace_access_vw where facility_id='"+facility_id+"' and appl_user_id='"+user_id+"' and  ('"+locn_type+"' is null or locn_type='"+locn_type+"') and upper(workplace_code) like upper(?) and upper(workplace_desc) like upper(?) and eff_status='E' and allocate_yn='Y' order by workplace_desc";
	argumentArray[0] ="select a.workplace_code code, b.workplace_desc description from rs_workplace_access_vw a, rs_workplace_lang_vw b where a.facility_id='"+facility_id+"' and a.appl_user_id='"+user_id+"' and  ('"+locn_type+"' is null or a.locn_type='"+locn_type+"') and upper(a.workplace_code) like upper(?) and upper(a.workplace_desc) like upper(?) and a.eff_status='E' and a.allocate_yn='Y' and b.facility_id = a.facility_id and b.workplace_code = a.workplace_code and b.language_id = '"+locale+"' order by b.workplace_desc";

	argumentArray[1] = dataNameArray ;
	argumentArray[2] = dataValueArray ;
	argumentArray[3] = dataTypeArray ;
	argumentArray[4] = "1,2"; 
	argumentArray[5] = target.value;
	argumentArray[6] = CODE_LINK ;//CODE_LINK
	argumentArray[7] = CODE_DESC ;//CODE_DESC

	retVal = CommonLookup(getLabel("eRS.WorkPlace.label","RS"),argumentArray);
	if(retVal != null && retVal != "") {
		target.value = retVal[1] ;
		frmObj.workplace_code.value = retVal[0];
	}else
		target.value ="";
	frmObj.role_type.selectedIndex=0;
	role_change();
}
/*****************************************************************/
function selectStaffID(target){
	
	var frmObj		=parent.frameManageWorkScheduleCriteria.document.forms[0];
	var p_role_type=frmObj.role_type[frmObj.role_type.selectedIndex].value;
	var p_staff_type=frmObj.staff_type[frmObj.staff_type.selectedIndex].value;
	if(frmObj.position.selectedIndex>0){
		var p_position_desc=frmObj.position[frmObj.position.selectedIndex].text;
		var p_position_code=frmObj.position[frmObj.position.selectedIndex].value;
	}
	else {
		var p_position_code='';
		var p_position_desc='';
	}
	var url='../../eRS/jsp/SearchStaff.jsp?p_role_type='+p_role_type+'&p_staff_type='+p_staff_type+'&p_position_code='+p_position_code+'&p_position_desc='+p_position_desc+'&mode=call';
	var dialogHeight =window.screen.height ;
	var dialogWidth = window.screen.width ;
	var dialogTop	= 0;
	var dialogLeft = 0 ;
	var features = 'dialogHeight:' + dialogHeight + '; dialogWidth:' + dialogWidth +';dialogTop:'+dialogTop+';dialogLeft:'+dialogLeft+'; scroll=no; status=no';
	var arguments = "";
	var retVals = window.showModalDialog(url,arguments,features);
/*	if(retVals !=null){
		target.value=retVals[0];
		frmObj.staff_name.value=retVals[1];
	}*/
	if(retVals !=null){
		if(p_role_type != retVals[2]){
			var len=frmObj.role_type.length;
			for(i=0;i<len;i++){
				if(frmObj.role_type.options[i].value==retVals[2]){
					frmObj.role_type.selectedIndex=i;
					break;
				}
			}
			role_change();
		}
		if(p_staff_type != retVals[3]){
			var len=frmObj.staff_type.length;
			frmObj.staff_type.selectedIndex=0;
			for(i=0;i<len;i++){
				if(frmObj.staff_type.options[i].value==retVals[3]){
					frmObj.staff_type.selectedIndex=i;
					stafftype_change();
					break;
				}
			}
		}
		if(p_position_code != retVals[4]){
			var len=frmObj.position.length;
			frmObj.position.selectedIndex=0;
			for(i=0;i<len;i++){
				if(frmObj.position.options[i].value==retVals[4]){
					frmObj.position.selectedIndex=i;
					break;
				}
			}
		}
		target.value=retVals[0];
		frmObj.staff_name.value=retVals[1];
		//frmObj.staff_type.value=retVals[3];
		//frmObj.position.value=retVals[4];
	}
}
/*****************************************************************/
function locn_change(){
	var frmObj=parent.frameManageWorkScheduleCriteria.document.forms[0];
	var selected		=frmObj.locn_type.selectedIndex;
	frmObj.reset();
	frmObj.locn_type.selectedIndex=selected;
}
/*****************************************************************/
function role_change(){
	clearStaffType( ) ;
	clearPosition();
	var frmObj=parent.frameManageWorkScheduleCriteria.document.forms[0];
	var role=frmObj.role_type[frmObj.role_type.selectedIndex].value;
	
	if(role !=''){
		
		var xmlDoc = "" ;
		var xmlHttp = new XMLHttpRequest() ;
		xmlStr ="<root><SEARCH " ;
		xmlStr +=" /></root>" ;
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open( "POST","../../eRS/jsp/ManageWorkScheduleValidate.jsp?role_type="+role, false);
		xmlHttp.send( xmlDoc ) ;
		responseText=xmlHttp.responseText ;
		eval(responseText);

	}
	frmObj.staff_type.selectedIndex=0;
	frmObj.staff_id.value="";
	frmObj.staff_name.value="";
}
/************************************************************************/
function addStaffType(code,value) {
	var element = document.createElement('OPTION') ;
	element.value =  code ;
	element.text = value ;
	parent.frameManageWorkScheduleCriteria.document.forms[0].staff_type.add(element);
}

/************************************************************************/
function addPosition(code,value) {
	var element = document.createElement('OPTION') ;
	element.value =  code ;
	element.text = value ;
	parent.frameManageWorkScheduleCriteria.document.forms[0].position.add(element);
}
/************************************************************************/
function clearStaffType( ) {
	var len = eval("document.forms[0].staff_type.options.length") ;
	for(var i=0;i<len;i++)
	{
		eval("document.forms[0].staff_type.remove(\"atc_class_l2_code\")") ;
	}
	var tp 		= "  ---Select---  " ;
	var opt  	= eval("document.createElement(\"OPTION\")") ;
	opt.text 	= tp ;
	eval("document.forms[0].staff_type.add(opt)") ;
}
/************************************************************************/
function clearPosition( ) {
	var len = eval("document.forms[0].position.options.length") ;
	for(var i=0;i<len;i++){
		eval("document.forms[0].position.remove(\"atc_class_l2_code\")") ;
	}
	var tp 		= "  ---Select---  " ;
	var opt  	= eval("document.createElement(\"OPTION\")") ;
	opt.text 	= tp ;
	eval("document.forms[0].position.add(opt)") ;
}
/*****************************************************************/
function position_change(){
	var frmObj=parent.frameManageWorkScheduleCriteria.document.forms[0];
	frmObj.staff_id.value="";
	frmObj.staff_name.value="";
}
/*****************************************************************/
function stafftype_change(role){
	clearPosition();
	var frmObj=parent.frameManageWorkScheduleCriteria.document.forms[0];
	var role=frmObj.role_type[frmObj.role_type.selectedIndex].value
	var staff_type=frmObj.staff_type[frmObj.staff_type.selectedIndex].value;
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest() ;
	xmlStr ="<root><SEARCH " ;
	xmlStr +=" /></root>" ;
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open( "POST","../../eRS/jsp/ManageWorkScheduleValidate.jsp?role_type="+role+"&staff_type="+staff_type, false);
	xmlHttp.send( xmlDoc ) ;
	responseText=xmlHttp.responseText ;
	eval(responseText);
	frmObj.position.selectedIndex=0;
	frmObj.staff_id.value="";
	frmObj.staff_name.value="";
}
/*****************************************************************/
function AllowDateFormat(){
   var key = window.event.keyCode;
   if( ! ( (( key>=48 ) && ( key<58 ) ) || (key == 47)) ) {
       return false;
   }
}

/**************************************************************/
function checkDateRange(obj){
	var frmObj=document.forms[0];
	var fromDate = frmObj.frmdate;
	var toDate = frmObj.todate;
	if(doDateCheckAlert(fromDate,toDate)==false){
			alert(getMessage("TO_DT_GR_EQ_FM_DT","RS")); // this message available in messages.js of ecommon/js
			obj.value='';
			obj.focus()
			return false
	}
}
/**************************************************************/
function checkFromDate(){
	var frmObj=document.forms[0];
	var from =frmObj.frmdate;
	var today = frmObj.sys_date;
	var fromdate = from.value;
	var todaydate = today.value;
	var fromarray;
	var toarray;
	if(fromdate.length > 0 && todaydate.length > 0 ) {
		fromarray = fromdate.split("/");
		toarray = todaydate.split("/");
		var fromdt = new Date(fromarray[2],fromarray[1],fromarray[0]);
		var todaydt = new Date(toarray[2],toarray[1],toarray[0]);
		if(Date.parse(todaydt) > Date.parse(fromdt)) {			
			var invaldt = getMessage("FROM_DATE_GREATER_SYSDATE","RS") ; 
			alert(invaldt);
			//from.value="";
			from.select();
			from.focus();
		}else{
			var toDate = frmObj.todate;
			if(toDate.value != ''){
				if(!doDateCheck(from,toDate,parent.messageFrame)){
					//alert(getMessage("TO_DT_GR_EQ_FM_DT"));
					frmObj.todate.select();
					//frmObj.todate.value='';
					frmObj.todate.focus();
				}
			}
		}
	}
}
/*************************************************************/
function checkToDate(){
	var frmObj=document.forms[0];
	var to =frmObj.todate;
	var today = frmObj.sys_date;
	var todate = to.value;
	var todaydate = today.value;
	var toarray;
	var todayarray;
	if(todate.length > 0 && todaydate.length > 0 ) {
		toarray = todate.split("/");
		todayarray = todaydate.split("/");
		var todt = new Date(toarray[2],toarray[1],toarray[0]);
		var todaydt = new Date(todayarray[2],todayarray[1],todayarray[0]);
		if(Date.parse(todaydt) > Date.parse(todt)) {			
			var invaldt = getMessage("TO_DATE_LESS_SYSDATE","RS") ; 
			alert(invaldt);
			//to.value="";
			to.select();
			to.focus();
		}else{
			var fromDate = frmObj.frmdate;
			if(fromDate.value != ''){
				if(!doDateCheck(fromDate,to,parent.messageFrame)){
					//alert(getMessage("TO_DT_GR_EQ_FM_DT"));
					frmObj.todate.select();
					//frmObj.todate.value='';
					frmObj.todate.focus();
				}
			}
		}
	}
}
/**************************************************************/
function showCal(obj, obj_id){
	showCalendar(obj_id);
	obj.focus();
}
/*************************************************************/
function showDetails(){
	
	var frmObj					=document.forms[0];
	
	var locale =frmObj.locale.value;
	var mode						=frmObj.mode.value;
	var facility_id				=frmObj.facility_id.value;
	var user_id					=frmObj.user_id.value;
	var locn_type				=frmObj.locn_type[frmObj.locn_type.selectedIndex].value;
	var workplace_code		=frmObj.workplace_code.value;
	var workplace				 =frmObj.workplace_desc.value;
	var role_type				=frmObj.role_type[frmObj.role_type.selectedIndex].value;
	var staff_type				=frmObj.staff_type[frmObj.staff_type.selectedIndex].value;
	var position_code		=frmObj.position[frmObj.position.selectedIndex].value;
	var staff_id					=frmObj.staff_id.value;
	//var groupby						=frmObj.groupby[frmObj.groupby.selectedIndex].value;
	//var view						=frmObj.view[frmObj.view.selectedIndex].value;
	var groupby				='W';
	var view						='All';
	var from_date				=convertDate(frmObj.frmdate.value,'DMY',locale,"en");
	var to_date					=convertDate(frmObj.todate.value,'DMY',locale,"en");
	var days						=frmObj.DAYS.value;
	var fields = new Array (frmObj.workplace_code, frmObj.frmdate, frmObj.todate);			    
	var names = new Array (getLabel("eRS.Workplace.label","RS"),getLabel("Common.fromdate.label","Common"),getLabel("Common.todate.label","Common"));			
	
	if(parent.frameManageWorkScheduleCriteria.checkFields( fields, names,parent.messageFrame)){	
	
	url="../../eRS/jsp/ManageWorkScheduleFrameset.jsp?user_id="+user_id+"&locn_type="+locn_type+"&workplace_code="+workplace_code+"&workplace_desc="+workplace+"&role_type="+role_type+"&staff_type="+staff_type+"&position_code="+position_code+"&staff_id="+staff_id+"&view="+view+"&groupby="+groupby+"&from_date="+from_date+"&to_date="+to_date+"&new_to_date="+to_date+"&new_from_date="+from_date+"&facility_id="+facility_id+"&mode="+mode+"&onclick_of=S"+"&producive_flag=W"+"&DAYS="+days;
		
			

		var dialogHeight =window.screen.height ;
		var dialogWidth = window.screen.width ;
		var dialogTop	= 0;
		var dialogLeft = 0 ;

		var features = 'dialogHeight:' + dialogHeight + '; dialogWidth:' + dialogWidth +';dialogTop:'+dialogTop+';dialogLeft:'+dialogLeft+'; scroll=no; status=no';
		var arguments = "";
		var retVals = window.showModalDialog(url,arguments,features);
		
	}

}
/*****************************************************************
function assignResult(_result, _message, _flag){
	result = _result ;
	message  = _message ;
	flag = _flag ;
}
/*****************************************************************
function onSuccess() {
	parent.frames[1].frames[1].frames[3].location.href='../../eCommon/html/blank.html';
	parent.frames[1].frames[1].frameset_MasterSchedule.rows="4%,26%,7%,*";
}
/*****************************************************************/
function checkIsValidForProceed(){
	
	var url = f_query_add_mod.location.href;
	url = url.toLowerCase();
	if ( (url.indexOf("queryresult.jsp")==-1) && (url.indexOf("query")==-1)&&(url.indexOf("blank")==-1) )
		return true;
	else
		return false;
}
/**********************FUNCTION TO HANDLE ARROWS ***********************/
function moveNext(){
		var frmObj=document.forms[0];

	var new_from_date	=	frmObj.p_from_date.value;
	var new_to_date		=	frmObj.p_to_date.value;
	var onclick_of				=	frmObj.p_next_direction.value;
	var p_end					=	frmObj.p_end.value;
	var DAYS						=	frmObj.DAYS.value;
	//var productive_flag	=	frmObj.productive_flag[frmObj.productive_flag.selectedIndex].value;
	var productive_flag	="W";

	if(p_end=='E'){
		//var message=getMessage("REACHED_END","RS");
		alert(getMessage("REACHED_END","RS"));
	}
	else{
		var frmObj1=parent.frames[1].document.forms[0];

		var facility_id				=frmObj1.facility_id.value;
		var user_id					=frmObj1.user_id.value;
		var locn_type				=frmObj1.locn_type.value;
		var workplace_code	=frmObj1.workplace_code.value;
		var role_type				=frmObj1.role_type.value;
		var staff_type				=frmObj1.staff_type.value;
		var position_code		=frmObj1.position_code.value;
		var staff_id					=frmObj1.staff_id.value;
		var groupby				=frmObj1.groupby.value;
		var view						=frmObj1.view.value;
		var from_date				=frmObj1.from_date.value;
		var to_date					=frmObj1.to_date.value;
		var end_ind					=frmObj1.end_ind.value ;

		if((to_date == new_to_date)&&(from_date == new_from_date)){
			//var message=getMessage("REACHED_END","RS");
			alert(getMessage("REACHED_END","RS"));
		}
		else{
			parent.frameManageWorkScheduleHdr.location.href="../../eRS/jsp/ManageWorkScheduleHdr.jsp?user_id="+user_id+"&locn_type="+locn_type+"&workplace_code="+workplace_code+"&role_type="+role_type+"&staff_type="+staff_type+"&position_code="+position_code+"&staff_id="+staff_id+"&view="+view+"&groupby="+groupby+"&from_date="+from_date+"&to_date="+to_date+"&new_to_date="+new_to_date+"&new_from_date="+new_from_date+"&onclick_of="+onclick_of+"&facility_id="+facility_id+"&DAYS="+DAYS+"&productive_flag="+productive_flag;
			//parent.frameManageWorkScheduleResult.location.href="../../eRS/jsp/ManageWorkScheduleResult.jsp?user_id="+user_id+"&locn_type="+locn_type+"&workplace_code="+workplace_code+"&role_type="+role_type+"&staff_type="+staff_type+"&position_code="+position_code+"&staff_id="+staff_id+"&view="+view+"&groupby="+groupby+"&from_date="+from_date+"&to_date="+to_date+"&new_to_date="+next_to_date+"&new_from_date="+next_from_date+"&onclick_of="+onclick_of+"&facility_id="+facility_id;
		}
	}
}
/********************************************************/
function moveBack(){
		var frmObj=document.forms[0];

	var new_from_date	=	frmObj.p_from_date.value;
	var new_to_date		=	frmObj.p_to_date.value;
	var onclick_of				=	frmObj.p_prev_direction.value;
	var p_end					=	frmObj.p_end.value;
	var DAYS						=	frmObj.DAYS.value;
	//var productive_flag	=	frmObj.productive_flag[frmObj.productive_flag.selectedIndex].value;
	var productive_flag	="W";

	if(p_end=='B'){
		//var message=getMessage("REACHED_BEGIN","RS");
		alert(getMessage("REACHED_BEGIN","RS"));
		return;
	}
	else{
		var frmObj1=parent.frames[1].document.forms[0];

		var facility_id				=frmObj1.facility_id.value;
		var user_id					=frmObj1.user_id.value;
		var locn_type				=frmObj1.locn_type.value;
		var workplace_code	=frmObj1.workplace_code.value;
		var role_type				=frmObj1.role_type.value;
		var staff_type			=frmObj1.staff_type.value;
		var position_code					=frmObj1.position_code.value;
		var staff_id					=frmObj1.staff_id.value;
		var groupby						=frmObj1.groupby.value;
		var view						=frmObj1.view.value;
		var from_date			=frmObj1.from_date.value;
		var to_date			=frmObj1.to_date.value;
		var end_ind			=frmObj1.end_ind.value ;

		if((to_date == new_to_date)&&(from_date == new_from_date)){
			//var message=getMessage("REACHED_BEGIN","RS");
			alert(getMessage("REACHED_BEGIN","RS"));
		}
		else{
			parent.frameManageWorkScheduleHdr.location.href="../../eRS/jsp/ManageWorkScheduleHdr.jsp?user_id="+user_id+"&locn_type="+locn_type+"&workplace_code="+workplace_code+"&role_type="+role_type+"&staff_type="+staff_type+"&position_code="+position_code+"&staff_id="+staff_id+"&view="+view+"&groupby="+groupby+"&from_date="+from_date+"&to_date="+to_date+"&new_to_date="+new_to_date+"&new_from_date="+new_from_date+"&onclick_of="+onclick_of+"&facility_id="+facility_id+"&DAYS="+DAYS+"&productive_flag="+productive_flag;

			//parent.frameManageWorkScheduleResult.location.href="../../eRS/jsp/ManageWorkScheduleResult.jsp?user_id="+user_id+"&locn_type="+locn_type+"&workplace_code="+workplace_code+"&role_type="+role_type+"&staff_type="+staff_type+"&position_code="+position_code+"&staff_id="+staff_id+"&view="+view+"&groupby="+groupby+"&from_date="+from_date+"&to_date="+to_date+"&new_to_date="+next_to_date+"&new_from_date="+next_from_date+"&onclick_of="+onclick_of+"&facility_id="+facility_id;
		}
	}
}
/************************************************************/
function changeShiftOpt(){
	

	var frmObj		=	document.forms[0];
	var facility_id				=	frmObj.facility_id.value;
	var user_id					=	frmObj.user_id.value;
	var locn_type				=	frmObj.locn_type.value;
	var workplace_code	=	frmObj.workplace_code.value;
	var role_type				=	frmObj.role_type.value;
	var staff_type				=	frmObj.staff_type.value;
	var position_code		=	frmObj.position_code.value;
	var staff_id					=	frmObj.staff_id.value;
	var groupby				=	frmObj.groupby.value;
	var view						=	frmObj.view.value;
	var from_date				=	frmObj.from_date.value;
	var to_date					=	frmObj.to_date.value;
	var new_from_date	=	frmObj.p_from_date.value;
	var new_to_date			=	frmObj.p_to_date.value;
	var p_end					=	frmObj.p_end.value;
	var DAYS						=	frmObj.DAYS.value;
	var productive_flag	=	frmObj.productive_flag[frmObj.productive_flag.selectedIndex].value;
	parent.frameManageWorkScheduleHdr.location.href="../../eRS/jsp/ManageWorkScheduleHdr.jsp?user_id="+user_id+"&locn_type="+locn_type+"&workplace_code="+workplace_code+"&role_type="+role_type+"&staff_type="+staff_type+"&position_code="+position_code+"&staff_id="+staff_id+"&view="+view+"&groupby="+groupby+"&from_date="+from_date+"&to_date="+to_date+"&new_to_date="+new_to_date+"&new_from_date="+new_from_date+"&onclick_of=S"+"&facility_id="+facility_id+"&DAYS="+DAYS+"&productive_flag="+productive_flag;
}
/************************************************************/
function changePositionOpt(target){
	var frmObj		=	document.forms[0];
	frmObj.position_code.value	=	frmObj.position_opt[frmObj.position_opt.selectedIndex].value;
	var facility_id				=frmObj.facility_id.value;
	var user_id					=frmObj.user_id.value;
	var locn_type				=frmObj.locn_type.value;
	var workplace_code	=frmObj.workplace_code.value;
	var role_type				=frmObj.role_type.value;
	var staff_type				=frmObj.staff_type.value;
	var position_code		=frmObj.position_code.value;
	var staff_id					=frmObj.staff_id.value;
	var groupby				=frmObj.groupby.value;
	var view						=frmObj.view.value;
	var from_date				=frmObj.from_date.value;
	var to_date					=frmObj.to_date.value;
	var new_from_date	=	frmObj.p_from_date.value;
	var new_to_date		=	frmObj.p_to_date.value;
	var p_end					=	frmObj.p_end.value;
	var DAYS						=	frmObj.DAYS.value;
	parent.frameManageWorkScheduleHdr.location.href="../../eRS/jsp/ManageWorkScheduleHdr.jsp?user_id="+user_id+"&locn_type="+locn_type+"&workplace_code="+workplace_code+"&role_type="+role_type+"&staff_type="+staff_type+"&position_code="+position_code+"&staff_id="+staff_id+"&view="+view+"&groupby="+groupby+"&from_date="+from_date+"&to_date="+to_date+"&new_to_date="+new_to_date+"&new_from_date="+new_from_date+"&onclick_of=S"+"&facility_id="+facility_id+"&DAYS="+DAYS+"&productive_flag=W";
}
/************************************************************/
function expanddetails(obj, posit_code){
	var frmObj = document.forms[0];
	var disprow=eval(eval("document.getElementById("posit")"+posit_code));
	if(disprow){
		var dispstatus = obj.innerText;
		if(dispstatus == '+'){

			for(i=1;i<disprow.length;i++){
				disprow[i].style.display='inline';
			}
			obj.innerText="-";
			obj.style.cursor='hand';
			obj.innerHTML="<a id='view"+posit_code+" href='' width='2%'><font color='blue'><b>"+obj.innerText+"</b></font></a>";
		}else
		if(dispstatus == '-'){

			for(i=1;i<disprow.length;i++){
				disprow[i].style.display='none';
			}
			obj.innerText="+";
			obj.style.cursor='hand';
			obj.innerHTML="<a id='view"+posit_code+" href='' width='2%'><font color='blue'><b>"+obj.innerText+"</b></font></a>";
		}
	}
}
/**************STAFF CELL FUNCTION ****************************/
function showPopup(fac_id, wrkplace_code, posit_code, role_type, staff_id, from_date, shift_code, shift_mnem, prod_flag, day1, staff_type, curr_obj){

	show=1;
	curr_class = curr_obj.className;
	//alert("curr_class====586==>" +curr_class);
	if(shift_mnem == '&nbsp;')
		shift_mnemonic='';
	p_facility_id			=	fac_id;
	p_workplace_code	=	wrkplace_code;
	p_position_code		=	posit_code;
	p_role_type				=	role_type;
	p_staff_id				=	staff_id;
	p_date						=	from_date;
	p_productive_flag	=	prod_flag;
	p_staff_type			=	staff_type;
	p_cell_no					=	day1;
	day							=	day1;

	p_shift_mnemonic=	eval("document.forms[0].staffshift"+p_position_code+p_role_type+p_staff_id+day).value;
	p_shift_code=	eval("document.forms[0].staffshiftcode"+p_position_code+p_role_type+p_staff_id+day).value;
	//alert("p_shift_mnemonic===601==>" +p_shift_mnemonic);
	//alert("p_shift_code===601==>" +p_shift_code);
	var req=eval(eval("document.getElementById("posit")"+posit_code+day));
	var reqclass=req.className;
	
	
	if(reqclass != "EmptyCell"){
		//alert("Not Empty =reqclass==606" +reqclass);
		

		/*if(curr_class == 'LeaveStaff'){
			menu.style.visibility="hidden";
			message=getMessage("STAFF_NOT_AVAILABLE","RS");
			alert(message);
			return false;
		}*/
			if(curr_class == 'LeaveStaff'){
//-----------------Code Added for CanLeave Function By SrikantaR------------------------//
				menu.style.visibility="visible";
				alloc.style.fontWeight='normal';
				change.style.fontWeight='normal';
				swap.style.fontWeight='normal';
				transfer.style.fontWeight='normal';
				ot.style.fontWeight='normal';
				leave.style.fontWeight='normal';
				cancel.style.fontWeight='normal';
				cancelleave.style.fontWeight='bolder';
				view_sched.style.fontWeight='normal';

				prev_cell	=	eval(curr_cell);
				old_cell		=	eval(prev_cell);
				curr_cell	=	"document.all."+curr_obj.id;
				
				new_cell		=	eval(curr_cell);
				
				
				prev_class = curr_class;
		
							

				var rightedge=document.body.clientWidth-(event.clientX+15);
				var bottomedge=document.body.clientHeight-(event.clientY +15);

				if (rightedge<menu.offsetWidth)
					menu.style.left=document.body.scrollLeft+event.clientX-menu.offsetWidth;
				else
					menu.style.left=document.body.scrollLeft+event.clientX;

				if (bottomedge<menu.offsetHeight)
					menu.style.top=document.body.scrollTop+event.clientY-menu.offsetHeight-15;
				else
					menu.style.top=document.body.scrollTop+event.clientY+15;

				

				if(prev_opt == 'CC')
				new_cell.className='StaffList';
				else
					new_cell.className='LeaveStaff';
				return false;
	
//-----------------Code Added for CancelLeave Function End --By SrikantaR-----------------------//
			//message=getMessage("STAFF_NOT_AVAILABLE","RS");
			//alert(message);
			//alert("I am on leave ");
			//return false;
		}else{
			prev_cell	=	eval(curr_cell);
			curr_cell	=	"document.all."+curr_obj.id;
			new_cell		=	eval(curr_cell);
			old_cell		=	eval(prev_cell);

			if(old_cell != null){
				old_cell.className=prev_class;
				if(prev_opt == 'L')
					old_cell.className='LeaveStaff';
				if(prev_opt=='S' || prev_opt=='T')
					old_cell.className='StaffOtherWP';
					
			}

			prev_class = curr_class;

			new_cell.className='ActiveStaffList';
			var rightedge=document.body.clientWidth-(event.clientX+15);
			var bottomedge=document.body.clientHeight-(event.clientY +15);

			if (rightedge<menu.offsetWidth)
				menu.style.left=document.body.scrollLeft+event.clientX-menu.offsetWidth;
			else
				menu.style.left=document.body.scrollLeft+event.clientX;

			if (bottomedge<menu.offsetHeight)
				menu.style.top=document.body.scrollTop+event.clientY-menu.offsetHeight-15;
			else
				menu.style.top=document.body.scrollTop+event.clientY+15;

			if(p_shift_code == ''){
				alloc.style.fontWeight='bolder';
				change.style.fontWeight='normal';
				swap.style.fontWeight='normal';
				transfer.style.fontWeight='normal';
				ot.style.fontWeight='normal';
				leave.style.fontWeight='normal';
				cancel.style.fontWeight='normal';
				if(curr_class=="StaffList")
					view_sched.style.fontWeight='normal';
				else
					view_sched.style.fontWeight='bolder';

			}else{
				alloc.style.fontWeight='bolder';
				change.style.fontWeight='bolder';
				swap.style.fontWeight='bolder';
				transfer.style.fontWeight='bolder';
				ot.style.fontWeight='bolder';
				leave.style.fontWeight='bolder';
				cancel.style.fontWeight='bolder';
				view_sched.style.fontWeight='bolder';

			}
			menu.style.visibility="visible";
			return false;
		}
	}
	else{
		menu.style.visibility="hidden";
		return false;
	}
}
/***************************************************************/
function hidePopup(){
	if(show==0){
		menu=eval("manage_menu");
		menu.style.visibility="hidden"
		p_facility_id			=	'';
		p_workplace_code	=	'';
		p_position_code		=	'';
		p_role_type				=	'';
		p_staff_id				=	'';
		p_staff_type			=	'';
		p_schedule_date		=	'';
		p_shift_code			=	'';
		p_shift_mnemonic	=	'';
		p_productive_flag	=	'';
	}
	show=0;
}
/***************************************************************/
function over(){
	menu=eval("manage_menu");
	menu.style.backgroundColor="#B44664";
	event.target.style.backgroundColor="white";
	event.target.style.color="#B44664";
}
/***************************************************************/
function out(){
	menu=eval("manage_menu");
	menu.style.backgroundColor="#B44664";
	event.target.style.backgroundColor="#B44664";
	event.target.style.color="white";
}
/***************************************************************/
function showWindow(){
	
	menu.style.visibility="hidden";

	if (event.target.style.fontWeight=="bolder"){
		var opt = event.target.value;
		var url = "";

		var dialogHeight ='35' ;
		var dialogWidth = '45' ;
		var dialogTop	= '134';
		var dialogLeft = '124' ;

		var features = 'dialogHeight:' + dialogHeight + '; dialogWidth:' + dialogWidth +';dialogTop:'+dialogTop+';dialogLeft:'+dialogLeft+'; scroll=no; status=no';
		var arguments = "";

		switch(opt){
			
			case 'A':
				url='../../eRS/jsp/ManageWorkScheduleAllocateFrameset.jsp?p_facility_id='+p_facility_id+ '&p_workplace_code=' +p_workplace_code+ '&p_position_code='+p_position_code+ '&p_role_type='+p_role_type+'&p_staff_id='+p_staff_id+'&p_staff_type='+p_staff_type+ '&p_date='+p_date+'&p_cell_no='+p_cell_no+ '&p_shift_code='+p_shift_code+ '&p_shift_mnemonic='+p_shift_mnemonic+ '&p_productive_flag='+p_productive_flag;
				break;

			case  'CH':
				url='../../eRS/jsp/ManageWorkScheduleChangeFrameset.jsp?p_facility_id='+p_facility_id+ '&p_workplace_code=' +p_workplace_code+ '&p_position_code='+p_position_code+ '&p_role_type='+p_role_type+ '&p_staff_id='+p_staff_id+'&p_staff_type='+p_staff_type+ '&p_date='+p_date+'&p_cell_no='+p_cell_no+'&p_shift_code='+p_shift_code+ '&p_shift_mnemonic='+p_shift_mnemonic+ '&p_productive_flag='+p_productive_flag;
				break;

			case 'S':
				dialogHeight ='30' ;
				dialogTop	= '103';
				var features = 'dialogHeight:' + dialogHeight + '; dialogWidth:' + dialogWidth +';dialogTop:'+dialogTop+';dialogLeft:'+dialogLeft+'; scroll=no; status=no';

				url='../../eRS/jsp/ManageWorkScheduleSwapFrameset.jsp?p_facility_id='+p_facility_id+ '&p_workplace_code=' +p_workplace_code+ '&p_position_code='+p_position_code+ '&p_role_type='+p_role_type+ '&p_staff_id='+p_staff_id+'&p_staff_type='+p_staff_type+ '&p_date='+p_date+'&p_cell_no='+p_cell_no+  '&p_shift_code='+p_shift_code+ '&p_shift_mnemonic='+p_shift_mnemonic+ '&p_productive_flag='+p_productive_flag;
				break;

			case 'T':
				url='../../eRS/jsp/ManageWorkScheduleTransferFrameset.jsp?p_facility_id='+p_facility_id+ '&p_workplace_code=' +p_workplace_code+ '&p_position_code='+p_position_code+ '&p_role_type='+p_role_type+ '&p_staff_id='+p_staff_id+'&p_staff_type='+p_staff_type+ '&p_date='+p_date+'&p_cell_no='+p_cell_no+'&p_shift_code='+p_shift_code+ '&p_shift_mnemonic='+p_shift_mnemonic+ '&p_productive_flag='+p_productive_flag;
				break

			case 'O':
				url='../../eRS/jsp/ManageWorkScheduleOvertimeFrameset.jsp?p_facility_id='+p_facility_id+ '&p_workplace_code=' +p_workplace_code+ '&p_position_code='+p_position_code+ '&p_role_type='+p_role_type+ '&p_staff_id='+p_staff_id+'&p_staff_type='+p_staff_type+ '&p_date='+p_date+'&p_cell_no='+p_cell_no+ '&p_shift_code='+p_shift_code+ '&p_shift_mnemonic='+p_shift_mnemonic+ '&p_productive_flag='+p_productive_flag;
				break;

			case 'L':
				url='../../eRS/jsp/ManageWorkScheduleUnavailability.jsp?p_facility_id='+p_facility_id+ '&p_workplace_code=' +p_workplace_code+ '&p_position_code='+p_position_code+ '&p_role_type='+p_role_type+ '&p_staff_id='+p_staff_id+'&p_staff_type='+p_staff_type+'&p_date='+p_date+'&p_cell_no='+p_cell_no+'&p_shift_code='+p_shift_code+ '&p_shift_mnemonic='+p_shift_mnemonic+ '&p_productive_flag='+p_productive_flag;
				break;

			case 'CL':
				url='../../eRS/jsp/ManageWorkScheduleCancelFrameset.jsp?p_facility_id='+p_facility_id+ '&p_workplace_code=' +p_workplace_code+ '&p_position_code='+p_position_code+ '&p_role_type='+p_role_type+ '&p_staff_id='+p_staff_id+'&p_staff_type='+p_staff_type+ '&p_date='+p_date+'&p_cell_no='+p_cell_no+'&p_shift_code='+p_shift_code+ '&p_shift_mnemonic='+p_shift_mnemonic+ '&p_productive_flag='+p_productive_flag;
				break;
// ----------------Added By SrikantaR On Click Cancel Leave Window-------------------------------------------//
			case 'CnlL':
				url='../../eRS/jsp/ManageWorkScheduleCancelLeave.jsp?p_facility_id='+p_facility_id+ '&p_workplace_code=' +p_workplace_code+ '&p_position_code='+p_position_code+ '&p_role_type='+p_role_type+ '&p_staff_id='+p_staff_id+'&p_staff_type='+p_staff_type+ '&p_date='+p_date+'&p_cell_no='+p_cell_no+'&p_shift_code='+p_shift_code+ '&p_shift_mnemonic='+p_shift_mnemonic+ '&p_productive_flag='+p_productive_flag;
				dialogHeight ='20' ;
				dialogWidth = '45' ;
				dialogTop	= '110';
				dialogLeft = '100' ;


				features = 'dialogHeight:' + dialogHeight + '; dialogWidth:' + dialogWidth +';dialogTop:'+dialogTop+';dialogLeft:'+dialogLeft+'; scroll=no; status=no';
				break;
//--------------------------------Cancel Leave Window ends --------------------------------------------------//
			case 'VS':
				dialogHeight ='10' ;
				dialogWidth = '35' ;
				dialogTop	= '175';
				dialogLeft = '124' ;

				features = 'dialogHeight:' + dialogHeight + '; dialogWidth:' + dialogWidth +';dialogTop:'+dialogTop+';dialogLeft:'+dialogLeft+'; scroll=no; status=no';
				var arguments = "";

				url='../../eRS/jsp/ManageWorkScheduleViewStaffDaySchedule.jsp?p_facility_id='+p_facility_id+ '&p_workplace_code=' +p_workplace_code+ '&p_position_code='+p_position_code+ '&p_role_type='+p_role_type+ '&p_staff_id='+p_staff_id+'&p_staff_type='+p_staff_type+ '&p_date='+p_date+'&p_cell_no='+p_cell_no+'&p_shift_code='+p_shift_code+ '&p_shift_mnemonic='+p_shift_mnemonic+ '&p_productive_flag='+p_productive_flag;
				break;
		}
		


	
		 retVal = window.showModalDialog(url,arguments,features);

		if (retVal=='CnlL')
		{
							
				var url = "";
					//parent.frames[2].location.reload();
					var dialogHeight ='35' ;
					var dialogWidth = '45' ;
					var dialogTop	= '134';
					var dialogLeft = '124' ;

					var features = 'dialogHeight:' + dialogHeight + '; dialogWidth:' + dialogWidth +';dialogTop:'+dialogTop+';dialogLeft:'+dialogLeft+'; scroll=no; status=no';
					var arguments = "";
					url='../../eRS/jsp/ManageWorkScheduleAllocateFrameset.jsp?p_facility_id='+p_facility_id+ '&p_workplace_code=' +p_workplace_code+ '&p_position_code='+p_position_code+ '&p_role_type='+p_role_type+'&p_staff_id='+p_staff_id+'&p_staff_type='+p_staff_type+ '&p_date='+p_date+'&p_cell_no='+p_cell_no+ '&p_shift_code='+p_shift_code+ '&p_shift_mnemonic='+p_shift_mnemonic+ '&p_productive_flag='+p_productive_flag;
					retVal = window.showModalDialog(url,arguments,features);
					opt='A';
					prev_opt='CC';
					
					//messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ message;
					
		}
		
		if(retVal=='CnlLC')
		{
			opt="CLC";
			prev_opt='CC';
			 
		}


		if(retVal != null){
			

			switch(opt){
				case 'A':{
					allocateshift(retVal);
					break;
				}
				case 'CH':{
					changeshift(retVal);
					break;
				}
				case 'S':{
					swapshift(retVal);
					break;
				}
				case 'T':{
					cancelshift(retVal);
					prev_opt='T';
					break;
				}
				case 'O':{
					//overtime(retVal)
					break;
				}
				case 'L':{
					leaveShift(retVal);
					prev_opt='L';
					break;
				}
				case 'CL':{
					cancelshift(retVal);
					break;
				}
				default:
					cancelLeave(retVal);
				break;
				

			}
				
			

		}else
		{	
			//alert("inside else== 915=>");
			if(opt=='A')
			{ //alert("opt===A======917");
				retVal="UndA";
				closeAllocate(retVal);
			}
		}
	}
}
/*************************************************************************/

function allocateshift(retVal){

	
	var retVals	=	new Array();
	retVals	 =	 retVal.split("|");
	var shift_cd		=	retVals[0];
	var shift_mnem	 	=	retVals[1];
	var shift_ind			=	retVals[2];
	var prod_flag		=	retVals[3];
	//alert("shift_cd===935==>" +shift_cd);

	if(shift_ind == "U"){
		

		if((total_alloc == '')||(total_alloc==null))
			total_alloc=1;
		else
			total_alloc=parseInt(total_alloc)+1;

		eval("parent.frames[1].document.forms[0].u_totalalloc"+day).value	=	total_alloc;

		curr_total		=	eval(eval("parent.frames[1].document.getElementById("u_total")"+day));
		if((curr_total == '')||(curr_total==null))
			curr_Total='0';
		curr_total.innerText	=	total_alloc;

		var prev_mnem	=	eval("document.forms[0].staffshift"+p_position_code+p_role_type+p_staff_id+day).value
		var prev_shift_code	=	eval("document.forms[0].staffshiftcode"+p_position_code+p_role_type+p_staff_id+day).value	;
		
		prev_mnem	 =	 trim(prev_mnem);

		if(prev_shift_code == ""){
			prev_shift_code		=	shift_cd;
			prev_mnem				=	shift_mnem;
		}
		else{
			prev_shift_code	 =	 prev_shift_code+"|"+shift_cd;
			prev_mnem	 =	 prev_mnem+"|"+shift_mnem;
		}
		sortShift(prev_shift_code, prev_mnem);
		eval("document.forms[0].staffshift"+p_position_code+p_role_type+p_staff_id+day).value =	s_shift_mnemonic;		
		eval("document.forms[0].staffshiftcode"+p_position_code+p_role_type+p_staff_id+day).value = s_shift_code;
		new_cell.innerText	 =	 s_shift_mnemonic
	}
	else if(prod_flag == "O"){
		//alert("else if ===O=====> 971" +prod_flag);
		var total_alloc	 =	 eval("parent.frames[1].document.forms[0].o_totalalloc"+day).value;
		var positoncall_alloc	 =	 eval("document.forms[0].positoncallalloc"+p_position_code+"OOOOO"+day).value;

		if((total_alloc == '')||(total_alloc==null))
			total_alloc=1;
		else
			total_alloc=parseInt(total_alloc)+1;

		if((positoncall_alloc == '')||(positoncall_alloc==null))
			positoncall_alloc=1;
		else
			positoncall_alloc=parseInt(positoncall_alloc)+1;

		var total_req	 =	 eval("parent.frames[1].document.forms[0].o_totalreq"+day).value;
		var positoncall_req	 =	 eval("document.forms[0].positoncallreq"+p_position_code+"OOOOO"+day).value;

		if((total_req == '')||(total_req==null))
			total_req=0;
		total_req=parseInt(total_req);

		if((positoncall_req == '')||(positoncall_req==null))
			positoncall_req=0;
		positoncall_req=parseInt(positoncall_req);

		eval("parent.frames[1].document.forms[0].o_totalalloc"+day).value	=	total_alloc;
		eval("document.forms[0].positoncallalloc"+p_position_code+"OOOOO"+day).value	=	positoncall_alloc;

		curr_total		=	eval(eval("parent.frames[1].document.getElementById("o_total")"+day));
		curr_posit_shift		=	eval(eval("document.getElementById("positoncall")"+p_position_code+"OOOOO"+day));

		curr_total.innerText	=	total_alloc+"/"+total_req;
		curr_posit_shift.innerText	=	positoncall_alloc+"/"+positoncall_req;

		if(total_alloc < total_req)
			curr_total.className	=	"BELOWOPTIMAL";
		if(total_alloc > total_req)
			curr_total.className	=	"ABOVEOPTIMAL";
		if(total_alloc == total_req)
			curr_total.className	=	"OPTIMAL";

		if(positoncall_alloc < positoncall_req)
			curr_posit_shift.className	=	"BELOWOPTIMAL";
		if(positoncall_alloc > positoncall_req)
			curr_posit_shift.className	=	"ABOVEOPTIMAL";
		if(positoncall_alloc == positoncall_req)
			curr_posit_shift.className	=	"OPTIMAL";

		var prev_mnem	=	eval("document.forms[0].staffshift"+p_position_code+p_role_type+p_staff_id+day).value
		var prev_shift_code	=	eval("document.forms[0].staffshiftcode"+p_position_code+p_role_type+p_staff_id+day).value	;
		
		prev_mnem	 =	 trim(prev_mnem);

		if(prev_shift_code == ""){
			prev_shift_code		=	shift_cd;
			prev_mnem				=	shift_mnem;
		}
		else{
			prev_shift_code	 =	 prev_shift_code+"|"+shift_cd;
			prev_mnem	 =	 prev_mnem+"|"+shift_mnem;
		}
		sortShift(prev_shift_code, prev_mnem);
		eval("document.forms[0].staffshift"+p_position_code+p_role_type+p_staff_id+day).value =	s_shift_mnemonic;		
		eval("document.forms[0].staffshiftcode"+p_position_code+p_role_type+p_staff_id+day).value = s_shift_code;
		new_cell.innerText	 =	 s_shift_mnemonic

	}
	else if((shift_cd !='' )&&(shift_cd != null)&&(prod_flag == 'W')){
		//alert("inside else space,null,prod flag=w=====>1039");

		var total_alloc	 =	 eval("parent.frames[1].document.forms[0].w_totalalloc"+day).value;
		var shift_alloc	 =	 eval("parent.frames[1].document.forms[0].shiftalloc"+shift_cd+day).value;
		var posit_alloc =	 eval("document.forms[0].positalloc"+p_position_code+day).value;
		var positshift_alloc	 =	 eval("document.forms[0].positshiftalloc"+p_position_code+shift_cd+day).value;

		if((total_alloc == '')||(total_alloc==null))
			total_alloc=1;
		else
			total_alloc=parseInt(total_alloc)+1;

		if((shift_alloc == '')||(shift_alloc==null))
			shift_alloc=1;
		else
			shift_alloc=parseInt(shift_alloc)+1;

		if((posit_alloc == '')||(posit_alloc==null))
			posit_alloc=1;
		else
			posit_alloc=parseInt(posit_alloc)+1;

		if((positshift_alloc == '')||(positshift_alloc==null))
			positshift_alloc=1;
		else
			positshift_alloc=parseInt(positshift_alloc)+1;

		var total_req	 =	 eval("parent.frames[1].document.forms[0].w_totalreq"+day).value;
		var shift_req	 =	 eval("parent.frames[1].document.forms[0].shiftreq"+shift_cd+day).value;
		var posit_req	=	 eval("document.forms[0].positreq"+p_position_code+day).value;
		var positshift_req	 =	 eval("document.forms[0].positshiftreq"+p_position_code+shift_cd+day).value;

		if((total_req == '')||(total_req==null))
			total_req=0;

		if((shift_req == '')||(shift_req==null))
			shift_req=0;

		if((posit_req == '')||(posit_req==null))
			posit_req=0;

		if((positshift_req == '')||(positshift_req==null))
			positshift_req=0;

		total_req=parseInt(total_req);
		shift_req=parseInt(shift_req);
		posit_req=parseInt(posit_req);
		positshift_req=parseInt(positshift_req);

		eval("parent.frames[1].document.forms[0].w_totalalloc"+day).value	=	total_alloc;
		eval("parent.frames[1].document.forms[0].shiftalloc"+shift_cd+day).value	=	shift_alloc;
		eval("document.forms[0].positalloc"+p_position_code+day).value	 =	 posit_alloc;	
		eval("document.forms[0].positshiftalloc"+p_position_code+shift_cd+day).value=positshift_alloc;
		
		curr_total		=	eval(eval("parent.frames[1].document.getElementById("w_total")"+day));
		curr_shift		=	eval(eval("parent.frames[1].document.getElementById("shift")"+shift_cd+day));
		curr_posit		=	eval(eval("document.getElementById("posit")"+p_position_code+day));
		curr_posit_shift		=	eval(eval("document.getElementById("positshift")"+p_position_code+shift_cd+day));

		curr_total.innerText	=	total_alloc+"/"+total_req;
		curr_shift.innerText	=	shift_alloc+"/"+shift_req;
		curr_posit.innerText	=	posit_alloc+"/"+posit_req;
		curr_posit_shift.innerText			=	positshift_alloc+"/"+positshift_req;

		var prev_mnem	=	eval("document.forms[0].staffshift"+p_position_code+p_role_type+p_staff_id+day).value
		var prev_shift_code	=	eval("document.forms[0].staffshiftcode"+p_position_code+p_role_type+p_staff_id+day).value	;
		
		prev_mnem	 =	 trim(prev_mnem);

		if(prev_shift_code == ""){
			prev_shift_code		=	shift_cd;
			prev_mnem				=	shift_mnem;
		}
		else{
			prev_shift_code	 =	 prev_shift_code+"|"+shift_cd;
			prev_mnem	 =	 prev_mnem+"|"+shift_mnem;
		}
		sortShift(prev_shift_code, prev_mnem);
		eval("document.forms[0].staffshift"+p_position_code+p_role_type+p_staff_id+day).value =	s_shift_mnemonic;		
		eval("document.forms[0].staffshiftcode"+p_position_code+p_role_type+p_staff_id+day).value = s_shift_code;
		new_cell.innerText	 =	 s_shift_mnemonic
			
		changeColor(shift_cd);
	}
	s_shift_code="";
	s_shift_mnemonic="";
	
}
/*************************************************************************/
function changeshift(retVal){
	var shiftdata	=	new Array();
	shiftdata	 =	 retVal.split("~");
	if(shiftdata != null){
		cancelshift(shiftdata[0]);
		allocateshift(shiftdata[1]);
	}
}
/*************************************************************************/
function swapshift(retVal){
	var retData	=	new Array();
	retData		=	retVal.split("~");
	if(retData != null){
		var wrkflag	=	retData[0];
		if(wrkflag == 'W'){
			p_role_type		=	retData[1];
			p_staff_id		=	retData[2];
			var shiftdata1	=	retData[3];
			var shiftdata2	=	retData[6];
			cancelshift(shiftdata1);
			allocateshift(shiftdata2);
			p_role_type		=	retData[4];
			p_staff_id		=	retData[5];
			new_cell=eval(eval("document.getElementById("staff")"+p_position_code+p_role_type+p_staff_id+day));
			cancelshift(shiftdata2);
			allocateshift(shiftdata1);
		}
		if(wrkflag == 'A'){
			prev_opt='S';
		}
	}

}
/*************************************************************************/
function cancelshift(retVal){

	var shiftdata	=	new Array();
	shiftdata	 =	 retVal.split("~");

	for(count=0; count<shiftdata.length;count++){

		var shiftdata1	=	shiftdata[count].split("|");
		var shift_cd		=	shiftdata1[0];
		var shift_mnem	 	=	shiftdata1[1];
		var shift_ind			=	shiftdata1[2];
		var prod_flag		=	shiftdata1[3];

		if(shift_ind == "U"){

			if((total_alloc == '')||(total_alloc==null))
				total_alloc=0;
			else
				total_alloc=parseInt(total_alloc);
			if(total_alloc > 0)
				total_alloc--;

			eval("parent.frames[1].document.forms[0].u_totalalloc"+day).value	=	total_alloc;

			curr_total		=	eval(eval("parent.frames[1].document.getElementById("u_total")"+day));
			if((curr_total == '')||(curr_total==null))
				curr_Total='0';
			curr_total.innerText	=	total_alloc;

			var prev_mnem	=	eval("document.forms[0].staffshift"+p_position_code+p_role_type+p_staff_id+day).value
			var prev_shift_code	=	eval("document.forms[0].staffshiftcode"+p_position_code+p_role_type+p_staff_id+day).value	;
			
			prev_mnem	 =	 trim(prev_mnem);
			prev_shift_code	=	trim(prev_shift_code);
			var prev_mnems	 =	 prev_mnem.split("|");
			var prev_shift_codes	=	 prev_shift_code.split("|");
			var curr_shift_code ='';
			var curr_mnem = '';

			for(i=0;i<prev_mnems.length;i++){
				if(prev_mnems[i] != shift_mnem){
					if(curr_mnem == ''){
						curr_shift_code	= prev_shift_codes[i];
						curr_mnem	= prev_mnems[i];
					}else{
						curr_shift_code	= curr_shift_code+"|"+prev_shift_codes[i];
						curr_mnem	= curr_mnem+"|"+prev_mnems[i];
					}
				}
			}
			sortShift(curr_shift_code, curr_mnem);
			eval("document.forms[0].staffshift"+p_position_code+p_role_type+p_staff_id+day).value =	s_shift_mnemonic;		
			eval("document.forms[0].staffshiftcode"+p_position_code+p_role_type+p_staff_id+day).value = s_shift_code;
			new_cell.innerText	 =	 s_shift_mnemonic
		}
		else if(prod_flag == "O"){

			var total_alloc	 =	 eval("parent.frames[1].document.forms[0].o_totalalloc"+day).value;
			var positoncall_alloc	 =	 eval("document.forms[0].positoncallalloc"+p_position_code+"OOOOO"+day).value;
	
			if((total_alloc == '')||(total_alloc==null))
				total_alloc=0;
			else
				total_alloc=parseInt(total_alloc);

			if((positoncall_alloc == '')||(positoncall_alloc==null))
				positoncall_alloc=0;
			else
				positoncall_alloc=parseInt(positoncall_alloc);

			if(total_alloc > 0)
				total_alloc--;

			if(positoncall_alloc > 0)
				positoncall_alloc--;

			var total_req	 =	 eval("parent.frames[1].document.forms[0].o_totalreq"+day).value;
			var positoncall_req	 =	 eval("document.forms[0].positoncallreq"+p_position_code+"OOOOO"+day).value;

			if((total_req == '')||(total_req==null))
				total_req=0;
			total_req=parseInt(total_req);

			if((positoncall_req == '')||(positoncall_req==null))
				positoncall_req=0;
			positoncall_req=parseInt(positoncall_req);

			eval("parent.frames[1].document.forms[0].o_totalalloc"+day).value	=	total_alloc;
			eval("document.forms[0].positoncallalloc"+p_position_code+"OOOOO"+day).value	=	positoncall_alloc;

			curr_total		=	eval(eval("parent.frames[1].document.getElementById("o_total")"+day));
			curr_posit_shift		=	eval(eval("document.getElementById("positoncall")"+p_position_code+"OOOOO"+day));
	
			curr_total.innerText	=	total_alloc+"/"+total_req;
			curr_posit_shift.innerText	=	positoncall_alloc+"/"+positoncall_req;

			if(total_alloc < total_req)
				curr_total.className	=	"BELOWOPTIMAL";
			if(total_alloc > total_req)
				curr_total.className	=	"ABOVEOPTIMAL";
			if(total_alloc == total_req)
				curr_total.className	=	"OPTIMAL";

			if(positoncall_alloc < positoncall_req)
				curr_posit_shift.className	=	"BELOWOPTIMAL";
			if(positoncall_alloc > positoncall_req)
				curr_posit_shift.className	=	"ABOVEOPTIMAL";
			if(positoncall_alloc == positoncall_req)
				curr_posit_shift.className	=	"OPTIMAL";

			var prev_mnem	=	eval("document.forms[0].staffshift"+p_position_code+p_role_type+p_staff_id+day).value
			var prev_shift_code	=	eval("document.forms[0].staffshiftcode"+p_position_code+p_role_type+p_staff_id+day).value	;
			
			prev_mnem	 =	 trim(prev_mnem);
			prev_shift_code	=	trim(prev_shift_code);
			var prev_mnems	 =	 prev_mnem.split("|");
			var prev_shift_codes	=	 prev_shift_code.split("|");
			var curr_shift_code ='';
			var curr_mnem = '';

			for(i=0;i<prev_mnems.length;i++){
				if(prev_mnems[i] != shift_mnem){
					if(curr_mnem == ''){
						curr_shift_code	= prev_shift_codes[i];
						curr_mnem	= prev_mnems[i];
					}else{
						curr_shift_code	= curr_shift_code+"|"+prev_shift_codes[i];
						curr_mnem	= curr_mnem+"|"+prev_mnems[i];
					}
				}
			}
			sortShift(curr_shift_code, curr_mnem);
			eval("document.forms[0].staffshift"+p_position_code+p_role_type+p_staff_id+day).value =	s_shift_mnemonic;		
			eval("document.forms[0].staffshiftcode"+p_position_code+p_role_type+p_staff_id+day).value = s_shift_code;
			new_cell.innerText	 =	 s_shift_mnemonic

		}
		else if((shift_cd !='' )&&(shift_cd != null)&&(prod_flag == 'W')){

			var total_alloc	 =	 eval("parent.frames[1].document.forms[0].w_totalalloc"+day).value;
			var shift_alloc	 =	 eval("parent.frames[1].document.forms[0].shiftalloc"+shift_cd+day).value;
			var posit_alloc =	 eval("document.forms[0].positalloc"+p_position_code+day).value;
			var positshift_alloc	 =	 eval("document.forms[0].positshiftalloc"+p_position_code+shift_cd+day).value;

			if((total_alloc == '')||(total_alloc==null))
				total_alloc=0;
			else
				total_alloc=parseInt(total_alloc);
			if(total_alloc > 0)
				total_alloc--;

			if((shift_alloc == '')||(shift_alloc==null))
				shift_alloc=0;
			else
				shift_alloc=parseInt(shift_alloc);
			if(shift_alloc > 0)
				shift_alloc--;

			if((posit_alloc == '')||(posit_alloc==null))
				posit_alloc=0;
			else
				posit_alloc=parseInt(posit_alloc);
			if(posit_alloc > 0)
				posit_alloc--;

			if((positshift_alloc == '')||(positshift_alloc==null))
				positshift_alloc=0;
			else
				positshift_alloc=parseInt(positshift_alloc);
			if(positshift_alloc > 0)
				positshift_alloc--;

			var total_req	 =	 eval("parent.frames[1].document.forms[0].w_totalreq"+day).value;
			var shift_req	 =	 eval("parent.frames[1].document.forms[0].shiftreq"+shift_cd+day).value;
			var posit_req	=	 eval("document.forms[0].positreq"+p_position_code+day).value;
			var positshift_req	 =	 eval("document.forms[0].positshiftreq"+p_position_code+shift_cd+day).value;

			if((total_req == '')||(total_req==null))
				total_req=0;

			if((shift_req == '')||(shift_req==null))
				shift_req=0;

			if((posit_req == '')||(posit_req==null))
				posit_req=0;

			if((positshift_req == '')||(positshift_req==null))
				positshift_req=0;

			total_req=parseInt(total_req);
			shift_req=parseInt(shift_req);
			posit_req=parseInt(posit_req);
			positshift_req=parseInt(positshift_req);

			eval("parent.frames[1].document.forms[0].w_totalalloc"+day).value	=	total_alloc;
			eval("parent.frames[1].document.forms[0].shiftalloc"+shift_cd+day).value	=	shift_alloc;
			eval("document.forms[0].positalloc"+p_position_code+day).value	 =	 posit_alloc;	
			eval("document.forms[0].positshiftalloc"+p_position_code+shift_cd+day).value=positshift_alloc;
			
			curr_total		=	eval(eval("parent.frames[1].document.getElementById("w_total")"+day));
			curr_shift		=	eval(eval("parent.frames[1].document.getElementById("shift")"+shift_cd+day));
			curr_posit		=	eval(eval("document.getElementById("posit")"+p_position_code+day));
			curr_posit_shift		=	eval(eval("document.getElementById("positshift")"+p_position_code+shift_cd+day));

			curr_total.innerText	=	total_alloc+"/"+total_req;
			curr_shift.innerText	=	shift_alloc+"/"+shift_req;
			curr_posit.innerText	=	posit_alloc+"/"+posit_req;
			curr_posit_shift.innerText			=	positshift_alloc+"/"+positshift_req;
			changeColor(shift_cd);

			var prev_mnem	=	eval("document.forms[0].staffshift"+p_position_code+p_role_type+p_staff_id+day).value
			var prev_shift_code	=	eval("document.forms[0].staffshiftcode"+p_position_code+p_role_type+p_staff_id+day).value	;
			
		/*	var prev_mnem	=	p_shift_mnemonic;
			var prev_shift_code	=	p_shift_code;*/

			prev_mnem	 =	 trim(prev_mnem);
			prev_shift_code	=	trim(prev_shift_code);
			var prev_mnems	 =	 prev_mnem.split("|");
			var prev_shift_codes	=	 prev_shift_code.split("|");
			var curr_shift_code ='';
			var curr_mnem = '';

			for(i=0;i<prev_mnems.length;i++){
				if(prev_mnems[i] != shift_mnem){
					if(curr_mnem == ''){
						curr_shift_code	= prev_shift_codes[i];
						curr_mnem	= prev_mnems[i];
					}else{
						curr_shift_code	= curr_shift_code+"|"+prev_shift_codes[i];
						curr_mnem	= curr_mnem+"|"+prev_mnems[i];
					}
				}
			}
		//	alert("Final : "+curr_shift_code+" - "+curr_mnem);
			sortShift(curr_shift_code, curr_mnem);
	//		alert("after sort Final : "+s_shift_code+" - "+s_shift_mnemonic);

			eval("document.forms[0].staffshift"+p_position_code+p_role_type+p_staff_id+day).value =	s_shift_mnemonic;		
			eval("document.forms[0].staffshiftcode"+p_position_code+p_role_type+p_staff_id+day).value = s_shift_code;
			if(s_shift_mnemonic =='')
				new_cell.innerHTML='&nbsp;'
			else
				new_cell.innerText	 =	 s_shift_mnemonic
			changeColor(shift_cd);
		}
	s_shift_code="";
	s_shift_mnemonic="";
	}
}
/**************************************************************************/
function leaveShift(retVal){

	var shiftdata	=	new Array();
	shiftdata	 =	 retVal.split("~");

	for(count=0; count<shiftdata.length;count++){

		var shiftdata1	=	shiftdata[count].split("|");
		var shift_cd		=	shiftdata1[0];
		var shift_mnem	 	=	shiftdata1[1];
		var shift_ind			=	shiftdata1[2];
		var prod_flag		=	shiftdata1[3];

		if(shift_ind == "U"){

			if((total_alloc == '')||(total_alloc==null))
				total_alloc=0;
			else
				total_alloc=parseInt(total_alloc);
			if(total_alloc > 0)
				total_alloc--;

			eval("parent.frames[1].document.forms[0].u_totalalloc"+day).value	=	total_alloc;

			curr_total		=	eval(eval("parent.frames[1].document.getElementById("u_total")"+day));
			if((curr_total == '')||(curr_total==null))
				curr_Total='0';
			curr_total.innerText	=	total_alloc;

			var prev_mnem	=	eval("document.forms[0].staffshift"+p_position_code+p_role_type+p_staff_id+day).value
			var prev_shift_code	=	eval("document.forms[0].staffshiftcode"+p_position_code+p_role_type+p_staff_id+day).value	;
			
			prev_mnem	 =	 trim(prev_mnem);
			prev_shift_code	=	trim(prev_shift_code);
			var prev_mnems	 =	 prev_mnem.split("|");
			var prev_shift_codes	=	 prev_shift_code.split("|");
			var curr_shift_code ='';
			var curr_mnem = '';

			for(i=0;i<prev_mnems.length;i++){
				if(prev_mnems[i] != shift_mnem){
					if(curr_mnem == ''){
						curr_shift_code	= prev_shift_codes[i];
						curr_mnem	= prev_mnems[i];
					}else{
						curr_shift_code	= curr_shift_code+"|"+prev_shift_codes[i];
						curr_mnem	= curr_mnem+"|"+prev_mnems[i];
					}
				}
			}
			sortShift(curr_shift_code, curr_mnem);
			eval("document.forms[0].staffshift"+p_position_code+p_role_type+p_staff_id+day).value =	s_shift_mnemonic;		
			eval("document.forms[0].staffshiftcode"+p_position_code+p_role_type+p_staff_id+day).value = s_shift_code;
			new_cell.innerText	 =	 s_shift_mnemonic
		}
		else if(prod_flag == "O"){

			var total_alloc	 =	 eval("parent.frames[1].document.forms[0].o_totalalloc"+day).value;
			var positoncall_alloc	 =	 eval("document.forms[0].positoncallalloc"+p_position_code+"OOOOO"+day).value;
	
			if((total_alloc == '')||(total_alloc==null))
				total_alloc=0;
			else
				total_alloc=parseInt(total_alloc);

			if((positoncall_alloc == '')||(positoncall_alloc==null))
				positoncall_alloc=0;
			else
				positoncall_alloc=parseInt(positoncall_alloc);

			if(total_alloc > 0)
				total_alloc--;

			if(positoncall_alloc > 0)
				positoncall_alloc--;

			var total_req	 =	 eval("parent.frames[1].document.forms[0].o_totalreq"+day).value;
			var positoncall_req	 =	 eval("document.forms[0].positoncallreq"+p_position_code+"OOOOO"+day).value;

			if((total_req == '')||(total_req==null))
				total_req=0;
			total_req=parseInt(total_req);

			if((positoncall_req == '')||(positoncall_req==null))
				positoncall_req=0;
			positoncall_req=parseInt(positoncall_req);

			eval("parent.frames[1].document.forms[0].o_totalalloc"+day).value	=	total_alloc;
			eval("document.forms[0].positoncallalloc"+p_position_code+"OOOOO"+day).value	=	positoncall_alloc;

			curr_total		=	eval(eval("parent.frames[1].document.getElementById("o_total")"+day));
			curr_posit_shift		=	eval(eval("document.getElementById("positoncall")"+p_position_code+"OOOOO"+day));
	
			curr_total.innerText	=	total_alloc+"/"+total_req;
			curr_posit_shift.innerText	=	positoncall_alloc+"/"+positoncall_req;

			if(total_alloc < total_req)
				curr_total.className	=	"BELOWOPTIMAL";
			if(total_alloc > total_req)
				curr_total.className	=	"ABOVEOPTIMAL";
			if(total_alloc == total_req)
				curr_total.className	=	"OPTIMAL";

			if(positoncall_alloc < positoncall_req)
				curr_posit_shift.className	=	"BELOWOPTIMAL";
			if(positoncall_alloc > positoncall_req)
				curr_posit_shift.className	=	"ABOVEOPTIMAL";
			if(positoncall_alloc == positoncall_req)
				curr_posit_shift.className	=	"OPTIMAL";

			var prev_mnem	=	eval("document.forms[0].staffshift"+p_position_code+p_role_type+p_staff_id+day).value
			var prev_shift_code	=	eval("document.forms[0].staffshiftcode"+p_position_code+p_role_type+p_staff_id+day).value	;
			
			prev_mnem	 =	 trim(prev_mnem);
			prev_shift_code	=	trim(prev_shift_code);
			var prev_mnems	 =	 prev_mnem.split("|");
			var prev_shift_codes	=	 prev_shift_code.split("|");
			var curr_shift_code ='';
			var curr_mnem = '';

			for(i=0;i<prev_mnems.length;i++){
				if(prev_mnems[i] != shift_mnem){
					if(curr_mnem == ''){
						curr_shift_code	= prev_shift_codes[i];
						curr_mnem	= prev_mnems[i];
					}else{
						curr_shift_code	= curr_shift_code+"|"+prev_shift_codes[i];
						curr_mnem	= curr_mnem+"|"+prev_mnems[i];
					}
				}
			}
			sortShift(curr_shift_code, curr_mnem);
			eval("document.forms[0].staffshift"+p_position_code+p_role_type+p_staff_id+day).value =	s_shift_mnemonic;		
			eval("document.forms[0].staffshiftcode"+p_position_code+p_role_type+p_staff_id+day).value = s_shift_code;
			new_cell.innerText	 =	 s_shift_mnemonic

		}
		else if((shift_cd !='' )&&(shift_cd != null)&&(prod_flag == 'W')){

			var total_alloc	 =	 eval("parent.frames[1].document.forms[0].w_totalalloc"+day).value;
			var shift_alloc	 =	 eval("parent.frames[1].document.forms[0].shiftalloc"+shift_cd+day).value;
			var posit_alloc =	 eval("document.forms[0].positalloc"+p_position_code+day).value;
			var positshift_alloc	 =	 eval("document.forms[0].positshiftalloc"+p_position_code+shift_cd+day).value;

			if((total_alloc == '')||(total_alloc==null))
				total_alloc=0;
			else
				total_alloc=parseInt(total_alloc);
			if(total_alloc > 0)
				total_alloc--;

			if((shift_alloc == '')||(shift_alloc==null))
				shift_alloc=0;
			else
				shift_alloc=parseInt(shift_alloc);
			if(shift_alloc > 0)
				shift_alloc--;

			if((posit_alloc == '')||(posit_alloc==null))
				posit_alloc=0;
			else
				posit_alloc=parseInt(posit_alloc);
			if(posit_alloc > 0)
				posit_alloc--;

			if((positshift_alloc == '')||(positshift_alloc==null))
				positshift_alloc=0;
			else
				positshift_alloc=parseInt(positshift_alloc);
			if(positshift_alloc > 0)
				positshift_alloc--;

			var total_req	 =	 eval("parent.frames[1].document.forms[0].w_totalreq"+day).value;
			var shift_req	 =	 eval("parent.frames[1].document.forms[0].shiftreq"+shift_cd+day).value;
			var posit_req	=	 eval("document.forms[0].positreq"+p_position_code+day).value;
			var positshift_req	 =	 eval("document.forms[0].positshiftreq"+p_position_code+shift_cd+day).value;

			if((total_req == '')||(total_req==null))
				total_req=0;

			if((shift_req == '')||(shift_req==null))
				shift_req=0;

			if((posit_req == '')||(posit_req==null))
				posit_req=0;

			if((positshift_req == '')||(positshift_req==null))
				positshift_req=0;

			total_req=parseInt(total_req);
			shift_req=parseInt(shift_req);
			posit_req=parseInt(posit_req);
			positshift_req=parseInt(positshift_req);

			eval("parent.frames[1].document.forms[0].w_totalalloc"+day).value	=	total_alloc;
			eval("parent.frames[1].document.forms[0].shiftalloc"+shift_cd+day).value	=	shift_alloc;
			eval("document.forms[0].positalloc"+p_position_code+day).value	 =	 posit_alloc;	
			eval("document.forms[0].positshiftalloc"+p_position_code+shift_cd+day).value=positshift_alloc;
			
			curr_total		=	eval(eval("parent.frames[1].document.getElementById("w_total")"+day));
			curr_shift		=	eval(eval("parent.frames[1].document.getElementById("shift")"+shift_cd+day));
			curr_posit		=	eval(eval("document.getElementById("posit")"+p_position_code+day));
			curr_posit_shift		=	eval(eval("document.getElementById("positshift")"+p_position_code+shift_cd+day));

			curr_total.innerText	=	total_alloc+"/"+total_req;
			curr_shift.innerText	=	shift_alloc+"/"+shift_req;
			curr_posit.innerText	=	posit_alloc+"/"+posit_req;
			curr_posit_shift.innerText			=	positshift_alloc+"/"+positshift_req;
			changeColor(shift_cd);

			var prev_mnem	=	eval("document.forms[0].staffshift"+p_position_code+p_role_type+p_staff_id+day).value
			var prev_shift_code	=	eval("document.forms[0].staffshiftcode"+p_position_code+p_role_type+p_staff_id+day).value	;
			
		/*	var prev_mnem	=	p_shift_mnemonic;
			var prev_shift_code	=	p_shift_code;*/

			prev_mnem	 =	 trim(prev_mnem);
			prev_shift_code	=	trim(prev_shift_code);
			var prev_mnems	 =	 prev_mnem.split("|");
			var prev_shift_codes	=	 prev_shift_code.split("|");
			var curr_shift_code ='';
			var curr_mnem = '';

			for(i=0;i<prev_mnems.length;i++){
				if(prev_mnems[i] != shift_mnem){
					if(curr_mnem == ''){
						curr_shift_code	= prev_shift_codes[i];
						curr_mnem	= prev_mnems[i];
					}else{
						curr_shift_code	= curr_shift_code+"|"+prev_shift_codes[i];
						curr_mnem	= curr_mnem+"|"+prev_mnems[i];
					}
				}
			}
		//	alert("Final : "+curr_shift_code+" - "+curr_mnem);
			sortShift(curr_shift_code, curr_mnem);
	//		alert("after sort Final : "+s_shift_code+" - "+s_shift_mnemonic);

			eval("document.forms[0].staffshift"+p_position_code+p_role_type+p_staff_id+day).value =	s_shift_mnemonic;		
			eval("document.forms[0].staffshiftcode"+p_position_code+p_role_type+p_staff_id+day).value = s_shift_code;
			if(s_shift_mnemonic =='')
				new_cell.innerHTML="<div align='center'><img src='../../eRS/images/leave_icon.gif'></img></div>";
			else
				new_cell.innerText	 =	 s_shift_mnemonic
			changeColor(shift_cd);
		}
	s_shift_code="";
	s_shift_mnemonic="";
	}
}
/**************************************************************************/
function cancelLeave(retVal){

	var shiftdata	=	new Array();
	shiftdata	 =	 retVal.split("~");

	for(count=0; count<shiftdata.length;count++){

		var shiftdata1	=	shiftdata[count].split("|");
		var shift_cd		=	shiftdata1[0];
		var shift_mnem	 	=	shiftdata1[1];
		var shift_ind			=	shiftdata1[2];
		var prod_flag		=	shiftdata1[3];

		if(shift_ind == "U"){

			if((total_alloc == '')||(total_alloc==null))
				total_alloc=0;
			else
				total_alloc=parseInt(total_alloc);
			if(total_alloc > 0)
				total_alloc--;

			eval("parent.frames[1].document.forms[0].u_totalalloc"+day).value	=	total_alloc;

			curr_total		=	eval(eval("parent.frames[1].document.getElementById("u_total")"+day));
			if((curr_total == '')||(curr_total==null))
				curr_Total='0';
			curr_total.innerText	=	total_alloc;

			var prev_mnem	=	eval("document.forms[0].staffshift"+p_position_code+p_role_type+p_staff_id+day).value
			var prev_shift_code	=	eval("document.forms[0].staffshiftcode"+p_position_code+p_role_type+p_staff_id+day).value	;
			
			prev_mnem	 =	 trim(prev_mnem);
			prev_shift_code	=	trim(prev_shift_code);
			var prev_mnems	 =	 prev_mnem.split("|");
			var prev_shift_codes	=	 prev_shift_code.split("|");
			var curr_shift_code ='';
			var curr_mnem = '';

			for(i=0;i<prev_mnems.length;i++){
				if(prev_mnems[i] != shift_mnem){
					if(curr_mnem == ''){
						curr_shift_code	= prev_shift_codes[i];
						curr_mnem	= prev_mnems[i];
					}else{
						curr_shift_code	= curr_shift_code+"|"+prev_shift_codes[i];
						curr_mnem	= curr_mnem+"|"+prev_mnems[i];
					}
				}
			}
			sortShift(curr_shift_code, curr_mnem);
			eval("document.forms[0].staffshift"+p_position_code+p_role_type+p_staff_id+day).value =	s_shift_mnemonic;		
			eval("document.forms[0].staffshiftcode"+p_position_code+p_role_type+p_staff_id+day).value = s_shift_code;
			new_cell.innerText	 =	 s_shift_mnemonic
		}
		else if(prod_flag == "O"){

			var total_alloc	 =	 eval("parent.frames[1].document.forms[0].o_totalalloc"+day).value;
			var positoncall_alloc	 =	 eval("document.forms[0].positoncallalloc"+p_position_code+"OOOOO"+day).value;
	
			if((total_alloc == '')||(total_alloc==null))
				total_alloc=0;
			else
				total_alloc=parseInt(total_alloc);

			if((positoncall_alloc == '')||(positoncall_alloc==null))
				positoncall_alloc=0;
			else
				positoncall_alloc=parseInt(positoncall_alloc);

			if(total_alloc > 0)
				total_alloc--;

			if(positoncall_alloc > 0)
				positoncall_alloc--;

			var total_req	 =	 eval("parent.frames[1].document.forms[0].o_totalreq"+day).value;
			var positoncall_req	 =	 eval("document.forms[0].positoncallreq"+p_position_code+"OOOOO"+day).value;

			if((total_req == '')||(total_req==null))
				total_req=0;
			total_req=parseInt(total_req);

			if((positoncall_req == '')||(positoncall_req==null))
				positoncall_req=0;
			positoncall_req=parseInt(positoncall_req);

			eval("parent.frames[1].document.forms[0].o_totalalloc"+day).value	=	total_alloc;
			eval("document.forms[0].positoncallalloc"+p_position_code+"OOOOO"+day).value	=	positoncall_alloc;

			curr_total		=	eval(eval("parent.frames[1].document.getElementById("o_total")"+day));
			curr_posit_shift		=	eval(eval("document.getElementById("positoncall")"+p_position_code+"OOOOO"+day));
	
			curr_total.innerText	=	total_alloc+"/"+total_req;
			curr_posit_shift.innerText	=	positoncall_alloc+"/"+positoncall_req;

			if(total_alloc < total_req)
				curr_total.className	=	"BELOWOPTIMAL";
			if(total_alloc > total_req)
				curr_total.className	=	"ABOVEOPTIMAL";
			if(total_alloc == total_req)
				curr_total.className	=	"OPTIMAL";

			if(positoncall_alloc < positoncall_req)
				curr_posit_shift.className	=	"BELOWOPTIMAL";
			if(positoncall_alloc > positoncall_req)
				curr_posit_shift.className	=	"ABOVEOPTIMAL";
			if(positoncall_alloc == positoncall_req)
				curr_posit_shift.className	=	"OPTIMAL";

			var prev_mnem	=	eval("document.forms[0].staffshift"+p_position_code+p_role_type+p_staff_id+day).value
			var prev_shift_code	=	eval("document.forms[0].staffshiftcode"+p_position_code+p_role_type+p_staff_id+day).value	;
			
			prev_mnem	 =	 trim(prev_mnem);
			prev_shift_code	=	trim(prev_shift_code);
			var prev_mnems	 =	 prev_mnem.split("|");
			var prev_shift_codes	=	 prev_shift_code.split("|");
			var curr_shift_code ='';
			var curr_mnem = '';

			for(i=0;i<prev_mnems.length;i++){
				if(prev_mnems[i] != shift_mnem){
					if(curr_mnem == ''){
						curr_shift_code	= prev_shift_codes[i];
						curr_mnem	= prev_mnems[i];
					}else{
						curr_shift_code	= curr_shift_code+"|"+prev_shift_codes[i];
						curr_mnem	= curr_mnem+"|"+prev_mnems[i];
					}
				}
			}
			sortShift(curr_shift_code, curr_mnem);
			eval("document.forms[0].staffshift"+p_position_code+p_role_type+p_staff_id+day).value =	s_shift_mnemonic;		
			eval("document.forms[0].staffshiftcode"+p_position_code+p_role_type+p_staff_id+day).value = s_shift_code;
			new_cell.innerText	 =	 s_shift_mnemonic

		}
		else if((shift_cd !='' )&&(shift_cd != null)&&(prod_flag == 'W')){

			var total_alloc	 =	 eval("parent.frames[1].document.forms[0].w_totalalloc"+day).value;
			var shift_alloc	 =	 eval("parent.frames[1].document.forms[0].shiftalloc"+shift_cd+day).value;
			var posit_alloc =	 eval("document.forms[0].positalloc"+p_position_code+day).value;
			var positshift_alloc	 =	 eval("document.forms[0].positshiftalloc"+p_position_code+shift_cd+day).value;

			if((total_alloc == '')||(total_alloc==null))
				total_alloc=0;
			else
				total_alloc=parseInt(total_alloc);
			if(total_alloc > 0)
				total_alloc--;

			if((shift_alloc == '')||(shift_alloc==null))
				shift_alloc=0;
			else
				shift_alloc=parseInt(shift_alloc);
			if(shift_alloc > 0)
				shift_alloc--;

			if((posit_alloc == '')||(posit_alloc==null))
				posit_alloc=0;
			else
				posit_alloc=parseInt(posit_alloc);
			if(posit_alloc > 0)
				posit_alloc--;

			if((positshift_alloc == '')||(positshift_alloc==null))
				positshift_alloc=0;
			else
				positshift_alloc=parseInt(positshift_alloc);
			if(positshift_alloc > 0)
				positshift_alloc--;

			var total_req	 =	 eval("parent.frames[1].document.forms[0].w_totalreq"+day).value;
			var shift_req	 =	 eval("parent.frames[1].document.forms[0].shiftreq"+shift_cd+day).value;
			var posit_req	=	 eval("document.forms[0].positreq"+p_position_code+day).value;
			var positshift_req	 =	 eval("document.forms[0].positshiftreq"+p_position_code+shift_cd+day).value;

			if((total_req == '')||(total_req==null))
				total_req=0;

			if((shift_req == '')||(shift_req==null))
				shift_req=0;

			if((posit_req == '')||(posit_req==null))
				posit_req=0;

			if((positshift_req == '')||(positshift_req==null))
				positshift_req=0;

			total_req=parseInt(total_req);
			shift_req=parseInt(shift_req);
			posit_req=parseInt(posit_req);
			positshift_req=parseInt(positshift_req);

			eval("parent.frames[1].document.forms[0].w_totalalloc"+day).value	=	total_alloc;
			eval("parent.frames[1].document.forms[0].shiftalloc"+shift_cd+day).value	=	shift_alloc;
			eval("document.forms[0].positalloc"+p_position_code+day).value	 =	 posit_alloc;	
			eval("document.forms[0].positshiftalloc"+p_position_code+shift_cd+day).value=positshift_alloc;
			
			curr_total		=	eval(eval("parent.frames[1].document.getElementById("w_total")"+day));
			curr_shift		=	eval(eval("parent.frames[1].document.getElementById("shift")"+shift_cd+day));
			curr_posit		=	eval(eval("document.getElementById("posit")"+p_position_code+day));
			curr_posit_shift		=	eval(eval("document.getElementById("positshift")"+p_position_code+shift_cd+day));

			curr_total.innerText	=	total_alloc+"/"+total_req;
			curr_shift.innerText	=	shift_alloc+"/"+shift_req;
			curr_posit.innerText	=	posit_alloc+"/"+posit_req;
			curr_posit_shift.innerText			=	positshift_alloc+"/"+positshift_req;
			changeColor(shift_cd);

			var prev_mnem	=	eval("document.forms[0].staffshift"+p_position_code+p_role_type+p_staff_id+day).value
			var prev_shift_code	=	eval("document.forms[0].staffshiftcode"+p_position_code+p_role_type+p_staff_id+day).value	;
			
		/*	var prev_mnem	=	p_shift_mnemonic;
			var prev_shift_code	=	p_shift_code;*/

			prev_mnem	 =	 trim(prev_mnem);
			prev_shift_code	=	trim(prev_shift_code);
			var prev_mnems	 =	 prev_mnem.split("|");
			var prev_shift_codes	=	 prev_shift_code.split("|");
			var curr_shift_code ='';
			var curr_mnem = '';

			for(i=0;i<prev_mnems.length;i++){
				if(prev_mnems[i] != shift_mnem){
					if(curr_mnem == ''){
						curr_shift_code	= prev_shift_codes[i];
						curr_mnem	= prev_mnems[i];
					}else{
						curr_shift_code	= curr_shift_code+"|"+prev_shift_codes[i];
						curr_mnem	= curr_mnem+"|"+prev_mnems[i];
					}
				}
			}
		//	alert("Final : "+curr_shift_code+" - "+curr_mnem);
			sortShift(curr_shift_code, curr_mnem);
	//		alert("after sort Final : "+s_shift_code+" - "+s_shift_mnemonic);

			eval("document.forms[0].staffshift"+p_position_code+p_role_type+p_staff_id+day).value =	s_shift_mnemonic;		
			eval("document.forms[0].staffshiftcode"+p_position_code+p_role_type+p_staff_id+day).value = s_shift_code;
			if(s_shift_mnemonic =='')
				new_cell.innerHTML='&nbsp;'
			else
				new_cell.innerText	 =	 s_shift_mnemonic
			changeColor(shift_cd);
		}
		else
		{
			
			
				new_cell.innerHTML='&nbsp;'

		}
		
	s_shift_code="";
	s_shift_mnemonic="";
	}
}
/**************************************************************************/

function trim(check) {
	
    var startPos;
    var ch;
   // startPos = 0;
    strlength = check.length;
	var retstr="";

    for(var i=0;i<=strlength;i++) {
        ch = check.charAt(i);
        if(!((ch == " ") || (ch == "\b") || (ch == "\f") || (ch == "\n") || 

(ch == "\r") || (ch == "\n"))) {
            retstr=retstr+check.charAt(i);
        }
    }
	return retstr;
}
/**************************************************************************/
function sortShift(shift_cd, mnemonic){
	
	if(shift_cd !=null)
		shift_codes=shift_cd.split('|');
	if(mnemonic != null)
		mnemonics=mnemonic.split('|');
	for(i=0;i<mnemonics.length;i++){
		for(j=i+1; j<mnemonics.length;j++){
			if(mnemonics[i] > mnemonics[j]){
				temp=mnemonics[i];
				mnemonics[i]=mnemonics[j];
				mnemonics[j]=temp;
				temp=shift_codes[i];
				shift_codes[i]=shift_codes[j];
				shift_codes[j]=temp;
			}
		}
	}
	for(i=0;i<shift_codes.length;i++){
		if(s_shift_code=='')
			s_shift_code =shift_codes[i];
		else
			s_shift_code=s_shift_code+"|"+ shift_codes[i];
		if(s_shift_mnemonic=='')
			s_shift_mnemonic =mnemonics[i];
		else
			s_shift_mnemonic=s_shift_mnemonic+"|"+ mnemonics[i];
	}
}
/**************************************************************************/
function closeAllocate(retVal){
	//alert("Inside Close Allocate===1965");
	//alert("retVal====1967" +retVal);

	var shiftdata	=	new Array();
	shiftdata	 =	 retVal.split("~");
	//alert("shiftdata===>" +shiftdata);

	for(count=0; count<shiftdata.length;count++){
		//alert("count===1974===>" +count);
		//alert("shiftdata.length===1975===>" +shiftdata.length);

		var shiftdata1	=	shiftdata[count].split("|");
		var shift_cd		=	shiftdata1[0];
		var shift_mnem	 	=	shiftdata1[1];
		var shift_ind			=	shiftdata1[2];
		var prod_flag		=	shiftdata1[3];
		
		if(shift_ind == "U"){
			//alert("If U= 1984=>" +shift_ind);

			if((total_alloc == '')||(total_alloc==null))
				total_alloc=0;
			else
				total_alloc=parseInt(total_alloc);
			if(total_alloc > 0)
				total_alloc--;

			eval("parent.frames[1].document.forms[0].u_totalalloc"+day).value	=	total_alloc;

			curr_total		=	eval(eval("parent.frames[1].document.getElementById("u_total")"+day));
			if((curr_total == '')||(curr_total==null))
				curr_Total='0';
			curr_total.innerText	=	total_alloc;

			var prev_mnem	=	eval("document.forms[0].staffshift"+p_position_code+p_role_type+p_staff_id+day).value
			var prev_shift_code	=	eval("document.forms[0].staffshiftcode"+p_position_code+p_role_type+p_staff_id+day).value	;
			
			prev_mnem	 =	 trim(prev_mnem);
			prev_shift_code	=	trim(prev_shift_code);
			var prev_mnems	 =	 prev_mnem.split("|");
			var prev_shift_codes	=	 prev_shift_code.split("|");
			var curr_shift_code ='';
			var curr_mnem = '';

			for(i=0;i<prev_mnems.length;i++){
				if(prev_mnems[i] != shift_mnem){
					if(curr_mnem == ''){
						curr_shift_code	= prev_shift_codes[i];
						curr_mnem	= prev_mnems[i];
					}else{
						curr_shift_code	= curr_shift_code+"|"+prev_shift_codes[i];
						curr_mnem	= curr_mnem+"|"+prev_mnems[i];
					}
				}
			}
			sortShift(curr_shift_code, curr_mnem);
			eval("document.forms[0].staffshift"+p_position_code+p_role_type+p_staff_id+day).value =	s_shift_mnemonic;		
			eval("document.forms[0].staffshiftcode"+p_position_code+p_role_type+p_staff_id+day).value = s_shift_code;
			new_cell.innerText	 =	 s_shift_mnemonic
		}
		else if(prod_flag == "O"){
			//alert("If O= 2027=>" +prod_flag);

			var total_alloc	 =	 eval("parent.frames[1].document.forms[0].o_totalalloc"+day).value;
			var positoncall_alloc	 =	 eval("document.forms[0].positoncallalloc"+p_position_code+"OOOOO"+day).value;
	
			if((total_alloc == '')||(total_alloc==null))
				total_alloc=0;
			else
				total_alloc=parseInt(total_alloc);

			if((positoncall_alloc == '')||(positoncall_alloc==null))
				positoncall_alloc=0;
			else
				positoncall_alloc=parseInt(positoncall_alloc);

			if(total_alloc > 0)
				total_alloc--;

			if(positoncall_alloc > 0)
				positoncall_alloc--;

			var total_req	 =	 eval("parent.frames[1].document.forms[0].o_totalreq"+day).value;
			var positoncall_req	 =	 eval("document.forms[0].positoncallreq"+p_position_code+"OOOOO"+day).value;

			if((total_req == '')||(total_req==null))
				total_req=0;
			total_req=parseInt(total_req);

			if((positoncall_req == '')||(positoncall_req==null))
				positoncall_req=0;
			positoncall_req=parseInt(positoncall_req);

			eval("parent.frames[1].document.forms[0].o_totalalloc"+day).value	=	total_alloc;
			eval("document.forms[0].positoncallalloc"+p_position_code+"OOOOO"+day).value	=	positoncall_alloc;

			curr_total		=	eval(eval("parent.frames[1].document.getElementById("o_total")"+day));
			curr_posit_shift		=	eval(eval("document.getElementById("positoncall")"+p_position_code+"OOOOO"+day));
	
			curr_total.innerText	=	total_alloc+"/"+total_req;
			curr_posit_shift.innerText	=	positoncall_alloc+"/"+positoncall_req;

			if(total_alloc < total_req)
				curr_total.className	=	"BELOWOPTIMAL";
			if(total_alloc > total_req)
				curr_total.className	=	"ABOVEOPTIMAL";
			if(total_alloc == total_req)
				curr_total.className	=	"OPTIMAL";

			if(positoncall_alloc < positoncall_req)
				curr_posit_shift.className	=	"BELOWOPTIMAL";
			if(positoncall_alloc > positoncall_req)
				curr_posit_shift.className	=	"ABOVEOPTIMAL";
			if(positoncall_alloc == positoncall_req)
				curr_posit_shift.className	=	"OPTIMAL";

			var prev_mnem	=	eval("document.forms[0].staffshift"+p_position_code+p_role_type+p_staff_id+day).value
			var prev_shift_code	=	eval("document.forms[0].staffshiftcode"+p_position_code+p_role_type+p_staff_id+day).value	;
			
			prev_mnem	 =	 trim(prev_mnem);
			prev_shift_code	=	trim(prev_shift_code);
			var prev_mnems	 =	 prev_mnem.split("|");
			var prev_shift_codes	=	 prev_shift_code.split("|");
			var curr_shift_code ='';
			var curr_mnem = '';

			for(i=0;i<prev_mnems.length;i++){
				if(prev_mnems[i] != shift_mnem){
					if(curr_mnem == ''){
						curr_shift_code	= prev_shift_codes[i];
						curr_mnem	= prev_mnems[i];
					}else{
						curr_shift_code	= curr_shift_code+"|"+prev_shift_codes[i];
						curr_mnem	= curr_mnem+"|"+prev_mnems[i];
					}
				}
			}
			sortShift(curr_shift_code, curr_mnem);
			eval("document.forms[0].staffshift"+p_position_code+p_role_type+p_staff_id+day).value =	s_shift_mnemonic;		
			eval("document.forms[0].staffshiftcode"+p_position_code+p_role_type+p_staff_id+day).value = s_shift_code;
			new_cell.innerText	 =	 s_shift_mnemonic

		}
		else if((shift_cd !='' )&&(shift_cd != null)&&(prod_flag == 'W')){
			var total_alloc	 =	 eval("parent.frames[1].document.forms[0].w_totalalloc"+day).value;
			var shift_alloc	 =	 eval("parent.frames[1].document.forms[0].shiftalloc"+shift_cd+day).value;
			var posit_alloc =	 eval("document.forms[0].positalloc"+p_position_code+day).value;
			var positshift_alloc	 =	 eval("document.forms[0].positshiftalloc"+p_position_code+shift_cd+day).value;

			if((total_alloc == '')||(total_alloc==null))
				total_alloc=0;
			else
				total_alloc=parseInt(total_alloc);
			if(total_alloc > 0)
				total_alloc--;

			if((shift_alloc == '')||(shift_alloc==null))
				shift_alloc=0;
			else
				shift_alloc=parseInt(shift_alloc);
			if(shift_alloc > 0)
				shift_alloc--;

			if((posit_alloc == '')||(posit_alloc==null))
				posit_alloc=0;
			else
				posit_alloc=parseInt(posit_alloc);
			if(posit_alloc > 0)
				posit_alloc--;

			if((positshift_alloc == '')||(positshift_alloc==null))
				positshift_alloc=0;
			else
				positshift_alloc=parseInt(positshift_alloc);
			if(positshift_alloc > 0)
				positshift_alloc--;

			var total_req	 =	 eval("parent.frames[1].document.forms[0].w_totalreq"+day).value;
			var shift_req	 =	 eval("parent.frames[1].document.forms[0].shiftreq"+shift_cd+day).value;
			var posit_req	=	 eval("document.forms[0].positreq"+p_position_code+day).value;
			var positshift_req	 =	 eval("document.forms[0].positshiftreq"+p_position_code+shift_cd+day).value;

			if((total_req == '')||(total_req==null))
				total_req=0;

			if((shift_req == '')||(shift_req==null))
				shift_req=0;

			if((posit_req == '')||(posit_req==null))
				posit_req=0;

			if((positshift_req == '')||(positshift_req==null))
				positshift_req=0;

			total_req=parseInt(total_req);
			shift_req=parseInt(shift_req);
			posit_req=parseInt(posit_req);
			positshift_req=parseInt(positshift_req);

			eval("parent.frames[1].document.forms[0].w_totalalloc"+day).value	=	total_alloc;
			eval("parent.frames[1].document.forms[0].shiftalloc"+shift_cd+day).value	=	shift_alloc;
			eval("document.forms[0].positalloc"+p_position_code+day).value	 =	 posit_alloc;	
			eval("document.forms[0].positshiftalloc"+p_position_code+shift_cd+day).value=positshift_alloc;
			
			curr_total		=	eval(eval("parent.frames[1].document.getElementById("w_total")"+day));
			curr_shift		=	eval(eval("parent.frames[1].document.getElementById("shift")"+shift_cd+day));
			curr_posit		=	eval(eval("document.getElementById("posit")"+p_position_code+day));
			curr_posit_shift		=	eval(eval("document.getElementById("positshift")"+p_position_code+shift_cd+day));

			curr_total.innerText	=	total_alloc+"/"+total_req;
			curr_shift.innerText	=	shift_alloc+"/"+shift_req;
			curr_posit.innerText	=	posit_alloc+"/"+posit_req;
			curr_posit_shift.innerText			=	positshift_alloc+"/"+positshift_req;
			changeColor(shift_cd);

			var prev_mnem	=	eval("document.forms[0].staffshift"+p_position_code+p_role_type+p_staff_id+day).value
			var prev_shift_code	=	eval("document.forms[0].staffshiftcode"+p_position_code+p_role_type+p_staff_id+day).value	;
			
		/*	var prev_mnem	=	p_shift_mnemonic;
			var prev_shift_code	=	p_shift_code;*/

			prev_mnem	 =	 trim(prev_mnem);
			prev_shift_code	=	trim(prev_shift_code);
			var prev_mnems	 =	 prev_mnem.split("|");
			var prev_shift_codes	=	 prev_shift_code.split("|");
			var curr_shift_code ='';
			var curr_mnem = '';

			for(i=0;i<prev_mnems.length;i++){
				if(prev_mnems[i] != shift_mnem){
					if(curr_mnem == ''){
						curr_shift_code	= prev_shift_codes[i];
						curr_mnem	= prev_mnems[i];
					}else{
						curr_shift_code	= curr_shift_code+"|"+prev_shift_codes[i];
						curr_mnem	= curr_mnem+"|"+prev_mnems[i];
					}
				}
			}
		//	alert("Final : "+curr_shift_code+" - "+curr_mnem);
			sortShift(curr_shift_code, curr_mnem);
	//		alert("after sort Final : "+s_shift_code+" - "+s_shift_mnemonic);

			eval("document.forms[0].staffshift"+p_position_code+p_role_type+p_staff_id+day).value =	s_shift_mnemonic;		
			eval("document.forms[0].staffshiftcode"+p_position_code+p_role_type+p_staff_id+day).value = s_shift_code;
			if(s_shift_mnemonic =='')
				new_cell.innerHTML='&nbsp;'
			else
				new_cell.innerText	 =	 s_shift_mnemonic
			changeColor(shift_cd);
		}
		else
		{
			
			//alert("final else===2222");
				//new_cell.innerHTML='&nbsp;' //commented on 1/2/2010
				//alert(new_cell.innerHTML);

		}
		
	s_shift_code="";
	s_shift_mnemonic="";
	//alert("s_shift_code= 2229==>" +s_shift_code+ "s_shift_mnemonic===>" +s_shift_mnemonic);
	}
}
/**************************************************************************/
function changeColor(shift_cd){
	//alert("inside change color");

	curr_total		=	eval(eval("parent.frames[1].document.getElementById("w_total")"+day));
	curr_shift		=	eval(eval("parent.frames[1].document.getElementById("shift")"+shift_cd+day));
	curr_posit		=	eval(eval("document.getElementById("posit")"+p_position_code+day));
	curr_posit_shift		=	eval(eval("document.getElementById("positshift")"+p_position_code+shift_cd+day));

	var total_req	 =	 eval("parent.frames[1].document.forms[0].w_totalreq"+day).value;
	var shift_req	 =	 eval("parent.frames[1].document.forms[0].shiftreq"+shift_cd+day).value;
	var posit_req	=	 eval("document.forms[0].positreq"+p_position_code+day).value;
	var positshift_req	 =	 eval("document.forms[0].positshiftreq"+p_position_code+shift_cd+day).value;

	var total_alloc	 =	 eval("parent.frames[1].document.forms[0].w_totalalloc"+day).value;
	var shift_alloc	 =	 eval("parent.frames[1].document.forms[0].shiftalloc"+shift_cd+day).value;
	var posit_alloc =	 eval("document.forms[0].positalloc"+p_position_code+day).value;
	var positshift_alloc	 =	 eval("document.forms[0].positshiftalloc"+p_position_code+shift_cd+day).value;


	if((total_req == '')||(total_req==null))
		total_req=0;

	if((shift_req == '')||(shift_req==null))
		shift_req=0;

	if((posit_req == '')||(posit_req==null))
		posit_req=0;

	if((positshift_req == '')||(positshift_req==null))
		positshift_req=0;

	total_req=parseInt(total_req);
	shift_req=parseInt(shift_req);
	posit_req=parseInt(posit_req);
	positshift_req=parseInt(positshift_req);

	if((total_alloc == '')||(total_alloc==null))
		total_alloc=0;

	if((shift_alloc == '')||(shift_alloc==null))
		shift_alloc=0;

	if((posit_alloc == '')||(posit_alloc==null))
		posit_alloc=0;

	if((positshift_alloc == '')||(positshift_alloc==null))
		positshift_alloc=0;

	total_alloc=parseInt(total_alloc);
	shift_alloc=parseInt(shift_alloc);
	posit_alloc=parseInt(posit_alloc);
	positshift_alloc=parseInt(positshift_alloc);

	if(total_alloc < total_req)
		curr_total.className	=	"BELOWOPTIMAL";
	if(total_alloc > total_req)
		curr_total.className	=	"ABOVEOPTIMAL";
	if(total_alloc == total_req)
		curr_total.className	=	"OPTIMAL";

	if(shift_alloc < shift_req)
		curr_shift.className	=	"BELOWOPTIMAL";
	if(shift_alloc > shift_req)
		curr_shift.className	=	"ABOVEOPTIMAL";
	if(shift_alloc == shift_req)
		curr_shift.className	=	"OPTIMAL";

	if(posit_alloc < posit_req)
		curr_posit.className	=	"BELOWOPTIMAL";
	if(posit_alloc > posit_req)
		curr_posit.className	=	"ABOVEOPTIMAL";
	if(posit_alloc == posit_req)
		curr_posit.className	=	"OPTIMAL";

	if(positshift_alloc < positshift_req)
		curr_posit_shift.className	=	"BELOWOPTIMAL";
	if(positshift_alloc > positshift_req)
		curr_posit_shift.className	=	"ABOVEOPTIMAL";
	if(positshift_alloc == positshift_req)
		curr_posit_shift.className	=	"OPTIMAL";
}
/*****************************************************************/
/*****************************************************************/
