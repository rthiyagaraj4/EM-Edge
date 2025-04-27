function reset(){	
	frames[0].location.reload();
	frames[1].location.reload();
	frames[2].location.href = "../../eCommon/jsp/error.jsp";
}

function clearCode(obj){
	obj.value='';
}
function checkAlpha(event) {
    var strCheck = '1234567890';
    var whichCode = (window.Event) ? event.which : event.keyCode;
    key = String.fromCharCode(whichCode);
    if (strCheck.indexOf(key) == -1)
        return false;
    return true;
}

function checkForNumber(obj) {
    if (trimCheck(obj.value) && isNaN(obj.value) == false && obj.value >= 0) {
		if(obj.value == 0){
			alert(getMessage("CANNOT_BE_ZERO", "common"));
			obj.value = "";
			obj.focus();
			return false;
		}
        return true;
    } else {
        if (obj.value.length > 0) {
            alert(getMessage("NUM_ALLOWED", "SM"));
            obj.value = '';
            return false;
        }
    }
}

function compareDates(startDate, endDate) {
    var starr = startDate.value.split("/");
    var enarr = endDate.value.split("/");
	
	var startdt = new Date();
    var enddt = new Date();
	startdt.setFullYear(starr[2], starr[1] - 1, starr[0]);
    enddt.setFullYear(enarr[2], enarr[1] - 1, enarr[0]);
	
	if(startDate.value == ""){
		alert(getMessage('BL8504', 'BL'));
        endDate.value = '';
		return false;
	}
	
	if (startDate.value.length > 0 && endDate.value.length > 0) {
        if(startdt > enddt) {
            alert(getMessage('BL4115', 'BL'));
            endDate.value = '';
			return false;
        }
    }
	return true;
}

function compareCurrent_endDates(endDate){
	var starr = endDate.value.split("/");
	var currdt = new Date();
    var startdt = new Date();
	startdt.setFullYear(starr[2], starr[1] - 1, starr[0]);
	if(currdt < startdt){
		alert(getMessage('BL0966', 'BLEXT')); 
		endDate.value = '';
		return false;
	}
}

function encFromDateValidation(obj, startDt, endDt){
	var locale = document.forms[0].locale.value; 
	if(obj.value != "") {
		var valid_status = validDateObj(obj,"DMY",locale);
		
		if(!isBeforeNow(obj.value,'DMY',locale)){
			alert(getMessage("FROM_DT_NGE_CURR_DATE","SM"));
			obj.value='';
			valid_status =  false;
		}else{
			valid_status = true;
		}
		
		if(valid_status == true || valid_status == "true"){
			valid_status = compareDates(startDt, endDt);
		}
	}
}

function encToDateValidation(obj, startDt, endDt ){
	var locale = document.forms[0].locale.value;
	if(obj.value != "") {	
		var valid_status = validDateObj(obj,"DMY",locale);
		if(valid_status == true){
			valid_status = compareDates(startDt, endDt)
		}	
		
		if(valid_status == true || valid_status == "true"){
			var dateDif = dateDiff(startDt.value, endDt.value);
			//alert(dateDif);
			var actualDays = 30;
			if(dateDif > actualDays){
				alert(getMessage("BL0939",'BLEXT'));
				endDt.value = '';
				return false;
			}
		}
	}
}

function showCalendarLocal(fromTo, obj) {
    if (fromTo == 1) {
        return showCalendar('effFrom_' + obj)
    } else if (fromTo == 2) {
        return showCalendar('effTo_' + obj)
    }
}
function dateDiff(fromDate, toDate){
	var starr = fromDate.split("/");
	var enarr = toDate.split("/");
	var startdt = new Date();
	var enddt = new Date();
	startdt.setFullYear(starr[2], starr[1]-1, starr[0]);
	enddt.setFullYear(enarr[2], enarr[1]-1, enarr[0]);
	var timeDiff;
	var daysDiff;

	timeDiff = enddt.getTime() - startdt.getTime();
	daysDiff =  Math.floor(timeDiff / (1000 * 60 * 60 * 24));
			
	return daysDiff;
}

function pymtRefIDLkup()
{
	var facility_id = document.getElementById('facility_id').value;
	var target = document.getElementById('pymtRefID');
	var locale = document.getElementById('locale').value;
	
	var qryParam = '&locale='+locale+'&facility_id='+facility_id+'&target='+target.value;	
	
	var retVal				= new String();
	var dialogTop			= "40" ;
	var dialogHeight		= "15" ;
	var dialogWidth			= "50" ;
	var features			= "dialogTop:"+dialogTop+" dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +";status=no" ;
	var arguments			= "" ;
	
	var title = getLabel("eBL.PYMT_REF_ID.label", 'BL');

	title =  "Payment Reference ID";
	title = escape(title);
	var column_sizes = escape("100%");
		
	var appr_doc_ref_no = getLabel("eBL.PYMT_REF_ID.label", 'eBL');
	var column_descriptions = "Payment Reference ID";
	
	var sql="";
	sql="BLINTERNALREP_13::blsql::"+facility_id+"::";
	var param = "title="+title+"&"+"column_sizes="+column_sizes+"&"+"column_descriptions="+column_descriptions+"&col_show_hide=Y"+qryParam+"&sqlData="+sql;
	
	var  retVal=window.showModalDialog("../../eBL/jsp/BLLookupMain.jsp?called_for=INS_PYMT_REF_LKUP&"+param,arguments,features);
	
	if (retVal != null && retVal!="" && retVal!="undefined" )
	{
		retVal=unescape(retVal);
		var arr=retVal.split("^~^");
		target.value = arr[0];
		document.getElementById('payerGrpMand').style.visibility = "hidden";
		document.getElementById('pymtRefFromDateMand').style.visibility = "hidden";
		document.getElementById('pymtRefToDateMand').style.visibility = "hidden";		
	}
    else
	{
		target.value = '';
		document.getElementById('payerGrpMand').style.visibility = "visible";
		document.getElementById('pymtRefFromDateMand').style.visibility = "visible";
		document.getElementById('pymtRefToDateMand').style.visibility = "visible";			 
	}
}

function mandCheck(){
	var target = document.getElementById('pymtRefID');
	
	if(target.value != ""){
		document.getElementById('payerGrpMand').style.visibility = "hidden";
		document.getElementById('pymtRefFromDateMand').style.visibility = "hidden";
		document.getElementById('pymtRefToDateMand').style.visibility = "hidden";
	}else{
		document.getElementById('payerGrpMand').style.visibility = "visible";
		document.getElementById('pymtRefFromDateMand').style.visibility = "visible";
		document.getElementById('pymtRefToDateMand').style.visibility = "visible";
		if(document.getElementById('pymtRefFromDate').value == "")
			document.getElementById('pymtRefFromDate').value = document.getElementById('daysBeforeDate').value;
		if(document.getElementById('pymtRefToDate').value == "")
			document.getElementById('pymtRefToDate').value = document.getElementById('todaysDate').value;		
	}
}

function validateFormAndQuery(){
	var payerGroupCode = document.getElementById('payer_grp_code').value;
	var pymtRefFromDate = document.getElementById('pymtRefFromDate').value;
	var pymtRefToDate = document.getElementById('pymtRefToDate').value;
	var pymtRefID = document.getElementById('pymtRefID').value;
	var pymtRefStatus = document.getElementById('pymtRefStatus').value;
	
	var flag = true;
	
	if(pymtRefID == ""){
		if(payerGroupCode == ""){
			alert(getMessage("BL6277","BL"));
			return false;
		}

		if(pymtRefFromDate == ""){
			alert(getMessage("BL00949","BL"));		
			return false;
		}

		if(pymtRefToDate == ""){
			alert(getMessage("BL00950","BL"));		
			return false;
		}
	}
	
	if(flag == true)
		callResultFrame();
}
function callResultFrame(){	

	parent.parent.messageFrame.location.href='../../eCommon/jsp/error.jsp';
	parent.frames[1].location.href='../../eCommon/html/blank.html';
	parent.frames[2].location.href='../../eCommon/html/blank.html';
	
	var payerGroupCode = document.getElementById('payer_grp_code').value;
	var payerGroupDesc = encodeURIComponent(document.getElementById('payer_group').value);
	var payerCode = document.getElementById('payer_code').value;
	var payerDesc = encodeURIComponent(document.getElementById('payer').value);
	var pymtRefFromDate = document.getElementById('pymtRefFromDate').value;
	var pymtRefToDate = document.getElementById('pymtRefToDate').value;
	var pymtRefID = document.getElementById('pymtRefID').value;
	var pymtRefStatus = document.getElementById('pymtRefStatus').value;
	
	var locale = document.getElementById('locale').value;
	var facility_id = document.getElementById('facility_id').value;

	parent.frames[1].location.href="../../eBL/jsp/BLInsAckPymtSearchResult.jsp?payerGroupCode="+payerGroupCode+"&payerGroupDesc="+payerGroupDesc+"&payerCode="+payerCode+"&payerDesc="+payerDesc+"&pymtRefFromDate="+pymtRefFromDate+"&pymtRefToDate="+pymtRefToDate+"&pymtRefID="+pymtRefID+"&pymtRefStatus="+pymtRefStatus+"&locale="+locale+"&facility_id="+facility_id;
	
	document.getElementById('search_button').disabled=true; 
}

function resetForm(){
	parent.BLInsAckPymtSearchCriteria.location.reload();
	parent.BLInsAckPymtSearchResult.location.href = "../../eCommon/html/blank.html";
	parent.BLInsAckPymtBtn.location.href = "../../eCommon/html/blank.html";
}

function formValidation(xmlStr, event) {
	
	var temp_jsp = "../../eBL/jsp/BLInsAckPymtPersistance.jsp";
    if (event != null && event == "delete")
        temp_jsp = "../../eBL/jsp/BLInsAckPymtPersistance.jsp?event=" + event;

    var xmlDoc="";
    var xmlHttp = new XMLHttpRequest();
    xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");

    xmlHttp.open("POST", temp_jsp, false);
    xmlHttp.send(xmlDoc);

    var responseText = xmlHttp.responseText;
	eval(responseText);
    return true;
}

function formXMLStringMain(frmObj) {
    if (frmObj != null && frmObj != "undefined" && frmObj.length > 0) {
        var xmlStr = "<root><SEARCH ";
	if (true) {
		var arrObj = frmObj.elements;
		
		for (var i = 0; i < arrObj.length; i++) {
			var val = "";
			if (arrObj[i].type == "checkbox") {
				if (arrObj[i].checked) {
					val = arrObj[i].value;
					if (arrObj[i].name != null && arrObj[i].name != "")
						xmlStr += arrObj[i].name + "=\"Y" + "\" ";
				} else {
					if (arrObj[i].name != null && arrObj[i].name != "")
						xmlStr += arrObj[i].name + "=\"" + "N" + "\" ";
				}
			} else if (arrObj[i].type == "radio") {
				if (arrObj[i].checked) {
					val = arrObj[i].value;
					if (arrObj[i].name != null && arrObj[i].name != "")
						xmlStr += arrObj[i].name + "=\"" + checkSpl(val) +
						"\" ";
				}
			} else if (arrObj[i].type == "select-multiple") {
				for (var j = 0; j < arrObj[i].options.length; j++) {
					if (arrObj[i].options[j].selected)
						val += arrObj[i].options[j].value + "~"
				}
				val = val.substring(0, val.lastIndexOf('~'))
				if (arrObj[i].name != null && arrObj[i].name != "")
					xmlStr += arrObj[i].name + "=\"" + checkSpl(val) +
					"\" ";
			} else {
				val = arrObj[i].value;
				if (arrObj[i].name != null && arrObj[i].name != "")
					xmlStr += arrObj[i].name + "=\"" + checkSpl(val) +
					"\" ";
			}
		}
        }
        xmlStr += " /></root>";
    }
	
	return xmlStr;
}

function onSubmit(){
    var frm                = parent.frames[1].document.forms[0];  
	var frmObj             = parent.frames[1].document;
	var checkStatus        = "";
	var totalRecords       = frmObj.getElementById('totalRecords').value;
	var qryPayerGrpCode    = frmObj.getElementById('qryPayerGrpCode').value;
	var qryPayerGrpDesc    = frmObj.getElementById('qryPayerGrpDesc').value;
	var qryPayerCode       = frmObj.getElementById('qryPayerCode').value;
	var qryPayerDesc       = frmObj.getElementById('qryPayerDesc').value;
	var qryPymtRefID       = frmObj.getElementById('qryPymtRefID').value;
	var qryPymtRefFromDate = frmObj.getElementById('qryPymtRefFromDate').value;
	var qryPymtRefToDate   = frmObj.getElementById('qryPymtRefToDate').value;
	var qryPymtRefStatus   = frmObj.getElementById('qryPymtRefStatus').value;

	for(var i = 0; i < totalRecords; i++ ){
		if(frmObj.getElementById("select_record_"+i).checked){			
			checkStatus = "Y";
			frmObj.getElementById("checkedStatus_"+i).value = "Y";
		}
	}

	if(checkStatus != "Y"){
		alert(getMessage("ATLEAST_ONE_SELECTED","common"));
		document.getElementById('send_to_insurance').disabled=false; 
		return;
	}		

	xmlString = formXMLStringMain(frm);
	updation = formValidation(xmlString);

	if(updation == true)
	{
		frm.target = 'messageFrame';
		frm.method = "post";
		frm.action = "../../servlet/eBL.BLInsAckPymtServlet?totalRecords="+totalRecords+"&qryPayerGrpCode="+qryPayerGrpCode+"&qryPayerGrpDesc="+qryPayerGrpDesc+"&qryPayerCode="+qryPayerCode+"&qryPayerDesc="+qryPayerDesc+"&qryPymtRefID="+qryPymtRefID+"&qryPymtRefFromDate="+qryPymtRefFromDate+"&qryPymtRefToDate="+qryPymtRefToDate+"&qryPymtRefStatus="+qryPymtRefStatus;
		frm.submit(); 
		document.getElementById('insAckPymt').disabled=true; 		
	}
}

function selectAll(obj){
	var frmObj = parent.frames[1].document;
	var totalRecords  = frmObj.getElementById('totalRecords').value;
	
	for(var i = 0; i < totalRecords; i++ ){
		if(obj.checked){
			if(frmObj.getElementById("pymtRefStatus_"+i).value == "P"){			
				frmObj.getElementById("select_record_"+i).checked = true;
				frmObj.getElementById("checkedStatus_"+i).value = "Y";
			}
		}else{
			if(frmObj.getElementById("pymtRefStatus_"+i).value == "P"){			
				frmObj.getElementById("select_record_"+i).checked = false;
				frmObj.getElementById("checkedStatus_"+i).value = "N";
			}
		}
	}
}
