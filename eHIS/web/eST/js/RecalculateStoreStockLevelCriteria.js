var bean_id = "";
var bean_name = "";
var xmlDom;
var xmlHttp;
var formObj="";

function reset() 
	{
	f_query_add_mod.location.reload();
	}
async function searchCodeStore( obj) {
var result		=	false ;
var message		=	"" ;
var flag		=	"" ;
var function_id = "";

	var argumentArray  = new Array();
	var dataNameArray  = new Array();
	var dataValueArray = new Array();
	var dataTypeArray  = new Array();
	dataNameArray[0]   = "language_id";
	dataValueArray[0]   = document.forms[0].p_language_id.value;
	dataTypeArray[0]    = STRING;	
	dataNameArray[1]  = "facility_id";
	dataValueArray[1]  =document.forms[0].p_facility_id.value;
	dataTypeArray[1] = STRING;
	argumentArray[0] = document.getElementById('SQL_ST_STORE_LOOKUP').value;
	argumentArray[1] = dataNameArray;
	argumentArray[2] = dataValueArray;
	argumentArray[3] = dataTypeArray;
	argumentArray[4] = "3,4";
	argumentArray[5] = obj.value;
	argumentArray[6] = CODE_LINK;
	argumentArray[7] = CODE_DESC;
	

	returnedValues = await CommonLookup( getLabel("Common.Store.label", "Common"), argumentArray );
	if((returnedValues != null) && (returnedValues != "") )  {
		var ret1=unescape(returnedValues);
	 	var arr=ret1.split(",");
		if(arr[1]==undefined) { 
		arr[0]="";
		arr[1]="";
		}
		obj.value = arr[0];
	} 
}

async function searchCodeItem( obj) {
var result		=	false ;
var message		=	"" ;
var flag		=	"" ;
var function_id = "";
	var argumentArray  = new Array();
	var dataNameArray  = new Array();
	var dataValueArray = new Array();
	var dataTypeArray  = new Array();
	dataNameArray[0]   = "language_id";
	dataValueArray[0]   = document.forms[0].p_language_id.value;
	dataTypeArray[0]    = STRING;
	argumentArray[0] = document.getElementById('SQL_ST_ITEM_LOOKUP').value;
	argumentArray[1] = dataNameArray;
	argumentArray[2] = dataValueArray;
	argumentArray[3] = dataTypeArray;
	argumentArray[4] = "2,3";
	argumentArray[5] = obj.value;
	argumentArray[6] = CODE_LINK;
	argumentArray[7] = CODE_DESC;

	returnedValues = await CommonLookup(getLabel("Common.item.label","Common"), argumentArray );
	if((returnedValues != null) && (returnedValues != "") )  {
		var ret1=unescape(returnedValues);
	 	var arr=ret1.split(",");
		if(arr[1]==undefined) { 
		arr[0]="";
		arr[1]="";
		}
		obj.value = arr[0];
	} 
}


async function searchCodeItemClass( obj) {
var result		=	false ;
var message		=	"" ;
var flag		=	"" ;
var function_id = "";
	var argumentArray  = new Array();
	var dataNameArray  = new Array();
	var dataValueArray = new Array();
	var dataTypeArray  = new Array();
	argumentArray[0] = document.getElementById('SQL_ST_ITEM_CLASS_LOOKUP_LANG').value+"'"+document.forms[0].p_language_id.value+"'";
	argumentArray[1] = dataNameArray;
	argumentArray[2] = dataValueArray;
	argumentArray[3] = dataTypeArray;
	argumentArray[4] = "1,2";
	argumentArray[5] = obj.value;
	argumentArray[6] = CODE_LINK;
	argumentArray[7] = CODE_DESC;

	returnedValues = await CommonLookup( getLabel("Common.ItemClass.label","Common"), argumentArray );
	if((returnedValues != null) && (returnedValues != "") )  {
		var ret1=unescape(returnedValues);
	 	var arr=ret1.split(",");
		if(arr[1]==undefined) { 
		arr[0]="";
		arr[1]="";
		}
		obj.value = arr[0];
	} 
}



function run()
{
	var formObj=  f_query_add_mod.document.RecalculateStoreStockLevelCriteria;
	var resultText	= formApply(formObj,ST_CONTROLLER);
	var errorPage	=	"../../eCommon/jsp/error.jsp";
    
//    var obj1 = f_query_add_mod.document.RecalculateStoreStockLevelCriteria.p_process_option[0].status;
    
	//if (obj1 == true)
//	{
	
	var arrayObject = new Array(formObj.p_cons_per);
	var names = new Array(getLabel("eST.ConsumptionPeriod.label","ST"));
//	var blankObject = getSTBlankField(arrayObject, names, messageFrame);
    var blankObject = checkSTFields(arrayObject, names, messageFrame);	
	if (blankObject != true) {}
	//	blankObject.focus();	
	else
		if (isSTValidFromToField(formObj.p_fm_item_code, formObj.p_to_item_code, STRING, getLabel("Common.ItemCode.label","Common"), messageFrame)) 
		if (isSTValidFromToField(formObj.p_fm_item_class, formObj.p_to_item_class, STRING, getLabel("Common.ItemClass.label","Common"), messageFrame)) 
		formObj.submit();		
//	return;
		//commontoolbarFrame.document.location.href="../../eCommon/jsp/commonToolbar.jsp";
	//alert("after submit");
//	}
	
//	just.to.stop();
//	setTimeout(1000,"messageFrame.location.href='../../eCommon/jsp/error.jsp';")
	/*else 
	{
		alert("In this else part U have to write update  and call the report");
 	}*/

}

/*function run()
{       
	var formObj=  f_query_add_mod.document.formItemLabelCriteria;
    var obj1 = f_query_add_mod.document.formItemLabelCriteria.radio2[0].status;

	if (obj1 == true)
	{
	
	var arrayObject = new Array(formObj.p_doc_type_code,formObj.p_doc_no);
	var names = new Array("Doc Type","Doc No");
	
	var blankObject = getBlankField(arrayObject, names, messageFrame);
	if (blankObject != null) 
		blankObject.focus();	
	else
		if (isValidFromToField(formObj.p_fm_item_code, formObj.p_to_item_code, STRING, "Item Code", messageFrame)) 
		formObj.submit();		
	}
  else
	{
	  var arrayObject = new Array(formObj.P_no_labels);
	  var names = new Array("No. of Copies");
	
	var blankObject = getBlankField(arrayObject, names, messageFrame);
	if (blankObject != null) 
		blankObject.focus();
	else
		if (isValidFromToField(formObj.p_fm_item_code, formObj.p_to_item_code, STRING, "Item Code", messageFrame)) 
		formObj.submit();		
	}

}

*/



