var invalidCode = "";
var function_id	=	"" ;
var result		=	false ;
var message		=	"" ;
var flag		=	"" ;
var xmlDom;
var xmlHttp;
var errorPage	= "../../eCommon/jsp/error.jsp" ;	

function create() 
{
	f_query_add_mod.location.href	=	"../../ePO/jsp/MasterTypeFrameset.jsp?function_id="+function_id+"&mode="+MODE_INSERT; 
}

function query() 
{
	f_query_add_mod.location.href	=	"../../ePO/jsp/MasterTypeQueryCriteria.jsp?function_id="+function_id+"&mode="+MODE_MODIFY;
}

function apply()
{
	var arrPKFieldNames     =   new Array();
	arrPKFieldNames[0]      =   "master_code_";

	var formObj = f_query_add_mod.master_type_list; 
	if(formObj==undefined){
	messageFrame.location.href	=	"../../eCommon/jsp/error.jsp?err_num=";
	return false;
	}
	
	var formObjMasterType = f_query_add_mod.master_type_list.document.formMaster_type;
	var fields = new Array ( formObjMasterType.master_type);
	var names = new Array (getLabel("ePO.MasterType.label","PO"));

	var blankObject  = checkPOFields( fields, names, messageFrame,errorPage) ;
	if(blankObject!=true){
		return;
	}
		f_query_add_mod.master_type_detail.document.formMasterType.master_type.value=f_query_add_mod.master_type_list.document.formMaster_type.master_type.value;

		var formObj = f_query_add_mod.master_type_detail.document.formMasterType ;
		var obj=null;
		
		var arrFieldName = new Array();
		var arrLegends = new Array();
		var arrPKFieldNames =	new Array();
		arrFieldName[0] =	"master_code_";
		arrFieldName[1] =	"long_desc_";
		arrFieldName[2] =	"short_desc_";
		arrLegends[0]	= getLabel("ePO.MasterType.label","PO");
		arrLegends[1]	= getLabel("Common.longdescription.label","Common");
		arrLegends[2]	= getLabel("Common.shortdescription.label","Common");   
		arrPKFieldNames[0] = "master_code_";
		//resetDuplicateClass( formObj, arrPKFieldNames);

		if(formObj.mode.value==MODE_INSERT)
		{
			
			var validateResult = validateMMSTMandatoryFields(formObj,arrFieldName,arrLegends,arrPKFieldNames);
			if(validateResult)
			{
				
				eval(formApply(formObj,PO_CONTROLLER));
				messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_value=0&err_num="+ message;
		
				if( result )
				{
					onSuccess();
				}
				if( invalidCode != "null" && invalidCode != "" ){
					var newInvalidCode		=	"";
					var arrInvalidCodes	=	new Array();
					arrInvalidCodes	=	invalidCode.split(";");
					for(i=0; i<arrInvalidCodes.length; i++)
					{
						var arrInvalidCode	=	new Array();
						var strInvalidCode	=	arrInvalidCodes[i];
						arrInvalidCode		=	strInvalidCode.split(":");
						newInvalidCode		=	arrInvalidCode[0]+";";
					}
					invalidCode		=	newInvalidCode.substring(0, newInvalidCode.length-1);
					showDuplicates(formObj, arrPKFieldNames, invalidCode,'0',messageFrame, errorPage);
				}
				else {
					messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num="+ message;
				}
			}
			
		}
		if (formObj.mode.value == MODE_MODIFY)
			{
				
				eval(formApply(formObj,PO_CONTROLLER));
				messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num="+ message;
				

				if( result )
				{
					onSuccess();
				}
				return;
			}

	//}
}

function reset() 
{
	formReset() ;
}

function onSuccess() 
{
	if( f_query_add_mod.master_type_detail )
	{
		var mode	=	f_query_add_mod.master_type_detail.document.formMasterType.mode.value;
		if( mode == MODE_INSERT ) 
		{
			formReset();
			
		}
	}
	else 
	{
		f_query_add_mod.document.location.reload();
	}
}

function formReset () 
{
	
	if(!(f_query_add_mod.master_type_detail==null))
	{
		f_query_add_mod.location.reload();
		
	}

	if(f_query_add_mod.document.query_form!=null)
	{
		f_query_add_mod.document.query_form.reset();
		f_query_add_mod.FocusFirstElement();
	}
	
	if(f_query_add_mod.document.formMasterType!=null)
	{
		f_query_add_mod.document.formMasterType.reset();
		f_query_add_mod.FocusFirstElement();
	}
		
}

function Modify(obj,eff_status,master_type)
{
	var code1				=	obj.cells[0].innerText;
	var code2				=	obj.cells[1].innerText;
	var code3				=	obj.cells[2].innerText;
	document.location.href	=	"../../ePO/jsp/MasterTypeFrameset.jsp?mode="+MODE_MODIFY+"&function_id="+parent.function_id+"&master_type="+master_type+"&eff_status="+eff_status+"&master_code="+code1+"&long_desc="+encodeURIComponent(code2,"UTF-8")+"&short_desc="+encodeURIComponent(code3,"UTF-8");
}

function resetColorCode(obj){
    var arrPKFieldNames = new Array();
    var formObj = parent.parent.f_query_add_mod.master_type_detail.document.formMasterType;
    arrPKFieldNames[0] = "master_code_";
    resetDuplicateClass( formObj, arrPKFieldNames, 0, obj );
}

function changetype() {
	var formObj = parent.master_type_list.document.formMaster_type;
	var totalrecords = parent.master_type_detail.document.formMasterType.totalRecords.value;
	var mode = parent.master_type_detail.document.formMasterType.mode.value;
		
		for (var i = 0; i < totalrecords; i++) {
		if(formObj.master_type != undefined){
		if(formObj.master_type != null){ 
		if(formObj.master_type.value == "COMMNT"){
				eval("parent.master_type_detail.document.formMasterType.additional_dtls_"+i).disabled = false; 
		}	
		else{		
		eval("parent.master_type_detail.document.formMasterType.additional_dtls_"+i).disabled = true;
		}
		}
		}
}
}

function CommitCodeDetails(bean_id, bean_name, mode,master_code,long_desc,short_desc,eff_status,cnt) {

	var formObj = document.formMasterType;
	var count = formObj.totalRecords.value;
	
	if(master_code.value == "" || master_code.value == null) { 
		alert(getMessage("CODE_NOT_BLANK","PO"));  
		master_code.focus();
		return;
		
	}
		if(long_desc.value == "" || long_desc.value == null) { 
		alert(getMessage("LONG_DESC_NOT_BLANK","PO"));  
		long_desc.focus();
		return;
		
	}
		if(short_desc.value == "" || short_desc.value == null) { 
		alert(getMessage("SHORT_DESC_NOT_BLANK","PO"));  
		short_desc.focus();
		return;
		
	}
		if(eff_status.value == "" || eff_status.value == null) { 
		alert(getMessage("EFF_STATUS_NOT_BLANK","PO"));  
		eff_status.focus();
		return;
		
	}
	function_id = document.forms[0].function_id.value;
	
	var tit = "TITLE";
	var retVal = window.showModalDialog("../../ePO/jsp/CommitmentCodeDetails.jsp?bean_id=" + bean_id + "&bean_name=" + bean_name +  "&function_id=" + function_id + "&mode=" + mode + "&master_code=" + master_code.value + "&long_desc=" + long_desc.value + "&short_desc=" + short_desc.value + "&eff_status=" + eff_status.value + "&count=" + count + "&index=" + cnt , "", "dialogHeight:23; dialogWidth: 70; right: 1; status: no; dialogTop :300;scroll:auto");
	
	
	
}

function returnVals(index) {
	var formObj = document.formcomcodedtls;
	var returnvals = "";
	var totalRecords = formObj.totalRecords.value;
	var noOfCheckedRecords = "";
	

	for (var i = 0; i < totalRecords; i++) {

			var dept_no     = eval("document.formcomcodedtls.dept_no_"+i).value;
			var acc_no      = eval("document.formcomcodedtls.acc_no_"+i).value;
			var acc_no_desc = eval("document.formcomcodedtls.acc_no_desc_"+i).value;			
			var from_date   = eval("document.formcomcodedtls.from_date_"+i).value;

			//formObj.all_budget.value = eval("document.formcomcodedtls.all_budget_"+i).value;
			//formObj.addnl_budget.value = eval("document.formcomcodedtls.addnl_budget_"+i).value;
			//formObj.total_budget.value = eval("document.formcomcodedtls.total_budget_"+i).value;
			//formObj.to_date.value = eval("document.formcomcodedtls.to_date_"+i).value;

				if(acc_no != "" || acc_no_desc != "") { 
					if(dept_no=="" || dept_no== null){
					alert(getMessage("DEPT_CODE_NOT_BLANK","PO"));  
					eval("document.formcomcodedtls.dept_no_"+i).focus();
					return;		
					}
					if(from_date=="" || from_date== null){
					alert(getMessage("FROM_DATE_NOT_BLANK","PO"));  
					eval("document.formcomcodedtls.from_date_"+i).focus();
					return;		
					}
				}

					for (var j = 0; j < totalRecords; j++) {
						var dept_no1     = eval("document.formcomcodedtls.dept_no_"+j).value;
						var from_date1   = eval("document.formcomcodedtls.from_date_"+j).value;

						if(dept_no!="" && from_date!="" && dept_no==dept_no1 && from_date==from_date1 && i!=j){
							alert(getMessage("DUPLICATE_NOT_POSSIBLE","PO"));  
							
							return;
						}
					}
				

		}

		var xmlHttp = new XMLHttpRequest();
		var xmlDoc="";
		xmlDoc.loadXML(getEnhancedXMLString(formObj));
		xmlHttp.open("POST", "../../ePO/jsp/CommitmentCodeDetailsValidate.jsp?bean_id=" + formObj.bean_id.value + "&bean_name=" + formObj.bean_name.value + "&index=" + index +  "&function_type=SETVALUES", false);
		xmlHttp.send(xmlDoc);
		responseText = xmlHttp.responseText;
		eval(responseText);
		
		if(result){		
		window.close();
		}
}
function addRowToTable()
{  /*
	var formObj = document.formcomcodedtls;

	var totalRecords = formObj.totalRecords.value;

		var table=document.getElementById("myTable");
		var lastRow = table.rows.length;
		var iteration = lastRow;	
		var row = table.insertRow(lastRow);

		var cell1=row.insertCell(0);

		var el = document.createElement('input');
		el.setAttribute('type', 'text');
		el.setAttribute('name', 'dept_no1' + iteration);
		el.setAttribute('size', '10');
		cell1.appendChild(el).innerHTML;

		var cell2=row.insertCell(1);
		var el1 = document.createElement('input');
		el1.setAttribute('type', 'text');
		el1.setAttribute('name', 'acc_no1' + iteration);
		el1.setAttribute('size', '20');
		cell2.appendChild(el1).innerHTML;

		var cell3=row.insertCell(2);
		var el2 = document.createElement('input');
		el2.setAttribute('type', 'text');
		el2.setAttribute('name', 'acc_no_desc1' + iteration);
		el2.setAttribute('size', '30');
		cell3.appendChild(el2).innerHTML;

		var cell4=row.insertCell(3);
		var el3 = document.createElement('input');
		el3.setAttribute('type', 'text');
		el3.setAttribute('name', 'all_budget1' + iteration);
		el3.setAttribute('size', '10');
		cell4.appendChild(el3).innerHTML;

		var cell5=row.insertCell(4);
		var el4 = document.createElement('input');
		el4.setAttribute('type', 'text');
		el4.setAttribute('name', 'addnl_budget1' + iteration);
		el4.setAttribute('size', '10');
		cell5.appendChild(el4).innerHTML;

		var cell6=row.insertCell(5);
		var el5 = document.createElement('input');
		el5.setAttribute('type', 'text');
		el5.setAttribute('name', 'total_budget1' + iteration);
		el5.setAttribute('size', '15');
		cell6.appendChild(el5).innerHTML;

		var cell7=row.insertCell(6);
		var el6 = document.createElement('input');
		el6.setAttribute('type', 'text');
		el6.setAttribute('name', 'from_date1' + iteration);
		el6.setAttribute('size', '10');
		cell7.appendChild(el6).innerHTML;

		var cell8=row.insertCell(7);
		var el7 = document.createElement('input');
		el7.setAttribute('type', 'text');
		el7.setAttribute('name', 'to_date1' + iteration);
		el7.setAttribute('size', '10');
		cell8.appendChild(el7).innerHTML;
  */
}

function displaytotalbudget_insert(i) {
	var formObj = document.formcomcodedtls;
	var totalrecords = formObj.totalRecords.value;
	//	for (var i = 0; i < totalrecords; i++) {
		var all_budget = eval("document.formcomcodedtls.all_budget_"+i).value;
		var addnl_budget = eval("document.formcomcodedtls.addnl_budget_"+i).value;
			if(addnl_budget.value !="" || addnl_budget.value != null) {
				eval("document.formcomcodedtls.total_budget_"+i).value = ((parseFloat(all_budget) || null) + (parseFloat(addnl_budget) || null));
			}
	//	}
}

function displaytotalbudget_modify(i,total_bdgt,addnl_bdgt1) {
	var formObj = document.formcomcodedtls;
	var comm_rec = formObj.comm_rec.value;
	if(comm_rec == 0){
		displaytotalbudget_insert(i);
	}else{
		var addnl_budget = eval("document.formcomcodedtls.addnl_budget_"+i).value;
		addnl_budget = addnl_budget - addnl_bdgt1 ; 
		if(addnl_budget.value !="" || addnl_budget.value != null) {
			eval("document.formcomcodedtls.total_budget_"+i).value = ((parseFloat(total_bdgt) || null) + (parseFloat(addnl_budget) || null));
		}
	}
}

function checkValidate(obj_toDate){
	var formObject = document.formcomcodedtls;
	
	var toDateArray;
	var fromDateArray;
//	var toDate = obj_toDate.value;
	var totalrecords = formObject.totalRecords.value;
		for (var i = 0; i < totalrecords; i++) {
			var toDate = eval("document.formcomcodedtls.to_date_"+i).value;
			var fromDate = eval("document.formcomcodedtls.from_date_"+i).value;
			if(fromDate != null || fromDate != ""){
				if (toDate.length > 0 && fromDate.length > 0) {
					toDateArray = toDate.split("/");
					fromDateArray = fromDate.split("/");
					var toDateObject = new Date(toDateArray[2], (toDateArray[1] - 1), toDateArray[0]);
					var fromDateObject = new Date(fromDateArray[2], (fromDateArray[1] - 1), fromDateArray[0]);
					if (Date.parse(fromDateObject) > Date.parse(toDateObject)) {
						alert(getMessage("EFF_TO_DATE_GR_FROM_DATE","PO"));  
						eval("document.formcomcodedtls.to_date_"+i).select();
						eval("document.formcomcodedtls.to_date_"+i).focus();
					}
				}
			}
		}
}

function changeText(obj,i){


if(eval("document.formMasterType.eff_status_"+i).checked == true){
eval("document.formMasterType.long_desc_"+i).disabled = false;
eval("document.formMasterType.short_desc_"+i).disabled = false;
}else{
eval("document.formMasterType.long_desc_"+i).disabled = true;
eval("document.formMasterType.short_desc_"+i).disabled = true
}

}
