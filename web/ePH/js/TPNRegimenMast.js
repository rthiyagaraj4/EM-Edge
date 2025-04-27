//saved on 26/10/2005
/* Date       		    Edit History     Name      			Rev.Date		Rev.Name		                   Description
----------------------------------------------------------------------------------------------------------------------------------------------------------
	?				    ?				 ?				    ?			    ?								   ?
  29/01/2019		    IN068728		 Devindra				 		                                       ML-MMOH-CRF-1266 [IN:068728]
---------------------------------------------------------------------------------------------------------------------------------------------------------
*/
var result	= false;
var message	= "";
var flag	= "";
var itemDesc = "";

function create() {
    f_query_add_mod.location.href="../../ePH/jsp/TPNRegimenMastFrames.jsp?&mode="+MODE_INSERT;
}

function query() {
    f_query_add_mod.location.href="../../ePH/jsp/TPNRegimenMastQueryCriteria.jsp" ;
}

function apply() {

	if ( !checkIsValidForProceed( "tpnregimenmastframes" ) ) {
		messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num=";
		return false;
	}

	var formObj	= f_query_add_mod.f_tpn_regimen_add_modify.document.TPNRegimenMastForm;
	var link	= formObj.curr_tab.value;
	frmObj		= "";

	if(link == ""){
	//	onSuccess();
	frmObj =	f_query_add_mod.f_tpn_regimen_add_modify.document.TPNRegimenMastForm;
//	}else{

	}
	else if(link=="OrderingDispensingRules_tab") {
			frmObj	= f_query_add_mod.f_tpn_regimen_details.document.TPNRegimenMastOrdDispForm;
			
		}
		else if(link=="Constituents_tab") {
			frmObj	= f_query_add_mod.f_tpn_regimen_details.document.TPNRegimenMastConsForm;
			
		/*	var calfields = f_query_add_mod.f_tpn_regimen_details.document.TPNRegimenMastConsForm.all_fields.value;
			alert("hidden" + calfields);
			if ( !check_calculation(frmObj,calfields))
			{
				messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num=" + getMessage("PH_TPN_REGIMEN_NUTRIENT_FLUID_QTY");
				return false;
			}*/

		}
		else if(link=="external_db") {
			frmObj	= f_query_add_mod.f_tpn_regimen_details.document.TPNRegimenMastExternalDrug;
		}

	
	/*	if(drug_item_code_ind == "S"){
			var fields	= new Array(formObj.item_code, formObj.short_name, formObj.long_name, formObj.dflt_tpn_route);
			var names	= new Array("Item Code", "Short Name", "Long Name", "TPN Admin Route");
		}else{
			var fields	= new Array(formObj.tpn_regimen_code, formObj.short_name, formObj.long_name, formObj.dflt_tpn_route);
			var names	= new Array("Regimen Code", "Short Name", "Long Name", "TPN Admin Route");
		}

		This code is commented as the short name is removed from the screen; accordingly the mandatory check is done in the following code  --- srijagadeesh on 09/12/2004
	*/
	
		var drug_item_code_ind = formObj.drug_item_code_ind.value;
		if(drug_item_code_ind == "S"){
			var fields	= new Array(formObj.item_code, formObj.long_name, formObj.dflt_tpn_route);
			var names	= new Array(getLabel("Common.ItemCode.label","Common"),getLabel("Common.longname.label","Common"), getLabel("ePH.TPNAdminRoute.label","PH"));
		}else{
			var fields	= new Array(formObj.tpn_regimen_code, formObj.long_name, formObj.dflt_tpn_route);
			var names	= new Array(getLabel("Common.RegimenCode.label","Common"), getLabel("Common.longname.label","Common"), getLabel("ePH.TPNAdminRoute.label","PH"));
		}
	
		if(checkFieldsofMst(fields, names, messageFrame)) {
			if(frmObj!="")
				storeValues(frmObj,link);

//			alert(formApply(formObj,PH_CONTROLLER)); 
			eval(formApply(formObj,PH_CONTROLLER));

			messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ message;

	
			if(result)
				onSuccess();
		}
		else {
			return false;
		}
	}	
//}

async function onSuccess() {

	var or_yn			= f_query_add_mod.f_tpn_regimen_add_modify.TPNRegimenMastForm.or_yn.value;
	var mode			= f_query_add_mod.f_tpn_regimen_add_modify.TPNRegimenMastForm.mode.value;
	var or_status		= f_query_add_mod.f_tpn_regimen_add_modify.TPNRegimenMastForm.or_status.value;



	if(or_yn=="Y") {
		var chk = false;
		if(mode==MODE_MODIFY && or_status=='true') {
			chk	= confirm(getMessage("MODIFY_ORDER_INFO","PH"));
			mode = MODE_MODIFY;
		}
		else {
			chk = confirm(getMessage("SETUP_ORDER_INFO","PH"));
			mode = MODE_INSERT;
		}

		if(chk) {
		/*	var drug_code		= f_query_add_mod.f_tpn_regimen_add_modify.TPNRegimenMastForm.tpn_regimen_code.value;
			var drug_desc		= f_query_add_mod.f_tpn_regimen_add_modify.TPNRegimenMastForm.long_name.value;
			var short_desc		=  drug_desc.substring(0,40);
			//escape(f_query_add_mod.f_tpn_regimen_add_modify.TPNRegimenMastForm.short_name.value);
			var schedule_id		= f_query_add_mod.f_tpn_regimen_add_modify.TPNRegimenMastForm.schedule_id.value;
			var base_unit_code	= f_query_add_mod.f_tpn_regimen_add_modify.TPNRegimenMastForm.pres_base_uom.value;
			var base_unit_desc	= f_query_add_mod.f_tpn_regimen_add_modify.TPNRegimenMastForm.pres_base_uom_desc.value;
			var drug_class		= "";
			var drug_cat_code	= "";
			var refill_yn		= "N";

			var sql_order_type	= escape("SELECT A.ORDER_TYPE_CODE code,B.SHORT_DESC short_desc FROM PH_ORDER_TYPE_FOR_DRUG_CLASS A,OR_ORDER_TYPE B WHERE A.ORDER_TYPE_CODE=B.ORDER_TYPE_CODE AND B.EFF_STATUS='E' AND A.DRUG_CLASS='G' ORDER BY 2")
			var sql_setting		= escape("SELECT A.DRUG_CATG_CODE,A.PATIENT_CLASS,A.MAX_DURN_VALUE,A.MAX_DURN_TYPE ,A.ACTION chk_for_max_durn_action,A.ORD_AUTH_LEVEL,A.PROMPT_MSG FROM PH_DRUG_CATG_RULE_BY_PATCL A WHERE A.DRUG_CATG_CODE='"+drug_cat_code+"'");
			var sql_auth_level	= escape("SELECT A.ORDER_AUTH_LEVEL ord_auth_level,A.ORDER_COSIGN_LEVEL ord_cosign_level,A.SPL_APPR_LEVEL ord_spl_appr_level,A.DISP_AUTH_REQD_YN result_auth_reqd_yn,A.REPEAT_SINGLE_CONT_ORDER_YN FROM PH_DRUG_SCHEDULE A WHERE SCHEDULE_ID='"+schedule_id+"' AND EFF_STATUS='E'");


			var dialogHeight	= "35";
			var dialogWidth		= "50";
			var dialogTop		= "60";
			var center			= "1";
			var status			= "no";
			var features		= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; center: " + center + ";scroll "+scroll+"; status: " + status + "; dialogTop :" + dialogTop;
			var arguments		= "";

			//var retVal			= window.showModalDialog("../../eOR/jsp/OROrderCatalog.jsp?mode="+mode+"&module_id=PH&order_category=PH&uom_desc="+escape(base_unit_desc)+"&uom_code="+base_unit_code+"&order_catalog_code="+drug_code+"&long_desc="+escape(drug_desc)+"&short_desc="+escape(short_desc)+"&sql_order_type="+sql_order_type+"&sql_setting="+sql_setting+"&sql_auth_level="+sql_auth_level+"&update_refill_cont_order_yn="+refill_yn,arguments,features);

		//	var retVal			=	window.showModalDialog("../../eOR/jsp/OROrderCatalog.jsp?mode="+mode+"&uom_desc="+escape(base_unit_desc)+"&uom_code="+base_unit_code+"&order_catalog_code="+drug_code+"&long_desc="+escape(drug_desc)+"&short_desc="+escape(short_desc)+"&module_id=PH&order_category=PH&sql_order_type="+sql_order_type+"&sql_setting="+sql_setting+"&sql_auth_level="+sql_auth_level+"&update_refill_cont_order_yn="+refill_yn,arguments,features);

		var retVal			=	window.showModalDialog("../../eOR/jsp/OROrderCatalog.jsp?mode="+mode+"&uom_desc="+base_unit_desc+"&uom_code="+base_unit_code+"&order_catalog_code="+drug_code+"&long_desc="+escape(drug_desc)+"&short_desc="+escape(short_desc)+"&module_id=PH&order_category=PH&sql_order_type="+sql_order_type+"&sql_setting="+sql_setting+"&sql_auth_level="+sql_auth_level+"&update_refill_cont_order_yn="+refill_yn,arguments,features);
*/


    var tpn_tab_reg=f_query_add_mod.f_tpn_regimen_add_modify.TPNRegimenMastForm.tpn_tab_reg.value;
	var drug_code		= f_query_add_mod.f_tpn_regimen_add_modify.TPNRegimenMastForm.tpn_regimen_code.value;
			var drug_desc		= f_query_add_mod.f_tpn_regimen_add_modify.TPNRegimenMastForm.long_name.value;
			var short_desc		=  drug_desc.substring(0,40);
			//escape(f_query_add_mod.f_tpn_regimen_add_modify.TPNRegimenMastForm.short_name.value);
			var schedule_id		= f_query_add_mod.f_tpn_regimen_add_modify.TPNRegimenMastForm.schedule_id.value;
			var base_unit_code	= f_query_add_mod.f_tpn_regimen_add_modify.TPNRegimenMastForm.pres_base_uom.value;
			var base_unit_desc	= f_query_add_mod.f_tpn_regimen_add_modify.TPNRegimenMastForm.pres_base_uom_desc.value;
			var language_id=f_query_add_mod.f_tpn_regimen_add_modify.TPNRegimenMastForm.language_id.value;
//			var drug_class		= "G";
			var drug_cat_code	= "";
			var refill_yn		= "N";

//			var sql_order_type	= escape("SELECT A.ORDER_TYPE_CODE code,B.SHORT_DESC short_desc FROM PH_ORDER_TYPE_FOR_DRUG_CLASS A,OR_ORDER_TYPE_LANG_VW B WHERE A.ORDER_TYPE_CODE=B.ORDER_TYPE_CODE AND B.EFF_STATUS='E' AND A.DRUG_CLASS='G' AND B.LANGUAGE_ID='"+language_id+"'  ORDER BY 2")

//	var sql_order_type	= escape("SQL_PH_TPN_REGIMEN_MAST_SELECT13'"+language_id+"'ORDER BY 2");

// 			var sql_setting		= escape("SELECT A.DRUG_CATG_CODE,A.PATIENT_CLASS,A.MAX_DURN_VALUE,A.MAX_DURN_TYPE ,A.ACTION chk_for_max_durn_action,A.ORD_AUTH_LEVEL,A.PROMPT_MSG FROM PH_DRG_CTG_RLE_BY_PTCL_LANG_VW A WHERE A.LANGUAGE_ID='"+language_id+"' AND A.DRUG_CATG_CODE='"+drug_cat_code+"'");
 			
	var sql_setting		= "";
		//escape("SQL_PH_TPN_REGIMEN_MAST_SELECT14'"+language_id+"' AND A.DRUG_CATG_CODE='"+drug_cat_code+"'");

//			var sql_auth_level	= escape("SELECT A.ORDER_AUTH_LEVEL ord_auth_level,A.ORDER_COSIGN_LEVEL ord_cosign_level,A.SPL_APPR_LEVEL ord_spl_appr_level,A.DISP_AUTH_REQD_YN result_auth_reqd_yn,A.REPEAT_SINGLE_CONT_ORDER_YN FROM PH_DRUG_SCHEDULE A WHERE SCHEDULE_ID='"+schedule_id+"' AND EFF_STATUS='E'");

		var sql_auth_level	= schedule_id;
			//escape("SQL_PH_TPN_REGIMEN_MAST_SELECT15'"+schedule_id+"' AND EFF_STATUS='E'");


			var dialogHeight	= "580px";
			var dialogWidth		= "980px";
			var dialogTop		= "60";
			var center			= "1";
			var status			= "no";
			var features		= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; center: " + center + ";scroll "+scroll+"; status: " + status + "; dialogTop :" + dialogTop;
			var arguments		= "";
			var iv_prep_yn="TPN";//added for ml-mmoh-crf-1290
			var retVal	="";//added for ml-mmoh-crf-1290
			
			
			//var retVal			= window.showModalDialog("../../eOR/jsp/OROrderCatalog.jsp?mode="+mode+"&module_id=PH&order_category=PH&uom_desc="+escape(base_unit_desc)+"&uom_code="+base_unit_code+"&order_catalog_code="+drug_code+"&long_desc="+escape(drug_desc)+"&short_desc="+escape(short_desc)+"&sql_order_type="+sql_order_type+"&sql_setting="+sql_setting+"&sql_auth_level="+sql_auth_level+"&update_refill_cont_order_yn="+refill_yn,arguments,features);

		//	var retVal			=	window.showModalDialog("../../eOR/jsp/OROrderCatalog.jsp?mode="+mode+"&uom_desc="+escape(base_unit_desc)+"&uom_code="+base_unit_code+"&order_catalog_code="+drug_code+"&long_desc="+escape(drug_desc)+"&short_desc="+escape(short_desc)+"&module_id=PH&order_category=PH&sql_order_type="+sql_order_type+"&sql_setting="+sql_setting+"&sql_auth_level="+sql_auth_level+"&update_refill_cont_order_yn="+refill_yn,arguments,features);
//if condtion added  ml-mmoh-crf-1290
			if(tpn_tab_reg=="true"){
				
				 retVal			=	await window.showModalDialog("../../eOR/jsp/OROrderCatalog.jsp?mode="+mode+"&uom_desc="+base_unit_desc+"&uom_code="+base_unit_code+"&order_catalog_code="+drug_code+"&long_desc="+escape(drug_desc)+"&short_desc="+escape(short_desc)+"&module_id=PH&order_category=PH&sql_order_type=G&sql_setting=&sql_auth_level="+sql_auth_level+"&update_refill_cont_order_yn="+refill_yn+"&tpn_item_yn="+iv_prep_yn,arguments,features);
			}
			else{
				 retVal			=	await window.showModalDialog("../../eOR/jsp/OROrderCatalog.jsp?mode="+mode+"&uom_desc="+base_unit_desc+"&uom_code="+base_unit_code+"&order_catalog_code="+drug_code+"&long_desc="+escape(drug_desc)+"&short_desc="+escape(short_desc)+"&module_id=PH&order_category=PH&sql_order_type=G&sql_setting=&sql_auth_level="+sql_auth_level+"&update_refill_cont_order_yn="+refill_yn,arguments,features);
			}

		}
	}

	messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ message;
	create();

}

function setScheduleID(objValue) {
	parent.f_tpn_regimen_add_modify.document.TPNRegimenMastForm.schedule_id.value = objValue;
}

function assignResult( _result, _message, _flag ) {
	result	= _result;
	message	= _message;
	flag	= _flag;
} 

function reset() {
	if (checkIsValidForProceed("tpnregimenmastquerycriteria")) {
		f_query_add_mod.document.query_form.reset();
	}
	else if (checkIsValidForProceed("tpnregimenmastframes")) {
		if(f_query_add_mod.f_tpn_regimen_add_modify.document.TPNRegimenMastForm.mode.value == MODE_INSERT) {
			create();
		}
		else {
			var tpn_regimen_code = f_query_add_mod.f_tpn_regimen_add_modify.document.TPNRegimenMastForm.tpn_regimen_code.value;
			f_query_add_mod.location.href="../../ePH/jsp/TPNRegimenMastFrames.jsp?&mode="+MODE_MODIFY+"&tpn_regimen_code="+tpn_regimen_code;
		}
	}
}
 
function assignValue(obj) {

	if(obj.checked==true)
		obj.value="Y";
	else
		obj.value="N";
}

// @
function chkValue(){
	var frmObj		= parent.f_tpn_regimen_add_modify.document.TPNRegimenMastForm;
	var mode = frmObj.mode.value;
//	alert(frmObj.tpn_regimen_code.value);
if (mode==1)
	{
if(frmObj.standard_regimen_yn.value=="Y") {
	document.getElementById("pedReg").style.visibility="hidden";
	document.getElementById("overegVol").style.visibility="hidden";
	}

if(frmObj.standard_regimen_yn.value=="N"){
	document.getElementById("pedReg").style.visibility="visible";
	document.getElementById("overegVol").style.visibility="visible";
	document.getElementById("itmCode").style.visibility="hidden";
	document.getElementById("Constituents_tab").style.visibility="hidden";
	document.getElementById("OrderingDispensingRules_tab").style.visibility="hidden";
	frmObj.item_code_man.style.visibility	= "hidden";	 
	}
}

if(mode==2)
	{
	var infusionline	= frmObj.dflt_tpn_route.value
	frmObj.standard_regimen_yn.disabled=true;
//alert(frmObj.dflt_tpn_route.value);
	if (infusionline =="C")
	{
	frmObj.dflt_tpn_route.disabled=true;
	}

if (frmObj.standard_regimen_yn.value=="Y")
	 {
	 document.getElementById("pedReg").style.visibility="hidden";
	 document.getElementById("overegVol").style.visibility="hidden";
	 }

//if(frmObj.standard_regimen_yn.value=="N" || frmObj.tpn_regimen_code.value=="NON_STANDARD")
else
	{
/*
	document.getElementById("itmCode").style.visibility="hidden";
	document.getElementById("constunts").style.visibility="hidden";
	document.getElementById("orderDsp").style.visibility="hidden";
	frmObj.item_code_man.style.visibility	= "hidden";	 
*/
	frmObj.drug_item_code_ind.value='X'; 	 
	}
	}	
} 

function enableValue(obj){
	var frmObj		= parent.f_tpn_regimen_add_modify.document.TPNRegimenMastForm;
	var regmncde = frmObj.tpn_regimen_code.value;
	var mode = frmObj.mode.value;

if (mode==1)
{
	if(obj.checked==true){
	frmObj.tpn_regimen_code.disabled	= true;	
	document.getElementById("pedReg").style.visibility="hidden";
	document.getElementById("overegVol").style.visibility="hidden";
	document.getElementById("itmCode").style.visibility="visible";
	document.getElementById("Constituents_tab").style.visibility="visible";
	document.getElementById("OrderingDispensingRules_tab").style.visibility="visible";
	frmObj.item_code_man.style.visibility	= "visible";	 
	frmObj.standard_regimen_yn.value='Y';
	frmObj.single_emulsion.checked=false;
	frmObj.single_emulsion.disabled=false;
//	frmObj.drug_item_code_ind.value='Y';
//	frmObj.standard_regimen_yn.value='Y';
	}
	else{
	frmObj.tpn_regimen_code.disabled	= false;	
	document.getElementById("pedReg").style.visibility="visible";
	document.getElementById("overegVol").style.visibility="visible";
	document.getElementById("itmCode").style.visibility="hidden";
	document.getElementById("Constituents_tab").style.visibility="hidden";
	document.getElementById("OrderingDispensingRules_tab").style.visibility="hidden";
	frmObj.item_code_man.style.visibility	= "hidden";
	frmObj.drug_item_code_ind.value='X';
	frmObj.single_emulsion.checked=true;
	frmObj.single_emulsion.value='Y';
	frmObj.single_emulsion.disabled=true;
	frmObj.standard_regimen_yn.value='N';
	}
}
}


function showTabDetail(obj) {
	
	var frmObj		= parent.f_tpn_regimen_add_modify.document.TPNRegimenMastForm;

	if(frmObj.std_result.value=="N") {
		alert(getMessage("PH_TPN_STANDARD_REGIMEN_NOT_APPLICABLE","PH"));
		return;
	}
	var errorPage	= "../../eCommon/jsp/MstCodeError.jsp" ;
	var blankObj 	= null ;
/*
	var fields	= new Array (frmObj.tpn_regimen_code, frmObj.long_name, frmObj.short_name, frmObj.dflt_tpn_route);
	var names	= new Array ("Regimen Code", "Long Name", "Short Name", "TPN Admin Route");

	This code is commented as the short name is removed from the screen; accordingly the mandatory check is done in the following code  --- srijagadeesh on 09/12/2004
*/

	var fields	= new Array (frmObj.tpn_regimen_code, frmObj.long_name, frmObj.dflt_tpn_route);
	var names	= new Array (getLabel("Common.RegimenCode.label","Common"), getLabel("Common.longname.label","Common"), getLabel("ePH.TPNAdminRoute.label","PH"));

	var drug_item_code_ind = frmObj.drug_item_code_ind.value;
	if(drug_item_code_ind == "S"){
		var fields	= new Array(frmObj.item_code, frmObj.long_name, frmObj.dflt_tpn_route);
		var names	= new Array(getLabel("Common.ItemCode.label","Common"), getLabel("Common.longname.label","Common"), getLabel("ePH.TPNAdminRoute.label","PH"));
	}else{
		var fields	= new Array(frmObj.tpn_regimen_code, frmObj.long_name, frmObj.dflt_tpn_route);
		var names	= new Array(getLabel("Common.RegimenCode.label","Common"),getLabel("Common.longname.label","Common"), getLabel("ePH.TPNAdminRoute.label","PH"));
	}
	blankObject  = checkFieldsofMst(fields, names, parent.parent.messageFrame, errorPage) ;
	
	if(blankObject==true) {
		parent.parent.messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num=";
		var link		= obj;

//		alert("link...."+link);
		var prev_tab	= frmObj.curr_tab.value;
		var single_emul	= frmObj.single_emulsion.value;

		frmObj.tpn_regimen_code.disabled	= true;
		frmObj.long_name.disabled			= true;
//		frmObj.short_name.disabled			= true;
		frmObj.dflt_tpn_route.disabled		= true;
		frmObj.single_emulsion.disabled		= true;
		frmObj.item_code.disabled			= true;
		frmObj.item_code_lkup.disabled		= true;

		if(link=="Constituents_tab") {
			parent.f_tpn_regimen_details.location.href="../../ePH/jsp/TPNRegimenMastConstituents.jsp?single_emul="+single_emul;
		//	obj.src="../../ePH/images/Constituents_click.gif";
		//	parent.f_tpn_regimen_add_modify.document.getElementById("ordering_dispensing").src	="../../ePH/images/OrderingDispensingRules.gif";
//			parent.f_tpn_regimen_add_modify.document.getElementById("external_db").src	="../../ePH/images/ExternalLink.gif";
			frmObj.curr_tab.value = link;
		}
		else if(link=="OrderingDispensingRules_tab")	{
			parent.f_tpn_regimen_details.location.href="../../ePH/jsp/TPNRegimenMastOrdDispRules.jsp";
		//	obj.src="../../ePH/images/OrderingDispensingRules_click.gif";
		//	parent.f_tpn_regimen_add_modify.document.getElementById("constituents").src="../../ePH/images/Constituents.gif";
//			parent.f_tpn_regimen_add_modify.document.getElementById("external_db").src	="../../ePH/images/ExternalLink.gif";
			frmObj.curr_tab.value = link;
		}
		else if(link=="external_db")	{
/*			parent.f_tpn_regimen_details.location.href="../../ePH/jsp/TPNRegimenMastExternalDrug.jsp";
			obj.src="../../ePH/images/ExternalLink_click.gif";
			parent.f_tpn_regimen_add_modify.document.getElementById("constituents").src="../../ePH/images/Constituents.gif";
			parent.f_tpn_regimen_add_modify.document.getElementById("ordering_dispensing").src	="../../ePH/images/OrderingDispensingRules.gif";
			frmObj.curr_tab.value = link;
*/
		}

		if(prev_tab=="OrderingDispensingRules_tab") {
			frmObj = parent.f_tpn_regimen_details.document.TPNRegimenMastOrdDispForm;
		}
		else if(prev_tab=="Constituents_tab") {
			frmObj = parent.f_tpn_regimen_details.document.TPNRegimenMastConsForm;
		}
		else if(prev_tab=="external_db") {
	//		frmObj = parent.f_tpn_regimen_details.document.TPNRegimenMastExternalDrug;
		}

		if (prev_tab!="" && link!=prev_tab)
			storeValues(frmObj, prev_tab);
	}
	/*else {
		blankObject.focus() ;
	}*/

}

function storeValues(frmObj, link) {
	//alert('frmObj in storeValues :'+frmObj);
	var xmlDoc="";
    var xmlHttp = new XMLHttpRequest();
    var arrObj = frmObj.elements;

    var frmObjs = new Array();
    if(frmObj.name == null)
        frmObjs = frmObj ;
    else frmObjs[0] = frmObj;

    var xmlStr = "<root><SEARCH ";

    for(var frmCount=0; frmCount<frmObjs.length; frmCount++) {
        frmObj = frmObjs[frmCount];
        var arrObj = frmObj.elements;

        for(var i=0;i<arrObj.length;i++) {
            var val = "" ;
            if(arrObj[i].type == "checkbox") {
                if(arrObj[i].checked)
                    val = arrObj[i].value;
                if(arrObj[i].name != null && arrObj[i].name != "")
                    xmlStr+= arrObj[i].name+"=\"" + checkSpl(val) + "\" " ;
            }
            else if(arrObj[i].type == "radio") {
                if(arrObj[i].checked) {
                    val = arrObj[i].value;
                    if(arrObj[i].name != null && arrObj[i].name != "")
                        xmlStr+= arrObj[i].name+"=\"" + checkSpl(val) + "\" " ;
                }
            }
            else if(arrObj[i].type == "select-multiple" ) {
                for(var j=0; j<arrObj[i].options.length; j++)
                {
                    if(arrObj[i].options[j].selected)
                        val+=arrObj[i].options[j].value +"~"
                }
                val= val.substring(0,val.lastIndexOf('~'))
                if(arrObj[i].name != null && arrObj[i].name != "")
                    xmlStr+= arrObj[i].name+"=\"" + checkSpl(val) + "\" " ;

            }
            else {
                val = arrObj[i].value;
				if(arrObj[i].name != null && arrObj[i].name != "")
                    xmlStr+= arrObj[i].name+"=\"" + checkSpl(val) + "\" " ;
            }
        }
    }
	xmlStr +=" /></root>";
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	//alert(xmlStr);
	xmlHttp.open("POST", "TPNRegimenMastValidate.jsp?func_mode="+link, false);
	xmlHttp.send(xmlDoc);
	responseText = xmlHttp.responseText;
	//alert(responseText);
}

async function searchItem(obj) {
	var argumentArray  = new Array();
	var dataNameArray  = new Array();
	var dataValueArray = new Array();
	var dataTypeArray  = new Array();
	
	formObj				=	document.TPNRegimenMastForm;
	dataNameArray[0] = "locale";
	dataValueArray[0]= document.TPNRegimenMastForm.locale.value;
	dataTypeArray[0] = STRING;
	var sql="SELECT A.ITEM_CODE code,B.LONG_DESC description FROM ST_ITEM A,MM_ITEM_LANG_VW B WHERE   A.DRUG_ITEM_YN='Y'  AND B.LANGUAGE_ID like ? AND B.ITEM_CODE=A.ITEM_CODE AND A.ITEM_CODE LIKE UPPER(?) AND upper(B.LONG_DESC) LIKE upper(?) AND A.ITEM_CODE NOT IN(SELECT INVENTORY_ITEM_CODE FROM PH_INVENTORY_ITEM_FOR_DRUG) order by 2";

	
    argumentArray[0]   = sql;
	argumentArray[1]   = dataNameArray ;
	argumentArray[2]   = dataValueArray ;
	argumentArray[3]   = dataTypeArray ;
	argumentArray[4]   = "2,3";
	argumentArray[5]   = document.TPNRegimenMastForm.item_code.value ;
	argumentArray[6]   = DESC_LINK ;
	argumentArray[7]   = DESC_CODE ;
	bean_id				=	formObj.bean_id.value;
	bean_name			=	formObj.bean_name.value;

	retVal = await CommonLookup(getLabel("Common.ItemName.label","Common"), argumentArray);
	
    var ret1=unescape(retVal);
	var arr=ret1.split(",");
	if(retVal != null && retVal != "") {
		itemDesc	=	arr[1];
		var xmlStr ="<root><SEARCH ";
		xmlStr+= "bean_id =\"" + bean_id + "\" " ;
		xmlStr+= "bean_name=\"" + bean_name + "\" " ;
		xmlStr+= "base_unit=\"" + formObj.pres_base_uom.value + "\" " ;	
		xmlStr+= "item_code=\"" + arr[0] + "\" " ;
		xmlStr+= "item_desc=\"" + escape(arr[1]) + "\" " ;
		xmlStr +=" /></root>";
		var temp_jsp="TPNRegimenMastValidate.jsp?func_mode=item_search";
		var xmlDoc = "" ;
		var xmlHttp = new XMLHttpRequest() ;
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		//alert('xml str :'+xmlStr);
		xmlHttp.open("POST",temp_jsp,false);
		xmlHttp.send(xmlDoc);
		responseText=xmlHttp.responseText ;
		//alert(responseText);
		eval(responseText);

	}
}

function defaultPerc(code,allcode,fluidname,obj) { // obj Added for ML-MMOH-CRF-1266 [IN:068728]
	//alert('defaultPerc '+allcode);
	var names = allcode.split("~");
    var sumval = 0;
	var flag ;
	var frmobj = "document.TPNRegimenMastConsForm.";
    totval=eval("document.TPNRegimenMastConsForm."+fluidname+".value");
	if (totval != "")
	{
	for (i=2;i<names.length ;i++ )
    {
		//alert(names[i]);
		if(eval(frmobj + names[i] + "_vol").value == "" || eval(frmobj + names[i] + "_perc").value == "")
			flag=false;
				
		temp=eval("document.TPNRegimenMastConsForm."+names[i]+"_vol").value;
		if(temp != "")
			sumval = parseFloat(sumval)+ parseFloat(temp);

    }
/*	
	if(flag != false && sumval > totval){
		eval("document.TPNRegimenMastConsForm."+fluidname).focus();
		alert('1');
			alert(getMessage("PH_TPN_REGIMEN_MACRO_NUTRIENT"));
			return false;
	}
	if(flag == false && sumval > totval){
			eval("document.TPNRegimenMastConsForm."+fluidname).focus();
			alert(getMessage("PH_TPN_REGIMEN_MACRO_NUTRIENT"));
			return false;
		}
*/
	perc	= eval("document.TPNRegimenMastConsForm."+code+"_perc.value");
	vol		= eval("document.TPNRegimenMastConsForm."+code+"_vol.value");
  if(obj!=undefined){ // Added for ML-MMOH-CRF-1266 [IN:068728] - Start
	if(perc<=100){  
		var temp1 = 0;
	   if(obj.value!='' && sumval!='' && vol!=''){
		  if(parseInt(vol)>0)
		   temp1=(obj.value/vol)*100;
		  else
		   temp1=0;
	   }
	   if(temp1<=100){
		eval("document.TPNRegimenMastConsForm."+code+"_perc").value = temp1;
		defaultPerc(code,allcode,fluidname);
		totalEnergy(allcode);
		npcRatio(allcode);
	   }
	   else{
		   alert(getMessage("PERCENTAGE_CAN_NOT_BE_GREATER_THAN_100","PH"));	
		   obj.focus();
		   return false;
	   }	
	}
	else{
		alert(getMessage("PERCENTAGE_CAN_NOT_BE_GREATER_THAN_100","PH"));	
		obj.focus();
		return false;
		} 
  } // Added for ML-MMOH-CRF-1266 [IN:068728] - End
	eval("document.TPNRegimenMastConsForm."+code+".value=''");
	document.getElementById(code+"_label").innerText='';
	document.getElementById(code+"_unit_label").innerText='';

	if(perc!="" && vol!="") {
//		alert('perc and vol');
//		weight	= parseInt(perc)*parseInt(vol) / 100;
		weight 	= (perc*vol / 100)+"";
//	alert("weight bfr :"+weight);	
		if(weight.indexOf(".") != -1){
		var ind	=	weight.lastIndexOf(".",weight.length);
			if( weight.length > ind+3)
				weight	=	weight.substring(0,ind+3);
			
		}else{
			weight +="   ";
		}
//		alert("weight aftr :"+weight);
		//weight = Math.round(weight);
		//weight = st.substring(0,st.indexOf(".")+3);
		
		unit	= eval("document.TPNRegimenMastConsForm."+code+"_unit.value");
		eval("document.TPNRegimenMastConsForm."+code+".value="+weight);
		document.getElementById(code+"_label").innerText=weight;
		document.getElementById(code+"_unit_label").innerText=unit";
	}
	}
	else
	{
		eval("document.TPNRegimenMastConsForm."+fluidname+".focus()");
		alert(getMessage("PH_TPN_REGIMEN_NUTRIENT_FLUID_QTY","PH"));
		//alert("Fluid volume cannot be blank");
		return;
	}

}

async function callExternalDBSearch(generic_id,generic_name) {
	var dialogHeight	= "25";
	var dialogWidth		= "40";
	var dialogTop		= "60";
	var center			= "1";
	var status			= "no";
	var features		= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; center: " + center + ";scroll "+scroll+"; status: " + status + "; dialogTop :" + dialogTop;
	var arguments		= "";

    var retVal = await window.showModalDialog("../../ePH/jsp/DrugMasterExternalDrugSearchFrames.jsp?generic_id="+generic_id+"&generic_name="+generic_name, arguments, features);
	if(retVal != undefined) {
		document.TPNRegimenMastExternalDrug.external_drug_id.value		= retVal;
		document.TPNRegimenMastExternalDrug.external_drug_name.value	= retVal;
	}
}

function Modify(obj) {
	var tpn_regimen_code = obj.cells[0].innerText;
	document.location.href="../../ePH/jsp/TPNRegimenMastFrames.jsp?&mode="+MODE_MODIFY+"&tpn_regimen_code="+tpn_regimen_code;
}

function checkIsNotZero(obj, appendObj) {
	if (obj.value == "0") {
		InfuseObj.focus();
		alert(getMessage("ZERO_NOT_ALLOWED","PH") + appendObj);
		return true;
	}
	else if (eval(obj.value) > 24 && document.TPNRegimenMastOrdDispForm.infuse_over_list.value == "H")
	{
		alert(getMessage("INFUSEOVER_LESSTHAN","PH") + "24"+getLabel("Common.hours.label","Common"));
		InfuseObj.focus();
		return;
	}
	else if (eval(obj.value) > 60 && document.TPNRegimenMastOrdDispForm.infuse_over_list.value == "M")
	{
		alert(getMessage("INFUSEOVER_LESSTHAN","PH") + "60"+getLabel("Common.Minutes.label","Common"));
		InfuseObj.focus();
		return;
	}
	else {
		checkSplChars(obj);
	}
    
   

}

function final_check(obj,emulsion)
{
	//alert('final_check');

	frmObj = eval("document.TPNRegimenMastConsForm");
	if(obj.value == 0  || obj.value =="")
	{
				obj.focus();
				alert(getMessage("PH_TPN_REGIMEN_NUTRIENT_FLUID_QTY","PH"));
				return false;
	}
	var all_fields="";
	var all_fields1="";
	var all_fields2="";
	 var arrObj = frmObj.elements;
	 for(var i=0;i<arrObj.length;i++) {
			var val = "" ;
            if(arrObj[i].type == "text") {
				var str1 = arrObj[i].name;
				var s = str1.lastIndexOf("des_");
				var s1 = str1.lastIndexOf("_vol");
				if(s != -1){
					all_fields = all_fields + "~" + str1.substr(4);
					all_fields1 = all_fields1 + "~" + str1;
				}
				if(s1 != -1){
					all_fields2 = all_fields2 + "~" + str1.substr(0,str1.length-4);
				}
				
			}
	 }//for

	
    var emul = emulsion;
//	var tot=0;
//alert(emul);
	if (emul == "Y" || emul == "y"){
		objs=all_fields1.split("~");
		valname=all_fields.split("~");
	//	alert(objs.length);
		for (i=1;i< (objs.length) ;i++ ){

	//			tot = eval(tot) + Calc_Value(eval("document.TPNRegimenMastConsForm." + objs[i]),valname[i],obj.name) ;
				if(!Calc_Value(eval("document.TPNRegimenMastConsForm." + objs[i]),valname[i],obj.name,obj.name + "~" +all_fields))
					break;
			}
		
	}
	
	else{
		valname = all_fields2.split("~");
		for (j=1;j< (valname.length) ;j++ ){
				if(!defaultPerc(valname[j],obj.name+"~"+all_fields2,obj.name) )
					break;
				return;
			}
	}

}//function



function Calc_Percentage(obj,x,tot,all_fields) {	
	//alert('Calc_Percentage');
		if(eval(x) != 0 && eval("document.TPNRegimenMastConsForm.des_"+obj.name) != null){
	    if(isNaN(eval("document.TPNRegimenMastConsForm." + tot).value) || eval("document.TPNRegimenMastConsForm." + tot).value == 0){
		eval("document.TPNRegimenMastConsForm." + tot).focus();
	//	alert(getMessage("PH_TPN_REGIMEN_NUTRIENT_FLUID_QTY"));
		return;
   }
   else{
	   	temp=eval("document.TPNRegimenMastConsForm.des_"+obj.name);
		if (temp == null)
		{
			return;
		}
	temp.value="";
	   if(isNaN(obj.value)) {
		   alert(getMessage("ONLY_NUMERIC_ALLOWED","PH"));
		  // alert("Enter a Numeric value");
		   obj.focus();
	   }
	   else{
			if(obj.value != "" )	{
	  		objval = eval(obj.value);
			totval = eval("document.TPNRegimenMastConsForm." + tot).value;
			//totval=1000;
			cal_val =((objval * 100)/totval)+"";
			
			//alert('cal_val :'+cal_val);
			
			if(cal_val.indexOf(".") != -1){
			var ind	=	cal_val.lastIndexOf(".",cal_val.length);
			if( cal_val.length > ind+3)
				cal_val	=	cal_val.substring(0,ind+3);
				//alert('rd val :'+cal_val);
			}

			temp.value = cal_val;
	//			temp.value = Math.round(cal_val);
			check_tot_greater(all_fields);
		}
	   }
     }//else
   }

}

function Calc_Value(obj,valname,tot,all_fields) {
//	alert("Calc_Value");
if(isNaN(eval("document.TPNRegimenMastConsForm." + tot).value) || eval("document.TPNRegimenMastConsForm." + tot).value == 0){
//	   alert ("Enter the Fluid Quantity");
   }
   else{
	temp=eval("document.TPNRegimenMastConsForm."+ valname);
	temp.value="";
	 if(isNaN(obj.value)){
//		   alert("Enter a Numeric value");
		   obj.focus();
	   }
	   else{
			if(obj.value != "" ){
				objval = eval(obj.value);
				totval = eval("document.TPNRegimenMastConsForm."+tot).value;
				cal_val = (objval * totval)/100;
				temp.value = cal_val;
				//alert('cal val'+cal_val);
				temp.value = roundTwoDigits(cal_val);
				//return(check_tot_greater(all_fields));
				if (!check_tot_greater(all_fields))
				{
					obj.focus();
					
					alert(getMessage("PH_TPN_REGIMEN_MACRO_NUTRIENT","PH"));
					return false;
				}
				return true;
			}
	   }
   } 
}
function check_tot_greater(all_fields)
{
	var names = all_fields.split("~");
	var sumval=0;
	fluidname = names[1];
	for (i=2;i<names.length ;i++ )
	{
		temp=eval("document.TPNRegimenMastConsForm.des_"+names[i]).value;
		if(temp != "")
			sumval = parseFloat(sumval)+ parseFloat(temp);
	}
//		   alert(sumval);
   			if(sumval > 100)
			{
//				eval("document.TPNRegimenMastConsForm."+names[2]).focus();
				return false;
			}
return true;
}
function checkSplChars(obj, mode)	{
	if(!CheckChars(obj)) {
		obj.select();
		alert(getMessage("SPECIAL_CHARCTERS_NOT_ALLOWED","PH"));
		return true;
	}
	else {
		if (mode == undefined)
			validNumber(obj);
	}
}

function CheckNum(obj)
{
	if(isNaN(obj.value))
	{
		return false;
	}
	return true;
}
function validNumber(obj) {
	//alert('validNumber');
	if (obj.value != "") {
		if(!CheckNum(obj))
		{
			alert(getMessage("ENTER_VALID_NUMBER","PH"));
			//alert("Enter a Valid number");
			obj.focus();
		}
	}
}

function checkIsValidForProceed( urlName ) {
	var url = f_query_add_mod.location.href;
	url = url.toLowerCase();

	if ( (url.indexOf( urlName ) != -1) )
		return true;
	else
		return false;
}

function invalidItemMessage() {
	alert(getMessage("PH_NO_EQUVL","PH"));
	document.TPNRegimenMastForm.item_code.value = "";
	document.TPNRegimenMastForm.item_code.focus();
}

function setItemCode(item_code,item_desc) {
	document.TPNRegimenMastForm.item_code.value=item_code;
	document.TPNRegimenMastForm.tpn_regimen_code.value=item_code;
//	document.TPNRegimenMastForm.long_name.value=escape(item_desc);
	document.TPNRegimenMastForm.long_name.value = itemDesc;
	validateCode(document.TPNRegimenMastForm.item_code);	
}

function totalEnergy(allcode,mode){
		var names = allcode.split("~");
		var total_energy    = 0.0;
			
		
		for (i=2;i<names.length ;i++ )
		{
			if(mode == "2"){
				nut_energy		= eval("document.TPNRegimenMastConsForm."+names[i]+".value");	
			}
			else if(document.TPNRegimenMastConsForm.micro_nut_enterable_yn.value=="true"){ // Added for ML-MMOH-CRF-1266 [IN:068728] - Start
				nut_energy		= document.getElementById(names[i]+"_label").value;
			} // Added for ML-MMOH-CRF-1266 [IN:068728] - End
			else{
				nut_energy		= document.getElementById(names[i]+"_label").innerText;
			}
			//if(nut_energy == "") nut_energy = "2";
			ener_rel_value	= eval("document.TPNRegimenMastConsForm."+names[i]+"_rel_value.value");
				
			total_energy = total_energy+(nut_energy*ener_rel_value);
		}
		
		total_energy = Math.round(total_energy);
		document.getElementById('total_energy').innerText=total_energy;
		document.TPNRegimenMastConsForm.ttl_energy.value=total_energy;

		//npcRatio(allcode,mode)
}

function defaultFluidBalance(code,allcode,mode){
	//alert('defaultFluidBalance');
	//alert('code :'+code+'allcode :'+allcode+'mode  :'+mode);
	var names = allcode.split("~");
	var sumval = 0;
	var next = "";
	//alert('names :'+names+'length :'+names.length);
	for(i=0;i<names.length; i++){
		//alert('dan :'+names[i+1]);
		if(names[i] == code && i != names.length - 1) 
		{ next = names[i+1];}
	}
	
	for (i=2;i<names.length ;i++ )
    {
		if(mode == "2"){
			temp=eval("document.TPNRegimenMastConsForm."+names[i]).value;
		}else {
			temp=eval("document.TPNRegimenMastConsForm."+names[i]+"_vol").value;
		}
		if(temp != "")
			sumval = parseFloat(sumval)+ parseFloat(temp);
	
    }
	
	if( sumval > totval){
		if(mode == "2"){
			var a=eval("document.TPNRegimenMastConsForm."+code).value;
			eval("document.TPNRegimenMastConsForm."+code).value=a-(sumval-totval);
			eval("document.TPNRegimenMastConsForm."+code).focus();
		}else {
			var a=eval("document.TPNRegimenMastConsForm."+code+"_vol").value;
			eval("document.TPNRegimenMastConsForm."+code+"_vol").value=a-(sumval-totval);
			eval("document.TPNRegimenMastConsForm."+code+"_vol").focus();
		}
		//alert('new ');
			alert(getMessage("PH_TPN_REGIMEN_MACRO_NUTRIENT","PH"));
			return false;
		}else{
			newval = totval - sumval;
			newval = Math.round(newval);
			if(newval == 0) newval = "";
	//		alert('n val :'+newval);
			if(next != ""){
//			alert(eval("document.TPNRegimenMastConsForm."+next+"_vol").name);
			if(mode == "2"){
//				|| eval("document.TPNRegimenMastConsForm."+next).value == 0

				if(eval("document.TPNRegimenMastConsForm."+next).value == "" ){
					eval("document.TPNRegimenMastConsForm."+next).value = newval;
					if(next == "LIPID") document.TPNRegimenMastConsForm.lipid_emulsion_type.disabled=false;
				}
				eval("document.TPNRegimenMastConsForm."+next).focus();
			} else {
//				|| eval("document.TPNRegimenMastConsForm."+next).value == 0
				
				if(eval("document.TPNRegimenMastConsForm."+next+"_vol").value == "" ){
					eval("document.TPNRegimenMastConsForm."+next+"_vol").value = newval;
					if(next == "LIPID") document.TPNRegimenMastConsForm.lipid_emulsion_type.disabled=false;
				}
				eval("document.TPNRegimenMastConsForm."+next+"_vol").focus();
			}
		  }
	
		}

}

// function npcRatio is to calculate the npc ratio
function npcRatio(allcode,mode){
//alert('in npc ratio');	
		var names = allcode.split("~");
		var total_n2_energy    = 0;
		var n2				= 0;
		var npc				= 0;
		var protein_val    = 0;
		var cho_val		= 0;
		var cho_rel_val	= 0;
		var macro_val		= 0; // Added for ML-MMOH-CRF-1266 [IN:068728]
		var macro_rel_val	= 0; // Added for ML-MMOH-CRF-1266 [IN:068728]
		var lipid_val	=0;
		var lipid_rel_val =0;
		var code ="";

		for (i=2;i<names.length ;i++ )
		{
			if(mode == "2"){
				protein_val		= eval("document.TPNRegimenMastConsForm."+names[i]+".value");	
				if(names[i] == "PROTEIN"){
					protein_val		= eval("document.TPNRegimenMastConsForm."+names[i]+".value");	
				}else if(names[i] =="CHO"){
					cho_val			= eval("document.TPNRegimenMastConsForm."+names[i]+".value");
					cho_rel_val		= document.getElementById(names[i]+"_rel_value").value;
				}else if(names[i] =="LIPID"){
					lipid_val		= eval("document.TPNRegimenMastConsForm."+names[i]+".value");
					lipid_rel_val		= document.getElementById(names[i]+"_rel_value").value;
				}
			}
			else if(document.TPNRegimenMastConsForm.micro_nut_enterable_yn.value=="true"){ // Added for ML-MMOH-CRF-1266 [IN:068728] - Start             
				if(names[i] == "PROTEIN"){
					protein_val		= document.getElementById(names[i]+"_label").value;
				}
				else{
					macro_val			= document.getElementById(names[i]+"_label").value;
					macro_rel_val		= document.getElementById(names[i]+"_rel_value").value;
					total_n2_energy = total_n2_energy+(macro_val * macro_rel_val);
				}				 
			} // Added for ML-MMOH-CRF-1266 [IN:068728] - End
			else{				
				if(names[i] == "PROTEIN"){
					protein_val		= document.getElementById(names[i]+"_label").innerText;
				}else if(names[i] =="CHO"){
					cho_val			= document.getElementById(names[i]+"_label").innerText;
					cho_rel_val		= document.getElementById(names[i]+"_rel_value").value;
				}else if(names[i] =="LIPID"){
					lipid_val		= document.getElementById(names[i]+"_label").innerText;
					lipid_rel_val		= document.getElementById(names[i]+"_rel_value").value;
				}
			}
		}	
		
			n2 = protein_val * (16/100);
//			alert('n2 val :'+n2);
			
		 if(document.TPNRegimenMastConsForm.micro_nut_enterable_yn.value=="true"){ // if condition Added for ML-MMOH-CRF-1266 [IN:068728] - Start
			 total_n2_energy = total_n2_energy;
		 } // if condition Added for ML-MMOH-CRF-1266 [IN:068728] - End
		 else
			 total_n2_energy	= (cho_val * cho_rel_val)+(lipid_val * lipid_rel_val);		
//			alert('totl n2 '+total_n2_energy);
			if(n2 != 0)	
				npc = Math.ceil(total_n2_energy/n2);

			document.getElementById("npc_ratio").innerText=npc+" : 1";
			document.TPNRegimenMastConsForm.npc_ratio_val.value=npc;
			
//			var obj = eval("document.getElementById("npc_ratio").innerText");
//alert('lvng npc ratio');		
}

function percent_max(obj,code,test,totval,test){
	if(obj.value > 100){
		alert(getMessage("PERCENTAGE_CAN_NOT_BE_GREATER_THAN_100","PH"));
		//alert('Percentage can not be greater than 100');
		obj.focus();
		return false;
	}else{
		defaultPerc(code,test,totval); 
		totalEnergy(test);
		npcRatio(test);
	}
}

function validateCode(obj)	{
	if(obj.value!="" && obj!=null)	{
		formObj				=	document.TPNRegimenMastForm;

		bean_id				=	formObj.bean_id.value;
		bean_name			=	formObj.bean_name.value;

		//var bean_id		=	drugMasterMain.document.drugMasterMainForm.bean_id.value;
		//var bean_name	=	drugMasterMain.document.drugMasterMainForm.bean_name.value;

		var xmlDoc = "" ;
		var xmlHttp = new XMLHttpRequest() ;
		var xmlStr ="<root><SEARCH ";
		xmlStr += " tpn_regimen_code=\""+obj.value+"\"";
		xmlStr += " bean_id=\""+bean_id+"\"";
		xmlStr += " bean_name=\""+bean_name+"\"";
		xmlStr +=" /></root>";
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	//	alert("--xmlstr-- "+xmlStr);
//		xmlHttp.open("POST","DrugMasterValidation.jsp?func_mode=drug_code",false);
		xmlHttp.open("POST", "TPNRegimenMastValidate.jsp?func_mode=tpn_regimen_code", false);
		xmlHttp.send(xmlDoc);
	//	alert(xmlHttp.responseText);
		eval(xmlHttp.responseText);
	}
}

function regimenCodeResult(result){

		if(result=='false')	{
		alert(getMessage("PH_TPN_REGIMEN_ALREADY_EXISTS","PH"));
		document.TPNRegimenMastForm.tpn_regimen_code.value="";
		document.TPNRegimenMastForm.long_name.value="";
		document.TPNRegimenMastForm.dflt_tpn_route.selectedindex=0;
		document.TPNRegimenMastForm.item_code.value="";
		if(document.TPNRegimenMastForm.drug_item_code_ind.value =="S"){
			document.TPNRegimenMastForm.item_code.focus();
		}else{
			document.TPNRegimenMastForm.tpn_regimen_code.focus();
		}

		return false;
	}
	else	return true;

}

function enableLipidEmulsion(obj){
	if(obj.value != "")
		document.TPNRegimenMastConsForm.lipid_emulsion_type.disabled=false;
	else
		document.TPNRegimenMastConsForm.lipid_emulsion_type.disabled=true;
}

function roundTwoDigits(a){
			var a=a+"";
			
			if (a.indexOf(".")==-1)
			{
				bb=a.substr(0,a.length);
			}
			else
			{
				bb=a.substr(a.indexOf("."),a.length);
				if (bb.length>3)
				{
					bb=a.substr(0,a.indexOf(".")+3);
				}
				else
				{
					bb=a;
				}
			
			}
			if (bb.indexOf(".")==-1){ bb=bb+'.0';}
			return bb;
}
function fluid_max(obj,code,test,totval,test){	// Added for ML-MMOH-CRF-1266 [IN:068728] - Start	
		defaultPerc(code,test,totval,obj);
		totalEnergy(test);
		npcRatio(test);
} // Added for ML-MMOH-CRF-1266 [IN:068728] - End
