/*
*Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
* 
*Warning: This computer program is protected by copyright law and international treaties.
*Unauthorized reproduction or distribution of this program, or any portion of it, 
*may result in severe civil and criminal penalties, and will be prosecuted to 
*the maximum extent possible under the law.
*/
function create(){
	f_query_add_mod.location.href = "../../eSS/jsp/IssueGroupFrame.jsp?mode="+MODE_INSERT+"&function_id="+function_id ;
}

function query(){
	f_query_add_mod.location.href="../../eSS/jsp/IssueGroupQueryMain.jsp?mode="+MODE_MODIFY+"&function_id="+function_id;
}

function onSuccess(){
	var mode = f_query_add_mod.frameIssueGroupHeader.document.formIssueGroupHeader.mode.value;
	var Re_Issue = f_query_add_mod.frameIssueGroupHeader.document.formIssueGroupHeader.Re_Issue.value;
	if( mode == MODE_INSERT ) {
		reset();
	}else{
		//create();
		if(Re_Issue=="Confirm"){
		alert(message);
		//window.close();
		let dialogBody = parent.document.getElementById('dialog-body');
		dialogBody.contentWindow.returnValue = formObject.remarks.value;
		const dialogTag = parent.document.getElementById("dialog_tag");    
        dialogTag.close();
		}else{
		f_query_add_mod.frameIssueGroupHeader.document.location.href="../../eCommon/html/blank.html";
		f_query_add_mod.frameIssueGroupList.document.location.href="../../eCommon/html/blank.html";
		f_query_add_mod.frameIssueGroupDetail.document.location.href="../../eCommon/html/blank.html";
		}
		
	}
}

function reset() {
	if(f_query_add_mod.frameIssueGroupQueryCriteria!=null){
		f_query_add_mod.frameIssueGroupQueryCriteria.document.formIssueGroupQueryCriteria.reset();
		f_query_add_mod.frameIssueGroupQueryResult.document.location.href="../../eCommon/html/blank.html";
	}
	else if(f_query_add_mod.frameIssueGroupHeader!=null){
		f_query_add_mod.location.reload();
	}
}


function apply(){
	if( f_query_add_mod.frameIssueGroupList==undefined){
		messageFrame.location.href ="../../eCommon/jsp/error.jsp?err_num=";
		return;
	}
	totalCBox=parseInt(f_query_add_mod.frameIssueGroupList.document.formIssueGroupList.total_checkboxes.value);
	var formObj		=	f_query_add_mod.frameIssueGroupHeader.document.formIssueGroupHeader ;
	var formObject	=	f_query_add_mod.frameIssueGroupList.document.formIssueGroupList ;

		var errorPage	=	"../../eCommon/jsp/error.jsp";
	var checkBoxObj=null;
	var forDeletion="";
	var noDetailExists	=	true;
	for(i=0;i<totalCBox;i++)
	{
		checkBoxObj=eval("f_query_add_mod.frameIssueGroupList.document.formIssueGroupList.checkbox"+i);
		if(checkBoxObj.checked)
			forDeletion+=("Y,");
		else
			forDeletion+=("N,");
		if(!checkBoxObj.checked){
			noDetailExists=false;
		}

		if(!checkBoxObj.checked){
		//Added by Sakti against BRU-HIMS-CRF-375 not to allow process transaction if issue_group and tray no blank fro checked records
		if(eval("formObject.issue_group_code_"+i).value == ""){ 
			messageFrame.location.href = errorPage+"?err_num="+getMessage("ISSUE_GROUP_CANNOT_BLANK","SS");
			eval("formObject.issue_group_code_"+i).focus();
			return;
		}
		
		if(eval("formObject.tray_no_"+i).value == ""){ 
			messageFrame.location.href = errorPage+"?err_num="+getMessage("TRAY_CANNOT_BLANK","SS");
			eval("formObject.tray_no_"+i).focus();
			return;
		}//Added ends
	}
}
	
	forDeletion=forDeletion.substring(0,forDeletion.length-1);
	
	formObject.records_to_delete.value=forDeletion;

	//var formObj		=	f_query_add_mod.frameIssueGroupHeader.document.formIssueGroupHeader ;
	//formObj.records_to_delete.value=forDeletion;
	
	var blankObject	=	null;
	var fields		=	new Array();
	var fieldNames	=	new Array();
	var	index		=	0;
	var queryString =	"";
	var errorPage	=	"../../eCommon/jsp/error.jsp";
	


	var fields = new Array (formObj.req_doc_type_code,formObj.req_doc_no, formObj.doc_type_code,formObj.doc_date);
	
	var fieldNames = new Array (getLabel("eSS.ReqDocType.label","SS"),getLabel("eSS.ReqDocNo.label","SS"),	getLabel("Common.DocType.label","Common"),getLabel("eSS.DocDate.label","SS"));
	if(!formObj.doc_no.disabled){
		var fields = new Array (formObj.req_doc_type_code,formObj.req_doc_no, formObj.doc_type_code,formObj.doc_date,formObj.doc_no);
		var fieldNames = new Array (getLabel("eSS.ReqDocType.label","SS"),getLabel("eSS.ReqDocNo.label","SS"),	getLabel("Common.DocType.label","Common"),getLabel("eSS.DocDate.label","SS"),getLabel("eSS.DocNo.label","SS"));
	}
	blankObject		=	getBlankField1( fields, fieldNames, messageFrame);


	if(blankObject==null) {
		if (noDetailExists){
		messageFrame.location.href = errorPage+"?err_num="+getMessage("MIN_ONE_DETAIL_REQUIRED","Common"); 		
		return;
	}
		//Added by Sakti against BRU-HIMS-CRF-375
		formObject.req_doc_type_code.value 	= formObj.req_doc_type_code.value;
		formObject.fr_store_code.value 		= formObj.fr_store_code.value;
		formObject.req_doc_no.value 		= formObj.req_doc_no.value;
		formObject.doc_ref.value 			= formObj.doc_ref.value;
		formObject.doc_type_code.value 		= formObj.doc_type_code.value;
		formObject.doc_no.value 			= formObj.doc_no.value;
		formObject.doc_date.value 			= formObj.doc_date.value;
		formObject.to_store_code.value 		= formObj.to_store_code.value;
		
		
		xmlDom ="";
		xmlHttp = new XMLHttpRequest();
		xmlStr = getEnhancedXMLString (formObject);
		xmlDom = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open("POST", "IssueGroupValidate.jsp?prev_index=" + index  + "&validate=ADD_TO_LIST", false);
		xmlHttp.send( xmlDom );
		responseText=xmlHttp.responseText;
		eval( responseText );//Added ends 

		//var responseText	=	formApply(formObj,SS_CONTROLLER);
		var responseText	=	formApply(formObject,SS_CONTROLLER);
		eval(responseText);
		messageFrame.location.href = errorPage+"?err_num="+ message+"<br>"+flag;
		if( result ) {
			onSuccess();
		}
	}
	else{
		
	
		//blankObject.focus();
		
	}
}
function getBlankField1( fields, legends, messageFrame, errorPage) {

    var obj=null;
    var errors = "" ;
    if (errorPage==null) {
        errorPage = "../../eCommon/jsp/error.jsp"
    }
    for( var i=0;i<fields.length; i++ )
    {
		
        if(trimCheck(fields[i].value))
            fields[i].value = trimString(fields[i].value);
        else
        {
            if(obj==null)
                obj=fields[i];
			
           errors += getMessage("SHOULD_NOT_BE_BLANK","Common",new Array(encodeURIComponent(legends[i])))+"<br>";
		
        }
    }
    if ( errors.length != 0 ) {
        messageFrame.location.href=errorPage+"?err_num="+errors;
    }
        return obj ;
}
function checkDoc_type_code(){
	if(document.formIssueGroupHeader.doc_type_code.value=="") return;
	var xmlHttp = new XMLHttpRequest();
	var xmlDoc="";
	xmlDoc = new DOMParser().parseFromString(getXMLString(null), "text/xml");
	xmlHttp.open("POST", "../../eSS/jsp/IssueGroupValidate.jsp?validate=DOC_TYPE_CODE&doc_type_code=" + document.formIssueGroupHeader.doc_type_code.value, false);
	xmlHttp.send(xmlDoc);
	responseText=xmlHttp.responseText;
	eval(responseText);
}

async function searchRequest(){
	var formObj = document.formIssueGroupHeader;

	if(!((formObj.req_doc_type_code.value=="") || (formObj.req_doc_no.value=="")))return;

    var retVal = new String();
    var dialogHeight= "80vh" ;
    var dialogWidth = "80vw" ;
    var status = "no";
	
	var dialogUrl       = "../../eSS/jsp/IssueGroupRequestQueryFrame.jsp?function_id="+parent.function_id+"&req_doc_type_code="+formObj.req_doc_type_code.value+"&req_doc_no="+formObj.req_doc_no.value;
	var dialogArguments = ""
	var dialogFeatures  = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; scroll=no; status:" + status;
	var returnVal =await window.showModalDialog(dialogUrl, dialogArguments, dialogFeatures);

	if( returnVal == null )
		return;
	else{
		
		formObj.req_doc_no.value=returnVal[0];
		formObj.req_doc_type_code.value=returnVal[1];		
		formObj.doc_type_code.focus();
		populateRequest();
	}
}

function returnDocNo(obj){

	var doc_no=obj.cells[0].innerText;
    var doc_type_code=obj.cells[5].innerText;
    var retVal = doc_no+ "\"" + doc_type_code;
    var returnedValue=retVal.split("\"");
   /* top.window.returnValue = retVal.split("\"");
    top.close();*/
    
    let dialogBody = parent.parent.document.getElementById('dialog-body');
    dialogBody.contentWindow.returnValue = returnedValue;
    
    const dialogTag = parent.parent.document.getElementById('dialog_tag');    
    dialogTag.close();   

}

function populateRequest(){
	var formObj=document.formIssueGroupHeader;
	//alert();
	if((formObj.req_doc_type_code.value=="") || (formObj.req_doc_no.value=="")) return;
	if (!checkIntegerFormat(formObj.req_doc_no))return;
	
	var xmlHttp = new XMLHttpRequest();	
	var xmlStr = getXMLString (null);
    var parser = new DOMParser();
    var xmlDoc = parser.parseFromString(xmlStr, "application/xml");

	
	
	
//	xmlDoc.loadXML(getXMLString(null));
	xmlHttp.open("POST", "../../eSS/jsp/IssueGroupValidate.jsp?validate=SEARCH_REQUEST&req_doc_type_code=" + document.formIssueGroupHeader.req_doc_type_code.value+"&req_doc_no=" + document.formIssueGroupHeader.req_doc_no.value+"&mode=" + document.formIssueGroupHeader.mode.value+"&doc_no="+document.formIssueGroupHeader.doc_no.value+"&doc_type_code="+document.formIssueGroupHeader.doc_type_code_iss.value, false);
	//xmlHttp.send(xmlDoc);
	xmlHttp.setRequestHeader("Content-Type", "text/xml");
    xmlHttp.send(new XMLSerializer().serializeToString(xmlDoc));	
	responseText=xmlHttp.responseText;
	eval(responseText);
	if(!result){
		alert(getMessage(flag,"SS"));
		//formObj.req_doc_no.select();
		formObj.req_doc_no.focus();
		formObj.req_doc_no.value = "";
	}
	else{
		formObj.req_doc_type_code.disabled=true;
		formObj.req_doc_no.disabled=true;
		formObj.fr_store_code.disabled=true;
		formObj.to_store_code.disabled=true;
		formObj.search_request.disabled=true;
		if(document.formIssueGroupHeader.mode.value=="1"){
		formObj.doc_type_code.focus();
		}else{
			formObj.doc_type_code.disabled=true;
			formObj.doc_date.disabled=true;
			formObj.doc_date_1.disabled=true;
		}

		//parent.frameIssueGroupList.location.reload();

		//parent.frameIssueGroupList.location.href="../../eSS/jsp/IssueGroupList.jsp?function_id="+parent.parent.function_id+"&mode="+document.formIssueGroupHeader.mode.value;
		parent.frameIssueGroupList.location.href="../../eSS/jsp/IssueGroupList.jsp?function_id="+parent.parent.function_id+"&mode="+document.formIssueGroupHeader.mode.value+"&fr_store_code="+formObj.fr_store_code.value+"&req_doc_type_code=" + document.formIssueGroupHeader.req_doc_type_code.value+"&req_doc_no=" + document.formIssueGroupHeader.req_doc_no.value+"&to_store_code="+formObj.to_store_code.value;
		
		//alert(parent.frameIssueGroupList);
	}
}

function clearList(){
	var xmlHttp = new XMLHttpRequest();
	var xmlDoc="";
	xmlDoc = new DOMParser().parseFromString(getXMLString(null), "text/xml");
	xmlHttp.open("POST", "../../eSS/jsp/IssueGroupValidate.jsp?validate=CLEAR_LIST", false);
	xmlHttp.send(xmlDoc);
	responseText=xmlHttp.responseText;
	refreshList();
}

function enableDocNo(bValue){
	if(!bValue){
		parent.frameIssueGroupHeader.document.formIssueGroupHeader.doc_no.value="";	
	}
	parent.frameIssueGroupHeader.document.formIssueGroupHeader.doc_no.disabled=!bValue;
}

function setIssueDetail(_issue_store, _receiving_store, _authorized_by_id,_authorized_by_name){
	var formObj = document.formIssueGroupHeader;
	formObj.fr_store_code.value=_issue_store;
	formObj.to_store_code.value=_receiving_store;
	formObj.authorized_by_id.value=_authorized_by_id;
	//formObj.authorized_by_name.value=_authorized_by_name;
	//Modified by suresh.r on 28/05/2015 against ML-BRU-SCF-1597
	formObj.authorized_by_name.value=decodeURIComponent(_authorized_by_name,"UTF-8");
}

function setIssueDetailList(_req_group_desc, _auth_group_desc){
	var formObj = document.formIssueGroupDetail;
	formObj.req_group_desc.value=_req_group_desc;
	formObj.auth_group_desc.value=_auth_group_desc;
	formObj.issue_group_code.disabled=false;
	formObj.tray_no.disabled=false;
	formObj.tray_search.disabled=false;
	formObj.patient_id.disabled=false;
	formObj.patient_search.disabled=false;
	
}

function clearIssueDetail(){}

function addToList(){
	
	var receiving_store_code=parent.frameIssueGroupHeader.formIssueGroupHeader.to_store_code.value;
	var description;

	var formObj=  document.formIssueGroupDetail;
	if(formObj.mode.value==1){
		 description = formObj.issue_group_code.value ;
	}else{
		description = formObj.description.value
	}
	var fields = new Array ( formObj.issue_group_code, formObj.tray_no);
	var names  =  new Array (getLabel("eSS.IssueGroup.label","SS") ,getLabel("eSS.TrayNo.label","SS") );
	var obj    =null;
	var messageFrame = parent.parent.messageFrame; 
	var errorPage	 = "../../eCommon/jsp/error.jsp"
	obj=getBlankField( fields, names, messageFrame,errorPage);
	if(obj==null) {
	 //alert(formObj.patient_name.value);
		var xmlHttp = new XMLHttpRequest();
		var xmlDoc="";
		var issue_group_desc	=	formObj.issue_group_code.options[formObj.issue_group_code.options.selectedIndex].text
		xmlDoc = new DOMParser().parseFromString(getXMLString(null), "text/xml");
		xmlHttp.open("POST", "../../eSS/jsp/IssueGroupValidate.jsp?issue_group_code=" + formObj.issue_group_code.value + "&tray_no=" + formObj.tray_no.value + "&bin_location_code=" + formObj.bin_location_code.value + "&patient_id=" + formObj.patient_id.value +"&expiry_date=" + formObj.expiry_date.value  +"&issue_group_desc=" + issue_group_desc+"&index="+formObj.index.value+ "&patient_name="+formObj.patient_name.value+ "&issue_cost="+formObj.issue_cost.value+"&receiving_store_code="+receiving_store_code+ "&mode="+formObj.mode.value+"&req_group_desc=" + formObj.req_group_desc.value +"&auth_group_desc=" + formObj.auth_group_desc.value+"&auth_group_code=" + description+"&req_group_code=" + description+"&validate=ADD_TO_LIST", false);
		xmlHttp.send(xmlDoc);
		responseText=xmlHttp.responseText;
		eval(responseText);
		//alert(responseText);
		if( result ) {
			
			refreshDetails();
			//parent.frameIssueGroupList.location.reload();

		}
		else{
			messageFrame.location.href = errorPage+"?err_num="+ getMessage(message,"SS");
		}
	}
	else
		obj.focus();
}

/*function searchPatient() {
	var patient_id	= PatientSearch();
	//var formObj = top.content.f_query_add_mod.frameIssueGroupDetail.document.formIssueGroupDetail;
	var formObj = document.formIssueGroupDetail;
	if (!((patient_id == null) || (patient_id =="")))	{
		formObj.patient_id.value = patient_id;
	}
	formObj.patient_id.focus();
}*/
//Modified by Sakti against BRU-HIMS-CRF-375 to display patient name index wise
async function searchPatient(i) {
	var patient_id	=await PatientSearch();
	//var formObj = top.content.f_query_add_mod.frameIssueGroupDetail.document.formIssueGroupDetail;
	var formObj = document.formIssueGroupList;
	if (!((patient_id == null) || (patient_id =="")))	{
		eval("formObj.patient_id_"+i).value = patient_id;
	}
	eval("formObj.patient_id_"+i).focus();
}

function checkIssueDate(issuedate,sysdate)
{
	var flag=true;
	if(issuedate.value.length <1)
	{
		alert(getMessage("DATE_NOT_BLANK","SS"));
		issuedate.select();
		issuedate.focus();
		flag=false;
		return false;
	}
		
	CheckDate(issuedate); 
	if(flag)
	checkSysdate(issuedate,sysdate);
	
}


function checkSysdate(receiptdate,sysdate){

var flag=true;

	
if(ChkDate(receiptdate) && flag )
   {
	
		if(!checkdateWithSysDate(receiptdate,sysdate))
		{
		alert(getMessage("NOT_GRT_THAN_SYSDATE","SS"));
		receiptdate.value="";
		//receiptdate.select();
		//receiptdate.focus();
		return false;
		}
		else
		{

		}
   }
	else
	{
		if(!(flag))
		{

			alert(getMessage("INVALID_DATE_FMT","SS"));
			//receiptdate.select();
			//receiptdate.focus();
			receiptdate.value="";
			return false;

		}
		else
		{
		alert(getMessage("INVALID_DATE_FMT","SS"));
		//receiptdate.select();
		//receiptdate.focus();
		receiptdate.value="";
		return false;
		}
	}

	
}

function chkCurrentYear(receiptdate,sysdate)
{
	var strYear = receiptdate.value;
	var sysYear = sysdate.value;
	var strDateArray = strYear.split("/");
	var sysDateArray = sysYear.split("/");
    var rYear ="";
	var sYear = "";
	if (strDateArray.length != 3) 
	{
        return false;
	}
    else
	{
        rYear = strDateArray[2];
       }

    if (sysDateArray.length != 3)
	{
        return false;
       }
    else
	{
        sYear = sysDateArray[2];
    }
	

	if(parseInt(rYear) < parseInt(sYear))
   		return false;
  	else
		return true;

}


function checkdateWithSysDate(entered_date,sys_date) 
{
	var enteredDateArray; var sysDateArray;
	var enteredDate = entered_date.value ;
	var sysDate = sys_date.value;

	if(enteredDate.length > 0 && sysDate.length > 0 ) 
	{
		enteredDateArray = enteredDate.split("/");
		sysDateArray = sysDate.split("/");
		var enteredDateObject = new Date(enteredDateArray[2],(enteredDateArray[1]-1),enteredDateArray[0]);
		var sysDateObject = new Date(sysDateArray[2],(sysDateArray[1]-1),sysDateArray[0]);	
		if(Date.parse(sysDateObject) < Date.parse(enteredDateObject)) 
		{
			/**
			  * If the sys_date is less than the entered_date date,
			  * i.e., The Entered date is greater than the Current System Date
			  * Then return false to indicate it is wrong..
			  */
			return false;
		}
		else if(Date.parse(sysDateObject) >= Date.parse(enteredDateObject)) return true;
	}	
	return true;
}

function searchGroupCode( objCode, objDesc ) {
	
	var argumentArray  = new Array();
	var dataNameArray  = new Array();
	var dataValueArray = new Array();
	var dataTypeArray  = new Array();


	var formobj=document.formIssueGroupHeader;
    
	dataNameArray[0] = "store_code";
	dataValueArray[0]=formobj.store_code.value;
	dataTypeArray[0] = STRING;
	


	argumentArray[0] = document.formIssueGroupTrayQueryCriteria.SQL_SS_GROUP_LOOKUP.value;
	argumentArray[1] = dataNameArray;
	argumentArray[2] = dataValueArray;
	argumentArray[3] = dataTypeArray;
	argumentArray[4] = "2,3";
	argumentArray[5] = objDesc.value;
	argumentArray[6] = CODE_LINK;
	argumentArray[7] = CODE_DESC;


	returnedValues = CommonLookup( "Group", argumentArray );
	if((returnedValues != null) && (returnedValues != "") )  {
		objCode.value = returnedValues[0];
		objDesc.value = returnedValues[1];
	} 

	
}

/*function searchPatientName(){
	var formObj	= document.formIssueGroupDetail;
	if(formObj.patient_id.value==""){
		formObj.patient_name.value="";
		return;
	}

	var xmlHttp = new XMLHttpRequest();
	var xmlDoc="";
	xmlDoc.loadXML(getXMLString(null));
	xmlHttp.open("POST", "../../eSS/jsp/IssueGroupValidate.jsp?validate=PATIENT_NAME&patient_id="+formObj.patient_id.value, false);
	xmlHttp.send(xmlDoc);
	responseText=xmlHttp.responseText;
	eval(responseText);
	if(!result){
		alert(getMessage(flag,"SS"));
		formObj.patient_id.select();
		formObj.patient_id.focus();
	}
}*/
//Modified By Sakti against BRU-HIMS-CRF-375
function searchPatientName(i){
	var formObj	= document.formIssueGroupList;
	if(eval("formObj.patient_id_"+i).value==""){
		eval("formObj.patient_name_"+i).value="";
		return;
	}
//
//	var xmlHttp = new XMLHttpRequest();
//	var xmlDoc="";
	var xmlHttp = new XMLHttpRequest();
	var xmlStr = getXMLString (null);
    var parser = new DOMParser();
    var xmlDoc = parser.parseFromString(xmlStr, "application/xml");

//	xmlDoc.loadXML(getXMLString(null));
	xmlHttp.open("POST", "../../eSS/jsp/IssueGroupValidate.jsp?validate=PATIENT_NAME&patient_id="+eval("formObj.patient_id_"+i).value+"&index_val="+i, false);
//	xmlHttp.send(xmlDoc);
	xmlHttp.setRequestHeader("Content-Type", "text/xml");
    xmlHttp.send(new XMLSerializer().serializeToString(xmlDoc));	
	responseText=xmlHttp.responseText;
	eval(responseText);
	if(!result){
		alert(getMessage(flag,"SS"));
		eval("formObj.patient_id_"+i).select();
		eval("formObj.patient_id_"+i).focus();
	}
}

/*function setPatientName(patient_name){
	//var formObj = top.content.f_query_add_mod.frameIssueGroupDetail.document.formIssueGroupDetail;
	var formObj = document.formIssueGroupDetail;
	formObj.patient_name.value=patient_name;
}*/
//Modified By Sakti against BRU-HIMS-CRF-375
function setPatientName(i,patient_name){
	//var formObj = top.content.f_query_add_mod.frameIssueGroupDetail.document.formIssueGroupDetail;
	var formObj = document.formIssueGroupList;
	eval("formObj.patient_name_"+i).value=patient_name;
}

/*function searchTrayDetail(){
	var formObj	= document.formIssueGroupDetail;
	if(formObj.tray_no.value==""){
		clearTrayDetails();
		return;
	}
	if (!checkIntegerFormat(formObj.tray_no))return;

	var xmlHttp = new XMLHttpRequest();
	var xmlDoc="";
	xmlDoc.loadXML(getXMLString(null));
	xmlHttp.open("POST", "../../eSS/jsp/IssueGroupValidate.jsp?validate=TRAY_DETAIL&tray_no="+formObj.tray_no.value+"&group_code="+formObj.issue_group_code.value, false);
	xmlHttp.send(xmlDoc);
	responseText=xmlHttp.responseText;
	eval(responseText);
	if(!result){
		alert(getMessage(flag,"SS"));
		formObj.tray_no.select();
		formObj.tray_no.focus();
	}
}*/
//Modified By Sakti against BRU-HIMS-CRF-375
function searchTrayDetail(i){
	var formObj	= document.formIssueGroupList;
	
	if(eval("formObj.tray_no_"+i).value==""){
		clearTrayDetails(i);
		return;
	}
	
	if (!checkIntegerFormat(eval("formObj.tray_no_"+i) ))return;

	var xmlHttp = new XMLHttpRequest();
	var xmlDoc="";
	xmlDoc = new DOMParser().parseFromString(getEnhancedXMLString(formObj), "text/xml");
	xmlHttp.open("POST", "../../eSS/jsp/IssueGroupValidate.jsp?validate=TRAY_DETAIL&tray_no="+eval("formObj.tray_no_"+i).value+"&group_code="+eval("formObj.issue_group_code_"+i).value+"&index_val="+i, false);
	xmlHttp.send(xmlDoc);
	responseText=xmlHttp.responseText;
	eval(responseText);
	if(!result){
		alert(getMessage(flag,"SS"));
		eval("formObj.tray_no_"+i).focus();
	}
}

/*function setTrayDetail(tray_no, bin_location_code, expiry_date, issue_cost){
	//var formObj							=	top.content.f_query_add_mod.frameIssueGroupDetail.document.formIssueGroupDetail;
	var formObj							=	document.formIssueGroupDetail;
	var locale							=	formObj.locale.value;
	formObj.expiry_date.value			=	convertDate(expiry_date,'DMY',"en",locale); 
	formObj.tray_no.value				=	tray_no;
	formObj.bin_location_code.value		=	bin_location_code;
	formObj.issue_cost.value			=	issue_cost;
}*/
//Modified By Sakti against BRU-HIMS-CRF-375
function setTrayDetail(index,tray_no, bin_location_code, expiry_date, issue_cost){
	
	var formObj							=	document.formIssueGroupList;
	var locale							=	formObj.locale.value;
	
	eval("formObj.expiry_date_"+index).value			=	convertDate(expiry_date,'DMY',"en",locale); 
	eval("formObj.tray_no_"+index).value				=	tray_no;
	eval("formObj.bin_location_code_"+index).value		=	bin_location_code;
	eval("formObj.issue_cost_"+index).value				=	issue_cost;
}


function clearGroupDetail(){
	var formObj = top.content.f_query_add_mod.frameIssueGroupDetail.document.formIssueGroupDetail;
	formObj.req_group_code.value="";
	formObj.request_qty.value="";
	formObj.description.value="";
}

function resetIssueGroupDetail(){
	//var formObj=top.content.f_query_add_mod.frameIssueGroupDetail.document.formIssueGroupDetail;
	var formObj=document.formIssueGroupDetail;
	var messageFrame = parent.parent.messageFrame;
	
	if(formObj.mode.value=="1") {
		
	formObj.req_group_desc.value="";
	formObj.auth_group_desc.value="";
	formObj.issue_group_code.value="";
	formObj.issue_group_code.disabled=true;
	formObj.tray_no.value="";
	formObj.tray_no.disabled=true;
	formObj.tray_search.disabled=true;
	formObj.bin_location_code.value="";
	formObj.expiry_date.value="";
	formObj.issue_cost.value="";
	formObj.patient_id.value="";
	formObj.patient_id.disabled=true;
	formObj.patient_search.disabled=true;
	formObj.patient_name.value="";
	formObj.index.value="-1";
	formObj.apply.disabled=true;
	formObj.cancel.disabled=true;
	messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num=";
	}else{
		formObj.description.value="";
	formObj.req_group_desc.value="";
	formObj.auth_group_desc.value="";
	formObj.issue_group_code.value="";
	formObj.issue_group_code.disabled=true;
	formObj.tray_no.value="";
	formObj.tray_no.disabled=true;
	formObj.tray_search.disabled=true;
	formObj.bin_location_code.value="";
	formObj.expiry_date.value="";
	formObj.issue_cost.value="";
	formObj.patient_id.value="";
	formObj.patient_id.disabled=true;
	formObj.patient_search.disabled=true;
	formObj.patient_name.value="";
	formObj.index.value="-1";
	formObj.apply.disabled=false;
	formObj.cancel.disabled=false;
	messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num=";
	
	}
}

async function searchTrayNo(){
	var formObj = document.formIssueGroupDetail;
	
	//alert(formObj.mode.value);
	var group_code	=	formObj.issue_group_code.value;
	var group_desc	=	formObj.issue_group_code.options[formObj.issue_group_code.options.selectedIndex].text;
	if(group_code=="")	return;
	var dialogHeight= "28vh" ;
    var dialogWidth = "47vw" ;
    var status = "no";
	
	var dialogUrl       = "../../eSS/jsp/IssueGroupTrayQueryFrame.jsp?function_id="+parent.function_id+"&tray_no="+formObj.tray_no.value+"&group_code="+group_code+"&group_desc="+group_desc+"&store_code="+parent.frameIssueGroupHeader.document.formIssueGroupHeader.fr_store_code.value+"&mode="+formObj.mode.value;
	var dialogArguments = ""
	var dialogFeatures  = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; scroll=no; status:" + status;
	var returnVal = await window.showModalDialog(dialogUrl, dialogArguments, dialogFeatures);

	if( returnVal == null )
		return;
	else{
		formObj.tray_no.value=returnVal;
		formObj.tray_no.focus();
		searchTrayDetail(); //Added by Rabbani on 13/12/2012
	}
}

function returnTrayNo(obj){
	var tray_no=obj.cells[0].innerText;
    top.window.returnValue = tray_no;
    top.close();
}

/*function clearTrayDetails(){
	document.formIssueGroupDetail.tray_no.value="";
	document.formIssueGroupDetail.bin_location_code.value="";
	document.formIssueGroupDetail.expiry_date.value="";
	document.formIssueGroupDetail.issue_cost.value="";
}*/

function clearTrayDetails(i){
	eval("document.formIssueGroupList.tray_no_"+i).value="";
	eval("document.formIssueGroupList.bin_location_code_"+i).value="";
	eval("document.formIssueGroupList.expiry_date_"+i).value="";
	eval("document.formIssueGroupList.issue_cost_"+i).value="";
	
	
}

function refreshDetails(){
	resetIssueGroupDetail();
	refreshList();
}

function refreshList(){
	//top.content.f_query_add_mod.frameIssueGroupList.document.location.reload();
	parent.frameIssueGroupList.location.href="../../eSS/jsp/IssueGroupList.jsp?index="+document.formIssueGroupDetail.index.value+"&function_id="+parent.parent.function_id+"&mode="+document.formIssueGroupDetail.mode.value+"&index="+document.formIssueGroupDetail.index.value;
	//parent.frameIssueGroupList.location.reload();


}

function listModify(index){
	parent.frameIssueGroupDetail.location.href="../../eSS/jsp/IssueGroupDetail.jsp?index="+index+"&function_id="+parent.parent.function_id+"&mode="+document.formIssueGroupList.mode.value;
}

function Modify(obj){
	var doc_type_code=obj.cells[5].innerText;
	var doc_no=obj.cells[1].innerText;
	var req_doc_no=obj.cells[6].innerText;
	var Re_Issue	= "Issue_Group" ;
	top.content.f_query_add_mod.document.location.href="../../eSS/jsp/IssueGroupFrame.jsp?mode="+MODE_MODIFY+"&function_id="+parent.parent.function_id+"&doc_type_code="+doc_type_code+"&doc_no="+doc_no+"&req_doc_no="+req_doc_no+"&Re_Issue="+Re_Issue;

	}

function issueGroupStoreValidate()
{
	
	var message1="INVALID_GROUP_FOR_STORE" ;
	var errorPage	 = "../../eCommon/jsp/error.jsp"
	//parent.parent.messageFrame.location.href = errorPage+"?err_num="+ getMessage(message1,"SS");
	messageFrame.location.href = errorPage+"?err_num="+ getMessage(message1,"SS");
}

async function searchGroupCode( obj ) {
	var argumentArray  = new Array();
	var dataNameArray  = new Array();
	var dataValueArray = new Array();
	var dataTypeArray  = new Array();

	argumentArray[0] = document.formIssueGroupDetail.SQL_SS_GROUP_LOOKUP_FOR_REPORT.value;
	dataNameArray  [0]="LANGUAGE_ID"
	dataValueArray [0]=document.formIssueGroupDetail.locale.value;
	dataTypeArray  [0]=STRING;
	
	argumentArray[1] = dataNameArray;
	argumentArray[2] = dataValueArray;
	argumentArray[3] = dataTypeArray;
	argumentArray[4] = "2,3";
	argumentArray[5] = obj.value;
	argumentArray[6] = CODE_LINK;
	argumentArray[7] = CODE_DESC;

	returnedValues = await CommonLookup(getLabel("Common.Group.label","Common"), argumentArray );
	if((returnedValues != null) && (returnedValues != "") )  {
		obj.value = returnedValues[0];

		var formObj=document.formIssueGroupDetail;
		var xmlHttp = new XMLHttpRequest();
		var xmlDoc="";
		xmlDoc = new DOMParser().parseFromString(getXMLString(null), "text/xml");

		xmlHttp.open("POST", "../../eSS/jsp/IssueGroupValidate.jsp?req_group_code=" + formObj.description.value + "&validate=POPULATE_AUTH_GROUP_CODE", false);
		xmlHttp.send(xmlDoc);
		responseText=xmlHttp.responseText;
		eval(responseText);
		/*if(formObj.mode.value==MODE_INSERT)
			formObj.auth_group_code.disabled=true;
		else
			formObj.auth_group_code.disabled=false;*/
	} 
} 

//Added by Rabbani for Validate Invalid Tray no on 14/12/2012
/*function validateTrayno(){
	var formObj	= document.formIssueGroupDetail;
	if(formObj.tray_no.value==""){
		clearTrayDetails();
		return;
	}
	if (!checkIntegerFormat(formObj.tray_no))return;

	var xmlHttp = new XMLHttpRequest();
	var xmlDoc="";
	xmlDoc.loadXML(getXMLString(null));
	xmlHttp.open("POST", "../../eSS/jsp/IssueGroupValidate.jsp?validate=TRAY_NO_VALIDATE&tray_no="+formObj.tray_no.value+"&group_code="+formObj.issue_group_code.value, false);
	xmlHttp.send(xmlDoc);
	responseText=xmlHttp.responseText;
	eval(responseText);
	if(result){
	 searchTrayDetail();
	}else{
		alert(getMessage(flag,"SS"));
		formObj.tray_no.select();
		formObj.tray_no.focus();
	}
}*/

async function validateTrayno(i){
	var formObj	= document.formIssueGroupList;
	if(eval("formObj.tray_no_"+i).value==""){
		clearTrayDetails(i);
		return;
	}
	if (!checkIntegerFormat(eval("formObj.tray_no_"+i)))
	{
		return;
	}
	

	var xmlHttp = new XMLHttpRequest();
	var xmlDoc="";
	xmlDoc = new DOMParser().parseFromString(getXMLString(null), "text/xml");
	xmlHttp.open("POST", "../../eSS/jsp/IssueGroupValidate.jsp?validate=TRAY_NO_VALIDATE&tray_no="+eval("formObj.tray_no_"+i).value+"&group_code="+eval("formObj.issue_group_code_"+i).value+"&index_val="+i, false);
	xmlHttp.send(xmlDoc);
	responseText=xmlHttp.responseText;
	eval(responseText);
	if(result){
	 await searchTrayDetail(i);
	}else{
		alert(getMessage(flag,"SS"));
		eval("formObj.tray_no_"+i).focus();
	}
}
//Added by Sakti against BRU-HIMS-CRF-375
function RemoveTrayno(i,fr_store_code){
	var formObj	= document.formIssueGroupList;
	if(eval("formObj.tray_no_"+i).value==""){
		clearTrayDetails(i);
	}	
	var xmlHttp = new XMLHttpRequest();
	var xmlDoc="";
	xmlDoc = new DOMParser().parseFromString(getEnhancedXMLString(formObj), "text/xml");
	xmlHttp.open("POST", "../../eSS/jsp/IssueGroupValidate.jsp?validate=REMOVE_TRAY_NO&tray_no="+eval("formObj.tray_no_"+i).value+"&index_val="+i+"&fr_store_code="+fr_store_code, false);
	xmlHttp.send(xmlDoc);
	responseText=xmlHttp.responseText;
	eval(responseText);	
}

function ChangeIssueGroup(i,fr_store_code){
	clearTrayDetails(i);
	var formObj	= document.formIssueGroupList;
	var xmlHttp = new XMLHttpRequest();
	var xmlDoc="";
xmlDoc = new DOMParser().parseFromString(getEnhancedXMLString(formObj), "text/xml");
	xmlHttp.open("POST", "../../eSS/jsp/IssueGroupValidate.jsp?validate=CHANGE_ISSUE_GROUP&tray_no="+eval("formObj.tray_no_"+i).value+"&index_val="+i+"&fr_store_code="+fr_store_code, false);
	xmlHttp.send(xmlDoc);
	responseText=xmlHttp.responseText;
	eval(responseText);	
}

async function callGroupSearch() {
	var formObject 								= parent.frameIssueGroupList.document.formIssueGroupList;
	parent.parent.messageFrame.location.href 	= "../../eCommon/jsp/error.jsp";
	var formObj 								= document.formIssueGroupHeader;
	var arrayObject 							= new Array(formObj.fr_store_code,formObj.to_store_code);
	var names 									= new Array(getLabel("eSS.IssueStore.label","SS"),getLabel("eSS.ReceivingStore.label","SS"));
	var blankObject 							= checkSSFields(arrayObject, names, parent.parent.messageFrame);
	if (blankObject == true) {
		var issueing_store_code 					= formObj.fr_store_code.value;
		var receiving_store_code 					= formObj.to_store_code.value;
								
		xmlDom = "";
		xmlHttp = new XMLHttpRequest();
		xmlStr = getEnhancedXMLString (formObject);
xmlDom = new DOMParser().parseFromString(xmlStr, "text/xml");
		
		xmlHttp.open("POST", "IssueGroupValidate.jsp?bean_id="+formObject.bean_id.value+"&bean_name="+formObject.bean_name.value+ "&validate=DTL_DATA_STORE", false);
		xmlHttp.send( xmlDom );
		responseText=xmlHttp.responseText;
		eval( responseText );
			
		retval = await window.showModalDialog("../../eSS/jsp/IssueGroupSearchFrame.jsp?req_on_store_code=" + issueing_store_code+"&mode="+formObj.mode.value+"&req_by_store_code="+receiving_store_code ,"", "dialogHeight:33; dialogWidth:55; center:0; status: no; dialogLeft :200; dialogTop :100;");
	
		//if (retval != null && retval!="" && retval!=undefined) {
		if (retval != null && retval!=undefined) {
		
			parent.frameIssueGroupList.location.href="../../eSS/jsp/IssueGroupList.jsp?function_id="+parent.parent.function_id+"&mode="+document.formIssueGroupHeader.mode.value+"&fr_store_code="+formObj.fr_store_code.value+"&req_doc_type_code=" + document.formIssueGroupHeader.req_doc_type_code.value+"&req_doc_no=" + document.formIssueGroupHeader.req_doc_no.value+"&to_store_code="+formObj.to_store_code.value+"&Re_Issue="+document.formIssueGroupHeader.Re_Issue.value;
		}
		//else part added  for clearing checked values oncancel and clicking on cross or close
		else{
			

			/*xmlDom = new ActiveXObject( "Microsoft.XMLDom" );
			xmlHttp = new ActiveXObject( "Microsoft.XMLHTTP" );
			xmlStr = getXMLString (null);
			xmlDom.loadXML( xmlStr );
			
			xmlHttp.open("POST", "RequestGroupValidate.jsp?bean_id="+formObject.bean_id.value+"&bean_name="+formObject.bean_name.value+"&validate=CLEAR_DATA", false);
			xmlHttp.send( xmlDom );
			responseText=xmlHttp.responseText;
			eval( responseText );*/
			
		}
	}
}

function searchValues() {
	

	var group_type 			= document.GroupSearchCriteria_Form.group_type.value;
	var surgery_type 		= document.GroupSearchCriteria_Form.surgery_type.value;
	var surg_description 	= document.GroupSearchCriteria_Form.surg_description.value;
	var ot_surg_description = document.GroupSearchCriteria_Form.ot_surg_description.value;
	var req_on_store_code 	= document.GroupSearchCriteria_Form.req_on_store_code.value;
	var req_by_store_code 	= document.GroupSearchCriteria_Form.req_by_store_code.value;
	var isincludetargetstore= document.GroupSearchCriteria_Form.target_store.checked;
	var searchCriteria		= document.GroupSearchCriteria_Form.search_criteria.value;
	var search_text 		= document.GroupSearchCriteria_Form.search_text.value;
	var mode 				= document.GroupSearchCriteria_Form.mode.value;
	
	parent.frameIssueGroupSearchResult.document.location.href = "../../eSS/jsp/IssueGroupSearchResult.jsp?radioval=" + radioval+"&search_text="+encodeURIComponent(search_text,"UTF-8")+"&mode="+mode+"&group_type="+group_type+"&ot_surg_description="+ot_surg_description+"&req_on_store_code="+req_on_store_code+"&surg_description="+surg_description+"&surgery_type="+surgery_type+"&req_by_store_code="+req_by_store_code+"&isincludetargetstore="+isincludetargetstore+"&searchCriteria="+searchCriteria;
}

function closeActionPerformed(frmObj) {

	var index = 0;
	var returnvals = "";
	var new_index= "";
	var unchecked_index = "";
	var seach_type = "";
	var exist = false;
	var formObj = parent.frameIssueGroupSearchResult.document.GroupsearchForm;
	if(formObj == undefined){
		alert(getMessage("SELECT_GROUP_TO_PROCEED","SS"));
		return;
	}
	var total_trays = formObj.totalRecords.value;
	
	var arrayObject = new Array();
	window.returnValue=false;
	
	for (var count = 0;count<total_trays;count++) {
			if(eval("parent.frameIssueGroupSearchResult.document.GroupsearchForm.group_code"+count+".checked")) {
				exist = true;
				returnvals += formObj.elements("group" + count).value + "`" + formObj.elements("desc" + count).value +  "~";
				
				arrayObject[index] = eval("parent.frameIssueGroupSearchResult.document.GroupsearchForm.group"+count);
				arrayObject[index+1] = eval("parent.frameIssueGroupSearchResult.document.GroupsearchForm.desc"+count);
				
				arrayObject[index+2] = eval("parent.frameIssueGroupSearchResult.document.GroupsearchForm.group_type"+count);
				arrayObject[index+3] = eval("parent.frameIssueGroupSearchResult.document.GroupsearchForm.auth_group"+count);
				arrayObject[index+4] = eval("parent.frameIssueGroupSearchResult.document.GroupsearchForm.surgery_type"+count);
				arrayObject[index+5] = eval("parent.frameIssueGroupSearchResult.document.GroupsearchForm.surgery_name"+count);
				arrayObject[index+6] = eval("parent.frameIssueGroupSearchResult.document.GroupsearchForm.qty"+count);
				arrayObject[index+7] = eval("parent.frameIssueGroupSearchResult.document.GroupsearchForm.avlbl_ster_qty"+count);
				index += 8;
				
				new_index += count + "!";
			}else{
				arrayObject[index] = eval("parent.frameIssueGroupSearchResult.document.GroupsearchForm.group"+count);
				arrayObject[index+1] = eval("parent.frameIssueGroupSearchResult.document.GroupsearchForm.desc"+count);
				
				arrayObject[index+2] = eval("parent.frameIssueGroupSearchResult.document.GroupsearchForm.group_type"+count);
				arrayObject[index+3] = eval("parent.frameIssueGroupSearchResult.document.GroupsearchForm.auth_group"+count);
				arrayObject[index+4] = eval("parent.frameIssueGroupSearchResult.document.GroupsearchForm.surgery_type"+count);
				arrayObject[index+5] = eval("parent.frameIssueGroupSearchResult.document.GroupsearchForm.surgery_name"+count);
				arrayObject[index+6] = eval("parent.frameIssueGroupSearchResult.document.GroupsearchForm.qty"+count);
				arrayObject[index+7] = eval("parent.frameIssueGroupSearchResult.document.GroupsearchForm.avlbl_ster_qty"+count);
				
				index += 8;
				
				unchecked_index += count+"!";
			}
	}

		
	parent.frameIssueGroupSearchResult.document.GroupsearchForm.index.value = new_index;
	parent.frameIssueGroupSearchResult.document.GroupsearchForm.mode.value = document.GroupSearchCriteria_Form.mode.value;
	parent.frameIssueGroupSearchResult.document.GroupsearchForm.unchecked_index.value = unchecked_index;
	
	//alert(parent.frameIssueGroupSearchResult.document.GroupsearchForm.index.value);
	//alert(parent.frameIssueGroupSearchResult.document.GroupsearchForm.unchecked_index.value);
	arrayObject[arrayObject.length] = parent.frameIssueGroupSearchResult.document.GroupsearchForm.unchecked_index;
	arrayObject[arrayObject.length] = parent.frameIssueGroupSearchResult.document.GroupsearchForm.index;
	arrayObject[arrayObject.length] = parent.frameIssueGroupSearchResult.document.GroupsearchForm.mode;
		
	
	var xmlDom ="";
	var xmlHttp = new XMLHttpRequest();
	var xmlStr = getXMLString (arrayObject);
	xmlDom = new DOMParser().parseFromString(xmlStr, "text/xml");
	
	xmlHttp.open("POST", "IssueGroupValidate.jsp?validate=ADD_GROUPS_TO_LIST"+"&search_type=search", false);
	xmlHttp.send( xmlDom );
	responseText=xmlHttp.responseText;
	eval( responseText );
	
	//This is added by Sakti against BRU-HIMS-CRF-373 if in group search window any one group is selected among all pages, need to add that group in list. If not, then below message shown
	if(!result) {
		alert(getMessage("SELECT_GROUP_TO_PROCEED","SS")); 
		return;
	}else{
		window.parent.parent.returnValue = returnvals;
		window.close();
	}//Added ends
	
}



function SubmitLink(from, to) {

	var index = 0;
	var new_index= "";
	var unchecked_index= "";
	var formObj = document.GroupsearchForm;

	if(document.GroupsearchForm){
	var total_trays = formObj.totalRecords.value;
	
	var arrayObject = new Array();
		for (var count = 0;count<total_trays;count++) {
		
			if(eval("document.GroupsearchForm.group_code"+count+".checked")) {
				
				arrayObject[index] = eval("document.GroupsearchForm.group"+count);
				arrayObject[index+1] = eval("document.GroupsearchForm.desc"+count);
				
				
				
				arrayObject[index+2] = eval("document.GroupsearchForm.group_type"+count);
				arrayObject[index+3] = eval("document.GroupsearchForm.auth_group"+count);
				arrayObject[index+4] = eval("document.GroupsearchForm.surgery_type"+count);
				arrayObject[index+5] = eval("document.GroupsearchForm.surgery_name"+count);
				arrayObject[index+6] = eval("document.GroupsearchForm.qty"+count);
				arrayObject[index+7] = eval("document.GroupsearchForm.avlbl_ster_qty"+count);
				
				index += 8;
				
				new_index += count+"!";
		}else{
			arrayObject[index] = eval("document.GroupsearchForm.group"+count);
			arrayObject[index+1] = eval("document.GroupsearchForm.desc"+count);
			
			arrayObject[index+2] = eval("document.GroupsearchForm.group_type"+count);
			arrayObject[index+3] = eval("document.GroupsearchForm.auth_group"+count);
			arrayObject[index+4] = eval("document.GroupsearchForm.surgery_type"+count);
			arrayObject[index+5] = eval("document.GroupsearchForm.surgery_name"+count);
			arrayObject[index+6] = eval("document.GroupsearchForm.qty"+count);
			arrayObject[index+7] = eval("document.GroupsearchForm.avlbl_ster_qty"+count);
			
			index += 8;
			
			unchecked_index += count+"!";
		}
	}
		

	
	document.GroupsearchForm.index.value = new_index;
	arrayObject[arrayObject.length] = document.GroupsearchForm.index;
	
	document.GroupsearchForm.search_type.value = "next_prev";
	
	document.GroupsearchForm.unchecked_index.value = unchecked_index;
	arrayObject[arrayObject.length] = document.GroupsearchForm.unchecked_index;
	arrayObject[arrayObject.length] = document.GroupsearchForm.mode;
	arrayObject[arrayObject.length] = document.GroupsearchForm.search_type;

	
	
	xmlDom = "";
	xmlHttp = new XMLHttpRequest() ;
	xmlStr = getXMLString (arrayObject);
	xmlDom = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST", "IssueGroupValidate.jsp?validate=ADD_GROUPS_TO_LIST"+"&search_type=next_prev", false);
	xmlHttp.send( xmlDom );
	responseText=xmlHttp.responseText;
	eval( responseText );
	}
    document.QueryForm.from.value = from;
    document.QueryForm.to.value = to;

    document.QueryForm.submit() ; 
    
}

function submit1()
{
document.formIssueGroupRequestQueryCriteria.action="../../eSS/jsp/IssueGroupRequestQueryResult.jsp";
document.formIssueGroupRequestQueryCriteria.target="frameIssueGroupRequestQueryResult";
document.formIssueGroupRequestQueryCriteria.submit();
}
function submit2()
{
document.formIssueGroup.action="../../eSS/jsp/IssueGroupQueryResult.jsp";
document.formIssueGroup.target="qryResultIssueGroup";
document.formIssueGroup.submit();
}



function updateSelectionGroupSearch() {
	var frmObject		= document.GroupsearchForm;
	var total_check_boxes = frmObject.totalRecords.value;
	var exist=true;
		for (var count = 0;count<total_check_boxes;count++) {

				if(!(eval("frmObject.group_code"+count+".checked"))) {
					exist=false;
				}
		}
			if(exist){
			document.GroupsearchForm.selectAll.checked=true;
			}else{
			document.GroupsearchForm.selectAll.checked=false;
			}
}

function toggleCheck(selAllObj){

	var formObj = document.GroupsearchForm;
	
	for(var i=0; i<formObj.totalRecords.value; i++){
	if(eval('formObj.group_code'+i).disabled == false) {	
		if(selAllObj.checked == true){
			if(eval('formObj.group_code'+i) != undefined) {
				eval('formObj.group_code'+i).checked = true;
			}
		}
		else{
			if(eval('formObj.group_code'+i) != undefined) {
				eval('formObj.group_code'+i).checked = false;
			}
		}
	}
 }

}



async function details(group_code,group_desc)
{
  
	if(group_code!="")
	{
	var dialogHeight = "30vh" ;
	var dialogWidth	= "40vw" ;

	var dialogTop = "265" ;
	var center = "1" ;

	var features = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +"; center: " + center + "; dialogTop :" + dialogTop +"; scroll=yes; status=no;" ;
	
	var arguments = "" ;
	var title="Request Detail";
	var params = "group_code="+group_code+"&group_desc="+group_desc;
	
	retVal = await window.showModalDialog("../../eSS/jsp/GroupItemDetails.jsp?"+params,arguments,features);
	}

}
function getXMLString(arrayObject) {
	
	xmlStr ="<root><SEARCH ";
	if (arrayObject!=null)
		for (index=0;index<arrayObject.length;index++)	{
			xmlStr += arrayObject[index].name+"=\""+ checkSpl(arrayObject[index].value) +"\" ";
		}
	xmlStr +=" /></root>";
	return xmlStr;
}

function isNumberKey(evt)
{

    var charCode = (evt.which) ? evt.which : evt.keyCode;
    if (charCode == 8 || charCode == 13) 
    	return false;
} 
//Added ends

function CloseReIssueWindow(){
	window.close();
}
//ML-MMOH-CRF-1829
function showToolTip(obj,msg){
	obj.title=msg;  
}//END  

