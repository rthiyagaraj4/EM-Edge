
function reset() {
	f_query_add_mod.location.reload();
	//ResultFrame.location.href = "../../eCommon/html/blank.html";
	
}

function query() {
	f_query_add_mod.location.href = "../../ePO/jsp/PurchaseRequestStatusFrame.jsp?function_id=" + function_id;
	//ResultFrame.location.href = "../../eCommon/html/blank.html";
}


function specialCharacterCheck(fieldObj)
{
	var fieldValue = fieldObj.value;
	
	if(fieldValue != "" && fieldValue.search(/[^a-zA-Z0-9.,\/ ]/g) != -1){
	//	alert("please enter alpha numeric characters only");
		alert(getMessage("PLS_ENTER_ALPHA_NUMERIC_CHAR","PO")); 
		fieldObj.focus();
		return false;
	
	}
	else
	return true;
		
		
}


function checkDateRange(obj,from){
	var fromDate = eval("document."+from+".docDtFrom");
	var toDate = eval("document."+from+".docDtTo");
	var localeName = eval("document."+from+".localeName");
		
	
	if(validDateObj(obj,"DMY",localeName)){
		
		if(!isAfter(toDate.value,fromDate.value,"DMY",localeName.value)){//this function is available in eCommon/js/DateUtils.js		
			alert(getMessage("TO_DT_GR_EQ_FM_DT","SM")); // this message available in messages.js of ecommon/js
			obj.focus();
			return false;
		}
	}else{
		//document.po_req_status_qry_form.docDtTo.value=document.po_req_status_qry_form.temp_curr_week_date.value;
		return false;
	}


}

function submitRequestQuery(){

var purchaseUnit = document.getElementById("purchaseUnit").value;
	if(purchaseUnit != "")
	{
		var reqStore = document.getElementById("reqByStore").value;
		var requestType = document.getElementById("requestType").value;
		var DocNo= document.getElementById("docNo").value;
	//	var item_fld_val = document.getElementById("requestItem").value;
		var item_fld_val = document.getElementById("item_desc").value;
	//	var item = document.getElementById("requestItem_id").value;
		var item = document.getElementById("item_code").value;
		var requestStatus = document.getElementById("requestStatus").value;
		var docDtFrm = document.getElementById("docDtFrom").value;
		var docDtTo = document.getElementById("docDtTo").value;
		
		
		if(item_fld_val==""){
			item ="";
		}
		
		var paramList = "?reqByStore="+reqStore+"&purchaseUnit="+purchaseUnit+"&requestType="+encodeURIComponent(requestType)+"&docNo="+DocNo+"&requestStatus="+requestStatus+"&docDtFrom="+encodeURIComponent(docDtFrm)+"&docDtTo="+encodeURIComponent(docDtTo)+"&requestItem="+item;
		
		var urlRelocate = "PurchaseRequestStatusQueryResult.jsp";
		
		//alert("url :  "+urlRelocate+paramList);
		parent.ResultFrame.location.href = urlRelocate+paramList;
		//parent.parent.messageFrame.location.href = "../../eCommon/jsp/error.jsp?error_value=0&err_num=" + "";
	}
	else
	{
	//	parent.parent.messageFrame.location.href = "../../eCommon/jsp/error.jsp?error_value=0&err_num=" + "APP-000001 Purchase Unit Cannot be blank";
		//parent.parent.messageFrame.location.href = "../../eCommon/jsp/error.jsp?error_value=0&err_num=" + getMessage("PURCHASE_UNIT_BLANK","PO");
		parent.ResultFrame.location.href="../../eCommon/html/blank.html";
		alert(getMessage("PURCHASE_UNIT_BLANK","PO"));
		
	}


}


function callItemDetails(docNo,item){

	var retVal;
    var dialogHeight= "25" ;
	var dialogTop = "30" ;
	var dialogWidth	= "60" ;
    var center  = "1" ;
    var status  = "no";
    var scroll  = "no";
	var features    = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop +"; scroll :"+ scroll;
    var arguments   = "" ;
	
	//var url="../../ePO/jsp/PurchaseRequestStatusItemDetailsFrameSet.jsp?docNo="+docNo+"&purchaseItem="+item;	 
	var url="../../ePO/jsp/PurchaseRequestStatusItemDetails.jsp?docNo="+docNo+"&purchaseItem="+item;
	

	retVal=window.showModalDialog(url,arguments,features); 
}


/*function getrequestItem(objCode){

	
	if(objCode.name=='requestItem')
	{
		requestItemId(objCode);
	}

	if(objCode.name == "requestItem_search")
	{
		
		if(document.po_req_status_qry_form.flag.value=='false'){
			
			return false;
		}
		else{
			
			callFunctionButton();
			}
	}

}

function requestItemId(objCode)
{
	var requestItem2 = objCode.value;
	if(requestItem2 == '')
	{
		document.po_req_status_qry_form.flag.value='true';
		return false;
	}
	else
	{
		parent.messageFrame.location.href = '../../eCommon/jsp/MstCodeError.jsp';

        var HTMLVal="<html><script src='../../eCommon/js/ValidateControl.js' language='javascript'></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script><body onKeyDown='lockKey()'><form name='tempform1' id='tempform1' method='post' action='../../ePO/jsp/PurchaseRequestStatusPopulateItem.jsp'><input type='hidden' name='requestItem2' id='requestItem2' value="+requestItem2+"></form></body></html>";

        parent.frames[3].document.write(HTMLVal);
	    parent.frames[3].document.tempform1.submit(); 

    }
}

function callFunction(sql,title,target)
{
	
	var serviceVal   ="";
	var search_desc	= "";
	var argArray = new Array();
	var namesArray = new Array();
	var valuesArray = new Array();
	var datatypesArray = new Array();
	argArray[0] = sql;
	argArray[1] = namesArray;
	argArray[2] = valuesArray;
	argArray[3] = datatypesArray;
	argArray[4] = "1,2";
	argArray[5] = target.value;
	argArray[6] = DESC_LINK;
	argArray[7] = CODE_DESC;
	retArray = CommonLookup(title, argArray );
	return retArray;
 }
 
 function  callFunctionButton()
{

	var sql = "SELECT ITEM_CODE code, LONG_DESC description FROM MM_ITEM_LANG_VW where language_id = 'en' and upper(ITEM_CODE) like upper(?) and  upper(SHORT_DESC) like upper(?) order by 2";
	
	var title = getLabel("ePO.requestItem.label","PO");
	var target			= document.po_req_status_qry_form.requestItem;
	target.value='';
	
	
	var serviceVal   ="";
	var search_desc	= "";
	var argArray = new Array();
	var namesArray = new Array();
	var valuesArray = new Array();
	var datatypesArray = new Array();
	argArray[0] = sql;
	argArray[1] = namesArray;
	argArray[2] = valuesArray;
	argArray[3] = datatypesArray;
	argArray[4] = "1,2";
	argArray[5] = target.value;
	argArray[6] = DESC_LINK;
	argArray[7] = CODE_DESC;
	retArray = CommonLookup( title, argArray );

	if(retArray != null && retArray !="")	
	{
		document.po_req_status_qry_form.requestItem.value = retArray[1];
		document.po_req_status_qry_form.requestItem_id.value = retArray[0];
		
	} 
	document.po_req_status_qry_form.flag.value='true'
}
*/

function auditInfoSubmit(docNo){

	var retVal;
    var dialogHeight= "10" ;
	var dialogTop = "30" ;
	var dialogWidth	= "30" ;
    var center  = "1" ;
    var status  = "no";
    var scroll  = "no";
	var features    = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop +"; scroll :"+ scroll;
    var arguments   = "" ;
	
		 
	var url="../../ePO/jsp/PurchaseRequestStatusAuditInfo.jsp?documentNo="+docNo;
	retVal=window.showModalDialog(url,arguments,features); 

}

function Modify(obj){
// alert("modify1");
	
}
 
 
function searchCodeItem(obj) {

	var formObject = document.po_req_status_qry_form;

	
	
	var result = false;
	var message = "";
	var flag = "";
	var function_id = "";
	var argumentArray = new Array();
	var dataNameArray = new Array();
	var dataValueArray = new Array();
	var dataTypeArray = new Array();
	dataNameArray[0] = "language_id";
	dataValueArray[0] = document.forms[0].p_language_id.value;
	dataTypeArray[0] = STRING;
	argumentArray[0] = document.getElementById("SQL_ST_ITEM_LOOKUP").value;
	argumentArray[1] = dataNameArray;
	argumentArray[2] = dataValueArray;
	argumentArray[3] = dataTypeArray;
	argumentArray[4] = "2,3";
	argumentArray[5] = obj.value;
	argumentArray[6] = CODE_LINK;
	argumentArray[7] = CODE_DESC;
	returnedValues = CommonLookup(getLabel("Common.item.label", "Common"), argumentArray);
	//alert(returnedValues);
	if ((returnedValues != null) && (returnedValues != "")) {
		obj.value = returnedValues[0];
		formObject.item_code.value = returnedValues[0];
		formObject.item_desc.value = returnedValues[1];
	}
		
}
 

