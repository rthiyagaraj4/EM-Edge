var message = "" ;
var todatecon=false;
/************************************************************************/
function apply(){
	if(!checkIsValidForProceed()){
		//alert("checkvalid proceed1");
		//message  = getMessage("NOT_VALID","Common");
		//messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num="+ message;
		var frmobj=f_query_add_mod.frameGenWrkSchCriteria.document.formWrkScheduleCriteria;
		var fields = new Array (frmobj.work_text,frmobj.frm_dt,frmobj.to_dt);
		var names = new Array (getLabel("eRS.WorkPlace.label","RS"),getLabel("Common.from.label","Common"),getLabel("Common.to.label","Common"));
		if(checkFields(fields,names,messageFrame)) {
				frmobj.dt_from.value = convertDate(frmobj.dt_from.value,'DMY',frmobj.locale.value,'en');
				frmobj.dt_to.value = convertDate(frmobj.dt_to.value,'DMY',frmobj.locale.value,'en');
			
	}



		
		return false ;
	}
	var formObj	=	parent.frames[2].frames[1].frameGenWrkSchResult.document.form_GenWrkSchResult;
	var no_of_checked=0;
	for(cnt=0;cnt<formObj.totalrecs.value; cnt++){
		val = eval("formObj.select"+cnt);
		if(val.checked == true){
			val.value='Y';
			no_of_checked++;
		}
	}
	if(parseInt(no_of_checked) == 0){
		var err = getMessage("ATLEAST_ONE_SELECTED","Common");
		parent.frames[2].messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num="+err;
		return false
	}

	parent.frames[2].messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num="+"";
	formObj.submit();
 }

/************************************************************************/
function reset(){

	parent.frames[2].frames[1].frameset_GenerateWorkSchedule.rows='100%,0%,0%';
	var frmObj=parent.frames[2].frames[1].frames[0].document.forms[0];
	frmObj.reset();
	var i=0;
	while(frmObj.elements(i)!=null)
		frmObj.elements(i++).disabled=false;
	frmObj.frm_dt_img.disabled=false;
	frmObj.to_dt_img.disabled=false;

	frmObj.elements(0).focus();
}
/************************************************************************/
function checkIsValidForProceed(){
	var url = f_query_add_mod.frameGenWrkSchResult.location.href;
	url = url.toLowerCase();
	if ( url.indexOf("blank")==-1) 
		return true;
	else
		return false;
}
/*function checkIsValidForProceed2()
{	
	alert("");
	var url = f_query_add_mod.frameGenWrkSchHdr.location.href;
		url = url.toLowerCase();
		if ( (url.indexOf("queryresult.jsp")==-1) && (url.indexOf("query")==-1)&&(url.indexOf("blank")==-1) )
		{
				
				return true;
		}
		else
		{
			
			return false;
		}
}*/

/************************************************************************/
/*************** common look up for position returns code n desc*********************/
/************************************************************************/

function viewPosition(call_mode, target){

	var frmObj=parent.frameGenWrkSchCriteria.document.formWrkScheduleCriteria;

	var position	 =frmObj.position_text.value;
	var locale	 =frmObj.locale.value;
	if((call_mode == 'T')&&(position == '')){
		frmObj.position_code.value='';
		return false;
	}
	
	var role_type=frmObj.role_type.value;
	var fields = new Array (frmObj.role_type);
	var names = new Array (getLabel("Common.RoleType.label","Common"));
	var	msgFrame=parent.parent.messageFrame;
	if(parent.frameGenWrkSchCriteria.checkFields(fields,names,msgFrame)){ 

		if(frmObj.position_code.value !=''){
			frmObj.position_code.value="";
			target.value="";
		}
		var staff_type=frmObj.staff_type[frmObj.staff_type.selectedIndex].value;
		var argumentArray  = new Array() ;
		var dataNameArray  = new Array() ;
		var dataValueArray = new Array() ;
		var dataTypeArray  = new Array() ;		
		
		dataNameArray[0]="role_type";
		dataValueArray[0]=role_type;
		dataTypeArray[0]=STRING;

		//argumentArray[0] ="select position_code code,position_desc description from am_position where eff_status='E' and ('"+staff_type+"' is null or staff_type='"+staff_type+"' ) and upper(role_type) like upper(?) and upper(position_code) like upper(?) and  upper(position_desc) like upper(?) order by position_desc";
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
		else{
			target.value ='' ;
			frmObj.position_code.value ='';
		}
		positionchange();
	}
}

/************************************************************************/
/*************** for populating staff list box executes qry in validate jsp****************/
/************************************************************************/

function populateStaffType(){

	clearStaffType();
	var frmObj=parent.frameGenWrkSchCriteria.document.formWrkScheduleCriteria;
	var role_type=frmObj.role_type.value;
	frmObj.staff_text.value="";
	
		if(!role_type==""){
			var xmlDoc = new ActiveXObject("Microsoft.XMLDom" );
			var xmlHttp = new XMLHttpRequest();

			xmlStr ="<root><SEARCH " ;
			xmlStr +=" /></root>" ;
			xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
			xmlHttp.open( "POST", "../../eRS/jsp/GenerateWorkScheduleValidate.jsp?role_type="+role_type, false ) ;
			xmlHttp.send( xmlDoc ) ;
			responseText=xmlHttp.responseText ;
			eval(responseText);
		}
}	
/************************************************************************/
/*************** called frm validate.jsp****************************************/
/************************************************************************/

function addStaffType(code,value) {
	var element = document.createElement('OPTION') ;
	element.value =  code ;
	element.text = value ;
	parent.frameGenWrkSchCriteria.document.formWrkScheduleCriteria.staff_type.add(element);
}
/************************************************************************/
function addPosition(code, desc){
	var frmObj= document.forms[0];
	frmObj.position_code.value=code;
	frmObj.position_text.value=desc;
}
/************************************************************************/
//***************This will clear the list from the staff list box***********************//
/************************************************************************/

function clearStaffType( ) {
	var len = eval("document.formWrkScheduleCriteria.staff_type.options.length") ;
	for(var i=0;i<len;i++)
	{
		eval("document.formWrkScheduleCriteria.staff_type.remove(\"atc_class_l2_code\")") ;
	}
	var tp 		= "  ---Select---  " ;
	var opt  	= eval("document.createElement(\"OPTION\")") ;
	opt.text 	= tp ;
	eval("document.formWrkScheduleCriteria.staff_type.add(opt)") ;
}

/************************************************************************/
/*************** common look up for workplace returns code n desc*******************/
/************************************************************************/

function viewWrkPlace(call_mode, target){
	var argumentArray  = new Array() ;
	var dataNameArray  = new Array() ;
	var dataValueArray = new Array() ;
	var dataTypeArray  = new Array() ;

	var frmObj		 =parent.frameGenWrkSchCriteria.document.formWrkScheduleCriteria;

	var workplace	 =frmObj.work_text.value;
	if((call_mode == 'T')&&(workplace == '')){
		frmObj.wrk_code.value="";
		return false;
	}
	var facility_id	 =frmObj.facility_id.value;
	var appl_user_id =frmObj.appl_user_id.value;
	var locn_type	 =frmObj.locn.value; 

	if(frmObj.wrk_code.value !=''){
		frmObj.work_text.value="";
		frmObj.wrk_code.value="";
	}
	argumentArray[0] ="SELECT workplace_code code, workplace_desc description FROM rs_workplace_access_vw WHERE ALLOCATE_YN='Y' and facility_id='"+facility_id+"' and appl_user_id='"+appl_user_id+"' AND ('"+locn_type+"' is null or locn_type='"+locn_type+"') AND UPPER(workplace_code) LIKE UPPER(?) AND UPPER(workplace_desc) LIKE UPPER(?) ORDER BY workplace_desc";

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
		frmObj.wrk_code.value = retVal[0];
	}else
		target.value ="";
	workplacechange();
}
/************************************************************************/
/********************* Date Validations Starts *********************************/
/************************************************************************/
function showCal(obj,obj_id){
	showCalendar(obj_id);
	obj.focus();
}
/*********************************************************************/
function AllowDateFormat(){

   var key = window.event.keyCode;
   if( ! ( (( key>=48 ) && ( key<58 ) ) || (key == 47)) ) {
       return false;
   }
}

/************************************************************************/
function checkDateRange(obj){

	var frmObj=document.forms[0];
	var fromDate = frmObj.frm_dt;
	var toDate = frmObj.to_dt;
	if(!doDateCheck(fromDate,toDate,parent.parent.messageFrame)){
		obj.select();
		obj.focus();
		todatecon=false;
	}
	else{
		if(checkToDate()){
			fromarray = (fromDate.value).split("/");
			toarray = (toDate.value).split("/");
			var fromdt = new Date(fromarray[2],fromarray[1],fromarray[0]);
			var todt = new Date(toarray[2],toarray[1],toarray[0]);
			var days=daysBetween(todt,fromdt)+1;
			var schedule_days=frmObj.period_for_schedule.value;
			if(days > schedule_days){
				message=getMessage("SCHEDULE_PERIOD_LESS","RS")
				alert(message);
				obj.select();
				obj.focus();
				parent.parent.messageFrame.location.href='../../eCommon/jsp/error.jsp';
			}
		}
		todatecon=true;
	}
}
/************************************************************************/
function daysBetween(laterdate,earlierdate) {
    var difference = laterdate.getTime() - earlierdate.getTime();
    var daysDifference = Math.floor(difference/1000/60/60/24);
	return daysDifference;
}
/************************************************************************/
function checkFromDate(){
	var frmObj=document.forms[0];
	var from =frmObj.frm_dt;
	var today = frmObj.sys_date;
	var fromdate = from.value;
	var todaydate = today.value;
	var fromarray;
	var toarray;
	if(fromdate.length > 0 && todaydate.length > 0){
		fromarray = fromdate.split("/");
		toarray = todaydate.split("/");
		var fromdt = new Date(fromarray[2],fromarray[1],fromarray[0]);
		var todt = new Date(toarray[2],toarray[1],toarray[0]);
		if(Date.parse(todt) > Date.parse(fromdt)){
			var invaldt =parent.parent.frames[1].getMessage("FROM_DATE_LESS_SYSDATE","RS") ; 
			alert(invaldt);
			//parent.parent.messageFrame.location.href='../../eCommon/jsp/error.jsp?err_num='+invaldt;
			from.select();
			from.focus();
		}
	}
}
/************************************************************************/
function checkToDate(){
	var frmObj=document.forms[0];
	var to_dt =frmObj.to_dt;
	var today = frmObj.sys_date;
	var todate = to_dt.value;
	var todaydate = today.value;
	var toarray;
	var todayarray;
	if(todate.length > 0 && todaydate.length > 0){
		toarray = todate.split("/");
		todayarray = todaydate.split("/");
		var todt = new Date(toarray[2],toarray[1],toarray[0]);
		var todaydt = new Date(todayarray[2],todayarray[1],todayarray[0]);
		if(Date.parse(todaydt) > Date.parse(todt)){
			var invaldt =parent.parent.frames[1].getMessage("TO_DATE_LESS_SYSDATE","RS") ; 
			alert(invaldt);
			//parent.parent.messageFrame.location.href='../../eCommon/jsp/error.jsp?err_num='+invaldt;
			to_dt.select();
			to_dt.focus();
		}
	}
}
/************************************************************************/
/************************Date Validations Ends ********************************/
/************************************************************************/
function showStaff(target){

	var frmObj=document.formWrkScheduleCriteria;
	var role_type	= frmObj.role_type.value;
	var staff_type	= frmObj.staff_type.value;
	var position_code=frmObj.position_code.value;
	var position_desc=frmObj.position_text.value;

	var mode		= "call";
	var url = "../../eRS/jsp/SearchStaff.jsp?p_role_type="+role_type+"&p_staff_type="+staff_type+"&p_position_code="+position_code+"&p_position_desc="+position_desc+"&mode="+mode;

	if(frmObj.staff_id.value !=''){
		frmObj.staff_id.value="";
		frmObj.staff_text.value="";
	}

	var dialogHeight =window.screen.height ;
	var dialogWidth = window.screen.width ;
	var dialogTop	= 0;
	var dialogLeft = 0 ;
	var arguments   = "" ;
	var features    = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +";dialogTop:"+dialogTop+";dialogLeft:"+dialogLeft+"; scroll=no; status=no;";
	var retVal   = window.showModalDialog( url, arguments, features ) ;

	if(retVal !=null){
		if(role_type != retVal[2]){
			var len=frmObj.role_type.length;
			for(i=0;i<len;i++){
				if(frmObj.role_type.options[i].value==retVal[2]){
					frmObj.role_type.selectedIndex=i;
					break;
				}
			}
			rolechange();
		}
		if(staff_type != retVal[3]){
			var len=frmObj.staff_type.length;
			for(i=0;i<len;i++){
				if(frmObj.staff_type.options[i].value==retVal[3]){
					frmObj.staff_type.selectedIndex=i;
					break;
				}
			}
		}
		if(position_code != retVal[4]){
			var xmlDoc = new ActiveXObject("Microsoft.XMLDom" );
			var xmlHttp = new XMLHttpRequest();

			xmlStr ="<root><SEARCH " ;
			xmlStr +=" /></root>" ;
			xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
			xmlHttp.open( "POST", "../../eRS/jsp/GenerateWorkScheduleValidate.jsp?position_code="+retVal[4], false ) ;
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
function locnchange(){
	document.formWrkScheduleCriteria.work_text.value="";
	document.formWrkScheduleCriteria.wrk_code.value="";
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
}
/************************************************************************/
function positionchange(){
	document.forms[0].staff_id.value='';
	document.forms[0].staff_text.value='';
	document.forms[0].frm_dt.value='';
	document.forms[0].to_dt.value='';
}
/************************************************************************/
function stafftypechange(){
	document.forms[0].position_text.value='';
	document.forms[0].position_code.value='';
	document.forms[0].staff_id.value='';
	document.forms[0].staff_text.value='';
	document.forms[0].frm_dt.value='';
	document.forms[0].to_dt.value='';
}
/************************************************************************/
function staffchange(){
	document.forms[0].frm_dt.value='';
	document.forms[0].to_dt.value='';
}
/************************************************************************/
function GenerateSchedule(){

	if(mandatory()){
		if(todatecon){
			var formObj		= document.formWrkScheduleCriteria;
			var locale =formObj.locale.value;
			var facility_id		= formObj.facility_id.value;
			var locn_type		= formObj.locn.value;
			var wrkplace_code	= formObj.wrk_code.value;
			var role_type			= formObj.role_type.value;
			var position_code	= formObj.position_code.value;
			var staff_type			= formObj.staff_type.value;
			var staff_id				= formObj.staff_id.value;
			var frm_dt				= convertDate(formObj.frm_dt.value,'DMY',locale,"en");
			var to_dt				= convertDate(formObj.to_dt.value,'DMY',locale,"en");
						
			parent.frameset_GenerateWorkSchedule.rows='30%,5%,*';
			
			parent.frameGenWrkSchHdr.location.href="../../eRS/jsp/GenerateWorkScheduleHdr.jsp";
			parent.frameGenWrkSchResult.location.href="../../eRS/jsp/GenerateWorkScheduleResult.jsp?locn_type="+locn_type+"&wrkplace_code="+wrkplace_code+"&role_type="+role_type+"&position_code="+position_code+"&staff_type="+staff_type+"&staff_id="+staff_id+"&frm_dt="+frm_dt+"&to_dt="+to_dt+"&facility_id="+facility_id;
			parent.parent.messageFrame.location.href= "../../eCommon/jsp/error.jsp"+"";
			var i=0;
		
			while(formObj.elements(i)!=null)
				formObj.elements(i++).disabled=true;
			formObj.frm_dt_img.disabled=true;
			formObj.to_dt_img.disabled=true;
			
			
		}
		
		else{
			var frmObj=document.forms[0];
			
			var toDate = frmObj.to_dt;
			
			toDate.select();
			toDate.focus();

		}
	}
}
	
/************************************************************************/
function mandatory(){
	var frmObj=parent.frameGenWrkSchCriteria.document.formWrkScheduleCriteria;
	var fields = new Array ( frmObj.work_text,frmObj.frm_dt,frmObj.to_dt);
	var names = new Array (getLabel("eRS.WorkPlace.label","RS"),getLabel("Common.fromdate.label","Common"),getLabel("Common.todate.label","Common"));
	var	msgFrame=parent.parent.messageFrame;
	if(parent.frameGenWrkSchCriteria.checkFields(fields,names,msgFrame)) {
	   return true;
	}
	else
	  return false;
}

/************************************************************************/
function invokeChk(obj){
	if(obj.checked) {
		obj.value='Y'
	}else{
		obj.value='N'
	}
}

/************************************************************************/
function click_select(){
	if(document.form_WrkPlaceStaffHdr.chk_all.checked == true){
		for(cnt=0;cnt<parent.frameGenWrkSchResult.document.form_GenWrkSchResult.totalrecs.value; cnt++){
			val = eval("parent.frameGenWrkSchResult.document.form_GenWrkSchResult.select"+cnt);
			val.checked = true;
		}
	}else{
		for(cnt=0; cnt<parent.frameGenWrkSchResult.document.form_GenWrkSchResult.totalrecs.value; cnt++){
			val = eval("parent.frameGenWrkSchResult.document.form_GenWrkSchResult.select"+cnt);
			val.checked = false;
		}
	}
}
/************************************************************************/

