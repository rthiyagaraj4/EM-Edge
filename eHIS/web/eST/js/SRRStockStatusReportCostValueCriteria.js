																												   
var bean_id = "";
var bean_name = "";
var xmlDom;
var xmlHttp;
var formObj = "";
function reset() {

	
	formObj = f_query_add_mod.document.formStockStatusReportCostValueCriteria;
	/*formObj.p_fr_sr.disabled = false;
	formObj.P_STORE_CODE_FM.disabled = false;
	formObj.p_to_sr.disabled = false;
	formObj.P_STORE_CODE_to.disabled = false;				 
	formObj.p_item_sel.disabled = false;
	formObj.p_report_order.disabled = false;
	frames[1].document.forms[0].reset();
	//parent.frames[1].frames[1].document.forms[0].reset();
	frames[1].document.getElementById("p_top_style").style.visibility = "visible";					 
	frames[1].document.getElementById("p_count_style").style.visibility = "visible";
	frames[1].document.getElementById("p_item_style").style.visibility = "visible";	*/

	formObj.reset(); 
   frames[1].document.getElementById("image_style_item").style.visibility="hidden";

	}
function CheckForSpecialChars(event) {
	var strCheck = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";						    
	var whichCode = (window.Event) ? event.which : event.keyCode;
	key = String.fromCharCode(whichCode);  // Get key value from key code
	if (strCheck.indexOf(key) == -1) {
		return false;
	}  // Not a valid key
	//if( (event.keyCode >= 97) && (event.keyCode <= 122) )
	//	return (event.keyCode -= 32);
	return true;
}
function loadcolumn(obj) {
	formObj = document.forms[0];
	if (obj.value == "STBSTKS1") {
		
	} else {
		formObj.p_fr_sr.disabled = false;
		formObj.P_STORE_CODE_FM.disabled = false;
		formObj.p_to_sr.disabled = false;
		formObj.P_STORE_CODE_to.disabled = false;
	}
	/*	if(obj.value != "STBSTKS1") {
			formObj.p_item_sel.value="AL";
			formObj.p_item_sel.disabled=true;
	}
	else
			formObj.p_item_sel.disabled=false;*/
	if ((obj.value == "STBSTKS3")  || (obj.value == "STBSTKS6")) {	    
	document.getElementById("p_bin_style").style.visibility = "visible";
	document.getElementById("p_fr_bin_loc_txt").style.visibility = "visible";
	document.getElementById("p_bin_to_style").style.visibility = "visible";
	document.getElementById("p_to_bin_loc").style.visibility = "visible";
		
	} else {
	document.getElementById("p_bin_style").style.visibility = "hidden";
	document.getElementById("p_fr_bin_loc_txt").style.visibility = "hidden";
	document.getElementById("p_bin_to_style").style.visibility = "hidden";
	document.getElementById("p_to_bin_loc").style.visibility = "hidden";
		
	}
	if (obj.value == "STBSTKS1") {
		formObj.p_count.disabled = false;
	}
	if (obj.value == "STBSTKS2") {
		formObj.p_count.disabled = true;
	}
	if (obj.value == "STBSTKS3") {
		
		formObj.p_count.disabled = true;
	}
	if (obj.value == "STBSTKS4") {
		formObj.p_count.disabled = true;
	}
	if (obj.value == "STBSTKS5") {
		formObj.p_count.disabled = true;
	}
	if (obj.value == "STBSTKS6") {
		formObj.p_count.disabled = true;
		formObj.p_fr_sr.disabled = true;
		formObj.P_STORE_CODE_FM.value = "";
		formObj.P_STORE_CODE_to.value = "";
		formObj.P_STORE_CODE_FM.disabled = true;
		formObj.p_to_sr.disabled = true;
		formObj.P_STORE_CODE_to.disabled = true;
	}
	else{

		formObj.p_fr_sr.disabled = false;
		formObj.P_STORE_CODE_FM.disabled = false;
		formObj.p_to_sr.disabled = false;
		formObj.P_STORE_CODE_to.disabled = false;
	}
}
function setReportType() {
	var formObject = document.formStockStatusReportCriteria;
	if (formObject.p_report_id.value == "STBSTKS1") {
		document.getElementById("p_top_style").style.visibility = "visible";
		document.getElementById("p_count").style.visibility = "visible";
		document.getElementById("p_count_style").style.visibility = "visible";
		document.getElementById("p_item_style").style.visibility = "visible";
		document.getElementById("p_by_style").style.visibility = "visible";
		document.getElementById("p_select_by_style").style.visibility = "visible";
		/**
			* @Name - Priya 
			* @Date - 31/12/2009
			* @Inc# - IN017730
			* @Desc - To select the default value for the select box ?Top of Items By? as ?Quantity?
		*/
		document.formStockStatusReportCriteria.p_item_by.selectedIndex = 0;
	} else {
		document.getElementById("p_top_style").style.visibility = "hidden";
		document.getElementById("p_count").style.visibility = "hidden";
		document.getElementById("p_count_style").style.visibility = "hidden";
		document.getElementById("p_item_style").style.visibility = "hidden";
		document.getElementById("p_by_style").style.visibility = "hidden";
		document.getElementById("p_select_by_style").style.visibility = "hidden";
		document.formStockStatusReportCriteria.p_item_by.value = "";
		document.formStockStatusReportCriteria.p_count.value = "";

	}
}
function searchCodeItem(obj) {
	var result = false;
	var message = "";
	var flag = "";
	var function_id = "";
	var argumentArray = new Array();
	var dataNameArray = new Array();
	var dataValueArray = new Array();
	var dataTypeArray = new Array();
	dataNameArray[0] = "language_id";
	dataValueArray[0] = document.forms[0].P_LANGUAGE_ID.value;
	dataTypeArray[0] = STRING;
	argumentArray[0] = document.getElementById("SQL_ST_ITEM_LOOKUP").value;
	argumentArray[1] = dataNameArray;
	argumentArray[2] = dataValueArray;
	argumentArray[3] = dataTypeArray;
	argumentArray[4] = "2,3";
	argumentArray[5] = obj.value;
	argumentArray[6] = CODE_LINK;
	argumentArray[7] = CODE_DESC;
	returnedValues = CommonLookup(getLabel("Common.item.label", "Common"), argumentArray);
	if ((returnedValues != null) && (returnedValues != "")) {
		obj.value = returnedValues[0];
	}
}
function searchCodeStore(obj) {


	var result = false;
	var message = "";
	var flag = "";
	var function_id = "";
	var argumentArray = new Array();
	var dataNameArray = new Array();
	var dataValueArray = new Array();
	var dataTypeArray = new Array();
	dataNameArray[0] = "language_id";
	dataValueArray[0] = document.forms[0].P_LANGUAGE_ID.value;		  
	dataTypeArray[0] = STRING;
	dataNameArray[1] = "facility_id";
	dataValueArray[1] = document.forms[0].P_FACILITY_ID.value;
	dataTypeArray[1] = STRING;
	//argumentArray[0] = document.getElementById("SQL_ST_STORE_LOOKUP").value;
	var sql = "SELECT    DISTINCT A.STORE_CODE CODE, A.SHORT_DESC DESCRIPTION FROM MM_STORE_LANG_VW A, ST_STORE C, ST_ACC_ENTITY_PARAM D, ST_USER_ACCESS_FOR_STORE E WHERE A.LANGUAGE_ID LIKE ? AND A.FACILITY_ID LIKE ? AND A.STORE_CODE LIKE UPPER (?) AND UPPER (A.SHORT_DESC) LIKE UPPER (?) AND A.EFF_STATUS = 'E' AND A.STORE_CODE = C.STORE_CODE AND C.STORE_TYPE_FLAG != 'N' AND E.USER_ID LIKE DECODE(D.RESTRICT_VIEW_STK_STATUS , 'ALL','%', '"+document.forms[0].P_USER_NAME.value+"') AND C.STORE_CODE = E.STORE_CODE";
	argumentArray[0] = encodeURIComponent(sql)+" ORDER BY 2";
	argumentArray[1] = dataNameArray;
	argumentArray[2] = dataValueArray;
	argumentArray[3] = dataTypeArray;
	argumentArray[4] = "3,4";
	argumentArray[5] = obj.value;
	argumentArray[6] = CODE_LINK;
	argumentArray[7] = CODE_DESC;
	returnedValues = CommonLookup(getLabel("Common.Store.label", "Common"), argumentArray);
	if ((returnedValues != null) && (returnedValues != "")) {
		obj.value = returnedValues[0];
	}
}
function searchCodeItemClass(obj) {
	var result = false;
	var message = "";
	var flag = "";
	var function_id = "";
	var argumentArray = new Array();
	var dataNameArray = new Array();
	var dataValueArray = new Array();
	var dataTypeArray = new Array();
	argumentArray[0] = document.getElementById("SQL_ST_ITEM_CLASS_LOOKUP_LANG").value + "'" + document.forms[0].P_LANGUAGE_ID.value + "'";
	argumentArray[1] = dataNameArray;
	argumentArray[2] = dataValueArray;
	argumentArray[3] = dataTypeArray;
	argumentArray[4] = "1,2";
	argumentArray[5] = obj.value;
	argumentArray[6] = CODE_LINK;
	argumentArray[7] = CODE_DESC;
	returnedValues = CommonLookup(getLabel("Common.ItemClass.label", "Common"), argumentArray);
	if ((returnedValues != null) && (returnedValues != "")) {
		obj.value = returnedValues[0];
	}
}
function searchAlphaCode(obj) {
	var result = false;
	var message = "";
	var flag = "";
	var function_id = "";
	var argumentArray = new Array();
	var dataNameArray = new Array();
	var dataValueArray = new Array();
	var dataTypeArray = new Array();
	argumentArray[0] = document.forms[0].SQL_ST_ALPHA_LOOKUP.value;
	argumentArray[1] = dataNameArray;
	argumentArray[2] = dataValueArray;
	argumentArray[3] = dataTypeArray;
	argumentArray[4] = "1,2";
	argumentArray[5] = obj.value;
	argumentArray[6] = CODE_LINK;
	argumentArray[7] = CODE_DESC;
	returnedValues = CommonLookup(getLabel("Common.AlphaCode.label", "Common"), argumentArray);
	if ((returnedValues != null) && (returnedValues != "")) {
		obj.value = returnedValues[0];
	}
}
function searchSterileType(obj) {
	var result = false;
	var message = "";
	var flag = "";
	var function_id = "";
	var argumentArray = new Array();
	var dataNameArray = new Array();
	var dataValueArray = new Array();
	var dataTypeArray = new Array();
	argumentArray[0] = document.forms[0].SQL_ST_STERILE_SELECT.value;
	argumentArray[1] = dataNameArray;
	argumentArray[2] = dataValueArray;
	argumentArray[3] = dataTypeArray;
	argumentArray[4] = "1,2";
	argumentArray[5] = obj.value;
	argumentArray[6] = CODE_LINK;
	argumentArray[7] = CODE_DESC;
	returnedValues = CommonLookup(getLabel("Common.AlphaCode.label", "Common"), argumentArray);
	if ((returnedValues != null) && (returnedValues != "")) {
		obj.value = returnedValues[0];
	}
}
function setValue() {
	if (document.formStockStatusReportCriteria.p_count.value != "") {
		document.formStockStatusReportCriteria.p_report_order.selectedIndex = 2;
	}
}
function setReportOrder() {
	document.formStockStatusReportCriteria.p_report_order.disabled = false;
	document.formStockStatusReportCriteria.p_report_order.selectedIndex = 0;
	
}

function run() {
	 messageFrame.location.href = "../../eCommon/jsp/error.jsp";
	
	if (f_query_add_mod.document.formStockStatusReportCostValueCriteria) {		   
		 formObj = f_query_add_mod.document.formStockStatusReportCostValueCriteria;
													   
		 var fields=new Array();
		 var name=new Array();
		   fields[0]=formObj.p_report_type;
		   name[0]=getLabel("Common.reporttype.label","Common");
	    if(formObj.p_report_type.value=="A")
		{																					  
			//fields[1]=formObj.P_ITEM_ANAL_FM;										     
			//name[1]=getLabel("Common.ItemAnalysis.label","Common");
			fields[1]=formObj.P_ITEM_ANAL_LEVEL;										     
			name[1]=getLabel("Common.ItemAnalysis.label","Common")+" "+getLabel("Common.Level.label","Common");
		}
			 																	   
			
	
	
			
	if(checkFields(fields,name,messageFrame))	{
														   
	   if (isValidFromToField(formObj.P_STORE_GROUP_fm, formObj.P_STORE_GROUP_to, STRING, getLabel("eST.StoreGroup.label", "ST"), messageFrame))
		{					
				
		   if (isValidFromToField(formObj.P_STORE_CODE_FM, formObj.P_STORE_CODE_to, STRING, getLabel("Common.StoreCode.label", "Common"), messageFrame)) {  
			 
			   if (isValidFromToField(formObj.P_ITEM_CLASS_FM, formObj.P_ITEM_CLASS_to, STRING, getLabel("Common.ItemClass.label", "Common"), messageFrame)) {
					
					if (isValidFromToField(formObj.P_STORE_CODE_FM, formObj.P_STORE_CODE_to, STRING, getLabel("Common.ItemCode.label", "Common"), messageFrame)) {

						 if (isValidFromToField(formObj.P_ITEM_ANAL_FM, formObj.P_ITEM_ANAL_to, STRING, getLabel("Common.ItemAnalysis.label", "Common"), messageFrame)) {


								if(formObj.p_report_type.value=="C" && formObj.p_report_order_type.value=="p_by_store")
								{
								  formObj.p_report_id.value="STICICBS";
								}
								else if(formObj.p_report_type.value=="C" && formObj.p_report_order_type.value=="p_by_group")
								 {
										 formObj.p_report_id.value="STICICBG";	 
								 }
								else if(formObj.p_report_type.value=="A" && formObj.p_report_order_type.value=="p_by_group")
								 {
										 formObj.p_report_id.value="STICVBAG";	 
								 }			
								  else
								 {
								   formObj.p_report_id.value="STICVBIA";
								 }

						
							     formObj.submit(); 

						 }

					}
			   }
		   }
		} 												    

	}
		/*formObj = f_query_add_mod.document.formStockStatusReportCriteria;    
		
		if (isValidFromToField(formObj.P_STORE_CODE_FM, formObj.P_STORE_CODE_to, STRING, getLabel("Common.StoreCode.label", "Common"), messageFrame)) {

																				   
			if (isValidFromToField(formObj.p_fm_item_code, formObj.p_to_item_code, STRING, getLabel("Common.ItemCode.label", "Common"), messageFrame)) {

				
				if (isValidFromToField(formObj.P_ITEM_CLASS_FM, formObj.p_to_item_class, STRING, getLabel("Common.ItemClass.label", "Common"), messageFrame)) {

					
					if (isValidFromToField(formObj.p_fr_alp_code, formObj.p_to_alp_code, STRING, getLabel("Common.AlphaCode.label", "Common"), messageFrame)) {

						
						if (isValidFromToField(formObj.p_fr_unit_cost, formObj.p_to_unit_cost, INT,getLabel("Common.UnitCost.label", "Common") , messageFrame)) {

							
								if (isValidFromToField(formObj.p_fr_bin_loc, formObj.p_to_bin_loc, STRING,getLabel("Common.BinLocation.label", "Common"), messageFrame)) {

									if (isValidFromToField(formObj.p_fr_st_val, formObj.p_to_st_val, INT,getLabel("eST.CostValue.label", "st_labels"), messageFrame)) {

									
									formObj.submit();
								}
							}
						}
					}
				}
			}
		}*/
	}
}
/*		else if(f_query_add_mod.MasterCodePages.document.formReportItem)
		{
			formObj=f_query_add_mod.MasterCodePages.document.formReportItem;
		
			if (isValidFromToField(formObj.p_fm_item_code, formObj.p_to_item_code, STRING, "Item", messageFrame)) 
			 if (isValidFromToField(formObj.p_fm_alpha_code, formObj.p_to_alpha_code, STRING, "Alpha Code", messageFrame)) 
			  if (isValidFromToField(formObj.p_fm_item_class_code, formObj.p_to_item_class_code, STRING, "Item Class", messageFrame)) 
				if (isValidFromToField(formObj.p_fm_machine_code, formObj.p_to_machine_code, STRING, "Machine Code", messageFrame))  
				  if (isValidFromToField(formObj.p_fm_model_no, formObj.p_to_model_no, STRING, "Model Number", messageFrame)) 
				    if (isValidFromToField(formObj.p_fm_part_no, formObj.p_to_part_no, STRING, "Part Number", messageFrame)) 
				      formObj.submit();
		}
		else if(f_query_add_mod.MasterCodePages.document.formReportStore)
		{
			formObj=f_query_add_mod.MasterCodePages.document.formReportStore;
		
			if (isValidFromToField(formObj.p_fm_store_code, formObj.p_to_store_code, STRING, "Store", messageFrame)) 
			  if (isValidFromToField(formObj.p_fm_dept_code, formObj.p_to_dept_code, STRING, "Department", messageFrame)) 
				formObj.submit();
			
		}
		else if(f_query_add_mod.MasterCodePages.document.formReportItemForStore)
		{
			formObj=f_query_add_mod.MasterCodePages.document.formReportItemForStore;
		
			if (isValidFromToField(formObj.p_fm_store_code, formObj.p_to_store_code, STRING, "Store Code", messageFrame)) 
			  if (isValidFromToField(formObj.p_fm_item_code, formObj.p_to_item_code, STRING, "Item Code", messageFrame)) 
				formObj.submit();
			
		}
       	else if(f_query_add_mod.MasterCodePages.document.formReportItemClassForStore)							    
		{
			formObj=f_query_add_mod.MasterCodePages.document.formReportItemClassForStore;
		
			if (isValidFromToField(formObj.p_fm_store_code, formObj.p_to_store_code, STRING, "Store Code", messageFrame)) 
			  if (isValidFromToField(formObj.p_fm_item_class_code, formObj.p_to_item_class_code, STRING, "Item Class Code", messageFrame)) 
				formObj.submit();
			
		}
		else if(f_query_add_mod.MasterCodePages.document.formReportPrepareLocation)
		{
			formObj=f_query_add_mod.MasterCodePages.document.formReportPrepareLocation;
		
			if (isValidFromToField(formObj.p_fm_code, formObj.p_to_code, STRING, "Prepare Location", messageFrame)) 
			  formObj.submit();
			
		}
		else if(f_query_add_mod.MasterCodePages.document.formReportTrnDocType)
		{
			formObj=f_query_add_mod.MasterCodePages.document.formReportTrnDocType;
		
			if (isValidFromToField(formObj.p_fm_code, formObj.p_to_code, STRING, "Doc Type Code", messageFrame)) 
			  formObj.submit();
			
		}
}  */

function setReportItemId() {
	if (document.formReportItem.p_report_type.value == "1") {
		document.formReportItem.p_report_id.value = "STBITEMS";												   
	} else {
		document.formReportItem.p_report_id.value = "STBITMDT";						   
	}
}

//********************************************************************************************
//  function checkListItem 
//********************************************************************************************
function checkListItem(obj)
{

	if(obj.value=="A")
	{
	  document.getElementById("image_style_item").style.visibility="visible";
	}
	else																						    
	{
	  document.getElementById("image_style_item").style.visibility="hidden";
	}
}
