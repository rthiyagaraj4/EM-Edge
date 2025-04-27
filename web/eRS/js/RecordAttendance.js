var function_id='';
var message='';
/*****************************************************************/
function apply(){
		if (! checkIsValidForProceed() ) {
		var frmobj=frameQueryCriteria.document.form_RACriteria;
		//alert(frameQueryCriteria.document.forms[0].name);
		//alert(frmobj.name);
		var fields = new Array (frmobj.workplace_desc);
		var names=new Array(getLabel("eRS.WorkPlace.label","RS"));
		if(frameQueryCriteria.checkFields( fields, names, messageFrame))
		{
			return true ;
		}
  		//if(frameQueryCriteria.checkFieldsofMst( fields, names, messageFrame))
		//parent.frames[1].messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num=";
		return false ;
	}

	var today=new Date();
	var curr_hr=today.getHours();
	var curr_mint=today.getMinutes();
	message='';
	var frmObj=frameQueryResult.document.forms[0];
	var cnt=0,count=0;
	for(cnt=0;cnt<frmObj.totalRecords.value; cnt++){
		var max_duration = parseInt(frmObj.max_duration_in_mints.value);
		var select=eval("frmObj.select_yn"+cnt);
		var stepin_hh=eval("frmObj.stepin_hh"+cnt).value;
		var stepin_mm=eval("frmObj.stepin_mm"+cnt).value;
		var stepout_hh=eval("frmObj.stepout_hh"+cnt).value;
		var stepout_mm=eval("frmObj.stepout_mm"+cnt).value;
		var schedule_date=eval("frmObj.schedule_date"+cnt).value;
		var shift_start_time=eval("frmObj.shift_start_time"+cnt).value;
		var shift_end_time=eval("frmObj.shift_end_time"+cnt).value;
		var shift_start=shift_start_time.split(":");
		var shift_end=shift_end_time.split(":");

		if(schedule_date.length > 0 ){
			date_array = schedule_date.split("/");
			schedule_start =(new Date(date_array[2],date_array[1],date_array[0],shift_start[0],shift_start[1])).getTime();
		    schedule_end =(new Date(date_array[2],date_array[1],date_array[0],shift_end[0],shift_end[1])).getTime();
			step_in_Time	=	(new Date(date_array[2],date_array[1],date_array[0],stepin_hh,stepin_mm)).getTime();
			step_out_Time	=	(new Date(date_array[2],date_array[1],date_array[0],stepout_hh,stepout_mm)).getTime();
			}
		var stepin_diff=(step_in_Time - schedule_start)/1000/60;
			if(select.checked==true){
			if(!((stepin_hh == null)||(stepin_hh ==''))){
					if(!((stepout_hh=='')&&(stepout_mm != ''))){
					if((stepin_diff <= max_duration)&&(step_in_Time < schedule_end)&&(step_in_Time >schedule_start) ){
						
						select.value="Y";
						count++;
						
					
					}else{
							
							alert(getMessage("STEP_IN_OVERLAP","RS"))
							message  = getMessage("STEP_IN_OVERLAP","RS");
							count=0;
							break;
					}

				}else{
				message  = getMessage("STEP_OUT_CANNOT_BLANK","RS");
				count=0;
				break;
			}
		}else{
				message  = getMessage("STEP_IN_CANNOT_BLANK","RS");
				count=0;
				break;
			}
		}else{
			select.value="N"
			message=getMessage("ATLEAST_ONE_SELECTED","Common");;
		}
	}

	if(count>0)
		frmObj.submit();
	else
		messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num="+ message;
}
/*****************************************************************/
function checkIsValidForProceed(){
	var url = frameQueryResult.location.href;
	url = url.toLowerCase();
	if ( (url.indexOf("blank")==-1) )
		return true;
	else
		return false;
}
/******************************************************************/
function onSuccess() {
		var frmObj=frameQueryCriteria.document.forms[0];
		frmObj.reset();
		for(i=0;i<frmObj.elements.length;i++){
			frmObj.elements[i].disabled=false;
		}
		frameQueryResult.location.href='../../eCommon/html/blank.html';
}
/******************************************************************/
function assignResult(_result, _message, _flag){
	result = _result ;
	message  = _message ;
	flag = _flag ;
}
/******************************************************************/
function reset(){
	var url=frameQueryCriteria.location.href;
	if(url.indexOf("blank")==-1) {
		var url=frameQueryResult.location.href;
		if(url.indexOf("blank")==-1) {
				if(frameQueryResult.document.forms[0])
					frameQueryResult.document.forms[0].reset();
		}else
			frameQueryCriteria.document.forms[0].reset();
	}
	frameQueryCriteria.document.forms[0].clear.disabled=false;
}
/******************************************************************/
function onSelect(target){

	if(target.checked==true)
		target.value="Y";
	else
		target.value="N";
	return;
}
/******************************************************************/
function showWorkplace(target){
	var argumentArray  = new Array() ;
	var dataNameArray  = new Array() ;
	var dataValueArray = new Array() ;
	var dataTypeArray  = new Array() ;

	var frmObj		=parent.frameQueryCriteria.document.forms[0];
	var facility_id		=frmObj.facility_id.value;
	var locale		=frmObj.locale.value;
	if(!(frmObj.workplace_code.value=="")){
		frmObj.workplace_code.value='';
		frmObj.workplace_desc.value='';
	}
	//argumentArray[0] ="select workplace_code code, workplace_desc description from rs_workplace where facility_id='"+facility_id+"' and  upper(workplace_code) like upper(?) and upper(workplace_desc) like upper(?) and eff_status='E' order by workplace_desc";
	argumentArray[0] ="select workplace_code code, workplace_desc description from rs_workplace_lang_vw where facility_id='"+facility_id+"' and  upper(workplace_code) like upper(?) and upper(workplace_desc) like upper(?) and eff_status='E' and language_id = '"+locale+"' order by workplace_desc";

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
	listShift();
	frmObj.staff_id.value='';
	frmObj.staff_name.value='';
}
/******************************************************************/
function listShift(){ 
	//alert("inside shift");
	clearShift();
	var frmObj=parent.frameQueryCriteria.document.forms[0];
	var workplace_code=frmObj.workplace_code.value
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest() ;

	xmlStr ="<root><SEARCH " ;
	xmlStr +=" /></root>" ;
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open( "POST","../../eRS/jsp/RecordAttendanceValidate.jsp?workplace_code="+workplace_code, false ) ;
	xmlHttp.send( xmlDoc ) ;
	responseText=xmlHttp.responseText ;
	eval(responseText);
	frmObj.shift_code.selectedIndex=0;
}
/************************************************************************/
function addShift(code,value) {
	var element = document.createElement('OPTION') ;
	element.value =  code ;
	element.text = value ;
	parent.frameQueryCriteria.document.forms[0].shift_code.add(element);
}
/************************************************************************/
function clearShift( ) { 

	var len = eval("document.forms[0].shift_code.options.length") ;
	for(var i=0;i<len;i++){

		eval("document.forms[0].shift_code.remove(\"atc_class_l2_code\")") ;
	}
	var tp 		= "  ---Select---  " ;
	var opt  	= eval("document.createElement(\"OPTION\")") ;
	opt.text 	= tp ;
	eval("document.forms[0].shift_code.add(opt)") ;
}
/************************************************************************/
function listStaff(target ) { 
	
	var frmObj=parent.frameQueryCriteria.document.forms[0];
	
	var fields=new Array(frmObj.workplace_code);
	var names=new Array(getLabel("eRS.WorkPlace.label","RS"));
	var messageFrame = parent.messageFrame;

	if(checkFields(fields,names,messageFrame)){	
		var url='../../eRS/jsp/SearchStaff.jsp?mode=call';
		var dialogHeight =window.screen.height ;
		var dialogWidth = window.screen.width ;
		var dialogTop	= 0;
		var dialogLeft = 0 ;
		var features = 'dialogHeight:' + dialogHeight + '; dialogWidth:' + dialogWidth +';dialogTop:'+dialogTop+';dialogLeft:'+dialogLeft+'; scroll=no; status=no';
		var arguments = "";
		var retVals = window.showModalDialog(url,arguments,features);
		if(retVals !=null){
			target.value=retVals[0];
			frmObj.staff_name.value=retVals[1];
			frmObj.role_type.value=retVals[2];
		}
	}
}
/***********************************************************************/
function display(obj){
	
	var frmObj=parent.frameQueryCriteria.document.forms[0];
	var role_type=frmObj.role_type.value;
	if(role_type=='P')
		obj.innerText='Practitioner';
	else if(role_type=='O')
		obj.innerText='Other Staff';
}
/***********************************************************************/
function showStaff(obj){
	
	var frmObj=parent.frameQueryCriteria.document.forms[0];
	var role_type=frmObj.role_type.value;
	var facility_id		=frmObj.facility_id.value;
	var workplace_code		=frmObj.workplace_code.value;
	var role_type		=frmObj.role_type.value;
	var staff_id		=frmObj.staff_id.value;
	var shift_code		=frmObj.shift_code[frmObj.shift_code.selectedIndex].value;
	var max_duration_in_mints=frmObj.max_duration_in_mints.value;
	var fields = new Array (frmObj.workplace_code);
  	var names = new Array (getLabel("eRS.WorkplaceCode.label","RS"));
	
	
	if(parent.frameQueryCriteria.checkFields( fields, names, parent.messageFrame)) {
		parent.frameQueryResult.location.href='../../eRS/jsp/RecordAttendanceQueryResult.jsp?facility_id='+facility_id+'&workplace_code='+workplace_code+'&role_type='+role_type+'&staff_id='+staff_id+'&shift_code='+shift_code+"&max_duration_in_mints="+max_duration_in_mints;
		for(i=0;i<frmObj.elements.length;i++){
			
			frmObj.elements[i].disabled=true;
		}
	
		frmObj.clear.disabled=false;
		message="";
	}
}
/***********************************************************************/
function allowPositiveNumber() {
   var key = window.event.keyCode;
   if((key<48 )||(key>58)){
	   return false;
   }
}
/***********************************************************************/
function CheckForHours(target){
	var value = target.value;
		if(value!='')
		if(value < 0 || value >23)	{
		
			message = getMessage("STEP_IN_OUT_HOURS_0_TO_23","RS");
			parent.messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num="+ message;
			target.focus();
			target.select();
			return;
		}
		else	{
			//
			if(value < 10) {
				//
				var len = value.length;
				if(len < 2)
				{
					//
					target.value = '0' + value;
					
				}
			}
	}
}
/***********************************************************************/
function CheckForMinutes(target){
	var value = target.value;
	if(value!='')
		if(value < 0 || value >59){
			message = getMessage("STEP_IN_OUT_MINIT_0_TO_59","RS");
			parent.messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num="+ message;
			target.focus();
			target.select();
			return;
		}
		else{
			if(value < 10)	{
				var len = value.length;
				if(len < 2)
					target.value = '0' + value;
			}
	}
}
/***********************************************************************/
function clearall(){
	var frmObj=parent.frameQueryCriteria.document.forms[0];
	frmObj.reset();
	for(i=0;i<frmObj.elements.length;i++){
		frmObj.elements[i].disabled=false;
	}
	parent.frameQueryResult.location.href = "../../eCommon/html/blank.html";
	parent.messageFrame.location.href = "../../eCommon/jsp/error.jsp?";
}
/***********************************************************************/
