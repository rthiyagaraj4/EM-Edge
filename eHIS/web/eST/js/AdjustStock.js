var itemlastcost_1;  
var storecost_1;
var toolBarString = "";
function create(){
	f_query_add_mod.location.href="../../eST/jsp/AdjustStockFrame.jsp?mode="+MODE_INSERT+"&function_id="+function_id; 
}

function query() {
		f_query_add_mod.location.href="../../eST/jsp/AdjustStockQueryFrame.jsp?function_id="+function_id;
}

function reset() {  
	f_query_add_mod.location.reload();
}


async function deleterecord()
{
	if(  f_query_add_mod.frameAdjustStockList==undefined){
		messageFrame.location.href ="../../eCommon/jsp/error.jsp?err_num=";
		return;
	}
		var formObj = f_query_add_mod.frameAdjustStockList.frameAdjustStockListHeader.document.formAdjustStockListHeader;
	
	
	if(formObj.mode.value==MODE_MODIFY){
		f_query_add_mod.frameAdjustStockDetail.document.formAdjustStockDetail.mode.value = MODE_DELETE;
	
	if(f_query_add_mod.frameAdjustStockHeader.formAdjustStockHeader.trn_type.value=="ADJ" && f_query_add_mod.frameAdjustStockHeader.formAdjustStockHeader.adj_delete_yn.value=="N"){
		messageFrame.location.href = "../../eCommon/jsp/error.jsp?error_value=0&err_num="+getMessage("NO_DELETE_ACCESS_FOR_USER", "ST");
		formObj.mode.value = MODE_MODIFY;
		return false;
	}

		var result = await confirmDelete();
	if(result=="")
		{
		messageFrame.location.href = "../../eCommon/jsp/error.jsp?error_value=0&err_num=";
		return false;
		}
	if(result==YES){
			apply();
		}else {
			messageFrame.location.href = "../../eCommon/jsp/error.jsp?error_value=0&err_num="+getMessage("OPER_CANCELLED","ST");
			f_query_add_mod.frameAdjustStockDetail.document.formAdjustStockDetail.mode.value = MODE_MODIFY;

		}
	}else {
		messageFrame.location.href = "../../eCommon/jsp/error.jsp?error_value=0&err_num=";
	}
}

function onSuccess() {
	f_query_add_mod.location.href="../../eCommon/html/blank.html";
}


 function callItemSearchScreen () 
{
	var search_string=parent.frameAdjustStockListHeader.formAdjustStockListHeader.item_desc.value;
	var store_code=parent.parent.frameAdjustStockHeader.document.formAdjustStockHeader.store_code.value;
	var category ="A";
	var sole_source ="A";
	var ps_item ="A";
	var mfg_item ="A";
	var expiry ="A";
	var consignment ="A";

	var item_class =parent.parent.frameAdjustStockHeader.document.formAdjustStockHeader.item_class_code.value;
	var item_class_check=parent.parent.frameAdjustStockHeader.document.formAdjustStockHeader.item_class_check.value;

	
		
   if(item_class_check=='Y'){
	
	if((item_class=="")||(item_class=='null'))
	{
		alert(getMessage("ITEM_CLASS_CANNOT_BLANK","ST"));
	}
		
	
	if((item_class_check=='Y')&&((item_class!="")&&(item_class!='null')))
	
	{
		 sub1();
	}
  }else{
		 sub1();
	}
async function sub1(){
	var mode = "";
	var retVal= await callItemSearchWindow(search_string,store_code,category,sole_source,ps_item,mfg_item,expiry,item_class,consignment);
//	console.log(retVal);
//	var ret1=unescape(retVal);
//		 	var arr=ret1.split(",");
//	/*var ret1=unescape(retVal);
//
//	var arr=ret1.split("~");*/
//	console.log(arr);	 	
//	if(arr[1]==undefined)
// 		{
//	 		arr[0]="";	
//	 		arr[1]="";	
// 		}
	var errorPage	 = "../../eCommon/jsp/error.jsp";
	parent.parent.parent.messageFrame.location.href = "../../eCommon/jsp/error.jsp";

	if(retVal != null && retVal[0].length>0) { 
	//if(retVal && retVal[0] && retVal[0].length > 0) {
		document.formAdjustStockListHeader.item_code.value=retVal[0];
		/** @Name - Priya
			* @Date - 13/01/2010
			* @Inc# - 15496 (SRR20056-CRF-0537.2)  			
			* @Desc - 'Allow Decimal Y/N' value of the selected item is assigned to the hidden field 'dec_allowed_yn'
			* Modified by - Priya
			* @Date - 13/04/2010
			* @Inc# - 20631
			* @Desc - Moved the below four lines of code as no of decimals value is used in the preceding codes.
			*/
		document.formAdjustStockListHeader.dec_allowed_yn.value=retVal[27];
		if(document.formAdjustStockListHeader.dec_allowed_yn.value == "Y"){
			document.formAdjustStockListHeader.no_of_decimals.value=retVal[28];
		}else{
			document.formAdjustStockListHeader.no_of_decimals.value=0;
		}
		/**end**/
		var item_code = retVal[0];
		var xmlHttp = new XMLHttpRequest();
		var xmlDoc="";
		//xmlDoc.loadXML(getXMLString(null));
		var xmlString = getXMLString(null);
        var xmlDoc = new DOMParser().parseFromString(xmlString, "text/xml");
		xmlHttp.open("POST", "../../eST/jsp/AdjustStockValidate.jsp?validate=VALIDATE_ITEM_CODE"+"&item_code="+item_code+"&store_code="+store_code+"", false);
		xmlHttp.send(xmlDoc);
		responseText=xmlHttp.responseText;
		
		eval(responseText);
		
		if( !responseText ) {
			parent.parent.parent.messageFrame.location.href = errorPage;
			if(message=="PHY_INV_PROCESS_INITIATED")
				alert(getMessage(message,"ST")+"\n"+getLabel("eST.PhyInventoryID.label","ST")+":"+document.formAdjustStockListHeader.phy_inv_id.value);
			else
				alert(getMessage(message,"ST"));
			cancel_me();
			return;
		}						  

		var formObj=parent.frameAdjustStockListHeader.document.formAdjustStockListHeader;
		mode = formObj.mode.value;

		if(mode == "null"){

			mode = parent.parent.frames[1].document.forms[0].mode.value;
		}
		else
			toConvFactor();
		
		//xmlDoc.loadXML(getEnhancedXMLString(formObj));
        var xmlDoc = new DOMParser().parseFromString(getEnhancedXMLString(formObj), "text/xml");	
		xmlHttp.open("POST", "../../eST/jsp/AdjustStockValidate.jsp?item_code="+retVal[0]+"&store_code="+store_code+"&validate=FETCH_COST", false);
		xmlHttp.send(xmlDoc);
		responseText=xmlHttp.responseText;

		eval(responseText);
		document.formAdjustStockListHeader.item_code.value=retVal[0];
		
		document.formAdjustStockListHeader.item_desc.value=retVal[1];
		document.formAdjustStockListHeader.item_desc.disabled="true";
		document.formAdjustStockListHeader.item_search.disabled="true";	

		document.formAdjustStockListHeader.expiry_yn.value=retVal[2];

		document.formAdjustStockListHeader.uom.value=retVal[15];
		document.formAdjustStockListHeader.uom_code.value=retVal[13];
		
		var retuom = new String(retVal[15]);
		if(retuom.length > 40)
		parent.frameAdjustStockListHeader.document.getElementById("td_uom").innerHTML="<b>"+retuom.slice(0,8)+"<BR>"+retuom.slice(8)+"</b>";
		else
		parent.frameAdjustStockListHeader.document.getElementById("td_uom").innerHTML="<b>"+retuom+"</b>";
		document.formAdjustStockListHeader.trade_id_applicable_yn.value=retVal[17];
		document.formAdjustStockListHeader.batch_id_applicable_yn.value=retVal[18];
		
		//Added by Rabbani #Inc no:29954(Bru-HIMS-CRF-088) on 04-MAR-2013 Starts
		var disposable_yn = "N";
		document.formAdjustStockListHeader.disposable_yn.disabled = true;
		if(document.formAdjustStockListHeader.disposable_yn.checked){
		disposable_yn = "Y"; 
		document.formAdjustStockListHeader.disposable_item_yn.value = 'Y';
		/*var status =  checkstatus(document.formAdjustStockListHeader.disposable_yn);
		alert(status);
		if(!status){
		document.formAdjustStockListHeader.disposable_yn.disabled = false;
		return;
		}*/
		}else{
		disposable_yn = "N"; 
		document.formAdjustStockListHeader.disposable_item_yn.value = 'N';
		}
		//ends
		
		
		parent.frameAdjustStockListDetail.location.href="../../eST/jsp/AdjustStockListDetail.jsp?mode="+mode+"&item_desc="+escape(retVal[1])+"&item_code="+retVal[0]+"&expiry_yn="+retVal[2]+"&uom_code="+retVal[13]+"&uom="+retVal[15]+"&batch_id_applicable_yn="+retVal[18]+"&trade_id_applicable_yn="+retVal[17]+"    "+"&mode="+mode+"&disposable_yn="+disposable_yn; //29954
	}
	parent.parent.parent.messageFrame.location=errorPage;
	parent.parent.parent.f_query_add_mod.frameAdjustStockHeader.formAdjustStockHeader.store_code_disabled.value = "disabled";
	parent.frameAdjustStockListHeader.formAdjustStockListHeader.adj_item_qty.focus();
	}
}


function populateUnitCost(item_unit_cost,available_stock,mode) {
if (mode != 2)
{
	
	var quantity=document.formAdjustStockListHeader.adj_item_qty.value;
	var value=document.formAdjustStockListHeader.item_cost_value.value;
	
	/** @Name - Priya
	* @Date - 20/05/2010
	* @Inc# -  
	* @Desc - To round up item_unit_cost with no_of_decimals_for_cost.
	*/
	var no_of_decimals_for_cost = eval(document.formAdjustStockListHeader.no_of_decimals_for_cost.value);
	if(quantity != "" && value != "") {
		
	item_unit_cost = value / quantity;
	}
	toConvFactor();
		
	var x=setNumber(eval(item_unit_cost)*eval(document.formAdjustStockListHeader.tmp_conv.value),no_of_decimals_for_cost);
	document.getElementById("td_cost").innerHTML="<b>"+x+"</b>";
	document.formAdjustStockListHeader.item_unit_cost.value = x;
	document.formAdjustStockListHeader.item_unit_cost_org.value = item_unit_cost;//Added against inc#50616 to set base unit cost 
	
	
	/** @Name - Priya
	* @Date - 10/03/2010
	* @Inc# - 19909 
	* @Desc - To display ?Available Stock? in decimals, when User has selected the item by using item lookup , if the item is having quantity in decimals.
	*/
	var var_no_of_decimals = eval(document.formAdjustStockListHeader.no_of_decimals.value);
	var var_available_stock = eval(available_stock/(document.formAdjustStockListHeader.tmp_conv.value));
	//document.formAdjustStockListHeader.document.getElementById("td_av_qty").innerHTML ="<b>"+var_available_stock.toFixed(var_no_of_decimals)+"</b>";
	document.getElementById("td_av_qty").innerHTML ="<b>"+var_available_stock.toFixed(var_no_of_decimals)+"</b>";
	/**END**/
	//document.formAdjustStockListHeader.document.getElementById("avl_qty").value = eval(available_stock/(document.formAdjustStockListHeader.tmp_conv.value));
	document.getElementById("avl_qty").value = eval(available_stock/(document.formAdjustStockListHeader.tmp_conv.value));
}
else
{

	var quantity=parent.frameAdjustStockList.frameAdjustStockListHeader.document.formAdjustStockListHeader.adj_item_qty.value;
	var value=parent.frameAdjustStockList.frameAdjustStockListHeader.document.formAdjustStockListHeader.item_cost_value.value;
	parent.frameAdjustStockList.frameAdjustStockListHeader.document.formAdjustStockListHeader.item_unit_cost_org.value = item_unit_cost;//Added against inc#50616 to set base unit cost
	/** @Name - Priya
	* @Date - 20/05/2010
	* @Inc# -  
	* @Desc - To round up item_unit_cost with no_of_decimals_for_cost.
	*/
	var no_of_decimals_for_cost = eval(parent.frameAdjustStockList.frameAdjustStockListHeader.document.formAdjustStockListHeader.no_of_decimals_for_cost.value);
	if(quantity != "" && value != "") {
	item_unit_cost = value / quantity;
	}
	var x=setNumber(item_unit_cost,no_of_decimals_for_cost);
	parent.frameAdjustStockList.frameAdjustStockListHeader.document.getElementById("td_cost").innerHTML="<b>"+x+"</b>";
	parent.frameAdjustStockList.frameAdjustStockListHeader.document.formAdjustStockListHeader.item_unit_cost.value = x;
	parent.frameAdjustStockList.frameAdjustStockListHeader.document.getElementById("td_av_qty").innerHTML = "<b>"+available_stock+"</b>";
	parent.frameAdjustStockList.frameAdjustStockListHeader.document.getElementById("avl_qty").value = +available_stock;
}

}

function CheckQuantity() {
	if(document.formAdjustStockListHeader.adj_item_qty.value!=null)
		if(document.formAdjustStockListHeader.adj_item_qty.value==0)
			alert(getMessage("CANNOT_BE_ZERO","Common"));
	isValidDouble(document.formAdjustStockListHeader.adj_item_qty);
	ComputeCost();
}

function CheckValue() {
	// alert ("CheckValue");
	if(document.formAdjustStockListHeader.item_cost_value.value!=null)
		if(document.formAdjustStockListHeader.item_cost_value.value==0)
			alert(getMessage("CANNOT_BE_ZERO","Common"));
		if(isValidDouble(document.formAdjustStockListHeader.quantity));
			ComputeCost();
}

function addToList(obj) {

	var locale=formAdjustStockListDetail.locale.value;
	
	var operation=obj;

	var formObj=parent.frameAdjustStockListHeader.document.formAdjustStockListHeader;
	var formObj1=  parent.parent.frameAdjustStockList.frameAdjustStockListDetail.document.formAdjustStockListDetail;
	

	var proceed=false;
	var messageFrame = parent.parent.messageFrame; 
	var errorPage	 = "../../eCommon/jsp/error.jsp"
	var remarks=getLabel("Common.remarks.label","Common");
	if(! SPCheckMaxLen(remarks,formObj.remarks,200)) {
		return;
	}
   
    setRemarks1();

    if(formObj.remarks.value=="")
	{
      alert(getMessage("ADJ_REMARKS_NOT_BLANK","ST"));
      formObj.remarks.value = '';
      formObj.remarks.focus() ;
	  return ;
	}


	var total_qty	=	0;
	var quantity=parent.frameAdjustStockListHeader.document.forms[0].tot_adj_qty.value;

	var no_of_batches_entered = 0;
	var batch_arr = new Array();
	var batch_value = 0;
	for (var b = 0; b < 10; b++) {
		var q_batch = parent.frameAdjustStockListDetail.document.formAdjustStockListDetail.elements["item_qty_" + b].value;
		if (q_batch != "") {
			var ex_date = parent.frameAdjustStockListDetail.document.formAdjustStockListDetail.elements["expiry_date_or_receipt_date_" + b].value;
			   var b_id = parent.frameAdjustStockListDetail.document.formAdjustStockListDetail.elements["batch_id_" + b].value;
			 var t_name = parent.frameAdjustStockListDetail.document.formAdjustStockListDetail.elements["trade_id_" + b].value;
			var bin_loc = parent.frameAdjustStockListDetail.document.formAdjustStockListDetail.elements["bin_location_code_" + b].value;
			var rec_1 = ex_date + trimString(b_id) + t_name + bin_loc;
			batch_arr[batch_value] = rec_1;
			batch_value++;
		}
	}
	for (var c = 0; c < batch_arr.length; c++) {
		var check_arr = batch_arr[c];
		for (var f = c + 1; f < batch_arr.length; f++) {
			if (check_arr == batch_arr[f]) {
				parent.parent.parent.frames[2].location.href = errorPage + "?err_num=" + getMessage("BATCH_DTL_ALREADY_EXIST", "ST");
				return;
			}
		}
	}

	for (var i=0;i<10;i++ ) {
		if(parent.frameAdjustStockListDetail.document.formAdjustStockListDetail.elements["item_qty_"+i].value!="") {
			/**
			* @Name - Priya
			* @Date - 19/01/2010
			* @Inc# - 15496 (SRR20056-CRF-0537.2)
			* @Desc - parseFloat is changed into eval as item_qty_ is having double values 
			*/
			item_qty = parent.frameAdjustStockListDetail.document.formAdjustStockListDetail.elements["item_qty_"+i].value;
			if (item_qty == "") {
					item_qty = 0;
				}
			total_qty += parseFloat(item_qty);
			/**END**/
			if(parent.frameAdjustStockListDetail.document.formAdjustStockListDetail.elements["expiry_date_or_receipt_date_"+i].value=="") {
				alert(getMessage("DATE_NOT_BLANK","ST"));
				parent.frameAdjustStockListDetail.document.formAdjustStockListDetail.elements["expiry_date_or_receipt_date_"+i].value = '';
				parent.frameAdjustStockListDetail.document.formAdjustStockListDetail.elements["expiry_date_or_receipt_date_"+i].focus();
				proceed=false;
				
			}
			else if(parent.frameAdjustStockListDetail.document.formAdjustStockListDetail.elements["batch_id_"+i].value=="") {
				alert(getMessage("BATCH_ID_NOT_BLANK","ST"));			
				parent.frameAdjustStockListDetail.document.formAdjustStockListDetail.elements["batch_id_"+i].value = '';
				parent.frameAdjustStockListDetail.document.formAdjustStockListDetail.elements["batch_id_"+i].focus();
				proceed=false;
			}
			else if(parent.frameAdjustStockListDetail.document.formAdjustStockListDetail.elements["trade_id_"+i].value=="") {
				alert(getMessage("TRADE_ID_NOT_BLANK","ST"));					
				proceed=false;
				parent.frameAdjustStockListDetail.document.formAdjustStockListDetail.elements["trade_id_"+i].value = '';
				parent.frameAdjustStockListDetail.document.formAdjustStockListDetail.elements["trade_id_"+i].focus();
			}
			else if(parent.frameAdjustStockListDetail.document.formAdjustStockListDetail.elements["bin_location_code_"+i].value=="") {
				alert(getMessage("BIN_LOCN_NOT_BLANK","ST"));							
				proceed=false;
				parent.frameAdjustStockListDetail.document.formAdjustStockListDetail.elements["bin_location_code_"+i].value = '';
				parent.frameAdjustStockListDetail.document.formAdjustStockListDetail.elements["bin_location_code_"+i].focus();
			}else {
				proceed=true;
				no_of_batches_entered = no_of_batches_entered+1;
			}
		}
	}

	if(!(no_of_batches_entered > 0)) {
		parent.parent.parent.messageFrame.location.href = errorPage+"?err_num="+ getMessage("BATCH_DETAILS_NOT_BLANK","ST");
		return;
	}
	var check_avl_qty = checkAvlQty1();
	if(!check_avl_qty){
		 return;
	}

			/**
			* @Name - Priya
			* @Date - 23/01/2010
			* @Inc# - 15496 (SRR20056-CRF-0537.2)
			* @Desc - as total_qty & quantity are having double values to Fixed is used to get the correct decimal value
			*/
	var no_of_decimals = parent.frameAdjustStockListHeader.document.forms[0].no_of_decimals.value;
	total_qty=total_qty.toFixed(no_of_decimals);

	if(proceed) {
			if(eval(total_qty)==eval(quantity)  )
			{
			//Added by Rabbani #Inc no:29954(Bru-HIMS-CRF-088) on 04-MAR-2013 
			if(formObj.disposable_item_yn.value =="N"){ 
			if (formObj.adjustment_type.value=="P") {
			if (!confirm("This is a Positive Adjustment. Do you want to continue?")) {
			parent.parent.parent.messageFrame.location.href = errorPage+"?err_num=";
			return;
		}
	}else{
		if (!confirm("This is a Negative Adjustment. Do you want to continue?")) {
			parent.parent.parent.messageFrame.location.href = errorPage+"?err_num=";
			return;
		}

	}
}		
				 var storecost=parent.frameAdjustStockListHeader.document.formAdjustStockListHeader.item_store_unit_cost_1.value;
				 
				 itemcost_1=formObj.item_unit_cost.value
				 itemlastcost=parent.frameAdjustStockListHeader.document.formAdjustStockListHeader.item_last_unit_cost.value;
				 /** @Name - Priya
					* @Date - 07/06/2010
					* @Inc# -  
					* @Desc - To round up itemlastcost with no_of_decimals_for_cost.
					*/
				 var no_of_decimals_for_cost = eval(parent.frameAdjustStockListHeader.document.formAdjustStockListHeader.no_of_decimals_for_cost.value);	
				itemlastcost=setNumber(itemlastcost,no_of_decimals_for_cost);
				if(storecost==0 && formObj.adjustment_type.value=="P")
				{  
					if(itemcost_1!=itemlastcost)
					{

					itemlastcost=itemcost_1;
					itemlastcost=setNumber(itemlastcost,no_of_decimals_for_cost)
					}
					avg_cost_changed_from=getLabel("eST.Averagecostwillbechangedfrom.label","ST");
					var to_legend=getLabel("Common.to.label","Common");
					message = avg_cost_changed_from+storecost+to_legend+itemlastcost;
					ret =confirm(message);
					
					
				}
				if(storecost==0 && formObj.adjustment_type.value=="N")
				{
				formObj.item_unit_cost.value=0.0;
				itemlastcost=0.0;								
				formObj.item_cost_value.value=0.0
				ret=true;
				}
				if(storecost!=0)
				{	ret=true;}
				
				if(ret)
				{
			//Added by sakti against inc# 51074
			if(formObj.item_cost_value.value == "") {
			formObj.item_cost_value.value = 0.0;
			}
			//Added ends
			
			var xmlHttp = new XMLHttpRequest();	
			var store_code=parent.parent.frameAdjustStockHeader.document.formAdjustStockHeader.store_code.value;
          
			var xmlDoc= new DOMParser().parseFromString(getEnhancedXMLString(formObj1), "text/xml");
			xmlHttp.open("POST", "../../eST/jsp/AdjustStockValidate.jsp?operation="+operation+"&doc_srl_no="+formObj.doc_srl_no.value+"&store_code="+store_code+"&item_code="+formObj.item_code.value+"&item_desc="+encodeURIComponent(formObj.item_desc.value,"UTF-8")+"&adj_item_qty="+formObj.adj_item_qty.value+"&item_unit_cost="+formObj.item_unit_cost.value +"&item_unit_cost_org="+formObj.item_unit_cost_org.value +"&item_cost_value="+formObj.item_cost_value.value+"&remarks="+encodeURIComponent(formObj.remarks.value,'UTF-8')+"&expiry_yn="+formObj1.expiry_yn.value+"&batch_id_applicable_yn="+formObj1.batch_id_applicable_yn.value+"&trade_id_applicable_yn="+formObj1.trade_id_applicable_yn.value+"&stock_uom_code="+ formObj.uom_code.value+"&uom="+ encodeURIComponent(formObj1.uom.value,"UTF-8")+"&line_mode="+formObj.line_mode.value+"&storecost="+storecost+"&itemlastcost="+itemlastcost+"&avl_qty="+formObj.avl_qty.value+"&min_stk_qty="+formObj.min_stk_qty.value+"&max_stk_qty="+formObj.max_stk_qty.value+"&mm_trn_qty="+quantity+"&remarks_code="+formObj.remarks_code.value+"&adjustment_type="+formObj.adjustment_type.value+"&dec_allowed_yn="+formObj.dec_allowed_yn.value+"&disposable_yn="+formObj.disposable_item_yn.value+"&next_batch_id="+formObj1.next_batch_id.value+"&validate=ADD_TO_LIST", false);//29954
			xmlHttp.send(xmlDoc);
			responseText=xmlHttp.responseText;
          
			
			eval(responseText)
				if( result ) {
					refreshDetails();
					
				}
			else {
				flag1 = flag.split("$");
				var batchid = "";
				var count = flag1.length;
				for (i=0;i<count ;i++ )
				{
					if (i==1)
					{
						batchid =flag1[i];
					}
					else
					{
						batchid = batchid +","+flag1[i];
					}
					
				}
			
				parent.parent.parent.frames[2].location.href = errorPage+"?err_num="+ getMessage(message,"ST")+":"+batchid;
			}

			}
			else
		{

			parent.frameAdjustStockListHeader.location.href="../../eST/jsp/AdjustStockListHeader.jsp";
			parent.parent.frameAdjustStockList.frameAdjustStockListDetail.location.href="../../eCommon/html/blank.html";

			}
		}
		else {
			alert(getMessage("QUANTIY_MUST_BE_EQUAL","ST"));
		}

	}
}

// To refresh detail frame on click of Add

function refreshDetails() {
	mode = parent.parent.frames[2].frames[1].document.forms[0].mode.value;
	parent.parent.frameAdjustStockDetail.location.href="../../eST/jsp/AdjustStockDetail.jsp?function_id="+parent.parent.function_id+"&mode="+mode;
	parent.frameAdjustStockListHeader.location.href="../../eST/jsp/AdjustStockListHeader.jsp?disposable_disabled=disabled";
	parent.frameAdjustStockListDetail.location.href='../../eCommon/html/blank.html';
	parent.parent.parent.messageFrame.location.href = "../../eCommon/jsp/error.jsp";
}

async function apply() {
	
	if(  f_query_add_mod.frameAdjustStockDetail==undefined){
		messageFrame.location.href ="../../eCommon/jsp/error.jsp?err_num=";
		return;
	}
	var formObj	=	f_query_add_mod.frameAdjustStockDetail.document.formAdjustStockDetail;
	totalCBox	=	parseInt(formObj.total_checkboxes.value);
	var checkBoxObj=null;
	var forDeletion="";
	var noDetailExists	=	true;
	var errorPage	=	"../../eCommon/jsp/error.jsp";

	//var formObj=  f_query_add_mod.frameAdjustStockDetail.document.formAdjustStockDetail;

	for(i=0;i<totalCBox;i++) {
		checkBoxObj=eval("formObj.checkbox"+i);
		if(checkBoxObj.checked) {
			forDeletion+=("Y,");
		}
		else {
			forDeletion+=("N,");
			noDetailExists=false;
		}
	}
	
	if (noDetailExists && !(formObj.mode.value==MODE_DELETE)) {
		messageFrame.location.href = errorPage+"?err_num="+getMessage("MIN_ONE_DETAIL_REQUIRED","Common"); 		
		return;
	}

	forDeletion=forDeletion.substring(0,forDeletion.length-1);
	formObj.records_to_delete.value=forDeletion;
	if(formObj.mode.value==MODE_DELETE) 
	{
		eval(formApply(formObj, ST_CONTROLLER));
		messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num="+ message;
		if(result) {
			onSuccess();
		}
		return;
	}
	var xmlHttp = new XMLHttpRequest();
	var xmlDoc="";
	var formHdrObj		= f_query_add_mod.frameAdjustStockHeader.document.formAdjustStockHeader;
	var arrayObject = new Array(formHdrObj.store_code, formHdrObj.doc_type_code);
	var names = new Array(getLabel("Common.StoreCode.label", "Common"),getLabel("Common.documenttype.label", "Common"));
	var blankObject = checkSTFields(arrayObject, names, messageFrame);
	if(!blankObject)
		return;
		//xmlDoc.loadXML(getEnhancedXMLString(formObj));
		//xmlDoc.loadXML(getXMLString(null));
		var xmlString = getXMLString(null);
        var xmlDoc = new DOMParser().parseFromString(getXMLString(document.formComputeStockLevelsCriteria), "text/xml");
		xmlHttp.open("POST", "../../eST/jsp/AdjustStockValidate.jsp?validate=CHECK_AUTHORIZE_ALLOWED&store_code="+formHdrObj.store_code.value, false);
		xmlHttp.send(xmlDoc);
		responseText=xmlHttp.responseText;
		eval(responseText);
		if(result){	
		
		//added for SKR-CRF-0039 By Ganga on 5th Aug 2013
		var xmlHttp = new XMLHttpRequest();
		var xmlDoc="";
		var xmlStr	="<root><SEARCH " ;
		xmlStr+=" function_type=\"2\" ";		
		xmlStr +=" /></root>" ; 
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open("POST", "../../eST/jsp/CommonSearchValidate.jsp?trn_type=" + formHdrObj.trn_type.value + "&store_code="+formHdrObj.store_code.value, false);
		xmlHttp.send(xmlDoc);
		responseText = xmlHttp.responseText;
		eval(responseText);		
		
		var confirmation = "";
		//var confirmation = confirmFinalize(); commented
		if(result){
			confirmation = await confirmFinalize();	
		}else{
			confirmation = YES;
		}
		//Added ends
		
		
		if(confirmation=="")
		{
		messageFrame.location.href = errorPage+"?err_num=";
		return false;
			}
			if(confirmation=="Yes") {
				formObj.finalized.value="Y";
			}else{
					formObj.finalized.value="N";
				}
		}
		else
		{
			formObj.finalized.value="N";
		}
		
		
		  //Added by Rabbani #Inc no:29954(Bru-HIMS-CRF-088) on 01-MAR-2013 Starts
		    if(formObj.disposable_yn.value == "Y" && confirmation=="Yes"){  
		    var doIt= confirm(getMessage("WISH_TO_CONDEMNEXPIRED_BATCH","ST"));
	                  if(doIt) {
					   var responseText = formApply(formObj,ST_CONTROLLER);
                        eval(responseText);
					    if(result){
					    messageFrame.location.href = errorPage+"?err_num=";
					    var dialogHeight= "45vh" ;
						var dialogWidth	= "65vw" ;
						var dialogTop = "10" ;
						var center = "1" ;
						var status="no";
						var function_id="ST_CONDEMN_EXPIRED_BATCHES";
						var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; center: " + center + ";scroll "+scroll+"; status: " + status + "; dialogTop :" + dialogTop;
						var arguments	= "" ;
						var function_name = "CondemnExpiredBatches";	 
						
				var retVal = await window.showModalDialog("../../eST/jsp/CondemnExpiredBatches.jsp?mode="+MODE_INSERT+"&function_id="+function_id+"&function_name="+function_name+"&function_type=F"+"&access=NYNNN"+"&store_code="+formHdrObj.store_code.value+"&default_Expdate_condmn="+formHdrObj.default_Expdate_condmn.value+"&disposable_yn=Y",arguments,features);
				    }	
			   }else{
		       var responseText = formApply(formObj,ST_CONTROLLER);
		       eval(responseText);
		       }
		  }else{ //ends
		var responseText = formApply(formObj,ST_CONTROLLER);
		eval(responseText);
		}
		if(invalidCode != null && invalidCode != "") {
			message = message + " for the Item "+invalidCode;
		}
		flag1 = (flag.split("~"))[0];
		flag2 = (flag.split("~"))[1];
		flag1 = (flag1=="null"?"":flag1);  
		if(result)
		{
			if(flag2 == "PY")
			{
				if(formObj.finalized.value=="Y"){
				var PConfirm = confirmPrinting();
				if (PConfirm == "Yes") 
				{
					var xmlHttp = new XMLHttpRequest();
					var xmlDoc="";
					//xmlDoc.loadXML(getXMLString(null));
					var xmlString = getXMLString(null);
                    var xmlDoc = new DOMParser().parseFromString(xmlString, "text/xml");
					//xmlHttp.open("POST", 	"../../eST/jsp/AdjustStockValidate.jsp?validate=printOnlineDoc&msg="+encodeURIComponent(message), false);
					xmlHttp.open("POST", 	"../../eST/jsp/AdjustStockValidate.jsp?validate=printOnlineDoc&msg="+encodeURIComponent(message), true);
					xmlHttp.send(xmlDoc);
					//responseText=xmlHttp.responseText;
					//eval(responseText);
				}
			}
		}else 	if(flag2 == "PS")
			{
					var xmlHttp = new XMLHttpRequest();
					var xmlDoc="";
					//xmlDoc.loadXML(getXMLString(null));
					var xmlString = getXMLString(null);
                    var xmlDoc = new DOMParser().parseFromString(xmlString, "text/xml");
					//xmlHttp.open("POST", 	"../../eST/jsp/AdjustStockValidate.jsp?validate=printOnlineDoc&msg="+encodeURIComponent(message), false);
					xmlHttp.open("POST", 	"../../eST/jsp/AdjustStockValidate.jsp?validate=printOnlineDoc&msg="+encodeURIComponent(message), true);
					xmlHttp.send(xmlDoc);
					//responseText=xmlHttp.responseText;
					//eval(responseText);
			}
		//Added by Rabbani #Inc no:29954(Bru-HIMS-CRF-088) on 01-MAR-2013 Starts
		  if(formObj.disposable_yn.value == "Y" && formObj.finalized.value=="Y"){  
		 var display_msg = message;
		 var  f2 = flag1;
		  display_msg = (display_msg.split("."))[0];
		 var f3 = display_msg+"" +f2;
		 //alert(f3);
		 if(restoreToolbar()){
		  alert(f3);
		  messageFrame.location.href = errorPage+"?err_num="+ message +"<BR>"+ (result?flag1:"");
		  create();
		//
		}
		}
		messageFrame.location.href = errorPage+"?err_num="+ message +"<BR>"+ (result?flag1:"");
		onSuccess();
		}
		else{
			
			if (flag!="" && result){
			messageFrame.location.href = "../../eCommon/jsp/error.jsp?error_value=0&err_num=";
			f_query_add_mod.frameAdjustStockDetail.location.href="../../eST/jsp/AdjustStockDetail.jsp?function_id="+function_id+"&item_code="+flag;
			}else{
					messageFrame.location.href = errorPage+"?err_num="+ message ;
				}

		}

}


function populateData(mode, item_code,doc_srl_no,expiry_yn,batch_id_applicable_yn,trade_id_applicable_yn,uom,line_mode,itemlastcost,storecost) {
	var formObj1=parent.frameAdjustStockList.frameAdjustStockListHeader.document.formAdjustStockListHeader;
	var store_code=parent.frameAdjustStockHeader.document.formAdjustStockHeader.store_code.value;

	if (mode == 2)
	{
		
		
		var xmlString = getXMLString(null);
		var xmlDoc = new DOMParser().parseFromString(xmlString, "text/xml");
		var xmlHttp = new XMLHttpRequest();
		//xmlDoc.loadXML(getEnhancedXMLString(formObj1));
		xmlHttp.open("POST", "../../eST/jsp/AdjustStockValidate.jsp?item_code="+item_code+"&store_code="+store_code+"&validate=FETCH_COST&mode="+mode, false);
		xmlHttp.setRequestHeader("Content-Type", "text/xml");
		xmlHttp.send(xmlString);
		responseText=xmlHttp.responseText;
		eval(responseText);

		storecost =formObj1.item_store_unit_cost_1.value;
		itemlastcost =formObj1.item_last_unit_cost.value;

	}
	//Added by Rabbani #Inc no:29954(Bru-HIMS-CRF-088) on 01-MAR-2013 Starts
	var disposable_yn =formObj1.disposable_item_yn.value;
	parent.frameAdjustStockList.frameAdjustStockListHeader.location.href="../../eST/jsp/AdjustStockListHeader.jsp?mode="+mode+"&item_code="+item_code+"&doc_srl_no="+doc_srl_no+"&uom="+uom+"&batch_id_applicable_yn="+batch_id_applicable_yn+"&trade_id_applicable_yn="+trade_id_applicable_yn+"&line_mode="+line_mode+"&itemlastcost="+itemlastcost +"&storecost="+storecost;	
	parent.frameAdjustStockList.frameAdjustStockListDetail.location.href="../../eST/jsp/AdjustStockListDetail.jsp?mode="+mode+"&item_code="+item_code+"&doc_srl_no="+doc_srl_no+"&expiry_yn="+expiry_yn+"&batch_id_applicable_yn="+batch_id_applicable_yn+"&uom="+uom+"&trade_id_applicable_yn="+trade_id_applicable_yn+"&disposable_yn="+disposable_yn; //29954		
	
}

function getBatchIDFromExpiryDate(expiry_date_object,i,flag) {
  var dateObj = expiry_date_object;
	var sys_date=document.forms[0].sys_date;
	var formObj = document.formAdjustStockListDetail;
	var locale = formObj.locale.value; 
	//alert(locale);
	if(locale != "en") {
	expiry_date_object = convertDate(expiry_date_object.value, "DMY", locale, "en");
	}
	else{
		expiry_date_object = expiry_date_object.value;
	}
	//alert(expiry_date_object);
	if(CheckDate(expiry_date_object)) {
			if( (CheckDate(expiry_date_object)) && (flag == 'E') && (expiry_date_object.value !="") ) {
				var index = i;
				var expiry_date = expiry_date_object;
				if(locale != "en") {
					expiry_date = convertDate(expiry_date, "DMY", "en", locale);
				}
				var result ="";
				var start_index = 0;
				var end_index = 0;
				while(expiry_date.indexOf("/") != -1) {
					end_index = expiry_date.indexOf("/");
					result += expiry_date.substring(start_index,end_index);
					expiry_date = expiry_date.substring(end_index+1);
				}
				result+=expiry_date;
				parent.parent.frameAdjustStockList.frameAdjustStockListDetail.document.formAdjustStockListDetail.elements["batch_id_"+i].value =result; 
			}
	} else {
		dateObj.value = "" ;
	}
}

function cancel_me() {
	parent.frameAdjustStockListHeader.location.href="../../eST/jsp/AdjustStockListHeader.jsp?disposable_disabled=disabled";
	parent.parent.frameAdjustStockList.frameAdjustStockListDetail.location.href="../../eCommon/html/blank.html";
	parent.parent.parent.messageFrame.location.href = "../../eCommon/jsp/error.jsp?";
}
function ValidateItem(obj) {
	var formObj=  parent.frameAdjustStockListHeader.document.formAdjustStockListHeader;
	var xmlHttp = new XMLHttpRequest();
	var xmlDoc="";
	//xmlDoc.loadXML(getXMLString(null));
	var xmlString = getXMLString(null);
    var xmlDoc = new DOMParser().parseFromString(xmlString, "text/xml");
	xmlHttp.open("POST", "../../eST/jsp/AdjustStockValidate.jsp?validate=ITEM_CODE&search_code=" + formObj.item_desc.value, false);
	xmlHttp.send(xmlDoc);
	responseText=xmlHttp.responseText;
	eval(responseText);
}



// Function added to check and accept positive and negative numbers.

function isValidNumberOnKeyPress() {
	var key = window.event.keyCode;
	if( !( key >= 48 && key <= 57 || key == 45) ) {
		return false;
	}
	else {
		return true;
	}
}


function checkNumberValid()
{
	var quantity=document.formAdjustStockListHeader.adj_item_qty.value;
	var value=document.formAdjustStockListHeader.item_cost_value.value;

    if(!(document.formAdjustStockListHeader.adj_item_qty.value ==null))
		{
			if(checkDoubleFormatForAllNumbers(document.formAdjustStockListHeader.adj_item_qty))
			{
			}
			else
			{
				document.formAdjustStockListHeader.adj_item_qty.value="";
				
			}
		}

	if(!(document.formAdjustStockListHeader.item_cost_value.value ==null))
		{
			if(checkDoubleFormatForAllNumbers(document.formAdjustStockListHeader.item_cost_value))
			{
			}
			else
			{
				document.formAdjustStockListHeader.item_cost_value="";
				
			}
		}
	}

function checkForQuantityAndValue (chkflag) {
	var quantity=document.formAdjustStockListHeader.adj_item_qty.value;
	var value=document.formAdjustStockListHeader.item_cost_value.value;
	var unit_cost= document.formAdjustStockListHeader.item_unit_cost.value;
	//var unit_cost= document.formAdjustStockListHeader.item_unit_cost_org.value;
	var no_of_decimals_for_cost = eval(document.formAdjustStockListHeader.no_of_decimals_for_cost.value);
	//unit_cost = eval(document.formAdjustStockListHeader.item_unit_cost_org.value)*eval(document.formAdjustStockListHeader.tmp_conv.value);
	unit_cost = eval(document.formAdjustStockListHeader.item_unit_cost.value)*eval(document.formAdjustStockListHeader.tmp_conv.value);//ML-MMOH-CRF-1982
	
	/*alert(quantity);
	alert(value);
	alert(unit_cost);
	alert(document.formAdjustStockListHeader.item_unit_cost_org.value);
	alert(document.formAdjustStockListHeader.tmp_conv.value);*/
	
	if(quantity !="" && value != ""  ) {
		if(quantity < 0) {
			
			if(value > 0) {
				alert("Value also should be negative or zero");
				document.formAdjustStockListHeader.item_cost_value.value= eval("-"+document.formAdjustStockListHeader.item_cost_value.value);
				if(unit_cost>0){
					document.formAdjustStockListHeader.item_unit_cost.value = eval("-"+document.formAdjustStockListHeader.item_unit_cost.value);
				}
				
			}
			else if(value < 0) 
			{
				if (chkflag =='fromvalue')
				{
					document.getElementById("td_cost").innerHTML="<b>"+x+"</b>";
					document.formAdjustStockListHeader.item_unit_cost.value=cost;
					cost = value/quantity;
					var x=setNumber(cost,no_of_decimals_for_cost);
					document.getElementById("td_cost").innerHTML="<b>"+x+"</b>";
					document.formAdjustStockListHeader.item_unit_cost.value=cost;
				}
				else
				{
					value = quantity * unit_cost;
					var x=setNumber(value,no_of_decimals_for_cost);
					document.formAdjustStockListHeader.item_cost_value.value = x;
				}
			}
		}
		else if(value < 0) {
			
			if(quantity > 0) {
				document.formAdjustStockListHeader.item_cost_value.value= eval("-"+document.formAdjustStockListHeader.item_cost_value.value);
				if(unit_cost>0){
					document.formAdjustStockListHeader.item_unit_cost.value = eval("-"+document.formAdjustStockListHeader.item_unit_cost.value);
				}
				
			}
			else if(quantity < 0) {
				
				var cost = value/quantity;
				var x=setNumber(cost,no_of_decimals_for_cost);
				document.getElementById("td_cost").innerHTML="<b>"+x+"</b>";
				document.formAdjustStockListHeader.item_unit_cost.value=cost;
			}
			else if(quantity == 0){

                var cost = value ;
				var x=setNumber(cost,no_of_decimals_for_cost);
				document.getElementById("td_cost").innerHTML="<b>"+x+"</b>";
				document.formAdjustStockListHeader.item_unit_cost.value=cost;

			}


		}
		
		else {
			
			var cost ="";
			var x="";
			if(quantity !=0)
			{
			if (chkflag =='fromvalue')
			{
				document.getElementById("td_cost").innerHTML="<b>"+x+"</b>";
				document.formAdjustStockListHeader.item_unit_cost.value=cost;
				cost = value/quantity;
				var x=setNumber(cost,no_of_decimals_for_cost);
				document.getElementById("td_cost").innerHTML="<b>"+x+"</b>";
				document.formAdjustStockListHeader.item_unit_cost.value=cost;
			}
			else
			{
				value = quantity * unit_cost;
				
				var x=setNumber(value,no_of_decimals_for_cost);
				document.formAdjustStockListHeader.item_cost_value.value = x;
				//alert(document.formAdjustStockListHeader.item_cost_value.value);
			}
			}
			else if(quantity ==0)
			{
				cost = value;
				var x=setNumber(cost,no_of_decimals_for_cost);
				document.getElementById("td_cost").innerHTML="<b>"+x+"</b>";
				document.formAdjustStockListHeader.item_unit_cost.value=cost;
			}
		}
		return true;
	}
	//else if(quantity != "" && value == "" && unit_cost != "" ){   ///ML_MMOH_CRF_1982
	else if(quantity != "" && value == "" && (unit_cost != "" ||unit_cost ==0) ){   ///ML_MMOH_CRF_1982
		
		value = quantity * unit_cost;
		var x=setNumber(value,no_of_decimals_for_cost);
		document.formAdjustStockListHeader.item_cost_value.value = x;
		
	}
	else if(quantity == "" && value != "" && unit_cost != "" ) {
		quantity = value / unit_cost;
		document.formAdjustStockListHeader.adj_item_qty.value = quantity;
	}
	//else if(quantity == "" && value == "" && unit_cost == "") {
	//Modified against BSP-SCF-0030
	else if(quantity == "" && value == "" && unit_cost == null) {
		document.getElementById("td_cost").innerText="";
		document.formAdjustStockListHeader.item_unit_cost.value="";
	}
		
}

function isValidValueOnKeyPress(fld, e, maxInt, deci) {
    var count=fld.value.length;
    var whichCode = (window.Event) ? e.which : e.keyCode;
    if(count>=maxInt) {
        if(count==maxInt) {
            var dotOccurance = fld.value.indexOf('.');

            if(((dotOccurance>=maxInt)||(dotOccurance==-1)) && (count==maxInt)) {
                if(whichCode!=46) {
					if(deci>1) { 
						fld.value = fld.value+".";
					}
                }
            }
        }
        else if(count>maxInt) {
            var objectValue = fld.value;
            var dotOccurance = objectValue.indexOf('.');
            if((objectValue.charAt(maxInt))!='.') {
                if(dotOccurance==-1) {
                    if(deci!=0) {
						fld.value = objectValue.substring(0,maxInt)+".";
					}
					else {
						fld.value = objectValue.substring(0,maxInt);
					}
                    return false;
                }
            }
        }
    }
	var strCheck = '-.0123456789';

	if(deci==0) {
	   strCheck = '-0123456789';
	}

    var fldvalue=fld.value;
    var whichCode = (window.Event) ? e.which : e.keyCode;
    if (whichCode == 13) {
		return true;  // Enter
	}
    var pointCount=0;
    for(var i=0;i<fldvalue.length;i++) {
        if(fldvalue.charAt(i)=='.') pointCount++;
    }
    if (pointCount>0 && whichCode == 46) {
		return false;
	}
    var fldValue    =   fld.value;
    var dotIndex    =   fldValue.indexOf(".");
    var fldLength   =   fldValue.length;
    if(dotIndex!=-1) {
        if( fldLength > (dotIndex+deci) ) {
			return false;
		}
	}
    key = String.fromCharCode(whichCode);  // Get key value from key code
    if (strCheck.indexOf(key) == -1) {
		return false;  // Not a valid key
	}
    return true;

}

async function callBatchSearch() {
	
	var objForm=parent.frameAdjustStockListHeader.formAdjustStockListHeader;
	var store_code=parent.parent.frameAdjustStockHeader.document.formAdjustStockHeader.store_code.value;
	var formObj1 = parent.parent.frameAdjustStockHeader.document.formAdjustStockHeader;
	var item_code=objForm.item_code.value;

	var includeZeroStockBatches ="N";
	var includeExpiredBatches ="Y";
	var includeSuspendedBatches ="N";
	var searchFunction ="Y";
	var multipleSelect ="Y";
	if(item_code==null || item_code === '') {
		alert(getMessage("ST_ITEM_CODE_BLANK","ST"));	
		return;
	}
	else if(store_code==null || store_code === '') {
		alert(getMessage("ST_STORE_CODE_BLANK","ST"));
		return;
	}
	else {
		var retvals="";
	
		retvals= await callBatchSearchWindow(item_code,store_code,includeZeroStockBatches,includeExpiredBatches,includeSuspendedBatches,searchFunction,multipleSelect,'',formObj1.doc_type_code.value,formObj1.doc_no.value,formObj1.trn_type.value);

		var arr_string=new Array();
		var arr_vals=new Array();

		if (retvals!=null && retvals!="" && retvals!=undefined) {
			arr_string=retvals.split("~");

			if(arr_string.length > 0) {
				if(confirm(getMessage("BATCH_REFRESHED","ST")))
				{	
					document.formAdjustStockListHeader.batch_details.value = "";
					document.formAdjustStockListHeader.batch_details.value = retvals;
					var item_desc				= document.formAdjustStockListHeader.item_desc.value;
					var item_code				= document.formAdjustStockListHeader.item_code.value;
					var expiry_yn				= document.formAdjustStockListHeader.expiry_yn.value;
					var uom_code				= document.formAdjustStockListHeader.uom_code.value;
					var uom						= document.formAdjustStockListHeader.uom.value;
					var mode					= document.formAdjustStockListHeader.mode.value;
					if(mode == "null")
						mode = parent.parent.frames[1].document.forms[0].mode.value;

					var batch_id_applicable_yn	= 
					document.formAdjustStockListHeader.batch_id_applicable_yn.value;
					var trade_id_applicable_yn	= document.formAdjustStockListHeader.trade_id_applicable_yn.value;
					var doc_srl_no = document.formAdjustStockListHeader.doc_srl_no.value;
				parent.frameAdjustStockListDetail.location.href="../../eST/jsp/AdjustStockListDetail.jsp?mode="+mode+"&item_desc="+encodeURIComponent(item_desc,"UTF-8")+"&item_code="+item_code+"&expiry_yn="+expiry_yn+"&uom_code="+uom_code+"&uom="+uom+"&batch_id_applicable_yn="+batch_id_applicable_yn+"&trade_id_applicable_yn="+trade_id_applicable_yn+"&doc_srl_no="+doc_srl_no;	

				}
				
			}

		}
	}
}

function reloadTheBatchDetails () {
	var locale=formAdjustStockListDetail.locale.value;

	var arr_string  = new Array();
	arr_string		=	parent.frameAdjustStockListHeader.formAdjustStockListHeader.batch_details.value;
	
	var batch_string="";
	if(arr_string != null && arr_string.length > 0) {
		arr_string      = arr_string.split("~");
		for(var i=0;i<arr_string.length;i++) {

			batch_string=arr_string[i];
			arr_vals=batch_string.split("`");
			expiry_date=convertDate(arr_vals[6],"DMY","en",locale);
			bin_location_code=arr_vals[7];
			batch_id=arr_vals[0];
			trade_id=arr_vals[9];
			var objListForm=parent.frameAdjustStockListDetail.formAdjustStockListDetail;
	
			objListForm.elements["expiry_date_or_receipt_date_"+i].value = expiry_date;
			
			objListForm.elements["batch_id_"+i].value = batch_id;
			if(objListForm.trade_id_applicable_yn.value!="N")
				objListForm.elements["trade_id_"+i].value = trade_id;
			objListForm.elements["bin_location_code_"+i].value = bin_location_code;
		}
		for ( j=i; j<10; j++) {
			objListForm.elements["expiry_date_or_receipt_date_"+j].value = "";
			objListForm.elements["batch_id_"+j].value = "";
			if (!objListForm.elements["trade_id_"+j].disabled) {
				objListForm.elements["trade_id_"+j].value = "";
			}
			objListForm.elements["bin_location_code_"+j].value = "";
			objListForm.elements["item_qty_"+j].value = "";
		}
		//parent.frameAdjustStockListHeader.formAdjustStockListHeader.batch_details.value = "";
	}
}
function Modify(obj,doc_type_code,store_code,doc_ref,local,item_class_code) {
	/**
	* @Name - Priya
	* @Date - 21/12/2009
	* @Inc# - IN017084
	* @Desc - To avoid the duplication records display in Modify mode
	*/
	var errorPage = "../../eCommon/jsp/error.jsp";
	document.getElementById("readOnlyDiv").style.visibility='visible';
	parent.parent.messageFrame.location.href = errorPage + "?err_num="+getMessage("ST_PROCESSING_WAIT", "ST");
	
	var doc_no		= obj.cells[1].innerText;
	var doc_date	= obj.cells[2].innerText;
    doc_date        = convertDate(doc_date,'DMY',local,"en");
	if(doc_ref == "undefined") {
		doc_ref = "";
	}
	parent.document.location.href="../../eST/jsp/AdjustStockFrame.jsp?mode="+MODE_MODIFY+"&function_id="+parent.parent.function_id+"&doc_type_code="+doc_type_code+"&doc_no="+doc_no+"&doc_date="+doc_date+"&store_code="+store_code+"&doc_ref="+doc_ref+"&item_class_code="+item_class_code+"&disposable_disabled=disabled"; 

}

function showCalendarLocal(id) {
	var flag = showCalendar(id); 
	document.getElementById(id).focus();
	return flag;		   
}

function CheckForSpecialChars(event){
    var strCheck = '0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ_*/-';
    var whichCode = (window.Event) ? event.which : event.keyCode;
    key = String.fromCharCode(whichCode);  // Get key value from key code
    if (strCheck.indexOf(key) == -1) return false;  // Not a valid key
	if( (event.keyCode >= 97) && (event.keyCode <= 122) )
		return (event.keyCode -= 32);
	return true ;
}

function convertToUpperCase(obj) {
	obj.value = obj.value.toUpperCase();
}

function isValidNumber1(fld, e, maxInt, deci){

    var count=fld.value.length;
    var whichCode = (window.Event) ? e.which : e.keyCode;


	if(whichCode==45)
		return true;

    if(count>=maxInt) {
        if(count==maxInt) {
            var dotOccurance = fld.value.indexOf('.');

            if(((dotOccurance>=maxInt)||(dotOccurance==-1)) && (count==maxInt)) {
                if(whichCode!=46 ) {
					if(deci>1) { 
						fld.value = fld.value+".";
					}
                }
            }
        }
        else if(count>maxInt) {
            var objectValue = fld.value;
            var dotOccurance = objectValue.indexOf('.');
            if((objectValue.charAt(maxInt))!='.') {
                if(dotOccurance==-1) {
                    if(deci!=0) {
						fld.value = objectValue.substring(0,maxInt)+".";
					}
					else {
						fld.value = objectValue.substring(0,maxInt);
					}
                    return false;
                }
            }
        }
    }
	var strCheck = '.0123456789';

	if(deci==0) {
	   strCheck = '0123456789';
	}

    var fldvalue=fld.value;
    var whichCode = (window.Event) ? e.which : e.keyCode;
    if (whichCode == 13) {
		return true;  
	}
    var pointCount=0;
    for(var i=0;i<fldvalue.length;i++) {
        if(fldvalue.charAt(i)=='.') pointCount++;
    }
    if (pointCount>0 && whichCode == 46) {
		return false;
	}

    var fldValue    =   fld.value;
    var dotIndex    =   fldValue.indexOf(".");
    var fldLength   =   fldValue.length;
    if(dotIndex!=-1) {
        if( fldLength > (dotIndex+deci) ) {
			return false;
		}
	}

    key = String.fromCharCode(whichCode);  // Get key value from key code
	
    if (strCheck.indexOf(key) == -1) {
		return false;  // Not a valid key
	}
    return true;


}


function setRemarks(){
 var formObj = document.formAdjustStockListHeader ;
 formObj.remarks.value=formObj.remarks.value ;

}

function setRemarks1(){
 var formObj=parent.frameAdjustStockListHeader.document.formAdjustStockListHeader;
 formObj.remarks.value=formObj.remarks.value ;
}

async function searchRemarks(objCode,objDesc) {

	objCode_value			=		"";
	objDesc_value			=		"";
	var argumentArray		=		new Array();
	var dataNameArray		=		new Array();
	var dataValueArray		=		new Array();
	var dataTypeArray		=		new Array();

	dataNameArray[0]		=		"language_id" ;
	dataValueArray[0]		=		document.formAdjustStockListHeader.language_id.value;
	dataTypeArray[0]		=		STRING ;

	dataNameArray[1]		=		"module_id" ;
	dataValueArray[1]		=		"ST";
	dataTypeArray[1]		=		STRING ; 
	

	dataNameArray[2]		=		"trn_type" ;
	dataValueArray[2]		=		document.formAdjustStockListHeader.rem_trans_type.value;
	dataTypeArray[2]		=		STRING ;	

	argumentArray[0]		=		document.formAdjustStockListHeader.SQL_ST_TRN_REMARKS_LOOKUP_SELECT.value;	
	
	argumentArray[1]		=		dataNameArray;
	argumentArray[2]		=		dataValueArray;
	argumentArray[3]		=		dataTypeArray;
	argumentArray[4]		=		"4,5";
	argumentArray[5]		=		objDesc_value;
	argumentArray[6]		=		CODE_LINK;
	argumentArray[7]		=		CODE_DESC;
	
	var remarks				=		getLabel("Common.remarks.label","Common");
	returnedValues			=		await CommonLookup( remarks, argumentArray );

	/*if((returnedValues != null) && (returnedValues != "") )  {
		objCode.value		=		returnedValues[0];
		objDesc.value		=		returnedValues[1];
		
	} */
	var ret1=unescape(returnedValues);
	 	arr=ret1.split(",");
		if(arr[1]==undefined)
 		{
	 		arr[0]="";	
	 		arr[1]="";	
 		}
	else{
		objCode.value=arr[0];
		objDesc.value=arr[1];
	}
}

function BatchExitsID(batchidexits)
{
	
parent.parent.parent.messageFrame.location.href = "../../eCommon/jsp/error.jsp?error_value=0&err_num="+getMessage("RECORD_ALREADY_EXISTS"+batchidexits);

}

// Ends of 10/25/2004

function checkMinMaxLevel(){
	var formObj	=	document.formAdjustStockListHeader;
		
	if(!formObj.adj_item_qty.value == "")
	{
		if (formObj.max_stk_qty.value!= null && !formObj.max_stk_qty.value == "")      
			{
				if ( parseFloat(formObj.adj_item_qty.value) + parseFloat(formObj.avl_qty.value) >parseFloat(formObj.max_stk_qty.value) )
				{
					alert(getLabel("eST.exceedmaxStockLevel.label","ST")); // exceed
																			// max
																			// Stock
																			// Level
				}
			}
		if (formObj.min_stk_qty.value!= null && !formObj.min_stk_qty.value == "")      
			{
				if ( parseFloat(formObj.adj_item_qty.value)  + parseFloat(formObj.avl_qty.value) < parseFloat(formObj.min_stk_qty.value) )
				{
					alert(getLabel("eST.BelowMinStockLevel.label","ST")); // Below
																			// Min
																			// Stock
																			// Level
				}
			}
	}
}
function convertDate(date,format,from,to){
	var xhr =  getXHR();
	var url = "../../eCommon/jsp/DateUtils.jsp?methodName=convertDate&format="+format+"&date="+date+"&fromLocale="+from+"&toLocale="+to;
    xhr.open("POST", url, false);
	xhr.setRequestHeader("Content-Type","text/plain")
   	xhr.send("");
	
	var xmlText = xhr.responseText
	return(xhr.responseText);
}
function getXHR(){
	var request = false;
	try {
		request = new XMLHttpRequest();
	}catch (trymicrosoft) {
		try {
			//request = new ActiveXObject("Msxml2.XMLHTTP");
			request = new XMLHttpRequest();
		}catch (othermicrosoft) {
			try {
				//request = new ActiveXObject("Microsoft.XMLHTTP");
				request = new XMLHttpRequest();
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
function issueUOMQtyChk(){
	var formObj	=  parent.parent.frames[2].frames[0].document.formAdjustStockListHeader;
		toConvFactor();
		/*if(formObj.dec_allowed_yn.value == 'N')
		{
		var conv_factor = formObj.tmp_conv.value;
		var dec_factor=((formObj.tot_adj_qty.value))%(formObj.tmp_conv.value);
		if(dec_factor>0 && eval(conv_factor) > 1){
				alert("Quantity Should Be In Multiples Of "+formObj.tmp_conv.value);
				return false;
			}else{
				return true;
			}
		}*/
	return true;
}
function setTempConvFactor(tmp){
	if(document.formAdjustStockListHeader==null){
		parent.parent.frames[2].frames[0].document.formAdjustStockListHeader.tmp_conv.value = tmp;
	}
	else{
		document.formAdjustStockListHeader.tmp_conv.value = tmp;
	}
}
function toConvFactor(){
	var formObj	=	document.formAdjustStockListHeader;
	var item_code="";
	if(formObj==null){
		formObj=parent.parent.frames[2].frames[0].document.formAdjustStockListHeader;
		var store_code=parent.parent.frameAdjustStockHeader.document.formAdjustStockHeader.store_code.value;
	}else{
		var store_code=parent.parent.frameAdjustStockHeader.document.formAdjustStockHeader.store_code.value;
	}
	item_code=formObj.item_code.value;
	if(parent.frameAdjustStockDetail!=null){
		var formObj1	=	parent.frameAdjustStockDetail.document.formAdjustStockDetail;
		item_code		=	formObj1.item_code.value;
	}
	var xmlHttp = new XMLHttpRequest();
	var xmlDoc="";
	//var xmlString = getXMLString(null);
    var xmlString = getXMLString(null);
    var xmlDoc = new DOMParser().parseFromString(xmlString, "text/xml");
	xmlHttp.open("POST", "../../eST/jsp/AdjustStockValidate.jsp?validate=setToConv"+"&store_code="+store_code+"&item_code="+item_code, false);
	xmlHttp.send(xmlDoc);
	var responseText=xmlHttp.responseText;
	eval(responseText);
/*	if( !result ) {
		if(message=="Multiple"){
		alert("Mutilpe uom");
			cancel_me();
			return;
		}
		}	*/	
}
function totalqty(no_of_decimals){		
	var formObj	=	parent.parent.frames[2].frames[0].document.formAdjustStockListHeader;
	if(formObj==null)
		formObj=parent.parent.frames[2].frames[0].document.formAdjustStockListHeader;
	if(formObj.dec_allowed_yn.value == 'N'){
		no_of_decimals =0;
	}
	if(formObj.item_code.value!="")
		toConvFactor();
	var totalqty = eval(formObj.adj_item_qty.value*formObj.tmp_conv.value);
	if(formObj.adj_item_qty.value ==""){
		formObj.tot_adj_qty.value =  "";
	}else{
		formObj.tot_adj_qty.value= totalqty.toFixed(eval(no_of_decimals));
	}
}
function dispMess(id){
		alert(getMessage("PHY_INV_PROCESS_INITIATED","ST")+"\n"+getLabel("eST.PhyInventoryID.label","ST")+":"+id);
}

function assignValue(obj) {
	if (obj.checked == true) {
		obj.value = "P";
	} else {
		obj.value = "N";
	}
}


async function checkForMandatory(){

parent.parent.messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num=";
var from_doc_date=document.formAdjustStockQueryCriteria.from_doc_date ;
var to_doc_date=document.formAdjustStockQueryCriteria.to_doc_date ;
var sysdate=document.formAdjustStockQueryCriteria.sysdate ;
var locale = document.formAdjustStockQueryCriteria.language_id.value ; //added by B.Badmavathi for SRR20056-SCF-14071 on 22/7/2015
var errorPage = "../../eCommon/jsp/error.jsp";
var arrayObject = new Array(document.formAdjustStockQueryCriteria.from_doc_date,document.formAdjustStockQueryCriteria.to_doc_date);
var names = new Array(getLabel("eST.FromDocDate.label", "ST"),getLabel("eST.ToDocDate.label", "ST"));
var blankObject = checkSTFields(arrayObject, names, parent.parent.messageFrame, errorPage);
	if (blankObject != true) {
		return;
	}
var flag1=false;
	
var flag2=false;
flag1= await checkSysdate(sysdate,from_doc_date,locale);//locale added by Badmavathi for SRR20056-SCF-14071
flag2= await checkSysdateTo(to_doc_date,from_doc_date,locale);//locale added by Badmavathi for SRR20056-SCF-14071
if (flag1 != false && flag2 != false) {
    document.formAdjustStockQueryCriteria.action = "../../eST/jsp/AdjustStockQueryResult.jsp";
    document.formAdjustStockQueryCriteria.method = "post";
    document.formAdjustStockQueryCriteria.target = "AdjustStockQueryResult";

    document.formAdjustStockQueryCriteria.submit();
}
}

async function checkSysdate(receiptdate, sysdate,locale) {
	var errorPage = "../../eCommon/jsp/error.jsp";
	var arrayObject = new Array(document.formAdjustStockQueryCriteria.from_doc_date);
	if(receiptdate.value!=""){
		//var flag = ChkDate(receiptdate);
		var flag =await CheckDateLeap(receiptdate,"DMY",locale);//changed chkDate to CheckDateLeap by B.Badmavathi for SRR20056-SCF-14071 on 22/7/2015
		if (!flag) {

		parent.parent.messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num="+getMessage("INVALID_DATE_FMT", "ST");
			return false;
		}

		if (flag) {
			if (checkdateWithSysDate(receiptdate, sysdate)) {
			parent.parent.messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num="+getMessage("FRM_DOC_DATE_NOT_LESS_SYSDATE","ST");
			return false;
						
			}
			}
	}
}
function checkdateWithSysDate(entered_date, sys_date) {
	/* Entered Date Should not be less than sysdate Krishna 1/13/2009 */
	var enteredDateArray;
	var sysDateArray;
	var enteredDate = entered_date.value;
	var sysDate = sys_date.value;
	if (enteredDate.length > 0 && sysDate.length > 0) {
		enteredDateArray = enteredDate.split("/");
		sysDateArray = sysDate.split("/");
		var enteredDateObject = new Date(enteredDateArray[2], (enteredDateArray[1] - 1), enteredDateArray[0]);
		var sysDateObject = new Date(sysDateArray[2], (sysDateArray[1] - 1), sysDateArray[0]);
		if (Date.parse(sysDateObject) <= Date.parse(enteredDateObject)) {
				
			return false;
		} else {
			if (Date.parse(sysDateObject) > Date.parse(enteredDateObject)) {
				return true;
			}
		}
	}
	return true;
}

function checkSysdateTo(receiptdate, sysdate, locale) {
	var errorPage = "../../eCommon/jsp/error.jsp";
	var arrayObject = new Array(document.formAdjustStockQueryCriteria.from_doc_date);
	if(receiptdate.value!=""){
		//var flag = ChkDate(receiptdate);
		var flag = CheckDateLeap(receiptdate,"DMY",locale);//changed chkDate to CheckDateLeap by B.Badmavathi for SRR20056-SCF-14071 on 22/7/2015
		if (!flag) {

		parent.parent.messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num="+getMessage("INVALID_DATE_FMT", "ST");
			return false;
		}

		if (flag) {
			if (checkdateWithSysDateTo(receiptdate, sysdate)) {
			parent.parent.messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num="+getMessage("TO_DOC_DATE_NOT_LESS_FRM_DOC_DATE","ST");
			return false;
						
			}
			}
	}
}
function checkdateWithSysDateTo(entered_date, sys_date) {
	/* Entered Date Should not be less than sysdate Krishna 1/13/2009 */
	var enteredDateArray;
	var sysDateArray;
	var enteredDate = entered_date.value;
	var sysDate = sys_date.value;
	if (enteredDate.length > 0 && sysDate.length > 0) {
		enteredDateArray = enteredDate.split("/");
		sysDateArray = sysDate.split("/");
		var enteredDateObject = new Date(enteredDateArray[2], (enteredDateArray[1] - 1), enteredDateArray[0]);
		var sysDateObject = new Date(sysDateArray[2], (sysDateArray[1] - 1), sysDateArray[0]);
		if (Date.parse(sysDateObject) <= Date.parse(enteredDateObject)) {
				
			return false;
		} else {
			if (Date.parse(sysDateObject) > Date.parse(enteredDateObject)) {
				return true;
			}
		}
	}
	return true;
}
/**
	* @Name - Priya
	* @Date - 21/12/2009
	* @Inc# - IN017084
	* @Desc - To avoid the duplication records display in Modify mode
	*/
function clearMessageFrame(){
var errorPage = "../../eCommon/jsp/error.jsp";
parent.messageFrame.location.href = errorPage + "?err_num=";
}

/**
	* @Name - Priya
	* @Date - 27/01/2010
	* @Inc# - IN018497
	* @Desc - To check whether the available quantity is going below zero during negative adjustment
	*/

function checkAvlQty(item_obj,index){
   var formObj=parent.frameAdjustStockListHeader.document.formAdjustStockListHeader;
   
   if(formObj.adjustment_type.value == 'N'){
	   var batch_string		=	formObj.batch_details.value;
	   if(batch_string != null && batch_string.length > 0) {
			batch_string      = batch_string.split("~");
	   
	   var batch_arr = new Array();
	   batch_arr = 	(batch_string[index]).split("`");
		var batch_qty = parseFloat(item_obj.value);
		var batch_avl_qty = parseFloat(batch_arr[15]);
		if((batch_avl_qty - batch_qty) < 0){
			alert(getMessage("TFR_QTY_LESS_THAN_AVL_QTY", "ST"));
			item_obj.value = '';
			item_obj.focus();
		}
   }
   }
}

function checkAvlQty1(){
   var formHeaderObj=parent.frameAdjustStockListHeader.document.formAdjustStockListHeader;
   var formDetailObj=parent.frameAdjustStockListDetail.document.formAdjustStockListDetail;
   if(formHeaderObj.adjustment_type.value == 'N'){
	   var batch_string		=	formHeaderObj.batch_details.value;
	   if(batch_string != null && batch_string.length > 0) {
			batch_string      = batch_string.split("~");
	   } 

		for(var i=0;i<batch_string.length;i++) {   
			var batch_arr = new Array();
			batch_arr = 	(batch_string[i]).split("`");
			var batch_qty = parseFloat(formDetailObj.elements["item_qty_"+i].value);
			var batch_avl_qty = parseFloat(batch_arr[15]);
			if((batch_avl_qty - batch_qty) < 0){
			alert(getMessage("TFR_QTY_LESS_THAN_AVL_QTY", "ST"));
			formDetailObj.elements["item_qty_"+i].value = '';
			formDetailObj.elements["item_qty_"+i].select();
			return false;
			}
		}
		return true;
   }else{
	return true;
   }
}
//Added by Rabbani #Inc no:29954(Bru-HIMS-CRF-088) on 01-MAR-2013 Starts 
function checkstatus(obj){
   if(obj.checked){
  document.formAdjustStockListHeader.batchSearch.disabled = true;
  document.formAdjustStockListHeader.adjustment_type.disabled = true;
  document.formAdjustStockListHeader.adjustment_type.checked = true;
  document.formAdjustStockListHeader.adjustment_type.value= "P";
  document.formAdjustStockListHeader.disposable_yn.value = 'Y';
 // document.formAdjustStockListHeader.dispo_items.value = 'Y';
  document.formAdjustStockListHeader.disposable_item_yn.value = 'Y';
  //alert(document.formAdjustStockListHeader.disposable_yn.value);
  var store_code=parent.parent.frameAdjustStockHeader.document.formAdjustStockHeader.store_code.value;
  var xmlHttp = new XMLHttpRequest();
  var xmlDoc="";
	  // xmlDoc.loadXML(getXMLString(null));
	  var xmlString = getXMLString(null);
    var xmlDoc = new DOMParser().parseFromString(xmlString, "text/xml");
	   xmlHttp.open("POST", "../../eST/jsp/AdjustStockValidate.jsp?validate=check_status"+"&store_code="+store_code, false);
	   xmlHttp.send(xmlDoc);
	var responseText=xmlHttp.responseText;
	eval(responseText);
	if(result){
	parent.parent.frameAdjustStockHeader.formAdjustStockHeader.store_code_disabled.value = "disabled";
	}else{
	alert(getMessage("SET_UP_BATCH_ID", "ST")); 
	obj.checked = false;
	document.formAdjustStockListHeader.disposable_yn.value = "N";
	return false;
	}
}else{
document.formAdjustStockListHeader.batchSearch.disabled = false;
 document.formAdjustStockListHeader.adjustment_type.disabled = false;
document.formAdjustStockListHeader.disposable_yn.value = "N";
parent.parent.frameAdjustStockHeader.formAdjustStockHeader.store_code_disabled.value = "";
}

 
}
function restoreToolbar(){
	bean_id		=	parent.frames[2].frames[1].frames[0].document.formAdjustStockHeader.bean_id.value;
	bean_name	=	parent.frames[2].frames[1].frames[0].document.formAdjustStockHeader.bean_name.value;
	var xmlDoc="";
    var xmlHttp = new XMLHttpRequest();

    var xmlStr ="<root><SEARCH ";
	xmlStr += " bean_id=\""+bean_id+"\"";
	xmlStr += " bean_name=\""+bean_name+"\"";
    xmlStr +=" /></root>";
    xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	 xmlHttp.open("POST", "../../eST/jsp/AdjustStockValidate.jsp?validate=toolBar&"+toolBarString,false);
    xmlHttp.send(xmlDoc);
	eval(xmlHttp.responseText)
	return true
}
//ends
function getGTINDetails (e,barcode){//Adding start for MOHE-CRF-0167
	if(e.keyCode==9 || e.keyCode== 13  || e.keyCode== 0){
		var store_code =parent.parent.frameAdjustStockHeader.formAdjustStockHeader.store_code.value;
		var item_code = document.formAdjustStockListHeader.item_code.value;
		var xmlHttp = new XMLHttpRequest();
		var xmlDoc="";
		var xmlString = getXMLString(null);
        var xmlDoc = new DOMParser().parseFromString(xmlString, "text/xml");
		//xmlDoc.loadXML(getXMLString(null));
		xmlHttp.open("POST", "../../eST/jsp/AdjustStockValidate.jsp?barcode=" + barcode.value+"&item_code="+item_code +"&store_code="+store_code+"&validate=GET_GTIN", false);
		xmlHttp.send(xmlDoc);
		responseText = xmlHttp.responseText;
		eval(responseText);
		if(result){
			
			callItemSearchScreen("BARCODE",barcode.value);
			
		}else{
			if(item_code==""){
			document.formAdjustStockListHeader.barcode.value = "";
			 alert(getMessage(message, "ST"));
			}
		} 
		
	}
} // end
