function create(){
	//parent.frames[1].f_query_add_mod.location.href="../../eRS/jsp/WorkPlaceRequirementFrameset.jsp?mode=1&function_id="+function_id;
	
	f_query_add_mod.location.href="../../eRS/jsp/WorkPlaceRequirementFrameset.jsp?mode=1&function_id="+function_id;
}

/********************************************************/
function apply(){

	if (! checkIsValidForProceed()) {
	//if query
		//message  = getMessage("NOT_VALID","Common");
		message  = "";
		messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ message;
		return false ;
	}
	if (!checkIsValidForProceed1()){	
		
		var frmobj=f_query_add_mod.frameWorkPlaceSearch.document.formWorkplaceReqdSearch;
		var fields = new Array (frmobj.work_text,frmobj.reqd_desc_text);
		var names = new Array (getLabel("eRS.WorkPlace.label","RS"),getLabel("eRS.RequirementDescription.label","RS"));
		if(f_query_add_mod.frameWorkPlaceSearch.checkFieldsofMst( fields, names, messageFrame))
		parent.frames[1].messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num=";
		return false;
	}
	var wflag		=	false;
	var nwflag	=	false;
	var hflag		=	false;
	var flag		=	true;
	var message	=	"";
	var obj			=	null; 
	var formObj	=	parent.frames[2].frames[1].frameWorkPlaceResult.document.form_WrkPlaceReqdResult;
	var mode=formObj.mode.value;
	var constCount=parseInt(formObj.constCount.value);
	var no_of_checked=0;

	for(cnt=0;cnt<formObj.totalRecords.value; cnt++){
		
		var val = eval("formObj.select"+cnt);
		if(val.checked == true){

			val.value='Y';
			no_of_checked++;

			wflag		=	false;
			nwflag	=	false;
			hflag		=	false;
			flag		=	true;

			var wday_min		=	parseInt(eval("formObj.wday_min"+cnt).value);
			var wday_opt		=	parseInt(eval("formObj.wday_opt"+cnt).value);
			var wday_max	=	parseInt(eval("formObj.wday_max"+cnt).value);
			var nwday_min	=	parseInt(eval("formObj.nwday_min"+cnt).value);
			var nwday_opt	=	parseInt(eval("formObj.nwday_opt"+cnt).value);
			var nwday_max	=	parseInt(eval("formObj.nwday_max"+cnt).value);
			var hday_min		=	parseInt(eval("formObj.hday_min"+cnt).value);
			var hday_opt		=	parseInt(eval("formObj.hday_opt"+cnt).value);
			var hday_max		=	parseInt(eval("formObj.hday_max"+cnt).value);

			if(!((wday_min == 0)&&(wday_opt == 0)&&(wday_max == 0))){
				wflag=true;
			}
			if(!((nwday_min == 0)&&(nwday_opt == 0)&&(nwday_max == 0))){
				nwflag=true;
			}
			if(!((hday_min == 0)&&(hday_opt == 0)&&(hday_max == 0))){
				hflag=true;
			}

			if(wflag){
				message=getMessage("ALL_GREATER_ZERO","RS");
				if(wday_min ==0){
					//eval("formObj.wday_min"+cnt).select();
					obj	=	eval("formObj.wday_min"+cnt);
					flag	=	false;
					break;
				}
				if(wday_opt ==0){
					//eval("formObj.wday_opt"+cnt).select();
					obj	=	eval("formObj.wday_opt"+cnt);
					flag	=	false;
					break;
				}
				if(wday_max ==0){
					//eval("formObj.wday_max"+cnt).select();
					obj	=	eval("formObj.wday_max"+cnt);
					flag	=	false;
					break;
				}
			}

			if(nwflag){
				message=getMessage("ALL_GREATER_ZERO","RS");
				if(nwday_min ==0){
					//eval("formObj.nwday_min"+cnt).select();
					obj	=	eval("formObj.nwday_min"+cnt);
					flag	=	false;
					break;
				}
				if(nwday_opt ==0){
					//eval("formObj.nwday_opt"+cnt).select();
					obj	=	eval("formObj.nwday_opt"+cnt);
					flag	=	false;
					break;
				}
				if(nwday_max	 ==0){
					//eval("formObj.nwday_max"+cnt).select();
					obj	=	eval("formObj.nwday_max"+cnt);
					flag	=	false;
					break;
				}
			}

			if(hflag){
				message=getMessage("ALL_GREATER_ZERO","RS");
				if(hday_min ==0){
					//eval("formObj.hday_min"+cnt).select();
					obj	=	eval("formObj.hday_min"+cnt);
					flag	=	false;
					break;
				}
				if(hday_opt ==0){
					//eval("formObj.wday_opt"+cnt).select();
					obj	=	eval("formObj.hday_opt"+cnt);
					flag	=	false;
					break;
				}
				if(hday_max ==0){
					//eval("formObj.wday_max"+cnt).select();
					obj	=	eval("formObj.hday_max"+cnt);
					flag	=	false;
					break;
				}
			}
			if((wflag == false)&&(nwflag == false)&&(hflag == false)){
				obj	=	eval("formObj.wday_min"+cnt);
				message=getMessage("ATLESAST_ONE_SET_GREATER_ZERO","RS");
				break;
			}
		}
	}
	
	if(parseInt(no_of_checked) == 0){
		var err = getMessage("ATLEAST_ONE_SELECTED","Common");
		parent.frames[2].messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+err;
		return false;
	}
	if(obj == null){
		parent.frames[2].messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+"";
		formObj.submit();
		f_query_add_mod.location.href="../../eRS/jsp/WorkPlaceRequirementFrameset.jsp?mode=1&function_id="+function_id;
	}
	/*else{

		obj.select();
		obj.focus();
		parent.frames[2].messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+message;
		return false;
	}*/
}

/********************************************************/
function query() {
	f_query_add_mod.location.href="../../eRS/jsp/WorkPlaceRequirementQueryCriteria.jsp?function_id="+function_id;
}

/********************************************************/
function reset(){
	if ( !checkIsValidForProceed() ) {
	if(f_query_add_mod.document.forms[0])
	f_query_add_mod.document.forms[0].reset();
	}
	if ( checkIsValidForProceed() ) {
		//var frmObj=parent.frames[1].f_query_add_mod.frameWorkPlaceSearch.document.forms[0];
		var frmObj=f_query_add_mod.frameWorkPlaceSearch.document.forms[0];
		frmObj.reset();
		var i=0;
		while(frmObj.elements(i)){
			frmObj.elements(i++).disabled=false;
		}
		frmObj.frm_date_img.disabled=false;
		frmObj.to_date_img.disabled=false;
		frmObj.elements(0).focus();

	//	parent.frames[1].frames[1].framesetWorkplaceReq.rows="100%,0,0";
	//	parent.frames[1].f_query_add_mod.frameWorkPlaceHdr.location.href ='../../eCommon/html/blank.html'
	//	parent.frames[1].f_query_add_mod.frameWorkPlaceResult.location.href ='../../eCommon/html/blank.html'
	   f_query_add_mod.frameWorkPlaceHdr.location.href ='../../eCommon/html/blank.html';
	   f_query_add_mod.frameWorkPlaceResult.location.href ='../../eCommon/html/blank.html'
	}
}

/********************************************************/
function checkIsValidForProceed(){
		 var url = f_query_add_mod.location.href;
		url = url.toLowerCase();
		if ( (url.indexOf("queryresult.jsp")==-1) && (url.indexOf("query")==-1)&&(url.indexOf("blank")==-1) )
				return true;
		else
				return false;
}
function checkIsValidForProceed1()
{		
	
	var url = f_query_add_mod.frameWorkPlaceHdr.location.href;
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
/********************************************************/
function showWrkplace(call_mode, target){

	var argumentArray  = new Array() ;
	var dataNameArray  = new Array() ;
	var dataValueArray = new Array() ;
	var dataTypeArray  = new Array() ;
	var frmObj=document.forms[0];
		
	var work_text = frmObj.work_text.value;
	if((call_mode =='T')&&(work_text =='')){
		frmObj.wrk_code.value='';
		return false;
	}

	var locn_type = frmObj.locn[frmObj.locn.selectedIndex].value;
	var facility_id=frmObj.facility_id.value;
	var user_id=frmObj.user_id.value;
	if(frmObj.wrk_code.value !=''){
		frmObj.wrk_code.value='';
		frmObj.work_text.value='';
	}
	//alert(user_id);
	
	
	var sql_workplace_lookup = "select workplace_code code, workplace_desc description from rs_workplace_access_vw where facility_id='"+facility_id+"' and appl_user_id='"+user_id+"' and  ('"+locn_type+"'is null or locn_type ='"+locn_type+"') and  upper(workplace_code) like upper(?) and upper(workplace_desc) like upper(?)  and eff_status='E' and allocate_yn='Y' order by workplace_desc";
	//alert(sql_workplace_lookup);
	argumentArray[0] = sql_workplace_lookup;
	argumentArray[1] = dataNameArray ;
	argumentArray[2] = dataValueArray ;
	argumentArray[3] = dataTypeArray ;
	argumentArray[4] = "1,2";
	argumentArray[5] = target.value;
	argumentArray[6] = CODE_LINK ;//CODE_LINK
	argumentArray[7] = CODE_DESC ;//CODE_DESC

	retVal = CommonLookup(getLabel("eRS.FindWorkplace.label","RS"),argumentArray);
	if(retVal != null && retVal != "" ){
		frmObj.wrk_code.value = retVal[0];
		target.value = retVal[1];
	}
}
/********************************************************/
function addConstCount(count){
	var frmObj			=parent.frameWorkPlaceSearch.document.formWorkplaceReqdSearch;
	frmObj.constCount.value=count;
}

/********************************************************/
function AllowDateFormat(){
   var key = window.event.keyCode;
   if( ! ( (( key>=48 ) && ( key<58 ) ) || (key == 47)) ) {
       return false;
   }
}

/********************************************************/
function checkDateRange(obj,from){

	var fromDate = eval("document."+from+".frm_date")
	var toDate = eval("document."+from+".to_date")

	 //  this method is from ValidateControl.js
		if(doDateCheck(fromDate,toDate) == 1) { 
			alert(getMessage("TO_DT_GR_EQ_FM_DT","RS")); // this message available in messages.js of ecommon/js
			obj.focus()
			return false
	}
}
/********************************************************/

/**
Check Date and give app return 's
if from = to returns 0
if from > to returns 1
if from < to returns -1
*/
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
			 return  0 ;
   }
} //End of function
/********************************************************/
function showDetails(){

	var frmObj=document.forms[0];
	var locale=frmObj.locale.value;
	var wrkPlace		= frmObj.work_text;
	var reqd_desc_text	= frmObj.reqd_desc_text;
	var fields=new Array(wrkPlace,reqd_desc_text);
	var names=new Array(getLabel("eRS.Workplace.label","RS"),getLabel("eRS.RequirementDescription.label","RS"));
	var messageFrame = parent.parent.frames[2];
	
	if(checkFieldsofMst(fields,names,messageFrame)){
		var facility_id		= frmObj.facility_id.value;
		var wrkplace_code	= frmObj.wrk_code.value;
		var reqd_id			= frmObj.reqd_id.value;
		var frm_dt			= convertDate(frmObj.frm_date.value,'DMY',locale,"en");
		var to_dt			= convertDate(frmObj.to_date.value,'DMY',locale,"en");
		var reqd_desc		= frmObj.reqd_desc_text.value;
		var mode			= frmObj.mode.value;
		var fr=0;
		var to=0;
		var flag=true;
		
		if(frm_dt != '')
			fr=1;
		if(to_dt  != '')
			to=1;
		if(fr ^ to)
			flag=false;
		/*if(to_dt == '')
		{
			//alert(getMessage("TO_DATE_NOT_BLANK","RS"));
			var err = getMessage("TO_DATE_NOT_BLANK","RS");
			parent.parent.messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+err;
		}*/
		if(flag){
			
			var xmlDoc = "" ;
			var xmlHttp = new XMLHttpRequest() ;

			xmlStr ="<root><SEARCH " ;
			xmlStr +=" /></root>" ;
			xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
			xmlHttp.open( "POST", "../../eRS/jsp/WorkPlaceRequirementValidate.jsp?work_code="+wrkplace_code+"&facility_id="+facility_id+"&frm_dt="+frm_dt+"&to_dt="+to_dt+"&flag=count", false );
			xmlHttp.send( xmlDoc ) ;
			
			responseText=xmlHttp.responseText ;
			//alert("showDetails--------->");

			//eval(responseText);

			//alert(responseText);
			
			//alert("showDetails--------->");
			var count=parseInt(frmObj.constCount.value);
			if(count >0){
				
				var err='';
				if(frm_dt == '')
					err = getMessage("CONST_REQUIREMENT_EXIST","RS");
				else
					err = getMessage("REQUIREMENT_EXIST","RS");

				parent.parent.messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+err;
				return false;
			}
			else{
				
				//parent.framesetWorkplaceReq.rows="25%,9%,*";
				parent.parent.messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+"";
				parent.frameWorkPlaceHdr.location.href="../../eRS/jsp/WorkplaceRequirementHdr.jsp?mode="+mode;
				parent.frameWorkPlaceResult.location.href="../../eRS/jsp/WorkplaceRequirementResult.jsp?facility_id="+facility_id+"&wrkplace_code="+wrkplace_code+"&reqd_id="+reqd_id+"&mode="+mode+"&frm_dt="+frm_dt+"&to_dt="+to_dt+"&reqd_desc="+reqd_desc;
				var i=0;
				while(document.formWorkplaceReqdSearch.elements(i)!=null){
					frmObj.elements(i).disabled=true;
					i++;
				}
				frmObj.frm_date_img.disabled=true;
				frmObj.to_date_img.disabled=true;
			}
		}	else{
				var err = getMessage("FROM_TO_BLANK_NOT","RS");
				parent.parent.messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+err;
				return false;
		}
	}
}

/********************************************************/
function click_select(){
	if(document.form_WrkPlaceStaffHdr.chk_all.checked == true){
		for(cnt=0;cnt<parent.frameWorkPlaceResult.document.form_WrkPlaceReqdResult.totalRecords.value; cnt++){
			val = eval("parent.frameWorkPlaceResult.document.form_WrkPlaceReqdResult.select"+cnt);
			val.checked = true;
		}
	}else{
		for(cnt=0; cnt<parent.frameWorkPlaceResult.document.form_WrkPlaceReqdResult.totalRecords.value; cnt++){
			val = eval("parent.frameWorkPlaceResult.document.form_WrkPlaceReqdResult.select"+cnt);
			val.checked = false;
		}
	}
}

/********************************************************/
function displayReqdDetls(wrk_code,facility_id,reqd_id){
	var mode="edit";
	parent.frame_qryResulutHdr.location.href="../../eRS/jsp/WorkplaceRequirementHdr.jsp?mode="+mode;
	parent.frame_qryResultbottom.location.href="../../eRS/jsp/WorkplaceRequirementResult.jsp?facility_id="+facility_id+"&wrkplace_code="+wrk_code+"&reqd_id="+reqd_id+"&mode="+mode;
}

/********************************************************/
function NumberFormat(){
   var key = window.event.keyCode;
   if( ! ( (( key>=48 ) && ( key<58 ) ) ) ) {
       return false;
   }
}

/********************************************************/
function checkDateRange(obj,from){
	var fromDate=from;
	var toDate=obj;
		if(doDateCheck(fromDate,toDate) == 1) { 
			alert(getMessage("TO_DATE_GR_FR_DATE","RS")); 
			obj.focus()
				obj.select();
			return false
	}
			
}

/********************************************************/
function checkFromDate(from,today,to_date){
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
			var invaldt =parent.getMessage("FROM_DATE_LESS_SYSDATE","RS") ; 
			alert(invaldt);
			from.select();
			from.focus();
		}

	}
	
	if(to_date.value != ''){
		if(doDateCheck(from,to_date) == 1) { 
			alert(getMessage("TO_DATE_GR_FR_DATE","RS")); 
			to_date.focus()
			to_date.select();
			return false

		}
		
	}
	
}
/********************************************************/
function checkForNull(obj){
	if((obj.value=='')||(obj.value==null))
		obj.value='0';
}
/********************************************************/
function showCal(obj, obj_id){
	showCalendar(obj_id);
}
/**************************************************************/

