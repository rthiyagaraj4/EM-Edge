var function_id = "";
var previous_id="";
var previous_shift="";
var bykey=false;
var message='';
var total;
var prev_posit_shift_total;
var curr_posit_shift_total;
var prev_shit_total;
var curr_shift_total;
var productive_flag="";
var shift_indicator="";
var previous_ind="";
var previous_prod="";
var change=false;
var alloc_flag=true;
var txtflag=false;
var Position_code='';
var Role_type='';
var Staff_id='';
var Day='';
var Shift_ind='';
var Prod_flag='';
var prev_menu;

/****************************************************************/
function apply(){
	
	if (!checkIsValidForProceed()){
		message  = getMessage("NOT_VALID","Common");
		messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num="+ message;
		return false ;
	}
	if (!checkIsValidForProceed1()){
		message  = getMessage("NOT_VALID","Common");
		messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num="+ message;
		return false ;
	}
	if (!checkIsValidForProceed2()){
		////message  = getMessage("NOT_VALID","Common");
		//messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num="+ message;
		var frmobj=f_query_add_mod.frameCriteria.document.forms[0];
		if(frmobj==f_query_add_mod.frameCriteria.document.form_byWorkplace)
		{ 
			var fields = new Array (frmobj.workplace_desc,frmobj.requirement_id);
			var names = new Array (getLabel("eRS.WorkPlace.label","RS"),getLabel("eRS.Requirement.label","RS"));
			if(checkFields(fields,names,messageFrame)) 
			{ 
			
				return true;
			}
			
		}
		return false ;
	}
	//alert(frames[1].frameResult.frames[1].document.forms[0].name);
	var frmObj=frames[1].frameResult.frames[1].document.forms[0];
	//alert(""+frmObj.name);
	frmObj.submit();
}
/*****************************************************************/
function reset(){
	var url=f_query_add_mod.frameCriteria.location.href; 
	if(url.indexOf("blank")==-1) {
			var frmObj=frames[1].frameCriteria.document.forms[0]
			url=frames[1].frameResult.location.href;
			if((url.indexOf("blank")==-1)) {
				if(url.indexOf("Weekly")==-1) {
						messageFrame.location.href = "../../eCommon/jsp/error.jsp";
				}else{
					var frmObj=frames[1].frameResult.frameByWorkplaceResultWeekly.document.forms[0];
					var mode						=	frmObj.mode.value;
					var facility_id				=	frmObj.facility_id.value;
					var user_id					=	frmObj.user_id.value;
					var locn_type				=	frmObj.locn_type.value;
					var workplace_code	=	frmObj.workplace_code.value;
					var requirement_id		=	frmObj.requirement_id.value;
					var role_type				=	frmObj.role_type.value;
					var staff_type				=	frmObj.staff_type.value;
					var position_code		=	frmObj.position_code.value;
					var staff_id					=	frmObj.staff_id.value;
					var view						=	frmObj.view.value;
					var week_no				=	frmObj.week_no.value;

					frames[1].frameResult.frameByWorkplaceResultWeekly.location.href="../../eRS/jsp/MasterScheduleByWorkplaceResultWeekly.jsp?user_id="+user_id+"&locn_type="+locn_type+"&workplace_code="+workplace_code+"&requirement_id="+requirement_id+"&role_type="+role_type+"&staff_type="+staff_type+"&position_code="+position_code+"&staff_id="+staff_id+"&week_no="+week_no+"&facility_id="+facility_id+"&view="+view+"&mode="+mode;
					frames[1].frameResult.frameByWorkplaceResultHdr.formByWorkplaceResultHdr.reset();
				}
		  }
		  else{
		 var frmObj=frames[1].frameCriteria.document.forms[0];
	     frmObj.reset();
        //alert(frames[1].frameCriteria.location.href)
		//frames[1].frameCriteria.location.href='../../eRS/jsp/MasterScheduleCriteriabyWorkplace.jsp';
		frames[1].frameButtons.location.href='../../eCommon/html/blank.html';
		}
	}
	//alert(frames[1].frameButtons.location.href)
	frames[1].frameButtons.location.href='../../eCommon/html/blank.html';
}
/*****************************************************************/
function showWorkplace(){

	parent.frameCriteria.location.href='../../eRS/jsp/MasterScheduleCriteriaByWorkplace.jsp';
	parent.frameButtons.location.href='../../eCommon/html/blank.html';
	parent.parent.messageFrame.location.href = '../../eCommon/jsp/error.jsp';
}
/*****************************************************************/
function showStaff(){

	parent.frameCriteria.location.href="../../eRS/jsp/MasterScheduleCriteriaByStaff.jsp";
	parent.frameButtons.location.href='../../eCommon/html/blank.html';
	parent.parent.messageFrame.location.href = '../../eCommon/jsp/error.jsp';
}
/*****************************************************************/
function selectWorplace(call_mode, target){
	
	var argumentArray  = new Array() ;
	var dataNameArray  = new Array() ; 
	var dataValueArray = new Array() ;
	var dataTypeArray  = new Array() ;

	var frmObj		=parent.frameCriteria.document.form_byWorkplace;
	
	var workplace	 =frmObj.workplace_desc.value;
	
	if((call_mode == 'T')&&(workplace == '')){
		
		frmObj.workplace_code.value='';
		return false;
	}
	var facility_id		=frmObj.facility_id.value;
	var user_id		=frmObj.user_id.value;
	var locn_type		=frmObj.locn_type[frmObj.locn_type.selectedIndex].value;
	var locn_desc	=frmObj.locn_type[frmObj.locn_type.selectedIndex].text;
	//alert("facility_id----|" +facility_id+ "|-----user_id---|" +user_id+ "|-----locn_type----|" +locn_type+ "|---locn_desc---|" +locn_desc+ "|---");
	if(frmObj.workplace_code.value !=''){
		
		frmObj.workplace_code.value='';
		frmObj.workplace_desc.value='';
	}
	if(locn_type==""){
		argumentArray[0] ="select workplace_code code, workplace_desc description from rs_workplace_access_vw where facility_id='"+facility_id+"' and appl_user_id='"+user_id+"' and  upper(workplace_code) like upper(?) and upper(workplace_desc) like upper(?) and  ('"+locn_type+"'is null or locn_type ='"+locn_type+"') and eff_status='E' and allocate_yn='Y' order by workplace_desc";

		argumentArray[1] = dataNameArray ;
		argumentArray[2] = dataValueArray ;
		argumentArray[3] = dataTypeArray ;
		argumentArray[4] = "1,2"; 

	} else if (!(locn_type=="")){  
		argumentArray[0] ="select workplace_code code, workplace_desc description from rs_workplace_access_vw where facility_id='"+facility_id+"' and appl_user_id='"+user_id+"' and  locn_type='"+locn_type+"' and upper(workplace_code) like upper(?) and upper(workplace_desc) like upper(?) and eff_status='E' and allocate_yn='Y' order by workplace_desc";

		argumentArray[1] = dataNameArray ;
		argumentArray[2] = dataValueArray ;
		argumentArray[3] = dataTypeArray ;
		argumentArray[4] = "1,2"; 
	}
	argumentArray[5] = target.value;
	argumentArray[6] = CODE_LINK ;//CODE_LINK
	argumentArray[7] = CODE_DESC ;//CODE_DESC
	retVal = CommonLookup(getLabel("eRS.WorkPlace.label","RS"), argumentArray );
	if(retVal != null && retVal != "") {
		target.value = retVal[1] ;
		frmObj.workplace_code.value = retVal[0];
	}else
		target.value ="";
	frmObj.requirement_id.value="";
	frmObj.requirement_desc.value="";
	frmObj.role_type.selectedIndex=0;
	role_change();
}
/*****************************************************************/
function selectRequirement(call_mode, target){
	
	var argumentArray  = new Array() ;
	var dataNameArray  = new Array() ;
	var dataValueArray = new Array() ;
	var dataTypeArray  = new Array() ;

	var frmObj		=parent.frameCriteria.document.form_byWorkplace;
	//alert("frmObj---->" +frmObj.name);
	var requirement_id	 =frmObj.requirement_id.value;
	//alert("requirement_id--->" +requirement_id);
	if((call_mode == 'T')&&(requirement_id == '')) {
		
		frmObj.requirement_id.value='';
		return false;
	}
	var facility_id		=frmObj.facility_id.value;
	var user_id		=frmObj.user_id.value;
	var workplace_code=frmObj.workplace_code.value;
	var fields = new Array (frmObj.workplace_code);			    
	var names = new Array (getLabel("eRS.Workplace.label","RS"));		
	if(parent.parent.f_query_add_mod.checkFields( fields, names, parent.parent.messageFrame)){	
		
			if(frmObj.requirement_desc.value !=''){
				
				frmObj.requirement_id.value='';
				frmObj.requirement_desc.value='';
			}

		argumentArray[0] ="select requirement_id code, requirement_desc description from rs_workplace_requirement where facility_id ='"+facility_id+"' and workplace_code='"+workplace_code+"' and  upper(requirement_id) like upper(?) and upper(requirement_desc) like upper(?) and ((requirement_type = 'V' and requirement_date_to > sysdate) or (requirement_type = 'C' and requirement_date_fm is null and requirement_date_to is null)) ";

		argumentArray[1] = dataNameArray ;
		argumentArray[2] = dataValueArray ;
		argumentArray[3] = dataTypeArray ;
		argumentArray[4] = "1,2"; 
		argumentArray[5] = target.value;
		argumentArray[6] = CODE_LINK ;//CODE_LINK
		argumentArray[7] = CODE_DESC ;//CODE_DESC
		retVal = CommonLookup(getLabel("eRS.Requirement.label","RS"), argumentArray );
		if(retVal != null && retVal != "") {
			//alert("retVal--->" +retVal);
			target.value = retVal[0] ;
			//alert("target.value " +target.value );
			var requirement_id=retVal[0];
			frmObj.requirement_desc.value=retVal[1];
			var xmlDoc = "" ;
			var xmlHttp = new XMLHttpRequest() ;
			xmlStr ="<root><SEARCH " ;
			xmlStr +=" /></root>" ;
			xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
			//to get the period for selected requirement
			xmlHttp.open( "POST","../../eRS/jsp/MasterScheduleValidate1.jsp?requirement_id="+requirement_id+"&workplace_code="+workplace_code+"&facility_id="+facility_id, false);
			xmlHttp.send( xmlDoc ) ;
			responseText=xmlHttp.responseText ;
			//alert(responseText);
			eval(responseText);
			
		}else
			target.value ="";
	}
	frmObj.role_type.selectedIndex=0;
	role_change();
}
/*****************************************************************/
//this fuction is calling from MasterScheduleValidate1.jsp
function assignDateRange(from, to){
	var frmObj=parent.frameCriteria.document.form_byWorkplace;
	var date_range_txt='';
	if(!((from == 'null')&&(to=='null')))
		date_range_txt="\n   "+from+" to "+to;
	else
		date_range_txt="";
	frmObj.date_range.value=date_range_txt;
}
/*****************************************************************/
function displayDateRange(obj){
	var frmObj=parent.frameCriteria.document.form_byWorkplace;
	var req=frmObj.requirement_desc.value;
	var date_range_txt=frmObj.date_range.value;
	obj.innerText="   "+req+date_range_txt;
}
/*****************************************************************/
function selectStaffID(target){
	var frmObj		=parent.frameCriteria.document.form_byWorkplace;
	var p_role_type=frmObj.role_type[frmObj.role_type.selectedIndex].value;
	var p_staff_type=frmObj.staff_type[frmObj.staff_type.selectedIndex].value;
	//alert(frmObj.position.selectedIndex);
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
	var frmObj=parent.frameCriteria.document.forms[0];
	//alert("frmObj--->" +frmObj.name);
	var selected		=frmObj.locn_type.selectedIndex;
	frmObj.reset();
	frmObj.locn_type.selectedIndex=selected;
}
/*****************************************************************/
function role_change(){
	clearStaffType( ) ;
	clearPosition();
	var frmObj=parent.frameCriteria.document.forms[0];
	var role=frmObj.role_type[frmObj.role_type.selectedIndex].value;
	if(role !=''){
		var xmlDoc="";
		var xmlHttp = new XMLHttpRequest();
		xmlStr ="<root><SEARCH " ;
		xmlStr +=" /></root>" ;
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml") ;
		xmlHttp.open( "POST","../../eRS/jsp/MasterScheduleValidate1.jsp?role="+role, false);
		xmlHttp.send( xmlDoc ) ;
		responseText=xmlHttp.responseText ;
		//alert(responseText);
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
	parent.frameCriteria.document.forms[0].staff_type.add(element);
}
/************************************************************************/
function addPosition(code,value) {
	var element = document.createElement('OPTION') ;
	element.value =  code ;
	element.text = value ;
	parent.frameCriteria.document.forms[0].position.add(element);
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
	var frmObj=parent.frameCriteria.document.forms[0];
	frmObj.staff_id.value="";
	frmObj.staff_name.value="";
}
/*****************************************************************/
function stafftype_change(role){
	clearPosition();
	var frmObj=parent.frameCriteria.document.forms[0];
	var role=frmObj.role_type[frmObj.role_type.selectedIndex].value
	var staff_type=frmObj.staff_type[frmObj.staff_type.selectedIndex].value;
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest() ;
	xmlStr ="<root><SEARCH " ;
	xmlStr +=" /></root>" ;
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open( "POST","../../eRS/jsp/MasterScheduleValidate1.jsp?role="+role+"&staff_type="+staff_type, false);
	xmlHttp.send( xmlDoc ) ;
	responseText=xmlHttp.responseText ;
	eval(responseText);
	frmObj.position.selectedIndex=0;
	frmObj.staff_id.value="";
	frmObj.staff_name.value="";
}
/*****************************************************************/
function showDetails(){
	var frmObj					=parent.frameCriteria.document.forms[0];
	var mode						=frmObj.mode.value;
	var facility_id				=frmObj.facility_id.value;
	var user_id					=frmObj.user_id.value;
	var locn_type				=frmObj.locn_type[frmObj.locn_type.selectedIndex].value;
	var workplace_code	=frmObj.workplace_code.value;
	var requirement_id	=frmObj.requirement_id.value;
	var role_type				=frmObj.role_type[frmObj.role_type.selectedIndex].value;
	var staff_type			=frmObj.staff_type[frmObj.staff_type.selectedIndex].value;
	var position_code					=frmObj.position[frmObj.position.selectedIndex].value;
	var staff_id					=frmObj.staff_id.value;
	var view						=frmObj.view[frmObj.view.selectedIndex].value;
	var week_count			=frmObj.week_count.value;
	var fields = new Array (frmObj.workplace_code,frmObj.requirement_id);			    
	var names = new Array (getLabel("eRS.Workplace.label","RS"),getLabel("eRS.Requirement.label","RS"));			
	if(parent.parent.f_query_add_mod.checkFields( fields, names, parent.parent.messageFrame)){	
/*to display the week no buttons...		
		var i=0;
			while(frmObj.elements(i)!=null){
					frmObj.elements(i).disabled=true;
					i++;
			}
parent.frameButtons.location.href="../../eRS/jsp/MasterScheduleWeekButtons.jsp?user_id="+user_id+"&locn_type="+locn_type+"&workplace_code="+workplace_code+"&requirement_id="+requirement_id+"&role_type="+role_type+"&staff_type="+staff_type+"&position_code="+position_code+"&staff_id="+staff_id+"&week_count="+week_count+"&facility_id="+facility_id+"&view="+view+"&mode="+mode;
		parent.parent.messageFrame.location.href =  "../../eCommon/jsp/error.jsp";
/*	to hide the week no buttons*/
	var week_no=1;
	parent.parent.f_query_add_mod.frameset_MasterSchedule.rows="0%,0%,0%,100%";
	parent.parent.f_query_add_mod.frameResult.location.href="../../eRS/jsp/MasterScheduleByWorkplaceResultWeeklyFrames.jsp?user_id="+user_id+"&locn_type="+locn_type+"&workplace_code="+workplace_code+"&requirement_id="+requirement_id+"&role_type="+role_type+"&staff_type="+staff_type+"&position_code="+position_code+"&staff_id="+staff_id+"&week_no="+week_no+"&facility_id="+facility_id+"&view="+view+"&mode="+mode;
	parent.parent.messageFrame.location.href =  "../../eCommon/jsp/error.jsp";
	return;
	}

}
/*****************************************************************/
function showWeek(week_no,from){

	var frmObj					=	document.forms[0];
	var mode						=	frmObj.mode.value;
	var facility_id				=	frmObj.facility_id.value;
	var user_id					=	frmObj.user_id.value;
	var locn_type				=	frmObj.locn_type.value;
	var workplace_code	=	frmObj.workplace_code.value;
	var requirement_id		=	frmObj.requirement_id.value;
	var role_type				=	frmObj.role_type.value;
	var staff_type				=	frmObj.staff_type.value;
	var position_code		=	frmObj.position_code.value;
	var staff_id					=	frmObj.staff_id.value;
	var view						=	frmObj.view.value;
	var dialogHeight ='35' ;
	var dialogWidth = '50' ;
	var dialogTop	= '61';
	var dialogLeft = '5' ;
	var features = 'dialogHeight:' + dialogHeight + '; dialogWidth:' + dialogWidth +';dialogTop:'+dialogTop+';dialogLeft:'+dialogLeft+'; scroll=no; status=no';
	var arguments = "";
	//var retVals = window.showModalDialog("../../eRS/jsp/MasterScheduleByWorkplaceResultWeeklyFrames.jsp?user_id="+user_id+"&locn_type="+locn_type+"&workplace_code="+workplace_code+"&requirement_id="+requirement_id+"&role_type="+role_type+"&staff_type="+staff_type+"&position_code="+position_code+"&staff_id="+staff_id+"&week_no="+week_no+"&facility_id="+facility_id+"&mode="+mode,arguments,features);
	parent.parent.f_query_add_mod.frameset_MasterSchedule.rows="0%,0%,0%,100%";
	parent.parent.f_query_add_mod.frameResult.location.href="../../eRS/jsp/MasterScheduleByWorkplaceResultWeeklyFrames.jsp?user_id="+user_id+"&locn_type="+locn_type+"&workplace_code="+workplace_code+"&requirement_id="+requirement_id+"&role_type="+role_type+"&staff_type="+staff_type+"&position_code="+position_code+"&staff_id="+staff_id+"&week_no="+week_no+"&facility_id="+facility_id+"&view="+view+"&mode="+mode;
	parent.parent.messageFrame.location.href =  "../../eCommon/jsp/error.jsp";
	return;
}
/****************************************************************/
function  showAllWeek(){ 
	var frmObj=document.forms[0];
	var mode						=frmObj.mode.value;
	var facility_id				=frmObj.facility_id.value;
	var workplace_code	=frmObj.workplace_code.value;
	var requirement_id	=frmObj.requirement_id.value;
	var role_type				=frmObj.role_type.value;
	var position_code		=frmObj.position_code.value;
	var staff_id					=frmObj.staff_id.value;
	var view						=frmObj.view.value;
	var week_count						=frmObj.week_count.value;
	var dialogHeight ='35' ;
	var dialogWidth = '50' ;
	var dialogTop	= '61';
	var dialogLeft = '5' ;
	var features = 'dialogHeight:' + dialogHeight + '; dialogWidth:' + dialogWidth +';dialogTop:'+dialogTop+';dialogLeft:'+dialogLeft+'; scroll=no; status=no';
	var arguments = "";
	parent.parent.f_query_add_mod.frameset_MasterSchedule.rows="0%,0%,0%,100%";
	parent.parent.f_query_add_mod.frameResult.location.href="../../eRS/jsp/MasterScheduleCompleteViewFrameset.jsp?workplace_code="+workplace_code+"&requirement_id="+requirement_id+"&role_type="+role_type+"&position_code="+position_code+"&staff_id="+staff_id+"&week_count="+week_count+"&facility_id="+facility_id+"&view="+view+"&mode="+mode;
	parent.parent.messageFrame.location.href =  "../../eCommon/jsp/error.jsp";
	return;
}
/*******************************************************/
function clearstaff(role_type, staff_id, position_code){
	
	if(prev_menu){
		prev_menu.style.visibility="hidden";
		prev_menu.style.display='none';
	}

	var frmObj=parent.frames[1].document.forms[0];
	for(day=0;day<7;day++){
		var shift_id=eval("frmObj.shift_code"+role_type+staff_id+day).value;
		var shift_mnem=eval("frmObj.shift"+role_type+staff_id+day).value;
		var prod_flag=eval("frmObj.productive_flag"+role_type+staff_id+day).value;
		var shift_ind=eval("frmObj.shift_indicator"+role_type+staff_id+day).value;
		if(shift_id !=''){

				eval("frmObj.shift"+role_type+staff_id+day).value='';
				eval("frmObj.shift_code"+role_type+staff_id+day).value='';
				shiftDelete(shift_id,shift_mnem,shift_ind, prod_flag, position_code, role_type, staff_id,day);
		}
	}
}
/*********************************************************/
function onallocation(day,position_code,role_type,staff_id){
	

	var req_total=0;
	var alloc_total=0;
	var pos_shif_req=0;
	var pos_shif_alloc=0;
	var shif_total_req=0;
	var shif_total_alloc=0;
	var frmObj=parent.frames[1].document.forms[0];
	var allocated_id=eval("frmObj.shift_code"+role_type+staff_id+day).value;
	
	var allocated_shift=eval("frmObj.shift"+role_type+staff_id+day).value;
	
	productive_flag=eval("frmObj.productive_flag"+role_type+staff_id+day).value;
	shift_indicator=eval("frmObj.shift_indicator"+role_type+staff_id+day).value;
	
	/*req_total=parseInt(eval("frmObj.req_total"+day).value);
	alloc_total=parseInt(eval("frmObj.alloc_total"+day).value);
	total=eval(eval("parent.frames[1].document.getElementById("req_alloc_total")"+day));*/

	//Adding Shift
	    
		
		if(previous_id == ''){
					
			if(allocated_shift != ''){
				shiftAllocate(allocated_id, allocated_shift,shift_indicator, productive_flag,position_code,role_type,staff_id,day);
			}
		}else{
			
			if((previous_id != allocated_id)&&(previous_shift != allocated_shift)&&(allocated_shift != '')){ 
				shiftDelete(previous_id,previous_shift,previous_ind, previous_prod, position_code, role_type,staff_id,day);
				shiftAllocate(allocated_id, allocated_shift,shift_indicator, productive_flag,position_code,role_type,staff_id,day);
			}
		}

		//Removing Shift
		if((allocated_shift == '')&&(allocated_id != '')){
				shiftDelete(allocated_id, allocated_shift,shift_indicator, productive_flag,position_code,role_type,staff_id,day);
		}
		if(change){
			changeColor(position_code, allocated_id, day);
	}
	previous_id ='';
	previous_shift = '';
	previous_ind = '';
	previous_prod = '';
	alloc_flag=true;
}
/***********************************************************/
function shiftAllocate(allocated_id,allocated_shift,shift_ind, prod_flag,position_code,role_type, staff_id,day){
	
	var frmObj=parent.frames[1].document.forms[0];
	
 	if(shift_ind == 'U'){
		

		eval("frmObj.shift"+role_type+staff_id+day).style.backgroundColor='#FFCC00';
		alloc_total=parseInt(eval("frmObj.unproductive_alloc"+day).value)+1;
		eval("frmObj.unproductive_alloc"+day).value=alloc_total;
		eval(eval("document.getElementById("unproductive_total")"+day)).innerText = alloc_total;
		change=false;
	}
	else if(prod_flag == "O"){
		
	
		eval("frmObj.shift"+role_type+staff_id+day).style.backgroundColor='#00CC66';

		req_total=parseInt(eval("frmObj.oncall_req"+day).value);
		alloc_total=parseInt(eval("frmObj.oncall_alloc"+day).value)+1;
		eval("frmObj.oncall_alloc"+day).value=alloc_total;
		eval(eval("document.getElementById("oncall_total")"+day)).innerText = alloc_total+"/"+req_total;
		if(alloc_total > req_total)
			eval(eval("document.getElementById("oncall_total")"+day)).className = "ABOVEOPTIMAL";
		if(alloc_total < req_total)
			eval(eval("document.getElementById("oncall_total")"+day)).className = "BELOWOPTIMAL";
		if(alloc_total == req_total)
			eval(eval("document.getElementById("oncall_total")"+day)).className = "OPTIMAL";

		change=false;
	}
	else{
		
		req_total=parseInt(eval("frmObj.req_total"+day).value);
		alloc_total=parseInt(eval("frmObj.alloc_total"+day).value);
		total=eval(eval("parent.frames[1].document.getElementById("req_alloc_total")"+day));
		alloc_total++;
		
		
		eval("frmObj.alloc_total"+day).value=alloc_total;
		total=eval(eval("parent.frames[1].document.getElementById("req_alloc_total")"+day));
		
		total.innerText=alloc_total+"/"+req_total;
		pos_shif_req=parseInt(eval("frmObj.req_position"+position_code+allocated_id+day).value);
		pos_shif_alloc=parseInt(eval("frmObj.alloc_position"+position_code+allocated_id+day).value);

		pos_shif_alloc++;
		eval("frmObj.alloc_position"+position_code+allocated_id+day).value=pos_shif_alloc;
		curr_posit_shift_total=eval(eval("parent.frames[1].document.getElementById("req_alloc_position")"+position_code+allocated_id+day));
		curr_posit_shift_total.innerText=pos_shif_alloc+"/"+pos_shif_req;
		shif_total_req=parseInt(eval("frmObj.req_shift"+allocated_id+day).value);
		shif_total_alloc=parseInt(eval("frmObj.alloc_shift"+allocated_id+day).value);
		shif_total_alloc++;
		
		eval("frmObj.alloc_shift"+allocated_id+day).value=shif_total_alloc;
		curr_shift_total=eval(eval("parent.frames[1].document.getElementById("req_alloc_shift")"+allocated_id+day));
		curr_shift_total.innerText=shif_total_alloc+"/"+shif_total_req;
		change=true;

	}
}
/**************************************************************************/
function changeColor(position_code, allocated_id, day){
	var frmObj=parent.frames[1].document.forms[0];
	req_total=parseInt(eval("frmObj.req_total"+day).value);
	alloc_total=parseInt(eval("frmObj.alloc_total"+day).value);
	pos_shif_req=parseInt(eval("frmObj.req_position"+position_code+allocated_id+day).value);

	pos_shif_alloc=parseInt(eval("frmObj.alloc_position"+position_code+allocated_id+day).value);
	shif_total_req=parseInt(eval("frmObj.req_shift"+allocated_id+day).value);
	shif_total_alloc=parseInt(eval("frmObj.alloc_shift"+allocated_id+day).value);

	total=eval(eval("parent.frames[1].document.getElementById("req_alloc_total")"+day));

	if(alloc_total < req_total)
		total.className='BELOWOPTIMAL';
	if(alloc_total > req_total)
		total.className='ABOVEOPTIMAL';
	if(alloc_total == req_total)
		total.className='OPTIMAL';
	if((alloc_total == 0)&&(req_total == 0))
		total.className = "REQUIREMENT";

	if(pos_shif_alloc < pos_shif_req)
		curr_posit_shift_total.className='BELOWOPTIMAL';
	if(pos_shif_alloc > pos_shif_req)
		curr_posit_shift_total.className='ABOVEOPTIMAL';
	if(pos_shif_alloc == pos_shif_req)
		curr_posit_shift_total.className='OPTIMAL';
	if((pos_shif_alloc == 0)&&(pos_shif_req == 0))
		curr_posit_shift_total.className = "ALOCATED";

	if(shif_total_alloc < shif_total_req )
		curr_shift_total.className='BELOWOPTIMAL';
	if(shif_total_alloc > shif_total_req )
		curr_shift_total.className='ABOVEOPTIMAL';
	if(shif_total_alloc == shif_total_req )
		curr_shift_total.className='OPTIMAL';
	if((shif_total_alloc == 0)&&(shif_total_req == 0))
		curr_shift_total.className = "SHIFTTOTAL";
	change=false;
}
/*****************************************************************/
function shiftDelete(shift_id,shift_mnem,shift_ind, prod_flag,position_code, role_type,staff_id, day){
	
	var frmObj=parent.frames[1].document.forms[0];

	if(shift_ind == 'U'){
		alloc_total=parseInt(eval("frmObj.unproductive_alloc"+day).value);
		if(alloc_total > 0)
			alloc_total--;
		eval("frmObj.unproductive_alloc"+day).value=alloc_total;
		eval(eval("parent.frames[1].document.getElementById("unproductive_total")"+day)).innerText = alloc_total;
		eval("frmObj.shift"+role_type+staff_id+day).style.backgroundColor='white';
		change=false;
	}
	else if(prod_flag == "O"){
		req_total=parseInt(eval("frmObj.oncall_req"+day).value);
		alloc_total=parseInt(eval("frmObj.oncall_alloc"+day).value);
		if(alloc_total >0)
			alloc_total--;
		eval("frmObj.oncall_alloc"+day).value=alloc_total;
		eval(eval("parent.frames[1].document.getElementById("oncall_total")"+day)).innerText = alloc_total+"/"+req_total;
		if(alloc_total > req_total)
			eval(eval("parent.frames[1].document.getElementById("oncall_total")"+day)).className = "ABOVEOPTIMAL";
		if(alloc_total < req_total)
			eval(eval("parent.frames[1].document.getElementById("oncall_total")"+day)).className = "BELOWOPTIMAL";
		if(alloc_total == req_total)
			eval(eval("parent.frames[1].document.getElementById("oncall_total")"+day)).className = "OPTIMAL";
		if((alloc_total == 0)&&(req_total == 0))
			eval(eval("document.getElementById("oncall_total")"+day)).className = "REQUIREMENT";

		eval("frmObj.shift"+role_type+staff_id+day).style.backgroundColor='white';
		change=false;
	}
	else{
		
		req_total=parseInt(eval("frmObj.req_total"+day).value);
		alloc_total=parseInt(eval("frmObj.alloc_total"+day).value);
		total=eval(eval("parent.frames[1].document.getElementById("req_alloc_total")"+day));
		if(alloc_total>0){
		alloc_total--;
		eval("frmObj.alloc_total"+day).value=alloc_total;
		total=eval(eval("parent.frames[1].document.getElementById("req_alloc_total")"+day));
		total.innerText=alloc_total+"/"+req_total;
		}
		pos_shif_req=parseInt(eval("frmObj.req_position"+position_code+shift_id+day).value);
		pos_shif_alloc=parseInt(eval("frmObj.alloc_position"+position_code+shift_id+day).value);
	if(pos_shif_alloc>0){
			pos_shif_alloc--;
			eval("frmObj.alloc_position"+position_code+shift_id+day).value=pos_shif_alloc;
			curr_posit_shift_total=eval(eval("parent.frames[1].document.getElementById("req_alloc_position")"+position_code+shift_id+day));
			curr_posit_shift_total.innerText=pos_shif_alloc+"/"+pos_shif_req;
		}
		shif_total_req=parseInt(eval("frmObj.req_shift"+shift_id+day).value);
		shif_total_alloc=parseInt(eval("frmObj.alloc_shift"+shift_id+day).value);
		if(shif_total_alloc>0){
			shif_total_alloc--;
			eval("frmObj.alloc_shift"+shift_id+day).value=shif_total_alloc;
			curr_shift_total=eval(eval("parent.frames[1].document.getElementById("req_alloc_shift")"+shift_id+day));
			curr_shift_total.innerText=shif_total_alloc+"/"+shif_total_req;
		}	
		changeColor(position_code, shift_id, day);
	}
}
/******************************************************************/
function checkshift( day,role_type,staff_id,position_code) {//KEY PERSS
	bykey=true;
	var key = window.event.keyCode;
	if( (key >= 97) && (key <= 122) ){
		event.keyCode -= 32;
		key -= 32;
	}
	var exist=false;
	var key_value=String.fromCharCode(key);

	if(key_value !=""){
			exist=shift_contains(key_value,role_type, staff_id,day,position_code);
	}
	else
		exist= true;
		
	if(!exist){
		exist=false;
		message=getMessage("INVALID_SHIFT","RS");
		alloc_flag=false;
		alert(message);
	}
	return exist;
}
/***********************************************************/
function checkshiftlost( obj, role_type, staff_id,day,position_code) {//onblur

	var key_value=obj.value;
	var frmObj=document.forms[0];
	if((key_value != '')&&(bykey == false)){
		var exist=false;
		if(key_value !=""){
			exist=shift_contains(key_value,role_type, staff_id,day,position_code);
		}
		else
			exist= true;
			
		if(!exist){
			exist=false;
			message=getMessage("INVALID_SHIFT","RS")
				alloc_flag=false;
			alert(message);
			obj.value='';
		}
	}
	bykey=false;
}
/***********************************************************************************/
function shift_contains(shift, role_type, staff_id,day,position_code){
	var p_mnemonic_key='';
	var p_shift_code='';
	var u_mnemonic_key='';
	var u_shift_code='';
	var o_mnemonic_key='';
	var o_shift_code='';
	var flag=false;

	var p_mnemonic_keys=new Array();
	var p_shift_codes=new Array();
	var u_mnemonic_keys=new Array();
	var u_shift_codes=new Array();
	var o_mnemonic_keys=new Array();
	var o_shift_codes=new Array();
	var frmObj=parent.frameByWorkplaceResultWeekly.document.formByWorkplaceResultWeekly;
	previous_id = eval("frmObj.shift_code"+role_type+staff_id+day).value;
	previous_shift = eval("frmObj.shift"+role_type+staff_id+day).value;
	previous_ind = eval("frmObj.shift_indicator"+role_type+staff_id+day).value;
	previous_prod = eval("frmObj.productive_flag"+role_type+staff_id+day).value;


	p_mnemonic_key=eval("frmObj."+position_code+"p_shift_mnemonic_list").value;
	p_shift_code=eval("frmObj."+position_code+"p_shift_code_list").value;
	u_mnemonic_key=eval("frmObj."+position_code+"u_shift_mnemonic_list").value;
	u_shift_code=eval("frmObj."+position_code+"u_shift_code_list").value;
	o_mnemonic_key=eval("frmObj."+position_code+"o_shift_mnemonic_list").value;
	o_shift_code=eval("frmObj."+position_code+"o_shift_code_list").value;

	p_mnemonic_keys=p_mnemonic_key.split("|");
	p_shift_codes=p_shift_code.split("|");
	u_mnemonic_keys=u_mnemonic_key.split("|");
	u_shift_codes=u_shift_code.split("|");
	o_mnemonic_keys=o_mnemonic_key.split("|");
	o_shift_codes=o_shift_code.split("|");

	for(var i=0; i<p_mnemonic_keys.length;i++){		
		if(shift == p_mnemonic_keys[i]){
			eval("frmObj.shift_code"+role_type+staff_id+day).value=p_shift_codes[i];
			eval("frmObj.shift_indicator"+role_type+staff_id+day).value="P";
			eval("frmObj.productive_flag"+role_type+staff_id+day).value="W";
			shift_mnem=p_mnemonic_keys[i];
			shift_cod=p_shift_codes[i];
			flag=true;
			break;
		}		
	}
	for(var i=0; i<u_mnemonic_keys.length;i++){		
		if(shift == u_mnemonic_keys[i]){
			eval("frmObj.shift_code"+role_type+staff_id+day).value=u_shift_codes[i];
			eval("frmObj.shift_indicator"+role_type+staff_id+day).value="U";
			eval("frmObj.productive_flag"+role_type+staff_id+day).value="";
			shift_mnem=u_mnemonic_keys[i];
			shift_cod=u_shift_codes[i];
			flag=true;
			break;
		}		
	}
	for(var i=0; i<o_mnemonic_keys.length;i++){		
		if(shift == o_mnemonic_keys[i]){
			eval("frmObj.shift_code"+role_type+staff_id+day).value=o_shift_codes[i];
			eval("frmObj.shift_indicator"+role_type+staff_id+day).value="P";
			eval("frmObj.productive_flag"+role_type+staff_id+day).value="O";
			shift_mnem=o_mnemonic_keys[i];
			shift_cod=o_shift_codes[i];
			flag=true;
			break;
		}		
	}
	return flag
}
/*******************************************************/
function check(target,position_code,role_type, staff_id,day){
	
	var shift=target.value;
	var frmObj=document.forms[0];
	if(alloc_flag == false){
		onallocation(day,position_code,role_type,staff_id)
	}
	if(shift == '')
		eval("frmObj.shift_code"+role_type+staff_id+day).value='';
}
/***********************************************************/
function getShiftPattern(role_type, staff_id,position_code,rec_no){
	var argumentArray  = new Array() ;
	var dataNameArray  = new Array() ;
	var dataValueArray = new Array() ;
	var dataTypeArray  = new Array() ;

	var frmObj		=document.forms[0];
	var facility_id		=frmObj.facility_id.value;
	var workplace_code		=frmObj.workplace_code.value;
	var week_no		=frmObj.week_no.value;
	//alert("frmObj--->" +frmObj.name+ "facility_id--->" +facility_id+ "workplace_code--->" +workplace_code+ "week_no--->" +week_no);
	argumentArray[0] ="select shift_pattern_id code, long_desc description from rs_shift_pattern where facility_id = '"+facility_id+"' and eff_status = 'E' and upper(shift_pattern_id) like (?) and upper(long_desc) like (?) and (facility_id,shift_pattern_id) in (select facility_id,shift_pattern_id from rs_shift_pattern_for_workplace where facility_id ='"+facility_id+"' and workplace_code = '"+workplace_code+"') order by long_desc";

		argumentArray[1] = dataNameArray ;
		argumentArray[2] = dataValueArray ;
		argumentArray[3] = dataTypeArray ;
		argumentArray[4] = "1,2"; 

	argumentArray[5] = '';
	argumentArray[6] = CODE_LINK ;//CODE_LINK
	argumentArray[7] = CODE_DESC ;//CODE_DESC
	retVal = CommonLookup(getLabel("eRS.ShiftPattern.label","RS"), argumentArray );
	//alert("retVal---->" +retVal);
	if(retVal != null && retVal != "") {
		
		eval("frmObj.shift_pattern_id"+rec_no).value=retVal[0];
		eval("frmObj.shift_pattern_desc"+rec_no).value=retVal[1];
		
		clearstaff(role_type,staff_id, position_code);

		var shift_pattern_id=retVal[0];
		//alert("shift_pattern_id-->" +shift_pattern_id);
		var xmlDoc = "" ;
		var xmlHttp = new XMLHttpRequest() ;
		xmlStr ="<root><SEARCH " ;
		xmlStr +=" /></root>" ;
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open( "POST","../../eRS/jsp/MasterScheduleValidate2.jsp?facility_id="+facility_id+"&shift_pattern_id="+shift_pattern_id+"&week_no="+week_no+"&role_type="+role_type+"&staff_id="+staff_id+"&position_code="+position_code, false);
		xmlHttp.send( xmlDoc ) ;
		responseText=xmlHttp.responseText ;
		//alert("responseText--->"+responseText);
		eval(responseText);
		
		

	}else{
		
		eval("frmObj.shift_pattern_id"+rec_no).value='';
		eval("frmObj.shift_pattern_desc"+rec_no).value='';
	}
}
/*******************************************************/
function assignShift(day_no, shift_code, shift_mnemonic, shift_ind, prod_flag, role_type, staff_id,position_code){
		
	var frmObj=document.forms[0];
	var day=day_no-1;
	if(assignCheck(day,shift_code, shift_mnemonic,role_type,staff_id,position_code)){
		eval("frmObj.shift"+role_type+staff_id+day).value=shift_mnemonic;
		eval("frmObj.shift_code"+role_type+staff_id+day).value=shift_code;
		eval("frmObj.shift_indicator"+role_type+staff_id+day).value	=	shift_ind;
		eval("frmObj.productive_flag"+role_type+staff_id+day).value	=	prod_flag;
		onallocation(day,position_code,role_type,staff_id);
	}
}
/*******************************************************/
function assignCheck(day,shift_code, shift_mnemonic,role_type, staff_id,position_code){
	var exist=false;
	var i=0;
	var p_shift_code='';
	var u_shift_code='';
	var o_shift_code='';

	var p_shift_codes=new Array();
	var u_shift_codes=new Array();
	var o_shift_codes=new Array();

	var frmObj=parent.frameByWorkplaceResultWeekly.document.formByWorkplaceResultWeekly;
	previous_id = eval("frmObj.shift_code"+role_type+staff_id+day).value;
	previous_shift = eval("frmObj.shift"+role_type+staff_id+day).value;
	previous_ind = eval("frmObj.shift_indicator"+role_type+staff_id+day).value;
	previous_prod = eval("frmObj.productive_flag"+role_type+staff_id+day).value;

	p_shift_code=eval("frmObj."+position_code+"p_shift_code_list").value;
	u_shift_code=eval("frmObj."+position_code+"u_shift_code_list").value;
	o_shift_code=eval("frmObj."+position_code+"o_shift_code_list").value;
	p_shift_codes=p_shift_code.split("|");
	u_shift_codes=u_shift_code.split("|");
	o_shift_codes=o_shift_code.split("|");
	if(shift_code !=""){
		//alert("if shift_code !=--->" +shift_code);
		for(var i=0; i<p_shift_codes.length;i++){
				if(shift_code == p_shift_codes[i]){
				exist=true;
				break;
			}		
		}
		for(var i=0; i<u_shift_codes.length;i++){		
			if(shift_code == u_shift_codes[i]){
				exist=true;
				break;
			}		
		}
		for(var i=0; i<o_shift_codes.length;i++){		
			if(shift_code == o_shift_codes[i]){
				exist=true;
				break;
			}		
		}
	}
	else
		exist= true;		
	if(!exist){
		exist=false;
	}
	return exist;
}
/***********************************************************/
function getallShiftPattern(){
	
	var frmObj		=document.forms[0];
	var facility_id		=frmObj.facility_id.value;
	var workplace_code		=frmObj.workplace_code.value;
	var week_no		=frmObj.week_no.value;
	var shift_pattern_id=frmObj.shift_pattern[frmObj.shift_pattern.selectedIndex].value;
	if(shift_pattern_id !=''){
			clearAll()
			var shift_pattern_desc=frmObj.shift_pattern[frmObj.shift_pattern.selectedIndex].text;
			var xmlDoc = "" ;
			var xmlHttp = new XMLHttpRequest() ;
			xmlStr ="<root><SEARCH " ;
			xmlStr +=" /></root>" ;
			xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
			xmlHttp.open( "POST","../../eRS/jsp/MasterScheduleValidate2.jsp?facility_id="+facility_id+"&shift_pattern_id="+shift_pattern_id+"&week_no="+week_no+"&mode=all", false);
			xmlHttp.send( xmlDoc ) ;
			responseText=xmlHttp.responseText ;
			eval(responseText);
	}
}
/*******************************************************/
function assignallShift(day_no, shift_code, shift_mnemonic, shift_ind, prod_flag){
	
	var frmObj=parent.frames[1].document.forms[0];
	var day=day_no-1;
	var totalrec=parseInt(frmObj.total_records.value);
	for(var i=0;i<totalrec;i++){
		var staff_id=eval("frmObj.staff"+i).value;
		var role_type=eval("frmObj.role_type"+i).value;
		var position_code=eval("frmObj.position_code"+i).value;
		if(assignCheck(day,shift_code, shift_mnemonic, role_type,staff_id,position_code)){
			eval("frmObj.shift"+role_type+staff_id+day).value=shift_mnemonic;
			eval("frmObj.shift_code"+role_type+staff_id+day).value=shift_code;
			eval("frmObj.shift_indicator"+role_type+staff_id+day).value=shift_ind;
			eval("frmObj.productive_flag"+role_type+staff_id+day).value=prod_flag;
			onallocation(day,position_code,role_type,staff_id);
		}
	}
}
/*******************************************************/
function clearAll(){
	var frmObj=parent.frames[1].document.forms[0];
	var totalrec=parseInt(frmObj.total_records.value);
	for(var i=0;i<totalrec;i++){
		var staff_id=eval("frmObj.staff"+i).value;
		var role_type=eval("frmObj.role_type"+i).value;
		var position_code=eval("frmObj.position_code"+i).value;
				clearstaff(role_type,staff_id, position_code);
	}
}
/********************************************************/
function changeweek(){
	parent.parent.parent.f_query_add_mod.frameset_MasterSchedule.rows='4%,26%,7%,*';
	parent.parent.parent.f_query_add_mod.frameResult.location.href='../../eCommon/html/blank.html';
}
/*****************************************************************/
function changeweekall(){
	parent.parent.frameset_MasterSchedule.rows='4%,26%,7%,*';
	parent.parent.frameResult.location.href='../../eCommon/html/blank.html';
}
/*****************************************************************/
function assignResult(_result, _message, _flag){
	result = _result ;
	message  = _message ;
	flag = _flag ;
}
/*****************************************************************/
function onSuccess() {
	//parent.frames[1].frames[1].frames[3].location.href='../../eCommon/html/blank.html';
	//parent.frames[1].frames[1].frameset_MasterSchedule.rows="4%,26%,7%,*";
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
/*****************************************************************/
function checkIsValidForProceed1(){
	var url = f_query_add_mod.frameCriteria.location.href;
	
	url = url.toLowerCase();
	if ( (url.indexOf("queryresult.jsp")==-1) && (url.indexOf("query")==-1)&&(url.indexOf("blank")==-1) )
	{
		return true;
	}
	else
	{
		return false;
	}
}
/*****************************************************************/
function checkIsValidForProceed2(){
	
	var url = f_query_add_mod.frameResult.location.href;
	url = url.toLowerCase();
	if ((url.indexOf("queryresult.jsp")==-1) && (url.indexOf("query")==-1)&&(url.indexOf("blank")==-1) )
	{	if(!(url.indexOf("completeview")==-1))
		{
				
				return false;
		}
		if(url.indexOf("ResultWeekly")==-1)
			{
				return true;
			}
		return false;
	}
	else
	{
		return false;
	}
}
/*****************************************************************/
function unSelect(target){
	target.select();
}
/*****************************************************************/
function expanddetails(obj, posit_code){
	//
	if(prev_menu){
		//
		prev_menu.style.visibility="hidden";
		prev_menu.style.display='none';
	}
	var frmObj = document.forms[0];	
	
		if(eval("document.getElementById("posit")"+posit_code)){
			//
			var disprow=eval(eval("document.getElementById("posit")"+posit_code));
			var dispstatus = obj.innerText;
			//
			if(dispstatus == '+'){
					for(i=0;i<disprow.length;i++){
					
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
/************************************************************/
function showPopup(position_code,role_type, staff_id, day){
	Position_code	=	position_code;
	Role_type			=	role_type;
	Staff_id			=	staff_id;
	Day					=	day;
	
	if(!txtflag){
		var frmObj=document.forms[0];
		menu=eval("master_menu"+Position_code);
		menu.className="master_menu";
			var rightedge=document.body.clientWidth-(event.clientX+175);
			var bottomedge=document.body.clientHeight-(event.clientY +1000);
			if (rightedge<menu.offsetWidth)
				menu.style.left=document.body.scrollLeft+event.clientX-(menu.offsetWidth+175);
			else
				menu.style.left=document.body.scrollLeft+event.clientX+35;
			if (bottomedge<menu.offsetHeight)
				menu.style.top=document.body.scrollTop+event.clientY-menu.offsetHeight-50;
			else
				menu.style.top=document.body.scrollTop+event.clientY+15;

			if(prev_menu){
				prev_menu.style.visibility="hidden";
				prev_menu.style.display='none';
			}
			prev_menu=menu;
			menu.style.visibility="visible";
			menu.style.display='inline';
	}
	txtflag=false;
}
/*************************************************************/
function txtclick(){
	if(prev_menu){
		prev_menu.style.visibility="hidden";
		prev_menu.style.display='none';
	}
	txtflag=true;
	return false;
}
/***************************************************************/
function over(){
	menu.style.backgroundColor="#B44664";
	event.target.style.backgroundColor="white";
	event.target.style.color="#B44664";
}
/***************************************************************/
function out(){
	menu.style.backgroundColor="#B44664";
	event.target.style.backgroundColor="#B44664";
	event.target.style.color="white";
}
/****************************************************************/
function Un_Oncall_assign(){
	if(prev_menu){
		prev_menu.style.visibility="hidden";
		prev_menu.style.display='none';
	}
	var frmObj	=	document.forms[0];
	if(window.event.button==1){
		
		var Shift_data = null;
		//
		Shift_data = event.target.value;
		
		if(Shift_data != null){
			if(!(Shift_data == 'O' || Shift_data == 'U'|| Shift_data == 'P')){
				var Shift_mnemonic = event.target.text;
				var Shiftdata_array	=	Shift_data.split('|');
				Shift_code	=	Shiftdata_array[0];
				Shift_ind		=	Shiftdata_array[1];
				if(Shift_ind == 'P')
					Prod_flag		=	Shiftdata_array[2];
				else
				Prod_flag	='';

				var shift_id			=	eval("frmObj.shift_code"+Role_type+Staff_id+Day).value;
				var shift_mnem	=	 eval("frmObj.shift"+Role_type+Staff_id+Day).value;
				var prod_flag		=	eval("frmObj.productive_flag"+Role_type+Staff_id+Day).value;
				var shift_ind			=	eval("frmObj.shift_indicator"+Role_type+Staff_id+Day).value;
				
				eval("frmObj.shift"+Role_type+Staff_id+Day).value=Shift_mnemonic;
				eval("frmObj.shift_code"+Role_type+Staff_id+Day).value=Shift_code;
				eval("frmObj.shift_indicator"+Role_type+Staff_id+Day).value=Shift_ind;
				eval("frmObj.productive_flag"+Role_type+Staff_id+Day).value=Prod_flag;
				
				if(shift_id != '')
					shiftDelete(shift_id,shift_mnem,shift_ind, prod_flag,Position_code, Role_type,Staff_id, Day)
				shiftAllocate(Shift_code,Shift_mnemonic,Shift_ind, Prod_flag,Position_code,Role_type, Staff_id,Day)
				if((Shift_ind == 'P')&&(Prod_flag=='W'))
					changeColor(Position_code, Shift_code, Day)
			}
		}
	}
}
/******************************************************************************/
function CodeArrest1() {
    if((window.event.button == 2) || (window.event.button == 3) || (window.event.button == 4)) {
        alert("Welcome to eHIS");
    }
	if(window.event.button == 1){
		if(prev_menu){
			prev_menu.style.visibility="hidden";
			prev_menu.style.display='none';
		}
	}
}
/********************************************************************************/
