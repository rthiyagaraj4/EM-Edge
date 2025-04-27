/*
--------------------------------------------------------------------------------------------------------------
Date     	  Edit History      	Name     			Description
--------------------------------------------------------------------------------------------------------------
23-OCT-2018      100           	Subha Sundari M          Created
---------------------------------------------------------------------------------------------------------------
*/

function reset() {
	var formObj = BLAutoBillGenFrame.BLAutoBillGenDtls.document.forms[0];
	if(formObj != undefined && formObj != 'undefined') {
		if(formObj.sessionId != undefined && formObj.sessionId != 'undefined') {
			var sessionId = formObj.sessionId.value;
			BLAutoBillGenFrame.dummyFrame.location.href="../../servlet/eBL.BLAutoBillGenServlet?mode=delete&sessionId="+sessionId;
		}
	}
	BLAutoBillGenFrame.location.reload();
}

function onLoadStatus() {
	document.forms[0].episode_type.value='A';
	document.forms[0].status.value='CMP';
	var function_id = document.forms[0].function_id.value;
	if(function_id == "BL_OPEM_AUTO_BILL_GEN") {
		var formObj = parent.parent.frames[0].document.forms[0];
		if(formObj != undefined && formObj != 'undefined' && formObj != null && formObj != 'null') {
			formObj.apply.disabled = true;
		}
	}
}

function fnClearCode(obj,code) {
	obj.value = '';
	code.value = '';
}

async function customerLookup(sqlSelect, obj, code, called) {
    var locale = document.forms[0].locale.value;
    var facility_id = document.forms[0].facility_id.value;
    var argumentArray = new Array();
    var dataNameArray = new Array();
    var dataValueArray = new Array();
    var dataTypeArray = new Array();
    var sql = '';
    var title = '';
    switch (sqlSelect) {
        case 1:
        {
        	var cust_code = document.forms[0].custgroupCode.value;
            sql = "Select description,code from (Select long_name description,cust_code code from ar_customer_lang_vw " +
                	"Where Cust_Code In ( SELECT cust_code " +
                	"FROM bl_cust_by_cust_group " +
                	"WHERE cust_group_code = " +
                	"DECODE ('" +
                	cust_code +
                	"', " +
                	"'**', cust_group_code, '" +
                	cust_code +
                	"')) " +
                	"and acc_entity_code  In (Select Acc_Entity_Code From Sy_Acc_Entity Where Acc_Entity_Id = '" +
                	facility_id +
                	"') " +
                	"and nvl(patient_flag,'N')  ='Y' " +
                	"and nvl(pat_com_flag,'N')='N' " +
                	"And Nvl(Insurance_Yn, 'N') = 'Y' And Status Is Null " +
                	"and upper(language_id) = upper('" +
                	locale +
                	"') union  Select 'All Payer','**' From Dual) where upper(description) like upper(?) and upper(code) like upper(?) ";
            title = 'Customers';
            break;
        }
        case 2:
        {
        	sql = "select description,code from (select long_desc description, cust_group_code code from ar_cust_group_lang_vw where status is null and " +
                	"cust_group_code in (Select Distinct Cust_Group_Code From Bl_Cust_By_Cust_Group Where Cust_Code In (Select Cust_Code From Ar_Customer_Lang_Vw " +
                	"where acc_entity_code  in (Select Acc_Entity_Code From Sy_Acc_Entity Where Acc_Entity_Id = '" +
                	facility_id +
                	"') and upper(language_id) = upper('" +
                	locale +
                	"') " +
                	"and nvl(patient_flag,'N')  ='Y' And Nvl(Insurance_Yn, 'N') = 'Y' )) " +
                	"And Acc_Entity_Code In (Select Acc_Entity_Code From Sy_Acc_Entity Where Acc_Entity_Id = '" +
                	facility_id +
                	"') and upper(language_id) = upper('" +
                	locale +
                	"')) where upper(description) like upper(?) and upper(code) like upper(?) " +
                	" order by 2";
            title = 'Customer Group';
            break;
        }
    }
    argumentArray[0] = sql;
    argumentArray[1] = dataNameArray;
    argumentArray[2] = dataValueArray;
    argumentArray[3] = dataTypeArray;
    argumentArray[4] = "2,1";
    if(called == '0') {
    	argumentArray[5] = obj.value;
        argumentArray[6] = DESC_LINK;
        argumentArray[7] = DESC_CODE;
    }
    if(called == '1') {
    	argumentArray[5] = code.value;
        argumentArray[6] = CODE_LINK;
        argumentArray[7] = CODE_DESC;
    }
    returnedValues = await CommonLookup(title, argumentArray);
	var ret1=unescape(returnedValues);
 	var arr=ret1.split(",");
 	if(arr[1]==undefined) 
		{
 		arr[0]="";	
 		arr[1]="";	
		}
    if ((returnedValues != null) && (returnedValues != "")) {
        obj.value = arr[1];
        code.value = arr[0];
    } else {
        obj.value = '';
        code.value = '';
    }
}

function search() {
	//alert("2");
	var cust_group = document.forms[0].cust_group.value;
	var cust_group_code = document.forms[0].custgroupCode.value;
	var cust_name_code = document.forms[0].custnameCode.value;
	var cust_name = document.forms[0].cust_name.value;
	var visit_from_date = document.forms[0].visit_from_date.value;
	var visit_to_date = document.forms[0].visit_to_date.value;
	var episode_type=document.forms[0].episode_type.value;
	var patient_id = document.forms[0].patient_id.value;
	var status=document.forms[0].status.value;
	var locale = document.forms[0].locale.value;
	var facility_id = document.forms[0].facility_id.value;
	var function_id = document.forms[0].function_id.value;
	var loginUser = document.forms[0].loginUser.value;
	var clientIp = document.forms[0].clientIp.value;
	if(cust_group == "") {
		var msg = getMessage("BL0771","BL");
		alert(msg);
		return false;
	}
	if(cust_name == "") {
		var msg = getMessage("BL0772","BL");
		alert(msg);
		return false;
	}
	if(visit_from_date == "") {
		var msg = getMessage("BL0773","BL");
		msg = msg.replace("$", "Visit From Date");
		alert(msg);
		return false;
	}
	if(visit_to_date == "") {
		var msg = getMessage("BL0774","BL");
		msg = msg.replace("$", "Visit To Date");
		alert(msg);
		return false;
	}
	/*if ((Date.parse(visit_to_date) < Date.parse(visit_from_date))) {
		var msg = getMessage("BL0775","BL");
		alert(msg);
		document.getElementById("visit_from_date").value = "";
		return false;
	}*/
	var starr = document.getElementById('visit_from_date').value.split("/");
	var enarr = document.getElementById('visit_to_date').value.split("/");
	var startdt = new Date();
	var enddt = new Date();
	startdt.setFullYear(starr[2], starr[1]-1, starr[0]);
	enddt.setFullYear(enarr[2], enarr[1]-1, enarr[0]);
	if(startdt>enddt)
	{
		var msg = getMessage("BL0776","BL");
		msg = msg.replace("$", "Visit To Date");
		alert(msg);
		document.forms[0].visit_to_date.focus();
		return false;
	}
	
	visit_from_date = visit_from_date + " 00:00";
	var d = new Date();
	visit_to_date = visit_to_date + " " + d.getHours() + ":" + d.getMinutes();
	document.forms[0].search_button.disabled = true;
	parent.BLAutoBillGenDtls.location.href="../../servlet/eBL.BLAutoBillGenServlet?cust_group="+cust_group+
											"&cust_group_code="+cust_group_code+"&cust_name="+cust_name+
											"&cust_name_code="+cust_name_code+"&visit_from_date="+visit_from_date+
											"&visit_to_date="+visit_to_date+"&episode_type="+episode_type+
											"&patient_id="+patient_id+"&status="+status+"&locale="+locale+
											"&facility_id="+facility_id+"&functionId="+function_id+"&loginUser="+
											loginUser+"&clientIp="+clientIp+"&mode=search";
}

function clearFrame() {
	var formObj = parent.BLAutoBillGenDtls.document.forms[0];
	if(formObj != undefined && formObj != 'undefined') {
		if(formObj.sessionId != undefined && formObj.sessionId != 'undefined') {
			var sessionId = formObj.sessionId.value;
			parent.dummyFrame.location.href="../../servlet/eBL.BLAutoBillGenServlet?mode=delete&sessionId="+sessionId;
		}
	}
	document.forms[0].reset() ;
	$('#status').val('CMP');
	document.forms[0].search_button.disabled = false;
	parent.frames[1].location.href='../../eCommon/html/blank.html';
}

function no_record_check() {	
	var total_records=document.forms[0].total_records.value;			
	if(total_records == 0) {
		setTimeout(function(){ alert(getMessage("NO_RECORD_FOUND_FOR_CRITERIA","Common")); }, 100);
		$("#view_enctr_bill_det").html("");
		parent.BLAutoBillGenSearch.document.forms[0].search_button.disabled = false;
	}			
}

function checkAll() {
	var totalRecCount = document.getElementById("total_records").value;
	if(document.getElementById('chkall').checked == true) {
		for(var i = 1 ; i <= totalRecCount ; i++) {
			document.getElementById("chkbx"+i).checked = true;
			checkUncheckVal(i);
			parent.parent.frames[0].document.forms[0].apply.disabled = false;
		}
	} else {
		for(var i = 1 ; i <= totalRecCount ; i++) {
			document.getElementById("chkbx"+i).checked = false;
			checkUncheckVal(i);
			parent.parent.frames[0].document.forms[0].apply.disabled = true;
		}
	}
}

function chkindividualitem() {
	var totalRecCount = document.getElementById("total_records").value;
	var flag = 0;
	for(var i = 1 ; i <= totalRecCount ; i++) {
		if(document.getElementById("chkbx"+i).checked == true) {
			flag = 1;
		} else {
			flag = 0;
			break;
		}
	}
	if(flag == 0) {
		document.getElementById('chkall').checked = false;
	} else {
		document.getElementById('chkall').checked = true;
	}
	var flag1 = 0;
	for(var i = 1 ; i <= totalRecCount ; i++) {
		if(document.getElementById("chkbx"+i).checked == true) {
			flag1 = 1;
			break;
		} else {
			flag1 = 0;
		}
	}
	if(flag1 == 1) {
		parent.parent.frames[0].document.forms[0].apply.disabled = false;
	} else {
		parent.parent.frames[0].document.forms[0].apply.disabled = true;
	}
	
}

function apply() {
	var frmObj = BLAutoBillGenFrame.BLAutoBillGenDtls.view_enctr_bill_det;
	var frmObjSearchForm = BLAutoBillGenFrame.BLAutoBillGenSearch.billGenSearchForm;
	var sessionId = frmObj.sessionId.value;
	var facilityId = frmObj.facilityId.value;
	var loginUser = frmObj.loginUser.value;
	var jobId = frmObj.jobId.value;
	var clientIp = frmObj.clientIp.value;
	var params = BLAutoBillGenFrame.BLAutoBillGenSearch.document.getElementById('params').value;
	var custGrpCode = frmObjSearchForm.custgroupCode.value;
	var custCode = frmObjSearchForm.custnameCode.value;
	var episodeType = frmObjSearchForm.episode_type.value;
	var functionId = frmObjSearchForm.function_id.value;
	
	alert("Auto Bill Generation Job Submitted with Job id "+jobId);
    BLAutoBillGenFrame.BLAutoBillGenDtls.document.forms[0].target='messageFrame';
	BLAutoBillGenFrame.BLAutoBillGenDtls.document.forms[0].method="post";
	BLAutoBillGenFrame.BLAutoBillGenDtls.document.forms[0].action = "../../servlet/eBL.BLAutoBillGenServlet?facilityId="
		+facilityId+"&loginUser="+loginUser+"&sessionId="+sessionId+"&jobId="+jobId+"&mode=apply"+"&clientIp="+clientIp+"&custGrpCode="+custGrpCode+"&custCode="+custCode
		+"&episodeType="+episodeType+"&functionId="+functionId;
	BLAutoBillGenFrame.BLAutoBillGenDtls.document.forms[0].submit();
	commontoolbarFrame.location.href ="../../eCommon/jsp/commonToolbar.jsp?"+params;
	BLAutoBillGenFrame.BLAutoBillGenSearch.location.reload();
	BLAutoBillGenFrame.BLAutoBillGenDtls.location.href = '../../eCommon/html/blank.html';
	
}

function checkUncheckVal(i) {
	var facilityId = document.getElementById("facilityId").value;
	var patientId = document.getElementById("patientId"+i).value;
	var episodeType = document.getElementById("episodeType"+i).value;
	var episodeId = document.getElementById("episodeNo"+i).value;
	var visitId = document.getElementById("visit"+i).value;
	var jobId = "XXXXX";
	var sessionId = document.forms[0].sessionId.value;
	var chkValue = document.getElementById("chkbx"+i);
	var billSelectedYN = "";
	if(chkValue.checked == true) {
		billSelectedYN = "Y";
	}else {
		billSelectedYN = "N";
	}
	$.ajax({
		type: "Post",
		url	:	"../../servlet/eBL.BLAutoBillGenServlet?facility_id="+facilityId+"&patientId="+patientId+"&episode_type="+episodeType+
		"&episodeId="+episodeId+"&visitId="+visitId+"&jobId="+jobId+"&sessionId="+sessionId+"&billSelectedYN="+billSelectedYN+"&mode=selectUnselect",
		data	: "",
		dataType:"text",
		async:false,
		success: function(data){
		},
		error: function(data){
		}
	});
}
