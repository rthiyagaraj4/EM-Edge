async function openAddPPN(patientId,orderId,params){

	var dialogHeight	= "30vh" ;
	var dialogWidth		= "64vw";
	var dialogTop		= "290" ;
	var dialogLeft		= "200" ;
	var center			= "0" ;
	var status			= "no";
	var features		= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop;
	var arguments		= "" ;
	//window.open("../../ePH/jsp/PPNRegimenLookupFrames.jsp?patientId="+patientId+"&orderId="+orderId,arguments,features);
	var retVal			= await window.showModalDialog("../../ePH/jsp/PPNRegimenLookupFrames.jsp?patientId="+patientId+"&orderId="+orderId,arguments,features);

	if(retVal != undefined && retVal == 'success')
	{
		parent.f_disp_medication_header.location.href="../../ePH/jsp/DispMedicationHeader.jsp?"+params;
		parent.f_disp_medication_filling.location.href="../../ePH/jsp/DispMedicationFilling.jsp?patient_id="+patientId+"&encounter_id=DUMMYENCOUNTERID&order_id="+orderId;
	}
}

function openRemovePPN(params)
{
	if(confirm(getMessage("PPN_REMOVE_CONFIRM","PH")))
	{
		var bean_id		= "DispMedicationBean";
		var bean_name	= "ePH.DispMedicationBean";
		var xmlDoc  = "";
		var xmlHttp = new XMLHttpRequest() ;
		var xmlStr ="<root><SEARCH ";
		xmlStr +=" /></root>";
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open("POST","DispMedicationValidate.jsp?bean_id="+bean_id+"&bean_name="+bean_name+"&identity=RemovePPNValues",false);
		xmlHttp.send( xmlDoc ) ;
		eval(xmlHttp.responseText);
		parent.f_disp_medication_header.location.href="../../ePH/jsp/DispMedicationHeader.jsp?PPNFlag=RMPPN&"+params;
	}
}

function searchPPN(patientId,orderId)
{
	var formObj			= document.PPNSearchCriteria;
	var searchBy		= formObj.searchBy.value;
	var searchText		= formObj.search_text.value;
	var searchCriteria	= formObj.search_criteria.value;

	parent.PPNSearchResult.location.href="../../ePH/jsp/PPNSearchResult.jsp?patientId="+patientId+"&orderId="+orderId+"&searchBy="+searchBy+"&searchText="+searchText+"&searchCriteria="+searchCriteria;
}

function storeVal(obj)
{
	document.PPNSearchCriteria.searchBy.value = obj.value;
}

async function callBatchSearchForPPN(item_code,store_code,index) 
{

	var store_code					=	store_code;
	var item_code					=	item_code;
	var includeZeroStockBatches		= "N";
	var includeExpiredBatches		= "N";
	var includeSuspendedBatches		= "N";
	var searchFunction				= "Y";
	var multipleSelect				= "N";
	var trade_code					= "";
	var allowchangetradenameyn		= "N";
	var allowmultitradeyn			= "N"
	var end_date					="";
	var allow_short_expiry_drugs_yn ="Y";

	var dialogHeight	= "30vh" ;
	var dialogWidth		= "60vw";
	var dialogTop		= "100" ;
	var dialogLeft		= "200" ;
	var center			= "0" ;
	var status			= "no";
	var features		= "dialogHeight:" + dialogHeight +"; dialogLeft"+dialogLeft+ "; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop;
	var arguments		= "";
	
	var retVal=await window.showModalDialog("../../eST/jsp/BatchSearchFrame.jsp?item_code="+item_code+"&store_code="+store_code+"&includeZeroStockBatches="+includeZeroStockBatches+"&includeExpiredBatches="+includeExpiredBatches+"&includeSuspendedBatches="+includeSuspendedBatches+"&searchFunction="+searchFunction+"&multipleSelect="+multipleSelect+"&trade_code="+trade_code+"&p_list_all_trades_yn="+allowchangetradenameyn+"&p_multi_trade_select_yn="+allowmultitradeyn,arguments,features);
	
//alert('<<< retVal '+ retVal);
	if(retVal!=undefined && retVal!='') {
		var batchDetails = retVal.split("`");
		var batchId		 = batchDetails[0];
		var batchQty	 = batchDetails[15];
		var tradeId		 = batchDetails[9];
		var mfgId		 = batchDetails[13];

		var formObj		 = document.PPNSearchResult;
		if(formObj.totalItems.value == '1')
		{
			formObj.BatchId.value = batchId;
			formObj.TradeId.value = tradeId;
			formObj.ManufacturerId.value = mfgId;
			formObj.AvailQty.value = batchQty;
			formObj.batchSearch.value = batchId;
			document.getElementById("dispAvailQty").innerText = batchQty;

		}
		else
		{
			formObj.BatchId[index].value = batchId;
			formObj.TradeId[index].value = tradeId;
			formObj.ManufacturerId[index].value = mfgId;
			formObj.AvailQty[index].value = batchQty;
			formObj.batchSearch[index].value = batchId;
			document.getElementById("dispAvailQty")[index].innerText = batchQty;
		}

	}

}

function checkWithMaxQty(index, obj)
{
	var formObj		 = document.PPNSearchResult;
	if(formObj.totalItems.value == '1')
	{
//alert(' obj value '+ obj.value +" == AvailQty "+ formObj.AvailQty.value);
		if(parseInt(obj.value) > parseInt(formObj.AvailQty.value))
		{
			alert(getMessage("PH_ALLOC_QTY_LESS_AVAIL_QTY","PH"));
			obj.value = '';
			obj.focus();
		}

	}
	else
	{
//alert(' obj value 22 '+ obj.value +" == AvailQty22 "+ formObj.AvailQty[index].value);
		if(parseInt(obj.value) > parseInt(formObj.AvailQty[index].value))
		{
			alert(getMessage("PH_ALLOC_QTY_LESS_AVAIL_QTY","PH"));
			obj.value = '';
			obj.focus();
		}
	}
}

async function displayConstInPPN(regimenCode)
{  
	var regcode =regimenCode;
	var dialogHeight	 = "30vh";
	var dialogWidth	= "50vw";
	var dialogTop	= "199";
	var center		= "1";
	var status		= "no";
	var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop;
	await window.showModalDialog("../../ePH/jsp/TPNRegStdRegConsFrame.jsp?RegimenCode="+regcode,arguments,features);
}

function returnPPNValues(index)
{
	var formObj		 = document.PPNSearchResult;	
	var selectedQtyObj;
	var all_stages_bean_id			= "DispMedicationAllStages" ;
	var	all_stages_bean_name		=	"ePH.DispMedicationAllStages";
	
	if(formObj.totalItems.value == '1')
		selectedQtyObj	 = formObj.selectQty; 
	else
		selectedQtyObj	 = formObj.selectQty[index]; 

	if(selectedQtyObj == undefined || selectedQtyObj.value == '' || parseInt(selectedQtyObj.value) < 1 )
	{
		alert(getMessage("PH_ISSUE_QTY_BLANK","PH"));
		selectedQtyObj.focus();
		return;		
	}
	else
	{
		var batchId		 = '';
		var batchQty	 = '';
		var tradeId		 = '';
		var mfgId		 = '';
		var orderId		 = formObj.OrderId.value;  
		var patientId	 = formObj.PatientId.value;  
		var selectedQty	 = '';
		var formObj		 = document.PPNSearchResult;
		var UOMCode		 = '';		
		var itemCode	 = '';
		var itemDesc	 = '';
		var expiryDate	 = '';
		var binLocation	 = '';

		if(formObj.totalItems.value == '1')
		{
			itemCode	 = formObj.ItemCode.value;  
			itemDesc	 = formObj.ItemDesc.value;  
			batchId		 = formObj.BatchId.value;  
			batchQty	 = formObj.AvailQty.value;  
			tradeId		 = formObj.TradeId.value;  
			mfgId		 = formObj.ManufacturerId.value;  
			UOMCode		 = formObj.UOMCode.value;  
			expiryDate	 = formObj.ExpiryDate.value;  
			binLocation	 = formObj.BinLocation.value;  
			selectedQty	 = selectedQtyObj.value;  
		}
		else
		{
			itemCode	 = formObj.ItemCode[index].value;  
			itemDesc	 = formObj.ItemDesc[index].value;  
			batchId		 = formObj.BatchId[index].value;  
			batchQty	 = formObj.AvailQty[index].value;  
			tradeId		 = formObj.TradeId[index].value;  
			mfgId		 = formObj.ManufacturerId[index].value;  
			UOMCode		 = formObj.UOMCode[index].value;  
			expiryDate	 = formObj.ExpiryDate[index].value;  
			binLocation	 = formObj.BinLocation[index].value; 
			selectedQty	 = selectedQtyObj.value; 
		}


		var bean_id		= "DispMedicationBean";
		var bean_name	= "ePH.DispMedicationBean";
		var xmlDoc  = "";
		var xmlHttp = new XMLHttpRequest() ;
		var xmlStr ="<root><SEARCH ";
		xmlStr += " all_stages_bean_id=\"" + all_stages_bean_id + "\"";
		xmlStr += " all_stages_bean_name=\"" + all_stages_bean_name + "\"";
		xmlStr += " itemCode=\""+itemCode+"\"";
		xmlStr += " itemDesc=\""+itemDesc+"\"";
		xmlStr += " batchId=\""+batchId+"\"";
		xmlStr += " batchQty=\""+batchQty+"\"";
		xmlStr += " mfgId=\""+mfgId+"\"";
		xmlStr += " tradeId=\""+tradeId+"\"";
		xmlStr += " orderId=\""+orderId+"\"";
		xmlStr += " UOMCode=\""+UOMCode+"\"";
		xmlStr += " patientId=\""+patientId+"\"";
		xmlStr += " selectedQty=\""+selectedQty+"\"";
		xmlStr += " expiryDate=\""+expiryDate+"\"";
		xmlStr += " binLocation=\""+binLocation+"\"";
		xmlStr +=" /></root>";
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open("POST","DispMedicationValidate.jsp?bean_id="+bean_id+"&bean_name="+bean_name+"&identity=AddPPNValues",false);
		xmlHttp.send( xmlDoc ) ;
		eval(xmlHttp.responseText);
	}
	window.returnValue = "success";
	window.close();

}

async function openPPNDisplay(patientId,orderId,dispLocn,disChargeInd){
	if(disChargeInd == undefined || disChargeInd == null)
		disChargeInd = "";
	var dialogHeight	= "30vh" ;
	var dialogWidth		= "40vw";
	var dialogTop		= "290" ;
	var dialogLeft		= "200" ;
	var center			= "0" ;
	var status			= "no";
	var features		= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop;
	var arguments		= "" ;
	var retVal			= await window.showModalDialog("../../ePH/jsp/PPNOrderDeails.jsp?patientId="+patientId+"&orderId="+orderId+"&disp_locn_code="+dispLocn+"&disChargeInd="+disChargeInd,arguments,features);
}
