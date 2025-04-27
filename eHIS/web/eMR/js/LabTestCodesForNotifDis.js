/** ****************************************************** */
function apply() {

	if (!checkIsValidForProceed()) {
		message = getMessage("APPLY_NOT_VALID", 'MR');
		messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="
				+ message;
		return false;
	}
	if (!checkIsValidForProceed1()) {
		message = getMessage("APPLY_NOT_VALID", 'MR');
		messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="
				+ message;
		return false;
	}
	if (!checkIsValidForProceed2()) {
		message = getMessage("APPLY_NOT_VALID", 'MR');
		messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="
				+ message;
		return false;
	}
	if (!checkIsValidForProceed3()) {
		message = getMessage("APPLY_NOT_VALID", 'MR');
		messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="
				+ message;
		return false;
	}
	parent.frames[2].frames[1].frames[1].document.forms[0].action = "../../servlet/eMR.LabTestForNotifyDiseasesServlet";
	parent.frames[2].frames[1].frames[1].document.forms[0].target = "messageFrame";
	parent.frames[2].frames[1].frames[1].document.forms[0].submit();

}
/** ****************************************************** */
function checkIsValidForProceed() {

	var url = f_query_add_mod.location.href;
	url = url.toLowerCase();
	if ((url.indexOf("queryresult.jsp") == -1) && (url.indexOf("query") == -1)
			&& (url.indexOf("blank") == -1))
		return true;
	else
		return false;
}
/** ****************************************************** */

function checkIsValidForProceed1() {
	var url = f_query_add_mod.f_query_header.location.href;
	url = url.toLowerCase();
	if ((url.indexOf("queryresult.jsp") == -1) && (url.indexOf("query") == -1)
			&& (url.indexOf("blank") == -1))
		return true;
	else
		return false;
}
/** ****************************************************** */
function checkIsValidForProceed2() {
	var url = f_query_add_mod.f_query_detail.location.href;
	url = url.toLowerCase();
	if ((url.indexOf("queryresult.jsp") == -1) && (url.indexOf("query") == -1)
			&& (url.indexOf("blank") == -1))
		return true;
	else
		return false;
}
/** ****************************************************** */
function checkIsValidForProceed3() {

	var url = f_query_add_mod.Dummy.location.href;
	url = url.toLowerCase();
	if ((url.indexOf("queryresult.jsp") == -1) && (url.indexOf("query") == -1)
			&& (url.indexOf("blank") == -1))
		return true;
	else
		return false;
}
/** ****************************************************** */

function create() {

	f_query_add_mod.location.href = '../../eMR/jsp/LabTestCodesForNotififDisFrameSet.jsp';
}

function query() {

	frames[1].location.href = '../../eMR/jsp/LabTestForNotifyDiseasesQueryCriteria.jsp';
}

/*
 * function reset() { var url=f_query_add_mod.location.href;
 * if(url.indexOf("blank")==-1) { if(url.indexOf("Query")==-1){
 * parent.frames[2].frames[1].frameSearch.document.forms[0].reset();
 * parent.frames[2].frames[1].frameSearch.document.forms[0].elements(0).focus();
 * parent.frames[2].frames[1].frameResult.location.href='../../eCommon/html/blank.html';
 * parent.frames[2].frames[1].Dummy.location.href='../../eCommon/html/blank.html';
 * }else parent.frames[2].frames[1].document.forms[0].reset(); } }
 */

function reset() {
	var url = f_query_add_mod.location.href;
	if (url.indexOf("blank") == -1) {
		if (url.indexOf("Query") == -1) {
			parent.frames[2].frames[1].f_query_header.document.forms[0].reset();
			parent.frames[2].frames[1].f_query_header.document.forms[0]
					.elements[0].focus();
			parent.frames[2].frames[1].f_query_detail.location.href = '../../eCommon/html/blank.html';
			parent.frames[2].frames[1].Dummy.location.href = '../../eCommon/html/blank.html';
		} else
			parent.frames[2].frames[1].document.forms[0].reset();
	}
}

function onSuccess() {

	parent.frames[2].frames[1].frames[1].location.href = '../../eCommon/html/blank.html';
	parent.frames[2].frames[1].frames[0].location.reload();
	// parent.parent.frames[1].frames[0].location.href=
	// parent.parent.frames[1].frames[0].location.reload();

}

function searchNotifyDis(target) {

	/*
	 * usage of this condition is if notifiable disease filed value "null"
	 * serach window will open unnessary ,so this condition avoid to opent that
	 * search window
	 */
	if (target.value == "") {
		target.value = "";
		document.forms[0].notify_dis_code_1.value = "";
		return;
	}
	getNotifyDis(target)

}

async function getNotifyDis(target) {

	var retVal = new String();
	var argumentArray = new Array();
	var dataNameArray = new Array();
	var dataValueArray = new Array();
	var dataTypeArray = new Array();
	var tit = "";
	tit = getLabel('eMR.NotifyDiseases.label', 'mr_labels');

	sql = "SELECT notify_disease_code code, SHORT_DESC description FROM mr_notifiable_disease WHERE EFF_STATUS='E' and UPPER (notify_disease_code) LIKE UPPER (?) and UPPER (SHORT_DESC) LIKE UPPER (?) ORDER BY 2";

	argumentArray[0] = sql;
	argumentArray[1] = dataNameArray;
	argumentArray[2] = dataValueArray;
	argumentArray[3] = dataTypeArray;
	argumentArray[4] = "1,2";
	argumentArray[5] = target.value;
	argumentArray[6] = DESC_LINK;
	argumentArray[7] = DESC_CODE;

	retVal = await CommonLookup(tit, argumentArray);

	if (retVal != null && retVal != "") {

		var ret1 = unescape(retVal);
		arr = ret1.split(",");
		target.value = arr[1];
		document.forms[0].notify_dis_code_1.value = arr[0];

	}

}

function PopulateValues(obj) {

	var notify_dis_code_1 = document.forms[0].notify_dis_code_1.value

	if (notify_dis_code_1 == '') {
		parent.frames[1].location.href = '../../eCommon/html/blank.html';
	}

}

function searchTestCode() {
	parent.frames[1].location.href = '../../eCommon/html/blank.html';
	parent.frames[2].location.href = '../../eMR/jsp/LabTestCodesForNotifyDisDynamicValues.jsp';
	var notifyDisCode = document.forms[0].notify_dis_code_1.value;

	var serachCriteriaValue = document.forms[0].lab_type.value;
	var searchCriteria = document.forms[0].search_criteria.value;
	var messageFrame = parent.parent.frames[2];

	var fields = new Array(document.forms[0].notify_dis_code_2);
	var names = new Array(getLabel("eMR.NotifyDiseases.label", "MR"));

	if (serachCriteriaValue.indexOf("'") != -1) {
		serachCriteriaValue = serachCriteriaValue.replace("'", "''");
	}
	// parent.f_query_header.checkFieldsofMst
	if (parent.f_query_header.checkFieldsofMst(fields, names, messageFrame)) {
		// parent.frames[2].location.href='../../eMR/jsp/LabTestCodesForNotifyDisDynamicValues.jsp';
		parent.frames[1].location.href = '../../eMR/jsp/LabTestCodeSearchResult.jsp?notifyDisCode='
				+ notifyDisCode
				+ '&fromSearch=true&serachCriteriaValue='
				+ encodeURIComponent(serachCriteriaValue)
				+ '&search_criteria='
				+ searchCriteria;
		parent.parent.frames[2].location.href = '../../eCommon/jsp/MstCodeError.jsp';
	}

}

/*
 * function submitPrevNext(from, to){
 * 
 * alert("document.forms[0].selectall.checked===>"+document.forms[0].selectall.checked);
 * if(document.forms[0].selectall.checked==true)
 * document.getElementById("selectCHk").value='Y'; else
 * document.forms[0].selectCHk.value='N';
 * 
 * alert("document.forms[0].selectCHk.value===>"+document.forms[0].selectCHk.value);
 * 
 * document.forms[0].from.value = from; document.forms[0].to.value = to;
 * alert("mymymymymymymymymymy====>"+document.forms[0].name)
 * document.forms[0].submit(); }
 */

/*
 * function selectAll(Obj,start,end) { alert("myobjece===>"+Obj.checked)
 * 
 * if(Obj.checked) { for(var i=start;i<=end;i++){
 * 
 * if(eval("document.forms[0].select"+i))
 * eval("document.forms[0].select"+i).checked=true; } var notifyDisCode =
 * document.forms[0].notifyDisCode.value; var HTMLVal = "<HTML><BODY
 * onKeyDown='lockKey()'><form name='form1' id='form1' method='post'
 * action='../../eMR/jsp/LabTestCodesForNotifyDisDynamicValues.jsp'><input
 * type='hidden' name='clearAll' id='clearAll' value='notCleared'><input
 * type='hidden' name='notifyDisCode' id='notifyDisCode'
 * value='"+notifyDisCode+"'></form></BODY></HTML>";
 * parent.frames[2].document.body.insertAdjacentHTML('afterbegin',HTMLVal);
 * parent.frames[2].document.form1.submit();
 * document.getElementById("selectCHk").value='Y';
 *  } else{ for(var i=start;i<=end;i++) {
 * if(eval("document.forms[0].select"+i))
 * eval("document.forms[0].select"+i).checked=false;
 *  }
 * 
 * var HTMLVal = "<HTML><BODY onKeyDown='lockKey()'><form name='form1'
 * id='form1' method='post'
 * action='TerminologySetForPractitionerTypeDynamicValues.jsp'><input
 * type='hidden' name='clearAll' id='clearAll' value='clearAll'></form></BODY></HTML>";
 * parent.frames[2].document.body.insertAdjacentHTML('afterbegin',HTMLVal);
 * parent.frames[2].document.form1.submit();
 * document.getElementById("selectCHk").value='N'; } }
 */

/*
 * function chkForSelectAll(start,end) {
 * alert("*******************************"+parent.frames[2].document.forms[0].E.value);
 * if(parent.frames[2].document.forms[0].E.value == 'selectAll'){
 * //alert(parent.frames[2].document.forms[0].E.value);
 * document.forms[0].selectall.checked=true;
 * //alert(document.forms[0].selectall.checked);
 * selectAll(document.forms[0].selectall,start,end) } }
 */

/*
 * function SelectDefaultChk(obj,i) { if(obj.checked == true) {
 * eval("document.forms[0].dftremoveCode"+i).value = "N";
 * if(document.forms[0].selectall.checked==true)
 * document.getElementById("selectCHk").value='Y';
 * eval("document.forms[0].select"+i).checked = true;
 * 
 * }else{ eval("document.forms[0].dftremoveCode"+i).value = "Y";
 *  }
 * 
 *  }
 */

