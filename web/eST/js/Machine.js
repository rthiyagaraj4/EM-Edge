
function create() {
	f_query_add_mod.location.href = "../../eST/jsp/MachineAddModify.jsp?mode=" + MODE_INSERT + "&function_id=" + function_id;
}
function query() {
	f_query_add_mod.location.href = "../../eST/jsp/MachineQueryCriteria.jsp?function_id=" + function_id;
}
function apply() {
		var formObj = f_query_add_mod.document.formMachine;
		if(formObj==undefined){
	messageFrame.location.href =  "../../eCommon/jsp/error.jsp?err_num=";
	return;
		}
	f_query_add_mod.document.formMachine.technical_specification.value = f_query_add_mod.document.formMachine.technical_specification_textarea.value;

	var fields = new Array(formObj.machine_code, formObj.machine_name, formObj.model_no);
	var names = new Array(getLabel("eST.MachineCode.label", "ST"), getLabel("Common.MachineName.label", "Common"), getLabel("eST.ModelNo.label", "ST"));
	var errorPage = "../../eCommon/jsp/error.jsp";
	var blankObj = null;
	blankObject = checkSTFields(fields, names, messageFrame, errorPage);
	if (blankObject == true) {
		//alert("formObj =="+ formObj);
		
		eval(formApply(formObj, ST_CONTROLLER));
		messageFrame.location.href = errorPage + "?err_num=" + message;
		if (result) {
			onSuccess();
		}
	}
}
function reset() {
	if (f_query_add_mod.document.formMachine != null) {
		f_query_add_mod.document.formMachine.reset();
	}
	if (f_query_add_mod.document.query_form != null) {
		f_query_add_mod.document.query_form.reset();
	}
}
function onSuccess() {
	var mode = f_query_add_mod.document.formMachine.mode.value;
	if (mode == MODE_INSERT) {
		reset();
	} else {
		f_query_add_mod.document.location.reload();
	}
}
function Modify(obj) {
	var machine_code = obj.cells[0].innerText;
	document.location.href = "../../eST/jsp/MachineAddModify.jsp?mode=" + MODE_MODIFY + "&function_id=" + parent.function_id + "&machine_code=" + machine_code;
}
async function callTextBox() {
	var technical_specification = parent.f_query_add_mod.document.formMachine.technical_specification_textarea.value;
var 	disabled123 = parent.f_query_add_mod.document.formMachine.disabled123.value;
	if (technical_specification == null) {
		technical_specification = "";
	}
	var retVal =await window.showModalDialog("../../eST/jsp/TechSpecPopup.jsp?disabled123=" + disabled123, technical_specification, "dialogHeight:50vh; dialogWidth: 60vw; center: 1; status: no; dialogTop :20;");
	//alert("retVal===="+retVal);
	if (!(retVal == null)) {
		parent.f_query_add_mod.document.formMachine.technical_specification.value = retVal;
		parent.f_query_add_mod.document.formMachine.technical_specification_textarea.value = retVal;
	}
}

