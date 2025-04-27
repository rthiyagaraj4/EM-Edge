/*
---------------------------------------------------------------------------------------------------------
Date			Edit History    	Name		Rev. Date		Rev. By			Description
---------------------------------------------------------------------------------------------------------
31/12/20221																		MO-CRF-20174 
---------------------------------------------------------------------------------------------------------
*/
var xmlDom;
var xmlHttp;
var prevObj=null;
var prevColor=null;

function assignBean(frmObject) {
	bean_id = frmObject.bean_id.value;
	bean_name = frmObject.bean_name.value;
	//xmlDom = new ActiveXObject("Microsoft.XMLDom");
	//xmlHttp = new ActiveXObject("Microsoft.XMLHTTP");
	xmlDom = "";
	xmlHttp = new XMLHttpRequest();
}


function Modify(obj){
	/*var doc_no =obj.cells[1].innerText;
	var doc_type_code =obj.cells[6].innerText;
	parent.document.location.href="../../eST/jsp/CancelRequestFrame.jsp?mode="+MODE_MODIFY+"&function_id="+parent.parent.function_id+"&doc_type_code="+doc_type_code+"&doc_no="+doc_no;*/ 
}

function onSuccess(){
	f_query_add_mod.document.location.reload();
	messageFrame.location.href = "../../eCommon/jsp/error.jsp?error_value=0&err_num="+ message;
	return;
}

function reset() {
		f_query_add_mod.location.reload();
}

function query() {
		f_query_add_mod.location.href="../../eST/jsp/RejectRequestQueryFrame.jsp?function_id="+function_id+"&mode="+MODE_MODIFY;
}

function apply() {
	var errorPage = "../../eCommon/jsp/error.jsp";
	if( f_query_add_mod.RejectRequestQueryResultFrame==undefined){
		messageFrame.location.href ="../../eCommon/jsp/error.jsp?err_num=";
		return;
	}
	var formObject = f_query_add_mod.RejectRequestQueryResultFrame.document.formRejectRequestQueryResult;
	if (formObject == null) {
		messageFrame.location.href = errorPage+"?err_num=";
		return;
	}
	var total_items = formObject.total_check_boxes.value;
	var chkdValue = 0;
	var chkditemvalue = 0; //Rabbani # Bru-HIMS-CRF-118[INC NO:30077]
	  for (count = 0;count<total_items;count++) {
			if(eval("formObject.doc_"+count+".checked")) {
			if(eval("formObject.rem_"+count).value == ""){  
			 messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num="+ getMessage('ADJ_REMARKS_NOT_BLANK','ST');
			return;
			}else if(eval("formObject.rem_"+count).value =='undefined'){
			 messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num="+ getMessage('ADJ_REMARKS_NOT_BLANK','ST');
			return;
			}
				chkdValue++;
			}
			//Added by Rabbani # Bru-HIMS-CRF-118[INC NO:30077] on 16-JULY-2013 Starts 
			var total_dtl_items  =   eval("formObject.item_size_"+count).value;
			for (j = 0;j<total_dtl_items;j++) {
			if(eval("formObject.item_cancel_"+count+"_"+j) != null){
			if(eval("formObject.item_cancel_"+count+"_"+j+".checked")){
			var item_name = decodeURIComponent(eval("formObject.item_desc_"+count+"_"+j).value,"UTF-8");
			    if(eval("formObject.dtl_rem_"+count+"_"+j).value == ""){ 
				flag_doc = eval("formObject.doc_"+count).value;
				flag1 = (flag_doc.split("~"))[1];
				messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num="+ getMessage('ADJ_REMARKS_NOT_BLANK','ST')+"    for Doc no : "+flag1+"   "+" Item Desc : "+item_name;
				 return;
				 }else 
			      if(eval("formObject.dtl_rem_"+count+"_"+j).value =='undefined'){
				messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num="+getMessage('ADJ_REMARKS_NOT_BLANK','ST')+"    for Doc no : "+flag1+"   "+" Item Desc : "+item_name;
				  return;
				  }
					chkditemvalue++;
				}
			  }
			} //ends
	   }
	//if (chkdValue<=0){
	if (chkdValue<=0 && chkditemvalue<=0) {  //Rabbani # Bru-HIMS-CRF-118[INC NO:30077]
	messageFrame.location.href = errorPage+"?err_num="+ "APP-ST0211 Select atleast one Issue Request or Stock Item for rejection"; 
		//getMessage('MIN_ONE_DETAIL_REQUIRED','Common');
		return;
	}
	var selectedIndices = "";
	var selecteditemIndices = ""; 
	var index = 0;
	//var flag  = "true";
	var total_check_boxes = formObject.total_check_boxes.value;

	for (count = 0;count<total_check_boxes;count++) {
	        var total_dtl_items  =   eval("formObject.item_size_"+count).value; //Rabbani # Bru-HIMS-CRF-118[INC NO:30077]
			var item_dtl_length  =   eval("formObject.item_dtl_length_"+count).value;//Rabbani # Bru-HIMS-CRF-118[INC NO:30077]
			var flag_chk         =   true;
				if(eval("formObject.doc_"+count+".checked") &&  (total_dtl_items == item_dtl_length)) {
				 //if(total_dtl_items == item_dtl_length){  
				    flag_chk = false;
					selectedIndices += (count+ ",");
					// }
				 }
			for (j = 0;j<total_dtl_items;j++) {
			if(eval("formObject.item_cancel_"+count+"_"+j) != "null"){
			if(eval("formObject.item_cancel_"+count+"_"+j+".checked")){
			       if(flag_chk)
					selecteditemIndices += (count+"_"+j+ ",");
				 }
			  }
			}
			
			/*}
			else
			{
				//alert(flag);
				flag = "false";
			}*/
	  }
	formObject.checkedIndices.value = selectedIndices;
	formObject.checked_item_indices.value = selecteditemIndices;
	
	CancelYN = confirm("Do you want to Reject Selected Request"); //MO-CRF-20174 
	//alert(CancelYN)
	if(!CancelYN){
	messageFrame.location.href = errorPage+"?err_num=";
		return false;
	}

//	{
	if(CancelYN) 
	{
		var appResult  = formApply(formObject, ST_CONTROLLER);

		eval(appResult);
		flag1 = (flag.split("~"))[0];
	    flag2 = (flag.split("~"))[1];
	   flag1 = (flag1 == "null" ? "" : flag1);
		if (message == "INVALID_REMARKS") {
		  messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num="+ getMessage('ADJ_REMARKS_NOT_BLANK','ST');
		}
		/*else {
		messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num="+ getMessage(message,'ST');
        } */
		if(result) {
       //Added by Rabbani #BRU-HIMS-CRF-118[INC NO: 30077] on 24-JULY-2013 for online report Starts
		var bean_id = "rejectRequestBean";
	    var bean_name = "eST.RejectRequestBean";
		if (flag2 == "PY") {
			var PConfirm = await confirmPrinting();
			if (PConfirm == "Yes") {
				var xmlHttp = new XMLHttpRequest();
				var xmlDoc="";
				//xmlDoc.loadXML(getXMLString(null));
				xmlDoc = new DOMParser().parseFromString(getXMLString(null), "text/xml");
				xmlHttp.open("POST", "../../eST/jsp/RejectRequestValidate.jsp?function_type=9&msg=" + encodeURIComponent(message) + "&bean_id="+bean_id +"&bean_name="+bean_name+"&request_on_store="+formObject.request_on_store.value+"&request_by_store="+formObject.request_by_store.value+"&from_doc_date="+formObject.from_doc_date.value+"&to_doc_date="+formObject.to_doc_date.value, true);
				xmlHttp.send(xmlDoc); 
			}	 
		} /*else 	if (flag2 == "PN") {
				var xmlHttp = new XMLHttpRequest();
				var xmlDoc="";
				xmlDoc.loadXML(getXMLString(null));
				xmlHttp.open("POST", "../../eST/jsp/CancelRequestValidate.jsp?function_type=9&msg=" + encodeURIComponent(message) + "&bean_id=" + bean_id + "&bean_name=" + bean_name, true);
				xmlHttp.send(xmlDoc);
				 
		   }*/
		   //ends
			onSuccess();
		}
	}
	else {
	   f_query_add_mod.document.location.reload();
	   messageFrame.location.href = "../../eCommon/jsp/error.jsp?error_value=0&err_num="+ getMessage("OPER_CANCELLED","ST");
	}
/*	}
	else
	{
		//f_query_add_mod.document.location.reload();
	    messageFrame.location.href = "../../eCommon/jsp/error.jsp?error_value=0&err_num="+ getMessage("REMARKS_NOT_BLANK");
		
	}
	*/
}

async function displayPending(trObj) {
	changeRowColor(trObj,9);
	var doc_no =trObj.cells[2].innerText;
	var doc_type_code = trObj.cells[9].innerText
	retVal=await window.showModalDialog("../../eST/jsp/CancelRequestList.jsp?function_id="+parent.parent.function_id+"&doc_type_code="+doc_type_code+"&doc_no="+doc_no,'','dialogHeight:15vh; dialogWidth:40vw; center:0; status: no; dialogLeft :75; dialogTop :250;');
	
}

async function showReason(trObj,index) {
	//changeRowColor(trObj,8);
	changeRowColor(trObj,9); //Added by Rabbani # Bru-HIMS-CRF-118[INC NO:30077] on 16-JULY-2013 
	 var doc_no =trObj.cells[2].innerText;
	 //var doc_type_code = trObj.cells[8].innerText
	var doc_type_code = trObj.cells[9].innerText
	
	
	if (eval ("document.formRejectRequestQueryResult.doc_"+index+".checked")){
		retVal=await window.showModalDialog("../../eST/jsp/RejectRequestRemarks.jsp?function_id="+parent.parent.function_id+"&doc_type_code="+doc_type_code+"&doc_no="+doc_no,'','dialogHeight:30vh; dialogWidth:36vw; center:0; status: no; dialogLeft :75; dialogTop :250;');
		
		while(retVal == undefined){
		alert('Please Press Close Button');  // //Added by Padmapriya for INC # 34746 on 30/08/2012
		retVal=await window.showModalDialog("../../eST/jsp/RejectRequestRemarks.jsp?function_id="+parent.parent.function_id+"&doc_type_code="+doc_type_code+"&doc_no="+doc_no,'','dialogHeight:30vh; dialogWidth:36vw; center:0; status: no; dialogLeft :75; dialogTop :250;');
		} 
		
		(eval("document.formRejectRequestQueryResult.rem_"+index)).value=retVal;
		//(eval("document.formCancelRequestQueryResult.rem_"+index)).value=encodeURIComponent(retVal);
		 
		var dtl_item_size = (eval("document.formRejectRequestQueryResult.item_size_"+index)).value;
		for(j=0; j < dtl_item_size; j++){
		if((eval("document.formRejectRequestQueryResult.dtl_rem_"+index+"_"+j)).value == "")
		//(eval("document.formCancelRequestQueryResult.dtl_rem_"+index+"_"+j)).value = retVal;
		(eval("document.formRejectRequestQueryResult.dtl_rem_"+index+"_"+j)).value = encodeURIComponent(retVal);
		}
	}
}

function updateRemarks() {
	formObject = document.formRejectRequestRemarks;
	if (!setTextAreaMaxLength(formObject.remarks,201)) {
		alert (getMessage('REMARKS_CHAR_EXCEEDS_LIMIT','ST'));
		return;
	}
	if (formObject.remarks.value == "") {
		checkField(formObject.remarks,getLabel("Common.remarks.label","Common"));
		//alert("Remarks"+getMessage("SHOULD_NOT_BE_BLANK","Common"));
		return;
	}
	assignBean(formObject);
	//xmlStr = getXMLString(formObject);
	xmlStr = getEnhancedXMLString(formObject); //Added by Rabbani  # Bru-HIMS-CRF-118[INC NO:30077] on 22-JULY-2013
	//xmlDom.loadXML(xmlStr);
	xmlDom = new DOMParser().parseFromString(xmlStr, "text/xml");
	//alert(xmlStr);
	xmlHttp.open("POST", "../../eST/jsp/RejectRequestValidate.jsp?bean_id="+bean_id+"&bean_name="+bean_name+"&function_type=1", false);
	xmlHttp.send(xmlDom);
	responseText=xmlHttp.responseText;
	//alert(responseText);
	eval(responseText);
	//alert(formObject.remarks_code_1.value);
	window.returnValue = formObject.remarks_code_1.value;  
	if(formObject.remarks_code_1.value == "")
	window.returnValue = formObject.remarks.value;
	window.close();
}

function SubmitLink(from, to) {
	var formObject = document.formRejectRequestQueryResult;
	var selectedIndices = "";
	var selectedItemIndices = ""; //Rabbani # Bru-HIMS-CRF-118[INC NO:30077]
	var index = 0;
	var total_check_boxes = formObject.total_check_boxes.value;
	
	for (count = 0;count<total_check_boxes;count++) {
	//Rabbani # Bru-HIMS-CRF-118[INC NO:30077]
	var total_dtl_items  =   eval("formObject.item_size_"+count).value;
	var item_dtl_length  =   eval("formObject.item_dtl_length_"+count).value;
	var flag_chk         =   true;
			    if(eval("formObject.doc_"+count+".checked")) {
				if(eval("formObject.rem_"+count).value == ""){
				alert(getMessage('ADJ_REMARKS_NOT_BLANK','ST'));
				return;
				}
				//Added by Rabbani Inc no: 42518(CRF-ST- Bru-HIMS-CRF-0118/04-Remarks- Next Hyperlink) on 20-AUG-2013
				eval("formObject.rem_"+count).value = encodeURIComponent(eval("formObject.rem_"+count).value);
				//ends
				 if(total_dtl_items == item_dtl_length){
				    flag_chk = false;
					selectedIndices += (count+ ",");
					}
		        }
			  for (j = 0;j<total_dtl_items;j++){ 
			  if(eval("formObject.item_cancel_"+count+"_"+j+".checked")){
			  if(eval("formObject.dtl_rem_"+count+"_"+j).value == ""){
				flag_doc = eval("formObject.doc_"+count).value;
				flag1 = (flag_doc.split("~"))[1];
				var item_name = decodeURIComponent(eval("formObject.item_desc_"+count+"_"+j).value,"UTF-8");
				//alert(getMessage('ADJ_REMARKS_NOT_BLANK','ST')+"    for Doc no  : "+flag1+"   "+" Item Desc :"+eval("formObject.item_desc_"+count+"_"+j).value);
				alert(getMessage('ADJ_REMARKS_NOT_BLANK','ST')+"    for Doc no  : "+flag1+"   "+" Item Desc :"+item_name);
				 return;   
				 }
				 //Added by Rabbani Inc no: 42518(CRF-ST- Bru-HIMS-CRF-0118/04-Remarks- Next Hyperlink) on 20-AUG-2013
				 eval("formObject.dtl_rem_"+count+"_"+j).value = encodeURIComponent(eval("formObject.dtl_rem_"+count+"_"+j).value);
				 //ends
				  if(flag_chk)
					selectedItemIndices += (count+"_"+j+ ",");
				 }
			   }
	     }
	formObject.checkedIndices.value = selectedIndices;
	formObject.checked_item_indices.value = selectedItemIndices; 
	assignBean(formObject);
	xmlStr = getXMLString(formObject); 
	//xmlStr = getEnhancedXMLString(formObject); //added by rabbani # inc no:42135 on 05-AUG-2013
	//xmlDom.loadXML(xmlStr);
	xmlDom = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST", "../../eST/jsp/RejectRequestValidate.jsp?bean_id="+bean_id+"&bean_name="+bean_name+"&function_type=2", false);
	xmlHttp.send(xmlDom);
	responseText=xmlHttp.responseText;
	eval(responseText);
    document.QueryForm.from.value = from;
    document.QueryForm.to.value = to;
    document.QueryForm.submit() ;
}



function changeMyRowColor(index,n,chkObj) { 
	
	var trObj=eval(document.getElementById('tr_'+index));
	//alert(trObj);
	var formObject         =   document.formRejectRequestQueryResult;
     var allElements	   =	formObject.elements;
     var dtl_length        =   eval("formObject.item_size_"+index).value;  //Rabbani # Bru-HIMS-CRF-118[INC NO:30077]
	 var total_check_boxes =   formObject.total_check_boxes.value;
	 var ischecked =chkObj.checked;
	 
	 
	for (j=0; j<dtl_length; j++) //Rabbani # Bru-HIMS-CRF-118[INC NO:30077]
	{
		if (allElements[j].type=="checkbox")
			if (!allElements[j].disabled) 
				//allElements[j].checked=ischecked;
				
				ischecked =chkObj.checked;
				eval("formObject.item_cancel_"+index+"_"+j).checked=ischecked;
				if(eval("formObject.dtl_img_"+index+"_"+j) != null)
				eval("formObject.dtl_img_"+index+"_"+j).style.visibility="visible";
				
				if(!ischecked){
				key = "";
				assignBean(formObject);
	            //xmlStr = getXMLString(formObject);
	            xmlStr = getXMLString(null);//added by rabbani # inc no:42155 on 05-AUG-2013
	            //xmlDom.loadXML(xmlStr);
	            xmlDom = new DOMParser().parseFromString(xmlStr, "text/xml");
				 if(eval("formObject.dtl_img_"+index+"_"+j) != null)
				 eval("formObject.dtl_img_"+index+"_"+j).style.visibility="hidden";
				 
				  key = eval("formObject.doc_"+index).value;
				  xmlHttp.open("POST", "../../eST/jsp/RejectRequestValidate.jsp?bean_id="+bean_id+"&bean_name="+bean_name+"&key="+key+"&function_type=7", false);
	               xmlHttp.send(xmlDom);
	               responseText=xmlHttp.responseText;
	               eval(responseText);
 
		            key = key+"-"+eval("formObject.item_code_"+index+"_"+j).value;
	                xmlHttp.open("POST", "../../eST/jsp/RejectRequestValidate.jsp?bean_id="+bean_id+"&bean_name="+bean_name+"&key="+key+"&function_type=8", false);
	                xmlHttp.send(xmlDom);
	               responseText=xmlHttp.responseText;
	                eval(responseText);
					
					eval("formObject.dtl_rem_"+index+"_"+j).value = "";
					eval("formObject.rem_"+index).value = "";
					
				}
	    if (chkObj.checked) {
		//OAGREEN,OAHOLIDAY,DATACHANGE,ORPANEL,ORHIGHER		
		classValue="DATACHANGE"
		//Added by Rabbani #INC NO:37466 on 18/FEB/2013 
	    eval(document.getElementById('img_'+index)).style.visibility="visible";
	    eval("formObject.dtl_img_"+index+"_"+j).style.visibility="visible";
	   }
	   else if (index%2==0) {
		classValue="OAQRYEVEN";
		 //Added by Rabbani #INC NO:37466 on 18/FEB/2013 
		eval(document.getElementById('img_'+index)).style.visibility="hidden";
		eval("formObject.dtl_img_"+index+"_"+j).style.visibility="hidden";
		}
	 else{
		classValue="OAQRYODD";
		 //Added by Rabbani #INC NO:37466 on 18/FEB/2013 
		eval(document.getElementById('img_'+index)).style.visibility="hidden";		
		}

	for( k=0;k<n;k++)
		trObj.cells[k].className=classValue;
}
     var check_all = true;
	 for(i=0; i<total_check_boxes;i++){
	 if(eval("formObject.doc_"+i).checked == false)
	   check_all = false;
	 }
	 
	 if(check_all)
	 formObject.cancelAll.checked = true;
	 else
	 formObject.cancelAll.checked = false;
}


var prevObj=null;
var prevColor=null;

function changeRowColor(obj,n) {
	if(prevObj!=null){
		for( k=0;k<n;k++)
			prevObj.cells[k].className=prevColor;
	}
	prevObj=obj;
	prevColor=obj.cells[0].className;
	for( k=0;k<n;k++)
		obj.cells[k].className="STLIGHTPINK";
}

function submitQueryCriteria(){
	if (isValidFromToField(document.formRejectRequestQueryCriteria.from_doc_date,document.formRejectRequestQueryCriteria.to_doc_date,DATE,getLabel("Common.DocDate.label", "Common"),parent.parent.messageFrame,"../../eCommon/jsp/error.jsp")) 
	{
		if(document.formRejectRequestQueryCriteria.item_desc.value != "")
		{
			alert("When searching for Issue Requests using Item, no other Stock Items contained in the Issue Request ID are displayed");
		}
		document.formRejectRequestQueryCriteria.action="../../eST/jsp/RejectRequestQueryResult.jsp";
		document.formRejectRequestQueryCriteria.target="RejectRequestQueryResultFrame";
		document.formRejectRequestQueryCriteria.submit();
	}
}

// Added on Monday, July 26, 2004
function toggleCheck(formObject){
	var allElements	=	formObject.elements;
	var ischecked=formObject.cancelAll.checked;
	for (i=0; i<allElements.length; i++) 
	{
		    if (allElements[i].type=="checkbox")
			if (!allElements[i].disabled) 
				allElements[i].checked=ischecked;
		 //Added by Rabbani #INC NO:37466 on 18/FEB/2013  Starts
				if(eval("formObject.img_"+i) != null)
				eval("formObject.img_"+i).style.visibility="visible";
				
				if(!ischecked){
				if(eval("formObject.img_"+i) != null)
				 eval("formObject.img_"+i).style.visibility="hidden";
				 
				key = "";
				assignBean(formObject);
	            //xmlStr = getXMLString(formObject);
	             xmlStr = getXMLString(null);//added by rabbani # inc no:42155 on 05-AUG-2013
	            //xmlDom.loadXML(xmlStr);
	            xmlDom = new DOMParser().parseFromString(xmlStr, "text/xml");
				 if(eval("formObject.doc_"+i) != null){
				  key = eval("formObject.doc_"+i).value;
				  
				  xmlHttp.open("POST", "../../eST/jsp/RejectRequestValidate.jsp?bean_id="+bean_id+"&bean_name="+bean_name+"&key="+key+"&function_type=7", false);
	               xmlHttp.send(xmlDom);
	               responseText=xmlHttp.responseText;
	               eval(responseText);
				   eval("formObject.rem_"+i).value = "";
				   }
				   }
				
				
				//Added by Rabbani # Bru-HIMS-CRF-118[INC NO:30077] on 16-JULY-2013 Starts 
				 if(eval("formObject.item_size_"+i) != null)
				 var dtl_length=     eval("formObject.item_size_"+i).value;
				 
				 for(j=0; j<dtl_length;j++){
				 if(eval("formObject.dtl_img_"+i+"_"+j) != null)
				 eval("formObject.dtl_img_"+i+"_"+j).style.visibility="visible";
				  //ends
				  
				 if(!ischecked){
				 //Added by Rabbani # Bru-HIMS-CRF-118[INC NO:30077] on 16-JULY-2013 Starts 
				 if(eval("formObject.dtl_img_"+i+"_"+j) != null)
				 eval("formObject.dtl_img_"+i+"_"+j).style.visibility="hidden";
				 
				 
                   if(eval("formObject.item_code_"+i+"_"+j) != null){
		            key = key+"-"+eval("formObject.item_code_"+i+"_"+j).value;
	                xmlHttp.open("POST", "../../eST/jsp/RejectRequestValidate.jsp?bean_id="+bean_id+"&bean_name="+bean_name+"&key="+key+"&function_type=8", false);
	                xmlHttp.send(xmlDom);
	               responseText=xmlHttp.responseText;
	                eval(responseText);
					eval("formObject.dtl_rem_"+i+"_"+j).value = "";
					}		 
				}
				//ends
		    }
	}
}

// End - Monday, July 26, 2004
//MO-CRF-20174 
function populateStores(request_on_store) {
	
 	/*if (request_on_store.value == "")	{//commented for ICN-38209
		clearListItems('document.forms[0].request_by_store');
		return;
	}*/
	
	var arrayObject										=		 new Array();
	arrayObject[0]										=		request_on_store.value;
	assignBean(document.formRejectRequestQueryCriteria);
	xmlStr												=		getXMLString(arrayObject);
	//xmlDom.loadXML(xmlStr);
	xmlDom = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST", "../../eST/jsp/RejectRequestValidate.jsp?bean_id="+bean_id+"&bean_name="+bean_name+"&request_on_store="+request_on_store.value+"&function_type=3", false);
	xmlHttp.send(xmlDom);
	responseText										=		xmlHttp.responseText;
	eval(responseText);
	
}
function populateItemClasses(request_on_store,request_by_store) {
	if (request_by_store == "" || request_on_store.value == "")	{
		
		clearListItems('document.forms[0].item_class_code');
		return;
	}
	var arrayObject			=		 new Array();
	arrayObject[0]			=		request_by_store;
	arrayObject[1]			=		request_on_store;
	assignBean(document.formRejectRequestQueryCriteria);
	xmlStr					=		 getXMLString(arrayObject);
	//xmlDom.loadXML(xmlStr);
	xmlDom = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST", "../../eST/jsp/RejectRequestValidate.jsp?bean_id="+bean_id+"&bean_name="+bean_name+"&function_type=4", false);
	xmlHttp.send(xmlDom);
	responseText=xmlHttp.responseText;
	eval(responseText);
}
async function searchRemarks(objCode,objDesc)
{
	
	var argumentArray		 =		 new Array();
	var dataNameArray		 =		 new Array();
	var dataValueArray		 =		 new Array();
	var dataTypeArray		 =		 new Array();
	var sql                  =       "SELECT DISTINCT MM.TRN_REMARKS_CODE  CODE,MM.REMARKS_DESC  DESCRIPTION FROM  MM_TRN_REMARKS_LANG_VW  MM, ST_TRN_TYPE_FOR_REMARKS ST WHERE ST.TRN_REMARKS_CODE = MM.TRN_REMARKS_CODE AND   UPPER(MM.LANGUAGE_ID) LIKE  UPPER(?) AND UPPER(MM.MODULE_ID) LIKE  UPPER(?)   AND  UPPER(ST.TRN_TYPE)  LIKE  UPPER(?)     AND  MM.TRN_REMARKS_CODE LIKE   UPPER(?)     AND  UPPER(MM.REMARKS_DESC) LIKE  UPPER(?) AND REJECT_STATUS ='E'"

	dataNameArray[0]		 =		"language_id" ;
	//dataValueArray[0]		 =		document.formCancelRequestRemarks.lang_id.value;
	dataValueArray[0]		 =		document.forms[0].lang_id.value;
	dataTypeArray[0]		 =		STRING ;

	dataNameArray[1]		 =		"module_id" ;
	dataValueArray[1]		 =		"ST";
	dataTypeArray[1]		 =		STRING ; 
	

	dataNameArray[2]		 =		"trn_type" ;
	//dataValueArray[2]		 =		document.formCancelRequestRemarks.rem_trans_type.value;
	dataValueArray[2]		 =		"ISS";
	dataTypeArray[2]		 =		STRING ;

	//argumentArray[0]		 =		document.formCancelRequestRemarks.SQL_ST_TRN_REMARKS_LOOKUP_SELECT.value;
	argumentArray[0]		 =		sql;//document.forms[0].SQL_ST_TRN_REMARKS_LOOKUP_SELECT.value;


	argumentArray[1]		 =		dataNameArray;
	argumentArray[2]		 =		dataValueArray;
	argumentArray[3]		 =		dataTypeArray;
	argumentArray[4]		 =		 "4,5";
	argumentArray[5]		 =		objDesc.value;
	argumentArray[6]		 =		CODE_LINK;
	argumentArray[7]		 =		CODE_DESC;
	returnedValues			 =		await CommonLookup( getLabel("Common.remarks.label","Common"), argumentArray );	

	/*if((returnedValues != null) && (returnedValues != "") )  {
		objCode.value		 =		returnedValues[0];
		objDesc.value		 =		returnedValues[1];
	
	} */
	if(returnedValues != null && returnedValues != "" )
	{
		var ret1=unescape(returnedValues);
	 	var arr=ret1.split(",");
	 	if(arr[1]==undefined) { 
		arr[1]="";
		arr[0]="";
		}										
		 	objCode.value = arr[0];
			objDesc.value = arr[1];	  			  
	}
	
}

function populateReqOnStore(request_type)
{
	parent.RejectRequestQueryResultFrame.location.href=src="../../eCommon/html/blank.html";
	var arrayObject										=		 new Array();
	arrayObject[0]										=		request_type;
	assignBean(document.formRejectRequestQueryCriteria);
	xmlStr												=		getXMLString(arrayObject);
	//xmlDom.loadXML(xmlStr);
	xmlDom = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST", "../../eST/jsp/RejectRequestValidate.jsp?bean_id="+bean_id+"&bean_name="+bean_name+"&function_type=5", false);
	xmlHttp.send(xmlDom);
	responseText										=		xmlHttp.responseText;
	eval(responseText);

}
//Added by Rabbani # Bru-HIMS-CRF-118[INC NO:30077] on 16-JULY-2013 Starts
async function callItemSearch() {
	var search_string = "";
	if (!document.formRejectRequestQueryCriteria.item_desc.readOnly) {
		search_string = document.formRejectRequestQueryCriteria.item_desc.value;
	}
	var store_code = "";
	var category = "A";
	var sole_source = "A";
	var ps_item = "A";
	var mfg_item = "A";
	var expiry = "A";
	var consignment = "A";
	var item_class = "";
	var store_disable = "Y";
	var retVal = await callItemSearchWindow(search_string, store_code, category, sole_source, ps_item, mfg_item, expiry, item_class, consignment, "", "", store_disable);
	if (retVal != null) {
		document.formRejectRequestQueryCriteria.item_code.value = retVal[0];;
		document.formRejectRequestQueryCriteria.item_desc.value = retVal[1];
		document.formRejectRequestQueryCriteria.item_desc.readOnly=true;
	}
}

function expanddetails(obj, trObj,index){
	//alert("expanddetails");  
    var doc_no        =  trObj.cells[2].innerText;
	var doc_type_code =  trObj.cells[9].innerText;
	var frmObj        =   document.forms[0];	
	
	       if(eval(document.getElementById('item_dtls_'+doc_no))){	 
			var dispstatus = obj.innerText;
			if(dispstatus == '+'){
				document.getElementById('tblItemList_'+index).style.display ='inline';
				obj.innerText="-";
				obj.style.cursor='hand';
				obj.innerHTML="<a id='view"+index+" href='' width='2%'><font color='blue'><b>"+obj.innerText+"</b></font></a>";
			 }
			 else
			 if(dispstatus == '-'){
				document.getElementById('tblItemList_'+index).style.display ='none';
				obj.innerText="+";
				obj.style.cursor='hand';
				obj.innerHTML="<a id='view"+index+" href='' width='2%'><font color='blue'><b>"+obj.innerText+"</b></font></a>";
				
			}
		}	
}
function ItemCancel(index,n,chkObj)
{
var formObject = document.formRejectRequestQueryResult;
var total_check_boxes = formObject.total_check_boxes.value;
var check_all = true;
  if(chkObj.checked) {	
	eval("formObject.dtl_img_"+index+"_"+n).style.visibility="visible";
	 }else{
	 key = "";
	  eval("formObject.dtl_img_"+index+"_"+n).style.visibility="hidden";
	  eval("formObject.dtl_rem_"+index+"_"+n).value = "";
	  eval("formObject.doc_"+index).checked = false;
	   key = eval("formObject.doc_"+index).value;
	   key = key+"-"+eval("formObject.item_code_"+index+"_"+n).value;
		 
	     //Added for clearing remarks value after uncheck the check box for all
		 assignBean(formObject);
	    // xmlStr = getXMLString(formObject);
	     xmlStr = getXMLString(null);//added by rabbani # inc no:42155 on 05-AUG-2013
	     //xmlDom.loadXML(xmlStr);
	     xmlDom = new DOMParser().parseFromString(xmlStr, "text/xml");
	     xmlHttp.open("POST", "../../eST/jsp/RejectRequestValidate.jsp?bean_id="+bean_id+"&bean_name="+bean_name+"&key="+key+"&function_type=8", false);
	      xmlHttp.send(xmlDom);
	      responseText=xmlHttp.responseText;
	      eval(responseText);
		 //Added ends 
	 }
	 var dtl_length =     eval("formObject.item_size_"+index).value;
	 var count = 0;
	 for (j=0; j<dtl_length; j++) 
	{
	if(eval("formObject.item_cancel_"+index+"_"+j+".checked"))
	count++;
	}
	if(dtl_length == count){
	eval("formObject.doc_"+index).checked = true;
	eval(document.getElementById('img_'+index)).style.visibility="visible";
	}else{
	key = "";
	eval("formObject.doc_"+index).checked = false;
	eval(document.getElementById('img_'+index)).style.visibility="hidden";
	eval("formObject.rem_"+index).value = "";
	key = eval("formObject.doc_"+index).value;
	   
	     //Added for clearing remarks value after uncheck the check box for all
		 assignBean(formObject);
	     //xmlStr = getXMLString(formObject);
	     xmlStr = getXMLString(null);//added by rabbani # inc no:42155 on 05-AUG-2013
	     //xmlDom.loadXML(xmlStr);
	     xmlDom = new DOMParser().parseFromString(xmlStr, "text/xml");
	     xmlHttp.open("POST", "../../eST/jsp/RejectRequestValidate.jsp?bean_id="+bean_id+"&bean_name="+bean_name+"&key="+key+"&function_type=7", false);
	      xmlHttp.send(xmlDom);
	      responseText=xmlHttp.responseText;
	      eval(responseText);
		 //Added ends 
	
	 
	}
	 for(i=0; i<total_check_boxes;i++){
	 if(eval("formObject.doc_"+i).checked == false)
	   check_all = false;
	 }
	 
	 if(check_all)
	 formObject.cancelAll.checked = true;
	 else
	 formObject.cancelAll.checked = false;
}

async function showItemReason(index,n) {

	   var formObject       =  document.formRejectRequestQueryResult;
	         flag           =  eval("formObject.doc_"+index).value;
		  var doc_no        =eval("formObject.docno_"+index+"_"+n).value; //(flag.split("-"))[1]; Modified for ML-BRU-SCF-1715
		  var doc_type_code   =eval("formObject.doctypecode_"+index+"_"+n).value;// (flag.split("-"))[0]; Modified for ML-BRU-SCF-1715
		  var item_code        =  eval("formObject.item_code_"+index+"_"+n).value;
 		 
	   
	   if (eval ("formObject.item_cancel_"+index+"_"+n+".checked")){
		retVal=await window.showModalDialog("../../eST/jsp/RejectRequestDtlRemarks.jsp?function_id="+parent.parent.function_id+"&doc_type_code="+doc_type_code+"&doc_no="+doc_no+"&item_code="+item_code,'','dialogHeight:30vh; dialogWidth:35vw; center:0; status: no; dialogLeft :75; dialogTop :250;');//MO-CRF-20174
		
	    while(retVal == undefined){
		alert('Please Press Close Button'); 
		retVal=await window.showModalDialog("../../eST/jsp/RejectRequestDtlRemarks.jsp?function_id="+parent.parent.function_id+"&doc_type_code="+doc_type_code+"&doc_no="+doc_no+"&item_code="+item_code,'','dialogHeight:30vh; dialogWidth:35vw; center:0; status: no; dialogLeft :75; dialogTop :250;');
		}
		(eval("document.formRejectRequestQueryResult.dtl_rem_"+index+"_"+n)).value = retVal;   
 		 
	}
}

function updateItemRemarks() {
	var formObject = document.formRejectRequestdtlRemarks;
	if (!setTextAreaMaxLength(formObject.remarks,201)) {  
		alert (getMessage('REMARKS_CHAR_EXCEEDS_LIMIT','ST'));
		return;
	}
	if (formObject.remarks.value == "") {
		checkField(formObject.remarks,getLabel("Common.remarks.label","Common"));
		return;
	}
	assignBean(formObject);
	//xmlStr = getXMLString(formObject);
	xmlStr = getEnhancedXMLString(formObject);  //Added by Rabbani  # Bru-HIMS-CRF-118[INC NO:30077] on 22-JULY-2013
	//xmlDom.loadXML(xmlStr);
	xmlDom = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST", "../../eST/jsp/RejectRequestValidate.jsp?bean_id="+bean_id+"&bean_name="+bean_name+"&function_type=6", false);
	xmlHttp.send(xmlDom);
	responseText=xmlHttp.responseText;
	eval(responseText);
	window.returnValue = formObject.remarks_code_1.value;
	if(formObject.remarks_code_1.value == "")
	window.returnValue = formObject.remarks.value; 
	
	window.close();
}

function validateRemarks(){
 var formObject = document.forms[0];
	if (!setTextAreaMaxLength(formObject.remarks,201)) {  
		alert (getMessage('REMARKS_CHAR_EXCEEDS_LIMIT','ST'));
		return;
	}
}
