/*
---------------------------------------------------------------------------------------------------------
Date			Edit History    	Name			Rev. Date		Rev. By			Description
---------------------------------------------------------------------------------------------------------
31/3/2021		TFS:15977			Shazana											NMC-JD-SCF-0160
---------------------------------------------------------------------------------------------------------
*/ 
var function_id = "" ;
var route_default_val	=	"";
var result = false ;
var message = "" ;
var flag = "" ;
var schedule_val	=	new Array();
var orderable_yn	=	"N";
var toolBarString = "";
var compFldStatus	= false;
var fdaCategoryGroupCode1 = '';
var fdaCode="";
var fdaSrchTxt="";
var fda1="";
var fda2="";
var fda3="";



function create() {
	f_query_add_mod.location.href="../../ePH/jsp/DrugMasterFrames.jsp?mode="+MODE_INSERT;
}

async function query() {
	var retVal=await DrugSearch("D","");
	if(retVal != null && retVal != "" )  {
		var drug_code = retVal[0] ;
		var drug_desc = retVal[1] ;
		f_query_add_mod.location.href="../../ePH/jsp/DrugMasterFrames.jsp?drug_code="+drug_code+"&mode="+MODE_MODIFY;
	}
}

function apply() {

	if (!proceedOnApply()) {
	/*	if(parent.frames[2].frames[1].frames[2].document.drugMasterAddModifyForm!=null)
		else if(parent.frames[2].frames[1].frames[2].document.forms[0]!=null)
		else if(parent.frames[2].frames[1].frames[2].frames[1].document.forms[0]!=null)
	*/
		var frmObj	= parent.frames[2].frames[1].frames[0].document.drugMasterMainForm.current_form.value;
		var last_link=parent.frames[2].frames[1].frames[0].document.drugMasterMainForm.last_link.value;
		var mode = parent.frames[2].frames[1].frames[0].document.drugMasterMainForm.mode.value;
		if(mode == '2'){
			var link_to_existing_item = parent.frames[2].frames[1].frames[0].document.drugMasterMainForm.link_to_existing_item.value;
			if(link_to_existing_item == 'Y'){
				var item_code = parent.frames[2].frames[1].frames[0].document.drugMasterMainForm.item_code.value;
				if(item_code == ''){
					message = getMessage("ITEM_CANNOT_BE_BLANK","PH");
					parent.frames[2].frames[1].frames[0].document.drugMasterMainForm.item_code.disabled = false;
					parent.frames[2].frames[1].frames[0].document.drugMasterMainForm.item_code_lookup.disabled = false;
					messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num="+message;
					return false;
				}
			}
		}
		var xmlString=formXMLString(frmObj,last_link,'apply');
		var updation=formValidation(xmlString,last_link);

		if(updation){
			if(assignValuePackSize("apply")){
				var formObj			= parent.frames[2].frames[1].frames[0].document.drugMasterMainForm ;
				var formCharaObj	= parent.frames[2].frames[1].frames[2].document.drugMasterDetailForm ;

				var fields  = new Array() ;
				var names   = new Array() ;
				var i		=	0;

				fields[i]   = formObj.pres_base_uom_ref ;
				names[i]   = getLabel("ePH.PrescribingUnit.label","PH");
				i++;
				if(formObj.licenceRights.value!="PHBASIC") {
					fields[i]   = formObj.stock_uom_ref ;
					names[i]   = getLabel("ePH.DispensingUnit.label","PH");
					i++;
				}

				if(formObj.strength_value.value != "" && parseInt(formObj.strength_value.value) != 0 && formObj.strength_uom.value =="") {
					fields[i]   = formObj.strength_uom ;
					names[i]   = getLabel("ePH.StrengthUOM.label","PH");
					i++;
				}
				if(formObj.scheduled_drug_yn_man.value=="Y"){
					fields[i]   = formObj.schedule_man ;
					names[i]	= getLabel("Common.Schedule.label","Common");
					i++;
				}
				if(formObj.reissue_count.value=="" && formObj.reissue_type.value=="F"){//Added for Bru-HIMS-CRF-405[IN044830]
					fields[i]   = formObj.reissue_count ;
					names[i]   = getLabel("ePH.NoofQuantity.label","PH")+"/"+getLabel("ePH.NoofTimes.label","PH");
					i++;
				}
				if(formCharaObj!= undefined){
					if(formCharaObj.warn_reqd_yn_ft.value=="Y"){
						fields[i]   = formCharaObj.DrugEffectToPregnancy ;
						names[i]   = getLabel("ePH.DrugEffectToPregnancy.label","PH")+getLabel("ePH.FirstTrimester.label","PH");
						i++;
					}
					if(formCharaObj.warn_reqd_yn_st.value=="Y"){
						fields[i]   = formCharaObj.DrugEffectToPregnancyforsecondtrim ;
						names[i]   = getLabel("ePH.DrugEffectToPregnancy.label","PH")+getLabel("ePH.SecondTrimester.label","PH");
						i++;
					}
					if(formCharaObj.warn_reqd_yn_tt.value=="Y"){
						fields[i]   = formCharaObj.DrugEffectToPregnancyforthirdtrim ;
						names[i]   = getLabel("ePH.DrugEffectToPregnancy.label","PH")+getLabel("ePH.ThirdTrimester.label","PH");
					}

					//Check for this validation condition based only if the anti_microbial_yn is Y //KDAH-CRF-0610
					if(formCharaObj.rest_anti_justform_yn && formCharaObj.rest_anti_justform_yn.value=="Y" ) {
						if(formCharaObj.rest_anti_justform_duration.value!="0") {
							fields[i]   = formCharaObj.rest_anti_justform_duration ;
							names[i]   = getLabel("ePH.RestrictedAntimicrobialsJustificationFormDuration.label","PH");
						} /*else if(formCharaObj.rest_anti_justform_duration.value=="0") {
							//alert(getLabel("ePH.RestrictedAntimicrobialsJustificationFormDuration.label","PH")+" cannot be zero");
							msg = getMessage("PH_NOT_BLANK_ZERO_COMMON","PH");		
							alert(msg.replace('$',getLabel("ePH.RestrictedAntimicrobialsJustificationFormDuration.label","PH")));

							messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num="+message;
						return false;
					    }*/
					} //KDAH-CRF-0610
	

				}

				var formarray  =new Array(formObj);
				if(checkFields( fields, names, messageFrame)){
					enableMainForm();
					eval(formApply( formarray,PH_CONTROLLER) ) ;
					messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num="+message+" : <b>"+flag+"</b>";
                 
					if( result ) {
						onSuccess();
					}
				}
			}//updation
		}//pack
	}
	else{
		messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num=";
        return false;
	}
}

function assignResult( _result, _message, _flag ) {
	result = _result ;
	message  = _message ;
	flag = _flag ;
}

function reset() {
	f_query_add_mod.location.href="../../ePH/jsp/DrugMasterFrames.jsp?mode="+MODE_INSERT;
}

async function onSuccess() {
	//alert("Drugmaster.js - onSuccess");//added for skr-scf-1312
		// Parameters for the orderable tab.
	var or_yn			=	parent.frames[2].frames[1].frames[0].document.drugMasterMainForm.or_yn.value;
	var mode			=	parent.frames[2].frames[1].frames[0].document.drugMasterMainForm.mode.value;
	var or_status		=	parent.frames[2].frames[1].frames[0].document.drugMasterMainForm.or_status.value;

	if(or_yn=="Y")	{

		var drug_code		=	parent.frames[2].frames[1].frames[0].document.drugMasterMainForm.drug_code.value;
		var drug_desc		=	escape(parent.frames[2].frames[1].frames[0].document.drugMasterMainForm.drug_desc.value);
		var short_desc		=	escape(parent.frames[2].frames[1].frames[0].document.drugMasterMainForm.short_desc.value);
		//ADDED FOR SKR-SCF-1312
		var mm_short_desc		= "";
		if(parent.frames[2].frames[1].frames[0].document.drugMasterMainForm.mm_short_desc)
		 mm_short_desc		=	escape(parent.frames[2].frames[1].frames[0].document.drugMasterMainForm.mm_short_desc.value);
		//ADDED FOR SKR-SCF-1312 END 
		var drug_class		=	parent.frames[2].frames[1].frames[0].document.drugMasterMainForm.drug_class.value;
		var schedule_id		=	parent.frames[2].frames[1].frames[0].document.drugMasterMainForm.schedule_man.value;
		var drug_cat_code	=	parent.frames[2].frames[1].frames[0].document.drugMasterMainForm.drug_cat_code.value;
		var base_unit_code	=	parent.frames[2].frames[1].frames[0].document.drugMasterMainForm.pres_base_uom_ref.value;
		var base_unit_desc	=	escape(parent.frames[2].frames[1].frames[0].document.drugMasterMainForm.pres_base_uom_desc_ref.value);
		var sql_order_type	=	parent.frames[2].frames[1].frames[0].document.drugMasterMainForm.sql_or_ph_select1.value;
		var sql_setting		=	parent.frames[2].frames[1].frames[0].document.drugMasterMainForm.sql_or_ph_select2.value;
		var sql_auth_level	=	parent.frames[2].frames[1].frames[0].document.drugMasterMainForm.sql_or_ph_select3.value;
		var refill_yn		=	parent.frames[2].frames[1].frames[0].document.drugMasterMainForm.refill_yn.value;
		var language_id		=	parent.frames[2].frames[1].frames[0].document.drugMasterMainForm.language_id.value;
		var sql_21		=	parent.frames[2].frames[1].frames[0].document.drugMasterMainForm.sql_ph_drug_search_select21.value;
		var sql_22		=	parent.frames[2].frames[1].frames[0].document.drugMasterMainForm.sql_ph_drug_search_select22.value;
		var sql_23		=	parent.frames[2].frames[1].frames[0].document.drugMasterMainForm.sql_ph_drug_search_select23.value;

		var chk =	false;

		if(mode==MODE_MODIFY && or_status=='true')	{
			chk=confirm(getMessage("MODIFY_ORDER_INFO","PH"));
			mode = MODE_MODIFY;
		}
		else {
			chk=confirm(getMessage("SETUP_ORDER_INFO","PH"));
			mode  = MODE_INSERT;
		}

		if(chk){

			var sql_order_type=sql_21+"'"+drug_class+"' AND B.LANGUAGE_ID ='"+language_id+"' ORDER BY 2";
			 var sql_setting="";
			var sql_auth_level=sql_23+"'"+schedule_id+"' AND EFF_STATUS='E' AND A.LANGUAGE_ID = '"+language_id+"' ";

			var dialogHeight= "95vh" ;
			var dialogWidth	= "70vw" ;
			var dialogTop = "60" ;
			var center = "1" ;
			var status="no";
			var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; center: " + center + ";scroll "+scroll+"; status: " + status + "; dialogTop :" + dialogTop;
			var arguments	= "" ;
			//ADDED FOR SKR-SCF-1312 START
			//alert("DrugMaster.js -> drug_desc=199=="+drug_desc+"short_desc==="+short_desc+"==mm_short_desc==>"+mm_short_desc);//commented for skr-scf-1312
			if(mm_short_desc==undefined || mm_short_desc=="" || mm_short_desc==null) //SCF-13456
			mm_short_desc=short_desc;
			
			short_desc = mm_short_desc; 
			var retVal = await top.window.showModalDialog("../../eOR/jsp/OROrderCatalog.jsp?mode="+mode+"&uom_desc="+base_unit_desc+"&uom_code="+base_unit_code+"&order_catalog_code="+drug_code+"&long_desc="+drug_desc+"&short_desc="+short_desc+"&module_id=PH&order_category=PH&sql_order_type="+drug_class+"&sql_setting="+sql_setting+"&sql_auth_level="+schedule_id+"&update_refill_cont_order_yn="+refill_yn+"&mm_short_desc="+mm_short_desc,arguments,features);//mm_short_desc added for SKR-SCF-1312
              
			if(restoreToolbar()){
				create();
				messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num=";
			}
		}
		else{
			create();
		}
	}
	else{
		create();
	}
}

function restoreToolbar(){
	bean_id		=	parent.frames[2].frames[1].frames[0].document.drugMasterMainForm.bean_id.value;
	bean_name	=	parent.frames[2].frames[1].frames[0].document.drugMasterMainForm.bean_name.value;

	var xmlDoc="";
    var xmlHttp = new XMLHttpRequest();

    var xmlStr ="<root><SEARCH ";
	xmlStr += " bean_id=\""+bean_id+"\"";
	xmlStr += " bean_name=\""+bean_name+"\"";
    xmlStr +=" /></root>";
    xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
    xmlHttp.open("POST","DrugMasterValidation.jsp?func_mode=toolBar&"+toolBarString,false);
    xmlHttp.send(xmlDoc);
	eval(xmlHttp.responseText)
	return true
}

async function callOrderableTab(drug_code,drug_desc,drug_class,schedule_id,drug_cat_code)	{
	var language_id		=	parent.frames[2].frames[1].frames[0].document.drugMasterMainForm.language_id.value;
	var sql_24			=	parent.frames[2].frames[1].frames[0].document.drugMasterMainForm.sql_ph_drug_search_select24.value;
	var sql_25			=	parent.frames[2].frames[1].frames[0].document.drugMasterMainForm.sql_ph_drug_search_select25.value;
	var sql_26			=	parent.frames[2].frames[1].frames[0].document.drugMasterMainForm.sql_ph_drug_search_select26.value;

	var sql_order_type=sql_24+"'"+language_id+"'"+" ORDER BY 2";
	var sql_ptcl=sql_25+"'"+drug_code+"' AND A.LANGUAGE_ID = "+"'"+language_id+"'";
	var sql_auth_level=sql_26+"'"+schedule_id+"' AND EFF_STATUS='E' ";

	var dialogHeight= "35" ;
	var dialogWidth	= "50" ;
	var dialogTop = "60" ;
	var center = "1" ;
	var status="no";
	var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop;
	var arguments	= "" ;
	retVal = await window.showModalDialog("../../eOR/jsp/OROrderCatalog.jsp?uom_desc="+base_unit_desc+"&uom_code="+base_unit_code+"&order_catalog_code="+drug_cat_code+"&long_desc="+drug_desc+"&short_desc="+drug_desc+"&module_id=PH&order_category=PH&sql_order_type="+sql_order_type+"&sql_setting="+sql_setting+"&sql_auth_level="+sql_auth_level+"&mode=1",arguments,features);
}

function checkMandatoryFields()	{
	var formObj			= parent.frames[0].document.drugMasterMainForm ;
	var messageFrame	=	parent.parent.messageFrame;
	
	var fields = new Array ( formObj.drug_code, formObj.drug_desc, formObj.generic_name, formObj.form_code,formObj.route_code);
	var names = new Array ( getLabel("Common.DrugCode.label","Common"),  getLabel("ePH.DrugDescription.label","PH"), getLabel("Common.GenericName.label","Common"), getLabel("ePH.Form.label","PH"),getLabel("Common.Route.label","Common"));

	if(formObj.stock_yn.value=="Y" && formObj.item_mand.style.visibility=="visible" && formObj.mode.value==MODE_INSERT)	{
		fields[fields.length]	=	formObj.item_code;
		names[names.length]		=	 getLabel("Common.ItemCode.label","Common");
	}
    
	if(checkFields( fields, names, messageFrame) && checkGeneric(formObj))	{
		messageFrame.location.href="../../eCommon/jsp/MstCodeError.jsp"
		disableMainForm();
		return true;
	}
	else
		return false;
}

function disableMainForm()	{
	
	var arrObj = parent.frames[0].document.drugMasterMainForm.elements;
    for(var i=0;i<arrObj.length;i++){
		arrObj[i].disabled=true;
	} 
	parent.frames[0].document.drugMasterMainForm.prompt_alert_for_preferred_drug.disabled = false;	
	parent.frames[0].document.drugMasterMainForm.default_route_yn.disabled = false;	
	//Added for MMS-DM-CRF-0177
	var formObj			= parent.frames[0].document.drugMasterMainForm ;
	if(formObj.pre_alloc_appl_yn.value=="Y")
	{
		parent.frames[0].document.drugMasterMainForm.drug_search_by.disabled = false;	 //Added for MMS-DM-CRF-0177
	}
	//Added for MMS-DM-CRF-0177
}

function enableMainForm()	{
	var arrObj = parent.frames[2].frames[1].frames[0].document.drugMasterMainForm.elements;
	for(var i=0;i<arrObj.length;i++)
	   arrObj[i].disabled=false;
}

function showTabDetail(obj)	{
	link	=	obj;
//alert("showTabDetail==>"+link);
	if(link=="characteristics_tab" || link=="dosage_tab" || link=="inventory_tab" || link=="trade_tab" || link=="generic_tab" || link=="external_tab" || link=="weightrecording_tab" || link=="sliding_scale_tab" || link=="support_drugs_tab"){// support_drugs_tab link for TH-KW-CRF-0007
		trimDescription(parent.frames[0].document.drugMasterMainForm);
		var generic_id = parent.frames[0].document.drugMasterMainForm.generic_id.value;
		var item_code  = parent.frames[0].document.drugMasterMainForm.item_code.value;
		var form_code = parent.frames[0].document.drugMasterMainForm.form_code.value;
		var generic_name =parent.frames[0].document.drugMasterMainForm.generic_name.value;
		var drugCode	=parent.frames[0].document.drugMasterMainForm.drug_code.value;
		var in_formulary_yn	=parent.frames[0].document.drugMasterMainForm.in_formulary_yn.value;
		var flag="yes";
		if(checkMandatoryFields())	{
			parent.frames[0].document.drugMasterMainForm.audit_log.disabled	= false;
			
			checkOrderableTab(drugCode);
		
			if(link=="characteristics_tab")	{
				if(parent.frames[0].document.drugMasterMainForm.form_modify.value=="Y"){
					var frmObj	= parent.frames[0].document.drugMasterMainForm.current_form.value;
					var last_link=parent.frames[0].document.drugMasterMainForm.last_link.value;
					//var count_flag=parent.frames[0].document.drugMasterMainForm.count_flag.value;
					var xmlString=formXMLString(frmObj,link,"tab");
					var updation=formValidation(xmlString,last_link);
				}
				parent.frames[0].document.drugMasterMainForm.drug_desc.disabled	= false;
				parent.frames[0].document.drugMasterMainForm.audit_log.disabled	= false;
				if(in_formulary_yn == 'N'){
					parent.frames[0].document.drugMasterMainForm.in_formulary_yn.disabled	= false;
					validateItemCode(parent.frames[0].document.drugMasterMainForm.in_formulary_yn);
				}

				parent.frames[2].location.href="../../ePH/jsp/DrugMasterDetail.jsp?generic_id="+generic_id+"&link="+link;
			}
			else if(link=="dosage_tab"){

				if(parent.frames[0].document.drugMasterMainForm.form_modify.value=="Y"){
					var frmObj	= parent.frames[0].document.drugMasterMainForm.current_form.value;
					var last_link=parent.frames[0].document.drugMasterMainForm.last_link.value;
					var xmlString=formXMLString(frmObj,link,"tab");
					var updation=formValidation(xmlString,last_link);
				}
				parent.frames[2].location.href="../../ePH/jsp/DrugMasterDetailFrames.jsp?generic_id="+generic_id+"&item_code="+item_code+"&form_code="+form_code+"&link="+link;
			}
			else if(link=="inventory_tab")	{
				
				if(parent.frames[0].document.drugMasterMainForm.form_modify.value=="Y"){
					var frmObj	= parent.frames[0].document.drugMasterMainForm.current_form.value;
					var last_link=parent.frames[0].document.drugMasterMainForm.last_link.value;
					//var count_flag=parent.frames[0].document.drugMasterMainForm.count_flag.value;
					var xmlString=formXMLString(frmObj,link,"tab");
					var updation=formValidation(xmlString,last_link);
				}

				if(parent.frames[0].document.drugMasterMainForm.in_formulary_yn.checked==true && parent.frames[0].document.drugMasterMainForm.stock_yn.value=="Y" && parent.frames[0].document.drugMasterMainForm.link_to_existing_item.checked==true  && parent.frames[0].document.drugMasterMainForm.drug_to_item_mapping.value=="D"){
					if(parent.frames[0].document.drugMasterMainForm.allow_inventory.value=="Y"){
						if(parent.frames[0].document.drugMasterMainForm.item_code.value!="" && parent.frames[0].document.drugMasterMainForm.pres_base_uom_ref.value=="")	{
							alert(getMessage("PH_BASE_UNIT_SELECT","PH"));
						}
						else {

							 parent.frames[2].location.href="../../ePH/jsp/DrugMasterDetailFrames.jsp?generic_id="+generic_id+"&item_code="+item_code+"&form_code="+form_code+"&link="+link;
						}
					}
				}
				else	{
					alert(getMessage("PH_INVENTORY_NOT_ALLOWED","PH"));
				}
			 }
			 else if(link=="trade_tab")	{
				
				if(parent.frames[0].document.drugMasterMainForm.form_modify.value=="Y"){
					var frmObj	= parent.frames[0].document.drugMasterMainForm.current_form.value;
					var last_link=parent.frames[0].document.drugMasterMainForm.last_link.value;
					var xmlString=formXMLString(frmObj,link,"tab");
					var updation=formValidation(xmlString,last_link);
  				}
				parent.frames[2].location.href="../../ePH/jsp/DrugMasterDetailFrames.jsp?generic_id="+generic_id+"&item_code="+item_code+"&form_code="+form_code+"&link="+link;
			 } 
			 else if(link=="weightrecording_tab")	{
				
				if(parent.frames[0].document.drugMasterMainForm.form_modify.value=="Y"){
					var frmObj	= parent.frames[0].document.drugMasterMainForm.current_form.value;
					var last_link=parent.frames[0].document.drugMasterMainForm.last_link.value;
					var xmlString=formXMLString(frmObj,link,"tab");
					var updation=formValidation(xmlString,last_link);
  				}
			
				parent.frames[2].location.href="../../ePH/jsp/DrugMasterDetailFrames.jsp?generic_id="+generic_id+"&item_code="+item_code+"&form_code="+form_code+"&link="+link;
			 }

			 else if(link=="generic_tab")	{
				 
				if(parent.frames[0].document.drugMasterMainForm.form_modify.value=="Y"){
					var frmObj	= parent.frames[0].document.drugMasterMainForm.current_form.value;
					var last_link=parent.frames[0].document.drugMasterMainForm.last_link.value;
					var xmlString=formXMLString(frmObj,link,"tab");
					var updation=formValidation(xmlString,last_link);
				}

				if(parent.frames[0].document.drugMasterMainForm.compound_drug_yn.checked) {
					parent.frames[2].location.href="../../ePH/jsp/DrugMasterDetailFrames.jsp?generic_id="+generic_id+"&item_code="+item_code+"&form_code="+form_code+"&link="+link;
				}
				else{
					alert(getMessage("PH_NOT_COMPOUND_DRUG","PH"));
				}

			} 
			else if(link=="external_tab")	{
				
				if(parent.frames[0].document.drugMasterMainForm.form_modify.value=="Y"){
					var frmObj	= parent.frames[0].document.drugMasterMainForm.current_form.value;
					var last_link=parent.frames[0].document.drugMasterMainForm.last_link.value;
					var xmlString=formXMLString(frmObj,link,"tab");
					var updation=formValidation(xmlString,last_link);
				}
				parent.frames[2].location.href="../../ePH/jsp/DrugMasterAddModify.jsp?link="+link+"&generic_id="+generic_id+"&generic_name="+generic_name+"&drug_code="+drugCode;
			 }
			else if(link=="sliding_scale_tab")	{
		
			//	alert("parent.frames[0].document.drugMasterMainForm.form_modify.value >>>"+parent.frames[0].document.drugMasterMainForm.form_modify.value);
				if(parent.frames[0].document.drugMasterMainForm.form_modify.value=="Y"){
					var frmObj	= parent.frames[0].document.drugMasterMainForm.current_form.value;
					var last_link=parent.frames[0].document.drugMasterMainForm.last_link.value;
					var xmlString=formXMLString(frmObj,link,"tab");
					var updation=formValidation(xmlString,last_link);
				}
				//	alert("parent.frames[2] "+parent.frames[2].name);
				parent.frames[2].location.href="../../ePH/jsp/DrugMasterAddModify.jsp?link="+link+"&drug_code="+drugCode;
			}//Adding start for TH-KW-CRF-0007
			else if(link=="support_drugs_tab")	{
				if(parent.frames[0].document.drugMasterMainForm.form_modify.value=="Y"){
					var frmObj	= parent.frames[0].document.drugMasterMainForm.current_form.value;
					var last_link=parent.frames[0].document.drugMasterMainForm.last_link.value;
					var xmlString=formXMLString(frmObj,link,"tab");
					var updation=formValidation(xmlString,last_link);
  				}
			
				parent.frames[2].location.href="../../ePH/jsp/SupportiveDrugsFrames.jsp?parent_drug_code="+drugCode+"&link="+link;
			 }//Adding end for TH-KW-CRF-0007
		}
	}
	if(link=="prescribingdet_tab")	{
		var licenceRights = parent.parent.frames[0].document.drugMasterMainForm.licenceRights.value;
		if(parent.parent.frames[0].document.drugMasterMainForm.form_modify.value=="Y"){
			var frmObj	= parent.parent.frames[0].document.drugMasterMainForm.current_form.value;
			var last_link=parent.parent.frames[0].document.drugMasterMainForm.last_link.value;
			var xmlString=formXMLString(frmObj,link,"tab");
			var updation=formValidation(xmlString,last_link);
		}
		form_code	=	parent.parent.frames[0].document.drugMasterMainForm.form_code.value;
		parent.parent.frames[2].f_detail.location.href="../../ePH/jsp/DrugMasterAddModify.jsp?link="+link+"&form_code="+form_code;
	 }
	 else if(link=="dispensingdet_tab")	{
		if(parent.parent.frames[0].document.drugMasterMainForm.form_modify.value=="Y"){
			var frmObj	= parent.parent.frames[0].document.drugMasterMainForm.current_form.value;
			var last_link=parent.parent.frames[0].document.drugMasterMainForm.last_link.value;
			var xmlString=formXMLString(frmObj,link,"tab");
			var updation=formValidation(xmlString,last_link);
		}
		var strength_value=parent.parent.frames[0].document.drugMasterMainForm.strength_value.value;
		var item_code  = parent.parent.frames[2].f_title.document.drugMasterTitleForm.item_code.value;
		var form_code =  parent.parent.frames[2].f_title.document.drugMasterTitleForm.form_code.value;
		var generic_id =  parent.parent.frames[2].f_title.document.drugMasterTitleForm.generic_id.value;
		parent.parent.frames[2].f_detail.location.href="../../ePH/jsp/DrugMasterAddModify.jsp?generic_id="+generic_id+"&item_code="+item_code+"&form_code="+form_code+"&link="+link+"&default_strength_value="+strength_value;
	 }
	 else if(link=="ivchar_tab")	{
		var generic_id = parent.parent.frames[0].document.drugMasterMainForm.generic_id.value;
		var item_code  = parent.parent.frames[0].document.drugMasterMainForm.item_code.value;
		var form_code = parent.parent.frames[0].document.drugMasterMainForm.form_code.value;
		var generic_name =parent.parent.frames[0].document.drugMasterMainForm.generic_name.value;
		var drugCode	=parent.parent.frames[0].document.drugMasterMainForm.drug_code.value;
		var licenceRights = parent.parent.frames[0].document.drugMasterMainForm.licenceRights.value;

		if(parent.parent.frames[0].document.drugMasterMainForm.form_modify.value=="Y"){
			var frmObj	= parent.parent.frames[0].document.drugMasterMainForm.current_form.value;
			var last_link=parent.parent.frames[0].document.drugMasterMainForm.last_link.value;
			var xmlString=formXMLString(frmObj,link,"tab");
			var updation=formValidation(xmlString,last_link);
		}
		parent.parent.frames[2].f_detail.location.href="../../ePH/jsp/DrugMasterAddModify.jsp?link="+link+"&generic_id="+generic_id+"&generic_name="+generic_name+"&drug_code="+drugCode;
	 }
}

function adjustFrames(link)	{
	if(link=='inventory_tab'){
		//parent.parent.frames[2].document.getElementById("fset").rows='7%,*,40%';
		parent.parent.frames[2].document.getElementById("f_title").style.height="7vh";
		parent.parent.frames[2].document.getElementById("f_detail").style.height="53vh";
		parent.parent.frames[2].document.getElementById("f_add_modify").style.height="40vh";
		parent.parent.frames[2].f_add_modify.location.href="../../ePH/jsp/DrugMasterAddModify.jsp?link="+link;
	}
	else if(link=='trade_tab' ||link=='weightrecording_tab'){
			//parent.frames[2].document.getElementById("fset").rows='10%,*,30%';
			parent.frames[2].document.getElementById("f_title").style.height="10vh";
		parent.frames[2].document.getElementById("f_detail").style.height="60vh";
		parent.frames[2].document.getElementById("f_add_modify").style.height="30vh";
		parent.frames[2].f_add_modify.location.href="../../ePH/jsp/DrugMasterAddModify.jsp?link="+link;
	}
	else if(link=='generic_tab'){
		if(parent.frames[0].document.drugMasterMainForm.compound_drug_yn.checked) {
			//parent.frames[2].document.getElementById("fset").rows='7%,*,25%';
		parent.frames[2].document.getElementById("f_title").style.height="7vh";
		parent.frames[2].document.getElementById("f_detail").style.height="58vh";
		parent.frames[2].document.getElementById("f_add_modify").style.height="25vh";
			parent.frames[2].f_add_modify.location.href="../../ePH/jsp/DrugMasterAddModify.jsp?link="+link;
		}
	}
	else if(link=='prescribingdet_tab' || link=='dispensingdet_tab' || link=='ivchar_tab'){
		//parent.frames[2].document.getElementById("fset").rows='3%,*,0%';
		parent.frames[2].document.getElementById("f_title").style.height="5vh";
		parent.frames[2].document.getElementById("f_detail").style.height="77vh";
		parent.frames[2].document.getElementById("f_add_modify").style.height="0vh";
	}
}

function validateItemCode(obj)	{
	var frmObj="";
	if(parent.frames[0].document.drugMasterMainForm!=null)
		frmObj=parent.frames[0].document.drugMasterMainForm;
	else if(parent.frames[1].frames[0].document.drugMasterMainForm!=null)
		frmObj=parent.frames[1].frames[0].document.drugMasterMainForm;
	if(obj.checked==false)	{
		frmObj.item_code.disabled=true;
		frmObj.item_code_lookup.disabled=true;
		validateLinkItem();
	}
	else	{
		frmObj.item_code.disabled=false;
		frmObj.item_code_lookup.disabled=false;
		var mode				= frmObj.mode.value;
		var drug_code			=	parent.frames[1].frames[0].document.drugMasterMainForm.drug_code.value;
		var drug_item_code_link =	frmObj.drug_item_code_link.value;
		var drug_code_and_item	=	frmObj.drug_code_and_item.value;
		validateLinkItem();
		if((mode == '2') && (drug_item_code_link=='Y') && (drug_code_and_item=='S')){
			frmObj.item_code.value = drug_code;
			searchItemCode(drug_code);
		}
	}
	if(mode == '2'){
		frmObj.drug_desc.disabled	=false;
	}
}

function validateLinkItem()	{
	var frmObj="";
	if(parent.frames[0].document.drugMasterMainForm!=null)
		frmObj=parent.frames[0].document.drugMasterMainForm;
	else if(parent.frames[1].frames[0].document.drugMasterMainForm!=null)
		frmObj=parent.frames[1].frames[0].document.drugMasterMainForm;

	var	stock		=	frmObj.stock_yn.value;
	var	link		=	frmObj.drug_item_code_link.value;
	var formulary	=	frmObj.in_formulary_yn.checked;


	if(stock=="Y" && link=="Y" && formulary == true )	{
		frmObj.link_to_existing_item.checked	=	true;
		frmObj.link_to_existing_item.value		=	"Y";
		frmObj.drug_code.readOnly				=	true;
		frmObj.drug_desc.disabled				=	true;
	}

	if(stock=="Y" && (formulary == true || link=="Y") )	{
		if(frmObj.item_mand !=null)
		frmObj.item_mand.style.visibility="visible";

		frmObj.link_to_existing_item.disabled	= false;
		frmObj.item_code.disabled				= false;
		frmObj.item_code_lookup.disabled		= false;
		frmObj.drug_code.readOnly				= true;
		frmObj.drug_desc.disabled				= true;
	}

	if(stock=="N" || stock=="" || link=="N" || formulary == false )	{

		frmObj.link_to_existing_item.checked	= false;
		frmObj.link_to_existing_item.value		= "N";
		frmObj.link_to_existing_item.disabled	= true;

		frmObj.item_code.value					="";
		frmObj.item_code.disabled				=true;
		frmObj.item_code_lookup.disabled		=true;
		if(frmObj.item_mand !=null)
		frmObj.item_mand.style.visibility		="hidden";

		frmObj.drug_code.readOnly	= false;
		frmObj.drug_desc.readOnly	= false;
		frmObj.drug_desc.disabled	= false;
	}
}

function checkItemCode(obj)	{
	var mode = parent.frames[1].frames[0].document.drugMasterMainForm.mode.value;
	if(obj.checked==true)	{		
		parent.frames[1].frames[0].document.drugMasterMainForm.drug_code.readOnly	=true;		
		if(parent.frames[1].frames[0].document.getElementById('item_mand') !=null)
			parent.frames[1].frames[0].document.getElementById('item_mand').style.visibility="visible";

		parent.frames[1].frames[0].document.drugMasterMainForm.item_code.disabled	=	false;
		parent.frames[1].frames[0].document.drugMasterMainForm.item_code.focus();
		parent.frames[1].frames[0].document.drugMasterMainForm.item_code_lookup.disabled	=	false;
		parent.frames[1].frames[0].document.drugMasterMainForm.drug_desc.disabled	=true;
		if(mode == '2'){
			parent.frames[1].frames[0].document.drugMasterMainForm.drug_desc.disabled	=false;
			var drug_item_code_link=	parent.frames[1].frames[0].document.drugMasterMainForm.drug_item_code_link.value;
			var drug_code_and_item=	parent.frames[1].frames[0].document.drugMasterMainForm.drug_code_and_item.value;
			if((drug_item_code_link=='Y')&& (drug_code_and_item=='S')){
				var drug_code =parent.frames[1].frames[0].document.drugMasterMainForm.drug_code.value;
				parent.frames[1].frames[0].document.drugMasterMainForm.item_code.value = drug_code;
				searchItemCode(drug_code);
				parent.frames[1].frames[0].document.drugMasterMainForm.item_code.disabled	=	true;
				parent.frames[1].frames[0].document.drugMasterMainForm.item_code_lookup.disabled	=	true;
			}
		}
	}
	else{			
		if(mode != '2'){
			parent.frames[1].frames[0].document.drugMasterMainForm.drug_code.disabled	=false;
			parent.frames[1].frames[0].document.drugMasterMainForm.drug_code.readOnly	=false;
			parent.frames[1].frames[0].document.drugMasterMainForm.drug_code.focus();
			parent.frames[1].frames[0].document.drugMasterMainForm.drug_desc.disabled	=false;
			parent.frames[1].frames[0].document.drugMasterMainForm.drug_desc.readOnly	=false;
		}
		if(parent.frames[1].frames[0].document.getElementById('item_mand') !=null)
			parent.frames[1].frames[0].document.getElementById('item_mand').style.visibility="hidden";
	
		parent.frames[1].frames[0].document.drugMasterMainForm.drug_desc.disabled	=false;
		parent.frames[1].frames[0].document.drugMasterMainForm.item_code.value	=	"";
		parent.frames[1].frames[0].document.drugMasterMainForm.item_code.disabled	=	true;
		parent.frames[1].frames[0].document.drugMasterMainForm.item_code_lookup.disabled	=	true;
	}
}

async function searchGenericName(obj){
	var argumentArray  = new Array() ;
	var dataNameArray  = new Array() ;
	var dataValueArray = new Array() ;
	var dataTypeArray  = new Array() ;
	var sql_ph_generic_name="SELECT A.GENERIC_ID code,A.GENERIC_NAME description FROM PH_GENERIC_NAME_LANG_VW A WHERE  upper(A.GENERIC_ID) like upper(?) AND upper(A.GENERIC_NAME) like upper(?) AND A.EFF_STATUS='E' AND A.LANGUAGE_ID ='"+drugMasterMain.document.drugMasterMainForm.language_id.value+"' ";//15977
	argumentArray[0]   = sql_ph_generic_name; //15977
	argumentArray[1]   = dataNameArray ; 
	argumentArray[2]   = dataValueArray ;
	argumentArray[3]   = dataTypeArray ;
	argumentArray[4]   = "1,2";
	argumentArray[5]   = drugMasterMain.document.drugMasterMainForm.generic_name.value ;
	argumentArray[6]   = DESC_LINK ;
	argumentArray[7]   = DESC_CODE ;
	
	retVal = await CommonLookup( getLabel("Common.GenericName.label","Common"), argumentArray );
	
	var ret1=unescape(retVal);
		 	var arr=ret1.split(",");
		 	if(arr[1]==undefined) 
	 		{
		 		arr[0]="";	
		 		arr[1]="";	
	 		}
	if(retVal != null && retVal != "" )  {
		drugMasterMain.document.drugMasterMainForm.generic_name.value = arr[1] ;
		drugMasterMain.document.drugMasterMainForm.generic_id.value = arr[0];
		obj.disabled=true;
		drugMasterMain.document.drugMasterMainForm.generic_name.readOnly=true;
		getMainDrugClass(arr[0]);
	}
}

function populateRoute(frmObj) {
	var xmlDoc="";
    var xmlHttp = new XMLHttpRequest();
    var arrObj = frmObj.elements;

    var frmObjs = new Array()
    if(frmObj.name == null)
        frmObjs = frmObj ;
    else frmObjs[0] = frmObj ;
    var xmlStr ="<root><SEARCH ";
    for(var frmCount=0; frmCount<frmObjs.length; frmCount++) {
        frmObj = frmObjs[frmCount]
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
                for(var j=0; j<arrObj[i].options.length; j++){
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

    xmlHttp.open("POST","DrugMasterValidation.jsp?func_mode=routePopulate",false);
    xmlHttp.send(xmlDoc);
	eval(xmlHttp.responseText);
	//alert(xmlHttp.responseText);
}

function clearList()	{
	var len =drugMasterMain.document.drugMasterMainForm.route_code.options.length;
	for(var i=0;i<len;i++) {
		drugMasterMain.document.drugMasterMainForm.route_code.remove("route_code") ;
	}

	var tp = "       --- "+getLabel("Common.defaultSelect.label","Common")+"---           " ;
	var opt = document.createElement("OPTION") ;
	opt.text = tp ;
	opt.value = "" ;
	drugMasterMain.document.drugMasterMainForm.route_code.add(opt);
}

function addList(code,desc,default_val,fntColor, backgrndColor)	{
	route_default_val	=	default_val;
	var element = document.createElement('OPTION') ;
	element.value		=  code ;
	element.text		= desc ;
	element.style.color=fntColor;// added for CRF RUT-CRF-0034.1[IN:037389]
	element.style.backgroundColor=backgrndColor;// added for CRF RUT-CRF-0034.1[IN:037389]
	drugMasterMain.document.drugMasterMainForm.route_code.add(element);
}

function defaultRouteValue()	{
	var len =drugMasterMain.document.drugMasterMainForm.route_code.options.length;
	for(var i=0;i<len;i++) {
		if(drugMasterMain.document.drugMasterMainForm.route_code.options[i].value==route_default_val)
			drugMasterMain.document.drugMasterMainForm.route_code.options[i].selected = true;
	}
}

function validateSchedule(obj){
	if(obj.checked==true){
		obj.value = "Y" ;
		f_tab_detail.document.drugMasterDetailForm.schedule_man.style.visibility="visible";
		f_tab_detail.document.drugMasterDetailForm.schedule.disabled=false;
		drugMasterMain.document.drugMasterMainForm.scheduled_drug_yn_man.value="Y";
	}
	else{
		obj.value = "N" ;
		f_tab_detail.document.drugMasterDetailForm.schedule_man.style.visibility="hidden";
		f_tab_detail.document.drugMasterDetailForm.schedule.options[0].selected=true;
		f_tab_detail.document.drugMasterDetailForm.schedule.disabled=true;
		drugMasterMain.document.drugMasterMainForm.scheduled_drug_yn_man.value="N";
		updateSchedulinMain(f_tab_detail.document.drugMasterDetailForm.schedule);
	}
}

function updateSchedulinMain(obj){
	if(obj!=null)	{
		drugMasterMain.document.drugMasterMainForm.schedule_man.value=obj.value;
		drugMasterMain.document.drugMasterMainForm.disp_auth_reqd_yn.value = schedule_val[obj.value];
	}
	else{
		drugMasterMain.document.drugMasterMainForm.disp_auth_reqd_yn.value = "";
	}
}

function updatePrescribedPeriodinMain(obj){
	parent.frames[0].document.drugMasterMainForm.prn_doses_pres_prd_fill_man.value=obj.value;
}
function updateExpiryDaysMain(obj){//Added for TH-KW-CRF-0008
	drugMasterMain.document.drugMasterMainForm.expiry_alert_days.value=obj.value;
}

function updateContinuousFillinMain(obj){
	parent.frames[0].document.drugMasterMainForm.prn_doses_cont_daily_fill_man.value=obj.value;
}

function validateDrugType(val){
	if(val=="I"){
		f_tab_detail.document.drugMasterDetailForm.drug_type_2.checked=false;
		f_tab_detail.document.drugMasterDetailForm.drug_type_3.checked=false;
		validateSchedule(f_tab_detail.document.drugMasterDetailForm.drug_type_3);
	}
	else if(val=="V"){
		f_tab_detail.document.drugMasterDetailForm.drug_type_1.checked=false;
		f_tab_detail.document.drugMasterDetailForm.drug_type_3.checked=false;
		validateSchedule(f_tab_detail.document.drugMasterDetailForm.drug_type_3);
	}
	else if(val=="S"){
		f_tab_detail.document.drugMasterDetailForm.drug_type_1.checked=false;
		f_tab_detail.document.drugMasterDetailForm.drug_type_2.checked=false;
	}
	f_tab_detail.document.drugMasterDetailForm.drug_type.value=val;
}

function assignValue(obj,fractDoseRoundUpObj){
	if(obj.checked==true){
		obj.value="Y";
	}
	else{
		obj.value="N";
	}
	if(obj.name == 'FractionalDoseApplicable'){
		if(obj.checked==false){
			fractDoseRoundUpObj.value = 'N';
			fractDoseRoundUpObj.checked = false;
			fractDoseRoundUpObj.disabled = true;
		}
		else
			fractDoseRoundUpObj.disabled = false;
	}
}

function assignValue2(obj){

	if(obj.checked==true){
		obj.value="E";
	}
	else{
		obj.value="D";
	}
}

//mahesh
function assignValue1(obj,obj1){
	
	if(obj.checked==true){
		obj1.readOnly=false;
		if(obj1.value=="" || chkstr(obj1)){
			alert(getMessage("PH_EXT_DRUG_CODE_EMPTY","PH"));
			obj.checked=false;
			obj.value="D";
			obj1.value="";
			obj1.focus();
		}
		else{
			obj.value="E";
		}
	}
	else{
		obj1.readOnly=true;
		obj.value="D";
	}
}

function chkstr(obj){
	var flag=false;
	var str="abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
	for(var i=0;i<(obj.value).length;i++){
		for(var j=0;j<str.length;j++){
			if((obj.value).substring(i,i+1)==str.substring(j,j+1)){
				flag=false;
				break;
			}
			else{
				flag=true;
			}
		}
		if(flag){
			return flag;
		}
	}	
	return flag;
}

async function compFluids(flud,drug_code) {
	var fluid=flud.value;
	var dialogHeight= "100vh" ;
	var dialogWidth	= "50vw" ;//Changed 35 to 45 for ML-MMOH-CRF-1223
	var dialogTop = "80" ;
	var center = "1" ;
	var status="no";
	var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; center: " + center + ";scroll "+scroll+"; status: " + status + "; dialogTop :" + dialogTop;
	var arguments	= "" ;
	
    var retVal = await window.showModalDialog("../../ePH/jsp/DrugMasterCompFluids.jsp?fluid="+fluid+"&drug_code="+drug_code,arguments,features);
	if(retVal==null)
		retVal=parent.frames[2].frames[1].document.drugMasterAddModifyForm.dflt_fluid.value;
	else{
		var s=retVal.toString();
		var ss=s.split("+");
		retVal=ss[ss.length-1];
	}
	parent.frames[2].frames[1].document.drugMasterAddModifyForm.dflt_fluid.value = retVal;
}

function dffluid(cnt,fldcnt){
	var obj=eval("document.compFluidsForm.e_status"+fldcnt);
	var obj1=eval("document.compFluidsForm.dflt_fld"+fldcnt);
	var val;
	for(var i=1;i<=cnt;i++){
		val=eval("document.compFluidsForm.e_status"+i);
		if((val==obj)&&(obj.checked==true)){
			obj.disabled=false;
			document.compFluidsForm.dflt_fluid.value=obj1.value;
			document.compFluidsForm.eff_stat.value=obj.name;
			eval("document.compFluidsForm.df_fld"+i).value='Y';
		}
		else if(obj.checked==false){
			document.compFluidsForm.dflt_fluid.value="";
			eval("document.compFluidsForm.df_fld"+i).value='N';
			val.disabled=false;
		}
		else
			val.disabled=true;
	}	
}

function clsewindw(cnt,bean_id,bean_name){
	var comp="";
	var j=0;
	document.compFluidsForm.dflt_fluid.value="";
	for(var i=1;i<=cnt;i++){
		var obj1=eval("document.compFluidsForm.dflt_fld"+i);
		var val=eval("document.compFluidsForm.e_status"+i);
		var stat=eval("document.compFluidsForm.e_stats"+i);
		var db=eval("document.compFluidsForm.db_act"+i);
		var df_fls=eval("document.compFluidsForm.df_fld"+i);
		var df_infuse_over =eval("document.compFluidsForm.deflt_infuse_over_value"+i);//Adding start for ML-MMOH-CRF-1223
		if(df_infuse_over.value =="")
			var temp_df_infuse_over=0;
		else
			var temp_df_infuse_over=df_infuse_over.value
			//Adding end for ML-MMOH-CRF-1223
		if(stat.checked==true){
			stat.value="E";
			comp+=obj1.value+"+"+df_fls.value+"+"+stat.value+"+"+db.value+"+"+temp_df_infuse_over+"+";//Added df_infuse_over.value for ML-MMOH-CRF-1223
		}
		else{
			stat.value="D";
			comp+=obj1.value+"+"+df_fls.value+"+"+stat.value+"+"+db.value+"+"+temp_df_infuse_over+"+";//df_infuse_over.value Added for ML-MMOH-CRF-1223
		}
		if(val.checked==true){
			document.compFluidsForm.dflt_fluid.value=obj1.value;
		}
	}
	if(document.compFluidsForm.dflt_fluid.value=="")
		var temp_dflt_fluid =" ";
	else
		var temp_dflt_fluid = document.compFluidsForm.dflt_fluid.value;
	comp+=temp_dflt_fluid;
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest() ;
	var xmlStr ="<root><SEARCH ";
	xmlStr += " CompFluids=\""+comp+"\"";
	xmlStr += " bean_id=\""+bean_id+"\"";
	xmlStr += " bean_name=\""+bean_name+"\"";
	xmlStr +=" /></root>";
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST","DrugMasterValidation.jsp?func_mode=compatible",false);
	xmlHttp.send(xmlDoc);
	eval(xmlHttp.responseText);

	//window.returnValue =comp;//document.compFluidsForm.dflt_fluid.value;
	//window.close();
	let dialogBody = parent.document.getElementById('dialog-body');
	dialogBody.contentWindow.returnValue = comp;
    
	const dialogTag = parent.document.getElementById('dialog_tag');    
	dialogTag.close();
}

//mahesh
function validateForPhysicalForm(){
	var iv_ingredient_yn = parent.frames[2].f_detail.document.drugMasterAddModifyForm.iv_ingredient_yn.value;
	var iv_fluid_yn		 = parent.frames[2].f_detail.document.drugMasterAddModifyForm.iv_fluid_yn.value;

	if(iv_ingredient_yn=="Y" && iv_fluid_yn != "Y"){
		parent.frames[2].f_detail.document.drugMasterAddModifyForm.physical_form.disabled = false;
	}
	else if (iv_ingredient_yn=="N" && iv_fluid_yn == "N"){
		parent.frames[2].f_detail.document.drugMasterAddModifyForm.physical_form.disabled = false;
		applrecfldDisplay();	
	}
	else{
		
		parent.frames[2].f_detail.document.drugMasterAddModifyForm.physical_form.disabled = true;
		parent.frames[2].f_detail.document.drugMasterAddModifyForm.physical_form.value="S";
	}

	if(parent.frames[2].f_detail.document.drugMasterAddModifyForm.iv_ingredient_yn.checked) {
		parent.frames[2].f_detail.document.drugMasterAddModifyForm.cyto_toxic_yn.checked	=	false;
		parent.frames[2].f_detail.document.drugMasterAddModifyForm.cyto_toxic_yn.disabled=	true;
	}
	else {
		if(parent.frames[2].f_detail.document.drugMasterAddModifyForm.iv_fluid_yn.checked==true)
			parent.frames[2].f_detail.document.drugMasterAddModifyForm.cyto_toxic_yn.disabled=	false;
	}
}

function validateStability(obj){
	if(obj.checked==true){
		f_tab_detail.document.drugMasterDetailForm.stability_hrs.disabled=false;
	    f_tab_detail.document.drugMasterDetailForm.stability_man.style.visibility="visible";
	}
	else {
		f_tab_detail.document.drugMasterDetailForm.stability_hrs.value="";
		f_tab_detail.document.drugMasterDetailForm.stability_hrs.disabled=true;
		f_tab_detail.document.drugMasterDetailForm.stability_man.style.visibility="hidden";
	}
}

function validateCalculateByFreqDurn(){
	if(parent.frames[0].document.drugMasterMainForm.drug_code_and_item.value=="S"){
		parent.frames[2].f_detail.document.drugMasterAddModifyForm.fract_dose_round_up_yn.disabled=false;
	}
	else{
		parent.frames[2].f_detail.document.drugMasterAddModifyForm.fract_dose_round_up_yn.disabled=true;
	}
}

function validateInventoryItems(obj){
	if(obj.checked==true){
		parent.frames[0].document.drugMasterMainForm.allow_inventory.value="N";
		//parent.frames[2].f_detail.document.drugMasterAddModifyForm.disp_multi_strength_yn.checked=false;//commented for ghl-crf-0548
		parent.frames[2].f_detail.document.drugMasterAddModifyForm.disp_by_alt_form_yn.checked=false;
		parent.frames[2].f_detail.document.drugMasterAddModifyForm.disp_multi_strength_yn.disabled=false;//true changed to false for ghl-crf-0548
		parent.frames[2].f_detail.document.drugMasterAddModifyForm.disp_by_alt_form_yn.disabled=true;
	}
	else{
		parent.frames[0].document.drugMasterMainForm.allow_inventory.value="Y";
		parent.frames[2].f_detail.document.drugMasterAddModifyForm.disp_multi_strength_yn.disabled=true;//false changed to true for ghl-crf-0548
		parent.frames[2].f_detail.document.drugMasterAddModifyForm.disp_by_alt_form_yn.disabled=false;
	}

}
function assignValuePackSize(mode){

	if(mode=="apply"){
		uom_code=parent.frames[2].frames[1].frames[0].document.drugMasterMainForm.pres_base_uom_ref.value;
		var eqvl_uom_code=parent.frames[2].frames[1].frames[0].document.drugMasterMainForm.stock_uom_ref.value;
		var bean_id=parent.frames[2].frames[1].frames[0].document.drugMasterMainForm.bean_id.value;
		var bean_name=parent.frames[2].frames[1].frames[0].document.drugMasterMainForm.bean_name.value;
	}
	else{
		var uom_code=parent.frames[0].document.drugMasterMainForm.pres_base_uom_ref.value;
		var eqvl_uom_code=parent.frames[0].document.drugMasterMainForm.stock_uom_ref.value;
		var bean_id=parent.frames[0].document.drugMasterMainForm.bean_id.value;
		var bean_name=parent.frames[0].document.drugMasterMainForm.bean_name.value;
	}

	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest() ;
	var xmlStr ="<root><SEARCH ";
	xmlStr += " sor_mode=\""+mode+"\"";
	xmlStr += " uom_code=\""+uom_code+"\"";
	xmlStr += " eqvl_uom_code=\""+eqvl_uom_code+"\"";
	xmlStr += " bean_id=\""+bean_id+"\"";
	xmlStr += " bean_name=\""+bean_name+"\"";
	xmlStr +=" /></root>";
    xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
    xmlHttp.open("POST","DrugMasterValidation.jsp?func_mode=packSize",false);
    xmlHttp.send(xmlDoc);
	eval(xmlHttp.responseText );
	return true;
}

function assignPackSize(eqvl_value,mode){
	if(mode=="apply"){
		if(eqvl_value!=""){
			parent.frames[2].frames[1].frames[0].document.drugMasterMainForm.content_in_pres_base_uom_ref.value=eqvl_value;
		}
		else{
			parent.frames[2].frames[1].frames[0].document.drugMasterMainForm.content_in_pres_base_uom_ref.value="1";
		}
	}
	else{
		var curr_form=parent.frames[2].frames[1].document.drugMasterAddModifyForm;
		if(eqvl_value!=""){
			curr_form.content_in_pres_base_uom.value=eqvl_value;
			parent.frames[2].f_detail.document.getElementById('pack_size').innerText=eqvl_value;
			//curr_form.content_in_pres_bas_uom.disabled=true;
		}
		else{
			alert(parent.getMessage("PH_CONV_NOT_DEF_PROCEED","PH"));
			parent.parent.f_query_add_mod.location.href="../../ePH/jsp/DrugMasterFrames.jsp?mode="+MODE_INSERT;
		}
	}
}

function assignPresRefValue(obj){
	parent.frames[0].document.drugMasterMainForm.pres_base_uom_ref.value=obj.value;
	parent.frames[0].document.drugMasterMainForm.pres_base_uom_desc_ref.value=obj.options[obj.selectedIndex].text;
}

function updateDrugMain(obj){
	parent.frames[0].document.drugMasterMainForm.drug_cat_code.value=obj.value;
}

function assignStockRefValue(obj){
	parent.frames[0].document.drugMasterMainForm.stock_uom_ref.value=obj.value;
	if(parent.frames[0].document.drugMasterMainForm.pres_base_uom_ref.value!=""&& parent.frames[0].document.drugMasterMainForm.stock_uom_ref.value!=""){
		if(parent.frames[0].document.drugMasterMainForm.pres_base_uom_ref.value!=obj.value){
			assignValuePackSize("tab");
		}
		else{
			parent.frames[2].f_detail.document.drugMasterAddModifyForm.content_in_pres_base_uom.value="1";
			parent.frames[2].f_detail.document.drugMasterAddModifyForm.pack_size.innerText="1";
			parent.frames[2].f_detail.document.drugMasterAddModifyForm.content_in_pres_base_uom.disabled=true;
		}
	}
}

function validateIVFluid(obj){
	if(obj.checked==true){
		parent.frames[2].f_detail.document.drugMasterAddModifyForm.iv_fluid_yn.disabled=false;
	}
	else{
		parent.frames[2].f_detail.document.drugMasterAddModifyForm.iv_fluid_yn.value="N";
		parent.frames[2].f_detail.document.drugMasterAddModifyForm.iv_fluid_yn.checked=false;
		parent.frames[2].f_detail.document.drugMasterAddModifyForm.iv_fluid_yn.disabled=true;
	}
}

function assignPerVolQty(obj){

	if(obj.name=="pres_base_uom"){
		var val		=	obj.options[obj.options.selectedIndex].text;
		if(obj.value == '')
			val='';
		var code	=	parent.frames[2].f_detail.document.drugMasterAddModifyForm.strength_per_pres_uom.value;
		var mode	=	parent.parent.f_query_add_mod.drugMasterMain.document.drugMasterMainForm.mode.value;

		parent.parent.f_query_add_mod.drugMasterMain.document.drugMasterMainForm.base_unit_code.value=val;
		parent.parent.f_query_add_mod.drugMasterMain.document.drugMasterMainForm.base_unit_desc.value=obj.value;

		parent.frames[2].f_detail.document.getElementById('strength_pres_uom').innerText=val;
		parent.frames[2].f_detail.document.getElementById('disp_pres_uom').innerText=val;

		if(obj.value==""){
			parent.frames[2].f_detail.document.drugMasterAddModifyForm.strength_per_value_pres_uom_qty.value="0";
			parent.frames[2].f_detail.document.drugMasterAddModifyForm.strength_per_value_pres_uom_qty.disabled=true;
			//parent.frames[2].f_detail.document.drugMasterAddModifyForm.qtyvol_mand.style.visibility="hidden";
		}
		else{
			//parent.parent.frames[2].f_detail.document.drugMasterAddModifyForm.qtyvol_mand.style.visibility="visible";
			//parent.frames[2].f_detail.document.drugMasterAddModifyForm.strength_per_value_pres_uom_qty.value="0";
			parent.frames[2].f_detail.document.drugMasterAddModifyForm.strength_per_value_pres_uom_qty.disabled=false;
		}
	}
	else if(obj.name=="strength_uom"){
		var val		=	obj.options[obj.options.selectedIndex].text;	
		var code	=   obj.options[obj.options.selectedIndex].value;
		parent.parent.f_query_add_mod.drugMasterMain.document.drugMasterMainForm.strength_uom.value=code;

		if(code!="")
			parent.frames[2].f_detail.document.drugMasterAddModifyForm.strength_per_pres_uom_qty.value=val;

		if(obj.value==""){
			parent.frames[2].f_detail.document.drugMasterAddModifyForm.strength_per_pres_uom_qty.value="";
		}
		else{
			parent.frames[2].f_detail.document.drugMasterAddModifyForm.strength_per_pres_uom_qty.disabled=false;
		}
	}
}

function defaultStrength(obj)	{
	parent.frames[2].f_detail.document.drugMasterAddModifyForm.strength_per_pres_uom.value=obj.value;
	parent.parent.f_query_add_mod.drugMasterMain.document.drugMasterMainForm.strength_value.value=obj.value;

/*	if(obj.value!="")
		parent.frames[2].f_detail.document.drugMasterAddModifyForm.strength_per_value_pres_uom_qty.value="1";

	if(parseFloat(obj.value) == 0)*/
		parent.frames[2].f_detail.document.drugMasterAddModifyForm.strength_per_value_pres_uom_qty.value="1";

	if(parseFloat(obj.value) > 0 ){
		parent.frames[2].f_detail.document.getElementById('strength_mand').style.display="inline";
	}
	else{
		parent.frames[2].f_detail.document.getElementById('strength_value').value = ""; //stmt added for IN18732  --01/02/2010 -- shyampriya 
		parent.frames[2].f_detail.document.getElementById('strength_mand').style.display="none";
	}
}

function updateFormModify(formObject){
	eval(formObject).form_modify.value="Y";
}

function updateschedule(formobj){
	if (formobj.value =="S"){
		f_tab_detail.document.drugMasterDetailForm.schedule.disabled=false;
	}
	else{
		f_tab_detail.document.drugMasterDetailForm.schedule.options[0].selected=true;
		f_tab_detail.document.drugMasterDetailForm.schedule.disabled=true;
	}
}
function updatesceeningnote(formobj){
	if (formobj.value =="S"){
		f_tab_detail.document.drugMasterDetailForm.screen_note.disabled=false;
	}
	else{
		f_tab_detail.document.drugMasterDetailForm.screen_note.options[0].selected=true;
		f_tab_detail.document.drugMasterDetailForm.screen_note.disabled=true;
	}
}

function updateCurrentForm(last_link,form_name,formObject){
	eval(formObject).last_link.value=last_link;
	eval(formObject).current_form.value=form_name;
	eval(formObject).form_modify.value="N";
}

function formXMLString(curr_form,last_link,source){
	var frmObj="";
	if(source=="apply"){
		if(last_link=="ivchar_tab" || last_link=="dispensingdet_tab" || last_link=="prescribingdet_tab")
			frmObj="parent.frames[2].frames[1]."+curr_form;
		else
			frmObj="parent.frames[2].frames[1]."+curr_form;
	}
	else if(last_link=="ivchar_tab" || last_link=="dispensingdet_tab" || last_link=="prescribingdet_tab")
		frmObj="parent.frames[1].document.drugMasterAddModifyForm";
	else 
		frmObj="parent."+curr_form;

	frmObj=eval(frmObj);
	var drug_desc;
	if(frmObj.drug_desc!=null)
		drug_desc	=	frmObj.drug_desc.value;
	var xmlDoc="";
	var xmlHttp = new XMLHttpRequest();
	var arrObj = frmObj.elements;
	var frmObjs = new Array();
	if(frmObj.name == null)
		frmObjs = frmObj ;
	else
		frmObjs[0] = frmObj ;
	var xmlStr ="<root><SEARCH ";
	for(var frmCount=0; frmCount<frmObjs.length; frmCount++) {
		var frmObj = frmObjs[frmCount]
		var arrObj = eval(frmObj).elements;
		for(var i=0;i<arrObj.length;i++) {
			var val = "" ;
			if(arrObj[i].type == "checkbox") {
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
				for(var j=0; j<arrObj[i].options.length; j++){
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
	return xmlStr;
}

function formValidation(xmlStr,last_link){
	
	var temp_jsp="DrugMasterValidation.jsp?func_mode="+last_link;
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest() ;
	
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST",temp_jsp,false);
	xmlHttp.send(xmlDoc);
	responseText=xmlHttp.responseText ;
	return true;
}

function setFocus(frmObj)	{
	if(frmObj.elements[0].disabled == false)
	frmObj.elements[0].focus();
}

function validateCode(obj)	{
	if(obj.value!="" && obj!=null)	{
		var bean_id		=	drugMasterMain.document.drugMasterMainForm.bean_id.value;
		var bean_name	=	drugMasterMain.document.drugMasterMainForm.bean_name.value;

		var xmlDoc = "" ;
		var xmlHttp = new XMLHttpRequest() ;
		var xmlStr ="<root><SEARCH ";
		xmlStr += " drug_code=\""+obj.value+"\"";
		xmlStr += " bean_id=\""+bean_id+"\"";
		xmlStr += " bean_name=\""+bean_name+"\"";
		xmlStr +=" /></root>";
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open("POST","DrugMasterValidation.jsp?func_mode=drug_code",false);
		xmlHttp.send(xmlDoc);
		eval(xmlHttp.responseText);
	}
}

function drugCodeResult(result)	{
	var mode = drugMasterMain.document.drugMasterMainForm.mode.value;
	if(result=='false')	{
		alert(getMessage("PH_DRUG_ALREADY_EXISTS","PH"));
		if(mode == '2'){
			drugMasterMain.document.drugMasterMainForm.item_code.value="";
			drugMasterMain.document.drugMasterMainForm.item_code.focus();
			var drug_code_and_item=	drugMasterMain.document.drugMasterMainForm.drug_code_and_item.value;
			if(drug_code_and_item=='S'){
				drugMasterMain.document.drugMasterMainForm.link_to_existing_item.checked=false;
				drugMasterMain.document.drugMasterMainForm.link_to_existing_item.value='N';
				checkItemCode(drugMasterMain.document.drugMasterMainForm.link_to_existing_item);
			}
		}
		else{
			drugMasterMain.document.drugMasterMainForm.drug_code.value="";
			drugMasterMain.document.drugMasterMainForm.drug_desc.value="";
			drugMasterMain.document.drugMasterMainForm.item_code.value="";
			drugMasterMain.document.drugMasterMainForm.drug_code.focus();
		}
		return false;
	}
	else{
		return true;
	}
}

async function searchItem(obj){
	var argumentArray  = new Array() ;
	var dataNameArray  = new Array() ;
	var dataValueArray = new Array() ;
	var dataTypeArray  = new Array() ;
	//var sql_string="SELECT A.ITEM_CODE code,B.LONG_DESC description FROM ST_ITEM A,MM_ITEM_LANG_VW B WHERE B.LANGUAGE_ID='"+parent.drugMasterMain.document.drugMasterMainForm.language_id.value+"'  AND A.DRUG_ITEM_YN='Y' AND B.ITEM_CODE=A.ITEM_CODE AND A.ITEM_CODE LIKE UPPER(?) AND upper(B.LONG_DESC) LIKE upper(?) ORDER BY 2";
	var sql_ph_drug_select25 = "SELECT A.ITEM_CODE code,B.LONG_DESC description FROM ST_ITEM A,MM_ITEM_LANG_VW B WHERE   A.DRUG_ITEM_YN='Y' AND B.ITEM_CODE=A.ITEM_CODE AND A.ITEM_CODE LIKE UPPER(?) AND upper(B.LONG_DESC) LIKE upper(?) AND A.ITEM_CODE NOT IN(SELECT INVENTORY_ITEM_CODE FROM PH_INVENTORY_ITEM_FOR_DRUG) AND B.LANGUAGE_ID='"+drugMasterMain.document.drugMasterMainForm.language_id.value+"' ";//15977 START
	argumentArray[0]   = sql_ph_drug_select25;  
	//argumentArray[0]   = drugMasterMain.document.drugMasterMainForm.sql_ph_drug_select25.value+"'"+drugMasterMain.document.drugMasterMainForm.language_id.value+"'";////15977 END 
	argumentArray[1]   = dataNameArray ;
	argumentArray[2]   = dataValueArray ;
	argumentArray[3]   = dataTypeArray ;
	argumentArray[4]   = "1,2";
	argumentArray[5]   = drugMasterMain.document.drugMasterMainForm.item_code.value ;
	argumentArray[6]   = DESC_LINK ;
	argumentArray[7]   = DESC_CODE ;
	
	retVal = await CommonLookup( getLabel("Common.ItemName.label","Common"), argumentArray );
	
	var ret1=unescape(retVal);
		 	var arr=ret1.split(",");
		 	if(arr[1]==undefined) 
	 		{
		 		arr[0]="";	
		 		arr[1]="";	
	 		}
	mode = drugMasterMain.document.drugMasterMainForm.mode.value
	if(retVal != null && retVal != "" )  {
		if(mode != '2'){
			if(drugMasterMain.document.drugMasterMainForm.drug_item_code_link.value=="Y") {
				drugMasterMain.document.drugMasterMainForm.drug_code.value = arr[0] ;
				drugMasterMain.document.drugMasterMainForm.drug_desc.value = arr[1];
				drugMasterMain.document.drugMasterMainForm.drug_desc.disabled	=true;
				drugMasterMain.document.drugMasterMainForm.drug_desc.value = arr[1];
			}
		}
		else {
			var drug_code=	drugMasterMain.document.drugMasterMainForm.drug_code.value;
			var drug_item_code_link=	drugMasterMain.document.drugMasterMainForm.drug_item_code_link.value;
			var drug_code_and_item=	drugMasterMain.document.drugMasterMainForm.drug_code_and_item.value;
			var item_code=	arr[0];

			if((drug_item_code_link=='Y') && (drug_code_and_item == 'S') && (item_code != drug_code)){
				alert(getMessage('PH_DRUG_ITEM_MUST_SAME','PH'));
				drugMasterMain.document.drugMasterMainForm.item_code.value="";
				drugMasterMain.document.drugMasterMainForm.link_to_existing_item.checked=false;
				drugMasterMain.document.drugMasterMainForm.link_to_existing_item.value='N';
				checkItemCode(drugMasterMain.document.drugMasterMainForm.link_to_existing_item);
				return false;
			}
		}
		drugMasterMain.document.drugMasterMainForm.item_code.value = arr[0];
		validateCode(drugMasterMain.document.drugMasterMainForm.item_code);

		if(mode == '2')
			drugMasterMain.document.drugMasterMainForm.drug_desc.disabled=false;
	}
}

function checkBaseUnit(frmObj)	{
	base_unit	=	parent.frames[0].document.drugMasterMainForm.base_unit_status.value;
	if(base_unit!="")
		frmObj.pres_base_uom.disabled=true;
}

function validateAlternateAndStrength(obj)	{
	if(obj.checked==true)
	drugMasterMain.document.drugMasterMainForm.multi_strength_status.value ="Y";
}

function makeInfuseMandatory(obj,frmObj)	{
	if(obj.value> parseInt(0)	)
		frmObj.infuse_img.style.visibility='visible';
	else
		frmObj.infuse_img.style.visibility='hidden';
}

function getMainDrugClass(generic_id){
	if(generic_id!="")	{
		var bean_id		=	drugMasterMain.document.drugMasterMainForm.bean_id.value;
		var bean_name	=	drugMasterMain.document.drugMasterMainForm.bean_name.value;

		var xmlDoc = "" ;
		var xmlHttp = new XMLHttpRequest() ;
		var xmlStr ="<root><SEARCH ";
		xmlStr += " generic_id=\""+generic_id+"\"";
		xmlStr += " bean_id=\""+bean_id+"\"";
		xmlStr += " bean_name=\""+bean_name+"\"";
		xmlStr +=" /></root>";
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open("POST","DrugMasterValidation.jsp?func_mode=getDrugClass",false);
		xmlHttp.send(xmlDoc);
		eval(xmlHttp.responseText);
		//return true;
	}
}

function setDrugClass(DrugClass)	{
	if(DrugClass =="Controlled")
		DrugClass	=	"C";
	else if(DrugClass =="Narcotics")
		DrugClass	=	"N";
	else if(DrugClass =="General")
		DrugClass	=	"G";
	drugMasterMain.document.drugMasterMainForm.drug_class.value=DrugClass;
}

function checkOrderableTab(drug_code)	{
	if(drug_code!="")	{
		var bean_id		=	parent.frames[0].document.drugMasterMainForm.bean_id.value;
		var bean_name	=	parent.frames[0].document.drugMasterMainForm.bean_name.value;

		var xmlDoc = "" ;
		var xmlHttp = new XMLHttpRequest() ;
		var xmlStr ="<root><SEARCH ";
		xmlStr += " drug_code=\""+drug_code+"\"";
		xmlStr += " bean_id=\""+bean_id+"\"";
		xmlStr += " bean_name=\""+bean_name+"\"";
		xmlStr +=" /></root>";
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open("POST","DrugMasterValidation.jsp?func_mode=checkOrderable",false);
		xmlHttp.send(xmlDoc);
		eval(xmlHttp.responseText);
	}
}

function setOrderableTab(orderable_val)	{
	orderable_yn	=	orderable_val;
}

function checkGeneric(frmObj) {
	var ret_val	=	true;
	if(frmObj.generic_id.value=="") {
		parent.parent.messageFrame.location.href="../../eCommon/jsp/error.jsp?err_num="+getMessage("PH_INVALID_GENERIC_ID","PH");
		ret_val	=	false;
	}
	return	ret_val;
}

function loadButtons(req_str) {
	parent.f_query_add_mod.f_drug_tabs.location.href="../../ePH/jsp/DrugMasterButtons.jsp?"+req_str;
}

function trimDescription(frmObj) {
	desc	=	frmObj.drug_desc.value.substr(0,40);
	frmObj.short_desc.value=desc;
}

function proceedOnApply() {
    var url = f_query_add_mod.f_tab_detail.location.href;
	var result;
    url = url.toLowerCase();

	if (url.indexOf("blank.html")!=-1)
		result	= true;
	else
		result	= false;

	return result;
}

async function callExternalDBSearch(generic_id,generic_name) {
	var dialogHeight= "35vh" ;
	var dialogWidth	= "50vw" ;
	var dialogTop = "60" ;
	var center = "1" ;
	var status="no";
	var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; center: " + center + ";scroll "+scroll+"; status: " + status + "; dialogTop :" + dialogTop;
	var arguments	= "" ;

    var retVal = await window.showModalDialog("../../ePH/jsp/DrugMasterExternalDrugSearchFrames.jsp?generic_id="+generic_id+"&generic_name="+generic_name,arguments,features);

	if(retVal!=undefined) {
		parent.frames[2].document.drugMasterAddModifyForm.external_drug_name.value	= retVal;
		parent.frames[2].document.drugMasterAddModifyForm.external_drug_id.value	= retVal;
	}
}

function showDrugs(frmObj) {
	generic	=	frmObj.external_generic.value;
	parent.f_external_search_result.location.href="../../ePH/jsp/DrugMasterExternalDrugSearchResult.jsp?external_generic="+generic;
}

function dfDisplay(){
	var iv_ingredient_yn = parent.frames[2].f_detail.document.drugMasterAddModifyForm.iv_ingredient_yn.value;
	var iv_fluid_yn		 = parent.frames[2].f_detail.document.drugMasterAddModifyForm.iv_fluid_yn.value;
	var physical_form_val =
	parent.frames[2].f_detail.document.drugMasterAddModifyForm.physical_form.value;

	if(iv_ingredient_yn=="Y" && iv_fluid_yn != "Y"){
		parent.frames[2].f_detail.document.getElementById('dflt_td').style.visibility="visible";
		parent.frames[2].f_detail.document.drugMasterAddModifyForm.appl_recn_fld_yn.checked= false;
		parent.frames[2].f_detail.document.drugMasterAddModifyForm.appl_recn_fld_yn.value="N";
		parent.frames[2].f_detail.document.getElementById('applrecfld').style.visibility="hidden";
	}
	else{
		   parent.frames[2].f_detail.document.getElementById('dflt_td').style.visibility="hidden";

		if(physical_form_val != "L"){
			parent.frames[2].f_detail.document.drugMasterAddModifyForm.appl_recn_fld_yn.checked= false;
			parent.frames[2].f_detail.document.drugMasterAddModifyForm.appl_recn_fld_yn.value="N";
			parent.frames[2].f_detail.document.getElementById('applrecfld').style.visibility="hidden";
		}
		else{
			parent.frames[2].f_detail.document.getElementById('applrecfld').style.visibility="visible";
		}
	}
}

function dflroutedisplay(dflt_iv_route_code){
	var iv_ingredient_yn = parent.frames[2].f_detail.document.drugMasterAddModifyForm.iv_ingredient_yn.value;
	var	route_code =parent.frames[0].document.drugMasterMainForm.route_code.value;
	parent.frames[2].f_detail.document.drugMasterAddModifyForm.appl_piggy_back_yn.value="N";

	if(dflt_iv_route_code == route_code && iv_ingredient_yn=="Y"  ){
		parent.frames[2].f_detail.document.getElementById('appl_piggyback').style.visibility="visible";
		parent.frames[2].f_detail.document.getElementById('appl_piggyback1').style.visibility="visible";
	}
	else{
		parent.frames[2].f_detail.document.getElementById('appl_piggyback').style.visibility="hidden";
		parent.frames[2].f_detail.document.getElementById('appl_piggyback1').style.visibility="hidden";
	}
}

function applrecfldDisplay(){
	var iv_ingredient_yn = parent.frames[2].f_detail.document.drugMasterAddModifyForm.iv_ingredient_yn.value;
	var physical_form_val =
	parent.frames[2].f_detail.document.drugMasterAddModifyForm.physical_form.value;
	
	if(physical_form_val == "L" && iv_ingredient_yn != "Y"){
			parent.frames[2].f_detail.document.getElementById('applrecfld').style.visibility="visible";
	}
	else{
		parent.frames[2].f_detail.document.drugMasterAddModifyForm.appl_recn_fld_yn.checked= false;
		parent.frames[2].f_detail.document.drugMasterAddModifyForm.appl_recn_fld_yn.value="N";
		parent.frames[2].f_detail.document.getElementById('applrecfld').style.visibility="hidden";
	}
}

/*
function xcludeRecInSecCmb(obj1, obj2)
{
	
	var cmbVal = obj1.options[obj1.selectedIndex].value;

	var len = obj1.length;
	for (var i=0; i<=len; i++) 
	{
		if(obj1[i].value != cmbVal && obj1[i].value != "")
		{
			var opt1 = 	eval(document.createElement('OPTION'));
			opt1.value =  obj1[i].value;
			opt1.text = obj1[i].text;
			obj2.add(opt1);
		}
	}
}

*/

function clearCaution(){
	var formObj=parent.frames[2].f_detail.document.drugMasterAddModifyForm.caution_label_test_id_1;
	var len = formObj.options.length;
	for (var i=0; i<len; i++){
		formObj.remove("");
	}
	var opt	= eval(document.createElement('OPTION'));

	opt.value =	"";
	opt.text = "------------------------------ "+getLabel("Common.defaultSelect.label","Common")+"----------------------------" ;
	formObj.add(opt);
}

function clearSplInstr(){
	var formObj=parent.frames[2].f_detail.document.drugMasterAddModifyForm.spl_instr_label_text_id;
	var len = formObj.options.length;
	for (var i=0; i<len; i++){
		formObj.remove("");
	}
	var opt	= eval(document.createElement('OPTION'));
	opt.value =	"";
	opt.text = "------------------------------ "+getLabel("Common.defaultSelect.label","Common")+"----------------------------" ;
	formObj.add(opt);
}

function addOption(loc,code, desc, selValue, obj){
	var formObj=parent.frames[2].f_detail.document.drugMasterAddModifyForm;
	var opt	= document.createElement('OPTION');
	opt.value =	code;
	opt.text =decodeURIComponent( desc,"UTF-8") ;

	if(obj=='Caution'){
       if(code==selValue){
             opt.selected=true;
    	 	 parent.frames[2].f_detail.document.getElementById('caution_loc').innerText="     "+decodeURIComponent( loc,"UTF-8");
	   }
       formObj.caution_label_test_id_1.add(opt);
	}
	else {
		if(code==selValue)  {
			opt.selected=true;
			parent.frames[2].f_detail.document.getElementById('spl_loc').innerText="     "+decodeURIComponent( loc,"UTF-8");
		}
		formObj.spl_instr_label_text_id.add(opt);
	}
}

function loadCmb(obj){
	var bean_id		= parent.frames[2].f_detail.document.drugMasterAddModifyForm.bean_id.value	
	var bean_name	= parent.frames[2].f_detail.document.drugMasterAddModifyForm.bean_name.value	
	var CmbSelVal = obj.options[obj.selectedIndex].value;
	var varguments =  "xcludeRecInCmb&selCmbVal="+CmbSelVal;
	varguments+= "&cmbLoad=caution_label_test_id_1";

	var xmlStr ="<root><SEARCH ";
	xmlStr += " bean_id=\""+bean_id+"\"";
	xmlStr += " bean_name=\""+bean_name+"\"";
	xmlStr +=" /></root>";

	formXlcude(xmlStr,varguments);
}

function formXlcude(xmlStr,last_link){
	var temp_jsp="DrugMasterValidation.jsp?func_mode="+last_link;
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest() ;

	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST",temp_jsp,false);
	xmlHttp.send(xmlDoc);
	responseText=xmlHttp.responseText;
	eval(responseText);
	return true;
}

function loadCmbSplInstr(obj){
	var bean_id		= parent.frames[2].f_detail.document.drugMasterAddModifyForm.bean_id.value	
	var bean_name	= parent.frames[2].f_detail.document.drugMasterAddModifyForm.bean_name.value	
	var CmbSelVal = obj.options[obj.selectedIndex].value;
	var varguments =  "xcludeRecInCmbSplInstr&selCmbVal="+CmbSelVal;
	varguments+= "&cmbLoad=spl_instr_label_text_id";

	var xmlStr ="<root><SEARCH ";
	xmlStr += " bean_id=\""+bean_id+"\"";
	xmlStr += " bean_name=\""+bean_name+"\"";
	xmlStr +=" /></root>";

	formXlcude(xmlStr,varguments);
}

function searchItemCode(drug_code){
	var bean_id		=	drugMasterMain.document.drugMasterMainForm.bean_id.value;
	var bean_name	=	drugMasterMain.document.drugMasterMainForm.bean_name.value;
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest() ;
	var xmlStr ="<root><SEARCH ";
	xmlStr += " drug_code=\""+drug_code+"\"";
	xmlStr += " bean_id=\""+bean_id+"\"";
	xmlStr += " bean_name=\""+bean_name+"\"";
	xmlStr +=" /></root>";
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST","DrugMasterValidation.jsp?func_mode=getItemCodeLink",false);
	xmlHttp.send(xmlDoc);
	eval(xmlHttp.responseText);
}

function alertDrugItemLink(){
	alert(getMessage("PH_DRUG_ITEM_LINK","PH"));
	drugMasterMain.document.drugMasterMainForm.item_code.value="";
	drugMasterMain.document.drugMasterMainForm.link_to_existing_item.checked=false;
	drugMasterMain.document.drugMasterMainForm.link_to_existing_item.value='N';
	checkItemCode(drugMasterMain.document.drugMasterMainForm.link_to_existing_item);
	return false;
}

function checkItemCode1(){
//	checkItemCode(drugMasterMain.document.drugMasterMainForm.link_to_existing_item);
	var mode = drugMasterMain.document.drugMasterMainForm.mode.value;
	var obj = drugMasterMain.document.drugMasterMainForm.link_to_existing_item;
	if(obj.checked==true)	{		
		drugMasterMain.document.drugMasterMainForm.drug_code.readOnly	=true;		
		if(drugMasterMain.document.getElementById('item_mand') !=null)
			drugMasterMain.document.getElementById('item_mand').style.visibility="visible";

		drugMasterMain.document.drugMasterMainForm.item_code.disabled	=	false;
		drugMasterMain.document.drugMasterMainForm.item_code.focus();
		drugMasterMain.document.drugMasterMainForm.item_code_lookup.disabled	=	false;
		if(mode == '2'){
			drugMasterMain.document.drugMasterMainForm.drug_desc.disabled	=false;
			var drug_item_code_link=	drugMasterMain.document.drugMasterMainForm.drug_item_code_link.value;
			if(drug_item_code_link=='Y'){
				var drug_code =drugMasterMain.document.drugMasterMainForm.drug_code.value;
				drugMasterMain.document.drugMasterMainForm.item_code.value = drug_code;
				drugMasterMain.document.drugMasterMainForm.item_code.disabled	=	true;
				drugMasterMain.document.drugMasterMainForm.item_code_lookup.disabled	=	true;
			}
	
		}

	}
	else{			
		if(mode != '2'){
			drugMasterMain.document.drugMasterMainForm.drug_code.disabled	=false;
			drugMasterMain.document.drugMasterMainForm.drug_code.readOnly	=false;
			drugMasterMain.document.drugMasterMainForm.drug_code.focus();
			drugMasterMain.document.drugMasterMainForm.drug_desc.disabled	=false;
			drugMasterMain.document.drugMasterMainForm.drug_desc.readOnly	=false;
		}
		if(drugMasterMain.document.getElementById('item_mand') !=null)
			drugMasterMain.document.getElementById('item_mand').style.visibility="hidden";
	
		drugMasterMain.document.drugMasterMainForm.drug_desc.disabled	=false;
		drugMasterMain.document.drugMasterMainForm.item_code.disabled	=	true;
		drugMasterMain.document.drugMasterMainForm.item_code_lookup.disabled	=	true;
	}
}

function checkForPositive(obj){
	if(obj.value != ''){
		var strengthval= parseFloat(obj.value);
		if(strengthval < 0){
			obj.value = Math.abs(strengthval);
		}
	}
}

function allowPositiveNumber(obj) {
   var key = window.event.keyCode;// allows only numbers to be entered
   if(key == 45) {
	   return false;
   }
   else{
		return allowValidNumber(obj,window.event,8,6);
	}
}

function tab_click1(id){
	if(id!='characteristics_tab' && parent.f_tab_detail.document.drugMasterDetailForm!= undefined){
		var formCharaObj	= parent.f_tab_detail.document.drugMasterDetailForm ;
		var fields  = new Array() ;
		var names   = new Array() ;
		i=0;
		if(formCharaObj!= undefined){
			if(formCharaObj.warn_reqd_yn_ft.value=="Y"){
				fields[i]   = formCharaObj.DrugEffectToPregnancy ;
				names[i]   = getLabel("ePH.DrugEffectToPregnancy.label","PH")+getLabel("ePH.FirstTrimester.label","PH");
				i++;
			}
			if(formCharaObj.warn_reqd_yn_st.value=="Y"){
				fields[i]   = formCharaObj.DrugEffectToPregnancyforsecondtrim ;
				names[i]   = getLabel("ePH.DrugEffectToPregnancy.label","PH")+getLabel("ePH.SecondTrimester.label","PH");
				i++;
			}
			if(formCharaObj.warn_reqd_yn_tt.value=="Y"){
				fields[i]   = formCharaObj.DrugEffectToPregnancyforthirdtrim ;
				names[i]   = getLabel("ePH.DrugEffectToPregnancy.label","PH")+getLabel("ePH.ThirdTrimester.label","PH");
			}
		}
		if(!checkFields( fields, names,parent.parent.messageFrame)){
			return false;
		}
	}
	selectTab(id);
	showTabDetail(id);
}

function validmaxlength(obj){
	var field_label="";
	if(obj.name =='druginfo_text')
		field_label = getLabel("ePH.DrugInformation.label","PH");
	else if(obj.name =='patientedu_text')
		field_label = getLabel("ePH.PatientEducation.label","PH");
	else if (obj.name =='EDLClassRemarks'){
		field_label = getLabel("ePH.EDLCLASSIFICATIONREMARKS.label","PH");
		if(obj.value.length > 500){
		   var msg = getMessage("REMARKS_CANNOT_EXCEED","Common");
		   msg = msg.replace("$",field_label);
		   msg = msg.replace("#",500);
		   alert(msg);
		   obj.focus();
		}
	}
	if(!CheckMaxLen(field_label,obj,4000, parent.messageFrame)){
		obj.select();
		obj.focus();
	}
}

function chkRstrMaxLength(obj){
	if(obj.value.length > 500){
		return false;
	}
}

function fluidCompCheck(obj,drug_code){
	if(obj.checked == false){
	    compFldStatus = true;

		var bean_id = document.drugMasterAddModifyForm.bean_id.value;
		var bean_name = document.drugMasterAddModifyForm.bean_name.value;
		var fluid_code = drug_code;
		var xmlDoc="";
		var xmlHttp = new XMLHttpRequest();

		var xmlStr ="<root><SEARCH ";
		xmlStr += " bean_id=\""+bean_id+"\"";
		xmlStr += " bean_name=\""+bean_name+"\"";
		xmlStr += " fluid_code=\""+fluid_code+"\"";
		xmlStr +=" /></root>";
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open("POST","DrugMasterValidation.jsp?func_mode=checkCompFldStatus",false);
		xmlHttp.send(xmlDoc);
		eval(xmlHttp.responseText);
		if(!compFldStatus){obj.checked = true;}
	}
	else{
		compFldStatus = true;
	}
	
	return compFldStatus;
}

function cmpFldWarning(drug_code){
	compFldStatus = confirm(getMessage("PH_IS_COMPATIBLE_FLUID_CONTINUE","PH"));
	
	/*if(compFldStatus){
		var bean_id = document.drugMasterAddModifyForm.bean_id.value;
		var bean_name = document.drugMasterAddModifyForm.bean_name.value;
		var fluid_code = drug_code;
		var xmlDoc="";
		var xmlHttp = new XMLHttpRequest();

		var xmlStr ="<root><SEARCH ";
		xmlStr += " bean_id=\""+bean_id+"\"";
		xmlStr += " bean_name=\""+bean_name+"\"";
		xmlStr += " fluid_code=\""+fluid_code+"\"";
		xmlStr +=" /></root>";
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open("POST","DrugMasterValidation.jsp?func_mode=changeCmpFldStatus",false);
		xmlHttp.send(xmlDoc);
		eval(xmlHttp.responseText);
	}*/
}

function setcmpFldUpdateFld(cmpFldUpdateFld){
	compFldStatus = cmpFldUpdateFld;
}

async function showImage(image_filename){
	if(parent.frames[1].name !='f_drug_tabs')
		var imageURL= parent.frames[1].frames[0].document.forms[0].item_image_path.value+image_filename;
	else
		var imageURL= parent.frames[0].document.forms[0].item_image_path.value+image_filename;
	var dialogHeight= "400px" ;
	var dialogWidth	= "700px" ;
	var dialogTop = "111" ;
	var center = "1" ;
	var status="no";

	var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; center: " + center + ";scroll "+scroll+"; status: " + status + "; dialogTop :" + dialogTop;
	var arguments	= "" ;
	var retVal =await window.showModalDialog("../../ePH/jsp/DrugTradeImage.jsp?imageURL="+imageURL,arguments,features);
}

function dispImageFile(formObj,obj){
	if(obj.value !="")
		formObj.td_ImageFilename.innerHTML = "<a href=\"javascript:parent.showImage('"+obj.value+"');\">"+getLabel("Common.ImageFilename.label","Common")+"</a>";
	else
		formObj.td_ImageFilename.innerHTML = getLabel("Common.ImageFilename.label","Common");
}

function loadagegroup(obj){
	var selected_age=obj.value;
	if(selected_age==""){
		setAgefields("","","","","","");	
	}
	else{
		var bean_id =parent.f_tab_detail.f_add_modify.document.drugMasterAddModifyForm.bean_id.value;
		var bean_name =parent.f_tab_detail.f_add_modify.document.drugMasterAddModifyForm.bean_name.value;
		var xmlDoc="";
		var xmlHttp = new XMLHttpRequest();

		var xmlStr ="<root><SEARCH ";
		xmlStr += " bean_id=\""+bean_id+"\"";
		xmlStr += " bean_name=\""+bean_name+"\"";

		xmlStr += " selected_age=\""+selected_age+"\"";

		xmlStr +=" /></root>";
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open("POST","DrugMasterValidation.jsp?func_mode=selected_age_group",false);
		xmlHttp.send(xmlDoc);
		eval(xmlHttp.responseText);
	}
}

function setAgefields(age_group_code,short_desc,min_age,max_age,age_unit,gender){
	
	var age_unit1		= age_unit;
	var	gender1			=gender;
	if(age_unit1=="Y")
		age_unit1=getLabel("Common.Years.label","Common");
	else if(age_unit1=="D")
		age_unit1=getLabel("Common.Day(s).label","Common");
	else if(age_unit1=="M")
		age_unit1=getLabel("Common.months.label","Common");
	else if(age_unit1=="H")
		age_unit1=getLabel("Common.Hour(s).label","Common");
	else if(age_unit1=="N")
		age_unit1=getLabel("Common.Minute(s).label","Common");

	if(gender1=="A")
		gender1=getLabel("Common.label","Common");
	else if(gender1=="M")
		gender1=getLabel("Common.male.label","Common");
	else if(gender1=="F")
		gender1=getLabel("Common.female.label","Common");
	parent.f_tab_detail.f_add_modify.document.getElementById('MinAge').innerText=min_age;
	parent.f_tab_detail.f_add_modify.document.getElementById('AgeUnit').innerText=age_unit1;
	parent.f_tab_detail.f_add_modify.document.getElementById('MaxAge').innerText=max_age;
	parent.f_tab_detail.f_add_modify.document.getElementById('gender1').innerText=gender1;

	parent.f_tab_detail.f_add_modify.document.drugMasterAddModifyForm.min_age.value=min_age;
	parent.f_tab_detail.f_add_modify.document.drugMasterAddModifyForm.age_unit.value=age_unit;
	parent.f_tab_detail.f_add_modify.document.drugMasterAddModifyForm.max_age.value=max_age;
	parent.f_tab_detail.f_add_modify.document.drugMasterAddModifyForm.gender.value=gender;
	parent.f_tab_detail.f_add_modify.document.drugMasterAddModifyForm.short_desc.value=short_desc;
	parent.f_tab_detail.f_add_modify.document.drugMasterAddModifyForm.age_group_code.value=age_group_code;
}

function updateSlidingScale1(frmObj,obj){
	var frmObj = frmObj;

	var bean_id = frmObj.bean_id.value;
	var bean_name = frmObj.bean_name.value;
	var drug_code	 =	 frmObj.drug_code;

	var sld_checked = ""; 
	
	if(obj.checked == true)
		sld_checked = "yes";
	else if(obj.checked == false)
		sld_checked = "no";
	var xmlDoc="";
	var xmlHttp = new XMLHttpRequest();
	var xmlStr ="<root><SEARCH ";
	xmlStr += " bean_id=\""+bean_id+"\"";
	xmlStr += " bean_name=\""+bean_name+"\"";
	xmlStr += " template_id =\""+obj.value+"\"";
	xmlStr += " sld_chkd =\""+sld_checked+"\"";
	xmlStr +=" /></root>";

		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open("POST","DrugMasterValidation.jsp?func_mode=sliding_scale",false);
		xmlHttp.send(xmlDoc);
		eval(xmlHttp.responseText);
//		parent.frames[0].location.href="../../ePH/jsp/DrugMasterValidation.jsp?func_mode=sliding_scale&template_id="+obj.value+"&sld_chkd="+sld_chkd;
		
}

/*==========================================================================================*/
// Functions added for validating infuse_over_value_hrs and  infuse_over_value_mins fields

function validateNum(formObj,obj,hour){
	var tot;
	var hr = hour.value;
	var mi = obj.value;
	var minTohour;
	if(obj.value>59){
		alert(getMessage("INVALID_TIME_MINUTE","PH"));
		obj.select();
		obj.focus();
	}
	else{
		if(hr == "")
			hr = 0;
		if(mi == "")
			mi = 0;
		tot = parseFloat(hr*60)+parseFloat(mi);
		minTohour = parseFloat(tot/60);
		minTohour = Math.round(minTohour*100)/100;
		formObj.infuse_over_value.value = minTohour;
	//	alert("formObj.minTohour.value == "+formObj.infuse_over_value.value);
	}
}

 function getHrsMinStr(formObj,HMvalue){
	 var hrs = Math.floor(HMvalue);
	 HMvalue = HMvalue * 60;
	 var min = HMvalue % 60;
	 formObj.infuse_over_value_hrs.value = Math.floor(hrs);
	 formObj.infuse_over_value_mins.value = Math.round(min);
 }

function CheckForSpecCharsonBlur(obj){
	var str=obj.value;
	var chk="1234567890";
	for(var i=0; i<str.length; i++){
	  if (chk.indexOf(str.charAt(i)) == -1){
		  alert(getMessage("PH_WHOLE_NUMS_ALLOWED","PH"));
		  obj.select();
		  obj.focus();
		  return;
		}
	}
}

function charsCapsSpaceDotCamasOnly(){
	
  if(event.keyCode >=65 && event.keyCode<=90)
	  event.keyCode = event.keyCode;
  else if(event.keyCode >=97 && event.keyCode<=122)
      event.keyCode = event.keyCode;
  else if(event.keyCode >=48 && event.keyCode<=57)
      event.keyCode = event.keyCode;
   else 
     event.keyCode=0;
  }
//added for enabling FDA Pregnancy Category if the Affects Pregnancy Category is checked on 07/8/09
function enableFDA(obj){ 
	var fdaSearchText	= f_tab_detail.document.drugMasterDetailForm.fdaSearch;
	var fdaSearchButton	= f_tab_detail.document.drugMasterDetailForm.fdaSearch_lookup;
	var fda_FirstTrimester	= f_tab_detail.document.drugMasterDetailForm.fda_FirstTrimester;
	var fda_SecondTrimester	= f_tab_detail.document.drugMasterDetailForm.fda_SecondTrimester;
	var fda_ThridTrimester	= f_tab_detail.document.drugMasterDetailForm.fda_ThridTrimester;
	var DrugEffectToPregnancy	= f_tab_detail.document.drugMasterDetailForm.DrugEffectToPregnancy;	//Added for RUT-CRF-0063 [IN:029601]
	var DrugEffectToPregnancyforsecondtrim	= f_tab_detail.document.drugMasterDetailForm.DrugEffectToPregnancyforsecondtrim;	//Added for RUT-CRF-0063 [IN:029601]
	var DrugEffectToPregnancyforthirdtrim	= f_tab_detail.document.drugMasterDetailForm.DrugEffectToPregnancyforthirdtrim;	//Added for RUT-CRF-0063 [IN:029601]
	var formObj=f_tab_detail.document.drugMasterDetailForm;
	if (obj.checked){
		fdaSearchText.disabled = false;
		fdaSearchButton.disabled = false;
		fda_FirstTrimester.disabled = false;
		fda_SecondTrimester.disabled = false;
		fda_ThridTrimester.disabled = false;
		DrugEffectToPregnancy.disabled = false;	//Added for RUT-CRF-0063 [IN:029601]
		DrugEffectToPregnancyforsecondtrim.disabled = false;	//Added for RUT-CRF-0063 [IN:029601]
		DrugEffectToPregnancyforthirdtrim.disabled = false;	//Added for RUT-CRF-0063 [IN:029601]
		formObj.warn_reqd_yn_ft.disabled = false;
		formObj.warn_reqd_yn_st.disabled = false;
		formObj.warn_reqd_yn_tt.disabled = false;
	}
	else{
		fdaSearchText.disabled = true;
		fdaSearchButton.disabled = true;
		fdaSearchText.value = "";
		DrugEffectToPregnancy.value = "";	//Added for RUT-CRF-0063 [IN:029601]
		DrugEffectToPregnancyforsecondtrim.value ="" ;	//Added for RUT-CRF-0063 [IN:029601]
		DrugEffectToPregnancyforthirdtrim.value ="" ;	//Added for RUT-CRF-0063 [IN:029601]
		fda_FirstTrimester.disabled = true;
		fda_SecondTrimester.disabled = true;
		fda_ThridTrimester.disabled = true;
		DrugEffectToPregnancy.disabled = true;	//Added for RUT-CRF-0063 [IN:029601]
		DrugEffectToPregnancyforsecondtrim.disabled = true;	//Added for RUT-CRF-0063 [IN:029601]
		DrugEffectToPregnancyforthirdtrim.disabled = true;	//Added for RUT-CRF-0063 [IN:029601]
		clearCategoryList(fda_FirstTrimester);
		clearCategoryList(fda_SecondTrimester);
		clearCategoryList(fda_ThridTrimester);
		formObj.warn_reqd_yn_ft.disabled = true;
		formObj.warn_reqd_yn_st.disabled = true;
		formObj.warn_reqd_yn_tt.disabled = true;
		formObj.warn_reqd_yn_ft.checked = false;
		formObj.warn_reqd_yn_st.checked = false;
		formObj.warn_reqd_yn_tt.checked = false;
		formObj.warn_reqd_yn_ft.value = "N";
		formObj.warn_reqd_yn_st.value = "N";
		formObj.warn_reqd_yn_tt.value = "N";
		//clearCategoryList(DrugEffectToPregnancy);	//Added for RUT-CRF-0063 [IN:029601]
	}
}
// to search for the FDA Category on click of Pregnancy Category Drug for lookup
async function searchFDACategory(obj){
	
	var fda_FirstTrimester	= f_tab_detail.document.drugMasterDetailForm.fda_FirstTrimester;
	var fda_SecondTrimester	= f_tab_detail.document.drugMasterDetailForm.fda_SecondTrimester;
	var fda_ThridTrimester	= f_tab_detail.document.drugMasterDetailForm.fda_ThridTrimester;
	if (obj.value == ''){
		fdaSrchTxt = '';
		clearCategoryList(fda_FirstTrimester);
		clearCategoryList(fda_SecondTrimester);
		clearCategoryList(fda_ThridTrimester);
	}
	list1Value =fda_FirstTrimester.value;
	list2Value = fda_SecondTrimester.value;
	list3Value = fda_ThridTrimester.value;
	
	var argumentArray  = new Array() ;
	var dataNameArray  = new Array() ;
	var dataValueArray = new Array() ;
	var dataTypeArray  = new Array() ;
	
	var sql_order_type = f_tab_detail.document.drugMasterDetailForm.sql_fda_pregnancy_category_search_LookUp.value+"'"+drugMasterMain.document.drugMasterMainForm.language_id.value+"'"; 	
	argumentArray[0]   = sql_order_type;
	argumentArray[1]   = dataNameArray ;
	argumentArray[2]   = dataValueArray ;
	argumentArray[3]   = dataTypeArray ;
	argumentArray[4]   = "1,2";
	
	
	argumentArray[5]   = f_tab_detail.document.drugMasterDetailForm.fdaSearch.value;
	argumentArray[6]   = DESC_LINK ;
	argumentArray[7]   = DESC_CODE ;
	retVal = await CommonLookup( getLabel("ePH.PregnancyCategoryForDrug.label","PH"), argumentArray );
	//retVal = await CommonLookup( "Pregnancy Category for Drug", argumentArray );
	if (retVal == '' || retVal == undefined ){
		//f_tab_detail.document.drugMasterDetailForm.fdaCategorySearchCode.value = '';
		//f_tab_detail.document.drugMasterDetailForm.fdaSearch.value = '';
		//f_tab_detail.document.drugMasterDetailForm.fdaCategoryGroupCode.value = '';
		f_tab_detail.document.drugMasterDetailForm.fdaSearch.value = fdaSrchTxt;
		f_tab_detail.document.drugMasterDetailForm.fdaCategoryGroupCode.value = fdaCode;
		f_tab_detail.document.drugMasterDetailForm.fdaCategorySearchCode.value = fdaCode;
		//if (fdaCode !='')
		//{
		//trimesterSearch(fdaCode);
		//selctCategoryValues(fda1,f_tab_detail.document.drugMasterDetailForm.fda_FirstTrimester);
		//selctCategoryValues(fda2,f_tab_detail.document.drugMasterDetailForm.fda_SecondTrimester);
		//selctCategoryValues(fda3,f_tab_detail.document.drugMasterDetailForm.fda_ThridTrimester);
		//}

    }
	if(retVal != '' && retVal != undefined){
		
		var ret1=unescape(retVal);
	 	arr=ret1.split(",");
		fdaCode = arr[0];
		fdaSrchTxt = arr[1] ;
		f_tab_detail.document.drugMasterDetailForm.fdaSearch.value = arr[1] ;
		f_tab_detail.document.drugMasterDetailForm.fdaCategorySearchCode.value = arr[0];
		//alert("fdaCategoryGroupCode1--"+fdaCategoryGroupCode1+"--retVal[0]--"+retVal[0]);
     
		if (f_tab_detail.document.drugMasterDetailForm.fdaCategoryGroupCode.value != arr[0]){
			clearCategoryList(fda_FirstTrimester);
			clearCategoryList(fda_SecondTrimester);
			clearCategoryList(fda_ThridTrimester);
			trimesterSearch(arr[0]);
			f_tab_detail.document.drugMasterDetailForm.fdaCategoryGroupCode.value = arr[0];
		}		
	}
}
// to list the cateroy lines of a category group code
function trimesterSearch(obj){     
	var fdaCategorySearchCode=obj;
	var bean_id		= "DrugMasterBean" ;
	var bean_name	= "ePH.DrugMasterBean";
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest() ;
	var xmlStr ="<root><SEARCH ";
	xmlStr += " bean_id=\""+bean_id+"\"";
	xmlStr += " bean_name=\""+bean_name+"\"";
	xmlStr +=" /></root>";
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST","DrugMasterValidation.jsp?func_mode=FDACategoryCodeSearch&category_code="+fdaCategorySearchCode,false);
	xmlHttp.send(xmlDoc);
	eval(xmlHttp.responseText);
}
//dynamically loading the trimester values based on the selection categories through category lookup
/*
function loadSelectIntoLocation(objCode,objDesc){
	var formObj = f_tab_detail.document.drugMasterDetailForm;
	var element = document.createElement('OPTION') ;
	element.value		=  (unescape(objCode)) ;
	element.text		=  (unescape(objDesc)) ;	
	formObj.fda_FirstTrimester.add(element);
	loadSelectIntoLocation1(objCode,objDesc);
}
function loadSelectIntoLocation1(objCode,objDesc){
	var formObj = f_tab_detail.document.drugMasterDetailForm;
	var element = document.createElement('OPTION') ;
	element.value		=  (unescape(objCode)) ;
	element.text		=  (unescape(objDesc)) ;	
	formObj.fda_SecondTrimester.add(element);
	loadSelectIntoLocation2(objCode,objDesc)
}

function loadSelectIntoLocation2(objCode,objDesc){
	var formObj = f_tab_detail.document.drugMasterDetailForm;
	var element = document.createElement('OPTION') ;
	element.value		=  (unescape(objCode)) ;
	element.text		=  (unescape(objDesc)) ;	
	formObj.fda_ThridTrimester.add(element);
}*/

function loadPregnancyTrimesterList(objCode,objDesc){
	var formObj = f_tab_detail.document.drugMasterDetailForm;
	var element = document.createElement('OPTION') ;
	element.value		=  (unescape(objCode)) ;
	element.text		=  (unescape(objCode)) ;
	var element1 = document.createElement('OPTION') ;
	element1.value		=  (unescape(objCode)) ;
	element1.text		=  (unescape(objCode)) ;
	var element2 = document.createElement('OPTION') ;
	element2.value		=  (unescape(objCode)) ;
	element2.text		=  (unescape(objCode)) ;
	formObj.fda_FirstTrimester.add(element);
	formObj.fda_SecondTrimester.add(element1);
	formObj.fda_ThridTrimester.add(element2);
}

function clearCategoryList(obj){
	var len = obj.options.length ;
	if (len>0){
		for(var i=0;i<len;i++){
			obj.remove(obj.name) ;
		}
	}
	var element = document.createElement('OPTION') ;
	element.value		=  ""  ;
	element.text		= '---'+getLabel("Common.defaultSelect.label","common")+'---' ;
	obj.add(element);
}

function loadPregnancyCategoryValues(cgCode,cCode1,cCode2,cCode3){ //used to load the values based upon the mode
	var mode = f_tab_detail.document.drugMasterDetailForm.mode.value
	fdaCode = cgCode;
	fdaSrchTxt = f_tab_detail.document.drugMasterDetailForm.fdaSearch.value
	fda1 = cCode1;
	fda2 = cCode2;
	fda3 = cCode3;
	if (mode == "1" ){		
	
		enableFDA(eval("f_tab_detail.document.drugMasterDetailForm.affects_pregnancy_yn"));
		if (eval("f_tab_detail.document.drugMasterDetailForm.affects_pregnancy_yn").checked){   
			var searchText = f_tab_detail.document.drugMasterDetailForm.fdaSearch.value
		   
			if (searchText != ''){
				searchFDACategory(eval("f_tab_detail.document.drugMasterDetailForm.fdaSearch"))
				selctCategoryValues(cCode1,f_tab_detail.document.drugMasterDetailForm.fda_FirstTrimester);
				selctCategoryValues(cCode2,f_tab_detail.document.drugMasterDetailForm.fda_SecondTrimester);
				selctCategoryValues(cCode3,f_tab_detail.document.drugMasterDetailForm.fda_ThridTrimester);
			}
		}
	}
	if (mode == "2" ){
		enableFDA(eval("f_tab_detail.document.drugMasterDetailForm.affects_pregnancy_yn"));
		if (eval("f_tab_detail.document.drugMasterDetailForm.affects_pregnancy_yn").checked){
			f_tab_detail.document.drugMasterDetailForm.fdaSearch.value = f_tab_detail.document.drugMasterDetailForm.fdaCategorySearchText.value;
			
			if (f_tab_detail.document.drugMasterDetailForm.fdaSearch.value != ''){
				f_tab_detail.document.drugMasterDetailForm.fdaCategoryGroupCode.value = cgCode;
				f_tab_detail.document.drugMasterDetailForm.fdaCategorySearchCode.value = cgCode;
				trimesterSearch(cgCode);
				selctCategoryValues(cCode1,f_tab_detail.document.drugMasterDetailForm.fda_FirstTrimester);
				selctCategoryValues(cCode2,f_tab_detail.document.drugMasterDetailForm.fda_SecondTrimester);
				selctCategoryValues(cCode3,f_tab_detail.document.drugMasterDetailForm.fda_ThridTrimester);
			}
		}
	}	
}
function selctCategoryValues(cCode1,obj){
	var len = obj.options.length ;
	for(var i=0;i<parseInt(len);i++){
		if (obj.options[i].value == cCode1){
			obj.options[i].selected = true;
		}
	}
}

function checkCategoryValues(obj){

	var  searchText = obj.value;
	//eval("document.drugMasterDetailForm.fdaCategorySearchText").value = searchText;
	var fda_FirstTrimester	= document.drugMasterDetailForm.fda_FirstTrimester;
	var fda_SecondTrimester	= document.drugMasterDetailForm.fda_SecondTrimester;
	var fda_ThridTrimester	= document.drugMasterDetailForm.fda_ThridTrimester;

	if (searchText == ''){
		clearCategoryList(fda_FirstTrimester);
		clearCategoryList(fda_SecondTrimester);
		clearCategoryList(fda_ThridTrimester);
		document.drugMasterDetailForm.fdaCategoryGroupCode.value = '';	
	}
}

function searchFDACategoryCodes(obj){
	searchTextValue =  obj.value;
	list1Value = f_tab_detail.document.drugMasterDetailForm.fda_FirstTrimester.value;
	list2Value = f_tab_detail.document.drugMasterDetailForm.fda_SecondTrimester.value;
	list3Value = f_tab_detail.document.drugMasterDetailForm.fda_ThridTrimester.value;
	//	document.drugMasterDetailForm.fda_FirstTrimester.value;
	//alert(list1Value+" "+list2Value+" "+list3Value);
	searchFDACategory(escape(obj.value));
	//alert("obj.value"+f_tab_detail.document.drugMasterDetailForm.fdaCategorySearchText.value);
	//alert(list1Value+" "+list2Value+" "+list3Value);
	if ( f_tab_detail.document.drugMasterDetailForm.fdaCategorySearchText.value == searchTextValue){
		f_tab_detail.document.drugMasterDetailForm.fda_FirstTrimester.value = list1Value;
		f_tab_detail.document.drugMasterDetailForm.fda_SecondTrimester.value = list2Value;
		f_tab_detail.document.drugMasterDetailForm.fda_ThridTrimester.value = list3Value;
	}
}

function searchFDA(obj){
	
	if (obj.value != ''){	  
		searchFDACategory(f_tab_detail.document.drugMasterDetailForm.fdaSearch);
	}
	else{
		fdaSrchTxt = '';
		fdaCode = '';
		f_tab_detail.document.drugMasterDetailForm.fdaCategorySearchCode.value = '';
	}
}

function searchFDA1(obj){
	if (f_tab_detail.document.drugMasterDetailForm.fdaSearch.value  == ''){	
		//fdaCode = '';
		fdaSrchTxt = '';
	} 
	searchFDACategory(f_tab_detail.document.drugMasterDetailForm.fdaSearch);
}

function promptAlertForDrug(obj){
	if (obj.checked)
		obj.value = 'Y';
	else 
		obj.value = 'N';
}

function checkdefaultDosageBy(obj,calc_dosg_by_freq_durn_yn,strength_value,default_dosage_by){ //This function added For SKR-CRF-PHIS-003[IN028182]
	var fract_dose_appl_yn="";  
	if(obj.value != undefined)
	   fract_dose_appl_yn =obj.value;
	else
   	   fract_dose_appl_yn =obj;	
	setDefaultDosagebyOptions(fract_dose_appl_yn,calc_dosg_by_freq_durn_yn,strength_value);
	if( default_dosage_by!=undefined && default_dosage_by != ''){
	    if ( (fract_dose_appl_yn != 'N' ) && (calc_dosg_by_freq_durn_yn != 'N' ) && (strength_value != null && 	strength_value !="" && strength_value != 0  ) ) {
				drugMasterAddModifyForm.default_dosage_by.value = default_dosage_by ;				
				drugMasterAddModifyForm.default_dosage_by.disabled = false ; 				
		 }
		else {	
			drugMasterAddModifyForm.default_dosage_by.value = '' ;		
			drugMasterAddModifyForm.default_dosage_by.disabled = true ; 
		}		
	}
	else{	
		if ( (fract_dose_appl_yn != 'N' ) && (calc_dosg_by_freq_durn_yn != 'N' ) && (strength_value != null && 	strength_value !="" && strength_value != 0  )){	
			drugMasterAddModifyForm.default_dosage_by.value = 'Q' ;
			drugMasterAddModifyForm.default_dosage_by.disabled = false ;     
		}
		else {	
			drugMasterAddModifyForm.default_dosage_by.value = '' ;		
			drugMasterAddModifyForm.default_dosage_by.disabled = true ;
		}	
	}
}

function setDefaultDosagebyOptions(fract_dose_appl_yn,calc_dosg_by_freq_durn_yn,strength_value){ //This function added For SKR-CRF-PHIS-003[IN028182]
	var dosageObj = document.drugMasterAddModifyForm.default_dosage_by;
	var len =dosageObj.options.length;
	var element ;
	for(var i=0;i<len;i++) {
		dosageObj.remove("default_dosage_by") ;
	}
	if((fract_dose_appl_yn != 'N' ) && (calc_dosg_by_freq_durn_yn != 'N' ) && (strength_value != null && 	strength_value !="" && strength_value != 0  ) ) {
		element= document.createElement('OPTION') ;
		element.value		=  'Q' ;
		element.text		= getLabel("Common.Quantity.label","common"); ;
		dosageObj.add(element); 
		element= document.createElement('OPTION') ;
		element.value		=  'S' ;
		element.text		= getLabel("Common.Strength.label","common"); ;
		dosageObj.add(element); 
	}
	else{
		element= document.createElement('OPTION') ;
		element.value		=  '' ;
		element.text		= '---'+getLabel("Common.defaultSelect.label","common")+'---' ;
		dosageObj.add(element); 
	}
}
/*==========================================================================================*/
/*function checkValue() // This Function added for 32491  
{	
	var strength_value = drugMasterAddModifyForm.strength_value.value;
	var strength_uom = drugMasterAddModifyForm.strength_uom.value;	
	var strength_per_value_pres_uom_qty = drugMasterAddModifyForm.strength_per_value_pres_uom_qty.value;	
	
	if( strength_value != null && 	strength_value !="" && strength_value != 0 && strength_uom !="" ){
      	if( strength_per_value_pres_uom_qty == undefined || strength_per_value_pres_uom_qty=="" ||  strength_per_value_pres_uom_qty== 0 ){
			alert(getMessage("PH_NOT_BLANK_ZERO","PH"));
		    drugMasterAddModifyForm.strength_per_value_pres_uom_qty.focus();
		}
	}
}*/
function checkValue() // This Function added for 32491  
{	
	var strength_value = drugMasterAddModifyForm.strength_value.value;
	var strength_uom = drugMasterAddModifyForm.strength_uom.value;	
	var strength_per_value_pres_uom_qty = drugMasterAddModifyForm.strength_per_value_pres_uom_qty.value;	
	
	if( strength_value != null && strength_value != "" && strength_value != 0 && strength_uom != "" ){
      	if( strength_per_value_pres_uom_qty == undefined || strength_per_value_pres_uom_qty == "" ||  strength_per_value_pres_uom_qty == 0 ){
			alert(getMessage("PH_NOT_BLANK_ZERO", "PH"));
			drugMasterAddModifyForm.strength_per_value_pres_uom_qty.value = ''; 
			setTimeout(function() { 
				drugMasterAddModifyForm.strength_per_value_pres_uom_qty.focus();
			}, 0); 
			return; 
		}
	}
}

function CheckRemMaxLen(obj) { // added for CRF RUT-CRF-0063[29601]
	var val = "";
	//obj = document.drugMasterDetailForm.DrugEffectToPregnancy;
	val = obj.value;
	if(obj.value.length > 150) {
		var msg = getMessage("REMARKS_CANNOT_EXCEED","Common");
		msg = msg.replace("$",getLabel("ePH.DrugEffectToPregnancy.label",'PH')+" "+getLabel("Common.remarks.label",'Common'));
		msg = msg.replace("#",150);
		obj.value = val.substring(0,150);
		alert(msg);
		obj.focus();
		return false;
	} 
}

function drugEffectMand(trimster,obj) { // added for CRF RUT-CRF-0063[29601]
	var DrugEffectMandObj;
	if(trimster =='F')
		DrugEffectMandObj = document.drugMasterDetailForm.drugEffectMandF;
	if(trimster =='S')
		DrugEffectMandObj = document.drugMasterDetailForm.drugEffectMandS;
	if(trimster =='T')
		DrugEffectMandObj = document.drugMasterDetailForm.drugEffectMandT;
	if(obj.checked)
		DrugEffectMandObj.style.visibility="visible";
	else
		DrugEffectMandObj.style.visibility="hidden";
}

function displayreissuetype(obj){ //Added for Bru-HIMS-CRF-405[IN044830]-Start
	if(obj.checked==true){
		document.getElementById('lblReIssue').style.display='inline';
		document.getElementById('fldReIssue').style.display='inline';
		document.getElementById('fldReIssue_count').style.display='none';
		document.getElementById('fldReIssue_count_text').style.display='none';
	  	if(document.drugMasterAddModifyForm.reissue_type_ind.options(document.drugMasterAddModifyForm.reissue_type_ind.selectedIndex).value=="F"){
			if(document.drugMasterAddModifyForm.reissue_count_by_ind.options(document.drugMasterAddModifyForm.reissue_count_by_ind.selectedIndex).value=="Q"){
				document.getElementById('fldReIssue_desc_q').style.display='inline';
			}
			else{
				document.getElementById('fldReIssue_desc_t').style.display='inline';
			}
		}
	}
	else{
		document.getElementById('lblReIssue').style.display='none';
		document.getElementById('fldReIssue').style.display='none';
		document.getElementById('fldReIssue_count').style.display='none';
		document.getElementById('fldReIssue_count_text').style.display='none';
		document.getElementById('fldReIssue_desc_q').style.display='none';
		document.getElementById('fldReIssue_desc_t').style.display='none';
		var element ;
		var reissue_type_ind_obj = document.drugMasterAddModifyForm.reissue_type_ind;
		var len =reissue_type_ind_obj.options.length;
		for(var i=0;i<len;i++) {
			reissue_type_ind_obj.remove("reissue_type_ind") ;
		}
		 element= document.createElement('OPTION') ;
		 element.value		=  'R' ;
		 element.text		= getLabel("ePH.NoRestriction.label","ph"); ;
		 reissue_type_ind_obj.add(element);
		 element1= document.createElement('OPTION') ;
		 element1.value		=  'F' ;
		 element1.text		= getLabel("Common.Fixed.label","common");
		 reissue_type_ind_obj.add(element1);
		 element2			= document.createElement('OPTION') ;
		 element2.value		=  'V' ;
		 element2.text		= getLabel("Common.Variable.label","common");
		 reissue_type_ind_obj.add(element2);
	}
}

function setselectedreissue(obj){
	if(obj.value=="F"){
		document.getElementById('lblReIssue').style.display='inline';
		document.getElementById('fldReIssue').style.display='inline';
		document.getElementById('fldReIssue_count').style.display='inline';
		document.getElementById('fldReIssue_count_text').style.display='inline';
		document.getElementById('reissue_count').value="";
		if(document.drugMasterAddModifyForm.reissue_count_by_ind.options(document.drugMasterAddModifyForm.reissue_count_by_ind.selectedIndex).value=="Q"){
			document.getElementById('fldReIssue_desc_q').style.display='inline';
		}
		else{
			document.getElementById('fldReIssue_desc_t').style.display='inline';
		}
	}
	else{
		document.getElementById('lblReIssue').style.display='inline';
		document.getElementById('fldReIssue').style.display='inline';
		document.getElementById('fldReIssue_count').style.display='none';
		document.getElementById('fldReIssue_count_text').style.display='none';
		document.getElementById('fldReIssue_desc_q').style.display='none';
		document.getElementById('fldReIssue_desc_t').style.display='none';
	}
}

function setDefaultReIssueOptions(reissue_type_ind,reissue_count_by_ind){
	var reissue_type_ind_obj = document.drugMasterAddModifyForm.reissue_type_ind;
	var reissue_count_by_ind_obj = document.drugMasterAddModifyForm.reissue_count_by_ind;
	var len =reissue_type_ind_obj.options.length;
	var len1 =reissue_count_by_ind_obj.options.length;
	var formObj=document.drugMasterAddModifyForm;
	var reissue_yn=formObj.disp_against_damage_yn.value;
	if(reissue_yn=="N"){
		document.getElementById('lblReIssue').style.display='none';
		document.getElementById('fldReIssue').style.display='none';
		document.getElementById('fldReIssue_count').style.display='none';
		document.getElementById('fldReIssue_count_text').style.display='none';
	}

	var element ;
	for(var i=0;i<len;i++) {
		reissue_type_ind_obj.remove("reissue_type_ind") ;
	}
	for(var j=0;j<len1;j++) {
		reissue_count_by_ind_obj.remove("reissue_count_by_ind") ;
	}
	if(reissue_type_ind=="R"){
		element= document.createElement('OPTION') ;
		element.value		=  'R' ;
		element.text		= getLabel("ePH.NoRestriction.label","ph"); ;
		reissue_type_ind_obj.add(element);
		element1= document.createElement('OPTION') ;
		element1.value		=  'F' ;
		element1.text		= getLabel("Common.Fixed.label","common");
		reissue_type_ind_obj.add(element1);
		element2			= document.createElement('OPTION') ;
		element2.value		=  'V' ;
		element2.text		= getLabel("Common.Variable.label","common");
		reissue_type_ind_obj.add(element2);
		document.getElementById('fldReIssue_count').style.display='none';
		document.getElementById('fldReIssue_count_text').style.display='none';
		document.getElementById('fldReIssue_desc_q').style.display='none';
		document.getElementById('fldReIssue_desc_t').style.display='none';
	}
	else if(reissue_type_ind=="F"){
		element= document.createElement('OPTION') ;
		element.value		=  'F' ;
		element.text		= getLabel("Common.Fixed.label","common");
		reissue_type_ind_obj.add(element);
		element1			= document.createElement('OPTION') ;
		element1.value		=  'V' ;
		element1.text		= getLabel("Common.Variable.label","common");
		reissue_type_ind_obj.add(element1);
		element2= document.createElement('OPTION') ;
		element2.value		=  'R' ;
		element2.text		= getLabel("ePH.NoRestriction.label","ph"); ;
		reissue_type_ind_obj.add(element2);
	}
	else if(reissue_type_ind=="V"){
		element= document.createElement('OPTION') ;
		element.value       =  'V'
		element.text		= getLabel("Common.Variable.label","common");
		reissue_type_ind_obj.add(element); 
		element1= document.createElement('OPTION') ;
		element1.value		=  'F' ;
		element1.text		= getLabel("Common.Fixed.label","common");
		reissue_type_ind_obj.add(element1);
		element2= document.createElement('OPTION') ;
		element2.value		=  'R' ;
		element2.text		= getLabel("ePH.NoRestriction.label","ph"); ;
		reissue_type_ind_obj.add(element2);
		document.getElementById('fldReIssue_count').style.display='none';
		document.getElementById('fldReIssue_count_text').style.display='none';
		document.getElementById('fldReIssue_desc_q').style.display='none';
		document.getElementById('fldReIssue_desc_t').style.display='none';
	}
	else{
		element= document.createElement('OPTION') ;
		element.value		=  'R' ;
		element.text		= getLabel("ePH.NoRestriction.label","ph"); ;
		reissue_type_ind_obj.add(element);
		element1= document.createElement('OPTION') ;
		element1.value		=  'F' ;
		element1.text		= getLabel("Common.Fixed.label","common");
		reissue_type_ind_obj.add(element1);
		element2			= document.createElement('OPTION') ;
		element2.value		=  'V' ;
		element2.text		= getLabel("Common.Variable.label","common");
		reissue_type_ind_obj.add(element2);
		document.getElementById('fldReIssue_count').style.display='none';
		document.getElementById('fldReIssue_count_text').style.display='none';
		document.getElementById('fldReIssue_desc_q').style.display='none';
		document.getElementById('fldReIssue_desc_t').style.display='none'
	}
	if(reissue_count_by_ind=="Q" && reissue_type_ind=="F"){
		element= document.createElement('OPTION') ;
		element.value		=  'Q' ;
		element.text		= getLabel("ePH.NoofQuantity.label","ph"); ;
		reissue_count_by_ind_obj.add(element);
		element1= document.createElement('OPTION') ;
		element1.value		=  'C' ;
		element1.text		= getLabel("ePH.NoofTimes.label","ph");
		reissue_count_by_ind_obj.add(element1);
		document.getElementById('fldReIssue_desc_q').style.display='inline';
	}
	else if(reissue_count_by_ind=="C" && reissue_type_ind=="F"){
		element= document.createElement('OPTION') ;
		element.value		=  'C' ;
		element.text		= getLabel("ePH.NoofTimes.label","ph"); ;
		reissue_count_by_ind_obj.add(element);
		element1= document.createElement('OPTION') ;
		element1.value		=  'Q' ;
		element1.text		= getLabel("ePH.NoofQuantity.label","ph");
		reissue_count_by_ind_obj.add(element1);
		document.getElementById('fldReIssue_desc_t').style.display='inline';
	}
	else{
		element= document.createElement('OPTION') ;
		element.value		=  'Q' ;
		element.text		= getLabel("ePH.NoofQuantity.label","ph"); ;
		reissue_count_by_ind_obj.add(element);
		element1= document.createElement('OPTION') ;
		element1.value		=  'C' ;
		element1.text		= getLabel("ePH.NoofTimes.label","ph");
		reissue_count_by_ind_obj.add(element1);
		if(reissue_type_ind=="F")
			document.getElementById('fldReIssue_desc_q').style.display='inline';
	}
}

function assignselectedType(){
	if(document.drugMasterAddModifyForm.reissue_count_by_ind.options(document.drugMasterAddModifyForm.reissue_count_by_ind.selectedIndex).value=="Q"){
		document.getElementById('fldReIssue_desc_q').style.display='inline';
		document.getElementById('fldReIssue_desc_t').style.display='none';
	}
	else{
		document.getElementById('fldReIssue_desc_t').style.display='inline';
		document.getElementById('fldReIssue_desc_q').style.display='none';
	}
}

function updateReIssueCount(obj){
	parent.frames[0].document.drugMasterMainForm.reissue_count.value=obj.value;
}

function updateReIssueType(){
	parent.frames[0].document.drugMasterMainForm.reissue_type.value=parent.frames[2].frames[1].document.drugMasterAddModifyForm.reissue_type_ind.value
}
function validatereissueCount(obj){
	if(obj.value==0 || obj.value==""){
		alert(getMessage("PH_NOFQTY_NOCOUNT","PH"));
		document.drugMasterAddModifyForm.reissue_count.select();
		document.drugMasterAddModifyForm.reissue_count.focus();
	}
}//Added for Bru-HIMS-CRF-405[IN044830]-End
//Adding start for ML-MMOh-CRF-1223
function validateDefaultInfuseOver(formObj,obj,hour,row_no){
	//alert("obj==="+obj.value+"hour==="+hour.value+"row_no=="+row_no);
	var tot;
	var hr = hour.value;
	var mi = obj.value;
	var minTohour;
	if(obj.value>59){
		alert(getMessage("INVALID_TIME_MINUTE","PH"));
		obj.select();
		obj.focus();
	}
	else{
		if(hr == "" )
			hr = 0;
		if(mi == "" )
			mi = 0;
		tot = parseFloat(hr*60)+parseFloat(mi);
		minTohour = parseFloat(tot/60);
		minTohour = Math.round(minTohour*100)/100;
		eval("formObj.deflt_infuse_over_value"+row_no).value=minTohour;
	}
}

 function getHrsMinStrInfuseOver(formObj,HMvalue,row_no){
	 var hrs = Math.floor(HMvalue);
	 HMvalue = HMvalue * 60;
	 var min = HMvalue % 60;
	 var temp_hrs =Math.floor(hrs);
	 var temp_min =Math.round(min);
	 
	 if(temp_min === 0){
		 temp_min ="00";
	 }
	 if(temp_hrs === 0){
		 temp_hrs ="00";
	 }

	 eval("formObj.deflt_infuse_over_value_hrs"+row_no).value=temp_hrs;
	 eval("formObj.deflt_infuse_over_value_mins"+row_no).value= temp_min;
	
 }
 //Adding end for ML-MMOH-CRF-1223
 
 //Added for MMS-DM-CRF-0177
 function validateDrugSearchBy(obj){
	 if(obj.value=='G'){
		return true;
		}
	 else if(obj.value=='T'){
		 return true;
		 }
	 }
 //Added for MMS-DM-CRF-0177
function checkSplChars(obj)	{//Adding start for TH-KW-CRF-0008
	if(!CheckChars(obj))	{
		alert(getMessage("SPECIAL_CHARCTERS_NOT_ALLOWED","PH"));
		obj.select();
	}
}//Adding end for TH-KW-CRF-0008

function chkAntiMicrobials(formObj, obj){ //KDAH-CRF-0610

	if(obj.checked==true){
		obj.value = "Y";
		formObj.rest_anti_justform_duration.disabled=false;
		document.drugMasterDetailForm.restricted_antimicrobials.style.visibility="visible";
}
	else{
		obj.value = "N";
		formObj.rest_anti_justform_duration.value="";
		formObj.rest_anti_justform_duration.disabled=true;	
		document.drugMasterDetailForm.restricted_antimicrobials.style.visibility="hidden";
	}  

} //KDAH-CRF-0610


function checkZero(obj) {//KDAH-CRF-0610
if(obj.value!=null && obj.value=="0")
	obj.value = "";
}//KDAH-CRF-0610


