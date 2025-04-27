
function reset() {
	f_query_add_mod.frameProductComplaintCriteria.location.reload();
	f_query_add_mod.frameProductComplaintResult.location.href = "../../eCommon/html/blank.html";
	messageFrame.location.href = "../../eCommon/jsp/error.jsp";
}

async function callItemSearchScreen(objDesc,objCode) {
	var search_string = objDesc.value;
	var store_code = "";
	var category = "A";
	var sole_source = "A";
	var ps_item = "A";
	var mfg_item = "A";
	var expiry = "A";
	var consignment = "A";
	var item_class = "";
	var retValue =await callItemSearchWindow(search_string, store_code, category, sole_source, ps_item, mfg_item, expiry, item_class, consignment);
	if (retValue != null) {
		objCode.value = retValue[0];
		objDesc.value = retValue[1];
		document.getElementById("uom").innerText = retValue[15];
		document.getElementById("exp_id").innerText = getLabel("Common.Expiry.label", "Common");
		if (retValue[2] == "Y") {
			document.getElementById("exp_data").innerHTML = "<img src='../../eCommon/images/enabled.gif' align=center>";
		} else {
			document.getElementById("exp_data").innerHTML = "<img src='../../eCommon/images/disabled.gif' align=center>";
		}
		document.ProductComplaintCriteriaForm.item_desc.readOnly = true;		
		document.ProductComplaintCriteriaForm.show_batches.disabled = false;
		document.ProductComplaintCriteriaForm.uom_desc.value = retValue[15];
	}

	var xmlHttp = new XMLHttpRequest();
	var xmlDoc="";
	//xmlDoc.loadXML(getXMLString(null));
	xmlDoc = new DOMParser().parseFromString(getXMLString(null),"text/xml");
	xmlHttp.open("POST", "../../eST/jsp/ProductComplaintValidate.jsp?item_code=" + objCode.value, false);
	xmlHttp.send(xmlDoc);
	responseText = xmlHttp.responseText;
	document.ProductComplaintCriteriaForm.manufacturer.focus();
	eval(responseText);
	if (!result) {
		parent.parent.messageFrame.location.href = "../../eCommon/jsp/error.jsp?";
	}
}

function PrintWorkSheet(batch_id,expiry_date,trade_id) {
	var objform =document.ProductComplaintResultPrintForm;
	objform.p_batch_id.value = batch_id;
	objform.p_expiry_date.value = expiry_date;
	objform.p_trade_id.value = trade_id;
	//alert("p_batch_id== "+objform.p_batch_id.value);
	//alert("p_expiry_date== "+objform.p_expiry_date.value);
	//alert("p_trade_id== "+objform.p_trade_id.value);
	objform.submit();
}

var prevObj = null;
var prevColor = null;
function changeRowColor(obj) {
	if (prevObj != null) {
		for (k = 0; k < prevObj.cells.length; k++) {
			prevObj.cells(k).className = prevColor;
		}
	}
	prevObj = obj;
	prevColor = obj.cells(1).className;
	for (k = 0; k < prevObj.cells.length; k++) {
		obj.cells(k).className = "STLIGHTPINK";
	}
}
