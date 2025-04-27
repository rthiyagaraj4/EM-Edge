var function_id;
var var_Month;
var end_date;
var c;

/********************************************************/
function reset(){
	f_query_view.frames[0].document.forms[0].reset() ;	
	
	f_query_view.frames[0].document.forms[0].workplace_name.value='';
	f_query_view.frames[1].location.href='../../eCommon/html/blank.html';
	f_query_view.frames[2].location.href='../../eCommon/html/blank.html';
}
/********************************************************/
/*function showdetails(){
	var formObj=parent.frames[0].document.forms[0];
	var staff_id=formObj.staff_id.value;
	var role_type=formObj.role_type[formObj.role_type.selectedIndex].value;
	var mode=formObj.mode.value;
	var function_id=formObj.function_id.value;
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest() ;
	
	if((staff_id=="")||(role_type==""))	{
		message=getRsMessage("NOT_BLANK");
		parent.parent.messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num="+message;
		return false;
	}
	else
	{
		xmlStr ="<root><SEARCH " ;
		xmlStr +=" /></root>" ;
		xmlDoc.loadXML(xmlStr ) ;
		xmlHttp.open( "POST","../../eRS/jsp/StaffDetails.jsp?mode="+mode+"&function_id="+function_id+"&role_type="+role_type+"&staff_id="+staff_id, false ) ;
		xmlHttp.send(xmlDoc ) ;
		responseText=xmlHttp.responseText ;
		eval(responseText);
	}
}*/
/**************************************************************/

function showstaffprofile(role_type,staff_id){
	if(role_type=="P")
		var url     = "../../eAM/jsp/ViewPractitionerDtls.jsp?practitioner_id="+staff_id+"&fcall=call";
	else if(role_type=="O")
		var url     = "../../eAM/jsp/OtherStaffDtlsView.jsp?other_staff_id="+staff_id+"&fcall=call";
    var dialogHeight    = "28" ;
    var dialogWidth = "50" ;
	var dialogTop	= '120';
	var dialogLeft = '5' ;
    var arguments   = "" ;
    var features    = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +";dialogTop:"+dialogTop+";dialogLeft:"+dialogLeft+"; scroll=no; status=no;";
    var reportURL   = window.showModalDialog( url, arguments, features ) ;
}

/*****************************************************************/
function getdate()
{
	
	var formObj=parent.frames[0].document.forms[0];
	var from_date=formObj.from_date.value;
	var to_date=formObj.to_date.value;
	//formObj.to_date.readonly=true;
	//formObj.from_date.readonly=true;
	if(to_date !='' && from_date!=''){
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest() ;
	xmlStr ="<root><SEARCH from_date=\""+from_date+"\" to_date=\""+to_date+"\"  steps='1' /></root>"
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml")
	xmlHttp.open("POST","../../eRS/jsp/StaffRosterDateValidation.jsp",false)
	xmlHttp.send(xmlDoc)
	responseText=xmlHttp.responseText
	responseText = trimString(responseText)
	
	eval(responseText) 
	}

}
/******************************************************************/
function WorkplaceDetails(){
	parent.frames[2].location.href="../../eCommon/html/blank.html";
	var formObj=parent.frames[0].document.forms[0];
	//var staff_id=formObj.workplace_name.value;
	var workplace_code=formObj.workplace_code.value;
	var locale=formObj.locale.value;
	var mode=formObj.mode.value;
	var function_id=formObj.function_id.value;
	var from_date=convertDate(formObj.from_date.value,'DMY',locale,"en");
	var to_date=convertDate(formObj.to_date.value,'DMY',locale,"en");
	var fields = new Array(formObj.workplace_Id,formObj.from_date,formObj.to_date);
	var names = new Array(getLabel("eRS.WorkplaceID.label","RS"),getLabel("Common.fromdate.label","Common"),getLabel("Common.todate.label","Common"));
	
	if(parent.parent.frames[1].checkFields(fields, names, parent.parent.messageFrame))
	{
	
var error='';

parent.parent.frames[2].location.href="../../eCommon/jsp/error.jsp?err_num="+error;
parent.frames[1].location.href="../../eCommon/html/blank.html";
var new_todate1=convertDate(parent.frames[0].document.forms[0].to_date.value,'DMY',locale,"en");
var next_fromdate=convertDate(parent.frames[0].document.forms[0].from_date.value,'DMY',locale,"en");
	parent.f_query_details.location.href="../../eRS/jsp/WorkplaceRosterResultFrameset.jsp?workplace_code="+workplace_code+"&mode="+mode+"&function_id="+function_id+"&from_date="+from_date+"&to_date="+to_date+"&new_todate="+new_todate1+"&next_fromdate="+next_fromdate+"&onclick_of=S" ;


	}
	else
	{
		return false;
	}
}

/***************************************************************/
/*function clearStaffType( ) {	
	var len = eval("document.forms[0].staff_type.options.length") ;	
	for(var i=0;i<len;i++)	{
		eval("document.forms[0].staff_type.remove(\"atc_class_l2_code\")") ;
	}
	var tp 		= "  ---Select---  " ;
	var opt  	= eval("document.createElement(\"OPTION\")") ;
	opt.text 	= tp ;
	eval("document.forms[0].staff_type.add(opt)") ;
}*/
/***************************************************************/
function close_remark(){
	window.close();
}
/****************************************/

function viewWorkplace(target, name,role)
{
	var frmObj		=parent.frames[0].document.forms[0];
	var p_role_type="";
	var p_staff_type="";
	 url='../../eRS/jsp/SearchStaff.jsp?p_role_type='+p_role_type+'&p_staff_type='+p_staff_type+'&mode=call';
	var dialogHeight ='40' ;
	var dialogWidth = '50' ;
	var dialogTop	= '120';
	var dialogLeft = '5' ;
	var features = 'dialogHeight:' + dialogHeight + '; dialogWidth:' + dialogWidth +';dialogTop:'+dialogTop+';dialogLeft:'+dialogLeft+'; scroll=no; status=no';
	var arguments = "";
	var retVals = window.showModalDialog(url,arguments,features);
	if(retVals !=null){
		target.value=retVals[1];
		name.value=retVals[0];
		if(retVals[2]=="P") p_role_type="Practitioner";
		else p_role_type="Other Staff";
		role.innerText=" "+p_role_type;
		frmObj.role_type.value=retVals[2];
	
	}
}
/*****************************************************************/
function validate(ref)
{

		if(ref == "FROM_DATE_LESS_SYSDATE" )
		{
			from = document.WorkplaceRosterCriteriaform.from_date;
			to = document.WorkplaceRosterCriteriaform.sys_date;
		}
		else 
		{
			from = document.WorkplaceRosterCriteriaform.to_date;
			to = document.WorkplaceRosterCriteriaform.from_date;
		}

	var fromarray;
	var toarray;
	var fromdate = from.value ;
	var todate = to.value ;
	if(fromdate.length > 0 && todate.length > 0 ) 
	{
		fromarray = fromdate.split("/");
		toarray = todate.split("/");
		var fromdt = new Date(fromarray[2],fromarray[1],fromarray[0]);
		var todt = new Date(toarray[2],toarray[1],toarray[0]);
		if(Date.parse(todt) > Date.parse(fromdt)) 
		{
			
		var invaldt = parent.frames[0].getMessage(ref) ; 
		alert(invaldt);
		from.value="";
		from.focus();
		}
		else if(ref == "FROM_DATE_LESS_SYSDATE" ){
		from = document.forms[0].from_date;
		to   = document.forms[0].to_date;
		if (to.value!="")
		{
		fromarray  = from.value.split("/");
		toarray    = to.value.split("/");
		var fromdt = new Date(fromarray[2],fromarray[1],fromarray[0]);
		var todt   = new Date(toarray[2],toarray[1],toarray[0]);
		if(Date.parse(todt) < Date.parse(fromdt)) {
			
		var invaldt = parent.frames[0].getMessage("TO_DT_GR_EQ_FM_DT","RS") ;
		alert(invaldt);
		to.value="";
		to.focus();
		}
		return true;
		}
		}
		else if(Date.parse(todt) <= Date.parse(fromdt)){
		return true;
		}
	}
		return true;
	}
	/*************************************************************************/

function clearw_place()
{
parent.frames[0].document.forms[0].workplace_Id.value='';
parent.frames[2].location.href="../../eCommon/html/blank.html";
}
/***************************************************************/
function showCal(obj, obj_id){
	showCalendar(obj_id);
	obj.focus();
}
