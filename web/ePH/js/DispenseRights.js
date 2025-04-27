var function_id	= "PH_DISP_RIGHTS" ;
var result		= false ;
var message		= "" ;
var flag		= "" ;

function create() {
	f_query_add_mod.location.href="../../ePH/jsp/DispenseRightsFrames.jsp?function_id="+function_id+"&mode="+MODE_INSERT;
}

function query() {
	f_query_add_mod.location.href="../../ePH/jsp/DispenseRightsQueryCriteria.jsp?function_id="+function_id;
}

async function searchUserNames( target ) {
	var frmObj = document.formDispenseRights;
	frmObj.USER_ID.value = "";
	var argumentArray	= new Array() ;
	var dataNameArray	= new Array() ;
	var dataValueArray	= new Array() ;
	var dataTypeArray	= new Array() ;

	argumentArray[0] = frmObj.SQL_PH_DISP_RIGHTS_SELECT1.value;
	argumentArray[1] = dataNameArray ;
	argumentArray[2] = dataValueArray ;
	argumentArray[3] = dataTypeArray ;
	argumentArray[4] = "1,2";
	argumentArray[5] = target.value;
	argumentArray[6] = CODE_LINK ;
	argumentArray[7] = CODE_DESC ;

	retArray =await CommonLookup( getLabel("Common.username.label","Common"), argumentArray );
	var str =unescape(retArray);
	var arr = str.split(",");

	if(retArray != null && retArray != "" )  {
		frmObj.USER_ID.value = arr[0];
 		target.value = arr[1] ; /* if code need to be returned */
		frmObj.USER_NAME.disabled=true;
		//frmObj.USER_SEARCH.disabled=true;
 		frmObj.USER_PROFILE.disabled=false;
 		frmObj.USER_PROFILE.focus();
	}
	else {
		target.value = "";
		target.focus();
		frmObj.USER_PROFILE.disabled=true;
	}
}

function checkUser(objVal) {
	//alert("objVal---->" +objVal);
	if (objVal == "") {
		document.formDispenseRights.USER_NAME.disabled=false;
		document.formDispenseRights.USER_PROFILE.disabled=true;
	}
	else {
		searchUserNames(document.formDispenseRights.USER_NAME);
	}
}

async function callUserDetails() {
	var user_id			= document.formDispenseRights.USER_ID.value;
	//alert("user_id---------->" +user_id);
	var dialogHeight	= "34vh" ;
	var dialogWidth		= "25vw" ;
	var dialogTop		= "10" ;
	var dialogLeft		= "20" ;
	var center			= "0" ;
	var status			= "no";
	var features		= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop + ";dialogLeft:" + dialogLeft;
	var arguments		= "" ;
	retVal				=await window.showModalDialog( "../../ePH/jsp/DispenseRightsUserProf.jsp?user_id="+user_id, arguments, features );

		if(retVal != null && retVal != "" ) {
		document.formDispenseRights.user_pass.value=retVal;
		storePass(retVal);
	}

}

function checkPass() {
	var frmObj	= document.formDispenseRightsUserProf;
	var chkFlag	= true;

	if ( frmObj.OLD_PASSWORD ) {
		if ( (frmObj.OLD_PASSWORD.value).toLowerCase() != (frmObj.CURR_PASSWORD.value).toLowerCase() ) {//added .toLowerCase() for GDOH-CRF-0086 [IN:058551]
			chkFlag = false;
			alert(getMessage("ENTER_CORRECT_PWD","PH"));
			frmObj.OLD_PASSWORD.focus();
		}
	}

	if ( frmObj.CONF_PASSWORD.value != frmObj.NEW_PASSWORD.value ) {
		chkFlag = false;
		alert(getMessage("PWD_DO_NO_MATCH","PH"));
		frmObj.NEW_PASSWORD.focus();
	}

	if(chkFlag) {
		//window.returnValue = frmObj.CONF_PASSWORD.value + '|' + frmObj.bean_id.value + '|' + frmObj.bean_name.value;
		//window.close();
		let dialogBody = parent.document.getElementById('dialog-body');
		dialogBody.contentWindow.returnValue = frmObj.CONF_PASSWORD.value + '|' + frmObj.bean_id.value + '|' + frmObj.bean_name.value;

		const dialogTag = parent.document.getElementById('dialog_tag');    
		dialogTag.close(); 
	}
}

function storePass ( password ) {
	var pass = password.split('|');

	var user_pass = pass[0] ;
	var bean_id = pass[1] ;
	var bean_name = pass[2] ;

	/*var xmlDoc = new ActiveXObject( "Microsoft.XMLDom" ) ;
	var xmlHttp = new ActiveXObject( "Microsoft.XMLHTTP" ) ;*/
	var xmlDoc = "";
	var xmlHttp = new XMLHttpRequest();
	/* Checking if the user has entered a null password*/

	xmlHttp.open( "POST", "DispenseRightsValidate.jsp?bean_id=" + bean_id + "&bean_name=" + bean_name + "&password=" + user_pass, false ) ;
	xmlHttp.send( xmlDoc ) ;
	responseText=xmlHttp.responseText ;


}

/* This function loads the subdata screen in the 2nd frame */
function loadDetails(mode, obj) {
	var frmobj		= document.formDispenseRights;
		if (mode == "1") {
		var objVal = obj.value;
		if (objVal != "") {
			
			var errorPage	= "../../eCommon/jsp/MstCodeError.jsp" ;
			var blankObj 	= null ;
			var fields		= new Array ( frmobj.USER_NAME );
			var names		= new Array ( getLabel("Common.user.label","Common") );

			blankObject		= checkFieldsofMst( fields, names, parent.parent.messageFrame, errorPage) ;
			if(blankObject==true) {
				
				frmobj.USER_NAME.disabled = true;
				frmobj.DISP_LOCN.disabled = true;
				frmobj.USER_SEARCH.disabled = true;
				var user_id = frmobj.USER_ID.value;
				
				parent.disp_rights_sub_frame.location.href="../../ePH/jsp/DispenseRightsSubData.jsp?disp_locn_code="+objVal+"&appl_user_id="+user_id+"&function_id="+function_id+"&mode="+MODE_INSERT;
				parent.parent.messageFrame.location.href	="../../eCommon/jsp/MstCodeError.jsp";
			}
			/*else { //else block commented for JD-CRF-0156[IN041737]
				blankObject.focus() ;
				obj.value = "";
			}*/
		}
		else
			parent.disp_rights_sub_frame.location.href="../../eCommon/html/blank.html";
	}
	else if (mode == "2") {
		var disp_locn_code	= frmobj.DISP_LOCN.value;
		var appl_user_id	= frmobj.USER_ID.value;
		parent.disp_rights_sub_frame.location.href="../../ePH/jsp/DispenseRightsSubData.jsp?disp_locn_code="+disp_locn_code+"&appl_user_id="+appl_user_id+"&function_id="+function_id+"&mode="+MODE_MODIFY;
	}
}

function reset() {
	if ( checkIsValidForProceed( "dispenserightsquerycriteria", "reset" ) ) {
		f_query_add_mod.document.query_form.reset();
	}
	else if ( checkIsValidForProceed( "dispenserightsaddmodify", "reset" ) ) {
		var frmObj = f_query_add_mod.disp_rights_main_frame.document.formDispenseRights
		if(frmObj.mode.value == MODE_INSERT) {
			create();
/*			f_query_add_mod.disp_rights_sub_frame.location.href="../../eCommon/html/blank.html";
			frmObj.reset();
			frmObj.USER_NAME.disabled		= false;
			frmObj.DISP_LOCN.disabled		= false;
			frmObj.USER_SEARCH.disabled		= false;
			frmObj.USER_PROFILE.disabled	= true;*/
		}
		else {
			f_query_add_mod.disp_rights_sub_frame.location.reload();
			//f_query_add_mod.disp_rights_sub_frame.formDispenseRightsSubData.reset();			
		}
	}
}

/*dispenserightssubdata,apply is passed from apply */
function checkIsValidForProceed( urlName, mode ) {
	var url = f_query_add_mod.location.href;
	if (mode == "apply" && f_query_add_mod.disp_rights_sub_frame)
		url = f_query_add_mod.disp_rights_sub_frame.location.href;
	else if (mode == "reset" && f_query_add_mod.disp_rights_main_frame)
		url = f_query_add_mod.disp_rights_main_frame.location.href;

	url = url.toLowerCase();

	if ( (url.indexOf( urlName ) != -1) )
		return true;
	else
		return false;
}

function assignResult( _result, _message, _flag ) {

	result	= _result ;
	message	= _message ;
    flag	= _flag ;
}

function disableReprints(obj) {
	var frmObj = document.formDispenseRightsSubData;
	if(obj.checked) {
		//frmObj.NO_OF_REPRINTS.disabled = false;
		//frmObj.NO_OF_REPRINTS.focus();
	}
	else {
		//frmObj.NO_OF_REPRINTS.disabled	= true;
		//frmObj.NO_OF_REPRINTS.value		= "";
	}
}

function modify(obj) {
	var userid = trimString(obj.cells[0].innerText);
	var username = trimString(obj.cells[1].innerText);
	var locncode = trimString(obj.cells[2].innerText);
	var locndesc = trimString(obj.cells[3].innerText);
	parent.f_query_add_mod.location.href="../../ePH/jsp/DispenseRightsFrames.jsp?function_id="+function_id+"&mode="+MODE_MODIFY+"&userid="+userid+"&username="+encodeURIComponent(username)+"&locncode="+locncode+"&locndesc="+encodeURIComponent(locndesc);
}

function deleterecord() {
	/*  If delete is pressed , the function should return false */
   	var url = f_query_add_mod.location.href;
	url = url.toLowerCase();
   	if ( (url.indexOf("dispenserightsframes")==-1) ) {
		messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num=";
		return false;
	}
	else{
		var frmObj	= f_query_add_mod.disp_rights_main_frame.document.formDispenseRights;
		if (frmObj.mode.value!='2'){
			messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num=";
			return false;
		}
		else{

			//Setting delete mode and submitting the form
			var frmobj1			= f_query_add_mod.disp_rights_sub_frame.document.formDispenseRightsSubData;
			frmobj1.mode.value=MODE_DELETE;
			//if(confirm(f_query_add_mod.getMessage("DELETE_RECORD")))
			var get_val=confirm(getMessage("DELETE_RECORD","Common"));
			if(get_val==true){
				apply();
			}else{
				f_query_add_mod.disp_rights_sub_frame.document.formDispenseRightsSubData.mode.value = MODE_MODIFY;
				messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num=";
				return false;
			}
		}
	}		
}

/* This apply function is called from the top frame button */
function apply() {
	if ( !checkIsValidForProceed( "dispenserightssubdata", "apply" ) ) {
		messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num=";
		return false;
	}
	var frmobj			= f_query_add_mod.disp_rights_sub_frame.document.formDispenseRightsSubData;
	var frmobj1			= f_query_add_mod.disp_rights_main_frame.document.formDispenseRights;
	var continue_flag	= false;
	if(frmobj.GENERAL_YN.checked || frmobj.NARCOTIC_YN.checked || frmobj.CONTROLLED_YN.checked )
		continue_flag = true;
	if(continue_flag) {
		var errorPage	= "../../eCommon/jsp/MstCodeError.jsp" ;
		//var blankObj 	= null ;
		/* We have to check here if the user has a password already. */
		var blankObject=true;
		var pwd=frmobj.oldPassword.value;
		if((pwd==null)||(pwd=="" )){
			// only if no password exists, we have to check for mandatory password
			var fields	= new Array ( frmobj1.user_pass );
			var names	= new Array ( getLabel("ePH.UserProfile.label","PH") );
			blankObject  = checkFieldsofMst( fields, names, messageFrame, errorPage) ;
		}
		if(blankObject) {
			if(frmobj.TRACK_OUTSOURCING_YN.checked == true){
				if(frmobj.OUTSOURCING_SEND.checked == false && frmobj.OUTSOURCING_RECEIVE.checked == false && frmobj.OUTSOURCING_DELIVER.checked == false){
					messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ getMessage("PH_OUTSOURCING_ACCESS_RIGHTS","PH");
					return false;
				}
			}
			eval( formApply(frmobj, PH_CONTROLLER) ) ;
			messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ message;
			create();
		}
		else {
			frmobj1.USER_PROFILE.focus() ;
		}
	}
	else
		messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+getMessage("ATLEAST_ONE_DISP_DRUG_CLS_SHLD_BE_SELECTED","PH");
//	Atleast one Dispensable Drug Class Should Be Selected";
}

function onSuccess() {
}

//added for Bru-HIMS-CRF-087 [IN:029953] - start
function trackOutSourcing(obj){
	if(obj.checked == true){
		document.getElementById("trOutSourcingAccess").style='display';
		document.getElementById("trOutSourcingDefault").style='display';
	}
	else{
		document.getElementById("trOutSourcingAccess").style.display='none';
		document.getElementById("trOutSourcingDefault").style.display='none';
		document.formDispenseRightsSubData.OUTSOURCING_SEND.checked=false;
		document.formDispenseRightsSubData.OUTSOURCING_RECEIVE.checked=false;
		document.formDispenseRightsSubData.OUTSOURCING_DELIVER.checked=false;
		document.formDispenseRightsSubData.OUTSOURCING_DEF_FACILITY.selectedIndex=0;
		clearDefTrackAction();
	}
}

function clearDefTrackAction(){
	var len =document.formDispenseRightsSubData.OUTSOURCING_DEF_ACTION.options.length;
	for(var i=0;i<len;i++) {
		document.formDispenseRightsSubData.OUTSOURCING_DEF_ACTION.remove("DefTrackAction") ;
	}
	var opt = document.createElement("OPTION") ;
	opt.text = "   ---"+getLabel("ePH.Select.label","PH")+"---   "  ;
	opt.value = "" ;
	document.formDispenseRightsSubData.OUTSOURCING_DEF_ACTION.add(opt);
}

function addToDefAction(obj, action){
	defActionObj = document.formDispenseRightsSubData.OUTSOURCING_DEF_ACTION;
	var len =defActionObj.options.length;
	if(obj.checked == true){
		for(var i=0;i<len;i++) {
			if(defActionObj.options[i].value == '')
				defActionObj.remove(i) ;
		}
		var opt = document.createElement("OPTION") ;
		if(action == 'S')
			opt.text = getLabel("ePH.Send.label","PH") ;
		else if(action == 'R')
			opt.text = getLabel("ePH.Receive.label","PH") ;
		else if(action == 'D')
			opt.text = getLabel("ePH.Deliver.label","PH") ;
		opt.value = action;
		defActionObj.add(opt);
	}
	else{
		for(var i=0;i<len;i++) {
			if(defActionObj.options[i].value == action){
				defActionObj.remove(i) ;
				break;
			}
		}
		if(len == 1){
			var opt = document.createElement("OPTION") ;
			opt.text = "   ---"+getLabel("ePH.Select.label","PH")+"---   "  ;
			opt.value = "" ;
			defActionObj.add(opt);
		}
	}
}//added for Bru-HIMS-CRF-087 [IN:029953] - End

function mednRtnBillGenStatus(mednRetnObj, patClass){ // Added for JD-CRF-0178 [IN:039208]
	var billGenObj;
	if(patClass=='IP')
		billGenObj = document.formDispenseRightsSubData.IP_MEDN_RTN_AFTER_BILL_GEN;
	else
		billGenObj = document.formDispenseRightsSubData.OP_MEDN_RTN_AFTER_BILL_GEN;
	if(mednRetnObj.checked ==true){
		billGenObj.disabled=false;
	}
	else{
		billGenObj.value="";
		billGenObj.disabled=true;
	}
}

function addToDefStage(obj, stage, stage_legend ,pat_class){ //added for [IN047788]
	var defStageObj;
	if(pat_class=='IP')
		defStageObj = document.formDispenseRightsSubData.IP_DFLT_DISP_STAGE;
	else
		defStageObj = document.formDispenseRightsSubData.OP_DFLT_DISP_STAGE;
	var len =defStageObj.options.length;
	if(obj.checked == true){
		var opt = document.createElement("OPTION") ;
		opt.text = stage_legend ;
		opt.value = stage;
		defStageObj.add(opt);
	}
	else{
		for(var i=0;i<len;i++) {
			if(defStageObj.options[i].value == stage){
				defStageObj.remove(i) ;
				break;
			}
		}
	}
}

function dispDefTokenSeries(registerYNobj){
	if(registerYNobj.checked==true){
		document.formDispenseRightsSubData.DFLT_TOKEN_SERIES_IND.disabled=false;
		document.formDispenseRightsSubData.SORT_TOKEN_SERIES_IND.disabled=false;
	}
	else{
		document.formDispenseRightsSubData.DFLT_TOKEN_SERIES_IND.disabled=true;
		document.formDispenseRightsSubData.SORT_TOKEN_SERIES_IND.disabled=true;
		document.formDispenseRightsSubData.DFLT_TOKEN_SERIES_IND.value='W';
		document.formDispenseRightsSubData.SORT_TOKEN_SERIES_IND.value='O';
	}
}
//added for ml-mmoh-crf-0863 start
function modifyAuthAmendPres(changeDoseobj){
	if(changeDoseobj.checked==true){
		document.getElementById("AUTH_AMEND_PRES_LABEL_YN").style='display';
		document.getElementById("AUTH_AMEND_PRES_LABEL_YN").style.visibility ='inherit';
		
		document.formDispenseRightsSubData.AUTH_AMEND_PRES_YN.style='display';
		document.getElementById("AUTH_AMEND_PRES_YN").style.visibility ='inherit';
		document.formDispenseRightsSubData.AUTH_AMEND_PRES_YN.value='Y';
	}
	else{
		document.getElementById("AUTH_AMEND_PRES_LABEL_YN").style.display ='none';
		document.formDispenseRightsSubData.AUTH_AMEND_PRES_YN.style.display='none';
		document.formDispenseRightsSubData.AUTH_AMEND_PRES_YN.value='N';
		
	}
}
//added for ml-mmoh-crf-0863  end
