var function_id;
var var_Month;
var end_date;
var c;

/********************************************************/
function reset(){
	f_query_view.frames[0].document.forms[0].reset() ;	
	
	f_query_view.frames[0].document.forms[0].staff_name.value='';
	f_query_view.frames[1].location.href='../../eCommon/html/blank.html';
	f_query_view.frames[2].location.href='../../eCommon/html/blank.html';
}
/********************************************************/
/**************************************************************/
function enableTodate()
{
	parent.frames[0].document.forms[0].to_date.disabled=false;
	parent.frames[0].document.forms[0].to_date.focus();
}

/********************************************************/
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
function RosterDetails(){
	parent.frames[2].location.href="../../eCommon/html/blank.html";
	var formObj=parent.frames[0].document.forms[0];
	var staff_id=formObj.staff_name.value;
	var locale=formObj.locale.value;
	var role_type=formObj.role_type.value;
	var mode=formObj.mode.value;
	var function_id=formObj.function_id.value;
	var from_date=convertDate(formObj.from_date.value,'DMY',locale,"en");
	var to_date=convertDate(formObj.to_date.value,'DMY',locale,"en");
	var fields = new Array(formObj.staff_name,formObj.from_date,formObj.to_date);
	var names = new Array(getLabel("eRS.StaffId.label","RS"),getLabel("Common.fromdate.label","Common"),getLabel("Common.todate.label","Common"));

	if(parent.parent.frames[1].checkFields(fields, names, parent.parent.messageFrame))
	{
	
var error='';
parent.parent.frames[2].location.href="../../eCommon/jsp/error.jsp?err_num="+error;
parent.frames[1].location.href="../../eCommon/html/blank.html";
var new_todate1=convertDate(parent.frames[0].document.forms[0].to_date.value,'DMY',locale,"en");
var next_fromdate=convertDate(parent.frames[0].document.forms[0].from_date.value,'DMY',locale,"en");
parent.f_query_details.location.href="../../eRS/jsp/StaffRosterResultFrameset.jsp?staff_id="+staff_id+"&role_type="+role_type+"&mode="+mode+"&function_id="+function_id+"&from_date="+from_date+"&to_date="+to_date+"&new_todate="+new_todate1+"&next_fromdate="+next_fromdate+"&onclick_of=S" ;
}
else
{
return false;
}
}

/***************************************************************/
function close_remark(){
	window.close();
}
/****************************************/
function callFunction(obj)
{
if(obj=='StaffRoster')
{
var url="../../eRS/jsp/StaffRoster.jsp?p_role_type=P&p_staff_id=AZINA&p_mode=CA&title=My Roster";
}
else if(obj=='OnCallList')
{
var url="../../eRS/jsp/StaffOnCall.jsp?p_locn_type=IP&p_locn_code=BLUE&p_mode=CA";
}
else if(obj=='ManageWorkSchedule')
{
var url="../../eRS/jsp/ManageWorkScheduleFrameset.jsp?p_locn_type=IP&p_locn_code=BLUE&p_mode=CA";
}
var dialogHeight =window.screen.height ;
var dialogWidth = window.screen.width ;
var dialogTop	= 0;
var dialogLeft = 0 ;
var features = 'dialogHeight:' + dialogHeight + '; dialogWidth:' + dialogWidth +';dialogTop:'+dialogTop+';dialogLeft:'+dialogLeft+'; scroll=no; status=no';
var arguments="";
window.showModalDialog(url,arguments,features);
}
/*******************************************************************/
function viewstaff(target, name,role)
{
	var frmObj		=parent.frames[0].document.forms[0];
	var p_role_type="";
	var p_staff_type="";
	var mode=frmObj.callmode.value;
        url='../../eRS/jsp/SearchStaff.jsp?p_role_type='+p_role_type+'&p_staff_type='+p_staff_type+'&mode=call';
	var dialogHeight =window.screen.height ;
	var dialogWidth = window.screen.width ;
	var dialogTop	= 0;
	var dialogLeft = 0 ;
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
			from = document.StaffRosterCriteriaform.from_date;
			to = document.StaffRosterCriteriaform.sys_date;
		}
		else 
		{
			from = document.StaffRosterCriteriaform.to_date;
			to = document.StaffRosterCriteriaform.from_date;
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
function showCal(obj, obj_id){
	showCalendar(obj_id);
	obj.focus();
}
//****************************************************************
function legend()
{
var frmobj=document.forms[0];
var mode=frmobj.callmode.value;
var role=frmobj.role_type.value;
if(mode=='CA')
{
//  parent.parent.fs.rows='0,*,58';
  if(role=='P')
    frmobj.all.t1.rows[0].cells[2].innerText='  '+'Practitioner';
  else if(role=='O')
    frmobj.all.t1.rows[0].cells[2].innerText='  '+'Other Staff';
}
else
{
  frmobj.all.t1.rows[0].cells[2].innerText='';
}
}
//************************************************************************************
