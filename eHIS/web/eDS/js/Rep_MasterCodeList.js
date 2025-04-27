
function populateFields1(code) {
	var divObj=document.getElementById("Tab_CodeList_Fields");
	var select=document.createElement("select");
	var tab=document.createElement("table");
	var row=document.createElement("tr");
	divObj.appendChild(select);
	divObj.appendChild(tab);
	divObj.appendChild(row);
	var select1=document.createElement("select");
	divObj.appendChild(select1);
	divObj.appendChild(row);

}

// modified by N Munisekhar on 20-May-2013 against [IN039994]
function reset(){
	  var formObj = parent.content.f_query_rep.RepDSMasterCodesForm;
	  formObj.reset();
	 //at_tab_frame.location.reload();
	}

function populateKitchenArea() {
	var locale = document.RepDSMasterCodesForm["locale"].value;
	var facilityId = document.RepDSMasterCodesForm["facility_id"].value;
	var kitchenCode = document.RepDSMasterCodesForm["kitchen"].value;

	var kitchenAreaSql="select KITCHEN_AREA_CODE,SHORT_DESC from DS_KITCHEN_AREA_LANG_VW where (OPERATING_FACILITY_ID like '"+facilityId+"' )and(KITCHEN_CODE like '"+kitchenCode+"' )and(LANGUAGE_ID like '"+locale+"' )and(EFF_STATUS='E' ) order by  2 , 1";

	for(var i = document.RepDSMasterCodesForm["kitchenAreaFrom"].getElementsByTagName("option").length; i > 0;i--) {
		document.RepDSMasterCodesForm["kitchenAreaFrom"].remove(i -1);
	}

	for(var i = document.RepDSMasterCodesForm["kitchenAreaTo"].getElementsByTagName("option").length; i > 0;i--) {
		document.RepDSMasterCodesForm["kitchenAreaTo"].remove(i -1);
	}

	populateDropDownOptions("kitchenAreaFrom",kitchenAreaSql);
	populateDropDownOptions("kitchenAreaTo",kitchenAreaSql);
}

function populateFields(code) {
	//var locale = document.getElementById("p_language_id").value;
	var locale=document.RepDSMasterCodesForm["locale"].value;
	var facilityId = document.RepDSMasterCodesForm["facility_id"].value;
	var dietTypeSql="SELECT DIET_TYPE,SHORT_DESC from  DS_DIET_TYPE_LANG_VW  WHERE  LANGUAGE_ID ='"+locale+"' order by 2,1" ;
	var mealClassSql="select MEAL_CLASS,SHORT_DESC from DS_MEAL_CLASS order by  2 , 1";
	var mealTypeSql="select MEAL_TYPE, SHORT_DESC from DS_MEAL_TYPE order by  meal_order , 1";
	var feedTypeSql="select FEED_TYPE, SHORT_DESC from DS_FEED_TYPE order by  2 , 1";
	var itemTypeSql="select ITEM_TYPE, SHORT_DESC from DS_ITEM_TYPE order by  2 , 1";
	var complaintSql="select COMPLAINT_CODE,SHORT_DESC from DS_COMPLAINTS order by  2 , 1";
	var delieverInstrSql="select INSTR_CODE, LONG_DESC from DS_DELIVERY_INSTR order by  2 , 1";
	var ingredientSql="select INGREDIENT_CODE, SHORT_DESC from DS_INGREDIENT order by  2 , 1";
	var mealCategorySql="select MEAL_CATEGORY_CODE, DESCRIPTION from DS_MEAL_CATEGORY order by  2 , 1";
	var kitchenSql="select KITCHEN_CODE,SHORT_DESC from DS_KITCHENS where (OPERATING_FACILITY_ID='"+facilityId+"' ) order by  2 , 1";
	var foodItemSql="select FOOD_ITEM_CODE,SHORT_DESC from DS_FOOD_ITEM order by  2 , 1";
	var commericalFormulaSql="select COMM_FORMULA_CODE, SHORT_DESC from DS_COMM_FORMULA order by  2 , 1";
	var menuSql="select MENU_CODE,SHORT_DESC from DS_MENU order by  2 , 1";
	var nutrientSql="select NUTRIENTS_CODE, SHORT_DESC from DS_NUTRIENTS order by  2 , 1";
	var textureofdietSql="select TEXTURE_OF_DIET,SHORT_DESC from DS_TEXTURE_OF_DIET order by  2 , 1"; //412-US6	
	var dietRequestLocSql="select LOCATION_CODE,SHORT_DESC from DS_DIET_REQUEST_LOC order by 2 , 1";//419-US5
	
	//ML-MMOH-CRF-684-US3
	var menuTypeSql="SELECT menu_TYPE,SHORT_DESC from  ds_menu_type order by 2,1";
	//ML-MMOH-CRF-684-US3
	
	for(var i = document.getElementById("Tab_CodeList_Fields").rows.length; i > 0;i--) {
		document.getElementById("Tab_CodeList_Fields").deleteRow(i -1);
	}

	var tabObj=document.getElementById("Tab_CodeList_Fields");
	var row=tabObj.insertRow();
	var hiddenFields=row.insertCell();
	// CRF-412
	if(code==""){
		document.RepDSMasterCodesForm.reset();
	}
	// CRF-412
	if(code=="DT") {
		createComboBox('Tab_CodeList_Fields','Diet Type (From)','dietTypeFrom');
		populateDropDownOptions("dietTypeFrom",dietTypeSql);
		createComboBox('Tab_CodeList_Fields','Diet Type (To)','dietTypeTo');
		populateDropDownOptions("dietTypeTo",dietTypeSql);
		createNatureComboBox('Tab_CodeList_Fields','Nature','effStatus');

		hiddenFields.insertAdjacentHTML("BeforeEnd","<input type='hidden' name='PARAM1' id='PARAM1' value=''/ ><input type='hidden' name='PARAM2' id='PARAM2' value=''/ ><input type='hidden' name='PARAM3' id='PARAM3' value=''/ >");
		setReportId("DSRDTYPE");
	}

	else if(code=="MC") {
		createComboBox('Tab_CodeList_Fields','Meal Class (From)','mealClassFrom');
		populateDropDownOptions("mealClassFrom",mealClassSql);
		createComboBox('Tab_CodeList_Fields','Meal Class (To)','mealClassTo');
		populateDropDownOptions("mealClassTo",mealClassSql);
		createNatureComboBox('Tab_CodeList_Fields','Nature','effStatus');

		hiddenFields.insertAdjacentHTML("BeforeEnd","<input type='hidden' name='PARAM1' id='PARAM1' value=''/ ><input type='hidden' name='PARAM2' id='PARAM2' value=''/ ><input type='hidden' name='PARAM3' id='PARAM3' value=''/ >");
		setReportId("DSRMCLAS");
	}

	else if(code=="MT") {
		createComboBox('Tab_CodeList_Fields','Meal Type (From)','mealTypeFrom');
		populateDropDownOptions("mealTypeFrom",mealTypeSql);
		createComboBox('Tab_CodeList_Fields','Meal Type (To)','mealTypeTo');
		populateDropDownOptions("mealTypeTo",mealTypeSql);
		createNatureComboBox('Tab_CodeList_Fields','Nature','effStatus');

		hiddenFields.insertAdjacentHTML("BeforeEnd","<input type='hidden' name='PARAM1' id='PARAM1' value=''/ ><input type='hidden' name='PARAM2' id='PARAM2' value=''/ ><input type='hidden' name='PARAM3' id='PARAM3' value=''/ >");
		setReportId("DSRMTYPE");
	}

	else if(code=="FT") {
		createComboBox('Tab_CodeList_Fields','Feed Type (From)','feedTypeFrom');
		populateDropDownOptions("feedTypeFrom",feedTypeSql);
		createComboBox('Tab_CodeList_Fields','Feed Type (To)','feedTypeTo');
		populateDropDownOptions("feedTypeTo",feedTypeSql);
		createNatureComboBox('Tab_CodeList_Fields','Nature','effStatus');

		hiddenFields.insertAdjacentHTML("BeforeEnd","<input type='hidden' name='PARAM1' id='PARAM1' value=''/ ><input type='hidden' name='PARAM2' id='PARAM2' value=''/ ><input type='hidden' name='PARAM3' id='PARAM3' value=''/ >");
		setReportId("DSRFTYPE");
	}

	else if(code=="IT") {
		createComboBox('Tab_CodeList_Fields','Items (From)','itemTypeFrom');
		populateDropDownOptions("itemTypeFrom",itemTypeSql);
		createComboBox('Tab_CodeList_Fields','Items (To)','itemTypeTo');
		populateDropDownOptions("itemTypeTo",itemTypeSql);
		createNatureComboBox('Tab_CodeList_Fields','Nature','effStatus');

		hiddenFields.insertAdjacentHTML("BeforeEnd","<input type='hidden' name='PARAM1' id='PARAM1' value=''/ ><input type='hidden' name='PARAM2' id='PARAM2' value=''/ ><input type='hidden' name='PARAM3' id='PARAM3' value=''/ >");
		setReportId("DSRITYPE");
	}
	else if(code=="Cmpts") {
		createComboBox('Tab_CodeList_Fields','Complaint Code (From)','complaintCodeFrom');
		populateDropDownOptions("complaintCodeFrom",complaintSql);
		createComboBox('Tab_CodeList_Fields','Complaint Code (To)','complaintCodeTo');
		populateDropDownOptions("complaintCodeTo",complaintSql);
		createNatureComboBox('Tab_CodeList_Fields','Nature','effStatus');

		hiddenFields.insertAdjacentHTML("BeforeEnd","<input type='hidden' name='P_COMPLAINT_CODE_FROM' id='P_COMPLAINT_CODE_FROM' value=''/ ><input type='hidden' name='P_COMPLAINT_CODE_TO' id='P_COMPLAINT_CODE_TO' value=''/ ><input type='hidden' name='P_STATUS' id='P_STATUS' value=''/ >");
		setReportId("DSRCMPLT");
	}
	else if(code=="DI") {
		createComboBox('Tab_CodeList_Fields','Delivery Instruction (From)','deliveryInstrFrom');
		populateDropDownOptions("deliveryInstrFrom",delieverInstrSql);
		createComboBox('Tab_CodeList_Fields','Delivery Instruction (To)','deliveryInstrTo');
		populateDropDownOptions("deliveryInstrTo",delieverInstrSql);
		createNatureComboBox('Tab_CodeList_Fields','Nature','effStatus');

		hiddenFields.insertAdjacentHTML("BeforeEnd","<input type='hidden' name='PARAM1' id='PARAM1' value=''/ ><input type='hidden' name='PARAM2' id='PARAM2' value=''/ ><input type='hidden' name='PARAM3' id='PARAM3' value=''/ >");
		setReportId("DSRDELIN");
	}
	else if(code=="Ingrds") {
		createComboBox('Tab_CodeList_Fields','Ingredient (From)','ingredientFrom');
		populateDropDownOptions("ingredientFrom",ingredientSql);
		createComboBox('Tab_CodeList_Fields','Ingredient (To)','ingredientTo');
		populateDropDownOptions("ingredientTo",ingredientSql);
		createNatureComboBox('Tab_CodeList_Fields','Nature','effStatus');

		hiddenFields.insertAdjacentHTML("BeforeEnd","<input type='hidden' name='PARAM1' id='PARAM1' value=''/ ><input type='hidden' name='PARAM2' id='PARAM2' value=''/ ><input type='hidden' name='PARAM3' id='PARAM3' value=''/ >");
		setReportId("DSRINGR");
	}
	else if(code=="MCtrgy") {
		createComboBox('Tab_CodeList_Fields','Meal Category (From)','mealCategoryFrom');
		populateDropDownOptions("mealCategoryFrom",mealCategorySql);
		createComboBox('Tab_CodeList_Fields','Meal Category (To)','mealCategoryTo');
		populateDropDownOptions("mealCategoryTo",mealCategorySql);

		hiddenFields.insertAdjacentHTML("BeforeEnd","<input type='hidden' name='PARAM1' id='PARAM1' value=''/ ><input type='hidden' name='PARAM2' id='PARAM2' value=''/ >");
		setReportId("DSRMLCAT");
	}
	else if(code=="KHNS") {
		createComboBox('Tab_CodeList_Fields','Kitchen (From)','kitchenFrom');
		populateDropDownOptions("kitchenFrom",kitchenSql);
		createComboBox('Tab_CodeList_Fields','Kitchen (To)','kitchenTo');
		populateDropDownOptions("kitchenTo",kitchenSql);
		createNatureComboBox('Tab_CodeList_Fields','Nature','effStatus');

		hiddenFields.insertAdjacentHTML("BeforeEnd","<input type='hidden' name='PARAM1' id='PARAM1' value=''/ ><input type='hidden' name='PARAM2' id='PARAM2' value=''/ ><input type='hidden' name='PARAM3' id='PARAM3' value=''/ >");
		setReportId("DSRKTCHN");
	}
	else if(code=="KA") {
		createComboBox('Tab_CodeList_Fields','Kitchen','kitchen',true,'populateKitchenArea');
		populateDropDownOptions("kitchen",kitchenSql);
		createComboBox('Tab_CodeList_Fields','Kitchen Area (From)','kitchenAreaFrom');
		createComboBox('Tab_CodeList_Fields','Kitchen Area (To)','kitchenAreaTo');
		createNatureComboBox('Tab_CodeList_Fields','Nature','effStatus');

		hiddenFields.insertAdjacentHTML("BeforeEnd","<input type='hidden' name='PARAM1' id='PARAM1' value=''/ ><input type='hidden' name='PARAM2' id='PARAM2' value=''/ ><input type='hidden' name='PARAM3' id='PARAM3' value=''/ ><input type='hidden' name='PARAM4' id='PARAM4' value=''/ >");
		setReportId("DSRKITCH");
	}
	else if(code=="FI") {
		createComboBox('Tab_CodeList_Fields','Food Item (From)','foodItemFrom');
		populateDropDownOptions("foodItemFrom",foodItemSql);
		createComboBox('Tab_CodeList_Fields','Food Item (To)','foodItemTo');
		populateDropDownOptions("foodItemTo",foodItemSql);
		createComboBox('Tab_CodeList_Fields','Item Type','itemType');
		populateDropDownOptions("itemType",itemTypeSql);

		createNatureComboBox('Tab_CodeList_Fields','Nature','effStatus');

		hiddenFields.insertAdjacentHTML("BeforeEnd","<input type='hidden' name='PARAM1' id='PARAM1' value=''/ ><input type='hidden' name='PARAM2' id='PARAM2' value=''/ ><input type='hidden' name='PARAM3' id='PARAM3' value=''/ ><input type='hidden' name='PARAM4' id='PARAM4' value=''/ >");
		setReportId("DSRFITEM");
	}
	else if(code=="CF") {
		createComboBox('Tab_CodeList_Fields','Commercial Formula (From)','commercialFormulaFrom');
		populateDropDownOptions("commercialFormulaFrom",commericalFormulaSql);
		createComboBox('Tab_CodeList_Fields','Commercial Formula (To)','commercialFormulaTo');
		populateDropDownOptions("commercialFormulaTo",commericalFormulaSql);

		createComboBox('Tab_CodeList_Fields','Item Type','itemType');
		populateDropDownOptions("itemType",itemTypeSql);

		createNatureComboBox('Tab_CodeList_Fields','Nature','effStatus');

		hiddenFields.insertAdjacentHTML("BeforeEnd","<input type='hidden' name='PARAM1' id='PARAM1' value=''/ ><input type='hidden' name='PARAM2' id='PARAM2' value=''/ ><input type='hidden' name='PARAM3' id='PARAM3' value=''/ ><input type='hidden' name='PARAM4' id='PARAM4' value=''/ >");
		setReportId("DSRCOMFR");
	}
	else if(code=="Menu") {
		createComboBox('Tab_CodeList_Fields','Menu (From)','menuFrom');
		populateDropDownOptions("menuFrom",menuSql);
		createComboBox('Tab_CodeList_Fields','Menu (To)','menuTo');
		populateDropDownOptions("menuTo",menuSql);

		createComboBox('Tab_CodeList_Fields','Diet Type','dietType');
		populateDropDownOptions("dietType",dietTypeSql);

		createComboBox('Tab_CodeList_Fields','Meal Type','mealType');
		populateDropDownOptions("mealType",mealTypeSql);

		createComboBox('Tab_CodeList_Fields','Meal Class','mealClass');
		populateDropDownOptions("mealClass",mealClassSql);

		createNatureComboBox('Tab_CodeList_Fields','Nature','effStatus');

		hiddenFields.insertAdjacentHTML("BeforeEnd","<input type='hidden' name='PARAM1' id='PARAM1' value=''/ ><input type='hidden' name='PARAM2' id='PARAM2' value=''/ ><input type='hidden' name='PARAM3' id='PARAM3' value=''/ ><input type='hidden' name='PARAM4' id='PARAM4' value=''/ ><input type='hidden' name='PARAM5' id='PARAM5' value=''/ ><input type='hidden' name='PARAM6' id='PARAM6' value=''/ >");
		setReportId("DSRMENUC");
	}
	else if(code=="DC") {
		createComboBox('Tab_CodeList_Fields','Meal Class','mealClass');
		populateDropDownOptions("mealClass",mealClassSql);

		createComboBox('Tab_CodeList_Fields','Diet Type','dietType');
		populateDropDownOptions("dietType",dietTypeSql);

		createNatureComboBox('Tab_CodeList_Fields','Nature','effStatus');

		hiddenFields.insertAdjacentHTML("BeforeEnd","<input type='hidden' name='PARAM1' id='PARAM1' value=''/ ><input type='hidden' name='PARAM2' id='PARAM2' value=''/ ><input type='hidden' name='PARAM3' id='PARAM3' value=''/ >");
		setReportId("DSRSCHED");
	}
	else if(code=="DTT") {
		createComboBox('Tab_CodeList_Fields','Menu (From)','menuFrom');
		populateDropDownOptions("menuFrom",menuSql);
		createComboBox('Tab_CodeList_Fields','Menu (To)','menuTo');
		populateDropDownOptions("menuTo",menuSql);

		createComboBox('Tab_CodeList_Fields','Diet Type','dietType');
		populateDropDownOptions("dietType",dietTypeSql);

		createNatureComboBox('Tab_CodeList_Fields','Nature','effStatus');

		hiddenFields.insertAdjacentHTML("BeforeEnd","<input type='hidden' name='PARAM1' id='PARAM1' value=''/ ><input type='hidden' name='PARAM2' id='PARAM2' value=''/ ><input type='hidden' name='PARAM3' id='PARAM3' value=''/ ><input type='hidden' name='PARAM4' id='PARAM4' value=''/ >");
		setReportId("DSRTMTBL");
	}
	else if(code=="WforK") {
		createComboBox('Tab_CodeList_Fields','Kitchen (From)','kitchenFrom');
		populateDropDownOptions("kitchenFrom",kitchenSql);
		createComboBox('Tab_CodeList_Fields','Kitchen (To)','kitchenTo');
		populateDropDownOptions("kitchenTo",kitchenSql);

		hiddenFields.insertAdjacentHTML("BeforeEnd","<input type='hidden' name='P_KITCHEN_CODE_FROM' id='P_KITCHEN_CODE_FROM' value=''/ ><input type='hidden' name='P_KITCHEN_CODE_TO' id='P_KITCHEN_CODE_TO' value=''/ >");
		setReportId("DSRKTWRD");
	}
	else if(code=="NRT") {
		createComboBox('Tab_CodeList_Fields','Nutrient (From)','nutrientFrom');
		populateDropDownOptions("nutrientFrom",nutrientSql);
		createComboBox('Tab_CodeList_Fields','Nutrient (To)','nutrientTo');
		populateDropDownOptions("nutrientTo",nutrientSql);

		createNatureComboBox('Tab_CodeList_Fields','Nature','effStatus');

		hiddenFields.insertAdjacentHTML("BeforeEnd","<input type='hidden' name='P_NUTRIENT_FROM' id='P_NUTRIENT_FROM' value=''/ ><input type='hidden' name='P_NUTRIENT_TO' id='P_NUTRIENT_TO' value=''/ ><input type='hidden' name='P_STATUS' id='P_STATUS' value=''/ >");
		setReportId("DSRNUTRT");
	}
	//412-US6
	else if(code=="TXT"){
		createComboBox('Tab_CodeList_Fields','Texture of Diet (From)','textureofdietFrom');
		populateDropDownOptions("textureofdietFrom",textureofdietSql);
		createComboBox('Tab_CodeList_Fields','Texture of Diet (To)','textureofdietTo');
		populateDropDownOptions("textureofdietTo",textureofdietSql);
		createNatureComboBox('Tab_CodeList_Fields','Nature','effStatus');

		hiddenFields.insertAdjacentHTML("BeforeEnd","<input type='hidden' name='PARAM1' id='PARAM1' value=''/ ><input type='hidden' name='PARAM2' id='PARAM2' value=''/ ><input type='hidden' name='PARAM3' id='PARAM3' value=''/ >");
		setReportId("DSRTXOFDT");
		}
	//419-US5 
	else if (code=="DRL"){
	    createComboBox('Tab_CodeList_Fields','Diet Request Location (From)','DietRequestLocationFrom');
		populateDropDownOptions("DietRequestLocationFrom",dietRequestLocSql);
		createComboBox('Tab_CodeList_Fields','Diet Request Location (To)','DietRequestLocationTo');
		populateDropDownOptions("DietRequestLocationTo",dietRequestLocSql);
		createNatureComboBox('Tab_CodeList_Fields','Nature','effStatus');
		hiddenFields.insertAdjacentHTML("BeforeEnd","<input type='hidden' name='PARAM1' id='PARAM1' value=''/ ><input type='hidden' name='PARAM2' id='PARAM2' value=''/ ><input type='hidden' name='PARAM3' id='PARAM3' value=''/ >");
		setReportId("DSDTREQLOC");
	   }
	   //ML-MMOH-CRF-684-US3
	else if(code=="MNT") {
		createComboBox('Tab_CodeList_Fields','Menu Type (From)','menuTypeFrom');
		populateDropDownOptions("menuTypeFrom",menuTypeSql);
		createComboBox('Tab_CodeList_Fields','Menu Type (To)','menuTypeTo');
		populateDropDownOptions("menuTypeTo",menuTypeSql);
		createNatureComboBox('Tab_CodeList_Fields','Nature','effStatus');
		hiddenFields.insertAdjacentHTML("BeforeEnd","<input type='hidden' name='PARAM1' id='PARAM1' value=''/ ><input type='hidden' name='PARAM2' id='PARAM2' value=''/ ><input type='hidden' name='PARAM3' id='PARAM3' value=''/ >");
		setReportId("DSMENUTYP");
	}
	//ML-MMOH-CRF-684-US3
}

function createComboBox(tabId,labelName,fieldName,isOnchangeFunctionEnabled,onChangeFunction) {
	var tabObj=document.getElementById(tabId);
	var row=tabObj.insertRow();
	var label=row.insertCell();
	label.className="label";

	var lengthRequired = 50;
	var tempString=labelName;
	while (tempString.length<lengthRequired){
		tempString += " ";
	}

	label.insertAdjacentHTML("BeforeEnd",tempString);
	row.insertCell();
	row.insertCell();
	row.insertCell();
	row.insertCell();

	var field=row.insertCell();
	if(isOnchangeFunctionEnabled==true)field.insertAdjacentHTML("BeforeEnd","<select name='"+fieldName+"' id='"+fieldName+"' onchange='"+onChangeFunction+"()'>");
	else field.insertAdjacentHTML("BeforeEnd","<select name='"+fieldName+"' id='"+fieldName+"'>");
}

function createNatureComboBox(tabId,labelName,fieldName) {
	var tabObj=document.getElementById(tabId);
	var row=tabObj.insertRow();
	var label_nature=row.insertCell();
	label_nature.className="label";

	var lengthRequired = 50;
	var tempString=labelName;
	while (tempString.length<lengthRequired){
		tempString += " ";
	}

	label_nature.insertAdjacentHTML("BeforeEnd",tempString);
	row.insertCell();
	row.insertCell();
	row.insertCell();
	row.insertCell();

	var field_nature=row.insertCell();
	field_nature.insertAdjacentHTML("BeforeEnd","<select name='"+fieldName+"' id='"+fieldName+"'><option value=''>All</option><option value='E'>Enabled</option><option value='D'>Disabled</option></select>");

}

function populateDropDownOptions(id,query){

	//var obj=document.getElementById(id);
	var obj=document.RepDSMasterCodesForm[id];
	var formObj = parent.frames[1].document.forms[0];
/*	var xmldoc = new ActiveXObject( "Microsoft.XMLDom" ) ;
	var xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");*/
	var xmlstr = "<root><SEARCH  /></root>";
	/*xmldoc.loadXML(xmlstr);*/
	var xmlhttp = new XMLHttpRequest();
	var xmldoc = new DOMParser().parseFromString(xmlstr, "text/xml")
	xmlhttp.open("POST","../../eDS/jsp/DLCommonValidation.jsp?func_mode=getMasterCodeList&query="+query,false);
	xmlhttp.send(xmldoc);
	var retVal = trimString(xmlhttp.responseText);
	if(retVal!=''){
		var retValArr = retVal.split("##");
		var listOption1	= document.createElement('OPTION');
		var msg = "----select----"
		listOption1.text = msg;
		listOption1.value= "";
		obj.add(listOption1);

		if(retValArr!=''){
			for(var i=0; i<retValArr.length; i++){
				retArr = retValArr[i].split("::");
				var listOption	= document.createElement('option');

				listOption.value = retArr[0];
				listOption.text = retArr[1];

				obj.add(listOption);
			}
		}
	}
	//Added against 60675 starts
	else{
		var listOption1	= document.createElement('OPTION');
		var msg = "----select----"
		listOption1.text = msg;
		listOption1.value= "";
		obj.add(listOption1);	
	}
	//Added against 60675 ends
}

function run() {

	var rep = parent.content.f_query_rep.RepDSMasterCodesForm["repId"].value;
	if(rep == "DSRDTYPE"){

		// 1. DIET TYPE
		parent.content.f_query_rep.RepDSMasterCodesForm["report_id"].value = "DSRDTYPE";
		parent.content.f_query_rep.RepDSMasterCodesForm["p_report_id"].value = "DSRDTYPE";
		parent.content.f_query_rep.RepDSMasterCodesForm["PARAM1"].value = parent.content.f_query_rep.RepDSMasterCodesForm["dietTypeFrom"].value;
		parent.content.f_query_rep.RepDSMasterCodesForm["PARAM2"].value = parent.content.f_query_rep.RepDSMasterCodesForm["dietTypeTo"].value;
		parent.content.f_query_rep.RepDSMasterCodesForm["PARAM3"].value = parent.content.f_query_rep.RepDSMasterCodesForm["effStatus"].value;
		getReport();

	}else if(rep == "DSRMCLAS"){

	// 2. MEAL CLASS
		parent.content.f_query_rep.RepDSMasterCodesForm["report_id"].value = "DSRMCLAS";
		parent.content.f_query_rep.RepDSMasterCodesForm["p_report_id"].value = "DSRMCLAS";
		parent.content.f_query_rep.RepDSMasterCodesForm["PARAM1"].value = parent.content.f_query_rep.RepDSMasterCodesForm["mealClassFrom"].value;
		parent.content.f_query_rep.RepDSMasterCodesForm["PARAM2"].value = parent.content.f_query_rep.RepDSMasterCodesForm["mealClassTo"].value;
		parent.content.f_query_rep.RepDSMasterCodesForm["PARAM3"].value = parent.content.f_query_rep.RepDSMasterCodesForm["effStatus"].value;
		getReport();

	}else if(rep == "DSRMTYPE"){

	// 3. MEAL TYPE
		parent.content.f_query_rep.RepDSMasterCodesForm["report_id"].value = "DSRMTYPE";
		parent.content.f_query_rep.RepDSMasterCodesForm["p_report_id"].value = "DSRMTYPE";
		parent.content.f_query_rep.RepDSMasterCodesForm["PARAM1"].value = parent.content.f_query_rep.RepDSMasterCodesForm["mealTypeFrom"].value;
		parent.content.f_query_rep.RepDSMasterCodesForm["PARAM2"].value = parent.content.f_query_rep.RepDSMasterCodesForm["mealTypeTo"].value;
		parent.content.f_query_rep.RepDSMasterCodesForm["PARAM3"].value = parent.content.f_query_rep.RepDSMasterCodesForm["effStatus"].value;
		getReport();

	}else if(rep == "DSRFTYPE"){

	// 4. FEED TYPE
		parent.content.f_query_rep.RepDSMasterCodesForm["report_id"].value = "DSRFTYPE";
		parent.content.f_query_rep.RepDSMasterCodesForm["p_report_id"].value = "DSRFTYPE";
		parent.content.f_query_rep.RepDSMasterCodesForm["PARAM1"].value = parent.content.f_query_rep.RepDSMasterCodesForm["feedTypeFrom"].value;
		parent.content.f_query_rep.RepDSMasterCodesForm["PARAM2"].value = parent.content.f_query_rep.RepDSMasterCodesForm["feedTypeTo"].value;
		parent.content.f_query_rep.RepDSMasterCodesForm["PARAM3"].value = parent.content.f_query_rep.RepDSMasterCodesForm["effStatus"].value;
		getReport();

	}else if(rep == "DSRITYPE"){

	// 5.ITEM TYPE
		parent.content.f_query_rep.RepDSMasterCodesForm["report_id"].value = "DSRITYPE";
		parent.content.f_query_rep.RepDSMasterCodesForm["p_report_id"].value = "DSRITYPE";
		parent.content.f_query_rep.RepDSMasterCodesForm["PARAM1"].value = parent.content.f_query_rep.RepDSMasterCodesForm["itemTypeFrom"].value;
		parent.content.f_query_rep.RepDSMasterCodesForm["PARAM2"].value = parent.content.f_query_rep.RepDSMasterCodesForm["itemTypeTo"].value;
		parent.content.f_query_rep.RepDSMasterCodesForm["PARAM3"].value = parent.content.f_query_rep.RepDSMasterCodesForm["effStatus"].value;
		getReport();

	}else if(rep == "DSRCMPLT"){

	// 6.COMPLAINTS
		parent.content.f_query_rep.RepDSMasterCodesForm["report_id"].value = "DSRCMPLT";
		parent.content.f_query_rep.RepDSMasterCodesForm["p_report_id"].value = "DSRCMPLT";
		parent.content.f_query_rep.RepDSMasterCodesForm["P_COMPLAINT_CODE_FROM"].value = parent.content.f_query_rep.RepDSMasterCodesForm["complaintCodeFrom"].value;
		parent.content.f_query_rep.RepDSMasterCodesForm["P_COMPLAINT_CODE_TO"].value = parent.content.f_query_rep.RepDSMasterCodesForm["complaintCodeFrom"].value;
		parent.content.f_query_rep.RepDSMasterCodesForm["P_STATUS"].value = parent.content.f_query_rep.RepDSMasterCodesForm["effStatus"].value;
		getReport();

	}else if(rep == "DSRDELIN"){

	// 7.DELIVERY INSTRUCTIONS
		parent.content.f_query_rep.RepDSMasterCodesForm["p_report_id"].value = "DSRDELIN";
		parent.content.f_query_rep.RepDSMasterCodesForm["report_id"].value = "DSRDELIN";
		parent.content.f_query_rep.RepDSMasterCodesForm["PARAM1"].value = parent.content.f_query_rep.RepDSMasterCodesForm["deliveryInstrFrom"].value;
		parent.content.f_query_rep.RepDSMasterCodesForm["PARAM2"].value = parent.content.f_query_rep.RepDSMasterCodesForm["deliveryInstrTo"].value;
		parent.content.f_query_rep.RepDSMasterCodesForm["PARAM3"].value = parent.content.f_query_rep.RepDSMasterCodesForm["effStatus"].value;
		getReport();

	}else if(rep == "DSRINGR"){

	// 8.INGREDIENTS
		parent.content.f_query_rep.RepDSMasterCodesForm["report_id"].value = "DSRINGR";
		parent.content.f_query_rep.RepDSMasterCodesForm["p_report_id"].value = "DSRINGR";
		parent.content.f_query_rep.RepDSMasterCodesForm["PARAM1"].value = parent.content.f_query_rep.RepDSMasterCodesForm["ingredientFrom"].value;
		parent.content.f_query_rep.RepDSMasterCodesForm["PARAM2"].value = parent.content.f_query_rep.RepDSMasterCodesForm["ingredientTo"].value;
		parent.content.f_query_rep.RepDSMasterCodesForm["PARAM3"].value = parent.content.f_query_rep.RepDSMasterCodesForm["effStatus"].value;
		getReport();

	}else if(rep == "DSRMLCAT"){
	// 9.MEAL CATEGORY

		parent.content.f_query_rep.RepDSMasterCodesForm["report_id"].value = "DSRMLCAT";
		parent.content.f_query_rep.RepDSMasterCodesForm["p_report_id"].value = "DSRMLCAT";
		parent.content.f_query_rep.RepDSMasterCodesForm["PARAM1"].value = parent.content.f_query_rep.RepDSMasterCodesForm["mealCategoryFrom"].value;
		parent.content.f_query_rep.RepDSMasterCodesForm["PARAM2"].value = parent.content.f_query_rep.RepDSMasterCodesForm["mealCategoryTo"].value;
		getReport();

	}else if(rep == "DSRKTCHN"){
	//10.KITCHENS

		parent.content.f_query_rep.RepDSMasterCodesForm["report_id"].value = "DSRKTCHN";
		parent.content.f_query_rep.RepDSMasterCodesForm["p_report_id"].value = "DSRKTCHN";
		parent.content.f_query_rep.RepDSMasterCodesForm["PARAM1"].value = parent.content.f_query_rep.RepDSMasterCodesForm["kitchenFrom"].value;
		parent.content.f_query_rep.RepDSMasterCodesForm["PARAM2"].value = parent.content.f_query_rep.RepDSMasterCodesForm["kitchenTo"].value;
		parent.content.f_query_rep.RepDSMasterCodesForm["PARAM3"].value = parent.content.f_query_rep.RepDSMasterCodesForm["effStatus"].value;
		getReport();
	}else if(rep == "DSRKITCH"){
	//11.KITCHEN AREA

		parent.content.f_query_rep.RepDSMasterCodesForm["report_id"].value = "DSRKITCH";
		parent.content.f_query_rep.RepDSMasterCodesForm["p_report_id"].value = "DSRKITCH";
		parent.content.f_query_rep.RepDSMasterCodesForm["PARAM4"].value = parent.content.f_query_rep.RepDSMasterCodesForm["kitchen"].value;
		parent.content.f_query_rep.RepDSMasterCodesForm["PARAM1"].value = parent.content.f_query_rep.RepDSMasterCodesForm["kitchenAreaFrom"].value;
		parent.content.f_query_rep.RepDSMasterCodesForm["PARAM2"].value = parent.content.f_query_rep.RepDSMasterCodesForm["kitchenAreaTo"].value;
		parent.content.f_query_rep.RepDSMasterCodesForm["PARAM3"].value = parent.content.f_query_rep.RepDSMasterCodesForm["effStatus"].value;
		getReport();

	}else if(rep == "DSRFITEM"){
	//12. FOOD ITEM

		parent.content.f_query_rep.RepDSMasterCodesForm["report_id"].value = "DSRFITEM";
		parent.content.f_query_rep.RepDSMasterCodesForm["p_report_id"].value = "DSRFITEM";
		parent.content.f_query_rep.RepDSMasterCodesForm["PARAM1"].value = parent.content.f_query_rep.RepDSMasterCodesForm["foodItemFrom"].value;
		parent.content.f_query_rep.RepDSMasterCodesForm["PARAM2"].value = parent.content.f_query_rep.RepDSMasterCodesForm["foodItemTo"].value;
		parent.content.f_query_rep.RepDSMasterCodesForm["PARAM3"].value = parent.content.f_query_rep.RepDSMasterCodesForm["effStatus"].value;
		parent.content.f_query_rep.RepDSMasterCodesForm["PARAM4"].value = parent.content.f_query_rep.RepDSMasterCodesForm["itemType"].value;
		getReport();

	}else if(rep == "DSRCOMFR"){
	//13. COMMERCIAL FORMULA

		parent.content.f_query_rep.RepDSMasterCodesForm["report_id"].value = "DSRCOMFR";
		parent.content.f_query_rep.RepDSMasterCodesForm["p_report_id"].value = "DSRCOMFR";
		parent.content.f_query_rep.RepDSMasterCodesForm["PARAM1"].value = parent.content.f_query_rep.RepDSMasterCodesForm["commercialFormulaFrom"].value;
		parent.content.f_query_rep.RepDSMasterCodesForm["PARAM2"].value = parent.content.f_query_rep.RepDSMasterCodesForm["commercialFormulaTo"].value;
		parent.content.f_query_rep.RepDSMasterCodesForm["PARAM3"].value = parent.content.f_query_rep.RepDSMasterCodesForm["effStatus"].value;
		parent.content.f_query_rep.RepDSMasterCodesForm["PARAM4"].value = parent.content.f_query_rep.RepDSMasterCodesForm["itemType"].value;
		getReport();

	}else if(rep == "DSRMENUC"){
	//14. MENU

		parent.content.f_query_rep.RepDSMasterCodesForm["report_id"].value = "DSRMENUC";
		parent.content.f_query_rep.RepDSMasterCodesForm["p_report_id"].value = "DSRMENUC";
		parent.content.f_query_rep.RepDSMasterCodesForm["PARAM1"].value = parent.content.f_query_rep.RepDSMasterCodesForm["menuFrom"].value;
		parent.content.f_query_rep.RepDSMasterCodesForm["PARAM2"].value = parent.content.f_query_rep.RepDSMasterCodesForm["menuTo"].value;
		parent.content.f_query_rep.RepDSMasterCodesForm["PARAM3"].value = parent.content.f_query_rep.RepDSMasterCodesForm["effStatus"].value;
		parent.content.f_query_rep.RepDSMasterCodesForm["PARAM4"].value = parent.content.f_query_rep.RepDSMasterCodesForm["dietType"].value;
		parent.content.f_query_rep.RepDSMasterCodesForm["PARAM5"].value = parent.content.f_query_rep.RepDSMasterCodesForm["mealType"].value;
		parent.content.f_query_rep.RepDSMasterCodesForm["PARAM6"].value = parent.content.f_query_rep.RepDSMasterCodesForm["mealClass"].value;
		getReport();

	}else if(rep == "DSRSCHED"){
	//15. MENU CYCLE

		parent.content.f_query_rep.RepDSMasterCodesForm["report_id"].value = "DSRSCHED";
		parent.content.f_query_rep.RepDSMasterCodesForm["p_report_id"].value = "DSRSCHED";
		parent.content.f_query_rep.RepDSMasterCodesForm["PARAM1"].value = parent.content.f_query_rep.RepDSMasterCodesForm["mealClass"].value;
		parent.content.f_query_rep.RepDSMasterCodesForm["PARAM2"].value = parent.content.f_query_rep.RepDSMasterCodesForm["dietType"].value;
		parent.content.f_query_rep.RepDSMasterCodesForm["PARAM3"].value = parent.content.f_query_rep.RepDSMasterCodesForm["effStatus"].value;
		getReport();

	}else if(rep == "DSRTMTBL"){
	//16. MENU TIME TABLE

		parent.content.f_query_rep.RepDSMasterCodesForm["report_id"].value = "DSRTMTBL";
		parent.content.f_query_rep.RepDSMasterCodesForm["p_report_id"].value = "DSRTMTBL";
		parent.content.f_query_rep.RepDSMasterCodesForm["PARAM1"].value = parent.content.f_query_rep.RepDSMasterCodesForm["dietType"].value;
		parent.content.f_query_rep.RepDSMasterCodesForm["PARAM2"].value = parent.content.f_query_rep.RepDSMasterCodesForm["menuFrom"].value;
		parent.content.f_query_rep.RepDSMasterCodesForm["PARAM3"].value = parent.content.f_query_rep.RepDSMasterCodesForm["effStatus"].value;
		parent.content.f_query_rep.RepDSMasterCodesForm["PARAM4"].value = parent.content.f_query_rep.RepDSMasterCodesForm["menuTo"].value;
		getReport();

	}else if(rep == "DSRKTWRD"){
	//17. WARD FOR KITCHEN

		parent.content.f_query_rep.RepDSMasterCodesForm["report_id"].value = "DSRKTWRD";
		parent.content.f_query_rep.RepDSMasterCodesForm["p_report_id"].value = "DSRKTWRD";
		parent.content.f_query_rep.RepDSMasterCodesForm["P_KITCHEN_CODE_FROM"].value = parent.content.f_query_rep.RepDSMasterCodesForm["kitchenFrom"].value;
		parent.content.f_query_rep.RepDSMasterCodesForm["P_KITCHEN_CODE_TO"].value = parent.content.f_query_rep.RepDSMasterCodesForm["kitchenTo"].value;
		getReport();
	}else if(rep == "DSRNUTRT"){
	//18. NUTRIENT

		parent.content.f_query_rep.RepDSMasterCodesForm["report_id"].value = "DSRNUTRT";
		parent.content.f_query_rep.RepDSMasterCodesForm["p_report_id"].value = "DSRNUTRT";
		parent.content.f_query_rep.RepDSMasterCodesForm["P_NUTRIENT_FROM"].value = parent.content.f_query_rep.RepDSMasterCodesForm["nutrientFrom"].value;
		parent.content.f_query_rep.RepDSMasterCodesForm["P_NUTRIENT_TO"].value = parent.content.f_query_rep.RepDSMasterCodesForm["nutrientTo"].value;
		parent.content.f_query_rep.RepDSMasterCodesForm["P_STATUS"].value = parent.content.f_query_rep.RepDSMasterCodesForm["effStatus"].value;
		getReport();
	}
	//412-US6
	else if(rep=="DSRTXOFDT"){
	 //19. TEXTURE OF DIET
		parent.content.f_query_rep.RepDSMasterCodesForm["report_id"].value = "DSRTXOFDT";
		parent.content.f_query_rep.RepDSMasterCodesForm["p_report_id"].value = "DSRTXOFDT";
		parent.content.f_query_rep.RepDSMasterCodesForm["PARAM1"].value = parent.content.f_query_rep.RepDSMasterCodesForm["textureofdietFrom"].value;
		parent.content.f_query_rep.RepDSMasterCodesForm["PARAM2"].value = parent.content.f_query_rep.RepDSMasterCodesForm["textureofdietTo"].value;
		parent.content.f_query_rep.RepDSMasterCodesForm["PARAM3"].value = parent.content.f_query_rep.RepDSMasterCodesForm["effStatus"].value;
	    getReport();
	}
	//412-US6
	//419-US5
	 else if(rep=="DSDTREQLOC"){
	 //20.Diet request Location
       		parent.content.f_query_rep.RepDSMasterCodesForm["report_id"].value = "DSDTREQLOC";
		parent.content.f_query_rep.RepDSMasterCodesForm["p_report_id"].value = "DSDTREQLOC";
		parent.content.f_query_rep.RepDSMasterCodesForm["PARAM1"].value = parent.content.f_query_rep.RepDSMasterCodesForm["DietRequestLocationFrom"].value;
		parent.content.f_query_rep.RepDSMasterCodesForm["PARAM2"].value = parent.content.f_query_rep.RepDSMasterCodesForm["DietRequestLocationTo"].value;
		parent.content.f_query_rep.RepDSMasterCodesForm["PARAM3"].value = parent.content.f_query_rep.RepDSMasterCodesForm["effStatus"].value;
	    	getReport();
	}
	//ML-MMOH-CRF-684-US3
	else if(rep == "DSMENUTYP"){
	// MENU TYPE
	parent.content.f_query_rep.RepDSMasterCodesForm["report_id"].value = "DSMENUTYP";
	parent.content.f_query_rep.RepDSMasterCodesForm["p_report_id"].value = "DSMENUTYP";
	parent.content.f_query_rep.RepDSMasterCodesForm["PARAM1"].value = parent.content.f_query_rep.RepDSMasterCodesForm["menuTypeFrom"].value;
	parent.content.f_query_rep.RepDSMasterCodesForm["PARAM2"].value = parent.content.f_query_rep.RepDSMasterCodesForm["menuTypeTo"].value;
	parent.content.f_query_rep.RepDSMasterCodesForm["PARAM3"].value = parent.content.f_query_rep.RepDSMasterCodesForm["effStatus"].value;
	getReport();
	}
	//ML-MMOH-CRF-684-US3
}

function getReport(){
	var formObj=parent.content.f_query_rep.RepDSMasterCodesForm;
	formObj.action="../../eCommon/jsp/report_options.jsp";
	parent.content.f_query_rep.RepDSMasterCodesForm.submit();
}

function setReportId(repId) {
	var locale=document.RepDSMasterCodesForm["repId"].value=repId;
	var locale=document.RepDSMasterCodesForm["report_id"].value=repId;
	var locale=document.RepDSMasterCodesForm["p_report_id"].value=repId;
}

