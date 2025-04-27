/*
---------------------------------------------------------------------------------------------------------
Date			Edit History    	Name		Rev. Date		Rev. By			Description
---------------------------------------------------------------------------------------------------------
06/02/2017		IN0061922		Badmavathi B					GHL-CRF-0413.5 - Barcode search
02/Aug/2017		IN064206		Chithra M 						GHL-CRF-0462

02/Nov/2017             IN064982                Sharanraj                                        GHL-CRF-0483
08/10/2018		IN068772		Sharanraj       08/10/2018
24/09/2020      IN074078         Haribabu       24/09/2020                       SKR-SCF-1441
30/12/2020      TFSid:11896      B Haribabu          30/12/2020          ST-MMS-DM-CRF-0174.2/03(TF) - Request Issue
27/07/2022		34089			Ramesh G								PMG2022-COMN-CRF-0044

---------------------------------------------------------------------------------------------------------
*/ 
var prevObj = null; 
var prevColor = null;
var doc_no = "";
var l_bill_doc_num = "";
var l_slmt_reqd_yn = "";
var l_bill_doc_type = "";
var maxReturnableQuantity = "";
var item_sal_value = "";
var Finilize = "";
var doc_no = "";
var v_blng_group_id = "";
var message_bill = "";
var total_gross_charge_amt=0;
var total_net_charge_amt=0;
var encounterchk = "";

function create() {
	f_query_add_mod.location.href = "../../eST/jsp/SalesReturnFrame.jsp?mode=" + MODE_INSERT + "&function_id=" + function_id;
}
function query() {
	f_query_add_mod.location.href = "../../eST/jsp/SalesReturnQueryFrame.jsp?mode=" + MODE_MODIFY + "&function_id=" + function_id;
}
function reset() {
	f_query_add_mod.location.reload();
}
function deleterecord() {
	if(  f_query_add_mod.frameSalesReturnHeader==undefined){
		messageFrame.location.href ="../../eCommon/jsp/error.jsp?err_num=";
		return;
	}
	var errorPage = "../../eCommon/jsp/error.jsp";
	var formObj = f_query_add_mod.frameSalesReturnHeader.document.formSalesReturnHeader;
	var prevMode = formObj.mode.value;
	if (prevMode == MODE_INSERT) {
		messageFrame.location.href = errorPage + "?err_num=" + getMessage("OPER_CANCELLED", "ST");
		return;
	}
	formObj.mode.value = MODE_DELETE;
if(formObj.srt_delete_yn.value=="N"){
	messageFrame.location.href = "../../eCommon/jsp/error.jsp?error_value=0&err_num="+getMessage("NO_DELETE_ACCESS_FOR_USER", "ST");
	formObj.mode.value = MODE_MODIFY;
		return false;
}


	if (confirmDelete() != YES) {
		messageFrame.location.href = errorPage + "?err_num=" + getMessage("OPER_CANCELLED", "ST");// + "<BR>" + flag;
		formObj.mode.value = MODE_MODIFY;
		return;
	}
	var responseText = formApply(formObj, ST_CONTROLLER);
	eval(responseText);
	messageFrame.location.href = errorPage + "?err_num=" + message + "<BR>" + flag;
	if (result) {
		onSuccess();
	} else {
		formObj.mode.value = prevMode;
	}
}
function callBillingHdrProcedure() {
	if (document.formSalesReturnHeader.chargeable_yn.value == "Y") {
		if (document.formSalesReturnHeader.sal_trn_type.value != "R" && (document.formSalesReturnHeader.patient_name.value.length > 0) && (document.formSalesReturnHeader.patient_id.value.length > 0) && document.formSalesReturnHeader.encounter_id.value > 0) {
			var formObj = document.formSalesReturnHeader;
	//document.formSalesHeader.sal_trn_type.disabled = false;
			var patient_id = document.formSalesReturnHeader.patient_id.value;
			var sal_trn_type = document.formSalesReturnHeader.sal_trn_type.value;
			var encounter_id = document.formSalesReturnHeader.encounter_id.value;
			var xmlHttp = new XMLHttpRequest();
			var xmlDoc="";
			xmlDoc.loadXML(getXMLString(null));
			xmlHttp.open("POST", "../../eST/jsp/SalesReturnValidate.jsp?patient_id=" + patient_id + "&sal_trn_type=" + sal_trn_type + "&encounter_id=" + encounter_id + "&validate=HEADER_PROCEDURE", false);
			xmlHttp.send(xmlDoc);
			responseText = xmlHttp.responseText;
			eval(responseText); 
		}
	}
}
function viewCharges() {
	var formObj = document.formSalesReturnListHeader;
	var xmlHttp = new XMLHttpRequest();
	var xmlDoc="";
	var patient_id = parent.parent.frameSalesReturnHeader.document.formSalesReturnHeader.patient_id.value;
	var encounter_id = parent.parent.frameSalesReturnHeader.document.formSalesReturnHeader.encounter_id.value;
	var sal_trn_type = parent.parent.frameSalesReturnHeader.document.formSalesReturnHeader.sal_trn_type.value;
	if ((formObj.item_qty.value) != "") {
	calTotalQty();
		xmlDoc.loadXML(getXMLString(null));
		xmlHttp.open("POST", "../../eST/jsp/SalesReturnValidate.jsp?item_code=" + formObj.item_code.value + "&patient_id=" + patient_id + "&sal_trn_type=" + sal_trn_type + "&encounter_id=" + encounter_id + "&item_qty=" + formObj.tot_item_qty.value + "&validate=ITEMCHARGE_DTLS", false);
		xmlHttp.send(xmlDoc);
		responseText = xmlHttp.responseText;
		eval(responseText);
		if (result && message.length > 0) {
			results = message.split(",");
			for (var i = 0; i < 23; i++) {
				insind = results[0];
				baseqty = results[1];
				baserate = results[2];
				basechargeamt = results[3];
				grosschargeamt = results[4];
				discountper = results[5];
				discountamt = results[6];
				daytypecode = results[7];
				daytypedesc = results[8];
				timetypecode = results[9];
				timetypedesc = results[10];
				addlfactor = results[11];
				ordercatalogcode = results[12];
				ordercatalogdesc = results[13];
				blngservcode = results[14];
				blngservdesc = results[15];
				netchargeamt = results[16];
				patgrosschargeamt = results[17];
				patdiscamt = results[18];
				patnetamt = results[19];
				custgrosschargeamt = results[20];
				custdiscamt = results[21];
				custnewamt = results[22];
			}
			if (document.getElementById("id_payable_amt")) {
				//document.getElementById("id_payable_amt").innerText=-1*(grosschargeamt);
				//document.getElementById("id_payable_amt").innerText = "-"+netchargeamt;
				document.getElementById("id_payable_amt").innerText = netchargeamt;
				grosschargeamt_val = grosschargeamt;
				//document.getElementById("id_charge_amt").innerText=-1*(netchargeamt);//grosschargeamt
				//document.getElementById("id_charge_amt").innerText = "-"+grosschargeamt;//grosschargeamt
				document.getElementById("id_charge_amt").innerText = grosschargeamt;//grosschargeamt
			}
		} else {
			if (!result) {
				parent.parent.parent.messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num=" + message;
			}
		}
	}
}



function viewBatchCharges(obj) {
	
	var formObj = document.formSalesReturnListHeader;
	var formObj1= document.formSalesReturnListDetail;

	var xmlHttp = new XMLHttpRequest();
	var xmlDoc="";
	var patient_id = parent.parent.frameSalesReturnHeader.document.formSalesReturnHeader.patient_id.value;
	var encounter_id = parent.parent.frameSalesReturnHeader.document.formSalesReturnHeader.encounter_id.value;
	var sal_trn_type = parent.parent.frameSalesReturnHeader.document.formSalesReturnHeader.sal_trn_type.value;
    var item_code = parent.frameSalesReturnListHeader.document.formSalesReturnListHeader.item_code.value;
    //var total_checkboxes = formObj1.total_checkboxes.value;
	
	for (var j=obj;j<obj+1;j++ )
	{
    var	item_qty = eval("formObj1.item_qty_"+j).value;
	var batch_data  = eval(document.getElementById('trade_id1_'+j)).value +";"+ eval(document.getElementById('batch_id_'+j)).innerText + ";"+ eval(document.getElementById('expiry_date_or_receipt_date_'+j)).innerText + ";"  + eval(document.getElementById('bin_location_code_'+j)).value + ";" + eval("formObj1.item_qty_"+j).value + ";" ;
     
      if ((eval("formObj1.item_qty_"+j).value) != ""  && parent.parent.frameSalesReturnHeader.document.formSalesReturnHeader.bl_install_yn.value=="Y" ){
		xmlDoc.loadXML(getXMLString(null));
		xmlHttp.open("POST", "../../eST/jsp/SalesReturnValidate.jsp?item_code=" + item_code + "&patient_id=" + patient_id + "&sal_trn_type=" + sal_trn_type + "&encounter_id=" + encounter_id + "&item_qty=" +item_qty + "&batch_data=" + batch_data + "&validate=ITEMCHARGE_DTLS", false);
		xmlHttp.send(xmlDoc);
		responseText = xmlHttp.responseText;
		eval(responseText);
		if (result && message.length > 0) {
			results = message.split(",");
			for (var i = 0; i < 23; i++) {
				insind = results[0];
				baseqty = results[1];
				baserate = results[2];
				basechargeamt = results[3];
				grosschargeamt = results[4];
				discountper = results[5];
				discountamt = results[6];
				daytypecode = results[7];
				daytypedesc = results[8];
				timetypecode = results[9];
				timetypedesc = results[10];
				addlfactor = results[11];
				ordercatalogcode = results[12];
				ordercatalogdesc = results[13];
				blngservcode = results[14];
				blngservdesc = results[15];
				netchargeamt = results[16];
				patgrosschargeamt = results[17];
				patdiscamt = results[18];
				patnetamt = results[19];
				custgrosschargeamt = results[20];
				custdiscamt = results[21];
				custnewamt = results[22];
			}
			if (parent.frameSalesReturnListHeader.document.getElementById("id_payable_amt")) {
                
				parent.frameSalesReturnListHeader.document.getElementById("id_payable_amt").innerText = netchargeamt;
				grosschargeamt_val = grosschargeamt;
				parent.frameSalesReturnListHeader.document.getElementById("id_charge_amt").innerText = grosschargeamt;
				eval(document.getElementById("gross_charge_amt_"+j)).value = grosschargeamt;
				eval(document.getElementById("net_charge_amt_"+j)).value = netchargeamt;
			}
		} else {
			if (!result) {
				parent.parent.parent.messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num=" + message;
			}
		}
	}
	else
		{
		if(parent.parent.frameSalesReturnHeader.document.formSalesReturnHeader.bl_install_yn.value=="Y"){
		eval(document.getElementById("gross_charge_amt_"+j)).value = "0.00";
		eval(document.getElementById("net_charge_amt_"+j)).value   = "0.00";
		}
	}
	}
}


function loadBatchCharges() {
	var formObj = document.formSalesReturnListHeader;
	var formObj1= document.formSalesReturnListDetail;

	var xmlHttp = new XMLHttpRequest();
	var xmlDoc="";
	var patient_id = parent.parent.frameSalesReturnHeader.document.formSalesReturnHeader.patient_id.value;
	var encounter_id = parent.parent.frameSalesReturnHeader.document.formSalesReturnHeader.encounter_id.value;
	var sal_trn_type = parent.parent.frameSalesReturnHeader.document.formSalesReturnHeader.sal_trn_type.value;
    var item_code = parent.frameSalesReturnListHeader.document.getElementById("item_code").value;
    var total_checkboxes = formObj1.total_checkboxes.value;
    //Added for GHL-CRF-0557 START
    var sales_doc_no= parent.parent.frameSalesReturnHeader.document.formSalesReturnHeader.sales_doc_no.value;
    var sales_doc_srl_no = parent.frameSalesReturnListHeader.document.formSalesReturnListHeader.sal_doc_srl_no.value;
    var sales_doc_type_code = parent.frameSalesReturnListHeader.document.formSalesReturnListHeader.sales_doc_type_code.value;
    //Added for GHL-CRF-0557 END
	
	for (var j=0;j<total_checkboxes;j++)
	{
    
    var	item_qty = eval("formObj1.item_qty_"+j).value;	
	var batch_data  = eval(document.getElementById('trade_id1_'+j)).value +";"+ eval(document.getElementById('batch_id_'+j)).innerText + ";"+ eval(document.getElementById('expiry_date_or_receipt_date_'+j)).innerText + ";"  + eval(document.getElementById('bin_location_code_'+j)).value + ";" + eval("formObj1.item_qty_"+j).value + ";" ;
     
      if ((eval("formObj1.item_qty_"+j).value) != ""  && parent.parent.frameSalesReturnHeader.document.formSalesReturnHeader.bl_install_yn.value=="Y") {
		xmlDoc.loadXML(getXMLString(null));
		xmlHttp.open("POST", "../../eST/jsp/SalesReturnValidate.jsp?item_code=" + item_code + "&patient_id=" + patient_id + "&sal_trn_type=" + sal_trn_type + "&encounter_id=" + encounter_id + "&item_qty=" +item_qty + "&batch_data=" + batch_data + "&sales_doc_no=" + sales_doc_no + "&sales_doc_srl_no=" +sales_doc_srl_no + "&sales_doc_type_code=" + sales_doc_type_code + "&validate=ITEMCHARGE_DTLS", false);//MODIFIED FOR ghl-crf-0557
		xmlHttp.send(xmlDoc);
		responseText = xmlHttp.responseText;
		eval(responseText);
		if (result && message.length > 0) {
			results = message.split(",");
			for (var i = 0; i < 23; i++) {
				insind = results[0];
				baseqty = results[1];
				baserate = results[2];
				basechargeamt = results[3];
				grosschargeamt = results[4];
				discountper = results[5];
				discountamt = results[6];
				daytypecode = results[7];
				daytypedesc = results[8];
				timetypecode = results[9];
				timetypedesc = results[10];
				addlfactor = results[11];
				ordercatalogcode = results[12];
				ordercatalogdesc = results[13];
				blngservcode = results[14];
				blngservdesc = results[15];
				netchargeamt = results[16];
				patgrosschargeamt = results[17];
				patdiscamt = results[18];
				patnetamt = results[19];
				custgrosschargeamt = results[20];
				custdiscamt = results[21];
				custnewamt = results[22];
			}
			
				eval(document.getElementById("gross_charge_amt_"+j)).value = grosschargeamt;
				eval(document.getElementById("net_charge_amt_"+j)).value = netchargeamt;
		} else {
			if (!result) {
				parent.parent.parent.messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num=" + message;
			}
		}
	}
	else
		{
		eval(document.getElementById("gross_charge_amt_"+j)).value = "0.00";
		eval(document.getElementById("net_charge_amt_"+j)).value   = "0.00";
		if(parent.parent.frameSalesReturnHeader.document.formSalesReturnHeader.bl_install_yn.value=="Y"){
		parent.frameSalesReturnListHeader.document.getElementById("id_payable_amt").innerText = "0.00";
		parent.frameSalesReturnListHeader.document.getElementById("id_charge_amt").innerText = "0.00";
		}
	}
	}
}


function TotalBatchCharges() {
	var formObj = document.formSalesReturnListHeader;
	var formObj1= document.formSalesReturnListDetail;

	var xmlHttp = new XMLHttpRequest();
	var xmlDoc="";
	var patient_id = parent.parent.frameSalesReturnHeader.document.formSalesReturnHeader.patient_id.value;
	var encounter_id = parent.parent.frameSalesReturnHeader.document.formSalesReturnHeader.encounter_id.value;
	var sal_trn_type = parent.parent.frameSalesReturnHeader.document.formSalesReturnHeader.sal_trn_type.value;
   // var item_code = parent.frameSalesReturnListHeader.document.formSalesReturnListHeader.item_code.value;

    var total_checkboxes = formObj1.total_checkboxes.value;
	var total_gross_amt = 0;
    var total_net_amt = 0;

	for (var j=0;j<total_checkboxes;j++)
	{

    total_gross_amt = parseFloat(total_gross_amt)+parseFloat(eval("formObj1.gross_charge_amt_"+j).value);
	total_net_amt =  parseFloat(total_net_amt)+parseFloat(eval("formObj1.net_charge_amt_"+j).value);
    } 	
	if(parent.parent.frameSalesReturnHeader.document.formSalesReturnHeader.bl_install_yn.value=="Y"){
	parent.frameSalesReturnListHeader.document.getElementById("id_payable_amt").innerText = total_net_amt.toFixed(2);
	parent.frameSalesReturnListHeader.document.getElementById("id_charge_amt").innerText = total_gross_amt.toFixed(2);
    }
	}








function onSuccess() {
	f_query_add_mod.location.href = "../../eCommon/html/blank.html";
}
function Modify(obj) {
	/**
	* @Name - Priya
	* @Date - 21/12/2009
	* @Inc# - IN017084
	* @Desc - To avoid the duplication records display in Modify mode
	*/
	var errorPage = "../../eCommon/jsp/error.jsp";
	document.getElementById("readOnlyDiv").style.visibility='visible';
	parent.parent.messageFrame.location.href = errorPage + "?err_num="+getMessage("ST_PROCESSING_WAIT", "ST");

	var doc_no = obj.cells[1].innerText;
	var doc_type_code = obj.cells[6].innerText;
	var patient_id = obj.cells[3].innerText;
	var encounter_id = obj.cells[4].innerText;
	parent.document.location.href = "../../eST/jsp/SalesReturnFrame.jsp?mode=" + MODE_MODIFY + "&function_id=" + parent.parent.function_id + "&doc_type_code=" + doc_type_code + "&doc_no=" + doc_no + "&patient_id=" + patient_id + "&encounter_id=" + encounter_id;
}
function checkTRNType(obj) {
	document.formSalesReturnHeader.encounter_id.disabled = false;
	//document.formSalesReturnHeader.sales_doc_type.disabled = false;
	document.formSalesReturnHeader.patient_id.value= "";
	document.formSalesReturnHeader.patient_name.value = "";

	document.getElementById("pat_class").innerText="";
	document.getElementById("room_no").innerText="";
	document.getElementById("bed_no").innerText="";
	document.getElementById("NU_Clinic").innerText="";
	document.getElementById("NU_Clinic_code").value="";

	if (obj.value == "R" || obj.value == "X") {
		document.formSalesReturnHeader.encounter_id.disabled = true;
		//document.formSalesReturnHeader.sales_doc_type.disabled = true;
		document.formSalesReturnHeader.encounter_id.value = "";
		document.getElementById("id_encounter_id_gif").style.visibility = "hidden";
		if (obj.value == "X") {
			document.getElementById("id_patient_name_gif").style.visibility = "visible";
		}
	} else {
		document.getElementById("id_encounter_id_gif").style.visibility = "visible";
	}
	if (obj.value != "") {
		document.formSalesReturnHeader.store_code_disabled.value = "disabled";
	}
}
// Added by Padmapriya
function checkSaleRetTRNType(obj) {	
if(document.formSalesReturnHeader.patient_id.disabled == false){
	document.formSalesReturnHeader.encounter_id.disabled = false;
	document.formSalesReturnHeader.patient_id.value= "";
	document.formSalesReturnHeader.patient_name.value = "";

	document.getElementById("pat_class").innerText="";
	document.getElementById("room_no").innerText="";
	document.getElementById("bed_no").innerText="";
	document.getElementById("NU_Clinic").innerText="";
	document.getElementById("NU_Clinic_code").value="";

	if (obj.value == "R" || obj.value == "X") {
		document.formSalesReturnHeader.encounter_id.disabled = true;
		document.formSalesReturnHeader.encounter_id.value = "";
		document.getElementById("id_encounter_id_gif").style.visibility = "hidden";
		if (obj.value == "X") {
			document.getElementById("id_patient_name_gif").style.visibility = "visible";
		}
	} else {
		document.getElementById("id_encounter_id_gif").style.visibility = "visible";
	}
	/*if(document.formSalesReturnHeader.sal_trn_type.value == null || document.formSalesReturnHeader.sal_trn_type.value  == ""){
		document.formSalesReturnHeader.sal_trn_type.focus();
	}else{
		document.formSalesReturnHeader.patient_id.focus();
	}*/
	}
}


async function searchPatient() {
	var formObj = document.forms[0];
	if(formObj.patient_id.value!=undefined){
		var direct_sale_patient_flag = formObj.direct_sale_patient_flag.value;
		if (formObj.sal_trn_type.value == "X" && direct_sale_patient_flag=="true") {
		//searchPatientId(formObj.patient_id);
		//return;
		var ret_val=await searchPatientId(formObj.patient_id);
		 //added for TBMC-SCF-0014
			if(ret_val==true){
				getPatientName(formObj.patient_id.value);
			}

			if(ret_val==false)//added for TBMC-SCF-0014
				return false;
			else 
				return true;
		}
	}
	var patient_id =await PatientSearch();
	if (!((patient_id == null) || (patient_id == ""))) {
		formObj.patient_id.value = patient_id;
	}
	formObj.patient_id.focus();
	var itemCode;
	if(formObj.item_code==undefined || formObj.item_code.value == '')
	itemCode = '';
	getDocType(formObj.patient_id.value,itemCode,formObj.sal_trn_type.value);
}

function getDocType(patient_id,itemCode,salTrnType) {
	//storeCode = document.formSalesReturnHeader.all.store_code.value;
	storeCode = document.getElementById("store_code").value;
	if (patient_id != "") {
		var formObj = document.formSalesReturnHeader;
		var xmlString = getXMLString(null);
        var xmlDoc = new DOMParser().parseFromString(xmlString, "text/xml");
		var xmlHttp = new XMLHttpRequest();
		//var xmlDoc="";
		//xmlDoc.loadXML(getXMLString(null));
		xmlHttp.open("POST", "../../eST/jsp/SalesReturnValidate.jsp?patient_id=" + patient_id + "&itemCode="+itemCode+"&salTrnType="+salTrnType+"&store_code="+storeCode+"&siteId="+formObj.site_id.value+"&validate=LOADDOCTYPE", false);
		xmlHttp.setRequestHeader("Content-Type", "text/xml");
		xmlHttp.send(xmlString);
		var responseText = xmlHttp.responseText;
		responseText = trimString(responseText);
		eval(responseText) ;
	}
}

function getPatientName(_patient_id) {

var formObj = document.formSalesReturnHeader;

if (_patient_id != ""){
//added for TBMC-SCF-0014 - start
	if(formObj.patient_id.value!=undefined){
	var direct_sale_patient_flag = formObj.direct_sale_patient_flag.value;
		if (formObj.sal_trn_type.value == "X" && direct_sale_patient_flag=="true") {

			var ret_val = searchPatientId(formObj.patient_id);
			if(ret_val==false)
				return false;
		}
	}
	}
//added for TBMC-SCF-0014 - end
	if (_patient_id != "") {
		var xmlString = getXMLString(null);
        var xmlDoc = new DOMParser().parseFromString(xmlString, "text/xml");
		var xmlHttp = new XMLHttpRequest();
		//var xmlDoc="";
		//xmlDoc.loadXML(getXMLString(null));
		xmlHttp.open("POST", "../../eST/jsp/SalesReturnValidate.jsp?patient_id=" + _patient_id + "&validate=PATIENT_NAME&trn_type=" + formObj.sal_trn_type.value+"&site_id="+formObj.site_id.value, false);
		xmlHttp.setRequestHeader("Content-Type", "text/xml");
		xmlHttp.send(xmlString);
		var responseText = xmlHttp.responseText;
		responseText = trimString(responseText);
		eval(responseText);
		if (!result) {
			alert(getMessage(flag, "ST"));
			formObj.patient_id.focus();
		}
		if((result)&&(formObj.sal_trn_type.value=="R")){
			loadDocNo();
		}
		var itemCode;
		if(formObj.item_code==undefined || formObj.item_code.value == '')
		itemCode = '';
		getDocType(formObj.patient_id.value,itemCode,formObj.sal_trn_type.value);
	}
}
function setPatientName(_patient_name) {

	document.formSalesReturnHeader.patient_name.innerText = _patient_name;
}
 function callItemSearchScreen() {
	//alert("a13");
	var patient_id = parent.parent.frameSalesReturnHeader.document.formSalesReturnHeader.patient_id.value;
	var encounter_id = parent.parent.frameSalesReturnHeader.document.formSalesReturnHeader.encounter_id.value;
	//var encounter_id = document.getElementById("encounter_id").value;
	//var store_code = parent.parent.frameSalesReturnHeader.formSalesReturnHeader.store_code.value;
	var store_code = document.getElementById("store_code").value;
	var search_string = "";
	parent.parent.parent.messageFrame.location.href = "../../eCommon/jsp/error.jsp";
	if (!parent.frameSalesReturnListHeader.formSalesReturnListHeader.item_desc.readOnly) {
		search_string = parent.frameSalesReturnListHeader.formSalesReturnListHeader.item_desc.value;
	}
	var messageFrame = parent.parent.parent.messageFrame;
	var formObj = parent.parent.frameSalesReturnHeader.document.formSalesReturnHeader;
	var arrayObject = new Array(formObj.patient_id);
	var names = new Array(getLabel("Common.patientId.label", "Common"));
	if (formObj.sal_trn_type.value != "R" && formObj.sal_trn_type.value != "X") {
		arrayObject[1] = formObj.encounter_id;
		//arrayObject[1]= document.getElementById("encounter_id");
		names[1] = getLabel("Common.encounterid.label", "Common");
	}
	var blankObject = checkSTFields(arrayObject, names, parent.parent.parent.messageFrame);
	if (blankObject != true) {
   	  //blankObject.focus();
	} else {
		var category = "A";
		var sole_source = "A";
		var ps_item = "A";
		var mfg_item = "A";
		var expiry = "A";
		var consignment = "A";
		var item_class = parent.parent.frameSalesReturnHeader.formSalesReturnHeader.item_class_code.value;
		var item_class_check = parent.parent.frameSalesReturnHeader.formSalesReturnHeader.item_class_check.value;
		if (item_class_check == "Y") {
			if ((item_class == "") || (item_class == "null")) {
				alert(getMessage("ITEM_CLASS_CANNOT_BLANK", "ST"));
			}
			if ((item_class_check == "Y") && ((item_class != "") && (item_class != "null"))) {
				sub1();
			}
		} else {
			sub1();
		}
		async function sub1() {
			//Modified by Sakti against AMS-CRF-0011 trn_type passing
			var retVal =await callItemSearchWindow(search_string, store_code, category, sole_source, ps_item, mfg_item, expiry, item_class, consignment,"SRT");
			if (retVal != null) {
				parent.parent.frameSalesReturnHeader.document.formSalesReturnHeader.store_code_disabled.value = "disabled";
				document.formSalesReturnListHeader.item_code.value = retVal[0];
				document.formSalesReturnListHeader.item_desc.value = retVal[1];
				document.formSalesReturnListHeader.item_desc.readOnly = true;
				document.formSalesReturnListHeader.expiry_yn.value = retVal[2];
				document.formSalesReturnListHeader.uom_code.value = retVal[13];
				document.getElementById("id_store_item_unit_cost").innerHTML = retVal[14];
				document.getElementById("id_uom").innerHTML = retVal[15];
				var formObj = document.formSalesReturnListHeader;
				var xmlHttp = new XMLHttpRequest();
				var xmlDoc="";
				xmlDoc.loadXML(getXMLString(null));
				xmlHttp.open("POST", "../../eST/jsp/SalesReturnValidate.jsp?item_code=" + formObj.item_code.value + "&store_code=" + store_code + "&patient_id=" + patient_id + "&encounter_id=" + encounter_id + "&validate=GET_STATUS", false);
				xmlHttp.send(xmlDoc);
				responseText = xmlHttp.responseText;
				eval(responseText);
				if (result) {
					parent.parent.parent.messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num=" + message;
                      //refreshDetails();
					parent.parent.frameSalesReturnHeader.document.formSalesReturnHeader.encounter_id.disabled = true;
					//document.getElementById("encounter_id").disabled = true;
				} else {
					parent.parent.parent.messageFrame.location.href = "../../eCommon/jsp/error.jsp?";//err_num="+ escape(getMessage(message)) ;
					alert(getMessage(message, "ST"));
				      //refreshDetails();
					parent.frameSalesReturnListHeader.location.href = "../../eST/jsp/SalesReturnListHeader.jsp";
					parent.frameSalesReturnListDetail.location.href = "../../eCommon/html/blank.html";
				}
				document.formSalesReturnListHeader.item_qty.focus();
			}
		}
	}
}
function checkRemarksLength(obj) {
	if (!setTextAreaMaxLength(obj, 200)) {
		alert(getMessage("REMARKS_CHAR_EXCEEDS_LIMIT", "ST"));
		obj.focus();
	}
}
function CheckQuantity(obj) {

if(document.formSalesReturnListHeader.dec_allowed_yn.value=="Y"){
		if (!checkDoubleFormat(obj,false)) {
			return false;
		}
	}else{
		if (!checkIntegerFormat(obj,false)) {
			return false;
		}
	}
	ComputeCost();
	if (document.formSalesReturnListHeader.stock_item_yn.value == "N") {
		return true;
	}
	if (parseFloat(document.formSalesReturnListHeader.item_qty.value) > parseFloat(document.getElementById("id_pending_qty").innerText)) {
		alert(getMessage("RET_QTY_NOT_GRT_MAX_RET_QTY", "ST"));
		document.formSalesReturnListHeader.item_qty.focus();
		return false;
	}
}
function noPendingQty() {
	alert(getMessage("MAX_RET_QTY_ZERO", "ST"));
	cancel_me();
}
function cancel_me(index) {
	eval("parent.parent.frameSalesReturnDetail.document.formSalesReturnDetail.checkbox"+index).disabled = false;
	parent.frameSalesReturnListHeader.location.href = "../../eST/jsp/SalesReturnListHeader.jsp";
	parent.frameSalesReturnListDetail.location.href = "../../eCommon/html/blank.html";
	//Added for GHL-CRF-0413.5 starts
	var xmlHttp = new XMLHttpRequest();
	var xmlDoc="";
	xmlDoc.loadXML(getXMLString(null));
	xmlHttp.open("POST", "../../eST/jsp/SalesReturnValidate.jsp?validate=clearTmpBean", false);
	xmlHttp.send(xmlDoc);
	responseText = xmlHttp.responseText;
	eval(responseText);
	//Added for GHL-CRF-0413.5 ends
}
function showPendingQty(pendingQty, store_unit_cost) {
	document.getElementById("id_uom").innerHTML = "&nbsp;&nbsp;<b>" + retVal[15] + "<b>";
	parent.frameSalesReturnListHeader.document.getElementById("id_pending_qty").innerHTML = "&nbsp;&nbsp;<b>" + pendingQty + "</b>";
	parent.frameSalesReturnListHeader.document.formSalesReturnListHeader.max_returnable_qty.value = pendingQty;
	maxReturnableQuantity = pendingQty;
	document.getElementById("id_store_item_unit_cost").innerHTML = "&nbsp;&nbsp;<b>" + store_unit_cost + "<b>";
	document.getElementById("store_item_unit_cost").value = store_unit_cost;
}
function editViewBatch() {
	var formObj = document.formSalesReturnListHeader;
	//need to check which store to pass
	//var store_code = parent.parent.frameSalesReturnHeader.document.formSalesReturnHeader.store_code.value;
	var store_code = document.getElementById("store_code").value;
	var patient_id = parent.parent.frameSalesReturnHeader.document.formSalesReturnHeader.patient_id.value;
	var encounter_id = parent.parent.frameSalesReturnHeader.document.formSalesReturnHeader.encounter_id.value;
	//var encounter_id = document.getElementById("encounter_id").value;
	var sal_trn_type = parent.parent.frameSalesReturnHeader.document.formSalesReturnHeader.sal_trn_type.value;
	if (parent.frameSalesReturnListDetail.document.formSalesReturnListDetail != null) {
		if (!confirm(getMessage("BATCH_REFRESHED", "ST"))) {
			return;
		}
	}
	var arrayObject = new Array(formObj.item_code, formObj.tot_item_qty);
	var names = new Array(getLabel("Common.item.label", "Common"), getLabel("Common.Quantity.label", "Common"));
	var blankObject = checkSTFields(arrayObject, names, parent.parent.parent.messageFrame);
	if (blankObject == true) {
		var _item_code = formObj.item_code.value;
		var item_qty = formObj.tot_item_qty.value;
		parent.frameSalesReturnListDetail.location.href = "../../eST/jsp/SalesReturnListDetail.jsp?function=edit&store_code=" + store_code + "&patient_id=" + patient_id + "&encounter_id=" + encounter_id + "&sal_trn_type=" + sal_trn_type + "&item_code=" + _item_code + "&item_qty=" + item_qty + "&index=" + formObj.index.value + "&function_id" + parent.parent.function_id;
	} 
}
function addToList() {
/*Code added for Walk-thru on 3/3/2010*/
	var formObjDtl = parent.parent.frameSalesReturnDetail.document.formSalesReturnDetail;
	var return_allowed_yn=formObjDtl.return_allowed_yn.value;
	var checkBoxObj = null;
	var forDeletion = "";
	var noDetailExists = true;
	for (i = 0; i < parseInt(formObjDtl.total_checkboxes.value); i++) {
		checkBoxObj = eval("formObjDtl.checkbox" + i);
		if (checkBoxObj.checked) {
			forDeletion += ("Y,");
		} else {
			forDeletion += ("N,");
			noDetailExists = false;
		}
	}
	var formObjHdr = parent.parent.frameSalesReturnHeader.document.formSalesReturnHeader;
			
	forDeletion = forDeletion.substring(0, forDeletion.length - 1);
	formObjHdr.records_to_delete.value = forDeletion
/*Code Ended 3/3/2010*/
	var formObj = parent.frameSalesReturnListHeader.document.formSalesReturnListHeader;
	//var store_code = parent.parent.frameSalesReturnHeader.document.formSalesReturnHeader.store_code.value;
	var store_code = document.getElementById("store_code").value;
	var sal_trn_type = parent.parent.frameSalesReturnHeader.document.formSalesReturnHeader.sal_trn_type.value;
	var patient_id = parent.parent.frameSalesReturnHeader.document.formSalesReturnHeader.patient_id.value;
	var encounter_id = parent.parent.frameSalesReturnHeader.document.formSalesReturnHeader.encounter_id.value;
	//var encounter_id = document.getElementById("encounter_id").value;
	var arrayObject = new Array(formObj.item_code, formObj.item_qty);
	var names = new Array(getLabel("Common.item.label", "Common"), getLabel("Common.Quantity.label", "Common"));
	var blankObject = checkSTFields(arrayObject, names, parent.parent.parent.messageFrame);
	if (blankObject == true) {
		if (formObj.item_qty.value == "0") {
			alert("Quantity Cannot Be Zero");
			return;
		}
		formObj.apply.disabled = true;
		/* When Edit or Add button is clicked  */
		if (parent.frameSalesReturnListDetail.document.formSalesReturnListDetail == null) {
			var formObj = document.formSalesReturnListHeader;
			//var store_code = parent.parent.frameSalesReturnHeader.document.formSalesReturnHeader.store_code.value;
			var store_code = document.getElementById("store_code").value;
			var _item_code = formObj.item_code.value;
			//var item_qty=formObj.item_qty.value;
			var item_qty = formObj.tot_item_qty.value;
			parent.frameSalesReturnListDetail.location.href = "../../eST/jsp/SalesReturnListDetail.jsp?function=edit&store_code=" + store_code + "&patient_id=" + patient_id + "&encounter_id=" + encounter_id + "&sal_trn_type=" + sal_trn_type + "&item_code=" + _item_code + "&store_code=" + store_code + "&item_qty=" + item_qty + "&index=" + formObj.index.value + "&function_id" + parent.parent.function_id + "&addToList=true";
			return;
		}
		var formObjDtl = parent.parent.frameSalesReturnList.frameSalesReturnListDetail.document.formSalesReturnListDetail;
		var proceed = false;
		var messageFrame = parent.parent.messageFrame;
		var errorPage = "../../eCommon/jsp/error.jsp";
			//var item_qty=formObj.item_qty.value;
		var item_qty = formObj.tot_item_qty.value;
		_total_checkboxes = formObjDtl.total_checkboxes.value;


	/**
	* @Name - krishna
	* @Date - 22/01/2010
	* @Inc# - IN015496
	* @Desc -calculate the sum of batch qty and item qty.
	*/
	var no_of_decimals=formObj.no_of_decimals.value;
	
	
		var sum = 0;
		for (i = 0; i < _total_checkboxes; i++) {
			var qty = eval("formObjDtl.item_qty_" + i).value;
			if (qty == "") {
				qty = 0;
			}
			if (!isNaN(qty)) {
				sum += parseFloat(qty);
			}
		}
		if(formObjDtl.dec_allowed_yn.value=='Y')
			sum=sum.toFixed(no_of_decimals);
		
		if (sum != item_qty) {
			alert(getMessage("QUANTIY_MUST_BE_EQUAL", "ST"));
			formObj.apply.disabled = false;
			return;
		}
		for (i = 0; i < _total_checkboxes; i++) {
			var bin_location_name = "bin_location_code_" + i;
			var bin_location_code = eval("formObjDtl.bin_location_code_" + i).value;
			if (bin_location_code == "") {
				alert(getMessage("BIN_LOCN_NOT_BLANK", "ST"));
				eval("formObjDtl.bin_location_code_" + i).focus();
				formObj.apply.disabled = false;
				return;
			}
		}
		var xmlHttp = new XMLHttpRequest();
		var xmlDoc="";
		xmlDoc.loadXML(getEnhancedXMLString(formObjDtl));

//Added site for GHL-CRF-0413.5
		if (parent.parent.frameSalesReturnHeader.document.formSalesReturnHeader.chargeable_yn.value == "Y" && formObj.billable_item_yn.value=="Y" ) {
			xmlHttp.open("POST", "../../eST/jsp/SalesReturnValidate.jsp?index=" + formObj.index.value +"&site="+formObj.site.value+ "&doc_srl_no=" + formObj.doc_srl_no.value + "&store_code=" + store_code + "&item_code=" + formObj.item_code.value + "&item_desc=" + encodeURIComponent(formObj.item_desc.value) + "&item_qty=" + formObj.item_qty.value + "&item_unit_cost=" + document.getElementById("store_item_unit_cost").value + "&item_cost_value=" + formObj.id_item_sal_value.value + "&pat_net_amt=" + parent.frameSalesReturnListHeader.document.getElementById("id_payable_amt").innerText + "&expiry_yn=" + formObj.expiry_yn.value + "&uom_code=" + formObj.uom_code.value + "&stock_item_yn=" + formObj.stock_item_yn.value + "&remarks=" + encodeURIComponent(formObj.remarks.value) + "&uom_desc=" + encodeURIComponent(document.getElementById("id_uom").innerText) + "&stock_available=" + document.getElementById("id_pending_qty").innerText + "&batch_records=" + formObjDtl.total_checkboxes.value + "&sales_doc_type_code=" + formObj.sales_doc_type_code.value + "&sal_doc_srl_no=" + formObj.sal_doc_srl_no.value +"&sales_doc_no=" + formObj.sales_doc_no.value +"&decimal_allowedYN="+formObj.decimal_allowedYN.value+"&no_of_decimals="+formObj.no_of_decimals.value+"&records_to_delete="+formObjHdr.records_to_delete.value+ "&return_allowed_yn="+return_allowed_yn+"&remarks_code="+formObj.remarks_code_1.value+"&billable_item_yn=Y&validate=ADD_TO_LIST", false);
		} else {
			xmlHttp.open("POST", "../../eST/jsp/SalesReturnValidate.jsp?index=" + formObj.index.value +"&site="+formObj.site.value+ "&doc_srl_no=" + formObj.doc_srl_no.value + "&store_code=" + store_code + "&item_code=" + formObj.item_code.value + "&item_desc=" + encodeURIComponent(formObj.item_desc.value) + "&item_qty=" + formObj.item_qty.value + "&item_unit_cost=" + document.getElementById("store_item_unit_cost").value + "&item_cost_value=" + formObj.id_item_sal_value.value + "&expiry_yn=" + formObj.expiry_yn.value + "&uom_code=" + formObj.uom_code.value + "&stock_item_yn=" + formObj.stock_item_yn.value + "&remarks=" + escape(formObj.remarks.value) + "&uom_desc=" + encodeURIComponent(document.getElementById("id_uom").innerText) + "&stock_available=" + document.getElementById("id_pending_qty").innerText + "&batch_records=" + formObjDtl.total_checkboxes.value + "&sales_doc_type_code=" + formObj.sales_doc_type_code.value + "&sal_doc_srl_no=" + formObj.sal_doc_srl_no.value+"&sales_doc_no=" + formObj.sales_doc_no.value+"&decimal_allowedYN="+formObj.decimal_allowedYN.value+"&no_of_decimals="+formObj.no_of_decimals.value+"&records_to_delete="+formObjHdr.records_to_delete.value+"&return_allowed_yn="+return_allowed_yn+"&remarks_code="+formObj.remarks_code_1.value+"&billable_item_yn=N&validate=ADD_TO_LIST", false);
		}
		//xmlHttp.open("POST", "../../eST/jsp/SalesReturnValidate.jsp?index="+formObj.index.value+"&doc_srl_no="+formObj.doc_srl_no.value+"&store_code="+store_code+"&item_code="+formObj.item_code.value+"&item_desc="+escape(formObj.item_desc.value)+"&item_qty="+formObj.item_qty.value+"&item_unit_cost="+document.getElementById("store_item_unit_cost").value +"&item_cost_value="+formObj.id_item_sal_value.value+"&expiry_yn="+formObj.expiry_yn.value+"&uom_code="+formObj.uom_code.value+"&stock_item_yn="+formObj.stock_item_yn.value+"&remarks="+escape(formObj.remarks.value)+"&uom_desc="+ document.getElementById("id_uom").innerText+"&stock_available="+document.getElementById("id_pending_qty").innerText+"&validate=ADD_TO_LIST", false);
		xmlHttp.send(xmlDoc);
		responseText = xmlHttp.responseText;
		eval(responseText);
		if (result) {
			refreshDetails(formObj.index.value);
			parent.parent.frameSalesReturnHeader.formSalesReturnHeader.preview.disabled = false;
		} else {
			formObj.apply.disabled = false;
			parent.parent.parent.messageFrame.location.href = errorPage + "?err_num=" + getMessage(message, "ST");
			parent.frameSalesReturnListDetail.location.href = "../../eCommon/html/blank.html";
		}
	}
}
function refreshDetails(index) {
	parent.parent.frameSalesReturnDetail.location.href = "../../eST/jsp/SalesReturnDetail.jsp?index=" + index;
	//parent.parent.frameSalesReturnDetail.location.reload();
	parent.frameSalesReturnListHeader.location.href = "../../eST/jsp/SalesReturnListHeader.jsp";
	parent.frameSalesReturnListDetail.location.href = "../../eCommon/html/blank.html";
}
function ComputeCost() {
	var quantity = document.formSalesReturnListHeader.item_qty.value;
	var cost = document.getElementById("store_item_unit_cost").value;
	if (isNaN(quantity) || isNaN(cost)) {
		document.getElementById("id_item_sal_value").innerText = "";
		return;
	}
	/**
	 * @Name - Priya
	 * @Date - 18/05/2010
	 * @Inc# - 
	 * @Desc -  To round up item cost value based on the no_of_decimals_for_cost column in st_acc_entity_param table
	 */
	var no_of_decimals_for_cost = eval(document.formSalesReturnListHeader.no_of_decimals_for_cost.value);
	var value = setNumber(quantity * cost, no_of_decimals_for_cost);
	document.formSalesReturnListHeader.id_item_sal_value.value = value;
}
function modifyData(index) {
	if(parent.frameSalesReturnHeader.document.formSalesReturnHeader.prevIndex.value!=""){
		prevIndex = parent.frameSalesReturnHeader.document.formSalesReturnHeader.prevIndex.value;
		//eval("document.formSalesDetail.checkbox" + prevIndex).checked = false;
		eval("document.formSalesReturnDetail.checkbox" + prevIndex).disabled = false;
	}
	parent.frameSalesReturnHeader.document.formSalesReturnHeader.prevIndex.value = index;
	var trObject = eval(document.getElementById("tr_" + index));
	eval("document.forms[0].checkbox" + index).checked = false;
	eval("document.forms[0].checkbox" + index).disabled = true;
	changeRowColor(trObject);
	parent.frameSalesReturnList.location.href = "../../eST/jsp/SalesReturnListFrame.jsp?function=modify&index=" + index + "&function_id" + parent.parent.function_id;
}
function checkBatchQty(obj, available_qty) {

if(document.formSalesReturnListDetail.dec_allowed_yn.value=="Y"){
		if (!checkDoubleFormat(obj,false)) {
			return false;
		}
	}else{
		if (!checkIntegerFormat(obj,false)) {
			return false;
		}
	}

		if (parseFloat(available_qty) < parseFloat(obj.value)) {
			//alert(getMessage("TFR_QTY_LESS_THAN_AVL_QTY", "ST"));  commanted for GHL-CRF-0462
			alert(getMessage("TFR_QTY_LESS_THAN_AVL_QTY_BARCODE","ST"));//added for GHL-CRF-0462 start
			obj.value=available_qty;//end GHL-CRF-0462
			obj.focus();
		}
	
}
async function callSalRetBatchSearch() {
	if (parent.frameSalesReturnListDetail.document.formSalesReturnListDetail != null) {
		if (!confirm(getMessage("BATCH_REFRESHED", "ST"))) {
			return;
		}
		/*else {
			alert("Please click on modify, after selecting batch");
		}*/
	}
	var formObj = document.formSalesReturnListHeader;
	//var store_code = parent.parent.frameSalesReturnHeader.document.formSalesReturnHeader.store_code.value;
	var store_code = document.getElementById("store_code").value;
	var sal_trn_type = parent.parent.frameSalesReturnHeader.document.formSalesReturnHeader.sal_trn_type.value;
	var patient_id = parent.parent.frameSalesReturnHeader.document.formSalesReturnHeader.patient_id.value;
	var encounter_id = parent.parent.frameSalesReturnHeader.document.formSalesReturnHeader.encounter_id.value;
	//var encounter_id = document.getElementById("encounter_id").value;
	var formObj1 = parent.parent.frameSalesReturnHeader.document.formSalesReturnHeader;
	var _item_code = formObj.item_code.value;
	var item_qty = formObj.item_qty.value;
	var searchFunction = "Y";
	var multipleSelect = "Y";
	var batch_retval = "";
	batch_retval =await callSalRetBatchSearchWindow(_item_code, store_code, sal_trn_type, patient_id, encounter_id, searchFunction, multipleSelect, formObj1.doc_type_code.value, formObj1.doc_no.value, formObj1.trn_type.value);
	if (batch_retval != null && batch_retval!="" && batch_retval!=undefined) {
		parent.frameSalesReturnListDetail.location.href = "../../eST/jsp/SalesReturnListDetail.jsp?function=search&store_code=" + store_code + "&patient_id=" + patient_id + "&encounter_id=" + encounter_id + "&item_code=" + _item_code + "&item_qty=" + item_qty + "&index=" + formObj.index.value + "&function_id" + parent.parent.function_id;
	}
}
async function callSalRetBatchSearchWindow(item_code, store_code, sal_trn_type, patient_id, encounter_id, searchFunction, multipleSelect, doc_type_code, doc_no, trn_type) {
	retVal = await window.showModalDialog("../jsp/SalesReturnBatchSearchFrame.jsp?item_code=" + item_code + "&store_code=" + store_code + "&sal_trn_type=" + sal_trn_type + "&patient_id=" + patient_id + "&encounter_id=" + encounter_id + "&searchFunction=" + searchFunction + "&multipleSelect=" + multipleSelect + "&doc_type_code=" + doc_type_code + "&doc_no=" + doc_no + "&trn_type=" + trn_type, "", "dialogHeight:65vh; dialogWidth:65vw; center:0; status: no; dialogLeft :200; dialogTop :100;");
	return retVal;
}
/*function apply()
{
	var formObj=  f_query_add_mod.frameSalesReturnDetail.document.formSalesReturnDetail;
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

	var formObj	=	f_query_add_mod.frameSalesReturnHeader.document.formSalesReturnHeader;

	var arrayObject = new Array(formObj.patient_id);
	var names = new Array(getLabel("Common.patientId.label","Common"));
	
	if (formObj.sal_trn_type.value!="R") {
		arrayObject[1]=formObj.encounter_id;
		names[1]=getLabel("Common.encounterid.label","Common");
	}
	var blankObject = checkSTFields(arrayObject, names, messageFrame);
	if (blankObject==true) {
	
	forDeletion=forDeletion.substring(0,forDeletion.length-1);
	formObj.records_to_delete.value=forDeletion;

	var xmlHttp = new XMLHttpRequest();
	var xmlDoc="";
	xmlDoc.loadXML(getXMLString(null));
	xmlHttp.open("POST", "../../eST/jsp/SalesReturnValidate.jsp?validate=CHECK_FINALIZE_ALLOWED&store_code="+formObj.store_code.value, false);
	xmlHttp.send(xmlDoc);
	responseText=xmlHttp.responseText;
	//alert(responseText);
	eval(responseText);

		if (formObj.finalized_allowed_yn.value=="Y") {
			var response	=	confirmFinalize();
			if (response==YES) {
				formObj.finalized_yn.value="Y";
			}
		}

		var responseText=formApply(formObj,ST_CONTROLLER);
		//alert(responseText);
		eval(responseText);
		flag1 = (flag.split("~"))[0];
		flag2 = (flag.split("~"))[1];
		flag1 = (flag1=="null"?"":flag1);  
		if(result) {
			if(flag2 == "PY")
				{
				  if(formObj.finalized_allowed_yn.value=="Y")
				  {
   				    var PConfirm = confirmPrinting();
					if (PConfirm == "Yes"){
						var xmlHttp = new XMLHttpRequest();
						var xmlDoc="";
						xmlDoc.loadXML(getXMLString(null));
						xmlHttp.open("POST", "../../eST/jsp/SalesReturnValidate.jsp?validate=printOnlineDoc&msg="+encodeURIComponent(message), false);
						xmlHttp.send(xmlDoc);
						responseText=xmlHttp.responseText;
						eval(responseText);
					   }
					  
				  }
				}
				messageFrame.location.href = errorPage+"?err_num="+ message +"<BR>"+ (result?flag1:"");
				onSuccess();

			}


		if(result)
			messageFrame.location.href = errorPage+"?err_num="+ message +"<BR>"+ flag1;
		else
			messageFrame.location.href = errorPage+"?err_num="+ message;


       // messageFrame.location.href = errorPage+"?err_num="+ message +"<BR>" + flag;


		if(result) {
			onSuccess();
		}
		else{
				if (flag!="") {
					messageFrame.location.href = errorPage+"?err_num="+ message +"<BR>" ;
					f_query_add_mod.frameSalesReturnDetail.location.href="../../eST/jsp/SalesReturnDetail.jsp?function_id="+formObj.function_id.value+"&index="+flag+"&mode="+formObj.mode.value;
				
				}
			}

	}
	else{
	//	blankObject.focus();
	}
}
*/
 async function apply() {

	if(  f_query_add_mod.frameSalesReturnDetail==undefined){
		messageFrame.location.href ="../../eCommon/jsp/error.jsp?err_num=";
		return;
	}  
	var _encounter_id = f_query_add_mod.frameSalesReturnHeader.document.formSalesReturnHeader.encounter_id.value;	
	//console.log(document.getElementById("encounter_id"));
	//var encounter_id = document.getElementById("encounter_id").value;
	var _trn_type = f_query_add_mod.frameSalesReturnHeader.document.formSalesReturnHeader.sal_trn_type.value; 	
	var _patient_id = f_query_add_mod.frameSalesReturnHeader.document.formSalesReturnHeader.patient_id.value;	
	var _site_id = f_query_add_mod.frameSalesReturnHeader.document.formSalesReturnHeader.site_id.value;
	encounterchk = true;
	
	if(f_query_add_mod.frameSalesReturnDetail.document.formSalesReturnDetail.total_checkboxes.value != '0'){
	//if(document.getElementById("total_checkboxes").value != '0'){
		if (f_query_add_mod.frameSalesReturnHeader.document.formSalesReturnHeader.sal_trn_type.value != "X"){	
			if (f_query_add_mod.frameSalesReturnHeader.document.formSalesReturnHeader.sal_trn_type.value != "R"){
				Encounterchkmethod(_patient_id,_trn_type,_site_id,_encounter_id);
			}
		}
	}
	
	if(encounterchk)
	{	
	var formObj = f_query_add_mod.frameSalesReturnDetail.document.formSalesReturnDetail;
	totalCBox = parseInt(formObj.total_checkboxes.value);
	var checkBoxObj = null;
	var forDeletion = "";
	var noDetailExists = true;
	var errorPage = "../../eCommon/jsp/error.jsp";
	for (i = 0; i < totalCBox; i++) {
		checkBoxObj = eval("formObj.checkbox" + i);
		if (checkBoxObj.checked) {
			forDeletion += ("Y,");
		} else {
			forDeletion += ("N,");
			noDetailExists = false;
		}
	}
	if (noDetailExists) {
		messageFrame.location.href = errorPage + "?err_num=" + getMessage("MIN_ONE_DETAIL_REQUIRED","Common");
		return;
	}
	var formObj = f_query_add_mod.frameSalesReturnHeader.document.formSalesReturnHeader;
	var arrayObject = new Array(formObj.patient_id);
	//console.log(formObj.patient_id);
	var names = new Array("Patient ID");
	if (formObj.sal_trn_type.value != "R" && formObj.sal_trn_type.value != "X") {
		arrayObject[1] = formObj.encounter_id;
		//arrayObject[1]= document.getElementById("encounter_id");
		names[1] = "Encounter ID";
	}
	var blankObject = getBlankField(arrayObject, names, messageFrame);
	if (blankObject == null) {
		forDeletion = forDeletion.substring(0, forDeletion.length - 1);
		formObj.records_to_delete.value = forDeletion;
		var xmlString = getXMLString(null);
        var xmlDoc = new DOMParser().parseFromString(xmlString, "text/xml");
		var xmlHttp = new XMLHttpRequest();
		//var xmlDoc="";
		//xmlDoc.loadXML(getXMLString(null));
		xmlHttp.open("POST", "../../eST/jsp/SalesReturnValidate.jsp?validate=CHECK_FINALIZE_ALLOWED&store_code=" + formObj.store_code.value, false);
		xmlHttp.setRequestHeader("Content-Type", "text/xml");
		xmlHttp.send(xmlString);
		var responseText = xmlHttp.responseText;
		responseText = trimString(responseText); 
		eval(responseText);
	if (formObj.finalized_allowed_yn.value == "Y") {
		
		//added for SKR-CRF-0039 By Ganga on 5th Aug 2013
		var xmlHttp = new XMLHttpRequest();
		var xmlDoc="";
		var xmlStr	="<root><SEARCH " ;
		xmlStr+=" function_type=\"2\" ";		
		xmlStr +=" /></root>" ; 
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open("POST", "../../eST/jsp/CommonSearchValidate.jsp?trn_type=" + formObj.trn_type.value + "&store_code="+formObj.store_code.value, false);
		xmlHttp.send(xmlDoc);
		responseText = xmlHttp.responseText;
		eval(responseText);		
		
		var response = "";
		
		//var response = confirmFinalize(); commented
		
		if(result){
			response = await confirmFinalize();	
		}else{
			response = YES;
		}
		//Added ended
			
		if(response=="")
		{
		messageFrame.location.href = errorPage + "?err_num=" ;
		return false;
		}
			if (response == YES) {
				formObj.finalized_yn.value = "Y";
				Finilize = "Y";
			}
		}
		var responseText = formApply(formObj, ST_CONTROLLER);
		eval(responseText);
		l_slmt_reqd_yn = "";
		if (result && Finilize == "Y" && formObj.chargeable_yn.value == "Y" && formObj.item_class_doc_yn.value == "N" && formObj.no_of_records.value == "999999") {
			var xmlHttp = new XMLHttpRequest();
			var xmlDoc="";
			xmlDoc.loadXML(getXMLString(null));
			xmlHttp.open("POST", "../../eST/jsp/SalesReturnValidate.jsp?validate=Bill_data", false);
			xmlHttp.send(xmlDoc);
			responseText = xmlHttp.responseText;
			eval(responseText);
			if (result && message.length > 0) {
				results = message.split(",");
				l_slmt_reqd_yn = results[0];
				l_bill_doc_num = results[1];
				l_bill_doc_type = results[2];
				doc_no = getMessage("DOC_NO", "ST")+": "+(formObj.doc_type_code.value)+"-"+results[3];
				v_blng_group_id = results[4];
				message_bill = results[5];
				var call_disc_function_yn = results[6];
				var episode_id = "";
				var visit_id = "";
				if(formObj.sal_trn_type.value=="E"||formObj.sal_trn_type.value=="O"){
					episode_id = (formObj.encounter_id.value).substring(0,(formObj.encounter_id.value).length-4);
					//episode_id = (document.getElementById("encounter_id").value).substring(0,(document.getElementById("encounter_id").value).length-4);
					visit_id = (formObj.encounter_id.value).substring((formObj.encounter_id.value).length-4,(formObj.encounter_id.value).length);
					//visit_id = (document.getElementById("encounter_id").value).substring((document.getElementById("encounter_id").value).length-4,(document.getElementById("encounter_id").value).length);
				}else if(formObj.sal_trn_type.value=="I"||formObj.sal_trn_type.value=="D"){
					episode_id = formObj.encounter_id.value;
					//episode_id =document.getElementById("encounter_id").value;
					visit_id   = "1";
				}
				var sal_trn_type = formObj.sal_trn_type.value;
				if(sal_trn_type=="X"){
					sal_trn_type = "R";
				}
				//if (l_slmt_reqd_yn == "Y") {
				if (!(formObj.sal_trn_type.value=="I"||formObj.sal_trn_type.value=="D")) {
					var retVal = "";
					var dialogHeight = "40vh";
					var dialogWidth = "70vw";
					var dialogTop = "100";
					var center = "1";
					var status = "no";
					var column_sizes = escape("");
					var column_descriptions = "";
					var features = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; scroll: yes " + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop;
					var arguments = "";
					//var store_code = f_query_add_mod.frameSalesReturnHeader.document.formSalesReturnHeader.store_code.value;
					var store_code = document.getElementById("store_code").value;
					//var url = "../../eBL/jsp/BLCallDiscOrSlmtPage.jsp?billdoctypecode=" + l_bill_doc_type + "&billdocnum=" + l_bill_doc_num + "&storecode=" + store_code + "&blnggrp=" + v_blng_group_id + "&module_id=ST";
					var url = "../../eBL/jsp/BLCallDiscOrSlmtPage.jsp?bill_doc_type_code=" + l_bill_doc_type + "&bill_doc_num=" + l_bill_doc_num + "&store_code=" + store_code + "&blng_grp=" + v_blng_group_id + "&module_id=ST&column_sizes=" + column_sizes + "&column_descriptions=" + column_descriptions+"&patient_id="+formObj.patient_id.value+"&encounter_id="+formObj.encounter_id.value+"&call_disc_function_yn="+call_disc_function_yn+"&doc_no="+doc_no+"&episode_id="+episode_id+"&visit_id="+visit_id+"&slmt_reqd_yn="+l_slmt_reqd_yn+"&episode_type="+sal_trn_type;
					retVal =await window.showModalDialog(url, arguments, features);
					while(retVal==undefined){
						retVal =await window.showModalDialog(url, arguments, features);
						//return;
					}
				}
			}
			flag1 = (flag.split("~"))[0];
			flag2 = (flag.split("~"))[1];
			flag1 = (flag1 == "null" ? "" : flag1);
			//if (result && l_slmt_reqd_yn == "Y") {//commented by Mahesh as print alert is not coming for inpatients or daycare only..
			if (result) {
				if (flag2 == "PY") {
					if (formObj.finalized_allowed_yn.value == "Y") {
						var PConfirm = await confirmPrinting();
						if (PConfirm == "Yes") {
							var xmlHttp = new XMLHttpRequest();
							var xmlDoc="";
							xmlDoc.loadXML(getXMLString(null));
							xmlHttp.open("POST", "../../eST/jsp/SalesReturnValidate.jsp?validate=printOnlineDoc&msg=" + message, true);
							xmlHttp.send(xmlDoc);
							//responseText = xmlHttp.responseText;
							//eval(responseText);
						}
					}
				} 
				else if (flag2 == "PN") {
							var xmlHttp = new XMLHttpRequest();
							var xmlDoc="";
							xmlDoc.loadXML(getXMLString(null));
							xmlHttp.open("POST", "../../eST/jsp/SalesReturnValidate.jsp?validate=printOnlineDoc&msg=" + message, true);
							xmlHttp.send(xmlDoc);
							//responseText = xmlHttp.responseText;
							//eval(responseText);
				}
					//messageFrame.location.href = errorPage+"?err_num="+ message +"<BR>"+ (result?flag1:"");
					//onSuccess();
			}
			if (result && l_slmt_reqd_yn == "Y" && retVal != undefined) {
				messageFrame.location.href = errorPage + "?err_num=" + "<B>"+getMessage("ST_SALE_TRANSACTION_01", "ST")+" </B>" + l_bill_doc_type + "-" + l_bill_doc_num + "<B> "+getMessage("ST_SALE_TRANSACTION_02", "ST")+" ::</B>" + doc_no;
				onSuccess();
			} else {
		
				messageFrame.location.href = errorPage + "?err_num=" + message_bill + "<BR>" + flag1;
			}
			onSuccess();
		}else{
       // messageFrame.location.href = errorPage+"?err_num="+ message +"<BR>" + flag;
		//if (l_slmt_reqd_yn != undefined && result && l_slmt_reqd_yn != "Y" && l_slmt_reqd_yn != "null" && l_slmt_reqd_yn != null) {
		if (result) {
			flag1 = (flag.split("~"))[0];
			flag2 = (flag.split("~"))[1];
			flag1 = (flag1 == "null" ? "" : flag1);
			if (result) {
				if (flag2 == "PY") {
					if (formObj.finalized_allowed_yn.value == "Y") {
						var PConfirm = await confirmPrinting();
						if (PConfirm == "Yes") {
							var xmlHttp = new XMLHttpRequest();
							var xmlDoc="";
							xmlDoc.loadXML(getXMLString(null));
							xmlHttp.open("POST", "../../eST/jsp/SalesReturnValidate.jsp?validate=printOnlineDoc&msg=" + message, true);
							xmlHttp.send(xmlDoc);
							//responseText = xmlHttp.responseText;
							//eval(responseText);
						}
					}
				}
				else if (flag2 == "PN") {
							var xmlHttp = new XMLHttpRequest();
							var xmlDoc="";
							xmlDoc.loadXML(getXMLString(null));
							xmlHttp.open("POST", "../../eST/jsp/SalesReturnValidate.jsp?validate=printOnlineDoc&msg=" + message, true);
							xmlHttp.send(xmlDoc);
							//responseText = xmlHttp.responseText;
							//eval(responseText);
				}
					//messageFrame.location.href = errorPage+"?err_num="+ message +"<BR>"+ (result?flag1:"");
					//onSuccess();
			}
			if (message_bill != "" && l_slmt_reqd_yn != "Y" && l_slmt_reqd_yn != "null" && l_slmt_reqd_yn != null ) {
				messageFrame.location.href = errorPage + "?err_num=" + message_bill + "<BR>" + flag1;
			} else {
			
				messageFrame.location.href = errorPage + "?err_num=" + message + "<BR>" + flag1;
			}
			onSuccess();
		} else {
			if (!result) {
				messageFrame.location.href = errorPage + "?err_num=" + message + "<BR>";
				if (!result && flag != "") {
					messageFrame.location.href = errorPage + "?err_num=" + message + "<BR>";
					//f_query_add_mod.frameSalesReturnDetail.location.href = "../../eST/jsp/SalesReturnDetail.jsp?function_id=" + formObj.function_id.value + "&index=" + flag + "&mode=" + formObj.mode.value;
				}
			}
		}
	}
}
	Finilize = "";
	l_slmt_reqd_yn = "";
}
else
	{
	messageFrame.location.href ="../../eCommon/jsp/error.jsp?err_num=";
	return;
    }
}

function Encounterchkmethod(_patient_id,_trn_type,_site_id,_encounter_id){
		
	var xmlString = getXMLString(null);
    var xmlDoc = new DOMParser().parseFromString(xmlString, "text/xml");
	    var xmlHttp = new XMLHttpRequest();
		//var xmlDoc="";
		//xmlDoc.loadXML(getXMLString(null));
		xmlHttp.open("POST", "../../eST/jsp/SalesReturnValidate.jsp?patient_id=" + _patient_id + "&validate=ENCOUNTER_NEW_LIST&trn_type=" + _trn_type +"&site_id="+ _site_id + "&encounter_id="+ _encounter_id , false);
		xmlHttp.setRequestHeader("Content-Type", "text/xml");
		xmlHttp.send(xmlString);
		var responseText = xmlHttp.responseText;
		responseText = trimString(responseText); 
		eval(responseText);
        
	           if (!result) {
   		       alert("Cannot process the SaleReturn as the Discharge Advice is Already Prepared for this Patient");
		       encounterchk =false;
			   return encounterchk;
	           }

}

function setFinalize_allowed(_finalize_allowed_yn) {
	f_query_add_mod.frameSalesReturnHeader.document.formSalesReturnHeader.finalized_allowed_yn.value = _finalize_allowed_yn;
}
function changeRowColor(obj) {
	//tot = document.forms[0].total_checkboxes.value;
	tot = document.getElementById("total_checkboxes").value;
	tot = tot - 1;
	if (prevObj != null) {
		for (k = 0; k < 2; k++) {
			prevObj.cells(k).className = prevColor;
		}
	}
	prevObj = obj;
	prevColor = obj.cells(1).className;
	for (k = 0; k < 2; k++) {
		obj.cells(k).className = "STLIGHTPINK";
	}
}
async function previewDetails() {
	
	var formObj = parent.parent.f_query_add_mod.frameSalesReturnDetail.document.formSalesReturnDetail;
	totalCBox = parseInt(formObj.total_checkboxes.value);
	var checkedbox = "";
	for (i = 0; i <= totalCBox - 1; i++) {
		if (eval("formObj.checkbox" + i + ".checked")) {
			checkedbox = checkedbox + "@" + i;
		}
	}

	//var store_code = document.formSalesReturnHeader.store_code.value;
	var store_code = document.getElementById("store_code").value;
	var doc_type_code = document.formSalesReturnHeader.doc_type_code.value;
	var patient_id = document.formSalesReturnHeader.patient_id.value;
	var patient_name = document.formSalesReturnHeader.patient_name.value;
	var encounter_id = document.formSalesReturnHeader.encounter_id[document.formSalesReturnHeader.encounter_id.selectedIndex].value;
	//var encounter_id = document.getElementById("encounter_id")[document.getElementById("encounter_id").selectedIndex].value;
	var sal_trn_type_desc = document.formSalesReturnHeader.sal_trn_type[document.formSalesReturnHeader.sal_trn_type.selectedIndex].text;
	var retVal = "";
	var dialogHeight = "20vh";
	var dialogWidth = "55vw";
	var dialogTop = "200";
	var center = "1";
	var status = "no";
	var features = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; scroll: no " + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop;
	var arguments = "";
	var url = "../../eST/jsp/SalesReturnPreviewDetails.jsp?store_code=" + encodeURIComponent(store_code) + "&doc_type_code=" + encodeURIComponent(doc_type_code) + "&patient_id=" + patient_id + "&patient_name=" + encodeURIComponent(patient_name) + "&encounter_id=" + encounter_id + "&sal_trn_type_desc=" + encodeURIComponent(sal_trn_type_desc)+"&checkedbox="+checkedbox;
	retVal =await window.showModalDialog(url, arguments, features);
}
function loadDetailPage(obj,obj1) {
	var formObj = document.formSalesReturnHeader;
	/*if (formObj.sal_trn_type.value=="X"){
		var arrayObject = new Array(formObj.patient_name);
		var names = new Array(getLabel("Common.PatientName.label","Common"));
	}
	var blankObject = checkSTFields(arrayObject, names, parent.parent.messageFrame);
	if(blankObject!=true){
		formObj.sales_doc_no.selectedIndex = 0;
		return;
   	  //blankObject.focus();
	}else{*/

	if(formObj.sales_doc_no.value=="" || formObj.sales_doc_no.value ==null){
		parent.frameSalesReturnDetail.location.href = "../../eST/jsp/SalesReturnDetail.jsp?sales_doc_no_flag=EMPTY";
		parent.frameSalesReturnList.location.href = "../../eST/jsp/SalesReturnListFrame.jsp?";
		parent.parent.messageFrame.location.href = "../../eCommon/jsp/error.jsp?";
		/**
 * @Name - krishna
 * @Date - 20/01/2010
 * @Inc# - IN018239
 * @Desc - Sales Return Preview Details - web page showing wrongly 
 */
		formObj.preview.disabled=true;
		return;
	}
	var xmlHttp = new XMLHttpRequest();
	var xmlDoc="";
	xmlDoc.loadXML(getXMLString(null));
	xmlHttp.open("POST", "../../eST/jsp/SalesReturnValidate.jsp?patient_id=" + formObj.patient_id.value + "&validate=LOAD_DETAILS&trn_type=" + formObj.sal_trn_type.value + "&sales_doc_no=" + formObj.sales_doc_no.value + "&encounter" + formObj.encounter_id.value+"&sales_doc_type="+obj1.value, false);
	xmlHttp.send(xmlDoc);
	responseText = xmlHttp.responseText;
	eval(responseText);
	if (result) {
		formObj.preview.disabled = false;
		formObj.encounter_id.disabled = true;
		formObj.patient_id.disabled = true;
		formObj.sal_trn_type.disabled = true;
		formObj.pat_search.disabled = true;
		//formObj.sales_doc_type.disabled = true;
		parent.frameSalesReturnDetail.location.href = "../../eST/jsp/SalesReturnDetail.jsp?";
		parent.frameSalesReturnList.frameSalesReturnListHeader.location.href = "../../eST/jsp/SalesReturnListHeader.jsp?mode=" + MODE_MODIFY;
		parent.frameSalesReturnList.frameSalesReturnListDetail.location.href = "../../eCommon/html/blank.html";
		parent.parent.messageFrame.location.href = "../../eCommon/jsp/error.jsp?";
	}
	if (!result) {
		if (message == "PHY_INV_PROCESS_INITIATED") {
			parent.parent.messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num=" + getMessage(message, "ST") + "<BR>" + getLabel("eST.PhyInventoryID.label", "ST") + ":" + parent.frameSalesReturnList.frameSalesReturnListHeader.document.formSalesReturnListHeader.phy_inv_id.value;
		} else {
			parent.parent.messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num=" + getMessage("ST_BL_DETAILS_NOT_SET", "ST");
			parent.frameSalesReturnDetail.location.href = "../../eST/jsp/SalesReturnDetail.jsp?";
			parent.frameSalesReturnList.location.href = "../../eST/jsp/SalesReturnListFrame.jsp?";	   			
		}
	}
	//}
}
function setStoreCode(store_code) {
	//document.formSalesReturnHeader.store_code.value = store_code;
	document.getElementById("store_code").value = store_code;
}
function loadDocNo() {
/*The variable itemToFilter was added by Dinesh T on 1/7/2011 for the CRF 110 and added as a parameter to the SalesReturnValidate.jsp*/
	var itemToFilter="";
	var formObj = document.formSalesReturnHeader;
	//document.formSalesReturnHeader.all.sales_doc_no.length=1;
	parent.frameSalesReturnDetail.location.href = "../../eST/jsp/SalesReturnDetail.jsp?sales_doc_no_flag=EMPTY";

	if(formObj.item_code!=null)
		itemToFilter = formObj.item_code.value;

	var errorPage = "../../eCommon/jsp/error.jsp";
	parent.parent.messageFrame.location.href = errorPage + "?err_num=";
	if(formObj.sales_doc_type.value!="")
	{
		var arrayObject = new Array(formObj.encounter_id);
		var names = new Array("Encounter ID");

		if (formObj.sal_trn_type.value != "R" && formObj.sal_trn_type.value != "X") 
		{
		var blankObject = checkSTFields(arrayObject, names, parent.parent.messageFrame);
			if (blankObject != true)
			{
			formObj.sales_doc_type.value="";
				return;
			}
		}
		
		parent.frameSalesReturnDetail.location.href = "../../eST/jsp/SalesReturnDetail.jsp?sales_doc_no_flag=EMPTY";
		parent.frameSalesReturnList.location.href = "../../eST/jsp/SalesReturnListFrame.jsp?";
		parent.frameSalesReturnList.frameSalesReturnListDetail.location.href = "../../eCommon/html/blank.html";

		parent.parent.messageFrame.location.href = "../../eCommon/jsp/error.jsp?";
		var xmlHttp = new XMLHttpRequest();
		var xmlDoc="";
		xmlDoc.loadXML(getXMLString(null));
		xmlHttp.open("POST", "../../eST/jsp/SalesReturnValidate.jsp?patient_id=" + formObj.patient_id.value + "&validate=SALES_DOC_NO&trn_type=" + formObj.sal_trn_type.value + "&sales_doc_no=" + formObj.sales_doc_no.value + "&encounter_id=" + formObj.encounter_id.value+"&sales_doc_type="+formObj.sales_doc_type.value+"&itemToFilter="+itemToFilter, false);
		xmlHttp.send(xmlDoc);
		responseText = xmlHttp.responseText;
		eval(responseText);
		if (!result) 
		{
			alert("No Documents Availble For The Patient Type");
		}
	}
}
function addList(listObject) {
	var index = document.getElementById('sal_trn_type').selectedIndex;
	if(document.formSalesReturnHeader.sal_trn_type.value == null || document.formSalesReturnHeader.sal_trn_type.value == "" && index != 0 ){	
	//var store_code = document.formSalesReturnHeader.store_code.value;
	var store_code = document.getElementById("store_code").value;
	var arrayObject = new Array();
	var bean_id = "SalesBean";
	var bean_name = "eST.SalesBean";
	//var xmlDom = new ActiveXObject("Microsoft.XMLDom");
	//var xmlHttp = new XMLHttpRequest();
	var xmlHttp = new XMLHttpRequest();	
	var xmlStr = getXMLString(arrayObject);
	var xmlDom = new DOMParser().parseFromString(xmlStr, "text/xml");
	//xmlDom.loadXML(xmlStr);
	xmlHttp.open("POST", "../../eST/jsp/SalesReturnValidate.jsp?bean_id=" + bean_id + "&bean_name=" + bean_name + "&validate=SALES_TYPE" + "&store_code=" + store_code, false);
	xmlHttp.send(xmlDom);
	responseText = xmlHttp.responseText;
	eval(responseText);
	}
}
async function searchPatientId(obj) {
	var argumentArray = new Array();
	var dataNameArray = new Array();
	var dataValueArray = new Array();
	var dataTypeArray = new Array();
	var sql = document.formSalesReturnHeader.ST_SQL_DIR_SAL_PAT_LOOKUP.value;
	//var sql= "SELECT a.patient_id code, b.patient_name description FROM st_dir_sale_patient_param a, mp_patient b WHERE a.patient_id LIKE UPPER(?) AND UPPER(b.patient_name) LIKE UPPER(?) AND a.eff_status = 'E' and a.patient_id = b.patient_id  ";
	argumentArray[0] = sql;
	argumentArray[1] = dataNameArray;
	argumentArray[2] = dataValueArray;
	argumentArray[3] = dataTypeArray;
	argumentArray[4] = "1,2";
	argumentArray[5] = obj.value;
	argumentArray[6] = CODE_LINK;
	argumentArray[7] = CODE_DESC;
	var remarks = getLabel("Common.PatientName.label", "Common");
	returnedValues =await CommonLookup(remarks, argumentArray);
	if ((returnedValues != null) && (returnedValues != "")) {
		obj.value = returnedValues[0];
		//obj.focus();
		//objDesc.value = returnedValues[1];
		return true; //added for TBMC-SCF-0014 
	}else
	{
	return false;
	}
}
function CheckStoreSalesType() {
	/* Commented by mahesh for PE....Pls uncomment if any problem with sal_trn_type
	var store_code = document.formSalesReturnHeader.store_code.value;
	var sal_trn_type = document.formSalesReturnHeader.sal_trn_type.value;
	if (sal_trn_type == "") {
		alert("Sales Type Cannot Be Blank");
		document.formSalesReturnHeader.sal_trn_type.focus();
		return;
	}
	var arrayObject = new Array();
	var bean_id = "SalesReturnBean";
	var bean_name = "eST.SalesReturnBean";
	var xmlDom = new ActiveXObject("Microsoft.XMLDom");
	var xmlHttp = new XMLHttpRequest();
	var xmlStr = getXMLString(arrayObject);
	xmlStr = getXMLString(arrayObject);
	xmlDom.loadXML(xmlStr);
	xmlHttp.open("POST", "../../eST/jsp/SalesReturnValidate.jsp?bean_id=" + bean_id + "&bean_name=" + bean_name + "&validate=CHECK_STORE_SALESTYPE" + "&store_code=" + store_code + "&sal_trn_type=" + sal_trn_type, false);
	xmlHttp.send(xmlDom);
	responseText = xmlHttp.responseText;
	eval(responseText);*/
}
function dispMess(id) {
	alert(getMessage("PHY_INV_PROCESS_INITIATED", "ST") + "\n" + getLabel("eST.PhyInventoryID.label", "ST") + ":" + id);
}
async function searchRemarks(objCode, objDesc) {
	var argumentArray = new Array();
	var dataNameArray = new Array();
	var dataValueArray = new Array();
	var dataTypeArray = new Array();
	dataNameArray[0] = "language_id";
	dataValueArray[0] = document.formSalesReturnListHeader.lang_id.value;
	dataTypeArray[0] = STRING;
	dataNameArray[1] = "module_id";
	dataValueArray[1] = "ST";
	dataTypeArray[1] = STRING;
	dataNameArray[2] = "trn_type";
	dataValueArray[2] = document.formSalesReturnListHeader.rem_trans_type.value;
	dataTypeArray[2] = STRING;
	argumentArray[0] = document.formSalesReturnListHeader.SQL_ST_TRN_REMARKS_LOOKUP_SELECT.value;
	argumentArray[1] = dataNameArray;
	argumentArray[2] = dataValueArray;
	argumentArray[3] = dataTypeArray;
	argumentArray[4] = "4,5";
	argumentArray[5] = objDesc.value;
	argumentArray[6] = CODE_LINK;
	argumentArray[7] = CODE_DESC;
	returnedValues =await CommonLookup(getLabel("Common.remarks.label", "Common"), argumentArray);
	var ret1=unescape(returnedValues);
	 var arr=ret1.split(",");
		if(arr[1]==undefined) 
		{
			arr[0]="";	
			arr[1]="";	
		}

	if ((returnedValues != null) && (returnedValues != "")) {
		objCode.value = arr[0];
		objDesc.value = arr[1];
	}
}
function calTotalQty() {
	//var store_code = document.formSalesReturnListHeader.store_code.value;
	var store_code = document.getElementById("store_code").value;
	var item_code = document.formSalesReturnListHeader.item_code.value;
	var item_qty = document.formSalesReturnListHeader.item_qty.value;
	var no_of_decimals = document.formSalesReturnListHeader.no_of_decimals.value;
	if(item_qty!=""){
		var formObj = document.formSalesReturnListHeader;
		var xmlString = getXMLString(null);
        var xmlDoc = new DOMParser().parseFromString(xmlString, "text/xml");
		var xmlHttp = new XMLHttpRequest();
		//var xmlDoc="";
		//xmlDoc.loadXML(getXMLString(null));
		xmlHttp.open("POST", "../../eST/jsp/SalesReturnValidate.jsp?validate=TOTAL_QTY" + "&store_code=" + store_code + "&item_code=" + item_code + "&item_qty=" + item_qty+ "&no_of_decimals=" + no_of_decimals, false);
		xmlHttp.setRequestHeader("Content-Type", "text/xml");
		xmlHttp.send(xmlString);
		var responseText = xmlHttp.responseText;
		responseText = trimString(responseText);
		eval(responseText);
	}else{
		document.formSalesReturnListHeader.tot_item_qty.value = "";
	}
}
function displayDetails(){
	var formObj = document.formSalesReturnHeader;
	//var xmlDom = new ActiveXObject("Microsoft.XMLDom");
	//var xmlDom = "";
	var xmlString = getXMLString(null);
    var xmlDoc = new DOMParser().parseFromString(xmlString, "text/xml");
	var xmlHttp = new XMLHttpRequest();
	//xmlDom.loadXML(xmlStr);
	xmlHttp.open("POST", "../../eST/jsp/SalesReturnValidate.jsp?validate=DISP_DETAILS&patient_id="+formObj.patient_id.value+"&encounter_id="+formObj.encounter_id.value, false);
	xmlHttp.setRequestHeader("Content-Type", "text/xml");
	xmlHttp.send(xmlString);
	var responseText = xmlHttp.responseText;
	responseText = trimString(responseText);
	eval(responseText);
}
function diss(desc){
	var va=decodeURIComponent(desc,"UTF-8");
		var strCheck = new Array("+");
	var lenValue  = strCheck.length;
	for(var i=0;i<lenValue;i++){
		while(va.indexOf(strCheck[i]) != -1 ){
			while(va.indexOf(strCheck[i]) != -1){
				va = va.replace(strCheck[i]," ");
			}
			i++;
		}
	}
	
	document.getElementById("NU_Clinic").innerText = va;
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
 * @Name - krishna
 * @Date - 20/01/2010
 * @Inc# - IN018239
 * @Desc - Sales Return Preview Details - web page showing wrongly   
			 
 */
function disabledPreviwButton(obj,i){
	/*Coded added for SRR walk-thru on 3/4/2010*/
	if(obj!=undefined){
		if(obj!=null && obj.checked){
			eval(document.getElementById("font_"+i)).style.color='black';
			eval(document.getElementById("font_"+i)).onclick='';
			eval(document.getElementById("td_"+i)).style.cursor='';
			eval(document.getElementById("td_"+i)).onmouseover='';
		}else{
			eval(document.getElementById("font_"+i)).style.color='blue';
			eval(document.getElementById("td_"+i)).style.cursor='hand';
			eval(document.getElementById("font_"+i)).onclick=new Function("modifyData('"+i+"');disabledPreviwButton()");//"modifyData('"+i+"');disabledPreviwButton();";
		}
	}
	/*Code ended*/
	var count = 0;
	var totalCBox=document.formSalesReturnDetail.total_checkboxes.value;
	for (i = 0; i <= totalCBox - 1; i++) {
		if (eval("document.formSalesReturnDetail.checkbox" + i + ".checked")) {
			count=count+1;
		}
	}
	if(eval(count)==eval(totalCBox)){
	parent.frameSalesReturnHeader.document.formSalesReturnHeader.preview.disabled=true;
	}else{
		parent.frameSalesReturnHeader.document.formSalesReturnHeader.preview.disabled=false;
	}

}

function onBlurcallItemSearchScreenForDocFilter()
{
	if(document.getElementById("item_desc").value != '')
	  callItemSearchScreenForDocFilter();
	else if(document.getElementById("item_desc").value == '')
	{
		parent.frameSalesReturnHeader.document.formSalesReturnHeader.all.item_code.value="";
		parent.frameSalesReturnHeader.document.formSalesReturnHeader.all.item_desc.value="";
		getDocType(document.formSalesReturnHeader.all.patient_id.value,document.formSalesReturnHeader.all.item_code.value,document.formSalesReturnHeader.all.sal_trn_type.value) ;
	}

}

/*This function was Added By Dinesh T for CRF-0110*/
function callItemSearchScreenForDocFilter(itemDesc) {
	//parent.frameSalesReturnHeader.document.formSalesReturnHeader.all.item_code.value="";
	//parent.frameSalesReturnHeader.document.formSalesReturnHeader.all.item_desc.value="";
	//parent.frameSalesReturnHeader.document.formSalesReturnHeader.all.sales_doc_type.length = 1;
	//parent.frameSalesReturnHeader.document.formSalesReturnHeader.all.sales_doc_no.length = 1;
	parent.frameSalesReturnDetail.location.href = "../../eST/jsp/SalesReturnDetail.jsp?sales_doc_no_flag=EMPTY";
	var patient_id = parent.frameSalesReturnHeader.document.formSalesReturnHeader.patient_id.value;
	var encounter_id = parent.frameSalesReturnHeader.document.formSalesReturnHeader.encounter_id.value;
	//var encounter_id = document.getElementById("encounter_id").value;
	//var store_code = parent.frameSalesReturnHeader.formSalesReturnHeader.store_code.value;
	var store_code = document.getElementById("store_code").value;
	var search_string = "";
	parent.parent.messageFrame.location.href = "../../eCommon/jsp/error.jsp";
	
	if (!document.getElementById("item_desc").readOnly) {
		search_string = document.getElementById("item_desc").value;
	}
	
	var messageFrame = parent.parent.messageFrame;
	var formObj = parent.frameSalesReturnHeader.document.formSalesReturnHeader;
	var arrayObject = new Array(formObj.patient_id);
	var names = new Array(getLabel("Common.patientId.label", "Common"));
	if (formObj.sal_trn_type.value != "R" && formObj.sal_trn_type.value != "X") {
		arrayObject[1] = formObj.encounter_id;
		names[1] = getLabel("Common.encounterid.label", "Common");
	}
	var blankObject = checkSTFields(arrayObject, names, parent.parent.messageFrame);
	if (blankObject != true) {
   	  //blankObject.focus();
	} else {
		var category = "A";
		var sole_source = "A";
		var ps_item = "A";
		var mfg_item = "A";
		var expiry = "A";
		var consignment = "A";
		var item_class = parent.frameSalesReturnHeader.formSalesReturnHeader.item_class_code.value;
		var item_class_check = parent.frameSalesReturnHeader.formSalesReturnHeader.item_class_check.value;
		if (item_class_check == "Y") {
			if ((item_class == "") || (item_class == "null")) {
				alert(getMessage("ITEM_CLASS_CANNOT_BLANK", "ST"));
			}
			if ((item_class_check == "Y") && ((item_class != "") && (item_class != "null"))) {
				sub1();
			}
		} else {
			sub1();
		}
		async function sub1() {
			//Modified by Sakti against AMS-CRF-0011 trn_type passing
			var retVal =await callItemSearchWindow(search_string, store_code, category, sole_source, ps_item, mfg_item, expiry, item_class, consignment,"SRT");
			if (retVal != null) {
				parent.frameSalesReturnHeader.document.formSalesReturnHeader.store_code_disabled.value = "disabled";
				document.formSalesReturnHeader.item_code.value = retVal[0];
				document.formSalesReturnHeader.item_desc.value = retVal[1];
			//	document.formSalesReturnHeader.item_desc.readOnly = true;
				/*var formObj = document.formSalesReturnHeader;
				var xmlHttp = new XMLHttpRequest();
				var xmlDoc="";
				xmlDoc.loadXML(getXMLString(null));
				xmlHttp.open("POST", "../../eST/jsp/SalesReturnValidate.jsp?item_code=" + formObj.item_code.value + "&store_code=" + store_code + "&patient_id=" + patient_id + "&encounter_id=" + encounter_id, false);
				xmlHttp.send(xmlDoc);
				responseText = xmlHttp.responseText;
				eval(responseText);		*/
				getDocType(formObj.patient_id.value,document.formSalesReturnHeader.all.item_code.value,document.formSalesReturnHeader.all.sal_trn_type.value) ;
			}
			else
			{
				parent.frameSalesReturnHeader.document.formSalesReturnHeader.all.item_code.value="";
				parent.frameSalesReturnHeader.document.formSalesReturnHeader.all.item_desc.value="";
				getDocType(formObj.patient_id.value,document.formSalesReturnHeader.all.item_code.value,document.formSalesReturnHeader.all.sal_trn_type.value) ;
			}
		}	
	}	
}

function defaultEncounter()
{
	if(document.getElementById("encounter_id").length > 1)
	{
		document.getElementById("encounter_id").selectedIndex =1;
		callBillingHdrProcedure();
		displayDetails();
	}
}


function frmdate(){
   var from_date    =  document.formSalesReturnQueryCriteria.doc_date.value ;
   var to_doc_date =  document.formSalesReturnQueryCriteria.to_doc_date.value ;
   if(from_date==""){
   alert(getMessage("FROM_DATE_NOT_BLANK", "ST"));
   document.formSalesReturnQueryCriteria.doc_date.focus();
   return ;
   }
   else{
	   if (to_doc_date=="")
	   {
	   document.formSalesReturnQueryCriteria.submit();
	   }
	   else if(!isBefore(from_date,to_doc_date,"DMY",document.forms[0].language_id.value)) {
       alert(getMessage("FM_DATE_GR_TO_DATE", "ST"));
	   document.formSalesReturnQueryCriteria.doc_date.focus();
	   return ;
	   }
	   else
	   {
       document.formSalesReturnQueryCriteria.submit();
	   }
   }
}

async function searchDetails(){
	var patient_id    = document.formSalesReturnHeader.patient_id.value;
  	var encounter_id  = document.formSalesReturnHeader.encounter_id.value;
  	//var encounter_id = document.getElementById("encounter_id").value;
    var patient_name  = document.formSalesReturnHeader.patient_name.value;
    var sal_trn_type  = document.formSalesReturnHeader.sal_trn_type.value;
    var chargeable_yn = document.formSalesReturnHeader.chargeable_yn.value;
   // var store_code	  = document.formSalesReturnHeader.store_code.value;
    var store_code = document.getElementById("store_code").value;
	var sales_doc_no="";
	var sales_doc_type_code="";	
	var sal_patient_name="";	

	var retValChk="";
	var retVal="";
	var dialogHeight= "65vh";
	var dialogWidth	= "85vw";
	var dialogTop   = "250";
	var dialogLeft  = "20";
	var center      = "0";
	var status      = "no";
	var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; scroll: yes " + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop + "; dialogLeft :" + dialogLeft ;
	var arguments	= "" ;
	var url = "../../eST/jsp/SalesReturnSearchWindowFrame.jsp?patient_id="+patient_id+"&encounter_id="+encounter_id+"&patient_name="+patient_name+"&sal_trn_type="+sal_trn_type+"&chargeable_yn="+chargeable_yn+"&store_code="+store_code+"&index=0";
	retVal =await window.showModalDialog(url,arguments,features);	

    if (retVal!= null){
	 retValChk = (retVal.split("||"))[0];
	 sales_doc_type_code =(retVal.split("||"))[1];
	 sales_doc_no =(retVal.split("||"))[2];
	 sal_patient_name =(retVal.split("||"))[3];
     }
	if(retValChk=="ADD"){
		parent.frameSalesReturnHeader.document.formSalesReturnHeader.sales_doc_type.value=sales_doc_type_code;
		parent.frameSalesReturnHeader.document.formSalesReturnHeader.sales_doc_no.value=sales_doc_no;	
		if (sal_trn_type=='X')		{
		parent.frameSalesReturnHeader.document.formSalesReturnHeader.patient_name.value=sal_patient_name;
		}
		var html = "<html><body><form name='dummyFormSubmit' id='dummyFormSubmit'  action='../../eST/jsp/SalesReturnDetail.jsp?&function=edit"+"&addToList=true' method='post'>";
		html+="</form></body></html>";
		parent.frames[1].document.body.insertAdjacentHTML("afterBegin",html);
		parent.frames[1].dummyFormSubmit.submit();
		parent.frameSalesReturnList.document.location.href="../../eST/jsp/SalesReturnListFrame.jsp";
		parent.frameSalesReturnHeader.document.formSalesReturnHeader.encounter_id.disabled = true;
		//document.getElementById("encounter_id").disabled = true;
		parent.frameSalesReturnHeader.document.formSalesReturnHeader.sal_trn_type.disabled = true;
		parent.frameSalesReturnHeader.document.formSalesReturnHeader.patient_id.disabled = true;

	}
}


function enable_doc(object, batchcount, index, doctypecode){ //modified for IN074078
	
	var doc_no = object.value;
	var formObj = document.formSalesReturnSearchWindowResult;
	var prevCount = formObj.sel_doc_batch_count.value;	
	var prevdoc_no = formObj.selected_doc_no.value;	
	var prevdoc_type = formObj.prevdoc_type.value;	//added for IN074078
	var prev_ind = formObj.prev_ind.value;	
	formObj.selected_doc_no.value = doc_no;	
	formObj.prevdoc_type.value = doctypecode;	//added for IN074078
	formObj.sel_doc_batch_count.value = batchcount;	
	formObj.prev_ind.value = index;	
	var ind =  index ;    
    var material_group_access_message ="Y"; //34089
  
	for (var index=0; index < batchcount; index++ ){
		var checkobj = eval("formObj.doc_no_"+doc_no+"_"+doctypecode+"_"+index);  //modified for IN074078
		var itemQtyobj = eval("formObj.item_qty_"+doc_no+"_"+doctypecode+"_"+index); //modified for IN074078
		var applyobj = eval("formObj.apply_"+doc_no+"_"+doctypecode+"_"+ind); //modified for IN074078
		//34089  Start.
		var material_group_access_yn = eval("formObj.material_group_access_yn_"+doc_no+"_"+doctypecode+"_"+index);
		if(material_group_access_yn.value=='N'){
			material_group_access_message="N";
		}
		//34089 End.
		if(object.checked == true ){
			
			if (checkobj!= undefined && itemQtyobj!= undefined && material_group_access_yn.value=='Y'){
			
				//checkobj.checked = true;
			//itemQtyobj.value=eval("formObj.sal_item_qty_"+doc_no+"_"+index).value;
				
				//Added By sharanraj for GHL-CRF-0483 starts
				var chk=eval("formObj.chkAll_"+object.value+"_"+doctypecode); //modified for IN074078
				
				if(formObj.sal_doc_chkd.value=="Y")
				{
					checkobj.checked = true;
					chk.checked=true;
					itemQtyobj.value=eval("formObj.sal_item_qty_"+doc_no+"_"+doctypecode+"_"+index).value; //modified for IN074078
					itemQtyobj.disabled=false;
				}else{
					checkobj.checked = false;
				}	
				
				chk.disabled=false;
				if(formObj.sal_doc_chkd.value=="N")
				{
					//alert("<<<<>"+formObj.doc_no_radio.checked);
					itemQtyobj.value="";	
					itemQtyobj.disabled=true; // Added by sharanraj for GHL-CRF-0483
				}	
				
				
				//Added By sharanraj for GHL-CRF-0483 ends
			
				
			checkobj.disabled=false;
			//itemQtyobj.disabled=false;
			
			applyobj.disabled = false;
			}
			
		} 
		
	}
	if(prevdoc_no != undefined && prevdoc_no!= null && prevdoc_no!=""  && (!(doc_no==prevdoc_no && doctypecode==prevdoc_type))){   //modified for IN074078
		for (var batindx=0;batindx< parseInt(prevCount) ;batindx++ )
		{
			var checkobj = eval("formObj.doc_no_"+prevdoc_no+"_"+prevdoc_type+"_"+batindx); //modified for IN074078
			var itemQtyobj = eval("formObj.item_qty_"+prevdoc_no+"_"+prevdoc_type+"_"+batindx);//modified for IN074078
			var applyobj = eval("formObj.apply_"+prevdoc_no+"_"+prevdoc_type+"_"+prev_ind); //modified for IN074078
			var chk=eval("formObj.chkAll_"+prevdoc_no+"_"+prevdoc_type); //Added By sharanraj for GHL-CRF-0483 //modified for IN074078
			if (checkobj!= undefined && itemQtyobj!= undefined){
			checkobj.checked = false;
			chk.checked = false; //Added By sharanraj against GHL-CRF-0483
			itemQtyobj.value="";
			checkobj.disabled=true;
			chk.disabled=true; //Added by sharanraj against GHL-CRF-0483
			itemQtyobj.disabled=true;
			}
			applyobj.disabled = true;
			
		}
	}
	//34089 Start.
	if(material_group_access_message=='N'){
		var chk=eval("formObj.chkAll_"+object.value+"_"+doctypecode);	
		chk.checked=false;
		chk.disabled=true;
		document.getElementById("material_group_access_message_"+ind).innerHTML="<font color=red>Disabled items : Material Group and User Combination doesn't exist.</font>";
	}
	//34089 End.
}
function getItemQty(obj,index,doctypecode){ //modified for IN074078

   var formObj = document.formSalesReturnSearchWindowResult;
   var doc_no  = obj.value;
   var checkobj = eval("formObj.doc_no_"+doc_no+"_"+doctypecode+"_"+index); //modified for IN074078
   var itemQtyobj = eval("formObj.item_qty_"+doc_no+"_"+doctypecode+"_"+index); //modified for IN074078
   var salitemQtyobj = eval("formObj.sal_item_qty_"+doc_no+"_"+doctypecode+"_"+index); //modified for IN074078

	if (checkobj.checked == true){
	 itemQtyobj.value = salitemQtyobj.value;
	 itemQtyobj.disabled=false;
	}
	else{
	itemQtyobj.value ="";
	itemQtyobj.disabled=true;
	}
}

function ItemBatch(){
}

function onapply(batchcount,doctypecode){ //modified for IN074078
    var formObj       = document.formSalesReturnSearchWindowResult;
	var formCriteria  = parent.frameSalesReturnSearchWindowCriteria.document.formSalesReturnSearchWindowCriteria;	
	var doc_no        = formObj.selected_doc_no.value ;	
	var doc_type_code = "";
	var sal_patient_name = "";
	var item_arr   = new Array();
	var arrayIndex = 0;	
	

	for (var index=0;index<batchcount;index++ ){	

                var checkobj  = eval("formObj.doc_no_"+doc_no+"_"+doctypecode+"_"+index); //modified for IN074078

				if(eval("formObj.doc_type_code_"+doc_no+"_"+doctypecode+"_"+index)!= undefined) //modified for IN074078
                doc_type_code = eval("formObj.doc_type_code_"+doc_no+"_"+doctypecode+"_"+index).value; //modified for IN074078

				if (eval("formObj.sal_patient_name_"+doc_no)!= undefined)
				sal_patient_name = eval("formObj.sal_patient_name_"+doc_no).value;
				
				if (checkobj!= undefined && checkobj.checked == true){
					
					var myClassObj = new ItemBatch();

					myClassObj.checked = 'Y';	
          //modified for IN074078		
					myClassObj.doc_no            = eval("formObj.doc_no_"+doc_no+"_"+doctypecode+"_"+index).value ; 
					myClassObj.item_code         = eval("formObj.item_code_"+doc_no+"_"+doctypecode+"_"+index).value;
					myClassObj.item_name         = eval("formObj.item_name_"+doc_no+"_"+doctypecode+"_"+index).value;
					myClassObj.item_cost         = eval("formObj.item_cost_"+doc_no+"_"+doctypecode+"_"+index).value;
					myClassObj.uom_code          = eval("formObj.uom_code_"+doc_no+"_"+doctypecode+"_"+index).value;
					myClassObj.uom_desc          = eval("formObj.uom_desc_"+doc_no+"_"+doctypecode+"_"+index).value;
					myClassObj.expiry_yn         = eval("formObj.expiry_yn_"+doc_no+"_"+doctypecode+"_"+index).value;
					myClassObj.stock_item_yn     = eval("formObj.stock_item_yn_"+doc_no+"_"+doctypecode+"_"+index).value;
					myClassObj.doc_srl_no        = eval("formObj.doc_srl_no_"+doc_no+"_"+doctypecode+"_"+index).value;
					myClassObj.trade_name        = eval("formObj.trade_name_"+doc_no+"_"+doctypecode+"_"+index).value;
					myClassObj.bin_location_desc = eval("formObj.bin_location_desc_"+doc_no+"_"+doctypecode+"_"+index).value;
					myClassObj.refund_allow_yn   = eval("formObj.refund_allow_yn_"+doc_no+"_"+doctypecode+"_"+index).value ;
					myClassObj.srl_no            = eval("formObj.srl_no_"+doc_no+"_"+doctypecode+"_"+index).value;
					myClassObj.trade_id          = eval("formObj.trade_id_"+doc_no+"_"+doctypecode+"_"+index).value;
					myClassObj.batch_id          = eval("formObj.batch_id_"+doc_no+"_"+doctypecode+"_"+index).value;
					myClassObj.expiry_date_or_receipt_date = eval("formObj.expiry_date_or_receipt_date_"+doc_no+"_"+doctypecode+"_"+index).value ;
					myClassObj.bin_location_code           = eval("formObj.bin_location_code_"+doc_no+"_"+doctypecode+"_"+index).value;
					myClassObj.sal_item_qty         = eval("formObj.sal_item_qty_"+doc_no+"_"+doctypecode+"_"+index).value;
					myClassObj.item_qty             = eval("formObj.item_qty_"+doc_no+"_"+doctypecode+"_"+index).value; 
          //modified for IN074078
					item_arr[arrayIndex++]  = myClassObj;
				}		
		}		

	if (item_arr.length == 0){
		alert(getMessage("ATLEAST_ONE_TRANS","ST"));
		return;
	}

	for (var i=0;i<item_arr.length ;i++ ){
		var item_batch = item_arr[i];
		if ((item_batch.item_qty == '' ) || (parseFloat(item_batch.item_qty) == '0')){
			if (item_batch.item_qty == '' ){
				alert(getMessage("RET_QTY_CANNOT_BLANK","ST"));
				eval("formObj.item_qty_"+doc_no+"_"+doctypecode+"_"+i).focus();	 //modified for IN074078
				return;
			}
			if (parseFloat(item_batch.item_qty) == '0'){
				alert(getMessage("RET_QTY_CANNOT_ZERO","ST"));
				eval("formObj.item_qty_"+doc_no+"_"+doctypecode+"_"+i).focus();	 //modified for IN074078
				return;
			}
		}else if ((item_batch.sal_item_qty*1) < (item_batch.item_qty*1)){
			alert(getMessage("RET_QTY_NOT_GRT_MAX_RET_QTY","ST"));
			eval("formObj.item_qty_"+doc_no+"_"+doctypecode+"_"+i).focus();	//modified for IN074078		
			return;
		}
	}
	var loc_batch_string ="";
	for (var i=0;i<item_arr.length ;i++ ){
		var item_batch = item_arr[i];
		//loc_batch_string = loc_batch_string+"||"+item_batch.trade_id+";"+item_batch.batch_id+";"+item_batch.expiry_date_or_receipt_date+";"+item_batch.bin_location_code+";"+item_batch.item_qty+";"+item_batch.item_code+";"+item_batch.sal_item_qty+";"+item_batch.item_name+";"+item_batch.uom_code+";"+item_batch.uom_desc+";"+item_batch.doc_srl_no+";"+item_batch.trade_name+";"+item_batch.bin_location_desc+";"+item_batch.refund_allow_yn;
		//loc_batch_string = loc_batch_string+"||"+item_batch.trade_id+";"+item_batch.batch_id+";"+item_batch.expiry_date_or_receipt_date+";"+item_batch.bin_location_code+";"+item_batch.item_qty+";"+item_batch.item_code+";"+item_batch.sal_item_qty+";"+item_batch.uom_code+";"+item_batch.uom_desc+";"+item_batch.doc_srl_no+";"+item_batch.trade_name+";"+item_batch.bin_location_desc+";"+item_batch.refund_allow_yn;
		loc_batch_string = loc_batch_string+"||"+item_batch.trade_id+";"+item_batch.batch_id+";"+item_batch.expiry_date_or_receipt_date+";"+item_batch.bin_location_code+";"+item_batch.item_qty+";"+item_batch.item_code+";"+item_batch.sal_item_qty;
	}
	formCriteria.loc_batch_string.value= loc_batch_string;
	
	var xmlHttp = new XMLHttpRequest();
	var xmlDoc="";
	xmlDoc.loadXML(getEnhancedXMLString(formCriteria));

	var selected_doc_no = formObj.selected_doc_no.value;
	var patient_id      = formObj.patient_id.value;
	var encounter_id    = formObj.encounter_id.value;
	var sal_trn_type    = formObj.sal_trn_type.value;
	//var store_code      = formObj.store_code.value;
	var store_code = document.getElementById("store_code").value;
//	xmlHttp.open("POST", "../../eST/jsp/SalesReturnValidate.jsp?&doc_no="+selected_doc_no+"&batch_string="+loc_batch_string+"&patient_id="+patient_id+"&encounter_id="+encounter_id+"&validate=LOAD_DETAILS_NEW&sal_trn_type="+sal_trn_type+"&doc_type_code="+doc_type_code+"&store_code="+store_code, false);
	xmlHttp.open("POST", "../../eST/jsp/SalesReturnValidate.jsp?&doc_no="+selected_doc_no+"&patient_id="+patient_id+"&encounter_id="+encounter_id+"&validate=LOAD_DETAILS_NEW&sal_trn_type="+sal_trn_type+"&doc_type_code="+doc_type_code+"&store_code="+store_code, false);

	xmlHttp.send(xmlDoc);	
	responseText=xmlHttp.responseText;	
	eval(responseText);	
    if(result){	
		//document.parentWindow.returnValue ="ADD"+"||"+doc_type_code+"||"+doc_no+"||"+sal_patient_name;
		//document.parentWindow.close();
    	parent.document.getElementById('dialog-body').contentWindow.returnValue =="ADD"+"||"+doc_type_code+"||"+doc_no+"||"+sal_patient_name;
    	parent.document.getElementById("dialog_tag").close();
		}	
    else{
    	if(message!=""){
		alert(getMessage(message, "ST"));
	}
    }
}

async function searchItemCode(obj) {
	var result = false;
	var message = "";
	var flag = "";
	var function_id = "";
	var argumentArray  = new Array();
	var dataNameArray  = new Array();
	var dataValueArray = new Array();
	var dataTypeArray  = new Array();
	dataNameArray[0] = "language_id";
	dataValueArray[0]= localeName;
	dataTypeArray[0] = STRING;
	argumentArray[0] = document.formSalesReturnSearchWindowCriteria.SQL_ST_ITEM_LOOKUP.value;
	argumentArray[1] = dataNameArray;
	argumentArray[2] = dataValueArray;
	argumentArray[3] = dataTypeArray;
	argumentArray[4] = "2,3";
	argumentArray[5] = document.formSalesReturnSearchWindowCriteria.item_desc.value;
	argumentArray[6] = CODE_LINK;
	argumentArray[7] = CODE_DESC;
	returnedValues =await CommonLookup(getLabel("Common.item.label", "Common"), argumentArray);
	if ((returnedValues != null) && (returnedValues != "")) {
		obj.value = returnedValues[1];
		document.formSalesReturnSearchWindowCriteria.item_code.value = returnedValues[0];
	}
	else
	{
		obj.value ="";
		document.formSalesReturnSearchWindowCriteria.item_code.value =""
	}
}

function ReloadSaleWindow(){
		var criteriaformObj =document.formSalesReturnSearchWindowCriteria;

		  criteriaformObj.item_desc.value     =  "";
		  criteriaformObj.item_code.value     =  "";
		  criteriaformObj.doc_no.value		  =  "";
		  //criteriaformObj.from_doc_date.value =  "";
		  //criteriaformObj.to_doc_date.value   =  "";			  
		  criteriaformObj.batch_id.value =  "";
		  criteriaformObj.expiry_date.value =  "";
		  criteriaformObj.trade_id.value   =  "";	
		  criteriaformObj.binlocation.value   =  "";

			  
		 if( criteriaformObj.sal_trn_type.value== 'X'){
		  criteriaformObj.patient_name.value  =  "";
		 }  	  
		  criteriaformObj.search.click();
		  criteriaformObj.item_desc.focus();
}

async function searchNursingUnit(obj) {
	var result = false;
	var message = "";
	var flag = "";
	var function_id = "";
	var argumentArray  = new Array();
	var dataNameArray  = new Array();
	var dataValueArray = new Array();
	var dataTypeArray  = new Array();

	dataNameArray[0] = "language_id";
	dataValueArray[0]= localeName;
	dataTypeArray[0] = STRING;

	argumentArray[0] = "SELECT  code , description FROM (SELECT nursing_unit_code code, short_desc description,language_id  FROM ip_nursing_unit_lang_vw UNION SELECT clinic_code code, short_desc description,language_id   FROM op_clinic_lang_vw ) WHERE language_id LIKE (?) AND  upper(code) LIKE  upper(?) AND upper(description)  LIKE  upper(?)";

	argumentArray[1] = dataNameArray;
	argumentArray[2] = dataValueArray;
	argumentArray[3] = dataTypeArray;
	argumentArray[4] = "2,3";
	argumentArray[5] = document.formSalesReturnQueryCriteria.nursing_unit_desc.value;
	argumentArray[6] = CODE_LINK;
	argumentArray[7] = CODE_DESC;
	returnedValues =await CommonLookup(getLabel("eST.nursingunit/clinic.label", "eST"), argumentArray);
	if ((returnedValues != null) && (returnedValues != "")) {
		obj.value = returnedValues[1];
		document.formSalesReturnQueryCriteria.nursing_unit_code.value = returnedValues[0];
	}
	else{
		obj.value ="";
		document.formSalesReturnQueryCriteria.nursing_unit_code.value ="";
	}
}

function NursingUnitList(){
	var formObj = document.formSalesReturnQueryCriteria;
	var fromdate = formObj.doc_date.value;
	var todate = formObj.to_doc_date.value;
	if (formObj.nursing_unit_code != undefined) {
		var xmlHttp = new XMLHttpRequest();
		var xmlDoc="";
		xmlDoc.loadXML(getXMLString(null));
		xmlHttp.open("POST", "../../eST/jsp/SalesReturnValidate.jsp?validate=NURSING_UNIT_LIST&fromdate=" + fromdate +"&todate=" + todate, false);
		xmlHttp.send(xmlDoc);
		responseText = xmlHttp.responseText;
		eval(responseText);
	}
}

function searchItemCodeforBarcode(e,obj) {	
	 if(e.keyCode==13 || e.keyCode== 9 || e.keyCode== 0){
		var formObj = document.formSalesReturnSearchWindowCriteria;
		var barcode_appl = formObj.barcode_applicable1.value;
		var bean_id = formObj.bean_id.value;
		var bean_name = formObj.bean_name.value;
		if(barcode_appl == "Y"){
		if (obj!= undefined && obj.value!= "") {
			var xmlHttp = new XMLHttpRequest();
			var xmlDoc="";
			xmlDoc.loadXML(getXMLString(null));
			xmlHttp.open("POST", "../../eST/jsp/CommonSearchValidate.jsp?trn_type=SRT" +  "&bar_code=" + formObj.item_desc.value +  "&store_code=" + formObj.store_code.value  + "&bean_id="  + bean_id + "&bean_name=" + bean_name + "&formObj=formSalesReturnSearchWindowCriteria" + "&BARCODE_YN=TRUE&validate=SETDETAILS_SRT", false);
			xmlHttp.send(xmlDoc);
			responseText = xmlHttp.responseText;
			eval(responseText);			
			if(result){
			formObj.search.focus();
			formObj.search.click();
			}else{		
				if(message!=""){
				alert(getMessage(message, "ST"));
				formObj.item_desc.focus();
				}
			}
			}
		}else{
		searchItemCode(obj);
		}
		}
}

//Added by suresh r  14-11-2013 against JD-CRF-156 beg
function callDispCurrEncFinDtlVal(){
	var formObj = document.formSalesReturnHeader;
	var patient_id=formObj.patient_id.value;
	var encounter_id=formObj.encounter_id.value;
	//var store_code=formObj.store_code.value;
	var store_code = document.getElementById("store_code").value;
	var pat_class=formObj.patient_classcode.value;
	var xmlString = getXMLString(null);
    var xmlDoc = new DOMParser().parseFromString(xmlString, "text/xml");
	var xmlHttp = new XMLHttpRequest();
	//var xmlDoc="";
	//xmlDoc.loadXML(getXMLString(null));
	xmlHttp.open("POST", "../../eST/jsp/SalesReturnValidate.jsp?patient_id=" + patient_id + "&validate=VAL_DISPFINDTL&encounter_id=" +encounter_id+"&pat_class="+pat_class+"&store_code=" + store_code , false); 
	xmlHttp.setRequestHeader("Content-Type", "text/xml");
	xmlHttp.send(xmlString);
	var responseText = xmlHttp.responseText;
	responseText = trimString(responseText);
	eval(responseText);
}
//Added by suresh r  14-11-2013 against JD-CRF-156 end
//Added against GHL-CRF-0413.5 starts
function callBarCodeBatchSearchSRT(e,barcode,trntype,fromStore,toStore,formObj,bean_id,bean_name,ListHeader,ListDetail,Detail){
	if(e.keyCode==9 || e.keyCode== 13  || e.keyCode== 0){
		if(parent.frames[1].document.forms[0] != null){
			/*var xmlHttp  = new ActiveXObject("Microsoft.XMLHTTP");
			var xmlDoc   = new ActiveXObject("Microsoft.XMLDom");*/
			var xmlDom = "";
		    var xmlHttp = new XMLHttpRequest();
			xmlDoc.loadXML(getXMLString(null));
			xmlHttp.open("POST", "../../eST/jsp/CommonSearchValidate.jsp?&store_code="+fromStore.value+"&barcode=" + barcode.value + "&bean_id=" + bean_id + "&bean_name=" + bean_name + "&BARCODE_YN=TRUE" +  "&validate=VALID_BARCODE", false);
			xmlHttp.send(xmlDoc);
			responseText = xmlHttp.responseText;
			eval(responseText);
			if(result){
			var xmlHttp = new XMLHttpRequest();
			var xmlDoc="";
			xmlDoc.loadXML(getXMLString(null));
				xmlHttp.open("POST", "../../eST/jsp/SalesReturnValidate.jsp?&store_code="+fromStore.value+"&barcode=" + barcode.value+  "&validate=VALIDATE_STORE", false);
				xmlHttp.send(xmlDoc);
				responseText = xmlHttp.responseText;
				eval(responseText);
				if(result){
			var xmlHttp = new XMLHttpRequest();
			var xmlDoc="";
			xmlDoc.loadXML(getXMLString(null));
			xmlHttp.open("POST", "../../eST/jsp/SalesReturnValidate.jsp?&store_code="+fromStore.value+"&barcode=" + barcode.value +  "&validate=VALIDATE_SRT", false);
			xmlHttp.send(xmlDoc);
			responseText = xmlHttp.responseText;
			eval(responseText);
			if(result){
				//var index = parent.frames[1].document.forms[0].total_checkboxes.value ;
				var index = document.getElementById("total_checkboxes").value ;
				var xmlHttp = new XMLHttpRequest();
				var xmlDoc="";
				xmlDoc.loadXML(getXMLString(null));
				xmlHttp.open("POST", "../../eST/jsp/CommonSearchValidate.jsp?&validate=BATCH_EXP_DETAILS"+"&barcode=" + barcode.value + "&bean_id=" + bean_id + "&bean_name=" + bean_name + "&BARCODE_YN=TRUE", false);
				xmlHttp.send(xmlDoc);
				responseText = xmlHttp.responseText;
				eval(responseText);
				if(result){
					var item_qty = 0;
					item_qty = parent.frames[0].document.forms[0].item_qty.value;
					var temp_val=item_qty;//Added for GHL-CRF-0462
					item_qty++;
					parent.frames[0].document.forms[0].item_qty.value =item_qty;
					if(parent.frames[0].document.forms[0].tot_item_qty!=undefined){
parent.frames[0].document.forms[0].tot_item_qty.value =item_qty*parent.frames[0].document.forms[0].conv_factor.value ;//Modified for TFS id: 11896
					}
					if (parseFloat(parent.frames[0].document.forms[0].item_qty.value) > parseFloat(document.getElementById("id_pending_qty").innerText)) {
						alert(getMessage("RET_QTY_NOT_GRT_MAX_RET_QTY", "ST"));
						//parent.frames[0].document.forms[0].item_qty.focus();
						parent.frames[0].document.forms[0].item_qty.value=temp_val;// added for GHL-CRF-0462 START
						parent.frames[0].document.forms[0].item_qty.focus();
						parent.frames[0].document.forms[0].barcode.value = "";
						parent.frames[0].document.forms[0].barcode.focus();// added for GHL-CRF-0462 END
						return false; 
					}
						var xmlHttp = new XMLHttpRequest();
						var xmlDoc="";
						xmlDoc.loadXML(getXMLString(null));
						xmlHttp.open("POST", "../../eST/jsp/CommonSearchValidate.jsp?&validate=ITEM_QTY_INCREMENT"+"&barcode=" + barcode.value + "&bean_id=" + bean_id + "&bean_name=" + bean_name + "&BARCODE_YN=TRUE", false);
						xmlHttp.send(xmlDoc);
						responseText = xmlHttp.responseText;
						eval(responseText);
						if(result){
							var resultArray	;
							resultArray = message.split(";");
							var  m   = 	resultArray[0];
							var itm_qty = eval("parent.frames[1].document.forms[0].item_qty_"+m).value;
							var temp_item_qty = itm_qty;//Added against GHL-CRF-0462 Chithra
							itm_qty=parseFloat(itm_qty)+parseFloat(parent.frames[0].document.forms[0].conv_factor.value);//Modified for TFS id: 11896
							var item_qty_ = eval("parent.frames[1].document.forms[0].item_qty_"+m);
							item_qty_.value = parseInt(itm_qty) ;
							viewBatchChargesBarcode(parseInt(m));
							TotalBatchChargesBarcode();
							if (parseFloat(eval("parent.frames[1].document.forms[0].available_qty_"+m).value) < parseFloat(parseInt(itm_qty) )) {
							/*	alert(getMessage("TFR_QTY_LESS_THAN_AVL_QTY", "ST"));
								item_qty_.focus();*/
		
							
								alert(getMessage("TFR_QTY_LESS_THAN_AVL_QTY_BARCODE", "ST")); //added for GHL-CRF-0462 start
								item_qty_.value= parseInt(temp_item_qty) ;
								autoQtyUpdate();//GHL-CRF-0462 End
							//	parent.frames[0].document.forms[0].barcode.value = "";
							}
						}
					parent.frames[0].document.forms[0].barcode.value = "";
					}
					else{
						//var index = parent.frames[1].document.forms[0].total_checkboxes.value ;
						var index = document.getElementById("total_checkboxes").value ;
						index++;
						var xmlHttp = new XMLHttpRequest();
						var xmlDoc="";
						xmlDoc.loadXML(getXMLString(null));
						xmlHttp.open("POST", "../../eST/jsp/CommonSearchValidate.jsp?&validate=BARCODECHECK_SAMEITEM"+"&store_code="+fromStore.value+"&barcode=" + barcode.value + "&bean_id=" + bean_id + "&bean_name=" + bean_name + "&BARCODE_YN=TRUE", false);//"&valid_item_code=" + valid_item_code + 
						xmlHttp.send(xmlDoc);
						responseText = xmlHttp.responseText;
						eval(responseText);
						if(result)
							{
							//if(parent.parent.frames[0].document.forms[0].store_code != undefined)
							if(document.getElementById("store_code")!=undefined)
								//var store_code = parent.parent.frames[0].document.forms[0].store_code.value;
								var store_code = document.getElementById("store_code").value;
							else
								//var store_code = parent.parent.frames[0].document.forms[0].from_store_code.value;
								var store_code = document.getElementById("store_code").value;
							//var index = parent.frames[1].document.forms[0].total_checkboxes.value ;
							var index = document.getElementById("total_checkboxes").value ;
							var qtyList=[] ;
							for(var m=0 ; m< index; m++){
								qtyList.push(	eval("parent.frames[1].document.forms[0].item_qty_"+m).value);
							}
							qtyList.push(parseInt(parent.frames[0].document.forms[0].conv_factor.value));//Modified for TFS id: 11896
							var item_qty=0;
							item_qty = parent.frames[0].document.forms[0].item_qty.value;
							item_qty++;
							var defaultqty_appl= parent.parent.frames[0].document.forms[0].defaultqty_appl1.value;
							var site = parent.frames[0].document.forms[0].site.value;
							var toStore		= toStore.value;
							if (toStore==undefined)
								toStore="";
							parent.frames[0].document.forms[0].item_qty.value =item_qty;
							CheckQuantity(parent.frames[0].document.forms[0].item_qty);
							if(parent.frames[0].document.forms[0].tot_item_qty!=undefined){
								parent.frames[0].document.forms[0].tot_item_qty.value =item_qty*parseInt(parent.frames[0].document.forms[0].conv_factor.value) ;//Modified for TFS id: 11896
							}
							if (document.forms[0].bar_or_item_code.value == 'B'){
							    	editViewBatchForBarCode1(ListDetail,fromStore.value,barcode.value,"N",qtyList,trntype.value);
							    	parent.frames[0].document.forms[0].barcode.value = "";
								}
							}else{
						if (confirm("Proceed with the next Item?") == true) {
							addToListforBarcode();										
					    } else {
					    	 parent.frames[0].document.forms[0].barcode.value = "";
 					    	 return false;
						}
					}
				}
			}else{
				alert(getMessage("BARCODE_NOT_FOUND_SAL_DOC", "ST"));
				parent.frames[0].document.forms[0].barcode.value = "";
				return false;
			}
			}
			else{
				alert(getMessage("ITEM_STORE_NOT_FOUND1", "ST"));
				parent.frames[0].document.forms[0].barcode.value = "";
				return false;
			}
			}else{
				alert(getMessage("ST_INVALID_BAR_CODE", "ST"));
				parent.frames[0].document.forms[0].barcode.value = "";
				return false;
			}
		}
		else{
			callBarCodeBatchSearch(e,barcode,trntype,fromStore,toStore,formObj,bean_id,bean_name,ListHeader,ListDetail,Detail);
		}
	}
}
function callBarCodeBatchSearch(e,barcode,trntype,fromStore,toStore,formObj,bean_id,bean_name,ListHeader,ListDetail,Detail){
	if(e.keyCode==9 || e.keyCode== 13  || e.keyCode== 0){
		var xmlHttp = new XMLHttpRequest();
		var xmlDoc="";
		xmlDoc.loadXML(getXMLString(null));
		xmlHttp.open("POST", "../../eST/jsp/CommonSearchValidate.jsp?&store_code="+fromStore.value+"&barcode=" + barcode.value + "&bean_id=" + bean_id + "&bean_name=" + bean_name + "&BARCODE_YN=TRUE" +  "&validate=VALID_BARCODE", false);
		xmlHttp.send(xmlDoc);
		responseText = xmlHttp.responseText;
		eval(responseText); 
		if(result){
			var xmlHttp = new XMLHttpRequest();
			var xmlDoc="";
			xmlDoc.loadXML(getXMLString(null));
			xmlHttp.open("POST", "../../eST/jsp/SalesReturnValidate.jsp?&store_code="+fromStore.value+"&barcode=" + barcode.value+  "&validate=VALIDATE_STORE", false);
			xmlHttp.send(xmlDoc);
			responseText = xmlHttp.responseText;
			eval(responseText);//alert(responseText);
		if(result){
		var xmlHttp = new XMLHttpRequest();
		var xmlDoc="";
		xmlDoc.loadXML(getXMLString(null));
		xmlHttp.open("POST", "../../eST/jsp/SalesReturnValidate.jsp?&store_code="+fromStore.value+"&barcode=" + barcode.value+"&trntype=" + trntype.value + "&bean_id=" + bean_id + "&bean_name=" + bean_name + "&BARCODE_YN=TRUE" +  "&validate=VALIDATE_SRT", false);
		xmlHttp.send(xmlDoc);
		responseText = xmlHttp.responseText;
		eval(responseText);
		if(result){
			document.forms[0].bar_or_item_code.value = 'B';
			var bar_code	= barcode.value;
			var trn_type	= trntype.value;
			var fromStore   = fromStore.value;
			var toStore		= toStore.value;
			var formObj		= formObj.name; 
			var barcode_appl = parent.parent.frames[0].document.forms[0].barcode_applicable1.value;
			if (toStore==undefined)
				toStore="";
				var qtyList=[] ;
				editViewBatchForBarCode1(ListDetail,fromStore,bar_code,"N",qtyList,trntype.value);
				if (parent.parent.frames[0].document.forms[0].defaultqty_appl1.value == 'Y'  && parent.parent.frames[0].document.forms[0].editqty_appl1.value=='N') {
					parent.frames[0].document.forms[0].barcode.disabled = false;
					parent.frames[0].document.forms[0].barcode.value = "";
					parent.frames[0].document.forms[0].barcode.focus();
				}else if(parent.parent.frames[0].document.forms[0].defaultqty_appl1.value == 'N'){
					if(document.forms[0].item_qty!=undefined)
						document.forms[0].item_qty.focus();
				}
				parent.frames[0].document.forms[0].apply.value ="Modify";
			}
			else{
				if(getMessage(message, "ST") != ""){
					alert(getMessage(message, "ST"));
					refreshDetailsforBarCode('999',ListHeader,Detail,'','','','','');
				}
				else{
					alert(getMessage("BARCODE_NOT_FOUND_SAL_DOC", "ST"));
					parent.frames[0].document.forms[0].barcode.value = "";
					return false;
				}
			}
		}
		else{
			alert(getMessage("ITEM_STORE_NOT_FOUND1", "ST"));
			 parent.frames[0].document.forms[0].barcode.value = "";
			return false;
			}
		}
		else{
			alert(getMessage("ST_INVALID_BAR_CODE", "ST"));
			 parent.frames[0].document.forms[0].barcode.value = "";
			return false;
			}
		}
}
function callItemQtyUpdate(){ 
	var itmqty ;
	if(parent.frames[0].document.forms[0].item_qty!=undefined && parent.frames[0].document.forms[0].item_qty.value != ""){
	 itmqty = parent.frames[0].document.forms[0].item_qty.value;
	}
	else{
	 itmqty = "1";
	}
	var Obj	=  parent.parent.frames[0].document.forms[0].defaultqty_value1;
	var bar_appl = parent.parent.frames[0].document.forms[0].barcode_applicable1;
	if(bar_appl.value=='Y' && document.forms[0].item_code.value!=null){
	if(Obj.value==1 && parent.parent.frames[0].document.forms[0].editqty_appl1.value != 'Y' &&  document.forms[0].bar_or_item_code.value == 'B'){ 
		if (parent.frames[1].document.forms[0] != undefined && itmqty=="1") {
			//var index = parent.frames[1].document.forms[0].total_checkboxes.value ;
			var index = document.getElementById("total_checkboxes").value ;
				if(parent.frames[0].document.forms[0].noofbatchesforbarcode.value=="1"){
					if(parent.frames[0].document.forms[0].iss_uom_qty!=undefined){
						parent.frames[0].document.forms[0].iss_uom_qty.value = Obj.value;
					}				
					parent.frames[0].document.forms[0].item_qty.value = Obj.value;
					if(parent.frames[0].document.forms[0].tot_item_qty!=undefined){
					parent.frames[0].document.forms[0].tot_item_qty.value = Obj.value*parent.frames[0].document.forms[0].conv_factor.value;//Modified for TFS id: 11896
					}else if(parent.frames[0].document.forms[0].ret_qty!=undefined){
					parent.frames[0].document.forms[0].ret_qty.value= Obj.value*parent.frames[0].document.forms[0].conv_factor.value;//Modified for TFS id: 11896
					}
				}
			if (parseInt(index)==1){
				parent.frames[1].document.forms[0].item_qty_0.value = Obj.value*parent.frames[0].document.forms[0].conv_factor.value;//Modified for TFS id: 11896
				viewBatchChargesBarcode(0);
				TotalBatchChargesBarcode();
			}
	  }
	}
	else if(document.forms[0].item_qty.value>0){
		if (parent.frames[1].document.forms[0] != undefined) {
		//var index = parent.frames[1].document.forms[0].total_checkboxes.value ;	
		var index = document.getElementById("total_checkboxes").value ;	
		if (parseInt(index)==1 ){			
			var item_qty_new = document.forms[0].item_qty;
			parent.frames[1].document.forms[0].item_qty_0.value = document.forms[0].item_qty.value;
			var avail_qty = parent.frames[1].document.forms[0].available_qty_0.value ;
			var dec_allowed_yn = parent.frames[1].document.forms[0].dec_allowed_yn.value ;			
			var qty_val = checkBatchQtyforBarcode(item_qty_new,avail_qty,dec_allowed_yn);
			var tot_item_qty;
			if(document.forms[0].tot_item_qty!=undefined)
			var tot_item_qty = document.forms[0].tot_item_qty.value ;
			else
			var tot_item_qty = document.forms[0].ret_qty.value;
			if(qty_val)
			chargeDetailsExp(document.forms[0].item_code.value,tot_item_qty);   
			}
			}else{
			}
		}
	}
	CheckQuantity(parent.frames[0].document.forms[0].item_qty);
}
function calHeaderDetails(bar_code,item_code){
	var bar_code	= bar_code;
	var item_code	= item_code;
	if(item_code == parent.frames[0].document.forms[0].item_code.value || parent.frames[0].document.forms[0].item_code.value==''){
	var xmlHttp = new XMLHttpRequest();
	var xmlDoc="";
	xmlDoc.loadXML(getXMLString(null));
	xmlHttp.open("POST", "../../eST/jsp/SalesReturnValidate.jsp?&item_code="+item_code+"&bar_code=" + bar_code +  "&validate=HEADER_DETAILS", false);
	xmlHttp.send(xmlDoc);
	responseText = xmlHttp.responseText;
	eval(responseText); 
	}
}
function TotalBatchChargesBarcode(){
	var formObj = document.formSalesReturnListHeader;
	var formObj1= parent.frames[1].document.forms[0];
	var xmlHttp = new XMLHttpRequest();
	var xmlDoc="";
	var patient_id = parent.parent.frameSalesReturnHeader.document.formSalesReturnHeader.patient_id.value;
	var encounter_id = parent.parent.frameSalesReturnHeader.document.formSalesReturnHeader.encounter_id.value;
	var sal_trn_type = parent.parent.frameSalesReturnHeader.document.formSalesReturnHeader.sal_trn_type.value;
    var total_checkboxes = formObj1.total_checkboxes.value;
	var total_gross_amt = 0;
    var total_net_amt = 0;
	for (var j=0;j<total_checkboxes;j++)
	{
    total_gross_amt = parseFloat(total_gross_amt)+parseFloat(eval("formObj1.gross_charge_amt_"+j).value);
	total_net_amt =  parseFloat(total_net_amt)+parseFloat(eval("formObj1.net_charge_amt_"+j).value);
    } 	
	if(parent.parent.frameSalesReturnHeader.document.formSalesReturnHeader.bl_install_yn.value=="Y"){
	parent.frameSalesReturnListHeader.document.getElementById("id_payable_amt").innerText = total_net_amt.toFixed(2);
	parent.frameSalesReturnListHeader.document.getElementById("id_charge_amt").innerText = total_gross_amt.toFixed(2);
    }
}
function viewBatchChargesBarcode(obj){
	var formObj = document.formSalesReturnListHeader;
	var formObj1=parent.frames[1].document.forms[0];
	var xmlHttp = new XMLHttpRequest();
	var xmlDoc="";
	var patient_id = parent.parent.frameSalesReturnHeader.document.formSalesReturnHeader.patient_id.value;
	var encounter_id = parent.parent.frameSalesReturnHeader.document.formSalesReturnHeader.encounter_id.value;
	var sal_trn_type = parent.parent.frameSalesReturnHeader.document.formSalesReturnHeader.sal_trn_type.value;
    var item_code = parent.frameSalesReturnListHeader.document.formSalesReturnListHeader.item_code.value;
	for (var j=obj;j<obj+1;j++ )
	{
    var	item_qty = eval("formObj1.item_qty_"+j).value;
    var batch_data  = eval("formObj1.trade_id1_"+j).value +";"+ eval("formObj1.batch_id_"+j).value+";"+ eval("formObj1.expiry_date_or_receipt_date_"+j).value+ ";"  +  eval("formObj1.bin_location_code_"+j).value + ";" +  eval("formObj1.item_qty_"+j).value + ";" ;
      if ((eval("formObj1.item_qty_"+j).value) != ""  && parent.parent.frameSalesReturnHeader.document.formSalesReturnHeader.bl_install_yn.value=="Y" ){
		xmlDoc.loadXML(getXMLString(null));
		xmlHttp.open("POST", "../../eST/jsp/SalesReturnValidate.jsp?item_code=" + item_code + "&patient_id=" + patient_id + "&sal_trn_type=" + sal_trn_type + "&encounter_id=" + encounter_id + "&item_qty=" +item_qty + "&batch_data=" + batch_data + "&validate=ITEMCHARGE_DTLS", false);
		xmlHttp.send(xmlDoc);
		responseText = xmlHttp.responseText;
		eval(responseText);
		if (result && message.length > 0) {
			results = message.split(",");
			for (var i = 0; i < 23; i++) {
				insind = results[0];
				baseqty = results[1];
				baserate = results[2];
				basechargeamt = results[3];
				grosschargeamt = results[4];
				discountper = results[5];
				discountamt = results[6];
				daytypecode = results[7];
				daytypedesc = results[8];
				timetypecode = results[9];
				timetypedesc = results[10];
				addlfactor = results[11];
				ordercatalogcode = results[12];
				ordercatalogdesc = results[13];
				blngservcode = results[14];
				blngservdesc = results[15];
				netchargeamt = results[16];
				patgrosschargeamt = results[17];
				patdiscamt = results[18];
				patnetamt = results[19];
				custgrosschargeamt = results[20];
				custdiscamt = results[21];
				custnewamt = results[22];
			}
			if (parent.frameSalesReturnListHeader.document.getElementById("id_payable_amt")) {
				parent.frameSalesReturnListHeader.document.getElementById("id_payable_amt").innerText = netchargeamt;
				grosschargeamt_val = grosschargeamt;
				parent.frameSalesReturnListHeader.document.getElementById("id_charge_amt").innerText = grosschargeamt;
				eval("formObj1.gross_charge_amt_"+j).value = grosschargeamt;
				eval("formObj1.net_charge_amt_"+j).value = netchargeamt;
			}
		} else {
			if (!result) {
				parent.parent.parent.messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num=" + message;
			}
		}
	}
	else
		{
		if(parent.parent.frameSalesReturnHeader.document.formSalesReturnHeader.bl_install_yn.value=="Y"){
		eval(document.getElementById("gross_charge_amt_"+j)).value = "0.00";
		eval(document.getElementById("net_charge_amt_"+j)).value   = "0.00";
		}
	}
	}
}
function addToListforBarcode(){
if(parent.frameSalesReturnListDetail.document.formSalesReturnListDetail != undefined) {
	var formObjBarcode = parent.frameSalesReturnListHeader.document.formSalesReturnListHeader;
	var xmlHttp = new XMLHttpRequest();
	var xmlDoc="";
	xmlDoc.loadXML(getXMLString(null));
	xmlHttp.open("POST", "../../eST/jsp/SalesReturnValidate.jsp?doc_srl_no_forbean=" + parent.frames[1].document.forms[0].doc_srl_no_forbean.value + "&item_code="+formObjBarcode.item_code.value+"&barcode="+formObjBarcode.barcode.value+ "&validate=SET_IN_BEAN_SRT", false);
	xmlHttp.send(xmlDoc);
	responseText = xmlHttp.responseText;
	eval(responseText);
}
	var formObjDtl = parent.parent.frameSalesReturnDetail.document.formSalesReturnDetail;
	var return_allowed_yn=formObjDtl.return_allowed_yn.value;
	var checkBoxObj = null;
	var forDeletion = "";
	var noDetailExists = true;
	for (i = 0; i < parseInt(formObjDtl.total_checkboxes.value); i++) {
		checkBoxObj = eval("formObjDtl.checkbox" + i);
		if (checkBoxObj.checked) {
			forDeletion += ("Y,");
		} else {
			forDeletion += ("N,");
			noDetailExists = false;
		}
	}
	var formObjHdr = parent.parent.frameSalesReturnHeader.document.formSalesReturnHeader;
	forDeletion = forDeletion.substring(0, forDeletion.length - 1);
	formObjHdr.records_to_delete.value = forDeletion
	var formObj = parent.frameSalesReturnListHeader.document.formSalesReturnListHeader;
	//var store_code = parent.parent.frameSalesReturnHeader.document.formSalesReturnHeader.store_code.value;
	var store_code = document.getElementById("store_code").value;
	var sal_trn_type = parent.parent.frameSalesReturnHeader.document.formSalesReturnHeader.sal_trn_type.value;
	var patient_id = parent.parent.frameSalesReturnHeader.document.formSalesReturnHeader.patient_id.value;
	var encounter_id = parent.parent.frameSalesReturnHeader.document.formSalesReturnHeader.encounter_id.value;
	var arrayObject = new Array(formObj.item_code, formObj.item_qty);
	var names = new Array(getLabel("Common.item.label", "Common"), getLabel("Common.Quantity.label", "Common"));
	var blankObject = checkSTFields(arrayObject, names, parent.parent.parent.messageFrame);
	if (blankObject == true) {
		if (formObj.item_qty.value == "0") {
			alert("Quantity Cannot Be Zero");
			return;
		}
		formObj.apply.disabled = true;
		if (parent.frameSalesReturnListDetail.document.formSalesReturnListDetail == null) {
			var formObj = document.formSalesReturnListHeader;
			//var store_code = parent.parent.frameSalesReturnHeader.document.formSalesReturnHeader.store_code.value;
			var store_code = document.getElementById("store_code").value;
			var _item_code = formObj.item_code.value;
			var item_qty = formObj.tot_item_qty.value;
			parent.frameSalesReturnListDetail.location.href = "../../eST/jsp/SalesReturnListDetail.jsp?function=edit&store_code=" + store_code + "&patient_id=" + patient_id + "&encounter_id=" + encounter_id + "&sal_trn_type=" + sal_trn_type + "&item_code=" + _item_code + "&store_code=" + store_code + "&item_qty=" + item_qty + "&index=" + formObj.index.value + "&function_id" + parent.parent.function_id + "&addToList=true";
			return;
		}
		var formObjDtl = parent.parent.frameSalesReturnList.frameSalesReturnListDetail.document.formSalesReturnListDetail;
		var proceed = false;
		var messageFrame = parent.parent.messageFrame;
		var errorPage = "../../eCommon/jsp/error.jsp";
		var item_qty = formObj.tot_item_qty.value;
		_total_checkboxes = formObjDtl.total_checkboxes.value;
		var no_of_decimals=formObj.no_of_decimals.value;
		var sum = 0;
		for (i = 0; i < _total_checkboxes; i++) {
			var qty = eval("formObjDtl.item_qty_" + i).value;
			if (qty == "") {
				qty = 0;
			}
			if (!isNaN(qty)) {
				sum += parseFloat(qty);
			}
		}
		if(formObjDtl.dec_allowed_yn.value=='Y')
			sum=sum.toFixed(no_of_decimals);
		if (sum != item_qty) {
			alert(getMessage("QUANTIY_MUST_BE_EQUAL", "ST"));
			formObj.apply.disabled = false;
			return;
		}
		for (i = 0; i < _total_checkboxes; i++) {
			var bin_location_name = "bin_location_code_" + i;
			var bin_location_code = eval("formObjDtl.bin_location_code_" + i).value;
			if (bin_location_code == "") {
				alert(getMessage("BIN_LOCN_NOT_BLANK", "ST"));
				eval("formObjDtl.bin_location_code_" + i).focus();
				formObj.apply.disabled = false;
				return;
			}
		}
		var xmlHttp = new XMLHttpRequest();
		var xmlDoc="";
		xmlDoc.loadXML(getEnhancedXMLString(formObjDtl));
		if (parent.parent.frameSalesReturnHeader.document.formSalesReturnHeader.chargeable_yn.value == "Y" && formObj.billable_item_yn.value=="Y" ) {
			xmlHttp.open("POST", "../../eST/jsp/SalesReturnValidate.jsp?index=" + formObj.index.value + "&doc_srl_no_forbean="+formObjDtl.doc_srl_no_forbean.value+"&site="+formObj.site.value+ "&doc_srl_no=" + formObj.doc_srl_no.value + "&store_code=" + store_code + "&item_code=" + formObj.item_code.value + "&item_desc=" + encodeURIComponent(formObj.item_desc.value) + "&item_qty=" + formObj.item_qty.value + "&item_unit_cost=" + document.getElementById("store_item_unit_cost").value + "&item_cost_value=" + formObj.id_item_sal_value.value + "&pat_net_amt=" + parent.frameSalesReturnListHeader.document.getElementById("id_payable_amt").innerText + "&expiry_yn=" + formObj.expiry_yn.value + "&uom_code=" + formObj.uom_code.value + "&stock_item_yn=" + formObj.stock_item_yn.value + "&remarks=" + encodeURIComponent(formObj.remarks.value) + "&uom_desc=" + encodeURIComponent(document.getElementById("id_uom").innerText) + "&stock_available=" + document.getElementById("id_pending_qty").innerText + "&batch_records=" + formObjDtl.total_checkboxes.value + "&sales_doc_type_code=" + formObj.sales_doc_type_code.value + "&sal_doc_srl_no=" + formObj.sal_doc_srl_no.value +"&sales_doc_no=" + formObj.sales_doc_no.value +"&decimal_allowedYN="+formObj.decimal_allowedYN.value+"&no_of_decimals="+formObj.no_of_decimals.value+"&records_to_delete="+formObjHdr.records_to_delete.value+ "&return_allowed_yn="+return_allowed_yn+"&remarks_code="+formObj.remarks_code_1.value+"&billable_item_yn=Y&validate=ADD_TO_LIST", false);
		} else {
			xmlHttp.open("POST", "../../eST/jsp/SalesReturnValidate.jsp?index=" + formObj.index.value + "&doc_srl_no_forbean="+formObjDtl.doc_srl_no_forbean.value+"&site="+formObj.site.value+ "&doc_srl_no=" + formObj.doc_srl_no.value + "&store_code=" + store_code + "&item_code=" + formObj.item_code.value + "&item_desc=" + encodeURIComponent(formObj.item_desc.value) + "&item_qty=" + formObj.item_qty.value + "&item_unit_cost=" + document.getElementById("store_item_unit_cost").value + "&item_cost_value=" + formObj.id_item_sal_value.value + "&expiry_yn=" + formObj.expiry_yn.value + "&uom_code=" + formObj.uom_code.value + "&stock_item_yn=" + formObj.stock_item_yn.value + "&remarks=" + escape(formObj.remarks.value) + "&uom_desc=" + encodeURIComponent(document.getElementById("id_uom").innerText) + "&stock_available=" + document.getElementById("id_pending_qty").innerText + "&batch_records=" + formObjDtl.total_checkboxes.value + "&sales_doc_type_code=" + formObj.sales_doc_type_code.value + "&sal_doc_srl_no=" + formObj.sal_doc_srl_no.value+"&sales_doc_no=" + formObj.sales_doc_no.value+"&decimal_allowedYN="+formObj.decimal_allowedYN.value+"&no_of_decimals="+formObj.no_of_decimals.value+"&records_to_delete="+formObjHdr.records_to_delete.value+"&return_allowed_yn="+return_allowed_yn+"&remarks_code="+formObj.remarks_code_1.value+"&billable_item_yn=N&validate=ADD_TO_LIST", false);
		}
		xmlHttp.send(xmlDoc);
		responseText = xmlHttp.responseText;
		eval(responseText);
		if (result) {
			refreshDetails(formObj.index.value);
			parent.parent.frameSalesReturnHeader.formSalesReturnHeader.preview.disabled = false;
		} else {
			formObj.apply.disabled = false;
			parent.parent.parent.messageFrame.location.href = errorPage + "?err_num=" + getMessage(message, "ST");
			parent.frameSalesReturnListDetail.location.href = "../../eCommon/html/blank.html";
		}
	}
}
function setBarcodeField(){
	var site = parent.frames[0].document.forms[0].site.value;
	var total_checkboxes = parent.parent.frames[1].document.forms[0].total_checkboxes.value;
	//var total_checkboxes = parent.parent.f_query_add_mod.frameSalesReturnDetail.document.getElementById("total_checkboxes").value;
	if(site && parent.frames[0].document.forms[0].barcode != undefined && parent.frames[0].document.forms[0].index.value == '-1' && total_checkboxes >0){
		parent.frames[0].document.forms[0].barcode.disabled = false;
		parent.frames[0].document.forms[0].barcode.value = "";
		parent.frames[0].document.forms[0].barcode.focus();
		parent.frames[0].document.forms[0].barcode.select();
	}
}
//Added against GHL-CRF-0413.5 ends


//Added By sharanraj for GHL-CRF-0483 starts

function chkALl(object, batchcount, index,doctypecode) //modified for IN074078
{
	
	var doc_no = object.value;
	var formObj = document.formSalesReturnSearchWindowResult;
	var prevCount = formObj.sel_doc_batch_count.value;	
	var prevdoc_no = formObj.selected_doc_no.value;	
	var prevdoc_type = formObj.prevdoc_type.value;	//modified for IN074078
	var prev_ind = formObj.prev_ind.value;	
	formObj.selected_doc_no.value = doc_no;
	formObj.prevdoc_type.value = doctypecode; //modified for IN074078
	formObj.sel_doc_batch_count.value = batchcount;	
	formObj.prev_ind.value = index;	
	var ind =  index ;    
   
  
	for (var index=0; index < batchcount; index++ ){
		var checkobj = eval("formObj.doc_no_"+doc_no+"_"+doctypecode+"_"+index); //modified for IN074078
		var itemQtyobj = eval("formObj.item_qty_"+doc_no+"_"+doctypecode+"_"+index); //modified for IN074078
		var applyobj = eval("formObj.apply_"+doc_no+"_"+doctypecode+"_"+ind);		 //modified for IN074078
		if(object.checked == true ){
			if (checkobj!= undefined && itemQtyobj!= undefined){
			checkobj.checked = true;
			itemQtyobj.value=eval("formObj.sal_item_qty_"+doc_no+"_"+doctypecode+"_"+index).value; //modified for IN074078
			checkobj.disabled=false;
			itemQtyobj.disabled=false;
			applyobj.disabled = false;
			}
			
		}
		
		if(object.checked == false)
		{
			
			itemQtyobj.value="";
			itemQtyobj.disabled=true;
			if (checkobj!= undefined && itemQtyobj!= undefined)
			{
				checkobj.checked = false;
			}	
			
		}	
		
		//alert(checkobj.checked);
		
	}
	if(prevdoc_no != undefined && prevdoc_no!= null && prevdoc_no!=""  && (!(doc_no==prevdoc_no && doctypecode==prevdoc_type))){ //modified for IN074078
		for (var batindx=0;batindx< parseInt(prevCount) ;batindx++ )
		{
			var checkobj = eval("formObj.doc_no_"+prevdoc_no+"_"+prevdoc_type+"_"+batindx); //modified for IN074078
			var itemQtyobj = eval("formObj.item_qty_"+prevdoc_no+"_"+prevdoc_type+"_"+batindx); //modified for IN074078
			var applyobj = eval("formObj.apply_"+prevdoc_no+"_"+prevdoc_type+"_"+prev_ind); //modified for IN074078
			if (checkobj!= undefined && itemQtyobj!= undefined){
			checkobj.checked = false;
			itemQtyobj.value="";
			checkobj.disabled=true;
			itemQtyobj.disabled=true;
			}
			applyobj.disabled = true;
			
		}
	}
}

//Added By sharanraj for GHL-CRF-0483 ends

//Added by sharanraj against GHL-CRF-0483 STARTS
function chkSel(obj,batchcount,index,doctypecode) //modified for IN074078
{
	//alert(doc_no_radio);
	 var formObj = document.formSalesReturnSearchWindowResult;
	 var all_count=0;
	 
	 if(obj.checked)
	 {
	    for (var i=0;i<batchcount ;i++ )
	    {
	    	if(document.getElementById("doc_no_"+obj.value+"_"+doctypecode+"_"+i).checked == true) //modified for IN074078
	    	{
	    		all_count++;
	    	}
	    }
	 }
	 else
	 {
		document.getElementById("chkAll_"+obj.value+"_"+doctypecode).checked=false; //modified for IN074078
	 }
	 
	 if(all_count == batchcount )
	 {
		 document.getElementById("chkAll_"+obj.value+"_"+doctypecode).checked=true; //modified for IN074078
	 }
	
	//alert(checkobj.value+"doc_no"+doc_no);
	 var chk=eval("formObj.chkAll_"+obj.value+"_"+doctypecode); //modified for IN074078
	
	 for(var index=0; index < batchcount; index++)
	 {	
	   if(formObj.checked=="false" || formObj.checked==false)//added for KDAH-SCF-0545
	//	 if(checkobj.checked=="false" || checkobj.checked==false)//REMOVED for KDAH-SCF-0545
		 {
			 chk.checked=false;
		 }	
	}
	
}

// Added by sharanraj against GHL-CRF-0483 ENDS
//Added for TFS id: 11896
function setConvFactor(conv_factor){
	parent.frames[0].document.forms[0].conv_factor.value=conv_factor;
}
function autoQtyUpdate(){ 
	var Obj	=  parent.parent.frames[0].document.forms[0].defaultqty_value1.value;
	var site = parent.frames[0].document.forms[0].site.value;
	var bar_appl = parent.parent.frames[0].document.forms[0].barcode_applicable1.value;
	var trn_type=parent.parent.frames[0].document.forms[0].trn_type.value;
	var barcode = parent.frames[0].document.forms[0].barcode;
	var editqty = parent.parent.frames[0].document.forms[0].editqty_appl1.value;
	var bar_or_item_code = parent.frames[0].document.forms[0].bar_or_item_code.value;
	if(bar_appl=='Y' && parent.frames[0].document.forms[0].item_code.value!=null && Obj==1 && editqty != 'Y' &&  bar_or_item_code == 'B' && site){
		if (parent.frames[1].document.forms[0] != undefined && parent.frames[1].document.forms[0] != null) {
			var formObjDtl = parent.frames[1].document.forms[0];
			if(parent.frames[0].document.forms[0].tot_item_qty !=undefined)
				var item_qty = parent.frames[0].document.forms[0].tot_item_qty.value;
			if(parent.frames[0].document.forms[0].ret_qty !=undefined)
				var item_qty = parent.frames[0].document.forms[0].ret_qty.value;
			if(parent.frames[0].document.forms[0].item_qty !=undefined)// added for GHL-CRF-0465 Start
				var item_qty = parent.frames[0].document.forms[0].item_qty.value;
				if(parent.frames[0].document.forms[0].iss_uom_qty !=undefined)
					var item_qty = parent.frames[0].document.forms[0].iss_uom_qty.value;	
			var _total_checkboxes = formObjDtl.total_checkboxes.value;// GHL-CRF-0465 END
			var no_of_decimals=formObjDtl.no_of_decimals.value;
			
			var sum = 0;
			var i =0;
			for ( i = 0; i < _total_checkboxes; i++) {
				var qty = eval("formObjDtl.item_qty_" + i).value;
				if (qty == "") {
					qty = 0;
				}
				if (!isNaN(qty)) {
					sum += parseFloat(qty);
				}
			}
		if(formObjDtl.dec_allowed_yn.value=='Y')
			sum=sum.toFixed(no_of_decimals);
			if (sum != item_qty) {
				if(parent.frames[0].document.forms[0].tot_item_qty !=undefined)
					parent.frames[0].document.forms[0].tot_item_qty.value =sum;
				if(parent.frames[0].document.forms[0].ret_qty !=undefined)
					parent.frames[0].document.forms[0].ret_qty.value =sum;
				if(parent.frames[0].document.forms[0].iss_uom_qty !=undefined)//added GHL-CRF-0465
					parent.frames[0].document.forms[0].iss_uom_qty.value=sum;//added GHL-CRF-0465
				parent.frames[0].document.forms[0].item_qty.value = item_qty-1;
				barcode.focus();	
			}
		}
	}
}
//Added for TFS id: 11896

