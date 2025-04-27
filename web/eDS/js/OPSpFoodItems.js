/**
File Name			: OPSpFoodItems.js
File Description	: This is for selecting Special Food Items.
CRF#				: Bru-HIMS-CRF-230
Author				: Abirami
Date				: Aug-2013
**/

	//Global Declaration::
	var mealTypeStr1="";
	var foodARR = new Array();
	var countRowValue = 1;
	var	sl_flag=false;
	var	Apply_flag=false;

	//Function 1: mealTypeOPSpFoodItems - For selecting mealtypes
	async function mealTypeOPSpFoodItems(obj,fecthedMealTypes) {
		var mealtype = document.getElementById("mealType").value;
		var dialogUrl1 = "../../eDS/jsp/OPMealTypesForFrequency.jsp?&fecthedMealTypes="+fecthedMealTypes+"&mealtype="+mealtype;
		var mealTypesArray = new Array();	
		var dialogArguments = mealTypesArray;
		var dialogFeatures = "dialogHeight:38vh;dialogWidth:21vw;status:no;scroll:no";
		var returnVal2 = await window.showModalDialog(dialogUrl1, dialogArguments,dialogFeatures);
		
		if(returnVal2) {
			mealTypeStr1=returnVal2;
		}
	}
	
	//Function 2: ValidRecords - For selecting header fields to the table 
	function OPValidRecords()
	{
		//Declaration::
		var countRowValue = 0; 
			var tableObj = document.getElementById("listContentTable");
			var countRow = tableObj.rows.length;
			var row_ind = 1;
			var key_value = "";
		
		// Check the mandatory fields::
			if (document.all("itemType").value == "") {
					//alert("Item Type Cannot be Blank");
					alert(getMessage("DS_ITMTYPE_NOT_BLANK","DS"));
					return false;
				}
				if (document.all("foodDesc").value == "" || document.all("foodType").value == "") {
					//alert("Item CanNot be Blank");
					alert(getMessage("DS_ITM_NOT_BLANK","DS"));
					return false;
				}
				if (document.all("qty").value == "") {
					//alert("Qty. Cannot be Blank");
					alert(getMessage("DS_QTY_NOT_BLANK","DS"));
					return false;
				}
		// Check if Meal Type has entry::
		//alert('row:'+ document.getElementById("rowNo").value);
		if (document.getElementById("rowNo").value == "") {
		
			if (foodARR && foodARR.length > 0) {
				countRowValue = foodARR.length;
				for (var i = 1; i < foodARR.length; i++) {
					var obj = foodARR[i];
					if (obj != null) {
						if (obj[7] != "-1") {
							
							if(mealTypeStr1 == undefined){
								//alert("MealType can not be Blank...");
								alert(getMessage("DS_MEALTYPE_NOT_BLANK","DS"));
									return false;
							}
							var mt_attT=mealTypeStr1.split("*");
							// Check if this Food item is already selected::
							if(mt_attT != null || mt_attT != ""){
								if(mt_attT.length != 0 || mt_attT.length != "" || mt_attT.length != null){
									for(var k=0; k < mt_attT.length; k++){
										mt_attS = mt_attT[k].split("@");
										if(mt_attS[0] != undefined){
											if (obj[3] == document.all("foodDesc").value && obj[5] == mt_attS[0]) {
												//alert("This Food Item Is Already Exits");
												alert(getMessage("DS_FOODITM_EXIST","DS"));
												return false;
											}
										}
									}
								}
							}
						}
					}
				}

			}

			if(mealTypeStr1 == undefined || mealTypeStr1 == ""){
				//alert("MealType can not be Blank...")
				alert(getMessage("DS_MEALTYPE_NOT_BLANK","DS"));
					return false;
			}
			
		}else
		{
			countRowValue = document.getElementById("rowNo").value;
		}
		
		// Adding the values into the table::
		
		
		var mt_att1=mealTypeStr1.split("*");
		if(mt_att1 != null || mt_att1 != ""){
			if(mt_att1.length != 0 || mt_att1.length != "" || mt_att1.length != null){
				for(var k=0; k < mt_att1.length; k++){
					mt_att = mt_att1[k].split("@");
					if(mt_att[1] != undefined){
						var matchVar = mt_att[1].match("#");
						if("#" == matchVar){
						var mt_att2 = mt_att[1].split("#");
							for(var i=1; i < mt_att2.length; i++)
							{
								mt_att[1]=mt_att[1].replace("#"," ")
							}
						}
					}
					if( mt_att1[k] != "" ){
						
						//For getting Calori vlaues for entered Food Item:: 
						var foodType = document.all("foodType").value;
						var locale =document.getElementById("language_id").value;
						var mode = "KaloriForMeals";
						var paramType = "foodType="+foodType+"&mode="+mode+"&languageId="+locale;
						var xmlDoc="" ;
						var xmlHttp = new XMLHttpRequest() ;
						var xmlStr ="<root></root>";
						xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
						xmlHttp.open("POST", "../../servlet/eDS.PlaceMealOrderOPServlet?"+paramType,false);
						xmlHttp.send(xmlDoc);
						var retValue = localTrimString(xmlHttp.responseText);
						var getSplFoodItemCalori = retValue.split(",");
						var iCode = getSplFoodItemCalori[0];
						var Calori = getSplFoodItemCalori[1];
						var energyUom = getSplFoodItemCalori[2];
						var energyUomDesc = getSplFoodItemCalori[3]; //Added Against PMG2017-CRF-0012.1[IN:067191]
						var qty = document.all("qty").value;
						var CaloriT=parseFloat((Math.round(qty*Math.pow(10,2))/Math.pow(10,2)))*parseFloat((Math.round(Calori*Math.pow(10,2))/Math.pow(10,2)))
						//foodARR[countRowValue][9] =document.getElementById("servingUomCode").value;
						
						foodARR[countRowValue] = new Array();
						foodARR[countRowValue][0] = document.all("itemType").value;
						foodARR[countRowValue][1] = document.all("foodType").value;
						foodARR[countRowValue][2] = document.all("qty").value;
						foodARR[countRowValue][3] = document.all("foodDesc").value;
						foodARR[countRowValue][4] = document.all("itemType").options[document.all("itemType").selectedIndex].text;
						foodARR[countRowValue][5] = mt_att[0];
						foodARR[countRowValue][6] = mt_att[1];
						foodARR[countRowValue][7] = 0;
						//foodARR[countRowValue][8]=parseFloat((Math.round(CaloriT*Math.pow(10,2))/Math.pow(10,2)));
						foodARR[countRowValue][8]= Calori;
						foodARR[countRowValue][9]= energyUom;
						foodARR[countRowValue][10]= energyUomDesc; //Added Against PMG2017-CRF-0012.1[IN:067191]
						insFlag = true;	
						
						countRowValue++;
					}
				}
				mealTypeStr1 = "";
			}
		}
		
		while (tableObj.rows.length > 1) {
			tableObj.deleteRow(1);
		}
		for (var ntempCount = 0; ntempCount < foodARR.length; ntempCount++) { 
			var obj = foodARR[ntempCount];
			
			if (obj != null) {
			
				if (obj[7] != "-1") {
					var countRow = tableObj.rows.length;
					var row_ind = 1;

					var newRow = tableObj.insertRow(row_ind);
					var newCellitemType = newRow.insertCell(newRow.cells.length);
					var code = document.all("itemType").value + "-" + document.all("foodType").value;
					var sub = "<A href=\"#\" onclick=\"return fetchOPSpFoodItemRow('" + ntempCount + "', '" +foodARR[ntempCount][5]+"');\" >" + foodARR[ntempCount][4] + "</A>";
					
					//var sub = "<A href=\"#\" onclick=\"return ('" + ntempCount + "');\" >" + foodARR[ntempCount][4] + "</A>";
					newCellitemType.innerHTML = sub;
					
					var newCellFoodItem = newRow.insertCell(newRow.cells.length);
					newCellFoodItem.appendChild(document.createTextNode(foodARR[ntempCount][3])); //modified

					var newCellQty = newRow.insertCell(newRow.cells.length);
					var qty = foodARR[ntempCount][2]
					var Calori = foodARR[ntempCount][8]
					var CaloriT=parseFloat((Math.round(qty*Math.pow(10,2))/Math.pow(10,2)))*parseFloat((Math.round(Calori*Math.pow(10,2))/Math.pow(10,2)))
					var cUOM =parseFloat((Math.round(CaloriT*Math.pow(10,2))/Math.pow(10,2)));
					//newCellQty.appendChild(document.createTextNode(qty + " (" + cUOM + " " +foodARR[ntempCount][9] + " )")); //Commented Against PMG2017-CRF-0012.1[IN:067191]
					newCellQty.appendChild(document.createTextNode(qty + " (" + cUOM + " " +foodARR[ntempCount][10] + " )")); //Added Against PMG2017-CRF-0012.1[IN:067191]
					
					//newCellQty.appendChild(document.createTextNode(foodARR[ntempCount][2] + " (" + foodARR[ntempCount][8] + " " +foodARR[ntempCount][9] + " )"));

					var newCellMealType = newRow.insertCell(newRow.cells.length);
					newCellMealType.appendChild(document.createTextNode(foodARR[ntempCount][6]));		
				}
			}
		}
						
		document.getElementById("itemType").value = "";
		document.getElementById("foodDesc").value = "";
		document.getElementById("qty").value = "";
		document.getElementById("foodType").value = "";
		document.getElementById("rowNo").value = "";
		document.getElementById("mealType").value=""; 
	}
	
	
//Function 3: showLookupForItemType - For getting Item from lookup:
async function showLookupForOPItemType(obj) {	
	if (document.getElementById("itemType").value == "") {
		alert(getMessage("DS_ITMTYPE_NOT_BLANK","DS"));
		return;
	}
	var locale = document.getElementById("language_id").value;
	var argumentArray = new Array();
	var dataNameArray = new Array();
	var dataValueArray = new Array();
	var dataTypeArray = new Array();

	var sql = "SELECT A.FOOD_ITEM_CODE CODE, A.SHORT_DESC DESCRIPTION FROM DS_ITEMS A WHERE A.EFF_STATUS ='E' AND UPPER(A.ITEM_TYPE) LIKE UPPER('"+document.getElementById("itemType").value+"') AND UPPER(A.SHORT_DESC) LIKE UPPER(?) AND UPPER(A.FOOD_ITEM_CODE) LIKE UPPER(?) AND A.LANGUAGE_ID = '"+locale+"'";

	argumentArray[0] = sql;
	argumentArray[1] = dataNameArray;
	argumentArray[2] = dataValueArray;
	argumentArray[3] = dataTypeArray;
	argumentArray[4] = "2,1";
	argumentArray[5] = obj.value;
	argumentArray[6] = CODE_LINK;
	argumentArray[7] = CODE_DESC;

	retArr = await CommonLookup("Item", argumentArray);

	if (retArr != null  && retArr != "") {
		
		arr=unescape(retArr).split(",");
		document.getElementById("foodType").value = arr[0];
		document.getElementById("foodDesc").value = arr[1];
		var pArgumentArrayMap = "foodItemCode=" + arr[0];
	}
	}
	
	//Function 3: clearFood :
	function clearFood() {
		document.getElementById("foodType").value = "";
		document.getElementById("foodDesc").value = "";
	}
	
	//Function 4: For deleting Specialfood Item:
	function deleteOPSpItemRow() {
		mealTypeStr1="";
	
		if (document.getElementById("rowNo").value == "") {
			//alert("Please Select Atleast One Record to delete");
			alert(getMessage("DS_SEL_REC_TODEL","DS"));
			return false;
		}

		var tableObj = document.getElementById("listContentTable");
		if(tableObj.rows.length == 2){
			emptyFlag=false;
		}
		while (tableObj.rows.length > 1) {
			tableObj.deleteRow(1);
		}

		if (document.all("rowNo").value != "") {
			foodARR[document.all("rowNo").value][7] = "-1";
		}

	for (var ntempCount = 0; ntempCount < foodARR.length; ntempCount++) { 
	var obj = foodARR[ntempCount];
			
	if (obj != null) {
		if (obj[7] != "-1") {
			var countRow = tableObj.rows.length;
			var row_ind = 1;

			var newRow = tableObj.insertRow(row_ind);
			var newCellitemType = newRow.insertCell(newRow.cells.length);
			var code = document.getElementById("itemType").value + "-" + document.getElementById("foodType").value;
			var sub = "<A href=\"#\" onclick=\"return fetchOPSpFoodItemRow('" + ntempCount + "', '" +foodARR[ntempCount][5]+"');\" >" + foodARR[ntempCount][4] + "</A>";
					
		//	var sub = "<A href=\"#\" onclick=\"return fetchOPSpFoodItemRow('" + ntempCount + "');\" >" + foodARR[ntempCount][4] + "</A>";
			newCellitemType.innerHTML = sub;
					
			var newCellFoodItem = newRow.insertCell(newRow.cells.length);
			newCellFoodItem.appendChild(document.createTextNode(foodARR[ntempCount][3])); //modified

			var newCellQty = newRow.insertCell(newRow.cells.length);
			//newCellQty.appendChild(document.createTextNode(foodARR[ntempCount][2]));
			var qty = foodARR[ntempCount][2]
			var Calori = foodARR[ntempCount][8]
			var CaloriT=parseFloat((Math.round(qty*Math.pow(10,2))/Math.pow(10,2)))*parseFloat((Math.round(Calori*Math.pow(10,2))/Math.pow(10,2)))
			var cUOM =parseFloat((Math.round(CaloriT*Math.pow(10,2))/Math.pow(10,2)));
			//newCellQty.appendChild(document.createTextNode(qty + " (" + cUOM + " " +foodARR[ntempCount][9] + " )")); //Commented Against PMG2017-CRF-0012.1[IN:067191]
			newCellQty.appendChild(document.createTextNode(qty + " (" + cUOM + " " +foodARR[ntempCount][10] + " )")); //Added Against PMG2017-CRF-0012.1[IN:067191]

	//					newCellQty.appendChild(document.createTextNode(foodARR[ntempCount][2] + " (" + foodARR[ntempCount][8] + " " +foodARR[ntempCount][9] + " )"));

			var newCellMealType = newRow.insertCell(newRow.cells.length);
			newCellMealType.appendChild(document.createTextNode(foodARR[ntempCount][6]));		
				}
			}
		}
		document.getElementById("itemType").value = "";
		document.getElementById("foodDesc").value = "";
		document.getElementById("qty").value = "";
		document.getElementById("foodType").value = "";
		document.getElementById("rowNo").value = "";
		document.getElementById("mealType").value=""; 
	}
	
	//Function 5: Fetching the selected row value in the header: 
	function fetchOPSpFoodItemRow(fetRowCount, mealType) {
		//sl_flag=true;
		//Apply_flag=false;
		document.all("itemType").value = trim(foodARR[fetRowCount][0]);
		document.all("foodType").value = trim(foodARR[fetRowCount][1]);
		document.all("foodDesc").value = trim(foodARR[fetRowCount][3]);
		document.all("qty").value = trim(foodARR[fetRowCount][2]);
		document.getElementById("mealType").value = trim(foodARR[fetRowCount][5]);
		mealTypeStr1 = trim(foodARR[fetRowCount][5]) +"@"+trim(foodARR[fetRowCount][6])
		document.all("rowNo").value = fetRowCount;
		//document.all("delrowNo").value = delRowCount;	
	}
	
	//Function 6: Setting/Record the values on the Place Order Main Page:
	function setOPRecord()
	{
		var tmpSplfoodList = "";
		tmpSplfoodList += foodARR;
		var tbodyObj = document.getElementById("listContentTable");
		var countRow = tbodyObj.rows.length;
		if(countRow == 0){
			alert(getMessage("DS_SEL_RECORD","DS"));
			return false;
		}
		parent.document.querySelectorAll('#dialog-body')[parent.document.querySelectorAll('#dialog-body').length-1].contentWindow.returnValue = foodARR;
		//top.returnValue = foodARR;
		warnOnClose = true;
		//window.close();
		parent.document.querySelectorAll('#dialog_tag')[parent.document.querySelectorAll('#dialog_tag').length-1].close();
	}
	
	//Function 7: Closing the window:
	var warnOnClose = false;
	var warnMsg = "";
	function OPSpFoodClose()
	{
		warnOnClose = true;
		warnMsg = getMessage("DS_CONFIRM_TO_CONT","DS");
		
		if(window.confirm(warnMsg)){
			if(parent.document.querySelectorAll('#dialog_tag'))
				parent.document.querySelectorAll('#dialog_tag')[parent.document.querySelectorAll('#dialog_tag').length-1].close();
			else
				parent.parent.document.querySelectorAll('#dialog_tag')[parent.parent.document.querySelectorAll('#dialog_tag').length-1].close();
		}	//top.close();
		else
			warnOnClose = false;
	}
	
	window.onbeforeunload  = function OPautoClose() {
		if(!warnOnClose)
			return "";
	};
	
	// Non-function source:: The below code will be executed on this page load 
if(dialogArguments != "undefined" && dialogArguments != "")
{		
	var tmpFoodArr = new Array();
	tmpFoodArr = dialogArguments.split(",");
	var tableObj = document.getElementById("listContentTable");
	var nRowCount = 0; 
	//var ndelRowCount = ((tmpFoodArr.length-1)/9);
	for (var nCount = 0; nCount < tmpFoodArr.length; ) {
	//for (var nCount = tmpFoodArr.length-1; nCount > 0;) {
	//Getting Special Food Items::
				
	foodARR[nRowCount] =  new Array();
	foodARR[nRowCount][0] = tmpFoodArr[nCount++];
	foodARR[nRowCount][1] = tmpFoodArr[nCount++];
	foodARR[nRowCount][2] = tmpFoodArr[nCount++];
	foodARR[nRowCount][3] = tmpFoodArr[nCount++];
	foodARR[nRowCount][4] = tmpFoodArr[nCount++];
	foodARR[nRowCount][5] = tmpFoodArr[nCount++];
	foodARR[nRowCount][6] = tmpFoodArr[nCount++];
	foodARR[nRowCount][7] = tmpFoodArr[nCount++];
	foodARR[nRowCount][8] = tmpFoodArr[nCount++];
	foodARR[nRowCount][9] = tmpFoodArr[nCount++];
	foodARR[nRowCount][10] = tmpFoodArr[nCount++];  //Added Against PMG2017-CRF-0012.1[IN:067191]
					
					
	if (foodARR[nRowCount][7] != null) {
		if (foodARR[nRowCount][7] != "-1") {
			var countRow = tableObj.rows.length;
			var row_ind = 1;

			var newRow = tableObj.insertRow(row_ind);
			var newCellitemType = newRow.insertCell(newRow.cells.length);
			var code = document.all("itemType").value + "-" + document.all("foodType").value;
			var sub = "<A href=\"#\" onclick=\"return fetchOPSpFoodItemRow('" + nRowCount + "', '" +foodARR[nRowCount][5]+"');\" >" + foodARR[nRowCount][4] + "</A>";
			newCellitemType.innerHTML = sub;
							
			var newCellFoodItem = newRow.insertCell(newRow.cells.length);
			newCellFoodItem.appendChild(document.createTextNode(foodARR[nRowCount][3]));//modified

			var newCellQty = newRow.insertCell(newRow.cells.length);
			//newCellQty.appendChild(document.createTextNode(foodARR[nRowCount][2]));
			var qty = foodARR[nRowCount][2]
			var Calori = foodARR[nRowCount][8]
			var CaloriT=parseFloat((Math.round(qty*Math.pow(10,2))/Math.pow(10,2)))*parseFloat((Math.round(Calori*Math.pow(10,2))/Math.pow(10,2)))
			var cUOM =parseFloat((Math.round(CaloriT*Math.pow(10,2))/Math.pow(10,2)));
			//newCellQty.appendChild(document.createTextNode(qty + " (" + cUOM + " " +foodARR[nRowCount][9] + " )")); // commented Against PMG-CRF-0012.1
			newCellQty.appendChild(document.createTextNode(qty + " (" + cUOM + " " +foodARR[nRowCount][10] + " )")); //Added Against PMG-crf-0012.1

			var newCellMealType = newRow.insertCell(newRow.cells.length);
			newCellMealType.appendChild(document.createTextNode(foodARR[nRowCount][6]));
				
				}
			}
			nRowCount++;
			//ndelRowCount--;
		}
		document.getElementById("itemType").value = "";
		document.getElementById("foodDesc").value = "";
		document.getElementById("qty").value = "";
		document.getElementById("foodType").value = "";
		document.getElementById("rowNo").value = "";
		}
		
