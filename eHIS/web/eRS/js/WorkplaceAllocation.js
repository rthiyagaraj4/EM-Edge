/*************************************************************************************/
/*************** common look up for workplace returns code n desc********************/
/************************************************************************************/

function viewWorkPlace(target){
	var argumentArray  = new Array() ;
	var dataNameArray  = new Array() ;
	var dataValueArray = new Array() ;
	var dataTypeArray  = new Array() ;
   	var frmObj=parent.frameWorkPlaceAllocCriteria.document.formWorkplaceAllocCriteria;
 	var locn_type=frmObj.locn_type.value;
	var facility_id=frmObj.facility.value;
	var locale=frmObj.locale.value;
	//alert("locale----->"+locale);
	//argumentArray[0] ="SELECT workplace_code code, workplace_desc description FROM rs_workplace WHERE eff_status = 'E'  and facility_id='"+facility_id+"'  AND ('"+locn_type+"' is null or locn_type='"+locn_type+"')AND UPPER(workplace_code) LIKE UPPER(?) AND UPPER(workplace_desc) LIKE UPPER(?) ORDER BY workplace_desc";
	argumentArray[0] ="SELECT workplace_code code, workplace_desc description FROM rs_workplace_lang_vw a WHERE eff_status = 'E'  and facility_id='"+facility_id+"'  AND ('"+locn_type+"' is null or locn_type='"+locn_type+"')AND UPPER(workplace_code) LIKE UPPER(?) AND UPPER(workplace_desc) LIKE UPPER(?) and a.language_id = '"+locale+"' ORDER BY workplace_desc";

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
	}
/******************************************************************************************************/
function clearList( ) 
	{
		var len = eval("document.formWorkplaceAllocCriteria.view_opt.options.length") ;
		for(var i=0;i<len;i++)
		{
			eval("document.formWorkplaceAllocCriteria.view_opt.remove(\"atc_class_l2_code\")") ;
		}
		var tp 		= "  ---Select---  " ;
		var opt  	= eval("document.createElement(\"OPTION\")") ;
		opt.text 	= tp ;
		eval("document.formWorkplaceAllocCriteria.view_opt.add(opt)") ;
}

/******************************************************************************************************/
function resetVal( )
{
	document.formWorkplaceAllocCriteria.locn_type.selectedIndex=0;
	document.formWorkplaceAllocCriteria.work_text.value="";
}


/******************************************************************************************************/
function populateViewOption()
{
	
   	var frmObj=parent.frameWorkPlaceAllocCriteria.document.formWorkplaceAllocCriteria;
	var group_by=frmObj.group_by.value;
	
	if(group_by=='W')
	{

		var element1 = document.createElement('OPTION');
		element1.value ="PD";
		element1.text ="Position, Day";
		parent.frameWorkPlaceAllocCriteria.document.formWorkplaceAllocCriteria.view_opt.add(element1);
		var element2 = document.createElement('OPTION');
		element2.value ="SD";
		element2.text ="Shift, Day";
		parent.frameWorkPlaceAllocCriteria.document.formWorkplaceAllocCriteria.view_opt.add(element2);
		var element3 = document.createElement('OPTION');
		element3.value ="SPD";
		element3.text ="Shift, Position, Day";
		parent.frameWorkPlaceAllocCriteria.document.formWorkplaceAllocCriteria.view_opt.add(element3);
		var element4 = document.createElement('OPTION');
		element4.value ="PSD";
		element4.text ="Position, Shift, Day";
		parent.frameWorkPlaceAllocCriteria.document.formWorkplaceAllocCriteria.view_opt.add(element4);

	}
	else if(group_by=='P')
	{
		var element1 = document.createElement('OPTION');
		element1.value ="WD";
		element1.text ="Workplace, Day";
		parent.frameWorkPlaceAllocCriteria.document.formWorkplaceAllocCriteria.view_opt.add(element1);

		var element2 = document.createElement('OPTION');
		element2.value ="SD";
		element2.text ="Shift, Day";
		parent.frameWorkPlaceAllocCriteria.document.formWorkplaceAllocCriteria.view_opt.add(element2);

		var element3 = document.createElement('OPTION');
		element3.value ="SWD";
		element3.text ="Shift, Workplace, Day";
		parent.frameWorkPlaceAllocCriteria.document.formWorkplaceAllocCriteria.view_opt.add(element3);

		var element4 = document.createElement('OPTION');
		element4.value ="WSD";
		element4.text ="Workplace, Shift, Day";
		parent.frameWorkPlaceAllocCriteria.document.formWorkplaceAllocCriteria.view_opt.add(element4);
	}

}

/*******************************************************************************/

function mandatory(){

   	var frmObj=parent.frameWorkPlaceAllocCriteria.document.formWorkplaceAllocCriteria;
	var fields = new Array (frmObj.facility,frmObj.frm_dt,frmObj.to_dt);
	var names = new Array (getLabel("Common.facility.label","Common"),getLabel("Common.fromdate.label","Common"),getLabel("Common.todate.label","Common"));
	var	msgFrame=parent.parent.messageFrame;
	if(parent.frameWorkPlaceAllocCriteria.checkMandFields(fields,names, msgFrame)) {
	   return true;
	}
	else
	  return false;
}

/****************************************************************************************/

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
	messageFrame.document.location.href="../../eCommon/jsp/error.jsp?err_num="+errors ;

	return true ;
}

/***********************************************************************************************/
/********************* Date Validations Starts ************************************************/
/**********************************************************************************************/

function AllowDateFormat(){
   var key = window.event.keyCode;
   if( ! ( (( key>=48 ) && ( key<58 ) ) || (key == 47)) ) {
       return false;
   }

}

/****************************************************************************/
function checkSysFromDateRange(obj,from){

	var frmDate = eval("document."+from+".frm_dt")
	var sys_dt=new Date();
	var m=sys_dt.getMonth()+1;
	var y=sys_dt.getYear();
	var d=sys_dt.getDate();
	var sysDate=(d+"/"+m+"/"+y);
	parent.frameCanWrkSchCriteria.document.formCanWrkSchCriteria.sysdate.value=sysDate;
	var systdate = eval("document."+from+".sysdate");
	 //  this method is from ValidateControl.js
	
		if(doDateCheck(systdate,frmDate) == 1) { 
			alert("From Date shold be greater than Current Date"); // this message available in messages.js of ecommon/js
			var frmObj=parent.frameWorkPlaceAllocCriteria.document.formWorkplaceAllocCriteria.to_dt;
			frmObj.value="";
			frmObj.focus();
			return false

	}
}
/****************************************************************************/

/**
Check Date and give app return 's
if from = to returns 0
if from > to returns 1
if from < to returns -1
*/
function doDateCheck1(from,to) {
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
			 return  0 ;
   }

} 

/*******************************************************************************/
function SearchDetails(){
	
  if(mandatory())
  { 
			var frmObj=parent.frameWorkPlaceAllocCriteria.document.formWorkplaceAllocCriteria;
			var facility_id=frmObj.facility.value;
			var locale=frmObj.locale.value
			var locn_type=frmObj.locn_type.value;
			var workplace_code=frmObj.wrk_code.value;
			var group_by=frmObj.group_by.value;
			var view_opt=frmObj.view_opt.value;
			var frm_dt=convertDate(frmObj.frm_dt.value,'DMY',locale,"en");
			var to_dt=convertDate(frmObj.to_dt.value,'DMY',locale,"en");
			var new_todate1=convertDate(frmObj.to_dt.value,'DMY',locale,"en");
			var next_fromdate=convertDate(frmObj.frm_dt.value,'DMY',locale,"en");
			//alert("SearchDetails------>");
			if(group_by=='W')
			{
				//alert("hello1");
				if(view_opt=="")
				{
					//alert("Searchdetails111---->");
					var result_jsp="../../eRS/jsp/WorkplaceAllocationResult1.jsp";
					//alert("Searchdetails222---->");
				}
				else if(view_opt=='PD')
				{
					var result_jsp="../../eRS/jsp/WorkplaceAllocationResult2.jsp";
				}
				else if(view_opt=='SD')
				{
					var result_jsp="../../eRS/jsp/WorkplaceAllocationResult3.jsp";
				}
				else if(view_opt=='SPD')
				{
					var result_jsp="../../eRS/jsp/WorkplaceAllocationResult4.jsp";
				}
				else if(view_opt=='PSD')
				{
					var result_jsp="../../eRS/jsp/WorkplaceAllocationResult5.jsp";
				}
			}
			else
			{
				//alert("hello2");
				//alert("view_opt-->"+view_opt);
				if(view_opt=="")
				{
					var result_jsp="../../eRS/jsp/WorkplaceAllocationResult6.jsp";
				}
				else if(view_opt=='WD')
				{
					//alert("hello4");
					var result_jsp="../../eRS/jsp/WorkplaceAllocationResult7.jsp";
					//alert("hello5");
				}
				else if(view_opt=='SD')
				{
					var result_jsp="../../eRS/jsp/WorkplaceAllocationResult8.jsp";
				
				}
				else if(view_opt=='SWD')
				{
					
					var result_jsp="../../eRS/jsp/WorkplaceAllocationResult9.jsp";
				
				}
				else if(view_opt=='WSD')
				{
				var result_jsp="../../eRS/jsp/WorkplaceAllocationResult10.jsp";
					
				}

			}
	//alert("hello10");
		parent.frameWorkPlaceAllocHdr.location.href="../../eRS/jsp/WorkplaceAllocationResultFrameset.jsp?result_jsp="+result_jsp+"&facility_id="+facility_id+"&locn_type="+locn_type+"&workplace_code="+workplace_code+"&group_by="+group_by+"&view_opt="+view_opt+"&from_date="+frm_dt+"&to_date="+to_dt+"&new_todate="+new_todate1+"&next_fromdate="+next_fromdate+"&onclick_of=S" ;

	//alert("hello10");
  }//end if mandatory()
	else 
	{
	return false;
	}
}

/**********************************************************************/
function checkDateRange(obj,from){

	var fromDate = eval("document."+from+".frm_dt")
	var toDate = eval("document."+from+".to_dt")
	
	//  this method is from ValidateControl.js

		if(doDateCheck1(fromDate,toDate) == 1) { 
			message=getMessage("FROM_DATE_GREATER_TO_DATE","RS");
			alert(message); // this message available in messages.js of ecommon/js
			var frmObj=parent.frameWorkPlaceAllocCriteria.document.formWorkplaceAllocCriteria.to_dt;
			frmObj.value="";
			frmObj.focus();
			return false

	}
}
/****************************************************************************/
function checkDateRange1(obj,from){

	var fromDate = eval("document."+from+".frm_dt")
	var toDate = eval("document."+from+".to_dt")
	
	//  this method is from ValidateControl.js

		if(doDateCheck1(fromDate,toDate) == 1) { 
			message=getMessage("FROM_DATE_GREATER_TO_DATE","RS");
			alert(message); // this message available in messages.js of ecommon/js
			var frmObj=parent.frameWorkPlaceAllocCriteria.document.formWorkplaceAllocCriteria.frm_dt;
			frmObj.value="";
			frmObj.focus();
			return false
	}
}

/***********************************************************************************************/

function reset(){
	f_query_add_mod.frames[0].document.forms[0].reset() ;	
	f_query_add_mod.frames[1].location.href='../../eCommon/html/blank.html';
	f_query_add_mod.frames[2].location.href='../../eCommon/html/blank.html';
}
/****************************************************************************/

function moveForward()
{
		var next_from_date=parent.frames[0].document.forms[0].p_from_date.value;
		var next_to_date=parent.frames[0].document.forms[0].p_to_date.value;
		var onclick_of=parent.frames[0].document.forms[0].p_next_direction.value;
		var p_end=parent.frames[0].document.forms[0].p_end.value;
		var  result_jsp=parent.frames[0].document.forms[0].result_jsp.value;
		if(p_end=='E'){
			alert(getMessage("REACHED_END","RS"));
			}
		else
		{
				var facility_id=parent.parent.frames[0].document.forms[0].facility.value;
				var locn_type=parent.parent.frames[0].document.forms[0].locn_type.value;
				var workplace_code=parent.parent.frames[0].document.forms[0].wrk_code.value;
				var group_by=parent.parent.frames[0].document.forms[0].group_by.value;
				var view_opt=parent.parent.frames[0].document.forms[0].view_opt.value;
				var  from_date=parent.parent.frames[0].document.forms[0].frm_dt.value;
				var  to_date=parent.parent.frames[0].document.forms[0].to_dt.value;
				var  result_jsp=parent.frames[0].document.forms[0].result_jsp.value;
				//alert("result_jsp"+result_jsp);
				if((to_date == next_to_date)&&(from_date == next_from_date)){
					//message=getMessage("REACHED_END","RS");
					alert(getMessage("REACHED_END","RS"));
				}
				else
					parent.frames[1].location.href=result_jsp+"?facility_id="+facility_id+"&locn_type="+locn_type+"&workplace_code="+workplace_code+"&group_by="+group_by+"&view_opt="+view_opt+"&from_date="+from_date+"&to_date="+to_date+"&onclick_of="+onclick_of+"&new_todate="+next_to_date+"&next_fromdate="+next_from_date ;

		}
}

/***********************************************************************************************/

function moveBack()
{
		var next_from_date=parent.frames[0].document.forms[0].p_from_date.value;
		var next_to_date=parent.frames[0].document.forms[0].p_to_date.value;
		var onclick_of=parent.frames[0].document.forms[0].p_prev_direction.value;
		var p_end=parent.frames[0].document.forms[0].p_end.value;
		var  result_jsp=parent.frames[0].document.forms[0].result_jsp.value;
		if(p_end=='B')
		{
			//message=getMessage("REACHED_BEGIN","RS");
			alert(getMessage("REACHED_BEGIN","RS"));
		}
		else
		{
			var facility_id=parent.parent.frames[0].document.forms[0].facility.value;
			var locn_type=parent.parent.frames[0].document.forms[0].locn_type.value;
			var workplace_code=parent.parent.frames[0].document.forms[0].wrk_code.value;
			var group_by=parent.parent.frames[0].document.forms[0].group_by.value;
			var view_opt=parent.parent.frames[0].document.forms[0].view_opt.value;
			var  from_date=parent.parent.frames[0].document.forms[0].frm_dt.value;
			var  to_date=parent.parent.frames[0].document.forms[0].to_dt.value;
			var  result_jsp=parent.frames[0].document.forms[0].result_jsp.value;

			if((to_date == next_to_date)&&(from_date == next_from_date)){
				//message=getMessage("REACHED_BEGIN","RS");
				alert(getMessage("REACHED_BEGIN","RS"));
			}
			else
				parent.frames[1].location.href=result_jsp+"?facility_id="+facility_id+"&locn_type="+locn_type+"&workplace_code="+workplace_code+"&group_by="+group_by+"&view_opt="+view_opt+"&from_date="+from_date+"&to_date="+to_date+"&onclick_of="+onclick_of+"&new_todate="+next_to_date+"&next_fromdate="+next_from_date ;
		}
}
/*****************************************/
function showCal(obj, obj_id,obj1,obj2){
	showCalendar(obj_id,obj1,obj2);
	obj.focus();
}
