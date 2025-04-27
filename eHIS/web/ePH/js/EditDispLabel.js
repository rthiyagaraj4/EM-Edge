var function_id = "" ;
var message		= "" ;
var flag		= "" ;
var result		= false ;
var pswd_flag="N";

function query() {
	f_queryCriteria.location.href	=	"../../ePH/jsp/EditDispLabelSearchCriteria.jsp";
}

function reset(){
	var obj = f_queryCriteria.document.forms[0];
	obj.reset();
	f_queryCriteria.location.href = "../../ePH/jsp/EditDispLabelSearchCriteria.jsp";
	f_queryResult.location.href	=	"../../eCommon/html/blank.html";
}

function changeLocalInstr(obj,locale,iLabelPairs,instr_type){ //THis function add for SRR20056-SCF-6260[Incident No.25586]
	bean_id		=	document.frmEditLabel.bean_id.value;
	bean_name	=	document.frmEditLabel.bean_name.value;	
	var xmlStr ="<root><SEARCH ";
	xmlStr+= "locale =\"" + locale + "\" " ;
	xmlStr+= "formObj =\"" + document.frmEditLabel.name + "\" " ;
	xmlStr+= "instr =\"" + obj.value + "\" " ;
	xmlStr+= "instr_type =\"" + instr_type + "\" " ;
	xmlStr+= "iLabelPairs =\"" + iLabelPairs + "\" " ;
	xmlStr+= "bean_id =\"" + bean_id + "\" " ;
	xmlStr+= "bean_name=\"" + bean_name + "\" " ;
	xmlStr +=" /></root>";
	var temp_jsp="EditDispLabelValidate.jsp?func_mode=changeLocalInstr&bean_id="+bean_id+"&bean_name="+bean_name;
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest() ;
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST",temp_jsp,false);
	xmlHttp.send(xmlDoc);
	responseText=xmlHttp.responseText ;
	eval(responseText);
	
}

async function showLoginWindow(homepage, store_code){
	
	var disp_locn_code = "";
	var dialogHeight= "300px" ;
	var dialogWidth	= "500px" ;
	var dialogTop = "195" ;
	var center = "1" ;
	var status="no";
	var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop+";scroll:no";
	var arguments	= "" ;
	if(homepage!='Y' || store_code=='' || store_code == undefined){ //if condition and else block Added for Bru-HIMS-CRF-073.1 [IN:047222]
		retVal =await window.showModalDialog("../../ePH/jsp/EditDispLabelLogin.jsp?homepage="+homepage+"&store_code="+store_code,arguments,features);
		if(retVal=="GOHOME" || retVal == undefined){
			//history.go(-1);
			if(homepage!='Y')
				window.location.href = '../../eCommon/jsp/dmenu.jsp';
			else{
				window.close();
				parent.CommonToolbar.ShowMenu.click();
				parent.CommonToolbar.unLoadTitleName();
			}
		}
		else{
			disp_locn_code = retVal;
			window.close();
			document.location.href ="../../ePH/jsp/EditDispLabelFrameSet.jsp?home_required_yn=Y&menu_id=PH&module_id=PH&function_id=EDIT_DISP_LABEL&function_name=Edit%20Dispense%20Label&function_type=F&access=NNYNN&desktopFlag=N&disp_locn_code="+disp_locn_code;
		}
	} //added for Bru-HIMS-CRF-073.1 [IN:047222] -start
	else{
		var retVal='';
		var bean_id		= "EditDispLabelBean" ;
		var bean_name	= "ePH.EditDispLabelBean";
		var xmlDoc="";
		var xmlHttp = new XMLHttpRequest();
		xmlStr	="<root><SEARCH " ;
		xmlStr += " disp_locn_code=\"" + store_code + "\"";
		xmlStr += " homepage=\"" + homepage + "\"";
		xmlStr +=" /></root>" ;
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open( "POST", "EditDispLabelValidate.jsp?bean_id="+bean_id+"&bean_name="+bean_name+"&func_mode=validatePassword", false ) ;
		xmlHttp.send( xmlDoc ) ;
		eval(xmlHttp.responseText);
		if(retVal == 'GOQUERYCRITERIA'){
			document.location.href ="../../ePH/jsp/EditDispLabelFrameSet.jsp?home_required_yn=N&module_id=PH&function_id=EDIT_DISP_LABEL&heading=Edit%20Dispense%20Label&function_type=F&access=NNYNN&disp_locn_code="+store_code;
		}
		else{
			alert(getMessage('ACCESS_DENIED',"PH"));
			parent.CommonToolbar.ShowMenu.click();
			parent.CommonToolbar.unLoadTitleName();
		}
	} //added for Bru-HIMS-CRF-073.1 [IN:047222] -end
}

function checkFlds( fields, names) {
	var errors = "" ;
	for( var i=0; i<fields.length; i++ ) {
		if(trimCheck(fields[i].value)) {
			fields[i].value = trimString(fields[i].value);
		}
		else{
			errors = errors + "APP-000001 " + names[i] +getLabel("Common.Cannotbeblank.label","Common") +" ..." + "\n" ;
			
		}
	}
	if ( errors.length != 0 ) {
		alert(errors) ;
		return false ;
	}
	return true ;
}

function uppercase() {
	key = window.event.keyCode;
	if((key>0x60) && (key< 0x7B))
		window.event.keyCode=key-0x20;
}

function focusOnPasswordField(obj){
	if(obj=="Y")
		document.forms[0].password.focus();
	pswd_flag= obj;
}

function focusOnPatientField(){
	document.forms[0].patient_id.focus();
	
}

function goHome(){
	window.returnValue="GOHOME";
	//window.close();
	const dialogTag = parent.document.getElementById("dialog_tag");
	dialogTag.close();
}

function showQueryCriteria(obj){
	var formObj = document.frmEditDispLabelLogin;
	var disp_locn = formObj.disp_locn.value;
	var disp_locn_name 	= formObj.disp_locn.options[formObj.disp_locn.selectedIndex].text;
	var password  = formObj.password.value;
	var fields  = new Array() ;
	var names   = new Array() ;

	if(password==""){
		fields[0]   = formObj.password ;
		names[0]   = getLabel("Common.password.label","Common");
	}
	else if(disp_locn=="") {
		fields[0]   = formObj.disp_locn ;
		names[0]   = getLabel("ePH.DispenseLocation.label","PH");
	}

	if(checkFlds( fields, names)){
		var bean_id		= formObj.bean_id.value ;
		var bean_name	= formObj.bean_name.value ;
		var xmlDoc="";
		var xmlHttp = new XMLHttpRequest();
		xmlStr	="<root><SEARCH " ;
		xmlStr += " password=\"" + password + "\"";
		xmlStr += " disp_locn_code=\"" + disp_locn + "\"";
		xmlStr += " disp_locn_name=\"" + encodeURIComponent(disp_locn_name) + "\"";
		xmlStr +=" /></root>" ;
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open( "POST", "EditDispLabelValidate.jsp?bean_id="+bean_id+"&bean_name="+bean_name+"&func_mode=validatePassword", false ) ;
		xmlHttp.send( xmlDoc ) ;
		eval(xmlHttp.responseText);
	//	alert("xmlHttp.responseText"+xmlHttp.responseText);
		if(pswd_flag == "N"){
			window.returnValue=disp_locn;
			//window.close();
			const dialogTag = parent.parent.document.getElementById("dialog_tag");
			dialogTag.close();
		}
	}
}

// This will call common patient search
async function callPatientSearch(){
	var frmObj = "";
	formObj=document.FormEditDispLabelQryCriteria;
	var patient_id = formObj.patient_id.value;
	if(patient_id == ""){
		patient_id = await PatientSearch();
		if (patient_id!= "" && patient_id != undefined){
			formObj.patient_id.value = patient_id;
			//formObj.patient_id.disabled = true;
			//formObj.btnPatientID.disabled = true;
		}
	}
	else{
		var bean_id			= formObj.bean_id.value ;
		var bean_name	    = formObj.bean_name.value ;	
		var xmlStr ="";
		xmlStr ="<root><SEARCH " ;
		xmlStr			+= " bean_id=\""+ bean_id + "\" ";
		xmlStr			+= " bean_name=\""+ bean_name + "\" ";
		xmlStr		    += " patient_id=\""+ patient_id + "\" ";
		xmlStr +=" /></root>" ;
		var xmlDoc = "" ;
		var xmlHttp = new XMLHttpRequest() ;
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
					
		xmlHttp.open( "POST", "EditDispLabelValidate.jsp?bean_id="+bean_id+"&bean_name="+bean_name+"&func_mode=patientsearch", false ) ;
		xmlHttp.send(xmlDoc);
		responseText=xmlHttp.responseText ;
		eval(responseText);
	}
//	var patient_id = PatientSearch();
}

function validateDate(formObj,obj,locale){
	var dispDate=convertDate(obj.value,'DMY',locale,"en");
	var systemdate=formObj.system_date.value;
	if( obj.value!=""){
		if(!(validDate(obj.value, "DMY",locale))){
			alert(getMessage("INVALID_DATE_TIME", "PH"));
			obj.focus();
			return false;
		}
		if(obj.value != ""){
		  if(!doDateCheckAlert(dispDate,systemdate,0)){
				alert(getMessage("PH_DISPDATE_CANNOT_GREATER_SYSDATE", "PH"));
				obj.select();
				obj.focus();
				return false;
			}
	   }
	}
	return true;
}

function loadQueryResultPage(frmObj){
	var pat_id = frmObj.patient_id.value;
	var disp_no = frmObj.Dispense_No.value;
	var disp_date = frmObj.Dispense_Date.value;
	if(pat_id=="" && disp_no=="" && disp_date==""){
		alert(getMessage("PH_ATLEAST_ONE_CRITERIA", "PH"));
		
	}
	else{
		parent.f_queryResult.location.href	=	"../../ePH/jsp/EditDispLabelSearchResult.jsp?patient_id="+pat_id+"&dispense_no="+disp_no+"&dispense_date="+disp_date;
	}
}

async function loadEditLabelDialog(patient_id,patient_name,dispense_no,dispense_date_time,ord_date_time,pract_name,order_id,iv_prep_yn, patient_class){ //patient_class Added for Bru-HIMS-CRF-414 [IN045554]
	var dialogHeight= "600px" ;
	var dialogWidth	= "900px" ;
	var dialogTop = "195" ;
	var center = "1" ;
	var status="no";
	var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop+";scroll:yes";
	var arguments	= "" ;
	//window.open("../../ePH/jsp/EditLabel.jsp?patient_id="+patient_id+"&patient_name="+patient_name+"&dispense_no="+dispense_no+"&dispense_date_time="+dispense_date_time+"&ord_date_time="+ord_date_time+"&pract_name="+pract_name+"&order_id="+order_id+"&iv_prep_yn="+iv_prep_yn,arguments,features);encodeURIComponent(patient_name,"UTF-8")
	//retVal=window.showModalDialog("../../ePH/jsp/EditLabel.jsp?patient_id="+patient_id+"&patient_name="+patient_name+"&dispense_no="+dispense_no+"&dispense_date_time="+dispense_date_time+"&ord_date_time="+ord_date_time+"&pract_name="+pract_name+"&order_id="+order_id+"&iv_prep_yn="+iv_prep_yn,arguments,features);
	//retVal=window.showModalDialog("../../ePH/jsp/EditLabel.jsp?patient_id="+patient_id+"&patient_name="+encodeURIComponent(patient_name,"UTF-8")+"&dispense_no="+dispense_no+"&dispense_date_time="+dispense_date_time+"&ord_date_time="+ord_date_time+"&pract_name="+pract_name+"&order_id="+order_id+"&iv_prep_yn="+iv_prep_yn,arguments,features);
	// Remove Encode of Patient for SRR20056-SCF-6260[Incident No.25586]
	retVal=await window.showModalDialog("../../ePH/jsp/EditLabel.jsp?patient_id="+patient_id+"&patient_name="+patient_name+"&dispense_no="+dispense_no+"&dispense_date_time="+dispense_date_time+"&ord_date_time="+ord_date_time+"&pract_name="+pract_name+"&order_id="+order_id+"&iv_prep_yn="+iv_prep_yn+"&patient_class="+patient_class,arguments,features);  //patient_class Added for Bru-HIMS-CRF-414 [IN045554]
}

function cancelDialog(){
	const dialogTag = parent.parent.document.getElementById("dialog_tag");
	dialogTag.close();

	//document.forms[0].reset();
}

function checkMaxLength(obj){
	var val = "";
	val = obj.value;	
	if(obj.value.length > 250) {
			var msg = getMessage("REMARKS_CANNOT_EXCEED","Common");
			msg = msg.replace("$",getLabel("Common.PatientInstructions.label","Common"));
			msg = msg.replace("#",150);
			alert(msg);
			obj.value = val.substring(0,150);
		
	}
}

function updateTable(frmObj){
	var no_of_records = frmObj.no_of_records.value;
	var dispense_no = frmObj.dispense_no.value;
	var allow_edit_disp_label = frmObj.allow_edit_disp_label.value;
	
	var bean_id = frmObj.bean_id.value;
	var bean_name = frmObj.bean_name.value;
	//var arrObj = frmObj.elements;
	var caution_1 = "";
	var special_1 = "";
	var patient_int = "";
	var loc_caution_1 = "";
	var loc_special_1 = "";
	var loc_patient_int = "";
	var pres_remarks = "";
	var dispSrlNo='';
	var drug_ind = "";// Added for ML-BRU-CRF-072[Inc:29938]
	var xmlStr ="<root><SEARCH ";			
	xmlStr+= " no_of_records =\"" + no_of_records + "\" " ;
	xmlStr+= " dispense_no =\"" + dispense_no + "\" " ;
	xmlStr+= " bean_id =\"" + bean_id + "\" " ;
	xmlStr+= " bean_name=\"" + bean_name + "\" " ;
	xmlStr+= " allow_edit_disp_label=\"" + allow_edit_disp_label + "\" " ;
	if(allow_edit_disp_label=='Y'){
		xmlStr+= " labelLangId=\"" + frmObj.labelLangId.value + "\" " ;
		xmlStr+= " facility_id=\"" + frmObj.facility_id.value + "\" " ;
		var labelExists = frmObj.labelExists.value;
		if(labelExists==false || labelExists=='false'){
			if(!confirm(getMessage("PH_EDITLABEL_CHANGE_LANG","PH"))){
				parent.window.close();
				return false;
			}
		}
	}
	var dispQty_yn=true, noOfPrints_yn=true, dosageDtl_yn=true;
	for(j=1; j<=parseInt(no_of_records); j++){
		i = eval("frmObj.dispSrlNo"+j+".value");
		if(allow_edit_disp_label == 'Y'){
			xmlStr+= " dispSrlNo"+j+"=\"" + i + "\" " ;
			if(eval("frmObj.dispQty"+i+".value")=='' || parseInt(eval("frmObj.dispQty"+i+".value"))<=0)
				dispQty_yn = false;
			if(eval("frmObj.noOfPrints"+i+".value")=='' || parseInt(eval("frmObj.noOfPrints"+i+".value"))<=0)
				noOfPrints_yn = false;
			if(eval("frmObj.dosageDtl_"+i+".value")=='')
				dosageDtl_yn = false;
			if(!(dispQty_yn && noOfPrints_yn && dosageDtl_yn))
				break;
			xmlStr+= " dispQty"+i+"=\"" +eval("frmObj.dispQty"+i+".value") + "\" " ;
			xmlStr+= " disp_uom_code"+i+"=\"" +eval("frmObj.disp_uom_code"+i+".value") + "\" " ;
			xmlStr+= " noOfPrints"+i+"=\"" +eval("frmObj.noOfPrints"+i+".value") + "\" " ;
			xmlStr+= " pres_drug_code"+i+"=\"" +eval("frmObj.pres_drug_code"+i+".value") + "\" " ;
			xmlStr+= " drug_code_"+i+"=\"" +eval("frmObj.drug_code_"+i+".value") + "\" " ;
			xmlStr+= " dosageDtl_"+i+"=\"" + encodeURIComponent(eval("frmObj.dosageDtl_"+i+".value"),'UTF-8') + "\" " ;
			xmlStr+= " instruction_"+i+"=\"" + encodeURIComponent(eval("frmObj.instruction_"+i+".value"),'UTF-8') + "\" " ;
		}
		else{
			caution_1 = eval("frmObj.caution_1_"+i+".value");
			special_1 = eval("frmObj.special_1_"+i+".value");
			patient_int = eval("frmObj.patient_int_"+i+".value");
			//loc_caution_1 = eval("frmObj.loc_caution_1_"+i+".value");
			//loc_special_1 = eval("frmObj.loc_special_1_"+i+".value");
			loc_caution_1 = eval("frmObj.loc_caution_1_"+0+".value"); //value change for SRR20056-SCF-6260[Incident No.25586]
			loc_special_1 = eval("frmObj.loc_special_1_"+0+".value");//value change for SRR20056-SCF-6260[Incident No.25586]

			loc_patient_int = eval("frmObj.patient_int_local_"+i+".value");
			pres_remarks = eval("frmObj.pres_remarks_"+i+".value");
			drug_ind	 = eval("frmObj.drug_ind_"+i+".value");// Added for ML-BRU-CRF-072[Inc:29938]
			xmlStr+= " dispSrlNo"+j+"=\"" + i + "\" " ;
			xmlStr+= " caution_"+i+"=\"" + encodeURIComponent(caution_1,'UTF-8') + "\" " ;
			xmlStr+= " special_"+i+"=\"" + encodeURIComponent(special_1 ,'UTF-8')+ "\" " ;
			xmlStr+= " patient_int_"+i+"=\"" + encodeURIComponent(patient_int,'UTF-8') + "\" " ;
			xmlStr+= " loc_caution_"+i+"=\"" + encodeURIComponent(loc_caution_1,'UTF-8') + "\" " ;
			xmlStr+= " loc_special_"+i+"=\"" + encodeURIComponent(loc_special_1,'UTF-8') + "\" " ;
			xmlStr+= " loc_patient_int_"+i+"=\"" + encodeURIComponent(loc_patient_int,'UTF-8') + "\" " ;
			xmlStr+=" pres_remarks_"+i+"=\"" +pres_remarks + "\" " ;
			xmlStr+=" drug_ind_"+i+"=\"" +encodeURIComponent(drug_ind,'UTF-8') + "\" " ;// Added for ML-BRU-CRF-072[Inc:29938]
		}
	}		
	if(!(dispQty_yn && noOfPrints_yn && dosageDtl_yn)){
		msg = getMessage("CAN_NOT_BE_BLANK","Common");
		var fldLabel='';
		if(!dispQty_yn){
			msg = getMessage("PH_NOT_BLANK_ZERO_COMMON","PH");
			fldLabel = getLabel("ePH.DispensedQty.label","PH");
		}
		if(!noOfPrints_yn){
			msg = getMessage("PH_NOT_BLANK_ZERO_COMMON","PH");
			if(fldLabel!='')
				fldLabel += ", "+getLabel("ePH.NoOfPrints.label","PH");
			else
				fldLabel   = getLabel("ePH.NoOfPrints.label","PH");
		}
		if(!dosageDtl_yn){
			if(fldLabel!='')
				fldLabel += ", "+getLabel("ePH.DosageDetail.label","PH");
			else
				fldLabel   = getLabel("ePH.DosageDetail.label","PH");
		}
		msg = msg.replace('$', fldLabel);
		alert(msg);
		return false;
	}
	xmlStr +=" /></root>";
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest() ;
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open( "POST", "EditDispLabelValidate.jsp?bean_id="+bean_id+"&bean_name="+bean_name+"&func_mode=editLabels", false ) ;
	xmlHttp.send(xmlDoc);
	responseText=xmlHttp.responseText ;
	eval(responseText);
}

function showalert(){
	alert(getMessage('RECORD_MODIFIED','PH'));
	var print_confirm=confirm(getMessage("DO_WANT_PPRINT_DISP_LABEL", "PH"));
	if(print_confirm){
		var frmObjDtls = document.frmEditLabel;
		var frmObjHeader = parent.frames[0].document.frmEditLabelHeader;
		var no_of_records = frmObjDtls.no_of_records.value;
		var dispense_no = frmObjDtls.dispense_no.value;
		var bean_id = frmObjDtls.bean_id.value;
		var bean_name = frmObjDtls.bean_name.value;
		var patient_id = frmObjHeader.patient_id.value;
		var dispense_date_time = frmObjHeader.dispense_date_time.value;
		var order_id = frmObjHeader.order_id.value;
		var iv_prep_yn = frmObjHeader.iv_prep_yn.value;
		var xmlStr ="<root><SEARCH ";	
		xmlStr+= " no_of_records =\"" + no_of_records + "\" " ;
		xmlStr+= " dispense_no =\"" + dispense_no + "\" " ;
		xmlStr+= " bean_id =\"" + bean_id + "\" " ;
		xmlStr+= " bean_name=\"" + bean_name + "\" " ;
		xmlStr+= " patient_id=\"" + patient_id + "\" " ;
		xmlStr+= " dispense_date_time=\"" + dispense_date_time + "\" " ;
		xmlStr+= " order_id=\"" + order_id + "\" " ;
		xmlStr+= " iv_prep_yn=\"" + iv_prep_yn + "\" " ;
		xmlStr +=" /></root>";
		var xmlDoc = "" ;
		var xmlHttp = new XMLHttpRequest() ;
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
			
		xmlHttp.open( "POST", "EditDispLabelValidate.jsp?bean_id="+bean_id+"&bean_name="+bean_name+"&func_mode=printLabel", false ) ;
		xmlHttp.send(xmlDoc);
		responseText=xmlHttp.responseText ;
		eval(responseText);
	
	}
	window.close();
}

async function viewAuditTrail(dispense_no){
	var dialogHeight= "300px" ;
	var dialogWidth	= "500px" ;
	var dialogTop = "195" ;
	var center = "1" ;
	var status="no";
	var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop+";scroll:yes";
	var arguments	= "" ;
	retVal =await window.showModalDialog("../../ePH/jsp/EditLabelViewAuditTrail.jsp?dispense_no="+dispense_no,arguments,features);
}

function chkpatID(yes_no){
	var frmObj = "";
	formObj=document.FormEditDispLabelQryCriteria;
	if(yes_no == "N"){
		alert(getMessage("PH_NOT_VALID_PATIENT","PH"));
		formObj.patient_id.value="";
		formObj.patient_id.focus();
	}
	else if(yes_no == "Y"){
		formObj.patient_id.disabled = true;
		formObj.btnPatientID.disabled = true;
	}
}

function callPatientSearchTabOut(){
	var frmObj = "";
	formObj=document.FormEditDispLabelQryCriteria;
	var patient_id = formObj.patient_id.value;
	if(!(patient_id =="")){
		var bean_id			= formObj.bean_id.value ;
		var bean_name	    = formObj.bean_name.value ;	
		var xmlStr ="";
		xmlStr ="<root><SEARCH " ;
		xmlStr			+= " bean_id=\""+ bean_id + "\" ";
		xmlStr			+= " bean_name=\""+ bean_name + "\" ";
		xmlStr		    += " patient_id=\""+ patient_id + "\" ";
		xmlStr +=" /></root>" ;
		var xmlDoc = "" ;
		var xmlHttp = new XMLHttpRequest() ;
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open( "POST", "EditDispLabelValidate.jsp?bean_id="+bean_id+"&bean_name="+bean_name+"&func_mode=patientsearch", false ) ;
		xmlHttp.send(xmlDoc);
		responseText=xmlHttp.responseText ;
		eval(responseText);
	}
}

function assignLocaltxt(instr_type, iLabelPairs, loc_text){//Add this function for Incident No.28951
	if(instr_type=='C')
		eval('document.frmEditLabel.loc_caution_1_'+iLabelPairs).value=decodeURIComponent(loc_text);
	else
		eval('document.frmEditLabel.loc_special_1_'+iLabelPairs).value=decodeURIComponent(loc_text);
}
/*Added newly for NewRequirement for client CRF[ML-BRU-CRF-072[Inc:29938] Start */
function CopyDrugRemarksValue(frmObj,iLabelPairs){
	var noOfDrugs = frmObj.no_of_records.value;
	for(j=1; j<=parseInt(noOfDrugs); j++){
		i = eval("frmObj.dispSrlNo"+j+".value");
		var patient_ins = eval("frmObj.patient_int_" + i + ".value")+ eval("frmObj.remarks_new_" + i + ".value");
		eval("frmObj.patient_int_" + i).value = patient_ins;
		var patient_ins_loc = eval("frmObj.patient_int_local_" + i + ".value")+ eval("frmObj.remarks_new_" + i + ".value");
		eval("frmObj.patient_int_local_" + i).value = patient_ins_loc;
	}
}

function checkDrugIndMaxLimit(obj,maxLeng) { 
	if(obj.value.length > maxLeng) {
		val = obj.value;
		var msg = getMessage("REMARKS_CANNOT_EXCEED","Common");
		msg = msg.replace("$",getLabel("ePH.DrugIndications.label","PH"));
		msg = msg.replace("#",maxLeng);
		obj.value = val.substring(0,(val.length)-1);
		alert(msg);
		obj.focus();
		return false;
	} 
	else 
		return true;
}/*Added newly for NewRequirement for client CRF[ML-BRU-CRF-072[Inc:29938] End */

function setlabelLangId(){ //added for Bru-HIMS-CRF-414 [IN:045554]
	var formObj = document.frmEditLabelHeader;
	var allow_edit_disp_label = formObj.allow_edit_disp_label.value;
	if(allow_edit_disp_label =='Y'){
		var labelLangId = formObj.labelLangId.value;
		var bean_id			= formObj.bean_id.value ;
		var bean_name	    = formObj.bean_name.value ;	
		var xmlStr ="";
		xmlStr ="<root><SEARCH " ;
		xmlStr			+= " bean_id=\""+ bean_id + "\" ";
		xmlStr			+= " bean_name=\""+ bean_name + "\" ";
		xmlStr			+= " labelLangId=\""+ labelLangId + "\" ";
		xmlStr +=" /></root>" ;
		var xmlDoc = "" ;
		var xmlHttp = new XMLHttpRequest() ;
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open( "POST", "EditDispLabelValidate.jsp?bean_id="+bean_id+"&bean_name="+bean_name+"&func_mode=setlabelLangId", false ) ;
		xmlHttp.send(xmlDoc);
		responseText=xmlHttp.responseText ;
		var params = formObj.params.value;
		parent.f_drug_details.location.href = "../../ePH/jsp/EditLabelDetails.jsp?"+params;
	}
}
