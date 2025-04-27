/*
*Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
* 
*Warning: This computer program is protected by copyright law and international treaties.
*Unauthorized reproduction or distribution of this program, or any portion of it, 
*may result in severe civil and criminal penalties, and will be prosecuted to 
*the maximum extent possible under the law.
*/
//Declaration for Amazon Changes
var prevObjID;
var prevImgObj;
var disappeardelay= 250;

//Declaration for Amazon Changes ends

var result     =   false ;
var message     =   "" ;
var flag        =   "" ;
var cnt=0;
var cntflag=0;
var cntslate="";
function clearField(obj){
	obj.value="";
	obj.style.color="#330066";
}
function clearBean(){
	var dummy="dummy";
	var xmlStr ="<root><SEARCH ";
	xmlStr+=" dummy=\""+ dummy + "\" ";
	xmlStr +=" /></root>";
	return fieldValidation(xmlStr,"clearBean");
}
function fieldValidation(xmlStr,source){
	var xmlDoc = "" ;
    var xmlHttp = new XMLHttpRequest() ;
    xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST","SlateValidation.jsp?func_mode="+source,false);
    xmlHttp.send(xmlDoc);
    responseText=xmlHttp.responseText ;
	alert(responseText);
	eval(responseText);
    return true;
}

function checkFlds( fields, names,show_alert) {
	var errors = "" ;
	var msg_blank = getMessage("CANNOT_BE_BLANK","OT");
	var msgArray = msg_blank.split("&");

	for( var i=0; i<fields.length; i++ ) {
		if(trimCheck(fields[i].value)) {
			fields[i].value = trimString(fields[i].value);
		}
		else if(show_alert !="Y"){
			//errors = errors + "APP-000001 " + names[i] + " cannot be blank..." + "<br>" ;
			errors = errors + msgArray[0] + names[i] + msgArray[1] + "<br>" ;
		}else{
			//errors = errors + "APP-000001 " + names[i] + " cannot be blank...\n" ;
			errors = errors + msgArray[0] + names[i] + msgArray[1] + "\n" ;
		}
	}
	if ( errors.length != 0 && show_alert != "Y") {
		if(parent.parent.messageFrame != null)
			parent.parent.messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num="+ errors;
		else
			messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num="+ errors;
		return false ;
	}else if(errors.length != 0 && show_alert == "Y"){
		alert(errors);
		return false;
	}else{
		if(parent.parent.messageFrame != null){
			parent.parent.messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num=";
		}else if(parent.messageFrame!=null){
			parent.messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num=";
		}
	}
	return true ;
}

function validateForMandatoryFields(){
}

function assignResult( _result, _message, _flag ) {
	result = _result ;
	message  = _message ;
	flag = _flag ;
}
async function searchCode(target,objIdentify){
// can be used for commonLookup
	var argumentArray  = new Array() ;
	var dataNameArray  = new Array() ;
	var dataValueArray = new Array() ;
	var dataTypeArray  = new Array() ;

	argumentArray[0]   = "SELECT....."; //document.getElementById("SQL_OT_").....value;
	argumentArray[1]   = dataNameArray ;
	argumentArray[2]   = dataValueArray ;
	argumentArray[3]   = dataTypeArray ;
	argumentArray[4]   = "1,2";
	argumentArray[5]   = target.value ;
	argumentArray[6]   = DESC_LINK ;
	argumentArray[7]   = CODE_DESC ;

	var retVal = await CommonLookup(getLabel("Common.Surgeon.label","Common"), argumentArray );
	if(retVal != null && retVal != "" )  {
		
		target.value = retVal[1] ;
	}
}
function validateTheatre(){
	var formObj = document.SlateSearchForm;
	var locale = formObj.locale.value;
	var theatre_date	=	dateUtils(formObj.theatre_date.value,locale);
	var theatre_date_from	=	dateUtils(formObj.theatre_date_from.value,locale);
	var theatre_view	=	formObj.theatre_view.value;
	var speciality		=	formObj.speciality.value;
	var theatre_type	=	formObj.theatre_type.value;
	var surgeon			=	formObj.surgeon.value;
	var surgeon_name	=	formObj.surgeon_name.value;
	var user_role		=	formObj.user_role.value;
// enable this if user_role is changed to a llokup
//	var user_role_name	=	formObj.user_role_name.value;
	var user_role_name	=	"";
	var by_time_seq		=	formObj.by_time_seq.value;
	var view_by			=	formObj.view_by.value;
	var calledFrom		=	formObj.calledFrom.value;//Added for 054986
	var refresh_flag = "Y";
	refreshSlateSearch(theatre_date,theatre_date_from,theatre_view,speciality,theatre_type,surgeon,surgeon_name,user_role,user_role_name,by_time_seq,view_by,refresh_flag);
}

function refreshSlateSearch(theatre_date,theatre_date_from,theatre_view,speciality,theatre_type,surgeon,surgeon_name,user_role,user_role_name,by_time_seq,view_by,refresh_flag){
	var formObj = document.SlateSearchForm;
	var params=formObj.params.value;
	var more_Less_Criteria_Flag=formObj.more_Less_Criteria_Flag.value;

		parent.f_search.location.href="../../eOT/jsp/SlateSearch.jsp?theatre_date="+theatre_date+"&theatre_date_from="+theatre_date_from+"&theatre_view="+theatre_view+"&speciality="+speciality+"&theatre_type="+theatre_type+"&surgeon="+surgeon+"&surgeon_name="+surgeon_name+"&user_role="+user_role+"&user_role_name="+user_role_name+"&by_time_seq="+by_time_seq+"&view_by="+view_by+"&refresh_flag="+refresh_flag+"&more_Less_Criteria_Flag="+more_Less_Criteria_Flag;
	//parent.f_query_add_mod.location.href="../../eCommon/html/blank.html";
	parent.parent.messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num=";
}
//Added for 054986
function refreshSlateSearch1(theatre_date,theatre_date_from,theatre_view,speciality,theatre_type,surgeon,surgeon_name,user_role,user_role_name,by_time_seq,view_by,refresh_flag,calledFrom){
	var formObj = document.SlateSearchForm;
	var params=formObj.params.value;
	var more_Less_Criteria_Flag=formObj.more_Less_Criteria_Flag.value;
	parent.f_search.location.href="../../eOT/jsp/SlateSearch.jsp?theatre_date="+theatre_date+"&theatre_date_from="+theatre_date_from+"&theatre_view="+theatre_view+"&speciality="+speciality+"&theatre_type="+theatre_type+"&surgeon="+surgeon+"&surgeon_name="+surgeon_name+"&user_role="+user_role+"&user_role_name="+user_role_name+"&by_time_seq="+by_time_seq+"&view_by="+view_by+"&refresh_flag="+refresh_flag+"&more_Less_Criteria_Flag="+more_Less_Criteria_Flag+"&calledFrom="+calledFrom;	
	parent.parent.messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num=";
}
//Added for 054986
function reset(){

	var params = f_query_add_mod.document.forms[0].params.value;
	clearBean();
	//messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num=";
	f_query_add_mod.document.location.href="../../eCommon/html/blank.html";
	//f_slate_tab_frame.document.location.href="../../eOT/jsp/SlateTab.jsp?"+params;
	f_query_add_mod.document.location.href="../../eOT/jsp/SlateTab.jsp?"+params;
	f_query_add_mod.document.location.href="../../eOT/jsp/SlateSearch.jsp?"+params;
	parent.messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num=";

}
async function searchSurgeons(obj){
	var formObj	= document.SlateSearchForm;
	formObj.surgeon_name.value="";
	formObj.surgeon.value="";
	var facility_id = formObj.facility_id.value;
	var retVal = 	new String();
	var dialogHeight= "28" ;
	var dialogWidth	= "43" ;
	var status = "no";
	var arguments	= "" ;
	var sql="";
	var search_code="";
	var search_desc="";
	var tit="Surgeons";
	var status = "E";
	tit="Surgeons "
	sql=escape("Select PRACTITIONER_ID,SHORT_NAME from AM_PRACTITIONER_LANG_VW where LANGUAGE_ID='"+formObj.locale.value+"' and PRACT_TYPE IN ('MD','SG') AND NVL(EFF_STATUS,'E')='E'");
	search_code="PRACTITIONER_ID";
	search_desc= "SHORT_NAME";
	var features = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; scroll=no; status:" + status;
	retVal = await window.showModalDialog("../../eCommon/jsp/GeneralSearch.jsp?SQL="+sql+"&search_code="+search_code+"&search_desc="+search_desc+"&title="+tit+"&dispDescFirst=dispDescFirst",arguments,features);
	var arr=new Array();
	if (!(retVal == null))
	{
	    var retVal=unescape(retVal);
	    arr=retVal.split("::");
	    document.forms[0].surgeon_name.value=arr[0];
	    document.forms[0].surgeon.value=arr[1];
	}
}
/* made as a list itemy
function searchUserRoles(obj){
	var formObj	= document.SlateSearchForm;
	var facility_id = formObj.facility_id.value;
	var retVal = 	new String();
	var dialogHeight= "28" ;
	var dialogWidth	= "43" ;
	var status = "no";
	var arguments	= "" ;
	var sql="";
	var search_code="";
	var search_desc="";
	var tit="User Roles";
	var status = "E";
	tit="User Roles "
	sql=escape("Select ROLE_ID,ROLE_DESC from OT_ROLES where NVL(STATUS,'E')='E'");
	search_code="ROLE_ID";
	search_desc= "ROLE_DESC";
	var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; scroll=no; status:" + status;
	retVal = window.showModalDialog("../../eCommon/jsp/GeneralSearch.jsp?SQL="+sql+"&search_code="+search_code+"&search_desc="+search_desc+"&title="+tit+"&dispDescFirst=dispDescFirst",arguments,features);
	var arr=new Array();
	if (!(retVal == null))
	{
	    var retVal=unescape(retVal);
	    arr=retVal.split("::");
	    document.forms[0].user_role_name.value=arr[0];
	    document.forms[0].user_role.value=arr[1];
	}
}
*/
function searchSlate()
{
	var formObj	= document.SlateSearchForm;
	formObj = document.SlateSearchForm;
	var fromDate=formObj.theatre_date_from.value;
	var toDate  =formObj.theatre_date.value;
	var retVal = checkForMandatory(formObj);
	
	if(retVal==false)
	{
		var returnVal=compareDate(toDate,fromDate);
		if(returnVal==false)
		{
			alert(getMessage("APP-OT0134","OT"));
			return;
		}
		searchOTDetails('SLATE');
	}
	else
	{
		var errormessage  = getMessage("OT_MANDATORY","OT");
        parent.parent.messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num=";
	}
}
function checkForMandatory(formObj){
	var msg = getMessage("CANNOT_BE_BLANK","OT");
	var msgArray = msg.split("&");
	var UserRole_value=getLabel("eOT.UserRole.Label","OT");
	var TheatreDate_value=getLabel("eOT.TheatrePeriod.Label","OT");
	if(formObj.theatre_date.value =="" || formObj.theatre_date_from.value =="" ){
		alert(msgArray[0]+TheatreDate_value+(msgArray[1]));
		return true;
	}else if(formObj.user_role.value ==""){
		alert(msgArray[0]+UserRole_value+(msgArray[1]));
		return true;
	}else if(formObj.theatre_view.value =="S"){
		/*if(formObj.theatre.value ==""){
			alert(msgArray[0]+" Theatre "+(msgArray[1]));
			formObj.theatre.focus();
			return true;
		}*/
	}else if(formObj.theatre_view.value =="M"){
		if(formObj.theatre_from.value ==""){
			var theatre_from=getLabel("eOT.Theatrefrom.Label","OT");
			alert(msgArray[0]+theatre_from+(msgArray[1]));
			formObj.theatre_from.focus();
			return true;
		}else if(formObj.theatre_to.value ==""){
			var to_theatre=getLabel("eOT.ToTheatre.Label","OT");
			alert(msgArray[0]+to_theatre+(msgArray[1]));
			formObj.theatre_to.focus();
			return true;
		}
	}
	return false;
}
function searchOTDetails(tab_name)
{
	//clearBean();
	var formObj = document.SlateSearchForm;
	var locale = formObj.locale.value;
	if(tab_name == "SLATE")
	{
		var theatre_date	=	dateUtils(formObj.theatre_date.value,locale);
		var theatre_view	=	formObj.theatre_view.value;
		var speciality		=	formObj.speciality.value;
		var theatre_type	=	formObj.theatre_type.value;
		var theatre			=	formObj.theatre.value;
		var theatre_from	=	formObj.theatre_from.value;
		var theatre_to		=	formObj.theatre_to.value;
		var surgeon			=	formObj.surgeon.value;
		var user_role		=	formObj.user_role.value;
		var by_time_seq		=	formObj.by_time_seq.value;
		var view_by			=	formObj.view_by.value;
		var bill_flag	    =	formObj.bill_flag.value;
		var sel_status			=	"";
		var theatre_date_from	=	dateUtils(formObj.theatre_date_from.value,locale);
		var elec_emer		=	formObj.elec_emer.value;
		var doc_status		=	"";
		var scan_vals		=	formObj.scan_vals.value;
		var theatre_type=	formObj.theatre_type.value;
		var patient_id=	formObj.patientid.value;//MO-CRF-20082
		

		if (sel_status=="")
		{
	        for(var m=0;m<formObj.status.options.length;m++)
			{
			   if(formObj.status.options[m].selected==true)
			   {
			      if(sel_status=="")
					  sel_status=+formObj.status.options[m].value;
					else
					  sel_status=sel_status+"','"+formObj.status.options[m].value;
			   }
			}
        }
		else
	      sel_status=formObj.status.value;
	   		sel_status=sel_status;
		if(sel_status=="")
			doc_status="0";
		else
			doc_status="1";
		if(theatre_view == "S")
		{
			theatre_from=theatre;
			theatre_to=theatre;
		}
		if(theatre_type == "ALL")
			theatre_type="";
		var calledFrom = document.forms[0].calledFrom.value; //IN052054
		
		parent.f_query_add_mod.location.href="../../eOT/jsp/SlateSearchResultsFrame.jsp?theatre_date="+theatre_date+"&theatre_view="+theatre_view+"&speciality="+speciality+"&theatre_type="+theatre_type+"&theatre_from="+theatre_from+"&theatre_to="+theatre_to+"&surgeon="+surgeon+"&user_role="+user_role+"&by_time_seq="+by_time_seq+"&view_by="+view_by+"&status="+sel_status+"&tab_name="+tab_name+"&bill_flag="+bill_flag+"&theatre_date_from="+theatre_date_from+"&elec_emer="+elec_emer+"&doc_status="+doc_status+"&scan_vals="+scan_vals+"&theatre_type="+theatre_type+"&patient_id="+patient_id+"&calledFrom="+calledFrom; //IN052054
	}
	else if(tab_name == "WAITLIST")
	{
		var preferred_date	=	dateUtils(formObj.preferred_date.value,locale);
		var speciality		=	formObj.speciality.value;
		var surgeon			=	formObj.surgeon.value;
		parent.f_query_add_mod.location.href="../../eOT/jsp/SlateWaitlistSearchResultsFrame.jsp?preferred_date="+preferred_date+"&speciality="+speciality+"&surgeon="+surgeon+"&tab_name="+tab_name;
	}
}

//to display the drop-down menu for the patient_id link
function displayToolTip(rownum,patient_id,tab_name,orderctlHDR,imgObj,encounter,location) // GHL-CRF 356.1// (,param1,param2,param3,......){
{
	var formObj = document.SlateSchSearchResultForm;
	var status = '';  // GHL-CRF 356.1
	var waitlist_theatre_flag = "true";
	var sch_type=formObj.sch_unsch_flag.value;
	var theatre = "";
	//var orderctlHDR=patient_id;
	if(tab_name=="WAITLIST"){
		var msg = getMessage("CANNOT_BE_BLANK","OT");
		var msgArray = msg.split("&");
		var Theatre_value=getLabel("Common.Theatre.label","common");
		var theatre = eval("formObj.theatre_"+rownum).value;
		if(theatre == ""){
			alert(msgArray[0]+Theatre_value+(msgArray[1]));
			waitlist_theatre_flag = "false";
			return true;
		}
	}
	if(waitlist_theatre_flag == "true")
	{
		var xmlDoc = "" ;
		var xmlHttp = new XMLHttpRequest();
		var xmlStr ="<root><SEARCH ";
		xmlStr += " bean_id=\""+ formObj.bean_id.value + "\" ";
		xmlStr += " bean_name=\""+ formObj.bean_name.value + "\" ";
		xmlStr += " oper_status=\""+ eval("formObj.oper_status_"+rownum).value + "\" ";
		xmlStr += " user_role=\""+ formObj.user_role.value + "\" ";
		xmlStr += " tab_name=\""+ tab_name + "\" ";
		xmlStr +=" /></root>";
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open("POST","SlateValidation.jsp?func_mode=getMenuList&sch_type="+sch_type+" ",false);
		xmlHttp.send(xmlDoc);
		// assigns the values for function_id_list and function_name_list in the SlateSchSearchResultForm
		eval(xmlHttp.responseText);
		// get the list of function_id's (menu_id)
		var function_id_list = formObj.function_id_list.value;
		var function_id_list_array  = function_id_list.split("##"); // the functions are separated by ##
		var menu_id_list = "";
		for (var i=0;i<function_id_list_array.length-1;i++ ){
			if(i==0)
				menu_id_list = function_id_list_array[i];
			else{
				if(sch_type=="UNSCHEDULED" && function_id_list_array[i]!="13" || sch_type=="SCHEDULED"){  // Added for IN:45635
				menu_id_list += ",";
				menu_id_list += function_id_list_array[i];
				}
			}
		}
		for (var i=0;i<function_id_list_array.length-1;i++ ){
			if(i==0)
				menu_id_list = function_id_list_array[i];
			else{
			    if(sch_type=="UNSCHEDULED" && function_id_list_array[i]!="13" || sch_type=="SCHEDULED"){ // Added for IN:45635
				menu_id_list += ",";
				menu_id_list += function_id_list_array[i];
				}
			}
		}
		// get the list of function_names (menu_names)
		var function_name_list = formObj.function_name_list.value;
		var function_name_list_array  = function_name_list.split("##"); // the functions are separated by ##
		var menu_name_list = "";
		for (var i=0;i<function_name_list_array.length-1;i++ ){
			if(i==0)
				menu_name_list = function_name_list_array[i];
			else{
			    if(sch_type=="UNSCHEDULED" && function_id_list_array[i]!="13" || sch_type=="SCHEDULED"){  // Added for IN:45635
				menu_name_list += ",";
				menu_name_list += function_name_list_array[i];
				}
			}
		}
		// get the list of url_desc for each menu
		var url_desc_list = formObj.url_desc_list.value;
		var url_desc_list_array  = url_desc_list.split("##"); // the functions are separated by ##
		var menu_url_desc_list = "";
		for (var i=0;i<url_desc_list_array.length-1;i++ ){
			if(i==0)
				menu_url_desc_list = url_desc_list_array[i];
			else{
			    if(sch_type=="UNSCHEDULED" && function_id_list_array[i]!="13" || sch_type=="SCHEDULED"){  // Added for IN:45635
				menu_url_desc_list += ",";
				menu_url_desc_list += url_desc_list_array[i];
				}
			}
		}
		// after getting these values clear the values in the form
		formObj.function_id_list.value = "";
		formObj.function_name_list.value = "";
		formObj.url_desc_list.value = "";

		var patient_id=eval("formObj.patient_id_"+rownum).value;
		var oper_num=eval("formObj.oper_num_"+rownum).value;
		var order_id=eval("formObj.order_id_"+rownum).value;
		var appt_ref_num=eval("formObj.appt_ref_num_"+rownum).value;
		var waitlist_num=eval("formObj.waitlist_num_"+rownum).value;
		buildTable(rownum,tab_name,patient_id,appt_ref_num,oper_num,waitlist_num,order_id,theatre,menu_id_list,menu_name_list,menu_url_desc_list,orderctlHDR,imgObj,status,location);  // GHL-CRF 356.1
		resizeWindow(orderctlHDR);
		//resizeWindow();
	}
}
function assignFunctionIDList(function_id_list){
	var formObj = document.SlateSchSearchResultForm;
	formObj.function_id_list.value = function_id_list;
}
function assignFunctionNameList(function_name_list){
	var formObj = document.SlateSchSearchResultForm;
	formObj.function_name_list.value = function_name_list;
}
function assignFunctionURLList(url_desc_list){
	var formObj = document.SlateSchSearchResultForm;
	formObj.url_desc_list.value = url_desc_list;
}

function buildTable(rownum,tab_name,patient_id,appt_ref_num,oper_num,waitlist_num,order_id,theatre,menu_id_list,menu_name_list,menu_url_desc_list,orderctlHDR,imgObj,status,location)
{
	// GHL-CRF 356.1
	var formObj		= document.SlateSchSearchResultForm;
	var sch_type=formObj.sch_unsch_flag.value;
	var calledFrom = document.forms[0].calledFrom.value; //IN052054
	//IN:051158 start
	if(sch_type == "SCHEDULED" && location == "" || location == null)
	{
		menu_id_list		= trimString("39");
		menu_name_list		= trimString("Link To Current Episode");//51140
		menu_url_desc_list	= trimString("NO_URL");
	 }
    else
    {
		menu_id_list		= trimString(menu_id_list);
		menu_name_list		= trimString(menu_name_list);
		menu_url_desc_list	= trimString(menu_url_desc_list);
	}
	//IN:051158 end
	var id_rowval = menu_id_list.split (","); // function_id
	var id_name_rowval  = menu_name_list.split (","); // function_name
	var url_desc_rowval = menu_url_desc_list.split (","); // function_name
	if(calledFrom != 'CA') //IN052054 start
	{
	callMouseOverOnTD(orderctlHDR,imgObj);
	var tab_dat  = "<table id='tooltiptable' cellpadding='3' cellspacing=0 border='0' class='contextMenu' width='100%' height='100%' align='center'>";
	for( var i=0; i<id_rowval.length; i++ )
	{
		var id_colval		= id_rowval[i];
		//alert("id_colval:=="+id_colval);
		var id_name_colval  = id_name_rowval[i];
		var url_desc_colval  = url_desc_rowval[i];
		if(id_colval!="")
		{
			tab_dat     += "<tr>"
			tab_dat     += "<td class = 'contextMenuItem' nowrap id='mouse' onMouseOver='callMouseOver(this)' onMouseOut='callOnMouseOut(this);'><a class='contextMenuLink' href = javascript:callMenuFunctions('"+escape(location)+"','"+status+"','"+rownum+"','"+tab_name+"','"+patient_id+"','"+appt_ref_num+"','"+oper_num+"','"+waitlist_num+"','"+order_id+"','"+theatre+"','" + escape(id_colval) + "','"+escape(id_name_colval)+"','"+escape(url_desc_colval)+"')> "+id_name_colval + " </a> </td>"  // GHL-CRF 356.1
			tab_dat     += "</tr> ";
		}
	}
	tab_dat     += "</table> ";
	document.getElementById("menu_table").innerHTML = tab_dat;
	}
	else
	{
		for( var i=0; i<id_rowval.length; i++ )
		{
			var id_colval = id_rowval[i];
			var id_name_colval  = id_name_rowval[i];
			var url_desc_colval  = url_desc_rowval[i];
			if(id_colval != "" && url_desc_colval == 'OpenChartWrapper.jsp')
				callMenuFunctions(location, status, rownum, tab_name, patient_id, appt_ref_num, oper_num, waitlist_num, order_id, theatre, escape(id_colval), escape(id_name_colval), escape(url_desc_colval));
		}
	}
	 //IN052054 end
}

async function callMenuFunctions(location,status,rownum,tab_name,patient_id,appt_ref_num,oper_num,waitlist_num,order_id,theatre,function_id,function_name,url_desc)  // GHL-CRF 356.1
{
	var formObj		= document.SlateSchSearchResultForm;
	var facility_id = formObj.facility_id.value;
	var nursing_doc_comp_yn = "";
	var surgeon_doc_comp_yn = "";
	var anaesthesia_doc_comp_yn = "";
	var speciality_code = "";
	var speciality_desc="";
	var surgeon_code="";
	var surgeon_name="";
	var oper_code ="";
	//IN052054 start
	var login_reqd_yn;
	var calledFrom;
	if(document.forms[0].calledFrom != null)
		calledFrom = document.forms[0].calledFrom.value;
	//IN052054 end
	if(tab_name=="SLATE"){
		nursing_doc_comp_yn=eval("formObj.nursing_doc_comp_yn_"+rownum).value;
		surgeon_doc_comp_yn=eval("formObj.surgeon_doc_comp_yn_"+rownum).value;
		anaesthesia_doc_comp_yn=eval("formObj.anaesthesia_doc_comp_yn_"+rownum).value;
		surgeon_code = eval("formObj.surgeon_code_"+rownum).value;
		surgeon_name = eval("formObj.surgeon_desc_"+rownum).value;
		speciality_code = eval("formObj.speciality_code_"+rownum).value;
		//alert("speciality_code--->"+speciality_code)
		speciality_desc = eval("formObj.speciality_desc_"+rownum).value;
		oper_code = eval("formObj.oper_code_"+rownum).value;
		
	//Added by Gaurav Against ML-MMOH-CRF-1791-US03...starts	
	
	
	if(appt_ref_num === ''){
		var auto_schdl_yn = formObj.auto_schdl_yn.value;
		if(auto_schdl_yn === 'Y' && surgeon_code === 'ALL_OT_SURG'){
			var arguments = "";
		if (window.confirm('Surgeon not assigned for the surgery...Please assign surgeon to processed further.')){
			var dialogHeight2 = "10" ;
			var dialogWidth2  = "25" ;
			var dialogTop2    = "250";
			var dialogLeft2   = "300";
			var features2     = "dialogHeight:" + dialogHeight2 + "; dialogWidth:" + dialogWidth2+ "; dialogLeft:" + dialogLeft2+ "; dialogTop:" +dialogTop2+ "; status:no;scroll:no" ;
			var param="facility_id="+facility_id+"&patient_id="+patient_id+"&speciality_code="+speciality_code+"&tab_name="+tab_name+"&appt_ref_num="+appt_ref_num+"&oper_num="+oper_num+"&auto_schdl_yn="+auto_schdl_yn+"&surgeon_code2="+surgeon_code;
			retVal=window.showModalDialog("../../eOT/jsp/AddAsstSurgeonFrame.jsp?"+param,arguments,features2);	
				if(retVal=="Updated Successfully"){
					parent.location.reload();
				}else{
					return;
				}
		}else{
		window.close();
		return;
		}
		}
	}
	//Added by Gaurav Against ML-MMOH-CRF-1791-US03...ends
	}
	//added for Slate Login Required or Not (login_reqd_yn value is Stored it in the Tab Frame SlateTab.jsp).
	//IN052054 start
	if(calledFrom != 'CA')
		login_reqd_yn = parent.parent.parent.frames[0].document.forms[0].login_reqd_yn.value;
	else
		login_reqd_yn = "N";
	//IN052054 end
	var booking_num		= appt_ref_num;
	var waitlist_no		= ""; //remove this later and populate like oper_num
	var menu_id	= formObj.menu_id.value;

	var speciality_code = eval("formObj.speciality_code_"+rownum).value;
	var slate_user_id = "true";
	var old_session_user_id = "";
	if((url_desc.search("OpenChartWrapper")!= 0) && (url_desc.search("ViewConsentDtls")!= 0) && (function_id!=17)  && (function_id!=28)  && login_reqd_yn=="Y" ){
		slate_user_id = acceptAndValidateUser(function_id,function_name);
	}else{
		slate_user_id = formObj.login_user.value;
	}
	// if error, slate_user_id = NOT_VALID else it will return the new logged in user id
						var xmlDoc = "" ;
						var xmlHttp = new XMLHttpRequest() ;
						var xmlStr ="<root><SEARCH ";
						xmlStr +=" /></root>";
						xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
						var params = "func_mode=session_put_val&function_id="+function_id;
						xmlHttp.open("GET","../../eOT/jsp/CommonValidation.jsp?"+params,false);
						xmlHttp.send(xmlDoc);
						var retVal = trimString(xmlHttp.responseText);
						var function_id_old=retVal;
			// GHL-CRF 356.1
			if(function_id=="39")
			{
					var locationChk = validateCurrLocation(location, appt_ref_num, facility_id, order_id, patient_id);
					if(locationChk)
						parent.location.reload();
					return;
	    	}
			if(function_id=="27")
						{
						/* Chk Out Recovery Room Should Complete Before Chk In Recovery Room  For this validation is writeen by Sathish on 22-05-2009 For CRF-224(chargeableUnitsPart)*/
						var xmlDoc = "" ;
						var xmlHttp = new XMLHttpRequest() ;
						var xmlStr ="<root><SEARCH ";
						xmlStr +=" /></root>";
						xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
						var params = "func_mode=getChkinrecovery_yn&facility_id="+facility_id+"&oper_num="+oper_num;
						xmlHttp.open("GET","../../eOT/jsp/CommonValidation.jsp?"+params,false);
						xmlHttp.send(xmlDoc);
						var retVal = trimString(xmlHttp.responseText);
						if(retVal=="X")
							{
							//alert("ChkIn Recovery Room Should Complete");
                            alert(getMessage("APP-OT0138","OT"));

							return;
							}

							}

	if(slate_user_id!=null && slate_user_id!="undefined" && slate_user_id!='false'){
		if(slate_user_id!=='NOT_VALID'){
			//assign the slate user to sesion variables
			if(function_id=="04" || function_id=="06" || function_id=="07" || function_id=="08" || function_id=="09" || function_id=="10" || function_id=="11" || function_id=="32"){
				assignSessionVariables(slate_user_id,"NEW");
			}
			// end of assigning
			if(function_id=="02" || function_id=="03" || function_id=="22")
			{
				retVal=confirm(getMessage("APP-OT0079","OT"));
				if(retVal==true){
					//call the bean to update the status and commit
					var xmlDoc = "" ;
					var xmlHttp = new XMLHttpRequest();
					var xmlStr ="<root><SEARCH ";
					xmlStr += " function_id=\""+ function_id + "\" ";
					xmlStr += " oper_num=\""+ oper_num + "\" ";
					xmlStr += " booking_num=\""+ appt_ref_num + "\" ";
					xmlStr += " order_id=\""+ order_id + "\" ";
					xmlStr += " tab_name=\""+ tab_name + "\" ";
					xmlStr += " theatre=\""+ theatre + "\" ";
					xmlStr += " slate_user_id=\""+ slate_user_id + "\" ";
					xmlStr += " waitlist_num=\""+ waitlist_num + "\" ";
					xmlStr += " /></root>";
					xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
					xmlHttp.open("POST","SlateValidation.jsp?func_mode=updateStatusAndCommit",false);
					xmlHttp.send(xmlDoc);
					retVal = trimString(xmlHttp.responseText);
					if(retVal=="NO_ERROR_FOUND"){
						var msg = getMessage("RECORD_INSERTED","SM");
						// Start of Case Slip Online Print
						if(function_id=="03"){
							var dialogHeight	= "11" ;
							var dialogWidth	= "25" ;
							var arguments	= "" ;
							var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; status:no" ;
							var url = "../../eOT/jsp/CaseSlipReports.jsp";
							url=url+"?booking_num="+appt_ref_num+"&slate_user_id="+slate_user_id+"&p_module_id=OT&facility_id="+facility_id+"&p_report_id=OTRCSLIP";
							retVal 	   = await window.showModalDialog(url, arguments, features);
						}
						// End of Case Slip Online Print
						clearBean();
						if(cnt!=0)
						{
								cnt=0;
						}
						parent.document.location.reload();
						//parent.parent.messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num="+ msg;
					}else{
						clearBean();
						if(cnt!=0)
						{
							cnt=0;
						}
						//alert(msg); // commit message
						parent.document.location.reload();
						//parent.parent.messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num="+ msg;
					}
				}
			}
			else
			{
				// get these paramString values from Database....
				// This has to be removed and selected from Database.
				if(tab_name=="SLATE") // used in checkin,......
					tab_name = formObj.sch_unsch_flag.value;
				var access = "NYNNY";
				//if(nursing_doc_comp_yn=="Y" || surgeon_doc_comp_yn=="Y")
				//	access = "NNNNY";
				var formObjslate1=parent.parent.parent.f_tab_frames.f_search.document.SlateSearchForm;
				var db_param_1="module_id=OT&function_type=F&menu_id="+menu_id+"&access="+access+"&home_required_yn=N";
				var function_string = getFunctionString(url_desc,function_id);
				var db_param = db_param_1 + function_string;
				if(url_desc.search("OpenChartWrapper") == 0)
				{
					var xmlDoc = "" ;
					var xmlHttp = new XMLHttpRequest();
					var xmlStr ="<root><SEARCH ";
					xmlStr += " oper_num=\""+ oper_num + "\" ";
					xmlStr += " booking_num=\""+ appt_ref_num + "\" ";
					xmlStr += " from_service_yn=\""+ "Y" + "\" ";
					xmlStr += " /></root>";
					xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
					xmlHttp.open("POST","PatientHistoryParams.jsp",false);
					xmlHttp.send(xmlDoc);
					retVal = trimString(xmlHttp.responseText);
					var pt_array  = retVal.split("::");
					var HTML = "<html>";
					var cnt_temp=formObjslate1.cnt_temp.value;
					var oper_status=eval("formObj.oper_status_"+rownum).value
					//var colorindex=	formObjslate1.color_ind_old.value;
					var operationstatus=formObjslate1.operation_status.value;
					var operation_flag=formObjslate1.operation_flag.value;
					var oper_temp_cnt_1=formObjslate1.oper_temp_cnt_1.value;
					var tempcount=formObjslate1.oper_temp_cnt.value;
			if(formObjslate1.oper_temp_flag.value=="Y" && tempcount > 0 )
			{
				cnt=1;
			}
			if(operationstatus!="" && oper_status!= "" && operationstatus!=oper_status && operation_flag=="N" )
				{
				if(oper_temp_cnt_1 >0 )
				{
					cnt=1;
				}
					else
					{
						cnt=0;
					}
					formObjslate1.operation_flag.value="";
					formObjslate1.oper_temp_cnt_1.value=cnt;
					//operationstatus=oper_status;
				}
				if(operationstatus!="" && oper_status!= "" && operationstatus==oper_status && oper_temp_cnt_1 > 0)
				{
					cnt=1;
				}

			//alert(parent.parent.parent.frames[0].frame_count);
			var fram_count = parent.parent.parent.frames[0].frame_count
			fram_count=(fram_count==0)?1:++fram_count;
			parent.parent.parent.frames[0].frame_count=fram_count;
					var count1=cnt%2 ;
					//Modified against 50878
					var rootPath = window.location.protocol + "//" + window.location.host + "" + ctxPath +"/eCA/jsp/OpenChartWrapper.jsp";
					//HTML += "<form name='historyForm' id='historyForm' action = '../../eCA/jsp/OpenChartWrapper.jsp' method='post' target='messageFrame' >";
					//Modified against 50878
					HTML += "<form name='historyForm' id='historyForm' action = '"+rootPath+"' method='post' target='messageFrame' >";
					HTML += "<input type='hidden' name='patient_id' id='patient_id' value= '"+patient_id+"'>";
					HTML += "<input type='hidden' name='source_accession_type' id='source_accession_type' value= 'OT'>";
					HTML += "<input type='hidden' name='source_accession_num' id='source_accession_num' value= '"+oper_num+"'>";
					HTML += "<input type='hidden' name='encounter_id' id='encounter_id' value= '"+pt_array[0]+"'>";
					HTML += "<input type='hidden' name='patient_class' id='patient_class' value= '"+pt_array[1]+"'>";
			    	HTML += "<input type='hidden' name='mode' id='mode' value= 'R'>";
			    	HTML += "<input type='hidden' name='from_service_yn' id='from_service_yn' value= 'Y'>";
					HTML += "</form>";
					HTML += "</html>";
					cnt++;
					parent.parent.parent.messageFrame.document.body.insertAdjacentHTML("BeforeEnd", HTML);
					parent.parent.parent.messageFrame.document.historyForm.submit();
				}
				else
				{
					var bill_flag	    =	formObj.bill_flag.value;
		            var view_booking_params = "&facility_id="+facility_id;
					if(function_id=="17") // used only for vewi booking details
						//Modified by rajesh for hiding rreset button on 12/09/07
						//view_booking_params = view_booking_params+"&orderid=0&booking_no="+booking_num+"&transfer=5";
					view_booking_params = view_booking_params+"&orderid=0&booking_no="+booking_num+"&transfer=5&menu_required_yn=N";
					/* Newly added Below Function by Sathish.K on 12-03-2009  for TransferTOOT Cases... to uncheck Billing after TransferTOOT.*/
					var trfr_date_time	    =	"";
					var trfr_oper_room	    =	"";
					var trfr_to_ot_flag	    =	"N";
					var st_interface_flag1	=	"N";
					if(function_id=="07" ||function_id=="08")
					{
						var sql="SELECT TRFR_OPER_ROOM FROM OT_POST_OPER_HDR WHERE OPERATING_FACILITY_ID='"+facility_id+"' AND OPER_NUM='"+oper_num+"' ";
						var param="sql="+sql;
						var xmlDoc="";
						var xmlHttp = new XMLHttpRequest();
						var xmlStr="<root></root>";
						xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
						xmlHttp.open("POST", "../../servlet/eOT.CommonQueryServlet?"+param,false);
						xmlHttp.send(xmlDoc);;
						var return_val=xmlHttp.responseText;
				   trfr_oper_room=eval(return_val);
						if(trfr_oper_room!="")
						{
							trfr_to_ot_flag="Y";
							if(booking_num =="")
							{
							bill_flag="false";
							}else
							{
							bill_flag="true";
							}
						}
                     }
					if(function_id=="32")
					{
					var xmlDoc = "" ;
					var xmlHttp = new XMLHttpRequest() ;
					var xmlStr ="<root><SEARCH ";
					xmlStr +=" /></root>";
					xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
					var params = "func_mode=getAdminAndSTflag&facility_id="+facility_id;
					xmlHttp.open("GET","../../eOT/jsp/CommonValidation.jsp?"+params,false);
					xmlHttp.send(xmlDoc);
					var retVal = trimString(xmlHttp.responseText);
					retVal=retVal.split("##");
					if(retVal[1]=="N")
					{
					//alert("Admin Function not Applicable for this Facility");
				    alert(getMessage("APP-OT0169","OT"));
					return;
					}
					/*var sql="SELECT TRFR_OPER_ROOM FROM OT_POST_OPER_HDR WHERE OPERATING_FACILITY_ID='"+facility_id+"' AND OPER_NUM='"+oper_num+"'";
					var param="sql="+sql;
					var xmlDoc="";
					var xmlHttp = new XMLHttpRequest();
					var xmlStr="<root></root>";
					xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
					xmlHttp.open("POST", "../../servlet/eOT.CommonQueryServlet?"+param,false);
					xmlHttp.send(xmlDoc);;
					var return_val=xmlHttp.responseText;
					trfr_oper_room=eval(return_val);
					if(trfr_oper_room!="")
					{   //trfr_to_ot_flag="Y";
						//bill_flag="false";
					 //alert("Administrative Function is not Applicable for Transfer to OT Cases");
					 alert(getMessage("APP-OT0168","OT"));
					 return;
					}*/
					var xmlDoc = "" ;
					var xmlHttp = new XMLHttpRequest() ;
					var xmlStr ="<root><SEARCH ";
					xmlStr +=" /></root>";
					xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
					var params_trfr = "func_mode=get_trfropercode_and_sourceopernum&facility_id="+facility_id+"&oper_num="+oper_num;
					xmlHttp.open("GET","../../eOT/jsp/OTCommonValidation.jsp?"+params_trfr,false);
					xmlHttp.send(xmlDoc);
					var retVal_trfr = trimString(xmlHttp.responseText);
					retVal_trfr=retVal_trfr.split("::");
					if(retVal_trfr[0]!="" && retVal_trfr[1]!="")
					{
					 alert(getMessage("APP-OT0168","OT"));
					 return;
					}

					st_interface_flag1=retVal[0];
					}
					var url = url_desc+"?"+db_param+"&called_from=OT_SLATE&patient_id="+patient_id+"&oper_num="+oper_num+"&booking_num="+booking_num+"&booking_no="+booking_num+"&waitlist_no="+waitlist_no+"&slate_user_id="+slate_user_id+"&surgeon_doc_comp_yn="+surgeon_doc_comp_yn+"&nursing_doc_comp_yn="+nursing_doc_comp_yn+"&anaesthesia_doc_comp_yn="+anaesthesia_doc_comp_yn+"&order_id="+order_id+"&tab_name="+tab_name+"&speciality_code="+speciality_code+view_booking_params+"&oper_code="+oper_code+"&theatre_date="+formObjslate1.theatre_date.value+"&surgeon_code="+surgeon_code+"&bill_flag="+bill_flag+"&trfr_to_ot_flag="+trfr_to_ot_flag+"&function_id="+function_id;// comes from ot_functions (database) & //PMG2017-SS-CRF-0001-US002

					if(url_desc.search("ViewConsentDtls") == 0){
						var dialogHeight = "40" ;
						//var dialogWidth  = "52" ;
						var dialogWidth  		= window.screen.availWidth;
						var dialogTop    = "200";
						var dialogLeft   = "100";
						var features     = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth+ "; dialogLeft:" + dialogLeft+ "; dialogTop:" +dialogTop+ "; status=no;help:no" ;
						//var features = "dialogHeight:485px;dialogWidth:645px;status=no;help:no;center:yes";
					}else{ //Common to all
						var retVal;
						var dialogHeight = screen.availHeight ;
						//var dialogWidth  = "52" ;
						var dialogWidth  		= screen.availWidth;
						var dialogTop    = "0";
						var dialogLeft   = "0";
						var features     = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth+ "; dialogLeft:" + dialogLeft+ "; dialogTop:" +dialogTop+ "; status=no;help:no" ;
					}
					//Anaesthesia functions calling
					if(function_id=="09" || function_id=="10" || function_id=="11"){
						var xmlDoc = "" ;
						var xmlHttp = new XMLHttpRequest();
						var xmlStr ="<root><SEARCH ";
						xmlStr += "order_id=\""+order_id+ "\" ";
						xmlStr += "function_id=\""+function_id+ "\" ";
						xmlStr += " /></root>";
						xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
						xmlHttp.open("POST","AnaesthesiaParams.jsp",false);
						xmlHttp.send(xmlDoc);
						retVal = trimString(xmlHttp.responseText);
					var pt_array  = retVal.split("::");
						param="patient_id="+patient_id+"&facility_id="+facility_id+"&anesthesia_srl_no="+pt_array[0];
						if(function_id=="09" && pt_array[4]=="AnesthesiaDetails"){
							//var	url='../../eOT/jsp/AT_PreAnaesthesia.jsp?'+param+"&tab_name="+"AnesthesiaDetails"; //Anitha on 1/19/2011 for 25928
							var	url='../../eOT/jsp/AT_PreAnaesthesia.jsp?'+param+"&tab_name="+"AnesthesiaDetails"+"&slate_user_id="+slate_user_id;
						}else if(function_id=="09" && pt_array[4]=="PendingOrders"){
							 var	url='../../eOT/jsp/AT_PreAnaesthesia.jsp?'+param+"&tab_name="+"PendingOrders"+"&patient_id="+patient_id+"&source_id="+pt_array[5]+"&parent_source_id="+pt_array[6]+"&request_source_type="+pt_array[7]+"&anaesthetist_code="+pt_array[8];
						}else if(function_id=="09" && pt_array[4]=="AnaesthesiaNotApplicable"){
							//alert("Anesthesia is not applicable for this operation");
							alert(getMessage("APP-OT0038","OT"));
							return;
						}
						if(pt_array[0]=="" && function_id=="10"){
							//alert("Anesthesia is not applicable for this operation or Pre Anesthesia is not done for this operation");
							alert(getMessage("APP-OT0056","OT"));
							return;

						}else if(pt_array[0]!="" && function_id=="10"){
							//25928
							var	url='../../eOT/jsp/AT_IntraAnaesthesia.jsp?'+param+"&accession_num="+oper_num+"&slate_user_id="+slate_user_id;

						}
						if(pt_array[0]=="" && function_id=="11"){
							//alert("Anesthesia is not applicable for this operation or Pre/Intra Anesthesia are not done for this operation");
							alert(getMessage("APP-OT0057","OT"));
							return;

						}else if(pt_array[0]!="" && function_id=="11"){
							//25928
							 var	url='../../eOT/jsp/AT_PostAnaesthesia.jsp?'+param+"&accession_num="+oper_num+"&slate_user_id="+slate_user_id;
						}
					}

					if(function_id == 14){
						var oper_status = eval("formObj.oper_status_"+rownum).value;
						var surgery_history_legend = encodeURIComponent(getLabel("eOT.SurgeryHistory.Label","OT"));

						var param= db_param+"&called_from=OT_SLATE&patient_id="+patient_id+"&oper_num="+oper_num+"&booking_num="+booking_num+"&login_user="+document.forms[0].login_user.value+"&order_id="+order_id+"&tab_name="+tab_name+"&speciality_code="+speciality_code+"&facility_id="+facility_id+"&function_name="+surgery_history_legend+"&status="+oper_status;// comes from ot_functions
						var	url= "../../eOT/jsp/SurgeryHistory.jsp?"+param;

					}

					if(function_id == 15){
						var patient_name = eval("formObj.patient_name_"+rownum).value;
						var patient_name1=patient_name.replace("'","");//MMHADHOC
						var dialogHeight 		= window.screen.availHeight;
						var dialogWidth  		= window.screen.availWidth;
						var dialogTop   		= "0";
						var dialogLeft   		= "0";
						var features			= "dialogTop:"+dialogTop+"dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +";status=no";
						var param= "called_from=OT_SLATE&home_required_yn=N&patient_id="+patient_id+"&patient_name="+patient_name1; //comes from ot_functions +"&function_name=Anaesthesia History&home_required_yn=N"							
						var	url= "../../eOT/jsp/AT_AnaesthesiaHistory.jsp?"+param;
				}

					if(function_id == 28){
						//view checkList
						var oper_status = eval("formObj.oper_status_"+rownum).value;
						var surgery_history_legend = getLabel("eOT.SurgeryHistory.Label","OT");
						var param= db_param+"&called_from=OT_SLATE&patient_id="+patient_id+"&oper_num="+oper_num+"&booking_num="+booking_num+"&login_user="+document.forms[0].login_user.value+"&order_id="+order_id+"&tab_name="+tab_name+"&speciality_code="+speciality_code+"&facility_id="+facility_id+"&function_name="+surgery_history_legend+"&status="+oper_status+"&access=NNNNN";// comes from
						var	url= "../../eOT/jsp/SurgeryHistoryDetails.jsp?"+param;
						//alert(url)
					}

					if(function_id == 29){
						var dialogHeight 		= "80";
						var dialogWidth  		= "80";
						var dialogTop   		= "10";
						var dialogLeft   		= "50";
						var features			= "dialogTop:"+dialogTop+"dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +";status=no";
						var param="booking_no="+booking_num+"&facility_id="+facility_id+"&patient_id="+patient_id;
						var	url= "../../eOT/jsp/PreOperativeDlgFrame.jsp?"+param;
					}

					if(function_id == 21){
						rescheduleCount(appt_ref_num,patient_id);
					//	var surgeon_code1 = formObj.login_user.value;
						var	param="booking_no="+appt_ref_num+"&surgeonCode="+surgeon_code+"&funflag=2&prefDate=&surgeonName="+encodeURIComponent(surgeon_name,"UTF-8")+"&speciality_code="+speciality_code+"&speciality_desc="+encodeURIComponent(speciality_desc,"UTF-8")+"&booking_called_from=OT_SLATE"+"&called_from=OT_SLATE";
						var dialogHeight 		= "80";
						var dialogWidth  		= "80";
						var dialogTop   		= "10";
						var dialogLeft   		= "50";
						var title               = "Reschedule"
						var features			= "dialogTop:"+dialogTop+"dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +";status=no;";
						var	url= "../../eOT/jsp/CalendarFrame.jsp?"+param;
					}
					var arguments    = "" ;
					if(function_id == 01 || function_id == 04 || function_id == 05 || function_id == 06 || function_id == 17 || function_id == 28 || function_id == 14 || function_id == 09 || function_id == 07 || function_id == 08 || function_id == 32 || function_id ==33 || function_id == 25 || function_id == 26 || function_id == 27 || function_id == 31 || function_id == 20)
					{
						 dialogTop    = "85";
						 dialogLeft   = "5";
						 dialogHeight = "40" ;
						 dialogWidth  = "85" ;
						 features     = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth+ "; dialogLeft:" + dialogLeft+ "; dialogTop:" +dialogTop+ "; status=no" ;
					}
					if(function_id==13) //Added for IN:41808
					{
					var dialogHeight	= '25' ;
					var dialogWidth		= '65' ;
					var dialogTop		= 58;
					var arguments		= '';
					var features    = 'dialogHeight:' + dialogHeight + '; dialogWidth:' + dialogWidth +'; status=no;';
					var xmlDoc = "" ;
					var xmlHttp = new XMLHttpRequest() ;
					var xmlStr ="<root><SEARCH ";
					xmlStr +=" /></root>";
					var param="func_mode=pat_gender_check&patient_id="+patient_id;
					xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
					xmlHttp.open("POST","../../eOT/jsp/OTCommonValidation.jsp?"+param,false);
					xmlHttp.send(xmlDoc);
					var retVal = localTrimString(xmlHttp.responseText);
					var patgender = retVal;
					var url			= "../../eOT/jsp/OperatingSiteIdentification.jsp";
					url=url+"?nd_booking_num="+appt_ref_num+"&sex="+patgender+"&p_module_id="+"OT"+"&p_report_id="+"OTOSIDEN"+"&nd_facility_id="+facility_id+"&facility_id="+facility_id+"&Patient_ID=" +patient_id;
					retVal=   window.showModalDialog(url,arguments,features);
					if ( retVal != null ) {
					retVal		= "../../eCommon/jsp/report_process.jsp?" + retVal ;
					var myBars 		= 'directories=no,location=no,menubar=no' ;
					var myOptions 	= 'width=' + window.screen.availwidth + ', height=' + window.screen.availheight + ', resizable=yes' ;
					var myFeatures 	= myBars + ', ' + myOptions ;
					var reportWindow 	= open( retVal, '_blank', myFeatures ) ;
					reportWindow.title= "Medicom Report Viewer" ;
					reportWindow.resizeTo( screen.availWidth, screen.availHeight ) ;
					reportWindow.moveTo( 0,0 ) ;
					reportWindow.focus() ;
							}
					}
					if(function_id != 13) //Added for IN:41808
					{
					retVal 	   = await window.showModalDialog(url, arguments, features);
					}
					clearBean();
					var slate_params = "";
					if(retVal==null || retVal=="" || retVal=="undefined" ||retVal=="null"){
						if(parent.parent.document.forms[0]!=null){
							var formObj1 = parent.parent.document.forms[0];
							if(formObj1.name=="OTSlateForm")
								slate_params=formObj1.params.value;
						}
					if (slate_params=="")
							//alert("Line 627");
						var slate_legend=getLabel("eOT.Slate.Label","OT");
							slate_params = "module_id=OT&function_id=OT_SLATE_JAVA&function_name="+slate_legend+"&function_type=F&menu_id="+menu_id+"&access=NYNNY";
							//top.content.frames[0].location.href = "../../eOT/jsp/OTCommonToolBar.jsp?"+slate_params;
					}
					var msg = getMessage("RECORD_INSERTED","SM");
					if(retVal==null || retVal=="" || retVal=="undefined" ||retVal=="null")
					{
						if(cnt!=0)
						{	cnt=1; }
						if(function_id=="21")
							parent.parent.parent.frames[1].frames[1].document.location.reload();
					}
					else
					{

						if(function_id=="27")
						{
							var formObjslate11=parent.parent.parent.f_tab_frames.f_search.document.SlateSearchForm;
							formObjslate11.cnt_temp.value="N";
							//formObjslate11.color_ind_old.value=formObj.text_color_1.value;
							formObjslate11.operation_flag.value="N";
							formObjslate11.operation_status.value=eval("formObj.oper_status_"+rownum).value;
							formObjslate11.oper_temp_cnt_1.value=cnt;
						}
						else
						{
							var formObjslate11=parent.parent.parent.f_tab_frames.f_search.document.SlateSearchForm;
							formObjslate11.oper_temp_flag.value="Y";
							formObjslate11.oper_temp_cnt.value=cnt;
						}
							if(cnt!=0)
							{
								cnt=0;
							}
						parent.document.location.reload();
					}
					if(function_id!=17)
					{
					//alert(parent.parent.parent.frames[2].name);
				parent.parent.parent.messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num=";
					}
//					top.content.frames[3].location.href = "../../eCommon/jsp/error.jsp?err_num="+ msg;
				}
			}
			//assign the old user id back to sesion variables
			if(function_id=="04" || function_id=="06" || function_id=="07" || function_id=="08" || function_id=="09" || function_id=="10" || function_id=="11" ||  function_id=="32"){
				assignSessionVariables(slate_user_id,"OLD");
			}
			// end of assigning
		}
	}
	 function_id_old=function_id;
} // End of the Function callMenuFunctions
function callSamepage()
        {
		parent.document.location.reload();
		parent.parent.parent.messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num=";
         }
function getFunctionString(url_desc,function_id){
	var function_string = "";
	var checkin_legend = encodeURIComponent(getLabel("eOT.CheckIn.Label","OT"));
	var holdingarea_legend = encodeURIComponent(getLabel("eOT.HoldingArea.Label","OT"));
	var change_holdingarea_legend = encodeURIComponent(getLabel("eOT.ChangeHoldingArea.Label","OT"));
	var checkintoor_legend = encodeURIComponent(getLabel("eOT.CheckIntoOR.Label","OT"))	;
	var checkintorecoveryroom_legend = encodeURIComponent(getLabel("eOT.CheckInToRecoveryRoom.Label","OT"));
	var checkoutfromrecoveryroom_legend = encodeURIComponent(getLabel("eOT.CheckOutFromRecoveryRoom.Label","OT"));
	var checkoutfromward_legend = encodeURIComponent(getLabel("eOT.CheckOutFromWard.Label","OT"));
	var checkoutfromor_legend = encodeURIComponent(getLabel("eOT.CheckOutFromOR.Label","OT"));
	var cancelcheckedincases_legend = encodeURIComponent(getLabel("eOT.CancelCheckedInCases.Label","OT"));
	var patienthistory_legend = encodeURIComponent(getLabel("Common.PatientHistory.label","Common"));
	var cancelbooking_legend = encodeURIComponent(getLabel("Common.CancelBooking.label","common"));
	var consentdetails_legend = encodeURIComponent(getLabel("Common.ConsentDetails.label","Common"));
	var intraanaesthesiadetails_legend = encodeURIComponent(getLabel("eOT.IntraAnaesthesiaDetails.Label","OT"));
	var viewchecklist_legend = encodeURIComponent(getLabel("eOT.ViewCheckList.Label","OT"));
	var linkpreoperativeorders_legend = encodeURIComponent(getLabel("eOT.LinkPreOperativeOrders.Label","OT"));
	if(url_desc.search("OTCheckIn") == 0 && url_desc.search("OTCheckInToOR") != 0 && url_desc.search("CancelCheckedInCases")!=0)
			function_string="&function_id=OT_CHECK_IN&function_name="+checkin_legend;
	else if(url_desc.search("OTHoldingArea") == 0 && function_id != "33")
			function_string="&function_id=OT_HOLDING_AREA&function_name="+holdingarea_legend;
	else if(url_desc.search("OTHoldingArea") == 0 && function_id == "33")
			function_string="&function_id=OT_HOLDING_AREA&function_name="+change_holdingarea_legend+"&function_id_temp="+function_id;
	else if(url_desc.search("OTCheckInToOR") == 0)
			function_string="&function_id=OT_CHECKIN_TO_OR&function_name="+checkintoor_legend;
	else if((url_desc.search("OTCheckOutFromOR") == 0) && function_id == "23")
			function_string="&function_id=OT_CHECKOUT_FROM_OR&function_name="+checkoutfromor_legend;
	else if((url_desc.search("OTChkInRecoveryRoom") == 0) && function_id == "06")
			function_string="&recovery_in_out_flag=CHECK_IN_RECO&function_id=OT_CHECKIN_TO_RECOVERY&function_name="+checkintorecoveryroom_legend;
	else if((url_desc.search("OTChkInRecoveryRoom") == 0) && function_id == "27")
			function_string="&recovery_in_out_flag=CHECK_OUT_RECO&function_id=OT_CHECKOUT_FROM_RECOVERY&function_name="+checkoutfromrecoveryroom_legend;
	else if(url_desc.search("WardChkOut") == 0)
			function_string="&function_id=OT_CHECK_OUT_FROM_WARD&function_name="+checkoutfromward_legend;
	else if(url_desc.search("CancelCheckedInCases") == 0)
			function_string="&function_id=OT_CANCEL_CHECK_IN&function_name="+cancelcheckedincases_legend;
	else if(url_desc.search("OpenChartWrapper") == 0)
			function_string="&function_id=OT_PATIENT_HISTORY&function_name="+patienthistory_legend+"&insert_op=N";
	else if(url_desc.search("BookingDetailFrame") == 0)
			function_string="&function_id=OT_CANCEL_BOOKING&function_name="+cancelbooking_legend;
	else if(url_desc.search("ViewConsentDtls") == 0)
			function_string="&function_id=OT_VIEW_CONSENT&function_name="+consentdetails_legend; // old name was "View Consent Details"
	else if(url_desc.search("IntraAnaesthesia") == 0)
			function_string="&function_id=AT_INTRA_ANAES&function_name="+intraanaesthesiadetails_legend;
	else if(url_desc.search("ViewCheckListDtls") == 0)
		function_string="&function_id=OT_CHECKLIST_DTLS&function_name="+viewchecklist_legend;
	else if(url_desc.search("LinkOrder") == 0)
		function_string="&function_id=OT_LINK_ORDERS&function_name="+linkpreoperativeorders_legend; // old title Link Orders";
	return function_string;
}
async function acceptAndValidateUser(function_id,function_name){
	var dialogHeight= "11" ;  // 7
	var dialogWidth	= "26" ; // 22
	var dialogTop = (window.screen.availHeight-dialogHeight)/3;//"210" ;
	var dialogLeft = (window.screen.availWidth-dialogWidth)/4;// "240" ;
	var center = "1" ;
	var status="no";
	var scroll="no";
    var myBars = 'directories=no;location=no;menubar=no' ;
	var features	= "dialogLeft:" + dialogLeft + ";dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; center: " + center + ";scroll "+scroll+"; status: " + status + "; dialogTop :" + dialogTop+myBars;
	var arguments	= "" ;
	var retVal = await window.showModalDialog("../../eOT/jsp/SlateAuthUserPwd.jsp?function_id="+function_id+"&function_name="+function_name,arguments,features);
	return retVal;
}
function validateUserPwd(){
	var formObj = document.SlateUserPwdForm;
	var mandatory_flag = true;
	//MMS-ME-SCF-0051
	var user_id = (formObj.user_id.value).toUpperCase();
	var pwd = (formObj.password.value).toUpperCase();
	/* Added by lakshmanan for MMS-ME-SCF-0051 (password encryption) */
	var key = CryptoJS.enc.Base64.parse('u/Gu5posvwDsXUnV5Zaq4g==');
	var iv = CryptoJS.enc.Base64.parse('5D9r9ZVzEYYgha93/aUK2w==');
	var encrypted_password = CryptoJS.AES.encrypt(pwd,key,{ mode: CryptoJS.mode.CBC, padding: CryptoJS.pad.Pkcs7, iv: iv});
	/*end (password encryption)*/
	if(formObj.user_id.value==""){
		mandatory_flag = false;
		//alert(getMessage("USER_ID_NOT_BLANK"));
		 var msg = getMessage("CANNOT_BE_BLANK","OT");
		var msgArray = msg.split("&");
		var UserID_value=getLabel("Common.userid.label","common");
		alert(msgArray[0]+UserID_value+msgArray[1]);
		formObj.user_id.focus();
	}else if(formObj.password.value==""){
		mandatory_flag = false;
		alert(getMessage("ENTER_PWD","SM"));	//in messages.js
		formObj.password.focus();
	}
	
	//Added by Gomathi for ML-MMOH-CRF-1844.2 US005 Starts
	var isSSOIntegrationAppl = document.forms[0].isSSOIntegrationAppl.value;
	var login_user_type = document.forms[0].login_user_type.value;
	
	var active_dir_id	= "";
	var appl_user_id	= "";
	var appl_user_paswd	= "";
	var retValApi		= "";
	var lnkd_actv_dir_id		= "";
	if(isSSOIntegrationAppl == 'true' && login_user_type != 'EM'){
		var xmlDoc=""
		var xmlHttp = new XMLHttpRequest()
		xmlStr = "<root><SEARCH  action='getLinkedADUserDetails' loginID=\""+encodeURIComponent(user_id)+"\" /></root>"
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml")
		xmlHttp.open("POST","../../eSM/jsp/SMIntermediate.jsp",false)
		xmlHttp.send(xmlDoc)
		responseText = xmlHttp.responseText
		responseText = trimString(responseText)

		var retVal_arr = responseText.split("~");

		active_dir_id = retVal_arr[0];
		appl_user_id = retVal_arr[1];
		appl_user_paswd = retVal_arr[2];

		if(active_dir_id != ""){

			retValApi = callSingleSignOnAuth('AUTH',formObj.user_id.value,formObj.password.value);
			retValApi = retValApi.split("$!^");
			retValApi = trimString(retValApi[0]);
			
			user_id = appl_user_id;
			pwd = appl_user_paswd;
			encrypted_password = CryptoJS.AES.encrypt(pwd,key,{ mode: CryptoJS.mode.CBC, padding: CryptoJS.pad.Pkcs7, iv: iv});
			login_user_type = "AD";
		}
		else{
			var xmlDoc=""
			var xmlHttp = new XMLHttpRequest()
			xmlStr = "<root><SEARCH  action='getEMUserLinkedToADUserDetails' loginID=\""+encodeURIComponent(user_id)+"\" /></root>"
			xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml")
			xmlHttp.open("POST","../../eSM/jsp/SMIntermediate.jsp",false)
			xmlHttp.send(xmlDoc)
			responseText = xmlHttp.responseText
			responseText = trimString(responseText)

			lnkd_actv_dir_id = responseText;

			if(lnkd_actv_dir_id != "")
			{
				var errors = getMessage('EM_USER_LINKED_TO_AD_USER','SM');
				errors = errors.replace("#",user_id);
				alert(errors);
				document.forms[0].user_id.focus();
				return event.returnValue = false;
			}else{
				login_user_type = "EM";
			}
		}
			
		if(active_dir_id != "" && retValApi != "Success" && login_user_type =='AD'){
				alert("APP-SM0164 "+retValApi);
				window.returnValue='NOT_VALID';
				formObj.password.focus();
			}else{
				if(mandatory_flag==true){
		var xmlDoc = "" ;
		var xmlHttp = new XMLHttpRequest();
		var xmlStr ="<root><SEARCH ";
		xmlStr += " user_id=\""+ user_id + "\" ";
		xmlStr += " password=\""+ encrypted_password + "\" ";
		xmlStr += " function_id=\""+ formObj.function_id.value + "\" ";
		xmlStr += " function_name=\""+ formObj.function_name.value + "\" ";
		xmlStr +=" /></root>";
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open("POST","SlateValidation.jsp?func_mode=validateUserPwd",false);
		xmlHttp.send(xmlDoc);
		var retVal = trimString(xmlHttp.responseText);
		var valid_user_array  = retVal.split("##"); // validuser##userfunctionvalidation
		var valid_user_flag = valid_user_array[0];
		if(retValApi == "Success" && login_user_type =="AD")
		{
			var valid_user_function_flag = valid_user_array[1];
			if(valid_user_function_flag=="N"){
				alert((getMessage("INVALID_USER_FUNCTION","OT"))+", "+formObj.function_name.value);
				window.returnValue='NOT_VALID';
			}else
				window.returnValue=formObj.user_id.value;
			window.close();
		}
		else{
			if(valid_user_flag=="Y"){
			var valid_user_function_flag = valid_user_array[1];
			if(valid_user_function_flag=="N"){
				alert((getMessage("INVALID_USER_FUNCTION","OT"))+", "+formObj.function_name.value);
				window.returnValue='NOT_VALID';
			}else
				window.returnValue=formObj.user_id.value;
			window.close();
		}else if(valid_user_flag=="N"){
			alert(getMessage("INVALID_USER_PASSWORD","SM"));
			window.returnValue='NOT_VALID';
		}
			}
				}
		}
	}
	
	//Added by Gomathi for ML-MMOH-CRF-1844.2 US005 Ends
	else{
	if(mandatory_flag==true){
		var xmlDoc = "" ;
		var xmlHttp = new XMLHttpRequest();
		var xmlStr ="<root><SEARCH ";
		xmlStr += " user_id=\""+ user_id + "\" ";
		xmlStr += " password=\""+ encrypted_password + "\" ";
		xmlStr += " function_id=\""+ formObj.function_id.value + "\" ";
		xmlStr += " function_name=\""+ formObj.function_name.value + "\" ";
		xmlStr +=" /></root>";
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open("POST","SlateValidation.jsp?func_mode=validateUserPwd",false);
		xmlHttp.send(xmlDoc);
		var retVal = trimString(xmlHttp.responseText);
		var valid_user_array  = retVal.split("##"); // validuser##userfunctionvalidation
		var valid_user_flag = valid_user_array[0];
		if(valid_user_flag=="Y"){
			var valid_user_function_flag = valid_user_array[1];
			if(valid_user_function_flag=="N"){
				alert((getMessage("INVALID_USER_FUNCTION","OT"))+", "+formObj.function_name.value);
				window.returnValue='NOT_VALID';
			}else
				window.returnValue=formObj.user_id.value;
			window.close();
		}else if(valid_user_flag=="N"){
			alert(getMessage("INVALID_USER_PASSWORD","SM"));
			window.returnValue='NOT_VALID';
		}
	}
}

}

function hideToolTip(){
  document.getElementById("tooltiplayer").style.visibility = 'hidden';
}

function callMouseOver(obj){
	currClass = obj.className ;
	obj.className = 'OTMENU';
}

function callOnMouseOut(obj){
	obj.className = currClass;
}

function resizeWindow(){
	bodwidth = parent.frames[1].document.body.offsetWidth
	bodheight = parent.frames[1].document.body.offsetHeight
	var x =  event.x;
	var y =  event.y;

	x = x + (document.getElementById("tooltiplayer").offsetWidth)
	y = y + (document.getElementById("tooltiplayer").offsetHeight)

	if(x<bodwidth)
		x = event.x
	else
		x = x - (document.getElementById("tooltiplayer").offsetWidth*2)

	if(y<bodheight || event.y<30){
		y = event.y

	}else if(y>bodheight && event.y<100){
		if(event.y>60 && event.y<100){
			y = event.y-20
	}else if(y>bodheight && event.y<200){
		}else if(event.y>100 && event.y<120){
			y = 80
		}else if(event.y>120 && event.y<140){
			y = 100
		}else if(event.y>140 && event.y<160){
			y = 120
		}else if(event.y>160 && event.y<180){
			y = 140
		}else if(event.y>180 && event.y<200){
			y = 160
		}else if(event.y>180 && event.y<200){
			y = 160
		}else{
			y = event.y
		}
	}else if(y<bodheight || event.y>320){
		y = y - (document.getElementById("tooltiplayer").offsetHeight*2)
	}else{
		y = y - (document.getElementById("tooltiplayer").offsetHeight*2)
	}
	if(y<0)
		y=0;
	y+=document.body.scrollTop
	x+=document.body.scrollLeft

		//alert("x:=="+x)
		//alert("y:=="+y)
		//y=18;

	document.getElementById("tooltiplayer").style.posLeft= x
	document.getElementById("tooltiplayer").style.posTop = y
	document.getElementById("tooltiplayer").style.visibility='visible'
}
function  reasonStatusToolTip(arrMsg){
	var oper_proc_label=getLabel("eOT.RoombedStatus.Label","ot_labels");
	var tab_dat  = "<table id ='tooltiptable1' cellpadding='3' cellspacing=0 border='0' class='BOX' width='100%' height='100%' align='center'>";
	tab_dat     += "<tr>"
	tab_dat     += "<th   nowrap > <B>"+oper_proc_label+ " </B> </a> </th>"
	tab_dat     += "</tr> ";
	tab_dat     += "<tr>"
	tab_dat     += "<td class='label' > "+arrMsg+ "</a> </td>"
	tab_dat     += "</tr> ";
	tab_dat     += "</table> ";
return tab_dat;
//	resizeWindow1();
}
function  reasonToolTip(rownum,call_from){
	var formObj = document.SlateSchSearchResultForm;
	var facilityid=formObj.facilityid.value;
	var appt_ref_num = eval("formObj.appt_ref_num_"+rownum).value;
	var oper_num = eval("formObj.oper_num_"+rownum).value;
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest();
	var xmlStr ="<root><SEARCH ";
	xmlStr +=" /></root>";
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST","OTCommonValidation.jsp?func_mode=multiple_oper_display&appt_ref_num="+appt_ref_num+"&facilityid="+facilityid+"&oper_num="+oper_num+"&call_from="+call_from,false);
	xmlHttp.send(xmlDoc);
	var retVal = trimString(xmlHttp.responseText);
	var arrMsg=retVal;
	var arr=new Array();
	arr=arrMsg.split(",");
	var cou=0;
	var oper_proc_label=getLabel("eOT.OperationsProcedures.Label","ot_labels");
	var tab_dat  = "<table id ='tooltiptable1' cellpadding='3' cellspacing=0 border='0' class='BOX' width='100%' height='100%' align='center'>";
	var id_name_colval  ='';
	if(arr[0]=="" || arr[0]==null){
	id_name_colval  =oper_proc_label;
	}else{
	id_name_colval  = arr[0];
	}
	tab_dat     += "<tr>"
	tab_dat     += "<th   nowrap > <B>"+id_name_colval + " </B> </a> </th>"
	tab_dat     += "</tr> ";

	for( cou=1;cou<arr.length;cou++){
		msg=arr[cou];
		tab_dat     += "<tr>"
		tab_dat     += "<td class='label' > <B>"+msg+ " </B> </a> </td>"
		tab_dat     += "</tr> ";
	}
	tab_dat     += "</table> ";
	//58860
	return tab_dat;
	/*document.getElementById("tooltiplayer1").innerHTML = tab_dat;
	resizeWindow1();*/
	//58860
}

function resizeWindow1(){
	bodwidth = parent.frames[1].document.body.offsetWidth
	bodheight = parent.frames[1].document.body.offsetHeight

	var x =event.x
	var y =  event.y;

	x = x + (document.getElementById("tooltiplayer1").offsetWidth)
	y = y + (document.getElementById("tooltiplayer1").offsetHeight)

	if(x<bodwidth)
		x =event.x
	else
		x = x - (document.getElementById("tooltiplayer1").offsetWidth*1)

	if(y<bodheight){
		 y =event.y
	}else{
		y = y - (document.getElementById("tooltiplayer1").offsetHeight*1)
	}

	y+=document.body.scrollTop
	x+=document.body.scrollLeft

	document.getElementById("tooltiplayer1").style.posLeft= x
	document.getElementById("tooltiplayer1").style.posTop = y
	document.getElementById("tooltiplayer1").style.visibility='visible'
}

function hideToolTip1(){
  document.getElementById("tooltiplayer1").style.visibility = 'hidden';
}

function  indicatorToolTip(rownum){
	var formObj = document.SlateSchSearchResultForm;
	var facilityid=formObj.facilityid.value;
var nodata="No Information";
	var appt_ref_num = eval("formObj.appt_ref_num_"+rownum).value;
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest();
	var xmlStr ="<root><SEARCH ";
	xmlStr +=" /></root>";
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST","OTCommonValidation.jsp?func_mode=slate_order_status&appt_ref_num="+appt_ref_num+"&facilityid="+facilityid,false);
	xmlHttp.send(xmlDoc);
	var retVal = trimString(xmlHttp.responseText);
	var db_msg=retVal
	db_msg=db_msg.replace("[","");
	db_msg=db_msg.replace("]","");
	db_msg=db_msg.replace(",","");
    var currentlocation=getLabel("Common.currentlocation.label","Common");
    var roomno=getLabel("Common.roomno.label","Common");
    var bedno=getLabel("Common.bedno.label","Common");
    var bookingremarks=getLabel("eOT.BookingRemarks.Label","OT");
    var Lastmealtime=getLabel("eOT.Lastmealtime.Label","OT");
    var citizenid=getLabel("eOT.Citizenid.Label","OT");
  	var Orderresultstatus=getLabel("eOT.Orderresultstatus/additionalinformation-forpatientid.Label","OT");
	var msg_arr = db_msg.split("##");
	var patient_id = eval("formObj.patient_id_"+rownum).value;
	var title = Orderresultstatus+patient_id;
	var cou=0;
	var tab_dat  = "<table id ='tooltiptable2' cellpadding='' cellspacing=0 border='0' class='BOX' width='100%' height='100%' align='center'>";
	tab_dat     += "<tr>"
	tab_dat     += "<th  align=left> <B>"+title + "</B></th>"
	tab_dat     += "<th  align=center><a href = javascript:UnTip();><img src='../../eCommon/images/disabled.gif'></a></th>"
	tab_dat     += "</tr> ";
	db_msg=trimString(db_msg);
	if(db_msg !="####"){
		for(i=0;i<msg_arr.length;i++){
		 tab_dat     += "<tr>"
		 tab_dat     += "<td class='label'> "
			var msg_arr2=msg_arr[i].split("!");
			for(k=0;k<msg_arr2.length;k++){
			if (msg_arr2[k]==" Citizen Id :")
			{
				tab_dat += " ,  ";
				tab_dat +="<b>"+citizenid+"</b>";
				tab_dat += ":";
			}
			else if (msg_arr2[k]=="Booking_Remarks ")
			{
				tab_dat +="<b>"+bookingremarks+"</b>";
				tab_dat += ":";
			}else
			{
			tab_dat +=msg_arr2[k];
			}
		}
		tab_dat     +=" </td>"
		tab_dat     += "</tr> ";
		}
	}else
	{
		 tab_dat     += "<tr>"
		 tab_dat     += "<td class='label'> "
	tab_dat +="<b>"+nodata+"</b>";
		 	tab_dat     +=" </td>"
		tab_dat     += "</tr> ";
	}
	tab_dat     += "</table> ";
	return tab_dat;
}
function  indicatorToolTipUnSchCases(rownum){
	var formObj = document.SlateSchSearchResultForm;
//	var db_msg = eval("formObj.order_status_text_"+rownum).value;

var facilityid=formObj.facilityid.value;
	//var db_msg = eval("formObj.order_status_text_"+rownum).value;
	var appt_ref_num = eval("formObj.appt_ref_num_"+rownum).value;
	var order_id = eval("formObj.order_id_"+rownum).value;
	if(appt_ref_num=='') appt_ref_num=order_id;
    var nodata="No Information";

	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest();
	var xmlStr ="<root><SEARCH ";
	xmlStr +=" /></root>";
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST","OTCommonValidation.jsp?func_mode=slate_order_status&appt_ref_num="+appt_ref_num+"&facilityid="+facilityid,false);
	xmlHttp.send(xmlDoc);
	var retVal = trimString(xmlHttp.responseText);
	var db_msg=retVal;
	db_msg=db_msg.replace("[","");
	db_msg=db_msg.replace("]","");
	db_msg=db_msg.replace(",","");

    var currentlocation=getLabel("Common.currentlocation.label","Common");
    var roomno=getLabel("Common.roomno.label","Common");
    var bedno=getLabel("Common.bedno.label","Common");
    var bookingremarks=getLabel("eOT.BookingRemarks.Label","OT");
    var citizenid=getLabel("eOT.Citizenid.Label","OT");
  	var Orderresultstatus=getLabel("eOT.Orderresultstatus/additionalinformation-forpatientid.Label","OT");
	var msg_arr = db_msg.split("##");
	var patient_id = eval("formObj.patient_id_"+rownum).value;
	var title = Orderresultstatus+patient_id;
	var cou=0;
	var tab_dat  = "<table id ='tooltiptable2' cellpadding='' cellspacing=0 border='0' class='BOX' width='100%' height='100%' align='center'>";
	tab_dat     += "<tr>"
	tab_dat     += "<th  align=left> <B>"+title + "</B></th>"
	tab_dat     += "<th  align=center><a href = javascript:UnTip();><img src='../../eCommon/images/disabled.gif'></a></th>" //Added by lakshmi against OT-ICN-31938 on 22/03/2012
	tab_dat     += "</tr> ";
	db_msg=trimString(db_msg);
//Modified by lakshmi against OT-ICN-31938 on 22/03/2012
//if(db_msg !=""){
	if(db_msg !="####"){

	for(i=0;i<msg_arr.length;i++){
		var msg_arr1=msg_arr[i].split("$$");
		 tab_dat     += "<tr>"
		 tab_dat     += "<td class='label'> "
		for(j=0;j<msg_arr1.length;j++){
			var msg_arr2=msg_arr1[j].split("!");
			for(k=0;k<msg_arr2.length;k++){
			//	alert(k+" : "+msg_arr2[k]);
			if(msg_arr2[k]=="Current_Location :")
			{
			tab_dat +="<b>"+currentlocation+"</b>";
			tab_dat += ":";
			}
			else if (msg_arr2[k]=="Room_No :")
			{   tab_dat += " , "
				tab_dat +="<b>"+roomno+"</b>";
				tab_dat += ":";
			}
			else if (msg_arr2[k]=="Bed_No :")
			{   tab_dat += " , ";
				tab_dat +="<b>"+bedno+"</b>";
				tab_dat += ":";
			}else if (msg_arr2[k]==" Citizen Id :")
			{
				tab_dat += " ,  ";
				tab_dat +="<b>"+citizenid+"</b>";
				tab_dat += ":";
			}

			else if (msg_arr2[k]=="Booking_Remarks ")
			{
				tab_dat +="<b>"+bookingremarks+"</b>";
				tab_dat += ":";
			}

			else
			{
			tab_dat +=msg_arr2[k];
			}
		}
		//tab_dat     +=" </B></td>"
		//tab_dat     += "</tr> ";
			}
		//	alert(tab_dat);
			//tab_dat="<tr>"+tab_dat+"</tr>";
		tab_dat     +=" </td>"
		tab_dat     += "</tr> ";

		}
	}
	else
	{
		 tab_dat     += "<tr>"
		 tab_dat     += "<td class='label'> "
	tab_dat +="<b>"+nodata+"</b>";
		 	tab_dat     +=" </td>"
		tab_dat     += "</tr> ";
	}
		tab_dat     += "</table> ";
return tab_dat;
//	document.getElementById("tooltiplayer2").innerHTML = tab_dat;
//	resizeWindow2();
}

function resizeWindow2(){
	bodwidth = parent.frames[1].document.body.offsetWidth;
	bodheight = parent.frames[1].document.body.offsetHeight
	var x =event.x
	var y =  event.y;

	x = x + (document.getElementById("tooltiplayer2").offsetWidth)
	y = y + (document.getElementById("tooltiplayer2").offsetHeight)

	if(x<bodwidth)
		x =event.x
	else
		x = x - (document.getElementById("tooltiplayer2").offsetWidth*1)

	if(y<bodheight){
		 y =event.y
	}else{
		y = y - (document.getElementById("tooltiplayer2").offsetHeight*1)
	}
	y+=document.body.scrollTop
	x+=document.body.scrollLeft
	document.getElementById("tooltiplayer2").style.posLeft=x
	document.getElementById("tooltiplayer2").style.posTop = y
	document.getElementById("tooltiplayer2").style.visibility='visible'
}

function hideToolTip2(){
  document.getElementById("tooltiplayer2").style.visibility = 'hidden';
}

function lockKey(){
    if(event.keyCode == 93)
        alert(getMessage("APP-OT0084","OT"));
}


function  reasonToolTip3(stvar,indx,call_frm){
	var arr=new Array();
	var frmObj=document.forms[0];
	var facilityid=frmObj.facilityid.value;
	var oper_num = eval("frmObj.oper_num_"+indx).value;
	var case_called_time="";
	var check_out_from_ward_time="";
	var rescheduled_count ="";
	var order_id =eval("frmObj.order_id_"+indx).value; // Added for ML-MMOH-SCF-0406

	if(call_frm =="sch_case")
	{
	 case_called_time = eval("frmObj.case_called_time_"+indx).value;
	 check_out_from_ward_time = eval("frmObj.check_out_from_ward_time_"+indx).value;
	 rescheduled_count = eval("frmObj.rescheduled_count_"+indx).value;
}
	var called_from="SCH";
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest(); 
	var xmlStr ="<root><SEARCH ";
	xmlStr +=" /></root>";
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST","OTCommonValidation.jsp?func_mode=status_display_tooltip&oper_num="+oper_num+"&facilityid="+facilityid+"&called_from="+called_from+"&case_called_time="+case_called_time+"&check_out_from_ward_time="+check_out_from_ward_time+"&rescheduled_count="+rescheduled_count+"&order_id="+order_id,false); // order_id Added for ML-MMOH-SCF-0406
	xmlHttp.send(xmlDoc);
	var retVal = trimString(xmlHttp.responseText);
	var arrMsg=retVal;
	arr=arrMsg.split(",");
	var cou=0;
	var tab_dat  = "<table id ='tooltiptable3' cellpadding='3' cellspacing=0 border='0' class='BOX' width='100%' height='100%' align='center'>";
	for( cou=0;cou<arr.length;cou++)
	{
			msg=arr[cou];
			tab_dat     += "<tr>"
			tab_dat     += "<td class='label' >"+msg+"</td>"
			tab_dat     += "</tr> ";
	}
			tab_dat     += "</table> ";
	//58860
	return tab_dat;
	/*document.getElementById("tooltiplayer3").innerHTML = tab_dat;
	resizeWindow3();*/
	//58860
}

function resizeWindow3(){
	bodwidth =parent.frames[1].document.body.offsetWidth-300;
	bodheight = parent.frames[1].document.body.offsetHeight-300;

	var x =event.x-300;
	var y =event.y-300;

	x = x + (document.getElementById("tooltiplayer3").offsetWidth)
	y = y + (document.getElementById("tooltiplayer3").offsetHeight)

	if(x<bodwidth)
		x =event.x
	else
		x = x - (document.getElementById("tooltiplayer3").offsetWidth*1)
	 y =event.y

	y+=document.body.scrollTop
	x+=document.body.scrollLeft

	document.getElementById("tooltiplayer3").style.posLeft= x
	document.getElementById("tooltiplayer3").style.posTop = y
	document.getElementById("tooltiplayer3").style.visibility='visible'
}
function hideToolTip3(){
  document.getElementById("tooltiplayer3").style.visibility = 'hidden';
}

function clearSlateResultsPage(){
	//alert(parent.parent.frames[1].frames[1].name);
	parent.parent.messageFrame.location.href = "../../eCommon/jsp/error.jsp";
	var formObj = document.SlateSearchForm;
	searchSlate();
	//alert("userrole"+formObj.user_role.value);
	//searchSlate();
	  //parent.parent.frames[1].frames[1].location.href="../../eCommon/html/blank.html";
}

async function searchSurgeonslate(obj)
{	
	var result		=	false ;
	var message		=	"" ;
	var flag		=	"" ;
	var function_id = "";
	var argumentArray  = new Array();
	var dataNameArray  = new Array();
	var dataValueArray = new Array();
	var dataTypeArray  = new Array();
	var obj1=document.forms[0];
	var sql="";

	//	var sql= "SELECT SHORT_NAME DESCRIPTION,PRACTITIONER_ID CODE FROM AM_PRACTITIONER_LANG_VW WHERE LANGUAGE_ID = '"+obj1.locale.value+"' AND PRACT_TYPE IN ('MD','SG') AND NVL(EFF_STATUS,'X') <> 'S' AND upper(SHORT_NAME) like upper(?) AND upper(PRACTITIONER_ID) like upper(?) order by 2";

	//	var sql= "SELECT SHORT_NAME DESCRIPTION,PRACTITIONER_ID CODE FROM AM_PRACTITIONER_LANG_VW WHERE LANGUAGE_ID = '"+obj1.locale.value+"' AND PRACT_TYPE IN (SELECT PRACT_TYPE FROM OT_PRACT_TYPES_FOR_ROLE_TYPE WHERE ROLE_TYPE ='OS') AND NVL(EFF_STATUS,'X') <> 'S' AND upper(SHORT_NAME) like upper(?) AND upper(PRACTITIONER_ID) like upper(?) order by 2";

	if((obj1.speciality.value == null) || (obj1.speciality.value ==''))
	var sql= " SELECT SHORT_NAME DESCRIPTION,PRACTITIONER_ID CODE FROM AM_PRACTITIONER_LANG_VW WHERE LANGUAGE_ID = '"+obj1.locale.value+"' AND PRACT_TYPE IN (SELECT PRACT_TYPE FROM OT_PRACT_TYPES_FOR_ROLE_TYPE WHERE ROLE_TYPE ='OS') AND NVL(EFF_STATUS,'X') != 'S'  AND upper(SHORT_NAME) like upper(?)  AND upper(PRACTITIONER_ID) like upper(?) order by 2";
	

	if((obj1.speciality.value != null) && (obj1.speciality.value !=''))
	sql  = "SELECT SHORT_NAME DESCRIPTION,PRACTITIONER_ID CODE FROM AM_PRACTITIONER_LANG_VW WHERE LANGUAGE_ID = '"+obj1.locale.value+"' AND PRACT_TYPE IN (SELECT PRACT_TYPE FROM OT_PRACT_TYPES_FOR_ROLE_TYPE WHERE ROLE_TYPE ='OS') AND NVL(EFF_STATUS,'X') != 'S'  AND (PRACTITIONER_ID IN (SELECT PRACTITIONER_ID FROM AM_PRACT_SPECIALITIES WHERE FACILITY_ID ='"+obj1.facility_id.value+"' AND SPECIALITY_CODE = '"+obj1.speciality.value+"') OR PRIMARY_SPECIALITY_CODE='"+obj1.speciality.value+"') AND upper(SHORT_NAME) like upper(?) AND upper(PRACTITIONER_ID) like upper(?) order by 2";

	argumentArray[0] = sql;
	argumentArray[1] = dataNameArray;
	argumentArray[2] = dataValueArray;
	argumentArray[3] = dataTypeArray;
//	argumentArray[4] = "1,2"; Modified By Rajesh For Lookup Issue
	argumentArray[4] = "2,1";
	argumentArray[5] = obj.value;
	//alert("obj.value"+obj.value);
	argumentArray[6] = DESC_LINK;
	argumentArray[7] = DESC_CODE;

	returnedValues = await CommonLookup(getLabel("Common.Surgeon.label","Common"),argumentArray );
	if((returnedValues != null) && (returnedValues != "") )  {
		var ret1=unescape(returnedValues);
		 	arr=ret1.split(",");
		document.forms[0].surgeon_name.value = arr[1];
	document.forms[0].surgeon.value = arr[0];

	}
else
	{
		nationality_code.value = arr[0]; 
			nationality_desc.value = arr[1]; 
			desc.value=arr[1];
			code.value=arr[0];
	document.forms[0].surgeon_name.value = '';
	document.forms[0].surgeon.value = '';

		//obj.value = returnedValues[1];
	}
}

function assignSessionVariables(slate_user_id,stage){
	var form_jsp = "";
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest();
	var xmlStr ="<root><SEARCH ";
	xmlStr += " slate_user_id=\""+ slate_user_id + "\" ";
	xmlStr += " /></root>";
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	if(stage=="NEW")
		form_jsp = "SelectNoteTypeSetUserAttribute.jsp?slate_user_id="+slate_user_id;
	else
		form_jsp = "SelectNoteTypeSetOldUserAttribute.jsp?slate_user_id="+slate_user_id;
	xmlHttp.open("POST",form_jsp,false);
	xmlHttp.send(xmlDoc);
	//trimString(xmlHttp.responseText);
	}

//Added newly by rajesh for SPR-6073 on 05/11/2008

function getPatientName(patient_id){
var sql="select patient_name  from mp_patient where patient_id='"+patient_id+"' ";
var param="sql="+sql;
var xmlDoc = "";
var xmlHttp = new XMLHttpRequest();
var xmlStr="<root></root>";
xmlDoc.loadXML(xmlStr);
xmlHttp.open("POST", "../../servlet/eOT.CommonQueryServlet?"+param,false);
xmlHttp.send(xmlDoc);;
var return_val=xmlHttp.responseText;
var rtn_val=eval(return_val);
return rtn_val;
}

function rescheduleCount(ref_no,patient_id)
{
var pat_name=getPatientName(patient_id);
var patient_name2=pat_name.replace("'","");//049840
var sql="select NVL(RESCHEDULED_COUNT,0)  from OT_BOOKING_HDR where BOOKING_NUM ='"+ref_no+"'";
var param="sql="+sql;
var xmlDoc = "";
var xmlHttp = new XMLHttpRequest();
var xmlStr="<root></root>";
xmlDoc.loadXML(xmlStr);
xmlHttp.open("POST", "../../servlet/eOT.CommonQueryServlet?"+param,false);
xmlHttp.send(xmlDoc);;
var resTxt=xmlHttp.responseText;
var cou=eval(resTxt);
var count=parseInt(cou,10);
count=count+1;
var suffix = "";
if(count==1)
	suffix = "st";
else if(count==2)
	suffix = "nd";
else if(count==3)
	suffix = "rd";
else
	suffix = "th";
if(count == 1 || count > 1){
	//alert("This patient is being rescheduled for "+count+suffix+" time.");
	var msg_1 = getMessage("APP-OT0081","OT");
	var msgArr=msg_1.split("$");
	var msgArray = msgArr[1].split("&");
	alert(msgArr[0]+" "+patient_name2+" ("+patient_id+") "+msgArray[0]+count+suffix+msgArray[1])//049840
	//APP-OT0081 & This patient is being rescheduled for & time
//	alert(msgArray[0]+count+suffix+msgArray[1]);
}
}

function setAssignValue(dat){
	return dat.replace("'","");
}

//Newly added for Amazon Changes......

function hideToolTip(obj,imgObj,row)
	{
		dynamichide(obj, window.event,row);
	}


	function callMouseOver(obj)	{
		currClass = obj.className ;
		obj.className = 'selectedcontextMenuItem';

	}

	function callOnMouseOut(obj){
		obj.className = 'contextMenuItem';
	}


	function resizeWindow(orderctlHDR)
	{
	    var orderctlHDR1 = orderctlHDR.id;
		//alert("orderctlHDR1--->"+orderctlHDR1)
		/*var wdth = eval("document.all."+orderctlHDR1).offsetWidth;
		var hght1 = eval("document.all."+orderctlHDR1).offsetHeight;*/
		
		var wdth = document.getElementById(orderctlHDR1).offsetWidth;
		var hght1 = document.getElementById(orderctlHDR1).offsetHeight;

		var wdth1 = getPos(orderctlHDR).x +wdth;
		var hght = getPos(orderctlHDR).y ;

		bodwidth  = document.body.offsetWidth
		bodheight = document.body.offsetHeight

		var z = bodwidth- (event.x + wdth);

		var x 	  = event.x;
		var y 	  = event.y;

		x 	  = x + (document.getElementById("tooltiplayer").offsetWidth);
		y 	  = hght + (document.getElementById("tooltiplayer").offsetHeight);

		if(x<bodwidth){
			x= wdth1;
		}else{
			x = getPos(orderctlHDR).x;
		}
		/*if(y<bodheight){
			y = hght;

		}else
		{
			y = y - (document.getElementById("tooltiplayer").offsetHeight*2) + hght1 ;
		}*/
		y = hght;
		document.getElementById("tooltiplayer").style.posLeft= x;
		document.getElementById("tooltiplayer").style.posTop = y;
		document.getElementById("tooltiplayer").style.visibility='visible'
	}

function callMouseOverOnTD(obj,imgObj){
	        //alert("obj.id--->"+obj.id)
		 if (prevObjID != null && prevObjID != obj.id)
		 {
			 /*eval("document.all."+prevObjID).className = 'gridDataBlue';
			 eval("document.all."+prevImgObj).src = "../../eCommon/images/inactiveArrow.gif";*/
			 document.getElementById(prevObjID).className = 'gridDataBlue';
			 document.getElementById(prevImgObj).src = "../../eCommon/images/inactiveArrow.gif";
		 }
		obj.className = 'selectedTDData';
		//eval("document.all."+imgObj).src = "../../eCommon/images/activeArrow.gif";
		document.getElementById(imgObj).src = "../../eCommon/images/activeArrow.gif";
		prevObjID = obj.id;
		prevImgObj = imgObj;
	}

	function getPos(inputElement) {
    var coords =  new Object();
    coords.x = 0;
    coords.y = 0;
    try {
        targetElement = inputElement;
        if(targetElement.x && targetElement.y) {
            coords.x = targetElement.x;
            coords.y = targetElement.y;
        } else {
            if(targetElement.offsetParent) {
                coords.x += targetElement.offsetLeft;
                coords.y += targetElement.offsetTop;
                while(targetElement = targetElement.offsetParent) {
                    coords.x += targetElement.offsetLeft;
                    coords.y += targetElement.offsetTop;
                }
            } else {
                //alert("Could not find any reference for coordinate positioning.");
            }
        }
        return coords;
    } catch(error) {
        //alert(error.msg);
        return coords;
    }
}

function dynamichide(m, e,row)
	{
		if (!this.isContained(m, e))
		{
			this.delayhidemenu(row)
		}
	}

	function isContained(m, e)
	{   //alert("1655")
		//alert(m,e)
		var e=window.event || e
		var c=e.relatedTarget || ((e.type=="mouseover")? e.fromElement : e.toElement)
		while (c && c!=m)try {c=c.parentNode} catch(e){c=m}
		if (c==m)
			return true;
		else
			return false;
	}

	function delayhidemenu(row)
	{

		/*this.delayhide=setTimeout("hidemenu()", this.disappeardelay) //hide menu
		if(eval("document.getElementById("orderctl")"+row))
			eval("document.getElementById("orderctl")"+row).className='gridDataBlue';
		if(eval("document.getElementById("imgArrow")"+row))
			eval("document.getElementById("imgArrow")"+row).src = "../../eCommon/images/inactiveArrow.gif";
		*/
		if (document.getElementById(`orderctl${row}`)) {
    document.getElementById(`orderctl${row}`).className = 'gridDataBlue';
}
if (document.getElementById(`imgArrow${row}`)) {
    document.getElementById(`imgArrow${row}`).src = "../../eCommon/images/inactiveArrow.gif";
}

	}

	function hidemenu()
	{
		document.getElementById("tooltiplayer").style.visibility = 'hidden';
	}
//Amazon Changes Ends Here....


function moreCriteria(){

	var frmObj=document.forms[0];
	var expand_flag=frmObj.more_Less_Criteria_Flag.value;
	if(expand_flag=="Y"){
		//parent.document.getElementById("tab_frame").rows="33%,*"; //commented on 2/14/2011 by anitha for satya sai changes
		parent.document.getElementById("tab_frame").rows="38%,*";
		parent.frames[0].document.getElementById("moreCriteria").style.display='Inline';
		frmObj.more_Less_Criteria_Flag.value="N";
		frmObj.img_src.src="../../eOT/images/ShowLess.gif";
		}else if(expand_flag=="N"){
	//parent.document.getElementById("tab_frame").rows="26%,*"; //commented on 2/14/2011 by anitha for satya sai changes
	parent.document.getElementById("tab_frame").rows="30%,*";
	parent.frames[0].document.getElementById("moreCriteria").style.display='none';
	frmObj.more_Less_Criteria_Flag.value="Y";
	frmObj.img_src.src="../../eOT/images/ShowMore.gif";
	}

}

function checkForSpecCharsforID(event)
{
    var strCheck = '0123456789/';
    var whichCode = (window.Event) ? event.which : event.keyCode;
    key = String.fromCharCode(whichCode);  // Get key value from key code
    if (strCheck.indexOf(key) == -1) return false;  // Not a valid key
	if( (event.keyCode >= 97) && (event.keyCode <= 122) )
	return (event.keyCode -= 32);
	return true ;
}


function compareDate(fromdate,todate) {
    var fromarray; var toarray;
	var flag=true;
    if(fromdate.length > 0 && todate.length > 0 ) {
			var from_date_array = fromdate.split(" ");
			var from_date = from_date_array[0];
			var to_date_array = todate.split(" ");
			var to_date = to_date_array[0];
	        var fromdatearray = from_date.split("/");
            var todatearray = to_date.split("/");
			var fromdt = new Date(fromdatearray[2],fromdatearray[1],fromdatearray[0]);
            var todt = new Date(todatearray[2],todatearray[1],todatearray[0]);
			//alert(new Date(2004,11,24,23,11)); is the format used above yyyy,mm,dd,hh24,mi
			if(Date.parse(todt) > Date.parse(fromdt)) {
                flag=false;
            }
    }
	return flag;
}


function extractResultFrame(){
	var frmObj=document.forms[0];
	var view_by = frmObj.search_page_view_by.value;
	var expand_flag = frmObj.more_Less_result_Flag.value;
	if(expand_flag=="N"){
		parent.document.getElementById("SlateSearchResultsFrame").rows="0%,10%,68%,2%";
		frmObj.more_Less_result_Flag.value="Y";
		frmObj.img_src_res.src="../../eOT/images/gripper1.gif";
	}else if(expand_flag=="Y"){
		parent.document.getElementById("SlateSearchResultsFrame").rows="0%,40%,41%,2%";
		frmObj.more_Less_result_Flag.value="N";
		frmObj.img_src_res.src="../../eOT/images/gripper.gif";
	}
}

function extractResultUnschFrame(){
	var frmObj=document.forms[0];
	var view_by = frmObj.search_page_view_by.value;
	var expand_flag = frmObj.more_Less_result_Flag.value;

	if(expand_flag=="N"){
		parent.document.getElementById("SlateSearchResultsFrame").rows="0%,68%,10%,2%";
		frmObj.more_Less_result_Flag.value="Y";
		frmObj.img_src_res.src="../../eOT/images/gripper.gif";
	}else if(expand_flag=="Y"){
		parent.document.getElementById("SlateSearchResultsFrame").rows="0%,40%,41%,2%";
		frmObj.more_Less_result_Flag.value="N";
		frmObj.img_src_res.src="../../eOT/images/gripper1.gif";
	}
}

function expandColorInd()
{
	var formObj=document.forms[0];
	var min_max_val=formObj.min_max_val.value;	
	var view_by = formObj.search_page_view_by.value;	
	
	//IN055102 start
	var ot_sch_dtls_flag=formObj.ot_sch_dtls_flag.value;
	var ot_unsch_dtls_flag=formObj.ot_unsch_dtls_flag.value;
	//IN055102 end
	
	if(min_max_val=="Y" && view_by=="A" && ot_sch_dtls_flag=="true" && ot_unsch_dtls_flag=="true"){//IN055102
		parent.parent.frames[1].frames[4].document.getElementById("moreCriteria").style.display='Inline';
		parent.document.getElementById("SlateSearchResultsFrame").rows="0%,35%,36%,12%";
		formObj.img_src.src="../../eOT/images/gripper1.gif";
		formObj.min_max_val.value="N";
		}else if(min_max_val=="N" && view_by=="A" && ot_sch_dtls_flag=="true" && ot_unsch_dtls_flag=="true"){//IN055102
		parent.parent.frames[1].frames[4].document.getElementById("moreCriteria").style.display='none';
		parent.document.getElementById("SlateSearchResultsFrame").rows="0%,40%,41%,2%";
		formObj.img_src.src="../../eOT/images/gripper.gif";
		formObj.min_max_val.value="Y";
	}else if(min_max_val=="Y" && (view_by=="S" || (view_by=="A" && ot_sch_dtls_flag=="true" && ot_unsch_dtls_flag=="false"))){//IN055102
		parent.parent.frames[1].frames[2].document.getElementById("moreCriteria").style.display='Inline';
		parent.document.getElementById("SlateSearchResultsFrame").rows="0%,68%,12%";
		formObj.img_src.src="../../eOT/images/gripper1.gif";
		formObj.min_max_val.value="N";
		}else if(min_max_val=="N" && (view_by=="S" || (view_by=="A" && ot_sch_dtls_flag=="true" && ot_unsch_dtls_flag=="false"))){//IN055102
		parent.parent.frames[1].frames[2].document.getElementById("moreCriteria").style.display='none';
		parent.document.getElementById("SlateSearchResultsFrame").rows="0%,68%,2%";
		formObj.img_src.src="../../eOT/images/gripper.gif";
		formObj.min_max_val.value="Y";
	}else if(min_max_val=="Y" && (view_by=="U" || (view_by=="A" && ot_sch_dtls_flag=="false" && ot_unsch_dtls_flag=="true"))){//IN055102
		parent.parent.frames[1].frames[2].document.getElementById("moreCriteria").style.display='Inline';
		parent.document.getElementById("SlateSearchResultsFrame").rows="0%,68%,12%";
		formObj.img_src.src="../../eOT/images/gripper1.gif";
		formObj.min_max_val.value="N";
		}else if(min_max_val=="N" && (view_by=="U" || (view_by=="A" && ot_sch_dtls_flag=="false" && ot_unsch_dtls_flag=="true"))){//IN055102
		parent.parent.frames[1].frames[2].document.getElementById("moreCriteria").style.display='none';
		parent.document.getElementById("SlateSearchResultsFrame").rows="0%,68%,2%";
		formObj.img_src.src="../../eOT/images/gripper.gif";
		formObj.min_max_val.value="Y";
	}
}
 /*This method added by venkatesh.s against RUT-CRF-0083.4[IN041509] on 27-aug-2013*/
function external_doc(pat_id)
	{
		if(pat_id=='pat'){
			var  size= parent.f_query_add_mod.f_sch_cases_frame.document.forms[0].size.value;
	     for(var i=1;i<=size;i++){
			var file 				=eval("parent.f_query_add_mod.f_sch_cases_frame.document.forms[0].imgArrow"+i+".src");
			finename				=file.replace(/^.*[\\\/]/, '');
			if(finename=="activeArrow.gif"){
				var patient_id			=eval("parent.f_query_add_mod.f_sch_cases_frame.document.forms[0].patient_id_"+i+".value");
				var login_user			=parent.f_query_add_mod.f_sch_cases_frame.document.forms[0].login_user.value;
				var appt_date			=eval("parent.f_query_add_mod.f_sch_cases_frame.document.forms[0].appt_date"+i+".value");
				var order_id			=eval("parent.f_query_add_mod.f_sch_cases_frame.document.forms[0].order_id_"+i+".value");
				var episod_id			=eval("parent.f_query_add_mod.f_sch_cases_frame.document.forms[0].episod_id_"+i+".value");
				var patient_clss=eval("parent.f_query_add_mod.f_sch_cases_frame.document.forms[0].patient_class_"+i+".value");
				var current_locn	 	 =eval("parent.f_query_add_mod.f_sch_cases_frame.document.forms[0].current_locn_"+i+".value");
				var surgeon_code	    =eval("parent.f_query_add_mod.f_sch_cases_frame.document.forms[0].surgeon_code_"+i+".value");
				var facily_id			=eval("parent.f_query_add_mod.f_sch_cases_frame.document.forms[0].facility_id.value");
				var resp_id			 =eval("parent.f_query_add_mod.f_sch_cases_frame.document.forms[0].resp_id.value");
				var module_id			=eval("parent.f_query_add_mod.f_sch_cases_frame.document.forms[0].p_module_id.value");
				var language_id			=eval("parent.f_query_add_mod.f_sch_cases_frame.document.forms[0].language_id.value");
				var encounter_date		="";
				var accession_num 		= "";
				var order_type_code		="";
				var locn_type			="";
				var cust_code			="";
				var item_code			="";
				var inv_org_id			="";
				var function_id			="";
				var access_rights		="";
				var multi_site_yn		="";
				var multi_lang_yn		="";
				var ws_no				="";
				var ext_input_key		="";
				var ext_application_id	="";
				var dms					="";
				var ext_function		="";
				var view				="";
				var pwd					="";
				var connect_string		="";
				var param="P_USE_ID="+login_user+"&P_PATIENT_ID="+patient_id+"&P_ORDER_ID="+order_id+"&P_LOCN_CODE="+current_locn+"&P_PHYSICIAN_ID="+surgeon_code+"&P_FACILITY_ID="+facily_id+"&P_RESP_ID="+resp_id+"&P_MODULE_ID="+module_id+"&P_ENCNTR_DATE="+encounter_date+"&P_EPISODE_TYPE="+patient_clss+"&P_EPISODE_ID="+episod_id+"&P_ACCESSION_NUM="+accession_num+"&P_ORDER_TYPE_CODE="+order_type_code+"&P_LOCN_TYPE="+locn_type+"&P_CUST_CODE="+cust_code+"&P_ITEM_CODE="+item_code+"&P_INV_ORG_ID="+inv_org_id+"&P_FUNCTION_ID="+function_id+"&P_ACCESS_RIGHTS="+access_rights+"&P_LANGUAGE_ID="+language_id+"&P_MULTI_SITE_YN="+multi_site_yn+"&P_MULTI_LANG_YN="+multi_lang_yn+"&P_WS_NO="+ws_no+"&P_Ext_Input_Key="+ext_input_key+"&P_Ext_Application_ID="+ext_application_id+"&DMS="+dms+"&P_Ext_Function="+ext_function+"&VIEW="+view+"&P_pwd="+pwd+"&P_Connect_string="+connect_string;
				/*var xmlStr ="<root><SEARCH ";
				xmlStr +=" /></root>";
				var temp_jsp ="../../servlet/eXH.InvokeExternalApplication?"+param;
				var xmlDoc   = new ActiveXObject( "Microsoft.XMLDom" ) ;
				var xmlHttp  = new ActiveXObject( "Microsoft.XMLHTTP" ) ;
				xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
				xmlHttp.open("POST",temp_jsp,false);
				xmlHttp.send(xmlDoc);
				responseText=trimString(xmlHttp.responseText);
			*/
				/* Modified by Dharma for external link changes*/
				dispExtApp(param);
			}
	 }}}

//Added for the incident - 45354
function localTrimString(sInString) {
   return sInString.replace(/^\s+|\s+$/g,"");
}
// GHL-CRF 356.1
function validateCurrLocation(location,booking_num, facility_id, order_id, patient_id)
{
	if(location==null || location=="")
	{
		var xmlDoc = "" ;
		var xmlHttp = new XMLHttpRequest() ;
		var xmlStr ="<root><SEARCH ";
		xmlStr +=" /></root>";
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		var params="booking_no="+booking_num+"&facility_id="+facility_id+"&patient_id="+patient_id+"&mode=&orderid="+order_id;
		xmlHttp.open("GET","../../eOT/jsp/BookingValidation.jsp?"+params,false);
		xmlHttp.send(xmlDoc);
		var retVal = trimString(xmlHttp.responseText);
		var pt_array  = retVal.split("##");
		if(pt_array[1] == "A")
		{
			alert(pt_array[2]);
			return false;
		}//051274
		if(pt_array[0] == "E")
		{
			alert(getMessage(pt_array[2]))
			return false;
		}
		else
		{
			if(pt_array[1] == "S")
			{
				alert(pt_array[2]);
				return false;
			}
			if(pt_array[1] == "M")
				alert(pt_array[2]);
			if(pt_array[1] == "M_SPLIT")
			{
				var msg_arr = pt_array[3].split("$$"); // pt_array[3] is a message comes from procedure in the following format
				var lang_msg = getMessage(msg_arr[0],"OT"); // get bundle message msg_arr[0] can be either PRC-OT0025 or PRC-OT0026
				var lang_msg_arr_1 = lang_msg.split("#"); // splits the bundle message till #
				var disp_msg1 = lang_msg_arr_1[0]+msg_arr[1]; // Concatenate with msg_arr[1], which is the OLD_ENCOUNTER_ID coming from procedure.
				var lang_msg_arr_2 = lang_msg_arr_1[1].split("$"); // Split the remaining bundle message with $
				var disp_msg2 = lang_msg_arr_2[0]+msg_arr[2]; // Concatenate with msg_arr[2], which is the NEW_ENCOUNTER_ID coming from procedure.
				var lang_msg_display = disp_msg1 + disp_msg2; // Merge both splitted messages and display the alert
				alert(lang_msg_display);
				return true;
			}
			return true;
		}//051274
	}
}

//IN052054 start
function clickSearch()
{
	var calledFrom = document.forms[0].calledFrom.value;
	var userRole = document.forms[0].user_role.value;
	if(userRole != '')
		document.forms[0].Search.click();
}

function resetPage()
{
	window.location.reload();
	parent.f_query_add_mod.document.location.href="../../eCommon/html/blank.html";
}
//IN052054 end

//Added by Gaurav against ML-MMOH-CRF-1791-US04...starts

function  reasonToolTip4(stvar,indx,call_frm){
	var arr=new Array();
	var frmObj=document.forms[0];
	var facilityid=frmObj.facilityid.value;
	var oper_num = eval("frmObj.oper_num_"+indx).value;
	var case_called_time="";
	var check_out_from_ward_time="";
	var rescheduled_count ="";
	var order_id =eval("frmObj.order_id_"+indx).value; 
	var patient_id =eval("frmObj.patient_id_"+indx).value; 	
	if(call_frm =="sch_case")
	{
	 case_called_time = eval("frmObj.case_called_time_"+indx).value;
	 check_out_from_ward_time = eval("frmObj.check_out_from_ward_time_"+indx).value;
	 rescheduled_count = eval("frmObj.rescheduled_count_"+indx).value;
}
	var called_from="SCH";
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest(); 
	var xmlStr ="<root><SEARCH ";
	xmlStr +=" /></root>";
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml"); 
	xmlHttp.open("POST","OTCommonValidation.jsp?func_mode=reschedule_display_tooltip&oper_num="+oper_num+"&facilityid="+facilityid+"&called_from="+called_from+"&case_called_time="+case_called_time+"&check_out_from_ward_time="+check_out_from_ward_time+"&rescheduled_count="+rescheduled_count+"&order_id="+order_id+"&patient_id="+patient_id,false); // order_id Added for ML-MMOH-SCF-0406
	xmlHttp.send(xmlDoc);
	var retVal = trimString(xmlHttp.responseText);
	if(retVal != "SCHEDULED"){
	var tab_dat  = "<table id ='tooltiptable1' cellpadding='3' cellspacing=0 border='0' class='BOX' width='100%' height='100%' align='center'>";
	tab_dat += retVal;
	tab_dat += "</table>";
	return tab_dat;
	}
}
//Added by Gaurav against ML-MMOH-CRF-1791-US04...ends

function checkADAndEMUserYN(obj){ //Added by Gomathi against ML-MMOH-CRF-1844.2 US005
	var loginID = trimString(obj);
	var xmlDoc=""
	var xmlHttp = new XMLHttpRequest()
	xmlStr = "<root><SEARCH  action='getADAndEMUserYN' loginID=\""+encodeURIComponent(loginID)+"\" /></root>"
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml")
	xmlHttp.open("POST","../../eSM/jsp/SMIntermediate.jsp",false)
	xmlHttp.send(xmlDoc)
	responseText = xmlHttp.responseText
	responseText = trimString(responseText)
	if(responseText == 'Y'){
		if(confirm(getMessage("LOGIN_AS_AD_OR_EM_USER","SM"))){
			document.forms[0].login_user_type.value = 'AD';
		}else{
			document.forms[0].login_user_type.value = 'EM';
		}
	}
}

