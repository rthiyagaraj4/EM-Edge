/*
*Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
* 
*Warning: This computer program is protected by copyright law and international treaties.
*Unauthorized reproduction or distribution of this program, or any portion of it, 
*may result in severe civil and criminal penalties, and will be prosecuted to 
*the maximum extent possible under the law.
*/
function create(){
	f_query_add_mod.location.href = "../../eSS/jsp/LoanIssueGroupFrame.jsp?mode="+MODE_INSERT+"&function_id="+function_id ;
}

function query(){
	f_query_add_mod.location.href="../../eSS/jsp/LoanIssueGroupQueryMain.jsp?mode="+MODE_MODIFY+"&function_id="+function_id;
}

function onSuccess(){
	var mode = f_query_add_mod.frameLoanIssueGroupHeader.document.formLoanIssueGroupHeader.mode.value;
	//var Re_Issue = f_query_add_mod.frameLoanIssueGroupHeader.document.formLoanIssueGroupHeader.Re_Issue.value;
	if( mode == MODE_INSERT ) {
		reset();
	}
	/*else{
		//create();
		if(Re_Issue=="Confirm"){
		alert(message);
		window.close();
		}else{
		f_query_add_mod.frameLoanIssueGroupHeader.document.location.href="../../eCommon/html/blank.html";
		f_query_add_mod.frameLoanIssueGroupList.document.location.href="../../eCommon/html/blank.html";
		f_query_add_mod.frameLoanIssueGroupDetail.document.location.href="../../eCommon/html/blank.html";
		}		
	}*/
}

function reset() {
	if(f_query_add_mod.frameLoanIssueGroupQueryCriteria!=null){
		f_query_add_mod.frameLoanIssueGroupQueryCriteria.document.formLoanIssueGroupQueryCriteria.reset();
		f_query_add_mod.frameLoanIssueGroupQueryResult.document.location.href="../../eCommon/html/blank.html";
	}
	else if(f_query_add_mod.frameLoanIssueGroupHeader!=null){
		f_query_add_mod.location.reload();
	}
}


function apply(){
	totalCBox=parseInt(f_query_add_mod.frameLoanIssueGroupList.document.formLoanIssueGroupList.total_checkboxes.value);
	var formObj		=	f_query_add_mod.frameLoanIssueGroupHeader.document.formLoanIssueGroupHeader ;
	var formObject	=	f_query_add_mod.frameLoanIssueGroupList.document.formLoanIssueGroupList ;
	
		var errorPage	=	"../../eCommon/jsp/error.jsp";
	var checkBoxObj=null;
	var forDeletion="";
	var noDetailExists	=	true;

	for(i=0;i<totalCBox;i++)
	{
		checkBoxObj=eval("f_query_add_mod.frameLoanIssueGroupList.document.formLoanIssueGroupList.checkbox"+i);
		if(checkBoxObj.checked)
			forDeletion+=("Y,");
		else
			forDeletion+=("N,");
		if(!checkBoxObj.checked){
			noDetailExists=false;
		}
		if(!checkBoxObj.checked){
			if(eval("formObject.issue_group_code_"+i).value == ""){ 
				messageFrame.location.href = errorPage+"?err_num="+getMessage("ISSUE_GROUP_CANNOT_BE_BLANK","SS");
				eval("formObject.issue_group_code_"+i).focus();
				return;
			}		
			if(eval("formObject.tray_no_"+i).value == ""){ 
				messageFrame.location.href = errorPage+"?err_num="+getMessage("TRAY_NO_CANNOT_BE_BLANK","SS");
				eval("formObject.tray_no_"+i).focus();
				return;
			}
		}		
	}
	
	forDeletion=forDeletion.substring(0,forDeletion.length-1);
	formObject.records_to_delete.value=forDeletion;
	
	var blankObject	=	null;
	var	index		=	0;
	var errorPage	=	"../../eCommon/jsp/error.jsp";	


	var fields = new Array (formObj.req_doc_type_code,formObj.req_doc_no, formObj.doc_type_code,formObj.doc_date);	
	var fieldNames = new Array (getLabel("eSS.ReqDocType.label","SS"),getLabel("eSS.ReqDocNo.label","SS"),	getLabel("Common.DocType.label","Common"),getLabel("eSS.DocDate.label","SS"));
	
	if(!formObj.doc_no.disabled){
		var fields = new Array (formObj.req_doc_type_code,formObj.req_doc_no, formObj.doc_type_code,formObj.doc_date,formObj.doc_no);
		var fieldNames = new Array (getLabel("eSS.ReqDocType.label","SS"),getLabel("eSS.ReqDocNo.label","SS"),	getLabel("Common.DocType.label","Common"),getLabel("eSS.DocDate.label","SS"),getLabel("eSS.DocNo.label","SS"));
	}
	blankObject		=	getBlankField1(fields,fieldNames, messageFrame);


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
		
		//var index = f_query_add_mod.frameRequestGroupList.document.formRequestGroupList.total_checkboxes.value;
		xmlDom = new ActiveXObject( "Microsoft.XMLDom" );
		xmlHttp = new ActiveXObject( "Microsoft.XMLHTTP" );
		xmlStr = getEnhancedXMLString (formObject);
		xmlDom.loadXML( xmlStr );
		xmlHttp.open("POST", "LoanIssueGroupValidate.jsp?prev_index=" + index  + "&validate=ADD_TO_LIST", false);
		xmlHttp.send( xmlDom );
		responseText=xmlHttp.responseText;
		eval( responseText );		
		
		var responseText	=	formApply(formObject,SS_CONTROLLER);
		eval(responseText);
		messageFrame.location.href = errorPage+"?err_num="+ message+"<br>"+flag;
		if( result ) {
			onSuccess();
		}
	}
	else{	
		blankObject.focus();		
	}
}
function getBlankField1( fields, legends, messageFrame, errorPage) {

    var obj=null;
    var errors = "" ;
    if (errorPage==null) {
        errorPage = "../../eCommon/jsp/error.jsp";
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
	if(document.formLoanIssueGroupHeader.doc_type_code.value=="") return;
	var xmlHttp = new XMLHttpRequest();
	var xmlDoc="";
	xmlDoc.loadXML(getXMLString(null));
	xmlHttp.open("POST", "../../eSS/jsp/LoanIssueGroupValidate.jsp?validate=DOC_TYPE_CODE&doc_type_code=" + document.formLoanIssueGroupHeader.doc_type_code.value, false);
	xmlHttp.send(xmlDoc);
	responseText=xmlHttp.responseText;
	eval(responseText);
}

function searchRequest(){
	var formObj = document.formLoanIssueGroupHeader;

	if(!((formObj.req_doc_type_code.value=="") || (formObj.req_doc_no.value=="")))return;
    
    var dialogHeight= "75%" ;
    var dialogWidth = "75%" ;
    var status = "no";
	
	var dialogUrl       = "../../eSS/jsp/LoanIssueGroupRequestQueryFrame.jsp?function_id="+parent.function_id+"&req_doc_type_code="+formObj.req_doc_type_code.value+"&req_doc_no="+formObj.req_doc_no.value;
	var dialogArguments = "";
	var dialogFeatures  = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; scroll=no; status:" + status;
	var returnVal = window.showModalDialog(dialogUrl, dialogArguments, dialogFeatures);

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
    top.window.returnValue = retVal.split("\"");
    top.close();

}

function populateRequest(){
	var formObj=document.formLoanIssueGroupHeader;
	if((formObj.req_doc_type_code.value=="") || (formObj.req_doc_no.value=="")) return;
	if (!checkIntegerFormat(formObj.req_doc_no))return;
	var xmlHttp = new XMLHttpRequest();
	var xmlDoc="";
	xmlDoc.loadXML(getXMLString(null));
	xmlHttp.open("POST", "../../eSS/jsp/LoanIssueGroupValidate.jsp?validate=SEARCH_REQUEST&req_doc_type_code=" + document.formLoanIssueGroupHeader.req_doc_type_code.value+"&req_doc_no=" + document.formLoanIssueGroupHeader.req_doc_no.value+"&mode=" + document.formLoanIssueGroupHeader.mode.value+"&doc_no="+document.formLoanIssueGroupHeader.doc_no.value+"&doc_type_code="+document.formLoanIssueGroupHeader.doc_type_code_iss.value, false);
	xmlHttp.send(xmlDoc);
	responseText=xmlHttp.responseText;
	eval(responseText);
	if(!result){
		alert(getMessage(flag,"SS"));
		formObj.req_doc_no.select();
		formObj.req_doc_no.focus();
		
	}
	else{
		formObj.req_doc_type_code.disabled=true;
		formObj.req_doc_no.disabled=true;
		formObj.fr_store_code.disabled=true;
		formObj.to_store_code.disabled=true;
		formObj.search_request.disabled=true;
		if(document.formLoanIssueGroupHeader.mode.value=="1"){
		formObj.doc_type_code.focus();
		}else{
			formObj.doc_type_code.disabled=true;
			formObj.doc_date.disabled=true;
			formObj.doc_date_1.disabled=true;
		}
		//parent.frameLoanIssueGroupList.location.reload();
		parent.frameLoanIssueGroupList.location.href="../../eSS/jsp/LoanIssueGroupList.jsp?function_id="+parent.parent.function_id+"&mode="+document.formLoanIssueGroupHeader.mode.value+"&fr_store_code="+formObj.fr_store_code.value+"&req_doc_type_code=" + document.formLoanIssueGroupHeader.req_doc_type_code.value+"&req_doc_no=" + document.formLoanIssueGroupHeader.req_doc_no.value+"&to_store_code="+formObj.to_store_code.value;
	}
}

function clearList(){
	var xmlHttp = new XMLHttpRequest();
	var xmlDoc="";
	xmlDoc.loadXML(getXMLString(null));
	xmlHttp.open("POST", "../../eSS/jsp/LoanIssueGroupValidate.jsp?validate=CLEAR_LIST", false);
	xmlHttp.send(xmlDoc);
	responseText=xmlHttp.responseText;
	refreshList();
}

function enableDocNo(bValue){
	if(!bValue){
		parent.frameLoanIssueGroupHeader.document.formLoanIssueGroupHeader.doc_no.value="";	
	}
	parent.frameLoanIssueGroupHeader.document.formLoanIssueGroupHeader.doc_no.disabled=!bValue;
}

function setIssueDetail(_issue_store, _receiving_store, _authorized_by_id,_authorized_by_name){
	var formObj = document.formLoanIssueGroupHeader;
	formObj.fr_store_code.value=_issue_store;
	formObj.to_store_code.value=_receiving_store;
	formObj.authorized_by_id.value=_authorized_by_id;
	formObj.authorized_by_name.value=_authorized_by_name;
}

function setIssueDetailList(_req_group_desc, _auth_group_desc){
	var formObj = document.formLoanIssueGroupDetail;
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
	
	var receiving_store_code=parent.frameLoanIssueGroupHeader.formLoanIssueGroupHeader.to_store_code.value;
	var description;

	var formObj=  document.formLoanIssueGroupDetail;
	if(formObj.mode.value==1){
		 description = formObj.issue_group_code.value ;
	}else{
		description = formObj.description.value
	}
	var fields = new Array ( formObj.issue_group_code, formObj.tray_no);
	var names  =  new Array (getLabel("eSS.LoanIssueGroup.label","SS") ,getLabel("eSS.TrayNo.label","SS") );
	var obj    =null;
	var messageFrame = parent.parent.messageFrame; 
	var errorPage	 = "../../eCommon/jsp/error.jsp"
	obj=getBlankField( fields, names, messageFrame,errorPage);
	if(obj==null) {
	 //alert(formObj.patient_name.value);
		var xmlHttp = new XMLHttpRequest();
		var xmlDoc="";
		var issue_group_desc	=	formObj.issue_group_code.options[formObj.issue_group_code.options.selectedIndex].text
		xmlDoc.loadXML(getXMLString(null));
		xmlHttp.open("POST", "../../eSS/jsp/LoanIssueGroupValidate.jsp?issue_group_code=" + formObj.issue_group_code.value + "&tray_no=" + formObj.tray_no.value + "&bin_location_code=" + formObj.bin_location_code.value + "&patient_id=" + formObj.patient_id.value +"&expiry_date=" + formObj.expiry_date.value  +"&issue_group_desc=" + issue_group_desc+"&index="+formObj.index.value+ "&patient_name="+formObj.patient_name.value+ "&issue_cost="+formObj.issue_cost.value+"&receiving_store_code="+receiving_store_code+ "&mode="+formObj.mode.value+"&req_group_desc=" + formObj.req_group_desc.value +"&auth_group_desc=" + formObj.auth_group_desc.value+"&auth_group_code=" + description+"&req_group_code=" + description+"&validate=ADD_TO_LIST", false);
		xmlHttp.send(xmlDoc);
		responseText=xmlHttp.responseText;
		eval(responseText);
		//alert(responseText);
		if( result ) {
			
			refreshDetails();
			//parent.frameLoanIssueGroupList.location.reload();

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
	//var formObj = top.content.f_query_add_mod.frameLoanIssueGroupDetail.document.formLoanIssueGroupDetail;
	var formObj = document.formLoanIssueGroupDetail;
	if (!((patient_id == null) || (patient_id =="")))	{
		formObj.patient_id.value = patient_id;
	}
	formObj.patient_id.focus();
}*/

function searchPatient(i) {
	var patient_id	= PatientSearch();
	//var formObj = top.content.f_query_add_mod.frameLoanIssueGroupDetail.document.formLoanIssueGroupDetail;
	var formObj = document.formLoanIssueGroupList;
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
		receiptdate.select();
		receiptdate.focus();
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
			receiptdate.select();
			receiptdate.focus();
			return false;

		}
		else
		{
		alert(getMessage("INVALID_DATE_FMT","SS"));
		receiptdate.select();
		receiptdate.focus();
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

	var formobj=document.formLoanIssueGroupHeader;
    
	dataNameArray[0] = "store_code";
	dataValueArray[0]=formobj.store_code.value;
	dataTypeArray[0] = STRING;
	argumentArray[0] = document.formLoanIssueGroupTrayQueryCriteria.SQL_SS_GROUP_LOOKUP.value;
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
	var formObj	= document.formLoanIssueGroupDetail;
	if(formObj.patient_id.value==""){
		formObj.patient_name.value="";
		return;
	}

	var xmlHttp = new XMLHttpRequest();
	var xmlDoc="";
	xmlDoc.loadXML(getXMLString(null));
	xmlHttp.open("POST", "../../eSS/jsp/LoanIssueGroupValidate.jsp?validate=PATIENT_NAME&patient_id="+formObj.patient_id.value, false);
	xmlHttp.send(xmlDoc);
	responseText=xmlHttp.responseText;
	eval(responseText);
	if(!result){
		alert(getMessage(flag,"SS"));
		formObj.patient_id.select();
		formObj.patient_id.focus();
	}
}*/

function searchPatientName(i){
	var formObj	= document.formLoanIssueGroupList;
	if(eval("formObj.patient_id_"+i).value==""){
		eval("formObj.patient_name_"+i).value="";
		return;
	}

	var xmlHttp = new XMLHttpRequest();
	var xmlDoc="";
	xmlDoc.loadXML(getXMLString(null));
	xmlHttp.open("POST", "../../eSS/jsp/LoanIssueGroupValidate.jsp?validate=PATIENT_NAME&patient_id="+eval("formObj.patient_id_"+i).value+"&index_val="+i, false);
	xmlHttp.send(xmlDoc);
	responseText=xmlHttp.responseText;
	eval(responseText);
	if(!result){
		alert(getMessage(flag,"SS"));
		eval("formObj.patient_id_"+i).select();
		eval("formObj.patient_id_"+i).focus();
	}
}

/*function setPatientName(patient_name){
	//var formObj = top.content.f_query_add_mod.frameLoanIssueGroupDetail.document.formLoanIssueGroupDetail;
	var formObj = document.formLoanIssueGroupDetail;
	formObj.patient_name.value=patient_name;
}*/

function setPatientName(i,patient_name){
	//var formObj = top.content.f_query_add_mod.frameLoanIssueGroupDetail.document.formLoanIssueGroupDetail;
	var formObj = document.formLoanIssueGroupList;
	if(patient_name!=null || patient_name!="")
		eval("formObj.patient_name_"+i).value=patient_name;
}
function searchTrayDetail(i,fr_store_code){
	var formObj	= document.formLoanIssueGroupList;
	
	if(eval("formObj.tray_no_"+i).value==""){
		clearTrayDetails(i);
		return;
	}
	
	if (!checkIntegerFormat(eval("formObj.tray_no_"+i) ))return;

	var xmlHttp = new XMLHttpRequest();
	var xmlDoc="";
	xmlDoc.loadXML(getEnhancedXMLString(formObj));
	xmlHttp.open("POST", "../../eSS/jsp/LoanIssueGroupValidate.jsp?validate=TRAY_DETAIL&tray_no="+eval("formObj.tray_no_"+i).value+"&group_code="+eval("formObj.issue_group_code_"+i).value+"&index_val="+i+"&fr_store_code="+fr_store_code, false);
	xmlHttp.send(xmlDoc);
	responseText=xmlHttp.responseText;
	eval(responseText);
	if(!result){
		alert(getMessage(flag,"SS"));
		//eval("formObj.tray_no_"+i).select();
		eval("formObj.tray_no_"+i).focus();
	}
}

/*function setTrayDetail(tray_no, bin_location_code, expiry_date, issue_cost){
	//var formObj							=	top.content.f_query_add_mod.frameLoanIssueGroupDetail.document.formLoanIssueGroupDetail;
	var formObj							=	document.formLoanIssueGroupDetail;
	var locale							=	formObj.locale.value;
	formObj.expiry_date.value			=	convertDate(expiry_date,'DMY',"en",locale); 
	formObj.tray_no.value				=	tray_no;
	formObj.bin_location_code.value		=	bin_location_code;
	formObj.issue_cost.value			=	issue_cost;
}*/

function setTrayDetail(index,tray_no, bin_location_code, expiry_date, issue_cost){
	
	//var formObj							=	top.content.f_query_add_mod.frameLoanIssueGroupDetail.document.formLoanIssueGroupDetail;
	var formObj							=	document.formLoanIssueGroupList;
	var locale							=	formObj.locale.value;
	
	eval("formObj.expiry_date_"+index).value			=	convertDate(expiry_date,'DMY',"en",locale); 
	eval("formObj.tray_no_"+index).value				=	tray_no;
	eval("formObj.bin_location_code_"+index).value		=	bin_location_code;
	eval("formObj.issue_cost_"+index).value				=	issue_cost;
}


function clearGroupDetail(){
	var formObj = top.content.f_query_add_mod.frameLoanIssueGroupDetail.document.formLoanIssueGroupDetail;
	formObj.req_group_code.value="";
	formObj.request_qty.value="";
	formObj.description.value="";
}

function resetLoanIssueGroupDetail(){
	//var formObj=top.content.f_query_add_mod.frameLoanIssueGroupDetail.document.formLoanIssueGroupDetail;
	var formObj=document.formLoanIssueGroupDetail;
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
/*
function searchTrayNo(i){
	var formObj = document.formLoanIssueGroupList;

	var group_code	=	eval("formObj.issue_group_code_"+i).value;
	var group_desc	=	eval("formObj.issue_group_code_"+i).options[eval("formObj.issue_group_code_"+i).options.selectedIndex].text;
	eval("formObj.issue_group_desc_"+i).value  = group_desc;
	
	if(group_code=="")	return;
	var dialogHeight= "28" ;
    var dialogWidth = "47" ;
    var status = "no";
	
	var dialogUrl       = "../../eSS/jsp/LoanIssueGroupTrayQueryFrame.jsp?function_id="+parent.function_id+"&tray_no="+eval("formObj.tray_no_"+i).value+"&group_code="+group_code+"&group_desc="+group_desc+"&store_code="+parent.frameLoanIssueGroupHeader.document.formLoanIssueGroupHeader.fr_store_code.value+"&mode="+formObj.mode.value;
	var dialogArguments = ""
	var dialogFeatures  = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; scroll=no; status:" + status;
	var returnVal = window.showModalDialog(dialogUrl, dialogArguments, dialogFeatures);

	if( returnVal == null )
		return;
	else{
		eval("formObj.tray_no_"+i).value=returnVal;
		eval("formObj.tray_no_"+i).focus();
		searchTrayDetail(i); //Added by Rabbani on 13/12/2012
	}
}*/

function returnTrayNo(obj){
	var tray_no=obj.cells[0].innerText;
    top.window.returnValue = tray_no;
    top.close();
}

/*function clearTrayDetails(){
	document.formLoanIssueGroupDetail.tray_no.value="";
	document.formLoanIssueGroupDetail.bin_location_code.value="";
	document.formLoanIssueGroupDetail.expiry_date.value="";
	document.formLoanIssueGroupDetail.issue_cost.value="";
}*/

function clearTrayDetails(i){
	eval("document.formLoanIssueGroupList.tray_no_"+i).value="";
	eval("document.formLoanIssueGroupList.bin_location_code_"+i).value="";
	eval("document.formLoanIssueGroupList.expiry_date_"+i).value="";
	eval("document.formLoanIssueGroupList.issue_cost_"+i).value="";
}

function refreshDetails(){
	resetLoanIssueGroupDetail();
	refreshList();
}

function refreshList(){
	//top.content.f_query_add_mod.frameLoanIssueGroupList.document.location.reload();
	parent.frameLoanIssueGroupList.location.href="../../eSS/jsp/LoanIssueGroupList.jsp?index="+document.formLoanIssueGroupDetail.index.value+"&function_id="+parent.parent.function_id+"&mode="+document.formLoanIssueGroupDetail.mode.value+"&index="+document.formLoanIssueGroupDetail.index.value;
	//parent.frameLoanIssueGroupList.location.reload();


}

function listModify(index){
	parent.frameLoanIssueGroupDetail.location.href="../../eSS/jsp/LoanIssueGroupDetail.jsp?index="+index+"&function_id="+parent.parent.function_id+"&mode="+document.formLoanIssueGroupList.mode.value;
}

function Modify(obj){
	var doc_type_code=obj.cells[5].innerText;
	var doc_no=obj.cells[1].innerText;
	var req_doc_no=obj.cells[6].innerText;
	var Re_Issue	= "Issue_Group" ;
	top.content.f_query_add_mod.document.location.href="../../eSS/jsp/LoanIssueGroupFrame.jsp?mode="+MODE_MODIFY+"&function_id="+parent.parent.function_id+"&doc_type_code="+doc_type_code+"&doc_no="+doc_no+"&req_doc_no="+req_doc_no+"&Re_Issue="+Re_Issue;

	}

function LoanIssueGroupStoreValidate()
{
	
	var message1="INVALID_GROUP_FOR_STORE" ;
	var errorPage	 = "../../eCommon/jsp/error.jsp"
	//parent.parent.messageFrame.location.href = errorPage+"?err_num="+ getMessage(message1,"SS");
	messageFrame.location.href = errorPage+"?err_num="+ getMessage(message1,"SS");
}

function searchGroupCode( obj ) {
	var argumentArray  = new Array();
	var dataNameArray  = new Array();
	var dataValueArray = new Array();
	var dataTypeArray  = new Array();

	argumentArray[0] = document.formLoanIssueGroupDetail.SQL_SS_GROUP_LOOKUP_FOR_REPORT.value;
	dataNameArray  [0]="LANGUAGE_ID"
	dataValueArray [0]=document.formLoanIssueGroupDetail.locale.value;
	dataTypeArray  [0]=STRING;
	
	argumentArray[1] = dataNameArray;
	argumentArray[2] = dataValueArray;
	argumentArray[3] = dataTypeArray;
	argumentArray[4] = "2,3";
	argumentArray[5] = obj.value;
	argumentArray[6] = CODE_LINK;
	argumentArray[7] = CODE_DESC;

	returnedValues = CommonLookup(getLabel("Common.Group.label","Common"), argumentArray );
	if((returnedValues != null) && (returnedValues != "") )  {
		obj.value = returnedValues[0];

		var formObj=document.formLoanIssueGroupDetail;
		var xmlHttp = new XMLHttpRequest();
		var xmlDoc="";
		xmlDoc.loadXML(getXMLString(null));
		xmlHttp.open("POST", "../../eSS/jsp/LoanIssueGroupValidate.jsp?req_group_code=" + formObj.description.value + "&validate=POPULATE_AUTH_GROUP_CODE", false);
		xmlHttp.send(xmlDoc);
		responseText=xmlHttp.responseText;
		eval(responseText);
		/*if(formObj.mode.value==MODE_INSERT)
			formObj.auth_group_code.disabled=true;
		else
			formObj.auth_group_code.disabled=false;*/
	} 
} 
function RemoveTrayno(i,fr_store_code){
	var formObj	= document.formLoanIssueGroupList;
	if(eval("formObj.tray_no_"+i).value==""){
		clearTrayDetails(i);
	}	
	var xmlHttp = new XMLHttpRequest();
	var xmlDoc="";
	xmlDoc.loadXML(getEnhancedXMLString(formObj));
	xmlHttp.open("POST", "../../eSS/jsp/LoanIssueGroupValidate.jsp?validate=REMOVE_TRAY_NO&tray_no="+eval("formObj.tray_no_"+i).value+"&index_val="+i+"&fr_store_code="+fr_store_code, false);
	xmlHttp.send(xmlDoc);
	responseText=xmlHttp.responseText;
	eval(responseText);	
}
function ChangeIssueGroup(i,fr_store_code){
	clearTrayDetails(i);
	var formObj	= document.formLoanIssueGroupList;
	var xmlHttp = new XMLHttpRequest();
	var xmlDoc="";
	xmlDoc.loadXML(getEnhancedXMLString(formObj));
	xmlHttp.open("POST", "../../eSS/jsp/LoanIssueGroupValidate.jsp?validate=CHANGE_ISSUE_GROUP&tray_no="+eval("formObj.tray_no_"+i).value+"&index_val="+i+"&fr_store_code="+fr_store_code, false);
	xmlHttp.send(xmlDoc);
	responseText=xmlHttp.responseText;
	eval(responseText);	
}
function CloseReIssueWindow(){
	window.close();
}
