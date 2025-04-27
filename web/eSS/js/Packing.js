/*
*Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
* 
*Warning: This computer program is protected by copyright law and international treaties.
*Unauthorized reproduction or distribution of this program, or any portion of it, 
*may result in severe civil and criminal penalties, and will be prosecuted to 
*the maximum extent possible under the law.
*/
function query(){
	f_query_add_mod.location.href = "../../eSS/jsp/PackingQueryFrame.jsp?function_id="+function_id+"&mode="+MODE_MODIFY;
	
}
function create(){
	f_query_add_mod.location.href = "../../eSS/jsp/PackingFrame.jsp?mode=2&function_id=SS_PACKING&doc_type_code=C1ROF&doc_no=3";
}

async function searchPackItem(objCode,objDesc) {
	objCode.value = "";
	objDesc.value = "";
	var argumentArray  = new Array();
	var dataNameArray  = new Array();
	var dataValueArray = new Array();
	var dataTypeArray  = new Array();

	dataNameArray  [0]="LANGUAGE_ID"
	dataValueArray [0]=document.formPackingDetail.locale.value;
	dataTypeArray  [0]=STRING;

	argumentArray[0] = document.formPackingDetail.SQL_SS_ITEM_LOOKUP.value;
	argumentArray[1] = dataNameArray;
	argumentArray[2] = dataValueArray;
	argumentArray[3] = dataTypeArray;
	argumentArray[4] = "2,3";
	
	if(objDesc.readOnly)
		argumentArray[5] = "";
	else
		argumentArray[5] = objDesc.value;
	argumentArray[6] = CODE_LINK;
	argumentArray[7] = CODE_DESC;

	returnedValues = await CommonLookup(getLabel("Common.item.label","Common"), argumentArray );
	if((returnedValues != null) && (returnedValues != "") )  {
		if(returnedValues.length === 1){
			returnedValues = returnedValues[0].split(',');
		}
		objCode.value = returnedValues[0];
		objDesc.value = returnedValues[1];
		objDesc.readOnly=true;
	} 
}

function onSuccess(){
		if(f_query_add_mod.framePackingQueryCriteria!=null){
		f_query_add_mod.framePackingQueryCriteria.document.formPackingQueryCriteria.reset();
		f_query_add_mod.framePackingQueryResult.document.location.href="../../eCommon/html/blank.html";
	}
	else if(f_query_add_mod.framePackingHeader!=null){
		f_query_add_mod.location.reload();
	}
}

function checkHoldStatus(bChecked){
		if(bChecked){
		document.formPackingDetail.packing_date.value="";
		document.formPackingDetail.packing_date.disabled=true;
		document.formPackingDetail.date.style.visibility='hidden';
	}else{
		document.formPackingDetail.packing_date.value=document.formPackingDetail.sys_date.value;
		document.formPackingDetail.hold_reason.value="";
		document.formPackingDetail.date.style.visibility='visible';
	}
	//document.formPackingDetail.packing_date.disabled=bChecked;
	document.formPackingDetail.hold_reason.disabled=!bChecked;
}

async function collectDiscrepancyDetail() {
	var formObjDetail=document.formPackingDetail;
	var formObjHeader=parent.framePackingHeader.document.formPackingHeader;
	var group_code=formObjDetail.group_code.value;
	var tray_no=formObjDetail.tray_no.value;

	var dialogHeight	= "77vh";
	var dialogWidth	= "51vw" ;
	var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +"; status=no;" ;
	var arguments	= "" ;
		var parameters = "?group_code="+group_code +"&tray_no="+tray_no+"&function_id="+formObjDetail.function_id.value;
	retVal = await window.showModalDialog("../../eSS/jsp/PackingDiscrepancyFrame.jsp"+parameters,arguments,features);
}

function reset() {
	if(f_query_add_mod.framePackingQueryCriteria!=null){
		f_query_add_mod.framePackingQueryCriteria.document.formPackingQueryCriteria.reset();
		f_query_add_mod.framePackingQueryResult.document.location.href="../../eCommon/html/blank.html";
	}
	else if(f_query_add_mod.framePackingHeader!=null){
		f_query_add_mod.location.reload();
	}
}


async function apply(){
	frmObjindex=f_query_add_mod.location.href.indexOf(".jsp");

	var errorPage	=	"../../eCommon/jsp/error.jsp";

	if(frmObjindex!=-1){
		totalCBox=parseInt(f_query_add_mod.framePackingList.document.formPackingList.total_checkboxes.value);

		
		var checkBoxObj=null;

		var forPacking=""
		for(i=0;i<totalCBox;i++)
		{
			checkBoxObj=eval("f_query_add_mod.framePackingList.document.formPackingList.checkbox"+i);

			if(checkBoxObj.checked){

				forPacking=forPacking+("Y,");

				checkBoxObj.value="Y";
				}
			else{

				forPacking=forPacking+("N,");

				checkBoxObj.value="N";
			}

			
			checkBoxObj=eval("f_query_add_mod.framePackingList.document.formPackingList.checkbox"+i);

			packingQty=eval("f_query_add_mod.framePackingList.document.formPackingList.packing_qty_"+i);
			packingItemCode=eval("f_query_add_mod.framePackingList.document.formPackingList.packing_item_code_"+i);
			

		}
		forPacking=forPacking.substring(0,forPacking.length-1);

		var formObj		=	f_query_add_mod.framePackingHeader.document.formPackingHeader ;

		formObj.records_to_pack.value=forPacking;
		var errorPage	=	"../../eCommon/jsp/error.jsp";
		var responseText	=	formApply(formObj,SS_CONTROLLER);

		eval(responseText.replace(/<\/?[^>]+(>|$)|\s{2,}|\r?\n/g, ""));

		//messageFrame.location.href = errorPage+"?err_num="+ message;
		if( result ) {
				var PConfirm = await confirmPrinting();
				if (PConfirm == "Yes") {
					var xmlHttp = new XMLHttpRequest();
					var xmlDoc="";
					xmlDoc = new DOMParser().parseFromString(getXMLString(null), "text/xml");
					//xmlDoc.loadXML(getXMLString(null));
					//xmlHttp.open("POST", "../../eSS/jsp/PackingValidate.jsp?validate=printOnlineDoc&msg=" + encodeURIComponent(message), false);
					xmlHttp.open("POST", "../../eSS/jsp/PackingValidate.jsp?validate=printOnlineDoc&msg=" + encodeURIComponent(message), true);
					xmlHttp.send(xmlDoc);
					//responseText = xmlHttp.responseText;
					//eval(responseText);
				}
				else {
					messageFrame.location.href = errorPage + "?err_num=" + message;
				}
			//onSuccess();
		}
		messageFrame.location.href = errorPage+"?err_num="+ message;
		onSuccess();
	}
	else{
		messageFrame.location.href = errorPage+"?err_num="+ message;

	}
}
function formApply(frmObj, controllerJSP) {
	var xmlDoc="";
    var xmlHttp = new XMLHttpRequest();
    var arrObj = frmObj.elements;

    var frmObjs = new Array()
    if(frmObj.name == null)
        frmObjs = frmObj ;
    else frmObjs[0] = frmObj ;

    var xmlStr ="<root><SEARCH ";

    for(var frmCount=0; frmCount<frmObjs.length; frmCount++) {
        frmObj = frmObjs[frmCount]
        var arrObj = frmObj.elements;

        for(var i=0;i<arrObj.length;i++) {
            var val = "" ;
            if(arrObj[i].type == "checkbox") {
                if(arrObj[i].checked)
                    val = arrObj[i].value;
                if(arrObj[i].name != null && arrObj[i].name != "")
                    xmlStr+= arrObj[i].name+"=\"" + checkSpl(val) + "\" " ;
            }
            else if(arrObj[i].type == "radio") {
                if(arrObj[i].checked) {
                    val = arrObj[i].value;
                    if(arrObj[i].name != null && arrObj[i].name != "")
                        xmlStr+= arrObj[i].name+"=\"" + checkSpl(val) + "\" " ;
                }
            }
            else if(arrObj[i].type == "select-multiple" ) {
                for(var j=0; j<arrObj[i].options.length; j++)
                {
                    if(arrObj[i].options[j].selected)
                        val+=arrObj[i].options[j].value +"~"
                }
                val= val.substring(0,val.lastIndexOf('~'))
                if(arrObj[i].name != null && arrObj[i].name != "")
                    xmlStr+= arrObj[i].name+"=\"" + checkSpl(val) + "\" " ;

            }
            else {
                val = arrObj[i].value;
                if(arrObj[i].name != null && arrObj[i].name != "")
                    xmlStr+= arrObj[i].name+"=\"" + checkSpl(val) + "\" " ;
            }
        }
    }

    xmlStr +=" /></root>";

    xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
    beforePost(xmlStr) ;
	alert(xmlStr);
    xmlHttp.open("POST", controllerJSP, false);
	xmlHttp.setRequestHeader("Content-type","application/x-www-form-urlencoded");
    xmlHttp.send(xmlDoc);
    return xmlHttp.responseText  ;
}


function searchItem(objCode,objDesc) {
	var argumentArray  = new Array();
	var dataNameArray  = new Array();
	var dataValueArray = new Array();
	var dataTypeArray  = new Array();

	argumentArray[0] = document.forms[0].SQL_SS_ITEM_LOOKUP.value;
	argumentArray[1] = dataNameArray;
	argumentArray[2] = dataValueArray;
	argumentArray[3] = dataTypeArray;
	argumentArray[4] = "1,2";
	if(objDesc.readOnly)
		argumentArray[5] = "";
	else
		argumentArray[5] = objDesc.value;
	
	argumentArray[6] = CODE_LINK;
	argumentArray[7] = CODE_DESC;

	returnedValues = CommonLookup( "Item Search", argumentArray );
	if((returnedValues != null) && (returnedValues != "") )  {
		objCode.value = returnedValues[0];
		objDesc.value = returnedValues[1];
		objDesc.readOnly=true;
	} 
}


function checkPackingDate(packdate,sysdate)
{
	var flag=true;
	if(packdate.value.length <1)
	{
		alert(getMessage("PACKING_DATE_NOT_BLANK","SS"));
		packdate.select();
		packdate.focus();
		flag=false;
		return flag;
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
function addToList(){
	var formObj=  document.formPackingDetail;


	var fields =new Array ( formObj.pack_item_code, formObj.pack_item_qty);
	var names  =new Array ( getLabel("eSS.PackItem.label","SS"),getLabel("eSS.PackItemQty.label","SS"));
	var index  =2;
	
	if(!formObj.hold_yn.checked){
		fields[index]= formObj.packing_date;
		names[index]=  getLabel("eSS.PackingDate.label","SS");
	}
	var obj    =null;
	var messageFrame = parent.parent.messageFrame; 
	var errorPage	 = "../../eCommon/jsp/error.jsp";

		
		var xmlHttp = new XMLHttpRequest();
		var xmlDoc="";
		xmlDoc = new DOMParser().parseFromString(getXMLString(null), "application/xml");
		// xmlDoc.loadXML(getXMLString(null));
		//xmlHttp.open("POST", "../../eSS/jsp/PackingValidate.jsp?pack_item_code=" + formObj.pack_item_code.value + "&pack_item_desc=" + formObj.pack_item_desc.value + "&pack_item_qty=" + formObj.pack_item_qty.value +"&group_code=" + formObj.group_code.value +"&tray_no=" + formObj.tray_no.value+"&hold_yn=" + formObj.hold_yn.checked +"&hold_reason=" + escape(formObj.hold_reason.value)+ "&packing_date=" + formObj.packing_date.value+"&index="+formObj.index.value+ "&validate=ADD_TO_LIST", false);
		xmlHttp.open("POST", "../../eSS/jsp/PackingValidate.jsp?pack_item_code=" + (formObj.pack_item_code.value) +
			    "&pack_item_desc=" + (formObj.pack_item_desc.value) +
			    "&pack_item_qty=" + (formObj.pack_item_qty.value) +
			    "&group_code=" + (formObj.group_code.value) +
			    "&tray_no=" + (formObj.tray_no.value) +
			    "&hold_yn=" + (formObj.hold_yn.checked) +
			    "&hold_reason=" + (formObj.hold_reason.value) +
			    "&packing_date=" + (formObj.packing_date.value) +
			    "&index=" + (formObj.index.value) +
			    "&validate=ADD_TO_LIST", false);
		
		//xmlHttp.send(xmlDoc);
		xmlHttp.setRequestHeader("Content-Type", "text/xml");
		 
	    xmlHttp.send(new XMLSerializer().serializeToString(xmlDoc));	

				responseText=xmlHttp.responseText;

		eval(responseText.replace(/<\/?[^>]+(>|$)|\s+|\r?\n/g, ""));

		if( result ) {
			refreshDetails();
		}
		else{
			messageFrame.location.href = errorPage+"?err_num="+ getMessage(message,"SS");
		}

}

function addToDiscrepancyList(called_from){
	var formObj=  document.formPackingDiscrepancyDetail;

	var fields = new Array ( formObj.item_code, formObj.write_off_reason_code, formObj.discrepancy_qty);
	var names  =  new Array ( getLabel("eSS.Instrument.label","SS"),getLabel("eSS.DiscrepancyReason.label","SS"),getLabel("eSS.DiscrepancyQuantity.label","SS")  );
	var obj    =null;
	for( var i=0;i<fields.length; i++ ){
		if(trimCheck(fields[i].value)) 
			fields[i].value = trimString(fields[i].value);
		else{
			alert ("APP-000001 " + names[i] + " cannot be blank...");
			fields[i].focus();
			return;
		}
	}
	var item_desc				=		formObj.item_code.options[formObj.item_code.selectedIndex].text;
	var write_off_reason_desc	=		formObj.write_off_reason_code.options[formObj.write_off_reason_code.selectedIndex].text;
	var xmlDoc="";
	 xmlDoc = new DOMParser().parseFromString(getXMLString(null), "application/xml");
	var xmlHttp = new XMLHttpRequest();
	var validate = "ADD_TO_DISCREPANCY_LIST";
	//xmlDoc.loadXML(getXMLString(null));
	//xmlHttp.open("POST", "../../eSS/jsp/PackingValidate.jsp?validate=ADD_TO_DISCREPANCY_LIST+"&item_code=" + formObj.item_code.value + "&item_desc=" + item_desc+ "&write_off_reason_code=" + formObj.write_off_reason_code.value + "&write_off_reason_desc=" + write_off_reason_desc+ "&discrepancy_qty=" + formObj.discrepancy_qty.value + "&remarks=" + escape(formObj.remarks.value) +"&discrepancy_cost=" + formObj.discrepancy_cost.value+"&group_code=" + formObj.group_code.value+"&tray_no=" + formObj.tray_no.value +"&index="+formObj.index.value, false);
	xmlHttp.open("POST", "../../eSS/jsp/PackingValidate.jsp?validate=ADD_TO_DISCREPANCY_LIST" +
		    "&item_code=" + encodeURIComponent(formObj.item_code.value) +
		    "&item_desc=" + encodeURIComponent(item_desc) +
		    "&write_off_reason_code=" + encodeURIComponent(formObj.write_off_reason_code.value) +
		    "&write_off_reason_desc=" + encodeURIComponent(write_off_reason_desc) +
		    "&discrepancy_qty=" + encodeURIComponent(formObj.discrepancy_qty.value) +
		    "&remarks=" + encodeURIComponent(formObj.remarks.value) +
		    "&discrepancy_cost=" + encodeURIComponent(formObj.discrepancy_cost.value) +
		    "&group_code=" + encodeURIComponent(formObj.group_code.value) +
		    "&tray_no=" + encodeURIComponent(formObj.tray_no.value) +
		    "&index=" + encodeURIComponent(formObj.index.value), false);
	
	//xmlHttp.send(xmlDoc);
	xmlHttp.setRequestHeader("Content-Type", "text/xml");
	 
    xmlHttp.send(new XMLSerializer().serializeToString(xmlDoc));	

 
	responseText=xmlHttp.responseText;

	eval(responseText.replace(/<\/?[^>]+(>|$)|\s+|\r?\n/g, ""));
	if( result ){
		resetPackingDiscrepancyDetail();
		parent.framePackingDiscrepancyList.location.href=parent.framePackingDiscrepancyList.location.href;
	}
	else{
		alert(getMessage(message,"SS"));
	}
}

function preserveDiscrepancyDetails(){
	var xmlHttp = new XMLHttpRequest();
	var xmlDoc="";
	xmlDoc = new DOMParser().parseFromString(getEnhancedXMLString(document.formPackingDiscrepancyList), "text/xml");
//	xmlDoc.loadXML(getEnhancedXMLString(document.formPackingDiscrepancyList));
	xmlHttp.open("POST", "../../eSS/jsp/PackingValidate.jsp?validate=PRESERVE_DISCREPANCY", false);
	xmlHttp.send(xmlDoc);
	responseText=xmlHttp.responseText;
}

function resetPackingDetail(){
	var formObj=top.content.f_query_add_mod.framePackingDetail.document.formPackingDetail;
	formObj.group_code.value="";
	formObj.group_desc.value="";
	formObj.tray_no.value="";
	formObj.pack_item_code.value="";
	formObj.pack_item_desc.value="";
	formObj.item_search.disabled=true;
	formObj.pack_item_qty.value="";
	formObj.pack_item_qty.disabled=true;
	formObj.pack_cost.value="";
	formObj.packing_date.value="";
	formObj.packing_date.disabled=true;
	formObj.apply.disabled=true;
	formObj.cancel.disabled=true;
	formObj.discrepancy.disabled=true;
	formObj.hold_yn.disabled=true;
	formObj.hold_yn.checked=false;
	formObj.hold_reason.disabled=true;
	formObj.hold_reason.value="";
	formObj.index.value="-1";
	formObj.querySelector('#details').disabled = true;
	formObj.querySelector('#details').style.cursor = "default";
}

function resetPackingDiscrepancyDetail(){
	var formObj=document.formPackingDiscrepancyDetail;
	formObj.item_code.value="";
	formObj.item_code.disabled=false;
	formObj.write_off_reason_code.value="";
	formObj.write_off_reason_code.disabled=false;
	formObj.discrepancy_qty.value="";
	formObj.remarks.value="";
	formObj.discrepancy_cost.value="";
	formObj.apply.value="  Add  ";
	formObj.index.value="-1";
}

function refreshDetails(){
	displayMessage(top.content.messageFrame,"");
	resetPackingDetail();
	refreshList();
}

function refreshList(){
	top.content.f_query_add_mod.framePackingList.document.location.reload();
    parent.framePackingDetail.formPackingDetail.querySelector('#details').disabled = true;
	parent.framePackingDetail.formPackingDetail.querySelector('#details').style.cursor = "default";
}

function listModify(index){

parent.framePackingDetail.location.href="../../eSS/jsp/PackingDetail.jsp?index="+index+"&function_id="+parent.parent.function_id;
	parent.framePackingDetail.formPackingDetail.querySelector('#details').disabled = false;
	parent.framePackingDetail.formPackingDetail.querySelector('#details').style.cursor = "hand";
}

function discrepancyListModify(index){
	parent.framePackingDiscrepancyDetail.location.href="../../eSS/jsp/PackingDiscrepancyDetail.jsp?index="+index;//+"&function_id="+parent.function_id;
}

function Modify(obj){
	
	var doc_type_code=obj.cells[5].innerText;
	var doc_no=obj.cells[1].innerText;
	var store_code=obj.cells[5].innerText;
	
	top.content.f_query_add_mod.document.location.href="../../eSS/jsp/PackingFrame.jsp?mode="+MODE_MODIFY+"&function_id="+parent.parent.function_id+"&store_code="+store_code+"&doc_type_code="+doc_type_code+"&doc_no="+doc_no;
}



function doDateCheckFrom(packingDate,docDate) { 
	 if(packingDate.value != "")
	 {

				var fromarray;
				var toarray;
				var fromdate =packingDate.value ;
				var todate =docDate.value ;

				if(fromdate.length > 0 && todate.length > 0 ) {
						fromarray = fromdate.split("/");
						toarray = todate.split("/");
						var fromdt = new Date(fromarray[2],fromarray[1],fromarray[0]);
						var todt = new Date(toarray[2],toarray[1],toarray[0]);
						if(Date.parse(todt) > Date.parse(fromdt)) {
							var msg = getMessage('PACKING_DATE_GREATER_DOC_DATE',"SS");
							parent.parent.messageFrame.location.href='../../eCommon/jsp/error.jsp?err_num='+msg;
							packingDate.focus();
							packingDate.select();
							return false;
						}
						else if(Date.parse(todt) <= Date.parse(fromdt))
						{
							parent.parent.messageFrame.location.href='../../eCommon/jsp/error.jsp?' ;
							return true;
						}
				   }
			return true;
	 }
	return true;
}

function check()
{
	var flag=true;
	var hold=parent.framePackingDetail.formPackingDetail.hold_yn.checked;
	if(hold==false&& (parent.framePackingDetail.formPackingDetail.packing_date.value=='')){
	if(parent.framePackingDetail.formPackingDetail.packing_date.value.length <1)
	{	alert(getMessage("PACKING_DATE_NOT_BLANK","SS"));
		parent.framePackingDetail.formPackingDetail.packing_date.select();
		parent.framePackingDetail.formPackingDetail.packing_date.focus();
		flag=false;

		return flag;
	}
	}

	

 if((hold==false&& (parent.framePackingDetail.formPackingDetail.packing_date.value!=''))||(hold==true && parent.framePackingDetail.formPackingDetail.packing_date.value==''))
  
	{
             if(parent.framePackingDetail.formPackingDetail.expiry_date !=undefined){//Adding start for TH-KW-CRF-0030
				 parent.framePackingDetail.formPackingDetail.expiry_date.value ="";
			 }//Adding end for TH-KW-CRF-0030
			 addToList();
			 
	}
		

	

}
function checkSysdate(receiptdate,sysdate){
	var locale			=	document.formPackingDetail.locale.value;
		if(CheckDate(receiptdate))
	{

		receiptdate.value	=	convertDate(receiptdate.value,'DMY',locale,"en"); 
		return true;
	}
	else
	{
		return false;
	}

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
		else
		{
		

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
function validateDocDate(doc_date) {
	var arrayObjects = new Array();
	arrayObjects[0] = doc_date;

		xmlDom = new ActiveXObject( "Microsoft.XMLDom" );
		xmlHttp = new ActiveXObject( "Microsoft.XMLHTTP" );
		xmlStr = getXMLString (arrayObjects);
		xmlDom = new DOMParser().parseFromString(xmlStr, "text/xml");
		//xmlDom.loadXML( xmlStr );
		xmlHttp.open("POST", "../../eSS/jsp/PackingValidate.jsp?validate=doc_date&function_type=4", false);
		xmlHttp.send( xmlDom );
		responseText=xmlHttp.responseText;

		eval( responseText );

}	
function assignResult( _result, _message, _flag ) {
	result = _result ;

	message  = _message ;

	flag = _flag ;

}
function errorDisplay() {
	

	document.formPackingDetail.packing_date.focus(); 
}
function requestDocDateFocus() {
	parent.framePackingDetail.formPackingDetail.packing_date.focus();
}
function details()
{
    var group_code		=	document.formPackingDetail.group_code.value;
	var group_desc		=	document.formPackingDetail.group_desc.value;
    
	if(group_code!="")
	{
	var dialogHeight = "450px" ;
	//var dialogWidth	= "24" ;
	var dialogWidth	= "750px" ;

	var dialogTop = "265" ;
	var center = "1" ;

	var features = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +"; center: " + center + "; dialogTop :" + dialogTop +"; scroll=yes; status=no;" ;
	var arguments = "" ;
	var title="Request Detail";
	var params = "group_code="+group_code+"&group_desc="+group_desc;
	
	retVal = window.showModalDialog("../../eSS/jsp/GroupItemDetails.jsp?"+params,arguments,features);
	}
}
