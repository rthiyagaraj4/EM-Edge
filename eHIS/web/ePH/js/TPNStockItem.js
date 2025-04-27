  var result = true ;
var message = "" ;
var flag = true ;

function create(){
f_query_add_mod.location.href="../../ePH/jsp/TPNStockItemModify.jsp?mode="+MODE_INSERT;
	
}
function query() {
		f_query_add_mod.location.href="../../ePH/jsp/TPNStockItemQueryCriteria.jsp?mode="+MODE_MODIFY;
}

 
function assignResult(_result,_message,_flag)
{
	result=_result;
	message=_message;
	flag=_flag;
    
}


//added
function apply() {
	var frmobj = f_query_add_mod.document.forms[0] ;
		var mode = f_query_add_mod.document.TPNStockItemModifyQueryForm.mode.value;
if( mode == MODE_INSERT || mode == MODE_MODIFY ) 
	{
	var fields = new Array ( frmobj.item_code  );
	var names  = new Array (getLabel("Common.ItemCode.label","Common"));
	var errorPage	=	"../../eCommon/jsp/MstCodeError.jsp";
	var blankObj	=	null;
	blankObject = getBlankField( fields, names, messageFrame,errorPage);
	if(blankObject==null) {
		eval(formApply(frmobj, PH_CONTROLLER) ) ;
		messageFrame.location.href = errorPage+"?err_num="+message;
		if(result) {
			onSuccess(frmobj);
		}
	}
	else{
		blankObject.focus();
	}
	}
}
//ended

	function onSuccess(frmobj)
	{			var frmobj = f_query_add_mod.document.forms[0] ;
	f_query_add_mod.location.href="../../ePH/jsp/TPNStockItemModify.jsp?mode="+MODE_INSERT;
	//messageFrame.location.href = "../../eCommon/jsp/error.jsp";

}

/*function reset() {
	var url = f_query_add_mod.location.href;
	url = url.toLowerCase();
	 if ( (url.indexOf("tpnstockitemmodify")!=-1) ) {
		if(f_query_add_mod.document.TPNStockItemModifyQueryForm.mode.value == MODE_MODIFY){
			formObj	=	f_query_add_mod.document.TPNStockItemModifyQueryForm;
			var arrPKFieldNames		=	new Array();
			arrPKFieldNames[0]		=	"item_code";
			resetDuplicateClass(formObj,arrPKFieldNames,'1');
			f_query_add_mod.document.TPNStockItemModifyQueryForm.reset();
		}
		else {
			f_query_add_mod.document.TPNStockItemModifyQueryForm.reset();
		}
	}
}*/
function reset() {
		var mode = f_query_add_mod.document.TPNStockItemModifyQueryForm.mode.value;
		if(mode == 1){
			f_query_add_mod.location.href="../../ePH/jsp/TPNStockItemModify.jsp?mode="+MODE_INSERT;
		}else if (mode == 2){
			f_query_add_mod.document.TPNStockItemModifyQueryForm.reset();
		}
}

function Modify(item_code) 
{
document.location.href="../../ePH/jsp/TPNStockItemModify.jsp?item_code="+item_code+"&mode="+MODE_MODIFY;

}

/* function lockKey() {
        if(event.keyCode == 93)
            alert(getMessage("WELCOME","Common"));
    } Commented on dt:14/9/09*/

function checkunchecktpn()
{
	if(document.TPNStockItemModifyQueryForm.tpn_item_yn.checked==true)
	{
	document.TPNStockItemModifyQueryForm.tpn_item_yn.value="Y";
	}
	else
	{
		document.TPNStockItemModifyQueryForm.tpn_item_yn.value="N";
	}
}

async function searchItem(obj) {
parent.messageFrame.location.href ="../../eCommon/jsp/MstCodeError.jsp";
	var argumentArray  = new Array();
	var dataNameArray  = new Array();
	var dataValueArray = new Array();
	var dataTypeArray  = new Array();
	var formObj=document.TPNStockItemModifyQueryForm;
	//var sql1= "SELECT A.ITEM_CODE CODE, B.SHORT_DESC DESCRIPTION FROM ST_ITEM A, MM_ITEM_LANG_VW B WHERE  b.language_id ='"+id+"'AND A.DRUG_ITEM_YN='Y' AND A.ITEM_CODE=B.ITEM_CODE AND B.EFF_STATUS='E' AND A.ITEM_CODE LIKE UPPER(?) AND B.SHORT_DESC LIKE (?)  ORDER BY 2"; 
   	
	argumentArray[0]   = formObj.sql_ph_drug_select99.value+"'"+formObj.language_id.value+"'";
	
	//argumentArray[0]   = sql1;
	argumentArray[1]   = dataNameArray ;
	argumentArray[2]   = dataValueArray ;
	argumentArray[3]   = dataTypeArray ;
	argumentArray[4]   = "1,2";
	argumentArray[5]   = document.TPNStockItemModifyQueryForm.item_code.value ;
	argumentArray[6]   = DESC_LINK ;
	argumentArray[7]   = DESC_CODE ;
	bean_id			   = formObj.bean_id.value;
	bean_name		   = formObj.bean_name.value;

	var retVal = await CommonLookup(getLabel("Common.ItemName.label","Common"), argumentArray);
	if(retVal != null && retVal != "") {
//	document.getElementById("td_short_name").innerHTML=retVal[1];
           var ret1=unescape(retVal);
		 	var arr=ret1.split(",");
		 	if(arr[1]==undefined) 
	 		{
		 		arr[0]="";	
		 		arr[1]="";	
	 		}
			if(retVal==null || retVal=="")
				document.TPNStockItemModifyQueryForm.item_code.value=arr[0];
			else
	document.TPNStockItemModifyQueryForm.item_code.value=arr[0];
	document.TPNStockItemModifyQueryForm.item_code.disabled=true;
	
		var xmlStr ="<root><SEARCH ";
		xmlStr +=" /></root>";
		var temp_jsp="../../ePH/jsp/TPNStockItemValidate.jsp?func_mode=item_uom_search&bean_id="+bean_id+"&bean_name="+bean_name+"&item_code="+arr[0]+"&mode="+MODE_INSERT;
		var xmlDoc = "" ;
		var xmlHttp = new XMLHttpRequest() ;
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open("POST",temp_jsp,false);
		xmlHttp.send(xmlDoc);
	//	alert(xmlHttp.responseText);
		responseText=xmlHttp.responseText ;
		//alert(responseText);
		eval(responseText);

	}
	else
	{
		//window.close();
		const dialogTag = parent.parent.document.getElementById("dialog_tag");    
		dialogTag.close();   
	}
}
