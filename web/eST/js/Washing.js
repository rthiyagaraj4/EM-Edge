function query(){
	f_query_add_mod.location.href="../../eSS/jsp/WashingFrame.jsp?mode="+MODE_MODIFY+"&function_id="+function_id;
}

function onSuccess(mode,entryCompleted){
	if(mode==MODE_DELETE){
		f_query_add_mod.frameWashingAddModify.document.location.href="../../eCommon/html/blank.html";
		f_query_add_mod.frameWashingDetail.document.location.href="../../eCommon/html/blank.html";
		}
	else{
		f_query_add_mod.frameWashingAddModify.document.location.reload();
/*		if(!((flag==null)||(flag=="null")))
		setTimeout("messageFrame.location.href=\"../../eCommon/jsp/error.jsp?err_num=\"+flag",1000);
*/		f_query_add_mod.frameWashingDetail.document.location.href="../../eCommon/html/blank.html";
	}
}

function create(){
	f_query_add_mod.location.href="../../eSS/jsp/WashingFrame.jsp?mode="+MODE_INSERT+"&function_id="+function_id;
}


function apply() {
	var formObj		=	f_query_add_mod.frameWashingAddModify.document.formWashing ;
	var formObjDtl		=	f_query_add_mod.frameWashingDetail.location.href.indexOf(".jsp");
	var formObjDtlData		=	f_query_add_mod.frameWashingDetail.document.formWashingDetail ;

	if(formObj.entry_completed_yn.checked==true)
		formObj.entry_completed_yn.value="Y";
	else
		formObj.entry_completed_yn.value="N";
	//alert (getXMLString(formObj));

	
	var blankObject	=	null;
	var fields		=	new Array();
	var fieldNames	=	new Array();

	fields[0]		=	formObj.autoclave_wash_unit_code;
	fieldNames[0]	=	getLabel("eSS.WashUnit.label","SS");
	fields[1]		=	formObj.washing_type;
	fieldNames[1]	=	getLabel("eSS.WashingType.label","SS");

	var errorPage	=	"../../eCommon/jsp/error.jsp";
	blankObject		=	getBlankField( fields, fieldNames, messageFrame);

var total_index=parseInt(formObjDtlData.totalRecords.value);
	
	var count=0;
	if((formObjDtlData.mode.value==MODE_MODIFY)&&(total_index>=1))
		{
			for(var i=0;i<total_index;i++)
			{
		
				if((eval("formObjDtlData.checkbox"+i).value)=="Y")
				{
					count=count+1;
				}
			}
		}
	if(blankObject==null) {
		
    var countCheck =0;
		if(formObjDtl!=-1){
			
			if(formObjDtlData.mode.value==MODE_INSERT){
				
				if(parseInt(formObjDtlData.count_yes.value)>=1){
					xmlStr=formXMLString(formObjDtlData.start.value,formObjDtlData.end.value,formObjDtlData.totalRecords.value,formObjDtlData);								
					formValidation(xmlStr,formObjDtlData.start.value,formObjDtlData.end.value,formObjDtlData.totalRecords.value);
				
					eval(formApply(formObj,SS_CONTROLLER));
					messageFrame.location.href = errorPage+"?err_num="+ message+flag;

					if( result ) {
						onSuccess();
					}
				}
				else if((parseInt(formObjDtlData.count_yes.value)==0)&&(formObjDtlData.selectAll.value!="Y"))
				{
					message=getMessage("ONE_RECORD_NEEDED","SS");
					messageFrame.location.href = errorPage+"?err_num="+ message;
					return false;
				}
				else if((parseInt(formObjDtlData.count_yes.value)!=0)&&(formObjDtlData.selectAll.value=="Y"))
				{
					xmlStr=formXMLString(formObjDtlData.start.value,formObjDtlData.end.value,formObjDtlData.totalRecords.value,formObjDtlData);								
					formValidation(xmlStr,formObjDtlData.start.value,formObjDtlData.end.value,formObjDtlData.totalRecords.value);
				
					eval(formApply(formObj,SS_CONTROLLER));
					messageFrame.location.href = errorPage+"?err_num="+ message+flag;

					if( result ) {
						onSuccess();
					}
				}

			}
			else if((formObjDtlData.mode.value==MODE_MODIFY)&&(count>0)&&(formObj.entry_completed_yn.value=="Y")){
				
				//if(parseInt(formObjDtlData.totalRecords.value)>1){
					
							xmlStr=formXMLString(formObjDtlData.start.value,formObjDtlData.end.value,formObjDtlData.totalRecords.value,formObjDtlData);								
							temp_jsp="WashingValidation.jsp?start="+formObjDtlData.start.value+"&end="+formObjDtlData.end.value+"&totalRecords="+formObjDtlData.totalRecords.value+"&function_id=washing_delete";

							var xmlDoc = "" ;
							var xmlHttp = new XMLHttpRequest() ;
							xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
							xmlHttp.open("POST",temp_jsp,false);
							xmlHttp.send(xmlDoc);
							responseText=xmlHttp.responseText ;
							

				//}
			/*	else if(parseInt(formObjDtlData.totalRecords.value)==1){
					message=getMessage("ONE_RECORD_NEEDED");
					messageFrame.location.href = errorPage+"?err_num="+ message;
					return false;
				}*/

					eval(formApply(formObj,SS_CONTROLLER));
					messageFrame.location.href = errorPage+"?err_num="+ message;
					if( result ) {
						onSuccess(MODE_MODIFY,formObj.entry_completed_yn.value);
					}	
			}
				else if((formObjDtlData.mode.value==MODE_MODIFY)&&(count==0)&&(formObj.entry_completed_yn.value="Y"))
					{	
						
					message=getMessage("ONE_RECORD_NEEDED","SS");
					messageFrame.location.href = errorPage+"?err_num="+ message;
					return false;
				}
				else if((formObjDtlData.mode.value==MODE_MODIFY)&&(count>=0)&&(formObj.entry_completed_yn.value="N"))
					{
					
					xmlStr=formXMLString(formObjDtlData.start.value,formObjDtlData.end.value,formObjDtlData.totalRecords.value,formObjDtlData);								
							temp_jsp="WashingValidation.jsp?start="+formObjDtlData.start.value+"&end="+formObjDtlData.end.value+"&totalRecords="+formObjDtlData.totalRecords.value+"&function_id=washing_delete";

							var xmlDoc = "" ;
							var xmlHttp = new XMLHttpRequest() ;
							xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
							xmlHttp.open("POST",temp_jsp,false);
							xmlHttp.send(xmlDoc);
							responseText=xmlHttp.responseText ;
						
							eval(formApply(formObj,SS_CONTROLLER));
							messageFrame.location.href = errorPage+"?err_num="+ getMessage("RECORD_MODIFIED","SS");
							if( result ) {
							onSuccess(MODE_MODIFY,formObj.entry_completed_yn.value);
						}	
				}
		}


	}
	else{
		blankObject.focus();
	}
}

function assignValueHeader(obj){
	if(obj.checked)
	obj.value="Y";
	else
	obj.value="N";
	
	
}
function reset(){
	if(f_query_add_mod.frameWashingAddModify.document.formWashing!=null)
		f_query_add_mod.frameWashingAddModify.formWashing.reset();
	
	if(f_query_add_mod.frameWashingDetail.document.formWashingDetail !=null)
		f_query_add_mod.frameWashingDetail.document.formWashingDetail.reset();
}


function assignValue(obj){
if(obj.checked)
	obj.value="Y";
else
	obj.value="N";
var val=document.forms[0].count_yes.value;
if((document.forms[0].mode.value=="1")&&(obj.value=="Y")){
	document.forms[0].count_yes.value=parseInt(val)+1;
	
}
if((document.forms[0].mode.value=="1")&&(obj.value=="N")){
	document.forms[0].count_yes.value=parseInt(val)-1;
	
}
}

function assignResult( _result, _message, _flag ) {
	result = _result ;
	message  = _message ;
	flag = _flag ;
}

function getRofDtls(){
	
	var formObjWashing		=	parent.frameWashingAddModify.document.formWashing ;
	var blankObject	=	null;
	var fields		=	new Array();
	var fieldNames	=	new Array();

	fields[0]		=	formObjWashing.autoclave_wash_unit_code;
	fieldNames[0]	=	getLabel("eSS.WashUnit.label","SS");
	fields[1]		=	formObjWashing.washing_type;
	fieldNames[1]	=	getLabel("eSS.WashingType.label","SS");
	var errorPage	=	"../../eCommon/jsp/error.jsp";
	blankObject		=	getBlankField( fields, fieldNames, parent.parent.messageFrame);

	if(blankObject==null) {
	
	
	//if(formObjWashing.washing_type.value!=""){
	temp_jsp="WashingValidation.jsp?function_id=washing_add_modify&rof_doc_type_code="+formObjWashing.rof_doc_type_code.value+"&store_code="+formObjWashing.store_code.value+"&washing_type="+formObjWashing.washing_type.value;

	var xmlStr="<root><SEARCH/></root>"
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest() ;
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST",temp_jsp,false);
	xmlHttp.send(xmlDoc);
	responseText=xmlHttp.responseText ;
	
	if(formObjWashing.mode.value==MODE_INSERT)
		modeVal=MODE_INSERT;
	else
		modeVal=MODE_MODIFY;
	parent.frameWashingDetail.location.href="../../eSS/jsp/WashingDetail.jsp?autoclave_wash_unit_code="+formObjWashing.autoclave_wash_unit_code.value+"&mode="+modeVal+"&washing_type="+formObjWashing.washing_type.value+"&temperature="+formObjWashing.temperature.value+"&load_no="+formObjWashing.load_no.value+"&rof_doc_type_code="+formObjWashing.rof_doc_type_code.value+"&store_code="+formObjWashing.store_code.value;
	/*}
	else{
	alert(getMessage("WASHING_WASH_TYPE_MAND"));
	return false;
	}*/
	}
	else{
		blankObject.focus();
	}
}

function getSearchDetails(){
	var formObjWashing		=	parent.frameWashingAddModify.document.forms[0] ;
	parent.frameWashingDetail.location.href="../../eSS/jsp/WashingResult.jsp?autoclave_wash_unit_code="+formObjWashing.autoclave_wash_unit_code.value+"&mode="+MODE_MODIFY+"&load_no="+formObjWashing.load_no.value+"&washing_type="+formObjWashing.washing_type.value;
}

function activeLink() {
	formObj=parent.frameWashingDetail.document.formWashingDetail;

	if(formObj.start.value != 0 ){
			parent.frameWashingDetail.document.getElementById("prev").style.visibility='visible';
	}
	else{
	parent.frameWashingDetail.document.getElementById("prev").style.visibility='hidden';
	}

	if(  !((parseInt(formObj.start.value) +parseInt(formObj.displaySize.value))>= formObj.totalRecords.value ))
		parent.frameWashingDetail.document.getElementById("next").style.visibility='visible';
	else
		parent.frameWashingDetail.document.getElementById("next").style.visibility='hidden';
}


function goNext(source_mode) {
	formObj=parent.frameWashingDetail.document.formWashingDetail;
	
	start = parseInt( formObj.start.value) +parseInt( formObj.displaySize.value ) ;
	end = parseInt( formObj.end.value )+ parseInt(formObj.displaySize.value ) ;
	
	xmlStr=formXMLString(formObj.start.value,formObj.end.value,formObj.totalRecords.value,formObj);
	formValidation(xmlStr,formObj.start.value,formObj.end.value,formObj.totalRecords.value);

	if(formObj.mode.value==MODE_INSERT)
		modeVal=MODE_INSERT;
	else
		modeVal=MODE_MODIFY;
	
	var formObjWashing		=	parent.frameWashingAddModify.document.formWashing ;
	parent.frameWashingDetail.location.href="../../eSS/jsp/WashingDetail.jsp?autoclave_wash_unit_code="+formObjWashing.autoclave_wash_unit_code.value+"&mode="+modeVal+"&washing_type="+formObjWashing.washing_type.value+"&temperature="+formObjWashing.temperature.value+"&load_no="+formObjWashing.load_no.value+"&rof_doc_type_code="+formObjWashing.rof_doc_type_code.value+"&store_code="+formObjWashing.store_code.value+"&from="+start+"&to="+end;
}	

function goPrev(source_mode) {
	formObj=parent.frameWashingDetail.document.formWashingDetail;
	start = parseInt( formObj.start.value  )-parseInt(  formObj.displaySize.value)  ;
	end = parseInt( formObj.end.value )- parseInt(formObj.displaySize.value ) ;

	xmlStr=formXMLString(formObj.start.value,formObj.end.value,formObj.totalRecords.value,formObj);
	formValidation(xmlStr,formObj.start.value,formObj.end.value,formObj.totalRecords.value);

	if(formObj.mode.value==MODE_INSERT)
		modeVal=MODE_INSERT;
	else
		modeVal=MODE_MODIFY;

	var formObjWashing		=	parent.frameWashingAddModify.document.formWashing ;
	parent.frameWashingDetail.location.href="../../eSS/jsp/WashingDetail.jsp?autoclave_wash_unit_code="+formObjWashing.autoclave_wash_unit_code.value+"&mode="+modeVal+"&washing_type="+formObjWashing.washing_type.value+"&temperature="+formObjWashing.temperature.value+"&load_no="+formObjWashing.load_no.value+"&rof_doc_type_code="+formObjWashing.rof_doc_type_code.value+"&store_code="+formObjWashing.store_code.value+"&from="+start+"&to="+end;
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

function formValidation(xmlStr,start,end,totalRecords){
	temp_jsp="WashingValidation.jsp?start="+start+"&end="+end+"&totalRecords="+totalRecords+"&function_id=washing_detail";

	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest() ;
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST",temp_jsp,false);
	xmlHttp.send(xmlDoc);
	responseText=xmlHttp.responseText ;
	//alert(responseText);
	return true;
}

function popDtlData(autoclave_wash_unit_code,washing_type,load_no,temperature,entry_completed_yn,service_location_desc,store_code,store_desc){

	
	parent.frameWashingAddModify.document.location.href="../../eSS/jsp/WashingAddModify.jsp?mode="+MODE_MODIFY+"&function_id="+function_id+"&autoclave_wash_unit_code="+autoclave_wash_unit_code+"&washing_type="+washing_type+"&load_no="+load_no+"&temperature="+temperature+"&entry_completed_yn="+entry_completed_yn+"&service_location_desc="+service_location_desc+"&from="+start+"&to="+end+"&store_code="+store_code+"&store_desc="+store_desc;
	parent.frameWashingDetail.document.location.href="../../eSS/jsp/WashingDetail.jsp?mode="+MODE_MODIFY+"&function_id="+function_id+"&autoclave_wash_unit_code="+autoclave_wash_unit_code+"&washing_type="+washing_type+"&load_no="+load_no+"&temperature="+temperature+"&from="+start+"&to="+end;
}


function deleterecord(){
var formObjDtl		=	f_query_add_mod.frameWashingDetail.location.href.indexOf(".jsp");
var formObj		=	f_query_add_mod.frameWashingAddModify.document.formWashing ;
//var formObjCheck		=	f_query_add_mod.frameWashingAddModify.location.href.indexOf(".jsp");

var errorPage	=	"../../eCommon/jsp/error.jsp";
	if(f_query_add_mod.frameWashingAddModify.document.forms[0].name=="formWashing"){
		if(formObjDtl!=-1){
		if(f_query_add_mod.frameWashingDetail.document.forms[0].name=="formWashingDetail"){
				
				//	var confirmation =confirmFinalize();
			 var confirmation =confirmDelete();
			
			if(confirmation=="Yes"){
				formObj.mode.value=MODE_DELETE;
				//eval(formApply(formObj,SS_CONTROLLER));
					var resultText	=	formApply(formObj,SS_CONTROLLER);
					eval(resultText);
				
							messageFrame.location.href = errorPage+"?err_num="+ message;
							if( result ) {
							
								onSuccess(MODE_DELETE);
							}
				}
				else {

					message=getMessage("OPERATION_CANCELLED","SS");
					messageFrame.location.href = errorPage+"?err_num="+ message;
					return false;
				}
		}
		else
			messageFrame.location.href = errorPage+"?err_num=";
		}
		else
			messageFrame.location.href = errorPage+"?err_num=";
	}
	else
		messageFrame.location.href = errorPage+"?err_num=";
}

function changeStatusCheckBox(obj){
	formObj=parent.frameWashingDetail.document.formWashingDetail;	
	var count=0;
	for(var i=0;i<formObj.elements.length;i++){
		if(formObj.elements(i).type=="checkbox"){
			if(obj.checked){
				formObj.elements(i).value='Y';
				formObj.elements(i).checked=true;
			}
			else{
				formObj.elements(i).value='N';
				formObj.elements(i).checked=false;
			}
		}
		
		if((formObj.elements(i).name=="selectAll")&&(formObj.elements(i).value='Y')){
	formObj.count_yes.value=count+1;
		}
		
	}
}

function populateData(obj)
{
	if(obj.value!=""){
		loadServiceLocation(obj) ;
		loadTemperature(obj);
	}
	else{
		parent.frameWashingAddModify.formWashing.service_location.value="" ;
	}
  return true;
}

function loadServiceLocation(obj)
{
    if(obj.value!=""){
	temp_jsp="WashingValidation.jsp?function_id=get_service_location&washing_unit="+obj.value;

	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest() ;
	xmlDoc.loadXML(getXMLString(null));
	xmlHttp.open("POST",temp_jsp,false);
	xmlHttp.send(xmlDoc);
	responseText=xmlHttp.responseText ;
	eval(responseText);
	//alert(responseText);
	 return true;
	}
	else
	  return false;
}

function loadTemperature(obj){
	if(obj.value!="")
	{
	temp_jsp="WashingValidation.jsp?function_id=get_temperature&washing_unit="+obj.value;

	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest() ;
	xmlDoc.loadXML(getXMLString(null));
	xmlHttp.open("POST",temp_jsp,false);
	xmlHttp.send(xmlDoc);
	responseText=xmlHttp.responseText ;
	//alert(responseText);
	eval(responseText);
	  return true;
	}
	else
	  return false;
}




