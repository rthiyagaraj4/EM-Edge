
function create(){
	f_query_add_mod.location.href="../../eST/jsp/GoodsReturnToVendorFrame.jsp?mode="+MODE_INSERT+"&function_id="+function_id; 
}

function query(){  
	f_query_add_mod.location.href="../../eST/jsp/GoodsReturnToVendorQueryFrame.jsp?mode="+MODE_MODIFY+"&function_id="+function_id+"&doc_type_code=C1GRN&doc_no=107"; 
	//f_query_add_mod.location.href="../../eST/jsp/GoodsReturnToVendorFrame.jsp?mode="+MODE_MODIFY+"&function_id="+function_id+"&doc_type_code=C1GRN&doc_no=107"; 
}

function reset() {
	f_query_add_mod.location.reload();
}

function onSuccess() {
	f_query_add_mod.location.href="../../eCommon/html/blank.html";
}
function showCalendarLocal(id) {
	var flag = showCalendar(id); 
	document.getElementById(id).focus(); 
	return flag;		   
}


async function deleterecord(){

	var errorPage	 = "../../eCommon/jsp/error.jsp"
	var formObj= f_query_add_mod.frameGoodsReturnToVendorHeader.document.formGoodsReturnToVendorHeader;
	var prevMode	=	formObj.mode.value
	if (prevMode==MODE_INSERT) {
		messageFrame.location.href = errorPage+"?err_num="+ getMessage("OPER_CANCELLED","ST");
		return;
	}
	formObj.mode.value=MODE_DELETE;

	if(formObj.rtv_delete_yn.value=="N"){
	
	messageFrame.location.href = errorPage + "?err_num=" +getMessage("NO_DELETE_ACCESS_FOR_USER", "ST");
	formObj.mode.value = MODE_MODIFY;
	return false;
	}
	if (await confirmDelete()!=YES) {
		messageFrame.location.href = errorPage+"?err_num="+ getMessage("OPER_CANCELLED","ST");// +"<BR>"+ flag;
		formObj.mode.value = MODE_MODIFY;
		return;
	}
	var responseText=formApply(formObj,ST_CONTROLLER);
//	alert(responseText);
	eval(responseText);
	messageFrame.location.href = errorPage+"?err_num="+ message ;
	if(responseText) {
		onSuccess();
	}
	else{
		formObj.mode.value=prevMode;
	}
}


function callItemSearchScreen () {
	var search_string="";
	parent.parent.parent.messageFrame.location.href = "../../eCommon/jsp/error.jsp";
	
	if (!parent.frameGoodsReturnToVendorListHeader.formGoodsReturnToVendorListHeader.item_desc.readOnly){
		search_string=parent.frameGoodsReturnToVendorListHeader.formGoodsReturnToVendorListHeader.item_desc.value;
	}
	var arrayObject = new Array(parent.parent.frameGoodsReturnToVendorHeader.document.formGoodsReturnToVendorHeader.supp_code);
	var names = new Array(getLabel("Common.Supplier.label","Common"));
	var blankObject = checkSTFields(arrayObject, names, parent.parent.parent.messageFrame);
	if (blankObject!=true) {
		return;
	}
	var store_code=parent.parent.frameGoodsReturnToVendorHeader.formGoodsReturnToVendorHeader.store_code.value;
	var supp_code=parent.parent.frameGoodsReturnToVendorHeader.formGoodsReturnToVendorHeader.supp_code.value;
	var category ="A";
	var sole_source ="A";
	var ps_item ="A";
	var mfg_item ="A";
	var expiry ="A";
	var consignment ="A";
	var item_class =parent.parent.frameGoodsReturnToVendorHeader.formGoodsReturnToVendorHeader.item_class_code.value;
	var item_class_check =parent.parent.frameGoodsReturnToVendorHeader.formGoodsReturnToVendorHeader.item_class_check.value;

	if(item_class_check=='Y'){
	
		if((item_class=="")||(item_class=='null'))
		{
				alert(getMessage("ITEM_CLASS_CANNOT_BLANK","ST"));
		}
		
	
	if((item_class_check=='Y')&&((item_class!="")&&(item_class!='null')))
	
	{
		sub1();
	}
}
else
	{
		sub1();
	}
	async function sub1(){
	//Modified by Sakti against AMS-CRF-0011 trn_type passing
	var retVal=await callItemSearchWindow(search_string,store_code,category,sole_source,ps_item,mfg_item,expiry,item_class,consignment,"RTV");
     	var ret1=unescape(retVal);
	var arr=ret1.split(",");
		 	
	if(retVal!=null)
	{
		parent.parent.frameGoodsReturnToVendorHeader.document.formGoodsReturnToVendorHeader.store_code_disabled.value="disabled";
		document.formGoodsReturnToVendorListHeader.item_code.value=arr[0];
			/** @Name - Priya
			* @Date - 10/02/2010
			* @Inc# - 19092
			* @Desc - 'Allow Decimal Y/N' value of the selected item is assigned to the hidden field 'dec_allowed_yn'
			*/
		document.formGoodsReturnToVendorListHeader.dec_allowed_yn.value = arr[27];
		document.formGoodsReturnToVendorListHeader.item_desc.value=arr[1];
		document.formGoodsReturnToVendorListHeader.item_desc.readOnly=true;
		//document.formGoodsReturnToVendorListHeader.expiry_yn.value=retVal[2];
		document.formGoodsReturnToVendorListHeader.uom_code.value=arr[13];
//		document.getElementById("id_store_item_unit_cost").innerHTML=retVal[14];
		document.getElementById("id_uom").innerHTML=arr[15];
		document.getElementById("gen_uom_desc2").innerHTML=arr[25];
		document.getElementById("gen_uom_desc1").innerHTML=arr[25];
		document.getElementById("gen_uom_desc").value=arr[25];

		var trade_id_applicable_yn=arr[17];
		var batch_id_applicable_yn=arr[18];
		
		var formObj=document.formGoodsReturnToVendorListHeader;
		var xmlHttp = new XMLHttpRequest();
		//var xmlDoc="";
		//xmlDoc.loadXML(getXMLString(null));
		var xmlDoc = new DOMParser().parseFromString(getXMLString(null), "text/xml");
		var xmlString = '<root><child>Content</child></root>'; // Replace this with your actual XML string
		//var xmlDoc = parseXMLString(xmlString);

		
		xmlHttp.open("POST", "../../eST/jsp/GoodsReturnToVendorValidate.jsp?item_code="+formObj.item_code.value+"&store_code="+store_code+"&supp_code="+supp_code+"&validate=GET_STATUS", false);
		xmlHttp.send(xmlDoc);
		responseText=xmlHttp.responseText;
//		alert(responseText);
		eval(responseText);
		//if(result)
			//	parent.parent.frameGoodsReturnToVendorHeader.formGoodsReturnToVendorHeader.preview.disabled = false;
		if (!responseText) {
			parent.parent.parent.messageFrame.location.href = "../../eCommon/jsp/error.jsp?";//err_num="+ getMessage(message);
			if(message=="PHY_INV_PROCESS_INITIATED")
				alert(getMessage(message,"ST")+"\n"+getLabel("eST.PhyInventoryID.label","ST")+":"+formObj.phy_inv_id.value);
			else
				alert(getMessage(message,"ST"));
//	parent.parent.frameGoodsReturnToVendorDetail.location.reload();
//	parent.frameGoodsReturnToVendorListHeader.location.href='../../eST/jsp/GoodsReturnToVendorListHeader.jsp';
			refreshDetails();
			return;
		}
		//parent.frameGoodsReturnToVendorListDetail.location.href="../../eST/jsp/GoodsReturnToVendorListDetail.jsp?item_code="+retVal[0]+"&index="+formObj.index.value;
		setDecimalParameters(arr[27],arr[28],formObj);
		document.formGoodsReturnToVendorListHeader.item_qty_normal.focus();
	}
	}
}

function setStockDetails(_stock_item_yn, _available_stock){
	if (_stock_item_yn=="N") {
		alert(getMessage("NOT_STOCK_ITEM","ST"));
		refreshDetails();
	}

//	alert(_available_stock);
}

function setMaxReturnableQty(_normal, _bonus){
	document.formGoodsReturnToVendorListHeader.max_item_qty_normal.value=_normal;
	document.formGoodsReturnToVendorListHeader.max_item_qty_bonus.value=_bonus;
}

function ComputeCost() {
	var quantity=document.formGoodsReturnToVendorListHeader.item_qty.value;
	var cost=document.getElementById("id_store_item_unit_cost").innerText;
	if (isNaN(quantity)||isNaN(cost)) {
		document.getElementById("id_item_sal_value").innerText="";
		return;
	}
	var value=quantity*cost
	document.getElementById("id_item_sal_value").innerText=value;
}

function CheckQuantity() {
	if(!checkIntegerFormat(document.formGoodsReturnToVendorListHeader.item_qty))
		return false;

	ComputeCost();
	if(document.formGoodsReturnToVendorListHeader.stock_item_yn.value=="N")
		return true;

	if(parseFloat(document.formGoodsReturnToVendorListHeader.item_qty.value) > parseFloat(document.getElementById("id_stock_available").innerText) ) {
		alert(getMessage("QTY_NOT_GRT_AVLQTY","ST"));
		document.formGoodsReturnToVendorListHeader.item_qty.focus();
		return false;
	}
 }

function CheckValue()
{
	if(document.formGoodsReturnToVendorListHeader.item_cost_value.value!=null)
		if(document.formGoodsReturnToVendorListHeader.item_cost_value.value==0)
			alert(getMessage("CANNOT_BE_ZERO","Common"));
		if(isValidDouble(document.formGoodsReturnToVendorListHeader.quantity));
			ComputeCost();
}

function addToList()
{

 	
	if(parent.parent.frameGoodsReturnToVendorList.frameGoodsReturnToVendorListDetail.document.formGoodsReturnToVendorListDetail !=null)
	{
	var formObj=  parent.frameGoodsReturnToVendorListHeader.document.formGoodsReturnToVendorListHeader;
	var arrayObject = new Array(formObj.item_code);//,formObj.item_qty_normal);
	var names = new Array(getLabel("Common.item.label","Common"));//, "Normal Qty");
	var blankObject = checkSTFields(arrayObject, names, parent.parent.parent.messageFrame);

	if (blankObject==true) {
		formObj.apply.disabled=true;
		var formObjDtl=  parent.parent.frameGoodsReturnToVendorList.frameGoodsReturnToVendorListDetail.document.formGoodsReturnToVendorListDetail;
//		alert(formObjDtl);
		var messageFrame = parent.parent.messageFrame; 
		var errorPage	 = "../../eCommon/jsp/error.jsp"
		var item_qty=0;
		if (formObj.item_qty_normal.value!="") {
			item_qty=parseFloat(item_qty)+parseFloat(formObj.item_qty_normal.value);
		}
		if (formObj.item_qty_bonus.value!="") {
			item_qty=parseFloat(item_qty)+parseFloat(formObj.item_qty_bonus.value);
		}

		if (parseFloat(item_qty)==0) {
			alert(getMessage("NOR_OR_BON_MUST","ST"));
			formObj.apply.disabled=false;
			return;
		}

		var sum=0;
		var proceed=true;
		var totalchk	=	parseFloat(formObjDtl.elements["total_checkboxes"].value);
		for (var i=0;i<totalchk && proceed;i++ ){
			if(formObjDtl.elements["item_qty_"+i].value!=""){
				var qty=formObjDtl.elements["item_qty_"+i].value;
				if (qty=="") 
					qty=0
				if (!isNaN(qty))
					sum+=parseFloat(qty);
			}
		}
 		
		if (!proceed){
			formObj.apply.disabled=false;
			return;
		}
		if (setNumber(sum,parseInt(formObj.no_deci.value))!=setNumber(item_qty,parseInt(formObj.no_deci.value))) {
			alert(getMessage("QUANTIY_MUST_BE_EQUAL","ST"));
			formObj.apply.disabled=false;
			return;
		}
		var xmlHttp = new XMLHttpRequest();
		var xmlDoc="";
		//	xmlDoc.loadXML(getEnhancedXMLString(formObjDtl));
		xmlDoc = new DOMParser().parseFromString(getEnhancedXMLString(formObjDtl), "text/xml");
		//alert(formObj.gen_uom_desc.value);
		/**
			* @Name - Priya 
			* @Date - 17/12/2009
			* @Inc# - IN017176
			* @Desc - To Display the character ® properly in Item desc without junck characters
			* added 'encodeURIComponent(formObj.item_desc.value,"UTF-8")' in the next line code
			*/
		xmlHttp.open("POST", "../../eST/jsp/GoodsReturnToVendorValidate.jsp?index="+formObj.index.value+"&doc_srl_no="+formObj.doc_srl_no.value+"&item_code="+formObj.item_code.value+"&item_desc="+encodeURIComponent(formObj.item_desc.value,"UTF-8")+"&item_qty_normal="+formObj.item_qty_normal.value+"&item_qty_bonus="+formObj.item_qty_bonus.value+"&max_item_qty_normal="+formObj.max_item_qty_normal.value+"&max_item_qty_bonus="+formObj.max_item_qty_bonus.value+"&uom_code="+formObj.uom_code.value+"&remarks="+escape(formObj.remarks.value)+"&uom_desc="+ document.getElementById("id_uom").innerText+"&to_conv_fact="+formObj.tmp_conv.value+"&gen_uom_desc="+formObj.gen_uom_desc.value+"&allow_yn="+formObj.allow_deci_yn.value+"&no_decimals="+formObj.no_deci.value+"&validate=ADD_TO_LIST", false);
		xmlHttp.send(xmlDoc);
		responseText=xmlHttp.responseText;
 
		eval(responseText);
		if( responseText ){
			parent.parent.frameGoodsReturnToVendorHeader.formGoodsReturnToVendorHeader.preview.disabled = false;
			refreshDetails(formObj.index.value);
		}
		else{
			formObj.apply.disabled=false;
			parent.parent.parent.messageFrame.location.href = errorPage+"?err_num="+ getMessage(message,"ST");
//			parent.frameGoodsReturnToVendorListDetail.location.href='../../eCommon/html/blank.html';
		}
	}
	else{
	//	blankObject.focus();
	}

	}
	else
		alert(getMessage("BATCH_DETAILS_NOT_BLANK","ST"));

}

// To refresh detail frame on click of Add
function refreshDetails(index)
{
	//doc_type_code, doc_no
	//parent.parent.frameGoodsReturnToVendorDetail.location.reload();
	var formObj=  parent.frameGoodsReturnToVendorListHeader.document.formGoodsReturnToVendorListHeader;
	parent.parent.frameGoodsReturnToVendorDetail.location.href="../../eST/jsp/GoodsReturnToVendorDetail.jsp?index="+index+"&item_code="+formObj.item_code.value ;
    parent.frameGoodsReturnToVendorListHeader.location.href='../../eST/jsp/GoodsReturnToVendorListHeader.jsp';
	parent.frameGoodsReturnToVendorListDetail.location.href='../../eCommon/html/blank.html';
//	parent.frameGoodsReturnToVendorListDetail.location.href='../../eST/jsp/GoodsReturnToVendorListDetail.jsp';
//	parent.frameGoodsReturnToVendorListDetail.location.reload();
}

async function apply()
{
	var formObj=  f_query_add_mod.frameGoodsReturnToVendorDetail.document.formGoodsReturnToVendorDetail;
	totalCBox	=	parseInt(formObj.total_checkboxes.value);
	var checkBoxObj=null;
	var forDeletion="";
	var noDetailExists	=	true;
	var errorPage	=	"../../eCommon/jsp/error.jsp";


	for(i=0;i<totalCBox;i++)
	{
		checkBoxObj=eval("formObj.checkbox"+i);
		if(checkBoxObj.checked){
			forDeletion+=("Y,");
		}
		else{
			forDeletion+=("N,");
			noDetailExists=false;
		}
	}
	if (noDetailExists){
		messageFrame.location.href = errorPage+"?err_num="+getMessage("MIN_ONE_DETAIL_REQUIRED","Common"); 		
		return;
	}

	var formObj	=	f_query_add_mod.frameGoodsReturnToVendorHeader.document.formGoodsReturnToVendorHeader;
	var arrayObject = new Array(formObj.supp_code);
	var names = new Array(getLabel("Common.Supplier.label","Common"));
	var blankObject = checkSTFields(arrayObject, names, parent.parent.parent.messageFrame);
	
	console.log("Inside GoodsReturnToVendor JS 344 blankObject : "+blankObject);
	
	if (blankObject==true) {
		forDeletion=forDeletion.substring(0,forDeletion.length-1);
		formObj.records_to_delete.value=forDeletion;
		var xmlHttp = new XMLHttpRequest();
		var xmlDoc="";
		//xmlDoc.loadXML(getXMLString(null));
		xmlDoc = new DOMParser().parseFromString(getXMLString(null), "text/xml");
		xmlHttp.open("POST", "../../eST/jsp/GoodsReturnToVendorValidate.jsp?validate=CHECK_AUTHORIZE_ALLOWED&store_code="+formObj.store_code.value, false);
		xmlHttp.send(xmlDoc);
		responseText=xmlHttp.responseText;
		console.log("Inside GoodsReturnToVendor JS 356 responseText : "+responseText);
		eval(responseText);
		console.log("Inside GoodsReturnToVendor JS 358 formObj.finalize_allowed_yn.value : "+formObj.finalize_allowed_yn.value);
		if (formObj.finalize_allowed_yn.value=="Y") {
			console.log("Inside GoodsReturnToVendor JS 360 formObj.entry_completed_yn.checked : "+formObj.entry_completed_yn.checked);
			if (formObj.entry_completed_yn.checked) {				
				
				//added for SKR-CRF-0039 By Ganga on 5th Aug 2013
				var xmlHttp = new XMLHttpRequest();
				var xmlDoc="";
				var xmlStr	="<root><SEARCH " ;
				xmlStr+=" function_type=\"2\" ";		
				xmlStr +=" /></root>" ; 
				xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
				xmlHttp.open("POST", "../../eST/jsp/CommonSearchValidate.jsp?trn_type="+formObj.trn_type.value+"&store_code="+formObj.store_code.value, false);
				xmlHttp.send(xmlDoc);
				responseText = xmlHttp.responseText;
				eval(responseText);		
				
				console.log("Inside GoodsReturnToVendor JS 375 responseText : "+responseText);
				var response = "";
				//response = confirmFinalize(); commented
				if(responseText){
					response = await confirmFinalize();	
				}else{
					response = YES;
				}
				//Added ends	
				
				console.log("Inside GoodsReturnToVendor JS 385 response : "+response);
				
				if (response==YES) {
					formObj.finalized_yn.value="Y";
				}
			}
		}

		var responseText=formApply(formObj,ST_CONTROLLER);
		eval(responseText);
		console.log("Inside GoodsReturnToVendor JS 393 responseText : "+responseText+" flag : "+flag);
     // alert("responseText"+responseText);
//--------
		var flag1 = (flag.split("~"))[0];
		var flag2 = (flag.split("~"))[1];
		flag1 = (flag1=="null"?"":flag1);  
		if(result) {
			if(flag2 == "PY")
				{
				  if(formObj.finalize_allowed_yn.value=="Y")
				  {
   				    var PConfirm = confirmPrinting();
					if (PConfirm == "Yes"){
						var xmlHttp = new XMLHttpRequest();
						var xmlDoc="";
						//xmlDoc.loadXML(getXMLString(null));
						xmlDoc = new DOMParser().parseFromString(getXMLString(null), "text/xml");
						//xmlHttp.open("POST", "../../eST/jsp/GoodsReturnToVendorValidate.jsp?validate=printOnlineDoc&msg="+encodeURIComponent(message), false);
						xmlHttp.open("POST", "../../eST/jsp/GoodsReturnToVendorValidate.jsp?validate=printOnlineDoc&msg="+encodeURIComponent(message), true);
						xmlHttp.send(xmlDoc);
						responseText=xmlHttp.responseText;//anbu
				 //alert(responseText);//anbu
						eval(responseText);//anbu
                  
					   }
					  
				  }
				} else 	if(flag2 == "PN")
				{
						var xmlHttp = new XMLHttpRequest();
						var xmlDoc="";
						//xmlDoc.loadXML(getXMLString(null));
						xmlDoc = new DOMParser().parseFromString(getXMLString(null), "text/xml");
						//xmlHttp.open("POST", "../../eST/jsp/GoodsReturnToVendorValidate.jsp?validate=printOnlineDoc&msg="+encodeURIComponent(message), false);
						xmlHttp.open("POST", "../../eST/jsp/GoodsReturnToVendorValidate.jsp?validate=printOnlineDoc&msg="+encodeURIComponent(message), true);
						xmlHttp.send(xmlDoc);
						responseText=xmlHttp.responseText;//anbu
						eval(responseText);//anbu
 				}
				messageFrame.location.href = errorPage+"?err_num="+ message +"<BR>"+ (result?flag1:"");
				onSuccess();

			}

		if(responseText)
			messageFrame.location.href = errorPage+"?err_num="+ message +"<BR>"+ flag1;
		else
			messageFrame.location.href = errorPage+"?err_num="+ message;
		if(responseText) {
			onSuccess();
		}
//===============
		

/*		messageFrame.location.href = errorPage+"?err_num="+ message +"<BR>"+ ((result)?flag:"");
		if(result) {
			onSuccess();
		}*/


		else{
			if (flag!="") {
				f_query_add_mod.frameGoodsReturnToVendorDetail.location.href="../../eST/jsp/GoodsReturnToVendorDetail.jsp?function_id="+function_id+"&item_code="+flag;
			}
		}
	}
	else{
		//blankObject.focus();
	}
}

function setFinalize_allowed(_finalize_allowed_yn){
	f_query_add_mod.frameGoodsReturnToVendorHeader.document.formGoodsReturnToVendorHeader.finalize_allowed_yn.value=_finalize_allowed_yn;
}

function cancel_me()
{
	parent.frameGoodsReturnToVendorListHeader.location.href="../../eST/jsp/GoodsReturnToVendorListHeader.jsp";
	parent.parent.frameGoodsReturnToVendorList.frameGoodsReturnToVendorListDetail.location.href="../../eCommon/html/blank.html";

}


function checkBatchQty(obj, available_qty){
	if (checkDoubleFormat(obj)){
		if (parseFloat(available_qty)<parseFloat(obj.value)) {
			alert(getMessage("QTY_GREATER_THAN_AVAIL","ST"));
			obj.focus();
		}
	}
}

function checkRemarksLength(obj){
	if(!setTextAreaMaxLength(obj, 200)){
		alert(getMessage("REMARKS_CHAR_EXCEEDS_LIMIT","ST"));
		obj.focus();
	}
}


async function callRTVBatchSearch() {
	var formObj=document.formGoodsReturnToVendorListHeader;
	var arrayObject = new Array(parent.parent.frameGoodsReturnToVendorHeader.document.formGoodsReturnToVendorHeader.supp_code, formObj.item_code);
//	var names = new Array("Supplier", "Item");
	var names = new Array(getLabel("Common.Supplier.label","Common"),getLabel("Common.item.label","Common"));
	var blankObject = checkSTFields(arrayObject, names, parent.parent.parent.messageFrame);

	if (blankObject==true) {
		if (parent.frameGoodsReturnToVendorListDetail.document.formGoodsReturnToVendorListDetail!=null)
			if(!confirm(getMessage("BATCH_REFRESHED","ST")))
				return;

		var _store_code = parent.parent.frameGoodsReturnToVendorHeader.document.formGoodsReturnToVendorHeader.store_code.value;
		var _supp_code = parent.parent.frameGoodsReturnToVendorHeader.document.formGoodsReturnToVendorHeader.supp_code.value;
		var doc_type_code = parent.parent.frameGoodsReturnToVendorHeader.document.formGoodsReturnToVendorHeader.doc_type_code.value;
		var doc_no = parent.parent.frameGoodsReturnToVendorHeader.document.formGoodsReturnToVendorHeader.doc_no.value;
		var trn_type = parent.parent.frameGoodsReturnToVendorHeader.document.formGoodsReturnToVendorHeader.trn_type.value;
		 var  total_qty;// added GHL-CRF-496;
		var _item_code     = formObj.item_code.value ;
		var xmlHttp = new XMLHttpRequest();
		//var xmlDoc="";
			//xmlDoc.loadXML(getXMLString(null));
			var xmlDoc = new DOMParser().parseFromString(getXMLString(null), "text/xml");
		xmlHttp.open("POST", "../../eST/jsp/GoodsReturnToVendorValidate.jsp?validate=StoreTotalBatchQty"+"&store_code="+_store_code+"&item_code="+_item_code, false);
		xmlHttp.send(xmlDoc);
		var responseText=xmlHttp.responseText;
		eval(responseText);
		if(responseText){
			var resultArray1;
			resultArray1 = message.split(";");
			total_qty = 	resultArray1[3];
		}//end GHL-CRF-496  
		

		var batch_retval="";
		batch_retval=await callRTVBatchSearchWindow(_item_code,_store_code, _supp_code,doc_type_code,doc_no,trn_type,total_qty);//added parameter total_qty fot GHL-CRF-496 
		//alert(batch_retval);
        /*if (batch_retval==""){
			return ;
		}*/

		if (batch_retval!=null && batch_retval!="" && batch_retval!=undefined){
			parent.frameGoodsReturnToVendorListDetail.location.href="../../eST/jsp/GoodsReturnToVendorListDetail.jsp?index="+formObj.index.value+"&function_id"+parent.parent.function_id+"&item_code="+_item_code;

		}
	}
}

async function  callRTVBatchSearchWindow(item_code,_store_code,_supp_code,doc_type_code,doc_no,trn_type,tot_qty){//added parameter tot_qty for GHL-CRF-496 
   //alert(doc_type_code+"="+doc_no+"="+trn_type);	
   retVal=await top.window.showModalDialog("../../eST/jsp/BatchSearchGoodsReturnToVendorFrame.jsp?item_code="+item_code+"&store_code="+_store_code+"&supp_code="+_supp_code+"&doc_type_code="+doc_type_code+"&doc_no="+doc_no+"&trn_type="+trn_type+"&tot_qty="+tot_qty,'','dialogHeight:70vh; dialogWidth:80vw; center:0; status: no; dialogLeft :0vw; dialogTop :0vh;');//tot_qty added for GHL-CRF-496 
   //   	retVal=window.open("../../eST/jsp/BatchSearchGoodsReturnToVendorFrame.jsp?item_code="+item_code+"&store_code="+_store_code+"&supp_code="+_supp_code,'','dialogHeight:30; dialogWidth:50; center:0; status: no; dialogLeft :200; dialogTop :100;');
   return retVal ;   
}

function modifyData(index){
//	alert(index);
	var trObject = eval(document.getElementById("tr_"+index));
	changeRowColor(trObject);
	parent.frameGoodsReturnToVendorList.location.href="../../eST/jsp/GoodsReturnToVendorListFrame.jsp?function=modify&index="+index+"&function_id="+parent.parent.function_id;
}

function Modify(obj){
	/**
	* @Name - Priya
	* @Date - 22/12/2009
	* @Inc# - IN017084
	* @Desc - To avoid the duplication records display in Modify mode
	*/
	var errorPage = "../../eCommon/jsp/error.jsp";
	document.getElementById("readOnlyDiv").style.visibility='visible';
	parent.parent.messageFrame.location.href = errorPage + "?err_num="+getMessage("ST_PROCESSING_WAIT", "ST");
	
	var doc_no =obj.cells[1].innerText;
	var doc_type_code =obj.cells[4].innerText;
	parent.document.location.href="../../eST/jsp/GoodsReturnToVendorFrame.jsp?mode="+MODE_MODIFY+"&function_id="+parent.parent.function_id+"&doc_type_code="+doc_type_code+"&doc_no="+doc_no;
}

function chkTextAreaMaxLength(obj, len)
{
	if(!setTextAreaMaxLength(obj, len))
		alert(getMessage("REMARKS_NOT_EXCEED_200_CH","ST") );
		//alert(getMessage("EXCEED_MAX_LENGTH") + " of 200 characters");
}

function isQtyWithinLimit(obj, maxObj){
	if (parseFloat(obj.value)>parseFloat(maxObj.value)){
		alert(getMessage("TFR_QTY_LESS_THAN_AVL_QTY","ST"));
		obj.focus();
	}
}

async function previewDetails(){
	
	var store_code	 =document.formGoodsReturnToVendorHeader.store_code.value;
	var doc_type_code=document.formGoodsReturnToVendorHeader.doc_type_code.value;

	var supplier = document.formGoodsReturnToVendorHeader.supp_code.options[document.formGoodsReturnToVendorHeader.supp_code.options.selectedIndex].text;
	var retVal="";
	var dialogHeight= "70vh" ;
	var dialogWidth	= "60vw" ;
	var dialogTop = "0vh" ;
	var center = "1" ;
	var status="no";
	var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; scroll: no " + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop;
	var arguments	= "" ;
	var url = "../../eST/jsp/RtvPreviewDetails.jsp?store_code="+store_code+"&doc_type_code="+doc_type_code+"&supplier="+supplier;
	retVal = await window.showModalDialog(url,arguments,features);
}

var prevObj=null;
var prevColor=null;
function changeRowColor(obj) {
	tot = document.forms[0].total_checkboxes.value;
	tot = tot - 1;
	

	if(prevObj!=null){

	for( k=0;k<2;k++)
			prevObj.cells[k].className=prevColor;
	}
	prevObj=obj;
	prevColor=obj.cells[1].className;
	for( k=0;k<2;k++)
		obj.cells[k].className="STLIGHTPINK";
}

function setMyValue()
{
  var formObject = document.formGoodsReturnToVendorHeader ;
  if(formObject.replacement_grn_yn.checked==true)
       formObject.replacement_grn_yn.value = "Y" ;
  else
       formObject.replacement_grn_yn.value = "N" ;
}
function setTempConvFactor(tmp){
	//alert("set temp==>"+tmp);
	if(document.formGoodsReturnToVendorListHeader==null){
		parent.frames[2].frames[0].document.formGoodsReturnToVendorListHeader.tmp_conv.value = tmp;
	}
	else{
		document.formGoodsReturnToVendorListHeader.tmp_conv.value = tmp;
	}
}
function issueUOMQtyChk(){


	if(parent.parent.frames[2].frames[1].document.formGoodsReturnToVendorListDetail!=null){
		toConvFactor();
		var item_qty_normal =0;
		var item_qty_bonus =0;
		var formObj=  document.formGoodsReturnToVendorListHeader;
		if(formObj.item_qty_normal.value=="")
			item_qty_normal=0;
		else 
			item_qty_normal=eval(formObj.item_qty_normal.value);
		if(formObj.item_qty_bonus.value=="")
			item_qty_bonus=0;
		else
			item_qty_bonus=eval(formObj.item_qty_bonus.value);
		var pur_uom_conv = parent.parent.frames[2].frames[1].document.formGoodsReturnToVendorListDetail.pur_uom_conv.value;
		var dec_factor=((item_qty_normal+item_qty_bonus)*pur_uom_conv)%(formObj.tmp_conv.value);
		/*if(formObj.dec_allowed_yn.value=="N"){
		if(dec_factor>1){
			alert("Quantity Should Be In Multiples Of "+formObj.tmp_conv.value);
			return false;
		}else
			return true;
		}*/
		return true;
	}else{
		alert(getMessage("BATCH_DETAILS_NOT_BLANK","ST"));
		return false;
	}
}
function toConvFactor(){
	var formObj	=	document.formGoodsReturnToVendorListHeader;
	var item_code="";
	if(formObj==null){
		formObj=parent.frames[2].frames[0].document.formGoodsReturnToVendorListHeader;
		var store_code=parent.frameGoodsReturnToVendorHeader.document.formGoodsReturnToVendorHeader.store_code.value;
	}else{
		var store_code=parent.parent.frameGoodsReturnToVendorHeader.document.formGoodsReturnToVendorHeader.store_code.value;
	}
	item_code=formObj.item_code.value;
	if(parent.frameGoodsReturnToVendorDetail!=null){
		var formObj1	=	parent.frameGoodsReturnToVendorDetail.document.formGoodsReturnToVendorDetail;
		item_code		=	formObj1.item_code.value;
	}
	var xmlHttp = new XMLHttpRequest();
	var xmlDoc="";
		//xmlDoc.loadXML(getXMLString(null));
		var xmlDoc = new DOMParser().parseFromString(getXMLString(null), "text/xml");
	xmlHttp.open("POST", "../../eST/jsp/GoodsReturnToVendorValidate.jsp?validate=setToConv"+"&store_code="+store_code+"&item_code="+item_code, false);
	xmlHttp.send(xmlDoc);
	var responseText=xmlHttp.responseText;
//	alert(responseText);
	eval(responseText);
}
function dispMess(id){
		alert(getMessage("PHY_INV_PROCESS_INITIATED","ST")+"\n"+getLabel("eST.PhyInventoryID.label","ST")+":"+id);
}
async function searchRemarks(objCode,objDesc)
{
	
	var argumentArray		 =		 new Array();
	var dataNameArray		 =		 new Array();
	var dataValueArray		 =		 new Array();
	var dataTypeArray		 =		 new Array();

	dataNameArray[0]		 =		"language_id" ;
	dataValueArray[0]        =		document.formGoodsReturnToVendorListHeader.lang_id.value;
	dataTypeArray[0]		 =		STRING ;

	dataNameArray[1]		 =		"module_id" ;
	dataValueArray[1]		 =		"ST";
	dataTypeArray[1]		 =		STRING ; 
	

	dataNameArray[2]		 =		"trn_type" ;
	dataValueArray[2]		 =		document.formGoodsReturnToVendorListHeader.rem_trans_type.value;
	dataTypeArray[2]		 =		STRING ;
	
	argumentArray[0]		 =		document.formGoodsReturnToVendorListHeader.SQL_ST_TRN_REMARKS_LOOKUP_SELECT.value;	
	argumentArray[1]		 =		dataNameArray;
	argumentArray[2]		 =		dataValueArray;
	argumentArray[3]		 =		dataTypeArray;
	argumentArray[4]		 =		 "4,5";
	argumentArray[5]		 =		objDesc.value;
	argumentArray[6]		 =		CODE_LINK;
	argumentArray[7]		 =		CODE_DESC;
	returnedValues			 =		await CommonLookup( getLabel("Common.remarks.label","Common"), argumentArray );	
var ret1=unescape(returnedValues);
	//alert("ret1"+ret1);
		 	var arr=ret1.split(",");
		 	if(arr[1]==undefined) 
	 		{
		 		arr[0]="";	
		 		arr[1]="";	
	 		}
	if((returnedValues != null) && (returnedValues != "") )  {
		objCode.value		 =		arr[0];
		objDesc.value		 =		arr[1];
	
	} 
	
}

	/**
	* @Name - Priya
	* @Date - 22/12/2009
	* @Inc# - IN017084
	* @Desc - To avoid the duplication records display in Modify mode
	*/
function clearMessageFrame(){
var errorPage = "../../eCommon/jsp/error.jsp";
parent.messageFrame.location.href = errorPage + "?err_num=";
}
function setDecimalParameters(allow_yn,no_decimals,frmObject) {
		
	
		frmObject.allow_deci_yn.value = allow_yn;
		frmObject.no_deci.value = no_decimals;

}
function allow_restrict_decimals(obj,event)
{
var allow_yn =	document.formGoodsReturnToVendorListHeader.allow_deci_yn.value ;
var  no_decimals = document.formGoodsReturnToVendorListHeader.no_deci.value ;

 if(allow_yn=='N')
	   obj.onkeypress=function(){return isValidInteger()};
	
	if(allow_yn=='Y')
	{
	   obj.onkeypress=function(){return isValidNumber(obj,event,12,parseInt(no_decimals))};
      
	}
}//formGoodsReceivedNoteListDetail
function allow_restrict_decimals1(obj,event)
{
	
var allow_yn =	document.formGoodsReturnToVendorListDetail.allow_deci_yn.value ;
var  no_decimals = document.formGoodsReturnToVendorListDetail.no_deci.value ;
if(allow_yn=='N')
obj.onkeypress=function(){return isValidInteger()};

if(allow_yn=='Y')
	   obj.onkeypress=function(){return isValidNumber(obj,event,12,parseInt(no_decimals))};
}

/**
	* @Name - Mahesh
	* @Date - 13/01/2010
	* @Inc# - IN015496
	* @Desc - function to validate decimal numbers for cost value
	*/
function isValidNumberCost(fld, e, maxInt, deci) {
	

	/*var disp_allowed_yn = "Y";
	if(document.forms[0].dec_allowed_yn!=undefined){
		disp_allowed_yn = document.forms[0].dec_allowed_yn.value;
	}
	if(disp_allowed_yn=="N"){
		deci = 0;
	}		*/
	var count = fld.value.length;
	var whichCode = (window.Event) ? e.which : e.keyCode;
	if (count >= maxInt) {
		if (count == maxInt) {
			var dotOccurance = fld.value.indexOf(".");
			if (((dotOccurance >= maxInt) || (dotOccurance == -1)) && (count == maxInt)) {
				if (whichCode != 46) {
					if (deci > 1) {
						fld.value = fld.value + ".";
					}
				}
			}
		} else {
			if (count > maxInt) {
				var objectValue = fld.value;
				var dotOccurance = objectValue.indexOf(".");
				if ((objectValue.charAt(maxInt)) != ".") {
					if (dotOccurance == -1) {
						if (deci != 0) {
							fld.value = objectValue.substring(0, maxInt) + ".";
						} else {
							fld.value = objectValue.substring(0, maxInt);
						}
						return false;
					}
				}
			}
		}
	}
	var strCheck = ".0123456789";
	if (deci == 0) {
		strCheck = "0123456789";
	}
	var fldvalue = fld.value;
	var whichCode = (window.Event) ? e.which : e.keyCode;
	if (whichCode == 13) {
		return true;  // Enter
	}
	var pointCount = 0;
	for (var i = 0; i < fldvalue.length; i++) {
		if (fldvalue.charAt(i) == ".") {
			pointCount++;
		}
	}
	if (pointCount > 0 && whichCode == 46) {
		return false;
	}
	var fldValue = fld.value;
	var dotIndex = fldValue.indexOf(".");
	var fldLength = fldValue.length;
	if (dotIndex != -1) {
		if (fldLength > (dotIndex + deci)) {
			return false;
		}
	}
	key = String.fromCharCode(whichCode);  // Get key value from key code
	if (strCheck.indexOf(key) == -1) {
		return false;  // Not a valid key
	}
	return true;
}
function getGTINDetails (e,barcode){//Adding start for MOHE-CRF-0167
	if(e.keyCode==9 || e.keyCode== 13  || e.keyCode== 0){
		var xmlHttp = new XMLHttpRequest();
		var xmlDoc="";
		var item_code = document.formGoodsReturnToVendorListHeader.item_code.value;
		var store_code =parent.parent.frameGoodsReturnToVendorHeader.formGoodsReturnToVendorHeader.store_code.value;
	//	xmlDoc.loadXML(getXMLString(null));
	xmlDoc = new DOMParser().parseFromString(getXMLString(null), "text/xml");
		xmlHttp.open("POST", "../../eST/jsp/GoodsReturnToVendorValidate.jsp?&barcode=" + barcode.value+"&item_code="+item_code +"&store_code="+store_code+"&validate=GET_GTIN", false);
		xmlHttp.send(xmlDoc);
		responseText = xmlHttp.responseText;
		eval(responseText);
		if(responseText){
			
			callItemSearchScreen("BARCODE",barcode.value);
			
			if(document.formGoodsReturnToVendorListHeader.item_code.value!="" && message=="")
			 document.formGoodsReturnToVendorListHeader.batch_search.onclick();
			
		}else{
			if(item_code==""){
			document.formGoodsReceivedNoteListHeader.barcode.value = "";
			 alert(getMessage(message, "ST"));
			}
		}
		
	}
}//Adding end for MOHE-CRF-0167
