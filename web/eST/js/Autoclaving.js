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
//PROBLEM TO BE CHECKED///////////////////////////////////////
//		if(!((flag==null)||(flag=="null")||(flag==""))){
//			setTimeout("messageFrame.location.href=\"../../eCommon/jsp/error.jsp?err_num=Load No: \""+flag,1000);;
//			top.content.f_query_add_mod.document.location.href="../../eSS/jsp/AutoclavingFrame.jsp?mode="+MODE_MODIFY+"&function_id="+function_id+"&autoclave_wash_unit_code="+f_query_add_mod.frameAutoclavingHeader.formAutoclavingHeader.autoclave_wash_unit_code.value+"&load_no="+flag;
//		}
//PROBLEM TO BE CHECKED///////////////////////////////////////
	}
	else if((f_query_add_mod.frameAutoclavingHeader.document.formAutoclavingHeader.finalized.value=="Y")&&(f_query_add_mod.frameAutoclavingHeader.document.formAutoclavingHeader.load_status.value=="F")){
		top.content.f_query_add_mod.document.location.href="../../eSS/jsp/AutoclavingFrame.jsp?mode="+MODE_MODIFY+"&function_id="+function_id+"&autoclave_wash_unit_code="+f_query_add_mod.frameAutoclavingHeader.formAutoclavingHeader.autoclave_wash_unit_code.value+"&load_no="+flag;
	}
	else if( (mode == MODE_DELETE)||(f_query_add_mod.frameAutoclavingHeader.document.formAutoclavingHeader.finalized.value=="Y")) 
//	else if( mode == MODE_DELETE) 
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


function deleterecord(){
	var formObj	=	f_query_add_mod.frameAutoclavingHeader.document.formAutoclavingHeader;
	if(formObj.mode.value==MODE_MODIFY){
		var confirmation = confirmDelete();//window.confirm("Current record will be deleted!!");
		if(confirmation=="Yes"){
			formObj.mode.value=MODE_DELETE;
			eval(formApply(formObj,SS_CONTROLLER));
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
//if(searchTrayDetail())
//	{	
//totalCBox=parseInt(f_query_add_mod.frameAutoclavingList.document.formAutoclavingList.totalRecords.value)
/*
	var checkBoxObj=null;
	var forDeletion=""
	for(i=0;i<totalCBox;i++)
	{
		checkBoxObj=eval("f_query_add_mod.frameAutoclavingList.document.formAutoclavingList.checkbox"+i);
		if(checkBoxObj.checked)
			forDeletion+=("Y,");
		else
			forDeletion+=("N,");
	}
	forDeletion=forDeletion.substring(0,forDeletion.length-1);
*/
	var formObj		=	f_query_add_mod.frameAutoclavingHeader.document.formAutoclavingHeader ;
//	formObj.records_to_delete.value=forDeletion;
	var blankObject	=	null;
	var fields		=	new Array();
	var fieldNames	=	new Array();
	var	index		=	0;
	var queryString =	"";

	fields[index]		=	formObj.autoclave_wash_unit_code;
	fieldNames[index++]	=	getLabel("eSS.AutoclaveUnit.label","SS");
	fields[index]		=	formObj.autoclave_date;
	fieldNames[index++]	=	getLabel("eSS.AutoclaveDate.label","SS");
	fields[index]		=	formObj.service_location;
	fieldNames[index++]	=	getLabel("eSS.ServiceLocation.label","SS");

	var errorPage	=	"../../eCommon/jsp/error.jsp";
	blankObject		=	getBlankField( fields, fieldNames, messageFrame);
	if(blankObject==null) {
		if (formObj.SS_AUTOCLAVING_FINALIZE!=null) 
		if(formObj.entry_completed_yn.checked && (formObj.SS_AUTOCLAVING_FINALIZE.value=="Y")){
		
			var confirmation = await confirmFinalize();//window.confirm("Current record will be deleted!!");
			if(confirmation=="Yes"){
				formObj.finalized.value="Y";
			}
//			else if(formObj.entry_completed_yn.disabled){
//				messageFrame.location.href = errorPage+"?err_num="+ getMessage("OPERATION_CANCELLED");
//				return;
//			}
		
		if (confirmation !=	CLOSED) {
		
			eval(formApply(formObj,SS_CONTROLLER));
			if(!((flag==null)||(flag=="null")||(flag=="")))
			message=message+"<br>Load No: "+flag;
			messageFrame.location.href = errorPage+"?err_num="+ message;
			if( result ) {
			onSuccess();
			}
		}
		else {
			eval(formApply(formObj,SS_CONTROLLER));
			messageFrame.location.href = errorPage+"?err_num="+ message;
			if( result ) {
			onSuccess();
			}
		}

	//	alert("ready for submission");
		}
		else
		{
			
			eval(formApply(formObj,SS_CONTROLLER));
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
//}
}




function checkDoc_type_code(){
	if(document.formAutoclavingHeader.doc_type_code.value=="") return;
	var xmlHttp = new XMLHttpRequest();
	var xmlDoc="";
	xmlDoc.loadXML(getXMLString(null));
	xmlHttp.open("POST", "../../eSS/jsp/AutoclavingValidate.jsp?validate=DOC_TYPE_CODE&doc_type_code=" + document.formAutoclavingHeader.doc_type_code.value, false);
	xmlHttp.send(xmlDoc);
	responseText=xmlHttp.responseText;

	eval(responseText);
}

function quantityAlert(_total_quantity, _sterilized_quantity, _unsterilized_quantity){
	alert("WARNING! Available Quantity is "+_total_quantity+" (Sterilized = "+_sterilized_quantity+", Unsterilized = "+_unsterilized_quantity+")");
}

function clearList(){
	var xmlHttp = new XMLHttpRequest();
	var xmlDoc="";
	xmlDoc.loadXML(getXMLString(null));
	xmlHttp.open("POST", "../../eSS/jsp/AutoclavingValidate.jsp?validate=CLEAR_LIST", false);
	xmlHttp.send(xmlDoc);
	responseText=xmlHttp.responseText;
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
		xmlDoc.loadXML(getXMLString(null));
		xmlHttp.open("POST", "../../eSS/jsp/AutoclavingValidate.jsp?group_code=" + formObj.group_code.value + "&group_type=" + formObj.group_type.value +"&tray_no=" + formObj.tray_no.value +"&write_off_reason_code=" + formObj.writeoff_reason.value +"&index="+formObj.index.value+ "&description="+formObj.description.value+ "&remarks="+formObj.remarks.value+ "&writeoff_reason="+formObj.writeoff_reason.value+ "&store_code="+parent.frameAutoclavingHeader.document.formAutoclavingHeader.store_code.value+ "&validate=ADD_TO_LIST", false);
		xmlHttp.send(xmlDoc);
		responseText=xmlHttp.responseText;
//		alert(responseText);
		eval(responseText);
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

function searchGroupCode( objCode, objDesc ) {
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
	argumentArray[5] = "";//objDesc.value;
	argumentArray[6] = CODE_LINK;
	argumentArray[7] = CODE_DESC;

	returnedValues = CommonLookup( "Group", argumentArray );
	if((returnedValues != null) && (returnedValues != "") )  {
		objCode.value = returnedValues[0];
		objDesc.value = returnedValues[1];
	} 
}

function clearGroupDetail(){
	var formObj = top.content.f_query_add_mod.frameAutoclavingDetail.document.formAutoclavingDetail;
	formObj.group_code.value="";
	//formObj.request_qty.value="";
	//formObj.description.value="";
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
//	formObj.group_search.disabled=false;
	formObj.index.value="-1";
	formObj.apply.value="  Add  ";
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
	var group_desc	=	formObj.description.value;//options[formObj.description.options.selectedIndex].text;
	if(group_code=="")	return;

	var dialogHeight= "28vh" ;
    var dialogWidth = "43vw" ;
    var status = "no";
	
	var dialogUrl       = "../../eSS/jsp/AutoclavingTrayQueryFrame.jsp?function_id="+parent.function_id+"&tray_no="+formObj.tray_no.value+"&group_code="+group_code+"&group_desc="+group_desc+"&store_code="+parent.frameAutoclavingHeader.document.formAutoclavingHeader.store_code.value;
	var dialogArguments = ""
	var dialogFeatures  = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; scroll=no; status:" + status;
	var returnVal =await window.showModalDialog(dialogUrl, dialogArguments, dialogFeatures);

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
	xmlDoc.loadXML(getXMLString(null));
	xmlHttp.open("POST", "../../eSS/jsp/AutoclavingValidate.jsp?validate=TRAY_DETAIL&tray_no="+formObj.tray_no.value+"&group_code="+formObj.group_code.value, false);
	xmlHttp.send(xmlDoc);
	responseText=xmlHttp.responseText;
//	alert(responseText);
	eval(responseText);
	if(!result){
		alert(getMessage(flag));
		formObj.tray_no.select();
		formObj.tray_no.focus();
	}
	} 

	function clearTrayDetails(){
	document.formAutoclavingDetail.tray_no.value="";
//	document.formIssueGroupDetail.bin_location_code.value="";
//	document.formIssueGroupDetail.expiry_date.value="";
}

function setTrayDetail(tray_no, bin_location_code, expiry_date){
	var formObj = top.content.f_query_add_mod.frameAutoclavingDetail.document.formAutoclavingDetail;
	formObj.tray_no.value=tray_no;
//	formObj.bin_location_code.value=bin_location_code;
//2/24/2003	formObj.expiry_date.value=expiry_date;
}


function searchWriteOffReason(objCode, objDesc){
	var argumentArray  = new Array();
	var dataNameArray  = new Array();
	var dataValueArray = new Array();
	var dataTypeArray  = new Array();

//	dataNameArray[0] = "writeoff_reason";
//	dataValueArray[0]= document.formAutoclavingDetail.writeoff_reason.value;
//	dataTypeArray[0] = STRING;

	argumentArray[0] = document.formAutoclavingDetail.SS_WRITE_OFF_REASON_LOOKUP.value;
	argumentArray[1] = dataNameArray;
	argumentArray[2] = dataValueArray;
	argumentArray[3] = dataTypeArray;
	argumentArray[4] = "1,2";
	argumentArray[5] = "";//objDesc.value;
	argumentArray[6] = CODE_LINK;
	argumentArray[7] = CODE_DESC;

	returnedValues = CommonLookup( "WriteOff", argumentArray );
	if((returnedValues != null) && (returnedValues != "") )  {
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

		
//		parent.frameAutoclavingListHeader.location.href='../../eSS/html/AutoclavingListHeader.html';
	/*	if(autoclave_wash_unit_code=="")
		{
			alert("Autoclave Unit must be entered");
		//	parent.frameAutoclavingHeader.document.formAutoclavingHeader.autoclave_wash_unit_code.select();
		//	parent.frameAutoclavingHeader.document.formAutoclavingHeader.autoclave_wash_unit_code.focus();
		}
		else if(autoclave_date=="")
		{
			alert("Autoclave Date must be entered");
		//	parent.frameAutoclavingHeader.document.formAutoclavingHeader.autoclave_date.select();
		//	parent.frameAutoclavingHeader.document.formAutoclavingHeader.autoclave_date.focus();

		}
		else if(store_code=="")
		{
			alert(getMessage("STORE_CAN_NOT_BLANK"));
		}

		if(autoclave_wash_unit_code!="" && autoclave_date!="" && store_code!="")	
		{
			parent.frameAutoclavingList.location.href='../../eSS/jsp/AutoclavingList.jsp?mode='+mode+'&autoclave_wash_unit_code='+autoclave_wash_unit_code+'&store_code='+store_code+'&load_no='+load_no+'&sterile_type='+sterile_type+' ';
		}

		*/


		var formObj = parent.parent.f_query_add_mod.frames[0].document.formAutoclavingHeader; 
		//alert(formObj.load_status);
		var fields = new Array ( formObj.autoclave_wash_unit_code, formObj.autoclave_date,formObj.service_location);
		var names = new Array ( getLabel("eSS.AutoclavingUnit.label","SS"),getLabel("eSS.AutoclavingDate.label","SS"),getLabel("eSS.Service Location.label ","SS"));
		//var errorPage	=	"../../eCommon/jsp/MstCodeError.jsp";
		var errorPage	= "../../eCommon/jsp/error.jsp";
		var blankObject	=	null;
		
		
		blankObject		=	getBlankField( fields, names, parent.parent.frames[2],errorPage);
		
		if(blankObject==null) 
		{
		
			//alert("form submit");
			parent.frameAutoclavingList.location.href='../../eSS/jsp/AutoclavingList.jsp?mode='+mode+'&autoclave_wash_unit_code='+autoclave_wash_unit_code+'&store_code='+store_code+'&load_no='+load_no+'&sterile_type='+sterile_type+'&service_location='+service_location;
		}

		else{
	
		blankObject.focus();
	}
}


function PopulateOtherDetails(autoclave_wash_unit_code) 
{		
		if( autoclave_wash_unit_code.value == "" ) 
			return;
		var bean_id = document.formAutoclavingHeader.bean_id.value;
		var bean_name = document.formAutoclavingHeader.bean_name.value;
		
		//var xmlDom = new ActiveXObject( "Microsoft.XMLDom" );
		var xmlDom = "";
		var xmlHttp = new XMLHttpRequest();
		var arrayObject = new Array();
		arrayObject[0] = autoclave_wash_unit_code;
		xmlStr = getXMLString(arrayObject);
		xmlDom.loadXML(xmlStr);
		xmlHttp.open("POST", "AutoclavingValidate.jsp?bean_id=" + bean_id + "&bean_name=" + bean_name + "&autoclave_wash_unit_code=" + autoclave_wash_unit_code+ "&function_type=1", false);
		xmlHttp.send( xmlDom );
		responseText=xmlHttp.responseText;
		//alert(responseText )
		eval( responseText );
	//	alert(document.forms[0].sterile_type.value);

}

function changeStatusCheckBox(obj)
{
	//alert("changeStatusCheckBox");
	formObj=parent.frameAutoclavingList.document.formAutoclavingList;	
	for(var i=0;i<formObj.elements.length;i++)
	{
		if(formObj.elements(i).type=="checkbox")
		{
			if(obj.checked)
			{
				formObj.elements(i).checked=true;
				formObj.selectAll.value='Y';

			}
			else
			{
				formObj.elements(i).checked=false;
				formObj.selectAll.value='N';
			}
			if(formObj.elements(i).name!="selectAll")
			{
				alterBean(formObj.elements(i));
			}
		}
	}
}

function assignValue(obj){

	//alert("@@@ assignValue ");
if(obj.checked)
	obj.value="Y";
else
	obj.value="N";
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


// from here

function goNext(source_mode) {
	formObj=parent.frameAutoclavingList.document.formAutoclavingList;
	mode=formObj.mode.value;

	start = parseInt( formObj.start.value) +parseInt( formObj.displaySize.value ) ;
	end = parseInt( formObj.end.value )+ parseInt(formObj.displaySize.value ) ;
	
	xmlStr=formXMLString(formObj.start.value,formObj.end.value,formObj.totalRecords.value,formObj);
//	formValidation(xmlStr,formObj.start.value,formObj.end.value,formObj.totalRecords.value);

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
mode=formObj.mode.value;
	start = parseInt( formObj.start.value  )-parseInt(  formObj.displaySize.value)  ;
	end = parseInt( formObj.end.value )- parseInt(formObj.displaySize.value ) ;

	xmlStr=formXMLString(formObj.start.value,formObj.end.value,formObj.totalRecords.value,formObj);
//	formValidation(xmlStr,formObj.start.value,formObj.end.value,formObj.totalRecords.value);

	if(formObj.mode.value==MODE_INSERT)
		modeVal=MODE_INSERT;
	else
		modeVal=MODE_MODIFY;

	var formObjAutoclaving		=	parent.frameAutoclavingHeader.document.formAutoclavingHeader;
	parent.frameAutoclavingList.location.href="../../eSS/jsp/AutoclavingList.jsp?mode="+mode+"&autoclave_wash_unit_code="+formObjAutoclaving.autoclave_wash_unit_code.value+"&autoclave_date="+formObjAutoclaving.autoclave_date.value+"&temperature="+formObjAutoclaving.temperature.value+"&load_no="+formObjAutoclaving.load_no.value+"&store_code="+formObjAutoclaving.store_code.value+"&from="+start+"&to="+end;
}	


function formXMLString(start,end,totalRecord,formObj){
	var xmlStr ="<root><SEARCH ";
		if(parseInt(end)>parseInt(totalRecord))
		end=totalRecord;
			for(var i=start;i<end;i++)
								xmlStr += " SELECTED"+i+"=\""+ eval("formObj.checkbox"+i+".value") +"\" ";
	
		xmlStr +=" /></root>";
		//alert(xmlStr);
	return xmlStr;
}
function formValidation(xmlStr,start,end,totalRecords,checked_yn,idx,tray_no,index){
//alert("inside formValidation.."+start+"/"+end+"/"+totalRecords+"/"+checked_yn+"/"+idx);
temp_jsp="AutoclavingValidation.jsp?idx="+idx+"&checked_yn="+checked_yn+"&start="+start+"&end="+end+"&totalRecords="+totalRecords+"&function_id=autoclaving_detail&tray_no="+tray_no+"&index="+index;

	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest() ;
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
//alert("xmlStr 111111="+xmlStr);
//alert("temp_jsp==="+temp_jsp);
	xmlHttp.open("POST",temp_jsp,false);
	xmlHttp.send(xmlDoc);
	responseText=xmlHttp.responseText ;
	//alert(responseText);
	return true;
}

function alterBean(obj, index,tray_no)
{
	//alert("alterBean=name="+obj.name);
	var name=obj.name;
	var len=obj.name.length;
	//alert("alterBean len="+len);
	var idx=name.substring(8,len);
	//alert(idx);
	formObj=parent.frameAutoclavingList.document.formAutoclavingList;
	start = parseInt( formObj.start.value  )-parseInt(  formObj.displaySize.value)  ;
	end = parseInt( formObj.end.value )- parseInt(formObj.displaySize.value ) ;

	xmlStr=formXMLString(formObj.start.value,formObj.end.value,formObj.totalRecords.value,formObj);
	//alert("xmlStr="+xmlStr);
	formValidation(xmlStr,formObj.start.value,formObj.end.value,formObj.totalRecords.value,obj.checked,idx,tray_no,index);
}

// till here


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
	//alert(receiptdate + "= " + sysdate);
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
	
//alert("sysdate" + sysdate + "receipt" + receiptdate);	
var flag=chkCurrentYear(receiptdate,sysdate);
	//&& chkCurrentYear(receiptdate,sysdate)
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
	/*else
	{
		if(!(flag))
		{
			alert(getMessage("NOSHOW_FM_DT_VALIDATION","SS"));
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
	}*/

	
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
	
	//alert(receiptdate + "= " + sysdate);
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


/*

function checkSysdate(receiptdate,sysdate){
//alert("sysdate" + sysdate + "receipt" + receiptdate);	
var flag=chkCurrentYear(receiptdate,sysdate);

	//&& chkCurrentYear(receiptdate,sysdate)
if(ChkDate(receiptdate) && flag )
   {
		if(!checkdateWithSysDate(receiptdate,sysdate))
		{
		alert(getMessage("NOT_GRT_THAN_SYSDATE"));
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
			alert(getMessage("NOSHOW_FM_DT_VALIDATION"));
			receiptdate.select();
			receiptdate.focus();
			return false;

		}
		else
		{
		alert(getMessage("INVALID_DATE_FMT"));
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
			
			//  * If the sys_date is less than the entered_date date,
			//  * i.e., The Entered date is greater than the Current System Date
			//  * Then return false to indicate it is wrong..
			  //
			return false;
		}
		else if(Date.parse(sysDateObject) >= Date.parse(enteredDateObject)) return true;
	}	
	return true;
}
*/


/*function checkSysdate(receiptdate,sysdate){
	
//alert("sysdate" + sysdate + "receipt" + receiptdate);	
var flag=chkCurrentYear(receiptdate,sysdate);

	//&& chkCurrentYear(receiptdate,sysdate)
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
			alert(getMessage("NOSHOW_FM_DT_VALIDATION","SS"));
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
*/

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
	var flag=true;
	if(autodate.value.length <1)
	{
		alert(getMessage("AUTOCLAVING_UNIT_DATE_NOT_BLANK","SS"));
		autodate.select();
		autodate.focus();
		flag=false;
	}
		
	CheckDate(autodate); 
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

