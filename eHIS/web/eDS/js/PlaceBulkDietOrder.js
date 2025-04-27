var arr=new Array();
var dietTypeArray=new Array();
var dietTypeDescArray=new Array();
var mealTypeArray=new Array();
var mealTypeDescArray=new Array();
var mealTypesArray = new Array();
var nonFreqItemsArr=new Array();
var freqItemsArr=new Array();
var spclFoodItemsArr=new Array();
var mealTypeStr1;
var TotalCalorie=0;
var freqJSONObject=new Object();
var nonFreqJSONObject=new Object();
var specialFoodItemsObject=new Object();
var jsonPatientObject_Dislikes=new Object();
var jsonPatientObject_Spl=new Object();

var jsonPatientArr_Dislikes = new Array();
var jsonPatientArr_Spl = new Array();

var returnRemarks = null;
var _dTypeArr = new Array();
var _mTypeArr = new Array();

var fetchedMealTypesWithTime = new Array();//428
var excludedMeals={};
var manualexcludedMeals={};//428
var exclusionFlag=false;
var automatic_excluded_meal_types=new Array();//428
var Menu_Flag=true;//409
var irregular_meal_flag=false;//409
var irregular_meal_code="";//409
var selectedEncounterId="";//will contain the on load encounterId-CRF-410

function fetchDietType (val) {
	//Added against MMS-KH-CRF-0029.1 Starts Here
	encountID = encounter_IDs(); 
	document.getElementById("encounter").value = encountID;
	var length = encountID.length;
	for(var i=0;i<length;i++)
	{
		if(document.getElementById("rem_"+encountID[i]).style.visibility == 'visible' || document.getElementById("MenuImage"+encountID[i]).style.visibility == 'visible')
		{
			document.getElementById("rem_"+encountID[i]).style.visibility = 'hidden';	
			document.getElementById("MenuImage"+encountID[i]).style.visibility = 'hidden';
		}
	if(document.getElementById("patientRow"+encountID[i]).disabled==true)
	{
		document.getElementById("patientRow"+encountID[i]).disabled = false;
	}
	}
	//Added against MMS-KH-CRF-0029.1 Ends Here
	// Added for ML-MMOH-CRF-0820	
	var patientClass =document.getElementById("patientClass").value;
	var patclass_split =patientClass.split('~');
	var patientSplit =patclass_split[1];
	patientClass=patientSplit;	
	 // Added for ML-MMOH-CRF-0820
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest() ;
	var xmlStr ="<root></root>";
	var patientObject=new Object();
	patientObject=parent.patientsObj;
	param="&gender="+parent.gender+"&maxAge="+parent.averageAge+"&ageUnit=Y&mode=fetchAgeGroupCode&jsonPatientObject="+JSON.stringify(patientObject)+"&patientClass="+patientClass;// Added for ML-MMOH-CRF-0820
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST", "../../servlet/eDS.PlaceBulkDietOrderServlet?"+param,false);
	xmlHttp.send(xmlDoc);
	retVal = xmlHttp.responseText;
	var jsonObj=eval('(' + retVal + ')');
	
	var language_Id =document.getElementById("languageId").value;
	var dietCategory =document.getElementById("dietCategory").value;
	var diettypeauto=document.getElementById("diettype_auto").value;//Added Against ML-MMOH-CRF-0674
	arr=jsonObj.ageGroup;
	var obj = document.getElementById("dietType");
	
	if(arr != null) {
		var mode="fetchDietTypes";
		var xmlDoc = "" ;
		var xmlHttp = new XMLHttpRequest() ;
		var xmlStr ="<root></root>";
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		
		var jsonDataObject = new Object();
		jsonDataObject.languageId=language_Id;
		jsonDataObject.dietCategory=dietCategory;
		jsonDataObject.ageGroupArr=arr;
		jsonDataObject.diettype_auto=diettypeauto;//Added Against ML-MMOH-CRF-0674
		var jsonData = JSON.stringify(jsonDataObject);
		
		param="jsonData="+jsonData+"&mode="+mode+"&patientClass="+patientClass;// Added for ML-MMOH-CRF-0820
		xmlHttp.open("POST", "../../servlet/eDS.PlaceBulkDietOrderServlet?"+param,false);
		xmlHttp.send(xmlDoc);
		var retVal = xmlHttp.responseText;
		var jsonObjResponse=eval('(' + retVal + ')');
		dietTypeArray=jsonObjResponse.dietTypeCode;
		dietTypeDescArray=jsonObjResponse.dietTypeDesc;
		
		while(obj.length > 0){
			obj.remove(0);
		}
		var Entry = document.createElement("OPTION");
		var msg = "----select----";
		Entry.text = msg;
		Entry.value= "";
		obj.add(Entry);
		if(dietTypeArray!=null) {
			for(var j=0; j < dietTypeArray.length; j++){
				var Entry = document.createElement("option");
				Entry.value  = dietTypeArray[j];
				Entry.text  = dietTypeDescArray[j];
				obj.add(Entry);
			}
		}
	}
	//Added Against ML-MMOH-CRF-0674 Starts Here
		var str=document.getElementById("dietType").value;
		var auto_flag=document.getElementById("auto_flag").value
	if(str == "" && auto_flag == "true")
	{
		var sel = document.getElementById('dietType');
		var len = sel.options.length;
		if(len <= 3)
			sel.setAttribute('size', len);
		else
			sel.setAttribute('size', 3);
	}
	else if(str != "" &&  auto_flag == "false2")
	{
		var sel = document.getElementById('dietTypes');
		var len = sel.options.length;
		if(len <= 3)
			sel.setAttribute('size', len);
		else
			sel.setAttribute('size', 3);
	}
	//Added Against ML-MMOH-CRF-0674 Ends Here
}

function fecthDietTypeToMealClass(){
	//Added against MMS-KH-CRF-0029.1 Starts Here
	encountID = encounter_IDs(); 
	document.getElementById("encounter").value = encountID;
	var length = encountID.length;
	for(var i=0;i<length;i++)
	{
		if(document.getElementById("rem_"+encountID[i]).style.visibility == 'visible' || document.getElementById("MenuImage"+encountID[i]).style.visibility == 'visible')
		{
			document.getElementById("rem_"+encountID[i]).style.visibility = 'hidden';	
			document.getElementById("MenuImage"+encountID[i]).style.visibility = 'hidden';
		}
	if(document.getElementById("patientRow"+encountID[i]).disabled==true)
	{
		document.getElementById("patientRow"+encountID[i]).disabled = false;
	}
	}
	//Added against MMS-KH-CRF-0029.1 Ends Here
	var dietType=document.getElementById("dietType").value;
	var dietCategory=document.getElementById("dietCategory").value;
	var mealClass=document.getElementById("mealClass").value;

	if(dietType!="" && dietCategory!="" && mealClass!="") {
		fecthMealTypeOptions(document.getElementById("dietType").value);
	}
	else return;
}

function fecthMealTypeOptions(val){
	var language_Id =document.getElementById("languageId").value;
	var dietType =document.getElementById("dietType").value;
	var mealClass = document.getElementById("mealClass").value;
	var kitchenCode =document.getElementById("kitchenCode").value;
	fetchMealTypeOptionsWithTime();//CRF-428
	var mode = "mealTypeList";
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest() ;
	var xmlStr ="<root></root>";
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	
	var jsonDataObject = new Object();
	jsonDataObject.languageId=language_Id;
	jsonDataObject.dietCategory=document.getElementById("dietCategory").value;
	jsonDataObject.dietType=dietType;
	jsonDataObject.mealClass=mealClass;
	jsonDataObject.kitchenCode=kitchenCode;
	jsonDataObject.ageGroupArr=arr;
	var jsonData = JSON.stringify(jsonDataObject);
	
	param="mode="+mode+"&jsonData="+jsonData;
	xmlHttp.open("POST", "../../servlet/eDS.PlaceBulkDietOrderServlet?"+param,false);
	xmlHttp.send(xmlDoc);
	retVal = xmlHttp.responseText;
	var jsonObjResponse=eval('(' + retVal + ')');
	
	
	mealTypeArray=jsonObjResponse.mealTypeCode;
	
	mealTypeDescArray=jsonObjResponse.mealTypeDesc;	
	
	var tableObj = null;
	var row_ind = 1;
	tableObj = document.getElementById("Able");
	while (tableObj.rows.length > 1) {
		tableObj.deleteRow(1);
	}
	tableObj3 = document.getElementById("treemenu3");

	while (tableObj3.rows.length > 0) {
		tableObj3.deleteRow(0);
	}
	tableObj4 = document.getElementById("treemenu4");
	while (tableObj4.rows.length > 0) {
		tableObj4.deleteRow(0);
	}
	var tbodyObj = document.all("dispGTC");
	if(tbodyObj.rows.length>=1)
		tbodyObj.deleteRow(0);	
	
	if(mealTypeArray !=null) {
			for(var i =0; i < mealTypeArray.length; i++){
				var selObj = "";
				var newRow = tableObj.insertRow(row_ind);
				var newCellDesc = newRow.insertCell(newRow.cells.length);
				newCellDesc.className = "label";
				newCellDesc.appendChild(document.createTextNode(mealTypeDescArray[i]));
				var newCell = newRow.insertCell(newRow.cells.length);
				var sel = "<input type='hidden' name='mealTypesforDietTypes' id='mealTypesforDietTypes' value='"+(mealTypeArray[i])+"'>";
				newCell.innerHTML = sel;
				var newCellCheck = newRow.insertCell(newRow.cells.length);
				var status = document.getElementById("dietTypesStatus").value;
				if (status == "Y") {
					var selObj = "<SELECT name='dietTypesForMeals' id='dietTypesForMeals' onChange='getMeals1(this.value,"+row_ind+")'; >";
				} else {
					var selObj = "<SELECT name='dietTypesForMeals' id='dietTypesForMeals' disabled='true'>";
				}
				var label=getLabel("Common.defaultSelect.label","Common");
				selObj += "<OPTION value=''>"+label+"</OPTION>";
				var obj = document.getElementById("dietType").value;
	
				for (var j=0; j < dietTypeArray.length;j++) {
						var value = (dietTypeArray[j]);
						var desc = (dietTypeDescArray[j]);
						if((dietTypeArray[j]) == (obj)){
							selObj += "<OPTION value='" + value + "' selected>" + desc + "</OPTION>";
						}else{
							selObj += "<OPTION value='" + value + "'>" + desc + "</OPTION>";
						}
	
				}
				selObj += "</SELECT><img src='../../eCommon/images/mandatory.gif' alt='pil' />";
				selObj += "<input type='hidden' name='isDietTypesChanged' id='isDietTypesChanged'  value='" +  + "'>";
				newCellCheck.innerHTML = selObj;
				found_flag = false;
				row_ind++;
		}
		getMeals();
	}
}

var ob = new Array();
var ob1 = new Array();

function getMeals() {
	if (document.getElementById("mealClass").value != "" && document.getElementById("dietType").value != "") {
		var language_Id =document.getElementById("languageId").value;
		_dTypeArr.splice(0,_dTypeArr.length);
		_mTypeArr.splice(0,_mTypeArr.length);

		var count = 0;
		var ctr = 0;

		ob[0] = document.getElementById("dietType").value;
		var objsFields = new Array();
		var obj = document.getElementsByName("dietTypesForMeals");
		if(obj != null){
			for (var i = 0; i < obj.length; i++) {
				var flag = false;
				for (var j = 0; j < ob.length; j++) {
					if (obj[i].value == ob[j]) {
						if (obj[i].value != "") {
							flag = true;
						}
					}
				}
				ob[count++] = obj[i].value;
/*					if (!flag) {
						ob[count++] = obj[i].value;
					}else{
						ob[count++] = obj[i].value;
					}
*/				}
		}
		var h=0;
		var obj = document.getElementsByName("dietTypesForMeals");
		if(obj != null){
			for(var k=0; k < obj.length; k++){
				_dTypeArr[h] = obj[k].value;
				h=h+1;
			}
		}

		var h=0;
		var obj2 = document.getElementsByName("mealTypesforDietTypes")
		if(obj2 != null){
			for(var k=0; k < obj2.length; k++){
				ob1[h] = obj2[k].value;
				_mTypeArr[h] = obj2[k].value;
				h=h+1;
			}
		}

		var mode = "DayRefNo";
		var language_Id =document.getElementById("languageId").value;
		
		if (document.getElementById("mealClass").value != "" && document.getElementById("dietType").value != "") {
			var xmlDoc = "" ;
			var xmlHttp = new XMLHttpRequest() ;
			var xmlStr ="<root></root>";
			xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
			
			var jsonDataObject = new Object();
			jsonDataObject.languageId=language_Id;
			jsonDataObject.dateForMenu=document.getElementById("dateForMenu").value;
			jsonDataObject.dietType=document.getElementById("dietType").value;
			jsonDataObject.mealClass=document.getElementById("mealClass").value;
			jsonDataObject.facility=document.getElementById("addedFacilityId").value;
			var jsonData = JSON.stringify(jsonDataObject);
			
			xmlHttp.open("POST", "../../servlet/eDS.PlaceBulkDietOrderServlet?mode="+mode+"&jsonData="+jsonData,false);
			xmlHttp.send(xmlDoc);
			retVal = (xmlHttp.responseText);
			var jsonObjResponse=eval('(' + retVal + ')');
			var dayRef=(jsonObjResponse.dayRefNum);
			
			var obj = document.getElementById("dayRef");
			if(retVal != null && (retVal).length != 0){
				var Entry = document.createElement("option");
				Entry.value  = (dayRef);
				Entry.text  = (dayRef);
				obj.add(Entry);
			}
			if (retVal == "0") {
			}else {
				document.getElementById("dayRef").value = dayRef;
			}
			getMealContent();
		}
		function getMealContent(){
			var mode = "MealContent";
			var language_Id =document.getElementById("languageId").value;
			
			var xmlDoc = "" ;
			var xmlHttp = new XMLHttpRequest() ;
			var xmlStr ="<root></root>";
			var param="&locale="+language_Id+"&_mTypeArr="+_mTypeArr+"&mClass="+document.getElementById("mealClass").value+"&_dTypeArr="+_dTypeArr+"&profileSL="+document.getElementById("profileSL").value+"&encounterId="+document.getElementById("encounterId").value+"&dateForMeanu="+document.getElementById("dateForMenu").value+"&dayRef="+document.getElementById("dayRef").value+"&kitchenCode="+document.getElementById("kitchenCode").value+"&addedFacilityId="+document.getElementById("addedFacilityId").value+"&dietType="+document.getElementById("dietType").value+"&mode="+mode;
			xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
			var jsonDataObject = new Object();
			jsonDataObject.locale=language_Id;
			jsonDataObject.dateForMeanu=document.getElementById("dateForMenu").value;
			jsonDataObject.dietType=document.getElementById("dietType").value;
			jsonDataObject.mClass=document.getElementById("mealClass").value;
			jsonDataObject.addedFacilityId=document.getElementById("addedFacilityId").value;
			jsonDataObject.profileSL=document.getElementById("profileSL").value;
			jsonDataObject.encounterId=document.getElementById("encounterId").value;
			jsonDataObject.dayRef=document.getElementById("dayRef").value;
			jsonDataObject.kitchenCode=document.getElementById("kitchenCode").value;
			jsonDataObject._dTypeArr=_dTypeArr;
			jsonDataObject._mTypeArr=_mTypeArr;
			var jsonData = JSON.stringify(jsonDataObject);
			xmlHttp.open("POST", "../../servlet/eDS.PlaceBulkDietOrderServlet?mode="+mode+"&jsonData="+jsonData,false);
			xmlHttp.send(xmlDoc);
			retVal = (xmlHttp.responseText);
			var jsonObjResponse=eval('(' + retVal + ')');
			if(jsonObjResponse != null){
				assignMealItem(jsonObjResponse);
			}
		}
	}
}


var code = false;
var energyUom="";

function assignMealItem(jsonObjResponse){
	var MealItemsArray=new Array();
	MealItemsArray=jsonObjResponse.menuItem;
	var k=0;

	parent.document.getElementById("MealItemsArray").value=MealItemsArray;
	document.getElementById("mealTotalCalorie").value=0
	var dayRef = document.getElementById("dayRef").value;
	if(MealItemsArray != null){
		var row_ind1=0;
		var index=0;
		var nextIncre = 0;
		var tableObj = null;
		var i = 1;
		var found_flag = false;
		var qryEven = "QRYEVEN";
		var qryOdd = "QRYODD";
		var total = 0;
		 
		tableObj3 = document.getElementById("treemenu3");

		while (tableObj3.rows.length > 0) {
			tableObj3.deleteRow(0);
		}
		var selObj = "";

		count = 0;
		var totalCalori=0;
		var mealTypeIndex=0;

		var temp = new Array();
		temp[0] = "test";

		for(var itr=0,j=0; itr < MealItemsArray.length;itr++){
			var jsonobj=MealItemsArray[itr];
			
			if(itr !=MealItemsArray.length -1) var jsonobjNext=MealItemsArray[itr+1];
			else var jsonobjNext=MealItemsArray[itr];
			
			if (!code) {
				code = true;
			}
			var classVal = (itr % 2 == 0) ? qryEven : qryOdd;
			for(var k=0; k < temp.length; k++)
			{
				if((jsonobj.shortDesc != temp[j])){
					temp[j+1] = jsonobj.shortDesc;
					var newRow3 = tableObj3.insertRow(row_ind1);
					var newCellDesc = newRow3.insertCell(newRow3.cells.length);
					newCellDesc.className = "lable";
					newCellDesc.className = classVal;
					newCellDesc.colSpan = "3";//Modified against KDAH-CRF-0352 9 to 3
					newCellDesc.align = "left";
					newCellDesc.setAttribute("border", "0px");
					newCellDesc.style.fontSize ="10pt"
					newCellDesc.style.fontWeight = "700"
					newCellDesc.style.color = "#4E387E"
					newCellDesc.appendChild(document.createTextNode(jsonobj.shortDesc));
					
					//Added against KDAH-CRF-0352 Starts Here
					var newCellDesc1 = newRow3.insertCell(newRow3.cells.length);
					newCellDesc1.className = "lable";
					newCellDesc1.className = classVal;
					newCellDesc1.colSpan = "3";
					newCellDesc1.align = "left";
					newCellDesc1.setAttribute("border", "0px");
					newCellDesc1.style.fontSize ="10pt"
					newCellDesc1.style.fontWeight = "700"
					newCellDesc1.style.color = "#4E387E"
					newCellDesc1.appendChild(document.createTextNode("Qty"));
					
					var newCellDesc2 = newRow3.insertCell(newRow3.cells.length);
					newCellDesc2.className = "lable";
					newCellDesc2.className = classVal;
					newCellDesc2.colSpan = "1";
					newCellDesc2.align = "left";
					newCellDesc2.setAttribute("border", "0px");
					newCellDesc2.style.fontSize ="10pt"
					newCellDesc2.style.fontWeight = "700"
					newCellDesc2.style.color = "#4E387E"
					newCellDesc2.appendChild(document.createTextNode("Calorie"));
					//Added against KDAH-CRF-0352 Ends Here	
					
					row_ind1=row_ind1+1;
					j++;
				}
			}
			var cal1=0;
			var flag = false;
			
			var calori = parseInt(jsonobj.itemQty)*parseFloat((Math.round((jsonobj.calorificCont)*Math.pow(10,2))/Math.pow(10,2)));
			if(calori == "NaN")
				calori = 0.0
			if(cal1 == "NaN")
				cal1 = 0.0
			cal1=parseFloat(cal1)+parseFloat(calori);
			servingUom=jsonobj.energy_Uom;

			var newRow4 = tableObj3.insertRow(row_ind1);
			var newCell1 = newRow4.insertCell(newRow4.cells.length);
			var newCell2 = newRow4.insertCell(newRow4.cells.length);
			var newCell3 = newRow4.insertCell(newRow4.cells.length);
			if(flag){
				newCell1.style.color = "Red";
				newCell2.style.color = "Red";
				newCell3.style.color = "Red";
			}else{
				newCell1.style.color = "Navy";
				newCell2.style.color = "Navy";
				newCell3.style.color = "Navy";
			}
			var qSUC =  jsonobj.shortDesc1;

			newCell1.className = "label";
			newCell1.className = classVal;
			newCell1.align = "left";
			newCell1.colSpan = "3";
			newCell1.style.fontSize ="8pt"
			newCell1.appendChild(document.createTextNode(qSUC));

			//var qtty = jsonobj.itemQty+ " "+ jsonobj.servUOMCode.toLowerCase();
			var qtty = jsonobj.itemQty+ " "+ jsonobj.servingUom_Desc.toLowerCase();//Modified Against KDAH-CRF-0352
			newCell2.className = "lable";
			newCell2.className = classVal;
			newCell2.align = "left";
			newCell2.style.fontSize ="8pt"
			newCell2.colSpan = "3";
			newCell2.appendChild(document.createTextNode(qtty));

			//var calEUomCode = parseFloat((Math.round(calori*Math.pow(10,2))/Math.pow(10,2)))+" "+jsonobj.energyUom.toLowerCase();
			var calEUomCode = parseFloat((Math.round(calori*Math.pow(10,2))/Math.pow(10,2)))+" "+jsonobj.energyUom_Desc.toLowerCase();//Modified against KDAH-CRF-0352
			newCell3.className = "lable";
			newCell3.className = classVal;
			newCell3.style.fontSize ="8pt"
			newCell3.align = "left";
			newCell3.colSpan = "3";
			newCell3.bold = "bold";
			newCell3.appendChild(document.createTextNode(calEUomCode));
			row_ind1=row_ind1+1;

			//var str = "total";
			var str = getLabel("eDS.Total.Label","DS"); 
			var msg = str+" :";
			var acli = parseFloat((Math.round(cal1*Math.pow(10,2))/Math.pow(10,2)));
			totalCalori=parseFloat((Math.round(totalCalori*Math.pow(10,2))/Math.pow(10,2)))+parseFloat((Math.round(cal1*Math.pow(10,2))/Math.pow(10,2)));
			total = total+acli;
			var acliUom = total;
			//energyUom = jsonobj.energyUom.toLowerCase();
			energyUom = jsonobj.energyUom_Desc.toLowerCase();//Modified against KDAH-CRF-0352
			if(jsonobj.mealType != jsonobjNext.mealType || itr == 0){
				var newRow5 = tableObj3.insertRow(row_ind1);
				var newCell1 = newRow5.insertCell(newRow5.cells.length);
				var newCell2 = newRow5.insertCell(newRow5.cells.length);

				newCell1.className = "lable";
				newCell1.className = classVal;
				newCell1.style.fontWeight = "700";
				newCell1.style.fontSize ="8pt";
				newCell1.style.color ="#2B1B17";
				newCell1.align = "left";
				newCell1.colSpan = "6";

				newCell2.className = "lable";
				newCell2.className = classVal;
				newCell2.style.fontSize ="8pt"
				newCell2.style.color ="#2B1B17"
				newCell2.style.fontWeight = "700"
				newCell2.align = "left";
				newCell2.colSpan = "3";
				row_ind1=row_ind1+1;
				newCell1.innerHTML = msg;
				newCell2.innerHTML = acliUom;
				total = 0;
			}
			mealTypeIndex=mealTypeIndex+1;
		}
		tableObj4 = document.getElementById("treemenu4");
		while (tableObj4.rows.length > 0) {
			tableObj4.deleteRow(0);
		}

		var newRow6 = tableObj4.insertRow(0);
		var newCell1 = newRow6.insertCell(newRow6.cells.length);
		var newCell2 = newRow6.insertCell(newRow6.cells.length);

		newCell1.className = "lable";
		newCell1.className = classVal;
		newCell1.style.color = "#2B1B17";
		newCell1.style.fontSize ="8pt"
		newCell1.style.fontWeight = "700"
		newCell1.align = "left";
		newCell1.colSpan = "6";

		newCell2.className = "lable";
		newCell2.className = classVal;
		newCell2.style.color = "#2B1B17";
		newCell2.style.fontSize ="8pt"
		newCell2.style.fontWeight = "700"
		newCell2.align = "left";
		newCell2.colSpan = "3";

		var str1 = getLabel("eDS.mealTotalCalorie.Label","DS");
		var msg1 = str1+" :";
		var tatalCali = totalCalori;
		newCell1.appendChild(document.createTextNode(msg1));
		newCell2.appendChild(document.createTextNode(tatalCali));

		document.getElementById("mealTotalCalorie").value=totalCalori;
	}
	calGTotalCalorie();
}

function calGTotalCalorie(){
	var mealTotalCalorie=document.getElementById("mealTotalCalorie").value;
	if(mealTotalCalorie=="")
		mealTotalCalorie=0;
	var tbodyObj = document.all("dispGTC");
	if(tbodyObj.rows.length>=1)
		tbodyObj.deleteRow(0);

	var newRow1 = tbodyObj.insertRow(0);
	var labelCel = newRow1.insertCell(newRow1.cells.length);
	var calorieCel = newRow1.insertCell(newRow1.cells.length);

	labelCel.className = "lable";
	labelCel.style.fontWeight = "700";
	labelCel.style.fontSize ="7pt";
	labelCel.style.color ="#2B1B17";
	labelCel.setAttribute("border", "0px");
	labelCel.align = "left";
	labelCel.colSpan = "3";

	calorieCel.className = "lable";
	calorieCel.style.fontWeight = "700";
	calorieCel.style.fontSize ="7pt";
	calorieCel.style.color ="#2B1B17";
	calorieCel.setAttribute("border", "0px");
	calorieCel.align = "left";
	calorieCel.colSpan = "1";

	var msg = getLabel("eDS.calorieGrandTotal.Label","DS"); 
	labelCel.appendChild(document.createTextNode(msg+" :"));

	if(isNaN(mealTotalCalorie))
		mealTotalCalorie = 0;
	var CGTotal = parseFloat(parseFloat((Math.round(mealTotalCalorie*Math.pow(10,2))/Math.pow(10,2))));

	CGTotal = (Math.round(CGTotal*Math.pow(10,2))/Math.pow(10,2));

	var CGTotalVal = CGTotal+" "+energyUom;

	calorieCel.appendChild(document.createTextNode(CGTotalVal));


}

function checkNull(){
//CRF-410 Starts
	var jsonPatientObject1=new Object();
	jsonPatientObject1=parent.patientsObj;

	var jsonPatientObject1_Arr =jsonPatientObject1.patients;

	var selectedEncounterIds={};//will contain the on load encounterId-CRF-410
	selectedEncounterId="";
	$.each(jsonPatientObject1_Arr,function(index,value) {
	
		selectedEncounterId+=value.patient.encounterId+",";
	});

selectedEncounterId=selectedEncounterId.substring(0,selectedEncounterId.length-1);
//CRF-410 Ends

//Added against MMS-KH-CRF-0029.1 Starts Here	
var encounterSplit = selectedEncounterId.split(",");
var length = encounterSplit.length;
	for(var i=0;i<length;i++)
	{
	if(document.getElementById("rem_"+encounterSplit[i]).style.visibility != 'hidden'){
	var rem = encodeURIComponent(document.getElementById("rem_"+encounterSplit[i]).value); 
	if(rem=="" || rem=="null" || rem=="undefined")
	{
		alert(getMessage("DS_REM_NOT_BLANK","DS"));
		return false;
		} }
	}
//Added against MMS-KH-CRF-0029.1 Ends Here		

	if (document.getElementById("from").value != "" && document.getElementById("to").value != "") {
		var languageId=document.getElementById("languageId").value;
		var flag = compareDates(document.getElementById("from").value,document.getElementById("to").value,'en',"DMYHM");
		if(flag== -1){
			var n_msg = "Nil By Mouth";
			var f_msg = "From Date";
			var t_msg = "To date";
			var msg = "should be greater than"
				var error=getMessage("DS_NBMTODAT_GRTREQL_FRMDAT","DS");//"Nil By Mouth To date should be greater than or equal to Nil By Mouth From date";
			parent.frames.messageFrame.location.href='../../eCommon/jsp/MstCodeError.jsp?err_num='+error
			return false;
		}else{
			oldOrderChk();
		}
	}else{
		oldOrderChk();
	}
}

function oldOrderChk(){
	if(document.getElementById("dateFrom").value != "" && document.getElementById("dateTo").value != ""){
		var locale=document.getElementById("languageId").value;
		var flag = isBeforeNow(document.getElementById("dateFrom").value,"DMY",locale);
		
		var date=new Date();
		var month=date.getMonth();
		var date1=date.getDate();
		var year=date.getYear();
		month+=1;
		if(date1<=9){
			date1="0"+""+date1;
		}
		if(month<=9){
			month="0"+""+month;
		}
		var sysDate=date1+"/"+month+"/"+year;
				if(flag){
			var flagT = compareDate(document.getElementById("dateTo").value,sysDate);
			if(flagT == -1){
				var error="";
				var msg = "App-DS0011 # should be greater than or equals to";
				var msg_key = msg.split("#");
				var f_date = "From Date";
				var t_date = "To Date";
				var s_date = "SysDate";
				error = error+" "+msg_key[0]+" "+t_date+" "+msg_key[1]+" "+s_date+"<br>"
				parent.frames.messageFrame.location.href='../../eCommon/jsp/MstCodeError.jsp?err_num='+error
			}else{
				checkNull1();
			}
		}else{
			checkNull1();
		}
	}else{
		checkNull1();
	}
}

function checkNull1() {
	//CRF-0684
	var isMenuType="";		
	if(document.getElementById("isMenuType")!=null)
	isMenuType=document.getElementById("isMenuType").value;
    if(isMenuType=="true"){
		var menu_type = document.getElementById("menu_type").value;
	}
	//CRF-0684
	tableObj = document.getElementById("Able");
	var flag_spl=false;
	if(tableObj.rows.length == 1){
		//var error = getMessage("DS_MENU_NOT_DEFINED","DS"); //Commented against ML-MMOH-CRF-1124
		var error = getMessage("DS_MENU_NOT_DEFINED_MC_DT","DS"); //ML-MMOH-CRF-1124
		Menu_Flag=false;//409
		parent.frames.messageFrame.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num="+error;
		return false;
	}
	var f1 = true;
	var objs = new Array();

	objs[0] = document.getElementById("dateFrom");
	objs[1] = document.getElementById("mealClass");
	objs[2] = document.getElementById("dietType");
	
	//ML-MMOH-CRF-0427 US3 starts
	var profileFlag=$('#profileFlag').val();
	var restrict_date_inpatients_yn=$('#restrict_date_inpatients_yn').val();
	var maximum_days_allowed=$('#maximum_days_allowed').val();
		
	if(profileFlag=="true" && restrict_date_inpatients_yn=="Y"){
		objs[3] = document.getElementById("dateTo");
	}
	//ML-MMOH-CRF-0427 US3 ends
    if(isMenuType=="true"){
		objs[4] = document.getElementById("menu_type");
	}
	var objsFields = new Array();

	objsFields[0] = "From Date";
    objsFields[1] = "Meal Class";
    objsFields[2] = "Diet Type";
	
	//ML-MMOH-CRF-0427 US3 starts
	if(profileFlag=="true" && restrict_date_inpatients_yn=="Y"){
		objsFields[3]="To Date";
	}
	//ML-MMOH-CRF-0427 US3 ends
	//CRF-0684
	 if(isMenuType=="true"){
		objsFields[4] = "Menu Type";
	 }
	 //CRF-0684
    if (!checkNulls(objsFields, objs)) {
        return false;
    }
    var objsFields = new Array();
    var obj = document.getElementsByName("dietTypesForMeals");
    var error = "";
    if(obj != null){
    	for (var i = 0; i < obj.length; i++) {
            if (obj[i].value == "") {
                var mesg = getMessage("DS_DIETFORMEAL_NOT_BLANK","DS");// "Diet Type For Meal cannot be blanks";
                error = mesg;
                parent.frames.messageFrame.location.href='../../eCommon/jsp/MstCodeError.jsp?err_num='+error;
                return false;
            }
        }
    }
    if (!code) {
        if (parent.frames.messageFrame) {
        	//var msg =getMessage("DS_MENU_NOT_DEFINED","DS"); //Commented against ML-MMOH-CRF-1124
		var msg =getMessage("DS_MENU_NOT_DEFINED_MC_DT","DS"); //ML-MMOH-CRF-1124
		Menu_Flag=false;//409
		var error=msg;
        	parent.frames.messageFrame.location.href='../../eCommon/jsp/MstCodeError.jsp?err_num='+error;
        } else {
            top.content.messageFrame.location.href ='../../eCommon/jsp/MstCodeError.jsp?err_num='+error;
        }
        return false;
    }
		var locale=document.getElementById("languageId").value;
		if(document.getElementById("dateTo").value != "") {
			var flag = compareDate(document.getElementById("dateFrom").value, document.getElementById("dateTo").value);
			if (flag==1) {
		        error = "";
		        key_value = "";
		        var msg = "App-DS0012 # should be lesser than or equal to";
		        key = msg;
				var f_date = "From Date";
				key1=key.indexOf()
				var t_date ="To Date" ;
				key1=key.split("#");
	
				error = error +" "+ key1[0] +" "+ f_date+" "+key1[1]+" "+t_date+"<br>";
		        if (parent.frames.messageFrame) {
		        	parent.frames.messageFrame.location.href='../../eCommon/jsp/MstCodeError.jsp?err_num='+error;
		        } else {
		            top.content.messageFrame.location.href = '../../eCommon/jsp/MstCodeError.jsp?err_num='+error;
		        }
		        return false;
		    }
		}
	    if((splJSONObj && (splJSONObj.items ==null || splJSONObj.items.length==0)) && parseInt(jsonPatientArr_Spl.length) >0) {
	    	alert("Special Food Item Checkbox is selected. Atleast One Special Food Item should be selected");
	    	flag_spl=true;
//	    	return;
	    	
	    }
	    if((dislikeJSONObj.items ==null || dislikeJSONObj.items.length==0) && parseInt(jsonPatientArr_Dislikes.length) >0) {
	    	alert("Food Dislikes Checkbox is selected. Atleast One Food Dislikes Item should be selected");
	    	return;
	    }
	    
	    if(flag_spl==true) return;
	    
		var obj=parent.patientsObj;
		var arr=new Array();
		var obj1=new Object();
		arr=obj.patients;
		
		var newOrderPatientIds=new Array();
		var splExistsPatientIds=new Array();
		var splExistsEncIds=new Array();
		
		var dislikeExistsPatientIds=new Array();
		var dislikeExistsEncIds=new Array();
		
		var newOrderCheckFlag=false;
		var newOrder=false;
		for(var i=0;i<arr.length;i++) {
			obj1=arr[i].patient;
			var oldOrderFromDate=obj1.fromDate;
			var dislikeFlag=obj1.dislikeFlag;
			if(dislikeFlag=="Y"){
				dislikeExistsPatientIds.push(obj1.patientId);
				dislikeExistsEncIds.push(obj1.encounterId);
			}					
			var dateFromConverted = convertDate(document.getElementById("dateFrom").value,'DMY',locale,'en');
			if (dateFromConverted != oldOrderFromDate && oldOrderFromDate != "") {
				newOrder=true;
				var locale=document.getElementById("languageId").value;
				var flag = isAfter(dateFromConverted, oldOrderFromDate,"DMY",locale);
				
				if(flag) {
					newOrderCheckFlag=true;
					newOrderPatientIds.push(obj1.patientId);
				}
				else {
					newOrderCheckFlag=false;
					break;
				}
			}
			else {
				var spFlag=obj1.spFlag;
				if(spFlag=="Y") {
					splExistsPatientIds.push(obj1.patientId);
					splExistsEncIds.push(obj1.encounterId);
				}
			}
		}
		var check_sp=false;
		if(splExistsPatientIds!=null && splExistsPatientIds.length>0 && splJSONObj && splJSONObj.items !=null && splJSONObj.items.length>0) {
			var msg = "Special Food Items already exist for the following patients on the selected date. Saving the changes will overwrite the existing Special Food Item details. Are you sure you wish to continue?";
			var flag=false;
			msg=msg+'\n\n\n';
			msg=msg+"Encounter ID            Patient ID"+'\n';
			for(var iter=0;iter<splExistsPatientIds.length;iter++) {
				if(document.getElementById("chk_spl_"+splExistsEncIds[iter]).checked==true) {
					msg=msg+splExistsEncIds[iter]+"              "+splExistsPatientIds[iter]+'\n';
					flag=true;
				}
			}
			if (flag==true) {
				check_sp = confirm(msg);
			    if(check_sp){ }
			    else {
			    	return false;
			    }
			}
		}
		
		var check_dislike=false;
		if(dislikeExistsPatientIds!=null && dislikeExistsPatientIds.length>0 && dislikeJSONObj.items !=null && dislikeJSONObj.items.length>0) {
			var msg = "Food Dislikes already exist for the following patients on the selected date. Saving the changes will overwrite the existing Food Dislikes details. Are you sure you wish to continue?";
			msg=msg+'\n\n\n';
			msg=msg+"Encounter ID            Patient ID"+'\n';
			var flag=false;
			for(var iter=0;iter<dislikeExistsPatientIds.length;iter++) {
				if(document.getElementById("chk_dislike_"+dislikeExistsEncIds[iter]).checked==true) {
					msg=msg+dislikeExistsEncIds[iter]+"              "+dislikeExistsPatientIds[iter]+'\n';
					flag=true;
				}
			}
			if (flag==true) {
				check_dislike = confirm(msg);
			    if(check_dislike){
			    }
			    else {
			    	return false;
			    }
			}
		}
		
	//MMOH-CRF-427
	//if(!flag){
	var profileFlag=$('#profileFlag').val();
	var restrict_date_inpatients_yn=$('#restrict_date_inpatients_yn').val();
	var maximum_days_allowed=$('#maximum_days_allowed').val();
	//document.getElementById("dateFrom").value, document.getElementById("dateTo").value
	if(restrict_date_inpatients_yn=="Y" && profileFlag=="true"){
	var flagtemp=grayOutCalendarValidation(document.getElementById("dateFrom").value,maximum_days_allowed);
	
	if(flagtemp){
		flagtemp=grayOutCalendarValidation(document.getElementById("dateTo").value,maximum_days_allowed);
		if(!flagtemp){
		if (parent.frames.messageFrame) {
		var locale=document.getElementById("languageId").value;
		var sysdate=getCurrentDate("DMH",locale);
		var maxdate=addDays(new Date(),maximum_days_allowed);
		var maxToDate=changeDate(maxdate);
			
		var fieldName=getLabel("Common.todate.label","common");
		var msg=getMessage("DS_SHOULD_BE_WITHIN","DS");
		var msgArray=msg.split("#");
		error="";
		//error="Date should be within "+sysdate+" to "+maxToDate+"<br>";
		error+=fieldName;
		error+=msgArray[1];
		error+=sysdate;
		error+=msgArray[2];
		error+=maxToDate;
        	parent.frames.messageFrame.location.href='../../eCommon/jsp/MstCodeError.jsp?err_num='+error;
		$('#dateTo').focus();
		$('#dateTo').select();
        } else {
            top.content.messageFrame.location.href = '../../eCommon/jsp/MstCodeError.jsp?err_num='+error;
        }
		return false;
		}
		
	}else{
		if (parent.frames.messageFrame) {
			//Error Message for From Date is out of range 
			var fieldName=getLabel("Common.fromdate.label","common");
			var locale=document.getElementById("languageId").value;
			var sysdate=getCurrentDate("DMH",locale);
			var maxdate=addDays(new Date(),maximum_days_allowed);
			var maxToDate=changeDate(maxdate);
			var msg=getMessage("DS_SHOULD_BE_WITHIN","DS");
			var msgArray=msg.split("#");
			error="";
			//error="Date should be within "+sysdate+" to "+maxToDate+"<br>";
			error+=fieldName;
			error+=msgArray[1];
			error+=sysdate;
			error+=msgArray[2];
			error+=maxToDate;
			
        	parent.frames.messageFrame.location.href='../../eCommon/jsp/MstCodeError.jsp?err_num='+error;
			$('#dateFrom').focus();
			$('#dateFrom').select();
			
        } else {
            top.content.messageFrame.location.href = '../../eCommon/jsp/MstCodeError.jsp?err_num='+error;
        }
		return false;
	}
	}
	//}
	//MMOH-CRF-427
		
		//78.1 validation statrs
		// MMS-QH-CRF-0078.1-US003 validation starts 58572
	var GEN_MEALPLAN_FOR_NBM_PAT_YN=$('#GEN_MEALPLAN_FOR_NBM_PAT_YN').val();
	if(GEN_MEALPLAN_FOR_NBM_PAT_YN=="Y"){
	if(document.getElementById("from").value != "" && document.getElementById("to").value == ""){
		var fieldName=getLabel("eOT.nilBYMounth.Label","ot_labels");
		fieldName+=" ";
		fieldName+=getLabel("Common.todate.label","common");
		var message=getMessage("CAN_NOT_BE_BLANK","Common").replace("$",fieldName );
		
		parent.frames.messageFrame.location.href='../../eCommon/jsp/MstCodeError.jsp?err_num='+message
		$('#to').focus();
		$('#to').select();
		//document.getElementById("to").focus();
		
		return false;
	
	}else if(document.getElementById("to").value != "" && document.getElementById("from").value == ""){
		var fieldName=getLabel("eOT.nilBYMounth.Label","ot_labels");
		fieldName+=" ";
		fieldName+=getLabel("Common.fromdate.label","common");
		var message=getMessage("CAN_NOT_BE_BLANK","Common").replace("$",fieldName );
		
		parent.frames.messageFrame.location.href='../../eCommon/jsp/MstCodeError.jsp?err_num='+message
		$('#from').focus();
		$('#from').select();
		document.getElementById("from").focus();
		
		return false;
	}
	}
	// MMS-QH-CRF-0078.1-US003 validation ends 58572
		
	//427 validation for out of range starts for NBM
				
		var profileFlag=$('#profileFlag').val();
		var restrict_date_inpatients_yn=$('#restrict_date_inpatients_yn').val();
		var maximum_days_allowed=$('#maximum_days_allowed').val();
		if(restrict_date_inpatients_yn=="Y" && profileFlag=="true"){
		//var flagtemp=grayOutCalendarValidation(document.getElementById("from").value,maximum_days_allowed);
		var flagtemp=grayOutDateTimeCalendarValidation(document.getElementById("from").value,maximum_days_allowed);
		if(flagtemp){			
			//Nil by mouth from date is within the range
			//now check for nil by mouth to date
			//flagtemp=grayOutCalendarValidation(document.getElementById("to").value,maximum_days_allowed);
			flagtemp=grayOutDateTimeCalendarValidation(document.getElementById("to").value,maximum_days_allowed);
			if(!flagtemp){
			var fieldName=getLabel("eOT.nilBYMounth.Label","ot_labels");
			fieldName+=" ";
			fieldName+=getLabel("Common.todate.label","common");
			var locale=document.getElementById("languageId").value;
			var sysdate=getCurrentDate("DMH",locale);
			var maxdate=addDays(new Date(),maximum_days_allowed);
			var maxToDate=changeDate(maxdate);
			var msg=getMessage("DS_SHOULD_BE_WITHIN","DS");
			var msgArray=msg.split("#");
			error="";
			//error="Date should be within "+sysdate+" to "+maxToDate+"<br>";
			error+=fieldName;
			error+=msgArray[1];
			error+=sysdate;
			error+=msgArray[2];
			error+=maxToDate;
					
			parent.frames.messageFrame.location.href='../../eCommon/jsp/MstCodeError.jsp?err_num='+error;
			$('#to').focus();
			$('#to').select();
			return false;
			}
		}
		else
		{
				//Nil by mouth from date is out of range
			var fieldName=getLabel("eOT.nilBYMounth.Label","ot_labels");
			fieldName+=" ";
			fieldName+=getLabel("Common.fromdate.label","common");
			var locale=document.getElementById("languageId").value;
			var sysdate=getCurrentDate("DMH",locale);
			var maxdate=addDays(new Date(),maximum_days_allowed);
			var maxToDate=changeDate(maxdate);
			var msg=getMessage("DS_SHOULD_BE_WITHIN","DS");
			var msgArray=msg.split("#");
			error="";
			//error="Date should be within "+sysdate+" to "+maxToDate+"<br>";
			error+=fieldName;
			error+=msgArray[1];
			error+=sysdate;
			error+=msgArray[2];
			error+=maxToDate;
					
			parent.frames.messageFrame.location.href='../../eCommon/jsp/MstCodeError.jsp?err_num='+error;
			$('#from').focus();
			$('#from').select();
			return false;
		}
		}
				
	//427 validation for out of range ends	for NBM	
	//410 validation starts	
	var fromDate=document.getElementById("dateFrom").value;
	var dateTo=document.getElementById("dateTo").value;
	var addedFacilityId = document.getElementById("addedFacilityId").value;
	//checkFullNBMProfileOverLap(fromDate,dateTo,addedFacilityId,selectedEncounterId);
	/*var overlapflag=checkFullNBMProfileOverLap(fromDate,dateTo,addedFacilityId,selectedEncounterId);
	if(overlapflag){
	return;
	}*/
	//410 validation ends	
	/* Added Against start 968-CRF*/
			/* var isMenuType ="";
			if(document.getElementById("isMenuType")!=null)
			isMenuType=document.getElementById("isMenuType").value; */
			var dType =document.getElementById("dietType").value;
			var obj = document.getElementsByName("dietTypesForMeals");
			var count = 0;
			var obDiet = new Array();
			var dietArrayForJSON=new Array();
			if(isMenuType=="true"){ 
			var countDType	= 0;
			}

			if(obj != null){
			for (var i = 0; i < obj.length; i++) {
			if (obj[i].value != "") {
			obDiet[count++] = obj[i].value;
			if(isMenuType=="true"){
				if(obj[i].value == dType){
				countDType++;
				}
			}

			dietArrayForJSON.push({diet:obj[i].value});
			}
			}

			if(isMenuType=="true"){ 

			if (countDType == 0){
			alert(getMessage("DS_DTYPE_DIFF_OBDIET","DS"));
			return false;		
			}else{
			submitStatus = true;
			} 
			}
			}
	/* Added Against end 968 */
	
		if(newOrder==true && newOrderCheckFlag==true) {
			var msg = "New profile is created for the following Patient(s), this will be effective from";
			if(document.getElementById("dateTo").value!=""){
				msg = msg+" "+document.getElementById("dateFrom").value+" - "+document.getElementById("dateTo").value;
				msg=msg+'\n\n\n';
				for(var iter=0;iter<newOrderPatientIds.length;iter++) {
					msg=msg+newOrderPatientIds[iter]+'\n';				
				}
				check = confirm(msg);
			}else{
				msg = msg+" "+document.getElementById("dateFrom").value;
				msg=msg+'\n\n\n';
				for(var iter=0;iter<newOrderPatientIds.length;iter++) {
					msg=msg+newOrderPatientIds[iter]+'\n';				
				}
				check = confirm(msg);		
		
			}

		}
		else if(newOrder==true && newOrderCheckFlag==false) {
			error = "";
			var key_value = "App-DS0011 # should be greater than or equal to";
			var f_date = "From Date";
			var s_date = "From Date of Existing Order";
			key_value1 = key_value.split("#");
			error = error + key_value1[0] +" "+ f_date+" "+key_value1[1]+" "+s_date+" <br>";
			if (parent.frames.messageFrame) {
				parent.frames.messageFrame.location.href='../../eCommon/jsp/MstCodeError.jsp?err_num='+error;
	        } else {
	            top.content.messageFrame.location.href = '../../eCommon/jsp/MstCodeError.jsp?err_num='+error;
	        }
	        return false;

		}
		
	
    if(newOrder==true && newOrderCheckFlag==true) {
	    if(check){
	    	document.getElementById("isNEW").value= true;
//	    	updateNewFlag();
	    	var obj=new Object();
	    	obj=parent.patientsObj;
	    	
	    	for(var i=0;i<obj.patients.length;i++) {
	    		for(var iter=0;iter<newOrderPatientIds.length;iter++) {
	    			if(newOrderPatientIds[iter] == obj.patients[i].patient.patientId ) {
	    				obj.patients[i].patient.newFlag="true";
	    				break;
	    			}
	    		}
	    	}
	    	insertMealContents();
	    }
	    else {
	    	return false;
	    }
    }
    else if(newOrder==false) insertMealContents();
    var nonFreqTotalItems;
    var freqTotalItems;
    
    if((splJSONObj && splJSONObj.items ==null) && parseInt(jsonPatientArr_Spl.length) >0) {
    	alert("Special Food Item Checkbox is selected. Atleast One Special Food Item should be selected");
    	return;
    }
    if(splJSONObj && splJSONObj.items !=null) {
    	insertSpecialFoodItems();
    }
    if((dislikeJSONObj.items ==null) && parseInt(jsonPatientArr_Dislikes.length) >0) {
    	alert("Food Dislikes Checkbox is selected. Atleast One Food Dislikes Item should be selected");
    	return;
    }    
    if(dislikeJSONObj.items !=null) {
    	insertFoodDislikes();    	
    }
    
    return true;
}

function insertMealContents() {	
	//CRF -0684
	var isMenuType ="";
	if(document.getElementById("isMenuType")!=null)
	isMenuType=document.getElementById("isMenuType").value;
	var locale=document.getElementById("languageId").value;
	var dateFormate=document.getElementById("datepattrn1").value;
	var frmDate=document.getElementById("dateFrom").value;
//	var fromDate = convertDate(frmDate,'DMY','en',locale);
	var fromDate = convertDate(frmDate,'DMY',locale,'en');
//	document.getElementById("dateFrom").value=fromDate;
	var datTo=document.getElementById("dateTo").value;
	//var dateTo = convertDate(datTo,'DMY','en',locale);
	var dateTo = convertDate(datTo,'DMY',locale,'en');
	//document.getElementById("dateTo").value=dateTo;
	//Added against ML-MMOH-CRF-0968-US001 starts here
	var dType =document.getElementById("dietType").value;
	//Added against ML-MMOH-CRF-0968-US001 ends here
	var obMeal = new Array();
	var obDiet = new Array();
	var dietArrayForJSON=new Array();
	var mealArrayForJSON=new Array();
	var remarksArrayForJSON=new Array();//MMS-KH-CRF-029.1
	var count = 0;
    var countMeal = 0;
	var objMeal = document.getElementsByName("mealTypesforDietTypes");
    if(objMeal != null){
    	for (var i = 0; i < objMeal.length; i++) {
            if (objMeal[i].value != "") {
                obMeal[countMeal++] = objMeal[i].value;
                mealArrayForJSON.push({meal:objMeal[i].value});
            }
    	}
    }
    var obj = document.getElementsByName("dietTypesForMeals");
    //Added against ML-MMOH-CRF-0968-US001 starts here
	if(isMenuType=="true"){ 
	var countDType	= 0;
	}
	//Added against ML-MMOH-CRF-0968-US001 ends here
    if(obj != null){
	   for (var i = 0; i < obj.length; i++) {
	       if (obj[i].value != "") {
	           	obDiet[count++] = obj[i].value;
			//Added against ML-MMOH-CRF-0968-US001 starts here
				if(isMenuType=="true"){
					if(obj[i].value == dType){
					countDType++;
					}
				}
			//Added against ML-MMOH-CRF-0968-US001 ends here
	           	dietArrayForJSON.push({diet:obj[i].value});
	       }
	   }
		//added against ML-MMOH-CRF-0968-US001 starts here
		if(isMenuType=="true"){ 
			//if (obDiet.indexOf(dType) == -1){//indexOf will not support while using JSONObject.
			if (countDType == 0){
				alert(getMessage("DS_DTYPE_DIFF_OBDIET","DS"));
				return false;		
			}else{
				submitStatus = true;
			} 
		}
		//added against ML-MMOH-CRF-0968-US001 ends here
    }			
			
	var profileSL=document.getElementById("profileSL").value;
	if(profileSL=="" || profileSL == "0" || profileSL == null ){
		profileSL="0";
	}
	var addedById = document.getElementById("addedById").value;
	var addedAtWsNo = document.getElementById("addedAtWsNo").value;
	var addedFacilityId = document.getElementById("addedFacilityId").value;
	var dietCategory_insertMeal=document.getElementById("dietCategory").value;
	var locationType = document.getElementById("locationType").value;
	var locationCode = document.getElementById("locationCode").value;
	var mClass = document.getElementById("mealClass").value;
	var dType =document.getElementById("dietType").value;
	var from =document.getElementById("from").value;
	var to =document.getElementById("to").value;
	var dieticianReferral =document.getElementById("dieticianReferral").checked?'Y':'N';
	var feedingInstructions =encodeURIComponent(document.getElementById("feedingInstructions").value);//055251
	var prepInstr =encodeURIComponent(document.getElementById("prepInstr").value);//055251
	var feedType =document.getElementById("feedType").value;
	var dsDeliveryInstr =document.getElementById("dsDeliveryInstr").value;
	var texture_of_diet =document.getElementById("texture_of_diet").value;//ML-MMOH-CRF-412
	
	//CRF-684	
	if(isMenuType == "true"){
		var menu_type = document.getElementById("menu_type").value;
	}
	//CRF-684	
	var isNew=document.getElementById("isNEW").value;
	var mode = "insertMealContents";
	var xmlDoc="" ;
	var xmlHttp = new XMLHttpRequest() ;
	var xmlStr ="<root></root>";	
	
	var jsonDataObject = new Object();
	var jsonPatientObject=new Object();
		
	jsonPatientObject=parent.patientsObj;
  //MMS-KH-CRF-029.1 Starts
	for(var i=0;i<jsonPatientObject.patients.length;i++) {
			encounterId=jsonPatientObject.patients[i].patient.encounterId;
				var rem_val = document.getElementById("rem_"+encounterId).value;				
				remarksArrayForJSON.push({remarks:rem_val+"|~|"+encounterId});
			}
  //MMS-KH-CRF-029.1 Ends
	jsonDataObject.dietCategory=dietCategory_insertMeal;
	jsonDataObject.addedById=addedById;
	jsonDataObject.addedFacilityId=addedFacilityId;
	jsonDataObject.isNEW=isNew;
	jsonDataObject.profileSL=profileSL;
	jsonDataObject.locationType=locationType;
	jsonDataObject.locationCode=locationCode;
	jsonDataObject.addedAtWsNo=addedAtWsNo;

	jsonDataObject.objMeal=mealArrayForJSON;
	jsonDataObject.obDiet=dietArrayForJSON;
	
	jsonDataObject.mClass=mClass;
	jsonDataObject.dType=dType;
	jsonDataObject.fromDate=fromDate;
	jsonDataObject.dateTo=dateTo;
	jsonDataObject.NBMfrom=from;
	jsonDataObject.NBMto=to;
	jsonDataObject.dieticianReferral=dieticianReferral;
	jsonDataObject.feedingInstructions=feedingInstructions;
	jsonDataObject.prepInstr=prepInstr;
	jsonDataObject.feedType=feedType;
	jsonDataObject.dsDeliveryInstr=dsDeliveryInstr;
	jsonDataObject.status="";
	jsonDataObject.returnRemarks=remarksArrayForJSON; //MMS-KH-CRF-029.1
	jsonDataObject.mode=mode;
	
	var jsonData = JSON.stringify(jsonDataObject);
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	
	// changes for ML-MMOH-CRF-0428
	var irregular_enabled=$("#IRREGULAR_DIET_ORD_YN").val();
	if(irregular_enabled=="Y") addAutomaticExclusions();
	var msg_exclusions="The following meal(s) have been automatically excluded for the current day: \n";
	$.each(automatic_excluded_meal_types,function(index,value) {
	msg_exclusions=msg_exclusions+getMealTypeDesc(value)+"\n";
	});
	if(automatic_excluded_meal_types.length>0 && irregular_enabled=="Y") alert(msg_exclusions);
	//newly added for 428 starts
	if(checkIfAllMealTypesExcluded()) {
						var message="Atleast one meal should be selected for the Diet Order "
						parent.frames.messageFrame.location.href='../../eCommon/jsp/MstCodeError.jsp?err_num='+message;
						return false;
					}
					if(checkAutoExclusions()) {
						var message="All Meals are automatically excluded for today "
						parent.frames.messageFrame.location.href='../../eCommon/jsp/MstCodeError.jsp?err_num='+message;
						return false;
					}
	//newly added for 428 ends
	// changes for ML-MMOH-CRF-0428 ends here

	//check for irregular order
	//ML-MMOH-CRF-409 starts
	var IRREGULAR_DIET_ORD_YN=$("#IRREGULAR_DIET_ORD_YN").val();
	if(Menu_Flag==true && IRREGULAR_DIET_ORD_YN=="Y"){
		var objMeal = document.getElementsByName("mealTypesforDietTypes");
		var irregular_meal_name="";
		var dateFrom=$("#dateFrom").val();
		$.each(fetchedMealTypesWithTime,function(index) {
		 	var mealTypeCode=this.Meal_Code;
			var Irregular_End_Time=this.Irregular_End_Time;
			var Irregular_Start_Time=this.Irregular_Start_Time;
			var MealName=this.Short_Desc;
			var checktimeflag=checkTimeRange(Irregular_Start_Time,Irregular_End_Time,dateFrom);
			if(checktimeflag==true){
				irregular_meal_name+=MealName;
				irregular_meal_name+=",";
				irregular_meal_flag=true;
				irregular_meal_code+=mealTypeCode;
				irregular_meal_code+=",";
			}
	 });
		irregular_meal_name=irregular_meal_name.substring(0,irregular_meal_name.length-1);
		irregular_meal_code=irregular_meal_code.substring(0,irregular_meal_code.length-1);
//		var IRREGULAR_DIET_ORD_YN=$("#IRREGULAR_DIET_ORD_YN").val();
		var IRREGULAR_MEAL_ORD_MESSAGE=$.trim($("#IRREGULAR_MEAL_ORD_MESSAGE").val());
		var IRREGULAR_MEAL_ORD_MESSAGE=$.trim($("#IRREGULAR_MEAL_ORD_MESSAGE").val());
		$("#irregular_meal_code").val(irregular_meal_code);

		var deitTypesStatus=$("#dietTypesStatus").val();
		if(IRREGULAR_DIET_ORD_YN=="Y" && IRREGULAR_MEAL_ORD_MESSAGE.length>0 && deitTypesStatus=="Y" && irregular_meal_flag==true){
			//var msg="Late/Irregular Diet Order on "+dateFrom+" for the Meal: "+irregular_meal_name+"\n"+IRREGULAR_MEAL_ORD_MESSAGE;
			var msg=getMessage("DS_IRREGULAR_DIET_ORDER","DS");
			msg=msg.replace("#", dateFrom);
			msg+=""+irregular_meal_name;
			msg+="\n"+IRREGULAR_MEAL_ORD_MESSAGE;
			alert(msg);
			}
	}
	//ML-MMOH-CRF-409 ENDS		
		
	xmlHttp.open("POST", "../../servlet/eDS.PlaceBulkDietOrderServlet?mode="+mode+"&jsonData="+jsonData+"&jsonPatientObject="+JSON.stringify(jsonPatientObject)+"&mealExclusions="+JSON.stringify(excludedMeals)+"&irregular_meal_code="+irregular_meal_code+"&manualexcludedMeals="+JSON.stringify(manualexcludedMeals)+"&texture_of_diet="+texture_of_diet+"&menu_type="+menu_type,false);//CRF-428 and  CRF-684	
	
	xmlHttp.send(xmlDoc);
	retVal = (xmlHttp.responseText);
	var jsonObjResponse=eval('(' + retVal + ')');
	var arrVal = retVal.split(",");
	var row_ind = 1;
	
	if(arrVal != null){
		submitStatus = true;
	}
	if(submitStatus){
		var message =getMessage("DS_OPER_COMPLETE","DS");// "APP-DS0001 Operation Completed Successfully...";
		exclusionFlag=false;
		document.getElementById("profileSL").value=profileSL;
		updateMealMenuDate();
		updateExclusionsPane();
		parent.frames.messageFrame.location.href='../../eCommon/jsp/MstCodeError.jsp?err_num='+message
	}
}

function insertSpecialFoodItems() {
	var locale=document.getElementById("languageId").value;
	var dateFormate=document.getElementById("datepattrn1").value;
	var jsonData = JSON.stringify(splJSONObj);
	var mode = "insertSpecialFoodItems";
	var facility= document.getElementById("addedFacilityId").value;
	var addedById = document.getElementById("addedById").value;
	var workStationNo = document.getElementById("addedAtWsNo").value;
	
	var jsonPatientObject=new Object();
	jsonPatientObject.patients=jsonPatientArr_Spl;	
	
	var xmlDoc="";
	var xmlHttp = new XMLHttpRequest();
	var xmlStr ="<root></root>";
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST", "../../servlet/eDS.PlaceBulkDietOrderServlet?mode="+mode+"&jsonData="+jsonData+"&facilityId="+facility+"&addedId="+addedById+"&workStNo="+workStationNo+"&jsonPatientObject="+JSON.stringify(jsonPatientObject),false);
	xmlHttp.send(xmlDoc);
	retVal = (xmlHttp.responseText);
}

function checkNulls(fieldName, fields) {
	var f1;
	var errors = "";
	var key_value = new Array();
	for (j = 0; j < fields.length; j++) {
		if (fields[j].value == "") {
			f1=false;
			//errors = errors + "APP-SM0073 " + fieldName[j] + " cannot be blank..." + "<br>" ;
			   errors = errors + getMessage("CAN_NOT_BE_BLANK","Common").replace("$",fieldName[j]) + "<br>" ;
		}
	}
	if (parent.frames.messageFrame) {
		parent.frames.messageFrame.location.href='../../eCommon/jsp/MstCodeError.jsp?err_num='+errors;
	} else {
		top.content.messageFrame.location.href = '../../eCommon/jsp/MstCodeError.jsp?err_num='+errors;
	}
	if (f1 == false) {
		return false;
	} else {
		return true;
	}
}

function compareDate(date1,date2) {
	var flag="";
    if(date1.length > 0 && date2.length > 0 ) {
			var date1_array = date1.split(" ");
			var date1_temp= date1_array[0];
			
			var date2_array = date2.split(" ");
			var date2_temp = date2_array[0];
			
	        var date1array = date1_temp.split("/");
            var date2array = date2_temp.split("/");
            
			var date1dt = new Date(date1array[2],date1array[1],date1array[0]);
            var date2dt = new Date(date2array[2],date2array[1],date2array[0]);
			if(Date.parse(date1dt) > Date.parse(date2dt)) {
                flag=1;
            }
			else if(Date.parse(date1dt) == Date.parse(date2dt)) {
				flag=0;
			}
			else flag=-1;
			
    }
	return flag;
}

function compareDates(fromdate,todate,locale,format) {
    var fromarray; var toarray;
	var fromdate = convertDate(fromdate,format,locale,locale);
	var todate = convertDate(todate,format,locale,locale);
	var retVal=1;
    if(fromdate.length > 0 && todate.length > 0 ) {
    	var from_date_array = fromdate.split(" ");
		var from_date = from_date_array[0];
		var from_time = from_date_array[1];

		var to_date_array = todate.split(" ");
		var to_date = to_date_array[0];
		var to_time = to_date_array[1];

		var fromdatearray = from_date.split("/");
		var todatearray = to_date.split("/");
		if(format == "DMY") {
			var fromdt = new Date(fromdatearray[2],fromdatearray[1],fromdatearray[0]);
			var todt = new Date(todatearray[2],todatearray[1],todatearray[0]);
		}
		else{
			var fromtimearray = from_time.split(":");
			var totimearray = to_time.split(":");

			var fromdt = new Date(fromdatearray[2],fromdatearray[1],fromdatearray[0],fromtimearray[0],fromtimearray[1]);
            var todt = new Date(todatearray[2],todatearray[1],todatearray[0],totimearray[0],totimearray[1]);
		}
        if(Date.parse(todt) < Date.parse(fromdt)) {
        	retVal=-1;
        }
        else if(Date.parse(todt) == Date.parse(fromdt)) {
        	retVal=0;
        }
    }
	return retVal;
}

var remarks = new Array();
async function Remarks(){
	var remarkHdr;
	if(document.getElementById("remarks").value != "null" &&  document.getElementById("remarks").value != ""){
		remarkHdr = document.getElementById("remarks").value;
	}else{
		remarkHdr = "";
	}
	var dialogUrl1 = "../../eDS/jsp/Remarks.jsp?&remarkHdr="+remarkHdr;
	var dialogArguments = remarks;
	var dialogFeatures = "dialogHeight:13;dialogWidth:28;status:no;scroll:yes";
	returnRemarks = await window.showModalDialog(dialogUrl1, dialogArguments,dialogFeatures);
}
function geRemarks(val) {
	if(val == ""){
		document.getElementById('REMARKS').focus();
	}else{
		remarks = val;
		document.getElementById("remarks").value = remarks;
		window.returnValue = remarks;
		window.close();
	}
	
}

function updateMealMenuDate() {
	var fromDate=document.getElementById("dateFrom").value;
	document.getElementById("dateForMenu").value=fromDate;
}

function textAreaLimit(field, maxlen) {
	if (field.value.length > maxlen + 1){
		/*	var msg = "DS0010 should not be more than";
			var msg1=msg;
			var msg2 = "Characters";
			var msg3=msg2;
			alert(msg1+" "+maxlen+" "+msg3);*/
			
			var strMsg = getMessage("DS_MAXLEN_CHARS","DS");
			var arrMsg = strMsg.split("#");
			alert(arrMsg[0] + maxlen + arrMsg[1]);
	}
	if (field.value.length > maxlen)
	field.value = field.value.substring(0, maxlen);
}

function reset(){
	parent.frames[1].document.forms[0].reset();
	tableObj1 = document.getElementById("Able");
	while (tableObj1.rows.length > 1) {
		tableObj1.deleteRow(1);
	}
	
	tableObj3 = document.getElementById("treemenu3");

	while (tableObj3.rows.length > 0) {
		tableObj3.deleteRow(0);
	}
	
	tableObj4 = document.getElementById("treemenu4");

	while (tableObj4.rows.length > 0) {
		tableObj4.deleteRow(0);
	}	
	var tbodyObj = document.all("dispGTC");
	if(tbodyObj.rows.length>=1) {
		tbodyObj.deleteRow(0);
	}
	
	var tbodyObj = document.all("FoodItems");
	while (tbodyObj.rows.length>0) {
		tbodyObj.deleteRow(0);
	}
	splJSONObj=new Object();
	
	var tbodyObj = document.all("DislikesFoodItems");
	while (tbodyObj.rows.length>0) {
		tbodyObj.deleteRow(0);
	}	
	dislikeJSONObj=new Object();
	
	var tbodyObj2 = document.all("FoodItems1");
	if(tbodyObj2.rows.length>0)
	tbodyObj2.deleteRow(0);
	
	document.getElementById("splFoodItem_flow_text").disabled=true;
	document.getElementById("foodItem_dislike_flow_text").disabled=true;
	getSysDate();
	
	//Added against MMS-KH-CRF-0029.1 Starts Here
	encountID = encounter_IDs(); 
	document.getElementById("encounter").value = encountID;
	var length = encountID.length;
	for(var i=0;i<length;i++)
	{
		if(document.getElementById("rem_"+encountID[i]).style.visibility == 'visible' || document.getElementById("MenuImage"+encountID[i]).style.visibility == 'visible')
		{
			document.getElementById("rem_"+encountID[i]).style.visibility = 'hidden';
			document.getElementById("rem_"+encountID[i]).value="";
			document.getElementById("MenuImage"+encountID[i]).style.visibility = 'hidden';
		}
	if(document.getElementById("patientRow"+encountID[i]).disabled==true)
	{
		document.getElementById("patientRow"+encountID[i]).disabled = false;
	}
	}
	//Added against MMS-KH-CRF-0029.1 Ends Here
}

function getSysDate(){
	var locale=document.getElementById("languageId").value;
	var fromDate=document.getElementById("dateFrom").value;
	var date=new Date();
	var month=date.getMonth();
	var date1=date.getDate();
	var year=date.getYear();
	month+=1;
	if(date1<=9){
		date1="0"+""+date1;
	}
	if(month<=9){
		month="0"+""+month;
	}
	var sysDate=date1+"/"+month+"/"+year;
	var conDate = convertDate(sysDate,'DMY','en',locale);
	if(conDate!=""){
			document.getElementById("dateForMenu").value=conDate;
			document.getElementById("dateFrom").value=conDate;
	}
	
	//MMOH-CRF-427
	var profileFlag=document.getElementById("profileFlag").value;
	var restrict_date_inpatients_yn=document.getElementById("restrict_date_inpatients_yn").value;
	var maximum_days_allowed=document.getElementById("maximum_days_allowed").value;
	
	if(profileFlag=="true" && restrict_date_inpatients_yn=="Y"){
	
	var newtodate=addDays(new Date(),maximum_days_allowed);
	var date1=newtodate.getDate();
	var month=newtodate.getMonth();
	var year=newtodate.getFullYear();
	month+=1;
	if(date1<=9){
			date1="0"+""+date1;
		    }
	if(month<=9){
			month="0"+""+month;
		    }
	//var futDate=date.getDate() + "/" + (date.getMonth()+1) + "/" + date.getFullYear();
	var futDate=date1 + "/" + month + "/" + year;
	futDate=convertDate(futDate,'DMY','en',locale);
	document.getElementById("dateTo").value = futDate;
	}	
	//MMOH-CRF-427

}

function isValidDate(obj){
	if(obj.value!=""){
		var RE_NUM =  /^\/?\d+$/;
		var str_date = obj.value;
		var arr_date = str_date.split('/');
		if (arr_date.length!=3) return cal_error ("Invalid date format: '" + str_date + "'.\nFormat accepted is DD/MM/YYYY.",obj);
		if (!arr_date[0]) return cal_error ("Invalid date format: '" + str_date + "'.\nNo day of month value can be found.",obj);
		if (!RE_NUM.exec(arr_date[0])) return cal_error ("Invalid day of month value: '" + arr_date[0] + "'.\nAllowed values are unsigned integers.",obj);
		if (!arr_date[1]) return cal_error ("Invalid date format: '" + str_date + "'.\nNo month value can be found.",obj);
		if (!RE_NUM.exec(arr_date[1])) return cal_error ("Invalid month value: '" + arr_date[1] + "'.\nAllowed values are unsigned integers.",obj);
		if (!arr_date[2]) return cal_error ("Invalid date format: '" + str_date + "'.\nNo year value can be found.",obj);
		if (arr_date[2].length!=4) return cal_error ("Invalid year value: '" + arr_date[2] + "'.\nAllowed format YYYY.",obj);
		var dt_date = new Date();
		dt_date.setDate(1);
		if (arr_date[1] < 1 || arr_date[1] > 12) return cal_error ("Invalid month value: '" + arr_date[1] + "'.\nAllowed range is 01-12.",obj);
		dt_date.setMonth(arr_date[1]-1);
		var dt_numdays = new Date(arr_date[2], arr_date[1], 0);
		dt_date.setDate(arr_date[0]);
		if (dt_date.getMonth() != (arr_date[1]-1)) return cal_error ("Invalid day of month value: '" + arr_date[0] + "'.\nAllowed range is 01-"+dt_numdays.getDate()+".",obj);
		//if(arr_date[2].length==4 && arr_date[2]>=dt_date.getFullYear() ) return cal_error ("Not a valid Year value: '" + arr_date[2] + "'.\nCurrent Year "+dt_date.getFullYear()+" Only Allowed .",obj);
	}
	return true;
}

function cal_error (str_message,obj) {
	alert (str_message);
	obj.focus();
	obj.select();
	return null;
}


function getMeals1(val,indNo) {
	if (document.getElementById("mealClass").value != "" && document.getElementById("dietType").value != "") {
		var language_Id =document.getElementById("languageId").value;
		_dTypeArr.splice(0,_dTypeArr.length);
		_mTypeArr.splice(0,_mTypeArr.length);
		
		var count = 0;
		var ctr = 0;

		ob[0] = document.getElementById("dietType").value;
		var objsFields = new Array();
		var obj = document.getElementsByName("dietTypesForMeals");
		if(obj != null){
			for (var i = 0; i < obj.length; i++) {
				var flag = false;
				for (var j = 0; j < ob.length; j++) {
					if (obj[i].value == ob[j]) {
						if (obj[i].value != "") {
							flag = true;
						}
					}
				}
				ob[count++] = obj[i].value;
				}
		}
		var h=0;
		var obj = document.getElementsByName("dietTypesForMeals");
		if(obj != null){
			for(var k=0; k < obj.length; k++){
				_dTypeArr[h] = obj[k].value;
				h=h+1;
			}
		}

		var h=0;
		var obj2 = document.getElementsByName("mealTypesforDietTypes");
		
		if(indNo == undefined){
			indNo=0;
			
		}else{
			indNo=indNo;
		}

		if(obj2 != null){
			for(var k=0; k < obj2.length; k++){
				ob1[h] = obj2[k].value;
				_mTypeArr[h] = obj2[k].value;
				h=h+1;
			}
		}
		
		for(var m=0; m <= ob1.length; m++){
			var mt=obj2[indNo];
			if(mt==ob1[m]){
				_dTypeArr[m]=val;
				break;
			}
		}		

		var mode = "DayRefNo";
		var language_Id =document.getElementById("languageId").value;
		
		if (document.getElementById("mealClass").value != "" && document.getElementById("dietType").value != "") {
			var xmlDoc = "" ;
			var xmlHttp = new XMLHttpRequest() ;
			var xmlStr ="<root></root>";
			xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
			
			var jsonDataObject = new Object();
			jsonDataObject.languageId=language_Id;
			jsonDataObject.dateForMenu=document.getElementById("dateForMenu").value;
			jsonDataObject.dietType=document.getElementById("dietType").value;
			jsonDataObject.mealClass=document.getElementById("mealClass").value;
			jsonDataObject.facility=document.getElementById("addedFacilityId").value;
			var jsonData = JSON.stringify(jsonDataObject);
			
			xmlHttp.open("POST", "../../servlet/eDS.PlaceBulkDietOrderServlet?mode="+mode+"&jsonData="+jsonData,false);
			xmlHttp.send(xmlDoc);
			retVal = (xmlHttp.responseText);
			var jsonObjResponse=eval('(' + retVal + ')');
			var dayRef=(jsonObjResponse.dayRefNum);
			
			var obj = document.getElementById("dayRef");
			if(retVal != null && (retVal).length != 0){
				var Entry = document.createElement("option");
				Entry.value  = (dayRef);
				Entry.text  = (dayRef);
				obj.add(Entry);
			}
			if (retVal == "0") {
			}else {
				document.getElementById("dayRef").value = dayRef;
			}
			getMealContent();
		}
		function getMealContent(){
			var mode = "MealContent";
			var language_Id =document.getElementById("languageId").value;
			
			var xmlDoc = "" ;
			var xmlHttp = new XMLHttpRequest() ;
			var xmlStr ="<root></root>";
			var param="&locale="+language_Id+"&_mTypeArr="+_mTypeArr+"&mClass="+document.getElementById("mealClass").value+"&_dTypeArr="+_dTypeArr+"&profileSL="+document.getElementById("profileSL").value+"&encounterId="+document.getElementById("encounterId").value+"&dateForMeanu="+document.getElementById("dateForMenu").value+"&dayRef="+document.getElementById("dayRef").value+"&kitchenCode="+document.getElementById("kitchenCode").value+"&addedFacilityId="+document.getElementById("addedFacilityId").value+"&dietType="+document.getElementById("dietType").value+"&mode="+mode;
			xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");

			var jsonDataObject = new Object();
			jsonDataObject.locale=language_Id;
			jsonDataObject.dateForMeanu=document.getElementById("dateForMenu").value;
			jsonDataObject.dietType=document.getElementById("dietType").value;
			jsonDataObject.mClass=document.getElementById("mealClass").value;
			jsonDataObject.addedFacilityId=document.getElementById("addedFacilityId").value;
			jsonDataObject.profileSL=document.getElementById("profileSL").value;
			jsonDataObject.encounterId=document.getElementById("encounterId").value;
			jsonDataObject.dayRef=document.getElementById("dayRef").value;
			jsonDataObject.kitchenCode=document.getElementById("kitchenCode").value;
			jsonDataObject._dTypeArr=_dTypeArr;
			jsonDataObject._mTypeArr=_mTypeArr;
			
			var jsonData = JSON.stringify(jsonDataObject);
			
			xmlHttp.open("POST", "../../servlet/eDS.PlaceBulkDietOrderServlet?mode="+mode+"&jsonData="+jsonData,false);
			xmlHttp.send(xmlDoc);
			retVal = (xmlHttp.responseText);
			var jsonObjResponse=eval('(' + retVal + ')');

			if(jsonObjResponse != null){
				assignMealItem(jsonObjResponse);
			}
		}
	}
}

function getMenuForDayRef(){
	var dayRefNo;
	var language_Id =document.getElementById("languageId").value;
	
	dayRefNo = document.getElementById("dayRef").value;
	
	//ML-MMOH-CRF-0427 starts
	var locale=document.getElementById("languageId").value;
	var profileFlag=$('#profileFlag').val();
	var restrict_date_inpatients_yn=$('#restrict_date_inpatients_yn').val();
	var maximum_days_allowed=$('#maximum_days_allowed').val();
	var selecteddate=$('#dateForMenu').val();
	if(profileFlag=="true" && restrict_date_inpatients_yn=="Y"){
	var flag=grayOutCalendarValidation(selecteddate,maximum_days_allowed);
	if(!flag){
		
		var error="";
		var locale=document.getElementById("languageId").value;
		var sysdate=getCurrentDate("DMH",locale);
		var maxdate=addDays(new Date(),maximum_days_allowed);
		var maxToDate=changeDate(maxdate);		
		var fieldName=getLabel("eOT.date.Label","ot_labels");
		var msg=getMessage("DS_SHOULD_BE_WITHIN","DS");
		var msgArray=msg.split("#");
		error="";
		//error="Date should be within "+sysdate+" to "+maxToDate+"<br>";
		error+=fieldName;
		error+=msgArray[1];
		error+=sysdate;
		error+=msgArray[2];
		error+=maxToDate;
			
        	parent.frames.messageFrame.location.href='../../eCommon/jsp/MstCodeError.jsp?err_num='+error;
		$('#dateForMenu').focus();
		$('#dateForMenu').select();	
		
		return false;
	}else{
	var error="";
	parent.frames.messageFrame.location.href='../../eCommon/jsp/MstCodeError.jsp?err_num='+error;
	}
	}
	//ML-MMOH-CRF-0427 ends
	
	var mode = "MealContent";
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest() ;
	var xmlStr ="<root></root>";
	var param="&locale="+language_Id+"&_mTypeArr="+_mTypeArr+"&mClass="+document.getElementById("mealClass").value+"&_dTypeArr="+_dTypeArr+"&profileSL="+document.getElementById("profileSL").value+"&encounterId="+document.getElementById("encounterId").value+"&dateForMeanu="+document.getElementById("dateForMenu").value+"&dayRef="+document.getElementById("dayRef").value+"&kitchenCode="+document.getElementById("kitchenCode").value+"&addedFacilityId="+document.getElementById("addedFacilityId").value+"&dietType="+document.getElementById("dietType").value+"&mode="+mode;
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");

	var jsonDataObject = new Object();
	jsonDataObject.locale=language_Id;
	jsonDataObject.dateForMeanu=document.getElementById("dateForMenu").value;
	jsonDataObject.dietType=document.getElementById("dietType").value;
	jsonDataObject.mClass=document.getElementById("mealClass").value;
	jsonDataObject.addedFacilityId=document.getElementById("addedFacilityId").value;
	jsonDataObject.profileSL=document.getElementById("profileSL").value;
	jsonDataObject.encounterId=document.getElementById("encounterId").value;
	jsonDataObject.dayRef=document.getElementById("dayRef").value;
	jsonDataObject.kitchenCode=document.getElementById("kitchenCode").value;
	jsonDataObject._dTypeArr=_dTypeArr;
	jsonDataObject._mTypeArr=_mTypeArr;
	
	var jsonData = JSON.stringify(jsonDataObject);
	
	xmlHttp.open("POST", "../../servlet/eDS.PlaceBulkDietOrderServlet?mode="+mode+"&jsonData="+jsonData,false);
	xmlHttp.send(xmlDoc);
	retVal = (xmlHttp.responseText);
	var jsonObjResponse=eval('(' + retVal + ')');

	if(jsonObjResponse != null){
		assignMealItem(jsonObjResponse);
	}
		
}

function getDayRefNo(date) {
	if (document.getElementById("mealClass").value != "" && document.getElementById("dietType").value != "") {
		var mode = "DayRefNo";
		var language_Id =document.getElementById("languageId").value;
		
		var xmlDoc = "" ;
		var xmlHttp = new XMLHttpRequest() ;
		var xmlStr ="<root></root>";

		var jsonDataObject = new Object();
		jsonDataObject.languageId=language_Id;
		jsonDataObject.dateForMenu=document.getElementById("dateForMenu").value;
		jsonDataObject.dietType=document.getElementById("dietType").value;
		jsonDataObject.mealClass=document.getElementById("mealClass").value;
		jsonDataObject.facility=document.getElementById("addedFacilityId").value;
		var jsonData = JSON.stringify(jsonDataObject);
		
		xmlHttp.open("POST", "../../servlet/eDS.PlaceBulkDietOrderServlet?mode="+mode+"&jsonData="+jsonData,false);
		xmlHttp.send(xmlDoc);
		retVal = (xmlHttp.responseText);
		var jsonObjResponse=eval('(' + retVal + ')');
		var dayRef=(jsonObjResponse.dayRefNum);
		
		var obj = document.getElementById("dayRef");
		if(dayRef != null && dayRef != 0){
			var Entry = document.createElement("option");
			Entry.value  = (dayRef);
			Entry.text  = (dayRef);
			obj.add(Entry);
		}
		if (dayRef == "0") {
		}else {
			document.getElementById("dayRef").value = dayRef;
		}
	}
}

var supplimentArray = new Array();
var splJSONObj = new Object();
var tempObj = new Object();
async function spFoodItemsModalWindow(obj,encounterId,patientClass) {
	var k=0;
	var j=0;
	var qryEven = "QRYEVEN";
	var qryOdd = "QRYODD";
	
	specialFoodItemsObject=splJSONObj;
	var encounterId = document.getElementById("encounterId").value;
	var profileSL= document.getElementById("profileSL").value;
	
	//ML-MMOH-CRF-0427 US3 starts
	var profileFlag=$('#profileFlag').val();
	var restrict_date_inpatients_yn=$('#restrict_date_inpatients_yn').val();
	var maximum_days_allowed=$('#maximum_days_allowed').val();
	//ML-MMOH-CRF-0427 US3 ends
	//ML-MMOH-CRF-0427 Starts
	var calledFrom="SpecialFoodItemForBulkOrder";
	var dialogUrl1 = "../../eDS/jsp/NutrientSpecialFoodFrames.jsp?&mealTypeCode="+mealTypeArray+"&mealTypeDesc="+mealTypeDescArray
	+"&profileFlag="+profileFlag
	+"&restrict_date_inpatients_yn="+restrict_date_inpatients_yn//ML-MMOH-CRF-0427
	+"&maximum_days_allowed="+maximum_days_allowed
	+"&calledFrom="+calledFrom
	//+"&Title="+getLabel("eOT.fooditems.Label","ot_labels");
	+"&Title="+getLabel("eDS.SpecialFoodItem.Label","ds_labels");//5th Dec17
	//ML-MMOH-CRF-0427 ends
	
	//var dialogUrl1 = "../../eDS/jsp/SpFoodItemsForBulkOrder.jsp?&mealTypeCode="+mealTypeArray+"&mealTypeDesc="+mealTypeDescArray;
	var dialogArguments = splJSONObj;
	if(splJSONObj && splJSONObj.items!=null) {
//		tempObj.items=splJSONObj.items;
		var arr=new Array();
		for (var i = 0; i < splJSONObj.items.length; i++) {	
			var obj=new Object();
			obj.from=splJSONObj.items[i].item.from;
			obj.itemType=splJSONObj.items[i].item.itemType;
			obj.itemCode=splJSONObj.items[i].item.itemCode;
			obj.qty=splJSONObj.items[i].item.qty;
			obj.foodDesc=splJSONObj.items[i].item.foodDesc;
			obj.itemTypeDesc=splJSONObj.items[i].item.itemTypeDesc;
			obj.servingUomCode=splJSONObj.items[i].item.servingUomCode;
			obj.frequency=splJSONObj.items[i].item.frequency;
			obj.periodBetween=splJSONObj.items[i].item.periodBetween;
			obj.rowId=splJSONObj.items[i].item.rowId;
			obj.delFlag=splJSONObj.items[i].item.delFlag;
			obj.freqFlag=splJSONObj.items[i].item.freqFlag;
			obj.mealTypeCode=splJSONObj.items[i].item.mealTypeCode;
			obj.mealTypeDesc=splJSONObj.items[i].item.mealTypeDesc;
			obj.energyUom=splJSONObj.items[i].item.energyUom;
			obj.calorie=splJSONObj.items[i].item.calorie;
			obj.totalCalorie=splJSONObj.items[i].item.totalCalorie;
			
			arr.push({item:obj});
		}
		tempObj.items=arr;
	}
	var dialogFeatures = "dialogHeight:35;dialogWidth:50;status:no;scroll:no";
	var retValue = await window.showModalDialog(dialogUrl1, dialogArguments,dialogFeatures);
	if(retValue!=null)  { splJSONObj=retValue;}
	else {
		if(tempObj.items !=null) {
			var arr=new Array();
			for (var i = 0; i < tempObj.items.length; i++) {	
				var obj=new Object();
				obj.from=tempObj.items[i].item.from;
				obj.itemType=tempObj.items[i].item.itemType;
				obj.itemCode=tempObj.items[i].item.itemCode;
				obj.qty=tempObj.items[i].item.qty;
				obj.foodDesc=tempObj.items[i].item.foodDesc;
				obj.itemTypeDesc=tempObj.items[i].item.itemTypeDesc;
				obj.servingUomCode=tempObj.items[i].item.servingUomCode;
				obj.frequency=tempObj.items[i].item.frequency;
				obj.periodBetween=tempObj.items[i].item.periodBetween;
				obj.rowId=tempObj.items[i].item.rowId;
				obj.delFlag=tempObj.items[i].item.delFlag;
				obj.freqFlag=tempObj.items[i].item.freqFlag;
				obj.mealTypeCode=tempObj.items[i].item.mealTypeCode;
				obj.mealTypeDesc=tempObj.items[i].item.mealTypeDesc;
				obj.energyUom=tempObj.items[i].item.energyUom;
				obj.calorie=tempObj.items[i].item.calorie;
				obj.totalCalorie=tempObj.items[i].item.totalCalorie;
				
				arr.push({item:obj});
			}
			splJSONObj.items=arr;
		}
		else splJSONObj=new Object();
	}
	if(splJSONObj && splJSONObj.items !=null){
		var tbodyObj = document.all("FoodItems");
		while (tbodyObj.rows.length > 0) {
			tbodyObj.deleteRow(0);
		}

		var countRow = tbodyObj.rows.length;
		var row_ind = 0;
		splGTotal=0;
		for (var i = 0; i < splJSONObj.items.length; i++) {

			var classVal = (row_ind % 2 == 0) ? qryEven : qryOdd;
			var obj = splJSONObj.items[i].item;
					var newRow = tbodyObj.insertRow(row_ind);
					newRow.id = countRowValue;

					k=k+1;
					energyUom=obj.energyUom;
					splGTotal=parseFloat((Math.round(splGTotal*Math.pow(10,2))/Math.pow(10,2)))+parseFloat((Math.round(obj.calorie*Math.pow(10,2))/Math.pow(10,2)));
					document.getElementById("splFITotalCalorie").value=parseFloat((Math.round(splGTotal*Math.pow(10,2))/Math.pow(10,2)));
					var codeCell = newRow.insertCell(newRow.cells.length);
					var qtyCell = newRow.insertCell(newRow.cells.length);
					var calorieCell = newRow.insertCell(newRow.cells.length);

					var classVal = (row_ind % 2 == 0) ? qryEven : qryOdd;

					codeCell.className = "label";
					codeCell.className = classVal;
					codeCell.style.fontSize ="8pt";
					codeCell.align = "left";
					codeCell.colSpan = "3";

					qtyCell.className = "label";
					qtyCell.className = classVal;
					qtyCell.style.fontSize ="8pt";
					qtyCell.align = "left";
					qtyCell.colSpan = "3";

					calorieCell.className = "label";
					calorieCell.className = classVal;
					calorieCell.style.fontSize ="8pt";
					calorieCell.align = "left";
					calorieCell.colSpan = "3";

					codeCell.appendChild(document.createTextNode(obj.foodDesc));
					qtyCell.appendChild(document.createTextNode(obj.qty +" "+ obj.servingUomCode.toLowerCase()));

					var cal = parseFloat((Math.round(obj.calorie*Math.pow(10,2))/Math.pow(10,2)));
					var cal1 = cal+" "+obj.energyUom.toLowerCase()
					calorieCell.appendChild(document.createTextNode(cal1));

					row_ind++;
			var j=j+1;
			k++;
		}
			var tbodyObj2 = document.all("FoodItems1");
			if(tbodyObj2.rows.length>0)
			tbodyObj2.deleteRow(0);
			var newRow2 = tbodyObj2.insertRow(0);

				if(k!=0){
				var splGT = document.getElementById("splFITotalCalorie").value;
				var total = "Total";

					var labelCel = newRow2.insertCell(newRow2.cells.length);
					var calorieCel = newRow2.insertCell(newRow2.cells.length);

						labelCel.className = "lable";
						labelCel.className = classVal;
						labelCel.style.fontWeight = "700";
						labelCel.style.fontSize ="8pt";
						labelCel.style.color ="#2B1B17";
						labelCel.setAttribute("border", "0px");
						labelCel.align = "left";
						labelCel.colSpan = "3";

						calorieCel.className = "lable";
						calorieCel.className = classVal;
						calorieCel.style.fontWeight = "700";
						calorieCel.style.fontSize ="8pt";
						calorieCel.style.color ="#2B1B17";
						calorieCel.align = "left";
						calorieCel.colSpan = "6";

						labelCel.appendChild(document.createTextNode(total+" :"));
						var splGTVal = parseFloat((Math.round(splGT*Math.pow(10,2))/Math.pow(10,2)));
						var splGUom = splGTVal+" "+energyUom.toLowerCase();
						calorieCel.appendChild(document.createTextNode(splGUom));

				document.getElementById("splFITotalCalorie").value=parseFloat((Math.round(splGT*Math.pow(10,2))/Math.pow(10,2)));
				}else{
					document.getElementById("splFITotalCalorie").value=0;
				}

	}
	calGTotalCalorie();
}

/* FrequencyBased checkbox logic for splFoodItem  */

function freqEnable(val){
	if(document.getElementById("frequencyBasedYn").checked == true){
		document.getElementById("periodBetween").disabled = false;
		document.getElementById("frequencyBasedYn").disabled = false;
		document.getElementById("frequency").disabled = false;
		document.getElementById("mandatory_Freq").style.visibility="visible";
		document.getElementById("mandatory_PeriodBetweem").style.visibility="visible";
		document.getElementById("mealTypesId").disabled=true;

	}else if(document.getElementById("frequencyBasedYn").checked == false){
		document.getElementById("periodBetween").disabled = true;
		document.getElementById("mandatory_Freq").style.visibility="hidden";
		document.getElementById("mandatory_PeriodBetweem").style.visibility="hidden";
		document.getElementById("mealTypesId").disabled=false;
		document.getElementById("frequency").disabled = true;
		document.getElementById("frequency").value = "";
		document.getElementById("periodBetween").value = "";
	}
}

async function mealTypeSpFoodItems(obj,mealTypeCode,mealTypeDesc) {
	mealTypeStr1="";
	var mealtype = document.getElementById("mealType").value;
	document.getElementById("frequencyBasedYn").disabled = true
	var dialogUrl1 = "../../eDS/jsp/MealTypeForBulkOrder.jsp?&mealTypeCode="+mealTypeCode+"&mealTypeDesc="+mealTypeDesc;
	var dialogArguments = mealTypesArray;
	var dialogFeatures = "dialogHeight:12;dialogWidth:15;status:no;scroll:no";
	returnVal2 = await window.showModalDialog(dialogUrl1, dialogArguments,dialogFeatures);

	if(returnVal2) {
		mealTypeStr1=returnVal2;
		document.getElementById("frequencyBasedYn").disabled = true
	}else{
		if(mealtype == "" || mealtype == "null"){
			document.getElementById("frequencyBasedYn").disabled = false
		}else{
			document.getElementById("frequencyBasedYn").disabled = true
		}
	}
}

function defaultDisabled(){
	document.getElementById("periodBetween").disabled = true;
	document.getElementById("frequency").disabled = true;
	document.getElementById("mandatory_Freq").style.visibility="hidden";
	document.getElementById("mandatory_PeriodBetweem").style.visibility="hidden";
	document.getElementById("mealTypesId").disabled=false;
	document.getElementById("frequencyBasedYn").checked = false
}

function getMealTypes(mealTypeCode,mealTypeDesc,mealtype){
	var mealTypeArray = mealTypeCode.split(",");
	var mealTypeDescArray = mealTypeDesc.split(",");
	
	var tableObj = null;
	var found_flag = false;
	var code = null;
	tableObj = document.getElementById("AbleM");
	var selObj = "";
	var row_ind = 0;
	for (var i=0; i < mealTypeArray.length;) {
		var sel="";
		var newRow = tableObj.insertRow(row_ind);
		var newCellDesc = newRow.insertCell(newRow.cells.length);
		newCellDesc.className = "label";
		newCellDesc.appendChild(document.createTextNode(mealTypeDescArray[i]));
		sel="<input type='hidden' name='mealType' id='mealType'"+row_ind+" value='"+mealTypeArray[i]+"'>";
		var newCellCBox = newRow.insertCell(newRow.cells.length);
		var mealTypesind="mealType_"+row_ind;
		var mealTypeDesc = mealTypeDescArray[i];
			if(mealTypeDesc != ""){
				var mealTypeDescArr = mealTypeDesc.split(" ");
				for(var j=1 ; j <=mealTypeDescArr.length;j++){
					mealTypeDesc = mealTypeDesc.replace(" ","#");
				}
			}
		if(mealTypeDesc != null && mealTypeDesc != ""){
			code = mealTypeArray[i]+"@"+mealTypeDesc;
		}
		//code = mealTypeArray[i]+"@"+mealTypeDesc;
		var checkedYn = "";
		var disabledYn = "";
		if(mealtype==mealTypeArray[i])
		{
			checkedYn="checked";
		}
		if((mealtype == "" || mealtype == "null") && (code != null && code != ""))
		{
			sel+="<input type=\"checkbox\" value=" +code+ " name=" + mealTypesind + " id=" + mealTypesind + " "+checkedYn+" onclick=\"setStatus("+row_ind+",this.value)\" >"
		}else if(code != null && code != ""){
			sel+="<input type=\"checkbox\" value=" +code+ " name=" + mealTypesind + " id=" + mealTypesind + " "+checkedYn+" "+"disabled = true onclick=\"setStatus("+row_ind+",this.value)\" >"
		}
		newCellCBox.innerHTML = sel;
		row_ind++;
		i++;
	}
}

var k=0;
function setStatus(ind,mealTypes){
	chkBox = document.getElementById(("mealType_" + ind));
	if(chkBox != null || chkBox != ""){
		if(chkBox.checked == true){
			mealTypesArray[ind]=mealTypes;
			k++;
		}else{
			mealTypesArray[ind]="";
			k++;
		}
	}
}

var mealTypeStr;

function getMealTypesSpFoodItems() {
		for (var i=0; i < mealTypesArray.length ;i++ )
		{
			if(mealTypesArray[i] == undefined){
				mealTypesArray[i] = "";
			}
		}
	mealTypeStr=mealTypesArray.join("*");
	top.returnValue = mealTypeStr;
	top.close();
}

function clearFood() {
	document.all("foodType").value = "";
	document.all("foodDesc").value = "";
}

function showLookupForItemType(obj) {
	if (document.getElementById("itemType").value == "") {
		alert("Item Type Can Not be Blank");
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

	retArr = CommonLookup("Item", argumentArray);

	if (retArr != null  && retArr != "") {
		document.getElementById("foodType").value = retArr[0];
        document.getElementById("foodDesc").value = retArr[1];
        var pArgumentArrayMap = "foodItemCode=" + retArr[0];

	}
}


function ValidRecords() {
	var tableObj = document.getElementById("listContentTable");
	var countRow = tableObj.rows.length;
	var row_ind = 1;
	var key_value = "";
	
		if (document.all("from").value == "") {
			alert("From Date Cannot be Blank");
			return false;
		}
		if (document.all("itemType").value == "") {
			alert("Item Type Cannot be Blank");
			return false;
		}
		if (document.all("foodDesc").value == "" || document.all("foodType").value == "") {
			alert("Item CanNot be Blank");
			return false;
		}
		if (document.all("qty").value == "") {
			alert("Qty. Cannot be Blank");
			return false;
		}
		if(document.all("frequencyBasedYn").checked == true){
			if (document.all("frequency").value == "") {
				alert("Frequency Cannot be Blank");
				return false;
			}
			if (document.all("periodBetween").value == "") {
				alert("Period Between Cannot be Blank");
				return false;
			}
		}

		
		//ML-MMOH-CRF-0427 starts
			var profileFlag=$('#profileFlag').val();
			var restrict_date_inpatients_yn=$('#restrict_date_inpatients_yn').val();
			var maximum_days_allowed=$('#maximum_days_allowed').val();
			var selecteddate=$('#from').val();
			if(profileFlag=="true" && restrict_date_inpatients_yn=="Y"){
			var flag=grayOutCalendarValidation(selecteddate,maximum_days_allowed);
			
			if(!flag){
				var error="";
				var locale=document.getElementById("languageId").value;
				var sysdate=getCurrentDate("DMH",locale);
				var maxdate=addDays(new Date(),maximum_days_allowed);
				var maxToDate=changeDate(maxdate);			
				var fieldName=getLabel("Common.fromdate.label","common");
				var msg=getMessage("DS_SHOULD_BE_WITHIN","DS");
				var msgArray=msg.split("#");
				error="";
				//error="Date should be within "+sysdate+" to "+maxToDate+"<br>";
				error+=fieldName;
				error+=msgArray[1];
				error+=sysdate;
				error+=msgArray[2];
				error+=maxToDate;
	        	parent.frames.messageFrame.location.href='../../eCommon/jsp/MstCodeError.jsp?err_num='+error;
				$('#from').focus();
				$('#from').select();
				return false;
			}else{
				var error="";
				parent.frames.messageFrame.location.href='../../eCommon/jsp/MstCodeError.jsp?err_num='+error;
			}		
			}
		//ML-MMOH-CRF-0427 ends	
		
		var freqFlag = checkDateFreq();
		if(freqFlag != true){
			if(document.getElementById("frequency").value != "" && document.getElementById("periodBetween").value != ""){
				alert("Specified Frequency and Period Between combination  exceeds 24 hrs so Can not proceed...")
				return false;
			}
		}
		if (document.getElementById("rowNo").value == "") {
			if(specialFoodItemsObject.items==null) countRowValue=0;			
			else countRowValue=specialFoodItemsObject.items.length;

			if (parseInt(countRowValue) != 0) {
				for (var i = 0; i < specialFoodItemsObject.items.length; i++) {
							if(document.all("frequencyBasedYn").checked == true){
								var fromDate = document.all("from").value;
								var fromDateArr = fromDate.split(" ");
								var dateArr = specialFoodItemsObject.items[i].item.from.split(" ");
								
								if(specialFoodItemsObject.items[i].item.freqFlag == 'Y') {
	
									if (specialFoodItemsObject.items[i].item.foodDesc == document.all("foodDesc").value && dateArr[0] == fromDateArr[0]) {
										alert("This Food Item Already Exists");
										return false;
									}
								}
							}else if(document.all("frequencyBasedYn").checked == false){
								var fromDate = document.all("from").value;
								var fromDateArr = fromDate.split(" ");
								var dateArr = specialFoodItemsObject.items[i].item.from.split(" ");

								if(mealTypeStr1 == undefined){
									//alert("MealType can not be Blank...");//Commented against ML-MMOH-CRF-1060
									alert(getMessage("DS_MEALTYPES_NOT_BLANK","DS"));//Added against ML-MMOH-CRF-1060
									return false;
								}
								var mt_attT=mealTypeStr1.split("*");
								if(mt_attT != null || mt_attT != ""){
									if(mt_attT.length != 0 || mt_attT.length != "" || mt_attT.length != null){
										if(specialFoodItemsObject.items[i].item.freqFlag == 'N') {
											for(var k=0; k < mt_attT.length; k++){
												mt_attS = mt_attT[k].split("@");
												if(mt_attS[0] != undefined){
													if (specialFoodItemsObject.items[i].item.foodDesc == document.all("foodDesc").value && dateArr[0] == fromDateArr[0] && specialFoodItemsObject.items[i].item.mealTypeCode == mt_attS[0]) {
														alert("This Food Item Already Exists");
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
			if (document.all("from").value != "" && document.all("itemType").value != "" && document.all("foodType").value != "" && document.all("qty").value != ""
				&& document.all("frequencyBasedYn").checked == false ) {
				Apply_flag=false;
				sl_flag=false;

				var foodType = document.all("foodType").value;
				var locale =document.getElementById("language_id").value;
				var mode = "KaloriForMeals";
				var paramType = "&foodType="+foodType+"&mode="+mode+"&languageId="+locale;
				var xmlDoc="" ;
				var xmlHttp = new XMLHttpRequest() ;
				var xmlStr ="<root></root>";
				xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
				xmlHttp.open("POST", "../../servlet/eDS.PlaceDietOrderServlet?"+paramType,false);
				xmlHttp.send(xmlDoc);
				var retValue = localTrimString(xmlHttp.responseText);
				var getSplFoodItemCalori = retValue.split(",");
				var iCode = getSplFoodItemCalori[0];
				var Calori = getSplFoodItemCalori[1];
				var energyUom = getSplFoodItemCalori[2];

				window.setTimeout(splFoodItemRec1, 1000);
				function splFoodItemRec1(){
					if(mealTypeStr1 == undefined || mealTypeStr1==null){
						//alert("MealType can not be Blank...")//Commented against ML-MMOH-CRF-1060
						alert(getMessage("DS_MEALTYPES_NOT_BLANK","DS"));//Added against ML-MMOH-CRF-1060
						return false;
					}
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

									var itemTypeDesc=document.all("itemType").options[document.all("itemType").selectedIndex].text;
									var tempObj=new Object();
									
									tempObj.from=document.all("from").value;
									tempObj.itemType=document.all("itemType").value;
									tempObj.itemCode=document.all("foodType").value;
									tempObj.qty=document.all("qty").value;
									tempObj.foodDesc=document.all("foodDesc").value;
									tempObj.itemTypeDesc=itemTypeDesc;
									tempObj.mealTypeCode=mt_att[0];
									tempObj.mealTypeDesc=mt_att[1];
									tempObj.servingUomCode=document.all("servingUomCode").value;
									tempObj.rowId=countRowValue;
									tempObj.delFlag="N";
									tempObj.freqFlag="N";
									tempObj.frequency="";
									tempObj.periodBetween="";

									insFlag = true;
									var newRow = tableObj.insertRow(row_ind);
									newRow.id = countRowValue;
									var newCellitemType = newRow.insertCell(newRow.cells.length);
									var code = document.all("itemType").value + "-" + document.all("foodType").value;
									var sub = "<A href=\"#\" onclick=\"return fetchSpFoodItemRow('" + countRowValue + "','N');\" >" + itemTypeDesc + "</A>";
									newCellitemType.innerHTML = sub;

									var newCellDate = newRow.insertCell(newRow.cells.length);
									newCellDate.appendChild(document.createTextNode(document.all("from").value));

									var newCellfoodType = newRow.insertCell(newRow.cells.length);
									newCellfoodType.appendChild(document.createTextNode(document.all("foodDesc").value));

									qty=document.all("qty").value;
									uomCode=document.getElementById("servingUomCode").value;

									var CaloriT=parseFloat((Math.round(qty*Math.pow(10,2))/Math.pow(10,2)))*parseFloat((Math.round(Calori*Math.pow(10,2))/Math.pow(10,2)))

									tempObj.energyUom=energyUom;

									TotalCalorie=parseFloat((Math.round(TotalCalorie*Math.pow(10,2))/Math.pow(10,2)))+parseFloat((Math.round(CaloriT*Math.pow(10,2))/Math.pow(10,2)));
									
									tempObj.calorie=parseFloat((Math.round(CaloriT*Math.pow(10,2))/Math.pow(10,2)));
									tempObj.totalCalorie=parseFloat((Math.round(TotalCalorie*Math.pow(10,2))/Math.pow(10,2)));

									var cal1 = parseFloat((Math.round(CaloriT*Math.pow(10,2))/Math.pow(10,2)));
									var cal2 = cal1+" "+energyUom
									var newCellqty = newRow.insertCell(newRow.cells.length);
									newCellqty.appendChild(document.createTextNode(qty+" "+uomCode+"("+cal2+")"));

									var newCellMealTypeDesc = newRow.insertCell(newRow.cells.length);
									newCellMealTypeDesc.appendChild(document.createTextNode(mt_att[1]));

									var newCellFrequency = newRow.insertCell(newRow.cells.length);
									newCellFrequency.appendChild(document.createTextNode(""));

									var newCellPeriodBetween = newRow.insertCell(newRow.cells.length);
									newCellPeriodBetween.appendChild(document.createTextNode(""));
									countRowValue++;
									spclFoodItemsArr.push({item:tempObj});
									specialFoodItemsObject.items=spclFoodItemsArr;

								}
							}
						}
					}
					document.all("from").value = "";
					document.all("itemType").value = "";
					document.all("foodDesc").value = "";
					document.all("qty").value = "";
					document.all("foodType").value = "";
					document.getElementById("servingUomCode").value="";
					document.getElementById("frequencyBasedYn").disabled = false;
					document.getElementById("mealTypesId").disabled = false;
					document.getElementById("frequencyBasedYn").checked = false;					
				}
					document.getElementById("rowNo").value = "";
				} else{
					sl_flag=false;
					Apply_flag=false;
					var foodType = document.all("foodType").value;
					var locale =document.getElementById("language_id").value;
					var mode = "KaloriForMeals";
					var paramType = "&foodType="+foodType+"&mode="+mode+"&languageId="+locale;
					var xmlDoc="" ;
					var xmlHttp = new XMLHttpRequest() ;
					var xmlStr ="<root></root>";
					xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
					xmlHttp.open("POST", "../../servlet/eDS.PlaceDietOrderServlet?"+paramType,false);
					xmlHttp.send(xmlDoc);
					var retValue = localTrimString(xmlHttp.responseText);
					var getSplFoodItemCalori = retValue.split(",");
					var iCode = getSplFoodItemCalori[0];
					var Calori = getSplFoodItemCalori[1];
					var energyUom = getSplFoodItemCalori[2];
					window.setTimeout(timeOutFunction, 500);
						function timeOutFunction(){
						
						var tempObj=new Object();
						var itemTypeDesc=document.all("itemType").options[document.all("itemType").selectedIndex].text;
						tempObj.from=document.all("from").value;
						tempObj.itemType=document.all("itemType").value;
						tempObj.itemCode=document.all("foodType").value;
						tempObj.qty=document.all("qty").value;
						tempObj.foodDesc=document.all("foodDesc").value;
						tempObj.itemTypeDesc=itemTypeDesc;
						tempObj.servingUomCode=document.all("servingUomCode").value;
						tempObj.frequency=document.getElementById("frequency").value;
						tempObj.periodBetween=document.getElementById("periodBetween").value;
						tempObj.rowId=countRowValue;
						tempObj.delFlag="N";
						tempObj.freqFlag="Y";
						tempObj.mealTypeCode="";
						tempObj.mealTypeDesc="";						
						document.getElementById("frequencyBasedYn").disabled = false;

						insFlag = true;
						var newRow = tableObj.insertRow(row_ind);
						newRow.id = countRowValue;
						var newCellitemType = newRow.insertCell(newRow.cells.length);
						var code = document.all("itemType").value + "-" + document.all("foodType").value;
						var sub = "<A href=\"#\" onclick=\"return fetchSpFoodItemRow('" + countRowValue + "','Y');\" >" + itemTypeDesc + "</A>";
						newCellitemType.innerHTML = sub;
						var newCellDate = newRow.insertCell(newRow.cells.length);
						newCellDate.appendChild(document.createTextNode(tempObj.from));

						var newCellfoodType = newRow.insertCell(newRow.cells.length);
						newCellfoodType.appendChild(document.createTextNode(tempObj.foodDesc));

						qty=tempObj.qty;
						uomCode=tempObj.servingUomCode;
						var CaloriT=parseFloat((Math.round(qty*Math.pow(10,2))/Math.pow(10,2)))*parseFloat((Math.round(Calori*Math.pow(10,2))/Math.pow(10,2)))
						tempObj.energyUom=energyUom;

						TotalCalorie=parseFloat((Math.round(TotalCalorie*Math.pow(10,2))/Math.pow(10,2)))+parseFloat((Math.round(CaloriT*Math.pow(10,2))/Math.pow(10,2)));
						tempObj.calorie=CaloriT;
						tempObj.totalCalorie=TotalCalorie;
						var newCellqty = newRow.insertCell(newRow.cells.length);
						var cal = CaloriT;
						var cal1 = cal+" "+energyUom;
						newCellqty.appendChild(document.createTextNode(qty+" "+uomCode+"("+cal1+")"));

						var newCellMealTypeDesc = newRow.insertCell(newRow.cells.length);
						newCellMealTypeDesc.appendChild(document.createTextNode(""));

						var newCellFrequency = newRow.insertCell(newRow.cells.length);
						newCellFrequency.appendChild(document.createTextNode(tempObj.frequency));

						var newCellPeriodBetween = newRow.insertCell(newRow.cells.length);
						newCellPeriodBetween.appendChild(document.createTextNode(tempObj.periodBetween));
						clearSplFoodItemsFields();
						document.getElementById("frequencyBasedYn").disabled = false;
						document.getElementById("mealTypesId").disabled = false;
						document.getElementById("frequencyBasedYn").checked = false;
						document.getElementById("frequency").disabled=true;
						document.getElementById("frequency").value="";
						document.getElementById("periodBetween").disabled=true;
						document.getElementById("mandatory_Freq").style.visibility="hidden";
						document.getElementById("mandatory_PeriodBetweem").style.visibility="hidden";
						
						spclFoodItemsArr.push({item:tempObj});
						specialFoodItemsObject.items=spclFoodItemsArr;						
					}
				}
		}else{
			Apply_flag=false;
			sl_flag=true;
			var foodType = document.all("foodType").value;
			var locale =document.getElementById("language_id").value;
			var mode = "KaloriForMeals";
			var paramType = "&foodType="+foodType+"&mode="+mode+"&languageId="+locale;
			var xmlDoc="" ;
			var xmlHttp = new XMLHttpRequest() ;
			var xmlStr ="<root></root>";
			xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
			xmlHttp.open("POST", "../../servlet/eDS.PlaceDietOrderServlet?"+paramType,false);
			xmlHttp.send(xmlDoc);
			var retValue = localTrimString(xmlHttp.responseText);
			var getSplFoodItemCalori = retValue.split(",");
			var iCode = getSplFoodItemCalori[0];
			var Calori = getSplFoodItemCalori[1];
			var energyUom = getSplFoodItemCalori[2];

			var supCode = document.getElementById("rowNo").value;
			
			specialFoodItemsObject.items[supCode].item.from=document.all("from").value;
			specialFoodItemsObject.items[supCode].item.frequency=document.getElementById("frequency").value;
			specialFoodItemsObject.items[supCode].item.itemType=document.all("itemType").value;
			specialFoodItemsObject.items[supCode].item.itemCode=document.all("foodType").value;
			specialFoodItemsObject.items[supCode].item.qty=document.all("qty").value;
			specialFoodItemsObject.items[supCode].item.foodDesc=document.all("foodDesc").value;
			specialFoodItemsObject.items[supCode].item.itemTypeDesc=document.all("itemType").options[document.all("itemType").selectedIndex].text;;
			specialFoodItemsObject.items[supCode].item.servingUomCode=document.getElementById("servingUomCode").value;
			specialFoodItemsObject.items[supCode].item.energyUom=energyUom;
			specialFoodItemsObject.items[supCode].item.mealTypeDesc=document.getElementById("mealTypeDesc").value;
			specialFoodItemsObject.items[supCode].item.mealTypeCode=document.getElementById("mealType").value;
			
			document.getElementById("frequencyBasedYn").disabled = false;
			
			specialFoodItemsObject.items[supCode].item.periodBetween = document.getElementById("periodBetween").value;
			updFlag = true;
			document.getElementById("rowNo").value = "";
			var tableObj = document.getElementById("listContentTable");
			while (tableObj.rows.length > 1) {
				tableObj.deleteRow(1);
			}

			for (var i = 0; i < specialFoodItemsObject.items.length; i++) {
				var countRow = tableObj.rows.length;
				var row_ind = 1;

				var newRow = tableObj.insertRow(row_ind);
				var newCellitemType = newRow.insertCell(newRow.cells.length);
				var sub = "<A  href=\"#\" onclick=\"return fetchSpFoodItemRow('" + i + "','"+specialFoodItemsObject.items[i].item.freqFlag+"');\" >" + specialFoodItemsObject.items[i].item.itemTypeDesc + "</A>";
				newCellitemType.innerHTML = sub;
				var newCellDate = newRow.insertCell(newRow.cells.length);
				newCellDate.appendChild(document.createTextNode(specialFoodItemsObject.items[i].item.from));
				var newCellfoodType = newRow.insertCell(newRow.cells.length);
				newCellfoodType.appendChild(document.createTextNode(specialFoodItemsObject.items[i].item.foodDesc));
				var newCellqty = newRow.insertCell(newRow.cells.length);
				newCellqty.appendChild(document.createTextNode(specialFoodItemsObject.items[i].item.qty+" "+specialFoodItemsObject.items[i].item.servingUomCode+"("+specialFoodItemsObject.items[i].item.calorie+" "+specialFoodItemsObject.items[i].item.energyUom+")"));

				var newCellMealTypeDesc = newRow.insertCell(newRow.cells.length);
				newCellMealTypeDesc.appendChild(document.createTextNode(specialFoodItemsObject.items[i].item.mealTypeDesc));
				var newCellFrequency = newRow.insertCell(newRow.cells.length);
				newCellFrequency.appendChild(document.createTextNode(specialFoodItemsObject.items[i].item.frequency));
				var newCellPeriodBetween = newRow.insertCell(newRow.cells.length);
				newCellPeriodBetween.appendChild(document.createTextNode(specialFoodItemsObject.items[i].item.periodBetween));
	}	
			clearSplFoodItemsFields();
				document.getElementById("frequencyBasedYn").disabled = false;
				document.getElementById("mealTypesId").disabled = false;
				document.getElementById("frequencyBasedYn").checked = false;
				document.getElementById("frequency").disabled=true;
				document.getElementById("frequency").value="";
				document.getElementById("periodBetween").disabled=true;
				document.getElementById("mandatory_Freq").style.visibility="hidden";
				document.getElementById("mandatory_PeriodBetweem").style.visibility="hidden";				
		}
}

function dmyDate(s){
	var A= s.split(/\D+/);
	var D= new Date(A[2]*1,A[1]-1,A[0]*1)
	if(A.length == 5)D.setHours(A[3]*1,A[4]*1);
	return new Date(D);
}

function checkDateFreq(){
	var periodTime = document.all("periodBetween").value;
	var freq = document.all("frequency").value;
	var SDate = document.getElementById("from").value;

	STime = SDate.split(" ");
	STDate = STime[0]+" "+"23:59";
	var m_seconds2 = (dmyDate(SDate).getTime())
	var m_seconds3 = (dmyDate(STDate).getTime())
	var mills=Math.ceil(m_seconds3-m_seconds2);
	var pt=periodTime.split(":");
	var periodTime1 = pt[0];
	var inMins = periodTime1*60;
	var totalMins=parseInt(inMins)+parseInt(pt[1])
	var totalSec = totalMins*60;
	var totalMilliSec = totalSec*1000;
	var totalMillsWithFreq = totalMilliSec*parseInt(freq)
	if(totalMillsWithFreq>mills){
		f10=false;
		return f10=false;
	}else{

		f10=true;
		return f10=true;
	}
	return f10;
}
function localTrimString(sInString) {
	if(sInString != ""){
		return sInString.replace(/[\[\]']+/g,''); 
	}
	return "";
}

function clearSplFoodItemsFields(){
	document.all("from").value = "";
	document.all("itemType").value = "";
	document.all("foodDesc").value = "";
	document.all("qty").value = "";
	document.all("rowNo").value = "";
	document.all("foodType").value = "";
	document.getElementById("servingUomCode").value="";
	document.getElementById("frequency").value="";
	document.getElementById("periodBetween").value="";
}
function checkDigit(){
	obj =  String.fromCharCode(window.event.keyCode);
   	var alphaFilter =/^[0-9]+$/;
   	if (!(alphaFilter.test(obj))) {
   	var num ="Numbers Only Allowed";
	alert(num)
   	window.event.keyCode = 27;
		}
}
//validating Period between in Spl FoodItem window.
function setPeriod(obj)
{
	var flag=true;
	if(parseInt(obj.value)==1)document.getElementById("periodBetween").value="01:00"
		else if(parseInt(obj.value)==0)
		{

		flag=false;
		var mes = "Frequency Based";
		var label1 = mes;
		var mes1 ="should be greater than"
		var msg = mes1;
		var error="";
		error=label1+" "+msg+"  0";
		alert(error)
		obj.value="";
		obj.select;
		obj.focus();
	}
	return flag;
}
function verify(timeBox){
	if(timeBox.value != ""){
		if(parseInt(timeBox.value.length)<=parseInt(5))
		{
			if(timeBox.value!=""){
				time=timeBox.value
			    time1=time.split(':')
			    if (!/\d{2}:\d{2}/.test(time)){
					alert("Invalid Time Format");
					timeBox.value='';
					timeBox.focus();
					return false;
			    }else if (time1[0] >23 || time1[1]>59) {
			    	alert("Invalid Time Format");
					timeBox.value='';
					timeBox.focus();
				return false;
			}else return true;

			}else{
				timeBox.value='';
				alert("Invalid Time Format");
				timeBox.focus();
				return false;
				}
			}else{
				timeBox.value='';
				alert("Invalid Time Format");
				timeBox.focus();
				return false;
			}
		}
	}

function setRecord(){
	var tbodyObj = document.all("listContentTable");

	var countRow = tbodyObj.rows.length;
	if(countRow == 0){
		alert("APP-DS0019 Select Atleast One Record")
			return false;

	}else{

		setRecord12();
	}
}

function setRecord12(){
	top.returnValue = specialFoodItemsObject;
	top.close();
}

function setRecord1(){
	for(var i =0; i < foodARR.length; i++){
		if(Apply_flag == false && insFlag){
			if(foodARR[i] == null){
				break;
			}
			var encounterId = document.getElementById("encounterId").value;
			var patientClass = document.getElementById("patientClass").value;
			var facility= document.getElementById("addedFacilityId").value;
			var addedById = document.getElementById("addedById").value;
			var workStationNo = document.getElementById("workStationNo").value;
			var profileSL=document.getElementById("profileSL").value;
			var flag = document.getElementById("flag").value;
			if(profileSL=="" || profileSL == "0" || profileSL == null ){
				profileSL="0";
			}
			var paramType = "&encounterId="+encounterId
							+"&patientClass="+patientClass
							+"&facility="+facility
							+"&addedById="+addedById
							+"&workStationNo="+workStationNo
							+"&profileSL="+profileSL
							+"&flag="+flag
							+"&mode="+mode
							+"&foodARR="+foodARR[i];

			var xmlDoc="" ;
			var xmlHttp = new XMLHttpRequest() ;
			var xmlStr ="<root></root>";
			xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
			xmlHttp.open("POST", "../../servlet/eDS.PlaceDietOrderServlet?"+paramType,false);
			xmlHttp.send(xmlDoc);
			var retValue = localTrimString(xmlHttp.responseText);

		}
	}

	Apply_flag == true;
	if(sl_flag == true){
		getSlNo();
		sl_flag == false;
	}
	getFoodDetailsDtls();
	window.close();
}
function fetchSpFoodItemRow(val,freqFlag) {
	var jsonObj=specialFoodItemsObject;
	var arr;
	document.all("from").value = jsonObj.items[val].item.from;
	document.all("itemType").value = jsonObj.items[val].item.itemType;
	document.all("foodType").value = jsonObj.items[val].item.itemCode;
	document.all("foodDesc").value = jsonObj.items[val].item.foodDesc;
	document.all("qty").value = jsonObj.items[val].item.qty;
	document.getElementById("servingUomCode").value=jsonObj.items[val].item.servingUomCode;
	document.getElementById("mealTypeDesc").value=jsonObj.items[val].item.mealTypeDesc;
	document.all("rowNo").value = val;
	
	if(freqFlag=='N') {
		document.getElementById("mealType").value = jsonObj.items[val].item.mealTypeCode;
		document.getElementById("frequencyBasedYn").checked=false;
		document.getElementById("frequencyBasedYn").value="N";
		document.getElementById("periodBetween").value="";
		document.getElementById("frequency").disabled=true;
		document.getElementById("frequency").value="";
		document.getElementById("periodBetween").disabled=true;
		document.getElementById("mandatory_Freq").style.visibility="hidden";
		document.getElementById("mandatory_PeriodBetweem").style.visibility="hidden";
		document.getElementById("mealTypesId").disabled = false;
		document.getElementById("frequencyBasedYn").disabled = true;
	}

	else {
		document.getElementById("frequency").value=jsonObj.items[val].item.frequency;
		document.getElementById("periodBetween").value=jsonObj.items[val].item.periodBetween;
		document.getElementById("frequencyBasedYn").checked=true;
		document.getElementById("frequencyBasedYn").value="Y";
		document.getElementById("frequency").disabled=false;
		document.getElementById("periodBetween").disabled=false;
		document.getElementById("mandatory_Freq").style.visibility="visible";
		document.getElementById("mandatory_PeriodBetweem").style.visibility="visible";
		document.getElementById("mealTypesId").disabled = true;
		document.getElementById("frequencyBasedYn").disabled = true;
	}
}

function fetchSpFoodItemRow1(val) {
	sl_flag=true;
	Apply_flag=false;

	if(foodARR[val][6] > 0 && foodARR[val][5] > 0){
		if(itemSrlNo.length == 0){
			var i = 0;
		}
		itemSrlNo[i] = foodARR[val][6];
		prlSLdel[i] = foodARR[val][5];
	}

	document.all("from").value = trim(foodARR[val][0]);
	document.all("itemType").value = trim(foodARR[val][2]);
	document.all("foodType").value = trim(foodARR[val][3]);
	document.all("foodDesc").value = trim(foodARR[val][7]);
	document.all("qty").value = trim(foodARR[val][4]);
	document.getElementById("mealType").value = trim(foodARR[val][20]);
	document.getElementById("servingUomCode").value=trim(foodARR[val][9]);
	document.getElementById("frequency").value=trim(foodARR[val][1]);
	document.getElementById("periodBetween").value=trim(foodARR[val][17]);
	document.getElementById("mealTypeDesc").value=trim(foodARR[val][18]);
	document.all("rowNo").value = val;

	if(document.getElementById("frequency").value != null && document.getElementById("periodBetween").value != "" 
			&& document.getElementById("frequency").value != "null"){

		document.getElementById("frequencyBasedYn").checked=true;
		document.getElementById("frequencyBasedYn").value="Y";
		document.getElementById("frequency").disabled=false;
		document.getElementById("periodBetween").disabled=false;
		document.getElementById("mandatory_Freq").style.visibility="visible";
		document.getElementById("mandatory_PeriodBetweem").style.visibility="visible";
		document.getElementById("mealTypesId").disabled = true;
		document.getElementById("frequencyBasedYn").disabled = true;
	}else{

		document.getElementById("frequencyBasedYn").checked=false;
		document.getElementById("frequencyBasedYn").value="N";
		document.getElementById("periodBetween").value="";
		document.getElementById("frequency").disabled=true;
		document.getElementById("frequency").value="";
		document.getElementById("periodBetween").disabled=true;
		document.getElementById("mandatory_Freq").style.visibility="hidden";
		document.getElementById("mandatory_PeriodBetweem").style.visibility="hidden";
		document.getElementById("mealTypesId").disabled = false;
		document.getElementById("frequencyBasedYn").disabled = true;
		
	}
	i++;
}

var flagMTs=true;
var emptyFlag=true;
var gRowNo = null;
var delFlag = false;
function deleteSpItemRow() {
	delFlag = true;
	flagMTs=false;
	sl_flag=true;
	Apply_flag=false;
	mealTypeStr1="";
	var val=document.all("rowNo").value;
	if (document.all("rowNo").value == "") {
		alert("Please Select Atleast One Record to delete");
		return false;
	}
	spclFoodItemsArr=new Array();
	for (var i = 0; i < specialFoodItemsObject.items.length; i++) {
		var tempObj=new Object();
		tempObj=specialFoodItemsObject.items[i].item;
		spclFoodItemsArr.push({item:tempObj});
		
	}
	var tableObj = document.getElementById("listContentTable");
	var totalRows=tableObj.rows.length-1;
	tableObj.deleteRow(totalRows-val);
	while (tableObj.rows.length > 1) {
		tableObj.deleteRow(1);
	}

	spclFoodItemsArr.splice(val,1);
	specialFoodItemsObject.items=spclFoodItemsArr;
	
	for (var i = 0; i < specialFoodItemsObject.items.length; i++) {
				var countRow = tableObj.rows.length;
				var row_ind = 1;

				var newRow = tableObj.insertRow(row_ind);
				var newCellitemType = newRow.insertCell(newRow.cells.length);
				var sub = "<A  href=\"#\" onclick=\"return fetchSpFoodItemRow('" + i + "','"+specialFoodItemsObject.items[i].item.freqFlag+"');\" >" + specialFoodItemsObject.items[i].item.itemTypeDesc + "</A>";
				newCellitemType.innerHTML = sub;
				var newCellDate = newRow.insertCell(newRow.cells.length);
				newCellDate.appendChild(document.createTextNode(specialFoodItemsObject.items[i].item.from));
				var newCellfoodType = newRow.insertCell(newRow.cells.length);
				newCellfoodType.appendChild(document.createTextNode(specialFoodItemsObject.items[i].item.foodDesc));
				var newCellqty = newRow.insertCell(newRow.cells.length);
				newCellqty.appendChild(document.createTextNode(specialFoodItemsObject.items[i].item.qty+" "+specialFoodItemsObject.items[i].item.servingUomCode+"("+specialFoodItemsObject.items[i].item.calorie+" "+specialFoodItemsObject.items[i].item.energyUom+")"));
				var newCellMealTypeDesc = newRow.insertCell(newRow.cells.length);
				newCellMealTypeDesc.appendChild(document.createTextNode(specialFoodItemsObject.items[i].item.mealTypeDesc));
				var newCellFrequency = newRow.insertCell(newRow.cells.length);
				newCellFrequency.appendChild(document.createTextNode(specialFoodItemsObject.items[i].item.frequency));
				var newCellPeriodBetween = newRow.insertCell(newRow.cells.length);
				newCellPeriodBetween.appendChild(document.createTextNode(specialFoodItemsObject.items[i].item.periodBetween));
	}
	document.all("from").value = "";
	document.all("itemType").value = "";
	document.all("foodType").value = "";
	document.all("foodDesc").value = "";
	document.all("qty").value = "";
	document.all("rowNo").value = "";
	document.getElementById("servingUomCode").value="";
	document.getElementById("frequency").value="";
	document.getElementById("periodBetween").value="";
	document.getElementById("frequencyBasedYn").checked=false;
	document.getElementById("frequencyBasedYn").disabled=false;
	document.getElementById("mealTypesId").disabled=false;
	document.getElementById("frequencyBasedYn").value="N";	
}

function showLookup(obj) {
	var locale = document.getElementById("language_id").value;
	var argumentArray = new Array();
	var dataNameArray = new Array();
	var dataValueArray = new Array();
	var dataTypeArray = new Array();

	var sql = "SELECT A.FOOD_ITEM_CODE CODE,A.SHORT_DESC DESCRIPTION FROM DS_ITEMS A WHERE A.EFF_STATUS ='E' AND UPPER(A.SHORT_DESC) LIKE UPPER(?) AND UPPER(A.FOOD_ITEM_CODE) LIKE UPPER(?) AND A.LANGUAGE_ID LIKE '"+locale+"'";

	argumentArray[0] = sql;
	argumentArray[1] = dataNameArray;
	argumentArray[2] = dataValueArray;
	argumentArray[3] = dataTypeArray;
	argumentArray[4] = "2,1";
	argumentArray[5] = obj.value;
	argumentArray[6] = CODE_LINK;
	argumentArray[7] = CODE_DESC;

	retArr = CommonLookup("Item", argumentArray);
	if (retArr != null && retArr != "") {
		document.getElementById("foodType").value = retArr[0];
		document.getElementById("foodDesc").value = retArr[1];
	}
}

//Food Item
var foodDislikeList = new Array();
var foodDislikeJSONObj=new Object();
var dislikeJSONObj = new Object();
var countRowValue = 0;
var foodDislikeListArr = new Array();
var itemCodeDel = new Array();
var dislikeJSONObj = new Object();
var tempObj_dislikes = new Object();
async function foodDislikesModelWindow(obj) {
	var dialogUrl1 = "../../eDS/jsp/FoodDislikesForBulkOrder.jsp";
	var dialogArguments = dislikeJSONObj;
	var dialogFeatures = "dialogHeight:25;dialogWidth:32;status:no;scroll:no";
	
	if(dislikeJSONObj && dislikeJSONObj.items!=null) {
		var arr=new Array();
		for (var i = 0; i < dislikeJSONObj.items.length; i++) {	
			var obj=new Object();
			obj.itemCode=dislikeJSONObj.items[i].item.itemCode;
			obj.itemDesc=dislikeJSONObj.items[i].item.itemDesc;
			obj.flag=dislikeJSONObj.items[i].item.flag;
			
			arr.push({item:obj});
		}
		tempObj.items=arr;
	}
	returnVal1 = await window.showModalDialog(dialogUrl1, dialogArguments,dialogFeatures);
	
	if (returnVal1 && returnVal1.items !=null) {
		dislikeJSONObj = returnVal1;
		var tbodyObj = document.all("DislikesFoodItems");
		while (tbodyObj.rows.length > 0) {
			tbodyObj.deleteRow(0);
		}
		var countRow = tbodyObj.rows.length;
		var row_ind = 0;
		for (var i = 0; i < dislikeJSONObj.items.length; i++) {
				if (dislikeJSONObj.items[i].item.flag != "-1") {
					var newRow = tbodyObj.insertRow(row_ind);
					newRow.id = countRowValue;
					var newCellitemType = newRow.insertCell(newRow.cells.length);

					var newCellDate = newRow.insertCell(newRow.cells.length);
					newCellDate.className = "data";
					newCellDate.appendChild(document.createTextNode(dislikeJSONObj.items[i].item.itemDesc));

					row_ind++;
				}else{
					row_ind++;
				}
		}
	}
	else {
		if(tempObj.items !=null) {
			var arr=new Array();
			for (var i = 0; i < tempObj.items.length; i++) {	
				var obj=new Object();
				obj.itemCode=tempObj.items[i].item.itemCode;
				obj.itemDesc=tempObj.items[i].item.itemDesc;
				obj.flag=tempObj.items[i].item.flag;
				
				arr.push({item:obj});
			}
			dislikeJSONObj.items=arr;			
		}
		else dislikeJSONObj=new Object();
	}	
}

function getFoodDislikeDtls() {
	top.returnValue = foodDislikeJSONObj;
	window.close();
}

function AddFoodDislikeItem() {
	if (document.getElementById("foodType").value == "" || document.getElementById("foodDesc").value =="") {
		var msg = "Item can not be blank";
		alert(msg);
		return false;
	}
	var row_ind = 1;
	var count=0;
	var tabObj = document.getElementById("listContentTable");
	if(foodDislikeJSONObj.items==null) count=0;
	else count = foodDislikeJSONObj.items.length;
	var flag = true;
	if (document.getElementById("rowNo").value == "") {
		for (var k = 0; k < count; k++)
		{
			var obj = foodDislikeJSONObj.items[k].item;
			if(obj != null){
				if(obj.itemCode==document.getElementById("foodType").value){
				var msg ="Food Item Already Exists";
				alert(msg);
				return false;
				}
			}
		}
			var newRow = tabObj.insertRow(row_ind);
			var newCellitemType = newRow.insertCell(newRow.cells.length);
			var sub = "<A  href=\"#\" onclick=\"return fetchFoodDislikesRow('" + count + "');\" >" + document.getElementById("foodDesc").value + "</A>";
			newCellitemType.innerHTML = sub;
			var tempObj=new Object();
			tempObj.itemCode = document.getElementById("foodType").value;
			tempObj.itemDesc = document.getElementById("foodDesc").value;
			tempObj.flag = "0";
			foodDislikeList.push({item:tempObj});
			foodDislikeJSONObj.items=foodDislikeList;
	}else {
		var id = document.getElementById("rowNo").value;
		foodDislikeJSONObj.items[id].item.itemCode = document.getElementById("foodType").value;
		foodDislikeJSONObj.items[id].item.itemDesc = document.getElementById("foodDesc").value;
		foodDislikeJSONObj.items[id].item.flag = "0";

		var tbodyObj = document.all("listContentTable");
		while (tbodyObj.rows.length > 1) {
			tbodyObj.deleteRow(1);
		}
		var countRow = tbodyObj.rows.length;
		var row_ind = 1;
		var obj;
		for (var i = 0; i < foodDislikeJSONObj.items.length; i++) {
					if (foodDislikeJSONObj.items[i].item.flag != "-1") {
						var newRow = tbodyObj.insertRow(row_ind);
						var newCellitemType = newRow.insertCell(newRow.cells.length);
						var sub = "<A href=\"#\" onclick=\"return fetchFoodDislikesRow('" + i + "');\" >" + foodDislikeJSONObj.items[i].item.itemDesc + "</A>";
						newCellitemType.innerHTML = sub;
					}
		}
	}
	document.getElementById("rowNo").value = "";
	document.getElementById("foodType").value = "";
	document.getElementById("foodDesc").value="";
}

function fetchFoodDislikesRow(val) {
	document.all("foodType").value = foodDislikeJSONObj.items[val].item.itemCode;
	document.all("foodDesc").value = foodDislikeJSONObj.items[val].item.itemDesc;
	document.all("rowNo").value = val;
}


function deleteFoodDislikesRow() {
	if (document.getElementById("foodType").value == "" || document.getElementById("foodDesc").value =="") {
		var msg = "Item can not be blank";
		alert(msg);
		return false;
	}
	
	var foodType = document.getElementById("foodType").value;
	
	if (document.getElementById("rowNo").value != "") {
		var cod = document.getElementById("rowNo").value;
		foodDislikeList=new Array();
		for (var i = 0; i < foodDislikeJSONObj.items.length; i++) {
			var tempObj=new Object();
			tempObj=foodDislikeJSONObj.items[i].item;
			foodDislikeList.push({item:tempObj});
			
		}		
		foodDislikeList.splice(cod,1);
		foodDislikeJSONObj.items=foodDislikeList;
		
		var tbodyObj = document.all("listContentTable");
		while (tbodyObj.rows.length > 1) {
			tbodyObj.deleteRow(1);
		}
		var countRow = tbodyObj.rows.length;
		var row_ind = 1;
		var j=0;
		for (var i = 0; i < foodDislikeList.length; i++) {
				if (foodDislikeJSONObj.items[i].item.flag != "-1") {
					var newRow = tbodyObj.insertRow(row_ind);
					var newCellitemType = newRow.insertCell(newRow.cells.length);
					var sub = "<A href=\"#\" onclick=\"return fetchFoodDislikesRow('" + j + "');\" >" + foodDislikeJSONObj.items[i].item.itemDesc + "</A>";
					j++;
					newCellitemType.innerHTML = sub;
				}
		}
	}
	document.getElementById("rowNo").value = "";
	document.getElementById("foodType").value = "";
	document.getElementById("foodDesc").value = "";
	
}

function trimString(sInString){
	if(sInString != ""){
		return sInString.replace(/^\s+|\s+$/g,"");
	}
	return "";
}

function insertFoodDislikes() {
	var locale=document.getElementById("languageId").value;
	var dateFormate=document.getElementById("datepattrn1").value;
	var jsonData = JSON.stringify(dislikeJSONObj);
	var mode = "insertFoodDislikes";
	var facility= document.getElementById("addedFacilityId").value;
	var addedById = document.getElementById("addedById").value;
	var workStationNo = document.getElementById("addedAtWsNo").value;
	
	var jsonPatientObject=new Object();
	jsonPatientObject.patients=jsonPatientArr_Dislikes;	
	
	
	var xmlDoc="" ;
	var xmlHttp = new XMLHttpRequest() ;
	var xmlStr ="<root></root>";
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST", "../../servlet/eDS.PlaceBulkDietOrderServlet?mode="+mode+"&jsonData="+jsonData+"&facilityId="+facility+"&addedId="+addedById+"&workStNo="+workStationNo+"&jsonPatientObject="+JSON.stringify(jsonPatientObject),false);
	xmlHttp.send(xmlDoc);
	retVal = (xmlHttp.responseText);
	
}

function checkAll_Dislikes() {
	var jsonPatientObject=new Object();
	jsonPatientObject=parent.patientsObj;
	
	if(document.getElementById("chk_dislike_checkAll").checked) {
		document.getElementById("foodItem_dislike_flow_text").disabled=false;
		jsonPatientArr_Dislikes.splice(0,jsonPatientArr_Dislikes.length);
		for(var i=0;i<jsonPatientObject.patients.length;i++) {
			jsonPatientArr_Dislikes.push({patient:jsonPatientObject.patients[i].patient});
			encounterId=jsonPatientObject.patients[i].patient.encounterId;
			if(document.getElementById("chk_dislike_"+encounterId)) {
				document.getElementById("chk_dislike_"+encounterId).checked=true;
			}
		}
	}
	else {
		var i=0;
		jsonPatientArr_Dislikes.splice(0,jsonPatientArr_Dislikes.length);
		if(dislikeJSONObj && dislikeJSONObj.items !=null && dislikeJSONObj.items.length>0) {
			jsonPatientArr_Dislikes.push({patient:jsonPatientObject.patients[0].patient});
			i=1;
		}
		else {
			document.getElementById("foodItem_dislike_flow_text").disabled=true;
		}
		for(;i<jsonPatientObject.patients.length;i++) {
			encounterId=jsonPatientObject.patients[i].patient.encounterId;
			if(document.getElementById("chk_dislike_"+encounterId)) {
				document.getElementById("chk_dislike_"+encounterId).checked=false;
			}
		}		
	}
}

function check_FoodDislikes(encounterId,obj) {
	var jsonPatientObject=new Object();
	jsonPatientObject=parent.patientsObj;
	var obj;
	
	if(document.getElementById("chk_dislike_"+encounterId).checked==false) {
		if(dislikeJSONObj.items !=null) {
			if((parseInt(jsonPatientArr_Dislikes.length) ==1) && parseInt(dislikeJSONObj.items.length)!=0 ) {
				alert("Food Dislikes are selected. Atleast one Food Dislikes Check box should be selected");
				document.getElementById("chk_dislike_"+encounterId).checked=true;
				return;
			}
		}
	}	
	
	jsonPatientArr_Dislikes.splice(0,jsonPatientArr_Dislikes.length);
	document.getElementById("foodItem_dislike_flow_text").disabled=true;
	
	for(var i=0;i<jsonPatientObject.patients.length;i++) {
		encounterId=jsonPatientObject.patients[i].patient.encounterId;
		obj=document.getElementById("chk_dislike_"+encounterId);
		
		if(obj) {
			if(obj.checked==true) {
				jsonPatientArr_Dislikes.push({patient:jsonPatientObject.patients[i].patient});
				document.getElementById("foodItem_dislike_flow_text").disabled=false;
			}
			else {
				document.getElementById("chk_dislike_checkAll").checked=false;
			}			
		}
	}
	
}

function checkAll_Spl() {
	var jsonPatientObject=new Object();
	jsonPatientObject=parent.patientsObj;
	
	if(document.getElementById("chk_spl_checkAll").checked) {
		document.getElementById("splFoodItem_flow_text").disabled=false;
		jsonPatientArr_Spl.splice(0,jsonPatientArr_Spl.length);
		for(var i=0;i<jsonPatientObject.patients.length;i++) {
			jsonPatientArr_Spl.push({patient:jsonPatientObject.patients[i].patient});
			encounterId=jsonPatientObject.patients[i].patient.encounterId;
			if(document.getElementById("chk_spl_"+encounterId)) {
				document.getElementById("chk_spl_"+encounterId).checked=true;
			}
		}
	}
	else {
		var i=0;
		jsonPatientArr_Spl.splice(0,jsonPatientArr_Spl.length);
		if(splJSONObj && splJSONObj.items !=null && splJSONObj.items.length>0) {
			jsonPatientArr_Spl.push({patient:jsonPatientObject.patients[0].patient});
			i=1;
		}
		else {
			document.getElementById("splFoodItem_flow_text").disabled=true;
		}
		for(;i<jsonPatientObject.patients.length;i++) {
			encounterId=jsonPatientObject.patients[i].patient.encounterId;
			if(document.getElementById("chk_spl_"+encounterId)) {
				document.getElementById("chk_spl_"+encounterId).checked=false;
			}
		}		
	}
}

function check_SplFoodItems(encounterId,obj) {
	var jsonPatientObject=new Object();
	jsonPatientObject=parent.patientsObj;
	var obj;
	
	if(document.getElementById("chk_spl_"+encounterId).checked==false) {
		if(splJSONObj) {
			if(splJSONObj.items !=null) {
				if((parseInt(jsonPatientArr_Spl.length) ==1) && parseInt(splJSONObj.items.length)!=0 ) {
					alert("Special Food Items is selected. Atleast one Special Food Item Check box should be selected");
					document.getElementById("chk_spl_"+encounterId).checked=true;
					return;
				}
			}
		}
	}
	
	jsonPatientArr_Spl.splice(0,jsonPatientArr_Spl.length);
	
	document.getElementById("splFoodItem_flow_text").disabled=true;
	for(var i=0;i<jsonPatientObject.patients.length;i++) {
		encounterId=jsonPatientObject.patients[i].patient.encounterId;
		obj=document.getElementById("chk_spl_"+encounterId);
		
		if(obj) {
			if(obj.checked==true) {
				document.getElementById("splFoodItem_flow_text").disabled=false;
				jsonPatientArr_Spl.push({patient:jsonPatientObject.patients[i].patient});
			}
			else {
				document.getElementById("chk_spl_checkAll").checked=false;
			}
		}
	}
	
}

//Validating the date and time for NilByMouth
function validateDate(obj,val){
	var date=new Date();
	var error ="";
	var month=date.getMonth();
	var date1=date.getDate();
	var year=date.getYear();
	var hour=date.getHours();
	var minute=date.getMinutes();
	month+=1;
	if(date1<=9){
		date1="0"+""+date1;
	}
	if(month<=9){
		month="0"+""+month;
	}
	if(hour<=9){
		hour="0"+""+hour;
	}
	if(minute<=9){
		minute="0"+""+minute;
	}
	var sysDate=date1+"/"+month+"/"+year+" "+hour+":"+minute;
	
    if(val.length > 0) {
    	var date_array = val.split(" ");
    	
    	if(date_array.length==1) {
    		val=val+" "+hour+":"+minute;
    		obj.value=val;
    	}
    }
	if(isValidDateTime(val)){
		var flag =  compareFromDate(val,sysDate,'en',"DMYHM");
		if(flag == -1){
			error = "Nil By Mouth From Date Time should not be less than Current Date Time";
			parent.parent.parent.messageFrame.location.href ='../../eCommon/jsp/MstCodeError.jsp?err_num='+error;
		}else{
			parent.parent.parent.messageFrame.location.href ='../../eCommon/jsp/MstCodeError.jsp?err_num='+error;
		}
	}
	else
	{
		document.getElementById("from").value="";
	}

}

function validateToDate(obj,val){
	var error ="";
	var date=new Date();
	var month=date.getMonth();
	var date1=date.getDate();
	var year=date.getYear();
	var hour=date.getHours();
	var minute=date.getMinutes();
	month+=1;
	if(date1<=9){
		date1="0"+""+date1;
	}
	if(month<=9){
		month="0"+""+month;
	}
	if(hour<=9){
		hour="0"+""+hour;
	}
	if(minute<=9){
		minute="0"+""+minute;
	}
	
    if(val.length > 0) {
    	var date_array = val.split(" ");
    	
    	if(date_array.length==1) {
    		val=val+" "+hour+":"+minute;
    		obj.value=val;
    	}
    }
    
	var fromDate=document.getElementById("from").value;
	if(isValidDateTime(val)){
		var flag =  compareToDates(val,fromDate,'en',"DMYHM");
		if(flag == -1){
			var error = "Nil By Mouth To date should be greater than or equal to From Date";
			parent.parent.parent.messageFrame.location.href ='../../eCommon/jsp/MstCodeError.jsp?err_num='+error;
		}else{
			parent.parent.parent.messageFrame.location.href ='../../eCommon/jsp/MstCodeError.jsp?err_num='+error;
		}
	}
	else
	{
		document.getElementById("to").value="";
	}
}

function isValidDateTime(obj){
	var flag=true;
	if(obj!=""){
		var str=obj;
		var dateValArr = str.split(' ');
		if (dateValArr[0] =="" || dateValArr[1]=="")
		{
			alert(getMessage('INVALID_DATE_FMT','SM'));
			flag=false;
		}
		else
		{
			if(checkDate1(dateValArr[0])==true && checkTime(dateValArr[1])==true)
			{flag=true;}
			else
			{flag=false;}
		}
	}
	return flag;
}
function checkDate1(objval)
{
	var flag=true;
	var RE_NUM =  /^\/?\d+$/;
	var str_date = objval;
	var arr_date = str_date.split('/');
	if (arr_date.length != 3)
	{
		alert(getMessage('INVALID_DATE_FMT','SM'));
		flag=false;
	}
	else
	{
		if (!arr_date[0]) flag=false;
		if (!RE_NUM.exec(arr_date[0])) flag=false;
		if (!arr_date[1]) flag=false;
		if (!RE_NUM.exec(arr_date[1])) flag=false;
		if (!arr_date[2]) flag=false;
		if (arr_date[2].length!=4) flag=false;
		var dt_date = new Date();
		dt_date.setDate(1);
		if (arr_date[1] < 1 || arr_date[1] > 12) flag=false;
		dt_date.setMonth(arr_date[1]-1);
		var dt_numdays = new Date(arr_date[2], arr_date[1], 0);
		dt_date.setDate(arr_date[0]);
		if (dt_date.getMonth() != (arr_date[1]-1)) flag=false;
		var alphaFilter =/^[0-9]+$/;   
	   	if (!(alphaFilter.test(arr_date[2])))  flag=false;

		if (flag==false){
			alert(getMessage('INVALID_DATE_FMT','SM'));
		}
	}

	return flag;
}
function checkTime(timeBox){
	if(timeBox=="" || timeBox==null || typeof timeBox=='undefined' )
	{
		alert(getMessage('INVALID_DATE_FMT','SM'));
		return false;
	}else
	{
		if(parseInt(timeBox.length)<=parseInt(5))
		{
		   time=timeBox;
		   time1=time.split(':')
		   if (!/\d{2}:\d{2}/.test(time)){
			   alert(getMessage('INVALID_DATE_FMT','SM'));
			   return false;
		   }
		   else if (time1[0] >23 || time1[1]>59) {
			   alert(getMessage('INVALID_DATE_FMT','SM'));
			   return false;
		   }
		   else return true;
		}
	}
}
function showCalForNilByMouth(id, format, showsTime, showsOtherMonths, name) {
	fmt = format;
	{
		calend = format;
		if (showsTime) {
			time = true;
		} else {
			time = false;
		}
		var cal;
		currentDateElement = document.getElementById(id);
		cal = new PopupWindow();
		cal.offsetX = 50;
		cal.offsetY = 50;
		cal.setSize(250, 200);
		cal.autoHide();
		cal.setUrl("../../framework/jsp/Calendar.jsp");
		cal.refresh();
		cal.showPopup(name);
		return false;
	}
}
function compareToDates(fromdate,todate,locale,format) {
	 var fromarray; var toarray;
		var fromdate = convertDate(fromdate,format,locale,locale);
		var todate = convertDate(todate,format,locale,locale);
		var retVal=1;
	    if(fromdate.length > 0 && todate.length > 0 ) {
	    	var from_date_array = fromdate.split(" ");
			var from_date = from_date_array[0];
			var from_time = from_date_array[1];

			var to_date_array = todate.split(" ");
			var to_date = to_date_array[0];
			var to_time = to_date_array[1];

			var fromdatearray = from_date.split("/");
			var todatearray = to_date.split("/");
			if(format == "DMY") {
				var fromdt = new Date(fromdatearray[2],fromdatearray[1],fromdatearray[0]);
				var todt = new Date(todatearray[2],todatearray[1],todatearray[0]);
			}
			else{
				var fromtimearray = from_time.split(":");
				var totimearray = to_time.split(":");

				var fromdt = new Date(fromdatearray[2],fromdatearray[1],fromdatearray[0],fromtimearray[0],fromtimearray[1]);
	            var todt = new Date(todatearray[2],todatearray[1],todatearray[0],totimearray[0],totimearray[1]);
			}
	        if(Date.parse(fromdt) < Date.parse(todt)) {
	        	retVal=-1;
	        }       
	        else if(Date.parse(todt) > Date.parse(fromdt)){
	        	retVal=1;
	        }
	    }
		return retVal;
}
function updateNewFlag() {
	var obj=new Object();
	obj=parent.patientsObj;
	
	for(var i=0;i<obj.patients.length;i++) {
		for(var iter=0;iter<newOrderPatientIds.length;iter++) {
			if(newOrderPatientIds[iter] == obj.patients[i].patient.patientId ) {
				obj.patients.patient.newFlag="Y";
				break;
			}
		}
	}
}

/* Fix for Incident 48246 */

function compareFromDate(fromdate,todate,locale,format) {
    var fromarray; var toarray;
	var fromdate = convertDate(fromdate,format,locale,locale);
	var todate = convertDate(todate,format,locale,locale);
	var retVal=1;
    if(fromdate.length > 0 && todate.length > 0 ) {
    	var from_date_array = fromdate.split(" ");
		var from_date = from_date_array[0];
		var from_time = from_date_array[1];

		var to_date_array = todate.split(" ");
		var to_date = to_date_array[0];
		var to_time = to_date_array[1];

		var fromdatearray = from_date.split("/");
		var todatearray = to_date.split("/");
		if(format == "DMY") {
			var fromdt = new Date(fromdatearray[2],fromdatearray[1],fromdatearray[0]);
			var todt = new Date(todatearray[2],todatearray[1],todatearray[0]);
		}
		else{
			var fromtimearray = from_time.split(":");
			var totimearray = to_time.split(":");

			var fromdt = new Date(fromdatearray[2],fromdatearray[1],fromdatearray[0],fromtimearray[0],fromtimearray[1]);
            var todt = new Date(todatearray[2],todatearray[1],todatearray[0],totimearray[0],totimearray[1]);
		}
        if(Date.parse(fromdate) < Date.parse(todate)) {
        	retVal=-1;
        }
        else if(Date.parse(todt) == Date.parse(fromdt)) {
        	retVal=0;
        }
    }
	return retVal;
}

//055251 Start
function closeWindow()
{
//CRF-428
 if(exclusionFlag==true) {
		if(window.confirm("The Changes to Meal Exclusions will not be Saved. Are you sure you wish to continue?"))
		{
			closeWindowFlag = true;
			top.close();
		}
	}
	else
		top.close();
	//window.close();
 //CRF-428
}
//055251 End

//MMOH-CRF-427
function grayOutCalendar(fieldid,p_maxdate,locale){
		var dt=new Date();
		var c_date=dt.getDate();
		var c_month=dt.getMonth();
		var c_year=dt.getFullYear();
		if(locale=="th"){
			c_year=c_year+543;
		}
		var setdate=new Date(c_year,c_month,c_date);
		var max_date=addDays(setdate,p_maxdate);
		$.datepicker.setDefaults($.extend({showMonthAfterYear: false}, $.datepicker.regional[locale]));
		$("#"+fieldid).datepicker({
		dateFormat:'dd/mm/yy',
		minDate:setdate ,
		maxDate:max_date,
		showOn: 'image',		
		changeYear:true
		});
			$('#'+fieldid).focusin(function(){
			$('#'+fieldid).datepicker('widget').css({top: '25%',left: '50%'});
		});
		$('#'+fieldid).datepicker('show');
 

}

function grayOutCalendarDateTime(fieldid,p_maxdate,locale){
	var dt=new Date();
	var c_date=dt.getDate();
	var c_month=dt.getMonth();
	var c_year=dt.getFullYear();
	if(locale=="th"){
	c_year=c_year+543;
	}
	var setdate=new Date(c_year,c_month,c_date);
	var max_date=addDays(setdate,p_maxdate);	
	$.datepicker.setDefaults($.extend({showMonthAfterYear: false}, $.datepicker.regional[locale]));
	$.timepicker.setDefaults($.datepicker.regional[locale]);
	$("#"+fieldid).datetimepicker({
	dateFormat:'dd/mm/yy',
	minDate:setdate ,
	maxDate:max_date,
	showOn: 'image',
	//maxDate:100,
	changeYear:true
	});
	
	$('#'+fieldid).focusin(function(){
    $('#'+fieldid).datepicker('widget').css({top: '25%',left: '50%'});
	});
	$('#'+fieldid).datepicker('show');

}

//MMOH-CRF-427
function grayOutCalendarValidation(p_selecteddate,p_maxdate){
	var maxdate=p_maxdate;
	var date = addDays(new Date(), p_maxdate);
	var date1=date.getDate();
	var month=date.getMonth();
	var year=date.getFullYear();
	var locale=document.getElementById("languageId").value;
	var selecteddate=p_selecteddate;
	month+=1;
		if(date1<=9){
				date1="0"+""+date1;
			    }
		if(month<=9){
				month="0"+""+month;
			    }	
	var futDate=date1 + "/" + month + "/" + year;
	selecteddate = convertDate(selecteddate,'DMY',locale,'en');
	var flag = compareDate(futDate,selecteddate);
	if(flag==-1){		
			return false;
		   }
	else{
		var sysdate=getCurrentDate("DMH",'en');
		flag=compareDate(selecteddate,sysdate);
		if(flag==-1){
			return false;
		}else{
		return true;
		}
	}
}

function grayOutDateTimeCalendarValidation(p_selecteddate,p_maxdate){
	var maxdate=p_maxdate;
	var date = addDays(new Date(), p_maxdate);
	var date1=date.getDate();
	var month=date.getMonth();
	var year=date.getFullYear();
	var hour=date.getHours();
	var minute=date.getMinutes();
	var locale=document.getElementById("languageId").value;
	var selecteddate=p_selecteddate;
	
	month+=1;
		if(date1<=9){
				date1="0"+""+date1;
			    }
		if(month<=9){
				month="0"+""+month;
			    }	
	var futDate=date1 + "/" + month + "/" + year+" "+hour+":"+minute;
	selecteddate = convertDate(selecteddate,'DMYHM',locale,'en');
	//alert("selecteddate :"+selecteddate);
	var flag = compareDate(futDate,selecteddate);
	if(flag==-1){		
			return false;
		   }
	else{
		var sysdate=getCurrentDate("DMYHM",'en');
		flag=compareDate(selecteddate,sysdate);
		if(flag==-1){
			return false;
		}else{
		return true;
		}
	}
}

function addDays(theDate, days) {
    return new Date(theDate.getTime() + days*24*60*60*1000);
    
}

function changeDate(date){
	//var date= new Date(theDate.getTime() + days*24*60*60*1000);
	var date1=date.getDate();
	var month=date.getMonth();
	var year=date.getFullYear();
	var locale=document.getElementById("languageId").value;
	month+=1;
		if(date1<=9){
				date1="0"+""+date1;
			    }
		if(month<=9){
				month="0"+""+month;
			    }	
	var futDate=date1 + "/" + month + "/" + year;
	futDate = convertDate(futDate,'DMY','en',locale);
	return futDate;
}

//MMOH-CRF-427

//Changes for MMOH-CRF-0428 starts
function fetchMealTypeOptionsWithTime() {
	var language_Id =document.getElementById("languageId").value;
	var dType =document.getElementById("dietType").value;
	var mClass = document.getElementById("mealClass").value;
	var kCode =document.getElementById("kitchenCode").value;
	var dietCategory=document.getElementById("dietCategory").value;
	var mode = "mealTypeListWithTime";
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest() ;
	var xmlStr ="<root></root>";
	param="&language_Id="+language_Id+"&dType="+dType+"&mClass="+mClass+"&kCode="+kCode+"&diet_Category="+dietCategory+"&ageGroupArr="+arr+"&mode="+mode;
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST", "../../servlet/eDS.PlaceDietOrderServlet?"+param,false);
	xmlHttp.send(xmlDoc);

	fetchedMealTypesWithTime = JSON.parse(xmlHttp.responseText);
}

async function openExclusionsWindow(obj) {
	var encounterId = document.getElementById("encounterId").value;
	//var patientClass = document.getElementById("patientClass").value;
	var profileSL= document.getElementById("profileSL").value;
	var facilityId=document.getElementById("addedFacilityId").value;
	var restrict_date_inpatients_yn=document.getElementById("restrict_date_inpatients_yn").value;
	var maximum_days_allowed=document.getElementById("maximum_days_allowed").value;
	var order_from_date=document.getElementById("dateFrom").value;
	var order_to_date=document.getElementById("dateTo").value;
	//var profileFlag=$('#profileFlag').val();
	var dialogUrl1 = "../../eDS/jsp/MealExclusions.jsp?&encounterId="+encounterId+"&profileSL="+profileSL+"&fetchedMealTypesWithTime="+fetchedMealTypesWithTime+"&restrict_date_inpatients_yn="+restrict_date_inpatients_yn+"&maximum_days_allowed="+maximum_days_allowed+"&order_from_date="+order_from_date+"&order_to_date="+order_to_date;
	var obj={};
	obj.mealTypes=fetchedMealTypesWithTime;
	obj.excludedMealTypes= excludedMeals;
	var dialogArguments = obj;
	var dialogFeatures = "dialogHeight:35;dialogWidth:50;status:no;scroll:no";
	//excludedMeals = window.showModalDialog(dialogUrl1, dialogArguments,dialogFeatures);
	var test = await window.showModalDialog(dialogUrl1, dialogArguments,dialogFeatures);
	manualexcludedMeals=test.excludedMealTypes;//428
	excludedMeals=test.excludedMealTypes;
	if(exclusionFlag==false)exclusionFlag=test.changedFlag;
	updateExclusionsPane();
	/*if (!(JSON.stringify(obj.excludedMealTypes) === JSON.stringify(test))) {
		exclusionFlag=true;
		alert("true"+dfsf);
	}*/
}
function addAutomaticExclusions() {

	var fromDate=$("#dateFrom").val();
	var today=moment().format("DD/MM/YYYY");
	automatic_excluded_meal_types=new Array();
	if (fromDate==today) {

	 $.each(fetchedMealTypesWithTime,function(index) {
		 	var mealTypeCode=this.Meal_Code;
			var irreg_end_time=this.Irregular_End_Time;
			var next_meal_start_time=this.Next_Meal_Start_Time;
			var endTime=irreg_end_time;
			if (endTime=="") endTime=next_meal_start_time;
			var currentTimeObj=moment();
			var endTimeObj=moment(endTime,'HH:mm');
			var duration = moment.duration(endTimeObj.diff(currentTimeObj));
			var hours = duration.asHours();
			if(hours<0) addMealTypeToExclusion(today,mealTypeCode);
	 });
	}
}
function addMealTypeToExclusion(today,mealTypeCode) {
	if(excludedMeals[today]==null){
		excludedMeals[today]={};
		excludedMeals[today][mealTypeCode]="Y";
		automatic_excluded_meal_types.push(mealTypeCode);
	}
	else  {
		if(excludedMeals[today][mealTypeCode]==null) {
			excludedMeals[today][mealTypeCode]="Y";
			automatic_excluded_meal_types.push(mealTypeCode);
		}
		if(excludedMeals[today][mealTypeCode]=="N") {
			excludedMeals[today][mealTypeCode]="Y";
			automatic_excluded_meal_types.push(mealTypeCode);
		}
	}
}
getMealTypeDesc = function (mealTypeCode) {
	var desc="";
	$.each(fetchedMealTypesWithTime,function(index) {
	if(this.Meal_Code==mealTypeCode){
		desc=this.Short_Desc;
	}
});
return desc;
}
function updateExclusionsPane() {
	var tbody_exclusions = document.all("exclusions");
	while (tbody_exclusions.rows.length > 0) {
		tbody_exclusions.deleteRow(0);
	}
	var countRow = tbody_exclusions.rows.length;
	var row_ind = 0;
	$.each(excludedMeals,function(key,value) {
		var obj=this;
		var date=key;
		$.each(obj,function(mealTypeCode) {
			if(obj[mealTypeCode]=='Y') {
				var newRow = tbody_exclusions.insertRow(row_ind);
				var newCellitemType = newRow.insertCell(newRow.cells.length);
				var newCellDate = newRow.insertCell(newRow.cells.length);
				newCellDate.className = "Data";
				newCellDate.appendChild(document.createTextNode(date));
				var newCellMealType = newRow.insertCell(newRow.cells.length);
				newCellMealType.appendChild(document.createTextNode(getMealTypeDesc(mealTypeCode)));
			}
		});
	});
}
function checkExclusions(obj) {
	var temp=obj.oldvalue;
	var flag=jQuery.isEmptyObject(excludedMeals);

	if(obj.oldvalue!=null && (obj.oldvalue!=obj.value)) {
		if(flag==false) {
			if(window.confirm("The Changes to Meal Exclusions will be discarded. Are you sure you wish to continue?"))
			{
				obj.oldvalue=obj.value;
				excludedMeals={};
				exclusionFlag=false;
				updateExclusionsPane();
			}
			else obj.value=temp;
		}
		else obj.oldvalue=obj.value;
	}
	else obj.oldvalue=obj.value;
}
/*function checkExclusions(obj) {
	var temp=obj.oldvalue;
	if(obj.oldvalue!=obj.value) {
		if(exclusionFlag==true) {
			if(window.confirm("The Changes to Meal Exclusions will be discarded. Are you sure you wish to continue?"))
			{
				obj.oldvalue=obj.value;
				excludedMeals={};
				exclusionFlag=false;
				updateExclusionsPane();
			}
			else obj.value=temp;
		}
		else obj.oldvalue=obj.value;
	}
	else obj.oldvalue=obj.value;
}*/
function checkExclusions_select(obj) {
	document.getElementById("diettype_auto").value="";//Added Against ML-MMOH-CRF-0674
	var temp=obj.oldvalue;
	var flag=jQuery.isEmptyObject(excludedMeals);
	if(flag==false) {
		if(window.confirm("The Changes to Meal Exclusions will be discarded. Are you sure you wish to continue?"))
		{
			obj.oldvalue=obj.value;
			excludedMeals={};
			exclusionFlag=false;
			updateExclusionsPane();
		}
		else obj.value=temp;
	}
	else obj.oldvalue=obj.value;
}
//ML-MMOH-CRF-409 starts
function checkTimeRange(obj1,obj2,obj3){

	var dt=new Date();
	var c_date=dt.getDate();
	var c_month=dt.getMonth();
	var c_year=dt.getFullYear();
	var c_hour=dt.getHours(); 
	var c_min=dt.getMinutes();
	
	var dateFrom=obj3;	
	
	var dateFromArr=dateFrom.split("/");
	var f_date=dateFromArr[0];
	var f_month=dateFromArr[1]-1;
	var f_year=dateFromArr[2];
	
	var s1=obj1.split(":");
	var s2=obj2.split(":");	
	
	var setdate=new Date(f_year,f_month,f_date,c_hour,c_min);
	
	var start_time=new Date(c_year,c_month,c_date,s1[0],s1[1]);
	var end_time=new Date(c_year,c_month,c_date,s2[0],s2[1]);
		
	var range  = moment.range(start_time, end_time);	

	var flag=range.contains(setdate); // true
	
	return flag;
}
//ML-MMOH-CRF-409 ENDS
//428
function checkIfAllMealTypesExcluded() {
	var flag=false;
	var fromDate=document.getElementById("dateFrom").value;
	var toDate=document.getElementById("dateTo").value;

	var fromDate_moment = moment(fromDate,'DD/MM/YYYY');
	var toDate_moment = moment(toDate,'DD/MM/YYYY');
	var diffInDays = parseInt(toDate_moment.diff(fromDate_moment, 'days'))+1;
	var count_excludedMeals=getNumberOfExcludedMeals();
	var maxMealsForOrder=parseInt(diffInDays)*parseInt(fetchedMealTypesWithTime.length);

	if(parseInt(count_excludedMeals)==maxMealsForOrder) flag=true; 
	
	return flag;
	}
function getNumberOfExcludedMeals() {
	var count=0;
	$.each(excludedMeals,function(key,value) {
		var obj=this;
		$.each(obj,function(iter) {
			if(obj[iter]=='Y') count++;
		});
	});
	return count;
}	
function checkAutoExclusions() {
	var today=moment().format("DD/MM/YYYY");
	var flag=false;
	var count=0;
	if(excludedMeals[today]==null)return false;
	else {
		var obj=excludedMeals[today];
		$.each(obj,function(iter) {
			if(obj[iter]=='Y') count++;
		});
	}
	if(parseInt(count)==parseInt(fetchedMealTypesWithTime.length)) flag=true;
	return flag;
	}
//428
//CRF-410 Starts
function checkFullNBMProfileOverLap(fromDate,dateTo,addedFacilityId,encounterId){
	var result=false;
	var mode = "getNBMProfileOverLap";
	var xmlDoc="" ;
	var xmlHttp = new XMLHttpRequest() ;
	var xmlStr ="<root></root>";
	var paramTer="&encounterId="+encounterId
	+"&addedFacilityId="+addedFacilityId
	+"&fromDate="+fromDate
	+"&dateTo="+dateTo
	+"&mode="+mode;
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	
	xmlHttp.open("POST", "../../servlet/eDS.PlaceBulkDietOrderServlet?"+paramTer,false);
	xmlHttp.send(xmlDoc);
	var retVal = localTrimString(xmlHttp.responseText);
	var retVal = xmlHttp.responseText;
	
	var jsonObjResponse=eval('(' + retVal + ')');
	var NBMOverLapProfileList=new Array();
	NBMOverLapProfileList = jsonObjResponse.NBMOverLapProfileList;
	var count=0;
	var overlapencounter_id="";
	var cancel_profile="";
	var cancel_dates="";	
	if(NBMOverLapProfileList!=null && NBMOverLapProfileList!="undefined" && NBMOverLapProfileList!=""){
	$.each( NBMOverLapProfileList, function( key, value ) {
			++count;
			overlapencounter_id+=NBMOverLapProfileList[key].encounter_id+"\n";			
		});	

		if(count>0){
			result=true;
		}
		if(result==true){
				alert("The following encounter id \n"+overlapencounter_id+"Patient is in NBM for the requested date, Please change the Date.");			
		}
		}		
		return result;	
}	
//CRF-410 Ends
//Added Against ML-MMOH-CRF-0672 Starts Here
function losToolTip()
{
	var alacarta_message=getMessage("DS_ALA_CARTE_ORDER","DS");
	var tab_dat  = "<table id ='tooltiptable1' cellpadding='3' cellspacing=0 border='0' class='BOX' width='100%' height='100%' align='center'>";
	tab_dat     += "<tr>"
	tab_dat     += "<th   nowrap > <B>"+alacarta_message+ " </B> </a> </th>"
	tab_dat     += "</tr> ";
	tab_dat     += "</table> ";
 	return tab_dat;
 }
//Added Against ML-MMOH-CRF-0672 Ends Here


//Added Against ML-MMOH-CRF-0674 Starts Here
function diettype_Autocomplete()
{
	document.getElementById("diettype_auto").value=""; 
	var selText="";
	var theKeyCode = window.event.keyCode;
	if(theKeyCode != 37 && theKeyCode != 38 && theKeyCode != 39 && theKeyCode != 40 && theKeyCode != 13 && theKeyCode != 8)
	{
		document.getElementById("auto_flag").value="true";
		selText += String.fromCharCode(theKeyCode);
		document.getElementById("diettype_auto").value=selText;
		fetchDietType(document.getElementById("dietCategory").value);			 
	}
}

function Select()
{
	var auto_flag=document.getElementById("auto_flag").value;
	var myDropDown = document.getElementById("dietType");
	var str = myDropDown.options[myDropDown.selectedIndex].value;
	   
		if(auto_flag == "true" && str!="") 
		{	myDropDown.size = 1;
			document.getElementById("auto_flag").value="false2";
			document.getElementById("diettype_auto").value="";
		}
		else if(auto_flag == "true" && str=="")
		{			
			myDropDown.size = 1;  
			document.getElementById("diettype_auto").value="";
			document.getElementById("auto_flag").value="false";
			fetchDietType(document.getElementById("dietCategory").value);			 
				
		}
	else if(auto_flag == "false2" && str=="")
		{
			document.getElementById("diettype_auto").value="";
			document.getElementById("auto_flag").value="false";
			fetchDietType(document.getElementById("dietCategory").value);			 
		}		
}  

//Added Against ML-MMOH-CRF-0674 Ends Here

