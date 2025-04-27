/*
---------------------------------------------------------------------------------------------------------
Date			Edit History    	Name			Rev. Date		Rev. By			Description
---------------------------------------------------------------------------------------------------------
31/3/2021		TFS:15977			Shazana											NMC-JD-SCF-0160
---------------------------------------------------------------------------------------------------------
*/

var rowno_inventory		=	parseInt(0);
var rowno_trade			=	parseInt(0);
var rowno_generic		=	parseInt(0);
var max_disp			=	parseInt(0);

function addDetail(frmObj,obj)	{
	if((frmObj.link.value=="trade_tab"&&frmObj.trade_name.value!="")||(frmObj.link.value=="generic_tab"&&frmObj.generic_name.value!="")||(frmObj.link.value=="weightrecording_tab"&&frmObj.agegroup_id.value!="")){
		if(obj.value==getLabel("Common.delete.label","Common"))	{
			delete_record(frmObj);
		} 
		else if(checkMandatoryFields())	{
			if(obj.value==getLabel("Common.Add.label","Common")){
				submitCurrentForm(frmObj);
			}
			else if(obj.value==getLabel("Common.Modify.label","Common")){
				submitCurrentFormUpdate(frmObj);
			}
		}
	}
}

function updateInventory(size){
	rowno_inventory=size;
}

function updateTradeNames(size){
	rowno_trade=size;
}

function updateGenericNames(size){
	rowno_generic=size;
}

function clearFields(frmObj)	{
	if(frmObj.link.value=="inventory_tab"){
		frmObj.item_code.value					=	"";
		frmObj.item_desc.value					=	"";
		frmObj.stock_uom_code.value				=	"";
		frmObj.stock_uom_desc.value				=	"";
		frmObj.content_in_pres_base_uom.value	=	"";
		frmObj.content_in_strength_uom.value	=	"";
		//frmObj.inventory_item_code.focus();
	}
	else if(frmObj.link.value=="trade_tab"){
		frmObj.trade_name.value			=	"";
		frmObj.trade_id.value			=	"";
		frmObj.manufacturer_name.value	=	"";
		frmObj.manufacturer_id.value	=	"";
		frmObj.disp_seq_no.value	=	"";
	}
	else if(frmObj.link.value=="generic_tab"){
		frmObj.generic_name.value			=	"";
		frmObj.disp_seq_no.value			=	"";
	}
	else if(frmObj.link.value=="weightrecording_tab"){
		frmObj.min_age.value				=	"";
		frmObj.age_unit.value				=   "";
		frmObj.max_age.value				=   "";
		frmObj.gender.value					=	"";
		frmObj.short_desc.value				=	"";
		frmObj.age_group_code.value			=   "";
		frmObj.disp_seq_no.value			=	"";
	}
}

function findDuplicate(chk_fld,max_rows,frm,ext_fld){
	var chk_fld	=	chk_fld;
	var ext_fld	=	ext_fld;

	if(max_rows>=1){
		for(var i=0;i<max_rows;i++){
			old_text=f_detail.document.getElementById("detail").rows[i].cells(0).children[1].value;
			if(chk_fld==old_text){
				alert(getMessage("DUPLICATE_NOT_ALLOWED","PH"));
				return false;
			}
		}
	}
	return true;
}

function getDrugClass(generic_id){

	var bean_id		=	parent.f_tab_detail.f_add_modify.document.drugMasterAddModifyForm.bean_id.value;
	var bean_name	=	parent.f_tab_detail.f_add_modify.document.drugMasterAddModifyForm.bean_name.value;

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
	return true;
}

function setDrugClass(DrugClass)	{
	parent.f_tab_detail.f_add_modify.document.drugMasterAddModifyForm.drug_class.value=DrugClass;
}

function callModify(rowno)	{
	var row	=	parseInt(rowno);
	var rowobj	=	f_detail.document.getElementById("detail").rows(row);
	var frmObj	=	f_add_modify.document.drugMasterAddModifyForm;
	var frmObj1	=	f_detail.document.forms[0];
	if(frmObj.link.value=="inventory_tab"){
		frmObj.item_code.value					=	rowobj.cells(0).children[1].value;
		frmObj.item_desc.value					=	rowobj.cells(0).innerText;
		frmObj.stock_uom_code.value				=	rowobj.cells(1).innerText;
		frmObj.stock_uom_desc.value				=	rowobj.cells(1).children[1].value;
		var base_strength						=	rowobj.cells(2).innerText;
		var base_and_strength					=	base_strength.split("/");
		frmObj.content_in_pres_base_uom.value	=	base_and_strength[0];
		frmObj.content_in_strength_uom.value	=	base_and_strength[1];
		frmObj.flag.value						=	rowobj.cells(3).children[0].value;

		frmObj.add_butt.style.display	="none";
		if(frmObj.mode.value==MODE_MODIFY)
			frmObj.del_butt.style.visibility="visible";
	}
	else if(frmObj.link.value=="trade_tab"){
		frmObj.trade_id.value			=	rowobj.cells(0).children[1].value;
		frmObj.trade_name.value			=	rowobj.cells(0).innerText;
		frmObj.manufacturer_id.value	=	rowobj.cells(1).children[0].value;
		frmObj.manufacturer_name.value	=	rowobj.cells(1).innerText;
		frmObj.disp_seq_no.value		=	rowobj.cells(2).innerText;
		frmObj.flag.value				=	rowobj.cells(3).children[0].value;
		frmObj.add_butt.value			=	getLabel("Common.Modify.label","Common");
		if(frmObj.mode.value==MODE_MODIFY)
			frmObj.del_butt.style.visibility="visible";
	}
	else if(frmObj.link.value=="generic_tab"){
		if(frmObj.mode.value==MODE_MODIFY)	{
			frmObj.generic_name.disabled	=	true;
			frmObj.generic_search.disabled	=	true;
			frmObj.disp_seq_no.focus();
			frmObj.del_butt.style.visibility="visible";
		}
		frmObj.generic_id.value			=	eval("frmObj1.generic_id"+rowno+".value")
		frmObj.generic_name.value		=	eval("frmObj1.generic_name"+rowno+".value")
		frmObj.drug_class.value			=	eval("frmObj1.drug_class"+rowno+".value")
		frmObj.disp_seq_no.value		=	eval("frmObj1.disp_seq_no"+rowno+".value")
		frmObj.flag.value				=	eval("frmObj1.flag"+rowno+".value")
		frmObj.add_butt.value			=	getLabel("Common.Modify.label","Common");
	}
	frmObj.curr_row.value=rowno;
}

function checkMandatoryFields()	{
	var formObj			= parent.frames[0].document.drugMasterMainForm ;
	var messageFrame	=	parent.parent.messageFrame;
	
	var fields = new Array ( formObj.drug_code, formObj.drug_desc, formObj.generic_name, formObj.form_code, formObj.route_code);
	var names = new Array ( getLabel("ePH.DrugDescription.label","PH"),  getLabel("ePH.DrugDescription.label","PH"), getLabel("Common.GenericName.label","Common"), getLabel("ePH.Form.label","PH"),getLabel("ePH.DefaultRoute.label","PH"));

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

function callReset()	{
	frmObj	=		f_add_modify.document.drugMasterAddModifyForm;
	frmObj.reset();
	frmObj.add_butt.style.display	="inline";
	frmObj.add_butt.style.visibility="visible";
	frmObj.add_butt.value=getLabel("Common.Add.label","Common");
	frmObj.del_butt.style.visibility="hidden";
}

async function searchGenericNameforGeneric(obj){
	var argumentArray  = new Array() ;
	var dataNameArray  = new Array() ;
	var dataValueArray = new Array() ;
	var dataTypeArray  = new Array() ;
	var sql_ph_drug_select14 = "SELECT A.GENERIC_ID code,A.GENERIC_NAME description FROM PH_GENERIC_NAME_LANG_VW A WHERE  upper(A.GENERIC_ID) like upper(?) AND upper(A.GENERIC_NAME) like upper(?) AND A.EFF_STATUS='E' AND A.LANGUAGE_ID = '"+parent.f_tab_detail.f_add_modify.document.drugMasterAddModifyForm.language_id.value+"' ";//15977 START
	argumentArray[0]   = sql_ph_drug_select14; 
	//argumentArray[0]   = parent.f_tab_detail.f_add_modify.document.drugMasterAddModifyForm.sql_ph_drug_select14.value+"'"+parent.f_tab_detail.f_add_modify.document.drugMasterAddModifyForm.language_id.value+"'";//15977 END
	argumentArray[0]   = sql_ph_drug_select14;
	argumentArray[1]   = dataNameArray ;
	argumentArray[2]   = dataValueArray ;
	argumentArray[3]   = dataTypeArray ;
	argumentArray[4]   = "1,2";
	argumentArray[5]   = parent.f_tab_detail.f_add_modify.document.drugMasterAddModifyForm.generic_name.value ;
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
		parent.f_tab_detail.f_add_modify.document.drugMasterAddModifyForm.generic_name.value = arr[1] ;
		parent.f_tab_detail.f_add_modify.document.drugMasterAddModifyForm.generic_id.value = arr[0];
		//obj.disabled=true;
		parent.f_tab_detail.f_add_modify.document.drugMasterAddModifyForm.disp_seq_no.value	=
		parseInt(parent.f_tab_detail.f_add_modify.document.drugMasterAddModifyForm.max_val.value)+5;
	}
}

async function searchTradeName(obj){
	
	var argumentArray  = new Array() ;
	var dataNameArray  = new Array() ;
	var dataValueArray = new Array() ;
	var dataTypeArray  = new Array() ;
	
	dataNameArray[0]   = "ITEM_CODE" ;
    dataValueArray[0]  = parent.drugMasterMain.drugMasterMainForm.drug_code.value;;
    dataTypeArray[0]   = STRING ;
    var sql_ph_drug_select19=  "SELECT A.TRADE_ID code,A.SHORT_NAME description FROM AM_TRADE_NAME_LANG_VW A, MM_TRADE_NAME_FOR_ITEM B WHERE ITEM_CODE like ? AND A.TRADE_ID = B.TRADE_ID AND A.EFF_STATUS='E' and drug_yn = 'Y' AND upper(A.TRADE_ID) like upper(?) AND upper(A.SHORT_NAME) like upper(?) AND A.LANGUAGE_ID ='"+parent.f_tab_detail.f_add_modify.document.drugMasterAddModifyForm.language_id.value+"' ";//15977 START
	argumentArray[0]   = sql_ph_drug_select19 ;
	//argumentArray[0]   = parent.f_tab_detail.f_add_modify.document.drugMasterAddModifyForm.sql_ph_drug_select19.value+"'"+parent.f_tab_detail.f_add_modify.document.drugMasterAddModifyForm.language_id.value+"'";//15977 END
	argumentArray[1]   = dataNameArray ;
	argumentArray[2]   = dataValueArray ;
	argumentArray[3]   = dataTypeArray ;
	argumentArray[4]   = "2,3";
	argumentArray[5]   = parent.f_tab_detail.f_add_modify.document.drugMasterAddModifyForm.trade_name.value ;
	argumentArray[6]   = DESC_LINK ;
	argumentArray[7]   = DESC_CODE ;
	retVal = await CommonLookup( getLabel("Common.TradeName.label","Common"), argumentArray );
	var ret1=unescape(retVal);
		 	var arr=ret1.split(",");
		 	if(arr[1]==undefined) 
	 		{
		 		arr[0]="";	
		 		arr[1]="";	
	 		}
	
	var ret1=unescape(retVal);
		 	var arr=ret1.split(",");
		 	if(arr[1]==undefined) 
	 		{
		 		arr[0]="";	
		 		arr[1]="";	
	 		}
	if(retVal != null && retVal != "" )  {
		parent.f_tab_detail.f_add_modify.document.drugMasterAddModifyForm.trade_name.value = arr[1] ;
		parent.f_tab_detail.f_add_modify.document.drugMasterAddModifyForm.trade_id.value = arr[0];
	}
	searchDescription(arr[0]);
}

function searchDescription(code,objsrc){
	if(objsrc==undefined || objsrc=="" || objsrc==null)
	objsrc="";
	if(objsrc=="")	{
		var bean_id		=	parent.f_tab_detail.f_add_modify.document.drugMasterAddModifyForm.bean_id.value;
		var bean_name	=	parent.f_tab_detail.f_add_modify.document.drugMasterAddModifyForm.bean_name.value;
		var link		=	parent.f_tab_detail.f_add_modify.document.drugMasterAddModifyForm.link.value;
	} 
	else	{
		var bean_id		=	parent.drugMasterMain.drugMasterMainForm.bean_id.value;
		var bean_name	=	parent.drugMasterMain.drugMasterMainForm.bean_name.value;
		var link		=	"inventory_tab";
	}

	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest() ;
	var xmlStr ="<root><SEARCH ";
	xmlStr += " code=\""+code+"\"";
	xmlStr += " bean_id=\""+bean_id+"\"";
	xmlStr += " bean_name=\""+bean_name+"\"";
	xmlStr +=" /></root>";
	xmlDoc.async = "false";
    xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");

	if(link=="trade_tab"){
		xmlHttp.open("POST","DrugMasterValidation.jsp?func_mode=searchManufacturer",false);
	}
	else if(link=="inventory_tab" && objsrc!="")
	xmlHttp.open("POST","DrugMasterValidation.jsp?func_mode=searchForInventoryItem",false);
    xmlHttp.send(xmlDoc);
	eval(xmlHttp.responseText);
}

function setManufacturerName(manufacturer_detail)	{
	var va=decodeURIComponent(manufacturer_detail,"UTF-8");
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
	
	manufacturer_detail =va;
	var manufacturer1=decodeURIComponent(manufacturer_detail);
	 //manufacturer1=decodeURIComponent(manufacturer_detail);
	var manufacturer = manufacturer1.split(":");
	parent.f_tab_detail.f_add_modify.document.drugMasterAddModifyForm.manufacturer_id.value = manufacturer[0];
	parent.f_tab_detail.f_add_modify.document.drugMasterAddModifyForm.manufacturer_name.value =decodeURIComponent(manufacturer[1]);
	parent.f_tab_detail.f_add_modify.document.drugMasterAddModifyForm.disp_seq_no.value=
	parseInt(parent.f_tab_detail.f_add_modify.document.drugMasterAddModifyForm.max_val.value)+5;
}

function setItemDescription(item_detail)	{
	var item	=	item_detail.split(":");
	parent.f_tab_detail.f_add_modify.document.drugMasterAddModifyForm.stock_uom_code.value = item[0];
	parent.f_tab_detail.f_add_modify.document.drugMasterAddModifyForm.stock_uom_desc.value = item[1] ;
	strength	=	parent.parent.f_query_add_mod.drugMasterMain.document.drugMasterMainForm.base_unit_code.value;
	code		=	parent.parent.f_query_add_mod.drugMasterMain.document.drugMasterMainForm.base_unit_desc.value;
	parent.f_tab_detail.f_add_modify.document.drugMasterAddModifyForm.content_in_strength_uom.value=strength;

	if(strength!="" && code!="")	{

		if(item[0]!=code)	{
			var bean_id		=	parent.f_tab_detail.f_add_modify.document.drugMasterAddModifyForm.bean_id.value;
			var bean_name	=	parent.f_tab_detail.f_add_modify.document.drugMasterAddModifyForm.bean_name.value;

			var xmlDoc = "" ;
			var xmlHttp = new XMLHttpRequest() ;
			var xmlStr ="<root><SEARCH ";
			xmlStr += " uom_code=\""+item[0]+"\"";
			xmlStr += " eqvl_uom_code=\""+code+"\"";
			xmlStr += " bean_id=\""+bean_id+"\"";
			xmlStr += " bean_name=\""+bean_name+"\"";
			xmlStr +=" /></root>";
			xmlDoc.async = "false";
			xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
			xmlHttp.open("POST","DrugMasterValidation.jsp?func_mode=inventoryPackSize",false);
			xmlHttp.send(xmlDoc);
			eval(xmlHttp.responseText);
		}
		else	{
			parent.f_tab_detail.f_add_modify.document.drugMasterAddModifyForm.content_in_pres_base_uom.value="1";
		}
	}
}

function assignInventoryPackSize(value)	{
	if(value!="")	{
		parent.f_tab_detail.f_add_modify.document.drugMasterAddModifyForm.content_in_pres_base_uom.value = value;
		parent.parent.f_query_add_mod.drugMasterMain.document.drugMasterMainForm.base_unit_status.value ="disabled";
	}
	else{
			alert(getMessage("PH_CONV_FACTOR_NOT_DEF","PH"));
		clearFields(parent.f_tab_detail.f_add_modify.document.drugMasterAddModifyForm);
	}
}

async function searchItemDescription(obj,objsrc){
	base_unit	=	parent.parent.f_query_add_mod.drugMasterMain.document.drugMasterMainForm.pres_base_uom_ref.value;
	if(base_unit=="")	{
		alert(getMessage("BASE_UNIT_CANNOT_BE_BLANK","PH"));
		return false;
	}

	var argumentArray  = new Array() ;
	var dataNameArray  = new Array() ;
	var dataValueArray = new Array() ;
	var dataTypeArray  = new Array() ;
	argumentArray[0]   = parent.f_tab_detail.f_add_modify.document.drugMasterAddModifyForm.sql_ph_drug_select25.value+"'"+parent.parent.f_query_add_mod.drugMasterMain.document.drugMasterMainForm.language_id.value+"'";
	argumentArray[1]   = dataNameArray ;
	argumentArray[2]   = dataValueArray ;
	argumentArray[3]   = dataTypeArray ;
	argumentArray[4]   = "1,2";
	argumentArray[5]   = parent.f_tab_detail.f_add_modify.document.drugMasterAddModifyForm.item_desc.value ;
	argumentArray[6]   = DESC_LINK ;
	argumentArray[7]   = DESC_CODE ;
	retVal = await CommonLookup( "", argumentArray );
	var ret1=unescape(retVal);
		 	var arr=ret1.split(",");
		 	if(arr[1]==undefined) 
	 		{
		 		arr[0]="";	
		 		arr[1]="";	
	 		}
	if(retVal != null && retVal != "" )  {
		parent.f_tab_detail.f_add_modify.document.drugMasterAddModifyForm.item_desc.value = arr[1] ;
		parent.f_tab_detail.f_add_modify.document.drugMasterAddModifyForm.item_code.value = arr[0];
	}
	searchDescription(retVal[0],objsrc);
}


function delete_record(frmObj)	{
	var bean_id		=	frmObj.bean_id.value;
	var bean_name	=	frmObj.bean_name.value;
	var link		=	frmObj.link.value;
	var code		=	"";
	if(link=="generic_tab")	{
		code	=		frmObj.generic_id.value;
	}
	
	else if(link=="inventory_tab")	{
		code	=		frmObj.item_code.value;
	}

	if( confirm(parent.drugMasterMain.getMessage("DELETE_RECORD","Common") ))	{
		if(code!="")	{
			var xmlDoc = "" ;
			var xmlHttp = new XMLHttpRequest() ;
			var xmlStr ="<root><SEARCH ";
			xmlStr += " link=\""+link+"\"";
			xmlStr += " code=\""+code+"\"";
			xmlStr += " bean_id=\""+bean_id+"\"";
			xmlStr += " bean_name=\""+bean_name+"\"";
			xmlStr +=" /></root>";
			xmlDoc.async = "false";
			xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
			xmlHttp.open("POST","DrugMasterValidation.jsp?func_mode=delete",false);
			xmlHttp.send(xmlDoc);
			eval(xmlHttp.responseText);
		}
	}
}

function refreshParentTab(link)	{
	var formObj	=	parent.f_drug_tabs.document.all;
	if(link=="generic_tab")	{
		formObj.generic_tab.click();
	}
	else if(link=="trade_tab")	{
		formObj.trade_tab.click();
	}
	else if(link=="inventory_tab")	{
		formObj.inventory_tab.click();
	}
	else if(link=="weightrecording_tab")	{
		formObj.weightrecording_tab.click();
	}
}

function checkMultiStrength(obj,frmObj)	{
	if(obj.checked==true)	{
	//	frmObj.disp_multi_strength_yn.checked=true; //commented for ghl-crf-0548
	//	frmObj.disp_multi_strength_yn.value	="Y";//commented for ghl-crf-0548
		frmObj.disp_multi_strength_yn.disabled=false;//true changed to false for ghl-crf-0548
	}
	else	{
		//frmObj.disp_multi_strength_yn.checked=false;//commented for ghl-crf-0548
		//frmObj.disp_multi_strength_yn.value	="N";//commented for ghl-crf-0548
	//added for ghl-crf-0548 start
		var strengt_type=frmObj.disp_multi_strength_yn.value;
		if(strengt_type=="S"){
			frmObj.disp_multi_strength_yn.selectedIndex=1;
	if(frmObj.disp_multi_strength_yn.value=="S"){
	frmObj.disp_multi_strength_yn.selectedIndex=0;
	}

		}
			//added for ghl-crf-0548 end
		frmObj.disp_multi_strength_yn.disabled=true;//false changed to true for ghl-crf-0548
	}
}

function checkStrengthValue(frmObj)	{
	if(parent.drugMasterMain.document.drugMasterMainForm.multi_strength_status.value=="Y") {
		frmObj.disp_multi_strength_yn.disabled=false;//true changed to false for ghl-crf-0548
		//frmObj.disp_multi_strength_yn.value="N";//commented for ghl-crf-0548
		frmObj.disp_by_alt_form_yn.disabled=true;
		frmObj.disp_by_alt_form_yn.value="N";
	}
}

function checkDispAuthRequired(frmObj)	{
var auth_val	=	parent.drugMasterMain.document.drugMasterMainForm.disp_auth_reqd_yn.value;
	if(auth_val=="Y")	{
		frmObj.disp_auth_reqd_yn.checked	=	true;
		frmObj.disp_auth_reqd_yn.value		=	"Y";
		frmObj.disp_auth_reqd_yn.disabled	=	true;
	}
	else	{
		frmObj.disp_auth_reqd_yn.checked	=	false;
		frmObj.disp_auth_reqd_yn.value		=	"N";
		frmObj.disp_auth_reqd_yn.disabled	=	false;
	}
}

function validateInfuseOver(frmObj)	{
	if(frmObj.iv_fluid_yn.checked==false)	{
		frmObj.infuse_over_value_hrs.value				=	"";
		frmObj.infuse_over_value_mins.value				=	"";
	//	frmObj.infuse_over_durn_type.selectedIndex	=	0;
		frmObj.infuse_over_value_hrs.disabled			= true;
		frmObj.infuse_over_value_mins.disabled			= true;
		//frmObj.infuse_over_durn_type.disabled		= true;
		frmObj.infuse_img.style.visibility			='hidden';
		frmObj.cyto_toxic_yn.checked				=	false;
		frmObj.cyto_toxic_yn.disabled				=	true;
	}
	else	{
		frmObj.infuse_over_value_hrs.disabled		= false;
		frmObj.infuse_over_value_mins.disabled		= false;
	//	frmObj.infuse_over_durn_type.disabled = false;
		if(frmObj.iv_ingredient_yn.checked==false)
		frmObj.cyto_toxic_yn.disabled		=	false;
	}
}

function updateLink(link)	{
	parent.drugMasterMain.drugMasterMainForm.link.value=link;
}

function drugMain(obj)	{
	if(obj.value!="")	{
		parent.drugMasterMain.drugMasterMainForm.drug_cat_code=obj.value;
	}
}

function updateDispNo(dispno)	{
	max_disp	=	parseInt(dispno);
}

function submitCurrentForm(frmObj)	{
	var tade_id="";
	link	=	frmObj.link.value;

	var xmlDoc="";
	var xmlHttp = new XMLHttpRequest();
	var arrObj = frmObj.elements;
	//alert(frmObj.name);
	var frmObjs = new Array()
	if(frmObj.name == null)
		frmObjs = frmObj
	else frmObjs[0] = frmObj

	var xmlStr ="<root><SEARCH ";

	for(var frmCount=0; frmCount<frmObjs.length; frmCount++) {
		frmObj = frmObjs[frmCount]
		var arrObj = frmObj.elements;

		for(var i=0;i<arrObj.length;i++) {
			var val = "" ;
			if(arrObj[i].type == "checkbox") {
				if(arrObj[i].checked)	{
					arrObj[i].value="Y";
					val = arrObj[i].value;
				}
				else{
					arrObj[i].value="N";
					val = arrObj[i].value;
				}
			}
			else if(arrObj[i].type == "radio") {
				if(arrObj[i].checked)
					val = arrObj[i].value;
			}
			else if(arrObj[i].type == "select-multiple" ){
				for(var j=0; j<arrObj[i].options.length; j++){
					if(arrObj[i].options[j].selected)
						val+=arrObj[i].options[j].value +"~"
				}
				val= val.substring(0,val.lastIndexOf('~'))
			}
			else
				val = arrObj[i].value;

			val = checkSpl( val ) ;

			xmlStr+= arrObj[i].name+"=\"" + val + "\" " ;			
			if(link=='trade_tab' && arrObj[i].name=='trade_id' ){
			
				tade_id=val;
			}
		}
	}
	xmlStr +=" /></root>";
	//alert(xmlStr);
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	if(link=='trade_tab'){
		if(tade_id!=""){
			xmlHttp.open("POST","DrugMasterValidation.jsp?func_mode="+link,false);
			xmlHttp.send(xmlDoc);
			eval(xmlHttp.responseText );
			if(frmObj.add_butt.value==getLabel("Common.Add.label","Common"))
				clearFields(frmObj);
		}
	}
	else{
		xmlHttp.open("POST","DrugMasterValidation.jsp?func_mode="+link,false);
		xmlHttp.send(xmlDoc);	
		eval(xmlHttp.responseText );

		if(frmObj.add_butt.value==getLabel("Common.Add.label","Common"))
			clearFields(frmObj);
	}
}

function displayDuplicate(func_mode)	{
	if(func_mode=="trade_tab")
		alert(parent.getMessage("PH_DUP_TRD_SEQ_NO","PH"));
	else if(func_mode=="generic_tab")
		alert(parent.getMessage("PH_DUP_GEN_SEQ_NO","PH"));
	else if(func_mode=="inventory_tab")
		alert(parent.getMessage("PH_DUP_ITEM_DESC","PH"));
	else if(func_mode=="weightrecording_tab"){
		alert(getMessage("DUPLICATE_NOT_ALLOWED","PH"));
	}

}

function makeInventoryRecord()	{

	item_code	=	parent.drugMasterMain.drugMasterMainForm.item_code.value;
	if(parent.drugMasterMain.document.drugMasterMainForm.licenceRights.value!="PHBASIC")
		searchDescription(item_code,"forInventoryRecord");

}

function setStockDescription(stock_detail)	{
	var stock			=	stock_detail.split(":");
	var stock_uom_code  = stock[0];
	var stock_uom_desc  = stock[1] ;
	item_code			=	parent.drugMasterMain.drugMasterMainForm.item_code.value;
	item_desc			=	parent.drugMasterMain.drugMasterMainForm.drug_desc.value;
	strength			=	parent.drugMasterMain.document.drugMasterMainForm.base_unit_code.value;
	code				=	parent.drugMasterMain.document.drugMasterMainForm.base_unit_desc.value;
	if(strength!="" && code!="")	{
		var bean_id		=	parent.drugMasterMain.document.drugMasterMainForm.bean_id.value;
		var bean_name	=	parent.drugMasterMain.document.drugMasterMainForm.bean_name.value;
		var xmlDoc = "" ;
		var xmlHttp = new XMLHttpRequest() ;
		var xmlStr ="<root><SEARCH ";
		xmlStr += " uom_code=\""+stock_uom_code+"\"";
		xmlStr += " uom_desc=\""+stock_uom_desc+"\"";
		xmlStr += " eqvl_uom_code=\""+code+"\"";
		xmlStr += " strength=\""+strength+"\"";
		xmlStr += " item_code=\""+item_code+"\"";
		xmlStr += " item_desc=\""+item_desc+"\"";
		xmlStr += " bean_id=\""+bean_id+"\"";
		xmlStr += " bean_name=\""+bean_name+"\"";
		xmlStr +=" /></root>";
		xmlDoc.async = "false";
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open("POST","DrugMasterValidation.jsp?func_mode=getPackSize",false);
		xmlHttp.send(xmlDoc);
	
	}
}

function loadStockUnit(obj) {
	var bean_id		=	parent.drugMasterMain.document.drugMasterMainForm.bean_id.value;
	var bean_name	=	parent.drugMasterMain.document.drugMasterMainForm.bean_name.value;
	var base_unit	=	obj.value;
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest() ;
	var xmlStr ="<root><SEARCH ";
	xmlStr += " bean_id=\""+bean_id+"\"";
	xmlStr += " bean_name=\""+bean_name+"\"";
	xmlStr += " base_unit=\""+base_unit+"\"";
	xmlStr +=" /></root>";
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST","DrugMasterValidation.jsp?func_mode=loadStockUnit",false);
	xmlHttp.send(xmlDoc);
	eval(xmlHttp.responseText);
}

function clearStockList()	{ 
	var list_obj	=parent.f_tab_detail.f_detail.document.drugMasterAddModifyForm.stock_uom;
	var len =list_obj.options.length;
	for(var i=0;i<len;i++) {
		list_obj.remove("stock_uom") ;
	}

	var tp = "---------"+getLabel("Common.defaultSelect.label","Common")+"--------" ;
	var opt = document.createElement("OPTION") ;
	opt.text = tp ;
	opt.value = "" ;
	parent.frames[0].document.drugMasterMainForm.stock_uom_ref.value=""; //SKR-SCF-0456 
	list_obj.add(opt);
}

function addStockList(code,desc)	{ 
	var element = document.createElement('OPTION') ;
	element.value		=  code ;
	element.text		= desc ;
	parent.f_tab_detail.f_detail.document.drugMasterAddModifyForm.stock_uom.add(element);
}


function chkzero1(obj){

	if(eval(obj.value) == 0 || obj.value==""){
		alert(getMessage("PH_NOT_BLANK_ZERO","PH"));
		obj.focus();
	}
 }


function callReset1()	{
	frmObj	=		f_add_modify.document.drugMasterAddModifyForm;
	frmObj.reset();
	frmObj.add_butt.style.display	="inline";
	frmObj.add_butt.style.visibility="visible";
	frmObj.add_butt.value=getLabel("Common.Add.label","Common");
	frmObj.del_butt.style.visibility="hidden";
	parent.f_tab_detail.f_add_modify.document.drugMasterAddModifyForm.MinAge.innerText="";
	parent.f_tab_detail.f_add_modify.document.drugMasterAddModifyForm.AgeUnit.innerText="";
	parent.f_tab_detail.f_add_modify.document.drugMasterAddModifyForm.MaxAge.innerText="";
	parent.f_tab_detail.f_add_modify.document.drugMasterAddModifyForm.gender.innerText="";

	parent.f_tab_detail.f_add_modify.document.drugMasterAddModifyForm.min_age.value="";
	parent.f_tab_detail.f_add_modify.document.drugMasterAddModifyForm.age_unit.value="";
	parent.f_tab_detail.f_add_modify.document.drugMasterAddModifyForm.max_age.value="";
	parent.f_tab_detail.f_add_modify.document.drugMasterAddModifyForm.gender.value="";
	parent.f_tab_detail.f_add_modify.document.drugMasterAddModifyForm.short_desc.value="";
	parent.f_tab_detail.f_add_modify.document.drugMasterAddModifyForm.age_group_code.value="";
}

function updateTrade(row_no,trade_name,trade_id,disp_no,manufacturer_name,select,manufacturer_id,trade_image_filename){

	var va=decodeURIComponent(trade_name,"UTF-8");
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
	
	trade_name =va;

	var va=decodeURIComponent(manufacturer_name,"UTF-8");
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
	manufacturer_name =va;

	parent.f_tab_detail.f_add_modify.document.drugMasterAddModifyForm.trade_name.value=trade_name;
	parent.f_tab_detail.f_add_modify.document.drugMasterAddModifyForm.trade_id.value=trade_id;
	parent.f_tab_detail.f_add_modify.document.drugMasterAddModifyForm.manufacturer_name.value=decodeURIComponent(manufacturer_name);
	parent.f_tab_detail.f_add_modify.document.drugMasterAddModifyForm.manufacturer_id.value=manufacturer_id;
	parent.f_tab_detail.f_add_modify.document.drugMasterAddModifyForm.disp_seq_no.value=disp_no;
	parent.f_tab_detail.f_add_modify.document.drugMasterAddModifyForm.trade_image_filename.value=trade_image_filename;
	parent.f_tab_detail.f_add_modify.document.drugMasterAddModifyForm.add_butt.value=getLabel("Common.Modify.label","Common");
	parent.f_tab_detail.f_add_modify.document.drugMasterAddModifyForm.trade_search.disabled	=	true;
	parent.f_tab_detail.f_add_modify.document.drugMasterAddModifyForm.trade_name.readOnly	=true

}

function submitCurrentFormUpdate(frmObj){
	link	=	"Update";
	var li=frmObj.link.value;
	if(li=='generic_tab')
		link=li;	
	var xmlDoc="";
	var xmlHttp = new XMLHttpRequest();
	var arrObj = frmObj.elements;

	var frmObjs = new Array()
	if(frmObj.name == null)
		frmObjs = frmObj
	else frmObjs[0] = frmObj

	var xmlStr ="<root><SEARCH ";

	for(var frmCount=0; frmCount<frmObjs.length; frmCount++) {
		frmObj = frmObjs[frmCount]
		var arrObj = frmObj.elements;

		for(var i=0;i<arrObj.length;i++) {
			var val = "" ;
			if(arrObj[i].type == "checkbox") {
				if(arrObj[i].checked)	{
					arrObj[i].value="Y";
					val = arrObj[i].value;
				}
				else{
					arrObj[i].value="N";
					val = arrObj[i].value;
				}
			}
			else if(arrObj[i].type == "radio") {
				if(arrObj[i].checked)
					val = arrObj[i].value;
			}
			else if(arrObj[i].type == "select-multiple" ){
				for(var j=0; j<arrObj[i].options.length; j++){
					if(arrObj[i].options[j].selected)
						val+=arrObj[i].options[j].value +"~"
				}
				val= val.substring(0,val.lastIndexOf('~'))
			}
			else
				val = arrObj[i].value;

			val = checkSpl( val ) ;
			xmlStr+= arrObj[i].name+"=\"" + val + "\" " ;
		}
	}
	xmlStr +=" /></root>";
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST","DrugMasterValidation.jsp?func_mode="+link,false);
	xmlHttp.send(xmlDoc);
	eval(xmlHttp.responseText );
}

function validmaxlength1(obj){
	var 	field_label = getLabel("ePH.DirectionToPatient.label","PH");
	if(!SPCheckMaxLen(field_label,obj,150)){
		obj.select();
		obj.focus();
	}
}


async function openEDLLookUpFrame(){
	var dialogHeight	= "800px";//40
	var dialogWidth		= "450px";//35
	var center			= "1";//1
	var status			= "no";
	var features		= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status;
	var arguments		= "";
	
	var EDLCodes = document.drugMasterDetailForm.EDLClassCodes.value;

	var returnValue = await window.showModalDialog("../jsp/EDLAssociateLookupFrames.jsp?EDLCodes="+EDLCodes, arguments, features);
	//window.open("../jsp/EDLAssociateLookupFrames.jsp?EDLCodes="+EDLCodes);
	//alert(returnValue);

	if(returnValue!=null){
		var EDLCodeDesc = returnValue.split('::::');
		document.drugMasterDetailForm.EDLClassDescriptions.value = EDLCodeDesc[1];
		document.drugMasterDetailForm.EDLClassCodes.value = EDLCodeDesc[0];
	}
}

//Adding start for TH-KW-CRF-0007
async function searchDrugName(){
	var formObj = document.supportdrugsheader;

	var argumentArray  = new Array() ;
	var dataNameArray  = new Array() ;
	var dataValueArray = new Array() ;
	var dataTypeArray  = new Array() ;
	var language_id=formObj.locale.value;
	var bean_id   = formObj.bean_id.value;
	var bean_name = formObj.bean_name.value;
	var drug_code= "";
	argumentArray[0]   = "SELECT DRUG_CODE code, DRUG_DESC description FROM PH_DRUG_LANG_VW PH_DRUG WHERE  UPPER(DISCONTINUED_YN)='N' AND UPPER(DRUG_CODE) LIKE UPPER(?) AND UPPER(DRUG_DESC) LIKE UPPER(?) AND UPPER(DRUG_YN)='Y' AND LANGUAGE_ID ="+"'"+language_id+"'"+"order by 2"; 
	argumentArray[1]   = dataNameArray ;
	argumentArray[2]   = dataValueArray ;
	argumentArray[3]   = dataTypeArray ;
	argumentArray[4]   = "2,3";
	argumentArray[5]   = formObj.drug_name.value ;
	argumentArray[6]   = DESC_LINK ;
	argumentArray[7]   = DESC_CODE ; 
	retVal=await CommonLookup(getLabel("Common.DrugName.label","Common"), argumentArray );
	var ret1=unescape(retVal);
		 	var arr=ret1.split(",");
		 	if(arr[1]==undefined) 
	 		{
		 		arr[0]="";	
		 		arr[1]="";	
	 		}
	if(retVal != null && retVal != "" )  {
		drug_code = arr[0];
	}

	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest() ;
	var xmlStr ="<root><SEARCH ";
	xmlStr += " bean_id=\""+bean_id+"\"";
	xmlStr += " bean_name=\""+bean_name+"\"";
	xmlStr += " drug_code=\""+drug_code+"\"";
	xmlStr +=" /></root>";
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST","DrugMasterValidation.jsp?func_mode=ValidateDrug",false);
	xmlHttp.send(xmlDoc);
	eval(xmlHttp.responseText);

var main_drug_code =formObj.main_drug_code.value;//Adding start for ICN-37519
 if(drug_code==main_drug_code){
    alert("Supportive drug should not be same as Main drug");
      return;
  }//Adding end for ICN-37519
     formObj.drug_name.value ="";
	 parent.f_button.support_button.delete_button.disabled =false;
	 parent.f_add_mod_detail.location.href="../../ePH/jsp/SupportiveDrugsDetail.jsp?drug_code="+drug_code;
	
}

function deleteDrug(){
	 var formObj =parent.f_add_mod_detail.supportdrugsdetails;
     var total_records = parent.f_add_mod_detail.supportdrugsdetails.total_records.value;
	 var drug_code ="";
	 var bean_id =formObj.bean_id.value;
	 var bean_name =formObj.bean_name.value;

	 var confirm_flag =confirm("Selected supportive Drugs shall be deleted. Do you want to continue");
 if(confirm_flag){
	 for(var i=0;i<total_records;i++){
		  index =i+1;
		 if(eval("formObj.check_"+index+".checked")){
			 drug_code =eval("formObj.drug_code_"+index).value;
			 var xmlDoc = "" ;
			 var xmlHttp = new XMLHttpRequest() ;
			 var xmlStr ="<root><SEARCH ";
				xmlStr += " bean_id=\""+bean_id+"\"";
				xmlStr += " bean_name=\""+bean_name+"\"";
				xmlStr += " drug_code=\""+drug_code+"\"";
				xmlStr += " index=\""+i+"\"";
				xmlStr +=" /></root>";
				xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
				xmlHttp.open("POST","DrugMasterValidation.jsp?func_mode=RemoveSupDrug",false);
				xmlHttp.send(xmlDoc);
				eval(xmlHttp.responseText);
		 }
	 }
	}
	parent.f_add_mod_detail.location.href="../../ePH/jsp/SupportiveDrugsDetail.jsp?";
}//Adding end for TH-KW-CRF-0007
