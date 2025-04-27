/*
*Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
* 
*Warning: This computer program is protected by copyright law and international treaties.
*Unauthorized reproduction or distribution of this program, or any portion of it, 
*may result in severe civil and criminal penalties, and will be prosecuted to 
*the maximum extent possible under the law.
*/
function create(){
	f_query_add_mod.location.href = "../../eSS/jsp/AutoclavingFrame.jsp?mode="+MODE_INSERT+"&menu_id="+menu_id+"&module_id="+module_id+"&function_id="+function_id ;
}

function query(){
	f_query_add_mod.location.href = "../../eSS/jsp/AutoclavingQueryFrame.jsp?function_id="+function_id ;
}

function onSuccess(){
	var mode = f_query_add_mod.frameAutoclavingHeader.document.formAutoclavingHeader.mode.value;
	if( mode == MODE_INSERT ) {
		reset();
	}
	else if((f_query_add_mod.frameAutoclavingHeader.document.formAutoclavingHeader.finalized.value=="Y")&&(f_query_add_mod.frameAutoclavingHeader.document.formAutoclavingHeader.load_status.value=="F")){
		top.content.f_query_add_mod.document.location.href="../../eSS/jsp/AutoclavingFrame.jsp?mode="+MODE_MODIFY+"&function_id="+function_id+"&autoclave_wash_unit_code="+f_query_add_mod.frameAutoclavingHeader.formAutoclavingHeader.autoclave_wash_unit_code.value+"&load_no="+flag;
	}
	else if( (mode == MODE_DELETE)||(f_query_add_mod.frameAutoclavingHeader.document.formAutoclavingHeader.finalized.value=="Y")) 

		f_query_add_mod.document.location.href="../../eCommon/html/blank.html";
	else
		f_query_add_mod.document.location.reload();
}

function reset() {
	if(f_query_add_mod.frameAutoclavingQueryCriteria!=null){
		f_query_add_mod.frameAutoclavingQueryCriteria.document.formAutoclavingQueryCriteria.reset();
		f_query_add_mod.frameAutoclavingQueryResult.document.location.href="../../eCommon/html/blank.html";
	}
	else if(f_query_add_mod.frameAutoclavingHeader!=null){
		f_query_add_mod.location.reload();
	}
}


async function deleterecord(){
	var formObj	=	f_query_add_mod.frameAutoclavingHeader.document.formAutoclavingHeader;
	if(formObj.mode.value==MODE_MODIFY){
		var confirmation = await confirmDelete();
		if(confirmation=="Yes"){
			formObj.mode.value=MODE_DELETE;
			eval(formApply(formObj,SS_CONTROLLER).replace(/<\/?[^>]+(>|$)|\s+|\r?\n/g, ""));
			messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num="+ message;
			if( result ) {
				onSuccess();
			}
			else{
				formObj.mode.value=MODE_MODIFY;
			}
		}
		else {
			messageFrame.location.href = "../../eCommon/jsp/error.jsp?error_value=0&err_num="+getMessage("OPERATION_CANCELLED","SS");
		}
	}
	else {
		messageFrame.location.href = "../../eCommon/jsp/error.jsp?error_value=0&err_num=";
	}
}

async function apply(){
	var formObjlist=f_query_add_mod.frameAutoclavingList.document.formAutoclavingList;
	
	if(formObjlist==undefined){
	messageFrame.location.href = "../../eCommon/jsp/error.jsp?error_value=0&err_num="+getMessage("ATLEAST_ONE_SELECTED","SS");
				return false;}
	var totalCBox=escape(parseInt(formObjlist.totalRecords.value));
	var count=0;
	count=escape(parseInt(formObjlist.count.value));
//Commented against inc#43640
	/*if((formObjlist.selectAll.value=="Y")&&(formObjlist.mode.value=="1")){
	
		if(count==0)
		{
				messageFrame.location.href = "../../eCommon/jsp/error.jsp?error_value=0&err_num="+getMessage("ONE_RECORD_NEEDED","SS");
				return false;
		}
	}
	
		
	
	if((formObjlist.selectAll.value!="Y")&&(formObjlist.mode.value=="1"))
		{
			
				if(count==0){
	
				messageFrame.location.href = "../../eCommon/jsp/error.jsp?error_value=0&err_num="+getMessage("ONE_RECORD_NEEDED","SS");
				return false;
			}
		
		}*/
		
		if((formObjlist.selectAll.value!="Y")&&(formObjlist.mode.value=="2"))
		{
			for(i=0;i<totalCBox;i++)
			{ 
				checkBoxObj=eval("formObjlist.checkbox"+i);
			  if (checkBoxObj != null){ //Added by Rabbani on 10/12/2012
				if(checkBoxObj.checked)
					count=count+1;
			}
		  }
				/*if(totalCBox==count){
			
					messageFrame.location.href = "../../eCommon/jsp/error.jsp?error_value=0&err_num="+getMessage("ONE_RECORD_NEEDED","SS");
				return false;}*/

		
		}
			
		if((formObjlist.selectAll.value=="Y")&&(formObjlist.mode.value==2))
		{
			var totalCBox_1=0;
			totalCBox_1=totalCBox;
			for(i=0;i<totalCBox;i++)
			{ 
				checkBoxObj=eval("formObjlist.checkbox"+i);
				 if (checkBoxObj != null){ //Added by Rabbani on 10/12/2012
				if(checkBoxObj.checked)
					totalCBox_1=totalCBox_1-1;
			}
			}
				/*if(totalCBox_1<=0){
		
					messageFrame.location.href = "../../eCommon/jsp/error.jsp?error_value=0&err_num="+getMessage("ONE_RECORD_NEEDED","SS");
				return false;}*/

		
		}
		//Commented against inc#43640
		/*if((formObjlist.selectAll.value=" ")&&(formObjlist.mode.value=="1")&&(formObjlist.count.value==""))
		{
			
				
		
					messageFrame.location.href = "../../eCommon/jsp/error.jsp?error_value=0&err_num="+getMessage("ONE_RECORD_NEEDED","SS");
				return false;

		
		}*/
	var formObj		=	f_query_add_mod.frameAutoclavingHeader.document.formAutoclavingHeader ;
	var blankObject	=	null;
	var fields		=	new Array();
	var fieldNames	=	new Array();
	var	index		=	0;
	var queryString =	"";

	formObj.autoclave_date.value=	convertDate1(formObj.autoclave_date.value,'DMY',formObj.locale.value,"en"); 
	fields[index]		=	formObj.autoclave_wash_unit_code;
	fieldNames[index++]	=	getLabel("eSS.AutoclaveUnit.label","SS");
	fields[index]		=	formObj.autoclave_date;
	fieldNames[index++]	=	getLabel("eSS.AutoclaveDate.label","SS");
	fields[index]		=	formObj.service_location;
	fieldNames[index++]	=	getLabel("eSS.ServiceLocation.label","SS");

	var errorPage	=	"../../eCommon/jsp/error.jsp";
	blankObject		=	getBlankField( fields, fieldNames, messageFrame);
	if(blankObject==null) {

		//if (formObj.SS_AUTOCLAVING_FINALIZE!=null) Commented by Sakti  since we have finalize in function level AAKH_SCF_158
		//if(formObj.entry_completed_yn.checked && (formObj.SS_AUTOCLAVING_FINALIZE.value=="Y")){
			if(formObj.entry_completed_yn.checked) {
		
			var confirmation = await confirmFinalize();
			if(confirmation=="Yes"){
				formObj.finalized.value="Y";
			}
		if (confirmation !=	"No") {
		
			eval(formApply(formObj,SS_CONTROLLER).replace(/<\/?[^>]+(>|$)|\s{2,}|\r?\n/g, ""));
			if(!((flag==null)||(flag=="null")||(flag=="")))
			message=message+"<br>Load No: "+flag;
			messageFrame.location.href = errorPage+"?err_num="+ message;
			if( result ) {
			onSuccess();
			}
		}
		else {
			eval(formApply(formObj,SS_CONTROLLER).replace(/<\/?[^>]+(>|$)|\s{2,}|\r?\n/g, ""));
			messageFrame.location.href = errorPage+"?err_num="+ message;
			if( result ) {
			onSuccess();
			}
		}
		}
		else
		{
			
			eval(formApply(formObj,SS_CONTROLLER).replace(/<\/?[^>]+(>|$)|\s{2,}|\r?\n/g, ""));
			if(!((flag==null)||(flag=="null")||(flag=="")))
			message=message+"<br>Load No: "+flag;
			messageFrame.location.href = errorPage+"?err_num="+ message;
			if( result ) {
			onSuccess();
			}
	}
	}
	else{
		blankObject.focus();
	}
}




function checkDoc_type_code(){
	if(document.formAutoclavingHeader.doc_type_code.value=="") return;
	var xmlHttp = new XMLHttpRequest();
	var xmlDoc="";
	xmlDoc = new DOMParser().parseFromString(getXMLString(null), "text/xml");
	// xmlDoc.loadXML(getXMLString(null));
	xmlHttp.open("POST", "../../eSS/jsp/AutoclavingValidate.jsp?validate=DOC_TYPE_CODE&doc_type_code=" + document.formAutoclavingHeader.doc_type_code.value, false);
	xmlHttp.send(xmlDoc);
	responseText=xmlHttp.responseText.replace(/<\/?[^>]+(>|$)|\s+|\r?\n/g, "");

	eval(responseText);
}

function quantityAlert(_total_quantity, _sterilized_quantity, _unsterilized_quantity){
	alert("WARNING! Available Quantity is "+_total_quantity+" (Sterilized = "+_sterilized_quantity+", Unsterilized = "+_unsterilized_quantity+")");
}
function convertDate1(date,format,from,to){
	
	var xhr =  getXHR();
	var url = "../../eCommon/jsp/DateUtils.jsp?methodName=convertDate&format="+format+"&date="+date+"&fromLocale="+from+"&toLocale="+to;
    xhr.open("POST", url, false);
	xhr.setRequestHeader("Content-Type","text/plain")
   	xhr.send("");
	
	var xmlText =  trimString(xhr.responseText);

	f_query_add_mod.frames[0].document.formAutoclavingHeader.autoclave_date.value=xmlText;
	return(xmlText);
}
function getXHR(){
		var request = false;
	try {
		request = new XMLHttpRequest();		
	}catch (trymicrosoft) {		
		try {
			request = new ActiveXObject("Msxml2.XMLHTTP");
		}catch (othermicrosoft) {
			try {
				request = new ActiveXObject("Microsoft.XMLHTTP");
			} catch (failed) {
							request = false;
				
			}
		}
    }
	if (!request){
		alert("System Error initializing XMLHttpRequest!");
		return;
	}else return request;
}
function clearList(){
	var xmlHttp = new XMLHttpRequest();
	var xmlDoc="";
	xmlDoc = new DOMParser().parseFromString(getXMLString(null), "text/xml");
	//xmlDoc.loadXML(getXMLString(null));
	xmlHttp.open("POST", "../../eSS/jsp/AutoclavingValidate.jsp?validate=CLEAR_LIST", false);
	xmlHttp.send(xmlDoc);
	responseText=xmlHttp.responseText.replace(/<\/?[^>]+(>|$)|\s+|\r?\n/g, "");
	refreshList();
}

function enableDocNo(bValue){
	if(!bValue){
		parent.frameAutoclavingHeader.document.formAutoclavingHeader.doc_no.value="";	
	}
	parent.frameAutoclavingHeader.document.formAutoclavingHeader.doc_no.disabled=!bValue;
}

function addToList(){
	var formObj=  document.formAutoclavingDetail;
	var fields = new Array ( formObj.description, formObj.tray_no, formObj.writeoff_reason);
	var names  =  new Array ( getLabel("Common.Group.label","Common"),getLabel("eSS.TrayNo.label","SS"),getLabel("eSS.WriteoffReason.label","SS") );
	var obj    =null;
	var messageFrame = parent.parent.messageFrame; 
	var errorPage	 = "../../eCommon/jsp/error.jsp"
	obj=getBlankField( fields, names, messageFrame,errorPage);
	if(obj==null) {
		var xmlHttp = new XMLHttpRequest();
		var xmlDoc="";
		xmlDoc = new DOMParser().parseFromString(getXMLString(null), "text/xml");
//		xmlDoc.loadXML(getXMLString(null));
		xmlHttp.open("POST", "../../eSS/jsp/AutoclavingValidate.jsp?group_code=" + formObj.group_code.value + "&group_type=" + formObj.group_type.value +"&tray_no=" + formObj.tray_no.value +"&write_off_reason_code=" + formObj.writeoff_reason.value +"&index="+formObj.index.value+ "&description="+formObj.description.value+ "&remarks="+formObj.remarks.value+ "&writeoff_reason="+formObj.writeoff_reason.value+ "&store_code="+parent.frameAutoclavingHeader.document.formAutoclavingHeader.store_code.value+ "&validate=ADD_TO_LIST", false);
		xmlHttp.send(xmlDoc);
		responseText=xmlHttp.responseText;
		eval(responseText.replace(/<\/?[^>]+(>|$)|\s+|\r?\n/g, ""));
		if( result ) {
			refreshDetails();
		}
		else{
			messageFrame.location.href = errorPage+"?err_num="+ getMessage(message,"SS");
		}
	}
	else
		obj.focus();
}

async function searchGroupCode( objCode, objDesc ) {
	var argumentArray  = new Array();
	var dataNameArray  = new Array();
	var dataValueArray = new Array();
	var dataTypeArray  = new Array();

	dataNameArray[0] = "group_type";
	dataValueArray[0]= document.formAutoclavingDetail.group_type.value;
	dataTypeArray[0] = STRING;

	argumentArray[0] = document.formAutoclavingDetail.SQL_SS_GROUP_LOOKUP_BASED_ON_TYPE.value;
	argumentArray[1] = dataNameArray;
	argumentArray[2] = dataValueArray;
	argumentArray[3] = dataTypeArray;
	argumentArray[4] = "2,3";
	argumentArray[5] = "";
	argumentArray[6] = CODE_LINK;
	argumentArray[7] = CODE_DESC;

	returnedValues = await CommonLookup( "Group", argumentArray );
	if((returnedValues != null) && (returnedValues != "") )  {
		if(returnedValues.length === 1){
			returnedValues = returnedValues[0].split(',');
		}
		objCode.value = returnedValues[0];
		objDesc.value = returnedValues[1];
	} 
}

function clearGroupDetail(){
	var formObj = top.content.f_query_add_mod.frameAutoclavingDetail.document.formAutoclavingDetail;
	formObj.group_code.value="";
}

function resetGroupDetail(){
	var formObj = top.content.f_query_add_mod.frameAutoclavingDetail.document.formAutoclavingDetail;
	formObj.group_type.value="E";
	formObj.group_type.disabled=false;
	formObj.group_code.value="";
	formObj.writeoff_reason.value="";
	formObj.remarks.value="";
	formObj.tray_no.value="";
	formObj.description.value="";
	formObj.description.disabled=false;
	formObj.index.value="-1";
	formObj.apply.value=getLabel("Common.Add.label","Common");
}

function refreshDetails(){
	displayMessage(top.content.messageFrame,"");
	resetGroupDetail();
	refreshList();
}

function refreshList(){
	top.content.f_query_add_mod.frameAutoclavingList.document.location.reload();
}

function listModify(index){
	parent.frameAutoclavingDetail.location.href="../../eSS/jsp/AutoclavingDetail.jsp?index="+index;
}

function Modify(obj){
	var autoclave_wash_unit_code=obj.cells[5].innerText;
	var load_no=obj.cells[1].innerText;
	top.content.f_query_add_mod.document.location.href="../../eSS/jsp/AutoclavingFrame.jsp?mode="+MODE_MODIFY+"&function_id="+parent.parent.function_id+"&menu_id="+parent.parent.menu_id+"&module_id="+parent.parent.module_id+"&autoclave_wash_unit_code="+autoclave_wash_unit_code+"&load_no="+load_no;

}


async function searchTrayNo(){
	var formObj = document.formAutoclavingDetail;
	var group_code	=	formObj.group_code.value;
	var group_desc	=	formObj.description.value;
	if(group_code=="")	return;

	var dialogHeight= "28" ;
    var dialogWidth = "43" ;
    var status = "no";
	
	var dialogUrl       = "../../eSS/jsp/AutoclavingTrayQueryFrame.jsp?function_id="+parent.function_id+"&tray_no="+formObj.tray_no.value+"&group_code="+group_code+"&group_desc="+group_desc+"&store_code="+parent.frameAutoclavingHeader.document.formAutoclavingHeader.store_code.value;
	var dialogArguments = ""
	var dialogFeatures  = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; scroll=no; status:" + status;
	var returnVal = await window.showModalDialog(dialogUrl, dialogArguments, dialogFeatures);

	if( returnVal == null )
		return;
	else{
		formObj.tray_no.value=returnVal;
		formObj.tray_no.focus();
	}
}

function searchTrayDetail( objCode, objDesc ) {
var formObj	= document.forms[0];
	if(formObj.tray_no.value==""){
		clearTrayDetails();
		return;
	}

	var xmlHttp = new XMLHttpRequest();
	var xmlDoc="";
	xmlDoc = new DOMParser().parseFromString(getXMLString(null), "text/xml");
//	xmlDoc.loadXML(getXMLString(null));
	xmlHttp.open("POST", "../../eSS/jsp/AutoclavingValidate.jsp?validate=TRAY_DETAIL&tray_no="+formObj.tray_no.value+"&group_code="+formObj.group_code.value, false);
	xmlHttp.send(xmlDoc);
	responseText=xmlHttp.responseText;
	eval(responseText.replace(/<\/?[^>]+(>|$)|\s+|\r?\n/g, ""));
	if(!result){
		alert(getMessage(flag));
		formObj.tray_no.select();
		formObj.tray_no.focus();
	}
	} 

	function clearTrayDetails(){
	document.formAutoclavingDetail.tray_no.value="";
}

function setTrayDetail(tray_no, bin_location_code, expiry_date){
	var formObj = top.content.f_query_add_mod.frameAutoclavingDetail.document.formAutoclavingDetail;
	formObj.tray_no.value=tray_no;
}


async function searchWriteOffReason(objCode, objDesc){
	var argumentArray  = new Array();
	var dataNameArray  = new Array();
	var dataValueArray = new Array();
	var dataTypeArray  = new Array();


	argumentArray[0] = document.formAutoclavingDetail.SS_WRITE_OFF_REASON_LOOKUP.value;
	argumentArray[1] = dataNameArray;
	argumentArray[2] = dataValueArray;
	argumentArray[3] = dataTypeArray;
	argumentArray[4] = "1,2";
	argumentArray[5] = "";
	argumentArray[6] = CODE_LINK;
	argumentArray[7] = CODE_DESC;

	returnedValues = await CommonLookup( "WriteOff", argumentArray );
	if((returnedValues != null) && (returnedValues != "") )  {
		if(returnedValues.length === 1){
			returnedValues = returnedValues[0].split(',')
		}
		objCode.value = returnedValues[0];
		objDesc.value = returnedValues[1];
	} 
}
function returnTrayNo(obj){
	var tray_no=obj.cells[0].innerText;
    top.window.returnValue = tray_no;
    top.close();
}
function PopulateROF()
{
		var autoclave_wash_unit_code		=		parent.frameAutoclavingHeader.document.formAutoclavingHeader.autoclave_wash_unit_code.value;
		var autoclave_date					=		parent.frameAutoclavingHeader.document.formAutoclavingHeader.autoclave_date.value;
		var store_code						=		parent.frameAutoclavingHeader.document.formAutoclavingHeader.store_code.value;
		var load_no							=		parent.frameAutoclavingHeader.document.formAutoclavingHeader.load_no.value;
		var sterile_type					=		parent.frameAutoclavingHeader.document.formAutoclavingHeader.sterile_type.value;
		var service_location				=		parent.frameAutoclavingHeader.document.formAutoclavingHeader.service_location.value;
		var mode							=		parent.frameAutoclavingHeader.document.formAutoclavingHeader.mode.value;

	if(parent.frameAutoclavingHeader.document.formAutoclavingHeader.autoclave_date.value.length <1)
	{
		alert(getMessage("AUTOCLAVING_UNIT_DATE_NOT_BLANK","SS"));
		parent.frameAutoclavingHeader.document.formAutoclavingHeader.autoclave_date.select();
		parent.frameAutoclavingHeader.document.formAutoclavingHeader.autoclave_date.focus();
		flag=false;
		return false;
	}

		var formObj = parent.parent.f_query_add_mod.frames[0].document.formAutoclavingHeader; 
		
		var blankObject	=	null;
		var fields = new Array (formObj.autoclave_wash_unit_code,formObj.service_location, formObj.autoclave_date,formObj.store_code);
	
		var fieldNames = new Array (getLabel("eSS.AutoclaveUnit.label","SS"),getLabel("eSS.ServiceLocation.label","SS"),	getLabel("eSS.AutoclaveDate.label","SS"),getLabel("Common.Store.label","Common"));	

		blankObject = getBlankField1(fields, fieldNames, parent.parent.messageFrame); 
		
		if(blankObject==null) 
		{
		
			parent.frameAutoclavingList.location.href='../../eSS/jsp/AutoclavingList.jsp?mode='+mode+'&autoclave_wash_unit_code='+autoclave_wash_unit_code+'&store_code='+store_code+'&load_no='+load_no+'&sterile_type='+sterile_type+'&service_location='+service_location;
		}

		else{
	
		blankObject.focus();
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
           errors += getMessage("SHOULD_NOT_BE_BLANK","Common",new Array(encodeURIComponent(legends[i])))+"<br>"
        }
    }
    if ( errors.length != 0 ) {
        messageFrame.location.href=errorPage+"?err_num="+errors;
    }
        return obj ;
}


function PopulateOtherDetails(autoclave_wash_unit_code) 
{		
		if( autoclave_wash_unit_code.value == "" ) 
			return;
		var bean_id = document.formAutoclavingHeader.bean_id.value;
		var bean_name = document.formAutoclavingHeader.bean_name.value;
		
		
		var xmlHttp = new XMLHttpRequest();
		var xmlDoc = "";
		var arrayObject = new Array();
		arrayObject[0] = autoclave_wash_unit_code;
		xmlStr = getXMLString(arrayObject);
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
//		xmlDom.loadXML(xmlStr);
		xmlHttp.open("POST", "AutoclavingValidate.jsp?bean_id=" + bean_id + "&bean_name=" + bean_name + "&autoclave_wash_unit_code=" + autoclave_wash_unit_code+ "&function_type=1", false);
		xmlHttp.send( xmlDoc );
		responseText=xmlHttp.responseText;
//		console.log(responseText.replace(/<\/?[^>]+(>|$)|\s+|\r?\n/g, ""));
		eval( responseText.replace(/<\/?[^>]+(>|$)|\s+|\r?\n/g, ""));

}

function changeStatusCheckBox(obj)
{
	formObj=parent.frameAutoclavingList.document.formAutoclavingList;	
	var count=0;
	for(var i=0;i<formObj.elements.length;i++)
	{
		if(formObj.elements[i].type=="checkbox")
		{
			if(obj.checked)
			{
				formObj.elements[i].checked=true;
				formObj.elements[i].value='Y';
				formObj.selectAll.value='Y';
				if(i!==0)
					assignValue(formObj.elements[i]);
				count=count+1;

			}
			else
			{
				formObj.elements[i].checked=false;
				formObj.elements[i].value='N';
				formObj.selectAll.value='N';
				if(i!==0)
					assignValue(formObj.elements[i]);
			}
			

			if(formObj.elements[i].name!="selectAll")
		{
			alterBean(formObj.elements[i]);
			}
		}
	}
	
	formObj.count.value=count-1;

	if(formObj.selectAll.value=="Y")
	{
		formObj.checked_yn.value="Y";
	}
	
}

function assignValue(obj){

	if(obj.checked)
		obj.value="Y";
	else
		obj.value="N";
	var val= (document.forms[0].count.value === 'NaN' || document.forms[0].count.value === null || document.forms[0].count.value === undefined || document.forms[0].count.value === '') ? 0 : document.forms[0].count.value;
	if((document.forms[0].mode.value=="1")&&(obj.value=="Y")){
		document.forms[0].count.value=parseInt(val)+1;
		
	}
	if((document.forms[0].mode.value=="1")&&(obj.value=="N")){
		document.forms[0].count.value=parseInt(val)-1;
	}
	 const parentTr = obj.closest('tr');
     const trayVal  = parentTr.querySelector('input[id*="tray_no"]').value;
     
     const xmlStr = "<root><SEARCH tray_no=" + '"' +trayVal+ '" ' +"val="+'"'+ obj.value +'" ' +"bean_name="+'"eSS.AutoclavingBean" ' + "function=" +'"updateAutoClave" /></root>' ;
     //console.log(xmlStr);
     var xmlDoc="";
     var xmlHttp = new XMLHttpRequest();
     xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
     beforePost(xmlStr) ;
     xmlHttp.open("POST",SS_CONTROLLER, false);
 	 xmlHttp.setRequestHeader("Content-type","application/x-www-form-urlencoded");
     xmlHttp.send(xmlDoc);
}

function activeLink() {
	formObj=parent.frameAutoclavingList.document.formAutoclavingList;
	
	if(formObj.start.value != 0 ){
			parent.frameAutoclavingList.document.getElementById("prev").style.visibility='visible';
	}
	else{
	parent.frameAutoclavingList.document.getElementById("prev").style.visibility='hidden';
	}

	if(  !((parseInt(formObj.start.value) +parseInt(formObj.displaySize.value))>= formObj.totalRecords.value ))
		parent.frameAutoclavingList.document.getElementById("next").style.visibility='visible';
	else
		parent.frameAutoclavingList.document.getElementById("next").style.visibility='hidden';
}



function goNext(source_mode) {
	formObj=parent.frameAutoclavingList.document.formAutoclavingList;
	mode=formObj.mode.value;

	start = parseInt( formObj.start.value) +parseInt( formObj.displaySize.value ) ;
	end = parseInt( formObj.end.value )+ parseInt(formObj.displaySize.value ) ;
	
	xmlStr=formXMLString(formObj.start.value,formObj.end.value,formObj.totalRecords.value,formObj);
	formValidation(xmlStr,formObj.start.value,formObj.end.value,formObj.totalRecords.value);

	if(formObj.mode.value==MODE_INSERT)
		modeVal=MODE_INSERT;
	else
		modeVal=MODE_MODIFY;
	
	var formObjAutoclaving		=	parent.frameAutoclavingHeader.document.formAutoclavingHeader;
	parent.frameAutoclavingList.location.href="../../eSS/jsp/AutoclavingList.jsp?mode="+mode+"&autoclave_wash_unit_code="+formObjAutoclaving.autoclave_wash_unit_code.value+"&autoclave_date="+formObjAutoclaving.autoclave_date.value+"&temperature="+formObjAutoclaving.temperature.value+"&load_no="+formObjAutoclaving.load_no.value+"&store_code="+formObjAutoclaving.store_code.value+"&from="+start+"&to="+end;
}	

function goPrev(source_mode) {
	
	formObj=parent.frameAutoclavingList.document.formAutoclavingList;
	

	mode=formObj.mode.value;
	start = parseInt( formObj.start.value  )-parseInt(  formObj.displaySize.value)  ;
	end = parseInt( formObj.end.value )- parseInt(formObj.displaySize.value ) ;
	var selectAll="";
	if(formObj.checked_yn.value=="Y"){
		
		formObj.selectAll.checked=true;
		formObj.selectAll.value="Y";
		selectAll="Y";

	}
	xmlStr=formXMLString(formObj.start.value,formObj.end.value,formObj.totalRecords.value,formObj);
	formValidation(xmlStr,formObj.start.value,formObj.end.value,formObj.totalRecords.value);

	if(formObj.mode.value==MODE_INSERT)
		modeVal=MODE_INSERT;
	else
		modeVal=MODE_MODIFY;

	var formObjAutoclaving		=	parent.frameAutoclavingHeader.document.formAutoclavingHeader;
	parent.frameAutoclavingList.location.href="../../eSS/jsp/AutoclavingList.jsp?mode="+mode+"&autoclave_wash_unit_code="+formObjAutoclaving.autoclave_wash_unit_code.value+"&autoclave_date="+formObjAutoclaving.autoclave_date.value+"&temperature="+formObjAutoclaving.temperature.value+"&load_no="+formObjAutoclaving.load_no.value+"&store_code="+formObjAutoclaving.store_code.value+"&from="+start+"&to="+end+"&selectAll="+selectAll+"&count_all="+formObj.count.value;
	

	
}	


function formXMLString(start,end,totalRecord,formObj){
	var xmlStr ="<root><SEARCH ";
		if(parseInt(end)>parseInt(totalRecord))
		end=totalRecord;
			//for(var i=start;i<end;i++) ////commented by Rabbani INC NO:32068 on 13/12/2012
			for(var i=parseInt(start);i<parseInt(end);i++) //Added by Rabbani INC NO:32068 on 13/12/2012
								xmlStr += " SELECTED"+i+"=\""+ eval("formObj.checkbox"+i+".value") +"\" ";
	
		xmlStr +=" /></root>";
	return xmlStr;
}
function formValidation(xmlStr,start,end,totalRecords,checked_yn,idx,tray_no,index){
	index="-1";
	var select_all="";
	if(formObj.checked_yn.value=="Y"){
		select_all="Y";
	}
	temp_jsp="../../eSS/jsp/AutoclavingValidation.jsp?idx="+idx+"&checked_yn="+checked_yn+"&start="+start+"&end="+end+"&totalRecords="+totalRecords+"&function_id=autoclaving_detail&tray_no="+tray_no+"&index="+index+"&select_all="+select_all;

	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest() ;
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");

	xmlHttp.open("POST",temp_jsp,false);
	xmlHttp.send(xmlDoc);
	responseText=xmlHttp.responseText.replace(/<\/?[^>]+(>|$)|\s+|\r?\n/g, "") ;
	return true;
}

function alterBean(obj, index,tray_no)
{
	var name	=	obj.name;
	var len		=	obj.name.length;
	var idx		=	name.substring(8,len);
	formObj		=	parent.frameAutoclavingList.document.formAutoclavingList;
	start		=	parseInt( formObj.start.value  )-parseInt(  formObj.displaySize.value)  ;
	end			=	parseInt( formObj.end.value )- parseInt(formObj.displaySize.value ) ;

	xmlStr		=	formXMLString(formObj.start.value,formObj.end.value,formObj.totalRecords.value,formObj);

	formValidation(xmlStr,formObj.start.value,formObj.end.value,formObj.totalRecords.value,obj.checked,idx,tray_no,index);
}



function checkRecord()
{
			parent.parent.messageFrame.location.href = "../../eCommon/jsp/error.jsp?error_value=0&err_num="+getMessage("AUTO_RECORD_NOT_FOUND","SS");
}

function refreshMessageFrame()
{
     parent.parent.messageFrame.location.href ='../../eCommon/jsp/error.jsp' ;
}


function deletePreviousRecord(){

    document.formAutoclavingHeader.temperature.value="";
	document.formAutoclavingHeader.sterile_type.value="";
	document.formAutoclavingHeader.sterilization_type.value="";
	document.formAutoclavingHeader.service_location.value="";
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




function checkSysdate(receiptdate,sysdate){
	
var flag=chkCurrentYear(receiptdate,sysdate);
if(ChkDate(receiptdate) && flag )
   {
		if(!checkdateWithSysDate(receiptdate,sysdate))
		{
		alert(getMessage("NOT_GRT_THAN_SYSDATE","SS"));
		receiptdate.select();
		receiptdate.focus();
		return false;
		}
   }

	
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



function checkAutoClavingDate(autodate,sysdate)
{
	var locale			=	document.formAutoclavingHeader.locale.value;
	var flag=true;
	if(CheckDate(autodate)){

			autodate.value	=	convertDate(autodate.value,'DMY',locale,"en"); 
			flag			=	true;
		}
	else
	{
			flag			=	false;
		
	}
	

	

	
	
	if(flag)
	checkSysdate(autodate,sysdate);
	
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

