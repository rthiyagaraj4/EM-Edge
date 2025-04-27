
function reset() {
	f_query_add_mod.location.reload();
	//ResultFrame.location.href = "../../eCommon/html/blank.html";
}

function query() {
	f_query_add_mod.location.href = "../../ePO/jsp/PurchaseOrderStatusQueryCriteria.jsp?function_id=" + function_id;
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

function callItemDetails(docNo,item){

	var retVal;
    var dialogHeight= "25" ;
	var dialogTop = "30" ;
	var dialogWidth	= "70" ;
    var center  = "1" ;
    var status  = "no";
    var scroll  = "no";
	var features    = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop +"; scroll :"+ scroll;
    var arguments   = "" ;
	
	var url="../../ePO/jsp/PurchaseOrderStatusItemDetails.jsp?docNo="+docNo+"&purchaseItem="+item;	 

	retVal=window.showModalDialog(url,arguments,features); 
}
//Added By Sakti Sankar against Inc#30079

function callItemSchDetails(docNo,item,item_desc,uom_desc){

	var retVal;
    var dialogHeight= "25" ;
	var dialogTop = "530" ;
	var dialogLeft = "320" ;
	var dialogWidth	= "65" ;
    var center  = "0" ;
    var status  = "no";
    var scroll  = "no";
	var features    = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop +"; scroll :"+ scroll+"; dialogLeft :"+ dialogLeft;
    var arguments   = "" ;

var url="../../ePO/jsp/PurchaseOrderStatusScheduleItemDetails.jsp?docNo="+docNo+"&purchaseItem="+item+"&Item_desc="+item_desc+"&uom_desc="+uom_desc;	 

	retVal=window.showModalDialog(url,arguments,features); 
}



function submitQuery1(){
//alert("submit");
	
	var purchaseUnit = document.getElementById("purchaseUnit").value;
	if(purchaseUnit != "")
	{
		//var reqStore = document.getElementById("reqByStore").value;
		var reqStore = "";
		var supplier = document.getElementById("supplierCode").value;
		var purchaseType = document.getElementById("purchaseType").value;
		var DocNo= document.getElementById("docNo").value;
		var item_fld_val = document.getElementById("item_desc").value;
		var item = document.getElementById("item_code").value;
		var orderStatus = document.getElementById("orderStatus").value;
		var docDtFrm = document.getElementById("docDtFrom").value;
		var docDtTo = document.getElementById("docDtTo").value;
		
		if(item_fld_val==""){
			item ="";
		}
		
		var paramList = "?reqByStore="+reqStore+"&purchaseUnit="+purchaseUnit+"&supplierCode="+supplier+"&purchaseType="+encodeURIComponent(purchaseType)+"&docNo="+DocNo+"&purchaseItem="+item+"&orderStatus="+orderStatus+"&docDtFrom="+encodeURIComponent(docDtFrm)+"&docDtTo="+encodeURIComponent(docDtTo);
		
		var urlRelocate = "PurchaseOrderStatusQueryResult.jsp";
		
		//alert("url :  "+urlRelocate+paramList);
		parent.ResultFrame.location.href = urlRelocate+paramList;
	}
	else
	{
		parent.ResultFrame.location.href="../../eCommon/html/blank.html";
		alert(getPOMessage("PURCHASE_UNIT_BLANK"));
		//parent.parent.messageFrame.location.href = "../../eCommon/jsp/error.jsp?error_value=0&err_num=" + getMessage("PURCHASE_UNIT_BLANK","PO");
	}

}


function getpurchaseItem(objCode){

	
	if(objCode.name=='purchaseItem')
	{
		purchaseItemId(objCode)
	}

	if(objCode.name == "purchaseItem_search")
	{
		
		if(document.po_order_status_qry_form.flag.value=='false')
			return false
		else

			callFunctionButton()
	}

}


function purchaseItemId(objCode)
{
	var purchaseItem2 = objCode.value
	if(purchaseItem2 == '')
	{
		document.po_order_status_qry_form.flag.value='true'
		return false
	}
	else
	{
		parent.messageFrame.location.href = '../../eCommon/jsp/MstCodeError.jsp';

        var HTMLVal="<html><script src='../../eCommon/js/ValidateControl.js' language='javascript'></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script><body onKeyDown='lockKey()'><form name='tempform1' id='tempform1' method='post' action='../../ePO/jsp/PurchaseOrderStatusPopulateItem.jsp'><input type='hidden' name='purchaseItem2' id='purchaseItem2' value="+purchaseItem2+"></form></body></html>";

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
	
	var title = getLabel("ePO.purchaseItem.label","PO");
	var target			= document.po_order_status_qry_form.purchaseItem;
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
		document.po_order_status_qry_form.purchaseItem.value = retArray[1];
		document.po_order_status_qry_form.purchaseItem_id.value = retArray[0];
		
	} 
	document.po_order_status_qry_form.flag.value='true'
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
		return false;
	
	}


}


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
	
		 
	var url="../../ePO/jsp/PurchaseOrderStatusAuditInfo.jsp?documentNo="+docNo;
	retVal=window.showModalDialog(url,arguments,features); 

}

function searchCodeItem(obj) {

	var formObject = document.po_order_status_qry_form;

	
	
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
//Added By Sakti Sankar against Inc#30079
function showRemarks(i,remarks) {
		
	var rem = "";
	rem = window.showModalDialog("../../ePO/jsp/PurchaseOrderStatusScheduleItemDetailsRemarks.jsp?remarks=" + remarks, "", "dialogHeight:10; dialogWidth:30; center:0; status: no; dialogLeft :520; dialogTop :330;");
	
	}
 

