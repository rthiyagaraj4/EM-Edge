/*******************************************************************/
function viewWorkPlace(call_mode, target){
	
    var argumentArray  = new Array() ;
	var dataNameArray  = new Array() ;
	var dataValueArray = new Array() ;
	var dataTypeArray  = new Array() ;
   	var frmObj=parent.frameCanWrkSchCriteria.document.formCanWrkSchCriteria;
	
	var workplace=frmObj.work_text.value;
	if((call_mode=='T')&&(workplace== '')){
		frmObj.wrk_code.value="";
		return false;
	}

	var locn_type=frmObj.locan_type.value;
	var appl_user_id=frmObj.appl_user_id.value;
	var facility_id=frmObj.facility_id.value;

	if(frmObj.wrk_code.value !=''){
		frmObj.work_text.value="";
		frmObj.wrk_code.value="";
	}
	argumentArray[0] ="select workplace_code code, workplace_desc description from rs_workplace_access_vw where facility_id='"+facility_id+"' and appl_user_id='"+appl_user_id+"' and  ('"+locn_type+"' is null or locn_type='"+locn_type+"') and upper(workplace_code) like upper(?) and upper(workplace_desc) like upper(?) and eff_status='E' and allocate_yn='Y' order by workplace_desc";

		argumentArray[1] = dataNameArray ;
		argumentArray[2] = dataValueArray ;
		argumentArray[3] = dataTypeArray ;
		argumentArray[4] = "1,2"; 
		argumentArray[5] = target.value;
		argumentArray[6] = CODE_LINK ;//CODE_LINK
		argumentArray[7] = CODE_DESC ;//CODE_DESC
										
		retVal = CommonLookup(getLabel("eRS.WorkplaceCode.label","RS"), argumentArray );
		if(retVal != null && retVal != "") {
			target.value = retVal[1] ;
			frmObj.wrk_code.value = retVal[0];
		}else
			target.value ="";
		workplacechange();
	}
/************************************************************************/
function locnchange(){
	document.formCanWrkSchCriteria.work_text.value="";
	document.formCanWrkSchCriteria.wrk_code.value="";
	workplacechange()
}
/************************************************************************/
function workplacechange(){
	document.forms[0].role_type.selectedIndex=0;
	rolechange();
}
/************************************************************************/
function rolechange(){
	populateStaffType();
	document.forms[0].position_text.value='';
	document.forms[0].position_code.value='';
	document.forms[0].staff_id.value='';
	document.forms[0].staff_text.value='';
	document.forms[0].frm_dt.value='';
	document.forms[0].to_dt.value='';
//	document.forms[0].reason.selectedIndex=0;
}
/************************************************************************/
function positionchange(){
	document.forms[0].staff_id.value='';
	document.forms[0].staff_text.value='';
	document.forms[0].frm_dt.value='';
	document.forms[0].to_dt.value='';
//	document.forms[0].reason.selectedIndex=0;
}
/************************************************************************/
function stafftypechange(){
	document.forms[0].position_text.value='';
	document.forms[0].position_code.value='';
	document.forms[0].staff_id.value='';
	document.forms[0].staff_text.value='';
	document.forms[0].frm_dt.value='';
	document.forms[0].to_dt.value='';
//	document.forms[0].reason.selectedIndex=0;
}
/************************************************************************/
function staffchange(){
	document.forms[0].frm_dt.value='';
	document.forms[0].to_dt.value='';
//	document.forms[0].reason.selectedIndex=0;
}
/*******************************************************************/
function viewPosition(call_mode, target){
	var frmObj=parent.frameCanWrkSchCriteria.document.formCanWrkSchCriteria;

	var position=frmObj.position_text.value;
	if((call_mode=='T')&&(position== '')){
		frmObj.position_code.value="";
		return false;
	}
	var role_type=frmObj.role_type.value;
	var fields = new Array (frmObj.role_type);
	var names = new Array (getLabel("Common.RoleType.label","Common"));
	var	msgFrame=parent.parent.messageFrame;
	if(parent.frameCanWrkSchCriteria.checkFields(fields,names,msgFrame)){

		if(frmObj.position_code.value !=''){
			frmObj.position_text.value="";
			frmObj.position_code.value="";
		}
		var staff_type=frmObj.staff_type[frmObj.staff_type.selectedIndex].value;
		var locale=frmObj.locale.value;
		var argumentArray  = new Array() ;
		var dataNameArray  = new Array() ;
		var dataValueArray = new Array() ;
		var dataTypeArray  = new Array() ;

		dataNameArray[0]="role_type";
		dataValueArray[0]=role_type;
		dataTypeArray[0]=STRING;
		//argumentArray[0] ="select position_code code,position_desc description from am_position where eff_status='E' and upper(role_type) like upper(?) and upper(position_code) like upper(?) and  upper(position_desc) like upper(?) order by position_desc";
		argumentArray[0] ="select position_code code,position_desc description from am_position_lang_vw where eff_status='E' and ('"+staff_type+"' is null or staff_type='"+staff_type+"' ) and upper(role_type) like upper(?) and upper(position_code) like upper(?) and  upper(position_desc) like upper(?) and language_id = '"+locale+"' order by position_desc";
		argumentArray[1] = dataNameArray ;
		argumentArray[2] = dataValueArray ;
		argumentArray[3] = dataTypeArray ;
		argumentArray[4] = "2,3"; 
		argumentArray[5] = target.value;
		argumentArray[6] = CODE_LINK ;//CODE_LINK
		argumentArray[7] = CODE_DESC ;//CODE_DESC
		retVal = CommonLookup(getLabel("eRS.Positions.label","RS"),argumentArray);
		if(retVal != null && retVal != "") {
			target.value = retVal[1] ;
			frmObj.position_code.value = retVal[0];
		}
	}	
	positionchange();
}

/*******************************************************************/
function populateStaffType(){
	clearStaffType();
	var frmObj=parent.frameCanWrkSchCriteria.document.formCanWrkSchCriteria;
	var role_type=frmObj.role_type.value;
	frmObj.position_text.value="";
	frmObj.staff_text.value="";
	
		if(!role_type==""){
			var xmlDoc = "" ;
			var xmlHttp = new XMLHttpRequest() ;

			xmlStr ="<root><SEARCH " ;
			xmlStr +=" /></root>" ;
			xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
			xmlHttp.open( "POST", "../../eRS/jsp/CancelWorkScheduleValidate.jsp?role_type="+role_type, false ) ;
			xmlHttp.send( xmlDoc ) ;
			responseText=xmlHttp.responseText ;
			eval(responseText);
		}
}

/*******************************************************************/

function populateStaff(target){
	
	var frmObj=parent.frameCanWrkSchCriteria.document.formCanWrkSchCriteria;
	var p_role_type=frmObj.role_type.value;
	var p_staff_type=frmObj.staff_type.value;
	var p_position_code=frmObj.position_code.value;
	var p_position_desc=frmObj.position_text.value;

	var url='../../eRS/jsp/SearchStaff.jsp?p_role_type='+p_role_type+'&p_staff_type='+p_staff_type+'&p_position_code='+p_position_code+'&p_position_desc='+p_position_desc+'&mode=call';
	var dialogHeight =window.screen.height ;
	var dialogWidth = window.screen.width ;
	var dialogTop	= 0;
	var dialogLeft = 0 ;
    var arguments   = "" ;
    var features    = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +";dialogTop:"+dialogTop+";dialogLeft:"+dialogLeft+"; scroll=no; status=no;";
    var retVal   = window.showModalDialog( url, arguments, features ) ;
	if(retVal !=null){
		if(p_role_type != retVal[2]){
			var len=frmObj.role_type.length;
			for(i=0;i<len;i++){
				if(frmObj.role_type.options[i].value==retVal[2]){
					frmObj.role_type.selectedIndex=i;
					break;
				}
			}
			rolechange();
		}
		if(p_staff_type != retVal[3]){
			var len=frmObj.staff_type.length;
			for(i=0;i<len;i++){
				if(frmObj.staff_type.options[i].value==retVal[3]){
					frmObj.staff_type.selectedIndex=i;
					break;
				}
			}
		}
		if(p_position_code != retVal[4]){
			var xmlDoc = new ActiveXObject("Microsoft.XMLDom" );
			var xmlHttp = new XMLHttpRequest();

			xmlStr ="<root><SEARCH " ;
			xmlStr +=" /></root>" ;
			xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
			xmlHttp.open( "POST", "../../eRS/jsp/CancelWorkScheduleValidate.jsp?position_code="+retVal[4], false ) ;
			xmlHttp.send( xmlDoc ) ;
			responseText=xmlHttp.responseText ;
			eval(responseText);
		}
		//frmObj.staff_type.value=retVal[3];
		//frmObj.position.value=retVal[4];
		target.value=retVal[1];
		frmObj.staff_id.value=retVal[0];
	}
}
/************************************************************************/
function addPosition(code, desc){
	var frmObj= document.forms[0];
	frmObj.position_code.value=code;
	frmObj.position_text.value=desc;
}
/*******************************************************************/

	function addStaffType(code,value) {
	var element = document.createElement('OPTION') ;
	element.value =  code ;
	element.text = value ;
	parent.frameCanWrkSchCriteria.document.formCanWrkSchCriteria.staff_type.add(element);
}

/*******************************************************************/

	function clearStaffType( ) {
	var len = eval("document.formCanWrkSchCriteria.staff_type.options.length") ;
	for(var i=0;i<len;i++)
	{
		eval("document.formCanWrkSchCriteria.staff_type.remove(\"atc_class_l2_code\")") ;
	}
	var tp 		= "  ---Select---  " ;
	var opt  	= eval("document.createElement(\"OPTION\")") ;
	opt.text 	= tp ;
	eval("document.formCanWrkSchCriteria.staff_type.add(opt)") ;
}


/***********************DATE VALIDATION STARTS*******************/
function showCal(obj, obj_id){
	showCalendar(obj_id);
	obj.focus();
}
/*****************************************************************/
function AllowDateFormat(){
   var key = window.event.keyCode;
   if( ! ( (( key>=48 ) && ( key<58 ) ) || (key == 47)) ) {
       return false;
   }

}

/*******************************************************************/
function checkDateRange(obj,from){

	var fromDate = eval("document."+from+".frm_dt")
	var toDate = eval("document."+from+".to_dt")
	if(doDateCheck(fromDate,toDate) == 1) { 
		var invaldt =parent.frames[0].getMessage("TO_DT_GR_EQ_FM_DT","RS") ; 
		alert(invaldt);			
		var frmObj=parent.frameCanWrkSchCriteria.document.formCanWrkSchCriteria.to_dt;
		frmObj.value="";
		frmObj.focus();
		return false;
	}
}
/*******************************************************************/
function checkSysFromDateRange(obj){
	var frmObj = document.forms[0];
	var frmDate = obj;
	var systdate = frmObj.sys_dt;
	var fromdate = frmDate.value;
	var todaydate = systdate.value;
	var fromarray;
	var toarray;
	if(fromdate.length > 0 && todaydate.length > 0){
		fromarray = fromdate.split("/");
		toarray = todaydate.split("/");
		var fromdt = new Date(fromarray[2],fromarray[1],fromarray[0]);
		var todt = new Date(toarray[2],toarray[1],toarray[0]);
		if(Date.parse(todt) > Date.parse(fromdt)){
			var invaldt =getMessage("FROM_DATE_LESS_SYSDATE","RS") ; 
			alert(invaldt);
			//parent.parent.messageFrame.location.href='../../eCommon/jsp/error.jsp?err_num='+invaldt;
			obj.select();
			obj.focus();
		}
	}
}
/******************************************************************/
function checkSysToDateRange(obj){
	var frmObj = document.forms[0];
	var frmDate = obj;
	var systdate = frmObj.sys_dt;
	var fromdate = frmDate.value;
	var todaydate = systdate.value;
	var fromarray;
	var toarray;
	if(fromdate.length > 0 && todaydate.length > 0){
		fromarray = fromdate.split("/");
		toarray = todaydate.split("/");
		var fromdt = new Date(fromarray[2],fromarray[1],fromarray[0]);
		var todt = new Date(toarray[2],toarray[1],toarray[0]);
		if(Date.parse(todt) > Date.parse(fromdt)){
			var invaldt =getMessage("TO_DATE_LESS_SYSDATE","RS") ; 
			alert(invaldt);
			//parent.parent.messageFrame.location.href='../../eCommon/jsp/error.jsp?err_num='+invaldt;
			obj.select();
			obj.focus();
		}
	}
}
/*******************************************************************/
function doDateCheck(from,to) {
    var fromarray; var toarray;
    var fromdate = from.value ;
    var todate   = to.value ;
    if(fromdate.length > 0 && todate.length > 0 ) {
            fromarray = fromdate.split("/");
            toarray = todate.split("/");
            var fromdt = new Date(fromarray[2],fromarray[1]-1,fromarray[0]);
            var todt = new Date(toarray[2],toarray[1]-1,toarray[0]);
            if(Date.parse(todt) < Date.parse(fromdt))
               return 1 ;
            else if(Date.parse(todt) > Date.parse(fromdt))
			  return  -1 ;
			else if(Date.parse(todt) == Date.parse(fromdt))
			 return  -1 ;
   }
} 
/***********************DATE VALIDATION END***************************/

function clearWrkPlace(){
	parent.frameCanWrkSchCriteria.document.formCanWrkSchCriteria.work_text.value="";
}
/*******************************************************************/
function clearStaff(){
	parent.frameCanWrkSchCriteria.document.formCanWrkSchCriteria.staff_text.value="";
}
/*******************************************************************/
function ShowDetails(){
	
	if(mandatory()){ 
	var frmObj=parent.frameCanWrkSchCriteria.document.formCanWrkSchCriteria;
	var facility_id=frmObj.facility_id.value;
	var locale=frmObj.locale.value;
    var frm_dt=convertDate(frmObj.frm_dt.value,'DMY',locale,"en");
    var to_dt=convertDate(frmObj.to_dt.value,'DMY',locale,"en");
    var workplace_code=frmObj.wrk_code.value;
    var locn_type=frmObj.locan_type.value;
    var position_code=frmObj.position_code.value;
    var role_type=frmObj.role_type.value;
    var staff_id=frmObj.staff_id.value;    
    var staff_type=frmObj.staff_type.value;
	var reason_code=frmObj.reason.value;
		
	for(i=0;i<frmObj.elements.length;i++){

			frmObj.elements[i].disabled=true;
	}
	frmObj.frm_cal.disabled=true;
	frmObj.to_cal.disabled=true;
	frmObj.wrk_clr_button.disabled=false;
	
	parent.parent.messageFrame.location.href= "../../eCommon/jsp/error.jsp"+"";	
	parent.frameCanWrkSchHdr.location.href = "../../eRS/jsp/CancelWorkScheduleHdr.jsp";
 	parent.frameCanWrkSchResult.location.href = "../../eRS/jsp/CancelWorkScheduleResult.jsp?facility_id="+facility_id+"&frm_dt="+frm_dt+"&to_dt="+to_dt+"&workplace_code="+workplace_code+"&locn_type="+locn_type+"&position_code="+position_code+"&role_type="+role_type+"&staff_id="+staff_id+"&staff_type="+staff_type+"&reason_code="+reason_code;
	}
}

/*******************************************************************/
	
 function apply(){
	if (! checkIsValidForProceed() ) {
		//message  = getMessage("NOT_VALID","Common");
		//messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num="+ message;
		var frmobj=f_query_add_mod.frameCanWrkSchCriteria.document.forms[0];
		//alert(f_query_add_mod.frameCanWrkSchCriteria.document.forms[0].name);
		if(frmobj==f_query_add_mod.frameCanWrkSchCriteria.document.formCanWrkSchCriteria)
		{
			var fields = new Array (frmobj.frm_dt,frmobj.to_dt,frmobj.reason);
			//alert("fields ==" +fields);
			var names = new Array (getLabel("Common.from.label","Common"),getLabel("Common.to.label","Common"),getLabel("eRS.ReasonforCancellation.label","RS"));
			if(checkFields(fields,names,messageFrame)) 
			{ 
			
				return true;
			}
			
		}
		
		return false ;
	}
	var frmObj =parent.frames[2].frames[1].frameCanWrkSchResult.document.formCanWrkSchResult;
	var cnt=0;
	var count=0;
	for(cnt=0;cnt<frmObj.totalRecords.value; cnt++){
		var select=eval("frmObj.select_yn"+cnt);
		if(select.checked==true){
				select.value="Y";
				count++;
		}else{
			select.value="N";
		}
	}
	if(count>0)
	frmObj.submit();
	else
	messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num="+"Atleast one row should be selected......";
	//parent.frames[2].frames[1].frameCanWrkSchResult.location.href='../../eCommon/html/blank.html';
	//onSuccess();
}

/*******************************************************************/
function mandatory(){
	var frmObj=parent.frameCanWrkSchCriteria.document.formCanWrkSchCriteria;
	var fields = new Array ( frmObj.frm_dt,frmObj.to_dt,frmObj.reason);
	var names = new Array (getLabel("Common.fromdate.label","Common"),getLabel("Common.todate.label","Common"),getLabel("eRS.ReasonforCancellation.label","RS"));
	var	msgFrame=parent.parent.messageFrame;
	if(parent.frameCanWrkSchCriteria.checkMandFields(fields,names, msgFrame)) {
	   return true;
	}
	else
	  return false;
}

/*******************************************************************/
function onSuccess() {
	var frmObj=parent.frames[2].frames[1].frameCanWrkSchCriteria.document.formCanWrkSchCriteria;

	for(i=0;i<frmObj.elements.length;i++){
	frmObj.elements[i].disabled=false;
	}
	frmObj.frm_cal.disabled=false;
	frmObj.to_cal.disabled=false;
	
	frmObj.reset();
	parent.frames[2].frames[1].frameCanWrkSchResult.location.href='../../eCommon/html/blank.html';				
	parent.frames[2].frames[1].frameCanWrkSchHdr.location.href='../../eCommon/html/blank.html';
	parent.frames[2].frames[1].frameCanWrkSchCriteria.document.formCanWrkSchCriteria.reset();
}
/*******************************************************************/
function checkIsValidForProceed(){
   var url = parent.frames[2].f_query_add_mod.frameCanWrkSchResult.location.href;
	url = url.toLowerCase();
	if ( (url.indexOf("blank")==-1) )
			return true;
	else
			return false;
}

/*******************************************************************/
function reset(){	
	var url=f_query_add_mod.location.href;
	if(url.indexOf("blank")==-1) {
			url=frames[1].frameCanWrkSchCriteria.location.href;
			if(url.indexOf("blank")==-1) {
				var frmObj=frames[1].frameCanWrkSchCriteria.document.forms[0]
				url=frames[1].frameCanWrkSchHdr .location.href;
				if(url.indexOf("blank")==-1) {
					frames[1].frameCanWrkSchResult.document.forms[0].reset();
					messageFrame.location.href = "../../eCommon/jsp/error.jsp";
				}
				else{
					frmObj.reset();
					var i=0;
					while(frmObj.elements(i)!=null){
						frmObj.elements(i).disabled=false;
						i++;
					}
					frmObj.frm_cal.disabled=false;
					frmObj.to_cal.disabled=false;
				}
			}
		else
			f_query_add_mod.document.forms[0].reset();
	}
}
/*******************************************************************/

function assignResult(_result, _message, _flag){
	result = _result ;
	message  = _message ;
	flag = _flag ;
}
/*******************************************************************/

function checkMandFields( fields, names, messageFrame) {
	var errors = "" ;
	for( var i=0; i<fields.length; i++ ) {
		if(trimCheck(fields[i].value)) {
			fields[i].value = trimString(fields[i].value);
		}
		else	errors = errors + "APP-000001 " + names[i] + " cannot be blank..." + "<br>" ;
	}
	if ( errors.length != 0 ) {
		messageFrame.document.location.href="../../eCommon/jsp/error.jsp?err_num="+errors ;
		return false ;
	}
	return true ;
}
/*******************************************************************/

function clearAll(){
var frmObj=parent.frameCanWrkSchCriteria.document.forms[0];
	frmObj.reset();
	for(i=0;i<frmObj.elements.length;i++){
		frmObj.elements[i].disabled=false;
	}
	frmObj.frm_cal.disabled=false;
	frmObj.to_cal.disabled=false;

	parent.frameCanWrkSchHdr.location.href = "../../eCommon/html/blank.html";
	parent.frameCanWrkSchResult.location.href = "../../eCommon/html/blank.html";
	parent.parent.messageFrame.location.href = "../../eCommon/jsp/error.jsp?";
}
/*******************************************************************/

function checkDateRange1(obj,from){

	var fromDate = eval("document."+from+".frm_dt")
	var toDate = eval("document."+from+".to_dt")
	 //  this method is from ValidateControl.js
		if(doDateCheck(fromDate,toDate) == 1) { 
			var message=getMessage("FROM_DATE_GREATER_TO_DATE","RS");
			alert(message); // this message available in messages.js of ecommon/js
			var frmObj=parent.frameCanWrkSchCriteria.document.formCanWrkSchCriteria.frm_dt;
			frmObj.value="";
			frmObj.focus();
			return false;
	}
}
/*******************************************************************/
